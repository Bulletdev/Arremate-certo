/*     */ package org.apache.http.client.utils;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.EnumSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Stack;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.conn.routing.RouteInfo;
/*     */ import org.apache.http.util.Args;
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
/*     */ 
/*     */ public class URIUtils
/*     */ {
/*     */   public enum UriFlag
/*     */   {
/*  57 */     DROP_FRAGMENT,
/*  58 */     NORMALIZE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   public static final EnumSet<UriFlag> NO_FLAGS = EnumSet.noneOf(UriFlag.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  73 */   public static final EnumSet<UriFlag> DROP_FRAGMENT = EnumSet.of(UriFlag.DROP_FRAGMENT);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  80 */   public static final EnumSet<UriFlag> NORMALIZE = EnumSet.of(UriFlag.NORMALIZE);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  87 */   public static final EnumSet<UriFlag> DROP_FRAGMENT_AND_NORMALIZE = EnumSet.of(UriFlag.DROP_FRAGMENT, UriFlag.NORMALIZE);
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
/*     */   @Deprecated
/*     */   public static URI createURI(String paramString1, String paramString2, int paramInt, String paramString3, String paramString4, String paramString5) throws URISyntaxException {
/* 125 */     StringBuilder stringBuilder = new StringBuilder();
/* 126 */     if (paramString2 != null) {
/* 127 */       if (paramString1 != null) {
/* 128 */         stringBuilder.append(paramString1);
/* 129 */         stringBuilder.append("://");
/*     */       } 
/* 131 */       stringBuilder.append(paramString2);
/* 132 */       if (paramInt > 0) {
/* 133 */         stringBuilder.append(':');
/* 134 */         stringBuilder.append(paramInt);
/*     */       } 
/*     */     } 
/* 137 */     if (paramString3 == null || !paramString3.startsWith("/")) {
/* 138 */       stringBuilder.append('/');
/*     */     }
/* 140 */     if (paramString3 != null) {
/* 141 */       stringBuilder.append(paramString3);
/*     */     }
/* 143 */     if (paramString4 != null) {
/* 144 */       stringBuilder.append('?');
/* 145 */       stringBuilder.append(paramString4);
/*     */     } 
/* 147 */     if (paramString5 != null) {
/* 148 */       stringBuilder.append('#');
/* 149 */       stringBuilder.append(paramString5);
/*     */     } 
/* 151 */     return new URI(stringBuilder.toString());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static URI rewriteURI(URI paramURI, HttpHost paramHttpHost, boolean paramBoolean) throws URISyntaxException {
/* 177 */     return rewriteURI(paramURI, paramHttpHost, paramBoolean ? DROP_FRAGMENT : NO_FLAGS);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URI rewriteURI(URI paramURI, HttpHost paramHttpHost, EnumSet<UriFlag> paramEnumSet) throws URISyntaxException {
/* 201 */     Args.notNull(paramURI, "URI");
/* 202 */     Args.notNull(paramEnumSet, "URI flags");
/* 203 */     if (paramURI.isOpaque()) {
/* 204 */       return paramURI;
/*     */     }
/* 206 */     URIBuilder uRIBuilder = new URIBuilder(paramURI);
/* 207 */     if (paramHttpHost != null) {
/* 208 */       uRIBuilder.setScheme(paramHttpHost.getSchemeName());
/* 209 */       uRIBuilder.setHost(paramHttpHost.getHostName());
/* 210 */       uRIBuilder.setPort(paramHttpHost.getPort());
/*     */     } else {
/* 212 */       uRIBuilder.setScheme(null);
/* 213 */       uRIBuilder.setHost(null);
/* 214 */       uRIBuilder.setPort(-1);
/*     */     } 
/* 216 */     if (paramEnumSet.contains(UriFlag.DROP_FRAGMENT)) {
/* 217 */       uRIBuilder.setFragment(null);
/*     */     }
/* 219 */     if (paramEnumSet.contains(UriFlag.NORMALIZE)) {
/* 220 */       List<String> list = uRIBuilder.getPathSegments();
/* 221 */       ArrayList<String> arrayList = new ArrayList<String>(list);
/* 222 */       for (Iterator<String> iterator = arrayList.iterator(); iterator.hasNext(); ) {
/* 223 */         String str = iterator.next();
/* 224 */         if (str.isEmpty() && iterator.hasNext()) {
/* 225 */           iterator.remove();
/*     */         }
/*     */       } 
/* 228 */       if (arrayList.size() != list.size()) {
/* 229 */         uRIBuilder.setPathSegments(arrayList);
/*     */       }
/*     */     } 
/* 232 */     if (uRIBuilder.isPathEmpty()) {
/* 233 */       uRIBuilder.setPathSegments(new String[] { "" });
/*     */     }
/* 235 */     return uRIBuilder.build();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URI rewriteURI(URI paramURI, HttpHost paramHttpHost) throws URISyntaxException {
/* 246 */     return rewriteURI(paramURI, paramHttpHost, NORMALIZE);
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
/*     */   public static URI rewriteURI(URI paramURI) throws URISyntaxException {
/* 261 */     Args.notNull(paramURI, "URI");
/* 262 */     if (paramURI.isOpaque()) {
/* 263 */       return paramURI;
/*     */     }
/* 265 */     URIBuilder uRIBuilder = new URIBuilder(paramURI);
/* 266 */     if (uRIBuilder.getUserInfo() != null) {
/* 267 */       uRIBuilder.setUserInfo(null);
/*     */     }
/* 269 */     if (uRIBuilder.getPathSegments().isEmpty()) {
/* 270 */       uRIBuilder.setPathSegments(new String[] { "" });
/*     */     }
/* 272 */     if (TextUtils.isEmpty(uRIBuilder.getPath())) {
/* 273 */       uRIBuilder.setPath("/");
/*     */     }
/* 275 */     if (uRIBuilder.getHost() != null) {
/* 276 */       uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
/*     */     }
/* 278 */     uRIBuilder.setFragment(null);
/* 279 */     return uRIBuilder.build();
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
/*     */   public static URI rewriteURIForRoute(URI paramURI, RouteInfo paramRouteInfo) throws URISyntaxException {
/* 294 */     return rewriteURIForRoute(paramURI, paramRouteInfo, true);
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
/*     */   public static URI rewriteURIForRoute(URI paramURI, RouteInfo paramRouteInfo, boolean paramBoolean) throws URISyntaxException {
/* 309 */     if (paramURI == null) {
/* 310 */       return null;
/*     */     }
/* 312 */     if (paramRouteInfo.getProxyHost() != null && !paramRouteInfo.isTunnelled())
/*     */     {
/* 314 */       return paramURI.isAbsolute() ? rewriteURI(paramURI) : rewriteURI(paramURI, paramRouteInfo.getTargetHost(), paramBoolean ? DROP_FRAGMENT_AND_NORMALIZE : DROP_FRAGMENT);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 319 */     return paramURI.isAbsolute() ? rewriteURI(paramURI, (HttpHost)null, paramBoolean ? DROP_FRAGMENT_AND_NORMALIZE : DROP_FRAGMENT) : rewriteURI(paramURI);
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
/*     */   public static URI resolve(URI paramURI, String paramString) {
/* 331 */     return resolve(paramURI, URI.create(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URI resolve(URI paramURI1, URI paramURI2) {
/*     */     URI uRI;
/* 343 */     Args.notNull(paramURI1, "Base URI");
/* 344 */     Args.notNull(paramURI2, "Reference URI");
/* 345 */     String str = paramURI2.toASCIIString();
/* 346 */     if (str.startsWith("?")) {
/* 347 */       String str1 = paramURI1.toASCIIString();
/* 348 */       int i = str1.indexOf('?');
/* 349 */       str1 = (i > -1) ? str1.substring(0, i) : str1;
/* 350 */       return URI.create(str1 + str);
/*     */     } 
/* 352 */     boolean bool = str.isEmpty();
/*     */     
/* 354 */     if (bool) {
/* 355 */       uRI = paramURI1.resolve(URI.create("#"));
/* 356 */       String str1 = uRI.toASCIIString();
/* 357 */       uRI = URI.create(str1.substring(0, str1.indexOf('#')));
/*     */     } else {
/* 359 */       uRI = paramURI1.resolve(paramURI2);
/*     */     } 
/*     */     try {
/* 362 */       return normalizeSyntax(uRI);
/* 363 */     } catch (URISyntaxException uRISyntaxException) {
/* 364 */       throw new IllegalArgumentException(uRISyntaxException);
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
/*     */ 
/*     */   
/*     */   public static URI normalizeSyntax(URI paramURI) throws URISyntaxException {
/* 378 */     if (paramURI.isOpaque() || paramURI.getAuthority() == null)
/*     */     {
/* 380 */       return paramURI;
/*     */     }
/* 382 */     URIBuilder uRIBuilder = new URIBuilder(paramURI);
/* 383 */     List<String> list = uRIBuilder.getPathSegments();
/* 384 */     Stack<String> stack = new Stack();
/* 385 */     for (String str : list) {
/* 386 */       if (".".equals(str))
/*     */         continue; 
/* 388 */       if ("..".equals(str)) {
/* 389 */         if (!stack.isEmpty())
/* 390 */           stack.pop(); 
/*     */         continue;
/*     */       } 
/* 393 */       stack.push(str);
/*     */     } 
/*     */     
/* 396 */     if (stack.size() == 0) {
/* 397 */       stack.add("");
/*     */     }
/* 399 */     uRIBuilder.setPathSegments(stack);
/* 400 */     if (uRIBuilder.getScheme() != null) {
/* 401 */       uRIBuilder.setScheme(uRIBuilder.getScheme().toLowerCase(Locale.ROOT));
/*     */     }
/* 403 */     if (uRIBuilder.getHost() != null) {
/* 404 */       uRIBuilder.setHost(uRIBuilder.getHost().toLowerCase(Locale.ROOT));
/*     */     }
/* 406 */     return uRIBuilder.build();
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
/*     */   public static HttpHost extractHost(URI paramURI) {
/* 419 */     if (paramURI == null) {
/* 420 */       return null;
/*     */     }
/* 422 */     if (paramURI.isAbsolute()) {
/* 423 */       if (paramURI.getHost() == null) {
/*     */         
/* 425 */         if (paramURI.getAuthority() != null) {
/* 426 */           String str3; byte b; String str1 = paramURI.getAuthority();
/*     */           
/* 428 */           int i = str1.indexOf('@');
/* 429 */           if (i != -1) {
/* 430 */             str1 = str1.substring(i + 1);
/*     */           }
/* 432 */           String str2 = paramURI.getScheme();
/*     */ 
/*     */           
/* 435 */           i = str1.indexOf(":");
/* 436 */           if (i != -1) {
/* 437 */             str3 = str1.substring(0, i);
/*     */             try {
/* 439 */               String str = str1.substring(i + 1);
/* 440 */               b = !TextUtils.isEmpty(str) ? Integer.parseInt(str) : -1;
/* 441 */             } catch (NumberFormatException numberFormatException) {
/* 442 */               return null;
/*     */             } 
/*     */           } else {
/* 445 */             str3 = str1;
/* 446 */             b = -1;
/*     */           } 
/*     */           try {
/* 449 */             return new HttpHost(str3, b, str2);
/* 450 */           } catch (IllegalArgumentException illegalArgumentException) {}
/*     */         }
/*     */       
/*     */       } else {
/*     */         
/* 455 */         return new HttpHost(paramURI.getHost(), paramURI.getPort(), paramURI.getScheme());
/*     */       } 
/*     */     }
/* 458 */     return null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static URI resolve(URI paramURI, HttpHost paramHttpHost, List<URI> paramList) throws URISyntaxException {
/*     */     URIBuilder uRIBuilder;
/* 481 */     Args.notNull(paramURI, "Request URI");
/*     */     
/* 483 */     if (paramList == null || paramList.isEmpty()) {
/* 484 */       uRIBuilder = new URIBuilder(paramURI);
/*     */     } else {
/* 486 */       uRIBuilder = new URIBuilder(paramList.get(paramList.size() - 1));
/* 487 */       String str = uRIBuilder.getFragment();
/*     */       
/* 489 */       for (int i = paramList.size() - 1; str == null && i >= 0; i--) {
/* 490 */         str = ((URI)paramList.get(i)).getFragment();
/*     */       }
/* 492 */       uRIBuilder.setFragment(str);
/*     */     } 
/*     */     
/* 495 */     if (uRIBuilder.getFragment() == null) {
/* 496 */       uRIBuilder.setFragment(paramURI.getFragment());
/*     */     }
/*     */     
/* 499 */     if (paramHttpHost != null && !uRIBuilder.isAbsolute()) {
/* 500 */       uRIBuilder.setScheme(paramHttpHost.getSchemeName());
/* 501 */       uRIBuilder.setHost(paramHttpHost.getHostName());
/* 502 */       uRIBuilder.setPort(paramHttpHost.getPort());
/*     */     } 
/* 504 */     return uRIBuilder.build();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\clien\\utils\URIUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */