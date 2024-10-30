/*     */ package br.com.arremate.j;
/*     */ 
/*     */ import br.com.arremate.d.g;
/*     */ import br.com.arremate.f.f;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.f.x;
/*     */ import br.com.arremate.h.b;
/*     */ import br.com.arremate.l.d;
/*     */ import br.com.arremate.m.A;
/*     */ import br.com.arremate.m.y;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class i
/*     */ {
/*  26 */   protected static final Logger a = LoggerFactory.getLogger(i.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int au = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int av = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int aw = 2;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int ax = 3;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicBoolean b;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicInteger f;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicBoolean e;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicBoolean f;
/*     */ 
/*     */ 
/*     */   
/*     */   private final Set<g> e;
/*     */ 
/*     */ 
/*     */   
/*     */   private b c;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean z;
/*     */ 
/*     */ 
/*     */   
/*     */   private d b;
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean A;
/*     */ 
/*     */ 
/*     */   
/*     */   private String message;
/*     */ 
/*     */ 
/*     */   
/*     */   private final AtomicBoolean g;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public i() {
/*  95 */     this.g = new AtomicBoolean(false); this.e = (Set<g>)new AtomicBoolean(false); this.f = new AtomicBoolean(false);
/*     */     this.b = (d)new AtomicBoolean(false);
/*     */     this.f = (AtomicBoolean)new AtomicInteger(0);
/*     */     this.A = false;
/*     */     this.z = true;
/*     */     this.e = new HashSet<>();
/* 101 */   } protected String K(String paramString) { return a(paramString, x.a); } public void N(int paramInt) { synchronized (this.e) {
/* 102 */       if (this.e.get()) {
/*     */         return;
/*     */       }
/*     */       
/* 106 */       if (paramInt < B()) {
/*     */         return;
/*     */       }
/*     */       
/* 110 */       this.e.set(true);
/*     */     } 
/*     */     
/* 113 */     this.c.bD();
/* 114 */     for (g g : this.e) {
/* 115 */       if (!g.isRunning()) {
/*     */         continue;
/*     */       }
/*     */       
/* 119 */       g.a(f.j);
/* 120 */       g.l(String.join(" ", new CharSequence[] { "O", au(), "perdeu sessão no portal. Iniciado o processo para renovar a sessão ..." }));
/*     */     } 
/*     */     
/* 123 */     a.info("Trying to renew session, isRunning: {}", Boolean.valueOf(isRunning()));
/* 124 */     byte b1 = 1;
/*     */ 
/*     */     
/*     */     do {
/* 128 */       int j = z();
/* 129 */       if (j == 1) {
/* 130 */         bX();
/*     */         
/*     */         break;
/*     */       } 
/* 134 */       if (j == 2) {
/* 135 */         this.g.set(true);
/* 136 */         bY();
/*     */         
/*     */         break;
/*     */       } 
/* 140 */       O(b1++);
/* 141 */     } while (isRunning());
/*     */     
/* 143 */     this.e.set(false);
/* 144 */     this.c.bC(); }
/*     */   protected String a(String paramString, NameValuePair[] paramArrayOfNameValuePair) { return a(paramString, paramArrayOfNameValuePair, x.a); }
/*     */   public void b() { try { setRunning(false); if (this.c != null)
/*     */         this.c.b();  } catch (Exception exception) { a.warn("Erro ao finalizar httpclient", exception); }
/* 148 */      } private void bX() { String str = String.join(" ", new CharSequence[] { "O", au(), "foi renovado com sucesso!" });
/* 149 */     C(str); }
/*     */ 
/*     */   
/*     */   private void bY() {
/* 153 */     String str = String.join(" ", new CharSequence[] { "Falha ao renovar a sessão do", au(), "no portal. Dados de acesso inválidos!" });
/* 154 */     C(str);
/*     */   }
/*     */   
/*     */   private void O(int paramInt) {
/* 158 */     String str = String.join(" ", new CharSequence[] { "Falha ao renovar a sessão do", au(), "no portal.Tentativa nº", Integer.toString(paramInt) });
/* 159 */     C(str);
/*     */   }
/*     */   
/*     */   private void C(String paramString) {
/* 163 */     for (g g : this.e) {
/* 164 */       if (!g.isRunning())
/* 165 */         continue;  g.l(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean aa() {
/* 170 */     return this.g.get();
/*     */   }
/*     */   
/*     */   protected String au() {
/* 174 */     return "login";
/*     */   }
/*     */   
/*     */   public void bZ() {
/* 178 */     if (A.a().bX()) {
/*     */       return;
/*     */     }
/*     */     
/* 182 */     synchronized (this.f) {
/* 183 */       if (this.f.get()) {
/*     */         return;
/*     */       }
/* 186 */       this.f.set(true);
/*     */     } 
/*     */     
/* 189 */     this.c.bD();
/* 190 */     if (this.z) {
/* 191 */       for (g g : this.e) {
/* 192 */         if (!g.isRunning()) {
/*     */           continue;
/*     */         }
/*     */         
/* 196 */         g.a(f.p);
/* 197 */         g.l("Perdeu conexão com a internet!");
/*     */       } 
/*     */     }
/*     */     
/* 201 */     while (isRunning() && !A.a().bX()) {
/* 202 */       if (this.z) {
/* 203 */         for (g g : this.e) {
/* 204 */           if (!g.isRunning()) {
/*     */             continue;
/*     */           }
/*     */           
/* 208 */           g.l("Aguardando a conexão com a internet ser restabelecida.");
/*     */         } 
/*     */       }
/*     */       
/* 212 */       sleep(5000L);
/*     */     } 
/*     */     
/* 215 */     if (isRunning() && this.z) {
/* 216 */       for (g g : this.e) {
/* 217 */         if (!g.isRunning()) {
/*     */           continue;
/*     */         }
/*     */         
/* 221 */         g.l("Restabelicida conexão com a internet!");
/*     */       } 
/*     */     }
/*     */     
/* 225 */     this.f.set(false);
/* 226 */     this.c.bC();
/*     */   }
/*     */   
/*     */   public void ca() {
/* 230 */     if (this.b.b().a() == o.b) {
/*     */       return;
/*     */     }
/*     */     
/* 234 */     if (T()) {
/*     */       return;
/*     */     }
/*     */     
/* 238 */     synchronized (this.f) {
/* 239 */       if (this.f.get()) {
/*     */         return;
/*     */       }
/* 242 */       this.f.set(true);
/*     */     } 
/*     */     
/* 245 */     this.c.bD();
/* 246 */     if (this.z) {
/* 247 */       for (g g : this.e) {
/* 248 */         if (!g.isRunning()) {
/*     */           continue;
/*     */         }
/*     */         
/* 252 */         g.a(f.q);
/* 253 */         g.l("Perdeu conexão com o portal!");
/*     */       } 
/*     */     }
/*     */     
/* 257 */     while (isRunning() && !T()) {
/* 258 */       if (this.z) {
/* 259 */         for (g g : this.e) {
/* 260 */           if (!g.isRunning()) {
/*     */             continue;
/*     */           }
/*     */           
/* 264 */           g.l("Aguardando a conexão com o portal ser restabelecida.");
/*     */         } 
/*     */       }
/*     */       
/* 268 */       sleep(5000L);
/*     */     } 
/*     */     
/* 271 */     if (isRunning() && this.z) {
/* 272 */       for (g g : this.e) {
/* 273 */         if (!g.isRunning()) {
/*     */           continue;
/*     */         }
/*     */         
/* 277 */         g.l("Restabelicida conexão com o portal!");
/*     */       } 
/*     */     }
/*     */     
/* 281 */     this.f.set(false);
/* 282 */     this.c.bC();
/*     */   }
/*     */   
/*     */   private void sleep(long paramLong) {
/*     */     try {
/* 287 */       Thread.sleep(paramLong);
/* 288 */     } catch (InterruptedException interruptedException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public d a() {
/* 298 */     return this.b;
/*     */   }
/*     */   
/*     */   public void a(d paramd) {
/* 302 */     this.b = paramd;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 307 */     return a().getUser();
/*     */   }
/*     */   
/*     */   public String getPassword() {
/* 311 */     return a().getPassword();
/*     */   }
/*     */   
/*     */   public String av() {
/* 315 */     return String.valueOf(a().x());
/*     */   }
/*     */   
/*     */   public String aw() {
/* 319 */     return StringUtils.leftPad(av(), 14, "0");
/*     */   }
/*     */   
/*     */   public String ax() {
/* 323 */     return this.b.ax();
/*     */   }
/*     */   
/*     */   public void a(i parami) {
/* 327 */     if (parami != null) {
/* 328 */       parami.c().getCookies().forEach(paramCookie -> c().addCookie(paramCookie));
/*     */ 
/*     */ 
/*     */       
/* 332 */       setRunning(true);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void D(String paramString) {
/* 337 */     paramString = y.V(paramString);
/* 338 */     a().v(Long.parseLong(paramString));
/*     */   }
/*     */   
/*     */   public String ay() {
/* 342 */     return a().bv();
/*     */   }
/*     */   
/*     */   public void E(String paramString) {
/* 346 */     a().aa(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isRunning() {
/* 351 */     return this.b.get();
/*     */   }
/*     */   
/*     */   protected void setRunning(boolean paramBoolean) {
/* 355 */     this.b.set(paramBoolean);
/*     */   }
/*     */   
/*     */   public int B() {
/* 359 */     return this.f.get();
/*     */   }
/*     */   
/*     */   protected void cb() {
/* 363 */     this.f.incrementAndGet();
/*     */   }
/*     */   
/*     */   public boolean ab() {
/* 367 */     return this.e.get();
/*     */   }
/*     */   
/*     */   public boolean ac() {
/* 371 */     return this.f.get();
/*     */   }
/*     */   
/*     */   protected final boolean ad() {
/* 375 */     return this.e.isEmpty();
/*     */   }
/*     */   
/*     */   public final void b(g paramg) {
/* 379 */     this.e.add(paramg);
/*     */   }
/*     */   
/*     */   public final void c(g paramg) {
/* 383 */     this.e.remove(paramg);
/*     */   }
/*     */   
/*     */   protected b c() {
/* 387 */     return this.c;
/*     */   }
/*     */   
/*     */   protected void a(b paramb) {
/* 391 */     this.c = paramb;
/*     */   }
/*     */   
/*     */   protected void i(boolean paramBoolean) {
/* 395 */     this.z = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean ae() {
/* 399 */     return this.A;
/*     */   }
/*     */   
/*     */   public void j(boolean paramBoolean) {
/* 403 */     this.A = paramBoolean;
/*     */   }
/*     */   
/*     */   public String getMessage() {
/* 407 */     return this.message;
/*     */   }
/*     */   
/*     */   public void setMessage(String paramString) {
/* 411 */     this.message = paramString;
/*     */   }
/*     */   
/*     */   protected abstract String a(String paramString, x paramx);
/*     */   
/*     */   protected abstract String a(String paramString, NameValuePair[] paramArrayOfNameValuePair, x paramx);
/*     */   
/*     */   public abstract int z();
/*     */   
/*     */   public abstract boolean T();
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\i.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */