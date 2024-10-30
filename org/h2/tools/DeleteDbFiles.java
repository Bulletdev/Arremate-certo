/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.store.FileLister;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.Tool;
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
/*     */ 
/*     */ public class DeleteDbFiles
/*     */   extends Tool
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  41 */     (new DeleteDbFiles()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  46 */     String str1 = ".";
/*  47 */     String str2 = null;
/*  48 */     boolean bool = false;
/*  49 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  50 */       String str = paramVarArgs[b];
/*  51 */       if (str.equals("-dir"))
/*  52 */       { str1 = paramVarArgs[++b]; }
/*  53 */       else if (str.equals("-db"))
/*  54 */       { str2 = paramVarArgs[++b]; }
/*  55 */       else if (str.equals("-quiet"))
/*  56 */       { bool = true; }
/*  57 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  58 */           showUsage();
/*     */           return;
/*     */         } 
/*  61 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*  64 */     process(str1, str2, bool);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void execute(String paramString1, String paramString2, boolean paramBoolean) {
/*  75 */     (new DeleteDbFiles()).process(paramString1, paramString2, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void process(String paramString1, String paramString2, boolean paramBoolean) {
/*  86 */     ArrayList arrayList = FileLister.getDatabaseFiles(paramString1, paramString2, true);
/*  87 */     if (arrayList.size() == 0 && !paramBoolean) {
/*  88 */       printNoDatabaseFilesFound(paramString1, paramString2);
/*     */     }
/*  90 */     for (String str : arrayList) {
/*  91 */       process(str, paramBoolean);
/*  92 */       if (!paramBoolean) {
/*  93 */         this.out.println("Processed: " + str);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void process(String paramString, boolean paramBoolean) {
/*  99 */     if (FileUtils.isDirectory(paramString)) {
/*     */       
/* 101 */       FileUtils.tryDelete(paramString);
/* 102 */     } else if (paramBoolean || paramString.endsWith(".temp.db") || paramString.endsWith(".trace.db")) {
/*     */       
/* 104 */       FileUtils.tryDelete(paramString);
/*     */     } else {
/* 106 */       FileUtils.delete(paramString);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\DeleteDbFiles.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */