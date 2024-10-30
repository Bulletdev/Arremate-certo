/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.h.g;
/*     */ import br.com.arremate.l.h.a;
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
/*     */ public class c
/*     */   extends i
/*     */ {
/*     */   private static final String DOMAIN = "https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/";
/*     */   private static final String bG = "https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/efetuarLance.htm";
/*     */   private static final String bH = "https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/AtualizarLance.htm";
/*     */   private final b a;
/*     */   
/*     */   public c(b paramb) {
/*  29 */     a(paramb.a());
/*  30 */     this.a = paramb;
/*     */     
/*  32 */     a(this.a
/*  33 */         .c()
/*  34 */         .a("Origin", "https://www.siga.es.gov.br")
/*  35 */         .a("Sec-Fetch-Dest", "empty")
/*  36 */         .a("Sec-Fetch-Mode", "cors")
/*  37 */         .a("Sec-Fetch-Site", "same-origin")
/*  38 */         .a("X-Prototype-Version", "1.6.0.2")
/*  39 */         .a("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:107.0) Gecko/20100101 Firefox/107.0")
/*  40 */         .a("X-Requested-With", "XMLHttpRequest")
/*  41 */         .a());
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
/*  61 */     boolean bool = false;
/*     */     
/*     */     try {
/*  64 */       c().bB();
/*  65 */       bU();
/*     */       
/*  67 */       if (c().P().contains(".jboss")) {
/*  68 */         setRunning(true);
/*  69 */         bool = true;
/*     */       } 
/*  71 */     } catch (Exception exception) {
/*  72 */       a.error("Falha ao realizar login", exception);
/*     */     } 
/*     */     
/*  75 */     return bool;
/*     */   }
/*     */   
/*     */   private void bU() {
/*  79 */     String str1 = this.a.ar();
/*  80 */     e e = this.a.l(str1);
/*     */     
/*  82 */     String str2 = ((Header)Arrays.<Header>asList(e.a()).stream().filter(paramHeader -> paramHeader.getName().equals("Location")).findFirst().get()).getValue();
/*  83 */     c().a(g.c().a(str2).a());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String f(int paramInt) {
/*  90 */     return c().a(g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitDetalharPregaoLicitante.htm").a("idPregao", paramInt)).getData();
/*     */   }
/*     */   
/*     */   public e e(int paramInt, String paramString) {
/*  94 */     e e = c().a(
/*  95 */         g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitLanceLicitante.htm").a("idPregao", paramInt));
/*     */ 
/*     */     
/*  98 */     if (!e.O()) {
/*  99 */       long l = e.k();
/* 100 */       e = c().a(g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/AtualizarLance.htm").a("idPregao", paramInt).a("lotesLances", paramString));
/* 101 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 104 */     return e;
/*     */   }
/*     */   
/*     */   public e f(int paramInt, String paramString) {
/* 108 */     e e = c().a(
/* 109 */         g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitAbrirVistasLicitante.htm").a("idPregao", paramInt));
/*     */     
/* 111 */     if (!e.O()) {
/* 112 */       long l = e.k();
/* 113 */       e = c().a(g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLanceVistas.htm")
/* 114 */           .a("idPregao", paramInt).a("lotesLances", paramString));
/* 115 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 118 */     return e;
/*     */   }
/*     */   
/*     */   public e g(int paramInt, String paramString) {
/* 122 */     e e = c().a(
/* 123 */         g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitHabAdjLicitante.htm")
/* 124 */         .a("idPregao", paramInt)
/* 125 */         .a("fasePage", "HABILITA%C7%C3O"));
/*     */ 
/*     */     
/* 128 */     if (!e.O()) {
/* 129 */       long l = e.k();
/* 130 */       e = c().a(g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesHabAdj.htm")
/* 131 */           .a("idPregao", paramInt).a("lotesLances", paramString).a("faseAtual", "HABILITAÇÃO"));
/* 132 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 135 */     return e;
/*     */   }
/*     */   
/*     */   public e h(int paramInt, String paramString) {
/* 139 */     e e = c().a(
/* 140 */         g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitRecursoPageForm.htm").a("idPregao", paramInt));
/*     */     
/* 142 */     if (!e.O()) {
/* 143 */       long l = e.k();
/* 144 */       e = c().a(g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesRecurso.htm")
/* 145 */           .a("idPregao", paramInt).a("lotesLances", paramString));
/* 146 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 149 */     return e;
/*     */   }
/*     */   
/*     */   public e i(int paramInt, String paramString) {
/* 153 */     e e = c().a(
/* 154 */         g.c().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("InitHabAdjLicitante.htm")
/* 155 */         .a("idPregao", paramInt)
/* 156 */         .a("fasePage", "ADJUDICACAO"));
/*     */ 
/*     */     
/* 159 */     if (!e.O()) {
/* 160 */       long l = e.k();
/* 161 */       e = c().a(g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/").a("AtualizarLotesHabAdj.htm")
/* 162 */           .a("idPregao", paramInt).a("lotesLances", paramString).a("faseAtual", "ADJUDICAÇÃO"));
/* 163 */       e.q(e.k() + l);
/*     */     } 
/*     */     
/* 166 */     return e;
/*     */   }
/*     */   
/*     */   public String a(a parama, String paramString) {
/* 170 */     if (!k.b()) {
/* 171 */       return "";
/*     */     }
/*     */     
/* 174 */     return c().a(
/* 175 */         g.d().a("https://www.siga.es.gov.br/SgcPregao/priv/sgc/pregao/licitante/efetuarLance.htm")
/* 176 */         .a("idPregao", parama.a().v())
/* 177 */         .a("idLote", parama.v())
/* 178 */         .a("valorLance", paramString))
/* 179 */       .getData();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean T() {
/* 189 */     return A.a().p("https://portalsiga.es.gov.br");
/*     */   }
/*     */   
/*     */   public String C(String paramString) {
/* 193 */     Document document = Jsoup.parse(paramString);
/* 194 */     return document.select("input[id=javax.faces.ViewState]").first().val();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected String a(String paramString, x paramx) {
/* 200 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx) {
/* 205 */     throw new UnsupportedOperationException("Not supported yet.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */