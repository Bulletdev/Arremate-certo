/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.util.Utils;
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
/*     */ public class PageDataNode
/*     */   extends PageData
/*     */ {
/*     */   private int[] childPageIds;
/*  42 */   private int rowCountStored = -1;
/*     */   
/*  44 */   private int rowCount = -1;
/*     */ 
/*     */   
/*     */   private int length;
/*     */ 
/*     */ 
/*     */   
/*     */   private PageDataNode(PageDataIndex paramPageDataIndex, int paramInt, Data paramData) {
/*  52 */     super(paramPageDataIndex, paramInt, paramData);
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
/*     */   static PageDataNode create(PageDataIndex paramPageDataIndex, int paramInt1, int paramInt2) {
/*  64 */     PageDataNode pageDataNode = new PageDataNode(paramPageDataIndex, paramInt1, paramPageDataIndex.getPageStore().createData());
/*     */     
/*  66 */     paramPageDataIndex.getPageStore().logUndo(pageDataNode, null);
/*  67 */     pageDataNode.parentPageId = paramInt2;
/*  68 */     pageDataNode.writeHead();
/*     */     
/*  70 */     pageDataNode.length = pageDataNode.data.length() + 4;
/*  71 */     return pageDataNode;
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
/*  83 */     PageDataNode pageDataNode = new PageDataNode(paramPageDataIndex, paramInt, paramData);
/*  84 */     pageDataNode.read();
/*  85 */     return pageDataNode;
/*     */   }
/*     */   
/*     */   private void read() {
/*  89 */     this.data.reset();
/*  90 */     this.data.readByte();
/*  91 */     this.data.readShortInt();
/*  92 */     this.parentPageId = this.data.readInt();
/*  93 */     int i = this.data.readVarInt();
/*  94 */     if (i != this.index.getId()) {
/*  95 */       throw DbException.get(90030, "page:" + getPos() + " expected index:" + this.index.getId() + "got:" + i);
/*     */     }
/*     */ 
/*     */     
/*  99 */     this.rowCount = this.rowCountStored = this.data.readInt();
/* 100 */     this.entryCount = this.data.readShortInt();
/* 101 */     this.childPageIds = new int[this.entryCount + 1];
/* 102 */     this.childPageIds[this.entryCount] = this.data.readInt();
/* 103 */     this.keys = Utils.newLongArray(this.entryCount);
/* 104 */     for (byte b = 0; b < this.entryCount; b++) {
/* 105 */       this.childPageIds[b] = this.data.readInt();
/* 106 */       this.keys[b] = this.data.readVarLong();
/*     */     } 
/* 108 */     this.length = this.data.length();
/* 109 */     check();
/* 110 */     this.written = true;
/*     */   }
/*     */   
/*     */   private void addChild(int paramInt1, int paramInt2, long paramLong) {
/* 114 */     this.index.getPageStore().logUndo(this, this.data);
/* 115 */     this.written = false;
/* 116 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 117 */     this.childPageIds = insert(this.childPageIds, this.entryCount + 1, paramInt1 + 1, paramInt2);
/* 118 */     this.keys = insert(this.keys, this.entryCount, paramInt1, paramLong);
/* 119 */     this.entryCount++;
/* 120 */     this.length += 4 + Data.getVarLongLen(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   int addRowTry(Row paramRow) {
/* 125 */     this.index.getPageStore().logUndo(this, this.data);
/* 126 */     int i = 4 + Data.getVarLongLen(paramRow.getKey());
/*     */     while (true) {
/* 128 */       int j = find(paramRow.getKey());
/* 129 */       PageData pageData1 = this.index.getPage(this.childPageIds[j], getPos());
/* 130 */       int k = pageData1.addRowTry(paramRow);
/* 131 */       if (k == -1) {
/*     */         break;
/*     */       }
/* 134 */       if (this.length + i > this.index.getPageStore().getPageSize()) {
/* 135 */         return this.entryCount / 2;
/*     */       }
/* 137 */       long l = (k == 0) ? paramRow.getKey() : pageData1.getKey(k - 1);
/* 138 */       PageData pageData2 = pageData1.split(k);
/* 139 */       this.index.getPageStore().update(pageData1);
/* 140 */       this.index.getPageStore().update(pageData2);
/* 141 */       addChild(j, pageData2.getPos(), l);
/* 142 */       this.index.getPageStore().update(this);
/*     */     } 
/* 144 */     updateRowCount(1);
/* 145 */     return -1;
/*     */   }
/*     */   
/*     */   private void updateRowCount(int paramInt) {
/* 149 */     if (this.rowCount != -1) {
/* 150 */       this.rowCount += paramInt;
/*     */     }
/* 152 */     if (this.rowCountStored != -1) {
/* 153 */       this.rowCountStored = -1;
/* 154 */       this.index.getPageStore().logUndo(this, this.data);
/* 155 */       if (this.written) {
/* 156 */         writeHead();
/*     */       }
/* 158 */       this.index.getPageStore().update(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Cursor find(Session paramSession, long paramLong1, long paramLong2, boolean paramBoolean) {
/* 164 */     int i = find(paramLong1);
/* 165 */     int j = this.childPageIds[i];
/* 166 */     return this.index.getPage(j, getPos()).find(paramSession, paramLong1, paramLong2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   PageData split(int paramInt) {
/* 172 */     int i = this.index.getPageStore().allocatePage();
/* 173 */     PageDataNode pageDataNode = create(this.index, i, this.parentPageId);
/* 174 */     int j = this.childPageIds[paramInt]; int k;
/* 175 */     for (k = paramInt; k < this.entryCount; ) {
/* 176 */       pageDataNode.addChild(pageDataNode.entryCount, this.childPageIds[paramInt + 1], this.keys[paramInt]);
/* 177 */       removeChild(paramInt);
/*     */     } 
/* 179 */     k = this.childPageIds[paramInt - 1];
/* 180 */     removeChild(paramInt - 1);
/* 181 */     this.childPageIds[paramInt - 1] = k;
/* 182 */     pageDataNode.childPageIds[0] = j;
/* 183 */     pageDataNode.remapChildren(getPos());
/* 184 */     return pageDataNode;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void remapChildren(int paramInt) {
/* 189 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 190 */       int i = this.childPageIds[b];
/* 191 */       PageData pageData = this.index.getPage(i, paramInt);
/* 192 */       pageData.setParentPageId(getPos());
/* 193 */       this.index.getPageStore().update(pageData);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void init(PageData paramPageData1, long paramLong, PageData paramPageData2) {
/* 205 */     this.entryCount = 1;
/* 206 */     this.childPageIds = new int[] { paramPageData1.getPos(), paramPageData2.getPos() };
/* 207 */     this.keys = new long[] { paramLong };
/* 208 */     this.length += 4 + Data.getVarLongLen(paramLong);
/* 209 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   long getLastKey() {
/* 214 */     return this.index.getPage(this.childPageIds[this.entryCount], getPos()).getLastKey();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PageDataLeaf getNextPage(long paramLong) {
/* 224 */     int i = find(paramLong) + 1;
/* 225 */     if (i > this.entryCount) {
/* 226 */       if (this.parentPageId == 0) {
/* 227 */         return null;
/*     */       }
/* 229 */       PageDataNode pageDataNode = (PageDataNode)this.index.getPage(this.parentPageId, -1);
/* 230 */       return pageDataNode.getNextPage(paramLong);
/*     */     } 
/* 232 */     PageData pageData = this.index.getPage(this.childPageIds[i], getPos());
/* 233 */     return pageData.getFirstLeaf();
/*     */   }
/*     */ 
/*     */   
/*     */   PageDataLeaf getFirstLeaf() {
/* 238 */     int i = this.childPageIds[0];
/* 239 */     return this.index.getPage(i, getPos()).getFirstLeaf();
/*     */   }
/*     */ 
/*     */   
/*     */   boolean remove(long paramLong) {
/* 244 */     int i = find(paramLong);
/*     */ 
/*     */     
/* 247 */     PageData pageData = this.index.getPage(this.childPageIds[i], getPos());
/* 248 */     boolean bool = pageData.remove(paramLong);
/* 249 */     this.index.getPageStore().logUndo(this, this.data);
/* 250 */     updateRowCount(-1);
/* 251 */     if (!bool)
/*     */     {
/* 253 */       return false;
/*     */     }
/*     */     
/* 256 */     this.index.getPageStore().free(pageData.getPos());
/* 257 */     if (this.entryCount < 1)
/*     */     {
/* 259 */       return true;
/*     */     }
/* 261 */     removeChild(i);
/* 262 */     this.index.getPageStore().update(this);
/* 263 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   void freeRecursive() {
/* 268 */     this.index.getPageStore().logUndo(this, this.data);
/* 269 */     this.index.getPageStore().free(getPos());
/* 270 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 271 */       int i = this.childPageIds[b];
/* 272 */       this.index.getPage(i, getPos()).freeRecursive();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   Row getRowWithKey(long paramLong) {
/* 278 */     int i = find(paramLong);
/* 279 */     PageData pageData = this.index.getPage(this.childPageIds[i], getPos());
/* 280 */     return pageData.getRowWithKey(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   int getRowCount() {
/* 285 */     if (this.rowCount == -1) {
/* 286 */       int i = 0;
/* 287 */       for (byte b = 0; b < this.entryCount + 1; b++) {
/* 288 */         int j = this.childPageIds[b];
/* 289 */         PageData pageData = this.index.getPage(j, getPos());
/* 290 */         if (getPos() == pageData.getPos()) {
/* 291 */           throw DbException.throwInternalError("Page is its own child: " + getPos());
/*     */         }
/* 293 */         i += pageData.getRowCount();
/* 294 */         this.index.getDatabase().setProgress(0, this.index.getTable() + "." + this.index.getName(), i, 2147483647);
/*     */       } 
/*     */       
/* 297 */       this.rowCount = i;
/*     */     } 
/* 299 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   long getDiskSpaceUsed() {
/* 304 */     long l = 0L;
/* 305 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 306 */       int i = this.childPageIds[b];
/* 307 */       PageData pageData = this.index.getPage(i, getPos());
/* 308 */       if (getPos() == pageData.getPos()) {
/* 309 */         throw DbException.throwInternalError("Page is its own child: " + getPos());
/*     */       }
/* 311 */       l += pageData.getDiskSpaceUsed();
/* 312 */       this.index.getDatabase().setProgress(0, this.index.getTable() + "." + this.index.getName(), (int)(l >> 16L), 2147483647);
/*     */     } 
/*     */ 
/*     */     
/* 316 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   void setRowCountStored(int paramInt) {
/* 321 */     this.rowCount = paramInt;
/* 322 */     if (this.rowCountStored != paramInt) {
/* 323 */       this.rowCountStored = paramInt;
/* 324 */       this.index.getPageStore().logUndo(this, this.data);
/* 325 */       if (this.written) {
/* 326 */         this.changeCount = this.index.getPageStore().getChangeCount();
/* 327 */         writeHead();
/*     */       } 
/* 329 */       this.index.getPageStore().update(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void check() {
/* 334 */     if (SysProperties.CHECK) {
/* 335 */       for (byte b = 0; b < this.entryCount + 1; b++) {
/* 336 */         int i = this.childPageIds[b];
/* 337 */         if (i == 0) {
/* 338 */           DbException.throwInternalError();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 346 */     writeData();
/* 347 */     this.index.getPageStore().writePage(getPos(), this.data);
/*     */   }
/*     */   
/*     */   private void writeHead() {
/* 351 */     this.data.reset();
/* 352 */     this.data.writeByte((byte)2);
/* 353 */     this.data.writeShortInt(0);
/* 354 */     if (SysProperties.CHECK2 && 
/* 355 */       this.data.length() != 3) {
/* 356 */       DbException.throwInternalError();
/*     */     }
/*     */     
/* 359 */     this.data.writeInt(this.parentPageId);
/* 360 */     this.data.writeVarInt(this.index.getId());
/* 361 */     this.data.writeInt(this.rowCountStored);
/* 362 */     this.data.writeShortInt(this.entryCount);
/*     */   }
/*     */   
/*     */   private void writeData() {
/* 366 */     if (this.written) {
/*     */       return;
/*     */     }
/* 369 */     check();
/* 370 */     writeHead();
/* 371 */     this.data.writeInt(this.childPageIds[this.entryCount]);
/* 372 */     for (byte b = 0; b < this.entryCount; b++) {
/* 373 */       this.data.writeInt(this.childPageIds[b]);
/* 374 */       this.data.writeVarLong(this.keys[b]);
/*     */     } 
/* 376 */     if (this.length != this.data.length()) {
/* 377 */       DbException.throwInternalError("expected pos: " + this.length + " got: " + this.data.length());
/*     */     }
/*     */     
/* 380 */     this.written = true;
/*     */   }
/*     */   
/*     */   private void removeChild(int paramInt) {
/* 384 */     this.index.getPageStore().logUndo(this, this.data);
/* 385 */     this.written = false;
/* 386 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 387 */     int i = (paramInt < this.entryCount) ? paramInt : (paramInt - 1);
/* 388 */     this.entryCount--;
/* 389 */     this.length -= 4 + Data.getVarLongLen(this.keys[i]);
/* 390 */     if (this.entryCount < 0) {
/* 391 */       DbException.throwInternalError();
/*     */     }
/* 393 */     this.keys = remove(this.keys, this.entryCount + 1, i);
/* 394 */     this.childPageIds = remove(this.childPageIds, this.entryCount + 2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 399 */     return "page[" + getPos() + "] data node table:" + this.index.getId() + " entries:" + this.entryCount + " " + Arrays.toString(this.childPageIds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 405 */     PageStore pageStore = this.index.getPageStore();
/*     */ 
/*     */     
/* 408 */     for (byte b1 = 0; b1 < this.entryCount + 1; b1++) {
/* 409 */       int i = this.childPageIds[b1];
/* 410 */       pageStore.getPage(i);
/*     */     } 
/* 412 */     if (this.parentPageId != 0) {
/* 413 */       pageStore.getPage(this.parentPageId);
/*     */     }
/* 415 */     pageStore.logUndo(this, this.data);
/* 416 */     PageDataNode pageDataNode = create(this.index, paramInt, this.parentPageId);
/* 417 */     pageDataNode.rowCountStored = this.rowCountStored;
/* 418 */     pageDataNode.rowCount = this.rowCount;
/* 419 */     pageDataNode.childPageIds = this.childPageIds;
/* 420 */     pageDataNode.keys = this.keys;
/* 421 */     pageDataNode.entryCount = this.entryCount;
/* 422 */     pageDataNode.length = this.length;
/* 423 */     pageStore.update(pageDataNode);
/* 424 */     if (this.parentPageId == 0) {
/* 425 */       this.index.setRootPageId(paramSession, paramInt);
/*     */     } else {
/* 427 */       PageDataNode pageDataNode1 = (PageDataNode)pageStore.getPage(this.parentPageId);
/* 428 */       pageDataNode1.moveChild(getPos(), paramInt);
/*     */     } 
/* 430 */     for (byte b2 = 0; b2 < this.entryCount + 1; b2++) {
/* 431 */       int i = this.childPageIds[b2];
/* 432 */       PageData pageData = (PageData)pageStore.getPage(i);
/* 433 */       pageData.setParentPageId(paramInt);
/* 434 */       pageStore.update(pageData);
/*     */     } 
/* 436 */     pageStore.free(getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void moveChild(int paramInt1, int paramInt2) {
/* 446 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 447 */       if (this.childPageIds[b] == paramInt1) {
/* 448 */         this.index.getPageStore().logUndo(this, this.data);
/* 449 */         this.written = false;
/* 450 */         this.changeCount = this.index.getPageStore().getChangeCount();
/* 451 */         this.childPageIds[b] = paramInt2;
/* 452 */         this.index.getPageStore().update(this);
/*     */         return;
/*     */       } 
/*     */     } 
/* 456 */     throw DbException.throwInternalError();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDataNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */