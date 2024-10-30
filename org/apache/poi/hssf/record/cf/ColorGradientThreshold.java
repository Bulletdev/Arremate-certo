/*    */ package org.apache.poi.hssf.record.cf;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianInput;
/*    */ import org.apache.poi.util.LittleEndianOutput;
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
/*    */ public final class ColorGradientThreshold
/*    */   extends Threshold
/*    */   implements Cloneable
/*    */ {
/*    */   private double position;
/*    */   
/*    */   public ColorGradientThreshold() {
/* 32 */     this.position = 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public ColorGradientThreshold(LittleEndianInput paramLittleEndianInput) {
/* 37 */     super(paramLittleEndianInput);
/* 38 */     this.position = paramLittleEndianInput.readDouble();
/*    */   }
/*    */   
/*    */   public double getPosition() {
/* 42 */     return this.position;
/*    */   }
/*    */   public void setPosition(double paramDouble) {
/* 45 */     this.position = paramDouble;
/*    */   }
/*    */   
/*    */   public int getDataLength() {
/* 49 */     return super.getDataLength() + 8;
/*    */   }
/*    */ 
/*    */   
/*    */   public ColorGradientThreshold clone() {
/* 54 */     ColorGradientThreshold colorGradientThreshold = new ColorGradientThreshold();
/* 55 */     copyTo(colorGradientThreshold);
/* 56 */     colorGradientThreshold.position = this.position;
/* 57 */     return colorGradientThreshold;
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 61 */     super.serialize(paramLittleEndianOutput);
/* 62 */     paramLittleEndianOutput.writeDouble(this.position);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\ColorGradientThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */