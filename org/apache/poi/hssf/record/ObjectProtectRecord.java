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
/*     */ public final class ObjectProtectRecord
/*     */   extends StandardRecord
/*     */   implements Cloneable
/*     */ {
/*     */   public static final short sid = 99;
/*     */   private short field_1_protect;
/*     */   
/*     */   public ObjectProtectRecord() {}
/*     */   
/*     */   public ObjectProtectRecord(RecordInputStream paramRecordInputStream) {
/*  44 */     this.field_1_protect = paramRecordInputStream.readShort();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProtect(boolean paramBoolean) {
/*  54 */     if (paramBoolean) {
/*     */       
/*  56 */       this.field_1_protect = 1;
/*     */     }
/*     */     else {
/*     */       
/*  60 */       this.field_1_protect = 0;
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
/*  71 */     return (this.field_1_protect == 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/*  76 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/*  78 */     stringBuffer.append("[SCENARIOPROTECT]\n");
/*  79 */     stringBuffer.append("    .protect         = ").append(getProtect()).append("\n");
/*     */     
/*  81 */     stringBuffer.append("[/SCENARIOPROTECT]\n");
/*  82 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/*  86 */     paramLittleEndianOutput.writeShort(this.field_1_protect);
/*     */   }
/*     */   
/*     */   protected int getDataSize() {
/*  90 */     return 2;
/*     */   }
/*     */ 
/*     */   
/*     */   public short getSid() {
/*  95 */     return 99;
/*     */   }
/*     */ 
/*     */   
/*     */   public ObjectProtectRecord clone() {
/* 100 */     ObjectProtectRecord objectProtectRecord = new ObjectProtectRecord();
/* 101 */     objectProtectRecord.field_1_protect = this.field_1_protect;
/* 102 */     return objectProtectRecord;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\ObjectProtectRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */