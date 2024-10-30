/*     */ package br.com.arremate.d.u;
/*     */ 
/*     */ import br.com.arremate.a.j;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.g.c;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.l.a.d;
/*     */ import br.com.arremate.l.f;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */ {
/*  40 */   private static final Logger a = LoggerFactory.getLogger(b.class);
/*     */   
/*     */   private final d a;
/*     */   
/*     */   private final ExecutorService g;
/*     */   
/*     */   private Callable<List<h>> a;
/*     */   
/*     */   private Future<List<h>> b;
/*     */   private Callable<List<h>> b;
/*     */   private Future<List<h>> c;
/*     */   private boolean s;
/*     */   
/*     */   public b(d paramd) {
/*  54 */     this.a = (Callable<List<h>>)paramd;
/*  55 */     this.s = false;
/*  56 */     this.g = Executors.newFixedThreadPool(2);
/*     */   }
/*     */   
/*     */   List<h> a(f paramf) throws d, c {
/*  60 */     e e = paramf.a();
/*     */ 
/*     */     
/*     */     try {
/*  64 */       if (!this.s) {
/*  65 */         List<h> list = f(e);
/*  66 */         this.s = (!list.isEmpty() && ((h)list.get(0)).m() > e.f().m());
/*  67 */         return list;
/*     */       } 
/*     */       
/*  70 */       long l = System.currentTimeMillis();
/*     */       
/*  72 */       if (this.a == null) {
/*  73 */         this.a = (() -> f(parame));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  78 */       if (this.b == null) {
/*  79 */         this.b = (() -> g(parame));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  84 */       this.b = this.g.submit(this.a);
/*  85 */       this.c = this.g.submit(this.b);
/*     */       
/*  87 */       List<h> list1 = this.b.get();
/*  88 */       List<h> list2 = this.c.get();
/*     */       
/*  90 */       l = System.currentTimeMillis() - l;
/*  91 */       double d1 = l / 1000.0D;
/*  92 */       DecimalFormat decimalFormat = new DecimalFormat("#.##");
/*  93 */       paramf.b().a("Realizada a captura dos melhores lances com CAPTCHA para o envio de lances | " + decimalFormat
/*  94 */           .format(d1) + "s", e.bo());
/*     */       
/*  96 */       if (!list1.isEmpty() && ((h)list1.get(0)).m() <= e.f().m()) {
/*  97 */         this.s = false;
/*  98 */         return list1;
/*     */       } 
/*     */       
/* 101 */       if (list2.isEmpty() && !list1.isEmpty()) {
/* 102 */         return list1;
/*     */       }
/*     */       
/* 105 */       if (list2.isEmpty()) {
/* 106 */         a.info("{} - Lista de lances vazia ComprasNet", e.bo());
/*     */       }
/*     */       
/* 109 */       return list2;
/* 110 */     } catch (d|c d1) {
/* 111 */       throw d1;
/* 112 */     } catch (Exception exception) {
/* 113 */       a.info("{} - Falha ao capturar melhores lances ComprasNet", exception, e.bo());
/*     */ 
/*     */       
/* 116 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   List<h> f(e parame) throws d, c {
/* 120 */     e e1 = a((f)parame);
/*     */     
/* 122 */     if (e1.getData().isEmpty()) {
/* 123 */       if (e1.O()) {
/* 124 */         throw new d(e1.k());
/*     */       }
/*     */       
/* 127 */       a.info("{} - Não foi possível capturar os melhores lances: html vazio, statuscode {}", parame
/* 128 */           .bo(), Integer.valueOf(e1.getStatusCode()));
/*     */       
/* 130 */       if (!this.a.isRunning()) {
/* 131 */         throw new c();
/*     */       }
/*     */       
/* 134 */       return new ArrayList<>();
/*     */     } 
/*     */     
/* 137 */     Document document = Jsoup.parse(e1.getData());
/* 138 */     return a(document, parame);
/*     */   }
/*     */   
/*     */   List<h> a(Document paramDocument, e parame) {
/* 142 */     ArrayList<h> arrayList = new ArrayList();
/* 143 */     Elements elements1 = paramDocument.select("table[class=td]");
/*     */     
/* 145 */     if (elements1.isEmpty()) {
/* 146 */       a.info("{} - Não foi possível capturar os melhores lances: não encontrou a lista de lances", parame
/* 147 */           .bo());
/* 148 */       return arrayList;
/*     */     } 
/*     */     
/* 151 */     Elements elements2 = elements1.get(1).select("tr");
/* 152 */     elements2.remove(0);
/*     */     
/* 154 */     byte b1 = 1;
/* 155 */     int i = 0;
/*     */     
/* 157 */     while (i < elements2.size() && i >= 0) {
/* 158 */       String str5, str1 = "";
/* 159 */       String str2 = "";
/* 160 */       String str3 = "";
/* 161 */       String str4 = "";
/*     */       
/* 163 */       String str6 = "";
/* 164 */       String str7 = "";
/* 165 */       String str8 = "";
/* 166 */       boolean bool = false;
/*     */       
/*     */       try {
/* 169 */         Elements elements = elements2.get(i).select("td");
/* 170 */         str6 = elements.get(0).text();
/* 171 */         str7 = elements.get(1).text();
/* 172 */         str2 = elements.get(4).text();
/*     */         
/* 174 */         if (parame.az() && !parame.ay()) {
/* 175 */           Elements elements3 = elements2.get(i + 1).select("td");
/* 176 */           str1 = elements3.get(2).select("span[class=tex5a]").text();
/*     */         } else {
/* 178 */           str1 = elements.get(3).text();
/*     */         } 
/*     */ 
/*     */         
/* 182 */         elements = elements2.get(i + 1).select("span");
/* 183 */         bool = elements.text().toLowerCase().contains("porte da empresa: me");
/* 184 */         str3 = elements.get(6).select("span").get(0).text();
/* 185 */         str3 = str3.substring(0, str3.indexOf(" "));
/* 186 */         str4 = elements.get(1).text();
/* 187 */         str8 = elements.get(11).text();
/* 188 */         str5 = d(elements.get(3));
/* 189 */       } catch (Exception exception) {
/*     */ 
/*     */         
/* 192 */         str5 = "";
/* 193 */         str3 = "";
/*     */       } 
/*     */       
/* 196 */       str1 = str1.replace("R$", "").trim();
/* 197 */       str1 = y.Q(str1);
/* 198 */       double d1 = Double.parseDouble(str1);
/* 199 */       Calendar calendar = y.c(str2);
/*     */       
/* 201 */       h h = new h();
/* 202 */       h.l(b1);
/* 203 */       h.q(d1);
/* 204 */       h.c(calendar.getTime());
/* 205 */       h.x(bool);
/*     */       
/*     */       try {
/* 208 */         long l = Long.parseLong(str6.replaceAll("\\D", ""));
/* 209 */         boolean bool1 = (l == this.a.a().x()) ? true : false;
/* 210 */         h.A(bool1);
/* 211 */       } catch (Exception exception) {
/* 212 */         a.error("error parsing CNPJ", exception);
/*     */       } 
/*     */       
/* 215 */       if (n.bQ()) {
/* 216 */         h.E(str7);
/* 217 */         h.D(str6);
/* 218 */         h.ap(str8);
/* 219 */         h.ao(str3);
/* 220 */         h.al(str4);
/* 221 */         h.am(str5);
/*     */       } 
/*     */       
/* 224 */       arrayList.add(h);
/*     */       
/* 226 */       b1++;
/* 227 */       i = a(i, elements2);
/*     */     } 
/*     */     
/* 230 */     return arrayList;
/*     */   }
/*     */   
/*     */   private List<h> g(e parame) throws c {
/* 234 */     ArrayList<h> arrayList = new ArrayList();
/* 235 */     String str1 = this.a.aS();
/*     */     
/* 237 */     if (str1 == null || str1.isEmpty()) {
/* 238 */       return arrayList;
/*     */     }
/*     */     
/* 241 */     str1 = j.a().a(str1, o.a).a();
/*     */     
/* 243 */     if (str1 == null || str1.isEmpty()) {
/* 244 */       return arrayList;
/*     */     }
/*     */     
/* 247 */     String str2 = this.a.a(parame.v(), parame
/* 248 */         .bo(), parame.a().v(), str1);
/*     */     
/* 250 */     if (str2 == null || str2.isEmpty()) {
/* 251 */       if (!this.a.isRunning()) {
/* 252 */         throw new c();
/*     */       }
/*     */       
/* 255 */       return arrayList;
/*     */     } 
/*     */     
/* 258 */     Document document = Jsoup.parse(str2);
/* 259 */     Elements elements = document.select("tr[class=tex3]");
/* 260 */     byte b1 = 0;
/*     */     
/* 262 */     for (Element element : elements) {
/* 263 */       b1++;
/* 264 */       Elements elements1 = element.select("td");
/* 265 */       Calendar calendar = y.c(elements1.get(0).text());
/*     */       
/* 267 */       String str = elements1.get(1).text().replace("R$", "").trim();
/* 268 */       str = y.Q(str);
/* 269 */       double d1 = Double.parseDouble(str);
/*     */       
/* 271 */       h h = new h();
/* 272 */       h.l(b1);
/* 273 */       h.c(calendar.getTime());
/* 274 */       h.q(d1);
/*     */       
/* 276 */       arrayList.add(h);
/*     */     } 
/*     */     
/* 279 */     arrayList.stream().filter(paramh -> (parame.f() == paramh.m()))
/* 280 */       .forEachOrdered(paramh -> paramh.A(true));
/*     */ 
/*     */ 
/*     */     
/* 284 */     return arrayList;
/*     */   }
/*     */   
/*     */   private String d(Element paramElement) {
/*     */     try {
/* 289 */       String str = paramElement.html();
/* 290 */       return str.substring(0, str.indexOf("<"));
/* 291 */     } catch (Exception exception) {
/*     */ 
/*     */       
/* 294 */       return "";
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private e a(f paramf) {
/* 303 */     e e = new e();
/*     */     
/* 305 */     if (this.a != null) {
/* 306 */       e = this.a.w(paramf.v());
/*     */       
/* 308 */       if (e.getData().contains("Não é possível visualizar os lances") || e
/* 309 */         .getData().contains("Nenhum fornecedor deu lance para este item!")) {
/* 310 */         e.setData("");
/*     */       }
/*     */     } 
/*     */     
/* 314 */     return e;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int a(int paramInt, Elements paramElements) {
/* 325 */     byte b1 = -1;
/*     */     try {
/* 327 */       String str = paramElements.get(paramInt).attr("bgcolor");
/*     */       
/* 329 */       for (int i = paramInt + 1; i < paramElements.size(); i++) {
/* 330 */         if (!paramElements.get(i).attr("bgcolor").equals(str)) {
/* 331 */           return i;
/*     */         }
/*     */       } 
/* 334 */     } catch (Exception exception) {
/* 335 */       a.error("Fim da lista ou indexAtual errado", exception);
/*     */     } 
/*     */     
/* 338 */     return b1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\\\u\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */