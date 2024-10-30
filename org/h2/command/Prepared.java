/*     */ package org.h2.command;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.util.StatementBuilder;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Prepared
/*     */ {
/*     */   protected Session session;
/*     */   protected String sqlStatement;
/*     */   protected boolean create = true;
/*     */   protected ArrayList<Parameter> parameters;
/*     */   protected boolean prepareAlways;
/*     */   private long modificationMetaId;
/*     */   private Command command;
/*     */   private int objectId;
/*     */   private int currentRowNumber;
/*     */   private int rowScanCount;
/*     */   
/*     */   public Prepared(Session paramSession) {
/*  65 */     this.session = paramSession;
/*  66 */     this.modificationMetaId = paramSession.getDatabase().getModificationMetaId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isTransactional();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ResultInterface queryMeta();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract int getType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/*  98 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean needRecompile() {
/* 107 */     Database database = this.session.getDatabase();
/* 108 */     if (database == null) {
/* 109 */       throw DbException.get(90067, "database closed");
/*     */     }
/*     */ 
/*     */     
/* 113 */     return (this.prepareAlways || this.modificationMetaId < database.getModificationMetaId() || (database.getSettings()).recompileAlways);
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
/*     */   long getModificationMetaId() {
/* 125 */     return this.modificationMetaId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void setModificationMetaId(long paramLong) {
/* 134 */     this.modificationMetaId = paramLong;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParameterList(ArrayList<Parameter> paramArrayList) {
/* 143 */     this.parameters = paramArrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Parameter> getParameters() {
/* 152 */     return this.parameters;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkParameters() {
/* 161 */     if (this.parameters != null) {
/* 162 */       byte b; int i; for (b = 0, i = this.parameters.size(); b < i; b++) {
/* 163 */         Parameter parameter = this.parameters.get(b);
/* 164 */         parameter.checkSet();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCommand(Command paramCommand) {
/* 175 */     this.command = paramCommand;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/* 184 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void prepare() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int update() {
/* 201 */     throw DbException.get(90001);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultInterface query(int paramInt) {
/* 212 */     throw DbException.get(90002);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSQL(String paramString) {
/* 221 */     this.sqlStatement = paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSQL() {
/* 230 */     return this.sqlStatement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getCurrentObjectId() {
/* 241 */     return this.objectId;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getObjectId() {
/* 251 */     int i = this.objectId;
/* 252 */     if (i == 0) {
/* 253 */       i = this.session.getDatabase().allocateObjectId();
/*     */     } else {
/* 255 */       this.objectId = 0;
/*     */     } 
/* 257 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPlanSQL() {
/* 266 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void checkCanceled() {
/* 275 */     this.session.checkCanceled();
/* 276 */     Command command = (this.command != null) ? this.command : this.session.getCurrentCommand();
/* 277 */     if (command != null) {
/* 278 */       command.checkCanceled();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObjectId(int paramInt) {
/* 288 */     this.objectId = paramInt;
/* 289 */     this.create = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSession(Session paramSession) {
/* 298 */     this.session = paramSession;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void trace(long paramLong, int paramInt) {
/* 309 */     if (this.session.getTrace().isInfoEnabled() && paramLong > 0L) {
/* 310 */       long l = System.nanoTime() - paramLong;
/* 311 */       String str = Trace.formatParams(this.parameters);
/* 312 */       this.session.getTrace().infoSQL(this.sqlStatement, str, paramInt, l / 1000L / 1000L);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 317 */     if (this.session.getDatabase().getQueryStatistics() && paramLong != 0L) {
/* 318 */       long l = System.nanoTime() - paramLong;
/* 319 */       this.session.getDatabase().getQueryStatisticsData().update(toString(), l, paramInt);
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
/*     */   public void setPrepareAlways(boolean paramBoolean) {
/* 331 */     this.prepareAlways = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setCurrentRowNumber(int paramInt) {
/* 340 */     if ((++this.rowScanCount & 0x7F) == 0) {
/* 341 */       checkCanceled();
/*     */     }
/* 343 */     this.currentRowNumber = paramInt;
/* 344 */     setProgress();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCurrentRowNumber() {
/* 353 */     return this.currentRowNumber;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void setProgress() {
/* 360 */     if ((this.currentRowNumber & 0x7F) == 0) {
/* 361 */       this.session.getDatabase().setProgress(7, this.sqlStatement, this.currentRowNumber, 0);
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
/*     */   public String toString() {
/* 374 */     return this.sqlStatement;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getSQL(Value[] paramArrayOfValue) {
/* 384 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 385 */     for (Value value : paramArrayOfValue) {
/* 386 */       statementBuilder.appendExceptFirst(", ");
/* 387 */       if (value != null) {
/* 388 */         statementBuilder.append(value.getSQL());
/*     */       }
/*     */     } 
/* 391 */     return statementBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String getSQL(Expression[] paramArrayOfExpression) {
/* 401 */     StatementBuilder statementBuilder = new StatementBuilder();
/* 402 */     for (Expression expression : paramArrayOfExpression) {
/* 403 */       statementBuilder.appendExceptFirst(", ");
/* 404 */       if (expression != null) {
/* 405 */         statementBuilder.append(expression.getSQL());
/*     */       }
/*     */     } 
/* 408 */     return statementBuilder.toString();
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
/*     */   protected DbException setRow(DbException paramDbException, int paramInt, String paramString) {
/* 420 */     StringBuilder stringBuilder = new StringBuilder();
/* 421 */     if (this.sqlStatement != null) {
/* 422 */       stringBuilder.append(this.sqlStatement);
/*     */     }
/* 424 */     stringBuilder.append(" -- ");
/* 425 */     if (paramInt > 0) {
/* 426 */       stringBuilder.append("row #").append(paramInt + 1).append(' ');
/*     */     }
/* 428 */     stringBuilder.append('(').append(paramString).append(')');
/* 429 */     return paramDbException.addSQL(stringBuilder.toString());
/*     */   }
/*     */   
/*     */   public boolean isCacheable() {
/* 433 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\Prepared.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */