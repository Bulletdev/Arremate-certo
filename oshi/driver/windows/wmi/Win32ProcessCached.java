/*     */ package oshi.driver.windows.wmi;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.locks.ReentrantLock;
/*     */ import java.util.function.Supplier;
/*     */ import oshi.annotation.concurrent.GuardedBy;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.Memoizer;
/*     */ import oshi.util.platform.windows.WmiUtil;
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
/*     */ @ThreadSafe
/*     */ public final class Win32ProcessCached
/*     */ {
/*  47 */   private static final Supplier<Win32ProcessCached> INSTANCE = Memoizer.memoize(Win32ProcessCached::createInstance);
/*     */   
/*     */   @GuardedBy("commandLineCacheLock")
/*  50 */   private final Map<Integer, Pair<Long, String>> commandLineCache = new HashMap<>();
/*     */   
/*  52 */   private final ReentrantLock commandLineCacheLock = new ReentrantLock();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Win32ProcessCached getInstance() {
/*  64 */     return INSTANCE.get();
/*     */   }
/*     */   
/*     */   private static Win32ProcessCached createInstance() {
/*  68 */     return new Win32ProcessCached();
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
/*     */   public String getCommandLine(int paramInt, long paramLong) {
/*  98 */     this.commandLineCacheLock.lock();
/*     */     
/*     */     try {
/* 101 */       Pair pair = this.commandLineCache.get(Integer.valueOf(paramInt));
/*     */       
/* 103 */       if (pair != null && paramLong < ((Long)pair.getA()).longValue())
/*     */       {
/* 105 */         return (String)pair.getB();
/*     */       }
/*     */ 
/*     */       
/* 109 */       long l = System.currentTimeMillis();
/*     */       
/* 111 */       WbemcliUtil.WmiResult<Win32Process.CommandLineProperty> wmiResult = Win32Process.queryCommandLines(null);
/*     */ 
/*     */       
/* 114 */       if (this.commandLineCache.size() > wmiResult.getResultCount() * 2) {
/* 115 */         this.commandLineCache.clear();
/*     */       }
/*     */       
/* 118 */       String str = "";
/* 119 */       for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 120 */         int i = WmiUtil.getUint32(wmiResult, Win32Process.CommandLineProperty.PROCESSID, b);
/* 121 */         String str1 = WmiUtil.getString(wmiResult, Win32Process.CommandLineProperty.COMMANDLINE, b);
/* 122 */         this.commandLineCache.put(Integer.valueOf(i), new Pair(Long.valueOf(l), str1));
/* 123 */         if (i == paramInt) {
/* 124 */           str = str1;
/*     */         }
/*     */       } 
/* 127 */       return str;
/*     */     } finally {
/*     */       
/* 130 */       this.commandLineCacheLock.unlock();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\oshi\driver\windows\wmi\Win32ProcessCached.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */