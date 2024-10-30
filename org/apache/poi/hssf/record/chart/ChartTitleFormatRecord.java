/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
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
/*     */ 
/*     */ public class ChartTitleFormatRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 4176;
/*     */   private CTFormat[] _formats;
/*     */   
/*     */   private static final class CTFormat
/*     */   {
/*     */     public static final int ENCODED_SIZE = 4;
/*     */     private int _offset;
/*     */     private int _fontIndex;
/*     */     
/*     */     public CTFormat(RecordInputStream param1RecordInputStream) {
/*  42 */       this._offset = param1RecordInputStream.readShort();
/*  43 */       this._fontIndex = param1RecordInputStream.readShort();
/*     */     }
/*     */     
/*     */     public int getOffset() {
/*  47 */       return this._offset;
/*     */     }
/*     */     public void setOffset(int param1Int) {
/*  50 */       this._offset = param1Int;
/*     */     }
/*     */     public int getFontIndex() {
/*  53 */       return this._fontIndex;
/*     */     }
/*     */     
/*     */     public void serialize(LittleEndianOutput param1LittleEndianOutput) {
/*  57 */       param1LittleEndianOutput.writeShort(this._offset);
/*  58 */       param1LittleEndianOutput.writeShort(this._fontIndex);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public ChartTitleFormatRecord(RecordInputStream paramRecordInputStream) {
/*  64 */     int i = paramRecordInputStream.readUShort();
/*  65 */     this._formats = new CTFormat[i];
/*     */     
/*  67 */     for (byte b = 0; b < i; b++) {
/*  68 */       this._formats[b] = new CTFormat(paramRecordInputStream);
/*     */     }
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  73 */     paramLittleEndianOutput.writeShort(this._formats.length);
/*  74 */     for (byte b = 0; b < this._formats.length; b++) {
/*  75 */       this._formats[b].serialize(paramLittleEndianOutput);
/*     */     }
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  80 */     return 2 + 4 * this._formats.length;
/*     */   }
/*     */   
/*     */   public short getSid() {
/*  84 */     return 4176;
/*     */   }
/*     */   
/*     */   public int getFormatCount() {
/*  88 */     return this._formats.length;
/*     */   }
/*     */   
/*     */   public void modifyFormatRun(short paramShort1, short paramShort2) {
/*  92 */     int i = 0;
/*  93 */     for (byte b = 0; b < this._formats.length; b++) {
/*  94 */       CTFormat cTFormat = this._formats[b];
/*  95 */       if (i) {
/*  96 */         cTFormat.setOffset(cTFormat.getOffset() + i);
/*  97 */       } else if (paramShort1 == cTFormat.getOffset() && b < this._formats.length - 1) {
/*  98 */         CTFormat cTFormat1 = this._formats[b + 1];
/*  99 */         i = paramShort2 - cTFormat1.getOffset() - cTFormat.getOffset();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 105 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 107 */     stringBuffer.append("[CHARTTITLEFORMAT]\n");
/* 108 */     stringBuffer.append("    .format_runs       = ").append(this._formats.length).append("\n");
/* 109 */     for (byte b = 0; b < this._formats.length; b++) {
/* 110 */       CTFormat cTFormat = this._formats[b];
/* 111 */       stringBuffer.append("       .char_offset= ").append(cTFormat.getOffset());
/* 112 */       stringBuffer.append(",.fontidx= ").append(cTFormat.getFontIndex());
/* 113 */       stringBuffer.append("\n");
/*     */     } 
/* 115 */     stringBuffer.append("[/CHARTTITLEFORMAT]\n");
/* 116 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\ChartTitleFormatRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */