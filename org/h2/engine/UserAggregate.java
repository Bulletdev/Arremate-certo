/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.api.Aggregate;
/*     */ import org.h2.api.AggregateFunction;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.JdbcUtils;
/*     */ import org.h2.value.DataType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UserAggregate
/*     */   extends DbObjectBase
/*     */ {
/*     */   private String className;
/*     */   private Class<?> javaClass;
/*     */   
/*     */   public UserAggregate(Database paramDatabase, int paramInt, String paramString1, String paramString2, boolean paramBoolean) {
/*  30 */     initDbObjectBase(paramDatabase, paramInt, paramString1, 3);
/*  31 */     this.className = paramString2;
/*  32 */     if (!paramBoolean) {
/*  33 */       getInstance();
/*     */     }
/*     */   }
/*     */   
/*     */   public Aggregate getInstance() {
/*  38 */     if (this.javaClass == null) {
/*  39 */       this.javaClass = JdbcUtils.loadUserClass(this.className);
/*     */     }
/*     */     try {
/*     */       Aggregate aggregate;
/*  43 */       Object object = this.javaClass.newInstance();
/*     */       
/*  45 */       if (object instanceof Aggregate) {
/*  46 */         aggregate = (Aggregate)object;
/*     */       } else {
/*  48 */         aggregate = new AggregateWrapper((AggregateFunction)object);
/*     */       } 
/*  50 */       return aggregate;
/*  51 */     } catch (Exception exception) {
/*  52 */       throw DbException.convert(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  58 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  63 */     return "DROP AGGREGATE IF EXISTS " + getSQL();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/*  68 */     return "CREATE FORCE AGGREGATE " + getSQL() + " FOR " + Parser.quoteIdentifier(this.className);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/*  74 */     return 14;
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void removeChildrenAndResources(Session paramSession) {
/*  79 */     this.database.removeMeta(paramSession, getId());
/*  80 */     this.className = null;
/*  81 */     this.javaClass = null;
/*  82 */     invalidate();
/*     */   }
/*     */ 
/*     */   
/*     */   public void checkRename() {
/*  87 */     throw DbException.getUnsupportedException("AGGREGATE");
/*     */   }
/*     */   
/*     */   public String getJavaClassName() {
/*  91 */     return this.className;
/*     */   }
/*     */ 
/*     */   
/*     */   private static class AggregateWrapper
/*     */     implements Aggregate
/*     */   {
/*     */     private final AggregateFunction aggregateFunction;
/*     */ 
/*     */     
/*     */     AggregateWrapper(AggregateFunction param1AggregateFunction) {
/* 102 */       this.aggregateFunction = param1AggregateFunction;
/*     */     }
/*     */ 
/*     */     
/*     */     public void init(Connection param1Connection) throws SQLException {
/* 107 */       this.aggregateFunction.init(param1Connection);
/*     */     }
/*     */ 
/*     */     
/*     */     public int getInternalType(int[] param1ArrayOfint) throws SQLException {
/* 112 */       int[] arrayOfInt = new int[param1ArrayOfint.length];
/* 113 */       for (byte b = 0; b < param1ArrayOfint.length; b++) {
/* 114 */         arrayOfInt[b] = DataType.convertTypeToSQLType(param1ArrayOfint[b]);
/*     */       }
/* 116 */       return DataType.convertSQLTypeToValueType(this.aggregateFunction.getType(arrayOfInt));
/*     */     }
/*     */ 
/*     */     
/*     */     public void add(Object param1Object) throws SQLException {
/* 121 */       this.aggregateFunction.add(param1Object);
/*     */     }
/*     */ 
/*     */     
/*     */     public Object getResult() throws SQLException {
/* 126 */       return this.aggregateFunction.getResult();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\UserAggregate.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */