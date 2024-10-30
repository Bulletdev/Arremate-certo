/*     */ package org.apache.http.params;
/*     */ 
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
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
/*     */ 
/*     */ 
/*     */ @Deprecated
/*     */ public final class DefaultedHttpParams
/*     */   extends AbstractHttpParams
/*     */ {
/*     */   private final HttpParams local;
/*     */   private final HttpParams defaults;
/*     */   
/*     */   public DefaultedHttpParams(HttpParams paramHttpParams1, HttpParams paramHttpParams2) {
/*  60 */     this.local = (HttpParams)Args.notNull(paramHttpParams1, "Local HTTP parameters");
/*  61 */     this.defaults = paramHttpParams2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpParams copy() {
/*  69 */     HttpParams httpParams = this.local.copy();
/*  70 */     return new DefaultedHttpParams(httpParams, this.defaults);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getParameter(String paramString) {
/*  80 */     Object object = this.local.getParameter(paramString);
/*  81 */     if (object == null && this.defaults != null) {
/*  82 */       object = this.defaults.getParameter(paramString);
/*     */     }
/*  84 */     return object;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeParameter(String paramString) {
/*  93 */     return this.local.removeParameter(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpParams setParameter(String paramString, Object paramObject) {
/* 102 */     return this.local.setParameter(paramString, paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HttpParams getDefaults() {
/* 110 */     return this.defaults;
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
/*     */   public Set<String> getNames() {
/* 126 */     HashSet<String> hashSet = new HashSet<String>(getNames(this.defaults));
/* 127 */     hashSet.addAll(getNames(this.local));
/* 128 */     return hashSet;
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
/*     */   public Set<String> getDefaultNames() {
/* 142 */     return new HashSet<String>(getNames(this.defaults));
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
/*     */   public Set<String> getLocalNames() {
/* 156 */     return new HashSet<String>(getNames(this.local));
/*     */   }
/*     */ 
/*     */   
/*     */   private Set<String> getNames(HttpParams paramHttpParams) {
/* 161 */     if (paramHttpParams instanceof HttpParamsNames) {
/* 162 */       return ((HttpParamsNames)paramHttpParams).getNames();
/*     */     }
/* 164 */     throw new UnsupportedOperationException("HttpParams instance does not implement HttpParamsNames");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\DefaultedHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */