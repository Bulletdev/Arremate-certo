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
/*    */ public final class PasswordRev4Record
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 444;
/*    */   private int field_1_password;
/*    */   
/*    */   public PasswordRev4Record(int paramInt) {
/* 33 */     this.field_1_password = paramInt;
/*    */   }
/*    */   
/*    */   public PasswordRev4Record(RecordInputStream paramRecordInputStream) {
/* 37 */     this.field_1_password = paramRecordInputStream.readShort();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setPassword(short paramShort) {
/* 46 */     this.field_1_password = paramShort;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 50 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 52 */     stringBuffer.append("[PROT4REVPASSWORD]\n");
/* 53 */     stringBuffer.append("    .password = ").append(HexDump.shortToHex(this.field_1_password)).append("\n");
/* 54 */     stringBuffer.append("[/PROT4REVPASSWORD]\n");
/* 55 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 59 */     paramLittleEndianOutput.writeShort(this.field_1_password);
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 63 */     return 2;
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 67 */     return 444;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\PasswordRev4Record.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */