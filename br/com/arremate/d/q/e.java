/*     */ package br.com.arremate.d.q;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.j;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.m.b;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */   private final Map<Integer, Future> m;
/*     */   private final Map<Integer, b> n;
/*     */   private String al;
/*     */   
/*     */   public e(b paramb, i parami, boolean paramBoolean) {
/*  43 */     super(paramb, parami);
/*  44 */     a(new a(this, parami));
/*     */     
/*  46 */     this.af = 0;
/*     */     
/*  48 */     this.v = new HashMap<>();
/*  49 */     this.executor = Executors.newCachedThreadPool();
/*  50 */     this.m = new HashMap<>();
/*  51 */     this.n = new HashMap<>();
/*  52 */     this.al = "";
/*     */     
/*  54 */     if (paramBoolean) {
/*  55 */       a().a(this);
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
/*  75 */     t t = t.b;
/*     */     
/*     */     try {
/*  78 */       if (a() != null && a().isRunning()) {
/*  79 */         if (this.al.isEmpty()) {
/*  80 */           br.com.arremate.h.e e2 = a().q(a().bY());
/*  81 */           String str1 = e2.getData();
/*  82 */           e(e2.k());
/*     */           
/*  84 */           if (str1 != null && !str1.trim().isEmpty()) {
/*  85 */             Document document = Jsoup.parse(str1);
/*  86 */             Element element = document.select("frame[id=frmDetalhePregao]").first();
/*  87 */             String str2 = element.attr("src");
/*  88 */             this.al = str2.split("\\?")[1];
/*     */           } 
/*     */         } 
/*     */         
/*  92 */         if (this.al.isEmpty()) {
/*  93 */           return t;
/*     */         }
/*     */         
/*  96 */         br.com.arremate.h.e e1 = a().r(this.al);
/*  97 */         String str = e1.getData();
/*  98 */         e(e1.k());
/*     */         
/* 100 */         if (str != null && !str.trim().isEmpty()) {
/* 101 */           Document document = Jsoup.parse(str);
/* 102 */           Element element = document.select("span[id=lblSituacao]").first();
/* 103 */           String str1 = element.text();
/*     */           
/* 105 */           switch (str1) {
/*     */             case "Negotiation / qualification / acceptance":
/*     */             case "Negociação/Habilitação/Aceitabilidade":
/*     */             case "Homologado":
/*     */             case "Aguardando homologação":
/*     */             case "Fracassado":
/*     */             case "Em adjudicação":
/*     */             case "Contrarrazões":
/*     */             case "Sessão pública encerrada":
/* 114 */               t = t.d;
/*     */               break;
/*     */             case "Suspenso":
/* 117 */               t = t.e;
/*     */               break;
/*     */             case "Em disputa de lances":
/* 120 */               t = t.c;
/*     */               break;
/*     */           } 
/* 123 */         } else if (!D() && !E() && (
/* 124 */           a() != null || !a().isRunning())) {
/* 125 */           a().z();
/*     */         }
/*     */       
/*     */       } 
/* 129 */     } catch (Exception exception) {
/* 130 */       a.error("Erro ao capturar situação do pregão", exception);
/*     */     } 
/*     */     
/* 133 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 139 */       if (this.v.isEmpty()) {
/* 140 */         b((j)a());
/*     */       }
/*     */       
/* 143 */       List<String> list = u();
/* 144 */       if (list.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 148 */       for (String str : list) {
/* 149 */         if (!str.isEmpty() && !str.contains("top.location ='/default.aspx?q=")) {
/* 150 */           r(str);
/*     */         }
/*     */       } 
/* 153 */     } catch (Exception exception) {
/* 154 */       a.error("#003", exception);
/* 155 */       h("#003");
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(br.com.arremate.l.q.b.e parame, Element paramElement, Elements paramElements) {
/* 160 */     if (parame.br() && isRunning()) {
/*     */       return;
/*     */     }
/*     */     
/* 164 */     int i = parame.v();
/*     */     
/*     */     try {
/* 167 */       Future future = this.m.get(Integer.valueOf(i));
/*     */       
/* 169 */       if (future == null || future.isDone()) {
/* 170 */         b b = this.n.get(Integer.valueOf(i));
/*     */         
/* 172 */         if (b == null) {
/* 173 */           b = new b(parame, (i)a(), this);
/*     */ 
/*     */           
/* 176 */           if (t.c.equals(c()) && isRunning()) {
/* 177 */             this.n.put(Integer.valueOf(i), b);
/*     */             
/* 179 */             String str1 = b.l();
/* 180 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 181 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 183 */             StringBuilder stringBuilder = new StringBuilder();
/* 184 */             stringBuilder.append(str1)
/* 185 */               .append(" ")
/* 186 */               .append(parame.bo())
/* 187 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 188 */               .append(str2);
/* 189 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 193 */         b.i(paramElement);
/* 194 */         b.b(paramElements);
/* 195 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 196 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 198 */     } catch (Exception exception) {
/* 199 */       a.warn("Failed to start thread from item " + Integer.toString(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(j paramj) {
/*     */     try {
/* 205 */       if (!a().isRunning() && 
/* 206 */         a().z() != 1) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 211 */       int i = paramj.v();
/* 212 */       int k = paramj.a().w();
/*     */       
/* 214 */       String str = a().c(Integer.valueOf(i), Integer.valueOf(k));
/* 215 */       if (!"".equals(str)) {
/* 216 */         i i1 = new i(str);
/* 217 */         String str1 = i1.j("d").getString("Retorno");
/* 218 */         this.v.put(Integer.valueOf(0), str1);
/*     */         
/* 220 */         if (this.af == 0 || this.v.size() < this.af) {
/* 221 */           this.af = a(str1);
/*     */           
/* 223 */           if (this.af > 1) {
/* 224 */             for (byte b = 1; b < this.af; b++) {
/* 225 */               str1 = a().a(Integer.valueOf(i), Integer.valueOf(k), b);
/* 226 */               i1 = new i(str1);
/* 227 */               str1 = i1.j("d").getString("Retorno");
/* 228 */               this.v.put(Integer.valueOf(b), str1);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 233 */     } catch (Exception exception) {
/* 234 */       a.error("#002 - Failed to load hash", exception);
/* 235 */       h("#002 - Failed to load hash");
/*     */     } 
/*     */   }
/*     */   
/*     */   private int a(String paramString) {
/* 240 */     int i = 0;
/*     */     
/*     */     try {
/* 243 */       String str1 = a().F(paramString);
/* 244 */       Document document = Jsoup.parse(str1);
/* 245 */       String str2 = document.select("td[class=navegacao]").first().text();
/*     */       
/* 247 */       if (str2.contains("página  1  de  ")) {
/* 248 */         i = Integer.parseInt(str2.substring(str2.indexOf("página  1  de  ") + 15).trim());
/*     */       }
/* 250 */     } catch (Exception exception) {}
/*     */ 
/*     */     
/* 253 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 258 */     R();
/*     */ 
/*     */     
/* 261 */     this.m.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue())
/* 262 */       .forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 265 */           } catch (Exception exception) {}
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
/* 279 */     a().I().forEach(parame -> {
/*     */           b b = this.n.get(Integer.valueOf(parame.v()));
/*     */           if (b != null) {
/*     */             int[] arrayOfInt = b.a();
/*     */             parame.ah(arrayOfInt[0]);
/*     */             parame.ai(arrayOfInt[1]);
/*     */           } 
/*     */         });
/*     */   }
/*     */   
/*     */   public boolean c(br.com.arremate.l.q.b.e parame, double paramDouble) {
/* 290 */     h h = new h(paramDouble);
/* 291 */     b b = new b(parame, (i)a(), this);
/* 292 */     return b.a(h, true);
/*     */   }
/*     */ 
/*     */   
/*     */   public final j a() {
/* 297 */     return (j)super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   public b a() {
/* 302 */     return (b)super.a();
/*     */   }
/*     */   
/*     */   protected Map<Integer, String> j() {
/* 306 */     return this.v;
/*     */   }
/*     */   
/*     */   void p(br.com.arremate.l.q.b.e parame) {
/* 310 */     this.n.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */   
/*     */   public Map<Integer, b> c() {
/* 314 */     return this.n;
/*     */   }
/*     */   
/*     */   protected abstract void r(String paramString);
/*     */   
/*     */   protected abstract List<String> u();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\q\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */