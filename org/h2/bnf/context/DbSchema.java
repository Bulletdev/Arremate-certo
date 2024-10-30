/*     */ package org.h2.bnf.context;
/*     */ 
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.util.New;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DbSchema
/*     */ {
/*     */   public final String name;
/*     */   public final boolean isDefault;
/*     */   public final boolean isSystem;
/*     */   public final String quotedName;
/*     */   private final DbContents contents;
/*     */   private DbTableOrView[] tables;
/*     */   private DbProcedure[] procedures;
/*     */   
/*     */   DbSchema(DbContents paramDbContents, String paramString, boolean paramBoolean) {
/*  59 */     this.contents = paramDbContents;
/*  60 */     this.name = paramString;
/*  61 */     this.quotedName = paramDbContents.quoteIdentifier(paramString);
/*  62 */     this.isDefault = paramBoolean;
/*  63 */     if (paramString == null) {
/*     */       
/*  65 */       this.isSystem = true;
/*  66 */     } else if ("INFORMATION_SCHEMA".equals(paramString)) {
/*  67 */       this.isSystem = true;
/*  68 */     } else if (!paramDbContents.isH2() && StringUtils.toUpperEnglish(paramString).startsWith("INFO")) {
/*     */       
/*  70 */       this.isSystem = true;
/*  71 */     } else if (paramDbContents.isPostgreSQL() && StringUtils.toUpperEnglish(paramString).startsWith("PG_")) {
/*     */       
/*  73 */       this.isSystem = true;
/*  74 */     } else if (paramDbContents.isDerby() && paramString.startsWith("SYS")) {
/*  75 */       this.isSystem = true;
/*     */     } else {
/*  77 */       this.isSystem = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbContents getContents() {
/*  85 */     return this.contents;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbTableOrView[] getTables() {
/*  92 */     return this.tables;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbProcedure[] getProcedures() {
/*  99 */     return this.procedures;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readTables(DatabaseMetaData paramDatabaseMetaData, String[] paramArrayOfString) throws SQLException {
/* 110 */     ResultSet resultSet = paramDatabaseMetaData.getTables(null, this.name, null, paramArrayOfString);
/* 111 */     ArrayList<DbTableOrView> arrayList = New.arrayList();
/* 112 */     while (resultSet.next()) {
/* 113 */       DbTableOrView dbTableOrView = new DbTableOrView(this, resultSet);
/* 114 */       if (this.contents.isOracle() && dbTableOrView.getName().indexOf('$') > 0) {
/*     */         continue;
/*     */       }
/* 117 */       arrayList.add(dbTableOrView);
/*     */     } 
/* 119 */     resultSet.close();
/* 120 */     this.tables = new DbTableOrView[arrayList.size()];
/* 121 */     arrayList.toArray(this.tables);
/* 122 */     if (this.tables.length < SysProperties.CONSOLE_MAX_TABLES_LIST_COLUMNS) {
/* 123 */       for (DbTableOrView dbTableOrView : this.tables) {
/*     */         try {
/* 125 */           dbTableOrView.readColumns(paramDatabaseMetaData);
/* 126 */         } catch (SQLException sQLException) {}
/*     */       } 
/*     */     }
/*     */   }
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
/*     */   public void readProcedures(DatabaseMetaData paramDatabaseMetaData) throws SQLException {
/* 143 */     ResultSet resultSet = paramDatabaseMetaData.getProcedures(null, this.name, null);
/* 144 */     ArrayList<DbProcedure> arrayList = New.arrayList();
/* 145 */     while (resultSet.next()) {
/* 146 */       arrayList.add(new DbProcedure(this, resultSet));
/*     */     }
/* 148 */     resultSet.close();
/* 149 */     this.procedures = new DbProcedure[arrayList.size()];
/* 150 */     arrayList.toArray(this.procedures);
/* 151 */     if (this.procedures.length < SysProperties.CONSOLE_MAX_PROCEDURES_LIST_COLUMNS)
/* 152 */       for (DbProcedure dbProcedure : this.procedures)
/* 153 */         dbProcedure.readParameters(paramDatabaseMetaData);  
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\context\DbSchema.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */