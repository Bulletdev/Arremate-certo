/*     */ package org.a.a.c.a;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import org.a.c.a.b;
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
/*     */ public enum a
/*     */ {
/*  33 */   d(null, "bBhHsS"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  40 */   e(new Class[] { Character.class, Byte.class, Short.class, Integer.class }, "cC"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   f(new Class[] { Byte.class, Short.class, Integer.class, Long.class, BigInteger.class }, "doxX"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  54 */   g(new Class[] { Float.class, Double.class, BigDecimal.class }, "eEfgGaA"),
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   h(new Class[] { Long.class, Calendar.class, Date.class }, "tT"),
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
/*  81 */   i(new Class[] { Byte.class, Short.class, Integer.class }, null),
/*     */   
/*  83 */   j(new Class[] { Long.class }, null),
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
/*  95 */   k(new Class[0], null),
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
/* 108 */   l(null, null);
/*     */   public final Class<?>[] c;
/*     */   
/*     */   a(Class<?>[] paramArrayOfClass, String paramString1) {
/* 112 */     this.c = paramArrayOfClass;
/* 113 */     this.jJ = paramString1;
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
/*     */   public final String jJ;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(char paramChar) {
/* 135 */     for (a a1 : new a[] { d, e, f, g, h }) {
/* 136 */       if (a1.jJ.contains(String.valueOf(paramChar))) {
/* 137 */         return a1;
/*     */       }
/*     */     } 
/* 140 */     throw new IllegalArgumentException("Bad conversion character " + paramChar);
/*     */   }
/*     */   
/*     */   private static <E> Set<E> a(E[] paramArrayOfE) {
/* 144 */     return new HashSet<>(Arrays.asList(paramArrayOfE));
/*     */   }
/*     */   
/*     */   public static boolean a(a parama1, a parama2) {
/* 148 */     return (a(parama1, parama2) == parama1);
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
/*     */ 
/*     */   
/*     */   public static a a(a parama1, a parama2) {
/* 167 */     if (parama1 == l) {
/* 168 */       return parama2;
/*     */     }
/* 170 */     if (parama2 == l) {
/* 171 */       return parama1;
/*     */     }
/* 173 */     if (parama1 == d) {
/* 174 */       return parama2;
/*     */     }
/* 176 */     if (parama2 == d) {
/* 177 */       return parama1;
/*     */     }
/*     */     
/* 180 */     Set<Class<?>> set1 = a(parama1.c);
/* 181 */     Set<Class<?>> set2 = a(parama2.c);
/* 182 */     set1.retainAll(set2);
/*     */     
/* 184 */     for (a a1 : new a[] { e, f, g, h, i, j, k }) {
/*     */ 
/*     */       
/* 187 */       Set<Class<?>> set = a(a1.c);
/* 188 */       if (set.equals(set1)) {
/* 189 */         return a1;
/*     */       }
/*     */     } 
/* 192 */     throw new RuntimeException();
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
/*     */ 
/*     */   
/*     */   public static a b(a parama1, a parama2) {
/* 211 */     if (parama1 == l || parama2 == l) {
/* 212 */       return l;
/*     */     }
/* 214 */     if (parama1 == d || parama2 == d) {
/* 215 */       return d;
/*     */     }
/* 217 */     if ((parama1 == i && parama2 == j) || (parama1 == j && parama2 == i))
/*     */     {
/*     */ 
/*     */       
/* 221 */       return f;
/*     */     }
/*     */     
/* 224 */     Set<Class<?>> set1 = a(parama1.c);
/* 225 */     Set<Class<?>> set2 = a(parama2.c);
/* 226 */     set1.addAll(set2);
/*     */     
/* 228 */     for (a a1 : new a[] { k, i, j, e, f, g, h }) {
/*     */ 
/*     */       
/* 231 */       Set<Class<?>> set = a(a1.c);
/* 232 */       if (set.equals(set1)) {
/* 233 */         return a1;
/*     */       }
/*     */     } 
/*     */     
/* 237 */     return d;
/*     */   }
/*     */   
/*     */   private String a(Class<?> paramClass) {
/* 241 */     if (paramClass == Boolean.class) {
/* 242 */       return "boolean";
/*     */     }
/* 244 */     if (paramClass == Character.class) {
/* 245 */       return "char";
/*     */     }
/* 247 */     if (paramClass == Byte.class) {
/* 248 */       return "byte";
/*     */     }
/* 250 */     if (paramClass == Short.class) {
/* 251 */       return "short";
/*     */     }
/* 253 */     if (paramClass == Integer.class) {
/* 254 */       return "int";
/*     */     }
/* 256 */     if (paramClass == Long.class) {
/* 257 */       return "long";
/*     */     }
/* 259 */     if (paramClass == Float.class) {
/* 260 */       return "float";
/*     */     }
/* 262 */     if (paramClass == Double.class) {
/* 263 */       return "double";
/*     */     }
/* 265 */     return paramClass.getSimpleName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @b
/*     */   public String toString() {
/* 272 */     StringBuilder stringBuilder = new StringBuilder(name());
/* 273 */     stringBuilder.append(" conversion category (one of: ");
/* 274 */     boolean bool = true;
/* 275 */     for (Class<?> clazz : this.c) {
/* 276 */       if (!bool) {
/* 277 */         stringBuilder.append(", ");
/*     */       }
/* 279 */       stringBuilder.append(a(clazz));
/* 280 */       bool = false;
/*     */     } 
/* 282 */     stringBuilder.append(")");
/* 283 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\c\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */