/*    */ package oshi.hardware.common;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.Sensors;
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
/*    */ public abstract class AbstractSensors
/*    */   implements Sensors
/*    */ {
/* 41 */   private final Supplier<Double> cpuTemperature = Memoizer.memoize(this::queryCpuTemperature, Memoizer.defaultExpiration());
/*    */   
/* 43 */   private final Supplier<int[]> fanSpeeds = Memoizer.memoize(this::queryFanSpeeds, Memoizer.defaultExpiration());
/*    */   
/* 45 */   private final Supplier<Double> cpuVoltage = Memoizer.memoize(this::queryCpuVoltage, Memoizer.defaultExpiration());
/*    */ 
/*    */   
/*    */   public double getCpuTemperature() {
/* 49 */     return ((Double)this.cpuTemperature.get()).doubleValue();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract double queryCpuTemperature();
/*    */   
/*    */   public int[] getFanSpeeds() {
/* 56 */     return this.fanSpeeds.get();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract int[] queryFanSpeeds();
/*    */   
/*    */   public double getCpuVoltage() {
/* 63 */     return ((Double)this.cpuVoltage.get()).doubleValue();
/*    */   }
/*    */ 
/*    */   
/*    */   protected abstract double queryCpuVoltage();
/*    */   
/*    */   public String toString() {
/* 70 */     StringBuilder stringBuilder = new StringBuilder();
/* 71 */     stringBuilder.append("CPU Temperature=").append(getCpuTemperature()).append("°C, ");
/* 72 */     stringBuilder.append("Fan Speeds=").append(Arrays.toString(getFanSpeeds())).append(", ");
/* 73 */     stringBuilder.append("CPU Voltage=").append(getCpuVoltage());
/* 74 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */