/*     */ package br.com.arremate.d.n;
/*     */ 
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.m;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends e
/*     */ {
/*     */   private static final String ah = "TEMPO DE IMINÊNCIA concluído para esse lote. O TEMPO RANDÔMICO foi iniciado e a sessão de lances pode encerrar a qualquer momento.";
/*     */   private static final String ai = "A etapa de lances fechados foi iniciada.";
/*  25 */   private int ae = 0;
/*     */   
/*     */   public a(g paramg, i parami) {
/*  28 */     super(paramg, parami);
/*     */   }
/*     */ 
/*     */   
/*     */   protected List<m> d() {
/*  33 */     if (this.ae == 0) {
/*  34 */       this.ae = a().u();
/*  35 */       if (this.ae == 0) {
/*  36 */         return new ArrayList<>();
/*     */       }
/*     */     } 
/*     */     
/*  40 */     ArrayList<m> arrayList = new ArrayList();
/*  41 */     byte b1 = 1;
/*     */     
/*  43 */     boolean bool = false;
/*     */ 
/*     */     
/*  46 */     byte b2 = (a() == null) ? 100 : 10;
/*     */     try {
/*     */       int i;
/*     */       do {
/*  50 */         e e1 = a().b(this.ae, b1, b2);
/*  51 */         String str = e1.getData();
/*  52 */         if (str.isEmpty()) {
/*     */           break;
/*     */         }
/*     */         
/*  56 */         i i1 = new i(str);
/*  57 */         i i2 = i1.j("resultado");
/*  58 */         i = i2.getInt("total");
/*  59 */         f f = i2.c("dados");
/*     */         
/*  61 */         for (byte b = 0; b < f.length(); b++) {
/*  62 */           i i3 = f.b(b);
/*  63 */           m m = a(i3);
/*  64 */           if (a(m)) {
/*  65 */             bool = true;
/*     */             
/*     */             break;
/*     */           } 
/*  69 */           arrayList.add(0, m);
/*  70 */           k(m);
/*  71 */           if (a().a().a() == m.c) {
/*  72 */             l(m);
/*     */           }
/*     */         } 
/*     */         
/*  76 */         ++b1;
/*  77 */       } while (b1 * b2 < i && !bool);
/*  78 */     } catch (Exception exception) {
/*  79 */       a.warn("Failed to get new messages", exception);
/*     */     } 
/*     */     
/*  82 */     return arrayList;
/*     */   }
/*     */   
/*     */   private static m a(i parami) {
/*  86 */     String str1 = Integer.toString(parami.getInt("numeroLote"));
/*  87 */     String str2 = parami.getString("texto");
/*  88 */     Date date = y.a(parami.getString("dataHoraEnvio"));
/*  89 */     String str3 = parami.j("remetente").getString("descricao");
/*     */     
/*  91 */     if (str3.equalsIgnoreCase("fornecedor")) {
/*  92 */       str3 = String.join(" ", new CharSequence[] { str3, parami.j("fornecedor").getString("identificadorFornecedorFormatado") });
/*     */     }
/*     */     
/*  95 */     return new m(str1, str2, date, str3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void k(m paramm) {
/* 104 */     if (paramm != null && "TEMPO DE IMINÊNCIA concluído para esse lote. O TEMPO RANDÔMICO foi iniciado e a sessão de lances pode encerrar a qualquer momento.".equals(paramm.j())) {
/* 105 */       e e1 = a().a(paramm.bo());
/*     */       
/* 107 */       if (e1 != null) {
/* 108 */         br.com.arremate.l.k.a a1 = (br.com.arremate.l.k.a)e1.a();
/* 109 */         a1.e(paramm.b());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void l(m paramm) {
/* 120 */     if (paramm != null && paramm.j().contains("A etapa de lances fechados foi iniciada.")) {
/* 121 */       e e1 = a().a(paramm.bo());
/* 122 */       if (e1 != null) {
/* 123 */         br.com.arremate.l.k.a a1 = (br.com.arremate.l.k.a)e1.a();
/* 124 */         if (paramm.j().contains(a1.bG())) {
/* 125 */           a1.v(true);
/*     */         }
/*     */         
/* 128 */         a1.F(true);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public e a() {
/* 135 */     return (e)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 140 */     return (c)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\n\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */