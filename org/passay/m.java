/*    */ package org.passay;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public enum m
/*    */   implements f
/*    */ {
/* 12 */   a("INSUFFICIENT_LOWERCASE", "abcdefghijklmnopqrstuvwxyz"),
/*    */ 
/*    */   
/* 15 */   b("INSUFFICIENT_UPPERCASE", "ABCDEFGHIJKLMNOPQRSTUVWXYZ"),
/*    */ 
/*    */   
/* 18 */   c("INSUFFICIENT_DIGIT", "0123456789"),
/*    */ 
/*    */   
/* 21 */   d("INSUFFICIENT_ALPHABETICAL", b.fe() + a.fe()),
/*    */ 
/*    */   
/* 24 */   e("INSUFFICIENT_SPECIAL", "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~¡¢£¤¥¦§¨©ª«¬­®¯°±²³´µ¶·¸¹º»¼½¾¿×÷–—―‗‘’‚‛“”„†‡•…‰′″‹›‼‾⁄⁊₠₡₢₣₤₥₦₧₨₩₪₫€₭₮₯₰₱₲₳₴₵₶₷₸₹₺₻₼₽₾");
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String errorCode;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private final String mm;
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
/*    */   m(String paramString1, String paramString2) {
/* 56 */     this.errorCode = paramString1;
/* 57 */     this.mm = paramString2;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getErrorCode() {
/* 63 */     return this.errorCode;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String fe() {
/* 69 */     return this.mm;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */