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
/*    */ public class c
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
/* 28 */       for (byte b1 = 0; b1 < i - 1 - b; b1++) {
/* 29 */         String str1 = paramArrayOfString[b1];
/* 30 */         String str2 = paramArrayOfString[b1 + 1];
/* 31 */         if (paramComparator.compare(str1, str2) > 0) {
/* 32 */           paramArrayOfString[b1] = str2;
/* 33 */           paramArrayOfString[b1 + 1] = str1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\dictionary\a\c.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */