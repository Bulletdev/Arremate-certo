/*    */ package org.apache.commons.codec;
/*    */ 
/*    */ import java.util.Comparator;
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
/*    */ public class StringEncoderComparator
/*    */   implements Comparator
/*    */ {
/*    */   private final StringEncoder stringEncoder;
/*    */   
/*    */   @Deprecated
/*    */   public StringEncoderComparator() {
/* 47 */     this.stringEncoder = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public StringEncoderComparator(StringEncoder paramStringEncoder) {
/* 57 */     this.stringEncoder = paramStringEncoder;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int compare(Object paramObject1, Object paramObject2) {
/* 76 */     int i = 0;
/*    */ 
/*    */ 
/*    */     
/*    */     try {
/* 81 */       Comparable<Comparable> comparable = (Comparable)this.stringEncoder.encode(paramObject1);
/* 82 */       Comparable comparable1 = (Comparable)this.stringEncoder.encode(paramObject2);
/* 83 */       i = comparable.compareTo(comparable1);
/* 84 */     } catch (EncoderException encoderException) {
/* 85 */       i = 0;
/*    */     } 
/* 87 */     return i;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\StringEncoderComparator.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */