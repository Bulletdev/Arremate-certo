/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import org.h2.command.ddl.SchemaCommand;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
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
/*     */ public class AlterSequence
/*     */   extends SchemaCommand
/*     */ {
/*     */   private boolean ifExists;
/*     */   private Table table;
/*     */   private String sequenceName;
/*     */   private Sequence sequence;
/*     */   private Expression start;
/*     */   private Expression increment;
/*     */   private Boolean cycle;
/*     */   private Expression minValue;
/*     */   private Expression maxValue;
/*     */   private Expression cacheSize;
/*     */   
/*     */   public AlterSequence(Session paramSession, Schema paramSchema) {
/*  39 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setIfExists(boolean paramBoolean) {
/*  43 */     this.ifExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSequenceName(String paramString) {
/*  47 */     this.sequenceName = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/*  52 */     return true;
/*     */   }
/*     */   
/*     */   public void setColumn(Column paramColumn) {
/*  56 */     this.table = paramColumn.getTable();
/*  57 */     this.sequence = paramColumn.getSequence();
/*  58 */     if (this.sequence == null && !this.ifExists) {
/*  59 */       throw DbException.get(90036, paramColumn.getSQL());
/*     */     }
/*     */   }
/*     */   
/*     */   public void setStartWith(Expression paramExpression) {
/*  64 */     this.start = paramExpression;
/*     */   }
/*     */   
/*     */   public void setIncrement(Expression paramExpression) {
/*  68 */     this.increment = paramExpression;
/*     */   }
/*     */   
/*     */   public void setCycle(Boolean paramBoolean) {
/*  72 */     this.cycle = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setMinValue(Expression paramExpression) {
/*  76 */     this.minValue = paramExpression;
/*     */   }
/*     */   
/*     */   public void setMaxValue(Expression paramExpression) {
/*  80 */     this.maxValue = paramExpression;
/*     */   }
/*     */   
/*     */   public void setCacheSize(Expression paramExpression) {
/*  84 */     this.cacheSize = paramExpression;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  89 */     Database database = this.session.getDatabase();
/*  90 */     if (this.sequence == null) {
/*  91 */       this.sequence = getSchema().findSequence(this.sequenceName);
/*  92 */       if (this.sequence == null) {
/*  93 */         if (!this.ifExists) {
/*  94 */           throw DbException.get(90036, this.sequenceName);
/*     */         }
/*  96 */         return 0;
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     if (this.table != null) {
/* 101 */       this.session.getUser().checkRight(this.table, 15);
/*     */     }
/* 103 */     if (this.cycle != null) {
/* 104 */       this.sequence.setCycle(this.cycle.booleanValue());
/*     */     }
/* 106 */     if (this.cacheSize != null) {
/* 107 */       long l = this.cacheSize.optimize(this.session).getValue(this.session).getLong();
/* 108 */       this.sequence.setCacheSize(l);
/*     */     } 
/* 110 */     if (this.start != null || this.minValue != null || this.maxValue != null || this.increment != null) {
/*     */       
/* 112 */       Long long_1 = getLong(this.start);
/* 113 */       Long long_2 = getLong(this.minValue);
/* 114 */       Long long_3 = getLong(this.maxValue);
/* 115 */       Long long_4 = getLong(this.increment);
/* 116 */       this.sequence.modify(long_1, long_2, long_3, long_4);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 121 */     Session session = database.getSystemSession();
/* 122 */     synchronized (session) {
/* 123 */       synchronized (database) {
/* 124 */         database.updateMeta(session, (DbObject)this.sequence);
/* 125 */         session.commit(true);
/*     */       } 
/*     */     } 
/* 128 */     return 0;
/*     */   }
/*     */   
/*     */   private Long getLong(Expression paramExpression) {
/* 132 */     if (paramExpression == null) {
/* 133 */       return null;
/*     */     }
/* 135 */     return Long.valueOf(paramExpression.optimize(this.session).getValue(this.session).getLong());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 140 */     return 54;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\AlterSequence.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */