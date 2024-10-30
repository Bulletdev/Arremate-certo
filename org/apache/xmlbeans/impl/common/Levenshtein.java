/*    */ package org.apache.xmlbeans.impl.common;
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
/*    */ public class Levenshtein
/*    */ {
/*    */   private static int minimum(int paramInt1, int paramInt2, int paramInt3) {
/* 26 */     int i = paramInt1;
/* 27 */     if (paramInt2 < i)
/* 28 */       i = paramInt2; 
/* 29 */     if (paramInt3 < i)
/* 30 */       i = paramInt3; 
/* 31 */     return i;
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
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int distance(String paramString1, String paramString2) {
/* 49 */     int i = paramString1.length();
/* 50 */     int j = paramString2.length();
/* 51 */     if (i == 0)
/* 52 */       return j; 
/* 53 */     if (j == 0)
/* 54 */       return i; 
/* 55 */     int[][] arrayOfInt = new int[i + 1][j + 1];
/*    */     
/*    */     byte b1;
/* 58 */     for (b1 = 0; b1 <= i; b1++)
/* 59 */       arrayOfInt[b1][0] = b1;  byte b2;
/* 60 */     for (b2 = 0; b2 <= j; b2++) {
/* 61 */       arrayOfInt[0][b2] = b2;
/*    */     }
/*    */     
/* 64 */     for (b1 = 1; b1 <= i; b1++) {
/*    */       
/* 66 */       char c = paramString1.charAt(b1 - 1);
/*    */ 
/*    */       
/* 69 */       for (b2 = 1; b2 <= j; b2++) {
/*    */         byte b;
/* 71 */         char c1 = paramString2.charAt(b2 - 1);
/*    */ 
/*    */         
/* 74 */         if (c == c1) {
/* 75 */           b = 0;
/*    */         } else {
/* 77 */           b = 1;
/*    */         } 
/*    */         
/* 80 */         arrayOfInt[b1][b2] = minimum(arrayOfInt[b1 - 1][b2] + 1, arrayOfInt[b1][b2 - 1] + 1, arrayOfInt[b1 - 1][b2 - 1] + b);
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 85 */     return arrayOfInt[i][j];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\Levenshtein.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */