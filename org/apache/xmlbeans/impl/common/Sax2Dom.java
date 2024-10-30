/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.util.Stack;
/*     */ import java.util.Vector;
/*     */ import javax.xml.parsers.DocumentBuilderFactory;
/*     */ import javax.xml.parsers.ParserConfigurationException;
/*     */ import org.w3c.dom.Comment;
/*     */ import org.w3c.dom.Document;
/*     */ import org.w3c.dom.Element;
/*     */ import org.w3c.dom.Node;
/*     */ import org.w3c.dom.ProcessingInstruction;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.ContentHandler;
/*     */ import org.xml.sax.Locator;
/*     */ import org.xml.sax.SAXException;
/*     */ import org.xml.sax.ext.LexicalHandler;
/*     */ import org.xml.sax.helpers.DefaultHandler;
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
/*     */ public class Sax2Dom
/*     */   extends DefaultHandler
/*     */   implements ContentHandler, LexicalHandler
/*     */ {
/*     */   public static final String EMPTYSTRING = "";
/*     */   public static final String XML_PREFIX = "xml";
/*     */   public static final String XMLNS_PREFIX = "xmlns";
/*     */   public static final String XMLNS_STRING = "xmlns:";
/*     */   public static final String XMLNS_URI = "http://www.w3.org/2000/xmlns/";
/*  45 */   private Node _root = null;
/*  46 */   private Document _document = null;
/*  47 */   private Stack _nodeStk = new Stack();
/*  48 */   private Vector _namespaceDecls = null;
/*     */ 
/*     */   
/*     */   public Sax2Dom() throws ParserConfigurationException {
/*  52 */     DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*     */     
/*  54 */     this._document = documentBuilderFactory.newDocumentBuilder().newDocument();
/*  55 */     this._root = this._document;
/*     */   }
/*     */ 
/*     */   
/*     */   public Sax2Dom(Node paramNode) throws ParserConfigurationException {
/*  60 */     this._root = paramNode;
/*  61 */     if (paramNode instanceof Document) {
/*     */       
/*  63 */       this._document = (Document)paramNode;
/*     */     }
/*  65 */     else if (paramNode != null) {
/*     */       
/*  67 */       this._document = paramNode.getOwnerDocument();
/*     */     }
/*     */     else {
/*     */       
/*  71 */       DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
/*     */       
/*  73 */       this._document = documentBuilderFactory.newDocumentBuilder().newDocument();
/*  74 */       this._root = this._document;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Node getDOM() {
/*  80 */     return this._root;
/*     */   }
/*     */ 
/*     */   
/*     */   public void characters(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/*  85 */     Node node = this._nodeStk.peek();
/*     */ 
/*     */     
/*  88 */     if (node != this._document) {
/*     */       
/*  90 */       String str = new String(paramArrayOfchar, paramInt1, paramInt2);
/*  91 */       node.appendChild(this._document.createTextNode(str));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void startDocument() {
/*  97 */     this._nodeStk.push(this._root);
/*     */   }
/*     */ 
/*     */   
/*     */   public void endDocument() {
/* 102 */     this._nodeStk.pop();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes) {
/* 108 */     Element element = this._document.createElementNS(paramString1, paramString3);
/*     */ 
/*     */     
/* 111 */     if (this._namespaceDecls != null) {
/*     */       
/* 113 */       int j = this._namespaceDecls.size();
/* 114 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 116 */         String str = this._namespaceDecls.elementAt(b1++);
/*     */         
/* 118 */         if (str == null || str.equals("")) {
/*     */           
/* 120 */           element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns", this._namespaceDecls.elementAt(b1));
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 125 */           element.setAttributeNS("http://www.w3.org/2000/xmlns/", "xmlns:" + str, this._namespaceDecls.elementAt(b1));
/*     */         } 
/*     */       } 
/*     */       
/* 129 */       this._namespaceDecls.clear();
/*     */     } 
/*     */ 
/*     */     
/* 133 */     int i = paramAttributes.getLength();
/* 134 */     for (byte b = 0; b < i; b++) {
/*     */       
/* 136 */       if (paramAttributes.getLocalName(b) == null) {
/*     */         
/* 138 */         element.setAttribute(paramAttributes.getQName(b), paramAttributes.getValue(b));
/*     */       }
/*     */       else {
/*     */         
/* 142 */         element.setAttributeNS(paramAttributes.getURI(b), paramAttributes.getQName(b), paramAttributes.getValue(b));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 148 */     Node node = this._nodeStk.peek();
/* 149 */     node.appendChild(element);
/*     */ 
/*     */     
/* 152 */     this._nodeStk.push(element);
/*     */   }
/*     */ 
/*     */   
/*     */   public void endElement(String paramString1, String paramString2, String paramString3) {
/* 157 */     this._nodeStk.pop();
/*     */   }
/*     */ 
/*     */   
/*     */   public void startPrefixMapping(String paramString1, String paramString2) {
/* 162 */     if (this._namespaceDecls == null)
/*     */     {
/* 164 */       this._namespaceDecls = new Vector(2);
/*     */     }
/* 166 */     this._namespaceDecls.addElement(paramString1);
/* 167 */     this._namespaceDecls.addElement(paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void endPrefixMapping(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ignorableWhitespace(char[] paramArrayOfchar, int paramInt1, int paramInt2) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processingInstruction(String paramString1, String paramString2) {
/* 188 */     Node node = this._nodeStk.peek();
/* 189 */     ProcessingInstruction processingInstruction = this._document.createProcessingInstruction(paramString1, paramString2);
/*     */     
/* 191 */     if (processingInstruction != null) node.appendChild(processingInstruction);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentLocator(Locator paramLocator) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void skippedEntity(String paramString) {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void comment(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 216 */     Node node = this._nodeStk.peek();
/* 217 */     Comment comment = this._document.createComment(new String(paramArrayOfchar, paramInt1, paramInt2));
/* 218 */     if (comment != null) node.appendChild(comment); 
/*     */   }
/*     */   
/*     */   public void startCDATA() {}
/*     */   
/*     */   public void endCDATA() {}
/*     */   
/*     */   public void startEntity(String paramString) {}
/*     */   
/*     */   public void endEntity(String paramString) {}
/*     */   
/*     */   public void startDTD(String paramString1, String paramString2, String paramString3) throws SAXException {}
/*     */   
/*     */   public void endDTD() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\Sax2Dom.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */