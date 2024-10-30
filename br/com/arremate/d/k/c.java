/*     */ package br.com.arremate.d.k;
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
/*     */ import br.com.arremate.g.b;
/*     */ import br.com.arremate.g.d;
/*     */ import br.com.arremate.g.e;
/*     */ import br.com.arremate.h.e;
/*     */ import br.com.arremate.j.i;
/*     */ import br.com.arremate.j.i.b;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.i.b;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.time.LocalDate;
/*     */ import java.time.format.DateTimeFormatter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends f
/*     */ {
/*     */   private i c;
/*     */   private a a;
/*     */   
/*     */   public c(e parame, i parami, g paramg) {
/*  40 */     super(parame, parami, paramg);
/*  41 */     a(new a());
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
/*  46 */     if (a().a().a().equals(m.c)) {
/*  47 */       if (this.a == null) {
/*  48 */         this.a = new a(this, true);
/*     */       }
/*     */       
/*  51 */       return this.a.a();
/*     */     } 
/*     */     
/*  54 */     return super.a();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void P() {
/*  59 */     if (this.c != null) {
/*  60 */       a().y(true);
/*  61 */       String str = b(this.c.getInt("codigoSituacaoLote"));
/*  62 */       int j = 0;
/*  63 */       if (this.c.has("tempoDuracaoDisputa")) {
/*  64 */         j = this.c.getInt("tempoDuracaoDisputa");
/*     */       }
/*     */       
/*  67 */       m m = a().a().a();
/*     */       
/*  69 */       long l1 = 0L;
/*  70 */       if (m == m.c) {
/*  71 */         if (str.equals("Em disputa")) {
/*  72 */           l1 = TimeUnit.MINUTES.toMillis(15L);
/*     */         }
/*  74 */       } else if (m == m.b) {
/*  75 */         if (str.equals("Em disputa")) {
/*  76 */           l1 = TimeUnit.MINUTES.toMillis(10L);
/*     */         }
/*     */       } else {
/*  79 */         Date date = ((b)a().a()).c();
/*  80 */         if (date != null) {
/*  81 */           l1 = ((b)a().a()).c().getTime();
/*     */         } else {
/*  83 */           l1 = 0L;
/*     */         } 
/*     */       } 
/*     */       
/*  87 */       long l2 = b().i();
/*  88 */       long l3 = TimeUnit.SECONDS.toMillis(j);
/*  89 */       long l4 = l1 - l3 - l2;
/*  90 */       if (l4 > 0L) {
/*  91 */         a().C(l4);
/*     */       }
/*     */       
/*  94 */       if (m == m.b && str.equals("Em disputa") && l4 <= TimeUnit.MINUTES.toMillis(2L)) {
/*  95 */         a().N(g.I.getValue());
/*     */       } else {
/*  97 */         a().N(str);
/*     */       } 
/*     */       
/* 100 */       j();
/* 101 */       ba();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void f(h paramh) {
/* 106 */     a().h(paramh);
/*     */   }
/*     */   
/*     */   private void b(double paramDouble) {
/* 110 */     a().h(paramDouble);
/*     */   }
/*     */   
/*     */   private void ba() {
/* 114 */     a().ai(this.c.getInt("quantidadeParticipantesAusentes"));
/* 115 */     a().ah(this.c.getInt("quantidadeParticipantesPresentes"));
/*     */   }
/*     */   
/*     */   private void a(h paramh, List<h> paramList) {
/* 119 */     if (paramh.m() == ((h)paramList.get(0)).m()) {
/* 120 */       if (paramh.j() == 1) {
/* 121 */         if (paramList.size() > 1 && ((h)paramList.get(1)).m() == paramh.m()) {
/* 122 */           a().a(s.b);
/*     */         } else {
/* 124 */           a().a(s.a);
/*     */         } 
/*     */       } else {
/* 127 */         a().a(s.b);
/*     */       } 
/*     */     } else {
/* 130 */       a().a(s.c);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String b(int paramInt) {
/* 135 */     switch (paramInt) {
/*     */       case 2:
/*     */       case 3:
/* 138 */         return g.y.getValue();
/*     */       case 4:
/* 140 */         return g.A.getValue();
/*     */       case 6:
/* 142 */         return g.C.getValue();
/*     */       case 11:
/* 144 */         return g.z.getValue();
/*     */       case 13:
/* 146 */         return g.F.getValue();
/*     */       case 15:
/*     */       case 17:
/* 149 */         return g.E.getValue();
/*     */       case 21:
/* 151 */         return g.B.getValue();
/*     */       case 22:
/* 153 */         return g.I.getValue();
/*     */       case 23:
/* 155 */         return g.J.getValue();
/*     */       case 24:
/* 157 */         return g.K.getValue();
/*     */       case -1:
/*     */       case 5:
/* 160 */         return g.D.getValue();
/*     */     } 
/*     */     
/* 163 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 168 */     return j();
/*     */   }
/*     */   
/*     */   private List<h> j() {
/* 172 */     ArrayList<h> arrayList = new ArrayList();
/*     */     
/* 174 */     if (this.c.has("lances")) {
/* 175 */       f f1 = this.c.c("lances");
/* 176 */       h h = null;
/*     */       
/* 178 */       for (byte b = 0; b < f1.length(); b++) {
/* 179 */         i i1 = f1.b(b);
/*     */         
/* 181 */         h h1 = new h();
/* 182 */         h1.l(i1.getInt("classificacao"));
/*     */         
/* 184 */         double d = i1.getDouble("valor");
/* 185 */         h1.q(d);
/* 186 */         h1.A(i1.getBoolean("lanceDoFornecedor"));
/*     */         
/* 188 */         String str = i1.getString("hora");
/* 189 */         DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
/* 190 */         h1.c(y.a(LocalDate.now().format(dateTimeFormatter), str));
/*     */         
/* 192 */         if (h1.bb() && h == null) {
/* 193 */           h = h1;
/*     */         }
/*     */         
/* 196 */         arrayList.add(h1);
/*     */       } 
/*     */       
/* 199 */       if (h != null) {
/* 200 */         b(h.m());
/* 201 */         a(h, arrayList);
/*     */       } 
/*     */       
/* 204 */       f(arrayList.get(0));
/*     */     } 
/*     */     
/* 207 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 212 */     return (parami == i.a || 
/* 213 */       g.b(paramString, g.z) || (
/* 214 */       g.b(paramString, g.I) && parami == i.b) || 
/* 215 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 220 */     if (!b(paramh.m()) && !paramBoolean) {
/* 221 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 222 */       return false;
/*     */     } 
/*     */     
/* 225 */     if (!k.b()) {
/* 226 */       a().a().y(y.i().getTimeInMillis());
/* 227 */       a().w(a().aR());
/* 228 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[] { "Bid: " + 
/* 229 */             String.valueOf(paramh.m()) + " Bidding: " + a().a().v() + " Item: " + a().bo() });
/* 230 */       return true;
/*     */     } 
/*     */     
/*     */     try {
/* 234 */       e e = b().a(a().a().v(), a().bo(), paramh.m());
/* 235 */       if (e.getData().isEmpty()) {
/* 236 */         a.error("Failed to send item, the bid url likely changed or is down");
/* 237 */         return false;
/*     */       } 
/*     */       
/* 240 */       i i1 = new i(e.getData());
/*     */       
/* 242 */       if (e.getStatusCode() == 200) {
/* 243 */         if (i1.has("messages")) {
/* 244 */           f f1 = new f(i1.c("messages"));
/* 245 */           if (!f1.isEmpty()) {
/* 246 */             String str = f1.b(0).getString("text");
/* 247 */             if (str.equals("Lance cadastrado com sucesso.")) {
/* 248 */               if (a().a().a() == m.c) {
/* 249 */                 a().w(a().aR());
/*     */               }
/*     */ 
/*     */               
/* 253 */               a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + e.k() });
/* 254 */               return true;
/*     */             } 
/* 256 */             a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { str, "Tempo para envio: " + e.k() });
/* 257 */             a.error("Failed to send item {} bid; error message: {}; status code: {}; messages size: {}", new Object[] { a().bo(), str, Integer.valueOf(i1.getInt("statusCode")), Integer.valueOf(f1.length()) });
/*     */           } else {
/*     */             
/* 260 */             a.error("Failed to send item {} bid; sem mensagem de retorno; error status: {}", a().bo(), Integer.valueOf(e.getStatusCode()));
/*     */           } 
/*     */         } else {
/*     */           
/* 264 */           a.error("Failed to send item {} bid; error message: {}", a().bo(), i1.toString());
/*     */         } 
/* 266 */       } else if (e.getStatusCode() == 400) {
/* 267 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { i1.getString("msg"), "Tempo para envio: " + e.k() });
/*     */       } else {
/* 269 */         a.error("Failed to send item {} bid; error message: {}; error status: {}", new Object[] { a().bo(), e.getData(), Integer.valueOf(e.getStatusCode()) });
/*     */       } 
/* 271 */     } catch (Exception exception) {
/* 272 */       a.error("Failed to send item {} bid", a().bo(), exception);
/*     */     } 
/*     */     
/* 275 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public b b() {
/* 280 */     return (b)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public e b() {
/* 285 */     return (e)super.b();
/*     */   }
/*     */   
/*     */   public void b(i parami) {
/* 289 */     this.c = parami;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\k\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */