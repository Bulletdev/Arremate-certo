/*     */ package br.com.arremate.d.s;
/*     */ 
/*     */ import br.com.arremate.d.b;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.t;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.b.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.c.f;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
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
/*     */   private final ExecutorService executor;
/*     */   private final Map<Integer, Future<?>> m;
/*     */   private final Map<Integer, b> n;
/*     */   
/*     */   public c(b paramb, i parami, boolean paramBoolean) {
/*  37 */     super(paramb, parami);
/*     */     
/*  39 */     a(new a(this, parami));
/*     */     
/*  41 */     this.executor = Executors.newCachedThreadPool();
/*  42 */     this.m = new HashMap<>();
/*  43 */     this.n = new HashMap<>();
/*     */     
/*  45 */     if (paramBoolean) {
/*  46 */       a().b(this);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public t a() {
/*  52 */     t t = t.b;
/*     */     
/*     */     try {
/*  55 */       String str = a().c(a().v()).getData();
/*     */       
/*  57 */       if (!"".equals(str)) {
/*  58 */         String str1 = "";
/*  59 */         Document document = Jsoup.parse(str);
/*  60 */         Elements elements = document.select("form > table");
/*     */         
/*  62 */         if (!elements.isEmpty()) {
/*  63 */           Elements elements1 = elements.first().children().first().children();
/*     */           
/*  65 */           for (Element element : elements1) {
/*  66 */             if (element.text().replace(" ", "").contains(a().bo().replace(" ", ""))) {
/*  67 */               str1 = element.text();
/*  68 */               str1 = str1.substring(str1.lastIndexOf("(") + 1, str1.lastIndexOf(")")).toLowerCase().trim();
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/*     */         } 
/*  74 */         k(str1);
/*     */         
/*  76 */         switch (str1) {
/*     */           case "lances":
/*     */           case "tempo randômico":
/*  79 */             t = t.c;
/*     */             break;
/*     */           case "inscrição de proposta":
/*     */           case "inscrição de propostas":
/*     */           case "aguardando abertura de sessão":
/*     */           case "classificação":
/*  85 */             t = t.b;
/*     */             break;
/*     */           case "suspensa":
/*     */           case "suspenso":
/*  89 */             t = t.e;
/*     */             break;
/*     */           case "em negociação/habilitação":
/*     */           case "homologado":
/*  93 */             t = t.d;
/*     */             break;
/*     */         } 
/*     */       } 
/*  97 */     } catch (Exception exception) {
/*  98 */       h("#004");
/*     */     } 
/*     */     
/* 101 */     return t;
/*     */   }
/*     */ 
/*     */   
/*     */   public void R() {
/*     */     try {
/* 107 */       e e = a().c(a().v());
/* 108 */       e(e.k());
/* 109 */       String str = e.getData();
/*     */       
/* 111 */       if (!"".equals(str)) {
/* 112 */         r(str);
/*     */       }
/* 114 */     } catch (Exception exception) {
/* 115 */       a.error("#003", exception);
/* 116 */       h("#003");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void r(String paramString) {
/*     */     try {
/* 127 */       Document document = Jsoup.parse(paramString);
/* 128 */       Element element = document.select("select[name^=CbCli_Sel]").first();
/* 129 */       Elements elements = element.select("option");
/*     */       
/* 131 */       elements.forEach(paramElement -> {
/*     */             String str = paramElement.attr("value");
/*     */             if (!str.isEmpty() && !str.equals("Todos")) {
/*     */               int i = 0;
/*     */               try {
/*     */                 i = Integer.parseInt(str);
/* 137 */               } catch (Exception exception) {}
/*     */               
/*     */               if (i != 0) {
/*     */                 e e = a(i);
/*     */                 
/*     */                 String str1 = paramElement.text().split("-")[1].trim();
/*     */                 boolean bool = !str1.equalsIgnoreCase(e.bB()) ? true : false;
/*     */                 e.N(str1);
/*     */                 if ((!e.bw() && (!e.br() || bool)) || !isRunning()) {
/*     */                   a(e, bool);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           });
/* 151 */     } catch (Exception exception) {
/* 152 */       a.error("#005", exception);
/* 153 */       h("#005");
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
/*     */   protected void a(e parame, boolean paramBoolean) {
/* 165 */     int i = parame.v();
/*     */     
/*     */     try {
/* 168 */       Future future = this.m.get(Integer.valueOf(i));
/*     */       
/* 170 */       if (future == null || future.isDone() || paramBoolean) {
/* 171 */         b b = this.n.get(Integer.valueOf(i));
/*     */         
/* 173 */         if (b == null) {
/* 174 */           b = new b(parame, (i)a(), this);
/*     */ 
/*     */           
/* 177 */           if (t.c.equals(c()) && isRunning()) {
/* 178 */             this.n.put(Integer.valueOf(i), b);
/*     */             
/* 180 */             String str1 = b.l();
/* 181 */             DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 182 */             String str2 = decimalFormat.format(parame.l());
/*     */             
/* 184 */             StringBuilder stringBuilder = new StringBuilder();
/* 185 */             stringBuilder.append(str1).append(" ").append(parame.bo()).append(" entrou em disputa com valor mínimo de R$ ")
/* 186 */               .append(str2);
/* 187 */             l(stringBuilder.toString());
/*     */           } 
/*     */         } 
/*     */         
/* 191 */         Future<?> future1 = this.executor.submit((Runnable)b);
/* 192 */         this.m.put(Integer.valueOf(i), future1);
/*     */       } 
/* 194 */     } catch (Exception exception) {
/* 195 */       a.warn("Failed to start thread from item " + Integer.toString(i), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c(e parame, double paramDouble) {
/* 200 */     h h = new h(paramDouble);
/* 201 */     b b = new b(parame, (i)a(), this);
/* 202 */     return b.a(h, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<h> b(e parame) {
/*     */     try {
/* 210 */       if (parame.bt() && isRunning()) {
/* 211 */         b b1 = this.n.get(Integer.valueOf(parame.v()));
/* 212 */         return b1.e();
/*     */       } 
/* 214 */       b b = new b(parame, (i)a(), this);
/* 215 */       return b.e();
/*     */     }
/* 217 */     catch (Exception exception) {
/* 218 */       a.warn("{} - Tentativa falha de captura do melhores lances", parame.bo(), exception);
/*     */ 
/*     */       
/* 221 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void S() {
/* 226 */     R();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(f paramf, List<h> paramList) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void T() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final a a() {
/* 243 */     return (a)super.a();
/*     */   }
/*     */   
/*     */   void p(e parame) {
/* 247 */     this.n.remove(Integer.valueOf(parame.v()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\s\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */