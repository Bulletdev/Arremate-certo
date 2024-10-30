/*    */ package ch.qos.logback.classic.spi;
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
/*    */ public class STEUtil
/*    */ {
/*    */   static int UNUSED_findNumberOfCommonFrames(StackTraceElement[] paramArrayOfStackTraceElement1, StackTraceElement[] paramArrayOfStackTraceElement2) {
/* 19 */     if (paramArrayOfStackTraceElement2 == null) {
/* 20 */       return 0;
/*    */     }
/*    */     
/* 23 */     int i = paramArrayOfStackTraceElement1.length - 1;
/* 24 */     int j = paramArrayOfStackTraceElement2.length - 1;
/* 25 */     byte b = 0;
/* 26 */     while (i >= 0 && j >= 0 && 
/* 27 */       paramArrayOfStackTraceElement1[i].equals(paramArrayOfStackTraceElement2[j])) {
/* 28 */       b++;
/*    */ 
/*    */ 
/*    */       
/* 32 */       i--;
/* 33 */       j--;
/*    */     } 
/* 35 */     return b;
/*    */   }
/*    */   
/*    */   static int findNumberOfCommonFrames(StackTraceElement[] paramArrayOfStackTraceElement, StackTraceElementProxy[] paramArrayOfStackTraceElementProxy) {
/* 39 */     if (paramArrayOfStackTraceElementProxy == null) {
/* 40 */       return 0;
/*    */     }
/*    */     
/* 43 */     int i = paramArrayOfStackTraceElement.length - 1;
/* 44 */     int j = paramArrayOfStackTraceElementProxy.length - 1;
/* 45 */     byte b = 0;
/* 46 */     while (i >= 0 && j >= 0 && 
/* 47 */       paramArrayOfStackTraceElement[i].equals((paramArrayOfStackTraceElementProxy[j]).ste)) {
/* 48 */       b++;
/*    */ 
/*    */ 
/*    */       
/* 52 */       i--;
/* 53 */       j--;
/*    */     } 
/* 55 */     return b;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\spi\STEUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */