/*     */ package org.jsoup.select;
/*     */ 
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ abstract class StructuralEvaluator
/*     */   extends Evaluator
/*     */ {
/*     */   Evaluator evaluator;
/*     */   
/*     */   static class Root
/*     */     extends Evaluator {
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  13 */       return (param1Element1 == param1Element2);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Has extends StructuralEvaluator {
/*     */     public Has(Evaluator param1Evaluator) {
/*  19 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  23 */       for (Element element : param1Element2.getAllElements()) {
/*  24 */         if (element != param1Element2 && this.evaluator.matches(param1Element1, element))
/*  25 */           return true; 
/*     */       } 
/*  27 */       return false;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  31 */       return String.format(":has(%s)", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class Not extends StructuralEvaluator {
/*     */     public Not(Evaluator param1Evaluator) {
/*  37 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  41 */       return !this.evaluator.matches(param1Element1, param1Element2);
/*     */     }
/*     */     
/*     */     public String toString() {
/*  45 */       return String.format(":not%s", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class Parent extends StructuralEvaluator {
/*     */     public Parent(Evaluator param1Evaluator) {
/*  51 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  55 */       if (param1Element1 == param1Element2) {
/*  56 */         return false;
/*     */       }
/*  58 */       Element element = param1Element2.parent();
/*  59 */       while (element != param1Element1) {
/*  60 */         if (this.evaluator.matches(param1Element1, element))
/*  61 */           return true; 
/*  62 */         element = element.parent();
/*     */       } 
/*  64 */       return false;
/*     */     }
/*     */     
/*     */     public String toString() {
/*  68 */       return String.format(":parent%s", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class ImmediateParent extends StructuralEvaluator {
/*     */     public ImmediateParent(Evaluator param1Evaluator) {
/*  74 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  78 */       if (param1Element1 == param1Element2) {
/*  79 */         return false;
/*     */       }
/*  81 */       Element element = param1Element2.parent();
/*  82 */       return (element != null && this.evaluator.matches(param1Element1, element));
/*     */     }
/*     */     
/*     */     public String toString() {
/*  86 */       return String.format(":ImmediateParent%s", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class PreviousSibling extends StructuralEvaluator {
/*     */     public PreviousSibling(Evaluator param1Evaluator) {
/*  92 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/*  96 */       if (param1Element1 == param1Element2) {
/*  97 */         return false;
/*     */       }
/*  99 */       Element element = param1Element2.previousElementSibling();
/*     */       
/* 101 */       while (element != null) {
/* 102 */         if (this.evaluator.matches(param1Element1, element)) {
/* 103 */           return true;
/*     */         }
/* 105 */         element = element.previousElementSibling();
/*     */       } 
/* 107 */       return false;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 111 */       return String.format(":prev*%s", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */   
/*     */   static class ImmediatePreviousSibling extends StructuralEvaluator {
/*     */     public ImmediatePreviousSibling(Evaluator param1Evaluator) {
/* 117 */       this.evaluator = param1Evaluator;
/*     */     }
/*     */     
/*     */     public boolean matches(Element param1Element1, Element param1Element2) {
/* 121 */       if (param1Element1 == param1Element2) {
/* 122 */         return false;
/*     */       }
/* 124 */       Element element = param1Element2.previousElementSibling();
/* 125 */       return (element != null && this.evaluator.matches(param1Element1, element));
/*     */     }
/*     */     
/*     */     public String toString() {
/* 129 */       return String.format(":prev%s", new Object[] { this.evaluator });
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\StructuralEvaluator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */