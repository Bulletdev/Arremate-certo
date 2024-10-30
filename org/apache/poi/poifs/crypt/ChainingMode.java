/*    */ package org.apache.poi.poifs.crypt;
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
/*    */ public enum ChainingMode
/*    */ {
/* 22 */   ecb("ECB", 1),
/* 23 */   cbc("CBC", 2),
/*    */   
/* 25 */   cfb("CFB8", 3);
/*    */   public final String jceId;
/*    */   public final int ecmaId;
/*    */   
/*    */   ChainingMode(String paramString1, int paramInt1) {
/* 30 */     this.jceId = paramString1;
/* 31 */     this.ecmaId = paramInt1;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\ChainingMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */