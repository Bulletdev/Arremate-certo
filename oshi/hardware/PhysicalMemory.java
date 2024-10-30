/*     */ package oshi.hardware;
/*     */ 
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.util.FormatUtil;
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
/*     */ @Immutable
/*     */ public class PhysicalMemory
/*     */ {
/*     */   private final String bankLabel;
/*     */   private final long capacity;
/*     */   private final long clockSpeed;
/*     */   private final String manufacturer;
/*     */   private final String memoryType;
/*     */   
/*     */   public PhysicalMemory(String paramString1, long paramLong1, long paramLong2, String paramString2, String paramString3) {
/*  43 */     this.bankLabel = paramString1;
/*  44 */     this.capacity = paramLong1;
/*  45 */     this.clockSpeed = paramLong2;
/*  46 */     this.manufacturer = paramString2;
/*  47 */     this.memoryType = paramString3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBankLabel() {
/*  56 */     return this.bankLabel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCapacity() {
/*  65 */     return this.capacity;
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
/*     */   public long getClockSpeed() {
/*  77 */     return this.clockSpeed;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  86 */     return this.manufacturer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMemoryType() {
/*  95 */     return this.memoryType;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuilder stringBuilder = new StringBuilder();
/* 101 */     stringBuilder.append("Bank label: " + getBankLabel());
/* 102 */     stringBuilder.append(", Capacity: " + FormatUtil.formatBytes(getCapacity()));
/* 103 */     stringBuilder.append(", Clock speed: " + FormatUtil.formatHertz(getClockSpeed()));
/* 104 */     stringBuilder.append(", Manufacturer: " + getManufacturer());
/* 105 */     stringBuilder.append(", Memory type: " + getMemoryType());
/* 106 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\PhysicalMemory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */