/*     */ package br.com.arremate.h;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.l.p.j;
/*     */ import java.util.List;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   implements b
/*     */ {
/*  22 */   protected static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private final b b;
/*     */   
/*     */   a(b paramb) {
/*  27 */     this.b = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(f paramf) {
/*  32 */     e e = this.b.a(paramf);
/*  33 */     byte b1 = 0;
/*     */     
/*  35 */     while (b1++ < 3 && c(e)) {
/*  36 */       a(paramf.getUrl(), e);
/*  37 */       e = this.b.a(paramf);
/*     */       
/*  39 */       boolean bool = (e.getStatusCode() != 405) ? true : false;
/*  40 */       j.a().a(bool, o.d, paramf.getUrl(), b1);
/*     */     } 
/*     */     
/*  43 */     if (e.getStatusCode() == 405) {
/*  44 */       a.warn("Failed to break captcha for URL {}", paramf.getUrl());
/*     */     }
/*     */     
/*  47 */     return e;
/*     */   }
/*     */   
/*     */   private boolean c(e parame) {
/*  51 */     String str = parame.getData().toLowerCase();
/*  52 */     return (str.contains("vamos confirmar que você é humano") || str.contains("human verification") || str
/*  53 */       .contains("gokuProps") || parame.getStatusCode() == 405);
/*     */   }
/*     */   
/*     */   private void a(String paramString, e parame) {
/*     */     try {
/*  58 */       br.com.arremate.l.a a1 = a(parame);
/*  59 */       a1.M(paramString);
/*     */       
/*  61 */       j j = j.a();
/*  62 */       br.com.arremate.a.a.a a2 = j.a(a1);
/*     */       
/*  64 */       if (a2 == null) {
/*     */         return;
/*     */       }
/*     */       
/*  68 */       f f = a(a2, a1);
/*  69 */       e e1 = this.b.a(f);
/*     */       
/*  71 */       if (e1 == null || e1.getStatusCode() != 200) {
/*  72 */         j.c(a2.getId());
/*     */       }
/*  74 */     } catch (Exception exception) {
/*  75 */       a.warn("Exception while solving Amazon Captcha", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private br.com.arremate.l.a a(e parame) {
/*  80 */     Document document = Jsoup.parse(parame.getData());
/*  81 */     Elements elements = document.select("script");
/*  82 */     br.com.arremate.l.a a1 = new br.com.arremate.l.a();
/*     */     
/*  84 */     for (Element element : elements) {
/*  85 */       if (element.html().contains("gokuProps")) {
/*  86 */         String str1 = "window.gokuProps = ";
/*  87 */         String str2 = element.html().substring(element.html().indexOf(str1) + str1.length());
/*  88 */         str2 = str2.substring(0, str2.length() - 1);
/*     */         
/*  90 */         i i = new i(str2);
/*  91 */         a1.H(i.getString("key"));
/*  92 */         a1.I(i.getString("iv"));
/*  93 */         a1.J(i.getString("context")); continue;
/*  94 */       }  if (element.hasAttr("src")) {
/*  95 */         String str = element.attr("src");
/*     */         
/*  97 */         if (str.contains("challenge.js")) {
/*  98 */           a1.K(str); continue;
/*  99 */         }  if (str.contains("captcha.js")) {
/* 100 */           a1.L(str);
/*     */         }
/*     */       } 
/*     */     } 
/* 104 */     return a1;
/*     */   }
/*     */   
/*     */   private f a(br.com.arremate.a.a.a parama, br.com.arremate.l.a parama1) {
/* 108 */     i i1 = new i(parama.a());
/* 109 */     String str1 = i1.getString("captcha_voucher");
/* 110 */     String str2 = i1.getString("existing_token");
/* 111 */     String str3 = parama1.bc().replace("challenge.js", "voucher");
/*     */ 
/*     */ 
/*     */     
/* 115 */     i i2 = (new i()).c("captcha_voucher", str1).c("existing_token", str2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 120 */     return g.e().a(str3).a(i2).b();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void b() {
/* 126 */     this.b.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Cookie> getCookies() {
/* 131 */     return this.b.getCookies();
/*     */   }
/*     */ 
/*     */   
/*     */   public String P() {
/* 136 */     return this.b.P();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bB() {
/* 141 */     this.b.bB();
/*     */   }
/*     */ 
/*     */   
/*     */   public void addCookie(Cookie paramCookie) {
/* 146 */     this.b.addCookie(paramCookie);
/*     */   }
/*     */ 
/*     */   
/*     */   public void bC() {
/* 151 */     this.b.bC();
/*     */   }
/*     */ 
/*     */   
/*     */   public void bD() {
/* 156 */     this.b.bD();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */