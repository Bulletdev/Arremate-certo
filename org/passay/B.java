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
/*    */ public abstract class b
/*    */   implements v
/*    */ {
/*    */   protected abstract String bs(String paramString);
/*    */   
/*    */   public String a(F paramF) {
/* 28 */     String str3, str1 = paramF.getErrorCode();
/* 29 */     String str2 = bs(str1);
/*    */     
/* 31 */     if (str2 != null) {
/* 32 */       str3 = String.format(str2, paramF.h());
/*    */     }
/* 34 */     else if (!paramF.getParameters().isEmpty()) {
/* 35 */       str3 = String.format("%s:%s", new Object[] { str1, paramF.getParameters() });
/*    */     } else {
/* 37 */       str3 = String.format("%s", new Object[] { str1 });
/*    */     } 
/*    */     
/* 40 */     return str3;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */