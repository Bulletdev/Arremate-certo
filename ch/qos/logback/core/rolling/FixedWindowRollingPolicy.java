/*     */ package ch.qos.logback.core.rolling;
/*     */ 
/*     */ import ch.qos.logback.core.rolling.helper.CompressionMode;
/*     */ import ch.qos.logback.core.rolling.helper.Compressor;
/*     */ import ch.qos.logback.core.rolling.helper.FileFilterUtil;
/*     */ import ch.qos.logback.core.rolling.helper.FileNamePattern;
/*     */ import ch.qos.logback.core.rolling.helper.IntegerTokenConverter;
/*     */ import ch.qos.logback.core.rolling.helper.RenameUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FixedWindowRollingPolicy
/*     */   extends RollingPolicyBase
/*     */ {
/*     */   static final String FNP_NOT_SET = "The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. ";
/*     */   static final String PRUDENT_MODE_UNSUPPORTED = "See also http://logback.qos.ch/codes.html#tbr_fnp_prudent_unsupported";
/*     */   static final String SEE_PARENT_FN_NOT_SET = "Please refer to http://logback.qos.ch/codes.html#fwrp_parentFileName_not_set";
/*     */   int maxIndex;
/*     */   int minIndex;
/*  39 */   RenameUtil util = new RenameUtil();
/*     */ 
/*     */   
/*     */   Compressor compressor;
/*     */ 
/*     */   
/*     */   public static final String ZIP_ENTRY_DATE_PATTERN = "yyyy-MM-dd_HHmm";
/*     */   
/*  47 */   private static int MAX_WINDOW_SIZE = 20;
/*     */   
/*     */   public FixedWindowRollingPolicy() {
/*  50 */     this.minIndex = 1;
/*  51 */     this.maxIndex = 7;
/*     */   }
/*     */   
/*     */   public void start() {
/*  55 */     this.util.setContext(this.context);
/*     */     
/*  57 */     if (this.fileNamePatternStr != null) {
/*  58 */       this.fileNamePattern = new FileNamePattern(this.fileNamePatternStr, this.context);
/*  59 */       determineCompressionMode();
/*     */     } else {
/*  61 */       addError("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. ");
/*  62 */       addError("See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
/*  63 */       throw new IllegalStateException("The \"FileNamePattern\" property must be set before using FixedWindowRollingPolicy. See also http://logback.qos.ch/codes.html#tbr_fnp_not_set");
/*     */     } 
/*     */     
/*  66 */     if (isParentPrudent()) {
/*  67 */       addError("Prudent mode is not supported with FixedWindowRollingPolicy.");
/*  68 */       addError("See also http://logback.qos.ch/codes.html#tbr_fnp_prudent_unsupported");
/*  69 */       throw new IllegalStateException("Prudent mode is not supported.");
/*     */     } 
/*     */     
/*  72 */     if (getParentsRawFileProperty() == null) {
/*  73 */       addError("The File name property must be set before using this rolling policy.");
/*  74 */       addError("Please refer to http://logback.qos.ch/codes.html#fwrp_parentFileName_not_set");
/*  75 */       throw new IllegalStateException("The \"File\" option must be set.");
/*     */     } 
/*     */     
/*  78 */     if (this.maxIndex < this.minIndex) {
/*  79 */       addWarn("MaxIndex (" + this.maxIndex + ") cannot be smaller than MinIndex (" + this.minIndex + ").");
/*  80 */       addWarn("Setting maxIndex to equal minIndex.");
/*  81 */       this.maxIndex = this.minIndex;
/*     */     } 
/*     */     
/*  84 */     int i = getMaxWindowSize();
/*  85 */     if (this.maxIndex - this.minIndex > i) {
/*  86 */       addWarn("Large window sizes are not allowed.");
/*  87 */       this.maxIndex = this.minIndex + i;
/*  88 */       addWarn("MaxIndex reduced to " + this.maxIndex);
/*     */     } 
/*     */     
/*  91 */     IntegerTokenConverter integerTokenConverter = this.fileNamePattern.getIntegerTokenConverter();
/*     */     
/*  93 */     if (integerTokenConverter == null) {
/*  94 */       throw new IllegalStateException("FileNamePattern [" + this.fileNamePattern.getPattern() + "] does not contain a valid IntegerToken");
/*     */     }
/*     */     
/*  97 */     if (this.compressionMode == CompressionMode.ZIP) {
/*  98 */       String str = transformFileNamePatternFromInt2Date(this.fileNamePatternStr);
/*  99 */       this.zipEntryFileNamePattern = new FileNamePattern(str, this.context);
/*     */     } 
/* 101 */     this.compressor = new Compressor(this.compressionMode);
/* 102 */     this.compressor.setContext(this.context);
/* 103 */     super.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getMaxWindowSize() {
/* 112 */     return MAX_WINDOW_SIZE;
/*     */   }
/*     */   
/*     */   private String transformFileNamePatternFromInt2Date(String paramString) {
/* 116 */     String str1 = FileFilterUtil.slashify(paramString);
/* 117 */     String str2 = FileFilterUtil.afterLastSlash(str1);
/* 118 */     return str2.replace("%i", "%d{yyyy-MM-dd_HHmm}");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollover() throws RolloverFailure {
/* 126 */     if (this.maxIndex >= 0) {
/*     */       
/* 128 */       File file = new File(this.fileNamePattern.convertInt(this.maxIndex));
/*     */       
/* 130 */       if (file.exists()) {
/* 131 */         file.delete();
/*     */       }
/*     */ 
/*     */       
/* 135 */       for (int i = this.maxIndex - 1; i >= this.minIndex; i--) {
/* 136 */         String str = this.fileNamePattern.convertInt(i);
/* 137 */         File file1 = new File(str);
/*     */         
/* 139 */         if (file1.exists()) {
/* 140 */           this.util.rename(str, this.fileNamePattern.convertInt(i + 1));
/*     */         } else {
/* 142 */           addInfo("Skipping roll-over for inexistent file " + str);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 147 */       switch (null.s[this.compressionMode.ordinal()]) {
/*     */         case 1:
/* 149 */           this.util.rename(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex));
/*     */           break;
/*     */         case 2:
/* 152 */           this.compressor.compress(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex), null);
/*     */           break;
/*     */         case 3:
/* 155 */           this.compressor.compress(getActiveFileName(), this.fileNamePattern.convertInt(this.minIndex), this.zipEntryFileNamePattern.convert(new Date()));
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getActiveFileName() {
/* 165 */     return getParentsRawFileProperty();
/*     */   }
/*     */   
/*     */   public int getMaxIndex() {
/* 169 */     return this.maxIndex;
/*     */   }
/*     */   
/*     */   public int getMinIndex() {
/* 173 */     return this.minIndex;
/*     */   }
/*     */   
/*     */   public void setMaxIndex(int paramInt) {
/* 177 */     this.maxIndex = paramInt;
/*     */   }
/*     */   
/*     */   public void setMinIndex(int paramInt) {
/* 181 */     this.minIndex = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\FixedWindowRollingPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */