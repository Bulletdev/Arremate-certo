/*     */ package ch.qos.logback.core.pattern.parser;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.Converter;
/*     */ import ch.qos.logback.core.pattern.FormatInfo;
/*     */ import ch.qos.logback.core.pattern.IdentityCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.ReplacingCompositeConverter;
/*     */ import ch.qos.logback.core.pattern.util.IEscapeUtil;
/*     */ import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.spi.ScanException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ public class Parser<E>
/*     */   extends ContextAwareBase
/*     */ {
/*     */   public static final String MISSING_RIGHT_PARENTHESIS = "http://logback.qos.ch/codes.html#missingRightParenthesis";
/*  47 */   public static final Map<String, String> DEFAULT_COMPOSITE_CONVERTER_MAP = new HashMap<String, String>();
/*     */   
/*     */   static {
/*  50 */     DEFAULT_COMPOSITE_CONVERTER_MAP.put(b.c.getValue().toString(), IdentityCompositeConverter.class.getName());
/*  51 */     DEFAULT_COMPOSITE_CONVERTER_MAP.put("replace", ReplacingCompositeConverter.class.getName());
/*     */   }
/*     */   public static final String REPLACE_CONVERTER_WORD = "replace";
/*     */   final List tokenList;
/*  55 */   int pointer = 0;
/*     */   
/*     */   Parser(c paramc) throws ScanException {
/*  58 */     this.tokenList = paramc.tokenize();
/*     */   }
/*     */   
/*     */   public Parser(String paramString) throws ScanException {
/*  62 */     this(paramString, (IEscapeUtil)new RegularEscapeUtil());
/*     */   }
/*     */   
/*     */   public Parser(String paramString, IEscapeUtil paramIEscapeUtil) throws ScanException {
/*     */     try {
/*  67 */       c c = new c(paramString, paramIEscapeUtil);
/*  68 */       this.tokenList = c.tokenize();
/*  69 */     } catch (IllegalArgumentException illegalArgumentException) {
/*  70 */       throw new ScanException("Failed to initialize Parser", illegalArgumentException);
/*     */     } 
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
/*     */   public Converter<E> compile(Node paramNode, Map paramMap) {
/*  84 */     a<E> a = new a(paramNode, paramMap);
/*  85 */     a.setContext(this.context);
/*     */     
/*  87 */     return a.a();
/*     */   }
/*     */   
/*     */   public Node parse() throws ScanException {
/*  91 */     return E();
/*     */   }
/*     */ 
/*     */   
/*     */   Node E() throws ScanException {
/*  96 */     Node node1 = T();
/*  97 */     if (node1 == null) {
/*  98 */       return null;
/*     */     }
/* 100 */     Node node2 = Eopt();
/* 101 */     if (node2 != null) {
/* 102 */       node1.setNext(node2);
/*     */     }
/* 104 */     return node1;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   Node Eopt() throws ScanException {
/* 110 */     b b = getCurentToken();
/*     */     
/* 112 */     if (b == null) {
/* 113 */       return null;
/*     */     }
/* 115 */     return E();
/*     */   }
/*     */   
/*     */   Node T() throws ScanException {
/*     */     b b2;
/*     */     FormattingNode formattingNode;
/* 121 */     b b1 = getCurentToken();
/* 122 */     expectNotNull(b1, "a LITERAL or '%'");
/*     */     
/* 124 */     switch (b1.getType()) {
/*     */       case 1000:
/* 126 */         advanceTokenPointer();
/* 127 */         return new Node(0, b1.getValue());
/*     */       case 37:
/* 129 */         advanceTokenPointer();
/*     */ 
/*     */         
/* 132 */         b2 = getCurentToken();
/*     */         
/* 134 */         expectNotNull(b2, "a FORMAT_MODIFIER, SIMPLE_KEYWORD or COMPOUND_KEYWORD");
/* 135 */         if (b2.getType() == 1002) {
/* 136 */           FormatInfo formatInfo = FormatInfo.valueOf((String)b2.getValue());
/* 137 */           advanceTokenPointer();
/* 138 */           formattingNode = C();
/* 139 */           formattingNode.setFormatInfo(formatInfo);
/*     */         } else {
/* 141 */           formattingNode = C();
/*     */         } 
/* 143 */         return formattingNode;
/*     */     } 
/*     */     
/* 146 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   FormattingNode C() throws ScanException {
/* 153 */     b b = getCurentToken();
/*     */ 
/*     */     
/* 156 */     expectNotNull(b, "a LEFT_PARENTHESIS or KEYWORD");
/* 157 */     int i = b.getType();
/* 158 */     switch (i) {
/*     */       case 1004:
/* 160 */         return SINGLE();
/*     */       case 1005:
/* 162 */         advanceTokenPointer();
/* 163 */         return COMPOSITE(b.getValue().toString());
/*     */     } 
/* 165 */     throw new IllegalStateException("Unexpected token " + b);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   FormattingNode SINGLE() throws ScanException {
/* 171 */     b b1 = getNextToken();
/*     */     
/* 173 */     SimpleKeywordNode simpleKeywordNode = new SimpleKeywordNode(b1.getValue());
/*     */     
/* 175 */     b b2 = getCurentToken();
/* 176 */     if (b2 != null && b2.getType() == 1006) {
/* 177 */       List<String> list = (List)b2.getValue();
/* 178 */       simpleKeywordNode.setOptions(list);
/* 179 */       advanceTokenPointer();
/*     */     } 
/* 181 */     return simpleKeywordNode;
/*     */   }
/*     */   
/*     */   FormattingNode COMPOSITE(String paramString) throws ScanException {
/* 185 */     CompositeNode compositeNode = new CompositeNode(paramString);
/*     */     
/* 187 */     Node node = E();
/* 188 */     compositeNode.setChildNode(node);
/*     */     
/* 190 */     b b1 = getNextToken();
/*     */     
/* 192 */     if (b1 == null || b1.getType() != 41) {
/* 193 */       String str = "Expecting RIGHT_PARENTHESIS token but got " + b1;
/* 194 */       addError(str);
/* 195 */       addError("See also http://logback.qos.ch/codes.html#missingRightParenthesis");
/* 196 */       throw new ScanException(str);
/*     */     } 
/* 198 */     b b2 = getCurentToken();
/* 199 */     if (b2 != null && b2.getType() == 1006) {
/* 200 */       List<String> list = (List)b2.getValue();
/* 201 */       compositeNode.setOptions(list);
/* 202 */       advanceTokenPointer();
/*     */     } 
/* 204 */     return compositeNode;
/*     */   }
/*     */   
/*     */   b getNextToken() {
/* 208 */     if (this.pointer < this.tokenList.size()) {
/* 209 */       return this.tokenList.get(this.pointer++);
/*     */     }
/* 211 */     return null;
/*     */   }
/*     */   
/*     */   b getCurentToken() {
/* 215 */     if (this.pointer < this.tokenList.size()) {
/* 216 */       return this.tokenList.get(this.pointer);
/*     */     }
/* 218 */     return null;
/*     */   }
/*     */   
/*     */   void advanceTokenPointer() {
/* 222 */     this.pointer++;
/*     */   }
/*     */   
/*     */   void expectNotNull(b paramb, String paramString) {
/* 226 */     if (paramb == null)
/* 227 */       throw new IllegalStateException("All tokens consumed but was expecting " + paramString); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\pattern\parser\Parser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */