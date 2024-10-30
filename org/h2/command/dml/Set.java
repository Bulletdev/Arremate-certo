/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Mode;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.Setting;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ValueExpression;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.RowFactory;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.tools.CompressTool;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
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
/*     */ public class Set
/*     */   extends Prepared
/*     */ {
/*     */   private final int type;
/*     */   private Expression expression;
/*     */   private String stringValue;
/*     */   private String[] stringValueList;
/*     */   
/*     */   public Set(Session paramSession, int paramInt) {
/*  43 */     super(paramSession);
/*  44 */     this.type = paramInt;
/*     */   }
/*     */   
/*     */   public void setString(String paramString) {
/*  48 */     this.stringValue = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/*  53 */     switch (this.type) {
/*     */       case 5:
/*     */       case 9:
/*     */       case 10:
/*     */       case 13:
/*     */       case 20:
/*     */       case 26:
/*     */       case 28:
/*     */       case 35:
/*     */       case 36:
/*     */       case 40:
/*  64 */         return true;
/*     */     } 
/*     */     
/*  67 */     return false; } public int update() { int k; boolean bool; Table table2; int j; Table table1; int i; Mode mode; CompareMode compareMode1; int i1; Schema schema; int n; Expression expression; String str2; int m; StringBuilder stringBuilder;
/*     */     CompareMode compareMode2;
/*     */     Class<RowFactory> clazz;
/*     */     CompareMode compareMode3;
/*     */     RowFactory rowFactory;
/*  72 */     Database database = this.session.getDatabase();
/*  73 */     String str1 = SetTypes.getTypeName(this.type);
/*  74 */     switch (this.type)
/*     */     { case 24:
/*  76 */         this.session.getUser().checkAdmin();
/*  77 */         k = getIntValue();
/*  78 */         if (k < 0 || k > 2) {
/*  79 */           throw DbException.getInvalidValueException("ALLOW_LITERALS", Integer.valueOf(getIntValue()));
/*     */         }
/*     */         
/*  82 */         database.setAllowLiterals(k);
/*  83 */         addOrUpdateSetting(str1, (String)null, k);
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
/*     */         
/* 522 */         database.getNextModificationDataId();
/*     */ 
/*     */         
/* 525 */         database.getNextModificationMetaId();
/* 526 */         return 0;case 8: if (getIntValue() < 0) throw DbException.getInvalidValueException("CACHE_SIZE", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setCacheSize(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 13: if (!"TRUE".equals(this.stringValue)) { String str = StringUtils.quoteStringSQL(this.stringValue); if (!str.equals(database.getCluster())) { if (!str.equals("''")) this.session.getUser().checkAdmin();  database.setCluster(str); Session session = database.getSystemSession(); synchronized (session) { synchronized (database) { addOrUpdateSetting(session, str1, str, 0); session.commit(true); }  }  }  }  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 12: this.session.getUser().checkAdmin(); bool = database.getCompareMode().isBinaryUnsigned(); stringBuilder = new StringBuilder(this.stringValue); if (this.stringValue.equals("OFF")) { compareMode1 = CompareMode.getInstance(null, 0, bool); } else { int i2 = getIntValue(); stringBuilder.append(" STRENGTH "); if (i2 == 3) { stringBuilder.append("IDENTICAL"); } else if (i2 == 0) { stringBuilder.append("PRIMARY"); } else if (i2 == 1) { stringBuilder.append("SECONDARY"); } else if (i2 == 2) { stringBuilder.append("TERTIARY"); }  compareMode1 = CompareMode.getInstance(this.stringValue, i2, bool); }  compareMode3 = database.getCompareMode(); if (!compareMode3.equals(compareMode1)) { Table table = database.getFirstUserTable(); if (table != null) throw DbException.get(90089, table.getSQL());  addOrUpdateSetting(str1, stringBuilder.toString(), 0); database.setCompareMode(compareMode1); }  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 38: this.session.getUser().checkAdmin(); table2 = database.getFirstUserTable(); if (table2 != null) throw DbException.get(90089, table2.getSQL());  compareMode1 = database.getCompareMode(); if (this.stringValue.equals("SIGNED")) { compareMode2 = CompareMode.getInstance(compareMode1.getName(), compareMode1.getStrength(), false); } else if (this.stringValue.equals("UNSIGNED")) { compareMode2 = CompareMode.getInstance(compareMode1.getName(), compareMode1.getStrength(), true); } else { throw DbException.getInvalidValueException("BINARY_COLLATION", this.stringValue); }  addOrUpdateSetting(str1, this.stringValue, 0); database.setCompareMode(compareMode2); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 23: this.session.getUser().checkAdmin(); j = CompressTool.getCompressAlgorithm(this.stringValue); database.setLobCompressionAlgorithm((j == 0) ? null : this.stringValue); addOrUpdateSetting(str1, this.stringValue, 0); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 34: this.session.getUser().checkAdmin(); if (database.isStarting()) { j = getIntValue(); addOrUpdateSetting(str1, (String)null, j); }  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 15: this.session.getUser().checkAdmin(); database.setEventListenerClass(this.stringValue); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 18: j = getIntValue(); if (j != -1) if (j < 0) throw DbException.getInvalidValueException("DB_CLOSE_DELAY", Integer.valueOf(j));   this.session.getUser().checkAdmin(); database.setCloseDelay(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 6: if (getIntValue() < 0) throw DbException.getInvalidValueException("DEFAULT_LOCK_TIMEOUT", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 7: this.session.getUser().checkAdmin(); database.setDefaultTableType(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 33: this.session.getUser().checkAdmin(); j = getIntValue(); switch (j) { case 0: database.setExclusiveSession(null, false); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 1: database.setExclusiveSession(this.session, false); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 2: database.setExclusiveSession(this.session, true); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0; }  throw DbException.getInvalidValueException("EXCLUSIVE", Integer.valueOf(j));case 39: this.session.getUser().checkAdmin(); table1 = database.getFirstUserTable(); if (table1 != null) throw DbException.get(90141, table1.getSQL());  database.setJavaObjectSerializerName(this.stringValue); addOrUpdateSetting(str1, this.stringValue, 0); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 1: this.session.getUser().checkAdmin(); database.setIgnoreCase((getIntValue() == 1)); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 17: this.session.getUser().checkAdmin(); database.setLockMode(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 5: if (getIntValue() < 0) throw DbException.getInvalidValueException("LOCK_TIMEOUT", Integer.valueOf(getIntValue()));  this.session.setLockTimeout(getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 19: i = getIntValue(); if (database.isPersistent() && i != database.getLogMode()) { this.session.getUser().checkAdmin(); database.setLogMode(i); }  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 22: if (getIntValue() < 0) throw DbException.getInvalidValueException("MAX_LENGTH_INPLACE_LOB", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setMaxLengthInplaceLob(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 2: if (getIntValue() < 0) throw DbException.getInvalidValueException("MAX_LOG_SIZE", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setMaxLogSize(getIntValue() * 1024L * 1024L); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 16: if (getIntValue() < 0) throw DbException.getInvalidValueException("MAX_MEMORY_ROWS", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setMaxMemoryRows(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 21: if (getIntValue() < 0) throw DbException.getInvalidValueException("MAX_MEMORY_UNDO", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setMaxMemoryUndo(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 32: if (getIntValue() < 0) throw DbException.getInvalidValueException("MAX_OPERATION_MEMORY", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); i = getIntValue(); database.setMaxOperationMemory(i); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 3: mode = Mode.getInstance(this.stringValue); if (mode == null) throw DbException.get(90088, this.stringValue);  if (database.getMode() != mode) { this.session.getUser().checkAdmin(); database.setMode(mode); }  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 25: this.session.getUser().checkAdmin(); database.setMultiThreaded((getIntValue() == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 31: if (database.isMultiVersion() != ((getIntValue() == 1))) throw DbException.get(90133, "MVCC");  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 27: this.session.getUser().checkAdmin(); database.setOptimizeReuseResults((getIntValue() != 0)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 36: if (getIntValue() < 0) throw DbException.getInvalidValueException("QUERY_TIMEOUT", Integer.valueOf(getIntValue()));  i1 = getIntValue(); this.session.setQueryTimeout(i1); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 37: i1 = getIntValue(); this.session.setRedoLogBinary((i1 == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 30: this.session.getUser().checkAdmin(); i1 = getIntValue(); if (i1 < 0 || i1 > 1) throw DbException.getInvalidValueException("REFERENTIAL_INTEGRITY", Integer.valueOf(getIntValue()));  database.setReferentialIntegrity((i1 == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 41: this.session.getUser().checkAdmin(); i1 = getIntValue(); if (i1 < 0 || i1 > 1) throw DbException.getInvalidValueException("QUERY_STATISTICS", Integer.valueOf(getIntValue()));  database.setQueryStatistics((i1 == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 42: this.session.getUser().checkAdmin(); i1 = getIntValue(); if (i1 < 1) throw DbException.getInvalidValueException("QUERY_STATISTICS_MAX_ENTRIES", Integer.valueOf(getIntValue()));  database.setQueryStatisticsMaxEntries(i1); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 26: schema = database.getSchema(this.stringValue); this.session.setCurrentSchema(schema); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 28: this.session.setSchemaSearchPath(this.stringValueList); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 10: this.session.getUser().checkAdmin(); if (getCurrentObjectId() == 0) database.getTraceSystem().setLevelFile(getIntValue());  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 9: this.session.getUser().checkAdmin(); if (getCurrentObjectId() == 0) database.getTraceSystem().setLevelSystemOut(getIntValue());  database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 11: if (getIntValue() < 0) throw DbException.getInvalidValueException("TRACE_MAX_FILE_SIZE", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); n = getIntValue() * 1024 * 1024; database.getTraceSystem().setMaxFileSize(n); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 20: if (getIntValue() < 0) throw DbException.getInvalidValueException("THROTTLE", Integer.valueOf(getIntValue()));  this.session.setThrottle(getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 29: n = getIntValue(); if (n < 0 || n > 1) throw DbException.getInvalidValueException("UNDO_LOG", Integer.valueOf(getIntValue()));  this.session.setUndoLogEnabled((n == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 35: expression = this.expression.optimize(this.session); this.session.setVariable(this.stringValue, expression.getValue(this.session)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 14: if (getIntValue() < 0) throw DbException.getInvalidValueException("WRITE_DELAY", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setWriteDelay(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 40: if (getIntValue() < 0) throw DbException.getInvalidValueException("RETENTION_TIME", Integer.valueOf(getIntValue()));  this.session.getUser().checkAdmin(); database.setRetentionTime(getIntValue()); addOrUpdateSetting(str1, (String)null, getIntValue()); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 43: this.session.getUser().checkAdmin(); str2 = this.expression.getColumnName(); clazz = JdbcUtils.loadUserClass(str2); try { rowFactory = clazz.newInstance(); } catch (Exception exception) { throw DbException.convert(exception); }  database.setRowFactory(rowFactory); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 44: m = getIntValue(); if (m != 0 && m != 1) throw DbException.getInvalidValueException("BATCH_JOINS", Integer.valueOf(getIntValue()));  this.session.setJoinBatchEnabled((m == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0;case 45: m = getIntValue(); if (m != 0 && m != 1) throw DbException.getInvalidValueException("FORCE_JOIN_ORDER", Integer.valueOf(getIntValue()));  this.session.setForceJoinOrder((m == 1)); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0; }  DbException.throwInternalError("type=" + this.type); database.getNextModificationDataId(); database.getNextModificationMetaId(); return 0; }
/*     */ 
/*     */   
/*     */   private int getIntValue() {
/* 530 */     this.expression = this.expression.optimize(this.session);
/* 531 */     return this.expression.getValue(this.session).getInt();
/*     */   }
/*     */   
/*     */   public void setInt(int paramInt) {
/* 535 */     this.expression = (Expression)ValueExpression.get((Value)ValueInt.get(paramInt));
/*     */   }
/*     */   
/*     */   public void setExpression(Expression paramExpression) {
/* 539 */     this.expression = paramExpression;
/*     */   }
/*     */   
/*     */   private void addOrUpdateSetting(String paramString1, String paramString2, int paramInt) {
/* 543 */     addOrUpdateSetting(this.session, paramString1, paramString2, paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   private void addOrUpdateSetting(Session paramSession, String paramString1, String paramString2, int paramInt) {
/* 548 */     Database database = paramSession.getDatabase();
/* 549 */     if (database.isReadOnly()) {
/*     */       return;
/*     */     }
/* 552 */     Setting setting = database.findSetting(paramString1);
/* 553 */     boolean bool = false;
/* 554 */     if (setting == null) {
/* 555 */       bool = true;
/* 556 */       int i = getObjectId();
/* 557 */       setting = new Setting(database, i, paramString1);
/*     */     } 
/* 559 */     if (paramString2 != null) {
/* 560 */       if (!bool && setting.getStringValue().equals(paramString2)) {
/*     */         return;
/*     */       }
/* 563 */       setting.setStringValue(paramString2);
/*     */     } else {
/* 565 */       if (!bool && setting.getIntValue() == paramInt) {
/*     */         return;
/*     */       }
/* 568 */       setting.setIntValue(paramInt);
/*     */     } 
/* 570 */     if (bool) {
/* 571 */       database.addDatabaseObject(paramSession, (DbObject)setting);
/*     */     } else {
/* 573 */       database.updateMeta(paramSession, (DbObject)setting);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean needRecompile() {
/* 579 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 584 */     return null;
/*     */   }
/*     */   
/*     */   public void setStringArray(String[] paramArrayOfString) {
/* 588 */     this.stringValueList = paramArrayOfString;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 593 */     return 67;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Set.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */