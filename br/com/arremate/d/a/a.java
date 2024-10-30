/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.v;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*     */   private final i a;
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future> c;
/*     */   private final Map<Integer, Runnable> d;
/*     */   
/*     */   public a(i parami) {
/*  28 */     this.a = parami;
/*  29 */     this.executor = Executors.newCachedThreadPool();
/*  30 */     this.c = new HashMap<>();
/*  31 */     this.d = new HashMap<>();
/*     */   }
/*     */   
/*     */   void k(e parame) {
/*  35 */     if (!parame.br()) {
/*  36 */       Future future = this.c.get(Integer.valueOf(parame.v()));
/*  37 */       if (future == null || future.isDone()) {
/*  38 */         int j = parame.v();
/*  39 */         Runnable runnable = this.d.get(Integer.valueOf(j));
/*  40 */         if (runnable == null) {
/*  41 */           runnable = a(parame);
/*  42 */           this.d.put(Integer.valueOf(j), runnable);
/*     */         } 
/*     */         
/*  45 */         Future<?> future1 = this.executor.submit(runnable);
/*  46 */         this.c.put(Integer.valueOf(j), future1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private Runnable a(e parame) {
/*  52 */     return () -> {
/*     */         String str = this.a.a(parame);
/*     */         if (str != null && !str.isEmpty()) {
/*     */           if (str.equals("Prorrogação automatica")) {
/*     */             str = g.I.getValue();
/*     */           }
/*     */           if (str.toLowerCase().contains("convocação do fornecedor")) {
/*     */             str = g.E.getValue();
/*     */           }
/*     */           br.com.arremate.l.a.a a1 = new br.com.arremate.l.a.a(0, this.a.a());
/*     */           a1.N(str);
/*     */           if (a1.ar() && parame.bu()) {
/*     */             return;
/*     */           }
/*     */           if (a1.at() && !((br.com.arremate.l.a.a)parame.a()).aA()) {
/*     */             return;
/*     */           }
/*     */           if (a1.at() && parame.aS()) {
/*     */             str = g.i.getValue();
/*     */           } else if (a1.at() && !parame.aR() && ((br.com.arremate.l.a.a)parame.a()).aA()) {
/*     */             str = g.p.getValue();
/*     */           } 
/*     */           String str1 = parame.bB();
/*     */           parame.N(str);
/*     */           if (parame.bv() && !parame.bB().equals(str1)) {
/*     */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*     */             String str2 = decimalFormat.format(parame.y());
/*     */             this.a.l(String.join("", new CharSequence[] { "O Lote ", parame.bo(), " entrou em Lance Fechado com o valor de ", (parame.w() == v.b.v()) ? (str2 + " %") : ("R$ " + str2) }));
/*     */           } 
/*     */           if (parame.br()) {
/*     */             this.a.g(parame);
/*     */           }
/*     */           int j = this.a.a().indexOf(parame.v());
/*     */           if (j >= 0) {
/*     */             this.a.a().fireTableCellUpdated(j, 8);
/*     */           }
/*     */         } 
/*     */       };
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
/*     */   void l(e parame) {
/* 111 */     this.c.remove(Integer.valueOf(parame.v()));
/* 112 */     this.d.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */   
/*     */   public void close() {
/* 116 */     this.executor.shutdown();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */