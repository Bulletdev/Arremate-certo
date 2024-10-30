/*    */ package org.h2.table;
/*    */ 
/*    */ import org.h2.result.SortOrder;
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
/*    */ public class SubQueryInfo
/*    */ {
/*    */   private int[] masks;
/*    */   private TableFilter[] filters;
/*    */   private int filter;
/*    */   private SortOrder sortOrder;
/*    */   private SubQueryInfo upper;
/*    */   
/*    */   public SubQueryInfo(SubQueryInfo paramSubQueryInfo, int[] paramArrayOfint, TableFilter[] paramArrayOfTableFilter, int paramInt, SortOrder paramSortOrder) {
/* 33 */     this.upper = paramSubQueryInfo;
/* 34 */     this.masks = paramArrayOfint;
/* 35 */     this.filters = paramArrayOfTableFilter;
/* 36 */     this.filter = paramInt;
/* 37 */     this.sortOrder = paramSortOrder;
/*    */   }
/*    */   
/*    */   public SubQueryInfo getUpper() {
/* 41 */     return this.upper;
/*    */   }
/*    */   
/*    */   public int[] getMasks() {
/* 45 */     return this.masks;
/*    */   }
/*    */   
/*    */   public TableFilter[] getFilters() {
/* 49 */     return this.filters;
/*    */   }
/*    */   
/*    */   public int getFilter() {
/* 53 */     return this.filter;
/*    */   }
/*    */   
/*    */   public SortOrder getSortOrder() {
/* 57 */     return this.sortOrder;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\SubQueryInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */