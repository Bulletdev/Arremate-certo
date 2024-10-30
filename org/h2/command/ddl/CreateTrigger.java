/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.TriggerObject;
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
/*     */ 
/*     */ public class CreateTrigger
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String triggerName;
/*     */   private boolean ifNotExists;
/*     */   private boolean insteadOf;
/*     */   private boolean before;
/*     */   private int typeMask;
/*     */   private boolean rowBased;
/*  31 */   private int queueSize = 1024;
/*     */   private boolean noWait;
/*     */   private String tableName;
/*     */   private String triggerClassName;
/*     */   private String triggerSource;
/*     */   private boolean force;
/*     */   private boolean onRollback;
/*     */   
/*     */   public CreateTrigger(Session paramSession, Schema paramSchema) {
/*  40 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setInsteadOf(boolean paramBoolean) {
/*  44 */     this.insteadOf = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setBefore(boolean paramBoolean) {
/*  48 */     this.before = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTriggerClassName(String paramString) {
/*  52 */     this.triggerClassName = paramString;
/*     */   }
/*     */   
/*     */   public void setTriggerSource(String paramString) {
/*  56 */     this.triggerSource = paramString;
/*     */   }
/*     */   
/*     */   public void setTypeMask(int paramInt) {
/*  60 */     this.typeMask = paramInt;
/*     */   }
/*     */   
/*     */   public void setRowBased(boolean paramBoolean) {
/*  64 */     this.rowBased = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setQueueSize(int paramInt) {
/*  68 */     this.queueSize = paramInt;
/*     */   }
/*     */   
/*     */   public void setNoWait(boolean paramBoolean) {
/*  72 */     this.noWait = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  76 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   public void setTriggerName(String paramString) {
/*  80 */     this.triggerName = paramString;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  84 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  89 */     this.session.commit(true);
/*  90 */     Database database = this.session.getDatabase();
/*  91 */     if (getSchema().findTrigger(this.triggerName) != null) {
/*  92 */       if (this.ifNotExists) {
/*  93 */         return 0;
/*     */       }
/*  95 */       throw DbException.get(90041, this.triggerName);
/*     */     } 
/*     */ 
/*     */     
/*  99 */     if ((this.typeMask & 0x8) == 8 && this.rowBased) {
/* 100 */       throw DbException.get(90005, this.triggerName);
/*     */     }
/*     */ 
/*     */     
/* 104 */     int i = getObjectId();
/* 105 */     Table table = getSchema().getTableOrView(this.session, this.tableName);
/* 106 */     TriggerObject triggerObject = new TriggerObject(getSchema(), i, this.triggerName, table);
/* 107 */     triggerObject.setInsteadOf(this.insteadOf);
/* 108 */     triggerObject.setBefore(this.before);
/* 109 */     triggerObject.setNoWait(this.noWait);
/* 110 */     triggerObject.setQueueSize(this.queueSize);
/* 111 */     triggerObject.setRowBased(this.rowBased);
/* 112 */     triggerObject.setTypeMask(this.typeMask);
/* 113 */     triggerObject.setOnRollback(this.onRollback);
/* 114 */     if (this.triggerClassName != null) {
/* 115 */       triggerObject.setTriggerClassName(this.triggerClassName, this.force);
/*     */     } else {
/* 117 */       triggerObject.setTriggerSource(this.triggerSource, this.force);
/*     */     } 
/* 119 */     database.addSchemaObject(this.session, (SchemaObject)triggerObject);
/* 120 */     table.addTrigger(triggerObject);
/* 121 */     return 0;
/*     */   }
/*     */   
/*     */   public void setForce(boolean paramBoolean) {
/* 125 */     this.force = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setOnRollback(boolean paramBoolean) {
/* 129 */     this.onRollback = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 134 */     return 31;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateTrigger.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */