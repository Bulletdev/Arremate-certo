/*     */ package ch.qos.logback.core.rolling.helper;
/*     */ 
/*     */ import ch.qos.logback.core.pattern.Converter;
/*     */ import ch.qos.logback.core.spi.ContextAwareBase;
/*     */ import ch.qos.logback.core.util.FileSize;
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.Comparator;
/*     */ import java.util.Date;
/*     */ import java.util.concurrent.Future;
/*     */ import java.util.concurrent.ScheduledExecutorService;
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
/*     */ public class TimeBasedArchiveRemover
/*     */   extends ContextAwareBase
/*     */   implements ArchiveRemover
/*     */ {
/*     */   protected static final long UNINITIALIZED = -1L;
/*     */   protected static final long INACTIVITY_TOLERANCE_IN_MILLIS = 2764800000L;
/*     */   static final int MAX_VALUE_FOR_INACTIVITY_PERIODS = 336;
/*     */   final FileNamePattern fileNamePattern;
/*     */   final RollingCalendar rc;
/*  40 */   private int maxHistory = 0;
/*  41 */   private long totalSizeCap = 0L;
/*     */   final boolean parentClean;
/*  43 */   long lastHeartBeat = -1L;
/*     */ 
/*     */   
/*     */   int callCount;
/*     */ 
/*     */ 
/*     */   
/*     */   public TimeBasedArchiveRemover(FileNamePattern paramFileNamePattern, RollingCalendar paramRollingCalendar) {
/*  51 */     this.callCount = 0;
/*     */     this.fileNamePattern = paramFileNamePattern;
/*     */     this.rc = paramRollingCalendar;
/*  54 */     this.parentClean = computeParentCleaningFlag(paramFileNamePattern); } public void clean(Date paramDate) { long l = paramDate.getTime();
/*     */     
/*  56 */     int i = computeElapsedPeriodsSinceLastClean(l);
/*  57 */     this.lastHeartBeat = l;
/*  58 */     if (i > 1) {
/*  59 */       addInfo("Multiple periods, i.e. " + i + " periods, seem to have elapsed. This is expected at application start.");
/*     */     }
/*  61 */     for (byte b = 0; b < i; b++) {
/*  62 */       int j = getPeriodOffsetForDeletionTarget() - b;
/*  63 */       Date date = this.rc.getEndOfNextNthPeriod(paramDate, j);
/*  64 */       cleanPeriod(date);
/*     */     }  }
/*     */ 
/*     */   
/*     */   protected File[] getFilesInPeriod(Date paramDate) {
/*  69 */     String str = this.fileNamePattern.convert(paramDate);
/*  70 */     File file = new File(str);
/*     */     
/*  72 */     if (fileExistsAndIsFile(file)) {
/*  73 */       return new File[] { file };
/*     */     }
/*  75 */     return new File[0];
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean fileExistsAndIsFile(File paramFile) {
/*  80 */     return (paramFile.exists() && paramFile.isFile());
/*     */   }
/*     */   
/*     */   public void cleanPeriod(Date paramDate) {
/*  84 */     File[] arrayOfFile = getFilesInPeriod(paramDate);
/*     */     
/*  86 */     for (File file : arrayOfFile) {
/*  87 */       addInfo("deleting " + file);
/*  88 */       file.delete();
/*     */     } 
/*     */     
/*  91 */     if (this.parentClean && arrayOfFile.length > 0) {
/*  92 */       File file = getParentDir(arrayOfFile[0]);
/*  93 */       removeFolderIfEmpty(file);
/*     */     } 
/*     */   }
/*     */   
/*     */   void capTotalSize(Date paramDate) {
/*  98 */     long l1 = 0L;
/*  99 */     long l2 = 0L;
/* 100 */     for (byte b = 0; b < this.maxHistory; b++) {
/* 101 */       Date date = this.rc.getEndOfNextNthPeriod(paramDate, -b);
/* 102 */       File[] arrayOfFile = getFilesInPeriod(date);
/* 103 */       descendingSortByLastModified(arrayOfFile);
/* 104 */       for (File file : arrayOfFile) {
/* 105 */         long l = file.length();
/* 106 */         if (l1 + l > this.totalSizeCap) {
/* 107 */           addInfo("Deleting [" + file + "] of size " + new FileSize(l));
/* 108 */           l2 += l;
/* 109 */           file.delete();
/*     */         } 
/* 111 */         l1 += l;
/*     */       } 
/*     */     } 
/* 114 */     addInfo("Removed  " + new FileSize(l2) + " of files");
/*     */   }
/*     */   
/*     */   private void descendingSortByLastModified(File[] paramArrayOfFile) {
/* 118 */     Arrays.sort(paramArrayOfFile, new Comparator<File>()
/*     */         {
/*     */           public int compare(File param1File1, File param1File2) {
/* 121 */             long l1 = param1File1.lastModified();
/* 122 */             long l2 = param1File2.lastModified();
/* 123 */             if (l1 == l2) {
/* 124 */               return 0;
/*     */             }
/* 126 */             if (l2 < l1) {
/* 127 */               return -1;
/*     */             }
/* 129 */             return 1;
/*     */           }
/*     */         });
/*     */   }
/*     */   
/*     */   File getParentDir(File paramFile) {
/* 135 */     File file = paramFile.getAbsoluteFile();
/* 136 */     return file.getParentFile();
/*     */   }
/*     */ 
/*     */   
/*     */   int computeElapsedPeriodsSinceLastClean(long paramLong) {
/* 141 */     long l = 0L;
/* 142 */     if (this.lastHeartBeat == -1L) {
/* 143 */       addInfo("first clean up after appender initialization");
/* 144 */       l = this.rc.periodBarriersCrossed(paramLong, paramLong + 2764800000L);
/* 145 */       l = Math.min(l, 336L);
/*     */     } else {
/* 147 */       l = this.rc.periodBarriersCrossed(this.lastHeartBeat, paramLong);
/*     */     } 
/*     */     
/* 150 */     return (int)l;
/*     */   }
/*     */   
/*     */   boolean computeParentCleaningFlag(FileNamePattern paramFileNamePattern) {
/* 154 */     DateTokenConverter<Object> dateTokenConverter = paramFileNamePattern.getPrimaryDateTokenConverter();
/*     */     
/* 156 */     if (dateTokenConverter.getDatePattern().indexOf('/') != -1) {
/* 157 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 162 */     Converter<Object> converter = paramFileNamePattern.headTokenConverter;
/*     */ 
/*     */     
/* 165 */     while (converter != null && 
/* 166 */       !(converter instanceof DateTokenConverter))
/*     */     {
/*     */       
/* 169 */       converter = converter.getNext();
/*     */     }
/*     */     
/* 172 */     while (converter != null) {
/* 173 */       if (converter instanceof ch.qos.logback.core.pattern.LiteralConverter) {
/* 174 */         String str = converter.convert(null);
/* 175 */         if (str.indexOf('/') != -1) {
/* 176 */           return true;
/*     */         }
/*     */       } 
/* 179 */       converter = converter.getNext();
/*     */     } 
/*     */ 
/*     */     
/* 183 */     return false;
/*     */   }
/*     */   
/*     */   void removeFolderIfEmpty(File paramFile) {
/* 187 */     removeFolderIfEmpty(paramFile, 0);
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
/*     */   private void removeFolderIfEmpty(File paramFile, int paramInt) {
/* 200 */     if (paramInt >= 3) {
/*     */       return;
/*     */     }
/* 203 */     if (paramFile.isDirectory() && FileFilterUtil.isEmptyDirectory(paramFile)) {
/* 204 */       addInfo("deleting folder [" + paramFile + "]");
/* 205 */       paramFile.delete();
/* 206 */       removeFolderIfEmpty(paramFile.getParentFile(), paramInt + 1);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setMaxHistory(int paramInt) {
/* 211 */     this.maxHistory = paramInt;
/*     */   }
/*     */   
/*     */   protected int getPeriodOffsetForDeletionTarget() {
/* 215 */     return -this.maxHistory - 1;
/*     */   }
/*     */   
/*     */   public void setTotalSizeCap(long paramLong) {
/* 219 */     this.totalSizeCap = paramLong;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 223 */     return "c.q.l.core.rolling.helper.TimeBasedArchiveRemover";
/*     */   }
/*     */   
/*     */   public Future<?> cleanAsynchronously(Date paramDate) {
/* 227 */     ArhiveRemoverRunnable arhiveRemoverRunnable = new ArhiveRemoverRunnable(paramDate);
/* 228 */     ScheduledExecutorService scheduledExecutorService = this.context.getScheduledExecutorService();
/* 229 */     return scheduledExecutorService.submit(arhiveRemoverRunnable);
/*     */   }
/*     */   
/*     */   public class ArhiveRemoverRunnable
/*     */     implements Runnable {
/*     */     Date now;
/*     */     
/*     */     ArhiveRemoverRunnable(Date param1Date) {
/* 237 */       this.now = param1Date;
/*     */     }
/*     */ 
/*     */     
/*     */     public void run() {
/* 242 */       TimeBasedArchiveRemover.this.clean(this.now);
/* 243 */       if (TimeBasedArchiveRemover.this.totalSizeCap != 0L && TimeBasedArchiveRemover.this.totalSizeCap > 0L)
/* 244 */         TimeBasedArchiveRemover.this.capTotalSize(this.now); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\TimeBasedArchiveRemover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */