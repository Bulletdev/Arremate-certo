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
/*     */ public final class ScenarioProtectRecord
/*     */   extends StandardRecord
/*     */ {
/*     */   public static final short sid = 221;
/*     */   private short field_1_protect;
/*     */   
/*     */   public ScenarioProtectRecord() {}
/*     */   
/*     */   public ScenarioProtectRecord(RecordInputStream paramRecordInputStream) {
/*  47 */     this.field_1_protect = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProtect(boolean paramBoolean) {
/*  57 */     if (paramBoolean) {
/*     */       
/*  59 */       this.field_1_protect = 1;
/*     */     }
/*     */     else {
/*     */       
/*  63 */       this.field_1_protect = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getProtect() {
/*  74 */     return (this.field_1_protect == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  79 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  81 */     stringBuffer.append("[SCENARIOPROTECT]\n");
/*  82 */     stringBuffer.append("    .protect         = ").append(getProtect()).append("\n");
/*     */     
/*  84 */     stringBuffer.append("[/SCENARIOPROTECT]\n");
/*  85 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  89 */     paramLittleEndianOutput.writeShort(this.field_1_protect);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  93 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  98 */     return 221;
/*     */   }
/*     */   
/*     */   public Object clone() {
/* 102 */     ScenarioProtectRecord scenarioProtectRecord = new ScenarioProtectRecord();
/* 103 */     scenarioProtectRecord.field_1_protect = this.field_1_protect;
/* 104 */     return scenarioProtectRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ScenarioProtectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */