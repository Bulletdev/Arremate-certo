/*     */ package oshi.hardware.platform.unix.solaris;
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
/*     */ final class SolarisComputerSystem
/*     */   extends AbstractComputerSystem
/*     */ {
/*  46 */   private final Supplier<SmbiosStrings> smbiosStrings = Memoizer.memoize(SolarisComputerSystem::readSmbios);
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  50 */     return (this.smbiosStrings.get()).manufacturer;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModel() {
/*  55 */     return (this.smbiosStrings.get()).model;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSerialNumber() {
/*  60 */     return (this.smbiosStrings.get()).serialNumber;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getHardwareUUID() {
/*  65 */     return (this.smbiosStrings.get()).uuid;
/*     */   }
/*     */ 
/*     */   
/*     */   public Firmware createFirmware() {
/*  70 */     return (Firmware)new SolarisFirmware((this.smbiosStrings.get()).biosVendor, (this.smbiosStrings.get()).biosVersion, 
/*  71 */         (this.smbiosStrings.get()).biosDate);
/*     */   }
/*     */ 
/*     */   
/*     */   public Baseboard createBaseboard() {
/*  76 */     return (Baseboard)new UnixBaseboard((this.smbiosStrings.get()).boardManufacturer, (this.smbiosStrings.get()).boardModel, 
/*  77 */         (this.smbiosStrings.get()).boardSerialNumber, (this.smbiosStrings.get()).boardVersion);
/*     */   }
/*     */   
/*     */   private static SmbiosStrings readSmbios() {
/*  81 */     String str1 = null;
/*  82 */     String str2 = null;
/*  83 */     String str3 = null;
/*     */     
/*  85 */     String str4 = null;
/*  86 */     String str5 = null;
/*  87 */     String str6 = null;
/*  88 */     String str7 = null;
/*     */     
/*  90 */     String str8 = null;
/*  91 */     String str9 = null;
/*  92 */     String str10 = null;
/*  93 */     String str11 = null;
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
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 131 */     String str12 = "Vendor:";
/* 132 */     String str13 = "Release Date:";
/* 133 */     String str14 = "VersionString:";
/*     */     
/* 135 */     String str15 = "Manufacturer:";
/* 136 */     String str16 = "Product:";
/* 137 */     String str17 = "Serial Number:";
/* 138 */     String str18 = "UUID:";
/* 139 */     String str19 = "Version:";
/*     */     
/* 141 */     int i = -1;
/*     */     
/* 143 */     for (String str : ExecutingCommand.runNative("smbios")) {
/*     */       
/* 145 */       if (str.contains("SMB_TYPE_") && (i = getSmbType(str)) == Integer.MAX_VALUE) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 150 */       switch (i) {
/*     */         case 0:
/* 152 */           if (str.contains("Vendor:")) {
/* 153 */             str1 = str.split("Vendor:")[1].trim(); continue;
/* 154 */           }  if (str.contains("VersionString:")) {
/* 155 */             str2 = str.split("VersionString:")[1].trim(); continue;
/* 156 */           }  if (str.contains("Release Date:")) {
/* 157 */             str3 = str.split("Release Date:")[1].trim();
/*     */           }
/*     */         
/*     */         case 1:
/* 161 */           if (str.contains("Manufacturer:")) {
/* 162 */             str4 = str.split("Manufacturer:")[1].trim(); continue;
/* 163 */           }  if (str.contains("Product:")) {
/* 164 */             str5 = str.split("Product:")[1].trim(); continue;
/* 165 */           }  if (str.contains("Serial Number:")) {
/* 166 */             str6 = str.split("Serial Number:")[1].trim(); continue;
/* 167 */           }  if (str.contains("UUID:")) {
/* 168 */             str7 = str.split("UUID:")[1].trim();
/*     */           }
/*     */         
/*     */         case 2:
/* 172 */           if (str.contains("Manufacturer:")) {
/* 173 */             str8 = str.split("Manufacturer:")[1].trim(); continue;
/* 174 */           }  if (str.contains("Product:")) {
/* 175 */             str9 = str.split("Product:")[1].trim(); continue;
/* 176 */           }  if (str.contains("Version:")) {
/* 177 */             str10 = str.split("Version:")[1].trim(); continue;
/* 178 */           }  if (str.contains("Serial Number:")) {
/* 179 */             str11 = str.split("Serial Number:")[1].trim();
/*     */           }
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 187 */     if (Util.isBlank(str6)) {
/* 188 */       str6 = readSerialNumber();
/*     */     }
/* 190 */     return new SmbiosStrings(str1, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getSmbType(String paramString) {
/* 195 */     if (paramString.contains("SMB_TYPE_BIOS"))
/* 196 */       return 0; 
/* 197 */     if (paramString.contains("SMB_TYPE_SYSTEM"))
/* 198 */       return 1; 
/* 199 */     if (paramString.contains("SMB_TYPE_BASEBOARD")) {
/* 200 */       return 2;
/*     */     }
/*     */ 
/*     */     
/* 204 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String readSerialNumber() {
/* 210 */     String str = ExecutingCommand.getFirstAnswer("sneep");
/*     */     
/* 212 */     if (str.isEmpty()) {
/* 213 */       String str1 = "chassis-sn:";
/* 214 */       for (String str2 : ExecutingCommand.runNative("prtconf -pv")) {
/* 215 */         if (str2.contains(str1)) {
/* 216 */           str = ParseUtil.getSingleQuoteStringValue(str2);
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 221 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SmbiosStrings
/*     */   {
/*     */     private final String biosVendor;
/*     */     
/*     */     private final String biosVersion;
/*     */     
/*     */     private final String biosDate;
/*     */     private final String manufacturer;
/*     */     private final String model;
/*     */     private final String serialNumber;
/*     */     private final String uuid;
/*     */     private final String boardManufacturer;
/*     */     private final String boardModel;
/*     */     private final String boardVersion;
/*     */     private final String boardSerialNumber;
/*     */     
/*     */     private SmbiosStrings(String param1String1, String param1String2, String param1String3, String param1String4, String param1String5, String param1String6, String param1String7, String param1String8, String param1String9, String param1String10, String param1String11) {
/* 242 */       this.biosVendor = Util.isBlank(param1String1) ? "unknown" : param1String1;
/* 243 */       this.biosVersion = Util.isBlank(param1String2) ? "unknown" : param1String2;
/* 244 */       this.biosDate = Util.isBlank(param1String3) ? "unknown" : param1String3;
/*     */       
/* 246 */       this.manufacturer = Util.isBlank(param1String4) ? "unknown" : param1String4;
/* 247 */       this.model = Util.isBlank(param1String5) ? "unknown" : param1String5;
/* 248 */       this.serialNumber = Util.isBlank(param1String6) ? "unknown" : param1String6;
/* 249 */       this.uuid = Util.isBlank(param1String7) ? "unknown" : param1String7;
/*     */       
/* 251 */       this.boardManufacturer = Util.isBlank(param1String8) ? "unknown" : param1String8;
/* 252 */       this.boardModel = Util.isBlank(param1String9) ? "unknown" : param1String9;
/* 253 */       this.boardVersion = Util.isBlank(param1String10) ? "unknown" : param1String10;
/* 254 */       this.boardSerialNumber = Util.isBlank(param1String11) ? "unknown" : param1String11;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisComputerSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */