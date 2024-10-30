/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ abstract class CombiningEvaluator
/*     */   extends Evaluator
/*     */ {
/*     */   final ArrayList<Evaluator> evaluators;
/*  16 */   int num = 0;
/*     */ 
/*     */   
/*     */   CombiningEvaluator() {
/*  20 */     this.evaluators = new ArrayList<Evaluator>();
/*     */   }
/*     */   
/*     */   CombiningEvaluator(Collection<Evaluator> paramCollection) {
/*  24 */     this();
/*  25 */     this.evaluators.addAll(paramCollection);
/*  26 */     updateNumEvaluators();
/*     */   }
/*     */   
/*     */   Evaluator rightMostEvaluator() {
/*  30 */     return (this.num > 0) ? this.evaluators.get(this.num - 1) : null;
/*     */   }
/*     */   
/*     */   void replaceRightMostEvaluator(Evaluator paramEvaluator) {
/*  34 */     this.evaluators.set(this.num - 1, paramEvaluator);
/*     */   }
/*     */ 
/*     */   
/*     */   void updateNumEvaluators() {
/*  39 */     this.num = this.evaluators.size();
/*     */   }
/*     */   
/*     */   static final class And extends CombiningEvaluator {
/*     */     And(Collection<Evaluator> param1Collection) {
/*  44 */       super(param1Collection);
/*     */     }
/*     */     
/*     */     And(Evaluator... param1VarArgs) {
/*  48 */       this(Arrays.asList(param1VarArgs));
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  53 */       for (byte b = 0; b < this.num; b++) {
/*  54 */         Evaluator evaluator = this.evaluators.get(b);
/*  55 */         if (!evaluator.matches(param1Element1, param1Element2))
/*  56 */           return false; 
/*     */       } 
/*  58 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/*  63 */       return StringUtil.join(this.evaluators, " ");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final class Or
/*     */     extends CombiningEvaluator
/*     */   {
/*     */     Or(Collection<Evaluator> param1Collection) {
/*  74 */       if (this.num > 1) {
/*  75 */         this.evaluators.add(new CombiningEvaluator.And(param1Collection));
/*     */       } else {
/*  77 */         this.evaluators.addAll(param1Collection);
/*  78 */       }  updateNumEvaluators();
/*     */     }
/*     */ 
/*     */     
/*     */     Or() {}
/*     */ 
/*     */     
/*     */     public void add(Evaluator param1Evaluator) {
/*  86 */       this.evaluators.add(param1Evaluator);
/*  87 */       updateNumEvaluators();
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  92 */       for (byte b = 0; b < this.num; b++) {
/*  93 */         Evaluator evaluator = this.evaluators.get(b);
/*  94 */         if (evaluator.matches(param1Element1, param1Element2))
/*  95 */           return true; 
/*     */       } 
/*  97 */       return false;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 102 */       return String.format(":or%s", new Object[] { this.evaluators });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\CombiningEvaluator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */