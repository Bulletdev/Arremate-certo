/*     */ package oshi.driver.linux.proc;
/*     */ 
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class CpuInfo
/*     */ {
/*     */   public static String queryCpuManufacturer() {
/*  51 */     List list = FileUtil.readFile(ProcPath.CPUINFO);
/*  52 */     for (String str : list) {
/*  53 */       if (str.startsWith("CPU implementer")) {
/*  54 */         int i = ParseUtil.parseLastInt(str, 0);
/*  55 */         switch (i) {
/*     */           case 65:
/*  57 */             return "ARM";
/*     */           case 66:
/*  59 */             return "Broadcom";
/*     */           case 67:
/*  61 */             return "Cavium";
/*     */           case 68:
/*  63 */             return "DEC";
/*     */           case 78:
/*  65 */             return "Nvidia";
/*     */           case 80:
/*  67 */             return "APM";
/*     */           case 81:
/*  69 */             return "Qualcomm";
/*     */           case 83:
/*  71 */             return "Samsung";
/*     */           case 86:
/*  73 */             return "Marvell";
/*     */           case 102:
/*  75 */             return "Faraday";
/*     */           case 105:
/*  77 */             return "Intel";
/*     */         } 
/*  79 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/*  83 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Quartet<String, String, String, String> queryBoardInfo() {
/*  94 */     String str1 = null;
/*  95 */     String str2 = null;
/*  96 */     String str3 = null;
/*  97 */     String str4 = null;
/*     */     
/*  99 */     List list = FileUtil.readFile(ProcPath.CPUINFO);
/* 100 */     for (String str : list) {
/* 101 */       String[] arrayOfString = ParseUtil.whitespacesColonWhitespace.split(str);
/* 102 */       if (arrayOfString.length < 2) {
/*     */         continue;
/*     */       }
/* 105 */       switch (arrayOfString[0]) {
/*     */         case "Hardware":
/* 107 */           str2 = arrayOfString[1];
/*     */         
/*     */         case "Revision":
/* 110 */           str3 = arrayOfString[1];
/* 111 */           if (str3.length() > 1) {
/* 112 */             str1 = queryBoardManufacturer(str3.charAt(1));
/*     */           }
/*     */         
/*     */         case "Serial":
/* 116 */           str4 = arrayOfString[1];
/*     */       } 
/*     */ 
/*     */ 
/*     */     
/*     */     } 
/* 122 */     return new Quartet(str1, str2, str3, str4);
/*     */   }
/*     */   
/*     */   private static String queryBoardManufacturer(char paramChar) {
/* 126 */     switch (paramChar) {
/*     */       case '0':
/* 128 */         return "Sony UK";
/*     */       case '1':
/* 130 */         return "Egoman";
/*     */       case '2':
/* 132 */         return "Embest";
/*     */       case '3':
/* 134 */         return "Sony Japan";
/*     */       case '4':
/* 136 */         return "Embest";
/*     */       case '5':
/* 138 */         return "Stadium";
/*     */     } 
/* 140 */     return "unknown";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\CpuInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */