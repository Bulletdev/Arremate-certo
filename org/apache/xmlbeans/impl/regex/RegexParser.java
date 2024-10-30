/*      */ package org.apache.xmlbeans.impl.regex;
/*      */ 
/*      */ import java.util.Locale;
/*      */ import java.util.MissingResourceException;
/*      */ import java.util.ResourceBundle;
/*      */ import java.util.Vector;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ class RegexParser
/*      */ {
/*      */   static final int T_CHAR = 0;
/*      */   static final int T_EOF = 1;
/*      */   static final int T_OR = 2;
/*      */   static final int T_STAR = 3;
/*      */   static final int T_PLUS = 4;
/*      */   static final int T_QUESTION = 5;
/*      */   static final int T_LPAREN = 6;
/*      */   static final int T_RPAREN = 7;
/*      */   static final int T_DOT = 8;
/*      */   static final int T_LBRACKET = 9;
/*      */   static final int T_BACKSOLIDUS = 10;
/*      */   static final int T_CARET = 11;
/*      */   static final int T_DOLLAR = 12;
/*      */   static final int T_LPAREN2 = 13;
/*      */   static final int T_LOOKAHEAD = 14;
/*      */   static final int T_NEGATIVELOOKAHEAD = 15;
/*      */   static final int T_LOOKBEHIND = 16;
/*      */   static final int T_NEGATIVELOOKBEHIND = 17;
/*      */   static final int T_INDEPENDENT = 18;
/*      */   static final int T_SET_OPERATIONS = 19;
/*      */   static final int T_POSIX_CHARCLASS_START = 20;
/*      */   static final int T_COMMENT = 21;
/*      */   static final int T_MODIFIERS = 22;
/*      */   static final int T_CONDITION = 23;
/*      */   static final int T_XMLSCHEMA_CC_SUBTRACTION = 24;
/*      */   int offset;
/*      */   String regex;
/*      */   int regexlen;
/*      */   int options;
/*      */   ResourceBundle resources;
/*      */   int chardata;
/*      */   int nexttoken;
/*      */   protected static final int S_NORMAL = 0;
/*      */   protected static final int S_INBRACKETS = 1;
/*      */   protected static final int S_INXBRACKETS = 2;
/*      */   
/*      */   static class ReferencePosition
/*      */   {
/*      */     int refNumber;
/*      */     int position;
/*      */     
/*      */     ReferencePosition(int param1Int1, int param1Int2) {
/*   57 */       this.refNumber = param1Int1;
/*   58 */       this.position = param1Int2;
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
/*   72 */   int context = 0;
/*   73 */   int parennumber = 1;
/*      */   boolean hasBackReferences;
/*   75 */   Vector references = null;
/*      */   
/*      */   public RegexParser() {
/*   78 */     setLocale(Locale.getDefault());
/*      */   }
/*      */   public RegexParser(Locale paramLocale) {
/*   81 */     setLocale(paramLocale);
/*      */   }
/*      */   
/*      */   public void setLocale(Locale paramLocale) {
/*      */     try {
/*   86 */       this.resources = ResourceBundle.getBundle("org.apache.xmlbeans.impl.regex.message", paramLocale);
/*   87 */     } catch (MissingResourceException missingResourceException) {
/*   88 */       throw new RuntimeException("Installation Problem???  Couldn't load messages: " + missingResourceException.getMessage());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   final ParseException ex(String paramString, int paramInt) {
/*   94 */     return new ParseException(this.resources.getString(paramString), paramInt);
/*      */   }
/*      */   
/*      */   private final boolean isSet(int paramInt) {
/*   98 */     return ((this.options & paramInt) == paramInt);
/*      */   }
/*      */   
/*      */   synchronized Token parse(String paramString, int paramInt) throws ParseException {
/*  102 */     this.options = paramInt;
/*  103 */     this.offset = 0;
/*  104 */     setContext(0);
/*  105 */     this.parennumber = 1;
/*  106 */     this.hasBackReferences = false;
/*  107 */     this.regex = paramString;
/*  108 */     if (isSet(16))
/*  109 */       this.regex = REUtil.stripExtendedComment(this.regex); 
/*  110 */     this.regexlen = this.regex.length();
/*      */ 
/*      */     
/*  113 */     next();
/*  114 */     Token token = parseRegex();
/*  115 */     if (this.offset != this.regexlen)
/*  116 */       throw ex("parser.parse.1", this.offset); 
/*  117 */     if (this.references != null) {
/*  118 */       for (byte b = 0; b < this.references.size(); b++) {
/*  119 */         ReferencePosition referencePosition = this.references.elementAt(b);
/*  120 */         if (this.parennumber <= referencePosition.refNumber)
/*  121 */           throw ex("parser.parse.2", referencePosition.position); 
/*      */       } 
/*  123 */       this.references.removeAllElements();
/*      */     } 
/*  125 */     return token;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected final void setContext(int paramInt) {
/*  136 */     this.context = paramInt;
/*      */   }
/*      */   
/*      */   final int read() {
/*  140 */     return this.nexttoken;
/*      */   }
/*      */   final void next() {
/*      */     byte b;
/*  144 */     if (this.offset >= this.regexlen) {
/*  145 */       this.chardata = -1;
/*  146 */       this.nexttoken = 1;
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  151 */     char c = this.regex.charAt(this.offset++);
/*  152 */     this.chardata = c;
/*      */     
/*  154 */     if (this.context == 1) {
/*      */       byte b1;
/*      */       
/*  157 */       switch (c) {
/*      */         case '\\':
/*  159 */           b1 = 10;
/*  160 */           if (this.offset >= this.regexlen)
/*  161 */             throw ex("parser.next.1", this.offset - 1); 
/*  162 */           this.chardata = this.regex.charAt(this.offset++);
/*      */           break;
/*      */         
/*      */         case '-':
/*  166 */           if (isSet(512) && this.offset < this.regexlen && this.regex.charAt(this.offset) == '[') {
/*      */             
/*  168 */             this.offset++;
/*  169 */             b1 = 24; break;
/*      */           } 
/*  171 */           b1 = 0;
/*      */           break;
/*      */         
/*      */         case '[':
/*  175 */           if (!isSet(512) && this.offset < this.regexlen && this.regex.charAt(this.offset) == ':') {
/*      */             
/*  177 */             this.offset++;
/*  178 */             b1 = 20;
/*      */             break;
/*      */           } 
/*      */         default:
/*  182 */           if (REUtil.isHighSurrogate(c) && this.offset < this.regexlen) {
/*  183 */             char c1 = this.regex.charAt(this.offset);
/*  184 */             if (REUtil.isLowSurrogate(c1)) {
/*  185 */               this.chardata = REUtil.composeFromSurrogates(c, c1);
/*  186 */               this.offset++;
/*      */             } 
/*      */           } 
/*  189 */           b1 = 0; break;
/*      */       } 
/*  191 */       this.nexttoken = b1;
/*      */       
/*      */       return;
/*      */     } 
/*  195 */     switch (c) { case '|':
/*  196 */         b = 2; break;
/*  197 */       case '*': b = 3; break;
/*  198 */       case '+': b = 4; break;
/*  199 */       case '?': b = 5; break;
/*  200 */       case ')': b = 7; break;
/*  201 */       case '.': b = 8; break;
/*  202 */       case '[': b = 9; break;
/*  203 */       case '^': b = 11; break;
/*  204 */       case '$': b = 12; break;
/*      */       case '(':
/*  206 */         b = 6;
/*  207 */         if (this.offset >= this.regexlen)
/*      */           break; 
/*  209 */         if (this.regex.charAt(this.offset) != '?')
/*      */           break; 
/*  211 */         if (++this.offset >= this.regexlen)
/*  212 */           throw ex("parser.next.2", this.offset - 1); 
/*  213 */         c = this.regex.charAt(this.offset++);
/*  214 */         switch (c) { case ':':
/*  215 */             b = 13; break;
/*  216 */           case '=': b = 14; break;
/*  217 */           case '!': b = 15; break;
/*  218 */           case '[': b = 19; break;
/*  219 */           case '>': b = 18; break;
/*      */           case '<':
/*  221 */             if (this.offset >= this.regexlen)
/*  222 */               throw ex("parser.next.2", this.offset - 3); 
/*  223 */             c = this.regex.charAt(this.offset++);
/*  224 */             if (c == '=') {
/*  225 */               b = 16; break;
/*  226 */             }  if (c == '!') {
/*  227 */               b = 17; break;
/*      */             } 
/*  229 */             throw ex("parser.next.3", this.offset - 3);
/*      */           
/*      */           case '#':
/*  232 */             while (this.offset < this.regexlen) {
/*  233 */               c = this.regex.charAt(this.offset++);
/*  234 */               if (c == ')')
/*      */                 break; 
/*  236 */             }  if (c != ')')
/*  237 */               throw ex("parser.next.4", this.offset - 1); 
/*  238 */             b = 21;
/*      */             break; }
/*      */         
/*  241 */         if (c == '-' || ('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z')) {
/*  242 */           this.offset--;
/*  243 */           b = 22; break;
/*      */         } 
/*  245 */         if (c == '(') {
/*  246 */           b = 23;
/*      */           break;
/*      */         } 
/*  249 */         throw ex("parser.next.2", this.offset - 2);
/*      */ 
/*      */ 
/*      */       
/*      */       case '\\':
/*  254 */         b = 10;
/*  255 */         if (this.offset >= this.regexlen)
/*  256 */           throw ex("parser.next.1", this.offset - 1); 
/*  257 */         this.chardata = this.regex.charAt(this.offset++);
/*      */         break;
/*      */       
/*      */       default:
/*  261 */         b = 0; break; }
/*      */     
/*  263 */     this.nexttoken = b;
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
/*      */   Token parseRegex() throws ParseException {
/*  276 */     Token token = parseTerm();
/*  277 */     Token.UnionToken unionToken = null;
/*  278 */     while (read() == 2) {
/*  279 */       next();
/*  280 */       if (unionToken == null) {
/*  281 */         unionToken = Token.createUnion();
/*  282 */         unionToken.addChild(token);
/*  283 */         token = unionToken;
/*      */       } 
/*  285 */       token.addChild(parseTerm());
/*      */     } 
/*  287 */     return token;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Token parseTerm() throws ParseException {
/*  294 */     int i = read();
/*  295 */     if (i == 2 || i == 7 || i == 1) {
/*  296 */       return Token.createEmpty();
/*      */     }
/*  298 */     Token token = parseFactor();
/*  299 */     Token.UnionToken unionToken = null;
/*  300 */     while ((i = read()) != 2 && i != 7 && i != 1) {
/*  301 */       if (unionToken == null) {
/*  302 */         unionToken = Token.createConcat();
/*  303 */         unionToken.addChild(token);
/*  304 */         token = unionToken;
/*      */       } 
/*  306 */       unionToken.addChild(parseFactor());
/*      */     } 
/*      */     
/*  309 */     return token;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Token processCaret() throws ParseException {
/*  316 */     next();
/*  317 */     return Token.token_linebeginning;
/*      */   }
/*      */   Token processDollar() throws ParseException {
/*  320 */     next();
/*  321 */     return Token.token_lineend;
/*      */   }
/*      */   Token processLookahead() throws ParseException {
/*  324 */     next();
/*  325 */     Token.ParenToken parenToken = Token.createLook(20, parseRegex());
/*  326 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  327 */     next();
/*  328 */     return parenToken;
/*      */   }
/*      */   Token processNegativelookahead() throws ParseException {
/*  331 */     next();
/*  332 */     Token.ParenToken parenToken = Token.createLook(21, parseRegex());
/*  333 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  334 */     next();
/*  335 */     return parenToken;
/*      */   }
/*      */   Token processLookbehind() throws ParseException {
/*  338 */     next();
/*  339 */     Token.ParenToken parenToken = Token.createLook(22, parseRegex());
/*  340 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  341 */     next();
/*  342 */     return parenToken;
/*      */   }
/*      */   Token processNegativelookbehind() throws ParseException {
/*  345 */     next();
/*  346 */     Token.ParenToken parenToken = Token.createLook(23, parseRegex());
/*  347 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  348 */     next();
/*  349 */     return parenToken;
/*      */   }
/*      */   Token processBacksolidus_A() throws ParseException {
/*  352 */     next();
/*  353 */     return Token.token_stringbeginning;
/*      */   }
/*      */   Token processBacksolidus_Z() throws ParseException {
/*  356 */     next();
/*  357 */     return Token.token_stringend2;
/*      */   }
/*      */   Token processBacksolidus_z() throws ParseException {
/*  360 */     next();
/*  361 */     return Token.token_stringend;
/*      */   }
/*      */   Token processBacksolidus_b() throws ParseException {
/*  364 */     next();
/*  365 */     return Token.token_wordedge;
/*      */   }
/*      */   Token processBacksolidus_B() throws ParseException {
/*  368 */     next();
/*  369 */     return Token.token_not_wordedge;
/*      */   }
/*      */   Token processBacksolidus_lt() throws ParseException {
/*  372 */     next();
/*  373 */     return Token.token_wordbeginning;
/*      */   }
/*      */   Token processBacksolidus_gt() throws ParseException {
/*  376 */     next();
/*  377 */     return Token.token_wordend;
/*      */   }
/*      */   Token processStar(Token paramToken) throws ParseException {
/*  380 */     next();
/*  381 */     if (read() == 5) {
/*  382 */       next();
/*  383 */       return Token.createNGClosure(paramToken);
/*      */     } 
/*  385 */     return Token.createClosure(paramToken);
/*      */   }
/*      */   
/*      */   Token processPlus(Token paramToken) throws ParseException {
/*  389 */     next();
/*  390 */     if (read() == 5) {
/*  391 */       next();
/*  392 */       return Token.createConcat(paramToken, Token.createNGClosure(paramToken));
/*      */     } 
/*  394 */     return Token.createConcat(paramToken, Token.createClosure(paramToken));
/*      */   }
/*      */   
/*      */   Token processQuestion(Token paramToken) throws ParseException {
/*  398 */     next();
/*  399 */     Token.UnionToken unionToken = Token.createUnion();
/*  400 */     if (read() == 5) {
/*  401 */       next();
/*  402 */       unionToken.addChild(Token.createEmpty());
/*  403 */       unionToken.addChild(paramToken);
/*      */     } else {
/*  405 */       unionToken.addChild(paramToken);
/*  406 */       unionToken.addChild(Token.createEmpty());
/*      */     } 
/*  408 */     return unionToken;
/*      */   }
/*      */   boolean checkQuestion(int paramInt) {
/*  411 */     return (paramInt < this.regexlen && this.regex.charAt(paramInt) == '?');
/*      */   }
/*      */   Token processParen() throws ParseException {
/*  414 */     next();
/*  415 */     int i = this.parennumber++;
/*  416 */     Token.ParenToken parenToken = Token.createParen(parseRegex(), i);
/*  417 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  418 */     next();
/*  419 */     return parenToken;
/*      */   }
/*      */   Token processParen2() throws ParseException {
/*  422 */     next();
/*  423 */     Token.ParenToken parenToken = Token.createParen(parseRegex(), 0);
/*  424 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  425 */     next();
/*  426 */     return parenToken;
/*      */   }
/*      */   
/*      */   Token processCondition() throws ParseException {
/*  430 */     if (this.offset + 1 >= this.regexlen) throw ex("parser.factor.4", this.offset);
/*      */     
/*  432 */     int i = -1;
/*  433 */     Token token1 = null;
/*  434 */     char c = this.regex.charAt(this.offset);
/*  435 */     if ('1' <= c && c <= '9') {
/*  436 */       i = c - 48;
/*  437 */       this.hasBackReferences = true;
/*  438 */       if (this.references == null) this.references = new Vector(); 
/*  439 */       this.references.addElement(new ReferencePosition(i, this.offset));
/*  440 */       this.offset++;
/*  441 */       if (this.regex.charAt(this.offset) != ')') throw ex("parser.factor.1", this.offset); 
/*  442 */       this.offset++;
/*      */     } else {
/*  444 */       if (c == '?') this.offset--; 
/*  445 */       next();
/*  446 */       token1 = parseFactor();
/*  447 */       switch (token1.type) {
/*      */         case 20:
/*      */         case 21:
/*      */         case 22:
/*      */         case 23:
/*      */           break;
/*      */         case 8:
/*  454 */           if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*      */           break;
/*      */         default:
/*  457 */           throw ex("parser.factor.5", this.offset);
/*      */       } 
/*      */     
/*      */     } 
/*  461 */     next();
/*  462 */     Token token2 = parseRegex();
/*  463 */     Token token3 = null;
/*  464 */     if (token2.type == 2) {
/*  465 */       if (token2.size() != 2) throw ex("parser.factor.6", this.offset); 
/*  466 */       token3 = token2.getChild(1);
/*  467 */       token2 = token2.getChild(0);
/*      */     } 
/*  469 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  470 */     next();
/*  471 */     return Token.createCondition(i, token1, token2, token3);
/*      */   }
/*      */   
/*      */   Token processModifiers() throws ParseException {
/*      */     Token.ModifierToken modifierToken;
/*  476 */     int i = 0, j = 0, k = -1;
/*  477 */     while (this.offset < this.regexlen) {
/*  478 */       k = this.regex.charAt(this.offset);
/*  479 */       int m = REUtil.getOptionValue(k);
/*  480 */       if (m == 0)
/*  481 */         break;  i |= m;
/*  482 */       this.offset++;
/*      */     } 
/*  484 */     if (this.offset >= this.regexlen) throw ex("parser.factor.2", this.offset - 1); 
/*  485 */     if (k == 45) {
/*  486 */       this.offset++;
/*  487 */       while (this.offset < this.regexlen) {
/*  488 */         k = this.regex.charAt(this.offset);
/*  489 */         int m = REUtil.getOptionValue(k);
/*  490 */         if (m == 0)
/*  491 */           break;  j |= m;
/*  492 */         this.offset++;
/*      */       } 
/*  494 */       if (this.offset >= this.regexlen) throw ex("parser.factor.2", this.offset - 1);
/*      */     
/*      */     } 
/*  497 */     if (k == 58) {
/*  498 */       this.offset++;
/*  499 */       next();
/*  500 */       modifierToken = Token.createModifierGroup(parseRegex(), i, j);
/*  501 */       if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  502 */       next();
/*  503 */     } else if (k == 41) {
/*  504 */       this.offset++;
/*  505 */       next();
/*  506 */       modifierToken = Token.createModifierGroup(parseRegex(), i, j);
/*      */     } else {
/*  508 */       throw ex("parser.factor.3", this.offset);
/*      */     } 
/*  510 */     return modifierToken;
/*      */   }
/*      */   Token processIndependent() throws ParseException {
/*  513 */     next();
/*  514 */     Token.ParenToken parenToken = Token.createLook(24, parseRegex());
/*  515 */     if (read() != 7) throw ex("parser.factor.1", this.offset - 1); 
/*  516 */     next();
/*  517 */     return parenToken;
/*      */   }
/*      */   Token processBacksolidus_c() throws ParseException {
/*      */     char c;
/*  521 */     if (this.offset >= this.regexlen || ((c = this.regex.charAt(this.offset++)) & 0xFFE0) != 64)
/*      */     {
/*  523 */       throw ex("parser.atom.1", this.offset - 1); } 
/*  524 */     next();
/*  525 */     return Token.createChar(c - 64);
/*      */   }
/*      */   Token processBacksolidus_C() throws ParseException {
/*  528 */     throw ex("parser.process.1", this.offset);
/*      */   }
/*      */   Token processBacksolidus_i() throws ParseException {
/*  531 */     Token.CharToken charToken = Token.createChar(105);
/*  532 */     next();
/*  533 */     return charToken;
/*      */   }
/*      */   Token processBacksolidus_I() throws ParseException {
/*  536 */     throw ex("parser.process.1", this.offset);
/*      */   }
/*      */   Token processBacksolidus_g() throws ParseException {
/*  539 */     next();
/*  540 */     return Token.getGraphemePattern();
/*      */   }
/*      */   Token processBacksolidus_X() throws ParseException {
/*  543 */     next();
/*  544 */     return Token.getCombiningCharacterSequence();
/*      */   }
/*      */   Token processBackreference() throws ParseException {
/*  547 */     int i = this.chardata - 48;
/*  548 */     Token.StringToken stringToken = Token.createBackReference(i);
/*  549 */     this.hasBackReferences = true;
/*  550 */     if (this.references == null) this.references = new Vector(); 
/*  551 */     this.references.addElement(new ReferencePosition(i, this.offset - 2));
/*  552 */     next();
/*  553 */     return stringToken;
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
/*      */   Token parseFactor() throws ParseException {
/*  568 */     int i = read();
/*      */     
/*  570 */     switch (i) { case 11:
/*  571 */         return processCaret();
/*  572 */       case 12: return processDollar();
/*  573 */       case 14: return processLookahead();
/*  574 */       case 15: return processNegativelookahead();
/*  575 */       case 16: return processLookbehind();
/*  576 */       case 17: return processNegativelookbehind();
/*      */       
/*      */       case 21:
/*  579 */         next();
/*  580 */         return Token.createEmpty();
/*      */       
/*      */       case 10:
/*  583 */         switch (this.chardata) { case 65:
/*  584 */             return processBacksolidus_A();
/*  585 */           case 90: return processBacksolidus_Z();
/*  586 */           case 122: return processBacksolidus_z();
/*  587 */           case 98: return processBacksolidus_b();
/*  588 */           case 66: return processBacksolidus_B();
/*  589 */           case 60: return processBacksolidus_lt();
/*  590 */           case 62: return processBacksolidus_gt(); }
/*      */         
/*      */         break; }
/*      */     
/*  594 */     Token token = parseAtom();
/*  595 */     i = read();
/*  596 */     switch (i) { case 3:
/*  597 */         return processStar(token);
/*  598 */       case 4: return processPlus(token);
/*  599 */       case 5: return processQuestion(token);
/*      */       case 0:
/*  601 */         if (this.chardata == 123 && this.offset < this.regexlen) {
/*      */           
/*  603 */           int j = this.offset;
/*  604 */           int k = 0, m = -1;
/*      */           
/*  606 */           if ((i = this.regex.charAt(j++)) >= 48 && i <= 57) {
/*      */             
/*  608 */             k = i - 48;
/*      */             
/*  610 */             while (j < this.regexlen && (i = this.regex.charAt(j++)) >= 48 && i <= 57) {
/*  611 */               k = k * 10 + i - 48;
/*  612 */               if (k < 0) {
/*  613 */                 throw ex("parser.quantifier.5", this.offset);
/*      */               }
/*      */             } 
/*      */           } else {
/*  617 */             throw ex("parser.quantifier.1", this.offset);
/*      */           } 
/*      */           
/*  620 */           m = k;
/*  621 */           if (i == 44) {
/*      */             
/*  623 */             if (j >= this.regexlen) {
/*  624 */               throw ex("parser.quantifier.3", this.offset);
/*      */             }
/*  626 */             if ((i = this.regex.charAt(j++)) >= 48 && i <= 57) {
/*      */               
/*  628 */               m = i - 48;
/*      */ 
/*      */               
/*  631 */               while (j < this.regexlen && (i = this.regex.charAt(j++)) >= 48 && i <= 57) {
/*  632 */                 m = m * 10 + i - 48;
/*  633 */                 if (m < 0) {
/*  634 */                   throw ex("parser.quantifier.5", this.offset);
/*      */                 }
/*      */               } 
/*  637 */               if (k > m) {
/*  638 */                 throw ex("parser.quantifier.4", this.offset);
/*      */               }
/*      */             } else {
/*  641 */               m = -1;
/*      */             } 
/*      */           } 
/*      */           
/*  645 */           if (i != 125) {
/*  646 */             throw ex("parser.quantifier.2", this.offset);
/*      */           }
/*  648 */           if (checkQuestion(j)) {
/*  649 */             token = Token.createNGClosure(token);
/*  650 */             this.offset = j + 1;
/*      */           } else {
/*  652 */             token = Token.createClosure(token);
/*  653 */             this.offset = j;
/*      */           } 
/*      */           
/*  656 */           token.setMin(k);
/*  657 */           token.setMax(m);
/*      */           
/*  659 */           next();
/*      */         }  break; }
/*      */     
/*  662 */     return token;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Token parseAtom() throws ParseException {
/*  672 */     int j, i = read();
/*  673 */     Token token = null;
/*  674 */     switch (i) { case 6:
/*  675 */         return processParen();
/*  676 */       case 13: return processParen2();
/*  677 */       case 23: return processCondition();
/*  678 */       case 22: return processModifiers();
/*  679 */       case 18: return processIndependent();
/*      */       case 8:
/*  681 */         next();
/*  682 */         token = Token.token_dot;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  758 */         return token;case 9: return parseCharacterClass(true);case 19: return parseSetOperations();case 10: switch (this.chardata) { case 68: case 83: case 87: case 100: case 115: case 119: token = getTokenForShorthand(this.chardata); next(); return token;case 101: case 102: case 110: case 114: case 116: case 117: case 118: case 120: j = decodeEscaped(); if (j < 65536) { token = Token.createChar(j); break; }  token = Token.createString(REUtil.decomposeToSurrogates(j)); break;case 99: return processBacksolidus_c();case 67: return processBacksolidus_C();case 105: return processBacksolidus_i();case 73: return processBacksolidus_I();case 103: return processBacksolidus_g();case 88: return processBacksolidus_X();case 49: case 50: case 51: case 52: case 53: case 54: case 55: case 56: case 57: return processBackreference();case 80: case 112: j = this.offset; token = processBacksolidus_pP(this.chardata); if (token == null) throw ex("parser.atom.5", j);  break;default: token = Token.createChar(this.chardata); break; }  next(); return token;case 0: if (this.chardata == 93 || this.chardata == 123 || this.chardata == 125) throw ex("parser.atom.4", this.offset - 1);  token = Token.createChar(this.chardata); j = this.chardata; next(); if (REUtil.isHighSurrogate(j) && read() == 0 && REUtil.isLowSurrogate(this.chardata)) { char[] arrayOfChar = new char[2]; arrayOfChar[0] = (char)j; arrayOfChar[1] = (char)this.chardata; token = Token.createParen(Token.createString(new String(arrayOfChar)), 0); next(); }  return token; }
/*      */     
/*      */     throw ex("parser.atom.4", this.offset - 1);
/*      */   }
/*      */   protected RangeToken processBacksolidus_pP(int paramInt) throws ParseException {
/*  763 */     next();
/*  764 */     if (read() != 0 || this.chardata != 123) {
/*  765 */       throw ex("parser.atom.2", this.offset - 1);
/*      */     }
/*      */     
/*  768 */     boolean bool = (paramInt == 112) ? true : false;
/*  769 */     int i = this.offset;
/*  770 */     int j = this.regex.indexOf('}', i);
/*      */     
/*  772 */     if (j < 0) {
/*  773 */       throw ex("parser.atom.3", this.offset);
/*      */     }
/*  775 */     String str = this.regex.substring(i, j);
/*  776 */     this.offset = j + 1;
/*      */     
/*  778 */     return Token.getRange(str, bool, isSet(512));
/*      */   }
/*      */   
/*      */   int processCIinCharacterClass(RangeToken paramRangeToken, int paramInt) {
/*  782 */     return decodeEscaped();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected RangeToken parseCharacterClass(boolean paramBoolean) throws ParseException {
/*      */     RangeToken rangeToken2;
/*  793 */     setContext(1);
/*  794 */     next();
/*  795 */     boolean bool1 = false;
/*  796 */     RangeToken rangeToken1 = null;
/*      */     
/*  798 */     if (read() == 0 && this.chardata == 94) {
/*  799 */       bool1 = true;
/*  800 */       next();
/*  801 */       if (paramBoolean) {
/*  802 */         rangeToken2 = Token.createNRange();
/*      */       } else {
/*  804 */         rangeToken1 = Token.createRange();
/*  805 */         rangeToken1.addRange(0, 1114111);
/*  806 */         rangeToken2 = Token.createRange();
/*      */       } 
/*      */     } else {
/*  809 */       rangeToken2 = Token.createRange();
/*      */     } 
/*      */     
/*  812 */     boolean bool2 = true; int i;
/*  813 */     while ((i = read()) != 1 && (
/*  814 */       i != 0 || this.chardata != 93 || bool2)) {
/*      */       
/*  816 */       bool2 = false;
/*  817 */       int j = this.chardata;
/*  818 */       boolean bool = false;
/*  819 */       if (i == 10) {
/*  820 */         int k; RangeToken rangeToken; switch (j) { case 68: case 83: case 87:
/*      */           case 100:
/*      */           case 115:
/*      */           case 119:
/*  824 */             rangeToken2.mergeRanges(getTokenForShorthand(j));
/*  825 */             bool = true; break;
/*      */           case 67:
/*      */           case 73:
/*      */           case 99:
/*      */           case 105:
/*  830 */             j = processCIinCharacterClass(rangeToken2, j);
/*  831 */             if (j < 0) bool = true;
/*      */             
/*      */             break;
/*      */           case 80:
/*      */           case 112:
/*  836 */             k = this.offset;
/*  837 */             rangeToken = processBacksolidus_pP(j);
/*  838 */             if (rangeToken == null) throw ex("parser.atom.5", k); 
/*  839 */             rangeToken2.mergeRanges(rangeToken);
/*  840 */             bool = true;
/*      */             break;
/*      */           
/*      */           default:
/*  844 */             j = decodeEscaped();
/*      */             break; }
/*      */ 
/*      */       
/*  848 */       } else if (i == 20) {
/*  849 */         int k = this.regex.indexOf(':', this.offset);
/*  850 */         if (k < 0) throw ex("parser.cc.1", this.offset); 
/*  851 */         boolean bool3 = true;
/*  852 */         if (this.regex.charAt(this.offset) == '^') {
/*  853 */           this.offset++;
/*  854 */           bool3 = false;
/*      */         } 
/*  856 */         String str = this.regex.substring(this.offset, k);
/*  857 */         RangeToken rangeToken = Token.getRange(str, bool3, isSet(512));
/*      */         
/*  859 */         if (rangeToken == null) throw ex("parser.cc.3", this.offset); 
/*  860 */         rangeToken2.mergeRanges(rangeToken);
/*  861 */         bool = true;
/*  862 */         if (k + 1 >= this.regexlen || this.regex.charAt(k + 1) != ']')
/*  863 */           throw ex("parser.cc.1", k); 
/*  864 */         this.offset = k + 2;
/*      */       } 
/*  866 */       next();
/*  867 */       if (!bool) {
/*  868 */         if (read() != 0 || this.chardata != 45) {
/*  869 */           rangeToken2.addRange(j, j);
/*      */         } else {
/*  871 */           next();
/*  872 */           if ((i = read()) == 1) throw ex("parser.cc.2", this.offset); 
/*  873 */           if (i == 0 && this.chardata == 93) {
/*  874 */             rangeToken2.addRange(j, j);
/*  875 */             rangeToken2.addRange(45, 45);
/*      */           } else {
/*  877 */             int k = this.chardata;
/*  878 */             if (i == 10)
/*  879 */               k = decodeEscaped(); 
/*  880 */             next();
/*  881 */             rangeToken2.addRange(j, k);
/*      */           } 
/*      */         } 
/*      */       }
/*  885 */       if (isSet(1024) && read() == 0 && this.chardata == 44)
/*      */       {
/*  887 */         next(); } 
/*      */     } 
/*  889 */     if (read() == 1)
/*  890 */       throw ex("parser.cc.2", this.offset); 
/*  891 */     if (!paramBoolean && bool1) {
/*  892 */       rangeToken1.subtractRanges(rangeToken2);
/*  893 */       rangeToken2 = rangeToken1;
/*      */     } 
/*  895 */     rangeToken2.sortRanges();
/*  896 */     rangeToken2.compactRanges();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  902 */     setContext(0);
/*  903 */     next();
/*      */     
/*  905 */     return rangeToken2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected RangeToken parseSetOperations() throws ParseException {
/*  912 */     RangeToken rangeToken = parseCharacterClass(false);
/*      */     int i;
/*  914 */     while ((i = read()) != 7) {
/*  915 */       int j = this.chardata;
/*  916 */       if ((i == 0 && (j == 45 || j == 38)) || i == 4) {
/*      */         
/*  918 */         next();
/*  919 */         if (read() != 9) throw ex("parser.ope.1", this.offset - 1); 
/*  920 */         RangeToken rangeToken1 = parseCharacterClass(false);
/*  921 */         if (i == 4) {
/*  922 */           rangeToken.mergeRanges(rangeToken1); continue;
/*  923 */         }  if (j == 45) {
/*  924 */           rangeToken.subtractRanges(rangeToken1); continue;
/*  925 */         }  if (j == 38) {
/*  926 */           rangeToken.intersectRanges(rangeToken1); continue;
/*      */         } 
/*  928 */         throw new RuntimeException("ASSERT");
/*      */       } 
/*  930 */       throw ex("parser.ope.2", this.offset - 1);
/*      */     } 
/*      */     
/*  933 */     next();
/*  934 */     return rangeToken;
/*      */   }
/*      */   
/*      */   Token getTokenForShorthand(int paramInt) {
/*      */     Token token;
/*  939 */     switch (paramInt) {
/*      */       case 100:
/*  941 */         token = isSet(32) ? Token.getRange("Nd", true) : Token.token_0to9;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  968 */         return token;case 68: token = isSet(32) ? Token.getRange("Nd", false) : Token.token_not_0to9; return token;case 119: token = isSet(32) ? Token.getRange("IsWord", true) : Token.token_wordchars; return token;case 87: token = isSet(32) ? Token.getRange("IsWord", false) : Token.token_not_wordchars; return token;case 115: token = isSet(32) ? Token.getRange("IsSpace", true) : Token.token_spaces; return token;case 83: token = isSet(32) ? Token.getRange("IsSpace", false) : Token.token_not_spaces; return token;
/*      */     } 
/*      */     throw new RuntimeException("Internal Error: shorthands: \\u" + Integer.toString(paramInt, 16));
/*      */   }
/*      */   int decodeEscaped() throws ParseException {
/*      */     int j, k;
/*  974 */     if (read() != 10) throw ex("parser.next.1", this.offset - 1); 
/*  975 */     int i = this.chardata;
/*  976 */     switch (i) { case 101:
/*  977 */         i = 27; break;
/*  978 */       case 102: i = 12; break;
/*  979 */       case 110: i = 10; break;
/*  980 */       case 114: i = 13; break;
/*  981 */       case 116: i = 9;
/*      */         break;
/*      */       case 120:
/*  984 */         next();
/*  985 */         if (read() != 0) throw ex("parser.descape.1", this.offset - 1); 
/*  986 */         if (this.chardata == 123) {
/*  987 */           int m = 0;
/*  988 */           int n = 0;
/*      */           while (true) {
/*  990 */             next();
/*  991 */             if (read() != 0) throw ex("parser.descape.1", this.offset - 1); 
/*  992 */             if ((m = hexChar(this.chardata)) < 0)
/*      */               break; 
/*  994 */             if (n > n * 16) throw ex("parser.descape.2", this.offset - 1); 
/*  995 */             n = n * 16 + m;
/*      */           } 
/*  997 */           if (this.chardata != 125) throw ex("parser.descape.3", this.offset - 1); 
/*  998 */           if (n > 1114111) throw ex("parser.descape.4", this.offset - 1); 
/*  999 */           i = n; break;
/*      */         } 
/* 1001 */         j = 0;
/* 1002 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1003 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1004 */         k = j;
/* 1005 */         next();
/* 1006 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1007 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1008 */         k = k * 16 + j;
/* 1009 */         i = k;
/*      */         break;
/*      */ 
/*      */       
/*      */       case 117:
/* 1014 */         j = 0;
/* 1015 */         next();
/* 1016 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1017 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1018 */         k = j;
/* 1019 */         next();
/* 1020 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1021 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1022 */         k = k * 16 + j;
/* 1023 */         next();
/* 1024 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1025 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1026 */         k = k * 16 + j;
/* 1027 */         next();
/* 1028 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1029 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1030 */         k = k * 16 + j;
/* 1031 */         i = k;
/*      */         break;
/*      */       
/*      */       case 118:
/* 1035 */         next();
/* 1036 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1037 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1038 */         k = j;
/* 1039 */         next();
/* 1040 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1041 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1042 */         k = k * 16 + j;
/* 1043 */         next();
/* 1044 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1045 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1046 */         k = k * 16 + j;
/* 1047 */         next();
/* 1048 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1049 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1050 */         k = k * 16 + j;
/* 1051 */         next();
/* 1052 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1053 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1054 */         k = k * 16 + j;
/* 1055 */         next();
/* 1056 */         if (read() != 0 || (j = hexChar(this.chardata)) < 0)
/* 1057 */           throw ex("parser.descape.1", this.offset - 1); 
/* 1058 */         k = k * 16 + j;
/* 1059 */         if (k > 1114111) throw ex("parser.descappe.4", this.offset - 1); 
/* 1060 */         i = k;
/*      */         break;
/*      */       case 65:
/*      */       case 90:
/*      */       case 122:
/* 1065 */         throw ex("parser.descape.5", this.offset - 2); }
/*      */ 
/*      */     
/* 1068 */     return i;
/*      */   }
/*      */   
/*      */   private static final int hexChar(int paramInt) {
/* 1072 */     if (paramInt < 48) return -1; 
/* 1073 */     if (paramInt > 102) return -1; 
/* 1074 */     if (paramInt <= 57) return paramInt - 48; 
/* 1075 */     if (paramInt < 65) return -1; 
/* 1076 */     if (paramInt <= 70) return paramInt - 65 + 10; 
/* 1077 */     if (paramInt < 97) return -1; 
/* 1078 */     return paramInt - 97 + 10;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\regex\RegexParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */