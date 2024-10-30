/*    */ package ch.qos.logback.classic.db.names;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultDBNameResolver
/*    */   implements DBNameResolver
/*    */ {
/*    */   public <N extends Enum<?>> String getTableName(N paramN) {
/* 27 */     return paramN.toString().toLowerCase();
/*    */   }
/*    */   
/*    */   public <N extends Enum<?>> String getColumnName(N paramN) {
/* 31 */     return paramN.toString().toLowerCase();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\db\names\DefaultDBNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */