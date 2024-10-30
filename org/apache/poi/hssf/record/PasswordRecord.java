/*    */ package org.apache.poi.hssf.record;
/*    */ 
/*    */ import org.apache.poi.util.HexDump;
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
/*    */ public final class PasswordRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 19;
/*    */   private int field_1_password;
/*    */   
/*    */   public PasswordRecord(int paramInt) {
/* 33 */     this.field_1_password = paramInt;
/*    */   }
/*    */   
/*    */   public PasswordRecord(RecordInputStream paramRecordInputStream) {
/* 37 */     this.field_1_password = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPassword(int paramInt) {
/* 47 */     this.field_1_password = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPassword() {
/* 56 */     return this.field_1_password;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 60 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 62 */     stringBuffer.append("[PASSWORD]\n");
/* 63 */     stringBuffer.append("    .password = ").append(HexDump.shortToHex(this.field_1_password)).append("\n");
/* 64 */     stringBuffer.append("[/PASSWORD]\n");
/* 65 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 69 */     paramLittleEndianOutput.writeShort(this.field_1_password);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 73 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 77 */     return 19;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Object clone() {
/* 84 */     return new PasswordRecord(this.field_1_password);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PasswordRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */