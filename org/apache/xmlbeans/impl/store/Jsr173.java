/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.util.ConcurrentModificationException;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import javax.xml.namespace.a;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.stream.Location;
/*      */ import javax.xml.stream.XMLStreamException;
/*      */ import javax.xml.stream.XMLStreamReader;
/*      */ import org.apache.xmlbeans.XmlDocumentProperties;
/*      */ import org.apache.xmlbeans.XmlLineNumber;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.w3c.dom.Node;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Jsr173
/*      */ {
/*      */   static final boolean $assertionsDisabled;
/*      */   static Class class$org$apache$xmlbeans$XmlLineNumber;
/*      */   
/*      */   public static Node nodeFromStream(XMLStreamReader paramXMLStreamReader) {
/*   41 */     if (!(paramXMLStreamReader instanceof Jsr173GateWay)) {
/*   42 */       return null;
/*      */     }
/*   44 */     Jsr173GateWay jsr173GateWay = (Jsr173GateWay)paramXMLStreamReader;
/*      */     
/*   46 */     Locale locale = jsr173GateWay._l;
/*      */     
/*   48 */     if (locale.noSync()) { locale.enter(); try { return nodeFromStreamImpl(jsr173GateWay); } finally { locale.exit(); }  }
/*   49 */      synchronized (locale) { locale.enter(); try { return nodeFromStreamImpl(jsr173GateWay); } finally { locale.exit(); }
/*      */        }
/*      */   
/*      */   }
/*      */   
/*      */   public static Node nodeFromStreamImpl(Jsr173GateWay paramJsr173GateWay) {
/*   55 */     Cur cur = paramJsr173GateWay._xs.getStreamCur();
/*      */     
/*   57 */     return cur.isNode() ? (Node)cur.getDom() : (Node)null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static XMLStreamReader newXmlStreamReader(Cur paramCur, Object paramObject, int paramInt1, int paramInt2) {
/*   62 */     XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(paramCur, paramObject, paramInt1, paramInt2);
/*      */     
/*   64 */     if (paramCur._locale.noSync()) {
/*   65 */       return new UnsyncedJsr173(paramCur._locale, xMLStreamReaderForString);
/*      */     }
/*   67 */     return new SyncedJsr173(paramCur._locale, xMLStreamReaderForString);
/*      */   }
/*      */   
/*      */   public static XMLStreamReader newXmlStreamReader(Cur paramCur, XmlOptions paramXmlOptions) {
/*      */     XMLStreamReaderForNode xMLStreamReaderForNode;
/*   72 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/*      */     
/*   74 */     boolean bool = (paramXmlOptions.hasOption("SAVE_INNER") && !paramXmlOptions.hasOption("SAVE_OUTER")) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*   80 */     int i = paramCur.kind();
/*      */     
/*   82 */     if (i == 0 || i < 0) {
/*      */       
/*   84 */       XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(paramCur, paramCur.getChars(-1), paramCur._offSrc, paramCur._cchSrc);
/*      */     }
/*   86 */     else if (bool) {
/*      */       
/*   88 */       if (!paramCur.hasAttrs() && !paramCur.hasChildren()) {
/*   89 */         XMLStreamReaderForString xMLStreamReaderForString = new XMLStreamReaderForString(paramCur, paramCur.getFirstChars(), paramCur._offSrc, paramCur._cchSrc);
/*      */       } else {
/*      */         
/*   92 */         assert paramCur.isContainer();
/*   93 */         xMLStreamReaderForNode = new XMLStreamReaderForNode(paramCur, true);
/*      */       } 
/*      */     } else {
/*      */       
/*   97 */       xMLStreamReaderForNode = new XMLStreamReaderForNode(paramCur, false);
/*      */     } 
/*   99 */     if (paramCur._locale.noSync()) {
/*  100 */       return new UnsyncedJsr173(paramCur._locale, xMLStreamReaderForNode);
/*      */     }
/*  102 */     return new SyncedJsr173(paramCur._locale, xMLStreamReaderForNode);
/*      */   }
/*      */   
/*      */   private static final class XMLStreamReaderForNode extends XMLStreamReaderBase { private boolean _wholeDoc;
/*      */     private boolean _done;
/*      */     private Cur _cur;
/*      */     private Cur _end;
/*      */     private boolean _srcFetched;
/*      */     private Object _src;
/*      */     
/*      */     public XMLStreamReaderForNode(Cur param1Cur, boolean param1Boolean) {
/*  113 */       super(param1Cur);
/*      */       
/*  115 */       assert param1Cur.isContainer() || param1Cur.isComment() || param1Cur.isProcinst() || param1Cur.isAttr();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  120 */       if (param1Boolean) {
/*      */         
/*  122 */         assert param1Cur.isContainer();
/*      */         
/*  124 */         this._cur = param1Cur.weakCur(this);
/*      */         
/*  126 */         if (!this._cur.toFirstAttr()) {
/*  127 */           this._cur.next();
/*      */         }
/*  129 */         this._end = param1Cur.weakCur(this);
/*  130 */         this._end.toEnd();
/*      */       }
/*      */       else {
/*      */         
/*  134 */         this._cur = param1Cur.weakCur(this);
/*      */         
/*  136 */         if (param1Cur.isRoot()) {
/*  137 */           this._wholeDoc = true;
/*      */         } else {
/*      */           
/*  140 */           this._end = param1Cur.weakCur(this);
/*      */           
/*  142 */           if (param1Cur.isAttr()) {
/*      */             
/*  144 */             if (!this._end.toNextAttr()) {
/*      */               
/*  146 */               this._end.toParent();
/*  147 */               this._end.next();
/*      */             } 
/*      */           } else {
/*      */             
/*  151 */             this._end.skip();
/*      */           } 
/*      */         } 
/*      */       } 
/*  155 */       if (!this._wholeDoc) {
/*      */ 
/*      */ 
/*      */         
/*  159 */         this._cur.push();
/*      */ 
/*      */         
/*      */         try {
/*  163 */           next();
/*      */         }
/*  165 */         catch (XMLStreamException xMLStreamException) {
/*      */           
/*  167 */           throw new RuntimeException(xMLStreamException.getMessage(), xMLStreamException);
/*      */         } 
/*      */         
/*  170 */         this._cur.pop();
/*      */       } 
/*      */       
/*  173 */       assert this._wholeDoc || !this._cur.isSamePos(this._end);
/*      */     }
/*      */     private int _offSrc; private int _cchSrc; private boolean _textFetched;
/*      */     
/*      */     protected Cur getStreamCur() {
/*  178 */       return this._cur;
/*      */     }
/*      */     
/*      */     private char[] _chars;
/*      */     private int _offChars;
/*      */     private int _cchChars;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     public boolean hasNext() throws XMLStreamException {
/*  187 */       checkChanged();
/*      */       
/*  189 */       return !this._done;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getEventType() {
/*  194 */       switch (this._cur.kind()) {
/*      */         case 1:
/*  196 */           return 7;
/*  197 */         case -1: return 8;
/*  198 */         case 2: return 1;
/*  199 */         case -2: return 2;
/*  200 */         case 3: return this._cur.isXmlns() ? 13 : 10;
/*  201 */         case 0: return 4;
/*  202 */         case 4: return 5;
/*  203 */         case 5: return 3;
/*  204 */       }  throw new IllegalStateException();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int next() throws XMLStreamException {
/*  210 */       checkChanged();
/*      */       
/*  212 */       if (!hasNext()) {
/*  213 */         throw new IllegalStateException("No next event in stream");
/*      */       }
/*  215 */       int i = this._cur.kind();
/*      */       
/*  217 */       if (i == -1) {
/*      */         
/*  219 */         assert this._wholeDoc;
/*  220 */         this._done = true;
/*      */       }
/*      */       else {
/*      */         
/*  224 */         if (i == 3) {
/*      */           
/*  226 */           if (!this._cur.toNextAttr())
/*      */           {
/*  228 */             this._cur.toParent();
/*  229 */             this._cur.next();
/*      */           }
/*      */         
/*  232 */         } else if (i == 4 || i == 5) {
/*  233 */           this._cur.skip();
/*  234 */         } else if (i == 1) {
/*      */           
/*  236 */           if (!this._cur.toFirstAttr()) {
/*  237 */             this._cur.next();
/*      */           }
/*      */         } else {
/*  240 */           this._cur.next();
/*      */         } 
/*  242 */         assert this._wholeDoc || this._end != null;
/*      */         
/*  244 */         this._done = this._wholeDoc ? ((this._cur.kind() == -1)) : this._cur.isSamePos(this._end);
/*      */       } 
/*      */       
/*  247 */       this._textFetched = false;
/*  248 */       this._srcFetched = false;
/*      */       
/*  250 */       return getEventType();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getText() {
/*  255 */       checkChanged();
/*      */       
/*  257 */       int i = this._cur.kind();
/*      */       
/*  259 */       if (i == 4) {
/*  260 */         return this._cur.getValueAsString();
/*      */       }
/*  262 */       if (i == 0) {
/*  263 */         return this._cur.getCharsAsString(-1);
/*      */       }
/*  265 */       throw new IllegalStateException();
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isStartElement() {
/*  270 */       return (getEventType() == 1);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isEndElement() {
/*  275 */       return (getEventType() == 2);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isCharacters() {
/*  280 */       return (getEventType() == 4);
/*      */     }
/*      */ 
/*      */     
/*      */     public String getElementText() throws XMLStreamException {
/*  285 */       checkChanged();
/*      */       
/*  287 */       if (!isStartElement()) {
/*  288 */         throw new IllegalStateException();
/*      */       }
/*  290 */       StringBuffer stringBuffer = new StringBuffer();
/*      */ 
/*      */       
/*      */       while (true) {
/*  294 */         if (!hasNext()) {
/*  295 */           throw new XMLStreamException();
/*      */         }
/*  297 */         int i = next();
/*      */         
/*  299 */         if (i == 2)
/*      */           break; 
/*  301 */         if (i == 1)
/*  302 */           throw new XMLStreamException(); 
/*  303 */         if (i != 5 && i != 3) {
/*  304 */           stringBuffer.append(getText());
/*      */         }
/*      */       } 
/*  307 */       return stringBuffer.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     public int nextTag() throws XMLStreamException {
/*  312 */       checkChanged();
/*      */ 
/*      */       
/*      */       while (true) {
/*  316 */         if (isStartElement() || isEndElement()) {
/*  317 */           return getEventType();
/*      */         }
/*  319 */         if (!isWhiteSpace()) {
/*  320 */           throw new XMLStreamException();
/*      */         }
/*  322 */         if (!hasNext()) {
/*  323 */           throw new XMLStreamException();
/*      */         }
/*  325 */         next();
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private static boolean matchAttr(Cur param1Cur, String param1String1, String param1String2) {
/*  331 */       assert param1Cur.isNormalAttr();
/*      */       
/*  333 */       b b = param1Cur.getName();
/*      */       
/*  335 */       return (b.dT().equals(param1String2) && (param1String1 == null || b.getNamespaceURI().equals(param1String1)));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private static Cur toAttr(Cur param1Cur, String param1String1, String param1String2) {
/*  342 */       if (param1String1 == null || param1String2 == null || param1String2.length() == 0) {
/*  343 */         throw new IllegalArgumentException();
/*      */       }
/*  345 */       Cur cur = param1Cur.tempCur();
/*  346 */       boolean bool = false;
/*      */       
/*  348 */       if (param1Cur.isElem()) {
/*      */         
/*  350 */         if (cur.toFirstAttr()) {
/*      */           
/*      */           do {
/*      */             
/*  354 */             if (cur.isNormalAttr() && matchAttr(cur, param1String1, param1String2)) {
/*      */               
/*  356 */               bool = true;
/*      */               
/*      */               break;
/*      */             } 
/*  360 */           } while (cur.toNextSibling());
/*      */         }
/*      */       }
/*  363 */       else if (param1Cur.isNormalAttr()) {
/*  364 */         bool = matchAttr(param1Cur, param1String1, param1String2);
/*      */       } else {
/*  366 */         throw new IllegalStateException();
/*      */       } 
/*  368 */       if (!bool) {
/*      */         
/*  370 */         cur.release();
/*  371 */         cur = null;
/*      */       } 
/*      */       
/*  374 */       return cur;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributeValue(String param1String1, String param1String2) {
/*  379 */       Cur cur = toAttr(this._cur, param1String1, param1String2);
/*      */       
/*  381 */       String str = null;
/*      */       
/*  383 */       if (cur != null) {
/*      */         
/*  385 */         str = cur.getValueAsString();
/*  386 */         cur.release();
/*      */       } 
/*      */       
/*  389 */       return str;
/*      */     }
/*      */ 
/*      */     
/*      */     private static Cur toAttr(Cur param1Cur, int param1Int) {
/*  394 */       if (param1Int < 0) {
/*  395 */         throw new IndexOutOfBoundsException("Attribute index is negative");
/*      */       }
/*  397 */       Cur cur = param1Cur.tempCur();
/*  398 */       boolean bool = false;
/*      */       
/*  400 */       if (param1Cur.isElem()) {
/*      */         
/*  402 */         if (cur.toFirstAttr()) {
/*      */           
/*      */           do {
/*      */             
/*  406 */             if (cur.isNormalAttr() && param1Int-- == 0) {
/*      */               
/*  408 */               bool = true;
/*      */               
/*      */               break;
/*      */             } 
/*  412 */           } while (cur.toNextSibling());
/*      */         }
/*      */       }
/*  415 */       else if (param1Cur.isNormalAttr()) {
/*  416 */         bool = (param1Int == 0) ? true : false;
/*      */       } else {
/*  418 */         throw new IllegalStateException();
/*      */       } 
/*  420 */       if (!bool) {
/*      */         
/*  422 */         cur.release();
/*  423 */         throw new IndexOutOfBoundsException("Attribute index is too large");
/*      */       } 
/*      */       
/*  426 */       return cur;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getAttributeCount() {
/*  431 */       byte b = 0;
/*      */       
/*  433 */       if (this._cur.isElem()) {
/*      */         
/*  435 */         Cur cur = this._cur.tempCur();
/*      */         
/*  437 */         if (cur.toFirstAttr()) {
/*      */           do
/*      */           {
/*      */             
/*  441 */             if (!cur.isNormalAttr())
/*  442 */               continue;  b++;
/*      */           }
/*  444 */           while (cur.toNextSibling());
/*      */         }
/*      */         
/*  447 */         cur.release();
/*      */       }
/*  449 */       else if (this._cur.isNormalAttr()) {
/*  450 */         b++;
/*      */       } else {
/*  452 */         throw new IllegalStateException();
/*      */       } 
/*  454 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     public b getAttributeName(int param1Int) {
/*  459 */       Cur cur = toAttr(this._cur, param1Int);
/*  460 */       b b = cur.getName();
/*  461 */       cur.release();
/*  462 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributeNamespace(int param1Int) {
/*  467 */       return getAttributeName(param1Int).getNamespaceURI();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributeLocalName(int param1Int) {
/*  472 */       return getAttributeName(param1Int).dT();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributePrefix(int param1Int) {
/*  477 */       return getAttributeName(param1Int).getPrefix();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributeType(int param1Int) {
/*  482 */       toAttr(this._cur, param1Int).release();
/*  483 */       return "CDATA";
/*      */     }
/*      */ 
/*      */     
/*      */     public String getAttributeValue(int param1Int) {
/*  488 */       Cur cur = toAttr(this._cur, param1Int);
/*      */       
/*  490 */       String str = null;
/*      */       
/*  492 */       if (cur != null) {
/*      */         
/*  494 */         str = cur.getValueAsString();
/*  495 */         cur.release();
/*      */       } 
/*      */       
/*  498 */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isAttributeSpecified(int param1Int) {
/*  504 */       Cur cur = toAttr(this._cur, param1Int);
/*  505 */       cur.release();
/*      */       
/*  507 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getNamespaceCount() {
/*  512 */       byte b = 0;
/*      */       
/*  514 */       if (this._cur.isElem() || this._cur.kind() == -2) {
/*      */         
/*  516 */         Cur cur = this._cur.tempCur();
/*      */         
/*  518 */         if (this._cur.kind() == -2) {
/*  519 */           cur.toParent();
/*      */         }
/*  521 */         if (cur.toFirstAttr()) {
/*      */           do
/*      */           {
/*      */             
/*  525 */             if (!cur.isXmlns())
/*  526 */               continue;  b++;
/*      */           }
/*  528 */           while (cur.toNextSibling());
/*      */         }
/*      */         
/*  531 */         cur.release();
/*      */       }
/*  533 */       else if (this._cur.isXmlns()) {
/*  534 */         b++;
/*      */       } else {
/*  536 */         throw new IllegalStateException();
/*      */       } 
/*  538 */       return b;
/*      */     }
/*      */ 
/*      */     
/*      */     private static Cur toXmlns(Cur param1Cur, int param1Int) {
/*  543 */       if (param1Int < 0) {
/*  544 */         throw new IndexOutOfBoundsException("Namespace index is negative");
/*      */       }
/*  546 */       Cur cur = param1Cur.tempCur();
/*  547 */       boolean bool = false;
/*      */       
/*  549 */       if (param1Cur.isElem() || param1Cur.kind() == -2) {
/*      */         
/*  551 */         if (param1Cur.kind() == -2) {
/*  552 */           cur.toParent();
/*      */         }
/*  554 */         if (cur.toFirstAttr()) {
/*      */           
/*      */           do {
/*      */             
/*  558 */             if (cur.isXmlns() && param1Int-- == 0) {
/*      */               
/*  560 */               bool = true;
/*      */               
/*      */               break;
/*      */             } 
/*  564 */           } while (cur.toNextSibling());
/*      */         }
/*      */       }
/*  567 */       else if (param1Cur.isXmlns()) {
/*  568 */         bool = (param1Int == 0) ? true : false;
/*      */       } else {
/*  570 */         throw new IllegalStateException();
/*      */       } 
/*  572 */       if (!bool) {
/*      */         
/*  574 */         cur.release();
/*  575 */         throw new IndexOutOfBoundsException("Namespace index is too large");
/*      */       } 
/*      */       
/*  578 */       return cur;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getNamespacePrefix(int param1Int) {
/*  583 */       Cur cur = toXmlns(this._cur, param1Int);
/*  584 */       String str = cur.getXmlnsPrefix();
/*  585 */       cur.release();
/*  586 */       return str;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getNamespaceURI(int param1Int) {
/*  591 */       Cur cur = toXmlns(this._cur, param1Int);
/*  592 */       String str = cur.getXmlnsUri();
/*  593 */       cur.release();
/*  594 */       return str;
/*      */     }
/*      */ 
/*      */     
/*      */     private void fetchChars() {
/*  599 */       if (!this._textFetched) {
/*      */         
/*  601 */         int i = this._cur.kind();
/*      */         
/*  603 */         Cur cur = null;
/*      */         
/*  605 */         if (i == 4) {
/*      */           
/*  607 */           cur = this._cur.tempCur();
/*  608 */           cur.next();
/*      */         }
/*  610 */         else if (i == 0) {
/*  611 */           cur = this._cur;
/*      */         } else {
/*  613 */           throw new IllegalStateException();
/*      */         } 
/*  615 */         Object object = cur.getChars(-1);
/*      */         
/*  617 */         ensureCharBufLen(cur._cchSrc);
/*      */         
/*  619 */         CharUtil.getChars(this._chars, this._offChars = 0, object, cur._offSrc, this._cchChars = cur._cchSrc);
/*      */ 
/*      */         
/*  622 */         if (cur != this._cur) {
/*  623 */           cur.release();
/*      */         }
/*  625 */         this._textFetched = true;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void ensureCharBufLen(int param1Int) {
/*  631 */       if (this._chars == null || this._chars.length < param1Int) {
/*      */         
/*  633 */         int i = 256;
/*      */         
/*  635 */         while (i < param1Int) {
/*  636 */           i *= 2;
/*      */         }
/*  638 */         this._chars = new char[i];
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     public char[] getTextCharacters() {
/*  644 */       checkChanged();
/*      */       
/*  646 */       fetchChars();
/*      */       
/*  648 */       return this._chars;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getTextStart() {
/*  653 */       checkChanged();
/*      */       
/*  655 */       fetchChars();
/*      */       
/*  657 */       return this._offChars;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getTextLength() {
/*  662 */       checkChanged();
/*      */       
/*  664 */       fetchChars();
/*      */       
/*  666 */       return this._cchChars;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getTextCharacters(int param1Int1, char[] param1ArrayOfchar, int param1Int2, int param1Int3) throws XMLStreamException {
/*  673 */       if (param1Int3 < 0) {
/*  674 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  676 */       if (param1Int2 < 0 || param1Int2 >= param1ArrayOfchar.length) {
/*  677 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  679 */       if (param1Int2 + param1Int3 > param1ArrayOfchar.length) {
/*  680 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  682 */       if (!this._srcFetched) {
/*      */         
/*  684 */         int i = this._cur.kind();
/*      */         
/*  686 */         Cur cur = null;
/*      */         
/*  688 */         if (i == 4) {
/*      */           
/*  690 */           cur = this._cur.tempCur();
/*  691 */           cur.next();
/*      */         }
/*  693 */         else if (i == 0) {
/*  694 */           cur = this._cur;
/*      */         } else {
/*  696 */           throw new IllegalStateException();
/*      */         } 
/*  698 */         this._src = cur.getChars(-1);
/*  699 */         this._offSrc = cur._offSrc;
/*  700 */         this._cchSrc = cur._cchSrc;
/*      */         
/*  702 */         if (cur != this._cur) {
/*  703 */           cur.release();
/*      */         }
/*  705 */         this._srcFetched = true;
/*      */       } 
/*      */       
/*  708 */       if (param1Int1 > this._cchSrc) {
/*  709 */         throw new IndexOutOfBoundsException();
/*      */       }
/*  711 */       if (param1Int1 + param1Int3 > this._cchSrc) {
/*  712 */         param1Int3 = this._cchSrc - param1Int1;
/*      */       }
/*  714 */       CharUtil.getChars(param1ArrayOfchar, param1Int2, this._src, this._offSrc, param1Int3);
/*      */       
/*  716 */       return param1Int3;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasText() {
/*  721 */       int i = this._cur.kind();
/*      */       
/*  723 */       return (i == 4 || i == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean hasName() {
/*  728 */       int i = this._cur.kind();
/*  729 */       return (i == 2 || i == -2);
/*      */     }
/*      */ 
/*      */     
/*      */     public b getName() {
/*  734 */       if (!hasName()) {
/*  735 */         throw new IllegalStateException();
/*      */       }
/*  737 */       return this._cur.getName();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getNamespaceURI() {
/*  742 */       return getName().getNamespaceURI();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getLocalName() {
/*  747 */       return getName().dT();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getPrefix() {
/*  752 */       return getName().getPrefix();
/*      */     }
/*      */ 
/*      */     
/*      */     public String getPITarget() {
/*  757 */       return (this._cur.kind() == 5) ? this._cur.getName().dT() : null;
/*      */     }
/*      */ 
/*      */     
/*      */     public String getPIData() {
/*  762 */       return (this._cur.kind() == 5) ? this._cur.getValueAsString() : null;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static abstract class XMLStreamReaderBase
/*      */     implements a, Location, XMLStreamReader
/*      */   {
/*      */     private Locale _locale;
/*      */ 
/*      */ 
/*      */     
/*      */     private long _version;
/*      */ 
/*      */ 
/*      */     
/*      */     String _uri;
/*      */ 
/*      */ 
/*      */     
/*      */     int _line;
/*      */ 
/*      */ 
/*      */     
/*      */     int _column;
/*      */ 
/*      */ 
/*      */     
/*      */     int _offset;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected final void checkChanged() {
/*      */       if (this._version != this._locale.version()) {
/*      */         throw new ConcurrentModificationException("Document changed while streaming");
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void close() throws XMLStreamException {
/*      */       checkChanged();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isWhiteSpace() {
/*      */       checkChanged();
/*      */       String str = getText();
/*      */       return this._locale.getCharUtil().isWhiteSpace(str, 0, str.length());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Location getLocation() {
/*      */       checkChanged();
/*      */       Cur cur = getStreamCur();
/*      */       XmlLineNumber xmlLineNumber = (XmlLineNumber)cur.getBookmark((Jsr173.class$org$apache$xmlbeans$XmlLineNumber == null) ? (Jsr173.class$org$apache$xmlbeans$XmlLineNumber = Jsr173.class$("org.apache.xmlbeans.XmlLineNumber")) : Jsr173.class$org$apache$xmlbeans$XmlLineNumber);
/*      */       this._uri = null;
/*      */       if (xmlLineNumber != null) {
/*      */         this._line = xmlLineNumber.getLine();
/*      */         this._column = xmlLineNumber.getColumn();
/*      */         this._offset = xmlLineNumber.getOffset();
/*      */       } else {
/*      */         this._line = -1;
/*      */         this._column = -1;
/*      */         this._offset = -1;
/*      */       } 
/*      */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getProperty(String param1String) {
/*      */       checkChanged();
/*      */       if (param1String == null) {
/*      */         throw new IllegalArgumentException("Property name is null");
/*      */       }
/*      */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getCharacterEncodingScheme() {
/*      */       checkChanged();
/*      */       XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(getStreamCur(), false);
/*      */       return (xmlDocumentProperties == null) ? null : xmlDocumentProperties.getEncoding();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getEncoding() {
/*      */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getVersion() {
/*      */       checkChanged();
/*      */       XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(getStreamCur(), false);
/*      */       return (xmlDocumentProperties == null) ? null : xmlDocumentProperties.getVersion();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isStandalone() {
/*      */       checkChanged();
/*      */       XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(getStreamCur(), false);
/*      */       return (xmlDocumentProperties == null) ? false : xmlDocumentProperties.getStandalone();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean standaloneSet() {
/*      */       checkChanged();
/*      */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void require(int param1Int, String param1String1, String param1String2) throws XMLStreamException {
/*      */       checkChanged();
/*      */       if (param1Int != getEventType()) {
/*      */         throw new XMLStreamException();
/*      */       }
/*      */       if (param1String1 != null && !getNamespaceURI().equals(param1String1)) {
/*      */         throw new XMLStreamException();
/*      */       }
/*      */       if (param1String2 != null && !getLocalName().equals(param1String2)) {
/*      */         throw new XMLStreamException();
/*      */       }
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getCharacterOffset() {
/*      */       return this._offset;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getColumnNumber() {
/*      */       return this._column;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLineNumber() {
/*      */       return this._line;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getLocationURI() {
/*      */       return this._uri;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getPublicId() {
/*      */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getSystemId() {
/*      */       return null;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public a getNamespaceContext() {
/*      */       throw new RuntimeException("This version of getNamespaceContext should not be called");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getNamespaceURI(String param1String) {
/*      */       checkChanged();
/*      */       Cur cur = getStreamCur();
/*      */       cur.push();
/*      */       if (!cur.isContainer()) {
/*      */         cur.toParent();
/*      */       }
/*      */       String str = cur.namespaceForPrefix(param1String, true);
/*      */       cur.pop();
/*      */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getPrefix(String param1String) {
/*      */       checkChanged();
/*      */       Cur cur = getStreamCur();
/*      */       cur.push();
/*      */       if (!cur.isContainer()) {
/*      */         cur.toParent();
/*      */       }
/*      */       String str = cur.prefixForNamespace(param1String, null, false);
/*      */       cur.pop();
/*      */       return str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Iterator getPrefixes(String param1String) {
/*      */       checkChanged();
/*      */       HashMap hashMap = new HashMap();
/*      */       hashMap.put(param1String, getPrefix(param1String));
/*      */       return hashMap.values().iterator();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     XMLStreamReaderBase(Cur param1Cur) {
/* 1000 */       this._line = -1;
/* 1001 */       this._column = -1;
/* 1002 */       this._offset = -1;
/*      */       this._locale = param1Cur._locale;
/*      */       this._version = this._locale.version();
/*      */     }
/*      */     
/*      */     protected abstract Cur getStreamCur(); }
/*      */   
/*      */   private static final class XMLStreamReaderForString extends XMLStreamReaderBase { private Cur _cur;
/*      */     private Object _src;
/*      */     
/*      */     XMLStreamReaderForString(Cur param1Cur, Object param1Object, int param1Int1, int param1Int2) {
/* 1013 */       super(param1Cur);
/*      */       
/* 1015 */       this._src = param1Object;
/* 1016 */       this._off = param1Int1;
/* 1017 */       this._cch = param1Int2;
/*      */       
/* 1019 */       this._cur = param1Cur;
/*      */     }
/*      */     private int _off; private int _cch;
/*      */     
/*      */     protected Cur getStreamCur() {
/* 1024 */       return this._cur;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getText() {
/* 1033 */       checkChanged();
/*      */       
/* 1035 */       return CharUtil.getString(this._src, this._off, this._cch);
/*      */     }
/*      */ 
/*      */     
/*      */     public char[] getTextCharacters() {
/* 1040 */       checkChanged();
/*      */       
/* 1042 */       char[] arrayOfChar = new char[this._cch];
/*      */       
/* 1044 */       CharUtil.getChars(arrayOfChar, 0, this._src, this._off, this._cch);
/*      */       
/* 1046 */       return arrayOfChar;
/*      */     }
/*      */     
/*      */     public int getTextStart() {
/* 1050 */       checkChanged();
/*      */       
/* 1052 */       return this._off;
/*      */     }
/*      */     
/*      */     public int getTextLength() {
/* 1056 */       checkChanged();
/*      */       
/* 1058 */       return this._cch;
/*      */     }
/*      */ 
/*      */     
/*      */     public int getTextCharacters(int param1Int1, char[] param1ArrayOfchar, int param1Int2, int param1Int3) {
/* 1063 */       checkChanged();
/*      */       
/* 1065 */       if (param1Int3 < 0) {
/* 1066 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1068 */       if (param1Int1 > this._cch) {
/* 1069 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 1071 */       if (param1Int1 + param1Int3 > this._cch) {
/* 1072 */         param1Int3 = this._cch - param1Int1;
/*      */       }
/* 1074 */       CharUtil.getChars(param1ArrayOfchar, param1Int2, this._src, this._off + param1Int1, param1Int3);
/*      */       
/* 1076 */       return param1Int3;
/*      */     }
/*      */     
/* 1079 */     public int getEventType() { checkChanged(); return 4; }
/* 1080 */     public boolean hasName() { checkChanged(); return false; }
/* 1081 */     public boolean hasNext() { checkChanged(); return false; }
/* 1082 */     public boolean hasText() { checkChanged(); return true; }
/* 1083 */     public boolean isCharacters() { checkChanged(); return true; }
/* 1084 */     public boolean isEndElement() { checkChanged(); return false; } public boolean isStartElement() {
/* 1085 */       checkChanged(); return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getAttributeCount() {
/* 1091 */       throw new IllegalStateException();
/* 1092 */     } public String getAttributeLocalName(int param1Int) { throw new IllegalStateException(); }
/* 1093 */     public b getAttributeName(int param1Int) { throw new IllegalStateException(); }
/* 1094 */     public String getAttributeNamespace(int param1Int) { throw new IllegalStateException(); }
/* 1095 */     public String getAttributePrefix(int param1Int) { throw new IllegalStateException(); }
/* 1096 */     public String getAttributeType(int param1Int) { throw new IllegalStateException(); }
/* 1097 */     public String getAttributeValue(int param1Int) { throw new IllegalStateException(); }
/* 1098 */     public String getAttributeValue(String param1String1, String param1String2) { throw new IllegalStateException(); }
/* 1099 */     public String getElementText() { throw new IllegalStateException(); }
/* 1100 */     public String getLocalName() { throw new IllegalStateException(); }
/* 1101 */     public b getName() { throw new IllegalStateException(); }
/* 1102 */     public int getNamespaceCount() { throw new IllegalStateException(); }
/* 1103 */     public String getNamespacePrefix(int param1Int) { throw new IllegalStateException(); }
/* 1104 */     public String getNamespaceURI(int param1Int) { throw new IllegalStateException(); }
/* 1105 */     public String getNamespaceURI() { throw new IllegalStateException(); }
/* 1106 */     public String getPIData() { throw new IllegalStateException(); }
/* 1107 */     public String getPITarget() { throw new IllegalStateException(); }
/* 1108 */     public String getPrefix() { throw new IllegalStateException(); }
/* 1109 */     public boolean isAttributeSpecified(int param1Int) { throw new IllegalStateException(); }
/* 1110 */     public int next() { throw new IllegalStateException(); }
/* 1111 */     public int nextTag() { throw new IllegalStateException(); }
/* 1112 */     public String getPublicId() { throw new IllegalStateException(); } public String getSystemId() {
/* 1113 */       throw new IllegalStateException();
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static abstract class Jsr173GateWay
/*      */   {
/*      */     Locale _l;
/*      */     
/*      */     Jsr173.XMLStreamReaderBase _xs;
/*      */ 
/*      */     
/*      */     public Jsr173GateWay(Locale param1Locale, Jsr173.XMLStreamReaderBase param1XMLStreamReaderBase) {
/* 1127 */       this._l = param1Locale; this._xs = param1XMLStreamReaderBase;
/*      */     }
/*      */   }
/*      */   
/*      */   private static final class SyncedJsr173
/*      */     extends Jsr173GateWay
/*      */     implements a, Location, XMLStreamReader {
/*      */     public SyncedJsr173(Locale param1Locale, Jsr173.XMLStreamReaderBase param1XMLStreamReaderBase) {
/* 1135 */       super(param1Locale, param1XMLStreamReaderBase);
/*      */     }
/* 1137 */     public Object getProperty(String param1String) { synchronized (this._l) { this._l.enter(); try { return this._xs.getProperty(param1String); } finally { this._l.exit(); }  }
/* 1138 */        } public int next() throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { return this._xs.next(); } finally { this._l.exit(); }  }
/* 1139 */        } public void require(int param1Int, String param1String1, String param1String2) throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { this._xs.require(param1Int, param1String1, param1String2); } finally { this._l.exit(); }  }
/* 1140 */        } public String getElementText() throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { return this._xs.getElementText(); } finally { this._l.exit(); }  }
/* 1141 */        } public int nextTag() throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { return this._xs.nextTag(); } finally { this._l.exit(); }  }
/* 1142 */        } public boolean hasNext() throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { return this._xs.hasNext(); } finally { this._l.exit(); }  }
/* 1143 */        } public void close() throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { this._xs.close(); } finally { this._l.exit(); }  }
/* 1144 */        } public String getNamespaceURI(String param1String) { synchronized (this._l) { this._l.enter(); try { return this._xs.getNamespaceURI(param1String); } finally { this._l.exit(); }  }
/* 1145 */        } public boolean isStartElement() { synchronized (this._l) { this._l.enter(); try { return this._xs.isStartElement(); } finally { this._l.exit(); }  }
/* 1146 */        } public boolean isEndElement() { synchronized (this._l) { this._l.enter(); try { return this._xs.isEndElement(); } finally { this._l.exit(); }  }
/* 1147 */        } public boolean isCharacters() { synchronized (this._l) { this._l.enter(); try { return this._xs.isCharacters(); } finally { this._l.exit(); }  }
/* 1148 */        } public boolean isWhiteSpace() { synchronized (this._l) { this._l.enter(); try { return this._xs.isWhiteSpace(); } finally { this._l.exit(); }  }
/* 1149 */        } public String getAttributeValue(String param1String1, String param1String2) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeValue(param1String1, param1String2); } finally { this._l.exit(); }  }
/* 1150 */        } public int getAttributeCount() { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeCount(); } finally { this._l.exit(); }  }
/* 1151 */        } public b getAttributeName(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeName(param1Int); } finally { this._l.exit(); }  }
/* 1152 */        } public String getAttributeNamespace(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeNamespace(param1Int); } finally { this._l.exit(); }  }
/* 1153 */        } public String getAttributeLocalName(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeLocalName(param1Int); } finally { this._l.exit(); }  }
/* 1154 */        } public String getAttributePrefix(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributePrefix(param1Int); } finally { this._l.exit(); }  }
/* 1155 */        } public String getAttributeType(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeType(param1Int); } finally { this._l.exit(); }  }
/* 1156 */        } public String getAttributeValue(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getAttributeValue(param1Int); } finally { this._l.exit(); }  }
/* 1157 */        } public boolean isAttributeSpecified(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.isAttributeSpecified(param1Int); } finally { this._l.exit(); }  }
/* 1158 */        } public int getNamespaceCount() { synchronized (this._l) { this._l.enter(); try { return this._xs.getNamespaceCount(); } finally { this._l.exit(); }  }
/* 1159 */        } public String getNamespacePrefix(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getNamespacePrefix(param1Int); } finally { this._l.exit(); }  }
/* 1160 */        } public String getNamespaceURI(int param1Int) { synchronized (this._l) { this._l.enter(); try { return this._xs.getNamespaceURI(param1Int); } finally { this._l.exit(); }  }
/* 1161 */        } public a getNamespaceContext() { return this; }
/* 1162 */     public int getEventType() { synchronized (this._l) { this._l.enter(); try { return this._xs.getEventType(); } finally { this._l.exit(); }  }
/* 1163 */        } public String getText() { synchronized (this._l) { this._l.enter(); try { return this._xs.getText(); } finally { this._l.exit(); }  }
/* 1164 */        } public char[] getTextCharacters() { synchronized (this._l) { this._l.enter(); try { return this._xs.getTextCharacters(); } finally { this._l.exit(); }  }
/* 1165 */        } public int getTextCharacters(int param1Int1, char[] param1ArrayOfchar, int param1Int2, int param1Int3) throws XMLStreamException { synchronized (this._l) { this._l.enter(); try { return this._xs.getTextCharacters(param1Int1, param1ArrayOfchar, param1Int2, param1Int3); } finally { this._l.exit(); }  }
/* 1166 */        } public int getTextStart() { synchronized (this._l) { this._l.enter(); try { return this._xs.getTextStart(); } finally { this._l.exit(); }  }
/* 1167 */        } public int getTextLength() { synchronized (this._l) { this._l.enter(); try { return this._xs.getTextLength(); } finally { this._l.exit(); }  }
/* 1168 */        } public String getEncoding() { synchronized (this._l) { this._l.enter(); try { return this._xs.getEncoding(); } finally { this._l.exit(); }  }
/* 1169 */        } public boolean hasText() { synchronized (this._l) { this._l.enter(); try { return this._xs.hasText(); } finally { this._l.exit(); }  }
/* 1170 */        } public Location getLocation() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLocation(); } finally { this._l.exit(); }  }
/* 1171 */        } public b getName() { synchronized (this._l) { this._l.enter(); try { return this._xs.getName(); } finally { this._l.exit(); }  }
/* 1172 */        } public String getLocalName() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLocalName(); } finally { this._l.exit(); }  }
/* 1173 */        } public boolean hasName() { synchronized (this._l) { this._l.enter(); try { return this._xs.hasName(); } finally { this._l.exit(); }  }
/* 1174 */        } public String getNamespaceURI() { synchronized (this._l) { this._l.enter(); try { return this._xs.getNamespaceURI(); } finally { this._l.exit(); }  }
/* 1175 */        } public String getPrefix() { synchronized (this._l) { this._l.enter(); try { return this._xs.getPrefix(); } finally { this._l.exit(); }  }
/* 1176 */        } public String getVersion() { synchronized (this._l) { this._l.enter(); try { return this._xs.getVersion(); } finally { this._l.exit(); }  }
/* 1177 */        } public boolean isStandalone() { synchronized (this._l) { this._l.enter(); try { return this._xs.isStandalone(); } finally { this._l.exit(); }  }
/* 1178 */        } public boolean standaloneSet() { synchronized (this._l) { this._l.enter(); try { return this._xs.standaloneSet(); } finally { this._l.exit(); }  }
/* 1179 */        } public String getCharacterEncodingScheme() { synchronized (this._l) { this._l.enter(); try { return this._xs.getCharacterEncodingScheme(); } finally { this._l.exit(); }  }
/* 1180 */        } public String getPITarget() { synchronized (this._l) { this._l.enter(); try { return this._xs.getPITarget(); } finally { this._l.exit(); }  }
/* 1181 */        } public String getPIData() { synchronized (this._l) { this._l.enter(); try { return this._xs.getPIData(); } finally { this._l.exit(); }  }
/* 1182 */        } public String getPrefix(String param1String) { synchronized (this._l) { this._l.enter(); try { return this._xs.getPrefix(param1String); } finally { this._l.exit(); }  }
/* 1183 */        } public Iterator getPrefixes(String param1String) { synchronized (this._l) { this._l.enter(); try { return this._xs.getPrefixes(param1String); } finally { this._l.exit(); }  }
/* 1184 */        } public int getCharacterOffset() { synchronized (this._l) { this._l.enter(); try { return this._xs.getCharacterOffset(); } finally { this._l.exit(); }  }
/* 1185 */        } public int getColumnNumber() { synchronized (this._l) { this._l.enter(); try { return this._xs.getColumnNumber(); } finally { this._l.exit(); }  }
/* 1186 */        } public int getLineNumber() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLineNumber(); } finally { this._l.exit(); }  }
/* 1187 */        } public String getLocationURI() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLocationURI(); } finally { this._l.exit(); }  }
/* 1188 */        } public String getPublicId() { synchronized (this._l) { this._l.enter(); try { return this._xs.getPublicId(); } finally { this._l.exit(); }  }
/* 1189 */        } public String getSystemId() { synchronized (this._l) { this._l.enter(); try { return this._xs.getSystemId(); } finally { this._l.exit(); }
/*      */          }
/*      */        }
/*      */      }
/*      */   
/* 1194 */   private static final class UnsyncedJsr173 extends Jsr173GateWay implements a, Location, XMLStreamReader { public UnsyncedJsr173(Locale param1Locale, Jsr173.XMLStreamReaderBase param1XMLStreamReaderBase) { super(param1Locale, param1XMLStreamReaderBase); }
/*      */     public Object getProperty(String param1String) { 
/* 1196 */       try { this._l.enter(); return this._xs.getProperty(param1String); } finally { this._l.exit(); }
/* 1197 */        } public int next() throws XMLStreamException { try { this._l.enter(); return this._xs.next(); } finally { this._l.exit(); }
/* 1198 */        } public void require(int param1Int, String param1String1, String param1String2) throws XMLStreamException { try { this._l.enter(); this._xs.require(param1Int, param1String1, param1String2); } finally { this._l.exit(); }
/* 1199 */        } public String getElementText() throws XMLStreamException { try { this._l.enter(); return this._xs.getElementText(); } finally { this._l.exit(); }
/* 1200 */        } public int nextTag() throws XMLStreamException { try { this._l.enter(); return this._xs.nextTag(); } finally { this._l.exit(); }
/* 1201 */        } public boolean hasNext() throws XMLStreamException { try { this._l.enter(); return this._xs.hasNext(); } finally { this._l.exit(); }
/* 1202 */        } public void close() throws XMLStreamException { try { this._l.enter(); this._xs.close(); } finally { this._l.exit(); }
/* 1203 */        } public String getNamespaceURI(String param1String) { try { this._l.enter(); return this._xs.getNamespaceURI(param1String); } finally { this._l.exit(); }
/* 1204 */        } public boolean isStartElement() { try { this._l.enter(); return this._xs.isStartElement(); } finally { this._l.exit(); }
/* 1205 */        } public boolean isEndElement() { try { this._l.enter(); return this._xs.isEndElement(); } finally { this._l.exit(); }
/* 1206 */        } public boolean isCharacters() { try { this._l.enter(); return this._xs.isCharacters(); } finally { this._l.exit(); }
/* 1207 */        } public boolean isWhiteSpace() { try { this._l.enter(); return this._xs.isWhiteSpace(); } finally { this._l.exit(); }
/* 1208 */        } public String getAttributeValue(String param1String1, String param1String2) { try { this._l.enter(); return this._xs.getAttributeValue(param1String1, param1String2); } finally { this._l.exit(); }
/* 1209 */        } public int getAttributeCount() { try { this._l.enter(); return this._xs.getAttributeCount(); } finally { this._l.exit(); }
/* 1210 */        } public b getAttributeName(int param1Int) { try { this._l.enter(); return this._xs.getAttributeName(param1Int); } finally { this._l.exit(); }
/* 1211 */        } public String getAttributeNamespace(int param1Int) { try { this._l.enter(); return this._xs.getAttributeNamespace(param1Int); } finally { this._l.exit(); }
/* 1212 */        } public String getAttributeLocalName(int param1Int) { try { this._l.enter(); return this._xs.getAttributeLocalName(param1Int); } finally { this._l.exit(); }
/* 1213 */        } public String getAttributePrefix(int param1Int) { try { this._l.enter(); return this._xs.getAttributePrefix(param1Int); } finally { this._l.exit(); }
/* 1214 */        } public String getAttributeType(int param1Int) { try { this._l.enter(); return this._xs.getAttributeType(param1Int); } finally { this._l.exit(); }
/* 1215 */        } public String getAttributeValue(int param1Int) { try { this._l.enter(); return this._xs.getAttributeValue(param1Int); } finally { this._l.exit(); }
/* 1216 */        } public boolean isAttributeSpecified(int param1Int) { try { this._l.enter(); return this._xs.isAttributeSpecified(param1Int); } finally { this._l.exit(); }
/* 1217 */        } public int getNamespaceCount() { try { this._l.enter(); return this._xs.getNamespaceCount(); } finally { this._l.exit(); }
/* 1218 */        } public String getNamespacePrefix(int param1Int) { try { this._l.enter(); return this._xs.getNamespacePrefix(param1Int); } finally { this._l.exit(); }
/* 1219 */        } public String getNamespaceURI(int param1Int) { try { this._l.enter(); return this._xs.getNamespaceURI(param1Int); } finally { this._l.exit(); }
/* 1220 */        } public a getNamespaceContext() { return this; } public int getEventType() { 
/* 1221 */       try { this._l.enter(); return this._xs.getEventType(); } finally { this._l.exit(); }
/* 1222 */        } public String getText() { try { this._l.enter(); return this._xs.getText(); } finally { this._l.exit(); }
/* 1223 */        } public char[] getTextCharacters() { try { this._l.enter(); return this._xs.getTextCharacters(); } finally { this._l.exit(); }
/* 1224 */        } public int getTextCharacters(int param1Int1, char[] param1ArrayOfchar, int param1Int2, int param1Int3) throws XMLStreamException { try { this._l.enter(); return this._xs.getTextCharacters(param1Int1, param1ArrayOfchar, param1Int2, param1Int3); } finally { this._l.exit(); }
/* 1225 */        } public int getTextStart() { try { this._l.enter(); return this._xs.getTextStart(); } finally { this._l.exit(); }
/* 1226 */        } public int getTextLength() { try { this._l.enter(); return this._xs.getTextLength(); } finally { this._l.exit(); }
/* 1227 */        } public String getEncoding() { try { this._l.enter(); return this._xs.getEncoding(); } finally { this._l.exit(); }
/* 1228 */        } public boolean hasText() { try { this._l.enter(); return this._xs.hasText(); } finally { this._l.exit(); }
/* 1229 */        } public Location getLocation() { try { this._l.enter(); return this._xs.getLocation(); } finally { this._l.exit(); }
/* 1230 */        } public b getName() { try { this._l.enter(); return this._xs.getName(); } finally { this._l.exit(); }
/* 1231 */        } public String getLocalName() { try { this._l.enter(); return this._xs.getLocalName(); } finally { this._l.exit(); }
/* 1232 */        } public boolean hasName() { try { this._l.enter(); return this._xs.hasName(); } finally { this._l.exit(); }
/* 1233 */        } public String getNamespaceURI() { try { this._l.enter(); return this._xs.getNamespaceURI(); } finally { this._l.exit(); }
/* 1234 */        } public String getPrefix() { try { this._l.enter(); return this._xs.getPrefix(); } finally { this._l.exit(); }
/* 1235 */        } public String getVersion() { try { this._l.enter(); return this._xs.getVersion(); } finally { this._l.exit(); }
/* 1236 */        } public boolean isStandalone() { try { this._l.enter(); return this._xs.isStandalone(); } finally { this._l.exit(); }
/* 1237 */        } public boolean standaloneSet() { try { this._l.enter(); return this._xs.standaloneSet(); } finally { this._l.exit(); }
/* 1238 */        } public String getCharacterEncodingScheme() { try { this._l.enter(); return this._xs.getCharacterEncodingScheme(); } finally { this._l.exit(); }
/* 1239 */        } public String getPITarget() { try { this._l.enter(); return this._xs.getPITarget(); } finally { this._l.exit(); }
/* 1240 */        } public String getPIData() { try { this._l.enter(); return this._xs.getPIData(); } finally { this._l.exit(); }
/* 1241 */        } public String getPrefix(String param1String) { try { this._l.enter(); return this._xs.getPrefix(param1String); } finally { this._l.exit(); }
/* 1242 */        } public Iterator getPrefixes(String param1String) { try { this._l.enter(); return this._xs.getPrefixes(param1String); } finally { this._l.exit(); }
/* 1243 */        } public int getCharacterOffset() { try { this._l.enter(); return this._xs.getCharacterOffset(); } finally { this._l.exit(); }
/* 1244 */        } public int getColumnNumber() { try { this._l.enter(); return this._xs.getColumnNumber(); } finally { this._l.exit(); }
/* 1245 */        } public int getLineNumber() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLineNumber(); } finally { this._l.exit(); }  }
/* 1246 */        } public String getLocationURI() { synchronized (this._l) { this._l.enter(); try { return this._xs.getLocationURI(); } finally { this._l.exit(); }  }
/* 1247 */        } public String getPublicId() { synchronized (this._l) { this._l.enter(); try { return this._xs.getPublicId(); } finally { this._l.exit(); }  }
/* 1248 */        } public String getSystemId() { synchronized (this._l) { this._l.enter(); try { return this._xs.getSystemId(); } finally { this._l.exit(); }
/*      */          }
/*      */        }
/*      */      }
/*      */ 
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Jsr173.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */