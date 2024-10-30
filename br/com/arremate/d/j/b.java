/*     */ package br.com.arremate.d.j;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.d.f;
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.g;
/*     */ import br.com.arremate.f.i;
/*     */ import br.com.arremate.f.s;
/*     */ import br.com.arremate.j.c;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.h.a;
/*     */ import br.com.arremate.l.p.j;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.RoundingMode;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class b
/*     */   extends f
/*     */ {
/*  33 */   private final List<h> o = new ArrayList<>();
/*     */   private i c;
/*     */   private int aa;
/*     */   private int ab;
/*     */   
/*     */   public b(e parame, c paramc, c paramc1) {
/*  39 */     super(parame, (i)paramc, paramc1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  44 */     if (this.c != null) {
/*  45 */       String str = this.c.getString("faseLote");
/*     */       
/*  47 */       if (this.c.has("meuLanceFornecedor")) {
/*  48 */         if (this.c.getInt("doulheLote") == 4) {
/*  49 */           str = g.ay.getValue();
/*     */         }
/*     */         
/*  52 */         String str1 = this.c.getString("meuLanceFornecedor");
/*  53 */         Double double_ = y.a(str1);
/*  54 */         a().h(double_.doubleValue());
/*     */         
/*  56 */         i i1 = this.c.c("listaFornecedores").b(0);
/*     */         
/*  58 */         synchronized (this.o) {
/*  59 */           this.o.clear();
/*  60 */           f f1 = i1.c("melhoresLances");
/*  61 */           f1.iterator().forEachRemaining(paramObject -> {
/*     */                 String str = (String)paramObject;
/*     */                 
/*     */                 this.o.add(new h(y.a(str).doubleValue()));
/*     */               });
/*     */         } 
/*  67 */         if (this.c.getInt("statusMeuLance") == 1) {
/*  68 */           a().a(s.a);
/*  69 */           a().l(double_.doubleValue());
/*  70 */           if (this.o.size() > 0) {
/*  71 */             ((h)this.o.get(0)).A(true);
/*     */           }
/*     */         } else {
/*  74 */           a().a(s.c);
/*  75 */           String str2 = i1.getString("lanceMaximoMinimo");
/*  76 */           Double double_1 = y.a(str2);
/*  77 */           a().l(double_1.doubleValue());
/*     */         } 
/*     */         
/*  80 */         if (a().bu().isEmpty() && this.c.has("meuApelido") && !this.c.isNull("meuApelido")) {
/*  81 */           a().Y(this.c.getString("meuApelido"));
/*     */         }
/*     */       } 
/*     */       
/*  85 */       a().N(str);
/*  86 */       if (a().br()) {
/*  87 */         b().g(a());
/*     */       }
/*     */     } else {
/*  90 */       List<h> list = e();
/*  91 */       if (list.isEmpty()) {
/*     */         return;
/*     */       }
/*     */       
/*  95 */       if (a().f() <= 0.0D) {
/*  96 */         a().h(a().k());
/*     */       }
/*     */       
/*  99 */       Double double_ = Double.valueOf(0.0D);
/* 100 */       for (h h : list) {
/* 101 */         if (h.bb()) {
/* 102 */           double_ = Double.valueOf(h.m());
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 107 */       if (double_.doubleValue() == 0.0D) {
/* 108 */         double_ = Double.valueOf(a().f());
/*     */       }
/*     */       
/* 111 */       if (double_.doubleValue() < a().f()) {
/* 112 */         a().h(double_.doubleValue());
/*     */       }
/*     */       
/* 115 */       a().h(list.get(0));
/* 116 */       s s = ((h)list.get(0)).bb() ? s.a : s.c;
/* 117 */       a().a(s);
/*     */     } 
/*     */     
/* 120 */     aX();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 125 */     return (parami == i.a || a().bu());
/*     */   }
/*     */ 
/*     */   
/*     */   protected h f(List<h> paramList) {
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 136 */     double d = paramh.m();
/*     */     
/*     */     try {
/* 139 */       if (d < a().l() && !paramBoolean) {
/* 140 */         a.warn("Tentativa de enviar lance abaixo do mínimo detectada");
/* 141 */         return false;
/*     */       } 
/*     */       
/* 144 */       a a = (a)a().a();
/*     */       
/* 146 */       DecimalFormat decimalFormat = y.a("##0.00");
/* 147 */       double d1 = Double.parseDouble(decimalFormat.format(d).replace(",", "."));
/*     */       
/* 149 */       if (k.b()) {
/* 150 */         String str1 = (new BigDecimal(d1)).setScale(4, RoundingMode.HALF_EVEN).stripTrailingZeros().toPlainString();
/* 151 */         String str2 = a().a(a, str1);
/* 152 */         i i1 = new i(str2);
/*     */         
/* 154 */         if (i1.has("success")) {
/* 155 */           if (i1.getBoolean("success")) {
/* 156 */             a.y(n.a().longValue());
/* 157 */             a.h(d1);
/* 158 */             a("Lance enviado", paramh, m(), paramBoolean, new String[0]);
/* 159 */             return true;
/*     */           } 
/*     */           
/* 162 */           String str = i1.getString("message");
/* 163 */           if (str.contains("Houve um erro ao salvar o lance.")) {
/* 164 */             j.a().a(a().a(), a().isRunning(), a, paramh);
/*     */             
/* 166 */             b().a().b();
/* 167 */             a().b();
/*     */           } 
/*     */           
/* 170 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Mensagem de erro: " + str });
/*     */         } 
/*     */       } else {
/* 173 */         a.y(n.a().longValue());
/* 174 */         a("Simula disputa", paramh, m(), paramBoolean, new String[0]);
/* 175 */         return true;
/*     */       } 
/* 177 */     } catch (Exception exception) {
/* 178 */       a.warn("Erro ao enviar lance", exception);
/*     */     } 
/*     */     
/* 181 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() {
/* 186 */     List<h> list = b().a().c(a().bo());
/* 187 */     if (list != null) {
/* 188 */       synchronized (this.o) {
/* 189 */         for (h h : this.o) {
/* 190 */           if (!list.stream().filter(paramh2 -> (paramh2.m() == paramh1.m())).findFirst().isPresent()) {
/* 191 */             list.add(h);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 196 */       Collections.sort(list, (paramh1, paramh2) -> (paramh1.m() < paramh2.m()) ? -1 : ((paramh1.m() > paramh2.m()) ? 1 : 0));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 206 */       byte b1 = 1;
/* 207 */       boolean bool = false;
/* 208 */       for (h h : list) {
/* 209 */         h.l(b1);
/* 210 */         b1++;
/*     */         
/* 212 */         if (!bool && (h.ay().equalsIgnoreCase(a().bu()) || h.m() == a().f())) {
/* 213 */           h.A(true);
/* 214 */           bool = true;
/*     */         } 
/*     */       } 
/*     */       
/* 218 */       return list;
/*     */     } 
/*     */     
/* 221 */     synchronized (this.o) {
/* 222 */       return new ArrayList<>(this.o);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aX() {
/*     */     try {
/* 228 */       List<h> list = e();
/* 229 */       long l1 = n.a().longValue();
/* 230 */       long l2 = l1 - TimeUnit.HOURS.toMillis(1L) - TimeUnit.MINUTES.toMillis(5L);
/*     */       
/* 232 */       int j = (int)list.stream().filter(paramh -> (paramh.b() != null && paramh.b().getTime() > paramLong)).count();
/* 233 */       this.aa = j;
/* 234 */       this.ab = list.size() - j;
/* 235 */     } catch (Exception exception) {
/* 236 */       a.warn("[{}] - Fails to capture the item's online and offline users", a().bo(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   int s() {
/* 241 */     return this.aa;
/*     */   }
/*     */   
/*     */   int t() {
/* 245 */     return this.ab;
/*     */   }
/*     */ 
/*     */   
/*     */   public c a() {
/* 250 */     return (c)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public c b() {
/* 255 */     return (c)super.b();
/*     */   }
/*     */   
/*     */   private a a() {
/* 259 */     return (a)a().a();
/*     */   }
/*     */   
/*     */   public void b(i parami) {
/* 263 */     this.c = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\j\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */