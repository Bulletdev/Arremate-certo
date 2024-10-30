/*      */ package org.apache.xmlbeans.impl.store;
/*      */ 
/*      */ import java.io.PrintStream;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Hashtable;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import javax.xml.transform.Source;
/*      */ import org.apache.xmlbeans.CDataBookmark;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.XmlBeans;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.ValidatorListener;
/*      */ import org.apache.xmlbeans.impl.common.XmlLocale;
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
/*      */ import org.apache.xmlbeans.impl.soap.SOAPFaultElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeader;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPHeaderElement;
/*      */ import org.apache.xmlbeans.impl.soap.SOAPPart;
/*      */ import org.apache.xmlbeans.impl.values.NamespaceManager;
/*      */ import org.apache.xmlbeans.impl.values.TypeStore;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreUser;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreUserFactory;
/*      */ import org.apache.xmlbeans.impl.values.TypeStoreVisitor;
/*      */ import org.w3c.dom.Attr;
/*      */ import org.w3c.dom.CDATASection;
/*      */ import org.w3c.dom.Comment;
/*      */ import org.w3c.dom.DOMConfiguration;
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
/*      */ import org.w3c.dom.TypeInfo;
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
/*      */ abstract class Xobj
/*      */   implements TypeStore
/*      */ {
/*      */   static final int TEXT = 0;
/*      */   static final int ROOT = 1;
/*      */   static final int ELEM = 2;
/*      */   static final int ATTR = 3;
/*      */   static final int COMMENT = 4;
/*      */   static final int PROCINST = 5;
/*      */   static final int END_POS = -1;
/*      */   static final int NO_POS = -2;
/*      */   static final int VACANT = 256;
/*      */   static final int STABLE_USER = 512;
/*      */   static final int INHIBIT_DISCONNECT = 1024;
/*      */   Locale _locale;
/*      */   b _name;
/*      */   Cur _embedded;
/*      */   Bookmark _bookmarks;
/*      */   int _bits;
/*      */   Xobj _parent;
/*      */   Xobj _nextSibling;
/*      */   Xobj _prevSibling;
/*      */   Xobj _firstChild;
/*      */   Xobj _lastChild;
/*      */   Object _srcValue;
/*      */   Object _srcAfter;
/*      */   int _offValue;
/*      */   int _offAfter;
/*      */   int _cchValue;
/*      */   int _cchAfter;
/*      */   DomImpl.CharNode _charNodesValue;
/*      */   DomImpl.CharNode _charNodesAfter;
/*      */   TypeStoreUser _user;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   Xobj(Locale paramLocale, int paramInt1, int paramInt2) {
/*  113 */     assert paramInt1 == 1 || paramInt1 == 2 || paramInt1 == 3 || paramInt1 == 4 || paramInt1 == 5;
/*      */     
/*  115 */     this._locale = paramLocale;
/*  116 */     this._bits = (paramInt2 << 4) + paramInt1;
/*      */   }
/*      */   final boolean entered() {
/*  119 */     return this._locale.entered();
/*      */   }
/*  121 */   final int kind() { return this._bits & 0xF; } final int domType() {
/*  122 */     return (this._bits & 0xF0) >> 4;
/*      */   }
/*  124 */   final boolean isRoot() { return (kind() == 1); }
/*  125 */   final boolean isAttr() { return (kind() == 3); }
/*  126 */   final boolean isElem() { return (kind() == 2); }
/*  127 */   final boolean isProcinst() { return (kind() == 5); }
/*  128 */   final boolean isComment() { return (kind() == 4); }
/*  129 */   final boolean isContainer() { return Cur.kindIsContainer(kind()); } final boolean isUserNode() {
/*  130 */     int i = kind(); return (i == 2 || i == 1 || (i == 3 && !isXmlns()));
/*      */   }
/*  132 */   final boolean isNormalAttr() { return (isAttr() && !Locale.isXmlns(this._name)); } final boolean isXmlns() {
/*  133 */     return (isAttr() && Locale.isXmlns(this._name));
/*      */   }
/*  135 */   final int cchValue() { return this._cchValue; } final int cchAfter() {
/*  136 */     return this._cchAfter;
/*      */   }
/*  138 */   final int posAfter() { return 2 + this._cchValue; } final int posMax() {
/*  139 */     return 2 + this._cchValue + this._cchAfter;
/*      */   }
/*  141 */   final String getXmlnsPrefix() { return Locale.xmlnsPrefix(this._name); } final String getXmlnsUri() {
/*  142 */     return getValueAsString();
/*      */   }
/*      */   
/*      */   final boolean hasTextEnsureOccupancy() {
/*  146 */     ensureOccupancy();
/*  147 */     return hasTextNoEnsureOccupancy();
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean hasTextNoEnsureOccupancy() {
/*  152 */     if (this._cchValue > 0) {
/*  153 */       return true;
/*      */     }
/*  155 */     Xobj xobj = lastAttr();
/*      */     
/*  157 */     return (xobj != null && xobj._cchAfter > 0);
/*      */   }
/*      */   
/*  160 */   final boolean hasAttrs() { return (this._firstChild != null && this._firstChild.isAttr()); } final boolean hasChildren() {
/*  161 */     return (this._lastChild != null && !this._lastChild.isAttr());
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
/*      */   protected final int getDomZeroOneChildren() {
/*  173 */     if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null)
/*      */     {
/*      */       
/*  176 */       return 0;
/*      */     }
/*  178 */     if (this._lastChild != null && this._lastChild.isAttr() && this._lastChild._charNodesAfter == null && this._lastChild._srcAfter == null && this._srcValue == null && this._charNodesValue == null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  185 */       return 0;
/*      */     }
/*  187 */     if (this._firstChild == this._lastChild && this._firstChild != null && !this._firstChild.isAttr() && this._srcValue == null && this._charNodesValue == null && this._firstChild._srcAfter == null)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  194 */       return 1;
/*      */     }
/*  196 */     if (this._firstChild == null && this._srcValue != null && (this._charNodesValue == null || (this._charNodesValue._next == null && this._charNodesValue._cch == this._cchValue)))
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  202 */       return 1;
/*      */     }
/*  204 */     Xobj xobj1 = lastAttr();
/*  205 */     Xobj xobj2 = (xobj1 == null) ? null : xobj1._nextSibling;
/*      */     
/*  207 */     if (xobj1 != null && xobj1._srcAfter == null && xobj2 != null && xobj2._srcAfter == null && xobj2._nextSibling == null)
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  212 */       return 1;
/*      */     }
/*  214 */     return 2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean isFirstChildPtrDomUsable() {
/*  225 */     if (this._firstChild == null && this._srcValue == null && this._charNodesValue == null)
/*      */     {
/*      */       
/*  228 */       return true;
/*      */     }
/*  230 */     if (this._firstChild != null && !this._firstChild.isAttr() && this._srcValue == null && this._charNodesValue == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  236 */       assert this._firstChild instanceof NodeXobj : "wrong node type";
/*  237 */       return true;
/*      */     } 
/*  239 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean isNextSiblingPtrDomUsable() {
/*  249 */     if (this._charNodesAfter == null && this._srcAfter == null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  254 */       assert this._nextSibling == null || this._nextSibling instanceof NodeXobj : "wrong node type";
/*  255 */       return true;
/*      */     } 
/*  257 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final boolean isExistingCharNodesValueUsable() {
/*  267 */     if (this._srcValue == null) return false; 
/*  268 */     if (this._charNodesValue != null && this._charNodesValue._next == null && this._charNodesValue._cch == this._cchValue)
/*      */     {
/*  270 */       return true; } 
/*  271 */     return false;
/*      */   }
/*      */   
/*      */   protected final boolean isCharNodesValueUsable() {
/*  275 */     return (isExistingCharNodesValueUsable() || (this._charNodesValue = Cur.updateCharNodes(this._locale, this, this._charNodesValue, this._cchValue)) != null);
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
/*      */   protected final boolean isCharNodesAfterUsable() {
/*  289 */     if (this._srcAfter == null) return false; 
/*  290 */     if (this._charNodesAfter != null && this._charNodesAfter._next == null && this._charNodesAfter._cch == this._cchAfter)
/*      */     {
/*  292 */       return true; } 
/*  293 */     return ((this._charNodesAfter = Cur.updateCharNodes(this._locale, this, this._charNodesAfter, this._cchAfter)) != null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Xobj lastAttr() {
/*  301 */     if (this._firstChild == null || !this._firstChild.isAttr()) {
/*  302 */       return null;
/*      */     }
/*  304 */     Xobj xobj = this._firstChild;
/*      */     
/*  306 */     while (xobj._nextSibling != null && xobj._nextSibling.isAttr()) {
/*  307 */       xobj = xobj._nextSibling;
/*      */     }
/*  309 */     return xobj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final int cchLeft(int paramInt) {
/*  318 */     if (isRoot() && paramInt == 0) {
/*  319 */       return 0;
/*      */     }
/*  321 */     Xobj xobj = getDenormal(paramInt);
/*      */     
/*  323 */     paramInt = posTemp();
/*  324 */     int i = xobj.posAfter();
/*      */     
/*  326 */     return paramInt - ((paramInt < i) ? 1 : i);
/*      */   }
/*      */ 
/*      */   
/*      */   final int cchRight(int paramInt) {
/*  331 */     assert paramInt < posMax();
/*      */     
/*  333 */     if (paramInt <= 0) {
/*  334 */       return 0;
/*      */     }
/*  336 */     int i = posAfter();
/*      */     
/*  338 */     return (paramInt < i) ? (i - paramInt - 1) : (posMax() - paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public final Locale locale() {
/*  345 */     return this._locale;
/*  346 */   } public final int nodeType() { return domType(); } public final b getQName() {
/*  347 */     return this._name;
/*      */   } public final Cur tempCur() {
/*  349 */     Cur cur = this._locale.tempCur(); cur.moveTo(this); return cur;
/*      */   }
/*  351 */   public void dump(PrintStream paramPrintStream, Object paramObject) { Cur.dump(paramPrintStream, this, paramObject); }
/*  352 */   public void dump(PrintStream paramPrintStream) { Cur.dump(paramPrintStream, this, this); } public void dump() {
/*  353 */     dump(System.out);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Cur getEmbedded() {
/*  361 */     this._locale.embedCurs();
/*      */     
/*  363 */     return this._embedded;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean inChars(int paramInt1, Xobj paramXobj, int paramInt2, int paramInt3, boolean paramBoolean) {
/*      */     byte b1;
/*  370 */     assert paramInt1 > 0 && paramInt1 < posMax() && paramInt1 != posAfter() - 1 && paramInt3 > 0;
/*  371 */     assert paramXobj.isNormal(paramInt2);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  378 */     if (paramBoolean) {
/*      */ 
/*      */ 
/*      */       
/*  382 */       if (paramXobj.isRoot() && paramInt2 == 0) {
/*  383 */         return false;
/*      */       }
/*  385 */       paramXobj = paramXobj.getDenormal(paramInt2);
/*  386 */       paramInt2 = paramXobj.posTemp();
/*      */       
/*  388 */       b1 = 1;
/*      */     } else {
/*      */       
/*  391 */       b1 = 0;
/*      */     } 
/*  393 */     return (paramXobj == this && paramInt2 >= paramInt1 && paramInt2 < paramInt1 + ((paramInt3 < 0) ? cchRight(paramInt1) : paramInt3) + b1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean isJustAfterEnd(Xobj paramXobj, int paramInt) {
/*  400 */     assert paramXobj.isNormal(paramInt);
/*      */ 
/*      */ 
/*      */     
/*  404 */     if (paramXobj.isRoot() && paramInt == 0) {
/*  405 */       return false;
/*      */     }
/*  407 */     return (paramXobj == this) ? ((paramInt == posAfter())) : ((paramXobj.getDenormal(paramInt) == this && paramXobj.posTemp() == posAfter()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean isInSameTree(Xobj paramXobj) {
/*  415 */     if (this._locale != paramXobj._locale) {
/*  416 */       return false;
/*      */     }
/*  418 */     for (Xobj xobj = this;; xobj = xobj._parent) {
/*      */       
/*  420 */       if (xobj == paramXobj) {
/*  421 */         return true;
/*      */       }
/*  423 */       if (xobj._parent == null) {
/*      */         
/*  425 */         for (;; paramXobj = paramXobj._parent) {
/*      */           
/*  427 */           if (paramXobj == this) {
/*  428 */             return true;
/*      */           }
/*  430 */           if (paramXobj._parent == null)
/*  431 */             return (paramXobj == xobj); 
/*      */         } 
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   final boolean contains(Cur paramCur) {
/*  439 */     assert paramCur.isNormal();
/*      */     
/*  441 */     return contains(paramCur._xobj, paramCur._pos);
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean contains(Xobj paramXobj, int paramInt) {
/*  446 */     assert paramXobj.isNormal(paramInt);
/*      */     
/*  448 */     if (this == paramXobj) {
/*  449 */       return (paramInt == -1 || (paramInt > 0 && paramInt < posAfter()));
/*      */     }
/*  451 */     if (this._firstChild == null) {
/*  452 */       return false;
/*      */     }
/*  454 */     for (; paramXobj != null; paramXobj = paramXobj._parent) {
/*  455 */       if (paramXobj == this)
/*  456 */         return true; 
/*      */     } 
/*  458 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   final Bookmark setBookmark(int paramInt, Object paramObject1, Object paramObject2) {
/*  463 */     assert isNormal(paramInt);
/*      */     Bookmark bookmark;
/*  465 */     for (bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
/*      */       
/*  467 */       if (paramInt == bookmark._pos && paramObject1 == bookmark._key) {
/*      */         
/*  469 */         if (paramObject2 == null) {
/*      */           
/*  471 */           this._bookmarks = bookmark.listRemove(this._bookmarks);
/*  472 */           return null;
/*      */         } 
/*      */         
/*  475 */         bookmark._value = paramObject2;
/*      */         
/*  477 */         return bookmark;
/*      */       } 
/*      */     } 
/*      */     
/*  481 */     if (paramObject2 == null) {
/*  482 */       return null;
/*      */     }
/*  484 */     bookmark = new Bookmark();
/*      */     
/*  486 */     bookmark._xobj = this;
/*  487 */     bookmark._pos = paramInt;
/*  488 */     bookmark._key = paramObject1;
/*  489 */     bookmark._value = paramObject2;
/*      */     
/*  491 */     this._bookmarks = bookmark.listInsert(this._bookmarks);
/*      */     
/*  493 */     return bookmark;
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean hasBookmark(Object paramObject, int paramInt) {
/*  498 */     for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
/*  499 */       if (bookmark._pos == paramInt && paramObject == bookmark._key)
/*      */       {
/*      */         
/*  502 */         return true;
/*      */       }
/*      */     } 
/*  505 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj findXmlnsForPrefix(String paramString) {
/*  510 */     assert isContainer() && paramString != null;
/*      */     
/*  512 */     for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
/*  513 */       for (Xobj xobj1 = xobj.firstAttr(); xobj1 != null; xobj1 = xobj1.nextAttr()) {
/*  514 */         if (xobj1.isXmlns() && xobj1.getXmlnsPrefix().equals(paramString))
/*  515 */           return xobj1; 
/*      */       } 
/*  517 */     }  return null;
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean removeAttr(b paramb) {
/*  522 */     assert isContainer();
/*      */     
/*  524 */     Xobj xobj = getAttr(paramb);
/*      */     
/*  526 */     if (xobj == null) {
/*  527 */       return false;
/*      */     }
/*  529 */     Cur cur = xobj.tempCur();
/*      */ 
/*      */     
/*      */     while (true) {
/*  533 */       cur.moveNode(null);
/*      */       
/*  535 */       xobj = getAttr(paramb);
/*      */       
/*  537 */       if (xobj == null) {
/*      */         break;
/*      */       }
/*  540 */       cur.moveTo(xobj);
/*      */     } 
/*      */     
/*  543 */     cur.release();
/*      */     
/*  545 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj setAttr(b paramb, String paramString) {
/*  550 */     assert isContainer();
/*      */     
/*  552 */     Cur cur = tempCur();
/*      */     
/*  554 */     if (cur.toAttr(paramb)) {
/*  555 */       cur.removeFollowingAttrs();
/*      */     } else {
/*      */       
/*  558 */       cur.next();
/*  559 */       cur.createAttr(paramb);
/*      */     } 
/*      */     
/*  562 */     cur.setValue(paramString);
/*      */     
/*  564 */     Xobj xobj = cur._xobj;
/*      */     
/*  566 */     cur.release();
/*      */     
/*  568 */     return xobj;
/*      */   }
/*      */ 
/*      */   
/*      */   final void setName(b paramb) {
/*  573 */     assert isAttr() || isElem() || isProcinst();
/*  574 */     assert paramb != null;
/*      */     
/*  576 */     if (!this._name.equals(paramb) || !this._name.getPrefix().equals(paramb.getPrefix())) {
/*      */ 
/*      */       
/*  579 */       this._locale.notifyChange();
/*      */       
/*  581 */       b b1 = this._name;
/*      */       
/*  583 */       this._name = paramb;
/*  584 */       if (this instanceof NamedNodeXobj) {
/*      */         
/*  586 */         NamedNodeXobj namedNodeXobj = (NamedNodeXobj)this;
/*  587 */         namedNodeXobj._canHavePrefixUri = true;
/*      */       } 
/*      */       
/*  590 */       if (!isProcinst()) {
/*      */         
/*  592 */         Xobj xobj = this;
/*      */         
/*  594 */         if (isAttr() && this._parent != null) {
/*      */           
/*  596 */           if (b1.equals(Locale._xsiType) || paramb.equals(Locale._xsiType)) {
/*  597 */             xobj = this._parent;
/*      */           }
/*  599 */           if (b1.equals(Locale._xsiNil) || paramb.equals(Locale._xsiNil)) {
/*  600 */             this._parent.invalidateNil();
/*      */           }
/*      */         } 
/*  603 */         xobj.disconnectNonRootUsers();
/*      */       } 
/*      */       
/*  606 */       this._locale._versionAll++;
/*  607 */       this._locale._versionSansText++;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj ensureParent() {
/*  613 */     assert this._parent != null || (!isRoot() && cchAfter() == 0);
/*  614 */     return (this._parent == null) ? (new DocumentFragXobj(this._locale)).appendXobj(this) : this._parent;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj firstAttr() {
/*  619 */     return (this._firstChild == null || !this._firstChild.isAttr()) ? null : this._firstChild;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj nextAttr() {
/*  624 */     if (this._firstChild != null && this._firstChild.isAttr()) {
/*  625 */       return this._firstChild;
/*      */     }
/*  627 */     if (this._nextSibling != null && this._nextSibling.isAttr()) {
/*  628 */       return this._nextSibling;
/*      */     }
/*  630 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean isValid() {
/*  635 */     if (isVacant() && (this._cchValue != 0 || this._user == null)) {
/*  636 */       return false;
/*      */     }
/*  638 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   final int posTemp() {
/*  643 */     return this._locale._posTemp;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj getNormal(int paramInt) {
/*  648 */     assert paramInt == -1 || (paramInt >= 0 && paramInt <= posMax());
/*      */     
/*  650 */     Xobj xobj = this;
/*      */     
/*  652 */     if (paramInt == xobj.posMax()) {
/*      */       
/*  654 */       if (xobj._nextSibling != null)
/*      */       {
/*  656 */         xobj = xobj._nextSibling;
/*  657 */         paramInt = 0;
/*      */       }
/*      */       else
/*      */       {
/*  661 */         xobj = xobj.ensureParent();
/*  662 */         paramInt = -1;
/*      */       }
/*      */     
/*  665 */     } else if (paramInt == xobj.posAfter() - 1) {
/*  666 */       paramInt = -1;
/*      */     } 
/*  668 */     this._locale._posTemp = paramInt;
/*      */     
/*  670 */     return xobj;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final Xobj getDenormal(int paramInt) {
/*  679 */     assert !isRoot() || paramInt == -1 || paramInt > 0;
/*      */     
/*  681 */     Xobj xobj = this;
/*      */     
/*  683 */     if (paramInt == 0) {
/*      */       
/*  685 */       if (xobj._prevSibling == null)
/*      */       {
/*  687 */         xobj = xobj.ensureParent();
/*  688 */         paramInt = xobj.posAfter() - 1;
/*      */       }
/*      */       else
/*      */       {
/*  692 */         xobj = xobj._prevSibling;
/*  693 */         paramInt = xobj.posMax();
/*      */       }
/*      */     
/*  696 */     } else if (paramInt == -1) {
/*      */       
/*  698 */       if (xobj._lastChild == null) {
/*  699 */         paramInt = xobj.posAfter() - 1;
/*      */       } else {
/*      */         
/*  702 */         xobj = xobj._lastChild;
/*  703 */         paramInt = xobj.posMax();
/*      */       } 
/*      */     } 
/*      */     
/*  707 */     this._locale._posTemp = paramInt;
/*      */     
/*  709 */     return xobj;
/*      */   }
/*      */ 
/*      */   
/*      */   final boolean isNormal(int paramInt) {
/*  714 */     if (!isValid()) {
/*  715 */       return false;
/*      */     }
/*  717 */     if (paramInt == -1 || paramInt == 0) {
/*  718 */       return true;
/*      */     }
/*  720 */     if (paramInt < 0 || paramInt >= posMax()) {
/*  721 */       return false;
/*      */     }
/*  723 */     if (paramInt >= posAfter()) {
/*      */       
/*  725 */       if (isRoot()) {
/*  726 */         return false;
/*      */       }
/*  728 */       if (this._nextSibling != null && this._nextSibling.isAttr()) {
/*  729 */         return false;
/*      */       }
/*  731 */       if (this._parent == null || !this._parent.isContainer()) {
/*  732 */         return false;
/*      */       }
/*      */     } 
/*  735 */     if (paramInt == posAfter() - 1) {
/*  736 */       return false;
/*      */     }
/*  738 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj walk(Xobj paramXobj, boolean paramBoolean) {
/*  743 */     if (this._firstChild != null && paramBoolean) {
/*  744 */       return this._firstChild;
/*      */     }
/*  746 */     for (Xobj xobj = this; xobj != paramXobj; xobj = xobj._parent) {
/*  747 */       if (xobj._nextSibling != null)
/*  748 */         return xobj._nextSibling; 
/*      */     } 
/*  750 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj removeXobj() {
/*  755 */     if (this._parent != null) {
/*      */       
/*  757 */       if (this._parent._firstChild == this) {
/*  758 */         this._parent._firstChild = this._nextSibling;
/*      */       }
/*  760 */       if (this._parent._lastChild == this) {
/*  761 */         this._parent._lastChild = this._prevSibling;
/*      */       }
/*  763 */       if (this._prevSibling != null) {
/*  764 */         this._prevSibling._nextSibling = this._nextSibling;
/*      */       }
/*  766 */       if (this._nextSibling != null) {
/*  767 */         this._nextSibling._prevSibling = this._prevSibling;
/*      */       }
/*  769 */       this._parent = null;
/*  770 */       this._prevSibling = null;
/*  771 */       this._nextSibling = null;
/*      */     } 
/*      */     
/*  774 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj insertXobj(Xobj paramXobj) {
/*  779 */     assert this._locale == paramXobj._locale;
/*  780 */     assert !paramXobj.isRoot() && !isRoot();
/*  781 */     assert paramXobj._parent == null;
/*  782 */     assert paramXobj._prevSibling == null;
/*  783 */     assert paramXobj._nextSibling == null;
/*      */     
/*  785 */     ensureParent();
/*      */     
/*  787 */     paramXobj._parent = this._parent;
/*  788 */     paramXobj._prevSibling = this._prevSibling;
/*  789 */     paramXobj._nextSibling = this;
/*      */     
/*  791 */     if (this._prevSibling != null) {
/*  792 */       this._prevSibling._nextSibling = paramXobj;
/*      */     } else {
/*  794 */       this._parent._firstChild = paramXobj;
/*      */     } 
/*  796 */     this._prevSibling = paramXobj;
/*      */     
/*  798 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj appendXobj(Xobj paramXobj) {
/*  803 */     assert this._locale == paramXobj._locale;
/*  804 */     assert !paramXobj.isRoot();
/*  805 */     assert paramXobj._parent == null;
/*  806 */     assert paramXobj._prevSibling == null;
/*  807 */     assert paramXobj._nextSibling == null;
/*  808 */     assert this._lastChild == null || this._firstChild != null;
/*      */     
/*  810 */     paramXobj._parent = this;
/*  811 */     paramXobj._prevSibling = this._lastChild;
/*      */     
/*  813 */     if (this._lastChild == null) {
/*  814 */       this._firstChild = paramXobj;
/*      */     } else {
/*  816 */       this._lastChild._nextSibling = paramXobj;
/*      */     } 
/*  818 */     this._lastChild = paramXobj;
/*      */     
/*  820 */     return this;
/*      */   }
/*      */ 
/*      */   
/*      */   final void removeXobjs(Xobj paramXobj1, Xobj paramXobj2) {
/*  825 */     assert paramXobj2._locale == paramXobj1._locale;
/*  826 */     assert paramXobj1._parent == this;
/*  827 */     assert paramXobj2._parent == this;
/*      */     
/*  829 */     if (this._firstChild == paramXobj1) {
/*  830 */       this._firstChild = paramXobj2._nextSibling;
/*      */     }
/*  832 */     if (this._lastChild == paramXobj2) {
/*  833 */       this._lastChild = paramXobj1._prevSibling;
/*      */     }
/*  835 */     if (paramXobj1._prevSibling != null) {
/*  836 */       paramXobj1._prevSibling._nextSibling = paramXobj2._nextSibling;
/*      */     }
/*  838 */     if (paramXobj2._nextSibling != null) {
/*  839 */       paramXobj2._nextSibling._prevSibling = paramXobj1._prevSibling;
/*      */     }
/*      */ 
/*      */     
/*  843 */     paramXobj1._prevSibling = null;
/*  844 */     paramXobj2._nextSibling = null;
/*      */     
/*  846 */     for (; paramXobj1 != null; paramXobj1 = paramXobj1._nextSibling) {
/*  847 */       paramXobj1._parent = null;
/*      */     }
/*      */   }
/*      */   
/*      */   final void insertXobjs(Xobj paramXobj1, Xobj paramXobj2) {
/*  852 */     assert this._locale == paramXobj1._locale;
/*  853 */     assert paramXobj2._locale == paramXobj1._locale;
/*  854 */     assert paramXobj1._parent == null && paramXobj2._parent == null;
/*  855 */     assert paramXobj1._prevSibling == null;
/*  856 */     assert paramXobj2._nextSibling == null;
/*      */     
/*  858 */     paramXobj1._prevSibling = this._prevSibling;
/*  859 */     paramXobj2._nextSibling = this;
/*      */     
/*  861 */     if (this._prevSibling != null) {
/*  862 */       this._prevSibling._nextSibling = paramXobj1;
/*      */     } else {
/*  864 */       this._parent._firstChild = paramXobj1;
/*      */     } 
/*  866 */     this._prevSibling = paramXobj2;
/*      */     
/*  868 */     for (; paramXobj1 != this; paramXobj1 = paramXobj1._nextSibling) {
/*  869 */       paramXobj1._parent = this._parent;
/*      */     }
/*      */   }
/*      */   
/*      */   final void appendXobjs(Xobj paramXobj1, Xobj paramXobj2) {
/*  874 */     assert this._locale == paramXobj1._locale;
/*  875 */     assert paramXobj2._locale == paramXobj1._locale;
/*  876 */     assert paramXobj1._parent == null && paramXobj2._parent == null;
/*  877 */     assert paramXobj1._prevSibling == null;
/*  878 */     assert paramXobj2._nextSibling == null;
/*  879 */     assert !paramXobj1.isRoot();
/*      */     
/*  881 */     paramXobj1._prevSibling = this._lastChild;
/*      */     
/*  883 */     if (this._lastChild == null) {
/*  884 */       this._firstChild = paramXobj1;
/*      */     } else {
/*  886 */       this._lastChild._nextSibling = paramXobj1;
/*      */     } 
/*  888 */     this._lastChild = paramXobj2;
/*      */     
/*  890 */     for (; paramXobj1 != null; paramXobj1 = paramXobj1._nextSibling) {
/*  891 */       paramXobj1._parent = this;
/*      */     }
/*      */   }
/*      */   
/*      */   static final void disbandXobjs(Xobj paramXobj1, Xobj paramXobj2) {
/*  896 */     assert paramXobj2._locale == paramXobj1._locale;
/*  897 */     assert paramXobj1._parent == null && paramXobj2._parent == null;
/*  898 */     assert paramXobj1._prevSibling == null;
/*  899 */     assert paramXobj2._nextSibling == null;
/*  900 */     assert !paramXobj1.isRoot();
/*      */     
/*  902 */     while (paramXobj1 != null) {
/*      */       
/*  904 */       Xobj xobj = paramXobj1._nextSibling;
/*  905 */       paramXobj1._nextSibling = paramXobj1._prevSibling = null;
/*  906 */       paramXobj1 = xobj;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void invalidateSpecialAttr(Xobj paramXobj) {
/*  914 */     if (isAttr()) {
/*      */       
/*  916 */       if (this._name.equals(Locale._xsiType)) {
/*      */         
/*  918 */         if (this._parent != null) {
/*  919 */           this._parent.disconnectNonRootUsers();
/*      */         }
/*  921 */         if (paramXobj != null) {
/*  922 */           paramXobj.disconnectNonRootUsers();
/*      */         }
/*      */       } 
/*  925 */       if (this._name.equals(Locale._xsiNil)) {
/*      */         
/*  927 */         if (this._parent != null) {
/*  928 */           this._parent.invalidateNil();
/*      */         }
/*  930 */         if (paramXobj != null) {
/*  931 */           paramXobj.invalidateNil();
/*      */         }
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void removeCharsHelper(int paramInt1, int paramInt2, Xobj paramXobj, int paramInt3, boolean paramBoolean1, boolean paramBoolean2) {
/*  948 */     assert paramInt1 > 0 && paramInt1 < posMax() && paramInt1 != posAfter() - 1;
/*  949 */     assert paramInt2 > 0;
/*  950 */     assert cchRight(paramInt1) >= paramInt2;
/*  951 */     assert !paramBoolean1 || paramXobj != null;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  962 */     for (Cur cur = getEmbedded(); cur != null; ) {
/*      */       
/*  964 */       Cur cur1 = cur._next;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  973 */       assert cur._xobj == this;
/*      */       
/*  975 */       if (cur._pos >= paramInt1 && cur._pos < paramInt1 + paramInt2)
/*      */       {
/*  977 */         if (paramBoolean1) {
/*  978 */           cur.moveToNoCheck(paramXobj, paramInt3 + cur._pos - paramInt1);
/*      */         } else {
/*  980 */           cur.nextChars(paramInt2 - cur._pos + paramInt1);
/*      */         } 
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  987 */       if (cur._xobj == this && cur._pos >= paramInt1 + paramInt2) {
/*  988 */         cur._pos -= paramInt2;
/*      */       }
/*  990 */       cur = cur1;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  998 */     for (Bookmark bookmark = this._bookmarks; bookmark != null; ) {
/*      */       
/* 1000 */       Bookmark bookmark1 = bookmark._next;
/*      */ 
/*      */ 
/*      */       
/* 1004 */       assert bookmark._xobj == this;
/*      */       
/* 1006 */       if (bookmark._pos >= paramInt1 && bookmark._pos < paramInt1 + paramInt2) {
/*      */         
/* 1008 */         assert paramXobj != null;
/* 1009 */         bookmark.moveTo(paramXobj, paramInt3 + bookmark._pos - paramInt1);
/*      */       } 
/*      */       
/* 1012 */       if (bookmark._xobj == this && bookmark._pos >= paramInt1 + paramInt2) {
/* 1013 */         bookmark._pos -= paramInt2;
/*      */       }
/* 1015 */       bookmark = bookmark._next;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1020 */     int i = posAfter();
/* 1021 */     CharUtil charUtil = this._locale.getCharUtil();
/*      */     
/* 1023 */     if (paramInt1 < i) {
/*      */       
/* 1025 */       this._srcValue = charUtil.removeChars(paramInt1 - 1, paramInt2, this._srcValue, this._offValue, this._cchValue);
/* 1026 */       this._offValue = charUtil._offSrc;
/* 1027 */       this._cchValue = charUtil._cchSrc;
/*      */       
/* 1029 */       if (paramBoolean2)
/*      */       {
/* 1031 */         invalidateUser();
/* 1032 */         invalidateSpecialAttr(null);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1037 */       this._srcAfter = charUtil.removeChars(paramInt1 - i, paramInt2, this._srcAfter, this._offAfter, this._cchAfter);
/* 1038 */       this._offAfter = charUtil._offSrc;
/* 1039 */       this._cchAfter = charUtil._cchSrc;
/*      */       
/* 1041 */       if (paramBoolean2 && this._parent != null) {
/* 1042 */         this._parent.invalidateUser();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void insertCharsHelper(int paramInt1, Object paramObject, int paramInt2, int paramInt3, boolean paramBoolean) {
/* 1052 */     assert paramInt1 > 0;
/* 1053 */     assert paramInt1 >= posAfter() || isOccupied();
/*      */     
/* 1055 */     int i = posAfter();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1062 */     if (paramInt1 - ((paramInt1 < i) ? 1 : 2) < this._cchValue + this._cchAfter) {
/*      */       
/* 1064 */       for (Cur cur = getEmbedded(); cur != null; cur = cur._next) {
/* 1065 */         if (cur._pos >= paramInt1)
/* 1066 */           cur._pos += paramInt3; 
/*      */       } 
/* 1068 */       for (Bookmark bookmark = this._bookmarks; bookmark != null; bookmark = bookmark._next) {
/* 1069 */         if (bookmark._pos >= paramInt1) {
/* 1070 */           bookmark._pos += paramInt3;
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1078 */     CharUtil charUtil = this._locale.getCharUtil();
/*      */     
/* 1080 */     if (paramInt1 < i) {
/*      */       
/* 1082 */       this._srcValue = charUtil.insertChars(paramInt1 - 1, this._srcValue, this._offValue, this._cchValue, paramObject, paramInt2, paramInt3);
/* 1083 */       this._offValue = charUtil._offSrc;
/* 1084 */       this._cchValue = charUtil._cchSrc;
/*      */       
/* 1086 */       if (paramBoolean)
/*      */       {
/* 1088 */         invalidateUser();
/* 1089 */         invalidateSpecialAttr(null);
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1094 */       this._srcAfter = charUtil.insertChars(paramInt1 - i, this._srcAfter, this._offAfter, this._cchAfter, paramObject, paramInt2, paramInt3);
/* 1095 */       this._offAfter = charUtil._offSrc;
/* 1096 */       this._cchAfter = charUtil._cchSrc;
/*      */       
/* 1098 */       if (paramBoolean && this._parent != null) {
/* 1099 */         this._parent.invalidateUser();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   Xobj copyNode(Locale paramLocale) {
/* 1105 */     Xobj xobj1 = null;
/* 1106 */     Xobj xobj2 = null;
/*      */     
/* 1108 */     Xobj xobj3 = this;
/*      */     while (true) {
/* 1110 */       xobj3.ensureOccupancy();
/*      */       
/* 1112 */       Xobj xobj4 = xobj3.newNode(paramLocale);
/*      */       
/* 1114 */       xobj4._srcValue = xobj3._srcValue;
/* 1115 */       xobj4._offValue = xobj3._offValue;
/* 1116 */       xobj4._cchValue = xobj3._cchValue;
/*      */       
/* 1118 */       xobj4._srcAfter = xobj3._srcAfter;
/* 1119 */       xobj4._offAfter = xobj3._offAfter;
/* 1120 */       xobj4._cchAfter = xobj3._cchAfter;
/*      */       
/* 1122 */       for (Bookmark bookmark = xobj3._bookmarks; bookmark != null; bookmark = bookmark._next) {
/*      */         
/* 1124 */         if (xobj3.hasBookmark(CDataBookmark.CDATA_BOOKMARK.getKey(), bookmark._pos)) {
/* 1125 */           xobj4.setBookmark(bookmark._pos, CDataBookmark.CDATA_BOOKMARK.getKey(), CDataBookmark.CDATA_BOOKMARK);
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1131 */       if (xobj1 == null) {
/* 1132 */         xobj2 = xobj4;
/*      */       } else {
/* 1134 */         xobj1.appendXobj(xobj4);
/*      */       } 
/*      */ 
/*      */       
/* 1138 */       Xobj xobj5 = xobj3;
/*      */       
/* 1140 */       if ((xobj3 = xobj3.walk(this, true)) == null) {
/*      */         break;
/*      */       }
/* 1143 */       if (xobj5 == xobj3._parent) {
/* 1144 */         xobj1 = xobj4; continue;
/*      */       } 
/* 1146 */       for (; xobj5._parent != xobj3._parent; xobj5 = xobj5._parent) {
/* 1147 */         xobj1 = xobj1._parent;
/*      */       }
/*      */     } 
/* 1150 */     xobj2._srcAfter = null;
/* 1151 */     xobj2._offAfter = 0;
/* 1152 */     xobj2._cchAfter = 0;
/*      */     
/* 1154 */     return xobj2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   String getCharsAsString(int paramInt1, int paramInt2, int paramInt3) {
/* 1161 */     if (cchRight(paramInt1) == 0) {
/* 1162 */       return "";
/*      */     }
/* 1164 */     Object object = getChars(paramInt1, paramInt2);
/*      */     
/* 1166 */     if (paramInt3 == 1) {
/* 1167 */       return CharUtil.getString(object, this._locale._offSrc, this._locale._cchSrc);
/*      */     }
/* 1169 */     Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(paramInt3);
/*      */     
/* 1171 */     scrubBuffer.scrub(object, this._locale._offSrc, this._locale._cchSrc);
/*      */     
/* 1173 */     return scrubBuffer.getResultAsString();
/*      */   }
/*      */   
/*      */   String getCharsAfterAsString(int paramInt1, int paramInt2) {
/* 1177 */     int i = paramInt1 + this._cchValue + 2;
/* 1178 */     if (i == posMax())
/* 1179 */       i = -1; 
/* 1180 */     return getCharsAsString(i, paramInt2, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   String getCharsValueAsString(int paramInt1, int paramInt2) {
/* 1185 */     return getCharsAsString(paramInt1 + 1, paramInt2, 1);
/*      */   }
/*      */ 
/*      */   
/*      */   String getValueAsString(int paramInt) {
/* 1190 */     if (!hasChildren()) {
/*      */       
/* 1192 */       Object object = getFirstChars();
/*      */       
/* 1194 */       if (paramInt == 1) {
/*      */         
/* 1196 */         String str1 = CharUtil.getString(object, this._locale._offSrc, this._locale._cchSrc);
/*      */ 
/*      */ 
/*      */         
/* 1200 */         int i = str1.length();
/*      */         
/* 1202 */         if (i > 0) {
/*      */           
/* 1204 */           Xobj xobj = lastAttr();
/*      */           
/* 1206 */           assert ((xobj == null) ? this._cchValue : xobj._cchAfter) == i;
/*      */           
/* 1208 */           if (xobj != null) {
/*      */             
/* 1210 */             xobj._srcAfter = str1;
/* 1211 */             xobj._offAfter = 0;
/*      */           }
/*      */           else {
/*      */             
/* 1215 */             this._srcValue = str1;
/* 1216 */             this._offValue = 0;
/*      */           } 
/*      */         } 
/*      */         
/* 1220 */         return str1;
/*      */       } 
/*      */       
/* 1223 */       Locale.ScrubBuffer scrubBuffer1 = Locale.getScrubBuffer(paramInt);
/*      */       
/* 1225 */       scrubBuffer1.scrub(object, this._locale._offSrc, this._locale._cchSrc);
/*      */       
/* 1227 */       return scrubBuffer1.getResultAsString();
/*      */     } 
/*      */     
/* 1230 */     Locale.ScrubBuffer scrubBuffer = Locale.getScrubBuffer(paramInt);
/*      */     
/* 1232 */     Cur cur = tempCur();
/*      */     
/* 1234 */     cur.push();
/*      */     
/* 1236 */     cur.next(); while (!cur.isAtEndOfLastPush()) {
/*      */       
/* 1238 */       if (cur.isText()) {
/* 1239 */         scrubBuffer.scrub(cur.getChars(-1), cur._offSrc, cur._cchSrc);
/*      */       }
/* 1241 */       if (cur.isComment() || cur.isProcinst()) {
/* 1242 */         cur.skip(); continue;
/*      */       } 
/* 1244 */       cur.next();
/*      */     } 
/*      */     
/* 1247 */     String str = scrubBuffer.getResultAsString();
/*      */     
/* 1249 */     cur.release();
/*      */     
/* 1251 */     return str;
/*      */   }
/*      */ 
/*      */   
/*      */   String getValueAsString() {
/* 1256 */     return getValueAsString(1);
/*      */   }
/*      */   
/*      */   String getString(int paramInt1, int paramInt2) {
/*      */     String str;
/* 1261 */     int i = cchRight(paramInt1);
/*      */     
/* 1263 */     if (i == 0) {
/* 1264 */       return "";
/*      */     }
/* 1266 */     if (paramInt2 < 0 || paramInt2 > i) {
/* 1267 */       paramInt2 = i;
/*      */     }
/* 1269 */     int j = posAfter();
/*      */     
/* 1271 */     assert paramInt1 > 0;
/*      */ 
/*      */ 
/*      */     
/* 1275 */     if (paramInt1 >= j) {
/*      */       
/* 1277 */       str = CharUtil.getString(this._srcAfter, this._offAfter + paramInt1 - j, paramInt2);
/*      */       
/* 1279 */       if (paramInt1 == j && paramInt2 == this._cchAfter)
/*      */       {
/* 1281 */         this._srcAfter = str;
/* 1282 */         this._offAfter = 0;
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1287 */       str = CharUtil.getString(this._srcValue, this._offValue + paramInt1 - 1, paramInt2);
/*      */       
/* 1289 */       if (paramInt1 == 1 && paramInt2 == this._cchValue) {
/*      */         
/* 1291 */         this._srcValue = str;
/* 1292 */         this._offValue = 0;
/*      */       } 
/*      */     } 
/*      */     
/* 1296 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object getFirstChars() {
/* 1304 */     ensureOccupancy();
/*      */     
/* 1306 */     if (this._cchValue > 0) {
/* 1307 */       return getChars(1, -1);
/*      */     }
/* 1309 */     Xobj xobj = lastAttr();
/*      */     
/* 1311 */     if (xobj == null || xobj._cchAfter <= 0) {
/*      */       
/* 1313 */       this._locale._offSrc = 0;
/* 1314 */       this._locale._cchSrc = 0;
/*      */       
/* 1316 */       return null;
/*      */     } 
/*      */     
/* 1319 */     return xobj.getChars(xobj.posAfter(), -1);
/*      */   }
/*      */ 
/*      */   
/*      */   Object getChars(int paramInt1, int paramInt2, Cur paramCur) {
/* 1324 */     Object object = getChars(paramInt1, paramInt2);
/*      */     
/* 1326 */     paramCur._offSrc = this._locale._offSrc;
/* 1327 */     paramCur._cchSrc = this._locale._cchSrc;
/*      */     
/* 1329 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Object getChars(int paramInt1, int paramInt2) {
/* 1336 */     assert isNormal(paramInt1);
/*      */     
/* 1338 */     int i = cchRight(paramInt1);
/*      */     
/* 1340 */     if (paramInt2 < 0 || paramInt2 > i) {
/* 1341 */       paramInt2 = i;
/*      */     }
/* 1343 */     if (paramInt2 == 0) {
/*      */       
/* 1345 */       this._locale._offSrc = 0;
/* 1346 */       this._locale._cchSrc = 0;
/*      */       
/* 1348 */       return null;
/*      */     } 
/*      */     
/* 1351 */     return getCharsHelper(paramInt1, paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Object getCharsHelper(int paramInt1, int paramInt2) {
/*      */     Object object;
/* 1358 */     assert paramInt2 > 0 && cchRight(paramInt1) >= paramInt2;
/*      */     
/* 1360 */     int i = posAfter();
/*      */ 
/*      */ 
/*      */     
/* 1364 */     if (paramInt1 >= i) {
/*      */       
/* 1366 */       object = this._srcAfter;
/* 1367 */       this._locale._offSrc = this._offAfter + paramInt1 - i;
/*      */     }
/*      */     else {
/*      */       
/* 1371 */       object = this._srcValue;
/* 1372 */       this._locale._offSrc = this._offValue + paramInt1 - 1;
/*      */     } 
/*      */     
/* 1375 */     this._locale._cchSrc = paramInt2;
/*      */     
/* 1377 */     return object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   final void setBit(int paramInt) {
/* 1384 */     this._bits |= paramInt; } final void clearBit(int paramInt) {
/* 1385 */     this._bits &= paramInt ^ 0xFFFFFFFF;
/*      */   }
/* 1387 */   final boolean bitIsSet(int paramInt) { return ((this._bits & paramInt) != 0); } final boolean bitIsClear(int paramInt) {
/* 1388 */     return ((this._bits & paramInt) == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   final boolean isVacant() {
/* 1394 */     return bitIsSet(256);
/* 1395 */   } final boolean isOccupied() { return bitIsClear(256); } final boolean inhibitDisconnect() {
/* 1396 */     return bitIsSet(1024);
/*      */   } final boolean isStableUser() {
/* 1398 */     return bitIsSet(512);
/*      */   }
/*      */   
/*      */   void invalidateNil() {
/* 1402 */     if (this._user != null) {
/* 1403 */       this._user.invalidate_nilvalue();
/*      */     }
/*      */   }
/*      */   
/*      */   void setStableType(SchemaType paramSchemaType) {
/* 1408 */     setStableUser(((TypeStoreUserFactory)paramSchemaType).createTypeStoreUser());
/*      */   }
/*      */ 
/*      */   
/*      */   void setStableUser(TypeStoreUser paramTypeStoreUser) {
/* 1413 */     disconnectNonRootUsers();
/* 1414 */     disconnectUser();
/*      */     
/* 1416 */     assert this._user == null;
/*      */     
/* 1418 */     this._user = paramTypeStoreUser;
/*      */     
/* 1420 */     this._user.attach_store(this);
/*      */     
/* 1422 */     setBit(512);
/*      */   }
/*      */ 
/*      */   
/*      */   void disconnectUser() {
/* 1427 */     if (this._user != null && !inhibitDisconnect()) {
/*      */       
/* 1429 */       ensureOccupancy();
/* 1430 */       this._user.disconnect_store();
/* 1431 */       this._user = null;
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
/*      */   void disconnectNonRootUsers() {
/* 1443 */     for (Xobj xobj = this; xobj != null; xobj = xobj1) {
/*      */       
/* 1445 */       Xobj xobj1 = xobj.walk(this, (xobj._user != null));
/*      */       
/* 1447 */       if (!xobj.isRoot()) {
/* 1448 */         xobj.disconnectUser();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void disconnectChildrenUsers() {
/* 1456 */     for (Xobj xobj = walk(this, (this._user == null)); xobj != null; xobj = xobj1) {
/*      */       
/* 1458 */       Xobj xobj1 = xobj.walk(this, (xobj._user != null));
/*      */       
/* 1460 */       xobj.disconnectUser();
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
/*      */   final String namespaceForPrefix(String paramString, boolean paramBoolean) {
/* 1490 */     if (paramString == null) {
/* 1491 */       paramString = "";
/*      */     }
/*      */ 
/*      */     
/* 1495 */     if (paramString.equals("xml")) {
/* 1496 */       return "http://www.w3.org/XML/1998/namespace";
/*      */     }
/* 1498 */     if (paramString.equals("xmlns")) {
/* 1499 */       return "http://www.w3.org/2000/xmlns/";
/*      */     }
/* 1501 */     for (Xobj xobj = this; xobj != null; xobj = xobj._parent) {
/* 1502 */       for (Xobj xobj1 = xobj._firstChild; xobj1 != null && xobj1.isAttr(); xobj1 = xobj1._nextSibling) {
/* 1503 */         if (xobj1.isXmlns() && xobj1.getXmlnsPrefix().equals(paramString))
/* 1504 */           return xobj1.getXmlnsUri(); 
/*      */       } 
/* 1506 */     }  return (paramBoolean && paramString.length() == 0) ? "" : null;
/*      */   }
/*      */ 
/*      */   
/*      */   final String prefixForNamespace(String paramString1, String paramString2, boolean paramBoolean) {
/* 1511 */     if (paramString1 == null) {
/* 1512 */       paramString1 = "";
/*      */     }
/*      */ 
/*      */     
/* 1516 */     if (paramString1.equals("http://www.w3.org/XML/1998/namespace")) {
/* 1517 */       return "xml";
/*      */     }
/* 1519 */     if (paramString1.equals("http://www.w3.org/2000/xmlns/")) {
/* 1520 */       return "xmlns";
/*      */     }
/*      */ 
/*      */     
/* 1524 */     Xobj xobj1 = this;
/*      */     
/* 1526 */     while (!xobj1.isContainer()) {
/* 1527 */       xobj1 = xobj1.ensureParent();
/*      */     }
/*      */ 
/*      */     
/* 1531 */     if (paramString1.length() == 0) {
/*      */ 
/*      */ 
/*      */       
/* 1535 */       Xobj xobj = xobj1.findXmlnsForPrefix("");
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1540 */       if (xobj == null || xobj.getXmlnsUri().length() == 0) {
/* 1541 */         return "";
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 1546 */       if (!paramBoolean) {
/* 1547 */         return null;
/*      */       }
/*      */ 
/*      */       
/* 1551 */       xobj1.setAttr(this._locale.createXmlns(null), "");
/*      */       
/* 1553 */       return "";
/*      */     } 
/*      */     
/*      */     Xobj xobj2;
/*      */     
/* 1558 */     for (xobj2 = xobj1; xobj2 != null; xobj2 = xobj2._parent) {
/* 1559 */       for (Xobj xobj = xobj2.firstAttr(); xobj != null; xobj = xobj.nextAttr()) {
/* 1560 */         if (xobj.isXmlns() && xobj.getXmlnsUri().equals(paramString1) && 
/* 1561 */           xobj1.findXmlnsForPrefix(xobj.getXmlnsPrefix()) == xobj) {
/* 1562 */           return xobj.getXmlnsPrefix();
/*      */         }
/*      */       } 
/*      */     } 
/* 1566 */     if (!paramBoolean) {
/* 1567 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1571 */     if (paramString2 != null && (paramString2.length() == 0 || paramString2.toLowerCase().startsWith("xml") || xobj1.findXmlnsForPrefix(paramString2) != null))
/*      */     {
/*      */ 
/*      */       
/* 1575 */       paramString2 = null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1580 */     if (paramString2 == null) {
/*      */       
/* 1582 */       String str = QNameHelper.suggestPrefix(paramString1);
/*      */       
/* 1584 */       paramString2 = str;
/*      */       
/* 1586 */       byte b1 = 1;
/* 1587 */       while (xobj1.findXmlnsForPrefix(paramString2) != null) {
/*      */         paramString2 = str + b1++;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1593 */     xobj2 = xobj1;
/*      */     
/* 1595 */     while (!xobj2.isRoot() && !xobj2.ensureParent().isRoot()) {
/* 1596 */       xobj2 = xobj2._parent;
/*      */     }
/* 1598 */     xobj1.setAttr(this._locale.createXmlns(paramString2), paramString1);
/*      */     
/* 1600 */     return paramString2;
/*      */   }
/*      */   
/*      */   final b getValueAsQName() {
/*      */     String str2, str3;
/* 1605 */     assert !hasChildren();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1613 */     String str1 = getValueAsString(3);
/*      */ 
/*      */ 
/*      */     
/* 1617 */     int i = str1.indexOf(':');
/*      */     
/* 1619 */     if (i >= 0) {
/*      */       
/* 1621 */       str2 = str1.substring(0, i);
/* 1622 */       str3 = str1.substring(i + 1);
/*      */     }
/*      */     else {
/*      */       
/* 1626 */       str2 = "";
/* 1627 */       str3 = str1;
/*      */     } 
/*      */     
/* 1630 */     String str4 = namespaceForPrefix(str2, true);
/*      */     
/* 1632 */     if (str4 == null) {
/* 1633 */       return null;
/*      */     }
/* 1635 */     return new b(str4, str3);
/*      */   }
/*      */ 
/*      */   
/*      */   final Xobj getAttr(b paramb) {
/* 1640 */     for (Xobj xobj = this._firstChild; xobj != null && xobj.isAttr(); xobj = xobj._nextSibling) {
/* 1641 */       if (xobj._name.equals(paramb))
/* 1642 */         return xobj; 
/*      */     } 
/* 1644 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   final b getXsiTypeName() {
/* 1649 */     assert isContainer();
/*      */     
/* 1651 */     Xobj xobj = getAttr(Locale._xsiType);
/*      */     
/* 1653 */     return (xobj == null) ? null : xobj.getValueAsQName();
/*      */   }
/*      */ 
/*      */   
/*      */   final XmlObject getObject() {
/* 1658 */     return isUserNode() ? (XmlObject)getUser() : null;
/*      */   }
/*      */ 
/*      */   
/*      */   final TypeStoreUser getUser() {
/* 1663 */     assert isUserNode();
/* 1664 */     assert this._user != null || (!isRoot() && !isStableUser());
/*      */     
/* 1666 */     if (this._user == null) {
/*      */ 
/*      */ 
/*      */       
/* 1670 */       TypeStoreUser typeStoreUser = (this._parent == null) ? ((TypeStoreUserFactory)XmlBeans.NO_TYPE).createTypeStoreUser() : this._parent.getUser();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1675 */       this._user = isElem() ? typeStoreUser.create_element_user(this._name, getXsiTypeName()) : typeStoreUser.create_attribute_user(this._name);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1680 */       this._user.attach_store(this);
/*      */     } 
/*      */     
/* 1683 */     return this._user;
/*      */   }
/*      */ 
/*      */   
/*      */   final void invalidateUser() {
/* 1688 */     assert isValid();
/* 1689 */     assert this._user == null || isUserNode();
/*      */     
/* 1691 */     if (this._user != null) {
/* 1692 */       this._user.invalidate_value();
/*      */     }
/*      */   }
/*      */   
/*      */   final void ensureOccupancy() {
/* 1697 */     assert isValid();
/*      */     
/* 1699 */     if (isVacant()) {
/*      */       
/* 1701 */       assert isUserNode();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1707 */       clearBit(256);
/*      */       
/* 1709 */       TypeStoreUser typeStoreUser = this._user;
/* 1710 */       this._user = null;
/*      */       
/* 1712 */       String str = typeStoreUser.build_text((NamespaceManager)this);
/*      */ 
/*      */       
/* 1715 */       long l1 = this._locale._versionAll;
/* 1716 */       long l2 = this._locale._versionSansText;
/*      */ 
/*      */       
/* 1719 */       setValue(str);
/* 1720 */       assert l2 == this._locale._versionSansText;
/*      */       
/* 1722 */       this._locale._versionAll = l1;
/*      */ 
/*      */       
/* 1725 */       assert this._user == null;
/* 1726 */       this._user = typeStoreUser;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void setValue(String paramString) {
/* 1731 */     assert CharUtil.isValid(paramString, 0, paramString.length());
/*      */ 
/*      */ 
/*      */     
/* 1735 */     if (paramString.length() <= 0) {
/*      */       return;
/*      */     }
/* 1738 */     this._locale.notifyChange();
/* 1739 */     Xobj xobj1 = lastAttr();
/* 1740 */     int i = 1;
/* 1741 */     Xobj xobj2 = this;
/* 1742 */     if (xobj1 != null) {
/*      */       
/* 1744 */       xobj2 = xobj1;
/* 1745 */       i = xobj2.posAfter();
/*      */     } 
/* 1747 */     xobj2.insertCharsHelper(i, paramString, 0, paramString.length(), true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaTypeLoader get_schematypeloader() {
/* 1755 */     return this._locale._schemaTypeLoader;
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlLocale get_locale() {
/* 1760 */     return this._locale;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public Object get_root_object() {
/* 1766 */     return this._locale;
/*      */   }
/*      */   
/* 1769 */   public boolean is_attribute() { assert isValid(); return isAttr(); } public boolean validate_on_set() {
/* 1770 */     assert isValid(); return this._locale._validateOnSet;
/*      */   }
/*      */   
/*      */   public void invalidate_text() {
/* 1774 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1778 */       assert isValid();
/*      */       
/* 1780 */       if (isOccupied()) {
/*      */         
/* 1782 */         if (hasTextNoEnsureOccupancy() || hasChildren()) {
/*      */           
/* 1784 */           TypeStoreUser typeStoreUser = this._user;
/* 1785 */           this._user = null;
/*      */           
/* 1787 */           Cur cur = tempCur();
/* 1788 */           cur.moveNodeContents(null, false);
/* 1789 */           cur.release();
/*      */           
/* 1791 */           assert this._user == null;
/* 1792 */           this._user = typeStoreUser;
/*      */         } 
/*      */         
/* 1795 */         setBit(256);
/*      */       } 
/*      */       
/* 1798 */       assert isValid();
/*      */     }
/*      */     finally {
/*      */       
/* 1802 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String fetch_text(int paramInt) {
/* 1808 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1812 */       assert isValid() && isOccupied();
/*      */       
/* 1814 */       return getValueAsString(paramInt);
/*      */     }
/*      */     finally {
/*      */       
/* 1818 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlCursor new_cursor() {
/* 1824 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1828 */       Cur cur = tempCur();
/* 1829 */       Cursor cursor = new Cursor(cur);
/* 1830 */       cur.release();
/* 1831 */       return cursor;
/*      */     
/*      */     }
/*      */     finally {
/*      */       
/* 1836 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public SchemaField get_schema_field() {
/* 1842 */     assert isValid();
/*      */     
/* 1844 */     if (isRoot()) {
/* 1845 */       return null;
/*      */     }
/* 1847 */     TypeStoreUser typeStoreUser = ensureParent().getUser();
/*      */     
/* 1849 */     if (isAttr()) {
/* 1850 */       return typeStoreUser.get_attribute_field(this._name);
/*      */     }
/* 1852 */     assert isElem();
/*      */     
/* 1854 */     TypeStoreVisitor typeStoreVisitor = typeStoreUser.new_visitor();
/*      */     
/* 1856 */     if (typeStoreVisitor == null) {
/* 1857 */       return null;
/*      */     }
/* 1859 */     for (Xobj xobj = this._parent._firstChild;; xobj = xobj._nextSibling) {
/*      */       
/* 1861 */       if (xobj.isElem()) {
/*      */         
/* 1863 */         typeStoreVisitor.visit(xobj._name);
/*      */         
/* 1865 */         if (xobj == this) {
/* 1866 */           return typeStoreVisitor.get_schema_field();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void validate(ValidatorListener paramValidatorListener) {
/* 1873 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1877 */       Cur cur = tempCur();
/* 1878 */       Validate validate = new Validate(cur, paramValidatorListener);
/* 1879 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 1883 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser change_type(SchemaType paramSchemaType) {
/* 1889 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1893 */       Cur cur = tempCur();
/* 1894 */       cur.setType(paramSchemaType, false);
/* 1895 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 1899 */       this._locale.exit();
/*      */     } 
/*      */     
/* 1902 */     return getUser();
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser substitute(b paramb, SchemaType paramSchemaType) {
/* 1907 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 1911 */       Cur cur = tempCur();
/* 1912 */       cur.setSubstitution(paramb, paramSchemaType, false);
/* 1913 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 1917 */       this._locale.exit();
/*      */     } 
/*      */     
/* 1920 */     return getUser();
/*      */   }
/*      */ 
/*      */   
/*      */   public b get_xsi_type() {
/* 1925 */     return getXsiTypeName();
/*      */   }
/*      */ 
/*      */   
/*      */   public void store_text(String paramString) {
/* 1930 */     this._locale.enter();
/*      */     
/* 1932 */     TypeStoreUser typeStoreUser = this._user;
/* 1933 */     this._user = null;
/*      */ 
/*      */     
/*      */     try {
/* 1937 */       Cur cur = tempCur();
/*      */       
/* 1939 */       cur.moveNodeContents(null, false);
/*      */       
/* 1941 */       if (paramString != null && paramString.length() > 0) {
/*      */         
/* 1943 */         cur.next();
/* 1944 */         cur.insertString(paramString);
/*      */       } 
/*      */       
/* 1947 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 1951 */       assert this._user == null;
/* 1952 */       this._user = typeStoreUser;
/*      */       
/* 1954 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int compute_flags() {
/* 1960 */     if (isRoot()) {
/* 1961 */       return 0;
/*      */     }
/* 1963 */     TypeStoreUser typeStoreUser = ensureParent().getUser();
/*      */     
/* 1965 */     if (isAttr()) {
/* 1966 */       return typeStoreUser.get_attributeflags(this._name);
/*      */     }
/* 1968 */     int i = typeStoreUser.get_elementflags(this._name);
/*      */     
/* 1970 */     if (i != -1) {
/* 1971 */       return i;
/*      */     }
/* 1973 */     TypeStoreVisitor typeStoreVisitor = typeStoreUser.new_visitor();
/*      */     
/* 1975 */     if (typeStoreVisitor == null) {
/* 1976 */       return 0;
/*      */     }
/* 1978 */     for (Xobj xobj = this._parent._firstChild;; xobj = xobj._nextSibling) {
/*      */       
/* 1980 */       if (xobj.isElem()) {
/*      */         
/* 1982 */         typeStoreVisitor.visit(xobj._name);
/*      */         
/* 1984 */         if (xobj == this) {
/* 1985 */           return typeStoreVisitor.get_elementflags();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public String compute_default_text() {
/* 1992 */     if (isRoot()) {
/* 1993 */       return null;
/*      */     }
/* 1995 */     TypeStoreUser typeStoreUser = ensureParent().getUser();
/*      */     
/* 1997 */     if (isAttr()) {
/* 1998 */       return typeStoreUser.get_default_attribute_text(this._name);
/*      */     }
/* 2000 */     String str = typeStoreUser.get_default_element_text(this._name);
/*      */     
/* 2002 */     if (str != null) {
/* 2003 */       return str;
/*      */     }
/* 2005 */     TypeStoreVisitor typeStoreVisitor = typeStoreUser.new_visitor();
/*      */     
/* 2007 */     if (typeStoreVisitor == null) {
/* 2008 */       return null;
/*      */     }
/* 2010 */     for (Xobj xobj = this._parent._firstChild;; xobj = xobj._nextSibling) {
/*      */       
/* 2012 */       if (xobj.isElem()) {
/*      */         
/* 2014 */         typeStoreVisitor.visit(xobj._name);
/*      */         
/* 2016 */         if (xobj == this) {
/* 2017 */           return typeStoreVisitor.get_default_text();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean find_nil() {
/* 2024 */     if (isAttr()) {
/* 2025 */       return false;
/*      */     }
/* 2027 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2031 */       Xobj xobj = getAttr(Locale._xsiNil);
/*      */       
/* 2033 */       if (xobj == null) {
/* 2034 */         return false;
/*      */       }
/* 2036 */       String str = xobj.getValueAsString(3);
/*      */       
/* 2038 */       return (str.equals("true") || str.equals("1"));
/*      */     }
/*      */     finally {
/*      */       
/* 2042 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void invalidate_nil() {
/* 2048 */     if (isAttr()) {
/*      */       return;
/*      */     }
/* 2051 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2055 */       if (!this._user.build_nil()) {
/* 2056 */         removeAttr(Locale._xsiNil);
/*      */       } else {
/* 2058 */         setAttr(Locale._xsiNil, "true");
/*      */       } 
/*      */     } finally {
/*      */       
/* 2062 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int count_elements(b paramb) {
/* 2068 */     return this._locale.count(this, paramb, null);
/*      */   }
/*      */ 
/*      */   
/*      */   public int count_elements(QNameSet paramQNameSet) {
/* 2073 */     return this._locale.count(this, null, paramQNameSet);
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser find_element_user(b paramb, int paramInt) {
/* 2078 */     for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
/* 2079 */       if (xobj.isElem() && xobj._name.equals(paramb) && --paramInt < 0)
/* 2080 */         return xobj.getUser(); 
/*      */     } 
/* 2082 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser find_element_user(QNameSet paramQNameSet, int paramInt) {
/* 2087 */     for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
/* 2088 */       if (xobj.isElem() && paramQNameSet.contains(xobj._name) && --paramInt < 0)
/* 2089 */         return xobj.getUser(); 
/*      */     } 
/* 2091 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void find_all_element_users(b paramb, List paramList) {
/* 2096 */     for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
/* 2097 */       if (xobj.isElem() && xobj._name.equals(paramb))
/* 2098 */         paramList.add(xobj.getUser()); 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void find_all_element_users(QNameSet paramQNameSet, List paramList) {
/* 2103 */     for (Xobj xobj = this._firstChild; xobj != null; xobj = xobj._nextSibling) {
/* 2104 */       if (xobj.isElem() && paramQNameSet.contains(xobj._name))
/* 2105 */         paramList.add(xobj.getUser()); 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static TypeStoreUser insertElement(b paramb, Xobj paramXobj, int paramInt) {
/* 2110 */     paramXobj._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2114 */       Cur cur = paramXobj._locale.tempCur();
/* 2115 */       cur.moveTo(paramXobj, paramInt);
/* 2116 */       cur.createElement(paramb);
/* 2117 */       TypeStoreUser typeStoreUser = cur.getUser();
/* 2118 */       cur.release();
/* 2119 */       return typeStoreUser;
/*      */     }
/*      */     finally {
/*      */       
/* 2123 */       paramXobj._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser insert_element_user(b paramb, int paramInt) {
/* 2129 */     if (paramInt < 0) {
/* 2130 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2132 */     if (!isContainer()) {
/* 2133 */       throw new IllegalStateException();
/*      */     }
/* 2135 */     Xobj xobj = this._locale.findNthChildElem(this, paramb, null, paramInt);
/*      */     
/* 2137 */     if (xobj == null) {
/*      */       
/* 2139 */       if (paramInt > this._locale.count(this, paramb, null) + 1) {
/* 2140 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2142 */       return add_element_user(paramb);
/*      */     } 
/*      */     
/* 2145 */     return insertElement(paramb, xobj, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser insert_element_user(QNameSet paramQNameSet, b paramb, int paramInt) {
/* 2150 */     if (paramInt < 0) {
/* 2151 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2153 */     if (!isContainer()) {
/* 2154 */       throw new IllegalStateException();
/*      */     }
/* 2156 */     Xobj xobj = this._locale.findNthChildElem(this, null, paramQNameSet, paramInt);
/*      */     
/* 2158 */     if (xobj == null) {
/*      */       
/* 2160 */       if (paramInt > this._locale.count(this, null, paramQNameSet) + 1) {
/* 2161 */         throw new IndexOutOfBoundsException();
/*      */       }
/* 2163 */       return add_element_user(paramb);
/*      */     } 
/*      */     
/* 2166 */     return insertElement(paramb, xobj, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser add_element_user(b paramb) {
/* 2171 */     if (!isContainer()) {
/* 2172 */       throw new IllegalStateException();
/*      */     }
/* 2174 */     QNameSet qNameSet = null;
/* 2175 */     boolean bool = false;
/*      */     
/* 2177 */     Xobj xobj1 = null;
/*      */     
/* 2179 */     for (Xobj xobj2 = this._lastChild; xobj2 != null; xobj2 = xobj2._prevSibling) {
/*      */       
/* 2181 */       if (xobj2.isContainer()) {
/*      */         
/* 2183 */         if (xobj2._name.equals(paramb)) {
/*      */           break;
/*      */         }
/* 2186 */         if (!bool) {
/*      */           
/* 2188 */           qNameSet = this._user.get_element_ending_delimiters(paramb);
/* 2189 */           bool = true;
/*      */         } 
/*      */         
/* 2192 */         if (qNameSet == null || qNameSet.contains(xobj2._name)) {
/* 2193 */           xobj1 = xobj2;
/*      */         }
/*      */       } 
/*      */     } 
/* 2197 */     return (xobj1 == null) ? insertElement(paramb, this, -1) : insertElement(paramb, xobj1, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void removeElement(Xobj paramXobj) {
/* 2205 */     if (paramXobj == null) {
/* 2206 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2208 */     paramXobj._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2212 */       Cur cur = paramXobj.tempCur();
/* 2213 */       cur.moveNode(null);
/* 2214 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 2218 */       paramXobj._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void remove_element(b paramb, int paramInt) {
/* 2224 */     if (paramInt < 0) {
/* 2225 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2227 */     if (!isContainer()) {
/* 2228 */       throw new IllegalStateException();
/*      */     }
/*      */     
/*      */     Xobj xobj;
/* 2232 */     for (xobj = this._firstChild; xobj != null && (
/* 2233 */       !xobj.isElem() || !xobj._name.equals(paramb) || --paramInt >= 0); xobj = xobj._nextSibling);
/*      */ 
/*      */     
/* 2236 */     removeElement(xobj);
/*      */   }
/*      */ 
/*      */   
/*      */   public void remove_element(QNameSet paramQNameSet, int paramInt) {
/* 2241 */     if (paramInt < 0) {
/* 2242 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2244 */     if (!isContainer()) {
/* 2245 */       throw new IllegalStateException();
/*      */     }
/*      */     
/*      */     Xobj xobj;
/* 2249 */     for (xobj = this._firstChild; xobj != null && (
/* 2250 */       !xobj.isElem() || !paramQNameSet.contains(xobj._name) || --paramInt >= 0); xobj = xobj._nextSibling);
/*      */ 
/*      */     
/* 2253 */     removeElement(xobj);
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser find_attribute_user(b paramb) {
/* 2258 */     Xobj xobj = getAttr(paramb);
/*      */     
/* 2260 */     return (xobj == null) ? null : xobj.getUser();
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser add_attribute_user(b paramb) {
/* 2265 */     if (getAttr(paramb) != null) {
/* 2266 */       throw new IndexOutOfBoundsException();
/*      */     }
/* 2268 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2272 */       return setAttr(paramb, "").getUser();
/*      */     }
/*      */     finally {
/*      */       
/* 2276 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void remove_attribute(b paramb) {
/* 2282 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2286 */       if (!removeAttr(paramb)) {
/* 2287 */         throw new IndexOutOfBoundsException();
/*      */       }
/*      */     } finally {
/*      */       
/* 2291 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public TypeStoreUser copy_contents_from(TypeStore paramTypeStore) {
/* 2297 */     Xobj xobj = (Xobj)paramTypeStore;
/*      */     
/* 2299 */     if (xobj == this) {
/* 2300 */       return getUser();
/*      */     }
/* 2302 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2306 */       xobj._locale.enter();
/*      */       
/* 2308 */       Cur cur = tempCur();
/*      */ 
/*      */       
/*      */       try {
/* 2312 */         Cur cur1 = xobj.tempCur();
/* 2313 */         Map map = Locale.getAllNamespaces(cur1, null);
/* 2314 */         cur1.release();
/*      */         
/* 2316 */         if (isAttr()) {
/*      */           
/* 2318 */           Cur cur2 = xobj.tempCur();
/* 2319 */           String str = Locale.getTextValue(cur2);
/* 2320 */           cur2.release();
/*      */           
/* 2322 */           cur.setValue(str);
/*      */ 
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/* 2329 */           disconnectChildrenUsers();
/*      */           
/* 2331 */           assert !inhibitDisconnect();
/*      */           
/* 2333 */           setBit(1024);
/*      */           
/* 2335 */           b b1 = isContainer() ? getXsiTypeName() : null;
/*      */           
/* 2337 */           Xobj xobj1 = xobj.copyNode(this._locale);
/*      */           
/* 2339 */           Cur.moveNodeContents(this, null, true);
/*      */           
/* 2341 */           cur.next();
/*      */           
/* 2343 */           Cur.moveNodeContents(xobj1, cur, true);
/*      */           
/* 2345 */           cur.moveTo(this);
/*      */           
/* 2347 */           if (b1 != null) {
/* 2348 */             cur.setXsiType(b1);
/*      */           }
/* 2350 */           assert inhibitDisconnect();
/* 2351 */           clearBit(1024);
/*      */         } 
/*      */         
/* 2354 */         if (map != null)
/*      */         {
/* 2356 */           if (!cur.isContainer()) {
/* 2357 */             cur.toParent();
/*      */           }
/* 2359 */           Locale.applyNamespaces(cur, map);
/*      */         }
/*      */       
/*      */       }
/*      */       finally {
/*      */         
/* 2365 */         cur.release();
/*      */         
/* 2367 */         xobj._locale.exit();
/*      */       }
/*      */     
/*      */     } finally {
/*      */       
/* 2372 */       this._locale.exit();
/*      */     } 
/*      */     
/* 2375 */     return getUser();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreUser copy(SchemaTypeLoader paramSchemaTypeLoader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) {
/* 2382 */     Xobj xobj = null;
/* 2383 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/* 2384 */     SchemaType schemaType = (SchemaType)paramXmlOptions.get("DOCUMENT_TYPE");
/*      */     
/* 2386 */     if (schemaType == null) {
/* 2387 */       schemaType = (paramSchemaType == null) ? XmlObject.type : paramSchemaType;
/*      */     }
/* 2389 */     Locale locale = locale();
/* 2390 */     if (Boolean.TRUE.equals(paramXmlOptions.get("COPY_USE_NEW_LOCALE"))) {
/* 2391 */       locale = Locale.getLocale(paramSchemaTypeLoader, paramXmlOptions);
/*      */     }
/* 2393 */     if (schemaType.isDocumentType() || (schemaType.isNoType() && this instanceof DocumentXobj)) {
/* 2394 */       xobj = Cur.createDomDocumentRootXobj(locale, false);
/*      */     } else {
/* 2396 */       xobj = Cur.createDomDocumentRootXobj(locale, true);
/*      */     } 
/*      */     
/* 2399 */     locale.enter();
/*      */     
/*      */     try {
/* 2402 */       Cur cur = xobj.tempCur();
/* 2403 */       cur.setType(paramSchemaType);
/* 2404 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 2408 */       locale.exit();
/*      */     } 
/*      */     
/* 2411 */     return xobj.copy_contents_from(this);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void array_setter(XmlObject[] paramArrayOfXmlObject, b paramb) {
/* 2417 */     this._locale.enter();
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     try {
/* 2423 */       int i = paramArrayOfXmlObject.length;
/*      */       
/* 2425 */       ArrayList arrayList1 = new ArrayList();
/* 2426 */       ArrayList arrayList = new ArrayList();
/*      */       int j;
/* 2428 */       for (j = 0; j < i; j++) {
/*      */ 
/*      */ 
/*      */         
/* 2432 */         if (paramArrayOfXmlObject[j] == null) {
/* 2433 */           throw new IllegalArgumentException("Array element null");
/*      */         }
/* 2435 */         if (paramArrayOfXmlObject[j].isImmutable()) {
/*      */           
/* 2437 */           arrayList1.add(null);
/* 2438 */           arrayList.add(null);
/*      */         }
/*      */         else {
/*      */           
/* 2442 */           Xobj xobj = (Xobj)((TypeStoreUser)paramArrayOfXmlObject[j]).get_store();
/*      */           
/* 2444 */           if (xobj._locale == this._locale) {
/* 2445 */             arrayList1.add(xobj.copyNode(this._locale));
/*      */           } else {
/*      */             
/* 2448 */             xobj._locale.enter();
/*      */ 
/*      */             
/*      */             try {
/* 2452 */               arrayList1.add(xobj.copyNode(this._locale));
/*      */             }
/*      */             finally {
/*      */               
/* 2456 */               xobj._locale.exit();
/*      */             } 
/*      */           } 
/*      */           
/* 2460 */           arrayList.add(paramArrayOfXmlObject[j].schemaType());
/*      */         } 
/*      */       } 
/*      */       
/* 2464 */       j = count_elements(paramb);
/*      */       
/* 2466 */       for (; j > i; j--) {
/* 2467 */         remove_element(paramb, i);
/*      */       }
/* 2469 */       for (; i > j; j++) {
/* 2470 */         add_element_user(paramb);
/*      */       }
/* 2472 */       assert i == j;
/*      */       
/* 2474 */       ArrayList arrayList2 = new ArrayList();
/*      */       
/* 2476 */       find_all_element_users(paramb, arrayList2);
/*      */       
/* 2478 */       for (byte b1 = 0; b1 < arrayList2.size(); b1++) {
/* 2479 */         arrayList2.set(b1, (Xobj)((TypeStoreUser)arrayList2.get(b1)).get_store());
/*      */       }
/* 2481 */       assert arrayList2.size() == j;
/*      */       
/* 2483 */       Cur cur = tempCur();
/*      */       
/* 2485 */       for (byte b2 = 0; b2 < j; b2++) {
/*      */         
/* 2487 */         Xobj xobj = arrayList2.get(b2);
/*      */         
/* 2489 */         if (paramArrayOfXmlObject[b2].isImmutable()) {
/* 2490 */           xobj.getObject().set(paramArrayOfXmlObject[b2]);
/*      */         } else {
/*      */           
/* 2493 */           Cur.moveNodeContents(xobj, null, true);
/*      */           
/* 2495 */           cur.moveTo(xobj);
/* 2496 */           cur.next();
/*      */           
/* 2498 */           Cur.moveNodeContents(arrayList1.get(b2), cur, true);
/*      */           
/* 2500 */           xobj.change_type(arrayList.get(b2));
/*      */         } 
/*      */       } 
/*      */       
/* 2504 */       cur.release();
/*      */     }
/*      */     finally {
/*      */       
/* 2508 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void visit_elements(TypeStoreVisitor paramTypeStoreVisitor) {
/* 2514 */     throw new RuntimeException("Not implemeneted");
/*      */   }
/*      */ 
/*      */   
/*      */   public XmlObject[] exec_query(String paramString, XmlOptions paramXmlOptions) throws XmlException {
/* 2519 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2523 */       Cur cur = tempCur();
/*      */       
/* 2525 */       XmlObject[] arrayOfXmlObject = Query.objectExecQuery(cur, paramString, paramXmlOptions);
/*      */       
/* 2527 */       cur.release();
/*      */       
/* 2529 */       return arrayOfXmlObject;
/*      */     }
/*      */     finally {
/*      */       
/* 2533 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String find_prefix_for_nsuri(String paramString1, String paramString2) {
/* 2539 */     this._locale.enter();
/*      */ 
/*      */     
/*      */     try {
/* 2543 */       return prefixForNamespace(paramString1, paramString2, true);
/*      */     }
/*      */     finally {
/*      */       
/* 2547 */       this._locale.exit();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getNamespaceForPrefix(String paramString) {
/* 2553 */     return namespaceForPrefix(paramString, true);
/*      */   }
/*      */   
/*      */   abstract DomImpl.Dom getDom();
/*      */   
/*      */   abstract Xobj newNode(Locale paramLocale);
/*      */   
/*      */   static abstract class NodeXobj
/*      */     extends Xobj
/*      */     implements DomImpl.Dom, Node, NodeList {
/*      */     NodeXobj(Locale param1Locale, int param1Int1, int param1Int2) {
/* 2564 */       super(param1Locale, param1Int1, param1Int2);
/*      */     }
/*      */     DomImpl.Dom getDom() {
/* 2567 */       return this;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int getLength() {
/* 2573 */       return DomImpl._childNodes_getLength(this); } public Node item(int param1Int) {
/* 2574 */       return DomImpl._childNodes_item(this, param1Int);
/*      */     }
/* 2576 */     public Node appendChild(Node param1Node) { return DomImpl._node_appendChild(this, param1Node); }
/* 2577 */     public Node cloneNode(boolean param1Boolean) { return DomImpl._node_cloneNode(this, param1Boolean); }
/* 2578 */     public NamedNodeMap getAttributes() { return null; }
/* 2579 */     public NodeList getChildNodes() { return this; }
/* 2580 */     public Node getParentNode() { return DomImpl._node_getParentNode(this); }
/* 2581 */     public Node removeChild(Node param1Node) { return DomImpl._node_removeChild(this, param1Node); }
/* 2582 */     public Node getFirstChild() { return DomImpl._node_getFirstChild(this); }
/* 2583 */     public Node getLastChild() { return DomImpl._node_getLastChild(this); }
/* 2584 */     public String getLocalName() { return DomImpl._node_getLocalName(this); }
/* 2585 */     public String getNamespaceURI() { return DomImpl._node_getNamespaceURI(this); }
/* 2586 */     public Node getNextSibling() { return DomImpl._node_getNextSibling(this); }
/* 2587 */     public String getNodeName() { return DomImpl._node_getNodeName(this); }
/* 2588 */     public short getNodeType() { return DomImpl._node_getNodeType(this); }
/* 2589 */     public String getNodeValue() { return DomImpl._node_getNodeValue(this); }
/* 2590 */     public Document getOwnerDocument() { return DomImpl._node_getOwnerDocument(this); }
/* 2591 */     public String getPrefix() { return DomImpl._node_getPrefix(this); }
/* 2592 */     public Node getPreviousSibling() { return DomImpl._node_getPreviousSibling(this); }
/* 2593 */     public boolean hasAttributes() { return DomImpl._node_hasAttributes(this); }
/* 2594 */     public boolean hasChildNodes() { return DomImpl._node_hasChildNodes(this); }
/* 2595 */     public Node insertBefore(Node param1Node1, Node param1Node2) { return DomImpl._node_insertBefore(this, param1Node1, param1Node2); }
/* 2596 */     public boolean isSupported(String param1String1, String param1String2) { return DomImpl._node_isSupported(this, param1String1, param1String2); }
/* 2597 */     public void normalize() { DomImpl._node_normalize(this); }
/* 2598 */     public Node replaceChild(Node param1Node1, Node param1Node2) { return DomImpl._node_replaceChild(this, param1Node1, param1Node2); }
/* 2599 */     public void setNodeValue(String param1String) { DomImpl._node_setNodeValue(this, param1String); }
/* 2600 */     public void setPrefix(String param1String) { DomImpl._node_setPrefix(this, param1String); } public boolean nodeCanHavePrefixUri() {
/* 2601 */       return false;
/*      */     }
/*      */     
/* 2604 */     public Object getUserData(String param1String) { return DomImpl._node_getUserData(this, param1String); }
/* 2605 */     public Object setUserData(String param1String, Object param1Object, UserDataHandler param1UserDataHandler) { return DomImpl._node_setUserData(this, param1String, param1Object, param1UserDataHandler); }
/* 2606 */     public Object getFeature(String param1String1, String param1String2) { return DomImpl._node_getFeature(this, param1String1, param1String2); }
/* 2607 */     public boolean isEqualNode(Node param1Node) { return DomImpl._node_isEqualNode(this, param1Node); }
/* 2608 */     public boolean isSameNode(Node param1Node) { return DomImpl._node_isSameNode(this, param1Node); }
/* 2609 */     public String lookupNamespaceURI(String param1String) { return DomImpl._node_lookupNamespaceURI(this, param1String); }
/* 2610 */     public String lookupPrefix(String param1String) { return DomImpl._node_lookupPrefix(this, param1String); }
/* 2611 */     public boolean isDefaultNamespace(String param1String) { return DomImpl._node_isDefaultNamespace(this, param1String); }
/* 2612 */     public void setTextContent(String param1String) { DomImpl._node_setTextContent(this, param1String); }
/* 2613 */     public String getTextContent() { return DomImpl._node_getTextContent(this); }
/* 2614 */     public short compareDocumentPosition(Node param1Node) { return DomImpl._node_compareDocumentPosition(this, param1Node); } public String getBaseURI() {
/* 2615 */       return DomImpl._node_getBaseURI(this);
/*      */     } }
/*      */   
/*      */   static class DocumentXobj extends NodeXobj implements Document {
/*      */     private Hashtable _idToElement;
/*      */     
/*      */     DocumentXobj(Locale param1Locale) {
/* 2622 */       super(param1Locale, 1, 9);
/*      */     }
/*      */     Xobj newNode(Locale param1Locale) {
/* 2625 */       return new DocumentXobj(param1Locale);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public Attr createAttribute(String param1String) {
/* 2631 */       return DomImpl._document_createAttribute(this, param1String);
/* 2632 */     } public Attr createAttributeNS(String param1String1, String param1String2) { return DomImpl._document_createAttributeNS(this, param1String1, param1String2); }
/* 2633 */     public CDATASection createCDATASection(String param1String) { return DomImpl._document_createCDATASection(this, param1String); }
/* 2634 */     public Comment createComment(String param1String) { return DomImpl._document_createComment(this, param1String); }
/* 2635 */     public DocumentFragment createDocumentFragment() { return DomImpl._document_createDocumentFragment(this); }
/* 2636 */     public Element createElement(String param1String) { return DomImpl._document_createElement(this, param1String); }
/* 2637 */     public Element createElementNS(String param1String1, String param1String2) { return DomImpl._document_createElementNS(this, param1String1, param1String2); }
/* 2638 */     public EntityReference createEntityReference(String param1String) { return DomImpl._document_createEntityReference(this, param1String); }
/* 2639 */     public ProcessingInstruction createProcessingInstruction(String param1String1, String param1String2) { return DomImpl._document_createProcessingInstruction(this, param1String1, param1String2); }
/* 2640 */     public Text createTextNode(String param1String) { return DomImpl._document_createTextNode(this, param1String); }
/* 2641 */     public DocumentType getDoctype() { return DomImpl._document_getDoctype(this); } public Element getDocumentElement() {
/* 2642 */       return DomImpl._document_getDocumentElement(this);
/*      */     } public Element getElementById(String param1String) {
/* 2644 */       if (this._idToElement == null) return null; 
/* 2645 */       Xobj xobj = (Xobj)this._idToElement.get(param1String);
/* 2646 */       if (xobj == null) return null; 
/* 2647 */       if (!isInSameTree(xobj))
/*      */       {
/* 2649 */         this._idToElement.remove(param1String);
/*      */       }
/* 2651 */       return (Element)xobj;
/*      */     }
/* 2653 */     public NodeList getElementsByTagName(String param1String) { return DomImpl._document_getElementsByTagName(this, param1String); }
/* 2654 */     public NodeList getElementsByTagNameNS(String param1String1, String param1String2) { return DomImpl._document_getElementsByTagNameNS(this, param1String1, param1String2); }
/* 2655 */     public DOMImplementation getImplementation() { return DomImpl._document_getImplementation(this); } public Node importNode(Node param1Node, boolean param1Boolean) {
/* 2656 */       return DomImpl._document_importNode(this, param1Node, param1Boolean);
/*      */     }
/*      */     
/* 2659 */     public Node adoptNode(Node param1Node) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2660 */     public String getDocumentURI() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2661 */     public DOMConfiguration getDomConfig() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2662 */     public String getInputEncoding() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2663 */     public boolean getStrictErrorChecking() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2664 */     public String getXmlEncoding() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2665 */     public boolean getXmlStandalone() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2666 */     public String getXmlVersion() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2667 */     public void normalizeDocument() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2668 */     public Node renameNode(Node param1Node, String param1String1, String param1String2) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2669 */     public void setDocumentURI(String param1String) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2670 */     public void setStrictErrorChecking(boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2671 */     public void setXmlStandalone(boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); } public void setXmlVersion(String param1String) {
/* 2672 */       throw new RuntimeException("DOM Level 3 Not implemented");
/*      */     }
/*      */     protected void addIdElement(String param1String, DomImpl.Dom param1Dom) {
/* 2675 */       if (this._idToElement == null)
/* 2676 */         this._idToElement = new Hashtable(); 
/* 2677 */       this._idToElement.put(param1String, param1Dom);
/*      */     }
/*      */     void removeIdElement(String param1String) {
/* 2680 */       if (this._idToElement != null)
/* 2681 */         this._idToElement.remove(param1String); 
/*      */     }
/*      */   }
/*      */   
/*      */   static class DocumentFragXobj extends NodeXobj implements DocumentFragment {
/*      */     DocumentFragXobj(Locale param1Locale) {
/* 2687 */       super(param1Locale, 1, 11);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 2689 */       return new DocumentFragXobj(param1Locale);
/*      */     } }
/*      */   
/*      */   static final class ElementAttributes implements NamedNodeMap {
/*      */     private Xobj.ElementXobj _elementXobj;
/*      */     
/*      */     ElementAttributes(Xobj.ElementXobj param1ElementXobj) {
/* 2696 */       this._elementXobj = param1ElementXobj;
/*      */     }
/*      */     
/* 2699 */     public int getLength() { return DomImpl._attributes_getLength(this._elementXobj); }
/* 2700 */     public Node getNamedItem(String param1String) { return DomImpl._attributes_getNamedItem(this._elementXobj, param1String); }
/* 2701 */     public Node getNamedItemNS(String param1String1, String param1String2) { return DomImpl._attributes_getNamedItemNS(this._elementXobj, param1String1, param1String2); }
/* 2702 */     public Node item(int param1Int) { return DomImpl._attributes_item(this._elementXobj, param1Int); }
/* 2703 */     public Node removeNamedItem(String param1String) { return DomImpl._attributes_removeNamedItem(this._elementXobj, param1String); }
/* 2704 */     public Node removeNamedItemNS(String param1String1, String param1String2) { return DomImpl._attributes_removeNamedItemNS(this._elementXobj, param1String1, param1String2); }
/* 2705 */     public Node setNamedItem(Node param1Node) { return DomImpl._attributes_setNamedItem(this._elementXobj, param1Node); } public Node setNamedItemNS(Node param1Node) {
/* 2706 */       return DomImpl._attributes_setNamedItemNS(this._elementXobj, param1Node);
/*      */     }
/*      */   }
/*      */   
/*      */   static abstract class NamedNodeXobj
/*      */     extends NodeXobj {
/*      */     boolean _canHavePrefixUri;
/*      */     
/*      */     NamedNodeXobj(Locale param1Locale, int param1Int1, int param1Int2) {
/* 2715 */       super(param1Locale, param1Int1, param1Int2);
/* 2716 */       this._canHavePrefixUri = true;
/*      */     }
/*      */     public boolean nodeCanHavePrefixUri() {
/* 2719 */       return this._canHavePrefixUri;
/*      */     }
/*      */   }
/*      */   
/*      */   static class ElementXobj
/*      */     extends NamedNodeXobj implements Element {
/*      */     private Xobj.ElementAttributes _attributes;
/*      */     
/*      */     ElementXobj(Locale param1Locale, b param1b) {
/* 2728 */       super(param1Locale, 2, 1);
/* 2729 */       this._name = param1b;
/*      */     }
/*      */     Xobj newNode(Locale param1Locale) {
/* 2732 */       return new ElementXobj(param1Locale, this._name);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedNodeMap getAttributes() {
/* 2740 */       if (this._attributes == null) {
/* 2741 */         this._attributes = new Xobj.ElementAttributes(this);
/*      */       }
/* 2743 */       return this._attributes;
/*      */     }
/*      */     
/* 2746 */     public String getAttribute(String param1String) { return DomImpl._element_getAttribute(this, param1String); }
/* 2747 */     public Attr getAttributeNode(String param1String) { return DomImpl._element_getAttributeNode(this, param1String); }
/* 2748 */     public Attr getAttributeNodeNS(String param1String1, String param1String2) { return DomImpl._element_getAttributeNodeNS(this, param1String1, param1String2); }
/* 2749 */     public String getAttributeNS(String param1String1, String param1String2) { return DomImpl._element_getAttributeNS(this, param1String1, param1String2); }
/* 2750 */     public NodeList getElementsByTagName(String param1String) { return DomImpl._element_getElementsByTagName(this, param1String); }
/* 2751 */     public NodeList getElementsByTagNameNS(String param1String1, String param1String2) { return DomImpl._element_getElementsByTagNameNS(this, param1String1, param1String2); }
/* 2752 */     public String getTagName() { return DomImpl._element_getTagName(this); }
/* 2753 */     public boolean hasAttribute(String param1String) { return DomImpl._element_hasAttribute(this, param1String); }
/* 2754 */     public boolean hasAttributeNS(String param1String1, String param1String2) { return DomImpl._element_hasAttributeNS(this, param1String1, param1String2); }
/* 2755 */     public void removeAttribute(String param1String) { DomImpl._element_removeAttribute(this, param1String); }
/* 2756 */     public Attr removeAttributeNode(Attr param1Attr) { return DomImpl._element_removeAttributeNode(this, param1Attr); }
/* 2757 */     public void removeAttributeNS(String param1String1, String param1String2) { DomImpl._element_removeAttributeNS(this, param1String1, param1String2); }
/* 2758 */     public void setAttribute(String param1String1, String param1String2) { DomImpl._element_setAttribute(this, param1String1, param1String2); }
/* 2759 */     public Attr setAttributeNode(Attr param1Attr) { return DomImpl._element_setAttributeNode(this, param1Attr); }
/* 2760 */     public Attr setAttributeNodeNS(Attr param1Attr) { return DomImpl._element_setAttributeNodeNS(this, param1Attr); } public void setAttributeNS(String param1String1, String param1String2, String param1String3) {
/* 2761 */       DomImpl._element_setAttributeNS(this, param1String1, param1String2, param1String3);
/*      */     }
/*      */     
/* 2764 */     public TypeInfo getSchemaTypeInfo() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2765 */     public void setIdAttribute(String param1String, boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2766 */     public void setIdAttributeNS(String param1String1, String param1String2, boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); } public void setIdAttributeNode(Attr param1Attr, boolean param1Boolean) {
/* 2767 */       throw new RuntimeException("DOM Level 3 Not implemented");
/*      */     }
/*      */   }
/*      */   
/*      */   static class AttrXobj
/*      */     extends NamedNodeXobj
/*      */     implements Attr
/*      */   {
/*      */     AttrXobj(Locale param1Locale, b param1b) {
/* 2776 */       super(param1Locale, 3, 2);
/* 2777 */       this._name = param1b;
/*      */     }
/*      */     Xobj newNode(Locale param1Locale) {
/* 2780 */       return new AttrXobj(param1Locale, this._name);
/*      */     }
/*      */     public Node getNextSibling() {
/* 2783 */       return null;
/*      */     }
/*      */     
/* 2786 */     public String getName() { return DomImpl._node_getNodeName(this); }
/* 2787 */     public Element getOwnerElement() { return DomImpl._attr_getOwnerElement(this); }
/* 2788 */     public boolean getSpecified() { return DomImpl._attr_getSpecified(this); }
/* 2789 */     public String getValue() { return DomImpl._node_getNodeValue(this); } public void setValue(String param1String) {
/* 2790 */       DomImpl._node_setNodeValue(this, param1String);
/*      */     }
/*      */     
/* 2793 */     public TypeInfo getSchemaTypeInfo() { throw new RuntimeException("DOM Level 3 Not implemented"); } public boolean isId() {
/* 2794 */       return false;
/*      */     }
/*      */   }
/*      */   
/*      */   static class AttrIdXobj
/*      */     extends AttrXobj
/*      */   {
/*      */     AttrIdXobj(Locale param1Locale, b param1b) {
/* 2802 */       super(param1Locale, param1b);
/*      */     }
/*      */     
/*      */     public boolean isId() {
/* 2806 */       return true;
/*      */     } }
/*      */   
/*      */   static class CommentXobj extends NodeXobj implements Comment {
/*      */     CommentXobj(Locale param1Locale) {
/* 2811 */       super(param1Locale, 4, 8);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 2813 */       return new CommentXobj(param1Locale);
/*      */     } public NodeList getChildNodes() {
/* 2815 */       return DomImpl._emptyNodeList;
/*      */     }
/* 2817 */     public void appendData(String param1String) { DomImpl._characterData_appendData(this, param1String); }
/* 2818 */     public void deleteData(int param1Int1, int param1Int2) { DomImpl._characterData_deleteData(this, param1Int1, param1Int2); }
/* 2819 */     public String getData() { return DomImpl._characterData_getData(this); }
/* 2820 */     public int getLength() { return DomImpl._characterData_getLength(this); }
/* 2821 */     public Node getFirstChild() { return null; }
/* 2822 */     public void insertData(int param1Int, String param1String) { DomImpl._characterData_insertData(this, param1Int, param1String); }
/* 2823 */     public void replaceData(int param1Int1, int param1Int2, String param1String) { DomImpl._characterData_replaceData(this, param1Int1, param1Int2, param1String); }
/* 2824 */     public void setData(String param1String) { DomImpl._characterData_setData(this, param1String); } public String substringData(int param1Int1, int param1Int2) {
/* 2825 */       return DomImpl._characterData_substringData(this, param1Int1, param1Int2);
/*      */     }
/*      */   }
/*      */   
/*      */   static class ProcInstXobj
/*      */     extends NodeXobj implements ProcessingInstruction {
/*      */     ProcInstXobj(Locale param1Locale, String param1String) {
/* 2832 */       super(param1Locale, 5, 7);
/* 2833 */       this._name = this._locale.makeQName(null, param1String);
/*      */     }
/*      */     Xobj newNode(Locale param1Locale) {
/* 2836 */       return new ProcInstXobj(param1Locale, this._name.dT());
/*      */     }
/* 2838 */     public int getLength() { return 0; } public Node getFirstChild() {
/* 2839 */       return null;
/*      */     }
/* 2841 */     public String getData() { return DomImpl._processingInstruction_getData(this); }
/* 2842 */     public String getTarget() { return DomImpl._processingInstruction_getTarget(this); } public void setData(String param1String) {
/* 2843 */       DomImpl._processingInstruction_setData(this, param1String);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   static class SoapPartDocXobj
/*      */     extends DocumentXobj
/*      */   {
/*      */     Xobj.SoapPartDom _soapPartDom;
/*      */     
/*      */     SoapPartDocXobj(Locale param1Locale) {
/* 2854 */       super(param1Locale);
/*      */       
/* 2856 */       this._soapPartDom = new Xobj.SoapPartDom(this);
/*      */     }
/*      */     DomImpl.Dom getDom() {
/* 2859 */       return this._soapPartDom;
/*      */     } Xobj newNode(Locale param1Locale) {
/* 2861 */       return new SoapPartDocXobj(param1Locale);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapPartDom
/*      */     extends SOAPPart implements DomImpl.Dom, Document, NodeList {
/*      */     Xobj.SoapPartDocXobj _docXobj;
/*      */     
/*      */     SoapPartDom(Xobj.SoapPartDocXobj param1SoapPartDocXobj) {
/* 2870 */       this._docXobj = param1SoapPartDocXobj;
/*      */     }
/*      */     
/* 2873 */     public int nodeType() { return 9; }
/* 2874 */     public Locale locale() { return this._docXobj._locale; }
/* 2875 */     public Cur tempCur() { return this._docXobj.tempCur(); } public b getQName() {
/* 2876 */       return this._docXobj._name;
/*      */     }
/* 2878 */     public void dump() { dump(System.out); }
/* 2879 */     public void dump(PrintStream param1PrintStream) { this._docXobj.dump(param1PrintStream); } public void dump(PrintStream param1PrintStream, Object param1Object) {
/* 2880 */       this._docXobj.dump(param1PrintStream, param1Object);
/*      */     } public String name() {
/* 2882 */       return "#document";
/*      */     }
/* 2884 */     public Node appendChild(Node param1Node) { return DomImpl._node_appendChild(this, param1Node); }
/* 2885 */     public Node cloneNode(boolean param1Boolean) { return DomImpl._node_cloneNode(this, param1Boolean); }
/* 2886 */     public NamedNodeMap getAttributes() { return null; }
/* 2887 */     public NodeList getChildNodes() { return this; }
/* 2888 */     public Node getParentNode() { return DomImpl._node_getParentNode(this); }
/* 2889 */     public Node removeChild(Node param1Node) { return DomImpl._node_removeChild(this, param1Node); }
/* 2890 */     public Node getFirstChild() { return DomImpl._node_getFirstChild(this); }
/* 2891 */     public Node getLastChild() { return DomImpl._node_getLastChild(this); }
/* 2892 */     public String getLocalName() { return DomImpl._node_getLocalName(this); }
/* 2893 */     public String getNamespaceURI() { return DomImpl._node_getNamespaceURI(this); }
/* 2894 */     public Node getNextSibling() { return DomImpl._node_getNextSibling(this); }
/* 2895 */     public String getNodeName() { return DomImpl._node_getNodeName(this); }
/* 2896 */     public short getNodeType() { return DomImpl._node_getNodeType(this); }
/* 2897 */     public String getNodeValue() { return DomImpl._node_getNodeValue(this); }
/* 2898 */     public Document getOwnerDocument() { return DomImpl._node_getOwnerDocument(this); }
/* 2899 */     public String getPrefix() { return DomImpl._node_getPrefix(this); }
/* 2900 */     public Node getPreviousSibling() { return DomImpl._node_getPreviousSibling(this); }
/* 2901 */     public boolean hasAttributes() { return DomImpl._node_hasAttributes(this); }
/* 2902 */     public boolean hasChildNodes() { return DomImpl._node_hasChildNodes(this); }
/* 2903 */     public Node insertBefore(Node param1Node1, Node param1Node2) { return DomImpl._node_insertBefore(this, param1Node1, param1Node2); }
/* 2904 */     public boolean isSupported(String param1String1, String param1String2) { return DomImpl._node_isSupported(this, param1String1, param1String2); }
/* 2905 */     public void normalize() { DomImpl._node_normalize(this); }
/* 2906 */     public Node replaceChild(Node param1Node1, Node param1Node2) { return DomImpl._node_replaceChild(this, param1Node1, param1Node2); }
/* 2907 */     public void setNodeValue(String param1String) { DomImpl._node_setNodeValue(this, param1String); } public void setPrefix(String param1String) {
/* 2908 */       DomImpl._node_setPrefix(this, param1String);
/*      */     }
/*      */     
/* 2911 */     public Object getUserData(String param1String) { return DomImpl._node_getUserData(this, param1String); }
/* 2912 */     public Object setUserData(String param1String, Object param1Object, UserDataHandler param1UserDataHandler) { return DomImpl._node_setUserData(this, param1String, param1Object, param1UserDataHandler); }
/* 2913 */     public Object getFeature(String param1String1, String param1String2) { return DomImpl._node_getFeature(this, param1String1, param1String2); }
/* 2914 */     public boolean isEqualNode(Node param1Node) { return DomImpl._node_isEqualNode(this, param1Node); }
/* 2915 */     public boolean isSameNode(Node param1Node) { return DomImpl._node_isSameNode(this, param1Node); }
/* 2916 */     public String lookupNamespaceURI(String param1String) { return DomImpl._node_lookupNamespaceURI(this, param1String); }
/* 2917 */     public String lookupPrefix(String param1String) { return DomImpl._node_lookupPrefix(this, param1String); }
/* 2918 */     public boolean isDefaultNamespace(String param1String) { return DomImpl._node_isDefaultNamespace(this, param1String); }
/* 2919 */     public void setTextContent(String param1String) { DomImpl._node_setTextContent(this, param1String); }
/* 2920 */     public String getTextContent() { return DomImpl._node_getTextContent(this); }
/* 2921 */     public short compareDocumentPosition(Node param1Node) { return DomImpl._node_compareDocumentPosition(this, param1Node); }
/* 2922 */     public String getBaseURI() { return DomImpl._node_getBaseURI(this); }
/* 2923 */     public Node adoptNode(Node param1Node) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2924 */     public String getDocumentURI() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2925 */     public DOMConfiguration getDomConfig() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2926 */     public String getInputEncoding() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2927 */     public boolean getStrictErrorChecking() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2928 */     public String getXmlEncoding() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2929 */     public boolean getXmlStandalone() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2930 */     public String getXmlVersion() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2931 */     public void normalizeDocument() { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2932 */     public Node renameNode(Node param1Node, String param1String1, String param1String2) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2933 */     public void setDocumentURI(String param1String) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2934 */     public void setStrictErrorChecking(boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); }
/* 2935 */     public void setXmlStandalone(boolean param1Boolean) { throw new RuntimeException("DOM Level 3 Not implemented"); } public void setXmlVersion(String param1String) {
/* 2936 */       throw new RuntimeException("DOM Level 3 Not implemented");
/*      */     }
/* 2938 */     public Attr createAttribute(String param1String) { return DomImpl._document_createAttribute(this, param1String); }
/* 2939 */     public Attr createAttributeNS(String param1String1, String param1String2) { return DomImpl._document_createAttributeNS(this, param1String1, param1String2); }
/* 2940 */     public CDATASection createCDATASection(String param1String) { return DomImpl._document_createCDATASection(this, param1String); }
/* 2941 */     public Comment createComment(String param1String) { return DomImpl._document_createComment(this, param1String); }
/* 2942 */     public DocumentFragment createDocumentFragment() { return DomImpl._document_createDocumentFragment(this); }
/* 2943 */     public Element createElement(String param1String) { return DomImpl._document_createElement(this, param1String); }
/* 2944 */     public Element createElementNS(String param1String1, String param1String2) { return DomImpl._document_createElementNS(this, param1String1, param1String2); }
/* 2945 */     public EntityReference createEntityReference(String param1String) { return DomImpl._document_createEntityReference(this, param1String); }
/* 2946 */     public ProcessingInstruction createProcessingInstruction(String param1String1, String param1String2) { return DomImpl._document_createProcessingInstruction(this, param1String1, param1String2); }
/* 2947 */     public Text createTextNode(String param1String) { return DomImpl._document_createTextNode(this, param1String); }
/* 2948 */     public DocumentType getDoctype() { return DomImpl._document_getDoctype(this); }
/* 2949 */     public Element getDocumentElement() { return DomImpl._document_getDocumentElement(this); }
/* 2950 */     public Element getElementById(String param1String) { return DomImpl._document_getElementById(this, param1String); }
/* 2951 */     public NodeList getElementsByTagName(String param1String) { return DomImpl._document_getElementsByTagName(this, param1String); }
/* 2952 */     public NodeList getElementsByTagNameNS(String param1String1, String param1String2) { return DomImpl._document_getElementsByTagNameNS(this, param1String1, param1String2); }
/* 2953 */     public DOMImplementation getImplementation() { return DomImpl._document_getImplementation(this); } public Node importNode(Node param1Node, boolean param1Boolean) {
/* 2954 */       return DomImpl._document_importNode(this, param1Node, param1Boolean);
/*      */     }
/* 2956 */     public int getLength() { return DomImpl._childNodes_getLength(this); } public Node item(int param1Int) {
/* 2957 */       return DomImpl._childNodes_item(this, param1Int);
/*      */     }
/* 2959 */     public void removeAllMimeHeaders() { DomImpl._soapPart_removeAllMimeHeaders(this); }
/* 2960 */     public void removeMimeHeader(String param1String) { DomImpl._soapPart_removeMimeHeader(this, param1String); }
/* 2961 */     public Iterator getAllMimeHeaders() { return DomImpl._soapPart_getAllMimeHeaders(this); }
/* 2962 */     public SOAPEnvelope getEnvelope() { return DomImpl._soapPart_getEnvelope(this); }
/* 2963 */     public Source getContent() { return DomImpl._soapPart_getContent(this); }
/* 2964 */     public void setContent(Source param1Source) { DomImpl._soapPart_setContent(this, param1Source); }
/* 2965 */     public String[] getMimeHeader(String param1String) { return DomImpl._soapPart_getMimeHeader(this, param1String); }
/* 2966 */     public void addMimeHeader(String param1String1, String param1String2) { DomImpl._soapPart_addMimeHeader(this, param1String1, param1String2); }
/* 2967 */     public void setMimeHeader(String param1String1, String param1String2) { DomImpl._soapPart_setMimeHeader(this, param1String1, param1String2); }
/* 2968 */     public Iterator getMatchingMimeHeaders(String[] param1ArrayOfString) { return DomImpl._soapPart_getMatchingMimeHeaders(this, param1ArrayOfString); } public Iterator getNonMatchingMimeHeaders(String[] param1ArrayOfString) {
/* 2969 */       return DomImpl._soapPart_getNonMatchingMimeHeaders(this, param1ArrayOfString);
/*      */     } public boolean nodeCanHavePrefixUri() {
/* 2971 */       return true;
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapElementXobj
/*      */     extends ElementXobj
/*      */     implements Node, SOAPElement {
/*      */     SoapElementXobj(Locale param1Locale, b param1b) {
/* 2979 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 2981 */       return new SoapElementXobj(param1Locale, this._name);
/*      */     }
/* 2983 */     public void detachNode() { DomImpl._soapNode_detachNode(this); }
/* 2984 */     public void recycleNode() { DomImpl._soapNode_recycleNode(this); }
/* 2985 */     public String getValue() { return DomImpl._soapNode_getValue(this); }
/* 2986 */     public void setValue(String param1String) { DomImpl._soapNode_setValue(this, param1String); }
/* 2987 */     public SOAPElement getParentElement() { return DomImpl._soapNode_getParentElement(this); } public void setParentElement(SOAPElement param1SOAPElement) {
/* 2988 */       DomImpl._soapNode_setParentElement(this, param1SOAPElement);
/*      */     }
/* 2990 */     public void removeContents() { DomImpl._soapElement_removeContents(this); }
/* 2991 */     public String getEncodingStyle() { return DomImpl._soapElement_getEncodingStyle(this); }
/* 2992 */     public void setEncodingStyle(String param1String) { DomImpl._soapElement_setEncodingStyle(this, param1String); }
/* 2993 */     public boolean removeNamespaceDeclaration(String param1String) { return DomImpl._soapElement_removeNamespaceDeclaration(this, param1String); }
/* 2994 */     public Iterator getAllAttributes() { return DomImpl._soapElement_getAllAttributes(this); }
/* 2995 */     public Iterator getChildElements() { return DomImpl._soapElement_getChildElements(this); }
/* 2996 */     public Iterator getNamespacePrefixes() { return DomImpl._soapElement_getNamespacePrefixes(this); }
/* 2997 */     public SOAPElement addAttribute(Name param1Name, String param1String) throws SOAPException { return DomImpl._soapElement_addAttribute(this, param1Name, param1String); }
/* 2998 */     public SOAPElement addChildElement(SOAPElement param1SOAPElement) throws SOAPException { return DomImpl._soapElement_addChildElement(this, param1SOAPElement); }
/* 2999 */     public SOAPElement addChildElement(Name param1Name) throws SOAPException { return DomImpl._soapElement_addChildElement(this, param1Name); }
/* 3000 */     public SOAPElement addChildElement(String param1String) throws SOAPException { return DomImpl._soapElement_addChildElement(this, param1String); }
/* 3001 */     public SOAPElement addChildElement(String param1String1, String param1String2) throws SOAPException { return DomImpl._soapElement_addChildElement(this, param1String1, param1String2); }
/* 3002 */     public SOAPElement addChildElement(String param1String1, String param1String2, String param1String3) throws SOAPException { return DomImpl._soapElement_addChildElement(this, param1String1, param1String2, param1String3); }
/* 3003 */     public SOAPElement addNamespaceDeclaration(String param1String1, String param1String2) { return DomImpl._soapElement_addNamespaceDeclaration(this, param1String1, param1String2); }
/* 3004 */     public SOAPElement addTextNode(String param1String) { return DomImpl._soapElement_addTextNode(this, param1String); }
/* 3005 */     public String getAttributeValue(Name param1Name) { return DomImpl._soapElement_getAttributeValue(this, param1Name); }
/* 3006 */     public Iterator getChildElements(Name param1Name) { return DomImpl._soapElement_getChildElements(this, param1Name); }
/* 3007 */     public Name getElementName() { return DomImpl._soapElement_getElementName(this); }
/* 3008 */     public String getNamespaceURI(String param1String) { return DomImpl._soapElement_getNamespaceURI(this, param1String); }
/* 3009 */     public Iterator getVisibleNamespacePrefixes() { return DomImpl._soapElement_getVisibleNamespacePrefixes(this); } public boolean removeAttribute(Name param1Name) {
/* 3010 */       return DomImpl._soapElement_removeAttribute(this, param1Name);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapBodyXobj extends SoapElementXobj implements SOAPBody { SoapBodyXobj(Locale param1Locale, b param1b) {
/* 3015 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3017 */       return new SoapBodyXobj(param1Locale, this._name);
/*      */     }
/* 3019 */     public boolean hasFault() { return DomImpl.soapBody_hasFault(this); }
/* 3020 */     public SOAPFault addFault() throws SOAPException { return DomImpl.soapBody_addFault(this); }
/* 3021 */     public SOAPFault getFault() { return DomImpl.soapBody_getFault(this); }
/* 3022 */     public SOAPBodyElement addBodyElement(Name param1Name) { return DomImpl.soapBody_addBodyElement(this, param1Name); }
/* 3023 */     public SOAPBodyElement addDocument(Document param1Document) { return DomImpl.soapBody_addDocument(this, param1Document); }
/* 3024 */     public SOAPFault addFault(Name param1Name, String param1String) throws SOAPException { return DomImpl.soapBody_addFault(this, param1Name, param1String); } public SOAPFault addFault(Name param1Name, String param1String, Locale param1Locale) throws SOAPException {
/* 3025 */       return DomImpl.soapBody_addFault(this, param1Name, param1String, param1Locale);
/*      */     } }
/*      */   
/*      */   static class SoapBodyElementXobj extends SoapElementXobj implements SOAPBodyElement {
/*      */     SoapBodyElementXobj(Locale param1Locale, b param1b) {
/* 3030 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3032 */       return new SoapBodyElementXobj(param1Locale, this._name);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapEnvelopeXobj extends SoapElementXobj implements SOAPEnvelope { SoapEnvelopeXobj(Locale param1Locale, b param1b) {
/* 3037 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3039 */       return new SoapEnvelopeXobj(param1Locale, this._name);
/*      */     }
/* 3041 */     public SOAPBody addBody() throws SOAPException { return DomImpl._soapEnvelope_addBody(this); }
/* 3042 */     public SOAPBody getBody() throws SOAPException { return DomImpl._soapEnvelope_getBody(this); }
/* 3043 */     public SOAPHeader getHeader() throws SOAPException { return DomImpl._soapEnvelope_getHeader(this); }
/* 3044 */     public SOAPHeader addHeader() throws SOAPException { return DomImpl._soapEnvelope_addHeader(this); }
/* 3045 */     public Name createName(String param1String) { return DomImpl._soapEnvelope_createName(this, param1String); } public Name createName(String param1String1, String param1String2, String param1String3) {
/* 3046 */       return DomImpl._soapEnvelope_createName(this, param1String1, param1String2, param1String3);
/*      */     } }
/*      */   
/*      */   static class SoapHeaderXobj extends SoapElementXobj implements SOAPHeader {
/*      */     SoapHeaderXobj(Locale param1Locale, b param1b) {
/* 3051 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3053 */       return new SoapHeaderXobj(param1Locale, this._name);
/*      */     }
/* 3055 */     public Iterator examineAllHeaderElements() { return DomImpl.soapHeader_examineAllHeaderElements(this); }
/* 3056 */     public Iterator extractAllHeaderElements() { return DomImpl.soapHeader_extractAllHeaderElements(this); }
/* 3057 */     public Iterator examineHeaderElements(String param1String) { return DomImpl.soapHeader_examineHeaderElements(this, param1String); }
/* 3058 */     public Iterator examineMustUnderstandHeaderElements(String param1String) { return DomImpl.soapHeader_examineMustUnderstandHeaderElements(this, param1String); }
/* 3059 */     public Iterator extractHeaderElements(String param1String) { return DomImpl.soapHeader_extractHeaderElements(this, param1String); } public SOAPHeaderElement addHeaderElement(Name param1Name) {
/* 3060 */       return DomImpl.soapHeader_addHeaderElement(this, param1Name);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapHeaderElementXobj extends SoapElementXobj implements SOAPHeaderElement { SoapHeaderElementXobj(Locale param1Locale, b param1b) {
/* 3065 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3067 */       return new SoapHeaderElementXobj(param1Locale, this._name);
/*      */     }
/* 3069 */     public void setMustUnderstand(boolean param1Boolean) { DomImpl.soapHeaderElement_setMustUnderstand(this, param1Boolean); }
/* 3070 */     public boolean getMustUnderstand() { return DomImpl.soapHeaderElement_getMustUnderstand(this); }
/* 3071 */     public void setActor(String param1String) { DomImpl.soapHeaderElement_setActor(this, param1String); } public String getActor() {
/* 3072 */       return DomImpl.soapHeaderElement_getActor(this);
/*      */     } }
/*      */   
/*      */   static class SoapFaultXobj extends SoapBodyElementXobj implements SOAPFault {
/*      */     SoapFaultXobj(Locale param1Locale, b param1b) {
/* 3077 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3079 */       return new SoapFaultXobj(param1Locale, this._name);
/*      */     }
/* 3081 */     public void setFaultString(String param1String) { DomImpl.soapFault_setFaultString(this, param1String); }
/* 3082 */     public void setFaultString(String param1String, Locale param1Locale) { DomImpl.soapFault_setFaultString(this, param1String, param1Locale); }
/* 3083 */     public void setFaultCode(Name param1Name) throws SOAPException { DomImpl.soapFault_setFaultCode(this, param1Name); }
/* 3084 */     public void setFaultActor(String param1String) { DomImpl.soapFault_setFaultActor(this, param1String); }
/* 3085 */     public String getFaultActor() { return DomImpl.soapFault_getFaultActor(this); }
/* 3086 */     public String getFaultCode() { return DomImpl.soapFault_getFaultCode(this); }
/* 3087 */     public void setFaultCode(String param1String) throws SOAPException { DomImpl.soapFault_setFaultCode(this, param1String); }
/* 3088 */     public Locale getFaultStringLocale() { return DomImpl.soapFault_getFaultStringLocale(this); }
/* 3089 */     public Name getFaultCodeAsName() { return DomImpl.soapFault_getFaultCodeAsName(this); }
/* 3090 */     public String getFaultString() { return DomImpl.soapFault_getFaultString(this); }
/* 3091 */     public Detail addDetail() throws SOAPException { return DomImpl.soapFault_addDetail(this); } public Detail getDetail() {
/* 3092 */       return DomImpl.soapFault_getDetail(this);
/*      */     }
/*      */   }
/*      */   
/*      */   static class SoapFaultElementXobj extends SoapElementXobj implements SOAPFaultElement { SoapFaultElementXobj(Locale param1Locale, b param1b) {
/* 3097 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3099 */       return new SoapFaultElementXobj(param1Locale, this._name);
/*      */     } }
/*      */   
/*      */   static class DetailXobj extends SoapFaultElementXobj implements Detail {
/*      */     DetailXobj(Locale param1Locale, b param1b) {
/* 3104 */       super(param1Locale, param1b);
/*      */     } Xobj newNode(Locale param1Locale) {
/* 3106 */       return new DetailXobj(param1Locale, this._name);
/*      */     }
/* 3108 */     public DetailEntry addDetailEntry(Name param1Name) { return DomImpl.detail_addDetailEntry(this, param1Name); } public Iterator getDetailEntries() {
/* 3109 */       return DomImpl.detail_getDetailEntries(this);
/*      */     }
/*      */   }
/*      */   
/*      */   static class DetailEntryXobj extends SoapElementXobj implements DetailEntry { Xobj newNode(Locale param1Locale) {
/* 3114 */       return new DetailEntryXobj(param1Locale, this._name);
/*      */     } DetailEntryXobj(Locale param1Locale, b param1b) {
/* 3116 */       super(param1Locale, param1b);
/*      */     } }
/*      */   static class Bookmark implements XmlCursor.XmlMark { Xobj _xobj;
/*      */     int _pos;
/*      */     Bookmark _next;
/*      */     Bookmark _prev;
/*      */     Object _key;
/*      */     Object _value;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     boolean isOnList(Bookmark param1Bookmark) {
/* 3127 */       for (; param1Bookmark != null; param1Bookmark = param1Bookmark._next) {
/* 3128 */         if (param1Bookmark == this)
/* 3129 */           return true; 
/*      */       } 
/* 3131 */       return false;
/*      */     }
/*      */ 
/*      */     
/*      */     Bookmark listInsert(Bookmark param1Bookmark) {
/* 3136 */       assert this._next == null && this._prev == null;
/*      */       
/* 3138 */       if (param1Bookmark == null) {
/* 3139 */         param1Bookmark = this._prev = this;
/*      */       } else {
/*      */         
/* 3142 */         this._prev = param1Bookmark._prev;
/* 3143 */         param1Bookmark._prev = param1Bookmark._prev._next = this;
/*      */       } 
/*      */       
/* 3146 */       return param1Bookmark;
/*      */     }
/*      */ 
/*      */     
/*      */     Bookmark listRemove(Bookmark param1Bookmark) {
/* 3151 */       assert this._prev != null && isOnList(param1Bookmark);
/*      */       
/* 3153 */       if (this._prev == this) {
/* 3154 */         param1Bookmark = null;
/*      */       } else {
/*      */         
/* 3157 */         if (param1Bookmark == this) {
/* 3158 */           param1Bookmark = this._next;
/*      */         } else {
/* 3160 */           this._prev._next = this._next;
/*      */         } 
/* 3162 */         if (this._next == null) {
/* 3163 */           param1Bookmark._prev = this._prev;
/*      */         } else {
/*      */           
/* 3166 */           this._next._prev = this._prev;
/* 3167 */           this._next = null;
/*      */         } 
/*      */       } 
/*      */       
/* 3171 */       this._prev = null;
/* 3172 */       assert this._next == null;
/*      */       
/* 3174 */       return param1Bookmark;
/*      */     }
/*      */ 
/*      */     
/*      */     void moveTo(Xobj param1Xobj, int param1Int) {
/* 3179 */       assert isOnList(this._xobj._bookmarks);
/*      */       
/* 3181 */       if (this._xobj != param1Xobj) {
/*      */         
/* 3183 */         this._xobj._bookmarks = listRemove(this._xobj._bookmarks);
/* 3184 */         param1Xobj._bookmarks = listInsert(param1Xobj._bookmarks);
/*      */         
/* 3186 */         this._xobj = param1Xobj;
/*      */       } 
/*      */       
/* 3189 */       this._pos = param1Int;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlCursor createCursor() {
/* 3198 */       if (this._xobj == null)
/*      */       {
/* 3200 */         throw new IllegalStateException("Attempting to create a cursor on a bookmark that has been cleared or replaced.");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/* 3205 */       return Cursor.newCursor(this._xobj, this._pos);
/*      */     } }
/*      */ 
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\store\Xobj.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */