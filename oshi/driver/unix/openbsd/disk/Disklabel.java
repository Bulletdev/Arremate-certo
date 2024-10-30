/*     */ package oshi.driver.unix.openbsd.disk;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.tuples.Pair;
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
/*     */ 
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
/*     */ public final class Disklabel
/*     */ {
/*     */   public static Quartet<String, String, Long, List<HWPartition>> getDiskParams(String paramString) {
/*  63 */     ArrayList<HWPartition> arrayList = new ArrayList();
/*     */     
/*  65 */     String str1 = "total sectors:";
/*  66 */     long l = 1L;
/*  67 */     String str2 = "bytes/sector:";
/*  68 */     int i = 1;
/*  69 */     String str3 = "label:";
/*  70 */     String str4 = "";
/*  71 */     String str5 = "duid:";
/*  72 */     String str6 = "";
/*  73 */     for (String str : ExecutingCommand.runNative("disklabel -n " + paramString)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  90 */       if (str.contains(str1)) {
/*  91 */         l = ParseUtil.getFirstIntValue(str);
/*  92 */       } else if (str.contains(str2)) {
/*  93 */         i = ParseUtil.getFirstIntValue(str);
/*  94 */       } else if (str.contains(str3)) {
/*  95 */         str4 = str.split(str3)[1].trim();
/*  96 */       } else if (str.contains(str5)) {
/*  97 */         str6 = str.split(str5)[1].trim();
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 116 */       if (str.trim().indexOf(':') == 1) {
/*     */         
/* 118 */         String[] arrayOfString = ParseUtil.whitespaces.split(str.trim(), 9);
/* 119 */         String str7 = arrayOfString[0].substring(0, 1);
/*     */         
/* 121 */         Pair<Integer, Integer> pair = getMajorMinor(paramString, str7);
/*     */         
/* 123 */         if (arrayOfString.length > 4) {
/* 124 */           arrayList.add(new HWPartition(paramString + str7, str7, arrayOfString[3], str6 + "." + str7, 
/* 125 */                 ParseUtil.parseLongOrDefault(arrayOfString[1], 0L) * i, ((Integer)pair.getA()).intValue(), ((Integer)pair
/* 126 */                 .getB()).intValue(), (arrayOfString.length > 5) ? arrayOfString[arrayOfString.length - 1] : ""));
/*     */         }
/*     */       } 
/*     */     } 
/* 130 */     if (arrayList.isEmpty()) {
/* 131 */       return getDiskParamsNoRoot(paramString);
/*     */     }
/* 133 */     return new Quartet(str4, str6, Long.valueOf(l * i), arrayList);
/*     */   }
/*     */   
/*     */   private static Quartet<String, String, Long, List<HWPartition>> getDiskParamsNoRoot(String paramString) {
/* 137 */     ArrayList<HWPartition> arrayList = new ArrayList();
/* 138 */     for (String str : ExecutingCommand.runNative("df")) {
/* 139 */       if (str.startsWith("/dev/" + paramString)) {
/* 140 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 141 */         String str1 = arrayOfString[0].substring(5 + paramString.length());
/* 142 */         Pair<Integer, Integer> pair = getMajorMinor(paramString, str1);
/* 143 */         if (arrayOfString.length > 5) {
/* 144 */           long l = ParseUtil.parseLongOrDefault(arrayOfString[1], 1L) * 512L;
/* 145 */           arrayList.add(new HWPartition(arrayOfString[0], arrayOfString[0].substring(5), "unknown", "unknown", l, ((Integer)pair
/* 146 */                 .getA()).intValue(), ((Integer)pair.getB()).intValue(), arrayOfString[5]));
/*     */         } 
/*     */       } 
/*     */     } 
/* 150 */     return new Quartet("unknown", "unknown", Long.valueOf(0L), arrayList);
/*     */   }
/*     */   
/*     */   private static Pair<Integer, Integer> getMajorMinor(String paramString1, String paramString2) {
/* 154 */     int i = 0;
/* 155 */     int j = 0;
/* 156 */     String str = ExecutingCommand.getFirstAnswer("stat -f %Hr,%Lr /dev/" + paramString1 + paramString2);
/* 157 */     int k = str.indexOf(',');
/* 158 */     if (k > 0 && k < str.length()) {
/* 159 */       i = ParseUtil.parseIntOrDefault(str.substring(0, k), 0);
/* 160 */       j = ParseUtil.parseIntOrDefault(str.substring(k + 1), 0);
/*     */     } 
/* 162 */     return new Pair(Integer.valueOf(i), Integer.valueOf(j));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\openbsd\disk\Disklabel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */