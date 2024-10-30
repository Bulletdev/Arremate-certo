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
/*    */ class GUID
/*    */ {
/*    */   static final int SIZE = 16;
/*    */   private int _data1;
/*    */   private short _data2;
/*    */   private short _data3;
/*    */   private long _data4;
/*    */   
/*    */   GUID(byte[] paramArrayOfbyte, int paramInt) {
/* 34 */     this._data1 = LittleEndian.getInt(paramArrayOfbyte, paramInt + 0);
/* 35 */     this._data2 = LittleEndian.getShort(paramArrayOfbyte, paramInt + 4);
/* 36 */     this._data3 = LittleEndian.getShort(paramArrayOfbyte, paramInt + 6);
/* 37 */     this._data4 = LittleEndian.getLong(paramArrayOfbyte, paramInt + 8);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\GUID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */