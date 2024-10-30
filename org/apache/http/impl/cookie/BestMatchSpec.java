/*    */ package org.apache.http.impl.cookie;
/*    */ 
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
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
/*    */ @Contract(threading = ThreadingBehavior.SAFE)
/*    */ public class BestMatchSpec
/*    */   extends DefaultCookieSpec
/*    */ {
/*    */   public BestMatchSpec(String[] paramArrayOfString, boolean paramBoolean) {
/* 46 */     super(paramArrayOfString, paramBoolean);
/*    */   }
/*    */   
/*    */   public BestMatchSpec() {
/* 50 */     this(null, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return "best-match";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\cookie\BestMatchSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */