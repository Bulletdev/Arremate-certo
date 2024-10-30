/*    */ package org.h2.table;
/*    */ 
/*    */ import org.h2.index.Index;
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
/*    */ public class PlanItem
/*    */ {
/*    */   double cost;
/*    */   private int[] masks;
/*    */   private Index index;
/*    */   private PlanItem joinPlan;
/*    */   private PlanItem nestedJoinPlan;
/*    */   
/*    */   void setMasks(int[] paramArrayOfint) {
/* 27 */     this.masks = paramArrayOfint;
/*    */   }
/*    */   
/*    */   int[] getMasks() {
/* 31 */     return this.masks;
/*    */   }
/*    */   
/*    */   void setIndex(Index paramIndex) {
/* 35 */     this.index = paramIndex;
/*    */   }
/*    */   
/*    */   public Index getIndex() {
/* 39 */     return this.index;
/*    */   }
/*    */   
/*    */   PlanItem getJoinPlan() {
/* 43 */     return this.joinPlan;
/*    */   }
/*    */   
/*    */   PlanItem getNestedJoinPlan() {
/* 47 */     return this.nestedJoinPlan;
/*    */   }
/*    */   
/*    */   void setJoinPlan(PlanItem paramPlanItem) {
/* 51 */     this.joinPlan = paramPlanItem;
/*    */   }
/*    */   
/*    */   void setNestedJoinPlan(PlanItem paramPlanItem) {
/* 55 */     this.nestedJoinPlan = paramPlanItem;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\PlanItem.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */