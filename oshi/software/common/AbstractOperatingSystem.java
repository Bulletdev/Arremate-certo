/*     */ package oshi.software.common;
/*     */ 
/*     */ import com.sun.jna.Platform;
/*     */ import java.util.ArrayDeque;
/*     */ import java.util.Collection;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.function.Predicate;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.stream.Collectors;
/*     */ import oshi.software.os.OSProcess;
/*     */ import oshi.software.os.OperatingSystem;
/*     */ import oshi.util.GlobalConfig;
/*     */ import oshi.util.Memoizer;
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
/*     */ public abstract class AbstractOperatingSystem
/*     */   implements OperatingSystem
/*     */ {
/*     */   public static final String OSHI_OS_UNIX_WHOCOMMAND = "oshi.os.unix.whoCommand";
/*  56 */   protected static final boolean USE_WHO_COMMAND = GlobalConfig.get("oshi.os.unix.whoCommand", false);
/*     */   
/*  58 */   private final Supplier<String> manufacturer = Memoizer.memoize(this::queryManufacturer);
/*  59 */   private final Supplier<Pair<String, OperatingSystem.OSVersionInfo>> familyVersionInfo = Memoizer.memoize(this::queryFamilyVersionInfo);
/*  60 */   private final Supplier<Integer> bitness = Memoizer.memoize(this::queryPlatformBitness);
/*     */ 
/*     */   
/*     */   public String getManufacturer() {
/*  64 */     return this.manufacturer.get();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getFamily() {
/*  71 */     return (String)((Pair)this.familyVersionInfo.get()).getA();
/*     */   }
/*     */ 
/*     */   
/*     */   public OperatingSystem.OSVersionInfo getVersionInfo() {
/*  76 */     return (OperatingSystem.OSVersionInfo)((Pair)this.familyVersionInfo.get()).getB();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBitness() {
/*  83 */     return ((Integer)this.bitness.get()).intValue();
/*     */   }
/*     */   
/*     */   private int queryPlatformBitness() {
/*  87 */     if (Platform.is64Bit()) {
/*  88 */       return 64;
/*     */     }
/*     */ 
/*     */     
/*  92 */     byte b = (System.getProperty("os.arch").indexOf("64") != -1) ? 64 : 32;
/*  93 */     return queryBitness(b);
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
/*     */   public List<OSProcess> getProcesses(Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt) {
/* 107 */     return (List<OSProcess>)queryAllProcesses().stream().filter((paramPredicate == null) ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : paramPredicate)
/* 108 */       .sorted((paramComparator == null) ? OperatingSystem.ProcessSorting.NO_SORTING : paramComparator).limit((paramInt > 0) ? paramInt : Long.MAX_VALUE)
/* 109 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSProcess> getChildProcesses(int paramInt1, Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt2) {
/* 118 */     List<OSProcess> list = queryChildProcesses(paramInt1);
/*     */     
/* 120 */     OSProcess oSProcess = list.stream().filter(paramOSProcess -> (paramOSProcess.getParentProcessID() == paramInt)).findAny().orElse(null);
/*     */     
/* 122 */     long l = (oSProcess == null) ? 0L : oSProcess.getStartTime();
/*     */     
/* 124 */     return (List<OSProcess>)queryChildProcesses(paramInt1).stream().filter((paramPredicate == null) ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : paramPredicate)
/* 125 */       .filter(paramOSProcess -> (paramOSProcess.getProcessID() != paramInt && paramOSProcess.getStartTime() >= paramLong))
/* 126 */       .sorted((paramComparator == null) ? OperatingSystem.ProcessSorting.NO_SORTING : paramComparator).limit((paramInt2 > 0) ? paramInt2 : Long.MAX_VALUE)
/* 127 */       .collect(Collectors.toList());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<OSProcess> getDescendantProcesses(int paramInt1, Predicate<OSProcess> paramPredicate, Comparator<OSProcess> paramComparator, int paramInt2) {
/* 136 */     List<OSProcess> list = queryDescendantProcesses(paramInt1);
/*     */ 
/*     */     
/* 139 */     OSProcess oSProcess = list.stream().filter(paramOSProcess -> (paramOSProcess.getParentProcessID() == paramInt)).findAny().orElse(null);
/*     */     
/* 141 */     long l = (oSProcess == null) ? 0L : oSProcess.getStartTime();
/*     */     
/* 143 */     return (List<OSProcess>)queryDescendantProcesses(paramInt1).stream().filter((paramPredicate == null) ? OperatingSystem.ProcessFiltering.ALL_PROCESSES : paramPredicate)
/* 144 */       .filter(paramOSProcess -> (paramOSProcess.getProcessID() != paramInt && paramOSProcess.getStartTime() >= paramLong))
/* 145 */       .sorted((paramComparator == null) ? OperatingSystem.ProcessSorting.NO_SORTING : paramComparator).limit((paramInt2 > 0) ? paramInt2 : Long.MAX_VALUE)
/* 146 */       .collect(Collectors.toList());
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
/*     */   protected static Set<Integer> getChildrenOrDescendants(Collection<OSProcess> paramCollection, int paramInt, boolean paramBoolean) {
/* 168 */     Map<Integer, Integer> map = (Map)paramCollection.stream().collect(Collectors.toMap(OSProcess::getProcessID, OSProcess::getParentProcessID));
/* 169 */     return getChildrenOrDescendants(map, paramInt, paramBoolean);
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
/*     */   protected static Set<Integer> getChildrenOrDescendants(Map<Integer, Integer> paramMap, int paramInt, boolean paramBoolean) {
/* 189 */     HashSet<Integer> hashSet = new HashSet();
/* 190 */     hashSet.add(Integer.valueOf(paramInt));
/*     */     
/* 192 */     ArrayDeque<Integer> arrayDeque = new ArrayDeque();
/* 193 */     arrayDeque.add(Integer.valueOf(paramInt));
/*     */     
/*     */     do {
/* 196 */       for (Iterator<Integer> iterator = getChildren(paramMap, ((Integer)arrayDeque.poll()).intValue()).iterator(); iterator.hasNext(); ) { int i = ((Integer)iterator.next()).intValue();
/* 197 */         if (!hashSet.contains(Integer.valueOf(i))) {
/* 198 */           hashSet.add(Integer.valueOf(i));
/* 199 */           arrayDeque.add(Integer.valueOf(i));
/*     */         }  }
/*     */     
/* 202 */     } while (paramBoolean && !arrayDeque.isEmpty());
/* 203 */     return hashSet;
/*     */   }
/*     */   
/*     */   private static Set<Integer> getChildren(Map<Integer, Integer> paramMap, int paramInt) {
/* 207 */     return (Set<Integer>)paramMap.entrySet().stream()
/* 208 */       .filter(paramEntry -> (((Integer)paramEntry.getValue()).equals(Integer.valueOf(paramInt)) && !((Integer)paramEntry.getKey()).equals(Integer.valueOf(paramInt)))).map(Map.Entry::getKey)
/* 209 */       .collect(Collectors.toSet());
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 214 */     StringBuilder stringBuilder = new StringBuilder();
/* 215 */     stringBuilder.append(getManufacturer()).append(' ').append(getFamily()).append(' ').append(getVersionInfo());
/* 216 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   protected abstract String queryManufacturer();
/*     */   
/*     */   protected abstract Pair<String, OperatingSystem.OSVersionInfo> queryFamilyVersionInfo();
/*     */   
/*     */   protected abstract int queryBitness(int paramInt);
/*     */   
/*     */   protected abstract List<OSProcess> queryAllProcesses();
/*     */   
/*     */   protected abstract List<OSProcess> queryChildProcesses(int paramInt);
/*     */   
/*     */   protected abstract List<OSProcess> queryDescendantProcesses(int paramInt);
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\software\common\AbstractOperatingSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */