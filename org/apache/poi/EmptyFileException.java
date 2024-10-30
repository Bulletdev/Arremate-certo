/*    */ package org.apache.poi;
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
/*    */ public class EmptyFileException
/*    */   extends IllegalArgumentException
/*    */ {
/*    */   private static final long serialVersionUID = 1536449292174360166L;
/*    */   
/*    */   public EmptyFileException() {
/* 26 */     super("The supplied file was empty (zero bytes long)");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\EmptyFileException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */