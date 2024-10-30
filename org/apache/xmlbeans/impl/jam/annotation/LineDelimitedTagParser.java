/*    */ package org.apache.xmlbeans.impl.jam.annotation;
/*    */ 
/*    */ import com.sun.javadoc.Tag;
/*    */ import java.io.StringWriter;
/*    */ import java.util.StringTokenizer;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotatedElement;
/*    */ import org.apache.xmlbeans.impl.jam.mutable.MAnnotation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LineDelimitedTagParser
/*    */   extends JavadocTagParser
/*    */ {
/*    */   private static final String VALUE_QUOTE = "\"";
/*    */   private static final String LINE_DELIMS = "\n\f\r";
/*    */   
/*    */   public void parse(MAnnotatedElement paramMAnnotatedElement, Tag paramTag) {
/* 42 */     if (paramMAnnotatedElement == null) throw new IllegalArgumentException("null tagText"); 
/* 43 */     if (paramTag == null) throw new IllegalArgumentException("null tagName"); 
/* 44 */     MAnnotation[] arrayOfMAnnotation = createAnnotations(paramMAnnotatedElement, paramTag);
/* 45 */     String str = paramTag.text();
/* 46 */     StringTokenizer stringTokenizer = new StringTokenizer(str, "\n\f\r");
/* 47 */     while (stringTokenizer.hasMoreTokens()) {
/* 48 */       String str1 = stringTokenizer.nextToken();
/* 49 */       int i = str1.indexOf('=');
/* 50 */       if (i <= 0)
/* 51 */         continue;  String str2 = str1.substring(0, i).trim();
/* 52 */       if (i < str1.length() - 1) {
/* 53 */         String str3 = str1.substring(i + 1).trim();
/* 54 */         if (str3.startsWith("\"")) {
/* 55 */           str3 = parseQuotedValue(str3.substring(1), stringTokenizer);
/*    */         }
/* 57 */         setValue(arrayOfMAnnotation, str2, str3);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private String parseQuotedValue(String paramString, StringTokenizer paramStringTokenizer) {
/*    */     int i;
/* 66 */     StringWriter stringWriter = new StringWriter();
/*    */     while (true) {
/* 68 */       i = paramString.indexOf("\"");
/* 69 */       if (i == -1) {
/* 70 */         stringWriter.write(paramString);
/* 71 */         if (!paramStringTokenizer.hasMoreTokens()) return stringWriter.toString(); 
/* 72 */         stringWriter.write(10);
/* 73 */         paramString = paramStringTokenizer.nextToken().trim(); continue;
/*    */       }  break;
/*    */     } 
/* 76 */     stringWriter.write(paramString.substring(0, i).trim());
/* 77 */     return stringWriter.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\annotation\LineDelimitedTagParser.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */