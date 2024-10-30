/*     */ package com.google.a.o.a;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import com.google.b.a.b;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ThreadFactory;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class ap
/*     */ {
/*  49 */   private String iW = null;
/*  50 */   private Boolean daemon = null;
/*  51 */   private Integer priority = null;
/*  52 */   private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = null;
/*  53 */   private ThreadFactory b = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ap a(String paramString) {
/*  70 */     String str = b(paramString, new Object[] { Integer.valueOf(0) });
/*  71 */     this.iW = paramString;
/*  72 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ap a(boolean paramBoolean) {
/*  82 */     this.daemon = Boolean.valueOf(paramBoolean);
/*  83 */     return this;
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
/*     */   public ap a(int paramInt) {
/*  95 */     D.a((paramInt >= 1), "Thread priority (%s) must be >= %s", paramInt, 1);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     D.a((paramInt <= 10), "Thread priority (%s) must be <= %s", paramInt, 10);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 105 */     this.priority = Integer.valueOf(paramInt);
/* 106 */     return this;
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
/*     */   public ap a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler) {
/* 118 */     this.uncaughtExceptionHandler = (Thread.UncaughtExceptionHandler)D.checkNotNull(paramUncaughtExceptionHandler);
/* 119 */     return this;
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
/*     */   public ap a(ThreadFactory paramThreadFactory) {
/* 132 */     this.b = (ThreadFactory)D.checkNotNull(paramThreadFactory);
/* 133 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @b
/*     */   public ThreadFactory b() {
/* 145 */     return a(this);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static ThreadFactory a(ap paramap) {
/* 151 */     String str = paramap.iW;
/* 152 */     Boolean bool = paramap.daemon;
/* 153 */     Integer integer = paramap.priority;
/* 154 */     Thread.UncaughtExceptionHandler uncaughtExceptionHandler = paramap.uncaughtExceptionHandler;
/*     */ 
/*     */ 
/*     */     
/* 158 */     ThreadFactory threadFactory = (paramap.b != null) ? paramap.b : Executors.defaultThreadFactory();
/* 159 */     AtomicLong atomicLong = (str != null) ? new AtomicLong(0L) : null;
/* 160 */     return new ThreadFactory(threadFactory, str, atomicLong, bool, integer, uncaughtExceptionHandler)
/*     */       {
/*     */         public Thread newThread(Runnable param1Runnable) {
/* 163 */           Thread thread = this.c.newThread(param1Runnable);
/* 164 */           if (this.iX != null) {
/* 165 */             thread.setName(ap.c(this.iX, new Object[] { Long.valueOf(this.e.getAndIncrement()) }));
/*     */           }
/* 167 */           if (this.c != null) {
/* 168 */             thread.setDaemon(this.c.booleanValue());
/*     */           }
/* 170 */           if (this.f != null) {
/* 171 */             thread.setPriority(this.f.intValue());
/*     */           }
/* 173 */           if (this.a != null) {
/* 174 */             thread.setUncaughtExceptionHandler(this.a);
/*     */           }
/* 176 */           return thread;
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private static String b(String paramString, Object... paramVarArgs) {
/* 182 */     return String.format(Locale.ROOT, paramString, paramVarArgs);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\o\a\ap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */