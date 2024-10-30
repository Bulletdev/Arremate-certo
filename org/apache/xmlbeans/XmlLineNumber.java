/*    */ package org.apache.xmlbeans;
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
/*    */ public class XmlLineNumber
/*    */   extends XmlCursor.XmlBookmark
/*    */ {
/*    */   private int _line;
/*    */   private int _column;
/*    */   private int _offset;
/*    */   
/*    */   public XmlLineNumber(int paramInt) {
/* 34 */     this(paramInt, -1, -1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XmlLineNumber(int paramInt1, int paramInt2) {
/* 41 */     this(paramInt1, paramInt2, -1);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public XmlLineNumber(int paramInt1, int paramInt2, int paramInt3) {
/* 51 */     super(false);
/*    */     
/* 53 */     this._line = paramInt1;
/* 54 */     this._column = paramInt2;
/* 55 */     this._offset = paramInt3;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getLine() {
/* 61 */     return this._line;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getColumn() {
/* 66 */     return this._column;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getOffset() {
/* 71 */     return this._offset;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlLineNumber.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */