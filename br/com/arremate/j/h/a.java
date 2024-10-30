/*     */ package br.com.arremate.j.h;
/*     */ 
/*     */ import br.com.arremate.a.a.c;
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.f;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.select.Elements;
/*     */ 
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
/*     */   private static final String DOMAIN = "https://operacao.portaldecompraspublicas.com.br/";
/*     */   
/*  35 */   private static final String cq = String.join("", new CharSequence[] { "https://operacao.portaldecompraspublicas.com.br/", "18/LoginExt/" });
/*     */   
/*     */   private static final String cr = "https://apipcp.portaldecompraspublicas.com.br/";
/*     */   
/*     */   private static final int aC = 10;
/*     */   
/*     */   private static final int aD = 1;
/*  42 */   private final String cs = c.a().g();
/*     */   
/*     */   private final b d;
/*     */   
/*  46 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*  48 */   private String ct = "4/";
/*     */   
/*     */   public a(d paramd, boolean paramBoolean) {
/*  51 */     a(paramd);
/*     */     
/*  53 */     if (paramBoolean) {
/*  54 */       a(b());
/*     */     } else {
/*  56 */       ce();
/*     */     } 
/*     */     
/*  59 */     this.d = (AtomicInteger)g.a(
/*  60 */         g.c()
/*  61 */         .a("User-Agent", "Effecti")
/*  62 */         .a(304)
/*  63 */         .a(400)
/*  64 */         .a((af)d));
/*     */   }
/*     */ 
/*     */   
/*     */   private b b() {
/*  69 */     return g.a(
/*  70 */         g.c()
/*  71 */         .a("User-Agent", "Effecti")
/*  72 */         .a(304)
/*  73 */         .a("standard")
/*  74 */         .a((af)d));
/*     */   }
/*     */ 
/*     */   
/*     */   private void ce() {
/*  79 */     a(
/*  80 */         g.a(this, 
/*  81 */           b(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */             
/*  84 */             return (str.contains("\"urlredir\"") && (str.contains("/18/logout/") || str.contains("/18/sessaofinalizada/"))) ? true : ((parame.getStatusCode() == 302) ? true : (
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */               
/*  92 */               (str.contains("class=\"cta-login\"") || str.contains("sessão finalizada"))));
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int z() {
/*     */     try {
/* 101 */       c().bB();
/*     */       
/* 103 */       e e = l();
/* 104 */       String str1 = e.getData();
/*     */       
/* 106 */       if (str1.isEmpty()) {
/* 107 */         a.info("Failed to login at Compras Públicas, empty data | Status Code: {}", Integer.valueOf(e.getStatusCode()));
/* 108 */         return 0;
/*     */       } 
/*     */       
/* 111 */       if (g(str1)) {
/* 112 */         return 2;
/*     */       }
/*     */       
/* 115 */       F(str1);
/*     */       
/* 117 */       e = c().a(g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("Cadastro/").b());
/* 118 */       Document document = Jsoup.parse(e.getData());
/* 119 */       Elements elements = document.select("form[id=defaultForm3] > div > span");
/*     */       
/* 121 */       if (elements.isEmpty()) {
/* 122 */         a.info("Failed to login at Compras Públicas, company data not found | Status Code: {}", Integer.valueOf(e.getStatusCode()));
/* 123 */         return 0;
/*     */       } 
/*     */       
/* 126 */       String str2 = elements.get(0).text();
/* 127 */       str2 = str2.replace(".", "").replace("/", "").replace("-", "");
/* 128 */       String str3 = elements.get(3).text();
/*     */       
/* 130 */       a().v(Long.parseLong(str2));
/* 131 */       a().aa(str3);
/*     */       
/* 133 */       if (!ae()) {
/* 134 */         setRunning(true);
/* 135 */         cb();
/*     */       } 
/*     */       
/* 138 */       return 1;
/* 139 */     } catch (Exception exception) {
/* 140 */       a.error("Falha ao realizar login", exception);
/*     */ 
/*     */       
/* 143 */       return 0;
/*     */     } 
/*     */   }
/*     */   private e l() {
/* 147 */     return af() ? 
/* 148 */       n() : 
/* 149 */       m();
/*     */   }
/*     */   
/*     */   private boolean af() {
/* 153 */     String str = c().a(g.c().a(cq).b()).getData();
/* 154 */     return (str != null && str.toLowerCase().contains("siteKey"));
/*     */   }
/*     */   
/*     */   private e m() {
/* 158 */     return c().a(g.d()
/* 159 */         .a(cq)
/* 160 */         .a("usuario", getUser())
/* 161 */         .a("password", getPassword())
/* 162 */         .b());
/*     */   }
/*     */   
/*     */   private e n() {
/* 166 */     byte b1 = 0;
/* 167 */     e e = new e();
/*     */     
/*     */     do {
/* 170 */       j j = j.a();
/* 171 */       br.com.arremate.a.a.a a1 = j.e();
/*     */       
/* 173 */       if (a1 == null)
/* 174 */       { b1++;
/*     */ 
/*     */         
/*     */          }
/*     */       
/*     */       else
/*     */       
/*     */       { 
/*     */         
/* 183 */         f f = g.d().a(cq).a("usuario", getUser()).a("password", getPassword()).a("g-recaptcha-response", a1.a()).b();
/*     */         
/* 185 */         e = c().a(f);
/* 186 */         String str = e.getData();
/*     */         
/* 188 */         if (str.isEmpty() || !str.contains("Responda ao captcha!")) {
/*     */           break;
/*     */         }
/*     */         
/* 192 */         b1++;
/* 193 */         j.c(a1.getId()); } 
/* 194 */     } while (b1 < 3);
/*     */     
/* 196 */     if (b1 == 3) {
/* 197 */       setMessage("Falha ao quebrar reCaptcha para realizar o login no portal!");
/*     */     }
/*     */     
/* 200 */     return e;
/*     */   }
/*     */   
/*     */   private void F(String paramString) {
/* 204 */     if (paramString.contains("/4/DashBoard/")) {
/* 205 */       paramString = c().a(g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("DashBoard/").b()).getData();
/*     */       
/* 207 */       if (paramString.contains("/6/Cadastro/")) {
/* 208 */         this.ct = "6/";
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean g(String paramString) {
/* 214 */     return paramString.contains("Login e/ou Senha Incorretos!");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String i(int paramInt) {
/* 221 */     return c().a(
/* 222 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SuasPropostas/")
/* 223 */         .a("rdCampoPesquisado", "").a("btBuscar", "Buscar").a("ttBusca", "").a("ttOrderBy", "")
/* 224 */         .a("ttPagina", paramInt).a("ttOrgao", "").a("ttAbertura", "").a("ttObjeto", "").a("slCD_UF", "")
/* 225 */         .a("slCD_GRUPO_MATERIAL", 0).a("slCD_CLASSE_MATERIAL", 0).a("slCD_MODALIDADE_LICITACAO", "")
/* 226 */         .a("slCD_TIPO_REALIZACAO_LICITACAO", "").a("slCD_TIPO_JULGAMENTO_LICITACAO", ""))
/* 227 */       .getData();
/*     */   }
/*     */   
/*     */   public String d(int paramInt1, int paramInt2) {
/* 231 */     return c(paramInt1, paramInt2, 1);
/*     */   }
/*     */   
/*     */   public String c(int paramInt1, int paramInt2, int paramInt3) {
/* 235 */     return c().a(
/* 236 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("Pregoes/RegistroProposta/")
/* 237 */         .a("rdCampoPesquisado", "").a("btBuscar", "Buscar").a("ttBusca", "").a("ttOrderBy", "")
/* 238 */         .a("ttPagina", paramInt2).a("ttCD_CHAVE", paramInt1)
/* 239 */         .a("ttPaginaInternaLote", paramInt3).a("ttPASSO", "3"))
/* 240 */       .getData();
/*     */   }
/*     */   
/*     */   public String j(int paramInt) {
/* 244 */     return c().a(
/* 245 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("Pregoes/DadosPregao/")
/* 246 */         .a("slA", "Edit").a("ttCD_CHAVE", paramInt))
/* 247 */       .getData();
/*     */   }
/*     */   
/*     */   public String d(String paramString, int paramInt) {
/* 251 */     return c().a(
/* 252 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SuasPropostas/")
/* 253 */         .a("rdCampoPesquisado", "").a("btBuscar", "Buscar").a("ttBusca", paramString).a("ttOrderBy", "")
/* 254 */         .a("ttPagina", paramInt).a("ttOrgao", "").a("ttAbertura", "").a("ttObjeto", "").a("slCD_UF", "")
/* 255 */         .a("slCD_TIPO_LICITACAO", "").a("slCD_GRUPO_MATERIAL", "").a("slCD_CLASSE_MATERIAL", ""))
/* 256 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e n(int paramInt) {
/* 263 */     return this.d.a(g.c().a("https://apipcp.portaldecompraspublicas.com.br/").a("publico/obterStatusProcesso")
/* 264 */         .a("publicKey", this.cs)
/* 265 */         .a("idLicitacao", paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public e o(int paramInt) {
/* 270 */     return this.d.a(g.c().a("https://apipcp.portaldecompraspublicas.com.br/").a("publico/obterItensEmDisputa")
/* 271 */         .a("publicKey", this.cs)
/* 272 */         .a("idLicitacao", paramInt));
/*     */   }
/*     */ 
/*     */   
/*     */   public String k(int paramInt) {
/* 277 */     return this.d.a(g.c().a("https://apipcp.portaldecompraspublicas.com.br/").a("publico/obterProcesso")
/* 278 */         .a("publicKey", this.cs)
/* 279 */         .a("idLicitacao", paramInt))
/* 280 */       .getData();
/*     */   }
/*     */   
/*     */   public e e(int paramInt1, int paramInt2) {
/* 284 */     return c(paramInt1, 1, paramInt2);
/*     */   }
/*     */   
/*     */   public e f(int paramInt1, int paramInt2) {
/* 288 */     return c(paramInt1, 10, paramInt2);
/*     */   }
/*     */   
/*     */   private e c(int paramInt1, int paramInt2, int paramInt3) {
/* 292 */     return c().a(
/* 293 */         g.d().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SessaoPublica/lances/htmlAba.asp?param=").a(paramInt2)
/* 294 */         .a("ttCD_LICITACAO", paramInt1).a("ttTipo", paramInt2).a("ttPagina", paramInt3));
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(double paramDouble, int paramInt, String paramString1, String paramString2, String paramString3) {
/* 299 */     if (paramInt <= 0) {
/* 300 */       paramInt = 4;
/*     */     }
/*     */     
/* 303 */     String str = BigDecimal.valueOf(paramDouble).setScale(paramInt, RoundingMode.DOWN).stripTrailingZeros().toPlainString().replace(".", ",");
/* 304 */     return c().a(
/* 305 */         g.d().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SessaoPublica/SubmeterLance/")
/* 306 */         .a("ttCD_CHAVE", paramString1).a("slCD_ORIGEM", paramString2).a("ttUsuarioAtivo", paramString3)
/* 307 */         .a("ttPRECO_UNITARIO", str).a("btGravar", "sim"));
/*     */   }
/*     */ 
/*     */   
/*     */   public e a(double paramDouble, String paramString1, String paramString2) {
/* 312 */     String str = BigDecimal.valueOf(paramDouble).setScale(4, RoundingMode.DOWN).stripTrailingZeros().toPlainString().replace(".", ",");
/* 313 */     return c().a(
/* 314 */         g.d().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SessaoPublica/LanceFechado/")
/* 315 */         .a("ttCD_CHAVE", paramString1).a("slCD_ORIGEM", paramString2).a("ttLANCE_FECHADO", str)
/* 316 */         .a("btGravar", "Enviar Lance"));
/*     */   }
/*     */ 
/*     */   
/*     */   public String e(int paramInt1, int paramInt2) {
/* 321 */     return c().a(
/* 322 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SessaoPublica/RankingItem/")
/* 323 */         .a("ttCD_CHAVE", paramInt2).a("slCD_ORIGEM", paramInt1))
/* 324 */       .getData();
/*     */   }
/*     */   
/*     */   public e A(String paramString) {
/* 328 */     return c().a(
/* 329 */         g.c().a("https://operacao.portaldecompraspublicas.com.br/").a(this.ct).a("SessaoPublica/")
/* 330 */         .a("ttCD_CHAVE", paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e g(int paramInt1, int paramInt2) {
/* 338 */     f f = g.c().a("https://apipcp.portaldecompraspublicas.com.br/").a("publico/obterChat").a("publicKey", this.cs).a("idLicitacao", paramInt1).a("pagina", paramInt2);
/*     */     
/* 340 */     return this.d.a(f);
/*     */   }
/*     */   
/*     */   void bI() {
/* 344 */     c().a(g.c().a("https://operacao.portaldecompraspublicas.com.br/").a("18/Logout/"));
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 349 */     if (ae() || b.a().a(this)) {
/* 350 */       super.b();
/* 351 */       this.d.b();
/*     */     } 
/*     */   }
/*     */   
/*     */   int A() {
/* 356 */     return this.d.get();
/*     */   }
/*     */   
/*     */   public void bJ() {
/* 360 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   public void bK() {
/* 364 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 369 */     return A.a().p(cq);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 374 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 379 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\h\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */