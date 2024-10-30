/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.LittleEndianOutput;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class BackupRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 64;
/*    */   private short field_1_backup;
/*    */   
/*    */   public BackupRecord() {}
/*    */   
/*    */   public BackupRecord(RecordInputStream paramRecordInputStream) {
/* 45 */     this.field_1_backup = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setBackup(short paramShort) {
/* 56 */     this.field_1_backup = paramShort;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public short getBackup() {
/* 67 */     return this.field_1_backup;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 72 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 74 */     stringBuffer.append("[BACKUP]\n");
/* 75 */     stringBuffer.append("    .backup          = ").append(Integer.toHexString(getBackup())).append("\n");
/*    */     
/* 77 */     stringBuffer.append("[/BACKUP]\n");
/* 78 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 82 */     paramLittleEndianOutput.writeShort(getBackup());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 86 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 91 */     return 64;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\BackupRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */