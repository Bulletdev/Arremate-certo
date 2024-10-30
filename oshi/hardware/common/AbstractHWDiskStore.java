/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.HWDiskStore;
/*    */ import oshi.util.FormatUtil;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public abstract class AbstractHWDiskStore
/*    */   implements HWDiskStore
/*    */ {
/*    */   private final String name;
/*    */   private final String model;
/*    */   private final String serial;
/*    */   private final long size;
/*    */   
/*    */   protected AbstractHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/* 42 */     this.name = paramString1;
/* 43 */     this.model = paramString2;
/* 44 */     this.serial = paramString3;
/* 45 */     this.size = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 50 */     return this.name;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModel() {
/* 55 */     return this.model;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSerial() {
/* 60 */     return this.serial;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getSize() {
/* 65 */     return this.size;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 70 */     boolean bool = (getReads() > 0L || getWrites() > 0L) ? true : false;
/* 71 */     StringBuilder stringBuilder = new StringBuilder();
/* 72 */     stringBuilder.append(getName()).append(": ");
/* 73 */     stringBuilder.append("(model: ").append(getModel());
/* 74 */     stringBuilder.append(" - S/N: ").append(getSerial()).append(") ");
/* 75 */     stringBuilder.append("size: ").append((getSize() > 0L) ? FormatUtil.formatBytesDecimal(getSize()) : "?").append(", ");
/* 76 */     stringBuilder.append("reads: ").append(bool ? Long.valueOf(getReads()) : "?");
/* 77 */     stringBuilder.append(" (").append(bool ? FormatUtil.formatBytes(getReadBytes()) : "?").append("), ");
/* 78 */     stringBuilder.append("writes: ").append(bool ? Long.valueOf(getWrites()) : "?");
/* 79 */     stringBuilder.append(" (").append(bool ? FormatUtil.formatBytes(getWriteBytes()) : "?").append("), ");
/* 80 */     stringBuilder.append("xfer: ").append(bool ? Long.valueOf(getTransferTime()) : "?");
/* 81 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */