/*    */ package org.apache.poi.hssf.record;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ public final class InterfaceHdrRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 225;
/*    */   private final int _codepage;
/*    */   public static final int CODEPAGE = 1200;
/*    */   
/*    */   public InterfaceHdrRecord(int paramInt) {
/* 39 */     this._codepage = paramInt;
/*    */   }
/*    */   
/*    */   public InterfaceHdrRecord(RecordInputStream paramRecordInputStream) {
/* 43 */     this._codepage = paramRecordInputStream.readShort();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 47 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 49 */     stringBuffer.append("[INTERFACEHDR]\n");
/* 50 */     stringBuffer.append("    .codepage = ").append(HexDump.shortToHex(this._codepage)).append("\n");
/* 51 */     stringBuffer.append("[/INTERFACEHDR]\n");
/* 52 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 56 */     paramLittleEndianOutput.writeShort(this._codepage);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 60 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 64 */     return 225;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\InterfaceHdrRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */