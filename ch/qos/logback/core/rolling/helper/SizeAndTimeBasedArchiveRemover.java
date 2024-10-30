/*    */ package ch.qos.logback.core.rolling.helper;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.util.Date;
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
/*    */ public class SizeAndTimeBasedArchiveRemover
/*    */   extends TimeBasedArchiveRemover
/*    */ {
/*    */   public SizeAndTimeBasedArchiveRemover(FileNamePattern paramFileNamePattern, RollingCalendar paramRollingCalendar) {
/* 22 */     super(paramFileNamePattern, paramRollingCalendar);
/*    */   }
/*    */   
/*    */   protected File[] getFilesInPeriod(Date paramDate) {
/* 26 */     File file1 = new File(this.fileNamePattern.convertMultipleArguments(new Object[] { paramDate, Integer.valueOf(0) }));
/* 27 */     File file2 = getParentDir(file1);
/* 28 */     String str = createStemRegex(paramDate);
/* 29 */     return FileFilterUtil.filesInFolderMatchingStemRegex(file2, str);
/*    */   }
/*    */ 
/*    */   
/*    */   private String createStemRegex(Date paramDate) {
/* 34 */     String str = this.fileNamePattern.toRegexForFixedDate(paramDate);
/* 35 */     return FileFilterUtil.afterLastSlash(str);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\helper\SizeAndTimeBasedArchiveRemover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */