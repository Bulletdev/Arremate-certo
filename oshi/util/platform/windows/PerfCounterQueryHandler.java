/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.NotThreadSafe;
/*     */ import oshi.util.FormatUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @NotThreadSafe
/*     */ public final class PerfCounterQueryHandler
/*     */   implements AutoCloseable
/*     */ {
/*  47 */   private static final Logger LOG = LoggerFactory.getLogger(PerfCounterQueryHandler.class);
/*     */ 
/*     */   
/*  50 */   private Map<PerfDataUtil.PerfCounter, WinNT.HANDLEByReference> counterHandleMap = new HashMap<>();
/*     */   
/*  52 */   private WinNT.HANDLEByReference queryHandle = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean addCounterToQuery(PerfDataUtil.PerfCounter paramPerfCounter) {
/*  63 */     if (this.queryHandle == null) {
/*  64 */       this.queryHandle = new WinNT.HANDLEByReference();
/*  65 */       if (!PerfDataUtil.openQuery(this.queryHandle)) {
/*  66 */         LOG.warn("Failed to open a query for PDH counter: {}", paramPerfCounter.getCounterPath());
/*  67 */         this.queryHandle = null;
/*  68 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/*  72 */     WinNT.HANDLEByReference hANDLEByReference = new WinNT.HANDLEByReference();
/*  73 */     if (!PerfDataUtil.addCounter(this.queryHandle, paramPerfCounter.getCounterPath(), hANDLEByReference)) {
/*  74 */       LOG.warn("Failed to add counter for PDH counter: {}", paramPerfCounter.getCounterPath());
/*  75 */       return false;
/*     */     } 
/*  77 */     this.counterHandleMap.put(paramPerfCounter, hANDLEByReference);
/*  78 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean removeCounterFromQuery(PerfDataUtil.PerfCounter paramPerfCounter) {
/*  89 */     boolean bool = false;
/*  90 */     WinNT.HANDLEByReference hANDLEByReference = this.counterHandleMap.remove(paramPerfCounter);
/*     */     
/*  92 */     if (hANDLEByReference != null) {
/*  93 */       bool = PerfDataUtil.removeCounter(hANDLEByReference);
/*     */     }
/*  95 */     if (this.counterHandleMap.isEmpty()) {
/*  96 */       PerfDataUtil.closeQuery(this.queryHandle);
/*  97 */       this.queryHandle = null;
/*     */     } 
/*  99 */     return bool;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAllCounters() {
/* 107 */     for (WinNT.HANDLEByReference hANDLEByReference : this.counterHandleMap.values()) {
/* 108 */       PerfDataUtil.removeCounter(hANDLEByReference);
/*     */     }
/* 110 */     this.counterHandleMap.clear();
/*     */     
/* 112 */     if (this.queryHandle != null) {
/* 113 */       PerfDataUtil.closeQuery(this.queryHandle);
/*     */     }
/* 115 */     this.queryHandle = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long updateQuery() {
/* 125 */     if (this.queryHandle == null) {
/* 126 */       LOG.warn("Query does not exist to update.");
/* 127 */       return 0L;
/*     */     } 
/* 129 */     return PerfDataUtil.updateQueryTimestamp(this.queryHandle);
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
/*     */   public long queryCounter(PerfDataUtil.PerfCounter paramPerfCounter) {
/* 141 */     if (!this.counterHandleMap.containsKey(paramPerfCounter)) {
/* 142 */       if (LOG.isWarnEnabled()) {
/* 143 */         LOG.warn("Counter {} does not exist to query.", paramPerfCounter.getCounterPath());
/*     */       }
/* 145 */       return 0L;
/*     */     } 
/* 147 */     long l = PerfDataUtil.queryCounter(this.counterHandleMap.get(paramPerfCounter));
/* 148 */     if (l < 0L) {
/* 149 */       if (LOG.isWarnEnabled()) {
/* 150 */         LOG.warn("Error querying counter {}: {}", paramPerfCounter.getCounterPath(), 
/* 151 */             String.format(FormatUtil.formatError((int)l), new Object[0]));
/*     */       }
/* 153 */       return 0L;
/*     */     } 
/* 155 */     return l;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 160 */     removeAllCounters();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\PerfCounterQueryHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */