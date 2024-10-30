/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.c;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.Objects;
/*     */ import javax.swing.text.MaskFormatter;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.e.f;
/*     */ import org.e.i;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   extends i
/*     */ {
/*  39 */   private static final af d = af.a(10.0D);
/*     */   
/*     */   private static final String DOMAIN = "https://www1.compras.mg.gov.br/";
/*     */   
/*     */   private static final String bL = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/consulta/eletronico/$BIDDING?operacao=visualizar";
/*     */   private static final String bM = "https://www1.compras.mg.gov.br/servico/lei14133/proposta/consulta/recuperarDetalhes?id=%s&operacao=visualizar&idLote=%s";
/*     */   private static final String bN = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/recuperarLancesLote?idLote=";
/*  46 */   private static final String bI = String.join("", new CharSequence[] { "https://www1.compras.mg.gov.br/", "principal.html" });
/*     */   private static final String bO = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/lote/acoes/%s?operacao=visualizar";
/*     */   private static final String bP = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/atualizarLote?id=";
/*     */   private static final String bQ = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/chat/recuperarHistoricoChat?idProcedimento=";
/*  50 */   private static final String bJ = String.join("", new CharSequence[] { "https://www1.compras.mg.gov.br/", "j_acegi_security_check" });
/*     */   
/*     */   private static final String bR = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/lance";
/*     */   private static final String bS = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/lote/acoes/arquivosFornecedores?idLote=";
/*     */   private static final String bT = "https://www1.compras.mg.gov.br/j_acegi_logout";
/*     */   private static final String bU = "https://www1.compras.mg.gov.br/servico/captcha/dadosIniciais";
/*     */   private static final String bV = "https://www1.compras.mg.gov.br/servico/captcha/verificar";
/*     */   private static final String bW = "https://www1.compras.mg.gov.br/servico/captcha/pre-verificar";
/*     */   private a a;
/*     */   
/*     */   public e(d paramd) {
/*  61 */     a(paramd);
/*  62 */     a(e().a());
/*     */   }
/*     */   
/*     */   private c e() {
/*  66 */     return g.c()
/*  67 */       .a("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,application/json,*/*;q=0.8")
/*  68 */       .a("Accept-Encoding", "gzip,deflate,sdch")
/*  69 */       .a("Accept-Language", "en-US,en;q=0.8,pt-BR;q=0.6,pt;q=0.4")
/*  70 */       .a("Cache-Control", "no-cache")
/*  71 */       .a("Connection", "keep-alive")
/*     */       
/*  73 */       .a("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.132 Safari/537.36")
/*  74 */       .a("Pragma", "no-cache")
/*  75 */       .b(60000)
/*  76 */       .c(60000)
/*  77 */       .d(50)
/*  78 */       .e(150)
/*  79 */       .a(d);
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
/*     */   public int z() {
/*  98 */     boolean bool = false;
/*     */ 
/*     */     
/*     */     try {
/* 102 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 103 */       hashMap.put("j_username", as() + "|" + ax() + (a().aP() ? "|R|SSC" : "|R"));
/*     */       
/* 105 */       hashMap.put("j_password", getPassword());
/* 106 */       hashMap.put("cpfRep", as());
/* 107 */       hashMap.put("cnpjCpf", ax());
/* 108 */       hashMap.put("tipoLogin", "R");
/* 109 */       hashMap.put("matricula", "");
/* 110 */       hashMap.put("cpfRespMat", "");
/* 111 */       hashMap.put("unidade", "");
/* 112 */       hashMap.put("cnpjCpfResponsavel", "");
/*     */       
/* 114 */       String str = c().a(g.d().a(bJ).a(hashMap).b()).getData();
/*     */       
/* 116 */       if (str != null) {
/* 117 */         if (str.toLowerCase().contains("os dados digitados são inválidos")) {
/* 118 */           return 2;
/*     */         }
/*     */         
/* 121 */         Document document = Jsoup.parse(str);
/* 122 */         Elements elements = document.select("span[class=textcorpo]");
/*     */         
/* 124 */         if (elements != null && !elements.isEmpty()) {
/* 125 */           String str1 = elements.first().text();
/* 126 */           E(str1);
/* 127 */           bool = true;
/*     */           
/* 129 */           if (!ae()) {
/* 130 */             setRunning(true);
/* 131 */             cb();
/*     */             
/* 133 */             if (Objects.nonNull(this.a)) {
/* 134 */               this.a.interrupt();
/*     */             }
/*     */             
/* 137 */             this.a = new a(this, this);
/* 138 */             this.a.setName("SessionRenewerMG_" + getUser());
/* 139 */             this.a.start();
/*     */           } 
/*     */         } 
/*     */       } 
/* 143 */     } catch (Exception exception) {
/* 144 */       a.error("Failed login of the MG portal", exception);
/*     */     } 
/*     */     
/* 147 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/*     */     try {
/* 153 */       if (Objects.nonNull(this.a)) {
/* 154 */         this.a.interrupt();
/*     */       }
/* 156 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 159 */     i();
/* 160 */     super.b();
/*     */   }
/*     */   
/*     */   private br.com.arremate.h.e i() {
/* 164 */     return c().a(g.c().a("https://www1.compras.mg.gov.br/j_acegi_logout").b());
/*     */   }
/*     */   
/*     */   public void a(g paramg) {
/* 168 */     b(paramg);
/* 169 */     a(g.a(this, c(), parame -> {
/*     */             String str = parame.getData().toLowerCase();
/*     */             int j = parame.getStatusCode();
/*     */             return (j == 403) ? true : str.contains("user not authorized.");
/*     */           }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e a(br.com.arremate.l.k.a parama, double paramDouble, boolean paramBoolean) {
/*     */     try {
/*     */       DecimalFormat decimalFormat;
/* 185 */       if (paramBoolean) {
/* 186 */         decimalFormat = y.a("###,###,##0.0000");
/*     */       } else {
/* 188 */         decimalFormat = y.a("###,###,##0.00");
/*     */       } 
/* 190 */       String str = decimalFormat.format(paramDouble);
/*     */ 
/*     */       
/* 193 */       if (k.b()) {
/* 194 */         byte b = 0;
/*     */         do {
/* 196 */           i i1 = new i();
/*     */           
/* 198 */           i1.c("idLote", Integer.toString(parama.v()));
/* 199 */           i1.c("valorLance", str);
/* 200 */           i1.c("textoConfirmacaoCaptcha", "");
/*     */           
/* 202 */           br.com.arremate.h.e e1 = c().a(g.e().a("https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/lance").a(i1));
/* 203 */           i i2 = new i(e1.getData());
/*     */           
/* 205 */           if (!i2.getBoolean("necessidadeDesafioCaptcha")) {
/* 206 */             return e1;
/*     */           }
/* 208 */         } while (++b < 2 && !Y());
/*     */       } 
/* 210 */     } catch (Exception exception) {
/* 211 */       a.warn("Erro ao enviar lance", exception);
/*     */     } 
/*     */     
/* 214 */     return null;
/*     */   }
/*     */   
/*     */   private boolean Y() {
/* 218 */     a.info("Tentando resolver captcha");
/* 219 */     String str = at();
/* 220 */     if (str.isEmpty()) {
/* 221 */       a.warn("Sitekey não encontrado");
/* 222 */       return false;
/*     */     } 
/*     */     
/* 225 */     byte b1 = 5;
/* 226 */     byte b2 = 0;
/* 227 */     while (b2 < b1) {
/*     */       
/*     */       try {
/* 230 */         br.com.arremate.a.a.a a1 = j.a().a("https://www1.compras.mg.gov.br/", str);
/* 231 */         String str1 = a1.a();
/*     */         
/* 233 */         i i1 = (new i()).c("textoConfirmacao", str1);
/* 234 */         br.com.arremate.h.e e1 = c().a(
/* 235 */             g.e().a("https://www1.compras.mg.gov.br/servico/captcha/verificar").a(i1).b("Content-Type", "application/json"));
/*     */ 
/*     */         
/* 238 */         i i2 = new i(e1.getData());
/* 239 */         boolean bool = i2.getBoolean("sucesso");
/* 240 */         if (bool && !Z()) {
/* 241 */           a.info("Captcha broken successfully");
/* 242 */           return true;
/*     */         } 
/* 244 */       } catch (RuntimeException runtimeException) {
/* 245 */         a.warn("Failed attempt to break captcha. Attempt {}, {}", Integer.valueOf(b2), runtimeException.getMessage());
/*     */       } 
/*     */       
/* 248 */       b2++;
/*     */     } 
/*     */     
/* 251 */     return false;
/*     */   }
/*     */   
/*     */   private String at() {
/* 255 */     byte b1 = 5;
/* 256 */     byte b2 = 0;
/* 257 */     while (b2 < b1) {
/* 258 */       br.com.arremate.h.e e1 = c().a(g.c().a("https://www1.compras.mg.gov.br/servico/captcha/dadosIniciais"));
/* 259 */       if (!e(e1.getStatusCode())) {
/*     */         continue;
/*     */       }
/*     */       
/* 263 */       i i1 = new i(e1.getData());
/* 264 */       if (i1.has("siteKey") && !i1.getString("siteKey").isEmpty()) {
/* 265 */         return i1.getString("siteKey");
/*     */       }
/* 267 */       b2++;
/*     */     } 
/*     */     
/* 270 */     return "";
/*     */   }
/*     */   
/*     */   public boolean e(int paramInt) {
/* 274 */     return (paramInt >= 200 && paramInt < 300);
/*     */   }
/*     */   
/*     */   public boolean Z() {
/* 278 */     br.com.arremate.h.e e1 = c().a(g.c().a("https://www1.compras.mg.gov.br/servico/captcha/pre-verificar"));
/* 279 */     i i1 = new i(e1.getData());
/* 280 */     return i1.getBoolean("exibirCaptcha");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 285 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 290 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public br.com.arremate.h.e n(String paramString) {
/* 299 */     String str = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/consulta/eletronico/$BIDDING?operacao=visualizar".replace("$BIDDING", paramString);
/* 300 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e e(String paramString1, String paramString2) {
/* 304 */     String str = String.format("https://www1.compras.mg.gov.br/servico/lei14133/proposta/consulta/recuperarDetalhes?id=%s&operacao=visualizar&idLote=%s", new Object[] { paramString2, paramString1 });
/* 305 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e j(int paramInt) {
/* 309 */     String str = String.format("https://www1.compras.mg.gov.br/servico/procedimentolei14133/lote/acoes/%s?operacao=visualizar", new Object[] { Integer.valueOf(paramInt) });
/* 310 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e k(int paramInt) {
/* 314 */     String str = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/atualizarLote?id=" + paramInt;
/* 315 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e l(int paramInt) {
/* 319 */     String str = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/disputa/recuperarLancesLote?idLote=" + paramInt;
/* 320 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e m(int paramInt) {
/* 324 */     String str = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/lote/acoes/arquivosFornecedores?idLote=" + paramInt;
/* 325 */     return c().a(g.c().a(str));
/*     */   }
/*     */   
/*     */   public br.com.arremate.h.e b(int paramInt1, int paramInt2, int paramInt3) {
/* 329 */     String str = "https://www1.compras.mg.gov.br/servico/procedimentolei14133/chat/recuperarHistoricoChat?idProcedimento=" + paramInt1;
/* 330 */     i i1 = new i();
/* 331 */     i1.c("filtros", (new i()).c("lote", "Todos os lotes"));
/* 332 */     i1.c("ordenacoes", (new f()).a((new i())
/* 333 */           .c("sortName", "dataHoraEnvio").c("sortOrder", "desc")));
/* 334 */     i1.a("sizePerPage", paramInt3);
/* 335 */     i1.c("reqId", "");
/* 336 */     i1.a("page", paramInt2);
/* 337 */     return c().a(g.e().a(str).a(i1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 347 */     return A.a().p("https://www1.compras.mg.gov.br/");
/*     */   }
/*     */ 
/*     */   
/*     */   private void bV() {
/* 352 */     if (isRunning()) {
/* 353 */       c().a(g.c().a(bI).b());
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
/*     */   private String as() {
/*     */     String str;
/* 366 */     if (getUser().length() > 13) {
/* 367 */       return getUser();
/*     */     }
/*     */     
/*     */     try {
/* 371 */       str = StringUtils.leftPad(getUser(), 11, "0");
/*     */       
/* 373 */       MaskFormatter maskFormatter = new MaskFormatter("###.###.###-##");
/* 374 */       maskFormatter.setValueContainsLiteralCharacters(false);
/* 375 */       str = maskFormatter.valueToString(str);
/* 376 */     } catch (Exception exception) {
/* 377 */       str = "000.000.000-00";
/*     */     } 
/*     */     
/* 380 */     return str;
/*     */   }
/*     */   
/*     */   class a
/*     */     extends Thread {
/*     */     private final e a;
/*     */     
/*     */     a(e this$0, e param1e1) {
/* 388 */       this.a = param1e1;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 393 */       while (this.a.isRunning()) {
/*     */         try {
/* 395 */           sleep(50000L);
/* 396 */           e.a(this.a);
/* 397 */         } catch (InterruptedException interruptedException) {}
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */