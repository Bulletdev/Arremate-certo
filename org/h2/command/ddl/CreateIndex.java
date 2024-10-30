/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.index.IndexType;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.IndexColumn;
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
/*     */ public class CreateIndex
/*     */   extends SchemaCommand
/*     */ {
/*     */   private String tableName;
/*     */   private String indexName;
/*     */   private IndexColumn[] indexColumns;
/*     */   private boolean primaryKey;
/*     */   private boolean unique;
/*     */   private boolean hash;
/*     */   private boolean spatial;
/*     */   private boolean ifTableExists;
/*     */   private boolean ifNotExists;
/*     */   private String comment;
/*     */   
/*     */   public CreateIndex(Session paramSession, Schema paramSchema) {
/*  35 */     super(paramSession, paramSchema);
/*     */   }
/*     */   
/*     */   public void setIfTableExists(boolean paramBoolean) {
/*  39 */     this.ifTableExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setIfNotExists(boolean paramBoolean) {
/*  43 */     this.ifNotExists = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  47 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   public void setIndexName(String paramString) {
/*  51 */     this.indexName = paramString;
/*     */   }
/*     */   
/*     */   public void setIndexColumns(IndexColumn[] paramArrayOfIndexColumn) {
/*  55 */     this.indexColumns = paramArrayOfIndexColumn;
/*     */   }
/*     */   
/*     */   public int update() {
/*     */     IndexType indexType;
/*  60 */     if (!this.transactional) {
/*  61 */       this.session.commit(true);
/*     */     }
/*  63 */     Database database = this.session.getDatabase();
/*  64 */     boolean bool = database.isPersistent();
/*  65 */     Table table = getSchema().findTableOrView(this.session, this.tableName);
/*  66 */     if (table == null) {
/*  67 */       if (this.ifTableExists) {
/*  68 */         return 0;
/*     */       }
/*  70 */       throw DbException.get(42102, this.tableName);
/*     */     } 
/*  72 */     if (getSchema().findIndex(this.session, this.indexName) != null) {
/*  73 */       if (this.ifNotExists) {
/*  74 */         return 0;
/*     */       }
/*  76 */       throw DbException.get(42111, this.indexName);
/*     */     } 
/*  78 */     this.session.getUser().checkRight(table, 15);
/*  79 */     table.lock(this.session, true, true);
/*  80 */     if (!table.isPersistIndexes()) {
/*  81 */       bool = false;
/*     */     }
/*  83 */     int i = getObjectId();
/*  84 */     if (this.indexName == null) {
/*  85 */       if (this.primaryKey) {
/*  86 */         this.indexName = table.getSchema().getUniqueIndexName(this.session, table, "PRIMARY_KEY_");
/*     */       } else {
/*     */         
/*  89 */         this.indexName = table.getSchema().getUniqueIndexName(this.session, table, "INDEX_");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  94 */     if (this.primaryKey) {
/*  95 */       if (table.findPrimaryKey() != null) {
/*  96 */         throw DbException.get(90017);
/*     */       }
/*  98 */       indexType = IndexType.createPrimaryKey(bool, this.hash);
/*  99 */     } else if (this.unique) {
/* 100 */       indexType = IndexType.createUnique(bool, this.hash);
/*     */     } else {
/* 102 */       indexType = IndexType.createNonUnique(bool, this.hash, this.spatial);
/*     */     } 
/* 104 */     IndexColumn.mapColumns(this.indexColumns, table);
/* 105 */     table.addIndex(this.session, this.indexName, i, this.indexColumns, indexType, this.create, this.comment);
/*     */     
/* 107 */     return 0;
/*     */   }
/*     */   
/*     */   public void setPrimaryKey(boolean paramBoolean) {
/* 111 */     this.primaryKey = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setUnique(boolean paramBoolean) {
/* 115 */     this.unique = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setHash(boolean paramBoolean) {
/* 119 */     this.hash = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSpatial(boolean paramBoolean) {
/* 123 */     this.spatial = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setComment(String paramString) {
/* 127 */     this.comment = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 132 */     return 25;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\CreateIndex.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */