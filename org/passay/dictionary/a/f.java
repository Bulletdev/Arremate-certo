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
/*    */ public class f
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
/* 27 */     for (byte b = 0; b < i - 1; b++) {
/* 28 */       int j = b;
/* 29 */       for (int k = b + 1; k < i; k++) {
/* 30 */         String str1 = paramArrayOfString[k];
/* 31 */         if (paramComparator.compare(str1, paramArrayOfString[j]) < 0) {
/* 32 */           j = k;
/*    */         }
/*    */       } 
/*    */       
/* 36 */       String str = paramArrayOfString[j];
/* 37 */       paramArrayOfString[j] = paramArrayOfString[b];
/* 38 */       paramArrayOfString[b] = str;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\a\f.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */