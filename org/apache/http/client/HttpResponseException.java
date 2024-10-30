/*    */ package org.apache.http.client;
/*    */ 
/*    */ import org.apache.http.util.TextUtils;
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
/*    */ public class HttpResponseException
/*    */   extends ClientProtocolException
/*    */ {
/*    */   private static final long serialVersionUID = -7186627969477257933L;
/*    */   private final int statusCode;
/*    */   private final String reasonPhrase;
/*    */   
/*    */   public HttpResponseException(int paramInt, String paramString) {
/* 44 */     super(String.format("status code: %d" + (TextUtils.isBlank(paramString) ? "" : ", reason phrase: %s"), new Object[] { Integer.valueOf(paramInt), paramString }));
/*    */     
/* 46 */     this.statusCode = paramInt;
/* 47 */     this.reasonPhrase = paramString;
/*    */   }
/*    */   
/*    */   public int getStatusCode() {
/* 51 */     return this.statusCode;
/*    */   }
/*    */   
/*    */   public String getReasonPhrase() {
/* 55 */     return this.reasonPhrase;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\HttpResponseException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */