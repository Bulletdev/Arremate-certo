/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.PdhUtil;
/*     */ import com.sun.jna.platform.win32.VersionHelpers;
/*     */ import com.sun.jna.platform.win32.Win32Exception;
/*     */ import java.util.EnumMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ public final class PerfCounterQuery
/*     */ {
/*  51 */   private static final Logger LOG = LoggerFactory.getLogger(PerfCounterQuery.class);
/*     */   
/*  53 */   private static final boolean IS_VISTA_OR_GREATER = VersionHelpers.IsWindowsVistaOrGreater();
/*     */ 
/*     */   
/*  56 */   private static final Set<String> failedQueryCache = ConcurrentHashMap.newKeySet();
/*     */ 
/*     */   
/*  59 */   private static final ConcurrentHashMap<String, String> localizeCache = IS_VISTA_OR_GREATER ? null : 
/*  60 */     new ConcurrentHashMap<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String TOTAL_INSTANCE = "_Total";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String TOTAL_INSTANCES = "*_Total";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String NOT_TOTAL_INSTANCE = "^_Total";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String NOT_TOTAL_INSTANCES = "^*_Total";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Enum<T>> Map<T, Long> queryValues(Class<T> paramClass, String paramString1, String paramString2) {
/*  94 */     if (!failedQueryCache.contains(paramString1)) {
/*  95 */       Map<T, Long> map = queryValuesFromPDH(paramClass, paramString1);
/*  96 */       if (!map.isEmpty()) {
/*  97 */         return map;
/*     */       }
/*     */       
/* 100 */       LOG.warn("Disabling further attempts to query {}.", paramString1);
/* 101 */       failedQueryCache.add(paramString1);
/*     */     } 
/* 103 */     return queryValuesFromWMI(paramClass, paramString2);
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
/*     */   public static <T extends Enum<T>> Map<T, Long> queryValuesFromPDH(Class<T> paramClass, String paramString) {
/* 124 */     Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
/*     */     
/* 126 */     String str = localizeIfNeeded(paramString);
/* 127 */     EnumMap<T, Object> enumMap1 = new EnumMap<>(paramClass);
/* 128 */     EnumMap<T, Object> enumMap2 = new EnumMap<>(paramClass);
/* 129 */     PerfCounterQueryHandler perfCounterQueryHandler = new PerfCounterQueryHandler();
/*     */     
/* 131 */     try { for (Enum enum_ : arrayOfEnum)
/* 132 */       { PerfDataUtil.PerfCounter perfCounter = PerfDataUtil.createCounter(str, ((PdhCounterProperty)enum_)
/* 133 */             .getInstance(), ((PdhCounterProperty)enum_).getCounter());
/* 134 */         enumMap1.put((T)enum_, perfCounter);
/* 135 */         if (!perfCounterQueryHandler.addCounterToQuery(perfCounter))
/* 136 */         { EnumMap<T, Object> enumMap = enumMap2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 145 */           perfCounterQueryHandler.close(); return (Map)enumMap; }  }  if (0L < perfCounterQueryHandler.updateQuery()) for (Enum enum_ : arrayOfEnum) enumMap2.put((T)enum_, Long.valueOf(perfCounterQueryHandler.queryCounter((PerfDataUtil.PerfCounter)enumMap1.get(enum_))));   perfCounterQueryHandler.close(); } catch (Throwable throwable) { try { perfCounterQueryHandler.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }
/* 146 */      return (Map)enumMap2;
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
/*     */   public static <T extends Enum<T>> Map<T, Long> queryValuesFromWMI(Class<T> paramClass, String paramString) {
/* 166 */     WbemcliUtil.WmiQuery<Enum> wmiQuery = new WbemcliUtil.WmiQuery(paramString, paramClass);
/* 167 */     WbemcliUtil.WmiResult<Enum> wmiResult = WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/* 168 */     EnumMap<T, Object> enumMap = new EnumMap<>(paramClass);
/* 169 */     if (wmiResult.getResultCount() > 0) {
/* 170 */       for (Enum enum_ : (Enum[])paramClass.getEnumConstants()) {
/* 171 */         switch (wmiResult.getCIMType(enum_)) {
/*     */           case 18:
/* 173 */             enumMap.put((T)enum_, Long.valueOf(WmiUtil.<Enum>getUint16(wmiResult, enum_, 0)));
/*     */             break;
/*     */           case 19:
/* 176 */             enumMap.put((T)enum_, Long.valueOf(WmiUtil.getUint32asLong(wmiResult, enum_, 0)));
/*     */             break;
/*     */           case 21:
/* 179 */             enumMap.put((T)enum_, Long.valueOf(WmiUtil.getUint64(wmiResult, enum_, 0)));
/*     */             break;
/*     */           case 101:
/* 182 */             enumMap.put((T)enum_, Long.valueOf(WmiUtil.<Enum>getDateTime(wmiResult, enum_, 0).toInstant().toEpochMilli()));
/*     */             break;
/*     */           default:
/* 185 */             throw new ClassCastException("Unimplemented CIM Type Mapping.");
/*     */         } 
/*     */       } 
/*     */     }
/* 189 */     return (Map)enumMap;
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
/*     */   public static String localizeIfNeeded(String paramString) {
/* 206 */     return IS_VISTA_OR_GREATER ? paramString : 
/* 207 */       localizeCache.computeIfAbsent(paramString, PerfCounterQuery::localizeUsingPerfIndex);
/*     */   }
/*     */   
/*     */   private static String localizeUsingPerfIndex(String paramString) {
/* 211 */     String str = paramString;
/*     */     try {
/* 213 */       str = PdhUtil.PdhLookupPerfNameByIndex(null, PdhUtil.PdhLookupPerfIndexByEnglishName(paramString));
/* 214 */     } catch (Win32Exception win32Exception) {
/* 215 */       LOG.warn("Unable to locate English counter names in registry Perflib 009. Assuming English counters. Error {}. {}", 
/*     */           
/* 217 */           String.format("0x%x", new Object[] { Integer.valueOf(win32Exception.getHR().intValue()) }), "See https://support.microsoft.com/en-us/help/300956/how-to-manually-rebuild-performance-counter-library-values");
/*     */     }
/* 219 */     catch (com.sun.jna.platform.win32.PdhUtil.PdhException pdhException) {
/* 220 */       LOG.warn("Unable to localize {} performance counter.  Error {}.", paramString, 
/* 221 */           String.format("0x%x", new Object[] { Integer.valueOf(pdhException.getErrorCode()) }));
/*     */     } 
/* 223 */     if (str.isEmpty()) {
/* 224 */       return paramString;
/*     */     }
/* 226 */     LOG.debug("Localized {} to {}", paramString, str);
/* 227 */     return str;
/*     */   }
/*     */   
/*     */   public static interface PdhCounterProperty {
/*     */     String getInstance();
/*     */     
/*     */     String getCounter();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\PerfCounterQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */