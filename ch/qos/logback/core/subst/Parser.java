/*     */ package ch.qos.logback.core.subst;
/*     */ 
/*     */ import ch.qos.logback.core.CoreConstants;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import java.util.List;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parser
/*     */ {
/*     */   final List<Token> tokenList;
/*  38 */   int pointer = 0;
/*     */   
/*     */   public Parser(List<Token> paramList) {
/*  41 */     this.tokenList = paramList;
/*     */   }
/*     */   
/*     */   public Node parse() throws ScanException {
/*  45 */     if (this.tokenList == null || this.tokenList.isEmpty())
/*  46 */       return null; 
/*  47 */     return E();
/*     */   }
/*     */   
/*     */   private Node E() throws ScanException {
/*  51 */     Node node1 = T();
/*  52 */     if (node1 == null) {
/*  53 */       return null;
/*     */     }
/*  55 */     Node node2 = Eopt();
/*  56 */     if (node2 != null) {
/*  57 */       node1.append(node2);
/*     */     }
/*  59 */     return node1;
/*     */   }
/*     */ 
/*     */   
/*     */   private Node Eopt() throws ScanException {
/*  64 */     Token token = peekAtCurentToken();
/*  65 */     if (token == null) {
/*  66 */       return null;
/*     */     }
/*  68 */     return E();
/*     */   }
/*     */   private Node T() throws ScanException {
/*     */     Node node1;
/*     */     Token token2;
/*     */     Node node2, node3;
/*  74 */     Token token3, token1 = peekAtCurentToken();
/*     */     
/*  76 */     switch (null.v[token1.type.ordinal()]) {
/*     */       case 1:
/*  78 */         advanceTokenPointer();
/*  79 */         return makeNewLiteralNode(token1.payload);
/*     */       case 2:
/*  81 */         advanceTokenPointer();
/*  82 */         node1 = C();
/*  83 */         token2 = peekAtCurentToken();
/*  84 */         expectCurlyRight(token2);
/*  85 */         advanceTokenPointer();
/*  86 */         node2 = makeNewLiteralNode(CoreConstants.LEFT_ACCOLADE);
/*  87 */         node2.append(node1);
/*  88 */         node2.append(makeNewLiteralNode(CoreConstants.RIGHT_ACCOLADE));
/*  89 */         return node2;
/*     */       case 3:
/*  91 */         advanceTokenPointer();
/*  92 */         node3 = V();
/*  93 */         token3 = peekAtCurentToken();
/*  94 */         expectCurlyRight(token3);
/*  95 */         advanceTokenPointer();
/*  96 */         return node3;
/*     */     } 
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private Node makeNewLiteralNode(String paramString) {
/* 103 */     return new Node((Node.a)Node.a.a, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private Node V() throws ScanException {
/* 108 */     Node node1 = E();
/* 109 */     Node node2 = new Node(Node.a.b, node1);
/* 110 */     Token token = peekAtCurentToken();
/* 111 */     if (isDefaultToken(token)) {
/* 112 */       advanceTokenPointer();
/* 113 */       Node node = E();
/* 114 */       node2.defaultPart = node;
/*     */     } 
/* 116 */     return node2;
/*     */   }
/*     */ 
/*     */   
/*     */   private Node C() throws ScanException {
/* 121 */     Node node = E();
/* 122 */     Token token = peekAtCurentToken();
/* 123 */     if (isDefaultToken(token)) {
/* 124 */       advanceTokenPointer();
/* 125 */       Node node1 = makeNewLiteralNode(":-");
/* 126 */       node.append(node1);
/* 127 */       Node node2 = E();
/* 128 */       node.append(node2);
/*     */     } 
/* 130 */     return node;
/*     */   }
/*     */   
/*     */   private boolean isDefaultToken(Token paramToken) {
/* 134 */     return (paramToken != null && paramToken.type == Token.Type.DEFAULT);
/*     */   }
/*     */   
/*     */   void advanceTokenPointer() {
/* 138 */     this.pointer++;
/*     */   }
/*     */   
/*     */   void expectNotNull(Token paramToken, String paramString) {
/* 142 */     if (paramToken == null) {
/* 143 */       throw new IllegalArgumentException("All tokens consumed but was expecting \"" + paramString + "\"");
/*     */     }
/*     */   }
/*     */   
/*     */   void expectCurlyRight(Token paramToken) throws ScanException {
/* 148 */     expectNotNull(paramToken, "}");
/* 149 */     if (paramToken.type != Token.Type.CURLY_RIGHT) {
/* 150 */       throw new ScanException("Expecting }");
/*     */     }
/*     */   }
/*     */   
/*     */   Token peekAtCurentToken() {
/* 155 */     if (this.pointer < this.tokenList.size()) {
/* 156 */       return this.tokenList.get(this.pointer);
/*     */     }
/* 158 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\subst\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */