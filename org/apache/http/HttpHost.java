/*     */ package org.apache.http;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.net.InetAddress;
/*     */ import java.util.Locale;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.util.Args;
/*     */ import org.apache.http.util.LangUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*     */ public final class HttpHost
/*     */   implements Serializable, Cloneable
/*     */ {
/*     */   private static final long serialVersionUID = -7529410654042457626L;
/*     */   public static final String DEFAULT_SCHEME_NAME = "http";
/*     */   protected final String hostname;
/*     */   protected final String lcHostname;
/*     */   protected final int port;
/*     */   protected final String schemeName;
/*     */   protected final InetAddress address;
/*     */   
/*     */   public HttpHost(String paramString1, int paramInt, String paramString2) {
/*  80 */     this.hostname = (String)Args.containsNoBlanks(paramString1, "Host name");
/*  81 */     this.lcHostname = paramString1.toLowerCase(Locale.ROOT);
/*  82 */     if (paramString2 != null) {
/*  83 */       this.schemeName = paramString2.toLowerCase(Locale.ROOT);
/*     */     } else {
/*  85 */       this.schemeName = "http";
/*     */     } 
/*  87 */     this.port = paramInt;
/*  88 */     this.address = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost(String paramString, int paramInt) {
/*  99 */     this(paramString, paramInt, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static HttpHost create(String paramString) {
/* 108 */     Args.containsNoBlanks(paramString, "HTTP Host");
/* 109 */     String str1 = paramString;
/* 110 */     String str2 = null;
/* 111 */     int i = str1.indexOf("://");
/* 112 */     if (i > 0) {
/* 113 */       str2 = str1.substring(0, i);
/* 114 */       str1 = str1.substring(i + 3);
/*     */     } 
/* 116 */     int j = -1;
/* 117 */     int k = str1.lastIndexOf(":");
/* 118 */     if (k > 0) {
/*     */       try {
/* 120 */         j = Integer.parseInt(str1.substring(k + 1));
/* 121 */       } catch (NumberFormatException numberFormatException) {
/* 122 */         throw new IllegalArgumentException("Invalid HTTP host: " + str1);
/*     */       } 
/* 124 */       str1 = str1.substring(0, k);
/*     */     } 
/* 126 */     return new HttpHost(str1, j, str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost(String paramString) {
/* 135 */     this(paramString, -1, (String)null);
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost(InetAddress paramInetAddress, int paramInt, String paramString) {
/* 151 */     this((InetAddress)Args.notNull(paramInetAddress, "Inet address"), paramInetAddress.getHostName(), paramInt, paramString);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost(InetAddress paramInetAddress, String paramString1, int paramInt, String paramString2) {
/* 169 */     this.address = (InetAddress)Args.notNull(paramInetAddress, "Inet address");
/* 170 */     this.hostname = (String)Args.notNull(paramString1, "Hostname");
/* 171 */     this.lcHostname = this.hostname.toLowerCase(Locale.ROOT);
/* 172 */     if (paramString2 != null) {
/* 173 */       this.schemeName = paramString2.toLowerCase(Locale.ROOT);
/*     */     } else {
/* 175 */       this.schemeName = "http";
/*     */     } 
/* 177 */     this.port = paramInt;
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
/*     */ 
/*     */   
/*     */   public HttpHost(InetAddress paramInetAddress, int paramInt) {
/* 191 */     this(paramInetAddress, paramInt, (String)null);
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
/*     */   public HttpHost(InetAddress paramInetAddress) {
/* 203 */     this(paramInetAddress, -1, (String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpHost(HttpHost paramHttpHost) {
/* 213 */     Args.notNull(paramHttpHost, "HTTP host");
/* 214 */     this.hostname = paramHttpHost.hostname;
/* 215 */     this.lcHostname = paramHttpHost.lcHostname;
/* 216 */     this.schemeName = paramHttpHost.schemeName;
/* 217 */     this.port = paramHttpHost.port;
/* 218 */     this.address = paramHttpHost.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHostName() {
/* 227 */     return this.hostname;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPort() {
/* 236 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchemeName() {
/* 245 */     return this.schemeName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InetAddress getAddress() {
/* 256 */     return this.address;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toURI() {
/* 265 */     StringBuilder stringBuilder = new StringBuilder();
/* 266 */     stringBuilder.append(this.schemeName);
/* 267 */     stringBuilder.append("://");
/* 268 */     stringBuilder.append(this.hostname);
/* 269 */     if (this.port != -1) {
/* 270 */       stringBuilder.append(':');
/* 271 */       stringBuilder.append(Integer.toString(this.port));
/*     */     } 
/* 273 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toHostString() {
/* 283 */     if (this.port != -1) {
/*     */       
/* 285 */       StringBuilder stringBuilder = new StringBuilder(this.hostname.length() + 6);
/* 286 */       stringBuilder.append(this.hostname);
/* 287 */       stringBuilder.append(":");
/* 288 */       stringBuilder.append(Integer.toString(this.port));
/* 289 */       return stringBuilder.toString();
/*     */     } 
/* 291 */     return this.hostname;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 297 */     return toURI();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 303 */     if (this == paramObject) {
/* 304 */       return true;
/*     */     }
/* 306 */     if (paramObject instanceof HttpHost) {
/* 307 */       HttpHost httpHost = (HttpHost)paramObject;
/* 308 */       return (this.lcHostname.equals(httpHost.lcHostname) && this.port == httpHost.port && this.schemeName.equals(httpHost.schemeName) && ((this.address == null) ? (httpHost.address == null) : this.address.equals(httpHost.address)));
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 313 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 321 */     int i = 17;
/* 322 */     i = LangUtils.hashCode(i, this.lcHostname);
/* 323 */     i = LangUtils.hashCode(i, this.port);
/* 324 */     i = LangUtils.hashCode(i, this.schemeName);
/* 325 */     if (this.address != null) {
/* 326 */       i = LangUtils.hashCode(i, this.address);
/*     */     }
/* 328 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() throws CloneNotSupportedException {
/* 333 */     return super.clone();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\HttpHost.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */