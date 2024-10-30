/*    */ package org.jsoup.parser;
/*    */ 
/*    */ import org.jsoup.helper.DescendableLinkedList;
/*    */ import org.jsoup.helper.Validate;
/*    */ import org.jsoup.nodes.Document;
/*    */ import org.jsoup.nodes.Element;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class TreeBuilder
/*    */ {
/*    */   CharacterReader reader;
/*    */   Tokeniser tokeniser;
/*    */   protected Document doc;
/*    */   protected DescendableLinkedList<Element> stack;
/*    */   protected String baseUri;
/*    */   protected Token currentToken;
/*    */   protected ParseErrorList errors;
/*    */   
/*    */   protected void initialiseParse(String paramString1, String paramString2, ParseErrorList paramParseErrorList) {
/* 24 */     Validate.notNull(paramString1, "String input must not be null");
/* 25 */     Validate.notNull(paramString2, "BaseURI must not be null");
/*    */     
/* 27 */     this.doc = new Document(paramString2);
/* 28 */     this.reader = new CharacterReader(paramString1);
/* 29 */     this.errors = paramParseErrorList;
/* 30 */     this.tokeniser = new Tokeniser(this.reader, paramParseErrorList);
/* 31 */     this.stack = new DescendableLinkedList();
/* 32 */     this.baseUri = paramString2;
/*    */   }
/*    */   
/*    */   Document parse(String paramString1, String paramString2) {
/* 36 */     return parse(paramString1, paramString2, ParseErrorList.noTracking());
/*    */   }
/*    */   
/*    */   Document parse(String paramString1, String paramString2, ParseErrorList paramParseErrorList) {
/* 40 */     initialiseParse(paramString1, paramString2, paramParseErrorList);
/* 41 */     runParser();
/* 42 */     return this.doc;
/*    */   }
/*    */   protected void runParser() {
/*    */     Token token;
/*    */     do {
/* 47 */       token = this.tokeniser.read();
/* 48 */       process(token);
/*    */     }
/* 50 */     while (token.type != Token.TokenType.EOF);
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract boolean process(Token paramToken);
/*    */ 
/*    */   
/*    */   protected Element currentElement() {
/* 58 */     return (Element)this.stack.getLast();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\TreeBuilder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */