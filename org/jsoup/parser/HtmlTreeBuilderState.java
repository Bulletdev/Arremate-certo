/*      */ package org.jsoup.parser;
/*      */ import java.util.Iterator;
/*      */ import org.jsoup.helper.DescendableLinkedList;
/*      */ import org.jsoup.helper.StringUtil;
/*      */ import org.jsoup.nodes.Attribute;
/*      */ import org.jsoup.nodes.Attributes;
/*      */ import org.jsoup.nodes.Document;
/*      */ import org.jsoup.nodes.DocumentType;
/*      */ import org.jsoup.nodes.Element;
/*      */ import org.jsoup.nodes.FormElement;
/*      */ import org.jsoup.nodes.Node;
/*      */ 
/*      */ enum HtmlTreeBuilderState {
/*   14 */   Initial {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   16 */       if (isWhitespace(param1Token))
/*   17 */         return true; 
/*   18 */       if (param1Token.isComment()) {
/*   19 */         param1HtmlTreeBuilder.insert(param1Token.asComment());
/*   20 */       } else if (param1Token.isDoctype()) {
/*      */ 
/*      */         
/*   23 */         Token.Doctype doctype = param1Token.asDoctype();
/*   24 */         DocumentType documentType = new DocumentType(doctype.getName(), doctype.getPublicIdentifier(), doctype.getSystemIdentifier(), param1HtmlTreeBuilder.getBaseUri());
/*   25 */         param1HtmlTreeBuilder.getDocument().appendChild((Node)documentType);
/*   26 */         if (doctype.isForceQuirks())
/*   27 */           param1HtmlTreeBuilder.getDocument().quirksMode(Document.QuirksMode.quirks); 
/*   28 */         param1HtmlTreeBuilder.transition(BeforeHtml);
/*      */       } else {
/*      */         
/*   31 */         param1HtmlTreeBuilder.transition(BeforeHtml);
/*   32 */         return param1HtmlTreeBuilder.process(param1Token);
/*      */       } 
/*   34 */       return true;
/*      */     }
/*      */   },
/*   37 */   BeforeHtml {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   39 */       if (param1Token.isDoctype()) {
/*   40 */         param1HtmlTreeBuilder.error(this);
/*   41 */         return false;
/*   42 */       }  if (param1Token.isComment())
/*   43 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/*   44 */       else { if (isWhitespace(param1Token))
/*   45 */           return true; 
/*   46 */         if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html"))
/*   47 */         { param1HtmlTreeBuilder.insert(param1Token.asStartTag());
/*   48 */           param1HtmlTreeBuilder.transition(BeforeHead); }
/*   49 */         else { if (param1Token.isEndTag() && StringUtil.in(param1Token.asEndTag().name(), new String[] { "head", "body", "html", "br" }))
/*   50 */             return anythingElse(param1Token, param1HtmlTreeBuilder); 
/*   51 */           if (param1Token.isEndTag()) {
/*   52 */             param1HtmlTreeBuilder.error(this);
/*   53 */             return false;
/*      */           } 
/*   55 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */          }
/*   57 */        return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   61 */       param1HtmlTreeBuilder.insert("html");
/*   62 */       param1HtmlTreeBuilder.transition(BeforeHead);
/*   63 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*   66 */   BeforeHead {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*   68 */       if (isWhitespace(param1Token))
/*   69 */         return true; 
/*   70 */       if (param1Token.isComment())
/*   71 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/*   72 */       else { if (param1Token.isDoctype()) {
/*   73 */           param1HtmlTreeBuilder.error(this);
/*   74 */           return false;
/*   75 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html"))
/*   76 */           return InBody.process(param1Token, param1HtmlTreeBuilder); 
/*   77 */         if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("head"))
/*   78 */         { Element element = param1HtmlTreeBuilder.insert(param1Token.asStartTag());
/*   79 */           param1HtmlTreeBuilder.setHeadElement(element);
/*   80 */           param1HtmlTreeBuilder.transition(InHead); }
/*   81 */         else { if (param1Token.isEndTag() && StringUtil.in(param1Token.asEndTag().name(), new String[] { "head", "body", "html", "br" })) {
/*   82 */             param1HtmlTreeBuilder.process(new Token.StartTag("head"));
/*   83 */             return param1HtmlTreeBuilder.process(param1Token);
/*   84 */           }  if (param1Token.isEndTag()) {
/*   85 */             param1HtmlTreeBuilder.error(this);
/*   86 */             return false;
/*      */           } 
/*   88 */           param1HtmlTreeBuilder.process(new Token.StartTag("head"));
/*   89 */           return param1HtmlTreeBuilder.process(param1Token); }
/*      */          }
/*   91 */        return true;
/*      */     }
/*      */   },
/*   94 */   InHead { boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.StartTag startTag; String str;
/*      */       Token.EndTag endTag;
/*   96 */       if (isWhitespace(param1Token)) {
/*   97 */         param1HtmlTreeBuilder.insert(param1Token.asCharacter());
/*   98 */         return true;
/*      */       } 
/*  100 */       switch (param1Token.type) {
/*      */         case Comment:
/*  102 */           param1HtmlTreeBuilder.insert(param1Token.asComment());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  158 */           return true;case Doctype: param1HtmlTreeBuilder.error(this); return false;case StartTag: startTag = param1Token.asStartTag(); str = startTag.name(); if (str.equals("html")) return InBody.process(param1Token, param1HtmlTreeBuilder);  if (StringUtil.in(str, new String[] { "base", "basefont", "bgsound", "command", "link" })) { Element element = param1HtmlTreeBuilder.insertEmpty(startTag); if (str.equals("base") && element.hasAttr("href")) param1HtmlTreeBuilder.maybeSetBaseUri(element);  } else if (str.equals("meta")) { Element element = param1HtmlTreeBuilder.insertEmpty(startTag); } else if (str.equals("title")) { handleRcData(startTag, param1HtmlTreeBuilder); } else if (StringUtil.in(str, new String[] { "noframes", "style" })) { handleRawtext(startTag, param1HtmlTreeBuilder); } else if (str.equals("noscript")) { param1HtmlTreeBuilder.insert(startTag); param1HtmlTreeBuilder.transition(InHeadNoscript); } else if (str.equals("script")) { param1HtmlTreeBuilder.tokeniser.transition(TokeniserState.ScriptData); param1HtmlTreeBuilder.markInsertionMode(); param1HtmlTreeBuilder.transition(Text); param1HtmlTreeBuilder.insert(startTag); } else { if (str.equals("head")) { param1HtmlTreeBuilder.error(this); return false; }  return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;case EndTag: endTag = param1Token.asEndTag(); str = endTag.name(); if (str.equals("head")) { param1HtmlTreeBuilder.pop(); param1HtmlTreeBuilder.transition(AfterHead); } else { if (StringUtil.in(str, new String[] { "body", "html", "br" })) return anythingElse(param1Token, param1HtmlTreeBuilder);  param1HtmlTreeBuilder.error(this); return false; }  return true;
/*      */       } 
/*      */       return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */      private boolean anythingElse(Token param1Token, TreeBuilder param1TreeBuilder) {
/*  162 */       param1TreeBuilder.process(new Token.EndTag("head"));
/*  163 */       return param1TreeBuilder.process(param1Token);
/*      */     } }
/*      */   ,
/*  166 */   InHeadNoscript {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  168 */       if (param1Token.isDoctype())
/*  169 */       { param1HtmlTreeBuilder.error(this); }
/*  170 */       else { if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html"))
/*  171 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/*  172 */         if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("noscript"))
/*  173 */         { param1HtmlTreeBuilder.pop();
/*  174 */           param1HtmlTreeBuilder.transition(InHead); }
/*  175 */         else { if (isWhitespace(param1Token) || param1Token.isComment() || (param1Token.isStartTag() && StringUtil.in(param1Token.asStartTag().name(), new String[] { "basefont", "bgsound", "link", "meta", "noframes", "style" })))
/*      */           {
/*  177 */             return param1HtmlTreeBuilder.process(param1Token, InHead); } 
/*  178 */           if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("br"))
/*  179 */             return anythingElse(param1Token, param1HtmlTreeBuilder); 
/*  180 */           if ((param1Token.isStartTag() && StringUtil.in(param1Token.asStartTag().name(), new String[] { "head", "noscript" })) || param1Token.isEndTag()) {
/*  181 */             param1HtmlTreeBuilder.error(this);
/*  182 */             return false;
/*      */           } 
/*  184 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */          }
/*  186 */        return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  190 */       param1HtmlTreeBuilder.error(this);
/*  191 */       param1HtmlTreeBuilder.process(new Token.EndTag("noscript"));
/*  192 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*  195 */   AfterHead {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  197 */       if (isWhitespace(param1Token)) {
/*  198 */         param1HtmlTreeBuilder.insert(param1Token.asCharacter());
/*  199 */       } else if (param1Token.isComment()) {
/*  200 */         param1HtmlTreeBuilder.insert(param1Token.asComment());
/*  201 */       } else if (param1Token.isDoctype()) {
/*  202 */         param1HtmlTreeBuilder.error(this);
/*  203 */       } else if (param1Token.isStartTag()) {
/*  204 */         Token.StartTag startTag = param1Token.asStartTag();
/*  205 */         String str = startTag.name();
/*  206 */         if (str.equals("html"))
/*  207 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/*  208 */         if (str.equals("body"))
/*  209 */         { param1HtmlTreeBuilder.insert(startTag);
/*  210 */           param1HtmlTreeBuilder.framesetOk(false);
/*  211 */           param1HtmlTreeBuilder.transition(InBody); }
/*  212 */         else if (str.equals("frameset"))
/*  213 */         { param1HtmlTreeBuilder.insert(startTag);
/*  214 */           param1HtmlTreeBuilder.transition(InFrameset); }
/*  215 */         else if (StringUtil.in(str, new String[] { "base", "basefont", "bgsound", "link", "meta", "noframes", "script", "style", "title" }))
/*  216 */         { param1HtmlTreeBuilder.error(this);
/*  217 */           Element element = param1HtmlTreeBuilder.getHeadElement();
/*  218 */           param1HtmlTreeBuilder.push(element);
/*  219 */           param1HtmlTreeBuilder.process(param1Token, InHead);
/*  220 */           param1HtmlTreeBuilder.removeFromStack(element); }
/*  221 */         else { if (str.equals("head")) {
/*  222 */             param1HtmlTreeBuilder.error(this);
/*  223 */             return false;
/*      */           } 
/*  225 */           anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/*  227 */       } else if (param1Token.isEndTag()) {
/*  228 */         if (StringUtil.in(param1Token.asEndTag().name(), new String[] { "body", "html" })) {
/*  229 */           anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */         } else {
/*  231 */           param1HtmlTreeBuilder.error(this);
/*  232 */           return false;
/*      */         } 
/*      */       } else {
/*  235 */         anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */       } 
/*  237 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  241 */       param1HtmlTreeBuilder.process(new Token.StartTag("body"));
/*  242 */       param1HtmlTreeBuilder.framesetOk(true);
/*  243 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */   },
/*  246 */   InBody { boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.Character character; Token.StartTag startTag; String str;
/*      */       Token.EndTag endTag;
/*  248 */       switch (param1Token.type) {
/*      */         case Character:
/*  250 */           character = param1Token.asCharacter();
/*  251 */           if (character.getData().equals(HtmlTreeBuilderState.nullString)) {
/*      */             
/*  253 */             param1HtmlTreeBuilder.error(this);
/*  254 */             return false;
/*  255 */           }  if (param1HtmlTreeBuilder.framesetOk() && isWhitespace(character)) {
/*  256 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  257 */             param1HtmlTreeBuilder.insert(character); break;
/*      */           } 
/*  259 */           param1HtmlTreeBuilder.reconstructFormattingElements();
/*  260 */           param1HtmlTreeBuilder.insert(character);
/*  261 */           param1HtmlTreeBuilder.framesetOk(false);
/*      */           break;
/*      */ 
/*      */         
/*      */         case Comment:
/*  266 */           param1HtmlTreeBuilder.insert(param1Token.asComment());
/*      */           break;
/*      */         
/*      */         case Doctype:
/*  270 */           param1HtmlTreeBuilder.error(this);
/*  271 */           return false;
/*      */         
/*      */         case StartTag:
/*  274 */           startTag = param1Token.asStartTag();
/*  275 */           str = startTag.name();
/*  276 */           if (str.equals("html")) {
/*  277 */             param1HtmlTreeBuilder.error(this);
/*      */             
/*  279 */             Element element = (Element)param1HtmlTreeBuilder.getStack().getFirst();
/*  280 */             for (Attribute attribute : startTag.getAttributes()) {
/*  281 */               if (!element.hasAttr(attribute.getKey()))
/*  282 */                 element.attributes().put(attribute); 
/*      */             }  break;
/*  284 */           }  if (StringUtil.in(str, Constants.InBodyStartToHead))
/*  285 */             return param1HtmlTreeBuilder.process(param1Token, InHead); 
/*  286 */           if (str.equals("body")) {
/*  287 */             param1HtmlTreeBuilder.error(this);
/*  288 */             DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*  289 */             if (descendableLinkedList.size() == 1 || (descendableLinkedList.size() > 2 && !((Element)descendableLinkedList.get(1)).nodeName().equals("body")))
/*      */             {
/*  291 */               return false;
/*      */             }
/*  293 */             param1HtmlTreeBuilder.framesetOk(false);
/*  294 */             Element element = descendableLinkedList.get(1);
/*  295 */             for (Attribute attribute : startTag.getAttributes()) {
/*  296 */               if (!element.hasAttr(attribute.getKey()))
/*  297 */                 element.attributes().put(attribute); 
/*      */             }  break;
/*      */           } 
/*  300 */           if (str.equals("frameset")) {
/*  301 */             param1HtmlTreeBuilder.error(this);
/*  302 */             DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*  303 */             if (descendableLinkedList.size() == 1 || (descendableLinkedList.size() > 2 && !((Element)descendableLinkedList.get(1)).nodeName().equals("body")))
/*      */             {
/*  305 */               return false; } 
/*  306 */             if (!param1HtmlTreeBuilder.framesetOk()) {
/*  307 */               return false;
/*      */             }
/*  309 */             Element element = descendableLinkedList.get(1);
/*  310 */             if (element.parent() != null) {
/*  311 */               element.remove();
/*      */             }
/*  313 */             while (descendableLinkedList.size() > 1)
/*  314 */               descendableLinkedList.removeLast(); 
/*  315 */             param1HtmlTreeBuilder.insert(startTag);
/*  316 */             param1HtmlTreeBuilder.transition(InFrameset); break;
/*      */           } 
/*  318 */           if (StringUtil.in(str, Constants.InBodyStartPClosers)) {
/*  319 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  320 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  322 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  323 */           }  if (StringUtil.in(str, Constants.Headings)) {
/*  324 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  325 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  327 */             if (StringUtil.in(param1HtmlTreeBuilder.currentElement().nodeName(), Constants.Headings)) {
/*  328 */               param1HtmlTreeBuilder.error(this);
/*  329 */               param1HtmlTreeBuilder.pop();
/*      */             } 
/*  331 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  332 */           }  if (StringUtil.in(str, Constants.InBodyStartPreListing)) {
/*  333 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  334 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  336 */             param1HtmlTreeBuilder.insert(startTag);
/*      */             
/*  338 */             param1HtmlTreeBuilder.framesetOk(false); break;
/*  339 */           }  if (str.equals("form")) {
/*  340 */             if (param1HtmlTreeBuilder.getFormElement() != null) {
/*  341 */               param1HtmlTreeBuilder.error(this);
/*  342 */               return false;
/*      */             } 
/*  344 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  345 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  347 */             param1HtmlTreeBuilder.insertForm(startTag, true); break;
/*  348 */           }  if (str.equals("li")) {
/*  349 */             param1HtmlTreeBuilder.framesetOk(false);
/*  350 */             DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*  351 */             for (int i = descendableLinkedList.size() - 1; i > 0; i--) {
/*  352 */               Element element = descendableLinkedList.get(i);
/*  353 */               if (element.nodeName().equals("li")) {
/*  354 */                 param1HtmlTreeBuilder.process(new Token.EndTag("li"));
/*      */                 break;
/*      */               } 
/*  357 */               if (param1HtmlTreeBuilder.isSpecial(element) && !StringUtil.in(element.nodeName(), Constants.InBodyStartLiBreakers))
/*      */                 break; 
/*      */             } 
/*  360 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  361 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  363 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  364 */           }  if (StringUtil.in(str, Constants.DdDt)) {
/*  365 */             param1HtmlTreeBuilder.framesetOk(false);
/*  366 */             DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*  367 */             for (int i = descendableLinkedList.size() - 1; i > 0; i--) {
/*  368 */               Element element = descendableLinkedList.get(i);
/*  369 */               if (StringUtil.in(element.nodeName(), Constants.DdDt)) {
/*  370 */                 param1HtmlTreeBuilder.process(new Token.EndTag(element.nodeName()));
/*      */                 break;
/*      */               } 
/*  373 */               if (param1HtmlTreeBuilder.isSpecial(element) && !StringUtil.in(element.nodeName(), Constants.InBodyStartLiBreakers))
/*      */                 break; 
/*      */             } 
/*  376 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  377 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  379 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  380 */           }  if (str.equals("plaintext")) {
/*  381 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  382 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  384 */             param1HtmlTreeBuilder.insert(startTag);
/*  385 */             param1HtmlTreeBuilder.tokeniser.transition(TokeniserState.PLAINTEXT); break;
/*  386 */           }  if (str.equals("button")) {
/*  387 */             if (param1HtmlTreeBuilder.inButtonScope("button")) {
/*      */               
/*  389 */               param1HtmlTreeBuilder.error(this);
/*  390 */               param1HtmlTreeBuilder.process(new Token.EndTag("button"));
/*  391 */               param1HtmlTreeBuilder.process(startTag); break;
/*      */             } 
/*  393 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  394 */             param1HtmlTreeBuilder.insert(startTag);
/*  395 */             param1HtmlTreeBuilder.framesetOk(false); break;
/*      */           } 
/*  397 */           if (str.equals("a")) {
/*  398 */             if (param1HtmlTreeBuilder.getActiveFormattingElement("a") != null) {
/*  399 */               param1HtmlTreeBuilder.error(this);
/*  400 */               param1HtmlTreeBuilder.process(new Token.EndTag("a"));
/*      */ 
/*      */               
/*  403 */               Element element1 = param1HtmlTreeBuilder.getFromStack("a");
/*  404 */               if (element1 != null) {
/*  405 */                 param1HtmlTreeBuilder.removeFromActiveFormattingElements(element1);
/*  406 */                 param1HtmlTreeBuilder.removeFromStack(element1);
/*      */               } 
/*      */             } 
/*  409 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  410 */             Element element = param1HtmlTreeBuilder.insert(startTag);
/*  411 */             param1HtmlTreeBuilder.pushActiveFormattingElements(element); break;
/*  412 */           }  if (StringUtil.in(str, Constants.Formatters)) {
/*  413 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  414 */             Element element = param1HtmlTreeBuilder.insert(startTag);
/*  415 */             param1HtmlTreeBuilder.pushActiveFormattingElements(element); break;
/*  416 */           }  if (str.equals("nobr")) {
/*  417 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  418 */             if (param1HtmlTreeBuilder.inScope("nobr")) {
/*  419 */               param1HtmlTreeBuilder.error(this);
/*  420 */               param1HtmlTreeBuilder.process(new Token.EndTag("nobr"));
/*  421 */               param1HtmlTreeBuilder.reconstructFormattingElements();
/*      */             } 
/*  423 */             Element element = param1HtmlTreeBuilder.insert(startTag);
/*  424 */             param1HtmlTreeBuilder.pushActiveFormattingElements(element); break;
/*  425 */           }  if (StringUtil.in(str, Constants.InBodyStartApplets)) {
/*  426 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  427 */             param1HtmlTreeBuilder.insert(startTag);
/*  428 */             param1HtmlTreeBuilder.insertMarkerToFormattingElements();
/*  429 */             param1HtmlTreeBuilder.framesetOk(false); break;
/*  430 */           }  if (str.equals("table")) {
/*  431 */             if (param1HtmlTreeBuilder.getDocument().quirksMode() != Document.QuirksMode.quirks && param1HtmlTreeBuilder.inButtonScope("p")) {
/*  432 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  434 */             param1HtmlTreeBuilder.insert(startTag);
/*  435 */             param1HtmlTreeBuilder.framesetOk(false);
/*  436 */             param1HtmlTreeBuilder.transition(InTable); break;
/*  437 */           }  if (StringUtil.in(str, Constants.InBodyStartEmptyFormatters)) {
/*  438 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  439 */             param1HtmlTreeBuilder.insertEmpty(startTag);
/*  440 */             param1HtmlTreeBuilder.framesetOk(false); break;
/*  441 */           }  if (str.equals("input")) {
/*  442 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  443 */             Element element = param1HtmlTreeBuilder.insertEmpty(startTag);
/*  444 */             if (!element.attr("type").equalsIgnoreCase("hidden"))
/*  445 */               param1HtmlTreeBuilder.framesetOk(false);  break;
/*  446 */           }  if (StringUtil.in(str, Constants.InBodyStartMedia)) {
/*  447 */             param1HtmlTreeBuilder.insertEmpty(startTag); break;
/*  448 */           }  if (str.equals("hr")) {
/*  449 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  450 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  452 */             param1HtmlTreeBuilder.insertEmpty(startTag);
/*  453 */             param1HtmlTreeBuilder.framesetOk(false); break;
/*  454 */           }  if (str.equals("image")) {
/*  455 */             if (param1HtmlTreeBuilder.getFromStack("svg") == null) {
/*  456 */               return param1HtmlTreeBuilder.process(startTag.name("img"));
/*      */             }
/*  458 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  459 */           }  if (str.equals("isindex")) {
/*      */             
/*  461 */             param1HtmlTreeBuilder.error(this);
/*  462 */             if (param1HtmlTreeBuilder.getFormElement() != null) {
/*  463 */               return false;
/*      */             }
/*  465 */             param1HtmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag();
/*  466 */             param1HtmlTreeBuilder.process(new Token.StartTag("form"));
/*  467 */             if (startTag.attributes.hasKey("action")) {
/*  468 */               FormElement formElement = param1HtmlTreeBuilder.getFormElement();
/*  469 */               formElement.attr("action", startTag.attributes.get("action"));
/*      */             } 
/*  471 */             param1HtmlTreeBuilder.process(new Token.StartTag("hr"));
/*  472 */             param1HtmlTreeBuilder.process(new Token.StartTag("label"));
/*      */             
/*  474 */             String str1 = startTag.attributes.hasKey("prompt") ? startTag.attributes.get("prompt") : "This is a searchable index. Enter search keywords: ";
/*      */ 
/*      */ 
/*      */             
/*  478 */             param1HtmlTreeBuilder.process(new Token.Character(str1));
/*      */ 
/*      */             
/*  481 */             Attributes attributes = new Attributes();
/*  482 */             for (Attribute attribute : startTag.attributes) {
/*  483 */               if (!StringUtil.in(attribute.getKey(), Constants.InBodyStartInputAttribs))
/*  484 */                 attributes.put(attribute); 
/*      */             } 
/*  486 */             attributes.put("name", "isindex");
/*  487 */             param1HtmlTreeBuilder.process(new Token.StartTag("input", attributes));
/*  488 */             param1HtmlTreeBuilder.process(new Token.EndTag("label"));
/*  489 */             param1HtmlTreeBuilder.process(new Token.StartTag("hr"));
/*  490 */             param1HtmlTreeBuilder.process(new Token.EndTag("form")); break;
/*  491 */           }  if (str.equals("textarea")) {
/*  492 */             param1HtmlTreeBuilder.insert(startTag);
/*      */             
/*  494 */             param1HtmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
/*  495 */             param1HtmlTreeBuilder.markInsertionMode();
/*  496 */             param1HtmlTreeBuilder.framesetOk(false);
/*  497 */             param1HtmlTreeBuilder.transition(Text); break;
/*  498 */           }  if (str.equals("xmp")) {
/*  499 */             if (param1HtmlTreeBuilder.inButtonScope("p")) {
/*  500 */               param1HtmlTreeBuilder.process(new Token.EndTag("p"));
/*      */             }
/*  502 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  503 */             param1HtmlTreeBuilder.framesetOk(false);
/*  504 */             handleRawtext(startTag, param1HtmlTreeBuilder); break;
/*  505 */           }  if (str.equals("iframe")) {
/*  506 */             param1HtmlTreeBuilder.framesetOk(false);
/*  507 */             handleRawtext(startTag, param1HtmlTreeBuilder); break;
/*  508 */           }  if (str.equals("noembed")) {
/*      */             
/*  510 */             handleRawtext(startTag, param1HtmlTreeBuilder); break;
/*  511 */           }  if (str.equals("select")) {
/*  512 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  513 */             param1HtmlTreeBuilder.insert(startTag);
/*  514 */             param1HtmlTreeBuilder.framesetOk(false);
/*      */             
/*  516 */             HtmlTreeBuilderState htmlTreeBuilderState = param1HtmlTreeBuilder.state();
/*  517 */             if (htmlTreeBuilderState.equals(InTable) || htmlTreeBuilderState.equals(InCaption) || htmlTreeBuilderState.equals(InTableBody) || htmlTreeBuilderState.equals(InRow) || htmlTreeBuilderState.equals(InCell)) {
/*  518 */               param1HtmlTreeBuilder.transition(InSelectInTable); break;
/*      */             } 
/*  520 */             param1HtmlTreeBuilder.transition(InSelect); break;
/*  521 */           }  if (StringUtil.in(str, Constants.InBodyStartOptions)) {
/*  522 */             if (param1HtmlTreeBuilder.currentElement().nodeName().equals("option"))
/*  523 */               param1HtmlTreeBuilder.process(new Token.EndTag("option")); 
/*  524 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*  525 */             param1HtmlTreeBuilder.insert(startTag); break;
/*  526 */           }  if (StringUtil.in(str, Constants.InBodyStartRuby)) {
/*  527 */             if (param1HtmlTreeBuilder.inScope("ruby")) {
/*  528 */               param1HtmlTreeBuilder.generateImpliedEndTags();
/*  529 */               if (!param1HtmlTreeBuilder.currentElement().nodeName().equals("ruby")) {
/*  530 */                 param1HtmlTreeBuilder.error(this);
/*  531 */                 param1HtmlTreeBuilder.popStackToBefore("ruby");
/*      */               } 
/*  533 */               param1HtmlTreeBuilder.insert(startTag);
/*      */             }  break;
/*  535 */           }  if (str.equals("math")) {
/*  536 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*      */             
/*  538 */             param1HtmlTreeBuilder.insert(startTag);
/*  539 */             param1HtmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag(); break;
/*  540 */           }  if (str.equals("svg")) {
/*  541 */             param1HtmlTreeBuilder.reconstructFormattingElements();
/*      */             
/*  543 */             param1HtmlTreeBuilder.insert(startTag);
/*  544 */             param1HtmlTreeBuilder.tokeniser.acknowledgeSelfClosingFlag(); break;
/*  545 */           }  if (StringUtil.in(str, Constants.InBodyStartDrop)) {
/*  546 */             param1HtmlTreeBuilder.error(this);
/*  547 */             return false;
/*      */           } 
/*  549 */           param1HtmlTreeBuilder.reconstructFormattingElements();
/*  550 */           param1HtmlTreeBuilder.insert(startTag);
/*      */           break;
/*      */ 
/*      */         
/*      */         case EndTag:
/*  555 */           endTag = param1Token.asEndTag();
/*  556 */           str = endTag.name();
/*  557 */           if (str.equals("body")) {
/*  558 */             if (!param1HtmlTreeBuilder.inScope("body")) {
/*  559 */               param1HtmlTreeBuilder.error(this);
/*  560 */               return false;
/*      */             } 
/*      */             
/*  563 */             param1HtmlTreeBuilder.transition(AfterBody); break;
/*      */           } 
/*  565 */           if (str.equals("html")) {
/*  566 */             boolean bool = param1HtmlTreeBuilder.process(new Token.EndTag("body"));
/*  567 */             if (bool)
/*  568 */               return param1HtmlTreeBuilder.process(endTag);  break;
/*  569 */           }  if (StringUtil.in(str, Constants.InBodyEndClosers)) {
/*  570 */             if (!param1HtmlTreeBuilder.inScope(str)) {
/*      */               
/*  572 */               param1HtmlTreeBuilder.error(this);
/*  573 */               return false;
/*      */             } 
/*  575 */             param1HtmlTreeBuilder.generateImpliedEndTags();
/*  576 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  577 */               param1HtmlTreeBuilder.error(this); 
/*  578 */             param1HtmlTreeBuilder.popStackToClose(str); break;
/*      */           } 
/*  580 */           if (str.equals("form")) {
/*  581 */             FormElement formElement = param1HtmlTreeBuilder.getFormElement();
/*  582 */             param1HtmlTreeBuilder.setFormElement((FormElement)null);
/*  583 */             if (formElement == null || !param1HtmlTreeBuilder.inScope(str)) {
/*  584 */               param1HtmlTreeBuilder.error(this);
/*  585 */               return false;
/*      */             } 
/*  587 */             param1HtmlTreeBuilder.generateImpliedEndTags();
/*  588 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str)) {
/*  589 */               param1HtmlTreeBuilder.error(this);
/*      */             }
/*  591 */             param1HtmlTreeBuilder.removeFromStack((Element)formElement); break;
/*      */           } 
/*  593 */           if (str.equals("p")) {
/*  594 */             if (!param1HtmlTreeBuilder.inButtonScope(str)) {
/*  595 */               param1HtmlTreeBuilder.error(this);
/*  596 */               param1HtmlTreeBuilder.process(new Token.StartTag(str));
/*  597 */               return param1HtmlTreeBuilder.process(endTag);
/*      */             } 
/*  599 */             param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  600 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  601 */               param1HtmlTreeBuilder.error(this); 
/*  602 */             param1HtmlTreeBuilder.popStackToClose(str); break;
/*      */           } 
/*  604 */           if (str.equals("li")) {
/*  605 */             if (!param1HtmlTreeBuilder.inListItemScope(str)) {
/*  606 */               param1HtmlTreeBuilder.error(this);
/*  607 */               return false;
/*      */             } 
/*  609 */             param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  610 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  611 */               param1HtmlTreeBuilder.error(this); 
/*  612 */             param1HtmlTreeBuilder.popStackToClose(str); break;
/*      */           } 
/*  614 */           if (StringUtil.in(str, Constants.DdDt)) {
/*  615 */             if (!param1HtmlTreeBuilder.inScope(str)) {
/*  616 */               param1HtmlTreeBuilder.error(this);
/*  617 */               return false;
/*      */             } 
/*  619 */             param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  620 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  621 */               param1HtmlTreeBuilder.error(this); 
/*  622 */             param1HtmlTreeBuilder.popStackToClose(str); break;
/*      */           } 
/*  624 */           if (StringUtil.in(str, Constants.Headings)) {
/*  625 */             if (!param1HtmlTreeBuilder.inScope(Constants.Headings)) {
/*  626 */               param1HtmlTreeBuilder.error(this);
/*  627 */               return false;
/*      */             } 
/*  629 */             param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  630 */             if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  631 */               param1HtmlTreeBuilder.error(this); 
/*  632 */             param1HtmlTreeBuilder.popStackToClose(Constants.Headings); break;
/*      */           } 
/*  634 */           if (str.equals("sarcasm"))
/*      */           {
/*  636 */             return anyOtherEndTag(param1Token, param1HtmlTreeBuilder); } 
/*  637 */           if (StringUtil.in(str, Constants.InBodyEndAdoptionFormatters)) {
/*      */ 
/*      */             
/*  640 */             for (byte b = 0; b < 8; b++) {
/*  641 */               Element element1 = param1HtmlTreeBuilder.getActiveFormattingElement(str);
/*  642 */               if (element1 == null)
/*  643 */                 return anyOtherEndTag(param1Token, param1HtmlTreeBuilder); 
/*  644 */               if (!param1HtmlTreeBuilder.onStack(element1)) {
/*  645 */                 param1HtmlTreeBuilder.error(this);
/*  646 */                 param1HtmlTreeBuilder.removeFromActiveFormattingElements(element1);
/*  647 */                 return true;
/*  648 */               }  if (!param1HtmlTreeBuilder.inScope(element1.nodeName())) {
/*  649 */                 param1HtmlTreeBuilder.error(this);
/*  650 */                 return false;
/*  651 */               }  if (param1HtmlTreeBuilder.currentElement() != element1) {
/*  652 */                 param1HtmlTreeBuilder.error(this);
/*      */               }
/*  654 */               Element element2 = null;
/*  655 */               Element element3 = null;
/*  656 */               boolean bool = false;
/*  657 */               DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*      */ 
/*      */               
/*  660 */               int i = descendableLinkedList.size();
/*  661 */               for (byte b1 = 0; b1 < i && b1 < 64; b1++) {
/*  662 */                 Element element = descendableLinkedList.get(b1);
/*  663 */                 if (element == element1) {
/*  664 */                   element3 = descendableLinkedList.get(b1 - 1);
/*  665 */                   bool = true;
/*  666 */                 } else if (bool && param1HtmlTreeBuilder.isSpecial(element)) {
/*  667 */                   element2 = element;
/*      */                   break;
/*      */                 } 
/*      */               } 
/*  671 */               if (element2 == null) {
/*  672 */                 param1HtmlTreeBuilder.popStackToClose(element1.nodeName());
/*  673 */                 param1HtmlTreeBuilder.removeFromActiveFormattingElements(element1);
/*  674 */                 return true;
/*      */               } 
/*      */ 
/*      */ 
/*      */               
/*  679 */               Element element4 = element2;
/*  680 */               Element element5 = element2;
/*      */               
/*  682 */               for (byte b2 = 0; b2 < 3; b2++) {
/*  683 */                 if (param1HtmlTreeBuilder.onStack(element4))
/*  684 */                   element4 = param1HtmlTreeBuilder.aboveOnStack(element4); 
/*  685 */                 if (!param1HtmlTreeBuilder.isInActiveFormattingElements(element4)) {
/*  686 */                   param1HtmlTreeBuilder.removeFromStack(element4);
/*      */                 } else {
/*  688 */                   if (element4 == element1) {
/*      */                     break;
/*      */                   }
/*  691 */                   Element element = new Element(Tag.valueOf(element4.nodeName()), param1HtmlTreeBuilder.getBaseUri());
/*  692 */                   param1HtmlTreeBuilder.replaceActiveFormattingElement(element4, element);
/*  693 */                   param1HtmlTreeBuilder.replaceOnStack(element4, element);
/*  694 */                   element4 = element;
/*      */                   
/*  696 */                   if (element5 == element2);
/*      */ 
/*      */ 
/*      */                   
/*  700 */                   if (element5.parent() != null)
/*  701 */                     element5.remove(); 
/*  702 */                   element4.appendChild((Node)element5);
/*      */                   
/*  704 */                   element5 = element4;
/*      */                 } 
/*      */               } 
/*  707 */               if (StringUtil.in(element3.nodeName(), Constants.InBodyEndTableFosters)) {
/*  708 */                 if (element5.parent() != null)
/*  709 */                   element5.remove(); 
/*  710 */                 param1HtmlTreeBuilder.insertInFosterParent((Node)element5);
/*      */               } else {
/*  712 */                 if (element5.parent() != null)
/*  713 */                   element5.remove(); 
/*  714 */                 element3.appendChild((Node)element5);
/*      */               } 
/*      */               
/*  717 */               Element element6 = new Element(element1.tag(), param1HtmlTreeBuilder.getBaseUri());
/*  718 */               element6.attributes().addAll(element1.attributes());
/*  719 */               Node[] arrayOfNode = (Node[])element2.childNodes().toArray((Object[])new Node[element2.childNodeSize()]);
/*  720 */               for (Node node : arrayOfNode) {
/*  721 */                 element6.appendChild(node);
/*      */               }
/*  723 */               element2.appendChild((Node)element6);
/*  724 */               param1HtmlTreeBuilder.removeFromActiveFormattingElements(element1);
/*      */               
/*  726 */               param1HtmlTreeBuilder.removeFromStack(element1);
/*  727 */               param1HtmlTreeBuilder.insertOnStackAfter(element2, element6);
/*      */             }  break;
/*  729 */           }  if (StringUtil.in(str, Constants.InBodyStartApplets)) {
/*  730 */             if (!param1HtmlTreeBuilder.inScope("name")) {
/*  731 */               if (!param1HtmlTreeBuilder.inScope(str)) {
/*  732 */                 param1HtmlTreeBuilder.error(this);
/*  733 */                 return false;
/*      */               } 
/*  735 */               param1HtmlTreeBuilder.generateImpliedEndTags();
/*  736 */               if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/*  737 */                 param1HtmlTreeBuilder.error(this); 
/*  738 */               param1HtmlTreeBuilder.popStackToClose(str);
/*  739 */               param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/*      */             }  break;
/*  741 */           }  if (str.equals("br")) {
/*  742 */             param1HtmlTreeBuilder.error(this);
/*  743 */             param1HtmlTreeBuilder.process(new Token.StartTag("br"));
/*  744 */             return false;
/*      */           } 
/*  746 */           return anyOtherEndTag(param1Token, param1HtmlTreeBuilder);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  755 */       return true; }
/*      */ 
/*      */     
/*      */     boolean anyOtherEndTag(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  759 */       String str = param1Token.asEndTag().name();
/*  760 */       DescendableLinkedList<Element> descendableLinkedList = param1HtmlTreeBuilder.getStack();
/*  761 */       Iterator<Element> iterator = descendableLinkedList.descendingIterator();
/*  762 */       while (iterator.hasNext()) {
/*  763 */         Element element = iterator.next();
/*  764 */         if (element.nodeName().equals(str)) {
/*  765 */           param1HtmlTreeBuilder.generateImpliedEndTags(str);
/*  766 */           if (!str.equals(param1HtmlTreeBuilder.currentElement().nodeName()))
/*  767 */             param1HtmlTreeBuilder.error(this); 
/*  768 */           param1HtmlTreeBuilder.popStackToClose(str);
/*      */           break;
/*      */         } 
/*  771 */         if (param1HtmlTreeBuilder.isSpecial(element)) {
/*  772 */           param1HtmlTreeBuilder.error(this);
/*  773 */           return false;
/*      */         } 
/*      */       } 
/*      */       
/*  777 */       return true;
/*      */     } }
/*      */   ,
/*  780 */   Text
/*      */   {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  783 */       if (param1Token.isCharacter())
/*  784 */       { param1HtmlTreeBuilder.insert(param1Token.asCharacter()); }
/*  785 */       else { if (param1Token.isEOF()) {
/*  786 */           param1HtmlTreeBuilder.error(this);
/*      */           
/*  788 */           param1HtmlTreeBuilder.pop();
/*  789 */           param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState());
/*  790 */           return param1HtmlTreeBuilder.process(param1Token);
/*  791 */         }  if (param1Token.isEndTag()) {
/*      */           
/*  793 */           param1HtmlTreeBuilder.pop();
/*  794 */           param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState());
/*      */         }  }
/*  796 */        return true;
/*      */     }
/*      */   },
/*  799 */   InTable {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  801 */       if (param1Token.isCharacter()) {
/*  802 */         param1HtmlTreeBuilder.newPendingTableCharacters();
/*  803 */         param1HtmlTreeBuilder.markInsertionMode();
/*  804 */         param1HtmlTreeBuilder.transition(InTableText);
/*  805 */         return param1HtmlTreeBuilder.process(param1Token);
/*  806 */       }  if (param1Token.isComment()) {
/*  807 */         param1HtmlTreeBuilder.insert(param1Token.asComment());
/*  808 */         return true;
/*  809 */       }  if (param1Token.isDoctype()) {
/*  810 */         param1HtmlTreeBuilder.error(this);
/*  811 */         return false;
/*  812 */       }  if (param1Token.isStartTag()) {
/*  813 */         Token.StartTag startTag = param1Token.asStartTag();
/*  814 */         String str = startTag.name();
/*  815 */         if (str.equals("caption"))
/*  816 */         { param1HtmlTreeBuilder.clearStackToTableContext();
/*  817 */           param1HtmlTreeBuilder.insertMarkerToFormattingElements();
/*  818 */           param1HtmlTreeBuilder.insert(startTag);
/*  819 */           param1HtmlTreeBuilder.transition(InCaption); }
/*  820 */         else if (str.equals("colgroup"))
/*  821 */         { param1HtmlTreeBuilder.clearStackToTableContext();
/*  822 */           param1HtmlTreeBuilder.insert(startTag);
/*  823 */           param1HtmlTreeBuilder.transition(InColumnGroup); }
/*  824 */         else { if (str.equals("col")) {
/*  825 */             param1HtmlTreeBuilder.process(new Token.StartTag("colgroup"));
/*  826 */             return param1HtmlTreeBuilder.process(param1Token);
/*  827 */           }  if (StringUtil.in(str, new String[] { "tbody", "tfoot", "thead" }))
/*  828 */           { param1HtmlTreeBuilder.clearStackToTableContext();
/*  829 */             param1HtmlTreeBuilder.insert(startTag);
/*  830 */             param1HtmlTreeBuilder.transition(InTableBody); }
/*  831 */           else { if (StringUtil.in(str, new String[] { "td", "th", "tr" })) {
/*  832 */               param1HtmlTreeBuilder.process(new Token.StartTag("tbody"));
/*  833 */               return param1HtmlTreeBuilder.process(param1Token);
/*  834 */             }  if (str.equals("table"))
/*  835 */             { param1HtmlTreeBuilder.error(this);
/*  836 */               boolean bool = param1HtmlTreeBuilder.process(new Token.EndTag("table"));
/*  837 */               if (bool)
/*  838 */                 return param1HtmlTreeBuilder.process(param1Token);  }
/*  839 */             else { if (StringUtil.in(str, new String[] { "style", "script" }))
/*  840 */                 return param1HtmlTreeBuilder.process(param1Token, InHead); 
/*  841 */               if (str.equals("input"))
/*  842 */               { if (!startTag.attributes.get("type").equalsIgnoreCase("hidden")) {
/*  843 */                   return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */                 }
/*  845 */                 param1HtmlTreeBuilder.insertEmpty(startTag); }
/*      */               
/*  847 */               else if (str.equals("form"))
/*  848 */               { param1HtmlTreeBuilder.error(this);
/*  849 */                 if (param1HtmlTreeBuilder.getFormElement() != null) {
/*  850 */                   return false;
/*      */                 }
/*  852 */                 param1HtmlTreeBuilder.insertForm(startTag, false); }
/*      */               else
/*      */               
/*  855 */               { return anythingElse(param1Token, param1HtmlTreeBuilder); }  }  }
/*      */            }
/*  857 */          return true;
/*  858 */       }  if (param1Token.isEndTag()) {
/*  859 */         Token.EndTag endTag = param1Token.asEndTag();
/*  860 */         String str = endTag.name();
/*      */         
/*  862 */         if (str.equals("table"))
/*  863 */         { if (!param1HtmlTreeBuilder.inTableScope(str)) {
/*  864 */             param1HtmlTreeBuilder.error(this);
/*  865 */             return false;
/*      */           } 
/*  867 */           param1HtmlTreeBuilder.popStackToClose("table");
/*      */           
/*  869 */           param1HtmlTreeBuilder.resetInsertionMode(); }
/*  870 */         else { if (StringUtil.in(str, new String[] { "body", "caption", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr" })) {
/*      */             
/*  872 */             param1HtmlTreeBuilder.error(this);
/*  873 */             return false;
/*      */           } 
/*  875 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */         
/*  877 */         return true;
/*  878 */       }  if (param1Token.isEOF()) {
/*  879 */         if (param1HtmlTreeBuilder.currentElement().nodeName().equals("html"))
/*  880 */           param1HtmlTreeBuilder.error(this); 
/*  881 */         return true;
/*      */       } 
/*  883 */       return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */     }
/*      */     
/*      */     boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  887 */       param1HtmlTreeBuilder.error(this);
/*  888 */       boolean bool = true;
/*  889 */       if (StringUtil.in(param1HtmlTreeBuilder.currentElement().nodeName(), new String[] { "table", "tbody", "tfoot", "thead", "tr" })) {
/*  890 */         param1HtmlTreeBuilder.setFosterInserts(true);
/*  891 */         bool = param1HtmlTreeBuilder.process(param1Token, InBody);
/*  892 */         param1HtmlTreeBuilder.setFosterInserts(false);
/*      */       } else {
/*  894 */         bool = param1HtmlTreeBuilder.process(param1Token, InBody);
/*      */       } 
/*  896 */       return bool;
/*      */     }
/*      */   },
/*  899 */   InTableText {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.Character character;
/*  901 */       switch (param1Token.type)
/*      */       { case Character:
/*  903 */           character = param1Token.asCharacter();
/*  904 */           if (character.getData().equals(HtmlTreeBuilderState.nullString)) {
/*  905 */             param1HtmlTreeBuilder.error(this);
/*  906 */             return false;
/*      */           } 
/*  908 */           param1HtmlTreeBuilder.getPendingTableCharacters().add(character);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  932 */           return true; }  if (param1HtmlTreeBuilder.getPendingTableCharacters().size() > 0) { for (Token.Character character1 : param1HtmlTreeBuilder.getPendingTableCharacters()) { if (!isWhitespace(character1)) { param1HtmlTreeBuilder.error(this); if (StringUtil.in(param1HtmlTreeBuilder.currentElement().nodeName(), new String[] { "table", "tbody", "tfoot", "thead", "tr" })) { param1HtmlTreeBuilder.setFosterInserts(true); param1HtmlTreeBuilder.process(character1, InBody); param1HtmlTreeBuilder.setFosterInserts(false); continue; }  param1HtmlTreeBuilder.process(character1, InBody); continue; }
/*      */            param1HtmlTreeBuilder.insert(character1); }
/*      */          param1HtmlTreeBuilder.newPendingTableCharacters(); }
/*  935 */        param1HtmlTreeBuilder.transition(param1HtmlTreeBuilder.originalState()); return param1HtmlTreeBuilder.process(param1Token); } }, InCaption {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/*  937 */       if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("caption"))
/*  938 */       { Token.EndTag endTag = param1Token.asEndTag();
/*  939 */         String str = endTag.name();
/*  940 */         if (!param1HtmlTreeBuilder.inTableScope(str)) {
/*  941 */           param1HtmlTreeBuilder.error(this);
/*  942 */           return false;
/*      */         } 
/*  944 */         param1HtmlTreeBuilder.generateImpliedEndTags();
/*  945 */         if (!param1HtmlTreeBuilder.currentElement().nodeName().equals("caption"))
/*  946 */           param1HtmlTreeBuilder.error(this); 
/*  947 */         param1HtmlTreeBuilder.popStackToClose("caption");
/*  948 */         param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/*  949 */         param1HtmlTreeBuilder.transition(InTable); }
/*      */       
/*  951 */       else if ((param1Token.isStartTag() && StringUtil.in(param1Token.asStartTag().name(), new String[] { "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr" })) || (param1Token.isEndTag() && param1Token.asEndTag().name().equals("table")))
/*      */       
/*      */       { 
/*      */ 
/*      */         
/*  956 */         param1HtmlTreeBuilder.error(this);
/*  957 */         boolean bool = param1HtmlTreeBuilder.process(new Token.EndTag("caption"));
/*  958 */         if (bool)
/*  959 */           return param1HtmlTreeBuilder.process(param1Token);  }
/*  960 */       else { if (param1Token.isEndTag() && StringUtil.in(param1Token.asEndTag().name(), new String[] { "body", "col", "colgroup", "html", "tbody", "td", "tfoot", "th", "thead", "tr" })) {
/*      */           
/*  962 */           param1HtmlTreeBuilder.error(this);
/*  963 */           return false;
/*      */         } 
/*  965 */         return param1HtmlTreeBuilder.process(param1Token, InBody); }
/*      */       
/*  967 */       return true;
/*      */     }
/*      */   },
/*  970 */   InColumnGroup { boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.StartTag startTag; String str;
/*      */       Token.EndTag endTag;
/*  972 */       if (isWhitespace(param1Token)) {
/*  973 */         param1HtmlTreeBuilder.insert(param1Token.asCharacter());
/*  974 */         return true;
/*      */       } 
/*  976 */       switch (param1Token.type) {
/*      */         case Comment:
/*  978 */           param1HtmlTreeBuilder.insert(param1Token.asComment());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1015 */           return true;case Doctype: param1HtmlTreeBuilder.error(this); return true;case StartTag: startTag = param1Token.asStartTag(); str = startTag.name(); if (str.equals("html")) return param1HtmlTreeBuilder.process(param1Token, InBody);  if (str.equals("col")) { param1HtmlTreeBuilder.insertEmpty(startTag); } else { return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;case EndTag: endTag = param1Token.asEndTag(); str = endTag.name(); if (str.equals("colgroup")) { if (param1HtmlTreeBuilder.currentElement().nodeName().equals("html")) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.pop(); param1HtmlTreeBuilder.transition(InTable); } else { return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;
/*      */         case EOF:
/*      */           if (param1HtmlTreeBuilder.currentElement().nodeName().equals("html"))
/*      */             return true;  return anythingElse(param1Token, param1HtmlTreeBuilder);
/* 1019 */       }  return anythingElse(param1Token, param1HtmlTreeBuilder); } private boolean anythingElse(Token param1Token, TreeBuilder param1TreeBuilder) { boolean bool = param1TreeBuilder.process(new Token.EndTag("colgroup"));
/* 1020 */       if (bool)
/* 1021 */         return param1TreeBuilder.process(param1Token); 
/* 1022 */       return true; }
/*      */      }
/*      */   ,
/* 1025 */   InTableBody { boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.StartTag startTag; String str;
/*      */       Token.EndTag endTag;
/* 1027 */       switch (param1Token.type) {
/*      */         case StartTag:
/* 1029 */           startTag = param1Token.asStartTag();
/* 1030 */           str = startTag.name();
/* 1031 */           if (str.equals("tr"))
/* 1032 */           { param1HtmlTreeBuilder.clearStackToTableBodyContext();
/* 1033 */             param1HtmlTreeBuilder.insert(startTag);
/* 1034 */             param1HtmlTreeBuilder.transition(InRow); }
/* 1035 */           else { if (StringUtil.in(str, new String[] { "th", "td" })) {
/* 1036 */               param1HtmlTreeBuilder.error(this);
/* 1037 */               param1HtmlTreeBuilder.process(new Token.StartTag("tr"));
/* 1038 */               return param1HtmlTreeBuilder.process(startTag);
/* 1039 */             }  if (StringUtil.in(str, new String[] { "caption", "col", "colgroup", "tbody", "tfoot", "thead" })) {
/* 1040 */               return exitTableBody(param1Token, param1HtmlTreeBuilder);
/*      */             }
/* 1042 */             return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1067 */           return true;case EndTag: endTag = param1Token.asEndTag(); str = endTag.name(); if (StringUtil.in(str, new String[] { "tbody", "tfoot", "thead" })) { if (!param1HtmlTreeBuilder.inTableScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.clearStackToTableBodyContext(); param1HtmlTreeBuilder.pop(); param1HtmlTreeBuilder.transition(InTable); } else { if (str.equals("table")) return exitTableBody(param1Token, param1HtmlTreeBuilder);  if (StringUtil.in(str, new String[] { "body", "caption", "col", "colgroup", "html", "td", "th", "tr" })) { param1HtmlTreeBuilder.error(this); return false; }  return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;
/*      */       } 
/*      */       return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */      private boolean exitTableBody(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1071 */       if (!param1HtmlTreeBuilder.inTableScope("tbody") && !param1HtmlTreeBuilder.inTableScope("thead") && !param1HtmlTreeBuilder.inScope("tfoot")) {
/*      */         
/* 1073 */         param1HtmlTreeBuilder.error(this);
/* 1074 */         return false;
/*      */       } 
/* 1076 */       param1HtmlTreeBuilder.clearStackToTableBodyContext();
/* 1077 */       param1HtmlTreeBuilder.process(new Token.EndTag(param1HtmlTreeBuilder.currentElement().nodeName()));
/* 1078 */       return param1HtmlTreeBuilder.process(param1Token);
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1082 */       return param1HtmlTreeBuilder.process(param1Token, InTable);
/*      */     } }
/*      */   ,
/* 1085 */   InRow {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1087 */       if (param1Token.isStartTag()) {
/* 1088 */         Token.StartTag startTag = param1Token.asStartTag();
/* 1089 */         String str = startTag.name();
/*      */         
/* 1091 */         if (StringUtil.in(str, new String[] { "th", "td" }))
/* 1092 */         { param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1093 */           param1HtmlTreeBuilder.insert(startTag);
/* 1094 */           param1HtmlTreeBuilder.transition(InCell);
/* 1095 */           param1HtmlTreeBuilder.insertMarkerToFormattingElements(); }
/* 1096 */         else { if (StringUtil.in(str, new String[] { "caption", "col", "colgroup", "tbody", "tfoot", "thead", "tr" })) {
/* 1097 */             return handleMissingTr(param1Token, param1HtmlTreeBuilder);
/*      */           }
/* 1099 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/* 1101 */       } else if (param1Token.isEndTag()) {
/* 1102 */         Token.EndTag endTag = param1Token.asEndTag();
/* 1103 */         String str = endTag.name();
/*      */         
/* 1105 */         if (str.equals("tr"))
/* 1106 */         { if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1107 */             param1HtmlTreeBuilder.error(this);
/* 1108 */             return false;
/*      */           } 
/* 1110 */           param1HtmlTreeBuilder.clearStackToTableRowContext();
/* 1111 */           param1HtmlTreeBuilder.pop();
/* 1112 */           param1HtmlTreeBuilder.transition(InTableBody); }
/* 1113 */         else { if (str.equals("table"))
/* 1114 */             return handleMissingTr(param1Token, param1HtmlTreeBuilder); 
/* 1115 */           if (StringUtil.in(str, new String[] { "tbody", "tfoot", "thead" })) {
/* 1116 */             if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1117 */               param1HtmlTreeBuilder.error(this);
/* 1118 */               return false;
/*      */             } 
/* 1120 */             param1HtmlTreeBuilder.process(new Token.EndTag("tr"));
/* 1121 */             return param1HtmlTreeBuilder.process(param1Token);
/* 1122 */           }  if (StringUtil.in(str, new String[] { "body", "caption", "col", "colgroup", "html", "td", "th" })) {
/* 1123 */             param1HtmlTreeBuilder.error(this);
/* 1124 */             return false;
/*      */           } 
/* 1126 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/*      */       } else {
/* 1129 */         return anythingElse(param1Token, param1HtmlTreeBuilder);
/*      */       } 
/* 1131 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1135 */       return param1HtmlTreeBuilder.process(param1Token, InTable);
/*      */     }
/*      */     
/*      */     private boolean handleMissingTr(Token param1Token, TreeBuilder param1TreeBuilder) {
/* 1139 */       boolean bool = param1TreeBuilder.process(new Token.EndTag("tr"));
/* 1140 */       if (bool) {
/* 1141 */         return param1TreeBuilder.process(param1Token);
/*      */       }
/* 1143 */       return false;
/*      */     }
/*      */   },
/* 1146 */   InCell {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1148 */       if (param1Token.isEndTag())
/* 1149 */       { Token.EndTag endTag = param1Token.asEndTag();
/* 1150 */         String str = endTag.name();
/*      */         
/* 1152 */         if (StringUtil.in(str, new String[] { "td", "th" }))
/* 1153 */         { if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1154 */             param1HtmlTreeBuilder.error(this);
/* 1155 */             param1HtmlTreeBuilder.transition(InRow);
/* 1156 */             return false;
/*      */           } 
/* 1158 */           param1HtmlTreeBuilder.generateImpliedEndTags();
/* 1159 */           if (!param1HtmlTreeBuilder.currentElement().nodeName().equals(str))
/* 1160 */             param1HtmlTreeBuilder.error(this); 
/* 1161 */           param1HtmlTreeBuilder.popStackToClose(str);
/* 1162 */           param1HtmlTreeBuilder.clearFormattingElementsToLastMarker();
/* 1163 */           param1HtmlTreeBuilder.transition(InRow); }
/* 1164 */         else { if (StringUtil.in(str, new String[] { "body", "caption", "col", "colgroup", "html" })) {
/* 1165 */             param1HtmlTreeBuilder.error(this);
/* 1166 */             return false;
/* 1167 */           }  if (StringUtil.in(str, new String[] { "table", "tbody", "tfoot", "thead", "tr" })) {
/* 1168 */             if (!param1HtmlTreeBuilder.inTableScope(str)) {
/* 1169 */               param1HtmlTreeBuilder.error(this);
/* 1170 */               return false;
/*      */             } 
/* 1172 */             closeCell(param1HtmlTreeBuilder);
/* 1173 */             return param1HtmlTreeBuilder.process(param1Token);
/*      */           } 
/* 1175 */           return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */          }
/* 1177 */       else { if (param1Token.isStartTag() && StringUtil.in(param1Token.asStartTag().name(), new String[] { "caption", "col", "colgroup", "tbody", "td", "tfoot", "th", "thead", "tr" })) {
/*      */ 
/*      */           
/* 1180 */           if (!param1HtmlTreeBuilder.inTableScope("td") && !param1HtmlTreeBuilder.inTableScope("th")) {
/* 1181 */             param1HtmlTreeBuilder.error(this);
/* 1182 */             return false;
/*      */           } 
/* 1184 */           closeCell(param1HtmlTreeBuilder);
/* 1185 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         } 
/* 1187 */         return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */       
/* 1189 */       return true;
/*      */     }
/*      */     
/*      */     private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1193 */       return param1HtmlTreeBuilder.process(param1Token, InBody);
/*      */     }
/*      */     
/*      */     private void closeCell(HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1197 */       if (param1HtmlTreeBuilder.inTableScope("td")) {
/* 1198 */         param1HtmlTreeBuilder.process(new Token.EndTag("td"));
/*      */       } else {
/* 1200 */         param1HtmlTreeBuilder.process(new Token.EndTag("th"));
/*      */       } 
/*      */     } },
/* 1203 */   InSelect { boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) { Token.Character character; Token.StartTag startTag; String str;
/*      */       Token.EndTag endTag;
/* 1205 */       switch (param1Token.type) {
/*      */         case Character:
/* 1207 */           character = param1Token.asCharacter();
/* 1208 */           if (character.getData().equals(HtmlTreeBuilderState.nullString)) {
/* 1209 */             param1HtmlTreeBuilder.error(this);
/* 1210 */             return false;
/*      */           } 
/* 1212 */           param1HtmlTreeBuilder.insert(character);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1283 */           return true;case Comment: param1HtmlTreeBuilder.insert(param1Token.asComment()); return true;case Doctype: param1HtmlTreeBuilder.error(this); return false;case StartTag: startTag = param1Token.asStartTag(); str = startTag.name(); if (str.equals("html")) return param1HtmlTreeBuilder.process(startTag, InBody);  if (str.equals("option")) { param1HtmlTreeBuilder.process(new Token.EndTag("option")); param1HtmlTreeBuilder.insert(startTag); } else if (str.equals("optgroup")) { if (param1HtmlTreeBuilder.currentElement().nodeName().equals("option")) { param1HtmlTreeBuilder.process(new Token.EndTag("option")); } else if (param1HtmlTreeBuilder.currentElement().nodeName().equals("optgroup")) { param1HtmlTreeBuilder.process(new Token.EndTag("optgroup")); }  param1HtmlTreeBuilder.insert(startTag); } else { if (str.equals("select")) { param1HtmlTreeBuilder.error(this); return param1HtmlTreeBuilder.process(new Token.EndTag("select")); }  if (StringUtil.in(str, new String[] { "input", "keygen", "textarea" })) { param1HtmlTreeBuilder.error(this); if (!param1HtmlTreeBuilder.inSelectScope("select")) return false;  param1HtmlTreeBuilder.process(new Token.EndTag("select")); return param1HtmlTreeBuilder.process(startTag); }  if (str.equals("script")) return param1HtmlTreeBuilder.process(param1Token, InHead);  return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;case EndTag: endTag = param1Token.asEndTag(); str = endTag.name(); if (str.equals("optgroup")) { if (param1HtmlTreeBuilder.currentElement().nodeName().equals("option") && param1HtmlTreeBuilder.aboveOnStack(param1HtmlTreeBuilder.currentElement()) != null && param1HtmlTreeBuilder.aboveOnStack(param1HtmlTreeBuilder.currentElement()).nodeName().equals("optgroup")) param1HtmlTreeBuilder.process(new Token.EndTag("option"));  if (param1HtmlTreeBuilder.currentElement().nodeName().equals("optgroup")) { param1HtmlTreeBuilder.pop(); } else { param1HtmlTreeBuilder.error(this); }  } else if (str.equals("option")) { if (param1HtmlTreeBuilder.currentElement().nodeName().equals("option")) { param1HtmlTreeBuilder.pop(); } else { param1HtmlTreeBuilder.error(this); }  } else if (str.equals("select")) { if (!param1HtmlTreeBuilder.inSelectScope(str)) { param1HtmlTreeBuilder.error(this); return false; }  param1HtmlTreeBuilder.popStackToClose(str); param1HtmlTreeBuilder.resetInsertionMode(); } else { return anythingElse(param1Token, param1HtmlTreeBuilder); }  return true;case EOF: if (!param1HtmlTreeBuilder.currentElement().nodeName().equals("html")) param1HtmlTreeBuilder.error(this);  return true;
/*      */       } 
/*      */       return anythingElse(param1Token, param1HtmlTreeBuilder); }
/*      */      private boolean anythingElse(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1287 */       param1HtmlTreeBuilder.error(this);
/* 1288 */       return false;
/*      */     } }
/*      */   ,
/* 1291 */   InSelectInTable {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1293 */       if (param1Token.isStartTag() && StringUtil.in(param1Token.asStartTag().name(), new String[] { "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th" })) {
/* 1294 */         param1HtmlTreeBuilder.error(this);
/* 1295 */         param1HtmlTreeBuilder.process(new Token.EndTag("select"));
/* 1296 */         return param1HtmlTreeBuilder.process(param1Token);
/* 1297 */       }  if (param1Token.isEndTag() && StringUtil.in(param1Token.asEndTag().name(), new String[] { "caption", "table", "tbody", "tfoot", "thead", "tr", "td", "th" })) {
/* 1298 */         param1HtmlTreeBuilder.error(this);
/* 1299 */         if (param1HtmlTreeBuilder.inTableScope(param1Token.asEndTag().name())) {
/* 1300 */           param1HtmlTreeBuilder.process(new Token.EndTag("select"));
/* 1301 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         } 
/* 1303 */         return false;
/*      */       } 
/* 1305 */       return param1HtmlTreeBuilder.process(param1Token, InSelect);
/*      */     }
/*      */   },
/*      */   
/* 1309 */   AfterBody {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1311 */       if (isWhitespace(param1Token))
/* 1312 */         return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1313 */       if (param1Token.isComment())
/* 1314 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/* 1315 */       else { if (param1Token.isDoctype()) {
/* 1316 */           param1HtmlTreeBuilder.error(this);
/* 1317 */           return false;
/* 1318 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html"))
/* 1319 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1320 */         if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("html")) {
/* 1321 */           if (param1HtmlTreeBuilder.isFragmentParsing()) {
/* 1322 */             param1HtmlTreeBuilder.error(this);
/* 1323 */             return false;
/*      */           } 
/* 1325 */           param1HtmlTreeBuilder.transition(AfterAfterBody);
/*      */         }
/* 1327 */         else if (!param1Token.isEOF()) {
/*      */ 
/*      */           
/* 1330 */           param1HtmlTreeBuilder.error(this);
/* 1331 */           param1HtmlTreeBuilder.transition(InBody);
/* 1332 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         }  }
/* 1334 */        return true;
/*      */     }
/*      */   },
/* 1337 */   InFrameset {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1339 */       if (isWhitespace(param1Token))
/* 1340 */       { param1HtmlTreeBuilder.insert(param1Token.asCharacter()); }
/* 1341 */       else if (param1Token.isComment())
/* 1342 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/* 1343 */       else { if (param1Token.isDoctype()) {
/* 1344 */           param1HtmlTreeBuilder.error(this);
/* 1345 */           return false;
/* 1346 */         }  if (param1Token.isStartTag()) {
/* 1347 */           Token.StartTag startTag = param1Token.asStartTag();
/* 1348 */           String str = startTag.name();
/* 1349 */           if (str.equals("html"))
/* 1350 */             return param1HtmlTreeBuilder.process(startTag, InBody); 
/* 1351 */           if (str.equals("frameset"))
/* 1352 */           { param1HtmlTreeBuilder.insert(startTag); }
/* 1353 */           else if (str.equals("frame"))
/* 1354 */           { param1HtmlTreeBuilder.insertEmpty(startTag); }
/* 1355 */           else { if (str.equals("noframes")) {
/* 1356 */               return param1HtmlTreeBuilder.process(startTag, InHead);
/*      */             }
/* 1358 */             param1HtmlTreeBuilder.error(this);
/* 1359 */             return false; }
/*      */         
/* 1361 */         } else if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("frameset")) {
/* 1362 */           if (param1HtmlTreeBuilder.currentElement().nodeName().equals("html")) {
/* 1363 */             param1HtmlTreeBuilder.error(this);
/* 1364 */             return false;
/*      */           } 
/* 1366 */           param1HtmlTreeBuilder.pop();
/* 1367 */           if (!param1HtmlTreeBuilder.isFragmentParsing() && !param1HtmlTreeBuilder.currentElement().nodeName().equals("frameset")) {
/* 1368 */             param1HtmlTreeBuilder.transition(AfterFrameset);
/*      */           }
/*      */         }
/* 1371 */         else if (param1Token.isEOF()) {
/* 1372 */           if (!param1HtmlTreeBuilder.currentElement().nodeName().equals("html")) {
/* 1373 */             param1HtmlTreeBuilder.error(this);
/* 1374 */             return true;
/*      */           } 
/*      */         } else {
/* 1377 */           param1HtmlTreeBuilder.error(this);
/* 1378 */           return false;
/*      */         }  }
/* 1380 */        return true;
/*      */     }
/*      */   },
/* 1383 */   AfterFrameset {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1385 */       if (isWhitespace(param1Token))
/* 1386 */       { param1HtmlTreeBuilder.insert(param1Token.asCharacter()); }
/* 1387 */       else if (param1Token.isComment())
/* 1388 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/* 1389 */       else { if (param1Token.isDoctype()) {
/* 1390 */           param1HtmlTreeBuilder.error(this);
/* 1391 */           return false;
/* 1392 */         }  if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html"))
/* 1393 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1394 */         if (param1Token.isEndTag() && param1Token.asEndTag().name().equals("html"))
/* 1395 */         { param1HtmlTreeBuilder.transition(AfterAfterFrameset); }
/* 1396 */         else { if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("noframes"))
/* 1397 */             return param1HtmlTreeBuilder.process(param1Token, InHead); 
/* 1398 */           if (!param1Token.isEOF())
/*      */           
/*      */           { 
/* 1401 */             param1HtmlTreeBuilder.error(this);
/* 1402 */             return false; }  }
/*      */          }
/* 1404 */        return true;
/*      */     }
/*      */   },
/* 1407 */   AfterAfterBody {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1409 */       if (param1Token.isComment())
/* 1410 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/* 1411 */       else { if (param1Token.isDoctype() || isWhitespace(param1Token) || (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html")))
/* 1412 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1413 */         if (!param1Token.isEOF()) {
/*      */ 
/*      */           
/* 1416 */           param1HtmlTreeBuilder.error(this);
/* 1417 */           param1HtmlTreeBuilder.transition(InBody);
/* 1418 */           return param1HtmlTreeBuilder.process(param1Token);
/*      */         }  }
/* 1420 */        return true;
/*      */     }
/*      */   },
/* 1423 */   AfterAfterFrameset {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1425 */       if (param1Token.isComment())
/* 1426 */       { param1HtmlTreeBuilder.insert(param1Token.asComment()); }
/* 1427 */       else { if (param1Token.isDoctype() || isWhitespace(param1Token) || (param1Token.isStartTag() && param1Token.asStartTag().name().equals("html")))
/* 1428 */           return param1HtmlTreeBuilder.process(param1Token, InBody); 
/* 1429 */         if (!param1Token.isEOF()) {
/*      */           
/* 1431 */           if (param1Token.isStartTag() && param1Token.asStartTag().name().equals("noframes")) {
/* 1432 */             return param1HtmlTreeBuilder.process(param1Token, InHead);
/*      */           }
/* 1434 */           param1HtmlTreeBuilder.error(this);
/* 1435 */           return false;
/*      */         }  }
/* 1437 */        return true;
/*      */     }
/*      */   },
/* 1440 */   ForeignContent {
/*      */     boolean process(Token param1Token, HtmlTreeBuilder param1HtmlTreeBuilder) {
/* 1442 */       return true;
/*      */     } };
/*      */   private static String nullString;
/*      */   
/*      */   static {
/* 1447 */     nullString = String.valueOf(false);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isWhitespace(Token paramToken) {
/* 1452 */     if (paramToken.isCharacter()) {
/* 1453 */       String str = paramToken.asCharacter().getData();
/*      */       
/* 1455 */       for (byte b = 0; b < str.length(); b++) {
/* 1456 */         char c = str.charAt(b);
/* 1457 */         if (!StringUtil.isWhitespace(c))
/* 1458 */           return false; 
/*      */       } 
/* 1460 */       return true;
/*      */     } 
/* 1462 */     return false;
/*      */   }
/*      */   
/*      */   private static void handleRcData(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder) {
/* 1466 */     paramHtmlTreeBuilder.insert(paramStartTag);
/* 1467 */     paramHtmlTreeBuilder.tokeniser.transition(TokeniserState.Rcdata);
/* 1468 */     paramHtmlTreeBuilder.markInsertionMode();
/* 1469 */     paramHtmlTreeBuilder.transition(Text);
/*      */   }
/*      */   
/*      */   private static void handleRawtext(Token.StartTag paramStartTag, HtmlTreeBuilder paramHtmlTreeBuilder) {
/* 1473 */     paramHtmlTreeBuilder.insert(paramStartTag);
/* 1474 */     paramHtmlTreeBuilder.tokeniser.transition(TokeniserState.Rawtext);
/* 1475 */     paramHtmlTreeBuilder.markInsertionMode();
/* 1476 */     paramHtmlTreeBuilder.transition(Text);
/*      */   }
/*      */   
/*      */   abstract boolean process(Token paramToken, HtmlTreeBuilder paramHtmlTreeBuilder);
/*      */   
/*      */   private static final class Constants {
/* 1482 */     private static final String[] InBodyStartToHead = new String[] { "base", "basefont", "bgsound", "command", "link", "meta", "noframes", "script", "style", "title" };
/* 1483 */     private static final String[] InBodyStartPClosers = new String[] { "address", "article", "aside", "blockquote", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "menu", "nav", "ol", "p", "section", "summary", "ul" };
/*      */ 
/*      */     
/* 1486 */     private static final String[] Headings = new String[] { "h1", "h2", "h3", "h4", "h5", "h6" };
/* 1487 */     private static final String[] InBodyStartPreListing = new String[] { "pre", "listing" };
/* 1488 */     private static final String[] InBodyStartLiBreakers = new String[] { "address", "div", "p" };
/* 1489 */     private static final String[] DdDt = new String[] { "dd", "dt" };
/* 1490 */     private static final String[] Formatters = new String[] { "b", "big", "code", "em", "font", "i", "s", "small", "strike", "strong", "tt", "u" };
/* 1491 */     private static final String[] InBodyStartApplets = new String[] { "applet", "marquee", "object" };
/* 1492 */     private static final String[] InBodyStartEmptyFormatters = new String[] { "area", "br", "embed", "img", "keygen", "wbr" };
/* 1493 */     private static final String[] InBodyStartMedia = new String[] { "param", "source", "track" };
/* 1494 */     private static final String[] InBodyStartInputAttribs = new String[] { "name", "action", "prompt" };
/* 1495 */     private static final String[] InBodyStartOptions = new String[] { "optgroup", "option" };
/* 1496 */     private static final String[] InBodyStartRuby = new String[] { "rp", "rt" };
/* 1497 */     private static final String[] InBodyStartDrop = new String[] { "caption", "col", "colgroup", "frame", "head", "tbody", "td", "tfoot", "th", "thead", "tr" };
/* 1498 */     private static final String[] InBodyEndClosers = new String[] { "address", "article", "aside", "blockquote", "button", "center", "details", "dir", "div", "dl", "fieldset", "figcaption", "figure", "footer", "header", "hgroup", "listing", "menu", "nav", "ol", "pre", "section", "summary", "ul" };
/*      */ 
/*      */     
/* 1501 */     private static final String[] InBodyEndAdoptionFormatters = new String[] { "a", "b", "big", "code", "em", "font", "i", "nobr", "s", "small", "strike", "strong", "tt", "u" };
/* 1502 */     private static final String[] InBodyEndTableFosters = new String[] { "table", "tbody", "tfoot", "thead", "tr" };
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\HtmlTreeBuilderState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */