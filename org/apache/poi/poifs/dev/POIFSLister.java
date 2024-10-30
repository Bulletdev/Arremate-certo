/*     */ package org.apache.poi.poifs.dev;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentNode;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POIFSLister
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*  43 */     if (paramArrayOfString.length == 0) {
/*  44 */       System.err.println("Must specify at least one file to view");
/*  45 */       System.exit(1);
/*     */     } 
/*     */     
/*  48 */     boolean bool1 = false;
/*  49 */     boolean bool2 = true;
/*  50 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*  51 */       if (paramArrayOfString[b].equalsIgnoreCase("-size") || paramArrayOfString[b].equalsIgnoreCase("-sizes")) {
/*  52 */         bool1 = true;
/*  53 */       } else if (paramArrayOfString[b].equalsIgnoreCase("-old") || paramArrayOfString[b].equalsIgnoreCase("-old-poifs")) {
/*  54 */         bool2 = false;
/*     */       }
/*  56 */       else if (bool2) {
/*  57 */         viewFile(paramArrayOfString[b], bool1);
/*     */       } else {
/*  59 */         viewFileOld(paramArrayOfString[b], bool1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void viewFile(String paramString, boolean paramBoolean) throws IOException {
/*  66 */     NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(new File(paramString));
/*  67 */     displayDirectory(nPOIFSFileSystem.getRoot(), "", paramBoolean);
/*     */   }
/*     */   
/*     */   public static void viewFileOld(String paramString, boolean paramBoolean) throws IOException {
/*  71 */     POIFSFileSystem pOIFSFileSystem = new POIFSFileSystem(new FileInputStream(paramString));
/*  72 */     displayDirectory(pOIFSFileSystem.getRoot(), "", paramBoolean);
/*     */   }
/*     */   
/*     */   public static void displayDirectory(DirectoryNode paramDirectoryNode, String paramString, boolean paramBoolean) {
/*  76 */     System.out.println(paramString + paramDirectoryNode.getName() + " -");
/*  77 */     String str = paramString + "  ";
/*     */     
/*  79 */     boolean bool = false;
/*  80 */     for (Iterator<Entry> iterator = paramDirectoryNode.getEntries(); iterator.hasNext(); ) {
/*  81 */       bool = true;
/*  82 */       Entry entry = iterator.next();
/*  83 */       if (entry instanceof DirectoryNode) {
/*  84 */         displayDirectory((DirectoryNode)entry, str, paramBoolean); continue;
/*     */       } 
/*  86 */       DocumentNode documentNode = (DocumentNode)entry;
/*  87 */       String str1 = documentNode.getName();
/*  88 */       String str2 = "";
/*  89 */       if (str1.charAt(0) < '\n') {
/*  90 */         String str3 = "(0x0" + str1.charAt(0) + ")" + str1.substring(1);
/*  91 */         str1 = str1.substring(1) + " <" + str3 + ">";
/*     */       } 
/*  93 */       if (paramBoolean) {
/*  94 */         str2 = " [" + documentNode.getSize() + " / 0x" + Integer.toHexString(documentNode.getSize()) + "]";
/*     */       }
/*     */       
/*  97 */       System.out.println(str + str1 + str2);
/*     */     } 
/*     */     
/* 100 */     if (!bool)
/* 101 */       System.out.println(str + "(no children)"); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\dev\POIFSLister.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */