/*     */ package org.c.a.b.o.c;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Set;
/*     */ import java.util.TreeSet;
/*     */ import org.c.a.a.b;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.n.b;
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
/*     */ 
/*     */ 
/*     */ public class a
/*     */ {
/*  35 */   private static final org.c.a.a.f.a a = c.b(a.class);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Charset encoding;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public a(Charset paramCharset) {
/*  55 */     this.encoding = paramCharset;
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
/*     */   
/*     */   public Collection<b> a(b paramb) {
/*  69 */     String str = paramb.getPath();
/*  70 */     a.debug("Scanning for filesystem resources at '" + str + "'");
/*     */     
/*  72 */     File file = new File(str);
/*  73 */     if (!file.exists()) {
/*  74 */       a.warn("Skipping filesystem location:" + str + " (not found)");
/*  75 */       return Collections.emptyList();
/*     */     } 
/*  77 */     if (!file.canRead()) {
/*  78 */       a.warn("Skipping filesystem location:" + str + " (not readable)");
/*  79 */       return Collections.emptyList();
/*     */     } 
/*  81 */     if (!file.isDirectory()) {
/*  82 */       a.warn("Skipping filesystem location:" + str + " (not a directory)");
/*  83 */       return Collections.emptyList();
/*     */     } 
/*     */     
/*  86 */     TreeSet<org.c.a.b.n.c.a> treeSet = new TreeSet();
/*     */     
/*  88 */     for (String str1 : a(str, new File(str))) {
/*  89 */       treeSet.add(new org.c.a.b.n.c.a(paramb, str1, this.encoding));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  94 */       a.debug("Found filesystem resource: " + str1);
/*     */     } 
/*     */     
/*  97 */     return (Collection)treeSet;
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
/*     */   private Set<String> a(String paramString, File paramFile) {
/* 109 */     a.debug("Scanning for resources in path: " + paramFile.getPath() + " (" + paramString + ")");
/*     */     
/* 111 */     TreeSet<String> treeSet = new TreeSet();
/*     */     
/* 113 */     File[] arrayOfFile = paramFile.listFiles();
/* 114 */     for (File file : arrayOfFile) {
/* 115 */       if (file.canRead()) {
/* 116 */         if (file.isDirectory()) {
/* 117 */           if (file.isHidden()) {
/*     */             
/* 119 */             a.debug("Skipping hidden directory: " + file.getAbsolutePath());
/*     */           } else {
/* 121 */             treeSet.addAll(a(paramString, file));
/*     */           } 
/*     */         } else {
/* 124 */           treeSet.add(file.getPath());
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 129 */     return treeSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\o\c\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */