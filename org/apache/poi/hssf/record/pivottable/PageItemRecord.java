/*     */ package org.apache.poi.hssf.record.pivottable;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordFormatException;
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PageItemRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 182;
/*     */   private final FieldInfo[] _fieldInfos;
/*     */   
/*     */   private static final class FieldInfo
/*     */   {
/*     */     public static final int ENCODED_SIZE = 6;
/*     */     private int _isxvi;
/*     */     private int _isxvd;
/*     */     private int _idObj;
/*     */     
/*     */     public FieldInfo(RecordInputStream param1RecordInputStream) {
/*  44 */       this._isxvi = param1RecordInputStream.readShort();
/*  45 */       this._isxvd = param1RecordInputStream.readShort();
/*  46 */       this._idObj = param1RecordInputStream.readShort();
/*     */     }
/*     */     
/*     */     protected void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  50 */       param1LittleEndianOutput.writeShort(this._isxvi);
/*  51 */       param1LittleEndianOutput.writeShort(this._isxvd);
/*  52 */       param1LittleEndianOutput.writeShort(this._idObj);
/*     */     }
/*     */     
/*     */     public void appendDebugInfo(StringBuffer param1StringBuffer) {
/*  56 */       param1StringBuffer.append('(');
/*  57 */       param1StringBuffer.append("isxvi=").append(HexDump.shortToHex(this._isxvi));
/*  58 */       param1StringBuffer.append(" isxvd=").append(HexDump.shortToHex(this._isxvd));
/*  59 */       param1StringBuffer.append(" idObj=").append(HexDump.shortToHex(this._idObj));
/*  60 */       param1StringBuffer.append(')');
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PageItemRecord(RecordInputStream paramRecordInputStream) {
/*  67 */     int i = paramRecordInputStream.remaining();
/*  68 */     if (i % 6 != 0) {
/*  69 */       throw new RecordFormatException("Bad data size " + i);
/*     */     }
/*     */     
/*  72 */     int j = i / 6;
/*     */     
/*  74 */     FieldInfo[] arrayOfFieldInfo = new FieldInfo[j];
/*  75 */     for (byte b = 0; b < arrayOfFieldInfo.length; b++) {
/*  76 */       arrayOfFieldInfo[b] = new FieldInfo(paramRecordInputStream);
/*     */     }
/*  78 */     this._fieldInfos = arrayOfFieldInfo;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  83 */     for (byte b = 0; b < this._fieldInfos.length; b++) {
/*  84 */       this._fieldInfos[b].serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/*  90 */     return this._fieldInfos.length * 6;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  95 */     return 182;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 100 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 102 */     stringBuffer.append("[SXPI]\n");
/* 103 */     for (byte b = 0; b < this._fieldInfos.length; b++) {
/* 104 */       stringBuffer.append("    item[").append(b).append("]=");
/* 105 */       this._fieldInfos[b].appendDebugInfo(stringBuffer);
/* 106 */       stringBuffer.append('\n');
/*     */     } 
/* 108 */     stringBuffer.append("[/SXPI]\n");
/* 109 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\pivottable\PageItemRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */