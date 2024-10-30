/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import javax.xml.xpath.XPathFactory;
/*    */ import org.apache.commons.lang3.StringUtils;
/*    */ import org.xml.sax.InputSource;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class XmlStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 45 */   static final XmlStringLookup INSTANCE = new XmlStringLookup();
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
/*    */   public String lookup(String paramString) {
/* 65 */     if (paramString == null) {
/* 66 */       return null;
/*    */     }
/* 68 */     String[] arrayOfString = paramString.split(SPLIT_STR);
/* 69 */     int i = arrayOfString.length;
/* 70 */     if (i != 2) {
/* 71 */       throw IllegalArgumentExceptions.format("Bad XML key format [%s]; expected format is DocumentPath:XPath.", new Object[] { paramString });
/*    */     }
/*    */     
/* 74 */     String str1 = arrayOfString[0];
/* 75 */     String str2 = StringUtils.substringAfter(paramString, 58);
/* 76 */     try (InputStream null = Files.newInputStream(Paths.get(str1, new String[0]), new java.nio.file.OpenOption[0])) {
/* 77 */       return XPathFactory.newInstance().newXPath().evaluate(str2, new InputSource(inputStream));
/* 78 */     } catch (Exception exception) {
/* 79 */       throw IllegalArgumentExceptions.format(exception, "Error looking up XML document [%s] and XPath [%s].", new Object[] { str1, str2 });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\XmlStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */