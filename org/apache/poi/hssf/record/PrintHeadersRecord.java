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
/*     */ public final class PrintHeadersRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 42;
/*     */   private short field_1_print_headers;
/*     */   
/*     */   public PrintHeadersRecord() {}
/*     */   
/*     */   public PrintHeadersRecord(RecordInputStream paramRecordInputStream) {
/*  46 */     this.field_1_print_headers = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrintHeaders(boolean paramBoolean) {
/*  56 */     if (paramBoolean == true) {
/*     */       
/*  58 */       this.field_1_print_headers = 1;
/*     */     }
/*     */     else {
/*     */       
/*  62 */       this.field_1_print_headers = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getPrintHeaders() {
/*  73 */     return (this.field_1_print_headers == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  78 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  80 */     stringBuffer.append("[PRINTHEADERS]\n");
/*  81 */     stringBuffer.append("    .printheaders   = ").append(getPrintHeaders()).append("\n");
/*     */     
/*  83 */     stringBuffer.append("[/PRINTHEADERS]\n");
/*  84 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  88 */     paramLittleEndianOutput.writeShort(this.field_1_print_headers);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  92 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  97 */     return 42;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 101 */     PrintHeadersRecord printHeadersRecord = new PrintHeadersRecord();
/* 102 */     printHeadersRecord.field_1_print_headers = this.field_1_print_headers;
/* 103 */     return printHeadersRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PrintHeadersRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */