/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Iterator;
/*      */ import java.util.Locale;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import javax.xml.transform.Source;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlRuntimeException;
/*      */ import org.apache.xmlbeans.impl.common.XMLChar;
/*      */ import org.apache.xmlbeans.impl.soap.Detail;
/*      */ import org.apache.xmlbeans.impl.soap.DetailEntry;
/*      */ import org.apache.xmlbeans.impl.soap.Name;
/*      */ import org.apache.xmlbeans.impl.soap.Node;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPBody;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPException;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPFault;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeader;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPPart;
/*      */ import org.apache.xmlbeans.impl.soap.Text;
/*      */ import org.w3c.dom.Attr;
/*      */ import org.w3c.dom.CDATASection;
/*      */ import org.w3c.dom.CharacterData;
/*      */ import org.w3c.dom.Comment;
/*      */ import org.w3c.dom.DOMException;
/*      */ import org.w3c.dom.DOMImplementation;
/*      */ import org.w3c.dom.Document;
/*      */ import org.w3c.dom.DocumentFragment;
/*      */ import org.w3c.dom.DocumentType;
/*      */ import org.w3c.dom.Element;
/*      */ import org.w3c.dom.EntityReference;
/*      */ import org.w3c.dom.NamedNodeMap;
/*      */ import org.w3c.dom.Node;
/*      */ import org.w3c.dom.NodeList;
/*      */ import org.w3c.dom.ProcessingInstruction;
/*      */ import org.w3c.dom.Text;
/*      */ import org.w3c.dom.UserDataHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class DomImpl
/*      */ {
/*      */   static final int ELEMENT = 1;
/*      */   static final int ATTR = 2;
/*      */   static final int TEXT = 3;
/*      */   static final int CDATA = 4;
/*      */   static final int ENTITYREF = 5;
/*      */   static final int ENTITY = 6;
/*      */   static final int PROCINST = 7;
/*      */   static final int COMMENT = 8;
/*      */   static final int DOCUMENT = 9;
/*      */   static final int DOCTYPE = 10;
/*      */   static final int DOCFRAG = 11;
/*      */   static final int NOTATION = 12;
/*      */   
/*      */   static Dom parent(Dom paramDom) {
/*   99 */     return node_getParentNode(paramDom);
/*  100 */   } static Dom firstChild(Dom paramDom) { return node_getFirstChild(paramDom); }
/*  101 */   static Dom nextSibling(Dom paramDom) { return node_getNextSibling(paramDom); } static Dom prevSibling(Dom paramDom) {
/*  102 */     return node_getPreviousSibling(paramDom);
/*      */   }
/*      */   
/*      */   public static Dom append(Dom paramDom1, Dom paramDom2) {
/*  106 */     return node_insertBefore(paramDom2, paramDom1, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom insert(Dom paramDom1, Dom paramDom2) {
/*  111 */     assert paramDom2 != null;
/*  112 */     return node_insertBefore(parent(paramDom2), paramDom1, paramDom2);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom remove(Dom paramDom) {
/*  117 */     Dom dom = parent(paramDom);
/*      */     
/*  119 */     if (dom != null) {
/*  120 */       node_removeChild(dom, paramDom);
/*      */     }
/*  122 */     return paramDom;
/*      */   } static interface Dom {
/*      */     Locale locale(); int nodeType(); Cur tempCur();
/*      */     b getQName();
/*      */     boolean nodeCanHavePrefixUri();
/*      */     void dump();
/*      */     void dump(PrintStream param1PrintStream);
/*      */     void dump(PrintStream param1PrintStream, Object param1Object); }
/*      */   static class HierarchyRequestErr extends DOMException {
/*  131 */     HierarchyRequestErr() { this("This node isn't allowed there"); } HierarchyRequestErr(String param1String) {
/*  132 */       super((short)3, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class WrongDocumentErr extends DOMException {
/*  137 */     WrongDocumentErr() { this("Nodes do not belong to the same document"); } WrongDocumentErr(String param1String) {
/*  138 */       super((short)4, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class NotFoundErr extends DOMException {
/*  143 */     NotFoundErr() { this("Node not found"); } NotFoundErr(String param1String) {
/*  144 */       super((short)8, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class NamespaceErr extends DOMException {
/*  149 */     NamespaceErr() { this("Namespace error"); } NamespaceErr(String param1String) {
/*  150 */       super((short)14, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class NoModificationAllowedErr extends DOMException {
/*  155 */     NoModificationAllowedErr() { this("No modification allowed error"); } NoModificationAllowedErr(String param1String) {
/*  156 */       super((short)7, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class InuseAttributeError extends DOMException {
/*  161 */     InuseAttributeError() { this("Attribute currently in use error"); } InuseAttributeError(String param1String) {
/*  162 */       super((short)10, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class IndexSizeError extends DOMException {
/*  167 */     IndexSizeError() { this("Index Size Error"); } IndexSizeError(String param1String) {
/*  168 */       super((short)1, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class NotSupportedError extends DOMException {
/*  173 */     NotSupportedError() { this("This operation is not supported"); } NotSupportedError(String param1String) {
/*  174 */       super((short)9, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class InvalidCharacterError extends DOMException {
/*  179 */     InvalidCharacterError() { this("The name contains an invalid character"); } InvalidCharacterError(String param1String) {
/*  180 */       super((short)5, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class EmptyNodeList
/*      */     implements NodeList
/*      */   {
/*      */     private EmptyNodeList() {}
/*      */     
/*  189 */     public int getLength() { return 0; } public Node item(int param1Int) {
/*  190 */       return null;
/*      */     } }
/*      */   
/*  193 */   public static NodeList _emptyNodeList = new EmptyNodeList();
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   static String nodeKindName(int paramInt) {
/*  197 */     switch (paramInt) {
/*      */       case 2:
/*  199 */         return "attribute";
/*  200 */       case 4: return "cdata section";
/*  201 */       case 8: return "comment";
/*  202 */       case 11: return "document fragment";
/*  203 */       case 9: return "document";
/*  204 */       case 10: return "document type";
/*  205 */       case 1: return "element";
/*  206 */       case 6: return "entity";
/*  207 */       case 5: return "entity reference";
/*  208 */       case 12: return "notation";
/*  209 */       case 7: return "processing instruction";
/*  210 */       case 3: return "text";
/*      */     } 
/*  212 */     throw new RuntimeException("Unknown node type");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static String isValidChild(Dom paramDom1, Dom paramDom2) {
/*  218 */     int i = paramDom1.nodeType();
/*  219 */     int j = paramDom2.nodeType();
/*      */     
/*  221 */     switch (i) {
/*      */ 
/*      */       
/*      */       case 9:
/*  225 */         switch (j) {
/*      */ 
/*      */           
/*      */           case 1:
/*  229 */             if (document_getDocumentElement(paramDom1) != null) {
/*  230 */               return "Documents may only have a maximum of one document element";
/*      */             }
/*  232 */             return null;
/*      */ 
/*      */           
/*      */           case 10:
/*  236 */             if (document_getDoctype(paramDom1) != null) {
/*  237 */               return "Documents may only have a maximum of one document type node";
/*      */             }
/*  239 */             return null;
/*      */           
/*      */           case 7:
/*      */           case 8:
/*  243 */             return null;
/*      */         } 
/*      */ 
/*      */         
/*      */         break;
/*      */ 
/*      */       
/*      */       case 2:
/*  251 */         if (j == 3 || j == 5) {
/*  252 */           return null;
/*      */         }
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 5:
/*      */       case 6:
/*      */       case 11:
/*  265 */         switch (j) {
/*      */           
/*      */           case 1:
/*      */           case 3:
/*      */           case 4:
/*      */           case 5:
/*      */           case 7:
/*      */           case 8:
/*  273 */             return null;
/*      */         } 
/*      */ 
/*      */         
/*      */         break;
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 7:
/*      */       case 8:
/*      */       case 10:
/*      */       case 12:
/*  285 */         return nodeKindName(i) + " nodes may not have any children";
/*      */     } 
/*      */     
/*  288 */     return nodeKindName(i) + " nodes may not have " + nodeKindName(j) + " nodes as children";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void validateNewChild(Dom paramDom1, Dom paramDom2) {
/*  295 */     String str = isValidChild(paramDom1, paramDom2);
/*      */     
/*  297 */     if (str != null) {
/*  298 */       throw new HierarchyRequestErr(str);
/*      */     }
/*  300 */     if (paramDom1 == paramDom2) {
/*  301 */       throw new HierarchyRequestErr("New child and parent are the same node");
/*      */     }
/*  303 */     while ((paramDom1 = parent(paramDom1)) != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  308 */       if (paramDom2.nodeType() == 5) {
/*  309 */         throw new NoModificationAllowedErr("Entity reference trees may not be modified");
/*      */       }
/*  311 */       if (paramDom2 == paramDom1) {
/*  312 */         throw new HierarchyRequestErr("New child is an ancestor node of the parent node");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private static String validatePrefix(String paramString1, String paramString2, String paramString3, boolean paramBoolean) {
/*  319 */     validateNcName(paramString1);
/*      */     
/*  321 */     if (paramString1 == null) {
/*  322 */       paramString1 = "";
/*      */     }
/*  324 */     if (paramString2 == null) {
/*  325 */       paramString2 = "";
/*      */     }
/*  327 */     if (paramString1.length() > 0 && paramString2.length() == 0) {
/*  328 */       throw new NamespaceErr("Attempt to give a prefix for no namespace");
/*      */     }
/*  330 */     if (paramString1.equals("xml") && !paramString2.equals("http://www.w3.org/XML/1998/namespace")) {
/*  331 */       throw new NamespaceErr("Invalid prefix - begins with 'xml'");
/*      */     }
/*  333 */     if (paramBoolean) {
/*      */       
/*  335 */       if (paramString1.length() > 0) {
/*      */         
/*  337 */         if (paramString3.equals("xmlns")) {
/*  338 */           throw new NamespaceErr("Invalid namespace - attr is default namespace already");
/*      */         }
/*  340 */         if (Locale.beginsWithXml(paramString3)) {
/*  341 */           throw new NamespaceErr("Invalid namespace - attr prefix begins with 'xml'");
/*      */         }
/*  343 */         if (paramString1.equals("xmlns") && !paramString2.equals("http://www.w3.org/2000/xmlns/")) {
/*  344 */           throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
/*      */         
/*      */         }
/*      */       }
/*  348 */       else if (paramString3.equals("xmlns") && !paramString2.equals("http://www.w3.org/2000/xmlns/")) {
/*  349 */         throw new NamespaceErr("Invalid namespace - uri is not 'http://www.w3.org/2000/xmlns/;");
/*      */       }
/*      */     
/*  352 */     } else if (Locale.beginsWithXml(paramString1)) {
/*  353 */       throw new NamespaceErr("Invalid prefix - begins with 'xml'");
/*      */     } 
/*  355 */     return paramString1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void validateName(String paramString) {
/*  360 */     if (paramString == null) {
/*  361 */       throw new IllegalArgumentException("Name is null");
/*      */     }
/*  363 */     if (paramString.length() == 0) {
/*  364 */       throw new IllegalArgumentException("Name is empty");
/*      */     }
/*  366 */     if (!XMLChar.isValidName(paramString)) {
/*  367 */       throw new InvalidCharacterError("Name has an invalid character");
/*      */     }
/*      */   }
/*      */   
/*      */   private static void validateNcName(String paramString) {
/*  372 */     if (paramString != null && paramString.length() > 0 && !XMLChar.isValidNCName(paramString))
/*  373 */       throw new InvalidCharacterError(); 
/*      */   }
/*      */   
/*      */   private static void validateQualifiedName(String paramString1, String paramString2, boolean paramBoolean) {
/*      */     String str;
/*  378 */     assert paramString1 != null;
/*      */     
/*  380 */     if (paramString2 == null) {
/*  381 */       paramString2 = "";
/*      */     }
/*  383 */     int i = paramString1.indexOf(':');
/*      */ 
/*      */ 
/*      */     
/*  387 */     if (i < 0) {
/*      */       
/*  389 */       validateNcName(str = paramString1);
/*      */       
/*  391 */       if (paramBoolean && str.equals("xmlns") && !paramString2.equals("http://www.w3.org/2000/xmlns/"))
/*      */       {
/*  393 */         throw new NamespaceErr("Default xmlns attribute does not have namespace: http://www.w3.org/2000/xmlns/");
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/*  400 */       if (i == 0) {
/*  401 */         throw new NamespaceErr("Invalid qualified name, no prefix specified");
/*      */       }
/*  403 */       String str1 = paramString1.substring(0, i);
/*      */       
/*  405 */       validateNcName(str1);
/*      */       
/*  407 */       if (paramString2.length() == 0) {
/*  408 */         throw new NamespaceErr("Attempt to give a prefix for no namespace");
/*      */       }
/*  410 */       str = paramString1.substring(i + 1);
/*      */       
/*  412 */       if (str.indexOf(':') >= 0) {
/*  413 */         throw new NamespaceErr("Invalid qualified name, more than one colon");
/*      */       }
/*  415 */       validateNcName(str);
/*      */       
/*  417 */       if (str1.equals("xml") && !paramString2.equals("http://www.w3.org/XML/1998/namespace")) {
/*  418 */         throw new NamespaceErr("Invalid prefix - begins with 'xml'");
/*      */       }
/*      */     } 
/*  421 */     if (str.length() == 0) {
/*  422 */       throw new NamespaceErr("Invalid qualified name, no local part specified");
/*      */     }
/*      */   }
/*      */   
/*      */   private static void removeNode(Dom paramDom) {
/*  427 */     assert paramDom.nodeType() != 3 && paramDom.nodeType() != 4;
/*      */     
/*  429 */     Cur cur = paramDom.tempCur();
/*      */     
/*  431 */     cur.toEnd();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  437 */     if (cur.next()) {
/*      */       
/*  439 */       CharNode charNode = cur.getCharNodes();
/*      */       
/*  441 */       if (charNode != null) {
/*      */         
/*  443 */         cur.setCharNodes(null);
/*  444 */         Cur cur1 = paramDom.tempCur();
/*  445 */         cur1.setCharNodes(CharNode.appendNodes(cur1.getCharNodes(), charNode));
/*  446 */         cur1.release();
/*      */       } 
/*      */     } 
/*      */     
/*  450 */     cur.release();
/*      */     
/*  452 */     Cur.moveNode((Xobj)paramDom, null);
/*      */   }
/*      */   private static abstract class ElementsNodeList implements NodeList { private DomImpl.Dom _root; private Locale _locale; private long _version;
/*      */     private ArrayList _elements;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     ElementsNodeList(DomImpl.Dom param1Dom) {
/*  459 */       assert param1Dom.nodeType() == 9 || param1Dom.nodeType() == 1;
/*      */       
/*  461 */       this._root = param1Dom;
/*  462 */       this._locale = this._root.locale();
/*  463 */       this._version = 0L;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getLength() {
/*  468 */       ensureElements();
/*      */       
/*  470 */       return this._elements.size();
/*      */     }
/*      */ 
/*      */     
/*      */     public Node item(int param1Int) {
/*  475 */       ensureElements();
/*      */       
/*  477 */       return (param1Int < 0 || param1Int >= this._elements.size()) ? (Node)null : this._elements.get(param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     private void ensureElements() {
/*  482 */       if (this._version == this._locale.version()) {
/*      */         return;
/*      */       }
/*  485 */       this._version = this._locale.version();
/*      */       
/*  487 */       this._elements = new ArrayList();
/*      */       
/*  489 */       Locale locale = this._locale;
/*      */       
/*  491 */       if (locale.noSync()) { locale.enter(); try { addElements(this._root); } finally { locale.exit(); }  }
/*  492 */       else { synchronized (locale) { locale.enter(); try { addElements(this._root); } finally { locale.exit(); }
/*      */            }
/*      */          }
/*      */     
/*      */     } private void addElements(DomImpl.Dom param1Dom) {
/*  497 */       for (DomImpl.Dom dom = DomImpl.firstChild(param1Dom); dom != null; dom = DomImpl.nextSibling(dom)) {
/*      */         
/*  499 */         if (dom.nodeType() == 1) {
/*      */           
/*  501 */           if (match(dom)) {
/*  502 */             this._elements.add(dom);
/*      */           }
/*  504 */           addElements(dom);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected abstract boolean match(DomImpl.Dom param1Dom); }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class ElementsByTagNameNodeList
/*      */     extends ElementsNodeList
/*      */   {
/*      */     private String _name;
/*      */ 
/*      */     
/*      */     ElementsByTagNameNodeList(DomImpl.Dom param1Dom, String param1String) {
/*  521 */       super(param1Dom);
/*      */       
/*  523 */       this._name = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean match(DomImpl.Dom param1Dom) {
/*  528 */       return this._name.equals("*") ? true : DomImpl._node_getNodeName(param1Dom).equals(this._name);
/*      */     }
/*      */   }
/*      */   
/*      */   private static class ElementsByTagNameNSNodeList
/*      */     extends ElementsNodeList {
/*      */     private String _uri;
/*      */     private String _local;
/*      */     
/*      */     ElementsByTagNameNSNodeList(DomImpl.Dom param1Dom, String param1String1, String param1String2) {
/*  538 */       super(param1Dom);
/*      */       
/*  540 */       this._uri = (param1String1 == null) ? "" : param1String1;
/*  541 */       this._local = param1String2;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean match(DomImpl.Dom param1Dom) {
/*  546 */       if (!this._uri.equals("*") && !DomImpl._node_getNamespaceURI(param1Dom).equals(this._uri)) {
/*  547 */         return false;
/*      */       }
/*  549 */       return this._local.equals("*") ? true : DomImpl._node_getLocalName(param1Dom).equals(this._local);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Document _domImplementation_createDocument(Locale paramLocale, String paramString1, String paramString2, DocumentType paramDocumentType) {
/*  565 */     if (paramLocale.noSync()) { paramLocale.enter(); try { return domImplementation_createDocument(paramLocale, paramString1, paramString2, paramDocumentType); } finally { paramLocale.exit(); }  }
/*  566 */      synchronized (paramLocale) { paramLocale.enter(); try { return domImplementation_createDocument(paramLocale, paramString1, paramString2, paramDocumentType); } finally { paramLocale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   
/*      */   public static Document domImplementation_createDocument(Locale paramLocale, String paramString1, String paramString2, DocumentType paramDocumentType) {
/*  572 */     validateQualifiedName(paramString2, paramString1, false);
/*      */     
/*  574 */     Cur cur = paramLocale.tempCur();
/*      */     
/*  576 */     cur.createDomDocumentRoot();
/*      */     
/*  578 */     Document document = (Document)cur.getDom();
/*      */     
/*  580 */     cur.next();
/*      */     
/*  582 */     cur.createElement(paramLocale.makeQualifiedQName(paramString1, paramString2));
/*      */     
/*  584 */     if (paramDocumentType != null) {
/*  585 */       throw new RuntimeException("Not impl");
/*      */     }
/*  587 */     cur.toParent();
/*      */ 
/*      */     
/*      */     try {
/*  591 */       Locale.autoTypeDocument(cur, null, null);
/*      */     }
/*  593 */     catch (XmlException xmlException) {
/*      */       
/*  595 */       throw new XmlRuntimeException(xmlException);
/*      */     } 
/*      */     
/*  598 */     cur.release();
/*      */     
/*  600 */     return document;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _domImplementation_hasFeature(Locale paramLocale, String paramString1, String paramString2) {
/*  609 */     if (paramString1 == null) {
/*  610 */       return false;
/*      */     }
/*  612 */     if (paramString2 != null && paramString2.length() > 0 && !paramString2.equals("1.0") && !paramString2.equals("2.0"))
/*      */     {
/*      */       
/*  615 */       return false;
/*      */     }
/*      */     
/*  618 */     if (paramString1.equalsIgnoreCase("core")) {
/*  619 */       return true;
/*      */     }
/*  621 */     if (paramString1.equalsIgnoreCase("xml")) {
/*  622 */       return true;
/*      */     }
/*  624 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Element _document_getDocumentElement(Dom paramDom) {
/*      */     Dom dom;
/*  633 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  637 */     if (locale.noSync()) { locale.enter(); try { dom = document_getDocumentElement(paramDom); } finally { locale.exit(); }  }
/*  638 */     else { synchronized (locale) { locale.enter(); try { dom = document_getDocumentElement(paramDom); } finally { locale.exit(); }  }
/*      */        }
/*  640 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_getDocumentElement(Dom paramDom) {
/*  645 */     for (paramDom = firstChild(paramDom); paramDom != null; paramDom = nextSibling(paramDom)) {
/*      */       
/*  647 */       if (paramDom.nodeType() == 1) {
/*  648 */         return paramDom;
/*      */       }
/*      */     } 
/*  651 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DocumentFragment _document_createDocumentFragment(Dom paramDom) {
/*      */     Dom dom;
/*  660 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  664 */     if (locale.noSync()) { locale.enter(); try { dom = document_createDocumentFragment(paramDom); } finally { locale.exit(); }  }
/*  665 */     else { synchronized (locale) { locale.enter(); try { dom = document_createDocumentFragment(paramDom); } finally { locale.exit(); }  }
/*      */        }
/*  667 */      return (DocumentFragment)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createDocumentFragment(Dom paramDom) {
/*  672 */     Cur cur = paramDom.locale().tempCur();
/*      */     
/*  674 */     cur.createDomDocFragRoot();
/*      */     
/*  676 */     Dom dom = cur.getDom();
/*      */     
/*  678 */     cur.release();
/*      */     
/*  680 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Element _document_createElement(Dom paramDom, String paramString) {
/*      */     Dom dom;
/*  689 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  693 */     if (locale.noSync()) { locale.enter(); try { dom = document_createElement(paramDom, paramString); } finally { locale.exit(); }  }
/*  694 */     else { synchronized (locale) { locale.enter(); try { dom = document_createElement(paramDom, paramString); } finally { locale.exit(); }  }
/*      */        }
/*  696 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createElement(Dom paramDom, String paramString) {
/*  701 */     validateName(paramString);
/*      */     
/*  703 */     Locale locale = paramDom.locale();
/*      */     
/*  705 */     Cur cur = locale.tempCur();
/*      */     
/*  707 */     cur.createElement(locale.makeQualifiedQName("", paramString));
/*      */     
/*  709 */     Dom dom = cur.getDom();
/*      */     
/*  711 */     cur.release();
/*  712 */     ((Xobj.ElementXobj)dom)._canHavePrefixUri = false;
/*  713 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Element _document_createElementNS(Dom paramDom, String paramString1, String paramString2) {
/*      */     Dom dom;
/*  722 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  726 */     if (locale.noSync()) { locale.enter(); try { dom = document_createElementNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*  727 */     else { synchronized (locale) { locale.enter(); try { dom = document_createElementNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*      */        }
/*  729 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createElementNS(Dom paramDom, String paramString1, String paramString2) {
/*  734 */     validateQualifiedName(paramString2, paramString1, false);
/*      */     
/*  736 */     Locale locale = paramDom.locale();
/*      */     
/*  738 */     Cur cur = locale.tempCur();
/*      */     
/*  740 */     cur.createElement(locale.makeQualifiedQName(paramString1, paramString2));
/*      */     
/*  742 */     Dom dom = cur.getDom();
/*      */     
/*  744 */     cur.release();
/*      */     
/*  746 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _document_createAttribute(Dom paramDom, String paramString) {
/*      */     Dom dom;
/*  755 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  759 */     if (locale.noSync()) { locale.enter(); try { dom = document_createAttribute(paramDom, paramString); } finally { locale.exit(); }  }
/*  760 */     else { synchronized (locale) { locale.enter(); try { dom = document_createAttribute(paramDom, paramString); } finally { locale.exit(); }  }
/*      */        }
/*  762 */      return (Attr)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createAttribute(Dom paramDom, String paramString) {
/*  767 */     validateName(paramString);
/*      */     
/*  769 */     Locale locale = paramDom.locale();
/*      */     
/*  771 */     Cur cur = locale.tempCur();
/*      */     
/*  773 */     cur.createAttr(locale.makeQualifiedQName("", paramString));
/*      */     
/*  775 */     Dom dom = cur.getDom();
/*      */     
/*  777 */     cur.release();
/*  778 */     ((Xobj.AttrXobj)dom)._canHavePrefixUri = false;
/*  779 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _document_createAttributeNS(Dom paramDom, String paramString1, String paramString2) {
/*      */     Dom dom;
/*  788 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  792 */     if (locale.noSync()) { locale.enter(); try { dom = document_createAttributeNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*  793 */     else { synchronized (locale) { locale.enter(); try { dom = document_createAttributeNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*      */        }
/*  795 */      return (Attr)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createAttributeNS(Dom paramDom, String paramString1, String paramString2) {
/*  800 */     validateQualifiedName(paramString2, paramString1, true);
/*      */     
/*  802 */     Locale locale = paramDom.locale();
/*      */     
/*  804 */     Cur cur = locale.tempCur();
/*      */     
/*  806 */     cur.createAttr(locale.makeQualifiedQName(paramString1, paramString2));
/*      */     
/*  808 */     Dom dom = cur.getDom();
/*      */     
/*  810 */     cur.release();
/*      */     
/*  812 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Comment _document_createComment(Dom paramDom, String paramString) {
/*      */     Dom dom;
/*  821 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  825 */     if (locale.noSync()) { locale.enter(); try { dom = document_createComment(paramDom, paramString); } finally { locale.exit(); }  }
/*  826 */     else { synchronized (locale) { locale.enter(); try { dom = document_createComment(paramDom, paramString); } finally { locale.exit(); }  }
/*      */        }
/*  828 */      return (Comment)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createComment(Dom paramDom, String paramString) {
/*  833 */     Locale locale = paramDom.locale();
/*      */     
/*  835 */     Cur cur = locale.tempCur();
/*      */     
/*  837 */     cur.createComment();
/*      */     
/*  839 */     Dom dom = cur.getDom();
/*      */     
/*  841 */     if (paramString != null) {
/*      */       
/*  843 */       cur.next();
/*  844 */       cur.insertString(paramString);
/*      */     } 
/*      */     
/*  847 */     cur.release();
/*      */     
/*  849 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ProcessingInstruction _document_createProcessingInstruction(Dom paramDom, String paramString1, String paramString2) {
/*      */     Dom dom;
/*  858 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/*  862 */     if (locale.noSync()) { locale.enter(); try { dom = document_createProcessingInstruction(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*  863 */     else { synchronized (locale) { locale.enter(); try { dom = document_createProcessingInstruction(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*      */        }
/*  865 */      return (ProcessingInstruction)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createProcessingInstruction(Dom paramDom, String paramString1, String paramString2) {
/*  870 */     if (paramString1 == null) {
/*  871 */       throw new IllegalArgumentException("Target is null");
/*      */     }
/*  873 */     if (paramString1.length() == 0) {
/*  874 */       throw new IllegalArgumentException("Target is empty");
/*      */     }
/*  876 */     if (!XMLChar.isValidName(paramString1)) {
/*  877 */       throw new InvalidCharacterError("Target has an invalid character");
/*      */     }
/*  879 */     if (Locale.beginsWithXml(paramString1) && paramString1.length() == 3) {
/*  880 */       throw new InvalidCharacterError("Invalid target - is 'xml'");
/*      */     }
/*  882 */     Locale locale = paramDom.locale();
/*      */     
/*  884 */     Cur cur = locale.tempCur();
/*      */     
/*  886 */     cur.createProcinst(paramString1);
/*      */     
/*  888 */     Dom dom = cur.getDom();
/*      */     
/*  890 */     if (paramString2 != null) {
/*      */       
/*  892 */       cur.next();
/*  893 */       cur.insertString(paramString2);
/*      */     } 
/*      */     
/*  896 */     cur.release();
/*      */     
/*  898 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static CDATASection _document_createCDATASection(Dom paramDom, String paramString) {
/*  907 */     return (CDATASection)document_createCDATASection(paramDom, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_createCDATASection(Dom paramDom, String paramString) {
/*  912 */     CdataNode cdataNode = paramDom.locale().createCdataNode();
/*      */     
/*  914 */     if (paramString == null) {
/*  915 */       paramString = "";
/*      */     }
/*  917 */     cdataNode.setChars(paramString, 0, paramString.length());
/*      */     
/*  919 */     return cdataNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Text _document_createTextNode(Dom paramDom, String paramString) {
/*  928 */     return (Text)document_createTextNode(paramDom, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public static CharNode document_createTextNode(Dom paramDom, String paramString) {
/*  933 */     TextNode textNode = paramDom.locale().createTextNode();
/*      */     
/*  935 */     if (paramString == null) {
/*  936 */       paramString = "";
/*      */     }
/*  938 */     textNode.setChars(paramString, 0, paramString.length());
/*      */     
/*  940 */     return textNode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static EntityReference _document_createEntityReference(Dom paramDom, String paramString) {
/*  949 */     throw new RuntimeException("Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Element _document_getElementById(Dom paramDom, String paramString) {
/*  958 */     throw new RuntimeException("Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NodeList _document_getElementsByTagName(Dom paramDom, String paramString) {
/*  967 */     Locale locale = paramDom.locale();
/*      */     
/*  969 */     if (locale.noSync()) { locale.enter(); try { return document_getElementsByTagName(paramDom, paramString); } finally { locale.exit(); }  }
/*  970 */      synchronized (locale) { locale.enter(); try { return document_getElementsByTagName(paramDom, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static NodeList document_getElementsByTagName(Dom paramDom, String paramString) {
/*  975 */     return new ElementsByTagNameNodeList(paramDom, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NodeList _document_getElementsByTagNameNS(Dom paramDom, String paramString1, String paramString2) {
/*  984 */     Locale locale = paramDom.locale();
/*      */     
/*  986 */     if (locale.noSync()) { locale.enter(); try { return document_getElementsByTagNameNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*  987 */      synchronized (locale) { locale.enter(); try { return document_getElementsByTagNameNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static NodeList document_getElementsByTagNameNS(Dom paramDom, String paramString1, String paramString2) {
/*  992 */     return new ElementsByTagNameNSNodeList(paramDom, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DOMImplementation _document_getImplementation(Dom paramDom) {
/* 1001 */     return paramDom.locale();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _document_importNode(Dom paramDom, Node paramNode, boolean paramBoolean) {
/*      */     Dom dom;
/* 1010 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1019 */     if (locale.noSync()) { locale.enter(); try { dom = document_importNode(paramDom, paramNode, paramBoolean); } finally { locale.exit(); }  }
/* 1020 */     else { synchronized (locale) { locale.enter(); try { dom = document_importNode(paramDom, paramNode, paramBoolean); } finally { locale.exit(); }
/*      */          }
/*      */        }
/* 1023 */      return (Node)dom; } public static Dom document_importNode(Dom paramDom, Node paramNode, boolean paramBoolean) {
/*      */     Dom dom;
/*      */     String str;
/*      */     NamedNodeMap namedNodeMap;
/*      */     byte b;
/* 1028 */     if (paramNode == null) {
/* 1029 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1033 */     boolean bool = false;
/*      */     
/* 1035 */     switch (paramNode.getNodeType()) {
/*      */       
/*      */       case 9:
/* 1038 */         throw new NotSupportedError("Document nodes may not be imported");
/*      */       
/*      */       case 10:
/* 1041 */         throw new NotSupportedError("Document type nodes may not be imported");
/*      */ 
/*      */       
/*      */       case 1:
/* 1045 */         str = paramNode.getLocalName();
/*      */         
/* 1047 */         if (str == null || str.length() == 0) {
/* 1048 */           dom = document_createElement(paramDom, paramNode.getNodeName());
/*      */         } else {
/*      */           
/* 1051 */           String str1 = paramNode.getPrefix();
/* 1052 */           String str2 = (str1 == null || str1.length() == 0) ? str : (str1 + ":" + str);
/* 1053 */           String str3 = paramNode.getNamespaceURI();
/*      */           
/* 1055 */           if (str3 == null || str3.length() == 0) {
/* 1056 */             dom = document_createElement(paramDom, str2);
/*      */           } else {
/* 1058 */             dom = document_createElementNS(paramDom, str3, str2);
/*      */           } 
/*      */         } 
/* 1061 */         namedNodeMap = paramNode.getAttributes();
/*      */         
/* 1063 */         for (b = 0; b < namedNodeMap.getLength(); b++) {
/* 1064 */           attributes_setNamedItem(dom, document_importNode(paramDom, namedNodeMap.item(b), true));
/*      */         }
/* 1066 */         bool = paramBoolean;
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/* 1073 */         str = paramNode.getLocalName();
/*      */         
/* 1075 */         if (str == null || str.length() == 0) {
/* 1076 */           dom = document_createAttribute(paramDom, paramNode.getNodeName());
/*      */         } else {
/*      */           
/* 1079 */           String str1 = paramNode.getPrefix();
/* 1080 */           String str2 = (str1 == null || str1.length() == 0) ? str : (str1 + ":" + str);
/* 1081 */           String str3 = paramNode.getNamespaceURI();
/*      */           
/* 1083 */           if (str3 == null || str3.length() == 0) {
/* 1084 */             dom = document_createAttribute(paramDom, str2);
/*      */           } else {
/* 1086 */             dom = document_createAttributeNS(paramDom, str3, str2);
/*      */           } 
/*      */         } 
/* 1089 */         bool = true;
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 11:
/* 1096 */         dom = document_createDocumentFragment(paramDom);
/*      */         
/* 1098 */         bool = paramBoolean;
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 7:
/* 1105 */         dom = document_createProcessingInstruction(paramDom, paramNode.getNodeName(), paramNode.getNodeValue());
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 8:
/* 1111 */         dom = document_createComment(paramDom, paramNode.getNodeValue());
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/* 1117 */         dom = document_createTextNode(paramDom, paramNode.getNodeValue());
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 4:
/* 1123 */         dom = document_createCDATASection(paramDom, paramNode.getNodeValue());
/*      */         break;
/*      */ 
/*      */       
/*      */       case 5:
/*      */       case 6:
/*      */       case 12:
/* 1130 */         throw new RuntimeException("Not impl");
/*      */       default:
/* 1132 */         throw new RuntimeException("Unknown kind");
/*      */     } 
/*      */     
/* 1135 */     if (bool) {
/*      */       
/* 1137 */       NodeList nodeList = paramNode.getChildNodes();
/*      */       
/* 1139 */       for (byte b1 = 0; b1 < nodeList.getLength(); b1++) {
/* 1140 */         node_insertBefore(dom, document_importNode(paramDom, nodeList.item(b1), true), null);
/*      */       }
/*      */     } 
/* 1143 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DocumentType _document_getDoctype(Dom paramDom) {
/*      */     Dom dom;
/* 1152 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1156 */     if (locale.noSync()) { locale.enter(); try { dom = document_getDoctype(paramDom); } finally { locale.exit(); }  }
/* 1157 */     else { synchronized (locale) { locale.enter(); try { dom = document_getDoctype(paramDom); } finally { locale.exit(); }  }
/*      */        }
/* 1159 */      return (DocumentType)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom document_getDoctype(Dom paramDom) {
/* 1164 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Document _node_getOwnerDocument(Dom paramDom) {
/*      */     Dom dom;
/* 1173 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1177 */     if (locale.noSync()) { locale.enter(); try { dom = node_getOwnerDocument(paramDom); } finally { locale.exit(); }  }
/* 1178 */     else { synchronized (locale) { locale.enter(); try { dom = node_getOwnerDocument(paramDom); } finally { locale.exit(); }  }
/*      */        }
/* 1180 */      return (Document)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom node_getOwnerDocument(Dom paramDom) {
/* 1185 */     if (paramDom.nodeType() == 9) {
/* 1186 */       return null;
/*      */     }
/* 1188 */     Locale locale = paramDom.locale();
/*      */     
/* 1190 */     if (locale._ownerDoc == null) {
/*      */       
/* 1192 */       Cur cur = locale.tempCur();
/* 1193 */       cur.createDomDocumentRoot();
/* 1194 */       locale._ownerDoc = cur.getDom();
/* 1195 */       cur.release();
/*      */     } 
/*      */     
/* 1198 */     return locale._ownerDoc;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_getParentNode(Dom paramDom) {
/*      */     Dom dom;
/* 1207 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1211 */     if (locale.noSync()) { locale.enter(); try { dom = node_getParentNode(paramDom); } finally { locale.exit(); }  }
/* 1212 */     else { synchronized (locale) { locale.enter(); try { dom = node_getParentNode(paramDom); } finally { locale.exit(); }  }
/*      */        }
/* 1214 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom node_getParentNode(Dom paramDom) {
/* 1219 */     Cur cur = null;
/*      */     
/* 1221 */     switch (paramDom.nodeType()) {
/*      */       case 2:
/*      */       case 9:
/*      */       case 11:
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 7:
/*      */       case 8:
/* 1232 */         if (!(cur = paramDom.tempCur()).toParentRaw()) {
/*      */           
/* 1234 */           cur.release();
/* 1235 */           cur = null;
/*      */         } 
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/*      */       case 4:
/* 1244 */         if ((cur = paramDom.tempCur()) != null) {
/* 1245 */           cur.toParent();
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       case 5:
/* 1251 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 1256 */         throw new RuntimeException("Not impl");
/*      */       default:
/* 1258 */         throw new RuntimeException("Unknown kind");
/*      */     } 
/*      */     
/* 1261 */     if (cur == null) {
/* 1262 */       return null;
/*      */     }
/* 1264 */     Dom dom = cur.getDom();
/*      */     
/* 1266 */     cur.release();
/*      */     
/* 1268 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_getFirstChild(Dom paramDom) {
/*      */     Dom dom;
/* 1277 */     Locale locale = paramDom.locale();
/*      */ 
/*      */     
/* 1280 */     assert paramDom instanceof Xobj;
/* 1281 */     Xobj xobj = (Xobj)paramDom;
/* 1282 */     if (!xobj.isVacant()) {
/*      */       
/* 1284 */       if (xobj.isFirstChildPtrDomUsable())
/* 1285 */         return (Node)xobj._firstChild; 
/* 1286 */       Xobj xobj1 = xobj.lastAttr();
/* 1287 */       if (xobj1 != null && xobj1.isNextSiblingPtrDomUsable())
/*      */       {
/* 1289 */         return (Xobj.NodeXobj)xobj1._nextSibling; } 
/* 1290 */       if (xobj.isExistingCharNodesValueUsable())
/* 1291 */         return xobj._charNodesValue; 
/*      */     } 
/* 1293 */     if (locale.noSync()) { dom = node_getFirstChild(paramDom); }
/* 1294 */     else { synchronized (locale) { dom = node_getFirstChild(paramDom); }
/*      */        }
/* 1296 */      return (Node)dom;
/*      */   }
/*      */   
/*      */   public static Dom node_getFirstChild(Dom paramDom) {
/*      */     Xobj xobj1, xobj2;
/* 1301 */     Dom dom = null;
/*      */     
/* 1303 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 5:
/* 1312 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 1317 */         throw new RuntimeException("Not impl");
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 9:
/*      */       case 11:
/* 1325 */         xobj1 = (Xobj)paramDom;
/* 1326 */         xobj1.ensureOccupancy();
/* 1327 */         if (xobj1.isFirstChildPtrDomUsable())
/* 1328 */           return (Xobj.NodeXobj)xobj1._firstChild; 
/* 1329 */         xobj2 = xobj1.lastAttr();
/* 1330 */         if (xobj2 != null) {
/*      */           
/* 1332 */           if (xobj2.isNextSiblingPtrDomUsable())
/* 1333 */             return (Xobj.NodeXobj)xobj2._nextSibling; 
/* 1334 */           if (xobj2.isCharNodesAfterUsable())
/* 1335 */             return xobj2._charNodesAfter; 
/*      */         } 
/* 1337 */         if (xobj1.isCharNodesValueUsable()) {
/* 1338 */           return xobj1._charNodesValue;
/*      */         }
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1347 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_getLastChild(Dom paramDom) {
/*      */     Dom dom;
/* 1356 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1360 */     if (locale.noSync()) { locale.enter(); try { dom = node_getLastChild(paramDom); } finally { locale.exit(); }  }
/* 1361 */     else { synchronized (locale) { locale.enter(); try { dom = node_getLastChild(paramDom); } finally { locale.exit(); }  }
/*      */        }
/* 1363 */      return (Node)dom;
/*      */   }
/*      */   
/*      */   public static Dom node_getLastChild(Dom paramDom) {
/*      */     CharNode charNode;
/* 1368 */     switch (paramDom.nodeType()) {
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 7:
/*      */       case 8:
/* 1374 */         return null;
/*      */       
/*      */       case 5:
/* 1377 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 1382 */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1391 */     Dom dom = null;
/*      */ 
/*      */     
/* 1394 */     Cur cur = paramDom.tempCur();
/*      */     
/* 1396 */     if (cur.toLastChild()) {
/*      */       
/* 1398 */       dom = cur.getDom();
/*      */       
/* 1400 */       cur.skip();
/*      */       
/* 1402 */       if ((charNode = cur.getCharNodes()) != null) {
/* 1403 */         dom = null;
/*      */       }
/*      */     } else {
/*      */       
/* 1407 */       cur.next();
/* 1408 */       charNode = cur.getCharNodes();
/*      */     } 
/*      */     
/* 1411 */     if (dom == null && charNode != null) {
/*      */       
/* 1413 */       while (charNode._next != null) {
/* 1414 */         charNode = charNode._next;
/*      */       }
/* 1416 */       dom = charNode;
/*      */     } 
/*      */     
/* 1419 */     cur.release();
/*      */ 
/*      */ 
/*      */     
/* 1423 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_getNextSibling(Dom paramDom) {
/*      */     Dom dom;
/* 1432 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1436 */     if (locale.noSync()) { dom = node_getNextSibling(paramDom); }
/* 1437 */     else { synchronized (locale) { dom = node_getNextSibling(paramDom); }
/*      */        }
/* 1439 */      return (Node)dom; } public static Dom node_getNextSibling(Dom paramDom) {
/*      */     Xobj.NodeXobj nodeXobj;
/*      */     CharNode charNode2;
/*      */     Xobj xobj1, xobj2;
/*      */     boolean bool;
/* 1444 */     CharNode charNode1 = null;
/*      */     
/* 1446 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/*      */       case 4:
/* 1456 */         charNode2 = (CharNode)paramDom;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1463 */         if (!(charNode2._src instanceof Xobj))
/* 1464 */           return null; 
/* 1465 */         xobj2 = (Xobj)charNode2._src;
/*      */ 
/*      */         
/* 1468 */         xobj2._charNodesAfter = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesAfter, xobj2._cchAfter);
/*      */ 
/*      */         
/* 1471 */         xobj2._charNodesValue = Cur.updateCharNodes(xobj2._locale, xobj2, xobj2._charNodesValue, xobj2._cchValue);
/*      */ 
/*      */         
/* 1474 */         if (charNode2._next != null) {
/*      */           
/* 1476 */           charNode1 = charNode2._next;
/*      */           break;
/*      */         } 
/* 1479 */         bool = charNode2.isNodeAftertext();
/*      */         
/* 1481 */         if (bool) {
/* 1482 */           Xobj.NodeXobj nodeXobj1 = (Xobj.NodeXobj)xobj2._nextSibling; break;
/*      */         } 
/* 1484 */         nodeXobj = (Xobj.NodeXobj)xobj2._firstChild;
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 7:
/*      */       case 8:
/* 1493 */         assert paramDom instanceof Xobj : "PI, Comments and Elements always backed up by Xobj";
/* 1494 */         xobj1 = (Xobj)paramDom;
/* 1495 */         xobj1.ensureOccupancy();
/* 1496 */         if (xobj1.isNextSiblingPtrDomUsable()) {
/* 1497 */           return (Xobj.NodeXobj)xobj1._nextSibling;
/*      */         }
/* 1499 */         if (xobj1.isCharNodesAfterUsable()) {
/* 1500 */           return xobj1._charNodesAfter;
/*      */         }
/*      */         break;
/*      */       
/*      */       case 5:
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 1508 */         throw new RuntimeException("Not implemented");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1513 */     return nodeXobj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_getPreviousSibling(Dom paramDom) {
/*      */     Dom dom;
/* 1522 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 1526 */     if (locale.noSync()) { dom = node_getPreviousSibling(paramDom); }
/* 1527 */     else { synchronized (locale) { dom = node_getPreviousSibling(paramDom); }
/*      */        }
/* 1529 */      return (Node)dom; } public static Dom node_getPreviousSibling(Dom paramDom) {
/*      */     Dom dom1;
/*      */     CharNode charNode2;
/*      */     Xobj xobj1, xobj2;
/*      */     boolean bool;
/* 1534 */     CharNode charNode1 = null;
/*      */     
/* 1536 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */       
/*      */       case 3:
/*      */       case 4:
/* 1541 */         assert paramDom instanceof CharNode : "Text/CData should be a CharNode";
/* 1542 */         charNode2 = (CharNode)paramDom;
/* 1543 */         if (!(charNode2._src instanceof Xobj))
/* 1544 */           return null; 
/* 1545 */         xobj2 = (Xobj)charNode2._src;
/* 1546 */         xobj2.ensureOccupancy();
/* 1547 */         bool = charNode2.isNodeAftertext();
/* 1548 */         charNode1 = charNode2._prev;
/* 1549 */         if (charNode1 == null) {
/* 1550 */           Dom dom = bool ? (Dom)xobj2 : xobj2._charNodesValue;
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/* 1556 */         assert paramDom instanceof Xobj;
/* 1557 */         xobj1 = (Xobj)paramDom;
/* 1558 */         dom1 = (Dom)xobj1._prevSibling;
/* 1559 */         if (dom1 == null && xobj1._parent != null)
/* 1560 */           dom1 = node_getFirstChild((Dom)xobj1._parent); 
/*      */         break;
/*      */     } 
/* 1563 */     Dom dom2 = dom1;
/*      */     
/* 1565 */     while (dom2 != null && (dom2 = node_getNextSibling(dom2)) != paramDom)
/* 1566 */       dom1 = dom2; 
/* 1567 */     return dom1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_hasAttributes(Dom paramDom) {
/* 1576 */     Locale locale = paramDom.locale();
/*      */     
/* 1578 */     if (locale.noSync()) { locale.enter(); try { return node_hasAttributes(paramDom); } finally { locale.exit(); }  }
/* 1579 */      synchronized (locale) { locale.enter(); try { return node_hasAttributes(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static boolean node_hasAttributes(Dom paramDom) {
/* 1584 */     boolean bool = false;
/*      */     
/* 1586 */     if (paramDom.nodeType() == 1) {
/*      */       
/* 1588 */       Cur cur = paramDom.tempCur();
/*      */       
/* 1590 */       bool = cur.hasAttrs();
/*      */       
/* 1592 */       cur.release();
/*      */     } 
/*      */     
/* 1595 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_isSupported(Dom paramDom, String paramString1, String paramString2) {
/* 1604 */     return _domImplementation_hasFeature(paramDom.locale(), paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _node_normalize(Dom paramDom) {
/* 1613 */     Locale locale = paramDom.locale();
/*      */     
/* 1615 */     if (locale.noSync()) { locale.enter(); try { node_normalize(paramDom); } finally { locale.exit(); }  }
/* 1616 */     else { synchronized (locale) { locale.enter(); try { node_normalize(paramDom); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void node_normalize(Dom paramDom) {
/* 1621 */     switch (paramDom.nodeType()) {
/*      */       case 3:
/*      */       case 4:
/*      */       case 7:
/*      */       case 8:
/*      */         return;
/*      */ 
/*      */       
/*      */       case 5:
/* 1630 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 1635 */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1644 */     Cur cur = paramDom.tempCur();
/*      */     
/* 1646 */     cur.push();
/*      */ 
/*      */     
/*      */     do {
/* 1650 */       cur.nextWithAttrs();
/*      */       
/* 1652 */       CharNode charNode = cur.getCharNodes();
/*      */       
/* 1654 */       if (charNode == null)
/*      */         continue; 
/* 1656 */       if (!cur.isText()) {
/*      */         
/* 1658 */         while (charNode != null)
/*      */         {
/* 1660 */           charNode.setChars(null, 0, 0);
/* 1661 */           charNode = CharNode.remove(charNode, charNode);
/*      */         }
/*      */       
/* 1664 */       } else if (charNode._next != null) {
/*      */         
/* 1666 */         while (charNode._next != null) {
/*      */           
/* 1668 */           charNode.setChars(null, 0, 0);
/* 1669 */           charNode = CharNode.remove(charNode, charNode._next);
/*      */         } 
/*      */         
/* 1672 */         charNode._cch = Integer.MAX_VALUE;
/*      */       } 
/*      */       
/* 1675 */       cur.setCharNodes(charNode);
/*      */     
/*      */     }
/* 1678 */     while (!cur.isAtEndOfLastPush());
/*      */     
/* 1680 */     cur.release();
/*      */     
/* 1682 */     paramDom.locale().invalidateDomCaches(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_hasChildNodes(Dom paramDom) {
/* 1692 */     return (_node_getFirstChild(paramDom) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_appendChild(Dom paramDom, Node paramNode) {
/* 1701 */     return _node_insertBefore(paramDom, paramNode, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_replaceChild(Dom paramDom, Node paramNode1, Node paramNode2) {
/*      */     Dom dom3;
/* 1710 */     Locale locale = paramDom.locale();
/*      */     
/* 1712 */     if (paramNode1 == null) {
/* 1713 */       throw new IllegalArgumentException("Child to add is null");
/*      */     }
/* 1715 */     if (paramNode2 == null) {
/* 1716 */       throw new NotFoundErr("Child to replace is null");
/*      */     }
/*      */     
/*      */     Dom dom1;
/* 1720 */     if (!(paramNode1 instanceof Dom) || (dom1 = (Dom)paramNode1).locale() != locale) {
/* 1721 */       throw new WrongDocumentErr("Child to add is from another document");
/*      */     }
/* 1723 */     Dom dom2 = null;
/*      */     
/* 1725 */     if (!(paramNode2 instanceof Dom) || (dom2 = (Dom)paramNode2).locale() != locale) {
/* 1726 */       throw new WrongDocumentErr("Child to replace is from another document");
/*      */     }
/*      */ 
/*      */     
/* 1730 */     if (locale.noSync()) { locale.enter(); try { dom3 = node_replaceChild(paramDom, dom1, dom2); } finally { locale.exit(); }  }
/* 1731 */     else { synchronized (locale) { locale.enter(); try { dom3 = node_replaceChild(paramDom, dom1, dom2); } finally { locale.exit(); }  }
/*      */        }
/* 1733 */      return (Node)dom3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Dom node_replaceChild(Dom paramDom1, Dom paramDom2, Dom paramDom3) {
/* 1741 */     Dom dom = node_getNextSibling(paramDom3);
/*      */     
/* 1743 */     node_removeChild(paramDom1, paramDom3);
/*      */ 
/*      */     
/*      */     try {
/* 1747 */       node_insertBefore(paramDom1, paramDom2, dom);
/*      */     }
/* 1749 */     catch (DOMException dOMException) {
/*      */       
/* 1751 */       node_insertBefore(paramDom1, paramDom3, dom);
/*      */       
/* 1753 */       throw dOMException;
/*      */     } 
/*      */     
/* 1756 */     return paramDom3;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _node_insertBefore(Dom paramDom, Node paramNode1, Node paramNode2) {
/*      */     Dom dom3;
/* 1765 */     Locale locale = paramDom.locale();
/*      */     
/* 1767 */     if (paramNode1 == null) {
/* 1768 */       throw new IllegalArgumentException("Child to add is null");
/*      */     }
/*      */     
/*      */     Dom dom1;
/* 1772 */     if (!(paramNode1 instanceof Dom) || (dom1 = (Dom)paramNode1).locale() != locale) {
/* 1773 */       throw new WrongDocumentErr("Child to add is from another document");
/*      */     }
/* 1775 */     Dom dom2 = null;
/*      */     
/* 1777 */     if (paramNode2 != null)
/*      */     {
/* 1779 */       if (!(paramNode2 instanceof Dom) || (dom2 = (Dom)paramNode2).locale() != locale) {
/* 1780 */         throw new WrongDocumentErr("Reference child is from another document");
/*      */       }
/*      */     }
/*      */ 
/*      */     
/* 1785 */     if (locale.noSync()) { locale.enter(); try { dom3 = node_insertBefore(paramDom, dom1, dom2); } finally { locale.exit(); }  }
/* 1786 */     else { synchronized (locale) { locale.enter(); try { dom3 = node_insertBefore(paramDom, dom1, dom2); } finally { locale.exit(); }  }
/*      */        }
/* 1788 */      return (Node)dom3;
/*      */   } public static Dom node_insertBefore(Dom paramDom1, Dom paramDom2, Dom paramDom3) {
/*      */     CharNode charNode1, charNode2;
/*      */     Cur cur;
/*      */     CharNode charNode3;
/* 1793 */     assert paramDom2 != null;
/*      */ 
/*      */ 
/*      */     
/* 1797 */     if (paramDom2 == paramDom3) {
/* 1798 */       return paramDom2;
/*      */     }
/* 1800 */     if (paramDom3 != null && parent(paramDom3) != paramDom1) {
/* 1801 */       throw new NotFoundErr("RefChild is not a child of this node");
/*      */     }
/*      */ 
/*      */     
/* 1805 */     int i = paramDom2.nodeType();
/*      */     
/* 1807 */     if (i == 11) {
/*      */       Dom dom;
/* 1809 */       for (dom = firstChild(paramDom2); dom != null; dom = nextSibling(dom)) {
/* 1810 */         validateNewChild(paramDom1, dom);
/*      */       }
/* 1812 */       for (dom = firstChild(paramDom2); dom != null; ) {
/*      */         
/* 1814 */         Dom dom1 = nextSibling(dom);
/*      */         
/* 1816 */         if (paramDom3 == null) {
/* 1817 */           append(dom, paramDom1);
/*      */         } else {
/* 1819 */           insert(dom, paramDom3);
/*      */         } 
/* 1821 */         dom = dom1;
/*      */       } 
/*      */       
/* 1824 */       return paramDom2;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1831 */     validateNewChild(paramDom1, paramDom2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1837 */     remove(paramDom2);
/*      */     
/* 1839 */     int j = paramDom1.nodeType();
/*      */ 
/*      */     
/* 1842 */     assert j == 2 || j == 11 || j == 9 || j == 1;
/*      */     
/* 1844 */     switch (i) {
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 7:
/*      */       case 8:
/* 1850 */         if (paramDom3 == null) {
/*      */           
/* 1852 */           Cur cur1 = paramDom1.tempCur();
/* 1853 */           cur1.toEnd();
/* 1854 */           Cur.moveNode((Xobj)paramDom2, cur1);
/* 1855 */           cur1.release();
/*      */         }
/*      */         else {
/*      */           
/* 1859 */           int k = paramDom3.nodeType();
/*      */           
/* 1861 */           if (k == 3 || k == 4)
/*      */           
/*      */           { 
/*      */             
/* 1865 */             ArrayList arrayList = new ArrayList();
/*      */             
/* 1867 */             while (paramDom3 != null && (paramDom3.nodeType() == 3 || paramDom3.nodeType() == 4)) {
/*      */               
/* 1869 */               Dom dom = nextSibling(paramDom3);
/* 1870 */               arrayList.add(remove(paramDom3));
/* 1871 */               paramDom3 = dom;
/*      */             } 
/*      */             
/* 1874 */             if (paramDom3 == null) {
/* 1875 */               append(paramDom2, paramDom1);
/*      */             } else {
/* 1877 */               insert(paramDom2, paramDom3);
/*      */             } 
/* 1879 */             paramDom3 = nextSibling(paramDom2);
/*      */             
/* 1881 */             for (byte b = 0; b < arrayList.size(); b++) {
/*      */               
/* 1883 */               Dom dom = arrayList.get(b);
/*      */               
/* 1885 */               if (paramDom3 == null) {
/* 1886 */                 append(dom, paramDom1);
/*      */               } else {
/* 1888 */                 insert(dom, paramDom3);
/*      */               } 
/*      */             }  }
/* 1891 */           else { if (k == 5)
/*      */             {
/* 1893 */               throw new RuntimeException("Not implemented");
/*      */             }
/*      */ 
/*      */             
/* 1897 */             assert k == 1 || k == 7 || k == 8;
/* 1898 */             Cur cur1 = paramDom3.tempCur();
/* 1899 */             Cur.moveNode((Xobj)paramDom2, cur1);
/* 1900 */             cur1.release(); }
/*      */         
/*      */         } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1961 */         return paramDom2;case 3: case 4: charNode1 = (CharNode)paramDom2; assert charNode1._prev == null && charNode1._next == null; charNode2 = null; cur = paramDom1.tempCur(); if (paramDom3 == null) { cur.toEnd(); } else { int k = paramDom3.nodeType(); if (k == 3 || k == 4) { cur.moveToCharNode(charNode2 = (CharNode)paramDom3); } else { if (k == 5) throw new RuntimeException("Not implemented");  cur.moveToDom(paramDom3); }  }  charNode3 = cur.getCharNodes(); charNode3 = CharNode.insertNode(charNode3, charNode1, charNode2); cur.insertChars(charNode1._src, charNode1._off, charNode1._cch); cur.setCharNodes(charNode3); cur.release(); return paramDom2;
/*      */       case 5:
/*      */         throw new RuntimeException("Not implemented");
/*      */       case 10:
/*      */         throw new RuntimeException("Not implemented");
/*      */     } 
/*      */     throw new RuntimeException("Unexpected child node type");
/*      */   } public static Node _node_removeChild(Dom paramDom, Node paramNode) {
/*      */     Dom dom2;
/* 1970 */     Locale locale = paramDom.locale();
/*      */     
/* 1972 */     if (paramNode == null) {
/* 1973 */       throw new NotFoundErr("Child to remove is null");
/*      */     }
/*      */     
/*      */     Dom dom1;
/* 1977 */     if (!(paramNode instanceof Dom) || (dom1 = (Dom)paramNode).locale() != locale) {
/* 1978 */       throw new WrongDocumentErr("Child to remove is from another document");
/*      */     }
/*      */ 
/*      */     
/* 1982 */     if (locale.noSync()) { locale.enter(); try { dom2 = node_removeChild(paramDom, dom1); } finally { locale.exit(); }  }
/* 1983 */     else { synchronized (locale) { locale.enter(); try { dom2 = node_removeChild(paramDom, dom1); } finally { locale.exit(); }  }
/*      */        }
/* 1985 */      return (Node)dom2;
/*      */   }
/*      */   public static Dom node_removeChild(Dom paramDom1, Dom paramDom2) { Cur cur;
/*      */     CharNode charNode1;
/*      */     CharNode charNode2;
/* 1990 */     if (parent(paramDom2) != paramDom1) {
/* 1991 */       throw new NotFoundErr("Child to remove is not a child of given parent");
/*      */     }
/* 1993 */     switch (paramDom2.nodeType()) {
/*      */       
/*      */       case 2:
/*      */       case 9:
/*      */       case 11:
/* 1998 */         throw new IllegalStateException();
/*      */       
/*      */       case 1:
/*      */       case 7:
/*      */       case 8:
/* 2003 */         removeNode(paramDom2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2037 */         return paramDom2;case 3: case 4: cur = paramDom2.tempCur(); charNode1 = cur.getCharNodes(); charNode2 = (CharNode)paramDom2; assert charNode2._src instanceof Dom; charNode2.setChars(cur.moveChars(null, charNode2._cch), cur._offSrc, cur._cchSrc); cur.setCharNodes(CharNode.remove(charNode1, charNode2)); cur.release(); return paramDom2;
/*      */       case 5:
/*      */         throw new RuntimeException("Not impl");
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/*      */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */     throw new RuntimeException("Unknown kind"); } public static Node _node_cloneNode(Dom paramDom, boolean paramBoolean) { Dom dom;
/* 2046 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 2050 */     if (locale.noSync()) { locale.enter(); try { dom = node_cloneNode(paramDom, paramBoolean); } finally { locale.exit(); }  }
/* 2051 */     else { synchronized (locale) { locale.enter(); try { dom = node_cloneNode(paramDom, paramBoolean); } finally { locale.exit(); }  }
/*      */        }
/* 2053 */      return (Node)dom; }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Dom node_cloneNode(Dom paramDom, boolean paramBoolean) {
/* 2058 */     Locale locale = paramDom.locale();
/*      */     
/* 2060 */     Dom dom = null;
/*      */     
/* 2062 */     if (!paramBoolean) {
/*      */       Element element; NamedNodeMap namedNodeMap; byte b;
/* 2064 */       Cur cur = null;
/*      */       
/* 2066 */       switch (paramDom.nodeType()) {
/*      */         
/*      */         case 9:
/* 2069 */           cur = locale.tempCur();
/* 2070 */           cur.createDomDocumentRoot();
/*      */           break;
/*      */         
/*      */         case 11:
/* 2074 */           cur = locale.tempCur();
/* 2075 */           cur.createDomDocFragRoot();
/*      */           break;
/*      */ 
/*      */         
/*      */         case 1:
/* 2080 */           cur = locale.tempCur();
/* 2081 */           cur.createElement(paramDom.getQName());
/*      */           
/* 2083 */           element = (Element)cur.getDom();
/* 2084 */           namedNodeMap = ((Element)paramDom).getAttributes();
/*      */           
/* 2086 */           for (b = 0; b < namedNodeMap.getLength(); b++) {
/* 2087 */             element.setAttributeNodeNS((Attr)namedNodeMap.item(b).cloneNode(true));
/*      */           }
/*      */           break;
/*      */ 
/*      */         
/*      */         case 2:
/* 2093 */           cur = locale.tempCur();
/* 2094 */           cur.createAttr(paramDom.getQName());
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2108 */       if (cur != null) {
/*      */         
/* 2110 */         dom = cur.getDom();
/* 2111 */         cur.release();
/*      */       } 
/*      */     } 
/*      */     
/* 2115 */     if (dom == null)
/*      */     { Cur cur1; Cur cur2; TextNode textNode;
/* 2117 */       switch (paramDom.nodeType())
/*      */       
/*      */       { 
/*      */         case 1:
/*      */         case 2:
/*      */         case 7:
/*      */         case 8:
/*      */         case 9:
/*      */         case 11:
/* 2126 */           cur1 = locale.tempCur();
/* 2127 */           cur2 = paramDom.tempCur();
/* 2128 */           cur2.copyNode(cur1);
/* 2129 */           dom = cur1.getDom();
/* 2130 */           cur1.release();
/* 2131 */           cur2.release();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2162 */           return dom;case 3: case 4: cur1 = paramDom.tempCur(); textNode = (paramDom.nodeType() == 3) ? locale.createTextNode() : locale.createCdataNode(); textNode.setChars(cur1.getChars(((CharNode)paramDom)._cch), cur1._offSrc, cur1._cchSrc); dom = textNode; cur1.release(); return dom;case 5: case 6: case 10: case 12: throw new RuntimeException("Not impl"); }  throw new RuntimeException("Unknown kind"); }  return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getLocalName(Dom paramDom) {
/* 2171 */     if (!paramDom.nodeCanHavePrefixUri()) return null; 
/* 2172 */     b b = paramDom.getQName();
/* 2173 */     return (b == null) ? "" : b.dT();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getNamespaceURI(Dom paramDom) {
/* 2182 */     if (!paramDom.nodeCanHavePrefixUri()) return null; 
/* 2183 */     b b = paramDom.getQName();
/*      */     
/* 2185 */     return (b == null) ? "" : b.getNamespaceURI();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _node_setPrefix(Dom paramDom, String paramString) {
/* 2196 */     Locale locale = paramDom.locale();
/*      */     
/* 2198 */     if (locale.noSync()) { locale.enter(); try { node_setPrefix(paramDom, paramString); } finally { locale.exit(); }  }
/* 2199 */     else { synchronized (locale) { locale.enter(); try { node_setPrefix(paramDom, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void node_setPrefix(Dom paramDom, String paramString) {
/* 2211 */     if (paramDom.nodeType() == 1 || paramDom.nodeType() == 2) {
/*      */       
/* 2213 */       Cur cur = paramDom.tempCur();
/* 2214 */       b b = cur.getName();
/* 2215 */       String str1 = b.getNamespaceURI();
/* 2216 */       String str2 = b.dT();
/*      */       
/* 2218 */       paramString = validatePrefix(paramString, str1, str2, (paramDom.nodeType() == 2));
/*      */       
/* 2220 */       cur.setName(paramDom.locale().makeQName(str1, str2, paramString));
/*      */       
/* 2222 */       cur.release();
/*      */     } else {
/*      */       
/* 2225 */       validatePrefix(paramString, "", "", false);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getPrefix(Dom paramDom) {
/* 2234 */     if (!paramDom.nodeCanHavePrefixUri()) return null; 
/* 2235 */     b b = paramDom.getQName();
/* 2236 */     return (b == null) ? "" : b.getPrefix();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getNodeName(Dom paramDom) {
/*      */     b b;
/*      */     String str;
/* 2246 */     switch (paramDom.nodeType()) {
/*      */       case 4:
/* 2248 */         return "#cdata-section";
/* 2249 */       case 8: return "#comment";
/* 2250 */       case 11: return "#document-fragment";
/* 2251 */       case 9: return "#document";
/* 2252 */       case 7: return paramDom.getQName().dT();
/* 2253 */       case 3: return "#text";
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/* 2258 */         b = paramDom.getQName();
/* 2259 */         str = b.getPrefix();
/* 2260 */         return (str.length() == 0) ? b.dT() : (str + ":" + b.dT());
/*      */ 
/*      */       
/*      */       case 5:
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 2267 */         throw new RuntimeException("Not impl");
/*      */     } 
/* 2269 */     throw new RuntimeException("Unknown node type");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short _node_getNodeType(Dom paramDom) {
/* 2279 */     return (short)paramDom.nodeType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _node_setNodeValue(Dom paramDom, String paramString) {
/* 2288 */     Locale locale = paramDom.locale();
/*      */     
/* 2290 */     if (locale.noSync()) { locale.enter(); try { node_setNodeValue(paramDom, paramString); } finally { locale.exit(); }  }
/* 2291 */     else { synchronized (locale) { locale.enter(); try { node_setNodeValue(paramDom, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */      } public static void node_setNodeValue(Dom paramDom, String paramString) { CharNode charNode; NodeList nodeList; Cur cur1;
/*      */     Cur cur2;
/* 2296 */     if (paramString == null) {
/* 2297 */       paramString = "";
/*      */     }
/* 2299 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */       
/*      */       case 3:
/*      */       case 4:
/* 2304 */         charNode = (CharNode)paramDom;
/*      */ 
/*      */ 
/*      */         
/* 2308 */         if ((cur2 = charNode.tempCur()) != null) {
/*      */           
/* 2310 */           cur2.moveChars(null, charNode._cch);
/* 2311 */           charNode._cch = paramString.length();
/* 2312 */           cur2.insertString(paramString);
/* 2313 */           cur2.release();
/*      */           break;
/*      */         } 
/* 2316 */         charNode.setChars(paramString, 0, paramString.length());
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/* 2325 */         nodeList = ((Node)paramDom).getChildNodes();
/*      */         
/* 2327 */         while (nodeList.getLength() > 1) {
/* 2328 */           node_removeChild(paramDom, (Dom)nodeList.item(1));
/*      */         }
/* 2330 */         if (nodeList.getLength() == 0) {
/*      */           
/* 2332 */           TextNode textNode = paramDom.locale().createTextNode();
/* 2333 */           textNode.setChars(paramString, 0, paramString.length());
/* 2334 */           node_insertBefore(paramDom, textNode, null);
/*      */         }
/*      */         else {
/*      */           
/* 2338 */           assert nodeList.getLength() == 1;
/* 2339 */           nodeList.item(0).setNodeValue(paramString);
/*      */         } 
/* 2341 */         if (((Xobj.AttrXobj)paramDom).isId()) {
/*      */           
/* 2343 */           Dom dom = node_getOwnerDocument(paramDom);
/* 2344 */           String str = node_getNodeValue(paramDom);
/* 2345 */           if (dom instanceof Xobj.DocumentXobj) {
/*      */             
/* 2347 */             ((Xobj.DocumentXobj)dom).removeIdElement(str);
/* 2348 */             ((Xobj.DocumentXobj)dom).addIdElement(paramString, attr_getOwnerElement(paramDom));
/*      */           } 
/*      */         } 
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 7:
/*      */       case 8:
/* 2359 */         cur1 = paramDom.tempCur();
/* 2360 */         cur1.next();
/*      */         
/* 2362 */         cur1.getChars(-1);
/* 2363 */         cur1.moveChars(null, cur1._cchSrc);
/* 2364 */         cur1.insertString(paramString);
/*      */         
/* 2366 */         cur1.release();
/*      */         break;
/*      */     }  }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getNodeValue(Dom paramDom) {
/* 2379 */     Locale locale = paramDom.locale();
/*      */     
/* 2381 */     if (locale.noSync()) return node_getNodeValue(paramDom); 
/* 2382 */     synchronized (locale) { return node_getNodeValue(paramDom); }
/*      */      } public static String node_getNodeValue(Dom paramDom) {
/*      */     CharNode charNode;
/*      */     Xobj xobj;
/*      */     boolean bool;
/* 2387 */     String str = null;
/*      */     
/* 2389 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */       
/*      */       case 2:
/*      */       case 7:
/*      */       case 8:
/* 2395 */         str = ((Xobj)paramDom).getValueAsString();
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 3:
/*      */       case 4:
/* 2402 */         assert paramDom instanceof CharNode : "Text/CData should be a CharNode";
/* 2403 */         charNode = (CharNode)paramDom;
/* 2404 */         if (!(charNode._src instanceof Xobj)) {
/* 2405 */           str = CharUtil.getString(charNode._src, charNode._off, charNode._cch); break;
/*      */         } 
/* 2407 */         xobj = (Xobj)charNode._src;
/* 2408 */         xobj.ensureOccupancy();
/* 2409 */         bool = charNode.isNodeAftertext();
/* 2410 */         if (bool) {
/* 2411 */           xobj._charNodesAfter = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
/*      */           
/* 2413 */           str = xobj.getCharsAfterAsString(charNode._off, charNode._cch);
/*      */           break;
/*      */         } 
/* 2416 */         xobj._charNodesValue = Cur.updateCharNodes(xobj._locale, xobj, xobj._charNodesValue, xobj._cchValue);
/*      */         
/* 2418 */         str = xobj.getCharsValueAsString(charNode._off, charNode._cch);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2426 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object _node_getUserData(Dom paramDom, String paramString) {
/* 2435 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object _node_setUserData(Dom paramDom, String paramString, Object paramObject, UserDataHandler paramUserDataHandler) {
/* 2444 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Object _node_getFeature(Dom paramDom, String paramString1, String paramString2) {
/* 2453 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_isEqualNode(Dom paramDom, Node paramNode) {
/* 2462 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_isSameNode(Dom paramDom, Node paramNode) {
/* 2471 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_lookupNamespaceURI(Dom paramDom, String paramString) {
/* 2480 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _node_isDefaultNamespace(Dom paramDom, String paramString) {
/* 2489 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_lookupPrefix(Dom paramDom, String paramString) {
/* 2498 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _node_setTextContent(Dom paramDom, String paramString) {
/* 2507 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getTextContent(Dom paramDom) {
/* 2516 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short _node_compareDocumentPosition(Dom paramDom, Node paramNode) {
/* 2525 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _node_getBaseURI(Dom paramDom) {
/* 2534 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _childNodes_item(Dom paramDom, int paramInt) {
/*      */     Dom dom;
/* 2543 */     Locale locale = paramDom.locale();
/*      */ 
/*      */     
/* 2546 */     if (paramInt == 0) return _node_getFirstChild(paramDom); 
/* 2547 */     if (locale.noSync()) { dom = childNodes_item(paramDom, paramInt); }
/* 2548 */     else { synchronized (locale) { dom = childNodes_item(paramDom, paramInt); }
/*      */        }
/* 2550 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom childNodes_item(Dom paramDom, int paramInt) {
/* 2555 */     if (paramInt < 0) {
/* 2556 */       return null;
/*      */     }
/* 2558 */     switch (paramDom.nodeType()) {
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 7:
/*      */       case 8:
/* 2564 */         return null;
/*      */       
/*      */       case 5:
/* 2567 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 2572 */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2580 */     if (paramInt == 0)
/* 2581 */       return node_getFirstChild(paramDom); 
/* 2582 */     return paramDom.locale().findDomNthChild(paramDom, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int _childNodes_getLength(Dom paramDom) {
/* 2591 */     Locale locale = paramDom.locale();
/* 2592 */     assert paramDom instanceof Xobj;
/*      */     
/* 2594 */     Xobj xobj = (Xobj)paramDom; int i;
/* 2595 */     if (!xobj.isVacant() && (i = xobj.getDomZeroOneChildren()) < 2)
/*      */     {
/* 2597 */       return i; } 
/* 2598 */     if (locale.noSync()) return childNodes_getLength(paramDom); 
/* 2599 */     synchronized (locale) { return childNodes_getLength(paramDom); }
/*      */   
/*      */   }
/*      */   
/*      */   public static int childNodes_getLength(Dom paramDom) {
/* 2604 */     switch (paramDom.nodeType()) {
/*      */       
/*      */       case 3:
/*      */       case 4:
/*      */       case 7:
/*      */       case 8:
/* 2610 */         return 0;
/*      */       
/*      */       case 5:
/* 2613 */         throw new RuntimeException("Not impl");
/*      */       
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/* 2618 */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2628 */     assert paramDom instanceof Xobj;
/* 2629 */     Xobj xobj = (Xobj)paramDom;
/* 2630 */     xobj.ensureOccupancy(); int i;
/* 2631 */     if ((i = xobj.getDomZeroOneChildren()) < 2)
/* 2632 */       return i; 
/* 2633 */     return paramDom.locale().domLength(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _element_getTagName(Dom paramDom) {
/* 2642 */     return _node_getNodeName(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _element_getAttributeNode(Dom paramDom, String paramString) {
/* 2651 */     return (Attr)_attributes_getNamedItem(paramDom, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _element_getAttributeNodeNS(Dom paramDom, String paramString1, String paramString2) {
/* 2660 */     return (Attr)_attributes_getNamedItemNS(paramDom, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _element_setAttributeNode(Dom paramDom, Attr paramAttr) {
/* 2669 */     return (Attr)_attributes_setNamedItem(paramDom, paramAttr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _element_setAttributeNodeNS(Dom paramDom, Attr paramAttr) {
/* 2678 */     return (Attr)_attributes_setNamedItemNS(paramDom, paramAttr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _element_getAttribute(Dom paramDom, String paramString) {
/* 2687 */     Node node = _attributes_getNamedItem(paramDom, paramString);
/* 2688 */     return (node == null) ? "" : node.getNodeValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _element_getAttributeNS(Dom paramDom, String paramString1, String paramString2) {
/* 2697 */     Node node = _attributes_getNamedItemNS(paramDom, paramString1, paramString2);
/* 2698 */     return (node == null) ? "" : node.getNodeValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _element_hasAttribute(Dom paramDom, String paramString) {
/* 2707 */     return (_attributes_getNamedItem(paramDom, paramString) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _element_hasAttributeNS(Dom paramDom, String paramString1, String paramString2) {
/* 2716 */     return (_attributes_getNamedItemNS(paramDom, paramString1, paramString2) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _element_removeAttribute(Dom paramDom, String paramString) {
/*      */     try {
/* 2727 */       _attributes_removeNamedItem(paramDom, paramString);
/*      */     }
/* 2729 */     catch (NotFoundErr notFoundErr) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _element_removeAttributeNS(Dom paramDom, String paramString1, String paramString2) {
/*      */     try {
/* 2742 */       _attributes_removeNamedItemNS(paramDom, paramString1, paramString2);
/*      */     }
/* 2744 */     catch (NotFoundErr notFoundErr) {}
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Attr _element_removeAttributeNode(Dom paramDom, Attr paramAttr) {
/* 2755 */     if (paramAttr == null) {
/* 2756 */       throw new NotFoundErr("Attribute to remove is null");
/*      */     }
/* 2758 */     if (paramAttr.getOwnerElement() != paramDom) {
/* 2759 */       throw new NotFoundErr("Attribute to remove does not belong to this element");
/*      */     }
/* 2761 */     return (Attr)_attributes_removeNamedItem(paramDom, paramAttr.getNodeName());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _element_setAttribute(Dom paramDom, String paramString1, String paramString2) {
/* 2773 */     Locale locale = paramDom.locale();
/*      */     
/* 2775 */     if (locale.noSync()) { locale.enter(); try { element_setAttribute(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/* 2776 */     else { synchronized (locale) { locale.enter(); try { element_setAttribute(paramDom, paramString1, paramString2); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void element_setAttribute(Dom paramDom, String paramString1, String paramString2) {
/* 2781 */     Dom dom = attributes_getNamedItem(paramDom, paramString1);
/*      */     
/* 2783 */     if (dom == null) {
/*      */       
/* 2785 */       dom = document_createAttribute(node_getOwnerDocument(paramDom), paramString1);
/* 2786 */       attributes_setNamedItem(paramDom, dom);
/*      */     } 
/*      */     
/* 2789 */     node_setNodeValue(dom, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _element_setAttributeNS(Dom paramDom, String paramString1, String paramString2, String paramString3) {
/* 2798 */     Locale locale = paramDom.locale();
/*      */     
/* 2800 */     if (locale.noSync()) { locale.enter(); try { element_setAttributeNS(paramDom, paramString1, paramString2, paramString3); } finally { locale.exit(); }  }
/* 2801 */     else { synchronized (locale) { locale.enter(); try { element_setAttributeNS(paramDom, paramString1, paramString2, paramString3); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void element_setAttributeNS(Dom paramDom, String paramString1, String paramString2, String paramString3) {
/* 2806 */     validateQualifiedName(paramString2, paramString1, true);
/*      */     
/* 2808 */     b b = paramDom.locale().makeQualifiedQName(paramString1, paramString2);
/* 2809 */     String str1 = b.dT();
/* 2810 */     String str2 = validatePrefix(b.getPrefix(), paramString1, str1, true);
/*      */     
/* 2812 */     Dom dom = attributes_getNamedItemNS(paramDom, paramString1, str1);
/*      */     
/* 2814 */     if (dom == null) {
/*      */       
/* 2816 */       dom = document_createAttributeNS(node_getOwnerDocument(paramDom), paramString1, str1);
/* 2817 */       attributes_setNamedItemNS(paramDom, dom);
/*      */     } 
/*      */     
/* 2820 */     node_setPrefix(dom, str2);
/* 2821 */     node_setNodeValue(dom, paramString3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NodeList _element_getElementsByTagName(Dom paramDom, String paramString) {
/* 2830 */     Locale locale = paramDom.locale();
/*      */     
/* 2832 */     if (locale.noSync()) { locale.enter(); try { return element_getElementsByTagName(paramDom, paramString); } finally { locale.exit(); }  }
/* 2833 */      synchronized (locale) { locale.enter(); try { return element_getElementsByTagName(paramDom, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static NodeList element_getElementsByTagName(Dom paramDom, String paramString) {
/* 2838 */     return new ElementsByTagNameNodeList(paramDom, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static NodeList _element_getElementsByTagNameNS(Dom paramDom, String paramString1, String paramString2) {
/* 2847 */     Locale locale = paramDom.locale();
/*      */     
/* 2849 */     if (locale.noSync()) { locale.enter(); try { return element_getElementsByTagNameNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/* 2850 */      synchronized (locale) { locale.enter(); try { return element_getElementsByTagNameNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static NodeList element_getElementsByTagNameNS(Dom paramDom, String paramString1, String paramString2) {
/* 2855 */     return new ElementsByTagNameNSNodeList(paramDom, paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int _attributes_getLength(Dom paramDom) {
/* 2864 */     Locale locale = paramDom.locale();
/*      */     
/* 2866 */     if (locale.noSync()) { locale.enter(); try { return attributes_getLength(paramDom); } finally { locale.exit(); }  }
/* 2867 */      synchronized (locale) { locale.enter(); try { return attributes_getLength(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static int attributes_getLength(Dom paramDom) {
/* 2872 */     byte b = 0;
/*      */     
/* 2874 */     Cur cur = paramDom.tempCur();
/*      */     
/* 2876 */     while (cur.toNextAttr()) {
/* 2877 */       b++;
/*      */     }
/* 2879 */     cur.release();
/*      */     
/* 2881 */     return b;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_setNamedItem(Dom paramDom, Node paramNode) {
/*      */     Dom dom2;
/* 2890 */     Locale locale = paramDom.locale();
/*      */     
/* 2892 */     if (paramNode == null) {
/* 2893 */       throw new IllegalArgumentException("Attr to set is null");
/*      */     }
/*      */     
/*      */     Dom dom1;
/* 2897 */     if (!(paramNode instanceof Dom) || (dom1 = (Dom)paramNode).locale() != locale) {
/* 2898 */       throw new WrongDocumentErr("Attr to set is from another document");
/*      */     }
/*      */ 
/*      */     
/* 2902 */     if (locale.noSync()) { locale.enter(); try { dom2 = attributes_setNamedItem(paramDom, dom1); } finally { locale.exit(); }  }
/* 2903 */     else { synchronized (locale) { locale.enter(); try { dom2 = attributes_setNamedItem(paramDom, dom1); } finally { locale.exit(); }  }
/*      */        }
/* 2905 */      return (Node)dom2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_setNamedItem(Dom paramDom1, Dom paramDom2) {
/* 2910 */     if (attr_getOwnerElement(paramDom2) != null) {
/* 2911 */       throw new InuseAttributeError();
/*      */     }
/* 2913 */     if (paramDom2.nodeType() != 2) {
/* 2914 */       throw new HierarchyRequestErr("Node is not an attribute");
/*      */     }
/* 2916 */     String str = _node_getNodeName(paramDom2);
/* 2917 */     Dom dom = null;
/*      */     
/* 2919 */     Cur cur = paramDom1.tempCur();
/*      */     
/* 2921 */     while (cur.toNextAttr()) {
/*      */       
/* 2923 */       Dom dom1 = cur.getDom();
/*      */       
/* 2925 */       if (_node_getNodeName(dom1).equals(str)) {
/*      */         
/* 2927 */         if (dom == null) {
/* 2928 */           dom = dom1;
/*      */           continue;
/*      */         } 
/* 2931 */         removeNode(dom1);
/* 2932 */         cur.toPrevAttr();
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 2937 */     if (dom == null) {
/*      */       
/* 2939 */       cur.moveToDom(paramDom1);
/* 2940 */       cur.next();
/* 2941 */       Cur.moveNode((Xobj)paramDom2, cur);
/*      */     }
/*      */     else {
/*      */       
/* 2945 */       cur.moveToDom(dom);
/* 2946 */       Cur.moveNode((Xobj)paramDom2, cur);
/* 2947 */       removeNode(dom);
/*      */     } 
/*      */     
/* 2950 */     cur.release();
/*      */     
/* 2952 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_getNamedItem(Dom paramDom, String paramString) {
/*      */     Dom dom;
/* 2961 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 2965 */     if (locale.noSync()) { locale.enter(); try { dom = attributes_getNamedItem(paramDom, paramString); } finally { locale.exit(); }  }
/* 2966 */     else { synchronized (locale) { locale.enter(); try { dom = attributes_getNamedItem(paramDom, paramString); } finally { locale.exit(); }  }
/*      */        }
/* 2968 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_getNamedItem(Dom paramDom, String paramString) {
/* 2973 */     Dom dom = null;
/*      */     
/* 2975 */     Cur cur = paramDom.tempCur();
/*      */     
/* 2977 */     while (cur.toNextAttr()) {
/*      */       
/* 2979 */       Dom dom1 = cur.getDom();
/*      */       
/* 2981 */       if (_node_getNodeName(dom1).equals(paramString)) {
/*      */         
/* 2983 */         dom = dom1;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 2988 */     cur.release();
/*      */     
/* 2990 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_getNamedItemNS(Dom paramDom, String paramString1, String paramString2) {
/*      */     Dom dom;
/* 2999 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 3003 */     if (locale.noSync()) { locale.enter(); try { dom = attributes_getNamedItemNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/* 3004 */     else { synchronized (locale) { locale.enter(); try { dom = attributes_getNamedItemNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*      */        }
/* 3006 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_getNamedItemNS(Dom paramDom, String paramString1, String paramString2) {
/* 3011 */     if (paramString1 == null) {
/* 3012 */       paramString1 = "";
/*      */     }
/* 3014 */     Dom dom = null;
/*      */     
/* 3016 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3018 */     while (cur.toNextAttr()) {
/*      */       
/* 3020 */       Dom dom1 = cur.getDom();
/*      */       
/* 3022 */       b b = dom1.getQName();
/*      */       
/* 3024 */       if (b.getNamespaceURI().equals(paramString1) && b.dT().equals(paramString2)) {
/*      */         
/* 3026 */         dom = dom1;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 3031 */     cur.release();
/*      */     
/* 3033 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_removeNamedItem(Dom paramDom, String paramString) {
/*      */     Dom dom;
/* 3042 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 3046 */     if (locale.noSync()) { locale.enter(); try { dom = attributes_removeNamedItem(paramDom, paramString); } finally { locale.exit(); }  }
/* 3047 */     else { synchronized (locale) { locale.enter(); try { dom = attributes_removeNamedItem(paramDom, paramString); } finally { locale.exit(); }  }
/*      */        }
/* 3049 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_removeNamedItem(Dom paramDom, String paramString) {
/* 3054 */     Dom dom = null;
/*      */     
/* 3056 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3058 */     while (cur.toNextAttr()) {
/*      */       
/* 3060 */       Dom dom1 = cur.getDom();
/*      */       
/* 3062 */       if (_node_getNodeName(dom1).equals(paramString)) {
/*      */         
/* 3064 */         if (dom == null) {
/* 3065 */           dom = dom1;
/*      */         }
/* 3067 */         if (((Xobj.AttrXobj)dom1).isId()) {
/*      */           
/* 3069 */           Dom dom2 = node_getOwnerDocument(dom1);
/* 3070 */           String str = node_getNodeValue(dom1);
/* 3071 */           if (dom2 instanceof Xobj.DocumentXobj)
/* 3072 */             ((Xobj.DocumentXobj)dom2).removeIdElement(str); 
/*      */         } 
/* 3074 */         removeNode(dom1);
/* 3075 */         cur.toPrevAttr();
/*      */       } 
/*      */     } 
/*      */     
/* 3079 */     cur.release();
/*      */     
/* 3081 */     if (dom == null) {
/* 3082 */       throw new NotFoundErr("Named item not found: " + paramString);
/*      */     }
/* 3084 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_removeNamedItemNS(Dom paramDom, String paramString1, String paramString2) {
/*      */     Dom dom;
/* 3093 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 3097 */     if (locale.noSync()) { locale.enter(); try { dom = attributes_removeNamedItemNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/* 3098 */     else { synchronized (locale) { locale.enter(); try { dom = attributes_removeNamedItemNS(paramDom, paramString1, paramString2); } finally { locale.exit(); }  }
/*      */        }
/* 3100 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_removeNamedItemNS(Dom paramDom, String paramString1, String paramString2) {
/* 3105 */     if (paramString1 == null) {
/* 3106 */       paramString1 = "";
/*      */     }
/* 3108 */     Dom dom = null;
/*      */     
/* 3110 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3112 */     while (cur.toNextAttr()) {
/*      */       
/* 3114 */       Dom dom1 = cur.getDom();
/*      */       
/* 3116 */       b b = dom1.getQName();
/*      */       
/* 3118 */       if (b.getNamespaceURI().equals(paramString1) && b.dT().equals(paramString2)) {
/*      */         
/* 3120 */         if (dom == null)
/* 3121 */           dom = dom1; 
/* 3122 */         if (((Xobj.AttrXobj)dom1).isId()) {
/*      */           
/* 3124 */           Dom dom2 = node_getOwnerDocument(dom1);
/* 3125 */           String str = node_getNodeValue(dom1);
/* 3126 */           if (dom2 instanceof Xobj.DocumentXobj)
/* 3127 */             ((Xobj.DocumentXobj)dom2).removeIdElement(str); 
/*      */         } 
/* 3129 */         removeNode(dom1);
/*      */         
/* 3131 */         cur.toPrevAttr();
/*      */       } 
/*      */     } 
/*      */     
/* 3135 */     cur.release();
/*      */     
/* 3137 */     if (dom == null) {
/* 3138 */       throw new NotFoundErr("Named item not found: uri=" + paramString1 + ", local=" + paramString2);
/*      */     }
/* 3140 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_setNamedItemNS(Dom paramDom, Node paramNode) {
/*      */     Dom dom2;
/* 3149 */     Locale locale = paramDom.locale();
/*      */     
/* 3151 */     if (paramNode == null) {
/* 3152 */       throw new IllegalArgumentException("Attr to set is null");
/*      */     }
/*      */     
/*      */     Dom dom1;
/* 3156 */     if (!(paramNode instanceof Dom) || (dom1 = (Dom)paramNode).locale() != locale) {
/* 3157 */       throw new WrongDocumentErr("Attr to set is from another document");
/*      */     }
/*      */ 
/*      */     
/* 3161 */     if (locale.noSync()) { locale.enter(); try { dom2 = attributes_setNamedItemNS(paramDom, dom1); } finally { locale.exit(); }  }
/* 3162 */     else { synchronized (locale) { locale.enter(); try { dom2 = attributes_setNamedItemNS(paramDom, dom1); } finally { locale.exit(); }  }
/*      */        }
/* 3164 */      return (Node)dom2;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_setNamedItemNS(Dom paramDom1, Dom paramDom2) {
/* 3169 */     Dom dom1 = attr_getOwnerElement(paramDom2);
/*      */     
/* 3171 */     if (dom1 == paramDom1) {
/* 3172 */       return paramDom2;
/*      */     }
/* 3174 */     if (dom1 != null) {
/* 3175 */       throw new InuseAttributeError();
/*      */     }
/* 3177 */     if (paramDom2.nodeType() != 2) {
/* 3178 */       throw new HierarchyRequestErr("Node is not an attribute");
/*      */     }
/* 3180 */     b b = paramDom2.getQName();
/* 3181 */     Dom dom2 = null;
/*      */     
/* 3183 */     Cur cur = paramDom1.tempCur();
/*      */     
/* 3185 */     while (cur.toNextAttr()) {
/*      */       
/* 3187 */       Dom dom = cur.getDom();
/*      */       
/* 3189 */       if (dom.getQName().equals(b)) {
/*      */         
/* 3191 */         if (dom2 == null) {
/* 3192 */           dom2 = dom;
/*      */           continue;
/*      */         } 
/* 3195 */         removeNode(dom);
/* 3196 */         cur.toPrevAttr();
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 3201 */     if (dom2 == null) {
/*      */       
/* 3203 */       cur.moveToDom(paramDom1);
/* 3204 */       cur.next();
/* 3205 */       Cur.moveNode((Xobj)paramDom2, cur);
/*      */     }
/*      */     else {
/*      */       
/* 3209 */       cur.moveToDom(dom2);
/* 3210 */       Cur.moveNode((Xobj)paramDom2, cur);
/* 3211 */       removeNode(dom2);
/*      */     } 
/*      */     
/* 3214 */     cur.release();
/*      */     
/* 3216 */     return dom2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Node _attributes_item(Dom paramDom, int paramInt) {
/*      */     Dom dom;
/* 3225 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 3229 */     if (locale.noSync()) { locale.enter(); try { dom = attributes_item(paramDom, paramInt); } finally { locale.exit(); }  }
/* 3230 */     else { synchronized (locale) { locale.enter(); try { dom = attributes_item(paramDom, paramInt); } finally { locale.exit(); }  }
/*      */        }
/* 3232 */      return (Node)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attributes_item(Dom paramDom, int paramInt) {
/* 3237 */     if (paramInt < 0) {
/* 3238 */       return null;
/*      */     }
/* 3240 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3242 */     Dom dom = null;
/*      */     
/* 3244 */     while (cur.toNextAttr()) {
/*      */       
/* 3246 */       if (paramInt-- == 0) {
/*      */         
/* 3248 */         dom = cur.getDom();
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/* 3253 */     cur.release();
/*      */     
/* 3255 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _processingInstruction_getData(Dom paramDom) {
/* 3264 */     return _node_getNodeValue(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _processingInstruction_getTarget(Dom paramDom) {
/* 3273 */     return _node_getNodeName(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _processingInstruction_setData(Dom paramDom, String paramString) {
/* 3282 */     _node_setNodeValue(paramDom, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _attr_getSpecified(Dom paramDom) {
/* 3292 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Element _attr_getOwnerElement(Dom paramDom) {
/*      */     Dom dom;
/* 3301 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 3305 */     if (locale.noSync()) { locale.enter(); try { dom = attr_getOwnerElement(paramDom); } finally { locale.exit(); }  }
/* 3306 */     else { synchronized (locale) { locale.enter(); try { dom = attr_getOwnerElement(paramDom); } finally { locale.exit(); }  }
/*      */        }
/* 3308 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom attr_getOwnerElement(Dom paramDom) {
/* 3313 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3315 */     if (!cur.toParentRaw()) {
/*      */       
/* 3317 */       cur.release();
/* 3318 */       return null;
/*      */     } 
/*      */     
/* 3321 */     Dom dom = cur.getDom();
/*      */     
/* 3323 */     cur.release();
/*      */     
/* 3325 */     return dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _characterData_appendData(Dom paramDom, String paramString) {
/* 3337 */     if (paramString != null && paramString.length() != 0) {
/* 3338 */       _node_setNodeValue(paramDom, _node_getNodeValue(paramDom) + paramString);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _characterData_deleteData(Dom paramDom, int paramInt1, int paramInt2) {
/* 3347 */     String str = _characterData_getData(paramDom);
/*      */     
/* 3349 */     if (paramInt1 < 0 || paramInt1 > str.length() || paramInt2 < 0) {
/* 3350 */       throw new IndexSizeError();
/*      */     }
/* 3352 */     if (paramInt1 + paramInt2 > str.length()) {
/* 3353 */       paramInt2 = str.length() - paramInt1;
/*      */     }
/* 3355 */     if (paramInt2 > 0) {
/* 3356 */       _characterData_setData(paramDom, str.substring(0, paramInt1) + str.substring(paramInt1 + paramInt2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _characterData_getData(Dom paramDom) {
/* 3365 */     return _node_getNodeValue(paramDom);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int _characterData_getLength(Dom paramDom) {
/* 3374 */     return _characterData_getData(paramDom).length();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _characterData_insertData(Dom paramDom, int paramInt, String paramString) {
/* 3383 */     String str = _characterData_getData(paramDom);
/*      */     
/* 3385 */     if (paramInt < 0 || paramInt > str.length()) {
/* 3386 */       throw new IndexSizeError();
/*      */     }
/* 3388 */     if (paramString != null && paramString.length() > 0) {
/* 3389 */       _characterData_setData(paramDom, str.substring(0, paramInt) + paramString + str.substring(paramInt));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _characterData_replaceData(Dom paramDom, int paramInt1, int paramInt2, String paramString) {
/* 3398 */     String str = _characterData_getData(paramDom);
/*      */     
/* 3400 */     if (paramInt1 < 0 || paramInt1 > str.length() || paramInt2 < 0) {
/* 3401 */       throw new IndexSizeError();
/*      */     }
/* 3403 */     if (paramInt1 + paramInt2 > str.length()) {
/* 3404 */       paramInt2 = str.length() - paramInt1;
/*      */     }
/* 3406 */     if (paramInt2 > 0)
/*      */     {
/* 3408 */       _characterData_setData(paramDom, str.substring(0, paramInt1) + ((paramString == null) ? "" : paramString) + str.substring(paramInt1 + paramInt2));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _characterData_setData(Dom paramDom, String paramString) {
/* 3420 */     _node_setNodeValue(paramDom, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _characterData_substringData(Dom paramDom, int paramInt1, int paramInt2) {
/* 3429 */     String str = _characterData_getData(paramDom);
/*      */     
/* 3431 */     if (paramInt1 < 0 || paramInt1 > str.length() || paramInt2 < 0) {
/* 3432 */       throw new IndexSizeError();
/*      */     }
/* 3434 */     if (paramInt1 + paramInt2 > str.length()) {
/* 3435 */       paramInt2 = str.length() - paramInt1;
/*      */     }
/* 3437 */     return str.substring(paramInt1, paramInt1 + paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Text _text_splitText(Dom paramDom, int paramInt) {
/* 3446 */     assert paramDom.nodeType() == 3;
/*      */     
/* 3448 */     String str = _characterData_getData(paramDom);
/*      */     
/* 3450 */     if (paramInt < 0 || paramInt > str.length()) {
/* 3451 */       throw new IndexSizeError();
/*      */     }
/* 3453 */     _characterData_deleteData(paramDom, paramInt, str.length() - paramInt);
/*      */ 
/*      */ 
/*      */     
/* 3457 */     Dom dom1 = (Dom)_document_createTextNode(paramDom, str.substring(paramInt));
/*      */     
/* 3459 */     Dom dom2 = (Dom)_node_getParentNode(paramDom);
/*      */     
/* 3461 */     if (dom2 != null) {
/*      */       
/* 3463 */       _node_insertBefore(dom2, (Text)dom1, _node_getNextSibling(paramDom));
/* 3464 */       paramDom.locale().invalidateDomCaches(dom2);
/*      */     } 
/*      */     
/* 3467 */     return (Text)dom1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String _text_getWholeText(Dom paramDom) {
/* 3476 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _text_isElementContentWhitespace(Dom paramDom) {
/* 3485 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Text _text_replaceWholeText(Dom paramDom, String paramString) {
/* 3494 */     throw new RuntimeException("DOM Level 3 Not implemented");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static XMLStreamReader _getXmlStreamReader(Dom paramDom) {
/* 3503 */     Locale locale = paramDom.locale();
/*      */     
/* 3505 */     if (locale.noSync()) { locale.enter(); try { return getXmlStreamReader(paramDom); } finally { locale.exit(); }  }
/* 3506 */      synchronized (locale) { locale.enter(); try { return getXmlStreamReader(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */      } public static XMLStreamReader getXmlStreamReader(Dom paramDom) {
/*      */     XMLStreamReader xMLStreamReader;
/*      */     Cur cur1;
/*      */     CharNode charNode;
/*      */     Cur cur2;
/* 3513 */     switch (paramDom.nodeType()) {
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 7:
/*      */       case 8:
/*      */       case 9:
/*      */       case 11:
/* 3522 */         cur1 = paramDom.tempCur();
/* 3523 */         xMLStreamReader = Jsr173.newXmlStreamReader(cur1, null);
/* 3524 */         cur1.release();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 3563 */         return xMLStreamReader;case 3: case 4: charNode = (CharNode)paramDom; if ((cur2 = charNode.tempCur()) == null) { cur2 = paramDom.locale().tempCur(); xMLStreamReader = Jsr173.newXmlStreamReader(cur2, charNode._src, charNode._off, charNode._cch); } else { xMLStreamReader = Jsr173.newXmlStreamReader(cur2, cur2.getChars(charNode._cch), cur2._offSrc, cur2._cchSrc); }  cur2.release(); return xMLStreamReader;
/*      */       case 5:
/*      */       case 6:
/*      */       case 10:
/*      */       case 12:
/*      */         throw new RuntimeException("Not impl");
/*      */     } 
/*      */     throw new RuntimeException("Unknown kind");
/*      */   } public static XmlCursor _getXmlCursor(Dom paramDom) {
/* 3572 */     Locale locale = paramDom.locale();
/*      */     
/* 3574 */     if (locale.noSync()) { locale.enter(); try { return getXmlCursor(paramDom); } finally { locale.exit(); }  }
/* 3575 */      synchronized (locale) { locale.enter(); try { return getXmlCursor(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static XmlCursor getXmlCursor(Dom paramDom) {
/* 3580 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3582 */     Cursor cursor = new Cursor(cur);
/*      */     
/* 3584 */     cur.release();
/*      */     
/* 3586 */     return cursor;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static XmlObject _getXmlObject(Dom paramDom) {
/* 3595 */     Locale locale = paramDom.locale();
/*      */     
/* 3597 */     if (locale.noSync()) { locale.enter(); try { return getXmlObject(paramDom); } finally { locale.exit(); }  }
/* 3598 */      synchronized (locale) { locale.enter(); try { return getXmlObject(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static XmlObject getXmlObject(Dom paramDom) {
/* 3603 */     Cur cur = paramDom.tempCur();
/*      */     
/* 3605 */     XmlObject xmlObject = cur.getObject();
/*      */     
/* 3607 */     cur.release();
/*      */     
/* 3609 */     return xmlObject;
/*      */   }
/*      */   static abstract class CharNode implements Dom, CharacterData, Node { private Locale _locale;
/*      */     CharNode _next;
/*      */     CharNode _prev;
/*      */     private Object _src;
/*      */     int _off;
/*      */     int _cch;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     public CharNode(Locale param1Locale) {
/* 3620 */       assert param1Locale != null;
/*      */       
/* 3622 */       this._locale = param1Locale;
/*      */     }
/*      */ 
/*      */     
/*      */     public b getQName() {
/* 3627 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Locale locale() {
/* 3632 */       assert isValid();
/*      */       
/* 3634 */       return (this._locale == null) ? ((DomImpl.Dom)this._src).locale() : this._locale;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setChars(Object param1Object, int param1Int1, int param1Int2) {
/* 3639 */       assert CharUtil.isValid(param1Object, param1Int1, param1Int2);
/* 3640 */       assert this._locale != null || this._src instanceof DomImpl.Dom;
/*      */       
/* 3642 */       if (this._locale == null) {
/* 3643 */         this._locale = ((DomImpl.Dom)this._src).locale();
/*      */       }
/* 3645 */       this._src = param1Object;
/* 3646 */       this._off = param1Int1;
/* 3647 */       this._cch = param1Int2;
/*      */     }
/*      */ 
/*      */     
/*      */     public DomImpl.Dom getDom() {
/* 3652 */       assert isValid();
/*      */       
/* 3654 */       if (this._src instanceof DomImpl.Dom) {
/* 3655 */         return (DomImpl.Dom)this._src;
/*      */       }
/* 3657 */       return null;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setDom(DomImpl.Dom param1Dom) {
/* 3662 */       assert param1Dom != null;
/*      */       
/* 3664 */       this._src = param1Dom;
/* 3665 */       this._locale = null;
/*      */     }
/*      */ 
/*      */     
/*      */     public Cur tempCur() {
/* 3670 */       assert isValid();
/*      */       
/* 3672 */       if (!(this._src instanceof DomImpl.Dom)) {
/* 3673 */         return null;
/*      */       }
/* 3675 */       Cur cur = locale().tempCur();
/* 3676 */       cur.moveToCharNode(this);
/*      */       
/* 3678 */       return cur;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean isValid() {
/* 3683 */       if (this._src instanceof DomImpl.Dom) {
/* 3684 */         return (this._locale == null);
/*      */       }
/* 3686 */       if (this._locale == null) {
/* 3687 */         return false;
/*      */       }
/* 3689 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     public static boolean isOnList(CharNode param1CharNode1, CharNode param1CharNode2) {
/* 3694 */       assert param1CharNode2 != null;
/*      */       
/* 3696 */       for (CharNode charNode = param1CharNode1; charNode != null; charNode = charNode._next) {
/* 3697 */         if (charNode == param1CharNode2)
/* 3698 */           return true; 
/*      */       } 
/* 3700 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public static CharNode remove(CharNode param1CharNode1, CharNode param1CharNode2) {
/* 3705 */       assert isOnList(param1CharNode1, param1CharNode2);
/*      */       
/* 3707 */       if (param1CharNode1 == param1CharNode2) {
/* 3708 */         param1CharNode1 = param1CharNode2._next;
/*      */       } else {
/* 3710 */         param1CharNode2._prev._next = param1CharNode2._next;
/*      */       } 
/* 3712 */       if (param1CharNode2._next != null) {
/* 3713 */         param1CharNode2._next._prev = param1CharNode2._prev;
/*      */       }
/* 3715 */       param1CharNode2._prev = param1CharNode2._next = null;
/*      */       
/* 3717 */       return param1CharNode1;
/*      */     }
/*      */ 
/*      */     
/*      */     public static CharNode insertNode(CharNode param1CharNode1, CharNode param1CharNode2, CharNode param1CharNode3) {
/* 3722 */       assert !isOnList(param1CharNode1, param1CharNode2);
/* 3723 */       assert param1CharNode3 == null || isOnList(param1CharNode1, param1CharNode3);
/* 3724 */       assert param1CharNode2 != null;
/* 3725 */       assert param1CharNode2._prev == null && param1CharNode2._next == null;
/*      */       
/* 3727 */       if (param1CharNode1 == null) {
/*      */         
/* 3729 */         assert param1CharNode3 == null;
/* 3730 */         param1CharNode1 = param1CharNode2;
/*      */       }
/* 3732 */       else if (param1CharNode1 == param1CharNode3) {
/*      */         
/* 3734 */         param1CharNode1._prev = param1CharNode2;
/* 3735 */         param1CharNode2._next = param1CharNode1;
/* 3736 */         param1CharNode1 = param1CharNode2;
/*      */       }
/*      */       else {
/*      */         
/* 3740 */         CharNode charNode = param1CharNode1;
/*      */         
/* 3742 */         while (charNode._next != param1CharNode3) {
/* 3743 */           charNode = charNode._next;
/*      */         }
/* 3745 */         if ((param1CharNode2._next = charNode._next) != null) {
/* 3746 */           charNode._next._prev = param1CharNode2;
/*      */         }
/* 3748 */         param1CharNode2._prev = charNode;
/* 3749 */         charNode._next = param1CharNode2;
/*      */       } 
/*      */       
/* 3752 */       return param1CharNode1;
/*      */     }
/*      */ 
/*      */     
/*      */     public static CharNode appendNode(CharNode param1CharNode1, CharNode param1CharNode2) {
/* 3757 */       return insertNode(param1CharNode1, param1CharNode2, null);
/*      */     }
/*      */ 
/*      */     
/*      */     public static CharNode appendNodes(CharNode param1CharNode1, CharNode param1CharNode2) {
/* 3762 */       assert param1CharNode2 != null;
/* 3763 */       assert param1CharNode2._prev == null;
/*      */       
/* 3765 */       if (param1CharNode1 == null) {
/* 3766 */         return param1CharNode2;
/*      */       }
/* 3768 */       CharNode charNode = param1CharNode1;
/*      */       
/* 3770 */       while (charNode._next != null) {
/* 3771 */         charNode = charNode._next;
/*      */       }
/* 3773 */       charNode._next = param1CharNode2;
/* 3774 */       param1CharNode2._prev = charNode;
/*      */       
/* 3776 */       return param1CharNode1;
/*      */     }
/*      */ 
/*      */     
/*      */     public static CharNode copyNodes(CharNode param1CharNode, Object param1Object) {
/* 3781 */       DomImpl.TextNode textNode = null;
/*      */       
/* 3783 */       for (CharNode charNode = null; param1CharNode != null; param1CharNode = param1CharNode._next) {
/*      */         DomImpl.TextNode textNode1;
/*      */ 
/*      */         
/* 3787 */         if (param1CharNode instanceof DomImpl.TextNode) {
/* 3788 */           textNode1 = param1CharNode.locale().createTextNode();
/*      */         } else {
/* 3790 */           textNode1 = param1CharNode.locale().createCdataNode();
/*      */         } 
/*      */ 
/*      */         
/* 3794 */         textNode1.setChars(param1Object, param1CharNode._off, param1CharNode._cch);
/*      */         
/* 3796 */         if (textNode == null) {
/* 3797 */           textNode = textNode1;
/*      */         }
/* 3799 */         if (charNode != null) {
/*      */           
/* 3801 */           charNode._next = textNode1;
/* 3802 */           textNode1._prev = charNode;
/*      */         } 
/*      */         
/* 3805 */         charNode = textNode1;
/*      */       } 
/*      */       
/* 3808 */       return textNode;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean nodeCanHavePrefixUri() {
/* 3813 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isNodeAftertext() {
/* 3819 */       assert this._src instanceof Xobj : "this method is to only be used for nodes backed up by Xobjs";
/* 3820 */       Xobj xobj = (Xobj)this._src;
/* 3821 */       return (xobj._charNodesValue == null) ? true : ((xobj._charNodesAfter == null) ? false : isOnList(xobj._charNodesAfter, this));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public void dump(PrintStream param1PrintStream, Object param1Object) {
/* 3827 */       if (this._src instanceof DomImpl.Dom) {
/* 3828 */         ((DomImpl.Dom)this._src).dump(param1PrintStream, param1Object);
/*      */       } else {
/* 3830 */         param1PrintStream.println("Lonely CharNode: \"" + CharUtil.getString(this._src, this._off, this._cch) + "\"");
/*      */       } 
/*      */     }
/*      */     
/*      */     public void dump(PrintStream param1PrintStream) {
/* 3835 */       dump(param1PrintStream, this);
/*      */     }
/*      */ 
/*      */     
/*      */     public void dump() {
/* 3840 */       dump(System.out);
/*      */     }
/*      */     
/* 3843 */     public Node appendChild(Node param1Node) { return DomImpl._node_appendChild(this, param1Node); }
/* 3844 */     public Node cloneNode(boolean param1Boolean) { return DomImpl._node_cloneNode(this, param1Boolean); }
/* 3845 */     public NamedNodeMap getAttributes() { return null; }
/* 3846 */     public NodeList getChildNodes() { return DomImpl._emptyNodeList; }
/* 3847 */     public Node getParentNode() { return DomImpl._node_getParentNode(this); }
/* 3848 */     public Node removeChild(Node param1Node) { return DomImpl._node_removeChild(this, param1Node); }
/* 3849 */     public Node getFirstChild() { return null; }
/* 3850 */     public Node getLastChild() { return null; }
/* 3851 */     public String getLocalName() { return DomImpl._node_getLocalName(this); }
/* 3852 */     public String getNamespaceURI() { return DomImpl._node_getNamespaceURI(this); }
/* 3853 */     public Node getNextSibling() { return DomImpl._node_getNextSibling(this); }
/* 3854 */     public String getNodeName() { return DomImpl._node_getNodeName(this); }
/* 3855 */     public short getNodeType() { return DomImpl._node_getNodeType(this); }
/* 3856 */     public String getNodeValue() { return DomImpl._node_getNodeValue(this); }
/* 3857 */     public Document getOwnerDocument() { return DomImpl._node_getOwnerDocument(this); }
/* 3858 */     public String getPrefix() { return DomImpl._node_getPrefix(this); }
/* 3859 */     public Node getPreviousSibling() { return DomImpl._node_getPreviousSibling(this); }
/* 3860 */     public boolean hasAttributes() { return false; }
/* 3861 */     public boolean hasChildNodes() { return false; }
/* 3862 */     public Node insertBefore(Node param1Node1, Node param1Node2) { return DomImpl._node_insertBefore(this, param1Node1, param1Node2); }
/* 3863 */     public boolean isSupported(String param1String1, String param1String2) { return DomImpl._node_isSupported(this, param1String1, param1String2); }
/* 3864 */     public void normalize() { DomImpl._node_normalize(this); }
/* 3865 */     public Node replaceChild(Node param1Node1, Node param1Node2) { return DomImpl._node_replaceChild(this, param1Node1, param1Node2); }
/* 3866 */     public void setNodeValue(String param1String) { DomImpl._node_setNodeValue(this, param1String); } public void setPrefix(String param1String) {
/* 3867 */       DomImpl._node_setPrefix(this, param1String);
/*      */     }
/*      */     
/* 3870 */     public Object getUserData(String param1String) { return DomImpl._node_getUserData(this, param1String); }
/* 3871 */     public Object setUserData(String param1String, Object param1Object, UserDataHandler param1UserDataHandler) { return DomImpl._node_setUserData(this, param1String, param1Object, param1UserDataHandler); }
/* 3872 */     public Object getFeature(String param1String1, String param1String2) { return DomImpl._node_getFeature(this, param1String1, param1String2); }
/* 3873 */     public boolean isEqualNode(Node param1Node) { return DomImpl._node_isEqualNode(this, param1Node); }
/* 3874 */     public boolean isSameNode(Node param1Node) { return DomImpl._node_isSameNode(this, param1Node); }
/* 3875 */     public String lookupNamespaceURI(String param1String) { return DomImpl._node_lookupNamespaceURI(this, param1String); }
/* 3876 */     public String lookupPrefix(String param1String) { return DomImpl._node_lookupPrefix(this, param1String); }
/* 3877 */     public boolean isDefaultNamespace(String param1String) { return DomImpl._node_isDefaultNamespace(this, param1String); }
/* 3878 */     public void setTextContent(String param1String) { DomImpl._node_setTextContent(this, param1String); }
/* 3879 */     public String getTextContent() { return DomImpl._node_getTextContent(this); }
/* 3880 */     public short compareDocumentPosition(Node param1Node) { return DomImpl._node_compareDocumentPosition(this, param1Node); } public String getBaseURI() {
/* 3881 */       return DomImpl._node_getBaseURI(this);
/*      */     }
/* 3883 */     public void appendData(String param1String) { DomImpl._characterData_appendData(this, param1String); }
/* 3884 */     public void deleteData(int param1Int1, int param1Int2) { DomImpl._characterData_deleteData(this, param1Int1, param1Int2); }
/* 3885 */     public String getData() { return DomImpl._characterData_getData(this); }
/* 3886 */     public int getLength() { return DomImpl._characterData_getLength(this); }
/* 3887 */     public void insertData(int param1Int, String param1String) { DomImpl._characterData_insertData(this, param1Int, param1String); }
/* 3888 */     public void replaceData(int param1Int1, int param1Int2, String param1String) { DomImpl._characterData_replaceData(this, param1Int1, param1Int2, param1String); }
/* 3889 */     public void setData(String param1String) { DomImpl._characterData_setData(this, param1String); } public String substringData(int param1Int1, int param1Int2) {
/* 3890 */       return DomImpl._characterData_substringData(this, param1Int1, param1Int2);
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static class TextNode
/*      */     extends CharNode
/*      */     implements Text
/*      */   {
/*      */     TextNode(Locale param1Locale) {
/* 3907 */       super(param1Locale);
/*      */     }
/*      */     public int nodeType() {
/* 3910 */       return 3;
/*      */     } public String name() {
/* 3912 */       return "#text";
/*      */     }
/* 3914 */     public Text splitText(int param1Int) { return DomImpl._text_splitText(this, param1Int); }
/* 3915 */     public String getWholeText() { return DomImpl._text_getWholeText(this); }
/* 3916 */     public boolean isElementContentWhitespace() { return DomImpl._text_isElementContentWhitespace(this); } public Text replaceWholeText(String param1String) {
/* 3917 */       return DomImpl._text_replaceWholeText(this, param1String);
/*      */     }
/*      */   }
/*      */   
/*      */   static class CdataNode
/*      */     extends TextNode implements CDATASection {
/*      */     CdataNode(Locale param1Locale) {
/* 3924 */       super(param1Locale);
/*      */     }
/*      */     public int nodeType() {
/* 3927 */       return 4;
/*      */     } public String name() {
/* 3929 */       return "#cdata-section";
/*      */     }
/*      */   }
/*      */   
/*      */   static class SaajTextNode
/*      */     extends TextNode implements Text {
/*      */     SaajTextNode(Locale param1Locale) {
/* 3936 */       super(param1Locale);
/*      */     }
/*      */     public boolean isComment() {
/* 3939 */       return DomImpl._soapText_isComment(this);
/*      */     }
/* 3941 */     public void detachNode() { DomImpl._soapNode_detachNode(this); }
/* 3942 */     public void recycleNode() { DomImpl._soapNode_recycleNode(this); }
/* 3943 */     public String getValue() { return DomImpl._soapNode_getValue(this); }
/* 3944 */     public void setValue(String param1String) { DomImpl._soapNode_setValue(this, param1String); }
/* 3945 */     public SOAPElement getParentElement() { return DomImpl._soapNode_getParentElement(this); } public void setParentElement(SOAPElement param1SOAPElement) {
/* 3946 */       DomImpl._soapNode_setParentElement(this, param1SOAPElement);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SaajCdataNode
/*      */     extends CdataNode implements Text {
/*      */     public SaajCdataNode(Locale param1Locale) {
/* 3953 */       super(param1Locale);
/*      */     }
/*      */     public boolean isComment() {
/* 3956 */       return DomImpl._soapText_isComment(this);
/*      */     }
/* 3958 */     public void detachNode() { DomImpl._soapNode_detachNode(this); }
/* 3959 */     public void recycleNode() { DomImpl._soapNode_recycleNode(this); }
/* 3960 */     public String getValue() { return DomImpl._soapNode_getValue(this); }
/* 3961 */     public void setValue(String param1String) { DomImpl._soapNode_setValue(this, param1String); }
/* 3962 */     public SOAPElement getParentElement() { return DomImpl._soapNode_getParentElement(this); } public void setParentElement(SOAPElement param1SOAPElement) {
/* 3963 */       DomImpl._soapNode_setParentElement(this, param1SOAPElement);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean _soapText_isComment(Dom paramDom) {
/* 3972 */     Locale locale = paramDom.locale();
/*      */     
/* 3974 */     Text text = (Text)paramDom;
/*      */     
/* 3976 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapText_isComment(text); } finally { locale.exit(); }  }
/* 3977 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapText_isComment(text); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _soapNode_detachNode(Dom paramDom) {
/* 3986 */     Locale locale = paramDom.locale();
/*      */     
/* 3988 */     Node node = (Node)paramDom;
/*      */     
/* 3990 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapNode_detachNode(node); } finally { locale.exit(); }  }
/* 3991 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapNode_detachNode(node); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void _soapNode_recycleNode(Dom paramDom) {
/* 3996 */     Locale locale = paramDom.locale();
/*      */     
/* 3998 */     Node node = (Node)paramDom;
/*      */     
/* 4000 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapNode_recycleNode(node); } finally { locale.exit(); }  }
/* 4001 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapNode_recycleNode(node); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static String _soapNode_getValue(Dom paramDom) {
/* 4006 */     Locale locale = paramDom.locale();
/*      */     
/* 4008 */     Node node = (Node)paramDom;
/*      */     
/* 4010 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapNode_getValue(node); } finally { locale.exit(); }  }
/* 4011 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapNode_getValue(node); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void _soapNode_setValue(Dom paramDom, String paramString) {
/* 4016 */     Locale locale = paramDom.locale();
/*      */     
/* 4018 */     Node node = (Node)paramDom;
/*      */     
/* 4020 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapNode_setValue(node, paramString); } finally { locale.exit(); }  }
/* 4021 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapNode_setValue(node, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static SOAPElement _soapNode_getParentElement(Dom paramDom) {
/* 4026 */     Locale locale = paramDom.locale();
/*      */     
/* 4028 */     Node node = (Node)paramDom;
/*      */     
/* 4030 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapNode_getParentElement(node); } finally { locale.exit(); }  }
/* 4031 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapNode_getParentElement(node); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void _soapNode_setParentElement(Dom paramDom, SOAPElement paramSOAPElement) {
/* 4036 */     Locale locale = paramDom.locale();
/*      */     
/* 4038 */     Node node = (Node)paramDom;
/*      */     
/* 4040 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapNode_setParentElement(node, paramSOAPElement); } finally { locale.exit(); }  }
/* 4041 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapNode_setParentElement(node, paramSOAPElement); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _soapElement_removeContents(Dom paramDom) {
/* 4050 */     Locale locale = paramDom.locale();
/*      */     
/* 4052 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4054 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapElement_removeContents(sOAPElement); } finally { locale.exit(); }  }
/* 4055 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapElement_removeContents(sOAPElement); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static String _soapElement_getEncodingStyle(Dom paramDom) {
/* 4060 */     Locale locale = paramDom.locale();
/*      */     
/* 4062 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4064 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getEncodingStyle(sOAPElement); } finally { locale.exit(); }  }
/* 4065 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getEncodingStyle(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void _soapElement_setEncodingStyle(Dom paramDom, String paramString) {
/* 4070 */     Locale locale = paramDom.locale();
/*      */     
/* 4072 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4074 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapElement_setEncodingStyle(sOAPElement, paramString); } finally { locale.exit(); }  }
/* 4075 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapElement_setEncodingStyle(sOAPElement, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static boolean _soapElement_removeNamespaceDeclaration(Dom paramDom, String paramString) {
/* 4080 */     Locale locale = paramDom.locale();
/*      */     
/* 4082 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4084 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, paramString); } finally { locale.exit(); }  }
/* 4085 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_removeNamespaceDeclaration(sOAPElement, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapElement_getAllAttributes(Dom paramDom) {
/* 4090 */     Locale locale = paramDom.locale();
/*      */     
/* 4092 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4094 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getAllAttributes(sOAPElement); } finally { locale.exit(); }  }
/* 4095 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getAllAttributes(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapElement_getChildElements(Dom paramDom) {
/* 4100 */     Locale locale = paramDom.locale();
/*      */     
/* 4102 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4104 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getChildElements(sOAPElement); } finally { locale.exit(); }  }
/* 4105 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getChildElements(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapElement_getNamespacePrefixes(Dom paramDom) {
/* 4110 */     Locale locale = paramDom.locale();
/*      */     
/* 4112 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4114 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getNamespacePrefixes(sOAPElement); } finally { locale.exit(); }  }
/* 4115 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getNamespacePrefixes(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addAttribute(Dom paramDom, Name paramName, String paramString) throws SOAPException {
/* 4120 */     Locale locale = paramDom.locale();
/*      */     
/* 4122 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4124 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addAttribute(sOAPElement, paramName, paramString); } finally { locale.exit(); }  }
/* 4125 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addAttribute(sOAPElement, paramName, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addChildElement(Dom paramDom, SOAPElement paramSOAPElement) throws SOAPException {
/* 4130 */     Locale locale = paramDom.locale();
/*      */     
/* 4132 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4134 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramSOAPElement); } finally { locale.exit(); }  }
/* 4135 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramSOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addChildElement(Dom paramDom, Name paramName) throws SOAPException {
/* 4140 */     Locale locale = paramDom.locale();
/*      */     
/* 4142 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4144 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramName); } finally { locale.exit(); }  }
/* 4145 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addChildElement(Dom paramDom, String paramString) throws SOAPException {
/* 4150 */     Locale locale = paramDom.locale();
/*      */     
/* 4152 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4154 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString); } finally { locale.exit(); }  }
/* 4155 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addChildElement(Dom paramDom, String paramString1, String paramString2) throws SOAPException {
/* 4160 */     Locale locale = paramDom.locale();
/*      */     
/* 4162 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4164 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString1, paramString2); } finally { locale.exit(); }  }
/* 4165 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString1, paramString2); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addChildElement(Dom paramDom, String paramString1, String paramString2, String paramString3) throws SOAPException {
/* 4170 */     Locale locale = paramDom.locale();
/*      */     
/* 4172 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4174 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString1, paramString2, paramString3); } finally { locale.exit(); }  }
/* 4175 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addChildElement(sOAPElement, paramString1, paramString2, paramString3); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addNamespaceDeclaration(Dom paramDom, String paramString1, String paramString2) {
/* 4180 */     Locale locale = paramDom.locale();
/*      */     
/* 4182 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4184 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, paramString1, paramString2); } finally { locale.exit(); }  }
/* 4185 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addNamespaceDeclaration(sOAPElement, paramString1, paramString2); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPElement _soapElement_addTextNode(Dom paramDom, String paramString) {
/* 4190 */     Locale locale = paramDom.locale();
/*      */     
/* 4192 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4194 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_addTextNode(sOAPElement, paramString); } finally { locale.exit(); }  }
/* 4195 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_addTextNode(sOAPElement, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static String _soapElement_getAttributeValue(Dom paramDom, Name paramName) {
/* 4200 */     Locale locale = paramDom.locale();
/*      */     
/* 4202 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4204 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getAttributeValue(sOAPElement, paramName); } finally { locale.exit(); }  }
/* 4205 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getAttributeValue(sOAPElement, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapElement_getChildElements(Dom paramDom, Name paramName) {
/* 4210 */     Locale locale = paramDom.locale();
/*      */     
/* 4212 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4214 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getChildElements(sOAPElement, paramName); } finally { locale.exit(); }  }
/* 4215 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getChildElements(sOAPElement, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Name _soapElement_getElementName(Dom paramDom) {
/* 4220 */     Locale locale = paramDom.locale();
/*      */     
/* 4222 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4224 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getElementName(sOAPElement); } finally { locale.exit(); }  }
/* 4225 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getElementName(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static String _soapElement_getNamespaceURI(Dom paramDom, String paramString) {
/* 4230 */     Locale locale = paramDom.locale();
/*      */     
/* 4232 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4234 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getNamespaceURI(sOAPElement, paramString); } finally { locale.exit(); }  }
/* 4235 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getNamespaceURI(sOAPElement, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapElement_getVisibleNamespacePrefixes(Dom paramDom) {
/* 4240 */     Locale locale = paramDom.locale();
/*      */     
/* 4242 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4244 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement); } finally { locale.exit(); }  }
/* 4245 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_getVisibleNamespacePrefixes(sOAPElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static boolean _soapElement_removeAttribute(Dom paramDom, Name paramName) {
/* 4250 */     Locale locale = paramDom.locale();
/*      */     
/* 4252 */     SOAPElement sOAPElement = (SOAPElement)paramDom;
/*      */     
/* 4254 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapElement_removeAttribute(sOAPElement, paramName); } finally { locale.exit(); }  }
/* 4255 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapElement_removeAttribute(sOAPElement, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static SOAPBody _soapEnvelope_addBody(Dom paramDom) throws SOAPException {
/* 4264 */     Locale locale = paramDom.locale();
/*      */     
/* 4266 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4268 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_addBody(sOAPEnvelope); } finally { locale.exit(); }  }
/* 4269 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_addBody(sOAPEnvelope); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPBody _soapEnvelope_getBody(Dom paramDom) throws SOAPException {
/* 4274 */     Locale locale = paramDom.locale();
/*      */     
/* 4276 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4278 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_getBody(sOAPEnvelope); } finally { locale.exit(); }  }
/* 4279 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_getBody(sOAPEnvelope); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPHeader _soapEnvelope_getHeader(Dom paramDom) throws SOAPException {
/* 4284 */     Locale locale = paramDom.locale();
/*      */     
/* 4286 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4288 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_getHeader(sOAPEnvelope); } finally { locale.exit(); }  }
/* 4289 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_getHeader(sOAPEnvelope); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPHeader _soapEnvelope_addHeader(Dom paramDom) throws SOAPException {
/* 4294 */     Locale locale = paramDom.locale();
/*      */     
/* 4296 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4298 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_addHeader(sOAPEnvelope); } finally { locale.exit(); }  }
/* 4299 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_addHeader(sOAPEnvelope); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Name _soapEnvelope_createName(Dom paramDom, String paramString) {
/* 4304 */     Locale locale = paramDom.locale();
/*      */     
/* 4306 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4308 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_createName(sOAPEnvelope, paramString); } finally { locale.exit(); }  }
/* 4309 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_createName(sOAPEnvelope, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Name _soapEnvelope_createName(Dom paramDom, String paramString1, String paramString2, String paramString3) {
/* 4314 */     Locale locale = paramDom.locale();
/*      */     
/* 4316 */     SOAPEnvelope sOAPEnvelope = (SOAPEnvelope)paramDom;
/*      */     
/* 4318 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapEnvelope_createName(sOAPEnvelope, paramString1, paramString2, paramString3); } finally { locale.exit(); }  }
/* 4319 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapEnvelope_createName(sOAPEnvelope, paramString1, paramString2, paramString3); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Iterator soapHeader_examineAllHeaderElements(Dom paramDom) {
/* 4328 */     Locale locale = paramDom.locale();
/*      */     
/* 4330 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4332 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader); } finally { locale.exit(); }  }
/* 4333 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_examineAllHeaderElements(sOAPHeader); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator soapHeader_extractAllHeaderElements(Dom paramDom) {
/* 4338 */     Locale locale = paramDom.locale();
/*      */     
/* 4340 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4342 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader); } finally { locale.exit(); }  }
/* 4343 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_extractAllHeaderElements(sOAPHeader); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator soapHeader_examineHeaderElements(Dom paramDom, String paramString) {
/* 4348 */     Locale locale = paramDom.locale();
/*      */     
/* 4350 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4352 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }  }
/* 4353 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_examineHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator soapHeader_examineMustUnderstandHeaderElements(Dom paramDom, String paramString) {
/* 4358 */     Locale locale = paramDom.locale();
/*      */     
/* 4360 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4362 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }  }
/* 4363 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_examineMustUnderstandHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator soapHeader_extractHeaderElements(Dom paramDom, String paramString) {
/* 4368 */     Locale locale = paramDom.locale();
/*      */     
/* 4370 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4372 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }  }
/* 4373 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_extractHeaderElements(sOAPHeader, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPHeaderElement soapHeader_addHeaderElement(Dom paramDom, Name paramName) {
/* 4378 */     Locale locale = paramDom.locale();
/*      */     
/* 4380 */     SOAPHeader sOAPHeader = (SOAPHeader)paramDom;
/*      */     
/* 4382 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeader_addHeaderElement(sOAPHeader, paramName); } finally { locale.exit(); }  }
/* 4383 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeader_addHeaderElement(sOAPHeader, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean soapBody_hasFault(Dom paramDom) {
/* 4392 */     Locale locale = paramDom.locale();
/*      */     
/* 4394 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4396 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_hasFault(sOAPBody); } finally { locale.exit(); }  }
/* 4397 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_hasFault(sOAPBody); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPFault soapBody_addFault(Dom paramDom) throws SOAPException {
/* 4402 */     Locale locale = paramDom.locale();
/*      */     
/* 4404 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4406 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody); } finally { locale.exit(); }  }
/* 4407 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPFault soapBody_getFault(Dom paramDom) {
/* 4412 */     Locale locale = paramDom.locale();
/*      */     
/* 4414 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4416 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_getFault(sOAPBody); } finally { locale.exit(); }  }
/* 4417 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_getFault(sOAPBody); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPBodyElement soapBody_addBodyElement(Dom paramDom, Name paramName) {
/* 4422 */     Locale locale = paramDom.locale();
/*      */     
/* 4424 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4426 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_addBodyElement(sOAPBody, paramName); } finally { locale.exit(); }  }
/* 4427 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_addBodyElement(sOAPBody, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPBodyElement soapBody_addDocument(Dom paramDom, Document paramDocument) {
/* 4432 */     Locale locale = paramDom.locale();
/*      */     
/* 4434 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4436 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_addDocument(sOAPBody, paramDocument); } finally { locale.exit(); }  }
/* 4437 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_addDocument(sOAPBody, paramDocument); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPFault soapBody_addFault(Dom paramDom, Name paramName, String paramString) throws SOAPException {
/* 4442 */     Locale locale = paramDom.locale();
/*      */     
/* 4444 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4446 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody, paramName, paramString); } finally { locale.exit(); }  }
/* 4447 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody, paramName, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPFault soapBody_addFault(Dom paramDom, Name paramName, String paramString, Locale paramLocale) throws SOAPException {
/* 4452 */     Locale locale = paramDom.locale();
/*      */     
/* 4454 */     SOAPBody sOAPBody = (SOAPBody)paramDom;
/*      */     
/* 4456 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody, paramName, paramString, paramLocale); } finally { locale.exit(); }  }
/* 4457 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapBody_addFault(sOAPBody, paramName, paramString, paramLocale); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void soapFault_setFaultString(Dom paramDom, String paramString) {
/* 4466 */     Locale locale = paramDom.locale();
/*      */     
/* 4468 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4470 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapFault_setFaultString(sOAPFault, paramString); } finally { locale.exit(); }  }
/* 4471 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapFault_setFaultString(sOAPFault, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void soapFault_setFaultString(Dom paramDom, String paramString, Locale paramLocale) {
/* 4476 */     Locale locale = paramDom.locale();
/*      */     
/* 4478 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4480 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapFault_setFaultString(sOAPFault, paramString, paramLocale); } finally { locale.exit(); }  }
/* 4481 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapFault_setFaultString(sOAPFault, paramString, paramLocale); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void soapFault_setFaultCode(Dom paramDom, Name paramName) throws SOAPException {
/* 4486 */     Locale locale = paramDom.locale();
/*      */     
/* 4488 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4490 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapFault_setFaultCode(sOAPFault, paramName); } finally { locale.exit(); }  }
/* 4491 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapFault_setFaultCode(sOAPFault, paramName); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void soapFault_setFaultActor(Dom paramDom, String paramString) {
/* 4496 */     Locale locale = paramDom.locale();
/*      */     
/* 4498 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4500 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapFault_setFaultActor(sOAPFault, paramString); } finally { locale.exit(); }  }
/* 4501 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapFault_setFaultActor(sOAPFault, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static String soapFault_getFaultActor(Dom paramDom) {
/* 4506 */     Locale locale = paramDom.locale();
/*      */     
/* 4508 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4510 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getFaultActor(sOAPFault); } finally { locale.exit(); }  }
/* 4511 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getFaultActor(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static String soapFault_getFaultCode(Dom paramDom) {
/* 4516 */     Locale locale = paramDom.locale();
/*      */     
/* 4518 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4520 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getFaultCode(sOAPFault); } finally { locale.exit(); }  }
/* 4521 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getFaultCode(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void soapFault_setFaultCode(Dom paramDom, String paramString) throws SOAPException {
/* 4526 */     Locale locale = paramDom.locale();
/*      */     
/* 4528 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4530 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapFault_setFaultCode(sOAPFault, paramString); } finally { locale.exit(); }  }
/* 4531 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapFault_setFaultCode(sOAPFault, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static Locale soapFault_getFaultStringLocale(Dom paramDom) {
/* 4536 */     Locale locale = paramDom.locale();
/*      */     
/* 4538 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4540 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getFaultStringLocale(sOAPFault); } finally { locale.exit(); }  }
/* 4541 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getFaultStringLocale(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Name soapFault_getFaultCodeAsName(Dom paramDom) {
/* 4546 */     Locale locale = paramDom.locale();
/*      */     
/* 4548 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4550 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getFaultCodeAsName(sOAPFault); } finally { locale.exit(); }  }
/* 4551 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getFaultCodeAsName(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static String soapFault_getFaultString(Dom paramDom) {
/* 4556 */     Locale locale = paramDom.locale();
/*      */     
/* 4558 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4560 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getFaultString(sOAPFault); } finally { locale.exit(); }  }
/* 4561 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getFaultString(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Detail soapFault_addDetail(Dom paramDom) throws SOAPException {
/* 4566 */     Locale locale = paramDom.locale();
/*      */     
/* 4568 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4570 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_addDetail(sOAPFault); } finally { locale.exit(); }  }
/* 4571 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_addDetail(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Detail soapFault_getDetail(Dom paramDom) {
/* 4576 */     Locale locale = paramDom.locale();
/*      */     
/* 4578 */     SOAPFault sOAPFault = (SOAPFault)paramDom;
/*      */     
/* 4580 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapFault_getDetail(sOAPFault); } finally { locale.exit(); }  }
/* 4581 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapFault_getDetail(sOAPFault); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void soapHeaderElement_setMustUnderstand(Dom paramDom, boolean paramBoolean) {
/* 4590 */     Locale locale = paramDom.locale();
/*      */     
/* 4592 */     SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement)paramDom;
/*      */     
/* 4594 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, paramBoolean); } finally { locale.exit(); }  }
/* 4595 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapHeaderElement_setMustUnderstand(sOAPHeaderElement, paramBoolean); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static boolean soapHeaderElement_getMustUnderstand(Dom paramDom) {
/* 4600 */     Locale locale = paramDom.locale();
/*      */     
/* 4602 */     SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement)paramDom;
/*      */     
/* 4604 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement); } finally { locale.exit(); }  }
/* 4605 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeaderElement_getMustUnderstand(sOAPHeaderElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void soapHeaderElement_setActor(Dom paramDom, String paramString) {
/* 4610 */     Locale locale = paramDom.locale();
/*      */     
/* 4612 */     SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement)paramDom;
/*      */     
/* 4614 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, paramString); } finally { locale.exit(); }  }
/* 4615 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapHeaderElement_setActor(sOAPHeaderElement, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static String soapHeaderElement_getActor(Dom paramDom) {
/* 4620 */     Locale locale = paramDom.locale();
/*      */     
/* 4622 */     SOAPHeaderElement sOAPHeaderElement = (SOAPHeaderElement)paramDom;
/*      */     
/* 4624 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement); } finally { locale.exit(); }  }
/* 4625 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapHeaderElement_getActor(sOAPHeaderElement); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static DetailEntry detail_addDetailEntry(Dom paramDom, Name paramName) {
/* 4634 */     Locale locale = paramDom.locale();
/*      */     
/* 4636 */     Detail detail = (Detail)paramDom;
/*      */     
/* 4638 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.detail_addDetailEntry(detail, paramName); } finally { locale.exit(); }  }
/* 4639 */      synchronized (locale) { locale.enter(); try { return locale._saaj.detail_addDetailEntry(detail, paramName); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator detail_getDetailEntries(Dom paramDom) {
/* 4644 */     Locale locale = paramDom.locale();
/*      */     
/* 4646 */     Detail detail = (Detail)paramDom;
/*      */     
/* 4648 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.detail_getDetailEntries(detail); } finally { locale.exit(); }  }
/* 4649 */      synchronized (locale) { locale.enter(); try { return locale._saaj.detail_getDetailEntries(detail); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void _soapPart_removeAllMimeHeaders(Dom paramDom) {
/* 4658 */     Locale locale = paramDom.locale();
/*      */     
/* 4660 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4662 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart); } finally { locale.exit(); }  }
/* 4663 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapPart_removeAllMimeHeaders(sOAPPart); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void _soapPart_removeMimeHeader(Dom paramDom, String paramString) {
/* 4668 */     Locale locale = paramDom.locale();
/*      */     
/* 4670 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4672 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapPart_removeMimeHeader(sOAPPart, paramString); } finally { locale.exit(); }  }
/* 4673 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapPart_removeMimeHeader(sOAPPart, paramString); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static Iterator _soapPart_getAllMimeHeaders(Dom paramDom) {
/* 4678 */     Locale locale = paramDom.locale();
/*      */     
/* 4680 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4682 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getAllMimeHeaders(sOAPPart); } finally { locale.exit(); }  }
/* 4683 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getAllMimeHeaders(sOAPPart); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static SOAPEnvelope _soapPart_getEnvelope(Dom paramDom) {
/* 4688 */     Locale locale = paramDom.locale();
/*      */     
/* 4690 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4692 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getEnvelope(sOAPPart); } finally { locale.exit(); }  }
/* 4693 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getEnvelope(sOAPPart); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Source _soapPart_getContent(Dom paramDom) {
/* 4698 */     Locale locale = paramDom.locale();
/*      */     
/* 4700 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4702 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getContent(sOAPPart); } finally { locale.exit(); }  }
/* 4703 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getContent(sOAPPart); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void _soapPart_setContent(Dom paramDom, Source paramSource) {
/* 4708 */     Locale locale = paramDom.locale();
/*      */     
/* 4710 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4712 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapPart_setContent(sOAPPart, paramSource); } finally { locale.exit(); }  }
/* 4713 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapPart_setContent(sOAPPart, paramSource); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static String[] _soapPart_getMimeHeader(Dom paramDom, String paramString) {
/* 4718 */     Locale locale = paramDom.locale();
/*      */     
/* 4720 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4722 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getMimeHeader(sOAPPart, paramString); } finally { locale.exit(); }  }
/* 4723 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getMimeHeader(sOAPPart, paramString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static void _soapPart_addMimeHeader(Dom paramDom, String paramString1, String paramString2) {
/* 4728 */     Locale locale = paramDom.locale();
/*      */     
/* 4730 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4732 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapPart_addMimeHeader(sOAPPart, paramString1, paramString2); } finally { locale.exit(); }  }
/* 4733 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapPart_addMimeHeader(sOAPPart, paramString1, paramString2); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void _soapPart_setMimeHeader(Dom paramDom, String paramString1, String paramString2) {
/* 4738 */     Locale locale = paramDom.locale();
/*      */     
/* 4740 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4742 */     if (locale.noSync()) { locale.enter(); try { locale._saaj.soapPart_setMimeHeader(sOAPPart, paramString1, paramString2); } finally { locale.exit(); }  }
/* 4743 */     else { synchronized (locale) { locale.enter(); try { locale._saaj.soapPart_setMimeHeader(sOAPPart, paramString1, paramString2); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static Iterator _soapPart_getMatchingMimeHeaders(Dom paramDom, String[] paramArrayOfString) {
/* 4748 */     Locale locale = paramDom.locale();
/*      */     
/* 4750 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4752 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, paramArrayOfString); } finally { locale.exit(); }  }
/* 4753 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getMatchingMimeHeaders(sOAPPart, paramArrayOfString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Iterator _soapPart_getNonMatchingMimeHeaders(Dom paramDom, String[] paramArrayOfString) {
/* 4758 */     Locale locale = paramDom.locale();
/*      */     
/* 4760 */     SOAPPart sOAPPart = (SOAPPart)paramDom;
/*      */     
/* 4762 */     if (locale.noSync()) { locale.enter(); try { return locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, paramArrayOfString); } finally { locale.exit(); }  }
/* 4763 */      synchronized (locale) { locale.enter(); try { return locale._saaj.soapPart_getNonMatchingMimeHeaders(sOAPPart, paramArrayOfString); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */   
/*      */   private static class SaajData
/*      */   {
/*      */     Object _obj;
/*      */     
/*      */     private SaajData() {}
/*      */   }
/*      */   
/*      */   public static void saajCallback_setSaajData(Dom paramDom, Object paramObject) {
/* 4777 */     Locale locale = paramDom.locale();
/*      */     
/* 4779 */     if (locale.noSync()) { locale.enter(); try { impl_saajCallback_setSaajData(paramDom, paramObject); } finally { locale.exit(); }  }
/* 4780 */     else { synchronized (locale) { locale.enter(); try { impl_saajCallback_setSaajData(paramDom, paramObject); } finally { locale.exit(); }
/*      */          }
/*      */        }
/*      */   
/*      */   } public static void impl_saajCallback_setSaajData(Dom paramDom, Object paramObject) {
/* 4785 */     Locale locale = paramDom.locale();
/*      */     
/* 4787 */     Cur cur = locale.tempCur();
/*      */     
/* 4789 */     cur.moveToDom(paramDom);
/*      */     
/* 4791 */     SaajData saajData = null;
/*      */     
/* 4793 */     if (paramObject != null) {
/*      */       
/* 4795 */       saajData = (SaajData)cur.getBookmark(SaajData.class);
/*      */       
/* 4797 */       if (saajData == null) {
/* 4798 */         saajData = new SaajData();
/*      */       }
/* 4800 */       saajData._obj = paramObject;
/*      */     } 
/*      */     
/* 4803 */     cur.setBookmark(SaajData.class, saajData);
/*      */     
/* 4805 */     cur.release();
/*      */   }
/*      */ 
/*      */   
/*      */   public static Object saajCallback_getSaajData(Dom paramDom) {
/* 4810 */     Locale locale = paramDom.locale();
/*      */     
/* 4812 */     if (locale.noSync()) { locale.enter(); try { return impl_saajCallback_getSaajData(paramDom); } finally { locale.exit(); }  }
/* 4813 */      synchronized (locale) { locale.enter(); try { return impl_saajCallback_getSaajData(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   public static Object impl_saajCallback_getSaajData(Dom paramDom) {
/* 4818 */     Locale locale = paramDom.locale();
/*      */     
/* 4820 */     Cur cur = locale.tempCur();
/*      */     
/* 4822 */     cur.moveToDom(paramDom);
/*      */     
/* 4824 */     SaajData saajData = (SaajData)cur.getBookmark(SaajData.class);
/*      */     
/* 4826 */     Object object = (saajData == null) ? null : saajData._obj;
/*      */     
/* 4828 */     cur.release();
/*      */     
/* 4830 */     return object;
/*      */   }
/*      */   
/*      */   public static Element saajCallback_createSoapElement(Dom paramDom, b paramb1, b paramb2) {
/*      */     Dom dom;
/* 4835 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 4839 */     if (locale.noSync()) { locale.enter(); try { dom = impl_saajCallback_createSoapElement(paramDom, paramb1, paramb2); } finally { locale.exit(); }  }
/* 4840 */     else { synchronized (locale) { locale.enter(); try { dom = impl_saajCallback_createSoapElement(paramDom, paramb1, paramb2); } finally { locale.exit(); }  }
/*      */        }
/* 4842 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Dom impl_saajCallback_createSoapElement(Dom paramDom, b paramb1, b paramb2) {
/* 4847 */     Cur cur = paramDom.locale().tempCur();
/*      */     
/* 4849 */     cur.createElement(paramb1, paramb2);
/*      */     
/* 4851 */     Dom dom = cur.getDom();
/*      */     
/* 4853 */     cur.release();
/*      */     
/* 4855 */     return dom;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Element saajCallback_importSoapElement(Dom paramDom, Element paramElement, boolean paramBoolean, b paramb) {
/*      */     Dom dom;
/* 4861 */     Locale locale = paramDom.locale();
/*      */ 
/*      */ 
/*      */     
/* 4865 */     if (locale.noSync()) { locale.enter(); try { dom = impl_saajCallback_importSoapElement(paramDom, paramElement, paramBoolean, paramb); } finally { locale.exit(); }  }
/* 4866 */     else { synchronized (locale) { locale.enter(); try { dom = impl_saajCallback_importSoapElement(paramDom, paramElement, paramBoolean, paramb); } finally { locale.exit(); }  }
/*      */        }
/* 4868 */      return (Element)dom;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Dom impl_saajCallback_importSoapElement(Dom paramDom, Element paramElement, boolean paramBoolean, b paramb) {
/* 4878 */     throw new RuntimeException("Not impl");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Text saajCallback_ensureSoapTextNode(Dom paramDom) {
/* 4884 */     Locale locale = paramDom.locale();
/*      */     
/* 4886 */     if (locale.noSync()) { locale.enter(); try { return impl_saajCallback_ensureSoapTextNode(paramDom); } finally { locale.exit(); }  }
/* 4887 */      synchronized (locale) { locale.enter(); try { return impl_saajCallback_ensureSoapTextNode(paramDom); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Text impl_saajCallback_ensureSoapTextNode(Dom paramDom) {
/* 4903 */     return null;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\DomImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */