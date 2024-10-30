/*    */ package org.apache.http.auth.params;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.params.HttpParams;
/*    */ import org.apache.http.protocol.HTTP;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public final class AuthParams
/*    */ {
/*    */   public static String getCredentialCharset(HttpParams paramHttpParams) {
/* 62 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 63 */     String str = (String)paramHttpParams.getParameter("http.auth.credential-charset");
/*    */     
/* 65 */     if (str == null) {
/* 66 */       str = HTTP.DEF_PROTOCOL_CHARSET.name();
/*    */     }
/* 68 */     return str;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void setCredentialCharset(HttpParams paramHttpParams, String paramString) {
/* 79 */     Args.notNull(paramHttpParams, "HTTP parameters");
/* 80 */     paramHttpParams.setParameter("http.auth.credential-charset", paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\auth\params\AuthParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */