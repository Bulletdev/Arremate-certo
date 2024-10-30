/*    */ package org.apache.http.impl.entity;
/*    */ 
/*    */ import org.apache.http.HttpException;
/*    */ import org.apache.http.HttpMessage;
/*    */ import org.apache.http.ProtocolException;
/*    */ import org.apache.http.annotation.Contract;
/*    */ import org.apache.http.annotation.ThreadingBehavior;
/*    */ import org.apache.http.entity.ContentLengthStrategy;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Contract(threading = ThreadingBehavior.IMMUTABLE_CONDITIONAL)
/*    */ public class DisallowIdentityContentLengthStrategy
/*    */   implements ContentLengthStrategy
/*    */ {
/* 46 */   public static final DisallowIdentityContentLengthStrategy INSTANCE = new DisallowIdentityContentLengthStrategy(new LaxContentLengthStrategy(0));
/*    */ 
/*    */   
/*    */   private final ContentLengthStrategy contentLengthStrategy;
/*    */ 
/*    */   
/*    */   public DisallowIdentityContentLengthStrategy(ContentLengthStrategy paramContentLengthStrategy) {
/* 53 */     this.contentLengthStrategy = paramContentLengthStrategy;
/*    */   }
/*    */ 
/*    */   
/*    */   public long determineLength(HttpMessage paramHttpMessage) throws HttpException {
/* 58 */     long l = this.contentLengthStrategy.determineLength(paramHttpMessage);
/* 59 */     if (l == -1L) {
/* 60 */       throw new ProtocolException("Identity transfer encoding cannot be used");
/*    */     }
/* 62 */     return l;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\impl\entity\DisallowIdentityContentLengthStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */