/*     */ package org.h2.expression;
/*     */ 
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.table.ColumnResolver;
/*     */ import org.h2.table.TableFilter;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueLong;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SequenceValue
/*     */   extends Expression
/*     */ {
/*     */   private final Sequence sequence;
/*     */   
/*     */   public SequenceValue(Sequence paramSequence) {
/*  25 */     this.sequence = paramSequence;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value getValue(Session paramSession) {
/*  30 */     long l = this.sequence.getNext(paramSession);
/*  31 */     paramSession.setLastIdentity((Value)ValueLong.get(l));
/*  32 */     return (Value)ValueLong.get(l);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/*  37 */     return 5;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void mapColumns(ColumnResolver paramColumnResolver, int paramInt) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public Expression optimize(Session paramSession) {
/*  47 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEvaluatable(TableFilter paramTableFilter, boolean paramBoolean) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public int getScale() {
/*  57 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  62 */     return 10L;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  67 */     return 11;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  72 */     return "(NEXT VALUE FOR " + this.sequence.getSQL() + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateAggregate(Session paramSession) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEverything(ExpressionVisitor paramExpressionVisitor) {
/*  82 */     switch (paramExpressionVisitor.getType()) {
/*     */       case 1:
/*     */       case 3:
/*     */       case 6:
/*     */       case 9:
/*  87 */         return true;
/*     */       case 0:
/*     */       case 2:
/*     */       case 5:
/*     */       case 8:
/*  92 */         return false;
/*     */       case 4:
/*  94 */         paramExpressionVisitor.addDataModificationId(this.sequence.getModificationId());
/*  95 */         return true;
/*     */       case 7:
/*  97 */         paramExpressionVisitor.addDependency((DbObject)this.sequence);
/*  98 */         return true;
/*     */     } 
/* 100 */     throw DbException.throwInternalError("type=" + paramExpressionVisitor.getType());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCost() {
/* 106 */     return 1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\expression\SequenceValue.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */