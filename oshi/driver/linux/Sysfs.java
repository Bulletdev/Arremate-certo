/*     */ package oshi.driver.linux;
/*     */ 
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FileUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class Sysfs
/*     */ {
/*     */   public static String querySystemVendor() {
/*  47 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/sys_vendor").trim();
/*  48 */     if (!str.isEmpty()) {
/*  49 */       return str;
/*     */     }
/*  51 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryProductModel() {
/*  60 */     String str1 = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_name").trim();
/*     */     
/*  62 */     String str2 = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_version").trim();
/*  63 */     if (str1.isEmpty()) {
/*  64 */       if (!str2.isEmpty()) {
/*  65 */         return str2;
/*     */       }
/*     */     } else {
/*  68 */       if (!str2.isEmpty() && !"None".equals(str2)) {
/*  69 */         return str1 + " (version: " + str2 + ")";
/*     */       }
/*  71 */       return str1;
/*     */     } 
/*     */     
/*  74 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryProductSerial() {
/*  85 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_serial");
/*  86 */     if (!str.isEmpty() && !"None".equals(str)) {
/*  87 */       return str;
/*     */     }
/*  89 */     return queryBoardSerial();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryUUID() {
/* 100 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/product_uuid");
/* 101 */     if (!str.isEmpty() && !"None".equals(str)) {
/* 102 */       return str;
/*     */     }
/* 104 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBoardVendor() {
/* 113 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_vendor").trim();
/* 114 */     if (!str.isEmpty()) {
/* 115 */       return str;
/*     */     }
/* 117 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBoardModel() {
/* 126 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_name").trim();
/* 127 */     if (!str.isEmpty()) {
/* 128 */       return str;
/*     */     }
/* 130 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBoardVersion() {
/* 139 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_version").trim();
/* 140 */     if (!str.isEmpty()) {
/* 141 */       return str;
/*     */     }
/* 143 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBoardSerial() {
/* 152 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/board_serial").trim();
/* 153 */     if (!str.isEmpty()) {
/* 154 */       return str;
/*     */     }
/* 156 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBiosVendor() {
/* 165 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_vendor").trim();
/* 166 */     if (str.isEmpty()) {
/* 167 */       return str;
/*     */     }
/* 169 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBiosDescription() {
/* 178 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/modalias").trim();
/* 179 */     if (!str.isEmpty()) {
/* 180 */       return str;
/*     */     }
/* 182 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBiosVersion(String paramString) {
/* 193 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_version").trim();
/* 194 */     if (!str.isEmpty()) {
/* 195 */       return str + (Util.isBlank(paramString) ? "" : (" (revision " + paramString + ")"));
/*     */     }
/* 197 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryBiosReleaseDate() {
/* 206 */     String str = FileUtil.getStringFromFile("/sys/devices/virtual/dmi/id/bios_date").trim();
/* 207 */     if (!str.isEmpty()) {
/* 208 */       return ParseUtil.parseMmDdYyyyToYyyyMmDD(str);
/*     */     }
/* 210 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Sysfs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */