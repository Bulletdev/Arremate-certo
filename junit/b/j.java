/*     */ package junit.b;
/*     */ 
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
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
/*     */ public abstract class j
/*     */   extends a
/*     */   implements i
/*     */ {
/*     */   private String jF;
/*     */   
/*     */   public j() {
/*  88 */     this.jF = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public j(String paramString) {
/*  95 */     this.jF = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int bc() {
/* 102 */     return 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected m a() {
/* 111 */     return new m();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public m b() {
/* 121 */     m m = a();
/* 122 */     a(m);
/* 123 */     return m;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(m paramm) {
/* 130 */     paramm.a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void hf() throws Throwable {
/* 139 */     Throwable throwable = null;
/* 140 */     gZ();
/*     */     try {
/* 142 */       hg();
/* 143 */     } catch (Throwable throwable1) {
/* 144 */       throwable = throwable1;
/*     */     } finally {
/*     */       try {
/* 147 */         ha();
/* 148 */       } catch (Throwable throwable1) {
/* 149 */         if (throwable == null) throwable = throwable1; 
/*     */       } 
/*     */     } 
/* 152 */     if (throwable != null) throw throwable;
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hg() throws Throwable {
/* 161 */     a("TestCase.fName cannot be null", this.jF);
/* 162 */     Method method = null;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 168 */       method = getClass().getMethod(this.jF, (Class[])null);
/* 169 */     } catch (NoSuchMethodException noSuchMethodException) {
/* 170 */       fail("Method \"" + this.jF + "\" not found");
/*     */     } 
/* 172 */     if (!Modifier.isPublic(method.getModifiers())) {
/* 173 */       fail("Method \"" + this.jF + "\" should be public");
/*     */     }
/*     */     
/*     */     try {
/* 177 */       method.invoke(this, new Object[0]);
/* 178 */     } catch (InvocationTargetException invocationTargetException) {
/* 179 */       invocationTargetException.fillInStackTrace();
/* 180 */       throw invocationTargetException.getTargetException();
/* 181 */     } catch (IllegalAccessException illegalAccessException) {
/* 182 */       illegalAccessException.fillInStackTrace();
/* 183 */       throw illegalAccessException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString, boolean paramBoolean) {
/* 192 */     a.b(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void aq(boolean paramBoolean) {
/* 200 */     a.aq(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(String paramString, boolean paramBoolean) {
/* 208 */     a.c(paramString, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void ar(boolean paramBoolean) {
/* 216 */     a.ar(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void fail(String paramString) {
/* 223 */     a.fail(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void hc() {
/* 230 */     a.hc();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, Object paramObject1, Object paramObject2) {
/* 238 */     a.a(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void h(Object paramObject1, Object paramObject2) {
/* 246 */     a.h(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString1, String paramString2, String paramString3) {
/* 253 */     a.b(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void j(String paramString1, String paramString2) {
/* 260 */     a.j(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, double paramDouble1, double paramDouble2, double paramDouble3) {
/* 269 */     a.a(paramString, paramDouble1, paramDouble2, paramDouble3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(double paramDouble1, double paramDouble2, double paramDouble3) {
/* 277 */     a.b(paramDouble1, paramDouble2, paramDouble3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3) {
/* 286 */     a.a(paramString, paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 294 */     a.a(paramFloat1, paramFloat2, paramFloat3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, long paramLong1, long paramLong2) {
/* 302 */     a.a(paramString, paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(long paramLong1, long paramLong2) {
/* 309 */     a.c(paramLong1, paramLong2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 317 */     a.a(paramString, paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(boolean paramBoolean1, boolean paramBoolean2) {
/* 324 */     a.b(paramBoolean1, paramBoolean2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, byte paramByte1, byte paramByte2) {
/* 332 */     a.a(paramString, paramByte1, paramByte2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(byte paramByte1, byte paramByte2) {
/* 339 */     a.a(paramByte1, paramByte2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, char paramChar1, char paramChar2) {
/* 347 */     a.a(paramString, paramChar1, paramChar2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(char paramChar1, char paramChar2) {
/* 354 */     a.a(paramChar1, paramChar2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, short paramShort1, short paramShort2) {
/* 362 */     a.a(paramString, paramShort1, paramShort2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(short paramShort1, short paramShort2) {
/* 369 */     a.a(paramShort1, paramShort2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, int paramInt1, int paramInt2) {
/* 377 */     a.a(paramString, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void k(int paramInt1, int paramInt2) {
/* 384 */     a.k(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void C(Object paramObject) {
/* 391 */     a.C(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void a(String paramString, Object paramObject) {
/* 399 */     a.a(paramString, paramObject);
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
/* 410 */     a.D(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString, Object paramObject) {
/* 418 */     a.b(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void b(String paramString, Object paramObject1, Object paramObject2) {
/* 426 */     a.b(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void i(Object paramObject1, Object paramObject2) {
/* 434 */     a.i(paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void c(String paramString, Object paramObject1, Object paramObject2) {
/* 443 */     a.c(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void j(Object paramObject1, Object paramObject2) {
/* 451 */     a.j(paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public static void bd(String paramString) {
/* 455 */     a.bd(paramString);
/*     */   }
/*     */   
/*     */   public static void d(String paramString, Object paramObject1, Object paramObject2) {
/* 459 */     a.d(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public static void e(String paramString, Object paramObject1, Object paramObject2) {
/* 463 */     a.e(paramString, paramObject1, paramObject2);
/*     */   }
/*     */   
/*     */   public static String a(String paramString, Object paramObject1, Object paramObject2) {
/* 467 */     return a.a(paramString, paramObject1, paramObject2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void gZ() throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void ha() throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     return getName() + "(" + getClass().getName() + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 498 */     return this.jF;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(String paramString) {
/* 507 */     this.jF = paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\b\j.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */