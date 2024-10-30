/*     */ package oshi.hardware.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.driver.windows.wmi.Win32Bios;
/*     */ import oshi.driver.windows.wmi.Win32ComputerSystem;
/*     */ import oshi.driver.windows.wmi.Win32ComputerSystemProduct;
/*     */ import oshi.hardware.Baseboard;
/*     */ import oshi.hardware.Firmware;
/*     */ import oshi.hardware.common.AbstractComputerSystem;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.platform.windows.WmiUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ @Immutable
/*     */ final class WindowsComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  53 */   private final Supplier<Pair<String, String>> manufacturerModel = Memoizer.memoize(WindowsComputerSystem::queryManufacturerModel);
/*     */   
/*  55 */   private final Supplier<Pair<String, String>> serialNumberUUID = Memoizer.memoize(WindowsComputerSystem::querySystemSerialNumberUUID);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  60 */     return (String)((Pair)this.manufacturerModel.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  65 */     return (String)((Pair)this.manufacturerModel.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  70 */     return (String)((Pair)this.serialNumberUUID.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  75 */     return (String)((Pair)this.serialNumberUUID.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  80 */     return (Firmware)new WindowsFirmware();
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  85 */     return (Baseboard)new WindowsBaseboard();
/*     */   }
/*     */   
/*     */   private static Pair<String, String> queryManufacturerModel() {
/*  89 */     String str1 = null;
/*  90 */     String str2 = null;
/*  91 */     WbemcliUtil.WmiResult wmiResult = Win32ComputerSystem.queryComputerSystem();
/*  92 */     if (wmiResult.getResultCount() > 0) {
/*  93 */       str1 = WmiUtil.getString(wmiResult, (Enum)Win32ComputerSystem.ComputerSystemProperty.MANUFACTURER, 0);
/*  94 */       str2 = WmiUtil.getString(wmiResult, (Enum)Win32ComputerSystem.ComputerSystemProperty.MODEL, 0);
/*     */     } 
/*  96 */     return new Pair(Util.isBlank(str1) ? "unknown" : str1, 
/*  97 */         Util.isBlank(str2) ? "unknown" : str2);
/*     */   }
/*     */   
/*     */   private static Pair<String, String> querySystemSerialNumberUUID() {
/* 101 */     String str1 = null;
/* 102 */     String str2 = null;
/*     */     
/* 104 */     WbemcliUtil.WmiResult wmiResult = Win32ComputerSystemProduct.queryIdentifyingNumberUUID();
/* 105 */     if (wmiResult.getResultCount() > 0) {
/* 106 */       str1 = WmiUtil.getString(wmiResult, (Enum)Win32ComputerSystemProduct.ComputerSystemProductProperty.IDENTIFYINGNUMBER, 0);
/*     */       
/* 108 */       str2 = WmiUtil.getString(wmiResult, (Enum)Win32ComputerSystemProduct.ComputerSystemProductProperty.UUID, 0);
/*     */     } 
/* 110 */     if (Util.isBlank(str1)) {
/* 111 */       str1 = querySerialFromBios();
/*     */     }
/* 113 */     if (Util.isBlank(str1)) {
/* 114 */       str1 = "unknown";
/*     */     }
/* 116 */     if (Util.isBlank(str2)) {
/* 117 */       str2 = "unknown";
/*     */     }
/* 119 */     return new Pair(str1, str2);
/*     */   }
/*     */   
/*     */   private static String querySerialFromBios() {
/* 123 */     WbemcliUtil.WmiResult wmiResult = Win32Bios.querySerialNumber();
/* 124 */     if (wmiResult.getResultCount() > 0) {
/* 125 */       return WmiUtil.getString(wmiResult, (Enum)Win32Bios.BiosSerialProperty.SERIALNUMBER, 0);
/*     */     }
/* 127 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\windows\WindowsComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */