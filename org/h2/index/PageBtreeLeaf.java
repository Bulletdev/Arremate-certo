/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.store.Data;
/*     */ import org.h2.store.Page;
/*     */ import org.h2.store.PageStore;
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
/*     */ public class PageBtreeLeaf
/*     */   extends PageBtree
/*     */ {
/*     */   private static final int OFFSET_LENGTH = 2;
/*     */   private final boolean optimizeUpdate;
/*     */   private boolean writtenData;
/*     */   
/*     */   private PageBtreeLeaf(PageBtreeIndex paramPageBtreeIndex, int paramInt, Data paramData) {
/*  40 */     super(paramPageBtreeIndex, paramInt, paramData);
/*  41 */     this.optimizeUpdate = (paramPageBtreeIndex.getDatabase().getSettings()).optimizeUpdate;
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
/*     */   public static Page read(PageBtreeIndex paramPageBtreeIndex, Data paramData, int paramInt) {
/*  53 */     PageBtreeLeaf pageBtreeLeaf = new PageBtreeLeaf(paramPageBtreeIndex, paramInt, paramData);
/*  54 */     pageBtreeLeaf.read();
/*  55 */     return pageBtreeLeaf;
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
/*     */   static PageBtreeLeaf create(PageBtreeIndex paramPageBtreeIndex, int paramInt1, int paramInt2) {
/*  68 */     PageBtreeLeaf pageBtreeLeaf = new PageBtreeLeaf(paramPageBtreeIndex, paramInt1, paramPageBtreeIndex.getPageStore().createData());
/*     */     
/*  70 */     paramPageBtreeIndex.getPageStore().logUndo(pageBtreeLeaf, null);
/*  71 */     pageBtreeLeaf.rows = SearchRow.EMPTY_ARRAY;
/*  72 */     pageBtreeLeaf.parentPageId = paramInt2;
/*  73 */     pageBtreeLeaf.writeHead();
/*  74 */     pageBtreeLeaf.start = pageBtreeLeaf.data.length();
/*  75 */     return pageBtreeLeaf;
/*     */   }
/*     */   
/*     */   private void read() {
/*  79 */     this.data.reset();
/*  80 */     byte b = this.data.readByte();
/*  81 */     this.data.readShortInt();
/*  82 */     this.parentPageId = this.data.readInt();
/*  83 */     this.onlyPosition = ((b & 0x10) == 0);
/*  84 */     int i = this.data.readVarInt();
/*  85 */     if (i != this.index.getId()) {
/*  86 */       throw DbException.get(90030, "page:" + getPos() + " expected index:" + this.index.getId() + "got:" + i);
/*     */     }
/*     */ 
/*     */     
/*  90 */     this.entryCount = this.data.readShortInt();
/*  91 */     this.offsets = new int[this.entryCount];
/*  92 */     this.rows = new SearchRow[this.entryCount];
/*  93 */     for (byte b1 = 0; b1 < this.entryCount; b1++) {
/*  94 */       this.offsets[b1] = this.data.readShortInt();
/*     */     }
/*  96 */     this.start = this.data.length();
/*  97 */     this.written = true;
/*  98 */     this.writtenData = true;
/*     */   }
/*     */ 
/*     */   
/*     */   int addRowTry(SearchRow paramSearchRow) {
/* 103 */     int i = addRow(paramSearchRow, true);
/* 104 */     memoryChange();
/* 105 */     return i;
/*     */   }
/*     */   
/*     */   private int addRow(SearchRow paramSearchRow, boolean paramBoolean) {
/* 109 */     int m, i = this.index.getRowSize(this.data, paramSearchRow, this.onlyPosition);
/* 110 */     int j = this.index.getPageStore().getPageSize();
/* 111 */     int k = (this.entryCount == 0) ? j : this.offsets[this.entryCount - 1];
/* 112 */     if (k - i < this.start + 2) {
/* 113 */       if (paramBoolean && this.entryCount > 1) {
/* 114 */         int i1 = find(paramSearchRow, false, true, true);
/* 115 */         if (this.entryCount < 5)
/*     */         {
/* 117 */           return this.entryCount / 2;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 122 */         int i2 = this.entryCount / 3;
/* 123 */         return (i1 < i2) ? i2 : ((i1 >= 2 * i2) ? (2 * i2) : i1);
/*     */       } 
/* 125 */       readAllRows();
/* 126 */       this.writtenData = false;
/* 127 */       this.onlyPosition = true;
/*     */       
/* 129 */       m = j;
/* 130 */       for (byte b = 0; b < this.entryCount; b++) {
/* 131 */         m -= this.index.getRowSize(this.data, getRow(b), true);
/* 132 */         this.offsets[b] = m;
/*     */       } 
/* 134 */       k = (this.entryCount == 0) ? j : this.offsets[this.entryCount - 1];
/* 135 */       i = this.index.getRowSize(this.data, paramSearchRow, true);
/* 136 */       if (SysProperties.CHECK && k - i < this.start + 2) {
/* 137 */         throw DbException.throwInternalError();
/*     */       }
/*     */     } 
/* 140 */     this.index.getPageStore().logUndo(this, this.data);
/* 141 */     if (!this.optimizeUpdate) {
/* 142 */       readAllRows();
/*     */     }
/* 144 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 145 */     this.written = false;
/*     */     
/* 147 */     if (this.entryCount == 0) {
/* 148 */       m = 0;
/*     */     } else {
/* 150 */       m = find(paramSearchRow, false, true, true);
/*     */     } 
/* 152 */     this.start += 2;
/* 153 */     int n = ((m == 0) ? j : this.offsets[m - 1]) - i;
/* 154 */     if (this.optimizeUpdate && this.writtenData) {
/* 155 */       if (this.entryCount > 0) {
/* 156 */         byte[] arrayOfByte = this.data.getBytes();
/* 157 */         int i1 = this.offsets[this.entryCount - 1];
/* 158 */         int i2 = n;
/* 159 */         System.arraycopy(arrayOfByte, i1, arrayOfByte, i1 - i, i2 - i1 + i);
/*     */       } 
/*     */       
/* 162 */       this.index.writeRow(this.data, n, paramSearchRow, this.onlyPosition);
/*     */     } 
/* 164 */     this.offsets = insert(this.offsets, this.entryCount, m, n);
/* 165 */     add(this.offsets, m + 1, this.entryCount + 1, -i);
/* 166 */     this.rows = (SearchRow[])insert((Object[])this.rows, this.entryCount, m, paramSearchRow);
/* 167 */     this.entryCount++;
/* 168 */     this.index.getPageStore().update(this);
/* 169 */     return -1;
/*     */   }
/*     */   
/*     */   private void removeRow(int paramInt) {
/* 173 */     if (!this.optimizeUpdate) {
/* 174 */       readAllRows();
/*     */     }
/* 176 */     this.index.getPageStore().logUndo(this, this.data);
/* 177 */     this.entryCount--;
/* 178 */     this.written = false;
/* 179 */     this.changeCount = this.index.getPageStore().getChangeCount();
/* 180 */     if (this.entryCount <= 0) {
/* 181 */       DbException.throwInternalError();
/*     */     }
/* 183 */     int i = (paramInt > 0) ? this.offsets[paramInt - 1] : this.index.getPageStore().getPageSize();
/* 184 */     int j = i - this.offsets[paramInt];
/* 185 */     this.start -= 2;
/*     */     
/* 187 */     if (this.optimizeUpdate && 
/* 188 */       this.writtenData) {
/* 189 */       byte[] arrayOfByte = this.data.getBytes();
/* 190 */       int k = this.offsets[this.entryCount];
/* 191 */       System.arraycopy(arrayOfByte, k, arrayOfByte, k + j, this.offsets[paramInt] - k);
/*     */       
/* 193 */       Arrays.fill(arrayOfByte, k, k + j, (byte)0);
/*     */     } 
/*     */ 
/*     */     
/* 197 */     this.offsets = remove(this.offsets, this.entryCount + 1, paramInt);
/* 198 */     add(this.offsets, paramInt, this.entryCount, j);
/* 199 */     this.rows = (SearchRow[])remove((Object[])this.rows, this.entryCount + 1, paramInt);
/*     */   }
/*     */   
/*     */   int getEntryCount() {
/* 203 */     return this.entryCount;
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtree split(int paramInt) {
/* 208 */     int i = this.index.getPageStore().allocatePage();
/* 209 */     PageBtreeLeaf pageBtreeLeaf = create(this.index, i, this.parentPageId);
/* 210 */     for (int j = paramInt; j < this.entryCount; ) {
/* 211 */       pageBtreeLeaf.addRow(getRow(paramInt), false);
/* 212 */       removeRow(paramInt);
/*     */     } 
/* 214 */     memoryChange();
/* 215 */     pageBtreeLeaf.memoryChange();
/* 216 */     return pageBtreeLeaf;
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtreeLeaf getFirstLeaf() {
/* 221 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   PageBtreeLeaf getLastLeaf() {
/* 226 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   SearchRow remove(SearchRow paramSearchRow) {
/* 231 */     int i = find(paramSearchRow, false, false, true);
/* 232 */     SearchRow searchRow = getRow(i);
/* 233 */     if (this.index.compareRows(paramSearchRow, searchRow) != 0 || searchRow.getKey() != paramSearchRow.getKey()) {
/* 234 */       throw DbException.get(90112, this.index.getSQL() + ": " + paramSearchRow);
/*     */     }
/*     */     
/* 237 */     this.index.getPageStore().logUndo(this, this.data);
/* 238 */     if (this.entryCount == 1)
/*     */     {
/* 240 */       return paramSearchRow;
/*     */     }
/* 242 */     removeRow(i);
/* 243 */     memoryChange();
/* 244 */     this.index.getPageStore().update(this);
/* 245 */     if (i == this.entryCount)
/*     */     {
/* 247 */       return getRow(i - 1);
/*     */     }
/*     */     
/* 250 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   void freeRecursive() {
/* 255 */     this.index.getPageStore().logUndo(this, this.data);
/* 256 */     this.index.getPageStore().free(getPos());
/*     */   }
/*     */ 
/*     */   
/*     */   int getRowCount() {
/* 261 */     return this.entryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void setRowCountStored(int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void write() {
/* 271 */     writeData();
/* 272 */     this.index.getPageStore().writePage(getPos(), this.data);
/*     */   }
/*     */   
/*     */   private void writeHead() {
/* 276 */     this.data.reset();
/* 277 */     this.data.writeByte((byte)(0x4 | (this.onlyPosition ? 0 : 16)));
/*     */     
/* 279 */     this.data.writeShortInt(0);
/* 280 */     this.data.writeInt(this.parentPageId);
/* 281 */     this.data.writeVarInt(this.index.getId());
/* 282 */     this.data.writeShortInt(this.entryCount);
/*     */   }
/*     */   
/*     */   private void writeData() {
/* 286 */     if (this.written) {
/*     */       return;
/*     */     }
/* 289 */     if (!this.optimizeUpdate) {
/* 290 */       readAllRows();
/*     */     }
/* 292 */     writeHead(); byte b;
/* 293 */     for (b = 0; b < this.entryCount; b++) {
/* 294 */       this.data.writeShortInt(this.offsets[b]);
/*     */     }
/* 296 */     if (!this.writtenData || !this.optimizeUpdate) {
/* 297 */       for (b = 0; b < this.entryCount; b++) {
/* 298 */         this.index.writeRow(this.data, this.offsets[b], this.rows[b], this.onlyPosition);
/*     */       }
/* 300 */       this.writtenData = true;
/*     */     } 
/* 302 */     this.written = true;
/* 303 */     memoryChange();
/*     */   }
/*     */ 
/*     */   
/*     */   void find(PageBtreeCursor paramPageBtreeCursor, SearchRow paramSearchRow, boolean paramBoolean) {
/* 308 */     int i = find(paramSearchRow, paramBoolean, false, false);
/* 309 */     if (i > this.entryCount) {
/* 310 */       if (this.parentPageId == 0) {
/*     */         return;
/*     */       }
/* 313 */       PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 314 */       pageBtreeNode.find(paramPageBtreeCursor, paramSearchRow, paramBoolean);
/*     */       return;
/*     */     } 
/* 317 */     paramPageBtreeCursor.setCurrent(this, i);
/*     */   }
/*     */ 
/*     */   
/*     */   void last(PageBtreeCursor paramPageBtreeCursor) {
/* 322 */     paramPageBtreeCursor.setCurrent(this, this.entryCount - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remapChildren() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void nextPage(PageBtreeCursor paramPageBtreeCursor) {
/* 336 */     if (this.parentPageId == 0) {
/* 337 */       paramPageBtreeCursor.setCurrent(null, 0);
/*     */       return;
/*     */     } 
/* 340 */     PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 341 */     pageBtreeNode.nextPage(paramPageBtreeCursor, getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void previousPage(PageBtreeCursor paramPageBtreeCursor) {
/* 350 */     if (this.parentPageId == 0) {
/* 351 */       paramPageBtreeCursor.setCurrent(null, 0);
/*     */       return;
/*     */     } 
/* 354 */     PageBtreeNode pageBtreeNode = (PageBtreeNode)this.index.getPage(this.parentPageId);
/* 355 */     pageBtreeNode.previousPage(paramPageBtreeCursor, getPos());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 360 */     return "page[" + getPos() + "] b-tree leaf table:" + this.index.getId() + " entries:" + this.entryCount;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 366 */     PageStore pageStore = this.index.getPageStore();
/* 367 */     readAllRows();
/* 368 */     PageBtreeLeaf pageBtreeLeaf = create(this.index, paramInt, this.parentPageId);
/* 369 */     pageStore.logUndo(this, this.data);
/* 370 */     pageStore.logUndo(pageBtreeLeaf, null);
/* 371 */     pageBtreeLeaf.rows = this.rows;
/* 372 */     pageBtreeLeaf.entryCount = this.entryCount;
/* 373 */     pageBtreeLeaf.offsets = this.offsets;
/* 374 */     pageBtreeLeaf.onlyPosition = this.onlyPosition;
/* 375 */     pageBtreeLeaf.parentPageId = this.parentPageId;
/* 376 */     pageBtreeLeaf.start = this.start;
/* 377 */     pageStore.update(pageBtreeLeaf);
/* 378 */     if (this.parentPageId == 0) {
/* 379 */       this.index.setRootPageId(paramSession, paramInt);
/*     */     } else {
/* 381 */       PageBtreeNode pageBtreeNode = (PageBtreeNode)pageStore.getPage(this.parentPageId);
/* 382 */       pageBtreeNode.moveChild(getPos(), paramInt);
/*     */     } 
/* 384 */     pageStore.free(getPos());
/*     */   }
/*     */ 
/*     */   
/*     */   protected void memoryChange() {
/* 389 */     if (!PageBtreeIndex.isMemoryChangeRequired()) {
/*     */       return;
/*     */     }
/* 392 */     int i = 184 + this.index.getPageStore().getPageSize();
/* 393 */     if (this.rows != null) {
/* 394 */       i += getEntryCount() * 12;
/* 395 */       for (byte b = 0; b < this.entryCount; b++) {
/* 396 */         SearchRow searchRow = this.rows[b];
/* 397 */         if (searchRow != null) {
/* 398 */           i += searchRow.getMemory();
/*     */         }
/*     */       } 
/*     */     } 
/* 402 */     this.index.memoryChange(i >> 2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageBtreeLeaf.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */