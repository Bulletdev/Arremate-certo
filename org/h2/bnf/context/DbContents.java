/*     */ package org.h2.bnf.context;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.Parser;
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
/*     */ public class DbContents
/*     */ {
/*     */   private DbSchema[] schemas;
/*     */   private DbSchema defaultSchema;
/*     */   private boolean isOracle;
/*     */   private boolean isH2;
/*     */   private boolean isPostgreSQL;
/*     */   private boolean isDerby;
/*     */   private boolean isSQLite;
/*     */   private boolean isH2ModeMySQL;
/*     */   private boolean isMySQL;
/*     */   private boolean isFirebird;
/*     */   private boolean isMSSQLServer;
/*     */   private boolean isDB2;
/*     */   
/*     */   public DbSchema getDefaultSchema() {
/*  42 */     return this.defaultSchema;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDerby() {
/*  49 */     return this.isDerby;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isFirebird() {
/*  56 */     return this.isFirebird;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isH2() {
/*  63 */     return this.isH2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isH2ModeMySQL() {
/*  70 */     return this.isH2ModeMySQL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMSSQLServer() {
/*  77 */     return this.isMSSQLServer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isMySQL() {
/*  84 */     return this.isMySQL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOracle() {
/*  91 */     return this.isOracle;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isPostgreSQL() {
/*  98 */     return this.isPostgreSQL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSQLite() {
/* 105 */     return this.isSQLite;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDB2() {
/* 112 */     return this.isDB2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DbSchema[] getSchemas() {
/* 119 */     return this.schemas;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void readContents(String paramString, Connection paramConnection) throws SQLException {
/* 130 */     this.isH2 = paramString.startsWith("jdbc:h2:");
/* 131 */     if (this.isH2) {
/* 132 */       PreparedStatement preparedStatement = paramConnection.prepareStatement("SELECT UPPER(VALUE) FROM INFORMATION_SCHEMA.SETTINGS WHERE NAME=?");
/*     */ 
/*     */       
/* 135 */       preparedStatement.setString(1, "MODE");
/* 136 */       ResultSet resultSet = preparedStatement.executeQuery();
/* 137 */       resultSet.next();
/* 138 */       if ("MYSQL".equals(resultSet.getString(1))) {
/* 139 */         this.isH2ModeMySQL = true;
/*     */       }
/* 141 */       resultSet.close();
/* 142 */       preparedStatement.close();
/*     */     } 
/* 144 */     this.isDB2 = paramString.startsWith("jdbc:db2:");
/* 145 */     this.isSQLite = paramString.startsWith("jdbc:sqlite:");
/* 146 */     this.isOracle = paramString.startsWith("jdbc:oracle:");
/*     */     
/* 148 */     this.isPostgreSQL = (paramString.startsWith("jdbc:postgresql:") || paramString.startsWith("jdbc:vertica:"));
/*     */     
/* 150 */     this.isMySQL = paramString.startsWith("jdbc:mysql:");
/* 151 */     this.isDerby = paramString.startsWith("jdbc:derby:");
/* 152 */     this.isFirebird = paramString.startsWith("jdbc:firebirdsql:");
/* 153 */     this.isMSSQLServer = paramString.startsWith("jdbc:sqlserver:");
/* 154 */     DatabaseMetaData databaseMetaData = paramConnection.getMetaData();
/* 155 */     String str = getDefaultSchemaName(databaseMetaData);
/* 156 */     String[] arrayOfString = getSchemaNames(databaseMetaData);
/* 157 */     this.schemas = new DbSchema[arrayOfString.length];
/* 158 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 159 */       String str1 = arrayOfString[b];
/* 160 */       boolean bool = (str == null || str.equals(str1)) ? true : false;
/*     */       
/* 162 */       DbSchema dbSchema = new DbSchema(this, str1, bool);
/* 163 */       if (bool) {
/* 164 */         this.defaultSchema = dbSchema;
/*     */       }
/* 166 */       this.schemas[b] = dbSchema;
/* 167 */       String[] arrayOfString1 = { "TABLE", "SYSTEM TABLE", "VIEW", "SYSTEM VIEW", "TABLE LINK", "SYNONYM", "EXTERNAL" };
/*     */       
/* 169 */       dbSchema.readTables(databaseMetaData, arrayOfString1);
/* 170 */       if (!this.isPostgreSQL && !this.isDB2) {
/* 171 */         dbSchema.readProcedures(databaseMetaData);
/*     */       }
/*     */     } 
/* 174 */     if (this.defaultSchema == null) {
/* 175 */       String str1 = null;
/* 176 */       for (DbSchema dbSchema : this.schemas) {
/* 177 */         if ("dbo".equals(dbSchema.name)) {
/*     */           
/* 179 */           this.defaultSchema = dbSchema;
/*     */           break;
/*     */         } 
/* 182 */         if (this.defaultSchema == null || str1 == null || dbSchema.name.length() < str1.length()) {
/*     */ 
/*     */           
/* 185 */           str1 = dbSchema.name;
/* 186 */           this.defaultSchema = dbSchema;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private String[] getSchemaNames(DatabaseMetaData paramDatabaseMetaData) throws SQLException {
/* 193 */     if (this.isMySQL || this.isSQLite)
/* 194 */       return new String[] { "" }; 
/* 195 */     if (this.isFirebird) {
/* 196 */       return new String[] { null };
/*     */     }
/* 198 */     ResultSet resultSet = paramDatabaseMetaData.getSchemas();
/* 199 */     ArrayList<String> arrayList = New.arrayList();
/* 200 */     while (resultSet.next()) {
/* 201 */       String str = resultSet.getString("TABLE_SCHEM");
/* 202 */       String[] arrayOfString1 = null;
/* 203 */       if (this.isOracle) {
/* 204 */         arrayOfString1 = new String[] { "CTXSYS", "DIP", "DBSNMP", "DMSYS", "EXFSYS", "FLOWS_020100", "FLOWS_FILES", "MDDATA", "MDSYS", "MGMT_VIEW", "OLAPSYS", "ORDSYS", "ORDPLUGINS", "OUTLN", "SI_INFORMTN_SCHEMA", "SYS", "SYSMAN", "SYSTEM", "TSMSYS", "WMSYS", "XDB" };
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 209 */       else if (this.isMSSQLServer) {
/* 210 */         arrayOfString1 = new String[] { "sys", "db_accessadmin", "db_backupoperator", "db_datareader", "db_datawriter", "db_ddladmin", "db_denydatareader", "db_denydatawriter", "db_owner", "db_securityadmin" };
/*     */ 
/*     */       
/*     */       }
/* 214 */       else if (this.isDB2) {
/* 215 */         arrayOfString1 = new String[] { "NULLID", "SYSFUN", "SYSIBMINTERNAL", "SYSIBMTS", "SYSPROC", "SYSPUBLIC", "SYSCAT", "SYSIBM", "SYSIBMADM", "SYSSTAT", "SYSTOOLS" };
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 223 */       if (arrayOfString1 != null) {
/* 224 */         for (String str1 : arrayOfString1) {
/* 225 */           if (str1.equals(str)) {
/* 226 */             str = null;
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/* 231 */       if (str == null) {
/*     */         continue;
/*     */       }
/* 234 */       arrayList.add(str);
/*     */     } 
/* 236 */     resultSet.close();
/* 237 */     String[] arrayOfString = new String[arrayList.size()];
/* 238 */     arrayList.toArray(arrayOfString);
/* 239 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   private String getDefaultSchemaName(DatabaseMetaData paramDatabaseMetaData) {
/* 243 */     String str = "";
/*     */     try {
/* 245 */       if (this.isOracle)
/* 246 */         return paramDatabaseMetaData.getUserName(); 
/* 247 */       if (this.isPostgreSQL)
/* 248 */         return "public"; 
/* 249 */       if (this.isMySQL)
/* 250 */         return ""; 
/* 251 */       if (this.isDerby)
/* 252 */         return StringUtils.toUpperEnglish(paramDatabaseMetaData.getUserName()); 
/* 253 */       if (this.isFirebird) {
/* 254 */         return null;
/*     */       }
/* 256 */       ResultSet resultSet = paramDatabaseMetaData.getSchemas();
/* 257 */       int i = resultSet.findColumn("IS_DEFAULT");
/* 258 */       while (resultSet.next()) {
/* 259 */         if (resultSet.getBoolean(i)) {
/* 260 */           str = resultSet.getString("TABLE_SCHEM");
/*     */         }
/*     */       } 
/* 263 */     } catch (SQLException sQLException) {}
/*     */ 
/*     */     
/* 266 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String quoteIdentifier(String paramString) {
/* 277 */     if (paramString == null) {
/* 278 */       return null;
/*     */     }
/* 280 */     if (this.isH2 && !this.isH2ModeMySQL) {
/* 281 */       return Parser.quoteIdentifier(paramString);
/*     */     }
/* 283 */     return StringUtils.toUpperEnglish(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\bnf\context\DbContents.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */