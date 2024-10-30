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
/*    */ public class NetscapeDraftSpecFactory
/*    */   implements CookieSpecFactory, CookieSpecProvider
/*    */ {
/*    */   private final CookieSpec cookieSpec;
/*    */   
/*    */   public NetscapeDraftSpecFactory(String[] paramArrayOfString) {
/* 58 */     this.cookieSpec = new NetscapeDraftSpec(paramArrayOfString);
/*    */   }
/*    */   
/*    */   public NetscapeDraftSpecFactory() {
/* 62 */     this(null);
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
/* 76 */       return new NetscapeDraftSpec(arrayOfString);
/*    */     } 
/* 78 */     return new NetscapeDraftSpec();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public CookieSpec create(HttpContext paramHttpContext) {
/* 84 */     return this.cookieSpec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\NetscapeDraftSpecFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */