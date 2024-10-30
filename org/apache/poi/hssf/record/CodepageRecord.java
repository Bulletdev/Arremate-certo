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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CodepageRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 66;
/*     */   private short field_1_codepage;
/*     */   public static final short CODEPAGE = 1200;
/*     */   
/*     */   public CodepageRecord() {}
/*     */   
/*     */   public CodepageRecord(RecordInputStream paramRecordInputStream) {
/*  53 */     this.field_1_codepage = paramRecordInputStream.readShort();
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
/*     */   public void setCodepage(short paramShort) {
/*  65 */     this.field_1_codepage = paramShort;
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
/*     */   public short getCodepage() {
/*  77 */     return this.field_1_codepage;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  82 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  84 */     stringBuffer.append("[CODEPAGE]\n");
/*  85 */     stringBuffer.append("    .codepage        = ").append(Integer.toHexString(getCodepage())).append("\n");
/*     */     
/*  87 */     stringBuffer.append("[/CODEPAGE]\n");
/*  88 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  92 */     paramLittleEndianOutput.writeShort(getCodepage());
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  96 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 101 */     return 66;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\CodepageRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */