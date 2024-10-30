/*     */ package br.com.arremate.d.q;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.m.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.n.n;
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
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private Element e;
/*     */   private Elements c;
/*     */   private String ak;
/*     */   private List<h> h;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  47 */     super(parame, parami, paramg);
/*  48 */     a((a)new br.com.arremate.k.b.b());
/*  49 */     this.ak = "";
/*  50 */     this.h = new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  59 */       int i = IntStream.range(0, this.c.size()).filter(paramInt -> this.c.get(paramInt).text().contains("Menor preço")).findFirst().getAsInt();
/*     */       
/*  61 */       if (i > 0) {
/*     */ 
/*     */         
/*  64 */         String str1 = this.e.select("td:eq(" + i + ")").first().text().replace("R$", "").replace(".", "").replace(",", ".").replace(" ", "").trim();
/*  65 */         if (!"".equals(str1)) {
/*  66 */           double d = Double.parseDouble(str1);
/*  67 */           a().l(d);
/*     */         } 
/*     */         
/*  70 */         String str2 = this.e.select("td:eq(1) img:eq(0)").attr("title");
/*  71 */         a().N(str2);
/*     */         
/*  73 */         s s = this.e.html().contains("ic_vencedor.gif") ? s.a : s.c;
/*     */ 
/*     */         
/*  76 */         a().a(s);
/*     */       } 
/*     */       
/*  79 */       this.h = t();
/*     */       
/*  81 */       if (!this.h.isEmpty()) {
/*  82 */         a().h(this.h.get(0));
/*     */         
/*  84 */         Optional<h> optional = this.h.stream().filter(paramh -> paramh.bb()).findFirst();
/*  85 */         if (optional.isPresent()) {
/*  86 */           a().h(((h)optional.get()).m());
/*     */         }
/*     */         
/*  89 */         s s = ((h)this.h.get(0)).bb() ? s.a : s.c;
/*     */ 
/*     */         
/*  92 */         a().a(s);
/*     */         
/*  94 */         if (a().br() || b().c().equals(t.d)) {
/*     */           
/*  96 */           if (a().bt()) {
/*  97 */             a().N(g.s.getValue());
/*     */           }
/*  99 */           b().g(a());
/* 100 */           b().p(a());
/*     */         } 
/*     */       } 
/* 103 */     } catch (Exception exception) {
/* 104 */       a.error("#006", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 110 */     return (parami == i.a || (parami == i.b && 
/* 111 */       !g.b(paramString, g.aq)) || 
/* 112 */       g.b(paramString, g.ar));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 118 */     if (!this.h.isEmpty())
/*     */     {
/*     */       
/* 121 */       return new ArrayList<>(this.h);
/*     */     }
/* 123 */     return t();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> t() {
/* 128 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 130 */     if ("".equals(this.ak)) {
/* 131 */       bn();
/*     */     }
/*     */     
/* 134 */     e e = b().s(this.ak);
/* 135 */     b().e(e.k());
/* 136 */     String str = e.getData();
/*     */     
/* 138 */     if ("".equals(str)) {
/* 139 */       return arrayList;
/*     */     }
/*     */     
/*     */     try {
/* 143 */       Document document = Jsoup.parse(str);
/* 144 */       byte b1 = -1, b2 = -1, b3 = -1, b4 = -1, b5 = -1, b6 = -1; byte b7 = 1;
/* 145 */       Elements elements = document.select(".tdTituloLista");
/*     */       
/* 147 */       for (byte b8 = 0; b8 < elements.size(); b8++) {
/* 148 */         String str1 = elements.get(b8).text();
/* 149 */         if (str1.contains("Licitante")) {
/* 150 */           b1 = b8;
/* 151 */         } else if (str1.contains("LC 123/06")) {
/* 152 */           b2 = b8;
/* 153 */         } else if (str1.contains("Data")) {
/* 154 */           b3 = b8;
/* 155 */         } else if (str1.contains("Valor do lance")) {
/* 156 */           b4 = b8;
/* 157 */         } else if (str1.contains("Marca")) {
/* 158 */           b5 = b8;
/* 159 */         } else if (str1.contains("Modelo")) {
/* 160 */           b6 = b8;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 165 */       if (b1 > -1 && b2 > -1 && b3 > -1 && b4 > -1) {
/* 166 */         Elements elements1 = document.select("div[id^=divLances] > table > tbody > tr");
/*     */         
/* 168 */         for (Element element : elements1) {
/*     */           
/* 170 */           String str1 = element.html().toLowerCase();
/* 171 */           str1 = str1.replace("&amp;", "&");
/*     */           
/* 173 */           if (str1.contains("lance válido")) {
/* 174 */             Elements elements2 = element.select("td[class=tdItemLista]");
/*     */             
/* 176 */             String str2 = elements2.get(b1).text();
/*     */             
/* 178 */             String str3 = elements2.get(b2).text().replaceAll("\\W", "");
/* 179 */             boolean bool = str3.equals("Sim");
/*     */ 
/*     */             
/* 182 */             String str4 = elements2.get(b3).text();
/* 183 */             SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 184 */             Date date = simpleDateFormat.parse(str4);
/*     */ 
/*     */             
/* 187 */             String str5 = elements2.get(b4).text();
/* 188 */             str5 = str5.replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 189 */             double d = Double.parseDouble(str5);
/*     */ 
/*     */             
/* 192 */             String str6 = (b5 > -1) ? elements2.get(b5).text().replace(" ", "") : "";
/*     */ 
/*     */             
/* 195 */             String str7 = (b6 > -1) ? elements2.get(b6).text() : "";
/*     */ 
/*     */             
/* 198 */             h h = new h(d);
/* 199 */             h.c(date);
/* 200 */             h.al(str7);
/* 201 */             h.am(str6);
/* 202 */             h.E(str2);
/* 203 */             h.x(bool);
/* 204 */             h.ap(bool ? "ME/EPP" : "Demais (Diferente de ME/EPP)");
/* 205 */             h.l(b7++);
/* 206 */             h.A(str2.contains(a().a().a().bv()));
/* 207 */             arrayList.add(h);
/*     */           } 
/*     */         } 
/*     */       } 
/* 211 */     } catch (Exception exception) {
/* 212 */       a.warn(String.join(" - ", new CharSequence[] { "#033", a().bo() }), exception);
/* 213 */       h(String.join(" - ", new CharSequence[] { "#033", a().bo() }));
/*     */     } 
/*     */     
/* 216 */     return arrayList;
/*     */   }
/*     */   
/*     */   private void bn() {
/*     */     try {
/* 221 */       if (!b().isRunning() && 
/* 222 */         b().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 227 */       String str1 = this.e.select("td:last-child a").first().attr("onclick").split(",")[0].replace("AbrirJanela('", "").replace("'", "");
/* 228 */       String str2 = b().G(str1);
/*     */       
/* 230 */       if (!"".equals(str2)) {
/* 231 */         this.ak = str2;
/*     */         return;
/*     */       } 
/* 234 */     } catch (Exception exception) {
/* 235 */       a.error("#002 - Failed to load hash item", exception);
/* 236 */       h("#002 - Failed to load hash item");
/*     */     } 
/*     */     
/* 239 */     this.ak = "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*     */     try {
/* 245 */       a a = (a)a().a();
/*     */       
/* 247 */       if (!k.b()) {
/* 248 */         a.y(n.a().longValue());
/* 249 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 250 */         return true;
/*     */       } 
/*     */       
/* 253 */       double d = paramh.m();
/* 254 */       e e = b().a(a, d);
/* 255 */       String str1 = c(e);
/*     */       
/* 257 */       String str2 = e.getData();
/* 258 */       if (str2.isEmpty()) {
/* 259 */         a(paramh, paramBoolean, "Sem retorno do portal!", str1);
/* 260 */         return false;
/*     */       } 
/*     */       
/* 263 */       if (str2.equals("failedGenerateToken")) {
/* 264 */         a(paramh, paramBoolean, "Falha ao quebrar o reCAPTCHA para o envio do lance!", str1);
/* 265 */         return false;
/*     */       } 
/*     */       
/* 268 */       i i1 = new i(str2);
/* 269 */       if (i1.isEmpty()) {
/* 270 */         a(paramh, paramBoolean, "Mensagem do portal sem informações!", str1);
/* 271 */         return false;
/*     */       } 
/*     */       
/* 274 */       if (!i1.has("lstRetorno")) {
/* 275 */         String str = "Mensagem do portal sem informações!";
/* 276 */         if (i1.has("Message")) {
/* 277 */           str = i1.getString("Message");
/*     */         }
/*     */         
/* 280 */         a(paramh, paramBoolean, str, str1);
/* 281 */         return false;
/*     */       } 
/*     */       
/* 284 */       f f1 = i1.c("lstRetorno");
/* 285 */       if (!f1.isEmpty()) {
/* 286 */         i1 = f1.b(0);
/* 287 */         if (!i1.has("sDsErro") || i1.isNull("sDsErro")) {
/* 288 */           a.y(n.a().longValue());
/* 289 */           a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str1 + "s" });
/* 290 */           c(d);
/* 291 */           return true;
/*     */         } 
/*     */         
/* 294 */         String str = i1.getString("sDsErro").trim();
/* 295 */         if (str.contains("não disponível para lance")) {
/* 296 */           str = str + " -- Situação: " + a().bB();
/*     */         }
/*     */         
/* 299 */         a(paramh, paramBoolean, "Mensagem de erro: " + str, str1);
/* 300 */         return false;
/*     */       } 
/*     */       
/* 303 */       i i2 = i1.j("oReCaptcha");
/* 304 */       String str3 = i2.getString("sMensagem");
/*     */       
/* 306 */       if (str3.contains("incorrect-captcha-sol")) {
/* 307 */         str3 = "reCAPTCHA inválido!";
/*     */       }
/*     */       
/* 310 */       if (k(i2)) {
/* 311 */         str3 = "Erro na validação do reCAPTCHA!";
/*     */       }
/*     */       
/* 314 */       a(paramh, paramBoolean, "Mensagem de erro: " + str3, str1);
/* 315 */       return false;
/* 316 */     } catch (Exception exception) {
/* 317 */       a.error(String.join("", new CharSequence[] { "Failed to send item {} bid", a().bo() }), exception);
/*     */ 
/*     */       
/* 320 */       return false;
/*     */     } 
/*     */   }
/*     */   private void a(h paramh, boolean paramBoolean, String paramString1, String paramString2) {
/* 324 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { paramString1, "Tempo para envio: " + paramString2 + "s" });
/*     */   }
/*     */   
/*     */   private String c(e parame) {
/* 328 */     double d = parame.k() / 1000.0D;
/* 329 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 330 */     return decimalFormat.format(d);
/*     */   }
/*     */   
/*     */   private boolean k(i parami) throws g {
/* 334 */     return (!parami.isNull("bFlScoreViolado") && parami.has("bFlScoreViolado") && parami.getBoolean("bFlScoreViolado"));
/*     */   }
/*     */   
/*     */   protected int[] a() {
/* 338 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 341 */       List<h> list = e();
/* 342 */       long l1 = n.a().longValue();
/* 343 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 345 */       int i = (int)list.stream().filter(paramh -> (paramh.b().getTime() > paramLong)).count();
/*     */       
/* 347 */       arrayOfInt[0] = i;
/* 348 */       arrayOfInt[1] = list.size() - i;
/* 349 */     } catch (Exception exception) {
/* 350 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 351 */       b().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 354 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(double paramDouble) {
/* 363 */     a().h(paramDouble);
/*     */     
/* 365 */     if (paramDouble < a().f().m() && m().equals("1º Lugar")) {
/* 366 */       a().l(paramDouble);
/* 367 */       a().a(s.a);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String c(String paramString) {
/* 377 */     String str = paramString.split("<br />")[1];
/* 378 */     return str.substring(str.indexOf("<strong>") + 8, str.indexOf("</strong>"));
/*     */   }
/*     */ 
/*     */   
/*     */   public j b() {
/* 383 */     return (j)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 388 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   void i(Element paramElement) {
/* 392 */     this.e = paramElement;
/*     */   }
/*     */   
/*     */   public void b(Elements paramElements) {
/* 396 */     this.c = paramElements;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\q\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */