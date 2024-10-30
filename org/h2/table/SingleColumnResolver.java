/*    */ package org.h2.table;
/*    */ 
/*    */ import org.h2.command.dml.Select;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.expression.ExpressionColumn;
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
/*    */ public class SingleColumnResolver
/*    */   implements ColumnResolver
/*    */ {
/*    */   private final Column column;
/*    */   private Value value;
/*    */   
/*    */   SingleColumnResolver(Column paramColumn) {
/* 23 */     this.column = paramColumn;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTableAlias() {
/* 28 */     return null;
/*    */   }
/*    */   
/*    */   void setValue(Value paramValue) {
/* 32 */     this.value = paramValue;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(Column paramColumn) {
/* 37 */     return this.value;
/*    */   }
/*    */ 
/*    */   
/*    */   public Column[] getColumns() {
/* 42 */     return new Column[] { this.column };
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSchemaName() {
/* 47 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public TableFilter getTableFilter() {
/* 52 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Select getSelect() {
/* 57 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Column[] getSystemColumns() {
/* 62 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Column getRowIdColumn() {
/* 67 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Expression optimize(ExpressionColumn paramExpressionColumn, Column paramColumn) {
/* 72 */     return (Expression)paramExpressionColumn;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\SingleColumnResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */