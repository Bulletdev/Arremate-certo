/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.expression.ValueExpression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.ResultTarget;
/*     */ import org.h2.result.SortOrder;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
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
/*     */ public class SelectUnion
/*     */   extends Query
/*     */ {
/*     */   public static final int UNION = 0;
/*     */   public static final int UNION_ALL = 1;
/*     */   public static final int EXCEPT = 2;
/*     */   public static final int INTERSECT = 3;
/*     */   private int unionType;
/*     */   private final Query left;
/*     */   private Query right;
/*     */   private ArrayList<Expression> expressions;
/*     */   private Expression[] expressionArray;
/*     */   private ArrayList<SelectOrderBy> orderList;
/*     */   private SortOrder sort;
/*     */   private boolean isPrepared;
/*     */   private boolean checkInit;
/*     */   private boolean isForUpdate;
/*     */   
/*     */   public SelectUnion(Session paramSession, Query paramQuery) {
/*  70 */     super(paramSession);
/*  71 */     this.left = paramQuery;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnion() {
/*  76 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareJoinBatch() {
/*  81 */     this.left.prepareJoinBatch();
/*  82 */     this.right.prepareJoinBatch();
/*     */   }
/*     */   
/*     */   public void setUnionType(int paramInt) {
/*  86 */     this.unionType = paramInt;
/*     */   }
/*     */   
/*     */   public int getUnionType() {
/*  90 */     return this.unionType;
/*     */   }
/*     */   
/*     */   public void setRight(Query paramQuery) {
/*  94 */     this.right = paramQuery;
/*     */   }
/*     */   
/*     */   public Query getLeft() {
/*  98 */     return this.left;
/*     */   }
/*     */   
/*     */   public Query getRight() {
/* 102 */     return this.right;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSQL(String paramString) {
/* 107 */     this.sqlStatement = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOrder(ArrayList<SelectOrderBy> paramArrayList) {
/* 112 */     this.orderList = paramArrayList;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasOrder() {
/* 117 */     return (this.orderList != null || this.sort != null);
/*     */   }
/*     */   
/*     */   private Value[] convert(Value[] paramArrayOfValue, int paramInt) {
/*     */     Value[] arrayOfValue;
/* 122 */     if (paramInt == paramArrayOfValue.length) {
/*     */       
/* 124 */       arrayOfValue = paramArrayOfValue;
/*     */     }
/*     */     else {
/*     */       
/* 128 */       arrayOfValue = new Value[paramInt];
/*     */     } 
/* 130 */     for (byte b = 0; b < paramInt; b++) {
/* 131 */       Expression expression = this.expressions.get(b);
/* 132 */       arrayOfValue[b] = paramArrayOfValue[b].convertTo(expression.getType());
/*     */     } 
/* 134 */     return arrayOfValue;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 139 */     int i = this.left.getColumnCount();
/* 140 */     LocalResult localResult = new LocalResult(this.session, this.expressionArray, i);
/* 141 */     localResult.done();
/* 142 */     return (ResultInterface)localResult;
/*     */   }
/*     */   
/*     */   public LocalResult getEmptyResult() {
/* 146 */     int i = this.left.getColumnCount();
/* 147 */     return new LocalResult(this.session, this.expressionArray, i);
/*     */   }
/*     */   
/*     */   protected LocalResult queryWithoutCache(int paramInt, ResultTarget paramResultTarget) {
/*     */     LocalResult localResult4;
/* 152 */     if (paramInt != 0) {
/*     */       int j;
/*     */       
/* 155 */       if (this.limitExpr == null) {
/* 156 */         j = -1;
/*     */       } else {
/* 158 */         Value value = this.limitExpr.getValue(this.session);
/* 159 */         j = (value == ValueNull.INSTANCE) ? -1 : value.getInt();
/*     */       } 
/* 161 */       if (j) {
/*     */         
/* 163 */         j = paramInt;
/*     */       } else {
/* 165 */         j = Math.min(j, paramInt);
/*     */       } 
/* 167 */       this.limitExpr = (Expression)ValueExpression.get((Value)ValueInt.get(j));
/*     */     } 
/* 169 */     if ((this.session.getDatabase().getSettings()).optimizeInsertFromSelect && 
/* 170 */       this.unionType == 1 && paramResultTarget != null && 
/* 171 */       this.sort == null && !this.distinct && paramInt == 0 && this.offsetExpr == null && this.limitExpr == null) {
/*     */       
/* 173 */       this.left.query(0, paramResultTarget);
/* 174 */       this.right.query(0, paramResultTarget);
/* 175 */       return null;
/*     */     } 
/*     */ 
/*     */     
/* 179 */     int i = this.left.getColumnCount();
/* 180 */     LocalResult localResult1 = new LocalResult(this.session, this.expressionArray, i);
/* 181 */     if (this.sort != null) {
/* 182 */       localResult1.setSortOrder(this.sort);
/*     */     }
/* 184 */     if (this.distinct) {
/* 185 */       this.left.setDistinct(true);
/* 186 */       this.right.setDistinct(true);
/* 187 */       localResult1.setDistinct();
/*     */     } 
/* 189 */     if (this.randomAccessResult) {
/* 190 */       localResult1.setRandomAccess();
/*     */     }
/* 192 */     switch (this.unionType) {
/*     */       case 0:
/*     */       case 2:
/* 195 */         this.left.setDistinct(true);
/* 196 */         this.right.setDistinct(true);
/* 197 */         localResult1.setDistinct();
/*     */         break;
/*     */       case 1:
/*     */         break;
/*     */       case 3:
/* 202 */         this.left.setDistinct(true);
/* 203 */         this.right.setDistinct(true);
/*     */         break;
/*     */       default:
/* 206 */         DbException.throwInternalError("type=" + this.unionType); break;
/*     */     } 
/* 208 */     LocalResult localResult2 = this.left.query(0);
/* 209 */     LocalResult localResult3 = this.right.query(0);
/* 210 */     localResult2.reset();
/* 211 */     localResult3.reset();
/* 212 */     switch (this.unionType) {
/*     */       case 0:
/*     */       case 1:
/* 215 */         while (localResult2.next()) {
/* 216 */           localResult1.addRow(convert(localResult2.currentRow(), i));
/*     */         }
/* 218 */         while (localResult3.next()) {
/* 219 */           localResult1.addRow(convert(localResult3.currentRow(), i));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 2:
/* 224 */         while (localResult2.next()) {
/* 225 */           localResult1.addRow(convert(localResult2.currentRow(), i));
/*     */         }
/* 227 */         while (localResult3.next()) {
/* 228 */           localResult1.removeDistinct(convert(localResult3.currentRow(), i));
/*     */         }
/*     */         break;
/*     */       
/*     */       case 3:
/* 233 */         localResult4 = new LocalResult(this.session, this.expressionArray, i);
/* 234 */         localResult4.setDistinct();
/* 235 */         localResult4.setRandomAccess();
/* 236 */         while (localResult2.next()) {
/* 237 */           localResult4.addRow(convert(localResult2.currentRow(), i));
/*     */         }
/* 239 */         while (localResult3.next()) {
/* 240 */           Value[] arrayOfValue = convert(localResult3.currentRow(), i);
/* 241 */           if (localResult4.containsDistinct(arrayOfValue)) {
/* 242 */             localResult1.addRow(arrayOfValue);
/*     */           }
/*     */         } 
/*     */         break;
/*     */       
/*     */       default:
/* 248 */         DbException.throwInternalError("type=" + this.unionType); break;
/*     */     } 
/* 250 */     if (this.offsetExpr != null) {
/* 251 */       localResult1.setOffset(this.offsetExpr.getValue(this.session).getInt());
/*     */     }
/* 253 */     if (this.limitExpr != null) {
/* 254 */       Value value = this.limitExpr.getValue(this.session);
/* 255 */       if (value != ValueNull.INSTANCE) {
/* 256 */         localResult1.setLimit(value.getInt());
/*     */       }
/*     */     } 
/* 259 */     localResult2.close();
/* 260 */     localResult3.close();
/* 261 */     localResult1.done();
/* 262 */     if (paramResultTarget != null) {
/* 263 */       while (localResult1.next()) {
/* 264 */         paramResultTarget.addRow(localResult1.currentRow());
/*     */       }
/* 266 */       localResult1.close();
/* 267 */       return null;
/*     */     } 
/* 269 */     return localResult1;
/*     */   }
/*     */ 
/*     */   
/*     */   public void init() {
/* 274 */     if (SysProperties.CHECK && this.checkInit) {
/* 275 */       DbException.throwInternalError();
/*     */     }
/* 277 */     this.checkInit = true;
/* 278 */     this.left.init();
/* 279 */     this.right.init();
/* 280 */     int i = this.left.getColumnCount();
/* 281 */     if (i != this.right.getColumnCount()) {
/* 282 */       throw DbException.get(21002);
/*     */     }
/* 284 */     ArrayList<Expression> arrayList = this.left.getExpressions();
/*     */ 
/*     */     
/* 287 */     this.expressions = New.arrayList();
/* 288 */     for (byte b = 0; b < i; b++) {
/* 289 */       Expression expression = arrayList.get(b);
/* 290 */       this.expressions.add(expression);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/* 296 */     if (this.isPrepared) {
/*     */       return;
/*     */     }
/*     */     
/* 300 */     if (SysProperties.CHECK && !this.checkInit) {
/* 301 */       DbException.throwInternalError("not initialized");
/*     */     }
/* 303 */     this.isPrepared = true;
/* 304 */     this.left.prepare();
/* 305 */     this.right.prepare();
/* 306 */     int i = this.left.getColumnCount();
/*     */     
/* 308 */     this.expressions = New.arrayList();
/* 309 */     ArrayList<Expression> arrayList1 = this.left.getExpressions();
/* 310 */     ArrayList<Expression> arrayList2 = this.right.getExpressions();
/* 311 */     for (byte b = 0; b < i; b++) {
/* 312 */       Expression expression1 = arrayList1.get(b);
/* 313 */       Expression expression2 = arrayList2.get(b);
/* 314 */       int j = Value.getHigherOrder(expression1.getType(), expression2.getType());
/* 315 */       long l = Math.max(expression1.getPrecision(), expression2.getPrecision());
/* 316 */       int k = Math.max(expression1.getScale(), expression2.getScale());
/* 317 */       int m = Math.max(expression1.getDisplaySize(), expression2.getDisplaySize());
/* 318 */       Column column = new Column(expression1.getAlias(), j, l, k, m);
/* 319 */       ExpressionColumn expressionColumn = new ExpressionColumn(this.session.getDatabase(), column);
/* 320 */       this.expressions.add(expressionColumn);
/*     */     } 
/* 322 */     if (this.orderList != null) {
/* 323 */       initOrder(this.session, this.expressions, (ArrayList<String>)null, this.orderList, getColumnCount(), true, (ArrayList<TableFilter>)null);
/* 324 */       this.sort = prepareOrder(this.orderList, this.expressions.size());
/* 325 */       this.orderList = null;
/*     */     } 
/* 327 */     this.expressionArray = new Expression[this.expressions.size()];
/* 328 */     this.expressions.toArray(this.expressionArray);
/*     */   }
/*     */ 
/*     */   
/*     */   public double getCost() {
/* 333 */     return this.left.getCost() + this.right.getCost();
/*     */   }
/*     */ 
/*     */   
/*     */   public HashSet<Table> getTables() {
/* 338 */     HashSet<Table> hashSet = this.left.getTables();
/* 339 */     hashSet.addAll(this.right.getTables());
/* 340 */     return hashSet;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<Expression> getExpressions() {
/* 345 */     return this.expressions;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setForUpdate(boolean paramBoolean) {
/* 350 */     this.left.setForUpdate(paramBoolean);
/* 351 */     this.right.setForUpdate(paramBoolean);
/* 352 */     this.isForUpdate = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumnCount() {
/* 357 */     return this.left.getColumnCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/* 362 */     this.left.mapColumns(paramColumnResolver, paramInt);
/* 363 */     this.right.mapColumns(paramColumnResolver, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/* 368 */     this.left.setEvaluatable(paramTableFilter, paramBoolean);
/* 369 */     this.right.setEvaluatable(paramTableFilter, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addGlobalCondition(Parameter paramParameter, int paramInt1, int paramInt2) {
/* 375 */     addParameter(paramParameter);
/* 376 */     switch (this.unionType) {
/*     */       case 0:
/*     */       case 1:
/*     */       case 3:
/* 380 */         this.left.addGlobalCondition(paramParameter, paramInt1, paramInt2);
/* 381 */         this.right.addGlobalCondition(paramParameter, paramInt1, paramInt2);
/*     */         return;
/*     */       
/*     */       case 2:
/* 385 */         this.left.addGlobalCondition(paramParameter, paramInt1, paramInt2);
/*     */         return;
/*     */     } 
/*     */     
/* 389 */     DbException.throwInternalError("type=" + this.unionType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 395 */     StringBuilder stringBuilder = new StringBuilder();
/* 396 */     stringBuilder.append('(').append(this.left.getPlanSQL()).append(')');
/* 397 */     switch (this.unionType) {
/*     */       case 1:
/* 399 */         stringBuilder.append("\nUNION ALL\n");
/*     */         break;
/*     */       case 0:
/* 402 */         stringBuilder.append("\nUNION\n");
/*     */         break;
/*     */       case 3:
/* 405 */         stringBuilder.append("\nINTERSECT\n");
/*     */         break;
/*     */       case 2:
/* 408 */         stringBuilder.append("\nEXCEPT\n");
/*     */         break;
/*     */       default:
/* 411 */         DbException.throwInternalError("type=" + this.unionType); break;
/*     */     } 
/* 413 */     stringBuilder.append('(').append(this.right.getPlanSQL()).append(')');
/* 414 */     Expression[] arrayOfExpression = this.expressions.<Expression>toArray(new Expression[this.expressions.size()]);
/* 415 */     if (this.sort != null) {
/* 416 */       stringBuilder.append("\nORDER BY ").append(this.sort.getSQL(arrayOfExpression, arrayOfExpression.length));
/*     */     }
/* 418 */     if (this.limitExpr != null) {
/* 419 */       stringBuilder.append("\nLIMIT ").append(StringUtils.unEnclose(this.limitExpr.getSQL()));
/*     */       
/* 421 */       if (this.offsetExpr != null) {
/* 422 */         stringBuilder.append("\nOFFSET ").append(StringUtils.unEnclose(this.offsetExpr.getSQL()));
/*     */       }
/*     */     } 
/*     */     
/* 426 */     if (this.sampleSizeExpr != null) {
/* 427 */       stringBuilder.append("\nSAMPLE_SIZE ").append(StringUtils.unEnclose(this.sampleSizeExpr.getSQL()));
/*     */     }
/*     */     
/* 430 */     if (this.isForUpdate) {
/* 431 */       stringBuilder.append("\nFOR UPDATE");
/*     */     }
/* 433 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public LocalResult query(int paramInt, ResultTarget paramResultTarget) {
/* 440 */     return queryWithoutCache(paramInt, paramResultTarget);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 445 */     return (this.left.isEverything(paramExpressionVisitor) && this.right.isEverything(paramExpressionVisitor));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 450 */     return (this.left.isReadOnly() && this.right.isReadOnly());
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 455 */     this.left.updateAggregate(paramSession);
/* 456 */     this.right.updateAggregate(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public void fireBeforeSelectTriggers() {
/* 461 */     this.left.fireBeforeSelectTriggers();
/* 462 */     this.right.fireBeforeSelectTriggers();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 467 */     return 66;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean allowGlobalConditions() {
/* 472 */     return (this.left.allowGlobalConditions() && this.right.allowGlobalConditions());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\SelectUnion.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */