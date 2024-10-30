/*     */ package org.jsoup.parser;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import org.jsoup.helper.DescendableLinkedList;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Comment;
/*     */ import org.jsoup.nodes.DataNode;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.FormElement;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.select.Elements;
/*     */ 
/*     */ class HtmlTreeBuilder extends TreeBuilder {
/*  19 */   private static final String[] TagsScriptStyle = new String[] { "script", "style" };
/*  20 */   public static final String[] TagsSearchInScope = new String[] { "applet", "caption", "html", "table", "td", "th", "marquee", "object" };
/*  21 */   private static final String[] TagSearchList = new String[] { "ol", "ul" };
/*  22 */   private static final String[] TagSearchButton = new String[] { "button" };
/*  23 */   private static final String[] TagSearchTableScope = new String[] { "html", "table" };
/*  24 */   private static final String[] TagSearchSelectScope = new String[] { "optgroup", "option" };
/*  25 */   private static final String[] TagSearchEndTags = new String[] { "dd", "dt", "li", "option", "optgroup", "p", "rp", "rt" };
/*  26 */   private static final String[] TagSearchSpecial = new String[] { "address", "applet", "area", "article", "aside", "base", "basefont", "bgsound", "blockquote", "body", "br", "button", "caption", "center", "col", "colgroup", "command", "dd", "details", "dir", "div", "dl", "dt", "embed", "fieldset", "figcaption", "figure", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "iframe", "img", "input", "isindex", "li", "link", "listing", "marquee", "menu", "meta", "nav", "noembed", "noframes", "noscript", "object", "ol", "p", "param", "plaintext", "pre", "script", "section", "select", "style", "summary", "table", "tbody", "td", "textarea", "tfoot", "th", "thead", "title", "tr", "ul", "wbr", "xmp" };
/*     */ 
/*     */   
/*     */   private HtmlTreeBuilderState state;
/*     */ 
/*     */   
/*     */   private HtmlTreeBuilderState originalState;
/*     */   
/*     */   private boolean baseUriSetFromDoc = false;
/*     */   
/*     */   private Element headElement;
/*     */   
/*     */   private FormElement formElement;
/*     */   
/*     */   private Element contextElement;
/*     */   
/*  42 */   private DescendableLinkedList<Element> formattingElements = new DescendableLinkedList();
/*  43 */   private List<Token.Character> pendingTableCharacters = new ArrayList<Token.Character>();
/*     */   
/*     */   private boolean framesetOk = true;
/*     */   
/*     */   private boolean fosterInserts = false;
/*     */   
/*     */   private boolean fragmentParsing = false;
/*     */ 
/*     */   
/*     */   Document parse(String paramString1, String paramString2, ParseErrorList paramParseErrorList) {
/*  53 */     this.state = HtmlTreeBuilderState.Initial;
/*  54 */     this.baseUriSetFromDoc = false;
/*  55 */     return super.parse(paramString1, paramString2, paramParseErrorList);
/*     */   }
/*     */ 
/*     */   
/*     */   List<Node> parseFragment(String paramString1, Element paramElement, String paramString2, ParseErrorList paramParseErrorList) {
/*  60 */     this.state = HtmlTreeBuilderState.Initial;
/*  61 */     initialiseParse(paramString1, paramString2, paramParseErrorList);
/*  62 */     this.contextElement = paramElement;
/*  63 */     this.fragmentParsing = true;
/*  64 */     Element element = null;
/*     */     
/*  66 */     if (paramElement != null) {
/*  67 */       if (paramElement.ownerDocument() != null) {
/*  68 */         this.doc.quirksMode(paramElement.ownerDocument().quirksMode());
/*     */       }
/*     */       
/*  71 */       String str = paramElement.tagName();
/*  72 */       if (StringUtil.in(str, new String[] { "title", "textarea" })) {
/*  73 */         this.tokeniser.transition(TokeniserState.Rcdata);
/*  74 */       } else if (StringUtil.in(str, new String[] { "iframe", "noembed", "noframes", "style", "xmp" })) {
/*  75 */         this.tokeniser.transition(TokeniserState.Rawtext);
/*  76 */       } else if (str.equals("script")) {
/*  77 */         this.tokeniser.transition(TokeniserState.ScriptData);
/*  78 */       } else if (str.equals("noscript")) {
/*  79 */         this.tokeniser.transition(TokeniserState.Data);
/*  80 */       } else if (str.equals("plaintext")) {
/*  81 */         this.tokeniser.transition(TokeniserState.Data);
/*     */       } else {
/*  83 */         this.tokeniser.transition(TokeniserState.Data);
/*     */       } 
/*  85 */       element = new Element(Tag.valueOf("html"), paramString2);
/*  86 */       this.doc.appendChild((Node)element);
/*  87 */       this.stack.push(element);
/*  88 */       resetInsertionMode();
/*     */ 
/*     */ 
/*     */       
/*  92 */       Elements elements = paramElement.parents();
/*  93 */       elements.add(0, paramElement);
/*  94 */       for (Element element1 : elements) {
/*  95 */         if (element1 instanceof FormElement) {
/*  96 */           this.formElement = (FormElement)element1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 102 */     runParser();
/* 103 */     if (paramElement != null) {
/* 104 */       return element.childNodes();
/*     */     }
/* 106 */     return this.doc.childNodes();
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean process(Token paramToken) {
/* 111 */     this.currentToken = paramToken;
/* 112 */     return this.state.process(paramToken, this);
/*     */   }
/*     */   
/*     */   boolean process(Token paramToken, HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/* 116 */     this.currentToken = paramToken;
/* 117 */     return paramHtmlTreeBuilderState.process(paramToken, this);
/*     */   }
/*     */   
/*     */   void transition(HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/* 121 */     this.state = paramHtmlTreeBuilderState;
/*     */   }
/*     */   
/*     */   HtmlTreeBuilderState state() {
/* 125 */     return this.state;
/*     */   }
/*     */   
/*     */   void markInsertionMode() {
/* 129 */     this.originalState = this.state;
/*     */   }
/*     */   
/*     */   HtmlTreeBuilderState originalState() {
/* 133 */     return this.originalState;
/*     */   }
/*     */   
/*     */   void framesetOk(boolean paramBoolean) {
/* 137 */     this.framesetOk = paramBoolean;
/*     */   }
/*     */   
/*     */   boolean framesetOk() {
/* 141 */     return this.framesetOk;
/*     */   }
/*     */   
/*     */   Document getDocument() {
/* 145 */     return this.doc;
/*     */   }
/*     */   
/*     */   String getBaseUri() {
/* 149 */     return this.baseUri;
/*     */   }
/*     */   
/*     */   void maybeSetBaseUri(Element paramElement) {
/* 153 */     if (this.baseUriSetFromDoc) {
/*     */       return;
/*     */     }
/* 156 */     String str = paramElement.absUrl("href");
/* 157 */     if (str.length() != 0) {
/* 158 */       this.baseUri = str;
/* 159 */       this.baseUriSetFromDoc = true;
/* 160 */       this.doc.setBaseUri(str);
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean isFragmentParsing() {
/* 165 */     return this.fragmentParsing;
/*     */   }
/*     */   
/*     */   void error(HtmlTreeBuilderState paramHtmlTreeBuilderState) {
/* 169 */     if (this.errors.canAddError()) {
/* 170 */       this.errors.add(new ParseError(this.reader.pos(), "Unexpected token [%s] when in state [%s]", new Object[] { this.currentToken.tokenType(), paramHtmlTreeBuilderState }));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Element insert(Token.StartTag paramStartTag) {
/* 176 */     if (paramStartTag.isSelfClosing()) {
/* 177 */       Element element1 = insertEmpty(paramStartTag);
/* 178 */       this.stack.add(element1);
/* 179 */       this.tokeniser.transition(TokeniserState.Data);
/* 180 */       this.tokeniser.emit(new Token.EndTag(element1.tagName()));
/* 181 */       return element1;
/*     */     } 
/*     */     
/* 184 */     Element element = new Element(Tag.valueOf(paramStartTag.name()), this.baseUri, paramStartTag.attributes);
/* 185 */     insert(element);
/* 186 */     return element;
/*     */   }
/*     */   
/*     */   Element insert(String paramString) {
/* 190 */     Element element = new Element(Tag.valueOf(paramString), this.baseUri);
/* 191 */     insert(element);
/* 192 */     return element;
/*     */   }
/*     */   
/*     */   void insert(Element paramElement) {
/* 196 */     insertNode((Node)paramElement);
/* 197 */     this.stack.add(paramElement);
/*     */   }
/*     */   
/*     */   Element insertEmpty(Token.StartTag paramStartTag) {
/* 201 */     Tag tag = Tag.valueOf(paramStartTag.name());
/* 202 */     Element element = new Element(tag, this.baseUri, paramStartTag.attributes);
/* 203 */     insertNode((Node)element);
/* 204 */     if (paramStartTag.isSelfClosing()) {
/* 205 */       if (tag.isKnownTag()) {
/* 206 */         if (tag.isSelfClosing()) this.tokeniser.acknowledgeSelfClosingFlag();
/*     */       
/*     */       } else {
/* 209 */         tag.setSelfClosing();
/* 210 */         this.tokeniser.acknowledgeSelfClosingFlag();
/*     */       } 
/*     */     }
/* 213 */     return element;
/*     */   }
/*     */   
/*     */   FormElement insertForm(Token.StartTag paramStartTag, boolean paramBoolean) {
/* 217 */     Tag tag = Tag.valueOf(paramStartTag.name());
/* 218 */     FormElement formElement = new FormElement(tag, this.baseUri, paramStartTag.attributes);
/* 219 */     setFormElement(formElement);
/* 220 */     insertNode((Node)formElement);
/* 221 */     if (paramBoolean)
/* 222 */       this.stack.add(formElement); 
/* 223 */     return formElement;
/*     */   }
/*     */   
/*     */   void insert(Token.Comment paramComment) {
/* 227 */     Comment comment = new Comment(paramComment.getData(), this.baseUri);
/* 228 */     insertNode((Node)comment);
/*     */   }
/*     */ 
/*     */   
/*     */   void insert(Token.Character paramCharacter) {
/*     */     TextNode textNode;
/* 234 */     String str = currentElement().tagName();
/* 235 */     if (str.equals("script") || str.equals("style")) {
/* 236 */       DataNode dataNode = new DataNode(paramCharacter.getData(), this.baseUri);
/*     */     } else {
/* 238 */       textNode = new TextNode(paramCharacter.getData(), this.baseUri);
/* 239 */     }  currentElement().appendChild((Node)textNode);
/*     */   }
/*     */ 
/*     */   
/*     */   private void insertNode(Node paramNode) {
/* 244 */     if (this.stack.size() == 0) {
/* 245 */       this.doc.appendChild(paramNode);
/* 246 */     } else if (isFosterInserts()) {
/* 247 */       insertInFosterParent(paramNode);
/*     */     } else {
/* 249 */       currentElement().appendChild(paramNode);
/*     */     } 
/*     */     
/* 252 */     if (paramNode instanceof Element && ((Element)paramNode).tag().isFormListed() && 
/* 253 */       this.formElement != null) {
/* 254 */       this.formElement.addElement((Element)paramNode);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   Element pop() {
/* 260 */     if (((Element)this.stack.peekLast()).nodeName().equals("td") && !this.state.name().equals("InCell"))
/* 261 */       Validate.isFalse(true, "pop td not in cell"); 
/* 262 */     if (((Element)this.stack.peekLast()).nodeName().equals("html"))
/* 263 */       Validate.isFalse(true, "popping html!"); 
/* 264 */     return (Element)this.stack.pollLast();
/*     */   }
/*     */   
/*     */   void push(Element paramElement) {
/* 268 */     this.stack.add(paramElement);
/*     */   }
/*     */   
/*     */   DescendableLinkedList<Element> getStack() {
/* 272 */     return this.stack;
/*     */   }
/*     */   
/*     */   boolean onStack(Element paramElement) {
/* 276 */     return isElementInQueue(this.stack, paramElement);
/*     */   }
/*     */   
/*     */   private boolean isElementInQueue(DescendableLinkedList<Element> paramDescendableLinkedList, Element paramElement) {
/* 280 */     Iterator<Element> iterator = paramDescendableLinkedList.descendingIterator();
/* 281 */     while (iterator.hasNext()) {
/* 282 */       Element element = iterator.next();
/* 283 */       if (element == paramElement) {
/* 284 */         return true;
/*     */       }
/*     */     } 
/* 287 */     return false;
/*     */   }
/*     */   
/*     */   Element getFromStack(String paramString) {
/* 291 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 292 */     while (iterator.hasNext()) {
/* 293 */       Element element = iterator.next();
/* 294 */       if (element.nodeName().equals(paramString)) {
/* 295 */         return element;
/*     */       }
/*     */     } 
/* 298 */     return null;
/*     */   }
/*     */   
/*     */   boolean removeFromStack(Element paramElement) {
/* 302 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 303 */     while (iterator.hasNext()) {
/* 304 */       Element element = iterator.next();
/* 305 */       if (element == paramElement) {
/* 306 */         iterator.remove();
/* 307 */         return true;
/*     */       } 
/*     */     } 
/* 310 */     return false;
/*     */   }
/*     */   
/*     */   void popStackToClose(String paramString) {
/* 314 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 315 */     while (iterator.hasNext()) {
/* 316 */       Element element = iterator.next();
/* 317 */       if (element.nodeName().equals(paramString)) {
/* 318 */         iterator.remove();
/*     */         break;
/*     */       } 
/* 321 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void popStackToClose(String... paramVarArgs) {
/* 327 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 328 */     while (iterator.hasNext()) {
/* 329 */       Element element = iterator.next();
/* 330 */       if (StringUtil.in(element.nodeName(), paramVarArgs)) {
/* 331 */         iterator.remove();
/*     */         break;
/*     */       } 
/* 334 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void popStackToBefore(String paramString) {
/* 340 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 341 */     while (iterator.hasNext()) {
/* 342 */       Element element = iterator.next();
/* 343 */       if (element.nodeName().equals(paramString)) {
/*     */         break;
/*     */       }
/* 346 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void clearStackToTableContext() {
/* 352 */     clearStackToContext(new String[] { "table" });
/*     */   }
/*     */   
/*     */   void clearStackToTableBodyContext() {
/* 356 */     clearStackToContext(new String[] { "tbody", "tfoot", "thead" });
/*     */   }
/*     */   
/*     */   void clearStackToTableRowContext() {
/* 360 */     clearStackToContext(new String[] { "tr" });
/*     */   }
/*     */   
/*     */   private void clearStackToContext(String... paramVarArgs) {
/* 364 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 365 */     while (iterator.hasNext()) {
/* 366 */       Element element = iterator.next();
/* 367 */       if (StringUtil.in(element.nodeName(), paramVarArgs) || element.nodeName().equals("html")) {
/*     */         break;
/*     */       }
/* 370 */       iterator.remove();
/*     */     } 
/*     */   }
/*     */   
/*     */   Element aboveOnStack(Element paramElement) {
/* 375 */     assert onStack(paramElement);
/* 376 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 377 */     while (iterator.hasNext()) {
/* 378 */       Element element = iterator.next();
/* 379 */       if (element == paramElement) {
/* 380 */         return iterator.next();
/*     */       }
/*     */     } 
/* 383 */     return null;
/*     */   }
/*     */   
/*     */   void insertOnStackAfter(Element paramElement1, Element paramElement2) {
/* 387 */     int i = this.stack.lastIndexOf(paramElement1);
/* 388 */     Validate.isTrue((i != -1));
/* 389 */     this.stack.add(i + 1, paramElement2);
/*     */   }
/*     */   
/*     */   void replaceOnStack(Element paramElement1, Element paramElement2) {
/* 393 */     replaceInQueue((LinkedList<Element>)this.stack, paramElement1, paramElement2);
/*     */   }
/*     */   
/*     */   private void replaceInQueue(LinkedList<Element> paramLinkedList, Element paramElement1, Element paramElement2) {
/* 397 */     int i = paramLinkedList.lastIndexOf(paramElement1);
/* 398 */     Validate.isTrue((i != -1));
/* 399 */     paramLinkedList.remove(i);
/* 400 */     paramLinkedList.add(i, paramElement2);
/*     */   }
/*     */   
/*     */   void resetInsertionMode() {
/* 404 */     boolean bool = false;
/* 405 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 406 */     while (iterator.hasNext()) {
/* 407 */       Element element = iterator.next();
/* 408 */       if (!iterator.hasNext()) {
/* 409 */         bool = true;
/* 410 */         element = this.contextElement;
/*     */       } 
/* 412 */       String str = element.nodeName();
/* 413 */       if ("select".equals(str)) {
/* 414 */         transition(HtmlTreeBuilderState.InSelect); break;
/*     */       } 
/* 416 */       if ("td".equals(str) || ("td".equals(str) && !bool)) {
/* 417 */         transition(HtmlTreeBuilderState.InCell); break;
/*     */       } 
/* 419 */       if ("tr".equals(str)) {
/* 420 */         transition(HtmlTreeBuilderState.InRow); break;
/*     */       } 
/* 422 */       if ("tbody".equals(str) || "thead".equals(str) || "tfoot".equals(str)) {
/* 423 */         transition(HtmlTreeBuilderState.InTableBody); break;
/*     */       } 
/* 425 */       if ("caption".equals(str)) {
/* 426 */         transition(HtmlTreeBuilderState.InCaption); break;
/*     */       } 
/* 428 */       if ("colgroup".equals(str)) {
/* 429 */         transition(HtmlTreeBuilderState.InColumnGroup); break;
/*     */       } 
/* 431 */       if ("table".equals(str)) {
/* 432 */         transition(HtmlTreeBuilderState.InTable); break;
/*     */       } 
/* 434 */       if ("head".equals(str)) {
/* 435 */         transition(HtmlTreeBuilderState.InBody); break;
/*     */       } 
/* 437 */       if ("body".equals(str)) {
/* 438 */         transition(HtmlTreeBuilderState.InBody); break;
/*     */       } 
/* 440 */       if ("frameset".equals(str)) {
/* 441 */         transition(HtmlTreeBuilderState.InFrameset); break;
/*     */       } 
/* 443 */       if ("html".equals(str)) {
/* 444 */         transition(HtmlTreeBuilderState.BeforeHead); break;
/*     */       } 
/* 446 */       if (bool) {
/* 447 */         transition(HtmlTreeBuilderState.InBody);
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean inSpecificScope(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2) {
/* 455 */     return inSpecificScope(new String[] { paramString }, paramArrayOfString1, paramArrayOfString2);
/*     */   }
/*     */   
/*     */   private boolean inSpecificScope(String[] paramArrayOfString1, String[] paramArrayOfString2, String[] paramArrayOfString3) {
/* 459 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 460 */     while (iterator.hasNext()) {
/* 461 */       Element element = iterator.next();
/* 462 */       String str = element.nodeName();
/* 463 */       if (StringUtil.in(str, paramArrayOfString1))
/* 464 */         return true; 
/* 465 */       if (StringUtil.in(str, paramArrayOfString2))
/* 466 */         return false; 
/* 467 */       if (paramArrayOfString3 != null && StringUtil.in(str, paramArrayOfString3))
/* 468 */         return false; 
/*     */     } 
/* 470 */     Validate.fail("Should not be reachable");
/* 471 */     return false;
/*     */   }
/*     */   
/*     */   boolean inScope(String[] paramArrayOfString) {
/* 475 */     return inSpecificScope(paramArrayOfString, TagsSearchInScope, (String[])null);
/*     */   }
/*     */   
/*     */   boolean inScope(String paramString) {
/* 479 */     return inScope(paramString, (String[])null);
/*     */   }
/*     */   
/*     */   boolean inScope(String paramString, String[] paramArrayOfString) {
/* 483 */     return inSpecificScope(paramString, TagsSearchInScope, paramArrayOfString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean inListItemScope(String paramString) {
/* 489 */     return inScope(paramString, TagSearchList);
/*     */   }
/*     */   
/*     */   boolean inButtonScope(String paramString) {
/* 493 */     return inScope(paramString, TagSearchButton);
/*     */   }
/*     */   
/*     */   boolean inTableScope(String paramString) {
/* 497 */     return inSpecificScope(paramString, TagSearchTableScope, (String[])null);
/*     */   }
/*     */   
/*     */   boolean inSelectScope(String paramString) {
/* 501 */     Iterator<Element> iterator = this.stack.descendingIterator();
/* 502 */     while (iterator.hasNext()) {
/* 503 */       Element element = iterator.next();
/* 504 */       String str = element.nodeName();
/* 505 */       if (str.equals(paramString))
/* 506 */         return true; 
/* 507 */       if (!StringUtil.in(str, TagSearchSelectScope))
/* 508 */         return false; 
/*     */     } 
/* 510 */     Validate.fail("Should not be reachable");
/* 511 */     return false;
/*     */   }
/*     */   
/*     */   void setHeadElement(Element paramElement) {
/* 515 */     this.headElement = paramElement;
/*     */   }
/*     */   
/*     */   Element getHeadElement() {
/* 519 */     return this.headElement;
/*     */   }
/*     */   
/*     */   boolean isFosterInserts() {
/* 523 */     return this.fosterInserts;
/*     */   }
/*     */   
/*     */   void setFosterInserts(boolean paramBoolean) {
/* 527 */     this.fosterInserts = paramBoolean;
/*     */   }
/*     */   
/*     */   FormElement getFormElement() {
/* 531 */     return this.formElement;
/*     */   }
/*     */   
/*     */   void setFormElement(FormElement paramFormElement) {
/* 535 */     this.formElement = paramFormElement;
/*     */   }
/*     */   
/*     */   void newPendingTableCharacters() {
/* 539 */     this.pendingTableCharacters = new ArrayList<Token.Character>();
/*     */   }
/*     */   
/*     */   List<Token.Character> getPendingTableCharacters() {
/* 543 */     return this.pendingTableCharacters;
/*     */   }
/*     */   
/*     */   void setPendingTableCharacters(List<Token.Character> paramList) {
/* 547 */     this.pendingTableCharacters = paramList;
/*     */   }
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
/*     */   void generateImpliedEndTags(String paramString) {
/* 560 */     while (paramString != null && !currentElement().nodeName().equals(paramString) && StringUtil.in(currentElement().nodeName(), TagSearchEndTags))
/*     */     {
/* 562 */       pop(); } 
/*     */   }
/*     */   
/*     */   void generateImpliedEndTags() {
/* 566 */     generateImpliedEndTags((String)null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   boolean isSpecial(Element paramElement) {
/* 572 */     String str = paramElement.nodeName();
/* 573 */     return StringUtil.in(str, TagSearchSpecial);
/*     */   }
/*     */ 
/*     */   
/*     */   void pushActiveFormattingElements(Element paramElement) {
/* 578 */     byte b = 0;
/* 579 */     Iterator<Element> iterator = this.formattingElements.descendingIterator();
/* 580 */     while (iterator.hasNext()) {
/* 581 */       Element element = iterator.next();
/* 582 */       if (element == null) {
/*     */         break;
/*     */       }
/* 585 */       if (isSameFormattingElement(paramElement, element)) {
/* 586 */         b++;
/*     */       }
/* 588 */       if (b == 3) {
/* 589 */         iterator.remove();
/*     */         break;
/*     */       } 
/*     */     } 
/* 593 */     this.formattingElements.add(paramElement);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean isSameFormattingElement(Element paramElement1, Element paramElement2) {
/* 598 */     return (paramElement1.nodeName().equals(paramElement2.nodeName()) && paramElement1.attributes().equals(paramElement2.attributes()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void reconstructFormattingElements() {
/* 605 */     int i = this.formattingElements.size();
/* 606 */     if (i == 0 || this.formattingElements.getLast() == null || onStack((Element)this.formattingElements.getLast())) {
/*     */       return;
/*     */     }
/* 609 */     Element element = (Element)this.formattingElements.getLast();
/* 610 */     int j = i - 1;
/* 611 */     boolean bool = false;
/*     */     do {
/* 613 */       if (j == 0) {
/* 614 */         bool = true;
/*     */         break;
/*     */       } 
/* 617 */       element = (Element)this.formattingElements.get(--j);
/* 618 */     } while (element != null && !onStack(element));
/*     */ 
/*     */     
/*     */     do {
/* 622 */       if (!bool)
/* 623 */         element = (Element)this.formattingElements.get(++j); 
/* 624 */       Validate.notNull(element);
/*     */ 
/*     */       
/* 627 */       bool = false;
/* 628 */       Element element1 = insert(element.nodeName());
/*     */       
/* 630 */       element1.attributes().addAll(element.attributes());
/*     */ 
/*     */       
/* 633 */       this.formattingElements.add(j, element1);
/* 634 */       this.formattingElements.remove(j + 1);
/*     */     
/*     */     }
/* 637 */     while (j != i - 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clearFormattingElementsToLastMarker() {
/* 643 */     while (!this.formattingElements.isEmpty()) {
/* 644 */       Element element = (Element)this.formattingElements.peekLast();
/* 645 */       this.formattingElements.removeLast();
/* 646 */       if (element == null)
/*     */         break; 
/*     */     } 
/*     */   }
/*     */   
/*     */   void removeFromActiveFormattingElements(Element paramElement) {
/* 652 */     Iterator<Element> iterator = this.formattingElements.descendingIterator();
/* 653 */     while (iterator.hasNext()) {
/* 654 */       Element element = iterator.next();
/* 655 */       if (element == paramElement) {
/* 656 */         iterator.remove();
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   boolean isInActiveFormattingElements(Element paramElement) {
/* 663 */     return isElementInQueue(this.formattingElements, paramElement);
/*     */   }
/*     */   
/*     */   Element getActiveFormattingElement(String paramString) {
/* 667 */     Iterator<Element> iterator = this.formattingElements.descendingIterator();
/* 668 */     while (iterator.hasNext()) {
/* 669 */       Element element = iterator.next();
/* 670 */       if (element == null)
/*     */         break; 
/* 672 */       if (element.nodeName().equals(paramString))
/* 673 */         return element; 
/*     */     } 
/* 675 */     return null;
/*     */   }
/*     */   
/*     */   void replaceActiveFormattingElement(Element paramElement1, Element paramElement2) {
/* 679 */     replaceInQueue((LinkedList<Element>)this.formattingElements, paramElement1, paramElement2);
/*     */   }
/*     */   
/*     */   void insertMarkerToFormattingElements() {
/* 683 */     this.formattingElements.add(null);
/*     */   }
/*     */   
/*     */   void insertInFosterParent(Node paramNode) {
/* 687 */     Element element1 = null;
/* 688 */     Element element2 = getFromStack("table");
/* 689 */     boolean bool = false;
/* 690 */     if (element2 != null)
/* 691 */     { if (element2.parent() != null) {
/* 692 */         element1 = element2.parent();
/* 693 */         bool = true;
/*     */       } else {
/* 695 */         element1 = aboveOnStack(element2);
/*     */       }  }
/* 697 */     else { element1 = (Element)this.stack.get(0); }
/*     */ 
/*     */     
/* 700 */     if (bool) {
/* 701 */       Validate.notNull(element2);
/* 702 */       element2.before(paramNode);
/*     */     } else {
/*     */       
/* 705 */       element1.appendChild(paramNode);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 710 */     return "TreeBuilder{currentToken=" + this.currentToken + ", state=" + this.state + ", currentElement=" + currentElement() + '}';
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\HtmlTreeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */