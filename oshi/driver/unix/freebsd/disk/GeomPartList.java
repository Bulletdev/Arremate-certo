/*     */ package oshi.driver.unix.freebsd.disk;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.stream.Collectors;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class GeomPartList
/*     */ {
/*     */   private static final String GEOM_PART_LIST = "geom part list";
/*     */   private static final String STAT_FILESIZE = "stat -f %i /dev/";
/*     */   
/*     */   public static Map<String, List<HWPartition>> queryPartitions() {
/*  57 */     Map<String, String> map = Mount.queryPartitionToMountMap();
/*     */     
/*  59 */     HashMap<Object, Object> hashMap = new HashMap<>();
/*     */     
/*  61 */     String str1 = null;
/*     */     
/*  63 */     ArrayList<HWPartition> arrayList = new ArrayList();
/*     */     
/*  65 */     String str2 = null;
/*  66 */     String str3 = "unknown";
/*  67 */     String str4 = "unknown";
/*  68 */     String str5 = "unknown";
/*  69 */     long l = 0L;
/*  70 */     String str6 = "";
/*     */     
/*  72 */     List list = ExecutingCommand.runNative("geom part list");
/*  73 */     for (String str : list) {
/*  74 */       str = str.trim();
/*     */       
/*  76 */       if (str.startsWith("Geom name:")) {
/*     */         
/*  78 */         if (str1 != null && !arrayList.isEmpty()) {
/*     */           
/*  80 */           hashMap.put(str1, arrayList);
/*     */           
/*  82 */           arrayList = new ArrayList();
/*     */         } 
/*     */         
/*  85 */         str1 = str.substring(str.lastIndexOf(' ') + 1);
/*     */       } 
/*     */       
/*  88 */       if (str1 != null) {
/*     */         
/*  90 */         if (str.contains("Name:")) {
/*     */           
/*  92 */           if (str2 != null) {
/*     */ 
/*     */ 
/*     */             
/*  96 */             int i = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("stat -f %i /dev/" + str2), 0);
/*  97 */             arrayList.add(new HWPartition(str3, str2, str4, str5, l, 0, i, str6));
/*  98 */             str2 = null;
/*  99 */             str3 = "unknown";
/* 100 */             str4 = "unknown";
/* 101 */             str5 = "unknown";
/* 102 */             l = 0L;
/*     */           } 
/*     */ 
/*     */           
/* 106 */           String str7 = str.substring(str.lastIndexOf(' ') + 1);
/* 107 */           if (str7.startsWith(str1)) {
/* 108 */             str2 = str7;
/* 109 */             str3 = str7;
/* 110 */             str6 = map.getOrDefault(str7, "");
/*     */           } 
/*     */         } 
/*     */         
/* 114 */         if (str2 != null) {
/* 115 */           String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 116 */           if (arrayOfString.length >= 2) {
/* 117 */             if (str.startsWith("Mediasize:")) {
/* 118 */               l = ParseUtil.parseLongOrDefault(arrayOfString[1], 0L); continue;
/* 119 */             }  if (str.startsWith("rawuuid:")) {
/* 120 */               str5 = arrayOfString[1]; continue;
/* 121 */             }  if (str.startsWith("type:")) {
/* 122 */               str4 = arrayOfString[1];
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 128 */     if (str1 != null) {
/*     */       
/* 130 */       if (str2 != null) {
/* 131 */         int i = ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("stat -f %i /dev/" + str2), 0);
/* 132 */         arrayList.add(new HWPartition(str3, str2, str4, str5, l, 0, i, str6));
/*     */       } 
/*     */       
/* 135 */       if (!arrayList.isEmpty()) {
/*     */         
/* 137 */         List list1 = (List)arrayList.stream().sorted(Comparator.comparing(HWPartition::getName)).collect(Collectors.toList());
/* 138 */         hashMap.put(str1, list1);
/*     */       } 
/*     */     } 
/* 141 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\freebsd\disk\GeomPartList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */