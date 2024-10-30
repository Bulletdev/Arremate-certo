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
/*    */ public class SimpleDBNameResolver
/*    */   implements DBNameResolver
/*    */ {
/* 24 */   private String tableNamePrefix = "";
/*    */   
/* 26 */   private String tableNameSuffix = "";
/*    */   
/* 28 */   private String columnNamePrefix = "";
/*    */   
/* 30 */   private String columnNameSuffix = "";
/*    */   
/*    */   public <N extends Enum<?>> String getTableName(N paramN) {
/* 33 */     return this.tableNamePrefix + paramN.name().toLowerCase() + this.tableNameSuffix;
/*    */   }
/*    */   
/*    */   public <N extends Enum<?>> String getColumnName(N paramN) {
/* 37 */     return this.columnNamePrefix + paramN.name().toLowerCase() + this.columnNameSuffix;
/*    */   }
/*    */   
/*    */   public void setTableNamePrefix(String paramString) {
/* 41 */     this.tableNamePrefix = (paramString != null) ? paramString : "";
/*    */   }
/*    */   
/*    */   public void setTableNameSuffix(String paramString) {
/* 45 */     this.tableNameSuffix = (paramString != null) ? paramString : "";
/*    */   }
/*    */   
/*    */   public void setColumnNamePrefix(String paramString) {
/* 49 */     this.columnNamePrefix = (paramString != null) ? paramString : "";
/*    */   }
/*    */   
/*    */   public void setColumnNameSuffix(String paramString) {
/* 53 */     this.columnNameSuffix = (paramString != null) ? paramString : "";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\ch\qos\logback\classic\db\names\SimpleDBNameResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */