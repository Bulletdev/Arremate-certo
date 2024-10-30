/*     */ package ch.qos.logback.core.subst;
/*     */ 
/*     */ import ch.qos.logback.core.spi.PropertyContainer;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import ch.qos.logback.core.util.OptionHelper;
/*     */ import java.util.List;
/*     */ import java.util.Stack;
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
/*     */ public class NodeToStringTransformer
/*     */ {
/*     */   final Node node;
/*     */   final PropertyContainer propertyContainer0;
/*     */   final PropertyContainer propertyContainer1;
/*     */   
/*     */   public NodeToStringTransformer(Node paramNode, PropertyContainer paramPropertyContainer1, PropertyContainer paramPropertyContainer2) {
/*  36 */     this.node = paramNode;
/*  37 */     this.propertyContainer0 = paramPropertyContainer1;
/*  38 */     this.propertyContainer1 = paramPropertyContainer2;
/*     */   }
/*     */   
/*     */   public NodeToStringTransformer(Node paramNode, PropertyContainer paramPropertyContainer) {
/*  42 */     this(paramNode, paramPropertyContainer, null);
/*     */   }
/*     */   
/*     */   public static String substituteVariable(String paramString, PropertyContainer paramPropertyContainer1, PropertyContainer paramPropertyContainer2) throws ScanException {
/*  46 */     Node node = tokenizeAndParseString(paramString);
/*  47 */     NodeToStringTransformer nodeToStringTransformer = new NodeToStringTransformer(node, paramPropertyContainer1, paramPropertyContainer2);
/*  48 */     return nodeToStringTransformer.transform();
/*     */   }
/*     */   
/*     */   private static Node tokenizeAndParseString(String paramString) throws ScanException {
/*  52 */     Tokenizer tokenizer = new Tokenizer(paramString);
/*  53 */     List<Token> list = tokenizer.tokenize();
/*  54 */     Parser parser = new Parser(list);
/*  55 */     return parser.parse();
/*     */   }
/*     */   
/*     */   public String transform() throws ScanException {
/*  59 */     StringBuilder stringBuilder = new StringBuilder();
/*  60 */     compileNode(this.node, stringBuilder, new Stack<Node>());
/*  61 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private void compileNode(Node paramNode, StringBuilder paramStringBuilder, Stack<Node> paramStack) throws ScanException {
/*  65 */     Node node = paramNode;
/*  66 */     while (node != null) {
/*  67 */       switch (null.u[node.type.ordinal()]) {
/*     */         case 1:
/*  69 */           handleLiteral(node, paramStringBuilder);
/*     */           break;
/*     */         case 2:
/*  72 */           handleVariable(node, paramStringBuilder, paramStack);
/*     */           break;
/*     */       } 
/*  75 */       node = node.next;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void handleVariable(Node paramNode, StringBuilder paramStringBuilder, Stack<Node> paramStack) throws ScanException {
/*  82 */     if (haveVisitedNodeAlready(paramNode, paramStack)) {
/*  83 */       paramStack.push(paramNode);
/*  84 */       String str = constructRecursionErrorMessage(paramStack);
/*  85 */       throw new IllegalArgumentException(str);
/*     */     } 
/*  87 */     paramStack.push(paramNode);
/*     */     
/*  89 */     StringBuilder stringBuilder1 = new StringBuilder();
/*  90 */     Node node1 = (Node)paramNode.payload;
/*  91 */     compileNode(node1, stringBuilder1, paramStack);
/*  92 */     String str1 = stringBuilder1.toString();
/*  93 */     String str2 = lookupKey(str1);
/*     */     
/*  95 */     if (str2 != null) {
/*  96 */       Node node = tokenizeAndParseString(str2);
/*  97 */       compileNode(node, paramStringBuilder, paramStack);
/*  98 */       paramStack.pop();
/*     */       
/*     */       return;
/*     */     } 
/* 102 */     if (paramNode.defaultPart == null) {
/* 103 */       paramStringBuilder.append(str1 + "_IS_UNDEFINED");
/* 104 */       paramStack.pop();
/*     */       
/*     */       return;
/*     */     } 
/* 108 */     Node node2 = (Node)paramNode.defaultPart;
/* 109 */     StringBuilder stringBuilder2 = new StringBuilder();
/* 110 */     compileNode(node2, stringBuilder2, paramStack);
/* 111 */     paramStack.pop();
/* 112 */     String str3 = stringBuilder2.toString();
/* 113 */     paramStringBuilder.append(str3);
/*     */   }
/*     */   
/*     */   private String lookupKey(String paramString) {
/* 117 */     String str = this.propertyContainer0.getProperty(paramString);
/* 118 */     if (str != null) {
/* 119 */       return str;
/*     */     }
/* 121 */     if (this.propertyContainer1 != null) {
/* 122 */       str = this.propertyContainer1.getProperty(paramString);
/* 123 */       if (str != null) {
/* 124 */         return str;
/*     */       }
/*     */     } 
/* 127 */     str = OptionHelper.getSystemProperty(paramString, null);
/* 128 */     if (str != null) {
/* 129 */       return str;
/*     */     }
/* 131 */     str = OptionHelper.getEnv(paramString);
/* 132 */     if (str != null) {
/* 133 */       return str;
/*     */     }
/*     */     
/* 136 */     return null;
/*     */   }
/*     */   
/*     */   private void handleLiteral(Node paramNode, StringBuilder paramStringBuilder) {
/* 140 */     paramStringBuilder.append((String)paramNode.payload);
/*     */   }
/*     */   
/*     */   private String variableNodeValue(Node paramNode) {
/* 144 */     Node node = (Node)paramNode.payload;
/* 145 */     return (String)node.payload;
/*     */   }
/*     */   
/*     */   private String constructRecursionErrorMessage(Stack<Node> paramStack) {
/* 149 */     StringBuilder stringBuilder = new StringBuilder("Circular variable reference detected while parsing input [");
/*     */     
/* 151 */     for (Node node : paramStack) {
/* 152 */       stringBuilder.append("${").append(variableNodeValue(node)).append("}");
/* 153 */       if (paramStack.lastElement() != node) {
/* 154 */         stringBuilder.append(" --> ");
/*     */       }
/*     */     } 
/* 157 */     stringBuilder.append("]");
/* 158 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean haveVisitedNodeAlready(Node paramNode, Stack<Node> paramStack) {
/* 167 */     for (Node node : paramStack) {
/* 168 */       if (equalNodes(paramNode, node)) {
/* 169 */         return true;
/*     */       }
/*     */     } 
/* 172 */     return false;
/*     */   }
/*     */   
/*     */   private boolean equalNodes(Node paramNode1, Node paramNode2) {
/* 176 */     if (paramNode1.type != null && !paramNode1.type.equals(paramNode2.type))
/* 177 */       return false; 
/* 178 */     if (paramNode1.payload != null && !paramNode1.payload.equals(paramNode2.payload))
/* 179 */       return false; 
/* 180 */     if (paramNode1.defaultPart != null && !paramNode1.defaultPart.equals(paramNode2.defaultPart)) {
/* 181 */       return false;
/*     */     }
/* 183 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\subst\NodeToStringTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */