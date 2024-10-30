/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Entities;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class Tokeniser
/*     */ {
/*     */   static final char replacementChar = '�';
/*     */   private CharacterReader reader;
/*     */   private ParseErrorList errors;
/*  18 */   private TokeniserState state = TokeniserState.Data;
/*     */   private Token emitPending;
/*     */   private boolean isEmitPending = false;
/*  21 */   private StringBuilder charBuffer = new StringBuilder();
/*     */   
/*     */   StringBuilder dataBuffer;
/*     */   Token.Tag tagPending;
/*     */   Token.Doctype doctypePending;
/*     */   Token.Comment commentPending;
/*     */   private Token.StartTag lastStartTag;
/*     */   private boolean selfClosingFlagAcknowledged = true;
/*     */   
/*     */   Tokeniser(CharacterReader paramCharacterReader, ParseErrorList paramParseErrorList) {
/*  31 */     this.reader = paramCharacterReader;
/*  32 */     this.errors = paramParseErrorList;
/*     */   }
/*     */   
/*     */   Token read() {
/*  36 */     if (!this.selfClosingFlagAcknowledged) {
/*  37 */       error("Self closing flag not acknowledged");
/*  38 */       this.selfClosingFlagAcknowledged = true;
/*     */     } 
/*     */     
/*  41 */     while (!this.isEmitPending) {
/*  42 */       this.state.read(this, this.reader);
/*     */     }
/*     */     
/*  45 */     if (this.charBuffer.length() > 0) {
/*  46 */       String str = this.charBuffer.toString();
/*  47 */       this.charBuffer.delete(0, this.charBuffer.length());
/*  48 */       return new Token.Character(str);
/*     */     } 
/*  50 */     this.isEmitPending = false;
/*  51 */     return this.emitPending;
/*     */   }
/*     */ 
/*     */   
/*     */   void emit(Token paramToken) {
/*  56 */     Validate.isFalse(this.isEmitPending, "There is an unread token pending!");
/*     */     
/*  58 */     this.emitPending = paramToken;
/*  59 */     this.isEmitPending = true;
/*     */     
/*  61 */     if (paramToken.type == Token.TokenType.StartTag) {
/*  62 */       Token.StartTag startTag = (Token.StartTag)paramToken;
/*  63 */       this.lastStartTag = startTag;
/*  64 */       if (startTag.selfClosing)
/*  65 */         this.selfClosingFlagAcknowledged = false; 
/*  66 */     } else if (paramToken.type == Token.TokenType.EndTag) {
/*  67 */       Token.EndTag endTag = (Token.EndTag)paramToken;
/*  68 */       if (endTag.attributes != null) {
/*  69 */         error("Attributes incorrectly present on end tag");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   void emit(String paramString) {
/*  76 */     this.charBuffer.append(paramString);
/*     */   }
/*     */   
/*     */   void emit(char[] paramArrayOfchar) {
/*  80 */     this.charBuffer.append(paramArrayOfchar);
/*     */   }
/*     */   
/*     */   void emit(char paramChar) {
/*  84 */     this.charBuffer.append(paramChar);
/*     */   }
/*     */   
/*     */   TokeniserState getState() {
/*  88 */     return this.state;
/*     */   }
/*     */   
/*     */   void transition(TokeniserState paramTokeniserState) {
/*  92 */     this.state = paramTokeniserState;
/*     */   }
/*     */   
/*     */   void advanceTransition(TokeniserState paramTokeniserState) {
/*  96 */     this.reader.advance();
/*  97 */     this.state = paramTokeniserState;
/*     */   }
/*     */   
/*     */   void acknowledgeSelfClosingFlag() {
/* 101 */     this.selfClosingFlagAcknowledged = true;
/*     */   }
/*     */   
/*     */   char[] consumeCharacterReference(Character paramCharacter, boolean paramBoolean) {
/* 105 */     if (this.reader.isEmpty())
/* 106 */       return null; 
/* 107 */     if (paramCharacter != null && paramCharacter.charValue() == this.reader.current())
/* 108 */       return null; 
/* 109 */     if (this.reader.matchesAny(new char[] { '\t', '\n', '\r', '\f', ' ', '<', '&' })) {
/* 110 */       return null;
/*     */     }
/* 112 */     this.reader.mark();
/* 113 */     if (this.reader.matchConsume("#")) {
/* 114 */       boolean bool2 = this.reader.matchConsumeIgnoreCase("X");
/* 115 */       String str1 = bool2 ? this.reader.consumeHexSequence() : this.reader.consumeDigitSequence();
/* 116 */       if (str1.length() == 0) {
/* 117 */         characterReferenceError("numeric reference with no numerals");
/* 118 */         this.reader.rewindToMark();
/* 119 */         return null;
/*     */       } 
/* 121 */       if (!this.reader.matchConsume(";"))
/* 122 */         characterReferenceError("missing semicolon"); 
/* 123 */       int i = -1;
/*     */       try {
/* 125 */         byte b = bool2 ? 16 : 10;
/* 126 */         i = Integer.valueOf(str1, b).intValue();
/* 127 */       } catch (NumberFormatException numberFormatException) {}
/*     */       
/* 129 */       if (i == -1 || (i >= 55296 && i <= 57343) || i > 1114111) {
/* 130 */         characterReferenceError("character outside of valid range");
/* 131 */         return new char[] { '�' };
/*     */       } 
/*     */ 
/*     */       
/* 135 */       return Character.toChars(i);
/*     */     } 
/*     */ 
/*     */     
/* 139 */     String str = this.reader.consumeLetterThenDigitSequence();
/* 140 */     boolean bool = this.reader.matches(';');
/*     */     
/* 142 */     boolean bool1 = (Entities.isBaseNamedEntity(str) || (Entities.isNamedEntity(str) && bool)) ? true : false;
/*     */     
/* 144 */     if (!bool1) {
/* 145 */       this.reader.rewindToMark();
/* 146 */       if (bool)
/* 147 */         characterReferenceError(String.format("invalid named referenece '%s'", new Object[] { str })); 
/* 148 */       return null;
/*     */     } 
/* 150 */     if (paramBoolean && (this.reader.matchesLetter() || this.reader.matchesDigit() || this.reader.matchesAny(new char[] { '=', '-', '_' }))) {
/*     */       
/* 152 */       this.reader.rewindToMark();
/* 153 */       return null;
/*     */     } 
/* 155 */     if (!this.reader.matchConsume(";"))
/* 156 */       characterReferenceError("missing semicolon"); 
/* 157 */     return new char[] { Entities.getCharacterByName(str).charValue() };
/*     */   }
/*     */ 
/*     */   
/*     */   Token.Tag createTagPending(boolean paramBoolean) {
/* 162 */     this.tagPending = paramBoolean ? new Token.StartTag() : new Token.EndTag();
/* 163 */     return this.tagPending;
/*     */   }
/*     */   
/*     */   void emitTagPending() {
/* 167 */     this.tagPending.finaliseTag();
/* 168 */     emit(this.tagPending);
/*     */   }
/*     */   
/*     */   void createCommentPending() {
/* 172 */     this.commentPending = new Token.Comment();
/*     */   }
/*     */   
/*     */   void emitCommentPending() {
/* 176 */     emit(this.commentPending);
/*     */   }
/*     */   
/*     */   void createDoctypePending() {
/* 180 */     this.doctypePending = new Token.Doctype();
/*     */   }
/*     */   
/*     */   void emitDoctypePending() {
/* 184 */     emit(this.doctypePending);
/*     */   }
/*     */   
/*     */   void createTempBuffer() {
/* 188 */     this.dataBuffer = new StringBuilder();
/*     */   }
/*     */   
/*     */   boolean isAppropriateEndTagToken() {
/* 192 */     if (this.lastStartTag == null)
/* 193 */       return false; 
/* 194 */     return this.tagPending.tagName.equals(this.lastStartTag.tagName);
/*     */   }
/*     */   
/*     */   String appropriateEndTagName() {
/* 198 */     if (this.lastStartTag == null)
/* 199 */       return null; 
/* 200 */     return this.lastStartTag.tagName;
/*     */   }
/*     */   
/*     */   void error(TokeniserState paramTokeniserState) {
/* 204 */     if (this.errors.canAddError())
/* 205 */       this.errors.add(new ParseError(this.reader.pos(), "Unexpected character '%s' in input state [%s]", new Object[] { Character.valueOf(this.reader.current()), paramTokeniserState })); 
/*     */   }
/*     */   
/*     */   void eofError(TokeniserState paramTokeniserState) {
/* 209 */     if (this.errors.canAddError())
/* 210 */       this.errors.add(new ParseError(this.reader.pos(), "Unexpectedly reached end of file (EOF) in input state [%s]", new Object[] { paramTokeniserState })); 
/*     */   }
/*     */   
/*     */   private void characterReferenceError(String paramString) {
/* 214 */     if (this.errors.canAddError())
/* 215 */       this.errors.add(new ParseError(this.reader.pos(), "Invalid character reference: %s", new Object[] { paramString })); 
/*     */   }
/*     */   
/*     */   private void error(String paramString) {
/* 219 */     if (this.errors.canAddError()) {
/* 220 */       this.errors.add(new ParseError(this.reader.pos(), paramString));
/*     */     }
/*     */   }
/*     */   
/*     */   boolean currentNodeInHtmlNS() {
/* 225 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   String unescapeEntities(boolean paramBoolean) {
/* 236 */     StringBuilder stringBuilder = new StringBuilder();
/* 237 */     while (!this.reader.isEmpty()) {
/* 238 */       stringBuilder.append(this.reader.consumeTo('&'));
/* 239 */       if (this.reader.matches('&')) {
/* 240 */         this.reader.consume();
/* 241 */         char[] arrayOfChar = consumeCharacterReference(null, paramBoolean);
/* 242 */         if (arrayOfChar == null || arrayOfChar.length == 0) {
/* 243 */           stringBuilder.append('&'); continue;
/*     */         } 
/* 245 */         stringBuilder.append(arrayOfChar);
/*     */       } 
/*     */     } 
/* 248 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\Tokeniser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */