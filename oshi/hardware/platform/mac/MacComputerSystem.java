/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.Baseboard;
/*     */ import oshi.hardware.Firmware;
/*     */ import oshi.hardware.common.AbstractComputerSystem;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.tuples.Quartet;
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
/*     */ final class MacComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  49 */   private final Supplier<Quartet<String, String, String, String>> manufacturerModelSerialUUID = Memoizer.memoize(MacComputerSystem::platformExpert);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  54 */     return (String)((Quartet)this.manufacturerModelSerialUUID.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  59 */     return (String)((Quartet)this.manufacturerModelSerialUUID.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  64 */     return (String)((Quartet)this.manufacturerModelSerialUUID.get()).getC();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  69 */     return (String)((Quartet)this.manufacturerModelSerialUUID.get()).getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  74 */     return (Firmware)new MacFirmware();
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  79 */     return (Baseboard)new MacBaseboard();
/*     */   }
/*     */   
/*     */   private static Quartet<String, String, String, String> platformExpert() {
/*  83 */     String str1 = null;
/*  84 */     String str2 = null;
/*  85 */     String str3 = null;
/*  86 */     String str4 = null;
/*  87 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
/*  88 */     if (iOService != null) {
/*  89 */       byte[] arrayOfByte = iOService.getByteArrayProperty("manufacturer");
/*  90 */       if (arrayOfByte != null) {
/*  91 */         str1 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/*  93 */       arrayOfByte = iOService.getByteArrayProperty("model");
/*  94 */       if (arrayOfByte != null) {
/*  95 */         str2 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */       }
/*  97 */       str3 = iOService.getStringProperty("IOPlatformSerialNumber");
/*  98 */       str4 = iOService.getStringProperty("IOPlatformUUID");
/*  99 */       iOService.release();
/*     */     } 
/* 101 */     return new Quartet(Util.isBlank(str1) ? "Apple Inc." : str1, 
/* 102 */         Util.isBlank(str2) ? "unknown" : str2, 
/* 103 */         Util.isBlank(str3) ? "unknown" : str3, 
/* 104 */         Util.isBlank(str4) ? "unknown" : str4);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */