/*     */ package org.h2.bnf.context;
/*     */ 
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
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
/*     */ public class DbColumn
/*     */ {
/*     */   private final String name;
/*     */   private final String quotedName;
/*     */   private final String dataType;
/*     */   private int position;
/*     */   
/*     */   private DbColumn(DbContents paramDbContents, ResultSet paramResultSet, boolean paramBoolean) throws SQLException {
/*     */     String str2;
/*  28 */     this.name = paramResultSet.getString("COLUMN_NAME");
/*  29 */     this.quotedName = paramDbContents.quoteIdentifier(this.name);
/*  30 */     String str1 = paramResultSet.getString("TYPE_NAME");
/*     */ 
/*     */ 
/*     */     
/*  34 */     if (paramBoolean) {
/*  35 */       str2 = "PRECISION";
/*     */     } else {
/*  37 */       str2 = "COLUMN_SIZE";
/*     */     } 
/*  39 */     int i = paramResultSet.getInt(str2);
/*  40 */     this.position = paramResultSet.getInt("ORDINAL_POSITION");
/*  41 */     boolean bool = paramDbContents.isSQLite();
/*  42 */     if (i > 0 && !bool) {
/*  43 */       String str; str1 = str1 + "(" + i;
/*     */       
/*  45 */       if (paramBoolean) {
/*  46 */         str = "SCALE";
/*     */       } else {
/*  48 */         str = "DECIMAL_DIGITS";
/*     */       } 
/*  50 */       int j = paramResultSet.getInt(str);
/*  51 */       if (j > 0) {
/*  52 */         str1 = str1 + ", " + j;
/*     */       }
/*  54 */       str1 = str1 + ")";
/*     */     } 
/*  56 */     if (paramResultSet.getInt("NULLABLE") == 0) {
/*  57 */       str1 = str1 + " NOT NULL";
/*     */     }
/*  59 */     this.dataType = str1;
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
/*     */   public static DbColumn getProcedureColumn(DbContents paramDbContents, ResultSet paramResultSet) throws SQLException {
/*  71 */     return new DbColumn(paramDbContents, paramResultSet, true);
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
/*     */   public static DbColumn getColumn(DbContents paramDbContents, ResultSet paramResultSet) throws SQLException {
/*  83 */     return new DbColumn(paramDbContents, paramResultSet, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDataType() {
/*  91 */     return this.dataType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/*  98 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQuotedName() {
/* 105 */     return this.quotedName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPosition() {
/* 112 */     return this.position;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\context\DbColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */