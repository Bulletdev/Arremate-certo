/*     */ package oshi.hardware.platform.mac;
/*     */ 
/*     */ import com.sun.jna.Native;
/*     */ import com.sun.jna.platform.mac.IOKit;
/*     */ import com.sun.jna.platform.mac.IOKitUtil;
/*     */ import java.nio.charset.StandardCharsets;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.common.AbstractFirmware;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.Util;
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
/*     */ 
/*     */ 
/*     */ @Immutable
/*     */ final class MacFirmware
/*     */   extends AbstractFirmware
/*     */ {
/*  48 */   private final Supplier<Quintet<String, String, String, String, String>> manufNameDescVersRelease = Memoizer.memoize(MacFirmware::queryEfi);
/*     */ 
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  53 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/*  58 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDescription() {
/*  63 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getC();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  68 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getD();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReleaseDate() {
/*  73 */     return (String)((Quintet)this.manufNameDescVersRelease.get()).getE();
/*     */   }
/*     */   
/*     */   private static Quintet<String, String, String, String, String> queryEfi() {
/*  77 */     String str1 = null;
/*  78 */     String str2 = null;
/*  79 */     String str3 = null;
/*  80 */     String str4 = null;
/*  81 */     String str5 = null;
/*     */     
/*  83 */     IOKit.IOService iOService = IOKitUtil.getMatchingService("IOPlatformExpertDevice");
/*     */     
/*  85 */     if (iOService != null) {
/*  86 */       IOKit.IOIterator iOIterator = iOService.getChildIterator("IODeviceTree");
/*  87 */       if (iOIterator != null) {
/*  88 */         IOKit.IORegistryEntry iORegistryEntry = iOIterator.next();
/*  89 */         while (iORegistryEntry != null) {
/*  90 */           byte[] arrayOfByte; switch (iORegistryEntry.getName()) {
/*     */             case "rom":
/*  92 */               arrayOfByte = iORegistryEntry.getByteArrayProperty("vendor");
/*  93 */               if (arrayOfByte != null) {
/*  94 */                 str1 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */               }
/*  96 */               arrayOfByte = iORegistryEntry.getByteArrayProperty("version");
/*  97 */               if (arrayOfByte != null) {
/*  98 */                 str4 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */               }
/* 100 */               arrayOfByte = iORegistryEntry.getByteArrayProperty("release-date");
/* 101 */               if (arrayOfByte != null) {
/* 102 */                 str5 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */               }
/*     */               break;
/*     */             case "chosen":
/* 106 */               arrayOfByte = iORegistryEntry.getByteArrayProperty("booter-name");
/* 107 */               if (arrayOfByte != null) {
/* 108 */                 str2 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */               }
/*     */               break;
/*     */             case "efi":
/* 112 */               arrayOfByte = iORegistryEntry.getByteArrayProperty("firmware-abi");
/* 113 */               if (arrayOfByte != null) {
/* 114 */                 str3 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */               }
/*     */               break;
/*     */             default:
/* 118 */               if (Util.isBlank(str2)) {
/* 119 */                 str2 = iORegistryEntry.getStringProperty("IONameMatch");
/*     */               }
/*     */               break;
/*     */           } 
/* 123 */           iORegistryEntry.release();
/* 124 */           iORegistryEntry = iOIterator.next();
/*     */         } 
/* 126 */         iOIterator.release();
/*     */       } 
/* 128 */       if (Util.isBlank(str1)) {
/* 129 */         byte[] arrayOfByte = iOService.getByteArrayProperty("manufacturer");
/* 130 */         if (arrayOfByte != null) {
/* 131 */           str1 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */         }
/*     */       } 
/* 134 */       if (Util.isBlank(str4)) {
/* 135 */         byte[] arrayOfByte = iOService.getByteArrayProperty("target-type");
/* 136 */         if (arrayOfByte != null) {
/* 137 */           str4 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */         }
/*     */       } 
/* 140 */       if (Util.isBlank(str2)) {
/* 141 */         byte[] arrayOfByte = iOService.getByteArrayProperty("device_type");
/* 142 */         if (arrayOfByte != null) {
/* 143 */           str2 = Native.toString(arrayOfByte, StandardCharsets.UTF_8);
/*     */         }
/*     */       } 
/* 146 */       iOService.release();
/*     */     } 
/* 148 */     return new Quintet(Util.isBlank(str1) ? "unknown" : str1, 
/* 149 */         Util.isBlank(str2) ? "unknown" : str2, 
/* 150 */         Util.isBlank(str3) ? "unknown" : str3, 
/* 151 */         Util.isBlank(str4) ? "unknown" : str4, 
/* 152 */         Util.isBlank(str5) ? "unknown" : str5);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platform\mac\MacFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */