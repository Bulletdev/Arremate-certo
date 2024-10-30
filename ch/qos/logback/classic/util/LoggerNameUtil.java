/*    */ package ch.qos.logback.classic.util;
/*    */ 
/*    */ import java.util.ArrayList;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoggerNameUtil
/*    */ {
/*    */   public static int getFirstSeparatorIndexOf(String paramString) {
/* 27 */     return getSeparatorIndexOf(paramString, 0);
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
/*    */   public static int getSeparatorIndexOf(String paramString, int paramInt) {
/* 39 */     int i = paramString.indexOf('.', paramInt);
/* 40 */     int j = paramString.indexOf('$', paramInt);
/*    */     
/* 42 */     if (i == -1 && j == -1)
/* 43 */       return -1; 
/* 44 */     if (i == -1)
/* 45 */       return j; 
/* 46 */     if (j == -1) {
/* 47 */       return i;
/*    */     }
/* 49 */     return (i < j) ? i : j;
/*    */   }
/*    */   
/*    */   public static List<String> computeNameParts(String paramString) {
/* 53 */     ArrayList<String> arrayList = new ArrayList();
/*    */     
/* 55 */     int i = 0;
/*    */     while (true) {
/* 57 */       int j = getSeparatorIndexOf(paramString, i);
/* 58 */       if (j == -1) {
/* 59 */         arrayList.add(paramString.substring(i));
/*    */         break;
/*    */       } 
/* 62 */       arrayList.add(paramString.substring(i, j));
/* 63 */       i = j + 1;
/*    */     } 
/* 65 */     return arrayList;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classi\\util\LoggerNameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */