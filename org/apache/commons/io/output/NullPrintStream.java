/*    */ package org.apache.commons.io.output;
/*    */ 
/*    */ import java.io.PrintStream;
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
/*    */ public class NullPrintStream
/*    */   extends PrintStream
/*    */ {
/* 35 */   public static final NullPrintStream NULL_PRINT_STREAM = new NullPrintStream();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public NullPrintStream() {
/* 42 */     super(NullOutputStream.NULL_OUTPUT_STREAM);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\output\NullPrintStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */