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
/*     */ public final class PrintGridlinesRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 43;
/*     */   private short field_1_print_gridlines;
/*     */   
/*     */   public PrintGridlinesRecord() {}
/*     */   
/*     */   public PrintGridlinesRecord(RecordInputStream paramRecordInputStream) {
/*  45 */     this.field_1_print_gridlines = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrintGridlines(boolean paramBoolean) {
/*  56 */     if (paramBoolean == true) {
/*     */       
/*  58 */       this.field_1_print_gridlines = 1;
/*     */     }
/*     */     else {
/*     */       
/*  62 */       this.field_1_print_gridlines = 0;
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
/*     */   public boolean getPrintGridlines() {
/*  74 */     return (this.field_1_print_gridlines == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  81 */     stringBuffer.append("[PRINTGRIDLINES]\n");
/*  82 */     stringBuffer.append("    .printgridlines = ").append(getPrintGridlines()).append("\n");
/*     */     
/*  84 */     stringBuffer.append("[/PRINTGRIDLINES]\n");
/*  85 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  89 */     paramLittleEndianOutput.writeShort(this.field_1_print_gridlines);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  93 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  98 */     return 43;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 102 */     PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
/* 103 */     printGridlinesRecord.field_1_print_gridlines = this.field_1_print_gridlines;
/* 104 */     return printGridlinesRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PrintGridlinesRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */