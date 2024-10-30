/*    */ package ch.qos.logback.core.encoder;
/*    */ 
/*    */ import java.io.ByteArrayOutputStream;
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
/*    */ public class ByteArrayUtil
/*    */ {
/*    */   static void writeInt(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 22 */     for (byte b = 0; b < 4; b++) {
/* 23 */       int i = 24 - b * 8;
/* 24 */       paramArrayOfbyte[paramInt1 + b] = (byte)(paramInt2 >>> i);
/*    */     } 
/*    */   }
/*    */   
/*    */   static void writeInt(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt) {
/* 29 */     for (byte b = 0; b < 4; b++) {
/* 30 */       int i = 24 - b * 8;
/* 31 */       paramByteArrayOutputStream.write((byte)(paramInt >>> i));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   static int readInt(byte[] paramArrayOfbyte, int paramInt) {
/* 37 */     int i = 0;
/* 38 */     for (byte b = 0; b < 4; b++) {
/* 39 */       int j = 24 - b * 8;
/* 40 */       i += (paramArrayOfbyte[paramInt + b] & 0xFF) << j;
/*    */     } 
/* 42 */     return i;
/*    */   }
/*    */   
/*    */   public static String toHexString(byte[] paramArrayOfbyte) {
/* 46 */     StringBuilder stringBuilder = new StringBuilder();
/* 47 */     for (byte b : paramArrayOfbyte) {
/* 48 */       String str = Integer.toHexString(b & 0xFF);
/* 49 */       if (str.length() == 1) {
/* 50 */         stringBuilder.append('0');
/*    */       }
/* 52 */       stringBuilder.append(str);
/*    */     } 
/* 54 */     return stringBuilder.toString();
/*    */   }
/*    */   
/*    */   public static byte[] hexStringToByteArray(String paramString) {
/* 58 */     int i = paramString.length();
/* 59 */     byte[] arrayOfByte = new byte[i / 2];
/*    */     
/* 61 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 62 */       int j = b * 2;
/* 63 */       int k = Integer.parseInt(paramString.substring(j, j + 2), 16);
/* 64 */       byte b1 = (byte)(k & 0xFF);
/* 65 */       arrayOfByte[b] = b1;
/*    */     } 
/* 67 */     return arrayOfByte;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\encoder\ByteArrayUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */