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
/*     */ public final class GridsetRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 130;
/*     */   public short field_1_gridset_flag;
/*     */   
/*     */   public GridsetRecord() {}
/*     */   
/*     */   public GridsetRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     this.field_1_gridset_flag = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setGridset(boolean paramBoolean) {
/*  58 */     if (paramBoolean == true) {
/*     */       
/*  60 */       this.field_1_gridset_flag = 1;
/*     */     }
/*     */     else {
/*     */       
/*  64 */       this.field_1_gridset_flag = 0;
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
/*     */   public boolean getGridset() {
/*  76 */     return (this.field_1_gridset_flag == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  81 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  83 */     stringBuffer.append("[GRIDSET]\n");
/*  84 */     stringBuffer.append("    .gridset        = ").append(getGridset()).append("\n");
/*     */     
/*  86 */     stringBuffer.append("[/GRIDSET]\n");
/*  87 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  91 */     paramLittleEndianOutput.writeShort(this.field_1_gridset_flag);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  95 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/* 100 */     return 130;
/*     */   }
/*     */ 
/*     */   
/*     */   public GridsetRecord clone() {
/* 105 */     GridsetRecord gridsetRecord = new GridsetRecord();
/* 106 */     gridsetRecord.field_1_gridset_flag = this.field_1_gridset_flag;
/* 107 */     return gridsetRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\GridsetRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */