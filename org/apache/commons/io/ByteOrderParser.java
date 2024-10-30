/*    */ package org.apache.commons.io;
/*    */ 
/*    */ import java.nio.ByteOrder;
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
/*    */ public final class ByteOrderParser
/*    */ {
/*    */   public static ByteOrder parseByteOrder(String paramString) {
/* 56 */     if (ByteOrder.BIG_ENDIAN.toString().equals(paramString)) {
/* 57 */       return ByteOrder.BIG_ENDIAN;
/*    */     }
/* 59 */     if (ByteOrder.LITTLE_ENDIAN.toString().equals(paramString)) {
/* 60 */       return ByteOrder.LITTLE_ENDIAN;
/*    */     }
/* 62 */     throw new IllegalArgumentException("Unsupported byte order setting: " + paramString + ", expected one of " + ByteOrder.LITTLE_ENDIAN + ", " + ByteOrder.BIG_ENDIAN);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\ByteOrderParser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */