/*     */ package ch.qos.logback.core.rolling;
/*     */ 
/*     */ import ch.qos.logback.core.FileAppender;
/*     */ import ch.qos.logback.core.rolling.helper.CompressionMode;
/*     */ import ch.qos.logback.core.rolling.helper.FileNamePattern;
/*     */ import ch.qos.logback.core.util.ContextUtil;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RollingFileAppender<E>
/*     */   extends FileAppender<E>
/*     */ {
/*     */   File currentlyActiveFile;
/*     */   TriggeringPolicy<E> triggeringPolicy;
/*     */   RollingPolicy rollingPolicy;
/*  46 */   private static String RFA_NO_TP_URL = "http://logback.qos.ch/codes.html#rfa_no_tp";
/*  47 */   private static String RFA_NO_RP_URL = "http://logback.qos.ch/codes.html#rfa_no_rp";
/*  48 */   private static String COLLISION_URL = "http://logback.qos.ch/codes.html#rfa_collision";
/*  49 */   private static String RFA_LATE_FILE_URL = "http://logback.qos.ch/codes.html#rfa_file_after";
/*     */   
/*     */   public void start() {
/*  52 */     if (this.triggeringPolicy == null) {
/*  53 */       addWarn("No TriggeringPolicy was set for the RollingFileAppender named " + getName());
/*  54 */       addWarn("For more information, please visit " + RFA_NO_TP_URL);
/*     */       return;
/*     */     } 
/*  57 */     if (!this.triggeringPolicy.isStarted()) {
/*  58 */       addWarn("TriggeringPolicy has not started. RollingFileAppender will not start");
/*     */       
/*     */       return;
/*     */     } 
/*  62 */     if (checkForCollisionsInPreviousRollingFileAppenders()) {
/*  63 */       addError("Collisions detected with FileAppender/RollingAppender instances defined earlier. Aborting.");
/*  64 */       addError("For more information, please visit " + COLLISION_WITH_EARLIER_APPENDER_URL);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  69 */     if (!this.append) {
/*  70 */       addWarn("Append mode is mandatory for RollingFileAppender. Defaulting to append=true.");
/*  71 */       this.append = true;
/*     */     } 
/*     */     
/*  74 */     if (this.rollingPolicy == null) {
/*  75 */       addError("No RollingPolicy was set for the RollingFileAppender named " + getName());
/*  76 */       addError("For more information, please visit " + RFA_NO_RP_URL);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  81 */     if (checkForFileAndPatternCollisions()) {
/*  82 */       addError("File property collides with fileNamePattern. Aborting.");
/*  83 */       addError("For more information, please visit " + COLLISION_URL);
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     if (isPrudent()) {
/*  88 */       if (rawFileProperty() != null) {
/*  89 */         addWarn("Setting \"File\" property to null on account of prudent mode");
/*  90 */         setFile((String)null);
/*     */       } 
/*  92 */       if (this.rollingPolicy.getCompressionMode() != CompressionMode.NONE) {
/*  93 */         addError("Compression is not supported in prudent mode. Aborting");
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*  98 */     this.currentlyActiveFile = new File(getFile());
/*  99 */     addInfo("Active log file name: " + getFile());
/* 100 */     super.start();
/*     */   }
/*     */   
/*     */   private boolean checkForFileAndPatternCollisions() {
/* 104 */     if (this.triggeringPolicy instanceof RollingPolicyBase) {
/* 105 */       RollingPolicyBase rollingPolicyBase = (RollingPolicyBase)this.triggeringPolicy;
/* 106 */       FileNamePattern fileNamePattern = rollingPolicyBase.fileNamePattern;
/*     */       
/* 108 */       if (fileNamePattern != null && this.fileName != null) {
/* 109 */         String str = fileNamePattern.toRegex();
/* 110 */         return this.fileName.matches(str);
/*     */       } 
/*     */     } 
/* 113 */     return false;
/*     */   }
/*     */   
/*     */   private boolean checkForCollisionsInPreviousRollingFileAppenders() {
/* 117 */     boolean bool = false;
/* 118 */     if (this.triggeringPolicy instanceof RollingPolicyBase) {
/* 119 */       RollingPolicyBase rollingPolicyBase = (RollingPolicyBase)this.triggeringPolicy;
/* 120 */       FileNamePattern fileNamePattern = rollingPolicyBase.fileNamePattern;
/* 121 */       boolean bool1 = innerCheckForFileNamePatternCollisionInPreviousRFA(fileNamePattern);
/* 122 */       if (bool1)
/* 123 */         bool = true; 
/*     */     } 
/* 125 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean innerCheckForFileNamePatternCollisionInPreviousRFA(FileNamePattern paramFileNamePattern) {
/* 129 */     boolean bool = false;
/*     */     
/* 131 */     Map<String, FileNamePattern> map = (Map)this.context.getObject("RFA_FILENAME_PATTERN_COLLISION_MAP");
/* 132 */     if (map == null) {
/* 133 */       return bool;
/*     */     }
/* 135 */     for (Map.Entry entry : map.entrySet()) {
/* 136 */       if (paramFileNamePattern.equals(entry.getValue())) {
/* 137 */         addErrorForCollision("FileNamePattern", ((FileNamePattern)entry.getValue()).toString(), (String)entry.getKey());
/* 138 */         bool = true;
/*     */       } 
/*     */     } 
/* 141 */     if (this.name != null) {
/* 142 */       map.put(getName(), paramFileNamePattern);
/*     */     }
/* 144 */     return bool;
/*     */   }
/*     */ 
/*     */   
/*     */   public void stop() {
/* 149 */     super.stop();
/*     */     
/* 151 */     if (this.rollingPolicy != null)
/* 152 */       this.rollingPolicy.stop(); 
/* 153 */     if (this.triggeringPolicy != null) {
/* 154 */       this.triggeringPolicy.stop();
/*     */     }
/* 156 */     Map map = ContextUtil.getFilenamePatternCollisionMap(this.context);
/* 157 */     if (map != null && getName() != null) {
/* 158 */       map.remove(getName());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFile(String paramString) {
/* 166 */     if (paramString != null && (this.triggeringPolicy != null || this.rollingPolicy != null)) {
/* 167 */       addError("File property must be set before any triggeringPolicy or rollingPolicy properties");
/* 168 */       addError("For more information, please visit " + RFA_LATE_FILE_URL);
/*     */     } 
/* 170 */     super.setFile(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getFile() {
/* 175 */     return this.rollingPolicy.getActiveFileName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollover() {
/* 182 */     this.lock.lock();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 189 */       closeOutputStream();
/* 190 */       attemptRollover();
/* 191 */       attemptOpenFile();
/*     */     } finally {
/* 193 */       this.lock.unlock();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void attemptOpenFile() {
/*     */     try {
/* 200 */       this.currentlyActiveFile = new File(this.rollingPolicy.getActiveFileName());
/*     */ 
/*     */       
/* 203 */       openFile(this.rollingPolicy.getActiveFileName());
/* 204 */     } catch (IOException iOException) {
/* 205 */       addError("setFile(" + this.fileName + ", false) call failed.", iOException);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void attemptRollover() {
/*     */     try {
/* 211 */       this.rollingPolicy.rollover();
/* 212 */     } catch (RolloverFailure rolloverFailure) {
/* 213 */       addWarn("RolloverFailure occurred. Deferring roll-over.");
/*     */       
/* 215 */       this.append = true;
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
/*     */   protected void subAppend(E paramE) {
/* 229 */     synchronized (this.triggeringPolicy) {
/* 230 */       if (this.triggeringPolicy.isTriggeringEvent(this.currentlyActiveFile, paramE)) {
/* 231 */         rollover();
/*     */       }
/*     */     } 
/*     */     
/* 235 */     super.subAppend(paramE);
/*     */   }
/*     */   
/*     */   public RollingPolicy getRollingPolicy() {
/* 239 */     return this.rollingPolicy;
/*     */   }
/*     */   
/*     */   public TriggeringPolicy<E> getTriggeringPolicy() {
/* 243 */     return this.triggeringPolicy;
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
/*     */   public void setRollingPolicy(RollingPolicy paramRollingPolicy) {
/* 255 */     this.rollingPolicy = paramRollingPolicy;
/* 256 */     if (this.rollingPolicy instanceof TriggeringPolicy) {
/* 257 */       this.triggeringPolicy = (TriggeringPolicy<E>)paramRollingPolicy;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTriggeringPolicy(TriggeringPolicy<E> paramTriggeringPolicy) {
/* 263 */     this.triggeringPolicy = paramTriggeringPolicy;
/* 264 */     if (paramTriggeringPolicy instanceof RollingPolicy)
/* 265 */       this.rollingPolicy = (RollingPolicy)paramTriggeringPolicy; 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\RollingFileAppender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */