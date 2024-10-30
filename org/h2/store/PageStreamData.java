/*     */ package org.h2.store;
/*     */ 
/*     */ import org.h2.engine.Session;
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
/*     */ public class PageStreamData
/*     */   extends Page
/*     */ {
/*     */   private static final int DATA_START = 11;
/*     */   private final PageStore store;
/*     */   private int trunk;
/*     */   private int logKey;
/*     */   private Data data;
/*     */   private int remaining;
/*     */   
/*     */   private PageStreamData(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3) {
/*  31 */     setPos(paramInt1);
/*  32 */     this.store = paramPageStore;
/*  33 */     this.trunk = paramInt2;
/*  34 */     this.logKey = paramInt3;
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
/*     */   static PageStreamData read(PageStore paramPageStore, Data paramData, int paramInt) {
/*  46 */     PageStreamData pageStreamData = new PageStreamData(paramPageStore, paramInt, 0, 0);
/*  47 */     pageStreamData.data = paramData;
/*  48 */     pageStreamData.read();
/*  49 */     return pageStreamData;
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
/*     */   static PageStreamData create(PageStore paramPageStore, int paramInt1, int paramInt2, int paramInt3) {
/*  63 */     return new PageStreamData(paramPageStore, paramInt1, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void read() {
/*  70 */     this.data.reset();
/*  71 */     this.data.readByte();
/*  72 */     this.data.readShortInt();
/*  73 */     this.trunk = this.data.readInt();
/*  74 */     this.logKey = this.data.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void initWrite() {
/*  81 */     this.data = this.store.createData();
/*  82 */     this.data.writeByte((byte)8);
/*  83 */     this.data.writeShortInt(0);
/*  84 */     this.data.writeInt(this.trunk);
/*  85 */     this.data.writeInt(this.logKey);
/*  86 */     this.remaining = this.store.getPageSize() - this.data.length();
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
/*     */   int write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/*  98 */     int i = Math.min(this.remaining, paramInt2);
/*  99 */     this.data.write(paramArrayOfbyte, paramInt1, i);
/* 100 */     this.remaining -= i;
/* 101 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 106 */     this.store.writePage(getPos(), this.data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static int getCapacity(int paramInt) {
/* 116 */     return paramInt - 11;
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
/*     */   void read(int paramInt1, byte[] paramArrayOfbyte, int paramInt2, int paramInt3) {
/* 128 */     System.arraycopy(this.data.getBytes(), paramInt1, paramArrayOfbyte, paramInt2, paramInt3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getRemaining() {
/* 137 */     return this.remaining;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMemory() {
/* 147 */     return this.store.getPageSize() >> 2;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void moveTo(Session paramSession, int paramInt) {}
/*     */ 
/*     */   
/*     */   int getLogKey() {
/* 156 */     return this.logKey;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 161 */     return "[" + getPos() + "] stream data key:" + this.logKey + " pos:" + this.data.length() + " remaining:" + this.remaining;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canRemove() {
/* 167 */     return true;
/*     */   }
/*     */   
/*     */   public static int getReadStart() {
/* 171 */     return 11;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMove() {
/* 176 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\PageStreamData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */