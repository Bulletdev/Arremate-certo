/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.Obsolete;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.cookie.CookieSpec;
/*    */ import org.apache.http.cookie.CookieSpecProvider;
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
/*    */ @Obsolete
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE)
/*    */ public class NetscapeDraftSpecProvider
/*    */   implements CookieSpecProvider
/*    */ {
/*    */   private final String[] datepatterns;
/*    */   private volatile CookieSpec cookieSpec;
/*    */   
/*    */   public NetscapeDraftSpecProvider(String[] paramArrayOfString) {
/* 57 */     this.datepatterns = paramArrayOfString;
/*    */   }
/*    */   
/*    */   public NetscapeDraftSpecProvider() {
/* 61 */     this(null);
/*    */   }
/*    */ 
/*    */   
/*    */   public CookieSpec create(HttpContext paramHttpContext) {
/* 66 */     if (this.cookieSpec == null) {
/* 67 */       synchronized (this) {
/* 68 */         if (this.cookieSpec == null) {
/* 69 */           this.cookieSpec = new NetscapeDraftSpec(this.datepatterns);
/*    */         }
/*    */       } 
/*    */     }
/* 73 */     return this.cookieSpec;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\NetscapeDraftSpecProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */