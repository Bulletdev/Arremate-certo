/*     */ package org.apache.poi.ss.util;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.ss.formula.SheetNameFormatter;
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
/*     */ public class CellRangeAddress
/*     */   extends CellRangeAddressBase
/*     */ {
/*     */   public static final int ENCODED_SIZE = 8;
/*     */   
/*     */   public CellRangeAddress(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
/*  49 */     super(paramInt1, paramInt2, paramInt3, paramInt4);
/*     */     
/*  51 */     if (paramInt2 < paramInt1 || paramInt4 < paramInt3)
/*  52 */       throw new IllegalArgumentException("lastRow < firstRow || lastCol < firstCol"); 
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  56 */     paramLittleEndianOutput.writeShort(getFirstRow());
/*  57 */     paramLittleEndianOutput.writeShort(getLastRow());
/*  58 */     paramLittleEndianOutput.writeShort(getFirstColumn());
/*  59 */     paramLittleEndianOutput.writeShort(getLastColumn());
/*     */   }
/*     */   
/*     */   public CellRangeAddress(RecordInputStream paramRecordInputStream) {
/*  63 */     super(readUShortAndCheck(paramRecordInputStream), paramRecordInputStream.readUShort(), paramRecordInputStream.readUShort(), paramRecordInputStream.readUShort());
/*     */   }
/*     */   
/*     */   private static int readUShortAndCheck(RecordInputStream paramRecordInputStream) {
/*  67 */     if (paramRecordInputStream.remaining() < 8)
/*     */     {
/*  69 */       throw new RuntimeException("Ran out of data reading CellRangeAddress");
/*     */     }
/*  71 */     return paramRecordInputStream.readUShort();
/*     */   }
/*     */   
/*     */   public CellRangeAddress copy() {
/*  75 */     return new CellRangeAddress(getFirstRow(), getLastRow(), getFirstColumn(), getLastColumn());
/*     */   }
/*     */   
/*     */   public static int getEncodedSize(int paramInt) {
/*  79 */     return paramInt * 8;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatAsString() {
/*  87 */     return formatAsString((String)null, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatAsString(String paramString, boolean paramBoolean) {
/*  94 */     StringBuffer stringBuffer = new StringBuffer();
/*  95 */     if (paramString != null) {
/*  96 */       stringBuffer.append(SheetNameFormatter.format(paramString));
/*  97 */       stringBuffer.append("!");
/*     */     } 
/*  99 */     CellReference cellReference1 = new CellReference(getFirstRow(), getFirstColumn(), paramBoolean, paramBoolean);
/*     */     
/* 101 */     CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn(), paramBoolean, paramBoolean);
/*     */     
/* 103 */     stringBuffer.append(cellReference1.formatAsString());
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 108 */     if (!cellReference1.equals(cellReference2) || isFullColumnRange() || isFullRowRange()) {
/*     */       
/* 110 */       stringBuffer.append(':');
/* 111 */       stringBuffer.append(cellReference2.formatAsString());
/*     */     } 
/* 113 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CellRangeAddress valueOf(String paramString) {
/*     */     CellReference cellReference1, cellReference2;
/* 125 */     int i = paramString.indexOf(":");
/*     */ 
/*     */     
/* 128 */     if (i == -1) {
/* 129 */       cellReference1 = new CellReference(paramString);
/* 130 */       cellReference2 = cellReference1;
/*     */     } else {
/* 132 */       cellReference1 = new CellReference(paramString.substring(0, i));
/* 133 */       cellReference2 = new CellReference(paramString.substring(i + 1));
/*     */     } 
/* 135 */     return new CellRangeAddress(cellReference1.getRow(), cellReference2.getRow(), cellReference1.getCol(), cellReference2.getCol());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\util\CellRangeAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */