/*    */ package org.apache.commons.text.translate;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ public final class CsvTranslators
/*    */ {
/*    */   private static final char CSV_DELIMITER = ',';
/*    */   private static final char CSV_QUOTE = '"';
/* 41 */   private static final String CSV_QUOTE_STR = String.valueOf('"');
/*    */   
/* 43 */   private static final String CSV_ESCAPED_QUOTE_STR = CSV_QUOTE_STR + CSV_QUOTE_STR;
/*    */   
/* 45 */   private static final char[] CSV_SEARCH_CHARS = new char[] { ',', '"', '\r', '\n' };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class CsvEscaper
/*    */     extends SinglePassTranslator
/*    */   {
/*    */     void translateWhole(CharSequence param1CharSequence, Writer param1Writer) throws IOException {
/* 58 */       String str = param1CharSequence.toString();
/* 59 */       if (StringUtils.containsNone(str, CsvTranslators.CSV_SEARCH_CHARS)) {
/* 60 */         param1Writer.write(str);
/*    */       } else {
/*    */         
/* 63 */         param1Writer.write(34);
/* 64 */         param1Writer.write(StringUtils.replace(str, CsvTranslators.CSV_QUOTE_STR, CsvTranslators.CSV_ESCAPED_QUOTE_STR));
/* 65 */         param1Writer.write(34);
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static class CsvUnescaper
/*    */     extends SinglePassTranslator
/*    */   {
/*    */     void translateWhole(CharSequence param1CharSequence, Writer param1Writer) throws IOException {
/* 78 */       if (param1CharSequence.charAt(0) != '"' || param1CharSequence.charAt(param1CharSequence.length() - 1) != '"') {
/* 79 */         param1Writer.write(param1CharSequence.toString());
/*    */         
/*    */         return;
/*    */       } 
/*    */       
/* 84 */       String str = param1CharSequence.subSequence(1, param1CharSequence.length() - 1).toString();
/*    */       
/* 86 */       if (StringUtils.containsAny(str, CsvTranslators.CSV_SEARCH_CHARS)) {
/*    */         
/* 88 */         param1Writer.write(StringUtils.replace(str, CsvTranslators.CSV_ESCAPED_QUOTE_STR, CsvTranslators.CSV_QUOTE_STR));
/*    */       } else {
/* 90 */         param1Writer.write(str);
/*    */       } 
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\translate\CsvTranslators.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */