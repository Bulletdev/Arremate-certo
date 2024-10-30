/*    */ package org.apache.xmlbeans.impl.util;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.io.LineNumberReader;
/*    */ import java.io.Reader;
/*    */ import java.util.List;
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
/*    */ public class Diff
/*    */ {
/*    */   public static void readersAsText(Reader paramReader1, String paramString1, Reader paramReader2, String paramString2, List paramList) throws IOException {
/* 32 */     LineNumberReader lineNumberReader1 = new LineNumberReader(paramReader1);
/* 33 */     LineNumberReader lineNumberReader2 = new LineNumberReader(paramReader2);
/* 34 */     String str1 = lineNumberReader1.readLine();
/* 35 */     String str2 = lineNumberReader2.readLine();
/* 36 */     while (str1 != null && str2 != null) {
/*    */       
/* 38 */       if (!str1.equals(str2)) {
/*    */         
/* 40 */         paramList.add("File \"" + paramString1 + "\" and file \"" + paramString2 + "\" differ at line " + lineNumberReader1.getLineNumber() + ":" + "\n" + str1 + "\n========\n" + str2);
/*    */         
/*    */         break;
/*    */       } 
/*    */       
/* 45 */       str1 = lineNumberReader1.readLine();
/* 46 */       str2 = lineNumberReader2.readLine();
/*    */     } 
/* 48 */     if (str1 == null && str2 != null) {
/* 49 */       paramList.add("File \"" + paramString2 + "\" has extra lines at line " + lineNumberReader2.getLineNumber() + ":\n" + str2);
/*    */     }
/* 51 */     if (str1 != null && str2 == null)
/* 52 */       paramList.add("File \"" + paramString1 + "\" has extra lines at line " + lineNumberReader1.getLineNumber() + ":\n" + str1); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\imp\\util\Diff.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */