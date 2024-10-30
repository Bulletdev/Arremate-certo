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
/*    */ @Internal
/*    */ class Blob
/*    */ {
/*    */   private byte[] _value;
/*    */   
/*    */   Blob(byte[] paramArrayOfbyte, int paramInt) {
/* 29 */     int i = LittleEndian.getInt(paramArrayOfbyte, paramInt);
/*    */     
/* 31 */     if (i == 0) {
/*    */       
/* 33 */       this._value = new byte[0];
/*    */       
/*    */       return;
/*    */     } 
/* 37 */     this._value = LittleEndian.getByteArray(paramArrayOfbyte, paramInt + 4, i);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   int getSize() {
/* 43 */     return 4 + this._value.length;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Blob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */