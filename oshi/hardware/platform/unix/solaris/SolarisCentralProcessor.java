/*     */ package oshi.hardware.platform.unix.solaris;
/*     */ 
/*     */ import com.sun.jna.platform.unix.solaris.LibKstat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.hardware.CentralProcessor;
/*     */ import oshi.hardware.common.AbstractCentralProcessor;
/*     */ import oshi.jna.platform.unix.solaris.SolarisLibc;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.solaris.KstatUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ final class SolarisCentralProcessor
/*     */   extends AbstractCentralProcessor
/*     */ {
/*     */   private static final String CPU_INFO = "cpu_info";
/*     */   
/*     */   protected CentralProcessor.ProcessorIdentifier queryProcessorId() {
/*  52 */     String str1 = "";
/*  53 */     String str2 = "";
/*  54 */     String str3 = "";
/*  55 */     String str4 = "";
/*  56 */     String str5 = "";
/*  57 */     long l = 0L;
/*     */ 
/*     */     
/*  60 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/*  61 */     try { LibKstat.Kstat kstat = KstatUtil.KstatChain.lookup("cpu_info", -1, null);
/*     */       
/*  63 */       if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
/*  64 */         str1 = KstatUtil.dataLookupString(kstat, "vendor_id");
/*  65 */         str2 = KstatUtil.dataLookupString(kstat, "brand");
/*  66 */         str3 = KstatUtil.dataLookupString(kstat, "family");
/*  67 */         str4 = KstatUtil.dataLookupString(kstat, "model");
/*  68 */         str5 = KstatUtil.dataLookupString(kstat, "stepping");
/*  69 */         l = KstatUtil.dataLookupLong(kstat, "clock_MHz") * 1000000L;
/*     */       } 
/*  71 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/*  72 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  boolean bool = "64".equals(ExecutingCommand.getFirstAnswer("isainfo -b").trim());
/*  73 */     String str6 = getProcessorID(str5, str4, str3);
/*     */     
/*  75 */     return new CentralProcessor.ProcessorIdentifier(str1, str2, str3, str4, str5, str6, bool, l);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected List<CentralProcessor.LogicalProcessor> initProcessorCounts() {
/*  81 */     Map<Integer, Integer> map = mapNumaNodes();
/*  82 */     ArrayList<CentralProcessor.LogicalProcessor> arrayList = new ArrayList();
/*  83 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/*  84 */     try { List list = KstatUtil.KstatChain.lookupAll("cpu_info", -1, null);
/*     */       
/*  86 */       for (LibKstat.Kstat kstat : list) {
/*  87 */         if (kstat != null && KstatUtil.KstatChain.read(kstat)) {
/*  88 */           int i = arrayList.size();
/*  89 */           String str1 = KstatUtil.dataLookupString(kstat, "chip_id");
/*  90 */           String str2 = KstatUtil.dataLookupString(kstat, "core_id");
/*     */           
/*  92 */           CentralProcessor.LogicalProcessor logicalProcessor = new CentralProcessor.LogicalProcessor(i, ParseUtil.parseIntOrDefault(str2, 0), ParseUtil.parseIntOrDefault(str1, 0), ((Integer)map.getOrDefault(Integer.valueOf(i), Integer.valueOf(0))).intValue());
/*  93 */           arrayList.add(logicalProcessor);
/*     */         } 
/*     */       } 
/*  96 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/*  97 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  if (arrayList.isEmpty()) {
/*  98 */       arrayList.add(new CentralProcessor.LogicalProcessor(0, 0, 0));
/*     */     }
/* 100 */     return arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   private static Map<Integer, Integer> mapNumaNodes() {
/* 105 */     HashMap<Object, Object> hashMap = new HashMap<>();
/* 106 */     int i = 0;
/* 107 */     for (String str : ExecutingCommand.runNative("lgrpinfo -c leaves")) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 115 */       if (str.startsWith("lgroup")) {
/* 116 */         i = ParseUtil.getFirstIntValue(str); continue;
/* 117 */       }  if (str.contains("CPUs:") || str.contains("CPU:")) {
/* 118 */         for (Integer integer : ParseUtil.parseHyphenatedIntList(str.split(":")[1])) {
/* 119 */           hashMap.put(integer, Integer.valueOf(i));
/*     */         }
/*     */       }
/*     */     } 
/* 123 */     return (Map)hashMap;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] querySystemCpuLoadTicks() {
/* 128 */     long[] arrayOfLong = new long[(CentralProcessor.TickType.values()).length];
/*     */     
/* 130 */     long[][] arrayOfLong1 = getProcessorCpuLoadTicks();
/* 131 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 132 */       for (long[] arrayOfLong2 : arrayOfLong1) {
/* 133 */         arrayOfLong[b] = arrayOfLong[b] + arrayOfLong2[b];
/*     */       }
/* 135 */       arrayOfLong[b] = arrayOfLong[b] / arrayOfLong1.length;
/*     */     } 
/* 137 */     return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[] queryCurrentFreq() {
/* 142 */     long[] arrayOfLong = new long[getLogicalProcessorCount()];
/* 143 */     Arrays.fill(arrayOfLong, -1L);
/* 144 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 145 */     try { for (byte b = 0; b < arrayOfLong.length; b++) {
/* 146 */         for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll("cpu_info", b, null)) {
/* 147 */           if (KstatUtil.KstatChain.read(kstat)) {
/* 148 */             arrayOfLong[b] = KstatUtil.dataLookupLong(kstat, "current_clock_Hz");
/*     */           }
/*     */         } 
/*     */       } 
/* 152 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 153 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return arrayOfLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryMaxFreq() {
/* 158 */     long l = -1L;
/* 159 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 160 */     try { for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll("cpu_info", 0, null)) {
/* 161 */         if (KstatUtil.KstatChain.read(kstat)) {
/* 162 */           String str = KstatUtil.dataLookupString(kstat, "supported_frequencies_Hz");
/* 163 */           if (!str.isEmpty()) {
/* 164 */             for (String str1 : str.split(":")) {
/* 165 */               long l1 = ParseUtil.parseLongOrDefault(str1, -1L);
/* 166 */               if (l < l1) {
/* 167 */                 l = l1;
/*     */               }
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/* 173 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 174 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public double[] getSystemLoadAverage(int paramInt) {
/* 179 */     if (paramInt < 1 || paramInt > 3) {
/* 180 */       throw new IllegalArgumentException("Must include from one to three elements.");
/*     */     }
/* 182 */     double[] arrayOfDouble = new double[paramInt];
/* 183 */     int i = SolarisLibc.INSTANCE.getloadavg(arrayOfDouble, paramInt);
/* 184 */     if (i < paramInt) {
/* 185 */       for (int j = Math.max(i, 0); j < arrayOfDouble.length; j++) {
/* 186 */         arrayOfDouble[j] = -1.0D;
/*     */       }
/*     */     }
/* 189 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public long[][] queryProcessorCpuLoadTicks() {
/* 194 */     long[][] arrayOfLong = new long[getLogicalProcessorCount()][(CentralProcessor.TickType.values()).length];
/* 195 */     byte b = -1;
/* 196 */     KstatUtil.KstatChain kstatChain = KstatUtil.openChain(); 
/* 197 */     try { for (LibKstat.Kstat kstat : KstatUtil.KstatChain.lookupAll("cpu", -1, "sys")) {
/*     */         
/* 199 */         if (++b >= arrayOfLong.length) {
/*     */           break;
/*     */         }
/*     */         
/* 203 */         if (KstatUtil.KstatChain.read(kstat)) {
/* 204 */           arrayOfLong[b][CentralProcessor.TickType.IDLE.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_idle");
/* 205 */           arrayOfLong[b][CentralProcessor.TickType.SYSTEM.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_kernel");
/* 206 */           arrayOfLong[b][CentralProcessor.TickType.USER.getIndex()] = KstatUtil.dataLookupLong(kstat, "cpu_ticks_user");
/*     */         } 
/*     */       } 
/* 209 */       if (kstatChain != null) kstatChain.close();  } catch (Throwable throwable) { if (kstatChain != null)
/* 210 */         try { kstatChain.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }   throw throwable; }  return arrayOfLong;
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
/*     */   private static String getProcessorID(String paramString1, String paramString2, String paramString3) {
/* 226 */     List list = ExecutingCommand.runNative("isainfo -v");
/* 227 */     StringBuilder stringBuilder = new StringBuilder();
/* 228 */     for (String str : list) {
/* 229 */       if (str.startsWith("32-bit"))
/*     */         break; 
/* 231 */       if (!str.startsWith("64-bit")) {
/* 232 */         stringBuilder.append(' ').append(str.trim());
/*     */       }
/*     */     } 
/* 235 */     return createProcessorID(paramString1, paramString2, paramString3, ParseUtil.whitespaces.split(stringBuilder.toString().toLowerCase()));
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryContextSwitches() {
/* 240 */     long l = 0L;
/* 241 */     List list = ExecutingCommand.runNative("kstat -p cpu_stat:::/pswitch\\\\|inv_swtch/");
/* 242 */     for (String str : list) {
/* 243 */       l += ParseUtil.parseLastLong(str, 0L);
/*     */     }
/* 245 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public long queryInterrupts() {
/* 250 */     long l = 0L;
/* 251 */     List list = ExecutingCommand.runNative("kstat -p cpu_stat:::/intr/");
/* 252 */     for (String str : list) {
/* 253 */       l += ParseUtil.parseLastLong(str, 0L);
/*     */     }
/* 255 */     return l;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\solaris\SolarisCentralProcessor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */