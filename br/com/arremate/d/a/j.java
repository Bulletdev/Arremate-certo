/*     */ package br.com.arremate.d.a;
/*     */ 
/*     */ import br.com.arremate.a.a.a;
/*     */ import br.com.arremate.a.k;
/*     */ import br.com.arremate.f.o;
/*     */ import br.com.arremate.j.d.c;
/*     */ import br.com.arremate.l.a.a;
/*     */ import br.com.arremate.l.d;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class j
/*     */   extends Thread
/*     */ {
/*  27 */   private static final Logger a = LoggerFactory.getLogger(j.class);
/*     */   
/*     */   private final c a;
/*     */   
/*     */   private final AtomicBoolean c;
/*     */   private final AtomicInteger b;
/*     */   private String O;
/*     */   private a a;
/*     */   private long i;
/*     */   private int K;
/*     */   
/*     */   public j(d paramd) {
/*  39 */     this.a = (a)new c(paramd, false);
/*  40 */     this.c = new AtomicBoolean(false);
/*  41 */     this.b = new AtomicInteger(0);
/*  42 */     this.O = "";
/*  43 */     this.K = 0;
/*     */   }
/*     */   
/*     */   void aq() {
/*  47 */     (new Thread(() -> {
/*     */           while (!this.a.isRunning()) {
/*     */             a.info("ThreadSendBid sem sessão, requisitando login");
/*     */             
/*     */             if (this.a.z() != 1) {
/*     */               a.warn("Tentativa falha de login");
/*     */             }
/*     */           } 
/*     */           
/*     */           this.c.set(true);
/*  57 */         })).start();
/*     */   }
/*     */ 
/*     */   
/*     */   public void run() {
/*  62 */     if (!this.a.isRunning()) {
/*  63 */       ar();
/*     */       
/*     */       return;
/*     */     } 
/*  67 */     if (this.K == 3) {
/*  68 */       ar();
/*  69 */       this.a.b();
/*     */       
/*     */       return;
/*     */     } 
/*     */     try {
/*  74 */       if (!k.b()) {
/*  75 */         Thread.sleep((new Random()).nextInt(30000));
/*  76 */         ar();
/*     */         
/*     */         return;
/*     */       } 
/*  80 */       this.a = null;
/*  81 */       if (this.O == null || this.O.isEmpty()) {
/*  82 */         ar();
/*     */         
/*     */         return;
/*     */       } 
/*  86 */       byte b = 0;
/*     */       do {
/*  88 */         this.a = br.com.arremate.a.j.a().a(this.O, o.b);
/*  89 */         b++;
/*  90 */       } while (this.a == null && b < 3);
/*     */       
/*  92 */       if (this.a == null) {
/*  93 */         this.a.b();
/*     */       }
/*  95 */     } catch (InterruptedException|RuntimeException interruptedException) {
/*  96 */       a.warn("Falha ao quebrar captcha de lance do BB");
/*  97 */       this.a.b();
/*     */     } 
/*     */     
/* 100 */     ar();
/*     */   }
/*     */   
/*     */   private void ar() {
/* 104 */     this.c.set(true);
/* 105 */     this.b.incrementAndGet();
/*     */   }
/*     */ 
/*     */   
/*     */   public i a(double paramDouble, a parama) throws Exception {
/* 110 */     long l = System.currentTimeMillis();
/*     */     
/* 112 */     String str1 = null;
/* 113 */     if (this.a != null) {
/* 114 */       str1 = this.a.a().toLowerCase();
/*     */     }
/*     */     
/* 117 */     String str2 = this.a.a(parama.q(), paramDouble, str1);
/* 118 */     this.i = System.currentTimeMillis() - l;
/* 119 */     i i = new i(str2);
/*     */     
/* 121 */     return c(i);
/*     */   }
/*     */   
/*     */   private i c(i parami) throws Exception {
/* 125 */     i i1 = new i();
/* 126 */     i1.a("elapsedTime", this.i);
/* 127 */     i1.c("captchaText", (this.a != null) ? this.a.a() : "Sem captcha enviado pelo portal");
/*     */ 
/*     */     
/* 130 */     if (parami.length() == 0) {
/* 131 */       a.warn("Bidding thread without session");
/* 132 */       return i1;
/*     */     } 
/*     */     
/* 135 */     if (parami.has("textoDesafioNovaSala") && !parami.isNull("textoDesafioNovaSala")) {
/* 136 */       String str1 = parami.getString("textoDesafioNovaSala").trim();
/* 137 */       if (!str1.isEmpty()) {
/* 138 */         this.O = str1;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 143 */     if (!parami.has("mensagemErro") || parami.isNull("mensagemErro")) {
/* 144 */       this.K = 0;
/* 145 */       i1.c("jsonRetorno", parami);
/* 146 */       return i1;
/*     */     } 
/*     */     
/* 149 */     String str = "";
/*     */     
/*     */     try {
/* 152 */       str = new String(parami.getString("mensagemErro").getBytes(), "UTF-8");
/* 153 */       if (str.contains("O texto enviado não confere com o da imagem")) {
/* 154 */         this.K++;
/*     */         
/* 156 */         if (this.a != null) {
/* 157 */           br.com.arremate.a.j.a().c(this.a.getId());
/* 158 */           br.com.arremate.l.p.j.a().a(false, o.b);
/*     */         } 
/*     */       } 
/* 161 */     } catch (UnsupportedEncodingException|org.e.g unsupportedEncodingException) {
/* 162 */       a.warn("Error getting message", unsupportedEncodingException);
/*     */     } 
/*     */     
/* 165 */     if (!str.isEmpty()) {
/* 166 */       i1.c("mensagemErro", str);
/*     */     } else {
/* 168 */       a.warn("Bidding thread without session");
/*     */     } 
/*     */     
/* 171 */     return i1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void as() {
/* 178 */     this.c.set(false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int p() {
/* 187 */     return this.b.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void b() {
/* 194 */     if (this.a != null) {
/* 195 */       this.a.b();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean F() {
/* 205 */     return (!this.c.get() && !this.a.isRunning());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean G() {
/* 214 */     return (this.c.get() && this.a.isRunning());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean H() {
/* 223 */     return (!this.c.get() && this.a.isRunning());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean I() {
/* 232 */     return (this.c.get() && !this.a.isRunning());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\d\a\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */