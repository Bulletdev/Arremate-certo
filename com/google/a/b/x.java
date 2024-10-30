/*     */ package com.google.a.b;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import java.util.Arrays;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @b
/*     */ public final class x
/*     */ {
/*     */   public static <T> T a(T paramT1, T paramT2) {
/*  58 */     if (paramT1 != null) {
/*  59 */       return paramT1;
/*     */     }
/*  61 */     if (paramT2 != null) {
/*  62 */       return paramT2;
/*     */     }
/*  64 */     throw new NullPointerException("Both parameters are null");
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static a a(Object paramObject) {
/* 108 */     return new a(paramObject.getClass().getSimpleName());
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
/*     */   public static a a(Class<?> paramClass) {
/* 122 */     return new a(paramClass.getSimpleName());
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
/*     */   public static a a(String paramString) {
/* 134 */     return new a(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class a
/*     */   {
/*     */     private final String className;
/*     */ 
/*     */     
/* 145 */     private final a a = new a();
/* 146 */     private a b = this.a;
/*     */     
/*     */     private boolean aw = false;
/*     */     
/*     */     private a(String param1String) {
/* 151 */       this.className = D.<String>checkNotNull(param1String);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a() {
/* 163 */       this.aw = true;
/* 164 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, Object param1Object) {
/* 174 */       return b(param1String, param1Object);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, boolean param1Boolean) {
/* 184 */       return b(param1String, String.valueOf(param1Boolean));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, char param1Char) {
/* 194 */       return b(param1String, String.valueOf(param1Char));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, double param1Double) {
/* 204 */       return b(param1String, String.valueOf(param1Double));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, float param1Float) {
/* 214 */       return b(param1String, String.valueOf(param1Float));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, int param1Int) {
/* 224 */       return b(param1String, String.valueOf(param1Int));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a a(String param1String, long param1Long) {
/* 234 */       return b(param1String, String.valueOf(param1Long));
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     @com.google.b.a.a
/*     */     public a b(Object param1Object) {
/* 245 */       return c(param1Object);
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
/*     */     @com.google.b.a.a
/*     */     public a a(boolean param1Boolean) {
/* 258 */       return c(String.valueOf(param1Boolean));
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
/*     */     @com.google.b.a.a
/*     */     public a a(char param1Char) {
/* 271 */       return c(String.valueOf(param1Char));
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
/*     */     @com.google.b.a.a
/*     */     public a a(double param1Double) {
/* 284 */       return c(String.valueOf(param1Double));
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
/*     */     @com.google.b.a.a
/*     */     public a a(float param1Float) {
/* 297 */       return c(String.valueOf(param1Float));
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
/*     */     @com.google.b.a.a
/*     */     public a a(int param1Int) {
/* 310 */       return c(String.valueOf(param1Int));
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
/*     */     @com.google.b.a.a
/*     */     public a a(long param1Long) {
/* 323 */       return c(String.valueOf(param1Long));
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
/*     */     public String toString() {
/* 337 */       boolean bool = this.aw;
/* 338 */       String str = "";
/* 339 */       StringBuilder stringBuilder = (new StringBuilder(32)).append(this.className).append('{');
/* 340 */       a a1 = this.a.c;
/* 341 */       for (; a1 != null; 
/* 342 */         a1 = a1.c) {
/* 343 */         Object object = a1.value;
/* 344 */         if (!bool || object != null) {
/* 345 */           stringBuilder.append(str);
/* 346 */           str = ", ";
/*     */           
/* 348 */           if (a1.name != null) {
/* 349 */             stringBuilder.append(a1.name).append('=');
/*     */           }
/* 351 */           if (object != null && object.getClass().isArray()) {
/* 352 */             Object[] arrayOfObject = { object };
/* 353 */             String str1 = Arrays.deepToString(arrayOfObject);
/* 354 */             stringBuilder.append(str1, 1, str1.length() - 1);
/*     */           } else {
/* 356 */             stringBuilder.append(object);
/*     */           } 
/*     */         } 
/*     */       } 
/* 360 */       return stringBuilder.append('}').toString();
/*     */     }
/*     */     
/*     */     private a a() {
/* 364 */       a a1 = new a();
/* 365 */       this.b = this.b.c = a1;
/* 366 */       return a1;
/*     */     }
/*     */     
/*     */     private a c(Object param1Object) {
/* 370 */       a a1 = a();
/* 371 */       a1.value = param1Object;
/* 372 */       return this;
/*     */     }
/*     */     
/*     */     private a b(String param1String, Object param1Object) {
/* 376 */       a a1 = a();
/* 377 */       a1.value = param1Object;
/* 378 */       a1.name = D.<String>checkNotNull(param1String);
/* 379 */       return this;
/*     */     }
/*     */     
/*     */     private static final class a {
/*     */       String name;
/*     */       Object value;
/*     */       a c;
/*     */       
/*     */       private a() {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\b\x.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */