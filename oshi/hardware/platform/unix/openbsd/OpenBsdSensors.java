/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.common.AbstractSensors;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Triplet;
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
/*     */ @ThreadSafe
/*     */ final class OpenBsdSensors
/*     */   extends AbstractSensors
/*     */ {
/*  45 */   private final Supplier<Triplet<Double, int[], Double>> tempFanVolts = Memoizer.memoize(OpenBsdSensors::querySensors, 
/*  46 */       Memoizer.defaultExpiration());
/*     */ 
/*     */   
/*     */   public double queryCpuTemperature() {
/*  50 */     return ((Double)((Triplet)this.tempFanVolts.get()).getA()).doubleValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] queryFanSpeeds() {
/*  55 */     return (int[])((Triplet)this.tempFanVolts.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public double queryCpuVoltage() {
/*  60 */     return ((Double)((Triplet)this.tempFanVolts.get()).getC()).doubleValue();
/*     */   }
/*     */   
/*     */   private static Triplet<Double, int[], Double> querySensors() {
/*  64 */     double d1 = 0.0D;
/*  65 */     ArrayList<Double> arrayList1 = new ArrayList();
/*  66 */     ArrayList<Double> arrayList2 = new ArrayList();
/*  67 */     ArrayList<Integer> arrayList = new ArrayList();
/*  68 */     for (String str : ExecutingCommand.runNative("systat -ab sensors")) {
/*  69 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*  70 */       if (arrayOfString.length > 1) {
/*  71 */         if (arrayOfString[0].contains("cpu")) {
/*  72 */           if (arrayOfString[0].contains("temp0")) {
/*  73 */             arrayList1.add(Double.valueOf(ParseUtil.parseDoubleOrDefault(arrayOfString[1], Double.NaN))); continue;
/*  74 */           }  if (arrayOfString[0].contains("volt0"))
/*  75 */             d1 = ParseUtil.parseDoubleOrDefault(arrayOfString[1], 0.0D);  continue;
/*     */         } 
/*  77 */         if (arrayOfString[0].contains("temp0")) {
/*  78 */           arrayList2.add(Double.valueOf(ParseUtil.parseDoubleOrDefault(arrayOfString[1], Double.NaN))); continue;
/*  79 */         }  if (arrayOfString[0].contains("fan")) {
/*  80 */           arrayList.add(Integer.valueOf(ParseUtil.parseIntOrDefault(arrayOfString[1], 0)));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  85 */     double d2 = arrayList1.isEmpty() ? listAverage(arrayList2) : listAverage(arrayList1);
/*     */     
/*  87 */     int[] arrayOfInt = new int[arrayList.size()];
/*  88 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/*  89 */       arrayOfInt[b] = ((Integer)arrayList.get(b)).intValue();
/*     */     }
/*  91 */     return new Triplet(Double.valueOf(d2), arrayOfInt, Double.valueOf(d1));
/*     */   }
/*     */   
/*     */   private static double listAverage(List<Double> paramList) {
/*  95 */     double d = 0.0D;
/*  96 */     byte b = 0;
/*  97 */     for (Double double_ : paramList) {
/*  98 */       if (!double_.isNaN()) {
/*  99 */         d += double_.doubleValue();
/* 100 */         b++;
/*     */       } 
/*     */     } 
/* 103 */     return (b > 0) ? (d / b) : 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */