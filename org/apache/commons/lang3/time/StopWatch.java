/*     */ package org.apache.commons.lang3.time;
/*     */ 
/*     */ import java.util.Objects;
/*     */ import java.util.concurrent.TimeUnit;
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
/*     */ public class StopWatch
/*     */ {
/*     */   private static final long NANO_2_MILLIS = 1000000L;
/*     */   private final String message;
/*     */   
/*     */   private enum SplitState
/*     */   {
/*  68 */     SPLIT,
/*  69 */     UNSPLIT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private enum State
/*     */   {
/*  77 */     RUNNING
/*     */     {
/*     */       boolean isStarted() {
/*  80 */         return true;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/*  84 */         return false;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/*  88 */         return false;
/*     */       }
/*     */     },
/*  91 */     STOPPED
/*     */     {
/*     */       boolean isStarted() {
/*  94 */         return false;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/*  98 */         return true;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 102 */         return false;
/*     */       }
/*     */     },
/* 105 */     SUSPENDED
/*     */     {
/*     */       boolean isStarted() {
/* 108 */         return true;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/* 112 */         return false;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 116 */         return true;
/*     */       }
/*     */     },
/* 119 */     UNSTARTED
/*     */     {
/*     */       boolean isStarted() {
/* 122 */         return false;
/*     */       }
/*     */       
/*     */       boolean isStopped() {
/* 126 */         return true;
/*     */       }
/*     */       
/*     */       boolean isSuspended() {
/* 130 */         return false;
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isStarted();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isStopped();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     abstract boolean isSuspended();
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
/*     */   public static StopWatch create() {
/* 174 */     return new StopWatch();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static StopWatch createStarted() {
/* 185 */     StopWatch stopWatch = new StopWatch();
/* 186 */     stopWatch.start();
/* 187 */     return stopWatch;
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
/* 200 */   private State runningState = State.UNSTARTED;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 205 */   private SplitState splitState = SplitState.UNSPLIT;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long startTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long startTimeMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long stopTime;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StopWatch() {
/* 230 */     this(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public StopWatch(String paramString) {
/* 241 */     this.message = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatSplitTime() {
/* 251 */     return DurationFormatUtils.formatDurationHMS(getSplitTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String formatTime() {
/* 261 */     return DurationFormatUtils.formatDurationHMS(getTime());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 271 */     return this.message;
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
/*     */   public long getNanoTime() {
/* 288 */     if (this.runningState == State.STOPPED || this.runningState == State.SUSPENDED)
/* 289 */       return this.stopTime - this.startTime; 
/* 290 */     if (this.runningState == State.UNSTARTED)
/* 291 */       return 0L; 
/* 292 */     if (this.runningState == State.RUNNING) {
/* 293 */       return System.nanoTime() - this.startTime;
/*     */     }
/* 295 */     throw new RuntimeException("Illegal running state has occurred.");
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
/*     */   public long getSplitNanoTime() {
/* 314 */     if (this.splitState != SplitState.SPLIT) {
/* 315 */       throw new IllegalStateException("Stopwatch must be split to get the split time. ");
/*     */     }
/* 317 */     return this.stopTime - this.startTime;
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
/*     */   public long getSplitTime() {
/* 336 */     return getSplitNanoTime() / 1000000L;
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
/*     */   public long getStartTime() {
/* 348 */     if (this.runningState == State.UNSTARTED) {
/* 349 */       throw new IllegalStateException("Stopwatch has not been started");
/*     */     }
/*     */     
/* 352 */     return this.startTimeMillis;
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
/*     */   public long getTime() {
/* 368 */     return getNanoTime() / 1000000L;
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
/*     */   public long getTime(TimeUnit paramTimeUnit) {
/* 388 */     return paramTimeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
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
/*     */   public boolean isStarted() {
/* 400 */     return this.runningState.isStarted();
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
/*     */   public boolean isStopped() {
/* 413 */     return this.runningState.isStopped();
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
/*     */   public boolean isSuspended() {
/* 426 */     return this.runningState.isSuspended();
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
/*     */   public void reset() {
/* 439 */     this.runningState = State.UNSTARTED;
/* 440 */     this.splitState = SplitState.UNSPLIT;
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
/*     */   public void resume() {
/* 456 */     if (this.runningState != State.SUSPENDED) {
/* 457 */       throw new IllegalStateException("Stopwatch must be suspended to resume. ");
/*     */     }
/* 459 */     this.startTime += System.nanoTime() - this.stopTime;
/* 460 */     this.runningState = State.RUNNING;
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
/*     */   public void split() {
/* 477 */     if (this.runningState != State.RUNNING) {
/* 478 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 480 */     this.stopTime = System.nanoTime();
/* 481 */     this.splitState = SplitState.SPLIT;
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
/*     */   public void start() {
/* 497 */     if (this.runningState == State.STOPPED) {
/* 498 */       throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
/*     */     }
/* 500 */     if (this.runningState != State.UNSTARTED) {
/* 501 */       throw new IllegalStateException("Stopwatch already started. ");
/*     */     }
/* 503 */     this.startTime = System.nanoTime();
/* 504 */     this.startTimeMillis = System.currentTimeMillis();
/* 505 */     this.runningState = State.RUNNING;
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
/*     */   public void stop() {
/* 521 */     if (this.runningState != State.RUNNING && this.runningState != State.SUSPENDED) {
/* 522 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 524 */     if (this.runningState == State.RUNNING) {
/* 525 */       this.stopTime = System.nanoTime();
/*     */     }
/* 527 */     this.runningState = State.STOPPED;
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
/*     */   public void suspend() {
/* 544 */     if (this.runningState != State.RUNNING) {
/* 545 */       throw new IllegalStateException("Stopwatch must be running to suspend. ");
/*     */     }
/* 547 */     this.stopTime = System.nanoTime();
/* 548 */     this.runningState = State.SUSPENDED;
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
/*     */   public String toSplitString() {
/* 565 */     String str1 = Objects.toString(this.message, "");
/* 566 */     String str2 = formatSplitTime();
/* 567 */     return str1.isEmpty() ? str2 : (str1 + " " + str2);
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
/*     */   public String toString() {
/* 584 */     String str1 = Objects.toString(this.message, "");
/* 585 */     String str2 = formatTime();
/* 586 */     return str1.isEmpty() ? str2 : (str1 + " " + str2);
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
/*     */   public void unsplit() {
/* 603 */     if (this.splitState != SplitState.SPLIT) {
/* 604 */       throw new IllegalStateException("Stopwatch has not been split. ");
/*     */     }
/* 606 */     this.splitState = SplitState.UNSPLIT;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\lang3\time\StopWatch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */