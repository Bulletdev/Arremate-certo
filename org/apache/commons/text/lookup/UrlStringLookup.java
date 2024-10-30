/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.io.BufferedInputStream;
/*    */ import java.io.InputStreamReader;
/*    */ import java.io.StringWriter;
/*    */ import java.net.URL;
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
/*    */ final class UrlStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 43 */   static final UrlStringLookup INSTANCE = new UrlStringLookup();
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
/* 63 */     if (paramString == null) {
/* 64 */       return null;
/*    */     }
/* 66 */     String[] arrayOfString = paramString.split(SPLIT_STR);
/* 67 */     int i = arrayOfString.length;
/* 68 */     if (i < 2) {
/* 69 */       throw IllegalArgumentExceptions.format("Bad URL key format [%s]; expected format is DocumentPath:Key.", new Object[] { paramString });
/*    */     }
/*    */     
/* 72 */     String str1 = arrayOfString[0];
/* 73 */     String str2 = StringUtils.substringAfter(paramString, 58);
/*    */     try {
/* 75 */       URL uRL = new URL(str2);
/* 76 */       char c = ' ';
/* 77 */       StringWriter stringWriter = new StringWriter(8192);
/* 78 */       char[] arrayOfChar = new char[8192];
/* 79 */       try(BufferedInputStream null = new BufferedInputStream(uRL.openStream()); 
/* 80 */           InputStreamReader null = new InputStreamReader(bufferedInputStream, str1)) {
/*    */         int j;
/* 82 */         while (-1 != (j = inputStreamReader.read(arrayOfChar))) {
/* 83 */           stringWriter.write(arrayOfChar, 0, j);
/*    */         }
/*    */       } 
/* 86 */       return stringWriter.toString();
/* 87 */     } catch (Exception exception) {
/* 88 */       throw IllegalArgumentExceptions.format(exception, "Error looking up URL [%s] with Charset [%s].", new Object[] { str2, str1 });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\UrlStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */