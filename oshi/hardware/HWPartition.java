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
/*     */ public class HWPartition
/*     */ {
/*     */   private final String identification;
/*     */   private final String name;
/*     */   private final String type;
/*     */   private final String uuid;
/*     */   private final long size;
/*     */   private final int major;
/*     */   private final int minor;
/*     */   private final String mountPoint;
/*     */   
/*     */   public HWPartition(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt1, int paramInt2, String paramString5) {
/*  69 */     this.identification = paramString1;
/*  70 */     this.name = paramString2;
/*  71 */     this.type = paramString3;
/*  72 */     this.uuid = paramString4;
/*  73 */     this.size = paramLong;
/*  74 */     this.major = paramInt1;
/*  75 */     this.minor = paramInt2;
/*  76 */     this.mountPoint = paramString5;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getIdentification() {
/*  87 */     return this.identification;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  98 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getType() {
/* 109 */     return this.type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUuid() {
/* 120 */     return this.uuid;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getSize() {
/* 131 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMajor() {
/* 142 */     return this.major;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinor() {
/* 153 */     return this.minor;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMountPoint() {
/* 164 */     return this.mountPoint;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 169 */     StringBuilder stringBuilder = new StringBuilder();
/* 170 */     stringBuilder.append(getIdentification()).append(": ");
/* 171 */     stringBuilder.append(getName()).append(" ");
/* 172 */     stringBuilder.append("(").append(getType()).append(") ");
/* 173 */     stringBuilder.append("Maj:Min=").append(getMajor()).append(":").append(getMinor()).append(", ");
/* 174 */     stringBuilder.append("size: ").append(FormatUtil.formatBytesDecimal(getSize()));
/* 175 */     stringBuilder.append(getMountPoint().isEmpty() ? "" : (" @ " + getMountPoint()));
/* 176 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\HWPartition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */