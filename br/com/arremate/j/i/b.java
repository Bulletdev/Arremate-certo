/*     */ package br.com.arremate.j.i;
/*     */ 
/*     */ import br.com.a.a.a.c;
/*     */ import br.com.a.d.a.c;
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.h.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.impl.cookie.BasicClientCookie;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends i
/*     */ {
/*  33 */   private static final af d = af.a(4.0D);
/*     */   protected static final String DOMAIN = "https://licitacoes-e2.bb.com.br/";
/*  35 */   protected static final String ce = String.join("", new CharSequence[] { "https://licitacoes-e2.bb.com.br/", "aop-inter-estatico/" });
/*  36 */   protected static final String cu = String.join("", new CharSequence[] { "https://licitacoes-e2.bb.com.br/", "aop-inter-api/api/v1/" });
/*  37 */   protected static final String cv = String.join("", new CharSequence[] { "https://licitacoes-e2.bb.com.br/", "aop-fornecedor-api/" });
/*  38 */   protected static final String cw = String.join("", new CharSequence[] { cv, "licitacao/com-proposta/" });
/*  39 */   protected static final String cx = String.join("", new CharSequence[] { cu, "licitacao/carregar-dados-basicos/" });
/*  40 */   protected static final String cy = String.join("", new CharSequence[] { cu, "lote/carregar-lotes-licitacao/" });
/*  41 */   protected static final String cz = String.join("", new CharSequence[] { cu, "fornecedor/encontrar-licitacao-lote" });
/*  42 */   protected static final String cA = String.join("", new CharSequence[] { cu, "lance/carregar-licitacao-lote" });
/*  43 */   protected static final String cB = String.join("", new CharSequence[] { cu, "mensagem/encontrar" });
/*  44 */   protected static final String cC = String.join("", new CharSequence[] { cv, "lote/dados-proposta" });
/*  45 */   protected static final String cD = String.join("", new CharSequence[] { "https://licitacoes-e2.bb.com.br/", "aop-disputas-api/lance-lote/cadastrar" });
/*  46 */   protected static final String cE = String.join("", new CharSequence[] { "https://licitacoes-e2.bb.com.br/", "aop-disputas-api/disputas/lotes/fornecedor" });
/*     */   
/*     */   static final String SOCKET = "wss://licitacoes-e2.bb.com.br/aop-disputas-api/ws/disputas/456/gli0xh5l/websocket";
/*     */   
/*     */   private static final int DEFAULT_TIMEOUT = 60000;
/*     */   
/*  52 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*     */   private String authorization;
/*     */   
/*     */   private int aE;
/*  57 */   private final AtomicBoolean h = new AtomicBoolean(false);
/*     */   private h.a b;
/*     */   
/*     */   public b(d paramd) {
/*  61 */     a(paramd);
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
/*  74 */     c c = g.c().a("Accept", "application/json, text/plain, */*").a("Accept-Encoding", "gzip, deflate, br").a("Accept-Language", "pt-BR,pt;q=0.8,en-US;q=0.5,en;q=0.3").a("Connection", "keep-alive").a("Host", "licitacoes-e2.bb.com.br").a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:121.0) Gecko/20100101 Firefox/121.0").a("netscape").a(400).a(500).a(StandardCharsets.UTF_8).b(60000).d(25).e(100).a((af)d);
/*  75 */     a(c.a());
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/*  79 */     b(paramg);
/*  80 */     a(g.a(this, c(), this.b));
/*     */   }
/*     */ 
/*     */   
/*     */   public int z() {
/*  85 */     if (isRunning() && !ab()) {
/*  86 */       return 1;
/*     */     }
/*     */     
/*     */     try {
/*  90 */       c().bB();
/*     */       
/*  92 */       c c = new c();
/*  93 */       br.com.a.d.a a1 = new br.com.a.d.a((br.com.a.c.a)c);
/*     */       
/*  95 */       d d = a();
/*  96 */       i i1 = a1.f(d.getUser(), d.getPassword());
/*     */       
/*  98 */       this.authorization = "Bearer " + i1.getString("authorization");
/*  99 */       this.aE = i1.getInt("clientCode");
/*     */       
/* 101 */       f f = i1.c("cookies");
/* 102 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 103 */         i i2 = f.b(b1);
/*     */         
/* 105 */         BasicClientCookie basicClientCookie = new BasicClientCookie(i2.getString("name"), i2.getString("value"));
/* 106 */         basicClientCookie.setPath(i2.getString("path"));
/* 107 */         basicClientCookie.setDomain(i2.getString("domain"));
/* 108 */         c().addCookie((Cookie)basicClientCookie);
/*     */       } 
/*     */       
/* 111 */       String str = az();
/* 112 */       if (str.isEmpty()) {
/* 113 */         return 0;
/*     */       }
/*     */       
/* 116 */       d.aa(str);
/*     */       
/* 118 */       setRunning(true);
/* 119 */       cb();
/*     */       
/* 121 */       k(false);
/*     */       
/* 123 */       this.b = new a(this);
/* 124 */       return 1;
/* 125 */     } catch (c c) {
/* 126 */       a.error("Incorrect login data", (Throwable)c);
/* 127 */       return 2;
/* 128 */     } catch (Exception exception) {
/* 129 */       a.error("Failed login of the Licitações-e portal", exception);
/*     */ 
/*     */       
/* 132 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private String az() {
/* 138 */     String str1 = c().a(g.c().a("https://licitacoes-e2.bb.com.br/").a("aop-fornecedor-api/listar-autorizacao-usuario").b()).getData();
/*     */     
/* 140 */     i i1 = new i(str1);
/* 141 */     f f = i1.j("data").c("autorizacoes");
/* 142 */     if (f.isEmpty()) {
/* 143 */       return "";
/*     */     }
/*     */     
/* 146 */     String str2 = f.b(0).getString("descricao");
/* 147 */     return str2.substring(0, str2.indexOf("(")).trim();
/*     */   }
/*     */   
/*     */   public e p(int paramInt) {
/* 151 */     return c().a(g.c().a(cC).a("numeroLicitacao", paramInt).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e B(String paramString) {
/* 155 */     return c().a(g.c().a(cw).a("situacao/").a(paramString).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e q(int paramInt) {
/* 159 */     return c().a(g.c().a(cx).a(paramInt).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e h(int paramInt1, int paramInt2) {
/* 163 */     i i1 = (new i()).a("numeroLicitacao", paramInt1).a("primeiroItem", paramInt2);
/* 164 */     return c().a(g.e().a(cy).a(i1).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e i(int paramInt1, int paramInt2) {
/* 168 */     i i1 = (new i()).a("numeroLicitacao", paramInt1).a("codigoLote", paramInt2);
/* 169 */     return c().a(g.e().a(cz).a(i1).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e j(int paramInt1, int paramInt2) {
/* 173 */     i i1 = (new i()).a("numeroLicitacao", paramInt1).a("codigoLote", paramInt2);
/* 174 */     return c().a(g.e().a(cA).a(i1).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e k(int paramInt1, int paramInt2) {
/* 178 */     i i1 = (new i()).a("numeroLicitacao", paramInt1).a("codigoLote", paramInt2);
/* 179 */     return c().a(g.e().a(cB).a(i1).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e o() {
/* 183 */     return c().a(g.c().a(cE).a("codigoFornecedor", this.aE).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e r(int paramInt) {
/* 187 */     return c().a(g.c().a(cE).a("codigoFornecedor", this.aE).a("pagina", paramInt).b("Authorization", this.authorization));
/*     */   }
/*     */   
/*     */   public e a(int paramInt, String paramString, double paramDouble) {
/* 191 */     i i1 = new i();
/* 192 */     i1.a("numeroLicitacao", paramInt);
/* 193 */     i1.a("numeroLote", Integer.parseInt(paramString));
/* 194 */     i1.a("valorLanceLote", paramDouble);
/*     */     
/* 196 */     if (k.b()) {
/* 197 */       return c().a(g.e().a(cD).a(i1).b("Authorization", this.authorization));
/*     */     }
/* 199 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 205 */     return A.a().p(ce);
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 210 */     if (ae() || c.a().a(this)) {
/* 211 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   int A() {
/* 216 */     return this.d.get();
/*     */   }
/*     */   
/*     */   void bJ() {
/* 220 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   void bK() {
/* 224 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 229 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 234 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   final c d() {
/* 240 */     return g.c().b(60000).a(302).d(50).e(300).a((af)d).a("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String aF() {
/* 246 */     return this.authorization;
/*     */   }
/*     */   
/*     */   public int C() {
/* 250 */     return this.aE;
/*     */   }
/*     */   
/*     */   public AtomicBoolean b() {
/* 254 */     return this.h;
/*     */   }
/*     */   
/*     */   public void k(boolean paramBoolean) {
/* 258 */     this.h.set(paramBoolean);
/*     */   }
/*     */   
/*     */   protected void a(h.a parama) {
/* 262 */     this.b = parama;
/*     */   }
/*     */   
/*     */   protected h.a a() {
/* 266 */     return this.b;
/*     */   }
/*     */   
/*     */   protected class a implements h.a {
/*     */     protected a(b this$0) {}
/*     */     
/*     */     public boolean lockRequestsBySessionControl(e param1e) throws Exception {
/* 273 */       String str = param1e.getData().toLowerCase();
/*     */       
/* 275 */       return str.contains("sessão expirada");
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\i\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */