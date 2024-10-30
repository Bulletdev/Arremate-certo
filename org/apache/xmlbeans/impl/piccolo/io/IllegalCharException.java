/*    */ package org.apache.xmlbeans.impl.piccolo.io;
/*    */ 
/*    */ import java.io.CharConversionException;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class IllegalCharException
/*    */   extends CharConversionException
/*    */ {
/*    */   protected int line;
/*    */   protected int column;
/*    */   
/*    */   public IllegalCharException(String paramString) {
/* 28 */     super(paramString);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\io\IllegalCharException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */