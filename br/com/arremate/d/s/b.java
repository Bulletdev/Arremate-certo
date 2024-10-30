/*     */ package br.com.arremate.d.s;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.b.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.o.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private List<h> h;
/*     */   private double c;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  39 */     super(parame, parami, paramg);
/*  40 */     a(new a());
/*     */     
/*  42 */     this.h = new ArrayList<>();
/*  43 */     this.c = -1.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  49 */       if (this.c == -1.0D && a().isRunning()) {
/*  50 */         br();
/*     */       }
/*     */       
/*  53 */       this.h = t();
/*     */       
/*  55 */       if (!this.h.isEmpty()) {
/*  56 */         a().h(this.h.get(0));
/*     */         
/*  58 */         this.h.stream().filter(paramh -> paramh.bb()).forEachOrdered(paramh -> a().h(paramh.m()));
/*     */ 
/*     */ 
/*     */         
/*  62 */         s s = ((h)this.h.get(0)).bb() ? s.a : s.c;
/*     */ 
/*     */         
/*  65 */         a().a(s);
/*     */         
/*  67 */         if (a().br() || a().c().equals(t.d)) {
/*  68 */           a().g(a());
/*  69 */           a().p(a());
/*     */         } 
/*     */       } 
/*  72 */     } catch (Exception exception) {
/*  73 */       a.error("#006", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/*  79 */     return (parami == i.a || 
/*  80 */       a().bu());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/*  85 */     if (!this.h.isEmpty())
/*     */     {
/*     */       
/*  88 */       return new ArrayList<>(this.h);
/*     */     }
/*  90 */     return t();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> t() {
/*  95 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/*     */     try {
/*  98 */       e e = b().a(a().a().v(), a().v());
/*  99 */       a().e(e.k());
/* 100 */       String str = e.getData();
/*     */       
/* 102 */       if (!"".equals(str)) {
/* 103 */         Document document = Jsoup.parse(str);
/*     */         
/* 105 */         int i = -1, j = -1, k = -1, m = -1, n = -1;
/* 106 */         Elements elements = document.select("tr[class=tdcolor2] > td");
/*     */         
/* 108 */         for (byte b1 = 0; b1 < elements.size(); b1++) {
/* 109 */           String str1 = elements.get(b1).text();
/* 110 */           if (str1.contains("Proponente")) {
/* 111 */             i = b1 + 1;
/* 112 */           } else if (str1.contains("VL Unit. Lance")) {
/* 113 */             j = b1 + 1;
/* 114 */           } else if (str1.contains("VL Lance")) {
/* 115 */             k = b1 + 1;
/* 116 */           } else if (str1.contains("VL Prop.")) {
/* 117 */             m = b1 + 1;
/* 118 */           } else if (str1.contains("VL Unit. Prop.")) {
/* 119 */             n = b1 + 1;
/*     */           } 
/*     */         } 
/*     */         
/* 123 */         if (i > -1 && j > -1 && k > -1 && m > -1 && n > -1) {
/* 124 */           String str1 = document.select("input[name=UltLanceCli_" + a().v() + "]").first().attr("value").trim();
/* 125 */           str1 = y.Q(str1);
/* 126 */           double d = Double.parseDouble(str1);
/* 127 */           boolean bool = false;
/* 128 */           Element element = document.select("tr[class=tdcolor2]").first().parent();
/*     */           
/* 130 */           Elements elements1 = element.select("tr");
/* 131 */           if (elements1.size() > 1) {
/* 132 */             elements1.remove(0);
/* 133 */             elements1.remove(elements1.size() - 1);
/* 134 */             byte b2 = 1;
/*     */             
/* 136 */             for (Element element1 : elements1) {
/* 137 */               Elements elements2 = element1.select("td");
/*     */               
/* 139 */               String str2 = elements2.get(i).text();
/* 140 */               String str3 = elements2.get(j).text().replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 141 */               String str4 = elements2.get(k).text().replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/*     */               
/* 143 */               if (str3.isEmpty() && str4.isEmpty()) {
/* 144 */                 str3 = elements2.get(n).text().replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 145 */                 str4 = elements2.get(m).text().replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 146 */                 bool = true;
/*     */               } 
/*     */               
/* 149 */               double d1 = Double.parseDouble(str4);
/* 150 */               double d2 = Double.parseDouble(str3);
/*     */               
/* 152 */               h h = new h();
/* 153 */               h.q(d2);
/* 154 */               h.l(b2);
/* 155 */               h.A((d1 == d || str2.contains(a().a().a().bv())));
/*     */               
/* 157 */               b2++;
/* 158 */               arrayList.add(h);
/*     */             } 
/*     */             
/* 161 */             if (bool) {
/* 162 */               Collections.sort(arrayList, (paramh1, paramh2) -> (paramh1.m() < paramh2.m()) ? -1 : ((paramh1.m() > paramh2.m()) ? 1 : 0));
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
/* 173 */               b2 = 1;
/* 174 */               for (h h : arrayList) {
/* 175 */                 h.l(b2);
/* 176 */                 b2++;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 182 */     } catch (Exception exception) {
/* 183 */       a.error(String.join(" - ", new CharSequence[] { "#008", a().bo() }), exception);
/* 184 */       h(String.join(" - ", new CharSequence[] { "#008", a().bo() }));
/*     */     } 
/*     */     
/* 187 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void br() {
/* 194 */     String str = b().a(a().a().v(), a().v());
/* 195 */     if (!"".equals(str)) {
/* 196 */       Document document = Jsoup.parse(str);
/* 197 */       Elements elements = document.select("input[name=IT_VL_ABERTURA_" + a().v() + "]");
/*     */       
/* 199 */       if (elements != null && elements.size() > 0) {
/* 200 */         String str1 = elements.first().attr("value").trim().replace(".", "").replace(",", ".");
/*     */         
/* 202 */         if (str1 != null && "".equals(str1)) {
/* 203 */           this.c = Double.parseDouble(str1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*     */     try {
/* 212 */       a a = (a)a().a();
/*     */ 
/*     */       
/* 215 */       if (a().l() <= paramh.m()) {
/* 216 */         if (k.b()) {
/* 217 */           int i = a.v();
/*     */           
/* 219 */           BigDecimal bigDecimal1 = BigDecimal.valueOf(paramh.m());
/*     */           
/* 221 */           BigDecimal bigDecimal2 = bigDecimal1.multiply(BigDecimal.valueOf(a.i())).setScale(4, RoundingMode.HALF_DOWN);
/*     */           
/* 223 */           String str1 = bigDecimal2.toString().replace(".", ",");
/* 224 */           String str2 = bigDecimal1.toString().replace(".", ",");
/*     */           
/* 226 */           e e = b().a(i, str2, Double.toString(this.c), str1);
/* 227 */           String str3 = e.getData();
/*     */           
/* 229 */           if (str3.contains("Lances Registrados com Sucesso.")) {
/* 230 */             a.y(n.a().longValue());
/*     */             
/* 232 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 233 */             return true;
/*     */           } 
/* 235 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Erro: ", str3 });
/*     */           
/* 237 */           if (str3 == null || str3.isEmpty()) {
/* 238 */             a.warn("Item {} - Licitação {} - Valor Lance Unt R${} - Valor Lance Total R${} - Status code {} - Falha ao enviar lance", new Object[] {
/* 239 */                   a().bo(), a().a().bo(), str2, str1, Integer.valueOf(e.getStatusCode())
/*     */                 });
/*     */           }
/*     */         } else {
/* 243 */           a.y(n.a().longValue());
/* 244 */           a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 245 */           return true;
/*     */         } 
/*     */       } else {
/* 248 */         a.warn("{} - Tentou enviar lance abaixo do valor mínimo", a().bo());
/*     */       } 
/* 250 */     } catch (Exception exception) {
/* 251 */       a.error(String.join(" - ", new CharSequence[] { "#009", a().bo() }), exception);
/* 252 */       h(String.join(" - ", new CharSequence[] { "#009", a().bo() }));
/*     */     } 
/*     */     
/* 255 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 260 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 265 */     return (c)super.b();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\s\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */