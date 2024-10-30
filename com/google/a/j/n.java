/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.b.O;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.logging.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @a
/*     */ @c
/*     */ public final class n
/*     */   implements Closeable
/*     */ {
/*  95 */   private static final c a = b.isAvailable() ? 
/*  96 */     b.a : 
/*  97 */     a.a;
/*     */ 
/*     */   
/*     */   public static n a() {
/* 101 */     return new n(a);
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/*     */   final c b;
/* 107 */   private final Deque<Closeable> stack = new ArrayDeque<>(4);
/*     */   private Throwable b;
/*     */   
/*     */   @d
/*     */   n(c paramc) {
/* 112 */     this.b = (Throwable)D.checkNotNull(paramc);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public <C extends Closeable> C a(C paramC) {
/* 124 */     if (paramC != null) {
/* 125 */       this.stack.addFirst((Closeable)paramC);
/*     */     }
/*     */     
/* 128 */     return paramC;
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
/*     */   public RuntimeException rethrow(Throwable paramThrowable) throws IOException {
/* 145 */     D.checkNotNull(paramThrowable);
/* 146 */     this.b = paramThrowable;
/* 147 */     O.c(paramThrowable, IOException.class);
/* 148 */     throw new RuntimeException(paramThrowable);
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
/*     */   public <X extends Exception> RuntimeException a(Throwable paramThrowable, Class<X> paramClass) throws IOException, X {
/* 167 */     D.checkNotNull(paramThrowable);
/* 168 */     this.b = paramThrowable;
/* 169 */     O.c(paramThrowable, IOException.class);
/* 170 */     O.c(paramThrowable, paramClass);
/* 171 */     throw new RuntimeException(paramThrowable);
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
/*     */   public <X1 extends Exception, X2 extends Exception> RuntimeException a(Throwable paramThrowable, Class<X1> paramClass, Class<X2> paramClass1) throws IOException, X1, X2 {
/* 191 */     D.checkNotNull(paramThrowable);
/* 192 */     this.b = paramThrowable;
/* 193 */     O.c(paramThrowable, IOException.class);
/* 194 */     O.a(paramThrowable, paramClass, paramClass1);
/* 195 */     throw new RuntimeException(paramThrowable);
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
/*     */   public void close() throws IOException {
/* 207 */     Throwable throwable = this.b;
/*     */ 
/*     */     
/* 210 */     while (!this.stack.isEmpty()) {
/* 211 */       Closeable closeable = this.stack.removeFirst();
/*     */       try {
/* 213 */         closeable.close();
/* 214 */       } catch (Throwable throwable1) {
/* 215 */         if (throwable == null) {
/* 216 */           throwable = throwable1; continue;
/*     */         } 
/* 218 */         this.b.a(closeable, throwable, throwable1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 223 */     if (this.b == null && throwable != null) {
/* 224 */       O.c(throwable, IOException.class);
/* 225 */       throw new AssertionError(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static interface c
/*     */   {
/*     */     void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static final class a
/*     */     implements c
/*     */   {
/* 244 */     static final a a = new a();
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
/* 249 */       String str = String.valueOf(param1Closeable); m.logger.log(Level.WARNING, (new StringBuilder(42 + String.valueOf(str).length())).append("Suppressing exception thrown when closing ").append(str).toString(), param1Throwable2);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @d
/*     */   static final class b
/*     */     implements c
/*     */   {
/* 261 */     static final b a = new b();
/*     */     
/*     */     static boolean isAvailable() {
/* 264 */       return (e != null);
/*     */     }
/*     */     
/* 267 */     static final Method e = g();
/*     */     
/*     */     private static Method g() {
/*     */       try {
/* 271 */         return Throwable.class.getMethod("addSuppressed", new Class[] { Throwable.class });
/* 272 */       } catch (Throwable throwable) {
/* 273 */         return null;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void a(Closeable param1Closeable, Throwable param1Throwable1, Throwable param1Throwable2) {
/* 280 */       if (param1Throwable1 == param1Throwable2) {
/*     */         return;
/*     */       }
/*     */       try {
/* 284 */         e.invoke(param1Throwable1, new Object[] { param1Throwable2 });
/* 285 */       } catch (Throwable throwable) {
/*     */         
/* 287 */         n.a.a.a(param1Closeable, param1Throwable1, param1Throwable2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\n.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */