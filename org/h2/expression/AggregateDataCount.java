/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.util.ValueHashMap;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueLong;
/*    */ import org.h2.value.ValueNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AggregateDataCount
/*    */   extends AggregateData
/*    */ {
/*    */   private long count;
/*    */   private ValueHashMap<AggregateDataCount> distinctValues;
/*    */   
/*    */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/* 23 */     if (paramValue == ValueNull.INSTANCE) {
/*    */       return;
/*    */     }
/* 26 */     this.count++;
/* 27 */     if (paramBoolean) {
/* 28 */       if (this.distinctValues == null) {
/* 29 */         this.distinctValues = ValueHashMap.newInstance();
/*    */       }
/* 31 */       this.distinctValues.put(paramValue, this);
/*    */       return;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 38 */     if (paramBoolean) {
/* 39 */       if (this.distinctValues != null) {
/* 40 */         this.count = this.distinctValues.size();
/*    */       } else {
/* 42 */         this.count = 0L;
/*    */       } 
/*    */     }
/* 45 */     ValueLong valueLong = ValueLong.get(this.count);
/* 46 */     return valueLong.convertTo(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataCount.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */