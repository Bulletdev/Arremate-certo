/*     */ package org.h2.store;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.SQLException;
/*     */ import java.util.HashSet;
/*     */ import java.util.Properties;
/*     */ import org.h2.engine.ConnectionInfo;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.store.fs.FilePathRec;
/*     */ import org.h2.store.fs.FileUtils;
/*     */ import org.h2.store.fs.Recorder;
/*     */ import org.h2.tools.Recover;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.New;
/*     */ import org.h2.util.StringUtils;
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
/*     */ 
/*     */ public class RecoverTester
/*     */   implements Recorder
/*     */ {
/*     */   private static RecoverTester instance;
/*  38 */   private String testDatabase = "memFS:reopen";
/*  39 */   private int writeCount = Utils.getProperty("h2.recoverTestOffset", 0);
/*  40 */   private int testEvery = Utils.getProperty("h2.recoverTest", 64);
/*  41 */   private final long maxFileSize = Utils.getProperty("h2.recoverTestMaxFileSize", 2147483647) * 1024L * 1024L;
/*     */   
/*     */   private int verifyCount;
/*  44 */   private final HashSet<String> knownErrors = New.hashSet();
/*     */ 
/*     */ 
/*     */   
/*     */   private volatile boolean testing;
/*     */ 
/*     */ 
/*     */   
/*     */   public static synchronized void init(String paramString) {
/*  53 */     RecoverTester recoverTester = getInstance();
/*  54 */     if (StringUtils.isNumber(paramString)) {
/*  55 */       recoverTester.setTestEvery(Integer.parseInt(paramString));
/*     */     }
/*  57 */     FilePathRec.setRecorder(recoverTester);
/*     */   }
/*     */   
/*     */   public static synchronized RecoverTester getInstance() {
/*  61 */     if (instance == null) {
/*  62 */       instance = new RecoverTester();
/*     */     }
/*  64 */     return instance;
/*     */   }
/*     */ 
/*     */   
/*     */   public void log(int paramInt, String paramString, byte[] paramArrayOfbyte, long paramLong) {
/*  69 */     if (paramInt != 8 && paramInt != 7) {
/*     */       return;
/*     */     }
/*  72 */     if (!paramString.endsWith(".h2.db") && !paramString.endsWith(".mv.db")) {
/*     */       return;
/*     */     }
/*     */     
/*  76 */     this.writeCount++;
/*  77 */     if (this.writeCount % this.testEvery != 0) {
/*     */       return;
/*     */     }
/*  80 */     if (FileUtils.size(paramString) > this.maxFileSize) {
/*     */       return;
/*     */     }
/*     */     
/*  84 */     if (this.testing) {
/*     */       return;
/*     */     }
/*     */     
/*  88 */     this.testing = true;
/*  89 */     PrintWriter printWriter = null;
/*     */     try {
/*  91 */       printWriter = new PrintWriter(new OutputStreamWriter(FileUtils.newOutputStream(paramString + ".log", true)));
/*     */ 
/*     */       
/*  94 */       testDatabase(paramString, printWriter);
/*  95 */     } catch (IOException iOException) {
/*  96 */       throw DbException.convertIOException(iOException, null);
/*     */     } finally {
/*  98 */       IOUtils.closeSilently(printWriter);
/*  99 */       this.testing = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private synchronized void testDatabase(String paramString, PrintWriter paramPrintWriter) {
/* 104 */     paramPrintWriter.println("+ write #" + this.writeCount + " verify #" + this.verifyCount);
/*     */     try {
/* 106 */       IOUtils.copyFiles(paramString, this.testDatabase + ".h2.db");
/* 107 */       String str = paramString.substring(0, paramString.length() - ".h2.db".length()) + ".mv.db";
/*     */ 
/*     */       
/* 110 */       if (FileUtils.exists(str)) {
/* 111 */         IOUtils.copyFiles(str, this.testDatabase + ".mv.db");
/*     */       }
/* 113 */       this.verifyCount++;
/*     */       
/* 115 */       Properties properties = new Properties();
/* 116 */       properties.setProperty("user", "");
/* 117 */       properties.setProperty("password", "");
/* 118 */       ConnectionInfo connectionInfo = new ConnectionInfo("jdbc:h2:" + this.testDatabase + ";FILE_LOCK=NO;TRACE_LEVEL_FILE=0", properties);
/*     */       
/* 120 */       Database database = new Database(connectionInfo, null);
/*     */       
/* 122 */       Session session = database.getSystemSession();
/* 123 */       session.prepare("script to '" + this.testDatabase + ".sql'").query(0);
/* 124 */       session.prepare("shutdown immediately").update();
/* 125 */       database.removeSession(null);
/*     */       
/*     */       return;
/* 128 */     } catch (DbException dbException) {
/* 129 */       SQLException sQLException = DbException.toSQLException((Exception)dbException);
/* 130 */       int i = sQLException.getErrorCode();
/* 131 */       if (i == 28000)
/*     */         return; 
/* 133 */       if (i == 90049) {
/*     */         return;
/*     */       }
/* 136 */       dbException.printStackTrace(System.out);
/* 137 */     } catch (Exception exception) {
/*     */       
/* 139 */       int i = 0;
/* 140 */       if (exception instanceof SQLException) {
/* 141 */         i = ((SQLException)exception).getErrorCode();
/*     */       }
/* 143 */       if (i == 28000)
/*     */         return; 
/* 145 */       if (i == 90049) {
/*     */         return;
/*     */       }
/* 148 */       exception.printStackTrace(System.out);
/*     */     } 
/* 150 */     paramPrintWriter.println("begin ------------------------------ " + this.writeCount);
/*     */     try {
/* 152 */       Recover.execute(paramString.substring(0, paramString.lastIndexOf('/')), null);
/* 153 */     } catch (SQLException sQLException) {}
/*     */ 
/*     */     
/* 156 */     this.testDatabase += "X";
/*     */     try {
/* 158 */       IOUtils.copyFiles(paramString, this.testDatabase + ".h2.db");
/*     */       
/* 160 */       Properties properties = new Properties();
/* 161 */       ConnectionInfo connectionInfo = new ConnectionInfo("jdbc:h2:" + this.testDatabase + ";FILE_LOCK=NO", properties);
/*     */       
/* 163 */       Database database = new Database(connectionInfo, null);
/*     */       
/* 165 */       database.removeSession(null);
/* 166 */     } catch (Exception exception) {
/* 167 */       int i = 0;
/* 168 */       if (exception instanceof DbException) {
/* 169 */         exception = ((DbException)exception).getSQLException();
/* 170 */         i = ((SQLException)exception).getErrorCode();
/*     */       } 
/* 172 */       if (i == 28000)
/*     */         return; 
/* 174 */       if (i == 90049) {
/*     */         return;
/*     */       }
/* 177 */       StringBuilder stringBuilder = new StringBuilder();
/* 178 */       StackTraceElement[] arrayOfStackTraceElement = exception.getStackTrace();
/* 179 */       for (byte b = 0; b < 10 && b < arrayOfStackTraceElement.length; b++) {
/* 180 */         stringBuilder.append(arrayOfStackTraceElement[b].toString()).append('\n');
/*     */       }
/* 182 */       String str = stringBuilder.toString();
/* 183 */       if (!this.knownErrors.contains(str)) {
/* 184 */         paramPrintWriter.println(this.writeCount + " code: " + i + " " + exception.toString());
/* 185 */         exception.printStackTrace(System.out);
/* 186 */         this.knownErrors.add(str);
/*     */       } else {
/* 188 */         paramPrintWriter.println(this.writeCount + " code: " + i);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTestEvery(int paramInt) {
/* 194 */     this.testEvery = paramInt;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\store\RecoverTester.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */