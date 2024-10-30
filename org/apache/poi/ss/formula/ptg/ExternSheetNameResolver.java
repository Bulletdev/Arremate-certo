/*    */ package org.apache.poi.ss.formula.ptg;
/*    */ 
/*    */ import org.apache.poi.ss.formula.EvaluationWorkbook;
/*    */ import org.apache.poi.ss.formula.FormulaRenderingWorkbook;
/*    */ import org.apache.poi.ss.formula.SheetNameFormatter;
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
/*    */ final class ExternSheetNameResolver
/*    */ {
/*    */   public static String prependSheetName(FormulaRenderingWorkbook paramFormulaRenderingWorkbook, int paramInt, String paramString) {
/*    */     StringBuffer stringBuffer;
/* 34 */     EvaluationWorkbook.ExternalSheet externalSheet = paramFormulaRenderingWorkbook.getExternalSheet(paramInt);
/*    */     
/* 36 */     if (externalSheet != null) {
/* 37 */       String str1 = externalSheet.getWorkbookName();
/* 38 */       String str2 = externalSheet.getSheetName();
/* 39 */       if (str1 != null) {
/* 40 */         stringBuffer = new StringBuffer(str1.length() + str2.length() + paramString.length() + 4);
/* 41 */         SheetNameFormatter.appendFormat(stringBuffer, str1, str2);
/*    */       } else {
/* 43 */         stringBuffer = new StringBuffer(str2.length() + paramString.length() + 4);
/* 44 */         SheetNameFormatter.appendFormat(stringBuffer, str2);
/*    */       } 
/* 46 */       if (externalSheet instanceof EvaluationWorkbook.ExternalSheetRange) {
/* 47 */         EvaluationWorkbook.ExternalSheetRange externalSheetRange = (EvaluationWorkbook.ExternalSheetRange)externalSheet;
/* 48 */         if (!externalSheetRange.getFirstSheetName().equals(externalSheetRange.getLastSheetName())) {
/* 49 */           stringBuffer.append(':');
/* 50 */           SheetNameFormatter.appendFormat(stringBuffer, externalSheetRange.getLastSheetName());
/*    */         } 
/*    */       } 
/*    */     } else {
/* 54 */       String str1 = paramFormulaRenderingWorkbook.getSheetFirstNameByExternSheet(paramInt);
/* 55 */       String str2 = paramFormulaRenderingWorkbook.getSheetLastNameByExternSheet(paramInt);
/* 56 */       stringBuffer = new StringBuffer(str1.length() + paramString.length() + 4);
/* 57 */       if (str1.length() < 1) {
/*    */         
/* 59 */         stringBuffer.append("#REF");
/*    */       } else {
/* 61 */         SheetNameFormatter.appendFormat(stringBuffer, str1);
/* 62 */         if (!str1.equals(str2)) {
/* 63 */           stringBuffer.append(':');
/* 64 */           stringBuffer.append(str2);
/*    */         } 
/*    */       } 
/*    */     } 
/* 68 */     stringBuffer.append('!');
/* 69 */     stringBuffer.append(paramString);
/* 70 */     return stringBuffer.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\ss\formula\ptg\ExternSheetNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */