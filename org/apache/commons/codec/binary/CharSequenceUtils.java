/*    */ package org.apache.commons.codec.binary;
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
/*    */ public class CharSequenceUtils
/*    */ {
/*    */   static boolean regionMatches(CharSequence paramCharSequence1, boolean paramBoolean, int paramInt1, CharSequence paramCharSequence2, int paramInt2, int paramInt3) {
/* 54 */     if (paramCharSequence1 instanceof String && paramCharSequence2 instanceof String) {
/* 55 */       return ((String)paramCharSequence1).regionMatches(paramBoolean, paramInt1, (String)paramCharSequence2, paramInt2, paramInt3);
/*    */     }
/* 57 */     int i = paramInt1;
/* 58 */     int j = paramInt2;
/* 59 */     int k = paramInt3;
/*    */     
/* 61 */     while (k-- > 0) {
/* 62 */       char c1 = paramCharSequence1.charAt(i++);
/* 63 */       char c2 = paramCharSequence2.charAt(j++);
/*    */       
/* 65 */       if (c1 == c2) {
/*    */         continue;
/*    */       }
/*    */       
/* 69 */       if (!paramBoolean) {
/* 70 */         return false;
/*    */       }
/*    */ 
/*    */       
/* 74 */       if (Character.toUpperCase(c1) != Character.toUpperCase(c2) && 
/* 75 */         Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
/* 76 */         return false;
/*    */       }
/*    */     } 
/*    */     
/* 80 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\codec\binary\CharSequenceUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */