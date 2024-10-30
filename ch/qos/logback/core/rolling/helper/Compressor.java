/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.rolling.RolloverFailure;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.status.ErrorStatus;
/*     */ import ch.qos.logback.core.status.Status;
/*     */ import ch.qos.logback.core.status.WarnStatus;
/*     */ import ch.qos.logback.core.util.FileUtil;
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledExecutorService;
/*     */ import java.util.zip.GZIPOutputStream;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipOutputStream;
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
/*     */ public class Compressor
/*     */   extends ContextAwareBase
/*     */ {
/*     */   final CompressionMode compressionMode;
/*     */   static final int BUFFER_SIZE = 8192;
/*     */   
/*     */   public Compressor(CompressionMode paramCompressionMode) {
/*  46 */     this.compressionMode = paramCompressionMode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void compress(String paramString1, String paramString2, String paramString3) {
/*  56 */     switch (null.s[this.compressionMode.ordinal()]) {
/*     */       case 1:
/*  58 */         gzCompress(paramString1, paramString2);
/*     */         break;
/*     */       case 2:
/*  61 */         zipCompress(paramString1, paramString2, paramString3);
/*     */         break;
/*     */       case 3:
/*  64 */         throw new UnsupportedOperationException("compress method called in NONE compression mode");
/*     */     } 
/*     */   }
/*     */   
/*     */   private void zipCompress(String paramString1, String paramString2, String paramString3) {
/*  69 */     File file1 = new File(paramString1);
/*     */     
/*  71 */     if (!file1.exists()) {
/*  72 */       addStatus((Status)new WarnStatus("The file to compress named [" + paramString1 + "] does not exist.", this));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  77 */     if (paramString3 == null) {
/*  78 */       addStatus((Status)new WarnStatus("The innerEntryName parameter cannot be null", this));
/*     */       
/*     */       return;
/*     */     } 
/*  82 */     if (!paramString2.endsWith(".zip")) {
/*  83 */       paramString2 = paramString2 + ".zip";
/*     */     }
/*     */     
/*  86 */     File file2 = new File(paramString2);
/*     */     
/*  88 */     if (file2.exists()) {
/*  89 */       addStatus((Status)new WarnStatus("The target compressed file named [" + paramString2 + "] exist already.", this));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  94 */     addInfo("ZIP compressing [" + file1 + "] as [" + file2 + "]");
/*  95 */     createMissingTargetDirsIfNecessary(file2);
/*     */     
/*  97 */     BufferedInputStream bufferedInputStream = null;
/*  98 */     ZipOutputStream zipOutputStream = null;
/*     */     try {
/* 100 */       bufferedInputStream = new BufferedInputStream(new FileInputStream(paramString1));
/* 101 */       zipOutputStream = new ZipOutputStream(new FileOutputStream(paramString2));
/*     */       
/* 103 */       ZipEntry zipEntry = computeZipEntry(paramString3);
/* 104 */       zipOutputStream.putNextEntry(zipEntry);
/*     */       
/* 106 */       byte[] arrayOfByte = new byte[8192];
/*     */       
/*     */       int i;
/* 109 */       while ((i = bufferedInputStream.read(arrayOfByte)) != -1) {
/* 110 */         zipOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */       
/* 113 */       bufferedInputStream.close();
/* 114 */       bufferedInputStream = null;
/* 115 */       zipOutputStream.close();
/* 116 */       zipOutputStream = null;
/*     */       
/* 118 */       if (!file1.delete()) {
/* 119 */         addStatus((Status)new WarnStatus("Could not delete [" + paramString1 + "].", this));
/*     */       }
/* 121 */     } catch (Exception exception) {
/* 122 */       addStatus((Status)new ErrorStatus("Error occurred while compressing [" + paramString1 + "] into [" + paramString2 + "].", this, exception));
/*     */     } finally {
/* 124 */       if (bufferedInputStream != null) {
/*     */         try {
/* 126 */           bufferedInputStream.close();
/* 127 */         } catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */       
/* 131 */       if (zipOutputStream != null) {
/*     */         try {
/* 133 */           zipOutputStream.close();
/* 134 */         } catch (IOException iOException) {}
/*     */       }
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   ZipEntry computeZipEntry(File paramFile) {
/* 158 */     return computeZipEntry(paramFile.getName());
/*     */   }
/*     */   
/*     */   ZipEntry computeZipEntry(String paramString) {
/* 162 */     String str = computeFileNameStrWithoutCompSuffix(paramString, this.compressionMode);
/* 163 */     return new ZipEntry(str);
/*     */   }
/*     */   
/*     */   private void gzCompress(String paramString1, String paramString2) {
/* 167 */     File file1 = new File(paramString1);
/*     */     
/* 169 */     if (!file1.exists()) {
/* 170 */       addStatus((Status)new WarnStatus("The file to compress named [" + paramString1 + "] does not exist.", this));
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 175 */     if (!paramString2.endsWith(".gz")) {
/* 176 */       paramString2 = paramString2 + ".gz";
/*     */     }
/*     */     
/* 179 */     File file2 = new File(paramString2);
/*     */     
/* 181 */     if (file2.exists()) {
/* 182 */       addWarn("The target compressed file named [" + paramString2 + "] exist already. Aborting file compression.");
/*     */       
/*     */       return;
/*     */     } 
/* 186 */     addInfo("GZ compressing [" + file1 + "] as [" + file2 + "]");
/* 187 */     createMissingTargetDirsIfNecessary(file2);
/*     */     
/* 189 */     BufferedInputStream bufferedInputStream = null;
/* 190 */     GZIPOutputStream gZIPOutputStream = null;
/*     */     try {
/* 192 */       bufferedInputStream = new BufferedInputStream(new FileInputStream(paramString1));
/* 193 */       gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(paramString2));
/* 194 */       byte[] arrayOfByte = new byte[8192];
/*     */       
/*     */       int i;
/* 197 */       while ((i = bufferedInputStream.read(arrayOfByte)) != -1) {
/* 198 */         gZIPOutputStream.write(arrayOfByte, 0, i);
/*     */       }
/*     */       
/* 201 */       bufferedInputStream.close();
/* 202 */       bufferedInputStream = null;
/* 203 */       gZIPOutputStream.close();
/* 204 */       gZIPOutputStream = null;
/*     */       
/* 206 */       if (!file1.delete()) {
/* 207 */         addStatus((Status)new WarnStatus("Could not delete [" + paramString1 + "].", this));
/*     */       }
/* 209 */     } catch (Exception exception) {
/* 210 */       addStatus((Status)new ErrorStatus("Error occurred while compressing [" + paramString1 + "] into [" + paramString2 + "].", this, exception));
/*     */     } finally {
/* 212 */       if (bufferedInputStream != null) {
/*     */         try {
/* 214 */           bufferedInputStream.close();
/* 215 */         } catch (IOException iOException) {}
/*     */       }
/*     */ 
/*     */       
/* 219 */       if (gZIPOutputStream != null) {
/*     */         try {
/* 221 */           gZIPOutputStream.close();
/* 222 */         } catch (IOException iOException) {}
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String computeFileNameStrWithoutCompSuffix(String paramString, CompressionMode paramCompressionMode) {
/* 230 */     int i = paramString.length();
/* 231 */     switch (null.s[paramCompressionMode.ordinal()]) {
/*     */       case 1:
/* 233 */         if (paramString.endsWith(".gz")) {
/* 234 */           return paramString.substring(0, i - 3);
/*     */         }
/* 236 */         return paramString;
/*     */       case 2:
/* 238 */         if (paramString.endsWith(".zip")) {
/* 239 */           return paramString.substring(0, i - 4);
/*     */         }
/* 241 */         return paramString;
/*     */       case 3:
/* 243 */         return paramString;
/*     */     } 
/* 245 */     throw new IllegalStateException("Execution should not reach this point");
/*     */   }
/*     */   
/*     */   void createMissingTargetDirsIfNecessary(File paramFile) {
/* 249 */     boolean bool = FileUtil.createMissingParentDirectories(paramFile);
/* 250 */     if (!bool) {
/* 251 */       addError("Failed to create parent directories for [" + paramFile.getAbsolutePath() + "]");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 257 */     return getClass().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public Future<?> asyncCompress(String paramString1, String paramString2, String paramString3) throws RolloverFailure {
/* 262 */     a a = new a(this, paramString1, paramString2, paramString3);
/* 263 */     ScheduledExecutorService scheduledExecutorService = this.context.getScheduledExecutorService();
/* 264 */     return scheduledExecutorService.submit(a);
/*     */   }
/*     */   
/*     */   class a
/*     */     implements Runnable
/*     */   {
/*     */     final String gn;
/*     */     final String go;
/*     */     final String gp;
/*     */     
/*     */     public a(Compressor this$0, String param1String1, String param1String2, String param1String3) {
/* 275 */       this.gn = param1String1;
/* 276 */       this.go = param1String2;
/* 277 */       this.gp = param1String3;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 282 */       this.a.compress(this.gn, this.go, this.gp);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\Compressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */