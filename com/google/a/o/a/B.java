/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.M;
/*     */ import com.google.b.a.a;
/*     */ import java.time.Duration;
/*     */ import java.util.concurrent.Executor;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.TimeoutException;
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
/*     */ @c
/*     */ public abstract class b
/*     */   implements ai
/*     */ {
/*  39 */   private static final Logger logger = Logger.getLogger(b.class.getName());
/*     */ 
/*     */   
/*  42 */   private final ai a = new g(this)
/*     */     {
/*     */       
/*     */       protected final void fD()
/*     */       {
/*  47 */         Executor executor = ab.a(this.a
/*  48 */             .a(), new M<String>(this)
/*     */             {
/*     */               public String du()
/*     */               {
/*  52 */                 return this.a.a.dt();
/*     */               }
/*     */             });
/*  55 */         executor.execute(new Runnable(this)
/*     */             {
/*     */               public void run()
/*     */               {
/*     */                 try {
/*  60 */                   this.a.a.fy();
/*  61 */                   this.a.fL();
/*     */ 
/*     */                   
/*  64 */                   if (this.a.isRunning()) {
/*     */                     try {
/*  66 */                       this.a.a.run();
/*  67 */                     } catch (Throwable throwable) {
/*     */                       try {
/*  69 */                         this.a.a.fz();
/*  70 */                       } catch (Exception exception) {
/*     */ 
/*     */ 
/*     */                         
/*  74 */                         b.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", exception);
/*     */                       } 
/*     */ 
/*     */ 
/*     */                       
/*  79 */                       this.a.c(throwable);
/*     */                       
/*     */                       return;
/*     */                     } 
/*     */                   }
/*  84 */                   this.a.a.fz();
/*  85 */                   this.a.fM();
/*  86 */                 } catch (Throwable throwable) {
/*  87 */                   this.a.c(throwable);
/*     */                 } 
/*     */               }
/*     */             });
/*     */       }
/*     */ 
/*     */       
/*     */       protected void fE() {
/*  95 */         this.a.fA();
/*     */       }
/*     */ 
/*     */       
/*     */       public String toString() {
/* 100 */         return this.a.toString();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fy() throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void fz() throws Exception {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   protected void fA() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 164 */     return new Executor(this)
/*     */       {
/*     */         public void execute(Runnable param1Runnable) {
/* 167 */           ab.a(this.a.dt(), param1Runnable).start();
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 174 */     String str1 = dt(), str2 = String.valueOf(a()); return (new StringBuilder(3 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(" [").append(str2).append("]").toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public final boolean isRunning() {
/* 179 */     return this.a.isRunning();
/*     */   }
/*     */ 
/*     */   
/*     */   public final ai.b a() {
/* 184 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(ai.a parama, Executor paramExecutor) {
/* 190 */     this.a.a(parama, paramExecutor);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final Throwable a() {
/* 196 */     return this.a.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public final ai a() {
/* 203 */     this.a.a();
/* 204 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @a
/*     */   public final ai b() {
/* 211 */     this.a.b();
/* 212 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fB() {
/* 218 */     this.a.fB();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(Duration paramDuration) throws TimeoutException {
/* 224 */     super.a(paramDuration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void a(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 230 */     this.a.a(paramLong, paramTimeUnit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void fC() {
/* 236 */     this.a.fC();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(Duration paramDuration) throws TimeoutException {
/* 242 */     super.b(paramDuration);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public final void b(long paramLong, TimeUnit paramTimeUnit) throws TimeoutException {
/* 248 */     this.a.b(paramLong, paramTimeUnit);
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
/*     */   protected String dt() {
/* 260 */     return getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   protected abstract void run() throws Exception;
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */