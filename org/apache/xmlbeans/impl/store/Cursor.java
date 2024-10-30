/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.PrintStream;
/*      */ import java.io.Reader;
/*      */ import java.io.Writer;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlDocumentProperties;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.GlobalLock;
/*      */ import org.apache.xmlbeans.impl.common.XMLChar;
/*      */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*      */ import org.w3c.dom.Node;
/*      */ import org.xml.sax.ContentHandler;
/*      */ import org.xml.sax.SAXException;
/*      */ import org.xml.sax.ext.LexicalHandler;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Cursor
/*      */   implements XmlCursor, Locale.ChangeListener
/*      */ {
/*      */   static final int ROOT = 1;
/*      */   static final int ELEM = 2;
/*      */   static final int ATTR = 3;
/*      */   static final int COMMENT = 4;
/*      */   static final int PROCINST = 5;
/*      */   static final int TEXT = 0;
/*      */   private static final int MOVE_XML = 0;
/*      */   private static final int COPY_XML = 1;
/*      */   private static final int MOVE_XML_CONTENTS = 2;
/*      */   private static final int COPY_XML_CONTENTS = 3;
/*      */   private static final int MOVE_CHARS = 4;
/*      */   private static final int COPY_CHARS = 5;
/*      */   private Cur _cur;
/*      */   private Path.PathEngine _pathEngine;
/*      */   private int _currentSelection;
/*      */   private Locale.ChangeListener _nextChangeListener;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   Cursor(Xobj paramXobj, int paramInt) {
/*   68 */     this._cur = paramXobj._locale.weakCur(this);
/*   69 */     this._cur.moveTo(paramXobj, paramInt);
/*   70 */     this._currentSelection = -1;
/*      */   }
/*      */   
/*      */   Cursor(Cur paramCur) {
/*   74 */     this(paramCur._xobj, paramCur._pos);
/*      */   }
/*      */   
/*      */   private static boolean isValid(Cur paramCur) {
/*   78 */     if (paramCur.kind() <= 0) {
/*   79 */       paramCur.push();
/*      */       
/*   81 */       if (paramCur.toParentRaw()) {
/*   82 */         int i = paramCur.kind();
/*      */         
/*   84 */         if (i == 4 || i == 5 || i == 3) {
/*   85 */           return false;
/*      */         }
/*      */       } 
/*   88 */       paramCur.pop();
/*      */     } 
/*      */     
/*   91 */     return true;
/*      */   }
/*      */   
/*      */   private boolean isValid() {
/*   95 */     return isValid(this._cur);
/*      */   }
/*      */   
/*      */   Locale locale() {
/*   99 */     return this._cur._locale;
/*      */   }
/*      */   
/*      */   Cur tempCur() {
/*  103 */     return this._cur.tempCur();
/*      */   }
/*      */   
/*      */   public void dump(PrintStream paramPrintStream) {
/*  107 */     this._cur.dump(paramPrintStream);
/*      */   }
/*      */   
/*      */   static void validateLocalName(b paramb) {
/*  111 */     if (paramb == null) {
/*  112 */       throw new IllegalArgumentException("QName is null");
/*      */     }
/*  114 */     validateLocalName(paramb.dT());
/*      */   }
/*      */   
/*      */   static void validateLocalName(String paramString) {
/*  118 */     if (paramString == null) {
/*  119 */       throw new IllegalArgumentException("Name is null");
/*      */     }
/*  121 */     if (paramString.length() == 0) {
/*  122 */       throw new IllegalArgumentException("Name is empty");
/*      */     }
/*  124 */     if (!XMLChar.isValidNCName(paramString))
/*  125 */       throw new IllegalArgumentException("Name is not valid"); 
/*      */   }
/*      */   
/*      */   static void validatePrefix(String paramString) {
/*  129 */     if (paramString == null) {
/*  130 */       throw new IllegalArgumentException("Prefix is null");
/*      */     }
/*  132 */     if (paramString.length() == 0) {
/*  133 */       throw new IllegalArgumentException("Prefix is empty");
/*      */     }
/*  135 */     if (Locale.beginsWithXml(paramString)) {
/*  136 */       throw new IllegalArgumentException("Prefix begins with 'xml'");
/*      */     }
/*  138 */     if (!XMLChar.isValidNCName(paramString))
/*  139 */       throw new IllegalArgumentException("Prefix is not valid"); 
/*      */   }
/*      */   
/*      */   private static void complain(String paramString) {
/*  143 */     throw new IllegalArgumentException(paramString);
/*      */   }
/*      */   
/*      */   private void checkInsertionValidity(Cur paramCur) {
/*  147 */     int i = paramCur.kind();
/*      */     
/*  149 */     if (i < 0) {
/*  150 */       complain("Can't move/copy/insert an end token.");
/*      */     }
/*  152 */     if (i == 1) {
/*  153 */       complain("Can't move/copy/insert a whole document.");
/*      */     }
/*  155 */     int j = this._cur.kind();
/*      */     
/*  157 */     if (j == 1) {
/*  158 */       complain("Can't insert before the start of the document.");
/*      */     }
/*  160 */     if (i == 3) {
/*  161 */       this._cur.push();
/*  162 */       this._cur.prevWithAttrs();
/*  163 */       int k = this._cur.kind();
/*  164 */       this._cur.pop();
/*      */       
/*  166 */       if (k != 2 && k != 1 && k != -3) {
/*  167 */         complain("Can only insert attributes before other attributes or after containers.");
/*      */       }
/*      */     } 
/*      */     
/*  171 */     if (j == 3 && i != 3)
/*  172 */       complain("Can only insert attributes before other attributes or after containers."); 
/*      */   }
/*      */   
/*      */   private void insertNode(Cur paramCur, String paramString) {
/*  176 */     assert !paramCur.isRoot();
/*  177 */     assert paramCur.isNode();
/*  178 */     assert isValid(paramCur);
/*  179 */     assert isValid();
/*      */     
/*  181 */     if (paramString != null && paramString.length() > 0) {
/*  182 */       paramCur.next();
/*  183 */       paramCur.insertString(paramString);
/*  184 */       paramCur.toParent();
/*      */     } 
/*      */     
/*  187 */     checkInsertionValidity(paramCur);
/*      */     
/*  189 */     paramCur.moveNode(this._cur);
/*      */     
/*  191 */     this._cur.toEnd();
/*  192 */     this._cur.nextWithAttrs();
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
/*      */   public void _dispose() {
/*  205 */     this._cur.release();
/*  206 */     this._cur = null;
/*      */   }
/*      */   
/*      */   public XmlCursor _newCursor() {
/*  210 */     return new Cursor(this._cur);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public b _getName() {
/*  216 */     switch (this._cur.kind()) {
/*      */       
/*      */       case 3:
/*  219 */         if (this._cur.isXmlns()) {
/*  220 */           return this._cur._locale.makeQNameNoCheck(this._cur.getXmlnsUri(), this._cur.getXmlnsPrefix());
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       case 2:
/*      */       case 5:
/*  228 */         return this._cur.getName();
/*      */     } 
/*      */     
/*  231 */     return null;
/*      */   }
/*      */   
/*      */   public void _setName(b paramb) {
/*  235 */     if (paramb == null) {
/*  236 */       throw new IllegalArgumentException("Name is null");
/*      */     }
/*  238 */     switch (this._cur.kind()) {
/*      */       
/*      */       case 2:
/*      */       case 3:
/*  242 */         validateLocalName(paramb.dT());
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 5:
/*  248 */         validatePrefix(paramb.dT());
/*      */         
/*  250 */         if (paramb.getNamespaceURI().length() > 0) {
/*  251 */           throw new IllegalArgumentException("Procinst name must have no URI");
/*      */         }
/*  253 */         if (paramb.getPrefix().length() > 0) {
/*  254 */           throw new IllegalArgumentException("Procinst name must have no prefix");
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       default:
/*  260 */         throw new IllegalStateException("Can set name on element, atrtribute and procinst only");
/*      */     } 
/*      */ 
/*      */     
/*  264 */     this._cur.setName(paramb);
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _currentTokenType() {
/*  268 */     assert isValid();
/*      */     
/*  270 */     switch (this._cur.kind()) {
/*      */       case 1:
/*  272 */         return XmlCursor.TokenType.STARTDOC;
/*      */       case -1:
/*  274 */         return XmlCursor.TokenType.ENDDOC;
/*      */       case 2:
/*  276 */         return XmlCursor.TokenType.START;
/*      */       case -2:
/*  278 */         return XmlCursor.TokenType.END;
/*      */       case 0:
/*  280 */         return XmlCursor.TokenType.TEXT;
/*      */       case 3:
/*  282 */         return this._cur.isXmlns() ? XmlCursor.TokenType.NAMESPACE : XmlCursor.TokenType.ATTR;
/*      */       case 4:
/*  284 */         return XmlCursor.TokenType.COMMENT;
/*      */       case 5:
/*  286 */         return XmlCursor.TokenType.PROCINST;
/*      */     } 
/*      */     
/*  289 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean _isStartdoc() {
/*  295 */     assert isValid();
/*  296 */     return this._cur.isRoot();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isEnddoc() {
/*  301 */     assert isValid();
/*  302 */     return this._cur.isEndRoot();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isStart() {
/*  307 */     assert isValid();
/*  308 */     return this._cur.isElem();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isEnd() {
/*  313 */     assert isValid();
/*  314 */     return this._cur.isEnd();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isText() {
/*  319 */     assert isValid();
/*  320 */     return this._cur.isText();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isAttr() {
/*  325 */     assert isValid();
/*  326 */     return this._cur.isNormalAttr();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isNamespace() {
/*  331 */     assert isValid();
/*  332 */     return this._cur.isXmlns();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isComment() {
/*  337 */     assert isValid();
/*  338 */     return this._cur.isComment();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isProcinst() {
/*  343 */     assert isValid();
/*  344 */     return this._cur.isProcinst();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isContainer() {
/*  349 */     assert isValid();
/*  350 */     return this._cur.isContainer();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isFinish() {
/*  355 */     assert isValid();
/*  356 */     return this._cur.isFinish();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _isAnyAttr() {
/*  361 */     assert isValid();
/*  362 */     return this._cur.isAttr();
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _toNextToken() {
/*  366 */     assert isValid();
/*      */     
/*  368 */     switch (this._cur.kind())
/*      */     
/*      */     { case 1:
/*      */       case 2:
/*  372 */         if (!this._cur.toFirstAttr()) {
/*  373 */           this._cur.next();
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
/*  404 */         return _currentTokenType();case 3: if (!this._cur.toNextSibling()) { this._cur.toParent(); this._cur.next(); }  return _currentTokenType();case 4: case 5: this._cur.skip(); return _currentTokenType(); }  if (!this._cur.next()) return XmlCursor.TokenType.NONE;  return _currentTokenType();
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _toPrevToken() {
/*  408 */     assert isValid();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  416 */     boolean bool = this._cur.isText();
/*      */     
/*  418 */     if (!this._cur.prev()) {
/*  419 */       assert this._cur.isRoot() || this._cur.isAttr();
/*      */       
/*  421 */       if (this._cur.isRoot()) {
/*  422 */         return XmlCursor.TokenType.NONE;
/*      */       }
/*  424 */       this._cur.toParent();
/*      */     } else {
/*  426 */       int i = this._cur.kind();
/*      */       
/*  428 */       if (i < 0 && (i == -4 || i == -5 || i == -3)) {
/*  429 */         this._cur.toParent();
/*  430 */       } else if (this._cur.isContainer()) {
/*  431 */         this._cur.toLastAttr();
/*  432 */       } else if (bool && this._cur.isText()) {
/*  433 */         return _toPrevToken();
/*      */       } 
/*      */     } 
/*  436 */     return _currentTokenType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object _monitor() {
/*  443 */     return this._cur._locale;
/*      */   }
/*      */   
/*      */   public boolean _toParent() {
/*  447 */     Cur cur = this._cur.tempCur();
/*      */     
/*  449 */     if (!cur.toParent()) {
/*  450 */       return false;
/*      */     }
/*  452 */     this._cur.moveToCur(cur);
/*      */     
/*  454 */     cur.release();
/*      */     
/*  456 */     return true;
/*      */   }
/*      */   private static final class ChangeStampImpl implements XmlCursor.ChangeStamp { private final Locale _locale; private final long _versionStamp;
/*      */     
/*      */     ChangeStampImpl(Locale param1Locale) {
/*  461 */       this._locale = param1Locale;
/*  462 */       this._versionStamp = this._locale.version();
/*      */     }
/*      */     
/*      */     public boolean hasChanged() {
/*  466 */       return (this._versionStamp != this._locale.version());
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlCursor.ChangeStamp _getDocChangeStamp() {
/*  474 */     return new ChangeStampImpl(this._cur._locale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XMLInputStream _newXMLInputStream() {
/*  485 */     return _newXMLInputStream(null);
/*      */   }
/*      */   
/*      */   public XMLStreamReader _newXMLStreamReader() {
/*  489 */     return _newXMLStreamReader(null);
/*      */   }
/*      */   
/*      */   public Node _newDomNode() {
/*  493 */     return _newDomNode(null);
/*      */   }
/*      */   
/*      */   public InputStream _newInputStream() {
/*  497 */     return _newInputStream(null);
/*      */   }
/*      */   
/*      */   public String _xmlText() {
/*  501 */     return _xmlText(null);
/*      */   }
/*      */   
/*      */   public Reader _newReader() {
/*  505 */     return _newReader(null);
/*      */   }
/*      */   
/*      */   public void _save(File paramFile) throws IOException {
/*  509 */     _save(paramFile, (XmlOptions)null);
/*      */   }
/*      */   
/*      */   public void _save(OutputStream paramOutputStream) throws IOException {
/*  513 */     _save(paramOutputStream, (XmlOptions)null);
/*      */   }
/*      */   
/*      */   public void _save(Writer paramWriter) throws IOException {
/*  517 */     _save(paramWriter, (XmlOptions)null);
/*      */   }
/*      */   
/*      */   public void _save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler) throws SAXException {
/*  521 */     _save(paramContentHandler, paramLexicalHandler, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlDocumentProperties _documentProperties() {
/*  529 */     return Locale.getDocProps(this._cur, true);
/*      */   }
/*      */   
/*      */   public XMLStreamReader _newXMLStreamReader(XmlOptions paramXmlOptions) {
/*  533 */     return Jsr173.newXmlStreamReader(this._cur, paramXmlOptions);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XMLInputStream _newXMLInputStream(XmlOptions paramXmlOptions) {
/*  540 */     return (XMLInputStream)new Saver.XmlInputStreamImpl(this._cur, paramXmlOptions);
/*      */   }
/*      */   
/*      */   public String _xmlText(XmlOptions paramXmlOptions) {
/*  544 */     assert isValid();
/*      */     
/*  546 */     return (new Saver.TextSaver(this._cur, paramXmlOptions, null)).saveToString();
/*      */   }
/*      */   
/*      */   public InputStream _newInputStream(XmlOptions paramXmlOptions) {
/*  550 */     return new Saver.InputStreamSaver(this._cur, paramXmlOptions);
/*      */   }
/*      */   
/*      */   public Reader _newReader(XmlOptions paramXmlOptions) {
/*  554 */     return new Saver.TextReader(this._cur, paramXmlOptions);
/*      */   }
/*      */ 
/*      */   
/*      */   public void _save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler, XmlOptions paramXmlOptions) throws SAXException {
/*  559 */     new Saver.SaxSaver(this._cur, paramXmlOptions, paramContentHandler, paramLexicalHandler);
/*      */   }
/*      */   
/*      */   public void _save(File paramFile, XmlOptions paramXmlOptions) throws IOException {
/*  563 */     if (paramFile == null) {
/*  564 */       throw new IllegalArgumentException("Null file specified");
/*      */     }
/*  566 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/*      */     
/*      */     try {
/*  569 */       _save(fileOutputStream, paramXmlOptions);
/*      */     } finally {
/*  571 */       fileOutputStream.close();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void _save(OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException {
/*  576 */     if (paramOutputStream == null) {
/*  577 */       throw new IllegalArgumentException("Null OutputStream specified");
/*      */     }
/*  579 */     InputStream inputStream = _newInputStream(paramXmlOptions);
/*      */     
/*      */     try {
/*  582 */       byte[] arrayOfByte = new byte[8192];
/*      */       
/*      */       while (true) {
/*  585 */         int i = inputStream.read(arrayOfByte);
/*      */         
/*  587 */         if (i < 0) {
/*      */           break;
/*      */         }
/*  590 */         paramOutputStream.write(arrayOfByte, 0, i);
/*      */       } 
/*      */     } finally {
/*  593 */       inputStream.close();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void _save(Writer paramWriter, XmlOptions paramXmlOptions) throws IOException {
/*  598 */     if (paramWriter == null) {
/*  599 */       throw new IllegalArgumentException("Null Writer specified");
/*      */     }
/*  601 */     if (paramXmlOptions != null && paramXmlOptions.hasOption("SAVE_OPTIMIZE_FOR_SPEED")) {
/*      */       
/*  603 */       Saver.OptimizedForSpeedSaver.save(this._cur, paramWriter);
/*      */       
/*      */       return;
/*      */     } 
/*  607 */     Reader reader = _newReader(paramXmlOptions);
/*      */     
/*      */     try {
/*  610 */       char[] arrayOfChar = new char[8192];
/*      */       
/*      */       while (true) {
/*  613 */         int i = reader.read(arrayOfChar);
/*      */         
/*  615 */         if (i < 0) {
/*      */           break;
/*      */         }
/*  618 */         paramWriter.write(arrayOfChar, 0, i);
/*      */       } 
/*      */     } finally {
/*  621 */       reader.close();
/*      */     } 
/*      */   }
/*      */   
/*      */   public Node _getDomNode() {
/*  626 */     return (Node)this._cur.getDom();
/*      */   }
/*      */   
/*      */   private boolean isDomFragment() {
/*  630 */     if (!isStartdoc()) {
/*  631 */       return true;
/*      */     }
/*  633 */     boolean bool = false;
/*      */     
/*  635 */     XmlCursor xmlCursor = newCursor();
/*  636 */     int i = xmlCursor.toNextToken().intValue();
/*      */ 
/*      */     
/*      */     try { while (true)
/*  640 */       { switch (i) {
/*      */           case 3:
/*  642 */             if (bool)
/*  643 */               return true; 
/*  644 */             bool = true;
/*  645 */             i = xmlCursor.toEndToken().intValue();
/*      */             continue;
/*      */           
/*      */           case 5:
/*  649 */             if (!Locale.isWhiteSpace(xmlCursor.getChars()))
/*  650 */               return true; 
/*  651 */             i = xmlCursor.toNextToken().intValue();
/*      */             continue;
/*      */           
/*      */           case 0:
/*      */           case 2:
/*      */             break;
/*      */           
/*      */           case 6:
/*      */           case 7:
/*  660 */             return true;
/*      */           
/*      */           case 4:
/*      */           case 8:
/*      */           case 9:
/*  665 */             i = xmlCursor.toNextToken().intValue();
/*      */             continue;
/*      */           
/*      */           case 1:
/*      */             assert false;
/*      */             break;
/*      */           default:
/*      */             continue;
/*      */         } 
/*  674 */         xmlCursor.dispose(); }  } finally { xmlCursor.dispose(); }
/*      */ 
/*      */     
/*  677 */     return !bool;
/*      */   }
/*      */   private static final class DomSaver extends Saver { private Cur _nodeCur; private SchemaType _type; private SchemaTypeLoader _stl;
/*      */     
/*      */     DomSaver(Cur param1Cur, boolean param1Boolean, XmlOptions param1XmlOptions) {
/*  682 */       super(param1Cur, param1XmlOptions);
/*      */       
/*  684 */       if (param1Cur.isUserNode()) {
/*  685 */         this._type = param1Cur.getUser().get_schema_type();
/*      */       }
/*  687 */       this._stl = param1Cur._locale._schemaTypeLoader;
/*  688 */       this._options = param1XmlOptions;
/*  689 */       this._isFrag = param1Boolean;
/*      */     }
/*      */     private XmlOptions _options; private boolean _isFrag; static final boolean $assertionsDisabled;
/*      */     Node saveDom() {
/*  693 */       Locale locale = Locale.getLocale(this._stl, this._options);
/*      */       
/*  695 */       locale.enter();
/*      */       
/*      */       try {
/*  698 */         this._nodeCur = locale.getCur();
/*      */ 
/*      */ 
/*      */         
/*  702 */         while (process());
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  707 */         while (!this._nodeCur.isRoot()) {
/*  708 */           this._nodeCur.toParent();
/*      */         }
/*  710 */         if (this._type != null) {
/*  711 */           this._nodeCur.setType(this._type);
/*      */         }
/*  713 */         Node node = (Node)this._nodeCur.getDom();
/*      */         
/*  715 */         this._nodeCur.release();
/*      */         
/*  717 */         this._nodeCur = null;
/*      */         
/*  719 */         return node;
/*      */       } finally {
/*  721 */         locale.exit();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected boolean emitElement(Saver.SaveCur param1SaveCur, ArrayList param1ArrayList1, ArrayList param1ArrayList2) {
/*  730 */       if (Locale.isFragmentQName(param1SaveCur.getName())) {
/*  731 */         this._nodeCur.moveTo(null, -2);
/*      */       }
/*  733 */       ensureDoc();
/*      */       
/*  735 */       this._nodeCur.createElement(getQualifiedName(param1SaveCur, param1SaveCur.getName()));
/*  736 */       this._nodeCur.next();
/*      */       
/*  738 */       iterateMappings(); for (; hasMapping(); nextMapping()) {
/*  739 */         this._nodeCur.createAttr(this._nodeCur._locale.createXmlns(mappingPrefix()));
/*  740 */         this._nodeCur.next();
/*  741 */         this._nodeCur.insertString(mappingUri());
/*  742 */         this._nodeCur.toParent();
/*  743 */         this._nodeCur.skipWithAttrs();
/*      */       } 
/*      */       
/*  746 */       for (byte b = 0; b < param1ArrayList1.size(); b++) {
/*  747 */         this._nodeCur.createAttr(getQualifiedName(param1SaveCur, param1ArrayList1.get(b)));
/*  748 */         this._nodeCur.next();
/*  749 */         this._nodeCur.insertString(param1ArrayList2.get(b));
/*  750 */         this._nodeCur.toParent();
/*  751 */         this._nodeCur.skipWithAttrs();
/*      */       } 
/*      */       
/*  754 */       return false;
/*      */     }
/*      */     
/*      */     protected void emitFinish(Saver.SaveCur param1SaveCur) {
/*  758 */       if (!Locale.isFragmentQName(param1SaveCur.getName())) {
/*  759 */         assert this._nodeCur.isEnd();
/*  760 */         this._nodeCur.next();
/*      */       } 
/*      */     }
/*      */     
/*      */     protected void emitText(Saver.SaveCur param1SaveCur) {
/*  765 */       ensureDoc();
/*      */       
/*  767 */       Object object = param1SaveCur.getChars();
/*      */       
/*  769 */       if (param1SaveCur._cchSrc > 0) {
/*  770 */         this._nodeCur.insertChars(object, param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*  771 */         this._nodeCur.next();
/*      */       } 
/*      */     }
/*      */     
/*      */     protected void emitComment(Saver.SaveCur param1SaveCur) {
/*  776 */       ensureDoc();
/*      */       
/*  778 */       this._nodeCur.createComment();
/*  779 */       emitTextValue(param1SaveCur);
/*  780 */       this._nodeCur.skip();
/*      */     }
/*      */     
/*      */     protected void emitProcinst(Saver.SaveCur param1SaveCur) {
/*  784 */       ensureDoc();
/*      */       
/*  786 */       this._nodeCur.createProcinst(param1SaveCur.getName().dT());
/*  787 */       emitTextValue(param1SaveCur);
/*  788 */       this._nodeCur.skip();
/*      */     }
/*      */     
/*      */     protected void emitDocType(String param1String1, String param1String2, String param1String3) {
/*  792 */       ensureDoc();
/*      */       
/*  794 */       XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(this._nodeCur, true);
/*  795 */       xmlDocumentProperties.setDoctypeName(param1String1);
/*  796 */       xmlDocumentProperties.setDoctypePublicId(param1String2);
/*  797 */       xmlDocumentProperties.setDoctypeSystemId(param1String3);
/*      */     }
/*      */     
/*      */     protected void emitStartDoc(Saver.SaveCur param1SaveCur) {
/*  801 */       ensureDoc();
/*      */     }
/*      */ 
/*      */     
/*      */     protected void emitEndDoc(Saver.SaveCur param1SaveCur) {}
/*      */ 
/*      */     
/*      */     private b getQualifiedName(Saver.SaveCur param1SaveCur, b param1b) {
/*  809 */       String str1 = param1b.getNamespaceURI();
/*      */       
/*  811 */       String str2 = (str1.length() > 0) ? getUriMapping(str1) : "";
/*      */       
/*  813 */       if (str2.equals(param1b.getPrefix())) {
/*  814 */         return param1b;
/*      */       }
/*  816 */       return this._nodeCur._locale.makeQName(str1, param1b.dT(), str2);
/*      */     }
/*      */     
/*      */     private void emitTextValue(Saver.SaveCur param1SaveCur) {
/*  820 */       param1SaveCur.push();
/*  821 */       param1SaveCur.next();
/*      */       
/*  823 */       if (param1SaveCur.isText()) {
/*  824 */         this._nodeCur.next();
/*  825 */         this._nodeCur.insertChars(param1SaveCur.getChars(), param1SaveCur._offSrc, param1SaveCur._cchSrc);
/*  826 */         this._nodeCur.toParent();
/*      */       } 
/*      */       
/*  829 */       param1SaveCur.pop();
/*      */     }
/*      */     
/*      */     private void ensureDoc() {
/*  833 */       if (!this._nodeCur.isPositioned()) {
/*  834 */         if (this._isFrag) {
/*  835 */           this._nodeCur.createDomDocFragRoot();
/*      */         } else {
/*  837 */           this._nodeCur.createDomDocumentRoot();
/*      */         } 
/*  839 */         this._nodeCur.next();
/*      */       } 
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
/*      */   public Node _newDomNode(XmlOptions paramXmlOptions) {
/*  853 */     if (XmlOptions.hasOption(paramXmlOptions, "SAVE_INNER")) {
/*  854 */       paramXmlOptions = new XmlOptions(paramXmlOptions);
/*  855 */       paramXmlOptions.remove("SAVE_INNER");
/*      */     } 
/*      */     
/*  858 */     return (new DomSaver(this._cur, isDomFragment(), paramXmlOptions)).saveDom();
/*      */   }
/*      */   
/*      */   public boolean _toCursor(Cursor paramCursor) {
/*  862 */     assert this._cur._locale == paramCursor._cur._locale;
/*      */     
/*  864 */     this._cur.moveToCur(paramCursor._cur);
/*      */     
/*  866 */     return true;
/*      */   }
/*      */   
/*      */   public void _push() {
/*  870 */     this._cur.push();
/*      */   }
/*      */   
/*      */   public boolean _pop() {
/*  874 */     return this._cur.pop();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void notifyChange() {
/*  881 */     if (this._cur != null)
/*  882 */       _getSelectionCount(); 
/*      */   }
/*      */   
/*      */   public void setNextChangeListener(Locale.ChangeListener paramChangeListener) {
/*  886 */     this._nextChangeListener = paramChangeListener;
/*      */   }
/*      */   
/*      */   public Locale.ChangeListener getNextChangeListener() {
/*  890 */     return this._nextChangeListener;
/*      */   }
/*      */   
/*      */   public void _selectPath(String paramString) {
/*  894 */     _selectPath(paramString, null);
/*      */   }
/*      */   
/*      */   public void _selectPath(String paramString, XmlOptions paramXmlOptions) {
/*  898 */     _clearSelections();
/*      */     
/*  900 */     assert this._pathEngine == null;
/*      */     
/*  902 */     this._pathEngine = Path.getCompiledPath(paramString, paramXmlOptions).execute(this._cur, paramXmlOptions);
/*      */     
/*  904 */     this._cur._locale.registerForChange(this);
/*      */   }
/*      */   
/*      */   public boolean _hasNextSelection() {
/*  908 */     int i = this._currentSelection;
/*  909 */     push();
/*      */     
/*      */     try {
/*  912 */       return _toNextSelection();
/*      */     } finally {
/*  914 */       this._currentSelection = i;
/*  915 */       pop();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean _toNextSelection() {
/*  920 */     return _toSelection(this._currentSelection + 1);
/*      */   }
/*      */   
/*      */   public boolean _toSelection(int paramInt) {
/*  924 */     if (paramInt < 0) {
/*  925 */       return false;
/*      */     }
/*  927 */     while (paramInt >= this._cur.selectionCount()) {
/*  928 */       if (this._pathEngine == null) {
/*  929 */         return false;
/*      */       }
/*  931 */       if (!this._pathEngine.next(this._cur)) {
/*  932 */         this._pathEngine.release();
/*  933 */         this._pathEngine = null;
/*      */         
/*  935 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/*  939 */     this._cur.moveToSelection(this._currentSelection = paramInt);
/*      */     
/*  941 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public int _getSelectionCount() {
/*  946 */     _toSelection(2147483647);
/*      */     
/*  948 */     return this._cur.selectionCount();
/*      */   }
/*      */   
/*      */   public void _addToSelection() {
/*  952 */     _toSelection(2147483647);
/*      */     
/*  954 */     this._cur.addToSelection();
/*      */   }
/*      */   
/*      */   public void _clearSelections() {
/*  958 */     if (this._pathEngine != null) {
/*  959 */       this._pathEngine.release();
/*  960 */       this._pathEngine = null;
/*      */     } 
/*      */     
/*  963 */     this._cur.clearSelection();
/*      */     
/*  965 */     this._currentSelection = -1;
/*      */   }
/*      */   
/*      */   public String _namespaceForPrefix(String paramString) {
/*  969 */     if (!this._cur.isContainer()) {
/*  970 */       throw new IllegalStateException("Not on a container");
/*      */     }
/*  972 */     return this._cur.namespaceForPrefix(paramString, true);
/*      */   }
/*      */   
/*      */   public String _prefixForNamespace(String paramString) {
/*  976 */     if (paramString == null || paramString.length() == 0) {
/*  977 */       throw new IllegalArgumentException("Must specify a namespace");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  983 */     return this._cur.prefixForNamespace(paramString, null, true);
/*      */   }
/*      */   
/*      */   public void _getAllNamespaces(Map paramMap) {
/*  987 */     if (!this._cur.isContainer()) {
/*  988 */       throw new IllegalStateException("Not on a container");
/*      */     }
/*  990 */     if (paramMap != null)
/*  991 */       Locale.getAllNamespaces(this._cur, paramMap); 
/*      */   }
/*      */   
/*      */   public XmlObject _getObject() {
/*  995 */     return this._cur.getObject();
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _prevTokenType() {
/*  999 */     this._cur.push();
/*      */     
/* 1001 */     XmlCursor.TokenType tokenType = _toPrevToken();
/*      */     
/* 1003 */     this._cur.pop();
/*      */     
/* 1005 */     return tokenType;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean _hasNextToken() {
/* 1010 */     return (this._cur._pos != -1 || this._cur._xobj.kind() != 1);
/*      */   }
/*      */   
/*      */   public boolean _hasPrevToken() {
/* 1014 */     return (this._cur.kind() != 1);
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _toFirstContentToken() {
/* 1018 */     if (!this._cur.isContainer()) {
/* 1019 */       return XmlCursor.TokenType.NONE;
/*      */     }
/* 1021 */     this._cur.next();
/*      */     
/* 1023 */     return currentTokenType();
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType _toEndToken() {
/* 1027 */     if (!this._cur.isContainer()) {
/* 1028 */       return XmlCursor.TokenType.NONE;
/*      */     }
/* 1030 */     this._cur.toEnd();
/*      */     
/* 1032 */     return currentTokenType();
/*      */   }
/*      */   
/*      */   public boolean _toChild(String paramString) {
/* 1036 */     return _toChild((String)null, paramString);
/*      */   }
/*      */   
/*      */   public boolean _toChild(b paramb) {
/* 1040 */     return _toChild(paramb, 0);
/*      */   }
/*      */   
/*      */   public boolean _toChild(int paramInt) {
/* 1044 */     return _toChild((b)null, paramInt);
/*      */   }
/*      */   
/*      */   public boolean _toChild(String paramString1, String paramString2) {
/* 1048 */     validateLocalName(paramString2);
/*      */     
/* 1050 */     return _toChild(this._cur._locale.makeQName(paramString1, paramString2), 0);
/*      */   }
/*      */   
/*      */   public boolean _toChild(b paramb, int paramInt) {
/* 1054 */     return Locale.toChild(this._cur, paramb, paramInt);
/*      */   }
/*      */   
/*      */   public int _toNextChar(int paramInt) {
/* 1058 */     return this._cur.nextChars(paramInt);
/*      */   }
/*      */   
/*      */   public int _toPrevChar(int paramInt) {
/* 1062 */     return this._cur.prevChars(paramInt);
/*      */   }
/*      */   
/*      */   public boolean _toPrevSibling() {
/* 1066 */     return Locale.toPrevSiblingElement(this._cur);
/*      */   }
/*      */   
/*      */   public boolean _toLastChild() {
/* 1070 */     return Locale.toLastChildElement(this._cur);
/*      */   }
/*      */   
/*      */   public boolean _toFirstChild() {
/* 1074 */     return Locale.toFirstChildElement(this._cur);
/*      */   }
/*      */   
/*      */   public boolean _toNextSibling(String paramString) {
/* 1078 */     return _toNextSibling(new b(paramString));
/*      */   }
/*      */   
/*      */   public boolean _toNextSibling(String paramString1, String paramString2) {
/* 1082 */     validateLocalName(paramString2);
/*      */     
/* 1084 */     return _toNextSibling(this._cur._locale._qnameFactory.getQName(paramString1, paramString2));
/*      */   }
/*      */   
/*      */   public boolean _toNextSibling(b paramb) {
/* 1088 */     this._cur.push();
/*      */     
/* 1090 */     while (___toNextSibling()) {
/* 1091 */       if (this._cur.getName().equals(paramb)) {
/* 1092 */         this._cur.popButStay();
/* 1093 */         return true;
/*      */       } 
/*      */     } 
/*      */     
/* 1097 */     this._cur.pop();
/*      */     
/* 1099 */     return false;
/*      */   }
/*      */   
/*      */   public boolean _toFirstAttribute() {
/* 1103 */     return (this._cur.isContainer() && Locale.toFirstNormalAttr(this._cur));
/*      */   }
/*      */   
/*      */   public boolean _toLastAttribute() {
/* 1107 */     if (this._cur.isContainer()) {
/* 1108 */       this._cur.push();
/* 1109 */       this._cur.push();
/*      */       
/* 1111 */       boolean bool = false;
/*      */       
/* 1113 */       while (this._cur.toNextAttr()) {
/* 1114 */         if (this._cur.isNormalAttr()) {
/* 1115 */           this._cur.popButStay();
/* 1116 */           this._cur.push();
/* 1117 */           bool = true;
/*      */         } 
/*      */       } 
/*      */       
/* 1121 */       this._cur.pop();
/*      */       
/* 1123 */       if (bool) {
/* 1124 */         this._cur.popButStay();
/* 1125 */         return true;
/*      */       } 
/*      */       
/* 1128 */       this._cur.pop();
/*      */     } 
/*      */     
/* 1131 */     return false;
/*      */   }
/*      */   
/*      */   public boolean _toNextAttribute() {
/* 1135 */     return (this._cur.isAttr() && Locale.toNextNormalAttr(this._cur));
/*      */   }
/*      */   
/*      */   public boolean _toPrevAttribute() {
/* 1139 */     return (this._cur.isAttr() && Locale.toPrevNormalAttr(this._cur));
/*      */   }
/*      */   
/*      */   public String _getAttributeText(b paramb) {
/* 1143 */     if (paramb == null) {
/* 1144 */       throw new IllegalArgumentException("Attr name is null");
/*      */     }
/* 1146 */     if (!this._cur.isContainer()) {
/* 1147 */       return null;
/*      */     }
/* 1149 */     return this._cur.getAttrValue(paramb);
/*      */   }
/*      */   
/*      */   public boolean _setAttributeText(b paramb, String paramString) {
/* 1153 */     if (paramb == null) {
/* 1154 */       throw new IllegalArgumentException("Attr name is null");
/*      */     }
/* 1156 */     validateLocalName(paramb.dT());
/*      */     
/* 1158 */     if (!this._cur.isContainer()) {
/* 1159 */       return false;
/*      */     }
/* 1161 */     this._cur.setAttrValue(paramb, paramString);
/*      */     
/* 1163 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _removeAttribute(b paramb) {
/* 1167 */     if (paramb == null) {
/* 1168 */       throw new IllegalArgumentException("Attr name is null");
/*      */     }
/* 1170 */     if (!this._cur.isContainer()) {
/* 1171 */       return false;
/*      */     }
/* 1173 */     return this._cur.removeAttr(paramb);
/*      */   }
/*      */   
/*      */   public String _getTextValue() {
/* 1177 */     if (this._cur.isText()) {
/* 1178 */       return _getChars();
/*      */     }
/* 1180 */     if (!this._cur.isNode()) {
/* 1181 */       throw new IllegalStateException("Can't get text value, current token can have no text value");
/*      */     }
/*      */     
/* 1184 */     return this._cur.hasChildren() ? Locale.getTextValue(this._cur) : this._cur.getValueAsString();
/*      */   }
/*      */   
/*      */   public int _getTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1188 */     if (this._cur.isText()) {
/* 1189 */       return _getChars(paramArrayOfchar, paramInt1, paramInt2);
/*      */     }
/* 1191 */     if (paramArrayOfchar == null) {
/* 1192 */       throw new IllegalArgumentException("char buffer is null");
/*      */     }
/* 1194 */     if (paramInt1 < 0) {
/* 1195 */       throw new IllegalArgumentException("offset < 0");
/*      */     }
/* 1197 */     if (paramInt1 >= paramArrayOfchar.length) {
/* 1198 */       throw new IllegalArgumentException("offset off end");
/*      */     }
/* 1200 */     if (paramInt2 < 0) {
/* 1201 */       paramInt2 = Integer.MAX_VALUE;
/*      */     }
/* 1203 */     if (paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 1204 */       paramInt2 = paramArrayOfchar.length - paramInt1;
/*      */     }
/* 1206 */     if (!this._cur.isNode()) {
/* 1207 */       throw new IllegalStateException("Can't get text value, current token can have no text value");
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1212 */     if (this._cur.hasChildren()) {
/* 1213 */       return Locale.getTextValue(this._cur, 1, paramArrayOfchar, paramInt1, paramInt2);
/*      */     }
/*      */ 
/*      */     
/* 1217 */     Object object = this._cur.getFirstChars();
/*      */     
/* 1219 */     if (this._cur._cchSrc > paramInt2) {
/* 1220 */       this._cur._cchSrc = paramInt2;
/*      */     }
/* 1222 */     if (this._cur._cchSrc <= 0) {
/* 1223 */       return 0;
/*      */     }
/* 1225 */     CharUtil.getChars(paramArrayOfchar, paramInt1, object, this._cur._offSrc, this._cur._cchSrc);
/*      */     
/* 1227 */     return this._cur._cchSrc;
/*      */   }
/*      */   
/*      */   private void setTextValue(Object paramObject, int paramInt1, int paramInt2) {
/* 1231 */     if (!this._cur.isNode()) {
/* 1232 */       throw new IllegalStateException("Can't set text value, current token can have no text value");
/*      */     }
/*      */     
/* 1235 */     this._cur.moveNodeContents(null, false);
/* 1236 */     this._cur.next();
/* 1237 */     this._cur.insertChars(paramObject, paramInt1, paramInt2);
/* 1238 */     this._cur.toParent();
/*      */   }
/*      */   
/*      */   public void _setTextValue(String paramString) {
/* 1242 */     if (paramString == null) {
/* 1243 */       paramString = "";
/*      */     }
/* 1245 */     setTextValue(paramString, 0, paramString.length());
/*      */   }
/*      */   
/*      */   public void _setTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1249 */     if (paramInt2 < 0) {
/* 1250 */       throw new IndexOutOfBoundsException("setTextValue: length < 0");
/*      */     }
/* 1252 */     if (paramArrayOfchar == null) {
/* 1253 */       if (paramInt2 > 0) {
/* 1254 */         throw new IllegalArgumentException("setTextValue: sourceChars == null");
/*      */       }
/* 1256 */       setTextValue((char[])null, 0, 0);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1261 */     if (paramInt1 < 0 || paramInt1 >= paramArrayOfchar.length) {
/* 1262 */       throw new IndexOutOfBoundsException("setTextValue: offset out of bounds");
/*      */     }
/* 1264 */     if (paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 1265 */       paramInt2 = paramArrayOfchar.length - paramInt1;
/*      */     }
/* 1267 */     CharUtil charUtil = this._cur._locale.getCharUtil();
/*      */     
/* 1269 */     setTextValue(charUtil.saveChars(paramArrayOfchar, paramInt1, paramInt2), charUtil._offSrc, charUtil._cchSrc);
/*      */   }
/*      */   
/*      */   public String _getChars() {
/* 1273 */     return this._cur.getCharsAsString(-1);
/*      */   }
/*      */   
/*      */   public int _getChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 1277 */     int i = this._cur.cchRight();
/*      */     
/* 1279 */     if (paramInt2 < 0 || paramInt2 > i) {
/* 1280 */       paramInt2 = i;
/*      */     }
/* 1282 */     if (paramArrayOfchar == null || paramInt1 >= paramArrayOfchar.length) {
/* 1283 */       return 0;
/*      */     }
/* 1285 */     if (paramArrayOfchar.length - paramInt1 < paramInt2) {
/* 1286 */       paramInt2 = paramArrayOfchar.length - paramInt1;
/*      */     }
/* 1288 */     Object object = this._cur.getChars(paramInt2);
/*      */     
/* 1290 */     CharUtil.getChars(paramArrayOfchar, paramInt1, object, this._cur._offSrc, this._cur._cchSrc);
/*      */     
/* 1292 */     return this._cur._cchSrc;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void _toStartDoc() {
/* 1298 */     this._cur.toRoot();
/*      */   }
/*      */   
/*      */   public void _toEndDoc() {
/* 1302 */     _toStartDoc();
/*      */     
/* 1304 */     this._cur.toEnd();
/*      */   }
/*      */   
/*      */   public int _comparePosition(Cursor paramCursor) {
/* 1308 */     int i = this._cur.comparePosition(paramCursor._cur);
/*      */     
/* 1310 */     if (i == 2) {
/* 1311 */       throw new IllegalArgumentException("Cursors not in same document");
/*      */     }
/* 1313 */     assert i >= -1 && i <= 1;
/*      */     
/* 1315 */     return i;
/*      */   }
/*      */   
/*      */   public boolean _isLeftOf(Cursor paramCursor) {
/* 1319 */     return (_comparePosition(paramCursor) < 0);
/*      */   }
/*      */   
/*      */   public boolean _isAtSamePositionAs(Cursor paramCursor) {
/* 1323 */     return this._cur.isSamePos(paramCursor._cur);
/*      */   }
/*      */   
/*      */   public boolean _isRightOf(Cursor paramCursor) {
/* 1327 */     return (_comparePosition(paramCursor) > 0);
/*      */   }
/*      */   
/*      */   public XmlCursor _execQuery(String paramString) {
/* 1331 */     return _execQuery(paramString, null);
/*      */   }
/*      */   
/*      */   public XmlCursor _execQuery(String paramString, XmlOptions paramXmlOptions) {
/* 1335 */     checkThisCursor();
/* 1336 */     return Query.cursorExecQuery(this._cur, paramString, paramXmlOptions);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean _toBookmark(XmlCursor.XmlBookmark paramXmlBookmark) {
/* 1342 */     if (paramXmlBookmark == null || !(paramXmlBookmark._currentMark instanceof Xobj.Bookmark)) {
/* 1343 */       return false;
/*      */     }
/* 1345 */     Xobj.Bookmark bookmark = (Xobj.Bookmark)paramXmlBookmark._currentMark;
/*      */     
/* 1347 */     if (bookmark._xobj == null || bookmark._xobj._locale != this._cur._locale) {
/* 1348 */       return false;
/*      */     }
/* 1350 */     this._cur.moveTo(bookmark._xobj, bookmark._pos);
/*      */     
/* 1352 */     return true;
/*      */   }
/*      */   
/*      */   public XmlCursor.XmlBookmark _toNextBookmark(Object paramObject) {
/* 1356 */     if (paramObject == null) {
/* 1357 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1361 */     this._cur.push();
/*      */     
/*      */     while (true) {
/*      */       int i;
/*      */       
/* 1366 */       if ((i = this._cur.cchRight()) > 1) {
/* 1367 */         this._cur.nextChars(1);
/* 1368 */         this._cur.nextChars(((i = this._cur.firstBookmarkInChars(paramObject, i - 1)) >= 0) ? i : -1);
/* 1369 */       } else if (_toNextToken().isNone()) {
/* 1370 */         this._cur.pop();
/* 1371 */         return null;
/*      */       } 
/*      */       
/* 1374 */       XmlCursor.XmlBookmark xmlBookmark = getBookmark(paramObject, this._cur);
/*      */       
/* 1376 */       if (xmlBookmark != null) {
/* 1377 */         this._cur.popButStay();
/* 1378 */         return xmlBookmark;
/*      */       } 
/*      */       
/* 1381 */       if (this._cur.kind() == -1) {
/* 1382 */         this._cur.pop();
/* 1383 */         return null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.XmlBookmark _toPrevBookmark(Object paramObject) {
/* 1389 */     if (paramObject == null) {
/* 1390 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1394 */     this._cur.push();
/*      */     
/*      */     while (true) {
/*      */       int i;
/*      */       
/* 1399 */       if ((i = this._cur.cchLeft()) > 1) {
/* 1400 */         this._cur.prevChars(1);
/*      */         
/* 1402 */         this._cur.prevChars(((i = this._cur.firstBookmarkInCharsLeft(paramObject, i - 1)) >= 0) ? i : -1);
/* 1403 */       } else if (i == 1) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1408 */         this._cur.prevChars(1);
/* 1409 */       } else if (_toPrevToken().isNone()) {
/* 1410 */         this._cur.pop();
/* 1411 */         return null;
/*      */       } 
/*      */       
/* 1414 */       XmlCursor.XmlBookmark xmlBookmark = getBookmark(paramObject, this._cur);
/*      */       
/* 1416 */       if (xmlBookmark != null) {
/* 1417 */         this._cur.popButStay();
/* 1418 */         return xmlBookmark;
/*      */       } 
/*      */       
/* 1421 */       if (this._cur.kind() == 1) {
/* 1422 */         this._cur.pop();
/* 1423 */         return null;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void _setBookmark(XmlCursor.XmlBookmark paramXmlBookmark) {
/* 1429 */     if (paramXmlBookmark != null) {
/* 1430 */       if (paramXmlBookmark.getKey() == null) {
/* 1431 */         throw new IllegalArgumentException("Annotation key is null");
/*      */       }
/*      */ 
/*      */       
/* 1435 */       paramXmlBookmark._currentMark = this._cur.setBookmark(paramXmlBookmark.getKey(), paramXmlBookmark);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static XmlCursor.XmlBookmark getBookmark(Object paramObject, Cur paramCur) {
/* 1442 */     if (paramObject == null) {
/* 1443 */       return null;
/*      */     }
/* 1445 */     Object object = paramCur.getBookmark(paramObject);
/*      */     
/* 1447 */     return (object != null && object instanceof XmlCursor.XmlBookmark) ? (XmlCursor.XmlBookmark)object : null;
/*      */   }
/*      */   
/*      */   public XmlCursor.XmlBookmark _getBookmark(Object paramObject) {
/* 1451 */     return (paramObject == null) ? null : getBookmark(paramObject, this._cur);
/*      */   }
/*      */   
/*      */   public void _clearBookmark(Object paramObject) {
/* 1455 */     if (paramObject != null)
/* 1456 */       this._cur.setBookmark(paramObject, null); 
/*      */   }
/*      */   
/*      */   public void _getAllBookmarkRefs(Collection paramCollection) {
/* 1460 */     if (paramCollection != null)
/* 1461 */       for (Xobj.Bookmark bookmark = this._cur._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
/* 1462 */         if (bookmark._value instanceof XmlCursor.XmlBookmark)
/* 1463 */           paramCollection.add(bookmark._value); 
/*      */       }  
/*      */   }
/*      */   
/*      */   public boolean _removeXml() {
/* 1468 */     if (this._cur.isRoot()) {
/* 1469 */       throw new IllegalStateException("Can't remove a whole document.");
/*      */     }
/* 1471 */     if (this._cur.isFinish()) {
/* 1472 */       return false;
/*      */     }
/* 1474 */     assert this._cur.isText() || this._cur.isNode();
/*      */     
/* 1476 */     if (this._cur.isText()) {
/* 1477 */       this._cur.moveChars(null, -1);
/*      */     } else {
/* 1479 */       this._cur.moveNode(null);
/*      */     } 
/* 1481 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _moveXml(Cursor paramCursor) {
/* 1485 */     paramCursor.checkInsertionValidity(this._cur);
/*      */ 
/*      */ 
/*      */     
/* 1489 */     if (this._cur.isText()) {
/* 1490 */       int i = this._cur.cchRight();
/*      */       
/* 1492 */       assert i > 0;
/*      */       
/* 1494 */       if (this._cur.inChars(paramCursor._cur, i, true)) {
/* 1495 */         return false;
/*      */       }
/* 1497 */       this._cur.moveChars(paramCursor._cur, i);
/*      */       
/* 1499 */       paramCursor._cur.nextChars(i);
/*      */       
/* 1501 */       return true;
/*      */     } 
/*      */     
/* 1504 */     if (this._cur.contains(paramCursor._cur)) {
/* 1505 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1509 */     Cur cur = paramCursor.tempCur();
/*      */     
/* 1511 */     this._cur.moveNode(paramCursor._cur);
/*      */     
/* 1513 */     paramCursor._cur.moveToCur(cur);
/*      */     
/* 1515 */     cur.release();
/*      */     
/* 1517 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _copyXml(Cursor paramCursor) {
/* 1521 */     paramCursor.checkInsertionValidity(this._cur);
/*      */     
/* 1523 */     assert this._cur.isText() || this._cur.isNode();
/*      */     
/* 1525 */     Cur cur = paramCursor.tempCur();
/*      */     
/* 1527 */     if (this._cur.isText()) {
/* 1528 */       paramCursor._cur.insertChars(this._cur.getChars(-1), this._cur._offSrc, this._cur._cchSrc);
/*      */     } else {
/* 1530 */       this._cur.copyNode(paramCursor._cur);
/*      */     } 
/* 1532 */     paramCursor._cur.moveToCur(cur);
/*      */     
/* 1534 */     cur.release();
/*      */     
/* 1536 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _removeXmlContents() {
/* 1540 */     if (!this._cur.isContainer()) {
/* 1541 */       return false;
/*      */     }
/* 1543 */     this._cur.moveNodeContents(null, false);
/*      */     
/* 1545 */     return true;
/*      */   }
/*      */   
/*      */   private boolean checkContentInsertionValidity(Cursor paramCursor) {
/* 1549 */     this._cur.push();
/*      */     
/* 1551 */     this._cur.next();
/*      */     
/* 1553 */     if (this._cur.isFinish()) {
/* 1554 */       this._cur.pop();
/* 1555 */       return false;
/*      */     } 
/*      */     
/*      */     try {
/* 1559 */       paramCursor.checkInsertionValidity(this._cur);
/* 1560 */     } catch (IllegalArgumentException illegalArgumentException) {
/* 1561 */       this._cur.pop();
/* 1562 */       throw illegalArgumentException;
/*      */     } 
/*      */     
/* 1565 */     this._cur.pop();
/*      */     
/* 1567 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _moveXmlContents(Cursor paramCursor) {
/* 1571 */     if (!this._cur.isContainer() || this._cur.contains(paramCursor._cur)) {
/* 1572 */       return false;
/*      */     }
/* 1574 */     if (!checkContentInsertionValidity(paramCursor)) {
/* 1575 */       return false;
/*      */     }
/* 1577 */     Cur cur = paramCursor.tempCur();
/*      */     
/* 1579 */     this._cur.moveNodeContents(paramCursor._cur, false);
/*      */     
/* 1581 */     paramCursor._cur.moveToCur(cur);
/*      */     
/* 1583 */     cur.release();
/*      */     
/* 1585 */     return true;
/*      */   }
/*      */   
/*      */   public boolean _copyXmlContents(Cursor paramCursor) {
/* 1589 */     if (!this._cur.isContainer() || this._cur.contains(paramCursor._cur)) {
/* 1590 */       return false;
/*      */     }
/* 1592 */     if (!checkContentInsertionValidity(paramCursor)) {
/* 1593 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1598 */     Cur cur1 = this._cur._locale.tempCur();
/*      */     
/* 1600 */     this._cur.copyNode(cur1);
/*      */     
/* 1602 */     Cur cur2 = paramCursor._cur.tempCur();
/*      */     
/* 1604 */     cur1.moveNodeContents(paramCursor._cur, false);
/*      */     
/* 1606 */     cur1.release();
/*      */     
/* 1608 */     paramCursor._cur.moveToCur(cur2);
/*      */     
/* 1610 */     cur2.release();
/*      */     
/* 1612 */     return true;
/*      */   }
/*      */   
/*      */   public int _removeChars(int paramInt) {
/* 1616 */     int i = this._cur.cchRight();
/*      */     
/* 1618 */     if (i == 0 || paramInt == 0) {
/* 1619 */       return 0;
/*      */     }
/* 1621 */     if (paramInt < 0 || paramInt > i) {
/* 1622 */       paramInt = i;
/*      */     }
/* 1624 */     this._cur.moveChars(null, paramInt);
/*      */     
/* 1626 */     return this._cur._cchSrc;
/*      */   }
/*      */   
/*      */   public int _moveChars(int paramInt, Cursor paramCursor) {
/* 1630 */     int i = this._cur.cchRight();
/*      */     
/* 1632 */     if (i <= 0 || paramInt == 0) {
/* 1633 */       return 0;
/*      */     }
/* 1635 */     if (paramInt < 0 || paramInt > i) {
/* 1636 */       paramInt = i;
/*      */     }
/* 1638 */     paramCursor.checkInsertionValidity(this._cur);
/*      */     
/* 1640 */     this._cur.moveChars(paramCursor._cur, paramInt);
/*      */     
/* 1642 */     paramCursor._cur.nextChars(this._cur._cchSrc);
/*      */     
/* 1644 */     return this._cur._cchSrc;
/*      */   }
/*      */   
/*      */   public int _copyChars(int paramInt, Cursor paramCursor) {
/* 1648 */     int i = this._cur.cchRight();
/*      */     
/* 1650 */     if (i <= 0 || paramInt == 0) {
/* 1651 */       return 0;
/*      */     }
/* 1653 */     if (paramInt < 0 || paramInt > i) {
/* 1654 */       paramInt = i;
/*      */     }
/* 1656 */     paramCursor.checkInsertionValidity(this._cur);
/*      */     
/* 1658 */     paramCursor._cur.insertChars(this._cur.getChars(paramInt), this._cur._offSrc, this._cur._cchSrc);
/*      */     
/* 1660 */     paramCursor._cur.nextChars(this._cur._cchSrc);
/*      */     
/* 1662 */     return this._cur._cchSrc;
/*      */   }
/*      */   
/*      */   public void _insertChars(String paramString) {
/* 1666 */     boolean bool = (paramString == null) ? false : paramString.length();
/*      */     
/* 1668 */     if (bool) {
/* 1669 */       if (this._cur.isRoot() || this._cur.isAttr()) {
/* 1670 */         throw new IllegalStateException("Can't insert before the document or an attribute.");
/*      */       }
/*      */ 
/*      */       
/* 1674 */       this._cur.insertChars(paramString, 0, bool);
/* 1675 */       this._cur.nextChars(bool);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _beginElement(String paramString) {
/* 1684 */     _insertElementWithText(paramString, null, null);
/* 1685 */     _toPrevToken();
/*      */   }
/*      */   
/*      */   public void _beginElement(String paramString1, String paramString2) {
/* 1689 */     _insertElementWithText(paramString1, paramString2, null);
/* 1690 */     _toPrevToken();
/*      */   }
/*      */   
/*      */   public void _beginElement(b paramb) {
/* 1694 */     _insertElementWithText(paramb, (String)null);
/* 1695 */     _toPrevToken();
/*      */   }
/*      */   
/*      */   public void _insertElement(String paramString) {
/* 1699 */     _insertElementWithText(paramString, null, null);
/*      */   }
/*      */   
/*      */   public void _insertElement(String paramString1, String paramString2) {
/* 1703 */     _insertElementWithText(paramString1, paramString2, null);
/*      */   }
/*      */   
/*      */   public void _insertElement(b paramb) {
/* 1707 */     _insertElementWithText(paramb, (String)null);
/*      */   }
/*      */   
/*      */   public void _insertElementWithText(String paramString1, String paramString2) {
/* 1711 */     _insertElementWithText(paramString1, null, paramString2);
/*      */   }
/*      */   
/*      */   public void _insertElementWithText(String paramString1, String paramString2, String paramString3) {
/* 1715 */     validateLocalName(paramString1);
/*      */     
/* 1717 */     _insertElementWithText(this._cur._locale.makeQName(paramString2, paramString1), paramString3);
/*      */   }
/*      */   
/*      */   public void _insertElementWithText(b paramb, String paramString) {
/* 1721 */     validateLocalName(paramb.dT());
/*      */     
/* 1723 */     Cur cur = this._cur._locale.tempCur();
/*      */     
/* 1725 */     cur.createElement(paramb);
/*      */     
/* 1727 */     insertNode(cur, paramString);
/*      */     
/* 1729 */     cur.release();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _insertAttribute(String paramString) {
/* 1737 */     _insertAttributeWithValue(paramString, (String)null);
/*      */   }
/*      */   
/*      */   public void _insertAttribute(String paramString1, String paramString2) {
/* 1741 */     _insertAttributeWithValue(paramString1, paramString2, null);
/*      */   }
/*      */   
/*      */   public void _insertAttribute(b paramb) {
/* 1745 */     _insertAttributeWithValue(paramb, (String)null);
/*      */   }
/*      */   
/*      */   public void _insertAttributeWithValue(String paramString1, String paramString2) {
/* 1749 */     _insertAttributeWithValue(paramString1, null, paramString2);
/*      */   }
/*      */   
/*      */   public void _insertAttributeWithValue(String paramString1, String paramString2, String paramString3) {
/* 1753 */     validateLocalName(paramString1);
/*      */     
/* 1755 */     _insertAttributeWithValue(this._cur._locale.makeQName(paramString2, paramString1), paramString3);
/*      */   }
/*      */   
/*      */   public void _insertAttributeWithValue(b paramb, String paramString) {
/* 1759 */     validateLocalName(paramb.dT());
/*      */     
/* 1761 */     Cur cur = this._cur._locale.tempCur();
/*      */     
/* 1763 */     cur.createAttr(paramb);
/*      */     
/* 1765 */     insertNode(cur, paramString);
/*      */     
/* 1767 */     cur.release();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void _insertNamespace(String paramString1, String paramString2) {
/* 1775 */     _insertAttributeWithValue(this._cur._locale.createXmlns(paramString1), paramString2);
/*      */   }
/*      */   
/*      */   public void _insertComment(String paramString) {
/* 1779 */     Cur cur = this._cur._locale.tempCur();
/*      */     
/* 1781 */     cur.createComment();
/*      */     
/* 1783 */     insertNode(cur, paramString);
/*      */     
/* 1785 */     cur.release();
/*      */   }
/*      */   
/*      */   public void _insertProcInst(String paramString1, String paramString2) {
/* 1789 */     validateLocalName(paramString1);
/*      */     
/* 1791 */     if (Locale.beginsWithXml(paramString1) && paramString1.length() == 3) {
/* 1792 */       throw new IllegalArgumentException("Target is 'xml'");
/*      */     }
/* 1794 */     Cur cur = this._cur._locale.tempCur();
/*      */     
/* 1796 */     cur.createProcinst(paramString1);
/*      */     
/* 1798 */     insertNode(cur, paramString2);
/*      */     
/* 1800 */     cur.release();
/*      */   }
/*      */   
/*      */   public void _dump() {
/* 1804 */     this._cur.dump();
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
/*      */   private void checkThisCursor() {
/* 1816 */     if (this._cur == null)
/* 1817 */       throw new IllegalStateException("This cursor has been disposed"); 
/*      */   }
/*      */   
/*      */   private Cursor checkCursors(XmlCursor paramXmlCursor) {
/* 1821 */     checkThisCursor();
/*      */     
/* 1823 */     if (paramXmlCursor == null) {
/* 1824 */       throw new IllegalArgumentException("Other cursor is <null>");
/*      */     }
/* 1826 */     if (!(paramXmlCursor instanceof Cursor)) {
/* 1827 */       throw new IllegalArgumentException("Incompatible cursors: " + paramXmlCursor);
/*      */     }
/* 1829 */     Cursor cursor = (Cursor)paramXmlCursor;
/*      */     
/* 1831 */     if (cursor._cur == null) {
/* 1832 */       throw new IllegalStateException("Other cursor has been disposed");
/*      */     }
/* 1834 */     return cursor;
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
/*      */   private int twoLocaleOp(XmlCursor paramXmlCursor, int paramInt1, int paramInt2) {
/* 1849 */     Cursor cursor = checkCursors(paramXmlCursor);
/*      */     
/* 1851 */     Locale locale1 = this._cur._locale;
/* 1852 */     Locale locale2 = cursor._cur._locale;
/*      */     
/* 1854 */     if (locale1 == locale2) {
/* 1855 */       if (locale1.noSync()) {
/* 1856 */         return twoLocaleOp(cursor, paramInt1, paramInt2);
/*      */       }
/* 1858 */       synchronized (locale1) {
/* 1859 */         return twoLocaleOp(cursor, paramInt1, paramInt2);
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1864 */     if (locale1.noSync()) {
/* 1865 */       if (locale2.noSync()) {
/* 1866 */         return twoLocaleOp(cursor, paramInt1, paramInt2);
/*      */       }
/* 1868 */       synchronized (locale2) {
/* 1869 */         return twoLocaleOp(cursor, paramInt1, paramInt2);
/*      */       } 
/*      */     } 
/* 1872 */     if (locale2.noSync()) {
/* 1873 */       synchronized (locale1) {
/* 1874 */         return twoLocaleOp(cursor, paramInt1, paramInt2);
/*      */       } 
/*      */     }
/*      */     
/* 1878 */     boolean bool = false;
/*      */     
/*      */     try {
/* 1881 */       GlobalLock.acquire();
/* 1882 */       bool = true;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/* 1892 */     catch (InterruptedException interruptedException) {
/* 1893 */       throw new RuntimeException(interruptedException.getMessage(), interruptedException);
/*      */     } finally {
/* 1895 */       if (bool)
/* 1896 */         GlobalLock.release(); 
/*      */     } 
/*      */   }
/*      */   
/*      */   private int twoLocaleOp(Cursor paramCursor, int paramInt1, int paramInt2) {
/* 1901 */     Locale locale1 = this._cur._locale;
/* 1902 */     Locale locale2 = paramCursor._cur._locale;
/*      */     
/* 1904 */     locale1.enter(locale2);
/*      */     
/*      */     try { int i;
/* 1907 */       switch (paramInt1)
/*      */       { case 0:
/* 1909 */           i = _moveXml(paramCursor) ? 1 : 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1925 */           return i;case 1: i = _copyXml(paramCursor) ? 1 : 0; return i;case 2: i = _moveXmlContents(paramCursor) ? 1 : 0; return i;case 3: i = _copyXmlContents(paramCursor) ? 1 : 0; return i;case 4: i = _moveChars(paramInt2, paramCursor); return i;case 5: i = _copyChars(paramInt2, paramCursor); return i; }  throw new RuntimeException("Unknown operation: " + paramInt1); } finally { locale1.exit(locale2); }
/*      */   
/*      */   }
/*      */   
/*      */   public boolean moveXml(XmlCursor paramXmlCursor) {
/* 1930 */     return (twoLocaleOp(paramXmlCursor, 0, 0) == 1);
/*      */   }
/*      */   
/*      */   public boolean copyXml(XmlCursor paramXmlCursor) {
/* 1934 */     return (twoLocaleOp(paramXmlCursor, 1, 0) == 1);
/*      */   }
/*      */   
/*      */   public boolean moveXmlContents(XmlCursor paramXmlCursor) {
/* 1938 */     return (twoLocaleOp(paramXmlCursor, 2, 0) == 1);
/*      */   }
/*      */   
/*      */   public boolean copyXmlContents(XmlCursor paramXmlCursor) {
/* 1942 */     return (twoLocaleOp(paramXmlCursor, 3, 0) == 1);
/*      */   }
/*      */   
/*      */   public int moveChars(int paramInt, XmlCursor paramXmlCursor) {
/* 1946 */     return twoLocaleOp(paramXmlCursor, 4, paramInt);
/*      */   }
/*      */   
/*      */   public int copyChars(int paramInt, XmlCursor paramXmlCursor) {
/* 1950 */     return twoLocaleOp(paramXmlCursor, 5, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean toCursor(XmlCursor paramXmlCursor) {
/* 1961 */     Cursor cursor = checkCursors(paramXmlCursor);
/*      */     
/* 1963 */     if (this._cur._locale != cursor._cur._locale) {
/* 1964 */       return false;
/*      */     }
/* 1966 */     if (this._cur._locale.noSync()) {
/* 1967 */       this._cur._locale.enter();
/*      */       try {
/* 1969 */         return _toCursor(cursor);
/*      */       } finally {
/* 1971 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/* 1974 */     synchronized (this._cur._locale) {
/* 1975 */       this._cur._locale.enter();
/*      */       try {
/* 1977 */         return _toCursor(cursor);
/*      */       } finally {
/* 1979 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isInSameDocument(XmlCursor paramXmlCursor) {
/* 1986 */     return (paramXmlCursor == null) ? false : this._cur.isInSameTree((checkCursors(paramXmlCursor))._cur);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Cursor preCheck(XmlCursor paramXmlCursor) {
/* 1994 */     Cursor cursor = checkCursors(paramXmlCursor);
/*      */     
/* 1996 */     if (this._cur._locale != cursor._cur._locale) {
/* 1997 */       throw new IllegalArgumentException("Cursors not in same document");
/*      */     }
/* 1999 */     return cursor;
/*      */   }
/*      */   
/*      */   public int comparePosition(XmlCursor paramXmlCursor) {
/* 2003 */     Cursor cursor = preCheck(paramXmlCursor);
/* 2004 */     if (this._cur._locale.noSync()) {
/* 2005 */       this._cur._locale.enter();
/*      */       try {
/* 2007 */         return _comparePosition(cursor);
/*      */       } finally {
/* 2009 */         this._cur._locale.exit();
/*      */       } 
/* 2011 */     }  synchronized (this._cur._locale) {
/* 2012 */       this._cur._locale.enter();
/*      */       try {
/* 2014 */         return _comparePosition(cursor);
/*      */       } finally {
/* 2016 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isLeftOf(XmlCursor paramXmlCursor) {
/* 2022 */     Cursor cursor = preCheck(paramXmlCursor);
/* 2023 */     if (this._cur._locale.noSync()) {
/* 2024 */       this._cur._locale.enter();
/*      */       try {
/* 2026 */         return _isLeftOf(cursor);
/*      */       } finally {
/* 2028 */         this._cur._locale.exit();
/*      */       } 
/* 2030 */     }  synchronized (this._cur._locale) {
/* 2031 */       this._cur._locale.enter();
/*      */       try {
/* 2033 */         return _isLeftOf(cursor);
/*      */       } finally {
/* 2035 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isAtSamePositionAs(XmlCursor paramXmlCursor) {
/* 2041 */     Cursor cursor = preCheck(paramXmlCursor);
/* 2042 */     if (this._cur._locale.noSync()) {
/* 2043 */       this._cur._locale.enter();
/*      */       try {
/* 2045 */         return _isAtSamePositionAs(cursor);
/*      */       } finally {
/* 2047 */         this._cur._locale.exit();
/*      */       } 
/* 2049 */     }  synchronized (this._cur._locale) {
/* 2050 */       this._cur._locale.enter();
/*      */       try {
/* 2052 */         return _isAtSamePositionAs(cursor);
/*      */       } finally {
/* 2054 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isRightOf(XmlCursor paramXmlCursor) {
/* 2060 */     Cursor cursor = preCheck(paramXmlCursor);
/* 2061 */     if (this._cur._locale.noSync()) {
/* 2062 */       this._cur._locale.enter();
/*      */       try {
/* 2064 */         return _isRightOf(cursor);
/*      */       } finally {
/* 2066 */         this._cur._locale.exit();
/*      */       } 
/* 2068 */     }  synchronized (this._cur._locale) {
/* 2069 */       this._cur._locale.enter();
/*      */       try {
/* 2071 */         return _isRightOf(cursor);
/*      */       } finally {
/* 2073 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static XmlCursor newCursor(Xobj paramXobj, int paramInt) {
/* 2083 */     Locale locale = paramXobj._locale;
/* 2084 */     if (locale.noSync()) {
/* 2085 */       locale.enter();
/*      */       try {
/* 2087 */         return new Cursor(paramXobj, paramInt);
/*      */       } finally {
/* 2089 */         locale.exit();
/*      */       } 
/* 2091 */     }  synchronized (locale) {
/* 2092 */       locale.enter();
/*      */       try {
/* 2094 */         return new Cursor(paramXobj, paramInt);
/*      */       } finally {
/* 2096 */         locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean preCheck() {
/* 2106 */     checkThisCursor();
/* 2107 */     return this._cur._locale.noSync();
/*      */   }
/*      */   
/*      */   public void dispose() {
/* 2111 */     if (this._cur != null) {
/* 2112 */       Locale locale = this._cur._locale;
/* 2113 */       if (preCheck())
/* 2114 */       { locale.enter();
/*      */         try {
/* 2116 */           _dispose();
/*      */         } finally {
/* 2118 */           locale.exit();
/*      */         }  }
/* 2120 */       else { synchronized (locale) {
/* 2121 */           locale.enter();
/*      */           try {
/* 2123 */             _dispose();
/*      */           } finally {
/* 2125 */             locale.exit();
/*      */           } 
/*      */         }  }
/*      */     
/*      */     } 
/*      */   }
/*      */   public Object monitor() {
/* 2132 */     if (preCheck()) {
/* 2133 */       this._cur._locale.enter();
/*      */       try {
/* 2135 */         return _monitor();
/*      */       } finally {
/* 2137 */         this._cur._locale.exit();
/*      */       } 
/* 2139 */     }  synchronized (this._cur._locale) {
/* 2140 */       this._cur._locale.enter();
/*      */       try {
/* 2142 */         return _monitor();
/*      */       } finally {
/* 2144 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlDocumentProperties documentProperties() {
/* 2150 */     if (preCheck()) {
/* 2151 */       this._cur._locale.enter();
/*      */       try {
/* 2153 */         return _documentProperties();
/*      */       } finally {
/* 2155 */         this._cur._locale.exit();
/*      */       } 
/* 2157 */     }  synchronized (this._cur._locale) {
/* 2158 */       this._cur._locale.enter();
/*      */       try {
/* 2160 */         return _documentProperties();
/*      */       } finally {
/* 2162 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor newCursor() {
/* 2168 */     if (preCheck()) {
/* 2169 */       this._cur._locale.enter();
/*      */       try {
/* 2171 */         return _newCursor();
/*      */       } finally {
/* 2173 */         this._cur._locale.exit();
/*      */       } 
/* 2175 */     }  synchronized (this._cur._locale) {
/* 2176 */       this._cur._locale.enter();
/*      */       try {
/* 2178 */         return _newCursor();
/*      */       } finally {
/* 2180 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XMLStreamReader newXMLStreamReader() {
/* 2186 */     if (preCheck()) {
/* 2187 */       this._cur._locale.enter();
/*      */       try {
/* 2189 */         return _newXMLStreamReader();
/*      */       } finally {
/* 2191 */         this._cur._locale.exit();
/*      */       } 
/* 2193 */     }  synchronized (this._cur._locale) {
/* 2194 */       this._cur._locale.enter();
/*      */       try {
/* 2196 */         return _newXMLStreamReader();
/*      */       } finally {
/* 2198 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XMLStreamReader newXMLStreamReader(XmlOptions paramXmlOptions) {
/* 2204 */     if (preCheck()) {
/* 2205 */       this._cur._locale.enter();
/*      */       try {
/* 2207 */         return _newXMLStreamReader(paramXmlOptions);
/*      */       } finally {
/* 2209 */         this._cur._locale.exit();
/*      */       } 
/* 2211 */     }  synchronized (this._cur._locale) {
/* 2212 */       this._cur._locale.enter();
/*      */       try {
/* 2214 */         return _newXMLStreamReader(paramXmlOptions);
/*      */       } finally {
/* 2216 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XMLInputStream newXMLInputStream() {
/* 2225 */     if (preCheck()) {
/* 2226 */       this._cur._locale.enter();
/*      */       try {
/* 2228 */         return _newXMLInputStream();
/*      */       } finally {
/* 2230 */         this._cur._locale.exit();
/*      */       } 
/* 2232 */     }  synchronized (this._cur._locale) {
/* 2233 */       this._cur._locale.enter();
/*      */       try {
/* 2235 */         return _newXMLInputStream();
/*      */       } finally {
/* 2237 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String xmlText() {
/* 2243 */     if (preCheck()) {
/* 2244 */       this._cur._locale.enter();
/*      */       try {
/* 2246 */         return _xmlText();
/*      */       } finally {
/* 2248 */         this._cur._locale.exit();
/*      */       } 
/* 2250 */     }  synchronized (this._cur._locale) {
/* 2251 */       this._cur._locale.enter();
/*      */       try {
/* 2253 */         return _xmlText();
/*      */       } finally {
/* 2255 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public InputStream newInputStream() {
/* 2261 */     if (preCheck()) {
/* 2262 */       this._cur._locale.enter();
/*      */       try {
/* 2264 */         return _newInputStream();
/*      */       } finally {
/* 2266 */         this._cur._locale.exit();
/*      */       } 
/* 2268 */     }  synchronized (this._cur._locale) {
/* 2269 */       this._cur._locale.enter();
/*      */       try {
/* 2271 */         return _newInputStream();
/*      */       } finally {
/* 2273 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Reader newReader() {
/* 2279 */     if (preCheck()) {
/* 2280 */       this._cur._locale.enter();
/*      */       try {
/* 2282 */         return _newReader();
/*      */       } finally {
/* 2284 */         this._cur._locale.exit();
/*      */       } 
/* 2286 */     }  synchronized (this._cur._locale) {
/* 2287 */       this._cur._locale.enter();
/*      */       try {
/* 2289 */         return _newReader();
/*      */       } finally {
/* 2291 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Node newDomNode() {
/* 2297 */     if (preCheck()) {
/* 2298 */       this._cur._locale.enter();
/*      */       try {
/* 2300 */         return _newDomNode();
/*      */       } finally {
/* 2302 */         this._cur._locale.exit();
/*      */       } 
/* 2304 */     }  synchronized (this._cur._locale) {
/* 2305 */       this._cur._locale.enter();
/*      */       try {
/* 2307 */         return _newDomNode();
/*      */       } finally {
/* 2309 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Node getDomNode() {
/* 2315 */     if (preCheck()) {
/* 2316 */       this._cur._locale.enter();
/*      */       try {
/* 2318 */         return _getDomNode();
/*      */       } finally {
/* 2320 */         this._cur._locale.exit();
/*      */       } 
/* 2322 */     }  synchronized (this._cur._locale) {
/* 2323 */       this._cur._locale.enter();
/*      */       try {
/* 2325 */         return _getDomNode();
/*      */       } finally {
/* 2327 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler) throws SAXException {
/* 2333 */     if (preCheck())
/* 2334 */     { this._cur._locale.enter();
/*      */       try {
/* 2336 */         _save(paramContentHandler, paramLexicalHandler);
/*      */       } finally {
/* 2338 */         this._cur._locale.exit();
/*      */       }  }
/* 2340 */     else { synchronized (this._cur._locale) {
/* 2341 */         this._cur._locale.enter();
/*      */         try {
/* 2343 */           _save(paramContentHandler, paramLexicalHandler);
/*      */         } finally {
/* 2345 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(File paramFile) throws IOException {
/* 2351 */     if (preCheck())
/* 2352 */     { this._cur._locale.enter();
/*      */       try {
/* 2354 */         _save(paramFile);
/*      */       } finally {
/* 2356 */         this._cur._locale.exit();
/*      */       }  }
/* 2358 */     else { synchronized (this._cur._locale) {
/* 2359 */         this._cur._locale.enter();
/*      */         try {
/* 2361 */           _save(paramFile);
/*      */         } finally {
/* 2363 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(OutputStream paramOutputStream) throws IOException {
/* 2369 */     if (preCheck())
/* 2370 */     { this._cur._locale.enter();
/*      */       try {
/* 2372 */         _save(paramOutputStream);
/*      */       } finally {
/* 2374 */         this._cur._locale.exit();
/*      */       }  }
/* 2376 */     else { synchronized (this._cur._locale) {
/* 2377 */         this._cur._locale.enter();
/*      */         try {
/* 2379 */           _save(paramOutputStream);
/*      */         } finally {
/* 2381 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(Writer paramWriter) throws IOException {
/* 2387 */     if (preCheck())
/* 2388 */     { this._cur._locale.enter();
/*      */       try {
/* 2390 */         _save(paramWriter);
/*      */       } finally {
/* 2392 */         this._cur._locale.exit();
/*      */       }  }
/* 2394 */     else { synchronized (this._cur._locale) {
/* 2395 */         this._cur._locale.enter();
/*      */         try {
/* 2397 */           _save(paramWriter);
/*      */         } finally {
/* 2399 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XMLInputStream newXMLInputStream(XmlOptions paramXmlOptions) {
/* 2408 */     if (preCheck()) {
/* 2409 */       this._cur._locale.enter();
/*      */       try {
/* 2411 */         return _newXMLInputStream(paramXmlOptions);
/*      */       } finally {
/* 2413 */         this._cur._locale.exit();
/*      */       } 
/* 2415 */     }  synchronized (this._cur._locale) {
/* 2416 */       this._cur._locale.enter();
/*      */       try {
/* 2418 */         return _newXMLInputStream(paramXmlOptions);
/*      */       } finally {
/* 2420 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String xmlText(XmlOptions paramXmlOptions) {
/* 2426 */     if (preCheck()) {
/* 2427 */       this._cur._locale.enter();
/*      */       try {
/* 2429 */         return _xmlText(paramXmlOptions);
/*      */       } finally {
/* 2431 */         this._cur._locale.exit();
/*      */       } 
/* 2433 */     }  synchronized (this._cur._locale) {
/* 2434 */       this._cur._locale.enter();
/*      */       try {
/* 2436 */         return _xmlText(paramXmlOptions);
/*      */       } finally {
/* 2438 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public InputStream newInputStream(XmlOptions paramXmlOptions) {
/* 2444 */     if (preCheck()) {
/* 2445 */       this._cur._locale.enter();
/*      */       try {
/* 2447 */         return _newInputStream(paramXmlOptions);
/*      */       } finally {
/* 2449 */         this._cur._locale.exit();
/*      */       } 
/* 2451 */     }  synchronized (this._cur._locale) {
/* 2452 */       this._cur._locale.enter();
/*      */       try {
/* 2454 */         return _newInputStream(paramXmlOptions);
/*      */       } finally {
/* 2456 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Reader newReader(XmlOptions paramXmlOptions) {
/* 2462 */     if (preCheck()) {
/* 2463 */       this._cur._locale.enter();
/*      */       try {
/* 2465 */         return _newReader(paramXmlOptions);
/*      */       } finally {
/* 2467 */         this._cur._locale.exit();
/*      */       } 
/* 2469 */     }  synchronized (this._cur._locale) {
/* 2470 */       this._cur._locale.enter();
/*      */       try {
/* 2472 */         return _newReader(paramXmlOptions);
/*      */       } finally {
/* 2474 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Node newDomNode(XmlOptions paramXmlOptions) {
/* 2480 */     if (preCheck()) {
/* 2481 */       this._cur._locale.enter();
/*      */       try {
/* 2483 */         return _newDomNode(paramXmlOptions);
/*      */       } finally {
/* 2485 */         this._cur._locale.exit();
/*      */       } 
/* 2487 */     }  synchronized (this._cur._locale) {
/* 2488 */       this._cur._locale.enter();
/*      */       try {
/* 2490 */         return _newDomNode(paramXmlOptions);
/*      */       } finally {
/* 2492 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void save(ContentHandler paramContentHandler, LexicalHandler paramLexicalHandler, XmlOptions paramXmlOptions) throws SAXException {
/* 2498 */     if (preCheck())
/* 2499 */     { this._cur._locale.enter();
/*      */       try {
/* 2501 */         _save(paramContentHandler, paramLexicalHandler, paramXmlOptions);
/*      */       } finally {
/* 2503 */         this._cur._locale.exit();
/*      */       }  }
/* 2505 */     else { synchronized (this._cur._locale) {
/* 2506 */         this._cur._locale.enter();
/*      */         try {
/* 2508 */           _save(paramContentHandler, paramLexicalHandler, paramXmlOptions);
/*      */         } finally {
/* 2510 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(File paramFile, XmlOptions paramXmlOptions) throws IOException {
/* 2516 */     if (preCheck())
/* 2517 */     { this._cur._locale.enter();
/*      */       try {
/* 2519 */         _save(paramFile, paramXmlOptions);
/*      */       } finally {
/* 2521 */         this._cur._locale.exit();
/*      */       }  }
/* 2523 */     else { synchronized (this._cur._locale) {
/* 2524 */         this._cur._locale.enter();
/*      */         try {
/* 2526 */           _save(paramFile, paramXmlOptions);
/*      */         } finally {
/* 2528 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(OutputStream paramOutputStream, XmlOptions paramXmlOptions) throws IOException {
/* 2534 */     if (preCheck())
/* 2535 */     { this._cur._locale.enter();
/*      */       try {
/* 2537 */         _save(paramOutputStream, paramXmlOptions);
/*      */       } finally {
/* 2539 */         this._cur._locale.exit();
/*      */       }  }
/* 2541 */     else { synchronized (this._cur._locale) {
/* 2542 */         this._cur._locale.enter();
/*      */         try {
/* 2544 */           _save(paramOutputStream, paramXmlOptions);
/*      */         } finally {
/* 2546 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void save(Writer paramWriter, XmlOptions paramXmlOptions) throws IOException {
/* 2552 */     if (preCheck())
/* 2553 */     { this._cur._locale.enter();
/*      */       try {
/* 2555 */         _save(paramWriter, paramXmlOptions);
/*      */       } finally {
/* 2557 */         this._cur._locale.exit();
/*      */       }  }
/* 2559 */     else { synchronized (this._cur._locale) {
/* 2560 */         this._cur._locale.enter();
/*      */         try {
/* 2562 */           _save(paramWriter, paramXmlOptions);
/*      */         } finally {
/* 2564 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void push() {
/* 2570 */     if (preCheck())
/* 2571 */     { this._cur._locale.enter();
/*      */       try {
/* 2573 */         _push();
/*      */       } finally {
/* 2575 */         this._cur._locale.exit();
/*      */       }  }
/* 2577 */     else { synchronized (this._cur._locale) {
/* 2578 */         this._cur._locale.enter();
/*      */         try {
/* 2580 */           _push();
/*      */         } finally {
/* 2582 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public boolean pop() {
/* 2588 */     if (preCheck()) {
/* 2589 */       this._cur._locale.enter();
/*      */       try {
/* 2591 */         return _pop();
/*      */       } finally {
/* 2593 */         this._cur._locale.exit();
/*      */       } 
/* 2595 */     }  synchronized (this._cur._locale) {
/* 2596 */       this._cur._locale.enter();
/*      */       try {
/* 2598 */         return _pop();
/*      */       } finally {
/* 2600 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void selectPath(String paramString) {
/* 2606 */     if (preCheck())
/* 2607 */     { this._cur._locale.enter();
/*      */       try {
/* 2609 */         _selectPath(paramString);
/*      */       } finally {
/* 2611 */         this._cur._locale.exit();
/*      */       }  }
/* 2613 */     else { synchronized (this._cur._locale) {
/* 2614 */         this._cur._locale.enter();
/*      */         try {
/* 2616 */           _selectPath(paramString);
/*      */         } finally {
/* 2618 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void selectPath(String paramString, XmlOptions paramXmlOptions) {
/* 2624 */     if (preCheck())
/* 2625 */     { this._cur._locale.enter();
/*      */       try {
/* 2627 */         _selectPath(paramString, paramXmlOptions);
/*      */       } finally {
/* 2629 */         this._cur._locale.exit();
/*      */       }  }
/* 2631 */     else { synchronized (this._cur._locale) {
/* 2632 */         this._cur._locale.enter();
/*      */         try {
/* 2634 */           _selectPath(paramString, paramXmlOptions);
/*      */         } finally {
/* 2636 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public boolean hasNextSelection() {
/* 2642 */     if (preCheck()) {
/* 2643 */       this._cur._locale.enter();
/*      */       try {
/* 2645 */         return _hasNextSelection();
/*      */       } finally {
/* 2647 */         this._cur._locale.exit();
/*      */       } 
/* 2649 */     }  synchronized (this._cur._locale) {
/* 2650 */       this._cur._locale.enter();
/*      */       try {
/* 2652 */         return _hasNextSelection();
/*      */       } finally {
/* 2654 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toNextSelection() {
/* 2660 */     if (preCheck()) {
/* 2661 */       this._cur._locale.enter();
/*      */       try {
/* 2663 */         return _toNextSelection();
/*      */       } finally {
/* 2665 */         this._cur._locale.exit();
/*      */       } 
/* 2667 */     }  synchronized (this._cur._locale) {
/* 2668 */       this._cur._locale.enter();
/*      */       try {
/* 2670 */         return _toNextSelection();
/*      */       } finally {
/* 2672 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toSelection(int paramInt) {
/* 2678 */     if (preCheck()) {
/* 2679 */       this._cur._locale.enter();
/*      */       try {
/* 2681 */         return _toSelection(paramInt);
/*      */       } finally {
/* 2683 */         this._cur._locale.exit();
/*      */       } 
/* 2685 */     }  synchronized (this._cur._locale) {
/* 2686 */       this._cur._locale.enter();
/*      */       try {
/* 2688 */         return _toSelection(paramInt);
/*      */       } finally {
/* 2690 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getSelectionCount() {
/* 2696 */     if (preCheck()) {
/* 2697 */       this._cur._locale.enter();
/*      */       try {
/* 2699 */         return _getSelectionCount();
/*      */       } finally {
/* 2701 */         this._cur._locale.exit();
/*      */       } 
/* 2703 */     }  synchronized (this._cur._locale) {
/* 2704 */       this._cur._locale.enter();
/*      */       try {
/* 2706 */         return _getSelectionCount();
/*      */       } finally {
/* 2708 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addToSelection() {
/* 2714 */     if (preCheck())
/* 2715 */     { this._cur._locale.enter();
/*      */       try {
/* 2717 */         _addToSelection();
/*      */       } finally {
/* 2719 */         this._cur._locale.exit();
/*      */       }  }
/* 2721 */     else { synchronized (this._cur._locale) {
/* 2722 */         this._cur._locale.enter();
/*      */         try {
/* 2724 */           _addToSelection();
/*      */         } finally {
/* 2726 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void clearSelections() {
/* 2732 */     if (preCheck())
/* 2733 */     { this._cur._locale.enter();
/*      */       try {
/* 2735 */         _clearSelections();
/*      */       } finally {
/* 2737 */         this._cur._locale.exit();
/*      */       }  }
/* 2739 */     else { synchronized (this._cur._locale) {
/* 2740 */         this._cur._locale.enter();
/*      */         try {
/* 2742 */           _clearSelections();
/*      */         } finally {
/* 2744 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public boolean toBookmark(XmlCursor.XmlBookmark paramXmlBookmark) {
/* 2750 */     if (preCheck()) {
/* 2751 */       this._cur._locale.enter();
/*      */       try {
/* 2753 */         return _toBookmark(paramXmlBookmark);
/*      */       } finally {
/* 2755 */         this._cur._locale.exit();
/*      */       } 
/* 2757 */     }  synchronized (this._cur._locale) {
/* 2758 */       this._cur._locale.enter();
/*      */       try {
/* 2760 */         return _toBookmark(paramXmlBookmark);
/*      */       } finally {
/* 2762 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.XmlBookmark toNextBookmark(Object paramObject) {
/* 2768 */     if (preCheck()) {
/* 2769 */       this._cur._locale.enter();
/*      */       try {
/* 2771 */         return _toNextBookmark(paramObject);
/*      */       } finally {
/* 2773 */         this._cur._locale.exit();
/*      */       } 
/* 2775 */     }  synchronized (this._cur._locale) {
/* 2776 */       this._cur._locale.enter();
/*      */       try {
/* 2778 */         return _toNextBookmark(paramObject);
/*      */       } finally {
/* 2780 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.XmlBookmark toPrevBookmark(Object paramObject) {
/* 2786 */     if (preCheck()) {
/* 2787 */       this._cur._locale.enter();
/*      */       try {
/* 2789 */         return _toPrevBookmark(paramObject);
/*      */       } finally {
/* 2791 */         this._cur._locale.exit();
/*      */       } 
/* 2793 */     }  synchronized (this._cur._locale) {
/* 2794 */       this._cur._locale.enter();
/*      */       try {
/* 2796 */         return _toPrevBookmark(paramObject);
/*      */       } finally {
/* 2798 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public b getName() {
/* 2804 */     if (preCheck()) {
/* 2805 */       this._cur._locale.enter();
/*      */       try {
/* 2807 */         return _getName();
/*      */       } finally {
/* 2809 */         this._cur._locale.exit();
/*      */       } 
/* 2811 */     }  synchronized (this._cur._locale) {
/* 2812 */       this._cur._locale.enter();
/*      */       try {
/* 2814 */         return _getName();
/*      */       } finally {
/* 2816 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setName(b paramb) {
/* 2822 */     if (preCheck())
/* 2823 */     { this._cur._locale.enter();
/*      */       try {
/* 2825 */         _setName(paramb);
/*      */       } finally {
/* 2827 */         this._cur._locale.exit();
/*      */       }  }
/* 2829 */     else { synchronized (this._cur._locale) {
/* 2830 */         this._cur._locale.enter();
/*      */         try {
/* 2832 */           _setName(paramb);
/*      */         } finally {
/* 2834 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public String namespaceForPrefix(String paramString) {
/* 2840 */     if (preCheck()) {
/* 2841 */       this._cur._locale.enter();
/*      */       try {
/* 2843 */         return _namespaceForPrefix(paramString);
/*      */       } finally {
/* 2845 */         this._cur._locale.exit();
/*      */       } 
/* 2847 */     }  synchronized (this._cur._locale) {
/* 2848 */       this._cur._locale.enter();
/*      */       try {
/* 2850 */         return _namespaceForPrefix(paramString);
/*      */       } finally {
/* 2852 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String prefixForNamespace(String paramString) {
/* 2858 */     if (preCheck()) {
/* 2859 */       this._cur._locale.enter();
/*      */       try {
/* 2861 */         return _prefixForNamespace(paramString);
/*      */       } finally {
/* 2863 */         this._cur._locale.exit();
/*      */       } 
/* 2865 */     }  synchronized (this._cur._locale) {
/* 2866 */       this._cur._locale.enter();
/*      */       try {
/* 2868 */         return _prefixForNamespace(paramString);
/*      */       } finally {
/* 2870 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void getAllNamespaces(Map paramMap) {
/* 2876 */     if (preCheck())
/* 2877 */     { this._cur._locale.enter();
/*      */       try {
/* 2879 */         _getAllNamespaces(paramMap);
/*      */       } finally {
/* 2881 */         this._cur._locale.exit();
/*      */       }  }
/* 2883 */     else { synchronized (this._cur._locale) {
/* 2884 */         this._cur._locale.enter();
/*      */         try {
/* 2886 */           _getAllNamespaces(paramMap);
/*      */         } finally {
/* 2888 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public XmlObject getObject() {
/* 2894 */     if (preCheck()) {
/* 2895 */       this._cur._locale.enter();
/*      */       try {
/* 2897 */         return _getObject();
/*      */       } finally {
/* 2899 */         this._cur._locale.exit();
/*      */       } 
/* 2901 */     }  synchronized (this._cur._locale) {
/* 2902 */       this._cur._locale.enter();
/*      */       try {
/* 2904 */         return _getObject();
/*      */       } finally {
/* 2906 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType currentTokenType() {
/* 2912 */     if (preCheck())
/*      */     {
/*      */       
/* 2915 */       return _currentTokenType();
/*      */     }
/*      */ 
/*      */     
/* 2919 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 2922 */       return _currentTokenType();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStartdoc() {
/* 2930 */     if (preCheck())
/*      */     {
/*      */       
/* 2933 */       return _isStartdoc();
/*      */     }
/*      */ 
/*      */     
/* 2937 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 2940 */       return _isStartdoc();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnddoc() {
/* 2948 */     if (preCheck())
/*      */     {
/*      */       
/* 2951 */       return _isEnddoc();
/*      */     }
/*      */ 
/*      */     
/* 2955 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 2958 */       return _isEnddoc();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isStart() {
/* 2966 */     if (preCheck())
/*      */     {
/*      */       
/* 2969 */       return _isStart();
/*      */     }
/*      */ 
/*      */     
/* 2973 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 2976 */       return _isStart();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isEnd() {
/* 2984 */     if (preCheck())
/*      */     {
/*      */       
/* 2987 */       return _isEnd();
/*      */     }
/*      */ 
/*      */     
/* 2991 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 2994 */       return _isEnd();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isText() {
/* 3002 */     if (preCheck())
/*      */     {
/*      */       
/* 3005 */       return _isText();
/*      */     }
/*      */ 
/*      */     
/* 3009 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3012 */       return _isText();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAttr() {
/* 3020 */     if (preCheck())
/*      */     {
/*      */       
/* 3023 */       return _isAttr();
/*      */     }
/*      */ 
/*      */     
/* 3027 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3030 */       return _isAttr();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isNamespace() {
/* 3038 */     if (preCheck())
/*      */     {
/*      */       
/* 3041 */       return _isNamespace();
/*      */     }
/*      */ 
/*      */     
/* 3045 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3048 */       return _isNamespace();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isComment() {
/* 3056 */     if (preCheck())
/*      */     {
/*      */       
/* 3059 */       return _isComment();
/*      */     }
/*      */ 
/*      */     
/* 3063 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3066 */       return _isComment();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isProcinst() {
/* 3074 */     if (preCheck())
/*      */     {
/*      */       
/* 3077 */       return _isProcinst();
/*      */     }
/*      */ 
/*      */     
/* 3081 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3084 */       return _isProcinst();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isContainer() {
/* 3092 */     if (preCheck())
/*      */     {
/*      */       
/* 3095 */       return _isContainer();
/*      */     }
/*      */ 
/*      */     
/* 3099 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3102 */       return _isContainer();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isFinish() {
/* 3110 */     if (preCheck())
/*      */     {
/*      */       
/* 3113 */       return _isFinish();
/*      */     }
/*      */ 
/*      */     
/* 3117 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3120 */       return _isFinish();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isAnyAttr() {
/* 3128 */     if (preCheck())
/*      */     {
/*      */       
/* 3131 */       return _isAnyAttr();
/*      */     }
/*      */ 
/*      */     
/* 3135 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3138 */       return _isAnyAttr();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlCursor.TokenType prevTokenType() {
/* 3146 */     if (preCheck()) {
/* 3147 */       this._cur._locale.enter();
/*      */       try {
/* 3149 */         return _prevTokenType();
/*      */       } finally {
/* 3151 */         this._cur._locale.exit();
/*      */       } 
/* 3153 */     }  synchronized (this._cur._locale) {
/* 3154 */       this._cur._locale.enter();
/*      */       try {
/* 3156 */         return _prevTokenType();
/*      */       } finally {
/* 3158 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean hasNextToken() {
/* 3164 */     if (preCheck())
/*      */     {
/*      */       
/* 3167 */       return _hasNextToken();
/*      */     }
/*      */ 
/*      */     
/* 3171 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3174 */       return _hasNextToken();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean hasPrevToken() {
/* 3182 */     if (preCheck()) {
/* 3183 */       this._cur._locale.enter();
/*      */       try {
/* 3185 */         return _hasPrevToken();
/*      */       } finally {
/* 3187 */         this._cur._locale.exit();
/*      */       } 
/* 3189 */     }  synchronized (this._cur._locale) {
/* 3190 */       this._cur._locale.enter();
/*      */       try {
/* 3192 */         return _hasPrevToken();
/*      */       } finally {
/* 3194 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType toNextToken() {
/* 3200 */     if (preCheck()) {
/* 3201 */       this._cur._locale.enter();
/*      */       try {
/* 3203 */         return _toNextToken();
/*      */       } finally {
/* 3205 */         this._cur._locale.exit();
/*      */       } 
/* 3207 */     }  synchronized (this._cur._locale) {
/* 3208 */       this._cur._locale.enter();
/*      */       try {
/* 3210 */         return _toNextToken();
/*      */       } finally {
/* 3212 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType toPrevToken() {
/* 3218 */     if (preCheck()) {
/* 3219 */       this._cur._locale.enter();
/*      */       try {
/* 3221 */         return _toPrevToken();
/*      */       } finally {
/* 3223 */         this._cur._locale.exit();
/*      */       } 
/* 3225 */     }  synchronized (this._cur._locale) {
/* 3226 */       this._cur._locale.enter();
/*      */       try {
/* 3228 */         return _toPrevToken();
/*      */       } finally {
/* 3230 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType toFirstContentToken() {
/* 3236 */     if (preCheck()) {
/* 3237 */       this._cur._locale.enter();
/*      */       try {
/* 3239 */         return _toFirstContentToken();
/*      */       } finally {
/* 3241 */         this._cur._locale.exit();
/*      */       } 
/* 3243 */     }  synchronized (this._cur._locale) {
/* 3244 */       this._cur._locale.enter();
/*      */       try {
/* 3246 */         return _toFirstContentToken();
/*      */       } finally {
/* 3248 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.TokenType toEndToken() {
/* 3254 */     if (preCheck()) {
/* 3255 */       this._cur._locale.enter();
/*      */       try {
/* 3257 */         return _toEndToken();
/*      */       } finally {
/* 3259 */         this._cur._locale.exit();
/*      */       } 
/* 3261 */     }  synchronized (this._cur._locale) {
/* 3262 */       this._cur._locale.enter();
/*      */       try {
/* 3264 */         return _toEndToken();
/*      */       } finally {
/* 3266 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int toNextChar(int paramInt) {
/* 3272 */     if (preCheck()) {
/* 3273 */       this._cur._locale.enter();
/*      */       try {
/* 3275 */         return _toNextChar(paramInt);
/*      */       } finally {
/* 3277 */         this._cur._locale.exit();
/*      */       } 
/* 3279 */     }  synchronized (this._cur._locale) {
/* 3280 */       this._cur._locale.enter();
/*      */       try {
/* 3282 */         return _toNextChar(paramInt);
/*      */       } finally {
/* 3284 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int toPrevChar(int paramInt) {
/* 3290 */     if (preCheck()) {
/* 3291 */       this._cur._locale.enter();
/*      */       try {
/* 3293 */         return _toPrevChar(paramInt);
/*      */       } finally {
/* 3295 */         this._cur._locale.exit();
/*      */       } 
/* 3297 */     }  synchronized (this._cur._locale) {
/* 3298 */       this._cur._locale.enter();
/*      */       try {
/* 3300 */         return _toPrevChar(paramInt);
/*      */       } finally {
/* 3302 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean ___toNextSibling() {
/* 3314 */     if (!this._cur.hasParent()) {
/* 3315 */       return false;
/*      */     }
/* 3317 */     Xobj xobj = this._cur.getParentNoRoot();
/*      */     
/* 3319 */     if (xobj == null) {
/*      */       
/* 3321 */       this._cur._locale.enter();
/*      */       
/*      */       try {
/* 3324 */         xobj = this._cur.getParent();
/*      */       } finally {
/* 3326 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */     
/* 3330 */     return Locale.toNextSiblingElement(this._cur, xobj);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean toNextSibling() {
/* 3335 */     if (preCheck())
/* 3336 */       return ___toNextSibling(); 
/* 3337 */     synchronized (this._cur._locale) {
/* 3338 */       return ___toNextSibling();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toPrevSibling() {
/* 3343 */     if (preCheck()) {
/* 3344 */       this._cur._locale.enter();
/*      */       try {
/* 3346 */         return _toPrevSibling();
/*      */       } finally {
/* 3348 */         this._cur._locale.exit();
/*      */       } 
/* 3350 */     }  synchronized (this._cur._locale) {
/* 3351 */       this._cur._locale.enter();
/*      */       try {
/* 3353 */         return _toPrevSibling();
/*      */       } finally {
/* 3355 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toParent() {
/* 3361 */     if (preCheck()) {
/* 3362 */       this._cur._locale.enter();
/*      */       try {
/* 3364 */         return _toParent();
/*      */       } finally {
/* 3366 */         this._cur._locale.exit();
/*      */       } 
/* 3368 */     }  synchronized (this._cur._locale) {
/* 3369 */       this._cur._locale.enter();
/*      */       try {
/* 3371 */         return _toParent();
/*      */       } finally {
/* 3373 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toFirstChild() {
/* 3379 */     if (preCheck())
/*      */     {
/*      */       
/* 3382 */       return _toFirstChild();
/*      */     }
/*      */ 
/*      */     
/* 3386 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3389 */       return _toFirstChild();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean toLastChild() {
/* 3397 */     if (preCheck()) {
/* 3398 */       this._cur._locale.enter();
/*      */       try {
/* 3400 */         return _toLastChild();
/*      */       } finally {
/* 3402 */         this._cur._locale.exit();
/*      */       } 
/* 3404 */     }  synchronized (this._cur._locale) {
/* 3405 */       this._cur._locale.enter();
/*      */       try {
/* 3407 */         return _toLastChild();
/*      */       } finally {
/* 3409 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toChild(String paramString) {
/* 3415 */     if (preCheck()) {
/* 3416 */       this._cur._locale.enter();
/*      */       try {
/* 3418 */         return _toChild(paramString);
/*      */       } finally {
/* 3420 */         this._cur._locale.exit();
/*      */       } 
/* 3422 */     }  synchronized (this._cur._locale) {
/* 3423 */       this._cur._locale.enter();
/*      */       try {
/* 3425 */         return _toChild(paramString);
/*      */       } finally {
/* 3427 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toChild(String paramString1, String paramString2) {
/* 3433 */     if (preCheck()) {
/* 3434 */       this._cur._locale.enter();
/*      */       try {
/* 3436 */         return _toChild(paramString1, paramString2);
/*      */       } finally {
/* 3438 */         this._cur._locale.exit();
/*      */       } 
/* 3440 */     }  synchronized (this._cur._locale) {
/* 3441 */       this._cur._locale.enter();
/*      */       try {
/* 3443 */         return _toChild(paramString1, paramString2);
/*      */       } finally {
/* 3445 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toChild(b paramb) {
/* 3451 */     if (preCheck()) {
/* 3452 */       this._cur._locale.enter();
/*      */       try {
/* 3454 */         return _toChild(paramb);
/*      */       } finally {
/* 3456 */         this._cur._locale.exit();
/*      */       } 
/* 3458 */     }  synchronized (this._cur._locale) {
/* 3459 */       this._cur._locale.enter();
/*      */       try {
/* 3461 */         return _toChild(paramb);
/*      */       } finally {
/* 3463 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toChild(int paramInt) {
/* 3469 */     if (preCheck()) {
/* 3470 */       this._cur._locale.enter();
/*      */       try {
/* 3472 */         return _toChild(paramInt);
/*      */       } finally {
/* 3474 */         this._cur._locale.exit();
/*      */       } 
/* 3476 */     }  synchronized (this._cur._locale) {
/* 3477 */       this._cur._locale.enter();
/*      */       try {
/* 3479 */         return _toChild(paramInt);
/*      */       } finally {
/* 3481 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toChild(b paramb, int paramInt) {
/* 3487 */     if (preCheck()) {
/* 3488 */       this._cur._locale.enter();
/*      */       try {
/* 3490 */         return _toChild(paramb, paramInt);
/*      */       } finally {
/* 3492 */         this._cur._locale.exit();
/*      */       } 
/* 3494 */     }  synchronized (this._cur._locale) {
/* 3495 */       this._cur._locale.enter();
/*      */       try {
/* 3497 */         return _toChild(paramb, paramInt);
/*      */       } finally {
/* 3499 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toNextSibling(String paramString) {
/* 3505 */     if (preCheck()) {
/* 3506 */       this._cur._locale.enter();
/*      */       try {
/* 3508 */         return _toNextSibling(paramString);
/*      */       } finally {
/* 3510 */         this._cur._locale.exit();
/*      */       } 
/* 3512 */     }  synchronized (this._cur._locale) {
/* 3513 */       this._cur._locale.enter();
/*      */       try {
/* 3515 */         return _toNextSibling(paramString);
/*      */       } finally {
/* 3517 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toNextSibling(String paramString1, String paramString2) {
/* 3523 */     if (preCheck()) {
/* 3524 */       this._cur._locale.enter();
/*      */       try {
/* 3526 */         return _toNextSibling(paramString1, paramString2);
/*      */       } finally {
/* 3528 */         this._cur._locale.exit();
/*      */       } 
/* 3530 */     }  synchronized (this._cur._locale) {
/* 3531 */       this._cur._locale.enter();
/*      */       try {
/* 3533 */         return _toNextSibling(paramString1, paramString2);
/*      */       } finally {
/* 3535 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toNextSibling(b paramb) {
/* 3541 */     if (preCheck()) {
/* 3542 */       this._cur._locale.enter();
/*      */       try {
/* 3544 */         return _toNextSibling(paramb);
/*      */       } finally {
/* 3546 */         this._cur._locale.exit();
/*      */       } 
/* 3548 */     }  synchronized (this._cur._locale) {
/* 3549 */       this._cur._locale.enter();
/*      */       try {
/* 3551 */         return _toNextSibling(paramb);
/*      */       } finally {
/* 3553 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toFirstAttribute() {
/* 3559 */     if (preCheck())
/*      */     {
/*      */       
/* 3562 */       return _toFirstAttribute();
/*      */     }
/*      */ 
/*      */     
/* 3566 */     synchronized (this._cur._locale) {
/*      */ 
/*      */       
/* 3569 */       return _toFirstAttribute();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean toLastAttribute() {
/* 3577 */     if (preCheck()) {
/* 3578 */       this._cur._locale.enter();
/*      */       try {
/* 3580 */         return _toLastAttribute();
/*      */       } finally {
/* 3582 */         this._cur._locale.exit();
/*      */       } 
/* 3584 */     }  synchronized (this._cur._locale) {
/* 3585 */       this._cur._locale.enter();
/*      */       try {
/* 3587 */         return _toLastAttribute();
/*      */       } finally {
/* 3589 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toNextAttribute() {
/* 3595 */     if (preCheck()) {
/* 3596 */       this._cur._locale.enter();
/*      */       try {
/* 3598 */         return _toNextAttribute();
/*      */       } finally {
/* 3600 */         this._cur._locale.exit();
/*      */       } 
/* 3602 */     }  synchronized (this._cur._locale) {
/* 3603 */       this._cur._locale.enter();
/*      */       try {
/* 3605 */         return _toNextAttribute();
/*      */       } finally {
/* 3607 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean toPrevAttribute() {
/* 3613 */     if (preCheck()) {
/* 3614 */       this._cur._locale.enter();
/*      */       try {
/* 3616 */         return _toPrevAttribute();
/*      */       } finally {
/* 3618 */         this._cur._locale.exit();
/*      */       } 
/* 3620 */     }  synchronized (this._cur._locale) {
/* 3621 */       this._cur._locale.enter();
/*      */       try {
/* 3623 */         return _toPrevAttribute();
/*      */       } finally {
/* 3625 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getAttributeText(b paramb) {
/* 3631 */     if (preCheck()) {
/* 3632 */       this._cur._locale.enter();
/*      */       try {
/* 3634 */         return _getAttributeText(paramb);
/*      */       } finally {
/* 3636 */         this._cur._locale.exit();
/*      */       } 
/* 3638 */     }  synchronized (this._cur._locale) {
/* 3639 */       this._cur._locale.enter();
/*      */       try {
/* 3641 */         return _getAttributeText(paramb);
/*      */       } finally {
/* 3643 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean setAttributeText(b paramb, String paramString) {
/* 3649 */     if (preCheck()) {
/* 3650 */       this._cur._locale.enter();
/*      */       try {
/* 3652 */         return _setAttributeText(paramb, paramString);
/*      */       } finally {
/* 3654 */         this._cur._locale.exit();
/*      */       } 
/* 3656 */     }  synchronized (this._cur._locale) {
/* 3657 */       this._cur._locale.enter();
/*      */       try {
/* 3659 */         return _setAttributeText(paramb, paramString);
/*      */       } finally {
/* 3661 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean removeAttribute(b paramb) {
/* 3667 */     if (preCheck()) {
/* 3668 */       this._cur._locale.enter();
/*      */       try {
/* 3670 */         return _removeAttribute(paramb);
/*      */       } finally {
/* 3672 */         this._cur._locale.exit();
/*      */       } 
/* 3674 */     }  synchronized (this._cur._locale) {
/* 3675 */       this._cur._locale.enter();
/*      */       try {
/* 3677 */         return _removeAttribute(paramb);
/*      */       } finally {
/* 3679 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getTextValue() {
/* 3685 */     if (preCheck()) {
/* 3686 */       this._cur._locale.enter();
/*      */       try {
/* 3688 */         return _getTextValue();
/*      */       } finally {
/* 3690 */         this._cur._locale.exit();
/*      */       } 
/* 3692 */     }  synchronized (this._cur._locale) {
/* 3693 */       this._cur._locale.enter();
/*      */       try {
/* 3695 */         return _getTextValue();
/*      */       } finally {
/* 3697 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 3703 */     if (preCheck()) {
/* 3704 */       this._cur._locale.enter();
/*      */       try {
/* 3706 */         return _getTextValue(paramArrayOfchar, paramInt1, paramInt2);
/*      */       } finally {
/* 3708 */         this._cur._locale.exit();
/*      */       } 
/* 3710 */     }  synchronized (this._cur._locale) {
/* 3711 */       this._cur._locale.enter();
/*      */       try {
/* 3713 */         return _getTextValue(paramArrayOfchar, paramInt1, paramInt2);
/*      */       } finally {
/* 3715 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setTextValue(String paramString) {
/* 3721 */     if (preCheck())
/* 3722 */     { this._cur._locale.enter();
/*      */       try {
/* 3724 */         _setTextValue(paramString);
/*      */       } finally {
/* 3726 */         this._cur._locale.exit();
/*      */       }  }
/* 3728 */     else { synchronized (this._cur._locale) {
/* 3729 */         this._cur._locale.enter();
/*      */         try {
/* 3731 */           _setTextValue(paramString);
/*      */         } finally {
/* 3733 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void setTextValue(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 3739 */     if (preCheck())
/* 3740 */     { this._cur._locale.enter();
/*      */       try {
/* 3742 */         _setTextValue(paramArrayOfchar, paramInt1, paramInt2);
/*      */       } finally {
/* 3744 */         this._cur._locale.exit();
/*      */       }  }
/* 3746 */     else { synchronized (this._cur._locale) {
/* 3747 */         this._cur._locale.enter();
/*      */         try {
/* 3749 */           _setTextValue(paramArrayOfchar, paramInt1, paramInt2);
/*      */         } finally {
/* 3751 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public String getChars() {
/* 3757 */     if (preCheck()) {
/* 3758 */       this._cur._locale.enter();
/*      */       try {
/* 3760 */         return _getChars();
/*      */       } finally {
/* 3762 */         this._cur._locale.exit();
/*      */       } 
/* 3764 */     }  synchronized (this._cur._locale) {
/* 3765 */       this._cur._locale.enter();
/*      */       try {
/* 3767 */         return _getChars();
/*      */       } finally {
/* 3769 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getChars(char[] paramArrayOfchar, int paramInt1, int paramInt2) {
/* 3775 */     if (preCheck()) {
/* 3776 */       this._cur._locale.enter();
/*      */       try {
/* 3778 */         return _getChars(paramArrayOfchar, paramInt1, paramInt2);
/*      */       } finally {
/* 3780 */         this._cur._locale.exit();
/*      */       } 
/* 3782 */     }  synchronized (this._cur._locale) {
/* 3783 */       this._cur._locale.enter();
/*      */       try {
/* 3785 */         return _getChars(paramArrayOfchar, paramInt1, paramInt2);
/*      */       } finally {
/* 3787 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void toStartDoc() {
/* 3793 */     if (preCheck()) {
/*      */ 
/*      */       
/* 3796 */       _toStartDoc();
/*      */     }
/*      */     else {
/*      */       
/* 3800 */       synchronized (this._cur._locale) {
/*      */ 
/*      */         
/* 3803 */         _toStartDoc();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void toEndDoc() {
/* 3811 */     if (preCheck()) {
/*      */ 
/*      */       
/* 3814 */       _toEndDoc();
/*      */     }
/*      */     else {
/*      */       
/* 3818 */       synchronized (this._cur._locale) {
/*      */ 
/*      */         
/* 3821 */         _toEndDoc();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public XmlCursor execQuery(String paramString) {
/* 3829 */     if (preCheck()) {
/* 3830 */       this._cur._locale.enter();
/*      */       try {
/* 3832 */         return _execQuery(paramString);
/*      */       } finally {
/* 3834 */         this._cur._locale.exit();
/*      */       } 
/* 3836 */     }  synchronized (this._cur._locale) {
/* 3837 */       this._cur._locale.enter();
/*      */       try {
/* 3839 */         return _execQuery(paramString);
/*      */       } finally {
/* 3841 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor execQuery(String paramString, XmlOptions paramXmlOptions) {
/* 3847 */     if (preCheck()) {
/* 3848 */       this._cur._locale.enter();
/*      */       try {
/* 3850 */         return _execQuery(paramString, paramXmlOptions);
/*      */       } finally {
/* 3852 */         this._cur._locale.exit();
/*      */       } 
/* 3854 */     }  synchronized (this._cur._locale) {
/* 3855 */       this._cur._locale.enter();
/*      */       try {
/* 3857 */         return _execQuery(paramString, paramXmlOptions);
/*      */       } finally {
/* 3859 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public XmlCursor.ChangeStamp getDocChangeStamp() {
/* 3865 */     if (preCheck()) {
/* 3866 */       this._cur._locale.enter();
/*      */       try {
/* 3868 */         return _getDocChangeStamp();
/*      */       } finally {
/* 3870 */         this._cur._locale.exit();
/*      */       } 
/* 3872 */     }  synchronized (this._cur._locale) {
/* 3873 */       this._cur._locale.enter();
/*      */       try {
/* 3875 */         return _getDocChangeStamp();
/*      */       } finally {
/* 3877 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setBookmark(XmlCursor.XmlBookmark paramXmlBookmark) {
/* 3883 */     if (preCheck())
/* 3884 */     { this._cur._locale.enter();
/*      */       try {
/* 3886 */         _setBookmark(paramXmlBookmark);
/*      */       } finally {
/* 3888 */         this._cur._locale.exit();
/*      */       }  }
/* 3890 */     else { synchronized (this._cur._locale) {
/* 3891 */         this._cur._locale.enter();
/*      */         try {
/* 3893 */           _setBookmark(paramXmlBookmark);
/*      */         } finally {
/* 3895 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public XmlCursor.XmlBookmark getBookmark(Object paramObject) {
/* 3901 */     if (preCheck()) {
/* 3902 */       this._cur._locale.enter();
/*      */       try {
/* 3904 */         return _getBookmark(paramObject);
/*      */       } finally {
/* 3906 */         this._cur._locale.exit();
/*      */       } 
/* 3908 */     }  synchronized (this._cur._locale) {
/* 3909 */       this._cur._locale.enter();
/*      */       try {
/* 3911 */         return _getBookmark(paramObject);
/*      */       } finally {
/* 3913 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void clearBookmark(Object paramObject) {
/* 3919 */     if (preCheck())
/* 3920 */     { this._cur._locale.enter();
/*      */       try {
/* 3922 */         _clearBookmark(paramObject);
/*      */       } finally {
/* 3924 */         this._cur._locale.exit();
/*      */       }  }
/* 3926 */     else { synchronized (this._cur._locale) {
/* 3927 */         this._cur._locale.enter();
/*      */         try {
/* 3929 */           _clearBookmark(paramObject);
/*      */         } finally {
/* 3931 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void getAllBookmarkRefs(Collection paramCollection) {
/* 3937 */     if (preCheck())
/* 3938 */     { this._cur._locale.enter();
/*      */       try {
/* 3940 */         _getAllBookmarkRefs(paramCollection);
/*      */       } finally {
/* 3942 */         this._cur._locale.exit();
/*      */       }  }
/* 3944 */     else { synchronized (this._cur._locale) {
/* 3945 */         this._cur._locale.enter();
/*      */         try {
/* 3947 */           _getAllBookmarkRefs(paramCollection);
/*      */         } finally {
/* 3949 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public boolean removeXml() {
/* 3955 */     if (preCheck()) {
/* 3956 */       this._cur._locale.enter();
/*      */       try {
/* 3958 */         return _removeXml();
/*      */       } finally {
/* 3960 */         this._cur._locale.exit();
/*      */       } 
/* 3962 */     }  synchronized (this._cur._locale) {
/* 3963 */       this._cur._locale.enter();
/*      */       try {
/* 3965 */         return _removeXml();
/*      */       } finally {
/* 3967 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean removeXmlContents() {
/* 3973 */     if (preCheck()) {
/* 3974 */       this._cur._locale.enter();
/*      */       try {
/* 3976 */         return _removeXmlContents();
/*      */       } finally {
/* 3978 */         this._cur._locale.exit();
/*      */       } 
/* 3980 */     }  synchronized (this._cur._locale) {
/* 3981 */       this._cur._locale.enter();
/*      */       try {
/* 3983 */         return _removeXmlContents();
/*      */       } finally {
/* 3985 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int removeChars(int paramInt) {
/* 3991 */     if (preCheck()) {
/* 3992 */       this._cur._locale.enter();
/*      */       try {
/* 3994 */         return _removeChars(paramInt);
/*      */       } finally {
/* 3996 */         this._cur._locale.exit();
/*      */       } 
/* 3998 */     }  synchronized (this._cur._locale) {
/* 3999 */       this._cur._locale.enter();
/*      */       try {
/* 4001 */         return _removeChars(paramInt);
/*      */       } finally {
/* 4003 */         this._cur._locale.exit();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void insertChars(String paramString) {
/* 4009 */     if (preCheck())
/* 4010 */     { this._cur._locale.enter();
/*      */       try {
/* 4012 */         _insertChars(paramString);
/*      */       } finally {
/* 4014 */         this._cur._locale.exit();
/*      */       }  }
/* 4016 */     else { synchronized (this._cur._locale) {
/* 4017 */         this._cur._locale.enter();
/*      */         try {
/* 4019 */           _insertChars(paramString);
/*      */         } finally {
/* 4021 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElement(b paramb) {
/* 4027 */     if (preCheck())
/* 4028 */     { this._cur._locale.enter();
/*      */       try {
/* 4030 */         _insertElement(paramb);
/*      */       } finally {
/* 4032 */         this._cur._locale.exit();
/*      */       }  }
/* 4034 */     else { synchronized (this._cur._locale) {
/* 4035 */         this._cur._locale.enter();
/*      */         try {
/* 4037 */           _insertElement(paramb);
/*      */         } finally {
/* 4039 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElement(String paramString) {
/* 4045 */     if (preCheck())
/* 4046 */     { this._cur._locale.enter();
/*      */       try {
/* 4048 */         _insertElement(paramString);
/*      */       } finally {
/* 4050 */         this._cur._locale.exit();
/*      */       }  }
/* 4052 */     else { synchronized (this._cur._locale) {
/* 4053 */         this._cur._locale.enter();
/*      */         try {
/* 4055 */           _insertElement(paramString);
/*      */         } finally {
/* 4057 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElement(String paramString1, String paramString2) {
/* 4063 */     if (preCheck())
/* 4064 */     { this._cur._locale.enter();
/*      */       try {
/* 4066 */         _insertElement(paramString1, paramString2);
/*      */       } finally {
/* 4068 */         this._cur._locale.exit();
/*      */       }  }
/* 4070 */     else { synchronized (this._cur._locale) {
/* 4071 */         this._cur._locale.enter();
/*      */         try {
/* 4073 */           _insertElement(paramString1, paramString2);
/*      */         } finally {
/* 4075 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void beginElement(b paramb) {
/* 4081 */     if (preCheck())
/* 4082 */     { this._cur._locale.enter();
/*      */       try {
/* 4084 */         _beginElement(paramb);
/*      */       } finally {
/* 4086 */         this._cur._locale.exit();
/*      */       }  }
/* 4088 */     else { synchronized (this._cur._locale) {
/* 4089 */         this._cur._locale.enter();
/*      */         try {
/* 4091 */           _beginElement(paramb);
/*      */         } finally {
/* 4093 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void beginElement(String paramString) {
/* 4099 */     if (preCheck())
/* 4100 */     { this._cur._locale.enter();
/*      */       try {
/* 4102 */         _beginElement(paramString);
/*      */       } finally {
/* 4104 */         this._cur._locale.exit();
/*      */       }  }
/* 4106 */     else { synchronized (this._cur._locale) {
/* 4107 */         this._cur._locale.enter();
/*      */         try {
/* 4109 */           _beginElement(paramString);
/*      */         } finally {
/* 4111 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void beginElement(String paramString1, String paramString2) {
/* 4117 */     if (preCheck())
/* 4118 */     { this._cur._locale.enter();
/*      */       try {
/* 4120 */         _beginElement(paramString1, paramString2);
/*      */       } finally {
/* 4122 */         this._cur._locale.exit();
/*      */       }  }
/* 4124 */     else { synchronized (this._cur._locale) {
/* 4125 */         this._cur._locale.enter();
/*      */         try {
/* 4127 */           _beginElement(paramString1, paramString2);
/*      */         } finally {
/* 4129 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElementWithText(b paramb, String paramString) {
/* 4135 */     if (preCheck())
/* 4136 */     { this._cur._locale.enter();
/*      */       try {
/* 4138 */         _insertElementWithText(paramb, paramString);
/*      */       } finally {
/* 4140 */         this._cur._locale.exit();
/*      */       }  }
/* 4142 */     else { synchronized (this._cur._locale) {
/* 4143 */         this._cur._locale.enter();
/*      */         try {
/* 4145 */           _insertElementWithText(paramb, paramString);
/*      */         } finally {
/* 4147 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElementWithText(String paramString1, String paramString2) {
/* 4153 */     if (preCheck())
/* 4154 */     { this._cur._locale.enter();
/*      */       try {
/* 4156 */         _insertElementWithText(paramString1, paramString2);
/*      */       } finally {
/* 4158 */         this._cur._locale.exit();
/*      */       }  }
/* 4160 */     else { synchronized (this._cur._locale) {
/* 4161 */         this._cur._locale.enter();
/*      */         try {
/* 4163 */           _insertElementWithText(paramString1, paramString2);
/*      */         } finally {
/* 4165 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertElementWithText(String paramString1, String paramString2, String paramString3) {
/* 4171 */     if (preCheck())
/* 4172 */     { this._cur._locale.enter();
/*      */       try {
/* 4174 */         _insertElementWithText(paramString1, paramString2, paramString3);
/*      */       } finally {
/* 4176 */         this._cur._locale.exit();
/*      */       }  }
/* 4178 */     else { synchronized (this._cur._locale) {
/* 4179 */         this._cur._locale.enter();
/*      */         try {
/* 4181 */           _insertElementWithText(paramString1, paramString2, paramString3);
/*      */         } finally {
/* 4183 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttribute(String paramString) {
/* 4189 */     if (preCheck())
/* 4190 */     { this._cur._locale.enter();
/*      */       try {
/* 4192 */         _insertAttribute(paramString);
/*      */       } finally {
/* 4194 */         this._cur._locale.exit();
/*      */       }  }
/* 4196 */     else { synchronized (this._cur._locale) {
/* 4197 */         this._cur._locale.enter();
/*      */         try {
/* 4199 */           _insertAttribute(paramString);
/*      */         } finally {
/* 4201 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttribute(String paramString1, String paramString2) {
/* 4207 */     if (preCheck())
/* 4208 */     { this._cur._locale.enter();
/*      */       try {
/* 4210 */         _insertAttribute(paramString1, paramString2);
/*      */       } finally {
/* 4212 */         this._cur._locale.exit();
/*      */       }  }
/* 4214 */     else { synchronized (this._cur._locale) {
/* 4215 */         this._cur._locale.enter();
/*      */         try {
/* 4217 */           _insertAttribute(paramString1, paramString2);
/*      */         } finally {
/* 4219 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttribute(b paramb) {
/* 4225 */     if (preCheck())
/* 4226 */     { this._cur._locale.enter();
/*      */       try {
/* 4228 */         _insertAttribute(paramb);
/*      */       } finally {
/* 4230 */         this._cur._locale.exit();
/*      */       }  }
/* 4232 */     else { synchronized (this._cur._locale) {
/* 4233 */         this._cur._locale.enter();
/*      */         try {
/* 4235 */           _insertAttribute(paramb);
/*      */         } finally {
/* 4237 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttributeWithValue(String paramString1, String paramString2) {
/* 4243 */     if (preCheck())
/* 4244 */     { this._cur._locale.enter();
/*      */       try {
/* 4246 */         _insertAttributeWithValue(paramString1, paramString2);
/*      */       } finally {
/* 4248 */         this._cur._locale.exit();
/*      */       }  }
/* 4250 */     else { synchronized (this._cur._locale) {
/* 4251 */         this._cur._locale.enter();
/*      */         try {
/* 4253 */           _insertAttributeWithValue(paramString1, paramString2);
/*      */         } finally {
/* 4255 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttributeWithValue(String paramString1, String paramString2, String paramString3) {
/* 4261 */     if (preCheck())
/* 4262 */     { this._cur._locale.enter();
/*      */       try {
/* 4264 */         _insertAttributeWithValue(paramString1, paramString2, paramString3);
/*      */       } finally {
/* 4266 */         this._cur._locale.exit();
/*      */       }  }
/* 4268 */     else { synchronized (this._cur._locale) {
/* 4269 */         this._cur._locale.enter();
/*      */         try {
/* 4271 */           _insertAttributeWithValue(paramString1, paramString2, paramString3);
/*      */         } finally {
/* 4273 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertAttributeWithValue(b paramb, String paramString) {
/* 4279 */     if (preCheck())
/* 4280 */     { this._cur._locale.enter();
/*      */       try {
/* 4282 */         _insertAttributeWithValue(paramb, paramString);
/*      */       } finally {
/* 4284 */         this._cur._locale.exit();
/*      */       }  }
/* 4286 */     else { synchronized (this._cur._locale) {
/* 4287 */         this._cur._locale.enter();
/*      */         try {
/* 4289 */           _insertAttributeWithValue(paramb, paramString);
/*      */         } finally {
/* 4291 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertNamespace(String paramString1, String paramString2) {
/* 4297 */     if (preCheck())
/* 4298 */     { this._cur._locale.enter();
/*      */       try {
/* 4300 */         _insertNamespace(paramString1, paramString2);
/*      */       } finally {
/* 4302 */         this._cur._locale.exit();
/*      */       }  }
/* 4304 */     else { synchronized (this._cur._locale) {
/* 4305 */         this._cur._locale.enter();
/*      */         try {
/* 4307 */           _insertNamespace(paramString1, paramString2);
/*      */         } finally {
/* 4309 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertComment(String paramString) {
/* 4315 */     if (preCheck())
/* 4316 */     { this._cur._locale.enter();
/*      */       try {
/* 4318 */         _insertComment(paramString);
/*      */       } finally {
/* 4320 */         this._cur._locale.exit();
/*      */       }  }
/* 4322 */     else { synchronized (this._cur._locale) {
/* 4323 */         this._cur._locale.enter();
/*      */         try {
/* 4325 */           _insertComment(paramString);
/*      */         } finally {
/* 4327 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void insertProcInst(String paramString1, String paramString2) {
/* 4333 */     if (preCheck())
/* 4334 */     { this._cur._locale.enter();
/*      */       try {
/* 4336 */         _insertProcInst(paramString1, paramString2);
/*      */       } finally {
/* 4338 */         this._cur._locale.exit();
/*      */       }  }
/* 4340 */     else { synchronized (this._cur._locale) {
/* 4341 */         this._cur._locale.enter();
/*      */         try {
/* 4343 */           _insertProcInst(paramString1, paramString2);
/*      */         } finally {
/* 4345 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */   public void dump() {
/* 4351 */     if (preCheck())
/* 4352 */     { this._cur._locale.enter();
/*      */       try {
/* 4354 */         _dump();
/*      */       } finally {
/* 4356 */         this._cur._locale.exit();
/*      */       }  }
/* 4358 */     else { synchronized (this._cur._locale) {
/* 4359 */         this._cur._locale.enter();
/*      */         try {
/* 4361 */           _dump();
/*      */         } finally {
/* 4363 */           this._cur._locale.exit();
/*      */         } 
/*      */       }  }
/*      */   
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Cursor.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */