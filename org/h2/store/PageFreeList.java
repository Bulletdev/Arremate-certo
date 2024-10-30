/*     */ package org.h2.store;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.util.BitField;
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
/*     */ public class PageFreeList
/*     */   extends Page
/*     */ {
/*     */   private static final int DATA_START = 3;
/*     */   private final PageStore store;
/*     */   private final BitField used;
/*     */   private final int pageCount;
/*     */   private boolean full;
/*     */   private Data data;
/*     */   
/*     */   private PageFreeList(PageStore paramPageStore, int paramInt) {
/*  32 */     setPos(paramInt);
/*  33 */     this.store = paramPageStore;
/*  34 */     this.pageCount = (paramPageStore.getPageSize() - 3) * 8;
/*  35 */     this.used = new BitField(this.pageCount);
/*  36 */     this.used.set(0);
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
/*     */   static PageFreeList read(PageStore paramPageStore, Data paramData, int paramInt) {
/*  48 */     PageFreeList pageFreeList = new PageFreeList(paramPageStore, paramInt);
/*  49 */     pageFreeList.data = paramData;
/*  50 */     pageFreeList.read();
/*  51 */     return pageFreeList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static PageFreeList create(PageStore paramPageStore, int paramInt) {
/*  62 */     return new PageFreeList(paramPageStore, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int allocate(BitField paramBitField, int paramInt) {
/*     */     int j;
/*  73 */     if (this.full) {
/*  74 */       return -1;
/*     */     }
/*     */     
/*  77 */     int i = Math.max(0, paramInt - getPos());
/*     */     while (true) {
/*  79 */       j = this.used.nextClearBit(i);
/*  80 */       if (j >= this.pageCount) {
/*  81 */         if (i == 0) {
/*  82 */           this.full = true;
/*     */         }
/*  84 */         return -1;
/*     */       } 
/*  86 */       if (paramBitField != null && paramBitField.get(j + getPos())) {
/*  87 */         i = paramBitField.nextClearBit(j + getPos()) - getPos();
/*  88 */         if (i >= this.pageCount) {
/*  89 */           return -1;
/*     */         }
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/*  95 */     this.used.set(j);
/*  96 */     this.store.logUndo(this, this.data);
/*  97 */     this.store.update(this);
/*  98 */     return j + getPos();
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
/*     */   int getFirstFree(int paramInt) {
/* 110 */     if (this.full) {
/* 111 */       return -1;
/*     */     }
/* 113 */     int i = Math.max(0, paramInt - getPos());
/* 114 */     int j = this.used.nextClearBit(i);
/* 115 */     if (j >= this.pageCount) {
/* 116 */       return -1;
/*     */     }
/* 118 */     return j + getPos();
/*     */   }
/*     */   
/*     */   int getLastUsed() {
/* 122 */     int i = this.used.length() - 1;
/* 123 */     return (i <= 0) ? -1 : (i + getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void allocate(int paramInt) {
/* 132 */     int i = paramInt - getPos();
/* 133 */     if (i >= 0 && !this.used.get(i)) {
/*     */ 
/*     */ 
/*     */       
/* 137 */       this.used.set(i);
/* 138 */       this.store.logUndo(this, this.data);
/* 139 */       this.store.update(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void free(int paramInt) {
/* 149 */     this.full = false;
/* 150 */     this.store.logUndo(this, this.data);
/* 151 */     this.used.clear(paramInt - getPos());
/* 152 */     this.store.update(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void read() {
/* 159 */     this.data.reset();
/* 160 */     this.data.readByte();
/* 161 */     this.data.readShortInt();
/* 162 */     for (byte b = 0; b < this.pageCount; b += 8) {
/* 163 */       int i = this.data.readByte() & 0xFF;
/* 164 */       this.used.setByte(b, i);
/*     */     } 
/* 166 */     this.full = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 171 */     this.data = this.store.createData();
/* 172 */     this.data.writeByte((byte)6);
/* 173 */     this.data.writeShortInt(0);
/* 174 */     for (byte b = 0; b < this.pageCount; b += 8) {
/* 175 */       this.data.writeByte((byte)this.used.getByte(b));
/*     */     }
/* 177 */     this.store.writePage(getPos(), this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int getPagesAddressed(int paramInt) {
/* 187 */     return (paramInt - 3) * 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 197 */     return this.store.getPageSize() >> 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isUsed(int paramInt) {
/* 207 */     return this.used.get(paramInt - getPos());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {
/* 214 */     this.store.free(getPos(), false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 219 */     return "page [" + getPos() + "] freeList" + (this.full ? "full" : "");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 224 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMove() {
/* 229 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageFreeList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */