/*    */ package org.c.a.b.o.b.a;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.net.URL;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import java.util.TreeSet;
/*    */ import org.c.a.a.f.a;
/*    */ import org.c.a.a.f.c;
/*    */ import org.c.a.b.o.b.a;
/*    */ import org.c.a.b.r.p;
/*    */ import org.jboss.vfs.VFS;
/*    */ import org.jboss.vfs.VirtualFile;
/*    */ import org.jboss.vfs.VirtualFileFilter;
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
/*    */ public class b
/*    */   implements a
/*    */ {
/* 36 */   private static final a a = c.b(b.class);
/*    */   
/*    */   public Set<String> a(String paramString, URL paramURL) {
/* 39 */     String str1 = p.b(paramURL);
/* 40 */     String str2 = str1.substring(0, str1.length() - paramString.length());
/* 41 */     if (!str2.endsWith("/")) {
/* 42 */       str2 = str2 + "/";
/*    */     }
/* 44 */     a.debug("Scanning starting at classpath root on JBoss VFS: " + str2);
/*    */     
/* 46 */     TreeSet<String> treeSet = new TreeSet();
/*    */ 
/*    */     
/*    */     try {
/* 50 */       List list = VFS.getChild(str1).getChildrenRecursively(new VirtualFileFilter(this) {
/*    */             public boolean a(VirtualFile param1VirtualFile) {
/* 52 */               return param1VirtualFile.isFile();
/*    */             }
/*    */           });
/* 55 */       for (VirtualFile virtualFile : list) {
/* 56 */         treeSet.add(virtualFile.getPathName().substring(str2.length()));
/*    */       }
/* 58 */     } catch (IOException iOException) {
/* 59 */       a.warn("Unable to scan classpath root (" + str2 + ") using JBoss VFS: " + iOException.getMessage());
/*    */     } 
/*    */     
/* 62 */     return treeSet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\a\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */