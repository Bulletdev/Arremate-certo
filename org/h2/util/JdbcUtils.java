/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.ObjectInputStream;
/*     */ import java.io.ObjectOutputStream;
/*     */ import java.io.ObjectStreamClass;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Driver;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Properties;
/*     */ import javax.naming.Context;
/*     */ import javax.sql.DataSource;
/*     */ import org.h2.api.JavaObjectSerializer;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.DataHandler;
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
/*     */ public class JdbcUtils
/*     */ {
/*     */   public static JavaObjectSerializer serializer;
/*  41 */   private static final String[] DRIVERS = new String[] { "h2:", "org.h2.Driver", "Cache:", "com.intersys.jdbc.CacheDriver", "daffodilDB://", "in.co.daffodil.db.rmi.RmiDaffodilDBDriver", "daffodil", "in.co.daffodil.db.jdbc.DaffodilDBDriver", "db2:", "com.ibm.db2.jcc.DB2Driver", "derby:net:", "org.apache.derby.jdbc.ClientDriver", "derby://", "org.apache.derby.jdbc.ClientDriver", "derby:", "org.apache.derby.jdbc.EmbeddedDriver", "FrontBase:", "com.frontbase.jdbc.FBJDriver", "firebirdsql:", "org.firebirdsql.jdbc.FBDriver", "hsqldb:", "org.hsqldb.jdbcDriver", "informix-sqli:", "com.informix.jdbc.IfxDriver", "jtds:", "net.sourceforge.jtds.jdbc.Driver", "microsoft:", "com.microsoft.jdbc.sqlserver.SQLServerDriver", "mimer:", "com.mimer.jdbc.Driver", "mysql:", "com.mysql.jdbc.Driver", "odbc:", "sun.jdbc.odbc.JdbcOdbcDriver", "oracle:", "oracle.jdbc.driver.OracleDriver", "pervasive:", "com.pervasive.jdbc.v2.Driver", "pointbase:micro:", "com.pointbase.me.jdbc.jdbcDriver", "pointbase:", "com.pointbase.jdbc.jdbcUniversalDriver", "postgresql:", "org.postgresql.Driver", "sybase:", "com.sybase.jdbc3.jdbc.SybDriver", "sqlserver:", "com.microsoft.sqlserver.jdbc.SQLServerDriver", "teradata:", "com.ncr.teradata.TeraDriver" };
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
/*     */   private static boolean allowAllClasses;
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
/*     */   private static HashSet<String> allowedClassNames;
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
/*  75 */   private static ArrayList<Utils.ClassFactory> userClassFactories = new ArrayList<>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] allowedClassNamePrefixes;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void addClassFactory(Utils.ClassFactory paramClassFactory) {
/*  90 */     getUserClassFactories().add(paramClassFactory);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void removeClassFactory(Utils.ClassFactory paramClassFactory) {
/*  99 */     getUserClassFactories().remove(paramClassFactory);
/*     */   }
/*     */   
/*     */   private static ArrayList<Utils.ClassFactory> getUserClassFactories() {
/* 103 */     if (userClassFactories == null)
/*     */     {
/*     */       
/* 106 */       userClassFactories = new ArrayList<>();
/*     */     }
/* 108 */     return userClassFactories;
/*     */   }
/*     */   
/*     */   static {
/* 112 */     String str = SysProperties.JAVA_OBJECT_SERIALIZER;
/* 113 */     if (str != null) {
/*     */       try {
/* 115 */         serializer = loadUserClass(str).newInstance();
/* 116 */       } catch (Exception exception) {
/* 117 */         throw DbException.convert(exception);
/*     */       } 
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
/*     */   public static <Z> Class<Z> loadUserClass(String paramString) {
/* 132 */     if (allowedClassNames == null) {
/*     */       
/* 134 */       String str = SysProperties.ALLOWED_CLASSES;
/* 135 */       ArrayList<?> arrayList = New.arrayList();
/* 136 */       boolean bool = false;
/* 137 */       HashSet<?> hashSet = New.hashSet();
/* 138 */       for (String str1 : StringUtils.arraySplit(str, ',', true)) {
/* 139 */         if (str1.equals("*")) {
/* 140 */           bool = true;
/* 141 */         } else if (str1.endsWith("*")) {
/* 142 */           arrayList.add(str1.substring(0, str1.length() - 1));
/*     */         } else {
/* 144 */           hashSet.add(str1);
/*     */         } 
/*     */       } 
/* 147 */       allowedClassNamePrefixes = new String[arrayList.size()];
/* 148 */       arrayList.toArray(allowedClassNamePrefixes);
/* 149 */       allowAllClasses = bool;
/* 150 */       allowedClassNames = (HashSet)hashSet;
/*     */     } 
/* 152 */     if (!allowAllClasses && !allowedClassNames.contains(paramString)) {
/* 153 */       boolean bool = false;
/* 154 */       for (String str : allowedClassNamePrefixes) {
/* 155 */         if (paramString.startsWith(str)) {
/* 156 */           bool = true;
/*     */         }
/*     */       } 
/* 159 */       if (!bool) {
/* 160 */         throw DbException.get(90134, paramString);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 165 */     for (Utils.ClassFactory classFactory : getUserClassFactories()) {
/* 166 */       if (classFactory.match(paramString)) {
/*     */         try {
/* 168 */           Class<?> clazz = classFactory.loadClass(paramString);
/* 169 */           if (clazz != null) {
/* 170 */             return (Class)clazz;
/*     */           }
/* 172 */         } catch (Exception exception) {
/* 173 */           throw DbException.get(90086, exception, new String[] { paramString });
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 180 */       return (Class)Class.forName(paramString);
/* 181 */     } catch (ClassNotFoundException classNotFoundException) {
/*     */       try {
/* 183 */         return (Class)Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
/*     */       
/*     */       }
/* 186 */       catch (Exception exception) {
/* 187 */         throw DbException.get(90086, classNotFoundException, new String[] { paramString });
/*     */       }
/*     */     
/* 190 */     } catch (NoClassDefFoundError noClassDefFoundError) {
/* 191 */       throw DbException.get(90086, noClassDefFoundError, new String[] { paramString });
/*     */     }
/* 193 */     catch (Error error) {
/*     */       
/* 195 */       throw DbException.get(50000, error, new String[] { paramString });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeSilently(Statement paramStatement) {
/* 206 */     if (paramStatement != null) {
/*     */       try {
/* 208 */         paramStatement.close();
/* 209 */       } catch (SQLException sQLException) {}
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
/*     */   public static void closeSilently(Connection paramConnection) {
/* 221 */     if (paramConnection != null) {
/*     */       try {
/* 223 */         paramConnection.close();
/* 224 */       } catch (SQLException sQLException) {}
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
/*     */   public static void closeSilently(ResultSet paramResultSet) {
/* 236 */     if (paramResultSet != null) {
/*     */       try {
/* 238 */         paramResultSet.close();
/* 239 */       } catch (SQLException sQLException) {}
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
/*     */   public static Connection getConnection(String paramString1, String paramString2, String paramString3, String paramString4) throws SQLException {
/* 256 */     Properties properties = new Properties();
/* 257 */     if (paramString3 != null) {
/* 258 */       properties.setProperty("user", paramString3);
/*     */     }
/* 260 */     if (paramString4 != null) {
/* 261 */       properties.setProperty("password", paramString4);
/*     */     }
/* 263 */     return getConnection(paramString1, paramString2, properties);
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
/*     */   public static Connection getConnection(String paramString1, String paramString2, Properties paramProperties) throws SQLException {
/* 276 */     if (StringUtils.isNullOrEmpty(paramString1)) {
/* 277 */       load(paramString2);
/*     */     } else {
/* 279 */       Class<?> clazz = loadUserClass(paramString1);
/* 280 */       if (Driver.class.isAssignableFrom(clazz))
/* 281 */         return DriverManager.getConnection(paramString2, paramProperties); 
/* 282 */       if (Context.class.isAssignableFrom(clazz)) {
/*     */         
/*     */         try {
/* 285 */           Context context = (Context)clazz.newInstance();
/* 286 */           DataSource dataSource = (DataSource)context.lookup(paramString2);
/* 287 */           String str1 = paramProperties.getProperty("user");
/* 288 */           String str2 = paramProperties.getProperty("password");
/* 289 */           if (StringUtils.isNullOrEmpty(str1) && StringUtils.isNullOrEmpty(str2)) {
/* 290 */             return dataSource.getConnection();
/*     */           }
/* 292 */           return dataSource.getConnection(str1, str2);
/* 293 */         } catch (Exception exception) {
/* 294 */           throw DbException.toSQLException(exception);
/*     */         } 
/*     */       }
/*     */       
/* 298 */       return DriverManager.getConnection(paramString2, paramProperties);
/*     */     } 
/*     */     
/* 301 */     return DriverManager.getConnection(paramString2, paramProperties);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getDriver(String paramString) {
/* 312 */     if (paramString.startsWith("jdbc:")) {
/* 313 */       paramString = paramString.substring("jdbc:".length());
/* 314 */       for (byte b = 0; b < DRIVERS.length; b += 2) {
/* 315 */         String str = DRIVERS[b];
/* 316 */         if (paramString.startsWith(str)) {
/* 317 */           return DRIVERS[b + 1];
/*     */         }
/*     */       } 
/*     */     } 
/* 321 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void load(String paramString) {
/* 330 */     String str = getDriver(paramString);
/* 331 */     if (str != null) {
/* 332 */       loadUserClass(str);
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
/*     */   public static byte[] serialize(Object paramObject, DataHandler paramDataHandler) {
/*     */     try {
/* 346 */       JavaObjectSerializer javaObjectSerializer = null;
/* 347 */       if (paramDataHandler != null) {
/* 348 */         javaObjectSerializer = paramDataHandler.getJavaObjectSerializer();
/*     */       }
/* 350 */       if (javaObjectSerializer != null) {
/* 351 */         return javaObjectSerializer.serialize(paramObject);
/*     */       }
/* 353 */       if (serializer != null) {
/* 354 */         return serializer.serialize(paramObject);
/*     */       }
/* 356 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 357 */       ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
/* 358 */       objectOutputStream.writeObject(paramObject);
/* 359 */       return byteArrayOutputStream.toByteArray();
/* 360 */     } catch (Throwable throwable) {
/* 361 */       throw DbException.get(90026, throwable, new String[] { throwable.toString() });
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
/*     */   public static Object deserialize(byte[] paramArrayOfbyte, DataHandler paramDataHandler) {
/*     */     try {
/*     */       ObjectInputStream objectInputStream;
/* 376 */       JavaObjectSerializer javaObjectSerializer = null;
/* 377 */       if (paramDataHandler != null) {
/* 378 */         javaObjectSerializer = paramDataHandler.getJavaObjectSerializer();
/*     */       }
/* 380 */       if (javaObjectSerializer != null) {
/* 381 */         return javaObjectSerializer.deserialize(paramArrayOfbyte);
/*     */       }
/* 383 */       if (serializer != null) {
/* 384 */         return serializer.deserialize(paramArrayOfbyte);
/*     */       }
/* 386 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(paramArrayOfbyte);
/*     */       
/* 388 */       if (SysProperties.USE_THREAD_CONTEXT_CLASS_LOADER) {
/* 389 */         final ClassLoader loader = Thread.currentThread().getContextClassLoader();
/* 390 */         objectInputStream = new ObjectInputStream(byteArrayInputStream)
/*     */           {
/*     */             protected Class<?> resolveClass(ObjectStreamClass param1ObjectStreamClass) throws IOException, ClassNotFoundException
/*     */             {
/*     */               try {
/* 395 */                 return Class.forName(param1ObjectStreamClass.getName(), true, loader);
/* 396 */               } catch (ClassNotFoundException classNotFoundException) {
/* 397 */                 return super.resolveClass(param1ObjectStreamClass);
/*     */               } 
/*     */             }
/*     */           };
/*     */       } else {
/* 402 */         objectInputStream = new ObjectInputStream(byteArrayInputStream);
/*     */       } 
/* 404 */       return objectInputStream.readObject();
/* 405 */     } catch (Throwable throwable) {
/* 406 */       throw DbException.get(90027, throwable, new String[] { throwable.toString() });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\JdbcUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */