/*     */ package br.com.arremate.d.f;
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
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
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
/*     */   private Element d;
/*     */   private boolean l;
/*     */   
/*     */   public a(e parame, i parami, g paramg) {
/*  39 */     super(parame, parami, paramg);
/*     */     
/*  41 */     this.decimalFormat = y.a("###,###,###,##0.0000");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  46 */     byte b1 = 3;
/*  47 */     byte b2 = 4;
/*     */     
/*  49 */     if (a().a().k()) {
/*  50 */       b1 = 4;
/*  51 */       b2 = 6;
/*     */       
/*  53 */       if (a().a().a() == 0.0D) {
/*  54 */         double d = Double.parseDouble(this.b.get(3).text().replace(",", "."));
/*  55 */         a().a().p(d);
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/*     */       g g;
/*  61 */       String str1 = this.d.select("img").attr("src");
/*     */       
/*  63 */       if (str1.contains("ico_ampulheta3.gif")) {
/*  64 */         g = g.s;
/*  65 */       } else if (str1.contains("ico_ampulheta1.gif")) {
/*  66 */         g = g.v;
/*     */       } else {
/*  68 */         g = g.w;
/*     */       } 
/*     */ 
/*     */       
/*  72 */       String str2 = this.b.get(2).select("img").attr("src");
/*  73 */       s s = s.c;
/*  74 */       if (str2.contains("LanceVencedor.gif")) {
/*  75 */         s = s.a;
/*  76 */       } else if (str2.contains("LanceEmpatado.gif")) {
/*  77 */         s = s.b;
/*     */       } 
/*     */       
/*  80 */       String str3 = y.Q(this.b.get(b2).text()).replaceAll("[^0-9 .]", "");
/*  81 */       String str4 = y.Q(this.b.get(b1).text().replace("(Lance acima do valor máximo estabelecido, podendo ser recusado.)", "")).replaceAll("[^0-9 .]", "");
/*  82 */       double d = Double.parseDouble(str4);
/*     */       
/*  84 */       a().a(s);
/*  85 */       a().N(g.getValue());
/*  86 */       a().h(Double.parseDouble(str3));
/*  87 */       a().l(d);
/*     */       
/*  89 */       if (a().br()) {
/*  90 */         b().g(a());
/*     */       }
/*  92 */     } catch (Exception exception) {
/*  93 */       a.error("Erro ao buscar dados do item", exception);
/*  94 */       h("#009 - Dados dos itens");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 100 */     return (parami == i.a || 
/* 101 */       a().a().as());
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() {
/* 106 */     h h = null;
/* 107 */     boolean bool = true;
/*     */     
/* 109 */     if (a().a() == s.a) {
/* 110 */       bool = (this.l && a().b().aH());
/* 111 */     } else if (a().b().aG()) {
/* 112 */       bool = this.l;
/*     */     } 
/*     */     
/* 115 */     if (bool) {
/* 116 */       if (a().j() == h.i.v()) {
/* 117 */         h = h((List<h>)null);
/*     */       }
/*     */       
/* 120 */       if (h != null)
/*     */       {
/* 122 */         if (!b(h.m())) {
/* 123 */           h = new h(a().l());
/* 124 */           i("Lance Derradeiro");
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 129 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   protected h h(List<h> paramList) {
/* 134 */     h h = a().a(a());
/*     */     
/* 136 */     if (h != null) {
/* 137 */       i("1º Lugar");
/* 138 */       return h;
/* 139 */     }  if (a().b().aD()) {
/* 140 */       h = new h(a().l());
/* 141 */       i("Lance Derradeiro");
/*     */     } else {
/* 143 */       i("Sem limite");
/*     */     } 
/*     */     
/* 146 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 151 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 156 */     boolean bool = false;
/*     */     
/*     */     try {
/* 159 */       if (k.b()) {
/* 160 */         long l1 = System.currentTimeMillis();
/* 161 */         long l2 = System.currentTimeMillis();
/*     */ 
/*     */         
/* 164 */         byte b1 = 2;
/* 165 */         byte b2 = 1;
/*     */         
/* 167 */         while (b1 > b2) {
/* 168 */           long l = System.currentTimeMillis() - l2;
/*     */           
/* 170 */           double d = paramh.m();
/* 171 */           if (a().a().k()) {
/* 172 */             d = b(d);
/* 173 */             paramh.q(d);
/*     */           } 
/*     */           
/* 176 */           String str1 = this.decimalFormat.format(paramh.m());
/*     */           
/* 178 */           int i = a().a().v();
/* 179 */           int j = a().v();
/*     */           
/* 181 */           e e = b().a(str1, i, j);
/* 182 */           if (e.getStatusCode() == 200) {
/* 183 */             bool = true;
/*     */             
/* 185 */             a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + a(e) });
/* 186 */             a.info("Lance de R$ {} enviado", str1);
/*     */             break;
/*     */           } 
/* 189 */           Document document = Jsoup.parse(e.getData());
/* 190 */           String str2 = document.select("descricao").first().text();
/* 191 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str2, "Tempo para envio: " + 
/* 192 */                 a(e) });
/* 193 */           a.warn("Lance de R$ {} não enviado. {}. Tentar novamente.", str1, str2);
/*     */           
/* 195 */           if (!paramBoolean && str2.contains("O lance informado deve ser menor que seu último lance")) {
/*     */             break;
/*     */           }
/*     */           
/* 199 */           if (l > 2000L) {
/* 200 */             a.warn("Fim das tentativas");
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 206 */         long l3 = System.currentTimeMillis() - l1;
/* 207 */         a.info("Tempo gasto para envio de lances: {}ms", Long.toString(l3));
/*     */       } else {
/* 209 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/*     */       } 
/* 211 */     } catch (Exception exception) {
/* 212 */       a.error("Falha no envio do lance - #010", exception);
/*     */     } 
/*     */     
/* 215 */     return bool;
/*     */   }
/*     */   
/*     */   private String a(e parame) {
/* 219 */     double d = parame.k() / 1000.0D;
/* 220 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 221 */     return decimalFormat.format(d);
/*     */   }
/*     */   
/*     */   private double b(double paramDouble) {
/* 225 */     double d = a().a().a();
/* 226 */     return paramDouble / d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean b(double paramDouble) {
/* 233 */     return (a() != null) ? ((paramDouble >= 
/* 234 */       a().l() && paramDouble < a().f())) : false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public d b() {
/* 240 */     return (d)super.b();
/*     */   }
/*     */   
/*     */   public void a(Elements paramElements) {
/* 244 */     this.b = paramElements;
/*     */   }
/*     */   
/*     */   public void g(Element paramElement) {
/* 248 */     this.d = paramElement;
/*     */   }
/*     */   
/*     */   public void e(boolean paramBoolean) {
/* 252 */     this.l = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\f\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */