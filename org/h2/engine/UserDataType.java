/*    */ package org.h2.engine;
/*    */ 
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Column;
/*    */ import org.h2.table.Table;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class UserDataType
/*    */   extends DbObjectBase
/*    */ {
/*    */   private Column column;
/*    */   
/*    */   public UserDataType(Database paramDatabase, int paramInt, String paramString) {
/* 21 */     initDbObjectBase(paramDatabase, paramInt, paramString, 2);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 26 */     throw DbException.throwInternalError();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDropSQL() {
/* 31 */     return "DROP DOMAIN IF EXISTS " + getSQL();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQL() {
/* 36 */     return "CREATE DOMAIN " + getSQL() + " AS " + this.column.getCreateSQL();
/*    */   }
/*    */   
/*    */   public Column getColumn() {
/* 40 */     return this.column;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 45 */     return 12;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeChildrenAndResources(Session paramSession) {
/* 50 */     this.database.removeMeta(paramSession, getId());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void checkRename() {}
/*    */ 
/*    */   
/*    */   public void setColumn(Column paramColumn) {
/* 59 */     this.column = paramColumn;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\UserDataType.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */