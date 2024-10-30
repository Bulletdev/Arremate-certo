/*     */ package br.com.arremate.j.d;
/*     */ 
/*     */ import br.com.a.a.a.a;
/*     */ import br.com.a.c.a;
/*     */ import br.com.a.d.a;
/*     */ import br.com.a.d.a.c;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import com.google.a.o.a.af;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.impl.cookie.BasicClientCookie;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends i
/*     */ {
/*  30 */   private static final af d = af.a(4.0D);
/*     */   
/*     */   protected static final String DOMAIN = "https://www.licitacoes-e.com.br/";
/*  33 */   protected static final String cd = String.join("", new CharSequence[] { "https://www.licitacoes-e.com.br/", "aop/captchaServletAux.png" });
/*  34 */   protected static final String ce = String.join("", new CharSequence[] { "https://www.licitacoes-e.com.br/", "aop/index.jsp" });
/*     */   
/*  36 */   private final AtomicInteger d = new AtomicInteger(1);
/*     */   
/*     */   public b(d paramd, boolean paramBoolean) {
/*  39 */     a(paramd);
/*     */     
/*  41 */     if (paramBoolean) {
/*  42 */       a(e().a());
/*     */     } else {
/*  44 */       bH();
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
/*     */   protected final c e() {
/*  56 */     return g.c().a("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7").a("Accept-Encoding", "gzip, deflate, br").a("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7").a("Connection", "keep-alive").a("Host", "www.licitacoes-e.com.br").a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/111.0.0.0 Safari/537.36").b(60000).d(50).e(150).a((af)d);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void bH() {
/*  62 */     a(g.a(this, e().a(), parame -> {
/*     */             String str = parame.getData();
/*     */ 
/*     */             
/*  66 */             boolean bool = (str.contains("src=\"https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit\"") && str.contains("<input type=\"submit\" value=\"Continuar\">"));
/*     */ 
/*     */             
/*     */             if (!bool) {
/*  70 */               bool = (str.contains("Digite os caracteres abaixo para continuar:") && str.contains(cd));
/*     */             }
/*     */             
/*     */             if (bool) {
/*     */               String str1 = az();
/*     */               
/*     */               bool = str1.isEmpty();
/*     */             } 
/*     */             
/*  79 */             return (str.contains("Usuário não se encontra autenticado") || bool);
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int z() {
/*  91 */     if (isRunning() && !ab()) {
/*  92 */       return 1;
/*     */     }
/*     */     
/*     */     try {
/*  96 */       c().bB();
/*     */       
/*  98 */       d d = a();
/*     */       
/* 100 */       a a = new a();
/* 101 */       a a1 = new a((a)a);
/* 102 */       i i1 = a1.f(d.getUser(), d.getPassword());
/*     */       
/* 104 */       if (i1 != null && i1.has("cookies") && !i1.isNull("cookies")) {
/* 105 */         f f = i1.c("cookies");
/*     */         
/* 107 */         for (byte b1 = 0; b1 < f.length(); b1++) {
/* 108 */           i i2 = f.b(b1);
/* 109 */           BasicClientCookie basicClientCookie = new BasicClientCookie(i2.getString("name"), i2.getString("value"));
/* 110 */           basicClientCookie.setPath(i2.getString("path"));
/* 111 */           basicClientCookie.setDomain(i2.getString("domain"));
/* 112 */           c().addCookie((Cookie)basicClientCookie);
/*     */         } 
/*     */         
/* 115 */         String str = az();
/* 116 */         if (!str.isEmpty()) {
/* 117 */           d.aa(str);
/*     */           
/* 119 */           setRunning(true);
/* 120 */           cb();
/*     */           
/* 122 */           return 1;
/*     */         } 
/*     */       } 
/* 125 */     } catch (c c) {
/* 126 */       a.error("Incorrect login data", (Throwable)c);
/* 127 */       return 2;
/* 128 */     } catch (Exception exception) {
/* 129 */       a.error("Failed login of the Licitações-e portal", exception);
/*     */     } 
/*     */     
/* 132 */     return 0;
/*     */   }
/*     */   
/*     */   private String az() {
/* 136 */     e e = c().a(g.c().a("https://www.licitacoes-e.com.br/").a("aop/index2.jsp").b());
/* 137 */     String str = e.getData();
/* 138 */     if (!str.isEmpty()) {
/* 139 */       Document document = Jsoup.parse(str);
/* 140 */       Element element = document.select("div.textoPequeno").first();
/* 141 */       if (element != null) {
/* 142 */         String str1 = element.html().split("<br>")[0].trim().replaceAll("&amp;", "&");
/* 143 */         str1 = str1.replace(String.format("[%s]", new Object[] { a().getUser() }), "").trim();
/* 144 */         return str1;
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public e b(int paramInt1, int paramInt2) {
/* 155 */     return c().a(
/* 156 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/consultar-detalhes-licitacao.aop")
/* 157 */         .a("opcao", "consultarDadosDisputaLote")
/* 158 */         .a("numeroLicitacao", paramInt1)
/* 159 */         .a("numeroLote", paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public e c(int paramInt1, int paramInt2) {
/* 164 */     return e(Integer.toString(paramInt1), paramInt2);
/*     */   }
/*     */   
/*     */   public e e(String paramString, int paramInt) {
/* 168 */     return c().a(
/* 169 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-lotes.aop")
/* 170 */         .a("opcao", "listarLotesPreCaptcha")
/* 171 */         .a("numeroLicitacao", paramString)
/* 172 */         .a("numeroLoteInicial", paramInt)
/* 173 */         .a("numeroLoteFinal", paramInt)
/* 174 */         .a("question", ""));
/*     */   }
/*     */ 
/*     */   
/*     */   public String b(int paramInt1, int paramInt2, int paramInt3) {
/* 179 */     return c().a(
/* 180 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/consultar-lance-lote.aop")
/* 181 */         .a("opcao", "consultar")
/* 182 */         .a("id-licitacao", paramInt1)
/* 183 */         .a("idLoteInicial", paramInt2)
/* 184 */         .a("idLoteFinal", paramInt3))
/* 185 */       .getData();
/*     */   }
/*     */   
/*     */   public String b(int paramInt1, int paramInt2) {
/* 189 */     return c().a(
/* 190 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-lance-lote.aop")
/* 191 */         .a("opcao", "listarPropostasPreCaptcha")
/* 192 */         .a("numeroLicitacao", paramInt1)
/* 193 */         .a("numeroLote", paramInt2))
/* 194 */       .getData();
/*     */   }
/*     */   
/*     */   public String c(String paramString, int paramInt) {
/* 198 */     return c(Integer.parseInt(paramString), paramInt);
/*     */   }
/*     */   
/*     */   public String c(int paramInt1, int paramInt2) {
/* 202 */     return c().a(
/* 203 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-lotes.aop")
/* 204 */         .a("opcao", "listarLotesPosCaptcha")
/* 205 */         .a("numeroLicitacao", paramInt1)
/* 206 */         .a("numeroLoteInicial", paramInt2)
/* 207 */         .a("numeroLoteFinal", paramInt2)
/* 208 */         .a("question", "undefined"))
/* 209 */       .getData();
/*     */   }
/*     */   
/*     */   public e d(int paramInt1, int paramInt2) {
/* 213 */     return c().a(
/* 214 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-lotes.aop")
/* 215 */         .a("opcao", "consultarHistoricoDisputaPreCaptcha")
/* 216 */         .a("numeroLicitacao", paramInt1)
/* 217 */         .a("numeroLote", paramInt2));
/*     */   }
/*     */ 
/*     */   
/*     */   public String L(String paramString) {
/* 222 */     return c().a(
/* 223 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-licitacoes-fornecedor.aop")
/* 224 */         .a("opcao", "listarLicitacoesFornecedor")
/* 225 */         .a("codigoTipoEstadoLicitacao", paramString))
/* 226 */       .getData();
/*     */   }
/*     */   
/*     */   public e e(int paramInt) {
/* 230 */     return t(Integer.toString(paramInt));
/*     */   }
/*     */   
/*     */   public e t(String paramString) {
/* 234 */     return c().a(
/* 235 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/consultar-detalhes-licitacao.aop")
/* 236 */         .a("opcao", "exibirDetalhesLicitacao")
/* 237 */         .a("numeroLicitacao", paramString));
/*     */   }
/*     */ 
/*     */   
/*     */   public String h(int paramInt) {
/* 242 */     return c().a(
/* 243 */         g.c().a("https://www.licitacoes-e.com.br/").a("aop/listar-texto-mensagem-participante.aop")
/* 244 */         .a("opcao", "listarTextoMensagemParticipantes")
/* 245 */         .a("numeroLicitacao", paramInt))
/* 246 */       .getData();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 251 */     return A.a().p(ce);
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/* 256 */     if (ae() || d.a().a(this)) {
/* 257 */       super.b();
/*     */     }
/*     */   }
/*     */   
/*     */   int A() {
/* 262 */     return this.d.get();
/*     */   }
/*     */   
/*     */   void bJ() {
/* 266 */     this.d.incrementAndGet();
/*     */   }
/*     */   
/*     */   void bK() {
/* 270 */     this.d.decrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 275 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 280 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\d\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */