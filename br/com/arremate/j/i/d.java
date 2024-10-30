/*     */ package br.com.arremate.j.i;
/*     */ 
/*     */ import br.com.a.d.a.e;
/*     */ import com.b.a.a.Q;
/*     */ import com.b.a.a.R;
/*     */ import com.b.a.a.W;
/*     */ import com.b.a.a.Z;
/*     */ import java.security.KeyStore;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.X509TrustManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class d
/*     */ {
/*  32 */   private final List<a> listeners = new ArrayList<>();
/*  33 */   private final Object lock = new Object(); private Thread a;
/*     */   private Q a;
/*     */   
/*     */   public void a(a parama) {
/*  37 */     this.listeners.add(parama);
/*     */   }
/*     */   private String q; private int aE;
/*     */   public void u(String paramString) {
/*  41 */     this.q = paramString;
/*     */   }
/*     */   
/*     */   public void P(int paramInt) {
/*  45 */     this.aE = paramInt;
/*     */   }
/*     */   
/*     */   public void bR() throws e {
/*     */     try {
/*  50 */       synchronized (this.lock) {
/*  51 */         W w = new W();
/*  52 */         w.a(a());
/*  53 */         this.a = w.n("wss://licitacoes-e2.bb.com.br/aop-disputas-api/ws/disputas/456/gli0xh5l/websocket");
/*  54 */         this.a.a("v10.stomp");
/*     */         
/*  56 */         this.a.a((Z)new R(this)
/*     */             {
/*     */               public void a(Q param1Q, Map<String, List<String>> param1Map) throws Exception {
/*  59 */                 super.a(param1Q, param1Map);
/*  60 */                 param1Q.k(d.a(this.b));
/*     */               }
/*     */ 
/*     */               
/*     */               public void b(Q param1Q, String param1String) throws Exception {
/*  65 */                 d.a(this.b, param1Q, param1String);
/*     */               }
/*     */             });
/*     */         
/*  69 */         this.a.i();
/*     */         
/*  71 */         if (this.a == null || !this.a.isAlive()) {
/*  72 */           this.a = (Q)new Thread(() -> {
/*     */                 do {
/*     */                   try {
/*     */                     Thread.sleep(18000L);
/*  76 */                   } catch (InterruptedException interruptedException) {}
/*     */                 } while (this.a.isOpen());
/*     */               });
/*     */ 
/*     */           
/*  81 */           this.a.start();
/*     */         } 
/*     */       } 
/*  84 */     } catch (Exception exception) {
/*  85 */       throw new e();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean X() {
/*  90 */     if (this.a != null) {
/*  91 */       return this.a.isAlive();
/*     */     }
/*     */     
/*  94 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/*  98 */     if (this.a != null) {
/*  99 */       return this.a.isOpen();
/*     */     }
/*     */     
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public void disconnect() {
/* 106 */     synchronized (this.lock) {
/* 107 */       if (this.a != null) {
/* 108 */         this.a.k();
/*     */       }
/*     */       
/* 111 */       if (this.a != null && this.a.isAlive()) {
/* 112 */         this.a.interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Q paramQ, String paramString) {
/* 118 */     e e = new e(paramString);
/* 119 */     switch (e.getType()) {
/*     */       case "CONNECTED":
/* 121 */         paramQ.k(aI());
/* 122 */         paramQ.k(aJ());
/*     */         break;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case "MESSAGE":
/* 129 */         if (e.ag()) {
/* 130 */           this.listeners.forEach(parama -> parama.b(parame));
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case "ERROR":
/* 136 */         paramQ.k();
/* 137 */         this.listeners.forEach(parama -> parama.c(parame));
/*     */         break;
/*     */ 
/*     */       
/*     */       case "h":
/* 142 */         paramQ.k(aH());
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private SSLContext a() throws e {
/* 150 */     SSLContext sSLContext = null;
/*     */     try {
/* 152 */       KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
/* 153 */       keyStore.load(null, null);
/* 154 */       KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
/* 155 */       keyManagerFactory.init(keyStore, "123456".toCharArray());
/* 156 */       X509TrustManager x509TrustManager = new X509TrustManager(this)
/*     */         {
/*     */           public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
/*     */ 
/*     */ 
/*     */           
/*     */           public X509Certificate[] getAcceptedIssuers() {
/* 167 */             return null;
/*     */           }
/*     */         };
/* 170 */       sSLContext = SSLContext.getInstance("TLS");
/* 171 */       sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[] { x509TrustManager }, null);
/* 172 */     } catch (Exception exception) {
/* 173 */       throw new e();
/*     */     } 
/* 175 */     return sSLContext;
/*     */   }
/*     */   
/*     */   private String aG() {
/* 179 */     StringBuilder stringBuilder = new StringBuilder();
/* 180 */     stringBuilder.append("[\"CONNECT\\nAuthorization:");
/* 181 */     stringBuilder.append(this.q);
/* 182 */     stringBuilder.append("\\naccept-version:1.1,1.0\\nheart-beat:10000,10000\\n\\n\\u0000\"]");
/* 183 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String aH() {
/* 187 */     StringBuilder stringBuilder = new StringBuilder();
/* 188 */     stringBuilder.append("[\"SEND\\nAuthorization:");
/* 189 */     stringBuilder.append(this.q);
/* 190 */     stringBuilder.append("\\ndestination:/app-ws/lotes/fornecedor/");
/* 191 */     stringBuilder.append(this.aE);
/* 192 */     stringBuilder.append("/0\\n\\n\\u0000\"]");
/* 193 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String aI() {
/* 197 */     StringBuilder stringBuilder = new StringBuilder();
/* 198 */     stringBuilder.append("[\"SUBSCRIBE\\nid:sub-0\\ndestination:/topico/lotes/fornecedor/");
/* 199 */     stringBuilder.append(this.aE);
/* 200 */     stringBuilder.append("/0\\n\\n\\u0000\"]");
/* 201 */     return stringBuilder.toString();
/*     */   }
/*     */   private String aJ() {
/* 204 */     StringBuilder stringBuilder = new StringBuilder("[\"SUBSCRIBE\\nid:sub-1\\ndestination:/user/fila/erros\\n\\n\\u0000\"]");
/* 205 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\i\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */