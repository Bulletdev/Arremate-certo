/*     */ package org.jsoup.nodes;
/*     */ 
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
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
/*     */ public class TextNode
/*     */   extends Node
/*     */ {
/*     */   private static final String TEXT_KEY = "text";
/*     */   String text;
/*     */   
/*     */   public TextNode(String paramString1, String paramString2) {
/*  27 */     this.baseUri = paramString2;
/*  28 */     this.text = paramString1;
/*     */   }
/*     */   
/*     */   public String nodeName() {
/*  32 */     return "#text";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String text() {
/*  41 */     return normaliseWhitespace(getWholeText());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextNode text(String paramString) {
/*  50 */     this.text = paramString;
/*  51 */     if (this.attributes != null)
/*  52 */       this.attributes.put("text", paramString); 
/*  53 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getWholeText() {
/*  61 */     return (this.attributes == null) ? this.text : this.attributes.get("text");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlank() {
/*  69 */     return StringUtil.isBlank(getWholeText());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TextNode splitText(int paramInt) {
/*  79 */     Validate.isTrue((paramInt >= 0), "Split offset must be not be negative");
/*  80 */     Validate.isTrue((paramInt < this.text.length()), "Split offset must not be greater than current text length");
/*     */     
/*  82 */     String str1 = getWholeText().substring(0, paramInt);
/*  83 */     String str2 = getWholeText().substring(paramInt);
/*  84 */     text(str1);
/*  85 */     TextNode textNode = new TextNode(str2, baseUri());
/*  86 */     if (parent() != null) {
/*  87 */       parent().addChildren(siblingIndex() + 1, new Node[] { textNode });
/*     */     }
/*  89 */     return textNode;
/*     */   }
/*     */   
/*     */   void outerHtmlHead(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {
/*  93 */     if (paramOutputSettings.prettyPrint() && ((siblingIndex() == 0 && this.parentNode instanceof Element && ((Element)this.parentNode).tag().formatAsBlock() && !isBlank()) || (paramOutputSettings.outline() && siblingNodes().size() > 0 && !isBlank()))) {
/*  94 */       indent(paramStringBuilder, paramInt, paramOutputSettings);
/*     */     }
/*  96 */     boolean bool = (paramOutputSettings.prettyPrint() && parent() instanceof Element && !Element.preserveWhitespace(parent())) ? true : false;
/*     */     
/*  98 */     Entities.escape(paramStringBuilder, getWholeText(), paramOutputSettings, false, bool, false);
/*     */   }
/*     */   
/*     */   void outerHtmlTail(StringBuilder paramStringBuilder, int paramInt, Document.OutputSettings paramOutputSettings) {}
/*     */   
/*     */   public String toString() {
/* 104 */     return outerHtml();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TextNode createFromEncoded(String paramString1, String paramString2) {
/* 113 */     String str = Entities.unescape(paramString1);
/* 114 */     return new TextNode(str, paramString2);
/*     */   }
/*     */   
/*     */   static String normaliseWhitespace(String paramString) {
/* 118 */     paramString = StringUtil.normaliseWhitespace(paramString);
/* 119 */     return paramString;
/*     */   }
/*     */   
/*     */   static String stripLeadingWhitespace(String paramString) {
/* 123 */     return paramString.replaceFirst("^\\s+", "");
/*     */   }
/*     */   
/*     */   static boolean lastCharIsWhitespace(StringBuilder paramStringBuilder) {
/* 127 */     return (paramStringBuilder.length() != 0 && paramStringBuilder.charAt(paramStringBuilder.length() - 1) == ' ');
/*     */   }
/*     */ 
/*     */   
/*     */   private void ensureAttributes() {
/* 132 */     if (this.attributes == null) {
/* 133 */       this.attributes = new Attributes();
/* 134 */       this.attributes.put("text", this.text);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String attr(String paramString) {
/* 140 */     ensureAttributes();
/* 141 */     return super.attr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attributes attributes() {
/* 146 */     ensureAttributes();
/* 147 */     return super.attributes();
/*     */   }
/*     */ 
/*     */   
/*     */   public Node attr(String paramString1, String paramString2) {
/* 152 */     ensureAttributes();
/* 153 */     return super.attr(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasAttr(String paramString) {
/* 158 */     ensureAttributes();
/* 159 */     return super.hasAttr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public Node removeAttr(String paramString) {
/* 164 */     ensureAttributes();
/* 165 */     return super.removeAttr(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String absUrl(String paramString) {
/* 170 */     ensureAttributes();
/* 171 */     return super.absUrl(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\nodes\TextNode.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */