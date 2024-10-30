/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.Sequence;
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
/*     */ public class CreateSequence
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String sequenceName;
/*     */   private boolean ifNotExists;
/*     */   private boolean cycle;
/*     */   private Expression minValue;
/*     */   private Expression maxValue;
/*     */   private Expression start;
/*     */   private Expression increment;
/*     */   private Expression cacheSize;
/*     */   private boolean belongsToTable;
/*     */   
/*     */   public CreateSequence(Session paramSession, Schema paramSchema) {
/*  34 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setSequenceName(String paramString) {
/*  38 */     this.sequenceName = paramString;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  42 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setCycle(boolean paramBoolean) {
/*  46 */     this.cycle = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  51 */     this.session.commit(true);
/*  52 */     Database database = this.session.getDatabase();
/*  53 */     if (getSchema().findSequence(this.sequenceName) != null) {
/*  54 */       if (this.ifNotExists) {
/*  55 */         return 0;
/*     */       }
/*  57 */       throw DbException.get(90035, this.sequenceName);
/*     */     } 
/*  59 */     int i = getObjectId();
/*  60 */     Long long_1 = getLong(this.start);
/*  61 */     Long long_2 = getLong(this.increment);
/*  62 */     Long long_3 = getLong(this.cacheSize);
/*  63 */     Long long_4 = getLong(this.minValue);
/*  64 */     Long long_5 = getLong(this.maxValue);
/*  65 */     Sequence sequence = new Sequence(getSchema(), i, this.sequenceName, long_1, long_2, long_3, long_4, long_5, this.cycle, this.belongsToTable);
/*     */     
/*  67 */     database.addSchemaObject(this.session, (SchemaObject)sequence);
/*  68 */     return 0;
/*     */   }
/*     */   
/*     */   private Long getLong(Expression paramExpression) {
/*  72 */     if (paramExpression == null) {
/*  73 */       return null;
/*     */     }
/*  75 */     return Long.valueOf(paramExpression.optimize(this.session).getValue(this.session).getLong());
/*     */   }
/*     */   
/*     */   public void setStartWith(Expression paramExpression) {
/*  79 */     this.start = paramExpression;
/*     */   }
/*     */   
/*     */   public void setIncrement(Expression paramExpression) {
/*  83 */     this.increment = paramExpression;
/*     */   }
/*     */   
/*     */   public void setMinValue(Expression paramExpression) {
/*  87 */     this.minValue = paramExpression;
/*     */   }
/*     */   
/*     */   public void setMaxValue(Expression paramExpression) {
/*  91 */     this.maxValue = paramExpression;
/*     */   }
/*     */   
/*     */   public void setBelongsToTable(boolean paramBoolean) {
/*  95 */     this.belongsToTable = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setCacheSize(Expression paramExpression) {
/*  99 */     this.cacheSize = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 104 */     return 29;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateSequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */