/*    */ package org.apache.commons.codec.digest;
/*    */ 
/*    */ import java.security.SecureRandom;
/*    */ import java.util.Random;
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
/*    */ class B64
/*    */ {
/*    */   static final String B64T_STRING = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
/* 43 */   static final char[] B64T_ARRAY = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
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
/*    */   static void b64from24bit(byte paramByte1, byte paramByte2, byte paramByte3, int paramInt, StringBuilder paramStringBuilder) {
/* 62 */     int i = paramByte1 << 16 & 0xFFFFFF | paramByte2 << 8 & 0xFFFF | paramByte3 & 0xFF;
/*    */     
/* 64 */     int j = paramInt;
/* 65 */     while (j-- > 0) {
/* 66 */       paramStringBuilder.append(B64T_ARRAY[i & 0x3F]);
/* 67 */       i >>= 6;
/*    */     } 
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
/*    */   
/*    */   static String getRandomSalt(int paramInt) {
/* 81 */     return getRandomSalt(paramInt, new SecureRandom());
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
/*    */ 
/*    */   
/*    */   static String getRandomSalt(int paramInt, Random paramRandom) {
/* 95 */     StringBuilder stringBuilder = new StringBuilder(paramInt);
/* 96 */     for (byte b = 1; b <= paramInt; b++) {
/* 97 */       stringBuilder.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(paramRandom.nextInt("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
/*    */     }
/* 99 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\digest\B64.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */