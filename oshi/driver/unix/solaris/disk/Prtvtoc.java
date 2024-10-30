/*     */ package oshi.driver.unix.solaris.disk;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Prtvtoc
/*     */ {
/*     */   private static final String PRTVTOC_DEV_DSK = "prtvtoc /dev/dsk/";
/*     */   
/*     */   public static List<HWPartition> queryPartitions(String paramString, int paramInt) {
/*  47 */     ArrayList<HWPartition> arrayList = new ArrayList();
/*     */ 
/*     */     
/*  50 */     List list = ExecutingCommand.runNative("prtvtoc /dev/dsk/" + paramString);
/*     */     
/*  52 */     if (list.size() > 1) {
/*  53 */       int i = 0;
/*     */ 
/*     */       
/*  56 */       for (String str : list) {
/*     */ 
/*     */         
/*  59 */         if (str.startsWith("*")) {
/*  60 */           if (str.endsWith("bytes/sector")) {
/*  61 */             String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*  62 */             if (arrayOfString.length > 0)
/*  63 */               i = ParseUtil.parseIntOrDefault(arrayOfString[1], 0); 
/*     */           }  continue;
/*     */         } 
/*  66 */         if (i > 0) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*  72 */           String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/*     */           
/*  74 */           if (arrayOfString.length >= 6 && !"2".equals(arrayOfString[0])) {
/*     */             
/*  76 */             String str2, str3, str1 = paramString + "s" + arrayOfString[0];
/*     */             
/*  78 */             int j = ParseUtil.parseIntOrDefault(arrayOfString[0], 0);
/*     */ 
/*     */             
/*  81 */             switch (ParseUtil.parseIntOrDefault(arrayOfString[1], 0)) {
/*     */               case 1:
/*     */               case 24:
/*  84 */                 str2 = "boot";
/*     */                 break;
/*     */               case 2:
/*  87 */                 str2 = "root";
/*     */                 break;
/*     */               case 3:
/*  90 */                 str2 = "swap";
/*     */                 break;
/*     */               case 4:
/*  93 */                 str2 = "usr";
/*     */                 break;
/*     */               case 5:
/*  96 */                 str2 = "backup";
/*     */                 break;
/*     */               case 6:
/*  99 */                 str2 = "stand";
/*     */                 break;
/*     */               case 7:
/* 102 */                 str2 = "var";
/*     */                 break;
/*     */               case 8:
/* 105 */                 str2 = "home";
/*     */                 break;
/*     */               case 9:
/* 108 */                 str2 = "altsctr";
/*     */                 break;
/*     */               case 10:
/* 111 */                 str2 = "cache";
/*     */                 break;
/*     */               case 11:
/* 114 */                 str2 = "reserved";
/*     */                 break;
/*     */               case 12:
/* 117 */                 str2 = "system";
/*     */                 break;
/*     */               case 14:
/* 120 */                 str2 = "public region";
/*     */                 break;
/*     */               case 15:
/* 123 */                 str2 = "private region";
/*     */                 break;
/*     */               default:
/* 126 */                 str2 = "unknown";
/*     */                 break;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 132 */             switch (arrayOfString[2]) {
/*     */               case "00":
/* 134 */                 str3 = "wm";
/*     */                 break;
/*     */               case "10":
/* 137 */                 str3 = "rm";
/*     */                 break;
/*     */               case "01":
/* 140 */                 str3 = "wu";
/*     */                 break;
/*     */               default:
/* 143 */                 str3 = "ru";
/*     */                 break;
/*     */             } 
/*     */             
/* 147 */             long l = i * ParseUtil.parseLongOrDefault(arrayOfString[4], 0L);
/*     */             
/* 149 */             String str4 = "";
/* 150 */             if (arrayOfString.length > 6) {
/* 151 */               str4 = arrayOfString[6];
/*     */             }
/* 153 */             arrayList.add(new HWPartition(str1, str2, str3, "", l, paramInt, j, str4));
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\disk\Prtvtoc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */