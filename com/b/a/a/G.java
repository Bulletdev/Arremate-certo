/*    */ package com.b.a.a;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.util.zip.Deflater;
/*    */ import java.util.zip.DeflaterOutputStream;
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
/*    */ class g
/*    */ {
/*    */   public static byte[] a(byte[] paramArrayOfbyte) throws IOException {
/* 34 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*    */ 
/*    */     
/* 37 */     Deflater deflater = a();
/* 38 */     DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 46 */     deflaterOutputStream.write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/* 47 */     deflaterOutputStream.close();
/*    */ 
/*    */     
/* 50 */     deflater.end();
/*    */ 
/*    */     
/* 53 */     return byteArrayOutputStream.toByteArray();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static Deflater a() {
/* 61 */     return new Deflater(-1, true);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\b\a\a\g.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */