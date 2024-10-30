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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class RFC2965SpecFactory
/*    */   implements CookieSpecFactory, CookieSpecProvider
/*    */ {
/*    */   private final CookieSpec cookieSpec;
/*    */   
/*    */   public RFC2965SpecFactory(String[] paramArrayOfString, boolean paramBoolean) {
/* 58 */     this.cookieSpec = new RFC2965Spec(paramArrayOfString, paramBoolean);
/*    */   }
/*    */   
/*    */   public RFC2965SpecFactory() {
/* 62 */     this(null, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public CookieSpec newInstance(HttpParams paramHttpParams) {
/* 67 */     if (paramHttpParams != null) {
/*    */       
/* 69 */       String[] arrayOfString = null;
/* 70 */       Collection collection = (Collection)paramHttpParams.getParameter("http.protocol.cookie-datepatterns");
/*    */       
/* 72 */       if (collection != null) {
/* 73 */         arrayOfString = new String[collection.size()];
/* 74 */         arrayOfString = (String[])collection.toArray((Object[])arrayOfString);
/*    */       } 
/* 76 */       boolean bool = paramHttpParams.getBooleanParameter("http.protocol.single-cookie-header", false);
/*    */ 
/*    */       
/* 79 */       return new RFC2965Spec(arrayOfString, bool);
/*    */     } 
/* 81 */     return new RFC2965Spec();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CookieSpec create(HttpContext paramHttpContext) {
/* 87 */     return this.cookieSpec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\RFC2965SpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */