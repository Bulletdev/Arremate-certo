/*      */ package org.h2.mvstore;
/*      */ 
/*      */ import java.util.AbstractList;
/*      */ import java.util.AbstractMap;
/*      */ import java.util.AbstractSet;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ConcurrentMap;
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
/*      */ 
/*      */ public class MVMap<K, V>
/*      */   extends AbstractMap<K, V>
/*      */   implements ConcurrentMap<K, V>
/*      */ {
/*      */   protected MVStore store;
/*      */   protected volatile Page root;
/*      */   protected volatile long writeVersion;
/*      */   private int id;
/*      */   private long createVersion;
/*      */   private final DataType keyType;
/*      */   private final DataType valueType;
/*   60 */   private ConcurrentArrayList<Page> oldRoots = new ConcurrentArrayList<>();
/*      */   
/*      */   private boolean closed;
/*      */   
/*      */   private boolean readOnly;
/*      */   private boolean isVolatile;
/*      */   
/*      */   protected MVMap(DataType paramDataType1, DataType paramDataType2) {
/*   68 */     this.keyType = paramDataType1;
/*   69 */     this.valueType = paramDataType2;
/*   70 */     this.root = Page.createEmpty(this, -1L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getMapRootKey(int paramInt) {
/*   80 */     return "root." + Integer.toHexString(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String getMapKey(int paramInt) {
/*   90 */     return "map." + Integer.toHexString(paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init(MVStore paramMVStore, HashMap<String, Object> paramHashMap) {
/*  100 */     this.store = paramMVStore;
/*  101 */     this.id = DataUtils.readHexInt(paramHashMap, "id", 0);
/*  102 */     this.createVersion = DataUtils.readHexLong(paramHashMap, "createVersion", 0L);
/*  103 */     this.writeVersion = paramMVStore.getCurrentVersion();
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
/*      */   public synchronized V put(K paramK, V paramV) {
/*  116 */     DataUtils.checkArgument((paramV != null), "The value may not be null", new Object[0]);
/*  117 */     beforeWrite();
/*  118 */     long l = this.writeVersion;
/*  119 */     Page page = this.root.copy(l);
/*  120 */     page = splitRootIfNeeded(page, l);
/*  121 */     Object object = put(page, l, paramK, paramV);
/*  122 */     newRoot(page);
/*  123 */     return (V)object;
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
/*      */   synchronized Page putBranch(Page paramPage, K paramK, V paramV) {
/*  135 */     DataUtils.checkArgument((paramV != null), "The value may not be null", new Object[0]);
/*  136 */     long l = this.writeVersion;
/*  137 */     Page page = paramPage.copy(l);
/*  138 */     page = splitRootIfNeeded(page, l);
/*  139 */     put(page, l, paramK, paramV);
/*  140 */     return page;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Page splitRootIfNeeded(Page paramPage, long paramLong) {
/*  151 */     if (paramPage.getMemory() <= this.store.getPageSplitSize() || paramPage.getKeyCount() <= 1) {
/*  152 */       return paramPage;
/*      */     }
/*  154 */     int i = paramPage.getKeyCount() / 2;
/*  155 */     long l = paramPage.getTotalCount();
/*  156 */     Object object = paramPage.getKey(i);
/*  157 */     Page page = paramPage.split(i);
/*  158 */     Object[] arrayOfObject = { object };
/*  159 */     Page.PageReference[] arrayOfPageReference = { new Page.PageReference(paramPage, paramPage.getPos(), paramPage.getTotalCount()), new Page.PageReference(page, page.getPos(), page.getTotalCount()) };
/*      */ 
/*      */ 
/*      */     
/*  163 */     paramPage = Page.create(this, paramLong, arrayOfObject, null, arrayOfPageReference, l, 0);
/*      */ 
/*      */ 
/*      */     
/*  167 */     return paramPage;
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
/*      */   protected Object put(Page paramPage, long paramLong, Object paramObject1, Object paramObject2) {
/*  180 */     int i = paramPage.binarySearch(paramObject1);
/*  181 */     if (paramPage.isLeaf()) {
/*  182 */       if (i < 0) {
/*  183 */         i = -i - 1;
/*  184 */         paramPage.insertLeaf(i, paramObject1, paramObject2);
/*  185 */         return null;
/*      */       } 
/*  187 */       return paramPage.setValue(i, paramObject2);
/*      */     } 
/*      */     
/*  190 */     if (i < 0) {
/*  191 */       i = -i - 1;
/*      */     } else {
/*  193 */       i++;
/*      */     } 
/*  195 */     Page page = paramPage.getChildPage(i).copy(paramLong);
/*  196 */     if (page.getMemory() > this.store.getPageSplitSize() && page.getKeyCount() > 1) {
/*      */       
/*  198 */       int j = page.getKeyCount() / 2;
/*  199 */       Object object1 = page.getKey(j);
/*  200 */       Page page1 = page.split(j);
/*  201 */       paramPage.setChild(i, page1);
/*  202 */       paramPage.insertNode(i, object1, page);
/*      */       
/*  204 */       return put(paramPage, paramLong, paramObject1, paramObject2);
/*      */     } 
/*  206 */     Object object = put(page, paramLong, paramObject1, paramObject2);
/*  207 */     paramPage.setChild(i, page);
/*  208 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K firstKey() {
/*  217 */     return getFirstLast(true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K lastKey() {
/*  226 */     return getFirstLast(false);
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
/*      */   public K getKey(long paramLong) {
/*  239 */     if (paramLong < 0L || paramLong >= size()) {
/*  240 */       return null;
/*      */     }
/*  242 */     Page page = this.root;
/*  243 */     long l = 0L;
/*      */     while (true) {
/*  245 */       if (page.isLeaf()) {
/*  246 */         if (paramLong >= l + page.getKeyCount()) {
/*  247 */           return null;
/*      */         }
/*  249 */         return (K)page.getKey((int)(paramLong - l));
/*      */       } 
/*  251 */       byte b = 0; int i = getChildPageCount(page);
/*  252 */       for (; b < i; b++) {
/*  253 */         long l1 = page.getCounts(b);
/*  254 */         if (paramLong < l1 + l) {
/*      */           break;
/*      */         }
/*  257 */         l += l1;
/*      */       } 
/*  259 */       if (b == i) {
/*  260 */         return null;
/*      */       }
/*  262 */       page = page.getChildPage(b);
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
/*      */   public List<K> keyList() {
/*  275 */     return new AbstractList<K>()
/*      */       {
/*      */         public K get(int param1Int)
/*      */         {
/*  279 */           return (K)MVMap.this.getKey(param1Int);
/*      */         }
/*      */ 
/*      */         
/*      */         public int size() {
/*  284 */           return MVMap.this.size();
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public int indexOf(Object param1Object) {
/*  290 */           return (int)MVMap.this.getKeyIndex(param1Object);
/*      */         }
/*      */       };
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
/*      */ 
/*      */ 
/*      */   
/*      */   public long getKeyIndex(K paramK) {
/*  309 */     if (size() == 0) {
/*  310 */       return -1L;
/*      */     }
/*  312 */     Page page = this.root;
/*  313 */     long l = 0L;
/*      */     while (true) {
/*  315 */       int i = page.binarySearch(paramK);
/*  316 */       if (page.isLeaf()) {
/*  317 */         if (i < 0) {
/*  318 */           return -l + i;
/*      */         }
/*  320 */         return l + i;
/*      */       } 
/*  322 */       if (i < 0) {
/*  323 */         i = -i - 1;
/*      */       } else {
/*  325 */         i++;
/*      */       } 
/*  327 */       for (byte b = 0; b < i; b++) {
/*  328 */         l += page.getCounts(b);
/*      */       }
/*  330 */       page = page.getChildPage(i);
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
/*      */   protected K getFirstLast(boolean paramBoolean) {
/*  342 */     if (size() == 0) {
/*  343 */       return null;
/*      */     }
/*  345 */     Page page = this.root;
/*      */     while (true) {
/*  347 */       if (page.isLeaf()) {
/*  348 */         return (K)page.getKey(paramBoolean ? 0 : (page.getKeyCount() - 1));
/*      */       }
/*  350 */       page = page.getChildPage(paramBoolean ? 0 : (getChildPageCount(page) - 1));
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
/*      */   public K higherKey(K paramK) {
/*  362 */     return getMinMax(paramK, false, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K ceilingKey(K paramK) {
/*  372 */     return getMinMax(paramK, false, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K floorKey(K paramK) {
/*  382 */     return getMinMax(paramK, true, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public K lowerKey(K paramK) {
/*  393 */     return getMinMax(paramK, true, true);
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
/*      */   protected K getMinMax(K paramK, boolean paramBoolean1, boolean paramBoolean2) {
/*  405 */     return getMinMax(this.root, paramK, paramBoolean1, paramBoolean2);
/*      */   }
/*      */ 
/*      */   
/*      */   private K getMinMax(Page paramPage, K paramK, boolean paramBoolean1, boolean paramBoolean2) {
/*  410 */     if (paramPage.isLeaf()) {
/*  411 */       int j = paramPage.binarySearch(paramK);
/*  412 */       if (j < 0) {
/*  413 */         j = -j - (paramBoolean1 ? 2 : 1);
/*  414 */       } else if (paramBoolean2) {
/*  415 */         j += paramBoolean1 ? -1 : 1;
/*      */       } 
/*  417 */       if (j < 0 || j >= paramPage.getKeyCount()) {
/*  418 */         return null;
/*      */       }
/*  420 */       return (K)paramPage.getKey(j);
/*      */     } 
/*  422 */     int i = paramPage.binarySearch(paramK);
/*  423 */     if (i < 0) {
/*  424 */       i = -i - 1;
/*      */     } else {
/*  426 */       i++;
/*      */     } 
/*      */     while (true) {
/*  429 */       if (i < 0 || i >= getChildPageCount(paramPage)) {
/*  430 */         return null;
/*      */       }
/*  432 */       K k = getMinMax(paramPage.getChildPage(i), paramK, paramBoolean1, paramBoolean2);
/*  433 */       if (k != null) {
/*  434 */         return k;
/*      */       }
/*  436 */       i += paramBoolean1 ? -1 : 1;
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
/*      */   public V get(Object paramObject) {
/*  450 */     return (V)binarySearch(this.root, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Object binarySearch(Page paramPage, Object paramObject) {
/*  461 */     int i = paramPage.binarySearch(paramObject);
/*  462 */     if (!paramPage.isLeaf()) {
/*  463 */       if (i < 0) {
/*  464 */         i = -i - 1;
/*      */       } else {
/*  466 */         i++;
/*      */       } 
/*  468 */       paramPage = paramPage.getChildPage(i);
/*  469 */       return binarySearch(paramPage, paramObject);
/*      */     } 
/*  471 */     if (i >= 0) {
/*  472 */       return paramPage.getValue(i);
/*      */     }
/*  474 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean containsKey(Object paramObject) {
/*  479 */     return (get(paramObject) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected Page binarySearchPage(Page paramPage, Object paramObject) {
/*  490 */     int i = paramPage.binarySearch(paramObject);
/*  491 */     if (!paramPage.isLeaf()) {
/*  492 */       if (i < 0) {
/*  493 */         i = -i - 1;
/*      */       } else {
/*  495 */         i++;
/*      */       } 
/*  497 */       paramPage = paramPage.getChildPage(i);
/*  498 */       return binarySearchPage(paramPage, paramObject);
/*      */     } 
/*  500 */     if (i >= 0) {
/*  501 */       return paramPage;
/*      */     }
/*  503 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public synchronized void clear() {
/*  511 */     beforeWrite();
/*  512 */     this.root.removeAllRecursive();
/*  513 */     newRoot(Page.createEmpty(this, this.writeVersion));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void close() {
/*  521 */     this.closed = true;
/*      */   }
/*      */   
/*      */   public boolean isClosed() {
/*  525 */     return this.closed;
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
/*      */   public V remove(Object paramObject) {
/*  537 */     beforeWrite();
/*  538 */     V v = get(paramObject);
/*  539 */     if (v == null) {
/*  540 */       return null;
/*      */     }
/*  542 */     long l = this.writeVersion;
/*  543 */     synchronized (this) {
/*  544 */       Page page = this.root.copy(l);
/*  545 */       v = (V)remove(page, l, paramObject);
/*  546 */       if (!page.isLeaf() && page.getTotalCount() == 0L) {
/*  547 */         page.removePage();
/*  548 */         page = Page.createEmpty(this, page.getVersion());
/*      */       } 
/*  550 */       newRoot(page);
/*      */     } 
/*  552 */     return v;
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
/*      */   public synchronized V putIfAbsent(K paramK, V paramV) {
/*  564 */     V v = get(paramK);
/*  565 */     if (v == null) {
/*  566 */       put(paramK, paramV);
/*      */     }
/*  568 */     return v;
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
/*      */   public synchronized boolean remove(Object paramObject1, Object paramObject2) {
/*  580 */     V v = get(paramObject1);
/*  581 */     if (areValuesEqual(v, paramObject2)) {
/*  582 */       remove(paramObject1);
/*  583 */       return true;
/*      */     } 
/*  585 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean areValuesEqual(Object paramObject1, Object paramObject2) {
/*  596 */     if (paramObject1 == paramObject2)
/*  597 */       return true; 
/*  598 */     if (paramObject1 == null || paramObject2 == null) {
/*  599 */       return false;
/*      */     }
/*  601 */     return (this.valueType.compare(paramObject1, paramObject2) == 0);
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
/*      */   public synchronized boolean replace(K paramK, V paramV1, V paramV2) {
/*  614 */     V v = get(paramK);
/*  615 */     if (areValuesEqual(v, paramV1)) {
/*  616 */       put(paramK, paramV2);
/*  617 */       return true;
/*      */     } 
/*  619 */     return false;
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
/*      */   public synchronized V replace(K paramK, V paramV) {
/*  631 */     V v = get(paramK);
/*  632 */     if (v != null) {
/*  633 */       put(paramK, paramV);
/*  634 */       return v;
/*      */     } 
/*  636 */     return null;
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
/*      */   protected Object remove(Page paramPage, long paramLong, Object paramObject) {
/*  648 */     int i = paramPage.binarySearch(paramObject);
/*  649 */     Object object = null;
/*  650 */     if (paramPage.isLeaf()) {
/*  651 */       if (i >= 0) {
/*  652 */         object = paramPage.getValue(i);
/*  653 */         paramPage.remove(i);
/*      */       } 
/*  655 */       return object;
/*      */     } 
/*      */     
/*  658 */     if (i < 0) {
/*  659 */       i = -i - 1;
/*      */     } else {
/*  661 */       i++;
/*      */     } 
/*  663 */     Page page1 = paramPage.getChildPage(i);
/*  664 */     Page page2 = page1.copy(paramLong);
/*  665 */     object = remove(page2, paramLong, paramObject);
/*  666 */     if (object == null || page2.getTotalCount() != 0L) {
/*      */ 
/*      */       
/*  669 */       paramPage.setChild(i, page2);
/*      */     
/*      */     }
/*  672 */     else if (paramPage.getKeyCount() == 0) {
/*  673 */       paramPage.setChild(i, page2);
/*  674 */       page2.removePage();
/*      */     } else {
/*  676 */       paramPage.remove(i);
/*      */     } 
/*      */     
/*  679 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void newRoot(Page paramPage) {
/*  688 */     if (this.root != paramPage) {
/*  689 */       removeUnusedOldVersions();
/*  690 */       if (this.root.getVersion() != paramPage.getVersion()) {
/*  691 */         Page page = this.oldRoots.peekLast();
/*  692 */         if (page == null || page.getVersion() != this.root.getVersion()) {
/*  693 */           this.oldRoots.add(this.root);
/*      */         }
/*      */       } 
/*  696 */       this.root = paramPage;
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
/*      */   int compare(Object paramObject1, Object paramObject2) {
/*  708 */     return this.keyType.compare(paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataType getKeyType() {
/*  717 */     return this.keyType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DataType getValueType() {
/*  726 */     return this.valueType;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Page readPage(long paramLong) {
/*  736 */     return this.store.readPage(this, paramLong);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setRootPos(long paramLong1, long paramLong2) {
/*  746 */     this.root = (paramLong1 == 0L) ? Page.createEmpty(this, -1L) : readPage(paramLong1);
/*  747 */     this.root.setVersion(paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<K> keyIterator(K paramK) {
/*  757 */     return new Cursor<>(this, this.root, paramK);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean rewrite(Set<Integer> paramSet) {
/*      */     MVMap<K, V> mVMap;
/*  768 */     long l = this.store.getCurrentVersion() - 1L;
/*  769 */     if (l < this.createVersion)
/*      */     {
/*  771 */       return true;
/*      */     }
/*      */     
/*      */     try {
/*  775 */       mVMap = openVersion(l);
/*  776 */     } catch (IllegalArgumentException illegalArgumentException) {
/*      */ 
/*      */       
/*  779 */       return true;
/*      */     } 
/*      */     try {
/*  782 */       rewrite(mVMap.root, paramSet);
/*  783 */       return true;
/*  784 */     } catch (IllegalStateException illegalStateException) {
/*      */       
/*  786 */       if (DataUtils.getErrorCode(illegalStateException.getMessage()) == 9)
/*      */       {
/*  788 */         return false;
/*      */       }
/*  790 */       throw illegalStateException;
/*      */     } 
/*      */   }
/*      */   
/*      */   private int rewrite(Page paramPage, Set<Integer> paramSet) {
/*  795 */     if (paramPage.isLeaf()) {
/*  796 */       long l = paramPage.getPos();
/*  797 */       int j = DataUtils.getPageChunkId(l);
/*  798 */       if (!paramSet.contains(Integer.valueOf(j))) {
/*  799 */         return 0;
/*      */       }
/*  801 */       if (paramPage.getKeyCount() > 0) {
/*      */         
/*  803 */         Object object = paramPage.getKey(0);
/*  804 */         V v = get(object);
/*  805 */         if (v != null) {
/*  806 */           replace((K)object, v, v);
/*      */         }
/*      */       } 
/*  809 */       return 1;
/*      */     } 
/*  811 */     int i = 0;
/*  812 */     for (byte b = 0; b < getChildPageCount(paramPage); b++) {
/*  813 */       long l = paramPage.getChildPagePos(b);
/*  814 */       if (l != 0L && DataUtils.getPageType(l) == 0) {
/*      */ 
/*      */ 
/*      */         
/*  818 */         int j = DataUtils.getPageChunkId(l);
/*  819 */         if (!paramSet.contains(Integer.valueOf(j))) {
/*      */           continue;
/*      */         }
/*      */       } 
/*  823 */       i += rewrite(paramPage.getChildPage(b), paramSet); continue;
/*      */     } 
/*  825 */     if (i == 0) {
/*  826 */       long l = paramPage.getPos();
/*  827 */       int j = DataUtils.getPageChunkId(l);
/*  828 */       if (paramSet.contains(Integer.valueOf(j))) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  835 */         Page page = paramPage;
/*  836 */         while (!page.isLeaf()) {
/*  837 */           page = page.getChildPage(0);
/*      */         }
/*      */         
/*  840 */         Object object = page.getKey(0);
/*  841 */         V v = get(object);
/*  842 */         if (v != null) {
/*  843 */           replace((K)object, v, v);
/*      */         }
/*  845 */         i++;
/*      */       } 
/*      */     } 
/*  848 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Cursor<K, V> cursor(K paramK) {
/*  858 */     return new Cursor<>(this, this.root, paramK);
/*      */   }
/*      */ 
/*      */   
/*      */   public Set<Map.Entry<K, V>> entrySet() {
/*  863 */     final MVMap map = this;
/*  864 */     final Page root = this.root;
/*  865 */     return new AbstractSet<Map.Entry<K, V>>()
/*      */       {
/*      */         public Iterator<Map.Entry<K, V>> iterator()
/*      */         {
/*  869 */           final Cursor<Object, Object> cursor = new Cursor<>(map, root, null);
/*  870 */           return new Iterator<Map.Entry<K, V>>()
/*      */             {
/*      */               public boolean hasNext()
/*      */               {
/*  874 */                 return cursor.hasNext();
/*      */               }
/*      */ 
/*      */               
/*      */               public Map.Entry<K, V> next() {
/*  879 */                 Object object = cursor.next();
/*  880 */                 return new DataUtils.MapEntry<>((K)object, (V)cursor.getValue());
/*      */               }
/*      */ 
/*      */               
/*      */               public void remove() {
/*  885 */                 throw DataUtils.newUnsupportedOperationException("Removing is not supported");
/*      */               }
/*      */             };
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public int size() {
/*  894 */           return MVMap.this.size();
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean contains(Object param1Object) {
/*  899 */           return MVMap.this.containsKey(param1Object);
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Set<K> keySet() {
/*  908 */     final MVMap map = this;
/*  909 */     final Page root = this.root;
/*  910 */     return new AbstractSet<K>()
/*      */       {
/*      */         public Iterator<K> iterator()
/*      */         {
/*  914 */           return new Cursor<>(map, root, null);
/*      */         }
/*      */ 
/*      */         
/*      */         public int size() {
/*  919 */           return MVMap.this.size();
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean contains(Object param1Object) {
/*  924 */           return MVMap.this.containsKey(param1Object);
/*      */         }
/*      */       };
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Page getRoot() {
/*  936 */     return this.root;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getName() {
/*  945 */     return this.store.getMapName(this.id);
/*      */   }
/*      */   
/*      */   public MVStore getStore() {
/*  949 */     return this.store;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getId() {
/*  959 */     return this.id;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void rollbackTo(long paramLong) {
/*  968 */     beforeWrite();
/*  969 */     if (paramLong > this.createVersion)
/*      */     {
/*  971 */       if (this.root.getVersion() >= paramLong) {
/*      */         do {
/*  973 */           Page page = this.oldRoots.peekLast();
/*  974 */           if (page == null) {
/*      */             break;
/*      */           }
/*      */           
/*  978 */           this.oldRoots.removeLast(page);
/*  979 */           this.root = page;
/*  980 */         } while (this.root.getVersion() >= paramLong);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void removeUnusedOldVersions() {
/*  991 */     long l = this.store.getOldestVersionToKeep();
/*  992 */     if (l == -1L) {
/*      */       return;
/*      */     }
/*  995 */     Page page = this.oldRoots.peekLast();
/*      */     while (true) {
/*  997 */       Page page1 = this.oldRoots.peekFirst();
/*  998 */       if (page1 == null || page1.getVersion() >= l || page1 == page) {
/*      */         break;
/*      */       }
/* 1001 */       this.oldRoots.removeFirst(page1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isReadOnly() {
/* 1006 */     return this.readOnly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setVolatile(boolean paramBoolean) {
/* 1015 */     this.isVolatile = paramBoolean;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isVolatile() {
/* 1026 */     return this.isVolatile;
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
/*      */   protected void beforeWrite() {
/* 1038 */     if (this.closed) {
/* 1039 */       throw DataUtils.newIllegalStateException(4, "This map is closed", new Object[0]);
/*      */     }
/*      */     
/* 1042 */     if (this.readOnly) {
/* 1043 */       throw DataUtils.newUnsupportedOperationException("This map is read-only");
/*      */     }
/*      */     
/* 1046 */     this.store.beforeWrite(this);
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1051 */     return this.id;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/* 1056 */     return (this == paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int size() {
/* 1067 */     long l = sizeAsLong();
/* 1068 */     return (l > 2147483647L) ? Integer.MAX_VALUE : (int)l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long sizeAsLong() {
/* 1077 */     return this.root.getTotalCount();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEmpty() {
/* 1083 */     return (this.root.isLeaf() && this.root.getKeyCount() == 0);
/*      */   }
/*      */   
/*      */   public long getCreateVersion() {
/* 1087 */     return this.createVersion;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removePage(long paramLong, int paramInt) {
/* 1097 */     this.store.removePage(this, paramLong, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MVMap<K, V> openVersion(long paramLong) {
/* 1107 */     if (this.readOnly) {
/* 1108 */       throw DataUtils.newUnsupportedOperationException("This map is read-only; need to call the method on the writable map");
/*      */     }
/*      */ 
/*      */     
/* 1112 */     DataUtils.checkArgument((paramLong >= this.createVersion), "Unknown version {0}; this map was created in version is {1}", new Object[] { Long.valueOf(paramLong), Long.valueOf(this.createVersion) });
/*      */ 
/*      */     
/* 1115 */     Page page1 = null;
/*      */     
/* 1117 */     Page page2 = this.root;
/* 1118 */     if (paramLong >= page2.getVersion() && (paramLong == this.writeVersion || page2.getVersion() >= 0L || paramLong <= this.createVersion || this.store.getFileStore() == null)) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1123 */       page1 = page2;
/*      */     } else {
/* 1125 */       Page page = this.oldRoots.peekFirst();
/* 1126 */       if (page == null || paramLong < page.getVersion())
/*      */       {
/* 1128 */         return this.store.openMapVersion(paramLong, this.id, this);
/*      */       }
/* 1130 */       Iterator<Page> iterator = this.oldRoots.iterator();
/* 1131 */       while (iterator.hasNext()) {
/* 1132 */         Page page3 = iterator.next();
/* 1133 */         if (page3.getVersion() > paramLong) {
/*      */           break;
/*      */         }
/* 1136 */         page = page3;
/*      */       } 
/* 1138 */       page1 = page;
/*      */     } 
/* 1140 */     MVMap<K, V> mVMap = openReadOnly();
/* 1141 */     mVMap.root = page1;
/* 1142 */     return mVMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   MVMap<K, V> openReadOnly() {
/* 1151 */     MVMap<K, V> mVMap = new MVMap(this.keyType, this.valueType);
/* 1152 */     mVMap.readOnly = true;
/* 1153 */     HashMap<String, Integer> hashMap = New.hashMap();
/* 1154 */     hashMap.put("id", Integer.valueOf(this.id));
/* 1155 */     hashMap.put("createVersion", Long.valueOf(this.createVersion));
/* 1156 */     mVMap.init(this.store, (HashMap)hashMap);
/* 1157 */     mVMap.root = this.root;
/* 1158 */     return mVMap;
/*      */   }
/*      */   
/*      */   public long getVersion() {
/* 1162 */     return this.root.getVersion();
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
/*      */   protected int getChildPageCount(Page paramPage) {
/* 1174 */     return paramPage.getRawChildPageCount();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getType() {
/* 1183 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String asString(String paramString) {
/* 1193 */     StringBuilder stringBuilder = new StringBuilder();
/* 1194 */     if (paramString != null) {
/* 1195 */       DataUtils.appendMap(stringBuilder, "name", paramString);
/*      */     }
/* 1197 */     if (this.createVersion != 0L) {
/* 1198 */       DataUtils.appendMap(stringBuilder, "createVersion", Long.valueOf(this.createVersion));
/*      */     }
/* 1200 */     String str = getType();
/* 1201 */     if (str != null) {
/* 1202 */       DataUtils.appendMap(stringBuilder, "type", str);
/*      */     }
/* 1204 */     return stringBuilder.toString();
/*      */   }
/*      */   
/*      */   void setWriteVersion(long paramLong) {
/* 1208 */     this.writeVersion = paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void copyFrom(MVMap<K, V> paramMVMap) {
/* 1217 */     beforeWrite();
/* 1218 */     newRoot(copy(paramMVMap.root, null));
/*      */   }
/*      */   
/*      */   private Page copy(Page paramPage, CursorPos paramCursorPos) {
/* 1222 */     Page page = Page.create(this, this.writeVersion, paramPage);
/* 1223 */     if (paramPage.isLeaf()) {
/* 1224 */       Page page1 = page;
/* 1225 */       for (CursorPos cursorPos = paramCursorPos; cursorPos != null; cursorPos = cursorPos.parent) {
/* 1226 */         cursorPos.page.setChild(cursorPos.index, page1);
/* 1227 */         cursorPos.page = cursorPos.page.copy(this.writeVersion);
/* 1228 */         page1 = cursorPos.page;
/* 1229 */         if (cursorPos.parent == null) {
/* 1230 */           newRoot(cursorPos.page);
/* 1231 */           beforeWrite();
/*      */         }
/*      */       
/*      */       } 
/*      */     } else {
/*      */       
/* 1237 */       for (byte b1 = 0; b1 < getChildPageCount(page); b1++) {
/* 1238 */         page.setChild(b1, null);
/*      */       }
/* 1240 */       CursorPos cursorPos = new CursorPos(page, 0, paramCursorPos);
/* 1241 */       for (byte b2 = 0; b2 < getChildPageCount(page); b2++) {
/* 1242 */         cursorPos.index = b2;
/* 1243 */         long l = paramPage.getChildPagePos(b2);
/* 1244 */         if (l != 0L)
/*      */         {
/*      */ 
/*      */           
/* 1248 */           copy(paramPage.getChildPage(b2), cursorPos);
/*      */         }
/*      */       } 
/* 1251 */       page = cursorPos.page;
/*      */     } 
/* 1253 */     return page;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1258 */     return asString(null);
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
/*      */   public static interface MapBuilder<M extends MVMap<K, V>, K, V>
/*      */   {
/*      */     M create();
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
/*      */   public static class Builder<K, V>
/*      */     implements MapBuilder<MVMap<K, V>, K, V>
/*      */   {
/*      */     protected DataType keyType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected DataType valueType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder<K, V> keyType(DataType param1DataType) {
/* 1304 */       this.keyType = param1DataType;
/* 1305 */       return this;
/*      */     }
/*      */     
/*      */     public DataType getKeyType() {
/* 1309 */       return this.keyType;
/*      */     }
/*      */     
/*      */     public DataType getValueType() {
/* 1313 */       return this.valueType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Builder<K, V> valueType(DataType param1DataType) {
/* 1323 */       this.valueType = param1DataType;
/* 1324 */       return this;
/*      */     }
/*      */ 
/*      */     
/*      */     public MVMap<K, V> create() {
/* 1329 */       if (this.keyType == null) {
/* 1330 */         this.keyType = (DataType)new ObjectDataType();
/*      */       }
/* 1332 */       if (this.valueType == null) {
/* 1333 */         this.valueType = (DataType)new ObjectDataType();
/*      */       }
/* 1335 */       return new MVMap<>(this.keyType, this.valueType);
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\MVMap.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */