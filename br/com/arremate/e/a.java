/*    */ package br.com.arremate.e;
/*    */ 
/*    */ import br.com.arremate.m.y;
/*    */ import java.io.File;
/*    */ import java.sql.Connection;
/*    */ import java.sql.DriverManager;
/*    */ import org.apache.commons.lang3.SystemUtils;
/*    */ import org.slf4j.Logger;
/*    */ import org.slf4j.LoggerFactory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class a
/*    */ {
/* 18 */   private static final Logger LOG = LoggerFactory.getLogger(a.class);
/*    */ 
/*    */   
/*    */   private static final String aD = "./db";
/*    */ 
/*    */   
/*    */   private static final String aE = "./dbtest";
/*    */ 
/*    */   
/*    */   private static final String aF = "arremate";
/*    */   
/*    */   private static Connection a;
/*    */ 
/*    */   
/*    */   public static Connection a() {
/*    */     try {
/* 34 */       if (a == null || a.isClosed()) {
/* 35 */         LOG.debug("Inicializa conexão com o banco");
/* 36 */         Class.forName("org.h2.Driver");
/* 37 */         a = DriverManager.getConnection(I(), "sa", "");
/*    */       }
/*    */     
/* 40 */     } catch (Exception exception) {
/* 41 */       LOG.error("Erro ao conectar com banco de dados", exception);
/* 42 */       a = null;
/*    */     } 
/* 44 */     return a;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void bA() {
/*    */     try {
/* 52 */       if (a != null) {
/* 53 */         LOG.debug("Finaliza conexão com o banco");
/* 54 */         a.close();
/*    */       }
/*    */     
/* 57 */     } catch (Exception exception) {
/* 58 */       LOG.error("Erro ao finalizar conexão com banco de dados", exception);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static Connection b() {
/* 69 */     String str = "./dbtest";
/* 70 */     if (SystemUtils.IS_OS_MAC) {
/* 71 */       str = y.eG + File.separator + "dbtest";
/* 72 */       File file = new File(str);
/* 73 */       if (!file.exists()) {
/* 74 */         file.mkdirs();
/*    */       }
/*    */     } 
/*    */     try {
/* 78 */       return DriverManager.getConnection("jdbc:h2:" + str + "/" + "arremate" + ";AUTO_SERVER=TRUE;MULTI_THREADED=TRUE", "sa", "");
/*    */     
/*    */     }
/* 81 */     catch (Exception exception) {
/*    */       
/* 83 */       return null;
/*    */     } 
/*    */   }
/*    */   public static String I() {
/* 87 */     String str = "./db";
/* 88 */     if (SystemUtils.IS_OS_MAC) {
/* 89 */       str = y.eG + File.separator + "db";
/* 90 */       File file = new File(str);
/* 91 */       if (!file.exists()) {
/* 92 */         file.mkdirs();
/*    */       }
/*    */     } 
/* 95 */     return "jdbc:h2:" + str + "/" + "arremate" + ";AUTO_SERVER=TRUE;MULTI_THREADED=TRUE";
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\e\a.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */