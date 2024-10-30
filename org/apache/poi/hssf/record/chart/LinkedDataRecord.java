/*     */ package org.apache.poi.hssf.record.chart;
/*     */ 
/*     */ import org.apache.poi.hssf.record.RecordInputStream;
/*     */ import org.apache.poi.hssf.record.StandardRecord;
/*     */ import org.apache.poi.ss.formula.Formula;
/*     */ import org.apache.poi.ss.formula.ptg.Ptg;
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
/*     */ public final class LinkedDataRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 4177;
/*  35 */   private static final BitField customNumberFormat = BitFieldFactory.getInstance(1);
/*     */   
/*     */   private byte field_1_linkType;
/*     */   
/*     */   public static final byte LINK_TYPE_TITLE_OR_TEXT = 0;
/*     */   
/*     */   public static final byte LINK_TYPE_VALUES = 1;
/*     */   
/*     */   public static final byte LINK_TYPE_CATEGORIES = 2;
/*     */   
/*     */   public static final byte LINK_TYPE_SECONDARY_CATEGORIES = 3;
/*     */   
/*     */   private byte field_2_referenceType;
/*     */   public static final byte REFERENCE_TYPE_DEFAULT_CATEGORIES = 0;
/*     */   public static final byte REFERENCE_TYPE_DIRECT = 1;
/*     */   public static final byte REFERENCE_TYPE_WORKSHEET = 2;
/*     */   public static final byte REFERENCE_TYPE_NOT_USED = 3;
/*     */   public static final byte REFERENCE_TYPE_ERROR_REPORTED = 4;
/*     */   private short field_3_options;
/*     */   private short field_4_indexNumberFmtRecord;
/*     */   private Formula field_5_formulaOfLink;
/*     */   
/*     */   public LinkedDataRecord() {}
/*     */   
/*     */   public LinkedDataRecord(RecordInputStream paramRecordInputStream) {
/*  60 */     this.field_1_linkType = paramRecordInputStream.readByte();
/*  61 */     this.field_2_referenceType = paramRecordInputStream.readByte();
/*  62 */     this.field_3_options = paramRecordInputStream.readShort();
/*  63 */     this.field_4_indexNumberFmtRecord = paramRecordInputStream.readShort();
/*  64 */     int i = paramRecordInputStream.readUShort();
/*  65 */     this.field_5_formulaOfLink = Formula.read(i, (LittleEndianInput)paramRecordInputStream);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  69 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  71 */     stringBuffer.append("[AI]\n");
/*  72 */     stringBuffer.append("    .linkType             = ").append(HexDump.byteToHex(getLinkType())).append('\n');
/*  73 */     stringBuffer.append("    .referenceType        = ").append(HexDump.byteToHex(getReferenceType())).append('\n');
/*  74 */     stringBuffer.append("    .options              = ").append(HexDump.shortToHex(getOptions())).append('\n');
/*  75 */     stringBuffer.append("    .customNumberFormat   = ").append(isCustomNumberFormat()).append('\n');
/*  76 */     stringBuffer.append("    .indexNumberFmtRecord = ").append(HexDump.shortToHex(getIndexNumberFmtRecord())).append('\n');
/*  77 */     stringBuffer.append("    .formulaOfLink        = ").append('\n');
/*  78 */     Ptg[] arrayOfPtg = this.field_5_formulaOfLink.getTokens();
/*  79 */     for (byte b = 0; b < arrayOfPtg.length; b++) {
/*  80 */       Ptg ptg = arrayOfPtg[b];
/*  81 */       stringBuffer.append(ptg.toString()).append(ptg.getRVAType()).append('\n');
/*     */     } 
/*     */     
/*  84 */     stringBuffer.append("[/AI]\n");
/*  85 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  89 */     paramLittleEndianOutput.writeByte(this.field_1_linkType);
/*  90 */     paramLittleEndianOutput.writeByte(this.field_2_referenceType);
/*  91 */     paramLittleEndianOutput.writeShort(this.field_3_options);
/*  92 */     paramLittleEndianOutput.writeShort(this.field_4_indexNumberFmtRecord);
/*  93 */     this.field_5_formulaOfLink.serialize(paramLittleEndianOutput);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  97 */     return 6 + this.field_5_formulaOfLink.getEncodedSize();
/*     */   }
/*     */   
/*     */   public short getSid() {
/* 101 */     return 4177;
/*     */   }
/*     */ 
/*     */   
/*     */   public LinkedDataRecord clone() {
/* 106 */     LinkedDataRecord linkedDataRecord = new LinkedDataRecord();
/*     */     
/* 108 */     linkedDataRecord.field_1_linkType = this.field_1_linkType;
/* 109 */     linkedDataRecord.field_2_referenceType = this.field_2_referenceType;
/* 110 */     linkedDataRecord.field_3_options = this.field_3_options;
/* 111 */     linkedDataRecord.field_4_indexNumberFmtRecord = this.field_4_indexNumberFmtRecord;
/* 112 */     linkedDataRecord.field_5_formulaOfLink = this.field_5_formulaOfLink.copy();
/* 113 */     return linkedDataRecord;
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
/*     */   public byte getLinkType() {
/* 130 */     return this.field_1_linkType;
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
/*     */   public void setLinkType(byte paramByte) {
/* 145 */     this.field_1_linkType = paramByte;
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
/*     */   public byte getReferenceType() {
/* 160 */     return this.field_2_referenceType;
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
/*     */   public void setReferenceType(byte paramByte) {
/* 176 */     this.field_2_referenceType = paramByte;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getOptions() {
/* 184 */     return this.field_3_options;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOptions(short paramShort) {
/* 192 */     this.field_3_options = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getIndexNumberFmtRecord() {
/* 200 */     return this.field_4_indexNumberFmtRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIndexNumberFmtRecord(short paramShort) {
/* 208 */     this.field_4_indexNumberFmtRecord = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Ptg[] getFormulaOfLink() {
/* 215 */     return this.field_5_formulaOfLink.getTokens();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormulaOfLink(Ptg[] paramArrayOfPtg) {
/* 223 */     this.field_5_formulaOfLink = Formula.create(paramArrayOfPtg);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomNumberFormat(boolean paramBoolean) {
/* 232 */     this.field_3_options = customNumberFormat.setShortBoolean(this.field_3_options, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCustomNumberFormat() {
/* 241 */     return customNumberFormat.isSet(this.field_3_options);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\chart\LinkedDataRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */