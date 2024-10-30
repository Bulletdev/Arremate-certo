/*     */ package org.h2.result;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import org.h2.command.dml.SelectOrderBy;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Utils;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SortOrder
/*     */   implements Comparator<Value[]>
/*     */ {
/*     */   public static final int ASCENDING = 0;
/*     */   public static final int DESCENDING = 1;
/*     */   public static final int NULLS_FIRST = 2;
/*     */   public static final int NULLS_LAST = 4;
/*  55 */   private static final int DEFAULT_NULL_SORT = SysProperties.SORT_NULLS_HIGH ? 1 : -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Database database;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int[] queryColumnIndexes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int[] sortTypes;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ArrayList<SelectOrderBy> orderList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SortOrder(Database paramDatabase, int[] paramArrayOfint1, int[] paramArrayOfint2, ArrayList<SelectOrderBy> paramArrayList) {
/*  85 */     this.database = paramDatabase;
/*  86 */     this.queryColumnIndexes = paramArrayOfint1;
/*  87 */     this.sortTypes = paramArrayOfint2;
/*  88 */     this.orderList = paramArrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL(Expression[] paramArrayOfExpression, int paramInt) {
/* 100 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 101 */     byte b = 0;
/* 102 */     for (int i : this.queryColumnIndexes) {
/* 103 */       statementBuilder.appendExceptFirst(", ");
/* 104 */       if (i < paramInt) {
/* 105 */         statementBuilder.append((i + 1));
/*     */       } else {
/* 107 */         statementBuilder.append('=').append(StringUtils.unEnclose(paramArrayOfExpression[i].getSQL()));
/*     */       } 
/* 109 */       int j = this.sortTypes[b++];
/* 110 */       if ((j & 0x1) != 0) {
/* 111 */         statementBuilder.append(" DESC");
/*     */       }
/* 113 */       if ((j & 0x2) != 0) {
/* 114 */         statementBuilder.append(" NULLS FIRST");
/* 115 */       } else if ((j & 0x4) != 0) {
/* 116 */         statementBuilder.append(" NULLS LAST");
/*     */       } 
/*     */     } 
/* 119 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int compareNull(boolean paramBoolean, int paramInt) {
/* 131 */     if ((paramInt & 0x2) != 0)
/* 132 */       return paramBoolean ? -1 : 1; 
/* 133 */     if ((paramInt & 0x4) != 0) {
/* 134 */       return paramBoolean ? 1 : -1;
/*     */     }
/*     */     
/* 137 */     int i = paramBoolean ? DEFAULT_NULL_SORT : -DEFAULT_NULL_SORT;
/* 138 */     return ((paramInt & 0x1) == 0) ? i : -i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compare(Value[] paramArrayOfValue1, Value[] paramArrayOfValue2) {
/*     */     byte b;
/*     */     int i;
/* 151 */     for (b = 0, i = this.queryColumnIndexes.length; b < i; b++) {
/* 152 */       int j = this.queryColumnIndexes[b];
/* 153 */       int k = this.sortTypes[b];
/* 154 */       Value value1 = paramArrayOfValue1[j];
/* 155 */       Value value2 = paramArrayOfValue2[j];
/* 156 */       boolean bool1 = (value1 == ValueNull.INSTANCE) ? true : false, bool2 = (value2 == ValueNull.INSTANCE) ? true : false;
/* 157 */       if (bool1 || bool2) {
/* 158 */         if (bool1 != bool2)
/*     */         {
/*     */           
/* 161 */           return compareNull(bool1, k); } 
/*     */       } else {
/* 163 */         int m = this.database.compare(value1, value2);
/* 164 */         if (m != 0)
/* 165 */           return ((k & 0x1) == 0) ? m : -m; 
/*     */       } 
/*     */     } 
/* 168 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(ArrayList<Value[]> paramArrayList) {
/* 177 */     Collections.sort(paramArrayList, this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sort(ArrayList<Value[]> paramArrayList, int paramInt1, int paramInt2) {
/* 188 */     int i = paramArrayList.size();
/* 189 */     if (paramArrayList.isEmpty() || paramInt1 >= i || paramInt2 == 0) {
/*     */       return;
/*     */     }
/* 192 */     if (paramInt1 < 0) {
/* 193 */       paramInt1 = 0;
/*     */     }
/* 195 */     if (paramInt1 + paramInt2 > i) {
/* 196 */       paramInt2 = i - paramInt1;
/*     */     }
/* 198 */     if (paramInt2 == 1 && paramInt1 == 0) {
/* 199 */       paramArrayList.set(0, Collections.min(paramArrayList, this));
/*     */       return;
/*     */     } 
/* 202 */     Value[][] arrayOfValue = paramArrayList.<Value[]>toArray(new Value[i][]);
/* 203 */     Utils.sortTopN((Object[])arrayOfValue, paramInt1, paramInt2, this); byte b; int j;
/* 204 */     for (b = 0, j = Math.min(paramInt1 + paramInt2, i); b < j; b++) {
/* 205 */       paramArrayList.set(b, arrayOfValue[b]);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getQueryColumnIndexes() {
/* 221 */     return this.queryColumnIndexes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Column getColumn(int paramInt, TableFilter paramTableFilter) {
/* 233 */     if (this.orderList == null) {
/* 234 */       return null;
/*     */     }
/* 236 */     SelectOrderBy selectOrderBy = this.orderList.get(paramInt);
/* 237 */     Expression expression = selectOrderBy.expression;
/* 238 */     if (expression == null) {
/* 239 */       return null;
/*     */     }
/* 241 */     expression = expression.getNonAliasExpression();
/* 242 */     if (expression.isConstant()) {
/* 243 */       return null;
/*     */     }
/* 245 */     if (!(expression instanceof ExpressionColumn)) {
/* 246 */       return null;
/*     */     }
/* 248 */     ExpressionColumn expressionColumn = (ExpressionColumn)expression;
/* 249 */     if (expressionColumn.getTableFilter() != paramTableFilter) {
/* 250 */       return null;
/*     */     }
/* 252 */     return expressionColumn.getColumn();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getSortTypes() {
/* 261 */     return this.sortTypes;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\SortOrder.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */