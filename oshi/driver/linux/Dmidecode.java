/*     */ package oshi.driver.linux;
/*     */ 
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Dmidecode
/*     */ {
/*     */   public static String querySerialNumber() {
/*  84 */     String str = "Serial Number:";
/*  85 */     for (String str1 : ExecutingCommand.runNative("dmidecode -t system")) {
/*  86 */       if (str1.contains(str)) {
/*  87 */         return str1.split(str)[1].trim();
/*     */       }
/*     */     } 
/*  90 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String queryUUID() {
/* 100 */     String str = "UUID:";
/* 101 */     for (String str1 : ExecutingCommand.runNative("dmidecode -t system")) {
/* 102 */       if (str1.contains(str)) {
/* 103 */         return str1.split(str)[1].trim();
/*     */       }
/*     */     } 
/* 106 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pair<String, String> queryBiosNameRev() {
/* 117 */     String str1 = null;
/* 118 */     String str2 = null;
/*     */     
/* 120 */     String str3 = "SMBIOS";
/* 121 */     String str4 = "Bios Revision:";
/*     */ 
/*     */     
/* 124 */     for (String str : ExecutingCommand.runNative("dmidecode -t bios")) {
/* 125 */       if (str.contains("SMBIOS")) {
/* 126 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 127 */         if (arrayOfString.length >= 2) {
/* 128 */           str1 = arrayOfString[0] + " " + arrayOfString[1];
/*     */         }
/*     */       } 
/* 131 */       if (str.contains("Bios Revision:")) {
/* 132 */         str2 = str.split("Bios Revision:")[1].trim();
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 137 */     return new Pair(str1, str2);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\Dmidecode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */