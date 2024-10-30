/*    */ package br.com.arremate.f;
/*    */ 
/*    */ public enum b
/*    */ {
/*  5 */   a("base64"),
/*  6 */   b("recaptchav2"),
/*  7 */   c("recaptchav3"),
/*  8 */   d("capmonster-hcaptcha"),
/*  9 */   e("amazon");
/*    */   
/*    */   private final String description;
/*    */   
/*    */   b(String paramString1) {
/* 14 */     this.description = paramString1;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 18 */     return this.description;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\f\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */