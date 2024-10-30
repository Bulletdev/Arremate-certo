/*    */ package org.h2.bnf;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import org.h2.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class RuleElement
/*    */   implements Rule
/*    */ {
/*    */   private final boolean keyword;
/*    */   private final String name;
/*    */   private Rule link;
/*    */   private final int type;
/*    */   
/*    */   public RuleElement(String paramString1, String paramString2) {
/* 23 */     this.name = paramString1;
/* 24 */     this.keyword = (paramString1.length() == 1 || paramString1.equals(StringUtils.toUpperEnglish(paramString1)));
/*    */     
/* 26 */     paramString2 = StringUtils.toLowerEnglish(paramString2);
/* 27 */     this.type = paramString2.startsWith("function") ? 2 : 1;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void accept(BnfVisitor paramBnfVisitor) {
/* 33 */     paramBnfVisitor.visitRuleElement(this.keyword, this.name, this.link);
/*    */   }
/*    */ 
/*    */   
/*    */   public void setLinks(HashMap<String, RuleHead> paramHashMap) {
/* 38 */     if (this.link != null) {
/* 39 */       this.link.setLinks(paramHashMap);
/*    */     }
/* 41 */     if (this.keyword) {
/*    */       return;
/*    */     }
/* 44 */     String str = Bnf.getRuleMapKey(this.name);
/* 45 */     for (byte b = 0; b < str.length(); b++) {
/* 46 */       String str1 = str.substring(b);
/* 47 */       RuleHead ruleHead = paramHashMap.get(str1);
/* 48 */       if (ruleHead != null) {
/* 49 */         this.link = ruleHead.getRule();
/*    */         return;
/*    */       } 
/*    */     } 
/* 53 */     throw new AssertionError("Unknown " + this.name + "/" + str);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean autoComplete(Sentence paramSentence) {
/* 58 */     paramSentence.stopIfRequired();
/* 59 */     if (this.keyword) {
/* 60 */       String str1 = paramSentence.getQuery();
/* 61 */       String str2 = str1.trim();
/* 62 */       String str3 = paramSentence.getQueryUpper().trim();
/* 63 */       if (str3.startsWith(this.name)) {
/* 64 */         str1 = str1.substring(this.name.length());
/* 65 */         while (!"_".equals(this.name) && Bnf.startWithSpace(str1)) {
/* 66 */           str1 = str1.substring(1);
/*    */         }
/* 68 */         paramSentence.setQuery(str1);
/* 69 */         return true;
/* 70 */       }  if ((str2.length() == 0 || this.name.startsWith(str3)) && 
/* 71 */         str2.length() < this.name.length()) {
/* 72 */         paramSentence.add(this.name, this.name.substring(str2.length()), this.type);
/*    */       }
/*    */       
/* 75 */       return false;
/*    */     } 
/* 77 */     return this.link.autoComplete(paramSentence);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\RuleElement.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */