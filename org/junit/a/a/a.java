/*     */ package org.junit.a.a;
/*     */ 
/*     */ import java.lang.annotation.Retention;
/*     */ import java.lang.annotation.RetentionPolicy;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.LinkedHashSet;
/*     */ import java.util.Set;
/*     */ import org.junit.f.a.e;
/*     */ import org.junit.f.a.j;
/*     */ import org.junit.f.h;
/*     */ import org.junit.runner.a.e;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends h
/*     */ {
/*     */   public static class a
/*     */     extends org.junit.runner.a.b
/*     */   {
/*     */     private final Set<Class<?>> I;
/*     */     private final Set<Class<?>> J;
/*     */     private final boolean dh;
/*     */     private final boolean di;
/*     */     
/*     */     public static a a(boolean param1Boolean, Class<?>... param1VarArgs) {
/* 122 */       return new a(param1Boolean, param1VarArgs, true, null);
/*     */     }
/*     */     
/*     */     public static a a(Class<?> param1Class) {
/* 126 */       return a(true, new Class[] { param1Class });
/*     */     }
/*     */     
/*     */     public static a a(Class<?>... param1VarArgs) {
/* 130 */       return a(true, param1VarArgs);
/*     */     }
/*     */     
/*     */     public static a b(boolean param1Boolean, Class<?>... param1VarArgs) {
/* 134 */       return new a(true, null, param1Boolean, param1VarArgs);
/*     */     }
/*     */     
/*     */     public static a b(Class<?> param1Class) {
/* 138 */       return b(true, new Class[] { param1Class });
/*     */     }
/*     */     
/*     */     public static a b(Class<?>... param1VarArgs) {
/* 142 */       return b(true, param1VarArgs);
/*     */     }
/*     */ 
/*     */     
/*     */     public static a a(boolean param1Boolean1, Set<Class<?>> param1Set1, boolean param1Boolean2, Set<Class<?>> param1Set2) {
/* 147 */       return new a(param1Boolean1, param1Set1, param1Boolean2, param1Set2);
/*     */     }
/*     */     
/*     */     @Deprecated
/*     */     public a(Class<?> param1Class1, Class<?> param1Class2) {
/* 152 */       this.dh = true;
/* 153 */       this.di = true;
/* 154 */       this.I = a.f(param1Class1);
/* 155 */       this.J = a.f(param1Class2);
/*     */     }
/*     */ 
/*     */     
/*     */     protected a(boolean param1Boolean1, Set<Class<?>> param1Set1, boolean param1Boolean2, Set<Class<?>> param1Set2) {
/* 160 */       this.dh = param1Boolean1;
/* 161 */       this.di = param1Boolean2;
/* 162 */       this.I = g(param1Set1);
/* 163 */       this.J = g(param1Set2);
/*     */     }
/*     */ 
/*     */     
/*     */     private a(boolean param1Boolean1, Class<?>[] param1ArrayOfClass1, boolean param1Boolean2, Class<?>[] param1ArrayOfClass2) {
/* 168 */       this.dh = param1Boolean1;
/* 169 */       this.di = param1Boolean2;
/* 170 */       this.I = a.b(param1ArrayOfClass1);
/* 171 */       this.J = a.b(param1ArrayOfClass2);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String eY() {
/* 179 */       return toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 196 */       StringBuilder stringBuilder = (new StringBuilder("categories ")).append(this.I.isEmpty() ? "[all]" : this.I);
/*     */       
/* 198 */       if (!this.J.isEmpty()) {
/* 199 */         stringBuilder.append(" - ").append(this.J);
/*     */       }
/* 201 */       return stringBuilder.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean b(org.junit.runner.c param1c) {
/* 206 */       if (c(param1c)) {
/* 207 */         return true;
/*     */       }
/*     */       
/* 210 */       for (org.junit.runner.c c1 : param1c.getChildren()) {
/* 211 */         if (b(c1)) {
/* 212 */           return true;
/*     */         }
/*     */       } 
/*     */       
/* 216 */       return false;
/*     */     }
/*     */     
/*     */     private boolean c(org.junit.runner.c param1c) {
/* 220 */       Set<Class<?>> set = a(param1c);
/*     */ 
/*     */       
/* 223 */       if (set.isEmpty()) {
/* 224 */         return this.I.isEmpty();
/*     */       }
/*     */       
/* 227 */       if (!this.J.isEmpty()) {
/* 228 */         if (this.di) {
/* 229 */           if (a(set, this.J)) {
/* 230 */             return false;
/*     */           }
/*     */         }
/* 233 */         else if (b(set, this.J)) {
/* 234 */           return false;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 239 */       if (this.I.isEmpty())
/*     */       {
/* 241 */         return true;
/*     */       }
/* 243 */       if (this.dh) {
/* 244 */         return a(set, this.I);
/*     */       }
/* 246 */       return b(set, this.I);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean a(Set<Class<?>> param1Set1, Set<Class<?>> param1Set2) {
/* 256 */       for (Class<?> clazz : param1Set2) {
/* 257 */         if (a.b(param1Set1, clazz)) {
/* 258 */           return true;
/*     */         }
/*     */       } 
/* 261 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private boolean b(Set<Class<?>> param1Set1, Set<Class<?>> param1Set2) {
/* 269 */       for (Class<?> clazz : param1Set2) {
/* 270 */         if (!a.b(param1Set1, clazz)) {
/* 271 */           return false;
/*     */         }
/*     */       } 
/* 274 */       return true;
/*     */     }
/*     */     
/*     */     private static Set<Class<?>> a(org.junit.runner.c param1c) {
/* 278 */       HashSet<? super Class<?>> hashSet = new HashSet();
/* 279 */       Collections.addAll(hashSet, a(param1c));
/* 280 */       Collections.addAll(hashSet, a(b(param1c)));
/* 281 */       return (Set)hashSet;
/*     */     }
/*     */     
/*     */     private static org.junit.runner.c b(org.junit.runner.c param1c) {
/* 285 */       Class clazz = param1c.f();
/* 286 */       return (clazz == null) ? null : org.junit.runner.c.a(clazz);
/*     */     }
/*     */     
/*     */     private static Class<?>[] a(org.junit.runner.c param1c) {
/* 290 */       if (param1c == null) {
/* 291 */         return new Class[0];
/*     */       }
/*     */       
/* 294 */       b b1 = (b)param1c.getAnnotation(b.class);
/* 295 */       return (b1 == null) ? new Class[0] : b1.d();
/*     */     }
/*     */     
/*     */     private static Set<Class<?>> g(Set<Class<?>> param1Set) {
/* 299 */       LinkedHashSet<Class<?>> linkedHashSet = new LinkedHashSet();
/* 300 */       if (param1Set != null) {
/* 301 */         linkedHashSet.addAll(param1Set);
/*     */       }
/* 303 */       linkedHashSet.remove(null);
/* 304 */       return linkedHashSet;
/*     */     }
/*     */   }
/*     */   
/*     */   public a(Class<?> paramClass, j paramj) throws e {
/* 309 */     super(paramClass, paramj);
/*     */     try {
/* 311 */       Set<Class<?>> set1 = c(paramClass);
/* 312 */       Set<Class<?>> set2 = d(paramClass);
/* 313 */       boolean bool1 = f(paramClass);
/* 314 */       boolean bool2 = g(paramClass);
/*     */       
/* 316 */       a(a.a(bool1, set1, bool2, set2));
/* 317 */     } catch (e e) {
/* 318 */       throw new e(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Set<Class<?>> c(Class<?> paramClass) {
/* 323 */     c c = paramClass.<c>getAnnotation(c.class);
/* 324 */     return a((c == null) ? null : c.d());
/*     */   }
/*     */   
/*     */   private static boolean f(Class<?> paramClass) {
/* 328 */     c c = paramClass.<c>getAnnotation(c.class);
/* 329 */     return (c == null || c.gh());
/*     */   }
/*     */   
/*     */   private static Set<Class<?>> d(Class<?> paramClass) {
/* 333 */     b b = paramClass.<b>getAnnotation(b.class);
/* 334 */     return a((b == null) ? null : b.d());
/*     */   }
/*     */   
/*     */   private static boolean g(Class<?> paramClass) {
/* 338 */     b b = paramClass.<b>getAnnotation(b.class);
/* 339 */     return (b == null || b.gh());
/*     */   }
/*     */   
/*     */   private static boolean a(Set<Class<?>> paramSet, Class<?> paramClass) {
/* 343 */     for (Class<?> clazz : paramSet) {
/* 344 */       if (paramClass.isAssignableFrom(clazz)) {
/* 345 */         return true;
/*     */       }
/*     */     } 
/* 348 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set<Class<?>> a(Class<?>[] paramArrayOfClass) {
/* 354 */     if (paramArrayOfClass == null || paramArrayOfClass.length == 0) {
/* 355 */       return Collections.emptySet();
/*     */     }
/* 357 */     for (Class<?> clazz : paramArrayOfClass) {
/* 358 */       if (clazz == null) {
/* 359 */         throw new NullPointerException("has null category");
/*     */       }
/*     */     } 
/*     */     
/* 363 */     return (paramArrayOfClass.length == 1) ? Collections.<Class<?>>singleton(paramArrayOfClass[0]) : new LinkedHashSet<Class<?>>(Arrays.asList(paramArrayOfClass));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Set<Class<?>> e(Class<?> paramClass) {
/* 371 */     return (paramClass == null) ? Collections.<Class<?>>emptySet() : Collections.<Class<?>>singleton(paramClass);
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface b {
/*     */     Class<?>[] d() default {};
/*     */     
/*     */     boolean gh() default true;
/*     */   }
/*     */   
/*     */   @Retention(RetentionPolicy.RUNTIME)
/*     */   public static @interface c {
/*     */     Class<?>[] d() default {};
/*     */     
/*     */     boolean gh() default true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\junit\a\a\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */