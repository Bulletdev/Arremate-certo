/*     */ package oshi.driver.unix.solaris.disk;
/*     */ 
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class Iostat
/*     */ {
/*     */   private static final String IOSTAT_ER_DETAIL = "iostat -Er";
/*     */   private static final String IOSTAT_ER = "iostat -er";
/*     */   private static final String IOSTAT_ERN = "iostat -ern";
/*     */   private static final String DEVICE_HEADER = "device";
/*     */   
/*     */   public static Map<String, String> queryPartitionToMountMap() {
/*  74 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */ 
/*     */     
/*  77 */     List<String> list1 = ExecutingCommand.runNative("iostat -er");
/*     */     
/*  79 */     List<String> list2 = ExecutingCommand.runNative("iostat -ern");
/*     */ 
/*     */     
/*  82 */     for (byte b = 0; b < list1.size() && b < list2.size(); b++) {
/*     */       
/*  84 */       String str = list1.get(b);
/*  85 */       String[] arrayOfString = str.split(",");
/*  86 */       if (arrayOfString.length >= 5 && !"device".equals(arrayOfString[0])) {
/*  87 */         String str1 = list2.get(b);
/*  88 */         String[] arrayOfString1 = str1.split(",");
/*  89 */         if (arrayOfString1.length >= 5 && !"device".equals(arrayOfString1[4])) {
/*  90 */           hashMap.put(arrayOfString[0], arrayOfString1[4]);
/*     */         }
/*     */       } 
/*     */     } 
/*  94 */     return (Map)hashMap;
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
/*     */   public static Map<String, Quintet<String, String, String, String, Long>> queryDeviceStrings(Set<String> paramSet) {
/* 106 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/* 108 */     List list = ExecutingCommand.runNative("iostat -Er");
/*     */     
/* 110 */     String str1 = null;
/* 111 */     String str2 = "";
/* 112 */     String str3 = "";
/* 113 */     String str4 = "";
/* 114 */     String str5 = "";
/* 115 */     long l = 0L;
/* 116 */     for (String str : list) {
/*     */ 
/*     */ 
/*     */       
/* 120 */       String[] arrayOfString = str.split(",");
/* 121 */       for (String str6 : arrayOfString) {
/* 122 */         str6 = str6.trim();
/*     */ 
/*     */         
/* 125 */         if (paramSet.contains(str6)) {
/*     */ 
/*     */           
/* 128 */           if (str1 != null) {
/* 129 */             hashMap.put(str1, new Quintet(str2, str3, str4, str5, Long.valueOf(l)));
/*     */           }
/*     */           
/* 132 */           str1 = str6;
/* 133 */           str2 = "";
/* 134 */           str3 = "";
/* 135 */           str4 = "";
/* 136 */           str5 = "";
/* 137 */           l = 0L;
/*     */ 
/*     */         
/*     */         }
/* 141 */         else if (str6.startsWith("Model:")) {
/* 142 */           str2 = str6.replace("Model:", "").trim();
/* 143 */         } else if (str6.startsWith("Serial No:")) {
/* 144 */           str5 = str6.replace("Serial No:", "").trim();
/* 145 */         } else if (str6.startsWith("Vendor:")) {
/* 146 */           str3 = str6.replace("Vendor:", "").trim();
/* 147 */         } else if (str6.startsWith("Product:")) {
/* 148 */           str4 = str6.replace("Product:", "").trim();
/* 149 */         } else if (str6.startsWith("Size:")) {
/*     */           
/* 151 */           String[] arrayOfString1 = str6.split("<");
/* 152 */           if (arrayOfString1.length > 1) {
/* 153 */             arrayOfString1 = ParseUtil.whitespaces.split(arrayOfString1[1]);
/* 154 */             l = ParseUtil.parseLongOrDefault(arrayOfString1[0], 0L);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 159 */       if (str1 != null) {
/* 160 */         hashMap.put(str1, new Quintet(str2, str3, str4, str5, Long.valueOf(l)));
/*     */       }
/*     */     } 
/* 163 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\solaris\disk\Iostat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */