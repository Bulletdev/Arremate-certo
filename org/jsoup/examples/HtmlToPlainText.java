/*     */ package org.jsoup.examples;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.jsoup.Jsoup;
/*     */ import org.jsoup.helper.StringUtil;
/*     */ import org.jsoup.helper.Validate;
/*     */ import org.jsoup.nodes.Document;
/*     */ import org.jsoup.nodes.Element;
/*     */ import org.jsoup.nodes.Node;
/*     */ import org.jsoup.nodes.TextNode;
/*     */ import org.jsoup.select.NodeTraversor;
/*     */ import org.jsoup.select.NodeVisitor;
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
/*     */ public class HtmlToPlainText
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws IOException {
/*  26 */     Validate.isTrue((paramVarArgs.length == 1), "usage: supply url to fetch");
/*  27 */     String str1 = paramVarArgs[0];
/*     */ 
/*     */     
/*  30 */     Document document = Jsoup.connect(str1).get();
/*     */     
/*  32 */     HtmlToPlainText htmlToPlainText = new HtmlToPlainText();
/*  33 */     String str2 = htmlToPlainText.getPlainText((Element)document);
/*  34 */     System.out.println(str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlainText(Element paramElement) {
/*  43 */     FormattingVisitor formattingVisitor = new FormattingVisitor();
/*  44 */     NodeTraversor nodeTraversor = new NodeTraversor(formattingVisitor);
/*  45 */     nodeTraversor.traverse((Node)paramElement);
/*     */     
/*  47 */     return formattingVisitor.toString();
/*     */   }
/*     */   
/*     */   private class FormattingVisitor
/*     */     implements NodeVisitor {
/*     */     private static final int maxWidth = 80;
/*  53 */     private int width = 0;
/*  54 */     private StringBuilder accum = new StringBuilder();
/*     */ 
/*     */     
/*     */     public void head(Node param1Node, int param1Int) {
/*  58 */       String str = param1Node.nodeName();
/*  59 */       if (param1Node instanceof TextNode) {
/*  60 */         append(((TextNode)param1Node).text());
/*  61 */       } else if (str.equals("li")) {
/*  62 */         append("\n * ");
/*     */       } 
/*     */     }
/*     */     
/*     */     public void tail(Node param1Node, int param1Int) {
/*  67 */       String str = param1Node.nodeName();
/*  68 */       if (str.equals("br")) {
/*  69 */         append("\n");
/*  70 */       } else if (StringUtil.in(str, new String[] { "p", "h1", "h2", "h3", "h4", "h5" })) {
/*  71 */         append("\n\n");
/*  72 */       } else if (str.equals("a")) {
/*  73 */         append(String.format(" <%s>", new Object[] { param1Node.absUrl("href") }));
/*     */       } 
/*     */     }
/*     */     
/*     */     private void append(String param1String) {
/*  78 */       if (param1String.startsWith("\n"))
/*  79 */         this.width = 0; 
/*  80 */       if (param1String.equals(" ") && (this.accum.length() == 0 || StringUtil.in(this.accum.substring(this.accum.length() - 1), new String[] { " ", "\n" }))) {
/*     */         return;
/*     */       }
/*     */       
/*  84 */       if (param1String.length() + this.width > 80) {
/*  85 */         String[] arrayOfString = param1String.split("\\s+");
/*  86 */         for (byte b = 0; b < arrayOfString.length; b++) {
/*  87 */           String str = arrayOfString[b];
/*  88 */           boolean bool = (b == arrayOfString.length - 1) ? true : false;
/*  89 */           if (!bool)
/*  90 */             str = str + " "; 
/*  91 */           if (str.length() + this.width > 80) {
/*  92 */             this.accum.append("\n").append(str);
/*  93 */             this.width = str.length();
/*     */           } else {
/*  95 */             this.accum.append(str);
/*  96 */             this.width += str.length();
/*     */           } 
/*     */         } 
/*     */       } else {
/* 100 */         this.accum.append(param1String);
/* 101 */         this.width += param1String.length();
/*     */       } 
/*     */     }
/*     */     
/*     */     public String toString() {
/* 106 */       return this.accum.toString();
/*     */     }
/*     */     
/*     */     private FormattingVisitor() {}
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\jsoup\examples\HtmlToPlainText.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */