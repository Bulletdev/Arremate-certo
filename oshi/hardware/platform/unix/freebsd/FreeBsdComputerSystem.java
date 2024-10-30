/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.Baseboard;
/*     */ import oshi.hardware.Firmware;
/*     */ import oshi.hardware.common.AbstractComputerSystem;
/*     */ import oshi.hardware.platform.unix.UnixBaseboard;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.platform.unix.freebsd.BsdSysctlUtil;
/*     */ import oshi.util.tuples.Quintet;
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
/*     */ final class FreeBsdComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  48 */   private final Supplier<Quintet<String, String, String, String, String>> manufModelSerialUuidVers = Memoizer.memoize(FreeBsdComputerSystem::readDmiDecode);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  53 */     return (String)((Quintet)this.manufModelSerialUuidVers.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  58 */     return (String)((Quintet)this.manufModelSerialUuidVers.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  63 */     return (String)((Quintet)this.manufModelSerialUuidVers.get()).getC();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  68 */     return (String)((Quintet)this.manufModelSerialUuidVers.get()).getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  73 */     return (Firmware)new FreeBsdFirmware();
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  78 */     return (Baseboard)new UnixBaseboard((String)((Quintet)this.manufModelSerialUuidVers.get()).getA(), (String)((Quintet)this.manufModelSerialUuidVers.get()).getB(), (String)((Quintet)this.manufModelSerialUuidVers
/*  79 */         .get()).getC(), (String)((Quintet)this.manufModelSerialUuidVers.get()).getE());
/*     */   }
/*     */   
/*     */   private static Quintet<String, String, String, String, String> readDmiDecode() {
/*  83 */     String str1 = null;
/*  84 */     String str2 = null;
/*  85 */     String str3 = null;
/*  86 */     String str4 = null;
/*  87 */     String str5 = null;
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
/* 110 */     String str6 = "Manufacturer:";
/* 111 */     String str7 = "Product Name:";
/* 112 */     String str8 = "Serial Number:";
/* 113 */     String str9 = "UUID:";
/* 114 */     String str10 = "Version:";
/*     */ 
/*     */     
/* 117 */     for (String str : ExecutingCommand.runNative("dmidecode -t system")) {
/* 118 */       if (str.contains("Manufacturer:")) {
/* 119 */         str1 = str.split("Manufacturer:")[1].trim(); continue;
/* 120 */       }  if (str.contains("Product Name:")) {
/* 121 */         str2 = str.split("Product Name:")[1].trim(); continue;
/* 122 */       }  if (str.contains("Serial Number:")) {
/* 123 */         str3 = str.split("Serial Number:")[1].trim(); continue;
/* 124 */       }  if (str.contains("UUID:")) {
/* 125 */         str4 = str.split("UUID:")[1].trim(); continue;
/* 126 */       }  if (str.contains("Version:")) {
/* 127 */         str5 = str.split("Version:")[1].trim();
/*     */       }
/*     */     } 
/*     */     
/* 131 */     if (Util.isBlank(str3)) {
/* 132 */       str3 = querySystemSerialNumber();
/*     */     }
/* 134 */     if (Util.isBlank(str4)) {
/* 135 */       str4 = BsdSysctlUtil.sysctl("kern.hostuuid", "unknown");
/*     */     }
/* 137 */     return new Quintet(Util.isBlank(str1) ? "unknown" : str1, 
/* 138 */         Util.isBlank(str2) ? "unknown" : str2, 
/* 139 */         Util.isBlank(str3) ? "unknown" : str3, 
/* 140 */         Util.isBlank(str4) ? "unknown" : str4, Util.isBlank(str5) ? "unknown" : str5);
/*     */   }
/*     */   
/*     */   private static String querySystemSerialNumber() {
/* 144 */     String str = "system.hardware.serial =";
/* 145 */     for (String str1 : ExecutingCommand.runNative("lshal")) {
/* 146 */       if (str1.contains(str)) {
/* 147 */         return ParseUtil.getSingleQuoteStringValue(str1);
/*     */       }
/*     */     } 
/* 150 */     return "unknown";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */