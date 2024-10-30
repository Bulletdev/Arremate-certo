/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecord;
/*     */ import org.apache.poi.hssf.record.cont.ContinuableRecordOutput;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Area3DPtg;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.formula.ptg.Ref3DPtg;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianByteArrayInputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public final class NameRecord
/*     */   extends ContinuableRecord
/*     */ {
/*     */   public static final short sid = 24;
/*     */   public static final byte BUILTIN_CONSOLIDATE_AREA = 1;
/*     */   public static final byte BUILTIN_AUTO_OPEN = 2;
/*     */   public static final byte BUILTIN_AUTO_CLOSE = 3;
/*     */   public static final byte BUILTIN_DATABASE = 4;
/*     */   public static final byte BUILTIN_CRITERIA = 5;
/*     */   public static final byte BUILTIN_PRINT_AREA = 6;
/*     */   public static final byte BUILTIN_PRINT_TITLE = 7;
/*     */   public static final byte BUILTIN_RECORDER = 8;
/*     */   public static final byte BUILTIN_DATA_FORM = 9;
/*     */   public static final byte BUILTIN_AUTO_ACTIVATE = 10;
/*     */   public static final byte BUILTIN_AUTO_DEACTIVATE = 11;
/*     */   public static final byte BUILTIN_SHEET_TITLE = 12;
/*     */   public static final byte BUILTIN_FILTER_DB = 13;
/*     */   private short field_1_option_flag;
/*     */   private byte field_2_keyboard_shortcut;
/*     */   private short field_5_externSheetIndex_plus1;
/*     */   private int field_6_sheetNumber;
/*     */   private boolean field_11_nameIsMultibyte;
/*     */   private byte field_12_built_in_code;
/*     */   private String field_12_name_text;
/*     */   private Formula field_13_name_definition;
/*     */   private String field_14_custom_menu_text;
/*     */   private String field_15_description_text;
/*     */   private String field_16_help_topic_text;
/*     */   private String field_17_status_bar_text;
/*     */   
/*     */   private static final class Option
/*     */   {
/*     */     public static final int OPT_HIDDEN_NAME = 1;
/*     */     public static final int OPT_FUNCTION_NAME = 2;
/*     */     public static final int OPT_COMMAND_NAME = 4;
/*     */     public static final int OPT_MACRO = 8;
/*     */     public static final int OPT_COMPLEX = 16;
/*     */     public static final int OPT_BUILTIN = 32;
/*     */     public static final int OPT_BINDATA = 4096;
/*     */     
/*     */     public static final boolean isFormula(int param1Int) {
/*  70 */       return ((param1Int & 0xF) == 0);
/*     */     }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameRecord() {
/*  92 */     this.field_13_name_definition = Formula.create(Ptg.EMPTY_PTG_ARRAY);
/*     */     
/*  94 */     this.field_12_name_text = "";
/*  95 */     this.field_14_custom_menu_text = "";
/*  96 */     this.field_15_description_text = "";
/*  97 */     this.field_16_help_topic_text = "";
/*  98 */     this.field_17_status_bar_text = "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NameRecord(byte paramByte, int paramInt) {
/* 108 */     this();
/* 109 */     this.field_12_built_in_code = paramByte;
/* 110 */     setOptionFlag((short)(this.field_1_option_flag | 0x20));
/*     */     
/* 112 */     this.field_6_sheetNumber = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptionFlag(short paramShort) {
/* 119 */     this.field_1_option_flag = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeyboardShortcut(byte paramByte) {
/* 127 */     this.field_2_keyboard_shortcut = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSheetNumber() {
/* 136 */     return this.field_6_sheetNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getFnGroup() {
/* 144 */     int i = this.field_1_option_flag & 0xFC0;
/* 145 */     return (byte)(i >> 4);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSheetNumber(int paramInt) {
/* 151 */     this.field_6_sheetNumber = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNameText(String paramString) {
/* 159 */     this.field_12_name_text = paramString;
/* 160 */     this.field_11_nameIsMultibyte = StringUtil.hasMultibyte(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomMenuText(String paramString) {
/* 167 */     this.field_14_custom_menu_text = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescriptionText(String paramString) {
/* 174 */     this.field_15_description_text = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHelpTopicText(String paramString) {
/* 181 */     this.field_16_help_topic_text = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStatusBarText(String paramString) {
/* 188 */     this.field_17_status_bar_text = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptionFlag() {
/* 195 */     return this.field_1_option_flag;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getKeyboardShortcut() {
/* 202 */     return this.field_2_keyboard_shortcut;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getNameTextLength() {
/* 210 */     if (isBuiltInName()) {
/* 211 */       return 1;
/*     */     }
/* 213 */     return this.field_12_name_text.length();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isHiddenName() {
/* 221 */     return ((this.field_1_option_flag & 0x1) != 0);
/*     */   }
/*     */   public void setHidden(boolean paramBoolean) {
/* 224 */     if (paramBoolean) {
/* 225 */       this.field_1_option_flag = (short)(this.field_1_option_flag | 0x1);
/*     */     } else {
/* 227 */       this.field_1_option_flag = (short)(this.field_1_option_flag & 0xFFFFFFFE);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFunctionName() {
/* 234 */     return ((this.field_1_option_flag & 0x2) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFunction(boolean paramBoolean) {
/* 244 */     if (paramBoolean) {
/* 245 */       this.field_1_option_flag = (short)(this.field_1_option_flag | 0x2);
/*     */     } else {
/* 247 */       this.field_1_option_flag = (short)(this.field_1_option_flag & 0xFFFFFFFD);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasFormula() {
/* 255 */     return (Option.isFormula(this.field_1_option_flag) && this.field_13_name_definition.getEncodedTokenSize() > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCommandName() {
/* 262 */     return ((this.field_1_option_flag & 0x4) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMacro() {
/* 268 */     return ((this.field_1_option_flag & 0x8) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isComplexFunction() {
/* 274 */     return ((this.field_1_option_flag & 0x10) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBuiltInName() {
/* 284 */     return ((this.field_1_option_flag & 0x20) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getNameText() {
/* 293 */     return isBuiltInName() ? translateBuiltInName(getBuiltInName()) : this.field_12_name_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public byte getBuiltInName() {
/* 301 */     return this.field_12_built_in_code;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getNameDefinition() {
/* 309 */     return this.field_13_name_definition.getTokens();
/*     */   }
/*     */   
/*     */   public void setNameDefinition(Ptg[] paramArrayOfPtg) {
/* 313 */     this.field_13_name_definition = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomMenuText() {
/* 320 */     return this.field_14_custom_menu_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDescriptionText() {
/* 327 */     return this.field_15_description_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHelpTopicText() {
/* 334 */     return this.field_16_help_topic_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStatusBarText() {
/* 341 */     return this.field_17_status_bar_text;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(ContinuableRecordOutput paramContinuableRecordOutput) {
/* 352 */     int i = this.field_14_custom_menu_text.length();
/* 353 */     int j = this.field_15_description_text.length();
/* 354 */     int k = this.field_16_help_topic_text.length();
/* 355 */     int m = this.field_17_status_bar_text.length();
/*     */ 
/*     */     
/* 358 */     paramContinuableRecordOutput.writeShort(getOptionFlag());
/* 359 */     paramContinuableRecordOutput.writeByte(getKeyboardShortcut());
/* 360 */     paramContinuableRecordOutput.writeByte(getNameTextLength());
/*     */     
/* 362 */     paramContinuableRecordOutput.writeShort(this.field_13_name_definition.getEncodedTokenSize());
/* 363 */     paramContinuableRecordOutput.writeShort(this.field_5_externSheetIndex_plus1);
/* 364 */     paramContinuableRecordOutput.writeShort(this.field_6_sheetNumber);
/* 365 */     paramContinuableRecordOutput.writeByte(i);
/* 366 */     paramContinuableRecordOutput.writeByte(j);
/* 367 */     paramContinuableRecordOutput.writeByte(k);
/* 368 */     paramContinuableRecordOutput.writeByte(m);
/* 369 */     paramContinuableRecordOutput.writeByte(this.field_11_nameIsMultibyte ? 1 : 0);
/*     */     
/* 371 */     if (isBuiltInName()) {
/*     */       
/* 373 */       paramContinuableRecordOutput.writeByte(this.field_12_built_in_code);
/*     */     } else {
/* 375 */       String str = this.field_12_name_text;
/* 376 */       if (this.field_11_nameIsMultibyte) {
/* 377 */         StringUtil.putUnicodeLE(str, (LittleEndianOutput)paramContinuableRecordOutput);
/*     */       } else {
/* 379 */         StringUtil.putCompressedUnicode(str, (LittleEndianOutput)paramContinuableRecordOutput);
/*     */       } 
/*     */     } 
/* 382 */     this.field_13_name_definition.serializeTokens((LittleEndianOutput)paramContinuableRecordOutput);
/* 383 */     this.field_13_name_definition.serializeArrayConstantData((LittleEndianOutput)paramContinuableRecordOutput);
/*     */     
/* 385 */     StringUtil.putCompressedUnicode(getCustomMenuText(), (LittleEndianOutput)paramContinuableRecordOutput);
/* 386 */     StringUtil.putCompressedUnicode(getDescriptionText(), (LittleEndianOutput)paramContinuableRecordOutput);
/* 387 */     StringUtil.putCompressedUnicode(getHelpTopicText(), (LittleEndianOutput)paramContinuableRecordOutput);
/* 388 */     StringUtil.putCompressedUnicode(getStatusBarText(), (LittleEndianOutput)paramContinuableRecordOutput);
/*     */   }
/*     */   private int getNameRawSize() {
/* 391 */     if (isBuiltInName()) {
/* 392 */       return 1;
/*     */     }
/* 394 */     int i = this.field_12_name_text.length();
/* 395 */     if (this.field_11_nameIsMultibyte) {
/* 396 */       return 2 * i;
/*     */     }
/* 398 */     return i;
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 402 */     return 13 + getNameRawSize() + this.field_14_custom_menu_text.length() + this.field_15_description_text.length() + this.field_16_help_topic_text.length() + this.field_17_status_bar_text.length() + this.field_13_name_definition.getEncodedSize();
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
/*     */   public int getExternSheetNumber() {
/* 415 */     Ptg[] arrayOfPtg = this.field_13_name_definition.getTokens();
/* 416 */     if (arrayOfPtg.length == 0) {
/* 417 */       return 0;
/*     */     }
/*     */     
/* 420 */     Ptg ptg = arrayOfPtg[0];
/* 421 */     if (ptg.getClass() == Area3DPtg.class) {
/* 422 */       return ((Area3DPtg)ptg).getExternSheetIndex();
/*     */     }
/*     */     
/* 425 */     if (ptg.getClass() == Ref3DPtg.class) {
/* 426 */       return ((Ref3DPtg)ptg).getExternSheetIndex();
/*     */     }
/* 428 */     return 0;
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
/*     */   
/*     */   public NameRecord(RecordInputStream paramRecordInputStream) {
/* 442 */     byte[] arrayOfByte = paramRecordInputStream.readAllContinuedRemainder();
/* 443 */     LittleEndianByteArrayInputStream littleEndianByteArrayInputStream = new LittleEndianByteArrayInputStream(arrayOfByte);
/*     */     
/* 445 */     this.field_1_option_flag = littleEndianByteArrayInputStream.readShort();
/* 446 */     this.field_2_keyboard_shortcut = littleEndianByteArrayInputStream.readByte();
/* 447 */     int i = littleEndianByteArrayInputStream.readUByte();
/* 448 */     short s = littleEndianByteArrayInputStream.readShort();
/* 449 */     this.field_5_externSheetIndex_plus1 = littleEndianByteArrayInputStream.readShort();
/* 450 */     this.field_6_sheetNumber = littleEndianByteArrayInputStream.readUShort();
/* 451 */     int j = littleEndianByteArrayInputStream.readUByte();
/* 452 */     int k = littleEndianByteArrayInputStream.readUByte();
/* 453 */     int m = littleEndianByteArrayInputStream.readUByte();
/* 454 */     int n = littleEndianByteArrayInputStream.readUByte();
/*     */ 
/*     */     
/* 457 */     this.field_11_nameIsMultibyte = (littleEndianByteArrayInputStream.readByte() != 0);
/* 458 */     if (isBuiltInName()) {
/* 459 */       this.field_12_built_in_code = littleEndianByteArrayInputStream.readByte();
/*     */     }
/* 461 */     else if (this.field_11_nameIsMultibyte) {
/* 462 */       this.field_12_name_text = StringUtil.readUnicodeLE((LittleEndianInput)littleEndianByteArrayInputStream, i);
/*     */     } else {
/* 464 */       this.field_12_name_text = StringUtil.readCompressedUnicode((LittleEndianInput)littleEndianByteArrayInputStream, i);
/*     */     } 
/*     */ 
/*     */     
/* 468 */     int i1 = littleEndianByteArrayInputStream.available() - j + k + m + n;
/*     */     
/* 470 */     this.field_13_name_definition = Formula.read(s, (LittleEndianInput)littleEndianByteArrayInputStream, i1);
/*     */ 
/*     */     
/* 473 */     this.field_14_custom_menu_text = StringUtil.readCompressedUnicode((LittleEndianInput)littleEndianByteArrayInputStream, j);
/* 474 */     this.field_15_description_text = StringUtil.readCompressedUnicode((LittleEndianInput)littleEndianByteArrayInputStream, k);
/* 475 */     this.field_16_help_topic_text = StringUtil.readCompressedUnicode((LittleEndianInput)littleEndianByteArrayInputStream, m);
/* 476 */     this.field_17_status_bar_text = StringUtil.readCompressedUnicode((LittleEndianInput)littleEndianByteArrayInputStream, n);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 484 */     return 24;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 539 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 541 */     stringBuffer.append("[NAME]\n");
/* 542 */     stringBuffer.append("    .option flags           = ").append(HexDump.shortToHex(this.field_1_option_flag)).append("\n");
/* 543 */     stringBuffer.append("    .keyboard shortcut      = ").append(HexDump.byteToHex(this.field_2_keyboard_shortcut)).append("\n");
/* 544 */     stringBuffer.append("    .length of the name     = ").append(getNameTextLength()).append("\n");
/* 545 */     stringBuffer.append("    .extSheetIx(1-based, 0=Global)= ").append(this.field_5_externSheetIndex_plus1).append("\n");
/* 546 */     stringBuffer.append("    .sheetTabIx             = ").append(this.field_6_sheetNumber).append("\n");
/* 547 */     stringBuffer.append("    .Menu text length       = ").append(this.field_14_custom_menu_text.length()).append("\n");
/* 548 */     stringBuffer.append("    .Description text length= ").append(this.field_15_description_text.length()).append("\n");
/* 549 */     stringBuffer.append("    .Help topic text length = ").append(this.field_16_help_topic_text.length()).append("\n");
/* 550 */     stringBuffer.append("    .Status bar text length = ").append(this.field_17_status_bar_text.length()).append("\n");
/* 551 */     stringBuffer.append("    .NameIsMultibyte        = ").append(this.field_11_nameIsMultibyte).append("\n");
/* 552 */     stringBuffer.append("    .Name (Unicode text)    = ").append(getNameText()).append("\n");
/* 553 */     Ptg[] arrayOfPtg = this.field_13_name_definition.getTokens();
/* 554 */     stringBuffer.append("    .Formula (nTokens=").append(arrayOfPtg.length).append("):").append("\n");
/* 555 */     for (Ptg ptg : arrayOfPtg) {
/* 556 */       stringBuffer.append("       " + ptg.toString()).append(ptg.getRVAType()).append("\n");
/*     */     }
/*     */     
/* 559 */     stringBuffer.append("    .Menu text       = ").append(this.field_14_custom_menu_text).append("\n");
/* 560 */     stringBuffer.append("    .Description text= ").append(this.field_15_description_text).append("\n");
/* 561 */     stringBuffer.append("    .Help topic text = ").append(this.field_16_help_topic_text).append("\n");
/* 562 */     stringBuffer.append("    .Status bar text = ").append(this.field_17_status_bar_text).append("\n");
/* 563 */     stringBuffer.append("[/NAME]\n");
/*     */     
/* 565 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String translateBuiltInName(byte paramByte) {
/* 573 */     switch (paramByte) {
/*     */       case 10:
/* 575 */         return "Auto_Activate";
/* 576 */       case 3: return "Auto_Close";
/* 577 */       case 11: return "Auto_Deactivate";
/* 578 */       case 2: return "Auto_Open";
/* 579 */       case 1: return "Consolidate_Area";
/* 580 */       case 5: return "Criteria";
/* 581 */       case 4: return "Database";
/* 582 */       case 9: return "Data_Form";
/* 583 */       case 6: return "Print_Area";
/* 584 */       case 7: return "Print_Titles";
/* 585 */       case 8: return "Recorder";
/* 586 */       case 12: return "Sheet_Title";
/* 587 */       case 13: return "_FilterDatabase";
/*     */     } 
/*     */ 
/*     */     
/* 591 */     return "Unknown";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\NameRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */