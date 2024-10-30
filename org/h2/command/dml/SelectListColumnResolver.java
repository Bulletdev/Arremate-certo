/*    */ package org.h2.command.dml;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.expression.ExpressionColumn;
/*    */ import org.h2.table.Column;
/*    */ import org.h2.table.ColumnResolver;
/*    */ import org.h2.table.TableFilter;
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
/*    */ 
/*    */ 
/*    */ public class SelectListColumnResolver
/*    */   implements ColumnResolver
/*    */ {
/*    */   private final Select select;
/*    */   private final Expression[] expressions;
/*    */   private final Column[] columns;
/*    */   
/*    */   SelectListColumnResolver(Select paramSelect) {
/* 33 */     this.select = paramSelect;
/* 34 */     int i = paramSelect.getColumnCount();
/* 35 */     this.columns = new Column[i];
/* 36 */     this.expressions = new Expression[i];
/* 37 */     ArrayList<Expression> arrayList = paramSelect.getExpressions();
/* 38 */     for (byte b = 0; b < i; b++) {
/* 39 */       Expression expression = arrayList.get(b);
/* 40 */       Column column = new Column(expression.getAlias(), 0);
/* 41 */       column.setTable(null, b);
/* 42 */       this.columns[b] = column;
/* 43 */       this.expressions[b] = expression.getNonAliasExpression();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Column[] getColumns() {
/* 49 */     return this.columns;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSchemaName() {
/* 54 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Select getSelect() {
/* 59 */     return this.select;
/*    */   }
/*    */ 
/*    */   
/*    */   public Column[] getSystemColumns() {
/* 64 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Column getRowIdColumn() {
/* 69 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTableAlias() {
/* 74 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public TableFilter getTableFilter() {
/* 79 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Value getValue(Column paramColumn) {
/* 84 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Expression optimize(ExpressionColumn paramExpressionColumn, Column paramColumn) {
/* 89 */     return this.expressions[paramColumn.getColumnId()];
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\SelectListColumnResolver.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */