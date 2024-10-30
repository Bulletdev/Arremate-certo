/*    */ package org.apache.http;
/*    */ 
/*    */ import java.nio.charset.CharacterCodingException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessageConstraintException
/*    */   extends CharacterCodingException
/*    */ {
/*    */   private static final long serialVersionUID = 6077207720446368695L;
/*    */   private final String message;
/*    */   
/*    */   public MessageConstraintException(String paramString) {
/* 49 */     this.message = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 54 */     return this.message;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\http\MessageConstraintException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */