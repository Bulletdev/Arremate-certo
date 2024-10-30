/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.DocumentType;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.nodes.XmlDeclaration;
/*     */ 
/*     */ 
/*     */ public class XmlTreeBuilder
/*     */   extends TreeBuilder
/*     */ {
/*     */   protected void initialiseParse(String paramString1, String paramString2, ParseErrorList paramParseErrorList) {
/*  19 */     super.initialiseParse(paramString1, paramString2, paramParseErrorList);
/*  20 */     this.stack.add(this.doc);
/*  21 */     this.doc.outputSettings().syntax(Document.OutputSettings.Syntax.xml);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean process(Token paramToken) {
/*  27 */     switch (paramToken.type) {
/*     */       case StartTag:
/*  29 */         insert(paramToken.asStartTag());
/*     */       
/*     */       case EndTag:
/*  32 */         popStackToClose(paramToken.asEndTag());
/*     */       
/*     */       case Comment:
/*  35 */         insert(paramToken.asComment());
/*     */       
/*     */       case Character:
/*  38 */         insert(paramToken.asCharacter());
/*     */       
/*     */       case Doctype:
/*  41 */         insert(paramToken.asDoctype());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case EOF:
/*  48 */         return true;
/*     */     } 
/*     */     Validate.fail("Unexpected token type: " + paramToken.type);
/*     */   } private void insertNode(Node paramNode) {
/*  52 */     currentElement().appendChild(paramNode);
/*     */   }
/*     */   
/*     */   Element insert(Token.StartTag paramStartTag) {
/*  56 */     Tag tag = Tag.valueOf(paramStartTag.name());
/*     */     
/*  58 */     Element element = new Element(tag, this.baseUri, paramStartTag.attributes);
/*  59 */     insertNode((Node)element);
/*  60 */     if (paramStartTag.isSelfClosing()) {
/*  61 */       this.tokeniser.acknowledgeSelfClosingFlag();
/*  62 */       if (!tag.isKnownTag())
/*  63 */         tag.setSelfClosing(); 
/*     */     } else {
/*  65 */       this.stack.add(element);
/*     */     } 
/*  67 */     return element;
/*     */   }
/*     */   void insert(Token.Comment paramComment) {
/*     */     XmlDeclaration xmlDeclaration;
/*  71 */     Comment comment1 = new Comment(paramComment.getData(), this.baseUri);
/*  72 */     Comment comment2 = comment1;
/*  73 */     if (paramComment.bogus) {
/*  74 */       String str = comment1.getData();
/*  75 */       if (str.length() > 1 && (str.startsWith("!") || str.startsWith("?"))) {
/*  76 */         String str1 = str.substring(1);
/*  77 */         xmlDeclaration = new XmlDeclaration(str1, comment1.baseUri(), str.startsWith("!"));
/*     */       } 
/*     */     } 
/*  80 */     insertNode((Node)xmlDeclaration);
/*     */   }
/*     */   
/*     */   void insert(Token.Character paramCharacter) {
/*  84 */     TextNode textNode = new TextNode(paramCharacter.getData(), this.baseUri);
/*  85 */     insertNode((Node)textNode);
/*     */   }
/*     */   
/*     */   void insert(Token.Doctype paramDoctype) {
/*  89 */     DocumentType documentType = new DocumentType(paramDoctype.getName(), paramDoctype.getPublicIdentifier(), paramDoctype.getSystemIdentifier(), this.baseUri);
/*  90 */     insertNode((Node)documentType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void popStackToClose(Token.EndTag paramEndTag) {
/* 100 */     String str = paramEndTag.name();
/* 101 */     Element element = null;
/*     */     
/* 103 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 104 */     while (iterator.hasNext()) {
/* 105 */       Element element1 = iterator.next();
/* 106 */       if (element1.nodeName().equals(str)) {
/* 107 */         element = element1;
/*     */         break;
/*     */       } 
/*     */     } 
/* 111 */     if (element == null) {
/*     */       return;
/*     */     }
/* 114 */     iterator = this.stack.descendingIterator();
/* 115 */     while (iterator.hasNext()) {
/* 116 */       Element element1 = iterator.next();
/* 117 */       if (element1 == element) {
/* 118 */         iterator.remove();
/*     */         break;
/*     */       } 
/* 121 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   List<Node> parseFragment(String paramString1, String paramString2, ParseErrorList paramParseErrorList) {
/* 127 */     initialiseParse(paramString1, paramString2, paramParseErrorList);
/* 128 */     runParser();
/* 129 */     return this.doc.childNodes();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\XmlTreeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */