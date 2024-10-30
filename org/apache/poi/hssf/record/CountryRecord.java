/*     */ package org.apache.poi.hssf.record;
/*     */ 
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
/*     */ public final class CountryRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 140;
/*     */   private short field_1_default_country;
/*     */   private short field_2_current_country;
/*     */   
/*     */   public CountryRecord() {}
/*     */   
/*     */   public CountryRecord(RecordInputStream paramRecordInputStream) {
/*  49 */     this.field_1_default_country = paramRecordInputStream.readShort();
/*  50 */     this.field_2_current_country = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDefaultCountry(short paramShort) {
/*  61 */     this.field_1_default_country = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCurrentCountry(short paramShort) {
/*  72 */     this.field_2_current_country = paramShort;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getDefaultCountry() {
/*  83 */     return this.field_1_default_country;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getCurrentCountry() {
/*  94 */     return this.field_2_current_country;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  99 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 101 */     stringBuffer.append("[COUNTRY]\n");
/* 102 */     stringBuffer.append("    .defaultcountry  = ").append(Integer.toHexString(getDefaultCountry())).append("\n");
/*     */     
/* 104 */     stringBuffer.append("    .currentcountry  = ").append(Integer.toHexString(getCurrentCountry())).append("\n");
/*     */     
/* 106 */     stringBuffer.append("[/COUNTRY]\n");
/* 107 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 111 */     paramLittleEndianOutput.writeShort(getDefaultCountry());
/* 112 */     paramLittleEndianOutput.writeShort(getCurrentCountry());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/* 116 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 121 */     return 140;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CountryRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */