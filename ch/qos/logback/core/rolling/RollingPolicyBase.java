/*    */ package ch.qos.logback.core.rolling;
/*    */ 
/*    */ import ch.qos.logback.core.FileAppender;
/*    */ import ch.qos.logback.core.rolling.helper.CompressionMode;
/*    */ import ch.qos.logback.core.rolling.helper.FileNamePattern;
/*    */ import ch.qos.logback.core.spi.ContextAwareBase;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class RollingPolicyBase
/*    */   extends ContextAwareBase
/*    */   implements RollingPolicy
/*    */ {
/* 28 */   protected CompressionMode compressionMode = CompressionMode.NONE;
/*    */ 
/*    */   
/*    */   FileNamePattern fileNamePattern;
/*    */ 
/*    */   
/*    */   protected String fileNamePatternStr;
/*    */ 
/*    */   
/*    */   private FileAppender<?> parent;
/*    */ 
/*    */   
/*    */   FileNamePattern zipEntryFileNamePattern;
/*    */ 
/*    */   
/*    */   private boolean started;
/*    */ 
/*    */ 
/*    */   
/*    */   protected void determineCompressionMode() {
/* 48 */     if (this.fileNamePatternStr.endsWith(".gz")) {
/* 49 */       addInfo("Will use gz compression");
/* 50 */       this.compressionMode = CompressionMode.GZ;
/* 51 */     } else if (this.fileNamePatternStr.endsWith(".zip")) {
/* 52 */       addInfo("Will use zip compression");
/* 53 */       this.compressionMode = CompressionMode.ZIP;
/*    */     } else {
/* 55 */       addInfo("No compression will be used");
/* 56 */       this.compressionMode = CompressionMode.NONE;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setFileNamePattern(String paramString) {
/* 61 */     this.fileNamePatternStr = paramString;
/*    */   }
/*    */   
/*    */   public String getFileNamePattern() {
/* 65 */     return this.fileNamePatternStr;
/*    */   }
/*    */   
/*    */   public CompressionMode getCompressionMode() {
/* 69 */     return this.compressionMode;
/*    */   }
/*    */   
/*    */   public boolean isStarted() {
/* 73 */     return this.started;
/*    */   }
/*    */   
/*    */   public void start() {
/* 77 */     this.started = true;
/*    */   }
/*    */   
/*    */   public void stop() {
/* 81 */     this.started = false;
/*    */   }
/*    */   
/*    */   public void setParent(FileAppender<?> paramFileAppender) {
/* 85 */     this.parent = paramFileAppender;
/*    */   }
/*    */   
/*    */   public boolean isParentPrudent() {
/* 89 */     return this.parent.isPrudent();
/*    */   }
/*    */   
/*    */   public String getParentsRawFileProperty() {
/* 93 */     return this.parent.rawFileProperty();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\RollingPolicyBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */