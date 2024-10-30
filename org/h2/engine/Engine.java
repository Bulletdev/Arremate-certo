/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashMap;
/*     */ import org.h2.command.CommandInterface;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.FileLock;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.ThreadDeadlockDetector;
/*     */ import org.h2.util.Utils;
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
/*     */ public class Engine
/*     */   implements SessionFactory
/*     */ {
/*  29 */   private static final Engine INSTANCE = new Engine();
/*  30 */   private static final HashMap<String, Database> DATABASES = New.hashMap();
/*     */   
/*  32 */   private volatile long wrongPasswordDelay = SysProperties.DELAY_WRONG_PASSWORD_MIN;
/*     */   
/*     */   private boolean jmx;
/*     */ 
/*     */   
/*     */   private Engine() {
/*  38 */     if (SysProperties.THREAD_DEADLOCK_DETECTOR) {
/*  39 */       ThreadDeadlockDetector.init();
/*     */     }
/*     */   }
/*     */   
/*     */   public static Engine getInstance() {
/*  44 */     return INSTANCE;
/*     */   }
/*     */   
/*     */   private Session openSession(ConnectionInfo paramConnectionInfo, boolean paramBoolean, String paramString) {
/*     */     Database database;
/*  49 */     String str = paramConnectionInfo.getName();
/*     */     
/*  51 */     paramConnectionInfo.removeProperty("NO_UPGRADE", false);
/*  52 */     boolean bool = paramConnectionInfo.getProperty("OPEN_NEW", false);
/*  53 */     if (bool || paramConnectionInfo.isUnnamedInMemory()) {
/*  54 */       database = null;
/*     */     } else {
/*  56 */       database = DATABASES.get(str);
/*     */     } 
/*  58 */     User user = null;
/*  59 */     boolean bool1 = false;
/*  60 */     if (database == null) {
/*  61 */       if (paramBoolean && !Database.exists(str)) {
/*  62 */         throw DbException.get(90013, str);
/*     */       }
/*  64 */       database = new Database(paramConnectionInfo, paramString);
/*  65 */       bool1 = true;
/*  66 */       if (database.getAllUsers().size() == 0) {
/*     */ 
/*     */         
/*  69 */         user = new User(database, database.allocateObjectId(), paramConnectionInfo.getUserName(), false);
/*     */         
/*  71 */         user.setAdmin(true);
/*  72 */         user.setUserPasswordHash(paramConnectionInfo.getUserPasswordHash());
/*  73 */         database.setMasterUser(user);
/*     */       } 
/*  75 */       if (!paramConnectionInfo.isUnnamedInMemory()) {
/*  76 */         DATABASES.put(str, database);
/*     */       }
/*     */     } 
/*  79 */     if (bool1)
/*     */     {
/*     */ 
/*     */       
/*  83 */       database.opened();
/*     */     }
/*  85 */     if (database.isClosing()) {
/*  86 */       return null;
/*     */     }
/*  88 */     if (user == null) {
/*  89 */       if (database.validateFilePasswordHash(paramString, paramConnectionInfo.getFilePasswordHash())) {
/*  90 */         user = database.findUser(paramConnectionInfo.getUserName());
/*  91 */         if (user != null && 
/*  92 */           !user.validateUserPasswordHash(paramConnectionInfo.getUserPasswordHash())) {
/*  93 */           user = null;
/*     */         }
/*     */       } 
/*     */       
/*  97 */       if (bool1 && (user == null || !user.isAdmin()))
/*     */       {
/*     */         
/* 100 */         database.setEventListener(null);
/*     */       }
/*     */     } 
/* 103 */     if (user == null) {
/* 104 */       DbException dbException = DbException.get(28000);
/* 105 */       database.getTrace(2).error((Throwable)dbException, "wrong user or password; user: \"" + paramConnectionInfo.getUserName() + "\"");
/*     */       
/* 107 */       database.removeSession(null);
/* 108 */       throw dbException;
/*     */     } 
/* 110 */     checkClustering(paramConnectionInfo, database);
/* 111 */     Session session = database.createSession(user);
/* 112 */     if (session == null)
/*     */     {
/* 114 */       return null;
/*     */     }
/* 116 */     if (paramConnectionInfo.getProperty("JMX", false)) {
/*     */       try {
/* 118 */         Utils.callStaticMethod("org.h2.jmx.DatabaseInfo.registerMBean", new Object[] { paramConnectionInfo, database });
/*     */       }
/* 120 */       catch (Exception exception) {
/* 121 */         database.removeSession(session);
/* 122 */         throw DbException.get(50100, exception, new String[] { "JMX" });
/*     */       } 
/* 124 */       this.jmx = true;
/*     */     } 
/* 126 */     return session;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Session createSession(ConnectionInfo paramConnectionInfo) {
/* 137 */     return INSTANCE.createSessionAndValidate(paramConnectionInfo);
/*     */   }
/*     */   
/*     */   private Session createSessionAndValidate(ConnectionInfo paramConnectionInfo) {
/*     */     try {
/* 142 */       ConnectionInfo connectionInfo = null;
/* 143 */       String str = paramConnectionInfo.getProperty("FILE_LOCK", (String)null);
/* 144 */       int i = FileLock.getFileLockMethod(str);
/* 145 */       if (i == 3) {
/*     */         
/* 147 */         paramConnectionInfo.setProperty("OPEN_NEW", "TRUE");
/*     */         try {
/* 149 */           connectionInfo = paramConnectionInfo.clone();
/* 150 */         } catch (CloneNotSupportedException cloneNotSupportedException) {
/* 151 */           throw DbException.convert(cloneNotSupportedException);
/*     */         } 
/*     */       } 
/* 154 */       Session session = openSession(paramConnectionInfo);
/* 155 */       validateUserAndPassword(true);
/* 156 */       if (connectionInfo != null) {
/* 157 */         session.setConnectionInfo(connectionInfo);
/*     */       }
/* 159 */       return session;
/* 160 */     } catch (DbException dbException) {
/* 161 */       if (dbException.getErrorCode() == 28000) {
/* 162 */         validateUserAndPassword(false);
/*     */       }
/* 164 */       throw dbException;
/*     */     } 
/*     */   }
/*     */   private synchronized Session openSession(ConnectionInfo paramConnectionInfo) {
/*     */     Session session;
/* 169 */     boolean bool1 = paramConnectionInfo.removeProperty("IFEXISTS", false);
/* 170 */     boolean bool2 = paramConnectionInfo.removeProperty("IGNORE_UNKNOWN_SETTINGS", false);
/*     */     
/* 172 */     String str1 = paramConnectionInfo.removeProperty("CIPHER", (String)null);
/* 173 */     String str2 = paramConnectionInfo.removeProperty("INIT", (String)null);
/*     */     
/* 175 */     for (byte b = 0;; b++) {
/* 176 */       session = openSession(paramConnectionInfo, bool1, str1);
/* 177 */       if (session != null) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 182 */       if (b > '')
/*     */       {
/* 184 */         throw DbException.get(90020, "Waited for database closing longer than 1 minute");
/*     */       }
/*     */       
/*     */       try {
/* 188 */         Thread.sleep(1L);
/* 189 */       } catch (InterruptedException interruptedException) {}
/*     */     } 
/*     */ 
/*     */     
/* 193 */     synchronized (session) {
/* 194 */       session.setAllowLiterals(true);
/* 195 */       DbSettings dbSettings = DbSettings.getDefaultSettings();
/* 196 */       for (String str : paramConnectionInfo.getKeys()) {
/* 197 */         if (!dbSettings.containsKey(str)) {
/*     */ 
/*     */ 
/*     */           
/* 201 */           String str3 = paramConnectionInfo.getProperty(str);
/*     */           try {
/* 203 */             CommandInterface commandInterface = session.prepareCommand("SET " + Parser.quoteIdentifier(str) + " " + str3, 2147483647);
/*     */ 
/*     */             
/* 206 */             commandInterface.executeUpdate();
/* 207 */           } catch (DbException dbException) {
/* 208 */             if (dbException.getErrorCode() == 90040) {
/* 209 */               session.getTrace().error((Throwable)dbException, "admin rights required; user: \"" + paramConnectionInfo.getUserName() + "\"");
/*     */             } else {
/*     */               
/* 212 */               session.getTrace().error((Throwable)dbException, "");
/*     */             } 
/* 214 */             if (!bool2) {
/* 215 */               session.close();
/* 216 */               throw dbException;
/*     */             } 
/*     */           } 
/*     */         } 
/* 220 */       }  if (str2 != null) {
/*     */         try {
/* 222 */           CommandInterface commandInterface = session.prepareCommand(str2, 2147483647);
/*     */           
/* 224 */           commandInterface.executeUpdate();
/* 225 */         } catch (DbException dbException) {
/* 226 */           if (!bool2) {
/* 227 */             session.close();
/* 228 */             throw dbException;
/*     */           } 
/*     */         } 
/*     */       }
/* 232 */       session.setAllowLiterals(false);
/* 233 */       session.commit(true);
/*     */     } 
/* 235 */     return session;
/*     */   }
/*     */   
/*     */   private static void checkClustering(ConnectionInfo paramConnectionInfo, Database paramDatabase) {
/* 239 */     String str1 = paramConnectionInfo.getProperty(13, (String)null);
/* 240 */     if ("''".equals(str1)) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/* 245 */     String str2 = paramDatabase.getCluster();
/* 246 */     if (!"''".equals(str2) && 
/* 247 */       !"TRUE".equals(str1) && 
/* 248 */       !StringUtils.equals(str1, str2)) {
/* 249 */       if (str2.equals("''")) {
/* 250 */         throw DbException.get(90093);
/*     */       }
/*     */       
/* 253 */       throw DbException.get(90094, str2);
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
/*     */   void close(String paramString) {
/* 268 */     if (this.jmx) {
/*     */       try {
/* 270 */         Utils.callStaticMethod("org.h2.jmx.DatabaseInfo.unregisterMBean", new Object[] { paramString });
/* 271 */       } catch (Exception exception) {
/* 272 */         throw DbException.get(50100, exception, new String[] { "JMX" });
/*     */       } 
/*     */     }
/* 275 */     DATABASES.remove(paramString);
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
/*     */   private void validateUserAndPassword(boolean paramBoolean) {
/* 296 */     int i = SysProperties.DELAY_WRONG_PASSWORD_MIN;
/* 297 */     if (paramBoolean) {
/* 298 */       long l = this.wrongPasswordDelay;
/* 299 */       if (l > i && l > 0L)
/*     */       {
/*     */         
/* 302 */         synchronized (INSTANCE)
/*     */         {
/*     */           
/* 305 */           l = MathUtils.secureRandomInt((int)l);
/*     */           try {
/* 307 */             Thread.sleep(l);
/* 308 */           } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */           
/* 311 */           this.wrongPasswordDelay = i;
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/* 317 */       synchronized (INSTANCE) {
/* 318 */         long l = this.wrongPasswordDelay;
/* 319 */         int j = SysProperties.DELAY_WRONG_PASSWORD_MAX;
/* 320 */         if (j <= 0) {
/* 321 */           j = Integer.MAX_VALUE;
/*     */         }
/* 323 */         this.wrongPasswordDelay += this.wrongPasswordDelay;
/* 324 */         if (this.wrongPasswordDelay > j || this.wrongPasswordDelay < 0L) {
/* 325 */           this.wrongPasswordDelay = j;
/*     */         }
/* 327 */         if (i > 0) {
/*     */           
/* 329 */           l += Math.abs(MathUtils.secureRandomLong() % 100L);
/*     */           try {
/* 331 */             Thread.sleep(l);
/* 332 */           } catch (InterruptedException interruptedException) {}
/*     */         } 
/*     */ 
/*     */         
/* 336 */         throw DbException.get(28000);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\Engine.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */