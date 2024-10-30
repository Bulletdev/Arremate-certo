/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.COMException;
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.windows.wmi.MSAcpiThermalZoneTemperature;
/*     */ import oshi.driver.windows.wmi.OhmHardware;
/*     */ import oshi.driver.windows.wmi.OhmSensor;
/*     */ import oshi.driver.windows.wmi.Win32Fan;
/*     */ import oshi.driver.windows.wmi.Win32Processor;
/*     */ import oshi.hardware.common.AbstractSensors;
/*     */ import oshi.util.platform.windows.WmiQueryHandler;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ final class WindowsSensors
/*     */   extends AbstractSensors
/*     */ {
/*  53 */   private static final Logger LOG = LoggerFactory.getLogger(WindowsSensors.class);
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String COM_EXCEPTION_MSG = "COM exception: {}";
/*     */ 
/*     */ 
/*     */   
/*     */   public double queryCpuTemperature() {
/*  62 */     double d = getTempFromOHM();
/*  63 */     if (d > 0.0D) {
/*  64 */       return d;
/*     */     }
/*     */ 
/*     */     
/*  68 */     d = getTempFromWMI();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     return d;
/*     */   }
/*     */   
/*     */   private static double getTempFromOHM() {
/*  77 */     WmiQueryHandler wmiQueryHandler = WmiQueryHandler.createInstance();
/*  78 */     boolean bool = false;
/*     */     try {
/*  80 */       bool = wmiQueryHandler.initCOM();
/*  81 */       WbemcliUtil.WmiResult wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Hardware", "CPU");
/*  82 */       if (wmiResult.getResultCount() > 0) {
/*  83 */         LOG.debug("Found Temperature data in Open Hardware Monitor");
/*  84 */         String str = WmiUtil.getString(wmiResult, (Enum)OhmHardware.IdentifierProperty.IDENTIFIER, 0);
/*  85 */         if (str.length() > 0) {
/*  86 */           WbemcliUtil.WmiResult wmiResult1 = OhmSensor.querySensorValue(wmiQueryHandler, str, "Temperature");
/*  87 */           if (wmiResult1.getResultCount() > 0) {
/*  88 */             double d = 0.0D;
/*  89 */             for (byte b = 0; b < wmiResult1.getResultCount(); b++) {
/*  90 */               d += WmiUtil.getFloat(wmiResult1, (Enum)OhmSensor.ValueProperty.VALUE, b);
/*     */             }
/*  92 */             return d / wmiResult1.getResultCount();
/*     */           } 
/*     */         } 
/*     */       } 
/*  96 */     } catch (COMException cOMException) {
/*  97 */       LOG.warn("COM exception: {}", cOMException.getMessage());
/*     */     } finally {
/*  99 */       if (bool) {
/* 100 */         wmiQueryHandler.unInitCOM();
/*     */       }
/*     */     } 
/* 103 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private static double getTempFromWMI() {
/* 107 */     double d = 0.0D;
/* 108 */     long l = 0L;
/* 109 */     WbemcliUtil.WmiResult wmiResult = MSAcpiThermalZoneTemperature.queryCurrentTemperature();
/* 110 */     if (wmiResult.getResultCount() > 0) {
/* 111 */       LOG.debug("Found Temperature data in WMI");
/* 112 */       l = WmiUtil.getUint32asLong(wmiResult, (Enum)MSAcpiThermalZoneTemperature.TemperatureProperty.CURRENTTEMPERATURE, 0);
/*     */     } 
/* 114 */     if (l > 2732L) {
/* 115 */       d = l / 10.0D - 273.15D;
/* 116 */     } else if (l > 274L) {
/* 117 */       d = l - 273.0D;
/*     */     } 
/* 119 */     return (d < 0.0D) ? 0.0D : d;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] queryFanSpeeds() {
/* 125 */     int[] arrayOfInt = getFansFromOHM();
/* 126 */     if (arrayOfInt.length > 0) {
/* 127 */       return arrayOfInt;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 132 */     arrayOfInt = getFansFromWMI();
/* 133 */     if (arrayOfInt.length > 0) {
/* 134 */       return arrayOfInt;
/*     */     }
/*     */ 
/*     */     
/* 138 */     return new int[0];
/*     */   }
/*     */   
/*     */   private static int[] getFansFromOHM() {
/* 142 */     WmiQueryHandler wmiQueryHandler = WmiQueryHandler.createInstance();
/* 143 */     boolean bool = false;
/*     */     try {
/* 145 */       bool = wmiQueryHandler.initCOM();
/* 146 */       WbemcliUtil.WmiResult wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Hardware", "CPU");
/* 147 */       if (wmiResult.getResultCount() > 0) {
/* 148 */         LOG.debug("Found Fan data in Open Hardware Monitor");
/* 149 */         String str = WmiUtil.getString(wmiResult, (Enum)OhmHardware.IdentifierProperty.IDENTIFIER, 0);
/* 150 */         if (str.length() > 0) {
/* 151 */           WbemcliUtil.WmiResult wmiResult1 = OhmSensor.querySensorValue(wmiQueryHandler, str, "Fan");
/* 152 */           if (wmiResult1.getResultCount() > 0) {
/* 153 */             int[] arrayOfInt = new int[wmiResult1.getResultCount()];
/* 154 */             for (byte b = 0; b < wmiResult1.getResultCount(); b++) {
/* 155 */               arrayOfInt[b] = (int)WmiUtil.getFloat(wmiResult1, (Enum)OhmSensor.ValueProperty.VALUE, b);
/*     */             }
/* 157 */             return arrayOfInt;
/*     */           } 
/*     */         } 
/*     */       } 
/* 161 */     } catch (COMException cOMException) {
/* 162 */       LOG.warn("COM exception: {}", cOMException.getMessage());
/*     */     } finally {
/* 164 */       if (bool) {
/* 165 */         wmiQueryHandler.unInitCOM();
/*     */       }
/*     */     } 
/* 168 */     return new int[0];
/*     */   }
/*     */   
/*     */   private static int[] getFansFromWMI() {
/* 172 */     WbemcliUtil.WmiResult wmiResult = Win32Fan.querySpeed();
/* 173 */     if (wmiResult.getResultCount() > 1) {
/* 174 */       LOG.debug("Found Fan data in WMI");
/* 175 */       int[] arrayOfInt = new int[wmiResult.getResultCount()];
/* 176 */       for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 177 */         arrayOfInt[b] = (int)WmiUtil.getUint64(wmiResult, (Enum)Win32Fan.SpeedProperty.DESIREDSPEED, b);
/*     */       }
/* 179 */       return arrayOfInt;
/*     */     } 
/* 181 */     return new int[0];
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public double queryCpuVoltage() {
/* 187 */     double d = getVoltsFromOHM();
/* 188 */     if (d > 0.0D) {
/* 189 */       return d;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 194 */     d = getVoltsFromWMI();
/*     */     
/* 196 */     return d;
/*     */   }
/*     */   
/*     */   private static double getVoltsFromOHM() {
/* 200 */     WmiQueryHandler wmiQueryHandler = WmiQueryHandler.createInstance();
/* 201 */     boolean bool = false;
/*     */     try {
/* 203 */       bool = wmiQueryHandler.initCOM();
/* 204 */       WbemcliUtil.WmiResult wmiResult = OhmHardware.queryHwIdentifier(wmiQueryHandler, "Sensor", "Voltage");
/* 205 */       if (wmiResult.getResultCount() > 0) {
/* 206 */         LOG.debug("Found Voltage data in Open Hardware Monitor");
/*     */         
/* 208 */         String str = null;
/* 209 */         for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 210 */           String str1 = WmiUtil.getString(wmiResult, (Enum)OhmHardware.IdentifierProperty.IDENTIFIER, b);
/* 211 */           if (str1.toLowerCase().contains("cpu")) {
/* 212 */             str = str1;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 217 */         if (str == null) {
/* 218 */           str = WmiUtil.getString(wmiResult, (Enum)OhmHardware.IdentifierProperty.IDENTIFIER, 0);
/*     */         }
/*     */         
/* 221 */         WbemcliUtil.WmiResult wmiResult1 = OhmSensor.querySensorValue(wmiQueryHandler, str, "Voltage");
/* 222 */         if (wmiResult1.getResultCount() > 0) {
/* 223 */           return WmiUtil.getFloat(wmiResult1, (Enum)OhmSensor.ValueProperty.VALUE, 0);
/*     */         }
/*     */       } 
/* 226 */     } catch (COMException cOMException) {
/* 227 */       LOG.warn("COM exception: {}", cOMException.getMessage());
/*     */     } finally {
/* 229 */       if (bool) {
/* 230 */         wmiQueryHandler.unInitCOM();
/*     */       }
/*     */     } 
/* 233 */     return 0.0D;
/*     */   }
/*     */   
/*     */   private static double getVoltsFromWMI() {
/* 237 */     WbemcliUtil.WmiResult wmiResult = Win32Processor.queryVoltage();
/* 238 */     if (wmiResult.getResultCount() > 1) {
/* 239 */       LOG.debug("Found Voltage data in WMI");
/* 240 */       int i = WmiUtil.getUint16(wmiResult, (Enum)Win32Processor.VoltProperty.CURRENTVOLTAGE, 0);
/*     */ 
/*     */ 
/*     */       
/* 244 */       if (i > 0) {
/* 245 */         if ((i & 0x80) == 0) {
/* 246 */           i = WmiUtil.getUint32(wmiResult, (Enum)Win32Processor.VoltProperty.VOLTAGECAPS, 0);
/*     */           
/* 248 */           if ((i & 0x1) > 0)
/* 249 */             return 5.0D; 
/* 250 */           if ((i & 0x2) > 0)
/* 251 */             return 3.3D; 
/* 252 */           if ((i & 0x4) > 0) {
/* 253 */             return 2.9D;
/*     */           }
/*     */         } else {
/*     */           
/* 257 */           return (i & 0x7F) / 10.0D;
/*     */         } 
/*     */       }
/*     */     } 
/* 261 */     return 0.0D;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsSensors.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */