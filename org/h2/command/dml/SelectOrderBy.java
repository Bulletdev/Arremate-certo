/*    */ package org.h2.command.dml;
/*    */ 
/*    */ import org.h2.expression.Expression;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SelectOrderBy
/*    */ {
/*    */   public Expression expression;
/*    */   public Expression columnIndexExpr;
/*    */   public boolean descending;
/*    */   public boolean nullsFirst;
/*    */   public boolean nullsLast;
/*    */   
/*    */   public String getSQL() {
/* 43 */     StringBuilder stringBuilder = new StringBuilder();
/* 44 */     if (this.expression != null) {
/* 45 */       stringBuilder.append('=').append(this.expression.getSQL());
/*    */     } else {
/* 47 */       stringBuilder.append(this.columnIndexExpr.getSQL());
/*    */     } 
/* 49 */     if (this.descending) {
/* 50 */       stringBuilder.append(" DESC");
/*    */     }
/* 52 */     if (this.nullsFirst) {
/* 53 */       stringBuilder.append(" NULLS FIRST");
/* 54 */     } else if (this.nullsLast) {
/* 55 */       stringBuilder.append(" NULLS LAST");
/*    */     } 
/* 57 */     return stringBuilder.toString();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\SelectOrderBy.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */