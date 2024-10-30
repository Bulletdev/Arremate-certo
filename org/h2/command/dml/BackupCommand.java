/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.MVStore;
/*     */ import org.h2.mvstore.db.MVTableEngine;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.store.FileLister;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
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
/*     */ public class BackupCommand
/*     */   extends Prepared
/*     */ {
/*     */   private Expression fileNameExpr;
/*     */   
/*     */   public BackupCommand(Session paramSession) {
/*  40 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setFileName(Expression paramExpression) {
/*  44 */     this.fileNameExpr = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  49 */     String str = this.fileNameExpr.getValue(this.session).getString();
/*  50 */     this.session.getUser().checkAdmin();
/*  51 */     backupTo(str);
/*  52 */     return 0;
/*     */   }
/*     */   
/*     */   private void backupTo(String paramString) {
/*  56 */     Database database = this.session.getDatabase();
/*  57 */     if (!database.isPersistent()) {
/*  58 */       throw DbException.get(90126);
/*     */     }
/*     */     try {
/*  61 */       MVTableEngine.Store store = database.getMvStore();
/*  62 */       if (store != null) {
/*  63 */         store.flush();
/*     */       }
/*  65 */       String str1 = database.getName();
/*  66 */       str1 = FileUtils.getName(str1);
/*  67 */       OutputStream outputStream = FileUtils.newOutputStream(paramString, false);
/*  68 */       ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
/*  69 */       database.flush();
/*  70 */       if (database.getPageStore() != null) {
/*  71 */         String str = database.getName() + ".h2.db";
/*  72 */         backupPageStore(zipOutputStream, str, database.getPageStore());
/*     */       } 
/*     */ 
/*     */       
/*  76 */       String str2 = FileUtils.getParent(database.getName());
/*  77 */       synchronized (database.getLobSyncObject()) {
/*  78 */         String str3 = database.getDatabasePath();
/*  79 */         String str4 = FileUtils.getParent(str3);
/*  80 */         str4 = FileLister.getDir(str4);
/*  81 */         ArrayList arrayList = FileLister.getDatabaseFiles(str4, str1, true);
/*  82 */         for (String str : arrayList) {
/*  83 */           if (str.endsWith(".lob.db")) {
/*  84 */             backupFile(zipOutputStream, str2, str);
/*     */           }
/*  86 */           if (str.endsWith(".mv.db") && store != null) {
/*  87 */             MVStore mVStore = store.getStore();
/*  88 */             boolean bool = mVStore.getReuseSpace();
/*  89 */             mVStore.setReuseSpace(false);
/*     */             try {
/*  91 */               InputStream inputStream = store.getInputStream();
/*  92 */               backupFile(zipOutputStream, str2, str, inputStream);
/*     */             } finally {
/*  94 */               mVStore.setReuseSpace(bool);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*  99 */       zipOutputStream.close();
/* 100 */       outputStream.close();
/* 101 */     } catch (IOException iOException) {
/* 102 */       throw DbException.convertIOException(iOException, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void backupPageStore(ZipOutputStream paramZipOutputStream, String paramString, PageStore paramPageStore) throws IOException {
/* 108 */     Database database = this.session.getDatabase();
/* 109 */     paramString = FileUtils.getName(paramString);
/* 110 */     paramZipOutputStream.putNextEntry(new ZipEntry(paramString));
/* 111 */     int i = 0;
/*     */     try {
/* 113 */       paramPageStore.setBackup(true);
/*     */       while (true) {
/* 115 */         i = paramPageStore.copyDirect(i, paramZipOutputStream);
/* 116 */         if (i < 0) {
/*     */           break;
/*     */         }
/* 119 */         int j = paramPageStore.getPageCount();
/* 120 */         database.setProgress(3, paramString, i, j);
/*     */       } 
/*     */     } finally {
/* 123 */       paramPageStore.setBackup(false);
/*     */     } 
/* 125 */     paramZipOutputStream.closeEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   private static void backupFile(ZipOutputStream paramZipOutputStream, String paramString1, String paramString2) throws IOException {
/* 130 */     InputStream inputStream = FileUtils.newInputStream(paramString2);
/* 131 */     backupFile(paramZipOutputStream, paramString1, paramString2, inputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void backupFile(ZipOutputStream paramZipOutputStream, String paramString1, String paramString2, InputStream paramInputStream) throws IOException {
/* 136 */     String str = FileUtils.toRealPath(paramString2);
/* 137 */     paramString1 = FileUtils.toRealPath(paramString1);
/* 138 */     if (!str.startsWith(paramString1)) {
/* 139 */       DbException.throwInternalError(str + " does not start with " + paramString1);
/*     */     }
/* 141 */     str = str.substring(paramString1.length());
/* 142 */     str = correctFileName(str);
/* 143 */     paramZipOutputStream.putNextEntry(new ZipEntry(str));
/* 144 */     IOUtils.copyAndCloseInput(paramInputStream, paramZipOutputStream);
/* 145 */     paramZipOutputStream.closeEntry();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String correctFileName(String paramString) {
/* 160 */     paramString = paramString.replace('\\', '/');
/* 161 */     if (paramString.startsWith("/")) {
/* 162 */       paramString = paramString.substring(1);
/*     */     }
/* 164 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRecompile() {
/* 169 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 174 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 179 */     return 56;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\BackupCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */