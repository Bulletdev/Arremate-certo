/*     */ package br.com.arremate.d.p;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.g.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.c;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
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
/*     */ public abstract class e
/*     */   extends g
/*     */ {
/*     */   private String al;
/*     */   private int af;
/*     */   private final Map<Integer, String> v;
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future<?>> m;
/*     */   private final Map<Integer, b> n;
/*     */   private Timer a;
/*     */   
/*     */   public e(b paramb, i parami, boolean paramBoolean) {
/*  48 */     super(paramb, parami);
/*  49 */     a(new a(this, parami));
/*     */     
/*  51 */     this.af = 0;
/*     */     
/*  53 */     this.v = new HashMap<>();
/*  54 */     this.executor = Executors.newCachedThreadPool();
/*  55 */     this.m = new HashMap<>();
/*  56 */     this.n = new HashMap<>();
/*  57 */     this.al = "";
/*     */     
/*  59 */     if (paramBoolean) {
/*  60 */       a().b(this);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public t a() {
/*  80 */     t t = t.b;
/*     */     
/*  82 */     if (a() != null && a().isRunning()) {
/*     */       
/*  84 */       if (this.al.isEmpty()) {
/*  85 */         br.com.arremate.h.e e2 = a().q(a().bY());
/*  86 */         String str1 = e2.getData();
/*  87 */         e(e2.k());
/*     */         
/*  89 */         if (str1 != null && !str1.trim().isEmpty()) {
/*  90 */           Document document = Jsoup.parse(str1);
/*  91 */           Element element = document.select("frame[id=frmDetalhePregao]").first();
/*  92 */           String str2 = element.attr("src");
/*  93 */           this.al = str2.split("\\?")[1];
/*     */         } 
/*     */       } 
/*     */       
/*  97 */       if (this.al.isEmpty()) {
/*  98 */         return t;
/*     */       }
/*     */       
/* 101 */       br.com.arremate.h.e e1 = a().r(this.al);
/* 102 */       String str = e1.getData();
/* 103 */       e(e1.k());
/*     */       
/* 105 */       if (str != null && !str.isEmpty()) {
/* 106 */         Document document = Jsoup.parse(str);
/* 107 */         Element element = document.select("span[id=lblSituacao]").first();
/* 108 */         String str1 = element.text();
/*     */         
/* 110 */         switch (str1) {
/*     */           case "Negociação/Habilitação/Aceitabilidade":
/*     */           case "Homologado":
/*     */           case "Aguardando homologação":
/*     */           case "Fracassado":
/*     */           case "Em adjudicação":
/*     */           case "Contrarrazões":
/*     */           case "Sessão pública encerrada":
/* 118 */             t = t.d;
/*     */             break;
/*     */           case "Suspenso":
/* 121 */             t = t.e;
/*     */             break;
/*     */           case "Em disputa de lances":
/* 124 */             t = t.c;
/*     */             break;
/*     */         } 
/* 127 */       } else if (!D() && !E() && (
/* 128 */         a() != null || !a().isRunning())) {
/* 129 */         a().z();
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 134 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 139 */     t t = super.b();
/* 140 */     if (t == t.c && 
/* 141 */       a().a() != m.a) {
/* 142 */       an();
/*     */     }
/*     */ 
/*     */     
/* 146 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/* 150 */     this.a = new Timer("CountdownTimer");
/* 151 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 154 */             this.a.a().B().parallelStream().forEach(param1g -> {
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
/*     */   public void R() {
/*     */     try {
/* 173 */       if (this.v.isEmpty()) {
/* 174 */         b((j)a());
/*     */       }
/*     */       
/* 177 */       List<String> list = u();
/* 178 */       if (list.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 182 */       for (String str : list) {
/* 183 */         if (!str.isEmpty() && !str.contains("top.location ='/default.aspx?q=")) {
/* 184 */           r(str);
/*     */         }
/*     */       } 
/* 187 */     } catch (Exception exception) {
/* 188 */       a.error("#003", exception);
/* 189 */       h("#003");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(br.com.arremate.l.q.b.e parame, Element paramElement, Elements paramElements) {
/* 194 */     if (parame.br() && isRunning()) {
/*     */       return;
/*     */     }
/*     */     
/* 198 */     int i = parame.v();
/*     */     
/*     */     try {
/* 201 */       Future future = this.m.get(Integer.valueOf(i));
/*     */       
/* 203 */       if (future == null || future.isDone()) {
/* 204 */         b b = this.n.get(Integer.valueOf(i));
/*     */         
/* 206 */         if (b == null) {
/* 207 */           b = new b(parame, (i)a(), this);
/*     */ 
/*     */           
/* 210 */           if (t.c.equals(c()) && isRunning()) {
/* 211 */             this.n.put(Integer.valueOf(i), b);
/*     */             
/* 213 */             String str1 = b.l();
/* 214 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 215 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 217 */             StringBuilder stringBuilder = new StringBuilder();
/* 218 */             stringBuilder.append(str1)
/* 219 */               .append(" ")
/* 220 */               .append(parame.bo())
/* 221 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 222 */               .append(str2);
/* 223 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 227 */         b.i(paramElement);
/* 228 */         b.b(paramElements);
/* 229 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 230 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 232 */     } catch (Exception exception) {
/* 233 */       a.warn("Failed to start thread from item " + Integer.toString(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(j paramj) {
/*     */     try {
/* 239 */       if (!a().isRunning() && 
/* 240 */         a().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 245 */       int i = paramj.v();
/* 246 */       int k = paramj.a().w();
/*     */       
/* 248 */       String str = a().c(Integer.valueOf(i), Integer.valueOf(k));
/* 249 */       if (!"".equals(str)) {
/* 250 */         i i1 = new i(str);
/* 251 */         String str1 = i1.j("d").getString("Retorno");
/* 252 */         this.v.put(Integer.valueOf(0), str1);
/*     */         
/* 254 */         if (this.af == 0 || this.v.size() < this.af) {
/* 255 */           this.af = a(str1);
/*     */           
/* 257 */           if (this.af > 1) {
/* 258 */             for (byte b = 1; b < this.af; b++) {
/* 259 */               str1 = a().a(Integer.valueOf(i), Integer.valueOf(k), b);
/* 260 */               i1 = new i(str1);
/* 261 */               str1 = i1.j("d").getString("Retorno");
/* 262 */               this.v.put(Integer.valueOf(b), str1);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 267 */     } catch (Exception exception) {
/* 268 */       a.error("#002 - Failed to load hash", exception);
/* 269 */       h("#002 - Failed to load hash");
/*     */     } 
/*     */   }
/*     */   
/*     */   private int a(String paramString) {
/* 274 */     int i = 0;
/*     */     
/*     */     try {
/* 277 */       String str1 = a().F(paramString);
/* 278 */       Document document = Jsoup.parse(str1);
/* 279 */       String str2 = document.select("td[class=navegacao]").first().text();
/*     */       
/* 281 */       if (str2.contains("página  1  de  ")) {
/* 282 */         i = Integer.parseInt(str2.substring(str2.indexOf("página  1  de  ") + 15).trim());
/*     */       }
/* 284 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 287 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 292 */     R();
/*     */ 
/*     */     
/* 295 */     this.m.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 296 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 299 */           } catch (Exception exception) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {
/* 313 */     a().I().forEach(parame -> {
/*     */           b b = this.n.get(Integer.valueOf(parame.v()));
/*     */           if (b != null) {
/*     */             int[] arrayOfInt = b.a();
/*     */             parame.ah(arrayOfInt[0]);
/*     */             parame.ai(arrayOfInt[1]);
/*     */           } 
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean c(br.com.arremate.l.q.b.e parame, double paramDouble) {
/* 325 */     h h = new h(paramDouble);
/* 326 */     b b = new b(parame, (i)a(), this);
/* 327 */     return b.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 332 */     super.ab();
/*     */     
/* 334 */     if (this.a != null) {
/* 335 */       this.a.cancel();
/* 336 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 342 */     return (a)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 347 */     return (c)super.a();
/*     */   }
/*     */   
/*     */   protected Map<Integer, String> j() {
/* 351 */     return this.v;
/*     */   }
/*     */   
/*     */   void p(br.com.arremate.l.q.b.e parame) {
/* 355 */     this.n.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */   
/*     */   public Map<Integer, b> c() {
/* 359 */     return this.n;
/*     */   }
/*     */   
/*     */   protected abstract void r(String paramString);
/*     */   
/*     */   protected abstract List<String> u();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\p\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */