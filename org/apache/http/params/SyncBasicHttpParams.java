/*    */ package org.apache.http.params;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
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
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public class SyncBasicHttpParams
/*    */   extends BasicHttpParams
/*    */ {
/*    */   private static final long serialVersionUID = 5387834869062660642L;
/*    */   
/*    */   public synchronized boolean removeParameter(String paramString) {
/* 52 */     return super.removeParameter(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized HttpParams setParameter(String paramString, Object paramObject) {
/* 57 */     return super.setParameter(paramString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Object getParameter(String paramString) {
/* 62 */     return super.getParameter(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized boolean isParameterSet(String paramString) {
/* 67 */     return super.isParameterSet(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized boolean isParameterSetLocally(String paramString) {
/* 72 */     return super.isParameterSetLocally(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void setParameters(String[] paramArrayOfString, Object paramObject) {
/* 77 */     super.setParameters(paramArrayOfString, paramObject);
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void clear() {
/* 82 */     super.clear();
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized Object clone() throws CloneNotSupportedException {
/* 87 */     return super.clone();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\SyncBasicHttpParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */