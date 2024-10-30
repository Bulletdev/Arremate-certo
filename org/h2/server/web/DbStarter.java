/*    */ package org.h2.server.web;
/*    */ 
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import java.sql.Statement;
/*    */ import javax.servlet.ServletContext;
/*    */ import javax.servlet.ServletContextEvent;
/*    */ import javax.servlet.ServletContextListener;
/*    */ import org.h2.Driver;
/*    */ import org.h2.tools.Server;
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
/*    */ public class DbStarter
/*    */   implements ServletContextListener
/*    */ {
/*    */   private Connection conn;
/*    */   private Server server;
/*    */   
/*    */   public void contextInitialized(ServletContextEvent paramServletContextEvent) {
/*    */     try {
/* 32 */       Driver.load();
/*    */ 
/*    */ 
/*    */       
/* 36 */       ServletContext servletContext = paramServletContextEvent.getServletContext();
/* 37 */       String str1 = getParameter(servletContext, "db.url", "jdbc:h2:~/test");
/* 38 */       String str2 = getParameter(servletContext, "db.user", "sa");
/* 39 */       String str3 = getParameter(servletContext, "db.password", "sa");
/*    */ 
/*    */       
/* 42 */       String str4 = getParameter(servletContext, "db.tcpServer", null);
/* 43 */       if (str4 != null) {
/* 44 */         String[] arrayOfString = StringUtils.arraySplit(str4, ' ', true);
/* 45 */         this.server = Server.createTcpServer(arrayOfString);
/* 46 */         this.server.start();
/*    */       } 
/*    */ 
/*    */ 
/*    */       
/* 51 */       this.conn = DriverManager.getConnection(str1, str2, str3);
/* 52 */       servletContext.setAttribute("connection", this.conn);
/* 53 */     } catch (Exception exception) {
/* 54 */       exception.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static String getParameter(ServletContext paramServletContext, String paramString1, String paramString2) {
/* 60 */     String str = paramServletContext.getInitParameter(paramString1);
/* 61 */     return (str == null) ? paramString2 : str;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Connection getConnection() {
/* 70 */     return this.conn;
/*    */   }
/*    */ 
/*    */   
/*    */   public void contextDestroyed(ServletContextEvent paramServletContextEvent) {
/*    */     try {
/* 76 */       Statement statement = this.conn.createStatement();
/* 77 */       statement.execute("SHUTDOWN");
/* 78 */       statement.close();
/* 79 */     } catch (Exception exception) {
/* 80 */       exception.printStackTrace();
/*    */     } 
/*    */     try {
/* 83 */       this.conn.close();
/* 84 */     } catch (Exception exception) {
/* 85 */       exception.printStackTrace();
/*    */     } 
/* 87 */     if (this.server != null) {
/* 88 */       this.server.stop();
/* 89 */       this.server = null;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\server\web\DbStarter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */