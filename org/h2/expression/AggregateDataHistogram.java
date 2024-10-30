/*    */ package org.h2.expression;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import java.util.Comparator;
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.util.ValueHashMap;
/*    */ import org.h2.value.CompareMode;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueArray;
/*    */ import org.h2.value.ValueLong;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AggregateDataHistogram
/*    */   extends AggregateData
/*    */ {
/*    */   private long count;
/*    */   private ValueHashMap<AggregateDataHistogram> distinctValues;
/*    */   
/*    */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/* 27 */     if (this.distinctValues == null) {
/* 28 */       this.distinctValues = ValueHashMap.newInstance();
/*    */     }
/* 30 */     AggregateDataHistogram aggregateDataHistogram = (AggregateDataHistogram)this.distinctValues.get(paramValue);
/* 31 */     if (aggregateDataHistogram == null && 
/* 32 */       this.distinctValues.size() < 10000) {
/* 33 */       aggregateDataHistogram = new AggregateDataHistogram();
/* 34 */       this.distinctValues.put(paramValue, aggregateDataHistogram);
/*    */     } 
/*    */     
/* 37 */     if (aggregateDataHistogram != null) {
/* 38 */       aggregateDataHistogram.count++;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 44 */     if (paramBoolean) {
/* 45 */       this.count = 0L;
/* 46 */       groupDistinct(paramDatabase, paramInt);
/*    */     } 
/* 48 */     ValueArray[] arrayOfValueArray = new ValueArray[this.distinctValues.size()];
/* 49 */     byte b = 0;
/* 50 */     for (Value value : this.distinctValues.keys()) {
/* 51 */       AggregateDataHistogram aggregateDataHistogram = (AggregateDataHistogram)this.distinctValues.get(value);
/* 52 */       arrayOfValueArray[b] = ValueArray.get(new Value[] { value, (Value)ValueLong.get(aggregateDataHistogram.count) });
/* 53 */       b++;
/*    */     } 
/* 55 */     final CompareMode compareMode = paramDatabase.getCompareMode();
/* 56 */     Arrays.sort(arrayOfValueArray, new Comparator<ValueArray>()
/*    */         {
/*    */           public int compare(ValueArray param1ValueArray1, ValueArray param1ValueArray2) {
/* 59 */             Value value1 = param1ValueArray1.getList()[0];
/* 60 */             Value value2 = param1ValueArray2.getList()[0];
/* 61 */             return value1.compareTo(value2, compareMode);
/*    */           }
/*    */         });
/* 64 */     ValueArray valueArray = ValueArray.get((Value[])arrayOfValueArray);
/* 65 */     return valueArray.convertTo(paramInt);
/*    */   }
/*    */   
/*    */   private void groupDistinct(Database paramDatabase, int paramInt) {
/* 69 */     if (this.distinctValues == null) {
/*    */       return;
/*    */     }
/* 72 */     this.count = 0L;
/* 73 */     for (Value value : this.distinctValues.keys())
/* 74 */       add(paramDatabase, paramInt, false, value); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataHistogram.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */