/*     */ package org.apache.http.auth;
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
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class AuthSchemeRegistry
/*     */   implements Lookup<AuthSchemeProvider>
/*     */ {
/*  60 */   private final ConcurrentHashMap<String, AuthSchemeFactory> registeredSchemes = new ConcurrentHashMap<String, AuthSchemeFactory>();
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
/*     */   public void register(String paramString, AuthSchemeFactory paramAuthSchemeFactory) {
/*  81 */     Args.notNull(paramString, "Name");
/*  82 */     Args.notNull(paramAuthSchemeFactory, "Authentication scheme factory");
/*  83 */     this.registeredSchemes.put(paramString.toLowerCase(Locale.ENGLISH), paramAuthSchemeFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(String paramString) {
/*  93 */     Args.notNull(paramString, "Name");
/*  94 */     this.registeredSchemes.remove(paramString.toLowerCase(Locale.ENGLISH));
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
/*     */   public AuthScheme getAuthScheme(String paramString, HttpParams paramHttpParams) throws IllegalStateException {
/* 111 */     Args.notNull(paramString, "Name");
/* 112 */     AuthSchemeFactory authSchemeFactory = this.registeredSchemes.get(paramString.toLowerCase(Locale.ENGLISH));
/* 113 */     if (authSchemeFactory != null) {
/* 114 */       return authSchemeFactory.newInstance(paramHttpParams);
/*     */     }
/* 116 */     throw new IllegalStateException("Unsupported authentication scheme: " + paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getSchemeNames() {
/* 126 */     return new ArrayList<String>(this.registeredSchemes.keySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItems(Map<String, AuthSchemeFactory> paramMap) {
/* 136 */     if (paramMap == null) {
/*     */       return;
/*     */     }
/* 139 */     this.registeredSchemes.clear();
/* 140 */     this.registeredSchemes.putAll(paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public AuthSchemeProvider lookup(final String name) {
/* 145 */     return new AuthSchemeProvider()
/*     */       {
/*     */         public AuthScheme create(HttpContext param1HttpContext)
/*     */         {
/* 149 */           HttpRequest httpRequest = (HttpRequest)param1HttpContext.getAttribute("http.request");
/*     */           
/* 151 */           return AuthSchemeRegistry.this.getAuthScheme(name, httpRequest.getParams());
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\AuthSchemeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */