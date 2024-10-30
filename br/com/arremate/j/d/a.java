/*     */ package br.com.arremate.j.d;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.concurrent.ExecutorService;
/*     */ import java.util.concurrent.Executors;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicLong;
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
/*     */ public class a
/*     */ {
/*  20 */   protected static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private final c a;
/*     */   
/*     */   private final ExecutorService executor;
/*     */   
/*     */   private final i j;
/*     */   private final AtomicBoolean b;
/*     */   private final AtomicLong b;
/*     */   private final AtomicLong c;
/*     */   private Long b;
/*     */   private Long c;
/*     */   
/*     */   a(c paramc) {
/*  34 */     this.a = paramc;
/*     */     
/*  36 */     this.executor = Executors.newSingleThreadExecutor();
/*  37 */     this.j = new i();
/*     */     
/*  39 */     this.b = (Long)new AtomicBoolean(false);
/*  40 */     this.b = (Long)new AtomicLong();
/*  41 */     this.c = (Long)new AtomicLong();
/*     */     
/*  43 */     this.b = Long.valueOf(0L);
/*  44 */     this.c = Long.valueOf(0L);
/*     */   }
/*     */ 
/*     */   
/*     */   synchronized void start() {
/*  49 */     if (this.b.get()) {
/*     */       return;
/*     */     }
/*  52 */     this.b.set(true);
/*     */     
/*  54 */     this.executor.execute(() -> {
/*     */           do {
/*     */             try {
/*     */               if (this.c.longValue() == 0L) {
/*     */                 this.c = Long.valueOf(System.currentTimeMillis());
/*     */               }
/*     */               
/*     */               boolean bool = false;
/*     */               
/*     */               String str = this.a.aC();
/*     */               i i1 = h(str);
/*     */               if (i1 != null) {
/*  66 */                 bool = (!l(i1) && f(i1)) ? true : false;
/*     */               }
/*     */               
/*     */               if (!bool) {
/*     */                 str = this.a.aB();
/*     */                 
/*     */                 i1 = h(str);
/*     */                 if (i1 != null) {
/*  74 */                   bool = (!l(i1) && e(i1)) ? true : false;
/*     */                 }
/*     */               } 
/*     */               
/*     */               this.b = Long.valueOf(System.currentTimeMillis() - this.c.longValue());
/*     */               
/*     */               if (bool) {
/*     */                 this.c.set(System.currentTimeMillis());
/*     */                 
/*     */                 this.b.set(this.b.longValue());
/*     */                 this.c = Long.valueOf(0L);
/*     */               } 
/*     */               Thread.sleep(500L);
/*  87 */             } catch (InterruptedException|RuntimeException interruptedException) {
/*     */               a.error("[Licitações-e] Falha ao carregar dados da sala de disputa", interruptedException);
/*     */             } 
/*     */           } while (this.b.get());
/*     */         });
/*     */   }
/*     */   
/*     */   private i h(String paramString) {
/*  95 */     if (paramString.isEmpty() || paramString.equals("null") || paramString.equals("null\r\n") || paramString.trim().equals("{}")) {
/*  96 */       a.error("[Licitações-e] JSON com dados da disputa retornou vazio");
/*  97 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 101 */       return new i(paramString);
/* 102 */     } catch (g g) {
/* 103 */       a.error("[Licitações-e] Falha ao validar json da disputa");
/*     */ 
/*     */       
/* 106 */       return null;
/*     */     } 
/*     */   }
/*     */   private boolean l(i parami) {
/* 110 */     if (parami.has("mensagemErro") && !parami.isNull("mensagemErro")) {
/* 111 */       String str = parami.getString("mensagemErro");
/*     */       
/*     */       try {
/* 114 */         str = new String(str.getBytes(), "UTF-8");
/* 115 */       } catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */ 
/*     */ 
/*     */       
/* 119 */       if (str.toLowerCase().contains("exception") || str.toLowerCase().contains("java")) {
/* 120 */         a.error("[Licitações-e] Erro ao carregar lotes em disputa");
/*     */       } else {
/* 122 */         a.error("[Licitações-e] Erro ao carregar lotes em disputa: {}", str);
/*     */       } 
/*     */       
/* 125 */       return true;
/*     */     } 
/*     */     
/* 128 */     return false;
/*     */   }
/*     */   
/*     */   private boolean e(i parami) {
/* 132 */     if (!parami.has("disputas") || parami.isNull("disputas")) {
/* 133 */       return false;
/*     */     }
/*     */     
/* 136 */     f f = parami.c("disputas");
/* 137 */     if (f.length() <= 0) {
/* 138 */       return false;
/*     */     }
/*     */     
/* 141 */     synchronized (this.j) {
/* 142 */       this.j.keySet().clear();
/* 143 */       this.j.c("disputas", f);
/*     */     } 
/*     */     
/* 146 */     return true;
/*     */   }
/*     */   
/*     */   private boolean f(i parami) {
/* 150 */     if (!parami.has("licitacoes") || parami.isNull("licitacoes")) {
/* 151 */       return false;
/*     */     }
/*     */     
/* 154 */     f f = parami.c("licitacoes");
/* 155 */     if (f.length() <= 0) {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     synchronized (this.j) {
/* 160 */       this.j.keySet().clear();
/* 161 */       this.j.c("licitacoes", f);
/*     */     } 
/*     */     
/* 164 */     return true;
/*     */   }
/*     */   
/*     */   synchronized void stop() {
/* 168 */     if (this.b.get()) {
/* 169 */       this.b.set(false);
/* 170 */       this.executor.shutdown();
/*     */     } 
/*     */   }
/*     */   
/*     */   public i o() {
/* 175 */     synchronized (this.j) {
/* 176 */       return this.j;
/*     */     } 
/*     */   }
/*     */   
/*     */   public long g() {
/* 181 */     return this.b.get();
/*     */   }
/*     */   
/*     */   public long m() {
/* 185 */     return this.c.get();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */