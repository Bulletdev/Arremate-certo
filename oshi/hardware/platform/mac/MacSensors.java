/*    */ package oshi.hardware.platform.mac;
/*    */ 
/*    */ import com.sun.jna.platform.mac.IOKit;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.common.AbstractSensors;
/*    */ import oshi.util.platform.mac.SmcUtil;
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
/*    */ final class MacSensors
/*    */   extends AbstractSensors
/*    */ {
/* 39 */   private int numFans = 0;
/*    */ 
/*    */   
/*    */   public double queryCpuTemperature() {
/* 43 */     IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
/* 44 */     double d = SmcUtil.smcGetFloat(iOConnect, "TC0P");
/* 45 */     SmcUtil.smcClose(iOConnect);
/* 46 */     if (d > 0.0D) {
/* 47 */       return d;
/*    */     }
/* 49 */     return 0.0D;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] queryFanSpeeds() {
/* 55 */     IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
/* 56 */     if (this.numFans == 0) {
/* 57 */       this.numFans = (int)SmcUtil.smcGetLong(iOConnect, "FNum");
/*    */     }
/* 59 */     int[] arrayOfInt = new int[this.numFans];
/* 60 */     for (byte b = 0; b < this.numFans; b++) {
/* 61 */       arrayOfInt[b] = (int)SmcUtil.smcGetFloat(iOConnect, String.format("F%dAc", new Object[] { Integer.valueOf(b) }));
/*    */     } 
/* 63 */     SmcUtil.smcClose(iOConnect);
/* 64 */     return arrayOfInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public double queryCpuVoltage() {
/* 69 */     IOKit.IOConnect iOConnect = SmcUtil.smcOpen();
/* 70 */     double d = SmcUtil.smcGetFloat(iOConnect, "VC0C") / 1000.0D;
/* 71 */     SmcUtil.smcClose(iOConnect);
/* 72 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */