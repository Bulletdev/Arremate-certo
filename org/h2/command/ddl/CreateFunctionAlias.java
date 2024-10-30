/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.FunctionAlias;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class CreateFunctionAlias
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String aliasName;
/*     */   private String javaClassMethod;
/*     */   private boolean deterministic;
/*     */   private boolean ifNotExists;
/*     */   private boolean force;
/*     */   private String source;
/*     */   private boolean bufferResultSetToLocalTemp = true;
/*     */   
/*     */   public CreateFunctionAlias(Session paramSession, Schema paramSchema) {
/*  32 */     super(paramSession, paramSchema);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  37 */     this.session.commit(true);
/*  38 */     this.session.getUser().checkAdmin();
/*  39 */     Database database = this.session.getDatabase();
/*  40 */     if (getSchema().findFunction(this.aliasName) != null) {
/*  41 */       if (!this.ifNotExists) {
/*  42 */         throw DbException.get(90076, this.aliasName);
/*     */       }
/*     */     } else {
/*     */       FunctionAlias functionAlias;
/*  46 */       int i = getObjectId();
/*     */       
/*  48 */       if (this.javaClassMethod != null) {
/*  49 */         functionAlias = FunctionAlias.newInstance(getSchema(), i, this.aliasName, this.javaClassMethod, this.force, this.bufferResultSetToLocalTemp);
/*     */       }
/*     */       else {
/*     */         
/*  53 */         functionAlias = FunctionAlias.newInstanceFromSource(getSchema(), i, this.aliasName, this.source, this.force, this.bufferResultSetToLocalTemp);
/*     */       } 
/*     */ 
/*     */       
/*  57 */       functionAlias.setDeterministic(this.deterministic);
/*  58 */       database.addSchemaObject(this.session, (SchemaObject)functionAlias);
/*     */     } 
/*  60 */     return 0;
/*     */   }
/*     */   
/*     */   public void setAliasName(String paramString) {
/*  64 */     this.aliasName = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJavaClassMethod(String paramString) {
/*  73 */     this.javaClassMethod = StringUtils.replaceAll(paramString, " ", "");
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  77 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setForce(boolean paramBoolean) {
/*  81 */     this.force = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setDeterministic(boolean paramBoolean) {
/*  85 */     this.deterministic = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBufferResultSetToLocalTemp(boolean paramBoolean) {
/*  94 */     this.bufferResultSetToLocalTemp = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSource(String paramString) {
/*  98 */     this.source = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 103 */     return 24;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateFunctionAlias.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */