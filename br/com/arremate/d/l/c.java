/*     */ package br.com.arremate.d.l;
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
/*     */ import br.com.arremate.j.j.a;
/*     */ import br.com.arremate.k.b.a;
/*     */ import br.com.arremate.l.h;
/*     */ import br.com.arremate.l.q.b.e;
/*     */ import br.com.arremate.m.y;
/*     */ import java.text.DecimalFormat;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicLong;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class c
/*     */   extends f
/*     */ {
/*     */   private final List<Double> m;
/*     */   private final SimpleDateFormat b;
/*  41 */   private final long k = TimeUnit.SECONDS.toMillis(10L);
/*  42 */   private a a = (a)new AtomicLong(0L);
/*     */   
/*     */   private final AtomicLong a;
/*     */   private i c;
/*     */   private f e;
/*     */   
/*     */   public c(e parame, i parami, g paramg) {
/*  49 */     super(parame, parami, paramg);
/*  50 */     a(new a());
/*  51 */     this.m = new ArrayList<>();
/*  52 */     this.b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
/*     */   }
/*     */ 
/*     */   
/*     */   protected h a() throws b, e, a {
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
/*     */   protected void P() {
/*  70 */     if (this.c != null) {
/*  71 */       bc();
/*  72 */       bd();
/*  73 */       ay();
/*  74 */       be();
/*  75 */       az();
/*  76 */       bf();
/*     */     } 
/*     */     
/*  79 */     if (a().br()) {
/*  80 */       b().g(a());
/*  81 */       b().p(a());
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bc() {
/*  86 */     if (!this.c.isNull("status")) {
/*  87 */       String str = this.c.getString("status").toLowerCase();
/*  88 */       long l = a().z();
/*  89 */       if (a().a().a() == m.b && str
/*  90 */         .equals("disputa") && l > 0L && l <= 120000L) {
/*     */ 
/*     */         
/*  93 */         a().N("prorrogacao");
/*     */       } else {
/*  95 */         a().N(str);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void bd() {
/* 101 */     if (!this.c.isNull("closingTime")) {
/* 102 */       String str = this.c.getString("closingTime");
/* 103 */       if (!str.isEmpty()) {
/* 104 */         Calendar calendar = y.c(y.X(str));
/* 105 */         long l = calendar.getTimeInMillis() - y.i().getTimeInMillis();
/* 106 */         if (l > a().z()) {
/* 107 */           a().x(l);
/*     */         }
/*     */       } else {
/* 110 */         a().x(0L);
/*     */       } 
/*     */     } else {
/* 113 */       a().x(0L);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void ay() {
/* 118 */     if (!this.c.isNull("bestValidBid")) {
/* 119 */       a().l(this.c.getDouble("bestValidBid"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void be() {
/* 124 */     if (!this.c.isNull("myBestValidBid")) {
/* 125 */       a().h(this.c.getDouble("myBestValidBid"));
/*     */     }
/*     */   }
/*     */   
/*     */   private void az() {
/* 130 */     e e = a();
/* 131 */     a().a((e.f() == e.f().m()) ? s.a : s.c);
/*     */   }
/*     */   
/*     */   private void bf() {
/* 135 */     if (a().a().a() == m.c && !a().a().aS() && 
/* 136 */       a().bB().equals("fechado") && 
/* 137 */       this.c.getBoolean("isAvailableBid")) {
/* 138 */       a().v(true);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean a(i parami, String paramString) {
/* 145 */     return (parami == i.a || 
/* 146 */       g.b(paramString, g.bo) || (
/* 147 */       g.b(paramString, g.bn) && parami == i.b) || 
/* 148 */       a().bv());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(h paramh, boolean paramBoolean) {
/* 153 */     if (!b(paramh.m()) && !paramBoolean) {
/* 154 */       a.warn("Tentativa de lance abaixo do mínimo");
/* 155 */       return false;
/*     */     } 
/*     */     
/* 158 */     if (!k.b()) {
/* 159 */       a().a().y(y.i().getTimeInMillis());
/* 160 */       a().w(a().aR());
/* 161 */       a("Lance de simulação", paramh, m(), paramBoolean, new String[] { "Bid: " + 
/* 162 */             String.valueOf(paramh.m()) + " Bidding: " + a().a().v() + " Item: " + a().bo() });
/* 163 */       return true;
/*     */     } 
/*     */     
/*     */     try {
/* 167 */       e e = b().a(a().a().v(), a().bo(), String.valueOf(paramh.m()));
/* 168 */       String str = b(e);
/*     */       
/* 170 */       if (e.getData().isEmpty()) {
/* 171 */         if (e.getStatusCode() == 429) {
/* 172 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Portal está em sobrecarga" });
/*     */         } else {
/* 174 */           a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { "Sem retorno do portal", "Tempo para retorno: " + str });
/*     */         } 
/* 176 */         a.warn("Failed to send bid, empty response for item {}, value: {}, status code: {}", new Object[] { a().bo(), Double.valueOf(paramh.m()), Integer.valueOf(e.getStatusCode()) });
/* 177 */         return false;
/*     */       } 
/*     */       
/* 180 */       if (e.getStatusCode() == 201) {
/* 181 */         if (a().a().a() == m.c) {
/* 182 */           a().w(a().aR());
/*     */         }
/*     */         
/* 185 */         a("Lance enviado", paramh, m(), paramBoolean, new String[] { "Tempo para envio: " + str });
/* 186 */         this.m.add(Double.valueOf(paramh.m()));
/* 187 */         return true;
/*     */       } 
/* 189 */       i i1 = new i(e.getData());
/* 190 */       if (i1.has("msg")) {
/* 191 */         a("Tentativa de lance", paramh, m(), paramBoolean, new String[] { i1.getString("msg"), "Tempo para envio: " + str });
/*     */       }
/*     */       
/* 194 */       return false;
/* 195 */     } catch (Exception exception) {
/* 196 */       a.error("Failed to send item {} bid", a().bo(), exception);
/*     */ 
/*     */       
/* 199 */       return false;
/*     */     } 
/*     */   }
/*     */   private String b(e parame) {
/* 203 */     double d = parame.k() / 1000.0D;
/* 204 */     DecimalFormat decimalFormat = new DecimalFormat("#.##");
/* 205 */     return decimalFormat.format(d);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<h> e() throws d {
/* 210 */     if (this.e != null) {
/* 211 */       return q();
/*     */     }
/* 213 */     return r();
/*     */   }
/*     */ 
/*     */   
/*     */   private List<h> q() {
/*     */     try {
/* 219 */       return b(this.e);
/* 220 */     } catch (Exception exception) {
/* 221 */       a.error("Failed to read item {} best bids", a().bo(), exception);
/*     */ 
/*     */       
/* 224 */       return new ArrayList<>();
/*     */     } 
/*     */   }
/*     */   private List<h> r() {
/* 228 */     List<h> list = new ArrayList();
/*     */     
/*     */     try {
/* 231 */       if (this.a.get() > 0L) {
/* 232 */         Long long_ = Long.valueOf(System.currentTimeMillis());
/* 233 */         long_ = Long.valueOf(long_.longValue() - this.a.get());
/* 234 */         if (long_.longValue() < this.k) {
/* 235 */           Thread.sleep(this.k - long_.longValue());
/*     */         }
/*     */       } 
/*     */       
/* 239 */       e e = b().l(a().a().v(), a().bo());
/* 240 */       this.a.set(System.currentTimeMillis());
/*     */       
/* 242 */       String str = e.getData();
/* 243 */       if (!y.m(str)) {
/* 244 */         a.warn("Item {} - Licitação {} - Status code {} - Falha ao carregar os melhores lances do item", new Object[] {
/* 245 */               a().bo(), a().a().bo(), Integer.valueOf(e.getStatusCode()) });
/* 246 */         return list;
/*     */       } 
/*     */       
/* 249 */       i i1 = new i(str);
/* 250 */       f f1 = i1.j(a().bo()).c("bids");
/* 251 */       list = b(f1);
/* 252 */     } catch (Exception exception) {
/* 253 */       a.error("Failed to get item {} best bids", a().bo(), exception);
/*     */     } 
/*     */     
/* 256 */     return list;
/*     */   }
/*     */   
/*     */   private List<h> b(f paramf) throws ParseException {
/* 260 */     ArrayList<h> arrayList = new ArrayList();
/* 261 */     boolean bool1 = false;
/* 262 */     boolean bool2 = false;
/* 263 */     byte b1 = 0;
/*     */     
/* 265 */     for (byte b2 = 0; b2 < paramf.length(); b2++) {
/* 266 */       i i1 = paramf.b(b2);
/*     */       
/* 268 */       if (j(i1)) {
/*     */ 
/*     */         
/* 271 */         b1++;
/* 272 */         h h = new h();
/*     */         
/* 274 */         if (i1.has("datBid")) {
/* 275 */           h.c(this.b.parse(i1.getString("datBid")));
/*     */         }
/*     */         
/* 278 */         if (i1.has("value")) {
/* 279 */           h.q(i1.getDouble("value"));
/* 280 */         } else if (i1.has("lastBid")) {
/* 281 */           h.q(i1.getDouble("lastBid"));
/*     */         } 
/* 283 */         boolean bool = i1.has("rankingPosition") ? i1.getInt("rankingPosition") : b1;
/* 284 */         h.l(bool);
/*     */         
/* 286 */         if (i1.has("isMyBid")) {
/* 287 */           h.A(i1.getBoolean("isMyBid"));
/*     */           
/* 289 */           if (h.bb()) {
/* 290 */             bool1 = true;
/*     */           }
/*     */         }
/* 293 */         else if (!bool1 && h.m() == a().f()) {
/* 294 */           h.A(true);
/* 295 */           bool1 = true;
/* 296 */         } else if (!bool2 && a().k() != a().f() && h.m() == a().k()) {
/* 297 */           h.A(true);
/* 298 */           bool2 = true;
/* 299 */         } else if (this.m.contains(Double.valueOf(h.m()))) {
/* 300 */           h.A(true);
/*     */         } 
/*     */ 
/*     */         
/* 304 */         if (i1.has("participant") && !i1.isNull("participant")) {
/* 305 */           h.E(i1.getString("participant"));
/*     */         }
/*     */         
/* 308 */         if (i1.has("participantDocument") && !i1.isNull("participantDocument")) {
/* 309 */           long l = i1.f("participantDocument");
/*     */           
/* 311 */           if (l > 0L) {
/* 312 */             String str = y.k("##.###.###/####-##", Long.toString(l));
/* 313 */             h.D(str);
/*     */           } 
/*     */         } 
/*     */         
/* 317 */         arrayList.add(h);
/*     */       } 
/*     */     } 
/* 320 */     return arrayList;
/*     */   }
/*     */   
/*     */   private boolean j(i parami) throws g {
/* 324 */     return ((!parami.has("isInapt") || !parami.getBoolean("isInapt")) && (
/* 325 */       !parami.has("isDisqualified") || !parami.getBoolean("isDisqualified")) && (
/* 326 */       !parami.has("isPassedOver") || !parami.getBoolean("isPassedOver")) && (
/* 327 */       !parami.has("isInvalid") || !parami.getBoolean("isInvalid")));
/*     */   }
/*     */   
/*     */   private h a(i parami) throws ParseException, g {
/* 331 */     h h = new h();
/* 332 */     h.c(this.b.parse(parami.getString("datBid")));
/* 333 */     h.q(parami.getDouble("value"));
/* 334 */     return h;
/*     */   }
/*     */ 
/*     */   
/*     */   public a b() {
/* 339 */     return (a)super.b();
/*     */   }
/*     */ 
/*     */   
/*     */   public d b() {
/* 344 */     return (d)super.b();
/*     */   }
/*     */   
/*     */   public void b(i parami) {
/* 348 */     this.c = parami;
/*     */   }
/*     */   
/*     */   public void a(f paramf) {
/* 352 */     this.e = paramf;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\l\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */