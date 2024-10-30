/*     */ package org.h2.table;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbSettings;
/*     */ import org.h2.mvstore.db.MVTableEngine;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TableBase
/*     */   extends Table
/*     */ {
/*     */   private final String tableEngine;
/*  30 */   private List<String> tableEngineParams = new ArrayList<>();
/*     */   
/*     */   private final boolean globalTemporary;
/*     */   
/*     */   public TableBase(CreateTableData paramCreateTableData) {
/*  35 */     super(paramCreateTableData.schema, paramCreateTableData.id, paramCreateTableData.tableName, paramCreateTableData.persistIndexes, paramCreateTableData.persistData);
/*     */     
/*  37 */     this.tableEngine = paramCreateTableData.tableEngine;
/*  38 */     this.globalTemporary = paramCreateTableData.globalTemporary;
/*  39 */     if (paramCreateTableData.tableEngineParams != null) {
/*  40 */       this.tableEngineParams = paramCreateTableData.tableEngineParams;
/*     */     }
/*  42 */     setTemporary(paramCreateTableData.temporary);
/*  43 */     Column[] arrayOfColumn = new Column[paramCreateTableData.columns.size()];
/*  44 */     paramCreateTableData.columns.toArray((Object[])arrayOfColumn);
/*  45 */     setColumns(arrayOfColumn);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  50 */     return "DROP TABLE IF EXISTS " + getSQL() + " CASCADE";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  55 */     Database database = getDatabase();
/*  56 */     if (database == null)
/*     */     {
/*  58 */       return null;
/*     */     }
/*  60 */     StatementBuilder statementBuilder = new StatementBuilder("CREATE ");
/*  61 */     if (isTemporary()) {
/*  62 */       if (isGlobalTemporary()) {
/*  63 */         statementBuilder.append("GLOBAL ");
/*     */       } else {
/*  65 */         statementBuilder.append("LOCAL ");
/*     */       } 
/*  67 */       statementBuilder.append("TEMPORARY ");
/*  68 */     } else if (isPersistIndexes()) {
/*  69 */       statementBuilder.append("CACHED ");
/*     */     } else {
/*  71 */       statementBuilder.append("MEMORY ");
/*     */     } 
/*  73 */     statementBuilder.append("TABLE ");
/*  74 */     if (this.isHidden) {
/*  75 */       statementBuilder.append("IF NOT EXISTS ");
/*     */     }
/*  77 */     statementBuilder.append(getSQL());
/*  78 */     if (this.comment != null) {
/*  79 */       statementBuilder.append(" COMMENT ").append(StringUtils.quoteStringSQL(this.comment));
/*     */     }
/*  81 */     statementBuilder.append("(\n    ");
/*  82 */     for (Column column : this.columns) {
/*  83 */       statementBuilder.appendExceptFirst(",\n    ");
/*  84 */       statementBuilder.append(column.getCreateSQL());
/*     */     } 
/*  86 */     statementBuilder.append("\n)");
/*  87 */     if (this.tableEngine != null) {
/*  88 */       DbSettings dbSettings = database.getSettings();
/*  89 */       String str = dbSettings.defaultTableEngine;
/*  90 */       if (str == null && dbSettings.mvStore) {
/*  91 */         str = MVTableEngine.class.getName();
/*     */       }
/*  93 */       if (str == null || !this.tableEngine.endsWith(str)) {
/*  94 */         statementBuilder.append("\nENGINE ");
/*  95 */         statementBuilder.append(StringUtils.quoteIdentifier(this.tableEngine));
/*     */       } 
/*     */     } 
/*  98 */     if (!this.tableEngineParams.isEmpty()) {
/*  99 */       statementBuilder.append("\nWITH ");
/* 100 */       statementBuilder.resetCount();
/* 101 */       for (String str : this.tableEngineParams) {
/* 102 */         statementBuilder.appendExceptFirst(", ");
/* 103 */         statementBuilder.append(StringUtils.quoteIdentifier(str));
/*     */       } 
/*     */     } 
/* 106 */     if (!isPersistIndexes() && !isPersistData()) {
/* 107 */       statementBuilder.append("\nNOT PERSISTENT");
/*     */     }
/* 109 */     if (this.isHidden) {
/* 110 */       statementBuilder.append("\nHIDDEN");
/*     */     }
/* 112 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isGlobalTemporary() {
/* 117 */     return this.globalTemporary;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\TableBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */