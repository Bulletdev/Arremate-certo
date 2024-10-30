/*    */ package org.passay;
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
/*    */ public class h
/*    */ {
/*    */   private final String[] p;
/*    */   
/*    */   public h(String... paramVarArgs) {
/* 32 */     if (paramVarArgs.length < 1) {
/* 33 */       throw new IllegalArgumentException("At least one sequence must be defined");
/*    */     }
/* 35 */     for (String str : paramVarArgs) {
/* 36 */       if (paramVarArgs[0].length() != str.length()) {
/* 37 */         throw new IllegalArgumentException("Strings have unequal length: " + paramVarArgs[0] + " != " + str);
/*    */       }
/*    */     } 
/* 40 */     this.p = paramVarArgs;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] o() {
/* 47 */     return this.p;
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
/*    */   public boolean a(int paramInt, char paramChar) {
/* 62 */     for (String str : this.p) {
/* 63 */       if (str.charAt(paramInt) == paramChar) {
/* 64 */         return true;
/*    */       }
/*    */     } 
/* 67 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int length() {
/* 74 */     return this.p[0].length();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\h.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */