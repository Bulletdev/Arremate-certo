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
/*    */ public final class ProtectRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 18;
/* 35 */   private static final BitField protectFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   private ProtectRecord(int paramInt) {
/* 40 */     this._options = paramInt;
/*    */   }
/*    */   
/*    */   public ProtectRecord(boolean paramBoolean) {
/* 44 */     this(0);
/* 45 */     setProtect(paramBoolean);
/*    */   }
/*    */   
/*    */   public ProtectRecord(RecordInputStream paramRecordInputStream) {
/* 49 */     this(paramRecordInputStream.readShort());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setProtect(boolean paramBoolean) {
/* 57 */     this._options = protectFlag.setBoolean(this._options, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getProtect() {
/* 65 */     return protectFlag.isSet(this._options);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 69 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 71 */     stringBuffer.append("[PROTECT]\n");
/* 72 */     stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 73 */     stringBuffer.append("[/PROTECT]\n");
/* 74 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 78 */     paramLittleEndianOutput.writeShort(this._options);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 82 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 86 */     return 18;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 90 */     return new ProtectRecord(this._options);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ProtectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */