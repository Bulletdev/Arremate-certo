/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.ss.util.WorkbookUtil;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.StringUtil;
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
/*     */ public final class BoundSheetRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 133;
/*  41 */   private static final BitField hiddenFlag = BitFieldFactory.getInstance(1);
/*  42 */   private static final BitField veryHiddenFlag = BitFieldFactory.getInstance(2);
/*     */   private int field_1_position_of_BOF;
/*     */   private int field_2_option_flags;
/*     */   private int field_4_isMultibyteUnicode;
/*     */   private String field_5_sheetname;
/*     */   
/*     */   public BoundSheetRecord(String paramString) {
/*  49 */     this.field_2_option_flags = 0;
/*  50 */     setSheetname(paramString);
/*     */   }
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
/*     */   public BoundSheetRecord(RecordInputStream paramRecordInputStream) {
/*  63 */     this.field_1_position_of_BOF = paramRecordInputStream.readInt();
/*  64 */     this.field_2_option_flags = paramRecordInputStream.readUShort();
/*  65 */     int i = paramRecordInputStream.readUByte();
/*  66 */     this.field_4_isMultibyteUnicode = paramRecordInputStream.readByte();
/*     */     
/*  68 */     if (isMultibyte()) {
/*  69 */       this.field_5_sheetname = paramRecordInputStream.readUnicodeLEString(i);
/*     */     } else {
/*  71 */       this.field_5_sheetname = paramRecordInputStream.readCompressedUnicode(i);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPositionOfBof(int paramInt) {
/*  82 */     this.field_1_position_of_BOF = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetname(String paramString) {
/*  94 */     WorkbookUtil.validateSheetName(paramString);
/*  95 */     this.field_5_sheetname = paramString;
/*  96 */     this.field_4_isMultibyteUnicode = StringUtil.hasMultibyte(paramString) ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPositionOfBof() {
/* 105 */     return this.field_1_position_of_BOF;
/*     */   }
/*     */   
/*     */   private boolean isMultibyte() {
/* 109 */     return ((this.field_4_isMultibyteUnicode & 0x1) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSheetname() {
/* 117 */     return this.field_5_sheetname;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 123 */     stringBuffer.append("[BOUNDSHEET]\n");
/* 124 */     stringBuffer.append("    .bof        = ").append(HexDump.intToHex(getPositionOfBof())).append("\n");
/* 125 */     stringBuffer.append("    .options    = ").append(HexDump.shortToHex(this.field_2_option_flags)).append("\n");
/* 126 */     stringBuffer.append("    .unicodeflag= ").append(HexDump.byteToHex(this.field_4_isMultibyteUnicode)).append("\n");
/* 127 */     stringBuffer.append("    .sheetname  = ").append(this.field_5_sheetname).append("\n");
/* 128 */     stringBuffer.append("[/BOUNDSHEET]\n");
/* 129 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 133 */     return 8 + this.field_5_sheetname.length() * (isMultibyte() ? 2 : 1);
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 137 */     paramLittleEndianOutput.writeInt(getPositionOfBof());
/* 138 */     paramLittleEndianOutput.writeShort(this.field_2_option_flags);
/*     */     
/* 140 */     String str = this.field_5_sheetname;
/* 141 */     paramLittleEndianOutput.writeByte(str.length());
/* 142 */     paramLittleEndianOutput.writeByte(this.field_4_isMultibyteUnicode);
/*     */     
/* 144 */     if (isMultibyte()) {
/* 145 */       StringUtil.putUnicodeLE(str, paramLittleEndianOutput);
/*     */     } else {
/* 147 */       StringUtil.putCompressedUnicode(str, paramLittleEndianOutput);
/*     */     } 
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 152 */     return 133;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHidden() {
/* 161 */     return hiddenFlag.isSet(this.field_2_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHidden(boolean paramBoolean) {
/* 170 */     this.field_2_option_flags = hiddenFlag.setBoolean(this.field_2_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isVeryHidden() {
/* 179 */     return veryHiddenFlag.isSet(this.field_2_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVeryHidden(boolean paramBoolean) {
/* 188 */     this.field_2_option_flags = veryHiddenFlag.setBoolean(this.field_2_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BoundSheetRecord[] orderByBofPosition(List<BoundSheetRecord> paramList) {
/* 200 */     BoundSheetRecord[] arrayOfBoundSheetRecord = new BoundSheetRecord[paramList.size()];
/* 201 */     paramList.toArray(arrayOfBoundSheetRecord);
/* 202 */     Arrays.sort(arrayOfBoundSheetRecord, BOFComparator);
/* 203 */     return arrayOfBoundSheetRecord;
/*     */   }
/*     */   
/* 206 */   private static final Comparator<BoundSheetRecord> BOFComparator = new Comparator<BoundSheetRecord>()
/*     */     {
/*     */       public int compare(BoundSheetRecord param1BoundSheetRecord1, BoundSheetRecord param1BoundSheetRecord2) {
/* 209 */         return param1BoundSheetRecord1.getPositionOfBof() - param1BoundSheetRecord2.getPositionOfBof();
/*     */       }
/*     */     };
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BoundSheetRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */