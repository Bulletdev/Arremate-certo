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
/*    */ public final class UseSelFSRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 352;
/* 34 */   private static final BitField useNaturalLanguageFormulasFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   private UseSelFSRecord(int paramInt) {
/* 39 */     this._options = paramInt;
/*    */   }
/*    */   
/*    */   public UseSelFSRecord(RecordInputStream paramRecordInputStream) {
/* 43 */     this(paramRecordInputStream.readUShort());
/*    */   }
/*    */   
/*    */   public UseSelFSRecord(boolean paramBoolean) {
/* 47 */     this(0);
/* 48 */     this._options = useNaturalLanguageFormulasFlag.setBoolean(this._options, paramBoolean);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 52 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 54 */     stringBuffer.append("[USESELFS]\n");
/* 55 */     stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 56 */     stringBuffer.append("[/USESELFS]\n");
/* 57 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 61 */     paramLittleEndianOutput.writeShort(this._options);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 65 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 69 */     return 352;
/*    */   }
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 74 */     return new UseSelFSRecord(this._options);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\UseSelFSRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */