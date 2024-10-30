/*     */ package br.com.arremate.j.d;
/*     */ 
/*     */ import br.com.a.a.a.b;
/*     */ import br.com.a.c.a;
/*     */ import br.com.a.c.b;
/*     */ import br.com.a.d.a;
/*     */ import br.com.a.d.a.b;
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i.a.a;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.y;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.protocol.HttpClientContext;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.impl.cookie.BasicClientCookie;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   extends b
/*     */ {
/*  28 */   private static final String cf = String.join("", new CharSequence[] { "https://www.licitacoes-e.com.br/", "multisalas/disputa/manipularDisputa.action" });
/*  29 */   private static final String cg = String.join("", new CharSequence[] { "https://www.licitacoes-e.com.br/", "multisalas/disputa/acompanhar.action" });
/*     */   
/*     */   private static final int ay = 0;
/*     */   
/*     */   private static final int az = 6;
/*     */   private static final int aA = 12;
/*     */   private static final int aB = 99;
/*     */   private final a a;
/*     */   private final HttpClientContext a;
/*     */   private String authorization;
/*     */   
/*     */   public c(d paramd, boolean paramBoolean) {
/*  41 */     super(paramd, paramBoolean);
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
/*  56 */     br.com.arremate.h.c c1 = e().a("Accept", "application/json, text/plain, */*").a("Accept-Encoding", "gzip, deflate, br").a("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7").a("Connection", "keep-alive").a("Content-Type", "application/json;charset=UTF-8").a("disputav2", "true").a("Host", "www.licitacoes-e.com.br").a("mudar-redirect-para", "278").a("Origin", "https://www.licitacoes-e.com.br").a("Referer", "https://www.licitacoes-e.com.br/multisalas/app/disputa/disputa.app.html").a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36").a(302).a(278);
/*     */     
/*  58 */     a(g.a(this, c1
/*  59 */           .a(), parame -> {
/*     */             if (parame.getStatusCode() == 278) {
/*     */               if (!ad()) {
/*     */                 return true;
/*     */               }
/*     */ 
/*     */               
/*     */               b();
/*     */             } 
/*     */ 
/*     */             
/*     */             return false;
/*     */           }));
/*     */     
/*  73 */     i(false);
/*     */     
/*  75 */     this.a = (HttpClientContext)new a(this);
/*     */     
/*  77 */     this.a = new HttpClientContext();
/*  78 */     this.a.setRequestConfig(RequestConfig.custom()
/*  79 */         .setConnectionRequestTimeout(30000)
/*  80 */         .setConnectTimeout(30000)
/*  81 */         .setSocketTimeout(30000)
/*  82 */         .build());
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized int z() {
/*  87 */     if (isRunning() && !ab()) {
/*  88 */       return 1;
/*     */     }
/*     */     
/*     */     try {
/*  92 */       c().bB();
/*     */       
/*  94 */       d d = a();
/*  95 */       b b1 = new b((b)new a());
/*  96 */       a a1 = new a((a)b1);
/*     */       
/*  98 */       i i = a1.f(d.getUser(), d.getPassword());
/*     */       
/* 100 */       if (i != null && i.has("cookies") && !i.isNull("cookies") && i.has("authorization") && !i.isNull("authorization")) {
/* 101 */         f f = i.c("cookies");
/*     */         
/* 103 */         for (byte b2 = 0; b2 < f.length(); b2++) {
/* 104 */           i i1 = f.b(b2);
/* 105 */           BasicClientCookie basicClientCookie = new BasicClientCookie(i1.getString("name"), i1.getString("value"));
/* 106 */           basicClientCookie.setPath(i1.getString("path"));
/* 107 */           basicClientCookie.setDomain(i1.getString("domain"));
/* 108 */           c().addCookie((Cookie)basicClientCookie);
/*     */         } 
/*     */         
/* 111 */         this.authorization = i.getString("authorization");
/*     */         
/* 113 */         String str = aA();
/* 114 */         if (str != null && !str.isEmpty()) {
/* 115 */           if (str.charAt(0) == '{') {
/* 116 */             i i1 = new i(str);
/* 117 */             if (!i1.isNull("autorizacao")) {
/* 118 */               d.aa(i1.j("autorizacao").getString("nomeCliente"));
/*     */             }
/*     */           } 
/*     */           
/* 122 */           if (this.authorization != null && !this.authorization.isEmpty()) {
/* 123 */             setRunning(true);
/* 124 */             cb();
/*     */             
/* 126 */             return 1;
/*     */           } 
/* 128 */           a.warn("Falha ao conseguir autorização na sala de disputa do Licitações-e");
/*     */         }
/*     */       
/*     */       } 
/* 132 */     } catch (b b1) {
/* 133 */       a.error("Incorrect bidding login data", (Throwable)b1);
/* 134 */       return 2;
/* 135 */     } catch (Exception exception) {
/* 136 */       a.error("Failed bidding login of the Licitações-e portal", exception);
/*     */     } 
/*     */     
/* 139 */     return 0;
/*     */   }
/*     */   
/*     */   private String aA() {
/* 143 */     a.debug("[{}] Enter the dispute room", getClass().getName());
/*     */     
/* 145 */     if (this.authorization.isEmpty()) {
/* 146 */       return "";
/*     */     }
/*     */     
/* 149 */     i i = new i();
/* 150 */     i.b("atualizarListaLicitacoes", true);
/* 151 */     i.c("class", "br.com.bb.aop.sala.base.SalaDisputaRequisicao");
/* 152 */     i.a("codigoComando", 0);
/* 153 */     i.c("comunicados", i.NULL);
/* 154 */     i.c("disputas", i.NULL);
/* 155 */     i.c("salaDisputaLotePK", i.NULL);
/* 156 */     i.c("textoAutorizacaoLance", i.NULL);
/* 157 */     i.c("textoDesafio", i.NULL);
/* 158 */     i.c("textoMensagem", i.NULL);
/* 159 */     i.c("textoValorLance", i.NULL);
/* 160 */     i.b("ignoreLoadingBar", true);
/* 161 */     i.c("autorizacao", this.authorization);
/*     */     
/* 163 */     return c().a(g.e().a(cf).a(i).a().b()).getData();
/*     */   }
/*     */   
/*     */   public void cd() {
/* 167 */     this.a.start();
/*     */   }
/*     */   
/*     */   public i p() {
/* 171 */     return this.a.o();
/*     */   }
/*     */   
/*     */   public long n() {
/* 175 */     return this.a.m();
/*     */   }
/*     */   
/*     */   public long o() {
/* 179 */     return this.a.g();
/*     */   }
/*     */   
/*     */   String aB() {
/* 183 */     i i = new i();
/* 184 */     i.b("atualizarListaLicitacoes", true);
/* 185 */     i.c("autorizacao", this.authorization);
/* 186 */     i.c("class", "br.com.bb.aop.sala.base.SalaDisputaRequisicao");
/* 187 */     i.a("codigoComando", 99);
/* 188 */     i.c("comunicados", i.NULL);
/* 189 */     i.c("disputas", new f());
/* 190 */     i.c("ignoreLoadingBar", i.NULL);
/* 191 */     i.c("salaDisputaLotePK", i.NULL);
/* 192 */     i.c("textoAutorizacaoLance", i.NULL);
/* 193 */     i.c("textoDesafio", i.NULL);
/* 194 */     i.c("textoMensagem", i.NULL);
/* 195 */     i.c("textoValorLance", i.NULL);
/*     */     
/* 197 */     return c().a(
/* 198 */         g.e().a(cg)
/* 199 */         .a(i)
/* 200 */         .a((HttpContext)this.a)
/* 201 */         .a())
/* 202 */       .getData();
/*     */   }
/*     */   
/*     */   String aC() {
/* 206 */     i i = new i();
/* 207 */     i.b("atualizarListaLicitacoes", true);
/* 208 */     i.c("class", "br.com.bb.aop.sala.base.SalaDisputaRequisicao");
/* 209 */     i.a("codigoComando", 12);
/* 210 */     i.c("comunicados", i.NULL);
/* 211 */     i.c("disputas", new f());
/* 212 */     i.c("salaDisputaLotePK", i.NULL);
/* 213 */     i.c("textoAutorizacaoLance", i.NULL);
/* 214 */     i.c("textoDesafio", i.NULL);
/* 215 */     i.c("textoMensagem", i.NULL);
/* 216 */     i.c("textoValorLance", i.NULL);
/* 217 */     i.c("autorizacao", this.authorization);
/*     */     
/* 219 */     return c().a(
/* 220 */         g.e().a(cf)
/* 221 */         .a(i)
/* 222 */         .a((HttpContext)this.a)
/* 223 */         .a())
/* 224 */       .getData();
/*     */   }
/*     */   
/*     */   public String a(i parami, double paramDouble, String paramString) {
/* 228 */     i i1 = new i();
/* 229 */     i1.b("atualizarListaLicitacoes", false);
/* 230 */     i1.c("class", "br.com.bb.aop.sala.base.SalaDisputaRequisicao");
/* 231 */     i1.a("codigoComando", 6);
/* 232 */     i1.c("comunicados", i.NULL);
/* 233 */     i1.c("disputas", i.NULL);
/* 234 */     i1.c("respostaCaptcha", paramString);
/* 235 */     i1.c("salaDisputaLotePK", parami);
/* 236 */     i1.c("textoAutorizacaoLance", i.NULL);
/* 237 */     i1.c("textoDesafio", i.NULL);
/* 238 */     i1.c("textoMensagem", i.NULL);
/* 239 */     i1.c("textoValorLance", i.NULL);
/* 240 */     i1.c("textoValorLanceNovaSala", y.a("###,###,##0.00").format(paramDouble));
/* 241 */     i1.c("autorizacao", this.authorization);
/*     */     
/* 243 */     return k.b() ? 
/* 244 */       c().a(
/* 245 */         g.e().a("https://www.licitacoes-e.com.br/").a("multisalas/disputa/enviarlance.action").a(i1).a())
/* 246 */       .getData() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String au() {
/* 252 */     return "login da sala de disputa";
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 257 */     if (ad() || d.a().a(this))
/*     */       try {
/* 259 */         if (this.a != null) {
/* 260 */           this.a.stop();
/*     */         }
/*     */         
/* 263 */         setRunning(false);
/* 264 */         if (c() != null) {
/* 265 */           c().b();
/*     */         }
/* 267 */       } catch (Exception exception) {
/* 268 */         a.warn("Erro ao finalizar httpclient", exception);
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\d\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */