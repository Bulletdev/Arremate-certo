/*     */ package org.jsoup.safety;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Attribute;
/*     */ import org.jsoup.nodes.Attributes;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.parser.Tag;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
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
/*     */ public class Cleaner
/*     */ {
/*     */   private Whitelist whitelist;
/*     */   
/*     */   public Cleaner(Whitelist paramWhitelist) {
/*  31 */     Validate.notNull(paramWhitelist);
/*  32 */     this.whitelist = paramWhitelist;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document clean(Document paramDocument) {
/*  42 */     Validate.notNull(paramDocument);
/*     */     
/*  44 */     Document document = Document.createShell(paramDocument.baseUri());
/*  45 */     if (paramDocument.body() != null) {
/*  46 */       copySafeNodes(paramDocument.body(), document.body());
/*     */     }
/*  48 */     return document;
/*     */   }
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
/*     */   public boolean isValid(Document paramDocument) {
/*  62 */     Validate.notNull(paramDocument);
/*     */     
/*  64 */     Document document = Document.createShell(paramDocument.baseUri());
/*  65 */     int i = copySafeNodes(paramDocument.body(), document.body());
/*  66 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private final class CleaningVisitor
/*     */     implements NodeVisitor
/*     */   {
/*  73 */     private int numDiscarded = 0;
/*     */     private final Element root;
/*     */     private Element destination;
/*     */     
/*     */     private CleaningVisitor(Element param1Element1, Element param1Element2) {
/*  78 */       this.root = param1Element1;
/*  79 */       this.destination = param1Element2;
/*     */     }
/*     */     
/*     */     public void head(Node param1Node, int param1Int) {
/*  83 */       if (param1Node instanceof Element) {
/*  84 */         Element element = (Element)param1Node;
/*     */         
/*  86 */         if (Cleaner.this.whitelist.isSafeTag(element.tagName())) {
/*  87 */           Cleaner.ElementMeta elementMeta = Cleaner.this.createSafeElement(element);
/*  88 */           Element element1 = elementMeta.el;
/*  89 */           this.destination.appendChild((Node)element1);
/*     */           
/*  91 */           this.numDiscarded += elementMeta.numAttribsDiscarded;
/*  92 */           this.destination = element1;
/*  93 */         } else if (param1Node != this.root) {
/*  94 */           this.numDiscarded++;
/*     */         } 
/*  96 */       } else if (param1Node instanceof TextNode) {
/*  97 */         TextNode textNode1 = (TextNode)param1Node;
/*  98 */         TextNode textNode2 = new TextNode(textNode1.getWholeText(), param1Node.baseUri());
/*  99 */         this.destination.appendChild((Node)textNode2);
/* 100 */       } else if (param1Node instanceof DataNode && Cleaner.this.whitelist.isSafeTag(param1Node.parent().nodeName())) {
/* 101 */         DataNode dataNode1 = (DataNode)param1Node;
/* 102 */         DataNode dataNode2 = new DataNode(dataNode1.getWholeData(), param1Node.baseUri());
/* 103 */         this.destination.appendChild((Node)dataNode2);
/*     */       } else {
/* 105 */         this.numDiscarded++;
/*     */       } 
/*     */     }
/*     */     
/*     */     public void tail(Node param1Node, int param1Int) {
/* 110 */       if (param1Node instanceof Element && Cleaner.this.whitelist.isSafeTag(param1Node.nodeName())) {
/* 111 */         this.destination = this.destination.parent();
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   private int copySafeNodes(Element paramElement1, Element paramElement2) {
/* 117 */     CleaningVisitor cleaningVisitor = new CleaningVisitor(paramElement1, paramElement2);
/* 118 */     NodeTraversor nodeTraversor = new NodeTraversor(cleaningVisitor);
/* 119 */     nodeTraversor.traverse((Node)paramElement1);
/* 120 */     return cleaningVisitor.numDiscarded;
/*     */   }
/*     */   
/*     */   private ElementMeta createSafeElement(Element paramElement) {
/* 124 */     String str = paramElement.tagName();
/* 125 */     Attributes attributes1 = new Attributes();
/* 126 */     Element element = new Element(Tag.valueOf(str), paramElement.baseUri(), attributes1);
/* 127 */     byte b = 0;
/*     */     
/* 129 */     Attributes attributes2 = paramElement.attributes();
/* 130 */     for (Attribute attribute : attributes2) {
/* 131 */       if (this.whitelist.isSafeAttribute(str, paramElement, attribute)) {
/* 132 */         attributes1.put(attribute); continue;
/*     */       } 
/* 134 */       b++;
/*     */     } 
/* 136 */     Attributes attributes3 = this.whitelist.getEnforcedAttributes(str);
/* 137 */     attributes1.addAll(attributes3);
/*     */     
/* 139 */     return new ElementMeta(element, b);
/*     */   }
/*     */   
/*     */   private static class ElementMeta {
/*     */     Element el;
/*     */     int numAttribsDiscarded;
/*     */     
/*     */     ElementMeta(Element param1Element, int param1Int) {
/* 147 */       this.el = param1Element;
/* 148 */       this.numAttribsDiscarded = param1Int;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\safety\Cleaner.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */