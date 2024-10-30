/*     */ package junit.b;
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
/*     */ @Deprecated
/*     */ public class a
/*     */ {
/*     */   public static void b(String paramString, boolean paramBoolean) {
/*  21 */     if (!paramBoolean) {
/*  22 */       fail(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aq(boolean paramBoolean) {
/*  31 */     b((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(String paramString, boolean paramBoolean) {
/*  39 */     b(paramString, !paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ar(boolean paramBoolean) {
/*  47 */     c((String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void fail(String paramString) {
/*  54 */     if (paramString == null) {
/*  55 */       throw new b();
/*     */     }
/*  57 */     throw new b(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hc() {
/*  64 */     fail(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, Object paramObject1, Object paramObject2) {
/*  72 */     if (paramObject1 == null && paramObject2 == null) {
/*     */       return;
/*     */     }
/*  75 */     if (paramObject1 != null && paramObject1.equals(paramObject2)) {
/*     */       return;
/*     */     }
/*  78 */     e(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void h(Object paramObject1, Object paramObject2) {
/*  86 */     a((String)null, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString1, String paramString2, String paramString3) {
/*  93 */     if (paramString2 == null && paramString3 == null) {
/*     */       return;
/*     */     }
/*  96 */     if (paramString2 != null && paramString2.equals(paramString3)) {
/*     */       return;
/*     */     }
/*  99 */     String str = (paramString1 == null) ? "" : paramString1;
/* 100 */     throw new d(str, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void j(String paramString1, String paramString2) {
/* 107 */     b((String)null, paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, double paramDouble1, double paramDouble2, double paramDouble3) {
/* 116 */     if (Double.compare(paramDouble1, paramDouble2) == 0) {
/*     */       return;
/*     */     }
/* 119 */     if (Math.abs(paramDouble1 - paramDouble2) > paramDouble3) {
/* 120 */       e(paramString, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 129 */     a((String)null, paramDouble1, paramDouble2, paramDouble3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 138 */     if (Float.compare(paramFloat1, paramFloat2) == 0) {
/*     */       return;
/*     */     }
/* 141 */     if (Math.abs(paramFloat1 - paramFloat2) > paramFloat3) {
/* 142 */       e(paramString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 151 */     a((String)null, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, long paramLong1, long paramLong2) {
/* 159 */     a(paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(long paramLong1, long paramLong2) {
/* 166 */     a((String)null, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 174 */     a(paramString, Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(boolean paramBoolean1, boolean paramBoolean2) {
/* 181 */     a((String)null, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, byte paramByte1, byte paramByte2) {
/* 189 */     a(paramString, Byte.valueOf(paramByte1), Byte.valueOf(paramByte2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte paramByte1, byte paramByte2) {
/* 196 */     a((String)null, paramByte1, paramByte2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, char paramChar1, char paramChar2) {
/* 204 */     a(paramString, Character.valueOf(paramChar1), Character.valueOf(paramChar2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(char paramChar1, char paramChar2) {
/* 211 */     a((String)null, paramChar1, paramChar2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, short paramShort1, short paramShort2) {
/* 219 */     a(paramString, Short.valueOf(paramShort1), Short.valueOf(paramShort2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(short paramShort1, short paramShort2) {
/* 226 */     a((String)null, paramShort1, paramShort2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, int paramInt1, int paramInt2) {
/* 234 */     a(paramString, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void k(int paramInt1, int paramInt2) {
/* 241 */     a((String)null, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void C(Object paramObject) {
/* 248 */     a((String)null, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, Object paramObject) {
/* 256 */     b(paramString, (paramObject != null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void D(Object paramObject) {
/* 267 */     if (paramObject != null) {
/* 268 */       b("Expected: <null> but was: " + paramObject.toString(), paramObject);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString, Object paramObject) {
/* 277 */     b(paramString, (paramObject == null));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString, Object paramObject1, Object paramObject2) {
/* 285 */     if (paramObject1 == paramObject2) {
/*     */       return;
/*     */     }
/* 288 */     d(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void i(Object paramObject1, Object paramObject2) {
/* 296 */     b((String)null, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(String paramString, Object paramObject1, Object paramObject2) {
/* 305 */     if (paramObject1 == paramObject2) {
/* 306 */       bd(paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void j(Object paramObject1, Object paramObject2) {
/* 315 */     c(null, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public static void bd(String paramString) {
/* 319 */     String str = (paramString != null) ? (paramString + " ") : "";
/* 320 */     fail(str + "expected not same");
/*     */   }
/*     */   
/*     */   public static void d(String paramString, Object paramObject1, Object paramObject2) {
/* 324 */     String str = (paramString != null) ? (paramString + " ") : "";
/* 325 */     fail(str + "expected same:<" + paramObject1 + "> was not:<" + paramObject2 + ">");
/*     */   }
/*     */   
/*     */   public static void e(String paramString, Object paramObject1, Object paramObject2) {
/* 329 */     fail(a(paramString, paramObject1, paramObject2));
/*     */   }
/*     */   
/*     */   public static String a(String paramString, Object paramObject1, Object paramObject2) {
/* 333 */     String str = "";
/* 334 */     if (paramString != null && paramString.length() > 0) {
/* 335 */       str = paramString + " ";
/*     */     }
/* 337 */     return str + "expected:<" + paramObject1 + "> but was:<" + paramObject2 + ">";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */