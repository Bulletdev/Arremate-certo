/*     */ package org.h2.bnf.context;
/*     */ 
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.util.New;
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
/*     */ public class DbTableOrView
/*     */ {
/*     */   private final DbSchema schema;
/*     */   private final String name;
/*     */   private final String quotedName;
/*     */   private final boolean isView;
/*     */   private DbColumn[] columns;
/*     */   
/*     */   public DbTableOrView(DbSchema paramDbSchema, ResultSet paramResultSet) throws SQLException {
/*  46 */     this.schema = paramDbSchema;
/*  47 */     this.name = paramResultSet.getString("TABLE_NAME");
/*  48 */     String str = paramResultSet.getString("TABLE_TYPE");
/*  49 */     this.isView = "VIEW".equals(str);
/*  50 */     this.quotedName = paramDbSchema.getContents().quoteIdentifier(this.name);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbSchema getSchema() {
/*  57 */     return this.schema;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbColumn[] getColumns() {
/*  64 */     return this.columns;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  71 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isView() {
/*  78 */     return this.isView;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQuotedName() {
/*  85 */     return this.quotedName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void readColumns(DatabaseMetaData paramDatabaseMetaData) throws SQLException {
/*  94 */     ResultSet resultSet = paramDatabaseMetaData.getColumns(null, this.schema.name, this.name, null);
/*  95 */     ArrayList<DbColumn> arrayList = New.arrayList();
/*  96 */     while (resultSet.next()) {
/*  97 */       DbColumn dbColumn = DbColumn.getColumn(this.schema.getContents(), resultSet);
/*  98 */       arrayList.add(dbColumn);
/*     */     } 
/* 100 */     resultSet.close();
/* 101 */     this.columns = new DbColumn[arrayList.size()];
/* 102 */     arrayList.toArray(this.columns);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\context\DbTableOrView.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */