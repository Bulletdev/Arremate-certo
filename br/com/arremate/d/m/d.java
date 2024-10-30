/*     */ package br.com.arremate.d.m;
/*     */ 
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.d.h;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.Future;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ public class d
/*     */   extends h
/*     */ {
/*     */   private final Set<Integer> c;
/*     */   private boolean r;
/*     */   
/*     */   public d(g paramg) {
/*  26 */     super(paramg);
/*  27 */     this.c = new HashSet<>();
/*  28 */     this.r = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void ag() {
/*     */     try {
/*  34 */       i i = l();
/*     */       
/*  36 */       if (i != null && 
/*  37 */         !i.has("msgErro") && 
/*  38 */         i.has("lotes") && !i.isNull("lotes")) {
/*  39 */         f f = i.c("lotes");
/*     */         
/*  41 */         if (f.length() == 0) {
/*  42 */           h("#001 - Lista de lotes em disputa vazia");
/*     */           
/*     */           return;
/*     */         } 
/*  46 */         for (byte b = 0; b < f.length(); b++) {
/*  47 */           i i1 = f.b(b);
/*  48 */           int j = i1.getInt("idLote");
/*  49 */           e e = a(j);
/*     */           
/*  51 */           if (e != null) {
/*  52 */             a(e, i1);
/*  53 */             this.c.remove(Integer.valueOf(e.v()));
/*     */           } 
/*     */         } 
/*     */         
/*  57 */         bj();
/*     */       }
/*     */     
/*     */     }
/*  61 */     catch (Exception exception) {
/*  62 */       a.error("#003", exception);
/*  63 */       h("#003");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(e parame, i parami) {
/*  68 */     int j = parame.v();
/*     */     
/*     */     try {
/*  71 */       Future future = (Future)b().get(Integer.valueOf(j));
/*     */       
/*  73 */       if (future == null || future.isDone()) {
/*  74 */         b b = a(j);
/*     */         
/*  76 */         if (b == null) {
/*  77 */           b = new b(parame, (i)b(), c());
/*     */ 
/*     */ 
/*     */           
/*  81 */           if (t.c.equals(c().c()) && !this.r && !parame.br()) {
/*  82 */             c().put(Integer.valueOf(j), b);
/*     */             
/*  84 */             String str1 = b.l();
/*  85 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*  86 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/*  88 */             StringBuilder stringBuilder = new StringBuilder();
/*  89 */             stringBuilder.append(str1).append(" ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/*  90 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/*  94 */         b.a(parami);
/*  95 */         Future<?> future1 = a().submit((Runnable)b);
/*  96 */         b().put(Integer.valueOf(j), future1);
/*     */       } 
/*  98 */     } catch (Exception exception) {
/*  99 */       a.warn("Failed to start thread from lote " + Integer.toString(j), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private i l() {
/* 109 */     if (!this.r) {
/* 110 */       this.c.clear();
/* 111 */       a().I().forEach(parame -> this.c.add(Integer.valueOf(parame.v())));
/*     */ 
/*     */ 
/*     */       
/* 115 */       return c().a(this.c);
/*     */     } 
/*     */     
/* 118 */     return c().l();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void bj() {
/* 128 */     this.c.stream()
/* 129 */       .map(paramInteger -> a(paramInteger.intValue()))
/* 130 */       .filter(parame -> (parame != null))
/* 131 */       .map(parame -> {
/*     */           parame.N("");
/*     */ 
/*     */           
/*     */           return parame;
/* 136 */         }).forEachOrdered(parame -> h(String.join(" ", new CharSequence[] { "#009 - Lote", parame.bo(), "não encontrado no array de lotes em disputa" })));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void bk() {
/* 144 */     b().entrySet().stream()
/* 145 */       .map(paramEntry -> (Future)paramEntry.getValue())
/* 146 */       .forEachOrdered(paramFuture -> {
/*     */           
/*     */           try {
/*     */             paramFuture.get();
/* 150 */           } catch (Exception exception) {}
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 156 */     b b = a(parame.v());
/* 157 */     if (b != null) {
/* 158 */       return b.a(new h(paramDouble), true);
/*     */     }
/*     */     
/* 161 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected c c() {
/* 166 */     return (c)super.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.j.d b() {
/* 171 */     return (br.com.arremate.j.d)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<Integer, f> c() {
/* 176 */     return super.c();
/*     */   }
/*     */ 
/*     */   
/*     */   public b a(int paramInt) {
/* 181 */     return (b)super.a(paramInt);
/*     */   }
/*     */   
/*     */   public void g(boolean paramBoolean) {
/* 185 */     this.r = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\m\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */