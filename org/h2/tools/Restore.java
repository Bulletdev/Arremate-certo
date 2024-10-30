/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.sql.SQLException;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipInputStream;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
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
/*     */ public class Restore
/*     */   extends Tool
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  46 */     (new Restore()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  51 */     String str1 = "backup.zip";
/*  52 */     String str2 = ".";
/*  53 */     String str3 = null;
/*  54 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  55 */       String str = paramVarArgs[b];
/*  56 */       if (str.equals("-dir")) {
/*  57 */         str2 = paramVarArgs[++b];
/*  58 */       } else if (str.equals("-file")) {
/*  59 */         str1 = paramVarArgs[++b];
/*  60 */       } else if (str.equals("-db")) {
/*  61 */         str3 = paramVarArgs[++b];
/*  62 */       } else if (!str.equals("-quiet")) {
/*     */         
/*  64 */         if (str.equals("-help") || str.equals("-?")) {
/*  65 */           showUsage();
/*     */           return;
/*     */         } 
/*  68 */         showUsageAndThrowUnsupportedOption(str);
/*     */       } 
/*     */     } 
/*  71 */     execute(str1, str2, str3);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String getOriginalDbName(String paramString1, String paramString2) throws IOException {
/*  77 */     try (InputStream null = FileUtils.newInputStream(paramString1)) {
/*  78 */       ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/*  79 */       String str = null;
/*  80 */       boolean bool = false;
/*     */       while (true) {
/*  82 */         ZipEntry zipEntry = zipInputStream.getNextEntry();
/*  83 */         if (zipEntry == null) {
/*     */           break;
/*     */         }
/*  86 */         String str1 = zipEntry.getName();
/*  87 */         zipInputStream.closeEntry();
/*  88 */         String str2 = getDatabaseNameFromFileName(str1);
/*  89 */         if (str2 != null) {
/*  90 */           if (paramString2.equals(str2)) {
/*  91 */             str = str2;
/*     */             break;
/*     */           } 
/*  94 */           if (str == null) {
/*  95 */             str = str2;
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 100 */           bool = true;
/*     */         } 
/*     */       } 
/*     */       
/* 104 */       zipInputStream.close();
/* 105 */       if (bool && !paramString2.equals(str)) {
/* 106 */         throw new IOException("Multiple databases found, but not " + paramString2);
/*     */       }
/* 108 */       return str;
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
/*     */   private static String getDatabaseNameFromFileName(String paramString) {
/* 120 */     if (paramString.endsWith(".h2.db")) {
/* 121 */       return paramString.substring(0, paramString.length() - ".h2.db".length());
/*     */     }
/*     */     
/* 124 */     if (paramString.endsWith(".mv.db")) {
/* 125 */       return paramString.substring(0, paramString.length() - ".mv.db".length());
/*     */     }
/*     */     
/* 128 */     return null;
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
/*     */   public static void execute(String paramString1, String paramString2, String paramString3) {
/* 140 */     InputStream inputStream = null;
/*     */     try {
/* 142 */       if (!FileUtils.exists(paramString1)) {
/* 143 */         throw new IOException("File not found: " + paramString1);
/*     */       }
/* 145 */       String str = null;
/* 146 */       int i = 0;
/* 147 */       if (paramString3 != null) {
/* 148 */         str = getOriginalDbName(paramString1, paramString3);
/* 149 */         if (str == null) {
/* 150 */           throw new IOException("No database named " + paramString3 + " found");
/*     */         }
/* 152 */         if (str.startsWith(SysProperties.FILE_SEPARATOR)) {
/* 153 */           str = str.substring(1);
/*     */         }
/* 155 */         i = str.length();
/*     */       } 
/* 157 */       inputStream = FileUtils.newInputStream(paramString1);
/* 158 */       ZipInputStream zipInputStream = new ZipInputStream(inputStream);
/*     */       while (true) {
/* 160 */         ZipEntry zipEntry = zipInputStream.getNextEntry();
/* 161 */         if (zipEntry == null) {
/*     */           break;
/*     */         }
/* 164 */         String str1 = zipEntry.getName();
/*     */         
/* 166 */         str1 = str1.replace('\\', SysProperties.FILE_SEPARATOR.charAt(0));
/* 167 */         str1 = str1.replace('/', SysProperties.FILE_SEPARATOR.charAt(0));
/* 168 */         if (str1.startsWith(SysProperties.FILE_SEPARATOR)) {
/* 169 */           str1 = str1.substring(1);
/*     */         }
/* 171 */         boolean bool = false;
/* 172 */         if (paramString3 == null) {
/* 173 */           bool = true;
/* 174 */         } else if (str1.startsWith(str + ".")) {
/* 175 */           str1 = paramString3 + str1.substring(i);
/* 176 */           bool = true;
/*     */         } 
/* 178 */         if (bool) {
/* 179 */           OutputStream outputStream = null;
/*     */           try {
/* 181 */             outputStream = FileUtils.newOutputStream(paramString2 + SysProperties.FILE_SEPARATOR + str1, false);
/*     */             
/* 183 */             IOUtils.copy(zipInputStream, outputStream);
/* 184 */             outputStream.close();
/*     */           } finally {
/* 186 */             IOUtils.closeSilently(outputStream);
/*     */           } 
/*     */         } 
/* 189 */         zipInputStream.closeEntry();
/*     */       } 
/* 191 */       zipInputStream.closeEntry();
/* 192 */       zipInputStream.close();
/* 193 */     } catch (IOException iOException) {
/* 194 */       throw DbException.convertIOException(iOException, paramString1);
/*     */     } finally {
/* 196 */       IOUtils.closeSilently(inputStream);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Restore.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */