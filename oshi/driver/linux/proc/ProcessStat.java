/*     */ package oshi.driver.linux.proc;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.Arrays;
/*     */ import java.util.EnumMap;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.util.FileUtil;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.linux.ProcPath;
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
/*     */ @ThreadSafe
/*     */ public final class ProcessStat
/*     */ {
/*  56 */   private static final Pattern DIGITS = Pattern.compile("\\d+");
/*  57 */   private static final Pattern SOCKET = Pattern.compile("socket:\\[(\\d+)\\]");
/*     */ 
/*     */   
/*     */   public static final int PROC_PID_STAT_LENGTH;
/*     */ 
/*     */ 
/*     */   
/*     */   public enum PidStat
/*     */   {
/*  66 */     PID,
/*     */ 
/*     */ 
/*     */     
/*  70 */     COMM,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  98 */     STATE,
/*     */ 
/*     */ 
/*     */     
/* 102 */     PPID,
/*     */ 
/*     */ 
/*     */     
/* 106 */     PGRP,
/*     */ 
/*     */ 
/*     */     
/* 110 */     SESSION,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 116 */     TTY_NR,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 121 */     PTGID,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 127 */     FLAGS,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 132 */     MINFLT,
/*     */ 
/*     */ 
/*     */     
/* 136 */     CMINFLT,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     MAJFLT,
/*     */ 
/*     */ 
/*     */     
/* 145 */     CMAJFLT,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 152 */     UTIME,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     STIME,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 163 */     CUTIME,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 168 */     CSTIME,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 178 */     PRIORITY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 183 */     NICE,
/*     */ 
/*     */ 
/*     */     
/* 187 */     NUM_THREADS,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 193 */     ITREALVALUE,
/*     */ 
/*     */ 
/*     */     
/* 197 */     STARTTIME,
/*     */ 
/*     */ 
/*     */     
/* 201 */     VSIZE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 207 */     RSS,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 212 */     RSSLIM,
/*     */ 
/*     */ 
/*     */     
/* 216 */     STARTCODE,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 221 */     ENDCODE,
/*     */ 
/*     */ 
/*     */     
/* 225 */     STARTSTACK,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     KSTKESP,
/*     */ 
/*     */ 
/*     */     
/* 234 */     KSTKEIP,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 240 */     SIGNAL,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 246 */     BLOCKED,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 252 */     SIGIGNORE,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 258 */     SIGCATCH,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 264 */     WCHAN,
/*     */ 
/*     */ 
/*     */     
/* 268 */     NSWAP,
/*     */ 
/*     */ 
/*     */     
/* 272 */     CNSWAP,
/*     */ 
/*     */ 
/*     */     
/* 276 */     EXIT_SIGNAL,
/*     */ 
/*     */ 
/*     */     
/* 280 */     PROCESSOR,
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 286 */     RT_PRIORITY,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 291 */     POLICY,
/*     */ 
/*     */ 
/*     */     
/* 295 */     DELAYACCT_BLKIO_TICKS,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 300 */     GUEST_TIME,
/*     */ 
/*     */ 
/*     */     
/* 304 */     CGUEST_TIME,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 309 */     START_DATA,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     END_DATA,
/*     */ 
/*     */ 
/*     */     
/* 318 */     START_BRK,
/*     */ 
/*     */ 
/*     */     
/* 322 */     ARG_START,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 327 */     ARG_END,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     ENV_START,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     ENV_END,
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 342 */     EXIT_CODE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public enum PidStatM
/*     */   {
/* 352 */     SIZE,
/*     */ 
/*     */ 
/*     */     
/* 356 */     RESIDENT,
/*     */ 
/*     */ 
/*     */     
/* 360 */     SHARED,
/*     */ 
/*     */ 
/*     */     
/* 364 */     TEXT,
/*     */ 
/*     */ 
/*     */     
/* 368 */     LIB,
/*     */ 
/*     */ 
/*     */     
/* 372 */     DATA,
/*     */ 
/*     */ 
/*     */     
/* 376 */     DT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/* 385 */     String str = FileUtil.getStringFromFile(ProcPath.SELF_STAT);
/* 386 */     if (!str.isEmpty() && str.contains(")")) {
/*     */       
/* 388 */       PROC_PID_STAT_LENGTH = ParseUtil.countStringToLongArray(str, ' ') + 3;
/*     */     } else {
/*     */       
/* 391 */       PROC_PID_STAT_LENGTH = 52;
/*     */     } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Triplet<String, Character, Map<PidStat, Long>> getPidStats(int paramInt) {
/* 411 */     String str1 = FileUtil.getStringFromFile(String.format(ProcPath.PID_STAT, new Object[] { Integer.valueOf(paramInt) }));
/* 412 */     if (str1.isEmpty())
/*     */     {
/* 414 */       return null;
/*     */     }
/*     */     
/* 417 */     int i = str1.indexOf('(') + 1;
/* 418 */     int j = str1.indexOf(')');
/* 419 */     String str2 = str1.substring(i, j);
/* 420 */     Character character = Character.valueOf(str1.charAt(j + 2));
/*     */     
/* 422 */     String[] arrayOfString = ParseUtil.whitespaces.split(str1.substring(j + 4).trim());
/*     */     
/* 424 */     EnumMap<PidStat, Object> enumMap = new EnumMap<>(PidStat.class);
/* 425 */     PidStat[] arrayOfPidStat = PidStat.class.getEnumConstants();
/* 426 */     for (byte b = 3; b < arrayOfPidStat.length && b - 3 < arrayOfString.length; b++) {
/* 427 */       enumMap.put(arrayOfPidStat[b], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[b - 3], 0L)));
/*     */     }
/* 429 */     return new Triplet(str2, character, enumMap);
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
/*     */   public static Map<PidStatM, Long> getPidStatM(int paramInt) {
/* 443 */     String str = FileUtil.getStringFromFile(String.format(ProcPath.PID_STATM, new Object[] { Integer.valueOf(paramInt) }));
/* 444 */     if (str.isEmpty())
/*     */     {
/* 446 */       return null;
/*     */     }
/*     */     
/* 449 */     String[] arrayOfString = ParseUtil.whitespaces.split(str);
/*     */     
/* 451 */     EnumMap<PidStatM, Object> enumMap = new EnumMap<>(PidStatM.class);
/* 452 */     PidStatM[] arrayOfPidStatM = PidStatM.class.getEnumConstants();
/* 453 */     for (byte b = 0; b < arrayOfPidStatM.length && b < arrayOfString.length; b++) {
/* 454 */       enumMap.put(arrayOfPidStatM[b], Long.valueOf(ParseUtil.parseLongOrDefault(arrayOfString[b], 0L)));
/*     */     }
/* 456 */     return (Map)enumMap;
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
/*     */   public static File[] getFileDescriptorFiles(int paramInt) {
/* 468 */     return listNumericFiles(String.format(ProcPath.PID_FD, new Object[] { Integer.valueOf(paramInt) }));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static File[] getPidFiles() {
/* 478 */     return listNumericFiles(ProcPath.PROC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Map<Integer, Integer> querySocketToPidMap() {
/* 487 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 488 */     for (File file : getPidFiles()) {
/* 489 */       int i = ParseUtil.parseIntOrDefault(file.getName(), -1);
/* 490 */       File[] arrayOfFile = getFileDescriptorFiles(i);
/* 491 */       for (File file1 : arrayOfFile) {
/* 492 */         String str = FileUtil.readSymlinkTarget(file1);
/* 493 */         if (str != null) {
/* 494 */           Matcher matcher = SOCKET.matcher(str);
/* 495 */           if (matcher.matches()) {
/* 496 */             hashMap.put(Integer.valueOf(ParseUtil.parseIntOrDefault(matcher.group(1), -1)), Integer.valueOf(i));
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 501 */     return (Map)hashMap;
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
/*     */   public static List<Integer> getThreadIds(int paramInt) {
/* 513 */     File[] arrayOfFile = listNumericFiles(String.format(ProcPath.TASK_PATH, new Object[] { Integer.valueOf(paramInt) }));
/* 514 */     return (List<Integer>)Arrays.<File>stream(arrayOfFile).map(paramFile -> Integer.valueOf(ParseUtil.parseIntOrDefault(paramFile.getName(), 0)))
/* 515 */       .filter(paramInteger -> (paramInteger.intValue() != paramInt)).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private static File[] listNumericFiles(String paramString) {
/* 519 */     File file = new File(paramString);
/* 520 */     File[] arrayOfFile = file.listFiles(paramFile -> DIGITS.matcher(paramFile.getName()).matches());
/* 521 */     return (arrayOfFile == null) ? new File[0] : arrayOfFile;
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
/*     */   public static OSProcess.State getState(char paramChar) {
/* 534 */     switch (paramChar)
/*     */     { case 'R':
/* 536 */         state = OSProcess.State.RUNNING;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 554 */         return state;case 'S': state = OSProcess.State.SLEEPING; return state;case 'D': state = OSProcess.State.WAITING; return state;case 'Z': state = OSProcess.State.ZOMBIE; return state;case 'T': state = OSProcess.State.STOPPED; return state; }  OSProcess.State state = OSProcess.State.OTHER; return state;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\linux\proc\ProcessStat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */