/*    */ package org.passay;
/*    */ 
/*    */ import org.passay.dictionary.d;
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
/*    */ public class j
/*    */   extends a
/*    */ {
/*    */   public j() {}
/*    */   
/*    */   public j(d paramd) {
/* 28 */     a(paramd);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String br(String paramString) {
/* 35 */     for (byte b = 1; b <= paramString.length(); b++) {
/* 36 */       for (byte b1 = 0; b1 + b <= paramString.length(); b1++) {
/* 37 */         String str = paramString.substring(b1, b1 + b);
/* 38 */         if (a().search(str)) {
/* 39 */           return str;
/*    */         }
/*    */       } 
/*    */     } 
/* 43 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */