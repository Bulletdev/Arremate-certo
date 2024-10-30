/*    */ package org.apache.http.params;
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
/*    */ public class HttpConnectionParamBean
/*    */   extends HttpAbstractParamBean
/*    */ {
/*    */   public HttpConnectionParamBean(HttpParams paramHttpParams) {
/* 44 */     super(paramHttpParams);
/*    */   }
/*    */   
/*    */   public void setSoTimeout(int paramInt) {
/* 48 */     HttpConnectionParams.setSoTimeout(this.params, paramInt);
/*    */   }
/*    */   
/*    */   public void setTcpNoDelay(boolean paramBoolean) {
/* 52 */     HttpConnectionParams.setTcpNoDelay(this.params, paramBoolean);
/*    */   }
/*    */   
/*    */   public void setSocketBufferSize(int paramInt) {
/* 56 */     HttpConnectionParams.setSocketBufferSize(this.params, paramInt);
/*    */   }
/*    */   
/*    */   public void setLinger(int paramInt) {
/* 60 */     HttpConnectionParams.setLinger(this.params, paramInt);
/*    */   }
/*    */   
/*    */   public void setConnectionTimeout(int paramInt) {
/* 64 */     HttpConnectionParams.setConnectionTimeout(this.params, paramInt);
/*    */   }
/*    */   
/*    */   public void setStaleCheckingEnabled(boolean paramBoolean) {
/* 68 */     HttpConnectionParams.setStaleCheckingEnabled(this.params, paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\HttpConnectionParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */