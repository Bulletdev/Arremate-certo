/*    */ package org.apache.http.params;
/*    */ 
/*    */ import org.apache.http.HttpVersion;
/*    */ import org.apache.http.ProtocolVersion;
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
/*    */ public class HttpProtocolParamBean
/*    */   extends HttpAbstractParamBean
/*    */ {
/*    */   public HttpProtocolParamBean(HttpParams paramHttpParams) {
/* 46 */     super(paramHttpParams);
/*    */   }
/*    */   
/*    */   public void setHttpElementCharset(String paramString) {
/* 50 */     HttpProtocolParams.setHttpElementCharset(this.params, paramString);
/*    */   }
/*    */   
/*    */   public void setContentCharset(String paramString) {
/* 54 */     HttpProtocolParams.setContentCharset(this.params, paramString);
/*    */   }
/*    */   
/*    */   public void setVersion(HttpVersion paramHttpVersion) {
/* 58 */     HttpProtocolParams.setVersion(this.params, (ProtocolVersion)paramHttpVersion);
/*    */   }
/*    */   
/*    */   public void setUserAgent(String paramString) {
/* 62 */     HttpProtocolParams.setUserAgent(this.params, paramString);
/*    */   }
/*    */   
/*    */   public void setUseExpectContinue(boolean paramBoolean) {
/* 66 */     HttpProtocolParams.setUseExpectContinue(this.params, paramBoolean);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\params\HttpProtocolParamBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */