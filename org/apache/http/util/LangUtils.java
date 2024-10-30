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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LangUtils
/*    */ {
/*    */   public static final int HASH_SEED = 17;
/*    */   public static final int HASH_OFFSET = 37;
/*    */   
/*    */   public static int hashCode(int paramInt1, int paramInt2) {
/* 47 */     return paramInt1 * 37 + paramInt2;
/*    */   }
/*    */   
/*    */   public static int hashCode(int paramInt, boolean paramBoolean) {
/* 51 */     return hashCode(paramInt, paramBoolean ? 1 : 0);
/*    */   }
/*    */   
/*    */   public static int hashCode(int paramInt, Object paramObject) {
/* 55 */     return hashCode(paramInt, (paramObject != null) ? paramObject.hashCode() : 0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static boolean equals(Object paramObject1, Object paramObject2) {
/* 66 */     return (paramObject1 == null) ? ((paramObject2 == null)) : paramObject1.equals(paramObject2);
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
/*    */   public static boolean equals(Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) {
/* 84 */     if (paramArrayOfObject1 == null) {
/* 85 */       return (paramArrayOfObject2 == null);
/*    */     }
/* 87 */     if (paramArrayOfObject2 != null && paramArrayOfObject1.length == paramArrayOfObject2.length) {
/* 88 */       for (byte b = 0; b < paramArrayOfObject1.length; b++) {
/* 89 */         if (!equals(paramArrayOfObject1[b], paramArrayOfObject2[b])) {
/* 90 */           return false;
/*    */         }
/*    */       } 
/* 93 */       return true;
/*    */     } 
/* 95 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\htt\\util\LangUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */