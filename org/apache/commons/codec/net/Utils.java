/*    */ package org.apache.commons.codec.net;
/*    */ 
/*    */ import org.apache.commons.codec.DecoderException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ class Utils
/*    */ {
/*    */   private static final int RADIX = 16;
/*    */   
/*    */   static int digit16(byte paramByte) throws DecoderException {
/* 47 */     int i = Character.digit((char)paramByte, 16);
/* 48 */     if (i == -1) {
/* 49 */       throw new DecoderException("Invalid URL encoding: not a valid digit (radix 16): " + paramByte);
/*    */     }
/* 51 */     return i;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static char hexDigit(int paramInt) {
/* 61 */     return Character.toUpperCase(Character.forDigit(paramInt & 0xF, 16));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\net\Utils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */