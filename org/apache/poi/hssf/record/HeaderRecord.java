/*    */ package org.apache.poi.hssf.record;
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
/*    */ public final class HeaderRecord
/*    */   extends HeaderFooterBase
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 20;
/*    */   
/*    */   public HeaderRecord(String paramString) {
/* 32 */     super(paramString);
/*    */   }
/*    */   
/*    */   public HeaderRecord(RecordInputStream paramRecordInputStream) {
/* 36 */     super(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 40 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 42 */     stringBuffer.append("[HEADER]\n");
/* 43 */     stringBuffer.append("    .header = ").append(getText()).append("\n");
/* 44 */     stringBuffer.append("[/HEADER]\n");
/* 45 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 49 */     return 20;
/*    */   }
/*    */ 
/*    */   
/*    */   public HeaderRecord clone() {
/* 54 */     return new HeaderRecord(getText());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\HeaderRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */