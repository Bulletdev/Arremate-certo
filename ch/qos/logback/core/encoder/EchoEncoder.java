/*    */ package ch.qos.logback.core.encoder;
/*    */ 
/*    */ import ch.qos.logback.core.CoreConstants;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EchoEncoder<E>
/*    */   extends EncoderBase<E>
/*    */ {
/*    */   String fileHeader;
/*    */   String fileFooter;
/*    */   
/*    */   public byte[] encode(E paramE) {
/* 24 */     String str = (new StringBuilder()).append(paramE).append(CoreConstants.LINE_SEPARATOR).toString();
/* 25 */     return str.getBytes();
/*    */   }
/*    */   
/*    */   public byte[] footerBytes() {
/* 29 */     if (this.fileFooter == null) {
/* 30 */       return null;
/*    */     }
/* 32 */     return this.fileFooter.getBytes();
/*    */   }
/*    */   
/*    */   public byte[] headerBytes() {
/* 36 */     if (this.fileHeader == null) {
/* 37 */       return null;
/*    */     }
/* 39 */     return this.fileHeader.getBytes();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\encoder\EchoEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */