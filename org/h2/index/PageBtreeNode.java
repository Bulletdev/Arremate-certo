/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.SearchRow;
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
/*     */ 
/*     */ 
/*     */ public class PageBtreeNode
/*     */   extends PageBtree
/*     */ {
/*     */   private static final int CHILD_OFFSET_PAIR_LENGTH = 6;
/*     */   private static final int MAX_KEY_LENGTH = 10;
/*     */   private final boolean pageStoreInternalCount;
/*     */   private int[] childPageIds;
/*  46 */   private int rowCountStored = -1;
/*     */   
/*  48 */   private int rowCount = -1;
/*     */   
/*     */   private PageBtreeNode(PageBtreeIndex paramPageBtreeIndex, int paramInt, Data paramData) {
/*  51 */     super(paramPageBtreeIndex, paramInt, paramData);
/*  52 */     this.pageStoreInternalCount = (paramPageBtreeIndex.getDatabase().getSettings()).pageStoreInternalCount;
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
/*     */   public static Page read(PageBtreeIndex paramPageBtreeIndex, Data paramData, int paramInt) {
/*  65 */     PageBtreeNode pageBtreeNode = new PageBtreeNode(paramPageBtreeIndex, paramInt, paramData);
/*  66 */     pageBtreeNode.read();
/*  67 */     return pageBtreeNode;
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
/*     */   static PageBtreeNode create(PageBtreeIndex paramPageBtreeIndex, int paramInt1, int paramInt2) {
/*  80 */     PageBtreeNode pageBtreeNode = new PageBtreeNode(paramPageBtreeIndex, paramInt1, paramPageBtreeIndex.getPageStore().createData());
/*     */     
/*  82 */     paramPageBtreeIndex.getPageStore().logUndo(pageBtreeNode, null);
/*  83 */     pageBtreeNode.parentPageId = paramInt2;
/*  84 */     pageBtreeNode.writeHead();
/*     */     
/*  86 */     pageBtreeNode.start = pageBtreeNode.data.length() + 4;
/*  87 */     pageBtreeNode.rows = SearchRow.EMPTY_ARRAY;
/*  88 */     if (pageBtreeNode.pageStoreInternalCount) {
/*  89 */       pageBtreeNode.rowCount = 0;
/*     */     }
/*  91 */     return pageBtreeNode;
/*     */   }
/*     */   
/*     */   private void read() {
/*  95 */     this.data.reset();
/*  96 */     byte b = this.data.readByte();
/*  97 */     this.data.readShortInt();
/*  98 */     this.parentPageId = this.data.readInt();
/*  99 */     this.onlyPosition = ((b & 0x10) == 0);
/* 100 */     int i = this.data.readVarInt();
/* 101 */     if (i != this.index.getId()) {
/* 102 */       throw DbException.get(90030, "page:" + getPos() + " expected index:" + this.index.getId() + "got:" + i);
/*     */     }
/*     */ 
/*     */     
/* 106 */     this.rowCount = this.rowCountStored = this.data.readInt();
/* 107 */     this.entryCount = this.data.readShortInt();
/* 108 */     this.childPageIds = new int[this.entryCount + 1];
/* 109 */     this.childPageIds[this.entryCount] = this.data.readInt();
/* 110 */     this.rows = (this.entryCount == 0) ? SearchRow.EMPTY_ARRAY : new SearchRow[this.entryCount];
/* 111 */     this.offsets = Utils.newIntArray(this.entryCount);
/* 112 */     for (byte b1 = 0; b1 < this.entryCount; b1++) {
/* 113 */       this.childPageIds[b1] = this.data.readInt();
/* 114 */       this.offsets[b1] = this.data.readShortInt();
/*     */     } 
/* 116 */     check();
/* 117 */     this.start = this.data.length();
/* 118 */     this.written = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int addChildTry(SearchRow paramSearchRow) {
/*     */     int i;
/* 129 */     if (this.entryCount < 4) {
/* 130 */       return -1;
/*     */     }
/*     */     
/* 133 */     if (this.onlyPosition) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       i = this.entryCount + 10;
/*     */     } else {
/* 140 */       int j = this.index.getRowSize(this.data, paramSearchRow, this.onlyPosition);
/* 141 */       int k = this.index.getPageStore().getPageSize();
/* 142 */       int m = (this.entryCount == 0) ? k : this.offsets[this.entryCount - 1];
/* 143 */       i = m - j;
/*     */     } 
/* 145 */     if (i < this.start + 6) {
/* 146 */       return this.entryCount / 2;
/*     */     }
/* 148 */     return -1;
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
/*     */   private void addChild(int paramInt1, int paramInt2, SearchRow paramSearchRow) {
/* 160 */     int i = this.index.getRowSize(this.data, paramSearchRow, this.onlyPosition);
/* 161 */     int j = this.index.getPageStore().getPageSize();
/* 162 */     int k = (this.entryCount == 0) ? j : this.offsets[this.entryCount - 1];
/* 163 */     if (k - i < this.start + 6) {
/* 164 */       readAllRows();
/* 165 */       this.onlyPosition = true;
/*     */       
/* 167 */       int n = j;
/* 168 */       for (byte b = 0; b < this.entryCount; b++) {
/* 169 */         n -= this.index.getRowSize(this.data, getRow(b), true);
/* 170 */         this.offsets[b] = n;
/*     */       } 
/* 172 */       k = (this.entryCount == 0) ? j : this.offsets[this.entryCount - 1];
/* 173 */       i = this.index.getRowSize(this.data, paramSearchRow, true);
/* 174 */       if (SysProperties.CHECK && k - i < this.start + 6)
/*     */       {
/* 176 */         throw DbException.throwInternalError();
/*     */       }
/*     */     } 
/* 179 */     int m = k - i;
/* 180 */     if (this.entryCount > 0 && 
/* 181 */       paramInt1 < this.entryCount) {
/* 182 */       m = ((paramInt1 == 0) ? j : this.offsets[paramInt1 - 1]) - i;
/*     */     }
/*     */     
/* 185 */     this.rows = (SearchRow[])insert((Object[])this.rows, this.entryCount, paramInt1, paramSearchRow);
/* 186 */     this.offsets = insert(this.offsets, this.entryCount, paramInt1, m);
/* 187 */     add(this.offsets, paramInt1 + 1, this.entryCount + 1, -i);
/* 188 */     this.childPageIds = insert(this.childPageIds, this.entryCount + 1, paramInt1 + 1, paramInt2);
/* 189 */     this.start += 6;
/* 190 */     if (this.pageStoreInternalCount && 
/* 191 */       this.rowCount != -1) {
/* 192 */       this.rowCount += m;
/*     */     }
/*     */     
/* 195 */     this.entryCount++;
/* 196 */     this.written = false;
/* 197 */     this.changeCount = this.index.getPageStore().getChangeCount();
/*     */   }
/*     */ 
/*     */   
/*     */   int addRowTry(SearchRow paramSearchRow) {
/*     */     while (true) {
/* 203 */       int i = find(paramSearchRow, false, true, true);
/* 204 */       PageBtree pageBtree1 = this.index.getPage(this.childPageIds[i]);
/* 205 */       int j = pageBtree1.addRowTry(paramSearchRow);
/* 206 */       if (j == -1) {
/*     */         break;
/*     */       }
/* 209 */       SearchRow searchRow = pageBtree1.getRow(j - 1);
/* 210 */       this.index.getPageStore().logUndo(this, this.data);
/* 211 */       int k = addChildTry(searchRow);
/* 212 */       if (k != -1) {
/* 213 */         return k;
/*     */       }
/* 215 */       PageBtree pageBtree2 = pageBtree1.split(j);
/* 216 */       readAllRows();
/* 217 */       addChild(i, pageBtree2.getPos(), searchRow);
/* 218 */       this.index.getPageStore().update(pageBtree1);
/* 219 */       this.index.getPageStore().update(pageBtree2);
/* 220 */       this.index.getPageStore().update(this);
/*     */     } 
/* 222 */     updateRowCount(1);
/* 223 */     this.written = false;
/* 224 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 225 */     return -1;
/*     */   }
/*     */   
/*     */   private void updateRowCount(int paramInt) {
/* 229 */     if (this.rowCount != -1) {
/* 230 */       this.rowCount += paramInt;
/*     */     }
/* 232 */     if (this.rowCountStored != -1) {
/* 233 */       this.rowCountStored = -1;
/* 234 */       this.index.getPageStore().logUndo(this, this.data);
/* 235 */       if (this.written) {
/* 236 */         writeHead();
/*     */       }
/* 238 */       this.index.getPageStore().update(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtree split(int paramInt) {
/* 244 */     int i = this.index.getPageStore().allocatePage();
/* 245 */     PageBtreeNode pageBtreeNode = create(this.index, i, this.parentPageId);
/* 246 */     this.index.getPageStore().logUndo(this, this.data);
/* 247 */     if (this.onlyPosition)
/*     */     {
/* 249 */       pageBtreeNode.onlyPosition = true;
/*     */     }
/* 251 */     int j = this.childPageIds[paramInt];
/* 252 */     readAllRows(); int k;
/* 253 */     for (k = paramInt; k < this.entryCount; ) {
/* 254 */       pageBtreeNode.addChild(pageBtreeNode.entryCount, this.childPageIds[paramInt + 1], getRow(paramInt));
/* 255 */       removeChild(paramInt);
/*     */     } 
/* 257 */     k = this.childPageIds[paramInt - 1];
/* 258 */     removeChild(paramInt - 1);
/* 259 */     this.childPageIds[paramInt - 1] = k;
/* 260 */     if (pageBtreeNode.childPageIds == null) {
/* 261 */       pageBtreeNode.childPageIds = new int[1];
/*     */     }
/* 263 */     pageBtreeNode.childPageIds[0] = j;
/* 264 */     pageBtreeNode.remapChildren();
/* 265 */     return pageBtreeNode;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void remapChildren() {
/* 270 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 271 */       int i = this.childPageIds[b];
/* 272 */       PageBtree pageBtree = this.index.getPage(i);
/* 273 */       pageBtree.setParentPageId(getPos());
/* 274 */       this.index.getPageStore().update(pageBtree);
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
/*     */   void init(PageBtree paramPageBtree1, SearchRow paramSearchRow, PageBtree paramPageBtree2) {
/* 286 */     this.entryCount = 0;
/* 287 */     this.childPageIds = new int[] { paramPageBtree1.getPos() };
/* 288 */     this.rows = SearchRow.EMPTY_ARRAY;
/* 289 */     this.offsets = Utils.EMPTY_INT_ARRAY;
/* 290 */     addChild(0, paramPageBtree2.getPos(), paramSearchRow);
/* 291 */     if (this.pageStoreInternalCount) {
/* 292 */       this.rowCount = paramPageBtree1.getRowCount() + paramPageBtree2.getRowCount();
/*     */     }
/* 294 */     check();
/*     */   }
/*     */ 
/*     */   
/*     */   void find(PageBtreeCursor paramPageBtreeCursor, SearchRow paramSearchRow, boolean paramBoolean) {
/* 299 */     int i = find(paramSearchRow, paramBoolean, false, false);
/* 300 */     if (i > this.entryCount) {
/* 301 */       if (this.parentPageId == 0) {
/*     */         return;
/*     */       }
/* 304 */       PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 305 */       pageBtreeNode.find(paramPageBtreeCursor, paramSearchRow, paramBoolean);
/*     */       return;
/*     */     } 
/* 308 */     PageBtree pageBtree = this.index.getPage(this.childPageIds[i]);
/* 309 */     pageBtree.find(paramPageBtreeCursor, paramSearchRow, paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   void last(PageBtreeCursor paramPageBtreeCursor) {
/* 314 */     int i = this.childPageIds[this.entryCount];
/* 315 */     this.index.getPage(i).last(paramPageBtreeCursor);
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtreeLeaf getFirstLeaf() {
/* 320 */     int i = this.childPageIds[0];
/* 321 */     return this.index.getPage(i).getFirstLeaf();
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtreeLeaf getLastLeaf() {
/* 326 */     int i = this.childPageIds[this.entryCount];
/* 327 */     return this.index.getPage(i).getLastLeaf();
/*     */   }
/*     */ 
/*     */   
/*     */   SearchRow remove(SearchRow paramSearchRow) {
/* 332 */     int i = find(paramSearchRow, false, false, true);
/*     */ 
/*     */     
/* 335 */     PageBtree pageBtree = this.index.getPage(this.childPageIds[i]);
/* 336 */     SearchRow searchRow = pageBtree.remove(paramSearchRow);
/* 337 */     this.index.getPageStore().logUndo(this, this.data);
/* 338 */     updateRowCount(-1);
/* 339 */     this.written = false;
/* 340 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 341 */     if (searchRow == null)
/*     */     {
/* 343 */       return null; } 
/* 344 */     if (searchRow == paramSearchRow) {
/*     */       
/* 346 */       this.index.getPageStore().free(pageBtree.getPos());
/* 347 */       if (this.entryCount < 1)
/*     */       {
/* 349 */         return paramSearchRow;
/*     */       }
/* 351 */       if (i == this.entryCount) {
/*     */         
/* 353 */         searchRow = getRow(i - 1);
/*     */       } else {
/* 355 */         searchRow = null;
/*     */       } 
/* 357 */       removeChild(i);
/* 358 */       this.index.getPageStore().update(this);
/* 359 */       return searchRow;
/*     */     } 
/*     */     
/* 362 */     if (i == this.entryCount) {
/* 363 */       return searchRow;
/*     */     }
/* 365 */     int j = this.childPageIds[i];
/* 366 */     removeChild(i);
/*     */ 
/*     */     
/* 369 */     addChild(i, j, searchRow);
/*     */     
/* 371 */     int k = this.childPageIds[i];
/* 372 */     this.childPageIds[i] = this.childPageIds[i + 1];
/* 373 */     this.childPageIds[i + 1] = k;
/* 374 */     this.index.getPageStore().update(this);
/* 375 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   int getRowCount() {
/* 380 */     if (this.rowCount == -1) {
/* 381 */       int i = 0;
/* 382 */       for (byte b = 0; b < this.entryCount + 1; b++) {
/* 383 */         int j = this.childPageIds[b];
/* 384 */         PageBtree pageBtree = this.index.getPage(j);
/* 385 */         i += pageBtree.getRowCount();
/* 386 */         this.index.getDatabase().setProgress(0, this.index.getName(), i, 2147483647);
/*     */       } 
/*     */ 
/*     */       
/* 390 */       this.rowCount = i;
/*     */     } 
/* 392 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   void setRowCountStored(int paramInt) {
/* 397 */     if (paramInt < 0 && this.pageStoreInternalCount) {
/*     */       return;
/*     */     }
/* 400 */     this.rowCount = paramInt;
/* 401 */     if (this.rowCountStored != paramInt) {
/* 402 */       this.rowCountStored = paramInt;
/* 403 */       this.index.getPageStore().logUndo(this, this.data);
/* 404 */       if (this.written) {
/* 405 */         this.changeCount = this.index.getPageStore().getChangeCount();
/* 406 */         writeHead();
/*     */       } 
/* 408 */       this.index.getPageStore().update(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void check() {
/* 413 */     if (SysProperties.CHECK) {
/* 414 */       for (byte b = 0; b < this.entryCount + 1; b++) {
/* 415 */         int i = this.childPageIds[b];
/* 416 */         if (i == 0) {
/* 417 */           DbException.throwInternalError();
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 425 */     check();
/* 426 */     writeData();
/* 427 */     this.index.getPageStore().writePage(getPos(), this.data);
/*     */   }
/*     */   
/*     */   private void writeHead() {
/* 431 */     this.data.reset();
/* 432 */     this.data.writeByte((byte)(0x5 | (this.onlyPosition ? 0 : 16)));
/*     */     
/* 434 */     this.data.writeShortInt(0);
/* 435 */     this.data.writeInt(this.parentPageId);
/* 436 */     this.data.writeVarInt(this.index.getId());
/* 437 */     this.data.writeInt(this.rowCountStored);
/* 438 */     this.data.writeShortInt(this.entryCount);
/*     */   }
/*     */   
/*     */   private void writeData() {
/* 442 */     if (this.written) {
/*     */       return;
/*     */     }
/* 445 */     readAllRows();
/* 446 */     writeHead();
/* 447 */     this.data.writeInt(this.childPageIds[this.entryCount]); byte b;
/* 448 */     for (b = 0; b < this.entryCount; b++) {
/* 449 */       this.data.writeInt(this.childPageIds[b]);
/* 450 */       this.data.writeShortInt(this.offsets[b]);
/*     */     } 
/* 452 */     for (b = 0; b < this.entryCount; b++) {
/* 453 */       this.index.writeRow(this.data, this.offsets[b], this.rows[b], this.onlyPosition);
/*     */     }
/* 455 */     this.written = true;
/*     */   }
/*     */ 
/*     */   
/*     */   void freeRecursive() {
/* 460 */     this.index.getPageStore().logUndo(this, this.data);
/* 461 */     this.index.getPageStore().free(getPos());
/* 462 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 463 */       int i = this.childPageIds[b];
/* 464 */       this.index.getPage(i).freeRecursive();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void removeChild(int paramInt) {
/* 469 */     readAllRows();
/* 470 */     this.entryCount--;
/* 471 */     if (this.pageStoreInternalCount) {
/* 472 */       updateRowCount(-this.index.getPage(this.childPageIds[paramInt]).getRowCount());
/*     */     }
/* 474 */     this.written = false;
/* 475 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 476 */     if (this.entryCount < 0) {
/* 477 */       DbException.throwInternalError();
/*     */     }
/* 479 */     if (this.entryCount > paramInt) {
/* 480 */       int i = (paramInt > 0) ? this.offsets[paramInt - 1] : this.index.getPageStore().getPageSize();
/* 481 */       int j = i - this.offsets[paramInt];
/* 482 */       add(this.offsets, paramInt, this.entryCount + 1, j);
/*     */     } 
/* 484 */     this.rows = (SearchRow[])remove((Object[])this.rows, this.entryCount + 1, paramInt);
/* 485 */     this.offsets = remove(this.offsets, this.entryCount + 1, paramInt);
/* 486 */     this.childPageIds = remove(this.childPageIds, this.entryCount + 2, paramInt);
/* 487 */     this.start -= 6;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void nextPage(PageBtreeCursor paramPageBtreeCursor, int paramInt) {
/*     */     byte b;
/* 499 */     for (b = 0; b < this.entryCount + 1; b++) {
/* 500 */       if (this.childPageIds[b] == paramInt) {
/* 501 */         b++;
/*     */         break;
/*     */       } 
/*     */     } 
/* 505 */     if (b > this.entryCount) {
/* 506 */       if (this.parentPageId == 0) {
/* 507 */         paramPageBtreeCursor.setCurrent(null, 0);
/*     */         return;
/*     */       } 
/* 510 */       PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 511 */       pageBtreeNode.nextPage(paramPageBtreeCursor, getPos());
/*     */       return;
/*     */     } 
/* 514 */     PageBtree pageBtree = this.index.getPage(this.childPageIds[b]);
/* 515 */     PageBtreeLeaf pageBtreeLeaf = pageBtree.getFirstLeaf();
/* 516 */     paramPageBtreeCursor.setCurrent(pageBtreeLeaf, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void previousPage(PageBtreeCursor paramPageBtreeCursor, int paramInt) {
/*     */     int i;
/* 528 */     for (i = this.entryCount; i >= 0; i--) {
/* 529 */       if (this.childPageIds[i] == paramInt) {
/* 530 */         i--;
/*     */         break;
/*     */       } 
/*     */     } 
/* 534 */     if (i < 0) {
/* 535 */       if (this.parentPageId == 0) {
/* 536 */         paramPageBtreeCursor.setCurrent(null, 0);
/*     */         return;
/*     */       } 
/* 539 */       PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 540 */       pageBtreeNode.previousPage(paramPageBtreeCursor, getPos());
/*     */       return;
/*     */     } 
/* 543 */     PageBtree pageBtree = this.index.getPage(this.childPageIds[i]);
/* 544 */     PageBtreeLeaf pageBtreeLeaf = pageBtree.getLastLeaf();
/* 545 */     paramPageBtreeCursor.setCurrent(pageBtreeLeaf, pageBtreeLeaf.entryCount - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 551 */     return "page[" + getPos() + "] b-tree node table:" + this.index.getId() + " entries:" + this.entryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 557 */     PageStore pageStore = this.index.getPageStore();
/* 558 */     pageStore.logUndo(this, this.data);
/* 559 */     PageBtreeNode pageBtreeNode = create(this.index, paramInt, this.parentPageId);
/* 560 */     readAllRows();
/* 561 */     pageBtreeNode.rowCountStored = this.rowCountStored;
/* 562 */     pageBtreeNode.rowCount = this.rowCount;
/* 563 */     pageBtreeNode.childPageIds = this.childPageIds;
/* 564 */     pageBtreeNode.rows = this.rows;
/* 565 */     pageBtreeNode.entryCount = this.entryCount;
/* 566 */     pageBtreeNode.offsets = this.offsets;
/* 567 */     pageBtreeNode.onlyPosition = this.onlyPosition;
/* 568 */     pageBtreeNode.parentPageId = this.parentPageId;
/* 569 */     pageBtreeNode.start = this.start;
/* 570 */     pageStore.update(pageBtreeNode);
/* 571 */     if (this.parentPageId == 0) {
/* 572 */       this.index.setRootPageId(paramSession, paramInt);
/*     */     } else {
/* 574 */       Page page = pageStore.getPage(this.parentPageId);
/* 575 */       if (!(page instanceof PageBtreeNode)) {
/* 576 */         throw DbException.throwInternalError();
/*     */       }
/* 578 */       PageBtreeNode pageBtreeNode1 = (PageBtreeNode)page;
/* 579 */       pageBtreeNode1.moveChild(getPos(), paramInt);
/*     */     } 
/* 581 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 582 */       int i = this.childPageIds[b];
/* 583 */       PageBtree pageBtree = this.index.getPage(i);
/* 584 */       pageBtree.setParentPageId(paramInt);
/* 585 */       pageStore.update(pageBtree);
/*     */     } 
/* 587 */     pageStore.free(getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void moveChild(int paramInt1, int paramInt2) {
/* 597 */     for (byte b = 0; b < this.entryCount + 1; b++) {
/* 598 */       if (this.childPageIds[b] == paramInt1) {
/* 599 */         this.index.getPageStore().logUndo(this, this.data);
/* 600 */         this.written = false;
/* 601 */         this.changeCount = this.index.getPageStore().getChangeCount();
/* 602 */         this.childPageIds[b] = paramInt2;
/* 603 */         this.index.getPageStore().update(this);
/*     */         return;
/*     */       } 
/*     */     } 
/* 607 */     throw DbException.throwInternalError();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageBtreeNode.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */