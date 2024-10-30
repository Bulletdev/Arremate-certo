/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.io.InputStream;
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
/*    */ import java.util.Properties;
/*    */ import org.apache.commons.lang3.StringUtils;
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
/*    */ 
/*    */ 
/*    */ final class PropertiesStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 46 */   static final PropertiesStringLookup INSTANCE = new PropertiesStringLookup();
/*    */ 
/*    */ 
/*    */   
/*    */   static final String SEPARATOR = "::";
/*    */ 
/*    */ 
/*    */   
/*    */   static String toPropertyKey(String paramString1, String paramString2) {
/* 55 */     return AbstractStringLookup.toLookupKey(paramString1, "::", paramString2);
/*    */   }
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
/*    */   public String lookup(String paramString) {
/* 79 */     if (paramString == null) {
/* 80 */       return null;
/*    */     }
/* 82 */     String[] arrayOfString = paramString.split("::");
/* 83 */     int i = arrayOfString.length;
/* 84 */     if (i < 2) {
/* 85 */       throw IllegalArgumentExceptions.format("Bad properties key format [%s]; expected format is %s.", new Object[] { paramString, 
/* 86 */             toPropertyKey("DocumentPath", "Key") });
/*    */     }
/* 88 */     String str1 = arrayOfString[0];
/* 89 */     String str2 = StringUtils.substringAfter(paramString, "::");
/*    */     try {
/* 91 */       Properties properties = new Properties();
/* 92 */       try (InputStream null = Files.newInputStream(Paths.get(str1, new String[0]), new java.nio.file.OpenOption[0])) {
/* 93 */         properties.load(inputStream);
/*    */       } 
/* 95 */       return properties.getProperty(str2);
/* 96 */     } catch (Exception exception) {
/* 97 */       throw IllegalArgumentExceptions.format(exception, "Error looking up properties [%s] and key [%s].", new Object[] { str1, str2 });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\PropertiesStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */