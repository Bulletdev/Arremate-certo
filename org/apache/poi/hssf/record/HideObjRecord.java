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
/*    */ public final class HideObjRecord
/*    */   extends StandardRecord
/*    */ {
/*    */   public static final short sid = 141;
/*    */   public static final short HIDE_ALL = 2;
/*    */   public static final short SHOW_PLACEHOLDERS = 1;
/*    */   public static final short SHOW_ALL = 0;
/*    */   private short field_1_hide_obj;
/*    */   
/*    */   public HideObjRecord() {}
/*    */   
/*    */   public HideObjRecord(RecordInputStream paramRecordInputStream) {
/* 47 */     this.field_1_hide_obj = paramRecordInputStream.readShort();
/*    */   }
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
/*    */   public void setHideObj(short paramShort) {
/* 61 */     this.field_1_hide_obj = paramShort;
/*    */   }
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
/*    */   public short getHideObj() {
/* 75 */     return this.field_1_hide_obj;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 80 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 82 */     stringBuffer.append("[HIDEOBJ]\n");
/* 83 */     stringBuffer.append("    .hideobj         = ").append(Integer.toHexString(getHideObj())).append("\n");
/*    */     
/* 85 */     stringBuffer.append("[/HIDEOBJ]\n");
/* 86 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public void serialize(LittleEndianOutput paramLittleEndianOutput) {
/* 90 */     paramLittleEndianOutput.writeShort(getHideObj());
/*    */   }
/*    */   
/*    */   protected int getDataSize() {
/* 94 */     return 2;
/*    */   }
/*    */ 
/*    */   
/*    */   public short getSid() {
/* 99 */     return 141;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HideObjRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */