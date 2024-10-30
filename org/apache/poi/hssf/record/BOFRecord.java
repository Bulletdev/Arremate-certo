/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class BOFRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 2057;
/*     */   public static final short biff2_sid = 9;
/*     */   public static final short biff3_sid = 521;
/*     */   public static final short biff4_sid = 1033;
/*     */   public static final short biff5_sid = 2057;
/*     */   public static final int VERSION = 1536;
/*     */   public static final int BUILD = 4307;
/*     */   public static final int BUILD_YEAR = 1996;
/*     */   public static final int HISTORY_MASK = 65;
/*     */   public static final int TYPE_WORKBOOK = 5;
/*     */   public static final int TYPE_VB_MODULE = 6;
/*     */   public static final int TYPE_WORKSHEET = 16;
/*     */   public static final int TYPE_CHART = 32;
/*     */   public static final int TYPE_EXCEL_4_MACRO = 64;
/*     */   public static final int TYPE_WORKSPACE_FILE = 256;
/*     */   private int field_1_version;
/*     */   private int field_2_type;
/*     */   private int field_3_build;
/*     */   private int field_4_year;
/*     */   private int field_5_history;
/*     */   private int field_6_rversion;
/*     */   
/*     */   public BOFRecord() {}
/*     */   
/*     */   private BOFRecord(int paramInt) {
/*  75 */     this.field_1_version = 1536;
/*  76 */     this.field_2_type = paramInt;
/*  77 */     this.field_3_build = 4307;
/*  78 */     this.field_4_year = 1996;
/*  79 */     this.field_5_history = 1;
/*  80 */     this.field_6_rversion = 1536;
/*     */   }
/*     */   
/*     */   public static BOFRecord createSheetBOF() {
/*  84 */     return new BOFRecord(16);
/*     */   }
/*     */   
/*     */   public BOFRecord(RecordInputStream paramRecordInputStream) {
/*  88 */     this.field_1_version = paramRecordInputStream.readShort();
/*  89 */     this.field_2_type = paramRecordInputStream.readShort();
/*     */ 
/*     */ 
/*     */     
/*  93 */     if (paramRecordInputStream.remaining() >= 2) {
/*  94 */       this.field_3_build = paramRecordInputStream.readShort();
/*     */     }
/*  96 */     if (paramRecordInputStream.remaining() >= 2) {
/*  97 */       this.field_4_year = paramRecordInputStream.readShort();
/*     */     }
/*  99 */     if (paramRecordInputStream.remaining() >= 4) {
/* 100 */       this.field_5_history = paramRecordInputStream.readInt();
/*     */     }
/* 102 */     if (paramRecordInputStream.remaining() >= 4) {
/* 103 */       this.field_6_rversion = paramRecordInputStream.readInt();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersion(int paramInt) {
/* 113 */     this.field_1_version = paramInt;
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
/*     */   public void setType(int paramInt) {
/* 127 */     this.field_2_type = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuild(int paramInt) {
/* 136 */     this.field_3_build = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBuildYear(int paramInt) {
/* 145 */     this.field_4_year = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHistoryBitMask(int paramInt) {
/* 154 */     this.field_5_history = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRequiredVersion(int paramInt) {
/* 164 */     this.field_6_rversion = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getVersion() {
/* 173 */     return this.field_1_version;
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
/*     */   public int getType() {
/* 187 */     return this.field_2_type;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBuild() {
/* 196 */     return this.field_3_build;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBuildYear() {
/* 205 */     return this.field_4_year;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHistoryBitMask() {
/* 214 */     return this.field_5_history;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getRequiredVersion() {
/* 224 */     return this.field_6_rversion;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 228 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 230 */     stringBuffer.append("[BOF RECORD]\n");
/* 231 */     stringBuffer.append("    .version  = ").append(HexDump.shortToHex(getVersion())).append("\n");
/* 232 */     stringBuffer.append("    .type     = ").append(HexDump.shortToHex(getType()));
/* 233 */     stringBuffer.append(" (").append(getTypeName()).append(")").append("\n");
/* 234 */     stringBuffer.append("    .build    = ").append(HexDump.shortToHex(getBuild())).append("\n");
/* 235 */     stringBuffer.append("    .buildyear= ").append(getBuildYear()).append("\n");
/* 236 */     stringBuffer.append("    .history  = ").append(HexDump.intToHex(getHistoryBitMask())).append("\n");
/* 237 */     stringBuffer.append("    .reqver   = ").append(HexDump.intToHex(getRequiredVersion())).append("\n");
/* 238 */     stringBuffer.append("[/BOF RECORD]\n");
/* 239 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   private String getTypeName() {
/* 243 */     switch (this.field_2_type) { case 32:
/* 244 */         return "chart";
/* 245 */       case 64: return "excel 4 macro";
/* 246 */       case 6: return "vb module";
/* 247 */       case 5: return "workbook";
/* 248 */       case 16: return "worksheet";
/* 249 */       case 256: return "workspace file"; }
/*     */     
/* 251 */     return "#error unknown type#";
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 255 */     paramLittleEndianOutput.writeShort(getVersion());
/* 256 */     paramLittleEndianOutput.writeShort(getType());
/* 257 */     paramLittleEndianOutput.writeShort(getBuild());
/* 258 */     paramLittleEndianOutput.writeShort(getBuildYear());
/* 259 */     paramLittleEndianOutput.writeInt(getHistoryBitMask());
/* 260 */     paramLittleEndianOutput.writeInt(getRequiredVersion());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 264 */     return 16;
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 268 */     return 2057;
/*     */   }
/*     */ 
/*     */   
/*     */   public BOFRecord clone() {
/* 273 */     BOFRecord bOFRecord = new BOFRecord();
/* 274 */     bOFRecord.field_1_version = this.field_1_version;
/* 275 */     bOFRecord.field_2_type = this.field_2_type;
/* 276 */     bOFRecord.field_3_build = this.field_3_build;
/* 277 */     bOFRecord.field_4_year = this.field_4_year;
/* 278 */     bOFRecord.field_5_history = this.field_5_history;
/* 279 */     bOFRecord.field_6_rversion = this.field_6_rversion;
/* 280 */     return bOFRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BOFRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */