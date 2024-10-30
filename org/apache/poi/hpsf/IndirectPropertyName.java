/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
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
/*    */ @Internal
/*    */ class IndirectPropertyName
/*    */ {
/*    */   private CodePageString _value;
/*    */   
/*    */   IndirectPropertyName(byte[] paramArrayOfbyte, int paramInt) {
/* 28 */     this._value = new CodePageString(paramArrayOfbyte, paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   int getSize() {
/* 33 */     return this._value.getSize();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\IndirectPropertyName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */