/*     */ package ch.qos.logback.core.rolling;
/*     */ 
/*     */ import ch.qos.logback.core.joran.spi.NoAutoStart;
/*     */ import ch.qos.logback.core.rolling.helper.ArchiveRemover;
/*     */ import ch.qos.logback.core.rolling.helper.CompressionMode;
/*     */ import ch.qos.logback.core.rolling.helper.FileFilterUtil;
/*     */ import ch.qos.logback.core.rolling.helper.SizeAndTimeBasedArchiveRemover;
/*     */ import ch.qos.logback.core.util.DefaultInvocationGate;
/*     */ import ch.qos.logback.core.util.FileSize;
/*     */ import ch.qos.logback.core.util.InvocationGate;
/*     */ import java.io.File;
/*     */ import java.util.Date;
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
/*     */ @NoAutoStart
/*     */ public class SizeAndTimeBasedFNATP<E>
/*     */   extends TimeBasedFileNamingAndTriggeringPolicyBase<E>
/*     */ {
/*     */   enum a
/*     */   {
/*  34 */     a, b;
/*     */   }
/*     */   
/*  37 */   int currentPeriodsCounter = 0;
/*     */   
/*     */   FileSize maxFileSize;
/*     */   
/*  41 */   long nextSizeCheck = 0L;
/*  42 */   static String MISSING_INT_TOKEN = "Missing integer token, that is %i, in FileNamePattern [";
/*  43 */   static String MISSING_DATE_TOKEN = "Missing date token, that is %d, in FileNamePattern [";
/*     */   private final a usage;
/*     */   InvocationGate invocationGate;
/*     */   
/*     */   public SizeAndTimeBasedFNATP() {
/*  48 */     this(a.b);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void start() {
/*  58 */     super.start();
/*     */     
/*  60 */     if (this.usage == a.b) {
/*  61 */       addWarn("SizeAndTimeBasedFNATP is deprecated. Use SizeAndTimeBasedRollingPolicy instead");
/*  62 */       addWarn("For more information see http://logback.qos.ch/manual/appenders.html#SizeAndTimeBasedRollingPolicy");
/*     */     } 
/*     */     
/*  65 */     if (!isErrorFree()) {
/*     */       return;
/*     */     }
/*     */     
/*  69 */     if (this.maxFileSize == null) {
/*  70 */       addError("maxFileSize property is mandatory.");
/*  71 */       withErrors();
/*     */     } 
/*     */     
/*  74 */     if (!validateDateAndIntegerTokens()) {
/*  75 */       withErrors();
/*     */       
/*     */       return;
/*     */     } 
/*  79 */     this.archiveRemover = createArchiveRemover();
/*  80 */     this.archiveRemover.setContext(this.context);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  85 */     String str1 = this.tbrp.fileNamePattern.toRegexForFixedDate(this.dateInCurrentPeriod);
/*  86 */     String str2 = FileFilterUtil.afterLastSlash(str1);
/*     */     
/*  88 */     computeCurrentPeriodsHighestCounterValue(str2);
/*     */     
/*  90 */     if (isErrorFree()) {
/*  91 */       this.started = true;
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean validateDateAndIntegerTokens() {
/*  96 */     boolean bool = false;
/*  97 */     if (this.tbrp.fileNamePattern.getIntegerTokenConverter() == null) {
/*  98 */       bool = true;
/*  99 */       addError(MISSING_INT_TOKEN + this.tbrp.fileNamePatternStr + "]");
/* 100 */       addError("See also http://logback.qos.ch/codes.html#sat_missing_integer_token");
/*     */     } 
/* 102 */     if (this.tbrp.fileNamePattern.getPrimaryDateTokenConverter() == null) {
/* 103 */       bool = true;
/* 104 */       addError(MISSING_DATE_TOKEN + this.tbrp.fileNamePatternStr + "]");
/*     */     } 
/*     */     
/* 107 */     return !bool;
/*     */   }
/*     */   
/*     */   protected ArchiveRemover createArchiveRemover() {
/* 111 */     return (ArchiveRemover)new SizeAndTimeBasedArchiveRemover(this.tbrp.fileNamePattern, this.rc);
/*     */   }
/*     */   
/*     */   void computeCurrentPeriodsHighestCounterValue(String paramString) {
/* 115 */     File file1 = new File(getCurrentPeriodsFileNameWithoutCompressionSuffix());
/* 116 */     File file2 = file1.getParentFile();
/*     */     
/* 118 */     File[] arrayOfFile = FileFilterUtil.filesInFolderMatchingStemRegex(file2, paramString);
/*     */     
/* 120 */     if (arrayOfFile == null || arrayOfFile.length == 0) {
/* 121 */       this.currentPeriodsCounter = 0;
/*     */       return;
/*     */     } 
/* 124 */     this.currentPeriodsCounter = FileFilterUtil.findHighestCounter(arrayOfFile, paramString);
/*     */ 
/*     */ 
/*     */     
/* 128 */     if (this.tbrp.getParentsRawFileProperty() != null || this.tbrp.compressionMode != CompressionMode.NONE)
/*     */     {
/* 130 */       this.currentPeriodsCounter++; } 
/*     */   }
/*     */   
/*     */   public SizeAndTimeBasedFNATP(a parama) {
/* 134 */     this.invocationGate = (InvocationGate)new DefaultInvocationGate();
/*     */     this.usage = parama;
/*     */   }
/*     */   
/*     */   public boolean isTriggeringEvent(File paramFile, E paramE) {
/* 139 */     long l = getCurrentTime();
/*     */ 
/*     */     
/* 142 */     if (l >= this.nextCheck) {
/* 143 */       Date date = this.dateInCurrentPeriod;
/* 144 */       this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(new Object[] { date, Integer.valueOf(this.currentPeriodsCounter) });
/* 145 */       this.currentPeriodsCounter = 0;
/* 146 */       setDateInCurrentPeriod(l);
/* 147 */       computeNextCheck();
/* 148 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 152 */     if (this.invocationGate.isTooSoon(l)) {
/* 153 */       return false;
/*     */     }
/*     */     
/* 156 */     if (paramFile == null) {
/* 157 */       addWarn("activeFile == null");
/* 158 */       return false;
/*     */     } 
/* 160 */     if (this.maxFileSize == null) {
/* 161 */       addWarn("maxFileSize = null");
/* 162 */       return false;
/*     */     } 
/* 164 */     if (paramFile.length() >= this.maxFileSize.getSize()) {
/*     */       
/* 166 */       this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(new Object[] { this.dateInCurrentPeriod, Integer.valueOf(this.currentPeriodsCounter) });
/* 167 */       this.currentPeriodsCounter++;
/* 168 */       return true;
/*     */     } 
/*     */     
/* 171 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCurrentPeriodsFileNameWithoutCompressionSuffix() {
/* 176 */     return this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(new Object[] { this.dateInCurrentPeriod, Integer.valueOf(this.currentPeriodsCounter) });
/*     */   }
/*     */   
/*     */   public void setMaxFileSize(FileSize paramFileSize) {
/* 180 */     this.maxFileSize = paramFileSize;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\SizeAndTimeBasedFNATP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */