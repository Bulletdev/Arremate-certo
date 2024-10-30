/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.Reader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.ScriptReader;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.Tool;
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
/*     */ public class RunScript
/*     */   extends Tool
/*     */ {
/*     */   private boolean showResults;
/*     */   private boolean checkResults;
/*     */   
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  68 */     (new RunScript()).runTool(paramVarArgs);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  91 */     String str1 = null;
/*  92 */     String str2 = "";
/*  93 */     String str3 = "";
/*  94 */     String str4 = "backup.sql";
/*  95 */     String str5 = null;
/*  96 */     boolean bool1 = false;
/*  97 */     boolean bool2 = false;
/*  98 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  99 */       String str = paramVarArgs[b];
/* 100 */       if (str.equals("-url"))
/* 101 */       { str1 = paramVarArgs[++b]; }
/* 102 */       else if (str.equals("-user"))
/* 103 */       { str2 = paramVarArgs[++b]; }
/* 104 */       else if (str.equals("-password"))
/* 105 */       { str3 = paramVarArgs[++b]; }
/* 106 */       else if (str.equals("-continueOnError"))
/* 107 */       { bool1 = true; }
/* 108 */       else if (str.equals("-checkResults"))
/* 109 */       { this.checkResults = true; }
/* 110 */       else if (str.equals("-showResults"))
/* 111 */       { this.showResults = true; }
/* 112 */       else if (str.equals("-script"))
/* 113 */       { str4 = paramVarArgs[++b]; }
/* 114 */       else if (str.equals("-time"))
/* 115 */       { bool2 = true; }
/* 116 */       else if (str.equals("-driver"))
/* 117 */       { String str6 = paramVarArgs[++b];
/* 118 */         JdbcUtils.loadUserClass(str6); }
/* 119 */       else if (str.equals("-options"))
/* 120 */       { StringBuilder stringBuilder = new StringBuilder();
/* 121 */         b++;
/* 122 */         for (; b < paramVarArgs.length; b++) {
/* 123 */           stringBuilder.append(' ').append(paramVarArgs[b]);
/*     */         }
/* 125 */         str5 = stringBuilder.toString(); }
/* 126 */       else { if (str.equals("-help") || str.equals("-?")) {
/* 127 */           showUsage();
/*     */           return;
/*     */         } 
/* 130 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/* 133 */     if (str1 == null) {
/* 134 */       showUsage();
/* 135 */       throw new SQLException("URL not set");
/*     */     } 
/* 137 */     long l = System.currentTimeMillis();
/* 138 */     if (str5 != null) {
/* 139 */       processRunscript(str1, str2, str3, str4, str5);
/*     */     } else {
/* 141 */       process(str1, str2, str3, str4, (Charset)null, bool1);
/*     */     } 
/* 143 */     if (bool2) {
/* 144 */       l = System.currentTimeMillis() - l;
/* 145 */       this.out.println("Done in " + l + " ms");
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
/*     */   public static ResultSet execute(Connection paramConnection, Reader paramReader) throws SQLException {
/* 159 */     Statement statement = paramConnection.createStatement();
/* 160 */     ResultSet resultSet = null;
/* 161 */     ScriptReader scriptReader = new ScriptReader(paramReader);
/*     */     while (true) {
/* 163 */       String str = scriptReader.readStatement();
/* 164 */       if (str == null) {
/*     */         break;
/*     */       }
/* 167 */       if (str.trim().length() == 0) {
/*     */         continue;
/*     */       }
/* 170 */       boolean bool = statement.execute(str);
/* 171 */       if (bool) {
/* 172 */         if (resultSet != null) {
/* 173 */           resultSet.close();
/* 174 */           resultSet = null;
/*     */         } 
/* 176 */         resultSet = statement.getResultSet();
/*     */       } 
/*     */     } 
/* 179 */     return resultSet;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void process(Connection paramConnection, String paramString, boolean paramBoolean, Charset paramCharset) throws SQLException, IOException {
/* 185 */     InputStream inputStream = FileUtils.newInputStream(paramString);
/* 186 */     String str = FileUtils.getParent(paramString);
/*     */     try {
/* 188 */       inputStream = new BufferedInputStream(inputStream, 4096);
/* 189 */       InputStreamReader inputStreamReader = new InputStreamReader(inputStream, paramCharset);
/* 190 */       process(paramConnection, paramBoolean, str, inputStreamReader, paramCharset);
/*     */     } finally {
/* 192 */       IOUtils.closeSilently(inputStream);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void process(Connection paramConnection, boolean paramBoolean, String paramString, Reader paramReader, Charset paramCharset) throws SQLException, IOException {
/* 198 */     Statement statement = paramConnection.createStatement();
/* 199 */     ScriptReader scriptReader = new ScriptReader(paramReader);
/*     */     while (true) {
/* 201 */       String str1 = scriptReader.readStatement();
/* 202 */       if (str1 == null) {
/*     */         break;
/*     */       }
/* 205 */       String str2 = str1.trim();
/* 206 */       if (str2.length() == 0) {
/*     */         continue;
/*     */       }
/* 209 */       if (str2.startsWith("@") && StringUtils.toUpperEnglish(str2).startsWith("@INCLUDE")) {
/*     */         
/* 211 */         str1 = str2;
/* 212 */         str1 = str1.substring("@INCLUDE".length()).trim();
/* 213 */         if (!FileUtils.isAbsolute(str1)) {
/* 214 */           str1 = paramString + SysProperties.FILE_SEPARATOR + str1;
/*     */         }
/* 216 */         process(paramConnection, str1, paramBoolean, paramCharset); continue;
/*     */       } 
/*     */       try {
/* 219 */         if (this.showResults && !str2.startsWith("-->")) {
/* 220 */           this.out.print(str1 + ";");
/*     */         }
/* 222 */         if (this.showResults || this.checkResults) {
/* 223 */           boolean bool = statement.execute(str1);
/* 224 */           if (bool) {
/* 225 */             ResultSet resultSet = statement.getResultSet();
/* 226 */             int i = resultSet.getMetaData().getColumnCount();
/* 227 */             StringBuilder stringBuilder = new StringBuilder();
/* 228 */             while (resultSet.next()) {
/* 229 */               stringBuilder.append("\n-->");
/* 230 */               for (byte b = 0; b < i; b++) {
/* 231 */                 String str3 = resultSet.getString(b + 1);
/* 232 */                 if (str3 != null) {
/* 233 */                   str3 = StringUtils.replaceAll(str3, "\r\n", "\n");
/* 234 */                   str3 = StringUtils.replaceAll(str3, "\n", "\n-->    ");
/* 235 */                   str3 = StringUtils.replaceAll(str3, "\r", "\r-->    ");
/*     */                 } 
/* 237 */                 stringBuilder.append(' ').append(str3);
/*     */               } 
/*     */             } 
/* 240 */             stringBuilder.append("\n;");
/* 241 */             String str = stringBuilder.toString();
/* 242 */             if (this.showResults) {
/* 243 */               this.out.print(str);
/*     */             }
/* 245 */             if (this.checkResults) {
/* 246 */               String str3 = scriptReader.readStatement() + ";";
/* 247 */               str3 = StringUtils.replaceAll(str3, "\r\n", "\n");
/* 248 */               str3 = StringUtils.replaceAll(str3, "\r", "\n");
/* 249 */               if (!str3.equals(str)) {
/* 250 */                 str3 = StringUtils.replaceAll(str3, " ", "+");
/* 251 */                 str = StringUtils.replaceAll(str, " ", "+");
/* 252 */                 throw new SQLException("Unexpected output for:\n" + str1.trim() + "\nGot:\n" + str + "\nExpected:\n" + str3);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/*     */           continue;
/*     */         } 
/*     */         
/* 260 */         statement.execute(str1);
/*     */       }
/* 262 */       catch (Exception exception) {
/* 263 */         if (paramBoolean) {
/* 264 */           exception.printStackTrace(this.out); continue;
/*     */         } 
/* 266 */         throw DbException.toSQLException(exception);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void processRunscript(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws SQLException {
/* 275 */     Connection connection = null;
/* 276 */     Statement statement = null;
/*     */     try {
/* 278 */       Driver.load();
/* 279 */       connection = DriverManager.getConnection(paramString1, paramString2, paramString3);
/* 280 */       statement = connection.createStatement();
/* 281 */       String str = "RUNSCRIPT FROM '" + paramString4 + "' " + paramString5;
/* 282 */       statement.execute(str);
/*     */     } finally {
/* 284 */       JdbcUtils.closeSilently(statement);
/* 285 */       JdbcUtils.closeSilently(connection);
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
/*     */ 
/*     */   
/*     */   public static void execute(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, boolean paramBoolean) throws SQLException {
/* 303 */     (new RunScript()).process(paramString1, paramString2, paramString3, paramString4, paramCharset, paramBoolean);
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
/*     */ 
/*     */ 
/*     */   
/*     */   void process(String paramString1, String paramString2, String paramString3, String paramString4, Charset paramCharset, boolean paramBoolean) throws SQLException {
/*     */     try {
/* 322 */       Driver.load();
/* 323 */       Connection connection = DriverManager.getConnection(paramString1, paramString2, paramString3);
/* 324 */       if (paramCharset == null) {
/* 325 */         paramCharset = Constants.UTF8;
/*     */       }
/*     */       try {
/* 328 */         process(connection, paramString4, paramBoolean, paramCharset);
/*     */       } finally {
/* 330 */         connection.close();
/*     */       } 
/* 332 */     } catch (IOException iOException) {
/* 333 */       throw DbException.convertIOException(iOException, paramString4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\RunScript.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */