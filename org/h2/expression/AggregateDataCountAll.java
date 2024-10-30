/*    */ package org.h2.expression;
/*    */ 
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.message.DbException;
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
/*    */ class AggregateDataCountAll
/*    */   extends AggregateData
/*    */ {
/*    */   private long count;
/*    */   
/*    */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/* 22 */     if (paramBoolean) {
/* 23 */       throw DbException.throwInternalError();
/*    */     }
/* 25 */     this.count++;
/*    */   }
/*    */ 
/*    */   
/*    */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 30 */     if (paramBoolean) {
/* 31 */       throw DbException.throwInternalError();
/*    */     }
/* 33 */     ValueLong valueLong = ValueLong.get(this.count);
/* 34 */     return (valueLong == null) ? (Value)ValueNull.INSTANCE : valueLong.convertTo(paramInt);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataCountAll.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */