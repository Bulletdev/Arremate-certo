/*    */ package org.apache.poi.xwpf.usermodel;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
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
/*    */ public enum LineSpacingRule
/*    */ {
/* 36 */   AUTO(1),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 43 */   EXACT(2),
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   AT_LEAST(3);
/*    */   
/*    */   static {
/* 52 */     imap = new HashMap<Integer, LineSpacingRule>();
/*    */ 
/*    */     
/* 55 */     for (LineSpacingRule lineSpacingRule : values())
/* 56 */       imap.put(Integer.valueOf(lineSpacingRule.getValue()), lineSpacingRule); 
/*    */   }
/*    */   
/*    */   private static Map<Integer, LineSpacingRule> imap;
/*    */   private final int value;
/*    */   
/*    */   LineSpacingRule(int paramInt1) {
/* 63 */     this.value = paramInt1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getValue() {
/* 74 */     return this.value;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\xwp\\usermodel\LineSpacingRule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */