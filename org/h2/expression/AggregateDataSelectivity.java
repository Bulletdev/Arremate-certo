/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.util.IntIntHashMap;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueInt;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AggregateDataSelectivity
/*    */   extends AggregateData
/*    */ {
/*    */   private long count;
/*    */   private IntIntHashMap distinctHashes;
/*    */   private double m2;
/*    */   
/*    */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/* 24 */     this.count++;
/* 25 */     if (this.distinctHashes == null) {
/* 26 */       this.distinctHashes = new IntIntHashMap();
/*    */     }
/* 28 */     int i = this.distinctHashes.size();
/* 29 */     if (i > 10000) {
/* 30 */       this.distinctHashes = new IntIntHashMap();
/* 31 */       this.m2 += i;
/*    */     } 
/* 33 */     int j = paramValue.hashCode();
/*    */     
/* 35 */     this.distinctHashes.put(j, 1);
/*    */   }
/*    */ 
/*    */   
/*    */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 40 */     if (paramBoolean) {
/* 41 */       this.count = 0L;
/*    */     }
/* 43 */     ValueInt valueInt = null;
/* 44 */     int i = 0;
/* 45 */     if (this.count == 0L) {
/* 46 */       i = 0;
/*    */     } else {
/* 48 */       this.m2 += this.distinctHashes.size();
/* 49 */       this.m2 = 100.0D * this.m2 / this.count;
/* 50 */       i = (int)this.m2;
/* 51 */       i = (i <= 0) ? 1 : ((i > 100) ? 100 : i);
/*    */     } 
/* 53 */     valueInt = ValueInt.get(i);
/* 54 */     return valueInt.convertTo(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataSelectivity.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */