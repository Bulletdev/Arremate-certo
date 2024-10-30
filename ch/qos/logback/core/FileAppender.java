/*     */ package ch.qos.logback.core;
/*     */ 
/*     */ import ch.qos.logback.core.recovery.ResilientFileOutputStream;
/*     */ import ch.qos.logback.core.util.ContextUtil;
/*     */ import ch.qos.logback.core.util.FileSize;
/*     */ import ch.qos.logback.core.util.FileUtil;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.channels.FileChannel;
/*     */ import java.nio.channels.FileLock;
/*     */ import java.util.Map;
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
/*     */ public class FileAppender<E>
/*     */   extends OutputStreamAppender<E>
/*     */ {
/*     */   public static final long DEFAULT_BUFFER_SIZE = 8192L;
/*  43 */   protected static String COLLISION_WITH_EARLIER_APPENDER_URL = "http://logback.qos.ch/codes.html#earlier_fa_collision";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean append = true;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   protected String fileName = null;
/*     */   
/*     */   private boolean prudent = false;
/*     */   
/*  59 */   private FileSize bufferSize = new FileSize(8192L);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFile(String paramString) {
/*  66 */     if (paramString == null) {
/*  67 */       this.fileName = paramString;
/*     */     }
/*     */     else {
/*     */       
/*  71 */       this.fileName = paramString.trim();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAppend() {
/*  79 */     return this.append;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String rawFileProperty() {
/*  89 */     return this.fileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFile() {
/* 100 */     return this.fileName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/* 109 */     byte b = 0;
/* 110 */     if (getFile() != null) {
/* 111 */       addInfo("File property is set to [" + this.fileName + "]");
/*     */       
/* 113 */       if (this.prudent && 
/* 114 */         !isAppend()) {
/* 115 */         setAppend(true);
/* 116 */         addWarn("Setting \"Append\" property to true on account of \"Prudent\" mode");
/*     */       } 
/*     */ 
/*     */       
/* 120 */       if (checkForFileCollisionInPreviousFileAppenders()) {
/* 121 */         addError("Collisions detected with FileAppender/RollingAppender instances defined earlier. Aborting.");
/* 122 */         addError("For more information, please visit " + COLLISION_WITH_EARLIER_APPENDER_URL);
/* 123 */         b++;
/*     */       } else {
/*     */         
/*     */         try {
/* 127 */           openFile(getFile());
/* 128 */         } catch (IOException iOException) {
/* 129 */           b++;
/* 130 */           addError("openFile(" + this.fileName + "," + this.append + ") call failed.", iOException);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 134 */       b++;
/* 135 */       addError("\"File\" property not set for appender named [" + this.name + "].");
/*     */     } 
/* 137 */     if (b == 0) {
/* 138 */       super.start();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 144 */     super.stop();
/*     */     
/* 146 */     Map map = ContextUtil.getFilenameCollisionMap(this.context);
/* 147 */     if (map == null || getName() == null) {
/*     */       return;
/*     */     }
/* 150 */     map.remove(getName());
/*     */   }
/*     */   
/*     */   protected boolean checkForFileCollisionInPreviousFileAppenders() {
/* 154 */     boolean bool = false;
/* 155 */     if (this.fileName == null) {
/* 156 */       return false;
/*     */     }
/*     */     
/* 159 */     Map<String, String> map = (Map)this.context.getObject("FA_FILENAME_COLLISION_MAP");
/* 160 */     if (map == null) {
/* 161 */       return bool;
/*     */     }
/* 163 */     for (Map.Entry entry : map.entrySet()) {
/* 164 */       if (this.fileName.equals(entry.getValue())) {
/* 165 */         addErrorForCollision("File", (String)entry.getValue(), (String)entry.getKey());
/* 166 */         bool = true;
/*     */       } 
/*     */     } 
/* 169 */     if (this.name != null) {
/* 170 */       map.put(getName(), this.fileName);
/*     */     }
/* 172 */     return bool;
/*     */   }
/*     */   
/*     */   protected void addErrorForCollision(String paramString1, String paramString2, String paramString3) {
/* 176 */     addError("'" + paramString1 + "' option has the same value \"" + paramString2 + "\" as that given for appender [" + paramString3 + "] defined earlier.");
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
/*     */   public void openFile(String paramString) throws IOException {
/* 196 */     this.lock.lock();
/*     */     try {
/* 198 */       File file = new File(paramString);
/* 199 */       boolean bool = FileUtil.createMissingParentDirectories(file);
/* 200 */       if (!bool) {
/* 201 */         addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
/*     */       }
/*     */       
/* 204 */       ResilientFileOutputStream resilientFileOutputStream = new ResilientFileOutputStream(file, this.append, this.bufferSize.getSize());
/* 205 */       resilientFileOutputStream.setContext(this.context);
/* 206 */       setOutputStream((OutputStream)resilientFileOutputStream);
/*     */     } finally {
/* 208 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPrudent() {
/* 218 */     return this.prudent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPrudent(boolean paramBoolean) {
/* 228 */     this.prudent = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setAppend(boolean paramBoolean) {
/* 232 */     this.append = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setBufferSize(FileSize paramFileSize) {
/* 236 */     addInfo("Setting bufferSize to [" + paramFileSize.toString() + "]");
/* 237 */     this.bufferSize = paramFileSize;
/*     */   }
/*     */   
/*     */   private void safeWrite(E paramE) throws IOException {
/* 241 */     ResilientFileOutputStream resilientFileOutputStream = (ResilientFileOutputStream)getOutputStream();
/* 242 */     FileChannel fileChannel = resilientFileOutputStream.getChannel();
/* 243 */     if (fileChannel == null) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 248 */     boolean bool = Thread.interrupted();
/*     */     
/* 250 */     FileLock fileLock = null;
/*     */     try {
/* 252 */       fileLock = fileChannel.lock();
/* 253 */       long l1 = fileChannel.position();
/* 254 */       long l2 = fileChannel.size();
/* 255 */       if (l2 != l1) {
/* 256 */         fileChannel.position(l2);
/*     */       }
/* 258 */       super.writeOut(paramE);
/* 259 */     } catch (IOException iOException) {
/*     */       
/* 261 */       resilientFileOutputStream.postIOFailure(iOException);
/*     */     } finally {
/* 263 */       if (fileLock != null && fileLock.isValid()) {
/* 264 */         fileLock.release();
/*     */       }
/*     */ 
/*     */       
/* 268 */       if (bool) {
/* 269 */         Thread.currentThread().interrupt();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void writeOut(E paramE) throws IOException {
/* 276 */     if (this.prudent) {
/* 277 */       safeWrite(paramE);
/*     */     } else {
/* 279 */       super.writeOut(paramE);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\FileAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */