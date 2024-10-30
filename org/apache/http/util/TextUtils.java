/*    */ package org.apache.http.util;
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
/*    */ public final class TextUtils
/*    */ {
/*    */   public static boolean isEmpty(CharSequence paramCharSequence) {
/* 39 */     if (paramCharSequence == null) {
/* 40 */       return true;
/*    */     }
/* 42 */     return (paramCharSequence.length() == 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean isBlank(CharSequence paramCharSequence) {
/* 49 */     if (paramCharSequence == null) {
/* 50 */       return true;
/*    */     }
/* 52 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 53 */       if (!Character.isWhitespace(paramCharSequence.charAt(b))) {
/* 54 */         return false;
/*    */       }
/*    */     } 
/* 57 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean containsBlanks(CharSequence paramCharSequence) {
/* 64 */     if (paramCharSequence == null) {
/* 65 */       return false;
/*    */     }
/* 67 */     for (byte b = 0; b < paramCharSequence.length(); b++) {
/* 68 */       if (Character.isWhitespace(paramCharSequence.charAt(b))) {
/* 69 */         return true;
/*    */       }
/*    */     } 
/* 72 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\TextUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */