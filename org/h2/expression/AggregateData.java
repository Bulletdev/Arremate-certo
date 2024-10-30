/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ abstract class AggregateData
/*    */ {
/*    */   static AggregateData create(int paramInt) {
/* 23 */     if (paramInt == 15)
/* 24 */       return new AggregateDataSelectivity(); 
/* 25 */     if (paramInt == 2)
/* 26 */       return new AggregateDataGroupConcat(); 
/* 27 */     if (paramInt == 0)
/* 28 */       return new AggregateDataCountAll(); 
/* 29 */     if (paramInt == 1)
/* 30 */       return new AggregateDataCount(); 
/* 31 */     if (paramInt == 16) {
/* 32 */       return new AggregateDataHistogram();
/*    */     }
/* 34 */     return new AggregateDataDefault(paramInt);
/*    */   }
/*    */   
/*    */   abstract void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue);
/*    */   
/*    */   abstract Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean);
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateData.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */