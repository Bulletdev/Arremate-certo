/*    */ package org.apache.poi.hpsf;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
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
/*    */ 
/*    */ class Filetime
/*    */ {
/*    */   static final int SIZE = 8;
/*    */   private int _dwHighDateTime;
/*    */   private int _dwLowDateTime;
/*    */   
/*    */   Filetime(byte[] paramArrayOfbyte, int paramInt) {
/* 33 */     this._dwLowDateTime = LittleEndian.getInt(paramArrayOfbyte, paramInt + 0);
/*    */     
/* 35 */     this._dwHighDateTime = LittleEndian.getInt(paramArrayOfbyte, paramInt + 4);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   Filetime(int paramInt1, int paramInt2) {
/* 41 */     this._dwLowDateTime = paramInt1;
/* 42 */     this._dwHighDateTime = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   long getHigh() {
/* 47 */     return this._dwHighDateTime;
/*    */   }
/*    */ 
/*    */   
/*    */   long getLow() {
/* 52 */     return this._dwLowDateTime;
/*    */   }
/*    */ 
/*    */   
/*    */   byte[] toByteArray() {
/* 57 */     byte[] arrayOfByte = new byte[8];
/* 58 */     LittleEndian.putInt(arrayOfByte, 0, this._dwLowDateTime);
/* 59 */     LittleEndian.putInt(arrayOfByte, 4, this._dwHighDateTime);
/*    */     
/* 61 */     return arrayOfByte;
/*    */   }
/*    */ 
/*    */   
/*    */   int write(OutputStream paramOutputStream) throws IOException {
/* 66 */     LittleEndian.putInt(this._dwLowDateTime, paramOutputStream);
/* 67 */     LittleEndian.putInt(this._dwHighDateTime, paramOutputStream);
/* 68 */     return 8;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Filetime.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */