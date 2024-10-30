/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
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
/*     */ 
/*     */ @c
/*     */ final class ar<V>
/*     */   extends A.a<V>
/*     */ {
/*     */   private U<V> i;
/*     */   private ScheduledFuture<?> c;
/*     */   
/*     */   static <V> U<V> b(U<V> paramU, long paramLong, TimeUnit paramTimeUnit, ScheduledExecutorService paramScheduledExecutorService) {
/*  43 */     ar<V> ar1 = new ar<>(paramU);
/*  44 */     a<V> a1 = new a<>(ar1);
/*  45 */     ar1.c = paramScheduledExecutorService.schedule(a1, paramLong, paramTimeUnit);
/*  46 */     paramU.a(a1, ab.b());
/*  47 */     return ar1;
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
/*     */   private ar(U<V> paramU) {
/*  78 */     this.i = (U<V>)D.checkNotNull(paramU);
/*     */   }
/*     */   
/*     */   private static final class a<V>
/*     */     implements Runnable {
/*     */     ar<V> a;
/*     */     
/*     */     a(ar<V> param1ar) {
/*  86 */       this.a = param1ar;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/*  93 */       ar<V> ar1 = this.a;
/*  94 */       if (ar1 == null) {
/*     */         return;
/*     */       }
/*  97 */       U<? extends V> u = ar.a(ar1);
/*  98 */       if (u == null) {
/*     */         return;
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 114 */       this.a = null;
/* 115 */       if (u.isDone()) {
/* 116 */         ar1.a(u);
/*     */       } else {
/*     */         try {
/* 119 */           ScheduledFuture scheduledFuture = ar.a(ar1);
/* 120 */           ar.a(ar1, (ScheduledFuture)null);
/* 121 */           String str = "Timed out";
/*     */ 
/*     */           
/*     */           try {
/* 125 */             if (scheduledFuture != null) {
/* 126 */               long l = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
/* 127 */               if (l > 10L) {
/* 128 */                 String str3 = String.valueOf(str); str = (new StringBuilder(66 + String.valueOf(str3).length())).append(str3).append(" (timeout delayed by ").append(l).append(" ms after scheduled time)").toString();
/*     */               } 
/*     */             } 
/* 131 */             String str1 = String.valueOf(str), str2 = String.valueOf(u); str = (new StringBuilder(2 + String.valueOf(str1).length() + String.valueOf(str2).length())).append(str1).append(": ").append(str2).toString();
/*     */           } finally {
/* 133 */             ar1.a(new ar.b(str));
/*     */           } 
/*     */         } finally {
/* 136 */           u.cancel(true);
/*     */         } 
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private static final class b extends TimeoutException {
/*     */     private b(String param1String) {
/* 144 */       super(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public synchronized Throwable fillInStackTrace() {
/* 149 */       setStackTrace(new StackTraceElement[0]);
/* 150 */       return this;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected String ds() {
/* 156 */     U<V> u = this.i;
/* 157 */     ScheduledFuture<?> scheduledFuture = this.c;
/* 158 */     if (u != null) {
/* 159 */       String str2 = String.valueOf(u), str1 = (new StringBuilder(14 + String.valueOf(str2).length())).append("inputFuture=[").append(str2).append("]").toString();
/* 160 */       if (scheduledFuture != null) {
/* 161 */         long l = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
/*     */         
/* 163 */         if (l > 0L) {
/* 164 */           String str = String.valueOf(str1); str1 = (new StringBuilder(43 + String.valueOf(str).length())).append(str).append(", remaining delay=[").append(l).append(" ms]").toString();
/*     */         } 
/*     */       } 
/* 167 */       return str1;
/*     */     } 
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fx() {
/* 174 */     h(this.i);
/*     */     
/* 176 */     ScheduledFuture<?> scheduledFuture = this.c;
/*     */ 
/*     */ 
/*     */     
/* 180 */     if (scheduledFuture != null) {
/* 181 */       scheduledFuture.cancel(false);
/*     */     }
/*     */     
/* 184 */     this.i = null;
/* 185 */     this.c = null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ar.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */