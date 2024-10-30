/*     */ package org.h2.store;
/*     */ 
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.util.BitField;
/*     */ import org.h2.util.IntArray;
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
/*     */ public class PageOutputStream
/*     */ {
/*     */   private PageStore store;
/*     */   private final Trace trace;
/*     */   private final BitField exclude;
/*     */   private final boolean atEnd;
/*     */   private final int minPageId;
/*     */   private int trunkPageId;
/*     */   private int trunkNext;
/*  26 */   private IntArray reservedPages = new IntArray();
/*     */ 
/*     */   
/*     */   private PageStreamTrunk trunk;
/*     */   
/*     */   private int trunkIndex;
/*     */   
/*     */   private PageStreamData data;
/*     */   
/*     */   private int reserved;
/*     */   
/*     */   private boolean needFlush;
/*     */   
/*     */   private boolean writing;
/*     */   
/*     */   private int pageCount;
/*     */   
/*     */   private int logKey;
/*     */ 
/*     */   
/*     */   public PageOutputStream(PageStore paramPageStore, int paramInt1, BitField paramBitField, int paramInt2, boolean paramBoolean) {
/*  47 */     this.trace = paramPageStore.getTrace();
/*  48 */     this.store = paramPageStore;
/*  49 */     this.trunkPageId = paramInt1;
/*  50 */     this.exclude = paramBitField;
/*     */     
/*  52 */     this.logKey = paramInt2 - 1;
/*  53 */     this.atEnd = paramBoolean;
/*  54 */     this.minPageId = paramBoolean ? paramInt1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void reserve(int paramInt) {
/*  64 */     if (this.reserved < paramInt) {
/*  65 */       int i = this.store.getPageSize();
/*  66 */       int j = PageStreamData.getCapacity(i);
/*  67 */       int k = PageStreamTrunk.getPagesAddressed(i);
/*  68 */       int m = 0, n = 0;
/*     */       
/*     */       while (true) {
/*  71 */         m += k + 1;
/*  72 */         n += k * j;
/*  73 */         if (n >= paramInt) {
/*  74 */           boolean bool = this.atEnd ? this.trunkPageId : false;
/*  75 */           this.store.allocatePages(this.reservedPages, m, this.exclude, bool);
/*  76 */           this.reserved += n;
/*  77 */           if (this.data == null)
/*  78 */             initNextData(); 
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   } private void initNextData() {
/*  84 */     int i = (this.trunk == null) ? -1 : this.trunk.getPageData(this.trunkIndex++);
/*  85 */     if (i == -1) {
/*  86 */       int j = this.trunkPageId;
/*  87 */       if (this.trunkNext != 0) {
/*  88 */         this.trunkPageId = this.trunkNext;
/*     */       }
/*  90 */       int k = PageStreamTrunk.getPagesAddressed(this.store.getPageSize());
/*  91 */       int[] arrayOfInt = new int[k];
/*  92 */       for (byte b = 0; b < k; b++) {
/*  93 */         arrayOfInt[b] = this.reservedPages.get(b);
/*     */       }
/*  95 */       this.trunkNext = this.reservedPages.get(k);
/*  96 */       this.logKey++;
/*  97 */       this.trunk = PageStreamTrunk.create(this.store, j, this.trunkPageId, this.trunkNext, this.logKey, arrayOfInt);
/*     */       
/*  99 */       this.trunkIndex = 0;
/* 100 */       this.pageCount++;
/* 101 */       this.trunk.write();
/* 102 */       this.reservedPages.removeRange(0, k + 1);
/* 103 */       i = this.trunk.getPageData(this.trunkIndex++);
/*     */     } 
/* 105 */     this.data = PageStreamData.create(this.store, i, this.trunk.getPos(), this.logKey);
/* 106 */     this.pageCount++;
/* 107 */     this.data.initWrite();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 118 */     if (paramInt2 <= 0) {
/*     */       return;
/*     */     }
/* 121 */     if (this.writing) {
/* 122 */       DbException.throwInternalError("writing while still writing");
/*     */     }
/*     */     try {
/* 125 */       reserve(paramInt2);
/* 126 */       this.writing = true;
/* 127 */       while (paramInt2 > 0) {
/* 128 */         int i = this.data.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 129 */         if (i < paramInt2) {
/* 130 */           storePage();
/* 131 */           initNextData();
/*     */         } 
/* 133 */         this.reserved -= i;
/* 134 */         paramInt1 += i;
/* 135 */         paramInt2 -= i;
/*     */       } 
/* 137 */       this.needFlush = true;
/*     */     } finally {
/* 139 */       this.writing = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void storePage() {
/* 144 */     if (this.trace.isDebugEnabled()) {
/* 145 */       this.trace.debug("pageOut.storePage " + this.data);
/*     */     }
/* 147 */     this.data.write();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush() {
/* 154 */     if (this.needFlush) {
/* 155 */       storePage();
/* 156 */       this.needFlush = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/* 164 */     this.store = null;
/*     */   }
/*     */   
/*     */   int getCurrentDataPageId() {
/* 168 */     return this.data.getPos();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void fillPage() {
/* 176 */     if (this.trace.isDebugEnabled()) {
/* 177 */       this.trace.debug("pageOut.storePage fill " + this.data.getPos());
/*     */     }
/* 179 */     reserve(this.data.getRemaining() + 1);
/* 180 */     this.reserved -= this.data.getRemaining();
/* 181 */     this.data.write();
/* 182 */     initNextData();
/*     */   }
/*     */   
/*     */   long getSize() {
/* 186 */     return (this.pageCount * this.store.getPageSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void free(PageStreamTrunk paramPageStreamTrunk) {
/* 195 */     this.pageCount -= paramPageStreamTrunk.free(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void freeReserved() {
/* 202 */     if (this.reservedPages.size() > 0) {
/* 203 */       int[] arrayOfInt = new int[this.reservedPages.size()];
/* 204 */       this.reservedPages.toArray(arrayOfInt);
/* 205 */       this.reservedPages = new IntArray();
/* 206 */       this.reserved = 0;
/* 207 */       for (int i : arrayOfInt) {
/* 208 */         this.store.free(i, false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getMinPageId() {
/* 220 */     return this.minPageId;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageOutputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */