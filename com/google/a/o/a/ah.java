/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.c.a.h;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Deque;
/*     */ import java.util.concurrent.Executor;
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
/*     */ 
/*     */ 
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
/*     */ final class ah
/*     */   implements Executor
/*     */ {
/*  51 */   private static final Logger a = Logger.getLogger(ah.class.getName());
/*     */   
/*     */   enum b
/*     */   {
/*  55 */     b,
/*     */     
/*  57 */     c,
/*     */     
/*  59 */     d,
/*  60 */     e;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("queue")
/*  66 */   private final Deque<Runnable> d = new ArrayDeque<>();
/*     */ 
/*     */   
/*     */   @h
/*  70 */   private final a a = (a)b.b;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("queue")
/*  80 */   private long bC = 0L;
/*     */   
/*     */   ah(Executor paramExecutor) {
/*  83 */     this.a = new a();
/*     */ 
/*     */ 
/*     */     
/*  87 */     this.executor = (Executor)D.checkNotNull(paramExecutor);
/*     */   }
/*     */ 
/*     */   
/*     */   private final Executor executor;
/*     */   @com.google.b.a.a.a("queue")
/*     */   private b a;
/*     */   
/*     */   public void execute(Runnable paramRunnable) {
/*     */     Runnable runnable;
/*     */     long l;
/*  98 */     D.checkNotNull(paramRunnable);
/*     */ 
/*     */     
/* 101 */     synchronized (this.d) {
/*     */ 
/*     */       
/* 104 */       if (this.a == b.e || this.a == b.d) {
/* 105 */         this.d.add(paramRunnable);
/*     */         
/*     */         return;
/*     */       } 
/* 109 */       l = this.bC;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 117 */       runnable = new Runnable(this, paramRunnable)
/*     */         {
/*     */           public void run()
/*     */           {
/* 121 */             this.e.run();
/*     */           }
/*     */ 
/*     */           
/*     */           public String toString() {
/* 126 */             return this.e.toString();
/*     */           }
/*     */         };
/* 129 */       this.d.add(runnable);
/* 130 */       this.a = (a)b.c;
/*     */     } 
/*     */     
/*     */     try {
/* 134 */       this.executor.execute(this.a);
/* 135 */     } catch (RuntimeException|Error runtimeException) {
/* 136 */       synchronized (this.d) {
/*     */ 
/*     */         
/* 139 */         boolean bool1 = ((this.a == b.b || this.a == b.c) && this.d.removeLastOccurrence(runnable)) ? true : false;
/*     */ 
/*     */         
/* 142 */         if (!(runtimeException instanceof java.util.concurrent.RejectedExecutionException) || bool1) {
/* 143 */           throw runtimeException;
/*     */         }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 160 */     boolean bool = (this.a != b.c) ? true : false;
/* 161 */     if (bool) {
/*     */       return;
/*     */     }
/* 164 */     synchronized (this.d) {
/* 165 */       if (this.bC == l && this.a == b.c)
/* 166 */         this.a = (a)b.d; 
/*     */     } 
/*     */   }
/*     */   
/*     */   private final class a
/*     */     implements Runnable {
/*     */     Runnable c;
/*     */     
/*     */     private a(ah this$0) {}
/*     */     
/*     */     public void run() {
/*     */       try {
/* 178 */         gc();
/* 179 */       } catch (Error error) {
/* 180 */         synchronized (ah.a(this.a)) {
/* 181 */           ah.a(this.a, ah.b.b);
/*     */         } 
/* 183 */         throw error;
/*     */       } 
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
/*     */     
/*     */     private void gc() {
/* 202 */       boolean bool = false;
/* 203 */       boolean bool1 = false;
/*     */       try {
/*     */         while (true) {
/* 206 */           synchronized (ah.a(this.a)) {
/*     */ 
/*     */             
/* 209 */             if (!bool1) {
/* 210 */               if (ah.a(this.a) == ah.b.e) {
/*     */                 return;
/*     */               }
/*     */ 
/*     */ 
/*     */ 
/*     */               
/* 217 */               ah.a(this.a);
/* 218 */               ah.a(this.a, ah.b.e);
/* 219 */               bool1 = true;
/*     */             } 
/*     */             
/* 222 */             this.c = ah.a(this.a).poll();
/* 223 */             if (this.c == null) {
/* 224 */               ah.a(this.a, ah.b.b);
/*     */ 
/*     */               
/*     */               return;
/*     */             } 
/*     */           } 
/*     */           
/* 231 */           bool |= Thread.interrupted();
/*     */           try {
/* 233 */             this.c.run();
/* 234 */           } catch (RuntimeException runtimeException) {
/* 235 */             String str = String.valueOf(this.c); ah.b().log(Level.SEVERE, (new StringBuilder(35 + String.valueOf(str).length())).append("Exception while executing runnable ").append(str).toString(), runtimeException);
/*     */           } finally {
/* 237 */             this.c = null;
/*     */           }
/*     */         
/*     */         }
/*     */       
/*     */       } finally {
/*     */         
/* 244 */         if (bool) {
/* 245 */           Thread.currentThread().interrupt();
/*     */         }
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 253 */       Runnable runnable = this.c;
/* 254 */       if (runnable != null) {
/* 255 */         String str1 = String.valueOf(runnable); return (new StringBuilder(34 + String.valueOf(str1).length())).append("SequentialExecutorWorker{running=").append(str1).append("}").toString();
/*     */       } 
/* 257 */       String str = String.valueOf(ah.a(this.a)); return (new StringBuilder(32 + String.valueOf(str).length())).append("SequentialExecutorWorker{state=").append(str).append("}").toString();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 263 */     int i = System.identityHashCode(this); String str = String.valueOf(this.executor); return (new StringBuilder(32 + String.valueOf(str).length())).append("SequentialExecutor@").append(i).append("{").append(str).append("}").toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ah.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */