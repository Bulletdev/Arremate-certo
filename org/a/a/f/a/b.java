/*     */ package org.a.a.f.a;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public enum b
/*     */ {
/*  37 */   b(null, null),
/*     */ 
/*     */   
/*  40 */   c(null, null),
/*     */ 
/*     */   
/*  43 */   d((Class<? extends Object>[])new Class[] { Date.class, Number.class }, new String[] { "date", "time"
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }),
/*  54 */   e((Class<? extends Object>[])new Class[] { Number.class }, new String[] { "number", "choice" });
/*     */   
/*     */   public final Class<? extends Object>[] c;
/*     */   
/*     */   public final String[] strings;
/*     */   
/*     */   static b[] a;
/*     */   
/*     */   b(Class<? extends Object>[] paramArrayOfClass, String[] paramArrayOfString) {
/*  63 */     this.c = paramArrayOfClass;
/*  64 */     this.strings = paramArrayOfString;
/*     */   }
/*     */   
/*     */   static {
/*  68 */     a = new b[] { d, e };
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
/*     */   public static b a(String paramString) {
/*  80 */     paramString = paramString.toLowerCase();
/*  81 */     for (b b1 : a) {
/*  82 */       for (String str : b1.strings) {
/*  83 */         if (str.equals(paramString)) {
/*  84 */           return b1;
/*     */         }
/*     */       } 
/*     */     } 
/*  88 */     throw new IllegalArgumentException("Invalid format type " + paramString);
/*     */   }
/*     */   
/*     */   private static <E> Set<E> a(E[] paramArrayOfE) {
/*  92 */     return new HashSet<>(Arrays.asList(paramArrayOfE));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean a(b paramb1, b paramb2) {
/* 101 */     return (a(paramb1, paramb2) == paramb1);
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
/*     */   public static b a(b paramb1, b paramb2) {
/* 117 */     if (paramb1 == b) {
/* 118 */       return paramb2;
/*     */     }
/* 120 */     if (paramb2 == b) {
/* 121 */       return paramb1;
/*     */     }
/* 123 */     if (paramb1 == c) {
/* 124 */       return paramb2;
/*     */     }
/* 126 */     if (paramb2 == c) {
/* 127 */       return paramb1;
/*     */     }
/*     */     
/* 130 */     Set<Class<? extends Object>> set1 = a(paramb1.c);
/* 131 */     Set<Class<? extends Object>> set2 = a(paramb2.c);
/* 132 */     set1.retainAll(set2);
/* 133 */     for (b b1 : new b[] { d, e }) {
/* 134 */       Set<Class<? extends Object>> set = a(b1.c);
/* 135 */       if (set.equals(set1)) {
/* 136 */         return b1;
/*     */       }
/*     */     } 
/* 139 */     throw new RuntimeException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static b b(b paramb1, b paramb2) {
/* 150 */     if (paramb1 == b || paramb2 == b) {
/* 151 */       return (b)b;
/*     */     }
/* 153 */     if (paramb1 == c || paramb2 == c) {
/* 154 */       return (b)c;
/*     */     }
/* 156 */     if (paramb1 == d || paramb2 == d) {
/* 157 */       return d;
/*     */     }
/* 159 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 165 */     StringBuilder stringBuilder = new StringBuilder(name());
/* 166 */     if (this.c == null) {
/* 167 */       stringBuilder.append(" conversion category (all types)");
/*     */     } else {
/* 169 */       stringBuilder.append(" conversion category (one of: ");
/* 170 */       boolean bool = true;
/* 171 */       for (Class<? extends Object> clazz : this.c) {
/* 172 */         if (!bool) {
/* 173 */           stringBuilder.append(", ");
/*     */         }
/* 175 */         stringBuilder.append(clazz.getCanonicalName());
/* 176 */         bool = false;
/*     */       } 
/* 178 */       stringBuilder.append(")");
/*     */     } 
/* 180 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\a\a\f\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */