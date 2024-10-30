/*     */ package org.h2.store;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
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
/*     */ public class PageStreamTrunk
/*     */   extends Page
/*     */ {
/*     */   private static final int DATA_START = 17;
/*     */   int parent;
/*     */   int nextTrunk;
/*     */   private final PageStore store;
/*     */   private int logKey;
/*     */   private int[] pageIds;
/*     */   private int pageCount;
/*     */   private Data data;
/*     */   
/*     */   private PageStreamTrunk(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
/*  47 */     setPos(paramInt2);
/*  48 */     this.parent = paramInt1;
/*  49 */     this.store = paramPageStore;
/*  50 */     this.nextTrunk = paramInt3;
/*  51 */     this.logKey = paramInt4;
/*  52 */     this.pageCount = paramArrayOfint.length;
/*  53 */     this.pageIds = paramArrayOfint;
/*     */   }
/*     */   
/*     */   private PageStreamTrunk(PageStore paramPageStore, Data paramData, int paramInt) {
/*  57 */     setPos(paramInt);
/*  58 */     this.data = paramData;
/*  59 */     this.store = paramPageStore;
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
/*     */   static PageStreamTrunk read(PageStore paramPageStore, Data paramData, int paramInt) {
/*  71 */     PageStreamTrunk pageStreamTrunk = new PageStreamTrunk(paramPageStore, paramData, paramInt);
/*  72 */     pageStreamTrunk.read();
/*  73 */     return pageStreamTrunk;
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
/*     */   static PageStreamTrunk create(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfint) {
/*  89 */     return new PageStreamTrunk(paramPageStore, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfint);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void read() {
/*  96 */     this.data.reset();
/*  97 */     this.data.readByte();
/*  98 */     this.data.readShortInt();
/*  99 */     this.parent = this.data.readInt();
/* 100 */     this.logKey = this.data.readInt();
/* 101 */     this.nextTrunk = this.data.readInt();
/* 102 */     this.pageCount = this.data.readShortInt();
/* 103 */     this.pageIds = new int[this.pageCount];
/* 104 */     for (byte b = 0; b < this.pageCount; b++) {
/* 105 */       this.pageIds[b] = this.data.readInt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getPageData(int paramInt) {
/* 116 */     if (paramInt >= this.pageIds.length) {
/* 117 */       return -1;
/*     */     }
/* 119 */     return this.pageIds[paramInt];
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 124 */     this.data = this.store.createData();
/* 125 */     this.data.writeByte((byte)7);
/* 126 */     this.data.writeShortInt(0);
/* 127 */     this.data.writeInt(this.parent);
/* 128 */     this.data.writeInt(this.logKey);
/* 129 */     this.data.writeInt(this.nextTrunk);
/* 130 */     this.data.writeShortInt(this.pageCount);
/* 131 */     for (byte b = 0; b < this.pageCount; b++) {
/* 132 */       this.data.writeInt(this.pageIds[b]);
/*     */     }
/* 134 */     this.store.writePage(getPos(), this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int getPagesAddressed(int paramInt) {
/* 144 */     return (paramInt - 17) / 4;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean contains(int paramInt) {
/* 154 */     for (byte b = 0; b < this.pageCount; b++) {
/* 155 */       if (this.pageIds[b] == paramInt) {
/* 156 */         return true;
/*     */       }
/*     */     } 
/* 159 */     return false;
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
/*     */   int free(int paramInt) {
/* 171 */     this.store.free(getPos(), false);
/* 172 */     byte b1 = 1;
/* 173 */     boolean bool = false;
/* 174 */     for (byte b2 = 0; b2 < this.pageCount; b2++) {
/* 175 */       int i = this.pageIds[b2];
/* 176 */       if (bool) {
/* 177 */         this.store.freeUnused(i);
/*     */       } else {
/* 179 */         this.store.free(i, false);
/*     */       } 
/* 181 */       b1++;
/* 182 */       if (i == paramInt) {
/* 183 */         bool = true;
/*     */       }
/*     */     } 
/* 186 */     return b1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 196 */     return this.store.getPageSize() >> 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {}
/*     */ 
/*     */   
/*     */   int getLogKey() {
/* 205 */     return this.logKey;
/*     */   }
/*     */   
/*     */   public int getNextTrunk() {
/* 209 */     return this.nextTrunk;
/*     */   }
/*     */ 
/*     */   
/*     */   static class Iterator
/*     */   {
/*     */     private final PageStore store;
/*     */     
/*     */     private int first;
/*     */     
/*     */     private int next;
/*     */     private int previous;
/*     */     private boolean canDelete;
/*     */     private int current;
/*     */     
/*     */     Iterator(PageStore param1PageStore, int param1Int) {
/* 225 */       this.store = param1PageStore;
/* 226 */       this.next = param1Int;
/*     */     }
/*     */     
/*     */     int getCurrentPageId() {
/* 230 */       return this.current;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     PageStreamTrunk next() {
/*     */       Page page;
/* 239 */       this.canDelete = false;
/* 240 */       if (this.first == 0) {
/* 241 */         this.first = this.next;
/* 242 */       } else if (this.first == this.next) {
/* 243 */         return null;
/*     */       } 
/* 245 */       if (this.next == 0 || this.next >= this.store.getPageCount()) {
/* 246 */         return null;
/*     */       }
/*     */       
/* 249 */       this.current = this.next;
/*     */       try {
/* 251 */         page = this.store.getPage(this.next);
/* 252 */       } catch (DbException dbException) {
/* 253 */         if (dbException.getErrorCode() == 90030)
/*     */         {
/* 255 */           return null;
/*     */         }
/* 257 */         throw dbException;
/*     */       } 
/* 259 */       if (page == null || page instanceof PageStreamTrunk || page instanceof PageStreamData)
/*     */       {
/* 261 */         this.canDelete = true;
/*     */       }
/* 263 */       if (!(page instanceof PageStreamTrunk)) {
/* 264 */         return null;
/*     */       }
/* 266 */       PageStreamTrunk pageStreamTrunk = (PageStreamTrunk)page;
/* 267 */       if (this.previous > 0 && pageStreamTrunk.parent != this.previous) {
/* 268 */         return null;
/*     */       }
/* 270 */       this.previous = this.next;
/* 271 */       this.next = pageStreamTrunk.nextTrunk;
/* 272 */       return pageStreamTrunk;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean canDelete() {
/* 282 */       return this.canDelete;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 289 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 294 */     return "page[" + getPos() + "] stream trunk key:" + this.logKey + " next:" + this.nextTrunk;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canMove() {
/* 300 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageStreamTrunk.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */