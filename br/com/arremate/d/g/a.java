/*     */ package br.com.arremate.d.g;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.h;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends f
/*     */ {
/*     */   private final DecimalFormat decimalFormat;
/*     */   private Elements b;
/*     */   private boolean l;
/*     */   
/*     */   public a(e parame, i parami, g paramg) {
/*  36 */     super(parame, parami, paramg);
/*     */     
/*  38 */     this.decimalFormat = y.a("###,###,###,##0.0000");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  43 */     byte b1 = 4;
/*  44 */     byte b2 = 3;
/*     */     
/*     */     try {
/*  47 */       if (a().a().k()) {
/*  48 */         b1 = 6;
/*  49 */         b2 = 4;
/*     */         
/*  51 */         if (a().a().a() == 0.0D) {
/*  52 */           double d1 = Double.parseDouble(this.b.get(3).text().replace(",", "."));
/*  53 */           a().a().p(d1);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/*  58 */       String str1 = this.b.get(2).select("img").attr("src");
/*  59 */       s s = s.c;
/*  60 */       if (str1.contains("LanceVencedor.gif")) {
/*  61 */         s = s.a;
/*  62 */       } else if (str1.contains("LanceEmpatado.gif")) {
/*  63 */         s = s.b;
/*     */       } 
/*     */       
/*  66 */       String str2 = y.Q(this.b.get(b1).text()).replaceAll("[^0-9 .]", "");
/*     */       
/*  68 */       String str3 = y.Q(this.b.get(b2).text().replace("(Lance acima do valor máximo estabelecido, podendo ser recusado.)", "")).replaceAll("[^0-9 .]", "");
/*  69 */       double d = Double.parseDouble(str3);
/*     */       
/*  71 */       a().N(g.v.getValue());
/*  72 */       a().a(s);
/*  73 */       a().h(Double.parseDouble(str2));
/*  74 */       a().l(d);
/*     */       
/*  76 */       if (a().br()) {
/*  77 */         b().g(a());
/*     */       }
/*  79 */     } catch (Exception exception) {
/*  80 */       a.error("Erro ao buscar dados do item", exception);
/*  81 */       h("#009 - Dados dos itens");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  87 */     if (a().b().aI()) {
/*  88 */       return (a().z() < a().b().v());
/*     */     }
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() {
/*  96 */     h h = null;
/*  97 */     boolean bool = true;
/*     */     
/*  99 */     if (a().a() == s.a) {
/* 100 */       bool = (this.l && a().b().aH()) ? true : false;
/*     */     }
/*     */     
/* 103 */     if (bool) {
/* 104 */       if (a().j() == h.i.v()) {
/* 105 */         h = h((List<h>)null);
/*     */       }
/*     */       
/* 108 */       if (h != null && 
/* 109 */         !b(h.m())) {
/* 110 */         h = new h(a().l());
/* 111 */         i("Lance Derradeiro");
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 116 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h h(List<h> paramList) {
/* 121 */     h h = a().a(a());
/*     */     
/* 123 */     if (h != null) {
/* 124 */       i("1º Lugar");
/* 125 */       return h;
/* 126 */     }  if (a().b().aD()) {
/* 127 */       h = new h(a().l());
/* 128 */       i("Lance Derradeiro");
/*     */     } else {
/* 130 */       i("Sem limite");
/*     */     } 
/*     */     
/* 133 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 138 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 143 */     boolean bool = false;
/*     */     
/*     */     try {
/* 146 */       if (k.b()) {
/* 147 */         long l1 = System.currentTimeMillis();
/* 148 */         long l2 = System.currentTimeMillis();
/*     */ 
/*     */         
/* 151 */         byte b1 = 2;
/* 152 */         byte b2 = 1;
/*     */         
/* 154 */         while (b1 > b2) {
/* 155 */           long l = System.currentTimeMillis() - l2;
/*     */           
/* 157 */           double d = paramh.m();
/* 158 */           if (a().a().k()) {
/* 159 */             d = b(d);
/* 160 */             paramh.q(d);
/*     */           } 
/*     */           
/* 163 */           String str1 = this.decimalFormat.format(paramh.m());
/*     */           
/* 165 */           int i = a().a().v();
/* 166 */           int j = a().v();
/*     */           
/* 168 */           e e = b().a(str1, i, j);
/* 169 */           if (e.getStatusCode() == 200) {
/* 170 */             bool = true;
/*     */             
/* 172 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 173 */             a.info("Lance de R$ {} enviado", str1);
/*     */             break;
/*     */           } 
/* 176 */           Document document = Jsoup.parse(e.getData());
/* 177 */           String str2 = document.select("descricao").first().text();
/* 178 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str2 });
/* 179 */           a.warn("Lance de R$ {} não enviado. {}. Tentar novamente.", str1, str2);
/*     */           
/* 181 */           if (!paramBoolean && str2.contains("O lance informado deve ser menor que seu último lance")) {
/*     */             break;
/*     */           }
/*     */           
/* 185 */           if (l > 2000L) {
/* 186 */             a.warn("Fim das tentativas");
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 192 */         long l3 = System.currentTimeMillis() - l1;
/* 193 */         a.info("Tempo gasto para envio de lances: {}ms", Long.toString(l3));
/*     */       } else {
/* 195 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/*     */       } 
/* 197 */     } catch (Exception exception) {
/* 198 */       a.error("Falha no envio do lance - #010", exception);
/*     */     } 
/*     */     
/* 201 */     return bool;
/*     */   }
/*     */   
/*     */   private double b(double paramDouble) {
/* 205 */     double d = a().a().a();
/* 206 */     return paramDouble / d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean b(double paramDouble) {
/* 213 */     return (a() != null) ? ((paramDouble >= 
/* 214 */       a().l() && paramDouble < a().f())) : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d b() {
/* 220 */     return (d)super.b();
/*     */   }
/*     */   
/*     */   public void a(Elements paramElements) {
/* 224 */     this.b = paramElements;
/*     */   }
/*     */   
/*     */   public void e(boolean paramBoolean) {
/* 228 */     this.l = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\g\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */