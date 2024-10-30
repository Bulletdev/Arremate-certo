/*     */ package oshi.software.os.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.linux.proc.ProcessStat;
/*     */ import oshi.driver.unix.solaris.Who;
/*     */ import oshi.jna.platform.unix.solaris.SolarisLibc;
/*     */ import oshi.software.common.AbstractOperatingSystem;
/*     */ import oshi.software.os.FileSystem;
/*     */ import oshi.software.os.InternetProtocolStats;
/*     */ import oshi.software.os.NetworkParams;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OSService;
/*     */ import oshi.software.os.OSSession;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
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
/*     */ @ThreadSafe
/*     */ public class SolarisOperatingSystem
/*     */   extends AbstractOperatingSystem
/*     */ {
/*     */   enum PsKeywords
/*     */   {
/*  69 */     S, PID, PPID, USER, UID, GROUP, GID, NLWP, PRI, VSZ, RSS, ETIME, TIME, COMM, ARGS;
/*     */   }
/*     */   
/*  72 */   static final String PS_COMMAND_ARGS = Arrays.<PsKeywords>stream(PsKeywords.values()).map(Enum::name).map(String::toLowerCase)
/*  73 */     .collect(Collectors.joining(","));
/*     */   
/*     */   enum PrstatKeywords {
/*  76 */     PID, USERNAME, USR, SYS, TRP, TFL, DFL, LCK, SLP, LAT, VCX, ICX, SCL, SIG, PROCESS_NLWP;
/*     */   }
/*     */   
/*  79 */   private static final long BOOTTIME = querySystemBootTime();
/*     */ 
/*     */   
/*     */   public String queryManufacturer() {
/*  83 */     return "Oracle";
/*     */   }
/*     */ 
/*     */   
/*     */   public Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo() {
/*  88 */     String[] arrayOfString = ParseUtil.whitespaces.split(ExecutingCommand.getFirstAnswer("uname -rv"));
/*  89 */     String str1 = arrayOfString[0];
/*  90 */     String str2 = null;
/*  91 */     if (arrayOfString.length > 1) {
/*  92 */       str2 = arrayOfString[1];
/*     */     }
/*  94 */     return new Pair("SunOS", new OperatingSystem.OSVersionInfo(str1, "Solaris", str2));
/*     */   }
/*     */ 
/*     */   
/*     */   protected int queryBitness(int paramInt) {
/*  99 */     if (paramInt == 64) {
/* 100 */       return 64;
/*     */     }
/* 102 */     return ParseUtil.parseIntOrDefault(ExecutingCommand.getFirstAnswer("isainfo -b"), 32);
/*     */   }
/*     */ 
/*     */   
/*     */   public FileSystem getFileSystem() {
/* 107 */     return (FileSystem)new SolarisFileSystem();
/*     */   }
/*     */ 
/*     */   
/*     */   public InternetProtocolStats getInternetProtocolStats() {
/* 112 */     return (InternetProtocolStats)new SolarisInternetProtocolStats();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSSession> getSessions() {
/* 117 */     return USE_WHO_COMMAND ? super.getSessions() : Who.queryUtxent();
/*     */   }
/*     */ 
/*     */   
/*     */   public OSProcess getProcess(int paramInt) {
/* 122 */     List<OSProcess> list = getProcessListFromPS("ps -o " + PS_COMMAND_ARGS + " -p " + paramInt, paramInt);
/* 123 */     if (list.isEmpty()) {
/* 124 */       return null;
/*     */     }
/* 126 */     return list.get(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryAllProcesses() {
/* 131 */     return queryAllProcessesFromPS();
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryChildProcesses(int paramInt) {
/* 136 */     List<OSProcess> list = queryAllProcessesFromPS();
/* 137 */     Set set = getChildrenOrDescendants(list, paramInt, false);
/* 138 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */   
/*     */   public List<OSProcess> queryDescendantProcesses(int paramInt) {
/* 143 */     List<OSProcess> list = queryAllProcessesFromPS();
/* 144 */     Set set = getChildrenOrDescendants(list, paramInt, true);
/* 145 */     return (List<OSProcess>)list.stream().filter(paramOSProcess -> paramSet.contains(Integer.valueOf(paramOSProcess.getProcessID()))).collect(Collectors.toList());
/*     */   }
/*     */   
/*     */   private static List<OSProcess> queryAllProcessesFromPS() {
/* 149 */     return getProcessListFromPS("ps -eo " + PS_COMMAND_ARGS, -1);
/*     */   }
/*     */   
/*     */   private static List<OSProcess> getProcessListFromPS(String paramString, int paramInt) {
/* 153 */     ArrayList<SolarisOSProcess> arrayList = new ArrayList();
/* 154 */     List list = ExecutingCommand.runNative(paramString);
/* 155 */     if (list.size() > 1) {
/*     */ 
/*     */       
/* 158 */       List list1 = (paramInt < 0) ? ExecutingCommand.runNative("prstat -v 1 1") : ExecutingCommand.runNative("prstat -v -p " + paramInt + " 1 1");
/* 159 */       HashMap<Object, Object> hashMap = new HashMap<>();
/* 160 */       for (String str1 : list1) {
/* 161 */         String str2 = str1.trim();
/* 162 */         int i = str2.indexOf(' ');
/* 163 */         if (i > 0) {
/* 164 */           hashMap.put(str2.substring(0, i), str2);
/*     */         }
/*     */       } 
/*     */       
/* 168 */       list.remove(0);
/* 169 */       for (String str : list) {
/* 170 */         Map<PsKeywords, String> map = ParseUtil.stringToEnumMap(PsKeywords.class, str.trim(), ' ');
/*     */         
/* 172 */         if (map.containsKey(PsKeywords.ARGS)) {
/* 173 */           String str1 = (String)map.get(PsKeywords.PID);
/* 174 */           Map<PrstatKeywords, String> map1 = ParseUtil.stringToEnumMap(PrstatKeywords.class, (String)hashMap
/* 175 */               .getOrDefault(str1, ""), ' ');
/* 176 */           arrayList.add(new SolarisOSProcess((paramInt < 0) ? ParseUtil.parseIntOrDefault(str1, 0) : paramInt, map, map1));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessId() {
/* 186 */     return SolarisLibc.INSTANCE.getpid();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getProcessCount() {
/* 191 */     return (ProcessStat.getPidFiles()).length;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getThreadCount() {
/* 196 */     List list = ExecutingCommand.runNative("ps -eLo pid");
/* 197 */     if (!list.isEmpty())
/*     */     {
/* 199 */       return list.size() - 1;
/*     */     }
/* 201 */     return getProcessCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemUptime() {
/* 206 */     return querySystemUptime();
/*     */   }
/*     */   
/*     */   private static long querySystemUptime() {
/* 210 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 211 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("unix", 0, "system_misc");
/* 212 */       if (kstat != null)
/*     */       
/* 214 */       { long l = kstat.ks_snaptime / 1000000000L;
/*     */         
/* 216 */         if (kstatChain != null) kstatChain.close();  return l; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 217 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getSystemBootTime() {
/* 222 */     return BOOTTIME;
/*     */   }
/*     */   
/*     */   private static long querySystemBootTime() {
/* 226 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 227 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("unix", 0, "system_misc");
/* 228 */       if (kstat != null && KstatUtil.KstatChain.read(kstat))
/* 229 */       { long l = KstatUtil.dataLookupLong(kstat, "boot_time");
/*     */         
/* 231 */         if (kstatChain != null) kstatChain.close();  return l; }  if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 232 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return System.currentTimeMillis() / 1000L - querySystemUptime();
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkParams getNetworkParams() {
/* 237 */     return (NetworkParams)new SolarisNetworkParams();
/*     */   }
/*     */ 
/*     */   
/*     */   public OSService[] getServices() {
/* 242 */     ArrayList<OSService> arrayList = new ArrayList();
/*     */     
/* 244 */     ArrayList<String> arrayList1 = new ArrayList();
/* 245 */     File file = new File("/etc/init.d");
/*     */     File[] arrayOfFile;
/* 247 */     if (file.exists() && file.isDirectory() && (arrayOfFile = file.listFiles()) != null) {
/* 248 */       for (File file1 : arrayOfFile) {
/* 249 */         arrayList1.add(file1.getName());
/*     */       }
/*     */     }
/*     */     
/* 253 */     List list = ExecutingCommand.runNative("svcs -p");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 265 */     for (String str : list) {
/* 266 */       if (str.startsWith("online")) {
/* 267 */         int i = str.lastIndexOf(":/");
/* 268 */         if (i > 0) {
/* 269 */           String str1 = str.substring(i + 1);
/* 270 */           if (str1.endsWith(":default")) {
/* 271 */             str1 = str1.substring(0, str1.length() - 8);
/*     */           }
/* 273 */           arrayList.add(new OSService(str1, 0, OSService.State.STOPPED));
/*     */         }  continue;
/* 275 */       }  if (str.startsWith(" ")) {
/* 276 */         String[] arrayOfString = ParseUtil.whitespaces.split(str.trim());
/* 277 */         if (arrayOfString.length == 3)
/* 278 */           arrayList.add(new OSService(arrayOfString[2], ParseUtil.parseIntOrDefault(arrayOfString[1], 0), OSService.State.RUNNING));  continue;
/*     */       } 
/* 280 */       if (str.startsWith("legacy_run")) {
/* 281 */         for (String str1 : arrayList1) {
/* 282 */           if (str.endsWith(str1)) {
/* 283 */             arrayList.add(new OSService(str1, 0, OSService.State.STOPPED));
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 289 */     return arrayList.<OSService>toArray(new OSService[0]);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\o\\unix\solaris\SolarisOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */