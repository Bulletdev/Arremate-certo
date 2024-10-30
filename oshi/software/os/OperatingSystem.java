/*     */ package oshi.software.os;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.Who;
/*     */ import oshi.driver.unix.Xwininfo;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.Util;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public interface OperatingSystem
/*     */ {
/*     */   String getFamily();
/*     */   
/*     */   String getManufacturer();
/*     */   
/*     */   OSVersionInfo getVersionInfo();
/*     */   
/*     */   FileSystem getFileSystem();
/*     */   
/*     */   InternetProtocolStats getInternetProtocolStats();
/*     */   
/*     */   @Deprecated
/*     */   public enum ProcessSort
/*     */   {
/*  61 */     CPU, MEMORY, OLDEST, NEWEST, PID, PARENTPID, NAME;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class ProcessFiltering
/*     */   {
/*     */     public static final Predicate<OSProcess> ALL_PROCESSES = param1OSProcess -> true;
/*     */ 
/*     */     
/*     */     public static final Predicate<OSProcess> VALID_PROCESS;
/*     */     
/*     */     public static final Predicate<OSProcess> NO_PARENT;
/*     */     
/*     */     public static final Predicate<OSProcess> BITNESS_64;
/*     */     
/*     */     public static final Predicate<OSProcess> BITNESS_32;
/*     */ 
/*     */     
/*     */     static {
/*  81 */       VALID_PROCESS = (param1OSProcess -> !param1OSProcess.getState().equals(OSProcess.State.INVALID));
/*     */ 
/*     */ 
/*     */       
/*  85 */       NO_PARENT = (param1OSProcess -> (param1OSProcess.getParentProcessID() == param1OSProcess.getProcessID()));
/*     */ 
/*     */ 
/*     */       
/*  89 */       BITNESS_64 = (param1OSProcess -> (param1OSProcess.getBitness() == 64));
/*     */ 
/*     */ 
/*     */       
/*  93 */       BITNESS_32 = (param1OSProcess -> (param1OSProcess.getBitness() == 32));
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
/*     */   public static final class ProcessSorting
/*     */   {
/*     */     public static final Comparator<OSProcess> NO_SORTING = (param1OSProcess1, param1OSProcess2) -> 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     public static final Comparator<OSProcess> CPU_DESC = Comparator.<OSProcess>comparingDouble(OSProcess::getProcessCpuLoadCumulative).reversed();
/*     */ 
/*     */ 
/*     */     
/* 118 */     public static final Comparator<OSProcess> RSS_DESC = Comparator.<OSProcess>comparingLong(OSProcess::getResidentSetSize)
/* 119 */       .reversed();
/*     */ 
/*     */ 
/*     */     
/* 123 */     public static final Comparator<OSProcess> UPTIME_ASC = Comparator.comparingLong(OSProcess::getUpTime);
/*     */ 
/*     */ 
/*     */     
/* 127 */     public static final Comparator<OSProcess> UPTIME_DESC = UPTIME_ASC.reversed();
/*     */ 
/*     */ 
/*     */     
/* 131 */     public static final Comparator<OSProcess> PID_ASC = Comparator.comparingInt(OSProcess::getProcessID);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 136 */     public static final Comparator<OSProcess> PARENTPID_ASC = Comparator.comparingInt(OSProcess::getParentProcessID);
/*     */ 
/*     */ 
/*     */     
/* 140 */     public static final Comparator<OSProcess> NAME_ASC = Comparator.comparing(OSProcess::getName, String.CASE_INSENSITIVE_ORDER);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private static Comparator<OSProcess> convertSortToComparator(OperatingSystem.ProcessSort param1ProcessSort) {
/*     */       // Byte code:
/*     */       //   0: aload_0
/*     */       //   1: ifnull -> 114
/*     */       //   4: getstatic oshi/software/os/OperatingSystem$1.$SwitchMap$oshi$software$os$OperatingSystem$ProcessSort : [I
/*     */       //   7: aload_0
/*     */       //   8: invokevirtual ordinal : ()I
/*     */       //   11: iaload
/*     */       //   12: tableswitch default -> 84, 1 -> 56, 2 -> 60, 3 -> 64, 4 -> 68, 5 -> 72, 6 -> 76, 7 -> 80
/*     */       //   56: getstatic oshi/software/os/OperatingSystem$ProcessSorting.CPU_DESC : Ljava/util/Comparator;
/*     */       //   59: areturn
/*     */       //   60: getstatic oshi/software/os/OperatingSystem$ProcessSorting.RSS_DESC : Ljava/util/Comparator;
/*     */       //   63: areturn
/*     */       //   64: getstatic oshi/software/os/OperatingSystem$ProcessSorting.UPTIME_DESC : Ljava/util/Comparator;
/*     */       //   67: areturn
/*     */       //   68: getstatic oshi/software/os/OperatingSystem$ProcessSorting.UPTIME_ASC : Ljava/util/Comparator;
/*     */       //   71: areturn
/*     */       //   72: getstatic oshi/software/os/OperatingSystem$ProcessSorting.PID_ASC : Ljava/util/Comparator;
/*     */       //   75: areturn
/*     */       //   76: getstatic oshi/software/os/OperatingSystem$ProcessSorting.PARENTPID_ASC : Ljava/util/Comparator;
/*     */       //   79: areturn
/*     */       //   80: getstatic oshi/software/os/OperatingSystem$ProcessSorting.NAME_ASC : Ljava/util/Comparator;
/*     */       //   83: areturn
/*     */       //   84: new java/lang/IllegalArgumentException
/*     */       //   87: dup
/*     */       //   88: new java/lang/StringBuilder
/*     */       //   91: dup
/*     */       //   92: invokespecial <init> : ()V
/*     */       //   95: ldc 'Unimplemented enum type: '
/*     */       //   97: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   100: aload_0
/*     */       //   101: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   104: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*     */       //   107: invokevirtual toString : ()Ljava/lang/String;
/*     */       //   110: invokespecial <init> : (Ljava/lang/String;)V
/*     */       //   113: athrow
/*     */       //   114: getstatic oshi/software/os/OperatingSystem$ProcessSorting.NO_SORTING : Ljava/util/Comparator;
/*     */       //   117: areturn
/*     */       // Line number table:
/*     */       //   Java source line number -> byte code offset
/*     */       //   #152	-> 0
/*     */       //   #153	-> 4
/*     */       //   #155	-> 56
/*     */       //   #157	-> 60
/*     */       //   #159	-> 64
/*     */       //   #161	-> 68
/*     */       //   #163	-> 72
/*     */       //   #165	-> 76
/*     */       //   #167	-> 80
/*     */       //   #172	-> 84
/*     */       //   #175	-> 114
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default List<OSProcess> getProcesses() {
/* 224 */     return getProcesses(null, null, 0);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<OSProcess> getProcesses(Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   default List<OSProcess> getProcesses(int paramInt, ProcessSort paramProcessSort) {
/* 271 */     return getProcesses(null, ProcessSorting.convertSortToComparator(paramProcessSort), paramInt);
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
/*     */   default List<OSProcess> getProcesses(Collection<Integer> paramCollection) {
/* 284 */     return (List<OSProcess>)paramCollection.stream().map(this::getProcess).filter(Objects::nonNull).filter(ProcessFiltering.VALID_PROCESS)
/* 285 */       .collect(Collectors.toList());
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
/*     */   OSProcess getProcess(int paramInt);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   default List<OSProcess> getChildProcesses(int paramInt1, int paramInt2, ProcessSort paramProcessSort) {
/* 322 */     return getChildProcesses(paramInt1, null, ProcessSorting.convertSortToComparator(paramProcessSort), paramInt2);
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
/*     */   List<OSProcess> getChildProcesses(int paramInt1, Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   List<OSProcess> getDescendantProcesses(int paramInt1, Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt2);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getProcessId();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getProcessCount();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getThreadCount();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int getBitness();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getSystemUptime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   long getSystemBootTime();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default boolean isElevated() {
/* 430 */     return (0 == ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("id -u"), -1));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   NetworkParams getNetworkParams();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default OSService[] getServices() {
/* 447 */     return new OSService[0];
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
/*     */ 
/*     */ 
/*     */   
/*     */   default List<OSSession> getSessions() {
/* 469 */     return Who.queryWho();
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   default List<OSDesktopWindow> getDesktopWindows(boolean paramBoolean) {
/* 494 */     return Xwininfo.queryXWindows(paramBoolean);
/*     */   }
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class OSVersionInfo
/*     */   {
/*     */     private final String version;
/*     */     
/*     */     private final String codeName;
/*     */     
/*     */     private final String buildNumber;
/*     */     
/*     */     private final String versionStr;
/*     */     
/*     */     public OSVersionInfo(String param1String1, String param1String2, String param1String3) {
/* 510 */       if ("10".equals(param1String1) && param1String3.compareTo("22000") >= 0) {
/* 511 */         this.version = "11";
/*     */       } else {
/* 513 */         this.version = param1String1;
/*     */       } 
/* 515 */       this.codeName = param1String2;
/* 516 */       this.buildNumber = param1String3;
/*     */       
/* 518 */       StringBuilder stringBuilder = new StringBuilder((getVersion() != null) ? getVersion() : "unknown");
/* 519 */       if (!Util.isBlank(getCodeName())) {
/* 520 */         stringBuilder.append(" (").append(getCodeName()).append(')');
/*     */       }
/* 522 */       if (!Util.isBlank(getBuildNumber())) {
/* 523 */         stringBuilder.append(" build ").append(getBuildNumber());
/*     */       }
/* 525 */       this.versionStr = stringBuilder.toString();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getVersion() {
/* 534 */       return this.version;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCodeName() {
/* 543 */       return this.codeName;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getBuildNumber() {
/* 552 */       return this.buildNumber;
/*     */     }
/*     */ 
/*     */     
/*     */     public String toString() {
/* 557 */       return this.versionStr;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\os\OperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */