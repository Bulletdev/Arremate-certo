/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.LittleEndianOutput;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
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
/*     */ public final class SupBookRecord
/*     */   extends StandardRecord
/*     */ {
/*  33 */   private static final POILogger logger = POILogFactory.getLogger(SupBookRecord.class);
/*     */   
/*     */   public static final short sid = 430;
/*     */   
/*     */   private static final short SMALL_RECORD_SIZE = 4;
/*     */   
/*     */   private static final short TAG_INTERNAL_REFERENCES = 1025;
/*     */   
/*     */   private static final short TAG_ADD_IN_FUNCTIONS = 14849;
/*     */   private short field_1_number_of_sheets;
/*     */   private String field_2_encoded_url;
/*     */   private String[] field_3_sheet_names;
/*     */   private boolean _isAddInFunctions;
/*     */   protected static final char CH_VOLUME = '\001';
/*     */   protected static final char CH_SAME_VOLUME = '\002';
/*     */   protected static final char CH_DOWN_DIR = '\003';
/*     */   protected static final char CH_UP_DIR = '\004';
/*     */   protected static final char CH_LONG_VOLUME = '\005';
/*     */   protected static final char CH_STARTUP_DIR = '\006';
/*     */   protected static final char CH_ALT_STARTUP_DIR = '\007';
/*     */   protected static final char CH_LIB_DIR = '\b';
/*  54 */   protected static final String PATH_SEPERATOR = System.getProperty("file.separator");
/*     */   
/*     */   public static SupBookRecord createInternalReferences(short paramShort) {
/*  57 */     return new SupBookRecord(false, paramShort);
/*     */   }
/*     */   public static SupBookRecord createAddInFunctions() {
/*  60 */     return new SupBookRecord(true, (short)1);
/*     */   }
/*     */   public static SupBookRecord createExternalReferences(String paramString, String[] paramArrayOfString) {
/*  63 */     return new SupBookRecord(paramString, paramArrayOfString);
/*     */   }
/*     */   
/*     */   private SupBookRecord(boolean paramBoolean, short paramShort) {
/*  67 */     this.field_1_number_of_sheets = paramShort;
/*  68 */     this.field_2_encoded_url = null;
/*  69 */     this.field_3_sheet_names = null;
/*  70 */     this._isAddInFunctions = paramBoolean;
/*     */   }
/*     */   public SupBookRecord(String paramString, String[] paramArrayOfString) {
/*  73 */     this.field_1_number_of_sheets = (short)paramArrayOfString.length;
/*  74 */     this.field_2_encoded_url = paramString;
/*  75 */     this.field_3_sheet_names = paramArrayOfString;
/*  76 */     this._isAddInFunctions = false;
/*     */   }
/*     */   
/*     */   public boolean isExternalReferences() {
/*  80 */     return (this.field_3_sheet_names != null);
/*     */   }
/*     */   public boolean isInternalReferences() {
/*  83 */     return (this.field_3_sheet_names == null && !this._isAddInFunctions);
/*     */   }
/*     */   public boolean isAddInFunctions() {
/*  86 */     return (this.field_3_sheet_names == null && this._isAddInFunctions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SupBookRecord(RecordInputStream paramRecordInputStream) {
/*  95 */     int i = paramRecordInputStream.remaining();
/*     */     
/*  97 */     this.field_1_number_of_sheets = paramRecordInputStream.readShort();
/*     */     
/*  99 */     if (i > 4) {
/*     */       
/* 101 */       this._isAddInFunctions = false;
/*     */       
/* 103 */       this.field_2_encoded_url = paramRecordInputStream.readString();
/* 104 */       String[] arrayOfString = new String[this.field_1_number_of_sheets];
/* 105 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 106 */         arrayOfString[b] = paramRecordInputStream.readString();
/*     */       }
/* 108 */       this.field_3_sheet_names = arrayOfString;
/*     */       
/*     */       return;
/*     */     } 
/* 112 */     this.field_2_encoded_url = null;
/* 113 */     this.field_3_sheet_names = null;
/*     */     
/* 115 */     short s = paramRecordInputStream.readShort();
/* 116 */     if (s == 1025) {
/*     */       
/* 118 */       this._isAddInFunctions = false;
/* 119 */     } else if (s == 14849) {
/*     */       
/* 121 */       this._isAddInFunctions = true;
/* 122 */       if (this.field_1_number_of_sheets != 1) {
/* 123 */         throw new RuntimeException("Expected 0x0001 for number of sheets field in 'Add-In Functions' but got (" + this.field_1_number_of_sheets + ")");
/*     */       }
/*     */     } else {
/*     */       
/* 127 */       throw new RuntimeException("invalid EXTERNALBOOK code (" + Integer.toHexString(s) + ")");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 133 */     StringBuffer stringBuffer = new StringBuffer();
/* 134 */     stringBuffer.append("[SUPBOOK ");
/*     */     
/* 136 */     if (isExternalReferences()) {
/* 137 */       stringBuffer.append("External References]\n");
/* 138 */       stringBuffer.append(" .url     = ").append(this.field_2_encoded_url).append("\n");
/* 139 */       stringBuffer.append(" .nSheets = ").append(this.field_1_number_of_sheets).append("\n");
/* 140 */       for (String str : this.field_3_sheet_names) {
/* 141 */         stringBuffer.append("    .name = ").append(str).append("\n");
/*     */       }
/* 143 */       stringBuffer.append("[/SUPBOOK");
/* 144 */     } else if (this._isAddInFunctions) {
/* 145 */       stringBuffer.append("Add-In Functions");
/*     */     } else {
/* 147 */       stringBuffer.append("Internal References");
/* 148 */       stringBuffer.append(" nSheets=").append(this.field_1_number_of_sheets);
/*     */     } 
/* 150 */     stringBuffer.append("]");
/* 151 */     return stringBuffer.toString();
/*     */   }
/*     */   protected int getDataSize() {
/* 154 */     if (!isExternalReferences()) {
/* 155 */       return 4;
/*     */     }
/* 157 */     int i = 2;
/*     */     
/* 159 */     i += StringUtil.getEncodedSize(this.field_2_encoded_url);
/*     */     
/* 161 */     for (byte b = 0; b < this.field_3_sheet_names.length; b++) {
/* 162 */       i += StringUtil.getEncodedSize(this.field_3_sheet_names[b]);
/*     */     }
/* 164 */     return i;
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 168 */     paramLittleEndianOutput.writeShort(this.field_1_number_of_sheets);
/*     */     
/* 170 */     if (isExternalReferences()) {
/* 171 */       StringUtil.writeUnicodeString(paramLittleEndianOutput, this.field_2_encoded_url);
/*     */       
/* 173 */       for (byte b = 0; b < this.field_3_sheet_names.length; b++) {
/* 174 */         StringUtil.writeUnicodeString(paramLittleEndianOutput, this.field_3_sheet_names[b]);
/*     */       }
/*     */     } else {
/* 177 */       char c = this._isAddInFunctions ? '㨁' : 'Ё';
/*     */       
/* 179 */       paramLittleEndianOutput.writeShort(c);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setNumberOfSheets(short paramShort) {
/* 184 */     this.field_1_number_of_sheets = paramShort;
/*     */   }
/*     */   
/*     */   public short getNumberOfSheets() {
/* 188 */     return this.field_1_number_of_sheets;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 193 */     return 430;
/*     */   }
/*     */   public String getURL() {
/* 196 */     String str = this.field_2_encoded_url;
/* 197 */     switch (str.charAt(0)) {
/*     */       case '\000':
/* 199 */         return str.substring(1);
/*     */       case '\001':
/* 201 */         return decodeFileName(str);
/*     */       case '\002':
/* 203 */         return str.substring(1);
/*     */     } 
/*     */     
/* 206 */     return str;
/*     */   }
/*     */   
/*     */   private static String decodeFileName(String paramString) {
/* 210 */     StringBuilder stringBuilder = new StringBuilder();
/* 211 */     for (byte b = 1; b < paramString.length(); b++) {
/* 212 */       char c2, c1 = paramString.charAt(b);
/* 213 */       switch (c1) {
/*     */         case '\001':
/* 215 */           c2 = paramString.charAt(++b);
/* 216 */           if (c2 == '@') {
/* 217 */             stringBuilder.append("\\\\");
/*     */             break;
/*     */           } 
/* 220 */           stringBuilder.append(c2).append(":");
/*     */           break;
/*     */         
/*     */         case '\002':
/* 224 */           stringBuilder.append(PATH_SEPERATOR);
/*     */           break;
/*     */         case '\003':
/* 227 */           stringBuilder.append(PATH_SEPERATOR);
/*     */           break;
/*     */         case '\004':
/* 230 */           stringBuilder.append("..").append(PATH_SEPERATOR);
/*     */           break;
/*     */         
/*     */         case '\005':
/* 234 */           logger.log(5, new Object[] { "Found unexpected key: ChLongVolume - IGNORING" });
/*     */           break;
/*     */         case '\006':
/*     */         case '\007':
/*     */         case '\b':
/* 239 */           logger.log(5, new Object[] { "EXCEL.EXE path unkown - using this directoy instead: ." });
/* 240 */           stringBuilder.append(".").append(PATH_SEPERATOR);
/*     */           break;
/*     */         default:
/* 243 */           stringBuilder.append(c1); break;
/*     */       } 
/*     */     } 
/* 246 */     return stringBuilder.toString();
/*     */   }
/*     */   public String[] getSheetNames() {
/* 249 */     return (String[])this.field_3_sheet_names.clone();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setURL(String paramString) {
/* 254 */     this.field_2_encoded_url = this.field_2_encoded_url.substring(0, 1) + paramString;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\SupBookRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */