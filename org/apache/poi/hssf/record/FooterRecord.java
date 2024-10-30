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
/*    */ public final class FooterRecord
/*    */   extends HeaderFooterBase
/*    */   implements Cloneable
/*    */ {
/*    */   public static final short sid = 21;
/*    */   
/*    */   public FooterRecord(String paramString) {
/* 29 */     super(paramString);
/*    */   }
/*    */   
/*    */   public FooterRecord(RecordInputStream paramRecordInputStream) {
/* 33 */     super(paramRecordInputStream);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 37 */     StringBuffer stringBuffer = new StringBuffer();
/*    */     
/* 39 */     stringBuffer.append("[FOOTER]\n");
/* 40 */     stringBuffer.append("    .footer = ").append(getText()).append("\n");
/* 41 */     stringBuffer.append("[/FOOTER]\n");
/* 42 */     return stringBuffer.toString();
/*    */   }
/*    */   
/*    */   public short getSid() {
/* 46 */     return 21;
/*    */   }
/*    */ 
/*    */   
/*    */   public FooterRecord clone() {
/* 51 */     return new FooterRecord(getText());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hssf\record\FooterRecord.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */