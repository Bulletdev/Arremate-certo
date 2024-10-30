/*     */ package br.com.arremate.d;
/*     */ 
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class e
/*     */   extends Thread
/*     */ {
/*  17 */   protected static final Logger a = LoggerFactory.getLogger(e.class);
/*     */   
/*     */   private final g a;
/*     */   
/*     */   private final i a;
/*     */   private final AtomicBoolean b;
/*     */   private long c;
/*     */   private m a;
/*     */   
/*     */   public e(g paramg, i parami) {
/*  27 */     this.a = (m)paramg;
/*  28 */     this.a = (m)parami;
/*  29 */     this.b = new AtomicBoolean(true);
/*  30 */     this.c = 5000L;
/*     */     
/*  32 */     this.a = null;
/*     */   }
/*     */ 
/*     */   
/*     */   protected abstract List<m> d();
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*     */       do {
/*  42 */         if (this.a != null && this.a.isRunning()) {
/*  43 */           c(d());
/*     */         }
/*     */         
/*  46 */         Thread.sleep(this.c);
/*  47 */       } while (this.b.get());
/*  48 */     } catch (Exception exception) {
/*  49 */       a.error("Falha na thread de captura de mensagens", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void c(List<m> paramList) {
/*  54 */     for (byte b = 0; b < paramList.size(); b++) {
/*  55 */       m m1 = paramList.get(b);
/*  56 */       this.a = m1;
/*  57 */       this.a.a(m1);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void d(List<m> paramList) {
/*  62 */     paramList.forEach(this.a::a);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final boolean a(m paramm) {
/*  72 */     if (this.a == null) {
/*  73 */       return false;
/*     */     }
/*     */     
/*  76 */     return (this.a.a(paramm) >= 0);
/*     */   }
/*     */   
/*     */   public g a() {
/*  80 */     return (g)this.a;
/*     */   }
/*     */   
/*     */   public i a() {
/*  84 */     return (i)this.a;
/*     */   }
/*     */   
/*     */   protected void h(long paramLong) {
/*  88 */     this.c = paramLong;
/*     */   }
/*     */   
/*     */   void O() {
/*  92 */     this.b.set(false);
/*     */   }
/*     */   
/*     */   protected m a() {
/*  96 */     return this.a;
/*     */   }
/*     */   
/*     */   protected i a() {
/* 100 */     return this.a.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */