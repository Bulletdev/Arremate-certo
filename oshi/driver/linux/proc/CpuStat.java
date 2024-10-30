/*     */ package oshi.driver.linux.proc;
/*     */ 
/*     */ import java.util.List;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
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
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class CpuStat
/*     */ {
/*     */   public static long[] getSystemCpuLoadTicks() {
/*     */     String str;
/*  49 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  54 */     List<String> list = FileUtil.readFile(ProcPath.STAT);
/*  55 */     if (!list.isEmpty()) {
/*  56 */       str = list.get(0);
/*     */     } else {
/*  58 */       return arrayOfLong;
/*     */     } 
/*     */ 
/*     */     
/*  62 */     String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*  63 */     if (arrayOfString.length <= CentralProcessor.TickType.IDLE.getIndex())
/*     */     {
/*  65 */       return arrayOfLong;
/*     */     }
/*     */     
/*  68 */     for (byte b = 0; b < (CentralProcessor.TickType.values()).length; b++) {
/*  69 */       arrayOfLong[b] = ParseUtil.parseLongOrDefault(arrayOfString[b + 1], 0L);
/*     */     }
/*     */     
/*  72 */     return arrayOfLong;
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
/*     */   public static long[][] getProcessorCpuLoadTicks(int paramInt) {
/*  84 */     long[][] arrayOfLong = new long[paramInt][(CentralProcessor.TickType.values()).length];
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  89 */     byte b = 0;
/*  90 */     List list = FileUtil.readFile(ProcPath.STAT);
/*  91 */     for (String str : list) {
/*  92 */       if (str.startsWith("cpu") && !str.startsWith("cpu ")) {
/*     */ 
/*     */ 
/*     */         
/*  96 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*  97 */         if (arrayOfString.length <= CentralProcessor.TickType.IDLE.getIndex())
/*     */         {
/*  99 */           return arrayOfLong;
/*     */         }
/*     */         
/* 102 */         for (byte b1 = 0; b1 < (CentralProcessor.TickType.values()).length; b1++) {
/* 103 */           arrayOfLong[b][b1] = ParseUtil.parseLongOrDefault(arrayOfString[b1 + 1], 0L);
/*     */         }
/*     */         
/* 106 */         if (++b >= paramInt) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */     } 
/* 111 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getContextSwitches() {
/* 120 */     List list = FileUtil.readFile(ProcPath.STAT);
/* 121 */     for (String str : list) {
/* 122 */       if (str.startsWith("ctxt ")) {
/* 123 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 124 */         if (arrayOfString.length == 2) {
/* 125 */           return ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*     */         }
/*     */       } 
/*     */     } 
/* 129 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getInterrupts() {
/* 138 */     List list = FileUtil.readFile(ProcPath.STAT);
/* 139 */     for (String str : list) {
/* 140 */       if (str.startsWith("intr ")) {
/* 141 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 142 */         if (arrayOfString.length > 2) {
/* 143 */           return ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*     */         }
/*     */       } 
/*     */     } 
/* 147 */     return 0L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long getBootTime() {
/* 157 */     List list = FileUtil.readFile(ProcPath.STAT);
/* 158 */     for (String str : list) {
/* 159 */       if (str.startsWith("btime")) {
/* 160 */         String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 161 */         return ParseUtil.parseLongOrDefault(arrayOfString[1], 0L);
/*     */       } 
/*     */     } 
/* 164 */     return 0L;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\CpuStat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */