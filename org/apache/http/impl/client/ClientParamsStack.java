/*     */ package org.apache.http.impl.client;
/*     */ 
/*     */ import org.apache.http.params.AbstractHttpParams;
/*     */ import org.apache.http.params.HttpParams;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public class ClientParamsStack
/*     */   extends AbstractHttpParams
/*     */ {
/*     */   protected final HttpParams applicationParams;
/*     */   protected final HttpParams clientParams;
/*     */   protected final HttpParams requestParams;
/*     */   protected final HttpParams overrideParams;
/*     */   
/*     */   public ClientParamsStack(HttpParams paramHttpParams1, HttpParams paramHttpParams2, HttpParams paramHttpParams3, HttpParams paramHttpParams4) {
/*  99 */     this.applicationParams = paramHttpParams1;
/* 100 */     this.clientParams = paramHttpParams2;
/* 101 */     this.requestParams = paramHttpParams3;
/* 102 */     this.overrideParams = paramHttpParams4;
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
/*     */   public ClientParamsStack(ClientParamsStack paramClientParamsStack) {
/* 114 */     this(paramClientParamsStack.getApplicationParams(), paramClientParamsStack.getClientParams(), paramClientParamsStack.getRequestParams(), paramClientParamsStack.getOverrideParams());
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
/*     */   public ClientParamsStack(ClientParamsStack paramClientParamsStack, HttpParams paramHttpParams1, HttpParams paramHttpParams2, HttpParams paramHttpParams3, HttpParams paramHttpParams4) {
/* 137 */     this((paramHttpParams1 != null) ? paramHttpParams1 : paramClientParamsStack.getApplicationParams(), (paramHttpParams2 != null) ? paramHttpParams2 : paramClientParamsStack.getClientParams(), (paramHttpParams3 != null) ? paramHttpParams3 : paramClientParamsStack.getRequestParams(), (paramHttpParams4 != null) ? paramHttpParams4 : paramClientParamsStack.getOverrideParams());
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
/*     */   public final HttpParams getApplicationParams() {
/* 150 */     return this.applicationParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final HttpParams getClientParams() {
/* 159 */     return this.clientParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final HttpParams getRequestParams() {
/* 168 */     return this.requestParams;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final HttpParams getOverrideParams() {
/* 177 */     return this.overrideParams;
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
/*     */   public Object getParameter(String paramString) {
/* 192 */     Args.notNull(paramString, "Parameter name");
/*     */     
/* 194 */     Object object = null;
/*     */     
/* 196 */     if (this.overrideParams != null) {
/* 197 */       object = this.overrideParams.getParameter(paramString);
/*     */     }
/* 199 */     if (object == null && this.requestParams != null) {
/* 200 */       object = this.requestParams.getParameter(paramString);
/*     */     }
/* 202 */     if (object == null && this.clientParams != null) {
/* 203 */       object = this.clientParams.getParameter(paramString);
/*     */     }
/* 205 */     if (object == null && this.applicationParams != null) {
/* 206 */       object = this.applicationParams.getParameter(paramString);
/*     */     }
/* 208 */     return object;
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
/*     */   public HttpParams setParameter(String paramString, Object paramObject) throws UnsupportedOperationException {
/* 228 */     throw new UnsupportedOperationException("Setting parameters in a stack is not supported.");
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
/*     */   public boolean removeParameter(String paramString) {
/* 247 */     throw new UnsupportedOperationException("Removing parameters in a stack is not supported.");
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
/*     */   public HttpParams copy() {
/* 268 */     return (HttpParams)this;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\client\ClientParamsStack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */