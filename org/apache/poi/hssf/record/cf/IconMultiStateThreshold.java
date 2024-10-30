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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class IconMultiStateThreshold
/*    */   extends Threshold
/*    */   implements Cloneable
/*    */ {
/*    */   public static final byte EQUALS_EXCLUDE = 0;
/*    */   public static final byte EQUALS_INCLUDE = 1;
/*    */   private byte equals;
/*    */   
/*    */   public IconMultiStateThreshold() {
/* 41 */     this.equals = 1;
/*    */   }
/*    */ 
/*    */   
/*    */   public IconMultiStateThreshold(LittleEndianInput paramLittleEndianInput) {
/* 46 */     super(paramLittleEndianInput);
/* 47 */     this.equals = paramLittleEndianInput.readByte();
/*    */     
/* 49 */     paramLittleEndianInput.readInt();
/*    */   }
/*    */   
/*    */   public byte getEquals() {
/* 53 */     return this.equals;
/*    */   }
/*    */   public void setEquals(byte paramByte) {
/* 56 */     this.equals = paramByte;
/*    */   }
/*    */   
/*    */   public int getDataLength() {
/* 60 */     return super.getDataLength() + 5;
/*    */   }
/*    */ 
/*    */   
/*    */   public IconMultiStateThreshold clone() {
/* 65 */     IconMultiStateThreshold iconMultiStateThreshold = new IconMultiStateThreshold();
/* 66 */     copyTo(iconMultiStateThreshold);
/* 67 */     iconMultiStateThreshold.equals = this.equals;
/* 68 */     return iconMultiStateThreshold;
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 72 */     super.serialize(paramLittleEndianOutput);
/* 73 */     paramLittleEndianOutput.writeByte(this.equals);
/* 74 */     paramLittleEndianOutput.writeInt(0);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\cf\IconMultiStateThreshold.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */