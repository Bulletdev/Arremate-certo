/*     */ package br.com.arremate.d.e;
/*     */ 
/*     */ import br.com.arremate.f.l;
/*     */ import br.com.arremate.j.c.b;
/*     */ import br.com.arremate.j.c.e;
/*     */ import br.com.arremate.j.c.g;
/*     */ import br.com.arremate.j.c.h;
/*     */ import br.com.arremate.j.c.i;
/*     */ import br.com.arremate.l.e.c;
/*     */ import br.com.arremate.n.n;
/*     */ import java.text.ParseException;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.concurrent.ScheduledFuture;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.stream.Collectors;
/*     */ import org.apache.commons.collections4.IteratorUtils;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class q
/*     */   extends Thread
/*     */ {
/*  39 */   private static final Logger a = LoggerFactory.getLogger(q.class);
/*     */   
/*     */   private final SimpleDateFormat dateFormat;
/*     */   
/*     */   private final i d;
/*     */   private final AtomicBoolean b;
/*     */   private final e b;
/*     */   private final c b;
/*     */   private final Calendar c;
/*     */   private final ScheduledExecutorService c;
/*     */   private Runnable a;
/*     */   private ScheduledFuture a;
/*     */   private g a;
/*     */   private long p;
/*     */   
/*     */   static q a(c paramc, e parame) {
/*  55 */     q q1 = new q(paramc, parame);
/*  56 */     q1.aI();
/*  57 */     return q1;
/*     */   }
/*     */   
/*     */   private q(c paramc, e parame) {
/*  61 */     this.c = Executors.newScheduledThreadPool(1);
/*  62 */     this.dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
/*  63 */     this.d = new i();
/*  64 */     this.b = (c)new AtomicBoolean();
/*  65 */     this.b = (c)parame;
/*  66 */     this.b = paramc;
/*  67 */     this.c = (ScheduledExecutorService)Calendar.getInstance();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*     */     try {
/*  74 */       this.b.set(true);
/*     */       
/*  76 */       l l = this.b.a();
/*  77 */       if (l.equals(l.h) || l.equals(l.k)) {
/*  78 */         this.b.bN();
/*     */       } else {
/*  80 */         this.b.A(this.b.bk());
/*     */       } 
/*     */       
/*  83 */       this.a.u(this.b.a());
/*     */       
/*  85 */       Map<String, i> map = g();
/*  86 */       synchronized (this.d) {
/*  87 */         map.forEach(this.d::c);
/*     */       } 
/*     */       
/*  90 */       this.a.bR();
/*  91 */       this.a = (g)this.c.scheduleAtFixedRate((Runnable)this.a, 20L, 20L, TimeUnit.SECONDS);
/*     */       
/*  93 */       while (this.b.get()) {
/*     */         try {
/*  95 */           Long long_ = Long.valueOf(this.b.l() - n.a().longValue());
/*  96 */           if (long_.longValue() < TimeUnit.SECONDS.toMillis(30L) || !this.a.X()) {
/*  97 */             this.a.disconnect();
/*     */             
/*  99 */             if (!this.b.V()) {
/* 100 */               this.b.set(false); continue;
/*     */             } 
/* 102 */             this.a.u(this.b.a());
/* 103 */             this.a.bR();
/*     */             continue;
/*     */           } 
/* 106 */           Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
/*     */         }
/* 108 */         catch (i|InterruptedException i1) {
/* 109 */           a.error("Falha ao renovar token da sala de disputa", (Throwable)i1);
/*     */         } 
/*     */       } 
/* 112 */     } catch (Exception exception) {
/* 113 */       a.error("Falha ao entrar na sala de disputa", exception);
/*     */     } finally {
/* 115 */       if (this.a != null) {
/* 116 */         this.a.disconnect();
/*     */       }
/*     */       
/* 119 */       if (this.a != null) {
/* 120 */         this.a.cancel(true);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private Map<String, i> g() {
/* 126 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 127 */     long l = System.currentTimeMillis();
/*     */     
/* 129 */     String str1 = this.b.bk();
/* 130 */     String str2 = this.b.h(str1).getData();
/* 131 */     if (str2.isEmpty()) {
/* 132 */       a.info("Falha ao capturar itens em disputa. Disputa {}, UASG {}", this.b.bo(), Integer.valueOf(this.b.K()));
/* 133 */       return Collections.emptyMap();
/*     */     } 
/*     */     
/* 136 */     this.c.setTimeInMillis(n.a().longValue());
/*     */     
/* 138 */     f f = new f(str2);
/* 139 */     for (byte b = 0; b < f.length(); b++) {
/* 140 */       i i1 = f.b(b);
/* 141 */       c(i1);
/*     */       
/* 143 */       int j = i1.getInt("numero");
/* 144 */       String str = Integer.toString(j);
/*     */       
/* 146 */       if (j < 0) {
/* 147 */         f f1 = a(str);
/* 148 */         if (f1 != null) {
/* 149 */           i1.c("itens", f1);
/*     */         }
/*     */       } 
/*     */       
/* 153 */       hashMap.put(str, i1);
/*     */     } 
/*     */     
/* 156 */     this.p = System.currentTimeMillis() - l;
/* 157 */     return (Map)hashMap;
/*     */   }
/*     */   
/*     */   private f a(String paramString) {
/* 161 */     String str = this.b.a(this.b.bk(), paramString).getData();
/* 162 */     if (!str.isEmpty()) {
/* 163 */       f f = new f(str);
/*     */       
/* 165 */       for (byte b = 0; b < f.length(); b++) {
/* 166 */         i i1 = f.b(b);
/* 167 */         c(i1);
/*     */       } 
/*     */       
/* 170 */       return f;
/*     */     } 
/*     */     
/* 173 */     return null;
/*     */   }
/*     */   
/*     */   private void aI() {
/* 177 */     this.a = new g(this.b.a(), this.b.bk());
/* 178 */     this.a.a(new b(this)
/*     */         {
/*     */           public void a(h param1h) {
/* 181 */             i i = param1h.n();
/* 182 */             boolean bool = i.j("message").getBoolean("connected");
/* 183 */             if (!bool) {
/* 184 */               q.a(this.b).set(false);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void b(h param1h) {
/* 190 */             q.b().info("Message received from socket: {}", param1h);
/*     */             
/*     */             try {
/* 193 */               i i = param1h.n();
/* 194 */               if (i.has("dispatch")) {
/* 195 */                 synchronized (q.a(this.b)) {
/* 196 */                   String str = i.getString("dispatch");
/* 197 */                   boolean bool = (str.equals("ItemDisputaRepresentation") || str.equals("ItemComAlteracaoContadoresRepresentation")) ? true : false;
/*     */                   
/* 199 */                   if (bool) {
/* 200 */                     f f = i.j("message").c("message");
/* 201 */                     ArrayList<i> arrayList = new ArrayList();
/*     */                     
/* 203 */                     if (str.equals("ItemDisputaRepresentation")) {
/* 204 */                       for (byte b1 = 0; b1 < f.length(); b1++) {
/* 205 */                         i i1 = this.b.d(f.b(b1));
/* 206 */                         if (i1 != null) {
/* 207 */                           arrayList.add(i1);
/*     */                         }
/*     */                       } 
/*     */                     } else {
/* 211 */                       i i1 = this.b.d(f.b(0).j("item"));
/* 212 */                       if (i1 != null) {
/* 213 */                         arrayList.add(i1);
/*     */                       }
/*     */                     } 
/*     */                     
/* 217 */                     for (i i1 : arrayList) {
/* 218 */                       this.b.i(i1);
/*     */                     }
/*     */                   } 
/*     */                 } 
/*     */               }
/* 223 */             } catch (g g) {
/* 224 */               q.b().error("Falha ao receber mensagem da disputa", (Throwable)g);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void c(h param1h) {
/* 230 */             i i = param1h.n();
/* 231 */             boolean bool = i.j("message").getBoolean("connected");
/* 232 */             if (!bool) {
/* 233 */               q.a(this.b).set(false);
/*     */             }
/*     */           }
/*     */         });
/*     */     
/* 238 */     this.a = (g)(() -> {
/*     */         Map<String, i> map = g();
/*     */         map.values().forEach(());
/*     */       });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected i d(i parami) {
/* 251 */     int j = parami.getInt("numero");
/* 252 */     String str = Integer.toString(j);
/* 253 */     boolean bool = (j < 0) ? true : false;
/*     */     
/* 255 */     if (bool && !this.d.has(str)) {
/* 256 */       String str1 = parami.has("fase") ? parami.getString("fase") : "";
/*     */       
/* 258 */       if (str1.equals("F") || str1.equals("AS") || str1.equals("AP") || str1.equals("AA") || str1.equals("LS")) {
/* 259 */         parami = null;
/*     */       } else {
/* 261 */         a.info("Received not listed group {}", str);
/*     */         
/* 263 */         f f = a(str);
/* 264 */         if (f != null) {
/* 265 */           parami.c("itens", f);
/*     */         }
/*     */         
/* 268 */         a.info("Adding group {} to jsonItemMessage, data: {}", str, parami.toString());
/*     */       } 
/*     */     } 
/*     */     
/* 272 */     return parami;
/*     */   }
/*     */   
/*     */   boolean h(i parami) {
/* 276 */     synchronized (this.d) {
/* 277 */       return i(parami);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean i(i parami) {
/* 283 */     if (parami == null) {
/* 284 */       return false;
/*     */     }
/*     */     
/* 287 */     boolean bool = true;
/*     */     try {
/* 289 */       c(parami);
/*     */       
/* 291 */       int j = parami.getInt("numero");
/* 292 */       String str = Integer.toString(j);
/*     */       
/* 294 */       i i1 = null;
/* 295 */       byte b = 0;
/*     */       
/* 297 */       i i2 = null;
/* 298 */       if (this.d.has(str)) {
/* 299 */         i2 = this.d.j(str);
/*     */       } else {
/* 301 */         List list = (List)IteratorUtils.toList(this.d.o()).stream().filter(paramString -> (Integer.parseInt(paramString) < 0)).collect(Collectors.toList());
/* 302 */         for (String str1 : list) {
/* 303 */           i i3 = this.d.j(str1);
/*     */           
/* 305 */           f f = i3.c("itens");
/* 306 */           for (byte b1 = 0; b1 < f.length(); b1++) {
/* 307 */             i i4 = f.b(b1);
/* 308 */             if (i4.has("numero") && i4.getInt("numero") == j) {
/* 309 */               i2 = i4;
/* 310 */               i1 = i3;
/* 311 */               b = b1;
/*     */               
/*     */               break;
/*     */             } 
/*     */           } 
/* 316 */           if (i1 != null) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 322 */       if (parami.has("dataHoraAtualizacao")) {
/* 323 */         bool = a(parami, i2);
/*     */       }
/*     */       
/* 326 */       if (bool) {
/* 327 */         if (i1 != null) {
/* 328 */           f f = i1.c("itens");
/* 329 */           f.remove(b);
/* 330 */           f.a(parami);
/* 331 */           i1.c("itens", f);
/*     */           
/* 333 */           this.d.c(Integer.toString(i1.getInt("numero")), i1);
/*     */         } else {
/* 335 */           if (j < 0 && i2 != null) {
/* 336 */             if (!parami.has("identificador")) {
/* 337 */               parami.c("identificador", i2.getString("identificador"));
/*     */             }
/*     */             
/* 340 */             if (!parami.has("itens")) {
/* 341 */               parami.c("itens", i2.c("itens"));
/*     */             }
/*     */           } 
/*     */           
/* 345 */           this.d.c(str, parami);
/*     */         } 
/*     */       }
/* 348 */     } catch (Exception exception) {
/* 349 */       a.warn("Falha ao atualizar as informações do json da disputa", exception);
/* 350 */       bool = false;
/*     */     } 
/*     */     
/* 353 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean a(i parami1, i parami2) throws ParseException {
/* 357 */     if (parami2 == null) {
/* 358 */       return true;
/*     */     }
/*     */     
/* 361 */     boolean bool = false;
/*     */     
/* 363 */     String str = parami1.getString("dataHoraAtualizacao");
/* 364 */     Date date = this.dateFormat.parse(str);
/*     */     
/* 366 */     if (parami1.has("versaoItem") && parami2.has("versaoItem")) {
/* 367 */       bool = (parami2.getInt("versaoItem") < parami1.getInt("versaoItem")) ? true : false;
/*     */     }
/*     */     
/* 370 */     if (!bool && parami2.has("dataHoraAtualizacao")) {
/* 371 */       String str1 = parami2.getString("dataHoraAtualizacao");
/* 372 */       Date date1 = this.dateFormat.parse(str1);
/*     */       
/* 374 */       bool = (date1.getTime() < date.getTime()) ? true : false;
/* 375 */       if (bool) {
/* 376 */         this.p = n.i().getTimeInMillis() - date.getTime();
/* 377 */       } else if (parami1.has("dataHoraFimContagem")) {
/* 378 */         String str2 = parami1.getString("dataHoraFimContagem");
/* 379 */         Date date2 = this.dateFormat.parse(str2);
/* 380 */         date = n.i().getTime();
/*     */         
/* 382 */         if (parami2.has("dataHoraFimContagem")) {
/* 383 */           String str3 = parami2.getString("dataHoraFimContagem");
/* 384 */           Date date3 = this.dateFormat.parse(str3);
/* 385 */           bool = (date3.getTime() < date2.getTime()) ? true : false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 391 */     if (!bool && parami2.has("fase") && parami1.has("fase")) {
/* 392 */       String str1 = parami1.getString("fase");
/* 393 */       String str2 = parami2.getString("fase");
/*     */       
/* 395 */       bool = !str2.equals(str1) ? true : false;
/*     */     } 
/*     */     
/* 398 */     if (bool) {
/* 399 */       this.c.setTime(date);
/*     */     }
/*     */     
/* 402 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void c(i parami) {
/* 408 */     if (parami.has("dataHoraAtualizacao")) {
/* 409 */       String str = parami.getString("dataHoraAtualizacao");
/*     */       
/* 411 */       if (str.length() > 23) {
/* 412 */         str = str.substring(0, 23);
/* 413 */       } else if (str.length() == 19) {
/* 414 */         str = str + ".0";
/*     */       } 
/*     */       
/* 417 */       str = str.replace("T", " ");
/* 418 */       parami.c("dataHoraAtualizacao", str);
/*     */     } 
/*     */     
/* 421 */     if (parami.has("dataHoraFimContagem")) {
/* 422 */       String str = parami.getString("dataHoraFimContagem");
/*     */       
/* 424 */       if (str.length() > 23) {
/* 425 */         str = str.substring(0, 23);
/* 426 */       } else if (str.length() == 19) {
/* 427 */         str = str + ".0";
/*     */       } 
/*     */       
/* 430 */       str = str.replace("T", " ");
/* 431 */       parami.c("dataHoraFimContagem", str);
/*     */     } 
/*     */   }
/*     */   
/*     */   void q(String paramString) {
/* 436 */     synchronized (this.d) {
/* 437 */       this.d.remove(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   i j() {
/* 442 */     synchronized (this.d) {
/* 443 */       return new i(this.d.toString());
/*     */     } 
/*     */   }
/*     */   
/*     */   void aJ() {
/* 448 */     this.b.set(false);
/*     */   }
/*     */   
/*     */   void shutdown() {
/* 452 */     aJ();
/* 453 */     this.c.shutdown();
/*     */   }
/*     */   
/*     */   long e() {
/* 457 */     return this.p;
/*     */   }
/*     */   
/*     */   long f() {
/* 461 */     return this.c.getTimeInMillis();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\e\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */