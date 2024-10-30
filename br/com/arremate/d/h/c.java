/*     */ package br.com.arremate.d.h;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.h.a;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.stream.Collectors;
/*     */ import java.util.stream.IntStream;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends f
/*     */ {
/*     */   private Element e;
/*     */   private i c;
/*     */   private String Z;
/*     */   private String aa;
/*     */   private final SimpleDateFormat dateFormat;
/*     */   private final List<Double> m;
/*     */   
/*     */   public c(e parame, a parama, e parame1) {
/*  48 */     super(parame, (i)parama, parame1);
/*  49 */     this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*  50 */     this.m = new ArrayList<>();
/*     */   }
/*     */   
/*     */   protected void P() {
/*     */     try {
/*     */       s s;
/*  56 */       if (this.e == null) {
/*     */         return;
/*     */       }
/*     */       
/*  60 */       if (this.aa == null || this.aa.isEmpty()) {
/*  61 */         this.aa = this.e.select("td[class=td150]").first().select("input[name=ttUsuarioAtivo]").attr("value");
/*     */       }
/*     */ 
/*     */       
/*  65 */       String str1 = a().bB();
/*  66 */       a().N(w());
/*     */       
/*  68 */       if (a().bv() && !a().bB().equals(str1)) {
/*  69 */         DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/*  70 */         String str = decimalFormat.format(a().y());
/*     */         
/*  72 */         b().l(String.join("", new CharSequence[] { "O Item ", a().bo(), " entrou em Lance Fechado com o valor de R$ ", str }));
/*     */       } 
/*     */ 
/*     */       
/*  76 */       Elements elements = this.e.select("td[class=td140][id^=lstLances]").first().getAllElements();
/*  77 */       double d1 = c(elements);
/*  78 */       a().l(d1);
/*     */       
/*  80 */       h(this.e);
/*     */ 
/*     */ 
/*     */       
/*  84 */       double d2 = d1;
/*  85 */       String str2 = elements.select("img").attr("src");
/*     */       
/*  87 */       if (str2.contains("Ganhando")) {
/*  88 */         s = s.a;
/*     */       } else {
/*  90 */         s = s.c;
/*     */         
/*  92 */         if (str2.contains("Empatado")) {
/*  93 */           if (a().bw()) {
/*  94 */             d2 = a().k();
/*     */           } else {
/*  96 */             d2 = b(elements);
/*     */           } 
/*     */           
/*  99 */           if (d2 == d1) {
/* 100 */             s = s.b;
/*     */           }
/*     */         } else {
/* 103 */           d2 = a(elements);
/*     */         } 
/*     */       } 
/*     */       
/* 107 */       a().a(s);
/*     */       
/* 109 */       if (d2 > -1.0D) {
/* 110 */         a().h(d2);
/*     */       }
/*     */       
/* 113 */       aP();
/*     */       
/* 115 */       if (a().br()) {
/* 116 */         b().g(a());
/*     */       }
/* 118 */     } catch (Exception exception) {
/* 119 */       a.error("Failed to update item " + a().bo() + " data", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private double a(Elements paramElements) {
/* 124 */     String str1 = paramElements.select("a").attr("title");
/*     */     
/* 126 */     if (str1.contains("posição") && str1.contains("R$")) {
/* 127 */       str1 = str1.substring(str1.indexOf("R$"), str1.indexOf("posição"));
/*     */     }
/*     */     
/* 130 */     String str2 = str1.replaceAll("[^\\d,.]", "").replace(".", "").replace(",", ".");
/* 131 */     double d = 0.0D;
/*     */     
/* 133 */     if (!str2.isEmpty()) {
/* 134 */       d = Double.parseDouble(str2);
/*     */     }
/*     */     
/* 137 */     return d;
/*     */   }
/*     */   private double b(Elements paramElements) {
/*     */     double d;
/* 141 */     String str = paramElements.select("a").attr("title");
/*     */ 
/*     */     
/* 144 */     if (str.contains("1º (Em empate)")) {
/* 145 */       d = c(paramElements);
/* 146 */     } else if (str.contains("posição") && str.contains("R$")) {
/* 147 */       d = a(paramElements);
/* 148 */     } else if (str.contains("Desclassificado")) {
/* 149 */       d = 0.0D;
/* 150 */     } else if (a().f() == 0.0D) {
/* 151 */       d = a().k();
/*     */     } else {
/*     */       
/* 154 */       d = -1.0D;
/*     */     } 
/*     */     
/* 157 */     return d;
/*     */   }
/*     */   
/*     */   private double c(Elements paramElements) {
/* 161 */     return Double.parseDouble(paramElements.select("input").val());
/*     */   }
/*     */   
/*     */   private void h(Element paramElement) {
/*     */     try {
/* 166 */       Elements elements = paramElement.select("span[class=minBidValue]");
/*     */       
/* 168 */       if (elements == null || elements.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/* 172 */       String str = elements.first().text();
/* 173 */       String[] arrayOfString = str.toUpperCase().split("INTER. MIN.:");
/*     */       
/* 175 */       if (arrayOfString.length < 2) {
/*     */         return;
/*     */       }
/*     */       
/* 179 */       str = arrayOfString[1];
/* 180 */       g g = a().a();
/*     */       
/* 182 */       if (str.contains("R$")) {
/* 183 */         BigDecimal bigDecimal1 = new BigDecimal(a().f().m());
/* 184 */         BigDecimal bigDecimal2 = a().r();
/* 185 */         BigDecimal bigDecimal3 = bigDecimal1.subtract(bigDecimal2);
/* 186 */         if (bigDecimal1.compareTo(BigDecimal.ZERO) != 0 && bigDecimal3.compareTo(bigDecimal2) < 0) {
/* 187 */           if (bigDecimal3.compareTo(BigDecimal.ZERO) > 0) {
/* 188 */             a().e(bigDecimal3.add(new BigDecimal(0.01D)));
/*     */           } else {
/* 190 */             a().e(BigDecimal.ZERO);
/*     */           } 
/*     */         } else {
/* 193 */           Double double_ = Double.valueOf(arrayOfString[1].replace("R$", "").replace(",", ".").trim());
/* 194 */           BigDecimal bigDecimal = BigDecimal.valueOf(double_.doubleValue());
/*     */           
/* 196 */           if (bigDecimal.compareTo(g.r()) != 0) {
/* 197 */             b().a("Novo valor mínimo de redução estabelecido pelo portal: " + str.trim(), g.bo());
/*     */           }
/*     */           
/* 200 */           g.e(bigDecimal);
/*     */         } 
/* 202 */       } else if (str.contains("%")) {
/* 203 */         Double double_ = Double.valueOf(arrayOfString[1].replace("%", "").replace(",", ".").trim());
/* 204 */         BigDecimal bigDecimal = BigDecimal.valueOf(double_.doubleValue());
/*     */         
/* 206 */         if (bigDecimal.compareTo(g.s()) != 0) {
/* 207 */           b().a("Novo percentual mínimo de redução estabelecido pelo portal: " + str.trim(), g.bo());
/*     */         }
/*     */         
/* 210 */         g.f(bigDecimal);
/*     */       } 
/* 212 */     } catch (Exception exception) {
/* 213 */       a.warn("Failed to update minimum value between bids", exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected String w() {
/* 218 */     String str1 = this.e.select("td[class=td100 alignCenter]").first().getAllElements().get(2).attr("alt");
/* 219 */     String str2 = this.e.select("td[class=td150]").first().text();
/*     */     
/* 221 */     if (str2.contains("Proposta recusada") || str2.contains("Proposta rejeitada")) {
/* 222 */       str1 = g.aX.getValue();
/*     */     }
/*     */     
/* 225 */     return str1;
/*     */   }
/*     */   
/*     */   private void aP() {
/* 229 */     if (a().a().a() != m.a) {
/*     */       try {
/* 231 */         Element element = this.e.select("td[class=td60]").first();
/* 232 */         String str = element.select("input").attr("value");
/* 233 */         if (str != null && !str.isEmpty() && !str.equals(this.Z)) {
/* 234 */           this.Z = str;
/*     */           
/* 236 */           SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
/* 237 */           String str1 = simpleDateFormat.format(n.i().getTime());
/* 238 */           str = str1 + " " + str;
/*     */           
/* 240 */           Date date = this.dateFormat.parse(str);
/* 241 */           long l = date.getTime() - n.a().longValue();
/*     */           
/* 243 */           if (l < 0L) {
/* 244 */             l = 0L;
/*     */           }
/*     */           
/* 247 */           if (l > a().z()) {
/* 248 */             a().x(l);
/*     */           }
/*     */         } 
/* 251 */       } catch (ParseException parseException) {
/* 252 */         a.error("Failed to update item time remaining", parseException);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 259 */     return (parami == i.a || 
/* 260 */       g.b(paramString, g.aF) || (
/* 261 */       g.b(paramString, g.aE) && parami == i.b) || 
/* 262 */       a().bv());
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
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/*     */     try {
/* 278 */       if (!b(paramh.m()) && !paramBoolean) {
/* 279 */         b().h(a().bo() + " - Lance abaixo do mínimo para envio.");
/* 280 */         a.warn("{} - Lance abaixo do mínimo para envio.", a().bo());
/* 281 */         return false;
/* 282 */       }  if (this.aa == null || this.aa.isEmpty()) {
/* 283 */         a.info("Element ttUsuarioAtivo null or empty");
/* 284 */         return false;
/*     */       } 
/*     */       
/* 287 */       if (!k.b()) {
/*     */         
/* 289 */         a().a().y(n.a().longValue());
/* 290 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 291 */         return true;
/*     */       } 
/*     */       
/* 294 */       int j = a().a().N();
/* 295 */       String str1 = Integer.toString(a().a().v());
/* 296 */       String str2 = Integer.toString(a().v());
/* 297 */       e e = b().a(paramh.m(), j, str1, str2, this.aa);
/* 298 */       return b(e, paramh, paramBoolean);
/* 299 */     } catch (Exception exception) {
/* 300 */       a.error("Failed to send item bid", exception);
/*     */ 
/*     */       
/* 303 */       return false;
/*     */     } 
/*     */   } private boolean b(e parame, h paramh, boolean paramBoolean) {
/*     */     String str;
/* 307 */     long l = parame.k();
/* 308 */     a.info("Tempo post item {} = {}ms", a().bo(), Long.valueOf(l));
/* 309 */     i i1 = new i(parame.getData());
/*     */     
/* 311 */     if (i1.has("iconeOk") && i1.getString("iconeOk").equals("true")) {
/* 312 */       a().a().y(n.a().longValue());
/*     */       
/* 314 */       DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 315 */       double d = l / 1000.0D;
/* 316 */       String str1 = decimalFormat.format(d);
/*     */       
/* 318 */       a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str1 + "s" });
/* 319 */       this.m.add(Double.valueOf(paramh.m()));
/* 320 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 324 */     if (i1.has("message")) {
/* 325 */       str = i1.getString("message");
/* 326 */     } else if (i1.has("mensagem")) {
/* 327 */       str = i1.getString("mensagem");
/*     */     } else {
/* 329 */       str = "Sem retorno do portal";
/* 330 */       a.warn("Não foi possível identificar mensagem de retorno do portal: {}", i1.toString());
/*     */     } 
/*     */     
/* 333 */     a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Mensagem de erro: " + str });
/*     */ 
/*     */     
/* 336 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 341 */     f f1 = this.c.c("lances");
/* 342 */     List<?> list = (List)IntStream.range(0, f1.length()).mapToObj(paramInt -> new h(paramf.getDouble(paramInt))).collect(Collectors.toList());
/* 343 */     Collections.sort(list, (paramh1, paramh2) -> (paramh1.m() > paramh2.m()) ? 1 : ((paramh1.m() < paramh2.m()) ? -1 : 0));
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
/* 355 */     byte b = 1;
/* 356 */     boolean bool1 = false;
/* 357 */     boolean bool2 = false;
/*     */     
/* 359 */     for (h h : list) {
/* 360 */       h.l(b++);
/*     */       
/* 362 */       if (!bool1 && h.m() == a().f()) {
/* 363 */         h.A(true);
/* 364 */         bool1 = true; continue;
/* 365 */       }  if (!bool2 && a().k() != a().f() && h.m() == a().k()) {
/* 366 */         h.A(true);
/* 367 */         bool2 = true; continue;
/* 368 */       }  if (this.m.contains(Double.valueOf(h.m()))) {
/* 369 */         h.A(true);
/*     */       }
/*     */     } 
/*     */     
/* 373 */     return (List)list;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 378 */     return (a)super.b();
/*     */   }
/*     */   
/*     */   void i(Element paramElement) {
/* 382 */     this.e = paramElement;
/*     */   }
/*     */   
/*     */   protected Element a() {
/* 386 */     return this.e;
/*     */   }
/*     */   
/*     */   protected String x() {
/* 390 */     return this.aa;
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 395 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   public void b(i parami) {
/* 399 */     this.c = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\h\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */