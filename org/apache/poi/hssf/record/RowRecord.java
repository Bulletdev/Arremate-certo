/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class RowRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 520;
/*     */   public static final int ENCODED_SIZE = 20;
/*     */   private static final int OPTION_BITS_ALWAYS_SET = 256;
/*     */   private int field_1_row_number;
/*     */   private int field_2_first_col;
/*     */   private int field_3_last_col;
/*     */   private short field_4_height;
/*     */   private short field_5_optimize;
/*     */   private short field_6_reserved;
/*     */   private int field_7_option_flags;
/*  50 */   private static final BitField outlineLevel = BitFieldFactory.getInstance(7);
/*     */   
/*  52 */   private static final BitField colapsed = BitFieldFactory.getInstance(16);
/*  53 */   private static final BitField zeroHeight = BitFieldFactory.getInstance(32);
/*  54 */   private static final BitField badFontHeight = BitFieldFactory.getInstance(64);
/*  55 */   private static final BitField formatted = BitFieldFactory.getInstance(128);
/*     */   
/*     */   private int field_8_option_flags;
/*     */   
/*  59 */   private static final BitField xfIndex = BitFieldFactory.getInstance(4095);
/*  60 */   private static final BitField topBorder = BitFieldFactory.getInstance(4096);
/*  61 */   private static final BitField bottomBorder = BitFieldFactory.getInstance(8192);
/*  62 */   private static final BitField phoeneticGuide = BitFieldFactory.getInstance(16384);
/*     */ 
/*     */   
/*     */   public RowRecord(int paramInt) {
/*  66 */     if (paramInt < 0) {
/*  67 */       throw new IllegalArgumentException("Invalid row number (" + paramInt + ")");
/*     */     }
/*  69 */     this.field_1_row_number = paramInt;
/*  70 */     this.field_4_height = 255;
/*  71 */     this.field_5_optimize = 0;
/*  72 */     this.field_6_reserved = 0;
/*  73 */     this.field_7_option_flags = 256;
/*     */     
/*  75 */     this.field_8_option_flags = 15;
/*  76 */     setEmpty();
/*     */   }
/*     */   
/*     */   public RowRecord(RecordInputStream paramRecordInputStream) {
/*  80 */     this.field_1_row_number = paramRecordInputStream.readUShort();
/*  81 */     if (this.field_1_row_number < 0) {
/*  82 */       throw new IllegalArgumentException("Invalid row number " + this.field_1_row_number + " found in InputStream");
/*     */     }
/*  84 */     this.field_2_first_col = paramRecordInputStream.readShort();
/*  85 */     this.field_3_last_col = paramRecordInputStream.readShort();
/*  86 */     this.field_4_height = paramRecordInputStream.readShort();
/*  87 */     this.field_5_optimize = paramRecordInputStream.readShort();
/*  88 */     this.field_6_reserved = paramRecordInputStream.readShort();
/*  89 */     this.field_7_option_flags = paramRecordInputStream.readShort();
/*  90 */     this.field_8_option_flags = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEmpty() {
/*  98 */     this.field_2_first_col = 0;
/*  99 */     this.field_3_last_col = 0;
/*     */   }
/*     */   public boolean isEmpty() {
/* 102 */     return ((this.field_2_first_col | this.field_3_last_col) == 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRowNumber(int paramInt) {
/* 110 */     this.field_1_row_number = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFirstCol(int paramInt) {
/* 118 */     this.field_2_first_col = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastCol(int paramInt) {
/* 125 */     this.field_3_last_col = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeight(short paramShort) {
/* 133 */     this.field_4_height = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptimize(short paramShort) {
/* 141 */     this.field_5_optimize = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOutlineLevel(short paramShort) {
/* 151 */     this.field_7_option_flags = outlineLevel.setValue(this.field_7_option_flags, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setColapsed(boolean paramBoolean) {
/* 159 */     this.field_7_option_flags = colapsed.setBoolean(this.field_7_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setZeroHeight(boolean paramBoolean) {
/* 167 */     this.field_7_option_flags = zeroHeight.setBoolean(this.field_7_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBadFontHeight(boolean paramBoolean) {
/* 175 */     this.field_7_option_flags = badFontHeight.setBoolean(this.field_7_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormatted(boolean paramBoolean) {
/* 183 */     this.field_7_option_flags = formatted.setBoolean(this.field_7_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setXFIndex(short paramShort) {
/* 194 */     this.field_8_option_flags = xfIndex.setValue(this.field_8_option_flags, paramShort);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTopBorder(boolean paramBoolean) {
/* 203 */     this.field_8_option_flags = topBorder.setBoolean(this.field_8_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBottomBorder(boolean paramBoolean) {
/* 213 */     this.field_8_option_flags = bottomBorder.setBoolean(this.field_8_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPhoeneticGuide(boolean paramBoolean) {
/* 222 */     this.field_8_option_flags = phoeneticGuide.setBoolean(this.field_8_option_flags, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRowNumber() {
/* 230 */     return this.field_1_row_number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFirstCol() {
/* 238 */     return this.field_2_first_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLastCol() {
/* 246 */     return this.field_3_last_col;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getHeight() {
/* 254 */     return this.field_4_height;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptimize() {
/* 262 */     return this.field_5_optimize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptionFlags() {
/* 271 */     return (short)this.field_7_option_flags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOutlineLevel() {
/* 282 */     return (short)outlineLevel.getValue(this.field_7_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getColapsed() {
/* 291 */     return colapsed.isSet(this.field_7_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getZeroHeight() {
/* 300 */     return zeroHeight.isSet(this.field_7_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBadFontHeight() {
/* 309 */     return badFontHeight.isSet(this.field_7_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getFormatted() {
/* 318 */     return formatted.isSet(this.field_7_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptionFlags2() {
/* 329 */     return (short)this.field_8_option_flags;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getXFIndex() {
/* 338 */     return xfIndex.getShortValue((short)this.field_8_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getTopBorder() {
/* 347 */     return topBorder.isSet(this.field_8_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getBottomBorder() {
/* 356 */     return bottomBorder.isSet(this.field_8_option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPhoeneticGuide() {
/* 365 */     return phoeneticGuide.isSet(this.field_8_option_flags);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 369 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 371 */     stringBuffer.append("[ROW]\n");
/* 372 */     stringBuffer.append("    .rownumber      = ").append(Integer.toHexString(getRowNumber())).append("\n");
/*     */     
/* 374 */     stringBuffer.append("    .firstcol       = ").append(HexDump.shortToHex(getFirstCol())).append("\n");
/* 375 */     stringBuffer.append("    .lastcol        = ").append(HexDump.shortToHex(getLastCol())).append("\n");
/* 376 */     stringBuffer.append("    .height         = ").append(HexDump.shortToHex(getHeight())).append("\n");
/* 377 */     stringBuffer.append("    .optimize       = ").append(HexDump.shortToHex(getOptimize())).append("\n");
/* 378 */     stringBuffer.append("    .reserved       = ").append(HexDump.shortToHex(this.field_6_reserved)).append("\n");
/* 379 */     stringBuffer.append("    .optionflags    = ").append(HexDump.shortToHex(getOptionFlags())).append("\n");
/* 380 */     stringBuffer.append("        .outlinelvl = ").append(Integer.toHexString(getOutlineLevel())).append("\n");
/* 381 */     stringBuffer.append("        .colapsed   = ").append(getColapsed()).append("\n");
/* 382 */     stringBuffer.append("        .zeroheight = ").append(getZeroHeight()).append("\n");
/* 383 */     stringBuffer.append("        .badfontheig= ").append(getBadFontHeight()).append("\n");
/* 384 */     stringBuffer.append("        .formatted  = ").append(getFormatted()).append("\n");
/* 385 */     stringBuffer.append("    .optionsflags2  = ").append(HexDump.shortToHex(getOptionFlags2())).append("\n");
/* 386 */     stringBuffer.append("        .xfindex       = ").append(Integer.toHexString(getXFIndex())).append("\n");
/* 387 */     stringBuffer.append("        .topBorder     = ").append(getTopBorder()).append("\n");
/* 388 */     stringBuffer.append("        .bottomBorder  = ").append(getBottomBorder()).append("\n");
/* 389 */     stringBuffer.append("        .phoeneticGuide= ").append(getPhoeneticGuide()).append("\n");
/* 390 */     stringBuffer.append("[/ROW]\n");
/* 391 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 395 */     paramLittleEndianOutput.writeShort(getRowNumber());
/* 396 */     paramLittleEndianOutput.writeShort((getFirstCol() == -1) ? 0 : getFirstCol());
/* 397 */     paramLittleEndianOutput.writeShort((getLastCol() == -1) ? 0 : getLastCol());
/* 398 */     paramLittleEndianOutput.writeShort(getHeight());
/* 399 */     paramLittleEndianOutput.writeShort(getOptimize());
/* 400 */     paramLittleEndianOutput.writeShort(this.field_6_reserved);
/* 401 */     paramLittleEndianOutput.writeShort(getOptionFlags());
/* 402 */     paramLittleEndianOutput.writeShort(getOptionFlags2());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 406 */     return 16;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 410 */     return 520;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 414 */     RowRecord rowRecord = new RowRecord(this.field_1_row_number);
/* 415 */     rowRecord.field_2_first_col = this.field_2_first_col;
/* 416 */     rowRecord.field_3_last_col = this.field_3_last_col;
/* 417 */     rowRecord.field_4_height = this.field_4_height;
/* 418 */     rowRecord.field_5_optimize = this.field_5_optimize;
/* 419 */     rowRecord.field_6_reserved = this.field_6_reserved;
/* 420 */     rowRecord.field_7_option_flags = this.field_7_option_flags;
/* 421 */     rowRecord.field_8_option_flags = this.field_8_option_flags;
/* 422 */     return rowRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\RowRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */