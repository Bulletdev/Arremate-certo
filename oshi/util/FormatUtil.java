/*     */ package oshi.util;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
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
/*     */ @ThreadSafe
/*     */ public final class FormatUtil
/*     */ {
/*     */   private static final long KIBI = 1024L;
/*     */   private static final long MEBI = 1048576L;
/*     */   private static final long GIBI = 1073741824L;
/*     */   private static final long TEBI = 1099511627776L;
/*     */   private static final long PEBI = 1125899906842624L;
/*     */   private static final long EXBI = 1152921504606846976L;
/*     */   private static final long KILO = 1000L;
/*     */   private static final long MEGA = 1000000L;
/*     */   private static final long GIGA = 1000000000L;
/*     */   private static final long TERA = 1000000000000L;
/*     */   private static final long PETA = 1000000000000000L;
/*     */   private static final long EXA = 1000000000000000000L;
/*  63 */   private static final BigInteger TWOS_COMPLEMENT_REF = BigInteger.ONE.shiftLeft(64);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String HEX_ERROR = "0x%08X";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatBytes(long paramLong) {
/*  83 */     if (paramLong == 1L)
/*  84 */       return String.format("%d byte", new Object[] { Long.valueOf(paramLong) }); 
/*  85 */     if (paramLong < 1024L)
/*  86 */       return String.format("%d bytes", new Object[] { Long.valueOf(paramLong) }); 
/*  87 */     if (paramLong < 1048576L)
/*  88 */       return formatUnits(paramLong, 1024L, "KiB"); 
/*  89 */     if (paramLong < 1073741824L)
/*  90 */       return formatUnits(paramLong, 1048576L, "MiB"); 
/*  91 */     if (paramLong < 1099511627776L)
/*  92 */       return formatUnits(paramLong, 1073741824L, "GiB"); 
/*  93 */     if (paramLong < 1125899906842624L)
/*  94 */       return formatUnits(paramLong, 1099511627776L, "TiB"); 
/*  95 */     if (paramLong < 1152921504606846976L) {
/*  96 */       return formatUnits(paramLong, 1125899906842624L, "PiB");
/*     */     }
/*  98 */     return formatUnits(paramLong, 1152921504606846976L, "EiB");
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
/*     */   
/*     */   private static String formatUnits(long paramLong1, long paramLong2, String paramString) {
/* 115 */     if (paramLong1 % paramLong2 == 0L) {
/* 116 */       return String.format("%d %s", new Object[] { Long.valueOf(paramLong1 / paramLong2), paramString });
/*     */     }
/* 118 */     return String.format("%.1f %s", new Object[] { Double.valueOf(paramLong1 / paramLong2), paramString });
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
/*     */   public static String formatBytesDecimal(long paramLong) {
/* 131 */     if (paramLong == 1L)
/* 132 */       return String.format("%d byte", new Object[] { Long.valueOf(paramLong) }); 
/* 133 */     if (paramLong < 1000L) {
/* 134 */       return String.format("%d bytes", new Object[] { Long.valueOf(paramLong) });
/*     */     }
/* 136 */     return formatValue(paramLong, "B");
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
/*     */   public static String formatHertz(long paramLong) {
/* 148 */     return formatValue(paramLong, "Hz");
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
/*     */   public static String formatValue(long paramLong, String paramString) {
/* 162 */     if (paramLong < 1000L)
/* 163 */       return String.format("%d %s", new Object[] { Long.valueOf(paramLong), paramString }).trim(); 
/* 164 */     if (paramLong < 1000000L)
/* 165 */       return formatUnits(paramLong, 1000L, "K" + paramString); 
/* 166 */     if (paramLong < 1000000000L)
/* 167 */       return formatUnits(paramLong, 1000000L, "M" + paramString); 
/* 168 */     if (paramLong < 1000000000000L)
/* 169 */       return formatUnits(paramLong, 1000000000L, "G" + paramString); 
/* 170 */     if (paramLong < 1000000000000000L)
/* 171 */       return formatUnits(paramLong, 1000000000000L, "T" + paramString); 
/* 172 */     if (paramLong < 1000000000000000000L) {
/* 173 */       return formatUnits(paramLong, 1000000000000000L, "P" + paramString);
/*     */     }
/* 175 */     return formatUnits(paramLong, 1000000000000000000L, "E" + paramString);
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
/*     */   public static String formatElapsedSecs(long paramLong) {
/* 187 */     long l1 = paramLong;
/* 188 */     long l2 = TimeUnit.SECONDS.toDays(l1);
/* 189 */     l1 -= TimeUnit.DAYS.toSeconds(l2);
/* 190 */     long l3 = TimeUnit.SECONDS.toHours(l1);
/* 191 */     l1 -= TimeUnit.HOURS.toSeconds(l3);
/* 192 */     long l4 = TimeUnit.SECONDS.toMinutes(l1);
/* 193 */     l1 -= TimeUnit.MINUTES.toSeconds(l4);
/* 194 */     long l5 = l1;
/* 195 */     return String.format("%d days, %02d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getUnsignedInt(int paramInt) {
/* 206 */     return paramInt & 0xFFFFFFFFL;
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
/*     */   public static String toUnsignedString(int paramInt) {
/* 219 */     if (paramInt >= 0) {
/* 220 */       return Integer.toString(paramInt);
/*     */     }
/* 222 */     return Long.toString(getUnsignedInt(paramInt));
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
/*     */   public static String toUnsignedString(long paramLong) {
/* 235 */     if (paramLong >= 0L) {
/* 236 */       return Long.toString(paramLong);
/*     */     }
/* 238 */     return BigInteger.valueOf(paramLong).add(TWOS_COMPLEMENT_REF).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formatError(int paramInt) {
/* 249 */     return String.format("0x%08X", new Object[] { Integer.valueOf(paramInt) });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int roundToInt(double paramDouble) {
/* 260 */     return (int)Math.round(paramDouble);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\FormatUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */