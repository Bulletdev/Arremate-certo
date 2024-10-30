/*    */ package oshi.hardware.platform.unix.freebsd;
/*    */ 
/*    */ import com.sun.jna.Memory;
/*    */ import com.sun.jna.Pointer;
/*    */ import com.sun.jna.platform.unix.LibCAPI;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.common.AbstractSensors;
/*    */ import oshi.jna.platform.unix.freebsd.FreeBsdLibc;
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
/*    */ final class FreeBsdSensors
/*    */   extends AbstractSensors
/*    */ {
/*    */   public double queryCpuTemperature() {
/* 42 */     return queryKldloadCoretemp();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static double queryKldloadCoretemp() {
/* 52 */     String str = "dev.cpu.%d.temperature";
/* 53 */     LibCAPI.size_t.ByReference byReference = new LibCAPI.size_t.ByReference(new LibCAPI.size_t(FreeBsdLibc.INT_SIZE));
/* 54 */     Memory memory = new Memory(byReference.longValue());
/* 55 */     byte b = 0;
/* 56 */     double d = 0.0D;
/* 57 */     while (0 == FreeBsdLibc.INSTANCE.sysctlbyname(String.format(str, new Object[] { Integer.valueOf(b) }), (Pointer)memory, byReference, null, LibCAPI.size_t.ZERO)) {
/* 58 */       d += memory.getInt(0L) / 10.0D - 273.15D;
/* 59 */       b++;
/*    */     } 
/* 61 */     return (b > 0) ? (d / b) : Double.NaN;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] queryFanSpeeds() {
/* 67 */     return new int[0];
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public double queryCpuVoltage() {
/* 73 */     return 0.0D;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */