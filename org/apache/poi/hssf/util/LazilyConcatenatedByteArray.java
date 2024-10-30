/*    */ package org.apache.poi.hssf.util;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
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
/*    */ public class LazilyConcatenatedByteArray
/*    */ {
/* 29 */   private final List<byte[]> arrays = (List)new ArrayList<byte>(1);
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear() {
/* 35 */     this.arrays.clear();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void concatenate(byte[] paramArrayOfbyte) {
/* 46 */     if (paramArrayOfbyte == null) {
/* 47 */       throw new IllegalArgumentException("array cannot be null");
/*    */     }
/* 49 */     this.arrays.add(paramArrayOfbyte);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public byte[] toArray() {
/* 61 */     if (this.arrays.isEmpty())
/* 62 */       return null; 
/* 63 */     if (this.arrays.size() > 1) {
/* 64 */       int i = 0;
/* 65 */       for (byte[] arrayOfByte1 : this.arrays) {
/* 66 */         i += arrayOfByte1.length;
/*    */       }
/*    */       
/* 69 */       byte[] arrayOfByte = new byte[i];
/* 70 */       int j = 0;
/* 71 */       for (byte[] arrayOfByte1 : this.arrays) {
/* 72 */         System.arraycopy(arrayOfByte1, 0, arrayOfByte, j, arrayOfByte1.length);
/* 73 */         j += arrayOfByte1.length;
/*    */       } 
/*    */       
/* 76 */       this.arrays.clear();
/* 77 */       this.arrays.add(arrayOfByte);
/*    */     } 
/*    */     
/* 80 */     return this.arrays.get(0);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hss\\util\LazilyConcatenatedByteArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */