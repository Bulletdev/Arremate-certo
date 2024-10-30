/*     */ package br.com.arremate.j.c;
/*     */ 
/*     */ import br.com.arremate.l.d;
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
/*     */ import org.apache.commons.lang3.StringUtils;
/*     */ 
/*     */ public class g
/*     */ {
/*     */   private final d b;
/*     */   private final String bt;
/*     */   private final List<b> listeners;
/*     */   private final Object lock;
/*     */   private Thread a;
/*     */   private Q a;
/*     */   private String q;
/*     */   
/*     */   public g(d paramd, String paramString) {
/*  31 */     this.b = paramd;
/*  32 */     this.bt = paramString;
/*  33 */     this.listeners = new ArrayList<>();
/*  34 */     this.lock = new Object();
/*     */   }
/*     */   
/*     */   public void a(b paramb) {
/*  38 */     this.listeners.add(paramb);
/*     */   }
/*     */   
/*     */   public void u(String paramString) {
/*  42 */     this.q = paramString;
/*     */   }
/*     */   
/*     */   public void bR() throws i {
/*     */     try {
/*  47 */       synchronized (this.lock) {
/*  48 */         W w = new W();
/*  49 */         w.a(a());
/*  50 */         this.a = w.n("wss://cnetmobile.estaleiro.serpro.gov.br/comprasnet-websocket/socket/websocket");
/*  51 */         this.a.a("v10.stomp");
/*     */         
/*  53 */         this.a.a((Z)new R(this)
/*     */             {
/*     */               public void a(Q param1Q, Map<String, List<String>> param1Map) throws Exception {
/*  56 */                 super.a(param1Q, param1Map);
/*  57 */                 param1Q.k(g.a(this.b));
/*     */               }
/*     */ 
/*     */               
/*     */               public void b(Q param1Q, String param1String) throws Exception {
/*  62 */                 g.a(this.b, param1Q, param1String);
/*     */               }
/*     */             });
/*     */         
/*  66 */         this.a.i();
/*     */         
/*  68 */         if (this.a == null || !this.a.isAlive()) {
/*  69 */           this.a = (Q)new Thread(() -> {
/*     */                 do {
/*     */                   try {
/*     */                     Thread.sleep(18000L);
/*     */                     this.a.k("\n");
/*  74 */                   } catch (InterruptedException interruptedException) {}
/*     */                 } while (this.a.isOpen());
/*     */               });
/*     */ 
/*     */           
/*  79 */           this.a.start();
/*     */         } 
/*     */       } 
/*  82 */     } catch (Exception exception) {
/*  83 */       throw new i();
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean X() {
/*  88 */     if (this.a != null) {
/*  89 */       return this.a.isAlive();
/*     */     }
/*     */     
/*  92 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/*  96 */     if (this.a != null) {
/*  97 */       return this.a.isOpen();
/*     */     }
/*     */     
/* 100 */     return false;
/*     */   }
/*     */   
/*     */   public void disconnect() {
/* 104 */     synchronized (this.lock) {
/* 105 */       if (this.a != null) {
/* 106 */         this.a.k();
/*     */       }
/*     */       
/* 109 */       if (this.a != null && this.a.isAlive()) {
/* 110 */         this.a.interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(Q paramQ, String paramString) {
/* 116 */     h h = new h(paramString);
/* 117 */     switch (h.getType()) {
/*     */       case "CONNECTED":
/* 119 */         paramQ.k(ac());
/* 120 */         paramQ.k(ad());
/* 121 */         paramQ.k(ae());
/* 122 */         paramQ.k(af());
/*     */         
/* 124 */         this.listeners.forEach(paramb -> paramb.a(paramh));
/*     */         break;
/*     */ 
/*     */       
/*     */       case "MESSAGE":
/* 129 */         if (!h.ag().isEmpty()) {
/* 130 */           this.listeners.forEach(paramb -> paramb.b(paramh));
/*     */         }
/*     */         break;
/*     */ 
/*     */       
/*     */       case "ERROR":
/* 136 */         paramQ.k();
/* 137 */         this.listeners.forEach(paramb -> paramb.c(paramh));
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SSLContext a() throws i {
/* 147 */     SSLContext sSLContext = null;
/*     */     
/*     */     try {
/* 150 */       KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
/* 151 */       keyStore.load(null, null);
/*     */       
/* 153 */       KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
/* 154 */       keyManagerFactory.init(keyStore, "123456".toCharArray());
/*     */       
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
/*     */       
/* 171 */       sSLContext = SSLContext.getInstance("TLS");
/* 172 */       sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[] { x509TrustManager }, null);
/* 173 */     } catch (Exception exception) {
/* 174 */       throw new i();
/*     */     } 
/* 176 */     return sSLContext;
/*     */   }
/*     */   
/*     */   private String ab() {
/* 180 */     StringBuilder stringBuilder = new StringBuilder();
/* 181 */     stringBuilder.append("CONNECT\n");
/* 182 */     stringBuilder.append("Authorization:").append(this.q).append("\n");
/* 183 */     stringBuilder.append("accept-version:1.0,1.1,1.2\n");
/* 184 */     stringBuilder.append("heart-beat:20000,0\n\n");
/* 185 */     stringBuilder.append(Character.toChars(0));
/* 186 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String ac() {
/* 190 */     StringBuilder stringBuilder = new StringBuilder();
/* 191 */     stringBuilder.append("SUBSCRIBE\n");
/* 192 */     stringBuilder.append("ack:auto\n");
/* 193 */     stringBuilder.append("id:sub-0\n");
/* 194 */     stringBuilder.append("destination:/user/queue/dataHoraBrasilia\n\n");
/* 195 */     stringBuilder.append(Character.toChars(0));
/* 196 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String ad() {
/* 200 */     StringBuilder stringBuilder = new StringBuilder();
/* 201 */     stringBuilder.append("SUBSCRIBE\n");
/* 202 */     stringBuilder.append("ack:auto\n");
/* 203 */     stringBuilder.append("id:sub-1\n");
/* 204 */     stringBuilder.append("destination:/topic/dataHoraBrasilia\n\n");
/* 205 */     stringBuilder.append(Character.toChars(0));
/* 206 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String ae() {
/* 210 */     String str = StringUtils.leftPad(Long.toString(this.b.x()), 14, "0");
/*     */     
/* 212 */     StringBuilder stringBuilder = new StringBuilder();
/* 213 */     stringBuilder.append("SUBSCRIBE\n");
/* 214 */     stringBuilder.append("ack:auto\n");
/* 215 */     stringBuilder.append("id:sub-2\n");
/* 216 */     stringBuilder.append("destination:/topic/disputa/fornec/").append(this.bt).append("/").append(str).append("\n\n");
/* 217 */     stringBuilder.append(Character.toChars(0));
/* 218 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String af() {
/* 222 */     StringBuilder stringBuilder = new StringBuilder();
/* 223 */     stringBuilder.append("SUBSCRIBE\n");
/* 224 */     stringBuilder.append("ack:auto\n");
/* 225 */     stringBuilder.append("id:sub-3\n");
/* 226 */     stringBuilder.append("destination:/topic/compra/").append(this.bt).append("\n\n");
/* 227 */     stringBuilder.append(Character.toChars(0));
/* 228 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\j\c\g.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */