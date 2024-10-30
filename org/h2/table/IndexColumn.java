/*    */ package org.h2.table;
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
/*    */ public class IndexColumn
/*    */ {
/*    */   public String columnName;
/*    */   public Column column;
/* 30 */   public int sortType = 0;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSQL() {
/* 38 */     StringBuilder stringBuilder = new StringBuilder(this.column.getSQL());
/* 39 */     if ((this.sortType & 0x1) != 0) {
/* 40 */       stringBuilder.append(" DESC");
/*    */     }
/* 42 */     if ((this.sortType & 0x2) != 0) {
/* 43 */       stringBuilder.append(" NULLS FIRST");
/* 44 */     } else if ((this.sortType & 0x4) != 0) {
/* 45 */       stringBuilder.append(" NULLS LAST");
/*    */     } 
/* 47 */     return stringBuilder.toString();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static IndexColumn[] wrap(Column[] paramArrayOfColumn) {
/* 58 */     IndexColumn[] arrayOfIndexColumn = new IndexColumn[paramArrayOfColumn.length];
/* 59 */     for (byte b = 0; b < arrayOfIndexColumn.length; b++) {
/* 60 */       arrayOfIndexColumn[b] = new IndexColumn();
/* 61 */       (arrayOfIndexColumn[b]).column = paramArrayOfColumn[b];
/*    */     } 
/* 63 */     return arrayOfIndexColumn;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void mapColumns(IndexColumn[] paramArrayOfIndexColumn, Table paramTable) {
/* 73 */     for (IndexColumn indexColumn : paramArrayOfIndexColumn)
/* 74 */       indexColumn.column = paramTable.getColumn(indexColumn.columnName); 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\IndexColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */