/*      */ package org.apache.commons.lang3;
/*      */ 
/*      */ import java.lang.reflect.Method;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang3.mutable.MutableObject;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ClassUtils
/*      */ {
/*      */   public static final char PACKAGE_SEPARATOR_CHAR = '.';
/*      */   
/*      */   public enum Interfaces
/*      */   {
/*   55 */     INCLUDE,
/*      */ 
/*      */     
/*   58 */     EXCLUDE;
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
/*   69 */   public static final String PACKAGE_SEPARATOR = String.valueOf('.');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   79 */   public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   84 */   private static final Map<String, Class<?>> namePrimitiveMap = new HashMap<>();
/*      */   static {
/*   86 */     namePrimitiveMap.put("boolean", boolean.class);
/*   87 */     namePrimitiveMap.put("byte", byte.class);
/*   88 */     namePrimitiveMap.put("char", char.class);
/*   89 */     namePrimitiveMap.put("short", short.class);
/*   90 */     namePrimitiveMap.put("int", int.class);
/*   91 */     namePrimitiveMap.put("long", long.class);
/*   92 */     namePrimitiveMap.put("double", double.class);
/*   93 */     namePrimitiveMap.put("float", float.class);
/*   94 */     namePrimitiveMap.put("void", void.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  100 */   private static final Map<Class<?>, Class<?>> primitiveWrapperMap = new HashMap<>();
/*      */   static {
/*  102 */     primitiveWrapperMap.put(boolean.class, Boolean.class);
/*  103 */     primitiveWrapperMap.put(byte.class, Byte.class);
/*  104 */     primitiveWrapperMap.put(char.class, Character.class);
/*  105 */     primitiveWrapperMap.put(short.class, Short.class);
/*  106 */     primitiveWrapperMap.put(int.class, Integer.class);
/*  107 */     primitiveWrapperMap.put(long.class, Long.class);
/*  108 */     primitiveWrapperMap.put(double.class, Double.class);
/*  109 */     primitiveWrapperMap.put(float.class, Float.class);
/*  110 */     primitiveWrapperMap.put(void.class, void.class);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  116 */   private static final Map<Class<?>, Class<?>> wrapperPrimitiveMap = new HashMap<>();
/*      */   static {
/*  118 */     for (Map.Entry<Class<?>, Class<?>> entry : primitiveWrapperMap.entrySet()) {
/*  119 */       Class<?> clazz1 = (Class)entry.getKey();
/*  120 */       Class<?> clazz2 = (Class)entry.getValue();
/*  121 */       if (!clazz1.equals(clazz2)) {
/*  122 */         wrapperPrimitiveMap.put(clazz2, clazz1);
/*      */       }
/*      */     } 
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
/*  138 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/*  139 */     hashMap1.put("int", "I");
/*  140 */     hashMap1.put("boolean", "Z");
/*  141 */     hashMap1.put("float", "F");
/*  142 */     hashMap1.put("long", "J");
/*  143 */     hashMap1.put("short", "S");
/*  144 */     hashMap1.put("byte", "B");
/*  145 */     hashMap1.put("double", "D");
/*  146 */     hashMap1.put("char", "C");
/*  147 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/*  148 */     for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/*  149 */       hashMap2.put(entry.getValue(), entry.getKey());
/*      */     }
/*  151 */     abbreviationMap = Collections.unmodifiableMap(hashMap1);
/*  152 */     reverseAbbreviationMap = Collections.unmodifiableMap(hashMap2);
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
/*      */   private static final Map<String, String> abbreviationMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final Map<String, String> reverseAbbreviationMap;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortClassName(Object paramObject, String paramString) {
/*  181 */     if (paramObject == null) {
/*  182 */       return paramString;
/*      */     }
/*  184 */     return getShortClassName(paramObject.getClass());
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
/*      */   public static String getShortClassName(Class<?> paramClass) {
/*  199 */     if (paramClass == null) {
/*  200 */       return "";
/*      */     }
/*  202 */     return getShortClassName(paramClass.getName());
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
/*      */   public static String getShortClassName(String paramString) {
/*  231 */     if (StringUtils.isEmpty(paramString)) {
/*  232 */       return "";
/*      */     }
/*      */     
/*  235 */     StringBuilder stringBuilder = new StringBuilder();
/*      */ 
/*      */     
/*  238 */     if (paramString.startsWith("[")) {
/*  239 */       while (paramString.charAt(0) == '[') {
/*  240 */         paramString = paramString.substring(1);
/*  241 */         stringBuilder.append("[]");
/*      */       } 
/*      */       
/*  244 */       if (paramString.charAt(0) == 'L' && paramString.charAt(paramString.length() - 1) == ';') {
/*  245 */         paramString = paramString.substring(1, paramString.length() - 1);
/*      */       }
/*      */       
/*  248 */       if (reverseAbbreviationMap.containsKey(paramString)) {
/*  249 */         paramString = reverseAbbreviationMap.get(paramString);
/*      */       }
/*      */     } 
/*      */     
/*  253 */     int i = paramString.lastIndexOf('.');
/*  254 */     int j = paramString.indexOf('$', (i == -1) ? 0 : (i + 1));
/*      */     
/*  256 */     String str = paramString.substring(i + 1);
/*  257 */     if (j != -1) {
/*  258 */       str = str.replace('$', '.');
/*      */     }
/*  260 */     return str + stringBuilder;
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
/*      */   public static String getSimpleName(Class<?> paramClass) {
/*  272 */     return getSimpleName(paramClass, "");
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
/*      */   public static String getSimpleName(Class<?> paramClass, String paramString) {
/*  286 */     return (paramClass == null) ? paramString : paramClass.getSimpleName();
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
/*      */   public static String getSimpleName(Object paramObject) {
/*  304 */     return getSimpleName(paramObject, "");
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
/*      */   public static String getSimpleName(Object paramObject, String paramString) {
/*  318 */     return (paramObject == null) ? paramString : paramObject.getClass().getSimpleName();
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
/*      */   public static String getName(Class<?> paramClass) {
/*  330 */     return getName(paramClass, "");
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
/*      */   public static String getName(Class<?> paramClass, String paramString) {
/*  343 */     return (paramClass == null) ? paramString : paramClass.getName();
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
/*      */   public static String getName(Object paramObject) {
/*  355 */     return getName(paramObject, "");
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
/*      */   public static String getName(Object paramObject, String paramString) {
/*  368 */     return (paramObject == null) ? paramString : paramObject.getClass().getName();
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
/*      */   public static String getPackageName(Object paramObject, String paramString) {
/*  381 */     if (paramObject == null) {
/*  382 */       return paramString;
/*      */     }
/*  384 */     return getPackageName(paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageName(Class<?> paramClass) {
/*  394 */     if (paramClass == null) {
/*  395 */       return "";
/*      */     }
/*  397 */     return getPackageName(paramClass.getName());
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
/*      */   public static String getPackageName(String paramString) {
/*  410 */     if (StringUtils.isEmpty(paramString)) {
/*  411 */       return "";
/*      */     }
/*      */ 
/*      */     
/*  415 */     while (paramString.charAt(0) == '[') {
/*  416 */       paramString = paramString.substring(1);
/*      */     }
/*      */     
/*  419 */     if (paramString.charAt(0) == 'L' && paramString.charAt(paramString.length() - 1) == ';') {
/*  420 */       paramString = paramString.substring(1);
/*      */     }
/*      */     
/*  423 */     int i = paramString.lastIndexOf('.');
/*  424 */     if (i == -1) {
/*  425 */       return "";
/*      */     }
/*  427 */     return paramString.substring(0, i);
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
/*      */   public static String getAbbreviatedName(Class<?> paramClass, int paramInt) {
/*  443 */     if (paramClass == null) {
/*  444 */       return "";
/*      */     }
/*  446 */     return getAbbreviatedName(paramClass.getName(), paramInt);
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
/*      */   public static String getAbbreviatedName(String paramString, int paramInt) {
/*  490 */     if (paramInt <= 0) {
/*  491 */       throw new IllegalArgumentException("len must be > 0");
/*      */     }
/*  493 */     if (paramString == null) {
/*  494 */       return "";
/*      */     }
/*  496 */     if (paramString.length() <= paramInt) {
/*  497 */       return paramString;
/*      */     }
/*  499 */     char[] arrayOfChar = paramString.toCharArray();
/*  500 */     byte b1 = 0;
/*  501 */     byte b2 = 0;
/*  502 */     while (b2 < arrayOfChar.length) {
/*      */       
/*  504 */       byte b = b1;
/*  505 */       while (b2 < arrayOfChar.length && arrayOfChar[b2] != '.') {
/*  506 */         arrayOfChar[b++] = arrayOfChar[b2++];
/*      */       }
/*      */       
/*  509 */       b1++;
/*  510 */       if (useFull(b, b2, arrayOfChar.length, paramInt) || b1 > b)
/*      */       {
/*  512 */         b1 = b;
/*      */       }
/*      */ 
/*      */       
/*  516 */       if (b2 < arrayOfChar.length) {
/*  517 */         arrayOfChar[b1++] = arrayOfChar[b2++];
/*      */       }
/*      */     } 
/*  520 */     return new String(arrayOfChar, 0, b1);
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
/*      */ 
/*      */   
/*      */   private static boolean useFull(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  555 */     return (paramInt2 >= paramInt3 || paramInt1 + paramInt3 - paramInt2 <= paramInt4);
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
/*      */   public static List<Class<?>> getAllSuperclasses(Class<?> paramClass) {
/*  569 */     if (paramClass == null) {
/*  570 */       return null;
/*      */     }
/*  572 */     ArrayList<Class<?>> arrayList = new ArrayList();
/*  573 */     Class<?> clazz = paramClass.getSuperclass();
/*  574 */     while (clazz != null) {
/*  575 */       arrayList.add(clazz);
/*  576 */       clazz = clazz.getSuperclass();
/*      */     } 
/*  578 */     return arrayList;
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
/*      */   public static List<Class<?>> getAllInterfaces(Class<?> paramClass) {
/*  595 */     if (paramClass == null) {
/*  596 */       return null;
/*      */     }
/*      */     
/*  599 */     LinkedHashSet<Class<?>> linkedHashSet = new LinkedHashSet();
/*  600 */     getAllInterfaces(paramClass, linkedHashSet);
/*      */     
/*  602 */     return new ArrayList<>(linkedHashSet);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void getAllInterfaces(Class<?> paramClass, HashSet<Class<?>> paramHashSet) {
/*  612 */     while (paramClass != null) {
/*  613 */       Class[] arrayOfClass = paramClass.getInterfaces();
/*      */       
/*  615 */       for (Class<?> clazz : arrayOfClass) {
/*  616 */         if (paramHashSet.add(clazz)) {
/*  617 */           getAllInterfaces(clazz, paramHashSet);
/*      */         }
/*      */       } 
/*      */       
/*  621 */       paramClass = paramClass.getSuperclass();
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
/*      */   public static List<Class<?>> convertClassNamesToClasses(List<String> paramList) {
/*  640 */     if (paramList == null) {
/*  641 */       return null;
/*      */     }
/*  643 */     ArrayList<Class<?>> arrayList = new ArrayList(paramList.size());
/*  644 */     for (String str : paramList) {
/*      */       try {
/*  646 */         arrayList.add(Class.forName(str));
/*  647 */       } catch (Exception exception) {
/*  648 */         arrayList.add(null);
/*      */       } 
/*      */     } 
/*  651 */     return arrayList;
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
/*      */   public static List<String> convertClassesToClassNames(List<Class<?>> paramList) {
/*  667 */     if (paramList == null) {
/*  668 */       return null;
/*      */     }
/*  670 */     ArrayList<String> arrayList = new ArrayList(paramList.size());
/*  671 */     for (Class<?> clazz : paramList) {
/*  672 */       if (clazz == null) {
/*  673 */         arrayList.add(null); continue;
/*      */       } 
/*  675 */       arrayList.add(clazz.getName());
/*      */     } 
/*      */     
/*  678 */     return arrayList;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class<?>[] paramArrayOfClass1, Class<?>... paramVarArgs1) {
/*  720 */     return isAssignable(paramArrayOfClass1, paramVarArgs1, true);
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2, boolean paramBoolean) {
/*  756 */     if (!ArrayUtils.isSameLength((Object[])paramArrayOfClass1, (Object[])paramArrayOfClass2)) {
/*  757 */       return false;
/*      */     }
/*  759 */     if (paramArrayOfClass1 == null) {
/*  760 */       paramArrayOfClass1 = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  762 */     if (paramArrayOfClass2 == null) {
/*  763 */       paramArrayOfClass2 = ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/*  765 */     for (byte b = 0; b < paramArrayOfClass1.length; b++) {
/*  766 */       if (!isAssignable(paramArrayOfClass1[b], paramArrayOfClass2[b], paramBoolean)) {
/*  767 */         return false;
/*      */       }
/*      */     } 
/*  770 */     return true;
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
/*      */   public static boolean isPrimitiveOrWrapper(Class<?> paramClass) {
/*  784 */     if (paramClass == null) {
/*  785 */       return false;
/*      */     }
/*  787 */     return (paramClass.isPrimitive() || isPrimitiveWrapper(paramClass));
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
/*      */   public static boolean isPrimitiveWrapper(Class<?> paramClass) {
/*  801 */     return wrapperPrimitiveMap.containsKey(paramClass);
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
/*      */ 
/*      */   
/*      */   public static boolean isAssignable(Class<?> paramClass1, Class<?> paramClass2) {
/*  836 */     return isAssignable(paramClass1, paramClass2, true);
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
/*      */   public static boolean isAssignable(Class<?> paramClass1, Class<?> paramClass2, boolean paramBoolean) {
/*  867 */     if (paramClass2 == null) {
/*  868 */       return false;
/*      */     }
/*      */     
/*  871 */     if (paramClass1 == null) {
/*  872 */       return !paramClass2.isPrimitive();
/*      */     }
/*      */     
/*  875 */     if (paramBoolean) {
/*  876 */       if (paramClass1.isPrimitive() && !paramClass2.isPrimitive()) {
/*  877 */         paramClass1 = primitiveToWrapper(paramClass1);
/*  878 */         if (paramClass1 == null) {
/*  879 */           return false;
/*      */         }
/*      */       } 
/*  882 */       if (paramClass2.isPrimitive() && !paramClass1.isPrimitive()) {
/*  883 */         paramClass1 = wrapperToPrimitive(paramClass1);
/*  884 */         if (paramClass1 == null) {
/*  885 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*  889 */     if (paramClass1.equals(paramClass2)) {
/*  890 */       return true;
/*      */     }
/*  892 */     if (paramClass1.isPrimitive()) {
/*  893 */       if (!paramClass2.isPrimitive()) {
/*  894 */         return false;
/*      */       }
/*  896 */       if (int.class.equals(paramClass1)) {
/*  897 */         return (long.class.equals(paramClass2) || float.class
/*  898 */           .equals(paramClass2) || double.class
/*  899 */           .equals(paramClass2));
/*      */       }
/*  901 */       if (long.class.equals(paramClass1)) {
/*  902 */         return (float.class.equals(paramClass2) || double.class
/*  903 */           .equals(paramClass2));
/*      */       }
/*  905 */       if (boolean.class.equals(paramClass1)) {
/*  906 */         return false;
/*      */       }
/*  908 */       if (double.class.equals(paramClass1)) {
/*  909 */         return false;
/*      */       }
/*  911 */       if (float.class.equals(paramClass1)) {
/*  912 */         return double.class.equals(paramClass2);
/*      */       }
/*  914 */       if (char.class.equals(paramClass1)) {
/*  915 */         return (int.class.equals(paramClass2) || long.class
/*  916 */           .equals(paramClass2) || float.class
/*  917 */           .equals(paramClass2) || double.class
/*  918 */           .equals(paramClass2));
/*      */       }
/*  920 */       if (short.class.equals(paramClass1)) {
/*  921 */         return (int.class.equals(paramClass2) || long.class
/*  922 */           .equals(paramClass2) || float.class
/*  923 */           .equals(paramClass2) || double.class
/*  924 */           .equals(paramClass2));
/*      */       }
/*  926 */       if (byte.class.equals(paramClass1)) {
/*  927 */         return (short.class.equals(paramClass2) || int.class
/*  928 */           .equals(paramClass2) || long.class
/*  929 */           .equals(paramClass2) || float.class
/*  930 */           .equals(paramClass2) || double.class
/*  931 */           .equals(paramClass2));
/*      */       }
/*      */       
/*  934 */       return false;
/*      */     } 
/*  936 */     return paramClass2.isAssignableFrom(paramClass1);
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
/*      */   public static Class<?> primitiveToWrapper(Class<?> paramClass) {
/*  952 */     Class<?> clazz = paramClass;
/*  953 */     if (paramClass != null && paramClass.isPrimitive()) {
/*  954 */       clazz = primitiveWrapperMap.get(paramClass);
/*      */     }
/*  956 */     return clazz;
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
/*      */   public static Class<?>[] primitivesToWrappers(Class<?>... paramVarArgs) {
/*  970 */     if (paramVarArgs == null) {
/*  971 */       return null;
/*      */     }
/*      */     
/*  974 */     if (paramVarArgs.length == 0) {
/*  975 */       return paramVarArgs;
/*      */     }
/*      */     
/*  978 */     Class[] arrayOfClass = new Class[paramVarArgs.length];
/*  979 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/*  980 */       arrayOfClass[b] = primitiveToWrapper(paramVarArgs[b]);
/*      */     }
/*  982 */     return arrayOfClass;
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
/*      */   public static Class<?> wrapperToPrimitive(Class<?> paramClass) {
/* 1002 */     return wrapperPrimitiveMap.get(paramClass);
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
/*      */   public static Class<?>[] wrappersToPrimitives(Class<?>... paramVarArgs) {
/* 1020 */     if (paramVarArgs == null) {
/* 1021 */       return null;
/*      */     }
/*      */     
/* 1024 */     if (paramVarArgs.length == 0) {
/* 1025 */       return paramVarArgs;
/*      */     }
/*      */     
/* 1028 */     Class[] arrayOfClass = new Class[paramVarArgs.length];
/* 1029 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 1030 */       arrayOfClass[b] = wrapperToPrimitive(paramVarArgs[b]);
/*      */     }
/* 1032 */     return arrayOfClass;
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
/*      */   public static boolean isInnerClass(Class<?> paramClass) {
/* 1045 */     return (paramClass != null && paramClass.getEnclosingClass() != null);
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
/*      */   public static Class<?> getClass(ClassLoader paramClassLoader, String paramString, boolean paramBoolean) throws ClassNotFoundException {
/*      */     try {
/*      */       Class<?> clazz;
/* 1066 */       if (namePrimitiveMap.containsKey(paramString)) {
/* 1067 */         clazz = namePrimitiveMap.get(paramString);
/*      */       } else {
/* 1069 */         clazz = Class.forName(toCanonicalName(paramString), paramBoolean, paramClassLoader);
/*      */       } 
/* 1071 */       return clazz;
/* 1072 */     } catch (ClassNotFoundException classNotFoundException) {
/*      */       
/* 1074 */       int i = paramString.lastIndexOf('.');
/*      */       
/* 1076 */       if (i != -1) {
/*      */         try {
/* 1078 */           return getClass(paramClassLoader, paramString.substring(0, i) + '$' + paramString
/* 1079 */               .substring(i + 1), paramBoolean);
/*      */         }
/* 1081 */         catch (ClassNotFoundException classNotFoundException1) {}
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1086 */       throw classNotFoundException;
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
/*      */   public static Class<?> getClass(ClassLoader paramClassLoader, String paramString) throws ClassNotFoundException {
/* 1103 */     return getClass(paramClassLoader, paramString, true);
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
/*      */   public static Class<?> getClass(String paramString) throws ClassNotFoundException {
/* 1118 */     return getClass(paramString, true);
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
/*      */   public static Class<?> getClass(String paramString, boolean paramBoolean) throws ClassNotFoundException {
/* 1133 */     ClassLoader classLoader1 = Thread.currentThread().getContextClassLoader();
/* 1134 */     ClassLoader classLoader2 = (classLoader1 == null) ? ClassUtils.class.getClassLoader() : classLoader1;
/* 1135 */     return getClass(classLoader2, paramString, paramBoolean);
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
/*      */   public static Method getPublicMethod(Class<?> paramClass, String paramString, Class<?>... paramVarArgs) throws NoSuchMethodException {
/* 1165 */     Method method = paramClass.getMethod(paramString, paramVarArgs);
/* 1166 */     if (Modifier.isPublic(method.getDeclaringClass().getModifiers())) {
/* 1167 */       return method;
/*      */     }
/*      */     
/* 1170 */     ArrayList<Class<?>> arrayList = new ArrayList();
/* 1171 */     arrayList.addAll(getAllInterfaces(paramClass));
/* 1172 */     arrayList.addAll(getAllSuperclasses(paramClass));
/*      */     
/* 1174 */     for (Class<?> clazz : arrayList) {
/* 1175 */       Method method1; if (!Modifier.isPublic(clazz.getModifiers())) {
/*      */         continue;
/*      */       }
/*      */       
/*      */       try {
/* 1180 */         method1 = clazz.getMethod(paramString, paramVarArgs);
/* 1181 */       } catch (NoSuchMethodException noSuchMethodException) {
/*      */         continue;
/*      */       } 
/* 1184 */       if (Modifier.isPublic(method1.getDeclaringClass().getModifiers())) {
/* 1185 */         return method1;
/*      */       }
/*      */     } 
/*      */     
/* 1189 */     throw new NoSuchMethodException("Can't find a public method for " + paramString + " " + 
/* 1190 */         ArrayUtils.toString(paramVarArgs));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String toCanonicalName(String paramString) {
/* 1201 */     paramString = StringUtils.deleteWhitespace(paramString);
/* 1202 */     Validate.notNull(paramString, "className must not be null.", new Object[0]);
/* 1203 */     if (paramString.endsWith("[]")) {
/* 1204 */       StringBuilder stringBuilder = new StringBuilder();
/* 1205 */       while (paramString.endsWith("[]")) {
/* 1206 */         paramString = paramString.substring(0, paramString.length() - 2);
/* 1207 */         stringBuilder.append("[");
/*      */       } 
/* 1209 */       String str = abbreviationMap.get(paramString);
/* 1210 */       if (str != null) {
/* 1211 */         stringBuilder.append(str);
/*      */       } else {
/* 1213 */         stringBuilder.append("L").append(paramString).append(";");
/*      */       } 
/* 1215 */       paramString = stringBuilder.toString();
/*      */     } 
/* 1217 */     return paramString;
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
/*      */   public static Class<?>[] toClass(Object... paramVarArgs) {
/* 1231 */     if (paramVarArgs == null)
/* 1232 */       return null; 
/* 1233 */     if (paramVarArgs.length == 0) {
/* 1234 */       return ArrayUtils.EMPTY_CLASS_ARRAY;
/*      */     }
/* 1236 */     Class[] arrayOfClass = new Class[paramVarArgs.length];
/* 1237 */     for (byte b = 0; b < paramVarArgs.length; b++) {
/* 1238 */       arrayOfClass[b] = (paramVarArgs[b] == null) ? null : paramVarArgs[b].getClass();
/*      */     }
/* 1240 */     return arrayOfClass;
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
/*      */   public static String getShortCanonicalName(Object paramObject, String paramString) {
/* 1254 */     if (paramObject == null) {
/* 1255 */       return paramString;
/*      */     }
/* 1257 */     return getShortCanonicalName(paramObject.getClass().getName());
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
/*      */   public static String getCanonicalName(Class<?> paramClass) {
/* 1269 */     return getCanonicalName(paramClass, "");
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
/*      */   public static String getCanonicalName(Class<?> paramClass, String paramString) {
/* 1282 */     if (paramClass == null) {
/* 1283 */       return paramString;
/*      */     }
/* 1285 */     String str = paramClass.getCanonicalName();
/* 1286 */     return (str == null) ? paramString : str;
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
/*      */   public static String getCanonicalName(Object paramObject) {
/* 1298 */     return getCanonicalName(paramObject, "");
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
/*      */   public static String getCanonicalName(Object paramObject, String paramString) {
/* 1311 */     if (paramObject == null) {
/* 1312 */       return paramString;
/*      */     }
/* 1314 */     String str = paramObject.getClass().getCanonicalName();
/* 1315 */     return (str == null) ? paramString : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getShortCanonicalName(Class<?> paramClass) {
/* 1326 */     if (paramClass == null) {
/* 1327 */       return "";
/*      */     }
/* 1329 */     return getShortCanonicalName(paramClass.getName());
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
/*      */   public static String getShortCanonicalName(String paramString) {
/* 1376 */     return getShortClassName(getCanonicalName(paramString));
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
/*      */   public static String getPackageCanonicalName(Object paramObject, String paramString) {
/* 1390 */     if (paramObject == null) {
/* 1391 */       return paramString;
/*      */     }
/* 1393 */     return getPackageCanonicalName(paramObject.getClass().getName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPackageCanonicalName(Class<?> paramClass) {
/* 1404 */     if (paramClass == null) {
/* 1405 */       return "";
/*      */     }
/* 1407 */     return getPackageCanonicalName(paramClass.getName());
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
/*      */   public static String getPackageCanonicalName(String paramString) {
/* 1421 */     return getPackageName(getCanonicalName(paramString));
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
/*      */   private static String getCanonicalName(String paramString) {
/* 1445 */     paramString = StringUtils.deleteWhitespace(paramString);
/* 1446 */     if (paramString == null) {
/* 1447 */       return null;
/*      */     }
/* 1449 */     byte b1 = 0;
/* 1450 */     while (paramString.startsWith("[")) {
/* 1451 */       b1++;
/* 1452 */       paramString = paramString.substring(1);
/*      */     } 
/* 1454 */     if (b1 < 1) {
/* 1455 */       return paramString;
/*      */     }
/* 1457 */     if (paramString.startsWith("L")) {
/* 1458 */       paramString = paramString.substring(1, 
/*      */           
/* 1460 */           paramString.endsWith(";") ? (paramString
/* 1461 */           .length() - 1) : paramString
/* 1462 */           .length());
/*      */     }
/* 1464 */     else if (!paramString.isEmpty()) {
/* 1465 */       paramString = reverseAbbreviationMap.get(paramString.substring(0, 1));
/*      */     } 
/*      */     
/* 1468 */     StringBuilder stringBuilder = new StringBuilder(paramString);
/* 1469 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 1470 */       stringBuilder.append("[]");
/*      */     }
/* 1472 */     return stringBuilder.toString();
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
/*      */   public static Iterable<Class<?>> hierarchy(Class<?> paramClass) {
/* 1484 */     return hierarchy(paramClass, Interfaces.EXCLUDE);
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
/*      */   public static Iterable<Class<?>> hierarchy(Class<?> paramClass, Interfaces paramInterfaces) {
/* 1496 */     Iterable<Class<?>> iterable = () -> {
/*      */         MutableObject mutableObject = new MutableObject(paramClass);
/*      */         return new Iterator<Class<?>>()
/*      */           {
/*      */             public boolean hasNext()
/*      */             {
/* 1502 */               return (next.getValue() != null);
/*      */             }
/*      */ 
/*      */             
/*      */             public Class<?> next() {
/* 1507 */               Class<?> clazz = (Class)next.getValue();
/* 1508 */               next.setValue(clazz.getSuperclass());
/* 1509 */               return clazz;
/*      */             }
/*      */ 
/*      */             
/*      */             public void remove() {
/* 1514 */               throw new UnsupportedOperationException();
/*      */             }
/*      */           };
/*      */       };
/*      */     
/* 1519 */     if (paramInterfaces != Interfaces.INCLUDE) {
/* 1520 */       return iterable;
/*      */     }
/* 1522 */     return () -> {
/*      */         final HashSet seenInterfaces = new HashSet();
/*      */         final Iterator wrapped = paramIterable.iterator();
/*      */         return new Iterator<Class<?>>()
/*      */           {
/* 1527 */             Iterator interfaces = Collections.emptySet().iterator();
/*      */ 
/*      */             
/*      */             public boolean hasNext() {
/* 1531 */               return (this.interfaces.hasNext() || wrapped.hasNext());
/*      */             }
/*      */ 
/*      */             
/*      */             public Class<?> next() {
/* 1536 */               if (this.interfaces.hasNext()) {
/* 1537 */                 Class<?> clazz1 = this.interfaces.next();
/* 1538 */                 seenInterfaces.add(clazz1);
/* 1539 */                 return clazz1;
/*      */               } 
/* 1541 */               Class<?> clazz = wrapped.next();
/* 1542 */               LinkedHashSet<Class<?>> linkedHashSet = new LinkedHashSet();
/* 1543 */               walkInterfaces(linkedHashSet, clazz);
/* 1544 */               this.interfaces = linkedHashSet.iterator();
/* 1545 */               return clazz;
/*      */             }
/*      */             
/*      */             private void walkInterfaces(Set<Class<?>> param1Set, Class<?> param1Class) {
/* 1549 */               for (Class<?> clazz : param1Class.getInterfaces()) {
/* 1550 */                 if (!seenInterfaces.contains(clazz)) {
/* 1551 */                   param1Set.add(clazz);
/*      */                 }
/* 1553 */                 walkInterfaces(param1Set, clazz);
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             public void remove() {
/* 1559 */               throw new UnsupportedOperationException();
/*      */             }
/*      */           };
/*      */       };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\ClassUtils.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */