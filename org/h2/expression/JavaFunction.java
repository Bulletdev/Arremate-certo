/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.FunctionAlias;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
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
/*     */ public class JavaFunction
/*     */   extends Expression
/*     */   implements FunctionCall
/*     */ {
/*     */   private final FunctionAlias functionAlias;
/*     */   private final FunctionAlias.JavaMethod javaMethod;
/*     */   private final Expression[] args;
/*     */   
/*     */   public JavaFunction(FunctionAlias paramFunctionAlias, Expression[] paramArrayOfExpression) {
/*  31 */     this.functionAlias = paramFunctionAlias;
/*  32 */     this.javaMethod = paramFunctionAlias.findJavaMethod(paramArrayOfExpression);
/*  33 */     this.args = paramArrayOfExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  38 */     return this.javaMethod.getValue(paramSession, this.args, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  43 */     return this.javaMethod.getDataType();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {
/*  48 */     for (Expression expression : this.args) {
/*  49 */       expression.mapColumns(paramColumnResolver, paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  55 */     boolean bool = isDeterministic(); byte b; int i;
/*  56 */     for (b = 0, i = this.args.length; b < i; b++) {
/*  57 */       Expression expression = this.args[b].optimize(paramSession);
/*  58 */       this.args[b] = expression;
/*  59 */       bool &= expression.isConstant();
/*     */     } 
/*  61 */     if (bool) {
/*  62 */       return ValueExpression.get(getValue(paramSession));
/*     */     }
/*  64 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {
/*  69 */     for (Expression expression : this.args) {
/*  70 */       if (expression != null) {
/*  71 */         expression.setEvaluatable(paramTableFilter, paramBoolean);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  78 */     return (DataType.getDataType(getType())).defaultScale;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  83 */     return 2147483647L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  88 */     return Integer.MAX_VALUE;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  93 */     StatementBuilder statementBuilder = new StatementBuilder();
/*     */     
/*  95 */     if ((this.functionAlias.getDatabase().getSettings()).functionsInSchema || !this.functionAlias.getSchema().getName().equals("PUBLIC"))
/*     */     {
/*  97 */       statementBuilder.append(Parser.quoteIdentifier(this.functionAlias.getSchema().getName())).append('.');
/*     */     }
/*     */ 
/*     */     
/* 101 */     statementBuilder.append(Parser.quoteIdentifier(this.functionAlias.getName())).append('(');
/* 102 */     for (Expression expression : this.args) {
/* 103 */       statementBuilder.appendExceptFirst(", ");
/* 104 */       statementBuilder.append(expression.getSQL());
/*     */     } 
/* 106 */     return statementBuilder.append(')').toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {
/* 111 */     for (Expression expression : this.args) {
/* 112 */       if (expression != null) {
/* 113 */         expression.updateAggregate(paramSession);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 120 */     return this.functionAlias.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ValueResultSet getValueForColumnList(Session paramSession, Expression[] paramArrayOfExpression) {
/* 126 */     Value value = this.javaMethod.getValue(paramSession, paramArrayOfExpression, true);
/* 127 */     return (value == ValueNull.INSTANCE) ? null : (ValueResultSet)value;
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression[] getArgs() {
/* 132 */     return this.args;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/* 137 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 2:
/* 139 */         if (!isDeterministic()) {
/* 140 */           return false;
/*     */         }
/*     */         break;
/*     */       
/*     */       case 7:
/* 145 */         paramExpressionVisitor.addDependency((DbObject)this.functionAlias);
/*     */         break;
/*     */     } 
/*     */     
/* 149 */     for (Expression expression : this.args) {
/* 150 */       if (expression != null && !expression.isEverything(paramExpressionVisitor)) {
/* 151 */         return false;
/*     */       }
/*     */     } 
/* 154 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 159 */     int i = this.javaMethod.hasConnectionParam() ? 25 : 5;
/* 160 */     for (Expression expression : this.args) {
/* 161 */       i += expression.getCost();
/*     */     }
/* 163 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isDeterministic() {
/* 168 */     return this.functionAlias.isDeterministic();
/*     */   }
/*     */   
/*     */   public Expression[] getExpressionColumns(Session paramSession) {
/*     */     ValueResultSet valueResultSet;
/* 173 */     switch (getType()) {
/*     */       case 18:
/* 175 */         valueResultSet = getValueForColumnList(paramSession, getArgs());
/* 176 */         return getExpressionColumns(paramSession, valueResultSet.getResultSet());
/*     */       case 17:
/* 178 */         return getExpressionColumns(paramSession, (ValueArray)getValue(paramSession));
/*     */     } 
/* 180 */     return super.getExpressionColumns(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isBufferResultSetToLocalTemp() {
/* 185 */     return this.functionAlias.isBufferResultSetToLocalTemp();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\JavaFunction.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */