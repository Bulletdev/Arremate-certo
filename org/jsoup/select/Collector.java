/*    */ package org.jsoup.select;
/*    */ 
/*    */ import org.jsoup.nodes.Element;
/*    */ import org.jsoup.nodes.Node;
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
/*    */ public class Collector
/*    */ {
/*    */   public static Elements collect(Evaluator paramEvaluator, Element paramElement) {
/* 23 */     Elements elements = new Elements();
/* 24 */     (new NodeTraversor(new Accumulator(paramElement, elements, paramEvaluator))).traverse((Node)paramElement);
/* 25 */     return elements;
/*    */   }
/*    */   
/*    */   private static class Accumulator implements NodeVisitor {
/*    */     private final Element root;
/*    */     private final Elements elements;
/*    */     private final Evaluator eval;
/*    */     
/*    */     Accumulator(Element param1Element, Elements param1Elements, Evaluator param1Evaluator) {
/* 34 */       this.root = param1Element;
/* 35 */       this.elements = param1Elements;
/* 36 */       this.eval = param1Evaluator;
/*    */     }
/*    */     
/*    */     public void head(Node param1Node, int param1Int) {
/* 40 */       if (param1Node instanceof Element) {
/* 41 */         Element element = (Element)param1Node;
/* 42 */         if (this.eval.matches(this.root, element))
/* 43 */           this.elements.add(element); 
/*    */       } 
/*    */     }
/*    */     
/*    */     public void tail(Node param1Node, int param1Int) {}
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\Collector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */