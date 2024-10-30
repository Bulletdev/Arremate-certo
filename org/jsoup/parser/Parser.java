/*     */ package org.jsoup.parser;
/*     */ 
/*     */ import java.util.List;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Parser
/*     */ {
/*     */   private static final int DEFAULT_MAX_ERRORS = 0;
/*     */   private TreeBuilder treeBuilder;
/*  17 */   private int maxErrors = 0;
/*     */ 
/*     */   
/*     */   private ParseErrorList errors;
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser(TreeBuilder paramTreeBuilder) {
/*  25 */     this.treeBuilder = paramTreeBuilder;
/*     */   }
/*     */   
/*     */   public Document parseInput(String paramString1, String paramString2) {
/*  29 */     this.errors = isTrackErrors() ? ParseErrorList.tracking(this.maxErrors) : ParseErrorList.noTracking();
/*  30 */     return this.treeBuilder.parse(paramString1, paramString2, this.errors);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TreeBuilder getTreeBuilder() {
/*  40 */     return this.treeBuilder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser setTreeBuilder(TreeBuilder paramTreeBuilder) {
/*  49 */     this.treeBuilder = paramTreeBuilder;
/*  50 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isTrackErrors() {
/*  58 */     return (this.maxErrors > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Parser setTrackErrors(int paramInt) {
/*  67 */     this.maxErrors = paramInt;
/*  68 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ParseError> getErrors() {
/*  76 */     return this.errors;
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
/*     */   public static Document parse(String paramString1, String paramString2) {
/*  89 */     HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
/*  90 */     return htmlTreeBuilder.parse(paramString1, paramString2, ParseErrorList.noTracking());
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
/*     */   
/*     */   public static List<Node> parseFragment(String paramString1, Element paramElement, String paramString2) {
/* 104 */     HtmlTreeBuilder htmlTreeBuilder = new HtmlTreeBuilder();
/* 105 */     return htmlTreeBuilder.parseFragment(paramString1, paramElement, paramString2, ParseErrorList.noTracking());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<Node> parseXmlFragment(String paramString1, String paramString2) {
/* 116 */     XmlTreeBuilder xmlTreeBuilder = new XmlTreeBuilder();
/* 117 */     return xmlTreeBuilder.parseFragment(paramString1, paramString2, ParseErrorList.noTracking());
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
/*     */   public static Document parseBodyFragment(String paramString1, String paramString2) {
/* 129 */     Document document = Document.createShell(paramString2);
/* 130 */     Element element = document.body();
/* 131 */     List<Node> list = parseFragment(paramString1, element, paramString2);
/* 132 */     Node[] arrayOfNode = list.<Node>toArray(new Node[list.size()]);
/* 133 */     for (Node node : arrayOfNode) {
/* 134 */       element.appendChild(node);
/*     */     }
/* 136 */     return document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeEntities(String paramString, boolean paramBoolean) {
/* 146 */     Tokeniser tokeniser = new Tokeniser(new CharacterReader(paramString), ParseErrorList.noTracking());
/* 147 */     return tokeniser.unescapeEntities(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Document parseBodyFragmentRelaxed(String paramString1, String paramString2) {
/* 158 */     return parse(paramString1, paramString2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Parser htmlParser() {
/* 169 */     return new Parser(new HtmlTreeBuilder());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Parser xmlParser() {
/* 178 */     return new Parser(new XmlTreeBuilder());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\parser\Parser.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */