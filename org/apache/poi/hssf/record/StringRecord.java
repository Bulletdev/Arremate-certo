/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.hssf.record.cont.ContinuableRecord;
/*    */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*    */ import org.apache.poi.util.StringUtil;
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
/*    */ 
/*    */ 
/*    */ public final class StringRecord
/*    */   extends ContinuableRecord
/*    */ {
/*    */   public static final short sid = 519;
/*    */   private boolean _is16bitUnicode;
/*    */   private String _text;
/*    */   
/*    */   public StringRecord() {}
/*    */   
/*    */   public StringRecord(RecordInputStream paramRecordInputStream) {
/* 45 */     int i = paramRecordInputStream.readUShort();
/* 46 */     this._is16bitUnicode = (paramRecordInputStream.readByte() != 0);
/*    */     
/* 48 */     if (this._is16bitUnicode) {
/* 49 */       this._text = paramRecordInputStream.readUnicodeLEString(i);
/*    */     } else {
/* 51 */       this._text = paramRecordInputStream.readCompressedUnicode(i);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 57 */     paramContinuableRecordOutput.writeShort(this._text.length());
/* 58 */     paramContinuableRecordOutput.writeStringData(this._text);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 64 */     return 519;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getString() {
/* 72 */     return this._text;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setString(String paramString) {
/* 80 */     this._text = paramString;
/* 81 */     this._is16bitUnicode = StringUtil.hasMultibyte(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 86 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 88 */     stringBuffer.append("[STRING]\n");
/* 89 */     stringBuffer.append("    .string            = ").append(this._text).append("\n");
/*    */     
/* 91 */     stringBuffer.append("[/STRING]\n");
/* 92 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public Object clone() {
/* 96 */     StringRecord stringRecord = new StringRecord();
/* 97 */     stringRecord._is16bitUnicode = this._is16bitUnicode;
/* 98 */     stringRecord._text = this._text;
/* 99 */     return stringRecord;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\StringRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */