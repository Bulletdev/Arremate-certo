/*     */ package org.h2.expression;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.tools.SimpleResultSet;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueArray;
/*     */ import org.h2.value.ValueNull;
/*     */ import org.h2.value.ValueResultSet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TableFunction
/*     */   extends Function
/*     */ {
/*     */   private final boolean distinct;
/*     */   private final long rowCount;
/*     */   private Column[] columnList;
/*     */   
/*     */   TableFunction(Database paramDatabase, FunctionInfo paramFunctionInfo, long paramLong) {
/*  35 */     super(paramDatabase, paramFunctionInfo);
/*  36 */     this.distinct = (paramFunctionInfo.type == 224);
/*  37 */     this.rowCount = paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  42 */     return (Value)getTable(paramSession, this.args, false, this.distinct);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkParameterCount(int paramInt) {
/*  47 */     if (paramInt < 1) {
/*  48 */       throw DbException.get(7001, new String[] { getName(), ">0" });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  54 */     StatementBuilder statementBuilder = new StatementBuilder(getName());
/*  55 */     statementBuilder.append('(');
/*  56 */     byte b = 0;
/*  57 */     for (Expression expression : this.args) {
/*  58 */       statementBuilder.appendExceptFirst(", ");
/*  59 */       statementBuilder.append(this.columnList[b++].getCreateSQL()).append('=').append(expression.getSQL());
/*     */     } 
/*  61 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  67 */     return this.distinct ? "TABLE_DISTINCT" : "TABLE";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueResultSet getValueForColumnList(Session paramSession, Expression[] paramArrayOfExpression) {
/*  73 */     return getTable(paramSession, this.args, true, false);
/*     */   }
/*     */   
/*     */   public void setColumns(ArrayList<Column> paramArrayList) {
/*  77 */     this.columnList = new Column[paramArrayList.size()];
/*  78 */     paramArrayList.toArray(this.columnList);
/*     */   }
/*     */ 
/*     */   
/*     */   private ValueResultSet getTable(Session paramSession, Expression[] paramArrayOfExpression, boolean paramBoolean1, boolean paramBoolean2) {
/*  83 */     int i = this.columnList.length;
/*  84 */     Expression[] arrayOfExpression = new Expression[i];
/*  85 */     Database database = paramSession.getDatabase();
/*  86 */     for (byte b = 0; b < i; b++) {
/*  87 */       Column column = this.columnList[b];
/*  88 */       ExpressionColumn expressionColumn = new ExpressionColumn(database, column);
/*  89 */       arrayOfExpression[b] = expressionColumn;
/*     */     } 
/*  91 */     LocalResult localResult = new LocalResult(paramSession, arrayOfExpression, i);
/*  92 */     if (paramBoolean2) {
/*  93 */       localResult.setDistinct();
/*     */     }
/*  95 */     if (!paramBoolean1) {
/*  96 */       Value[][] arrayOfValue = new Value[i][];
/*  97 */       int j = 0; byte b1;
/*  98 */       for (b1 = 0; b1 < i; b1++) {
/*  99 */         Value value = paramArrayOfExpression[b1].getValue(paramSession);
/* 100 */         if (value == ValueNull.INSTANCE) {
/* 101 */           arrayOfValue[b1] = new Value[0];
/*     */         } else {
/* 103 */           ValueArray valueArray = (ValueArray)value.convertTo(17);
/* 104 */           Value[] arrayOfValue1 = valueArray.getList();
/* 105 */           arrayOfValue[b1] = arrayOfValue1;
/* 106 */           j = Math.max(j, arrayOfValue1.length);
/*     */         } 
/*     */       } 
/* 109 */       for (b1 = 0; b1 < j; b1++) {
/* 110 */         Value[] arrayOfValue1 = new Value[i];
/* 111 */         for (byte b2 = 0; b2 < i; b2++) {
/* 112 */           Value value, arrayOfValue2[] = arrayOfValue[b2];
/*     */           
/* 114 */           if (arrayOfValue2.length <= b1) {
/* 115 */             ValueNull valueNull = ValueNull.INSTANCE;
/*     */           } else {
/* 117 */             Column column = this.columnList[b2];
/* 118 */             value = arrayOfValue2[b1];
/* 119 */             value = column.convert(value);
/* 120 */             value = value.convertPrecision(column.getPrecision(), false);
/* 121 */             value = value.convertScale(true, column.getScale());
/*     */           } 
/* 123 */           arrayOfValue1[b2] = value;
/*     */         } 
/* 125 */         localResult.addRow(arrayOfValue1);
/*     */       } 
/*     */     } 
/* 128 */     localResult.done();
/* 129 */     return ValueResultSet.get((ResultSet)getSimpleResultSet((ResultInterface)localResult, 2147483647));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static SimpleResultSet getSimpleResultSet(ResultInterface paramResultInterface, int paramInt) {
/* 136 */     int i = paramResultInterface.getVisibleColumnCount();
/* 137 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 138 */     simpleResultSet.setAutoClose(false); byte b;
/* 139 */     for (b = 0; b < i; b++) {
/* 140 */       String str = paramResultInterface.getColumnName(b);
/* 141 */       int j = DataType.convertTypeToSQLType(paramResultInterface.getColumnType(b));
/* 142 */       int k = MathUtils.convertLongToInt(paramResultInterface.getColumnPrecision(b));
/* 143 */       int m = paramResultInterface.getColumnScale(b);
/* 144 */       simpleResultSet.addColumn(str, j, k, m);
/*     */     } 
/* 146 */     paramResultInterface.reset();
/* 147 */     for (b = 0; b < paramInt && paramResultInterface.next(); b++) {
/* 148 */       Object[] arrayOfObject = new Object[i];
/* 149 */       for (byte b1 = 0; b1 < i; b1++) {
/* 150 */         arrayOfObject[b1] = paramResultInterface.currentRow()[b1].getObject();
/*     */       }
/* 152 */       simpleResultSet.addRow(arrayOfObject);
/*     */     } 
/* 154 */     return simpleResultSet;
/*     */   }
/*     */   
/*     */   public long getRowCount() {
/* 158 */     return this.rowCount;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/* 163 */     return getExpressionColumns(paramSession, getTable(paramSession, getArgs(), true, false).getResultSet());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\TableFunction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */