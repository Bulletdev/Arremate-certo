/*    */ package org.c.a.b.o.b;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.net.URL;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.a.f.c;
/*    */ import org.c.a.b.r.p;
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
/*    */ public class d
/*    */   implements a
/*    */ {
/* 31 */   private static final a a = c.b(d.class);
/*    */   
/*    */   public Set<String> a(String paramString, URL paramURL) {
/* 34 */     String str1 = p.b(paramURL);
/* 35 */     File file = new File(str1);
/* 36 */     if (!file.isDirectory()) {
/* 37 */       a.debug("Skipping path as it is not a directory: " + str1);
/* 38 */       return new TreeSet<>();
/*    */     } 
/*    */     
/* 41 */     String str2 = str1.substring(0, str1.length() - paramString.length());
/* 42 */     if (!str2.endsWith(File.separator)) {
/* 43 */       str2 = str2 + File.separator;
/*    */     }
/* 45 */     a.debug("Scanning starting at classpath root in filesystem: " + str2);
/* 46 */     return a(str2, paramString, file);
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
/*    */   Set<String> a(String paramString1, String paramString2, File paramFile) {
/* 60 */     a.debug("Scanning for resources in path: " + paramFile.getPath() + " (" + paramString2 + ")");
/*    */     
/* 62 */     TreeSet<String> treeSet = new TreeSet();
/*    */     
/* 64 */     File[] arrayOfFile = paramFile.listFiles();
/* 65 */     for (File file : arrayOfFile) {
/* 66 */       if (file.canRead()) {
/* 67 */         if (file.isDirectory()) {
/* 68 */           treeSet.addAll(a(paramString1, paramString2, file));
/*    */         } else {
/* 70 */           treeSet.add(a(paramString1, file));
/*    */         } 
/*    */       }
/*    */     } 
/*    */     
/* 75 */     return treeSet;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private String a(String paramString, File paramFile) {
/* 86 */     String str = paramFile.getAbsolutePath().replace("\\", "/");
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 91 */     return str.substring(paramString.length());
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\d.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */