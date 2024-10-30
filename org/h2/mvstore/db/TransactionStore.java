/*      */ package org.h2.mvstore.db;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.BitSet;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import org.h2.mvstore.Cursor;
/*      */ import org.h2.mvstore.DataUtils;
/*      */ import org.h2.mvstore.MVMap;
/*      */ import org.h2.mvstore.MVStore;
/*      */ import org.h2.mvstore.WriteBuffer;
/*      */ import org.h2.mvstore.type.DataType;
/*      */ import org.h2.mvstore.type.ObjectDataType;
/*      */ import org.h2.util.New;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class TransactionStore
/*      */ {
/*      */   final MVStore store;
/*      */   final MVMap<Integer, Object[]> preparedTransactions;
/*      */   final MVMap<Long, Object[]> undoLog;
/*   56 */   private HashMap<Integer, MVMap<Object, VersionedValue>> maps = New.hashMap();
/*      */ 
/*      */   
/*      */   private final DataType dataType;
/*      */   
/*   61 */   private final BitSet openTransactions = new BitSet();
/*      */   
/*      */   private boolean init;
/*      */   
/*   65 */   private int maxTransactionId = 65535;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int nextTempMapId;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TransactionStore(MVStore paramMVStore) {
/*   78 */     this(paramMVStore, (DataType)new ObjectDataType());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TransactionStore(MVStore paramMVStore, DataType paramDataType) {
/*   88 */     this.store = paramMVStore;
/*   89 */     this.dataType = paramDataType;
/*   90 */     this.preparedTransactions = paramMVStore.openMap("openTransactions", (MVMap.MapBuilder)new MVMap.Builder());
/*      */     
/*   92 */     VersionedValueType versionedValueType = new VersionedValueType(paramDataType);
/*   93 */     ArrayType arrayType = new ArrayType(new DataType[] { (DataType)new ObjectDataType(), paramDataType, versionedValueType });
/*      */ 
/*      */     
/*   96 */     MVMap.Builder builder = (new MVMap.Builder()).valueType(arrayType);
/*      */ 
/*      */     
/*   99 */     this.undoLog = paramMVStore.openMap("undoLog", (MVMap.MapBuilder)builder);
/*  100 */     if (this.undoLog.getValueType() != arrayType) {
/*  101 */       throw DataUtils.newIllegalStateException(100, "Undo map open with a different value type", new Object[0]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void init() {
/*  113 */     this.init = true;
/*      */     
/*  115 */     for (String str : this.store.getMapNames()) {
/*  116 */       if (str.startsWith("temp.")) {
/*  117 */         MVMap<Object, Integer> mVMap = openTempMap(str);
/*  118 */         this.store.removeMap(mVMap);
/*      */       } 
/*      */     } 
/*  121 */     synchronized (this.undoLog) {
/*  122 */       if (this.undoLog.size() > 0) {
/*  123 */         for (Long long_ : this.undoLog.keySet()) {
/*  124 */           int i = getTransactionId(long_.longValue());
/*  125 */           this.openTransactions.set(i);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setMaxTransactionId(int paramInt) {
/*  139 */     this.maxTransactionId = paramInt;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static long getOperationId(int paramInt, long paramLong) {
/*  150 */     DataUtils.checkArgument((paramInt >= 0 && paramInt < 16777216), "Transaction id out of range: {0}", new Object[] { Integer.valueOf(paramInt) });
/*      */     
/*  152 */     DataUtils.checkArgument((paramLong >= 0L && paramLong < 1099511627776L), "Transaction log id out of range: {0}", new Object[] { Long.valueOf(paramLong) });
/*      */     
/*  154 */     return paramInt << 40L | paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static int getTransactionId(long paramLong) {
/*  164 */     return (int)(paramLong >>> 40L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static long getLogId(long paramLong) {
/*  174 */     return paramLong & 0xFFFFFFFFFFL;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<Transaction> getOpenTransactions() {
/*  183 */     synchronized (this.undoLog) {
/*  184 */       ArrayList<Transaction> arrayList = New.arrayList();
/*  185 */       Long long_ = (Long)this.undoLog.firstKey();
/*  186 */       while (long_ != null) {
/*  187 */         int j; String str; int i = getTransactionId(long_.longValue());
/*  188 */         long_ = (Long)this.undoLog.lowerKey(Long.valueOf(getOperationId(i + 1, 0L)));
/*  189 */         long l = getLogId(long_.longValue()) + 1L;
/*  190 */         Object[] arrayOfObject = (Object[])this.preparedTransactions.get(Integer.valueOf(i));
/*      */ 
/*      */         
/*  193 */         if (arrayOfObject == null) {
/*  194 */           if (this.undoLog.containsKey(Long.valueOf(getOperationId(i, 0L)))) {
/*  195 */             j = 1;
/*      */           } else {
/*  197 */             j = 3;
/*      */           } 
/*  199 */           str = null;
/*      */         } else {
/*  201 */           j = ((Integer)arrayOfObject[0]).intValue();
/*  202 */           str = (String)arrayOfObject[1];
/*      */         } 
/*  204 */         Transaction transaction = new Transaction(this, i, j, str, l);
/*      */         
/*  206 */         arrayList.add(transaction);
/*  207 */         long_ = (Long)this.undoLog.ceilingKey(Long.valueOf(getOperationId(i + 1, 0L)));
/*      */       } 
/*  209 */       return arrayList;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void close() {
/*  217 */     this.store.commit();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized Transaction begin() {
/*  229 */     if (!this.init) {
/*  230 */       throw DataUtils.newIllegalStateException(103, "Not initialized", new Object[0]);
/*      */     }
/*      */ 
/*      */     
/*  234 */     int i = this.openTransactions.nextClearBit(1);
/*  235 */     if (i > this.maxTransactionId) {
/*  236 */       throw DataUtils.newIllegalStateException(102, "There are {0} open transactions", new Object[] { Integer.valueOf(i - 1) });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  241 */     this.openTransactions.set(i);
/*  242 */     boolean bool = true;
/*  243 */     return new Transaction(this, i, bool, null, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized void storeTransaction(Transaction paramTransaction) {
/*  252 */     if (paramTransaction.getStatus() == 2 || paramTransaction.getName() != null) {
/*      */       
/*  254 */       Object[] arrayOfObject = { Integer.valueOf(paramTransaction.getStatus()), paramTransaction.getName() };
/*  255 */       this.preparedTransactions.put(Integer.valueOf(paramTransaction.getId()), arrayOfObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void log(Transaction paramTransaction, long paramLong, int paramInt, Object paramObject1, Object paramObject2) {
/*  270 */     Long long_ = Long.valueOf(getOperationId(paramTransaction.getId(), paramLong));
/*  271 */     Object[] arrayOfObject = { Integer.valueOf(paramInt), paramObject1, paramObject2 };
/*  272 */     synchronized (this.undoLog) {
/*  273 */       if (paramLong == 0L && 
/*  274 */         this.undoLog.containsKey(long_)) {
/*  275 */         throw DataUtils.newIllegalStateException(102, "An old transaction with the same id is still open: {0}", new Object[] { Integer.valueOf(paramTransaction.getId()) });
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  282 */       this.undoLog.put(long_, arrayOfObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void logUndo(Transaction paramTransaction, long paramLong) {
/*  293 */     Long long_ = Long.valueOf(getOperationId(paramTransaction.getId(), paramLong));
/*  294 */     synchronized (this.undoLog) {
/*  295 */       Object[] arrayOfObject = (Object[])this.undoLog.remove(long_);
/*  296 */       if (arrayOfObject == null) {
/*  297 */         throw DataUtils.newIllegalStateException(103, "Transaction {0} was concurrently rolled back", new Object[] { Integer.valueOf(paramTransaction.getId()) });
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized <K, V> void removeMap(TransactionMap<K, V> paramTransactionMap) {
/*  313 */     this.maps.remove(Integer.valueOf(paramTransactionMap.mapId));
/*  314 */     this.store.removeMap(paramTransactionMap.map);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void commit(Transaction paramTransaction, long paramLong) {
/*  324 */     if (this.store.isClosed()) {
/*      */       return;
/*      */     }
/*      */     
/*  328 */     synchronized (this.undoLog) {
/*  329 */       paramTransaction.setStatus(3); long l;
/*  330 */       for (l = 0L; l < paramLong; l++) {
/*  331 */         Long long_ = Long.valueOf(getOperationId(paramTransaction.getId(), l));
/*  332 */         Object[] arrayOfObject = (Object[])this.undoLog.get(long_);
/*  333 */         if (arrayOfObject == null) {
/*      */           
/*  335 */           long_ = (Long)this.undoLog.ceilingKey(long_);
/*  336 */           if (long_ == null || getTransactionId(long_.longValue()) != paramTransaction.getId()) {
/*      */             break;
/*      */           }
/*      */           
/*  340 */           l = getLogId(long_.longValue()) - 1L;
/*      */         } else {
/*      */           
/*  343 */           int i = ((Integer)arrayOfObject[0]).intValue();
/*  344 */           MVMap<Object, VersionedValue> mVMap = openMap(i);
/*  345 */           if (mVMap != null) {
/*      */ 
/*      */             
/*  348 */             Object object = arrayOfObject[1];
/*  349 */             VersionedValue versionedValue = (VersionedValue)mVMap.get(object);
/*  350 */             if (versionedValue != null)
/*      */             {
/*  352 */               if (versionedValue.value == null) {
/*      */                 
/*  354 */                 mVMap.remove(object);
/*      */               } else {
/*  356 */                 VersionedValue versionedValue1 = new VersionedValue();
/*  357 */                 versionedValue1.value = versionedValue.value;
/*  358 */                 mVMap.put(object, versionedValue1);
/*      */               }  } 
/*      */           } 
/*  361 */           this.undoLog.remove(long_);
/*      */         } 
/*      */       } 
/*  364 */     }  endTransaction(paramTransaction);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized <K> MVMap<K, VersionedValue> openMap(String paramString, DataType paramDataType1, DataType paramDataType2) {
/*      */     ObjectDataType objectDataType1, objectDataType2;
/*  378 */     if (paramDataType1 == null) {
/*  379 */       objectDataType1 = new ObjectDataType();
/*      */     }
/*  381 */     if (paramDataType2 == null) {
/*  382 */       objectDataType2 = new ObjectDataType();
/*      */     }
/*  384 */     VersionedValueType versionedValueType = new VersionedValueType((DataType)objectDataType2);
/*      */     
/*  386 */     MVMap.Builder builder = (new MVMap.Builder()).keyType((DataType)objectDataType1).valueType(versionedValueType);
/*      */ 
/*      */     
/*  389 */     MVMap<Object, VersionedValue> mVMap1 = this.store.openMap(paramString, (MVMap.MapBuilder)builder);
/*      */     
/*  391 */     MVMap<Object, VersionedValue> mVMap2 = mVMap1;
/*  392 */     this.maps.put(Integer.valueOf(mVMap1.getId()), mVMap2);
/*  393 */     return (MVMap)mVMap1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized MVMap<Object, VersionedValue> openMap(int paramInt) {
/*  403 */     MVMap<Object, VersionedValue> mVMap = this.maps.get(Integer.valueOf(paramInt));
/*  404 */     if (mVMap != null) {
/*  405 */       return mVMap;
/*      */     }
/*  407 */     String str = this.store.getMapName(paramInt);
/*  408 */     if (str == null)
/*      */     {
/*  410 */       return null;
/*      */     }
/*  412 */     VersionedValueType versionedValueType = new VersionedValueType(this.dataType);
/*  413 */     MVMap.Builder builder = (new MVMap.Builder()).keyType(this.dataType).valueType(versionedValueType);
/*      */ 
/*      */     
/*  416 */     mVMap = this.store.openMap(str, (MVMap.MapBuilder)builder);
/*  417 */     this.maps.put(Integer.valueOf(paramInt), mVMap);
/*  418 */     return mVMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized MVMap<Object, Integer> createTempMap() {
/*  427 */     String str = "temp." + this.nextTempMapId++;
/*  428 */     return openTempMap(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   MVMap<Object, Integer> openTempMap(String paramString) {
/*  438 */     MVMap.Builder builder = (new MVMap.Builder()).keyType(this.dataType);
/*      */ 
/*      */     
/*  441 */     return this.store.openMap(paramString, (MVMap.MapBuilder)builder);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   synchronized void endTransaction(Transaction paramTransaction) {
/*  450 */     if (paramTransaction.getStatus() == 2) {
/*  451 */       this.preparedTransactions.remove(Integer.valueOf(paramTransaction.getId()));
/*      */     }
/*  453 */     paramTransaction.setStatus(0);
/*  454 */     this.openTransactions.clear(paramTransaction.transactionId);
/*  455 */     if (this.store.getAutoCommitDelay() == 0) {
/*  456 */       this.store.commit();
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  462 */     if (this.undoLog.isEmpty()) {
/*  463 */       int i = this.store.getUnsavedMemory();
/*  464 */       int j = this.store.getAutoCommitMemory();
/*      */       
/*  466 */       if (i * 4 > j * 3) {
/*  467 */         this.store.commit();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void rollbackTo(Transaction paramTransaction, long paramLong1, long paramLong2) {
/*  481 */     synchronized (this.undoLog) {
/*  482 */       long l; for (l = paramLong1 - 1L; l >= paramLong2; l--) {
/*  483 */         Long long_ = Long.valueOf(getOperationId(paramTransaction.getId(), l));
/*  484 */         Object[] arrayOfObject = (Object[])this.undoLog.get(long_);
/*  485 */         if (arrayOfObject == null) {
/*      */           
/*  487 */           long_ = (Long)this.undoLog.floorKey(long_);
/*  488 */           if (long_ == null || getTransactionId(long_.longValue()) != paramTransaction.getId()) {
/*      */             break;
/*      */           }
/*      */           
/*  492 */           l = getLogId(long_.longValue()) + 1L;
/*      */         } else {
/*      */           
/*  495 */           int i = ((Integer)arrayOfObject[0]).intValue();
/*  496 */           MVMap<Object, VersionedValue> mVMap = openMap(i);
/*  497 */           if (mVMap != null) {
/*  498 */             Object object = arrayOfObject[1];
/*  499 */             VersionedValue versionedValue = (VersionedValue)arrayOfObject[2];
/*  500 */             if (versionedValue == null) {
/*      */               
/*  502 */               mVMap.remove(object);
/*      */             } else {
/*      */               
/*  505 */               mVMap.put(object, versionedValue);
/*      */             } 
/*      */           } 
/*  508 */           this.undoLog.remove(long_);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Iterator<Change> getChanges(final Transaction t, final long maxLogId, final long toLogId) {
/*  524 */     return new Iterator<Change>()
/*      */       {
/*      */         private long logId;
/*      */ 
/*      */         
/*      */         private TransactionStore.Change current;
/*      */ 
/*      */ 
/*      */         
/*      */         private void fetchNext() {
/*  534 */           synchronized (TransactionStore.this.undoLog) {
/*  535 */             while (this.logId >= toLogId) {
/*  536 */               Long long_ = Long.valueOf(TransactionStore.getOperationId(t.getId(), this.logId));
/*  537 */               Object[] arrayOfObject = (Object[])TransactionStore.this.undoLog.get(long_);
/*  538 */               this.logId--;
/*  539 */               if (arrayOfObject == null) {
/*      */                 
/*  541 */                 long_ = (Long)TransactionStore.this.undoLog.floorKey(long_);
/*  542 */                 if (long_ == null || TransactionStore.getTransactionId(long_.longValue()) != t.getId()) {
/*      */                   break;
/*      */                 }
/*      */                 
/*  546 */                 this.logId = TransactionStore.getLogId(long_.longValue());
/*      */                 continue;
/*      */               } 
/*  549 */               int i = ((Integer)arrayOfObject[0]).intValue();
/*  550 */               MVMap<Object, TransactionStore.VersionedValue> mVMap = TransactionStore.this.openMap(i);
/*  551 */               if (mVMap == null) {
/*      */                 continue;
/*      */               }
/*  554 */               this.current = new TransactionStore.Change();
/*  555 */               this.current.mapName = mVMap.getName();
/*  556 */               this.current.key = arrayOfObject[1];
/*  557 */               TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)arrayOfObject[2];
/*  558 */               this.current.value = (versionedValue == null) ? null : versionedValue.value;
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/*      */           
/*  564 */           this.current = null;
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean hasNext() {
/*  569 */           return (this.current != null);
/*      */         }
/*      */ 
/*      */         
/*      */         public TransactionStore.Change next() {
/*  574 */           if (this.current == null) {
/*  575 */             throw DataUtils.newUnsupportedOperationException("no data");
/*      */           }
/*  577 */           TransactionStore.Change change = this.current;
/*  578 */           fetchNext();
/*  579 */           return change;
/*      */         }
/*      */ 
/*      */         
/*      */         public void remove() {
/*  584 */           throw DataUtils.newUnsupportedOperationException("remove");
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Change
/*      */   {
/*      */     public String mapName;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object key;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class Transaction
/*      */   {
/*      */     public static final int STATUS_CLOSED = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final int STATUS_OPEN = 1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final int STATUS_PREPARED = 2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public static final int STATUS_COMMITTING = 3;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final TransactionStore store;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final int transactionId;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long logId;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int status;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String name;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Transaction(TransactionStore param1TransactionStore, int param1Int1, int param1Int2, String param1String, long param1Long) {
/*  660 */       this.store = param1TransactionStore;
/*  661 */       this.transactionId = param1Int1;
/*  662 */       this.status = param1Int2;
/*  663 */       this.name = param1String;
/*  664 */       this.logId = param1Long;
/*      */     }
/*      */     
/*      */     public int getId() {
/*  668 */       return this.transactionId;
/*      */     }
/*      */     
/*      */     public int getStatus() {
/*  672 */       return this.status;
/*      */     }
/*      */     
/*      */     void setStatus(int param1Int) {
/*  676 */       this.status = param1Int;
/*      */     }
/*      */     
/*      */     public void setName(String param1String) {
/*  680 */       checkNotClosed();
/*  681 */       this.name = param1String;
/*  682 */       this.store.storeTransaction(this);
/*      */     }
/*      */     
/*      */     public String getName() {
/*  686 */       return this.name;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public long setSavepoint() {
/*  695 */       return this.logId;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void log(int param1Int, Object param1Object1, Object param1Object2) {
/*  706 */       this.store.log(this, this.logId, param1Int, param1Object1, param1Object2);
/*      */       
/*  708 */       this.logId++;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void logUndo() {
/*  715 */       this.store.logUndo(this, --this.logId);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <K, V> TransactionStore.TransactionMap<K, V> openMap(String param1String) {
/*  727 */       return openMap(param1String, null, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <K, V> TransactionStore.TransactionMap<K, V> openMap(String param1String, DataType param1DataType1, DataType param1DataType2) {
/*  742 */       checkNotClosed();
/*  743 */       MVMap<?, TransactionStore.VersionedValue> mVMap = this.store.openMap(param1String, param1DataType1, param1DataType2);
/*      */       
/*  745 */       int i = mVMap.getId();
/*  746 */       return new TransactionStore.TransactionMap<>(this, (MVMap)mVMap, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <K, V> TransactionStore.TransactionMap<K, V> openMap(MVMap<K, TransactionStore.VersionedValue> param1MVMap) {
/*  759 */       checkNotClosed();
/*  760 */       int i = param1MVMap.getId();
/*  761 */       return new TransactionStore.TransactionMap<>(this, param1MVMap, i);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void prepare() {
/*  769 */       checkNotClosed();
/*  770 */       this.status = 2;
/*  771 */       this.store.storeTransaction(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void commit() {
/*  778 */       checkNotClosed();
/*  779 */       this.store.commit(this, this.logId);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void rollbackToSavepoint(long param1Long) {
/*  789 */       checkNotClosed();
/*  790 */       this.store.rollbackTo(this, this.logId, param1Long);
/*  791 */       this.logId = param1Long;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void rollback() {
/*  798 */       checkNotClosed();
/*  799 */       this.store.rollbackTo(this, this.logId, 0L);
/*  800 */       this.store.endTransaction(this);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<TransactionStore.Change> getChanges(long param1Long) {
/*  813 */       return this.store.getChanges(this, this.logId, param1Long);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void checkNotClosed() {
/*  820 */       if (this.status == 0) {
/*  821 */         throw DataUtils.newIllegalStateException(4, "Transaction is closed", new Object[0]);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public <K, V> void removeMap(TransactionStore.TransactionMap<K, V> param1TransactionMap) {
/*  832 */       this.store.removeMap(param1TransactionMap);
/*      */     }
/*      */ 
/*      */     
/*      */     public String toString() {
/*  837 */       return "" + this.transactionId;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class TransactionMap<K, V>
/*      */   {
/*      */     final int mapId;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  861 */     long readLogId = Long.MAX_VALUE;
/*      */ 
/*      */ 
/*      */     
/*      */     final MVMap<K, TransactionStore.VersionedValue> map;
/*      */ 
/*      */ 
/*      */     
/*      */     private TransactionStore.Transaction transaction;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TransactionMap(TransactionStore.Transaction param1Transaction, MVMap<K, TransactionStore.VersionedValue> param1MVMap, int param1Int) {
/*  875 */       this.transaction = param1Transaction;
/*  876 */       this.map = param1MVMap;
/*  877 */       this.mapId = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setSavepoint(long param1Long) {
/*  887 */       this.readLogId = param1Long;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TransactionMap<K, V> getInstance(TransactionStore.Transaction param1Transaction, long param1Long) {
/*  899 */       TransactionMap<K, V> transactionMap = new TransactionMap(param1Transaction, this.map, this.mapId);
/*      */       
/*  901 */       transactionMap.setSavepoint(param1Long);
/*  902 */       return transactionMap;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public long sizeAsLongMax() {
/*  912 */       return this.map.sizeAsLong();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public long sizeAsLong() {
/*  921 */       long l2, l1 = this.map.sizeAsLong();
/*  922 */       MVMap<Long, Object[]> mVMap = this.transaction.store.undoLog;
/*      */       
/*  924 */       synchronized (mVMap) {
/*  925 */         l2 = mVMap.sizeAsLong();
/*      */       } 
/*  927 */       if (l2 == 0L) {
/*  928 */         return l1;
/*      */       }
/*  930 */       if (l2 > l1) {
/*      */ 
/*      */         
/*  933 */         long l = 0L;
/*  934 */         Cursor cursor = this.map.cursor(null);
/*  935 */         while (cursor.hasNext()) {
/*      */           TransactionStore.VersionedValue versionedValue;
/*  937 */           synchronized (this.transaction.store.undoLog) {
/*  938 */             Object object = cursor.next();
/*  939 */             versionedValue = getValue((K)object, this.readLogId, (TransactionStore.VersionedValue)cursor.getValue());
/*      */           } 
/*  941 */           if (versionedValue != null && versionedValue.value != null) {
/*  942 */             l++;
/*      */           }
/*      */         } 
/*  945 */         return l;
/*      */       } 
/*      */ 
/*      */       
/*  949 */       synchronized (mVMap) {
/*      */         
/*  951 */         long l = this.map.sizeAsLong();
/*  952 */         MVMap<Object, Integer> mVMap1 = this.transaction.store.createTempMap();
/*      */         try {
/*  954 */           for (Map.Entry entry : mVMap.entrySet()) {
/*  955 */             Object[] arrayOfObject = (Object[])entry.getValue();
/*  956 */             int i = ((Integer)arrayOfObject[0]).intValue();
/*  957 */             if (i != this.mapId) {
/*      */               continue;
/*      */             }
/*      */ 
/*      */             
/*  962 */             Object object = arrayOfObject[1];
/*  963 */             if (get((K)object) == null) {
/*  964 */               Integer integer = (Integer)mVMap1.put(object, Integer.valueOf(1));
/*      */ 
/*      */               
/*  967 */               if (integer == null) {
/*  968 */                 l--;
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } finally {
/*  973 */           this.transaction.store.store.removeMap(mVMap1);
/*      */         } 
/*  975 */         return l;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V remove(K param1K) {
/*  989 */       return set(param1K, null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V put(K param1K, V param1V) {
/* 1004 */       DataUtils.checkArgument((param1V != null), "The value may not be null", new Object[0]);
/* 1005 */       return set(param1K, param1V);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V putCommitted(K param1K, V param1V) {
/* 1017 */       DataUtils.checkArgument((param1V != null), "The value may not be null", new Object[0]);
/* 1018 */       TransactionStore.VersionedValue versionedValue1 = new TransactionStore.VersionedValue();
/* 1019 */       versionedValue1.value = param1V;
/* 1020 */       TransactionStore.VersionedValue versionedValue2 = (TransactionStore.VersionedValue)this.map.put(param1K, versionedValue1);
/* 1021 */       return (versionedValue2 == null) ? null : (V)versionedValue2.value;
/*      */     }
/*      */     
/*      */     private V set(K param1K, V param1V) {
/* 1025 */       this.transaction.checkNotClosed();
/* 1026 */       V v = get(param1K);
/* 1027 */       boolean bool = trySet(param1K, param1V, false);
/* 1028 */       if (bool) {
/* 1029 */         return v;
/*      */       }
/* 1031 */       throw DataUtils.newIllegalStateException(101, "Entry is locked", new Object[0]);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean tryRemove(K param1K) {
/* 1045 */       return trySet(param1K, null, false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean tryPut(K param1K, V param1V) {
/* 1059 */       DataUtils.checkArgument((param1V != null), "The value may not be null", new Object[0]);
/* 1060 */       return trySet(param1K, param1V, false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean trySet(K param1K, V param1V, boolean param1Boolean) {
/* 1076 */       TransactionStore.VersionedValue versionedValue1 = (TransactionStore.VersionedValue)this.map.get(param1K);
/* 1077 */       if (param1Boolean) {
/* 1078 */         TransactionStore.VersionedValue versionedValue = getValue(param1K, this.readLogId);
/* 1079 */         if (!this.map.areValuesEqual(versionedValue, versionedValue1)) {
/* 1080 */           long l1 = TransactionStore.getTransactionId(versionedValue1.operationId);
/* 1081 */           if (l1 == this.transaction.transactionId) {
/* 1082 */             if (param1V == null)
/*      */             {
/*      */ 
/*      */               
/* 1086 */               return true; } 
/* 1087 */             if (versionedValue1.value != null)
/*      */             {
/*      */ 
/*      */               
/* 1091 */               return false;
/*      */             }
/*      */           } else {
/* 1094 */             return false;
/*      */           } 
/*      */         } 
/*      */       } 
/* 1098 */       TransactionStore.VersionedValue versionedValue2 = new TransactionStore.VersionedValue();
/* 1099 */       versionedValue2.operationId = TransactionStore.getOperationId(this.transaction.transactionId, this.transaction.logId);
/*      */       
/* 1101 */       versionedValue2.value = param1V;
/* 1102 */       if (versionedValue1 == null) {
/*      */         
/* 1104 */         this.transaction.log(this.mapId, param1K, versionedValue1);
/* 1105 */         TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)this.map.putIfAbsent(param1K, versionedValue2);
/* 1106 */         if (versionedValue != null) {
/* 1107 */           this.transaction.logUndo();
/* 1108 */           return false;
/*      */         } 
/* 1110 */         return true;
/*      */       } 
/* 1112 */       long l = versionedValue1.operationId;
/* 1113 */       if (l == 0L) {
/*      */         
/* 1115 */         this.transaction.log(this.mapId, param1K, versionedValue1);
/*      */ 
/*      */         
/* 1118 */         if (!this.map.replace(param1K, versionedValue1, versionedValue2)) {
/*      */           
/* 1120 */           this.transaction.logUndo();
/* 1121 */           return false;
/*      */         } 
/* 1123 */         return true;
/*      */       } 
/* 1125 */       int i = TransactionStore.getTransactionId(versionedValue1.operationId);
/* 1126 */       if (i == this.transaction.transactionId) {
/*      */         
/* 1128 */         this.transaction.log(this.mapId, param1K, versionedValue1);
/* 1129 */         if (!this.map.replace(param1K, versionedValue1, versionedValue2)) {
/*      */ 
/*      */           
/* 1132 */           this.transaction.logUndo();
/* 1133 */           return false;
/*      */         } 
/* 1135 */         return true;
/*      */       } 
/*      */       
/* 1138 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V get(K param1K) {
/* 1148 */       return get(param1K, this.readLogId);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V getLatest(K param1K) {
/* 1158 */       return get(param1K, Long.MAX_VALUE);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean containsKey(K param1K) {
/* 1168 */       return (get(param1K) != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public V get(K param1K, long param1Long) {
/* 1180 */       TransactionStore.VersionedValue versionedValue = getValue(param1K, param1Long);
/* 1181 */       return (versionedValue == null) ? null : (V)versionedValue.value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSameTransaction(K param1K) {
/* 1192 */       TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)this.map.get(param1K);
/* 1193 */       if (versionedValue == null)
/*      */       {
/* 1195 */         return false;
/*      */       }
/* 1197 */       int i = TransactionStore.getTransactionId(versionedValue.operationId);
/* 1198 */       return (i == this.transaction.transactionId);
/*      */     }
/*      */     
/*      */     private TransactionStore.VersionedValue getValue(K param1K, long param1Long) {
/* 1202 */       synchronized (getUndoLog()) {
/* 1203 */         TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)this.map.get(param1K);
/* 1204 */         return getValue(param1K, param1Long, versionedValue);
/*      */       } 
/*      */     }
/*      */     
/*      */     Object getUndoLog() {
/* 1209 */       return this.transaction.store.undoLog;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TransactionStore.VersionedValue getValue(K param1K, long param1Long, TransactionStore.VersionedValue param1VersionedValue) {
/*      */       while (true) {
/* 1229 */         if (param1VersionedValue == null)
/*      */         {
/* 1231 */           return null;
/*      */         }
/* 1233 */         long l = param1VersionedValue.operationId;
/* 1234 */         if (l == 0L)
/*      */         {
/* 1236 */           return param1VersionedValue;
/*      */         }
/* 1238 */         int i = TransactionStore.getTransactionId(l);
/* 1239 */         if (i == this.transaction.transactionId)
/*      */         {
/* 1241 */           if (TransactionStore.getLogId(l) < param1Long) {
/* 1242 */             return param1VersionedValue;
/*      */           }
/*      */         }
/*      */ 
/*      */         
/* 1247 */         Object[] arrayOfObject = (Object[])this.transaction.store.undoLog.get(Long.valueOf(l));
/* 1248 */         if (arrayOfObject == null) {
/* 1249 */           if (this.transaction.store.store.isReadOnly())
/*      */           {
/* 1251 */             return null;
/*      */           }
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1257 */           param1VersionedValue = (TransactionStore.VersionedValue)this.map.get(param1K); continue;
/*      */         } 
/* 1259 */         param1VersionedValue = (TransactionStore.VersionedValue)arrayOfObject[2];
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isClosed() {
/* 1270 */       return this.map.isClosed();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void clear() {
/* 1278 */       this.map.clear();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K firstKey() {
/* 1287 */       Iterator<K> iterator = keyIterator(null);
/* 1288 */       return iterator.hasNext() ? iterator.next() : null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K lastKey() {
/* 1297 */       Object object = this.map.lastKey();
/*      */       while (true) {
/* 1299 */         if (object == null) {
/* 1300 */           return null;
/*      */         }
/* 1302 */         if (get((K)object) != null) {
/* 1303 */           return (K)object;
/*      */         }
/* 1305 */         object = this.map.lowerKey(object);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K higherKey(K param1K) {
/*      */       while (true) {
/* 1318 */         Object object = this.map.higherKey(param1K);
/* 1319 */         if (object == null || get((K)object) != null) {
/* 1320 */           return (K)object;
/*      */         }
/* 1322 */         param1K = (K)object;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K relativeKey(K param1K, long param1Long) {
/* 1335 */       Object object = (param1Long > 0L) ? this.map.ceilingKey(param1K) : this.map.floorKey(param1K);
/* 1336 */       if (object == null) {
/* 1337 */         return (K)object;
/*      */       }
/* 1339 */       long l = this.map.getKeyIndex(object);
/* 1340 */       return (K)this.map.getKey(l + param1Long);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public K lowerKey(K param1K) {
/*      */       while (true) {
/* 1352 */         Object object = this.map.lowerKey(param1K);
/* 1353 */         if (object == null || get((K)object) != null) {
/* 1354 */           return (K)object;
/*      */         }
/* 1356 */         param1K = (K)object;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<K> keyIterator(K param1K) {
/* 1367 */       return keyIterator(param1K, false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<K> keyIterator(final K from, final boolean includeUncommitted) {
/* 1379 */       return new Iterator<K>()
/*      */         {
/*      */           private K currentKey;
/*      */ 
/*      */           
/*      */           private Cursor<K, TransactionStore.VersionedValue> cursor;
/*      */ 
/*      */           
/*      */           private void fetchNext() {
/* 1388 */             while (this.cursor.hasNext()) {
/*      */               Object object;
/*      */               try {
/* 1391 */                 object = this.cursor.next();
/* 1392 */               } catch (IllegalStateException illegalStateException) {
/*      */                 
/* 1394 */                 if (DataUtils.getErrorCode(illegalStateException.getMessage()) == 9) {
/*      */                   
/* 1396 */                   this.cursor = TransactionStore.TransactionMap.this.map.cursor(this.currentKey);
/*      */ 
/*      */                   
/* 1399 */                   if (!this.cursor.hasNext()) {
/*      */                     break;
/*      */                   }
/* 1402 */                   this.cursor.next();
/* 1403 */                   if (!this.cursor.hasNext()) {
/*      */                     break;
/*      */                   }
/* 1406 */                   object = this.cursor.next();
/*      */                 } else {
/* 1408 */                   throw illegalStateException;
/*      */                 } 
/*      */               } 
/* 1411 */               this.currentKey = (K)object;
/* 1412 */               if (includeUncommitted) {
/*      */                 return;
/*      */               }
/* 1415 */               if (TransactionStore.TransactionMap.this.containsKey(object)) {
/*      */                 return;
/*      */               }
/*      */             } 
/* 1419 */             this.currentKey = null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean hasNext() {
/* 1424 */             return (this.currentKey != null);
/*      */           }
/*      */ 
/*      */           
/*      */           public K next() {
/* 1429 */             K k = this.currentKey;
/* 1430 */             fetchNext();
/* 1431 */             return k;
/*      */           }
/*      */ 
/*      */           
/*      */           public void remove() {
/* 1436 */             throw DataUtils.newUnsupportedOperationException("Removing is not supported");
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<Map.Entry<K, V>> entryIterator(final K from) {
/* 1449 */       return new Iterator<Map.Entry<K, V>>()
/*      */         {
/*      */           private Map.Entry<K, V> current;
/*      */           
/*      */           private K currentKey;
/*      */           
/*      */           private Cursor<K, TransactionStore.VersionedValue> cursor;
/*      */ 
/*      */           
/*      */           private void fetchNext() {
/* 1459 */             while (this.cursor.hasNext()) {
/* 1460 */               synchronized (TransactionStore.TransactionMap.this.getUndoLog()) {
/*      */                 Object object1;
/*      */                 try {
/* 1463 */                   object1 = this.cursor.next();
/* 1464 */                 } catch (IllegalStateException illegalStateException) {
/*      */                   
/* 1466 */                   if (DataUtils.getErrorCode(illegalStateException.getMessage()) == 9) {
/*      */                     
/* 1468 */                     this.cursor = TransactionStore.TransactionMap.this.map.cursor(this.currentKey);
/*      */ 
/*      */                     
/* 1471 */                     if (!this.cursor.hasNext()) {
/*      */                       break;
/*      */                     }
/* 1474 */                     this.cursor.next();
/* 1475 */                     if (!this.cursor.hasNext()) {
/*      */                       break;
/*      */                     }
/* 1478 */                     object1 = this.cursor.next();
/*      */                   } else {
/* 1480 */                     throw illegalStateException;
/*      */                   } 
/*      */                 } 
/* 1483 */                 Object object2 = object1;
/* 1484 */                 TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)this.cursor.getValue();
/* 1485 */                 versionedValue = TransactionStore.TransactionMap.this.getValue(object2, TransactionStore.TransactionMap.this.readLogId, versionedValue);
/* 1486 */                 if (versionedValue != null && versionedValue.value != null) {
/*      */                   
/* 1488 */                   Object object = versionedValue.value;
/* 1489 */                   this.current = (Map.Entry<K, V>)new DataUtils.MapEntry(object2, object);
/* 1490 */                   this.currentKey = (K)object2;
/*      */                   return;
/*      */                 } 
/*      */               } 
/*      */             } 
/* 1495 */             this.current = null;
/* 1496 */             this.currentKey = null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean hasNext() {
/* 1501 */             return (this.current != null);
/*      */           }
/*      */ 
/*      */           
/*      */           public Map.Entry<K, V> next() {
/* 1506 */             Map.Entry<K, V> entry = this.current;
/* 1507 */             fetchNext();
/* 1508 */             return entry;
/*      */           }
/*      */ 
/*      */           
/*      */           public void remove() {
/* 1513 */             throw DataUtils.newUnsupportedOperationException("Removing is not supported");
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator<K> wrapIterator(final Iterator<K> iterator, final boolean includeUncommitted) {
/* 1531 */       return new Iterator<K>()
/*      */         {
/*      */           private K current;
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           private void fetchNext() {
/* 1539 */             while (iterator.hasNext()) {
/* 1540 */               this.current = iterator.next();
/* 1541 */               if (includeUncommitted) {
/*      */                 return;
/*      */               }
/* 1544 */               if (TransactionStore.TransactionMap.this.containsKey(this.current)) {
/*      */                 return;
/*      */               }
/*      */             } 
/* 1548 */             this.current = null;
/*      */           }
/*      */ 
/*      */           
/*      */           public boolean hasNext() {
/* 1553 */             return (this.current != null);
/*      */           }
/*      */ 
/*      */           
/*      */           public K next() {
/* 1558 */             K k = this.current;
/* 1559 */             fetchNext();
/* 1560 */             return k;
/*      */           }
/*      */ 
/*      */           
/*      */           public void remove() {
/* 1565 */             throw DataUtils.newUnsupportedOperationException("Removing is not supported");
/*      */           }
/*      */         };
/*      */     }
/*      */ 
/*      */     
/*      */     public TransactionStore.Transaction getTransaction() {
/* 1572 */       return this.transaction;
/*      */     }
/*      */     
/*      */     public DataType getKeyType() {
/* 1576 */       return this.map.getKeyType();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class VersionedValue
/*      */   {
/*      */     public long operationId;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object value;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1599 */       return this.value + ((this.operationId == 0L) ? "" : (" " + TransactionStore.getTransactionId(this.operationId) + "/" + TransactionStore.getLogId(this.operationId)));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class VersionedValueType
/*      */     implements DataType
/*      */   {
/*      */     private final DataType valueType;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     VersionedValueType(DataType param1DataType) {
/* 1615 */       this.valueType = param1DataType;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1620 */       TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)param1Object;
/* 1621 */       return this.valueType.getMemory(versionedValue.value) + 8;
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1626 */       if (param1Object1 == param1Object2) {
/* 1627 */         return 0;
/*      */       }
/* 1629 */       TransactionStore.VersionedValue versionedValue1 = (TransactionStore.VersionedValue)param1Object1;
/* 1630 */       TransactionStore.VersionedValue versionedValue2 = (TransactionStore.VersionedValue)param1Object2;
/* 1631 */       long l = versionedValue1.operationId - versionedValue2.operationId;
/* 1632 */       if (l == 0L) {
/* 1633 */         return this.valueType.compare(versionedValue1.value, versionedValue2.value);
/*      */       }
/* 1635 */       return Long.signum(l);
/*      */     }
/*      */ 
/*      */     
/*      */     public void read(ByteBuffer param1ByteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 1640 */       if (param1ByteBuffer.get() == 0) {
/*      */         
/* 1642 */         for (byte b = 0; b < param1Int; b++) {
/* 1643 */           TransactionStore.VersionedValue versionedValue = new TransactionStore.VersionedValue();
/* 1644 */           versionedValue.value = this.valueType.read(param1ByteBuffer);
/* 1645 */           param1ArrayOfObject[b] = versionedValue;
/*      */         } 
/*      */       } else {
/*      */         
/* 1649 */         for (byte b = 0; b < param1Int; b++) {
/* 1650 */           param1ArrayOfObject[b] = read(param1ByteBuffer);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer) {
/* 1657 */       TransactionStore.VersionedValue versionedValue = new TransactionStore.VersionedValue();
/* 1658 */       versionedValue.operationId = DataUtils.readVarLong(param1ByteBuffer);
/* 1659 */       if (param1ByteBuffer.get() == 1) {
/* 1660 */         versionedValue.value = this.valueType.read(param1ByteBuffer);
/*      */       }
/* 1662 */       return versionedValue;
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 1667 */       boolean bool = true; byte b;
/* 1668 */       for (b = 0; b < param1Int; b++) {
/* 1669 */         TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)param1ArrayOfObject[b];
/* 1670 */         if (versionedValue.operationId != 0L || versionedValue.value == null) {
/* 1671 */           bool = false;
/*      */         }
/*      */       } 
/* 1674 */       if (bool) {
/* 1675 */         param1WriteBuffer.put((byte)0);
/* 1676 */         for (b = 0; b < param1Int; b++) {
/* 1677 */           TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)param1ArrayOfObject[b];
/* 1678 */           this.valueType.write(param1WriteBuffer, versionedValue.value);
/*      */         }
/*      */       
/*      */       } else {
/*      */         
/* 1683 */         param1WriteBuffer.put((byte)1);
/* 1684 */         for (b = 0; b < param1Int; b++) {
/* 1685 */           write(param1WriteBuffer, param1ArrayOfObject[b]);
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1692 */       TransactionStore.VersionedValue versionedValue = (TransactionStore.VersionedValue)param1Object;
/* 1693 */       param1WriteBuffer.putVarLong(versionedValue.operationId);
/* 1694 */       if (versionedValue.value == null) {
/* 1695 */         param1WriteBuffer.put((byte)0);
/*      */       } else {
/* 1697 */         param1WriteBuffer.put((byte)1);
/* 1698 */         this.valueType.write(param1WriteBuffer, versionedValue.value);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static class ArrayType
/*      */     implements DataType
/*      */   {
/*      */     private final int arrayLength;
/*      */     
/*      */     private final DataType[] elementTypes;
/*      */ 
/*      */     
/*      */     ArrayType(DataType[] param1ArrayOfDataType) {
/* 1714 */       this.arrayLength = param1ArrayOfDataType.length;
/* 1715 */       this.elementTypes = param1ArrayOfDataType;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getMemory(Object param1Object) {
/* 1720 */       Object[] arrayOfObject = (Object[])param1Object;
/* 1721 */       int i = 0;
/* 1722 */       for (byte b = 0; b < this.arrayLength; b++) {
/* 1723 */         DataType dataType = this.elementTypes[b];
/* 1724 */         Object object = arrayOfObject[b];
/* 1725 */         if (object != null) {
/* 1726 */           i += dataType.getMemory(object);
/*      */         }
/*      */       } 
/* 1729 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public int compare(Object param1Object1, Object param1Object2) {
/* 1734 */       if (param1Object1 == param1Object2) {
/* 1735 */         return 0;
/*      */       }
/* 1737 */       Object[] arrayOfObject1 = (Object[])param1Object1;
/* 1738 */       Object[] arrayOfObject2 = (Object[])param1Object2;
/* 1739 */       for (byte b = 0; b < this.arrayLength; b++) {
/* 1740 */         DataType dataType = this.elementTypes[b];
/* 1741 */         int i = dataType.compare(arrayOfObject1[b], arrayOfObject2[b]);
/* 1742 */         if (i != 0) {
/* 1743 */           return i;
/*      */         }
/*      */       } 
/* 1746 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void read(ByteBuffer param1ByteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 1752 */       for (byte b = 0; b < param1Int; b++) {
/* 1753 */         param1ArrayOfObject[b] = read(param1ByteBuffer);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object[] param1ArrayOfObject, int param1Int, boolean param1Boolean) {
/* 1760 */       for (byte b = 0; b < param1Int; b++) {
/* 1761 */         write(param1WriteBuffer, param1ArrayOfObject[b]);
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     public void write(WriteBuffer param1WriteBuffer, Object param1Object) {
/* 1767 */       Object[] arrayOfObject = (Object[])param1Object;
/* 1768 */       for (byte b = 0; b < this.arrayLength; b++) {
/* 1769 */         DataType dataType = this.elementTypes[b];
/* 1770 */         Object object = arrayOfObject[b];
/* 1771 */         if (object == null) {
/* 1772 */           param1WriteBuffer.put((byte)0);
/*      */         } else {
/* 1774 */           param1WriteBuffer.put((byte)1);
/* 1775 */           dataType.write(param1WriteBuffer, object);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public Object read(ByteBuffer param1ByteBuffer) {
/* 1782 */       Object[] arrayOfObject = new Object[this.arrayLength];
/* 1783 */       for (byte b = 0; b < this.arrayLength; b++) {
/* 1784 */         DataType dataType = this.elementTypes[b];
/* 1785 */         if (param1ByteBuffer.get() == 1) {
/* 1786 */           arrayOfObject[b] = dataType.read(param1ByteBuffer);
/*      */         }
/*      */       } 
/* 1789 */       return arrayOfObject;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\db\TransactionStore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */