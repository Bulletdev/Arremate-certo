/*     */ package org.h2.index;
/*     */ 
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.value.Value;
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
/*     */ public class PageDataLeaf
/*     */   extends PageData
/*     */ {
/*     */   private final boolean optimizeUpdate;
/*     */   private int[] offsets;
/*     */   private Row[] rows;
/*     */   private SoftReference<Row> rowRef;
/*     */   private int firstOverflowPageId;
/*     */   private int start;
/*     */   private int overflowRowSize;
/*     */   private int columnCount;
/*     */   private int memoryData;
/*     */   private boolean writtenData;
/*     */   
/*     */   private PageDataLeaf(PageDataIndex paramPageDataIndex, int paramInt, Data paramData) {
/*  77 */     super(paramPageDataIndex, paramInt, paramData);
/*  78 */     this.optimizeUpdate = (paramPageDataIndex.getDatabase().getSettings()).optimizeUpdate;
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
/*     */   static PageDataLeaf create(PageDataIndex paramPageDataIndex, int paramInt1, int paramInt2) {
/*  90 */     PageDataLeaf pageDataLeaf = new PageDataLeaf(paramPageDataIndex, paramInt1, paramPageDataIndex.getPageStore().createData());
/*     */     
/*  92 */     paramPageDataIndex.getPageStore().logUndo(pageDataLeaf, null);
/*  93 */     pageDataLeaf.rows = Row.EMPTY_ARRAY;
/*  94 */     pageDataLeaf.parentPageId = paramInt2;
/*  95 */     pageDataLeaf.columnCount = (paramPageDataIndex.getTable().getColumns()).length;
/*  96 */     pageDataLeaf.writeHead();
/*  97 */     pageDataLeaf.start = pageDataLeaf.data.length();
/*  98 */     return pageDataLeaf;
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
/*     */   public static Page read(PageDataIndex paramPageDataIndex, Data paramData, int paramInt) {
/* 110 */     PageDataLeaf pageDataLeaf = new PageDataLeaf(paramPageDataIndex, paramInt, paramData);
/* 111 */     pageDataLeaf.read();
/* 112 */     return pageDataLeaf;
/*     */   }
/*     */   
/*     */   private void read() {
/* 116 */     this.data.reset();
/* 117 */     byte b = this.data.readByte();
/* 118 */     this.data.readShortInt();
/* 119 */     this.parentPageId = this.data.readInt();
/* 120 */     int i = this.data.readVarInt();
/* 121 */     if (i != this.index.getId()) {
/* 122 */       throw DbException.get(90030, "page:" + getPos() + " expected table:" + this.index.getId() + " got:" + i + " type:" + b);
/*     */     }
/*     */ 
/*     */     
/* 126 */     this.columnCount = this.data.readVarInt();
/* 127 */     this.entryCount = this.data.readShortInt();
/* 128 */     this.offsets = new int[this.entryCount];
/* 129 */     this.keys = new long[this.entryCount];
/* 130 */     this.rows = new Row[this.entryCount];
/* 131 */     if (b == 1) {
/* 132 */       if (this.entryCount != 1) {
/* 133 */         DbException.throwInternalError("entries: " + this.entryCount);
/*     */       }
/* 135 */       this.firstOverflowPageId = this.data.readInt();
/*     */     } 
/* 137 */     for (byte b1 = 0; b1 < this.entryCount; b1++) {
/* 138 */       this.keys[b1] = this.data.readVarLong();
/* 139 */       this.offsets[b1] = this.data.readShortInt();
/*     */     } 
/* 141 */     this.start = this.data.length();
/* 142 */     this.written = true;
/* 143 */     this.writtenData = true;
/*     */   }
/*     */   
/*     */   private int getRowLength(Row paramRow) {
/* 147 */     int i = 0;
/* 148 */     for (byte b = 0; b < this.columnCount; b++) {
/* 149 */       i += this.data.getValueLen(paramRow.getValue(b));
/*     */     }
/* 151 */     return i;
/*     */   }
/*     */   
/*     */   private int findInsertionPoint(long paramLong) {
/* 155 */     int i = find(paramLong);
/* 156 */     if (i < this.entryCount && this.keys[i] == paramLong) {
/* 157 */       throw this.index.getDuplicateKeyException("" + paramLong);
/*     */     }
/* 159 */     return i;
/*     */   }
/*     */   
/*     */   int addRowTry(Row paramRow) {
/*     */     int n;
/* 164 */     this.index.getPageStore().logUndo(this, this.data);
/* 165 */     int i = getRowLength(paramRow);
/* 166 */     int j = this.index.getPageStore().getPageSize();
/* 167 */     int k = (this.entryCount == 0) ? j : this.offsets[this.entryCount - 1];
/* 168 */     int m = 2 + Data.getVarLongLen(paramRow.getKey());
/* 169 */     if (this.entryCount > 0 && k - i < this.start + m) {
/* 170 */       n = findInsertionPoint(paramRow.getKey());
/* 171 */       if (this.entryCount > 1) {
/* 172 */         if (this.entryCount < 5)
/*     */         {
/* 174 */           return this.entryCount / 2;
/*     */         }
/* 176 */         if (this.index.isSortedInsertMode()) {
/* 177 */           return (n < 2) ? 1 : ((n > this.entryCount - 1) ? (this.entryCount - 1) : n);
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 182 */         int i2 = this.entryCount / 3;
/* 183 */         return (n < i2) ? i2 : ((n >= 2 * i2) ? (2 * i2) : n);
/*     */       } 
/* 185 */       return n;
/*     */     } 
/* 187 */     this.index.getPageStore().logUndo(this, this.data);
/*     */     
/* 189 */     if (this.entryCount == 0) {
/* 190 */       n = 0;
/*     */     } else {
/* 192 */       if (!this.optimizeUpdate) {
/* 193 */         readAllRows();
/*     */       }
/* 195 */       n = findInsertionPoint(paramRow.getKey());
/*     */     } 
/* 197 */     this.written = false;
/* 198 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 199 */     k = (n == 0) ? j : this.offsets[n - 1];
/* 200 */     int i1 = k - i;
/* 201 */     this.start += m;
/* 202 */     this.offsets = insert(this.offsets, this.entryCount, n, i1);
/* 203 */     add(this.offsets, n + 1, this.entryCount + 1, -i);
/* 204 */     this.keys = insert(this.keys, this.entryCount, n, paramRow.getKey());
/* 205 */     this.rows = (Row[])insert((Object[])this.rows, this.entryCount, n, paramRow);
/* 206 */     this.entryCount++;
/* 207 */     this.index.getPageStore().update(this);
/* 208 */     if (this.optimizeUpdate && 
/* 209 */       this.writtenData && i1 >= this.start) {
/* 210 */       byte[] arrayOfByte = this.data.getBytes();
/* 211 */       int i2 = this.offsets[this.entryCount - 1] + i;
/* 212 */       int i3 = this.offsets[n];
/* 213 */       System.arraycopy(arrayOfByte, i2, arrayOfByte, i2 - i, i3 - i2 + i);
/*     */       
/* 215 */       this.data.setPos(i3);
/* 216 */       for (byte b = 0; b < this.columnCount; b++) {
/* 217 */         this.data.writeValue(paramRow.getValue(b));
/*     */       }
/*     */     } 
/*     */     
/* 221 */     if (i1 < this.start) {
/* 222 */       this.writtenData = false;
/* 223 */       if (this.entryCount > 1) {
/* 224 */         DbException.throwInternalError();
/*     */       }
/*     */       
/* 227 */       this.start += 4;
/* 228 */       int i2 = i - j - this.start;
/*     */       
/* 230 */       i1 = this.start;
/* 231 */       this.offsets[n] = i1;
/* 232 */       int i3 = getPos();
/* 233 */       int i4 = j;
/* 234 */       int i5 = this.index.getPageStore().allocatePage();
/* 235 */       this.firstOverflowPageId = i5;
/* 236 */       this.overflowRowSize = j + i;
/* 237 */       writeData();
/*     */       
/* 239 */       Row row = this.rows[0];
/* 240 */       this.rowRef = new SoftReference<>(row);
/* 241 */       this.rows[0] = null;
/* 242 */       Data data = this.index.getPageStore().createData();
/* 243 */       data.checkCapacity(this.data.length());
/* 244 */       data.write(this.data.getBytes(), 0, this.data.length());
/* 245 */       this.data.truncate(this.index.getPageStore().getPageSize()); do {
/*     */         byte b;
/*     */         int i6, i7;
/* 248 */         if (i2 <= j - 9) {
/* 249 */           b = 19;
/* 250 */           i6 = i2;
/* 251 */           i7 = 0;
/*     */         } else {
/* 253 */           b = 3;
/* 254 */           i6 = j - 11;
/* 255 */           i7 = this.index.getPageStore().allocatePage();
/*     */         } 
/* 257 */         PageDataOverflow pageDataOverflow = PageDataOverflow.create(this.index.getPageStore(), i5, b, i3, i7, data, i4, i6);
/*     */         
/* 259 */         this.index.getPageStore().update(pageDataOverflow);
/* 260 */         i4 += i6;
/* 261 */         i2 -= i6;
/* 262 */         i3 = i5;
/* 263 */         i5 = i7;
/* 264 */       } while (i2 > 0);
/*     */     } 
/* 266 */     if (this.rowRef == null) {
/* 267 */       memoryChange(true, paramRow);
/*     */     } else {
/* 269 */       memoryChange(true, (Row)null);
/*     */     } 
/* 271 */     return -1;
/*     */   }
/*     */   
/*     */   private void removeRow(int paramInt) {
/* 275 */     this.index.getPageStore().logUndo(this, this.data);
/* 276 */     this.written = false;
/* 277 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 278 */     if (!this.optimizeUpdate) {
/* 279 */       readAllRows();
/*     */     }
/* 281 */     Row row = getRowAt(paramInt);
/* 282 */     if (row != null) {
/* 283 */       memoryChange(false, row);
/*     */     }
/* 285 */     this.entryCount--;
/* 286 */     if (this.entryCount < 0) {
/* 287 */       DbException.throwInternalError();
/*     */     }
/* 289 */     if (this.firstOverflowPageId != 0) {
/* 290 */       this.start -= 4;
/* 291 */       freeOverflow();
/* 292 */       this.firstOverflowPageId = 0;
/* 293 */       this.overflowRowSize = 0;
/* 294 */       this.rowRef = null;
/*     */     } 
/* 296 */     int i = 2 + Data.getVarLongLen(this.keys[paramInt]);
/* 297 */     int j = (paramInt > 0) ? this.offsets[paramInt - 1] : this.index.getPageStore().getPageSize();
/* 298 */     int k = j - this.offsets[paramInt];
/* 299 */     if (this.optimizeUpdate) {
/* 300 */       if (this.writtenData) {
/* 301 */         byte[] arrayOfByte = this.data.getBytes();
/* 302 */         int m = this.offsets[this.entryCount];
/* 303 */         System.arraycopy(arrayOfByte, m, arrayOfByte, m + k, this.offsets[paramInt] - m);
/*     */         
/* 305 */         Arrays.fill(arrayOfByte, m, m + k, (byte)0);
/*     */       } 
/*     */     } else {
/* 308 */       int m = this.offsets[this.entryCount];
/* 309 */       Arrays.fill(this.data.getBytes(), m, m + k, (byte)0);
/*     */     } 
/* 311 */     this.start -= i;
/* 312 */     this.offsets = remove(this.offsets, this.entryCount + 1, paramInt);
/* 313 */     add(this.offsets, paramInt, this.entryCount, k);
/* 314 */     this.keys = remove(this.keys, this.entryCount + 1, paramInt);
/* 315 */     this.rows = (Row[])remove((Object[])this.rows, this.entryCount + 1, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   Cursor find(Session paramSession, long paramLong1, long paramLong2, boolean paramBoolean) {
/* 320 */     int i = find(paramLong1);
/* 321 */     return new PageDataCursor(paramSession, this, i, paramLong2, paramBoolean);
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
/*     */   Row getRowAt(int paramInt) {
/*     */     // Byte code:
/*     */     //   0: aload_0
/*     */     //   1: getfield rows : [Lorg/h2/result/Row;
/*     */     //   4: iload_1
/*     */     //   5: aaload
/*     */     //   6: astore_2
/*     */     //   7: aload_2
/*     */     //   8: ifnonnull -> 213
/*     */     //   11: aload_0
/*     */     //   12: getfield firstOverflowPageId : I
/*     */     //   15: ifne -> 40
/*     */     //   18: aload_0
/*     */     //   19: aload_0
/*     */     //   20: getfield data : Lorg/h2/store/Data;
/*     */     //   23: aload_0
/*     */     //   24: getfield offsets : [I
/*     */     //   27: iload_1
/*     */     //   28: iaload
/*     */     //   29: aload_0
/*     */     //   30: getfield columnCount : I
/*     */     //   33: invokespecial readRow : (Lorg/h2/store/Data;II)Lorg/h2/result/Row;
/*     */     //   36: astore_2
/*     */     //   37: goto -> 166
/*     */     //   40: aload_0
/*     */     //   41: getfield rowRef : Ljava/lang/ref/SoftReference;
/*     */     //   44: ifnull -> 64
/*     */     //   47: aload_0
/*     */     //   48: getfield rowRef : Ljava/lang/ref/SoftReference;
/*     */     //   51: invokevirtual get : ()Ljava/lang/Object;
/*     */     //   54: checkcast org/h2/result/Row
/*     */     //   57: astore_2
/*     */     //   58: aload_2
/*     */     //   59: ifnull -> 64
/*     */     //   62: aload_2
/*     */     //   63: areturn
/*     */     //   64: aload_0
/*     */     //   65: getfield index : Lorg/h2/index/PageDataIndex;
/*     */     //   68: invokevirtual getPageStore : ()Lorg/h2/store/PageStore;
/*     */     //   71: astore_3
/*     */     //   72: aload_3
/*     */     //   73: invokevirtual createData : ()Lorg/h2/store/Data;
/*     */     //   76: astore #4
/*     */     //   78: aload_3
/*     */     //   79: invokevirtual getPageSize : ()I
/*     */     //   82: istore #5
/*     */     //   84: aload_0
/*     */     //   85: getfield offsets : [I
/*     */     //   88: iload_1
/*     */     //   89: iaload
/*     */     //   90: istore #6
/*     */     //   92: aload #4
/*     */     //   94: aload_0
/*     */     //   95: getfield data : Lorg/h2/store/Data;
/*     */     //   98: invokevirtual getBytes : ()[B
/*     */     //   101: iload #6
/*     */     //   103: iload #5
/*     */     //   105: iload #6
/*     */     //   107: isub
/*     */     //   108: invokevirtual write : ([BII)V
/*     */     //   111: aload_0
/*     */     //   112: getfield firstOverflowPageId : I
/*     */     //   115: istore #7
/*     */     //   117: aload_0
/*     */     //   118: getfield index : Lorg/h2/index/PageDataIndex;
/*     */     //   121: iload #7
/*     */     //   123: invokevirtual getPageOverflow : (I)Lorg/h2/index/PageDataOverflow;
/*     */     //   126: astore #8
/*     */     //   128: aload #8
/*     */     //   130: aload #4
/*     */     //   132: invokevirtual readInto : (Lorg/h2/store/Data;)I
/*     */     //   135: istore #7
/*     */     //   137: iload #7
/*     */     //   139: ifne -> 117
/*     */     //   142: aload_0
/*     */     //   143: iload #5
/*     */     //   145: aload #4
/*     */     //   147: invokevirtual length : ()I
/*     */     //   150: iadd
/*     */     //   151: putfield overflowRowSize : I
/*     */     //   154: aload_0
/*     */     //   155: aload #4
/*     */     //   157: iconst_0
/*     */     //   158: aload_0
/*     */     //   159: getfield columnCount : I
/*     */     //   162: invokespecial readRow : (Lorg/h2/store/Data;II)Lorg/h2/result/Row;
/*     */     //   165: astore_2
/*     */     //   166: aload_2
/*     */     //   167: aload_0
/*     */     //   168: getfield keys : [J
/*     */     //   171: iload_1
/*     */     //   172: laload
/*     */     //   173: invokeinterface setKey : (J)V
/*     */     //   178: aload_0
/*     */     //   179: getfield firstOverflowPageId : I
/*     */     //   182: ifeq -> 200
/*     */     //   185: aload_0
/*     */     //   186: new java/lang/ref/SoftReference
/*     */     //   189: dup
/*     */     //   190: aload_2
/*     */     //   191: invokespecial <init> : (Ljava/lang/Object;)V
/*     */     //   194: putfield rowRef : Ljava/lang/ref/SoftReference;
/*     */     //   197: goto -> 213
/*     */     //   200: aload_0
/*     */     //   201: getfield rows : [Lorg/h2/result/Row;
/*     */     //   204: iload_1
/*     */     //   205: aload_2
/*     */     //   206: aastore
/*     */     //   207: aload_0
/*     */     //   208: iconst_1
/*     */     //   209: aload_2
/*     */     //   210: invokespecial memoryChange : (ZLorg/h2/result/Row;)V
/*     */     //   213: aload_2
/*     */     //   214: areturn
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #331	-> 0
/*     */     //   #332	-> 7
/*     */     //   #333	-> 11
/*     */     //   #334	-> 18
/*     */     //   #336	-> 40
/*     */     //   #337	-> 47
/*     */     //   #338	-> 58
/*     */     //   #339	-> 62
/*     */     //   #342	-> 64
/*     */     //   #343	-> 72
/*     */     //   #344	-> 78
/*     */     //   #345	-> 84
/*     */     //   #346	-> 92
/*     */     //   #347	-> 111
/*     */     //   #349	-> 117
/*     */     //   #350	-> 128
/*     */     //   #351	-> 137
/*     */     //   #352	-> 142
/*     */     //   #353	-> 154
/*     */     //   #355	-> 166
/*     */     //   #356	-> 178
/*     */     //   #357	-> 185
/*     */     //   #359	-> 200
/*     */     //   #360	-> 207
/*     */     //   #363	-> 213
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
/*     */   int getEntryCount() {
/* 367 */     return this.entryCount;
/*     */   }
/*     */ 
/*     */   
/*     */   PageData split(int paramInt) {
/* 372 */     int i = this.index.getPageStore().allocatePage();
/* 373 */     PageDataLeaf pageDataLeaf = create(this.index, i, this.parentPageId);
/* 374 */     for (int j = paramInt; j < this.entryCount; ) {
/* 375 */       int k = pageDataLeaf.addRowTry(getRowAt(paramInt));
/* 376 */       if (k != -1) {
/* 377 */         DbException.throwInternalError("split " + k);
/*     */       }
/* 379 */       removeRow(paramInt);
/*     */     } 
/* 381 */     return pageDataLeaf;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   long getLastKey() {
/* 387 */     if (this.entryCount == 0) {
/* 388 */       return 0L;
/*     */     }
/* 390 */     return getRowAt(this.entryCount - 1).getKey();
/*     */   }
/*     */   
/*     */   PageDataLeaf getNextPage() {
/* 394 */     if (this.parentPageId == 0) {
/* 395 */       return null;
/*     */     }
/* 397 */     PageDataNode pageDataNode = (PageDataNode)this.index.getPage(this.parentPageId, -1);
/* 398 */     return pageDataNode.getNextPage(this.keys[this.entryCount - 1]);
/*     */   }
/*     */ 
/*     */   
/*     */   PageDataLeaf getFirstLeaf() {
/* 403 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void remapChildren(int paramInt) {
/* 408 */     if (this.firstOverflowPageId == 0) {
/*     */       return;
/*     */     }
/* 411 */     PageDataOverflow pageDataOverflow = this.index.getPageOverflow(this.firstOverflowPageId);
/* 412 */     pageDataOverflow.setParentPageId(getPos());
/* 413 */     this.index.getPageStore().update(pageDataOverflow);
/*     */   }
/*     */ 
/*     */   
/*     */   boolean remove(long paramLong) {
/* 418 */     int i = find(paramLong);
/* 419 */     if (this.keys == null || this.keys[i] != paramLong) {
/* 420 */       throw DbException.get(90112, this.index.getSQL() + ": " + paramLong + " " + ((this.keys == null) ? -1L : this.keys[i]));
/*     */     }
/*     */     
/* 423 */     this.index.getPageStore().logUndo(this, this.data);
/* 424 */     if (this.entryCount == 1) {
/* 425 */       freeRecursive();
/* 426 */       return true;
/*     */     } 
/* 428 */     removeRow(i);
/* 429 */     this.index.getPageStore().update(this);
/* 430 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void freeRecursive() {
/* 435 */     this.index.getPageStore().logUndo(this, this.data);
/* 436 */     this.index.getPageStore().free(getPos());
/* 437 */     freeOverflow();
/*     */   }
/*     */   
/*     */   private void freeOverflow() {
/* 441 */     if (this.firstOverflowPageId != 0) {
/* 442 */       int i = this.firstOverflowPageId;
/*     */       do {
/* 444 */         PageDataOverflow pageDataOverflow = this.index.getPageOverflow(i);
/* 445 */         pageDataOverflow.free();
/* 446 */         i = pageDataOverflow.getNextOverflow();
/* 447 */       } while (i != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Row getRowWithKey(long paramLong) {
/* 453 */     int i = find(paramLong);
/* 454 */     return getRowAt(i);
/*     */   }
/*     */ 
/*     */   
/*     */   int getRowCount() {
/* 459 */     return this.entryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setRowCountStored(int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   long getDiskSpaceUsed() {
/* 469 */     return this.index.getPageStore().getPageSize();
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 474 */     writeData();
/* 475 */     this.index.getPageStore().writePage(getPos(), this.data);
/* 476 */     this.data.truncate(this.index.getPageStore().getPageSize());
/*     */   }
/*     */   
/*     */   private void readAllRows() {
/* 480 */     for (byte b = 0; b < this.entryCount; b++)
/* 481 */       getRowAt(b); 
/*     */   }
/*     */   
/*     */   private void writeHead() {
/*     */     boolean bool;
/* 486 */     this.data.reset();
/*     */     
/* 488 */     if (this.firstOverflowPageId == 0) {
/* 489 */       bool = true;
/*     */     } else {
/* 491 */       bool = true;
/*     */     } 
/* 493 */     this.data.writeByte((byte)bool);
/* 494 */     this.data.writeShortInt(0);
/* 495 */     if (SysProperties.CHECK2 && 
/* 496 */       this.data.length() != 3) {
/* 497 */       DbException.throwInternalError();
/*     */     }
/*     */     
/* 500 */     this.data.writeInt(this.parentPageId);
/* 501 */     this.data.writeVarInt(this.index.getId());
/* 502 */     this.data.writeVarInt(this.columnCount);
/* 503 */     this.data.writeShortInt(this.entryCount);
/*     */   }
/*     */   
/*     */   private void writeData() {
/* 507 */     if (this.written) {
/*     */       return;
/*     */     }
/* 510 */     if (!this.optimizeUpdate) {
/* 511 */       readAllRows();
/*     */     }
/* 513 */     writeHead();
/* 514 */     if (this.firstOverflowPageId != 0) {
/* 515 */       this.data.writeInt(this.firstOverflowPageId);
/* 516 */       this.data.checkCapacity(this.overflowRowSize);
/*     */     }  byte b;
/* 518 */     for (b = 0; b < this.entryCount; b++) {
/* 519 */       this.data.writeVarLong(this.keys[b]);
/* 520 */       this.data.writeShortInt(this.offsets[b]);
/*     */     } 
/* 522 */     if (!this.writtenData || !this.optimizeUpdate) {
/* 523 */       for (b = 0; b < this.entryCount; b++) {
/* 524 */         this.data.setPos(this.offsets[b]);
/* 525 */         Row row = getRowAt(b);
/* 526 */         for (byte b1 = 0; b1 < this.columnCount; b1++) {
/* 527 */           this.data.writeValue(row.getValue(b1));
/*     */         }
/*     */       } 
/* 530 */       this.writtenData = true;
/*     */     } 
/* 532 */     this.written = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 537 */     return "page[" + getPos() + "] data leaf table:" + this.index.getId() + " " + this.index.getTable().getName() + " entries:" + this.entryCount + " parent:" + this.parentPageId + ((this.firstOverflowPageId == 0) ? "" : (" overflow:" + this.firstOverflowPageId)) + " keys:" + Arrays.toString(this.keys) + " offsets:" + Arrays.toString(this.offsets);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 546 */     PageStore pageStore = this.index.getPageStore();
/*     */ 
/*     */     
/* 549 */     if (this.parentPageId != 0) {
/* 550 */       pageStore.getPage(this.parentPageId);
/*     */     }
/* 552 */     pageStore.logUndo(this, this.data);
/* 553 */     PageDataLeaf pageDataLeaf = create(this.index, paramInt, this.parentPageId);
/* 554 */     readAllRows();
/* 555 */     pageDataLeaf.keys = this.keys;
/* 556 */     pageDataLeaf.overflowRowSize = this.overflowRowSize;
/* 557 */     pageDataLeaf.firstOverflowPageId = this.firstOverflowPageId;
/* 558 */     pageDataLeaf.rowRef = this.rowRef;
/* 559 */     pageDataLeaf.rows = this.rows;
/* 560 */     if (this.firstOverflowPageId != 0) {
/* 561 */       pageDataLeaf.rows[0] = getRowAt(0);
/*     */     }
/* 563 */     pageDataLeaf.entryCount = this.entryCount;
/* 564 */     pageDataLeaf.offsets = this.offsets;
/* 565 */     pageDataLeaf.start = this.start;
/* 566 */     pageDataLeaf.remapChildren(getPos());
/* 567 */     pageDataLeaf.writeData();
/* 568 */     pageDataLeaf.data.truncate(this.index.getPageStore().getPageSize());
/* 569 */     pageStore.update(pageDataLeaf);
/* 570 */     if (this.parentPageId == 0) {
/* 571 */       this.index.setRootPageId(paramSession, paramInt);
/*     */     } else {
/* 573 */       PageDataNode pageDataNode = (PageDataNode)pageStore.getPage(this.parentPageId);
/* 574 */       pageDataNode.moveChild(getPos(), paramInt);
/*     */     } 
/* 576 */     pageStore.free(getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setOverflow(int paramInt1, int paramInt2) {
/* 586 */     if (SysProperties.CHECK && paramInt1 != this.firstOverflowPageId) {
/* 587 */       DbException.throwInternalError("move " + this + " " + this.firstOverflowPageId);
/*     */     }
/* 589 */     this.index.getPageStore().logUndo(this, this.data);
/* 590 */     this.firstOverflowPageId = paramInt2;
/* 591 */     if (this.written) {
/* 592 */       this.changeCount = this.index.getPageStore().getChangeCount();
/* 593 */       writeHead();
/* 594 */       this.data.writeInt(this.firstOverflowPageId);
/*     */     } 
/* 596 */     this.index.getPageStore().update(this);
/*     */   }
/*     */   
/*     */   private void memoryChange(boolean paramBoolean, Row paramRow) {
/* 600 */     byte b = (paramRow == null) ? 0 : (20 + paramRow.getMemory());
/* 601 */     this.memoryData += paramBoolean ? b : -b;
/* 602 */     this.index.memoryChange(240 + this.memoryData + this.index.getPageStore().getPageSize() >> 2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isStream() {
/* 608 */     return (this.firstOverflowPageId > 0);
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
/*     */   private Row readRow(Data paramData, int paramInt1, int paramInt2) {
/* 620 */     Value[] arrayOfValue = new Value[paramInt2];
/* 621 */     synchronized (paramData) {
/* 622 */       paramData.setPos(paramInt1);
/* 623 */       for (byte b = 0; b < paramInt2; b++) {
/* 624 */         arrayOfValue[b] = paramData.readValue();
/*     */       }
/*     */     } 
/* 627 */     return this.index.getDatabase().createRow(arrayOfValue, -1);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDataLeaf.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */