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
/*    */ public final class RefreshAllRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 439;
/* 34 */   private static final BitField refreshFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   private RefreshAllRecord(int paramInt) {
/* 39 */     this._options = paramInt;
/*    */   }
/*    */   
/*    */   public RefreshAllRecord(RecordInputStream paramRecordInputStream) {
/* 43 */     this(paramRecordInputStream.readUShort());
/*    */   }
/*    */   
/*    */   public RefreshAllRecord(boolean paramBoolean) {
/* 47 */     this(0);
/* 48 */     setRefreshAll(paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRefreshAll(boolean paramBoolean) {
/* 56 */     this._options = refreshFlag.setBoolean(this._options, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getRefreshAll() {
/* 64 */     return refreshFlag.isSet(this._options);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 70 */     stringBuffer.append("[REFRESHALL]\n");
/* 71 */     stringBuffer.append("    .options      = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 72 */     stringBuffer.append("[/REFRESHALL]\n");
/* 73 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 77 */     paramLittleEndianOutput.writeShort(this._options);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 81 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 85 */     return 439;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 89 */     return new RefreshAllRecord(this._options);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RefreshAllRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */