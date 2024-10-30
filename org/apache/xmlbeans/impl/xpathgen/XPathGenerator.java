/*     */ package org.apache.xmlbeans.impl.xpathgen;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import javax.xml.namespace.a;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
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
/*     */ public class XPathGenerator
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static String generateXPath(XmlCursor paramXmlCursor1, XmlCursor paramXmlCursor2, a parama) throws XPathGenerationException {
/*     */     b b;
/*     */     String str1, str2;
/*     */     int i;
/*  31 */     if (paramXmlCursor1 == null)
/*  32 */       throw new IllegalArgumentException("Null node"); 
/*  33 */     if (parama == null)
/*  34 */       throw new IllegalArgumentException("Null namespace context"); 
/*  35 */     XmlCursor.TokenType tokenType = paramXmlCursor1.currentTokenType();
/*  36 */     if (paramXmlCursor2 != null && paramXmlCursor1.isAtSamePositionAs(paramXmlCursor2))
/*  37 */       return "."; 
/*  38 */     switch (tokenType.intValue()) {
/*     */       
/*     */       case 6:
/*  41 */         b = paramXmlCursor1.getName();
/*  42 */         paramXmlCursor1.toParent();
/*  43 */         str1 = generateInternal(paramXmlCursor1, paramXmlCursor2, parama);
/*  44 */         return str1 + '/' + '@' + qnameToString(b, parama);
/*     */       case 7:
/*  46 */         b = paramXmlCursor1.getName();
/*  47 */         paramXmlCursor1.toParent();
/*  48 */         str1 = generateInternal(paramXmlCursor1, paramXmlCursor2, parama);
/*  49 */         str2 = b.dT();
/*  50 */         if (str2.length() == 0) {
/*  51 */           return str1 + "/@xmlns";
/*     */         }
/*  53 */         return str1 + "/@xmlns:" + str2;
/*     */       case 1:
/*     */       case 3:
/*  56 */         return generateInternal(paramXmlCursor1, paramXmlCursor2, parama);
/*     */       case 5:
/*  58 */         i = countTextTokens(paramXmlCursor1);
/*  59 */         paramXmlCursor1.toParent();
/*  60 */         str1 = generateInternal(paramXmlCursor1, paramXmlCursor2, parama);
/*  61 */         if (i == 0) {
/*  62 */           return str1 + "/text()";
/*     */         }
/*  64 */         return str1 + "/text()[position()=" + i + ']';
/*     */     } 
/*  66 */     throw new XPathGenerationException("Cannot generate XPath for cursor position: " + tokenType.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String generateInternal(XmlCursor paramXmlCursor1, XmlCursor paramXmlCursor2, a parama) throws XPathGenerationException {
/*  74 */     if (paramXmlCursor1.isStartdoc())
/*  75 */       return ""; 
/*  76 */     if (paramXmlCursor2 != null && paramXmlCursor1.isAtSamePositionAs(paramXmlCursor2))
/*  77 */       return "."; 
/*  78 */     assert paramXmlCursor1.isStart();
/*  79 */     b b = paramXmlCursor1.getName();
/*  80 */     XmlCursor xmlCursor = paramXmlCursor1.newCursor();
/*  81 */     if (!paramXmlCursor1.toParent())
/*  82 */       return "/" + b; 
/*  83 */     byte b1 = 0, b2 = 1;
/*  84 */     paramXmlCursor1.push();
/*  85 */     if (!paramXmlCursor1.toChild(b)) {
/*  86 */       throw new IllegalStateException("Must have at least one child with name: " + b);
/*     */     }
/*     */     while (true) {
/*  89 */       if (paramXmlCursor1.isAtSamePositionAs(xmlCursor)) {
/*  90 */         b1 = b2;
/*     */       } else {
/*  92 */         b2++;
/*  93 */       }  if (!paramXmlCursor1.toNextSibling(b)) {
/*  94 */         paramXmlCursor1.pop();
/*  95 */         xmlCursor.dispose();
/*  96 */         String str = generateInternal(paramXmlCursor1, paramXmlCursor2, parama);
/*  97 */         return (b2 == 1) ? (str + '/' + qnameToString(b, parama)) : (str + '/' + qnameToString(b, parama) + '[' + b1 + ']');
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String qnameToString(b paramb, a parama) throws XPathGenerationException {
/* 104 */     String str1 = paramb.dT();
/* 105 */     String str2 = paramb.getNamespaceURI();
/* 106 */     if (str2.length() == 0)
/* 107 */       return str1; 
/* 108 */     String str3 = paramb.getPrefix();
/* 109 */     if (str3 != null && str3.length() > 0) {
/*     */ 
/*     */       
/* 112 */       String str = parama.getNamespaceURI(str3);
/* 113 */       if (str2.equals(str)) {
/* 114 */         return str3 + ':' + str1;
/*     */       }
/*     */     } 
/* 117 */     str3 = parama.getPrefix(str2);
/* 118 */     if (str3 == null)
/* 119 */       throw new XPathGenerationException("Could not obtain a prefix for URI: " + str2); 
/* 120 */     if (str3.length() == 0)
/* 121 */       throw new XPathGenerationException("Can not use default prefix in XPath for URI: " + str2); 
/* 122 */     return str3 + ':' + str1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int countTextTokens(XmlCursor paramXmlCursor) {
/* 132 */     byte b1 = 0;
/* 133 */     byte b2 = 0;
/* 134 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 135 */     paramXmlCursor.push();
/* 136 */     paramXmlCursor.toParent();
/* 137 */     XmlCursor.TokenType tokenType = paramXmlCursor.toFirstContentToken();
/* 138 */     while (!tokenType.isEnd()) {
/*     */       
/* 140 */       if (tokenType.isText()) {
/*     */         
/* 142 */         if (paramXmlCursor.comparePosition(xmlCursor) > 0) {
/*     */           
/* 144 */           b2++;
/*     */         } else {
/* 146 */           b1++;
/*     */         } 
/* 148 */       } else if (tokenType.isStart()) {
/* 149 */         paramXmlCursor.toEndToken();
/* 150 */       }  tokenType = paramXmlCursor.toNextToken();
/*     */     } 
/* 152 */     paramXmlCursor.pop();
/* 153 */     return (b2 == 0) ? 0 : b1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws XmlException {
/* 158 */     String str = "<root>\n<ns:a xmlns:ns=\"http://a.com\"><b foo=\"value\">text1<c/>text2<c/>text3<c>text</c>text4</b></ns:a>\n</root>";
/*     */ 
/*     */ 
/*     */     
/* 162 */     a a = new a()
/*     */       {
/*     */         public String getNamespaceURI(String param1String) {
/* 165 */           if ("ns".equals(param1String)) {
/* 166 */             return "http://a.com";
/*     */           }
/* 168 */           return null;
/*     */         }
/*     */         
/*     */         public String getPrefix(String param1String) {
/* 172 */           return null;
/*     */         }
/*     */         
/*     */         public Iterator getPrefixes(String param1String) {
/* 176 */           return null;
/*     */         }
/*     */       };
/* 179 */     XmlCursor xmlCursor1 = XmlObject.Factory.parse(str).newCursor();
/* 180 */     xmlCursor1.toFirstContentToken();
/* 181 */     xmlCursor1.toFirstContentToken();
/* 182 */     xmlCursor1.toFirstChild();
/* 183 */     xmlCursor1.toFirstChild();
/* 184 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, null, a)); xmlCursor1.pop();
/* 185 */     xmlCursor1.toNextSibling();
/* 186 */     xmlCursor1.toNextSibling();
/* 187 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, null, a)); xmlCursor1.pop();
/* 188 */     XmlCursor xmlCursor2 = xmlCursor1.newCursor();
/* 189 */     xmlCursor2.toParent();
/* 190 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 191 */     xmlCursor2.toParent();
/* 192 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 193 */     xmlCursor1.toFirstContentToken();
/* 194 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 195 */     xmlCursor1.toParent();
/* 196 */     xmlCursor1.toPrevToken();
/* 197 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 198 */     xmlCursor1.toParent();
/* 199 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 200 */     xmlCursor1.toFirstAttribute();
/* 201 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 202 */     xmlCursor1.toParent();
/* 203 */     xmlCursor1.toParent();
/* 204 */     xmlCursor1.toNextToken();
/* 205 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, xmlCursor2, a)); xmlCursor1.pop();
/* 206 */     xmlCursor1.push(); System.out.println(generateXPath(xmlCursor1, null, a)); xmlCursor1.pop();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xpathgen\XPathGenerator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */