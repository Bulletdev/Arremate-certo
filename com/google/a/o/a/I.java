/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.b;
/*     */ import com.google.a.b.D;
/*     */ import com.google.a.d.bd;
/*     */ import com.google.a.d.dj;
/*     */ import com.google.b.a.g;
/*     */ import com.google.b.a.n;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ abstract class i<InputT, OutputT>
/*     */   extends j<OutputT>
/*     */ {
/*  43 */   private static final Logger logger = Logger.getLogger(i.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private bd<? extends U<? extends InputT>> d;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean bm;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean bn;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i(bd<? extends U<? extends InputT>> parambd, boolean paramBoolean1, boolean paramBoolean2) {
/*  64 */     super(parambd.size());
/*  65 */     this.d = (bd<? extends U<? extends InputT>>)D.checkNotNull(parambd);
/*  66 */     this.bm = paramBoolean1;
/*  67 */     this.bn = paramBoolean2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected final void fx() {
/*  72 */     super.fx();
/*     */     
/*  74 */     bd<? extends U<? extends InputT>> bd1 = this.d;
/*  75 */     a((a)a.a);
/*     */     
/*  77 */     if ((isCancelled() & ((bd1 != null) ? 1 : 0)) != 0) {
/*  78 */       boolean bool = dw();
/*  79 */       for (dj<Future> dj = bd1.b(); dj.hasNext(); ) { Future future = dj.next();
/*  80 */         future.cancel(bool); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final String ds() {
/*  91 */     bd<? extends U<? extends InputT>> bd1 = this.d;
/*  92 */     if (bd1 != null) {
/*  93 */       String str = String.valueOf(bd1); return (new StringBuilder(8 + String.valueOf(str).length())).append("futures=").append(str).toString();
/*     */     } 
/*  95 */     return super.ds();
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
/*     */   final void init() {
/* 107 */     if (this.d.isEmpty()) {
/* 108 */       fQ();
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 115 */     if (this.bm) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 125 */       byte b = 0;
/* 126 */       for (dj<U> dj = this.d.b(); dj.hasNext(); ) { U u = dj.next();
/* 127 */         final byte index = b++;
/* 128 */         u.a(new Runnable(this, u)
/*     */             {
/*     */               public void run()
/*     */               {
/*     */                 try {
/* 133 */                   if (this.d.isCancelled()) {
/*     */ 
/*     */                     
/* 136 */                     i.a(this.a, (bd)null);
/* 137 */                     this.a.cancel(false);
/*     */                   } else {
/* 139 */                     i.a(this.a, index, this.d);
/*     */                   
/*     */                   }
/*     */ 
/*     */                 
/*     */                 }
/*     */                 finally {
/*     */                   
/* 147 */                   i.a(this.a, (bd)null);
/*     */                 }
/*     */               
/*     */               }
/* 151 */             }ab.b());
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */          }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 171 */       bd<? extends U<? extends InputT>> bd1 = this.bn ? this.d : null;
/* 172 */       Runnable runnable = new Runnable(this, bd1)
/*     */         {
/*     */           public void run()
/*     */           {
/* 176 */             i.a(this.a, this.e);
/*     */           }
/*     */         };
/* 179 */       for (dj<U> dj = this.d.b(); dj.hasNext(); ) { U u = dj.next();
/* 180 */         u.a(runnable, ab.b()); }
/*     */     
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void d(Throwable paramThrowable) {
/* 192 */     D.checkNotNull(paramThrowable);
/*     */     
/* 194 */     if (this.bm) {
/*     */ 
/*     */       
/* 197 */       boolean bool = a(paramThrowable);
/* 198 */       if (!bool) {
/*     */ 
/*     */         
/* 201 */         boolean bool1 = a(H(), paramThrowable);
/* 202 */         if (bool1) {
/* 203 */           e(paramThrowable);
/*     */ 
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 213 */     if (paramThrowable instanceof Error)
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 221 */       e(paramThrowable);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void e(Throwable paramThrowable) {
/* 229 */     String str = (paramThrowable instanceof Error) ? "Input Future failed with Error" : "Got more than one input Future failure. Logging failures after the first";
/* 230 */     logger.log(Level.SEVERE, str, paramThrowable);
/*     */   }
/*     */ 
/*     */   
/*     */   final void b(Set<Throwable> paramSet) {
/* 235 */     D.checkNotNull(paramSet);
/* 236 */     if (!isCancelled())
/*     */     {
/* 238 */       boolean bool = a(paramSet, b());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(int paramInt, Future<? extends InputT> paramFuture) {
/*     */     try {
/* 249 */       c(paramInt, L.b((Future)paramFuture));
/* 250 */     } catch (ExecutionException executionException) {
/* 251 */       d(executionException.getCause());
/* 252 */     } catch (Throwable throwable) {
/* 253 */       d(throwable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(bd<? extends Future<? extends InputT>> parambd) {
/* 261 */     int k = ax();
/* 262 */     D.b((k >= 0), "Less than 0 remaining futures");
/* 263 */     if (k == 0) {
/* 264 */       b(parambd);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void b(bd<? extends Future<? extends InputT>> parambd) {
/* 272 */     if (parambd != null) {
/* 273 */       byte b = 0;
/* 274 */       for (dj<Future> dj = parambd.b(); dj.hasNext(); ) { Future<? extends InputT> future = dj.next();
/* 275 */         if (!future.isCancelled()) {
/* 276 */           a(b, future);
/*     */         }
/* 278 */         b++; }
/*     */     
/*     */     } 
/* 281 */     fR();
/* 282 */     fQ();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 290 */     a(a.b);
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
/*     */   @g
/*     */   @n
/*     */   void a(a parama) {
/* 306 */     D.checkNotNull(parama);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     this.d = null;
/*     */   }
/*     */   
/*     */   enum a {
/* 317 */     a,
/* 318 */     b;
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
/*     */   private static boolean a(Set<Throwable> paramSet, Throwable paramThrowable) {
/* 331 */     for (; paramThrowable != null; paramThrowable = paramThrowable.getCause()) {
/* 332 */       boolean bool = paramSet.add(paramThrowable);
/* 333 */       if (!bool)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 340 */         return false;
/*     */       }
/*     */     } 
/* 343 */     return true;
/*     */   }
/*     */   
/*     */   abstract void c(int paramInt, InputT paramInputT);
/*     */   
/*     */   abstract void fQ();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */