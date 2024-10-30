/*     */ package br.com.arremate.d.t;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ThreadPoolExecutor;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.stream.Collectors;
/*     */ 
/*     */ public class f
/*     */   implements Runnable
/*     */ {
/*     */   private final ThreadPoolExecutor a;
/*     */   private final AtomicBoolean b;
/*     */   private final AtomicInteger c;
/*     */   private final List<a> q;
/*     */   private final Timer a;
/*  25 */   private List<Future<String>> r = new ArrayList<>();
/*     */   
/*     */   public f() {
/*  28 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  29 */     this.q = Collections.synchronizedList(new ArrayList<>());
/*  30 */     this.b = new AtomicBoolean(true);
/*  31 */     this.c = new AtomicInteger(1);
/*     */     
/*  33 */     this.a = new Timer("expireControl");
/*  34 */     this.a.schedule(b(), 1000L, 1000L);
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  39 */     while (this.b.get()) {
/*     */       
/*  41 */       ArrayList<List<Future<String>>> arrayList = new ArrayList(((Map)this.r.stream().parallel().collect(Collectors.partitioningBy(paramFuture -> paramFuture.isDone()))).values());
/*     */ 
/*     */ 
/*     */       
/*  45 */       this.r = arrayList.get(0);
/*     */ 
/*     */       
/*  48 */       ((List)arrayList.get(1)).forEach(paramFuture -> {
/*     */             try {
/*     */               String str = paramFuture.get();
/*     */               if (!str.isEmpty()) {
/*     */                 this.q.add(new a(this, str));
/*     */               }
/*  54 */             } catch (InterruptedException|java.util.concurrent.ExecutionException interruptedException) {}
/*     */           });
/*     */ 
/*     */ 
/*     */       
/*  59 */       if (this.r != null && this.q != null && this.c != null && 
/*  60 */         this.r.size() + this.q.size() <= this.c.get()) {
/*  61 */         Future<?> future = this.a.submit(() -> j.a().j().a());
/*     */ 
/*     */ 
/*     */         
/*  65 */         this.r.add(future);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private TimerTask b() {
/*  72 */     return new TimerTask(this)
/*     */       {
/*     */         public void run() {
/*  75 */           synchronized (f.a(this.a)) {
/*  76 */             f.a(this.a).forEach(param1a -> param1a.setTimeout(param1a.getTimeout() - 1000L));
/*     */ 
/*     */ 
/*     */             
/*  80 */             f.a(this.a).removeIf(param1a -> (param1a.getTimeout() <= 0L));
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void stopThread() {
/*  89 */     this.b.set(false);
/*  90 */     this.a.cancel();
/*  91 */     this.a.shutdown();
/*  92 */     this.r = null;
/*     */   }
/*     */   
/*     */   public void L(int paramInt) {
/*  96 */     this.c.set(Math.round((float)(paramInt * 1.6D)));
/*     */   }
/*     */   
/*     */   public a a() {
/* 100 */     synchronized (this.q) {
/* 101 */       if (!this.q.isEmpty()) {
/* 102 */         return this.q.remove(0);
/*     */       }
/* 104 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final class a
/*     */   {
/*     */     private String q;
/*     */     private long timeout;
/*     */     
/*     */     a(f this$0, String param1String) {
/* 115 */       this.q = param1String;
/* 116 */       this.timeout = 60000L;
/*     */     }
/*     */     
/*     */     public String a() {
/* 120 */       return this.q;
/*     */     }
/*     */     
/*     */     public void u(String param1String) {
/* 124 */       this.q = param1String;
/*     */     }
/*     */     
/*     */     public long getTimeout() {
/* 128 */       return this.timeout;
/*     */     }
/*     */     
/*     */     public void setTimeout(long param1Long) {
/* 132 */       this.timeout = param1Long;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 137 */       return (((a)param1Object).a() == this.q);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\t\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */