/*    */ package org.apache.poi.ss.usermodel;
/*    */ 
/*    */ import java.util.regex.Pattern;
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
/*    */ public interface Table
/*    */ {
/* 34 */   public static final Pattern isStructuredReference = Pattern.compile("[a-zA-Z_\\\\][a-zA-Z0-9._]*\\[.*\\]");
/*    */   
/*    */   int getStartColIndex();
/*    */   
/*    */   int getStartRowIndex();
/*    */   
/*    */   int getEndColIndex();
/*    */   
/*    */   int getEndRowIndex();
/*    */   
/*    */   String getName();
/*    */   
/*    */   int findColumnIndex(String paramString);
/*    */   
/*    */   String getSheetName();
/*    */   
/*    */   boolean isHasTotalsRow();
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\Table.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */