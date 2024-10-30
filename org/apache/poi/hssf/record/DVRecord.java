/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.hssf.record.common.UnicodeString;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
/*     */ import org.apache.poi.ss.util.CellRangeAddress;
/*     */ import org.apache.poi.ss.util.CellRangeAddressList;
/*     */ import org.apache.poi.util.BitField;
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
/*     */ public final class DVRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 446;
/*  41 */   private static final UnicodeString NULL_TEXT_STRING = new UnicodeString("\000");
/*     */ 
/*     */   
/*     */   private int _option_flags;
/*     */   
/*     */   private UnicodeString _promptTitle;
/*     */   
/*     */   private UnicodeString _errorTitle;
/*     */   
/*     */   private UnicodeString _promptText;
/*     */   
/*     */   private UnicodeString _errorText;
/*     */   
/*  54 */   private short _not_used_1 = 16352;
/*     */   
/*     */   private Formula _formula1;
/*     */   
/*  58 */   private short _not_used_2 = 0;
/*     */ 
/*     */ 
/*     */   
/*     */   private Formula _formula2;
/*     */ 
/*     */ 
/*     */   
/*     */   private CellRangeAddressList _regions;
/*     */ 
/*     */   
/*  69 */   private static final BitField opt_data_type = new BitField(15);
/*  70 */   private static final BitField opt_error_style = new BitField(112);
/*  71 */   private static final BitField opt_string_list_formula = new BitField(128);
/*  72 */   private static final BitField opt_empty_cell_allowed = new BitField(256);
/*  73 */   private static final BitField opt_suppress_dropdown_arrow = new BitField(512);
/*  74 */   private static final BitField opt_show_prompt_on_cell_selected = new BitField(262144);
/*  75 */   private static final BitField opt_show_error_on_invalid_value = new BitField(524288);
/*  76 */   private static final BitField opt_condition_operator = new BitField(7340032);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DVRecord(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, String paramString1, String paramString2, boolean paramBoolean5, String paramString3, String paramString4, Ptg[] paramArrayOfPtg1, Ptg[] paramArrayOfPtg2, CellRangeAddressList paramCellRangeAddressList) {
/*  85 */     int i = 0;
/*  86 */     i = opt_data_type.setValue(i, paramInt1);
/*  87 */     i = opt_condition_operator.setValue(i, paramInt2);
/*  88 */     i = opt_error_style.setValue(i, paramInt3);
/*  89 */     i = opt_empty_cell_allowed.setBoolean(i, paramBoolean1);
/*  90 */     i = opt_suppress_dropdown_arrow.setBoolean(i, paramBoolean2);
/*  91 */     i = opt_string_list_formula.setBoolean(i, paramBoolean3);
/*  92 */     i = opt_show_prompt_on_cell_selected.setBoolean(i, paramBoolean4);
/*  93 */     i = opt_show_error_on_invalid_value.setBoolean(i, paramBoolean5);
/*  94 */     this._option_flags = i;
/*  95 */     this._promptTitle = resolveTitleText(paramString1);
/*  96 */     this._promptText = resolveTitleText(paramString2);
/*  97 */     this._errorTitle = resolveTitleText(paramString3);
/*  98 */     this._errorText = resolveTitleText(paramString4);
/*  99 */     this._formula1 = Formula.create(paramArrayOfPtg1);
/* 100 */     this._formula2 = Formula.create(paramArrayOfPtg2);
/* 101 */     this._regions = paramCellRangeAddressList;
/*     */   }
/*     */ 
/*     */   
/*     */   public DVRecord(RecordInputStream paramRecordInputStream) {
/* 106 */     this._option_flags = paramRecordInputStream.readInt();
/*     */     
/* 108 */     this._promptTitle = readUnicodeString(paramRecordInputStream);
/* 109 */     this._errorTitle = readUnicodeString(paramRecordInputStream);
/* 110 */     this._promptText = readUnicodeString(paramRecordInputStream);
/* 111 */     this._errorText = readUnicodeString(paramRecordInputStream);
/*     */     
/* 113 */     int i = paramRecordInputStream.readUShort();
/* 114 */     this._not_used_1 = paramRecordInputStream.readShort();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     this._formula1 = Formula.read(i, paramRecordInputStream);
/*     */     
/* 121 */     int j = paramRecordInputStream.readUShort();
/* 122 */     this._not_used_2 = paramRecordInputStream.readShort();
/*     */ 
/*     */     
/* 125 */     this._formula2 = Formula.read(j, paramRecordInputStream);
/*     */ 
/*     */     
/* 128 */     this._regions = new CellRangeAddressList(paramRecordInputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDataType() {
/* 137 */     return opt_data_type.getValue(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getErrorStyle() {
/* 145 */     return opt_error_style.getValue(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getListExplicitFormula() {
/* 153 */     return opt_string_list_formula.isSet(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getEmptyCellAllowed() {
/* 160 */     return opt_empty_cell_allowed.isSet(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getSuppressDropdownArrow() {
/* 169 */     return opt_suppress_dropdown_arrow.isSet(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowPromptOnCellSelected() {
/* 176 */     return opt_show_prompt_on_cell_selected.isSet(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getShowErrorOnInvalidValue() {
/* 184 */     return opt_show_error_on_invalid_value.isSet(this._option_flags);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getConditionOperator() {
/* 193 */     return opt_condition_operator.getValue(this._option_flags);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getPromptTitle() {
/* 198 */     return resolveTitleString(this._promptTitle);
/*     */   }
/*     */   
/*     */   public String getErrorTitle() {
/* 202 */     return resolveTitleString(this._errorTitle);
/*     */   }
/*     */   
/*     */   public String getPromptText() {
/* 206 */     return resolveTitleString(this._promptText);
/*     */   }
/*     */   
/*     */   public String getErrorText() {
/* 210 */     return resolveTitleString(this._errorText);
/*     */   }
/*     */   
/*     */   public Ptg[] getFormula1() {
/* 214 */     return Formula.getTokens(this._formula1);
/*     */   }
/*     */   
/*     */   public Ptg[] getFormula2() {
/* 218 */     return Formula.getTokens(this._formula2);
/*     */   }
/*     */   
/*     */   public CellRangeAddressList getCellRangeAddress() {
/* 222 */     return this._regions;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 227 */     StringBuffer stringBuffer = new StringBuffer();
/* 228 */     stringBuffer.append("[DV]\n");
/* 229 */     stringBuffer.append(" options=").append(Integer.toHexString(this._option_flags));
/* 230 */     stringBuffer.append(" title-prompt=").append(formatTextTitle(this._promptTitle));
/* 231 */     stringBuffer.append(" title-error=").append(formatTextTitle(this._errorTitle));
/* 232 */     stringBuffer.append(" text-prompt=").append(formatTextTitle(this._promptText));
/* 233 */     stringBuffer.append(" text-error=").append(formatTextTitle(this._errorText));
/* 234 */     stringBuffer.append("\n");
/* 235 */     appendFormula(stringBuffer, "Formula 1:", this._formula1);
/* 236 */     appendFormula(stringBuffer, "Formula 2:", this._formula2);
/* 237 */     stringBuffer.append("Regions: ");
/* 238 */     int i = this._regions.countRanges();
/* 239 */     for (byte b = 0; b < i; b++) {
/* 240 */       if (b > 0) {
/* 241 */         stringBuffer.append(", ");
/*     */       }
/* 243 */       CellRangeAddress cellRangeAddress = this._regions.getCellRangeAddress(b);
/* 244 */       stringBuffer.append('(').append(cellRangeAddress.getFirstRow()).append(',').append(cellRangeAddress.getLastRow());
/* 245 */       stringBuffer.append(',').append(cellRangeAddress.getFirstColumn()).append(',').append(cellRangeAddress.getLastColumn()).append(')');
/*     */     } 
/* 247 */     stringBuffer.append("\n");
/* 248 */     stringBuffer.append("[/DV]");
/*     */     
/* 250 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private static String formatTextTitle(UnicodeString paramUnicodeString) {
/* 254 */     String str = paramUnicodeString.getString();
/* 255 */     if (str.length() == 1 && str.charAt(0) == '\000') {
/* 256 */       return "'\\0'";
/*     */     }
/* 258 */     return str;
/*     */   }
/*     */   
/*     */   private static void appendFormula(StringBuffer paramStringBuffer, String paramString, Formula paramFormula) {
/* 262 */     paramStringBuffer.append(paramString);
/*     */     
/* 264 */     if (paramFormula == null) {
/* 265 */       paramStringBuffer.append("<empty>\n");
/*     */       return;
/*     */     } 
/* 268 */     Ptg[] arrayOfPtg = paramFormula.getTokens();
/* 269 */     paramStringBuffer.append('\n');
/* 270 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/* 271 */       paramStringBuffer.append('\t').append(arrayOfPtg[b].toString()).append('\n');
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 277 */     paramLittleEndianOutput.writeInt(this._option_flags);
/*     */     
/* 279 */     serializeUnicodeString(this._promptTitle, paramLittleEndianOutput);
/* 280 */     serializeUnicodeString(this._errorTitle, paramLittleEndianOutput);
/* 281 */     serializeUnicodeString(this._promptText, paramLittleEndianOutput);
/* 282 */     serializeUnicodeString(this._errorText, paramLittleEndianOutput);
/* 283 */     paramLittleEndianOutput.writeShort(this._formula1.getEncodedTokenSize());
/* 284 */     paramLittleEndianOutput.writeShort(this._not_used_1);
/* 285 */     this._formula1.serializeTokens(paramLittleEndianOutput);
/*     */     
/* 287 */     paramLittleEndianOutput.writeShort(this._formula2.getEncodedTokenSize());
/* 288 */     paramLittleEndianOutput.writeShort(this._not_used_2);
/* 289 */     this._formula2.serializeTokens(paramLittleEndianOutput);
/*     */     
/* 291 */     this._regions.serialize(paramLittleEndianOutput);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static UnicodeString resolveTitleText(String paramString) {
/* 301 */     if (paramString == null || paramString.length() < 1) {
/* 302 */       return NULL_TEXT_STRING;
/*     */     }
/* 304 */     return new UnicodeString(paramString);
/*     */   }
/*     */   
/*     */   private static String resolveTitleString(UnicodeString paramUnicodeString) {
/* 308 */     if (paramUnicodeString == null || paramUnicodeString.equals(NULL_TEXT_STRING)) {
/* 309 */       return null;
/*     */     }
/* 311 */     return paramUnicodeString.getString();
/*     */   }
/*     */   
/*     */   private static UnicodeString readUnicodeString(RecordInputStream paramRecordInputStream) {
/* 315 */     return new UnicodeString(paramRecordInputStream);
/*     */   }
/*     */   
/*     */   private static void serializeUnicodeString(UnicodeString paramUnicodeString, LittleEndianOutput paramLittleEndianOutput) {
/* 319 */     StringUtil.writeUnicodeString(paramLittleEndianOutput, paramUnicodeString.getString());
/*     */   }
/*     */   private static int getUnicodeStringSize(UnicodeString paramUnicodeString) {
/* 322 */     String str = paramUnicodeString.getString();
/* 323 */     return 3 + str.length() * (StringUtil.hasMultibyte(str) ? 2 : 1);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 327 */     int i = 12;
/* 328 */     i += getUnicodeStringSize(this._promptTitle);
/* 329 */     i += getUnicodeStringSize(this._errorTitle);
/* 330 */     i += getUnicodeStringSize(this._promptText);
/* 331 */     i += getUnicodeStringSize(this._errorText);
/* 332 */     i += this._formula1.getEncodedTokenSize();
/* 333 */     i += this._formula2.getEncodedTokenSize();
/* 334 */     i += this._regions.getSize();
/* 335 */     return i;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 339 */     return 446;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DVRecord clone() {
/* 348 */     return (DVRecord)cloneViaReserialise();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\DVRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */