/*    */ package ch.qos.logback.core.helpers;
/*    */ 
/*    */ import java.util.LinkedList;
/*    */ import java.util.List;
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
/*    */ public class ThrowableToStringArray
/*    */ {
/*    */   public static String[] convert(Throwable paramThrowable) {
/* 24 */     LinkedList<String> linkedList = new LinkedList();
/* 25 */     extract(linkedList, paramThrowable, null);
/* 26 */     return linkedList.<String>toArray(new String[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private static void extract(List<String> paramList, Throwable paramThrowable, StackTraceElement[] paramArrayOfStackTraceElement) {
/* 32 */     StackTraceElement[] arrayOfStackTraceElement = paramThrowable.getStackTrace();
/* 33 */     int i = findNumberOfCommonFrames(arrayOfStackTraceElement, paramArrayOfStackTraceElement);
/*    */     
/* 35 */     paramList.add(formatFirstLine(paramThrowable, paramArrayOfStackTraceElement));
/* 36 */     for (byte b = 0; b < arrayOfStackTraceElement.length - i; b++) {
/* 37 */       paramList.add("\tat " + arrayOfStackTraceElement[b].toString());
/*    */     }
/*    */     
/* 40 */     if (i != 0) {
/* 41 */       paramList.add("\t... " + i + " common frames omitted");
/*    */     }
/*    */     
/* 44 */     Throwable throwable = paramThrowable.getCause();
/* 45 */     if (throwable != null) {
/* 46 */       extract(paramList, throwable, arrayOfStackTraceElement);
/*    */     }
/*    */   }
/*    */   
/*    */   private static String formatFirstLine(Throwable paramThrowable, StackTraceElement[] paramArrayOfStackTraceElement) {
/* 51 */     String str1 = "";
/* 52 */     if (paramArrayOfStackTraceElement != null) {
/* 53 */       str1 = "Caused by: ";
/*    */     }
/*    */     
/* 56 */     String str2 = str1 + paramThrowable.getClass().getName();
/* 57 */     if (paramThrowable.getMessage() != null) {
/* 58 */       str2 = str2 + ": " + paramThrowable.getMessage();
/*    */     }
/* 60 */     return str2;
/*    */   }
/*    */   
/*    */   private static int findNumberOfCommonFrames(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2) {
/* 64 */     if (paramArrayOfStackTraceElement2 == null) {
/* 65 */       return 0;
/*    */     }
/*    */     
/* 68 */     int i = paramArrayOfStackTraceElement1.length - 1;
/* 69 */     int j = paramArrayOfStackTraceElement2.length - 1;
/* 70 */     byte b = 0;
/* 71 */     while (i >= 0 && j >= 0 && 
/* 72 */       paramArrayOfStackTraceElement1[i].equals(paramArrayOfStackTraceElement2[j])) {
/* 73 */       b++;
/*    */ 
/*    */ 
/*    */       
/* 77 */       i--;
/* 78 */       j--;
/*    */     } 
/* 80 */     return b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\helpers\ThrowableToStringArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */