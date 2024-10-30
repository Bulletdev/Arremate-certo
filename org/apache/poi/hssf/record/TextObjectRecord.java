/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecord;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*     */ import org.apache.poi.hssf.usermodel.HSSFRichTextString;
/*     */ import org.apache.poi.ss.formula.ptg.OperandPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
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
/*     */ 
/*     */ public final class TextObjectRecord
/*     */   extends ContinuableRecord
/*     */ {
/*     */   public static final short sid = 438;
/*     */   private static final int FORMAT_RUN_ENCODED_SIZE = 8;
/*  40 */   private static final BitField HorizontalTextAlignment = BitFieldFactory.getInstance(14);
/*  41 */   private static final BitField VerticalTextAlignment = BitFieldFactory.getInstance(112);
/*  42 */   private static final BitField textLocked = BitFieldFactory.getInstance(512);
/*     */   
/*     */   public static final short HORIZONTAL_TEXT_ALIGNMENT_LEFT_ALIGNED = 1;
/*     */   
/*     */   public static final short HORIZONTAL_TEXT_ALIGNMENT_CENTERED = 2;
/*     */   
/*     */   public static final short HORIZONTAL_TEXT_ALIGNMENT_RIGHT_ALIGNED = 3;
/*     */   
/*     */   public static final short HORIZONTAL_TEXT_ALIGNMENT_JUSTIFIED = 4;
/*     */   
/*     */   public static final short VERTICAL_TEXT_ALIGNMENT_TOP = 1;
/*     */   
/*     */   public static final short VERTICAL_TEXT_ALIGNMENT_CENTER = 2;
/*     */   
/*     */   public static final short VERTICAL_TEXT_ALIGNMENT_BOTTOM = 3;
/*     */   
/*     */   public static final short VERTICAL_TEXT_ALIGNMENT_JUSTIFY = 4;
/*     */   
/*     */   public static final short TEXT_ORIENTATION_NONE = 0;
/*     */   
/*     */   public static final short TEXT_ORIENTATION_TOP_TO_BOTTOM = 1;
/*     */   
/*     */   public static final short TEXT_ORIENTATION_ROT_RIGHT = 2;
/*     */   
/*     */   public static final short TEXT_ORIENTATION_ROT_LEFT = 3;
/*     */   
/*     */   private int field_1_options;
/*     */   
/*     */   private int field_2_textOrientation;
/*     */   
/*     */   private int field_3_reserved4;
/*     */   
/*     */   private int field_4_reserved5;
/*     */   
/*     */   private int field_5_reserved6;
/*     */   private int field_8_reserved7;
/*     */   private HSSFRichTextString _text;
/*     */   private int _unknownPreFormulaInt;
/*     */   private OperandPtg _linkRefPtg;
/*     */   private Byte _unknownPostFormulaByte;
/*     */   
/*     */   public TextObjectRecord() {}
/*     */   
/*     */   public TextObjectRecord(RecordInputStream paramRecordInputStream) {
/*     */     String str;
/*  87 */     this.field_1_options = paramRecordInputStream.readUShort();
/*  88 */     this.field_2_textOrientation = paramRecordInputStream.readUShort();
/*  89 */     this.field_3_reserved4 = paramRecordInputStream.readUShort();
/*  90 */     this.field_4_reserved5 = paramRecordInputStream.readUShort();
/*  91 */     this.field_5_reserved6 = paramRecordInputStream.readUShort();
/*  92 */     int i = paramRecordInputStream.readUShort();
/*  93 */     int j = paramRecordInputStream.readUShort();
/*  94 */     this.field_8_reserved7 = paramRecordInputStream.readInt();
/*     */     
/*  96 */     if (paramRecordInputStream.remaining() > 0) {
/*     */ 
/*     */       
/*  99 */       if (paramRecordInputStream.remaining() < 11) {
/* 100 */         throw new RecordFormatException("Not enough remaining data for a link formula");
/*     */       }
/* 102 */       int k = paramRecordInputStream.readUShort();
/* 103 */       this._unknownPreFormulaInt = paramRecordInputStream.readInt();
/* 104 */       Ptg[] arrayOfPtg = Ptg.readTokens(k, paramRecordInputStream);
/* 105 */       if (arrayOfPtg.length != 1) {
/* 106 */         throw new RecordFormatException("Read " + arrayOfPtg.length + " tokens but expected exactly 1");
/*     */       }
/*     */       
/* 109 */       this._linkRefPtg = (OperandPtg)arrayOfPtg[0];
/* 110 */       if (paramRecordInputStream.remaining() > 0) {
/* 111 */         this._unknownPostFormulaByte = Byte.valueOf(paramRecordInputStream.readByte());
/*     */       } else {
/* 113 */         this._unknownPostFormulaByte = null;
/*     */       } 
/*     */     } else {
/* 116 */       this._linkRefPtg = null;
/*     */     } 
/* 118 */     if (paramRecordInputStream.remaining() > 0) {
/* 119 */       throw new RecordFormatException("Unused " + paramRecordInputStream.remaining() + " bytes at end of record");
/*     */     }
/*     */ 
/*     */     
/* 123 */     if (i > 0) {
/* 124 */       str = readRawString(paramRecordInputStream, i);
/*     */     } else {
/* 126 */       str = "";
/*     */     } 
/* 128 */     this._text = new HSSFRichTextString(str);
/*     */     
/* 130 */     if (j > 0) {
/* 131 */       processFontRuns(paramRecordInputStream, this._text, j);
/*     */     }
/*     */   }
/*     */   
/*     */   private static String readRawString(RecordInputStream paramRecordInputStream, int paramInt) {
/* 136 */     byte b = paramRecordInputStream.readByte();
/* 137 */     boolean bool = ((b & 0x1) == 0) ? true : false;
/* 138 */     if (bool) {
/* 139 */       return paramRecordInputStream.readCompressedUnicode(paramInt);
/*     */     }
/* 141 */     return paramRecordInputStream.readUnicodeLEString(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void processFontRuns(RecordInputStream paramRecordInputStream, HSSFRichTextString paramHSSFRichTextString, int paramInt) {
/* 146 */     if (paramInt % 8 != 0) {
/* 147 */       throw new RecordFormatException("Bad format run data length " + paramInt + ")");
/*     */     }
/*     */     
/* 150 */     int i = paramInt / 8;
/* 151 */     for (byte b = 0; b < i; b++) {
/* 152 */       short s1 = paramRecordInputStream.readShort();
/* 153 */       short s2 = paramRecordInputStream.readShort();
/* 154 */       paramRecordInputStream.readInt();
/* 155 */       paramHSSFRichTextString.applyFont(s1, paramHSSFRichTextString.length(), s2);
/*     */     } 
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 160 */     return 438;
/*     */   }
/*     */ 
/*     */   
/*     */   private void serializeTXORecord(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 165 */     paramContinuableRecordOutput.writeShort(this.field_1_options);
/* 166 */     paramContinuableRecordOutput.writeShort(this.field_2_textOrientation);
/* 167 */     paramContinuableRecordOutput.writeShort(this.field_3_reserved4);
/* 168 */     paramContinuableRecordOutput.writeShort(this.field_4_reserved5);
/* 169 */     paramContinuableRecordOutput.writeShort(this.field_5_reserved6);
/* 170 */     paramContinuableRecordOutput.writeShort(this._text.length());
/* 171 */     paramContinuableRecordOutput.writeShort(getFormattingDataLength());
/* 172 */     paramContinuableRecordOutput.writeInt(this.field_8_reserved7);
/*     */     
/* 174 */     if (this._linkRefPtg != null) {
/* 175 */       int i = this._linkRefPtg.getSize();
/* 176 */       paramContinuableRecordOutput.writeShort(i);
/* 177 */       paramContinuableRecordOutput.writeInt(this._unknownPreFormulaInt);
/* 178 */       this._linkRefPtg.write((LittleEndianOutput)paramContinuableRecordOutput);
/* 179 */       if (this._unknownPostFormulaByte != null) {
/* 180 */         paramContinuableRecordOutput.writeByte(this._unknownPostFormulaByte.byteValue());
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void serializeTrailingRecords(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 186 */     paramContinuableRecordOutput.writeContinue();
/* 187 */     paramContinuableRecordOutput.writeStringData(this._text.getString());
/* 188 */     paramContinuableRecordOutput.writeContinue();
/* 189 */     writeFormatData(paramContinuableRecordOutput, this._text);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 194 */     serializeTXORecord(paramContinuableRecordOutput);
/* 195 */     if (this._text.getString().length() > 0) {
/* 196 */       serializeTrailingRecords(paramContinuableRecordOutput);
/*     */     }
/*     */   }
/*     */   
/*     */   private int getFormattingDataLength() {
/* 201 */     if (this._text.length() < 1)
/*     */     {
/* 203 */       return 0;
/*     */     }
/* 205 */     return (this._text.numFormattingRuns() + 1) * 8;
/*     */   }
/*     */   
/*     */   private static void writeFormatData(ContinuableRecordOutput paramContinuableRecordOutput, HSSFRichTextString paramHSSFRichTextString) {
/* 209 */     int i = paramHSSFRichTextString.numFormattingRuns();
/* 210 */     for (byte b = 0; b < i; b++) {
/* 211 */       paramContinuableRecordOutput.writeShort(paramHSSFRichTextString.getIndexOfFormattingRun(b));
/* 212 */       short s = paramHSSFRichTextString.getFontOfFormattingRun(b);
/* 213 */       paramContinuableRecordOutput.writeShort((s == 0) ? 0 : s);
/* 214 */       paramContinuableRecordOutput.writeInt(0);
/*     */     } 
/* 216 */     paramContinuableRecordOutput.writeShort(paramHSSFRichTextString.length());
/* 217 */     paramContinuableRecordOutput.writeShort(0);
/* 218 */     paramContinuableRecordOutput.writeInt(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHorizontalTextAlignment(int paramInt) {
/* 225 */     this.field_1_options = HorizontalTextAlignment.setValue(this.field_1_options, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHorizontalTextAlignment() {
/* 232 */     return HorizontalTextAlignment.getValue(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVerticalTextAlignment(int paramInt) {
/* 239 */     this.field_1_options = VerticalTextAlignment.setValue(this.field_1_options, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVerticalTextAlignment() {
/* 246 */     return VerticalTextAlignment.getValue(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextLocked(boolean paramBoolean) {
/* 253 */     this.field_1_options = textLocked.setBoolean(this.field_1_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTextLocked() {
/* 260 */     return textLocked.isSet(this.field_1_options);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTextOrientation() {
/* 270 */     return this.field_2_textOrientation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTextOrientation(int paramInt) {
/* 281 */     this.field_2_textOrientation = paramInt;
/*     */   }
/*     */   
/*     */   public HSSFRichTextString getStr() {
/* 285 */     return this._text;
/*     */   }
/*     */   
/*     */   public void setStr(HSSFRichTextString paramHSSFRichTextString) {
/* 289 */     this._text = paramHSSFRichTextString;
/*     */   }
/*     */   
/*     */   public Ptg getLinkRefPtg() {
/* 293 */     return (Ptg)this._linkRefPtg;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 297 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 299 */     stringBuffer.append("[TXO]\n");
/* 300 */     stringBuffer.append("    .options        = ").append(HexDump.shortToHex(this.field_1_options)).append("\n");
/* 301 */     stringBuffer.append("         .isHorizontal = ").append(getHorizontalTextAlignment()).append('\n');
/* 302 */     stringBuffer.append("         .isVertical   = ").append(getVerticalTextAlignment()).append('\n');
/* 303 */     stringBuffer.append("         .textLocked   = ").append(isTextLocked()).append('\n');
/* 304 */     stringBuffer.append("    .textOrientation= ").append(HexDump.shortToHex(getTextOrientation())).append("\n");
/* 305 */     stringBuffer.append("    .reserved4      = ").append(HexDump.shortToHex(this.field_3_reserved4)).append("\n");
/* 306 */     stringBuffer.append("    .reserved5      = ").append(HexDump.shortToHex(this.field_4_reserved5)).append("\n");
/* 307 */     stringBuffer.append("    .reserved6      = ").append(HexDump.shortToHex(this.field_5_reserved6)).append("\n");
/* 308 */     stringBuffer.append("    .textLength     = ").append(HexDump.shortToHex(this._text.length())).append("\n");
/* 309 */     stringBuffer.append("    .reserved7      = ").append(HexDump.intToHex(this.field_8_reserved7)).append("\n");
/*     */     
/* 311 */     stringBuffer.append("    .string = ").append(this._text).append('\n');
/*     */     
/* 313 */     for (byte b = 0; b < this._text.numFormattingRuns(); b++) {
/* 314 */       stringBuffer.append("    .textrun = ").append(this._text.getFontOfFormattingRun(b)).append('\n');
/*     */     }
/*     */     
/* 317 */     stringBuffer.append("[/TXO]\n");
/* 318 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object clone() {
/* 323 */     TextObjectRecord textObjectRecord = new TextObjectRecord();
/* 324 */     textObjectRecord._text = this._text;
/*     */     
/* 326 */     textObjectRecord.field_1_options = this.field_1_options;
/* 327 */     textObjectRecord.field_2_textOrientation = this.field_2_textOrientation;
/* 328 */     textObjectRecord.field_3_reserved4 = this.field_3_reserved4;
/* 329 */     textObjectRecord.field_4_reserved5 = this.field_4_reserved5;
/* 330 */     textObjectRecord.field_5_reserved6 = this.field_5_reserved6;
/* 331 */     textObjectRecord.field_8_reserved7 = this.field_8_reserved7;
/*     */     
/* 333 */     textObjectRecord._text = this._text;
/*     */     
/* 335 */     if (this._linkRefPtg != null) {
/* 336 */       textObjectRecord._unknownPreFormulaInt = this._unknownPreFormulaInt;
/* 337 */       textObjectRecord._linkRefPtg = this._linkRefPtg.copy();
/* 338 */       textObjectRecord._unknownPostFormulaByte = this._unknownPostFormulaByte;
/*     */     } 
/* 340 */     return textObjectRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\TextObjectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */