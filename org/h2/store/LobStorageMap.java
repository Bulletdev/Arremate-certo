/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.MVMap;
/*     */ import org.h2.mvstore.MVStore;
/*     */ import org.h2.mvstore.StreamStore;
/*     */ import org.h2.mvstore.db.MVTableEngine;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueLobDb;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class LobStorageMap
/*     */   implements LobStorageInterface
/*     */ {
/*     */   private static final boolean TRACE = false;
/*     */   private final Database database;
/*     */   private boolean init;
/*  40 */   private Object nextLobIdSync = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long nextLobId;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MVMap<Long, Object[]> lobMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MVMap<Object[], Boolean> refMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private MVMap<Long, byte[]> dataMap;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private StreamStore streamStore;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LobStorageMap(Database paramDatabase) {
/*  74 */     this.database = paramDatabase;
/*     */   }
/*     */   
/*     */   public void init() {
/*     */     MVStore mVStore;
/*  79 */     if (this.init) {
/*     */       return;
/*     */     }
/*  82 */     this.init = true;
/*  83 */     MVTableEngine.Store store = this.database.getMvStore();
/*     */     
/*  85 */     if (store == null) {
/*     */       
/*  87 */       mVStore = MVStore.open(null);
/*     */     } else {
/*  89 */       mVStore = store.getStore();
/*     */     } 
/*  91 */     this.lobMap = mVStore.openMap("lobMap");
/*  92 */     this.refMap = mVStore.openMap("lobRef");
/*  93 */     this.dataMap = mVStore.openMap("lobData");
/*  94 */     this.streamStore = new StreamStore((Map)this.dataMap);
/*     */     
/*  96 */     if (this.database.isReadOnly()) {
/*     */       return;
/*     */     }
/*  99 */     if (this.dataMap.isEmpty()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 106 */     long l = -1L;
/* 107 */     for (Map.Entry entry : this.lobMap.entrySet()) {
/* 108 */       long l1 = ((Long)entry.getKey()).longValue();
/* 109 */       Object[] arrayOfObject = (Object[])entry.getValue();
/* 110 */       byte[] arrayOfByte = (byte[])arrayOfObject[0];
/* 111 */       long l2 = this.streamStore.getMaxBlockKey(arrayOfByte);
/*     */       
/* 113 */       if (l2 != -1L && l2 > l) {
/* 114 */         l = l2;
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 125 */       Long long_1 = (Long)this.dataMap.lastKey();
/* 126 */       if (long_1 == null || long_1.longValue() <= l) {
/*     */         break;
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 132 */       this.dataMap.remove(long_1);
/*     */     } 
/*     */     
/* 135 */     Long long_ = (Long)this.dataMap.lastKey();
/* 136 */     if (long_ != null) {
/* 137 */       this.streamStore.setNextKey(long_.longValue() + 1L);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Value createBlob(InputStream paramInputStream, long paramLong) {
/* 143 */     init();
/* 144 */     byte b = 15;
/*     */     try {
/* 146 */       if (paramLong != -1L && paramLong <= this.database.getMaxLengthInplaceLob()) {
/*     */         
/* 148 */         byte[] arrayOfByte = new byte[(int)paramLong];
/* 149 */         int i = IOUtils.readFully(paramInputStream, arrayOfByte, (int)paramLong);
/* 150 */         if (i > paramLong) {
/* 151 */           throw new IllegalStateException("len > blobLength, " + i + " > " + paramLong);
/*     */         }
/*     */         
/* 154 */         if (i < arrayOfByte.length) {
/* 155 */           arrayOfByte = Arrays.copyOf(arrayOfByte, i);
/*     */         }
/* 157 */         return ValueLobDb.createSmallLob(b, arrayOfByte);
/*     */       } 
/* 159 */       if (paramLong != -1L) {
/* 160 */         paramInputStream = new LimitInputStream(paramInputStream, paramLong);
/*     */       }
/* 162 */       return (Value)createLob(paramInputStream, b);
/* 163 */     } catch (IllegalStateException illegalStateException) {
/* 164 */       throw DbException.get(90007, illegalStateException, new String[0]);
/* 165 */     } catch (IOException iOException) {
/* 166 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Value createClob(Reader paramReader, long paramLong) {
/* 172 */     init();
/* 173 */     byte b = 16;
/*     */     
/*     */     try {
/* 176 */       if (paramLong != -1L && paramLong * 3L <= this.database.getMaxLengthInplaceLob()) {
/*     */         
/* 178 */         char[] arrayOfChar = new char[(int)paramLong];
/* 179 */         int i = IOUtils.readFully(paramReader, arrayOfChar, (int)paramLong);
/* 180 */         if (i > paramLong) {
/* 181 */           throw new IllegalStateException("len > blobLength, " + i + " > " + paramLong);
/*     */         }
/*     */         
/* 184 */         byte[] arrayOfByte = (new String(arrayOfChar, 0, i)).getBytes(Constants.UTF8);
/*     */         
/* 186 */         if (arrayOfByte.length > this.database.getMaxLengthInplaceLob()) {
/* 187 */           throw new IllegalStateException("len > maxinplace, " + arrayOfByte.length + " > " + this.database.getMaxLengthInplaceLob());
/*     */         }
/*     */ 
/*     */         
/* 191 */         return ValueLobDb.createSmallLob(b, arrayOfByte);
/*     */       } 
/* 193 */       if (paramLong < 0L) {
/* 194 */         paramLong = Long.MAX_VALUE;
/*     */       }
/* 196 */       CountingReaderInputStream countingReaderInputStream = new CountingReaderInputStream(paramReader, paramLong);
/*     */       
/* 198 */       ValueLobDb valueLobDb = createLob(countingReaderInputStream, b);
/*     */       
/* 200 */       valueLobDb = ValueLobDb.create(b, (DataHandler)this.database, valueLobDb.getTableId(), valueLobDb.getLobId(), null, countingReaderInputStream.getLength());
/*     */       
/* 202 */       return (Value)valueLobDb;
/* 203 */     } catch (IllegalStateException illegalStateException) {
/* 204 */       throw DbException.get(90007, illegalStateException, new String[0]);
/* 205 */     } catch (IOException iOException) {
/* 206 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private ValueLobDb createLob(InputStream paramInputStream, int paramInt) throws IOException {
/*     */     byte[] arrayOfByte;
/*     */     try {
/* 213 */       arrayOfByte = this.streamStore.put(paramInputStream);
/* 214 */     } catch (Exception exception) {
/* 215 */       throw DbException.convertToIOException(exception);
/*     */     } 
/* 217 */     long l1 = generateLobId();
/* 218 */     long l2 = this.streamStore.length(arrayOfByte);
/* 219 */     byte b = -2;
/* 220 */     Object[] arrayOfObject1 = { arrayOfByte, Integer.valueOf(b), Long.valueOf(l2), Integer.valueOf(0) };
/* 221 */     this.lobMap.put(Long.valueOf(l1), arrayOfObject1);
/* 222 */     Object[] arrayOfObject2 = { arrayOfByte, Long.valueOf(l1) };
/* 223 */     this.refMap.put(arrayOfObject2, Boolean.TRUE);
/* 224 */     return ValueLobDb.create(paramInt, (DataHandler)this.database, b, l1, null, l2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long generateLobId() {
/* 233 */     synchronized (this.nextLobIdSync) {
/* 234 */       if (this.nextLobId == 0L) {
/* 235 */         Long long_ = (Long)this.lobMap.lastKey();
/* 236 */         this.nextLobId = (long_ == null) ? 1L : (long_.longValue() + 1L);
/*     */       } 
/* 238 */       return this.nextLobId++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 244 */     return this.database.isReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public ValueLobDb copyLob(ValueLobDb paramValueLobDb, int paramInt, long paramLong) {
/* 249 */     init();
/* 250 */     int i = paramValueLobDb.getType();
/* 251 */     long l1 = paramValueLobDb.getLobId();
/* 252 */     long l2 = paramValueLobDb.getPrecision();
/* 253 */     if (l2 != paramLong) {
/* 254 */       throw DbException.throwInternalError("Length is different");
/*     */     }
/* 256 */     Object[] arrayOfObject1 = (Object[])this.lobMap.get(Long.valueOf(l1));
/* 257 */     arrayOfObject1 = (Object[])arrayOfObject1.clone();
/* 258 */     byte[] arrayOfByte = (byte[])arrayOfObject1[0];
/* 259 */     long l3 = generateLobId();
/* 260 */     arrayOfObject1[1] = Integer.valueOf(paramInt);
/* 261 */     this.lobMap.put(Long.valueOf(l3), arrayOfObject1);
/* 262 */     Object[] arrayOfObject2 = { arrayOfByte, Long.valueOf(l3) };
/* 263 */     this.refMap.put(arrayOfObject2, Boolean.TRUE);
/* 264 */     return ValueLobDb.create(i, (DataHandler)this.database, paramInt, l3, null, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream getInputStream(ValueLobDb paramValueLobDb, byte[] paramArrayOfbyte, long paramLong) throws IOException {
/* 276 */     init();
/* 277 */     Object[] arrayOfObject = (Object[])this.lobMap.get(Long.valueOf(paramValueLobDb.getLobId()));
/* 278 */     if (arrayOfObject == null) {
/* 279 */       if (paramValueLobDb.getTableId() == -3 || paramValueLobDb.getTableId() == -1)
/*     */       {
/* 281 */         throw DbException.get(90039, "" + paramValueLobDb.getLobId() + "/" + paramValueLobDb.getTableId());
/*     */       }
/*     */ 
/*     */       
/* 285 */       throw DbException.throwInternalError("Lob not found: " + paramValueLobDb.getLobId() + "/" + paramValueLobDb.getTableId());
/*     */     } 
/*     */     
/* 288 */     byte[] arrayOfByte = (byte[])arrayOfObject[0];
/* 289 */     return this.streamStore.get(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTable(ValueLobDb paramValueLobDb, int paramInt) {
/* 294 */     init();
/* 295 */     long l = paramValueLobDb.getLobId();
/* 296 */     Object[] arrayOfObject = (Object[])this.lobMap.remove(Long.valueOf(l));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 301 */     arrayOfObject[1] = Integer.valueOf(paramInt);
/* 302 */     this.lobMap.put(Long.valueOf(l), arrayOfObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeAllForTable(int paramInt) {
/* 307 */     init();
/* 308 */     if (this.database.getMvStore().getStore().isClosed()) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 313 */     ArrayList arrayList = New.arrayList();
/* 314 */     for (Map.Entry entry : this.lobMap.entrySet()) {
/* 315 */       Object[] arrayOfObject = (Object[])entry.getValue();
/* 316 */       int i = ((Integer)arrayOfObject[1]).intValue();
/* 317 */       if (i == paramInt) {
/* 318 */         arrayList.add(entry.getKey());
/*     */       }
/*     */     } 
/* 321 */     for (Iterator<Long> iterator = arrayList.iterator(); iterator.hasNext(); ) { long l = ((Long)iterator.next()).longValue();
/* 322 */       removeLob(paramInt, l); }
/*     */     
/* 324 */     if (paramInt == -1) {
/* 325 */       removeAllForTable(-2);
/* 326 */       removeAllForTable(-3);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeLob(ValueLobDb paramValueLobDb) {
/* 332 */     init();
/* 333 */     int i = paramValueLobDb.getTableId();
/* 334 */     long l = paramValueLobDb.getLobId();
/* 335 */     removeLob(i, l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void removeLob(int paramInt, long paramLong) {
/* 342 */     Object[] arrayOfObject1 = (Object[])this.lobMap.remove(Long.valueOf(paramLong));
/* 343 */     if (arrayOfObject1 == null) {
/*     */       return;
/*     */     }
/*     */     
/* 347 */     byte[] arrayOfByte = (byte[])arrayOfObject1[0];
/* 348 */     Object[] arrayOfObject2 = { arrayOfByte, Long.valueOf(paramLong) };
/* 349 */     this.refMap.remove(arrayOfObject2);
/*     */     
/* 351 */     arrayOfObject2 = new Object[] { arrayOfByte, Long.valueOf(0L) };
/* 352 */     arrayOfObject1 = (Object[])this.refMap.ceilingKey(arrayOfObject2);
/* 353 */     boolean bool = false;
/* 354 */     if (arrayOfObject1 != null) {
/* 355 */       byte[] arrayOfByte1 = (byte[])arrayOfObject1[0];
/* 356 */       if (Arrays.equals(arrayOfByte, arrayOfByte1))
/*     */       {
/*     */ 
/*     */         
/* 360 */         bool = true;
/*     */       }
/*     */     } 
/* 363 */     if (!bool)
/*     */     {
/*     */ 
/*     */       
/* 367 */       this.streamStore.remove(arrayOfByte);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void trace(String paramString) {
/* 372 */     System.out.println("[" + Thread.currentThread().getName() + "] LOB " + paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\LobStorageMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */