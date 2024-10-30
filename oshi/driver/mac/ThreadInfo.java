/*     */ package oshi.driver.mac;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.software.os.OSProcess;
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
/*     */ @ThreadSafe
/*     */ public final class ThreadInfo
/*     */ {
/*  51 */   private static final Pattern PS_M = Pattern.compile("\\D+(\\d+).+(\\d+\\.\\d)\\s+(\\w)\\s+(\\d+)\\D+(\\d+:\\d{2}\\.\\d{2})\\s+(\\d+:\\d{2}\\.\\d{2}).+");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<ThreadStats> queryTaskThreads(int paramInt) {
/*  58 */     String str = " " + paramInt + " ";
/*  59 */     ArrayList<ThreadStats> arrayList = new ArrayList();
/*     */ 
/*     */ 
/*     */     
/*  63 */     List list = (List)ExecutingCommand.runNative("ps -awwxM").stream().filter(paramString2 -> paramString2.contains(paramString1)).collect(Collectors.toList());
/*  64 */     byte b = 0;
/*  65 */     for (String str1 : list) {
/*  66 */       Matcher matcher = PS_M.matcher(str1);
/*  67 */       if (matcher.matches() && paramInt == ParseUtil.parseIntOrDefault(matcher.group(1), -1)) {
/*  68 */         double d = ParseUtil.parseDoubleOrDefault(matcher.group(2), 0.0D);
/*  69 */         char c = matcher.group(3).charAt(0);
/*  70 */         int i = ParseUtil.parseIntOrDefault(matcher.group(4), 0);
/*  71 */         long l1 = ParseUtil.parseDHMSOrDefault(matcher.group(5), 0L);
/*  72 */         long l2 = ParseUtil.parseDHMSOrDefault(matcher.group(6), 0L);
/*  73 */         arrayList.add(new ThreadStats(b++, d, c, l1, l2, i));
/*     */       } 
/*     */     } 
/*  76 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class ThreadStats
/*     */   {
/*     */     private final int threadId;
/*     */     
/*     */     private final long userTime;
/*     */     private final long systemTime;
/*     */     private final long upTime;
/*     */     private final OSProcess.State state;
/*     */     private final int priority;
/*     */     
/*     */     public ThreadStats(int param1Int1, double param1Double, char param1Char, long param1Long1, long param1Long2, int param1Int2) {
/*  92 */       this.threadId = param1Int1;
/*  93 */       this.userTime = param1Long2;
/*  94 */       this.systemTime = param1Long1;
/*     */ 
/*     */       
/*  97 */       this.upTime = (long)((param1Long2 + param1Long1) / (param1Double / 100.0D + 5.0E-4D));
/*  98 */       switch (param1Char) {
/*     */         case 'I':
/*     */         case 'S':
/* 101 */           this.state = OSProcess.State.SLEEPING;
/*     */           break;
/*     */         case 'U':
/* 104 */           this.state = OSProcess.State.WAITING;
/*     */           break;
/*     */         case 'R':
/* 107 */           this.state = OSProcess.State.RUNNING;
/*     */           break;
/*     */         case 'Z':
/* 110 */           this.state = OSProcess.State.ZOMBIE;
/*     */           break;
/*     */         case 'T':
/* 113 */           this.state = OSProcess.State.STOPPED;
/*     */           break;
/*     */         default:
/* 116 */           this.state = OSProcess.State.OTHER;
/*     */           break;
/*     */       } 
/* 119 */       this.priority = param1Int2;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getThreadId() {
/* 126 */       return this.threadId;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getUserTime() {
/* 133 */       return this.userTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getSystemTime() {
/* 140 */       return this.systemTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long getUpTime() {
/* 147 */       return this.upTime;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public OSProcess.State getState() {
/* 154 */       return this.state;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getPriority() {
/* 161 */       return this.priority;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\mac\ThreadInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */