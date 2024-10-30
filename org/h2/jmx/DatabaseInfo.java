/*     */ package org.h2.jmx;
/*     */ 
/*     */ import java.lang.management.ManagementFactory;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Hashtable;
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import javax.management.JMException;
/*     */ import javax.management.MBeanServer;
/*     */ import javax.management.ObjectName;
/*     */ import org.h2.command.Command;
/*     */ import org.h2.engine.ConnectionInfo;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.New;
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
/*     */ public class DatabaseInfo
/*     */   implements DatabaseInfoMBean
/*     */ {
/*  34 */   private static final Map<String, ObjectName> MBEANS = New.hashMap();
/*     */   
/*     */   private final Database database;
/*     */ 
/*     */   
/*     */   private DatabaseInfo(Database paramDatabase) {
/*  40 */     if (paramDatabase == null) {
/*  41 */       throw new IllegalArgumentException("Argument 'database' must not be null");
/*     */     }
/*  43 */     this.database = paramDatabase;
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
/*     */   private static ObjectName getObjectName(String paramString1, String paramString2) throws JMException {
/*  56 */     paramString1 = paramString1.replace(':', '_');
/*  57 */     paramString2 = paramString2.replace(':', '_');
/*  58 */     Hashtable<Object, Object> hashtable = new Hashtable<>();
/*  59 */     hashtable.put("name", paramString1);
/*  60 */     hashtable.put("path", paramString2);
/*  61 */     return new ObjectName("org.h2", (Hashtable)hashtable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void registerMBean(ConnectionInfo paramConnectionInfo, Database paramDatabase) throws JMException {
/*  72 */     String str = paramConnectionInfo.getName();
/*  73 */     if (!MBEANS.containsKey(str)) {
/*  74 */       MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
/*  75 */       String str1 = paramDatabase.getShortName();
/*  76 */       ObjectName objectName = getObjectName(str1, str);
/*  77 */       MBEANS.put(str, objectName);
/*  78 */       DatabaseInfo databaseInfo = new DatabaseInfo(paramDatabase);
/*  79 */       DocumentedMBean documentedMBean = new DocumentedMBean((T)databaseInfo, (Class)DatabaseInfoMBean.class);
/*  80 */       mBeanServer.registerMBean(documentedMBean, objectName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unregisterMBean(String paramString) throws Exception {
/*  90 */     ObjectName objectName = MBEANS.remove(paramString);
/*  91 */     if (objectName != null) {
/*  92 */       MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
/*  93 */       mBeanServer.unregisterMBean(objectName);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isExclusive() {
/*  99 */     return (this.database.getExclusiveSession() != null);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 104 */     return this.database.isReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMode() {
/* 109 */     return this.database.getMode().getName();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMultiThreaded() {
/* 114 */     return this.database.isMultiThreaded();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isMvcc() {
/* 119 */     return this.database.isMultiVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLogMode() {
/* 124 */     return this.database.getLogMode();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setLogMode(int paramInt) {
/* 129 */     this.database.setLogMode(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTraceLevel() {
/* 134 */     return this.database.getTraceSystem().getLevelFile();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTraceLevel(int paramInt) {
/* 139 */     this.database.getTraceSystem().setLevelFile(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFileWriteCountTotal() {
/* 144 */     if (!this.database.isPersistent()) {
/* 145 */       return 0L;
/*     */     }
/* 147 */     PageStore pageStore = this.database.getPageStore();
/* 148 */     if (pageStore != null) {
/* 149 */       return pageStore.getWriteCountTotal();
/*     */     }
/*     */ 
/*     */     
/* 153 */     return 0L;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFileWriteCount() {
/* 158 */     if (!this.database.isPersistent()) {
/* 159 */       return 0L;
/*     */     }
/* 161 */     PageStore pageStore = this.database.getPageStore();
/* 162 */     if (pageStore != null) {
/* 163 */       return pageStore.getWriteCount();
/*     */     }
/* 165 */     return this.database.getMvStore().getStore().getFileStore().getReadCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFileReadCount() {
/* 170 */     if (!this.database.isPersistent()) {
/* 171 */       return 0L;
/*     */     }
/* 173 */     PageStore pageStore = this.database.getPageStore();
/* 174 */     if (pageStore != null) {
/* 175 */       return pageStore.getReadCount();
/*     */     }
/* 177 */     return this.database.getMvStore().getStore().getFileStore().getReadCount();
/*     */   }
/*     */ 
/*     */   
/*     */   public long getFileSize() {
/* 182 */     if (!this.database.isPersistent()) {
/* 183 */       return 0L;
/*     */     }
/* 185 */     PageStore pageStore = this.database.getPageStore();
/* 186 */     if (pageStore != null) {
/* 187 */       return (pageStore.getPageCount() * pageStore.getPageSize() / 1024);
/*     */     }
/* 189 */     return this.database.getMvStore().getStore().getFileStore().size();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCacheSizeMax() {
/* 194 */     if (!this.database.isPersistent()) {
/* 195 */       return 0;
/*     */     }
/* 197 */     PageStore pageStore = this.database.getPageStore();
/* 198 */     if (pageStore != null) {
/* 199 */       return pageStore.getCache().getMaxMemory();
/*     */     }
/* 201 */     return this.database.getMvStore().getStore().getCacheSize() * 1024;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setCacheSizeMax(int paramInt) {
/* 206 */     if (this.database.isPersistent()) {
/* 207 */       this.database.setCacheSize(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCacheSize() {
/* 213 */     if (!this.database.isPersistent()) {
/* 214 */       return 0;
/*     */     }
/* 216 */     PageStore pageStore = this.database.getPageStore();
/* 217 */     if (pageStore != null) {
/* 218 */       return pageStore.getCache().getMemory();
/*     */     }
/* 220 */     return this.database.getMvStore().getStore().getCacheSizeUsed() * 1024;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 225 */     return Constants.getFullVersion();
/*     */   }
/*     */ 
/*     */   
/*     */   public String listSettings() {
/* 230 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 232 */     for (Map.Entry<?, ?> entry : (new TreeMap<>(this.database.getSettings().getSettings())).entrySet())
/*     */     {
/* 234 */       stringBuilder.append((String)entry.getKey()).append(" = ").append((String)entry.getValue()).append('\n');
/*     */     }
/* 236 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String listSessions() {
/* 241 */     StringBuilder stringBuilder = new StringBuilder();
/* 242 */     for (Session session : this.database.getSessions(false)) {
/* 243 */       stringBuilder.append("session id: ").append(session.getId());
/* 244 */       stringBuilder.append(" user: ").append(session.getUser().getName()).append('\n');
/*     */ 
/*     */       
/* 247 */       stringBuilder.append("connected: ").append(new Timestamp(session.getSessionStart())).append('\n');
/*     */ 
/*     */       
/* 250 */       Command command = session.getCurrentCommand();
/* 251 */       if (command != null) {
/* 252 */         stringBuilder.append("statement: ").append(session.getCurrentCommand()).append('\n');
/*     */ 
/*     */         
/* 255 */         long l = session.getCurrentCommandStart();
/* 256 */         if (l != 0L) {
/* 257 */           stringBuilder.append("started: ").append(new Timestamp(l)).append('\n');
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 262 */       Table[] arrayOfTable = session.getLocks();
/* 263 */       if (arrayOfTable.length > 0) {
/* 264 */         for (Table table : session.getLocks()) {
/* 265 */           if (table.isLockedExclusivelyBy(session)) {
/* 266 */             stringBuilder.append("write lock on ");
/*     */           } else {
/* 268 */             stringBuilder.append("read lock on ");
/*     */           } 
/* 270 */           stringBuilder.append(table.getSchema().getName()).append('.').append(table.getName()).append('\n');
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 275 */       stringBuilder.append('\n');
/*     */     } 
/* 277 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\jmx\DatabaseInfo.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */