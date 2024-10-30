/*     */ package ch.qos.logback.core.joran.util.beans;
/*     */ 
/*     */ import java.lang.reflect.Method;
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
/*     */ public class BeanUtil
/*     */ {
/*     */   public static final String PREFIX_GETTER_IS = "is";
/*     */   public static final String PREFIX_GETTER_GET = "get";
/*     */   public static final String PREFIX_SETTER = "set";
/*     */   public static final String PREFIX_ADDER = "add";
/*     */   
/*     */   public static boolean isAdder(Method paramMethod) {
/*  24 */     int i = getParameterCount(paramMethod);
/*  25 */     if (i != 1) {
/*  26 */       return false;
/*     */     }
/*  28 */     Class<?> clazz = paramMethod.getReturnType();
/*  29 */     if (clazz != void.class) {
/*  30 */       return false;
/*     */     }
/*  32 */     String str = paramMethod.getName();
/*  33 */     return str.startsWith("add");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isGetter(Method paramMethod) {
/*  42 */     int i = getParameterCount(paramMethod);
/*  43 */     if (i > 0) {
/*  44 */       return false;
/*     */     }
/*  46 */     Class<?> clazz = paramMethod.getReturnType();
/*  47 */     if (clazz == void.class) {
/*  48 */       return false;
/*     */     }
/*  50 */     String str = paramMethod.getName();
/*  51 */     if (!str.startsWith("get") && !str.startsWith("is")) {
/*  52 */       return false;
/*     */     }
/*  54 */     if (str.startsWith("is") && 
/*  55 */       !clazz.equals(boolean.class) && !clazz.equals(Boolean.class)) {
/*  56 */       return false;
/*     */     }
/*     */     
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   private static int getParameterCount(Method paramMethod) {
/*  63 */     return (paramMethod.getParameterTypes()).length;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSetter(Method paramMethod) {
/*  72 */     int i = getParameterCount(paramMethod);
/*  73 */     if (i != 1) {
/*  74 */       return false;
/*     */     }
/*  76 */     Class<?> clazz = paramMethod.getReturnType();
/*  77 */     if (clazz != void.class) {
/*  78 */       return false;
/*     */     }
/*  80 */     String str = paramMethod.getName();
/*  81 */     if (!str.startsWith("set")) {
/*  82 */       return false;
/*     */     }
/*  84 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPropertyName(Method paramMethod) {
/*  92 */     String str1 = paramMethod.getName();
/*  93 */     String str2 = getSubstringIfPrefixMatches(str1, "get");
/*  94 */     if (str2 == null) {
/*  95 */       str2 = getSubstringIfPrefixMatches(str1, "set");
/*     */     }
/*  97 */     if (str2 == null) {
/*  98 */       str2 = getSubstringIfPrefixMatches(str1, "is");
/*     */     }
/* 100 */     if (str2 == null) {
/* 101 */       str2 = getSubstringIfPrefixMatches(str1, "add");
/*     */     }
/* 103 */     return toLowerCamelCase(str2);
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
/*     */   public static String toLowerCamelCase(String paramString) {
/* 115 */     if (paramString == null) {
/* 116 */       return null;
/*     */     }
/* 118 */     if (paramString.isEmpty()) {
/* 119 */       return paramString;
/*     */     }
/* 121 */     if (paramString.length() > 1 && Character.isUpperCase(paramString.charAt(1)) && Character.isUpperCase(paramString.charAt(0))) {
/* 122 */       return paramString;
/*     */     }
/* 124 */     char[] arrayOfChar = paramString.toCharArray();
/* 125 */     arrayOfChar[0] = Character.toLowerCase(arrayOfChar[0]);
/* 126 */     return new String(arrayOfChar);
/*     */   }
/*     */   
/*     */   private static String getSubstringIfPrefixMatches(String paramString1, String paramString2) {
/* 130 */     if (paramString1.startsWith(paramString2)) {
/* 131 */       return paramString1.substring(paramString2.length());
/*     */     }
/* 133 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\jora\\util\beans\BeanUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */