/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.Reader;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.io.Writer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.HashMap;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SystemProperties;
/*      */ import org.apache.xmlbeans.XmlDocumentProperties;
/*      */ import org.apache.xmlbeans.XmlOptionCharEscapeMap;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.EncodingMap;
/*      */ import org.apache.xmlbeans.impl.common.GenericXmlInputStream;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.XmlEventBase;
/*      */ import org.apache.xmlbeans.impl.common.XmlNameImpl;
/*      */ import org.apache.xmlbeans.xml.stream.Attribute;
/*      */ import org.apache.xmlbeans.xml.stream.AttributeIterator;
/*      */ import org.apache.xmlbeans.xml.stream.ChangePrefixMapping;
/*      */ import org.apache.xmlbeans.xml.stream.CharacterData;
/*      */ import org.apache.xmlbeans.xml.stream.Comment;
/*      */ import org.apache.xmlbeans.xml.stream.EndDocument;
/*      */ import org.apache.xmlbeans.xml.stream.EndElement;
/*      */ import org.apache.xmlbeans.xml.stream.Location;
/*      */ import org.apache.xmlbeans.xml.stream.ProcessingInstruction;
/*      */ import org.apache.xmlbeans.xml.stream.StartDocument;
/*      */ import org.apache.xmlbeans.xml.stream.StartElement;
/*      */ import org.apache.xmlbeans.xml.stream.StartPrefixMapping;
/*      */ import org.apache.xmlbeans.xml.stream.XMLEvent;
/*      */ import org.apache.xmlbeans.xml.stream.XMLName;
/*      */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*      */ import org.xml.sax.ContentHandler;
/*      */ import org.xml.sax.SAXException;
/*      */ import org.xml.sax.ext.LexicalHandler;
/*      */ import org.xml.sax.helpers.AttributesImpl;
/*      */ 
/*      */ abstract class Saver {
/*      */   static final int ROOT = 1;
/*      */   static final int ELEM = 2;
/*      */   static final int ATTR = 3;
/*      */   static final int COMMENT = 4;
/*      */   static final int PROCINST = 5;
/*      */   static final int TEXT = 0;
/*      */   private final Locale _locale;
/*      */   private final long _version;
/*      */   private SaveCur _cur;
/*      */   private List _ancestorNamespaces;
/*      */   private Map _suggestedPrefixes;
/*      */   protected XmlOptionCharEscapeMap _replaceChar;
/*      */   private boolean _useDefaultNamespace;
/*      */   private Map _preComputedNamespaces;
/*      */   private boolean _saveNamespacesFirst;
/*      */   private ArrayList _attrNames;
/*      */   private ArrayList _attrValues;
/*      */   private ArrayList _namespaceStack;
/*      */   private int _currentMapping;
/*      */   private HashMap _uriMap;
/*      */   private HashMap _prefixMap;
/*      */   private String _initialDefaultUri;
/*      */   
/*      */   protected void syntheticNamespace(String paramString1, String paramString2, boolean paramBoolean) {}
/*      */   
/*   72 */   Saver(Cur paramCur, XmlOptions paramXmlOptions) { assert paramCur._locale.entered();
/*      */     
/*   74 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*      */     
/*   76 */     this._cur = createSaveCur(paramCur, paramXmlOptions);
/*      */     
/*   78 */     this._locale = paramCur._locale;
/*   79 */     this._version = this._locale.version();
/*      */     
/*   81 */     this._namespaceStack = new ArrayList();
/*   82 */     this._uriMap = new HashMap();
/*   83 */     this._prefixMap = new HashMap();
/*      */     
/*   85 */     this._attrNames = new ArrayList();
/*   86 */     this._attrValues = new ArrayList();
/*      */ 
/*      */ 
/*      */     
/*   90 */     addMapping("xml", "http://www.w3.org/XML/1998/namespace");
/*      */     
/*   92 */     if (paramXmlOptions.hasOption("SAVE_IMPLICIT_NAMESPACES")) {
/*      */       
/*   94 */       Map map = (Map)paramXmlOptions.get("SAVE_IMPLICIT_NAMESPACES");
/*      */       
/*   96 */       for (String str : map.keySet())
/*      */       {
/*      */         
/*   99 */         addMapping(str, (String)map.get(str));
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  104 */     if (paramXmlOptions.hasOption("SAVE_SUBSTITUTE_CHARACTERS"))
/*      */     {
/*  106 */       this._replaceChar = (XmlOptionCharEscapeMap)paramXmlOptions.get("SAVE_SUBSTITUTE_CHARACTERS");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  112 */     if (getNamespaceForPrefix("") == null) {
/*      */       
/*  114 */       this._initialDefaultUri = new String("");
/*  115 */       addMapping("", this._initialDefaultUri);
/*      */     } 
/*      */     
/*  118 */     if (paramXmlOptions.hasOption("SAVE_AGGRESSIVE_NAMESPACES") && !(this instanceof SynthNamespaceSaver)) {
/*      */ 
/*      */       
/*  121 */       SynthNamespaceSaver synthNamespaceSaver = new SynthNamespaceSaver(paramCur, paramXmlOptions);
/*      */       
/*  123 */       while (synthNamespaceSaver.process());
/*      */ 
/*      */       
/*  126 */       if (!synthNamespaceSaver._synthNamespaces.isEmpty()) {
/*  127 */         this._preComputedNamespaces = synthNamespaceSaver._synthNamespaces;
/*      */       }
/*      */     } 
/*  130 */     this._useDefaultNamespace = paramXmlOptions.hasOption("SAVE_USE_DEFAULT_NAMESPACE");
/*      */ 
/*      */     
/*  133 */     this._saveNamespacesFirst = paramXmlOptions.hasOption("SAVE_NAMESPACES_FIRST");
/*      */     
/*  135 */     if (paramXmlOptions.hasOption("SAVE_SUGGESTED_PREFIXES")) {
/*  136 */       this._suggestedPrefixes = (Map)paramXmlOptions.get("SAVE_SUGGESTED_PREFIXES");
/*      */     }
/*  138 */     this._ancestorNamespaces = this._cur.getAncestorNamespaces(); } private static SaveCur createSaveCur(Cur paramCur, XmlOptions paramXmlOptions) {
/*      */     DocSaveCur docSaveCur;
/*      */     FragSaveCur fragSaveCur1;
/*      */     FilterPiSaveCur filterPiSaveCur;
/*      */     PrettySaveCur prettySaveCur;
/*  143 */     b b1 = (b)paramXmlOptions.get("SAVE_SYNTHETIC_DOCUMENT_ELEMENT");
/*      */     
/*  145 */     b b2 = b1;
/*      */     
/*  147 */     if (b2 == null)
/*      */     {
/*  149 */       b2 = paramXmlOptions.hasOption("SAVE_USE_OPEN_FRAGMENT") ? Locale._openuriFragment : Locale._xmlFragment;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  155 */     boolean bool = (paramXmlOptions.hasOption("SAVE_INNER") && !paramXmlOptions.hasOption("SAVE_OUTER")) ? true : false;
/*      */ 
/*      */ 
/*      */     
/*  159 */     Cur cur1 = paramCur.tempCur();
/*  160 */     Cur cur2 = paramCur.tempCur();
/*      */     
/*  162 */     FragSaveCur fragSaveCur2 = null;
/*      */     
/*  164 */     int i = paramCur.kind();
/*      */     
/*  166 */     switch (i) {
/*      */ 
/*      */       
/*      */       case 1:
/*  170 */         positionToInner(paramCur, cur1, cur2);
/*      */         
/*  172 */         if (Locale.isFragment(cur1, cur2)) {
/*  173 */           fragSaveCur2 = new FragSaveCur(cur1, cur2, b2); break;
/*  174 */         }  if (b1 != null) {
/*  175 */           fragSaveCur2 = new FragSaveCur(cur1, cur2, b1); break;
/*      */         } 
/*  177 */         docSaveCur = new DocSaveCur(paramCur);
/*      */         break;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/*  184 */         if (bool) {
/*      */           
/*  186 */           positionToInner(paramCur, cur1, cur2);
/*      */           
/*  188 */           FragSaveCur fragSaveCur = new FragSaveCur(cur1, cur2, Locale.isFragment(cur1, cur2) ? b2 : b1);
/*      */           
/*      */           break;
/*      */         } 
/*  192 */         if (b1 != null) {
/*      */           
/*  194 */           positionToInner(paramCur, cur1, cur2);
/*      */           
/*  196 */           FragSaveCur fragSaveCur = new FragSaveCur(cur1, cur2, b1);
/*      */           
/*      */           break;
/*      */         } 
/*  200 */         cur1.moveToCur(paramCur);
/*  201 */         cur2.moveToCur(paramCur);
/*  202 */         cur2.skip();
/*      */         
/*  204 */         fragSaveCur1 = new FragSaveCur(cur1, cur2, null);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  211 */     if (fragSaveCur1 == null) {
/*      */       
/*  213 */       assert i < 0 || i == 3 || i == 4 || i == 5 || i == 0;
/*      */       
/*  215 */       if (i < 0) {
/*      */ 
/*      */         
/*  218 */         cur1.moveToCur(paramCur);
/*  219 */         cur2.moveToCur(paramCur);
/*      */       }
/*  221 */       else if (i == 0) {
/*      */         
/*  223 */         cur1.moveToCur(paramCur);
/*  224 */         cur2.moveToCur(paramCur);
/*  225 */         cur2.next();
/*      */       }
/*  227 */       else if (bool) {
/*      */         
/*  229 */         cur1.moveToCur(paramCur);
/*  230 */         cur1.next();
/*      */         
/*  232 */         cur2.moveToCur(paramCur);
/*  233 */         cur2.toEnd();
/*      */       }
/*  235 */       else if (i == 3) {
/*      */         
/*  237 */         cur1.moveToCur(paramCur);
/*  238 */         cur2.moveToCur(paramCur);
/*      */       }
/*      */       else {
/*      */         
/*  242 */         assert i == 4 || i == 5;
/*      */         
/*  244 */         cur1.moveToCur(paramCur);
/*  245 */         cur2.moveToCur(paramCur);
/*  246 */         cur2.skip();
/*      */       } 
/*      */       
/*  249 */       fragSaveCur1 = new FragSaveCur(cur1, cur2, b2);
/*      */     } 
/*      */     
/*  252 */     String str = (String)paramXmlOptions.get("SAVE_FILTER_PROCINST");
/*      */     
/*  254 */     if (str != null) {
/*  255 */       filterPiSaveCur = new FilterPiSaveCur(fragSaveCur1, str);
/*      */     }
/*  257 */     if (paramXmlOptions.hasOption("SAVE_PRETTY_PRINT")) {
/*  258 */       prettySaveCur = new PrettySaveCur(filterPiSaveCur, paramXmlOptions);
/*      */     }
/*  260 */     cur1.release();
/*  261 */     cur2.release();
/*      */     
/*  263 */     return prettySaveCur;
/*      */   }
/*      */ 
/*      */   
/*      */   private static void positionToInner(Cur paramCur1, Cur paramCur2, Cur paramCur3) {
/*  268 */     assert paramCur1.isContainer();
/*      */     
/*  270 */     paramCur2.moveToCur(paramCur1);
/*      */     
/*  272 */     if (!paramCur2.toFirstAttr()) {
/*  273 */       paramCur2.next();
/*      */     }
/*  275 */     paramCur3.moveToCur(paramCur1);
/*  276 */     paramCur3.toEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean saveNamespacesFirst() {
/*  281 */     return this._saveNamespacesFirst;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void enterLocale() {
/*  286 */     this._locale.enter();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void exitLocale() {
/*  291 */     this._locale.exit();
/*      */   }
/*      */   
/*      */   protected final boolean process()
/*      */   {
/*  296 */     assert this._locale.entered();
/*      */     
/*  298 */     if (this._cur == null) {
/*  299 */       return false;
/*      */     }
/*  301 */     if (this._version != this._locale.version()) {
/*  302 */       throw new ConcurrentModificationException("Document changed during save");
/*      */     }
/*  304 */     switch (this._cur.kind()) {
/*      */       case 1:
/*  306 */         processRoot();
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
/*  326 */         this._cur.next();
/*      */         
/*  328 */         return true;case 2: processElement(); this._cur.next(); return true;case -2: processFinish(); this._cur.next(); return true;case 0: emitText(this._cur); this._cur.next(); return true;case 4: emitComment(this._cur); this._cur.toEnd(); this._cur.next(); return true;case 5: emitProcinst(this._cur); this._cur.toEnd(); this._cur.next(); return true;
/*      */       case -1:
/*      */         emitEndDoc(this._cur); this._cur.release(); this._cur = null;
/*      */         return true;
/*      */     } 
/*  333 */     throw new RuntimeException("Unexpected kind"); } private final void processFinish() { emitFinish(this._cur);
/*  334 */     popMappings(); }
/*      */ 
/*      */ 
/*      */   
/*      */   private final void processRoot() {
/*  339 */     assert this._cur.isRoot();
/*      */     
/*  341 */     XmlDocumentProperties xmlDocumentProperties = this._cur.getDocProps();
/*  342 */     String str1 = null;
/*  343 */     String str2 = null;
/*  344 */     if (xmlDocumentProperties != null) {
/*      */       
/*  346 */       str1 = xmlDocumentProperties.getDoctypeSystemId();
/*  347 */       str2 = xmlDocumentProperties.getDoctypeName();
/*      */     } 
/*      */     
/*  350 */     if (str1 != null || str2 != null) {
/*      */       
/*  352 */       if (str2 == null) {
/*      */         
/*  354 */         this._cur.push();
/*  355 */         while (!this._cur.isElem() && this._cur.next());
/*      */         
/*  357 */         if (this._cur.isElem())
/*  358 */           str2 = this._cur.getName().dT(); 
/*  359 */         this._cur.pop();
/*      */       } 
/*      */       
/*  362 */       String str = xmlDocumentProperties.getDoctypePublicId();
/*      */       
/*  364 */       if (str2 != null) {
/*      */         
/*  366 */         b b = this._cur.getName();
/*      */         
/*  368 */         if (b == null) {
/*      */           
/*  370 */           this._cur.push();
/*  371 */           while (!this._cur.isFinish()) {
/*      */             
/*  373 */             if (this._cur.isElem()) {
/*      */               
/*  375 */               b = this._cur.getName();
/*      */               break;
/*      */             } 
/*  378 */             this._cur.next();
/*      */           } 
/*  380 */           this._cur.pop();
/*      */         } 
/*      */         
/*  383 */         if (b != null && str2.equals(b.dT())) {
/*      */           
/*  385 */           emitDocType(str2, str, str1);
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*  391 */     emitStartDoc(this._cur);
/*      */   }
/*      */ 
/*      */   
/*      */   private final void processElement() {
/*  396 */     assert this._cur.isElem() && this._cur.getName() != null;
/*      */     
/*  398 */     b b = this._cur.getName();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  404 */     boolean bool = (b.getNamespaceURI().length() == 0) ? true : false;
/*      */     
/*  406 */     pushMappings(this._cur, bool);
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
/*  419 */     ensureMapping(b.getNamespaceURI(), b.getPrefix(), !bool, false);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  425 */     this._attrNames.clear();
/*  426 */     this._attrValues.clear();
/*      */     
/*  428 */     this._cur.push();
/*      */ 
/*      */     
/*  431 */     for (boolean bool1 = this._cur.toFirstAttr(); bool1; bool1 = this._cur.toNextAttr()) {
/*      */       
/*  433 */       if (this._cur.isNormalAttr()) {
/*      */         
/*  435 */         b b1 = this._cur.getName();
/*      */         
/*  437 */         this._attrNames.add(b1);
/*      */         
/*  439 */         int i = this._attrNames.size() - 2; while (true) { if (i >= 0) {
/*      */             
/*  441 */             if (this._attrNames.get(i).equals(b1)) {
/*      */               
/*  443 */               this._attrNames.remove(this._attrNames.size() - 1); break;
/*      */             } 
/*      */             i--;
/*      */             continue;
/*      */           } 
/*  448 */           this._attrValues.add(this._cur.getAttrValue());
/*      */           
/*  450 */           ensureMapping(b1.getNamespaceURI(), b1.getPrefix(), false, true); break; }
/*      */       
/*      */       } 
/*      */     } 
/*  454 */     this._cur.pop();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  461 */     if (this._preComputedNamespaces != null) {
/*      */       
/*  463 */       for (String str1 : this._preComputedNamespaces.keySet()) {
/*      */ 
/*      */         
/*  466 */         String str2 = (String)this._preComputedNamespaces.get(str1);
/*  467 */         boolean bool2 = (str2.length() == 0 && !bool) ? true : false;
/*      */         
/*  469 */         ensureMapping(str1, str2, bool2, false);
/*      */       } 
/*      */ 
/*      */       
/*  473 */       this._preComputedNamespaces = null;
/*      */     } 
/*      */     
/*  476 */     if (emitElement(this._cur, this._attrNames, this._attrValues)) {
/*      */       
/*  478 */       popMappings();
/*  479 */       this._cur.toEnd();
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
/*      */   boolean hasMappings() {
/*  494 */     int i = this._namespaceStack.size();
/*      */     
/*  496 */     return (i > 0 && this._namespaceStack.get(i - 1) != null);
/*      */   }
/*      */ 
/*      */   
/*      */   void iterateMappings() {
/*  501 */     this._currentMapping = this._namespaceStack.size();
/*      */     
/*  503 */     while (this._currentMapping > 0 && this._namespaceStack.get(this._currentMapping - 1) != null) {
/*  504 */       this._currentMapping -= 8;
/*      */     }
/*      */   }
/*      */   
/*      */   boolean hasMapping() {
/*  509 */     return (this._currentMapping < this._namespaceStack.size());
/*      */   }
/*      */ 
/*      */   
/*      */   void nextMapping() {
/*  514 */     this._currentMapping += 8;
/*      */   }
/*      */ 
/*      */   
/*      */   String mappingPrefix() {
/*  519 */     assert hasMapping();
/*  520 */     return this._namespaceStack.get(this._currentMapping + 6);
/*      */   }
/*      */ 
/*      */   
/*      */   String mappingUri() {
/*  525 */     assert hasMapping();
/*  526 */     return this._namespaceStack.get(this._currentMapping + 7);
/*      */   }
/*      */ 
/*      */   
/*      */   private final void pushMappings(SaveCur paramSaveCur, boolean paramBoolean) {
/*  531 */     assert paramSaveCur.isContainer();
/*      */     
/*  533 */     this._namespaceStack.add(null);
/*      */     
/*  535 */     paramSaveCur.push();
/*      */     
/*      */     boolean bool;
/*  538 */     for (bool = paramSaveCur.toFirstAttr(); bool; bool = paramSaveCur.toNextAttr()) {
/*  539 */       if (paramSaveCur.isXmlns())
/*  540 */         addNewFrameMapping(paramSaveCur.getXmlnsPrefix(), paramSaveCur.getXmlnsUri(), paramBoolean); 
/*      */     } 
/*  542 */     paramSaveCur.pop();
/*      */     
/*  544 */     if (this._ancestorNamespaces != null) {
/*      */       
/*  546 */       for (bool = false; bool < this._ancestorNamespaces.size(); bool += true) {
/*      */         
/*  548 */         String str1 = this._ancestorNamespaces.get(bool);
/*  549 */         String str2 = this._ancestorNamespaces.get(bool + 1);
/*      */         
/*  551 */         addNewFrameMapping(str1, str2, paramBoolean);
/*      */       } 
/*      */       
/*  554 */       this._ancestorNamespaces = null;
/*      */     } 
/*      */     
/*  557 */     if (paramBoolean) {
/*      */       
/*  559 */       String str = (String)this._prefixMap.get("");
/*      */ 
/*      */       
/*  562 */       assert str != null;
/*      */       
/*  564 */       if (str.length() > 0) {
/*  565 */         addMapping("", "");
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final void addNewFrameMapping(String paramString1, String paramString2, boolean paramBoolean) {
/*  575 */     if ((paramString1.length() == 0 || paramString2.length() > 0) && (!paramBoolean || paramString1.length() > 0 || paramString2.length() == 0)) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  580 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*  581 */         if (mappingPrefix().equals(paramString1)) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  588 */       if (paramString2.equals(getNamespaceForPrefix(paramString1))) {
/*      */         return;
/*      */       }
/*  591 */       addMapping(paramString1, paramString2);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private final void addMapping(String paramString1, String paramString2) {
/*  597 */     assert paramString2 != null;
/*  598 */     assert paramString1 != null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  604 */     String str1 = (String)this._prefixMap.get(paramString1);
/*  605 */     String str2 = null;
/*      */     
/*  607 */     if (str1 != null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  612 */       if (str1.equals(paramString2)) {
/*  613 */         str1 = null;
/*      */       } else {
/*      */         
/*  616 */         int i = this._namespaceStack.size();
/*      */         
/*  618 */         while (i > 0) {
/*      */           
/*  620 */           if (this._namespaceStack.get(i - 1) == null) {
/*      */             
/*  622 */             i--;
/*      */             
/*      */             continue;
/*      */           } 
/*  626 */           if (this._namespaceStack.get(i - 7).equals(str1)) {
/*      */             
/*  628 */             str2 = this._namespaceStack.get(i - 8);
/*      */             
/*  630 */             if (str2 == null || !str2.equals(paramString1)) {
/*      */               break;
/*      */             }
/*      */           } 
/*  634 */           i -= 8;
/*      */         } 
/*      */         
/*  637 */         assert i > 0;
/*      */       } 
/*      */     }
/*      */     
/*  641 */     this._namespaceStack.add(this._uriMap.get(paramString2));
/*  642 */     this._namespaceStack.add(paramString2);
/*      */     
/*  644 */     if (str1 != null) {
/*      */       
/*  646 */       this._namespaceStack.add(this._uriMap.get(str1));
/*  647 */       this._namespaceStack.add(str1);
/*      */     }
/*      */     else {
/*      */       
/*  651 */       this._namespaceStack.add(null);
/*  652 */       this._namespaceStack.add(null);
/*      */     } 
/*      */     
/*  655 */     this._namespaceStack.add(paramString1);
/*  656 */     this._namespaceStack.add(this._prefixMap.get(paramString1));
/*      */     
/*  658 */     this._namespaceStack.add(paramString1);
/*  659 */     this._namespaceStack.add(paramString2);
/*      */     
/*  661 */     this._uriMap.put(paramString2, paramString1);
/*  662 */     this._prefixMap.put(paramString1, paramString2);
/*      */     
/*  664 */     if (str1 != null) {
/*  665 */       this._uriMap.put(str1, str2);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private final void popMappings() {
/*      */     while (true) {
/*  672 */       int i = this._namespaceStack.size();
/*      */       
/*  674 */       if (i == 0) {
/*      */         break;
/*      */       }
/*  677 */       if (this._namespaceStack.get(i - 1) == null) {
/*      */         
/*  679 */         this._namespaceStack.remove(i - 1);
/*      */         
/*      */         break;
/*      */       } 
/*  683 */       Object object1 = this._namespaceStack.get(i - 7);
/*  684 */       Object object2 = this._namespaceStack.get(i - 8);
/*      */       
/*  686 */       if (object2 == null) {
/*  687 */         this._uriMap.remove(object1);
/*      */       } else {
/*  689 */         this._uriMap.put(object1, object2);
/*      */       } 
/*  691 */       object2 = this._namespaceStack.get(i - 4);
/*  692 */       object1 = this._namespaceStack.get(i - 3);
/*      */       
/*  694 */       if (object1 == null) {
/*  695 */         this._prefixMap.remove(object2);
/*      */       } else {
/*  697 */         this._prefixMap.put(object2, object1);
/*      */       } 
/*  699 */       String str = this._namespaceStack.get(i - 5);
/*      */       
/*  701 */       if (str != null) {
/*  702 */         this._uriMap.put(str, this._namespaceStack.get(i - 6));
/*      */       }
/*      */       
/*  705 */       this._namespaceStack.remove(i - 1);
/*  706 */       this._namespaceStack.remove(i - 2);
/*  707 */       this._namespaceStack.remove(i - 3);
/*  708 */       this._namespaceStack.remove(i - 4);
/*  709 */       this._namespaceStack.remove(i - 5);
/*  710 */       this._namespaceStack.remove(i - 6);
/*  711 */       this._namespaceStack.remove(i - 7);
/*  712 */       this._namespaceStack.remove(i - 8);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private final void dumpMappings() {
/*  718 */     for (int i = this._namespaceStack.size(); i > 0; ) {
/*      */       
/*  720 */       if (this._namespaceStack.get(i - 1) == null) {
/*      */         
/*  722 */         System.out.println("----------------");
/*  723 */         i--;
/*      */         
/*      */         continue;
/*      */       } 
/*  727 */       System.out.print("Mapping: ");
/*  728 */       System.out.print(this._namespaceStack.get(i - 2));
/*  729 */       System.out.print(" -> ");
/*  730 */       System.out.print(this._namespaceStack.get(i - 1));
/*  731 */       System.out.println();
/*      */       
/*  733 */       System.out.print("Prefix Undo: ");
/*  734 */       System.out.print(this._namespaceStack.get(i - 4));
/*  735 */       System.out.print(" -> ");
/*  736 */       System.out.print(this._namespaceStack.get(i - 3));
/*  737 */       System.out.println();
/*      */       
/*  739 */       System.out.print("Uri Rename: ");
/*  740 */       System.out.print(this._namespaceStack.get(i - 5));
/*  741 */       System.out.print(" -> ");
/*  742 */       System.out.print(this._namespaceStack.get(i - 6));
/*  743 */       System.out.println();
/*      */       
/*  745 */       System.out.print("UriUndo: ");
/*  746 */       System.out.print(this._namespaceStack.get(i - 7));
/*  747 */       System.out.print(" -> ");
/*  748 */       System.out.print(this._namespaceStack.get(i - 8));
/*  749 */       System.out.println();
/*      */       
/*  751 */       System.out.println();
/*      */       
/*  753 */       i -= 8;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String ensureMapping(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2) {
/*  761 */     assert paramString1 != null;
/*      */ 
/*      */ 
/*      */     
/*  765 */     if (paramString1.length() == 0) {
/*  766 */       return null;
/*      */     }
/*  768 */     String str = (String)this._uriMap.get(paramString1);
/*      */     
/*  770 */     if (str != null && (str.length() > 0 || !paramBoolean2)) {
/*  771 */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  782 */     if (paramString2 != null && paramString2.length() == 0) {
/*  783 */       paramString2 = null;
/*      */     }
/*  785 */     if (paramString2 == null || !tryPrefix(paramString2))
/*      */     {
/*  787 */       if (this._suggestedPrefixes != null && this._suggestedPrefixes.containsKey(paramString1) && tryPrefix((String)this._suggestedPrefixes.get(paramString1))) {
/*      */ 
/*      */ 
/*      */         
/*  791 */         paramString2 = (String)this._suggestedPrefixes.get(paramString1);
/*      */       }
/*  793 */       else if (paramBoolean1 && this._useDefaultNamespace && tryPrefix("")) {
/*  794 */         paramString2 = "";
/*      */       } else {
/*      */         
/*  797 */         String str1 = QNameHelper.suggestPrefix(paramString1);
/*  798 */         paramString2 = str1;
/*      */         
/*  800 */         byte b = 1;
/*      */         
/*  802 */         for (; !tryPrefix(paramString2); b++)
/*      */         {
/*      */           
/*  805 */           paramString2 = str1 + b;
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  810 */     assert paramString2 != null;
/*      */     
/*  812 */     syntheticNamespace(paramString2, paramString1, paramBoolean1);
/*      */     
/*  814 */     addMapping(paramString2, paramString1);
/*      */     
/*  816 */     return paramString2;
/*      */   }
/*      */ 
/*      */   
/*      */   protected final String getUriMapping(String paramString) {
/*  821 */     assert this._uriMap.get(paramString) != null;
/*  822 */     return (String)this._uriMap.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   String getNonDefaultUriMapping(String paramString) {
/*  827 */     str = (String)this._uriMap.get(paramString);
/*      */     
/*  829 */     if (str != null && str.length() > 0) {
/*  830 */       return str;
/*      */     }
/*  832 */     for (String str : this._prefixMap.keySet()) {
/*      */ 
/*      */ 
/*      */       
/*  836 */       if (str.length() > 0 && this._prefixMap.get(str).equals(paramString)) {
/*  837 */         return str;
/*      */       }
/*      */     } 
/*  840 */     assert false : "Could not find non-default mapping";
/*      */     
/*  842 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private final boolean tryPrefix(String paramString) {
/*  847 */     if (paramString == null || Locale.beginsWithXml(paramString)) {
/*  848 */       return false;
/*      */     }
/*  850 */     String str = (String)this._prefixMap.get(paramString);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  859 */     if (str != null && (paramString.length() > 0 || str != this._initialDefaultUri)) {
/*  860 */       return false;
/*      */     }
/*  862 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public final String getNamespaceForPrefix(String paramString) {
/*  867 */     assert !paramString.equals("xml") || this._prefixMap.get(paramString).equals("http://www.w3.org/XML/1998/namespace");
/*      */     
/*  869 */     return (String)this._prefixMap.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   protected Map getPrefixMap() {
/*  874 */     return this._prefixMap;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class SynthNamespaceSaver
/*      */     extends Saver
/*      */   {
/*  883 */     LinkedHashMap _synthNamespaces = new LinkedHashMap();
/*      */ 
/*      */     
/*      */     SynthNamespaceSaver(Cur param1Cur, XmlOptions param1XmlOptions) {
/*  887 */       super(param1Cur, param1XmlOptions);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void syntheticNamespace(String param1String1, String param1String2, boolean param1Boolean) {
/*  893 */       this._synthNamespaces.put(param1String2, param1Boolean ? "" : param1String1);
/*      */     }
/*      */     
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) {
/*  897 */       return false;
/*      */     }
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) {}
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {} }
/*      */   static final class TextSaver extends Saver { private static final int _initialBufSize = 4096; private int _cdataLengthThreshold; private int _cdataEntityCountThreshold; private boolean _useCDataBookmarks;
/*      */     private boolean _isPrettyPrint;
/*      */     private int _lastEmitIn;
/*      */     private int _lastEmitCch;
/*      */     private int _free;
/*      */     private int _in;
/*      */     private int _out;
/*      */     private char[] _buf;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*  916 */     TextSaver(Cur param1Cur, XmlOptions param1XmlOptions, String param1String) { super(param1Cur, param1XmlOptions);
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
/* 1879 */       this._cdataLengthThreshold = 32;
/* 1880 */       this._cdataEntityCountThreshold = 5;
/* 1881 */       this._useCDataBookmarks = false;
/* 1882 */       this._isPrettyPrint = false; boolean bool = (param1XmlOptions != null && param1XmlOptions.hasOption("SAVE_NO_XML_DECL")) ? true : false; if (param1XmlOptions != null && param1XmlOptions.hasOption("SAVE_CDATA_LENGTH_THRESHOLD")) this._cdataLengthThreshold = ((Integer)param1XmlOptions.get("SAVE_CDATA_LENGTH_THRESHOLD")).intValue();  if (param1XmlOptions != null && param1XmlOptions.hasOption("SAVE_CDATA_ENTITY_COUNT_THRESHOLD")) this._cdataEntityCountThreshold = ((Integer)param1XmlOptions.get("SAVE_CDATA_ENTITY_COUNT_THRESHOLD")).intValue();  if (param1XmlOptions != null && param1XmlOptions.hasOption("LOAD_SAVE_CDATA_BOOKMARKS")) this._useCDataBookmarks = true;  if (param1XmlOptions != null && param1XmlOptions.hasOption("SAVE_PRETTY_PRINT")) this._isPrettyPrint = true;  this._in = this._out = 0; this._free = 0; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; if (param1String != null && !bool) { XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(param1Cur, false); String str = (xmlDocumentProperties == null) ? null : xmlDocumentProperties.getVersion(); if (str == null) str = "1.0";  emit("<?xml version=\""); emit(str); emit("\" encoding=\"" + param1String + "\"?>" + _newLine); }  }
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) { assert param1SaveCur.isElem(); emit('<'); emitName(param1SaveCur.getName(), false); if (saveNamespacesFirst()) emitNamespacesHelper();  for (byte b = 0; b < param1ArrayList1.size(); b++) emitAttrHelper(param1ArrayList1.get(b), param1ArrayList2.get(b));  if (!saveNamespacesFirst()) emitNamespacesHelper();  if (!param1SaveCur.hasChildren() && !param1SaveCur.hasText()) { emit('/', '>'); return true; }  emit('>'); return false; }
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) { emit('<', '/'); emitName(param1SaveCur.getName(), false); emit('>'); }
/*      */     protected void emitXmlns(String param1String1, String param1String2) { assert param1String1 != null; assert param1String2 != null; emit("xmlns"); if (param1String1.length() > 0) { emit(':'); emit(param1String1); }  emit('=', '"'); emit(param1String2); entitizeAttrValue(false); emit('"'); }
/*      */     private void emitNamespacesHelper() { iterateMappings(); for (; hasMapping(); nextMapping()) { emit(' '); emitXmlns(mappingPrefix(), mappingUri()); }  }
/*      */     private void emitAttrHelper(b param1b, String param1String) { emit(' '); emitName(param1b, true); emit('=', '"'); emit(param1String); entitizeAttrValue(true); emit('"'); }
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) { assert param1SaveCur.isText(); boolean bool = (this._useCDataBookmarks && param1SaveCur.isTextCData()) ? true : false; emit(param1SaveCur); entitizeContent(bool); }
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) { assert param1SaveCur.isComment(); emit("<!--"); param1SaveCur.push(); param1SaveCur.next(); emit(param1SaveCur); param1SaveCur.pop(); entitizeComment(); emit("-->"); }
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) { assert param1SaveCur.isProcinst(); emit("<?"); emit(param1SaveCur.getName().dT()); param1SaveCur.push(); param1SaveCur.next(); if (param1SaveCur.isText()) { emit(" "); emit(param1SaveCur); entitizeProcinst(); }  param1SaveCur.pop(); emit("?>"); }
/*      */     private void emitLiteral(String param1String) { if (param1String.indexOf("\"") < 0) { emit('"'); emit(param1String); emit('"'); } else { emit('\''); emit(param1String); emit('\''); }  }
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) { assert param1String1 != null; emit("<!DOCTYPE "); emit(param1String1); if (param1String2 == null && param1String3 != null) { emit(" SYSTEM "); emitLiteral(param1String3); } else if (param1String2 != null) { emit(" PUBLIC "); emitLiteral(param1String2); emit(" "); emitLiteral(param1String3); }  emit(">"); emit(_newLine); }
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {}
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {}
/*      */     private void emitName(b param1b, boolean param1Boolean) { assert param1b != null; String str = param1b.getNamespaceURI(); assert str != null; if (str.length() != 0) { String str1 = param1b.getPrefix(); String str2 = getNamespaceForPrefix(str1); if (str2 == null || !str2.equals(str)) str1 = getUriMapping(str);  if (param1Boolean && str1.length() == 0) str1 = getNonDefaultUriMapping(str);  if (str1.length() > 0) { emit(str1); emit(':'); }  }  assert param1b.dT().length() > 0; emit(param1b.dT()); }
/*      */     private void emit(char param1Char) { assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; preEmit(1); this._buf[this._in] = param1Char; this._in = (this._in + 1) % this._buf.length; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; }
/*      */     private void emit(char param1Char1, char param1Char2) { if (preEmit(2)) return;  this._buf[this._in] = param1Char1; this._in = (this._in + 1) % this._buf.length; this._buf[this._in] = param1Char2; this._in = (this._in + 1) % this._buf.length; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; }
/*      */     private void emit(String param1String) { assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; byte b = (param1String == null) ? 0 : param1String.length(); if (preEmit(b)) return;  int i; if (this._in <= this._out || b < (i = this._buf.length - this._in)) { param1String.getChars(0, b, this._buf, this._in); this._in += b; } else { param1String.getChars(0, i, this._buf, this._in); param1String.getChars(i, b, this._buf, 0); this._in = (this._in + b) % this._buf.length; }  assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; }
/*      */     private void emit(Saver.SaveCur param1SaveCur) { if (param1SaveCur.isText()) { Object object = param1SaveCur.getChars(); int i = param1SaveCur._cchSrc; if (preEmit(i)) return;  int j; if (this._in <= this._out || i < (j = this._buf.length - this._in)) { CharUtil.getChars(this._buf, this._in, object, param1SaveCur._offSrc, i); this._in += i; } else { CharUtil.getChars(this._buf, this._in, object, param1SaveCur._offSrc, j); CharUtil.getChars(this._buf, 0, object, param1SaveCur._offSrc + j, i - j); this._in = (this._in + i) % this._buf.length; }  } else { preEmit(0); }  }
/*      */     private boolean preEmit(int param1Int) { assert param1Int >= 0; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; this._lastEmitCch = param1Int; if (param1Int == 0) return true;  if (this._free <= param1Int) resize(param1Int, -1);  assert param1Int <= this._free; int i = getAvailable(); if (i == 0) { assert this._in == this._out; assert this._free == this._buf.length; this._in = this._out = 0; }  this._lastEmitIn = this._in; this._free -= param1Int; assert this._free >= 0; assert this._buf == null || this._free == ((this._in >= this._out) ? (this._buf.length - this._in - this._out) : (this._out - this._in)) - param1Int : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; assert (this._out > this._in && this._free == this._out - this._in - param1Int) || (this._out == this._in && this._free == this._buf.length - param1Int) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; return false; } private void entitizeContent(boolean param1Boolean) { assert this._free >= 0; if (this._lastEmitCch == 0) return;  int i = this._lastEmitIn; int j = this._buf.length; boolean bool = false; byte b = 0; char c1 = Character.MIN_VALUE; char c2 = Character.MIN_VALUE; int k; for (k = this._lastEmitCch; k > 0; k--) { char c = this._buf[i]; if (c == '<' || c == '&') { b++; } else if (c2 == ']' && c1 == ']' && c == '>') { bool = true; } else if (isBadChar(c) || isEscapedChar(c) || (!this._isPrettyPrint && c == '\r')) { bool = true; }  if (++i == j) i = 0;  c2 = c1; c1 = c; }  if (!param1Boolean && b == 0 && !bool && b < this._cdataEntityCountThreshold) return;  i = this._lastEmitIn; if (param1Boolean || (this._lastEmitCch > this._cdataLengthThreshold && b > this._cdataEntityCountThreshold)) { k = (this._buf[i] == ']') ? 1 : 0; i = replace(i, "<![CDATA[" + this._buf[i]); int m = k; k = (this._buf[i] == ']') ? 1 : 0; if (++i == this._buf.length) i = 0;  for (int n = this._lastEmitCch; n > 0; n--) { char c = this._buf[i]; if (c == '>' && m != 0 && k != 0) { i = replace(i, "]]>><![CDATA["); } else if (isBadChar(c)) { i = replace(i, "?"); } else { i++; }  m = k; k = (c == ']') ? 1 : 0; if (i == this._buf.length) i = 0;  }  emit("]]>"); } else { k = 0; int m = 0; for (int n = this._lastEmitCch; n > 0; n--) { int i1 = m; m = k; k = this._buf[i]; if (k == 60) { i = replace(i, "&lt;"); } else if (k == 38) { i = replace(i, "&amp;"); } else if (k == 62 && m == 93 && i1 == 93) { i = replace(i, "&gt;"); } else if (isBadChar(k)) { i = replace(i, "?"); } else if (!this._isPrettyPrint && k == 13) { i = replace(i, "&#13;"); } else if (isEscapedChar(k)) { i = replace(i, this._replaceChar.getEscapedString(k)); } else { i++; }  if (i == this._buf.length) i = 0;  }  }  } private void entitizeAttrValue(boolean param1Boolean) { if (this._lastEmitCch == 0) return;  int i = this._lastEmitIn; for (int j = this._lastEmitCch; j > 0; j--) { char c = this._buf[i]; if (c == '<') { i = replace(i, "&lt;"); } else if (c == '&') { i = replace(i, "&amp;"); } else if (c == '"') { i = replace(i, "&quot;"); } else if (isEscapedChar(c)) { if (param1Boolean) i = replace(i, this._replaceChar.getEscapedString(c));  } else { i++; }  if (i == this._buf.length) i = 0;  }  } private void entitizeComment() { if (this._lastEmitCch == 0) return;  int i = this._lastEmitIn; boolean bool = false; int j; for (j = this._lastEmitCch; j > 0; j--) { char c = this._buf[i]; if (isBadChar(c)) { i = replace(i, "?"); } else if (c == '-') { if (bool) { i = replace(i, " "); bool = false; } else { bool = true; i++; }  } else { bool = false; i++; }  if (i == this._buf.length) i = 0;  }  j = (this._lastEmitIn + this._lastEmitCch - 1) % this._buf.length; if (this._buf[j] == '-') i = replace(j, " ");  } private void entitizeProcinst() { if (this._lastEmitCch == 0) return;  int i = this._lastEmitIn; boolean bool = false; for (int j = this._lastEmitCch; j > 0; j--) { char c = this._buf[i]; if (isBadChar(c)) i = replace(i, "?");  if (c == '>') { if (bool) { i = replace(i, " "); } else { i++; }  bool = false; } else { bool = (c == '?') ? true : false; i++; }  if (i == this._buf.length) i = 0;  }  } private boolean isBadChar(char param1Char) { return ((param1Char < ' ' || param1Char > '퟿') && (param1Char < '' || param1Char > '�') && (param1Char < 65536 || param1Char > 1114111) && param1Char != '\t' && param1Char != '\n' && param1Char != '\r'); } private boolean isEscapedChar(char param1Char) { return (null != this._replaceChar && this._replaceChar.containsChar(param1Char)); } private int replace(int param1Int, String param1String) { assert param1String.length() > 0; int i = param1String.length() - 1; if (i == 0) { this._buf[param1Int] = param1String.charAt(0); return param1Int + 1; }  assert this._free >= 0; if (i > this._free) param1Int = resize(i, param1Int);  assert this._free >= 0; assert this._free >= i; assert getAvailable() > 0; int j = i + 1; if (this._out > this._in && param1Int >= this._out) { System.arraycopy(this._buf, this._out, this._buf, this._out - i, param1Int - this._out); this._out -= i; param1Int -= i; } else { assert param1Int < this._in; int k = this._buf.length - this._in; if (i <= k) { System.arraycopy(this._buf, param1Int, this._buf, param1Int + i, this._in - param1Int); this._in = (this._in + i) % this._buf.length; } else if (i <= k + this._in - param1Int - 1) { int m = i - k; System.arraycopy(this._buf, this._in - m, this._buf, 0, m); System.arraycopy(this._buf, param1Int + 1, this._buf, param1Int + 1 + i, this._in - param1Int - 1 - m); this._in = m; } else { int m = this._in - param1Int - 1; j = k + this._in - param1Int; System.arraycopy(this._buf, this._in - m, this._buf, i - j + 1, m); param1String.getChars(j, i + 1, this._buf, 0); this._in = m + i - j + 1; }  }  param1String.getChars(0, j, this._buf, param1Int); this._free -= i; assert this._free >= 0; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; return (param1Int + i + 1) % this._buf.length; } private int ensure(int param1Int) { if (param1Int <= 0) param1Int = 1;  int i = getAvailable(); for (; i < param1Int && process(); i = getAvailable()); assert i == getAvailable(); return i; } int getAvailable() { return (this._buf == null) ? 0 : (this._buf.length - this._free); } private int resize(int param1Int1, int param1Int2) { assert this._free >= 0; assert param1Int1 > 0; assert param1Int1 >= this._free; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; int i = (this._buf == null) ? 4096 : (this._buf.length * 2); int j = getAvailable(); while (i - j < param1Int1) i *= 2;  char[] arrayOfChar = new char[i]; if (j > 0) { if (this._in > this._out) { assert param1Int2 == -1 || (param1Int2 >= this._out && param1Int2 < this._in); System.arraycopy(this._buf, this._out, arrayOfChar, 0, j); param1Int2 -= this._out; } else { assert param1Int2 == -1 || param1Int2 >= this._out || param1Int2 < this._in; System.arraycopy(this._buf, this._out, arrayOfChar, 0, j - this._in); System.arraycopy(this._buf, 0, arrayOfChar, j - this._in, this._in); param1Int2 = (param1Int2 >= this._out) ? (param1Int2 - this._out) : (param1Int2 + this._out); }  this._out = 0; this._in = j; this._free += arrayOfChar.length - this._buf.length; } else { this._free = arrayOfChar.length; assert this._in == 0 && this._out == 0; assert param1Int2 == -1; }  this._buf = arrayOfChar; assert this._free >= 0; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; return param1Int2; } public int read() { if (ensure(1) == 0) return -1;  assert getAvailable() > 0; char c = this._buf[this._out]; this._out = (this._out + 1) % this._buf.length; this._free++; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; return c; } public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) { int i; if ((i = ensure(param1Int2)) == 0) return -1;  if (param1ArrayOfchar == null || param1Int2 <= 0) return 0;  if (i < param1Int2) param1Int2 = i;  if (this._out < this._in) { System.arraycopy(this._buf, this._out, param1ArrayOfchar, param1Int1, param1Int2); } else { int j = this._buf.length - this._out; if (j >= param1Int2) { System.arraycopy(this._buf, this._out, param1ArrayOfchar, param1Int1, param1Int2); } else { System.arraycopy(this._buf, this._out, param1ArrayOfchar, param1Int1, j); System.arraycopy(this._buf, 0, param1ArrayOfchar, param1Int1 + j, param1Int2 - j); }  }  this._out = (this._out + param1Int2) % this._buf.length; this._free += param1Int2; assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; assert this._free >= 0; return param1Int2; } public int write(Writer param1Writer, int param1Int) { while (getAvailable() < param1Int) { if (!process()) break;  }  int i = getAvailable(); if (i > 0) { assert this._out == 0; assert this._in >= this._out : "_in:" + this._in + " < _out:" + this._out; assert this._free == this._buf.length - this._in; try { param1Writer.write(this._buf, 0, i); param1Writer.flush(); } catch (IOException iOException) { throw new RuntimeException(iOException); }  this._free += i; assert this._free >= 0; this._in = 0; }  assert (this._out > this._in && this._free == this._out - this._in) || (this._out == this._in && this._free == this._buf.length) || (this._out == this._in && this._free == 0) : "_buf.length:" + this._buf.length + " _in:" + this._in + " _out:" + this._out + " _free:" + this._free; return i; } public String saveToString() { while (process()); assert this._out == 0; int i = getAvailable(); return (i == 0) ? "" : new String(this._buf, this._out, i); } }
/*      */    static final class OptimizedForSpeedSaver extends Saver
/*      */   {
/* 1903 */     private char[] _buf = new char[1024];
/*      */     Writer _w;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     private static class SaverIOException
/*      */       extends RuntimeException
/*      */     {
/*      */       SaverIOException(IOException param2IOException) {
/* 1911 */         super(param2IOException);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     OptimizedForSpeedSaver(Cur param1Cur, Writer param1Writer) {
/* 1918 */       super(param1Cur, XmlOptions.maskNull(null));
/* 1919 */       this._w = param1Writer;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     static void save(Cur param1Cur, Writer param1Writer) throws IOException {
/*      */       try {
/* 1927 */         OptimizedForSpeedSaver optimizedForSpeedSaver = new OptimizedForSpeedSaver(param1Cur, param1Writer);
/* 1928 */         while (optimizedForSpeedSaver.process());
/*      */       
/*      */       }
/* 1931 */       catch (SaverIOException saverIOException) {
/*      */         
/* 1933 */         throw (IOException)saverIOException.getCause();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void emit(String param1String) {
/*      */       try {
/* 1941 */         this._w.write(param1String);
/*      */       }
/* 1943 */       catch (IOException iOException) {
/*      */         
/* 1945 */         throw new SaverIOException(iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void emit(char param1Char) {
/*      */       try {
/* 1953 */         this._buf[0] = param1Char;
/* 1954 */         this._w.write(this._buf, 0, 1);
/*      */       }
/* 1956 */       catch (IOException iOException) {
/*      */         
/* 1958 */         throw new SaverIOException(iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void emit(char param1Char1, char param1Char2) {
/*      */       try {
/* 1966 */         this._buf[0] = param1Char1;
/* 1967 */         this._buf[1] = param1Char2;
/* 1968 */         this._w.write(this._buf, 0, 2);
/*      */       }
/* 1970 */       catch (IOException iOException) {
/*      */         
/* 1972 */         throw new SaverIOException(iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void emit(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/*      */       try {
/* 1980 */         this._w.write(param1ArrayOfchar, param1Int1, param1Int2);
/*      */       }
/* 1982 */       catch (IOException iOException) {
/*      */         
/* 1984 */         throw new SaverIOException(iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) {
/* 1990 */       assert param1SaveCur.isElem();
/*      */       
/* 1992 */       emit('<');
/* 1993 */       emitName(param1SaveCur.getName(), false);
/*      */       
/* 1995 */       for (byte b = 0; b < param1ArrayList1.size(); b++) {
/* 1996 */         emitAttrHelper(param1ArrayList1.get(b), param1ArrayList2.get(b));
/*      */       }
/* 1998 */       if (!saveNamespacesFirst()) {
/* 1999 */         emitNamespacesHelper();
/*      */       }
/* 2001 */       if (!param1SaveCur.hasChildren() && !param1SaveCur.hasText()) {
/*      */         
/* 2003 */         emit('/', '>');
/* 2004 */         return true;
/*      */       } 
/*      */ 
/*      */       
/* 2008 */       emit('>');
/* 2009 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) {
/* 2015 */       emit('<', '/');
/* 2016 */       emitName(param1SaveCur.getName(), false);
/* 2017 */       emit('>');
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitXmlns(String param1String1, String param1String2) {
/* 2022 */       assert param1String1 != null;
/* 2023 */       assert param1String2 != null;
/*      */       
/* 2025 */       emit("xmlns");
/*      */       
/* 2027 */       if (param1String1.length() > 0) {
/*      */         
/* 2029 */         emit(':');
/* 2030 */         emit(param1String1);
/*      */       } 
/*      */       
/* 2033 */       emit('=', '"');
/*      */ 
/*      */       
/* 2036 */       emitAttrValue(param1String2);
/*      */       
/* 2038 */       emit('"');
/*      */     }
/*      */ 
/*      */     
/*      */     private void emitNamespacesHelper() {
/* 2043 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*      */         
/* 2045 */         emit(' ');
/* 2046 */         emitXmlns(mappingPrefix(), mappingUri());
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void emitAttrHelper(b param1b, String param1String) {
/* 2052 */       emit(' ');
/* 2053 */       emitName(param1b, true);
/* 2054 */       emit('=', '"');
/* 2055 */       emitAttrValue(param1String);
/*      */       
/* 2057 */       emit('"');
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) {
/* 2062 */       assert param1SaveCur.isComment();
/*      */       
/* 2064 */       emit("<!--");
/*      */       
/* 2066 */       param1SaveCur.push();
/* 2067 */       param1SaveCur.next();
/*      */       
/* 2069 */       emitCommentText(param1SaveCur);
/*      */       
/* 2071 */       param1SaveCur.pop();
/*      */       
/* 2073 */       emit("-->");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) {
/* 2078 */       assert param1SaveCur.isProcinst();
/*      */       
/* 2080 */       emit("<?");
/*      */ 
/*      */       
/* 2083 */       emit(param1SaveCur.getName().dT());
/*      */       
/* 2085 */       param1SaveCur.push();
/*      */       
/* 2087 */       param1SaveCur.next();
/*      */       
/* 2089 */       if (param1SaveCur.isText()) {
/*      */         
/* 2091 */         emit(' ');
/* 2092 */         emitPiText(param1SaveCur);
/*      */       } 
/*      */       
/* 2095 */       param1SaveCur.pop();
/*      */       
/* 2097 */       emit("?>");
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) {
/* 2102 */       assert param1String1 != null;
/*      */       
/* 2104 */       emit("<!DOCTYPE ");
/* 2105 */       emit(param1String1);
/*      */       
/* 2107 */       if (param1String2 == null && param1String3 != null) {
/*      */         
/* 2109 */         emit(" SYSTEM ");
/* 2110 */         emitLiteral(param1String3);
/*      */       }
/* 2112 */       else if (param1String2 != null) {
/*      */         
/* 2114 */         emit(" PUBLIC ");
/* 2115 */         emitLiteral(param1String2);
/* 2116 */         emit(' ');
/* 2117 */         emitLiteral(param1String3);
/*      */       } 
/*      */       
/* 2120 */       emit('>');
/* 2121 */       emit(_newLine);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void emitName(b param1b, boolean param1Boolean) {
/* 2138 */       assert param1b != null;
/*      */       
/* 2140 */       String str = param1b.getNamespaceURI();
/*      */       
/* 2142 */       assert str != null;
/*      */       
/* 2144 */       if (str.length() != 0) {
/*      */         
/* 2146 */         String str1 = param1b.getPrefix();
/* 2147 */         String str2 = getNamespaceForPrefix(str1);
/*      */         
/* 2149 */         if (str2 == null || !str2.equals(str)) {
/* 2150 */           str1 = getUriMapping(str);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2159 */         if (param1Boolean && str1.length() == 0) {
/* 2160 */           str1 = getNonDefaultUriMapping(str);
/*      */         }
/* 2162 */         if (str1.length() > 0) {
/*      */           
/* 2164 */           emit(str1);
/* 2165 */           emit(':');
/*      */         } 
/*      */       } 
/*      */       
/* 2169 */       assert param1b.dT().length() > 0;
/*      */       
/* 2171 */       emit(param1b.dT());
/*      */     }
/*      */ 
/*      */     
/*      */     private void emitAttrValue(CharSequence param1CharSequence) {
/* 2176 */       int i = param1CharSequence.length();
/*      */       
/* 2178 */       for (byte b = 0; b < i; b++) {
/*      */         
/* 2180 */         char c = param1CharSequence.charAt(b);
/*      */         
/* 2182 */         if (c == '<') {
/* 2183 */           emit("&lt;");
/* 2184 */         } else if (c == '&') {
/* 2185 */           emit("&amp;");
/* 2186 */         } else if (c == '"') {
/* 2187 */           emit("&quot;");
/*      */         } else {
/* 2189 */           emit(c);
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean isBadChar(char param1Char) {
/* 2199 */       return ((param1Char < ' ' || param1Char > '퟿') && (param1Char < '' || param1Char > '�') && (param1Char < 65536 || param1Char > 1114111) && param1Char != '\t' && param1Char != '\n' && param1Char != '\r');
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private void emitLiteral(String param1String) {
/* 2211 */       if (param1String.indexOf("\"") < 0) {
/*      */         
/* 2213 */         emit('"');
/* 2214 */         emit(param1String);
/* 2215 */         emit('"');
/*      */       }
/*      */       else {
/*      */         
/* 2219 */         emit('\'');
/* 2220 */         emit(param1String);
/* 2221 */         emit('\'');
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) {
/* 2227 */       assert param1SaveCur.isText();
/*      */       
/* 2229 */       Object object = param1SaveCur.getChars();
/* 2230 */       int i = param1SaveCur._cchSrc;
/* 2231 */       int j = param1SaveCur._offSrc;
/* 2232 */       int k = 0;
/* 2233 */       int m = 0;
/* 2234 */       while (k < i) {
/*      */         
/* 2236 */         m = (k + 512 > i) ? i : (k + 512);
/* 2237 */         CharUtil.getChars(this._buf, 0, object, j + k, m - k);
/* 2238 */         entitizeAndWriteText(m - k);
/* 2239 */         k = m;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitPiText(Saver.SaveCur param1SaveCur) {
/* 2245 */       assert param1SaveCur.isText();
/*      */       
/* 2247 */       Object object = param1SaveCur.getChars();
/* 2248 */       int i = param1SaveCur._cchSrc;
/* 2249 */       int j = param1SaveCur._offSrc;
/* 2250 */       byte b1 = 0;
/* 2251 */       byte b2 = 0;
/* 2252 */       while (b1 < i) {
/*      */         
/* 2254 */         b2 = (b1 + 512 > i) ? i : 512;
/* 2255 */         CharUtil.getChars(this._buf, 0, object, j + b1, b2);
/* 2256 */         entitizeAndWritePIText(b2 - b1);
/* 2257 */         b1 = b2;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitCommentText(Saver.SaveCur param1SaveCur) {
/* 2263 */       assert param1SaveCur.isText();
/*      */       
/* 2265 */       Object object = param1SaveCur.getChars();
/* 2266 */       int i = param1SaveCur._cchSrc;
/* 2267 */       int j = param1SaveCur._offSrc;
/* 2268 */       byte b1 = 0;
/* 2269 */       byte b2 = 0;
/* 2270 */       while (b1 < i) {
/*      */         
/* 2272 */         b2 = (b1 + 512 > i) ? i : 512;
/* 2273 */         CharUtil.getChars(this._buf, 0, object, j + b1, b2);
/* 2274 */         entitizeAndWriteCommentText(b2 - b1);
/* 2275 */         b1 = b2;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void entitizeAndWriteText(int param1Int) {
/* 2281 */       int i = 0;
/* 2282 */       for (byte b = 0; b < param1Int; b++) {
/*      */         
/* 2284 */         char c = this._buf[b];
/* 2285 */         switch (c) {
/*      */           
/*      */           case '<':
/* 2288 */             emit(this._buf, i, b - i);
/* 2289 */             emit("&lt;");
/* 2290 */             i = b + 1;
/*      */             break;
/*      */           case '&':
/* 2293 */             emit(this._buf, i, b - i);
/* 2294 */             emit("&amp;");
/* 2295 */             i = b + 1;
/*      */             break;
/*      */         } 
/*      */       } 
/* 2299 */       emit(this._buf, i, param1Int - i);
/*      */     }
/*      */ 
/*      */     
/*      */     private void entitizeAndWriteCommentText(int param1Int) {
/* 2304 */       boolean bool = false;
/*      */       
/* 2306 */       for (byte b = 0; b < param1Int; b++) {
/*      */         
/* 2308 */         char c = this._buf[b];
/*      */         
/* 2310 */         if (isBadChar(c)) {
/* 2311 */           this._buf[b] = '?';
/* 2312 */         } else if (c == '-') {
/*      */           
/* 2314 */           if (bool)
/*      */           {
/*      */             
/* 2317 */             this._buf[b] = ' ';
/* 2318 */             bool = false;
/*      */           }
/*      */           else
/*      */           {
/* 2322 */             bool = true;
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 2327 */           bool = false;
/*      */         } 
/*      */         
/* 2330 */         if (b == this._buf.length) {
/* 2331 */           b = 0;
/*      */         }
/*      */       } 
/* 2334 */       if (this._buf[param1Int - 1] == '-') {
/* 2335 */         this._buf[param1Int - 1] = ' ';
/*      */       }
/* 2337 */       emit(this._buf, 0, param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     private void entitizeAndWritePIText(int param1Int) {
/* 2342 */       boolean bool = false;
/*      */       
/* 2344 */       for (byte b = 0; b < param1Int; b++) {
/*      */         
/* 2346 */         char c = this._buf[b];
/*      */         
/* 2348 */         if (isBadChar(c)) {
/*      */           
/* 2350 */           this._buf[b] = '?';
/* 2351 */           c = '?';
/*      */         } 
/*      */         
/* 2354 */         if (c == '>') {
/*      */ 
/*      */           
/* 2357 */           if (bool) {
/* 2358 */             this._buf[b] = ' ';
/*      */           }
/* 2360 */           bool = false;
/*      */         }
/*      */         else {
/*      */           
/* 2364 */           bool = (c == '?') ? true : false;
/*      */         } 
/*      */       } 
/* 2367 */       emit(this._buf, 0, param1Int);
/*      */     } }
/*      */   
/*      */   static final class TextReader extends Reader { private Locale _locale;
/*      */     private Saver.TextSaver _textSaver;
/*      */     private boolean _closed;
/*      */     
/*      */     TextReader(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 2375 */       this._textSaver = new Saver.TextSaver(param1Cur, param1XmlOptions, null);
/* 2376 */       this._locale = param1Cur._locale;
/* 2377 */       this._closed = false;
/*      */     }
/*      */     public void close() throws IOException {
/* 2380 */       this._closed = true;
/*      */     } public boolean ready() throws IOException {
/* 2382 */       return !this._closed;
/*      */     }
/*      */     
/*      */     public int read() throws IOException {
/* 2386 */       checkClosed();
/*      */       
/* 2388 */       if (this._locale.noSync()) { this._locale.enter(); try { return this._textSaver.read(); } finally { this._locale.exit(); }  }
/* 2389 */        synchronized (this._locale) { this._locale.enter(); try { return this._textSaver.read(); } finally { this._locale.exit(); }
/*      */          }
/*      */     
/*      */     }
/*      */     public int read(char[] param1ArrayOfchar) throws IOException {
/* 2394 */       checkClosed();
/*      */       
/* 2396 */       if (this._locale.noSync()) { this._locale.enter(); try { return this._textSaver.read(param1ArrayOfchar, 0, (param1ArrayOfchar == null) ? 0 : param1ArrayOfchar.length); } finally { this._locale.exit(); }  }
/* 2397 */        synchronized (this._locale) { this._locale.enter(); try { return this._textSaver.read(param1ArrayOfchar, 0, (param1ArrayOfchar == null) ? 0 : param1ArrayOfchar.length); } finally { this._locale.exit(); }
/*      */          }
/*      */     
/*      */     }
/*      */     public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 2402 */       checkClosed();
/*      */       
/* 2404 */       if (this._locale.noSync()) { this._locale.enter(); try { return this._textSaver.read(param1ArrayOfchar, param1Int1, param1Int2); } finally { this._locale.exit(); }  }
/* 2405 */        synchronized (this._locale) { this._locale.enter(); try { return this._textSaver.read(param1ArrayOfchar, param1Int1, param1Int2); } finally { this._locale.exit(); }
/*      */          }
/*      */     
/*      */     }
/*      */     private void checkClosed() throws IOException {
/* 2410 */       if (this._closed)
/* 2411 */         throw new IOException("Reader has been closed"); 
/*      */     } }
/*      */   
/*      */   static final class InputStreamSaver extends InputStream {
/*      */     private Locale _locale;
/*      */     private boolean _closed;
/*      */     private OutputStreamImpl _outStreamImpl;
/*      */     private Saver.TextSaver _textSaver;
/*      */     private OutputStreamWriter _converter;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     InputStreamSaver(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 2423 */       this._locale = param1Cur._locale;
/*      */       
/* 2425 */       this._closed = false;
/*      */       
/* 2427 */       assert this._locale.entered();
/*      */       
/* 2429 */       param1XmlOptions = XmlOptions.maskNull(param1XmlOptions);
/*      */       
/* 2431 */       this._outStreamImpl = new OutputStreamImpl();
/*      */       
/* 2433 */       String str1 = null;
/*      */       
/* 2435 */       XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(param1Cur, false);
/*      */       
/* 2437 */       if (xmlDocumentProperties != null && xmlDocumentProperties.getEncoding() != null) {
/* 2438 */         str1 = EncodingMap.getIANA2JavaMapping(xmlDocumentProperties.getEncoding());
/*      */       }
/* 2440 */       if (param1XmlOptions.hasOption("CHARACTER_ENCODING")) {
/* 2441 */         str1 = (String)param1XmlOptions.get("CHARACTER_ENCODING");
/*      */       }
/* 2443 */       if (str1 != null) {
/*      */         
/* 2445 */         String str = EncodingMap.getJava2IANAMapping(str1);
/*      */         
/* 2447 */         if (str != null) {
/* 2448 */           str1 = str;
/*      */         }
/*      */       } 
/* 2451 */       if (str1 == null) {
/* 2452 */         str1 = EncodingMap.getJava2IANAMapping("UTF8");
/*      */       }
/* 2454 */       String str2 = EncodingMap.getIANA2JavaMapping(str1);
/*      */       
/* 2456 */       if (str2 == null) {
/* 2457 */         throw new IllegalStateException("Unknown encoding: " + str1);
/*      */       }
/*      */       
/*      */       try {
/* 2461 */         this._converter = new OutputStreamWriter(this._outStreamImpl, str2);
/*      */       }
/* 2463 */       catch (UnsupportedEncodingException unsupportedEncodingException) {
/*      */         
/* 2465 */         throw new RuntimeException(unsupportedEncodingException);
/*      */       } 
/*      */       
/* 2468 */       this._textSaver = new Saver.TextSaver(param1Cur, param1XmlOptions, str1);
/*      */     }
/*      */ 
/*      */     
/*      */     public void close() throws IOException {
/* 2473 */       this._closed = true;
/*      */     }
/*      */ 
/*      */     
/*      */     private void checkClosed() throws IOException {
/* 2478 */       if (this._closed) {
/* 2479 */         throw new IOException("Stream closed");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int read() throws IOException {
/* 2487 */       checkClosed();
/*      */       
/* 2489 */       if (this._locale.noSync()) { this._locale.enter(); try { return this._outStreamImpl.read(); } finally { this._locale.exit(); }  }
/* 2490 */        synchronized (this._locale) { this._locale.enter(); try { return this._outStreamImpl.read(); } finally { this._locale.exit(); }
/*      */          }
/*      */     
/*      */     }
/*      */     public int read(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 2495 */       checkClosed();
/*      */       
/* 2497 */       if (param1ArrayOfbyte == null) {
/* 2498 */         throw new NullPointerException("buf to read into is null");
/*      */       }
/* 2500 */       if (param1Int1 < 0 || param1Int1 > param1ArrayOfbyte.length) {
/* 2501 */         throw new IndexOutOfBoundsException("Offset is not within buf");
/*      */       }
/* 2503 */       if (this._locale.noSync()) { this._locale.enter(); try { return this._outStreamImpl.read(param1ArrayOfbyte, param1Int1, param1Int2); } finally { this._locale.exit(); }  }
/* 2504 */        synchronized (this._locale) { this._locale.enter(); try { return this._outStreamImpl.read(param1ArrayOfbyte, param1Int1, param1Int2); } finally { this._locale.exit(); }
/*      */          }
/*      */     
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int ensure(int param1Int) {
/* 2513 */       if (param1Int <= 0) {
/* 2514 */         param1Int = 1;
/*      */       }
/* 2516 */       int i = this._outStreamImpl.getAvailable();
/*      */       
/* 2518 */       for (; i < param1Int; 
/* 2519 */         i = this._outStreamImpl.getAvailable()) {
/*      */         
/* 2521 */         if (this._textSaver.write(this._converter, 2048) < 2048) {
/*      */           break;
/*      */         }
/*      */       } 
/* 2525 */       i = this._outStreamImpl.getAvailable();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2530 */       return i;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int available() throws IOException {
/* 2536 */       if (this._locale.noSync()) {
/* 2537 */         this._locale.enter(); 
/* 2538 */         try { return ensure(1024); }
/* 2539 */         finally { this._locale.exit(); }
/*      */       
/* 2541 */       }  synchronized (this._locale) {
/* 2542 */         this._locale.enter(); try { return ensure(1024); } finally { this._locale.exit(); }
/*      */       
/*      */       } 
/*      */     }
/*      */     private final class OutputStreamImpl extends OutputStream { private static final int _initialBufSize = 4096; private int _free; private int _in; private int _out; private byte[] _buf; static final boolean $assertionsDisabled; private final Saver.InputStreamSaver this$0;
/*      */       private OutputStreamImpl() {}
/*      */       int read() {
/* 2549 */         if (Saver.InputStreamSaver.this.ensure(1) == 0) {
/* 2550 */           return -1;
/*      */         }
/* 2552 */         assert getAvailable() > 0;
/*      */         
/* 2554 */         byte b = this._buf[this._out];
/*      */         
/* 2556 */         this._out = (this._out + 1) % this._buf.length;
/* 2557 */         this._free++;
/*      */         
/* 2559 */         return b;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       int read(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
/*      */         int i;
/* 2570 */         if ((i = Saver.InputStreamSaver.this.ensure(param2Int2)) == 0) {
/* 2571 */           return -1;
/*      */         }
/* 2573 */         if (param2ArrayOfbyte == null || param2Int2 <= 0) {
/* 2574 */           return 0;
/*      */         }
/* 2576 */         if (i < param2Int2) {
/* 2577 */           param2Int2 = i;
/*      */         }
/* 2579 */         if (this._out < this._in) {
/*      */           
/* 2581 */           System.arraycopy(this._buf, this._out, param2ArrayOfbyte, param2Int1, param2Int2);
/*      */         }
/*      */         else {
/*      */           
/* 2585 */           int j = this._buf.length - this._out;
/*      */           
/* 2587 */           if (j >= param2Int2) {
/* 2588 */             System.arraycopy(this._buf, this._out, param2ArrayOfbyte, param2Int1, param2Int2);
/*      */           } else {
/*      */             
/* 2591 */             System.arraycopy(this._buf, this._out, param2ArrayOfbyte, param2Int1, j);
/*      */             
/* 2593 */             System.arraycopy(this._buf, 0, param2ArrayOfbyte, param2Int1 + j, param2Int2 - j);
/*      */           } 
/*      */         } 
/*      */         
/* 2597 */         this._out = (this._out + param2Int2) % this._buf.length;
/* 2598 */         this._free += param2Int2;
/*      */ 
/*      */         
/* 2601 */         return param2Int2;
/*      */       }
/*      */ 
/*      */       
/*      */       int getAvailable() {
/* 2606 */         return (this._buf == null) ? 0 : (this._buf.length - this._free);
/*      */       }
/*      */ 
/*      */       
/*      */       public void write(int param2Int) {
/* 2611 */         if (this._free == 0) {
/* 2612 */           resize(1);
/*      */         }
/* 2614 */         assert this._free > 0;
/*      */         
/* 2616 */         this._buf[this._in] = (byte)param2Int;
/*      */         
/* 2618 */         this._in = (this._in + 1) % this._buf.length;
/* 2619 */         this._free--;
/*      */       }
/*      */ 
/*      */       
/*      */       public void write(byte[] param2ArrayOfbyte, int param2Int1, int param2Int2) {
/* 2624 */         assert param2Int2 >= 0;
/*      */         
/* 2626 */         if (param2Int2 == 0) {
/*      */           return;
/*      */         }
/* 2629 */         if (this._free < param2Int2) {
/* 2630 */           resize(param2Int2);
/*      */         }
/* 2632 */         if (this._in == this._out) {
/*      */           
/* 2634 */           assert getAvailable() == 0;
/* 2635 */           assert this._free == this._buf.length - getAvailable();
/* 2636 */           this._in = this._out = 0;
/*      */         } 
/*      */         
/* 2639 */         int i = this._buf.length - this._in;
/*      */         
/* 2641 */         if (this._in <= this._out || param2Int2 < i) {
/*      */           
/* 2643 */           System.arraycopy(param2ArrayOfbyte, param2Int1, this._buf, this._in, param2Int2);
/* 2644 */           this._in += param2Int2;
/*      */         }
/*      */         else {
/*      */           
/* 2648 */           System.arraycopy(param2ArrayOfbyte, param2Int1, this._buf, this._in, i);
/*      */           
/* 2650 */           System.arraycopy(param2ArrayOfbyte, param2Int1 + i, this._buf, 0, param2Int2 - i);
/*      */ 
/*      */           
/* 2653 */           this._in = (this._in + param2Int2) % this._buf.length;
/*      */         } 
/*      */         
/* 2656 */         this._free -= param2Int2;
/*      */       }
/*      */ 
/*      */       
/*      */       void resize(int param2Int) {
/* 2661 */         assert param2Int > this._free : param2Int + " !> " + this._free;
/*      */         
/* 2663 */         int i = (this._buf == null) ? 4096 : (this._buf.length * 2);
/* 2664 */         int j = getAvailable();
/*      */         
/* 2666 */         while (i - j < param2Int) {
/* 2667 */           i *= 2;
/*      */         }
/* 2669 */         byte[] arrayOfByte = new byte[i];
/*      */         
/* 2671 */         if (j > 0) {
/*      */           
/* 2673 */           if (this._in > this._out) {
/* 2674 */             System.arraycopy(this._buf, this._out, arrayOfByte, 0, j);
/*      */           } else {
/*      */             
/* 2677 */             System.arraycopy(this._buf, this._out, arrayOfByte, 0, j - this._in);
/*      */ 
/*      */             
/* 2680 */             System.arraycopy(this._buf, 0, arrayOfByte, j - this._in, this._in);
/*      */           } 
/*      */ 
/*      */           
/* 2684 */           this._out = 0;
/* 2685 */           this._in = j;
/* 2686 */           this._free += arrayOfByte.length - this._buf.length;
/*      */         }
/*      */         else {
/*      */           
/* 2690 */           this._free = arrayOfByte.length;
/* 2691 */           assert this._in == this._out;
/*      */         } 
/*      */         
/* 2694 */         this._buf = arrayOfByte;
/*      */       } }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static final class XmlInputStreamSaver
/*      */     extends Saver
/*      */   {
/*      */     private XmlEventImpl _in;
/*      */ 
/*      */     
/*      */     private XmlEventImpl _out;
/*      */ 
/*      */     
/*      */     static final boolean $assertionsDisabled;
/*      */ 
/*      */ 
/*      */     
/*      */     XmlInputStreamSaver(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 2716 */       super(param1Cur, param1XmlOptions);
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) {
/* 2721 */       assert param1SaveCur.isElem();
/*      */       
/* 2723 */       iterateMappings(); for (; hasMapping(); nextMapping())
/*      */       {
/* 2725 */         enqueue(new StartPrefixMappingImpl(mappingPrefix(), mappingUri()));
/*      */       }
/*      */       
/* 2728 */       StartElementImpl.NormalAttributeImpl normalAttributeImpl1 = null;
/* 2729 */       StartElementImpl.NormalAttributeImpl normalAttributeImpl2 = null;
/* 2730 */       StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl = null;
/*      */       
/* 2732 */       for (byte b1 = 0; b1 < param1ArrayList1.size(); b1++) {
/*      */         
/* 2734 */         XMLName xMLName = computeName(param1ArrayList1.get(b1), this, true);
/* 2735 */         StartElementImpl.NormalAttributeImpl normalAttributeImpl = new StartElementImpl.NormalAttributeImpl(xMLName, param1ArrayList2.get(b1));
/*      */ 
/*      */         
/* 2738 */         if (normalAttributeImpl2 == null) {
/* 2739 */           normalAttributeImpl2 = normalAttributeImpl;
/*      */         } else {
/* 2741 */           normalAttributeImpl1._next = normalAttributeImpl;
/*      */         } 
/* 2743 */         normalAttributeImpl1 = normalAttributeImpl;
/*      */       } 
/*      */       
/* 2746 */       normalAttributeImpl1 = null;
/*      */       
/* 2748 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*      */         
/* 2750 */         String str1 = mappingPrefix();
/* 2751 */         String str2 = mappingUri();
/*      */         
/* 2753 */         StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl2 = new StartElementImpl.XmlnsAttributeImpl(str1, str2);
/*      */ 
/*      */         
/* 2756 */         if (xmlnsAttributeImpl == null) {
/* 2757 */           xmlnsAttributeImpl = xmlnsAttributeImpl2;
/*      */         } else {
/* 2759 */           normalAttributeImpl1._next = xmlnsAttributeImpl2;
/*      */         } 
/* 2761 */         StartElementImpl.XmlnsAttributeImpl xmlnsAttributeImpl1 = xmlnsAttributeImpl2;
/*      */       } 
/*      */ 
/*      */       
/* 2765 */       b b = param1SaveCur.getName();
/* 2766 */       enqueue(new StartElementImpl(computeName(b, this, false), normalAttributeImpl2, xmlnsAttributeImpl, getPrefixMap()));
/*      */       
/* 2768 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) {
/* 2773 */       if (param1SaveCur.isRoot()) {
/* 2774 */         enqueue(new EndDocumentImpl());
/*      */       } else {
/*      */         
/* 2777 */         XMLName xMLName = computeName(param1SaveCur.getName(), this, false);
/* 2778 */         enqueue(new EndElementImpl(xMLName));
/*      */       } 
/*      */       
/* 2781 */       emitEndPrefixMappings();
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) {
/* 2786 */       assert param1SaveCur.isText();
/* 2787 */       Object object = param1SaveCur.getChars();
/* 2788 */       int i = param1SaveCur._cchSrc;
/* 2789 */       int j = param1SaveCur._offSrc;
/*      */       
/* 2791 */       enqueue(new CharacterDataImpl(object, i, j));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) {
/* 2796 */       enqueue(new CommentImpl(param1SaveCur.getChars(), param1SaveCur._cchSrc, param1SaveCur._offSrc));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) {
/* 2801 */       String str = null;
/* 2802 */       b b = param1SaveCur.getName();
/*      */       
/* 2804 */       if (b != null) {
/* 2805 */         str = b.dT();
/*      */       }
/* 2807 */       enqueue(new ProcessingInstructionImpl(str, param1SaveCur.getChars(), param1SaveCur._cchSrc, param1SaveCur._offSrc));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) {
/* 2812 */       enqueue(new StartDocumentImpl(param1String3, null, true, null));
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {
/* 2817 */       emitDocType((String)null, (String)null, (String)null);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {
/* 2822 */       enqueue(new EndDocumentImpl());
/*      */     }
/*      */ 
/*      */     
/*      */     XMLEvent dequeue() {
/* 2827 */       if (this._out == null) {
/*      */         
/* 2829 */         enterLocale();
/*      */         
/*      */         try {
/* 2832 */           if (!process()) {
/* 2833 */             return null;
/*      */           }
/*      */         } finally {
/*      */           
/* 2837 */           exitLocale();
/*      */         } 
/*      */       } 
/*      */       
/* 2841 */       if (this._out == null) {
/* 2842 */         return null;
/*      */       }
/* 2844 */       XmlEventImpl xmlEventImpl = this._out;
/*      */       
/* 2846 */       if ((this._out = this._out._next) == null) {
/* 2847 */         this._in = null;
/*      */       }
/* 2849 */       return (XMLEvent)xmlEventImpl;
/*      */     }
/*      */ 
/*      */     
/*      */     private void enqueue(XmlEventImpl param1XmlEventImpl) {
/* 2854 */       assert param1XmlEventImpl._next == null;
/*      */       
/* 2856 */       if (this._in == null) {
/*      */         
/* 2858 */         assert this._out == null;
/* 2859 */         this._out = this._in = param1XmlEventImpl;
/*      */       }
/*      */       else {
/*      */         
/* 2863 */         this._in._next = param1XmlEventImpl;
/* 2864 */         this._in = param1XmlEventImpl;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitEndPrefixMappings() {
/* 2874 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*      */         
/* 2876 */         String str1 = null;
/* 2877 */         String str2 = mappingPrefix();
/* 2878 */         String str3 = mappingUri();
/*      */         
/* 2880 */         if (str1 == null) {
/* 2881 */           enqueue(new EndPrefixMappingImpl(str2));
/*      */         } else {
/*      */           
/* 2884 */           enqueue(new ChangePrefixMappingImpl(str2, str3, str1));
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static XMLName computeName(b param1b, Saver param1Saver, boolean param1Boolean) {
/* 2895 */       String str1 = param1b.getNamespaceURI();
/* 2896 */       String str2 = param1b.dT();
/*      */       
/* 2898 */       assert str1 != null;
/* 2899 */       assert str2.length() > 0;
/*      */       
/* 2901 */       String str3 = null;
/*      */       
/* 2903 */       if (str1 != null && str1.length() != 0) {
/*      */         
/* 2905 */         str3 = param1b.getPrefix();
/* 2906 */         String str = param1Saver.getNamespaceForPrefix(str3);
/*      */         
/* 2908 */         if (str == null || !str.equals(str1)) {
/* 2909 */           str3 = param1Saver.getUriMapping(str1);
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 2918 */         if (param1Boolean && str3.length() == 0) {
/* 2919 */           str3 = param1Saver.getNonDefaultUriMapping(str1);
/*      */         }
/*      */       } 
/*      */       
/* 2923 */       return (XMLName)new XmlNameImpl(str1, str2, str3);
/*      */     }
/*      */     
/*      */     private static abstract class XmlEventImpl extends XmlEventBase {
/*      */       XmlEventImpl _next;
/*      */       
/*      */       XmlEventImpl(int param2Int) {
/* 2930 */         super(param2Int);
/*      */       }
/*      */ 
/*      */       
/*      */       public XMLName getName() {
/* 2935 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public XMLName getSchemaType() {
/* 2940 */         throw new RuntimeException("NYI");
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasName() {
/* 2945 */         return false;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public final Location getLocation() {
/* 2951 */         return null;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class StartDocumentImpl extends XmlEventImpl implements StartDocument {
/*      */       String _systemID;
/*      */       String _encoding;
/*      */       boolean _standAlone;
/*      */       String _version;
/*      */       
/*      */       StartDocumentImpl(String param2String1, String param2String2, boolean param2Boolean, String param2String3) {
/* 2962 */         super(256);
/* 2963 */         this._systemID = param2String1;
/* 2964 */         this._encoding = param2String2;
/* 2965 */         this._standAlone = param2Boolean;
/* 2966 */         this._version = param2String3;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getSystemId() {
/* 2971 */         return this._systemID;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getCharacterEncodingScheme() {
/* 2976 */         return this._encoding;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean isStandalone() {
/* 2981 */         return this._standAlone;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getVersion() {
/* 2986 */         return this._version;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class StartElementImpl
/*      */       extends XmlEventImpl
/*      */       implements StartElement
/*      */     {
/*      */       private XMLName _name;
/*      */       private Map _prefixMap;
/*      */       private AttributeImpl _attributes;
/*      */       private AttributeImpl _namespaces;
/*      */       
/*      */       StartElementImpl(XMLName param2XMLName, AttributeImpl param2AttributeImpl1, AttributeImpl param2AttributeImpl2, Map param2Map) {
/* 3000 */         super(2);
/*      */         
/* 3002 */         this._name = param2XMLName;
/* 3003 */         this._attributes = param2AttributeImpl1;
/* 3004 */         this._namespaces = param2AttributeImpl2;
/* 3005 */         this._prefixMap = param2Map;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasName() {
/* 3010 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public XMLName getName() {
/* 3015 */         return this._name;
/*      */       }
/*      */ 
/*      */       
/*      */       public AttributeIterator getAttributes() {
/* 3020 */         return new AttributeIteratorImpl(this._attributes, null);
/*      */       }
/*      */ 
/*      */       
/*      */       public AttributeIterator getNamespaces() {
/* 3025 */         return new AttributeIteratorImpl(null, this._namespaces);
/*      */       }
/*      */ 
/*      */       
/*      */       public AttributeIterator getAttributesAndNamespaces() {
/* 3030 */         return new AttributeIteratorImpl(this._attributes, this._namespaces);
/*      */       }
/*      */ 
/*      */       
/*      */       public Attribute getAttributeByName(XMLName param2XMLName) {
/* 3035 */         for (AttributeImpl attributeImpl = this._attributes; attributeImpl != null; attributeImpl = attributeImpl._next) {
/*      */           
/* 3037 */           if (param2XMLName.equals(attributeImpl.getName())) {
/* 3038 */             return attributeImpl;
/*      */           }
/*      */         } 
/* 3041 */         return null;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getNamespaceUri(String param2String) {
/* 3046 */         return (String)this._prefixMap.get((param2String == null) ? "" : param2String);
/*      */       }
/*      */ 
/*      */       
/*      */       public Map getNamespaceMap() {
/* 3051 */         return this._prefixMap;
/*      */       }
/*      */       
/*      */       private static class AttributeIteratorImpl implements AttributeIterator {
/*      */         private Saver.XmlInputStreamSaver.StartElementImpl.AttributeImpl _attributes;
/*      */         private Saver.XmlInputStreamSaver.StartElementImpl.AttributeImpl _namespaces;
/*      */         
/*      */         AttributeIteratorImpl(Saver.XmlInputStreamSaver.StartElementImpl.AttributeImpl param3AttributeImpl1, Saver.XmlInputStreamSaver.StartElementImpl.AttributeImpl param3AttributeImpl2) {
/* 3059 */           this._attributes = param3AttributeImpl1;
/* 3060 */           this._namespaces = param3AttributeImpl2;
/*      */         }
/*      */ 
/*      */         
/*      */         public Object monitor() {
/* 3065 */           return this;
/*      */         }
/*      */ 
/*      */         
/*      */         public Attribute next() {
/* 3070 */           synchronized (monitor()) {
/*      */             
/* 3072 */             checkVersion();
/*      */             
/* 3074 */             Saver.XmlInputStreamSaver.StartElementImpl.AttributeImpl attributeImpl = null;
/*      */             
/* 3076 */             if (this._attributes != null) {
/*      */               
/* 3078 */               attributeImpl = this._attributes;
/* 3079 */               this._attributes = attributeImpl._next;
/*      */             }
/* 3081 */             else if (this._namespaces != null) {
/*      */               
/* 3083 */               attributeImpl = this._namespaces;
/* 3084 */               this._namespaces = attributeImpl._next;
/*      */             } 
/*      */             
/* 3087 */             return attributeImpl;
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public boolean hasNext() {
/* 3093 */           synchronized (monitor()) {
/*      */             
/* 3095 */             checkVersion();
/*      */             
/* 3097 */             return (this._attributes != null || this._namespaces != null);
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public Attribute peek() {
/* 3103 */           synchronized (monitor()) {
/*      */             
/* 3105 */             checkVersion();
/*      */             
/* 3107 */             if (this._attributes != null)
/* 3108 */               return this._attributes; 
/* 3109 */             if (this._namespaces != null) {
/* 3110 */               return this._namespaces;
/*      */             }
/* 3112 */             return null;
/*      */           } 
/*      */         }
/*      */ 
/*      */         
/*      */         public void skip() {
/* 3118 */           synchronized (monitor()) {
/*      */             
/* 3120 */             checkVersion();
/*      */             
/* 3122 */             if (this._attributes != null) {
/* 3123 */               this._attributes = this._attributes._next;
/* 3124 */             } else if (this._namespaces != null) {
/* 3125 */               this._namespaces = this._namespaces._next;
/*      */             } 
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         private final void checkVersion() {}
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       private static abstract class AttributeImpl
/*      */         implements Attribute
/*      */       {
/*      */         AttributeImpl _next;
/*      */ 
/*      */ 
/*      */         
/*      */         protected XMLName _name;
/*      */ 
/*      */ 
/*      */         
/*      */         public XMLName getName() {
/* 3151 */           return this._name;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         public String getType() {
/* 3158 */           return "CDATA";
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*      */         public XMLName getSchemaType() {
/* 3164 */           return null;
/*      */         }
/*      */       }
/*      */ 
/*      */       
/*      */       private static class XmlnsAttributeImpl
/*      */         extends AttributeImpl
/*      */       {
/*      */         private String _uri;
/*      */ 
/*      */         
/*      */         XmlnsAttributeImpl(String param3String1, String param3String2) {
/*      */           String str;
/* 3177 */           this._uri = param3String2;
/*      */ 
/*      */ 
/*      */           
/* 3181 */           if (param3String1.length() == 0) {
/*      */             
/* 3183 */             param3String1 = null;
/* 3184 */             str = "xmlns";
/*      */           }
/*      */           else {
/*      */             
/* 3188 */             str = param3String1;
/* 3189 */             param3String1 = "xmlns";
/*      */           } 
/*      */           
/* 3192 */           this._name = (XMLName)new XmlNameImpl(null, str, param3String1);
/*      */         }
/*      */ 
/*      */         
/*      */         public String getValue() {
/* 3197 */           return this._uri;
/*      */         }
/*      */       }
/*      */       
/*      */       private static class NormalAttributeImpl
/*      */         extends AttributeImpl
/*      */       {
/*      */         private String _value;
/*      */         
/*      */         NormalAttributeImpl(XMLName param3XMLName, String param3String) {
/* 3207 */           this._name = param3XMLName;
/* 3208 */           this._value = param3String;
/*      */         }
/*      */         
/*      */         public String getValue()
/*      */         {
/* 3213 */           return this._value; } } } private static abstract class AttributeImpl implements Attribute { AttributeImpl _next; protected XMLName _name; public XMLName getName() { return this._name; } public String getType() { return "CDATA"; } public XMLName getSchemaType() { return null; } } private static class XmlnsAttributeImpl extends StartElementImpl.AttributeImpl { private String _uri; XmlnsAttributeImpl(String param2String1, String param2String2) { String str; this._uri = param2String2; if (param2String1.length() == 0) { param2String1 = null; str = "xmlns"; } else { str = param2String1; param2String1 = "xmlns"; }  this._name = (XMLName)new XmlNameImpl(null, str, param2String1); } public String getValue() { return this._uri; } } private static class NormalAttributeImpl extends StartElementImpl.AttributeImpl { private String _value; NormalAttributeImpl(XMLName param2XMLName, String param2String) { this._name = param2XMLName; this._value = param2String; } public String getValue() { return this._value; }
/*      */        }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static class StartPrefixMappingImpl
/*      */       extends XmlEventImpl
/*      */       implements StartPrefixMapping
/*      */     {
/*      */       private String _prefix;
/*      */ 
/*      */       
/*      */       private String _uri;
/*      */ 
/*      */ 
/*      */       
/*      */       StartPrefixMappingImpl(String param2String1, String param2String2) {
/* 3231 */         super(1024);
/*      */         
/* 3233 */         this._prefix = param2String1;
/* 3234 */         this._uri = param2String2;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getNamespaceUri() {
/* 3239 */         return this._uri;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getPrefix() {
/* 3244 */         return this._prefix;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class ChangePrefixMappingImpl
/*      */       extends XmlEventImpl implements ChangePrefixMapping {
/*      */       private String _oldUri;
/*      */       private String _newUri;
/*      */       private String _prefix;
/*      */       
/*      */       ChangePrefixMappingImpl(String param2String1, String param2String2, String param2String3) {
/* 3255 */         super(4096);
/*      */         
/* 3257 */         this._oldUri = param2String2;
/* 3258 */         this._newUri = param2String3;
/* 3259 */         this._prefix = param2String1;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getOldNamespaceUri() {
/* 3264 */         return this._oldUri;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getNewNamespaceUri() {
/* 3269 */         return this._newUri;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getPrefix() {
/* 3274 */         return this._prefix;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class EndPrefixMappingImpl
/*      */       extends XmlEventImpl
/*      */       implements EndPrefixMapping
/*      */     {
/*      */       private String _prefix;
/*      */       
/*      */       EndPrefixMappingImpl(String param2String) {
/* 3285 */         super(2048);
/* 3286 */         this._prefix = param2String;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getPrefix() {
/* 3291 */         return this._prefix;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class EndElementImpl
/*      */       extends XmlEventImpl
/*      */       implements EndElement
/*      */     {
/*      */       private XMLName _name;
/*      */       
/*      */       EndElementImpl(XMLName param2XMLName) {
/* 3302 */         super(4);
/*      */         
/* 3304 */         this._name = param2XMLName;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasName() {
/* 3309 */         return true;
/*      */       }
/*      */ 
/*      */       
/*      */       public XMLName getName() {
/* 3314 */         return this._name;
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static class EndDocumentImpl
/*      */       extends XmlEventImpl
/*      */       implements EndDocument
/*      */     {
/*      */       EndDocumentImpl() {
/* 3325 */         super(512);
/*      */       } }
/*      */     
/*      */     private static class TripletEventImpl extends XmlEventImpl implements CharacterData {
/*      */       private Object _obj;
/*      */       private int _cch;
/*      */       private int _off;
/*      */       
/*      */       TripletEventImpl(int param2Int1, Object param2Object, int param2Int2, int param2Int3) {
/* 3334 */         super(param2Int1);
/* 3335 */         this._obj = param2Object;
/* 3336 */         this._cch = param2Int2;
/* 3337 */         this._off = param2Int3;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getContent() {
/* 3342 */         return CharUtil.getString(this._obj, this._off, this._cch);
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean hasContent() {
/* 3347 */         return (this._cch > 0);
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static class CharacterDataImpl
/*      */       extends TripletEventImpl
/*      */       implements CharacterData
/*      */     {
/*      */       CharacterDataImpl(Object param2Object, int param2Int1, int param2Int2) {
/* 3360 */         super(16, param2Object, param2Int1, param2Int2);
/*      */       }
/*      */     }
/*      */     
/*      */     private static class CommentImpl
/*      */       extends TripletEventImpl
/*      */       implements Comment
/*      */     {
/*      */       CommentImpl(Object param2Object, int param2Int1, int param2Int2) {
/* 3369 */         super(32, param2Object, param2Int1, param2Int2);
/*      */       }
/*      */     }
/*      */     
/*      */     private static class ProcessingInstructionImpl
/*      */       extends TripletEventImpl implements ProcessingInstruction {
/*      */       private String _target;
/*      */       
/*      */       ProcessingInstructionImpl(String param2String, Object param2Object, int param2Int1, int param2Int2) {
/* 3378 */         super(8, param2Object, param2Int1, param2Int2);
/* 3379 */         this._target = param2String;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getTarget() {
/* 3384 */         return this._target;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getData() {
/* 3389 */         return getContent();
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static final class XmlInputStreamImpl
/*      */     extends GenericXmlInputStream
/*      */   {
/*      */     private Saver.XmlInputStreamSaver _xmlInputStreamSaver;
/*      */ 
/*      */     
/*      */     XmlInputStreamImpl(Cur param1Cur, XmlOptions param1XmlOptions) {
/* 3402 */       this._xmlInputStreamSaver = new Saver.XmlInputStreamSaver(param1Cur, param1XmlOptions);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 3408 */       this._xmlInputStreamSaver.process();
/*      */     }
/*      */ 
/*      */     
/*      */     protected XMLEvent nextEvent() throws XMLStreamException {
/* 3413 */       return this._xmlInputStreamSaver.dequeue();
/*      */     } }
/*      */   
/*      */   static final class SaxSaver extends Saver { private ContentHandler _contentHandler;
/*      */     private LexicalHandler _lexicalHandler;
/*      */     private AttributesImpl _attributes;
/*      */     private char[] _buf;
/*      */     private boolean _nsAsAttrs;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     SaxSaver(Cur param1Cur, XmlOptions param1XmlOptions, ContentHandler param1ContentHandler, LexicalHandler param1LexicalHandler) throws SAXException {
/* 3424 */       super(param1Cur, param1XmlOptions);
/*      */       
/* 3426 */       this._contentHandler = param1ContentHandler;
/* 3427 */       this._lexicalHandler = param1LexicalHandler;
/*      */       
/* 3429 */       this._attributes = new AttributesImpl();
/* 3430 */       this._nsAsAttrs = !param1XmlOptions.hasOption("SAVE_SAX_NO_NSDECLS_IN_ATTRIBUTES");
/*      */       
/* 3432 */       this._contentHandler.startDocument();
/*      */ 
/*      */       
/*      */       try {
/* 3436 */         while (process());
/*      */       
/*      */       }
/* 3439 */       catch (SaverSAXException saverSAXException) {
/*      */         
/* 3441 */         throw saverSAXException._saxException;
/*      */       } 
/*      */       
/* 3444 */       this._contentHandler.endDocument();
/*      */     }
/*      */     
/*      */     private class SaverSAXException extends RuntimeException { SAXException _saxException;
/*      */       private final Saver.SaxSaver this$0;
/*      */       
/*      */       SaverSAXException(SAXException param2SAXException) {
/* 3451 */         this._saxException = param2SAXException;
/*      */       } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String getPrefixedName(b param1b) {
/* 3459 */       String str1 = param1b.getNamespaceURI();
/* 3460 */       String str2 = param1b.dT();
/*      */       
/* 3462 */       if (str1.length() == 0) {
/* 3463 */         return str2;
/*      */       }
/* 3465 */       String str3 = getUriMapping(str1);
/*      */       
/* 3467 */       if (str3.length() == 0) {
/* 3468 */         return str2;
/*      */       }
/* 3470 */       return str3 + ":" + str2;
/*      */     }
/*      */ 
/*      */     
/*      */     private void emitNamespacesHelper() {
/* 3475 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*      */         
/* 3477 */         String str1 = mappingPrefix();
/* 3478 */         String str2 = mappingUri();
/*      */ 
/*      */         
/*      */         try {
/* 3482 */           this._contentHandler.startPrefixMapping(str1, str2);
/*      */         }
/* 3484 */         catch (SAXException sAXException) {
/*      */           
/* 3486 */           throw new SaverSAXException(sAXException);
/*      */         } 
/*      */         
/* 3489 */         if (this._nsAsAttrs)
/* 3490 */           if (str1 == null || str1.length() == 0) {
/* 3491 */             this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", "xmlns", "xmlns", "CDATA", str2);
/*      */           } else {
/* 3493 */             this._attributes.addAttribute("http://www.w3.org/2000/xmlns/", str1, "xmlns:" + str1, "CDATA", str2);
/*      */           }  
/*      */       } 
/*      */     }
/*      */     
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) {
/* 3499 */       this._attributes.clear();
/*      */       
/* 3501 */       if (saveNamespacesFirst()) {
/* 3502 */         emitNamespacesHelper();
/*      */       }
/* 3504 */       for (byte b1 = 0; b1 < param1ArrayList1.size(); b1++) {
/*      */         
/* 3506 */         b b2 = param1ArrayList1.get(b1);
/*      */         
/* 3508 */         this._attributes.addAttribute(b2.getNamespaceURI(), b2.dT(), getPrefixedName(b2), "CDATA", param1ArrayList2.get(b1));
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 3513 */       if (!saveNamespacesFirst()) {
/* 3514 */         emitNamespacesHelper();
/*      */       }
/* 3516 */       b b = param1SaveCur.getName();
/*      */ 
/*      */       
/*      */       try {
/* 3520 */         this._contentHandler.startElement(b.getNamespaceURI(), b.dT(), getPrefixedName(b), this._attributes);
/*      */ 
/*      */       
/*      */       }
/* 3524 */       catch (SAXException sAXException) {
/*      */         
/* 3526 */         throw new SaverSAXException(sAXException);
/*      */       } 
/*      */       
/* 3529 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) {
/* 3534 */       b b = param1SaveCur.getName();
/*      */ 
/*      */       
/*      */       try {
/* 3538 */         this._contentHandler.endElement(b.getNamespaceURI(), b.dT(), getPrefixedName(b));
/*      */ 
/*      */         
/* 3541 */         iterateMappings(); for (; hasMapping(); nextMapping()) {
/* 3542 */           this._contentHandler.endPrefixMapping(mappingPrefix());
/*      */         }
/* 3544 */       } catch (SAXException sAXException) {
/*      */         
/* 3546 */         throw new SaverSAXException(sAXException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) {
/* 3552 */       assert param1SaveCur.isText();
/*      */       
/* 3554 */       Object object = param1SaveCur.getChars();
/*      */ 
/*      */       
/*      */       try {
/* 3558 */         if (object instanceof char[]) {
/*      */ 
/*      */           
/* 3561 */           this._contentHandler.characters((char[])object, param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*      */         }
/*      */         else {
/*      */           
/* 3565 */           if (this._buf == null) {
/* 3566 */             this._buf = new char[1024];
/*      */           }
/* 3568 */           while (param1SaveCur._cchSrc > 0)
/*      */           {
/* 3570 */             int i = Math.min(this._buf.length, param1SaveCur._cchSrc);
/*      */             
/* 3572 */             CharUtil.getChars(this._buf, 0, object, param1SaveCur._offSrc, i);
/*      */             
/* 3574 */             this._contentHandler.characters(this._buf, 0, i);
/*      */             
/* 3576 */             param1SaveCur._offSrc += i;
/* 3577 */             param1SaveCur._cchSrc -= i;
/*      */           }
/*      */         
/*      */         } 
/* 3581 */       } catch (SAXException sAXException) {
/*      */         
/* 3583 */         throw new SaverSAXException(sAXException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) {
/* 3589 */       if (this._lexicalHandler != null) {
/*      */         
/* 3591 */         param1SaveCur.push();
/*      */         
/* 3593 */         param1SaveCur.next();
/*      */ 
/*      */         
/*      */         try {
/* 3597 */           if (!param1SaveCur.isText()) {
/* 3598 */             this._lexicalHandler.comment(null, 0, 0);
/*      */           } else {
/*      */             
/* 3601 */             Object object = param1SaveCur.getChars();
/*      */             
/* 3603 */             if (object instanceof char[])
/*      */             {
/*      */               
/* 3606 */               this._lexicalHandler.comment((char[])object, param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*      */             }
/*      */             else
/*      */             {
/* 3610 */               if (this._buf == null || this._buf.length < param1SaveCur._cchSrc) {
/* 3611 */                 this._buf = new char[Math.max(1024, param1SaveCur._cchSrc)];
/*      */               }
/* 3613 */               CharUtil.getChars(this._buf, 0, object, param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*      */               
/* 3615 */               this._lexicalHandler.comment(this._buf, 0, param1SaveCur._cchSrc);
/*      */             }
/*      */           
/*      */           } 
/* 3619 */         } catch (SAXException sAXException) {
/*      */           
/* 3621 */           throw new SaverSAXException(sAXException);
/*      */         } 
/*      */         
/* 3624 */         param1SaveCur.pop();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) {
/* 3630 */       String str1 = param1SaveCur.getName().dT();
/*      */       
/* 3632 */       param1SaveCur.push();
/*      */       
/* 3634 */       param1SaveCur.next();
/*      */       
/* 3636 */       String str2 = CharUtil.getString(param1SaveCur.getChars(), param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*      */       
/* 3638 */       param1SaveCur.pop();
/*      */ 
/*      */       
/*      */       try {
/* 3642 */         this._contentHandler.processingInstruction(param1SaveCur.getName().dT(), str2);
/*      */       }
/* 3644 */       catch (SAXException sAXException) {
/*      */         
/* 3646 */         throw new SaverSAXException(sAXException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) {
/* 3652 */       if (this._lexicalHandler != null) {
/*      */         
/*      */         try {
/*      */           
/* 3656 */           this._lexicalHandler.startDTD(param1String1, param1String2, param1String3);
/* 3657 */           this._lexicalHandler.endDTD();
/*      */         }
/* 3659 */         catch (SAXException sAXException) {
/*      */           
/* 3661 */           throw new SaverSAXException(sAXException);
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {}
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {} }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static abstract class SaveCur
/*      */   {
/*      */     int _offSrc;
/*      */ 
/*      */     
/*      */     int _cchSrc;
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean isRoot() {
/* 3689 */       return (kind() == 1);
/* 3690 */     } final boolean isElem() { return (kind() == 2); }
/* 3691 */     final boolean isAttr() { return (kind() == 3); }
/* 3692 */     final boolean isText() { return (kind() == 0); }
/* 3693 */     final boolean isComment() { return (kind() == 4); }
/* 3694 */     final boolean isProcinst() { return (kind() == 5); }
/* 3695 */     final boolean isFinish() { return Cur.kindIsFinish(kind()); }
/* 3696 */     final boolean isContainer() { return Cur.kindIsContainer(kind()); } final boolean isNormalAttr() {
/* 3697 */       return (kind() == 3 && !isXmlns());
/*      */     } final boolean skip() {
/* 3699 */       toEnd(); return next();
/*      */     }
/*      */     abstract void release();
/*      */     abstract int kind();
/*      */     abstract b getName();
/*      */     abstract String getXmlnsPrefix();
/*      */     
/*      */     abstract String getXmlnsUri();
/*      */     
/*      */     abstract boolean isXmlns();
/*      */     
/*      */     abstract boolean hasChildren();
/*      */     
/*      */     abstract boolean hasText();
/*      */     
/*      */     abstract boolean isTextCData();
/*      */     
/*      */     abstract boolean toFirstAttr();
/*      */     
/*      */     abstract boolean toNextAttr();
/*      */     
/*      */     abstract String getAttrValue();
/*      */     
/*      */     abstract boolean next();
/*      */     
/*      */     abstract void toEnd();
/*      */     
/*      */     abstract void push();
/*      */     
/*      */     abstract void pop();
/*      */     
/*      */     abstract Object getChars();
/*      */     
/*      */     abstract List getAncestorNamespaces();
/*      */     
/*      */     abstract XmlDocumentProperties getDocProps(); }
/*      */   
/*      */   private static final class DocSaveCur extends SaveCur { private Cur _cur;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     DocSaveCur(Cur param1Cur) {
/* 3740 */       assert param1Cur.isRoot();
/* 3741 */       this._cur = param1Cur.weakCur(this);
/*      */     }
/*      */ 
/*      */     
/*      */     void release() {
/* 3746 */       this._cur.release();
/* 3747 */       this._cur = null;
/*      */     }
/*      */     int kind() {
/* 3750 */       return this._cur.kind();
/*      */     }
/* 3752 */     b getName() { return this._cur.getName(); }
/* 3753 */     String getXmlnsPrefix() { return this._cur.getXmlnsPrefix(); } String getXmlnsUri() {
/* 3754 */       return this._cur.getXmlnsUri();
/*      */     } boolean isXmlns() {
/* 3756 */       return this._cur.isXmlns();
/*      */     }
/* 3758 */     boolean hasChildren() { return this._cur.hasChildren(); }
/* 3759 */     boolean hasText() { return this._cur.hasText(); } boolean isTextCData() {
/* 3760 */       return this._cur.isTextCData();
/*      */     }
/* 3762 */     boolean toFirstAttr() { return this._cur.toFirstAttr(); }
/* 3763 */     boolean toNextAttr() { return this._cur.toNextAttr(); } String getAttrValue() {
/* 3764 */       assert this._cur.isAttr(); return this._cur.getValueAsString();
/*      */     }
/* 3766 */     void toEnd() { this._cur.toEnd(); } boolean next() {
/* 3767 */       return this._cur.next();
/*      */     }
/* 3769 */     void push() { this._cur.push(); } void pop() {
/* 3770 */       this._cur.pop();
/*      */     } List getAncestorNamespaces() {
/* 3772 */       return null;
/*      */     }
/*      */     
/*      */     Object getChars() {
/* 3776 */       Object object = this._cur.getChars(-1);
/*      */       
/* 3778 */       this._offSrc = this._cur._offSrc;
/* 3779 */       this._cchSrc = this._cur._cchSrc;
/*      */       
/* 3781 */       return object;
/*      */     }
/*      */     XmlDocumentProperties getDocProps() {
/* 3784 */       return Locale.getDocProps(this._cur, false);
/*      */     } }
/*      */ 
/*      */   
/*      */   private static abstract class FilterSaveCur extends SaveCur {
/*      */     private Saver.SaveCur _cur;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     FilterSaveCur(Saver.SaveCur param1SaveCur) {
/* 3793 */       assert param1SaveCur.isRoot();
/* 3794 */       this._cur = param1SaveCur;
/*      */     }
/*      */ 
/*      */     
/*      */     protected abstract boolean filter();
/*      */ 
/*      */     
/*      */     void release() {
/* 3802 */       this._cur.release();
/* 3803 */       this._cur = null;
/*      */     }
/*      */     int kind() {
/* 3806 */       return this._cur.kind();
/*      */     }
/* 3808 */     b getName() { return this._cur.getName(); }
/* 3809 */     String getXmlnsPrefix() { return this._cur.getXmlnsPrefix(); } String getXmlnsUri() {
/* 3810 */       return this._cur.getXmlnsUri();
/*      */     } boolean isXmlns() {
/* 3812 */       return this._cur.isXmlns();
/*      */     }
/* 3814 */     boolean hasChildren() { return this._cur.hasChildren(); }
/* 3815 */     boolean hasText() { return this._cur.hasText(); } boolean isTextCData() {
/* 3816 */       return this._cur.isTextCData();
/*      */     }
/* 3818 */     boolean toFirstAttr() { return this._cur.toFirstAttr(); }
/* 3819 */     boolean toNextAttr() { return this._cur.toNextAttr(); } String getAttrValue() {
/* 3820 */       return this._cur.getAttrValue();
/*      */     } void toEnd() {
/* 3822 */       this._cur.toEnd();
/*      */     }
/*      */     
/*      */     boolean next() {
/* 3826 */       if (!this._cur.next()) {
/* 3827 */         return false;
/*      */       }
/* 3829 */       if (!filter()) {
/* 3830 */         return true;
/*      */       }
/* 3832 */       assert !isRoot() && !isText() && !isAttr();
/*      */       
/* 3834 */       toEnd();
/*      */       
/* 3836 */       return next();
/*      */     }
/*      */     
/* 3839 */     void push() { this._cur.push(); } void pop() {
/* 3840 */       this._cur.pop();
/*      */     } List getAncestorNamespaces() {
/* 3842 */       return this._cur.getAncestorNamespaces();
/*      */     }
/*      */     
/*      */     Object getChars() {
/* 3846 */       Object object = this._cur.getChars();
/*      */       
/* 3848 */       this._offSrc = this._cur._offSrc;
/* 3849 */       this._cchSrc = this._cur._cchSrc;
/*      */       
/* 3851 */       return object;
/*      */     }
/*      */     XmlDocumentProperties getDocProps() {
/* 3854 */       return this._cur.getDocProps();
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class FilterPiSaveCur
/*      */     extends FilterSaveCur {
/*      */     private String _piTarget;
/*      */     
/*      */     FilterPiSaveCur(Saver.SaveCur param1SaveCur, String param1String) {
/* 3863 */       super(param1SaveCur);
/*      */       
/* 3865 */       this._piTarget = param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     protected boolean filter() {
/* 3870 */       return (kind() == 5 && getName().dT().equals(this._piTarget));
/*      */     } }
/*      */   private static final class FragSaveCur extends SaveCur { private Cur _cur; private Cur _end; private ArrayList _ancestorNamespaces; private b _elem; private boolean _saveAttr; private static final int ROOT_START = 1; private static final int ELEM_START = 2; private static final int ROOT_END = 3; private static final int ELEM_END = 4;
/*      */     private static final int CUR = 5;
/*      */     private int _state;
/*      */     private int[] _stateStack;
/*      */     private int _stateStackSize;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     FragSaveCur(Cur param1Cur1, Cur param1Cur2, b param1b) {
/* 3880 */       this._saveAttr = (param1Cur1.isAttr() && param1Cur1.isSamePos(param1Cur2));
/*      */       
/* 3882 */       this._cur = param1Cur1.weakCur(this);
/* 3883 */       this._end = param1Cur2.weakCur(this);
/*      */       
/* 3885 */       this._elem = param1b;
/*      */       
/* 3887 */       this._state = 1;
/*      */       
/* 3889 */       this._stateStack = new int[8];
/*      */       
/* 3891 */       param1Cur1.push();
/* 3892 */       computeAncestorNamespaces(param1Cur1);
/* 3893 */       param1Cur1.pop();
/*      */     }
/*      */ 
/*      */     
/*      */     List getAncestorNamespaces() {
/* 3898 */       return this._ancestorNamespaces;
/*      */     }
/*      */ 
/*      */     
/*      */     private void computeAncestorNamespaces(Cur param1Cur) {
/* 3903 */       this._ancestorNamespaces = new ArrayList();
/*      */       
/* 3905 */       while (param1Cur.toParentRaw()) {
/*      */         
/* 3907 */         if (param1Cur.toFirstAttr()) {
/*      */           
/*      */           do
/*      */           {
/* 3911 */             if (!param1Cur.isXmlns())
/*      */               continue; 
/* 3913 */             String str1 = param1Cur.getXmlnsPrefix();
/* 3914 */             String str2 = param1Cur.getXmlnsUri();
/*      */ 
/*      */ 
/*      */             
/* 3918 */             if (str2.length() <= 0 && str1.length() != 0)
/*      */               continue; 
/* 3920 */             this._ancestorNamespaces.add(param1Cur.getXmlnsPrefix());
/* 3921 */             this._ancestorNamespaces.add(param1Cur.getXmlnsUri());
/*      */ 
/*      */           
/*      */           }
/* 3925 */           while (param1Cur.toNextAttr());
/*      */           
/* 3927 */           param1Cur.toParent();
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void release() {
/* 3938 */       this._cur.release();
/* 3939 */       this._cur = null;
/*      */       
/* 3941 */       this._end.release();
/* 3942 */       this._end = null;
/*      */     }
/*      */ 
/*      */     
/*      */     int kind() {
/* 3947 */       switch (this._state) {
/*      */         case 1:
/* 3949 */           return 1;
/* 3950 */         case 2: return 2;
/* 3951 */         case 4: return -2;
/* 3952 */         case 3: return -1;
/*      */       } 
/*      */       
/* 3955 */       assert this._state == 5;
/*      */       
/* 3957 */       return this._cur.kind();
/*      */     }
/*      */ 
/*      */     
/*      */     b getName() {
/* 3962 */       switch (this._state) {
/*      */         case 1:
/*      */         case 3:
/* 3965 */           return null;
/*      */         case 2: case 4:
/* 3967 */           return this._elem;
/*      */       } 
/*      */       
/* 3970 */       assert this._state == 5;
/*      */       
/* 3972 */       return this._cur.getName();
/*      */     }
/*      */ 
/*      */     
/*      */     String getXmlnsPrefix() {
/* 3977 */       assert this._state == 5 && this._cur.isAttr();
/* 3978 */       return this._cur.getXmlnsPrefix();
/*      */     }
/*      */ 
/*      */     
/*      */     String getXmlnsUri() {
/* 3983 */       assert this._state == 5 && this._cur.isAttr();
/* 3984 */       return this._cur.getXmlnsUri();
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isXmlns() {
/* 3989 */       assert this._state == 5 && this._cur.isAttr();
/* 3990 */       return this._cur.isXmlns();
/*      */     }
/*      */ 
/*      */     
/*      */     boolean hasChildren() {
/* 3995 */       boolean bool = false;
/*      */       
/* 3997 */       if (isContainer()) {
/*      */         
/* 3999 */         push();
/* 4000 */         next();
/*      */         
/* 4002 */         if (!isText() && !isFinish()) {
/* 4003 */           bool = true;
/*      */         }
/* 4005 */         pop();
/*      */       } 
/*      */       
/* 4008 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean hasText() {
/* 4013 */       boolean bool = false;
/*      */       
/* 4015 */       if (isContainer()) {
/*      */         
/* 4017 */         push();
/* 4018 */         next();
/*      */         
/* 4020 */         if (isText()) {
/* 4021 */           bool = true;
/*      */         }
/* 4023 */         pop();
/*      */       } 
/*      */       
/* 4026 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isTextCData() {
/* 4031 */       return this._cur.isTextCData();
/*      */     }
/*      */ 
/*      */     
/*      */     Object getChars() {
/* 4036 */       assert this._state == 5 && this._cur.isText();
/*      */       
/* 4038 */       Object object = this._cur.getChars(-1);
/*      */       
/* 4040 */       this._offSrc = this._cur._offSrc;
/* 4041 */       this._cchSrc = this._cur._cchSrc;
/*      */       
/* 4043 */       return object;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean next() {
/* 4048 */       switch (this._state) {
/*      */ 
/*      */         
/*      */         case 1:
/* 4052 */           this._state = (this._elem == null) ? 5 : 2;
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 2:
/* 4058 */           if (this._saveAttr) {
/* 4059 */             this._state = 4;
/*      */             break;
/*      */           } 
/* 4062 */           if (this._cur.isAttr()) {
/*      */             
/* 4064 */             this._cur.toParent();
/* 4065 */             this._cur.next();
/*      */           } 
/*      */           
/* 4068 */           if (this._cur.isSamePos(this._end)) {
/* 4069 */             this._state = 4; break;
/*      */           } 
/* 4071 */           this._state = 5;
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 5:
/* 4079 */           assert !this._cur.isAttr();
/*      */           
/* 4081 */           this._cur.next();
/*      */           
/* 4083 */           if (this._cur.isSamePos(this._end)) {
/* 4084 */             this._state = (this._elem == null) ? 3 : 4;
/*      */           }
/*      */           break;
/*      */ 
/*      */ 
/*      */         
/*      */         case 4:
/* 4091 */           this._state = 3;
/*      */           break;
/*      */         
/*      */         case 3:
/* 4095 */           return false;
/*      */       } 
/*      */       
/* 4098 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     void toEnd() {
/* 4103 */       switch (this._state) {
/*      */         case 1:
/* 4105 */           this._state = 3; return;
/* 4106 */         case 2: this._state = 4; return;
/*      */         case 3:
/*      */         case 4:
/*      */           return;
/*      */       } 
/* 4111 */       assert this._state == 5 && !this._cur.isAttr() && !this._cur.isText();
/*      */       
/* 4113 */       this._cur.toEnd();
/*      */     }
/*      */ 
/*      */     
/*      */     boolean toFirstAttr() {
/* 4118 */       switch (this._state) {
/*      */         case 1:
/*      */         case 3:
/*      */         case 4:
/* 4122 */           return false;
/* 4123 */         case 5: return this._cur.toFirstAttr();
/*      */       } 
/*      */       
/* 4126 */       assert this._state == 2;
/*      */       
/* 4128 */       if (!this._cur.isAttr()) {
/* 4129 */         return false;
/*      */       }
/* 4131 */       this._state = 5;
/*      */       
/* 4133 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean toNextAttr() {
/* 4138 */       assert this._state == 5;
/* 4139 */       return (!this._saveAttr && this._cur.toNextAttr());
/*      */     }
/*      */ 
/*      */     
/*      */     String getAttrValue() {
/* 4144 */       assert this._state == 5 && this._cur.isAttr();
/* 4145 */       return this._cur.getValueAsString();
/*      */     }
/*      */ 
/*      */     
/*      */     void push() {
/* 4150 */       if (this._stateStackSize == this._stateStack.length) {
/*      */         
/* 4152 */         int[] arrayOfInt = new int[this._stateStackSize * 2];
/* 4153 */         System.arraycopy(this._stateStack, 0, arrayOfInt, 0, this._stateStackSize);
/* 4154 */         this._stateStack = arrayOfInt;
/*      */       } 
/*      */       
/* 4157 */       this._stateStack[this._stateStackSize++] = this._state;
/* 4158 */       this._cur.push();
/*      */     }
/*      */ 
/*      */     
/*      */     void pop() {
/* 4163 */       this._cur.pop();
/* 4164 */       this._state = this._stateStack[--this._stateStackSize];
/*      */     }
/*      */     XmlDocumentProperties getDocProps() {
/* 4167 */       return Locale.getDocProps(this._cur, false);
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
/*      */   private static final class PrettySaveCur
/*      */     extends SaveCur
/*      */   {
/*      */     private Saver.SaveCur _cur;
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
/*      */     private int _prettyIndent;
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
/*      */     private int _prettyOffset;
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
/*      */     private String _txt;
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
/*      */     private StringBuffer _sb;
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
/*      */     private int _depth;
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
/*      */     private ArrayList _stack;
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
/*      */     private boolean _isTextCData;
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
/*      */     private boolean _useCDataBookmarks;
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
/*      */     static final boolean $assertionsDisabled;
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
/*      */     PrettySaveCur(Saver.SaveCur param1SaveCur, XmlOptions param1XmlOptions) {
/* 4398 */       this._isTextCData = false;
/* 4399 */       this._useCDataBookmarks = false; this._sb = new StringBuffer(); this._stack = new ArrayList(); this._cur = param1SaveCur; assert param1XmlOptions != null; this._prettyIndent = 2; if (param1XmlOptions.hasOption("SAVE_PRETTY_PRINT_INDENT"))
/*      */         this._prettyIndent = ((Integer)param1XmlOptions.get("SAVE_PRETTY_PRINT_INDENT")).intValue();  if (param1XmlOptions.hasOption("SAVE_PRETTY_PRINT_OFFSET"))
/*      */         this._prettyOffset = ((Integer)param1XmlOptions.get("SAVE_PRETTY_PRINT_OFFSET")).intValue();  if (param1XmlOptions.hasOption("LOAD_SAVE_CDATA_BOOKMARKS"))
/*      */         this._useCDataBookmarks = true; 
/*      */     } List getAncestorNamespaces() { return this._cur.getAncestorNamespaces(); }
/*      */     void release() { this._cur.release(); }
/*      */     int kind() { return (this._txt == null) ? this._cur.kind() : 0; }
/*      */     b getName() { assert this._txt == null; return this._cur.getName(); }
/*      */     String getXmlnsPrefix() { assert this._txt == null; return this._cur.getXmlnsPrefix(); }
/*      */     String getXmlnsUri() { assert this._txt == null; return this._cur.getXmlnsUri(); }
/*      */     boolean isXmlns() { return (this._txt == null) ? this._cur.isXmlns() : false; }
/*      */     boolean hasChildren() { return (this._txt == null) ? this._cur.hasChildren() : false; }
/*      */     boolean hasText() { return (this._txt == null) ? this._cur.hasText() : false; }
/*      */     boolean isTextCData() { return (this._txt == null) ? ((this._useCDataBookmarks && this._cur.isTextCData())) : this._isTextCData; }
/*      */     boolean toFirstAttr() { assert this._txt == null; return this._cur.toFirstAttr(); }
/*      */     boolean toNextAttr() { assert this._txt == null; return this._cur.toNextAttr(); }
/*      */     String getAttrValue() { assert this._txt == null; return this._cur.getAttrValue(); }
/*      */     void toEnd() { assert this._txt == null; this._cur.toEnd(); if (this._cur.kind() == -2)
/*      */         this._depth--;  }
/*      */     boolean next() { int i; if (this._txt != null) { assert this._txt.length() > 0; assert !this._cur.isText(); this._txt = null; this._isTextCData = false; i = this._cur.kind(); } else { int j = i = this._cur.kind(); if (!this._cur.next())
/*      */           return false;  this._sb.delete(0, this._sb.length()); assert this._txt == null; if (this._cur.isText()) { this._isTextCData = (this._useCDataBookmarks && this._cur.isTextCData()); CharUtil.getString(this._sb, this._cur.getChars(), this._cur._offSrc, this._cur._cchSrc); this._cur.next(); trim(this._sb); }  i = this._cur.kind(); if (this._prettyIndent >= 0 && j != 4 && j != 5 && (j != 2 || i != -2)) { if (this._sb.length() > 0) { this._sb.insert(0, Saver._newLine); spaces(this._sb, Saver._newLine.length(), this._prettyOffset + this._prettyIndent * this._depth); }  if (i != -1) { if (j != 1)
/*      */               this._sb.append(Saver._newLine);  int k = (i < 0) ? (this._depth - 1) : this._depth; spaces(this._sb, this._sb.length(), this._prettyOffset + this._prettyIndent * k); }  }  if (this._sb.length() > 0) { this._txt = this._sb.toString(); i = 0; }  }  if (i == 2) { this._depth++; } else if (i == -2) { this._depth--; }  return true; }
/*      */     void push() { this._cur.push(); this._stack.add(this._txt); this._stack.add(new Integer(this._depth)); this._isTextCData = false; }
/*      */     void pop() { this._cur.pop(); this._depth = ((Integer)this._stack.remove(this._stack.size() - 1)).intValue(); this._txt = this._stack.remove(this._stack.size() - 1); this._isTextCData = false; }
/*      */     Object getChars() { if (this._txt != null) { this._offSrc = 0; this._cchSrc = this._txt.length(); return this._txt; }
/*      */        Object object = this._cur.getChars(); this._offSrc = this._cur._offSrc; this._cchSrc = this._cur._cchSrc; return object; }
/*      */     XmlDocumentProperties getDocProps() { return this._cur.getDocProps(); }
/*      */     static void spaces(StringBuffer param1StringBuffer, int param1Int1, int param1Int2) { while (param1Int2-- > 0)
/*      */         param1StringBuffer.insert(param1Int1, ' ');  }
/* 4428 */     static void trim(StringBuffer param1StringBuffer) { int i; for (i = 0; i < param1StringBuffer.length() && CharUtil.isWhiteSpace(param1StringBuffer.charAt(i)); i++); param1StringBuffer.delete(0, i); for (i = param1StringBuffer.length(); i > 0 && CharUtil.isWhiteSpace(param1StringBuffer.charAt(i - 1)); i--); param1StringBuffer.delete(i, param1StringBuffer.length()); } } static final String _newLine = (SystemProperties.getProperty("line.separator") == null) ? "\n" : SystemProperties.getProperty("line.separator");
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   protected abstract boolean emitElement(SaveCur paramSaveCur, ArrayList paramArrayList1, ArrayList paramArrayList2);
/*      */   
/*      */   protected abstract void emitFinish(SaveCur paramSaveCur);
/*      */   
/*      */   protected abstract void emitText(SaveCur paramSaveCur);
/*      */   
/*      */   protected abstract void emitComment(SaveCur paramSaveCur);
/*      */   
/*      */   protected abstract void emitProcinst(SaveCur paramSaveCur);
/*      */   
/*      */   protected abstract void emitDocType(String paramString1, String paramString2, String paramString3);
/*      */   
/*      */   protected abstract void emitStartDoc(SaveCur paramSaveCur);
/*      */   
/*      */   protected abstract void emitEndDoc(SaveCur paramSaveCur);
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Saver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */