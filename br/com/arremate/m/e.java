/*     */ package br.com.arremate.m;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.net.InetAddress;
/*     */ import java.nio.file.Files;
/*     */ import java.security.KeyManagementException;
/*     */ import java.security.cert.CertificateException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Optional;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import javax.net.ssl.SSLContext;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.apache.http.ConnectionClosedException;
/*     */ import org.apache.http.Header;
/*     */ import org.apache.http.HttpEntity;
/*     */ import org.apache.http.client.config.RequestConfig;
/*     */ import org.apache.http.client.methods.CloseableHttpResponse;
/*     */ import org.apache.http.client.methods.HttpUriRequest;
/*     */ import org.apache.http.client.methods.RequestBuilder;
/*     */ import org.apache.http.conn.ssl.NoopHostnameVerifier;
/*     */ import org.apache.http.cookie.Cookie;
/*     */ import org.apache.http.impl.client.BasicCookieStore;
/*     */ import org.apache.http.impl.client.CloseableHttpClient;
/*     */ import org.apache.http.impl.client.HttpClientBuilder;
/*     */ import org.apache.http.message.BasicHeader;
/*     */ import org.apache.http.ssl.SSLContextBuilder;
/*     */ import org.apache.http.ssl.SSLContexts;
/*     */ import org.apache.http.util.EntityUtils;
/*     */ import org.e.f;
/*     */ import org.e.i;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ public class e {
/*  44 */   private static final Logger a = LoggerFactory.getLogger(e.class);
/*  45 */   private static final e a = new e();
/*     */   
/*     */   private static final String ev = "ArremateAtualizador.jar";
/*     */   
/*     */   private static final String ew = "ArremateAtualizadorMacOS.zip";
/*     */   
/*     */   private static final String ex = "ArremateAtualizador.app";
/*     */   private final CloseableHttpClient a;
/*     */   private final BasicCookieStore a;
/*     */   private String ey;
/*     */   
/*     */   public static e a() {
/*  57 */     return (e)a;
/*     */   }
/*     */   
/*     */   private e() {
/*  61 */     this.a = (BasicCookieStore)a();
/*  62 */     this.a = new BasicCookieStore();
/*     */     
/*     */     try {
/*  65 */       this.ey = y.a((z.a)z.a.a);
/*  66 */     } catch (Exception exception) {
/*  67 */       a.error("[{}] - Failed to get the temp environment variable {}", getClass().getName(), exception);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean bB() {
/*  72 */     if (SystemUtils.IS_OS_MAC) {
/*  73 */       File file1 = a("ArremateAtualizadorMacOS.zip");
/*  74 */       File file2 = new File(String.join("", new CharSequence[] { this.ey, File.separator, "ArremateAtualizador.app" }));
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  79 */         if (file2.exists()) {
/*  80 */           Process process1 = Runtime.getRuntime().exec(String.join("", new CharSequence[] { "rm -rf ", file2.getPath() }));
/*  81 */           process1.waitFor();
/*     */         } 
/*     */         
/*  84 */         Process process = Runtime.getRuntime().exec(String.join("", new CharSequence[] { "unzip -o ", file1.getPath(), " -d ", this.ey }));
/*  85 */         process.waitFor();
/*  86 */         file1.delete();
/*  87 */       } catch (IOException|InterruptedException iOException) {
/*  88 */         a.error("Failed to unzip the {} file", file1.getPath(), iOException);
/*     */       } 
/*     */       
/*  91 */       return Files.exists(FileSystems.getDefault().getPath(String.join("", new CharSequence[] { this.ey, File.separator, "ArremateAtualizador.app" }), new String[0]), new java.nio.file.LinkOption[0]);
/*     */     } 
/*     */     
/*  94 */     File file = a("ArremateAtualizador.jar");
/*  95 */     return Files.exists(file.toPath(), new java.nio.file.LinkOption[0]);
/*     */   }
/*     */   
/*     */   private File a(String paramString) {
/*  99 */     return a(paramString, !SystemUtils.IS_OS_MAC);
/*     */   }
/*     */   
/*     */   private File a(String paramString, boolean paramBoolean) {
/*     */     try {
/* 104 */       String str = String.join("", new CharSequence[] { this.ey, File.separator, paramString });
/*     */       
/* 106 */       File file = new File(str);
/* 107 */       if (file.exists()) {
/* 108 */         i.a(file);
/*     */       }
/*     */ 
/*     */       
/* 112 */       HttpEntity httpEntity = null;
/* 113 */       HttpUriRequest httpUriRequest = a(String.join("", new CharSequence[] { y.f.getUrl(), paramString }));
/* 114 */       try (CloseableHttpResponse null = this.a.execute(httpUriRequest)) {
/* 115 */         if (closeableHttpResponse.getStatusLine().getStatusCode() == 200) {
/* 116 */           httpEntity = closeableHttpResponse.getEntity();
/*     */           
/* 118 */           try(BufferedOutputStream null = new BufferedOutputStream(new FileOutputStream(file)); 
/* 119 */               BufferedInputStream null = new BufferedInputStream(httpEntity.getContent())) {
/*     */ 
/*     */             
/* 122 */             byte[] arrayOfByte = new byte[4096];
/*     */             int i;
/* 124 */             while ((i = bufferedInputStream.read(arrayOfByte)) != -1) {
/* 125 */               bufferedOutputStream.write(arrayOfByte, 0, i);
/*     */             }
/*     */           } 
/*     */         } 
/* 129 */       } catch (Exception exception) {
/* 130 */         a.error("[{}] - Failed to download the {} file", new Object[] { getClass().getName(), paramString, exception });
/*     */       } finally {
/* 132 */         if (httpEntity != null) {
/* 133 */           EntityUtils.consumeQuietly(httpEntity);
/*     */         }
/*     */       } 
/*     */       
/* 137 */       if (paramBoolean) {
/* 138 */         File file1 = new File(y.ft);
/*     */         try {
/* 140 */           i.copyFile(file, file1);
/* 141 */           i.a(file);
/* 142 */           file = new File(String.join("", new CharSequence[] { y.ft, File.separator, paramString }));
/* 143 */         } catch (Exception exception) {
/* 144 */           a.error("[{}] - Error copying the {} file", new Object[] { getClass().getName(), paramString, exception });
/*     */         } 
/*     */       } 
/*     */       
/* 148 */       return file;
/* 149 */     } catch (Exception exception) {
/* 150 */       a.error("[{}] - Failed to manipulate the {} file", new Object[] { getClass().getName(), paramString, exception });
/* 151 */       return null;
/*     */     } finally {
/* 153 */       this.a.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean a(a parama) {
/* 163 */     String str1 = "";
/* 164 */     HttpEntity httpEntity = null;
/*     */     
/* 166 */     HttpUriRequest httpUriRequest = a("https://www.speedtest.net/api/js/servers?engine=js&limit=10&https_functional=true");
/* 167 */     try (CloseableHttpResponse null = this.a.execute(httpUriRequest)) {
/* 168 */       httpEntity = closeableHttpResponse.getEntity();
/* 169 */       str1 = EntityUtils.toString(httpEntity);
/* 170 */     } catch (Exception exception) {
/* 171 */       a.error("[{}] - Failed to request the list of speed test servers in the '{}' url", new Object[] { getClass().getName(), httpUriRequest.getURI().toString(), exception });
/* 172 */       return false;
/*     */     } finally {
/* 174 */       if (httpEntity != null) {
/* 175 */         EntityUtils.consumeQuietly(httpEntity);
/*     */       }
/*     */     } 
/*     */     
/* 179 */     if (str1.trim().isEmpty()) {
/* 180 */       a.warn("[{}] - Failed to get servers from speed test", getClass().getName());
/* 181 */       return false;
/*     */     } 
/*     */     
/* 184 */     f f = new f(str1);
/* 185 */     if (f.length() == 0) {
/* 186 */       a.warn("[{}] - The list of speed test servers came empty", getClass().getName());
/* 187 */       return false;
/*     */     } 
/*     */     
/* 190 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 191 */     for (byte b = 0; b < f.length(); b++) {
/* 192 */       i i = f.b(b);
/* 193 */       str1 = i.getString("host");
/*     */       
/*     */       try {
/* 196 */         InetAddress inetAddress = InetAddress.getByName(str1.substring(0, str1.indexOf(":")));
/* 197 */         Long long_1 = Long.valueOf(System.nanoTime());
/* 198 */         inetAddress.isReachable(500);
/* 199 */         long_1 = Long.valueOf(System.nanoTime() - long_1.longValue());
/* 200 */         hashMap.put(String.join("", new CharSequence[] { "https://", i.getString("host") }), long_1);
/* 201 */       } catch (IOException iOException) {
/* 202 */         a.warn("[{}] - Failed to reach the '{}' server", new Object[] { getClass().getName(), str1, iOException });
/*     */       } 
/*     */     } 
/*     */     
/* 206 */     Optional<Map.Entry> optional = hashMap.entrySet().stream().min(Comparator.comparing(Map.Entry::getValue));
/* 207 */     if (!optional.isPresent()) {
/* 208 */       a.warn("[{}] - Failed to pick up server with the shortest reach", getClass().getName());
/* 209 */       return false;
/*     */     } 
/*     */     
/* 212 */     String str2 = ((String)((Map.Entry)optional.get()).getKey()).replace("https://", "");
/* 213 */     str1 = (String)((Map.Entry)optional.get()).getKey();
/* 214 */     str1 = String.join("", new CharSequence[] { str1, "/download?size=100000000" });
/*     */     
/* 216 */     Long long_ = Long.valueOf(TimeUnit.SECONDS.toMillis(30L));
/* 217 */     long l = System.currentTimeMillis();
/* 218 */     ArrayList<Double> arrayList = new ArrayList();
/*     */     
/* 220 */     while (System.currentTimeMillis() - l < long_.longValue()) {
/* 221 */       httpUriRequest = a(str1, 
/* 222 */           Arrays.asList(new BasicHeader[] { 
/*     */               new BasicHeader("Accept", "*/*"), new BasicHeader("Accept-Encoding", "gzip, deflate, br"), new BasicHeader("Accept-Language", "pt-BR,pt;q=0.9,en-US;q=0.8,en;q=0.7"), new BasicHeader("Connection", "keep-alive"), new BasicHeader("Host", str2), new BasicHeader("Origin", "https://www.speedtest.net"), new BasicHeader("Referer", "https://www.speedtest.net/"), new BasicHeader("Sec-Fetch-Dest", "empty"), new BasicHeader("Sec-Fetch-Mode", "cors"), new BasicHeader("Sec-Fetch-Site", "cross-site"), 
/*     */               new BasicHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.193 Safari/537.36") }));
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
/* 235 */       try (CloseableHttpResponse null = this.a.execute(httpUriRequest)) {
/* 236 */         httpEntity = closeableHttpResponse.getEntity();
/* 237 */         try (InputStream null = httpEntity.getContent()) {
/*     */ 
/*     */           
/* 240 */           long l1 = System.currentTimeMillis();
/*     */           
/* 242 */           double d = 0.0D;
/*     */ 
/*     */           
/* 245 */           byte[] arrayOfByte = new byte[4096]; int i;
/* 246 */           while ((i = inputStream.read(arrayOfByte)) != -1 && System.currentTimeMillis() - l < long_.longValue()) {
/* 247 */             d += i;
/* 248 */             long l2 = System.currentTimeMillis() - l1;
/* 249 */             if (l2 > 500L) {
/* 250 */               d = d / l2 / 1000.0D / 1000.0D / 1000.0D * 8.0D;
/*     */               
/* 252 */               arrayList.add(Double.valueOf(d));
/* 253 */               if (arrayList.size() > 5) {
/* 254 */                 arrayList.remove(0);
/*     */               }
/*     */               
/* 257 */               parama.getInternetSpeed(Double.valueOf(arrayList.stream().mapToDouble(paramDouble -> paramDouble.doubleValue()).average().getAsDouble()));
/*     */               
/* 259 */               l1 = System.currentTimeMillis();
/* 260 */               d = 0.0D;
/*     */             } 
/*     */           } 
/* 263 */         } catch (ConnectionClosedException connectionClosedException) {}
/*     */       
/*     */       }
/* 266 */       catch (Exception exception) {
/* 267 */         a.error("[{}] - Failed to perform the internet speed test in the '{}' url", new Object[] { getClass().getName(), str1, exception });
/*     */       } finally {
/* 269 */         if (httpEntity != null) {
/* 270 */           EntityUtils.consumeQuietly(httpEntity);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 275 */     this.a.clear();
/* 276 */     return true;
/*     */   }
/*     */   
/*     */   private HttpUriRequest a(String paramString) {
/* 280 */     return a(paramString, (List<BasicHeader>)null);
/*     */   }
/*     */   
/*     */   private HttpUriRequest a(String paramString, List<BasicHeader> paramList) {
/* 284 */     HttpUriRequest httpUriRequest = RequestBuilder.get().setUri(paramString).build();
/*     */     
/* 286 */     if (paramList != null && !paramList.isEmpty()) {
/* 287 */       paramList.forEach(paramBasicHeader -> paramHttpUriRequest.addHeader((Header)paramBasicHeader));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 292 */     StringBuilder stringBuilder = new StringBuilder();
/* 293 */     this.a.getCookies().forEach(paramCookie -> paramStringBuilder.append(paramCookie.getName()).append("=").append(paramCookie.getValue()).append(";"));
/*     */ 
/*     */ 
/*     */     
/* 297 */     String str = stringBuilder.toString();
/* 298 */     if (str.length() > 0) {
/* 299 */       httpUriRequest.addHeader("Cookie", str);
/*     */     }
/*     */     
/* 302 */     return httpUriRequest;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CloseableHttpClient a() {
/* 310 */     RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(30000).setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
/*     */     
/* 312 */     SSLContext sSLContext = null;
/*     */     try {
/* 314 */       SSLContextBuilder sSLContextBuilder = SSLContexts.custom();
/* 315 */       sSLContextBuilder.loadTrustMaterial(null, (paramArrayOfX509Certificate, paramString) -> true).build();
/* 316 */       sSLContext = sSLContextBuilder.build();
/* 317 */     } catch (KeyManagementException|java.security.KeyStoreException|java.security.NoSuchAlgorithmException keyManagementException) {
/* 318 */       a.error("[{}] - Failed to create SSLContext", getClass().getName(), keyManagementException);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     HttpClientBuilder httpClientBuilder = HttpClients.custom().setSSLContext(sSLContext).setSSLHostnameVerifier((HostnameVerifier)new NoopHostnameVerifier()).setDefaultRequestConfig(requestConfig).setDefaultCookieStore((CookieStore)this.a).setConnectionManagerShared(true).setRedirectStrategy((RedirectStrategy)new LaxRedirectStrategy());
/*     */     
/* 329 */     return httpClientBuilder.build();
/*     */   }
/*     */   
/*     */   public static interface a {
/*     */     void getInternetSpeed(Double param1Double);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\m\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */