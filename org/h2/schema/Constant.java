/*    */ package org.h2.schema;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.ValueExpression;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.table.Table;
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
/*    */ public class Constant
/*    */   extends SchemaObjectBase
/*    */ {
/*    */   private Value value;
/*    */   private ValueExpression expression;
/*    */   
/*    */   public Constant(Schema paramSchema, int paramInt, String paramString) {
/* 26 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 8);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 31 */     throw DbException.throwInternalError();
/*    */   }
/*    */ 
/*    */   
/*    */   public String getDropSQL() {
/* 36 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getCreateSQL() {
/* 41 */     return "CREATE CONSTANT " + getSQL() + " VALUE " + this.value.getSQL();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 46 */     return 11;
/*    */   }
/*    */ 
/*    */   
/*    */   public void removeChildrenAndResources(Session paramSession) {
/* 51 */     this.database.removeMeta(paramSession, getId());
/* 52 */     invalidate();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void checkRename() {}
/*    */ 
/*    */   
/*    */   public void setValue(Value paramValue) {
/* 61 */     this.value = paramValue;
/* 62 */     this.expression = ValueExpression.get(paramValue);
/*    */   }
/*    */   
/*    */   public ValueExpression getValue() {
/* 66 */     return this.expression;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\Constant.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */