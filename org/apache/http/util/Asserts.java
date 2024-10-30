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
/*    */ public class Asserts
/*    */ {
/*    */   public static void check(boolean paramBoolean, String paramString) {
/* 33 */     if (!paramBoolean) {
/* 34 */       throw new IllegalStateException(paramString);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void check(boolean paramBoolean, String paramString, Object... paramVarArgs) {
/* 39 */     if (!paramBoolean) {
/* 40 */       throw new IllegalStateException(String.format(paramString, paramVarArgs));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void check(boolean paramBoolean, String paramString, Object paramObject) {
/* 45 */     if (!paramBoolean) {
/* 46 */       throw new IllegalStateException(String.format(paramString, new Object[] { paramObject }));
/*    */     }
/*    */   }
/*    */   
/*    */   public static void notNull(Object paramObject, String paramString) {
/* 51 */     if (paramObject == null) {
/* 52 */       throw new IllegalStateException(paramString + " is null");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void notEmpty(CharSequence paramCharSequence, String paramString) {
/* 57 */     if (TextUtils.isEmpty(paramCharSequence)) {
/* 58 */       throw new IllegalStateException(paramString + " is empty");
/*    */     }
/*    */   }
/*    */   
/*    */   public static void notBlank(CharSequence paramCharSequence, String paramString) {
/* 63 */     if (TextUtils.isBlank(paramCharSequence))
/* 64 */       throw new IllegalStateException(paramString + " is blank"); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\Asserts.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */