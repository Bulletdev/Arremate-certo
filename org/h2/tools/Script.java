/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import org.h2.Driver;
/*     */ import org.h2.util.JdbcUtils;
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
/*     */ public class Script
/*     */   extends Tool
/*     */ {
/*     */   public static void main(String... paramVarArgs) throws SQLException {
/*  45 */     (new Script()).runTool(paramVarArgs);
/*     */   }
/*     */ 
/*     */   
/*     */   public void runTool(String... paramVarArgs) throws SQLException {
/*  50 */     String str1 = null;
/*  51 */     String str2 = "";
/*  52 */     String str3 = "";
/*  53 */     String str4 = "backup.sql";
/*  54 */     String str5 = "";
/*  55 */     String str6 = "";
/*  56 */     for (byte b = 0; paramVarArgs != null && b < paramVarArgs.length; b++) {
/*  57 */       String str = paramVarArgs[b];
/*  58 */       if (str.equals("-url"))
/*  59 */       { str1 = paramVarArgs[++b]; }
/*  60 */       else if (str.equals("-user"))
/*  61 */       { str2 = paramVarArgs[++b]; }
/*  62 */       else if (str.equals("-password"))
/*  63 */       { str3 = paramVarArgs[++b]; }
/*  64 */       else if (str.equals("-script"))
/*  65 */       { str4 = paramVarArgs[++b]; }
/*  66 */       else if (str.equals("-options"))
/*  67 */       { StringBuilder stringBuilder1 = new StringBuilder();
/*  68 */         StringBuilder stringBuilder2 = new StringBuilder();
/*  69 */         b++;
/*  70 */         for (; b < paramVarArgs.length; b++) {
/*  71 */           String str7 = paramVarArgs[b];
/*  72 */           String str8 = StringUtils.toUpperEnglish(str7);
/*  73 */           if ("SIMPLE".equals(str8) || str8.startsWith("NO") || "DROP".equals(str8)) {
/*  74 */             stringBuilder1.append(' ');
/*  75 */             stringBuilder1.append(paramVarArgs[b]);
/*  76 */           } else if ("BLOCKSIZE".equals(str8)) {
/*  77 */             stringBuilder1.append(' ');
/*  78 */             stringBuilder1.append(paramVarArgs[b]);
/*  79 */             b++;
/*  80 */             stringBuilder1.append(' ');
/*  81 */             stringBuilder1.append(paramVarArgs[b]);
/*     */           } else {
/*  83 */             stringBuilder2.append(' ');
/*  84 */             stringBuilder2.append(paramVarArgs[b]);
/*     */           } 
/*     */         } 
/*  87 */         str5 = stringBuilder1.toString();
/*  88 */         str6 = stringBuilder2.toString(); }
/*  89 */       else { if (str.equals("-help") || str.equals("-?")) {
/*  90 */           showUsage();
/*     */           return;
/*     */         } 
/*  93 */         showUsageAndThrowUnsupportedOption(str); }
/*     */     
/*     */     } 
/*  96 */     if (str1 == null) {
/*  97 */       showUsage();
/*  98 */       throw new SQLException("URL not set");
/*     */     } 
/* 100 */     process(str1, str2, str3, str4, str5, str6);
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
/*     */   public static void process(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) throws SQLException {
/* 115 */     Connection connection = null;
/*     */     try {
/* 117 */       Driver.load();
/* 118 */       connection = DriverManager.getConnection(paramString1, paramString2, paramString3);
/* 119 */       process(connection, paramString4, paramString5, paramString6);
/*     */     } finally {
/* 121 */       JdbcUtils.closeSilently(connection);
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
/*     */   public static void process(Connection paramConnection, String paramString1, String paramString2, String paramString3) throws SQLException {
/* 137 */     try (Statement null = paramConnection.createStatement()) {
/* 138 */       String str = "SCRIPT " + paramString2 + " TO '" + paramString1 + "' " + paramString3;
/* 139 */       statement.execute(str);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\Script.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */