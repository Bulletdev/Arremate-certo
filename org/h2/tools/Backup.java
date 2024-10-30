/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.List;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.h2.command.dml.BackupCommand;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.FileLister;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Backup
/*     */   extends Tool
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  57 */     (new Backup()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  62 */     String str1 = "backup.zip";
/*  63 */     String str2 = ".";
/*  64 */     String str3 = null;
/*  65 */     boolean bool = false;
/*  66 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  67 */       String str = paramVarArgs[b];
/*  68 */       if (str.equals("-dir"))
/*  69 */       { str2 = paramVarArgs[++b]; }
/*  70 */       else if (str.equals("-db"))
/*  71 */       { str3 = paramVarArgs[++b]; }
/*  72 */       else if (str.equals("-quiet"))
/*  73 */       { bool = true; }
/*  74 */       else if (str.equals("-file"))
/*  75 */       { str1 = paramVarArgs[++b]; }
/*  76 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  77 */           showUsage();
/*     */           return;
/*     */         } 
/*  80 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*     */     try {
/*  84 */       process(str1, str2, str3, bool);
/*  85 */     } catch (Exception exception) {
/*  86 */       throw DbException.toSQLException(exception);
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
/*     */   
/*     */   public static void execute(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws SQLException {
/*     */     try {
/* 102 */       (new Backup()).process(paramString1, paramString2, paramString3, paramBoolean);
/* 103 */     } catch (Exception exception) {
/* 104 */       throw DbException.toSQLException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(String paramString1, String paramString2, String paramString3, boolean paramBoolean) throws SQLException {
/*     */     List list;
/* 111 */     boolean bool = (paramString3 != null && paramString3.length() == 0) ? true : false;
/* 112 */     if (bool) {
/* 113 */       list = FileUtils.newDirectoryStream(paramString2);
/*     */     } else {
/* 115 */       list = FileLister.getDatabaseFiles(paramString2, paramString3, true);
/*     */     } 
/* 117 */     if (list.size() == 0) {
/* 118 */       if (!paramBoolean) {
/* 119 */         printNoDatabaseFilesFound(paramString2, paramString3);
/*     */       }
/*     */       return;
/*     */     } 
/* 123 */     if (!paramBoolean) {
/* 124 */       FileLister.tryUnlockDatabase(list, "backup");
/*     */     }
/* 126 */     paramString1 = FileUtils.toRealPath(paramString1);
/* 127 */     FileUtils.delete(paramString1);
/* 128 */     OutputStream outputStream = null;
/*     */     try {
/* 130 */       outputStream = FileUtils.newOutputStream(paramString1, false);
/* 131 */       ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
/* 132 */       String str = "";
/* 133 */       for (String str1 : list) {
/* 134 */         if (bool || str1.endsWith(".h2.db") || str1.endsWith(".mv.db")) {
/*     */ 
/*     */           
/* 137 */           str = FileUtils.getParent(str1);
/*     */           break;
/*     */         } 
/*     */       } 
/* 141 */       for (String str1 : list) {
/* 142 */         String str2 = FileUtils.toRealPath(str1);
/* 143 */         if (!str2.startsWith(str)) {
/* 144 */           DbException.throwInternalError(str2 + " does not start with " + str);
/*     */         }
/* 146 */         if (str2.endsWith(paramString1)) {
/*     */           continue;
/*     */         }
/* 149 */         if (FileUtils.isDirectory(str1)) {
/*     */           continue;
/*     */         }
/* 152 */         str2 = str2.substring(str.length());
/* 153 */         str2 = BackupCommand.correctFileName(str2);
/* 154 */         ZipEntry zipEntry = new ZipEntry(str2);
/* 155 */         zipOutputStream.putNextEntry(zipEntry);
/* 156 */         InputStream inputStream = null;
/*     */         try {
/* 158 */           inputStream = FileUtils.newInputStream(str1);
/* 159 */           IOUtils.copyAndCloseInput(inputStream, zipOutputStream);
/* 160 */         } catch (FileNotFoundException fileNotFoundException) {
/*     */ 
/*     */         
/*     */         } finally {
/* 164 */           IOUtils.closeSilently(inputStream);
/*     */         } 
/* 166 */         zipOutputStream.closeEntry();
/* 167 */         if (!paramBoolean) {
/* 168 */           this.out.println("Processed: " + str1);
/*     */         }
/*     */       } 
/* 171 */       zipOutputStream.close();
/* 172 */     } catch (IOException iOException) {
/* 173 */       throw DbException.convertIOException(iOException, paramString1);
/*     */     } finally {
/* 175 */       IOUtils.closeSilently(outputStream);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Backup.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */