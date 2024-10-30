/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.M;
/*     */ import java.time.Duration;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public abstract class d
/*     */   implements ai
/*     */ {
/*  38 */   private final M<String> i = new b();
/*     */   
/*     */   private final class b implements M<String> {
/*     */     private b(d this$0) {}
/*     */     
/*     */     public String du() {
/*  44 */       String str1 = this.a.dt(), str2 = String.valueOf(this.a.a()); return (new StringBuilder(1 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" ").append(str2).toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*  49 */   private final ai a = new a();
/*     */   
/*     */   private final class a extends g {
/*     */     private a(d this$0) {}
/*     */     
/*     */     protected final void fD() {
/*  55 */       ab.a(this.a.a(), d.a(this.a))
/*  56 */         .execute(new Runnable(this)
/*     */           {
/*     */             public void run()
/*     */             {
/*     */               try {
/*  61 */                 this.a.a.fy();
/*  62 */                 this.a.fL();
/*  63 */               } catch (Throwable throwable) {
/*  64 */                 this.a.c(throwable);
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     protected final void fE() {
/*  72 */       ab.a(this.a.a(), d.a(this.a))
/*  73 */         .execute(new Runnable(this)
/*     */           {
/*     */             public void run()
/*     */             {
/*     */               try {
/*  78 */                 this.a.a.fz();
/*  79 */                 this.a.fM();
/*  80 */               } catch (Throwable throwable) {
/*  81 */                 this.a.c(throwable);
/*     */               } 
/*     */             }
/*     */           });
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  89 */       return this.a.toString();
/*     */     }
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
/*     */   protected Executor a() {
/* 110 */     return new Executor(this)
/*     */       {
/*     */         public void execute(Runnable param1Runnable) {
/* 113 */           ab.a((String)d.a(this.a).get(), param1Runnable).start();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 120 */     String str1 = dt(), str2 = String.valueOf(a()); return (new StringBuilder(3 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" [").append(str2).append("]").toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 125 */     return this.a.isRunning();
/*     */   }
/*     */ 
/*     */   
/*     */   public final ai.b a() {
/* 130 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ai.a parama, Executor paramExecutor) {
/* 136 */     this.a.a(parama, paramExecutor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Throwable a() {
/* 142 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final ai a() {
/* 149 */     this.a.a();
/* 150 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a
/*     */   public final ai b() {
/* 157 */     this.a.b();
/* 158 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fB() {
/* 164 */     this.a.fB();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Duration paramDuration) throws TimeoutException {
/* 170 */     super.a(paramDuration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 176 */     this.a.a(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fC() {
/* 182 */     this.a.fC();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(Duration paramDuration) throws TimeoutException {
/* 188 */     super.b(paramDuration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 194 */     this.a.b(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String dt() {
/* 204 */     return getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   protected abstract void fy() throws Exception;
/*     */   
/*     */   protected abstract void fz() throws Exception;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */