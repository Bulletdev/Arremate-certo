/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import java.util.Collection;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CookieSpec;
/*    */ import org.apache.http.cookie.CookieSpecFactory;
/*    */ import org.apache.http.cookie.CookieSpecProvider;
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
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class BrowserCompatSpecFactory
/*    */   implements CookieSpecFactory, CookieSpecProvider
/*    */ {
/*    */   private final SecurityLevel securityLevel;
/*    */   private final CookieSpec cookieSpec;
/*    */   
/*    */   public enum SecurityLevel
/*    */   {
/* 55 */     SECURITYLEVEL_DEFAULT,
/* 56 */     SECURITYLEVEL_IE_MEDIUM;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BrowserCompatSpecFactory(String[] paramArrayOfString, SecurityLevel paramSecurityLevel) {
/* 64 */     this.securityLevel = paramSecurityLevel;
/* 65 */     this.cookieSpec = new BrowserCompatSpec(paramArrayOfString, paramSecurityLevel);
/*    */   }
/*    */   
/*    */   public BrowserCompatSpecFactory(String[] paramArrayOfString) {
/* 69 */     this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
/*    */   }
/*    */   
/*    */   public BrowserCompatSpecFactory() {
/* 73 */     this(null, SecurityLevel.SECURITYLEVEL_DEFAULT);
/*    */   }
/*    */ 
/*    */   
/*    */   public CookieSpec newInstance(HttpParams paramHttpParams) {
/* 78 */     if (paramHttpParams != null) {
/*    */       
/* 80 */       String[] arrayOfString = null;
/* 81 */       Collection collection = (Collection)paramHttpParams.getParameter("http.protocol.cookie-datepatterns");
/*    */       
/* 83 */       if (collection != null) {
/* 84 */         arrayOfString = new String[collection.size()];
/* 85 */         arrayOfString = (String[])collection.toArray((Object[])arrayOfString);
/*    */       } 
/* 87 */       return new BrowserCompatSpec(arrayOfString, this.securityLevel);
/*    */     } 
/* 89 */     return new BrowserCompatSpec(null, this.securityLevel);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CookieSpec create(HttpContext paramHttpContext) {
/* 95 */     return this.cookieSpec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BrowserCompatSpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */