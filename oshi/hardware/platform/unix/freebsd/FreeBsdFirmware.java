/*     */ package oshi.hardware.platform.unix.freebsd;
/*     */ 
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.hardware.common.AbstractFirmware;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ import oshi.util.tuples.Triplet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class FreeBsdFirmware
/*     */   extends AbstractFirmware
/*     */ {
/*  44 */   private final Supplier<Triplet<String, String, String>> manufVersRelease = Memoizer.memoize(FreeBsdFirmware::readDmiDecode);
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  48 */     return (String)((Triplet)this.manufVersRelease.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/*  53 */     return (String)((Triplet)this.manufVersRelease.get()).getB();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getReleaseDate() {
/*  58 */     return (String)((Triplet)this.manufVersRelease.get()).getC();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Triplet<String, String, String> readDmiDecode() {
/*  66 */     String str1 = null;
/*  67 */     String str2 = null;
/*  68 */     String str3 = "";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     String str4 = "Vendor:";
/*  85 */     String str5 = "Version:";
/*  86 */     String str6 = "Release Date:";
/*     */ 
/*     */     
/*  89 */     for (String str : ExecutingCommand.runNative("dmidecode -t bios")) {
/*  90 */       if (str.contains("Vendor:")) {
/*  91 */         str1 = str.split("Vendor:")[1].trim(); continue;
/*  92 */       }  if (str.contains("Version:")) {
/*  93 */         str2 = str.split("Version:")[1].trim(); continue;
/*  94 */       }  if (str.contains("Release Date:")) {
/*  95 */         str3 = str.split("Release Date:")[1].trim();
/*     */       }
/*     */     } 
/*  98 */     str3 = ParseUtil.parseMmDdYyyyToYyyyMmDD(str3);
/*  99 */     return new Triplet(Util.isBlank(str1) ? "unknown" : str1, 
/* 100 */         Util.isBlank(str2) ? "unknown" : str2, 
/* 101 */         Util.isBlank(str3) ? "unknown" : str3);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\freebsd\FreeBsdFirmware.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */