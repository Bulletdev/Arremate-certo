/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.k.b.f;
/*     */ import br.com.arremate.l.e;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.l.g;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.l.q.b.f;
/*     */ import br.com.arremate.l.q.b.g;
/*     */ import br.com.arremate.l.q.b.i;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DecimalFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class h
/*     */   extends e
/*     */ {
/*  39 */   private static final long m = TimeUnit.SECONDS.toMillis(15L);
/*     */   
/*  41 */   private final ExecutorService c = Executors.newFixedThreadPool(20);
/*     */   
/*     */   private final Map<g, i> k;
/*     */   protected final DecimalFormat decimalFormat;
/*     */   protected double b;
/*     */   
/*     */   public h(f paramf, e parame, p paramp) {
/*  48 */     super((e)paramf, parame, paramp);
/*     */     
/*  50 */     this.k = new HashMap<>();
/*     */     
/*  52 */     this.decimalFormat = y.a("###,###,###,##0.0000");
/*  53 */     this.b = 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*     */     try {
/*  59 */       if (i() == null) {
/*     */         return;
/*     */       }
/*     */       
/*  63 */       a(i(), (e)a());
/*  64 */       aC();
/*     */       
/*  66 */       if (a().br()) {
/*  67 */         b().g((e)a());
/*     */       }
/*  69 */     } catch (Exception exception) {
/*  70 */       a.warn("Failed to update table data", exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void aC() {
/*  77 */     if (!i().has("itens")) {
/*     */       return;
/*     */     }
/*     */     
/*  81 */     this.k.clear();
/*  82 */     f f = i().c("itens");
/*     */     
/*  84 */     for (byte b = 0; b < f.length(); b++) {
/*  85 */       i i = f.b(b);
/*  86 */       String str = Integer.toString(i.getInt("numero"));
/*  87 */       e e1 = b().a(str);
/*     */       
/*  89 */       if (e1 instanceof g) {
/*  90 */         a(i, e1);
/*  91 */         i i1 = b().a();
/*  92 */         int j = i1.indexOf(e1.v());
/*     */         
/*  94 */         if (j >= 0) {
/*  95 */           i1.fireTableRowsUpdated(j, j);
/*     */         }
/*     */         
/*  98 */         this.k.put((g)e1, i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(br.com.arremate.l.h paramh, boolean paramBoolean) {
/* 105 */     if (paramBoolean) {
/* 106 */       a.warn("Tried to send manual global bid for group");
/* 107 */       return false;
/*     */     } 
/*     */     
/*     */     try {
/* 111 */       double d = paramh.m();
/* 112 */       e e1 = a().a();
/* 113 */       f f = new f(e1, BigDecimal.valueOf(d));
/* 114 */       List list = f.y();
/* 115 */       if (list.isEmpty()) {
/* 116 */         if (e1.b().aD() && e1.k().compareTo(new BigDecimal(paramh.m())) <= 0) {
/* 117 */           b().a(e1.v() + " -> O lance derradeiro não pôde ser enviado pois o intervalo mínimo entre lances estipulado pelo pregoeiro impede o lance em alguns itens.", true);
/*     */         }
/* 119 */         a.info("não é possível enviar lances para o grupo {} usando o valor {}", Integer.valueOf(e1.v()), Double.valueOf(d));
/* 120 */         return false;
/*     */       } 
/*     */       
/* 123 */       a(d);
/* 124 */       this.b = d;
/* 125 */       ArrayList<Future<?>> arrayList = new ArrayList();
/*     */       
/* 127 */       for (br.com.arremate.l.h h1 : list) {
/* 128 */         g g = h1.a();
/*     */ 
/*     */ 
/*     */         
/* 132 */         Optional<g> optional = f().keySet().stream().filter(paramg1 -> (paramg1.v() == paramg.v())).findFirst();
/*     */         
/* 134 */         if (!optional.isPresent()) {
/* 135 */           a.warn("não conseguiu encontrar item {} do grupo {} para enviar lance", Integer.valueOf(g.v()), a().bo());
/*     */           
/*     */           continue;
/*     */         } 
/* 139 */         g g1 = optional.get();
/* 140 */         long l1 = e1.b().t();
/* 141 */         long l2 = g1.a().A() + l1;
/*     */         
/* 143 */         if (n.a().longValue() < l2) {
/*     */           continue;
/*     */         }
/*     */         
/* 147 */         arrayList.add(this.c.submit(() -> a(paramg, paramh, false)));
/*     */       } 
/*     */       
/* 150 */       a(e1, (List)arrayList);
/* 151 */       a.info("lances enviados para o grupo {}", Integer.valueOf(e1.v()));
/* 152 */     } catch (Exception exception) {
/* 153 */       a.error(String.join(" - ", new CharSequence[] { "#025", a().K() }), exception);
/* 154 */       return false;
/*     */     } 
/*     */     
/* 157 */     return true;
/*     */   }
/*     */   
/*     */   private void a(g paramg, br.com.arremate.l.h paramh, boolean paramBoolean) {
/* 161 */     if (!a(paramh.m(), paramg) && !paramBoolean) {
/* 162 */       a.warn("Item {} - Tentativa de lance abaixo do mínimo", paramg.bo());
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/* 167 */       if (!k.b()) {
/* 168 */         paramg.a().y(n.a().longValue());
/* 169 */         a("Lance de simulação", (e)paramg, paramh, m(), paramBoolean, new String[0]);
/*     */         
/*     */         return;
/*     */       } 
/* 173 */       a.info("Enviando lance para o item {} no valor de R${}", paramg.bo(), Double.valueOf(paramh.m()));
/* 174 */       e e1 = a().a(((c)paramg.a()).bk(), paramg.bo(), paramh.m(), u());
/* 175 */       a(paramg, e1, paramh, paramBoolean);
/* 176 */     } catch (d d) {
/* 177 */       b("enviar lance", d);
/* 178 */     } catch (Exception exception) {
/* 179 */       a.error(String.join(" - ", new CharSequence[] { "#025", a().bo() }), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a(double paramDouble, g paramg) {
/* 184 */     return ((paramDouble >= paramg.l() && paramg.l() > 0.0D) || paramg.bv());
/*     */   }
/*     */   
/*     */   private void a(g paramg, e parame, br.com.arremate.l.h paramh, boolean paramBoolean) {
/* 188 */     String str1 = parame.getData().trim();
/* 189 */     a.info("Retorno sobre envio de lance para o item {}, status: {} | message: {}", new Object[] { paramg.bo(), Integer.valueOf(parame.getStatusCode()), str1 });
/*     */     
/* 191 */     if (parame.getStatusCode() != 200 || str1.isEmpty()) {
/* 192 */       a(paramg, str1, parame.getStatusCode(), paramh, paramBoolean);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 197 */     double d = parame.k() / 1000.0D;
/* 198 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 199 */     String str2 = decimalFormat.format(d);
/*     */     
/* 201 */     a("Lance enviado", (e)paramg, paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str2 });
/* 202 */     paramg.a().y(n.a().longValue());
/* 203 */     paramg.w(paramg.aR());
/* 204 */     p(str1);
/*     */   }
/*     */   
/*     */   private void a(g paramg, String paramString, int paramInt, br.com.arremate.l.h paramh, boolean paramBoolean) {
/* 208 */     String str = "Não houve mensagem de retorno do portal!";
/*     */     
/* 210 */     if (!paramString.isEmpty()) {
/* 211 */       i i = new i(paramString);
/*     */       
/* 213 */       if (i.has("message")) {
/* 214 */         str = i.getString("message");
/*     */       }
/*     */     } 
/*     */     
/* 218 */     a("Tentativa de lance", (e)paramg, paramh, m(), paramBoolean, new String[] { str, "Status: " + paramInt });
/*     */   }
/*     */   
/*     */   private void p(String paramString) {
/* 222 */     if (y.n(paramString)) {
/* 223 */       f f = new f(paramString);
/* 224 */       for (byte b = 0; b < f.length(); b++) {
/* 225 */         i i = f.b(b);
/* 226 */         b().g(i);
/*     */       } 
/*     */     } else {
/* 229 */       i i = new i(paramString);
/* 230 */       b().g(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(e parame, List<Future> paramList) throws InterruptedException {
/* 237 */     long l = System.currentTimeMillis();
/* 238 */     boolean bool = true;
/* 239 */     while (System.currentTimeMillis() - l < m) {
/* 240 */       bool = true;
/* 241 */       for (Future future : paramList) {
/* 242 */         if (!future.isDone()) {
/* 243 */           bool = false;
/*     */           break;
/*     */         } 
/*     */       } 
/* 247 */       if (bool) {
/*     */         break;
/*     */       }
/* 250 */       Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
/*     */     } 
/*     */     
/* 253 */     if (!bool) {
/* 254 */       a.warn("nem todos os lances foram enviados em {}ms para o grupo {}", Long.valueOf(m), Integer.valueOf(parame.v()));
/* 255 */       paramList.forEach(paramFuture -> paramFuture.cancel(true));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private synchronized void a(double paramDouble) {
/* 262 */     StringBuilder stringBuilder = new StringBuilder("Lance grupo (");
/* 263 */     stringBuilder.append(a().a().K());
/* 264 */     stringBuilder.append(") de R$ ");
/* 265 */     stringBuilder.append(this.decimalFormat.format(paramDouble));
/* 266 */     b().a(stringBuilder.toString(), false);
/*     */   }
/*     */   
/*     */   public Map<g, i> f() {
/* 270 */     return this.k;
/*     */   }
/*     */ 
/*     */   
/*     */   public f a() {
/* 275 */     return (f)super.a();
/*     */   }
/*     */   
/*     */   protected abstract void a(i parami, e parame);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */