/*    */ package oshi.hardware.platform.unix.solaris;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import oshi.annotation.concurrent.ThreadSafe;
/*    */ import oshi.hardware.common.AbstractSensors;
/*    */ import oshi.util.ExecutingCommand;
/*    */ import oshi.util.ParseUtil;
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
/*    */ final class SolarisSensors
/*    */   extends AbstractSensors
/*    */ {
/*    */   public double queryCpuTemperature() {
/* 42 */     double d = 0.0D;
/*    */     
/* 44 */     for (String str : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c temperature-sensor")) {
/* 45 */       if (str.trim().startsWith("Temperature:")) {
/* 46 */         int i = ParseUtil.parseLastInt(str, 0);
/* 47 */         if (i > d) {
/* 48 */           d = i;
/*    */         }
/*    */       } 
/*    */     } 
/*    */     
/* 53 */     if (d > 1000.0D) {
/* 54 */       d /= 1000.0D;
/*    */     }
/* 56 */     return d;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] queryFanSpeeds() {
/* 61 */     ArrayList<Integer> arrayList = new ArrayList();
/*    */     
/* 63 */     for (String str : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c fan")) {
/* 64 */       if (str.trim().startsWith("Speed:")) {
/* 65 */         arrayList.add(Integer.valueOf(ParseUtil.parseLastInt(str, 0)));
/*    */       }
/*    */     } 
/* 68 */     int[] arrayOfInt = new int[arrayList.size()];
/* 69 */     for (byte b = 0; b < arrayList.size(); b++) {
/* 70 */       arrayOfInt[b] = ((Integer)arrayList.get(b)).intValue();
/*    */     }
/* 72 */     return arrayOfInt;
/*    */   }
/*    */ 
/*    */   
/*    */   public double queryCpuVoltage() {
/* 77 */     double d = 0.0D;
/* 78 */     for (String str : ExecutingCommand.runNative("/usr/sbin/prtpicl -v -c voltage-sensor")) {
/* 79 */       if (str.trim().startsWith("Voltage:")) {
/* 80 */         d = ParseUtil.parseDoubleOrDefault(str.replace("Voltage:", "").trim(), 0.0D);
/*    */         break;
/*    */       } 
/*    */     } 
/* 84 */     return d;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */