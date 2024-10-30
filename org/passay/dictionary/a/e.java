/*    */ package org.passay.dictionary.a;
/*    */ 
/*    */ import java.util.Comparator;
/*    */ import org.passay.dictionary.l;
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
/*    */ public class e
/*    */   implements a
/*    */ {
/*    */   public void l(String[] paramArrayOfString) {
/* 19 */     a(paramArrayOfString, l.m);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void a(String[] paramArrayOfString, Comparator<String> paramComparator) {
/* 26 */     if (paramArrayOfString.length > 0) {
/* 27 */       a(paramArrayOfString, paramComparator, 0, paramArrayOfString.length - 1);
/*    */     }
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
/*    */   public static void a(String[] paramArrayOfString, Comparator<String> paramComparator, int paramInt1, int paramInt2) {
/* 43 */     int i = (paramInt1 + paramInt2) / 2;
/* 44 */     String str = paramArrayOfString[i];
/*    */     
/* 46 */     int j = paramInt1;
/* 47 */     int k = paramInt2;
/*    */     do {
/* 49 */       while (paramComparator.compare(str, paramArrayOfString[j]) > 0) {
/* 50 */         j++;
/*    */       }
/*    */       
/* 53 */       while (paramComparator.compare(str, paramArrayOfString[k]) < 0) {
/* 54 */         k--;
/*    */       }
/*    */       
/* 57 */       if (j > k)
/* 58 */         continue;  String str1 = paramArrayOfString[j];
/* 59 */       paramArrayOfString[j] = paramArrayOfString[k];
/* 60 */       paramArrayOfString[k] = str1;
/* 61 */       j++;
/* 62 */       k--;
/*    */     }
/* 64 */     while (j <= k);
/*    */     
/* 66 */     if (paramInt1 < k) {
/* 67 */       a(paramArrayOfString, paramComparator, paramInt1, k);
/*    */     }
/* 69 */     if (j < paramInt2)
/* 70 */       a(paramArrayOfString, paramComparator, j, paramInt2); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\a\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */