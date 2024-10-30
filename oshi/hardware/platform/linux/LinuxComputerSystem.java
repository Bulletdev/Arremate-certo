/*     */ package oshi.hardware.platform.linux;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.linux.Devicetree;
/*     */ import oshi.driver.linux.Dmidecode;
/*     */ import oshi.driver.linux.Lshal;
/*     */ import oshi.driver.linux.Lshw;
/*     */ import oshi.driver.linux.Sysfs;
/*     */ import oshi.driver.linux.proc.CpuInfo;
/*     */ import oshi.hardware.Baseboard;
/*     */ import oshi.hardware.Firmware;
/*     */ import oshi.hardware.common.AbstractComputerSystem;
/*     */ import oshi.util.Memoizer;
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
/*     */ @Immutable
/*     */ final class LinuxComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  48 */   private final Supplier<String> manufacturer = Memoizer.memoize(LinuxComputerSystem::queryManufacturer);
/*     */   
/*  50 */   private final Supplier<String> model = Memoizer.memoize(LinuxComputerSystem::queryModel);
/*     */   
/*  52 */   private final Supplier<String> serialNumber = Memoizer.memoize(LinuxComputerSystem::querySerialNumber);
/*     */   
/*  54 */   private final Supplier<String> uuid = Memoizer.memoize(LinuxComputerSystem::queryUUID);
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  58 */     return this.manufacturer.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  63 */     return this.model.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  68 */     return this.serialNumber.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  73 */     return this.uuid.get();
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  78 */     return (Firmware)new LinuxFirmware();
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  83 */     return (Baseboard)new LinuxBaseboard();
/*     */   }
/*     */   
/*     */   private static String queryManufacturer() {
/*  87 */     String str = null;
/*  88 */     if ((str = Sysfs.querySystemVendor()) == null && (str = CpuInfo.queryCpuManufacturer()) == null) {
/*  89 */       return "unknown";
/*     */     }
/*  91 */     return str;
/*     */   }
/*     */   
/*     */   private static String queryModel() {
/*  95 */     String str = null;
/*  96 */     if ((str = Sysfs.queryProductModel()) == null && (str = Devicetree.queryModel()) == null && (
/*  97 */       str = Lshw.queryModel()) == null) {
/*  98 */       return "unknown";
/*     */     }
/* 100 */     return str;
/*     */   }
/*     */   
/*     */   private static String querySerialNumber() {
/* 104 */     String str = null;
/* 105 */     if ((str = Sysfs.queryProductSerial()) == null && (str = Dmidecode.querySerialNumber()) == null && (
/* 106 */       str = Lshal.querySerialNumber()) == null && (str = Lshw.querySerialNumber()) == null) {
/* 107 */       return "unknown";
/*     */     }
/* 109 */     return str;
/*     */   }
/*     */   
/*     */   private static String queryUUID() {
/* 113 */     String str = null;
/* 114 */     if ((str = Sysfs.queryUUID()) == null && (str = Dmidecode.queryUUID()) == null && (
/* 115 */       str = Lshal.queryUUID()) == null && (str = Lshw.queryUUID()) == null) {
/* 116 */       return "unknown";
/*     */     }
/* 118 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\linux\LinuxComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */