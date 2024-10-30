/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.CDataBookmark;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlDocumentProperties;
/*      */ import org.apache.xmlbeans.XmlLineNumber;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.soap.Detail;
/*      */ import org.apache.xmlbeans.impl.soap.DetailEntry;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPBody;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPBodyElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPEnvelope;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPFault;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeader;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreUser;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ final class Cur
/*      */ {
/*      */   static final int TEXT = 0;
/*      */   static final int ROOT = 1;
/*      */   static final int ELEM = 2;
/*      */   static final int ATTR = 3;
/*      */   static final int COMMENT = 4;
/*      */   static final int PROCINST = 5;
/*      */   static final int POOLED = 0;
/*      */   static final int REGISTERED = 1;
/*      */   static final int EMBEDDED = 2;
/*      */   static final int DISPOSED = 3;
/*      */   static final int END_POS = -1;
/*      */   static final int NO_POS = -2;
/*      */   static final String LOAD_USE_LOCALE_CHAR_UTIL = "LOAD_USE_LOCALE_CHAR_UTIL";
/*      */   Locale _locale;
/*      */   Xobj _xobj;
/*      */   int _pos;
/*      */   int _state;
/*      */   String _id;
/*      */   Cur _nextTemp;
/*      */   Cur _prevTemp;
/*      */   int _tempFrame;
/*      */   Cur _next;
/*      */   Cur _prev;
/*      */   Locale.Ref _ref;
/*      */   int _stackTop;
/*      */   int _selectionFirst;
/*      */   int _selectionN;
/*      */   int _selectionLoc;
/*      */   int _selectionCount;
/*      */   private int _posTemp;
/*      */   int _offSrc;
/*      */   int _cchSrc;
/*      */   static final boolean $assertionsDisabled;
/*      */   static Class class$org$apache$xmlbeans$XmlLineNumber;
/*      */   
/*      */   Cur(Locale paramLocale) {
/*  122 */     this._locale = paramLocale;
/*  123 */     this._pos = -2;
/*      */     
/*  125 */     this._tempFrame = -1;
/*      */     
/*  127 */     this._state = 0;
/*      */     
/*  129 */     this._stackTop = -1;
/*  130 */     this._selectionFirst = -1;
/*  131 */     this._selectionN = -1;
/*  132 */     this._selectionLoc = -1;
/*  133 */     this._selectionCount = 0;
/*      */   }
/*      */   boolean isPositioned() {
/*  136 */     assert isNormal(); return (this._xobj != null);
/*      */   }
/*  138 */   static boolean kindIsContainer(int paramInt) { return (paramInt == 2 || paramInt == 1); } static boolean kindIsFinish(int paramInt) {
/*  139 */     return (paramInt == -2 || paramInt == -1);
/*      */   }
/*      */   
/*      */   int kind() {
/*  143 */     assert isPositioned();
/*  144 */     int i = this._xobj.kind();
/*  145 */     return (this._pos == 0) ? i : ((this._pos == -1) ? -i : 0);
/*      */   }
/*      */   
/*  148 */   boolean isRoot() { assert isPositioned(); return (this._pos == 0 && this._xobj.kind() == 1); }
/*  149 */   boolean isElem() { assert isPositioned(); return (this._pos == 0 && this._xobj.kind() == 2); }
/*  150 */   boolean isAttr() { assert isPositioned(); return (this._pos == 0 && this._xobj.kind() == 3); }
/*  151 */   boolean isComment() { assert isPositioned(); return (this._pos == 0 && this._xobj.kind() == 4); }
/*  152 */   boolean isProcinst() { assert isPositioned(); return (this._pos == 0 && this._xobj.kind() == 5); }
/*  153 */   boolean isText() { assert isPositioned(); return (this._pos > 0); }
/*  154 */   boolean isEnd() { assert isPositioned(); return (this._pos == -1 && this._xobj.kind() == 2); }
/*  155 */   boolean isEndRoot() { assert isPositioned(); return (this._pos == -1 && this._xobj.kind() == 1); }
/*  156 */   boolean isNode() { assert isPositioned(); return (this._pos == 0); }
/*  157 */   boolean isContainer() { assert isPositioned(); return (this._pos == 0 && kindIsContainer(this._xobj.kind())); }
/*  158 */   boolean isFinish() { assert isPositioned(); return (this._pos == -1 && kindIsContainer(this._xobj.kind())); } boolean isUserNode() {
/*  159 */     assert isPositioned(); int i = kind(); return (i == 2 || i == 1 || (i == 3 && !isXmlns()));
/*      */   }
/*      */   
/*      */   boolean isContainerOrFinish() {
/*  163 */     assert isPositioned();
/*      */     
/*  165 */     if (this._pos != 0 && this._pos != -1) {
/*  166 */       return false;
/*      */     }
/*  168 */     int i = this._xobj.kind();
/*  169 */     return (i == 2 || i == -2 || i == 1 || i == -1);
/*      */   }
/*      */   
/*  172 */   boolean isNormalAttr() { return (isNode() && this._xobj.isNormalAttr()); } boolean isXmlns() {
/*  173 */     return (isNode() && this._xobj.isXmlns());
/*      */   } boolean isTextCData() {
/*  175 */     return this._xobj.hasBookmark(CDataBookmark.class, this._pos);
/*      */   }
/*  177 */   b getName() { assert isNode() || isEnd(); return this._xobj._name; }
/*  178 */   String getLocal() { return getName().dT(); } String getUri() {
/*  179 */     return getName().getNamespaceURI();
/*      */   }
/*  181 */   String getXmlnsPrefix() { assert isXmlns(); return this._xobj.getXmlnsPrefix(); } String getXmlnsUri() {
/*  182 */     assert isXmlns(); return this._xobj.getXmlnsUri();
/*      */   }
/*  184 */   boolean isDomDocRoot() { return (isRoot() && this._xobj.getDom() instanceof org.w3c.dom.Document); } boolean isDomFragRoot() {
/*  185 */     return (isRoot() && this._xobj.getDom() instanceof org.w3c.dom.DocumentFragment);
/*      */   }
/*  187 */   int cchRight() { assert isPositioned(); return this._xobj.cchRight(this._pos); } int cchLeft() {
/*  188 */     assert isPositioned(); return this._xobj.cchLeft(this._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void createRoot() {
/*  196 */     createDomDocFragRoot();
/*      */   }
/*      */ 
/*      */   
/*      */   void createDomDocFragRoot() {
/*  201 */     moveTo(new Xobj.DocumentFragXobj(this._locale));
/*      */   }
/*      */ 
/*      */   
/*      */   void createDomDocumentRoot() {
/*  206 */     moveTo(createDomDocumentRootXobj(this._locale));
/*      */   }
/*      */ 
/*      */   
/*      */   void createAttr(b paramb) {
/*  211 */     createHelper(new Xobj.AttrXobj(this._locale, paramb));
/*      */   }
/*      */ 
/*      */   
/*      */   void createComment() {
/*  216 */     createHelper(new Xobj.CommentXobj(this._locale));
/*      */   }
/*      */ 
/*      */   
/*      */   void createProcinst(String paramString) {
/*  221 */     createHelper(new Xobj.ProcInstXobj(this._locale, paramString));
/*      */   }
/*      */ 
/*      */   
/*      */   void createElement(b paramb) {
/*  226 */     createElement(paramb, null);
/*      */   }
/*      */ 
/*      */   
/*      */   void createElement(b paramb1, b paramb2) {
/*  231 */     createHelper(createElementXobj(this._locale, paramb1, paramb2));
/*      */   }
/*      */ 
/*      */   
/*      */   static Xobj createDomDocumentRootXobj(Locale paramLocale) {
/*  236 */     return createDomDocumentRootXobj(paramLocale, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static Xobj createDomDocumentRootXobj(Locale paramLocale, boolean paramBoolean) {
/*      */     Xobj.DocumentXobj documentXobj;
/*  243 */     if (paramLocale._saaj == null)
/*  244 */     { if (paramBoolean) {
/*  245 */         Xobj.DocumentFragXobj documentFragXobj = new Xobj.DocumentFragXobj(paramLocale);
/*      */       } else {
/*  247 */         documentXobj = new Xobj.DocumentXobj(paramLocale);
/*      */       }  }
/*  249 */     else { documentXobj = new Xobj.SoapPartDocXobj(paramLocale); }
/*      */     
/*  251 */     if (paramLocale._ownerDoc == null) {
/*  252 */       paramLocale._ownerDoc = documentXobj.getDom();
/*      */     }
/*  254 */     return documentXobj;
/*      */   }
/*      */ 
/*      */   
/*      */   static Xobj createElementXobj(Locale paramLocale, b paramb1, b paramb2) {
/*  259 */     if (paramLocale._saaj == null) {
/*  260 */       return new Xobj.ElementXobj(paramLocale, paramb1);
/*      */     }
/*  262 */     Class clazz = paramLocale._saaj.identifyElement(paramb1, paramb2);
/*      */     
/*  264 */     if (clazz == SOAPElement.class) return new Xobj.SoapElementXobj(paramLocale, paramb1); 
/*  265 */     if (clazz == SOAPBody.class) return new Xobj.SoapBodyXobj(paramLocale, paramb1); 
/*  266 */     if (clazz == SOAPBodyElement.class) return new Xobj.SoapBodyElementXobj(paramLocale, paramb1); 
/*  267 */     if (clazz == SOAPEnvelope.class) return new Xobj.SoapEnvelopeXobj(paramLocale, paramb1); 
/*  268 */     if (clazz == SOAPHeader.class) return new Xobj.SoapHeaderXobj(paramLocale, paramb1); 
/*  269 */     if (clazz == SOAPHeaderElement.class) return new Xobj.SoapHeaderElementXobj(paramLocale, paramb1); 
/*  270 */     if (clazz == SOAPFaultElement.class) return new Xobj.SoapFaultElementXobj(paramLocale, paramb1); 
/*  271 */     if (clazz == Detail.class) return new Xobj.DetailXobj(paramLocale, paramb1); 
/*  272 */     if (clazz == DetailEntry.class) return new Xobj.DetailEntryXobj(paramLocale, paramb1); 
/*  273 */     if (clazz == SOAPFault.class) return new Xobj.SoapFaultXobj(paramLocale, paramb1);
/*      */     
/*  275 */     throw new IllegalStateException("Unknown SAAJ element class: " + clazz);
/*      */   }
/*      */ 
/*      */   
/*      */   private void createHelper(Xobj paramXobj) {
/*  280 */     assert paramXobj._locale == this._locale;
/*      */ 
/*      */ 
/*      */     
/*  284 */     if (isPositioned()) {
/*      */       
/*  286 */       Cur cur = tempCur(paramXobj, 0);
/*  287 */       cur.moveNode(this);
/*  288 */       cur.release();
/*      */     } 
/*      */     
/*  291 */     moveTo(paramXobj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isSamePos(Cur paramCur) {
/*  300 */     assert isNormal() && (paramCur == null || paramCur.isNormal());
/*      */     
/*  302 */     return (this._xobj == paramCur._xobj && this._pos == paramCur._pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isJustAfterEnd(Cur paramCur) {
/*  309 */     assert isNormal() && paramCur != null && paramCur.isNormal() && paramCur.isNode();
/*      */     
/*  311 */     return paramCur._xobj.isJustAfterEnd(this._xobj, this._pos);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isJustAfterEnd(Xobj paramXobj) {
/*  316 */     return paramXobj.isJustAfterEnd(this._xobj, this._pos);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isAtEndOf(Cur paramCur) {
/*  321 */     assert paramCur != null && paramCur.isNormal() && paramCur.isNode();
/*      */     
/*  323 */     return (this._xobj == paramCur._xobj && this._pos == -1);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isInSameTree(Cur paramCur) {
/*  328 */     assert isPositioned() && paramCur.isPositioned();
/*      */     
/*  330 */     return this._xobj.isInSameTree(paramCur._xobj);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int comparePosition(Cur paramCur) {
/*  337 */     assert isPositioned() && paramCur.isPositioned();
/*      */ 
/*      */ 
/*      */     
/*  341 */     if (this._locale != paramCur._locale) {
/*  342 */       return 2;
/*      */     }
/*      */ 
/*      */     
/*  346 */     Xobj xobj1 = this._xobj;
/*  347 */     int i = (this._pos == -1) ? (xobj1.posAfter() - 1) : this._pos;
/*      */     
/*  349 */     Xobj xobj2 = paramCur._xobj;
/*  350 */     int j = (paramCur._pos == -1) ? (xobj2.posAfter() - 1) : paramCur._pos;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  363 */     if (xobj1 == xobj2) {
/*  364 */       return (i < j) ? -1 : ((i == j) ? 0 : 1);
/*      */     }
/*      */ 
/*      */     
/*  368 */     byte b1 = 0;
/*      */     
/*  370 */     for (Xobj xobj3 = xobj1._parent; xobj3 != null; xobj3 = xobj3._parent) {
/*      */       
/*  372 */       b1++;
/*      */       
/*  374 */       if (xobj3 == xobj2) {
/*  375 */         return (j < xobj2.posAfter() - 1) ? 1 : -1;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  380 */     byte b2 = 0;
/*      */     
/*  382 */     for (Xobj xobj4 = xobj2._parent; xobj4 != null; xobj4 = xobj4._parent) {
/*      */       
/*  384 */       b2++;
/*      */       
/*  386 */       if (xobj4 == xobj1) {
/*  387 */         return (i < xobj1.posAfter() - 1) ? -1 : 1;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  392 */     while (b1 > b2) { b1--; xobj1 = xobj1._parent; }
/*  393 */      while (b2 > b1) { b2--; xobj2 = xobj2._parent; }
/*      */     
/*  395 */     assert b2 == b1;
/*      */     
/*  397 */     if (b2 == 0) {
/*  398 */       return 2;
/*      */     }
/*  400 */     assert xobj1._parent != null && xobj2._parent != null;
/*      */     
/*  402 */     while (xobj1._parent != xobj2._parent) {
/*      */       
/*  404 */       if ((xobj1 = xobj1._parent) == null) {
/*  405 */         return 2;
/*      */       }
/*  407 */       xobj2 = xobj2._parent;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  413 */     if (xobj1._prevSibling == null || xobj2._nextSibling == null) {
/*  414 */       return -1;
/*      */     }
/*  416 */     if (xobj1._nextSibling == null || xobj2._prevSibling == null) {
/*  417 */       return 1;
/*      */     }
/*  419 */     while (xobj1 != null) {
/*  420 */       if ((xobj1 = xobj1._prevSibling) == xobj2)
/*  421 */         return 1; 
/*      */     } 
/*  423 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   void setName(b paramb) {
/*  428 */     assert isNode() && paramb != null;
/*      */     
/*  430 */     this._xobj.setName(paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   void moveTo(Xobj paramXobj) {
/*  435 */     moveTo(paramXobj, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void moveTo(Xobj paramXobj, int paramInt) {
/*  442 */     assert paramXobj == null || this._locale == paramXobj._locale;
/*  443 */     assert paramXobj != null || paramInt == -2;
/*  444 */     assert paramXobj == null || paramXobj.isNormal(paramInt) || (paramXobj.isVacant() && paramXobj._cchValue == 0 && paramXobj._user == null);
/*  445 */     assert this._state == 1 || this._state == 2;
/*  446 */     assert this._state == 2 || this._xobj == null || !isOnList(this._xobj._embedded);
/*  447 */     assert this._state == 1 || (this._xobj != null && isOnList(this._xobj._embedded));
/*      */     
/*  449 */     moveToNoCheck(paramXobj, paramInt);
/*      */     
/*  451 */     assert isNormal() || (this._xobj.isVacant() && this._xobj._cchValue == 0 && this._xobj._user == null);
/*      */   }
/*      */ 
/*      */   
/*      */   void moveToNoCheck(Xobj paramXobj, int paramInt) {
/*  456 */     if (this._state == 2 && paramXobj != this._xobj) {
/*      */       
/*  458 */       this._xobj._embedded = listRemove(this._xobj._embedded);
/*  459 */       this._locale._registered = listInsert(this._locale._registered);
/*  460 */       this._state = 1;
/*      */     } 
/*      */     
/*  463 */     this._xobj = paramXobj;
/*  464 */     this._pos = paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   void moveToCur(Cur paramCur) {
/*  469 */     assert isNormal() && (paramCur == null || paramCur.isNormal());
/*      */     
/*  471 */     if (paramCur == null) {
/*  472 */       moveTo(null, -2);
/*      */     } else {
/*  474 */       moveTo(paramCur._xobj, paramCur._pos);
/*      */     } 
/*      */   }
/*      */   
/*      */   void moveToDom(DomImpl.Dom paramDom) {
/*  479 */     assert this._locale == paramDom.locale();
/*  480 */     assert paramDom instanceof Xobj || paramDom instanceof Xobj.SoapPartDom;
/*      */     
/*  482 */     moveTo((paramDom instanceof Xobj) ? (Xobj)paramDom : ((Xobj.SoapPartDom)paramDom)._docXobj);
/*      */   }
/*      */   static final class Locations { private static final int NULL = -1; private static final int _initialSize = 32; private Locale _locale; private Xobj[] _xobjs; private int[] _poses; private Cur[] _curs; private int[] _next; private int[] _prev; private int[] _nextN;
/*      */     private int[] _prevN;
/*      */     private int _free;
/*      */     private int _naked;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     Locations(Locale param1Locale) {
/*  491 */       this._locale = param1Locale;
/*      */       
/*  493 */       this._xobjs = new Xobj[32];
/*  494 */       this._poses = new int[32];
/*  495 */       this._curs = new Cur[32];
/*  496 */       this._next = new int[32];
/*  497 */       this._prev = new int[32];
/*  498 */       this._nextN = new int[32];
/*  499 */       this._prevN = new int[32];
/*      */       
/*  501 */       for (byte b = 31; b >= 0; b--) {
/*      */         
/*  503 */         assert this._xobjs[b] == null;
/*  504 */         this._poses[b] = -2;
/*  505 */         this._next[b] = b + 1;
/*  506 */         this._prev[b] = -1;
/*  507 */         this._nextN[b] = -1;
/*  508 */         this._prevN[b] = -1;
/*      */       } 
/*      */       
/*  511 */       this._next[31] = -1;
/*      */       
/*  513 */       this._free = 0;
/*  514 */       this._naked = -1;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isSamePos(int param1Int, Cur param1Cur) {
/*  519 */       if (this._curs[param1Int] == null) {
/*  520 */         return (param1Cur._xobj == this._xobjs[param1Int] && param1Cur._pos == this._poses[param1Int]);
/*      */       }
/*  522 */       return param1Cur.isSamePos(this._curs[param1Int]);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isAtEndOf(int param1Int, Cur param1Cur) {
/*  527 */       assert this._curs[param1Int] != null || this._poses[param1Int] == 0;
/*  528 */       assert this._curs[param1Int] == null || this._curs[param1Int].isNode();
/*      */       
/*  530 */       if (this._curs[param1Int] == null) {
/*  531 */         return (param1Cur._xobj == this._xobjs[param1Int] && param1Cur._pos == -1);
/*      */       }
/*  533 */       return param1Cur.isAtEndOf(this._curs[param1Int]);
/*      */     }
/*      */ 
/*      */     
/*      */     void moveTo(int param1Int, Cur param1Cur) {
/*  538 */       if (this._curs[param1Int] == null) {
/*  539 */         param1Cur.moveTo(this._xobjs[param1Int], this._poses[param1Int]);
/*      */       } else {
/*  541 */         param1Cur.moveToCur(this._curs[param1Int]);
/*      */       } 
/*      */     }
/*      */     
/*      */     int insert(int param1Int1, int param1Int2, int param1Int3) {
/*  546 */       return insert(param1Int1, param1Int2, param1Int3, this._next, this._prev);
/*      */     }
/*      */ 
/*      */     
/*      */     int remove(int param1Int1, int param1Int2) {
/*  551 */       Cur cur = this._curs[param1Int2];
/*      */       
/*  553 */       assert cur != null || this._xobjs[param1Int2] != null;
/*  554 */       assert cur != null || this._xobjs[param1Int2] != null;
/*      */       
/*  556 */       if (cur != null) {
/*      */         
/*  558 */         this._curs[param1Int2].release();
/*  559 */         this._curs[param1Int2] = null;
/*      */         
/*  561 */         assert this._xobjs[param1Int2] == null;
/*  562 */         assert this._poses[param1Int2] == -2;
/*      */       }
/*      */       else {
/*      */         
/*  566 */         assert this._xobjs[param1Int2] != null && this._poses[param1Int2] != -2;
/*      */         
/*  568 */         this._xobjs[param1Int2] = null;
/*  569 */         this._poses[param1Int2] = -2;
/*      */         
/*  571 */         this._naked = remove(this._naked, param1Int2, this._nextN, this._prevN);
/*      */       } 
/*      */       
/*  574 */       param1Int1 = remove(param1Int1, param1Int2, this._next, this._prev);
/*      */       
/*  576 */       this._next[param1Int2] = this._free;
/*  577 */       this._free = param1Int2;
/*      */       
/*  579 */       return param1Int1;
/*      */     }
/*      */ 
/*      */     
/*      */     int allocate(Cur param1Cur) {
/*  584 */       assert param1Cur.isPositioned();
/*      */       
/*  586 */       if (this._free == -1) {
/*  587 */         makeRoom();
/*      */       }
/*  589 */       int i = this._free;
/*      */       
/*  591 */       this._free = this._next[i];
/*      */       
/*  593 */       this._next[i] = -1;
/*  594 */       assert this._prev[i] == -1;
/*      */       
/*  596 */       assert this._curs[i] == null;
/*  597 */       assert this._xobjs[i] == null;
/*  598 */       assert this._poses[i] == -2;
/*      */       
/*  600 */       this._xobjs[i] = param1Cur._xobj;
/*  601 */       this._poses[i] = param1Cur._pos;
/*      */       
/*  603 */       this._naked = insert(this._naked, -1, i, this._nextN, this._prevN);
/*      */       
/*  605 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     private static int insert(int param1Int1, int param1Int2, int param1Int3, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/*  610 */       if (param1Int1 == -1) {
/*      */         
/*  612 */         assert param1Int2 == -1;
/*  613 */         param1ArrayOfint2[param1Int3] = param1Int3;
/*  614 */         param1Int1 = param1Int3;
/*      */       }
/*  616 */       else if (param1Int2 != -1) {
/*      */         
/*  618 */         param1ArrayOfint2[param1Int3] = param1ArrayOfint2[param1Int2];
/*  619 */         param1ArrayOfint1[param1Int3] = param1Int2;
/*  620 */         param1ArrayOfint2[param1Int2] = param1Int3;
/*      */         
/*  622 */         if (param1Int1 == param1Int2) {
/*  623 */           param1Int1 = param1Int3;
/*      */         }
/*      */       } else {
/*      */         
/*  627 */         param1ArrayOfint2[param1Int3] = param1ArrayOfint2[param1Int1];
/*  628 */         assert param1ArrayOfint1[param1Int3] == -1;
/*  629 */         param1ArrayOfint1[param1ArrayOfint2[param1Int1]] = param1Int3;
/*  630 */         param1ArrayOfint2[param1Int1] = param1Int3;
/*      */       } 
/*      */       
/*  633 */       return param1Int1;
/*      */     }
/*      */ 
/*      */     
/*      */     private static int remove(int param1Int1, int param1Int2, int[] param1ArrayOfint1, int[] param1ArrayOfint2) {
/*  638 */       if (param1ArrayOfint2[param1Int2] == param1Int2) {
/*      */         
/*  640 */         assert param1Int1 == param1Int2;
/*  641 */         param1Int1 = -1;
/*      */       }
/*      */       else {
/*      */         
/*  645 */         if (param1Int1 == param1Int2) {
/*  646 */           param1Int1 = param1ArrayOfint1[param1Int2];
/*      */         } else {
/*  648 */           param1ArrayOfint1[param1ArrayOfint2[param1Int2]] = param1ArrayOfint1[param1Int2];
/*      */         } 
/*  650 */         if (param1ArrayOfint1[param1Int2] == -1) {
/*  651 */           param1ArrayOfint2[param1Int1] = param1ArrayOfint2[param1Int2];
/*      */         } else {
/*      */           
/*  654 */           param1ArrayOfint2[param1ArrayOfint1[param1Int2]] = param1ArrayOfint2[param1Int2];
/*  655 */           param1ArrayOfint1[param1Int2] = -1;
/*      */         } 
/*      */       } 
/*      */       
/*  659 */       param1ArrayOfint2[param1Int2] = -1;
/*  660 */       assert param1ArrayOfint1[param1Int2] == -1;
/*      */       
/*  662 */       return param1Int1;
/*      */     }
/*      */     
/*      */     void notifyChange() {
/*      */       int i;
/*  667 */       while ((i = this._naked) != -1) {
/*      */         
/*  669 */         assert this._curs[i] == null && this._xobjs[i] != null && this._poses[i] != -2;
/*      */         
/*  671 */         this._naked = remove(this._naked, i, this._nextN, this._prevN);
/*      */         
/*  673 */         this._curs[i] = this._locale.getCur();
/*  674 */         this._curs[i].moveTo(this._xobjs[i], this._poses[i]);
/*      */         
/*  676 */         this._xobjs[i] = null;
/*  677 */         this._poses[i] = -2;
/*      */       } 
/*      */     }
/*      */     
/*  681 */     int next(int param1Int) { return this._next[param1Int]; } int prev(int param1Int) {
/*  682 */       return this._prev[param1Int];
/*      */     }
/*      */     
/*      */     private void makeRoom() {
/*  686 */       assert this._free == -1;
/*      */       
/*  688 */       int i = this._xobjs.length;
/*      */       
/*  690 */       Xobj[] arrayOfXobj = this._xobjs;
/*  691 */       int[] arrayOfInt1 = this._poses;
/*  692 */       Cur[] arrayOfCur = this._curs;
/*  693 */       int[] arrayOfInt2 = this._next;
/*  694 */       int[] arrayOfInt3 = this._prev;
/*  695 */       int[] arrayOfInt4 = this._nextN;
/*  696 */       int[] arrayOfInt5 = this._prevN;
/*      */       
/*  698 */       this._xobjs = new Xobj[i * 2];
/*  699 */       this._poses = new int[i * 2];
/*  700 */       this._curs = new Cur[i * 2];
/*  701 */       this._next = new int[i * 2];
/*  702 */       this._prev = new int[i * 2];
/*  703 */       this._nextN = new int[i * 2];
/*  704 */       this._prevN = new int[i * 2];
/*      */       
/*  706 */       System.arraycopy(arrayOfXobj, 0, this._xobjs, 0, i);
/*  707 */       System.arraycopy(arrayOfInt1, 0, this._poses, 0, i);
/*  708 */       System.arraycopy(arrayOfCur, 0, this._curs, 0, i);
/*  709 */       System.arraycopy(arrayOfInt2, 0, this._next, 0, i);
/*  710 */       System.arraycopy(arrayOfInt3, 0, this._prev, 0, i);
/*  711 */       System.arraycopy(arrayOfInt4, 0, this._nextN, 0, i);
/*  712 */       System.arraycopy(arrayOfInt5, 0, this._prevN, 0, i);
/*      */       
/*  714 */       for (int j = i * 2 - 1; j >= i; j--) {
/*      */         
/*  716 */         this._next[j] = j + 1;
/*  717 */         this._prev[j] = -1;
/*  718 */         this._nextN[j] = -1;
/*  719 */         this._prevN[j] = -1;
/*  720 */         this._poses[j] = -2;
/*      */       } 
/*      */       
/*  723 */       this._next[i * 2 - 1] = -1;
/*      */       
/*  725 */       this._free = i;
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
/*      */   void push() {
/*  746 */     assert isPositioned();
/*      */     
/*  748 */     int i = this._locale._locations.allocate(this);
/*  749 */     this._stackTop = this._locale._locations.insert(this._stackTop, this._stackTop, i);
/*      */   }
/*      */ 
/*      */   
/*      */   void pop(boolean paramBoolean) {
/*  754 */     if (paramBoolean) {
/*  755 */       popButStay();
/*      */     } else {
/*  757 */       pop();
/*      */     } 
/*      */   }
/*      */   
/*      */   void popButStay() {
/*  762 */     if (this._stackTop != -1) {
/*  763 */       this._stackTop = this._locale._locations.remove(this._stackTop, this._stackTop);
/*      */     }
/*      */   }
/*      */   
/*      */   boolean pop() {
/*  768 */     if (this._stackTop == -1) {
/*  769 */       return false;
/*      */     }
/*  771 */     this._locale._locations.moveTo(this._stackTop, this);
/*  772 */     this._stackTop = this._locale._locations.remove(this._stackTop, this._stackTop);
/*      */     
/*  774 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isAtLastPush() {
/*  779 */     assert this._stackTop != -1;
/*      */     
/*  781 */     return this._locale._locations.isSamePos(this._stackTop, this);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isAtEndOfLastPush() {
/*  786 */     assert this._stackTop != -1;
/*      */     
/*  788 */     return this._locale._locations.isAtEndOf(this._stackTop, this);
/*      */   }
/*      */ 
/*      */   
/*      */   void addToSelection(Cur paramCur) {
/*  793 */     assert paramCur != null && paramCur.isNormal();
/*  794 */     assert isPositioned() && paramCur.isPositioned();
/*      */     
/*  796 */     int i = this._locale._locations.allocate(paramCur);
/*  797 */     this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, i);
/*      */     
/*  799 */     this._selectionCount++;
/*      */   }
/*      */ 
/*      */   
/*      */   void addToSelection() {
/*  804 */     assert isPositioned();
/*      */     
/*  806 */     int i = this._locale._locations.allocate(this);
/*  807 */     this._selectionFirst = this._locale._locations.insert(this._selectionFirst, -1, i);
/*      */     
/*  809 */     this._selectionCount++;
/*      */   }
/*      */ 
/*      */   
/*      */   private int selectionIndex(int paramInt) {
/*  814 */     assert this._selectionN >= -1 && paramInt >= 0 && paramInt < this._selectionCount;
/*      */     
/*  816 */     if (this._selectionN == -1) {
/*      */       
/*  818 */       this._selectionN = 0;
/*  819 */       this._selectionLoc = this._selectionFirst;
/*      */     } 
/*      */     
/*  822 */     while (this._selectionN < paramInt) {
/*      */       
/*  824 */       this._selectionLoc = this._locale._locations.next(this._selectionLoc);
/*  825 */       this._selectionN++;
/*      */     } 
/*      */     
/*  828 */     while (this._selectionN > paramInt) {
/*      */       
/*  830 */       this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
/*  831 */       this._selectionN--;
/*      */     } 
/*      */     
/*  834 */     return this._selectionLoc;
/*      */   }
/*      */ 
/*      */   
/*      */   void removeSelection(int paramInt) {
/*  839 */     assert paramInt >= 0 && paramInt < this._selectionCount;
/*      */     
/*  841 */     int i = selectionIndex(paramInt);
/*      */ 
/*      */ 
/*      */     
/*  845 */     if (paramInt < this._selectionN) {
/*  846 */       this._selectionN--;
/*  847 */     } else if (paramInt == this._selectionN) {
/*      */       
/*  849 */       this._selectionN--;
/*      */       
/*  851 */       if (paramInt == 0) {
/*  852 */         this._selectionLoc = -1;
/*      */       } else {
/*  854 */         this._selectionLoc = this._locale._locations.prev(this._selectionLoc);
/*      */       } 
/*      */     } 
/*  857 */     this._selectionFirst = this._locale._locations.remove(this._selectionFirst, i);
/*      */     
/*  859 */     this._selectionCount--;
/*      */   }
/*      */ 
/*      */   
/*      */   int selectionCount() {
/*  864 */     return this._selectionCount;
/*      */   }
/*      */ 
/*      */   
/*      */   void moveToSelection(int paramInt) {
/*  869 */     assert paramInt >= 0 && paramInt < this._selectionCount;
/*      */     
/*  871 */     this._locale._locations.moveTo(selectionIndex(paramInt), this);
/*      */   }
/*      */ 
/*      */   
/*      */   void clearSelection() {
/*  876 */     assert this._selectionCount >= 0;
/*      */     
/*  878 */     while (this._selectionCount > 0)
/*  879 */       removeSelection(0); 
/*      */   }
/*      */   
/*  882 */   boolean toParent() { return toParent(false); } boolean toParentRaw() {
/*  883 */     return toParent(true);
/*      */   }
/*  885 */   Xobj getParent() { return getParent(false); } Xobj getParentRaw() {
/*  886 */     return getParent(true);
/*      */   }
/*      */   
/*      */   boolean hasParent() {
/*  890 */     assert isPositioned();
/*      */     
/*  892 */     if (this._pos == -1 || (this._pos >= 1 && this._pos < this._xobj.posAfter())) {
/*  893 */       return true;
/*      */     }
/*  895 */     assert this._pos == 0 || this._xobj._parent != null;
/*      */     
/*  897 */     return (this._xobj._parent != null);
/*      */   }
/*      */ 
/*      */   
/*      */   Xobj getParentNoRoot() {
/*  902 */     assert isPositioned();
/*      */     
/*  904 */     if (this._pos == -1 || (this._pos >= 1 && this._pos < this._xobj.posAfter())) {
/*  905 */       return this._xobj;
/*      */     }
/*  907 */     assert this._pos == 0 || this._xobj._parent != null;
/*      */     
/*  909 */     if (this._xobj._parent != null) {
/*  910 */       return this._xobj._parent;
/*      */     }
/*  912 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   Xobj getParent(boolean paramBoolean) {
/*  917 */     assert isPositioned();
/*      */     
/*  919 */     if (this._pos == -1 || (this._pos >= 1 && this._pos < this._xobj.posAfter())) {
/*  920 */       return this._xobj;
/*      */     }
/*  922 */     assert this._pos == 0 || this._xobj._parent != null;
/*      */     
/*  924 */     if (this._xobj._parent != null) {
/*  925 */       return this._xobj._parent;
/*      */     }
/*  927 */     if (paramBoolean || this._xobj.isRoot()) {
/*  928 */       return null;
/*      */     }
/*  930 */     Cur cur = this._locale.tempCur();
/*      */     
/*  932 */     cur.createRoot();
/*      */     
/*  934 */     Xobj xobj = cur._xobj;
/*      */     
/*  936 */     cur.next();
/*  937 */     moveNode(cur);
/*  938 */     cur.release();
/*      */     
/*  940 */     return xobj;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toParent(boolean paramBoolean) {
/*  945 */     Xobj xobj = getParent(paramBoolean);
/*      */     
/*  947 */     if (xobj == null) {
/*  948 */       return false;
/*      */     }
/*  950 */     moveTo(xobj);
/*      */     
/*  952 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   void toRoot() {
/*  957 */     Xobj xobj = this._xobj;
/*  958 */     while (!xobj.isRoot()) {
/*      */       
/*  960 */       if (xobj._parent == null) {
/*      */         
/*  962 */         Cur cur = this._locale.tempCur();
/*      */         
/*  964 */         cur.createRoot();
/*      */         
/*  966 */         Xobj xobj1 = cur._xobj;
/*      */         
/*  968 */         cur.next();
/*  969 */         moveNode(cur);
/*  970 */         cur.release();
/*      */         
/*  972 */         xobj = xobj1;
/*      */         break;
/*      */       } 
/*  975 */       xobj = xobj._parent;
/*      */     } 
/*  977 */     moveTo(xobj);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean hasText() {
/*  982 */     assert isNode();
/*      */     
/*  984 */     return this._xobj.hasTextEnsureOccupancy();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean hasAttrs() {
/*  989 */     assert isNode();
/*      */     
/*  991 */     return this._xobj.hasAttrs();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean hasChildren() {
/*  996 */     assert isNode();
/*      */     
/*  998 */     return this._xobj.hasChildren();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toFirstChild() {
/* 1003 */     assert isNode();
/*      */     
/* 1005 */     if (!this._xobj.hasChildren()) {
/* 1006 */       return false;
/*      */     }
/* 1008 */     for (Xobj xobj = this._xobj._firstChild;; xobj = xobj._nextSibling) {
/*      */       
/* 1010 */       if (!xobj.isAttr()) {
/*      */         
/* 1012 */         moveTo(xobj);
/* 1013 */         return true;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean toLastChild() {
/* 1020 */     assert isNode();
/*      */     
/* 1022 */     if (!this._xobj.hasChildren()) {
/* 1023 */       return false;
/*      */     }
/* 1025 */     moveTo(this._xobj._lastChild);
/*      */     
/* 1027 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toNextSibling() {
/* 1032 */     assert isNode();
/*      */     
/* 1034 */     if (this._xobj.isAttr()) {
/*      */       
/* 1036 */       if (this._xobj._nextSibling != null && this._xobj._nextSibling.isAttr())
/*      */       {
/* 1038 */         moveTo(this._xobj._nextSibling);
/* 1039 */         return true;
/*      */       }
/*      */     
/* 1042 */     } else if (this._xobj._nextSibling != null) {
/*      */       
/* 1044 */       moveTo(this._xobj._nextSibling);
/* 1045 */       return true;
/*      */     } 
/*      */     
/* 1048 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   void setValueAsQName(b paramb) {
/* 1053 */     assert isNode();
/*      */     
/* 1055 */     String str1 = paramb.dT();
/* 1056 */     String str2 = paramb.getNamespaceURI();
/*      */     
/* 1058 */     String str3 = prefixForNamespace(str2, (paramb.getPrefix().length() > 0) ? paramb.getPrefix() : null, true);
/*      */ 
/*      */ 
/*      */     
/* 1062 */     if (str3.length() > 0) {
/* 1063 */       str1 = str3 + ":" + str1;
/*      */     }
/* 1065 */     setValue(str1);
/*      */   }
/*      */ 
/*      */   
/*      */   void setValue(String paramString) {
/* 1070 */     assert isNode();
/*      */     
/* 1072 */     moveNodeContents(null, false);
/*      */     
/* 1074 */     next();
/*      */     
/* 1076 */     insertString(paramString);
/*      */     
/* 1078 */     toParent();
/*      */   }
/*      */ 
/*      */   
/*      */   void removeFollowingAttrs() {
/* 1083 */     assert isAttr();
/*      */     
/* 1085 */     b b = getName();
/*      */     
/* 1087 */     push();
/*      */     
/* 1089 */     if (toNextAttr())
/*      */     {
/* 1091 */       while (isAttr()) {
/*      */         
/* 1093 */         if (getName().equals(b)) {
/* 1094 */           moveNode(null); continue;
/* 1095 */         }  if (!toNextAttr()) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     }
/* 1100 */     pop();
/*      */   }
/*      */ 
/*      */   
/*      */   String getAttrValue(b paramb) {
/* 1105 */     String str = null;
/*      */     
/* 1107 */     push();
/*      */     
/* 1109 */     if (toAttr(paramb)) {
/* 1110 */       str = getValueAsString();
/*      */     }
/* 1112 */     pop();
/*      */     
/* 1114 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   void setAttrValueAsQName(b paramb1, b paramb2) {
/* 1119 */     assert isContainer();
/*      */     
/* 1121 */     if (paramb2 == null) {
/*      */       
/* 1123 */       this._xobj.removeAttr(paramb1);
/*      */     }
/*      */     else {
/*      */       
/* 1127 */       if (toAttr(paramb1)) {
/*      */         
/* 1129 */         removeFollowingAttrs();
/*      */       }
/*      */       else {
/*      */         
/* 1133 */         next();
/* 1134 */         createAttr(paramb1);
/*      */       } 
/*      */       
/* 1137 */       setValueAsQName(paramb2);
/*      */       
/* 1139 */       toParent();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   boolean removeAttr(b paramb) {
/* 1145 */     assert isContainer();
/*      */     
/* 1147 */     return this._xobj.removeAttr(paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   void setAttrValue(b paramb, String paramString) {
/* 1152 */     assert isContainer();
/*      */     
/* 1154 */     this._xobj.setAttr(paramb, paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toAttr(b paramb) {
/* 1159 */     assert isNode();
/*      */     
/* 1161 */     Xobj xobj = this._xobj.getAttr(paramb);
/*      */     
/* 1163 */     if (xobj == null) {
/* 1164 */       return false;
/*      */     }
/* 1166 */     moveTo(xobj);
/*      */     
/* 1168 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toFirstAttr() {
/* 1173 */     assert isNode();
/*      */     
/* 1175 */     Xobj xobj = this._xobj.firstAttr();
/*      */     
/* 1177 */     if (xobj == null) {
/* 1178 */       return false;
/*      */     }
/* 1180 */     moveTo(xobj);
/*      */     
/* 1182 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toLastAttr() {
/* 1187 */     assert isNode();
/*      */     
/* 1189 */     if (!toFirstAttr()) {
/* 1190 */       return false;
/*      */     }
/* 1192 */     while (toNextAttr());
/*      */ 
/*      */     
/* 1195 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toNextAttr() {
/* 1200 */     assert isAttr() || isContainer();
/*      */     
/* 1202 */     Xobj xobj = this._xobj.nextAttr();
/*      */     
/* 1204 */     if (xobj == null) {
/* 1205 */       return false;
/*      */     }
/* 1207 */     moveTo(xobj);
/*      */     
/* 1209 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean toPrevAttr() {
/* 1214 */     if (isAttr()) {
/*      */       
/* 1216 */       if (this._xobj._prevSibling == null) {
/* 1217 */         moveTo(this._xobj.ensureParent());
/*      */       } else {
/* 1219 */         moveTo(this._xobj._prevSibling);
/*      */       } 
/* 1221 */       return true;
/*      */     } 
/*      */     
/* 1224 */     prev();
/*      */     
/* 1226 */     if (!isContainer()) {
/*      */       
/* 1228 */       next();
/* 1229 */       return false;
/*      */     } 
/*      */     
/* 1232 */     return toLastAttr();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean skipWithAttrs() {
/* 1237 */     assert isNode();
/*      */     
/* 1239 */     if (skip()) {
/* 1240 */       return true;
/*      */     }
/* 1242 */     if (this._xobj.isRoot()) {
/* 1243 */       return false;
/*      */     }
/* 1245 */     assert this._xobj.isAttr();
/*      */     
/* 1247 */     toParent();
/*      */     
/* 1249 */     next();
/*      */     
/* 1251 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean skip() {
/* 1256 */     assert isNode();
/*      */     
/* 1258 */     if (this._xobj.isRoot()) {
/* 1259 */       return false;
/*      */     }
/* 1261 */     if (this._xobj.isAttr()) {
/*      */       
/* 1263 */       if (this._xobj._nextSibling == null || !this._xobj._nextSibling.isAttr()) {
/* 1264 */         return false;
/*      */       }
/* 1266 */       moveTo(this._xobj._nextSibling, 0);
/*      */     } else {
/*      */       
/* 1269 */       moveTo(getNormal(this._xobj, this._xobj.posAfter()), this._posTemp);
/*      */     } 
/* 1271 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   void toEnd() {
/* 1276 */     assert isNode();
/*      */     
/* 1278 */     moveTo(this._xobj, -1);
/*      */   }
/*      */ 
/*      */   
/*      */   void moveToCharNode(DomImpl.CharNode paramCharNode) {
/* 1283 */     assert paramCharNode.getDom() != null && paramCharNode.getDom().locale() == this._locale;
/*      */     
/* 1285 */     moveToDom(paramCharNode.getDom());
/*      */ 
/*      */ 
/*      */     
/* 1289 */     this._xobj.ensureOccupancy();
/*      */     
/* 1291 */     DomImpl.CharNode charNode = this._xobj._charNodesValue = updateCharNodes(this._locale, this._xobj, this._xobj._charNodesValue, this._xobj._cchValue);
/*      */ 
/*      */     
/* 1294 */     for (; charNode != null; charNode = charNode._next) {
/*      */       
/* 1296 */       if (paramCharNode == charNode) {
/*      */         
/* 1298 */         moveTo(getNormal(this._xobj, charNode._off + 1), this._posTemp);
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/* 1303 */     charNode = this._xobj._charNodesAfter = updateCharNodes(this._locale, this._xobj, this._xobj._charNodesAfter, this._xobj._cchAfter);
/*      */ 
/*      */     
/* 1306 */     for (; charNode != null; charNode = charNode._next) {
/*      */       
/* 1308 */       if (paramCharNode == charNode) {
/*      */         
/* 1310 */         moveTo(getNormal(this._xobj, charNode._off + this._xobj._cchValue + 2), this._posTemp);
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     assert false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   boolean prevWithAttrs() {
/* 1320 */     if (prev()) {
/* 1321 */       return true;
/*      */     }
/* 1323 */     if (!isAttr()) {
/* 1324 */       return false;
/*      */     }
/* 1326 */     toParent();
/*      */     
/* 1328 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean prev() {
/* 1333 */     assert isPositioned();
/*      */     
/* 1335 */     if (this._xobj.isRoot() && this._pos == 0) {
/* 1336 */       return false;
/*      */     }
/* 1338 */     if (this._xobj.isAttr() && this._pos == 0 && this._xobj._prevSibling == null) {
/* 1339 */       return false;
/*      */     }
/* 1341 */     Xobj xobj = getDenormal();
/* 1342 */     int i = this._posTemp;
/*      */     
/* 1344 */     assert i > 0 && i != -1;
/*      */     
/* 1346 */     int j = xobj.posAfter();
/*      */     
/* 1348 */     if (i > j) {
/* 1349 */       i = j;
/* 1350 */     } else if (i == j) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1358 */       if (xobj.isAttr() && (xobj._cchAfter > 0 || xobj._nextSibling == null || !xobj._nextSibling.isAttr())) {
/*      */ 
/*      */         
/* 1361 */         xobj = xobj.ensureParent();
/* 1362 */         i = 0;
/*      */       } else {
/*      */         
/* 1365 */         i = -1;
/*      */       } 
/* 1367 */     } else if (i == j - 1) {
/*      */       
/* 1369 */       xobj.ensureOccupancy();
/* 1370 */       i = (xobj._cchValue > 0) ? 1 : 0;
/*      */     }
/* 1372 */     else if (i > 1) {
/* 1373 */       i = 1;
/*      */     } else {
/*      */       
/* 1376 */       assert i == 1;
/* 1377 */       i = 0;
/*      */     } 
/*      */     
/* 1380 */     moveTo(getNormal(xobj, i), this._posTemp);
/*      */     
/* 1382 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean next(boolean paramBoolean) {
/* 1387 */     return paramBoolean ? nextWithAttrs() : next();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean nextWithAttrs() {
/* 1392 */     int i = kind();
/*      */     
/* 1394 */     if (kindIsContainer(i)) {
/*      */       
/* 1396 */       if (toFirstAttr()) {
/* 1397 */         return true;
/*      */       }
/* 1399 */     } else if (i == -3) {
/*      */       
/* 1401 */       if (next()) {
/* 1402 */         return true;
/*      */       }
/* 1404 */       toParent();
/*      */       
/* 1406 */       if (!toParentRaw()) {
/* 1407 */         return false;
/*      */       }
/*      */     } 
/* 1410 */     return next();
/*      */   }
/*      */ 
/*      */   
/*      */   boolean next() {
/* 1415 */     assert isNormal();
/*      */     
/* 1417 */     Xobj xobj = this._xobj;
/* 1418 */     int i = this._pos;
/*      */     
/* 1420 */     int j = xobj.posAfter();
/*      */     
/* 1422 */     if (i >= j) {
/* 1423 */       i = this._xobj.posMax();
/* 1424 */     } else if (i == -1) {
/*      */       
/* 1426 */       if (xobj.isRoot() || (xobj.isAttr() && (xobj._nextSibling == null || !xobj._nextSibling.isAttr()))) {
/* 1427 */         return false;
/*      */       }
/* 1429 */       i = j;
/*      */     }
/* 1431 */     else if (i > 0) {
/*      */       
/* 1433 */       assert xobj._firstChild == null || !xobj._firstChild.isAttr();
/*      */       
/* 1435 */       if (xobj._firstChild != null) {
/*      */         
/* 1437 */         xobj = xobj._firstChild;
/* 1438 */         i = 0;
/*      */       } else {
/*      */         
/* 1441 */         i = -1;
/*      */       } 
/*      */     } else {
/*      */       
/* 1445 */       assert i == 0;
/*      */       
/* 1447 */       xobj.ensureOccupancy();
/*      */       
/* 1449 */       i = 1;
/*      */       
/* 1451 */       if (xobj._cchValue == 0)
/*      */       {
/* 1453 */         if (xobj._firstChild != null)
/*      */         {
/* 1455 */           if (xobj._firstChild.isAttr()) {
/*      */             
/* 1457 */             Xobj xobj1 = xobj._firstChild;
/*      */             
/* 1459 */             while (xobj1._nextSibling != null && xobj1._nextSibling.isAttr()) {
/* 1460 */               xobj1 = xobj1._nextSibling;
/*      */             }
/* 1462 */             if (xobj1._cchAfter > 0)
/*      */             {
/* 1464 */               xobj = xobj1;
/* 1465 */               i = xobj1.posAfter();
/*      */             }
/* 1467 */             else if (xobj1._nextSibling != null)
/*      */             {
/* 1469 */               xobj = xobj1._nextSibling;
/* 1470 */               i = 0;
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/* 1475 */             xobj = xobj._firstChild;
/* 1476 */             i = 0;
/*      */           } 
/*      */         }
/*      */       }
/*      */     } 
/*      */     
/* 1482 */     moveTo(getNormal(xobj, i), this._posTemp);
/*      */     
/* 1484 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   int prevChars(int paramInt) {
/* 1489 */     assert isPositioned();
/*      */     
/* 1491 */     int i = cchLeft();
/*      */     
/* 1493 */     if (paramInt < 0 || paramInt > i) {
/* 1494 */       paramInt = i;
/*      */     }
/*      */ 
/*      */     
/* 1498 */     if (paramInt != 0) {
/* 1499 */       moveTo(getNormal(getDenormal(), this._posTemp - paramInt), this._posTemp);
/*      */     }
/* 1501 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   int nextChars(int paramInt) {
/* 1506 */     assert isPositioned();
/*      */     
/* 1508 */     int i = cchRight();
/*      */     
/* 1510 */     if (i == 0) {
/* 1511 */       return 0;
/*      */     }
/* 1513 */     if (paramInt < 0 || paramInt >= i) {
/*      */ 
/*      */       
/* 1516 */       next();
/* 1517 */       return i;
/*      */     } 
/*      */     
/* 1520 */     moveTo(getNormal(this._xobj, this._pos + paramInt), this._posTemp);
/*      */     
/* 1522 */     return paramInt;
/*      */   }
/*      */ 
/*      */   
/*      */   void setCharNodes(DomImpl.CharNode paramCharNode) {
/* 1527 */     assert paramCharNode == null || this._locale == paramCharNode.locale();
/* 1528 */     assert isPositioned();
/*      */     
/* 1530 */     Xobj xobj = getDenormal();
/* 1531 */     int i = this._posTemp;
/*      */     
/* 1533 */     assert !xobj.isRoot() || (i > 0 && i < xobj.posAfter());
/*      */     
/* 1535 */     if (i >= xobj.posAfter()) {
/* 1536 */       xobj._charNodesAfter = paramCharNode;
/*      */     } else {
/* 1538 */       xobj._charNodesValue = paramCharNode;
/*      */     } 
/* 1540 */     for (; paramCharNode != null; paramCharNode = paramCharNode._next) {
/* 1541 */       paramCharNode.setDom((DomImpl.Dom)xobj);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   DomImpl.CharNode getCharNodes() {
/*      */     DomImpl.CharNode charNode;
/* 1549 */     assert isPositioned();
/* 1550 */     assert !isRoot();
/*      */     
/* 1552 */     Xobj xobj = getDenormal();
/*      */ 
/*      */ 
/*      */     
/* 1556 */     if (this._posTemp >= xobj.posAfter()) {
/*      */       
/* 1558 */       charNode = xobj._charNodesAfter = updateCharNodes(this._locale, xobj, xobj._charNodesAfter, xobj._cchAfter);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1563 */       xobj.ensureOccupancy();
/*      */       
/* 1565 */       charNode = xobj._charNodesValue = updateCharNodes(this._locale, xobj, xobj._charNodesValue, xobj._cchValue);
/*      */     } 
/*      */ 
/*      */     
/* 1569 */     return charNode;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static DomImpl.CharNode updateCharNodes(Locale paramLocale, Xobj paramXobj, DomImpl.CharNode paramCharNode, int paramInt) {
/* 1575 */     assert paramCharNode == null || paramCharNode.locale() == paramLocale;
/*      */     
/* 1577 */     DomImpl.CharNode charNode = paramCharNode;
/* 1578 */     int i = 0;
/*      */     
/* 1580 */     while (charNode != null && paramInt > 0) {
/*      */       
/* 1582 */       assert charNode.getDom() == paramXobj;
/*      */       
/* 1584 */       if (charNode._cch > paramInt) {
/* 1585 */         charNode._cch = paramInt;
/*      */       }
/* 1587 */       charNode._off = i;
/* 1588 */       i += charNode._cch;
/* 1589 */       paramInt -= charNode._cch;
/*      */       
/* 1591 */       charNode = charNode._next;
/*      */     } 
/*      */     
/* 1594 */     if (paramInt <= 0) {
/*      */       
/* 1596 */       for (; charNode != null; charNode = charNode._next)
/*      */       {
/* 1598 */         assert charNode.getDom() == paramXobj;
/*      */         
/* 1600 */         if (charNode._cch != 0) {
/* 1601 */           charNode._cch = 0;
/*      */         }
/* 1603 */         charNode._off = i;
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1608 */       charNode = paramLocale.createTextNode();
/* 1609 */       charNode.setDom((DomImpl.Dom)paramXobj);
/* 1610 */       charNode._cch = paramInt;
/* 1611 */       charNode._off = i;
/* 1612 */       paramCharNode = DomImpl.CharNode.appendNode(paramCharNode, charNode);
/*      */     } 
/*      */     
/* 1615 */     return paramCharNode;
/*      */   }
/*      */ 
/*      */   
/*      */   final b getXsiTypeName() {
/* 1620 */     assert isNode();
/*      */     
/* 1622 */     return this._xobj.getXsiTypeName();
/*      */   }
/*      */ 
/*      */   
/*      */   final void setXsiType(b paramb) {
/* 1627 */     assert isContainer();
/*      */     
/* 1629 */     setAttrValueAsQName(Locale._xsiType, paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   final b valueAsQName() {
/* 1634 */     throw new RuntimeException("Not implemented");
/*      */   }
/*      */ 
/*      */   
/*      */   final String namespaceForPrefix(String paramString, boolean paramBoolean) {
/* 1639 */     return this._xobj.namespaceForPrefix(paramString, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   final String prefixForNamespace(String paramString1, String paramString2, boolean paramBoolean) {
/* 1644 */     return (isContainer() ? this._xobj : getParent()).prefixForNamespace(paramString1, paramString2, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean contains(Cur paramCur) {
/* 1653 */     assert isNode();
/* 1654 */     assert paramCur != null && paramCur.isPositioned();
/*      */     
/* 1656 */     return this._xobj.contains(paramCur);
/*      */   }
/*      */ 
/*      */   
/*      */   void insertString(String paramString) {
/* 1661 */     if (paramString != null) {
/* 1662 */       insertChars(paramString, 0, paramString.length());
/*      */     }
/*      */   }
/*      */   
/*      */   void insertChars(Object paramObject, int paramInt1, int paramInt2) {
/* 1667 */     assert isPositioned() && !isRoot();
/* 1668 */     assert CharUtil.isValid(paramObject, paramInt1, paramInt2);
/*      */ 
/*      */ 
/*      */     
/* 1672 */     if (paramInt2 <= 0) {
/*      */       return;
/*      */     }
/* 1675 */     this._locale.notifyChange();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1683 */     if (this._pos == -1) {
/* 1684 */       this._xobj.ensureOccupancy();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1689 */     Xobj xobj = getDenormal();
/* 1690 */     int i = this._posTemp;
/*      */     
/* 1692 */     assert i > 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1698 */     xobj.insertCharsHelper(i, paramObject, paramInt1, paramInt2, true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1704 */     moveTo(xobj, i);
/*      */     
/* 1706 */     this._locale._versionAll++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object moveChars(Cur paramCur, int paramInt) {
/* 1714 */     assert isPositioned();
/* 1715 */     assert paramInt <= 0 || paramInt <= cchRight();
/* 1716 */     assert paramCur == null || (paramCur.isPositioned() && !paramCur.isRoot());
/*      */     
/* 1718 */     if (paramInt < 0) {
/* 1719 */       paramInt = cchRight();
/*      */     }
/*      */ 
/*      */     
/* 1723 */     if (paramInt == 0) {
/*      */       
/* 1725 */       this._offSrc = 0;
/* 1726 */       this._cchSrc = 0;
/*      */       
/* 1728 */       return null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1734 */     Object object = getChars(paramInt);
/* 1735 */     int i = this._offSrc;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1740 */     assert isText() && ((this._pos >= this._xobj.posAfter()) ? this._xobj._parent : this._xobj).isOccupied();
/*      */     
/* 1742 */     if (paramCur == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1749 */       for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next)
/*      */       {
/* 1751 */         if (inChars(bookmark, paramInt, false))
/*      */         {
/* 1753 */           Cur cur = this._locale.tempCur();
/*      */           
/* 1755 */           cur.createRoot();
/* 1756 */           cur.next();
/*      */           
/* 1758 */           Object object1 = moveChars(cur, paramInt);
/*      */           
/* 1760 */           cur.release();
/*      */           
/* 1762 */           return object1;
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */ 
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/* 1776 */       if (inChars(paramCur, paramInt, true)) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1781 */         paramCur.moveToCur(this);
/* 1782 */         nextChars(paramInt);
/*      */         
/* 1784 */         this._offSrc = i;
/* 1785 */         this._cchSrc = paramInt;
/*      */         
/* 1787 */         return object;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1792 */       paramCur.insertChars(object, i, paramInt);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1800 */     this._locale.notifyChange();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1805 */     if (paramCur == null) {
/* 1806 */       this._xobj.removeCharsHelper(this._pos, paramInt, null, -2, false, true);
/*      */     } else {
/* 1808 */       this._xobj.removeCharsHelper(this._pos, paramInt, paramCur._xobj, paramCur._pos, false, true);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1816 */     this._locale._versionAll++;
/*      */     
/* 1818 */     this._offSrc = i;
/* 1819 */     this._cchSrc = paramInt;
/*      */     
/* 1821 */     return object;
/*      */   }
/*      */ 
/*      */   
/*      */   void moveNode(Cur paramCur) {
/* 1826 */     assert isNode() && !isRoot();
/* 1827 */     assert paramCur == null || paramCur.isPositioned();
/* 1828 */     assert paramCur == null || !contains(paramCur);
/* 1829 */     assert paramCur == null || !paramCur.isRoot();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1838 */     Xobj xobj = this._xobj;
/*      */     
/* 1840 */     skip();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1846 */     moveNode(xobj, paramCur);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void transferChars(Xobj paramXobj1, int paramInt1, Xobj paramXobj2, int paramInt2, int paramInt3) {
/* 1857 */     assert paramXobj1 != paramXobj2;
/* 1858 */     assert paramXobj1._locale == paramXobj2._locale;
/* 1859 */     assert paramInt1 > 0 && paramInt1 < paramXobj1.posMax();
/* 1860 */     assert paramInt2 > 0 && paramInt2 <= paramXobj2.posMax();
/* 1861 */     assert paramInt3 > 0 && paramInt3 <= paramXobj1.cchRight(paramInt1);
/* 1862 */     assert paramInt2 >= paramXobj2.posAfter() || paramXobj2.isOccupied();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1869 */     paramXobj2.insertCharsHelper(paramInt2, paramXobj1.getCharsHelper(paramInt1, paramInt3), paramXobj1._locale._offSrc, paramXobj1._locale._cchSrc, false);
/*      */ 
/*      */ 
/*      */     
/* 1873 */     paramXobj1.removeCharsHelper(paramInt1, paramInt3, paramXobj2, paramInt2, true, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void moveNode(Xobj paramXobj, Cur paramCur) {
/* 1880 */     assert paramXobj != null && !paramXobj.isRoot();
/* 1881 */     assert paramCur == null || paramCur.isPositioned();
/* 1882 */     assert paramCur == null || !paramXobj.contains(paramCur);
/* 1883 */     assert paramCur == null || !paramCur.isRoot();
/*      */     
/* 1885 */     if (paramCur != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1891 */       if (paramCur._pos == -1) {
/* 1892 */         paramCur._xobj.ensureOccupancy();
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1899 */       if ((paramCur._pos == 0 && paramCur._xobj == paramXobj) || paramCur.isJustAfterEnd(paramXobj)) {
/*      */ 
/*      */ 
/*      */         
/* 1903 */         paramCur.moveTo(paramXobj);
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */     } 
/*      */     
/* 1910 */     paramXobj._locale.notifyChange();
/*      */     
/* 1912 */     paramXobj._locale._versionAll++;
/* 1913 */     paramXobj._locale._versionSansText++;
/*      */     
/* 1915 */     if (paramCur != null && paramCur._locale != paramXobj._locale) {
/*      */       
/* 1917 */       paramCur._locale.notifyChange();
/*      */       
/* 1919 */       paramCur._locale._versionAll++;
/* 1920 */       paramCur._locale._versionSansText++;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1926 */     if (paramXobj.isAttr()) {
/* 1927 */       paramXobj.invalidateSpecialAttr((paramCur == null) ? null : paramCur.getParentRaw());
/*      */     } else {
/*      */       
/* 1930 */       if (paramXobj._parent != null) {
/* 1931 */         paramXobj._parent.invalidateUser();
/*      */       }
/* 1933 */       if (paramCur != null && paramCur.hasParent()) {
/* 1934 */         paramCur.getParent().invalidateUser();
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1944 */     if (paramXobj._cchAfter > 0) {
/* 1945 */       transferChars(paramXobj, paramXobj.posAfter(), paramXobj.getDenormal(0), paramXobj.posTemp(), paramXobj._cchAfter);
/*      */     }
/* 1947 */     assert paramXobj._cchAfter == 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1953 */     paramXobj._locale.embedCurs();
/*      */     Xobj xobj;
/* 1955 */     for (xobj = paramXobj; xobj != null; xobj = xobj.walk(paramXobj, true)) {
/*      */       
/* 1957 */       while (xobj._embedded != null) {
/* 1958 */         xobj._embedded.moveTo(paramXobj.getNormal(paramXobj.posAfter()));
/*      */       }
/* 1960 */       xobj.disconnectUser();
/*      */       
/* 1962 */       if (paramCur != null) {
/* 1963 */         xobj._locale = paramCur._locale;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1968 */     paramXobj.removeXobj();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1973 */     if (paramCur != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1979 */       xobj = paramCur._xobj;
/* 1980 */       boolean bool = (paramCur._pos != 0) ? true : false;
/*      */       
/* 1982 */       int i = paramCur.cchRight();
/*      */       
/* 1984 */       if (i > 0) {
/*      */         
/* 1986 */         paramCur.push();
/* 1987 */         paramCur.next();
/* 1988 */         xobj = paramCur._xobj;
/* 1989 */         bool = (paramCur._pos != 0) ? true : false;
/* 1990 */         paramCur.pop();
/*      */       } 
/*      */       
/* 1993 */       if (bool) {
/* 1994 */         xobj.appendXobj(paramXobj);
/*      */       } else {
/* 1996 */         xobj.insertXobj(paramXobj);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2001 */       if (i > 0) {
/* 2002 */         transferChars(paramCur._xobj, paramCur._pos, paramXobj, paramXobj.posAfter(), i);
/*      */       }
/* 2004 */       paramCur.moveTo(paramXobj);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   void moveNodeContents(Cur paramCur, boolean paramBoolean) {
/* 2010 */     assert this._pos == 0;
/* 2011 */     assert paramCur == null || !paramCur.isRoot();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2016 */     moveNodeContents(this._xobj, paramCur, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void moveNodeContents(Xobj paramXobj, Cur paramCur, boolean paramBoolean) {
/* 2023 */     assert paramCur == null || !paramCur.isRoot();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2028 */     boolean bool = paramXobj.hasAttrs();
/* 2029 */     boolean bool1 = (!paramXobj.hasChildren() && (!paramBoolean || !bool)) ? true : false;
/*      */ 
/*      */ 
/*      */     
/* 2033 */     if (bool1) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2039 */       if (paramXobj.isVacant() && paramCur == null) {
/*      */         
/* 2041 */         paramXobj.clearBit(256);
/*      */         
/* 2043 */         paramXobj.invalidateUser();
/* 2044 */         paramXobj.invalidateSpecialAttr(null);
/* 2045 */         paramXobj._locale._versionAll++;
/*      */       }
/* 2047 */       else if (paramXobj.hasTextEnsureOccupancy()) {
/*      */         
/* 2049 */         Cur cur1 = paramXobj.tempCur();
/* 2050 */         cur1.next();
/* 2051 */         cur1.moveChars(paramCur, -1);
/* 2052 */         cur1.release();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 2061 */     if (paramCur != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2066 */       if (paramXobj == paramCur._xobj && paramCur._pos == -1) {
/*      */ 
/*      */ 
/*      */         
/* 2070 */         paramCur.moveTo(paramXobj);
/* 2071 */         paramCur.next((paramBoolean && bool));
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         return;
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2081 */       boolean bool3 = false;
/*      */       
/* 2083 */       if (paramCur._locale == paramXobj._locale) {
/*      */         
/* 2085 */         paramCur.push();
/* 2086 */         paramCur.moveTo(paramXobj);
/* 2087 */         paramCur.next((paramBoolean && bool));
/* 2088 */         bool3 = paramCur.isAtLastPush();
/* 2089 */         paramCur.pop();
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2094 */       if (bool3) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/* 2099 */       assert !paramXobj.contains(paramCur);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2105 */       assert paramCur.getParent().isOccupied();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2114 */     int i = 0;
/*      */     
/* 2116 */     if (paramXobj.hasTextNoEnsureOccupancy()) {
/*      */       
/* 2118 */       Cur cur1 = paramXobj.tempCur();
/* 2119 */       cur1.next();
/* 2120 */       cur1.moveChars(paramCur, -1);
/* 2121 */       cur1.release();
/*      */       
/* 2123 */       if (paramCur != null) {
/* 2124 */         paramCur.nextChars(i = cur1._cchSrc);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2131 */     paramXobj._locale.embedCurs();
/*      */     
/* 2133 */     Xobj xobj1 = paramXobj.walk(paramXobj, true);
/* 2134 */     boolean bool2 = false;
/*      */     
/* 2136 */     Xobj xobj2 = xobj1; while (true) { if (xobj2 != null)
/*      */       
/* 2138 */       { if (xobj2._parent == paramXobj && xobj2.isAttr())
/*      */         
/* 2140 */         { assert xobj2._cchAfter == 0;
/*      */           
/* 2142 */           if (!paramBoolean)
/*      */           
/* 2144 */           { xobj1 = xobj2._nextSibling; }
/*      */           
/*      */           else
/*      */           
/* 2148 */           { xobj2.invalidateSpecialAttr((paramCur == null) ? null : paramCur.getParent());
/*      */             
/*      */             Cur cur2;
/* 2151 */             while ((cur2 = xobj2._embedded) != null)
/* 2152 */               cur2.moveTo(paramXobj, -1);  }  continue; }  } else { break; }  Cur cur1; while ((cur1 = xobj2._embedded) != null) cur1.moveTo(paramXobj, -1);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       xobj2 = xobj2.walk(paramXobj, true); }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2162 */     xobj2 = paramXobj._lastChild;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2170 */     Cur cur = null;
/*      */     
/* 2172 */     if (bool2 && paramCur == null) {
/*      */       
/* 2174 */       cur = paramCur = paramXobj._locale.tempCur();
/* 2175 */       paramCur.createRoot();
/* 2176 */       paramCur.next();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2183 */     if (!xobj2.isAttr()) {
/* 2184 */       paramXobj.invalidateUser();
/*      */     }
/* 2186 */     paramXobj._locale._versionAll++;
/* 2187 */     paramXobj._locale._versionSansText++;
/*      */     
/* 2189 */     if (paramCur != null && i == 0) {
/*      */       
/* 2191 */       paramCur.getParent().invalidateUser();
/* 2192 */       paramCur._locale._versionAll++;
/* 2193 */       paramCur._locale._versionSansText++;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2198 */     paramXobj.removeXobjs(xobj1, xobj2);
/*      */     
/* 2200 */     if (paramCur != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 2205 */       Xobj xobj = paramCur._xobj;
/* 2206 */       boolean bool3 = (paramCur._pos != 0) ? true : false;
/*      */       
/* 2208 */       int j = paramCur.cchRight();
/*      */       
/* 2210 */       if (j > 0) {
/*      */         
/* 2212 */         paramCur.push();
/* 2213 */         paramCur.next();
/* 2214 */         xobj = paramCur._xobj;
/* 2215 */         bool3 = (paramCur._pos != 0) ? true : false;
/* 2216 */         paramCur.pop();
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
/*      */       
/* 2230 */       if (xobj1.isAttr()) {
/*      */         
/* 2232 */         Xobj xobj3 = xobj1;
/*      */         
/* 2234 */         while (xobj3._nextSibling != null && xobj3._nextSibling.isAttr()) {
/* 2235 */           xobj3 = xobj3._nextSibling;
/*      */         }
/*      */ 
/*      */         
/* 2239 */         Xobj xobj4 = paramCur.getParent();
/*      */         
/* 2241 */         if (j > 0) {
/* 2242 */           transferChars(paramCur._xobj, paramCur._pos, xobj3, xobj3.posMax(), j);
/*      */         }
/* 2244 */         if (xobj4.hasTextNoEnsureOccupancy()) {
/*      */           int k, m;
/*      */ 
/*      */           
/* 2248 */           if (xobj4._cchValue > 0) {
/*      */             
/* 2250 */             k = 1;
/* 2251 */             m = xobj4._cchValue;
/*      */           }
/*      */           else {
/*      */             
/* 2255 */             xobj4 = xobj4.lastAttr();
/* 2256 */             k = xobj4.posAfter();
/* 2257 */             m = xobj4._cchAfter;
/*      */           } 
/*      */           
/* 2260 */           transferChars(xobj4, k, xobj3, xobj3.posAfter(), m);
/*      */         }
/*      */       
/* 2263 */       } else if (j > 0) {
/* 2264 */         transferChars(paramCur._xobj, paramCur._pos, xobj2, xobj2.posMax(), j);
/*      */       } 
/*      */ 
/*      */       
/* 2268 */       if (bool3) {
/* 2269 */         xobj.appendXobjs(xobj1, xobj2);
/*      */       } else {
/* 2271 */         xobj.insertXobjs(xobj1, xobj2);
/*      */       } 
/*      */ 
/*      */       
/* 2275 */       paramCur.moveTo(xobj1);
/* 2276 */       paramCur.prevChars(i);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2281 */     if (cur != null) {
/* 2282 */       cur.release();
/*      */     }
/*      */   }
/*      */   
/*      */   protected final Xobj.Bookmark setBookmark(Object paramObject1, Object paramObject2) {
/* 2287 */     assert isNormal();
/* 2288 */     assert paramObject1 != null;
/*      */     
/* 2290 */     return this._xobj.setBookmark(this._pos, paramObject1, paramObject2);
/*      */   }
/*      */ 
/*      */   
/*      */   Object getBookmark(Object paramObject) {
/* 2295 */     assert isNormal();
/* 2296 */     assert paramObject != null;
/*      */     
/* 2298 */     for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
/* 2299 */       if (bookmark._pos == this._pos && bookmark._key == paramObject)
/* 2300 */         return bookmark._value; 
/*      */     } 
/* 2302 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   int firstBookmarkInChars(Object paramObject, int paramInt) {
/* 2307 */     assert isNormal();
/* 2308 */     assert paramObject != null;
/* 2309 */     assert paramInt > 0;
/* 2310 */     assert paramInt <= cchRight();
/*      */     
/* 2312 */     byte b = -1;
/*      */     
/* 2314 */     if (isText())
/*      */     {
/* 2316 */       for (Xobj.Bookmark bookmark = this._xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
/* 2317 */         if (bookmark._key == paramObject && inChars(bookmark, paramInt, false))
/* 2318 */           b = (b == -1 || bookmark._pos - this._pos < b) ? (bookmark._pos - this._pos) : b; 
/*      */       } 
/*      */     }
/* 2321 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   int firstBookmarkInCharsLeft(Object paramObject, int paramInt) {
/* 2326 */     assert isNormal();
/* 2327 */     assert paramObject != null;
/* 2328 */     assert paramInt > 0;
/* 2329 */     assert paramInt <= cchLeft();
/*      */     
/* 2331 */     byte b = -1;
/*      */     
/* 2333 */     if (cchLeft() > 0) {
/*      */       
/* 2335 */       Xobj xobj = getDenormal();
/* 2336 */       int i = this._posTemp - paramInt;
/*      */       
/* 2338 */       for (Xobj.Bookmark bookmark = xobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
/* 2339 */         if (bookmark._key == paramObject && xobj.inChars(i, bookmark._xobj, bookmark._pos, paramInt, false))
/* 2340 */           b = (b == -1 || bookmark._pos - i < b) ? (bookmark._pos - i) : b; 
/*      */       } 
/*      */     } 
/* 2343 */     return b;
/*      */   }
/*      */ 
/*      */   
/*      */   String getCharsAsString(int paramInt) {
/* 2348 */     assert isNormal() && this._xobj != null;
/*      */     
/* 2350 */     return getCharsAsString(paramInt, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   String getCharsAsString(int paramInt1, int paramInt2) {
/* 2355 */     return this._xobj.getCharsAsString(this._pos, paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */   
/*      */   String getValueAsString(int paramInt) {
/* 2360 */     assert isNode();
/*      */     
/* 2362 */     return this._xobj.getValueAsString(paramInt);
/*      */   }
/*      */ 
/*      */   
/*      */   String getValueAsString() {
/* 2367 */     assert isNode();
/* 2368 */     assert !hasChildren();
/*      */     
/* 2370 */     return this._xobj.getValueAsString();
/*      */   }
/*      */ 
/*      */   
/*      */   Object getChars(int paramInt) {
/* 2375 */     assert isPositioned();
/*      */     
/* 2377 */     return this._xobj.getChars(this._pos, paramInt, this);
/*      */   }
/*      */ 
/*      */   
/*      */   Object getFirstChars() {
/* 2382 */     assert isNode();
/*      */     
/* 2384 */     Object object = this._xobj.getFirstChars();
/*      */     
/* 2386 */     this._offSrc = this._locale._offSrc;
/* 2387 */     this._cchSrc = this._locale._cchSrc;
/*      */     
/* 2389 */     return object;
/*      */   }
/*      */ 
/*      */   
/*      */   void copyNode(Cur paramCur) {
/* 2394 */     assert paramCur != null;
/* 2395 */     assert isNode();
/*      */     
/* 2397 */     Xobj xobj = this._xobj.copyNode(paramCur._locale);
/*      */ 
/*      */ 
/*      */     
/* 2401 */     if (paramCur.isPositioned()) {
/* 2402 */       moveNode(xobj, paramCur);
/*      */     } else {
/* 2404 */       paramCur.moveTo(xobj);
/*      */     } 
/*      */   }
/*      */   
/*      */   Cur weakCur(Object paramObject) {
/* 2409 */     Cur cur = this._locale.weakCur(paramObject);
/* 2410 */     cur.moveToCur(this);
/* 2411 */     return cur;
/*      */   }
/*      */ 
/*      */   
/*      */   Cur tempCur() {
/* 2416 */     return tempCur(null);
/*      */   }
/*      */ 
/*      */   
/*      */   Cur tempCur(String paramString) {
/* 2421 */     Cur cur = this._locale.tempCur(paramString);
/* 2422 */     cur.moveToCur(this);
/* 2423 */     return cur;
/*      */   }
/*      */ 
/*      */   
/*      */   private Cur tempCur(Xobj paramXobj, int paramInt) {
/* 2428 */     assert this._locale == paramXobj._locale;
/* 2429 */     assert paramXobj != null || paramInt == -2;
/*      */     
/* 2431 */     Cur cur = this._locale.tempCur();
/*      */     
/* 2433 */     if (paramXobj != null) {
/* 2434 */       cur.moveTo(getNormal(paramXobj, paramInt), this._posTemp);
/*      */     }
/* 2436 */     return cur;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean inChars(Cur paramCur, int paramInt, boolean paramBoolean) {
/* 2445 */     assert isPositioned() && isText() && cchRight() >= paramInt;
/* 2446 */     assert paramCur.isNormal();
/*      */     
/* 2448 */     return this._xobj.inChars(this._pos, paramCur._xobj, paramCur._pos, paramInt, paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean inChars(Xobj.Bookmark paramBookmark, int paramInt, boolean paramBoolean) {
/* 2453 */     assert isPositioned() && isText() && cchRight() >= paramInt;
/* 2454 */     assert paramBookmark._xobj.isNormal(paramBookmark._pos);
/*      */     
/* 2456 */     return this._xobj.inChars(this._pos, paramBookmark._xobj, paramBookmark._pos, paramInt, paramBoolean);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Xobj getNormal(Xobj paramXobj, int paramInt) {
/* 2464 */     Xobj xobj = paramXobj.getNormal(paramInt);
/* 2465 */     this._posTemp = paramXobj._locale._posTemp;
/* 2466 */     return xobj;
/*      */   }
/*      */ 
/*      */   
/*      */   private Xobj getDenormal() {
/* 2471 */     assert isPositioned();
/*      */     
/* 2473 */     return getDenormal(this._xobj, this._pos);
/*      */   }
/*      */ 
/*      */   
/*      */   private Xobj getDenormal(Xobj paramXobj, int paramInt) {
/* 2478 */     Xobj xobj = paramXobj.getDenormal(paramInt);
/* 2479 */     this._posTemp = paramXobj._locale._posTemp;
/* 2480 */     return xobj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void setType(SchemaType paramSchemaType) {
/* 2487 */     setType(paramSchemaType, true);
/*      */   }
/*      */ 
/*      */   
/*      */   void setType(SchemaType paramSchemaType, boolean paramBoolean) {
/* 2492 */     assert paramSchemaType != null;
/* 2493 */     assert isUserNode();
/*      */     
/* 2495 */     TypeStoreUser typeStoreUser1 = peekUser();
/*      */     
/* 2497 */     if (typeStoreUser1 != null && typeStoreUser1.get_schema_type() == paramSchemaType) {
/*      */       return;
/*      */     }
/* 2500 */     if (isRoot()) {
/*      */       
/* 2502 */       this._xobj.setStableType(paramSchemaType);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2508 */     TypeStoreUser typeStoreUser2 = this._xobj.ensureParent().getUser();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2513 */     if (isAttr()) {
/*      */       
/* 2515 */       if (paramBoolean && typeStoreUser2.get_attribute_type(getName()) != paramSchemaType)
/*      */       {
/* 2517 */         throw new IllegalArgumentException("Can't set type of attribute to " + paramSchemaType.toString());
/*      */       }
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 2525 */     assert isElem();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2530 */     if (typeStoreUser2.get_element_type(getName(), null) == paramSchemaType) {
/*      */       
/* 2532 */       removeAttr(Locale._xsiType);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 2539 */     b b = paramSchemaType.getName();
/*      */     
/* 2541 */     if (b == null) {
/*      */       
/* 2543 */       if (paramBoolean) {
/* 2544 */         throw new IllegalArgumentException("Can't set type of element, type is un-named");
/*      */       }
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2551 */     if (typeStoreUser2.get_element_type(getName(), b) != paramSchemaType) {
/*      */       
/* 2553 */       if (paramBoolean) {
/* 2554 */         throw new IllegalArgumentException("Can't set type of element, invalid type");
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/* 2559 */     setAttrValueAsQName(Locale._xsiType, b);
/*      */   }
/*      */ 
/*      */   
/*      */   void setSubstitution(b paramb, SchemaType paramSchemaType) {
/* 2564 */     setSubstitution(paramb, paramSchemaType, true);
/*      */   }
/*      */ 
/*      */   
/*      */   void setSubstitution(b paramb, SchemaType paramSchemaType, boolean paramBoolean) {
/* 2569 */     assert paramb != null;
/* 2570 */     assert paramSchemaType != null;
/* 2571 */     assert isUserNode();
/*      */     
/* 2573 */     TypeStoreUser typeStoreUser1 = peekUser();
/*      */     
/* 2575 */     if (typeStoreUser1 != null && typeStoreUser1.get_schema_type() == paramSchemaType && paramb.equals(getName())) {
/*      */       return;
/*      */     }
/* 2578 */     if (isRoot()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2587 */     TypeStoreUser typeStoreUser2 = this._xobj.ensureParent().getUser();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2592 */     if (isAttr()) {
/*      */       
/* 2594 */       if (paramBoolean)
/*      */       {
/* 2596 */         throw new IllegalArgumentException("Can't use substitution with attributes");
/*      */       }
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 2604 */     assert isElem();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2609 */     if (typeStoreUser2.get_element_type(paramb, null) == paramSchemaType) {
/*      */       
/* 2611 */       setName(paramb);
/* 2612 */       removeAttr(Locale._xsiType);
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 2619 */     b b1 = paramSchemaType.getName();
/*      */     
/* 2621 */     if (b1 == null) {
/*      */       
/* 2623 */       if (paramBoolean) {
/* 2624 */         throw new IllegalArgumentException("Can't set xsi:type on element, type is un-named");
/*      */       }
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 2631 */     if (typeStoreUser2.get_element_type(paramb, b1) != paramSchemaType) {
/*      */       
/* 2633 */       if (paramBoolean) {
/* 2634 */         throw new IllegalArgumentException("Can't set xsi:type on element, invalid type");
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/* 2639 */     setName(paramb);
/* 2640 */     setAttrValueAsQName(Locale._xsiType, b1);
/*      */   }
/*      */ 
/*      */   
/*      */   TypeStoreUser peekUser() {
/* 2645 */     assert isUserNode();
/*      */     
/* 2647 */     return this._xobj._user;
/*      */   }
/*      */ 
/*      */   
/*      */   XmlObject getObject() {
/* 2652 */     return isUserNode() ? (XmlObject)getUser() : null;
/*      */   }
/*      */ 
/*      */   
/*      */   TypeStoreUser getUser() {
/* 2657 */     assert isUserNode();
/*      */     
/* 2659 */     return this._xobj.getUser();
/*      */   }
/*      */ 
/*      */   
/*      */   DomImpl.Dom getDom() {
/* 2664 */     assert isNormal();
/* 2665 */     assert isPositioned();
/*      */     
/* 2667 */     if (isText()) {
/*      */       
/* 2669 */       int i = cchLeft();
/*      */       
/* 2671 */       for (DomImpl.CharNode charNode = getCharNodes();; charNode = charNode._next) {
/* 2672 */         if ((i -= charNode._cch) < 0)
/* 2673 */           return charNode; 
/*      */       } 
/*      */     } 
/* 2676 */     return this._xobj.getDom();
/*      */   }
/*      */ 
/*      */   
/*      */   static void release(Cur paramCur) {
/* 2681 */     if (paramCur != null) {
/* 2682 */       paramCur.release();
/*      */     }
/*      */   }
/*      */   
/*      */   void release() {
/* 2687 */     if (this._tempFrame >= 0) {
/*      */       
/* 2689 */       if (this._nextTemp != null) {
/* 2690 */         this._nextTemp._prevTemp = this._prevTemp;
/*      */       }
/* 2692 */       if (this._prevTemp == null) {
/* 2693 */         this._locale._tempFrames[this._tempFrame] = this._nextTemp;
/*      */       } else {
/* 2695 */         this._prevTemp._nextTemp = this._nextTemp;
/*      */       } 
/* 2697 */       this._prevTemp = this._nextTemp = null;
/* 2698 */       this._tempFrame = -1;
/*      */     } 
/*      */     
/* 2701 */     if (this._state != 0 && this._state != 3) {
/*      */ 
/*      */ 
/*      */       
/* 2705 */       while (this._stackTop != -1) {
/* 2706 */         popButStay();
/*      */       }
/* 2708 */       clearSelection();
/*      */       
/* 2710 */       this._id = null;
/*      */ 
/*      */ 
/*      */       
/* 2714 */       moveToCur(null);
/*      */       
/* 2716 */       assert isNormal();
/*      */       
/* 2718 */       assert this._xobj == null;
/* 2719 */       assert this._pos == -2;
/*      */ 
/*      */ 
/*      */       
/* 2723 */       if (this._ref != null) {
/*      */         
/* 2725 */         this._ref.clear();
/* 2726 */         this._ref._cur = null;
/*      */       } 
/*      */       
/* 2729 */       this._ref = null;
/*      */ 
/*      */ 
/*      */       
/* 2733 */       assert this._state == 1;
/* 2734 */       this._locale._registered = listRemove(this._locale._registered);
/*      */       
/* 2736 */       if (this._locale._curPoolCount < 16) {
/*      */         
/* 2738 */         this._locale._curPool = listInsert(this._locale._curPool);
/* 2739 */         this._state = 0;
/* 2740 */         this._locale._curPoolCount++;
/*      */       }
/*      */       else {
/*      */         
/* 2744 */         this._locale = null;
/* 2745 */         this._state = 3;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isOnList(Cur paramCur) {
/* 2752 */     for (; paramCur != null; paramCur = paramCur._next) {
/* 2753 */       if (paramCur == this)
/* 2754 */         return true; 
/*      */     } 
/* 2756 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   Cur listInsert(Cur paramCur) {
/* 2761 */     assert this._next == null && this._prev == null;
/*      */     
/* 2763 */     if (paramCur == null) {
/* 2764 */       paramCur = this._prev = this;
/*      */     } else {
/*      */       
/* 2767 */       this._prev = paramCur._prev;
/* 2768 */       paramCur._prev = paramCur._prev._next = this;
/*      */     } 
/*      */     
/* 2771 */     return paramCur;
/*      */   }
/*      */ 
/*      */   
/*      */   Cur listRemove(Cur paramCur) {
/* 2776 */     assert this._prev != null && isOnList(paramCur);
/*      */     
/* 2778 */     if (this._prev == this) {
/* 2779 */       paramCur = null;
/*      */     } else {
/*      */       
/* 2782 */       if (paramCur == this) {
/* 2783 */         paramCur = this._next;
/*      */       } else {
/* 2785 */         this._prev._next = this._next;
/*      */       } 
/* 2787 */       if (this._next == null) {
/* 2788 */         paramCur._prev = this._prev;
/*      */       } else {
/*      */         
/* 2791 */         this._next._prev = this._prev;
/* 2792 */         this._next = null;
/*      */       } 
/*      */     } 
/*      */     
/* 2796 */     this._prev = null;
/* 2797 */     assert this._next == null;
/*      */     
/* 2799 */     return paramCur;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   boolean isNormal() {
/* 2809 */     if (this._state == 0 || this._state == 3) {
/* 2810 */       return false;
/*      */     }
/* 2812 */     if (this._xobj == null) {
/* 2813 */       return (this._pos == -2);
/*      */     }
/* 2815 */     if (!this._xobj.isNormal(this._pos)) {
/* 2816 */       return false;
/*      */     }
/* 2818 */     if (this._state == 2) {
/* 2819 */       return isOnList(this._xobj._embedded);
/*      */     }
/* 2821 */     assert this._state == 1;
/*      */     
/* 2823 */     return isOnList(this._locale._registered);
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
/*      */   static final class CurLoadContext
/*      */     extends Locale.LoadContext
/*      */   {
/*      */     private boolean _stripLeft;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Locale _locale;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private CharUtil _charUtil;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Xobj _frontier;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean _after;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Xobj _lastXobj;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private int _lastPos;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean _discardDocElem;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private b _replaceDocElem;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean _stripWhitespace;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean _stripComments;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean _stripProcinsts;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Map _substituteNamespaces;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Map _additionalNamespaces;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String _doctypeName;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String _doctypePublicId;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String _doctypeSystemId;
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
/*      */     private void start(Xobj param1Xobj) {
/*      */       assert this._frontier != null;
/*      */       assert !this._after || this._frontier._parent != null;
/*      */       flushText();
/*      */       if (this._after) {
/*      */         this._frontier = this._frontier._parent;
/*      */         this._after = false;
/*      */       } 
/*      */       this._frontier.appendXobj(param1Xobj);
/*      */       this._frontier = param1Xobj;
/*      */       this._lastXobj = param1Xobj;
/*      */       this._lastPos = 0;
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
/*      */     
/*      */     private void end() {
/*      */       assert this._frontier != null;
/*      */       assert !this._after || this._frontier._parent != null;
/*      */       flushText();
/*      */       if (this._after) {
/*      */         this._frontier = this._frontier._parent;
/*      */       } else {
/*      */         this._after = true;
/*      */       } 
/*      */       this._lastXobj = this._frontier;
/*      */       this._lastPos = -1;
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
/*      */     
/*      */     private void text(Object param1Object, int param1Int1, int param1Int2) {
/*      */       if (param1Int2 <= 0) {
/*      */         return;
/*      */       }
/*      */       this._lastXobj = this._frontier;
/*      */       this._lastPos = this._frontier._cchValue + 1;
/*      */       if (this._after) {
/*      */         this._lastPos += this._frontier._cchAfter + 1;
/*      */         this._frontier._srcAfter = this._charUtil.saveChars(param1Object, param1Int1, param1Int2, this._frontier._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
/*      */         this._frontier._offAfter = this._charUtil._offSrc;
/*      */         this._frontier._cchAfter = this._charUtil._cchSrc;
/*      */       } else {
/*      */         this._frontier._srcValue = this._charUtil.saveChars(param1Object, param1Int1, param1Int2, this._frontier._srcValue, this._frontier._offValue, this._frontier._cchValue);
/*      */         this._frontier._offValue = this._charUtil._offSrc;
/*      */         this._frontier._cchValue = this._charUtil._cchSrc;
/*      */       } 
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
/*      */     
/*      */     private void flushText() {
/*      */       if (this._stripWhitespace) {
/*      */         if (this._after) {
/*      */           this._frontier._srcAfter = this._charUtil.stripRight(this._frontier._srcAfter, this._frontier._offAfter, this._frontier._cchAfter);
/*      */           this._frontier._offAfter = this._charUtil._offSrc;
/*      */           this._frontier._cchAfter = this._charUtil._cchSrc;
/*      */         } else {
/*      */           this._frontier._srcValue = this._charUtil.stripRight(this._frontier._srcValue, this._frontier._offValue, this._frontier._cchValue);
/*      */           this._frontier._offValue = this._charUtil._offSrc;
/*      */           this._frontier._cchValue = this._charUtil._cchSrc;
/*      */         } 
/*      */       }
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
/*      */     CurLoadContext(Locale param1Locale, XmlOptions param1XmlOptions) {
/* 3114 */       this._stripLeft = true; param1XmlOptions = XmlOptions.maskNull(param1XmlOptions); this._locale = param1Locale; this._charUtil = param1XmlOptions.hasOption("LOAD_USE_LOCALE_CHAR_UTIL") ? this._locale.getCharUtil() : CharUtil.getThreadLocalCharUtil(); this._frontier = Cur.createDomDocumentRootXobj(this._locale); this._after = false; this._lastXobj = this._frontier; this._lastPos = 0; if (param1XmlOptions.hasOption("LOAD_REPLACE_DOCUMENT_ELEMENT")) { this._replaceDocElem = (b)param1XmlOptions.get("LOAD_REPLACE_DOCUMENT_ELEMENT"); this._discardDocElem = true; }  this._stripWhitespace = param1XmlOptions.hasOption("LOAD_STRIP_WHITESPACE"); this._stripComments = param1XmlOptions.hasOption("LOAD_STRIP_COMMENTS"); this._stripProcinsts = param1XmlOptions.hasOption("LOAD_STRIP_PROCINSTS"); this._substituteNamespaces = (Map)param1XmlOptions.get("LOAD_SUBSTITUTE_NAMESPACES"); this._additionalNamespaces = (Map)param1XmlOptions.get("LOAD_ADDITIONAL_NAMESPACES"); this._locale._versionAll++; this._locale._versionSansText++;
/*      */     } private Xobj parent() { return this._after ? this._frontier._parent : this._frontier; } private b checkName(b param1b, boolean param1Boolean) { if (this._substituteNamespaces != null && (!param1Boolean || param1b.getNamespaceURI().length() > 0)) { String str = (String)this._substituteNamespaces.get(param1b.getNamespaceURI()); if (str != null)
/*      */           param1b = this._locale.makeQName(str, param1b.dT(), param1b.getPrefix());  }  return param1b; } protected void startDTD(String param1String1, String param1String2, String param1String3) { this._doctypeName = param1String1; this._doctypePublicId = param1String2; this._doctypeSystemId = param1String3; }
/*      */     protected void endDTD() {}
/* 3118 */     private void stripText(Object param1Object, int param1Int1, int param1Int2) { if (this._stripWhitespace)
/*      */       {
/*      */         
/* 3121 */         if (this._stripLeft) {
/*      */           
/* 3123 */           param1Object = this._charUtil.stripLeft(param1Object, param1Int1, param1Int2);
/* 3124 */           this._stripLeft = false;
/* 3125 */           param1Int1 = this._charUtil._offSrc;
/* 3126 */           param1Int2 = this._charUtil._cchSrc;
/*      */         } 
/*      */       }
/*      */       
/* 3130 */       text(param1Object, param1Int1, param1Int2); }
/*      */     protected void startElement(b param1b) { start(Cur.createElementXobj(this._locale, checkName(param1b, false), (parent())._name));
/*      */       this._stripLeft = true; }
/*      */     protected void endElement() { assert parent().isElem();
/*      */       end();
/* 3135 */       this._stripLeft = true; } protected void text(String param1String) { if (param1String == null) {
/*      */         return;
/*      */       }
/* 3138 */       stripText(param1String, 0, param1String.length()); }
/*      */     protected void xmlns(String param1String1, String param1String2) { assert parent().isContainer(); if (this._substituteNamespaces != null) { String str = (String)this._substituteNamespaces.get(param1String2); if (str != null) param1String2 = str;  }  Xobj.AttrXobj attrXobj = new Xobj.AttrXobj(this._locale, this._locale.createXmlns(param1String1)); start(attrXobj); text(param1String2, 0, param1String2.length()); end(); this._lastXobj = attrXobj; this._lastPos = 0; }
/*      */     protected void attr(b param1b, String param1String) { assert parent().isContainer(); b b1 = this._after ? this._lastXobj._parent.getQName() : this._lastXobj.getQName(); boolean bool = isAttrOfTypeId(param1b, b1); Xobj.AttrXobj attrXobj = bool ? new Xobj.AttrIdXobj(this._locale, checkName(param1b, true)) : new Xobj.AttrXobj(this._locale, checkName(param1b, true)); start(attrXobj); text(param1String, 0, param1String.length()); end(); if (bool) { Cur cur = attrXobj.tempCur(); cur.toRoot(); Xobj xobj = cur._xobj; cur.release(); if (xobj instanceof Xobj.DocumentXobj) ((Xobj.DocumentXobj)xobj).addIdElement(param1String, attrXobj._parent.getDom());  }  this._lastXobj = attrXobj; this._lastPos = 0; }
/*      */     protected void attr(String param1String1, String param1String2, String param1String3, String param1String4) { attr(this._locale.makeQName(param1String2, param1String1, param1String3), param1String4); }
/*      */     protected void procInst(String param1String1, String param1String2) { if (!this._stripProcinsts) { Xobj.ProcInstXobj procInstXobj = new Xobj.ProcInstXobj(this._locale, param1String1); start(procInstXobj); text(param1String2, 0, param1String2.length()); end(); this._lastXobj = procInstXobj; this._lastPos = 0; }  this._stripLeft = true; }
/* 3143 */     protected void comment(String param1String) { if (!this._stripComments) comment(param1String, 0, param1String.length());  this._stripLeft = true; } protected void comment(char[] param1ArrayOfchar, int param1Int1, int param1Int2) { if (!this._stripComments) comment(this._charUtil.saveChars(param1ArrayOfchar, param1Int1, param1Int2), this._charUtil._offSrc, this._charUtil._cchSrc);  this._stripLeft = true; } private void comment(Object param1Object, int param1Int1, int param1Int2) { Xobj.CommentXobj commentXobj = new Xobj.CommentXobj(this._locale); start(commentXobj); text(param1Object, param1Int1, param1Int2); end(); this._lastXobj = commentXobj; this._lastPos = 0; } protected void text(char[] param1ArrayOfchar, int param1Int1, int param1Int2) { stripText(param1ArrayOfchar, param1Int1, param1Int2); }
/*      */ 
/*      */ 
/*      */     
/*      */     protected void bookmark(XmlCursor.XmlBookmark param1XmlBookmark) {
/* 3148 */       this._lastXobj.setBookmark(this._lastPos, param1XmlBookmark.getKey(), param1XmlBookmark);
/*      */     }
/*      */ 
/*      */     
/*      */     protected void bookmarkLastNonAttr(XmlCursor.XmlBookmark param1XmlBookmark) {
/* 3153 */       if (this._lastPos > 0 || !this._lastXobj.isAttr()) {
/* 3154 */         this._lastXobj.setBookmark(this._lastPos, param1XmlBookmark.getKey(), param1XmlBookmark);
/*      */       } else {
/*      */         
/* 3157 */         assert this._lastXobj._parent != null;
/*      */         
/* 3159 */         this._lastXobj._parent.setBookmark(0, param1XmlBookmark.getKey(), param1XmlBookmark);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     protected void bookmarkLastAttr(b param1b, XmlCursor.XmlBookmark param1XmlBookmark) {
/* 3165 */       if (this._lastPos == 0 && this._lastXobj.isAttr()) {
/*      */         
/* 3167 */         assert this._lastXobj._parent != null;
/*      */         
/* 3169 */         Xobj xobj = this._lastXobj._parent.getAttr(param1b);
/*      */         
/* 3171 */         if (xobj != null) {
/* 3172 */           xobj.setBookmark(0, param1XmlBookmark.getKey(), param1XmlBookmark);
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*      */     protected void lineNumber(int param1Int1, int param1Int2, int param1Int3) {
/* 3178 */       this._lastXobj.setBookmark(this._lastPos, (Cur.class$org$apache$xmlbeans$XmlLineNumber == null) ? (Cur.class$org$apache$xmlbeans$XmlLineNumber = Cur.class$("org.apache.xmlbeans.XmlLineNumber")) : Cur.class$org$apache$xmlbeans$XmlLineNumber, new XmlLineNumber(param1Int1, param1Int2, param1Int3));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     protected void abort() {
/* 3186 */       this._stripLeft = true;
/* 3187 */       while (!parent().isRoot()) {
/* 3188 */         end();
/*      */       }
/* 3190 */       finish().release();
/*      */     }
/*      */ 
/*      */     
/*      */     protected Cur finish() {
/* 3195 */       flushText();
/*      */       
/* 3197 */       if (this._after) {
/* 3198 */         this._frontier = this._frontier._parent;
/*      */       }
/* 3200 */       assert this._frontier != null && this._frontier._parent == null && this._frontier.isRoot();
/*      */       
/* 3202 */       Cur cur = this._frontier.tempCur();
/*      */       
/* 3204 */       if (!Locale.toFirstChildElement(cur)) {
/* 3205 */         return cur;
/*      */       }
/*      */ 
/*      */       
/* 3209 */       boolean bool = Locale.isFragmentQName(cur.getName());
/*      */       
/* 3211 */       if (this._discardDocElem || bool) {
/*      */         
/* 3213 */         if (this._replaceDocElem != null) {
/* 3214 */           cur.setName(this._replaceDocElem);
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/* 3220 */           while (cur.toParent());
/*      */ 
/*      */           
/* 3223 */           cur.next();
/*      */           
/* 3225 */           while (!cur.isElem()) {
/* 3226 */             if (cur.isText()) { cur.moveChars(null, -1); continue; }  cur.moveNode(null);
/*      */           } 
/* 3228 */           assert cur.isElem();
/* 3229 */           cur.skip();
/*      */           
/* 3231 */           while (!cur.isFinish()) {
/* 3232 */             if (cur.isText()) { cur.moveChars(null, -1); continue; }  cur.moveNode(null);
/*      */           } 
/* 3234 */           cur.toParent();
/*      */           
/* 3236 */           cur.next();
/*      */           
/* 3238 */           assert cur.isElem();
/*      */           
/* 3240 */           Cur cur1 = cur.tempCur();
/*      */           
/* 3242 */           cur.moveNodeContents(cur, true);
/*      */           
/* 3244 */           cur.moveToCur(cur1);
/*      */           
/* 3246 */           cur1.release();
/*      */           
/* 3248 */           cur.moveNode(null);
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 3253 */         if (bool) {
/*      */           
/* 3255 */           cur.moveTo(this._frontier);
/*      */           
/* 3257 */           if (cur.toFirstAttr())
/*      */           {
/*      */             while (true) {
/*      */               
/* 3261 */               if (cur.isXmlns() && cur.getXmlnsUri().equals("http://www.openuri.org/fragment")) {
/*      */                 
/* 3263 */                 cur.moveNode(null);
/*      */                 
/* 3265 */                 if (!cur.isAttr())
/*      */                   break;  continue;
/*      */               } 
/* 3268 */               if (!cur.toNextAttr()) {
/*      */                 break;
/*      */               }
/*      */             } 
/*      */           }
/* 3273 */           cur.moveTo(this._frontier);
/* 3274 */           this._frontier = Cur.createDomDocumentRootXobj(this._locale, true);
/*      */           
/* 3276 */           Cur cur1 = this._frontier.tempCur();
/* 3277 */           cur1.next();
/* 3278 */           cur.moveNodeContents(cur1, true);
/* 3279 */           cur.moveTo(this._frontier);
/* 3280 */           cur1.release();
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 3285 */       if (this._additionalNamespaces != null) {
/*      */         
/* 3287 */         cur.moveTo(this._frontier);
/* 3288 */         Locale.toFirstChildElement(cur);
/* 3289 */         Locale.applyNamespaces(cur, this._additionalNamespaces);
/*      */       } 
/*      */       
/* 3292 */       if (this._doctypeName != null && (this._doctypePublicId != null || this._doctypeSystemId != null)) {
/*      */         
/* 3294 */         XmlDocumentProperties xmlDocumentProperties = Locale.getDocProps(cur, true);
/* 3295 */         xmlDocumentProperties.setDoctypeName(this._doctypeName);
/* 3296 */         if (this._doctypePublicId != null)
/* 3297 */           xmlDocumentProperties.setDoctypePublicId(this._doctypePublicId); 
/* 3298 */         if (this._doctypeSystemId != null) {
/* 3299 */           xmlDocumentProperties.setDoctypeSystemId(this._doctypeSystemId);
/*      */         }
/*      */       } 
/* 3302 */       cur.moveTo(this._frontier);
/*      */       
/* 3304 */       assert cur.isRoot();
/*      */       
/* 3306 */       return cur;
/*      */     }
/*      */ 
/*      */     
/*      */     public void dump() {
/* 3311 */       this._frontier.dump();
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static String kindName(int paramInt) {
/* 3342 */     switch (paramInt) {
/*      */       case 1:
/* 3344 */         return "ROOT";
/* 3345 */       case 2: return "ELEM";
/* 3346 */       case 3: return "ATTR";
/* 3347 */       case 4: return "COMMENT";
/* 3348 */       case 5: return "PROCINST";
/* 3349 */       case 0: return "TEXT";
/* 3350 */     }  return "<< Unknown Kind (" + paramInt + ") >>";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void dump(PrintStream paramPrintStream, DomImpl.Dom paramDom, Object paramObject) {}
/*      */ 
/*      */ 
/*      */   
/*      */   static void dump(PrintStream paramPrintStream, DomImpl.Dom paramDom) {
/* 3360 */     paramDom.dump(paramPrintStream);
/*      */   }
/*      */ 
/*      */   
/*      */   static void dump(DomImpl.Dom paramDom) {
/* 3365 */     dump(System.out, paramDom);
/*      */   }
/*      */ 
/*      */   
/*      */   static void dump(Node paramNode) {
/* 3370 */     dump(System.out, paramNode);
/*      */   }
/*      */ 
/*      */   
/*      */   static void dump(PrintStream paramPrintStream, Node paramNode) {
/* 3375 */     dump(paramPrintStream, (DomImpl.Dom)paramNode);
/*      */   }
/*      */ 
/*      */   
/*      */   void dump() {
/* 3380 */     dump(System.out, this._xobj, this);
/*      */   }
/*      */ 
/*      */   
/*      */   void dump(PrintStream paramPrintStream) {
/* 3385 */     if (this._xobj == null) {
/*      */       
/* 3387 */       paramPrintStream.println("Unpositioned xptr");
/*      */       
/*      */       return;
/*      */     } 
/* 3391 */     dump(paramPrintStream, this._xobj, this);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void dump(PrintStream paramPrintStream, Xobj paramXobj, Object paramObject) {
/* 3396 */     if (paramObject == null) {
/* 3397 */       paramObject = paramXobj;
/*      */     }
/* 3399 */     while (paramXobj._parent != null) {
/* 3400 */       paramXobj = paramXobj._parent;
/*      */     }
/* 3402 */     dumpXobj(paramPrintStream, paramXobj, 0, paramObject);
/*      */     
/* 3404 */     paramPrintStream.println();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void dumpCur(PrintStream paramPrintStream, String paramString, Cur paramCur, Object paramObject) {
/* 3409 */     paramPrintStream.print(" ");
/*      */     
/* 3411 */     if (paramObject == paramCur) {
/* 3412 */       paramPrintStream.print("*:");
/*      */     }
/* 3414 */     paramPrintStream.print(paramString + ((paramCur._id == null) ? "<cur>" : paramCur._id) + "[" + paramCur._pos + "]");
/*      */   }
/*      */   
/*      */   private static void dumpCurs(PrintStream paramPrintStream, Xobj paramXobj, Object paramObject) {
/*      */     Cur cur;
/* 3419 */     for (cur = paramXobj._embedded; cur != null; cur = cur._next) {
/* 3420 */       dumpCur(paramPrintStream, "E:", cur, paramObject);
/*      */     }
/* 3422 */     for (cur = paramXobj._locale._registered; cur != null; cur = cur._next) {
/*      */       
/* 3424 */       if (cur._xobj == paramXobj) {
/* 3425 */         dumpCur(paramPrintStream, "R:", cur, paramObject);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void dumpBookmarks(PrintStream paramPrintStream, Xobj paramXobj, Object paramObject) {
/* 3431 */     for (Xobj.Bookmark bookmark = paramXobj._bookmarks; bookmark != null; bookmark = bookmark._next) {
/*      */       
/* 3433 */       paramPrintStream.print(" ");
/*      */       
/* 3435 */       if (paramObject == bookmark) {
/* 3436 */         paramPrintStream.print("*:");
/*      */       }
/* 3438 */       if (bookmark._value instanceof XmlLineNumber) {
/*      */         
/* 3440 */         XmlLineNumber xmlLineNumber = (XmlLineNumber)bookmark._value;
/* 3441 */         paramPrintStream.print("<line:" + xmlLineNumber.getLine() + ">" + "[" + bookmark._pos + "]");
/*      */       } else {
/*      */         
/* 3444 */         paramPrintStream.print("<mark>[" + bookmark._pos + "]");
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static void dumpCharNodes(PrintStream paramPrintStream, DomImpl.CharNode paramCharNode, Object paramObject) {
/* 3450 */     for (DomImpl.CharNode charNode = paramCharNode; charNode != null; charNode = charNode._next) {
/*      */       
/* 3452 */       paramPrintStream.print(" ");
/*      */       
/* 3454 */       if (charNode == paramObject) {
/* 3455 */         paramPrintStream.print("*");
/*      */       }
/* 3457 */       paramPrintStream.print(((charNode instanceof DomImpl.TextNode) ? "TEXT" : "CDATA") + "[" + charNode._cch + "]");
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void dumpChars(PrintStream paramPrintStream, Object paramObject, int paramInt1, int paramInt2) {
/* 3465 */     paramPrintStream.print("\"");
/*      */     
/* 3467 */     String str = CharUtil.getString(paramObject, paramInt1, paramInt2);
/*      */     
/* 3469 */     for (byte b = 0; b < str.length(); b++) {
/*      */       
/* 3471 */       if (b == 36) {
/*      */         
/* 3473 */         paramPrintStream.print("...");
/*      */         
/*      */         break;
/*      */       } 
/* 3477 */       char c = str.charAt(b);
/*      */       
/* 3479 */       if (c >= ' ' && c < '') {
/* 3480 */         paramPrintStream.print(c);
/* 3481 */       } else if (c == '\n') {
/* 3482 */         paramPrintStream.print("\\n");
/* 3483 */       } else if (c == '\r') {
/* 3484 */         paramPrintStream.print("\\r");
/* 3485 */       } else if (c == '\t') {
/* 3486 */         paramPrintStream.print("\\t");
/* 3487 */       } else if (c == '"') {
/* 3488 */         paramPrintStream.print("\\\"");
/*      */       } else {
/* 3490 */         paramPrintStream.print("<#" + c + ">");
/*      */       } 
/*      */     } 
/* 3493 */     paramPrintStream.print("\"");
/*      */   }
/*      */ 
/*      */   
/*      */   private static void dumpXobj(PrintStream paramPrintStream, Xobj paramXobj, int paramInt, Object paramObject) {
/* 3498 */     if (paramXobj == null) {
/*      */       return;
/*      */     }
/* 3501 */     if (paramXobj == paramObject) {
/* 3502 */       paramPrintStream.print("* ");
/*      */     } else {
/* 3504 */       paramPrintStream.print("  ");
/*      */     } 
/* 3506 */     for (byte b = 0; b < paramInt; b++) {
/* 3507 */       paramPrintStream.print("  ");
/*      */     }
/* 3509 */     paramPrintStream.print(kindName(paramXobj.kind()));
/*      */     
/* 3511 */     if (paramXobj._name != null) {
/*      */       
/* 3513 */       paramPrintStream.print(" ");
/*      */       
/* 3515 */       if (paramXobj._name.getPrefix().length() > 0) {
/* 3516 */         paramPrintStream.print(paramXobj._name.getPrefix() + ":");
/*      */       }
/* 3518 */       paramPrintStream.print(paramXobj._name.dT());
/*      */       
/* 3520 */       if (paramXobj._name.getNamespaceURI().length() > 0) {
/* 3521 */         paramPrintStream.print("@" + paramXobj._name.getNamespaceURI());
/*      */       }
/*      */     } 
/* 3524 */     if (paramXobj._srcValue != null || paramXobj._charNodesValue != null) {
/*      */       
/* 3526 */       paramPrintStream.print(" Value( ");
/* 3527 */       dumpChars(paramPrintStream, paramXobj._srcValue, paramXobj._offValue, paramXobj._cchValue);
/* 3528 */       dumpCharNodes(paramPrintStream, paramXobj._charNodesValue, paramObject);
/* 3529 */       paramPrintStream.print(" )");
/*      */     } 
/*      */     
/* 3532 */     if (paramXobj._user != null) {
/* 3533 */       paramPrintStream.print(" (USER)");
/*      */     }
/* 3535 */     if (paramXobj.isVacant()) {
/* 3536 */       paramPrintStream.print(" (VACANT)");
/*      */     }
/* 3538 */     if (paramXobj._srcAfter != null || paramXobj._charNodesAfter != null) {
/*      */       
/* 3540 */       paramPrintStream.print(" After( ");
/* 3541 */       dumpChars(paramPrintStream, paramXobj._srcAfter, paramXobj._offAfter, paramXobj._cchAfter);
/* 3542 */       dumpCharNodes(paramPrintStream, paramXobj._charNodesAfter, paramObject);
/* 3543 */       paramPrintStream.print(" )");
/*      */     } 
/*      */     
/* 3546 */     dumpCurs(paramPrintStream, paramXobj, paramObject);
/* 3547 */     dumpBookmarks(paramPrintStream, paramXobj, paramObject);
/*      */     
/* 3549 */     String str = paramXobj.getClass().getName();
/*      */     
/* 3551 */     int i = str.lastIndexOf('.');
/*      */     
/* 3553 */     if (i > 0) {
/*      */       
/* 3555 */       str = str.substring(i + 1);
/*      */       
/* 3557 */       i = str.lastIndexOf('$');
/*      */       
/* 3559 */       if (i > 0) {
/* 3560 */         str = str.substring(i + 1);
/*      */       }
/*      */     } 
/* 3563 */     paramPrintStream.print(" (");
/* 3564 */     paramPrintStream.print(str);
/* 3565 */     paramPrintStream.print(")");
/*      */     
/* 3567 */     paramPrintStream.println();
/*      */     
/* 3569 */     for (paramXobj = paramXobj._firstChild; paramXobj != null; paramXobj = paramXobj._nextSibling) {
/* 3570 */       dumpXobj(paramPrintStream, paramXobj, paramInt + 1, paramObject);
/*      */     }
/*      */   }
/*      */   
/*      */   void setId(String paramString) {
/* 3575 */     this._id = paramString;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Cur.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */