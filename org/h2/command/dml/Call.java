/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionVisitor;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.value.Value;
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
/*     */ public class Call
/*     */   extends Prepared
/*     */ {
/*     */   private boolean isResultSet;
/*     */   private Expression expression;
/*     */   private Expression[] expressions;
/*     */   
/*     */   public Call(Session paramSession) {
/*  29 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/*     */     LocalResult localResult;
/*  35 */     if (this.isResultSet) {
/*  36 */       Expression[] arrayOfExpression = this.expression.getExpressionColumns(this.session);
/*  37 */       localResult = new LocalResult(this.session, arrayOfExpression, arrayOfExpression.length);
/*     */     } else {
/*  39 */       localResult = new LocalResult(this.session, this.expressions, 1);
/*     */     } 
/*  41 */     localResult.done();
/*  42 */     return (ResultInterface)localResult;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  47 */     Value value = this.expression.getValue(this.session);
/*  48 */     int i = value.getType();
/*  49 */     switch (i) {
/*     */ 
/*     */       
/*     */       case 18:
/*  53 */         return super.update();
/*     */       case -1:
/*     */       case 0:
/*  56 */         return 0;
/*     */     } 
/*  58 */     return value.getInt();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultInterface query(int paramInt) {
/*  64 */     setCurrentRowNumber(1);
/*  65 */     Value value = this.expression.getValue(this.session);
/*  66 */     if (this.isResultSet) {
/*  67 */       value = value.convertTo(18);
/*  68 */       ResultSet resultSet = value.getResultSet();
/*  69 */       return (ResultInterface)LocalResult.read(this.session, resultSet, paramInt);
/*     */     } 
/*  71 */     LocalResult localResult = new LocalResult(this.session, this.expressions, 1);
/*  72 */     Value[] arrayOfValue = { value };
/*  73 */     localResult.addRow(arrayOfValue);
/*  74 */     localResult.done();
/*  75 */     return (ResultInterface)localResult;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  80 */     this.expression = this.expression.optimize(this.session);
/*  81 */     this.expressions = new Expression[] { this.expression };
/*  82 */     this.isResultSet = (this.expression.getType() == 18);
/*  83 */     if (this.isResultSet) {
/*  84 */       this.prepareAlways = true;
/*     */     }
/*     */   }
/*     */   
/*     */   public void setExpression(Expression paramExpression) {
/*  89 */     this.expression = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/*  94 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/*  99 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 104 */     return this.expression.isEverything(ExpressionVisitor.READONLY_VISITOR);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/* 110 */     return 57;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 115 */     return !this.isResultSet;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Call.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */