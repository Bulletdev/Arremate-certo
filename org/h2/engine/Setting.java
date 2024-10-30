/*    */ package org.h2.engine;
/*    */ 
/*    */ import org.h2.message.DbException;
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
/*    */ public class Setting
/*    */   extends DbObjectBase
/*    */ {
/*    */   private int intValue;
/*    */   private String stringValue;
/*    */   
/*    */   public Setting(Database paramDatabase, int paramInt, String paramString) {
/* 21 */     initDbObjectBase(paramDatabase, paramInt, paramString, 10);
/*    */   }
/*    */   
/*    */   public void setIntValue(int paramInt) {
/* 25 */     this.intValue = paramInt;
/*    */   }
/*    */   
/*    */   public int getIntValue() {
/* 29 */     return this.intValue;
/*    */   }
/*    */   
/*    */   public void setStringValue(String paramString) {
/* 33 */     this.stringValue = paramString;
/*    */   }
/*    */   
/*    */   public String getStringValue() {
/* 37 */     return this.stringValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 42 */     throw DbException.throwInternalError();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDropSQL() {
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQL() {
/* 52 */     StringBuilder stringBuilder = new StringBuilder("SET ");
/* 53 */     stringBuilder.append(getSQL()).append(' ');
/* 54 */     if (this.stringValue != null) {
/* 55 */       stringBuilder.append(this.stringValue);
/*    */     } else {
/* 57 */       stringBuilder.append(this.intValue);
/*    */     } 
/* 59 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 64 */     return 6;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeChildrenAndResources(Session paramSession) {
/* 69 */     this.database.removeMeta(paramSession, getId());
/* 70 */     invalidate();
/*    */   }
/*    */ 
/*    */   
/*    */   public void checkRename() {
/* 75 */     throw DbException.getUnsupportedException("RENAME");
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Setting.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */