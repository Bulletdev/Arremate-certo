/*     */ package br.com.arremate.d.k;
/*     */ 
/*     */ import br.com.arremate.j.i.b;
/*     */ import br.com.arremate.j.i.d;
/*     */ import br.com.arremate.j.i.e;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import org.e.f;
/*     */ import org.e.g;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public final class a
/*     */   extends Thread {
/*  16 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private final AtomicBoolean b;
/*     */   private final b a;
/*     */   private d a;
/*     */   private long r;
/*     */   private long v;
/*     */   private f d;
/*     */   private int ac;
/*     */   
/*     */   static a a(b paramb) {
/*  27 */     a a1 = new a(paramb);
/*  28 */     a1.aI();
/*  29 */     return a1;
/*     */   }
/*     */   
/*     */   private a(b paramb) {
/*  33 */     this.d = new f();
/*  34 */     this.b = new AtomicBoolean();
/*  35 */     this.a = (d)paramb;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void run() {
/*  41 */     this.b.set(true);
/*  42 */     aZ();
/*  43 */     this.ac = this.a.B();
/*     */     
/*  45 */     while (this.b.get()) {
/*     */       try {
/*  47 */         if (this.ac < this.a.B() || !this.a.X()) {
/*  48 */           aZ();
/*     */         }
/*  50 */         Thread.sleep(TimeUnit.SECONDS.toMillis(1L));
/*  51 */       } catch (Exception exception) {
/*  52 */         a.error("Falha ao renovar token da sala de disputa", exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void aZ() {
/*     */     try {
/*  60 */       this.a.u(this.a.aF());
/*  61 */       this.a.P(this.a.C());
/*     */       
/*  63 */       this.a.bR();
/*  64 */     } catch (Exception exception) {
/*  65 */       a.error("Falha ao entrar na sala de disputa", exception);
/*     */     } finally {
/*  67 */       if (!this.a.isRunning() && this.a != null) {
/*  68 */         this.a.disconnect();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void aI() {
/*  74 */     this.a = new d();
/*  75 */     this.a.a(new br.com.arremate.j.i.a(this)
/*     */         {
/*     */           public void a(e param1e) {
/*  78 */             a.c().info("onCon:" + param1e);
/*  79 */             i i = new i(param1e.toString());
/*  80 */             boolean bool = i.j("message").getBoolean("connected");
/*  81 */             if (!bool) {
/*  82 */               a.a(this.a).set(bool);
/*     */             }
/*     */           }
/*     */ 
/*     */           
/*     */           public void b(e param1e) {
/*  88 */             a.c().info("Message received from socket: {}", param1e.toString());
/*     */             
/*     */             try {
/*  91 */               i i = new i(param1e.toString());
/*  92 */               if (i.has("dispatch")) {
/*  93 */                 synchronized (a.a(this.a)) {
/*  94 */                   boolean bool = i.getBoolean("dispatch");
/*  95 */                   if (bool) {
/*  96 */                     a.a(this.a, i.j("message").c("message"));
/*     */                   }
/*     */                 } 
/*     */               }
/*     */               
/* 101 */               if (a.a(this.a) != 0L) {
/* 102 */                 a.a(this.a, System.currentTimeMillis() - a.a(this.a));
/*     */               }
/*     */               
/* 105 */               a.b(this.a, System.currentTimeMillis());
/* 106 */             } catch (g g) {
/* 107 */               a.c().error("Falha ao receber mensagem da disputa", (Throwable)g);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void c(e param1e) {
/* 113 */             a.c().error("Error message received from socket: {}", param1e.toString());
/*     */             
/* 115 */             if (param1e.toString().contains("The Token has expired")) {
/* 116 */               a.a(this.a).disconnect();
/* 117 */               a.a(this.a).k(true);
/*     */             } 
/*     */             
/* 120 */             i i = new i(param1e.toString());
/* 121 */             boolean bool = i.j("message").getBoolean("connected");
/* 122 */             if (!bool) {
/* 123 */               a.a(this.a).set(bool);
/*     */             }
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   f d() {
/* 131 */     synchronized (this.d) {
/* 132 */       return this.d;
/*     */     } 
/*     */   }
/*     */   
/*     */   void aJ() {
/* 137 */     this.b.set(false);
/*     */   }
/*     */   
/*     */   void shutdown() {
/* 141 */     aJ();
/* 142 */     this.a.disconnect();
/*     */   }
/*     */   
/*     */   long g() {
/* 146 */     return this.r;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\k\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */