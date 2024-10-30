/*     */ package br.com.arremate.d;
/*     */ 
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.stream.Collectors;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class h
/*     */   extends Thread
/*     */ {
/*  24 */   protected static final Logger a = LoggerFactory.getLogger(h.class);
/*     */   
/*     */   private final g d;
/*     */   private boolean running;
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future> a;
/*     */   private final Map<Integer, f> b;
/*     */   
/*     */   public h(g paramg) {
/*  33 */     this.d = paramg;
/*  34 */     this.executor = Executors.newCachedThreadPool();
/*  35 */     this.a = new HashMap<>();
/*  36 */     this.b = new HashMap<>();
/*  37 */     this.running = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  43 */       while (isRunning()) {
/*  44 */         if (this.executor != null) {
/*  45 */           ag();
/*     */         }
/*     */       } 
/*  48 */     } catch (Exception exception) {
/*  49 */       a.error("Error running bid watch thread", exception);
/*  50 */       ah();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void ag();
/*     */ 
/*     */   
/*     */   public boolean isRunning() {
/*  60 */     return this.running;
/*     */   }
/*     */   
/*     */   protected g c() {
/*  64 */     return this.d;
/*     */   }
/*     */   
/*     */   public ExecutorService a() {
/*  68 */     return this.executor;
/*     */   }
/*     */   
/*     */   public Map<Integer, Future> b() {
/*  72 */     return this.a;
/*     */   }
/*     */   
/*     */   public Map<Integer, f> c() {
/*  76 */     return this.b;
/*     */   }
/*     */   
/*     */   public List<Integer> g() {
/*  80 */     return (List<Integer>)this.b.keySet().stream().collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   public void ah() {
/*  84 */     this.running = false;
/*     */   }
/*     */   
/*     */   public final i a() {
/*  88 */     return this.d.a();
/*     */   }
/*     */   
/*     */   public final j a() {
/*  92 */     return this.d.a();
/*     */   }
/*     */   
/*     */   public void h(String paramString) {
/*  96 */     this.d.h(paramString);
/*     */   }
/*     */   
/*     */   public void l(String paramString) {
/* 100 */     this.d.l(paramString);
/*     */   }
/*     */   
/*     */   protected f a(int paramInt) {
/* 104 */     return this.b.get(Integer.valueOf(paramInt));
/*     */   }
/*     */   
/*     */   public e a(int paramInt) {
/* 108 */     if (a() == null) {
/* 109 */       return null;
/*     */     }
/*     */     
/* 112 */     return a().a(paramInt);
/*     */   }
/*     */   
/*     */   public e a(String paramString) {
/* 116 */     if (a() == null) {
/* 117 */       return null;
/*     */     }
/*     */     
/* 120 */     return a().a(paramString);
/*     */   }
/*     */   
/*     */   public i b() {
/* 124 */     return c().a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */