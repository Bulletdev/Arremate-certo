/*     */ package org.h2.util;
/*     */ 
/*     */ import java.sql.Driver;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLFeatureNotSupportedException;
/*     */ import java.util.Properties;
/*     */ import javax.sql.ConnectionPoolDataSource;
/*     */ import javax.sql.DataSource;
/*     */ import javax.sql.XADataSource;
/*     */ import org.h2.Driver;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.jdbcx.JdbcDataSource;
/*     */ import org.osgi.framework.BundleContext;
/*     */ import org.osgi.service.jdbc.DataSourceFactory;
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
/*     */ public class OsgiDataSourceFactory
/*     */   implements DataSourceFactory
/*     */ {
/*     */   private Driver driver;
/*     */   
/*     */   public OsgiDataSourceFactory(Driver paramDriver) {
/*  44 */     this.driver = paramDriver;
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
/*     */   public DataSource createDataSource(Properties paramProperties) throws SQLException {
/*  59 */     Properties properties = new Properties();
/*  60 */     if (paramProperties != null) {
/*  61 */       properties.putAll(paramProperties);
/*     */     }
/*     */ 
/*     */     
/*  65 */     rejectUnsupportedOptions(properties);
/*     */ 
/*     */     
/*  68 */     rejectPoolingOptions(properties);
/*     */     
/*  70 */     JdbcDataSource jdbcDataSource = new JdbcDataSource();
/*     */     
/*  72 */     setupH2DataSource(jdbcDataSource, properties);
/*     */     
/*  74 */     return (DataSource)jdbcDataSource;
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
/*     */   public ConnectionPoolDataSource createConnectionPoolDataSource(Properties paramProperties) throws SQLException {
/*  89 */     Properties properties = new Properties();
/*  90 */     if (paramProperties != null) {
/*  91 */       properties.putAll(paramProperties);
/*     */     }
/*     */ 
/*     */     
/*  95 */     rejectUnsupportedOptions(properties);
/*     */ 
/*     */     
/*  98 */     rejectPoolingOptions(properties);
/*     */     
/* 100 */     JdbcDataSource jdbcDataSource = new JdbcDataSource();
/*     */     
/* 102 */     setupH2DataSource(jdbcDataSource, properties);
/*     */     
/* 104 */     return (ConnectionPoolDataSource)jdbcDataSource;
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
/*     */   public XADataSource createXADataSource(Properties paramProperties) throws SQLException {
/* 119 */     Properties properties = new Properties();
/* 120 */     if (paramProperties != null) {
/* 121 */       properties.putAll(paramProperties);
/*     */     }
/*     */ 
/*     */     
/* 125 */     rejectUnsupportedOptions(properties);
/*     */ 
/*     */     
/* 128 */     rejectPoolingOptions(properties);
/*     */     
/* 130 */     JdbcDataSource jdbcDataSource = new JdbcDataSource();
/*     */     
/* 132 */     setupH2DataSource(jdbcDataSource, properties);
/*     */     
/* 134 */     return (XADataSource)jdbcDataSource;
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
/*     */   public Driver createDriver(Properties paramProperties) throws SQLException {
/* 147 */     if (paramProperties != null && !paramProperties.isEmpty())
/*     */     {
/* 149 */       throw new SQLException();
/*     */     }
/* 151 */     return (Driver)this.driver;
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
/*     */   private static void rejectUnsupportedOptions(Properties paramProperties) throws SQLFeatureNotSupportedException {
/* 165 */     if (paramProperties.containsKey("roleName")) {
/* 166 */       throw new SQLFeatureNotSupportedException("The roleName property is not supported by H2");
/*     */     }
/*     */ 
/*     */     
/* 170 */     if (paramProperties.containsKey("dataSourceName")) {
/* 171 */       throw new SQLFeatureNotSupportedException("The dataSourceName property is not supported by H2");
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
/*     */   private static void setupH2DataSource(JdbcDataSource paramJdbcDataSource, Properties paramProperties) {
/* 187 */     if (paramProperties.containsKey("user")) {
/* 188 */       paramJdbcDataSource.setUser((String)paramProperties.remove("user"));
/*     */     }
/* 190 */     if (paramProperties.containsKey("password")) {
/* 191 */       paramJdbcDataSource.setPassword((String)paramProperties.remove("password"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 196 */     if (paramProperties.containsKey("description")) {
/* 197 */       paramJdbcDataSource.setDescription((String)paramProperties.remove("description"));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 202 */     StringBuffer stringBuffer = new StringBuffer();
/* 203 */     if (paramProperties.containsKey("url")) {
/*     */       
/* 205 */       stringBuffer.append(paramProperties.remove("url"));
/*     */       
/* 207 */       paramProperties.remove("networkProtocol");
/* 208 */       paramProperties.remove("serverName");
/* 209 */       paramProperties.remove("portNumber");
/* 210 */       paramProperties.remove("databaseName");
/*     */     } else {
/*     */       
/* 213 */       stringBuffer.append("jdbc:h2:");
/*     */ 
/*     */       
/* 216 */       String str = "";
/* 217 */       if (paramProperties.containsKey("networkProtocol")) {
/* 218 */         str = (String)paramProperties.remove("networkProtocol");
/* 219 */         stringBuffer.append(str).append(":");
/*     */       } 
/*     */ 
/*     */       
/* 223 */       if (paramProperties.containsKey("serverName")) {
/* 224 */         stringBuffer.append("//").append(paramProperties.remove("serverName"));
/*     */ 
/*     */         
/* 227 */         if (paramProperties.containsKey("portNumber")) {
/* 228 */           stringBuffer.append(":").append(paramProperties.remove("portNumber"));
/*     */         }
/*     */ 
/*     */         
/* 232 */         stringBuffer.append("/");
/* 233 */       } else if (paramProperties.containsKey("portNumber")) {
/*     */ 
/*     */         
/* 236 */         stringBuffer.append("//localhost:").append(paramProperties.remove("portNumber")).append("/");
/*     */ 
/*     */       
/*     */       }
/* 240 */       else if (str.equals("tcp") || str.equals("ssl")) {
/*     */ 
/*     */         
/* 243 */         stringBuffer.append("//localhost/");
/*     */       } 
/*     */ 
/*     */       
/* 247 */       if (paramProperties.containsKey("databaseName")) {
/* 248 */         stringBuffer.append(paramProperties.remove("databaseName"));
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 254 */     for (Object object : paramProperties.keySet()) {
/* 255 */       stringBuffer.append(";").append(object).append("=").append(paramProperties.get(object));
/*     */     }
/*     */ 
/*     */     
/* 259 */     if (stringBuffer.length() > "jdbc:h2:".length()) {
/* 260 */       paramJdbcDataSource.setURL(stringBuffer.toString());
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
/*     */   private static void rejectPoolingOptions(Properties paramProperties) throws SQLFeatureNotSupportedException {
/* 274 */     if (paramProperties.containsKey("initialPoolSize") || paramProperties.containsKey("maxIdleTime") || paramProperties.containsKey("maxPoolSize") || paramProperties.containsKey("maxStatements") || paramProperties.containsKey("minPoolSize") || paramProperties.containsKey("propertyCycle"))
/*     */     {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 280 */       throw new SQLFeatureNotSupportedException("Pooling properties are not supported by H2");
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
/*     */   static void registerService(BundleContext paramBundleContext, Driver paramDriver) {
/* 293 */     Properties properties = new Properties();
/* 294 */     properties.put("osgi.jdbc.driver.class", Driver.class.getName());
/*     */ 
/*     */     
/* 297 */     properties.put("osgi.jdbc.driver.name", "H2 JDBC Driver");
/*     */ 
/*     */     
/* 300 */     properties.put("osgi.jdbc.driver.version", Constants.getFullVersion());
/*     */ 
/*     */     
/* 303 */     paramBundleContext.registerService(DataSourceFactory.class.getName(), new OsgiDataSourceFactory(paramDriver), properties);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\OsgiDataSourceFactory.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */