/*    */ package org.apache.poi.hssf.record.cf;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianInput;
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
/*    */ public final class DataBarThreshold
/*    */   extends Threshold
/*    */   implements Cloneable
/*    */ {
/*    */   public DataBarThreshold() {}
/*    */   
/*    */   public DataBarThreshold(LittleEndianInput paramLittleEndianInput) {
/* 33 */     super(paramLittleEndianInput);
/*    */   }
/*    */ 
/*    */   
/*    */   public DataBarThreshold clone() {
/* 38 */     DataBarThreshold dataBarThreshold = new DataBarThreshold();
/* 39 */     copyTo(dataBarThreshold);
/* 40 */     return dataBarThreshold;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\DataBarThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */