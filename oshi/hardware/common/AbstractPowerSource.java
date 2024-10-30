/*     */ package oshi.hardware.common;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import java.time.LocalDate;
/*     */ import java.util.List;
/*     */ import oshi.PlatformEnum;
/*     */ import oshi.SystemInfo;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.PowerSource;
/*     */ import oshi.hardware.platform.linux.LinuxPowerSource;
/*     */ import oshi.hardware.platform.mac.MacPowerSource;
/*     */ import oshi.hardware.platform.unix.aix.AixPowerSource;
/*     */ import oshi.hardware.platform.unix.freebsd.FreeBsdPowerSource;
/*     */ import oshi.hardware.platform.unix.solaris.SolarisPowerSource;
/*     */ import oshi.hardware.platform.windows.WindowsPowerSource;
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
/*     */ public abstract class AbstractPowerSource
/*     */   implements PowerSource
/*     */ {
/*     */   private String name;
/*     */   private String deviceName;
/*     */   private double remainingCapacityPercent;
/*     */   private double timeRemainingEstimated;
/*     */   private double timeRemainingInstant;
/*     */   private double powerUsageRate;
/*     */   private double voltage;
/*     */   private double amperage;
/*     */   private boolean powerOnLine;
/*     */   private boolean charging;
/*     */   private boolean discharging;
/*     */   private PowerSource.CapacityUnits capacityUnits;
/*     */   private int currentCapacity;
/*     */   private int maxCapacity;
/*     */   private int designCapacity;
/*     */   private int cycleCount;
/*     */   private String chemistry;
/*     */   private LocalDate manufactureDate;
/*     */   private String manufacturer;
/*     */   private String serialNumber;
/*     */   private double temperature;
/*     */   
/*     */   protected AbstractPowerSource(String paramString1, String paramString2, double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4, double paramDouble5, double paramDouble6, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, PowerSource.CapacityUnits paramCapacityUnits, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString3, LocalDate paramLocalDate, String paramString4, String paramString5, double paramDouble7) {
/*  76 */     this.name = paramString1;
/*  77 */     this.deviceName = paramString2;
/*  78 */     this.remainingCapacityPercent = paramDouble1;
/*  79 */     this.timeRemainingEstimated = paramDouble2;
/*  80 */     this.timeRemainingInstant = paramDouble3;
/*  81 */     this.powerUsageRate = paramDouble4;
/*  82 */     this.voltage = paramDouble5;
/*  83 */     this.amperage = paramDouble6;
/*  84 */     this.powerOnLine = paramBoolean1;
/*  85 */     this.charging = paramBoolean2;
/*  86 */     this.discharging = paramBoolean3;
/*  87 */     this.capacityUnits = paramCapacityUnits;
/*  88 */     this.currentCapacity = paramInt1;
/*  89 */     this.maxCapacity = paramInt2;
/*  90 */     this.designCapacity = paramInt3;
/*  91 */     this.cycleCount = paramInt4;
/*  92 */     this.chemistry = paramString3;
/*  93 */     this.manufactureDate = paramLocalDate;
/*  94 */     this.manufacturer = paramString4;
/*  95 */     this.serialNumber = paramString5;
/*  96 */     this.temperature = paramDouble7;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 101 */     return this.name;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDeviceName() {
/* 106 */     return this.deviceName;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getRemainingCapacityPercent() {
/* 111 */     return this.remainingCapacityPercent;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getTimeRemainingEstimated() {
/* 116 */     return this.timeRemainingEstimated;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getTimeRemainingInstant() {
/* 121 */     return this.timeRemainingInstant;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getPowerUsageRate() {
/* 126 */     return this.powerUsageRate;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getVoltage() {
/* 131 */     return this.voltage;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getAmperage() {
/* 136 */     return this.amperage;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isPowerOnLine() {
/* 141 */     return this.powerOnLine;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCharging() {
/* 146 */     return this.charging;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDischarging() {
/* 151 */     return this.discharging;
/*     */   }
/*     */ 
/*     */   
/*     */   public PowerSource.CapacityUnits getCapacityUnits() {
/* 156 */     return this.capacityUnits;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCurrentCapacity() {
/* 161 */     return this.currentCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMaxCapacity() {
/* 166 */     return this.maxCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDesignCapacity() {
/* 171 */     return this.designCapacity;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCycleCount() {
/* 176 */     return this.cycleCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getChemistry() {
/* 181 */     return this.chemistry;
/*     */   }
/*     */ 
/*     */   
/*     */   public LocalDate getManufactureDate() {
/* 186 */     return this.manufactureDate;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/* 191 */     return this.manufacturer;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/* 196 */     return this.serialNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public double getTemperature() {
/* 201 */     return this.temperature;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean updateAttributes() {
/* 206 */     List<PowerSource> list = getPowerSources();
/* 207 */     for (PowerSource powerSource : list) {
/* 208 */       if (powerSource.getName().equals(this.name)) {
/* 209 */         this.name = powerSource.getName();
/* 210 */         this.deviceName = powerSource.getDeviceName();
/* 211 */         this.remainingCapacityPercent = powerSource.getRemainingCapacityPercent();
/* 212 */         this.timeRemainingEstimated = powerSource.getTimeRemainingEstimated();
/* 213 */         this.timeRemainingInstant = powerSource.getTimeRemainingInstant();
/* 214 */         this.powerUsageRate = powerSource.getPowerUsageRate();
/* 215 */         this.voltage = powerSource.getVoltage();
/* 216 */         this.amperage = powerSource.getAmperage();
/* 217 */         this.powerOnLine = powerSource.isPowerOnLine();
/* 218 */         this.charging = powerSource.isCharging();
/* 219 */         this.discharging = powerSource.isDischarging();
/* 220 */         this.capacityUnits = powerSource.getCapacityUnits();
/* 221 */         this.currentCapacity = powerSource.getCurrentCapacity();
/* 222 */         this.maxCapacity = powerSource.getMaxCapacity();
/* 223 */         this.designCapacity = powerSource.getDesignCapacity();
/* 224 */         this.cycleCount = powerSource.getCycleCount();
/* 225 */         this.chemistry = powerSource.getChemistry();
/* 226 */         this.manufactureDate = powerSource.getManufactureDate();
/* 227 */         this.manufacturer = powerSource.getManufacturer();
/* 228 */         this.serialNumber = powerSource.getSerialNumber();
/* 229 */         this.temperature = powerSource.getTemperature();
/* 230 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 234 */     return false;
/*     */   }
/*     */   
/*     */   private static List<PowerSource> getPowerSources() {
/* 238 */     switch (SystemInfo.getCurrentPlatform()) {
/*     */       case WINDOWS:
/* 240 */         return WindowsPowerSource.getPowerSources();
/*     */       case MACOS:
/* 242 */         return MacPowerSource.getPowerSources();
/*     */       case LINUX:
/* 244 */         return LinuxPowerSource.getPowerSources();
/*     */       case SOLARIS:
/* 246 */         return SolarisPowerSource.getPowerSources();
/*     */       case FREEBSD:
/* 248 */         return FreeBsdPowerSource.getPowerSources();
/*     */       case AIX:
/* 250 */         return AixPowerSource.getPowerSources();
/*     */     } 
/* 252 */     throw new UnsupportedOperationException("Operating system not supported: " + Platform.getOSType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 258 */     StringBuilder stringBuilder = new StringBuilder();
/* 259 */     stringBuilder.append("Name: ").append(getName()).append(", ");
/* 260 */     stringBuilder.append("Device Name: ").append(getDeviceName()).append(",\n ");
/* 261 */     stringBuilder.append("RemainingCapacityPercent: ").append(getRemainingCapacityPercent() * 100.0D).append("%, ");
/* 262 */     stringBuilder.append("Time Remaining: ").append(formatTimeRemaining(getTimeRemainingEstimated())).append(", ");
/* 263 */     stringBuilder.append("Time Remaining Instant: ").append(formatTimeRemaining(getTimeRemainingInstant())).append(",\n ");
/* 264 */     stringBuilder.append("Power Usage Rate: ").append(getPowerUsageRate()).append("mW, ");
/* 265 */     stringBuilder.append("Voltage: ");
/* 266 */     if (getVoltage() > 0.0D) {
/* 267 */       stringBuilder.append(getVoltage()).append("V, ");
/*     */     } else {
/* 269 */       stringBuilder.append("unknown");
/*     */     } 
/* 271 */     stringBuilder.append("Amperage: ").append(getAmperage()).append("mA,\n ");
/* 272 */     stringBuilder.append("Power OnLine: ").append(isPowerOnLine()).append(", ");
/* 273 */     stringBuilder.append("Charging: ").append(isCharging()).append(", ");
/* 274 */     stringBuilder.append("Discharging: ").append(isDischarging()).append(",\n ");
/* 275 */     stringBuilder.append("Capacity Units: ").append(getCapacityUnits()).append(", ");
/* 276 */     stringBuilder.append("Current Capacity: ").append(getCurrentCapacity()).append(", ");
/* 277 */     stringBuilder.append("Max Capacity: ").append(getMaxCapacity()).append(", ");
/* 278 */     stringBuilder.append("Design Capacity: ").append(getDesignCapacity()).append(",\n ");
/* 279 */     stringBuilder.append("Cycle Count: ").append(getCycleCount()).append(", ");
/* 280 */     stringBuilder.append("Chemistry: ").append(getChemistry()).append(", ");
/* 281 */     stringBuilder.append("Manufacture Date: ").append((getManufactureDate() != null) ? getManufactureDate() : "unknown")
/* 282 */       .append(", ");
/* 283 */     stringBuilder.append("Manufacturer: ").append(getManufacturer()).append(",\n ");
/* 284 */     stringBuilder.append("SerialNumber: ").append(getSerialNumber()).append(", ");
/* 285 */     stringBuilder.append("Temperature: ");
/* 286 */     if (getTemperature() > 0.0D) {
/* 287 */       stringBuilder.append(getTemperature()).append("°C");
/*     */     } else {
/* 289 */       stringBuilder.append("unknown");
/*     */     } 
/* 291 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String formatTimeRemaining(double paramDouble) {
/*     */     String str;
/* 303 */     if (paramDouble < -1.5D) {
/* 304 */       str = "Charging";
/* 305 */     } else if (paramDouble < 0.0D) {
/* 306 */       str = "Unknown";
/*     */     } else {
/* 308 */       int i = (int)(paramDouble / 3600.0D);
/* 309 */       int j = (int)(paramDouble % 3600.0D / 60.0D);
/* 310 */       str = String.format("%d:%02d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
/*     */     } 
/* 312 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\common\AbstractPowerSource.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */