/*    */ package com.google.gson.internal;
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
/*    */ public final class $Gson$Preconditions
/*    */ {
/*    */   private $Gson$Preconditions() {
/* 34 */     throw new UnsupportedOperationException();
/*    */   }
/*    */   
/*    */   public static <T> T checkNotNull(T paramT) {
/* 38 */     if (paramT == null) {
/* 39 */       throw new NullPointerException();
/*    */     }
/* 41 */     return paramT;
/*    */   }
/*    */   
/*    */   public static void checkArgument(boolean paramBoolean) {
/* 45 */     if (!paramBoolean)
/* 46 */       throw new IllegalArgumentException(); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\$Gson$Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */