/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableLink;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CreateLinkedTable
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String tableName;
/*     */   private String driver;
/*     */   private String url;
/*     */   private String user;
/*     */   private String password;
/*     */   private String originalSchema;
/*     */   private String originalTable;
/*     */   private boolean ifNotExists;
/*     */   private String comment;
/*     */   private boolean emitUpdates;
/*     */   private boolean force;
/*     */   private boolean temporary;
/*     */   private boolean globalTemporary;
/*     */   private boolean readOnly;
/*     */   
/*     */   public CreateLinkedTable(Session paramSession, Schema paramSchema) {
/*  33 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  37 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   public void setDriver(String paramString) {
/*  41 */     this.driver = paramString;
/*     */   }
/*     */   
/*     */   public void setOriginalTable(String paramString) {
/*  45 */     this.originalTable = paramString;
/*     */   }
/*     */   
/*     */   public void setPassword(String paramString) {
/*  49 */     this.password = paramString;
/*     */   }
/*     */   
/*     */   public void setUrl(String paramString) {
/*  53 */     this.url = paramString;
/*     */   }
/*     */   
/*     */   public void setUser(String paramString) {
/*  57 */     this.user = paramString;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  61 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  66 */     this.session.commit(true);
/*  67 */     Database database = this.session.getDatabase();
/*  68 */     this.session.getUser().checkAdmin();
/*  69 */     if (getSchema().findTableOrView(this.session, this.tableName) != null) {
/*  70 */       if (this.ifNotExists) {
/*  71 */         return 0;
/*     */       }
/*  73 */       throw DbException.get(42101, this.tableName);
/*     */     } 
/*     */     
/*  76 */     int i = getObjectId();
/*  77 */     TableLink tableLink = getSchema().createTableLink(i, this.tableName, this.driver, this.url, this.user, this.password, this.originalSchema, this.originalTable, this.emitUpdates, this.force);
/*     */     
/*  79 */     tableLink.setTemporary(this.temporary);
/*  80 */     tableLink.setGlobalTemporary(this.globalTemporary);
/*  81 */     tableLink.setComment(this.comment);
/*  82 */     tableLink.setReadOnly(this.readOnly);
/*  83 */     if (this.temporary && !this.globalTemporary) {
/*  84 */       this.session.addLocalTempTable((Table)tableLink);
/*     */     } else {
/*  86 */       database.addSchemaObject(this.session, (SchemaObject)tableLink);
/*     */     } 
/*  88 */     return 0;
/*     */   }
/*     */   
/*     */   public void setEmitUpdates(boolean paramBoolean) {
/*  92 */     this.emitUpdates = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/*  96 */     this.comment = paramString;
/*     */   }
/*     */   
/*     */   public void setForce(boolean paramBoolean) {
/* 100 */     this.force = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTemporary(boolean paramBoolean) {
/* 104 */     this.temporary = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setGlobalTemporary(boolean paramBoolean) {
/* 108 */     this.globalTemporary = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setReadOnly(boolean paramBoolean) {
/* 112 */     this.readOnly = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setOriginalSchema(String paramString) {
/* 116 */     this.originalSchema = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 121 */     return 26;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateLinkedTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */