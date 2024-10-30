/*    */ package org.h2.result;
/*    */ 
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
/*    */ public abstract class RowFactory
/*    */ {
/* 19 */   public static final RowFactory DEFAULT = new DefaultRowFactory();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public abstract Row createRow(Value[] paramArrayOfValue, int paramInt);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   static final class DefaultRowFactory
/*    */     extends RowFactory
/*    */   {
/*    */     public Row createRow(Value[] param1ArrayOfValue, int param1Int) {
/* 36 */       return new RowImpl(param1ArrayOfValue, param1Int);
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\RowFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */