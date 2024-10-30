/*    */ package org.h2.expression;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.engine.Database;
/*    */ import org.h2.util.New;
/*    */ import org.h2.util.ValueHashMap;
/*    */ import org.h2.value.Value;
/*    */ import org.h2.value.ValueNull;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class AggregateDataGroupConcat
/*    */   extends AggregateData
/*    */ {
/*    */   private ArrayList<Value> list;
/*    */   private ValueHashMap<AggregateDataGroupConcat> distinctValues;
/*    */   
/*    */   void add(Database paramDatabase, int paramInt, boolean paramBoolean, Value paramValue) {
/* 24 */     if (paramValue == ValueNull.INSTANCE) {
/*    */       return;
/*    */     }
/* 27 */     if (paramBoolean) {
/* 28 */       if (this.distinctValues == null) {
/* 29 */         this.distinctValues = ValueHashMap.newInstance();
/*    */       }
/* 31 */       this.distinctValues.put(paramValue, this);
/*    */       return;
/*    */     } 
/* 34 */     if (this.list == null) {
/* 35 */       this.list = New.arrayList();
/*    */     }
/* 37 */     this.list.add(paramValue);
/*    */   }
/*    */ 
/*    */   
/*    */   Value getValue(Database paramDatabase, int paramInt, boolean paramBoolean) {
/* 42 */     if (paramBoolean) {
/* 43 */       groupDistinct(paramDatabase, paramInt);
/*    */     }
/* 45 */     return null;
/*    */   }
/*    */   
/*    */   ArrayList<Value> getList() {
/* 49 */     return this.list;
/*    */   }
/*    */   
/*    */   private void groupDistinct(Database paramDatabase, int paramInt) {
/* 53 */     if (this.distinctValues == null) {
/*    */       return;
/*    */     }
/* 56 */     for (Value value : this.distinctValues.keys())
/* 57 */       add(paramDatabase, paramInt, false, value); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\AggregateDataGroupConcat.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */