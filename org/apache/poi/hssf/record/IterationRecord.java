/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.BitField;
/*    */ import org.apache.poi.util.BitFieldFactory;
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class IterationRecord
/*    */   extends StandardRecord
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 17;
/* 36 */   private static final BitField iterationOn = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _flags;
/*    */   
/*    */   public IterationRecord(boolean paramBoolean) {
/* 41 */     this._flags = iterationOn.setBoolean(0, paramBoolean);
/*    */   }
/*    */ 
/*    */   
/*    */   public IterationRecord(RecordInputStream paramRecordInputStream) {
/* 46 */     this._flags = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setIteration(boolean paramBoolean) {
/* 54 */     this._flags = iterationOn.setBoolean(this._flags, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getIteration() {
/* 63 */     return iterationOn.isSet(this._flags);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 69 */     stringBuffer.append("[ITERATION]\n");
/* 70 */     stringBuffer.append("    .flags      = ").append(HexDump.shortToHex(this._flags)).append("\n");
/* 71 */     stringBuffer.append("[/ITERATION]\n");
/* 72 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 76 */     paramLittleEndianOutput.writeShort(this._flags);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 80 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 84 */     return 17;
/*    */   }
/*    */ 
/*    */   
/*    */   public IterationRecord clone() {
/* 89 */     return new IterationRecord(getIteration());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\IterationRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */