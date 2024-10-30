/*     */ package br.com.arremate.j.e;
/*     */ 
/*     */ import br.com.arremate.a.a.c;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.f;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Optional;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.NameValuePair;
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
/*     */ public class a
/*     */   extends i
/*     */ {
/*  34 */   private static final af d = af.a(4.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://forward.portal-services.effecti.com.br/bll/";
/*     */   private static final String ch = "https://forward.portal-services.effecti.com.br/bll";
/*  38 */   private static final String ci = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bll/", "Home/" });
/*  39 */   private static final String aZ = String.join("", new CharSequence[] { ci, "Login" });
/*  40 */   private static final String cj = String.join("", new CharSequence[] { ci, "Logout" });
/*  41 */   private static final String ck = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bll/", "Proposal/" });
/*  42 */   private static final String cl = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bll/", "Process/" });
/*  43 */   private static final String cm = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bll/", "BatchList/" });
/*  44 */   private static final String cn = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bll/", "Participant/GetProcessByParams" });
/*     */ 
/*     */   
/*     */   public a(d paramd) {
/*  48 */     a(paramd);
/*     */     
/*  50 */     a(g.c()
/*  51 */         .b(30000).d(10).e(100).a(d)
/*  52 */         .a(500)
/*  53 */         .a(404)
/*  54 */         .a(302)
/*  55 */         .a(StandardCharsets.UTF_8)
/*  56 */         .a("User-Agent", "Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:124.0) Gecko/20100101 Firefox/124.0")
/*  57 */         .a("Authorization", "Bearer " + c.a().f())
/*  58 */         .a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  63 */     c().bB();
/*     */     
/*     */     try {
/*  66 */       String str1 = aD();
/*  67 */       if (str1.isEmpty()) {
/*  68 */         return 0;
/*     */       }
/*     */       
/*  71 */       ArrayList arrayList = new ArrayList();
/*  72 */       Document document = Jsoup.parse(str1);
/*     */       
/*  74 */       Element element = document.select("table > tbody").first();
/*  75 */       Elements elements1 = element.select("input");
/*  76 */       elements1.forEach(paramElement -> paramList.add(y.V(paramElement.attr("value"))));
/*     */ 
/*     */ 
/*     */       
/*  80 */       d d = a();
/*  81 */       String str2 = d.getUser();
/*  82 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*  84 */       String[] arrayOfString = d.getPassword().split("");
/*  85 */       for (String str : arrayOfString) {
/*  86 */         Optional<String> optional1 = arrayList.stream().filter(paramString2 -> paramString2.contains(paramString1)).findFirst();
/*  87 */         if (optional1.isPresent()) {
/*  88 */           stringBuilder.append(((String)optional1.get()).replaceAll("0", "*"));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  93 */       e e = f(str2, stringBuilder.toString());
/*  94 */       str1 = e.getData();
/*  95 */       if (str1.isEmpty()) {
/*  96 */         return 0;
/*     */       }
/*     */       
/*  99 */       if (str1.contains("Captcha inv&#225;lido") || str1.contains("Erro na valida&#231;&#227;o do captcha")) {
/* 100 */         setMessage("Falha ao quebrar reCaptcha pra realizar o login no portal!");
/* 101 */         return 0;
/*     */       } 
/*     */ 
/*     */       
/* 105 */       i i1 = new i(str1);
/* 106 */       if (i1.has("html")) {
/* 107 */         document = Jsoup.parse(i1.getString("html"));
/* 108 */         if (document.html().contains("Senha incorreta") || document.html().contains("Usuário ou senha incorretos")) {
/* 109 */           return 2;
/*     */         }
/*     */ 
/*     */         
/* 113 */         Elements elements4 = document.select("table[class*=table table-hover] > tbody > tr");
/* 114 */         elements4.remove(0);
/*     */         
/* 116 */         String str7 = d.bz().trim().toLowerCase();
/* 117 */         Optional<Element> optional1 = elements4.stream().filter(paramElement -> paramElement.select("td").get(0).text().trim().toLowerCase().equals(paramString)).findFirst();
/* 118 */         if (!optional1.isPresent()) {
/* 119 */           setMessage("O perfil informado não existe!");
/* 120 */           return 2;
/*     */         } 
/*     */         
/* 123 */         Elements elements5 = ((Element)optional1.get()).select("td");
/* 124 */         String str8 = elements5.get(2).select("[class*=btn btn-primary]").attr("href");
/* 125 */         str1 = u(str8).getData();
/*     */       } 
/*     */       
/* 128 */       if (str1.isEmpty()) {
/* 129 */         return 0;
/*     */       }
/*     */       
/* 132 */       if (str1.contains("\"modal\":\"error\"")) {
/* 133 */         i1 = new i(str1);
/* 134 */         document = Jsoup.parse(i1.getString("html"));
/* 135 */         String str = document.select("div.modal-body").first().html();
/* 136 */         str = str.substring(0, str.indexOf("<br>")).trim();
/* 137 */         str = String.join("\n\n", new CharSequence[] { "Mensagem de retorno do portal:", str });
/* 138 */         setMessage(str);
/* 139 */         return 0;
/*     */       } 
/*     */       
/* 142 */       str1 = j().getData();
/* 143 */       if (str1.isEmpty()) {
/* 144 */         return 0;
/*     */       }
/*     */       
/* 147 */       i1 = new i(str1);
/* 148 */       document = Jsoup.parse(i1.getString("html"));
/* 149 */       Elements elements2 = document.select("table[class*=table table-hover] > tbody > tr");
/* 150 */       elements2.remove(0);
/*     */       
/* 152 */       String str3 = d.bz().trim().toLowerCase();
/*     */       
/* 154 */       Optional<Element> optional = elements2.stream().filter(paramElement -> paramElement.select("td").get(1).select("input").first().attr("value").toLowerCase().contains(paramString)).findFirst();
/* 155 */       if (!optional.isPresent()) {
/* 156 */         setMessage("Falha ao carregar os dados cadastrais da empresa!");
/* 157 */         return 0;
/*     */       } 
/*     */       
/* 160 */       Elements elements3 = ((Element)optional.get()).select("td");
/* 161 */       String str4 = elements3.get(3).text();
/* 162 */       String str5 = str4.substring(0, str4.indexOf("(")).trim();
/* 163 */       String str6 = y.V(str4.substring(str4.indexOf("(")));
/*     */       
/* 165 */       d.aa(str5);
/* 166 */       d.v(Long.parseLong(str6));
/*     */       
/* 168 */       if (!ae()) {
/* 169 */         cb();
/* 170 */         setRunning(true);
/*     */       } 
/*     */       
/* 173 */       return 1;
/* 174 */     } catch (Exception exception) {
/* 175 */       a.warn("Falha ao realizar login no BLL", exception);
/*     */ 
/*     */       
/* 178 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String aD() {
/* 183 */     return c(
/* 184 */         g.c().a(aZ).b())
/* 185 */       .getData();
/*     */   }
/*     */   
/*     */   private e f(String paramString1, String paramString2) throws g {
/* 189 */     return c(
/* 190 */         g.d().a(aZ)
/* 191 */         .a("email", paramString1)
/* 192 */         .a("password", paramString2)
/* 193 */         .a("RememberMe", "false")
/* 194 */         .a("token", "")
/* 195 */         .b());
/*     */   }
/*     */ 
/*     */   
/*     */   private e u(String paramString) {
/* 200 */     return c(
/* 201 */         g.d().a("https://forward.portal-services.effecti.com.br/bll").a(paramString).b());
/*     */   }
/*     */ 
/*     */   
/*     */   private e j() {
/* 206 */     return c(
/* 207 */         g.c().a(ci).a("ShowProfiles").b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e k() {
/* 215 */     return b(
/* 216 */         g.c().a(ck).a("ProposalSearch"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e v(String paramString) {
/* 221 */     return b(
/* 222 */         g.c().a(cl).a("ProcessView").a("param1", paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e w(String paramString) {
/* 227 */     return b(
/* 228 */         g.c().a(ck).a("Proposal").a("param1", paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e b(String paramString1, String paramString2, String paramString3) {
/* 234 */     return b(
/* 235 */         g.d().a(cn)
/* 236 */         .a("Organization", paramString1).a("Number", paramString2).a("City", "").a("fkState", "")
/* 237 */         .a("fkModality", paramString3).a("fkStatus", "").a("fkDisputeKind", "").a("DateStart", "")
/* 238 */         .a("DateEnd", "").a("DateStartDispute", "").a("DateEndDispute", "").a("Offset", 0)
/* 239 */         .a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e x(String paramString) {
/* 244 */     return b(
/* 245 */         g.d().a(cl).a("ProcessBatches")
/* 246 */         .a("param1", paramString).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 251 */     return b(
/* 252 */         g.d().a(ck).a("GetProposalsByParams")
/* 253 */         .a("Organization", paramString1).a("Number", paramString2).a("City", paramString3).a("fkModality", paramString4)
/* 254 */         .a("fkStatus", "").a("creationStart", "").a("creationEnd", "").a("token", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e g(String paramString1, String paramString2) {
/* 262 */     return b(
/* 263 */         g.c().a(cm).a("PartialUnique/")
/* 264 */         .a("idProcess", paramString1)
/* 265 */         .a("idStatus", 1)
/* 266 */         .a("startingNumber", paramString2)
/* 267 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e h(String paramString1, String paramString2) {
/* 272 */     return b(
/* 273 */         g.d().a(cl).a("ProcessBatchItems")
/* 274 */         .a("param1", paramString1)
/* 275 */         .a("param2", paramString2)
/* 276 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e i(String paramString1, String paramString2) {
/* 281 */     return b(
/* 282 */         g.d().a("https://forward.portal-services.effecti.com.br/bll/").a("BatchListParticipant/PerformBidClosed")
/* 283 */         .a("idBatch", paramString1)
/* 284 */         .a("value", paramString2)
/* 285 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e j(String paramString1, String paramString2) {
/* 291 */     return b(
/* 292 */         g.c().a("https://forward.portal-services.effecti.com.br/bll/").a("BatchListParticipant/BidAndInfo/")
/* 293 */         .a("param1", paramString1).a("param2", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e k(String paramString1, String paramString2) {
/* 298 */     return b(
/* 299 */         g.d().a("https://forward.portal-services.effecti.com.br/bll/").a("BatchListParticipant/PerformBid")
/* 300 */         .a("batchId", paramString1).a("value", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e y(String paramString) {
/* 308 */     return l(paramString, "");
/*     */   }
/*     */   
/*     */   public e l(String paramString1, String paramString2) {
/* 312 */     return b(
/* 313 */         g.e().a(cm).a("GetMsgCountDetailedView")
/* 314 */         .a((new i()).c("param1", paramString1).c("param2", paramString2))
/* 315 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e z(String paramString) {
/* 321 */     return b(
/* 322 */         g.d().a(cm).a("GetProcessAlert")
/* 323 */         .a("param1", paramString).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e m(String paramString1, String paramString2) {
/* 328 */     return b(
/* 329 */         g.d().a(cm).a("GetProcessAlertList")
/* 330 */         .a("param1", paramString1).a("param2", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/* 335 */     b(paramg);
/* 336 */     a(g.a(this, c(), parame -> g(parame)));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g(e parame) {
/* 342 */     String str = parame.getData().toLowerCase();
/* 343 */     if (str.contains("\"modal\":\"error\"")) {
/* 344 */       return (str.contains("object reference not set to an instance of an object") || str
/* 345 */         .contains("the given key was not present in the dictionary") || str
/* 346 */         .contains("você não está autenticado. faça o login novamente.") || str
/* 347 */         .contains("houve um erro inesperado"));
/*     */     }
/*     */     
/* 350 */     return parame.R().equals("IndexOutOfBoundsException");
/*     */   }
/*     */   
/*     */   private e b(f paramf) {
/* 354 */     return a(paramf, false);
/*     */   }
/*     */   
/*     */   private e c(f paramf) {
/* 358 */     return a(paramf, true);
/*     */   }
/*     */   
/*     */   private e a(f paramf, boolean paramBoolean) {
/* 362 */     e e = c().a(paramf.a());
/* 363 */     if (e.getStatusCode() != 302) {
/* 364 */       return e;
/*     */     }
/*     */     
/* 367 */     long l = e.k();
/* 368 */     for (Header header : e.a()) {
/* 369 */       if (header.getName().equals("Location")) {
/* 370 */         paramf = g.c().a("https://forward.portal-services.effecti.com.br/bll/").a(header.getValue());
/* 371 */         if (paramBoolean) {
/* 372 */           paramf.b();
/*     */         }
/*     */         
/* 375 */         e = a(paramf, paramBoolean);
/*     */         
/* 377 */         l += e.k();
/* 378 */         e.q(l);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 383 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 388 */     bI();
/* 389 */     super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   private void bI() {
/* 394 */     b(g.c().a(cj));
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 415 */     return A.a().p("https://bllcompras.com/Home/Login");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 420 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 425 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */