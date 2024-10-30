/*     */ package oshi.hardware.platform.unix.openbsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.function.Supplier;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.driver.unix.openbsd.disk.Disklabel;
/*     */ import oshi.hardware.HWDiskStore;
/*     */ import oshi.hardware.HWPartition;
/*     */ import oshi.hardware.common.AbstractHWDiskStore;
/*     */ import oshi.util.ExecutingCommand;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.ParseUtil;
/*     */ import oshi.util.platform.unix.openbsd.OpenBsdSysctlUtil;
/*     */ import oshi.util.tuples.Quartet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class OpenBsdHWDiskStore
/*     */   extends AbstractHWDiskStore
/*     */ {
/*  51 */   private final Supplier<List<String>> iostat = Memoizer.memoize(OpenBsdHWDiskStore::querySystatIostat, Memoizer.defaultExpiration());
/*     */   
/*  53 */   private long reads = 0L;
/*  54 */   private long readBytes = 0L;
/*  55 */   private long writes = 0L;
/*  56 */   private long writeBytes = 0L;
/*  57 */   private long currentQueueLength = 0L;
/*  58 */   private long transferTime = 0L;
/*  59 */   private long timeStamp = 0L;
/*     */   private List<HWPartition> partitionList;
/*     */   
/*     */   private OpenBsdHWDiskStore(String paramString1, String paramString2, String paramString3, long paramLong) {
/*  63 */     super(paramString1, paramString2, paramString3, paramLong);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static List<HWDiskStore> getDisks() {
/*  72 */     ArrayList<OpenBsdHWDiskStore> arrayList = new ArrayList();
/*  73 */     List list = null;
/*     */ 
/*     */ 
/*     */     
/*  77 */     String[] arrayOfString = OpenBsdSysctlUtil.sysctl("hw.disknames", "").split(",");
/*     */ 
/*     */     
/*  80 */     for (String str2 : arrayOfString) {
/*  81 */       String str1 = str2.split(":")[0];
/*     */       
/*  83 */       Quartet quartet = Disklabel.getDiskParams(str1);
/*  84 */       String str3 = (String)quartet.getA();
/*  85 */       long l = ((Long)quartet.getC()).longValue();
/*  86 */       if (l <= 1L) {
/*  87 */         if (list == null) {
/*  88 */           list = ExecutingCommand.runNative("dmesg");
/*     */         }
/*  90 */         Pattern pattern1 = Pattern.compile(str1 + " at .*<(.+)>.*");
/*     */         
/*  92 */         Pattern pattern2 = Pattern.compile(str1 + ":.* (\\d+)MB, (?:(\\d+) bytes\\/sector, )?(?:(\\d+) sectors).*");
/*  93 */         for (String str : list) {
/*  94 */           Matcher matcher = pattern1.matcher(str);
/*  95 */           if (matcher.matches()) {
/*  96 */             str3 = matcher.group(1);
/*     */           }
/*  98 */           matcher = pattern2.matcher(str);
/*  99 */           if (matcher.matches()) {
/*     */             
/* 101 */             long l1 = ParseUtil.parseLongOrDefault(matcher.group(3), 0L);
/*     */             
/* 103 */             long l2 = ParseUtil.parseLongOrDefault(matcher.group(2), 0L);
/* 104 */             if (l2 == 0L && l1 > 0L) {
/*     */ 
/*     */ 
/*     */               
/* 108 */               l = ParseUtil.parseLongOrDefault(matcher.group(1), 0L) << 20L;
/*     */               
/* 110 */               l2 = l / l1;
/*     */               
/* 112 */               l2 = Long.highestOneBit(l2 + l2 >> 1L);
/*     */             } 
/* 114 */             l = l2 * l1;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/* 119 */       OpenBsdHWDiskStore openBsdHWDiskStore = new OpenBsdHWDiskStore(str1, str3, (String)quartet.getB(), l);
/* 120 */       openBsdHWDiskStore.partitionList = (List<HWPartition>)quartet.getD();
/* 121 */       openBsdHWDiskStore.updateAttributes();
/*     */       
/* 123 */       arrayList.add(openBsdHWDiskStore);
/*     */     } 
/* 125 */     return (List)arrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReads() {
/* 130 */     return this.reads;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getReadBytes() {
/* 135 */     return this.readBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWrites() {
/* 140 */     return this.writes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getWriteBytes() {
/* 145 */     return this.writeBytes;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getCurrentQueueLength() {
/* 150 */     return this.currentQueueLength;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTransferTime() {
/* 155 */     return this.transferTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getTimeStamp() {
/* 160 */     return this.timeStamp;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<HWPartition> getPartitions() {
/* 165 */     return this.partitionList;
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
/*     */   public boolean updateAttributes() {
/* 192 */     long l = System.currentTimeMillis();
/* 193 */     boolean bool = false;
/* 194 */     for (String str : this.iostat.get()) {
/* 195 */       String[] arrayOfString = ParseUtil.whitespaces.split(str);
/* 196 */       if (arrayOfString.length < 7 && arrayOfString[0].equals(getName())) {
/* 197 */         bool = true;
/* 198 */         this.readBytes = ParseUtil.parseMultipliedToLongs(arrayOfString[1]);
/* 199 */         this.writeBytes = ParseUtil.parseMultipliedToLongs(arrayOfString[2]);
/* 200 */         this.reads = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[3], 0.0D);
/* 201 */         this.writes = (long)ParseUtil.parseDoubleOrDefault(arrayOfString[4], 0.0D);
/*     */         
/* 203 */         this.transferTime = (long)(ParseUtil.parseDoubleOrDefault(arrayOfString[5], 0.0D) * 1000.0D);
/* 204 */         this.timeStamp = l;
/*     */       } 
/*     */     } 
/* 207 */     return bool;
/*     */   }
/*     */   
/*     */   private static List<String> querySystatIostat() {
/* 211 */     return ExecutingCommand.runNative("systat -ab iostat");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\hardware\platfor\\unix\openbsd\OpenBsdHWDiskStore.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */