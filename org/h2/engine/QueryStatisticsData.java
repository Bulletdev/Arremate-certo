/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QueryStatisticsData
/*     */ {
/*  22 */   private static final Comparator<QueryEntry> QUERY_ENTRY_COMPARATOR = new Comparator<QueryEntry>()
/*     */     {
/*     */       public int compare(QueryStatisticsData.QueryEntry param1QueryEntry1, QueryStatisticsData.QueryEntry param1QueryEntry2)
/*     */       {
/*  26 */         return (int)Math.signum((float)(param1QueryEntry1.lastUpdateTime - param1QueryEntry2.lastUpdateTime));
/*     */       }
/*     */     };
/*     */   
/*  30 */   private final HashMap<String, QueryEntry> map = new HashMap<>();
/*     */   
/*     */   private int maxQueryEntries;
/*     */ 
/*     */   
/*     */   public QueryStatisticsData(int paramInt) {
/*  36 */     this.maxQueryEntries = paramInt;
/*     */   }
/*     */   
/*     */   public synchronized void setMaxQueryEntries(int paramInt) {
/*  40 */     this.maxQueryEntries = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized List<QueryEntry> getQueries() {
/*  46 */     ArrayList<QueryEntry> arrayList = new ArrayList();
/*  47 */     arrayList.addAll(this.map.values());
/*     */     
/*  49 */     Collections.sort(arrayList, QUERY_ENTRY_COMPARATOR);
/*  50 */     return arrayList.subList(0, Math.min(arrayList.size(), this.maxQueryEntries));
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
/*     */   public synchronized void update(String paramString, long paramLong, int paramInt) {
/*  63 */     QueryEntry queryEntry = this.map.get(paramString);
/*  64 */     if (queryEntry == null) {
/*  65 */       queryEntry = new QueryEntry();
/*  66 */       queryEntry.sqlStatement = paramString;
/*  67 */       this.map.put(paramString, queryEntry);
/*     */     } 
/*  69 */     queryEntry.update(paramLong, paramInt);
/*     */ 
/*     */ 
/*     */     
/*  73 */     if (this.map.size() > this.maxQueryEntries * 1.5F) {
/*     */       
/*  75 */       ArrayList<QueryEntry> arrayList = new ArrayList();
/*  76 */       arrayList.addAll(this.map.values());
/*  77 */       Collections.sort(arrayList, QUERY_ENTRY_COMPARATOR);
/*     */       
/*  79 */       HashSet hashSet = new HashSet(arrayList.subList(0, arrayList.size() / 3));
/*     */ 
/*     */ 
/*     */       
/*  83 */       Iterator<Map.Entry> iterator = this.map.entrySet().iterator();
/*  84 */       while (iterator.hasNext()) {
/*  85 */         Map.Entry entry = iterator.next();
/*  86 */         if (hashSet.contains(entry.getValue())) {
/*  87 */           iterator.remove();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final class QueryEntry
/*     */   {
/*     */     public String sqlStatement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int count;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long lastUpdateTime;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long executionTimeMinNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long executionTimeMaxNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long executionTimeCumulativeNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int rowCountMin;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int rowCountMax;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public long rowCountCumulative;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double executionTimeMeanNanos;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public double rowCountMean;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private double executionTimeM2Nanos;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private double rowCountM2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void update(long param1Long, int param1Int) {
/* 168 */       this.count++;
/* 169 */       this.executionTimeMinNanos = Math.min(param1Long, this.executionTimeMinNanos);
/* 170 */       this.executionTimeMaxNanos = Math.max(param1Long, this.executionTimeMaxNanos);
/* 171 */       this.rowCountMin = Math.min(param1Int, this.rowCountMin);
/* 172 */       this.rowCountMax = Math.max(param1Int, this.rowCountMax);
/*     */       
/* 174 */       double d1 = param1Int - this.rowCountMean;
/* 175 */       this.rowCountMean += d1 / this.count;
/* 176 */       this.rowCountM2 += d1 * (param1Int - this.rowCountMean);
/*     */       
/* 178 */       double d2 = param1Long - this.executionTimeMeanNanos;
/* 179 */       this.executionTimeMeanNanos += d2 / this.count;
/* 180 */       this.executionTimeM2Nanos += d2 * (param1Long - this.executionTimeMeanNanos);
/*     */       
/* 182 */       this.executionTimeCumulativeNanos += param1Long;
/* 183 */       this.rowCountCumulative += param1Int;
/* 184 */       this.lastUpdateTime = System.currentTimeMillis();
/*     */     }
/*     */ 
/*     */     
/*     */     public double getExecutionTimeStandardDeviation() {
/* 189 */       return Math.sqrt(this.executionTimeM2Nanos / this.count);
/*     */     }
/*     */ 
/*     */     
/*     */     public double getRowCountStandardDeviation() {
/* 194 */       return Math.sqrt(this.rowCountM2 / this.count);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\QueryStatisticsData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */