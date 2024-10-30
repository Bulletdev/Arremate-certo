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
/*    */ 
/*    */ 
/*    */ 
/*    */ @Internal
/*    */ class Decimal
/*    */ {
/*    */   static final int SIZE = 16;
/*    */   private short field_1_wReserved;
/*    */   private byte field_2_scale;
/*    */   private byte field_3_sign;
/*    */   private int field_4_hi32;
/*    */   private long field_5_lo64;
/*    */   
/*    */   Decimal(byte[] paramArrayOfbyte, int paramInt) {
/* 38 */     int i = paramInt;
/*    */     
/* 40 */     this.field_1_wReserved = LittleEndian.getShort(paramArrayOfbyte, i);
/* 41 */     i += 2;
/*    */     
/* 43 */     this.field_2_scale = paramArrayOfbyte[i];
/* 44 */     i++;
/*    */     
/* 46 */     this.field_3_sign = paramArrayOfbyte[i];
/* 47 */     i++;
/*    */     
/* 49 */     this.field_4_hi32 = LittleEndian.getInt(paramArrayOfbyte, i);
/* 50 */     i += 4;
/*    */     
/* 52 */     this.field_5_lo64 = LittleEndian.getLong(paramArrayOfbyte, i);
/* 53 */     i += 8;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Decimal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */