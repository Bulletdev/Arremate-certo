/*    */ package org.apache.http.protocol;
/*    */ 
/*    */ import org.apache.http.util.Args;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public final class DefaultedHttpContext
/*    */   implements HttpContext
/*    */ {
/*    */   private final HttpContext local;
/*    */   private final HttpContext defaults;
/*    */   
/*    */   public DefaultedHttpContext(HttpContext paramHttpContext1, HttpContext paramHttpContext2) {
/* 50 */     this.local = (HttpContext)Args.notNull(paramHttpContext1, "HTTP context");
/* 51 */     this.defaults = paramHttpContext2;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object getAttribute(String paramString) {
/* 56 */     Object object = this.local.getAttribute(paramString);
/* 57 */     if (object == null) {
/* 58 */       return this.defaults.getAttribute(paramString);
/*    */     }
/* 60 */     return object;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object removeAttribute(String paramString) {
/* 65 */     return this.local.removeAttribute(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setAttribute(String paramString, Object paramObject) {
/* 70 */     this.local.setAttribute(paramString, paramObject);
/*    */   }
/*    */   
/*    */   public HttpContext getDefaults() {
/* 74 */     return this.defaults;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 79 */     StringBuilder stringBuilder = new StringBuilder();
/* 80 */     stringBuilder.append("[local: ").append(this.local);
/* 81 */     stringBuilder.append("defaults: ").append(this.defaults);
/* 82 */     stringBuilder.append("]");
/* 83 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\DefaultedHttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */