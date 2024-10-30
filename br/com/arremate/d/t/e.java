/*     */ package br.com.arremate.d.t;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.h;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.d;
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
/*     */   private int af;
/*     */   private final Map<Integer, String> v;
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future<?>> m;
/*     */   private final Map<Integer, b> n;
/*     */   private String al;
/*     */   private Timer a;
/*     */   
/*     */   public e(b paramb, i parami, boolean paramBoolean) {
/*  48 */     super(paramb, parami);
/*  49 */     a(new a(this, parami));
/*  50 */     j(1000L);
/*     */     
/*  52 */     this.af = 0;
/*     */     
/*  54 */     this.v = new HashMap<>();
/*  55 */     this.executor = Executors.newCachedThreadPool();
/*  56 */     this.m = new HashMap<>();
/*  57 */     this.n = new HashMap<>();
/*  58 */     this.al = "";
/*     */     
/*  60 */     if (paramBoolean) {
/*  61 */       a().a(this);
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
/*  81 */     t t = t.b;
/*     */     
/*     */     try {
/*  84 */       if (a() != null && a().isRunning()) {
/*  85 */         if (this.al.isEmpty()) {
/*  86 */           br.com.arremate.h.e e2 = a().q(a().bY());
/*  87 */           String str1 = e2.getData();
/*  88 */           e(e2.k());
/*     */           
/*  90 */           if (str1 != null && !str1.trim().isEmpty()) {
/*  91 */             Document document = Jsoup.parse(str1);
/*  92 */             Element element = document.select("frame[id=frmDetalhePregao]").first();
/*  93 */             String str2 = element.attr("src");
/*  94 */             this.al = str2.split("\\?")[1];
/*     */           } 
/*     */         } 
/*     */         
/*  98 */         if (this.al.isEmpty()) {
/*  99 */           return t;
/*     */         }
/*     */         
/* 102 */         br.com.arremate.h.e e1 = a().r(this.al);
/* 103 */         String str = e1.getData();
/* 104 */         e(e1.k());
/*     */         
/* 106 */         if (str != null && !str.trim().isEmpty()) {
/* 107 */           Document document = Jsoup.parse(str);
/* 108 */           Element element = document.select("span[id=lblSituacao]").first();
/* 109 */           if (element == null) {
/* 110 */             a.error("Erro ao capturar situação do pregão; retorno do portal: {}; status code: {}; reset login?: {}", new Object[] { str, Integer.valueOf(e1.getStatusCode()), Boolean.valueOf((a() != null && !a().isRunning())) });
/* 111 */             return t;
/*     */           } 
/* 113 */           String str1 = element.text();
/*     */           
/* 115 */           switch (str1) {
/*     */             case "Negociação/Habilitação/Aceitabilidade":
/*     */             case "Homologado":
/*     */             case "Aguardando homologação":
/*     */             case "Fracassado":
/*     */             case "Em adjudicação":
/*     */             case "Contrarrazões":
/*     */             case "Sessão pública encerrada":
/*     */             case "Intenção de recursos":
/* 124 */               t = t.d;
/*     */               break;
/*     */             case "Suspenso":
/* 127 */               t = t.e;
/*     */               break;
/*     */             case "Em disputa de lances":
/* 130 */               t = t.c;
/*     */               break;
/*     */           } 
/* 133 */         } else if (!D() && !E() && (
/* 134 */           a() != null || !a().isRunning())) {
/* 135 */           a().z();
/*     */         }
/*     */       
/*     */       } 
/* 139 */     } catch (Exception exception) {
/* 140 */       a.error("Erro ao capturar situação do pregão", exception);
/*     */     } 
/*     */     
/* 143 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 148 */     t t = super.b();
/* 149 */     if (t == t.c && 
/* 150 */       a().a() != m.a) {
/* 151 */       an();
/*     */     }
/*     */ 
/*     */     
/* 155 */     return t;
/*     */   }
/*     */   
/*     */   private void an() {
/* 159 */     this.a = new Timer("CountdownTimer");
/* 160 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 163 */             this.a.a().B().parallelStream().forEach(param1g -> {
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
/* 182 */       if (this.v.isEmpty()) {
/* 183 */         b((j)a());
/*     */       }
/*     */       
/* 186 */       List<String> list = u();
/* 187 */       if (list.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 191 */       for (String str : list) {
/* 192 */         if (!str.isEmpty()) {
/* 193 */           if (str.contains("top.location ='/default.aspx?q=")) {
/* 194 */             this.v.clear();
/*     */             break;
/*     */           } 
/* 197 */           r(str);
/*     */         }
/*     */       
/*     */       } 
/* 201 */     } catch (Exception exception) {
/* 202 */       a.error("#003", exception);
/* 203 */       h("#003");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(br.com.arremate.l.q.b.e parame, Element paramElement, Elements paramElements) {
/* 208 */     if (parame.br() && isRunning()) {
/*     */       return;
/*     */     }
/*     */     
/* 212 */     int i = parame.v();
/*     */     
/*     */     try {
/* 215 */       Future future = this.m.get(Integer.valueOf(i));
/*     */       
/* 217 */       if (future == null || future.isDone()) {
/* 218 */         b b = this.n.get(Integer.valueOf(i));
/*     */         
/* 220 */         if (b == null) {
/* 221 */           b = new b(parame, (i)a(), this);
/*     */ 
/*     */           
/* 224 */           if (t.c.equals(c()) && isRunning()) {
/* 225 */             this.n.put(Integer.valueOf(i), b);
/*     */             
/* 227 */             String str1 = b.l();
/* 228 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 229 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 231 */             StringBuilder stringBuilder = new StringBuilder();
/* 232 */             stringBuilder.append(str1)
/* 233 */               .append(" ")
/* 234 */               .append(parame.bo())
/* 235 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 236 */               .append(str2);
/* 237 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 241 */         b.i(paramElement);
/* 242 */         b.b(paramElements);
/* 243 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 244 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 246 */     } catch (Exception exception) {
/* 247 */       a.warn("Failed to start thread from item " + Integer.toString(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(j paramj) {
/*     */     try {
/* 253 */       if (!a().isRunning() && 
/* 254 */         a().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 259 */       int i = paramj.v();
/* 260 */       int k = paramj.a().w();
/*     */       
/* 262 */       String str = a().c(Integer.valueOf(i), Integer.valueOf(k));
/* 263 */       if (!"".equals(str)) {
/* 264 */         i i1 = new i(str);
/* 265 */         String str1 = i1.j("d").getString("Retorno");
/* 266 */         this.v.put(Integer.valueOf(0), str1);
/*     */         
/* 268 */         if (this.af == 0 || this.v.size() < this.af) {
/* 269 */           this.af = a(str1);
/*     */           
/* 271 */           if (this.af > 1) {
/* 272 */             for (byte b = 1; b < this.af; b++) {
/* 273 */               str1 = a().a(Integer.valueOf(i), Integer.valueOf(k), b);
/* 274 */               i1 = new i(str1);
/* 275 */               str1 = i1.j("d").getString("Retorno");
/* 276 */               this.v.put(Integer.valueOf(b), str1);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 281 */     } catch (Exception exception) {
/* 282 */       a.error("#002 - Failed to load hash", exception);
/* 283 */       h("#002 - Failed to load hash");
/*     */     } 
/*     */   }
/*     */   
/*     */   public int a(String paramString) {
/* 288 */     int i = 0;
/*     */     
/*     */     try {
/* 291 */       String str1 = a().F(paramString);
/* 292 */       Document document = Jsoup.parse(str1);
/* 293 */       String str2 = document.select("td[class=navegacao]").first().text();
/*     */       
/* 295 */       if (str2.contains("página  1  de  ")) {
/* 296 */         i = Integer.parseInt(str2.substring(str2.indexOf("página  1  de  ") + 15).trim());
/*     */       }
/* 298 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 301 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 306 */     R();
/*     */ 
/*     */     
/* 309 */     this.m.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 310 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 313 */           } catch (Exception exception) {}
/*     */         });
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {
/* 324 */     a().I().forEach(parame -> {
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
/* 336 */     h h = new h(paramDouble);
/* 337 */     b b = new b(parame, (i)a(), this);
/* 338 */     return b.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 343 */     super.ab();
/*     */     
/* 345 */     if (this.a != null) {
/* 346 */       this.a.cancel();
/* 347 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public final h a() {
/* 353 */     return (h)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public d a() {
/* 358 */     return (d)super.a();
/*     */   }
/*     */   
/*     */   protected Map<Integer, String> j() {
/* 362 */     return this.v;
/*     */   }
/*     */   
/*     */   void p(br.com.arremate.l.q.b.e parame) {
/* 366 */     this.n.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */   
/*     */   public Map<Integer, b> c() {
/* 370 */     return this.n;
/*     */   }
/*     */   
/*     */   protected abstract void r(String paramString);
/*     */   
/*     */   protected abstract List<String> u();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\t\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */