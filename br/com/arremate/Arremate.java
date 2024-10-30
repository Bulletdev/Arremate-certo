/*     */ package br.com.arremate;
/*     */ 
/*     */ import br.com.arremate.e.a;
/*     */ import br.com.arremate.m.y;
/*     */ import br.com.arremate.n.m;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.Statement;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.swing.JOptionPane;
/*     */ import javax.swing.ToolTipManager;
/*     */ import org.apache.commons.lang3.SystemUtils;
/*     */ import org.c.a.a.c;
/*     */ import org.c.a.a.d;
/*     */ import org.slf4j.Logger;
/*     */ import org.slf4j.LoggerFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Arremate
/*     */ {
/*     */   private static Logger a;
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     try {
/*  31 */       System.setProperty("user.timezone", "GMT-3");
/*  32 */       System.setProperty("log.logback.path", ".");
/*  33 */       Locale.setDefault(new Locale("pt", "BR"));
/*     */       
/*  35 */       ToolTipManager.sharedInstance().setDismissDelay((int)TimeUnit.MINUTES.toMillis(1L));
/*     */       
/*  37 */       if (SystemUtils.IS_OS_MAC) {
/*  38 */         System.setProperty("log.logback.path", System.getProperty("user.home") + "/Library/Application Support/Arremate");
/*  39 */         System.setProperty("apple.laf.useScreenMenuBar", "false");
/*     */       } 
/*     */       
/*  42 */       m m = new m();
/*  43 */       m.setVisible(true);
/*  44 */       m.aM("Iniciando...");
/*     */       
/*  46 */       a = LoggerFactory.getLogger(Arremate.class);
/*  47 */       Arremate arremate = new Arremate();
/*  48 */       arremate.a();
/*     */       
/*  50 */       a a = arremate.a();
/*  51 */       if (a != null) {
/*  52 */         m.Z(true);
/*  53 */         arremate.a(m, a.getUser(), a.getPassword());
/*  54 */       } else if (paramArrayOfString.length > 1) {
/*  55 */         arremate.a(m, paramArrayOfString[0], paramArrayOfString[1]);
/*     */       } else {
/*  57 */         m.cX();
/*     */       } 
/*  59 */     } catch (Exception exception) {
/*  60 */       String str = "Erro ao abrir aplicação!";
/*     */       
/*  62 */       if (exception.getMessage().contains("Unable to obtain connection from database")) {
/*  63 */         str = str + " Sem permissão para acessar a base de dados!";
/*     */       }
/*     */       
/*  66 */       JOptionPane.showMessageDialog(null, str, "Erro", 0);
/*  67 */       a.error("Unable to obtain connection from database", exception);
/*  68 */       Logger.getLogger(Arremate.class.getName()).log(Level.SEVERE, (String)null, exception);
/*  69 */       System.exit(0);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(m paramm, String paramString1, String paramString2) {
/*  74 */     paramm.setUser(paramString1);
/*  75 */     paramm.setPassword(paramString2);
/*  76 */     paramm.dC();
/*     */   }
/*     */   
/*     */   private a a() {
/*  80 */     try (Statement null = a.a().createStatement()) {
/*  81 */       String str = "SELECT carlembrardadosacesso, carusuarioacesso, carsenhaacesso FROM tbconfiguracaoarremate LIMIT 1;";
/*     */ 
/*     */       
/*  84 */       try (ResultSet null = statement.executeQuery(str)) {
/*  85 */         if (resultSet.next() && resultSet.getBoolean("carlembrardadosacesso")) {
/*  86 */           a a = new a();
/*  87 */           String str1 = y.S(resultSet.getString("carusuarioacesso"));
/*  88 */           String str2 = y.S(resultSet.getString("carsenhaacesso"));
/*  89 */           a.setUser(str1);
/*  90 */           a.setPassword(str2);
/*  91 */           return a;
/*     */         } 
/*     */       } 
/*  94 */     } catch (Exception exception) {
/*  95 */       Logger.getLogger(Arremate.class.getName()).log(Level.SEVERE, (String)null, exception);
/*     */     } 
/*     */     
/*  98 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   private void a() throws Exception {
/* 103 */     org.c.a.a a = org.c.a.a.a().a(a.I(), "sa", null).a();
/*     */     
/*     */     try {
/* 106 */       a(a);
/* 107 */     } catch (org.c.a.a.a a1) {
/* 108 */       if (a1.getMessage().contains("Lock file recently modified") || a1
/* 109 */         .getMessage().contains("Locked by another process:")) {
/* 110 */         String str = "Não foi possível realizar conexão com o banco de dados, existe outra aplicação conectada.\nFeche a(s) outra(s) aplicação(ões) e tente novamente.";
/*     */ 
/*     */         
/* 113 */         JOptionPane.showMessageDialog(null, "Não foi possível realizar conexão com o banco de dados, existe outra aplicação conectada.\nFeche a(s) outra(s) aplicação(ões) e tente novamente.", "Falha ao iniciar aplicação", 0);
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 118 */         if (!a()) {
/* 119 */           throw new Exception("Não foi possível migrar a base de dados");
/*     */         }
/*     */         
/* 122 */         a.info("Cleaning database");
/* 123 */         a.clean();
/* 124 */         a.bL();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(org.c.a.a parama) throws org.c.a.a.a {
/*     */     try {
/* 131 */       d d = parama.a();
/* 132 */       c[] arrayOfC = d.c();
/* 133 */       int i = arrayOfC.length;
/*     */       
/* 135 */       if (i > 0 && arrayOfC[i - 1].a().fr()) {
/* 136 */         a.info("Repairing database");
/* 137 */         parama.hP();
/*     */         
/* 139 */         d = parama.a();
/*     */       } 
/* 141 */       if ((d.b()).length > 0) {
/* 142 */         a.info("Migrating database");
/* 143 */         parama.bL();
/*     */       } 
/* 145 */     } catch (org.c.a.a.a a1) {
/* 146 */       a.error("Failed to migrate", (Throwable)a1);
/* 147 */       if (a1.getMessage().contains("Use baseline()")) {
/* 148 */         a.info("Executing baseline");
/* 149 */         parama.hO();
/* 150 */         parama.bL();
/*     */       } else {
/* 152 */         throw a1;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean a() {
/* 158 */     StringBuilder stringBuilder = new StringBuilder("Seu banco de dados está apresentando problemas");
/* 159 */     stringBuilder.append(" para atualizar e será necessário restaurá-lo para utilizar o sistema.");
/* 160 */     stringBuilder.append("\nContudo seus dados de acesso e disputas cadastradas serão perdidos.");
/* 161 */     stringBuilder.append("\nDeseja restaurar?");
/* 162 */     String str = "Falha ao atualizar banco de dados";
/* 163 */     int i = JOptionPane.showConfirmDialog(null, stringBuilder.toString(), str, 0);
/* 164 */     return (i == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   private static class a
/*     */   {
/*     */     private String user;
/*     */     
/*     */     public String getUser() {
/* 173 */       return this.user;
/*     */     } private String password;
/*     */     private a() {}
/*     */     public void setUser(String param1String) {
/* 177 */       this.user = param1String;
/*     */     }
/*     */     
/*     */     public String getPassword() {
/* 181 */       return this.password;
/*     */     }
/*     */     
/*     */     public void setPassword(String param1String) {
/* 185 */       this.password = param1String;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\br\com\arremate\Arremate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */