/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import java.nio.charset.Charset;
/*     */ import java.nio.charset.CharsetEncoder;
/*     */ import java.util.ArrayList;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.parser.Tag;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Document
/*     */   extends Element
/*     */ {
/*  18 */   private OutputSettings outputSettings = new OutputSettings();
/*  19 */   private QuirksMode quirksMode = QuirksMode.noQuirks;
/*     */ 
/*     */ 
/*     */   
/*     */   private String location;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document(String paramString) {
/*  29 */     super(Tag.valueOf("#root"), paramString);
/*  30 */     this.location = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document createShell(String paramString) {
/*  39 */     Validate.notNull(paramString);
/*     */     
/*  41 */     Document document = new Document(paramString);
/*  42 */     Element element = document.appendElement("html");
/*  43 */     element.appendElement("head");
/*  44 */     element.appendElement("body");
/*     */     
/*  46 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String location() {
/*  55 */     return this.location;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element head() {
/*  63 */     return findFirstElementByTagName("head", this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element body() {
/*  71 */     return findFirstElementByTagName("body", this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String title() {
/*  80 */     Element element = getElementsByTag("title").first();
/*  81 */     return (element != null) ? StringUtil.normaliseWhitespace(element.text()).trim() : "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void title(String paramString) {
/*  90 */     Validate.notNull(paramString);
/*  91 */     Element element = getElementsByTag("title").first();
/*  92 */     if (element == null) {
/*  93 */       head().appendElement("title").text(paramString);
/*     */     } else {
/*  95 */       element.text(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element createElement(String paramString) {
/* 105 */     return new Element(Tag.valueOf(paramString), baseUri());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document normalise() {
/* 114 */     Element element = findFirstElementByTagName("html", this);
/* 115 */     if (element == null)
/* 116 */       element = appendElement("html"); 
/* 117 */     if (head() == null)
/* 118 */       element.prependElement("head"); 
/* 119 */     if (body() == null) {
/* 120 */       element.appendElement("body");
/*     */     }
/*     */ 
/*     */     
/* 124 */     normaliseTextNodes(head());
/* 125 */     normaliseTextNodes(element);
/* 126 */     normaliseTextNodes(this);
/*     */     
/* 128 */     normaliseStructure("head", element);
/* 129 */     normaliseStructure("body", element);
/*     */     
/* 131 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   private void normaliseTextNodes(Element paramElement) {
/* 136 */     ArrayList<TextNode> arrayList = new ArrayList();
/* 137 */     for (Node node : paramElement.childNodes) {
/* 138 */       if (node instanceof TextNode) {
/* 139 */         TextNode textNode = (TextNode)node;
/* 140 */         if (!textNode.isBlank()) {
/* 141 */           arrayList.add(textNode);
/*     */         }
/*     */       } 
/*     */     } 
/* 145 */     for (int i = arrayList.size() - 1; i >= 0; i--) {
/* 146 */       Node node = arrayList.get(i);
/* 147 */       paramElement.removeChild(node);
/* 148 */       body().prependChild(new TextNode(" ", ""));
/* 149 */       body().prependChild(node);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void normaliseStructure(String paramString, Element paramElement) {
/* 155 */     Elements elements = getElementsByTag(paramString);
/* 156 */     Element element = elements.first();
/* 157 */     if (elements.size() > 1) {
/* 158 */       ArrayList<Node> arrayList = new ArrayList();
/* 159 */       for (byte b = 1; b < elements.size(); b++) {
/* 160 */         Element element1 = elements.get(b);
/* 161 */         for (Node node : element1.childNodes)
/* 162 */           arrayList.add(node); 
/* 163 */         element1.remove();
/*     */       } 
/*     */       
/* 166 */       for (Node node : arrayList) {
/* 167 */         element.appendChild(node);
/*     */       }
/*     */     } 
/* 170 */     if (!element.parent().equals(paramElement)) {
/* 171 */       paramElement.appendChild(element);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private Element findFirstElementByTagName(String paramString, Node paramNode) {
/* 177 */     if (paramNode.nodeName().equals(paramString)) {
/* 178 */       return (Element)paramNode;
/*     */     }
/* 180 */     for (Node node : paramNode.childNodes) {
/* 181 */       Element element = findFirstElementByTagName(paramString, node);
/* 182 */       if (element != null) {
/* 183 */         return element;
/*     */       }
/*     */     } 
/* 186 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String outerHtml() {
/* 191 */     return html();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Element text(String paramString) {
/* 201 */     body().text(paramString);
/* 202 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public String nodeName() {
/* 207 */     return "#document";
/*     */   }
/*     */ 
/*     */   
/*     */   public Document clone() {
/* 212 */     Document document = (Document)super.clone();
/* 213 */     document.outputSettings = this.outputSettings.clone();
/* 214 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class OutputSettings
/*     */     implements Cloneable
/*     */   {
/*     */     public enum Syntax
/*     */     {
/* 224 */       html, xml;
/*     */     }
/* 226 */     private Entities.EscapeMode escapeMode = Entities.EscapeMode.base;
/* 227 */     private Charset charset = Charset.forName("UTF-8");
/* 228 */     private CharsetEncoder charsetEncoder = this.charset.newEncoder();
/*     */     private boolean prettyPrint = true;
/*     */     private boolean outline = false;
/* 231 */     private int indentAmount = 1;
/* 232 */     private Syntax syntax = Syntax.html;
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
/*     */     public Entities.EscapeMode escapeMode() {
/* 245 */       return this.escapeMode;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings escapeMode(Entities.EscapeMode param1EscapeMode) {
/* 255 */       this.escapeMode = param1EscapeMode;
/* 256 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Charset charset() {
/* 268 */       return this.charset;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings charset(Charset param1Charset) {
/* 278 */       this.charset = param1Charset;
/* 279 */       this.charsetEncoder = param1Charset.newEncoder();
/* 280 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings charset(String param1String) {
/* 289 */       charset(Charset.forName(param1String));
/* 290 */       return this;
/*     */     }
/*     */     
/*     */     CharsetEncoder encoder() {
/* 294 */       return this.charsetEncoder;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Syntax syntax() {
/* 302 */       return this.syntax;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings syntax(Syntax param1Syntax) {
/* 312 */       this.syntax = param1Syntax;
/* 313 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean prettyPrint() {
/* 322 */       return this.prettyPrint;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings prettyPrint(boolean param1Boolean) {
/* 331 */       this.prettyPrint = param1Boolean;
/* 332 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean outline() {
/* 341 */       return this.outline;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings outline(boolean param1Boolean) {
/* 350 */       this.outline = param1Boolean;
/* 351 */       return this;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int indentAmount() {
/* 359 */       return this.indentAmount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OutputSettings indentAmount(int param1Int) {
/* 368 */       Validate.isTrue((param1Int >= 0));
/* 369 */       this.indentAmount = param1Int;
/* 370 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public OutputSettings clone() {
/*     */       OutputSettings outputSettings;
/*     */       try {
/* 377 */         outputSettings = (OutputSettings)super.clone();
/* 378 */       } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 379 */         throw new RuntimeException(cloneNotSupportedException);
/*     */       } 
/* 381 */       outputSettings.charset(this.charset.name());
/* 382 */       outputSettings.escapeMode = Entities.EscapeMode.valueOf(this.escapeMode.name());
/*     */       
/* 384 */       return outputSettings;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OutputSettings outputSettings() {
/* 393 */     return this.outputSettings;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Document outputSettings(OutputSettings paramOutputSettings) {
/* 402 */     Validate.notNull(paramOutputSettings);
/* 403 */     this.outputSettings = paramOutputSettings;
/* 404 */     return this;
/*     */   }
/*     */   
/*     */   public enum QuirksMode {
/* 408 */     noQuirks, quirks, limitedQuirks;
/*     */   }
/*     */   
/*     */   public QuirksMode quirksMode() {
/* 412 */     return this.quirksMode;
/*     */   }
/*     */   
/*     */   public Document quirksMode(QuirksMode paramQuirksMode) {
/* 416 */     this.quirksMode = paramQuirksMode;
/* 417 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 422 */     return super.equals(paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\Document.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */