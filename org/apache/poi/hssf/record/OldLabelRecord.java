/*     */ package org.apache.poi.hssf.record;
/*     */ 
/*     */ import org.apache.poi.util.HexDump;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class OldLabelRecord
/*     */   extends OldCellRecord
/*     */ {
/*  30 */   private static final POILogger logger = POILogFactory.getLogger(OldLabelRecord.class);
/*     */   
/*     */   public static final short biff2_sid = 4;
/*     */   
/*     */   public static final short biff345_sid = 516;
/*     */   
/*     */   private short field_4_string_len;
/*     */   
/*     */   private final byte[] field_5_bytes;
/*     */   
/*     */   private CodepageRecord codepage;
/*     */ 
/*     */   
/*     */   public OldLabelRecord(RecordInputStream paramRecordInputStream) {
/*  44 */     super(paramRecordInputStream, (paramRecordInputStream.getSid() == 4));
/*     */     
/*  46 */     if (isBiff2()) {
/*  47 */       this.field_4_string_len = (short)paramRecordInputStream.readUByte();
/*     */     } else {
/*  49 */       this.field_4_string_len = paramRecordInputStream.readShort();
/*     */     } 
/*     */ 
/*     */     
/*  53 */     this.field_5_bytes = new byte[this.field_4_string_len];
/*  54 */     paramRecordInputStream.read(this.field_5_bytes, 0, this.field_4_string_len);
/*     */     
/*  56 */     if (paramRecordInputStream.remaining() > 0) {
/*  57 */       logger.log(3, new Object[] { "LabelRecord data remains: " + paramRecordInputStream.remaining() + " : " + HexDump.toHex(paramRecordInputStream.readRemainder()) });
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodePage(CodepageRecord paramCodepageRecord) {
/*  65 */     this.codepage = paramCodepageRecord;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getStringLength() {
/*  74 */     return this.field_4_string_len;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getValue() {
/*  84 */     return OldStringRecord.getString(this.field_5_bytes, this.codepage);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int serialize(int paramInt, byte[] paramArrayOfbyte) {
/*  95 */     throw new RecordFormatException("Old Label Records are supported READ ONLY");
/*     */   }
/*     */   
/*     */   public int getRecordSize() {
/*  99 */     throw new RecordFormatException("Old Label Records are supported READ ONLY");
/*     */   }
/*     */ 
/*     */   
/*     */   protected void appendValueText(StringBuilder paramStringBuilder) {
/* 104 */     paramStringBuilder.append("    .string_len= ").append(HexDump.shortToHex(this.field_4_string_len)).append("\n");
/* 105 */     paramStringBuilder.append("    .value       = ").append(getValue()).append("\n");
/*     */   }
/*     */ 
/*     */   
/*     */   protected String getRecordName() {
/* 110 */     return "OLD LABEL";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\OldLabelRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */