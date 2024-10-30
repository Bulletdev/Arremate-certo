/*     */ package br.com.arremate.j.a;
/*     */ 
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class a
/*     */   extends i
/*     */ {
/*  31 */   private static final af d = af.a(5.0D);
/*     */   
/*     */   public static final int ar = 60000;
/*     */   private static final String DOMAIN = "https://www.bec.sp.gov.br/";
/*  35 */   private static final String aO = String.join("", new CharSequence[] { "https://www.bec.sp.gov.br/", "fornecedor_ui/LoginFornecedor.aspx?chave=" });
/*     */   
/*     */   private String aP;
/*     */   
/*  39 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*     */   public a(d paramd, boolean paramBoolean) {
/*  42 */     a(paramd);
/*     */     
/*  44 */     if (paramBoolean) {
/*  45 */       a(b());
/*     */     } else {
/*  47 */       bH();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bH() {
/*  52 */     a(g.a(this, b(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */             return str.contains("Sua sessão expirou, favor logar-se novamente.");
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private b b() {
/*  61 */     return g.c()
/*  62 */       .b(60000)
/*  63 */       .d(25).e(200)
/*  64 */       .a((af)d)
/*  65 */       .a(302)
/*  66 */       .a("Host", "www.bec.sp.gov.br")
/*  67 */       .a("sec-ch-ua", "\"Google Chrome\";v=\"95\", \"Chromium\";v=\"95\", \";Not A Brand\";v=\"99\"")
/*  68 */       .a("sec-ch-ua-mobile", "?0")
/*  69 */       .a("sec-ch-ua-platform", "\"Windows\"")
/*  70 */       .a("Sec-Fetch-Mode", "navigate")
/*  71 */       .a("Sec-Fetch-Site", "same-origin")
/*  72 */       .a("Sec-Fetch-User", "?1")
/*  73 */       .a("Upgrade-Insecure-Requests", "1")
/*  74 */       .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/100.0.4896.88 Safari/537.36")
/*  75 */       .a();
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*     */     try {
/*  81 */       c().bB();
/*  82 */       setMessage(null);
/*     */       
/*  84 */       String str1 = c().a(g.c().a(aO).b()).getData();
/*  85 */       if (str1.isEmpty()) {
/*  86 */         return 0;
/*     */       }
/*     */       
/*  89 */       Document document = Jsoup.parse(str1);
/*  90 */       String str2 = document.select("input[id=__VIEWSTATE]").first().val();
/*  91 */       String str3 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/*     */       
/*  93 */       byte b = 0;
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
/*     */       do {
/* 109 */         str1 = c().a(g.d().a(aO).a("__EVENTTARGET", "Btn_Confirmar").a("__EVENTARGUMENT", "").a("__VIEWSTATE", str2).a("__VIEWSTATEGENERATOR", str3).a("TextLogin", getUser()).a("TextSenha", getPassword()).a("hdnRecaptchaToken", "").a("chkAceite", "on").a("tb_Parametros", "||1920,1080||Chrome|Windows 95|").b()).getData().toLowerCase();
/* 110 */         if (!str1.contains("termoresponsabilidade.aspx")) {
/*     */           break;
/*     */         }
/*     */ 
/*     */         
/* 115 */         ++b;
/* 116 */       } while (b < 15);
/*     */       
/* 118 */       if (b == 15)
/*     */       {
/* 120 */         return 0;
/*     */       }
/*     */       
/* 123 */       if (str1.isEmpty() || str1.contains("assinale a declaração ao lado")) {
/* 124 */         return 0;
/*     */       }
/*     */       
/* 127 */       if (str1.contains("usuário não cadastrado neste módulo") || str1.contains("senha não confere")) {
/* 128 */         return 2;
/*     */       }
/*     */       
/* 131 */       document = Jsoup.parse(str1);
/* 132 */       Element element = document.select("form[id=aspnetform]").first();
/* 133 */       if (element != null) {
/* 134 */         String str4 = element.attr("action");
/* 135 */         int j = str4.indexOf("chave=");
/* 136 */         this.aP = str4.substring(j + 6);
/*     */         
/* 138 */         String str5 = String.valueOf(a().y());
/* 139 */         str5 = StringUtils.leftPad(str5, 11, "0");
/* 140 */         List<String> list = v();
/* 141 */         if (!list.contains(str5)) {
/* 142 */           setMessage("Não foi possível realizar o login. O CPF não está cadastrado ou não está credenciado no Portal.");
/* 143 */           return 0;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 148 */         str1 = c().a(g.c().a("https://www.bec.sp.gov.br/").a("fornecedor_ui2/AspX/Fornecedor_Home.aspx?chave=").a(this.aP).b()).getData();
/* 149 */         if (str1.isEmpty()) {
/* 150 */           return 0;
/*     */         }
/*     */         
/* 153 */         document = Jsoup.parse(str1);
/* 154 */         Element element1 = document.select("span[id=ctl00_ContentPlaceHolder1_lblCnpj]").first();
/* 155 */         Element element2 = document.select("span[id=ctl00_ContentPlaceHolder1_lblRazao]").first();
/* 156 */         D(element1.text());
/* 157 */         E(element2.text());
/* 158 */         setRunning(!ae());
/*     */         
/* 160 */         return 1;
/*     */       } 
/* 162 */     } catch (Exception exception) {
/* 163 */       a.warn("Falha ao realizar login na BEC", exception);
/*     */     } 
/*     */     
/* 166 */     return 0;
/*     */   }
/*     */   
/*     */   private List<String> v() {
/* 170 */     ArrayList<String> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */     
/* 174 */     String str = c().a(g.c().a("https://www.bec.sp.gov.br/").a("fornecedor_ui/Console/Console_Ficha.aspx?chave=").a(this.aP).b()).getData();
/* 175 */     if (!str.isEmpty()) {
/* 176 */       Document document = Jsoup.parse(str);
/* 177 */       String str1 = document.select("span#ctl00_ContentPlaceHolder1_WUC_Console_FichaFornecedor1_lblResponsaveis").first().html();
/* 178 */       String[] arrayOfString = str1.split("<br><br>");
/* 179 */       for (String str2 : arrayOfString) {
/* 180 */         String[] arrayOfString1 = str2.split("<br>");
/* 181 */         for (String str3 : arrayOfString1) {
/* 182 */           if (str3.contains("CPF")) {
/* 183 */             String str4 = str3.replaceAll("\\D", "");
/* 184 */             str4 = StringUtils.leftPad(str4, 11, "0");
/* 185 */             arrayList.add(str4);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 191 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String S() {
/* 198 */     String str1 = c().a(g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/PREGAO_OC_Pesquisa_Fornecedor.aspx?chave=").a(this.aP)).getData();
/* 199 */     Document document = Jsoup.parse(str1);
/* 200 */     String str2 = document.select("input[id=__VIEWSTATE]").first().val();
/* 201 */     String str3 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/* 202 */     String str4 = document.select("input[id=__EVENTVALIDATION]").first().val();
/*     */     
/* 204 */     Calendar calendar = y.i();
/* 205 */     String str5 = y.formatDate(calendar.getTime(), "dd/MM/yyyy");
/*     */     
/* 207 */     calendar.add(2, -6);
/* 208 */     String str6 = y.formatDate(calendar.getTime(), "dd/MM/yyyy");
/*     */     
/* 210 */     return c().a(
/* 211 */         g.d().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/PREGAO_OC_Pesquisa_Fornecedor.aspx?chave=").a(this.aP)
/* 212 */         .a("__EVENTTARGET", "ctl00$conteudo$Pesquisa")
/* 213 */         .a("__EVENTARGUMENT", "")
/* 214 */         .a("__VIEWSTATE", str2)
/* 215 */         .a("__VIEWSTATEGENERATOR", str3)
/* 216 */         .a("__EVENTVALIDATION", str4)
/* 217 */         .a("ctl00$conteudo$TipoOCPesquisa", "3")
/* 218 */         .a("ctl00$conteudo$LinhaFornecimento", "-1")
/* 219 */         .a("ctl00$conteudo$NumeroOc", "")
/* 220 */         .a("ctl00$conteudo$DataInicio", "")
/* 221 */         .a("ctl00$conteudo$DataFim", "")
/* 222 */         .a("ctl00$conteudo$DataInicio", str6)
/* 223 */         .a("ctl00$conteudo$DataFim", str5))
/* 224 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String e(String paramString) {
/* 230 */     String str1 = c().a(g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/PREGAO_OC_Pesquisa_Fornecedor.aspx?chave=").a(this.aP)).getData();
/* 231 */     Document document = Jsoup.parse(str1);
/* 232 */     String str2 = document.select("input[id=__VIEWSTATE]").first().val();
/* 233 */     String str3 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/* 234 */     String str4 = document.select("input[id=__EVENTVALIDATION]").first().val();
/*     */     
/* 236 */     return c().a(
/* 237 */         g.d().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/PREGAO_OC_Pesquisa_Fornecedor.aspx?chave=").a(this.aP)
/* 238 */         .a("__EVENTTARGET", "ctl00$conteudo$Pesquisa")
/* 239 */         .a("__EVENTARGUMENT", "")
/* 240 */         .a("__VIEWSTATE", str2)
/* 241 */         .a("__VIEWSTATEGENERATOR", str3)
/* 242 */         .a("__EVENTVALIDATION", str4)
/* 243 */         .a("ctl00$conteudo$TipoOCPesquisa", "1")
/* 244 */         .a("ctl00$conteudo$LinhaFornecimento", "-1")
/* 245 */         .a("ctl00$conteudo$NumeroOc", paramString)
/* 246 */         .a("ctl00$conteudo$DataInicio", "")
/* 247 */         .a("ctl00$conteudo$DataFim", ""))
/* 248 */       .getData();
/*     */   }
/*     */   
/*     */   public String f(String paramString) {
/* 252 */     return c().a(
/* 253 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/Ata/becprp17001.aspx?").a(paramString))
/* 254 */       .getData();
/*     */   }
/*     */   
/*     */   public String T() {
/* 258 */     return c().a(
/* 259 */         g.c().a("https://www.bec.sp.gov.br/").a("fornecedor_ui/Console/Console_OC.aspx?PA=1&chave=").a(this.aP))
/* 260 */       .getData();
/*     */   }
/*     */   
/*     */   public e b(String paramString) {
/* 264 */     return c().a(
/* 265 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/Pregao_OC_Item.aspx?chave=").a(this.aP).a("&OC=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e c(String paramString) {
/* 270 */     return c().a(
/* 271 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/becprp07001.aspx?").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String g(String paramString) {
/* 276 */     return c().a(
/* 277 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/oc/pregao_oc_item_ficha.aspx?").a(paramString))
/* 278 */       .getData();
/*     */   }
/*     */   
/*     */   public String h(String paramString) {
/* 282 */     return c().a(
/* 283 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_ui/chat/BECPRP00901.aspx?chave=").a(this.aP).a("&OC=").a(paramString))
/* 284 */       .getData();
/*     */   }
/*     */   
/*     */   public Header[] a(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
/* 288 */     String str = String.join("", new CharSequence[] { "ctl00$conteudo$dg$ctl", y.h(2, Integer.toString(paramInt + 1)), "$cb" });
/* 289 */     return a(paramString1, str, paramString2, paramString3, paramString4);
/*     */   }
/*     */   
/*     */   public Header[] b(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4) {
/* 293 */     String str = String.join("", new CharSequence[] { "ctl00$conteudo$loteGridItens$grdLote$ctl", y.h(2, Integer.toString(paramInt + 1)), "$cb" });
/* 294 */     return a(paramString1, str, paramString2, paramString3, paramString4);
/*     */   }
/*     */   
/*     */   private Header[] a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
/* 298 */     return c().a(
/* 299 */         g.d().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/OC/Pregao_OC_Item.aspx?chave=").a(this.aP).a("&OC=").a(paramString1)
/* 300 */         .a("__EVENTTARGET", "")
/* 301 */         .a("__EVENTARGUMENT", "")
/* 302 */         .a("__VIEWSTATE", paramString3)
/* 303 */         .a("__VIEWSTATEGENERATOR", paramString4)
/* 304 */         .a("__VIEWSTATEENCRYPTED", "")
/* 305 */         .a("__EVENTVALIDATION", paramString5)
/* 306 */         .a("ctl00$conteudo$tbNumSeqItem", "")
/* 307 */         .a("ctl00$conteudo$tbxCodigoFornecedorItem", "")
/* 308 */         .a("ctl00$conteudo$bt408", "Propostas")
/* 309 */         .a(paramString2, "on")
/* 310 */         .a())
/* 311 */       .a();
/*     */   }
/*     */   
/*     */   public e d(String paramString) {
/* 315 */     return c().a(
/* 316 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/lance/becprp11002.aspx?").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e e(String paramString) {
/* 321 */     return c().a(
/* 322 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/Lance/becprf05004.aspx?chave=").a(this.aP).a("&OC=").a(paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7) {
/* 327 */     String str = Long.toString(a().y());
/* 328 */     str = y.h(11, str);
/*     */     
/* 330 */     return c().a(
/* 331 */         g.d().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/Lance/becprf05004.aspx?chave=").a(this.aP).a("&OC=").a(paramString1)
/* 332 */         .a("__EVENTTARGET", "ctl00$conteudo$bt40601")
/* 333 */         .a("__EVENTARGUMENT", "")
/* 334 */         .a("__VIEWSTATE", paramString4)
/* 335 */         .a("__VIEWSTATEGENERATOR", paramString5)
/* 336 */         .a("__VIEWSTATEENCRYPTED", "")
/* 337 */         .a("__ASYNCPOST", "true")
/* 338 */         .a("ctl00$conteudo$txtCPF", str)
/* 339 */         .a("ctl00$cabecalhoBec$ScriptManager1", "ctl00$conteudo$areaPrincipal|ctl00$conteudo$bt40601")
/* 340 */         .a("ctl00$wucOcFicha$hidHoraRet", "0")
/* 341 */         .a("ctl00$wucOcFicha$hidMinutoRet", paramString6)
/* 342 */         .a("ctl00$wucOcFicha$hidSegundoRet", paramString7)
/* 343 */         .a(paramString2, paramString3)
/* 344 */         .a("", "")
/* 345 */         .b("Sec-Fetch-Mode", "cors")
/* 346 */         .b("Sec-Fetch-Site", "same-origin")
/* 347 */         .b("X-MicrosoftAjax", "Delta=true")
/* 348 */         .b("X-Requested-With", "XMLHttpRequest"));
/*     */   }
/*     */ 
/*     */   
/*     */   public String i(String paramString) {
/* 353 */     return c().a(
/* 354 */         g.c().a("https://www.bec.sp.gov.br/").a("bec_pregao_UI/lance/becprp11002.aspx?").a(paramString))
/* 355 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 360 */     if (ae() || b.a().a(this)) {
/* 361 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   void bI() {
/* 366 */     String str1 = c().a(g.d().a("https://www.bec.sp.gov.br/").a("Compartilhado_ui/Login/Logoff.aspx?chave=").a(this.aP)).getData();
/*     */     
/* 368 */     Document document = Jsoup.parse(str1);
/* 369 */     String str2 = document.select("input[id=__VIEWSTATE]").first().val();
/* 370 */     String str3 = document.select("input[id=__VIEWSTATEGENERATOR]").first().val();
/* 371 */     String str4 = document.select("input[id=__EVENTVALIDATION]").first().val();
/*     */     
/* 373 */     c().a(g.d().a("https://www.bec.sp.gov.br/").a("Compartilhado_ui/Login/Logoff.aspx?chave=").a(this.aP)
/* 374 */         .a("__VIEWSTATE", str2)
/* 375 */         .a("__VIEWSTATEGENERATOR", str3)
/* 376 */         .a("__EVENTVALIDATION", str4)
/* 377 */         .a("ctl00$c_area_conteudo$btn_Sim", "Sim"));
/*     */   }
/*     */   
/*     */   int A() {
/* 381 */     return this.d.get();
/*     */   }
/*     */   
/*     */   public void bJ() {
/* 385 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   public void bK() {
/* 389 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 394 */     return A.a().p(aO);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 399 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 404 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\a\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */