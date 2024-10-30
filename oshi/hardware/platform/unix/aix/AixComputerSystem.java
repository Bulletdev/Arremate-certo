/*     */ package oshi.hardware.platform.unix.aix;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.Baseboard;
/*     */ import oshi.hardware.Firmware;
/*     */ import oshi.hardware.common.AbstractComputerSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
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
/*     */ final class AixComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  46 */   private final Supplier<LsattrStrings> lsattrStrings = Memoizer.memoize(AixComputerSystem::readLsattr);
/*     */   private final Supplier<List<String>> lscfg;
/*     */   
/*     */   AixComputerSystem(Supplier<List<String>> paramSupplier) {
/*  50 */     this.lscfg = paramSupplier;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  55 */     return (this.lsattrStrings.get()).manufacturer;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  60 */     return (this.lsattrStrings.get()).model;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  65 */     return (this.lsattrStrings.get()).serialNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  70 */     return (this.lsattrStrings.get()).uuid;
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  75 */     return (Firmware)new AixFirmware((this.lsattrStrings.get()).biosVendor, (this.lsattrStrings.get()).biosPlatformVersion, 
/*  76 */         (this.lsattrStrings.get()).biosVersion);
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  81 */     return (Baseboard)new AixBaseboard(this.lscfg);
/*     */   }
/*     */   
/*     */   private static LsattrStrings readLsattr() {
/*  85 */     String str1 = "IBM";
/*  86 */     String str2 = null;
/*  87 */     String str3 = null;
/*     */     
/*  89 */     String str4 = str1;
/*  90 */     String str5 = null;
/*  91 */     String str6 = null;
/*  92 */     String str7 = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 102 */     String str8 = "fwversion";
/* 103 */     String str9 = "modelname";
/* 104 */     String str10 = "systemid";
/* 105 */     String str11 = "os_uuid";
/* 106 */     String str12 = "Platform Firmware level is";
/*     */     
/* 108 */     for (String str : ExecutingCommand.runNative("lsattr -El sys0")) {
/* 109 */       if (str.startsWith("fwversion")) {
/* 110 */         str2 = str.split("fwversion")[1].trim();
/* 111 */         int i = str2.indexOf(',');
/* 112 */         if (i > 0 && str2.length() > i) {
/* 113 */           str1 = str2.substring(0, i);
/* 114 */           str2 = str2.substring(i + 1);
/*     */         } 
/* 116 */         str2 = ParseUtil.whitespaces.split(str2)[0]; continue;
/* 117 */       }  if (str.startsWith("modelname")) {
/* 118 */         str5 = str.split("modelname")[1].trim();
/* 119 */         int i = str5.indexOf(',');
/* 120 */         if (i > 0 && str5.length() > i) {
/* 121 */           str4 = str5.substring(0, i);
/* 122 */           str5 = str5.substring(i + 1);
/*     */         } 
/* 124 */         str5 = ParseUtil.whitespaces.split(str5)[0]; continue;
/* 125 */       }  if (str.startsWith("systemid")) {
/* 126 */         str6 = str.split("systemid")[1].trim();
/* 127 */         str6 = ParseUtil.whitespaces.split(str6)[0]; continue;
/* 128 */       }  if (str.startsWith("os_uuid")) {
/* 129 */         str7 = str.split("os_uuid")[1].trim();
/* 130 */         str7 = ParseUtil.whitespaces.split(str7)[0];
/*     */       } 
/*     */     } 
/* 133 */     for (String str : ExecutingCommand.runNative("lsmcode -c")) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 138 */       if (str.startsWith("Platform Firmware level is")) {
/* 139 */         str3 = str.split("Platform Firmware level is")[1].trim();
/*     */         break;
/*     */       } 
/*     */     } 
/* 143 */     return new LsattrStrings(str1, str3, str2, str4, str5, str6, str7);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class LsattrStrings
/*     */   {
/*     */     private final String biosVendor;
/*     */     private final String biosPlatformVersion;
/*     */     private final String biosVersion;
/*     */     private final String manufacturer;
/*     */     private final String model;
/*     */     private final String serialNumber;
/*     */     private final String uuid;
/*     */     
/*     */     private LsattrStrings(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7) {
/* 158 */       this.biosVendor = Util.isBlank(param1String1) ? "unknown" : param1String1;
/* 159 */       this.biosPlatformVersion = Util.isBlank(param1String2) ? "unknown" : param1String2;
/* 160 */       this.biosVersion = Util.isBlank(param1String3) ? "unknown" : param1String3;
/*     */       
/* 162 */       this.manufacturer = Util.isBlank(param1String4) ? "unknown" : param1String4;
/* 163 */       this.model = Util.isBlank(param1String5) ? "unknown" : param1String5;
/* 164 */       this.serialNumber = Util.isBlank(param1String6) ? "unknown" : param1String6;
/* 165 */       this.uuid = Util.isBlank(param1String7) ? "unknown" : param1String7;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\aix\AixComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */