/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.BitField;
/*     */ import org.apache.poi.util.BitFieldFactory;
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public final class CommonObjectDataSubRecord
/*     */   extends SubRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 21;
/*  32 */   private static final BitField locked = BitFieldFactory.getInstance(1);
/*  33 */   private static final BitField printable = BitFieldFactory.getInstance(16);
/*  34 */   private static final BitField autofill = BitFieldFactory.getInstance(8192);
/*  35 */   private static final BitField autoline = BitFieldFactory.getInstance(16384);
/*     */   
/*     */   public static final short OBJECT_TYPE_GROUP = 0;
/*     */   
/*     */   public static final short OBJECT_TYPE_LINE = 1;
/*     */   
/*     */   public static final short OBJECT_TYPE_RECTANGLE = 2;
/*     */   
/*     */   public static final short OBJECT_TYPE_OVAL = 3;
/*     */   
/*     */   public static final short OBJECT_TYPE_ARC = 4;
/*     */   
/*     */   public static final short OBJECT_TYPE_CHART = 5;
/*     */   public static final short OBJECT_TYPE_TEXT = 6;
/*     */   public static final short OBJECT_TYPE_BUTTON = 7;
/*     */   public static final short OBJECT_TYPE_PICTURE = 8;
/*     */   public static final short OBJECT_TYPE_POLYGON = 9;
/*     */   public static final short OBJECT_TYPE_RESERVED1 = 10;
/*     */   public static final short OBJECT_TYPE_CHECKBOX = 11;
/*     */   public static final short OBJECT_TYPE_OPTION_BUTTON = 12;
/*     */   public static final short OBJECT_TYPE_EDIT_BOX = 13;
/*     */   public static final short OBJECT_TYPE_LABEL = 14;
/*     */   public static final short OBJECT_TYPE_DIALOG_BOX = 15;
/*     */   public static final short OBJECT_TYPE_SPINNER = 16;
/*     */   public static final short OBJECT_TYPE_SCROLL_BAR = 17;
/*     */   public static final short OBJECT_TYPE_LIST_BOX = 18;
/*     */   public static final short OBJECT_TYPE_GROUP_BOX = 19;
/*     */   public static final short OBJECT_TYPE_COMBO_BOX = 20;
/*     */   public static final short OBJECT_TYPE_RESERVED2 = 21;
/*     */   public static final short OBJECT_TYPE_RESERVED3 = 22;
/*     */   public static final short OBJECT_TYPE_RESERVED4 = 23;
/*     */   public static final short OBJECT_TYPE_RESERVED5 = 24;
/*     */   public static final short OBJECT_TYPE_COMMENT = 25;
/*     */   public static final short OBJECT_TYPE_RESERVED6 = 26;
/*     */   public static final short OBJECT_TYPE_RESERVED7 = 27;
/*     */   public static final short OBJECT_TYPE_RESERVED8 = 28;
/*     */   public static final short OBJECT_TYPE_RESERVED9 = 29;
/*     */   public static final short OBJECT_TYPE_MICROSOFT_OFFICE_DRAWING = 30;
/*     */   private short field_1_objectType;
/*     */   private int field_2_objectId;
/*     */   private short field_3_option;
/*     */   private int field_4_reserved1;
/*     */   private int field_5_reserved2;
/*     */   private int field_6_reserved3;
/*     */   
/*     */   public CommonObjectDataSubRecord() {}
/*     */   
/*     */   public CommonObjectDataSubRecord(LittleEndianInput paramLittleEndianInput, int paramInt) {
/*  83 */     if (paramInt != 18) {
/*  84 */       throw new RecordFormatException("Expected size 18 but got (" + paramInt + ")");
/*     */     }
/*  86 */     this.field_1_objectType = paramLittleEndianInput.readShort();
/*  87 */     this.field_2_objectId = paramLittleEndianInput.readUShort();
/*  88 */     this.field_3_option = paramLittleEndianInput.readShort();
/*  89 */     this.field_4_reserved1 = paramLittleEndianInput.readInt();
/*  90 */     this.field_5_reserved2 = paramLittleEndianInput.readInt();
/*  91 */     this.field_6_reserved3 = paramLittleEndianInput.readInt();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/*  97 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  99 */     stringBuffer.append("[ftCmo]\n");
/* 100 */     stringBuffer.append("    .objectType           = ").append("0x").append(HexDump.toHex(getObjectType())).append(" (").append(getObjectType()).append(" )");
/*     */ 
/*     */     
/* 103 */     stringBuffer.append(System.getProperty("line.separator"));
/* 104 */     stringBuffer.append("    .objectId             = ").append("0x").append(HexDump.toHex(getObjectId())).append(" (").append(getObjectId()).append(" )");
/*     */ 
/*     */     
/* 107 */     stringBuffer.append(System.getProperty("line.separator"));
/* 108 */     stringBuffer.append("    .option               = ").append("0x").append(HexDump.toHex(getOption())).append(" (").append(getOption()).append(" )");
/*     */ 
/*     */     
/* 111 */     stringBuffer.append(System.getProperty("line.separator"));
/* 112 */     stringBuffer.append("         .locked                   = ").append(isLocked()).append('\n');
/* 113 */     stringBuffer.append("         .printable                = ").append(isPrintable()).append('\n');
/* 114 */     stringBuffer.append("         .autofill                 = ").append(isAutofill()).append('\n');
/* 115 */     stringBuffer.append("         .autoline                 = ").append(isAutoline()).append('\n');
/* 116 */     stringBuffer.append("    .reserved1            = ").append("0x").append(HexDump.toHex(getReserved1())).append(" (").append(getReserved1()).append(" )");
/*     */ 
/*     */     
/* 119 */     stringBuffer.append(System.getProperty("line.separator"));
/* 120 */     stringBuffer.append("    .reserved2            = ").append("0x").append(HexDump.toHex(getReserved2())).append(" (").append(getReserved2()).append(" )");
/*     */ 
/*     */     
/* 123 */     stringBuffer.append(System.getProperty("line.separator"));
/* 124 */     stringBuffer.append("    .reserved3            = ").append("0x").append(HexDump.toHex(getReserved3())).append(" (").append(getReserved3()).append(" )");
/*     */ 
/*     */     
/* 127 */     stringBuffer.append(System.getProperty("line.separator"));
/*     */     
/* 129 */     stringBuffer.append("[/ftCmo]\n");
/* 130 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 136 */     paramLittleEndianOutput.writeShort(21);
/* 137 */     paramLittleEndianOutput.writeShort(getDataSize());
/*     */     
/* 139 */     paramLittleEndianOutput.writeShort(this.field_1_objectType);
/* 140 */     paramLittleEndianOutput.writeShort(this.field_2_objectId);
/* 141 */     paramLittleEndianOutput.writeShort(this.field_3_option);
/* 142 */     paramLittleEndianOutput.writeInt(this.field_4_reserved1);
/* 143 */     paramLittleEndianOutput.writeInt(this.field_5_reserved2);
/* 144 */     paramLittleEndianOutput.writeInt(this.field_6_reserved3);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int getDataSize() {
/* 149 */     return 18;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 157 */     return 21;
/*     */   }
/*     */ 
/*     */   
/*     */   public CommonObjectDataSubRecord clone() {
/* 162 */     CommonObjectDataSubRecord commonObjectDataSubRecord = new CommonObjectDataSubRecord();
/*     */     
/* 164 */     commonObjectDataSubRecord.field_1_objectType = this.field_1_objectType;
/* 165 */     commonObjectDataSubRecord.field_2_objectId = this.field_2_objectId;
/* 166 */     commonObjectDataSubRecord.field_3_option = this.field_3_option;
/* 167 */     commonObjectDataSubRecord.field_4_reserved1 = this.field_4_reserved1;
/* 168 */     commonObjectDataSubRecord.field_5_reserved2 = this.field_5_reserved2;
/* 169 */     commonObjectDataSubRecord.field_6_reserved3 = this.field_6_reserved3;
/* 170 */     return commonObjectDataSubRecord;
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
/*     */   public short getObjectType() {
/* 212 */     return this.field_1_objectType;
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
/*     */   public void setObjectType(short paramShort) {
/* 254 */     this.field_1_objectType = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getObjectId() {
/* 264 */     return this.field_2_objectId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectId(int paramInt) {
/* 274 */     this.field_2_objectId = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOption() {
/* 284 */     return this.field_3_option;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOption(short paramShort) {
/* 294 */     this.field_3_option = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved1() {
/* 304 */     return this.field_4_reserved1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved1(int paramInt) {
/* 314 */     this.field_4_reserved1 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved2() {
/* 324 */     return this.field_5_reserved2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved2(int paramInt) {
/* 334 */     this.field_5_reserved2 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getReserved3() {
/* 344 */     return this.field_6_reserved3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReserved3(int paramInt) {
/* 354 */     this.field_6_reserved3 = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLocked(boolean paramBoolean) {
/* 365 */     this.field_3_option = locked.setShortBoolean(this.field_3_option, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isLocked() {
/* 374 */     return locked.isSet(this.field_3_option);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrintable(boolean paramBoolean) {
/* 385 */     this.field_3_option = printable.setShortBoolean(this.field_3_option, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrintable() {
/* 394 */     return printable.isSet(this.field_3_option);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutofill(boolean paramBoolean) {
/* 405 */     this.field_3_option = autofill.setShortBoolean(this.field_3_option, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutofill() {
/* 414 */     return autofill.isSet(this.field_3_option);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoline(boolean paramBoolean) {
/* 425 */     this.field_3_option = autoline.setShortBoolean(this.field_3_option, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutoline() {
/* 434 */     return autoline.isSet(this.field_3_option);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CommonObjectDataSubRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */