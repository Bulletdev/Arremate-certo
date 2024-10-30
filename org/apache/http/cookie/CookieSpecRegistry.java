/*     */ package org.apache.http.cookie;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.HttpRequest;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
/*     */ import org.apache.http.config.Lookup;
/*     */ import org.apache.http.params.HttpParams;
/*     */ import org.apache.http.protocol.HttpContext;
/*     */ import org.apache.http.util.Args;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class CookieSpecRegistry
/*     */   implements Lookup<CookieSpecProvider>
/*     */ {
/*  62 */   private final ConcurrentHashMap<String, CookieSpecFactory> registeredSpecs = new ConcurrentHashMap<String, CookieSpecFactory>();
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
/*     */   public void register(String paramString, CookieSpecFactory paramCookieSpecFactory) {
/*  77 */     Args.notNull(paramString, "Name");
/*  78 */     Args.notNull(paramCookieSpecFactory, "Cookie spec factory");
/*  79 */     this.registeredSpecs.put(paramString.toLowerCase(Locale.ENGLISH), paramCookieSpecFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(String paramString) {
/*  88 */     Args.notNull(paramString, "Id");
/*  89 */     this.registeredSpecs.remove(paramString.toLowerCase(Locale.ENGLISH));
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
/*     */   public CookieSpec getCookieSpec(String paramString, HttpParams paramHttpParams) throws IllegalStateException {
/* 106 */     Args.notNull(paramString, "Name");
/* 107 */     CookieSpecFactory cookieSpecFactory = this.registeredSpecs.get(paramString.toLowerCase(Locale.ENGLISH));
/* 108 */     if (cookieSpecFactory != null) {
/* 109 */       return cookieSpecFactory.newInstance(paramHttpParams);
/*     */     }
/* 111 */     throw new IllegalStateException("Unsupported cookie spec: " + paramString);
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
/*     */   public CookieSpec getCookieSpec(String paramString) throws IllegalStateException {
/* 125 */     return getCookieSpec(paramString, null);
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
/*     */   public List<String> getSpecNames() {
/* 138 */     return new ArrayList<String>(this.registeredSpecs.keySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItems(Map<String, CookieSpecFactory> paramMap) {
/* 148 */     if (paramMap == null) {
/*     */       return;
/*     */     }
/* 151 */     this.registeredSpecs.clear();
/* 152 */     this.registeredSpecs.putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public CookieSpecProvider lookup(final String name) {
/* 157 */     return new CookieSpecProvider()
/*     */       {
/*     */         public CookieSpec create(HttpContext param1HttpContext)
/*     */         {
/* 161 */           HttpRequest httpRequest = (HttpRequest)param1HttpContext.getAttribute("http.request");
/*     */           
/* 163 */           return CookieSpecRegistry.this.getCookieSpec(name, httpRequest.getParams());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\cookie\CookieSpecRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */