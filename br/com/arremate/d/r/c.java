/*     */ package br.com.arremate.d.r;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.k.a;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Timer;
/*     */ import java.util.TimerTask;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends g
/*     */ {
/*     */   private final ExecutorService a;
/*     */   private final Map<Integer, Future<?>> g;
/*     */   private final Map<Integer, b> h;
/*     */   private final Map<String, List<h>> w;
/*     */   private boolean m;
/*     */   private Timer a;
/*     */   
/*     */   public c(b paramb, i parami, boolean paramBoolean) {
/*  46 */     super(paramb, parami);
/*  47 */     j(TimeUnit.SECONDS.toMillis(3L));
/*  48 */     a(new a(this, parami));
/*     */     
/*  50 */     this.a = (Timer)Executors.newCachedThreadPool();
/*  51 */     this.g = new HashMap<>();
/*  52 */     this.h = new HashMap<>();
/*  53 */     this.w = new HashMap<>();
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  58 */     String str1 = a().bf() ? "SR" : "CR";
/*  59 */     String str2 = String.valueOf(a().v());
/*  60 */     String str3 = a().b(1, str1, str2).getData();
/*     */     
/*     */     try {
/*  63 */       Document document = Jsoup.parse(str3);
/*  64 */       Elements elements = document.select("table[class=box_simples]").first().select("td");
/*     */       
/*  66 */       String str = elements.get(4).text().trim();
/*  67 */       switch (str) {
/*     */         case "Fase de acolhimento das propostas":
/*     */         case "Fase de abertura das propostas":
/*     */         case "Análise das propostas":
/*     */         case "Análise das propostas encerrada":
/*     */         case "Acolhimento de Propostas Encerrada":
/*  73 */           return t.b;
/*     */         case "Consultar Status no Item":
/*  75 */           if (!a(str1, str2, document))
/*  76 */             return t.c; 
/*     */           break;
/*     */       } 
/*  79 */       return t.d;
/*     */     
/*     */     }
/*  82 */     catch (Exception exception) {
/*  83 */       a.error("Failed to get bidding status", exception);
/*     */ 
/*     */       
/*  86 */       return t.b;
/*     */     } 
/*     */   }
/*     */   private boolean a(String paramString1, String paramString2, Document paramDocument) {
/*  90 */     int i = 1;
/*  91 */     byte b = 2;
/*     */     
/*  93 */     Element element = paramDocument.select("a[href*=f_ultima_pagina]").first();
/*  94 */     if (element != null) {
/*  95 */       i = Integer.parseInt(element.attr("href").replaceAll("[\\D]", ""));
/*     */     }
/*     */     
/*  98 */     boolean bool = c(paramDocument);
/*     */     
/* 100 */     while (b <= i && !bool) {
/* 101 */       String str = a().b(b, paramString1, paramString2).getData();
/* 102 */       paramDocument = Jsoup.parse(str);
/* 103 */       bool = c(paramDocument);
/* 104 */       b++;
/*     */     } 
/*     */     
/* 107 */     return !bool;
/*     */   }
/*     */   
/*     */   private boolean c(Document paramDocument) {
/* 111 */     Element element = paramDocument.select("table[class=tabela_listagem] > tbody").first();
/* 112 */     Elements elements = element.select("tr[class=listagem_linha]");
/* 113 */     for (Element element1 : elements) {
/* 114 */       Elements elements1 = element1.select("td");
/* 115 */       if (elements1.size() <= 11) {
/* 116 */         return true;
/*     */       }
/*     */     } 
/* 119 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected t b() {
/* 124 */     t t = super.b();
/* 125 */     if (t == t.c && 
/* 126 */       a().a() != m.a) {
/* 127 */       an();
/*     */     }
/*     */     
/* 130 */     if (this.w.isEmpty()) {
/* 131 */       c(a());
/*     */     }
/*     */     
/* 134 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   private void c(j paramj) {
/* 139 */     e e = a().o(paramj.bf() ? "SR" : "CR", String.valueOf(paramj.v()));
/*     */     
/* 141 */     Document document = Jsoup.parse(e.getData());
/* 142 */     Elements elements = document.select("table[class=tabela_consulta]");
/*     */     
/* 144 */     if (elements != null && !elements.isEmpty()) {
/* 145 */       Elements elements1 = elements.get(2).select("table[class=tabela_consulta_padrao]");
/*     */       
/* 147 */       for (Element element : elements1) {
/* 148 */         ArrayList<h> arrayList = new ArrayList();
/* 149 */         Elements elements2 = element.select("tr");
/* 150 */         if (elements2 != null && !elements2.isEmpty()) {
/* 151 */           elements2.remove(0);
/* 152 */           for (Element element2 : elements2) {
/* 153 */             Elements elements3 = element2.select("td");
/* 154 */             h h = new h();
/* 155 */             h.c(paramj.h().getTime());
/* 156 */             h.A(elements3.get(0).text().contains(a().a().ax()));
/* 157 */             h.q(y.a(elements3.get(1).text()).doubleValue());
/* 158 */             arrayList.add(h);
/*     */           } 
/*     */           
/* 161 */           Element element1 = element.parent().previousElementSibling().previousElementSibling();
/* 162 */           String str = element1.text().replaceAll("[\\D]", "");
/* 163 */           this.w.put(str, arrayList);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void an() {
/* 170 */     this.a = new Timer("CountdownTimer");
/* 171 */     this.a.schedule(new TimerTask(this)
/*     */         {
/*     */           public void run() {
/* 174 */             this.a.a().B().parallelStream().forEach(param1g -> {
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
/*     */   
/*     */   public void R() {
/* 193 */     Elements elements = new Elements();
/*     */     
/* 195 */     if (this.m) {
/* 196 */       for (g g1 : a().B()) {
/* 197 */         b(a(g1.bo()), (Elements)null);
/*     */       }
/*     */     } else {
/* 200 */       e e = a().D(String.valueOf(a().v()));
/* 201 */       elements.addAll((Collection)a(e.getData()));
/* 202 */       e(e.k());
/*     */     } 
/*     */     
/* 205 */     HashSet<Integer> hashSet = new HashSet();
/*     */     
/* 207 */     if (!elements.isEmpty()) {
/* 208 */       for (Element element : elements) {
/* 209 */         Elements elements1 = element.select("td");
/* 210 */         if (elements1.size() <= 1) {
/*     */           continue;
/*     */         }
/*     */         
/* 214 */         e e = a(elements1.get(1).text());
/* 215 */         if (e == null) {
/*     */           continue;
/*     */         }
/*     */         
/* 219 */         hashSet.add(Integer.valueOf(e.v()));
/* 220 */         b(e, elements1);
/*     */       } 
/*     */     }
/*     */     
/* 224 */     a(hashSet);
/*     */   }
/*     */   
/*     */   private Elements a(String paramString) {
/* 228 */     Document document = Jsoup.parse(paramString);
/* 229 */     Elements elements = document.select("tr[class^=linha_]");
/* 230 */     if (elements == null || elements.isEmpty() || elements.first().text().contains("Nenhum item encontrado.")) {
/* 231 */       return new Elements();
/*     */     }
/*     */     
/* 234 */     return elements;
/*     */   }
/*     */   
/*     */   private void a(HashSet<Integer> paramHashSet) {
/* 238 */     for (e e : a().H()) {
/* 239 */       if (paramHashSet.isEmpty() || !paramHashSet.contains(Integer.valueOf(e.v()))) {
/* 240 */         e.N("Encerrado");
/* 241 */         g(e);
/* 242 */         p(e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(e parame, Elements paramElements) {
/* 248 */     int i = parame.v();
/* 249 */     Future future = this.g.get(Integer.valueOf(i));
/*     */     
/*     */     try {
/* 252 */       if (future == null || future.isDone()) {
/* 253 */         b b = this.h.get(Integer.valueOf(i));
/*     */         
/* 255 */         if (b == null) {
/* 256 */           b = new b(parame, (i)a(), this);
/*     */           
/* 258 */           if (t.c.equals(c()) && !this.m) {
/* 259 */             this.h.put(Integer.valueOf(i), b);
/*     */             
/* 261 */             StringBuilder stringBuilder = new StringBuilder();
/* 262 */             stringBuilder
/* 263 */               .append("Lote ")
/* 264 */               .append(parame.bo())
/* 265 */               .append(" entrou em disputa com valor mínimo de R$ ")
/* 266 */               .append(y.a("###,###,###,##0.0000")
/* 267 */                 .format(parame.l()));
/*     */             
/* 269 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 273 */         b.c(paramElements);
/*     */         
/* 275 */         Future<?> future1 = this.a.submit((Runnable)b);
/* 276 */         this.g.put(Integer.valueOf(i), future1);
/*     */       } 
/* 278 */     } catch (Exception exception) {
/* 279 */       a.warn("[Item {}] Failed to start thread from item", parame.bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean b(e parame, double paramDouble) {
/* 284 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 285 */     if (b == null) {
/* 286 */       return false;
/*     */     }
/*     */     
/* 289 */     return b.a(new h(paramDouble), true);
/*     */   }
/*     */   
/*     */   public Map<String, List<h>> k() {
/* 293 */     return this.w;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) throws d {
/* 298 */     if (this.w.isEmpty()) {
/* 299 */       c(parame.a());
/*     */     }
/*     */     
/* 302 */     b b = this.h.get(Integer.valueOf(parame.v()));
/* 303 */     if (b == null) {
/* 304 */       b = new b(parame, (i)a(), this);
/*     */     }
/*     */     
/* 307 */     return b.e();
/*     */   }
/*     */ 
/*     */   
/*     */   public void S() {
/* 312 */     this.m = true;
/* 313 */     R();
/*     */     
/* 315 */     this.g.entrySet().stream().map(paramEntry -> (Future)paramEntry.getValue()).forEachOrdered(paramFuture -> {
/*     */           try {
/*     */             paramFuture.get();
/* 318 */           } catch (Exception exception) {}
/*     */         });
/*     */ 
/*     */     
/* 322 */     this.a.shutdown();
/*     */   }
/*     */ 
/*     */   
/*     */   public void ab() {
/* 327 */     super.ab();
/*     */     
/* 329 */     if (this.a != null) {
/* 330 */       this.a.cancel();
/*     */     }
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 335 */     this.h.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ 
/*     */   
/*     */   public final a a() {
/* 340 */     return (a)super.a();
/*     */   }
/*     */   
/*     */   protected void T() {}
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\r\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */