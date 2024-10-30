/*    */ package org.h2.bnf;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RuleOptional
/*    */   implements Rule
/*    */ {
/*    */   private final Rule rule;
/*    */   private boolean mapSet;
/*    */   
/*    */   public RuleOptional(Rule paramRule) {
/* 18 */     this.rule = paramRule;
/*    */   }
/*    */ 
/*    */   
/*    */   public void accept(BnfVisitor paramBnfVisitor) {
/* 23 */     paramBnfVisitor.visitRuleOptional(this.rule);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLinks(HashMap<String, RuleHead> paramHashMap) {
/* 28 */     if (!this.mapSet) {
/* 29 */       this.rule.setLinks(paramHashMap);
/* 30 */       this.mapSet = true;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean autoComplete(Sentence paramSentence) {
/* 35 */     paramSentence.stopIfRequired();
/* 36 */     this.rule.autoComplete(paramSentence);
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\RuleOptional.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */