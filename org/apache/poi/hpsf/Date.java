/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import org.apache.poi.util.Internal;
/*    */ import org.apache.poi.util.LittleEndian;
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
/*    */ @Internal
/*    */ class Date
/*    */ {
/*    */   static final int SIZE = 8;
/*    */   private byte[] _value;
/*    */   
/*    */   Date(byte[] paramArrayOfbyte, int paramInt) {
/* 31 */     this._value = LittleEndian.getByteArray(paramArrayOfbyte, paramInt, 8);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Date.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */