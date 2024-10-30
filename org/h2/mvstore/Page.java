/*      */ package org.h2.mvstore;
/*      */ 
/*      */ import java.nio.ByteBuffer;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import org.h2.compress.Compressor;
/*      */ import org.h2.mvstore.type.DataType;
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
/*      */ public class Page
/*      */ {
/*   38 */   public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final MVMap<?, ?> map;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long version;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long pos;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private long totalCount;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int cachedCompare;
/*      */ 
/*      */ 
/*      */   
/*      */   private int memory;
/*      */ 
/*      */ 
/*      */   
/*      */   private Object[] keys;
/*      */ 
/*      */ 
/*      */   
/*      */   private Object[] values;
/*      */ 
/*      */ 
/*      */   
/*      */   private PageReference[] children;
/*      */ 
/*      */ 
/*      */   
/*      */   private volatile boolean removedInMemory;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Page(MVMap<?, ?> paramMVMap, long paramLong) {
/*   89 */     this.map = paramMVMap;
/*   90 */     this.version = paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Page createEmpty(MVMap<?, ?> paramMVMap, long paramLong) {
/*  101 */     return create(paramMVMap, paramLong, EMPTY_OBJECT_ARRAY, EMPTY_OBJECT_ARRAY, null, 0L, 128);
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Page create(MVMap<?, ?> paramMVMap, long paramLong1, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2, PageReference[] paramArrayOfPageReference, long paramLong2, int paramInt) {
/*  122 */     Page page = new Page(paramMVMap, paramLong1);
/*      */     
/*  124 */     page.keys = paramArrayOfObject1;
/*  125 */     page.values = paramArrayOfObject2;
/*  126 */     page.children = paramArrayOfPageReference;
/*  127 */     page.totalCount = paramLong2;
/*  128 */     if (paramInt == 0) {
/*  129 */       page.recalculateMemory();
/*      */     } else {
/*  131 */       page.addMemory(paramInt);
/*      */     } 
/*  133 */     MVStore mVStore = paramMVMap.store;
/*  134 */     if (mVStore != null) {
/*  135 */       mVStore.registerUnsavedPage(page.memory);
/*      */     }
/*  137 */     return page;
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
/*      */   public static Page create(MVMap<?, ?> paramMVMap, long paramLong, Page paramPage) {
/*  149 */     Page page = new Page(paramMVMap, paramLong);
/*      */     
/*  151 */     page.keys = paramPage.keys;
/*  152 */     page.values = paramPage.values;
/*  153 */     page.children = paramPage.children;
/*  154 */     page.totalCount = paramPage.totalCount;
/*  155 */     page.memory = paramPage.memory;
/*  156 */     MVStore mVStore = paramMVMap.store;
/*  157 */     if (mVStore != null) {
/*  158 */       mVStore.registerUnsavedPage(page.memory);
/*      */     }
/*  160 */     return page;
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
/*      */   static Page read(FileStore paramFileStore, long paramLong1, MVMap<?, ?> paramMVMap, long paramLong2, long paramLong3) {
/*  176 */     int i = DataUtils.getPageMaxLength(paramLong1);
/*  177 */     if (i == 2097152) {
/*  178 */       ByteBuffer byteBuffer1 = paramFileStore.readFully(paramLong2, 128);
/*  179 */       i = byteBuffer1.getInt();
/*      */     } 
/*      */     
/*  182 */     i = (int)Math.min(paramLong3 - paramLong2, i);
/*  183 */     int j = i;
/*  184 */     if (j < 0) {
/*  185 */       throw DataUtils.newIllegalStateException(6, "Illegal page length {0} reading at {1}; max pos {2} ", new Object[] { Integer.valueOf(j), Long.valueOf(paramLong2), Long.valueOf(paramLong3) });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  190 */     ByteBuffer byteBuffer = paramFileStore.readFully(paramLong2, j);
/*  191 */     Page page = new Page(paramMVMap, 0L);
/*  192 */     page.pos = paramLong1;
/*  193 */     int k = DataUtils.getPageChunkId(paramLong1);
/*  194 */     int m = DataUtils.getPageOffset(paramLong1);
/*  195 */     page.read(byteBuffer, k, m, i);
/*  196 */     return page;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getKey(int paramInt) {
/*  206 */     return this.keys[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Page getChildPage(int paramInt) {
/*  216 */     PageReference pageReference = this.children[paramInt];
/*  217 */     return (pageReference.page != null) ? pageReference.page : this.map.readPage(pageReference.pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getChildPagePos(int paramInt) {
/*  227 */     return (this.children[paramInt]).pos;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getValue(int paramInt) {
/*  237 */     return this.values[paramInt];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getKeyCount() {
/*  246 */     return this.keys.length;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLeaf() {
/*  255 */     return (this.children == null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getPos() {
/*  264 */     return this.pos;
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  269 */     StringBuilder stringBuilder = new StringBuilder();
/*  270 */     stringBuilder.append("id: ").append(System.identityHashCode(this)).append('\n');
/*  271 */     stringBuilder.append("version: ").append(Long.toHexString(this.version)).append("\n");
/*  272 */     stringBuilder.append("pos: ").append(Long.toHexString(this.pos)).append("\n");
/*  273 */     if (this.pos != 0L) {
/*  274 */       int i = DataUtils.getPageChunkId(this.pos);
/*  275 */       stringBuilder.append("chunk: ").append(Long.toHexString(i)).append("\n");
/*      */     } 
/*  277 */     for (byte b = 0; b <= this.keys.length; b++) {
/*  278 */       if (b > 0) {
/*  279 */         stringBuilder.append(" ");
/*      */       }
/*  281 */       if (this.children != null) {
/*  282 */         stringBuilder.append("[" + Long.toHexString((this.children[b]).pos) + "] ");
/*      */       }
/*  284 */       if (b < this.keys.length) {
/*  285 */         stringBuilder.append(this.keys[b]);
/*  286 */         if (this.values != null) {
/*  287 */           stringBuilder.append(':');
/*  288 */           stringBuilder.append(this.values[b]);
/*      */         } 
/*      */       } 
/*      */     } 
/*  292 */     return stringBuilder.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Page copy(long paramLong) {
/*  302 */     Page page = create(this.map, paramLong, this.keys, this.values, this.children, this.totalCount, getMemory());
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  307 */     removePage();
/*  308 */     page.cachedCompare = this.cachedCompare;
/*  309 */     return page;
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
/*      */   public int binarySearch(Object paramObject) {
/*  324 */     int i = 0, j = this.keys.length - 1;
/*      */ 
/*      */ 
/*      */     
/*  328 */     int k = this.cachedCompare - 1;
/*  329 */     if (k < 0 || k > j) {
/*  330 */       k = j >>> 1;
/*      */     }
/*  332 */     Object[] arrayOfObject = this.keys;
/*  333 */     while (i <= j) {
/*  334 */       int m = this.map.compare(paramObject, arrayOfObject[k]);
/*  335 */       if (m > 0) {
/*  336 */         i = k + 1;
/*  337 */       } else if (m < 0) {
/*  338 */         j = k - 1;
/*      */       } else {
/*  340 */         this.cachedCompare = k + 1;
/*  341 */         return k;
/*      */       } 
/*  343 */       k = i + j >>> 1;
/*      */     } 
/*  345 */     this.cachedCompare = i;
/*  346 */     return -(i + 1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Page split(int paramInt) {
/*  371 */     return isLeaf() ? splitLeaf(paramInt) : splitNode(paramInt);
/*      */   }
/*      */   
/*      */   private Page splitLeaf(int paramInt) {
/*  375 */     int i = paramInt, j = this.keys.length - i;
/*  376 */     Object[] arrayOfObject1 = new Object[i];
/*  377 */     Object[] arrayOfObject2 = new Object[j];
/*  378 */     System.arraycopy(this.keys, 0, arrayOfObject1, 0, i);
/*  379 */     System.arraycopy(this.keys, i, arrayOfObject2, 0, j);
/*  380 */     this.keys = arrayOfObject1;
/*  381 */     Object[] arrayOfObject3 = new Object[i];
/*  382 */     Object[] arrayOfObject4 = new Object[j];
/*  383 */     arrayOfObject4 = new Object[j];
/*  384 */     System.arraycopy(this.values, 0, arrayOfObject3, 0, i);
/*  385 */     System.arraycopy(this.values, i, arrayOfObject4, 0, j);
/*  386 */     this.values = arrayOfObject3;
/*  387 */     this.totalCount = i;
/*  388 */     Page page = create(this.map, this.version, arrayOfObject2, arrayOfObject4, null, arrayOfObject2.length, 0);
/*      */ 
/*      */ 
/*      */     
/*  392 */     recalculateMemory();
/*  393 */     page.recalculateMemory();
/*  394 */     return page;
/*      */   }
/*      */   
/*      */   private Page splitNode(int paramInt) {
/*  398 */     int i = paramInt, j = this.keys.length - i;
/*      */     
/*  400 */     Object[] arrayOfObject1 = new Object[i];
/*  401 */     Object[] arrayOfObject2 = new Object[j - 1];
/*  402 */     System.arraycopy(this.keys, 0, arrayOfObject1, 0, i);
/*  403 */     System.arraycopy(this.keys, i + 1, arrayOfObject2, 0, j - 1);
/*  404 */     this.keys = arrayOfObject1;
/*      */     
/*  406 */     PageReference[] arrayOfPageReference1 = new PageReference[i + 1];
/*  407 */     PageReference[] arrayOfPageReference2 = new PageReference[j];
/*  408 */     System.arraycopy(this.children, 0, arrayOfPageReference1, 0, i + 1);
/*  409 */     System.arraycopy(this.children, i + 1, arrayOfPageReference2, 0, j);
/*  410 */     this.children = arrayOfPageReference1;
/*      */     
/*  412 */     long l = 0L;
/*  413 */     for (PageReference pageReference : arrayOfPageReference1) {
/*  414 */       l += pageReference.count;
/*      */     }
/*  416 */     this.totalCount = l;
/*  417 */     l = 0L;
/*  418 */     for (PageReference pageReference : arrayOfPageReference2) {
/*  419 */       l += pageReference.count;
/*      */     }
/*  421 */     Page page = create(this.map, this.version, arrayOfObject2, null, arrayOfPageReference2, l, 0);
/*      */ 
/*      */ 
/*      */     
/*  425 */     recalculateMemory();
/*  426 */     page.recalculateMemory();
/*  427 */     return page;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public long getTotalCount() {
/*  451 */     return this.totalCount;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   long getCounts(int paramInt) {
/*  461 */     return (this.children[paramInt]).count;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setChild(int paramInt, Page paramPage) {
/*  471 */     if (paramPage == null) {
/*  472 */       long l = (this.children[paramInt]).count;
/*      */ 
/*      */       
/*  475 */       this.children = (PageReference[])this.children.clone();
/*  476 */       PageReference pageReference = new PageReference(null, 0L, 0L);
/*  477 */       this.children[paramInt] = pageReference;
/*  478 */       this.totalCount -= l;
/*  479 */     } else if (paramPage != (this.children[paramInt]).page || paramPage.getPos() != (this.children[paramInt]).pos) {
/*      */       
/*  481 */       long l = (this.children[paramInt]).count;
/*      */ 
/*      */       
/*  484 */       this.children = (PageReference[])this.children.clone();
/*  485 */       PageReference pageReference = new PageReference(paramPage, paramPage.pos, paramPage.totalCount);
/*  486 */       this.children[paramInt] = pageReference;
/*  487 */       this.totalCount += paramPage.totalCount - l;
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
/*      */   public void setKey(int paramInt, Object paramObject) {
/*  500 */     this.keys = (Object[])this.keys.clone();
/*  501 */     Object object = this.keys[paramInt];
/*  502 */     DataType dataType = this.map.getKeyType();
/*  503 */     int i = dataType.getMemory(paramObject);
/*  504 */     if (object != null) {
/*  505 */       i -= dataType.getMemory(object);
/*      */     }
/*  507 */     addMemory(i);
/*  508 */     this.keys[paramInt] = paramObject;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object setValue(int paramInt, Object paramObject) {
/*  519 */     Object object = this.values[paramInt];
/*      */ 
/*      */     
/*  522 */     this.values = (Object[])this.values.clone();
/*  523 */     DataType dataType = this.map.getValueType();
/*  524 */     addMemory(dataType.getMemory(paramObject) - dataType.getMemory(object));
/*      */     
/*  526 */     this.values[paramInt] = paramObject;
/*  527 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void removeAllRecursive() {
/*  534 */     if (this.children != null) {
/*  535 */       byte b; int i; for (b = 0, i = this.map.getChildPageCount(this); b < i; b++) {
/*  536 */         PageReference pageReference = this.children[b];
/*  537 */         if (pageReference.page != null) {
/*  538 */           pageReference.page.removeAllRecursive();
/*      */         } else {
/*  540 */           long l = (this.children[b]).pos;
/*  541 */           int j = DataUtils.getPageType(l);
/*  542 */           if (j == 0) {
/*  543 */             int k = DataUtils.getPageMaxLength(l);
/*  544 */             this.map.removePage(l, k);
/*      */           } else {
/*  546 */             this.map.readPage(l).removeAllRecursive();
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  551 */     removePage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void insertLeaf(int paramInt, Object paramObject1, Object paramObject2) {
/*  562 */     int i = this.keys.length + 1;
/*  563 */     Object[] arrayOfObject1 = new Object[i];
/*  564 */     DataUtils.copyWithGap(this.keys, arrayOfObject1, i - 1, paramInt);
/*  565 */     this.keys = arrayOfObject1;
/*  566 */     Object[] arrayOfObject2 = new Object[i];
/*  567 */     DataUtils.copyWithGap(this.values, arrayOfObject2, i - 1, paramInt);
/*  568 */     this.values = arrayOfObject2;
/*  569 */     this.keys[paramInt] = paramObject1;
/*  570 */     this.values[paramInt] = paramObject2;
/*  571 */     this.totalCount++;
/*  572 */     addMemory(this.map.getKeyType().getMemory(paramObject1) + this.map.getValueType().getMemory(paramObject2));
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
/*      */   public void insertNode(int paramInt, Object paramObject, Page paramPage) {
/*  585 */     Object[] arrayOfObject = new Object[this.keys.length + 1];
/*  586 */     DataUtils.copyWithGap(this.keys, arrayOfObject, this.keys.length, paramInt);
/*  587 */     arrayOfObject[paramInt] = paramObject;
/*  588 */     this.keys = arrayOfObject;
/*      */     
/*  590 */     int i = this.children.length;
/*  591 */     PageReference[] arrayOfPageReference = new PageReference[i + 1];
/*  592 */     DataUtils.copyWithGap(this.children, arrayOfPageReference, i, paramInt);
/*  593 */     arrayOfPageReference[paramInt] = new PageReference(paramPage, paramPage.getPos(), paramPage.totalCount);
/*      */     
/*  595 */     this.children = arrayOfPageReference;
/*      */     
/*  597 */     this.totalCount += paramPage.totalCount;
/*  598 */     addMemory(this.map.getKeyType().getMemory(paramObject) + 16);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void remove(int paramInt) {
/*  608 */     int i = this.keys.length;
/*  609 */     int j = (paramInt >= i) ? (paramInt - 1) : paramInt;
/*  610 */     Object object = this.keys[j];
/*  611 */     addMemory(-this.map.getKeyType().getMemory(object));
/*  612 */     Object[] arrayOfObject = new Object[i - 1];
/*  613 */     DataUtils.copyExcept(this.keys, arrayOfObject, i, j);
/*  614 */     this.keys = arrayOfObject;
/*      */     
/*  616 */     if (this.values != null) {
/*  617 */       object = this.values[paramInt];
/*  618 */       addMemory(-this.map.getValueType().getMemory(object));
/*  619 */       Object[] arrayOfObject1 = new Object[i - 1];
/*  620 */       DataUtils.copyExcept(this.values, arrayOfObject1, i, paramInt);
/*  621 */       this.values = arrayOfObject1;
/*  622 */       this.totalCount--;
/*      */     } 
/*  624 */     if (this.children != null) {
/*  625 */       addMemory(-16);
/*  626 */       long l = (this.children[paramInt]).count;
/*      */       
/*  628 */       int k = this.children.length;
/*  629 */       PageReference[] arrayOfPageReference = new PageReference[k - 1];
/*  630 */       DataUtils.copyExcept(this.children, arrayOfPageReference, k, paramInt);
/*  631 */       this.children = arrayOfPageReference;
/*      */       
/*  633 */       this.totalCount -= l;
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
/*      */   void read(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3) {
/*  646 */     int i = paramByteBuffer.position();
/*  647 */     int j = paramByteBuffer.getInt();
/*  648 */     if (j > paramInt3 || j < 4) {
/*  649 */       throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected page length 4..{1}, got {2}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt3), Integer.valueOf(j) });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  654 */     paramByteBuffer.limit(i + j);
/*  655 */     short s = paramByteBuffer.getShort();
/*  656 */     int k = DataUtils.readVarInt(paramByteBuffer);
/*  657 */     if (k != this.map.getId()) {
/*  658 */       throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected map id {1}, got {2}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(this.map.getId()), Integer.valueOf(k) });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  663 */     int m = DataUtils.getCheckValue(paramInt1) ^ DataUtils.getCheckValue(paramInt2) ^ DataUtils.getCheckValue(j);
/*      */ 
/*      */     
/*  666 */     if (s != (short)m) {
/*  667 */       throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected check value {1}, got {2}", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(m), Short.valueOf(s) });
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  672 */     int n = DataUtils.readVarInt(paramByteBuffer);
/*  673 */     this.keys = new Object[n];
/*  674 */     byte b = paramByteBuffer.get();
/*  675 */     boolean bool1 = ((b & 0x1) == 1) ? true : false;
/*  676 */     if (bool1) {
/*  677 */       this.children = new PageReference[n + 1];
/*  678 */       long[] arrayOfLong = new long[n + 1];
/*  679 */       for (byte b1 = 0; b1 <= n; b1++) {
/*  680 */         arrayOfLong[b1] = paramByteBuffer.getLong();
/*      */       }
/*  682 */       long l = 0L;
/*  683 */       for (byte b2 = 0; b2 <= n; b2++) {
/*  684 */         long l1 = DataUtils.readVarLong(paramByteBuffer);
/*  685 */         l += l1;
/*  686 */         this.children[b2] = new PageReference(null, arrayOfLong[b2], l1);
/*      */       } 
/*  688 */       this.totalCount = l;
/*      */     } 
/*  690 */     boolean bool2 = ((b & 0x2) != 0) ? true : false;
/*  691 */     if (bool2) {
/*      */       Compressor compressor;
/*  693 */       if ((b & 0x6) == 6) {
/*      */         
/*  695 */         compressor = this.map.getStore().getCompressorHigh();
/*      */       } else {
/*  697 */         compressor = this.map.getStore().getCompressorFast();
/*      */       } 
/*  699 */       int i1 = DataUtils.readVarInt(paramByteBuffer);
/*  700 */       int i2 = j + i - paramByteBuffer.position();
/*  701 */       byte[] arrayOfByte = DataUtils.newBytes(i2);
/*  702 */       paramByteBuffer.get(arrayOfByte);
/*  703 */       int i3 = i2 + i1;
/*  704 */       paramByteBuffer = ByteBuffer.allocate(i3);
/*  705 */       compressor.expand(arrayOfByte, 0, i2, paramByteBuffer.array(), paramByteBuffer.arrayOffset(), i3);
/*      */     } 
/*      */     
/*  708 */     this.map.getKeyType().read(paramByteBuffer, this.keys, n, true);
/*  709 */     if (!bool1) {
/*  710 */       this.values = new Object[n];
/*  711 */       this.map.getValueType().read(paramByteBuffer, this.values, n, false);
/*  712 */       this.totalCount = n;
/*      */     } 
/*  714 */     recalculateMemory();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private int write(Chunk paramChunk, WriteBuffer paramWriteBuffer) {
/*  725 */     int i = paramWriteBuffer.position();
/*  726 */     int j = this.keys.length;
/*  727 */     byte b = (this.children != null) ? 1 : 0;
/*      */     
/*  729 */     paramWriteBuffer.putInt(0).putShort((short)0).putVarInt(this.map.getId()).putVarInt(j);
/*      */ 
/*      */ 
/*      */     
/*  733 */     int k = paramWriteBuffer.position();
/*  734 */     paramWriteBuffer.put((byte)b);
/*  735 */     if (b == 1) {
/*  736 */       writeChildren(paramWriteBuffer);
/*  737 */       for (byte b1 = 0; b1 <= j; b1++) {
/*  738 */         paramWriteBuffer.putVarLong((this.children[b1]).count);
/*      */       }
/*      */     } 
/*  741 */     int m = paramWriteBuffer.position();
/*  742 */     this.map.getKeyType().write(paramWriteBuffer, this.keys, j, true);
/*  743 */     if (!b) {
/*  744 */       this.map.getValueType().write(paramWriteBuffer, this.values, j, false);
/*      */     }
/*  746 */     MVStore mVStore = this.map.getStore();
/*  747 */     int n = paramWriteBuffer.position() - m;
/*  748 */     if (n > 16) {
/*  749 */       int i4 = mVStore.getCompressionLevel();
/*  750 */       if (i4 > 0) {
/*      */         Compressor compressor;
/*      */         byte b1;
/*  753 */         if (i4 == 1) {
/*  754 */           compressor = this.map.getStore().getCompressorFast();
/*  755 */           b1 = 2;
/*      */         } else {
/*  757 */           compressor = this.map.getStore().getCompressorHigh();
/*  758 */           b1 = 6;
/*      */         } 
/*  760 */         byte[] arrayOfByte1 = new byte[n];
/*  761 */         paramWriteBuffer.position(m).get(arrayOfByte1);
/*  762 */         byte[] arrayOfByte2 = new byte[n * 2];
/*  763 */         int i5 = compressor.compress(arrayOfByte1, n, arrayOfByte2, 0);
/*  764 */         int i6 = DataUtils.getVarIntLen(i5 - n);
/*  765 */         if (i5 + i6 < n) {
/*  766 */           paramWriteBuffer.position(k).put((byte)(b + b1));
/*      */           
/*  768 */           paramWriteBuffer.position(m).putVarInt(n - i5).put(arrayOfByte2, 0, i5);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  774 */     int i1 = paramWriteBuffer.position() - i;
/*  775 */     int i2 = paramChunk.id;
/*  776 */     int i3 = DataUtils.getCheckValue(i2) ^ DataUtils.getCheckValue(i) ^ DataUtils.getCheckValue(i1);
/*      */ 
/*      */     
/*  779 */     paramWriteBuffer.putInt(i, i1).putShort(i + 4, (short)i3);
/*      */     
/*  781 */     if (this.pos != 0L) {
/*  782 */       throw DataUtils.newIllegalStateException(3, "Page already stored", new Object[0]);
/*      */     }
/*      */     
/*  785 */     this.pos = DataUtils.getPagePos(i2, i, i1, b);
/*  786 */     mVStore.cachePage(this.pos, this, getMemory());
/*  787 */     if (b == 1)
/*      */     {
/*      */       
/*  790 */       mVStore.cachePage(this.pos, this, getMemory());
/*      */     }
/*  792 */     long l = DataUtils.getPageMaxLength(this.pos);
/*  793 */     paramChunk.maxLen += l;
/*  794 */     paramChunk.maxLenLive += l;
/*  795 */     paramChunk.pageCount++;
/*  796 */     paramChunk.pageCountLive++;
/*  797 */     if (this.removedInMemory)
/*      */     {
/*      */ 
/*      */       
/*  801 */       this.map.removePage(this.pos, this.memory);
/*      */     }
/*  803 */     return k + 1;
/*      */   }
/*      */   
/*      */   private void writeChildren(WriteBuffer paramWriteBuffer) {
/*  807 */     int i = this.keys.length;
/*  808 */     for (byte b = 0; b <= i; b++) {
/*  809 */       paramWriteBuffer.putLong((this.children[b]).pos);
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
/*      */   void writeUnsavedRecursive(Chunk paramChunk, WriteBuffer paramWriteBuffer) {
/*  821 */     if (this.pos != 0L) {
/*      */       return;
/*      */     }
/*      */     
/*  825 */     int i = write(paramChunk, paramWriteBuffer);
/*  826 */     if (!isLeaf()) {
/*  827 */       int j = this.children.length; int k;
/*  828 */       for (k = 0; k < j; k++) {
/*  829 */         Page page = (this.children[k]).page;
/*  830 */         if (page != null) {
/*  831 */           page.writeUnsavedRecursive(paramChunk, paramWriteBuffer);
/*  832 */           this.children[k] = new PageReference(page, page.getPos(), page.totalCount);
/*      */         } 
/*      */       } 
/*  835 */       k = paramWriteBuffer.position();
/*  836 */       paramWriteBuffer.position(i);
/*  837 */       writeChildren(paramWriteBuffer);
/*  838 */       paramWriteBuffer.position(k);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void writeEnd() {
/*  846 */     if (isLeaf()) {
/*      */       return;
/*      */     }
/*  849 */     int i = this.children.length;
/*  850 */     for (byte b = 0; b < i; b++) {
/*  851 */       PageReference pageReference = this.children[b];
/*  852 */       if (pageReference.page != null) {
/*  853 */         if (pageReference.page.getPos() == 0L) {
/*  854 */           throw DataUtils.newIllegalStateException(3, "Page not written", new Object[0]);
/*      */         }
/*      */         
/*  857 */         pageReference.page.writeEnd();
/*  858 */         this.children[b] = new PageReference(null, pageReference.pos, pageReference.count);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   long getVersion() {
/*  864 */     return this.version;
/*      */   }
/*      */   
/*      */   public int getRawChildPageCount() {
/*  868 */     return this.children.length;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object paramObject) {
/*  873 */     if (paramObject == this) {
/*  874 */       return true;
/*      */     }
/*  876 */     if (paramObject instanceof Page) {
/*  877 */       if (this.pos != 0L && ((Page)paramObject).pos == this.pos) {
/*  878 */         return true;
/*      */       }
/*  880 */       return (this == paramObject);
/*      */     } 
/*  882 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int hashCode() {
/*  887 */     return (this.pos != 0L) ? (int)(this.pos | this.pos >>> 32L) : super.hashCode();
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
/*      */   public int getMemory() {
/*  899 */     return this.memory;
/*      */   }
/*      */   
/*      */   private void addMemory(int paramInt) {
/*  903 */     this.memory += paramInt;
/*      */   }
/*      */   
/*      */   private void recalculateMemory() {
/*  907 */     int i = 128;
/*  908 */     DataType dataType = this.map.getKeyType();
/*  909 */     for (byte b = 0; b < this.keys.length; b++) {
/*  910 */       i += dataType.getMemory(this.keys[b]);
/*      */     }
/*  912 */     if (isLeaf()) {
/*  913 */       DataType dataType1 = this.map.getValueType();
/*  914 */       for (byte b1 = 0; b1 < this.keys.length; b1++) {
/*  915 */         i += dataType1.getMemory(this.values[b1]);
/*      */       }
/*      */     } else {
/*  918 */       i += getRawChildPageCount() * 16;
/*      */     } 
/*  920 */     addMemory(i - this.memory);
/*      */   }
/*      */   
/*      */   void setVersion(long paramLong) {
/*  924 */     this.version = paramLong;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void removePage() {
/*  931 */     long l = this.pos;
/*  932 */     if (l == 0L) {
/*  933 */       this.removedInMemory = true;
/*      */     }
/*  935 */     this.map.removePage(l, this.memory);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class PageReference
/*      */   {
/*      */     final long pos;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final Page page;
/*      */ 
/*      */ 
/*      */     
/*      */     final long count;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public PageReference(Page param1Page, long param1Long1, long param1Long2) {
/*  959 */       this.page = param1Page;
/*  960 */       this.pos = param1Long1;
/*  961 */       this.count = param1Long2;
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
/*      */   public static class PageChildren
/*      */   {
/*  977 */     public static final long[] EMPTY_ARRAY = new long[0];
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     final long pos;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     long[] children;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean chunkList;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private PageChildren(long param1Long, long[] param1ArrayOflong) {
/*  998 */       this.pos = param1Long;
/*  999 */       this.children = param1ArrayOflong;
/*      */     }
/*      */     
/*      */     PageChildren(Page param1Page) {
/* 1003 */       this.pos = param1Page.getPos();
/* 1004 */       int i = param1Page.getRawChildPageCount();
/* 1005 */       this.children = new long[i];
/* 1006 */       for (byte b = 0; b < i; b++) {
/* 1007 */         this.children[b] = param1Page.getChildPagePos(b);
/*      */       }
/*      */     }
/*      */     
/*      */     int getMemory() {
/* 1012 */       return 64 + 8 * this.children.length;
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
/*      */     static PageChildren read(FileStore param1FileStore, long param1Long1, int param1Int, long param1Long2, long param1Long3) {
/* 1029 */       int i = DataUtils.getPageMaxLength(param1Long1);
/* 1030 */       if (i == 2097152) {
/* 1031 */         ByteBuffer byteBuffer1 = param1FileStore.readFully(param1Long2, 128);
/* 1032 */         i = byteBuffer1.getInt();
/*      */       } 
/*      */       
/* 1035 */       i = (int)Math.min(param1Long3 - param1Long2, i);
/* 1036 */       int j = i;
/* 1037 */       if (j < 0) {
/* 1038 */         throw DataUtils.newIllegalStateException(6, "Illegal page length {0} reading at {1}; max pos {2} ", new Object[] { Integer.valueOf(j), Long.valueOf(param1Long2), Long.valueOf(param1Long3) });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1043 */       ByteBuffer byteBuffer = param1FileStore.readFully(param1Long2, j);
/* 1044 */       int k = DataUtils.getPageChunkId(param1Long1);
/* 1045 */       int m = DataUtils.getPageOffset(param1Long1);
/* 1046 */       int n = byteBuffer.position();
/* 1047 */       int i1 = byteBuffer.getInt();
/* 1048 */       if (i1 > i) {
/* 1049 */         throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected page length =< {1}, got {2}", new Object[] { Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(i1) });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1054 */       byteBuffer.limit(n + i1);
/* 1055 */       short s = byteBuffer.getShort();
/* 1056 */       int i2 = DataUtils.readVarInt(byteBuffer);
/* 1057 */       if (i2 != param1Int) {
/* 1058 */         throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected map id {1}, got {2}", new Object[] { Integer.valueOf(k), Integer.valueOf(param1Int), Integer.valueOf(i2) });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1063 */       int i3 = DataUtils.getCheckValue(k) ^ DataUtils.getCheckValue(m) ^ DataUtils.getCheckValue(i1);
/*      */ 
/*      */       
/* 1066 */       if (s != (short)i3) {
/* 1067 */         throw DataUtils.newIllegalStateException(6, "File corrupted in chunk {0}, expected check value {1}, got {2}", new Object[] { Integer.valueOf(k), Integer.valueOf(i3), Short.valueOf(s) });
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1072 */       int i4 = DataUtils.readVarInt(byteBuffer);
/* 1073 */       byte b = byteBuffer.get();
/* 1074 */       boolean bool = ((b & 0x1) == 1) ? true : false;
/* 1075 */       if (!bool) {
/* 1076 */         return null;
/*      */       }
/* 1078 */       long[] arrayOfLong = new long[i4 + 1];
/* 1079 */       for (byte b1 = 0; b1 <= i4; b1++) {
/* 1080 */         arrayOfLong[b1] = byteBuffer.getLong();
/*      */       }
/* 1082 */       return new PageChildren(param1Long1, arrayOfLong);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void removeDuplicateChunkReferences() {
/* 1091 */       HashSet<Integer> hashSet = New.hashSet();
/*      */       
/* 1093 */       hashSet.add(Integer.valueOf(DataUtils.getPageChunkId(this.pos)));
/* 1094 */       for (byte b = 0; b < this.children.length; b++) {
/* 1095 */         long l = this.children[b];
/* 1096 */         int i = DataUtils.getPageChunkId(l);
/* 1097 */         boolean bool = hashSet.add(Integer.valueOf(i));
/* 1098 */         if (DataUtils.getPageType(l) != 1)
/*      */         {
/*      */           
/* 1101 */           if (!bool)
/*      */           {
/*      */             
/* 1104 */             removeChild(b--);
/*      */           }
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void collectReferencedChunks(Set<Integer> param1Set) {
/* 1114 */       param1Set.add(Integer.valueOf(DataUtils.getPageChunkId(this.pos)));
/* 1115 */       for (long l : this.children) {
/* 1116 */         param1Set.add(Integer.valueOf(DataUtils.getPageChunkId(l)));
/*      */       }
/*      */     }
/*      */     
/*      */     private void removeChild(int param1Int) {
/* 1121 */       if (param1Int == 0 && this.children.length == 1) {
/* 1122 */         this.children = EMPTY_ARRAY;
/*      */         return;
/*      */       } 
/* 1125 */       long[] arrayOfLong = new long[this.children.length - 1];
/* 1126 */       DataUtils.copyExcept(this.children, arrayOfLong, this.children.length, param1Int);
/* 1127 */       this.children = arrayOfLong;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\mvstore\Page.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */