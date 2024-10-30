/*    */ package org.apache.poi.ss.format;
/*    */ 
/*    */ import java.util.logging.Logger;
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
/*    */ public abstract class CellFormatter
/*    */ {
/*    */   protected final String format;
/*    */   
/*    */   public CellFormatter(String paramString) {
/* 36 */     this.format = paramString;
/*    */   }
/*    */ 
/*    */   
/* 40 */   static final Logger logger = Logger.getLogger(CellFormatter.class.getName());
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void formatValue(StringBuffer paramStringBuffer, Object paramObject);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract void simpleValue(StringBuffer paramStringBuffer, Object paramObject);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String format(Object paramObject) {
/* 67 */     StringBuffer stringBuffer = new StringBuffer();
/* 68 */     formatValue(stringBuffer, paramObject);
/* 69 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String simpleFormat(Object paramObject) {
/* 80 */     StringBuffer stringBuffer = new StringBuffer();
/* 81 */     simpleValue(stringBuffer, paramObject);
/* 82 */     return stringBuffer.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static String quote(String paramString) {
/* 93 */     return '"' + paramString + '"';
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\format\CellFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */