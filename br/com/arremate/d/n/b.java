/*     */ package br.com.arremate.d.n;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.a;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.g.a;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.k.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.commons.text.StringEscapeUtils;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*     */   private i f;
/*     */   private a a;
/*     */   private boolean q = false;
/*     */   
/*     */   public b(e parame, i parami, g paramg) {
/*  47 */     super(parame, parami, paramg);
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws br.com.arremate.g.b, e, a {
/*  52 */     if (a().a().a().equals(m.c)) {
/*  53 */       if (this.a == null) {
/*  54 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  57 */       return this.a.a();
/*     */     } 
/*     */     
/*  60 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  66 */       double d1 = 0.0D;
/*  67 */       double d2 = 0.0D;
/*     */       
/*  69 */       this.f = new i(b().k(a().v()).getData());
/*  70 */       i i1 = this.f.j("definicaoLote");
/*  71 */       if (i1.has("diferencaEntreLances") && !i1.isNull("diferencaEntreLances")) {
/*  72 */         BigDecimal bigDecimal = BigDecimal.valueOf(y.a(i1.getString("diferencaEntreLances")).doubleValue());
/*  73 */         a().e(bigDecimal);
/*     */         
/*  75 */         if (bigDecimal.compareTo(BigDecimal.valueOf(0.01D)) < 0) {
/*  76 */           this.q = true;
/*     */         }
/*     */       } 
/*     */       
/*  80 */       if (this.f.has("melhorLanceDisputa") && !this.f.isNull("melhorLanceDisputa")) {
/*  81 */         d1 = Double.parseDouble(y.Q(this.f.j("melhorLanceDisputa").getString("melhorLanceProposta")));
/*  82 */         if (d1 > 0.0D) {
/*  83 */           a().l(d1);
/*     */         }
/*     */       } 
/*     */       
/*  87 */       if (this.f.has("participacao") && !this.f.isNull("participacao")) {
/*  88 */         i i2 = this.f.j("participacao");
/*     */         
/*  90 */         if (i2.has("notaValorMeuMelhorLance") && !i2.isNull("notaValorMeuMelhorLance")) {
/*  91 */           d2 = Double.parseDouble(y.Q(i2.getString("notaValorMeuMelhorLance")));
/*  92 */           if (d2 > 0.0D) {
/*  93 */             a().h(d2);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/*  98 */       if (d2 != 0.0D && d1 != 0.0D) {
/*  99 */         s s = s.c;
/*     */         
/* 101 */         if (d1 == d2) {
/* 102 */           s = this.f.getBoolean("lotePossuiEmpate") ? s.b : s.a;
/*     */         }
/* 104 */         a().a(s);
/*     */       } 
/*     */       
/* 107 */       long l = d();
/*     */       
/* 109 */       if (l > 0L && l + 1000L > a().z()) {
/* 110 */         a().x(l);
/*     */       }
/*     */       
/* 113 */       String str1 = a().bB();
/* 114 */       String str2 = a(l);
/* 115 */       a().N(str2);
/*     */       
/* 117 */       if (a().bv() && !a().bB().equals(str1)) {
/* 118 */         DecimalFormat decimalFormat = y.a("###,###,###,##0.0000");
/* 119 */         String str = decimalFormat.format(a().y());
/*     */         
/* 121 */         b().l(
/* 122 */             String.join("", new CharSequence[] {
/*     */                 
/* 124 */                 "O Item ", a().bo(), " entrou em Lance Fechado com o valor de R$ ", str
/*     */               }));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 131 */       if (a().br()) {
/* 132 */         b().g(a());
/* 133 */         b().p(a());
/*     */       } 
/* 135 */     } catch (Exception exception) {
/* 136 */       a.error("[MG] Failed to update item data", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 142 */     return (parami == i.a || (parami == i.b && 
/*     */       
/* 144 */       g.b(a().bB(), g.ac)) || (parami == i.b && 
/*     */       
/* 146 */       g.b(a().bB(), g.ab)) || 
/*     */       
/* 148 */       a().bu() || 
/* 149 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 154 */     ArrayList<h> arrayList = new ArrayList();
/* 155 */     HashSet<String> hashSet = new HashSet();
/*     */     
/*     */     try {
/* 158 */       e e = b().j(a().v());
/* 159 */       b().e(e.k());
/* 160 */       f f1 = (new i(e.getData())).c("participacoesOrdenadas");
/* 161 */       if (!f1.isEmpty()) {
/* 162 */         byte b1 = 1;
/* 163 */         for (i i1 : f1) {
/* 164 */           i i2 = i1;
/*     */           try {
/* 166 */             String str1 = i2.getString("identificadorFornecedorFormatado");
/* 167 */             String str2 = i2.getString("melhorLanceProposta");
/* 168 */             String str3 = "";
/* 169 */             if (str1.length() >= 14) {
/* 170 */               str3 = str1;
/*     */             }
/*     */             
/* 173 */             boolean bool = hashSet.add(str1);
/* 174 */             if (bool) {
/*     */               
/* 176 */               h h = new h();
/* 177 */               h.E(str1);
/* 178 */               h.D(str3);
/* 179 */               h.q(Double.parseDouble(y.Q(str2)));
/* 180 */               h.A(i2.getBoolean("isParticipacaoDoRepresentanteLogado"));
/* 181 */               h.l((i2.has("ordemClassificacao") && !i2.isNull("ordemClassificacao")) ? i2.getInt("ordemClassificacao") : b1);
/* 182 */               b1++;
/*     */               
/* 184 */               arrayList.add(h);
/*     */             } 
/* 186 */           } catch (Exception exception) {
/* 187 */             a.error("#005 - Erro ao capturar lance do fornecedor", exception);
/*     */           } 
/*     */         } 
/*     */       } 
/* 191 */     } catch (Exception exception) {
/* 192 */       a.error("#006 - Erro ao capturar melhores lances", exception);
/*     */     } 
/*     */     
/* 195 */     return arrayList;
/*     */   }
/*     */   
/*     */   public List<h> s() {
/* 199 */     ArrayList<h> arrayList = new ArrayList();
/* 200 */     TreeMap<Object, Object> treeMap = new TreeMap<>();
/* 201 */     String str1 = a().a().a().a().ax();
/* 202 */     String str2 = a().a().bG();
/*     */     
/*     */     try {
/* 205 */       e e = b().l(a().v());
/* 206 */       b().e(e.k());
/* 207 */       f f1 = new f(e.getData());
/* 208 */       f f2 = (new i(b().m(a().v()).getData())).c("participacoes");
/* 209 */       if (!f1.isEmpty()) {
/* 210 */         byte b1 = 1;
/* 211 */         for (int j = f1.length() - 1; j != 0; j--) {
/* 212 */           i i1 = f1.b(j);
/*     */           try {
/* 214 */             String str = i1.j("participacaoFornecedorLote").getString("identificadorFornecedorFormatado");
/* 215 */             if (str.length() < 14) {
/* 216 */               return e();
/*     */             }
/* 218 */             Double double_ = Double.valueOf(Double.parseDouble(y.Q(i1.getString("valorTotal"))));
/*     */             
/* 220 */             if (!treeMap.containsKey(str) || ((i)treeMap.get(str)).getDouble("value") > double_.doubleValue()) {
/* 221 */               i i2 = treeMap.containsKey(str) ? (i)treeMap.get(str) : new i();
/* 222 */               i2.c("value", double_);
/*     */               
/* 224 */               if (!i2.has("supplier") || i2.getString("supplier").isEmpty()) {
/* 225 */                 for (byte b2 = 0; b2 < f2.length(); b2++) {
/* 226 */                   i i3 = f2.b(b2);
/* 227 */                   if (i3.getString("identificadorFornecedorCompleto").contains(str)) {
/* 228 */                     i2.c("supplier", i3.getString("identificadorFornecedorCompleto").split("-")[2].trim());
/* 229 */                     i2.a("order", i3.getInt("ordemClassificacao"));
/*     */                     
/*     */                     break;
/*     */                   } 
/*     */                 } 
/*     */               }
/* 235 */               treeMap.put(str, i2);
/*     */             } 
/* 237 */           } catch (Exception exception) {
/* 238 */             a.error("#005 - Erro ao capturar lance do fornecedor", exception);
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 246 */         Map map = (Map)treeMap.entrySet().stream().sorted((paramEntry1, paramEntry2) -> -1 * ((Double)((i)paramEntry2.getValue()).get("value")).compareTo(Double.valueOf(((i)paramEntry1.getValue()).getDouble("value")))).collect(
/* 247 */             Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (parami1, parami2) -> parami1, java.util.LinkedHashMap::new));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 253 */         for (Map.Entry entry : map.entrySet()) {
/* 254 */           String str3 = "";
/* 255 */           if (((String)entry.getKey()).length() >= 14) {
/* 256 */             str3 = (String)entry.getKey();
/*     */           }
/*     */           
/* 259 */           String str4 = ((i)entry.getValue()).has("supplier") ? ((i)entry.getValue()).getString("supplier") : "";
/*     */           
/* 261 */           h h = new h();
/* 262 */           h.E(str4);
/* 263 */           h.D(str3);
/* 264 */           h.q(((i)entry.getValue()).getDouble("value"));
/* 265 */           h.A((((String)entry.getKey()).equals(str1) || ((String)entry.getKey()).equals(str2)));
/* 266 */           h.l(((i)entry.getValue()).has("order") ? ((i)entry.getValue()).getInt("order") : b1);
/* 267 */           b1++;
/*     */           
/* 269 */           arrayList.add(h);
/*     */         } 
/*     */       } 
/* 272 */     } catch (Exception exception) {
/* 273 */       a.error("#006 - Erro ao capturar melhores lances", exception);
/*     */     } 
/*     */     
/* 276 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int[] a() {
/* 285 */     int[] arrayOfInt = { 0, 0 };
/*     */     
/*     */     try {
/* 288 */       List<h> list = e();
/* 289 */       long l1 = n.a().longValue();
/* 290 */       long l2 = l1 - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 292 */       int j = (int)list.stream().filter(paramh -> (paramh.b() != null && paramh.b().getTime() > paramLong)).count();
/*     */       
/* 294 */       arrayOfInt[0] = j;
/* 295 */       arrayOfInt[1] = list.size() - j;
/* 296 */     } catch (Exception exception) {
/* 297 */       a.error(String.join(" - ", new CharSequence[] { "#035", a().bo() }), exception);
/*     */     } 
/*     */     
/* 300 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   protected String a(long paramLong) {
/* 304 */     String str = this.f.j("situacao").getString("descricao");
/*     */     
/* 306 */     if (a().a().a() == m.b) {
/* 307 */       if (paramLong > 0L && paramLong <= 120000L) {
/* 308 */         str = "Tempo de iminência - modo aberto";
/*     */       }
/*     */     } else {
/* 311 */       if (paramLong <= 0L && str.equals("Disputa aberta iniciada")) {
/* 312 */         str = "Tempo randômico iniciado";
/*     */       }
/* 314 */       a a1 = (a)a().a();
/*     */       
/* 316 */       if (g.b(str, g.P) && 
/* 317 */         !a1.aR() && a1
/* 318 */         .bh()) {
/* 319 */         str = g.p.getValue();
/*     */       }
/*     */     } 
/*     */     
/* 323 */     return str;
/*     */   }
/*     */   
/*     */   private long d() {
/* 327 */     long l = y.i().getTimeInMillis();
/* 328 */     if (this.f.has("dataFim") && !this.f.isNull("dataFim") && !this.f.getString("dataFim").isEmpty()) {
/* 329 */       String str = this.f.getString("dataFim");
/* 330 */       l = y.c(y.Y(str)).getTimeInMillis();
/*     */     } 
/*     */     
/* 333 */     return l - y.i().getTimeInMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 339 */     a a1 = (a)a().a();
/* 340 */     double d = paramh.m();
/*     */ 
/*     */     
/*     */     try {
/* 344 */       if (!k.b()) {
/* 345 */         a1.w(a1.aR());
/* 346 */         a1.y(n.a().longValue());
/* 347 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 348 */         return true;
/*     */       } 
/*     */ 
/*     */       
/* 352 */       e e = b().a(a1, d, this.q);
/*     */       
/* 354 */       String str1 = "";
/* 355 */       i i1 = null;
/*     */       
/* 357 */       if (e != null) {
/* 358 */         if (!e.getData().isEmpty() && e.getData().charAt(0) == '{') {
/*     */           try {
/* 360 */             if (e.getStatusCode() == 422) {
/* 361 */               str1 = "A atual situação do item não permite envio de lance";
/*     */             } else {
/* 363 */               i1 = new i(e.getData());
/* 364 */               str1 = StringEscapeUtils.unescapeJava(i1.c("erros").b(0).getString("mensagem"));
/*     */             } 
/* 366 */           } catch (Exception exception) {}
/*     */         } else {
/*     */           
/* 369 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str1 });
/*     */         } 
/*     */       }
/*     */       
/* 373 */       String str2 = b(d);
/*     */       
/* 375 */       if (str1.isEmpty() && i1 != null) {
/* 376 */         if (e.getStatusCode() == 200 && i1.has("id") && !i1.isNull("id")) {
/* 377 */           if (i1.getBoolean("necessidadeDesafioCaptcha")) {
/* 378 */             h("Necessidade de desafio captcha com valor verdadeiro");
/*     */           }
/*     */           
/* 381 */           if (a1.a().a() == m.c && a1.aR()) {
/* 382 */             a1.w(true);
/*     */           }
/*     */           
/* 385 */           a1.y(n.a().longValue());
/* 386 */           a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 387 */           return true;
/*     */         } 
/* 389 */         str1 = "Não foi possível enviar o lance (" + str2 + "), caso persista, envie o lance diretamente no portal e contate o suporte";
/*     */       } 
/*     */ 
/*     */       
/* 393 */       if (!str1.isEmpty()) {
/* 394 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str1 });
/* 395 */         b().a("Retorno do portal ao envio de lance com problemas, status: " + e.getStatusCode() + " body: " + i1, false);
/*     */       } 
/* 397 */     } catch (Exception exception) {
/* 398 */       a.error("#008 - Envia lance lote {}", a1.bo(), exception);
/*     */     } 
/*     */     
/* 401 */     return false;
/*     */   }
/*     */   
/*     */   private String b(double paramDouble) {
/*     */     DecimalFormat decimalFormat;
/* 406 */     if (this.q) {
/* 407 */       decimalFormat = y.a("###,###,##0.0000");
/*     */     } else {
/* 409 */       decimalFormat = y.a("###,###,##0.00");
/*     */     } 
/*     */     
/* 412 */     return decimalFormat.format(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 417 */     return (e)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 422 */     return (c)super.b();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\n\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */