/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.rolling.RollingFileAppender;
/*     */ import ch.qos.logback.core.rolling.RolloverFailure;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.EnvUtil;
/*     */ import ch.qos.logback.core.util.FileUtil;
/*     */ import java.io.File;
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
/*     */ public class RenameUtil
/*     */   extends ContextAwareBase
/*     */ {
/*  32 */   static String RENAMING_ERROR_URL = "http://logback.qos.ch/codes.html#renamingError";
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
/*     */   public void rename(String paramString1, String paramString2) throws RolloverFailure {
/*  44 */     if (paramString1.equals(paramString2)) {
/*  45 */       addWarn("Source and target files are the same [" + paramString1 + "]. Skipping.");
/*     */       return;
/*     */     } 
/*  48 */     File file = new File(paramString1);
/*     */     
/*  50 */     if (file.exists()) {
/*  51 */       File file1 = new File(paramString2);
/*  52 */       createMissingTargetDirsIfNecessary(file1);
/*     */       
/*  54 */       addInfo("Renaming file [" + file + "] to [" + file1 + "]");
/*     */       
/*  56 */       boolean bool = file.renameTo(file1);
/*     */       
/*  58 */       if (!bool) {
/*  59 */         addWarn("Failed to rename file [" + file + "] as [" + file1 + "].");
/*  60 */         Boolean bool1 = areOnDifferentVolumes(file, file1);
/*  61 */         if (Boolean.TRUE.equals(bool1)) {
/*  62 */           addWarn("Detected different file systems for source [" + paramString1 + "] and target [" + paramString2 + "]. Attempting rename by copying.");
/*  63 */           renameByCopying(paramString1, paramString2);
/*     */           return;
/*     */         } 
/*  66 */         addWarn("Please consider leaving the [file] option of " + RollingFileAppender.class.getSimpleName() + " empty.");
/*  67 */         addWarn("See also " + RENAMING_ERROR_URL);
/*     */       } 
/*     */     } else {
/*     */       
/*  71 */       throw new RolloverFailure("File [" + paramString1 + "] does not exist.");
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
/*     */   Boolean areOnDifferentVolumes(File paramFile1, File paramFile2) throws RolloverFailure {
/*  86 */     if (!EnvUtil.isJDK7OrHigher()) {
/*  87 */       return Boolean.valueOf(false);
/*     */     }
/*     */     
/*  90 */     File file = paramFile2.getAbsoluteFile().getParentFile();
/*     */     
/*  92 */     if (file == null) {
/*  93 */       addWarn("Parent of target file [" + paramFile2 + "] is null");
/*  94 */       return null;
/*     */     } 
/*  96 */     if (!file.exists()) {
/*  97 */       addWarn("Parent of target file [" + paramFile2 + "] does not exist");
/*  98 */       return null;
/*     */     } 
/*     */     
/*     */     try {
/* 102 */       boolean bool = FileStoreUtil.areOnSameFileStore(paramFile1, file);
/* 103 */       return Boolean.valueOf(!bool);
/* 104 */     } catch (RolloverFailure rolloverFailure) {
/* 105 */       addWarn("Error while checking file store equality", (Throwable)rolloverFailure);
/* 106 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renameByCopying(String paramString1, String paramString2) throws RolloverFailure {
/* 112 */     FileUtil fileUtil = new FileUtil(getContext());
/* 113 */     fileUtil.copy(paramString1, paramString2);
/*     */     
/* 115 */     File file = new File(paramString1);
/* 116 */     if (!file.delete()) {
/* 117 */       addWarn("Could not delete " + paramString1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   void createMissingTargetDirsIfNecessary(File paramFile) throws RolloverFailure {
/* 123 */     boolean bool = FileUtil.createMissingParentDirectories(paramFile);
/* 124 */     if (!bool) {
/* 125 */       throw new RolloverFailure("Failed to create parent directories for [" + paramFile.getAbsolutePath() + "]");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 131 */     return "c.q.l.co.rolling.helper.RenameUtil";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\RenameUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */