/*    */ package oshi.hardware.platform.unix.aix;
/*    */ 
/*    */ import java.util.List;
/*    */ import java.util.function.Supplier;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.common.AbstractSensors;
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
/*    */ final class AixSensors
/*    */   extends AbstractSensors
/*    */ {
/*    */   private final Supplier<List<String>> lscfg;
/*    */   
/*    */   AixSensors(Supplier<List<String>> paramSupplier) {
/* 41 */     this.lscfg = paramSupplier;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double queryCpuTemperature() {
/* 47 */     return 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] queryFanSpeeds() {
/* 54 */     byte b = 0;
/* 55 */     for (String str : this.lscfg.get()) {
/* 56 */       if (str.contains("Air Mover")) {
/* 57 */         b++;
/*    */       }
/*    */     } 
/* 60 */     return new int[b];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double queryCpuVoltage() {
/* 66 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */