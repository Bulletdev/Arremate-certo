/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.IOException;
/*     */ import java.nio.file.Paths;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.common.AbstractSensors;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
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
/*     */ final class LinuxSensors
/*     */   extends AbstractSensors
/*     */ {
/*     */   private static final String TEMP = "temp";
/*     */   private static final String FAN = "fan";
/*     */   private static final String VOLTAGE = "in";
/*  51 */   private static final String[] SENSORS = new String[] { "temp", "fan", "in" };
/*     */   
/*     */   private static final String HWMON = "hwmon";
/*     */   
/*     */   private static final String HWMON_PATH = "/sys/class/hwmon/hwmon";
/*     */   
/*     */   private static final String THERMAL_ZONE = "thermal_zone";
/*     */   
/*     */   private static final String THERMAL_ZONE_PATH = "/sys/class/thermal/thermal_zone";
/*     */   
/*  61 */   private static final boolean IS_PI = (queryCpuTemperatureFromVcGenCmd() > 0.0D);
/*     */ 
/*     */   
/*  64 */   private final Map<String, String> sensorsMap = new HashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LinuxSensors() {
/*  72 */     if (!IS_PI) {
/*  73 */       populateSensorsMapFromHwmon();
/*     */       
/*  75 */       if (!this.sensorsMap.containsKey("temp")) {
/*  76 */         populateSensorsMapFromThermalZone();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void populateSensorsMapFromHwmon() {
/*  86 */     for (String str1 : SENSORS) {
/*     */       
/*  88 */       String str2 = str1;
/*     */       
/*  90 */       getSensorFilesFromPath("/sys/class/hwmon/hwmon", str1, paramFile -> {
/*     */             try {
/*  92 */               return (paramFile.getName().startsWith(paramString) && paramFile.getName().endsWith("_input") && FileUtil.getIntFromFile(paramFile.getCanonicalPath()) > 0);
/*     */             }
/*  94 */             catch (IOException iOException) {
/*     */               return false;
/*     */             } 
/*     */           });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void populateSensorsMapFromThermalZone() {
/* 106 */     getSensorFilesFromPath("/sys/class/thermal/thermal_zone", "temp", paramFile -> paramFile.getName().equals("temp"));
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
/*     */   private void getSensorFilesFromPath(String paramString1, String paramString2, FileFilter paramFileFilter) {
/* 120 */     byte b = 0;
/* 121 */     while (Paths.get(paramString1 + b, new String[0]).toFile().isDirectory()) {
/* 122 */       String str = paramString1 + b;
/* 123 */       File file = new File(str);
/* 124 */       File[] arrayOfFile = file.listFiles(paramFileFilter);
/* 125 */       if (arrayOfFile != null && arrayOfFile.length > 0) {
/* 126 */         this.sensorsMap.put(paramString2, String.format("%s/%s", new Object[] { str, paramString2 }));
/*     */       }
/* 128 */       b++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public double queryCpuTemperature() {
/* 134 */     if (IS_PI) {
/* 135 */       return queryCpuTemperatureFromVcGenCmd();
/*     */     }
/* 137 */     String str = this.sensorsMap.get("temp");
/* 138 */     if (str != null) {
/* 139 */       long l = 0L;
/* 140 */       if (str.contains("hwmon")) {
/*     */         
/* 142 */         l = FileUtil.getLongFromFile(String.format("%s1_input", new Object[] { str }));
/*     */         
/* 144 */         if (l > 0L) {
/* 145 */           return l / 1000.0D;
/*     */         }
/*     */ 
/*     */         
/* 149 */         long l1 = 0L;
/* 150 */         byte b1 = 0;
/* 151 */         for (byte b2 = 2; b2 <= 6; b2++) {
/* 152 */           l = FileUtil.getLongFromFile(String.format("%s%d_input", new Object[] { str, Integer.valueOf(b2) }));
/* 153 */           if (l > 0L) {
/* 154 */             l1 += l;
/* 155 */             b1++;
/*     */           } 
/*     */         } 
/* 158 */         if (b1 > 0) {
/* 159 */           return l1 / b1 * 1000.0D;
/*     */         }
/* 161 */       } else if (str.contains("thermal_zone")) {
/*     */         
/* 163 */         l = FileUtil.getLongFromFile(str);
/*     */         
/* 165 */         if (l > 0L) {
/* 166 */           return l / 1000.0D;
/*     */         }
/*     */       } 
/*     */     } 
/* 170 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static double queryCpuTemperatureFromVcGenCmd() {
/* 179 */     String str = ExecutingCommand.getFirstAnswer("vcgencmd measure_temp");
/*     */     
/* 181 */     if (str.startsWith("temp=")) {
/* 182 */       return ParseUtil.parseDoubleOrDefault(str.replaceAll("[^\\d|\\.]+", ""), 0.0D);
/*     */     }
/* 184 */     return 0.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public int[] queryFanSpeeds() {
/* 189 */     if (!IS_PI) {
/* 190 */       String str = this.sensorsMap.get("fan");
/* 191 */       if (str != null) {
/* 192 */         ArrayList<Integer> arrayList = new ArrayList();
/* 193 */         byte b1 = 1;
/*     */         
/* 195 */         String str1 = String.format("%s%d_input", new Object[] { str, Integer.valueOf(b1) });
/* 196 */         while ((new File(str1)).exists()) {
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 201 */           arrayList.add(Integer.valueOf(FileUtil.getIntFromFile(str1)));
/*     */           
/* 203 */           b1++;
/*     */         } 
/* 205 */         int[] arrayOfInt = new int[arrayList.size()];
/* 206 */         for (byte b2 = 0; b2 < arrayList.size(); b2++) {
/* 207 */           arrayOfInt[b2] = ((Integer)arrayList.get(b2)).intValue();
/*     */         }
/* 209 */         return arrayOfInt;
/*     */       } 
/*     */     } 
/* 212 */     return new int[0];
/*     */   }
/*     */ 
/*     */   
/*     */   public double queryCpuVoltage() {
/* 217 */     if (IS_PI) {
/* 218 */       return queryCpuVoltageFromVcGenCmd();
/*     */     }
/* 220 */     String str = this.sensorsMap.get("in");
/* 221 */     if (str != null)
/*     */     {
/* 223 */       return FileUtil.getIntFromFile(String.format("%s1_input", new Object[] { str })) / 1000.0D;
/*     */     }
/* 225 */     return 0.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static double queryCpuVoltageFromVcGenCmd() {
/* 235 */     String str = ExecutingCommand.getFirstAnswer("vcgencmd measure_volts core");
/*     */     
/* 237 */     if (str.startsWith("volt=")) {
/* 238 */       return ParseUtil.parseDoubleOrDefault(str.replaceAll("[^\\d|\\.]+", ""), 0.0D);
/*     */     }
/* 240 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */