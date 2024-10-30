/*    */ package org.h2.bnf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RuleHead
/*    */ {
/*    */   private final String section;
/*    */   private final String topic;
/*    */   private Rule rule;
/*    */   
/*    */   RuleHead(String paramString1, String paramString2, Rule paramRule) {
/* 17 */     this.section = paramString1;
/* 18 */     this.topic = paramString2;
/* 19 */     this.rule = paramRule;
/*    */   }
/*    */   
/*    */   public String getTopic() {
/* 23 */     return this.topic;
/*    */   }
/*    */   
/*    */   public Rule getRule() {
/* 27 */     return this.rule;
/*    */   }
/*    */   
/*    */   void setRule(Rule paramRule) {
/* 31 */     this.rule = paramRule;
/*    */   }
/*    */   
/*    */   public String getSection() {
/* 35 */     return this.section;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\RuleHead.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */