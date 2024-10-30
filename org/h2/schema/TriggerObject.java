/*     */ package org.h2.schema;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.api.Trigger;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SessionInterface;
/*     */ import org.h2.jdbc.JdbcConnection;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.util.SourceCompiler;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.value.DataType;
/*     */ import org.h2.value.Value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TriggerObject
/*     */   extends SchemaObjectBase
/*     */ {
/*     */   public static final int DEFAULT_QUEUE_SIZE = 1024;
/*     */   private boolean insteadOf;
/*     */   private boolean before;
/*     */   private int typeMask;
/*     */   private boolean rowBased;
/*     */   private boolean onRollback;
/*  46 */   private int queueSize = 1024;
/*     */   private boolean noWait;
/*     */   private Table table;
/*     */   private String triggerClassName;
/*     */   private String triggerSource;
/*     */   private Trigger triggerCallback;
/*     */   
/*     */   public TriggerObject(Schema paramSchema, int paramInt, String paramString, Table paramTable) {
/*  54 */     initSchemaObjectBase(paramSchema, paramInt, paramString, 12);
/*  55 */     this.table = paramTable;
/*  56 */     setTemporary(paramTable.isTemporary());
/*     */   }
/*     */   
/*     */   public void setBefore(boolean paramBoolean) {
/*  60 */     this.before = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setInsteadOf(boolean paramBoolean) {
/*  64 */     this.insteadOf = paramBoolean;
/*     */   }
/*     */   
/*     */   private synchronized void load() {
/*  68 */     if (this.triggerCallback != null)
/*     */       return; 
/*     */     try {
/*     */       Trigger trigger;
/*  72 */       Session session = this.database.getSystemSession();
/*  73 */       JdbcConnection jdbcConnection = session.createConnection(false);
/*     */       
/*  75 */       if (this.triggerClassName != null) {
/*  76 */         trigger = (Trigger)JdbcUtils.loadUserClass(this.triggerClassName).newInstance();
/*     */       } else {
/*  78 */         trigger = loadFromSource();
/*     */       } 
/*  80 */       this.triggerCallback = trigger;
/*  81 */       this.triggerCallback.init((Connection)jdbcConnection, getSchema().getName(), getName(), this.table.getName(), this.before, this.typeMask);
/*     */     }
/*  83 */     catch (Throwable throwable) {
/*     */       
/*  85 */       this.triggerCallback = null;
/*  86 */       throw DbException.get(90043, throwable, new String[] { getName(), (this.triggerClassName != null) ? this.triggerClassName : "..source..", throwable.toString() });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Trigger loadFromSource() {
/*  92 */     SourceCompiler sourceCompiler = this.database.getCompiler();
/*  93 */     synchronized (sourceCompiler) {
/*  94 */       String str = "org.h2.dynamic.trigger." + getName();
/*  95 */       sourceCompiler.setSource(str, this.triggerSource);
/*     */       try {
/*  97 */         Method method = sourceCompiler.getMethod(str);
/*  98 */         if ((method.getParameterTypes()).length > 0) {
/*  99 */           throw new IllegalStateException("No parameters are allowed for a trigger");
/*     */         }
/* 101 */         return (Trigger)method.invoke(null, new Object[0]);
/* 102 */       } catch (DbException dbException) {
/* 103 */         throw dbException;
/* 104 */       } catch (Exception exception) {
/* 105 */         throw DbException.get(42000, exception, new String[] { this.triggerSource });
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
/*     */   public void setTriggerClassName(String paramString, boolean paramBoolean) {
/* 118 */     setTriggerAction(paramString, (String)null, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTriggerSource(String paramString, boolean paramBoolean) {
/* 129 */     setTriggerAction((String)null, paramString, paramBoolean);
/*     */   }
/*     */   
/*     */   private void setTriggerAction(String paramString1, String paramString2, boolean paramBoolean) {
/* 133 */     this.triggerClassName = paramString1;
/* 134 */     this.triggerSource = paramString2;
/*     */     try {
/* 136 */       load();
/* 137 */     } catch (DbException dbException) {
/* 138 */       if (!paramBoolean) {
/* 139 */         throw dbException;
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
/*     */   public void fire(Session paramSession, int paramInt, boolean paramBoolean) {
/* 154 */     if (this.rowBased || this.before != paramBoolean || (this.typeMask & paramInt) == 0) {
/*     */       return;
/*     */     }
/* 157 */     load();
/* 158 */     JdbcConnection jdbcConnection = paramSession.createConnection(false);
/* 159 */     boolean bool = false;
/* 160 */     if (paramInt != 8) {
/* 161 */       bool = paramSession.setCommitOrRollbackDisabled(true);
/*     */     }
/* 163 */     Value value = paramSession.getLastScopeIdentity();
/*     */     try {
/* 165 */       this.triggerCallback.fire((Connection)jdbcConnection, null, null);
/* 166 */     } catch (Throwable throwable) {
/* 167 */       throw DbException.get(90044, throwable, new String[] { getName(), (this.triggerClassName != null) ? this.triggerClassName : "..source..", throwable.toString() });
/*     */     } finally {
/*     */       
/* 170 */       if (paramSession.getLastTriggerIdentity() != null) {
/* 171 */         paramSession.setLastScopeIdentity(paramSession.getLastTriggerIdentity());
/* 172 */         paramSession.setLastTriggerIdentity(null);
/*     */       } else {
/* 174 */         paramSession.setLastScopeIdentity(value);
/*     */       } 
/* 176 */       if (paramInt != 8) {
/* 177 */         paramSession.setCommitOrRollbackDisabled(bool);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static Object[] convertToObjectList(Row paramRow) {
/* 183 */     if (paramRow == null) {
/* 184 */       return null;
/*     */     }
/* 186 */     int i = paramRow.getColumnCount();
/* 187 */     Object[] arrayOfObject = new Object[i];
/* 188 */     for (byte b = 0; b < i; b++) {
/* 189 */       arrayOfObject[b] = paramRow.getValue(b).getObject();
/*     */     }
/* 191 */     return arrayOfObject;
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
/*     */   public boolean fireRow(Session paramSession, Row paramRow1, Row paramRow2, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     Object object;
/* 210 */     if (!this.rowBased || this.before != paramBoolean1) {
/* 211 */       return false;
/*     */     }
/* 213 */     if (paramBoolean2 && !this.onRollback) {
/* 214 */       return false;
/*     */     }
/* 216 */     load();
/*     */ 
/*     */     
/* 219 */     boolean bool = false;
/* 220 */     if ((this.typeMask & 0x1) != 0 && 
/* 221 */       paramRow1 == null && paramRow2 != null) {
/* 222 */       bool = true;
/*     */     }
/*     */     
/* 225 */     if ((this.typeMask & 0x2) != 0 && 
/* 226 */       paramRow1 != null && paramRow2 != null) {
/* 227 */       bool = true;
/*     */     }
/*     */     
/* 230 */     if ((this.typeMask & 0x4) != 0 && 
/* 231 */       paramRow1 != null && paramRow2 == null) {
/* 232 */       bool = true;
/*     */     }
/*     */     
/* 235 */     if (!bool) {
/* 236 */       return false;
/*     */     }
/* 238 */     Object[] arrayOfObject1 = convertToObjectList(paramRow1);
/* 239 */     Object[] arrayOfObject2 = convertToObjectList(paramRow2);
/*     */     
/* 241 */     if (this.before && arrayOfObject2 != null) {
/* 242 */       object = new Object[arrayOfObject2.length];
/* 243 */       System.arraycopy(arrayOfObject2, 0, object, 0, arrayOfObject2.length);
/*     */     } else {
/* 245 */       object = null;
/*     */     } 
/* 247 */     JdbcConnection jdbcConnection = paramSession.createConnection(false);
/* 248 */     boolean bool1 = paramSession.getAutoCommit();
/* 249 */     boolean bool2 = paramSession.setCommitOrRollbackDisabled(true);
/* 250 */     Value value = paramSession.getLastScopeIdentity();
/*     */     
/* 252 */     try { paramSession.setAutoCommit(false);
/* 253 */       this.triggerCallback.fire((Connection)jdbcConnection, arrayOfObject1, arrayOfObject2);
/* 254 */       if (object != null) {
/* 255 */         for (byte b = 0; b < arrayOfObject2.length; b++) {
/* 256 */           Object object1 = arrayOfObject2[b];
/* 257 */           if (object1 != object[b]) {
/* 258 */             Value value1 = DataType.convertToValue((SessionInterface)paramSession, object1, -1);
/* 259 */             paramRow2.setValue(b, value1);
/*     */           } 
/*     */         } 
/*     */       } }
/* 263 */     catch (Exception exception)
/* 264 */     { if (this.onRollback)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 279 */         return this.insteadOf; }  throw DbException.convert(exception); } finally { if (paramSession.getLastTriggerIdentity() != null) { paramSession.setLastScopeIdentity(paramSession.getLastTriggerIdentity()); paramSession.setLastTriggerIdentity(null); } else { paramSession.setLastScopeIdentity(value); }  paramSession.setCommitOrRollbackDisabled(bool2); paramSession.setAutoCommit(bool1); }  return this.insteadOf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeMask(int paramInt) {
/* 288 */     this.typeMask = paramInt;
/*     */   }
/*     */   
/*     */   public void setRowBased(boolean paramBoolean) {
/* 292 */     this.rowBased = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setQueueSize(int paramInt) {
/* 296 */     this.queueSize = paramInt;
/*     */   }
/*     */   
/*     */   public int getQueueSize() {
/* 300 */     return this.queueSize;
/*     */   }
/*     */   
/*     */   public void setNoWait(boolean paramBoolean) {
/* 304 */     this.noWait = paramBoolean;
/*     */   }
/*     */   
/*     */   public boolean isNoWait() {
/* 308 */     return this.noWait;
/*     */   }
/*     */   
/*     */   public void setOnRollback(boolean paramBoolean) {
/* 312 */     this.onRollback = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/* 317 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/* 322 */     StringBuilder stringBuilder = new StringBuilder("CREATE FORCE TRIGGER ");
/* 323 */     stringBuilder.append(paramString);
/* 324 */     if (this.insteadOf) {
/* 325 */       stringBuilder.append(" INSTEAD OF ");
/* 326 */     } else if (this.before) {
/* 327 */       stringBuilder.append(" BEFORE ");
/*     */     } else {
/* 329 */       stringBuilder.append(" AFTER ");
/*     */     } 
/* 331 */     stringBuilder.append(getTypeNameList());
/* 332 */     stringBuilder.append(" ON ").append(paramTable.getSQL());
/* 333 */     if (this.rowBased) {
/* 334 */       stringBuilder.append(" FOR EACH ROW");
/*     */     }
/* 336 */     if (this.noWait) {
/* 337 */       stringBuilder.append(" NOWAIT");
/*     */     } else {
/* 339 */       stringBuilder.append(" QUEUE ").append(this.queueSize);
/*     */     } 
/* 341 */     if (this.triggerClassName != null) {
/* 342 */       stringBuilder.append(" CALL ").append(Parser.quoteIdentifier(this.triggerClassName));
/*     */     } else {
/* 344 */       stringBuilder.append(" AS ").append(StringUtils.quoteStringSQL(this.triggerSource));
/*     */     } 
/* 346 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   public String getTypeNameList() {
/* 350 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 351 */     if ((this.typeMask & 0x1) != 0) {
/* 352 */       statementBuilder.appendExceptFirst(", ");
/* 353 */       statementBuilder.append("INSERT");
/*     */     } 
/* 355 */     if ((this.typeMask & 0x2) != 0) {
/* 356 */       statementBuilder.appendExceptFirst(", ");
/* 357 */       statementBuilder.append("UPDATE");
/*     */     } 
/* 359 */     if ((this.typeMask & 0x4) != 0) {
/* 360 */       statementBuilder.appendExceptFirst(", ");
/* 361 */       statementBuilder.append("DELETE");
/*     */     } 
/* 363 */     if ((this.typeMask & 0x8) != 0) {
/* 364 */       statementBuilder.appendExceptFirst(", ");
/* 365 */       statementBuilder.append("SELECT");
/*     */     } 
/* 367 */     if (this.onRollback) {
/* 368 */       statementBuilder.appendExceptFirst(", ");
/* 369 */       statementBuilder.append("ROLLBACK");
/*     */     } 
/* 371 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 376 */     return getCreateSQLForCopy(this.table, getSQL());
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 381 */     return 4;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 386 */     this.table.removeTrigger(this);
/* 387 */     this.database.removeMeta(paramSession, getId());
/* 388 */     if (this.triggerCallback != null) {
/*     */       try {
/* 390 */         this.triggerCallback.remove();
/* 391 */       } catch (SQLException sQLException) {
/* 392 */         throw DbException.convert(sQLException);
/*     */       } 
/*     */     }
/* 395 */     this.table = null;
/* 396 */     this.triggerClassName = null;
/* 397 */     this.triggerSource = null;
/* 398 */     this.triggerCallback = null;
/* 399 */     invalidate();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkRename() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getTable() {
/* 413 */     return this.table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBefore() {
/* 422 */     return this.before;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getTriggerClassName() {
/* 431 */     return this.triggerClassName;
/*     */   }
/*     */   
/*     */   public String getTriggerSource() {
/* 435 */     return this.triggerSource;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/* 442 */     if (this.triggerCallback != null) {
/* 443 */       this.triggerCallback.close();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSelectTrigger() {
/* 453 */     return ((this.typeMask & 0x8) != 0);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\TriggerObject.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */