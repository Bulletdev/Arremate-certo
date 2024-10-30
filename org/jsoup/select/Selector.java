/*     */ package org.jsoup.select;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashSet;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Element;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Selector
/*     */ {
/*     */   private final Evaluator evaluator;
/*     */   private final Element root;
/*     */   
/*     */   private Selector(String paramString, Element paramElement) {
/*  76 */     Validate.notNull(paramString);
/*  77 */     paramString = paramString.trim();
/*  78 */     Validate.notEmpty(paramString);
/*  79 */     Validate.notNull(paramElement);
/*     */     
/*  81 */     this.evaluator = QueryParser.parse(paramString);
/*     */     
/*  83 */     this.root = paramElement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Elements select(String paramString, Element paramElement) {
/*  94 */     return (new Selector(paramString, paramElement)).select();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Elements select(String paramString, Iterable<Element> paramIterable) {
/* 105 */     Validate.notEmpty(paramString);
/* 106 */     Validate.notNull(paramIterable);
/* 107 */     LinkedHashSet<Element> linkedHashSet = new LinkedHashSet();
/*     */     
/* 109 */     for (Element element : paramIterable) {
/* 110 */       linkedHashSet.addAll(select(paramString, element));
/*     */     }
/* 112 */     return new Elements(linkedHashSet);
/*     */   }
/*     */   
/*     */   private Elements select() {
/* 116 */     return Collector.collect(this.evaluator, this.root);
/*     */   }
/*     */ 
/*     */   
/*     */   static Elements filterOut(Collection<Element> paramCollection1, Collection<Element> paramCollection2) {
/* 121 */     Elements elements = new Elements();
/* 122 */     for (Element element : paramCollection1) {
/* 123 */       boolean bool = false;
/* 124 */       for (Element element1 : paramCollection2) {
/* 125 */         if (element.equals(element1)) {
/* 126 */           bool = true;
/*     */           break;
/*     */         } 
/*     */       } 
/* 130 */       if (!bool)
/* 131 */         elements.add(element); 
/*     */     } 
/* 133 */     return elements;
/*     */   }
/*     */   
/*     */   public static class SelectorParseException extends IllegalStateException {
/*     */     public SelectorParseException(String param1String, Object... param1VarArgs) {
/* 138 */       super(String.format(param1String, param1VarArgs));
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\select\Selector.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */