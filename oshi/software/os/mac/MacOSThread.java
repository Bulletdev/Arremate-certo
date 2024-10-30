/*    */ package oshi.software.os.mac;
/*    */ 
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.common.AbstractOSThread;
/*    */ import oshi.software.os.OSProcess;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public class MacOSThread
/*    */   extends AbstractOSThread
/*    */ {
/*    */   private final int threadId;
/*    */   private final OSProcess.State state;
/*    */   private final long kernelTime;
/*    */   private final long userTime;
/*    */   private final long startTime;
/*    */   private final long upTime;
/*    */   private final int priority;
/*    */   
/*    */   public MacOSThread(int paramInt1, int paramInt2, OSProcess.State paramState, long paramLong1, long paramLong2, long paramLong3, long paramLong4, int paramInt3) {
/* 46 */     super(paramInt1);
/* 47 */     this.threadId = paramInt2;
/* 48 */     this.state = paramState;
/* 49 */     this.kernelTime = paramLong1;
/* 50 */     this.userTime = paramLong2;
/* 51 */     this.startTime = paramLong3;
/* 52 */     this.upTime = paramLong4;
/* 53 */     this.priority = paramInt3;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getThreadId() {
/* 58 */     return this.threadId;
/*    */   }
/*    */ 
/*    */   
/*    */   public OSProcess.State getState() {
/* 63 */     return this.state;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getKernelTime() {
/* 68 */     return this.kernelTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getUserTime() {
/* 73 */     return this.userTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getStartTime() {
/* 78 */     return this.startTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public long getUpTime() {
/* 83 */     return this.upTime;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getPriority() {
/* 88 */     return this.priority;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\mac\MacOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */