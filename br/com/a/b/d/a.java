/*     */ package br.com.a.b.d;
/*     */ 
/*     */ import br.com.a.c.c;
/*     */ import br.com.a.d.a.e;
/*     */ import com.b.a.a.Q;
/*     */ import com.b.a.a.R;
/*     */ import com.b.a.a.W;
/*     */ import com.b.a.a.Z;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.security.KeyStore;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.security.cert.X509Certificate;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Objects;
/*     */ import javax.net.ssl.KeyManagerFactory;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import javax.net.ssl.TrustManager;
/*     */ import javax.net.ssl.X509TrustManager;
/*     */ import javax.script.Bindings;
/*     */ import javax.script.Invocable;
/*     */ import javax.script.ScriptEngine;
/*     */ import javax.script.ScriptEngineManager;
/*     */ import javax.script.ScriptException;
/*     */ import org.apache.commons.io.IOUtils;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class a {
/*  34 */   private static final Logger a = LoggerFactory.getLogger(a.class);
/*     */   
/*     */   private static final int dd = 1;
/*     */   private static final int de = 2;
/*     */   private static final int dg = 3;
/*     */   private static final int dh = 4;
/*     */   private static final int di = 5;
/*     */   private static final long U = 10000L;
/*     */   private final ScriptEngine a;
/*     */   private final c a;
/*  44 */   private final String ge = "bb";
/*  45 */   private String gf = "";
/*  46 */   private String gg = "";
/*  47 */   private String gh = "";
/*  48 */   private String key = "";
/*  49 */   private String gi = "";
/*  50 */   private String gj = "";
/*  51 */   private String gk = "";
/*  52 */   private int dj = 935;
/*  53 */   private int dk = 1;
/*  54 */   private String gl = "";
/*     */   
/*     */   public a(c paramc) {
/*  57 */     this.a = paramc;
/*  58 */     this.a = (c)(new ScriptEngineManager()).getEngineByName("nashorn");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void et() throws e {
/*  68 */     this.gl = cW();
/*  69 */     this.dk = 1;
/*  70 */     eu();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void eu() throws e {
/*     */     try {
/*  80 */       aP("functions.js");
/*  81 */       aP("jsencrypt.js");
/*  82 */     } catch (Exception exception) {
/*  83 */       a.error("Failed on load warsaw scripts", exception);
/*  84 */       throw new e("Falha ao carregar os scripts do warsaw");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void aP(String paramString) throws IOException, ScriptException {
/*  96 */     InputStream inputStream = getClass().getClassLoader().getResourceAsStream(paramString); try {
/*  97 */       String str = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
/*  98 */       this.a.eval(str);
/*  99 */       if (inputStream != null) inputStream.close(); 
/*     */     } catch (Throwable throwable) {
/*     */       if (inputStream != null)
/*     */         try {
/*     */           inputStream.close();
/*     */         } catch (Throwable throwable1) {
/*     */           throwable.addSuppressed(throwable1);
/*     */         }  
/*     */       throw throwable;
/*     */     } 
/*     */   } public void ev() throws e {
/*     */     Q q;
/*     */     try {
/* 112 */       W w = new W();
/* 113 */       w.a(a());
/* 114 */       q = w.n(this.a.cI());
/* 115 */       q.a("Origin", this.a.cV());
/* 116 */       q.a("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36");
/*     */       
/* 118 */       q.a((Z)new R(this)
/*     */           {
/*     */             public void a(Q param1Q, Map<String, List<String>> param1Map) throws Exception
/*     */             {
/* 122 */               param1Q.b(a.a(this.b));
/*     */             }
/*     */ 
/*     */             
/*     */             public void b(Q param1Q, String param1String) {
/* 127 */               a.a(this.b, param1Q, param1String);
/*     */             }
/*     */           });
/* 130 */       q.i();
/* 131 */     } catch (Exception exception) {
/* 132 */       a.error("Failed on warsaw web socket communication", exception);
/* 133 */       throw new e();
/*     */     } 
/*     */     
/* 136 */     long l = System.currentTimeMillis();
/*     */ 
/*     */     
/* 139 */     while (q.isOpen()) {
/* 140 */       long l1 = System.currentTimeMillis() - l;
/*     */ 
/*     */       
/* 143 */       if (l1 >= 10000L) {
/* 144 */         q.k();
/* 145 */         a.error("Web socket connection timeout");
/* 146 */         throw new e("Finalizado o tempo limite do warsaw");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SSLContext a() throws e {
/* 159 */     SSLContext sSLContext = null;
/*     */ 
/*     */     
/*     */     try {
/* 163 */       KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
/* 164 */       keyStore.load(null, null);
/*     */ 
/*     */       
/* 167 */       KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("PKIX");
/* 168 */       keyManagerFactory.init(keyStore, "123456".toCharArray());
/*     */ 
/*     */       
/* 171 */       X509TrustManager x509TrustManager = new X509TrustManager(this)
/*     */         {
/*     */           public void checkClientTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
/*     */ 
/*     */ 
/*     */           
/*     */           public void checkServerTrusted(X509Certificate[] param1ArrayOfX509Certificate, String param1String) throws CertificateException {}
/*     */ 
/*     */           
/*     */           public X509Certificate[] getAcceptedIssuers() {
/* 181 */             return null;
/*     */           }
/*     */         };
/*     */ 
/*     */       
/* 186 */       sSLContext = SSLContext.getInstance("TLS");
/* 187 */       sSLContext.init(keyManagerFactory.getKeyManagers(), new TrustManager[] { x509TrustManager }, null);
/* 188 */       keyStore = null;
/* 189 */       keyManagerFactory = null;
/* 190 */       x509TrustManager = null;
/* 191 */     } catch (Exception exception) {
/* 192 */       a.error("Failed on load warsaw certificate", exception);
/* 193 */       throw new e("Falha ao carregar o certificado do warsaw");
/*     */     } 
/*     */     
/* 196 */     return sSLContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] a() throws Exception {
/* 206 */     i i1 = new i();
/* 207 */     i i2 = new i();
/* 208 */     i2.c("n", "IsInstalled");
/* 209 */     i2.a("rs", 0);
/* 210 */     i1.c("d", i2.toString());
/* 211 */     i1.c("c", (new i()).c("s", this.gi));
/* 212 */     i1.c("ri", String.valueOf(this.dj++));
/*     */     
/* 214 */     return a(i1.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] b() throws Exception {
/* 224 */     i i1 = new i();
/* 225 */     i i2 = new i();
/* 226 */     i2.c("n", "Install");
/* 227 */     i1.c("c", (new i()).c("s", this.gi));
/* 228 */     i1.c("d", i2.toString());
/* 229 */     i1.c("ri", String.valueOf(this.dj++));
/* 230 */     return a(i1.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] a(String paramString) throws Exception {
/* 242 */     Invocable invocable = (Invocable)this.a;
/*     */     
/* 244 */     Bindings bindings = (Bindings)invocable.invokeFunction("K", new Object[] { paramString });
/* 245 */     byte b = 0;
/*     */     
/* 247 */     byte[] arrayOfByte = new byte[bindings.values().size()];
/* 248 */     for (Object object : bindings.values().toArray()) {
/* 249 */       arrayOfByte[b] = ((Integer)object).byteValue();
/* 250 */       b++;
/*     */     } 
/* 252 */     bindings = null;
/* 253 */     invocable = null;
/* 254 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Q paramQ, String paramString) {
/*     */     try {
/* 265 */       i i = new i(paramString);
/*     */       
/* 267 */       if (this.dk == 1 || this.dk == 2) {
/* 268 */         if (this.dk == 2) {
/* 269 */           if (i.has("r") && i.getString("r").equals("0")) {
/*     */             
/* 271 */             paramQ.b(a());
/* 272 */             Thread.sleep(100L);
/* 273 */           } else if (i.has("r") && i.getString("r").equals("1")) {
/*     */             
/* 275 */             this.dk = 1;
/* 276 */             paramQ.b(a());
/*     */           } 
/* 278 */         } else if (i.has("r") && i.getString("r").equals("0")) {
/*     */           
/* 280 */           this.dk = 2;
/* 281 */           paramQ.b(b());
/* 282 */         } else if (i.has("r") && i.getString("r").equals("1")) {
/*     */           
/* 284 */           this.dk = 3;
/* 285 */           paramQ.b(c());
/* 286 */           this.dk = 4;
/* 287 */           paramQ.b(d());
/*     */         } else {
/* 289 */           a.error("Failed on warsaw web socket response {}", paramString);
/* 290 */           throw new e();
/*     */         } 
/* 292 */       } else if (this.dk == 4) {
/* 293 */         this.gf = i.j("r").toString();
/* 294 */         this.dk = 5;
/* 295 */         paramQ.b(e());
/* 296 */       } else if (this.dk == 5) {
/* 297 */         this.gg = i.j("r").toString();
/*     */ 
/*     */         
/* 300 */         paramQ.k();
/*     */       } 
/*     */       
/* 303 */       paramString = null;
/* 304 */       i = null;
/* 305 */     } catch (Exception exception) {
/* 306 */       a.error("Failed on web socket message", exception);
/* 307 */       this.gh = "Falha ao processar a mensagem do warsaw";
/*     */       
/* 309 */       if (exception != null && exception.getMessage() != null && !exception.getMessage().isEmpty()) {
/* 310 */         this.gh = exception.getMessage();
/*     */       }
/*     */       
/* 313 */       paramQ.k();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] c() throws Exception {
/* 324 */     i i = new i();
/* 325 */     i.c("c", (new i()).c("s", this.gi));
/* 326 */     i.c("d", (new i()).c("n", "Update").toString());
/* 327 */     i.c("ri", String.valueOf(this.dj++));
/* 328 */     return a(i.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] d() throws Exception {
/* 338 */     i i1 = new i(this.gj);
/* 339 */     i i2 = new i();
/* 340 */     i2.c("d", i1.getString("d"));
/* 341 */     i2.a("ds", i1.getInt("ds"));
/* 342 */     i2.c("ri", String.valueOf(this.dj++));
/* 343 */     i2.c("s", i1.getString("s"));
/* 344 */     i2.a("v", i1.getInt("v"));
/* 345 */     return a(i2.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private byte[] e() throws Exception {
/* 355 */     i i1 = new i(this.gk);
/* 356 */     i i2 = new i();
/* 357 */     i i3 = new i();
/* 358 */     i3.c("a", "");
/* 359 */     i3.c("c", "");
/* 360 */     i3.c("p", "");
/* 361 */     Objects.requireNonNull(this); i3.c("r", "bb");
/* 362 */     i3.c("s", this.key);
/* 363 */     i3.c("u", "");
/* 364 */     i2.c("c", i3);
/* 365 */     i2.c("d", i1.getString("d"));
/* 366 */     i2.a("ds", i1.getInt("ds"));
/* 367 */     i2.c("ri", String.valueOf(this.dj++));
/* 368 */     i2.c("s", i1.getString("s"));
/* 369 */     i2.a("v", i1.getInt("v"));
/* 370 */     return a(i2.toString());
/*     */   }
/*     */   
/*     */   public void aQ(String paramString) {
/* 374 */     this.gk = paramString;
/*     */   }
/*     */   
/*     */   public void setKey(String paramString) {
/* 378 */     this.key = paramString;
/*     */   }
/*     */   
/*     */   public void aR(String paramString) {
/* 382 */     this.gi = paramString;
/*     */   }
/*     */   
/*     */   public void aS(String paramString) {
/* 386 */     this.gj = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cW() {
/* 395 */     if (this.gl.isEmpty()) {
/* 396 */       long l1 = (new Date()).getTime();
/* 397 */       double d = Math.random();
/* 398 */       long l2 = (long)(l1 * d);
/* 399 */       this.gl = Long.toString(l2);
/*     */     } 
/* 401 */     return this.gl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cX() {
/* 410 */     return this.gf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cY() {
/* 419 */     return this.gg;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String cZ() {
/* 428 */     return this.gh;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScriptEngine a() {
/* 437 */     return (ScriptEngine)this.a;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\a\b\d\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */