/*     */ package br.com.arremate.d.t;
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
/*     */ import br.com.arremate.j.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.m.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.stream.IntStream;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
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
/*  52 */     super(parame, parami, paramg);
/*  53 */     a((a)new br.com.arremate.k.b.b());
/*  54 */     this.ak = "";
/*  55 */     this.h = new ArrayList<>();
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws br.com.arremate.g.b, e, a {
/*  60 */     if (a().a().a().equals(m.c)) {
/*  61 */       if (this.a == null) {
/*  62 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  65 */       return this.a.a();
/*     */     } 
/*     */     
/*  68 */     return super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  77 */       int i = IntStream.range(0, this.c.size()).filter(paramInt -> this.c.get(paramInt).text().contains("Menor preço")).findFirst().getAsInt();
/*     */       
/*  79 */       if (i > 0) {
/*     */ 
/*     */         
/*  82 */         String str = this.e.select("td:eq(" + i + ")").first().text().replace("R$", "").replace(".", "").replace(",", ".").replace(" ", "").trim();
/*  83 */         if (!"".equals(str)) {
/*  84 */           double d = Double.parseDouble(str);
/*  85 */           a().l(d);
/*     */         } 
/*     */         
/*  88 */         if (a().a().a() != m.a) {
/*  89 */           bl();
/*     */         }
/*     */         
/*  92 */         if (a().a().a() == m.c) {
/*  93 */           bo();
/*     */         }
/*     */         
/*  96 */         bc();
/*     */         
/*  98 */         s s = this.e.html().contains("ic_vencedor.gif") ? s.a : s.c;
/*     */ 
/*     */         
/* 101 */         a().a(s);
/*     */       } 
/*     */       
/* 104 */       if (!a().bB().equals(g.h.getValue())) {
/* 105 */         this.h = t();
/*     */       }
/*     */       
/* 108 */       if (!this.h.isEmpty()) {
/* 109 */         a().h(this.h.get(0));
/*     */         
/* 111 */         Optional<h> optional = this.h.stream().filter(paramh -> paramh.bb()).findFirst();
/*     */         
/* 113 */         if (optional.isPresent()) {
/* 114 */           a().h(((h)optional.get()).m());
/*     */         }
/*     */         
/* 117 */         s s = ((h)this.h.get(0)).bb() ? s.a : s.c;
/*     */ 
/*     */         
/* 120 */         a().a(s);
/*     */         
/* 122 */         if (a().br() || b().c().equals(t.d)) {
/*     */           
/* 124 */           if (a().bt()) {
/* 125 */             a().N(g.s.getValue());
/*     */           }
/* 127 */           b().g(a());
/* 128 */           b().p(a());
/*     */         } 
/*     */       } 
/* 131 */     } catch (Exception exception) {
/* 132 */       a.error("#006", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bo() {
/* 137 */     if (!a().a().aS() && a().bB().equals(g.h.getValue()) && this.e.select("input:not([type=hidden])").first() != null) {
/* 138 */       a().v(true);
/*     */     }
/*     */   }
/*     */   
/*     */   private void bc() {
/* 143 */     String str = this.e.select("td:eq(1) img:eq(0)").attr("title");
/* 144 */     if (a().a().a() == m.b) {
/* 145 */       if (str.equals("Aberto") && a().z() > 0L && a().z() <= TimeUnit.MINUTES.toMillis(2L)) {
/* 146 */         str = g.I.getValue();
/* 147 */       } else if (a().bB().equals(g.I.getValue()) && a().z() <= 0L) {
/* 148 */         str = g.s.getValue();
/*     */       } 
/*     */     }
/* 151 */     if (a().a().a() == m.c) {
/* 152 */       String str1 = this.e.select("td:eq(1) img:eq(1)").attr("title");
/* 153 */       String str2 = "Etapa de disputa fechada";
/*     */       
/* 155 */       if (str.equals("Encerrado") && str1.equals(str2)) {
/* 156 */         str = g.s.getValue();
/* 157 */       } else if (str.equals("Encerrado") && !str1.equals(str2)) {
/* 158 */         str = g.n.getValue();
/* 159 */       } else if (str.equals("Aberto") && str1.equals(str2)) {
/* 160 */         str = g.h.getValue();
/*     */       } 
/*     */     } 
/* 163 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void bl() {
/* 167 */     Elements elements = this.e.select("input[id*=hidRelogioTempoRestante]");
/*     */     
/* 169 */     if (elements != null && elements.first() != null && !elements.first().val().isEmpty()) {
/* 170 */       String str = elements.first().val();
/* 171 */       a().x(Long.parseLong(str));
/*     */     } else {
/* 173 */       a().x(0L);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 179 */     return (parami == i.a || (
/* 180 */       g.b(paramString, g.I) && parami == i.b) || 
/* 181 */       g.b(paramString, g.ar) || 
/* 182 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 187 */     if (!this.h.isEmpty())
/*     */     {
/*     */       
/* 190 */       return new ArrayList<>(this.h);
/*     */     }
/* 192 */     return t();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> t() {
/* 197 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 199 */     if ("".equals(this.ak)) {
/* 200 */       bn();
/*     */     }
/*     */     
/* 203 */     e e = b().s(this.ak);
/* 204 */     b().e(e.k());
/* 205 */     String str = e.getData();
/*     */     
/* 207 */     if ("".equals(str)) {
/* 208 */       return arrayList;
/*     */     }
/*     */     
/*     */     try {
/* 212 */       Document document = Jsoup.parse(str);
/* 213 */       byte b1 = -1, b2 = -1, b3 = -1, b4 = -1, b5 = -1; byte b6 = 1;
/* 214 */       Elements elements = document.select(".tdTituloLista");
/*     */       
/* 216 */       for (byte b7 = 0; b7 < elements.size(); b7++) {
/* 217 */         String str1 = elements.get(b7).text();
/* 218 */         if (str1.contains("Licitante")) {
/* 219 */           b1 = b7;
/* 220 */         } else if (str1.contains("LC 123/06")) {
/* 221 */           b2 = b7;
/* 222 */         } else if (str1.contains("Data")) {
/* 223 */           b3 = b7;
/* 224 */         } else if (str1.contains("Valor do lance")) {
/* 225 */           b4 = b7;
/* 226 */         } else if (str1.contains("Marca")) {
/* 227 */           b5 = b7;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 232 */       if (b1 > -1 && b2 > -1 && b3 > -1 && b4 > -1) {
/* 233 */         Elements elements1 = document.select("div[id^=divLances] > table > tbody > tr");
/*     */         
/* 235 */         for (Element element : elements1) {
/*     */           
/* 237 */           String str1 = element.html().toLowerCase();
/* 238 */           str1 = str1.replace("&amp;", "&");
/*     */           
/* 240 */           if (str1.contains("lance válido")) {
/* 241 */             Elements elements2 = element.select("td[class=tdItemLista]");
/*     */             
/* 243 */             String str2 = elements2.get(b1).text();
/*     */             
/* 245 */             String str3 = c(elements2.get(b1).getElementsByTag("span").attr("title"));
/*     */             
/* 247 */             String str4 = elements2.get(b2).text().replaceAll("\\W", "");
/* 248 */             boolean bool = str4.equals("Sim");
/*     */ 
/*     */             
/* 251 */             String str5 = elements2.get(b3).text();
/* 252 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 253 */             Date date = simpleDateFormat.parse(str5);
/*     */ 
/*     */             
/* 256 */             String str6 = elements2.get(b4).text();
/* 257 */             str6 = str6.replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 258 */             double d = Double.parseDouble(str6);
/*     */ 
/*     */             
/* 261 */             String str7 = (b5 > -1) ? elements2.get(b5).text().replace(" ", "") : "";
/*     */ 
/*     */             
/* 264 */             h h = new h(d);
/* 265 */             h.c(date);
/* 266 */             h.al(str7);
/* 267 */             h.D(str3);
/* 268 */             h.E(str2);
/* 269 */             h.x(bool);
/* 270 */             h.ap(bool ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/* 271 */             h.l(b6++);
/* 272 */             h.A(str2.contains(a().a().a().bv()));
/* 273 */             arrayList.add(h);
/*     */           } 
/*     */         } 
/*     */       } 
/* 277 */     } catch (Exception exception) {
/* 278 */       a.warn(String.join(" - ", new CharSequence[] { "#033", a().bo() }), exception);
/* 279 */       h(String.join(" - ", new CharSequence[] { "#033", a().bo() }));
/*     */     } 
/*     */     
/* 282 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void bn() {
/*     */     try {
/* 287 */       if (!b().isRunning() && 
/* 288 */         b().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 293 */       String str1 = this.e.select("td:last-child a").first().attr("onclick").split(",")[0].replace("AbrirJanela('", "").replace("'", "");
/* 294 */       String str2 = b().G(str1);
/*     */       
/* 296 */       if (!"".equals(str2)) {
/* 297 */         this.ak = str2;
/*     */         return;
/*     */       } 
/* 300 */     } catch (Exception exception) {
/* 301 */       a.error("#002 - Failed to load hash item", exception);
/* 302 */       h("#002 - Failed to load hash item");
/*     */     } 
/*     */     
/* 305 */     this.ak = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 310 */     String str = "";
/*     */     
/*     */     try {
/* 313 */       a a1 = (a)a().a();
/*     */       
/* 315 */       if (!k.b()) {
/* 316 */         a1.y(n.a().longValue());
/* 317 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/*     */         
/* 319 */         if (a().a().a() == m.c) {
/* 320 */           a().w(a().aR());
/*     */         }
/*     */         
/* 323 */         return true;
/*     */       } 
/*     */       
/* 326 */       double d = paramh.m();
/* 327 */       e e = b().a(a1, d);
/* 328 */       String str1 = c(e);
/*     */       
/* 330 */       str = e.getData();
/* 331 */       if (str.isEmpty()) {
/* 332 */         a(paramh, paramBoolean, "Sem retorno do portal!", str1);
/* 333 */         return false;
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 341 */       i i1 = new i(str);
/* 342 */       if (i1.isEmpty()) {
/* 343 */         a(paramh, paramBoolean, "Mensagem do portal sem informações!", str1);
/* 344 */         return false;
/*     */       } 
/*     */       
/* 347 */       if (!i1.has("lstRetorno")) {
/* 348 */         String str3 = "Mensagem do portal sem informações!";
/* 349 */         if (i1.has("Message")) {
/* 350 */           str3 = i1.getString("Message");
/*     */         }
/*     */         
/* 353 */         a(paramh, paramBoolean, str3, str1);
/* 354 */         return false;
/*     */       } 
/*     */       
/* 357 */       f f1 = i1.c("lstRetorno");
/* 358 */       if (!f1.isEmpty()) {
/* 359 */         i1 = f1.b(0);
/* 360 */         if (!i1.has("sDsErro") || i1.isNull("sDsErro")) {
/* 361 */           a1.y(n.a().longValue());
/* 362 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str1 + "s" });
/* 363 */           c(d);
/*     */           
/* 365 */           if (a().a().a() == m.c) {
/* 366 */             a().w(a().aR());
/*     */           }
/*     */           
/* 369 */           return true;
/*     */         } 
/*     */         
/* 372 */         String str3 = i1.getString("sDsErro").trim();
/* 373 */         if (str3.contains("não disponível para lance")) {
/* 374 */           str3 = str3 + " -- Situação: " + a().bB();
/*     */         }
/*     */         
/* 377 */         if (str3.contains("atendem o incremento mínimo")) {
/* 378 */           String str4 = str3.replaceAll("[^0-9]+,?[^0-9]+", "");
/* 379 */           BigDecimal bigDecimal = new BigDecimal(y.a(str4).doubleValue());
/* 380 */           if (str3.contains("%")) {
/* 381 */             a().f(bigDecimal);
/*     */           } else {
/* 383 */             a().e(bigDecimal);
/*     */           } 
/*     */         } 
/*     */         
/* 387 */         a(paramh, paramBoolean, "Mensagem de erro: " + str3, str1);
/* 388 */         return false;
/*     */       } 
/*     */       
/* 391 */       i i2 = i1.j("oReCaptcha");
/* 392 */       String str2 = i2.getString("sMensagem");
/*     */       
/* 394 */       if (str2.contains("incorrect-captcha-sol")) {
/* 395 */         str2 = "reCAPTCHA inválido!";
/*     */       }
/*     */       
/* 398 */       if (k(i2)) {
/* 399 */         str2 = "Erro na validação do reCAPTCHA!";
/*     */       }
/*     */       
/* 402 */       a(paramh, paramBoolean, "Mensagem de erro: " + str2, str1);
/* 403 */       return false;
/* 404 */     } catch (Exception exception) {
/* 405 */       a.error(String.join("", new CharSequence[] { "Failed to send item {} bid", a().bo() }), exception, str);
/*     */ 
/*     */       
/* 408 */       return false;
/*     */     } 
/*     */   }
/*     */   private void a(h paramh, boolean paramBoolean, String paramString1, String paramString2) {
/* 412 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { paramString1, "Tempo para envio: " + paramString2 + "s" });
/*     */   }
/*     */   
/*     */   private String c(e parame) {
/* 416 */     double d = parame.k() / 1000.0D;
/* 417 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 418 */     return decimalFormat.format(d);
/*     */   }
/*     */   
/*     */   private boolean k(i parami) throws g {
/* 422 */     return (!parami.isNull("bFlScoreViolado") && parami.has("bFlScoreViolado") && parami.getBoolean("bFlScoreViolado"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(double paramDouble) {
/* 431 */     a().h(paramDouble);
/*     */     
/* 433 */     if (paramDouble < a().f().m() && m().equals("1º Lugar")) {
/* 434 */       a().l(paramDouble);
/* 435 */       a().a(s.a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 445 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 448 */       List<h> list = e();
/* 449 */       long l1 = n.a().longValue();
/* 450 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 452 */       int i = (int)list.stream().filter(paramh -> (paramh.b().getTime() > paramLong)).count();
/*     */       
/* 454 */       arrayOfInt[0] = i;
/* 455 */       arrayOfInt[1] = list.size() - i;
/* 456 */     } catch (Exception exception) {
/* 457 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 458 */       b().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 461 */     return arrayOfInt;
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
/*     */   private String c(String paramString) {
/*     */     try {
/* 477 */       String str = paramString.split("<br />")[1];
/* 478 */       return str.substring(str.indexOf("<strong>") + 8, str.indexOf("</strong>"));
/* 479 */     } catch (Exception exception) {
/*     */       
/* 481 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public h b() {
/* 488 */     return (h)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 493 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   void i(Element paramElement) {
/* 497 */     this.e = paramElement;
/*     */   }
/*     */   
/*     */   public void b(Elements paramElements) {
/* 501 */     this.c = paramElements;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\t\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */