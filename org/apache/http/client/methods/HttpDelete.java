/*    */ package org.apache.http.client.methods;
/*    */ 
/*    */ import java.net.URI;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class HttpDelete
/*    */   extends HttpRequestBase
/*    */ {
/*    */   public static final String METHOD_NAME = "DELETE";
/*    */   
/*    */   public HttpDelete() {}
/*    */   
/*    */   public HttpDelete(URI paramURI) {
/* 58 */     setURI(paramURI);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public HttpDelete(String paramString) {
/* 66 */     setURI(URI.create(paramString));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMethod() {
/* 71 */     return "DELETE";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\client\methods\HttpDelete.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */