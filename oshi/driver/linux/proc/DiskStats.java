/*     */ package oshi.driver.linux.proc;
/*     */ 
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class DiskStats
/*     */ {
/*     */   public enum IoStat
/*     */   {
/*  49 */     MAJOR,
/*     */ 
/*     */ 
/*     */     
/*  53 */     MINOR,
/*     */ 
/*     */ 
/*     */     
/*  57 */     NAME,
/*     */ 
/*     */ 
/*     */     
/*  61 */     READS,
/*     */ 
/*     */ 
/*     */     
/*  65 */     READS_MERGED,
/*     */ 
/*     */ 
/*     */     
/*  69 */     READS_SECTOR,
/*     */ 
/*     */ 
/*     */     
/*  73 */     READS_MS,
/*     */ 
/*     */ 
/*     */     
/*  77 */     WRITES,
/*     */ 
/*     */ 
/*     */     
/*  81 */     WRITES_MERGED,
/*     */ 
/*     */ 
/*     */     
/*  85 */     WRITES_SECTOR,
/*     */ 
/*     */ 
/*     */     
/*  89 */     WRITES_MS,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  94 */     IO_QUEUE_LENGTH,
/*     */ 
/*     */ 
/*     */     
/*  98 */     IO_MS,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     IO_MS_WEIGHTED,
/*     */ 
/*     */ 
/*     */     
/* 108 */     DISCARDS,
/*     */ 
/*     */ 
/*     */     
/* 112 */     DISCARDS_MERGED,
/*     */ 
/*     */ 
/*     */     
/* 116 */     DISCARDS_SECTOR,
/*     */ 
/*     */ 
/*     */     
/* 120 */     DISCARDS_MS,
/*     */ 
/*     */ 
/*     */     
/* 124 */     FLUSHES,
/*     */ 
/*     */ 
/*     */     
/* 128 */     FLUSHES_MS;
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
/*     */ 
/*     */   
/*     */   public static Map<String, Map<IoStat, Long>> getDiskStats() {
/* 142 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 143 */     IoStat[] arrayOfIoStat = IoStat.class.getEnumConstants();
/* 144 */     List list = FileUtil.readFile(ProcPath.DISKSTATS);
/* 145 */     for (String str1 : list) {
/* 146 */       String[] arrayOfString = ParseUtil.whitespaces.split(str1.trim());
/* 147 */       EnumMap<IoStat, Object> enumMap = new EnumMap<>(IoStat.class);
/* 148 */       String str2 = null;
/* 149 */       for (byte b = 0; b < arrayOfIoStat.length && b < arrayOfString.length; b++) {
/* 150 */         if (arrayOfIoStat[b] == IoStat.NAME) {
/* 151 */           str2 = arrayOfString[b];
/*     */         } else {
/* 153 */           enumMap.put(arrayOfIoStat[b], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[b], 0L)));
/*     */         } 
/*     */       } 
/* 156 */       if (str2 != null) {
/* 157 */         hashMap.put(str2, enumMap);
/*     */       }
/*     */     } 
/* 160 */     return (Map)hashMap;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\DiskStats.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */