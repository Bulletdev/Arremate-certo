/*      */ package org.junit;
/*      */ 
/*      */ import org.d.k;
/*      */ import org.d.l;
/*      */ import org.junit.b.a;
/*      */ import org.junit.c.a;
/*      */ import org.junit.c.f;
/*      */ import org.junit.c.g;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class c
/*      */ {
/*      */   public static void b(String paramString, boolean paramBoolean) {
/*   41 */     if (!paramBoolean) {
/*   42 */       fail(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void aq(boolean paramBoolean) {
/*   53 */     b((String)null, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void c(String paramString, boolean paramBoolean) {
/*   65 */     b(paramString, !paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void ar(boolean paramBoolean) {
/*   75 */     c((String)null, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void fail(String paramString) {
/*   86 */     if (paramString == null) {
/*   87 */       throw new AssertionError();
/*      */     }
/*   89 */     throw new AssertionError(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void hc() {
/*   96 */     fail(null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, Object paramObject1, Object paramObject2) {
/*  112 */     if (o(paramObject1, paramObject2)) {
/*      */       return;
/*      */     }
/*  115 */     if (paramObject1 instanceof String && paramObject2 instanceof String) {
/*  116 */       String str = (paramString == null) ? "" : paramString;
/*  117 */       throw new i(str, (String)paramObject1, (String)paramObject2);
/*      */     } 
/*      */     
/*  120 */     e(paramString, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean o(Object paramObject1, Object paramObject2) {
/*  125 */     if (paramObject1 == null) {
/*  126 */       return (paramObject2 == null);
/*      */     }
/*      */     
/*  129 */     return isEquals(paramObject1, paramObject2);
/*      */   }
/*      */   
/*      */   private static boolean isEquals(Object paramObject1, Object paramObject2) {
/*  133 */     return paramObject1.equals(paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void h(Object paramObject1, Object paramObject2) {
/*  146 */     a((String)null, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void f(String paramString, Object paramObject1, Object paramObject2) {
/*  162 */     if (o(paramObject1, paramObject2)) {
/*  163 */       c(paramString, paramObject2);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void k(Object paramObject1, Object paramObject2) {
/*  177 */     f(null, paramObject1, paramObject2);
/*      */   }
/*      */   
/*      */   private static void c(String paramString, Object paramObject) {
/*  181 */     String str = "Values should be different. ";
/*  182 */     if (paramString != null) {
/*  183 */       str = paramString + ". ";
/*      */     }
/*      */     
/*  186 */     str = str + "Actual: " + paramObject;
/*  187 */     fail(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(String paramString, long paramLong1, long paramLong2) {
/*  200 */     if (paramLong1 == paramLong2) {
/*  201 */       c(paramString, Long.valueOf(paramLong2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void d(long paramLong1, long paramLong2) {
/*  213 */     b((String)null, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(String paramString, double paramDouble1, double paramDouble2, double paramDouble3) {
/*  233 */     if (!b(paramDouble1, paramDouble2, paramDouble3)) {
/*  234 */       c(paramString, Double.valueOf(paramDouble2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void c(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  251 */     b((String)null, paramDouble1, paramDouble2, paramDouble3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  267 */     b((String)null, paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) throws a {
/*  285 */     g(paramString, paramArrayOfObject1, paramArrayOfObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  300 */     a((String)null, paramArrayOfObject1, paramArrayOfObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) throws a {
/*  316 */     g(paramString, paramArrayOfboolean1, paramArrayOfboolean2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(boolean[] paramArrayOfboolean1, boolean[] paramArrayOfboolean2) {
/*  329 */     a((String)null, paramArrayOfboolean1, paramArrayOfboolean2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) throws a {
/*  343 */     g(paramString, paramArrayOfbyte1, paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(byte[] paramArrayOfbyte1, byte[] paramArrayOfbyte2) {
/*  354 */     a((String)null, paramArrayOfbyte1, paramArrayOfbyte2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, char[] paramArrayOfchar1, char[] paramArrayOfchar2) throws a {
/*  368 */     g(paramString, paramArrayOfchar1, paramArrayOfchar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(char[] paramArrayOfchar1, char[] paramArrayOfchar2) {
/*  379 */     a((String)null, paramArrayOfchar1, paramArrayOfchar2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, short[] paramArrayOfshort1, short[] paramArrayOfshort2) throws a {
/*  393 */     g(paramString, paramArrayOfshort1, paramArrayOfshort2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(short[] paramArrayOfshort1, short[] paramArrayOfshort2) {
/*  404 */     a((String)null, paramArrayOfshort1, paramArrayOfshort2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, int[] paramArrayOfint1, int[] paramArrayOfint2) throws a {
/*  418 */     g(paramString, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(int[] paramArrayOfint1, int[] paramArrayOfint2) {
/*  429 */     a((String)null, paramArrayOfint1, paramArrayOfint2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, long[] paramArrayOflong1, long[] paramArrayOflong2) throws a {
/*  443 */     g(paramString, paramArrayOflong1, paramArrayOflong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(long[] paramArrayOflong1, long[] paramArrayOflong2) {
/*  454 */     a((String)null, paramArrayOflong1, paramArrayOflong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double paramDouble) throws a {
/*  471 */     (new g(paramDouble)).h(paramString, paramArrayOfdouble1, paramArrayOfdouble2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(double[] paramArrayOfdouble1, double[] paramArrayOfdouble2, double paramDouble) {
/*  485 */     a((String)null, paramArrayOfdouble1, paramArrayOfdouble2, paramDouble);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, float[] paramArrayOffloat1, float[] paramArrayOffloat2, float paramFloat) throws a {
/*  502 */     (new g(paramFloat)).h(paramString, paramArrayOffloat1, paramArrayOffloat2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(float[] paramArrayOffloat1, float[] paramArrayOffloat2, float paramFloat) {
/*  516 */     a((String)null, paramArrayOffloat1, paramArrayOffloat2, paramFloat);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void g(String paramString, Object paramObject1, Object paramObject2) throws a {
/*  534 */     (new f()).h(paramString, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, double paramDouble1, double paramDouble2, double paramDouble3) {
/*  554 */     if (b(paramDouble1, paramDouble2, paramDouble3)) {
/*  555 */       e(paramString, Double.valueOf(paramDouble1), Double.valueOf(paramDouble2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  576 */     if (a(paramFloat1, paramFloat2, paramFloat3)) {
/*  577 */       e(paramString, Float.valueOf(paramFloat1), Float.valueOf(paramFloat2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(String paramString, float paramFloat1, float paramFloat2, float paramFloat3) {
/*  598 */     if (!a(paramFloat1, paramFloat2, paramFloat3)) {
/*  599 */       c(paramString, Float.valueOf(paramFloat2));
/*      */     }
/*      */   }
/*      */   
/*      */   private static boolean b(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  604 */     if (Double.compare(paramDouble1, paramDouble2) == 0) {
/*  605 */       return false;
/*      */     }
/*  607 */     if (Math.abs(paramDouble1 - paramDouble2) <= paramDouble3) {
/*  608 */       return false;
/*      */     }
/*      */     
/*  611 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean a(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  615 */     if (Float.compare(paramFloat1, paramFloat2) == 0) {
/*  616 */       return false;
/*      */     }
/*  618 */     if (Math.abs(paramFloat1 - paramFloat2) <= paramFloat3) {
/*  619 */       return false;
/*      */     }
/*      */     
/*  622 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void c(long paramLong1, long paramLong2) {
/*  633 */     a((String)null, paramLong1, paramLong2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, long paramLong1, long paramLong2) {
/*  646 */     if (paramLong1 != paramLong2) {
/*  647 */       e(paramString, Long.valueOf(paramLong1), Long.valueOf(paramLong2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void e(double paramDouble1, double paramDouble2) {
/*  658 */     a((String)null, paramDouble1, paramDouble2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void a(String paramString, double paramDouble1, double paramDouble2) {
/*  669 */     fail("Use assertEquals(expected, actual, delta) to compare floating-point numbers");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(double paramDouble1, double paramDouble2, double paramDouble3) {
/*  685 */     a((String)null, paramDouble1, paramDouble2, paramDouble3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(float paramFloat1, float paramFloat2, float paramFloat3) {
/*  701 */     a((String)null, paramFloat1, paramFloat2, paramFloat3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void a(String paramString, Object paramObject) {
/*  713 */     b(paramString, (paramObject != null));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void C(Object paramObject) {
/*  723 */     a((String)null, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(String paramString, Object paramObject) {
/*  735 */     if (paramObject == null) {
/*      */       return;
/*      */     }
/*  738 */     d(paramString, paramObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void D(Object paramObject) {
/*  748 */     b((String)null, paramObject);
/*      */   }
/*      */   
/*      */   private static void d(String paramString, Object paramObject) {
/*  752 */     String str = "";
/*  753 */     if (paramString != null) {
/*  754 */       str = paramString + " ";
/*      */     }
/*  756 */     fail(str + "expected null, but was:<" + paramObject + ">");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void b(String paramString, Object paramObject1, Object paramObject2) {
/*  769 */     if (paramObject1 == paramObject2) {
/*      */       return;
/*      */     }
/*  772 */     d(paramString, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void i(Object paramObject1, Object paramObject2) {
/*  783 */     b((String)null, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void c(String paramString, Object paramObject1, Object paramObject2) {
/*  798 */     if (paramObject1 == paramObject2) {
/*  799 */       bd(paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void j(Object paramObject1, Object paramObject2) {
/*  812 */     c((String)null, paramObject1, paramObject2);
/*      */   }
/*      */   
/*      */   private static void bd(String paramString) {
/*  816 */     String str = "";
/*  817 */     if (paramString != null) {
/*  818 */       str = paramString + " ";
/*      */     }
/*  820 */     fail(str + "expected not same");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void d(String paramString, Object paramObject1, Object paramObject2) {
/*  825 */     String str = "";
/*  826 */     if (paramString != null) {
/*  827 */       str = paramString + " ";
/*      */     }
/*  829 */     fail(str + "expected same:<" + paramObject1 + "> was not:<" + paramObject2 + ">");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static void e(String paramString, Object paramObject1, Object paramObject2) {
/*  835 */     fail(a(paramString, paramObject1, paramObject2));
/*      */   }
/*      */   
/*      */   static String a(String paramString, Object paramObject1, Object paramObject2) {
/*  839 */     String str1 = "";
/*  840 */     if (paramString != null && !"".equals(paramString)) {
/*  841 */       str1 = paramString + " ";
/*      */     }
/*  843 */     String str2 = String.valueOf(paramObject1);
/*  844 */     String str3 = String.valueOf(paramObject2);
/*  845 */     if (o(str2, str3)) {
/*  846 */       return str1 + "expected: " + a(paramObject1, str2) + " but was: " + a(paramObject2, str3);
/*      */     }
/*      */ 
/*      */     
/*  850 */     return str1 + "expected:<" + str2 + "> but was:<" + str3 + ">";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static String d(Class<?> paramClass) {
/*  856 */     String str = paramClass.getCanonicalName();
/*  857 */     return (str == null) ? paramClass.getName() : str;
/*      */   }
/*      */   
/*      */   private static String a(Object paramObject, String paramString) {
/*  861 */     String str = (paramObject == null) ? "null" : paramObject.getClass().getName();
/*  862 */     return str + "<" + paramString + ">";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void b(String paramString, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  882 */     a(paramString, paramArrayOfObject1, paramArrayOfObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static void b(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/*  899 */     a(paramArrayOfObject1, paramArrayOfObject2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> void a(T paramT, k<? super T> paramk) {
/*  930 */     a("", paramT, paramk);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public static <T> void a(String paramString, T paramT, k<? super T> paramk) {
/*  964 */     l.a(paramString, paramT, paramk);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Throwable> T a(Class<T> paramClass, a parama) {
/*  981 */     return a((String)null, paramClass, parama);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static <T extends Throwable> T a(String paramString, Class<T> paramClass, a parama) {
/*      */     try {
/* 1001 */       parama.run();
/* 1002 */     } catch (Throwable throwable) {
/* 1003 */       if (paramClass.isInstance(throwable)) {
/* 1004 */         return (T)throwable;
/*      */       }
/*      */       
/* 1007 */       String str1 = d(paramClass);
/* 1008 */       Class<?> clazz = throwable.getClass();
/* 1009 */       String str2 = d(clazz);
/* 1010 */       if (str1.equals(str2)) {
/*      */ 
/*      */         
/* 1013 */         str1 = str1 + "@" + Integer.toHexString(System.identityHashCode(paramClass));
/* 1014 */         str2 = str2 + "@" + Integer.toHexString(System.identityHashCode(clazz));
/*      */       } 
/* 1016 */       String str3 = bo(paramString) + a("unexpected exception type thrown;", str1, str2);
/*      */ 
/*      */ 
/*      */       
/* 1020 */       AssertionError assertionError = new AssertionError(str3);
/* 1021 */       assertionError.initCause(throwable);
/* 1022 */       throw assertionError;
/*      */     } 
/*      */     
/* 1025 */     String str = bo(paramString) + String.format("expected %s to be thrown, but nothing was thrown", new Object[] { d(paramClass) });
/*      */ 
/*      */     
/* 1028 */     throw new AssertionError(str);
/*      */   }
/*      */   
/*      */   private static String bo(String paramString) {
/* 1032 */     return (paramString != null && paramString.length() != 0) ? (paramString + ": ") : "";
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\c.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */