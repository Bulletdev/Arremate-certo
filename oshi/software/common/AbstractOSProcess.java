/*    */ package oshi.software.common;
/*    */ 
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.software.os.OSProcess;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ @ThreadSafe
/*    */ public abstract class AbstractOSProcess
/*    */   implements OSProcess
/*    */ {
/* 43 */   private final Supplier<Double> cumulativeCpuLoad = Memoizer.memoize(this::queryCumulativeCpuLoad, Memoizer.defaultExpiration());
/*    */   
/*    */   private int processID;
/*    */   
/*    */   protected AbstractOSProcess(int paramInt) {
/* 48 */     this.processID = paramInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getProcessID() {
/* 53 */     return this.processID;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getProcessCpuLoadCumulative() {
/* 58 */     return ((Double)this.cumulativeCpuLoad.get()).doubleValue();
/*    */   }
/*    */   
/*    */   private double queryCumulativeCpuLoad() {
/* 62 */     return (getUpTime() > 0.0D) ? ((getKernelTime() + getUserTime()) / getUpTime()) : 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getProcessCpuLoadBetweenTicks(OSProcess paramOSProcess) {
/* 67 */     if (paramOSProcess != null && this.processID == paramOSProcess.getProcessID() && 
/* 68 */       getUpTime() > paramOSProcess.getUpTime()) {
/* 69 */       return (getUserTime() - paramOSProcess.getUserTime() + getKernelTime() - paramOSProcess.getKernelTime()) / (
/* 70 */         getUpTime() - paramOSProcess.getUpTime());
/*    */     }
/* 72 */     return getProcessCpuLoadCumulative();
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 77 */     StringBuilder stringBuilder = new StringBuilder("OSProcess@");
/* 78 */     stringBuilder.append(Integer.toHexString(hashCode()));
/* 79 */     stringBuilder.append("[processID=").append(this.processID);
/* 80 */     stringBuilder.append(", name=").append(getName()).append(']');
/* 81 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractOSProcess.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */