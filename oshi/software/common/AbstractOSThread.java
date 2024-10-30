/*    */ package oshi.software.common;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.os.OSThread;
/*    */ import oshi.util.Memoizer;
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
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public abstract class AbstractOSThread
/*    */   implements OSThread
/*    */ {
/* 40 */   private final Supplier<Double> cumulativeCpuLoad = Memoizer.memoize(this::queryCumulativeCpuLoad, Memoizer.defaultExpiration());
/*    */   
/*    */   private final int owningProcessId;
/*    */   
/*    */   protected AbstractOSThread(int paramInt) {
/* 45 */     this.owningProcessId = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getOwningProcessId() {
/* 50 */     return this.owningProcessId;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getThreadCpuLoadCumulative() {
/* 55 */     return ((Double)this.cumulativeCpuLoad.get()).doubleValue();
/*    */   }
/*    */   
/*    */   private double queryCumulativeCpuLoad() {
/* 59 */     return (getUpTime() > 0.0D) ? ((getKernelTime() + getUserTime()) / getUpTime()) : 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getThreadCpuLoadBetweenTicks(OSThread paramOSThread) {
/* 64 */     if (paramOSThread != null && this.owningProcessId == paramOSThread.getOwningProcessId() && 
/* 65 */       getThreadId() == paramOSThread.getThreadId() && getUpTime() > paramOSThread.getUpTime()) {
/* 66 */       return (getUserTime() - paramOSThread.getUserTime() + getKernelTime() - paramOSThread.getKernelTime()) / (
/* 67 */         getUpTime() - paramOSThread.getUpTime());
/*    */     }
/* 69 */     return getThreadCpuLoadCumulative();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 74 */     return "OSThread [threadId=" + getThreadId() + ", owningProcessId=" + getOwningProcessId() + ", name=" + 
/* 75 */       getName() + ", state=" + getState() + ", kernelTime=" + getKernelTime() + ", userTime=" + 
/* 76 */       getUserTime() + ", upTime=" + getUpTime() + ", startTime=" + getStartTime() + ", startMemoryAddress=0x" + 
/* 77 */       String.format("%x", new Object[] { Long.valueOf(getStartMemoryAddress()) }) + ", contextSwitches=" + 
/* 78 */       getContextSwitches() + ", minorFaults=" + getMinorFaults() + ", majorFaults=" + getMajorFaults() + "]";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractOSThread.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */