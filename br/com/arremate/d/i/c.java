/*     */ package br.com.arremate.d.i;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.e;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import com.google.a.o.a.af;
/*     */ import java.net.URLDecoder;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends g
/*     */ {
/*  40 */   private static final af d = af.a(1.0D);
/*     */   
/*     */   protected final ExecutorService executor;
/*     */   
/*     */   protected final Map<Integer, Future> p;
/*     */   
/*     */   protected final Map<Integer, b> q;
/*     */   private String ac;
/*     */   private String ad;
/*     */   private String ae;
/*     */   private int T;
/*     */   
/*     */   public c(b paramb, i parami, boolean paramBoolean) {
/*  53 */     super(paramb, parami);
/*  54 */     a(new a(this, parami));
/*     */     
/*  56 */     this.executor = Executors.newCachedThreadPool();
/*  57 */     this.p = new HashMap<>();
/*  58 */     this.q = new HashMap<>();
/*     */     
/*  60 */     if (paramBoolean) {
/*  61 */       a().a(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  67 */     t t = super.b();
/*  68 */     if (t == t.c) {
/*  69 */       this.T = a().B();
/*  70 */     } else if (this.ac.contains("conformidade") && a().a().isEmpty()) {
/*  71 */       aV();
/*     */     } 
/*     */     
/*  74 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   private void aV() {
/*     */     try {
/*  80 */       String str = a().w(this.ad);
/*  81 */       if (str.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*  85 */       Document document = Jsoup.parse(str);
/*  86 */       Elements elements = document.select("table#ctl00_ctl00_ContentPlaceHolder1_Abas1_TableAbas").select("tr").select("td[class=abaCinzaCenter]");
/*     */       
/*  88 */       Optional<Element> optional = elements.stream().filter(paramElement -> paramElement.text().toLowerCase().contains("conformidade")).findFirst();
/*  89 */       if (optional.isPresent()) {
/*  90 */         String str1 = ((Element)optional.get()).select("a").attr("href").trim().replace("../ExameConformidade/AvaliarExameConformidadeFor.aspx?token=", "");
/*  91 */         str1 = URLDecoder.decode(str1, "UTF-8");
/*  92 */         str = a().x(str1);
/*  93 */         if (!str.isEmpty()) {
/*  94 */           v(str);
/*     */         }
/*     */       } 
/*  97 */     } catch (Exception exception) {
/*  98 */       a.warn("Failed to set chat token with compliance page", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/* 104 */     t t = t.b;
/*     */     
/*     */     try {
/*     */       Document document;
/* 108 */       if (this.ad == null || this.ad.isEmpty()) {
/* 109 */         document = a(a().bo());
/*     */       } else {
/* 111 */         String str = a().w(this.ad);
/* 112 */         document = Jsoup.parse(str);
/*     */       } 
/*     */       
/* 115 */       this.ac = document.getElementById("ctl00_ctl00_ContentPlaceHolder1_ContentPlaceHolder1_ctl09_lblStatus").text().toLowerCase();
/* 116 */       if (this.ac.contains("em lances")) {
/* 117 */         t = t.c;
/* 118 */       } else if (this.ac.contains("suspensa")) {
/* 119 */         t = t.e;
/*     */       } else {
/*     */         
/* 122 */         boolean bool = (this.ac.contains("inscrição de proposta") || this.ac.contains("aguardando abertura") || this.ac.contains("conformidade")) ? true : false;
/*     */         
/* 124 */         if (!bool) {
/* 125 */           t = t.d;
/*     */         }
/*     */       } 
/* 128 */     } catch (Exception exception) {
/* 129 */       a.error("{} - Failed to get bidding status", a().bo(), exception);
/*     */     } 
/*     */     
/* 132 */     return t;
/*     */   }
/*     */   
/*     */   private Document a(String paramString) {
/*     */     try {
/* 137 */       e e = a().k(paramString);
/* 138 */       if (e.getData().isEmpty()) {
/* 139 */         return null;
/*     */       }
/*     */       
/* 142 */       Document document = Jsoup.parse(e.getData());
/* 143 */       Elements elements = document.select("table#ctl00_ctl00_ContentPlaceHolder1_Abas1_TableAbas").select("tr").select("td[class=abaVerdeCenter]");
/* 144 */       String str = elements.first().select("a").attr("href").trim().replace("VisualizarEdital.aspx?token=", "").trim();
/* 145 */       this.ad = URLDecoder.decode(str, "UTF-8");
/* 146 */       return document;
/* 147 */     } catch (Exception exception) {
/* 148 */       a.warn("Failed to set process token", exception);
/*     */ 
/*     */       
/* 151 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 158 */       if (this.ae == null || this.ae.isEmpty()) {
/* 159 */         aW();
/*     */       } else {
/* 161 */         int j = a().B();
/* 162 */         if (this.T < j) {
/* 163 */           this.T = j;
/*     */           
/* 165 */           a(a().bo());
/* 166 */           aW();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 172 */       d.N();
/* 173 */       e e = a().d(this.ae, a().getRowCount());
/* 174 */       e(e.k());
/* 175 */       String str = e.getData();
/* 176 */       if (str.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 180 */       i i = new i(e.getData());
/* 181 */       f f = i.j("d").j("Dados").c("Lotes");
/* 182 */       for (byte b = 0; b < f.length(); b++) {
/* 183 */         i = f.b(b);
/* 184 */         e e1 = a(Integer.toString(i.getInt("NumeroLote")));
/* 185 */         if (e1 != null && !e1.br()) {
/* 186 */           b(e1, i);
/*     */         }
/*     */       } 
/* 189 */     } catch (Exception exception) {
/* 190 */       a.error("Failed to load bacthes data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(e parame, i parami) {
/* 195 */     int j = parame.v();
/* 196 */     Future future = this.p.get(Integer.valueOf(j));
/*     */     
/*     */     try {
/* 199 */       if (future == null || future.isDone()) {
/* 200 */         b b = this.q.get(Integer.valueOf(j));
/*     */         
/* 202 */         if (b == null) {
/* 203 */           b = new b(parame, (i)a(), this);
/*     */           
/* 205 */           if (t.c.equals(c())) {
/* 206 */             this.q.put(Integer.valueOf(j), b);
/*     */             
/* 208 */             String str1 = b.l();
/* 209 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 210 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 212 */             StringBuilder stringBuilder = new StringBuilder();
/* 213 */             stringBuilder.append(str1).append(" ").append(parame.bo());
/* 214 */             stringBuilder.append(" entrou em disputa com valor mínimo de R$ ").append(str2);
/* 215 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 219 */         b.f(parami);
/*     */         
/* 221 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 222 */         this.p.put(Integer.valueOf(j), future1);
/*     */       } 
/* 224 */     } catch (Exception exception) {
/* 225 */       a.error("Failed to start batch {} bid process", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void aW() {
/*     */     try {
/* 232 */       String str = a().w(this.ad);
/* 233 */       if (str.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 237 */       Document document = Jsoup.parse(str);
/* 238 */       Elements elements = document.select("table#ctl00_ctl00_ContentPlaceHolder1_Abas1_TableAbas").select("tr").select("td[class=abaCinzaCenter]");
/* 239 */       Optional<Element> optional = elements.stream().filter(paramElement -> paramElement.text().toLowerCase().contains("lances")).findFirst();
/* 240 */       if (optional.isPresent()) {
/* 241 */         String str1 = ((Element)optional.get()).select("a").attr("href").trim().replace("../Lance/LanceFornecedor.aspx?token=", "");
/* 242 */         str1 = URLDecoder.decode(str1, "UTF-8");
/* 243 */         str = a().y(str1);
/* 244 */         if (str.isEmpty()) {
/*     */           return;
/*     */         }
/*     */         
/* 248 */         String str2 = str.substring(str.indexOf("self.CarregarPagina = function"));
/* 249 */         str2 = str2.substring(str2.indexOf("'") + 1);
/* 250 */         str2 = str2.substring(0, str2.indexOf("'"));
/* 251 */         this.ae = str2;
/*     */         
/* 253 */         v(str);
/*     */       } 
/* 255 */     } catch (Exception exception) {
/* 256 */       a.warn("Failed to set dispute token", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void v(String paramString) {
/*     */     try {
/* 263 */       paramString = paramString.substring(paramString.indexOf("function MostrarHistorico"));
/* 264 */       paramString = paramString.substring(paramString.indexOf("'") + 1);
/* 265 */       paramString = paramString.substring(0, paramString.indexOf("'"));
/* 266 */       paramString = paramString.replace("../Edital/HistoricoChat.aspx?token=", "");
/* 267 */       a().u(URLDecoder.decode(paramString, "UTF-8"));
/* 268 */     } catch (Exception exception) {
/* 269 */       a.warn("Failed to set chat token", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 274 */     f f = this.q.get(Integer.valueOf(parame.v()));
/* 275 */     if (f != null) {
/* 276 */       return f.a(new h(paramDouble), true);
/*     */     }
/*     */     
/* 279 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 284 */     R();
/*     */     
/* 286 */     this.p.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 287 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 290 */           } catch (InterruptedException|java.util.concurrent.ExecutionException interruptedException) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 302 */     int i = parame.v();
/* 303 */     b b = this.q.get(Integer.valueOf(i));
/*     */     
/* 305 */     if (b == null) {
/* 306 */       if (this.ad == null || this.ad.isEmpty()) {
/* 307 */         a(parame.a().bo());
/*     */       }
/*     */       
/* 310 */       if (this.ae == null || this.ae.isEmpty()) {
/* 311 */         aW();
/*     */       }
/*     */       
/* 314 */       e e1 = a().d(this.ae, Integer.parseInt(parame.bo()));
/* 315 */       String str = e1.getData();
/* 316 */       if (str.isEmpty()) {
/* 317 */         return new ArrayList<>();
/*     */       }
/*     */       
/* 320 */       i i1 = new i(e1.getData());
/* 321 */       f f = i1.j("d").j("Dados").c("Lotes");
/* 322 */       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 323 */         i1 = f.b(b1);
/* 324 */         if (parame.bo().equals(Integer.toString(i1.getInt("NumeroLote")))) {
/* 325 */           b = new b(parame, (i)a(), this);
/* 326 */           b.f(f.b(b1));
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 332 */     if (b != null) {
/* 333 */       return b.e();
/*     */     }
/*     */     
/* 336 */     return new ArrayList<>();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/* 346 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected final a a() {
/* 351 */     return (a)super.a();
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 355 */     this.q.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\i\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */