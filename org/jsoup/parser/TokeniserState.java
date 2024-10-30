/*      */ package org.jsoup.parser;
/*      */ 
/*      */ 
/*      */ 
/*      */ enum TokeniserState
/*      */ {
/*    7 */   Data
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   10 */       switch (param1CharacterReader.current()) {
/*      */         case '&':
/*   12 */           param1Tokeniser.advanceTransition(CharacterReferenceInData);
/*      */           return;
/*      */         case '<':
/*   15 */           param1Tokeniser.advanceTransition(TagOpen);
/*      */           return;
/*      */         case '\000':
/*   18 */           param1Tokeniser.error(this);
/*   19 */           param1Tokeniser.emit(param1CharacterReader.consume());
/*      */           return;
/*      */         case '￿':
/*   22 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   25 */       String str = param1CharacterReader.consumeToAny(new char[] { '&', '<', Character.MIN_VALUE });
/*   26 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   31 */   CharacterReferenceInData
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   34 */       char[] arrayOfChar = param1Tokeniser.consumeCharacterReference(null, false);
/*   35 */       if (arrayOfChar == null) {
/*   36 */         param1Tokeniser.emit('&');
/*      */       } else {
/*   38 */         param1Tokeniser.emit(arrayOfChar);
/*   39 */       }  param1Tokeniser.transition(Data);
/*      */     }
/*      */   },
/*   42 */   Rcdata
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   45 */       switch (param1CharacterReader.current()) {
/*      */         case '&':
/*   47 */           param1Tokeniser.advanceTransition(CharacterReferenceInRcdata);
/*      */           return;
/*      */         case '<':
/*   50 */           param1Tokeniser.advanceTransition(RcdataLessthanSign);
/*      */           return;
/*      */         case '\000':
/*   53 */           param1Tokeniser.error(this);
/*   54 */           param1CharacterReader.advance();
/*   55 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*   58 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   61 */       String str = param1CharacterReader.consumeToAny(new char[] { '&', '<', Character.MIN_VALUE });
/*   62 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   67 */   CharacterReferenceInRcdata {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   69 */       char[] arrayOfChar = param1Tokeniser.consumeCharacterReference(null, false);
/*   70 */       if (arrayOfChar == null) {
/*   71 */         param1Tokeniser.emit('&');
/*      */       } else {
/*   73 */         param1Tokeniser.emit(arrayOfChar);
/*   74 */       }  param1Tokeniser.transition(Rcdata);
/*      */     }
/*      */   },
/*   77 */   Rawtext {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*   79 */       switch (param1CharacterReader.current()) {
/*      */         case '<':
/*   81 */           param1Tokeniser.advanceTransition(RawtextLessthanSign);
/*      */           return;
/*      */         case '\000':
/*   84 */           param1Tokeniser.error(this);
/*   85 */           param1CharacterReader.advance();
/*   86 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*   89 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*   92 */       String str = param1CharacterReader.consumeToAny(new char[] { '<', Character.MIN_VALUE });
/*   93 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*   98 */   ScriptData {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  100 */       switch (param1CharacterReader.current()) {
/*      */         case '<':
/*  102 */           param1Tokeniser.advanceTransition(ScriptDataLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  105 */           param1Tokeniser.error(this);
/*  106 */           param1CharacterReader.advance();
/*  107 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*  110 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*  113 */       String str = param1CharacterReader.consumeToAny(new char[] { '<', Character.MIN_VALUE });
/*  114 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*  119 */   PLAINTEXT {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  121 */       switch (param1CharacterReader.current()) {
/*      */         case '\000':
/*  123 */           param1Tokeniser.error(this);
/*  124 */           param1CharacterReader.advance();
/*  125 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*  128 */           param1Tokeniser.emit(new Token.EOF());
/*      */           return;
/*      */       } 
/*  131 */       String str = param1CharacterReader.consumeTo(false);
/*  132 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*  137 */   TagOpen
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  140 */       switch (param1CharacterReader.current()) {
/*      */         case '!':
/*  142 */           param1Tokeniser.advanceTransition(MarkupDeclarationOpen);
/*      */           return;
/*      */         case '/':
/*  145 */           param1Tokeniser.advanceTransition(EndTagOpen);
/*      */           return;
/*      */         case '?':
/*  148 */           param1Tokeniser.advanceTransition(BogusComment);
/*      */           return;
/*      */       } 
/*  151 */       if (param1CharacterReader.matchesLetter()) {
/*  152 */         param1Tokeniser.createTagPending(true);
/*  153 */         param1Tokeniser.transition(TagName);
/*      */       } else {
/*  155 */         param1Tokeniser.error(this);
/*  156 */         param1Tokeniser.emit('<');
/*  157 */         param1Tokeniser.transition(Data);
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */   },
/*  163 */   EndTagOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  165 */       if (param1CharacterReader.isEmpty()) {
/*  166 */         param1Tokeniser.eofError(this);
/*  167 */         param1Tokeniser.emit("</");
/*  168 */         param1Tokeniser.transition(Data);
/*  169 */       } else if (param1CharacterReader.matchesLetter()) {
/*  170 */         param1Tokeniser.createTagPending(false);
/*  171 */         param1Tokeniser.transition(TagName);
/*  172 */       } else if (param1CharacterReader.matches('>')) {
/*  173 */         param1Tokeniser.error(this);
/*  174 */         param1Tokeniser.advanceTransition(Data);
/*      */       } else {
/*  176 */         param1Tokeniser.error(this);
/*  177 */         param1Tokeniser.advanceTransition(BogusComment);
/*      */       } 
/*      */     }
/*      */   },
/*  181 */   TagName
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader)
/*      */     {
/*  185 */       String str = param1CharacterReader.consumeToAny(new char[] { '\t', '\n', '\r', '\f', ' ', '/', '>', Character.MIN_VALUE }).toLowerCase();
/*  186 */       param1Tokeniser.tagPending.appendTagName(str);
/*      */       
/*  188 */       switch (param1CharacterReader.consume()) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  194 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           break;
/*      */         case '/':
/*  197 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           break;
/*      */         case '>':
/*  200 */           param1Tokeniser.emitTagPending();
/*  201 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '\000':
/*  204 */           param1Tokeniser.tagPending.appendTagName(TokeniserState.replacementStr);
/*      */           break;
/*      */         case '￿':
/*  207 */           param1Tokeniser.eofError(this);
/*  208 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */       } 
/*      */     }
/*      */   },
/*  213 */   RcdataLessthanSign
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  216 */       if (param1CharacterReader.matches('/')) {
/*  217 */         param1Tokeniser.createTempBuffer();
/*  218 */         param1Tokeniser.advanceTransition(RCDATAEndTagOpen);
/*  219 */       } else if (param1CharacterReader.matchesLetter() && param1Tokeniser.appropriateEndTagName() != null && !param1CharacterReader.containsIgnoreCase("</" + param1Tokeniser.appropriateEndTagName())) {
/*      */ 
/*      */         
/*  222 */         param1Tokeniser.tagPending = new Token.EndTag(param1Tokeniser.appropriateEndTagName());
/*  223 */         param1Tokeniser.emitTagPending();
/*  224 */         param1CharacterReader.unconsume();
/*  225 */         param1Tokeniser.transition(Data);
/*      */       } else {
/*  227 */         param1Tokeniser.emit("<");
/*  228 */         param1Tokeniser.transition(Rcdata);
/*      */       } 
/*      */     }
/*      */   },
/*  232 */   RCDATAEndTagOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  234 */       if (param1CharacterReader.matchesLetter()) {
/*  235 */         param1Tokeniser.createTagPending(false);
/*  236 */         param1Tokeniser.tagPending.appendTagName(Character.toLowerCase(param1CharacterReader.current()));
/*  237 */         param1Tokeniser.dataBuffer.append(Character.toLowerCase(param1CharacterReader.current()));
/*  238 */         param1Tokeniser.advanceTransition(RCDATAEndTagName);
/*      */       } else {
/*  240 */         param1Tokeniser.emit("</");
/*  241 */         param1Tokeniser.transition(Rcdata);
/*      */       } 
/*      */     }
/*      */   },
/*  245 */   RCDATAEndTagName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  247 */       if (param1CharacterReader.matchesLetter()) {
/*  248 */         String str = param1CharacterReader.consumeLetterSequence();
/*  249 */         param1Tokeniser.tagPending.appendTagName(str.toLowerCase());
/*  250 */         param1Tokeniser.dataBuffer.append(str);
/*      */         
/*      */         return;
/*      */       } 
/*  254 */       char c = param1CharacterReader.consume();
/*  255 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  261 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  262 */             param1Tokeniser.transition(BeforeAttributeName);
/*      */           } else {
/*  264 */             anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           }  return;
/*      */         case '/':
/*  267 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  268 */             param1Tokeniser.transition(SelfClosingStartTag);
/*      */           } else {
/*  270 */             anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           }  return;
/*      */         case '>':
/*  273 */           if (param1Tokeniser.isAppropriateEndTagToken()) {
/*  274 */             param1Tokeniser.emitTagPending();
/*  275 */             param1Tokeniser.transition(Data);
/*      */           } else {
/*      */             
/*  278 */             anythingElse(param1Tokeniser, param1CharacterReader);
/*      */           }  return;
/*      */       } 
/*  281 */       anythingElse(param1Tokeniser, param1CharacterReader);
/*      */     }
/*      */ 
/*      */     
/*      */     private void anythingElse(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  286 */       param1Tokeniser.emit("</" + param1Tokeniser.dataBuffer.toString());
/*  287 */       param1CharacterReader.unconsume();
/*  288 */       param1Tokeniser.transition(Rcdata);
/*      */     }
/*      */   },
/*  291 */   RawtextLessthanSign {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  293 */       if (param1CharacterReader.matches('/')) {
/*  294 */         param1Tokeniser.createTempBuffer();
/*  295 */         param1Tokeniser.advanceTransition(RawtextEndTagOpen);
/*      */       } else {
/*  297 */         param1Tokeniser.emit('<');
/*  298 */         param1Tokeniser.transition(Rawtext);
/*      */       } 
/*      */     }
/*      */   },
/*  302 */   RawtextEndTagOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  304 */       if (param1CharacterReader.matchesLetter()) {
/*  305 */         param1Tokeniser.createTagPending(false);
/*  306 */         param1Tokeniser.transition(RawtextEndTagName);
/*      */       } else {
/*  308 */         param1Tokeniser.emit("</");
/*  309 */         param1Tokeniser.transition(Rawtext);
/*      */       } 
/*      */     }
/*      */   },
/*  313 */   RawtextEndTagName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  315 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, Rawtext);
/*      */     }
/*      */   },
/*  318 */   ScriptDataLessthanSign {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  320 */       switch (param1CharacterReader.consume()) {
/*      */         case '/':
/*  322 */           param1Tokeniser.createTempBuffer();
/*  323 */           param1Tokeniser.transition(ScriptDataEndTagOpen);
/*      */           return;
/*      */         case '!':
/*  326 */           param1Tokeniser.emit("<!");
/*  327 */           param1Tokeniser.transition(ScriptDataEscapeStart);
/*      */           return;
/*      */       } 
/*  330 */       param1Tokeniser.emit("<");
/*  331 */       param1CharacterReader.unconsume();
/*  332 */       param1Tokeniser.transition(ScriptData);
/*      */     }
/*      */   },
/*      */   
/*  336 */   ScriptDataEndTagOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  338 */       if (param1CharacterReader.matchesLetter()) {
/*  339 */         param1Tokeniser.createTagPending(false);
/*  340 */         param1Tokeniser.transition(ScriptDataEndTagName);
/*      */       } else {
/*  342 */         param1Tokeniser.emit("</");
/*  343 */         param1Tokeniser.transition(ScriptData);
/*      */       }
/*      */     
/*      */     }
/*      */   },
/*  348 */   ScriptDataEndTagName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  350 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, ScriptData);
/*      */     }
/*      */   },
/*  353 */   ScriptDataEscapeStart {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  355 */       if (param1CharacterReader.matches('-')) {
/*  356 */         param1Tokeniser.emit('-');
/*  357 */         param1Tokeniser.advanceTransition(ScriptDataEscapeStartDash);
/*      */       } else {
/*  359 */         param1Tokeniser.transition(ScriptData);
/*      */       } 
/*      */     }
/*      */   },
/*  363 */   ScriptDataEscapeStartDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  365 */       if (param1CharacterReader.matches('-')) {
/*  366 */         param1Tokeniser.emit('-');
/*  367 */         param1Tokeniser.advanceTransition(ScriptDataEscapedDashDash);
/*      */       } else {
/*  369 */         param1Tokeniser.transition(ScriptData);
/*      */       } 
/*      */     }
/*      */   },
/*  373 */   ScriptDataEscaped {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  375 */       if (param1CharacterReader.isEmpty()) {
/*  376 */         param1Tokeniser.eofError(this);
/*  377 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*  381 */       switch (param1CharacterReader.current()) {
/*      */         case '-':
/*  383 */           param1Tokeniser.emit('-');
/*  384 */           param1Tokeniser.advanceTransition(ScriptDataEscapedDash);
/*      */           return;
/*      */         case '<':
/*  387 */           param1Tokeniser.advanceTransition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  390 */           param1Tokeniser.error(this);
/*  391 */           param1CharacterReader.advance();
/*  392 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */       } 
/*  395 */       String str = param1CharacterReader.consumeToAny(new char[] { '-', '<', Character.MIN_VALUE });
/*  396 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */   
/*  400 */   ScriptDataEscapedDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  402 */       if (param1CharacterReader.isEmpty()) {
/*  403 */         param1Tokeniser.eofError(this);
/*  404 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*  408 */       char c = param1CharacterReader.consume();
/*  409 */       switch (c) {
/*      */         case '-':
/*  411 */           param1Tokeniser.emit(c);
/*  412 */           param1Tokeniser.transition(ScriptDataEscapedDashDash);
/*      */           return;
/*      */         case '<':
/*  415 */           param1Tokeniser.transition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  418 */           param1Tokeniser.error(this);
/*  419 */           param1Tokeniser.emit('�');
/*  420 */           param1Tokeniser.transition(ScriptDataEscaped);
/*      */           return;
/*      */       } 
/*  423 */       param1Tokeniser.emit(c);
/*  424 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  428 */   ScriptDataEscapedDashDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  430 */       if (param1CharacterReader.isEmpty()) {
/*  431 */         param1Tokeniser.eofError(this);
/*  432 */         param1Tokeniser.transition(Data);
/*      */         
/*      */         return;
/*      */       } 
/*  436 */       char c = param1CharacterReader.consume();
/*  437 */       switch (c) {
/*      */         case '-':
/*  439 */           param1Tokeniser.emit(c);
/*      */           return;
/*      */         case '<':
/*  442 */           param1Tokeniser.transition(ScriptDataEscapedLessthanSign);
/*      */           return;
/*      */         case '>':
/*  445 */           param1Tokeniser.emit(c);
/*  446 */           param1Tokeniser.transition(ScriptData);
/*      */           return;
/*      */         case '\000':
/*  449 */           param1Tokeniser.error(this);
/*  450 */           param1Tokeniser.emit('�');
/*  451 */           param1Tokeniser.transition(ScriptDataEscaped);
/*      */           return;
/*      */       } 
/*  454 */       param1Tokeniser.emit(c);
/*  455 */       param1Tokeniser.transition(ScriptDataEscaped);
/*      */     }
/*      */   },
/*      */   
/*  459 */   ScriptDataEscapedLessthanSign {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  461 */       if (param1CharacterReader.matchesLetter()) {
/*  462 */         param1Tokeniser.createTempBuffer();
/*  463 */         param1Tokeniser.dataBuffer.append(Character.toLowerCase(param1CharacterReader.current()));
/*  464 */         param1Tokeniser.emit("<" + param1CharacterReader.current());
/*  465 */         param1Tokeniser.advanceTransition(ScriptDataDoubleEscapeStart);
/*  466 */       } else if (param1CharacterReader.matches('/')) {
/*  467 */         param1Tokeniser.createTempBuffer();
/*  468 */         param1Tokeniser.advanceTransition(ScriptDataEscapedEndTagOpen);
/*      */       } else {
/*  470 */         param1Tokeniser.emit('<');
/*  471 */         param1Tokeniser.transition(ScriptDataEscaped);
/*      */       } 
/*      */     }
/*      */   },
/*  475 */   ScriptDataEscapedEndTagOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  477 */       if (param1CharacterReader.matchesLetter()) {
/*  478 */         param1Tokeniser.createTagPending(false);
/*  479 */         param1Tokeniser.tagPending.appendTagName(Character.toLowerCase(param1CharacterReader.current()));
/*  480 */         param1Tokeniser.dataBuffer.append(param1CharacterReader.current());
/*  481 */         param1Tokeniser.advanceTransition(ScriptDataEscapedEndTagName);
/*      */       } else {
/*  483 */         param1Tokeniser.emit("</");
/*  484 */         param1Tokeniser.transition(ScriptDataEscaped);
/*      */       } 
/*      */     }
/*      */   },
/*  488 */   ScriptDataEscapedEndTagName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  490 */       handleDataEndTag(param1Tokeniser, param1CharacterReader, ScriptDataEscaped);
/*      */     }
/*      */   },
/*  493 */   ScriptDataDoubleEscapeStart {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  495 */       handleDataDoubleEscapeTag(param1Tokeniser, param1CharacterReader, ScriptDataDoubleEscaped, ScriptDataEscaped);
/*      */     }
/*      */   },
/*  498 */   ScriptDataDoubleEscaped {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  500 */       char c = param1CharacterReader.current();
/*  501 */       switch (c) {
/*      */         case '-':
/*  503 */           param1Tokeniser.emit(c);
/*  504 */           param1Tokeniser.advanceTransition(ScriptDataDoubleEscapedDash);
/*      */           return;
/*      */         case '<':
/*  507 */           param1Tokeniser.emit(c);
/*  508 */           param1Tokeniser.advanceTransition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  511 */           param1Tokeniser.error(this);
/*  512 */           param1CharacterReader.advance();
/*  513 */           param1Tokeniser.emit('�');
/*      */           return;
/*      */         case '￿':
/*  516 */           param1Tokeniser.eofError(this);
/*  517 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  520 */       String str = param1CharacterReader.consumeToAny(new char[] { '-', '<', Character.MIN_VALUE });
/*  521 */       param1Tokeniser.emit(str);
/*      */     }
/*      */   },
/*      */   
/*  525 */   ScriptDataDoubleEscapedDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  527 */       char c = param1CharacterReader.consume();
/*  528 */       switch (c) {
/*      */         case '-':
/*  530 */           param1Tokeniser.emit(c);
/*  531 */           param1Tokeniser.transition(ScriptDataDoubleEscapedDashDash);
/*      */           return;
/*      */         case '<':
/*  534 */           param1Tokeniser.emit(c);
/*  535 */           param1Tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '\000':
/*  538 */           param1Tokeniser.error(this);
/*  539 */           param1Tokeniser.emit('�');
/*  540 */           param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */           return;
/*      */         case '￿':
/*  543 */           param1Tokeniser.eofError(this);
/*  544 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  547 */       param1Tokeniser.emit(c);
/*  548 */       param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*      */   
/*  552 */   ScriptDataDoubleEscapedDashDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  554 */       char c = param1CharacterReader.consume();
/*  555 */       switch (c) {
/*      */         case '-':
/*  557 */           param1Tokeniser.emit(c);
/*      */           return;
/*      */         case '<':
/*  560 */           param1Tokeniser.emit(c);
/*  561 */           param1Tokeniser.transition(ScriptDataDoubleEscapedLessthanSign);
/*      */           return;
/*      */         case '>':
/*  564 */           param1Tokeniser.emit(c);
/*  565 */           param1Tokeniser.transition(ScriptData);
/*      */           return;
/*      */         case '\000':
/*  568 */           param1Tokeniser.error(this);
/*  569 */           param1Tokeniser.emit('�');
/*  570 */           param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */           return;
/*      */         case '￿':
/*  573 */           param1Tokeniser.eofError(this);
/*  574 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  577 */       param1Tokeniser.emit(c);
/*  578 */       param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*      */   
/*  582 */   ScriptDataDoubleEscapedLessthanSign {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  584 */       if (param1CharacterReader.matches('/')) {
/*  585 */         param1Tokeniser.emit('/');
/*  586 */         param1Tokeniser.createTempBuffer();
/*  587 */         param1Tokeniser.advanceTransition(ScriptDataDoubleEscapeEnd);
/*      */       } else {
/*  589 */         param1Tokeniser.transition(ScriptDataDoubleEscaped);
/*      */       } 
/*      */     }
/*      */   },
/*  593 */   ScriptDataDoubleEscapeEnd {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  595 */       handleDataDoubleEscapeTag(param1Tokeniser, param1CharacterReader, ScriptDataEscaped, ScriptDataDoubleEscaped);
/*      */     }
/*      */   },
/*  598 */   BeforeAttributeName
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  601 */       char c = param1CharacterReader.consume();
/*  602 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '/':
/*  610 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */         
/*      */         case '>':
/*  613 */           param1Tokeniser.emitTagPending();
/*  614 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '\000':
/*  617 */           param1Tokeniser.error(this);
/*  618 */           param1Tokeniser.tagPending.newAttribute();
/*  619 */           param1CharacterReader.unconsume();
/*  620 */           param1Tokeniser.transition(AttributeName);
/*      */         
/*      */         case '￿':
/*  623 */           param1Tokeniser.eofError(this);
/*  624 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*      */         case '=':
/*  630 */           param1Tokeniser.error(this);
/*  631 */           param1Tokeniser.tagPending.newAttribute();
/*  632 */           param1Tokeniser.tagPending.appendAttributeName(c);
/*  633 */           param1Tokeniser.transition(AttributeName);
/*      */       } 
/*      */       
/*  636 */       param1Tokeniser.tagPending.newAttribute();
/*  637 */       param1CharacterReader.unconsume();
/*  638 */       param1Tokeniser.transition(AttributeName);
/*      */     }
/*      */   },
/*      */   
/*  642 */   AttributeName
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  645 */       String str = param1CharacterReader.consumeToAny(new char[] { '\t', '\n', '\r', '\f', ' ', '/', '=', '>', Character.MIN_VALUE, '"', '\'', '<' });
/*  646 */       param1Tokeniser.tagPending.appendAttributeName(str.toLowerCase());
/*      */       
/*  648 */       char c = param1CharacterReader.consume();
/*  649 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  655 */           param1Tokeniser.transition(AfterAttributeName);
/*      */           break;
/*      */         case '/':
/*  658 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           break;
/*      */         case '=':
/*  661 */           param1Tokeniser.transition(BeforeAttributeValue);
/*      */           break;
/*      */         case '>':
/*  664 */           param1Tokeniser.emitTagPending();
/*  665 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '\000':
/*  668 */           param1Tokeniser.error(this);
/*  669 */           param1Tokeniser.tagPending.appendAttributeName('�');
/*      */           break;
/*      */         case '￿':
/*  672 */           param1Tokeniser.eofError(this);
/*  673 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*  678 */           param1Tokeniser.error(this);
/*  679 */           param1Tokeniser.tagPending.appendAttributeName(c);
/*      */           break;
/*      */       } 
/*      */     }
/*      */   },
/*  684 */   AfterAttributeName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  686 */       char c = param1CharacterReader.consume();
/*  687 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '/':
/*  696 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */         
/*      */         case '=':
/*  699 */           param1Tokeniser.transition(BeforeAttributeValue);
/*      */         
/*      */         case '>':
/*  702 */           param1Tokeniser.emitTagPending();
/*  703 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '\000':
/*  706 */           param1Tokeniser.error(this);
/*  707 */           param1Tokeniser.tagPending.appendAttributeName('�');
/*  708 */           param1Tokeniser.transition(AttributeName);
/*      */         
/*      */         case '￿':
/*  711 */           param1Tokeniser.eofError(this);
/*  712 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*  717 */           param1Tokeniser.error(this);
/*  718 */           param1Tokeniser.tagPending.newAttribute();
/*  719 */           param1Tokeniser.tagPending.appendAttributeName(c);
/*  720 */           param1Tokeniser.transition(AttributeName);
/*      */       } 
/*      */       
/*  723 */       param1Tokeniser.tagPending.newAttribute();
/*  724 */       param1CharacterReader.unconsume();
/*  725 */       param1Tokeniser.transition(AttributeName);
/*      */     }
/*      */   },
/*      */   
/*  729 */   BeforeAttributeValue {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  731 */       char c = param1CharacterReader.consume();
/*  732 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/*  741 */           param1Tokeniser.transition(AttributeValue_doubleQuoted);
/*      */         
/*      */         case '&':
/*  744 */           param1CharacterReader.unconsume();
/*  745 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */         
/*      */         case '\'':
/*  748 */           param1Tokeniser.transition(AttributeValue_singleQuoted);
/*      */         
/*      */         case '\000':
/*  751 */           param1Tokeniser.error(this);
/*  752 */           param1Tokeniser.tagPending.appendAttributeValue('�');
/*  753 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */         
/*      */         case '￿':
/*  756 */           param1Tokeniser.eofError(this);
/*  757 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '>':
/*  760 */           param1Tokeniser.error(this);
/*  761 */           param1Tokeniser.emitTagPending();
/*  762 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '<':
/*      */         case '=':
/*      */         case '`':
/*  767 */           param1Tokeniser.error(this);
/*  768 */           param1Tokeniser.tagPending.appendAttributeValue(c);
/*  769 */           param1Tokeniser.transition(AttributeValue_unquoted);
/*      */       } 
/*      */       
/*  772 */       param1CharacterReader.unconsume();
/*  773 */       param1Tokeniser.transition(AttributeValue_unquoted);
/*      */     }
/*      */   },
/*      */   
/*  777 */   AttributeValue_doubleQuoted { void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char[] arrayOfChar;
/*  779 */       String str = param1CharacterReader.consumeToAny(new char[] { '"', '&', Character.MIN_VALUE });
/*  780 */       if (str.length() > 0) {
/*  781 */         param1Tokeniser.tagPending.appendAttributeValue(str);
/*      */       }
/*  783 */       char c = param1CharacterReader.consume();
/*  784 */       switch (c) {
/*      */         case '"':
/*  786 */           param1Tokeniser.transition(AfterAttributeValue_quoted);
/*      */           break;
/*      */         case '&':
/*  789 */           arrayOfChar = param1Tokeniser.consumeCharacterReference(Character.valueOf('"'), true);
/*  790 */           if (arrayOfChar != null) {
/*  791 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfChar); break;
/*      */           } 
/*  793 */           param1Tokeniser.tagPending.appendAttributeValue('&');
/*      */           break;
/*      */         case '\000':
/*  796 */           param1Tokeniser.error(this);
/*  797 */           param1Tokeniser.tagPending.appendAttributeValue('�');
/*      */           break;
/*      */         case '￿':
/*  800 */           param1Tokeniser.eofError(this);
/*  801 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */       } 
/*      */     
/*      */     } }
/*      */   ,
/*  807 */   AttributeValue_singleQuoted { void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char[] arrayOfChar;
/*  809 */       String str = param1CharacterReader.consumeToAny(new char[] { '\'', '&', Character.MIN_VALUE });
/*  810 */       if (str.length() > 0) {
/*  811 */         param1Tokeniser.tagPending.appendAttributeValue(str);
/*      */       }
/*  813 */       char c = param1CharacterReader.consume();
/*  814 */       switch (c) {
/*      */         case '\'':
/*  816 */           param1Tokeniser.transition(AfterAttributeValue_quoted);
/*      */           break;
/*      */         case '&':
/*  819 */           arrayOfChar = param1Tokeniser.consumeCharacterReference(Character.valueOf('\''), true);
/*  820 */           if (arrayOfChar != null) {
/*  821 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfChar); break;
/*      */           } 
/*  823 */           param1Tokeniser.tagPending.appendAttributeValue('&');
/*      */           break;
/*      */         case '\000':
/*  826 */           param1Tokeniser.error(this);
/*  827 */           param1Tokeniser.tagPending.appendAttributeValue('�');
/*      */           break;
/*      */         case '￿':
/*  830 */           param1Tokeniser.eofError(this);
/*  831 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */       } 
/*      */     
/*      */     } }
/*      */   ,
/*  837 */   AttributeValue_unquoted { void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*      */       char[] arrayOfChar;
/*  839 */       String str = param1CharacterReader.consumeToAny(new char[] { '\t', '\n', '\r', '\f', ' ', '&', '>', Character.MIN_VALUE, '"', '\'', '<', '=', '`' });
/*  840 */       if (str.length() > 0) {
/*  841 */         param1Tokeniser.tagPending.appendAttributeValue(str);
/*      */       }
/*  843 */       char c = param1CharacterReader.consume();
/*  844 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  850 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           break;
/*      */         case '&':
/*  853 */           arrayOfChar = param1Tokeniser.consumeCharacterReference(Character.valueOf('>'), true);
/*  854 */           if (arrayOfChar != null) {
/*  855 */             param1Tokeniser.tagPending.appendAttributeValue(arrayOfChar); break;
/*      */           } 
/*  857 */           param1Tokeniser.tagPending.appendAttributeValue('&');
/*      */           break;
/*      */         case '>':
/*  860 */           param1Tokeniser.emitTagPending();
/*  861 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '\000':
/*  864 */           param1Tokeniser.error(this);
/*  865 */           param1Tokeniser.tagPending.appendAttributeValue('�');
/*      */           break;
/*      */         case '￿':
/*  868 */           param1Tokeniser.eofError(this);
/*  869 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '"':
/*      */         case '\'':
/*      */         case '<':
/*      */         case '=':
/*      */         case '`':
/*  876 */           param1Tokeniser.error(this);
/*  877 */           param1Tokeniser.tagPending.appendAttributeValue(c);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */     
/*      */     } }
/*      */   ,
/*  885 */   AfterAttributeValue_quoted {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  887 */       char c = param1CharacterReader.consume();
/*  888 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*  894 */           param1Tokeniser.transition(BeforeAttributeName);
/*      */           return;
/*      */         case '/':
/*  897 */           param1Tokeniser.transition(SelfClosingStartTag);
/*      */           return;
/*      */         case '>':
/*  900 */           param1Tokeniser.emitTagPending();
/*  901 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  904 */           param1Tokeniser.eofError(this);
/*  905 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  908 */       param1Tokeniser.error(this);
/*  909 */       param1CharacterReader.unconsume();
/*  910 */       param1Tokeniser.transition(BeforeAttributeName);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/*  915 */   SelfClosingStartTag {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  917 */       char c = param1CharacterReader.consume();
/*  918 */       switch (c) {
/*      */         case '>':
/*  920 */           param1Tokeniser.tagPending.selfClosing = true;
/*  921 */           param1Tokeniser.emitTagPending();
/*  922 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  925 */           param1Tokeniser.eofError(this);
/*  926 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  929 */       param1Tokeniser.error(this);
/*  930 */       param1Tokeniser.transition(BeforeAttributeName);
/*      */     }
/*      */   },
/*      */   
/*  934 */   BogusComment
/*      */   {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader)
/*      */     {
/*  938 */       param1CharacterReader.unconsume();
/*  939 */       Token.Comment comment = new Token.Comment();
/*  940 */       comment.bogus = true;
/*  941 */       comment.data.append(param1CharacterReader.consumeTo('>'));
/*      */       
/*  943 */       param1Tokeniser.emit(comment);
/*  944 */       param1Tokeniser.advanceTransition(Data);
/*      */     }
/*      */   },
/*  947 */   MarkupDeclarationOpen {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  949 */       if (param1CharacterReader.matchConsume("--")) {
/*  950 */         param1Tokeniser.createCommentPending();
/*  951 */         param1Tokeniser.transition(CommentStart);
/*  952 */       } else if (param1CharacterReader.matchConsumeIgnoreCase("DOCTYPE")) {
/*  953 */         param1Tokeniser.transition(Doctype);
/*  954 */       } else if (param1CharacterReader.matchConsume("[CDATA[")) {
/*      */ 
/*      */ 
/*      */         
/*  958 */         param1Tokeniser.transition(CdataSection);
/*      */       } else {
/*  960 */         param1Tokeniser.error(this);
/*  961 */         param1Tokeniser.advanceTransition(BogusComment);
/*      */       } 
/*      */     }
/*      */   },
/*  965 */   CommentStart {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  967 */       char c = param1CharacterReader.consume();
/*  968 */       switch (c) {
/*      */         case '-':
/*  970 */           param1Tokeniser.transition(CommentStartDash);
/*      */           return;
/*      */         case '\000':
/*  973 */           param1Tokeniser.error(this);
/*  974 */           param1Tokeniser.commentPending.data.append('�');
/*  975 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '>':
/*  978 */           param1Tokeniser.error(this);
/*  979 */           param1Tokeniser.emitCommentPending();
/*  980 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/*  983 */           param1Tokeniser.eofError(this);
/*  984 */           param1Tokeniser.emitCommentPending();
/*  985 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/*  988 */       param1Tokeniser.commentPending.data.append(c);
/*  989 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/*  993 */   CommentStartDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/*  995 */       char c = param1CharacterReader.consume();
/*  996 */       switch (c) {
/*      */         case '-':
/*  998 */           param1Tokeniser.transition(CommentStartDash);
/*      */           return;
/*      */         case '\000':
/* 1001 */           param1Tokeniser.error(this);
/* 1002 */           param1Tokeniser.commentPending.data.append('�');
/* 1003 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '>':
/* 1006 */           param1Tokeniser.error(this);
/* 1007 */           param1Tokeniser.emitCommentPending();
/* 1008 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1011 */           param1Tokeniser.eofError(this);
/* 1012 */           param1Tokeniser.emitCommentPending();
/* 1013 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1016 */       param1Tokeniser.commentPending.data.append(c);
/* 1017 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1021 */   Comment {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1023 */       char c = param1CharacterReader.current();
/* 1024 */       switch (c) {
/*      */         case '-':
/* 1026 */           param1Tokeniser.advanceTransition(CommentEndDash);
/*      */           return;
/*      */         case '\000':
/* 1029 */           param1Tokeniser.error(this);
/* 1030 */           param1CharacterReader.advance();
/* 1031 */           param1Tokeniser.commentPending.data.append('�');
/*      */           return;
/*      */         case '￿':
/* 1034 */           param1Tokeniser.eofError(this);
/* 1035 */           param1Tokeniser.emitCommentPending();
/* 1036 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1039 */       param1Tokeniser.commentPending.data.append(param1CharacterReader.consumeToAny(new char[] { '-', Character.MIN_VALUE
/*      */             }));
/*      */     }
/*      */   },
/* 1043 */   CommentEndDash {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1045 */       char c = param1CharacterReader.consume();
/* 1046 */       switch (c) {
/*      */         case '-':
/* 1048 */           param1Tokeniser.transition(CommentEnd);
/*      */           return;
/*      */         case '\000':
/* 1051 */           param1Tokeniser.error(this);
/* 1052 */           param1Tokeniser.commentPending.data.append('-').append('�');
/* 1053 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '￿':
/* 1056 */           param1Tokeniser.eofError(this);
/* 1057 */           param1Tokeniser.emitCommentPending();
/* 1058 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1061 */       param1Tokeniser.commentPending.data.append('-').append(c);
/* 1062 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1066 */   CommentEnd {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1068 */       char c = param1CharacterReader.consume();
/* 1069 */       switch (c) {
/*      */         case '>':
/* 1071 */           param1Tokeniser.emitCommentPending();
/* 1072 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/* 1075 */           param1Tokeniser.error(this);
/* 1076 */           param1Tokeniser.commentPending.data.append("--").append('�');
/* 1077 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '!':
/* 1080 */           param1Tokeniser.error(this);
/* 1081 */           param1Tokeniser.transition(CommentEndBang);
/*      */           return;
/*      */         case '-':
/* 1084 */           param1Tokeniser.error(this);
/* 1085 */           param1Tokeniser.commentPending.data.append('-');
/*      */           return;
/*      */         case '￿':
/* 1088 */           param1Tokeniser.eofError(this);
/* 1089 */           param1Tokeniser.emitCommentPending();
/* 1090 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1093 */       param1Tokeniser.error(this);
/* 1094 */       param1Tokeniser.commentPending.data.append("--").append(c);
/* 1095 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1099 */   CommentEndBang {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1101 */       char c = param1CharacterReader.consume();
/* 1102 */       switch (c) {
/*      */         case '-':
/* 1104 */           param1Tokeniser.commentPending.data.append("--!");
/* 1105 */           param1Tokeniser.transition(CommentEndDash);
/*      */           return;
/*      */         case '>':
/* 1108 */           param1Tokeniser.emitCommentPending();
/* 1109 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\000':
/* 1112 */           param1Tokeniser.error(this);
/* 1113 */           param1Tokeniser.commentPending.data.append("--!").append('�');
/* 1114 */           param1Tokeniser.transition(Comment);
/*      */           return;
/*      */         case '￿':
/* 1117 */           param1Tokeniser.eofError(this);
/* 1118 */           param1Tokeniser.emitCommentPending();
/* 1119 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1122 */       param1Tokeniser.commentPending.data.append("--!").append(c);
/* 1123 */       param1Tokeniser.transition(Comment);
/*      */     }
/*      */   },
/*      */   
/* 1127 */   Doctype {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1129 */       char c = param1CharacterReader.consume();
/* 1130 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1136 */           param1Tokeniser.transition(BeforeDoctypeName);
/*      */           return;
/*      */         case '￿':
/* 1139 */           param1Tokeniser.eofError(this);
/*      */         
/*      */         case '>':
/* 1142 */           param1Tokeniser.error(this);
/* 1143 */           param1Tokeniser.createDoctypePending();
/* 1144 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1145 */           param1Tokeniser.emitDoctypePending();
/* 1146 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1149 */       param1Tokeniser.error(this);
/* 1150 */       param1Tokeniser.transition(BeforeDoctypeName);
/*      */     }
/*      */   },
/*      */   
/* 1154 */   BeforeDoctypeName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1156 */       if (param1CharacterReader.matchesLetter()) {
/* 1157 */         param1Tokeniser.createDoctypePending();
/* 1158 */         param1Tokeniser.transition(DoctypeName);
/*      */         return;
/*      */       } 
/* 1161 */       char c = param1CharacterReader.consume();
/* 1162 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '\000':
/* 1170 */           param1Tokeniser.error(this);
/* 1171 */           param1Tokeniser.createDoctypePending();
/* 1172 */           param1Tokeniser.doctypePending.name.append('�');
/* 1173 */           param1Tokeniser.transition(DoctypeName);
/*      */         
/*      */         case '￿':
/* 1176 */           param1Tokeniser.eofError(this);
/* 1177 */           param1Tokeniser.createDoctypePending();
/* 1178 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1179 */           param1Tokeniser.emitDoctypePending();
/* 1180 */           param1Tokeniser.transition(Data);
/*      */       } 
/*      */       
/* 1183 */       param1Tokeniser.createDoctypePending();
/* 1184 */       param1Tokeniser.doctypePending.name.append(c);
/* 1185 */       param1Tokeniser.transition(DoctypeName);
/*      */     }
/*      */   },
/*      */   
/* 1189 */   DoctypeName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1191 */       if (param1CharacterReader.matchesLetter()) {
/* 1192 */         String str = param1CharacterReader.consumeLetterSequence();
/* 1193 */         param1Tokeniser.doctypePending.name.append(str.toLowerCase());
/*      */         return;
/*      */       } 
/* 1196 */       char c = param1CharacterReader.consume();
/* 1197 */       switch (c) {
/*      */         case '>':
/* 1199 */           param1Tokeniser.emitDoctypePending();
/* 1200 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1207 */           param1Tokeniser.transition(AfterDoctypeName);
/*      */           return;
/*      */         case '\000':
/* 1210 */           param1Tokeniser.error(this);
/* 1211 */           param1Tokeniser.doctypePending.name.append('�');
/*      */           return;
/*      */         case '￿':
/* 1214 */           param1Tokeniser.eofError(this);
/* 1215 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1216 */           param1Tokeniser.emitDoctypePending();
/* 1217 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1220 */       param1Tokeniser.doctypePending.name.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1224 */   AfterDoctypeName {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1226 */       if (param1CharacterReader.isEmpty()) {
/* 1227 */         param1Tokeniser.eofError(this);
/* 1228 */         param1Tokeniser.doctypePending.forceQuirks = true;
/* 1229 */         param1Tokeniser.emitDoctypePending();
/* 1230 */         param1Tokeniser.transition(Data);
/*      */         return;
/*      */       } 
/* 1233 */       if (param1CharacterReader.matchesAny(new char[] { '\t', '\n', '\r', '\f', ' ' })) {
/* 1234 */         param1CharacterReader.advance();
/* 1235 */       } else if (param1CharacterReader.matches('>')) {
/* 1236 */         param1Tokeniser.emitDoctypePending();
/* 1237 */         param1Tokeniser.advanceTransition(Data);
/* 1238 */       } else if (param1CharacterReader.matchConsumeIgnoreCase("PUBLIC")) {
/* 1239 */         param1Tokeniser.transition(AfterDoctypePublicKeyword);
/* 1240 */       } else if (param1CharacterReader.matchConsumeIgnoreCase("SYSTEM")) {
/* 1241 */         param1Tokeniser.transition(AfterDoctypeSystemKeyword);
/*      */       } else {
/* 1243 */         param1Tokeniser.error(this);
/* 1244 */         param1Tokeniser.doctypePending.forceQuirks = true;
/* 1245 */         param1Tokeniser.advanceTransition(BogusDoctype);
/*      */       }
/*      */     
/*      */     }
/*      */   },
/* 1250 */   AfterDoctypePublicKeyword {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1252 */       char c = param1CharacterReader.consume();
/* 1253 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1259 */           param1Tokeniser.transition(BeforeDoctypePublicIdentifier);
/*      */           return;
/*      */         case '"':
/* 1262 */           param1Tokeniser.error(this);
/*      */           
/* 1264 */           param1Tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1267 */           param1Tokeniser.error(this);
/*      */           
/* 1269 */           param1Tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
/*      */           return;
/*      */         case '>':
/* 1272 */           param1Tokeniser.error(this);
/* 1273 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1274 */           param1Tokeniser.emitDoctypePending();
/* 1275 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1278 */           param1Tokeniser.eofError(this);
/* 1279 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1280 */           param1Tokeniser.emitDoctypePending();
/* 1281 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1284 */       param1Tokeniser.error(this);
/* 1285 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1286 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1290 */   BeforeDoctypePublicIdentifier {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1292 */       char c = param1CharacterReader.consume();
/* 1293 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/* 1302 */           param1Tokeniser.transition(DoctypePublicIdentifier_doubleQuoted);
/*      */ 
/*      */         
/*      */         case '\'':
/* 1306 */           param1Tokeniser.transition(DoctypePublicIdentifier_singleQuoted);
/*      */         
/*      */         case '>':
/* 1309 */           param1Tokeniser.error(this);
/* 1310 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1311 */           param1Tokeniser.emitDoctypePending();
/* 1312 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '￿':
/* 1315 */           param1Tokeniser.eofError(this);
/* 1316 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1317 */           param1Tokeniser.emitDoctypePending();
/* 1318 */           param1Tokeniser.transition(Data);
/*      */       } 
/*      */       
/* 1321 */       param1Tokeniser.error(this);
/* 1322 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1323 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1327 */   DoctypePublicIdentifier_doubleQuoted {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1329 */       char c = param1CharacterReader.consume();
/* 1330 */       switch (c) {
/*      */         case '"':
/* 1332 */           param1Tokeniser.transition(AfterDoctypePublicIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1335 */           param1Tokeniser.error(this);
/* 1336 */           param1Tokeniser.doctypePending.publicIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1339 */           param1Tokeniser.error(this);
/* 1340 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1341 */           param1Tokeniser.emitDoctypePending();
/* 1342 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1345 */           param1Tokeniser.eofError(this);
/* 1346 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1347 */           param1Tokeniser.emitDoctypePending();
/* 1348 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1351 */       param1Tokeniser.doctypePending.publicIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1355 */   DoctypePublicIdentifier_singleQuoted {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1357 */       char c = param1CharacterReader.consume();
/* 1358 */       switch (c) {
/*      */         case '\'':
/* 1360 */           param1Tokeniser.transition(AfterDoctypePublicIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1363 */           param1Tokeniser.error(this);
/* 1364 */           param1Tokeniser.doctypePending.publicIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1367 */           param1Tokeniser.error(this);
/* 1368 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1369 */           param1Tokeniser.emitDoctypePending();
/* 1370 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1373 */           param1Tokeniser.eofError(this);
/* 1374 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1375 */           param1Tokeniser.emitDoctypePending();
/* 1376 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1379 */       param1Tokeniser.doctypePending.publicIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1383 */   AfterDoctypePublicIdentifier {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1385 */       char c = param1CharacterReader.consume();
/* 1386 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1392 */           param1Tokeniser.transition(BetweenDoctypePublicAndSystemIdentifiers);
/*      */           return;
/*      */         case '>':
/* 1395 */           param1Tokeniser.emitDoctypePending();
/* 1396 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/* 1399 */           param1Tokeniser.error(this);
/*      */           
/* 1401 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1404 */           param1Tokeniser.error(this);
/*      */           
/* 1406 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '￿':
/* 1409 */           param1Tokeniser.eofError(this);
/* 1410 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1411 */           param1Tokeniser.emitDoctypePending();
/* 1412 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1415 */       param1Tokeniser.error(this);
/* 1416 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1417 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1421 */   BetweenDoctypePublicAndSystemIdentifiers {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1423 */       char c = param1CharacterReader.consume();
/* 1424 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '>':
/* 1432 */           param1Tokeniser.emitDoctypePending();
/* 1433 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '"':
/* 1436 */           param1Tokeniser.error(this);
/*      */           
/* 1438 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */         
/*      */         case '\'':
/* 1441 */           param1Tokeniser.error(this);
/*      */           
/* 1443 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */         
/*      */         case '￿':
/* 1446 */           param1Tokeniser.eofError(this);
/* 1447 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1448 */           param1Tokeniser.emitDoctypePending();
/* 1449 */           param1Tokeniser.transition(Data);
/*      */       } 
/*      */       
/* 1452 */       param1Tokeniser.error(this);
/* 1453 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1454 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1458 */   AfterDoctypeSystemKeyword {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1460 */       char c = param1CharacterReader.consume();
/* 1461 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1467 */           param1Tokeniser.transition(BeforeDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '>':
/* 1470 */           param1Tokeniser.error(this);
/* 1471 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1472 */           param1Tokeniser.emitDoctypePending();
/* 1473 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '"':
/* 1476 */           param1Tokeniser.error(this);
/*      */           
/* 1478 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */           return;
/*      */         case '\'':
/* 1481 */           param1Tokeniser.error(this);
/*      */           
/* 1483 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */           return;
/*      */         case '￿':
/* 1486 */           param1Tokeniser.eofError(this);
/* 1487 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1488 */           param1Tokeniser.emitDoctypePending();
/* 1489 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1492 */       param1Tokeniser.error(this);
/* 1493 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1494 */       param1Tokeniser.emitDoctypePending();
/*      */     }
/*      */   },
/*      */   
/* 1498 */   BeforeDoctypeSystemIdentifier {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1500 */       char c = param1CharacterReader.consume();
/* 1501 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         
/*      */         case '"':
/* 1510 */           param1Tokeniser.transition(DoctypeSystemIdentifier_doubleQuoted);
/*      */ 
/*      */         
/*      */         case '\'':
/* 1514 */           param1Tokeniser.transition(DoctypeSystemIdentifier_singleQuoted);
/*      */         
/*      */         case '>':
/* 1517 */           param1Tokeniser.error(this);
/* 1518 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1519 */           param1Tokeniser.emitDoctypePending();
/* 1520 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '￿':
/* 1523 */           param1Tokeniser.eofError(this);
/* 1524 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1525 */           param1Tokeniser.emitDoctypePending();
/* 1526 */           param1Tokeniser.transition(Data);
/*      */       } 
/*      */       
/* 1529 */       param1Tokeniser.error(this);
/* 1530 */       param1Tokeniser.doctypePending.forceQuirks = true;
/* 1531 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */   
/* 1535 */   DoctypeSystemIdentifier_doubleQuoted {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1537 */       char c = param1CharacterReader.consume();
/* 1538 */       switch (c) {
/*      */         case '"':
/* 1540 */           param1Tokeniser.transition(AfterDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1543 */           param1Tokeniser.error(this);
/* 1544 */           param1Tokeniser.doctypePending.systemIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1547 */           param1Tokeniser.error(this);
/* 1548 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1549 */           param1Tokeniser.emitDoctypePending();
/* 1550 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1553 */           param1Tokeniser.eofError(this);
/* 1554 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1555 */           param1Tokeniser.emitDoctypePending();
/* 1556 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1559 */       param1Tokeniser.doctypePending.systemIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1563 */   DoctypeSystemIdentifier_singleQuoted {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1565 */       char c = param1CharacterReader.consume();
/* 1566 */       switch (c) {
/*      */         case '\'':
/* 1568 */           param1Tokeniser.transition(AfterDoctypeSystemIdentifier);
/*      */           return;
/*      */         case '\000':
/* 1571 */           param1Tokeniser.error(this);
/* 1572 */           param1Tokeniser.doctypePending.systemIdentifier.append('�');
/*      */           return;
/*      */         case '>':
/* 1575 */           param1Tokeniser.error(this);
/* 1576 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1577 */           param1Tokeniser.emitDoctypePending();
/* 1578 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */         case '￿':
/* 1581 */           param1Tokeniser.eofError(this);
/* 1582 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1583 */           param1Tokeniser.emitDoctypePending();
/* 1584 */           param1Tokeniser.transition(Data);
/*      */           return;
/*      */       } 
/* 1587 */       param1Tokeniser.doctypePending.systemIdentifier.append(c);
/*      */     }
/*      */   },
/*      */   
/* 1591 */   AfterDoctypeSystemIdentifier {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1593 */       char c = param1CharacterReader.consume();
/* 1594 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/*      */           return;
/*      */         case '>':
/* 1602 */           param1Tokeniser.emitDoctypePending();
/* 1603 */           param1Tokeniser.transition(Data);
/*      */         
/*      */         case '￿':
/* 1606 */           param1Tokeniser.eofError(this);
/* 1607 */           param1Tokeniser.doctypePending.forceQuirks = true;
/* 1608 */           param1Tokeniser.emitDoctypePending();
/* 1609 */           param1Tokeniser.transition(Data);
/*      */       } 
/*      */       
/* 1612 */       param1Tokeniser.error(this);
/* 1613 */       param1Tokeniser.transition(BogusDoctype);
/*      */     }
/*      */   },
/*      */ 
/*      */   
/* 1618 */   BogusDoctype {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1620 */       char c = param1CharacterReader.consume();
/* 1621 */       switch (c) {
/*      */         case '>':
/* 1623 */           param1Tokeniser.emitDoctypePending();
/* 1624 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */         case '￿':
/* 1627 */           param1Tokeniser.emitDoctypePending();
/* 1628 */           param1Tokeniser.transition(Data);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*      */   },
/* 1636 */   CdataSection {
/*      */     void read(Tokeniser param1Tokeniser, CharacterReader param1CharacterReader) {
/* 1638 */       String str = param1CharacterReader.consumeTo("]]>");
/* 1639 */       param1Tokeniser.emit(str);
/* 1640 */       param1CharacterReader.matchConsume("]]>");
/* 1641 */       param1Tokeniser.transition(Data);
/*      */     } };
/*      */   
/*      */   private static final char nullChar = '\000';
/*      */   private static final char replacementChar = '�';
/*      */   private static final String replacementStr;
/*      */   private static final char eof = '￿';
/*      */   
/*      */   static {
/* 1650 */     replacementStr = String.valueOf('�');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final void handleDataEndTag(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState) {
/* 1658 */     if (paramCharacterReader.matchesLetter()) {
/* 1659 */       String str = paramCharacterReader.consumeLetterSequence();
/* 1660 */       paramTokeniser.tagPending.appendTagName(str.toLowerCase());
/* 1661 */       paramTokeniser.dataBuffer.append(str);
/*      */       
/*      */       return;
/*      */     } 
/* 1665 */     boolean bool = false;
/* 1666 */     if (paramTokeniser.isAppropriateEndTagToken() && !paramCharacterReader.isEmpty()) {
/* 1667 */       char c = paramCharacterReader.consume();
/* 1668 */       switch (c) {
/*      */         case '\t':
/*      */         case '\n':
/*      */         case '\f':
/*      */         case '\r':
/*      */         case ' ':
/* 1674 */           paramTokeniser.transition(BeforeAttributeName);
/*      */           break;
/*      */         case '/':
/* 1677 */           paramTokeniser.transition(SelfClosingStartTag);
/*      */           break;
/*      */         case '>':
/* 1680 */           paramTokeniser.emitTagPending();
/* 1681 */           paramTokeniser.transition(Data);
/*      */           break;
/*      */         default:
/* 1684 */           paramTokeniser.dataBuffer.append(c);
/* 1685 */           bool = true; break;
/*      */       } 
/*      */     } else {
/* 1688 */       bool = true;
/*      */     } 
/*      */     
/* 1691 */     if (bool) {
/* 1692 */       paramTokeniser.emit("</" + paramTokeniser.dataBuffer.toString());
/* 1693 */       paramTokeniser.transition(paramTokeniserState);
/*      */     } 
/*      */   }
/*      */   
/*      */   private static final void handleDataDoubleEscapeTag(Tokeniser paramTokeniser, CharacterReader paramCharacterReader, TokeniserState paramTokeniserState1, TokeniserState paramTokeniserState2) {
/* 1698 */     if (paramCharacterReader.matchesLetter()) {
/* 1699 */       String str = paramCharacterReader.consumeLetterSequence();
/* 1700 */       paramTokeniser.dataBuffer.append(str.toLowerCase());
/* 1701 */       paramTokeniser.emit(str);
/*      */       
/*      */       return;
/*      */     } 
/* 1705 */     char c = paramCharacterReader.consume();
/* 1706 */     switch (c) {
/*      */       case '\t':
/*      */       case '\n':
/*      */       case '\f':
/*      */       case '\r':
/*      */       case ' ':
/*      */       case '/':
/*      */       case '>':
/* 1714 */         if (paramTokeniser.dataBuffer.toString().equals("script")) {
/* 1715 */           paramTokeniser.transition(paramTokeniserState1);
/*      */         } else {
/* 1717 */           paramTokeniser.transition(paramTokeniserState2);
/* 1718 */         }  paramTokeniser.emit(c);
/*      */         return;
/*      */     } 
/* 1721 */     paramCharacterReader.unconsume();
/* 1722 */     paramTokeniser.transition(paramTokeniserState2);
/*      */   }
/*      */   
/*      */   abstract void read(Tokeniser paramTokeniser, CharacterReader paramCharacterReader);
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\TokeniserState.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */