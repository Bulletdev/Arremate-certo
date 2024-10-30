/*    */ package org.apache.http.impl.auth;
/*    */ 
/*    */ import java.nio.charset.Charset;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.auth.AuthScheme;
/*    */ import org.apache.http.auth.AuthSchemeFactory;
/*    */ import org.apache.http.auth.AuthSchemeProvider;
/*    */ import org.apache.http.params.HttpParams;
/*    */ import org.apache.http.protocol.HttpContext;
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
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class BasicSchemeFactory
/*    */   implements AuthSchemeFactory, AuthSchemeProvider
/*    */ {
/*    */   private final Charset charset;
/*    */   
/*    */   public BasicSchemeFactory(Charset paramCharset) {
/* 57 */     this.charset = paramCharset;
/*    */   }
/*    */   
/*    */   public BasicSchemeFactory() {
/* 61 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public AuthScheme newInstance(HttpParams paramHttpParams) {
/* 66 */     return (AuthScheme)new BasicScheme();
/*    */   }
/*    */ 
/*    */   
/*    */   public AuthScheme create(HttpContext paramHttpContext) {
/* 71 */     return (AuthScheme)new BasicScheme(this.charset);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\auth\BasicSchemeFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */