/*    */ package org.jsoup.parser;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ParseError
/*    */ {
/*    */   private int pos;
/*    */   private String errorMsg;
/*    */   
/*    */   ParseError(int paramInt, String paramString) {
/* 11 */     this.pos = paramInt;
/* 12 */     this.errorMsg = paramString;
/*    */   }
/*    */   
/*    */   ParseError(int paramInt, String paramString, Object... paramVarArgs) {
/* 16 */     this.errorMsg = String.format(paramString, paramVarArgs);
/* 17 */     this.pos = paramInt;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorMessage() {
/* 25 */     return this.errorMsg;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getPosition() {
/* 33 */     return this.pos;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 38 */     return this.pos + ": " + this.errorMsg;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\ParseError.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */