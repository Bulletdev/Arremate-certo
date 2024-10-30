/*     */ package oshi.driver.unix.aix;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.HWPartition;
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
/*     */ @ThreadSafe
/*     */ public final class Lspv
/*     */ {
/*     */   public static List<HWPartition> queryLogicalVolumes(String paramString, Map<String, Pair<Integer, Integer>> paramMap) {
/*  73 */     String str1 = "PV STATE:";
/*  74 */     String str2 = "PP SIZE:";
/*  75 */     long l = 0L;
/*  76 */     for (String str : ExecutingCommand.runNative("lspv -L " + paramString)) {
/*  77 */       if (str.startsWith(str1)) {
/*  78 */         if (!str.contains("active"))
/*  79 */           return Collections.emptyList();  continue;
/*     */       } 
/*  81 */       if (str.contains(str2)) {
/*  82 */         l = ParseUtil.getFirstIntValue(str);
/*     */       }
/*     */     } 
/*  85 */     if (l == 0L) {
/*  86 */       return Collections.emptyList();
/*     */     }
/*     */     
/*  89 */     l <<= 20L;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 118 */     HashMap<Object, Object> hashMap1 = new HashMap<>();
/* 119 */     HashMap<Object, Object> hashMap2 = new HashMap<>();
/* 120 */     HashMap<Object, Object> hashMap3 = new HashMap<>();
/* 121 */     for (String str : ExecutingCommand.runNative("lspv -p " + paramString)) {
/* 122 */       String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/* 123 */       if (arrayOfString.length >= 6 && "used".equals(arrayOfString[1])) {
/*     */         
/* 125 */         String str3 = arrayOfString[arrayOfString.length - 3];
/* 126 */         hashMap1.put(str3, arrayOfString[arrayOfString.length - 1]);
/* 127 */         hashMap2.put(str3, arrayOfString[arrayOfString.length - 2]);
/* 128 */         int i = 1 + ParseUtil.getNthIntValue(arrayOfString[0], 2) - ParseUtil.getNthIntValue(arrayOfString[0], 1);
/* 129 */         hashMap3.put(str3, Integer.valueOf(i + ((Integer)hashMap3.getOrDefault(str3, Integer.valueOf(0))).intValue()));
/*     */       } 
/*     */     } 
/* 132 */     ArrayList<HWPartition> arrayList = new ArrayList();
/* 133 */     for (Map.Entry<Object, Object> entry : hashMap1.entrySet()) {
/* 134 */       String str3 = "N/A".equals(entry.getValue()) ? "" : (String)entry.getValue();
/*     */       
/* 136 */       String str4 = (String)entry.getKey();
/* 137 */       String str5 = (String)hashMap2.get(str4);
/* 138 */       long l1 = l * ((Integer)hashMap3.get(str4)).intValue();
/* 139 */       Pair pair = paramMap.get(str4);
/* 140 */       int i = (pair == null) ? ParseUtil.getFirstIntValue(str4) : ((Integer)pair.getA()).intValue();
/* 141 */       int j = (pair == null) ? ParseUtil.getFirstIntValue(str4) : ((Integer)pair.getB()).intValue();
/* 142 */       arrayList.add(new HWPartition(str4, str4, str5, "", l1, i, j, str3));
/*     */     } 
/* 144 */     return arrayList;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\drive\\unix\aix\Lspv.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */