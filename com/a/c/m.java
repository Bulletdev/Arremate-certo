/*    */ package com.a.c;
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
/*    */ public abstract class m
/*    */   extends c
/*    */ {
/* 39 */   protected String name = null;
/*    */   protected boolean bB = false;
/*    */   
/*    */   public m(String paramString, boolean paramBoolean) {
/* 43 */     setName(paramString);
/* 44 */     ao(paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean dQ() {
/* 51 */     return this.bB;
/*    */   }
/*    */   
/*    */   public void ao(boolean paramBoolean) {
/* 55 */     this.bB = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getName() {
/* 62 */     return this.name;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setName(String paramString) {
/* 72 */     if (paramString == null) {
/* 73 */       throw new IllegalArgumentException("name cannot be null");
/*    */     }
/* 75 */     if (!isValidName(paramString)) {
/* 76 */       throw new IllegalArgumentException("invalid name: " + paramString);
/*    */     }
/* 78 */     this.name = paramString;
/*    */   }
/*    */   
/*    */   private static boolean isValidName(String paramString) {
/* 82 */     if (paramString.length() == 0) return false;
/*    */     
/* 84 */     char c1 = paramString.charAt(0);
/*    */     
/* 86 */     if ((c1 >= '0' && c1 <= '9') || c1 == '.' || c1 == ',' || c1 == '(' || c1 == ')' || c1 == '^' || c1 == '*' || c1 == '/' || c1 == '+' || c1 == '-' || c1 == ' ' || c1 == '\t' || c1 == '\n') {
/* 87 */       return false;
/*    */     }
/* 89 */     for (byte b = 1; b < paramString.length(); b++) {
/* 90 */       c1 = paramString.charAt(b);
/*    */       
/* 92 */       if (c1 == ',' || c1 == '(' || c1 == ')' || c1 == '^' || c1 == '*' || c1 == '/' || c1 == '+' || c1 == '-' || c1 == ' ' || c1 == '\t' || c1 == '\n') {
/* 93 */         return false;
/*    */       }
/*    */     } 
/* 96 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\a\c\m.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */