/*     */ package org.c.a.b.h;
/*     */ 
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Driver;
/*     */ import java.sql.SQLException;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Logger;
/*     */ import javax.sql.DataSource;
/*     */ import org.c.a.a.a;
/*     */ import org.c.a.a.f.a;
/*     */ import org.c.a.a.f.c;
/*     */ import org.c.a.b.r.d;
/*     */ import org.c.a.b.r.g;
/*     */ import org.c.a.b.r.n;
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
/*     */ public class b
/*     */   implements DataSource
/*     */ {
/*  37 */   private static final a a = c.b(b.class);
/*     */ 
/*     */   
/*     */   private static final String li = "jdbc:db2:";
/*     */ 
/*     */   
/*     */   private static final String lj = "jdbc:derby://";
/*     */ 
/*     */   
/*     */   private static final String lk = "jdbc:derby:";
/*     */ 
/*     */   
/*     */   private static final String ll = "org.mariadb.jdbc.Driver";
/*     */ 
/*     */   
/*     */   private static final String lm = "jdbc:mariadb:";
/*     */ 
/*     */   
/*     */   private static final String ln = "com.mysql.cj.jdbc.Driver";
/*     */ 
/*     */   
/*     */   private static final String lo = "com.mysql.jdbc.Driver";
/*     */ 
/*     */   
/*     */   private static final String lp = "jdbc:mysql:";
/*     */ 
/*     */   
/*     */   private static final String lq = "jdbc:oracle:";
/*     */ 
/*     */   
/*     */   private static final String lr = "jdbc:postgresql:";
/*     */ 
/*     */   
/*     */   private static final String ls = "jdbc:redshift:";
/*     */ 
/*     */   
/*     */   private static final String lt = "com.amazon.redshift.jdbc41.Driver";
/*     */ 
/*     */   
/*     */   private static final String lu = "jdbc:sap:";
/*     */ 
/*     */   
/*     */   private static final String lv = "org.sqldroid.SQLDroidDriver";
/*     */ 
/*     */   
/*     */   private static final String lw = "jdbc:sqlserver:";
/*     */ 
/*     */   
/*     */   private static final String lx = "jdbc:sybase:";
/*     */ 
/*     */   
/*     */   private static final String ly = "Flyway by Boxfuse";
/*     */ 
/*     */   
/*     */   private Driver a;
/*     */ 
/*     */   
/*     */   private final String url;
/*     */   
/*     */   private final String user;
/*     */   
/*     */   private final String password;
/*     */   
/*     */   private final Properties b;
/*     */   
/*     */   private final ClassLoader classLoader;
/*     */   
/*     */   private boolean autoCommit = true;
/*     */ 
/*     */   
/*     */   public b(ClassLoader paramClassLoader, String paramString1, String paramString2, String paramString3, String paramString4) throws a {
/* 108 */     this(paramClassLoader, paramString1, paramString2, paramString3, paramString4, new Properties());
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
/*     */   public b(ClassLoader paramClassLoader, String paramString1, String paramString2, String paramString3, String paramString4, Properties paramProperties) throws a {
/* 124 */     this.classLoader = paramClassLoader;
/* 125 */     this.url = aX(paramString2);
/*     */     
/* 127 */     if (!n.W(paramString1)) {
/* 128 */       paramString1 = bb(paramString2);
/* 129 */       if (!n.W(paramString1)) {
/* 130 */         throw new a("Unable to autodetect JDBC driver for url: " + paramString2);
/*     */       }
/*     */     } 
/*     */     
/* 134 */     this.b = new Properties(paramProperties);
/* 135 */     this.b.putAll(a(paramString2));
/*     */     
/*     */     try {
/* 138 */       this.a = (Driver)d.a(paramString1, paramClassLoader);
/* 139 */     } catch (a a1) {
/* 140 */       String str = ba(paramString2);
/* 141 */       if (str == null) {
/* 142 */         throw new a("Unable to instantiate JDBC driver: " + paramString1 + " => Check whether the jar file is present", a1);
/*     */       }
/*     */       
/*     */       try {
/* 146 */         this.a = (Driver)d.a(str, paramClassLoader);
/* 147 */       } catch (Exception exception) {
/*     */         
/* 149 */         throw new a("Unable to instantiate JDBC driver: " + paramString1 + " => Check whether the jar file is present", a1);
/*     */       } 
/*     */     } 
/*     */     
/* 153 */     this.user = aY(paramString3);
/* 154 */     this.password = aZ(paramString4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String aX(String paramString) {
/* 164 */     if (!n.X(paramString)) {
/*     */       
/* 166 */       String str = System.getenv("BOXFUSE_DATABASE_URL");
/* 167 */       if (n.X(str)) {
/* 168 */         return str;
/*     */       }
/*     */       
/* 171 */       throw new a("Missing required JDBC URL. Unable to create DataSource!");
/*     */     } 
/*     */     
/* 174 */     if (!paramString.toLowerCase().startsWith("jdbc:")) {
/* 175 */       throw new a("Invalid JDBC URL (should start with jdbc:) : " + paramString);
/*     */     }
/* 177 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String aY(String paramString) {
/* 187 */     if (!n.X(paramString)) {
/*     */       
/* 189 */       String str = System.getenv("BOXFUSE_DATABASE_USER");
/* 190 */       if (n.X(str)) {
/* 191 */         return str;
/*     */       }
/*     */     } 
/* 194 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String aZ(String paramString) {
/* 204 */     if (!n.X(paramString)) {
/*     */       
/* 206 */       String str = System.getenv("BOXFUSE_DATABASE_PASSWORD");
/* 207 */       if (n.X(str)) {
/* 208 */         return str;
/*     */       }
/*     */     } 
/* 211 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Properties a(String paramString) {
/* 221 */     Properties properties = new Properties();
/*     */     
/* 223 */     if (paramString.startsWith("jdbc:oracle:")) {
/* 224 */       String str = System.getProperty("user.name");
/* 225 */       properties.put("v$session.osuser", str.substring(0, Math.min(str.length(), 30)));
/* 226 */       properties.put("v$session.program", "Flyway by Boxfuse");
/* 227 */       properties.put("oracle.net.keepAlive", "true");
/* 228 */     } else if (paramString.startsWith("jdbc:sqlserver:")) {
/* 229 */       properties.put("applicationName", "Flyway by Boxfuse");
/* 230 */     } else if (paramString.startsWith("jdbc:postgresql:")) {
/* 231 */       properties.put("ApplicationName", "Flyway by Boxfuse");
/* 232 */     } else if (paramString.startsWith("jdbc:mysql:") || paramString.startsWith("jdbc:mariadb:")) {
/* 233 */       properties.put("connectionAttributes", "program_name:Flyway by Boxfuse");
/* 234 */     } else if (paramString.startsWith("jdbc:db2:")) {
/* 235 */       properties.put("clientProgramName", "Flyway by Boxfuse");
/* 236 */       properties.put("retrieveMessagesFromServerOnGetMessage", "true");
/* 237 */     } else if (paramString.startsWith("jdbc:sybase:")) {
/* 238 */       properties.put("APPLICATIONNAME", "Flyway by Boxfuse");
/* 239 */     } else if (paramString.startsWith("jdbc:sap:")) {
/* 240 */       properties.put("SESSIONVARIABLE:APPLICATION", "Flyway by Boxfuse");
/*     */     } 
/*     */     
/* 243 */     return properties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String ba(String paramString) {
/* 253 */     if (paramString.startsWith("jdbc:mysql:") && d.a("com.mysql.jdbc.Driver", this.classLoader)) {
/* 254 */       return "com.mysql.jdbc.Driver";
/*     */     }
/*     */     
/* 257 */     if (paramString.startsWith("jdbc:mysql:") && d.a("org.mariadb.jdbc.Driver", this.classLoader)) {
/* 258 */       a.warn("You are attempting to connect to a MySQL database using the MariaDB driver. This is known to cause issues. An upgrade to Oracle's MySQL JDBC driver is highly recommended.");
/*     */ 
/*     */       
/* 261 */       return "org.mariadb.jdbc.Driver";
/*     */     } 
/*     */     
/* 264 */     if (paramString.startsWith("jdbc:redshift:")) {
/* 265 */       if (d.a("com.amazon.redshift.jdbc41.Driver", this.classLoader)) {
/* 266 */         return "com.amazon.redshift.jdbc41.Driver";
/*     */       }
/* 268 */       return "com.amazon.redshift.jdbc4.Driver";
/*     */     } 
/*     */     
/* 271 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String bb(String paramString) {
/* 281 */     if (paramString.startsWith("jdbc:tc:")) {
/* 282 */       return "org.testcontainers.jdbc.ContainerDatabaseDriver";
/*     */     }
/*     */     
/* 285 */     if (paramString.startsWith("jdbc:db2:")) {
/* 286 */       return "com.ibm.db2.jcc.DB2Driver";
/*     */     }
/*     */     
/* 289 */     if (paramString.startsWith("jdbc:derby://")) {
/* 290 */       return "org.apache.derby.jdbc.ClientDriver";
/*     */     }
/*     */     
/* 293 */     if (paramString.startsWith("jdbc:derby:")) {
/* 294 */       return "org.apache.derby.jdbc.EmbeddedDriver";
/*     */     }
/*     */     
/* 297 */     if (paramString.startsWith("jdbc:h2:")) {
/* 298 */       return "org.h2.Driver";
/*     */     }
/*     */     
/* 301 */     if (paramString.startsWith("jdbc:hsqldb:")) {
/* 302 */       return "org.hsqldb.jdbcDriver";
/*     */     }
/*     */     
/* 305 */     if (paramString.startsWith("jdbc:sqlite:")) {
/* 306 */       if ((new g(this.classLoader)).gd()) {
/* 307 */         return "org.sqldroid.SQLDroidDriver";
/*     */       }
/* 309 */       return "org.sqlite.JDBC";
/*     */     } 
/*     */     
/* 312 */     if (paramString.startsWith("jdbc:sqldroid:")) {
/* 313 */       return "org.sqldroid.SQLDroidDriver";
/*     */     }
/*     */     
/* 316 */     if (paramString.startsWith("jdbc:mysql:")) {
/* 317 */       return "com.mysql.cj.jdbc.Driver";
/*     */     }
/*     */     
/* 320 */     if (paramString.startsWith("jdbc:mariadb:")) {
/* 321 */       return "org.mariadb.jdbc.Driver";
/*     */     }
/*     */     
/* 324 */     if (paramString.startsWith("jdbc:google:")) {
/* 325 */       return "com.mysql.jdbc.GoogleDriver";
/*     */     }
/*     */     
/* 328 */     if (paramString.startsWith("jdbc:oracle:")) {
/* 329 */       return "oracle.jdbc.OracleDriver";
/*     */     }
/*     */     
/* 332 */     if (paramString.startsWith("jdbc:postgresql:")) {
/* 333 */       return "org.postgresql.Driver";
/*     */     }
/*     */     
/* 336 */     if (paramString.startsWith("jdbc:redshift:")) {
/* 337 */       return "com.amazon.redshift.jdbc42.Driver";
/*     */     }
/*     */     
/* 340 */     if (paramString.startsWith("jdbc:jtds:")) {
/* 341 */       return "net.sourceforge.jtds.jdbc.Driver";
/*     */     }
/*     */     
/* 344 */     if (paramString.startsWith("jdbc:sybase:")) {
/* 345 */       return "com.sybase.jdbc4.jdbc.SybDriver";
/*     */     }
/*     */     
/* 348 */     if (paramString.startsWith("jdbc:sqlserver:")) {
/* 349 */       return "com.microsoft.sqlserver.jdbc.SQLServerDriver";
/*     */     }
/*     */     
/* 352 */     if (paramString.startsWith("jdbc:sap:")) {
/* 353 */       return "com.sap.db.jdbc.Driver";
/*     */     }
/*     */     
/* 356 */     if (paramString.startsWith("jdbc:informix-sqli:")) {
/* 357 */       return "com.informix.jdbc.IfxDriver";
/*     */     }
/*     */     
/* 360 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Driver a() {
/* 367 */     return this.a;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUrl() {
/* 374 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUser() {
/* 381 */     return this.user;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/* 388 */     return this.password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 399 */     return a(getUser(), getPassword());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection(String paramString1, String paramString2) throws SQLException {
/* 410 */     return a(paramString1, paramString2);
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
/*     */   protected Connection a(String paramString1, String paramString2) throws SQLException {
/* 425 */     Properties properties = new Properties(this.b);
/* 426 */     if (paramString1 != null) {
/* 427 */       properties.setProperty("user", paramString1);
/*     */     }
/* 429 */     if (paramString2 != null) {
/* 430 */       properties.setProperty("password", paramString2);
/*     */     }
/*     */     
/* 433 */     Connection connection = this.a.connect(this.url, properties);
/* 434 */     if (connection == null) {
/* 435 */       throw new a("Unable to connect to " + this.url);
/*     */     }
/* 437 */     connection.setAutoCommit(this.autoCommit);
/* 438 */     return connection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean fQ() {
/* 445 */     return this.autoCommit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean paramBoolean) {
/* 452 */     this.autoCommit = paramBoolean;
/*     */   }
/*     */   
/*     */   public int getLoginTimeout() {
/* 456 */     return 0;
/*     */   }
/*     */   
/*     */   public void setLoginTimeout(int paramInt) {
/* 460 */     throw new UnsupportedOperationException("setLoginTimeout");
/*     */   }
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 464 */     throw new UnsupportedOperationException("getLogWriter");
/*     */   }
/*     */   
/*     */   public void setLogWriter(PrintWriter paramPrintWriter) {
/* 468 */     throw new UnsupportedOperationException("setLogWriter");
/*     */   }
/*     */   
/*     */   public <T> T unwrap(Class<T> paramClass) {
/* 472 */     throw new UnsupportedOperationException("unwrap");
/*     */   }
/*     */   
/*     */   public boolean isWrapperFor(Class<?> paramClass) {
/* 476 */     return DataSource.class.equals(paramClass);
/*     */   }
/*     */   
/*     */   public Logger getParentLogger() {
/* 480 */     throw new UnsupportedOperationException("getParentLogger");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void ig() {
/* 487 */     if (this.url.startsWith("jdbc:derby:") && !this.url.startsWith("jdbc:derby://"))
/*     */       try {
/* 489 */         int i = this.url.indexOf(";");
/* 490 */         String str = ((i < 0) ? this.url : this.url.substring(0, i)) + ";shutdown=true";
/*     */         
/* 492 */         this.a.connect(str, new Properties());
/* 493 */       } catch (SQLException sQLException) {
/* 494 */         a.debug("Expected error on Derby Embedded Database shutdown: " + sQLException.getMessage());
/*     */       }  
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\c\a\b\h\b.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */