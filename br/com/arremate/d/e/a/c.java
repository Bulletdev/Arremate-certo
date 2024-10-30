/*     */ package br.com.arremate.d.e.a;
/*     */ 
/*     */ import br.com.arremate.j.c.b;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.c.g;
/*     */ import br.com.arremate.j.c.h;
/*     */ import br.com.arremate.j.c.i;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class c
/*     */   extends Thread
/*     */ {
/*  35 */   private static final Logger a = LoggerFactory.getLogger(c.class);
/*     */   
/*     */   private final SimpleDateFormat dateFormat;
/*     */   
/*     */   private final i d;
/*     */   private final AtomicBoolean b;
/*     */   private final e b;
/*     */   private final br.com.arremate.l.e.c b;
/*     */   private final Calendar c;
/*     */   private final ScheduledExecutorService c;
/*     */   private Runnable a;
/*     */   private ScheduledFuture a;
/*     */   private g a;
/*     */   private long r;
/*     */   
/*     */   static c a(br.com.arremate.l.e.c paramc, e parame) {
/*  51 */     c c1 = new c(paramc, parame);
/*  52 */     c1.aI();
/*  53 */     return c1;
/*     */   }
/*     */   
/*     */   private c(br.com.arremate.l.e.c paramc, e parame) {
/*  57 */     this.c = Executors.newScheduledThreadPool(1);
/*  58 */     this.dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS");
/*  59 */     this.d = new i();
/*  60 */     this.b = (br.com.arremate.l.e.c)new AtomicBoolean();
/*  61 */     this.b = (br.com.arremate.l.e.c)parame;
/*  62 */     this.b = paramc;
/*  63 */     this.c = (ScheduledExecutorService)Calendar.getInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  70 */       this.b.set(true);
/*     */       
/*  72 */       this.b.bN();
/*  73 */       this.a.u(this.b.a());
/*     */       
/*  75 */       Map<String, i> map = g();
/*  76 */       if (map != null) {
/*  77 */         synchronized (this.d) {
/*  78 */           map.entrySet().forEach(paramEntry -> this.d.c((String)paramEntry.getKey(), paramEntry.getValue()));
/*     */         } 
/*     */       }
/*     */ 
/*     */ 
/*     */       
/*  84 */       this.a.bR();
/*  85 */       this.a = (g)this.c.scheduleAtFixedRate((Runnable)this.a, 20L, 20L, TimeUnit.SECONDS);
/*     */       
/*  87 */       while (this.b.get()) {
/*     */         try {
/*  89 */           Long long_ = Long.valueOf(this.b.l() - n.a().longValue());
/*  90 */           if (long_.longValue() < TimeUnit.SECONDS.toMillis(30L) || !this.a.X()) {
/*  91 */             this.a.disconnect();
/*     */             
/*  93 */             if (!this.b.V()) {
/*  94 */               this.b.set(false); continue;
/*     */             } 
/*  96 */             this.a.u(this.b.a());
/*  97 */             this.a.bR();
/*     */             continue;
/*     */           } 
/* 100 */           Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
/*     */         }
/* 102 */         catch (i|InterruptedException i1) {
/* 103 */           a.error("Falha ao renovar token da sala de disputa", (Throwable)i1);
/*     */         } 
/*     */       } 
/* 106 */     } catch (Exception exception) {
/* 107 */       a.error("Falha ao entrar na sala de disputa", exception);
/*     */     } finally {
/* 109 */       if (this.a != null) {
/* 110 */         this.a.disconnect();
/*     */       }
/*     */       
/* 113 */       if (this.a != null) {
/* 114 */         this.a.cancel(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private Map<String, i> g() {
/* 120 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 121 */     long l = System.currentTimeMillis();
/*     */     
/* 123 */     String str = this.b.h(this.b.bk()).getData();
/* 124 */     if (str.isEmpty()) {
/* 125 */       return null;
/*     */     }
/*     */     
/* 128 */     this.c.setTimeInMillis(n.a().longValue());
/*     */     
/* 130 */     f f = new f(str);
/* 131 */     for (byte b = 0; b < f.length(); b++) {
/* 132 */       i i1 = f.b(b);
/* 133 */       c(i1);
/*     */       
/* 135 */       int j = i1.getInt("numero");
/* 136 */       String str1 = Integer.toString(j);
/* 137 */       hashMap.put(str1, i1);
/*     */     } 
/*     */     
/* 140 */     this.r = System.currentTimeMillis() - l;
/* 141 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private void aI() {
/* 145 */     this.a = new g(this.b.a(), this.b.bk());
/* 146 */     this.a.a(new b(this)
/*     */         {
/*     */           public void a(h param1h) {
/* 149 */             i i = new i(param1h.toString());
/* 150 */             boolean bool = i.j("message").getBoolean("connected");
/* 151 */             if (!bool) {
/* 152 */               c.a(this.b).set(bool);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void b(h param1h) {
/* 158 */             c.b().info("Message received from socket: {}", param1h.toString());
/*     */             
/*     */             try {
/* 161 */               i i = new i(param1h.toString());
/* 162 */               if (i.has("dispatch")) {
/* 163 */                 synchronized (c.a(this.b)) {
/* 164 */                   String str = i.getString("dispatch");
/* 165 */                   boolean bool = (str.equals("ItemDisputaRepresentation") || str.equals("ItemComAlteracaoContadoresRepresentation")) ? true : false;
/* 166 */                   if (bool) {
/* 167 */                     f f = i.j("message").c("message");
/*     */                     
/* 169 */                     ArrayList<i> arrayList = new ArrayList();
/* 170 */                     if (str.equals("ItemDisputaRepresentation")) {
/* 171 */                       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 172 */                         i i1 = f.b(b1);
/* 173 */                         arrayList.add(i1);
/*     */                       } 
/*     */                     } else {
/* 176 */                       i i1 = f.b(0).j("item");
/* 177 */                       arrayList.add(i1);
/*     */                     } 
/*     */                     
/* 180 */                     for (i i1 : arrayList) {
/* 181 */                       c.a(this.b, i1);
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */               }
/* 186 */             } catch (g g) {
/* 187 */               c.b().error("Falha ao receber mensagem da disputa", (Throwable)g);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void c(h param1h) {
/* 193 */             i i = new i(param1h.toString());
/* 194 */             boolean bool = i.j("message").getBoolean("connected");
/* 195 */             if (!bool) {
/* 196 */               c.a(this.b).set(bool);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 201 */     this.a = (g)(() -> {
/*     */         Map<String, i> map = g();
/*     */         if (map != null) {
/*     */           map.entrySet().forEach(());
/*     */         } else {
/*     */           a.info("Falha ao realizar refresh. Dispensa {}, UASG {}", this.b.bo(), Integer.valueOf(this.b.K()));
/*     */         } 
/*     */       });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean h(i parami) {
/* 219 */     synchronized (this.d) {
/* 220 */       return i(parami);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean i(i parami) {
/* 226 */     if (parami == null) {
/* 227 */       return false;
/*     */     }
/*     */     
/*     */     try {
/* 231 */       c(parami);
/* 232 */       int j = parami.getInt("numero");
/* 233 */       String str = Integer.toString(j);
/*     */       
/* 235 */       i i1 = null;
/* 236 */       if (this.d.has(str)) {
/* 237 */         i1 = this.d.j(str);
/*     */       }
/*     */       
/* 240 */       if (parami.has("dataHoraAtualizacao") && 
/* 241 */         a(parami, i1)) {
/* 242 */         this.d.c(str, parami);
/* 243 */         return true;
/*     */       }
/*     */     
/* 246 */     } catch (Exception exception) {
/* 247 */       a.warn("Falha ao atualizar as informações do json da disputa", exception);
/*     */     } 
/*     */     
/* 250 */     return false;
/*     */   }
/*     */   
/*     */   private boolean a(i parami1, i parami2) throws ParseException {
/* 254 */     if (parami2 == null) {
/* 255 */       return true;
/*     */     }
/*     */     
/* 258 */     boolean bool = false;
/*     */     
/* 260 */     String str = parami1.getString("dataHoraAtualizacao");
/* 261 */     Date date = this.dateFormat.parse(str);
/*     */     
/* 263 */     if (parami1.has("versaoItem") && parami2.has("versaoItem")) {
/* 264 */       bool = (parami2.getInt("versaoItem") < parami1.getInt("versaoItem")) ? true : false;
/*     */     }
/*     */     
/* 267 */     if (!bool && parami2.has("dataHoraAtualizacao")) {
/* 268 */       String str1 = parami2.getString("dataHoraAtualizacao");
/* 269 */       Date date1 = this.dateFormat.parse(str1);
/*     */       
/* 271 */       bool = (date1.getTime() < date.getTime()) ? true : false;
/* 272 */       if (bool) {
/* 273 */         this.r = y.i().getTimeInMillis() - date.getTime();
/*     */       }
/*     */     } 
/*     */     
/* 277 */     if (!bool && parami2.has("fase") && parami1.has("fase")) {
/* 278 */       String str1 = parami1.getString("fase");
/* 279 */       String str2 = parami2.getString("fase");
/* 280 */       bool = !str2.equals(str1) ? true : false;
/*     */     } 
/*     */     
/* 283 */     if (bool) {
/* 284 */       this.c.setTime(date);
/*     */     }
/*     */     
/* 287 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(i parami) {
/* 293 */     if (parami.has("dataHoraAtualizacao")) {
/* 294 */       String str = parami.getString("dataHoraAtualizacao");
/*     */       
/* 296 */       if (str.length() > 23) {
/* 297 */         str = str.substring(0, 23);
/* 298 */       } else if (str.length() == 19) {
/* 299 */         str = str + ".0";
/*     */       } 
/*     */       
/* 302 */       parami.c("dataHoraAtualizacao", str);
/*     */     } 
/*     */     
/* 305 */     if (parami.has("dataHoraFimContagem")) {
/* 306 */       String str = parami.getString("dataHoraFimContagem");
/*     */       
/* 308 */       if (str.length() > 23) {
/* 309 */         str = str.substring(0, 23);
/* 310 */       } else if (str.length() == 19) {
/* 311 */         str = str + ".0";
/*     */       } 
/*     */       
/* 314 */       parami.c("dataHoraFimContagem", str);
/*     */     } 
/*     */   }
/*     */   
/*     */   void q(String paramString) {
/* 319 */     synchronized (this.d) {
/* 320 */       this.d.remove(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   i j() {
/* 325 */     synchronized (this.d) {
/* 326 */       return new i(this.d.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   void aJ() {
/* 331 */     this.b.set(false);
/*     */   }
/*     */   
/*     */   void shutdown() {
/* 335 */     aJ();
/* 336 */     this.c.shutdown();
/*     */   }
/*     */   
/*     */   long g() {
/* 340 */     return this.r;
/*     */   }
/*     */   
/*     */   long f() {
/* 344 */     return this.c.getTimeInMillis();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */