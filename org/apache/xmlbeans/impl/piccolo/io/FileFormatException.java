/*    */ package org.apache.xmlbeans.impl.piccolo.io;
/*    */ 
/*    */ import java.io.IOException;
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
/*    */ public class FileFormatException
/*    */   extends IOException
/*    */ {
/*    */   protected int line;
/*    */   protected int column;
/*    */   
/*    */   public FileFormatException() {
/* 26 */     this(null);
/*    */   }
/*    */   
/*    */   public FileFormatException(String paramString) {
/* 30 */     this(paramString, -1, -1);
/*    */   }
/*    */   
/*    */   public FileFormatException(String paramString, int paramInt1, int paramInt2) {
/* 34 */     super(paramString);
/* 35 */     this.line = paramInt1;
/* 36 */     this.column = paramInt2;
/*    */   }
/*    */   
/*    */   public int getLine() {
/* 40 */     return this.line;
/*    */   }
/*    */   public int getColumn() {
/* 43 */     return this.column;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\io\FileFormatException.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */