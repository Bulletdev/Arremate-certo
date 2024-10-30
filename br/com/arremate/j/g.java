/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.l.l.a;
/*     */ import br.com.arremate.m.A;
/*     */ import java.util.Arrays;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.NameValuePair;
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
/*     */ 
/*     */ public class g
/*     */   extends i
/*     */ {
/*     */   private static final String DOMAIN = "http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/";
/*     */   private static final String bG = "http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/efetuarLance.htm";
/*     */   private static final String bH = "http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/AtualizarLance.htm";
/*     */   private final f a;
/*     */   
/*     */   public g(f paramf) {
/*  31 */     a(paramf.a());
/*  32 */     this.a = paramf;
/*     */     
/*  34 */     a(this.a
/*  35 */         .c()
/*  36 */         .a("Origin", "https://aquisicoes.seplag.mt.gov.br")
/*  37 */         .a("Sec-Fetch-Dest", "empty")
/*  38 */         .a("Sec-Fetch-Mode", "cors")
/*  39 */         .a("Sec-Fetch-Site", "same-origin")
/*  40 */         .a("X-Prototype-Version", "1.6.0.2")
/*  41 */         .a("X-Requested-With", "XMLHttpRequest")
/*  42 */         .a());
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
/*     */   public int z() {
/*  62 */     boolean bool = false;
/*     */     
/*     */     try {
/*  65 */       c().bB();
/*  66 */       bU();
/*     */       
/*  68 */       if (c().P().contains(".jboss")) {
/*  69 */         setRunning(true);
/*  70 */         bool = true;
/*     */       } 
/*  72 */     } catch (Exception exception) {
/*  73 */       a.error("Falha ao realizar login", exception);
/*     */     } 
/*     */     
/*  76 */     return bool;
/*     */   }
/*     */   
/*     */   private void bU() {
/*  80 */     String str1 = this.a.ar();
/*  81 */     e e = this.a.l(str1);
/*     */     
/*  83 */     String str2 = ((Header)Arrays.<Header>asList(e.a()).stream().filter(paramHeader -> paramHeader.getName().equals("Location")).findFirst().get()).getValue();
/*  84 */     c().a(br.com.arremate.h.g.c().a(str2).a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String f(int paramInt) {
/*  92 */     return c().a(br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitDetalharPregaoLicitante.htm").a("idPregao", paramInt)).getData();
/*     */   }
/*     */   
/*     */   public e e(int paramInt, String paramString) {
/*  96 */     e e = c().a(
/*  97 */         br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitLanceLicitante.htm").a("idPregao", paramInt));
/*     */ 
/*     */     
/* 100 */     if (!e.O()) {
/* 101 */       long l = e.k();
/* 102 */       e = c().a(br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/AtualizarLance.htm").a("idPregao", paramInt).a("lotesLances", paramString));
/* 103 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 106 */     return e;
/*     */   }
/*     */   
/*     */   public e f(int paramInt, String paramString) {
/* 110 */     e e = c().a(
/* 111 */         br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitAbrirVistasLicitante.htm").a("idPregao", paramInt));
/*     */     
/* 113 */     if (!e.O()) {
/* 114 */       long l = e.k();
/* 115 */       e = c().a(br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLanceVistas.htm")
/* 116 */           .a("idPregao", paramInt).a("lotesLances", paramString));
/* 117 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 120 */     return e;
/*     */   }
/*     */   
/*     */   public e g(int paramInt, String paramString) {
/* 124 */     e e = c().a(
/* 125 */         br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitHabAdjLicitante.htm")
/* 126 */         .a("idPregao", paramInt)
/* 127 */         .a("fasePage", "HABILITACAO"));
/*     */ 
/*     */     
/* 130 */     if (!e.O()) {
/* 131 */       long l = e.k();
/* 132 */       e = c().a(br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesHabAdj.htm")
/* 133 */           .a("idPregao", paramInt).a("lotesLances", paramString).a("faseAtual", "HABILITAÇÃO"));
/* 134 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 137 */     return e;
/*     */   }
/*     */   
/*     */   public e h(int paramInt, String paramString) {
/* 141 */     e e = c().a(
/* 142 */         br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitRecursoPageForm.htm").a("idPregao", paramInt));
/*     */     
/* 144 */     if (!e.O()) {
/* 145 */       long l = e.k();
/* 146 */       e = c().a(br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesRecurso.htm")
/* 147 */           .a("idPregao", paramInt).a("lotesLances", paramString));
/* 148 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 151 */     return e;
/*     */   }
/*     */   
/*     */   public e i(int paramInt, String paramString) {
/* 155 */     e e = c().a(
/* 156 */         br.com.arremate.h.g.c().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitHabAdjLicitante.htm")
/* 157 */         .a("idPregao", paramInt)
/* 158 */         .a("fasePage", "ADJUDICACAO"));
/*     */ 
/*     */     
/* 161 */     if (!e.O()) {
/* 162 */       long l = e.k();
/* 163 */       e = c().a(br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesHabAdj.htm")
/* 164 */           .a("idPregao", paramInt).a("lotesLances", paramString).a("faseAtual", "ADJUDICAÇÃO"));
/* 165 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 168 */     return e;
/*     */   }
/*     */   
/*     */   public String a(a parama, String paramString) {
/* 172 */     if (!k.b()) {
/* 173 */       return "";
/*     */     }
/*     */     
/* 176 */     return c().a(
/* 177 */         br.com.arremate.h.g.d().a("http://aquisicoes.seplag.mt.gov.br/SgcPregao/priv/sgc/pregao/licitante/efetuarLance.htm")
/* 178 */         .a("idPregao", parama.a().v())
/* 179 */         .a("idLote", parama.v())
/* 180 */         .a("valorLance", paramString))
/* 181 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 191 */     return A.a().p("http://aquisicoes.seplag.mt.gov.br/");
/*     */   }
/*     */   
/*     */   public String C(String paramString) {
/* 195 */     Document document = Jsoup.parse(paramString);
/* 196 */     return document.select("input[id=javax.faces.ViewState]").first().val();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 202 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 207 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */