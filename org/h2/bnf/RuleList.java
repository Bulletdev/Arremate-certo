/*    */ package org.h2.bnf;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import org.h2.util.New;
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
/*    */ public class RuleList
/*    */   implements Rule
/*    */ {
/*    */   private final boolean or;
/* 22 */   private final ArrayList<Rule> list = New.arrayList(); public RuleList(Rule paramRule1, Rule paramRule2, boolean paramBoolean) {
/* 23 */     if (paramRule1 instanceof RuleList && ((RuleList)paramRule1).or == paramBoolean) {
/* 24 */       this.list.addAll(((RuleList)paramRule1).list);
/*    */     } else {
/* 26 */       this.list.add(paramRule1);
/*    */     } 
/* 28 */     if (paramRule2 instanceof RuleList && ((RuleList)paramRule2).or == paramBoolean) {
/* 29 */       this.list.addAll(((RuleList)paramRule2).list);
/*    */     } else {
/* 31 */       this.list.add(paramRule2);
/*    */     } 
/* 33 */     this.or = paramBoolean;
/*    */   }
/*    */   private boolean mapSet;
/*    */   
/*    */   public void accept(BnfVisitor paramBnfVisitor) {
/* 38 */     paramBnfVisitor.visitRuleList(this.or, this.list);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLinks(HashMap<String, RuleHead> paramHashMap) {
/* 43 */     if (!this.mapSet) {
/* 44 */       for (Rule rule : this.list) {
/* 45 */         rule.setLinks(paramHashMap);
/*    */       }
/* 47 */       this.mapSet = true;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoComplete(Sentence paramSentence) {
/* 53 */     paramSentence.stopIfRequired();
/* 54 */     String str = paramSentence.getQuery();
/* 55 */     if (this.or) {
/* 56 */       for (Rule rule : this.list) {
/* 57 */         paramSentence.setQuery(str);
/* 58 */         if (rule.autoComplete(paramSentence)) {
/* 59 */           return true;
/*    */         }
/*    */       } 
/* 62 */       return false;
/*    */     } 
/* 64 */     for (Rule rule : this.list) {
/* 65 */       if (!rule.autoComplete(paramSentence)) {
/* 66 */         paramSentence.setQuery(str);
/* 67 */         return false;
/*    */       } 
/*    */     } 
/* 70 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\RuleList.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */