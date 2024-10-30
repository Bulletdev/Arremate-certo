/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.util.BitField;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PageInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private final PageStore store;
/*     */   private final Trace trace;
/*     */   private final int firstTrunkPage;
/*     */   private final PageStreamTrunk.Iterator trunkIterator;
/*     */   private int dataPage;
/*     */   private PageStreamTrunk trunk;
/*     */   private int trunkIndex;
/*     */   private PageStreamData data;
/*     */   private int dataPos;
/*     */   private boolean endOfFile;
/*     */   private int remaining;
/*  31 */   private final byte[] buffer = new byte[] { 0 };
/*     */   private int logKey;
/*     */   
/*     */   PageInputStream(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3) {
/*  35 */     this.store = paramPageStore;
/*  36 */     this.trace = paramPageStore.getTrace();
/*     */     
/*  38 */     this.logKey = paramInt1 - 1;
/*  39 */     this.firstTrunkPage = paramInt2;
/*  40 */     this.trunkIterator = new PageStreamTrunk.Iterator(paramPageStore, paramInt2);
/*  41 */     this.dataPage = paramInt3;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  46 */     int i = read(this.buffer);
/*  47 */     return (i < 0) ? -1 : (this.buffer[0] & 0xFF);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/*  52 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  57 */     if (paramInt2 == 0) {
/*  58 */       return 0;
/*     */     }
/*  60 */     int i = 0;
/*  61 */     while (paramInt2 > 0) {
/*  62 */       int j = readBlock(paramArrayOfbyte, paramInt1, paramInt2);
/*  63 */       if (j < 0) {
/*     */         break;
/*     */       }
/*  66 */       i += j;
/*  67 */       paramInt1 += j;
/*  68 */       paramInt2 -= j;
/*     */     } 
/*  70 */     return (i == 0) ? -1 : i;
/*     */   }
/*     */   
/*     */   private int readBlock(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*     */     try {
/*  75 */       fillBuffer();
/*  76 */       if (this.endOfFile) {
/*  77 */         return -1;
/*     */       }
/*  79 */       int i = Math.min(this.remaining, paramInt2);
/*  80 */       this.data.read(this.dataPos, paramArrayOfbyte, paramInt1, i);
/*  81 */       this.remaining -= i;
/*  82 */       this.dataPos += i;
/*  83 */       return i;
/*  84 */     } catch (DbException dbException) {
/*  85 */       throw new EOFException();
/*     */     } 
/*     */   }
/*     */   private void fillBuffer() {
/*     */     int i;
/*  90 */     if (this.remaining > 0 || this.endOfFile) {
/*     */       return;
/*     */     }
/*     */     
/*     */     while (true) {
/*  95 */       if (this.trunk == null) {
/*  96 */         this.trunk = this.trunkIterator.next();
/*  97 */         this.trunkIndex = 0;
/*  98 */         this.logKey++;
/*  99 */         if (this.trunk == null || this.trunk.getLogKey() != this.logKey) {
/* 100 */           this.endOfFile = true;
/*     */           return;
/*     */         } 
/*     */       } 
/* 104 */       if (this.trunk != null) {
/* 105 */         i = this.trunk.getPageData(this.trunkIndex++);
/* 106 */         if (i == -1) {
/* 107 */           this.trunk = null; continue;
/* 108 */         }  if (this.dataPage == -1 || this.dataPage == i) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 113 */     if (this.trace.isDebugEnabled()) {
/* 114 */       this.trace.debug("pageIn.readPage " + i);
/*     */     }
/* 116 */     this.dataPage = -1;
/* 117 */     this.data = null;
/* 118 */     Page page = this.store.getPage(i);
/* 119 */     if (page instanceof PageStreamData) {
/* 120 */       this.data = (PageStreamData)page;
/*     */     }
/* 122 */     if (this.data == null || this.data.getLogKey() != this.logKey) {
/* 123 */       this.endOfFile = true;
/*     */       return;
/*     */     } 
/* 126 */     this.dataPos = PageStreamData.getReadStart();
/* 127 */     this.remaining = this.store.getPageSize() - this.dataPos;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   BitField allocateAllPages() {
/* 136 */     BitField bitField = new BitField();
/* 137 */     int i = this.logKey;
/* 138 */     PageStreamTrunk.Iterator iterator = new PageStreamTrunk.Iterator(this.store, this.firstTrunkPage);
/*     */     
/*     */     label19: while (true) {
/* 141 */       PageStreamTrunk pageStreamTrunk = iterator.next();
/* 142 */       i++;
/* 143 */       if (iterator.canDelete()) {
/* 144 */         this.store.allocatePage(iterator.getCurrentPageId());
/*     */       }
/* 146 */       if (pageStreamTrunk == null || pageStreamTrunk.getLogKey() != i) {
/*     */         break;
/*     */       }
/* 149 */       bitField.set(pageStreamTrunk.getPos());
/* 150 */       for (byte b = 0;; b++) {
/* 151 */         int j = pageStreamTrunk.getPageData(b);
/* 152 */         if (j == -1) {
/*     */           continue label19;
/*     */         }
/* 155 */         bitField.set(j);
/* 156 */         this.store.allocatePage(j);
/*     */       } 
/*     */     } 
/* 159 */     return bitField;
/*     */   }
/*     */   
/*     */   int getDataPage() {
/* 163 */     return this.data.getPos();
/*     */   }
/*     */   
/*     */   public void close() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageInputStream.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */