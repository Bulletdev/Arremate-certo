/*     */ package org.c.a.b.o.b;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.net.JarURLConnection;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.util.Collections;
/*     */ import java.util.Enumeration;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class e
/*     */   implements a
/*     */ {
/*  38 */   private static final a a = c.b(e.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private final String separator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   e(String paramString) {
/*  48 */     this.separator = paramString;
/*     */   }
/*     */   public Set<String> a(String paramString, URL paramURL) {
/*     */     JarFile jarFile;
/*     */     try {
/*  53 */       jarFile = a(paramURL);
/*  54 */     } catch (IOException iOException) {
/*  55 */       a.warn("Unable to determine jar from url (" + paramURL + "): " + iOException.getMessage());
/*  56 */       return Collections.emptySet();
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/*  61 */       String str = jarFile.getName().toLowerCase().endsWith(".war") ? "WEB-INF/classes/" : "";
/*  62 */       return a(jarFile, str, paramString);
/*     */     } finally {
/*     */       try {
/*  65 */         jarFile.close();
/*  66 */       } catch (IOException iOException) {}
/*     */     } 
/*     */   }
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
/*     */   private JarFile a(URL paramURL) throws IOException {
/*  80 */     URLConnection uRLConnection = paramURL.openConnection();
/*  81 */     if (uRLConnection instanceof JarURLConnection) {
/*     */       
/*  83 */       JarURLConnection jarURLConnection = (JarURLConnection)uRLConnection;
/*  84 */       jarURLConnection.setUseCaches(false);
/*  85 */       return jarURLConnection.getJarFile();
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  92 */     String str = paramURL.getFile();
/*     */     
/*  94 */     int i = str.indexOf(this.separator);
/*  95 */     if (i != -1) {
/*  96 */       String str1 = str.substring(0, i);
/*  97 */       if (str1.startsWith("file:")) {
/*     */         try {
/*  99 */           return new JarFile((new URL(str1)).toURI().getSchemeSpecificPart());
/* 100 */         } catch (URISyntaxException uRISyntaxException) {
/*     */           
/* 102 */           return new JarFile(str1.substring("file:".length()));
/*     */         } 
/*     */       }
/* 105 */       return new JarFile(str1);
/*     */     } 
/*     */     
/* 108 */     return new JarFile(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Set<String> a(JarFile paramJarFile, String paramString1, String paramString2) {
/* 120 */     String str = paramString1 + paramString2 + (paramString2.endsWith("/") ? "" : "/");
/* 121 */     TreeSet<String> treeSet = new TreeSet();
/*     */     
/* 123 */     Enumeration<JarEntry> enumeration = paramJarFile.entries();
/* 124 */     while (enumeration.hasMoreElements()) {
/* 125 */       String str1 = ((JarEntry)enumeration.nextElement()).getName();
/* 126 */       if (str1.startsWith(str)) {
/* 127 */         treeSet.add(str1.substring(paramString1.length()));
/*     */       }
/*     */     } 
/*     */     
/* 131 */     return treeSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\b\e.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */