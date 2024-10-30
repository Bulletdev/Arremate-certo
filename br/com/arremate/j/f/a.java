/*     */ package br.com.arremate.j.f;
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
/*     */ public class a
/*     */   extends i
/*     */ {
/*  30 */   private static final af d = af.a(4.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://forward.portal-services.effecti.com.br/bnc/";
/*     */   private static final String ch = "https://forward.portal-services.effecti.com.br/bnc";
/*  34 */   private static final String ci = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bnc/", "Home/" });
/*  35 */   private static final String aZ = String.join("", new CharSequence[] { ci, "Login" });
/*  36 */   private static final String cj = String.join("", new CharSequence[] { ci, "Logout" });
/*  37 */   private static final String ck = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bnc/", "Proposal/" });
/*  38 */   private static final String cl = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bnc/", "Process/" });
/*  39 */   private static final String cm = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bnc/", "BatchList/" });
/*  40 */   private static final String cn = String.join("", new CharSequence[] { "https://forward.portal-services.effecti.com.br/bnc/", "Participant/GetProcessByParams" });
/*     */ 
/*     */   
/*     */   public a(d paramd) {
/*  44 */     a(paramd);
/*     */     
/*  46 */     a(g.c()
/*  47 */         .b(30000).d(10).e(100).a(d)
/*  48 */         .a(500)
/*  49 */         .a(404)
/*  50 */         .a(302)
/*  51 */         .a(StandardCharsets.UTF_8)
/*  52 */         .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0.0.0 Safari/537.36")
/*  53 */         .a("Authorization", "Bearer " + c.a().f())
/*  54 */         .a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  59 */     c().bB();
/*     */     
/*     */     try {
/*  62 */       String str1 = aD();
/*  63 */       if (str1.isEmpty()) {
/*  64 */         return 0;
/*     */       }
/*     */       
/*  67 */       ArrayList arrayList = new ArrayList();
/*  68 */       Document document = Jsoup.parse(str1);
/*     */       
/*  70 */       Element element = document.select("table > tbody").first();
/*  71 */       Elements elements1 = element.select("input");
/*  72 */       elements1.forEach(paramElement -> paramList.add(y.V(paramElement.attr("value"))));
/*     */ 
/*     */ 
/*     */       
/*  76 */       d d = a();
/*  77 */       String str2 = d.getUser();
/*  78 */       StringBuilder stringBuilder = new StringBuilder();
/*     */       
/*  80 */       String[] arrayOfString = d.getPassword().split("");
/*  81 */       for (String str : arrayOfString) {
/*  82 */         Optional<String> optional1 = arrayList.stream().filter(paramString2 -> paramString2.contains(paramString1)).findFirst();
/*  83 */         if (optional1.isPresent()) {
/*  84 */           stringBuilder.append(((String)optional1.get()).replaceAll("0", "*"));
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/*  89 */       e e = f(str2, stringBuilder.toString());
/*  90 */       str1 = e.getData();
/*  91 */       if (str1.isEmpty()) {
/*  92 */         return 0;
/*     */       }
/*     */       
/*  95 */       if (str1.contains("Captcha inv&#225;lido") || str1.contains("Erro na valida&#231;&#227;o do captcha")) {
/*  96 */         setMessage("Falha ao quebrar reCaptcha pra realizar o login no portal!");
/*  97 */         return 0;
/*     */       } 
/*     */ 
/*     */       
/* 101 */       i i1 = new i(str1);
/* 102 */       if (i1.has("html")) {
/* 103 */         document = Jsoup.parse(i1.getString("html"));
/* 104 */         if (document.html().contains("Senha incorreta") || document.html().contains("Usuário ou senha incorretos")) {
/* 105 */           return 2;
/*     */         }
/*     */ 
/*     */         
/* 109 */         Elements elements4 = document.select("table[class*=table table-hover] > tbody > tr");
/* 110 */         elements4.remove(0);
/*     */         
/* 112 */         String str7 = d.bz().trim().toLowerCase();
/* 113 */         Optional<Element> optional1 = elements4.stream().filter(paramElement -> paramElement.select("td").get(0).text().trim().toLowerCase().equals(paramString)).findFirst();
/* 114 */         if (!optional1.isPresent()) {
/* 115 */           setMessage("O perfil informado não existe!");
/* 116 */           return 2;
/*     */         } 
/*     */         
/* 119 */         Elements elements5 = ((Element)optional1.get()).select("td");
/* 120 */         String str8 = elements5.get(2).select("[class*=btn btn-primary]").attr("href");
/* 121 */         str1 = u(str8).getData();
/*     */       } 
/*     */       
/* 124 */       if (str1.isEmpty()) {
/* 125 */         return 0;
/*     */       }
/*     */       
/* 128 */       if (str1.contains("\"modal\":\"error\"")) {
/* 129 */         i1 = new i(str1);
/* 130 */         document = Jsoup.parse(i1.getString("html"));
/* 131 */         String str = document.select("div.modal-body").first().html();
/* 132 */         str = str.substring(0, str.indexOf("<br>")).trim();
/* 133 */         str = String.join("\n\n", new CharSequence[] { "Mensagem de retorno do portal:", str });
/* 134 */         setMessage(str);
/* 135 */         return 0;
/*     */       } 
/*     */       
/* 138 */       str1 = j().getData();
/* 139 */       if (str1.isEmpty()) {
/* 140 */         return 0;
/*     */       }
/*     */       
/* 143 */       i1 = new i(str1);
/* 144 */       document = Jsoup.parse(i1.getString("html"));
/* 145 */       Elements elements2 = document.select("table[class*=table table-hover] > tbody > tr");
/* 146 */       elements2.remove(0);
/*     */       
/* 148 */       String str3 = d.bz().trim().toLowerCase();
/*     */       
/* 150 */       Optional<Element> optional = elements2.stream().filter(paramElement -> paramElement.select("td").get(1).select("input").first().attr("value").toLowerCase().contains(paramString)).findFirst();
/* 151 */       if (!optional.isPresent()) {
/* 152 */         setMessage("Falha ao carregar os dados cadastrais da empresa!");
/* 153 */         return 0;
/*     */       } 
/*     */       
/* 156 */       Elements elements3 = ((Element)optional.get()).select("td");
/* 157 */       String str4 = elements3.get(3).text();
/* 158 */       String str5 = str4.substring(0, str4.indexOf("(")).trim();
/* 159 */       String str6 = y.V(str4.substring(str4.indexOf("(")));
/*     */       
/* 161 */       d.aa(str5);
/* 162 */       d.v(Long.parseLong(str6));
/*     */       
/* 164 */       if (!ae()) {
/* 165 */         cb();
/* 166 */         setRunning(true);
/*     */       } 
/*     */       
/* 169 */       return 1;
/* 170 */     } catch (Exception exception) {
/* 171 */       a.warn("Falha ao realizar login no BNC", exception);
/*     */ 
/*     */       
/* 174 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   private String aD() {
/* 179 */     return c(
/* 180 */         g.c().a(aZ).b())
/* 181 */       .getData();
/*     */   }
/*     */   
/*     */   private e f(String paramString1, String paramString2) throws g {
/* 185 */     return c(
/* 186 */         g.d().a(aZ)
/* 187 */         .a("email", paramString1)
/* 188 */         .a("password", paramString2)
/* 189 */         .a("RememberMe", "false")
/* 190 */         .a("token", "")
/* 191 */         .b());
/*     */   }
/*     */ 
/*     */   
/*     */   private e u(String paramString) {
/* 196 */     return c(
/* 197 */         g.d().a("https://forward.portal-services.effecti.com.br/bnc").a(paramString).b());
/*     */   }
/*     */ 
/*     */   
/*     */   private e j() {
/* 202 */     return c(
/* 203 */         g.c().a(ci).a("ShowProfiles").b());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e k() {
/* 211 */     return b(
/* 212 */         g.c().a(ck).a("ProposalSearch"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e v(String paramString) {
/* 217 */     return b(
/* 218 */         g.c().a(cl).a("ProcessView").a("param1", paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e w(String paramString) {
/* 223 */     return b(
/* 224 */         g.c().a(ck).a("Proposal").a("param1", paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e b(String paramString1, String paramString2, String paramString3) {
/* 230 */     return b(
/* 231 */         g.d().a(cn)
/* 232 */         .a("Organization", paramString1).a("Number", paramString2).a("City", "").a("fkState", "")
/* 233 */         .a("fkModality", paramString3).a("fkStatus", "").a("fkDisputeKind", "").a("DateStart", "")
/* 234 */         .a("DateEnd", "").a("DateStartDispute", "").a("DateEndDispute", "").a("Offset", 0)
/* 235 */         .a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e x(String paramString) {
/* 240 */     return b(
/* 241 */         g.d().a(cl).a("ProcessBatches")
/* 242 */         .a("param1", paramString).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(String paramString1, String paramString2, String paramString3, String paramString4) {
/* 247 */     return b(
/* 248 */         g.d().a(ck).a("GetProposalsByParams")
/* 249 */         .a("Organization", paramString1).a("Number", paramString2).a("City", paramString3).a("fkModality", paramString4)
/* 250 */         .a("fkStatus", "").a("creationStart", "").a("creationEnd", "").a("token", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e g(String paramString1, String paramString2) {
/* 258 */     return b(
/* 259 */         g.c().a(cm).a("PartialUnique/")
/* 260 */         .a("idProcess", paramString1)
/* 261 */         .a("idStatus", 1)
/* 262 */         .a("startingNumber", paramString2)
/* 263 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e h(String paramString1, String paramString2) {
/* 268 */     return b(
/* 269 */         g.d().a(cl).a("ProcessBatchItems")
/* 270 */         .a("param1", paramString1)
/* 271 */         .a("param2", paramString2)
/* 272 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e i(String paramString1, String paramString2) {
/* 277 */     return b(
/* 278 */         g.d().a("https://forward.portal-services.effecti.com.br/bnc/").a("BatchListParticipant/PerformBidClosed")
/* 279 */         .a("idBatch", paramString1)
/* 280 */         .a("value", paramString2)
/* 281 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e j(String paramString1, String paramString2) {
/* 287 */     return b(
/* 288 */         g.c().a("https://forward.portal-services.effecti.com.br/bnc/").a("BatchListParticipant/BidAndInfo/")
/* 289 */         .a("param1", paramString1).a("param2", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e k(String paramString1, String paramString2) {
/* 294 */     return b(
/* 295 */         g.d().a("https://forward.portal-services.effecti.com.br/bnc/").a("BatchListParticipant/PerformBid")
/* 296 */         .a("batchId", paramString1).a("value", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e y(String paramString) {
/* 304 */     return l(paramString, "");
/*     */   }
/*     */   
/*     */   public e l(String paramString1, String paramString2) {
/* 308 */     return b(
/* 309 */         g.e().a(cm).a("GetMsgCountDetailedView")
/* 310 */         .a((new i()).c("param1", paramString1).c("param2", paramString2))
/* 311 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public e z(String paramString) {
/* 317 */     return b(
/* 318 */         g.d().a(cm).a("GetProcessAlert")
/* 319 */         .a("param1", paramString).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public e m(String paramString1, String paramString2) {
/* 324 */     return b(
/* 325 */         g.d().a(cm).a("GetProcessAlertList")
/* 326 */         .a("param1", paramString1).a("param2", paramString2).a("token", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(g paramg) {
/* 331 */     b(paramg);
/* 332 */     a(g.a(this, c(), parame -> g(parame)));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean g(e parame) {
/* 340 */     String str = parame.getData().toLowerCase();
/* 341 */     if (str.contains("\"modal\":\"error\"")) {
/* 342 */       return (str.contains("object reference not set to an instance of an object") || str
/* 343 */         .contains("the given key was not present in the dictionary") || str
/* 344 */         .contains("você não está autenticado. faça o login novamente.") || str
/* 345 */         .contains("houve um erro inesperado"));
/*     */     }
/*     */     
/* 348 */     return parame.R().equals("IndexOutOfBoundsException");
/*     */   }
/*     */   
/*     */   private e b(f paramf) {
/* 352 */     return a(paramf, false);
/*     */   }
/*     */   
/*     */   private e c(f paramf) {
/* 356 */     return a(paramf, true);
/*     */   }
/*     */   
/*     */   private e a(f paramf, boolean paramBoolean) {
/* 360 */     e e = c().a(paramf.a());
/* 361 */     if (e.getStatusCode() != 302) {
/* 362 */       return e;
/*     */     }
/*     */     
/* 365 */     long l = e.k();
/* 366 */     for (Header header : e.a()) {
/* 367 */       if (header.getName().equals("Location")) {
/* 368 */         paramf = g.c().a("https://forward.portal-services.effecti.com.br/bnc/").a(header.getValue());
/* 369 */         if (paramBoolean) {
/* 370 */           paramf.b();
/*     */         }
/*     */         
/* 373 */         e = a(paramf, paramBoolean);
/*     */         
/* 375 */         l += e.k();
/* 376 */         e.q(l);
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 381 */     return e;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 386 */     bI();
/* 387 */     super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   private void bI() {
/* 392 */     b(g.c().a(cj));
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
/*     */   public boolean T() {
/* 412 */     return A.a().p("https://bnccompras.com/Home/Login");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 417 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 422 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\f\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */