/*    */ package org.apache.http.protocol;
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
/*    */ public class SyncBasicHttpContext
/*    */   extends BasicHttpContext
/*    */ {
/*    */   public SyncBasicHttpContext(HttpContext paramHttpContext) {
/* 41 */     super(paramHttpContext);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public SyncBasicHttpContext() {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized Object getAttribute(String paramString) {
/* 53 */     return super.getAttribute(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void setAttribute(String paramString, Object paramObject) {
/* 58 */     super.setAttribute(paramString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Object removeAttribute(String paramString) {
/* 63 */     return super.removeAttribute(paramString);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public synchronized void clear() {
/* 71 */     super.clear();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\protocol\SyncBasicHttpContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */