/*     */ package br.com.arremate.j.c;
/*     */ 
/*     */ import br.com.arremate.a.e;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.f;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.h.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.Optional;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.protocol.HttpContext;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends i
/*     */ {
/*  58 */   private static final af d = af.a(15.0D);
/*  59 */   public static final int DEFAULT_TIMEOUT = 30000; public static final String aX; public static final String aY; private static final String aZ; private static final String ba;
/*  60 */   public static final int as = 60000; private static final String bb; private static final String bc; private static final String bd;
/*     */   private static final String be;
/*  62 */   protected static final String DOMAIN = "https://www.comprasnet.gov.br/"; protected static final String bf; private final HttpClientContext a; protected final HttpContext c;
/*     */   private h.a b;
/*     */   
/*     */   static {
/*  66 */     aZ = String.join("", new CharSequence[] { DOMAIN, "seguro/loginPortalFornecedor.asp" });
/*  67 */     ba = String.join("", new CharSequence[] { DOMAIN, "seguro/landing_sso.asp?code=" });
/*  68 */     bb = String.join("", new CharSequence[] { DOMAIN, "seguro/loginPortalAssocEmpresa.asp" });
/*     */     
/*  70 */     bf = String.join("", new CharSequence[] { DOMAIN, "pregao/fornec/" });
/*  71 */     bc = String.join("", new CharSequence[] { bf, "Acompanhar.asp" });
/*  72 */     bd = String.join("", new CharSequence[] { bf, "Acompanhar2.asp" });
/*  73 */     aX = String.join("", new CharSequence[] { bf, "consultar.asp?tipo=agendados" });
/*  74 */     aY = String.join("", new CharSequence[] { bf, "lance.asp" });
/*  75 */     be = String.join("", new CharSequence[] { bf, "consultar.asp?tipo=" });
/*     */   }
/*     */   
/*     */   public c(d paramd) {
/*  79 */     a(paramd);
/*     */     
/*  81 */     this.a = new HttpClientContext();
/*  82 */     this.a.setRequestConfig(RequestConfig.custom()
/*  83 */         .setConnectionRequestTimeout(DEFAULT_TIMEOUT)
/*  84 */         .setConnectTimeout(DEFAULT_TIMEOUT)
/*  85 */         .setSocketTimeout(DEFAULT_TIMEOUT)
/*  86 */         .setCookieSpec("standard")
/*  87 */         .build());
/*     */     
/*  89 */     this.c = g.a(as);
/*     */     
/*  91 */     br.com.arremate.h.c c1 = d();
/*  92 */     a(c1.a());
/*  93 */     this.b = new a(this);
/*     */   }
/*     */   
/*     */   final br.com.arremate.h.c d() {
/*  97 */     return g.c()
/*  98 */       .b(DEFAULT_TIMEOUT)
/*  99 */       .a(302)
/* 100 */       .d(50)
/* 101 */       .e(300)
/* 102 */       .a(d)
/* 103 */       .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:109.0) Gecko/20100101 Firefox/117.0");
/*     */   }
/*     */   
/*     */   public int z() {
/*     */     i i1;
/* 108 */     c().bB();
/*     */     
/* 110 */     boolean bool1 = (a().bw() != null && !a().bw().trim().isEmpty()) ? true : false;
/* 111 */     long l1 = 0L, l2 = System.currentTimeMillis();
/* 112 */     byte b = 0;
/* 113 */     boolean bool2 = false;
/*     */ 
/*     */     
/*     */     do {
/* 117 */       b++;
/*     */       
/* 119 */       i1 = e.a().a(a());
/* 120 */       l1 += i1.getLong("latency");
/* 121 */       if (!i1.has("token"))
/* 122 */       { if (i1.has("error")) {
/* 123 */           String str = i1.getString("error");
/* 124 */           setMessage(str);
/*     */           
/* 126 */           l2 = System.currentTimeMillis() - l2;
/* 127 */           a(true, false, bool1, b, l1, l2);
/* 128 */           if (str.contains("verifique se o certificado e senha são válidos") || str
/* 129 */             .contains("'login e/ou senha incorreto(s)' ou 'senha bloqueada'") || str
/* 130 */             .contains("CPF informado inválido")) {
/* 131 */             return 2;
/*     */           }
/*     */           
/* 134 */           return 0;
/*     */         } 
/* 136 */         a.info("[CN] Failed to get token for login, token latency: {}", Long.valueOf(l1)); }
/*     */       
/*     */       else
/*     */       
/* 140 */       { bool2 = true; } 
/* 141 */     } while (!bool2 && b < 10);
/*     */     
/* 143 */     l2 = System.currentTimeMillis() - l2;
/* 144 */     if (!bool2) {
/* 145 */       setMessage("Falha ao realizar o login no portal, tente novamente!");
/* 146 */       a(false, false, bool1, b, l1, l2);
/* 147 */       return 0;
/*     */     } 
/*     */     
/*     */     try {
/* 151 */       String str1 = i1.getString("token");
/*     */ 
/*     */       
/* 154 */       String str2 = c().a(g.c().a(ba).a(str1).a((HttpContext)this.a).b()).getData();
/* 155 */       if (str2.isEmpty()) {
/* 156 */         a(true, false, bool1, b, l1, l2);
/* 157 */         return 0;
/*     */       } 
/*     */       
/* 160 */       Document document = Jsoup.parse(str2);
/* 161 */       Elements elements = document.select("div.br-radio");
/* 162 */       Optional optional = elements.stream().filter(paramElement -> (paramElement.select("input[value" + aw() + "]") != null)).findFirst();
/* 163 */       if (optional.isPresent())
/*     */       {
/*     */         
/* 166 */         str2 = c().a(g.d().a(bb).a("CNPJ", aw()).b()).getData();
/*     */       }
/*     */       
/* 169 */       if (str2.contains("location.href = \"branco.htm\"")) {
/* 170 */         str2 = c().a(g.c().a(DOMAIN).a("t_top.asp").b()).getData();
/* 171 */         if (!str2.contains(ax())) {
/* 172 */           setMessage("Não foi possível realizar o login. O CNPJ informado não foi encontrado no Portal!");
/* 173 */           a(true, false, bool1, b, l1, l2);
/* 174 */           return 2;
/*     */         } 
/*     */         
/* 177 */         if (f(str2)) {
/* 178 */           a(true, true, bool1, b, l1, l2);
/* 179 */           return 1;
/*     */         } 
/*     */       } 
/*     */       
/* 183 */       setMessage("Não foi possível realizar o login. O CNPJ informado não foi encontrado no Portal!");
/* 184 */     } catch (Exception exception) {
/* 185 */       a.error("Failed login of the Comprasnet portal", exception);
/*     */     } 
/*     */     
/* 188 */     a(true, false, bool1, b, l1, l2);
/* 189 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt, long paramLong1, long paramLong2) {
/* 195 */     double d1 = BigDecimal.valueOf(paramLong1).divide(BigDecimal.valueOf(paramInt), 4, RoundingMode.HALF_EVEN).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_EVEN).doubleValue();
/*     */ 
/*     */     
/* 198 */     double d2 = BigDecimal.valueOf(paramLong2).divide(BigDecimal.valueOf(1000L), 4, RoundingMode.HALF_EVEN).doubleValue();
/* 199 */     j.a().a(paramBoolean1, paramBoolean2, paramBoolean3, paramInt, d1, d2);
/*     */   }
/*     */   
/*     */   private boolean f(String paramString) {
/* 203 */     Document document = Jsoup.parse(paramString);
/* 204 */     Element element = document.select("div[class=info] > span[class=company]").first();
/* 205 */     if (element != null) {
/* 206 */       d d = a();
/*     */       
/* 208 */       String str = element.text();
/* 209 */       d.aa(str.substring(str.indexOf(" - ") + 3).trim());
/*     */       
/* 211 */       b();
/*     */       
/* 213 */       if (!ae()) {
/* 214 */         setRunning(true);
/* 215 */         cb();
/*     */       } 
/*     */       
/* 218 */       return true;
/*     */     } 
/*     */     
/* 221 */     return false;
/*     */   }
/*     */   
/*     */   private e b() {
/* 225 */     return c().a(g.c().a(DOMAIN).a("assinadas/pregao.asp").b());
/*     */   }
/*     */   
/*     */   boolean U() {
/* 229 */     String str = c().a(g.c().a(DOMAIN).a("t_top.asp").b()).getData();
/* 230 */     if (str.contains(ax())) {
/* 231 */       str = b().getData();
/* 232 */       return (!str.contains("sua sessão expirou") && !str.contains("você não está habilitado"));
/*     */     } 
/*     */     
/* 235 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void bL() {
/* 242 */     c().a(g.c().a(DOMAIN).a("assinadas/dispensa_eletronica.asp"));
/*     */   }
/*     */   
/*     */   public e c() {
/* 246 */     f f = g.c().a(aX);
/* 247 */     f.a(this.c);
/* 248 */     return c().a(f);
/*     */   }
/*     */   
/*     */   public e d() {
/* 252 */     return c().a(g.c().a(aY));
/*     */   }
/*     */   
/*     */   public e e() {
/* 256 */     return c().a(g.c().a(be).a("andamento"));
/*     */   }
/*     */   
/*     */   public e f() {
/* 260 */     return c().a(g.c().a(be).a("homologados"));
/*     */   }
/*     */   
/*     */   public e d(int paramInt) {
/* 264 */     return c().a(g.c().a(bf).a("detalhe_prop.asp")
/* 265 */         .a("prgcod", paramInt).a(this.c));
/*     */   }
/*     */   
/*     */   public e g() {
/* 269 */     return c().a(g.c().a(bf).a("VisualizaListaPregaoRAA.asp"));
/*     */   }
/*     */   
/*     */   public e h() {
/* 273 */     return c().a(g.c().a(bc));
/*     */   }
/*     */   
/*     */   public e a(int paramInt1, int paramInt2) {
/* 277 */     return c().a(
/* 278 */         g.c().a(bd)
/* 279 */         .a("prgCod", paramInt1)
/* 280 */         .a("ipgCod", paramInt2)
/* 281 */         .a("botao", "T")
/* 282 */         .a(this.c));
/*     */   }
/*     */ 
/*     */   
/*     */   public e e(int paramInt) {
/* 287 */     return c().a(g.c().a(bf).a("Consulta_proposta.asp").a("prgcod", paramInt));
/*     */   }
/*     */   
/*     */   public e d(int paramInt, String paramString) {
/* 291 */     return c().a(
/* 292 */         g.c().a(bf).a("Consulta_Proposta_Grupo.asp")
/* 293 */         .a("prgCod", paramInt)
/* 294 */         .a("ipgCod", paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public e f(int paramInt) {
/* 299 */     return c().a(g.c().a(bf).a("Mensagens_Sessao_Publica.asp").a("prgCod", paramInt));
/*     */   }
/*     */   
/*     */   public e f(String paramString) {
/* 303 */     return c().a(g.c().a(DOMAIN).a("includes/descricaoDetalhadaPropostaItem.asp").a("ippcod", paramString));
/*     */   }
/*     */   
/*     */   public e g(int paramInt) {
/* 307 */     return c().a(g.c().a(bf).a("dados_desc.asp").a("ipgcod", paramInt));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void b() {
/* 317 */     if (this instanceof e || this instanceof d) {
/* 318 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   void bM() {
/* 323 */     super.b();
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/* 327 */     b(paramg);
/* 328 */     a(g.a(this, c(), this.b));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 333 */     return A.a().p(aZ);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 338 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 343 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */   
/*     */   protected void a(h.a parama) {
/* 347 */     this.b = parama;
/*     */   }
/*     */   
/*     */   protected h.a a() {
/* 351 */     return this.b;
/*     */   }
/*     */   
/*     */   protected class a implements h.a {
/*     */     protected a(c this$0) {}
/*     */     
/*     */     public boolean lockRequestsBySessionControl(e param1e) throws Exception {
/* 358 */       String str = param1e.getData().toLowerCase();
/*     */       
/* 360 */       return (str.contains("sua sessão expirou") || str.contains("você não está habilitado") || str
/* 361 */         .contains("pregao.acesso.negado") || str.contains("pregao.sessao.expirada") || param1e
/* 362 */         .getStatusCode() == 401);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */