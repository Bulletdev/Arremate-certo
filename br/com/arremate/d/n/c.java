/*     */ package br.com.arremate.d.n;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future> g;
/*     */   private final Map<Integer, b> h;
/*     */   private boolean k;
/*     */   private Timer a;
/*     */   private int ae;
/*     */   
/*     */   public c(b paramb, i parami, boolean paramBoolean) {
/*  47 */     super(paramb, parami);
/*  48 */     a(new a(this, parami));
/*  49 */     j(TimeUnit.SECONDS.toMillis(5L));
/*     */     
/*  51 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  52 */     this.g = new HashMap<>();
/*  53 */     this.h = new HashMap<>();
/*     */     
/*  55 */     this.k = false;
/*     */     
/*  57 */     if (paramBoolean) {
/*  58 */       a().a(this);
/*     */     }
/*     */   }
/*     */   
/*     */   protected int u() {
/*  63 */     return this.ae;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/*  68 */     t t = super.b();
/*     */     
/*  70 */     if (t == t.c) {
/*  71 */       an();
/*     */     }
/*     */     
/*  74 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/*  78 */     this.a = new Timer("CountdownTimer");
/*  79 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/*  82 */             this.a.a().B().parallelStream().forEach(param1g -> {
/*     */                   long l = param1g.z();
/*     */                   if (l <= 0L) {
/*     */                     return;
/*     */                   }
/*     */                   if (param1g.aM() || param1g.au()) {
/*     */                     param1g.x(l - 1000L);
/*     */                     this.a.a().fireTableCellUpdated(this.a.a().indexOf(param1g.v()), 14);
/*     */                   } 
/*     */                 });
/*     */           }
/*     */         }1000L, 1000L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ab() {
/* 100 */     super.ab();
/*     */     
/* 102 */     if (this.a != null) {
/* 103 */       this.a.cancel();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/* 109 */     t t = t.b;
/*     */     
/*     */     try {
/* 112 */       String str = a().n(((br.com.arremate.l.k.c)a()).cc()).getData();
/*     */       
/* 114 */       if (!str.isEmpty()) {
/* 115 */         i i = (new i(str)).j("procedimento");
/*     */         
/* 117 */         String str1 = i.j("situacao").getString("descricao").toLowerCase();
/* 118 */         t = b(str1);
/* 119 */         String str2 = "Pregão em disputa";
/*     */         
/* 121 */         if (t.equals(t.d)) {
/* 122 */           str2 = "Disputa encerrada";
/* 123 */         } else if (t.equals(t.b)) {
/* 124 */           str2 = "Pregão em fase de proposta";
/* 125 */         } else if (t.equals(t.e)) {
/* 126 */           str2 = "Pregão suspenso";
/*     */         } 
/*     */         
/* 129 */         k(str2);
/* 130 */       } else if (!D() && !E() && 
/* 131 */         isRunning() && !a().isRunning()) {
/* 132 */         a().z();
/*     */       }
/*     */     
/* 135 */     } catch (Exception exception) {
/* 136 */       a.error("#004 - Erro no verifica pregão aberto", exception);
/*     */     } 
/*     */     
/* 139 */     return t;
/*     */   }
/*     */   
/*     */   private t b(String paramString) {
/* 143 */     if (paramString.contains("aguardando abertura da sessão") || paramString
/* 144 */       .contains("inscrição de propostas") || paramString
/* 145 */       .contains("aguardando agendamento") || paramString
/* 146 */       .contains("agendar retomada") || paramString
/* 147 */       .contains("aguardando reativação do pregão") || paramString
/* 148 */       .contains("sessão não iniciada"))
/* 149 */       return t.b; 
/* 150 */     if (paramString.contains("sessão iniciada"))
/* 151 */       return t.c; 
/* 152 */     if (paramString.contains("suspenso")) {
/* 153 */       return t.e;
/*     */     }
/* 155 */     return t.d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 162 */       br.com.arremate.l.k.c c1 = (br.com.arremate.l.k.c)a();
/* 163 */       e e = a().n(c1.cc());
/* 164 */       e(e.k());
/* 165 */       i i = (new i(e.getData())).j("procedimento");
/*     */       
/* 167 */       if (i != null) {
/* 168 */         if (i.has("msgErro")) {
/* 169 */           l("Não foi possível capturar dados de itens em disputa, mensagem do portal:" + i.getString("msgErro"));
/*     */           
/*     */           return;
/*     */         } 
/* 173 */         if (i.has("lotes")) {
/* 174 */           f f = i.c("lotes");
/* 175 */           if (i.has("chat") && !i.isNull("chat")) {
/* 176 */             this.ae = i.j("chat").getInt("idProcedimento");
/*     */           }
/*     */           
/* 179 */           for (byte b = 0; b < f.length(); b++) {
/* 180 */             i i1 = f.b(b);
/* 181 */             int j = i1.getInt("id");
/* 182 */             e e1 = a(j);
/*     */             
/* 184 */             if (e1 != null) {
/* 185 */               String str = i1.j("situacao").getString("descricao");
/*     */               
/* 187 */               a a = new a(e1.v(), a());
/* 188 */               a.N(a(e1, i1, str));
/*     */               
/* 190 */               if (a(e1, a)) {
/* 191 */                 u(e1);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 197 */     } catch (Exception exception) {
/* 198 */       a.error("Failed to load bidding batches data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(e parame, a parama) {
/* 203 */     return (((
/* 204 */       !parame.bw() || !parama.aq()) && 
/* 205 */       !parame.br()) || this.k);
/*     */   }
/*     */ 
/*     */   
/*     */   private void u(e parame) {
/* 210 */     int i = parame.v();
/* 211 */     Future future = this.g.get(Integer.valueOf(i));
/*     */     
/*     */     try {
/* 214 */       if (future == null || future.isDone()) {
/* 215 */         b b = this.h.get(Integer.valueOf(i));
/*     */         
/* 217 */         if (b == null) {
/* 218 */           b = new b(parame, (i)a(), this);
/*     */           
/* 220 */           if (t.c.equals(c()) && !this.k) {
/* 221 */             this.h.put(Integer.valueOf(i), b);
/*     */           }
/*     */         } 
/*     */         
/* 225 */         Future<?> future1 = this.a.submit((Runnable)b);
/* 226 */         this.g.put(Integer.valueOf(i), future1);
/*     */       } 
/* 228 */     } catch (Exception exception) {
/* 229 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String a(e parame, i parami, String paramString) {
/* 234 */     long l1 = y.i().getTimeInMillis();
/* 235 */     if (parami.has("dataFim") && !parami.getString("dataFim").isEmpty()) {
/* 236 */       String str = parami.getString("dataFim");
/* 237 */       l1 = y.c(y.Y(str)).getTimeInMillis();
/*     */     } 
/*     */     
/* 240 */     long l2 = l1 - y.i().getTimeInMillis();
/* 241 */     if (l2 > 0L) {
/* 242 */       if (l2 <= 120000L && parame.a().a() == m.b) {
/* 243 */         paramString = "Tempo de iminência - modo aberto";
/*     */       }
/*     */       
/* 246 */       if (l2 + 1000L > parame.z()) {
/* 247 */         parame.x(l2);
/*     */       }
/* 249 */     } else if (paramString.equals("Disputa aberta iniciada") && parame.a().a() != m.b) {
/* 250 */       parame.x(0L);
/* 251 */       paramString = "Tempo randômico iniciado";
/*     */     } 
/*     */     
/* 254 */     a a = (a)parame.a();
/* 255 */     if (g.b(paramString, g.P) && !a.aR() && a.bh()) {
/* 256 */       paramString = g.p.getValue();
/*     */     }
/*     */     
/* 259 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i l() {
/* 268 */     HashSet<Integer> hashSet = new HashSet();
/*     */     
/* 270 */     a()
/* 271 */       .L()
/* 272 */       .forEach(parame -> paramSet.add(Integer.valueOf(parame.v())));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 277 */     return a(hashSet);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   i a(Set<Integer> paramSet) {
/* 286 */     i i = null;
/* 287 */     String str = "";
/*     */     
/*     */     try {
/* 290 */       str = a(paramSet);
/*     */       
/* 292 */       if (!str.isEmpty()) {
/* 293 */         if (!str.contains("erroPregaoNaoValidado")) {
/* 294 */           i = new i(str);
/*     */         } else {
/* 296 */           String str1; Document document = Jsoup.parse(str);
/*     */ 
/*     */           
/*     */           try {
/* 300 */             str1 = document.select("span[id=erroPregaoNaoValidado]").first().text().trim();
/* 301 */           } catch (Exception exception) {
/* 302 */             str1 = "Acesso negado";
/*     */           } 
/*     */           
/* 305 */           i = new i();
/* 306 */           i.c("msgErro", str1);
/*     */         } 
/*     */       }
/* 309 */     } catch (Exception exception) {
/* 310 */       a.warn("#007", exception);
/*     */     } 
/*     */     
/* 313 */     return i;
/*     */   }
/*     */   
/*     */   private String a(Set<Integer> paramSet) {
/* 317 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 322 */     b b = null;
/*     */     
/* 324 */     if (!parame.br() && isRunning()) {
/* 325 */       b = this.h.get(Integer.valueOf(parame.v()));
/*     */     }
/*     */     
/* 328 */     if (b == null) {
/* 329 */       b = new b(parame, (i)a(), this);
/*     */     }
/*     */     
/* 332 */     return parame.br() ? b.s() : b.e();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void S() {
/* 338 */     this.k = true;
/* 339 */     R();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */   
/*     */   protected void T() {
/* 348 */     a()
/* 349 */       .I()
/* 350 */       .forEach(parame -> {
/*     */           b b = this.h.get(Integer.valueOf(parame.v()));
/*     */           if (b != null) {
/*     */             int[] arrayOfInt = b.a();
/*     */             parame.ah(arrayOfInt[0]);
/*     */             parame.ai(arrayOfInt[1]);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 362 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 363 */     if (b != null) {
/* 364 */       return b.a(new h(paramDouble), true);
/*     */     }
/*     */     
/* 367 */     return false;
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 371 */     this.h.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final e a() {
/* 376 */     return (e)super.a();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\n\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */