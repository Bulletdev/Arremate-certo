/*     */ package br.com.arremate.j.c;
/*     */ 
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.commons.codec.binary.Base64;
/*     */ import org.apache.http.Header;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends c
/*     */ {
/*  28 */   private static final af e = af.a(5.0D);
/*     */ 
/*     */   
/*     */   static final String SOCKET = "wss://cnetmobile.estaleiro.serpro.gov.br/comprasnet-websocket/socket/websocket";
/*     */ 
/*     */   
/*     */   protected static final String bj = "https://cnetmobile.estaleiro.serpro.gov.br/";
/*     */ 
/*     */   
/*  37 */   protected static final String bk = String.join("", new CharSequence[] { "https://cnetmobile.estaleiro.serpro.gov.br/", "comprasnet-usuario/" });
/*     */   
/*  39 */   protected static final String bl = String.join("", new CharSequence[] { bk, "v1/" });
/*  40 */   protected static final String bm = String.join("", new CharSequence[] { bl, "usuario/" });
/*     */   
/*  42 */   protected static final String bn = String.join("", new CharSequence[] { bk, "v2/" });
/*  43 */   protected static final String bo = String.join("", new CharSequence[] { bn, "sessao/fornecedor/usuario/token/" });
/*  44 */   protected static final String bp = String.join("", new CharSequence[] { bn, "sessao/fornecedor/retoken" });
/*     */   
/*  46 */   protected static final String bq = String.join("", new CharSequence[] { "https://cnetmobile.estaleiro.serpro.gov.br/", "comprasnet-disputa/v1/compras/" });
/*  47 */   protected static final String br = String.join("", new CharSequence[] { "https://cnetmobile.estaleiro.serpro.gov.br/", "comprasnet-fase-externa/v1/compras/" });
/*     */   
/*     */   private final a a;
/*     */   
/*     */   private String q;
/*     */   private String bs;
/*     */   
/*     */   public e(d paramd) {
/*  55 */     super(paramd);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  63 */     c c1 = d().a(422).a(206).a(302).a(500).a(429).a(e);
/*     */     
/*  65 */     a(c1.a());
/*     */     
/*  67 */     this.a = new a();
/*  68 */     a(new a());
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  73 */     c c1 = f.a().a(a());
/*  74 */     if (c1.isRunning()) {
/*  75 */       setRunning(true);
/*  76 */       cb();
/*  77 */       a(c1);
/*  78 */       return 1;
/*     */     } 
/*     */     
/*  81 */     setMessage(c1.getMessage());
/*  82 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bN() throws Exception {
/*  89 */     br.com.arremate.h.e e1 = c().a(g.c().a(DOMAIN).a("assinadas/dispensa_eletronica.asp"));
/*  90 */     Document document = Jsoup.parse(e1.getData());
/*  91 */     String str = document.select("#compras-id").first().val();
/*     */     
/*  93 */     e1 = c().a(
/*  94 */         g.c().a(bo).a(str)
/*  95 */         .b("Host", "cnetmobile.estaleiro.serpro.gov.br"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     i i = new i(e1.getData());
/* 105 */     this.q = i.getString("accessToken");
/* 106 */     this.bs = i.getString("refreshToken");
/*     */     
/* 108 */     e1 = c().a(g.c().a(bm).b("Authorization", this.q));
/* 109 */     if (e1.getStatusCode() != 200) {
/* 110 */       throw new Exception("Failed to login to the dispense bidding room");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void A(String paramString) throws Exception {
/* 117 */     Header[] arrayOfHeader = c().a(g.c().a(DOMAIN).a("pregao/includes/acessoSalaDisputaFornecedor.asp?compra=").a(paramString).a()).a();
/* 118 */     String str = "";
/*     */     
/* 120 */     for (Header header : arrayOfHeader) {
/* 121 */       if (header.getName().equals("Location")) {
/* 122 */         String str1 = header.getValue();
/* 123 */         String str2 = "compras-id=";
/* 124 */         int j = str1.indexOf(str2);
/*     */         
/* 126 */         if (j < 0) {
/* 127 */           ((a)a()).bO();
/* 128 */           a.info("Instead of expected redirect, sending us to: {}", str1);
/*     */         } else {
/* 130 */           ((a)a()).bP();
/*     */         } 
/*     */         
/* 133 */         str = str1.substring(j + str2.length());
/* 134 */         str = str.substring(0, str.indexOf("&compra="));
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 139 */     br.com.arremate.h.e e1 = c().a(
/* 140 */         g.c().a(bo).a(str)
/* 141 */         .b("Host", "cnetmobile.estaleiro.serpro.gov.br"));
/*     */ 
/*     */     
/* 144 */     i i = new i(e1.getData());
/* 145 */     this.q = i.getString("accessToken");
/* 146 */     this.bs = i.getString("refreshToken");
/*     */     
/* 148 */     e1 = c().a(g.c().a(bm).b("Authorization", aa()));
/* 149 */     if (e1.getStatusCode() != 200) {
/* 150 */       throw new Exception("Failed to login to the dispute bidding room");
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean V() {
/* 155 */     br.com.arremate.h.e e1 = c().a(
/* 156 */         g.i().a(bp)
/* 157 */         .b("Authorization", String.join("", new CharSequence[] { "Bearer ", this.bs
/* 158 */             })).b("Host", "cnetmobile.estaleiro.serpro.gov.br")
/* 159 */         .b("Accept", "application/json, text/plain, */*"));
/*     */ 
/*     */     
/* 162 */     if (!y.m(e1.getData())) {
/* 163 */       a.info("Failed to refresh token, status: {}, response: {}", Integer.valueOf(e1.getStatusCode()), e1.getData());
/* 164 */       return false;
/*     */     } 
/*     */     
/* 167 */     i i = new i(e1.getData());
/* 168 */     if (!i.has("accessToken") || !i.has("refreshToken")) {
/* 169 */       return false;
/*     */     }
/* 171 */     this.q = i.getString("accessToken");
/* 172 */     this.bs = i.getString("refreshToken");
/* 173 */     return true;
/*     */   }
/*     */   
/*     */   public long l() throws Exception {
/* 177 */     if (this.q != null) {
/* 178 */       String[] arrayOfString = this.q.split("\\.");
/* 179 */       String str1 = arrayOfString[1];
/* 180 */       Base64 base64 = new Base64(true);
/* 181 */       String str2 = new String(base64.decode(str1));
/*     */       
/* 183 */       i i = new i(str2);
/* 184 */       if (i.has("exp")) {
/* 185 */         return i.getLong("exp") * 1000L;
/*     */       }
/*     */     } 
/*     */     
/* 189 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e a(String paramString1, String paramString2, double paramDouble, String paramString3) throws d {
/* 196 */     i i = new i();
/* 197 */     i.c("valorInformado", BigDecimal.valueOf(paramDouble).setScale(4, RoundingMode.HALF_EVEN).toPlainString());
/* 198 */     i.c("faseItem", paramString3);
/*     */     
/* 200 */     a.debug("Post bid item {}: {}", paramString2, i.toString());
/*     */     
/* 202 */     br.com.arremate.h.e e1 = c().a(
/* 203 */         g.e()
/* 204 */         .a(bq).a(paramString1).a("/itens/").a(paramString2).a("/lances")
/* 205 */         .b("Accept", "application/json, text/plain, */*")
/* 206 */         .b("Authorization", aa())
/* 207 */         .a(i));
/*     */ 
/*     */     
/* 210 */     if (e1.O()) {
/* 211 */       throw new d(e1.k());
/*     */     }
/*     */     
/* 214 */     return e1;
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e h(String paramString) {
/* 218 */     return c().a(
/* 219 */         g.c().a(bq).a(paramString).a("/itens/em-disputa")
/* 220 */         .b("Authorization", aa()).b("Accept", "application/json, text/plain, */*"));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e a(String paramString1, String paramString2) {
/* 225 */     return c().a(
/* 226 */         g.c().a(bq).a(paramString1).a("/itens/em-disputa/").a(paramString2).a("/itens-grupo")
/* 227 */         .b("Authorization", aa()).b("Accept", "application/json, text/plain, */*"));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e a(String paramString, int paramInt) {
/* 232 */     return this.a.a(paramString2 -> c().a(g.c().a(bq).a(paramString1).a("/itens/disputa-encerrada").a("captcha", paramString2).a("tamanhoPagina", 10).a("pagina", paramInt).a("filtro", 1).b("Authorization", aa()).b("Accept", "application/json, text/plain, */*")));
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
/*     */   public br.com.arremate.h.e b(String paramString1, String paramString2) {
/* 244 */     return this.a.a(paramString3 -> c().a(g.c().a(bq).a(paramString1).a("/itens/").a(paramString2).a("/lances/por-participante").a("captcha", paramString3).a("tamanhoPagina", 20).a("pagina", 0).b("Authorization", aa()).b("Accept", "application/json, text/plain, */*")));
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
/*     */   public br.com.arremate.h.e a(int paramInt1, int paramInt2, int paramInt3) {
/* 256 */     return this.a.a(paramString -> c().a(g.c().a(br).a("participacoes").a("captcha", paramString).a("tamanhoPagina", paramInt1).a("pagina", paramInt2).a("filtro", paramInt3).b("Authorization", aa()).b("Accept", "application/json, text/plain, */*").a(this.c)));
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
/*     */   public br.com.arremate.h.e i(String paramString) {
/* 269 */     return c().a(
/* 270 */         g.c().a(br).a(paramString)
/* 271 */         .b("Authorization", aa())
/* 272 */         .b("Accept", "application/json, text/plain, */*")
/* 273 */         .a(this.c));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e j(String paramString) {
/* 278 */     return c().a(
/* 279 */         g.c().a(br).a(paramString).a("/participacao")
/* 280 */         .b("Authorization", aa())
/* 281 */         .b("Accept", "application/json, text/plain, */*")
/* 282 */         .a(this.c));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e c(String paramString1, String paramString2) {
/* 287 */     return c().a(
/* 288 */         g.c().a(br).a(paramString1).a("/itens/").a(paramString2).a("/detalhamento")
/* 289 */         .b("Authorization", aa())
/* 290 */         .b("Accept", "application/json, text/plain, */*")
/* 291 */         .a(this.c));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e b(String paramString, int paramInt) {
/* 296 */     return this.a.a(paramString2 -> c().a(g.c().a(br).a(paramString1).a("/itens/aguardando-abertura-sessao-publica").a("captcha", paramString2).a("tamanhoPagina", 10).a("pagina", paramInt).b("Authorization", aa()).b("Accept", "application/json, text/plain, */*").a(this.c)));
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
/*     */   public br.com.arremate.h.e b(String paramString, int paramInt1, int paramInt2) {
/* 308 */     return c().a(
/* 309 */         g.c().a(br).a(paramString).a("/itens/aguardando-abertura-sessao-publica/").a(paramInt2).a("/itens-grupo")
/* 310 */         .a("tamanhoPagina", 10).a("pagina", paramInt1)
/* 311 */         .b("Authorization", aa())
/* 312 */         .b("Accept", "application/json, text/plain, */*")
/* 313 */         .a(this.c));
/*     */   }
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e c(String paramString, int paramInt1, int paramInt2) {
/* 318 */     return c().a(
/* 319 */         g.c().a(bq).a(paramString).a("/itens/disputa-encerrada/").a(paramInt2).a("/itens-grupo")
/* 320 */         .a("tamanhoPagina", 10).a("pagina", paramInt1)
/* 321 */         .b("Authorization", aa())
/* 322 */         .b("Accept", "application/json, text/plain, */*"));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e c(String paramString, int paramInt) {
/* 326 */     return this.a.a(paramString2 -> c().a(g.c().a("https://cnetmobile.estaleiro.serpro.gov.br/").a("comprasnet-mensagem/v2/chat/").a(paramString1).a("size", 20).a("page", paramInt).a("legadoAsp", "false").a("captcha", paramString2).b("Authorization", aa()).b("Accept", "application/json, text/plain, */*")));
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
/*     */   public br.com.arremate.h.e d(String paramString1, String paramString2) {
/* 340 */     return c().a(
/* 341 */         g.c().a(br).a(paramString1).a("/em-selecao-fornecedores/itens/").a(paramString2).a("/propostas")
/* 342 */         .b("Authorization", aa())
/* 343 */         .b("Accept", "application/json, text/plain, */*"));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e a(String paramString1, String paramString2, String paramString3, int paramInt) {
/* 347 */     return c().a(
/* 348 */         g.c().a(br).a(paramString1).a("/em-selecao-fornecedores/participacoes/").a(paramString2).a("/itens/").a(paramString3).a("/itens-grupo/propostas")
/* 349 */         .a("tamanhoPagina", 10).a("pagina", paramInt)
/* 350 */         .b("Authorization", aa())
/* 351 */         .b("Accept", "application/json, text/plain, */*"));
/*     */   }
/*     */   
/*     */   private String aa() {
/* 355 */     return String.join("", new CharSequence[] { "Bearer ", this.q });
/*     */   }
/*     */   
/*     */   public String a() {
/* 359 */     return this.q;
/*     */   }
/*     */   
/*     */   private class a extends c.a {
/*     */     private a(e this$0) {
/* 364 */       this.e = new AtomicInteger(0);
/*     */     }
/*     */     private AtomicInteger e;
/*     */     public boolean lockRequestsBySessionControl(br.com.arremate.h.e param1e) throws Exception {
/* 368 */       boolean bool = (super.lockRequestsBySessionControl(param1e) || W()) ? true : false;
/*     */       
/* 370 */       if (bool) {
/* 371 */         bP();
/*     */       }
/*     */       
/* 374 */       return bool;
/*     */     }
/*     */     
/*     */     private boolean W() {
/* 378 */       return (this.e.get() >= 10);
/*     */     }
/*     */     
/*     */     protected void bO() {
/* 382 */       this.e.incrementAndGet();
/*     */     }
/*     */     
/*     */     protected void bP() {
/* 386 */       this.e.set(0);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */