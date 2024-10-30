/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.GraphicsCard;
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
/*     */ public abstract class AbstractGraphicsCard
/*     */   implements GraphicsCard
/*     */ {
/*     */   private final String name;
/*     */   private final String deviceId;
/*     */   private final String vendor;
/*     */   private final String versionInfo;
/*     */   private long vram;
/*     */   
/*     */   protected AbstractGraphicsCard(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong) {
/*  56 */     this.name = paramString1;
/*  57 */     this.deviceId = paramString2;
/*  58 */     this.vendor = paramString3;
/*  59 */     this.versionInfo = paramString4;
/*  60 */     this.vram = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  65 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeviceId() {
/*  70 */     return this.deviceId;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVendor() {
/*  75 */     return this.vendor;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersionInfo() {
/*  80 */     return this.versionInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getVRam() {
/*  85 */     return this.vram;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  90 */     StringBuilder stringBuilder = new StringBuilder();
/*  91 */     stringBuilder.append("GraphicsCard@");
/*  92 */     stringBuilder.append(Integer.toHexString(hashCode()));
/*  93 */     stringBuilder.append(" [name=");
/*  94 */     stringBuilder.append(this.name);
/*  95 */     stringBuilder.append(", deviceId=");
/*  96 */     stringBuilder.append(this.deviceId);
/*  97 */     stringBuilder.append(", vendor=");
/*  98 */     stringBuilder.append(this.vendor);
/*  99 */     stringBuilder.append(", vRam=");
/* 100 */     stringBuilder.append(this.vram);
/* 101 */     stringBuilder.append(", versionInfo=[");
/* 102 */     stringBuilder.append(this.versionInfo);
/* 103 */     stringBuilder.append("]]");
/* 104 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractGraphicsCard.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */