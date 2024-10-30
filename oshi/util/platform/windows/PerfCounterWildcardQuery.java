/*     */ package oshi.util.platform.windows;
/*     */ 
/*     */ import com.sun.jna.platform.win32.COM.WbemcliUtil;
/*     */ import com.sun.jna.platform.win32.PdhUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ import oshi.annotation.concurrent.ThreadSafe;
/*     */ import oshi.util.Util;
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
/*     */ public final class PerfCounterWildcardQuery
/*     */ {
/*  55 */   private static final Logger LOG = LoggerFactory.getLogger(PerfCounterWildcardQuery.class);
/*     */ 
/*     */   
/*  58 */   private static final Set<String> failedQueryCache = ConcurrentHashMap.newKeySet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValues(Class<T> paramClass, String paramString1, String paramString2) {
/*  85 */     if (!failedQueryCache.contains(paramString1)) {
/*  86 */       Pair<List<String>, Map<T, List<Long>>> pair = queryInstancesAndValuesFromPDH(paramClass, paramString1);
/*     */       
/*  88 */       if (!((List)pair.getA()).isEmpty()) {
/*  89 */         return pair;
/*     */       }
/*     */       
/*  92 */       LOG.warn("Disabling further attempts to query {}.", paramString1);
/*  93 */       failedQueryCache.add(paramString1);
/*     */     } 
/*  95 */     return queryInstancesAndValuesFromWMI(paramClass, paramString2);
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
/*     */   public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValuesFromPDH(Class<T> paramClass, String paramString) {
/*     */     PdhUtil.PdhEnumObjectItems pdhEnumObjectItems;
/* 118 */     Enum[] arrayOfEnum = (Enum[])paramClass.getEnumConstants();
/* 119 */     if (arrayOfEnum.length < 2) {
/* 120 */       throw new IllegalArgumentException("Enum " + paramClass.getName() + " must have at least two elements, an instance filter and a counter.");
/*     */     }
/*     */ 
/*     */     
/* 124 */     String str1 = ((PdhCounterWildcardProperty)((Enum[])paramClass.getEnumConstants())[0]).getCounter().toLowerCase();
/*     */     
/* 126 */     String str2 = PerfCounterQuery.localizeIfNeeded(paramString);
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 131 */       pdhEnumObjectItems = PdhUtil.PdhEnumObjectItems(null, null, str2, 100);
/* 132 */     } catch (com.sun.jna.platform.win32.PdhUtil.PdhException pdhException) {
/* 133 */       return new Pair(Collections.emptyList(), Collections.emptyMap());
/*     */     } 
/* 135 */     List list = pdhEnumObjectItems.getInstances();
/*     */     
/* 137 */     list.removeIf(paramString2 -> !Util.wildcardMatch(paramString2.toLowerCase(), paramString1));
/* 138 */     EnumMap<T, Object> enumMap = new EnumMap<>(paramClass);
/* 139 */     PerfCounterQueryHandler perfCounterQueryHandler = new PerfCounterQueryHandler();
/*     */     
/* 141 */     try { EnumMap<T, Object> enumMap1 = new EnumMap<>(paramClass);
/*     */       byte b;
/* 143 */       for (b = 1; b < arrayOfEnum.length; b++)
/* 144 */       { Enum enum_ = arrayOfEnum[b];
/* 145 */         ArrayList<PerfDataUtil.PerfCounter> arrayList = new ArrayList(list.size());
/* 146 */         for (String str : list)
/* 147 */         { PerfDataUtil.PerfCounter perfCounter = PerfDataUtil.createCounter(paramString, str, ((PdhCounterWildcardProperty)enum_)
/* 148 */               .getCounter());
/* 149 */           if (!perfCounterQueryHandler.addCounterToQuery(perfCounter))
/* 150 */           { Pair<List<String>, Map<T, List<Long>>> pair = new Pair(Collections.emptyList(), Collections.emptyMap());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 168 */             perfCounterQueryHandler.close(); return pair; }  arrayList.add(perfCounter); }  enumMap1.put((T)enum_, arrayList); }  if (0L < perfCounterQueryHandler.updateQuery()) for (b = 1; b < arrayOfEnum.length; b++) { Enum enum_ = arrayOfEnum[b]; ArrayList<Long> arrayList = new ArrayList(); for (PerfDataUtil.PerfCounter perfCounter : enumMap1.get(enum_)) arrayList.add(Long.valueOf(perfCounterQueryHandler.queryCounter(perfCounter)));  enumMap.put((T)enum_, arrayList); }   perfCounterQueryHandler.close(); } catch (Throwable throwable) { try { perfCounterQueryHandler.close(); } catch (Throwable throwable1) { throwable.addSuppressed(throwable1); }  throw throwable; }
/* 169 */      return new Pair(list, enumMap);
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
/*     */   public static <T extends Enum<T>> Pair<List<String>, Map<T, List<Long>>> queryInstancesAndValuesFromWMI(Class<T> paramClass, String paramString) {
/* 191 */     ArrayList<String> arrayList = new ArrayList();
/* 192 */     EnumMap<T, Object> enumMap = new EnumMap<>(paramClass);
/* 193 */     WbemcliUtil.WmiQuery<Enum> wmiQuery = new WbemcliUtil.WmiQuery(paramString, paramClass);
/* 194 */     WbemcliUtil.WmiResult<Enum> wmiResult = WmiQueryHandler.createInstance().queryWMI(wmiQuery);
/* 195 */     if (wmiResult.getResultCount() > 0) {
/* 196 */       for (Enum enum_ : (Enum[])paramClass.getEnumConstants()) {
/*     */         
/* 198 */         if (enum_.ordinal() == 0) {
/* 199 */           for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 200 */             arrayList.add(WmiUtil.getString(wmiResult, enum_, b));
/*     */           }
/*     */         } else {
/* 203 */           ArrayList<Long> arrayList1 = new ArrayList();
/* 204 */           for (byte b = 0; b < wmiResult.getResultCount(); b++) {
/* 205 */             switch (wmiResult.getCIMType(enum_)) {
/*     */               case 18:
/* 207 */                 arrayList1.add(Long.valueOf(WmiUtil.<Enum>getUint16(wmiResult, enum_, b)));
/*     */                 break;
/*     */               case 19:
/* 210 */                 arrayList1.add(Long.valueOf(WmiUtil.getUint32asLong(wmiResult, enum_, b)));
/*     */                 break;
/*     */               case 21:
/* 213 */                 arrayList1.add(Long.valueOf(WmiUtil.getUint64(wmiResult, enum_, b)));
/*     */                 break;
/*     */               case 101:
/* 216 */                 arrayList1.add(Long.valueOf(WmiUtil.<Enum>getDateTime(wmiResult, enum_, b).toInstant().toEpochMilli()));
/*     */                 break;
/*     */               default:
/* 219 */                 throw new ClassCastException("Unimplemented CIM Type Mapping.");
/*     */             } 
/*     */           } 
/* 222 */           enumMap.put((T)enum_, arrayList1);
/*     */         } 
/*     */       } 
/*     */     }
/* 226 */     return new Pair(arrayList, enumMap);
/*     */   }
/*     */   
/*     */   public static interface PdhCounterWildcardProperty {
/*     */     String getCounter();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\osh\\util\platform\windows\PerfCounterWildcardQuery.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */