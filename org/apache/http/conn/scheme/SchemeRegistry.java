/*     */ package org.apache.http.conn.scheme;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.apache.http.HttpHost;
/*     */ import org.apache.http.annotation.Contract;
/*     */ import org.apache.http.annotation.ThreadingBehavior;
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
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ @Contract(threading = ThreadingBehavior.SAFE)
/*     */ public final class SchemeRegistry
/*     */ {
/*  59 */   private final ConcurrentHashMap<String, Scheme> registeredSchemes = new ConcurrentHashMap<String, Scheme>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Scheme getScheme(String paramString) {
/*  73 */     Scheme scheme = get(paramString);
/*  74 */     if (scheme == null) {
/*  75 */       throw new IllegalStateException("Scheme '" + paramString + "' not registered.");
/*     */     }
/*     */     
/*  78 */     return scheme;
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
/*     */   public Scheme getScheme(HttpHost paramHttpHost) {
/*  93 */     Args.notNull(paramHttpHost, "Host");
/*  94 */     return getScheme(paramHttpHost.getSchemeName());
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
/*     */   public Scheme get(String paramString) {
/* 106 */     Args.notNull(paramString, "Scheme name");
/*     */ 
/*     */     
/* 109 */     return this.registeredSchemes.get(paramString);
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
/*     */   public Scheme register(Scheme paramScheme) {
/* 124 */     Args.notNull(paramScheme, "Scheme");
/* 125 */     return this.registeredSchemes.put(paramScheme.getName(), paramScheme);
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
/*     */   public Scheme unregister(String paramString) {
/* 138 */     Args.notNull(paramString, "Scheme name");
/*     */ 
/*     */     
/* 141 */     return this.registeredSchemes.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getSchemeNames() {
/* 151 */     return new ArrayList<String>(this.registeredSchemes.keySet());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setItems(Map<String, Scheme> paramMap) {
/* 161 */     if (paramMap == null) {
/*     */       return;
/*     */     }
/* 164 */     this.registeredSchemes.clear();
/* 165 */     this.registeredSchemes.putAll(paramMap);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\conn\scheme\SchemeRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */