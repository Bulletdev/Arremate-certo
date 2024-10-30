/*    */ package org.apache.commons.text.lookup;
/*    */ 
/*    */ import java.nio.file.Files;
/*    */ import java.nio.file.Paths;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class FileStringLookup
/*    */   extends AbstractStringLookup
/*    */ {
/* 53 */   static final AbstractStringLookup INSTANCE = new FileStringLookup();
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
/* 73 */     if (paramString == null) {
/* 74 */       return null;
/*    */     }
/* 76 */     String[] arrayOfString = paramString.split(String.valueOf(':'));
/* 77 */     int i = arrayOfString.length;
/* 78 */     if (i < 2)
/*    */     {
/* 80 */       throw IllegalArgumentExceptions.format("Bad file key format [%s], expected format is CharsetName:DocumentPath.", new Object[] { paramString });
/*    */     }
/* 82 */     String str1 = arrayOfString[0];
/* 83 */     String str2 = StringUtils.substringAfter(paramString, 58);
/*    */     try {
/* 85 */       return new String(Files.readAllBytes(Paths.get(str2, new String[0])), str1);
/* 86 */     } catch (Exception exception) {
/* 87 */       throw IllegalArgumentExceptions.format(exception, "Error looking up file [%s] with charset [%s].", new Object[] { str2, str1 });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\lookup\FileStringLookup.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */