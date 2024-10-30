/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.BaseTSD;
/*     */ import com.sun.jna.platform.win32.Pdh;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.WinDef;
/*     */ import com.sun.jna.platform.win32.WinNT;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.Immutable;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.FormatUtil;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @ThreadSafe
/*     */ public final class PerfDataUtil
/*     */ {
/*  54 */   private static final Logger LOG = LoggerFactory.getLogger(PerfDataUtil.class);
/*     */   
/*  56 */   private static final BaseTSD.DWORD_PTR PZERO = new BaseTSD.DWORD_PTR(0L);
/*  57 */   private static final WinDef.DWORDByReference PDH_FMT_RAW = new WinDef.DWORDByReference(new WinDef.DWORD(16L));
/*  58 */   private static final Pdh PDH = Pdh.INSTANCE;
/*     */   
/*  60 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */ 
/*     */   
/*     */   @Immutable
/*     */   public static class PerfCounter
/*     */   {
/*     */     private String object;
/*     */     
/*     */     private String instance;
/*     */     private String counter;
/*     */     
/*     */     public PerfCounter(String param1String1, String param1String2, String param1String3) {
/*  72 */       this.object = param1String1;
/*  73 */       this.instance = param1String2;
/*  74 */       this.counter = param1String3;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getObject() {
/*  81 */       return this.object;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getInstance() {
/*  88 */       return this.instance;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCounter() {
/*  95 */       return this.counter;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getCounterPath() {
/* 104 */       StringBuilder stringBuilder = new StringBuilder();
/* 105 */       stringBuilder.append('\\').append(this.object);
/* 106 */       if (this.instance != null) {
/* 107 */         stringBuilder.append('(').append(this.instance).append(')');
/*     */       }
/* 109 */       stringBuilder.append('\\').append(this.counter);
/* 110 */       return stringBuilder.toString();
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
/*     */   public static PerfCounter createCounter(String paramString1, String paramString2, String paramString3) {
/* 129 */     return new PerfCounter(paramString1, paramString2, paramString3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long updateQueryTimestamp(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 140 */     WinDef.LONGLONGByReference lONGLONGByReference = new WinDef.LONGLONGByReference();
/*     */     
/* 142 */     int i = IS_VISTA_OR_GREATER ? PDH.PdhCollectQueryDataWithTime(paramHANDLEByReference.getValue(), lONGLONGByReference) : PDH.PdhCollectQueryData(paramHANDLEByReference.getValue());
/*     */     
/* 144 */     byte b = 0;
/* 145 */     while (i == -2147481643 && b++ < 3) {
/*     */       
/* 147 */       Util.sleep((1 << b));
/*     */       
/* 149 */       i = IS_VISTA_OR_GREATER ? PDH.PdhCollectQueryDataWithTime(paramHANDLEByReference.getValue(), lONGLONGByReference) : PDH.PdhCollectQueryData(paramHANDLEByReference.getValue());
/*     */     } 
/* 151 */     if (i != 0) {
/* 152 */       if (LOG.isWarnEnabled()) {
/* 153 */         LOG.warn("Failed to update counter. Error code: {}", String.format(FormatUtil.formatError(i), new Object[0]));
/*     */       }
/* 155 */       return 0L;
/*     */     } 
/*     */     
/* 158 */     return IS_VISTA_OR_GREATER ? ParseUtil.filetimeToUtcMs(lONGLONGByReference.getValue().longValue(), true) : 
/* 159 */       System.currentTimeMillis();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean openQuery(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 170 */     int i = PDH.PdhOpenQuery(null, PZERO, paramHANDLEByReference);
/* 171 */     if (i != 0) {
/* 172 */       if (LOG.isErrorEnabled()) {
/* 173 */         LOG.error("Failed to open PDH Query. Error code: {}", String.format(FormatUtil.formatError(i), new Object[0]));
/*     */       }
/* 175 */       return false;
/*     */     } 
/* 177 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean closeQuery(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 188 */     return (0 == PDH.PdhCloseQuery(paramHANDLEByReference.getValue()));
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
/*     */   public static long queryCounter(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 200 */     Pdh.PDH_RAW_COUNTER pDH_RAW_COUNTER = new Pdh.PDH_RAW_COUNTER();
/* 201 */     int i = PDH.PdhGetRawCounterValue(paramHANDLEByReference.getValue(), PDH_FMT_RAW, pDH_RAW_COUNTER);
/* 202 */     if (i != 0) {
/* 203 */       if (LOG.isWarnEnabled()) {
/* 204 */         LOG.warn("Failed to get counter. Error code: {}", String.format(FormatUtil.formatError(i), new Object[0]));
/*     */       }
/* 206 */       return i;
/*     */     } 
/* 208 */     return pDH_RAW_COUNTER.FirstValue;
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
/*     */   public static boolean addCounter(WinNT.HANDLEByReference paramHANDLEByReference1, String paramString, WinNT.HANDLEByReference paramHANDLEByReference2) {
/* 225 */     int i = IS_VISTA_OR_GREATER ? PDH.PdhAddEnglishCounter(paramHANDLEByReference1.getValue(), paramString, PZERO, paramHANDLEByReference2) : PDH.PdhAddCounter(paramHANDLEByReference1.getValue(), paramString, PZERO, paramHANDLEByReference2);
/* 226 */     if (i != 0) {
/* 227 */       if (LOG.isWarnEnabled()) {
/* 228 */         LOG.warn("Failed to add PDH Counter: {}, Error code: {}", paramString, 
/* 229 */             String.format(FormatUtil.formatError(i), new Object[0]));
/*     */       }
/* 231 */       return false;
/*     */     } 
/* 233 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean removeCounter(WinNT.HANDLEByReference paramHANDLEByReference) {
/* 244 */     return (0 == PDH.PdhRemoveCounter(paramHANDLEByReference.getValue()));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\PerfDataUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */