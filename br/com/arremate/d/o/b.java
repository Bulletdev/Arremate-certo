/*     */ package br.com.arremate.d.o;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.m;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.j.g;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.l.a;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ public class b extends f {
/*  27 */   private final List<h> o = new ArrayList<>();
/*     */   private i c;
/*     */   private int aa;
/*     */   private int ab;
/*     */   
/*     */   public b(e parame, i parami, c paramc) {
/*  33 */     super(parame, parami, paramc);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  38 */     if (this.c != null) {
/*  39 */       if (this.c.has("meuLanceFornecedor")) {
/*  40 */         if (a().a().a() != m.a) {
/*  41 */           bl();
/*  42 */           bm();
/*     */         } 
/*     */         
/*  45 */         String str = this.c.getString("meuLanceFornecedor");
/*  46 */         Double double_ = y.a(str);
/*  47 */         a().h(double_.doubleValue());
/*     */         
/*  49 */         i i1 = this.c.c("listaFornecedores").b(0);
/*     */         
/*  51 */         synchronized (this.o) {
/*  52 */           this.o.clear();
/*  53 */           f f1 = i1.c("melhoresLances");
/*  54 */           f1.iterator().forEachRemaining(paramObject -> {
/*     */                 String str = (String)paramObject;
/*     */                 
/*     */                 this.o.add(new h(y.a(str).doubleValue()));
/*     */               });
/*     */         } 
/*  60 */         if (this.c.getInt("statusMeuLance") == 1) {
/*  61 */           a().l(double_.doubleValue());
/*  62 */           boolean bool = (this.o.size() > 1 && ((h)this.o.get(1)).m() == double_.doubleValue()) ? true : false;
/*  63 */           a().a(bool ? s.b : s.a);
/*     */           
/*  65 */           if (this.o.size() > 0) {
/*  66 */             ((h)this.o.get(0)).A(true);
/*     */           }
/*     */         } else {
/*  69 */           String str1 = i1.getString("lanceMaximoMinimo");
/*  70 */           Double double_1 = y.a(str1);
/*  71 */           a().l(double_1.doubleValue());
/*     */           
/*  73 */           boolean bool = (double_1.doubleValue() == double_.doubleValue()) ? true : false;
/*  74 */           a().a(bool ? s.b : s.c);
/*     */         } 
/*     */         
/*  77 */         if (a().bu().isEmpty() && this.c.has("meuApelido") && !this.c.isNull("meuApelido")) {
/*  78 */           a().Y(this.c.getString("meuApelido"));
/*     */         }
/*     */       } 
/*     */       
/*  82 */       bc();
/*     */       
/*  84 */       if (a().br()) {
/*  85 */         b().g(a());
/*     */       }
/*     */     } else {
/*  88 */       List<h> list = e();
/*  89 */       if (list.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*  93 */       if (a().f() <= 0.0D) {
/*  94 */         a().h(a().k());
/*     */       }
/*     */       
/*  97 */       Double double_ = Double.valueOf(0.0D);
/*  98 */       for (h h : list) {
/*  99 */         if (h.bb()) {
/* 100 */           double_ = Double.valueOf(h.m());
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 105 */       if (double_.doubleValue() == 0.0D) {
/* 106 */         double_ = Double.valueOf(a().f());
/*     */       }
/*     */       
/* 109 */       if (double_.doubleValue() < a().f()) {
/* 110 */         a().h(double_.doubleValue());
/*     */       }
/*     */       
/* 113 */       a().h(list.get(0));
/* 114 */       s s = ((h)list.get(0)).bb() ? s.a : s.c;
/* 115 */       a().a(s);
/*     */     } 
/*     */     
/* 118 */     aX();
/*     */   }
/*     */   
/*     */   private void bl() {
/* 122 */     String str = "";
/* 123 */     if (this.c.has("tempoLanceModoFechadoDesc") && !this.c.getString("tempoLanceModoFechadoDesc").equals("0:0:0")) {
/* 124 */       str = this.c.getString("tempoLanceModoFechadoDesc");
/* 125 */     } else if (this.c.has("tempoLanceModoAbertoDesc") && !this.c.getString("tempoLanceModoAbertoDesc").equals("0:0:0")) {
/* 126 */       str = this.c.getString("tempoLanceModoAbertoDesc");
/*     */     } 
/* 128 */     if (str != null && !str.isEmpty()) {
/* 129 */       a().x(y.b(str));
/*     */     } else {
/* 131 */       a().x(0L);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bc() {
/* 136 */     String str = this.c.getString("faseLote");
/* 137 */     if (a().a().a() == m.a && 
/* 138 */       this.c.getInt("doulheLote") == 4) {
/* 139 */       str = g.ay.getValue();
/*     */     }
/*     */ 
/*     */     
/* 143 */     if (a().a().a() == m.b && str.equals("LANCES")) {
/* 144 */       if (this.c.has("tempoLanceModoFechadoDesc") && !this.c.getString("tempoLanceModoFechadoDesc").equals("0:0:0")) {
/* 145 */         str = g.B.getValue();
/* 146 */       } else if (a().z() <= TimeUnit.MINUTES.toMillis(2L)) {
/* 147 */         str = g.I.getValue();
/*     */       } 
/*     */     }
/*     */     
/* 151 */     a().N(str);
/*     */   }
/*     */   
/*     */   private void bm() {
/* 155 */     if (this.c.has("diferencaMinimaLance")) {
/* 156 */       String str = this.c.getString("diferencaMinimaLance");
/* 157 */       BigDecimal bigDecimal = new BigDecimal(y.a(str.replaceAll("[^0-9,]", "")).doubleValue());
/* 158 */       if (str.contains("R$")) {
/* 159 */         a().e(bigDecimal);
/* 160 */       } else if (str.contains("%")) {
/* 161 */         a().f(bigDecimal);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 168 */     return (parami == i.a || 
/* 169 */       a().bu() || (
/* 170 */       g.b(paramString, g.I) && parami == i.b));
/*     */   }
/*     */ 
/*     */   
/*     */   protected h f(List<h> paramList) {
/* 175 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 181 */     double d = paramh.m();
/*     */     
/*     */     try {
/* 184 */       if (d < a().l() && !paramBoolean) {
/* 185 */         a.warn("Tentativa de enviar lance abaixo do mínimo detectada");
/* 186 */         return false;
/*     */       } 
/*     */       
/* 189 */       a a = (a)a().a();
/*     */       
/* 191 */       if (k.b()) {
/* 192 */         String str1 = (new BigDecimal(d)).setScale(4, RoundingMode.HALF_EVEN).stripTrailingZeros().toPlainString();
/* 193 */         String str2 = a().a(a, str1);
/* 194 */         i i1 = new i(str2);
/*     */         
/* 196 */         if (i1.has("success")) {
/* 197 */           if (i1.getBoolean("success")) {
/* 198 */             a.y(n.a().longValue());
/* 199 */             a.h(d);
/* 200 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 201 */             return true;
/*     */           } 
/*     */           
/* 204 */           String str = i1.getString("message");
/* 205 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Mensagem de erro: " + str });
/*     */         } 
/*     */       } else {
/* 208 */         a.y(n.a().longValue());
/* 209 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 210 */         return true;
/*     */       } 
/* 212 */     } catch (Exception exception) {
/* 213 */       a.warn("Erro ao enviar lance", exception);
/*     */     } 
/*     */     
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 221 */     List<h> list = b().a().c(a().bo());
/* 222 */     if (list != null) {
/* 223 */       synchronized (this.o) {
/* 224 */         for (h h : this.o) {
/* 225 */           if (!list.stream().filter(paramh2 -> (paramh2.m() == paramh1.m())).findFirst().isPresent()) {
/* 226 */             list.add(h);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 231 */       Collections.sort(list, (paramh1, paramh2) -> (paramh1.m() < paramh2.m()) ? -1 : ((paramh1.m() > paramh2.m()) ? 1 : 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 241 */       byte b1 = 1;
/* 242 */       boolean bool = false;
/* 243 */       for (h h : list) {
/* 244 */         h.l(b1);
/* 245 */         b1++;
/*     */         
/* 247 */         if (!bool && (h.ay().equalsIgnoreCase(a().bu()) || h.m() == a().f())) {
/* 248 */           h.A(true);
/* 249 */           bool = true;
/*     */         } 
/*     */       } 
/*     */       
/* 253 */       return list;
/*     */     } 
/*     */     
/* 256 */     synchronized (this.o) {
/* 257 */       return new ArrayList<>(this.o);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aX() {
/*     */     try {
/* 263 */       List<h> list = e();
/* 264 */       long l1 = n.a().longValue();
/* 265 */       long l2 = l1 - TimeUnit.HOURS.toMillis(1L) - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 267 */       int j = (int)list.stream().filter(paramh -> (paramh.b() != null && paramh.b().getTime() > paramLong)).count();
/* 268 */       this.aa = j;
/* 269 */       this.ab = list.size() - j;
/* 270 */     } catch (Exception exception) {
/* 271 */       a.warn("[{}] - Fails to capture the item's online and offline users", a().bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   int s() {
/* 276 */     return this.aa;
/*     */   }
/*     */   
/*     */   int t() {
/* 280 */     return this.ab;
/*     */   }
/*     */ 
/*     */   
/*     */   public g a() {
/* 285 */     return (g)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 290 */     return (c)super.b();
/*     */   }
/*     */   
/*     */   private a a() {
/* 294 */     return (a)a().a();
/*     */   }
/*     */   
/*     */   public void b(i parami) {
/* 298 */     this.c = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\o\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */