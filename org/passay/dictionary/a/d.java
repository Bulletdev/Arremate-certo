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
/*    */ public class d
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
/* 26 */     int i = paramArrayOfString.length;
/* 27 */     for (byte b = 1; b < i; b++) {
/* 28 */       int j = b - 1;
/* 29 */       String str1 = paramArrayOfString[b];
/*    */       
/*    */       String str2;
/* 32 */       while (j >= 0 && paramComparator.compare(str1, str2 = paramArrayOfString[j]) < 0) {
/* 33 */         paramArrayOfString[j + 1] = str2;
/* 34 */         j--;
/*    */       } 
/*    */       
/* 37 */       paramArrayOfString[j + 1] = str1;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\a\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */