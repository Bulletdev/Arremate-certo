/*     */ package br.com.arremate.d.u;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.c;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.j.c.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.k.b.b;
/*     */ import br.com.arremate.l.b;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.e.f;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.n;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.net.URLDecoder;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends f
/*     */ {
/*     */   private final DecimalFormat decimalFormat;
/*     */   private final c a;
/*     */   private final b a;
/*     */   protected String ao;
/*     */   
/*     */   public e(br.com.arremate.l.q.b.e parame, d paramd, f paramf) {
/*  47 */     super(parame, (i)paramd, paramf);
/*  48 */     a((a)new b());
/*  49 */     this.decimalFormat = y.a("###,###,###,##0.0000");
/*  50 */     f f1 = (f)parame.a();
/*  51 */     this.a = (b)new c(f1);
/*  52 */     this.a = new b(this.a.a());
/*  53 */     this.ap = "";
/*  54 */     this.aq = "";
/*  55 */     this.ar = "";
/*  56 */     this.as = "";
/*  57 */     this.ao = "";
/*     */   }
/*     */   private Element e; private String ap; private String aq; private String ar; private String as;
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  63 */       Elements elements = this.e.select("td");
/*     */ 
/*     */       
/*  66 */       String str1 = elements.get(0).select("img").attr("src");
/*  67 */       s s = a(str1);
/*     */       
/*  69 */       String str2 = elements.get(4).text();
/*  70 */       String str3 = d(elements.get(6).toString());
/*  71 */       String str4 = elements.get(5).toString();
/*     */       
/*  73 */       if (StringUtils.containsIgnoreCase("desclassificado", str4)) {
/*  74 */         str2 = "Desclassificado";
/*     */       } else {
/*  76 */         String str = d(str4);
/*  77 */         if (!"".equals(str)) {
/*  78 */           a().h(Double.parseDouble(str));
/*     */         }
/*     */       } 
/*     */       
/*  82 */       a().a(s);
/*  83 */       if (!"".equals(str3)) {
/*  84 */         a().l(Double.parseDouble(str3));
/*     */       }
/*     */       
/*  87 */       if (!a().bB().equals("Cancelado") && (
/*  88 */         !"".equals(str2) || !g.b(a().bB(), g.k)))
/*     */       {
/*     */         
/*  91 */         a().N(str2);
/*     */       }
/*     */       
/*  94 */       if (a().br()) {
/*  95 */         a().g(a());
/*     */       }
/*  97 */     } catch (Exception exception) {
/*  98 */       a.error("#020", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected s a(String paramString) {
/* 103 */     if (paramString.contains("LanceVencedor.gif"))
/* 104 */       return s.a; 
/* 105 */     if (paramString.contains("LanceEmpatado.gif")) {
/* 106 */       return s.b;
/*     */     }
/* 108 */     return s.c;
/*     */   }
/*     */   
/*     */   protected String d(String paramString) {
/* 112 */     String str1 = "";
/* 113 */     String str2 = "FormataValor4CasasDecimais('";
/* 114 */     int i = paramString.indexOf(str2) + str2.length();
/*     */     
/* 116 */     String str3 = "')";
/* 117 */     int j = paramString.indexOf(str3);
/*     */     
/* 119 */     if (i != -1 && j != -1) {
/* 120 */       str1 = paramString.substring(i, j).trim();
/*     */     }
/*     */     
/* 123 */     return str1;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 128 */     return (parami == i.a || 
/* 129 */       g.b(paramString, g.k) || (
/* 130 */       g.b(paramString, g.j) && parami == i.b));
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
/*     */   protected h h(List<h> paramList) {
/* 142 */     b b1 = a().b();
/* 143 */     n n = a().a().b();
/* 144 */     d d = a().a().a();
/* 145 */     m m = a().a().a();
/*     */     
/* 147 */     boolean bool = b1.a(n, d, m);
/*     */     
/* 149 */     if (bool) {
/*     */       try {
/* 151 */         if (paramList == null) {
/* 152 */           paramList = e();
/*     */         }
/*     */         
/* 155 */         if (!paramList.isEmpty()) {
/* 156 */           h h = a().a(
/* 157 */               a().l(), paramList
/* 158 */               .get(0), 
/* 159 */               a().r(), 
/* 160 */               a().s(), b1, bool);
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 165 */           if (h != null) {
/* 166 */             i("1º Lugar");
/* 167 */             return h;
/*     */           } 
/*     */           
/* 170 */           return i(paramList);
/*     */         } 
/* 172 */       } catch (d d1) {
/* 173 */         a("capturar os melhores lances para disputar contra ME/EPP", d1);
/*     */       } 
/*     */     }
/*     */     
/* 177 */     return super.h(paramList);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h i(List<h> paramList) {
/* 182 */     boolean bool = a().b().aE();
/*     */     
/* 184 */     h h = super.i(paramList);
/*     */     
/* 186 */     if (h != null && bool) {
/*     */ 
/*     */       
/* 189 */       long l1 = n.a().longValue();
/* 190 */       long l2 = h.b().getTime();
/* 191 */       long l3 = l1 - l2;
/*     */       
/* 193 */       if (l3 > 0L && l3 < TimeUnit.SECONDS.toMillis(3L)) {
/*     */         try {
/* 195 */           sleep(l3);
/* 196 */         } catch (Exception exception) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 201 */     return h;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 212 */     if (!b(paramh.m()) && !paramBoolean) {
/* 213 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 214 */       return false;
/*     */     } 
/*     */     
/* 217 */     String str = "";
/*     */     
/*     */     try {
/* 220 */       NameValuePair[] arrayOfNameValuePair = a(paramh);
/*     */       
/* 222 */       if (arrayOfNameValuePair == null) {
/* 223 */         return false;
/*     */       }
/*     */       
/* 226 */       if (!k.b()) {
/* 227 */         a().a().y(n.a().longValue());
/* 228 */         a("Lance de simulação", paramh, m(), paramBoolean, new String[0]);
/* 229 */         return true;
/*     */       } 
/*     */       
/* 232 */       str = this.a.a().a(arrayOfNameValuePair);
/* 233 */     } catch (Exception exception) {
/* 234 */       a.error(String.join(" - ", new CharSequence[] { "#025", a().bo() }), exception);
/* 235 */       a().h("#025 - " + a().bo());
/*     */     } finally {
/* 237 */       this.a.bu();
/*     */     } 
/*     */     
/* 240 */     return a(str, paramh, paramBoolean);
/*     */   }
/*     */   
/*     */   protected boolean a(String paramString, h paramh, boolean paramBoolean) {
/* 244 */     if (paramString.contains("Lance+registrado+com+sucesso")) {
/* 245 */       a().a().y(n.a().longValue());
/* 246 */       a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 247 */       return true;
/*     */     } 
/*     */     
/* 250 */     a(paramString, paramh, paramBoolean);
/* 251 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void a(String paramString, h paramh, boolean paramBoolean) {
/* 256 */     String str = "";
/*     */     
/* 258 */     if (!paramString.isEmpty()) {
/* 259 */       String str1 = "AtualizarPagina('";
/* 260 */       int i = paramString.indexOf(str1) + str1.length();
/* 261 */       int j = paramString.indexOf("');");
/*     */       
/* 263 */       if (i > -1 && j > -1) {
/* 264 */         str = paramString.substring(i, j);
/* 265 */         str = URLDecoder.decode(str);
/*     */         
/* 267 */         if (str.contains("intervalo mínimo de diferença entre os lances")) {
/* 268 */           str = "O lance deve atender o percentual mínimo de diferença entre lances estipulado pelo portal.";
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str });
/*     */   }
/*     */   
/*     */   protected NameValuePair[] a(h paramh) {
/* 277 */     if (this.e == null) {
/* 278 */       return null;
/*     */     }
/*     */     
/* 281 */     int i = a().a().v();
/* 282 */     int j = a().v();
/* 283 */     double d = paramh.m();
/* 284 */     String str = a().format(d);
/*     */     
/* 286 */     bv();
/*     */     
/* 288 */     if (this.ap.isEmpty() || this.aq.isEmpty() || this.ar.isEmpty() || this.as
/* 289 */       .isEmpty()) {
/* 290 */       return null;
/*     */     }
/*     */     
/* 293 */     NameValuePair[] arrayOfNameValuePair = new NameValuePair[11];
/* 294 */     arrayOfNameValuePair[0] = (NameValuePair)new BasicNameValuePair("valorlance", str);
/* 295 */     arrayOfNameValuePair[2] = (NameValuePair)new BasicNameValuePair("ticket", this.a.F());
/*     */     
/* 297 */     arrayOfNameValuePair[1] = (NameValuePair)new BasicNameValuePair("sequence", this.a.G());
/* 298 */     arrayOfNameValuePair[3] = (NameValuePair)new BasicNameValuePair("ipgCod", Integer.toString(j));
/* 299 */     arrayOfNameValuePair[4] = (NameValuePair)new BasicNameValuePair("prgCod", Integer.toString(i));
/* 300 */     arrayOfNameValuePair[5] = (NameValuePair)new BasicNameValuePair("ippCod", this.ap);
/* 301 */     arrayOfNameValuePair[6] = (NameValuePair)new BasicNameValuePair("valormin", this.aq);
/* 302 */     arrayOfNameValuePair[7] = (NameValuePair)new BasicNameValuePair("menorlance", this.ar);
/* 303 */     arrayOfNameValuePair[8] = (NameValuePair)new BasicNameValuePair("formajulg", this.as);
/* 304 */     arrayOfNameValuePair[9] = (NameValuePair)new BasicNameValuePair("fatorEqualiz", this.ao);
/* 305 */     arrayOfNameValuePair[10] = (NameValuePair)new BasicNameValuePair("acaoLance", "ENVIAR");
/* 306 */     return arrayOfNameValuePair;
/*     */   }
/*     */   
/*     */   protected void bv() {
/* 310 */     a a = new a(this.e);
/* 311 */     String str = a.A();
/* 312 */     if (!"".equals(str)) {
/* 313 */       this.ap = str;
/*     */     }
/*     */     
/* 316 */     str = a.B();
/* 317 */     if (!"".equals(str)) {
/* 318 */       this.aq = str;
/*     */     } else {
/* 320 */       this.aq = String.valueOf(a().f().m());
/*     */     } 
/*     */     
/* 323 */     str = a.C();
/* 324 */     if (!"".equals(str)) {
/* 325 */       this.ar = str;
/*     */     } else {
/* 327 */       this.ar = String.valueOf(a().f());
/*     */     } 
/*     */     
/* 330 */     str = a.D();
/* 331 */     if (!"".equals(str)) {
/* 332 */       this.as = str;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/*     */     try {
/* 345 */       if (this.a.a() != null) {
/* 346 */         if (!this.a.a().isRunning()) {
/* 347 */           this.a.a().z();
/*     */         }
/*     */         
/* 350 */         return this.a.a(this);
/*     */       } 
/* 352 */     } catch (d d) {
/* 353 */       throw d;
/* 354 */     } catch (c c1) {
/* 355 */       this.a.a().b();
/* 356 */       a.info(String.join("", new CharSequence[] { "{} - ", c1.getMessage() }), a().bo());
/* 357 */     } catch (Exception exception) {
/* 358 */       a.error(String.join(" - ", new CharSequence[] { "#032", a().bo() }), exception);
/*     */       
/* 360 */       if (a() != null) {
/* 361 */         a().h("#032 - " + a().bo());
/*     */       }
/*     */     } 
/*     */     
/* 365 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 374 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 377 */       List<h> list = e();
/* 378 */       long l1 = n.a().longValue();
/* 379 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 381 */       int i = (int)list.stream().filter(paramh -> (paramh.b().getTime() > paramLong)).count();
/*     */       
/* 383 */       arrayOfInt[0] = i;
/* 384 */       arrayOfInt[1] = list.size() - i;
/* 385 */     } catch (Exception exception) {
/* 386 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 387 */       a().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 390 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void b(Date paramDate) {
/*     */     try {
/* 401 */       long l1 = n.a().longValue();
/* 402 */       long l2 = paramDate.getTime() + TimeUnit.SECONDS.toMillis(3L);
/*     */       
/* 404 */       if (l1 < l2) {
/* 405 */         long l = l2 - l1;
/* 406 */         Thread.sleep(l);
/*     */       } 
/* 408 */     } catch (Exception exception) {
/* 409 */       a.error("Erro ao esperar envio de lance", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 415 */     return (c)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 420 */     return (f)super.b();
/*     */   }
/*     */   
/*     */   public DecimalFormat a() {
/* 424 */     return this.decimalFormat;
/*     */   }
/*     */   
/*     */   protected String G() {
/* 428 */     return a().G();
/*     */   }
/*     */   
/*     */   protected Element a() {
/* 432 */     return this.e;
/*     */   }
/*     */   
/*     */   public void i(Element paramElement) {
/* 436 */     this.e = paramElement;
/*     */   }
/*     */   
/*     */   protected c a() {
/* 440 */     return (c)this.a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */