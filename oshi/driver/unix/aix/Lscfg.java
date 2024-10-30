/*     */ package oshi.driver.unix.aix;
/*     */ 
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class Lscfg
/*     */ {
/*     */   public static List<String> queryAllDevices() {
/*  49 */     return ExecutingCommand.runNative("lscfg -vp");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Triplet<String, String, String> queryBackplaneModelSerialVersion(List<String> paramList) {
/*  60 */     String str1 = "WAY BACKPLANE";
/*  61 */     String str2 = "Part Number";
/*  62 */     String str3 = "Serial Number";
/*  63 */     String str4 = "Version";
/*  64 */     String str5 = "Physical Location";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     String str6 = null;
/*  77 */     String str7 = null;
/*  78 */     String str8 = null;
/*  79 */     boolean bool = false;
/*  80 */     for (String str : paramList) {
/*  81 */       if (!bool && str.contains("WAY BACKPLANE")) {
/*  82 */         bool = true; continue;
/*  83 */       }  if (bool) {
/*  84 */         if (str.contains("Part Number")) {
/*  85 */           str6 = ParseUtil.removeLeadingDots(str.split("Part Number")[1].trim()); continue;
/*  86 */         }  if (str.contains("Serial Number")) {
/*  87 */           str7 = ParseUtil.removeLeadingDots(str.split("Serial Number")[1].trim()); continue;
/*  88 */         }  if (str.contains("Version")) {
/*  89 */           str8 = ParseUtil.removeLeadingDots(str.split("Version")[1].trim()); continue;
/*  90 */         }  if (str.contains("Physical Location")) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/*  95 */     return new Triplet(str6, str7, str8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Pair<String, String> queryModelSerial(String paramString) {
/* 107 */     String str1 = "Machine Type and Model";
/* 108 */     String str2 = "Serial Number";
/* 109 */     String str3 = null;
/* 110 */     String str4 = null;
/* 111 */     for (String str : ExecutingCommand.runNative("lscfg -vl " + paramString)) {
/* 112 */       if (str.contains(str1)) {
/* 113 */         str3 = ParseUtil.removeLeadingDots(str.split(str1)[1].trim()); continue;
/* 114 */       }  if (str.contains(str2)) {
/* 115 */         str4 = ParseUtil.removeLeadingDots(str.split(str2)[1].trim());
/*     */       }
/*     */     } 
/* 118 */     return new Pair(str3, str4);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\Lscfg.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */