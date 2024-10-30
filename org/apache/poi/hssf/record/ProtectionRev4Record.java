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
/*    */ public final class ProtectionRev4Record
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 431;
/* 33 */   private static final BitField protectedFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   private ProtectionRev4Record(int paramInt) {
/* 38 */     this._options = paramInt;
/*    */   }
/*    */   
/*    */   public ProtectionRev4Record(boolean paramBoolean) {
/* 42 */     this(0);
/* 43 */     setProtect(paramBoolean);
/*    */   }
/*    */   
/*    */   public ProtectionRev4Record(RecordInputStream paramRecordInputStream) {
/* 47 */     this(paramRecordInputStream.readUShort());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setProtect(boolean paramBoolean) {
/* 55 */     this._options = protectedFlag.setBoolean(this._options, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean getProtect() {
/* 63 */     return protectedFlag.isSet(this._options);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 67 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 69 */     stringBuffer.append("[PROT4REV]\n");
/* 70 */     stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 71 */     stringBuffer.append("[/PROT4REV]\n");
/* 72 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 76 */     paramLittleEndianOutput.writeShort(this._options);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 80 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 84 */     return 431;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ProtectionRev4Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */