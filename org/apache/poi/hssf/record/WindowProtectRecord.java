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
/*    */ public final class WindowProtectRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 25;
/* 33 */   private static final BitField settingsProtectedFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   public WindowProtectRecord(int paramInt) {
/* 38 */     this._options = paramInt;
/*    */   }
/*    */   
/*    */   public WindowProtectRecord(RecordInputStream paramRecordInputStream) {
/* 42 */     this(paramRecordInputStream.readUShort());
/*    */   }
/*    */   
/*    */   public WindowProtectRecord(boolean paramBoolean) {
/* 46 */     this(0);
/* 47 */     setProtect(paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setProtect(boolean paramBoolean) {
/* 55 */     this._options = settingsProtectedFlag.setBoolean(this._options, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getProtect() {
/* 64 */     return settingsProtectedFlag.isSet(this._options);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 68 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 70 */     stringBuffer.append("[WINDOWPROTECT]\n");
/* 71 */     stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 72 */     stringBuffer.append("[/WINDOWPROTECT]\n");
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
/*    */   
/*    */   public short getSid() {
/* 86 */     return 25;
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 90 */     return new WindowProtectRecord(this._options);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\WindowProtectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */