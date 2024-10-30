/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.http.Consts;
/*     */ import org.apache.http.NameValuePair;
/*     */ import org.apache.http.conn.util.InetAddressUtils;
/*     */ import org.apache.http.message.BasicNameValuePair;
/*     */ import org.apache.http.util.TextUtils;
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
/*     */ public class URIBuilder
/*     */ {
/*     */   private String scheme;
/*     */   private String encodedSchemeSpecificPart;
/*     */   private String encodedAuthority;
/*     */   private String userInfo;
/*     */   private String encodedUserInfo;
/*     */   private String host;
/*     */   private int port;
/*     */   private String encodedPath;
/*     */   private List<String> pathSegments;
/*     */   private String encodedQuery;
/*     */   private List<NameValuePair> queryParams;
/*     */   private String query;
/*     */   private Charset charset;
/*     */   private String fragment;
/*     */   private String encodedFragment;
/*     */   
/*     */   public URIBuilder() {
/*  72 */     this.port = -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder(String paramString) throws URISyntaxException {
/*  82 */     this(new URI(paramString), (Charset)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder(URI paramURI) {
/*  90 */     this(paramURI, (Charset)null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder(String paramString, Charset paramCharset) throws URISyntaxException {
/* 100 */     this(new URI(paramString), paramCharset);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder(URI paramURI, Charset paramCharset) {
/* 109 */     setCharset(paramCharset);
/* 110 */     digestURI(paramURI);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setCharset(Charset paramCharset) {
/* 117 */     this.charset = paramCharset;
/* 118 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Charset getCharset() {
/* 125 */     return this.charset;
/*     */   }
/*     */   
/*     */   private List<NameValuePair> parseQuery(String paramString, Charset paramCharset) {
/* 129 */     if (paramString != null && !paramString.isEmpty()) {
/* 130 */       return URLEncodedUtils.parse(paramString, paramCharset);
/*     */     }
/* 132 */     return null;
/*     */   }
/*     */   
/*     */   private List<String> parsePath(String paramString, Charset paramCharset) {
/* 136 */     if (paramString != null && !paramString.isEmpty()) {
/* 137 */       return URLEncodedUtils.parsePathSegments(paramString, paramCharset);
/*     */     }
/* 139 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI build() throws URISyntaxException {
/* 146 */     return new URI(buildString());
/*     */   }
/*     */   
/*     */   private String buildString() {
/* 150 */     StringBuilder stringBuilder = new StringBuilder();
/* 151 */     if (this.scheme != null) {
/* 152 */       stringBuilder.append(this.scheme).append(':');
/*     */     }
/* 154 */     if (this.encodedSchemeSpecificPart != null) {
/* 155 */       stringBuilder.append(this.encodedSchemeSpecificPart);
/*     */     } else {
/* 157 */       if (this.encodedAuthority != null) {
/* 158 */         stringBuilder.append("//").append(this.encodedAuthority);
/* 159 */       } else if (this.host != null) {
/* 160 */         stringBuilder.append("//");
/* 161 */         if (this.encodedUserInfo != null) {
/* 162 */           stringBuilder.append(this.encodedUserInfo).append("@");
/* 163 */         } else if (this.userInfo != null) {
/* 164 */           stringBuilder.append(encodeUserInfo(this.userInfo)).append("@");
/*     */         } 
/* 166 */         if (InetAddressUtils.isIPv6Address(this.host)) {
/* 167 */           stringBuilder.append("[").append(this.host).append("]");
/*     */         } else {
/* 169 */           stringBuilder.append(this.host);
/*     */         } 
/* 171 */         if (this.port >= 0) {
/* 172 */           stringBuilder.append(":").append(this.port);
/*     */         }
/*     */       } 
/* 175 */       if (this.encodedPath != null) {
/* 176 */         stringBuilder.append(normalizePath(this.encodedPath, (stringBuilder.length() == 0)));
/* 177 */       } else if (this.pathSegments != null) {
/* 178 */         stringBuilder.append(encodePath(this.pathSegments));
/*     */       } 
/* 180 */       if (this.encodedQuery != null) {
/* 181 */         stringBuilder.append("?").append(this.encodedQuery);
/* 182 */       } else if (this.queryParams != null && !this.queryParams.isEmpty()) {
/* 183 */         stringBuilder.append("?").append(encodeUrlForm(this.queryParams));
/* 184 */       } else if (this.query != null) {
/* 185 */         stringBuilder.append("?").append(encodeUric(this.query));
/*     */       } 
/*     */     } 
/* 188 */     if (this.encodedFragment != null) {
/* 189 */       stringBuilder.append("#").append(this.encodedFragment);
/* 190 */     } else if (this.fragment != null) {
/* 191 */       stringBuilder.append("#").append(encodeUric(this.fragment));
/*     */     } 
/* 193 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private static String normalizePath(String paramString, boolean paramBoolean) {
/* 197 */     String str = paramString;
/* 198 */     if (TextUtils.isBlank(str)) {
/* 199 */       return "";
/*     */     }
/* 201 */     if (!paramBoolean && !str.startsWith("/")) {
/* 202 */       str = "/" + str;
/*     */     }
/* 204 */     return str;
/*     */   }
/*     */   
/*     */   private void digestURI(URI paramURI) {
/* 208 */     this.scheme = paramURI.getScheme();
/* 209 */     this.encodedSchemeSpecificPart = paramURI.getRawSchemeSpecificPart();
/* 210 */     this.encodedAuthority = paramURI.getRawAuthority();
/* 211 */     this.host = paramURI.getHost();
/* 212 */     this.port = paramURI.getPort();
/* 213 */     this.encodedUserInfo = paramURI.getRawUserInfo();
/* 214 */     this.userInfo = paramURI.getUserInfo();
/* 215 */     this.encodedPath = paramURI.getRawPath();
/* 216 */     this.pathSegments = parsePath(paramURI.getRawPath(), (this.charset != null) ? this.charset : Consts.UTF_8);
/* 217 */     this.encodedQuery = paramURI.getRawQuery();
/* 218 */     this.queryParams = parseQuery(paramURI.getRawQuery(), (this.charset != null) ? this.charset : Consts.UTF_8);
/* 219 */     this.encodedFragment = paramURI.getRawFragment();
/* 220 */     this.fragment = paramURI.getFragment();
/*     */   }
/*     */   
/*     */   private String encodeUserInfo(String paramString) {
/* 224 */     return URLEncodedUtils.encUserInfo(paramString, (this.charset != null) ? this.charset : Consts.UTF_8);
/*     */   }
/*     */   
/*     */   private String encodePath(List<String> paramList) {
/* 228 */     return URLEncodedUtils.formatSegments(paramList, (this.charset != null) ? this.charset : Consts.UTF_8);
/*     */   }
/*     */   
/*     */   private String encodeUrlForm(List<NameValuePair> paramList) {
/* 232 */     return URLEncodedUtils.format(paramList, (this.charset != null) ? this.charset : Consts.UTF_8);
/*     */   }
/*     */   
/*     */   private String encodeUric(String paramString) {
/* 236 */     return URLEncodedUtils.encUric(paramString, (this.charset != null) ? this.charset : Consts.UTF_8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setScheme(String paramString) {
/* 243 */     this.scheme = paramString;
/* 244 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setUserInfo(String paramString) {
/* 252 */     this.userInfo = paramString;
/* 253 */     this.encodedSchemeSpecificPart = null;
/* 254 */     this.encodedAuthority = null;
/* 255 */     this.encodedUserInfo = null;
/* 256 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setUserInfo(String paramString1, String paramString2) {
/* 264 */     return setUserInfo(paramString1 + ':' + paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setHost(String paramString) {
/* 271 */     this.host = paramString;
/* 272 */     this.encodedSchemeSpecificPart = null;
/* 273 */     this.encodedAuthority = null;
/* 274 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setPort(int paramInt) {
/* 281 */     this.port = (paramInt < 0) ? -1 : paramInt;
/* 282 */     this.encodedSchemeSpecificPart = null;
/* 283 */     this.encodedAuthority = null;
/* 284 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setPath(String paramString) {
/* 293 */     return setPathSegments((paramString != null) ? URLEncodedUtils.splitPathSegments(paramString) : null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setPathSegments(String... paramVarArgs) {
/* 304 */     this.pathSegments = (paramVarArgs.length > 0) ? Arrays.<String>asList(paramVarArgs) : null;
/* 305 */     this.encodedSchemeSpecificPart = null;
/* 306 */     this.encodedPath = null;
/* 307 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setPathSegments(List<String> paramList) {
/* 318 */     this.pathSegments = (paramList != null && paramList.size() > 0) ? new ArrayList<String>(paramList) : null;
/* 319 */     this.encodedSchemeSpecificPart = null;
/* 320 */     this.encodedPath = null;
/* 321 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder removeQuery() {
/* 328 */     this.queryParams = null;
/* 329 */     this.query = null;
/* 330 */     this.encodedQuery = null;
/* 331 */     this.encodedSchemeSpecificPart = null;
/* 332 */     return this;
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
/*     */   @Deprecated
/*     */   public URIBuilder setQuery(String paramString) {
/* 346 */     this.queryParams = parseQuery(paramString, (this.charset != null) ? this.charset : Consts.UTF_8);
/* 347 */     this.query = null;
/* 348 */     this.encodedQuery = null;
/* 349 */     this.encodedSchemeSpecificPart = null;
/* 350 */     return this;
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
/*     */   public URIBuilder setParameters(List<NameValuePair> paramList) {
/* 364 */     if (this.queryParams == null) {
/* 365 */       this.queryParams = new ArrayList<NameValuePair>();
/*     */     } else {
/* 367 */       this.queryParams.clear();
/*     */     } 
/* 369 */     this.queryParams.addAll(paramList);
/* 370 */     this.encodedQuery = null;
/* 371 */     this.encodedSchemeSpecificPart = null;
/* 372 */     this.query = null;
/* 373 */     return this;
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
/*     */   public URIBuilder addParameters(List<NameValuePair> paramList) {
/* 387 */     if (this.queryParams == null) {
/* 388 */       this.queryParams = new ArrayList<NameValuePair>();
/*     */     }
/* 390 */     this.queryParams.addAll(paramList);
/* 391 */     this.encodedQuery = null;
/* 392 */     this.encodedSchemeSpecificPart = null;
/* 393 */     this.query = null;
/* 394 */     return this;
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
/*     */   public URIBuilder setParameters(NameValuePair... paramVarArgs) {
/* 408 */     if (this.queryParams == null) {
/* 409 */       this.queryParams = new ArrayList<NameValuePair>();
/*     */     } else {
/* 411 */       this.queryParams.clear();
/*     */     } 
/* 413 */     Collections.addAll(this.queryParams, paramVarArgs);
/* 414 */     this.encodedQuery = null;
/* 415 */     this.encodedSchemeSpecificPart = null;
/* 416 */     this.query = null;
/* 417 */     return this;
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
/*     */   public URIBuilder addParameter(String paramString1, String paramString2) {
/* 429 */     if (this.queryParams == null) {
/* 430 */       this.queryParams = new ArrayList<NameValuePair>();
/*     */     }
/* 432 */     this.queryParams.add(new BasicNameValuePair(paramString1, paramString2));
/* 433 */     this.encodedQuery = null;
/* 434 */     this.encodedSchemeSpecificPart = null;
/* 435 */     this.query = null;
/* 436 */     return this;
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
/*     */   public URIBuilder setParameter(String paramString1, String paramString2) {
/* 448 */     if (this.queryParams == null) {
/* 449 */       this.queryParams = new ArrayList<NameValuePair>();
/*     */     }
/* 451 */     if (!this.queryParams.isEmpty()) {
/* 452 */       for (Iterator<NameValuePair> iterator = this.queryParams.iterator(); iterator.hasNext(); ) {
/* 453 */         NameValuePair nameValuePair = iterator.next();
/* 454 */         if (nameValuePair.getName().equals(paramString1)) {
/* 455 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     }
/* 459 */     this.queryParams.add(new BasicNameValuePair(paramString1, paramString2));
/* 460 */     this.encodedQuery = null;
/* 461 */     this.encodedSchemeSpecificPart = null;
/* 462 */     this.query = null;
/* 463 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder clearParameters() {
/* 472 */     this.queryParams = null;
/* 473 */     this.encodedQuery = null;
/* 474 */     this.encodedSchemeSpecificPart = null;
/* 475 */     return this;
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
/*     */   public URIBuilder setCustomQuery(String paramString) {
/* 489 */     this.query = paramString;
/* 490 */     this.encodedQuery = null;
/* 491 */     this.encodedSchemeSpecificPart = null;
/* 492 */     this.queryParams = null;
/* 493 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URIBuilder setFragment(String paramString) {
/* 501 */     this.fragment = paramString;
/* 502 */     this.encodedFragment = null;
/* 503 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAbsolute() {
/* 510 */     return (this.scheme != null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpaque() {
/* 517 */     return (this.pathSegments == null && this.encodedPath == null);
/*     */   }
/*     */   
/*     */   public String getScheme() {
/* 521 */     return this.scheme;
/*     */   }
/*     */   
/*     */   public String getUserInfo() {
/* 525 */     return this.userInfo;
/*     */   }
/*     */   
/*     */   public String getHost() {
/* 529 */     return this.host;
/*     */   }
/*     */   
/*     */   public int getPort() {
/* 533 */     return this.port;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPathEmpty() {
/* 540 */     return ((this.pathSegments == null || this.pathSegments.isEmpty()) && (this.encodedPath == null || this.encodedPath.isEmpty()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getPathSegments() {
/* 548 */     return (this.pathSegments != null) ? new ArrayList<String>(this.pathSegments) : new ArrayList<String>();
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 552 */     if (this.pathSegments == null) {
/* 553 */       return null;
/*     */     }
/* 555 */     StringBuilder stringBuilder = new StringBuilder();
/* 556 */     for (String str : this.pathSegments) {
/* 557 */       stringBuilder.append('/').append(str);
/*     */     }
/* 559 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isQueryEmpty() {
/* 566 */     return ((this.queryParams == null || this.queryParams.isEmpty()) && this.encodedQuery == null);
/*     */   }
/*     */   
/*     */   public List<NameValuePair> getQueryParams() {
/* 570 */     return (this.queryParams != null) ? new ArrayList<NameValuePair>(this.queryParams) : new ArrayList<NameValuePair>();
/*     */   }
/*     */   
/*     */   public String getFragment() {
/* 574 */     return this.fragment;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 579 */     return buildString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\URIBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */