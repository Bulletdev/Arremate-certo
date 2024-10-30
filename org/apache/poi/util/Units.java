/*     */ package org.apache.poi.util;
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
/*     */ public class Units
/*     */ {
/*     */   public static final int EMU_PER_PIXEL = 9525;
/*     */   public static final int EMU_PER_POINT = 12700;
/*     */   public static final int EMU_PER_CENTIMETER = 360000;
/*     */   public static final int MASTER_DPI = 576;
/*     */   public static final int PIXEL_DPI = 96;
/*     */   public static final int POINT_DPI = 72;
/*     */   
/*     */   public static int toEMU(double paramDouble) {
/*  54 */     return (int)Math.rint(12700.0D * paramDouble);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int pixelToEMU(int paramInt) {
/*  63 */     return paramInt * 9525;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static double toPoints(long paramLong) {
/*  72 */     return paramLong / 12700.0D;
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
/*     */   public static double fixedPointToDouble(int paramInt) {
/*  84 */     int i = paramInt >> 16;
/*  85 */     int j = paramInt & 0xFFFF;
/*  86 */     return i + j / 65536.0D;
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
/*     */   public static int doubleToFixedPoint(double paramDouble) {
/*  98 */     double d1 = paramDouble % 1.0D;
/*  99 */     double d2 = paramDouble - d1;
/* 100 */     int i = (int)Math.floor(d2);
/* 101 */     int j = (int)Math.rint(d1 * 65536.0D);
/* 102 */     return i << 16 | j & 0xFFFF;
/*     */   }
/*     */   
/*     */   public static double masterToPoints(int paramInt) {
/* 106 */     double d = paramInt;
/* 107 */     d *= 72.0D;
/* 108 */     d /= 576.0D;
/* 109 */     return d;
/*     */   }
/*     */   
/*     */   public static int pointsToMaster(double paramDouble) {
/* 113 */     paramDouble *= 576.0D;
/* 114 */     paramDouble /= 72.0D;
/* 115 */     return (int)Math.rint(paramDouble);
/*     */   }
/*     */   
/*     */   public static int pointsToPixel(double paramDouble) {
/* 119 */     paramDouble *= 96.0D;
/* 120 */     paramDouble /= 72.0D;
/* 121 */     return (int)Math.rint(paramDouble);
/*     */   }
/*     */   
/*     */   public static double pixelToPoints(int paramInt) {
/* 125 */     double d = paramInt;
/* 126 */     d *= 72.0D;
/* 127 */     d /= 96.0D;
/* 128 */     return d;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\po\\util\Units.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */