/*     */ package org.h2.command;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.message.Trace;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.util.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Command
/*     */   implements CommandInterface
/*     */ {
/*     */   protected final Session session;
/*     */   protected long startTimeNanos;
/*     */   private final Trace trace;
/*     */   private volatile boolean cancel;
/*     */   private final String sql;
/*     */   private boolean canReuse;
/*     */   
/*     */   Command(Parser paramParser, String paramString) {
/*  50 */     this.session = paramParser.getSession();
/*  51 */     this.sql = paramString;
/*  52 */     this.trace = this.session.getDatabase().getTrace(0);
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
/*     */   public abstract boolean isQuery();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void prepareJoinBatch();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract ArrayList<? extends ParameterInterface> getParameters();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract boolean isReadOnly();
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
/*     */   public int update() {
/* 106 */     throw DbException.get(90001);
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
/* 117 */     throw DbException.get(90002);
/*     */   }
/*     */ 
/*     */   
/*     */   public final ResultInterface getMetaData() {
/* 122 */     return queryMeta();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void start() {
/* 129 */     if (this.trace.isInfoEnabled() || this.session.getDatabase().getQueryStatistics()) {
/* 130 */       this.startTimeNanos = System.nanoTime();
/*     */     }
/*     */   }
/*     */   
/*     */   void setProgress(int paramInt) {
/* 135 */     this.session.getDatabase().setProgress(paramInt, this.sql, 0, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkCanceled() {
/* 144 */     if (this.cancel) {
/* 145 */       this.cancel = false;
/* 146 */       throw DbException.get(57014);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void stop() {
/* 151 */     this.session.endStatement();
/* 152 */     this.session.setCurrentCommand(null);
/* 153 */     if (!isTransactional()) {
/* 154 */       this.session.commit(true);
/* 155 */     } else if (this.session.getAutoCommit()) {
/* 156 */       this.session.commit(false);
/* 157 */     } else if (this.session.getDatabase().isMultiThreaded()) {
/* 158 */       Database database = this.session.getDatabase();
/* 159 */       if (database != null && 
/* 160 */         database.getLockMode() == 3) {
/* 161 */         this.session.unlockReadLocks();
/*     */       }
/*     */     } 
/*     */     
/* 165 */     if (this.trace.isInfoEnabled() && this.startTimeNanos > 0L) {
/* 166 */       long l = (System.nanoTime() - this.startTimeNanos) / 1000L / 1000L;
/* 167 */       if (l > 100L) {
/* 168 */         this.trace.info("slow query: {0} ms", new Object[] { Long.valueOf(l) });
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
/*     */   public ResultInterface executeQuery(int paramInt, boolean paramBoolean) {
/* 183 */     this.startTimeNanos = 0L;
/* 184 */     long l = 0L;
/* 185 */     Database database = this.session.getDatabase();
/* 186 */     Object object = database.isMultiThreaded() ? this.session : database;
/* 187 */     this.session.waitIfExclusiveModeEnabled();
/* 188 */     boolean bool1 = true;
/* 189 */     boolean bool2 = !isReadOnly() ? true : false;
/* 190 */     if (bool2) {
/* 191 */       while (!database.beforeWriting());
/*     */     }
/*     */ 
/*     */     
/* 195 */     synchronized (object) {
/* 196 */       this.session.setCurrentCommand(this);
/*     */       try {
/*     */         while (true) {
/* 199 */           database.checkPowerOff();
/*     */           try {
/* 201 */             return query(paramInt);
/* 202 */           } catch (DbException dbException) {
/* 203 */             l = filterConcurrentUpdate(dbException, l);
/* 204 */           } catch (OutOfMemoryError outOfMemoryError) {
/* 205 */             bool1 = false;
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 210 */             database.shutdownImmediately();
/* 211 */             throw DbException.convert(outOfMemoryError);
/* 212 */           } catch (Throwable throwable) {
/* 213 */             throw DbException.convert(throwable);
/*     */           } 
/*     */         } 
/* 216 */       } catch (DbException dbException) {
/* 217 */         dbException = dbException.addSQL(this.sql);
/* 218 */         SQLException sQLException = dbException.getSQLException();
/* 219 */         database.exceptionThrown(sQLException, this.sql);
/* 220 */         if (sQLException.getErrorCode() == 90108) {
/* 221 */           bool1 = false;
/* 222 */           database.shutdownImmediately();
/* 223 */           throw dbException;
/*     */         } 
/* 225 */         database.checkPowerOff();
/* 226 */         throw dbException;
/*     */       } finally {
/* 228 */         if (bool1) {
/* 229 */           stop();
/*     */         }
/* 231 */         if (bool2) {
/* 232 */           database.afterWriting();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int executeUpdate() {
/* 240 */     long l = 0L;
/* 241 */     Database database = this.session.getDatabase();
/* 242 */     Object object = database.isMultiThreaded() ? this.session : database;
/* 243 */     this.session.waitIfExclusiveModeEnabled();
/* 244 */     boolean bool1 = true;
/* 245 */     boolean bool2 = !isReadOnly() ? true : false;
/* 246 */     if (bool2) {
/* 247 */       while (!database.beforeWriting());
/*     */     }
/*     */ 
/*     */     
/* 251 */     synchronized (object) {
/* 252 */       Session.Savepoint savepoint = this.session.setSavepoint();
/* 253 */       this.session.setCurrentCommand(this);
/*     */       try {
/*     */         while (true) {
/* 256 */           database.checkPowerOff();
/*     */           try {
/* 258 */             return update();
/* 259 */           } catch (DbException dbException) {
/* 260 */             l = filterConcurrentUpdate(dbException, l);
/* 261 */           } catch (OutOfMemoryError outOfMemoryError) {
/* 262 */             bool1 = false;
/* 263 */             database.shutdownImmediately();
/* 264 */             throw DbException.convert(outOfMemoryError);
/* 265 */           } catch (Throwable throwable) {
/* 266 */             throw DbException.convert(throwable);
/*     */           } 
/*     */         } 
/* 269 */       } catch (DbException dbException) {
/* 270 */         dbException = dbException.addSQL(this.sql);
/* 271 */         SQLException sQLException = dbException.getSQLException();
/* 272 */         database.exceptionThrown(sQLException, this.sql);
/* 273 */         if (sQLException.getErrorCode() == 90108) {
/* 274 */           bool1 = false;
/* 275 */           database.shutdownImmediately();
/* 276 */           throw dbException;
/*     */         } 
/* 278 */         database.checkPowerOff();
/* 279 */         if (sQLException.getErrorCode() == 40001) {
/* 280 */           this.session.rollback();
/*     */         } else {
/* 282 */           this.session.rollbackTo(savepoint, false);
/*     */         } 
/* 284 */         throw dbException;
/*     */       } finally {
/*     */         try {
/* 287 */           if (bool1) {
/* 288 */             stop();
/*     */           }
/*     */         } finally {
/* 291 */           if (bool2)
/* 292 */             database.afterWriting(); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private long filterConcurrentUpdate(DbException paramDbException, long paramLong) {
/*     */     long l2;
/* 300 */     int i = paramDbException.getErrorCode();
/* 301 */     if (i != 90131 && i != 90112)
/*     */     {
/* 303 */       throw paramDbException;
/*     */     }
/* 305 */     long l1 = System.nanoTime() / 1000000L;
/* 306 */     if (paramLong != 0L && l1 - paramLong > this.session.getLockTimeout()) {
/* 307 */       throw DbException.get(50200, paramDbException.getCause(), new String[] { "" });
/*     */     }
/* 309 */     Database database = this.session.getDatabase();
/* 310 */     int j = 1 + MathUtils.randomInt(10);
/*     */     do {
/*     */       try {
/* 313 */         if (database.isMultiThreaded()) {
/* 314 */           Thread.sleep(j);
/*     */         } else {
/* 316 */           database.wait(j);
/*     */         } 
/* 318 */       } catch (InterruptedException interruptedException) {}
/*     */ 
/*     */       
/* 321 */       l2 = System.nanoTime() / 1000000L - l1;
/* 322 */     } while (l2 < j);
/*     */ 
/*     */ 
/*     */     
/* 326 */     return (paramLong == 0L) ? l1 : paramLong;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 331 */     this.canReuse = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void cancel() {
/* 336 */     this.cancel = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 341 */     return this.sql + Trace.formatParams(getParameters());
/*     */   }
/*     */   
/*     */   public boolean isCacheable() {
/* 345 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canReuse() {
/* 354 */     return this.canReuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reuse() {
/* 362 */     this.canReuse = false;
/* 363 */     ArrayList<? extends ParameterInterface> arrayList = getParameters(); byte b; int i;
/* 364 */     for (b = 0, i = arrayList.size(); b < i; b++) {
/* 365 */       ParameterInterface parameterInterface = arrayList.get(b);
/* 366 */       parameterInterface.setValue(null, true);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\Command.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */