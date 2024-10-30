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
/*    */ public final class DSFRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 353;
/* 34 */   private static final BitField biff5BookStreamFlag = BitFieldFactory.getInstance(1);
/*    */   
/*    */   private int _options;
/*    */   
/*    */   private DSFRecord(int paramInt) {
/* 39 */     this._options = paramInt;
/*    */   }
/*    */   public DSFRecord(boolean paramBoolean) {
/* 42 */     this(0);
/* 43 */     this._options = biff5BookStreamFlag.setBoolean(0, paramBoolean);
/*    */   }
/*    */   
/*    */   public DSFRecord(RecordInputStream paramRecordInputStream) {
/* 47 */     this(paramRecordInputStream.readShort());
/*    */   }
/*    */   
/*    */   public boolean isBiff5BookStreamPresent() {
/* 51 */     return biff5BookStreamFlag.isSet(this._options);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 55 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 57 */     stringBuffer.append("[DSF]\n");
/* 58 */     stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
/* 59 */     stringBuffer.append("[/DSF]\n");
/* 60 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 64 */     paramLittleEndianOutput.writeShort(this._options);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 68 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 72 */     return 353;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DSFRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */