/*     */ package br.com.arremate.d.p;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.g.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.m.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.IntStream;
/*     */ import org.e.f;
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
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private Element e;
/*     */   private Elements c;
/*     */   private String ak;
/*     */   private List<h> h;
/*     */   private a a;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  53 */     super(parame, parami, paramg);
/*  54 */     a((a)new br.com.arremate.k.b.b());
/*  55 */     this.ak = "";
/*  56 */     this.h = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws br.com.arremate.g.b, e, a {
/*  61 */     if (a().a().a().equals(m.c)) {
/*  62 */       if (this.a == null) {
/*  63 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  66 */       return this.a.a();
/*     */     } 
/*     */     
/*  69 */     return super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  78 */       int i = IntStream.range(0, this.c.size()).filter(paramInt -> this.c.get(paramInt).text().contains("Menor preço")).findFirst().getAsInt();
/*     */       
/*  80 */       if (i > 0) {
/*     */ 
/*     */         
/*  83 */         String str = this.e.select("td:eq(" + i + ")").first().text().replace("R$", "").replace(".", "").replace(",", ".").replace(" ", "").trim();
/*  84 */         if (!"".equals(str)) {
/*  85 */           double d = Double.parseDouble(str);
/*  86 */           a().l(d);
/*     */         } 
/*     */         
/*  89 */         if (a().a().a() != m.a) {
/*  90 */           bl();
/*     */         }
/*     */         
/*  93 */         if (a().a().a() == m.c) {
/*  94 */           bo();
/*     */         }
/*     */         
/*  97 */         bc();
/*     */         
/*  99 */         s s = this.e.html().contains("ic_vencedor.gif") ? s.a : s.c;
/*     */ 
/*     */         
/* 102 */         a().a(s);
/*     */       } 
/*     */       
/* 105 */       if (!a().bB().equals(g.h.getValue())) {
/* 106 */         this.h = t();
/*     */       }
/*     */       
/* 109 */       if (!this.h.isEmpty()) {
/* 110 */         a().h(this.h.get(0));
/*     */         
/* 112 */         Optional<h> optional = this.h.stream().filter(paramh -> paramh.bb()).findFirst();
/*     */         
/* 114 */         if (optional.isPresent()) {
/* 115 */           a().h(((h)optional.get()).m());
/*     */         }
/*     */         
/* 118 */         s s = ((h)this.h.get(0)).bb() ? s.a : s.c;
/*     */ 
/*     */         
/* 121 */         a().a(s);
/*     */         
/* 123 */         if (a().br() || b().c().equals(t.d)) {
/*     */           
/* 125 */           if (a().bt()) {
/* 126 */             a().N(g.s.getValue());
/*     */           }
/* 128 */           b().g(a());
/* 129 */           b().p(a());
/*     */         } 
/*     */       } 
/* 132 */     } catch (Exception exception) {
/* 133 */       a.error("#006", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bo() {
/* 138 */     if (!a().a().aS() && a().bB().equals(g.h.getValue()) && this.e.select("input:not([type=hidden])").first() != null) {
/* 139 */       a().v(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void bc() {
/* 144 */     String str = this.e.select("td:eq(1) img:eq(0)").attr("title");
/* 145 */     if (a().a().a() == m.b) {
/* 146 */       if (str.equals("Aberto") && a().z() > 0L && a().z() <= TimeUnit.MINUTES.toMillis(2L)) {
/* 147 */         str = g.I.getValue();
/* 148 */       } else if (a().bB().equals(g.I.getValue()) && a().z() <= 0L) {
/* 149 */         str = g.s.getValue();
/*     */       } 
/*     */     }
/* 152 */     if (a().a().a() == m.c) {
/* 153 */       String str1 = this.e.select("td:eq(1) img:eq(1)").attr("title");
/* 154 */       String str2 = "Etapa de disputa fechada";
/*     */       
/* 156 */       if (str.equals("Encerrado") && str1.equals(str2)) {
/* 157 */         str = g.s.getValue();
/* 158 */       } else if (str.equals("Encerrado") && !str1.equals(str2)) {
/* 159 */         str = g.n.getValue();
/* 160 */       } else if (str.equals("Aberto") && str1.equals(str2)) {
/* 161 */         str = g.h.getValue();
/*     */       } 
/*     */     } 
/* 164 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void bl() {
/* 168 */     Elements elements = this.e.select("input[id*=hidRelogioTempoRestante]");
/*     */     
/* 170 */     if (elements != null && elements.first() != null && !elements.first().val().isEmpty()) {
/* 171 */       String str = elements.first().val();
/* 172 */       a().x(Long.parseLong(str));
/*     */     } else {
/* 174 */       a().x(0L);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 180 */     return (parami == i.a || (
/* 181 */       g.b(paramString, g.I) && parami == i.b) || 
/* 182 */       g.b(paramString, g.ar) || 
/* 183 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 188 */     if (!this.h.isEmpty())
/*     */     {
/*     */       
/* 191 */       return new ArrayList<>(this.h);
/*     */     }
/* 193 */     return t();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> t() {
/* 198 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 200 */     if ("".equals(this.ak)) {
/* 201 */       bn();
/*     */     }
/*     */     
/* 204 */     e e = b().s(this.ak);
/* 205 */     b().e(e.k());
/* 206 */     String str = e.getData();
/*     */     
/* 208 */     if ("".equals(str) || str.contains("top.location ='/default.aspx?q=")) {
/* 209 */       return arrayList;
/*     */     }
/*     */     
/*     */     try {
/* 213 */       Document document = Jsoup.parse(str);
/* 214 */       byte b1 = -1, b2 = -1, b3 = -1, b4 = -1, b5 = -1; byte b6 = 1;
/* 215 */       Elements elements = document.select(".tdTituloLista");
/*     */       
/* 217 */       for (byte b7 = 0; b7 < elements.size(); b7++) {
/* 218 */         String str1 = elements.get(b7).text();
/* 219 */         if (str1.contains("Licitante")) {
/* 220 */           b1 = b7;
/* 221 */         } else if (str1.contains("LC 123/06")) {
/* 222 */           b2 = b7;
/* 223 */         } else if (str1.contains("Data")) {
/* 224 */           b3 = b7;
/* 225 */         } else if (str1.contains("Valor do lance")) {
/* 226 */           b4 = b7;
/* 227 */         } else if (str1.contains("Marca")) {
/* 228 */           b5 = b7;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 233 */       if (b1 > -1 && b2 > -1 && b3 > -1 && b4 > -1) {
/* 234 */         Elements elements1 = document.select("div[id^=divLances] > table > tbody > tr");
/*     */         
/* 236 */         for (Element element : elements1) {
/*     */           
/* 238 */           String str1 = element.html().toLowerCase();
/* 239 */           str1 = str1.replace("&amp;", "&");
/*     */           
/* 241 */           if (str1.contains("lance válido")) {
/* 242 */             Elements elements2 = element.select("td[class=tdItemLista]");
/*     */             
/* 244 */             String str2 = elements2.get(b1).text();
/*     */             
/* 246 */             String str3 = elements2.get(b2).text().replaceAll("\\W", "");
/* 247 */             boolean bool = str3.equals("Sim");
/*     */ 
/*     */             
/* 250 */             String str4 = elements2.get(b3).text();
/* 251 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 252 */             Date date = simpleDateFormat.parse(str4);
/*     */ 
/*     */             
/* 255 */             String str5 = elements2.get(b4).text();
/* 256 */             str5 = str5.replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 257 */             double d = Double.parseDouble(str5);
/*     */ 
/*     */             
/* 260 */             String str6 = (b5 > -1) ? elements2.get(b5).text().replace(" ", "") : "";
/*     */             
/* 262 */             String str7 = c(elements2.get(b1).getElementsByTag("span").attr("title"));
/*     */ 
/*     */             
/* 265 */             h h = new h(d);
/* 266 */             h.c(date);
/* 267 */             h.al(str6);
/* 268 */             h.D(str7);
/* 269 */             h.E(str2);
/* 270 */             h.x(bool);
/* 271 */             h.ap(bool ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/* 272 */             h.l(b6++);
/* 273 */             h.A(str2.contains(a().a().a().bv()));
/* 274 */             arrayList.add(h);
/*     */           } 
/*     */         } 
/*     */       } 
/* 278 */     } catch (Exception exception) {
/* 279 */       a.warn(String.join(" - ", new CharSequence[] { "#033", a().bo() }), exception);
/* 280 */       h(String.join(" - ", new CharSequence[] { "#033", a().bo() }));
/*     */     } 
/*     */     
/* 283 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void bn() {
/*     */     try {
/* 288 */       if (!b().isRunning() && 
/* 289 */         b().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 294 */       String str1 = this.e.select("td:last-child a").first().attr("onclick").split(",")[0].replace("AbrirJanela('", "").replace("'", "");
/* 295 */       String str2 = b().G(str1);
/*     */       
/* 297 */       if (!"".equals(str2)) {
/* 298 */         this.ak = str2;
/*     */         return;
/*     */       } 
/* 301 */     } catch (Exception exception) {
/* 302 */       a.error("#002 - Failed to load hash item", exception);
/* 303 */       h("#002 - Failed to load hash item");
/*     */     } 
/*     */     
/* 306 */     this.ak = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*     */     try {
/* 312 */       a a1 = (a)a().a();
/* 313 */       double d = paramh.m();
/*     */ 
/*     */       
/* 316 */       if (k.b()) {
/*     */ 
/*     */         
/* 319 */         String str = b().a(a1, d);
/* 320 */         f f1 = new f(str);
/*     */         
/* 322 */         if (f1.length() > 0) {
/* 323 */           if (!f1.b(0).has("sDsErro") || f1.b(0).isNull("sDsErro")) {
/* 324 */             a1.y(n.a().longValue());
/* 325 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 326 */             c(d);
/*     */             
/* 328 */             if (a().a().a() == m.c) {
/* 329 */               a().w(a().aR());
/*     */             }
/*     */             
/* 332 */             return true;
/*     */           } 
/* 334 */           String str1 = f1.b(0).getString("sDsErro");
/*     */           
/* 336 */           if (str1.contains("não disponível para lance")) {
/* 337 */             str1 = str1 + " -- Situação: " + a().bB();
/*     */           }
/*     */           
/* 340 */           if (str1.contains("atendem o incremento mínimo")) {
/* 341 */             String str2 = str1.replaceAll("[^0-9]+,?[^0-9]+", "");
/* 342 */             BigDecimal bigDecimal = new BigDecimal(y.a(str2).doubleValue());
/* 343 */             if (str1.contains("%")) {
/* 344 */               a().f(bigDecimal);
/*     */             } else {
/* 346 */               a().e(bigDecimal);
/*     */             } 
/*     */           } 
/*     */           
/* 350 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Mensagem de erro: " + str1 });
/* 351 */           return false;
/*     */         } 
/*     */       } else {
/*     */         
/* 355 */         a1.y(n.a().longValue());
/* 356 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/*     */         
/* 358 */         if (a().a().a() == m.c) {
/* 359 */           a().w(a().aR());
/*     */         }
/*     */         
/* 362 */         return true;
/*     */       } 
/* 364 */     } catch (Exception exception) {
/* 365 */       a.error(String.join(" - ", new CharSequence[] { "#009", a().bo() }), exception);
/* 366 */       h(String.join(" - ", new CharSequence[] { "#009", a().bo() }));
/*     */     } 
/*     */     
/* 369 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 378 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 381 */       List<h> list = e();
/* 382 */       long l1 = n.a().longValue();
/* 383 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 385 */       int i = (int)list.stream().filter(paramh -> (paramh.b().getTime() > paramLong)).count();
/*     */       
/* 387 */       arrayOfInt[0] = i;
/* 388 */       arrayOfInt[1] = list.size() - i;
/* 389 */     } catch (Exception exception) {
/* 390 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 391 */       b().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 394 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(double paramDouble) {
/* 403 */     a().h(paramDouble);
/*     */     
/* 405 */     if (paramDouble < a().f().m() && m().equals("1º Lugar")) {
/* 406 */       a().l(paramDouble);
/* 407 */       a().a(s.a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String c(String paramString) {
/*     */     try {
/* 418 */       String str = paramString.split("<br />")[1];
/* 419 */       return str.substring(str.indexOf("<strong>") + 8, str.indexOf("</strong>"));
/* 420 */     } catch (Exception exception) {
/*     */       
/* 422 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 428 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 433 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   void i(Element paramElement) {
/* 437 */     this.e = paramElement;
/*     */   }
/*     */   
/*     */   public void b(Elements paramElements) {
/* 441 */     this.c = paramElements;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\p\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */