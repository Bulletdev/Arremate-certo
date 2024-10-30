/*     */ package br.com.arremate.d.m;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.q;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.j.d;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.n;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.apache.commons.text.StringEscapeUtils;
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
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private i b;
/*     */   private final boolean p;
/*     */   private a a;
/*     */   private boolean q = false;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  50 */     super(parame, parami, paramg);
/*     */     
/*  52 */     this.p = n.a().a(q.h);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws br.com.arremate.g.b, e, a {
/*  57 */     if (a().a().a().equals(m.c)) {
/*  58 */       if (this.a == null) {
/*  59 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  62 */       return this.a.a();
/*     */     } 
/*     */     
/*  65 */     return super.a();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  72 */       String str = this.b.getString("situacao");
/*     */       
/*  74 */       if (a().a().a() == m.a)
/*     */       {
/*  76 */         if (str.equals("Abertura de lances concluída")) {
/*  77 */           String str1 = this.b.getString("tempoDeIminencia");
/*  78 */           if (!str1.equals("-") && !str1.equals("Encerrado")) {
/*  79 */             str = "Tempo de iminência iniciado";
/*     */           }
/*     */         } 
/*     */       }
/*     */       
/*  84 */       double d1 = 0.0D;
/*  85 */       if (this.b.has("melhorValor")) {
/*  86 */         String str1 = this.b.getString("melhorValor");
/*  87 */         d1 = Double.parseDouble(y.Q(str1));
/*     */         
/*  89 */         str1 = str1.substring(str1.indexOf(",") + 1);
/*  90 */         this.q = (str1.length() > 2);
/*     */       } 
/*     */       
/*  93 */       double d2 = 0.0D;
/*  94 */       if (this.b.has("meuMelhorValor")) {
/*  95 */         d2 = Double.parseDouble(y.Q(this.b.getString("meuMelhorValor")));
/*     */       }
/*     */       
/*  98 */       s s = this.b.getBoolean("bandeiraFornVencedor") ? s.a : s.c;
/*     */       
/* 100 */       a().l(d1);
/* 101 */       a().h(d2);
/* 102 */       a().a(s);
/*     */       
/* 104 */       if (a().a().a() != m.a) {
/* 105 */         w(str);
/*     */       } else {
/* 107 */         a().N(str);
/*     */       } 
/*     */       
/* 110 */       if (a().br()) {
/* 111 */         b().g(a());
/* 112 */         b().p(a());
/*     */       } 
/* 114 */     } catch (Exception exception) {
/* 115 */       a.error("#020", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean t() {
/* 121 */     return (super.t() && N());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean N() {
/* 130 */     if (this.p && a().a().a() == m.a) {
/* 131 */       a a1 = (a)a().a();
/*     */       
/* 133 */       if (a1.D() > 0L) {
/* 134 */         long l1 = n.a().longValue();
/* 135 */         long l2 = l1 - a1.D();
/*     */ 
/*     */         
/* 138 */         if (l2 <= 285000L) {
/* 139 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 149 */     return (parami == i.a || (parami == i.b && 
/*     */       
/* 151 */       g.b(a().bB(), g.ac)) || (parami == i.b && 
/*     */       
/* 153 */       g.b(a().bB(), g.ab)) || 
/*     */       
/* 155 */       a().bu() || 
/* 156 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 161 */     ArrayList<h> arrayList = new ArrayList();
/* 162 */     HashSet<String> hashSet = new HashSet();
/*     */     
/*     */     try {
/* 165 */       String str = b().a(Integer.valueOf(a().a().v()), Integer.valueOf(a().a().v()));
/* 166 */       if (!"".equals(str)) {
/* 167 */         Document document = Jsoup.parse(str);
/* 168 */         Elements elements1 = document.select("table#tabelaLancesPregao > tbody > tr");
/* 169 */         Elements elements2 = document.select("a.outrasPaginas");
/* 170 */         byte b1 = 0;
/*     */         
/*     */         do {
/* 173 */           for (Element element : elements1) {
/*     */             try {
/* 175 */               String str1 = element.select("span[id^=identificacao_]").first().text().trim();
/* 176 */               String str2 = element.select("span[id^=dataLance_]").first().text().trim();
/* 177 */               String str3 = element.select("span[id^=horaLance_]").first().text().trim();
/* 178 */               String str4 = element.select("span[id^=valor_]").first().text().trim().replace(".", "").replace(",", ".");
/* 179 */               String str5 = "";
/* 180 */               Element element1 = element.select("span[id^=cnpjCpf_]").first();
/*     */               
/* 182 */               if (element1 != null) {
/* 183 */                 str5 = element1.text().trim();
/*     */               }
/*     */               
/* 186 */               Element element2 = element.select("span[id^=nomeForn_]").first();
/*     */               
/* 188 */               if (element2 != null) {
/* 189 */                 str1 = element2.text().trim();
/*     */               }
/*     */               
/* 192 */               boolean bool = hashSet.add(str1);
/* 193 */               if (bool) {
/* 194 */                 SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
/* 195 */                 Date date = simpleDateFormat.parse(str2 + " " + str3);
/*     */                 
/* 197 */                 h h = new h();
/* 198 */                 h.c(date);
/* 199 */                 h.E(str1);
/* 200 */                 h.D(str5);
/* 201 */                 h.q(Double.parseDouble(str4));
/* 202 */                 h.A((h.m() == a().f()));
/* 203 */                 h.l(hashSet.size());
/*     */                 
/* 205 */                 arrayList.add(h);
/*     */               } 
/* 207 */             } catch (Exception exception) {
/* 208 */               a.error("#005 - Erro ao capturar lance do fornecedor", exception);
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 213 */           if (b1 >= elements2.size())
/* 214 */             continue;  str = b().b(elements2.get(b1).attr("href"));
/* 215 */           if (!"".equals(str)) {
/* 216 */             document = Jsoup.parse(str);
/* 217 */             elements1 = document.select("table#tabelaLancesPregao > tbody > tr");
/*     */           } else {
/*     */             break;
/*     */           } 
/*     */ 
/*     */           
/* 223 */           ++b1;
/* 224 */         } while (b1 <= elements2.size());
/*     */       } 
/* 226 */     } catch (Exception exception) {
/* 227 */       a.error("#006 - Erro ao capturar melhores lances", exception);
/* 228 */       h("#006 - Erro ao capturar melhores lances");
/*     */     } 
/*     */     
/* 231 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 240 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 243 */       List<h> list = e();
/* 244 */       long l1 = n.a().longValue();
/* 245 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 247 */       int j = (int)list.stream().filter(paramh -> (paramh.b().getTime() > paramLong)).count();
/*     */       
/* 249 */       arrayOfInt[0] = j;
/* 250 */       arrayOfInt[1] = list.size() - j;
/* 251 */     } catch (Exception exception) {
/* 252 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/* 253 */       b().h("#035 - " + a().bo());
/*     */     } 
/*     */     
/* 256 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   protected void w(String paramString) {
/* 260 */     String str1 = this.b.getString("tempoDeSessaoAberta");
/* 261 */     if (str1.equals("-") || str1.equals("Encerrado")) {
/* 262 */       str1 = this.b.getString("tempoDeSessaoFechada");
/*     */     }
/*     */     
/* 265 */     int j = 0;
/* 266 */     int k = 0;
/*     */     
/* 268 */     if (!str1.equals("-") && !str1.equals("Encerrado")) {
/* 269 */       String[] arrayOfString = str1.split(":");
/* 270 */       j = Integer.parseInt(arrayOfString[0]);
/* 271 */       k = Integer.parseInt(arrayOfString[1]);
/*     */     } 
/*     */     
/* 274 */     long l = TimeUnit.MINUTES.toMillis(j) + TimeUnit.SECONDS.toMillis(k);
/*     */     
/* 276 */     if (l > 0L) {
/* 277 */       if (l <= 120000L && a().a().a() == m.b) {
/* 278 */         paramString = "Tempo de iminência - modo aberto";
/*     */       }
/*     */       
/* 281 */       if (l + 1000L > a().z()) {
/* 282 */         a().x(l);
/*     */       }
/* 284 */     } else if (paramString.equals("Disputa aberta iniciada") && a().a().a() != m.b) {
/* 285 */       a().x(0L);
/* 286 */       paramString = "Tempo randômico iniciado";
/*     */     } 
/*     */     
/* 289 */     a a1 = (a)a().a();
/* 290 */     if (g.b(paramString, g.P) && !a1.aR() && a1.bh()) {
/* 291 */       paramString = g.p.getValue();
/*     */     }
/*     */     
/* 294 */     String str2 = a().bB();
/* 295 */     a().N(paramString);
/*     */     
/* 297 */     if (a().bv() && !a().bB().equals(str2)) {
/* 298 */       DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 299 */       String str = decimalFormat.format(a().y());
/*     */       
/* 301 */       b().l(
/* 302 */           String.join("", new CharSequence[] {
/*     */               
/* 304 */               "O Item ", a().bo(), " entrou em Lance Fechado com o valor de R$ ", str
/*     */             }));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 313 */     a a1 = (a)a().a();
/* 314 */     double d = paramh.m();
/*     */     
/*     */     try {
/*     */       DecimalFormat decimalFormat;
/* 318 */       if (!k.b()) {
/* 319 */         a1.w(a1.aR());
/* 320 */         a1.y(n.a().longValue());
/* 321 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 322 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 326 */       String str1 = b().a(a1, d, this.q);
/* 327 */       String str2 = "";
/* 328 */       i i1 = null;
/*     */       
/* 330 */       if (str1 != null) {
/* 331 */         if (!str1.isEmpty() && str1.charAt(0) == '{') {
/*     */           try {
/* 333 */             i1 = new i(str1);
/* 334 */             str2 = StringEscapeUtils.unescapeJava(i1.c("erros").b(0).getString("mensagem"));
/* 335 */           } catch (Exception exception) {}
/*     */         } else {
/*     */           
/* 338 */           String str = "";
/* 339 */           if (str1.contains("mensagemErroCritico")) {
/* 340 */             str = "mensagemErroCritico.erroGeral";
/* 341 */           } else if (str1.contains("erroEnvioLanceSiutacaoLoteInvalida")) {
/* 342 */             str = "erroEnvioLanceSiutacaoLoteInvalida";
/*     */           } 
/*     */           
/* 345 */           if (!str.isEmpty()) {
/* 346 */             Document document = Jsoup.parse(str1);
/* 347 */             Element element = document.select("span[id=" + str + "]").first();
/* 348 */             str2 = element.text();
/*     */             
/* 350 */             a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str2 });
/*     */           } 
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 356 */       if (this.q) {
/* 357 */         decimalFormat = y.a("###,###,##0.0000");
/*     */       } else {
/* 359 */         decimalFormat = y.a("###,###,##0.00");
/*     */       } 
/*     */       
/* 362 */       String str3 = decimalFormat.format(d);
/*     */       
/* 364 */       if (str2.isEmpty() && i1 != null) {
/* 365 */         f f1 = i1.c("lotes");
/*     */         
/* 367 */         for (byte b1 = 0; b1 < f1.length(); b1++) {
/* 368 */           i i2 = f1.b(b1);
/* 369 */           if (i2.getInt("idLote") == a1.v()) {
/*     */             
/* 371 */             String str = i2.getString("meuMelhorValor");
/* 372 */             if (str3.equals(str)) {
/* 373 */               if (a1.a().a() == m.c && a1.aR()) {
/* 374 */                 a1.w(true);
/*     */               }
/* 376 */               a1.y(n.a().longValue());
/* 377 */               a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 378 */               return true;
/*     */             } 
/* 380 */             str2 = String.join("", new CharSequence[] { "Valor enviado(", str3, ") diferente do capturado(", str, ") para validação" });
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 385 */       } else if (str2.isEmpty()) {
/*     */         
/* 387 */         HashSet<Integer> hashSet = new HashSet();
/* 388 */         hashSet.add(Integer.valueOf(a1.v()));
/* 389 */         i i2 = b().a(hashSet);
/*     */         
/* 391 */         if (i2 != null && !i2.has("msgErro")) {
/* 392 */           f f1 = i2.c("lotes");
/*     */           
/* 394 */           String str = f1.b(0).getString("meuMelhorValor");
/* 395 */           if (str3.equals(str)) {
/* 396 */             if (a1.a().a() == m.c && a1.aR()) {
/* 397 */               a1.w(true);
/*     */             }
/* 399 */             a1.y(n.a().longValue());
/* 400 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/*     */             
/* 402 */             return true;
/*     */           } 
/* 404 */           str2 = String.join("", new CharSequence[] { "Valor enviado(", str3, ") diferente do capturado(", str, ") para validação" });
/*     */         } else {
/*     */           
/* 407 */           str2 = "Falha ao validar se o lance foi enviado";
/*     */           
/* 409 */           if (i2 != null && i2.has("msgErro")) {
/* 410 */             str2 = i2.getString("msgErro");
/*     */           }
/*     */           
/* 413 */           if (str2.contains("não se encontra em situação")) {
/* 414 */             str2 = str2 + " -- Situação: " + a().bB();
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 419 */       if (!str2.isEmpty()) {
/* 420 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str2 });
/*     */       }
/* 422 */     } catch (Exception exception) {
/* 423 */       a.error("#008 - Envia lance lote {}", a1.bo(), exception);
/* 424 */       h("#008 - Envia lance lote " + a1.bo());
/*     */     } 
/*     */     
/* 427 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public d b() {
/* 432 */     return (d)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 437 */     return (c)super.b();
/*     */   }
/*     */   
/*     */   public void a(i parami) {
/* 441 */     this.b = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\m\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */