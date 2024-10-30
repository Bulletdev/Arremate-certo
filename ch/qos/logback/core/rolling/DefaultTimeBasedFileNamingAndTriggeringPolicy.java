/*    */ package ch.qos.logback.core.rolling;
/*    */ 
/*    */ import ch.qos.logback.core.joran.spi.NoAutoStart;
/*    */ import ch.qos.logback.core.rolling.helper.ArchiveRemover;
/*    */ import ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @NoAutoStart
/*    */ public class DefaultTimeBasedFileNamingAndTriggeringPolicy<E>
/*    */   extends TimeBasedFileNamingAndTriggeringPolicyBase<E>
/*    */ {
/*    */   public void start() {
/* 33 */     super.start();
/* 34 */     if (!isErrorFree())
/*    */       return; 
/* 36 */     if (this.tbrp.fileNamePattern.hasIntegerTokenCOnverter()) {
/* 37 */       addError("Filename pattern [" + this.tbrp.fileNamePattern + "] contains an integer token converter, i.e. %i, INCOMPATIBLE with this configuration. Remove it.");
/*    */       
/*    */       return;
/*    */     } 
/* 41 */     this.archiveRemover = (ArchiveRemover)new TimeBasedArchiveRemover(this.tbrp.fileNamePattern, this.rc);
/* 42 */     this.archiveRemover.setContext(this.context);
/* 43 */     this.started = true;
/*    */   }
/*    */   
/*    */   public boolean isTriggeringEvent(File paramFile, E paramE) {
/* 47 */     long l = getCurrentTime();
/* 48 */     if (l >= this.nextCheck) {
/* 49 */       Date date = this.dateInCurrentPeriod;
/* 50 */       addInfo("Elapsed period: " + date);
/* 51 */       this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convert(date);
/* 52 */       setDateInCurrentPeriod(l);
/* 53 */       computeNextCheck();
/* 54 */       return true;
/*    */     } 
/* 56 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String toString() {
/* 62 */     return "c.q.l.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\core\rolling\DefaultTimeBasedFileNamingAndTriggeringPolicy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */