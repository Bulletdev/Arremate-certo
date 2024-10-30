/*      */ package org.apache.xmlbeans.impl.common;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.XmlError;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XPath
/*      */ {
/*      */   public static final String _NS_BOUNDARY = "$xmlbeans!ns_boundary";
/*      */   public static final String _DEFAULT_ELT_NS = "$xmlbeans!default_uri";
/*      */   private final Selector _selector;
/*      */   private final boolean _sawDeepDot;
/*      */   static Class class$org$apache$xmlbeans$impl$common$XPath;
/*      */   
/*      */   public static class XPathCompileException
/*      */     extends XmlException
/*      */   {
/*      */     XPathCompileException(XmlError param1XmlError) {
/*   35 */       super(param1XmlError.toString(), null, param1XmlError);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static Class class$(String paramString) {
/*      */     
/*   43 */     try { return Class.forName(paramString); } catch (ClassNotFoundException classNotFoundException) { throw (new NoClassDefFoundError()).initCause(classNotFoundException); }
/*      */   
/*      */   }
/*      */   public static class ExecutionContext { public static final int HIT = 1; public static final int DESCEND = 2;
/*   47 */     private ArrayList _stack = new ArrayList();
/*      */     
/*      */     public static final int ATTRS = 4;
/*      */     
/*      */     private XPath _xpath;
/*      */     private PathContext[] _paths;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     public final void init(XPath param1XPath) {
/*   56 */       if (this._xpath != param1XPath) {
/*      */         
/*   58 */         this._xpath = param1XPath;
/*      */         
/*   60 */         this._paths = new PathContext[param1XPath._selector._paths.length];
/*      */         
/*   62 */         for (byte b1 = 0; b1 < this._paths.length; b1++) {
/*   63 */           this._paths[b1] = new PathContext();
/*      */         }
/*      */       } 
/*   66 */       this._stack.clear();
/*      */       
/*   68 */       for (byte b = 0; b < this._paths.length; b++) {
/*   69 */         this._paths[b].init(param1XPath._selector._paths[b]);
/*      */       }
/*      */     }
/*      */     
/*      */     public final int start() {
/*   74 */       int i = 0;
/*      */       
/*   76 */       for (byte b = 0; b < this._paths.length; b++) {
/*   77 */         i |= this._paths[b].start();
/*      */       }
/*   79 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public final int element(b param1b) {
/*   84 */       assert param1b != null;
/*      */       
/*   86 */       this._stack.add(param1b);
/*      */       
/*   88 */       int i = 0;
/*      */       
/*   90 */       for (byte b1 = 0; b1 < this._paths.length; b1++) {
/*   91 */         i |= this._paths[b1].element(param1b);
/*      */       }
/*   93 */       return i;
/*      */     }
/*      */ 
/*      */     
/*      */     public final boolean attr(b param1b) {
/*   98 */       boolean bool = false;
/*      */       
/*  100 */       for (byte b1 = 0; b1 < this._paths.length; b1++) {
/*  101 */         bool |= this._paths[b1].attr(param1b);
/*      */       }
/*  103 */       return bool;
/*      */     }
/*      */ 
/*      */     
/*      */     public final void end() {
/*  108 */       this._stack.remove(this._stack.size() - 1);
/*      */       
/*  110 */       for (byte b = 0; b < this._paths.length; b++) {
/*  111 */         this._paths[b].end();
/*      */       }
/*      */     }
/*      */     
/*      */     private final class PathContext
/*      */     {
/*      */       private XPath.Step _curr;
/*  118 */       private List _prev = new ArrayList();
/*      */       static final boolean $assertionsDisabled;
/*      */       private final XPath.ExecutionContext this$0;
/*      */       
/*      */       void init(XPath.Step param2Step) {
/*  123 */         this._curr = param2Step;
/*  124 */         this._prev.clear();
/*      */       }
/*      */ 
/*      */       
/*      */       private b top(int param2Int) {
/*  129 */         return XPath.ExecutionContext.this._stack.get(XPath.ExecutionContext.this._stack.size() - 1 - param2Int);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       private void backtrack() {
/*  135 */         assert this._curr != null;
/*      */         
/*  137 */         if (this._curr._hasBacktrack) {
/*      */ 
/*      */           
/*  140 */           this._curr = this._curr._backtrack;
/*      */           
/*      */           return;
/*      */         } 
/*  144 */         assert !this._curr._deep;
/*      */         
/*  146 */         this._curr = this._curr._prev;
/*      */         
/*  148 */         while (!this._curr._deep) {
/*      */           
/*  150 */           byte b = 0;
/*      */           
/*  152 */           for (XPath.Step step = this._curr; !step._deep; step = step._prev) {
/*      */             
/*  154 */             if (!step.match(top(b++))) {
/*      */               this._curr = this._curr._prev;
/*      */               continue;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       int start() {
/*  164 */         assert this._curr != null;
/*  165 */         assert this._curr._prev == null;
/*      */         
/*  167 */         if (this._curr._name != null) {
/*  168 */           return this._curr._flags;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  174 */         this._curr = null;
/*      */         
/*  176 */         return 1;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       int element(b param2b) {
/*  182 */         this._prev.add(this._curr);
/*      */         
/*  184 */         if (this._curr == null) {
/*  185 */           return 0;
/*      */         }
/*  187 */         assert this._curr._name != null;
/*      */         
/*  189 */         if (!this._curr._attr && this._curr.match(param2b)) {
/*      */           
/*  191 */           if ((this._curr = this._curr._next)._name != null) {
/*  192 */             return this._curr._flags;
/*      */           }
/*  194 */           backtrack();
/*      */ 
/*      */           
/*  197 */           return (this._curr == null) ? 1 : (0x1 | this._curr._flags);
/*      */         } 
/*      */ 
/*      */         
/*      */         do {
/*  202 */           backtrack();
/*      */           
/*  204 */           if (this._curr == null) {
/*  205 */             return 0;
/*      */           }
/*  207 */           if (this._curr.match(param2b)) {
/*      */             
/*  209 */             this._curr = this._curr._next;
/*      */             
/*      */             break;
/*      */           } 
/*  213 */         } while (!this._curr._deep);
/*      */ 
/*      */ 
/*      */         
/*  217 */         return this._curr._flags;
/*      */       }
/*      */ 
/*      */       
/*      */       boolean attr(b param2b) {
/*  222 */         return (this._curr != null && this._curr._attr && this._curr.match(param2b));
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       void end() {
/*  228 */         this._curr = this._prev.remove(this._prev.size() - 1);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static XPath compileXPath(String paramString) throws XPathCompileException {
/*  247 */     return compileXPath(paramString, "$this", null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static XPath compileXPath(String paramString1, String paramString2) throws XPathCompileException {
/*  253 */     return compileXPath(paramString1, paramString2, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static XPath compileXPath(String paramString, Map paramMap) throws XPathCompileException {
/*  259 */     return compileXPath(paramString, "$this", paramMap);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static XPath compileXPath(String paramString1, String paramString2, Map paramMap) throws XPathCompileException {
/*  266 */     return (new CompilationContext(paramMap, paramString2)).compile(paramString1);
/*      */   }
/*      */   private static class CompilationContext { private String _expr;
/*      */     private boolean _sawDeepDot;
/*      */     private boolean _lastDeepDot;
/*      */     private String _currentNodeVar;
/*      */     protected Map _namespaces;
/*      */     
/*      */     CompilationContext(Map param1Map, String param1String) {
/*  275 */       assert this._currentNodeVar == null || this._currentNodeVar.startsWith("$");
/*      */ 
/*      */ 
/*      */       
/*  279 */       if (param1String == null) {
/*  280 */         this._currentNodeVar = "$this";
/*      */       } else {
/*  282 */         this._currentNodeVar = param1String;
/*      */       } 
/*  284 */       this._namespaces = new HashMap();
/*      */       
/*  286 */       this._externalNamespaces = (param1Map == null) ? new HashMap() : param1Map;
/*      */     }
/*      */     private Map _externalNamespaces;
/*      */     private int _offset;
/*      */     
/*      */     XPath compile(String param1String) throws XPath.XPathCompileException {
/*  292 */       this._offset = 0;
/*  293 */       this._line = 1;
/*  294 */       this._column = 1;
/*  295 */       this._expr = param1String;
/*      */       
/*  297 */       return tokenizeXPath();
/*      */     }
/*      */     private int _line; private int _column; static final boolean $assertionsDisabled;
/*      */     
/*      */     int currChar() {
/*  302 */       return currChar(0);
/*      */     }
/*      */ 
/*      */     
/*      */     int currChar(int param1Int) {
/*  307 */       return (this._offset + param1Int >= this._expr.length()) ? -1 : this._expr.charAt(this._offset + param1Int);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void advance() {
/*  315 */       if (this._offset < this._expr.length()) {
/*      */         
/*  317 */         char c = this._expr.charAt(this._offset);
/*      */         
/*  319 */         this._offset++;
/*  320 */         this._column++;
/*      */         
/*  322 */         if (c == '\r' || c == '\n') {
/*      */           
/*  324 */           this._line++;
/*  325 */           this._column = 1;
/*      */           
/*  327 */           if (this._offset + 1 < this._expr.length()) {
/*      */             
/*  329 */             char c1 = this._expr.charAt(this._offset + 1);
/*      */             
/*  331 */             if ((c1 == '\r' || c1 == '\n') && c != c1) {
/*  332 */               this._offset++;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     void advance(int param1Int) {
/*  340 */       assert param1Int >= 0;
/*      */       
/*  342 */       while (param1Int-- > 0) {
/*  343 */         advance();
/*      */       }
/*      */     }
/*      */     
/*      */     boolean isWhitespace() {
/*  348 */       return isWhitespace(0);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isWhitespace(int param1Int) {
/*  353 */       int i = currChar(param1Int);
/*  354 */       return (i == 32 || i == 9 || i == 10 || i == 13);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isNCNameStart() {
/*  359 */       return (currChar() == -1) ? false : XMLChar.isNCNameStart(currChar());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean isNCName() {
/*  367 */       return (currChar() == -1) ? false : XMLChar.isNCName(currChar());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     boolean startsWith(String param1String) {
/*  375 */       return startsWith(param1String, 0);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean startsWith(String param1String, int param1Int) {
/*  380 */       if (this._offset + param1Int >= this._expr.length()) {
/*  381 */         return false;
/*      */       }
/*  383 */       return this._expr.startsWith(param1String, this._offset + param1Int);
/*      */     }
/*      */ 
/*      */     
/*      */     private XPath.XPathCompileException newError(String param1String) {
/*  388 */       XmlError xmlError = XmlError.forLocation(param1String, 0, null, this._line, this._column, this._offset);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  393 */       return new XPath.XPathCompileException(xmlError);
/*      */     }
/*      */ 
/*      */     
/*      */     String lookupPrefix(String param1String) throws XPath.XPathCompileException {
/*  398 */       if (this._namespaces.containsKey(param1String)) {
/*  399 */         return (String)this._namespaces.get(param1String);
/*      */       }
/*  401 */       if (this._externalNamespaces.containsKey(param1String)) {
/*  402 */         return (String)this._externalNamespaces.get(param1String);
/*      */       }
/*  404 */       if (param1String.equals("xml")) {
/*  405 */         return "http://www.w3.org/XML/1998/namespace";
/*      */       }
/*  407 */       if (param1String.equals("xs")) {
/*  408 */         return "http://www.w3.org/2001/XMLSchema";
/*      */       }
/*  410 */       if (param1String.equals("xsi")) {
/*  411 */         return "http://www.w3.org/2001/XMLSchema-instance";
/*      */       }
/*  413 */       if (param1String.equals("fn")) {
/*  414 */         return "http://www.w3.org/2002/11/xquery-functions";
/*      */       }
/*  416 */       if (param1String.equals("xdt")) {
/*  417 */         return "http://www.w3.org/2003/11/xpath-datatypes";
/*      */       }
/*  419 */       if (param1String.equals("local")) {
/*  420 */         return "http://www.w3.org/2003/11/xquery-local-functions";
/*      */       }
/*  422 */       throw newError("Undefined prefix: " + param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean parseWhitespace() throws XPath.XPathCompileException {
/*  427 */       boolean bool = false;
/*      */       
/*  429 */       while (isWhitespace()) {
/*      */         
/*  431 */         advance();
/*  432 */         bool = true;
/*      */       } 
/*      */       
/*  435 */       return bool;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private boolean tokenize(String param1String) {
/*  446 */       assert param1String.length() > 0;
/*      */       
/*  448 */       int i = 0;
/*      */       
/*  450 */       while (isWhitespace(i)) {
/*  451 */         i++;
/*      */       }
/*  453 */       if (!startsWith(param1String, i)) {
/*  454 */         return false;
/*      */       }
/*  456 */       i += param1String.length();
/*      */       
/*  458 */       advance(i);
/*      */       
/*  460 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean tokenize(String param1String1, String param1String2) {
/*  465 */       assert param1String1.length() > 0;
/*  466 */       assert param1String2.length() > 0;
/*      */       
/*  468 */       int i = 0;
/*      */       
/*  470 */       while (isWhitespace(i)) {
/*  471 */         i++;
/*      */       }
/*  473 */       if (!startsWith(param1String1, i)) {
/*  474 */         return false;
/*      */       }
/*  476 */       i += param1String1.length();
/*      */       
/*  478 */       while (isWhitespace(i)) {
/*  479 */         i++;
/*      */       }
/*  481 */       if (!startsWith(param1String2, i)) {
/*  482 */         return false;
/*      */       }
/*  484 */       i += param1String2.length();
/*      */       
/*  486 */       advance(i);
/*      */       
/*  488 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean tokenize(String param1String1, String param1String2, String param1String3) {
/*  493 */       assert param1String1.length() > 0;
/*  494 */       assert param1String2.length() > 0;
/*  495 */       assert param1String3.length() > 0;
/*      */       
/*  497 */       int i = 0;
/*      */       
/*  499 */       while (isWhitespace(i)) {
/*  500 */         i++;
/*      */       }
/*  502 */       if (!startsWith(param1String1, i)) {
/*  503 */         return false;
/*      */       }
/*  505 */       i += param1String1.length();
/*      */       
/*  507 */       while (isWhitespace(i)) {
/*  508 */         i++;
/*      */       }
/*  510 */       if (!startsWith(param1String2, i)) {
/*  511 */         return false;
/*      */       }
/*  513 */       i += param1String2.length();
/*      */       
/*  515 */       while (isWhitespace(i)) {
/*  516 */         i++;
/*      */       }
/*  518 */       if (!startsWith(param1String3, i)) {
/*  519 */         return false;
/*      */       }
/*  521 */       i += param1String3.length();
/*      */       
/*  523 */       while (isWhitespace(i)) {
/*  524 */         i++;
/*      */       }
/*  526 */       advance(i);
/*      */       
/*  528 */       return true;
/*      */     }
/*      */     private boolean tokenize(String param1String1, String param1String2, String param1String3, String param1String4) {
/*  531 */       assert param1String1.length() > 0;
/*  532 */       assert param1String2.length() > 0;
/*  533 */       assert param1String3.length() > 0;
/*  534 */       assert param1String4.length() > 0;
/*      */       
/*  536 */       int i = 0;
/*      */       
/*  538 */       while (isWhitespace(i)) {
/*  539 */         i++;
/*      */       }
/*  541 */       if (!startsWith(param1String1, i)) {
/*  542 */         return false;
/*      */       }
/*  544 */       i += param1String1.length();
/*      */       
/*  546 */       while (isWhitespace(i)) {
/*  547 */         i++;
/*      */       }
/*  549 */       if (!startsWith(param1String2, i)) {
/*  550 */         return false;
/*      */       }
/*  552 */       i += param1String2.length();
/*      */       
/*  554 */       while (isWhitespace(i)) {
/*  555 */         i++;
/*      */       }
/*  557 */       if (!startsWith(param1String3, i)) {
/*  558 */         return false;
/*      */       }
/*  560 */       i += param1String3.length();
/*      */       
/*  562 */       while (isWhitespace(i)) {
/*  563 */         i++;
/*      */       }
/*  565 */       if (!startsWith(param1String4, i)) {
/*  566 */         return false;
/*      */       }
/*  568 */       i += param1String4.length();
/*      */       
/*  570 */       advance(i);
/*      */       
/*  572 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private String tokenizeNCName() throws XPath.XPathCompileException {
/*  578 */       parseWhitespace();
/*      */       
/*  580 */       if (!isNCNameStart()) {
/*  581 */         throw newError("Expected non-colonized name");
/*      */       }
/*  583 */       StringBuffer stringBuffer = new StringBuffer();
/*      */       
/*  585 */       stringBuffer.append((char)currChar());
/*      */       
/*  587 */       advance(); for (; isNCName(); advance()) {
/*  588 */         stringBuffer.append((char)currChar());
/*      */       }
/*  590 */       return stringBuffer.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     private b getAnyQName() {
/*  595 */       return new b("", "");
/*      */     }
/*      */ 
/*      */     
/*      */     private b tokenizeQName() throws XPath.XPathCompileException {
/*  600 */       if (tokenize("*")) {
/*  601 */         return getAnyQName();
/*      */       }
/*  603 */       String str = tokenizeNCName();
/*      */       
/*  605 */       if (!tokenize(":")) {
/*  606 */         return new b(lookupPrefix(""), str);
/*      */       }
/*  608 */       return new b(lookupPrefix(str), tokenize("*") ? "" : tokenizeNCName());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private String tokenizeQuotedUri() throws XPath.XPathCompileException {
/*      */       byte b;
/*  618 */       if (tokenize("\"")) {
/*  619 */         b = 34;
/*  620 */       } else if (tokenize("'")) {
/*  621 */         b = 39;
/*      */       } else {
/*  623 */         throw newError("Expected quote (\" or ')");
/*      */       } 
/*  625 */       StringBuffer stringBuffer = new StringBuffer();
/*      */ 
/*      */       
/*      */       while (true) {
/*  629 */         if (currChar() == -1) {
/*  630 */           throw newError("Path terminated in URI literal");
/*      */         }
/*  632 */         if (currChar() == b) {
/*      */           
/*  634 */           advance();
/*      */           
/*  636 */           if (currChar() != b) {
/*      */             break;
/*      */           }
/*      */         } 
/*  640 */         stringBuffer.append((char)currChar());
/*      */         
/*  642 */         advance();
/*      */       } 
/*      */       
/*  645 */       return stringBuffer.toString();
/*      */     }
/*      */ 
/*      */     
/*      */     private XPath.Step addStep(boolean param1Boolean1, boolean param1Boolean2, b param1b, XPath.Step param1Step) {
/*  650 */       XPath.Step step1 = new XPath.Step(param1Boolean1, param1Boolean2, param1b);
/*      */       
/*  652 */       if (param1Step == null) {
/*  653 */         return step1;
/*      */       }
/*  655 */       XPath.Step step2 = param1Step;
/*      */       
/*  657 */       while (param1Step._next != null) {
/*  658 */         param1Step = param1Step._next;
/*      */       }
/*  660 */       param1Step._next = step1;
/*  661 */       step1._prev = param1Step;
/*      */       
/*  663 */       return step2;
/*      */     }
/*      */     
/*      */     private XPath.Step tokenizeSteps() throws XPath.XPathCompileException {
/*      */       boolean bool1;
/*  668 */       if (tokenize("/")) {
/*  669 */         throw newError("Absolute paths unsupported");
/*      */       }
/*      */ 
/*      */       
/*  673 */       if (tokenize("$", this._currentNodeVar, "//") || tokenize(".", "//"))
/*  674 */       { bool1 = true; }
/*  675 */       else if (tokenize("$", this._currentNodeVar, "/") || tokenize(".", "/"))
/*  676 */       { bool1 = false; }
/*  677 */       else { if (tokenize("$", this._currentNodeVar) || tokenize(".")) {
/*  678 */           return addStep(false, false, null, null);
/*      */         }
/*  680 */         bool1 = false; }
/*      */       
/*  682 */       XPath.Step step = null;
/*      */ 
/*      */ 
/*      */       
/*  686 */       boolean bool2 = false;
/*      */ 
/*      */       
/*      */       while (true) {
/*  690 */         if (tokenize("attribute", "::") || tokenize("@")) {
/*      */           
/*  692 */           step = addStep(bool1, true, tokenizeQName(), step);
/*      */ 
/*      */           
/*      */           break;
/*      */         } 
/*      */         
/*  698 */         if (tokenize(".")) {
/*  699 */           bool2 = (bool2 || bool1) ? true : false;
/*      */         } else {
/*      */           
/*  702 */           tokenize("child", "::"); b b;
/*  703 */           if ((b = tokenizeQName()) != null) {
/*      */             
/*  705 */             step = addStep(bool1, false, b, step);
/*  706 */             bool1 = false;
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  711 */         if (tokenize("//")) {
/*      */           
/*  713 */           bool1 = true;
/*  714 */           bool2 = false; continue;
/*      */         } 
/*  716 */         if (tokenize("/")) {
/*      */           
/*  718 */           if (bool2) {
/*  719 */             bool1 = true;
/*      */           }
/*      */           
/*      */           continue;
/*      */         } 
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/*  728 */       if (this._lastDeepDot = bool2) {
/*      */         
/*  730 */         this._lastDeepDot = true;
/*  731 */         step = addStep(true, false, getAnyQName(), step);
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  736 */       return addStep(false, false, null, step);
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
/*      */ 
/*      */     
/*      */     private void computeBacktrack(XPath.Step param1Step) throws XPath.XPathCompileException {
/*  751 */       for (XPath.Step step = param1Step; step != null; step = step1) {
/*      */         XPath.Step step1;
/*      */ 
/*      */         
/*  755 */         for (step1 = step._next; step1 != null && !step1._deep;) {
/*  756 */           step1 = step1._next;
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  762 */         if (!step._deep) {
/*      */           
/*  764 */           for (XPath.Step step2 = step; step2 != step1; step2 = step2._next) {
/*  765 */             step2._hasBacktrack = true;
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */ 
/*      */           
/*  773 */           byte b1 = 0;
/*  774 */           XPath.Step step2 = step;
/*      */           
/*  776 */           while (step2 != step1 && step2._name != null && !step2.isWild() && !step2._attr) {
/*      */             
/*  778 */             b1++;
/*  779 */             step2 = step2._next;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  784 */           b[] arrayOfB = new b[b1 + 1];
/*  785 */           int[] arrayOfInt = new int[b1 + 1];
/*      */           
/*  787 */           XPath.Step step3 = step;
/*      */           byte b2;
/*  789 */           for (b2 = 0; b2 < b1; b2++) {
/*      */             
/*  791 */             arrayOfB[b2] = step3._name;
/*  792 */             step3 = step3._next;
/*      */           } 
/*      */           
/*  795 */           arrayOfB[b1] = getAnyQName();
/*      */           
/*  797 */           b2 = 0;
/*  798 */           int i = arrayOfInt[0] = -1;
/*      */           
/*  800 */           while (b2 < b1) {
/*      */             
/*  802 */             while (i > -1 && !arrayOfB[b2].equals(arrayOfB[i])) {
/*  803 */               i = arrayOfInt[i];
/*      */             }
/*  805 */             if (arrayOfB[++b2].equals(arrayOfB[++i])) {
/*  806 */               arrayOfInt[b2] = arrayOfInt[i]; continue;
/*      */             } 
/*  808 */             arrayOfInt[b2] = i;
/*      */           } 
/*      */           
/*  811 */           b2 = 0;
/*      */           
/*  813 */           for (step3 = step; step3 != step2; step3 = step3._next) {
/*      */             
/*  815 */             step3._hasBacktrack = true;
/*  816 */             step3._backtrack = step;
/*      */             
/*  818 */             for (i = arrayOfInt[b2]; i > 0; i--) {
/*  819 */               step3._backtrack = step3._backtrack._next;
/*      */             }
/*  821 */             b2++;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  827 */           step3 = step;
/*      */           
/*  829 */           if (b1 > 1)
/*      */           {
/*  831 */             for (i = arrayOfInt[b1 - 1]; i > 0; i--) {
/*  832 */               step3 = step3._next;
/*      */             }
/*      */           }
/*  835 */           if (step2 != step1 && step2._attr) {
/*      */             
/*  837 */             step2._hasBacktrack = true;
/*  838 */             step2._backtrack = step3;
/*  839 */             step2 = step2._next;
/*      */           } 
/*      */           
/*  842 */           if (step2 != step1 && step2._name == null) {
/*      */             
/*  844 */             step2._hasBacktrack = true;
/*  845 */             step2._backtrack = step3;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  850 */           assert step._deep;
/*      */           
/*  852 */           step._hasBacktrack = true;
/*  853 */           step._backtrack = step;
/*      */         } 
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private void tokenizePath(ArrayList param1ArrayList) throws XPath.XPathCompileException {
/*  860 */       this._lastDeepDot = false;
/*      */       
/*  862 */       XPath.Step step = tokenizeSteps();
/*      */       
/*  864 */       computeBacktrack(step);
/*      */       
/*  866 */       param1ArrayList.add(step);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  871 */       if (this._lastDeepDot) {
/*      */         
/*  873 */         this._sawDeepDot = true;
/*      */         
/*  875 */         XPath.Step step1 = null;
/*      */         
/*  877 */         for (XPath.Step step2 = step; step2 != null; step2 = step2._next) {
/*      */           
/*  879 */           if (step2._next != null && step2._next._next == null) {
/*  880 */             step1 = addStep(step2._deep, true, step2._name, step1);
/*      */           } else {
/*  882 */             step1 = addStep(step2._deep, step2._attr, step2._name, step1);
/*      */           } 
/*      */         } 
/*  885 */         computeBacktrack(step1);
/*      */         
/*  887 */         param1ArrayList.add(step1);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     private XPath.Selector tokenizeSelector() throws XPath.XPathCompileException {
/*  893 */       ArrayList arrayList = new ArrayList();
/*      */       
/*  895 */       tokenizePath(arrayList);
/*      */       
/*  897 */       while (tokenize("|")) {
/*  898 */         tokenizePath(arrayList);
/*      */       }
/*  900 */       return new XPath.Selector((XPath.Step[])arrayList.toArray((Object[])new XPath.Step[0]));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private XPath tokenizeXPath() throws XPath.XPathCompileException {
/*      */       while (true) {
/*  907 */         while (tokenize("declare", "namespace")) {
/*      */           
/*  909 */           if (!parseWhitespace()) {
/*  910 */             throw newError("Expected prefix after 'declare namespace'");
/*      */           }
/*  912 */           String str1 = tokenizeNCName();
/*      */           
/*  914 */           if (!tokenize("=")) {
/*  915 */             throw newError("Expected '='");
/*      */           }
/*  917 */           String str2 = tokenizeQuotedUri();
/*      */           
/*  919 */           if (this._namespaces.containsKey(str1))
/*      */           {
/*  921 */             throw newError("Redefinition of namespace prefix: " + str1);
/*      */           }
/*      */ 
/*      */           
/*  925 */           this._namespaces.put(str1, str2);
/*      */ 
/*      */ 
/*      */           
/*  929 */           if (this._externalNamespaces.containsKey(str1))
/*      */           {
/*  931 */             throw newError("Redefinition of namespace prefix: " + str1);
/*      */           }
/*      */           
/*  934 */           this._externalNamespaces.put(str1, str2);
/*      */           
/*  936 */           if (!tokenize(";"));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  942 */           this._externalNamespaces.put("$xmlbeans!ns_boundary", new Integer(this._offset));
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  947 */         if (tokenize("declare", "default", "element", "namespace")) {
/*      */           
/*  949 */           String str = tokenizeQuotedUri();
/*      */           
/*  951 */           if (this._namespaces.containsKey(""))
/*      */           {
/*  953 */             throw newError("Redefinition of default element namespace");
/*      */           }
/*      */ 
/*      */           
/*  957 */           this._namespaces.put("", str);
/*      */ 
/*      */ 
/*      */           
/*  961 */           if (this._externalNamespaces.containsKey("$xmlbeans!default_uri"))
/*      */           {
/*  963 */             throw newError("Redefinition of default element namespace : ");
/*      */           }
/*  965 */           this._externalNamespaces.put("$xmlbeans!default_uri", str);
/*      */           
/*  967 */           if (!tokenize(";")) {
/*  968 */             throw newError("Default Namespace declaration must end with ;");
/*      */           }
/*  970 */           this._externalNamespaces.put("$xmlbeans!ns_boundary", new Integer(this._offset));
/*      */ 
/*      */           
/*      */           continue;
/*      */         } 
/*      */ 
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/*  980 */       if (!this._namespaces.containsKey("")) {
/*  981 */         this._namespaces.put("", "");
/*      */       }
/*  983 */       XPath.Selector selector = tokenizeSelector();
/*      */       
/*  985 */       parseWhitespace();
/*      */       
/*  987 */       if (currChar() != -1)
/*      */       {
/*  989 */         throw newError("Unexpected char '" + (char)currChar() + "'");
/*      */       }
/*      */ 
/*      */       
/*  993 */       return new XPath(selector, this._sawDeepDot);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private void processNonXpathDecls() {} }
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Step
/*      */   {
/*      */     final boolean _attr;
/*      */     
/*      */     final boolean _deep;
/*      */     
/*      */     int _flags;
/*      */     
/*      */     final b _name;
/*      */     
/*      */     Step _next;
/*      */     
/*      */     Step _prev;
/*      */     
/*      */     boolean _hasBacktrack;
/*      */     
/*      */     Step _backtrack;
/*      */ 
/*      */     
/*      */     Step(boolean param1Boolean1, boolean param1Boolean2, b param1b) {
/* 1022 */       this._name = param1b;
/*      */       
/* 1024 */       this._deep = param1Boolean1;
/* 1025 */       this._attr = param1Boolean2;
/*      */       
/* 1027 */       int i = 0;
/*      */       
/* 1029 */       if (this._deep || !this._attr) {
/* 1030 */         i |= 0x2;
/*      */       }
/* 1032 */       if (this._attr) {
/* 1033 */         i |= 0x4;
/*      */       }
/* 1035 */       this._flags = i;
/*      */     }
/*      */ 
/*      */     
/*      */     boolean isWild() {
/* 1040 */       return (this._name.dT().length() == 0);
/*      */     }
/*      */ 
/*      */     
/*      */     boolean match(b param1b) {
/* 1045 */       String str1 = this._name.dT();
/* 1046 */       String str2 = param1b.dT();
/*      */ 
/*      */ 
/*      */       
/* 1050 */       int i = str1.length();
/*      */ 
/*      */ 
/*      */       
/* 1054 */       if (i == 0) {
/*      */         
/* 1056 */         String str = this._name.getNamespaceURI();
/* 1057 */         int j = str.length();
/*      */         
/* 1059 */         if (j == 0) {
/* 1060 */           return true;
/*      */         }
/* 1062 */         return str.equals(param1b.getNamespaceURI());
/*      */       } 
/*      */       
/* 1065 */       if (i != str2.length()) {
/* 1066 */         return false;
/*      */       }
/* 1068 */       String str3 = this._name.getNamespaceURI();
/* 1069 */       String str4 = param1b.getNamespaceURI();
/*      */       
/* 1071 */       if (str3.length() != str4.length()) {
/* 1072 */         return false;
/*      */       }
/* 1074 */       return (str1.equals(str2) && str3.equals(str4));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class Selector
/*      */   {
/*      */     final XPath.Step[] _paths;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     Selector(XPath.Step[] param1ArrayOfStep) {
/* 1094 */       this._paths = param1ArrayOfStep;
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
/*      */   private XPath(Selector paramSelector, boolean paramBoolean) {
/* 1106 */     this._selector = paramSelector;
/* 1107 */     this._sawDeepDot = paramBoolean;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean sawDeepDot() {
/* 1112 */     return this._sawDeepDot;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\XPath.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */