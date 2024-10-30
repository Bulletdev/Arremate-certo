/*    */ package org.h2.table;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import java.sql.Statement;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.tools.SimpleResultSet;
/*    */ import org.h2.util.JdbcUtils;
/*    */ import org.h2.util.StringUtils;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinkSchema
/*    */ {
/*    */   public static ResultSet linkSchema(Connection paramConnection, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6) {
/* 44 */     Connection connection = null;
/* 45 */     Statement statement = null;
/* 46 */     ResultSet resultSet = null;
/* 47 */     SimpleResultSet simpleResultSet = new SimpleResultSet();
/* 48 */     simpleResultSet.setAutoClose(false);
/* 49 */     simpleResultSet.addColumn("TABLE_NAME", 12, 2147483647, 0);
/*    */     try {
/* 51 */       connection = JdbcUtils.getConnection(paramString2, paramString3, paramString4, paramString5);
/* 52 */       statement = paramConnection.createStatement();
/* 53 */       statement.execute("CREATE SCHEMA IF NOT EXISTS " + StringUtils.quoteIdentifier(paramString1));
/*    */       
/* 55 */       resultSet = connection.getMetaData().getTables(null, paramString6, null, null);
/* 56 */       while (resultSet.next()) {
/* 57 */         String str = resultSet.getString("TABLE_NAME");
/* 58 */         StringBuilder stringBuilder = new StringBuilder();
/* 59 */         stringBuilder.append("DROP TABLE IF EXISTS ").append(StringUtils.quoteIdentifier(paramString1)).append('.').append(StringUtils.quoteIdentifier(str));
/*    */ 
/*    */ 
/*    */         
/* 63 */         statement.execute(stringBuilder.toString());
/* 64 */         stringBuilder = new StringBuilder();
/* 65 */         stringBuilder.append("CREATE LINKED TABLE ").append(StringUtils.quoteIdentifier(paramString1)).append('.').append(StringUtils.quoteIdentifier(str)).append('(').append(StringUtils.quoteStringSQL(paramString2)).append(", ").append(StringUtils.quoteStringSQL(paramString3)).append(", ").append(StringUtils.quoteStringSQL(paramString4)).append(", ").append(StringUtils.quoteStringSQL(paramString5)).append(", ").append(StringUtils.quoteStringSQL(str)).append(')');
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */         
/* 80 */         statement.execute(stringBuilder.toString());
/* 81 */         simpleResultSet.addRow(new Object[] { str });
/*    */       } 
/* 83 */     } catch (SQLException sQLException) {
/* 84 */       throw DbException.convert(sQLException);
/*    */     } finally {
/* 86 */       JdbcUtils.closeSilently(resultSet);
/* 87 */       JdbcUtils.closeSilently(connection);
/* 88 */       JdbcUtils.closeSilently(statement);
/*    */     } 
/* 90 */     return (ResultSet)simpleResultSet;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\table\LinkSchema.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */