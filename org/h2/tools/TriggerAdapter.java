/*     */ package org.h2.tools;
/*     */ 
/*     */ import java.sql.Connection;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.api.Trigger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TriggerAdapter
/*     */   implements Trigger
/*     */ {
/*     */   protected String schemaName;
/*     */   protected String triggerName;
/*     */   protected String tableName;
/*     */   protected boolean before;
/*     */   protected int type;
/*     */   private SimpleResultSet oldResultSet;
/*     */   private SimpleResultSet newResultSet;
/*     */   private TriggerRowSource oldSource;
/*     */   private TriggerRowSource newSource;
/*     */   
/*     */   public void init(Connection paramConnection, String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt) throws SQLException {
/*  69 */     ResultSet resultSet = paramConnection.getMetaData().getColumns(null, paramString1, paramString3, null);
/*     */     
/*  71 */     this.oldSource = new TriggerRowSource();
/*  72 */     this.newSource = new TriggerRowSource();
/*  73 */     this.oldResultSet = new SimpleResultSet(this.oldSource);
/*  74 */     this.newResultSet = new SimpleResultSet(this.newSource);
/*  75 */     while (resultSet.next()) {
/*  76 */       String str = resultSet.getString("COLUMN_NAME");
/*  77 */       int i = resultSet.getInt("DATA_TYPE");
/*  78 */       int j = resultSet.getInt("COLUMN_SIZE");
/*  79 */       int k = resultSet.getInt("DECIMAL_DIGITS");
/*  80 */       this.oldResultSet.addColumn(str, i, j, k);
/*  81 */       this.newResultSet.addColumn(str, i, j, k);
/*     */     } 
/*  83 */     this.schemaName = paramString1;
/*  84 */     this.triggerName = paramString2;
/*  85 */     this.tableName = paramString3;
/*  86 */     this.before = paramBoolean;
/*  87 */     this.type = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   static class TriggerRowSource
/*     */     implements SimpleRowSource
/*     */   {
/*     */     private Object[] row;
/*     */ 
/*     */     
/*     */     void setRow(Object[] param1ArrayOfObject) {
/*  98 */       this.row = param1ArrayOfObject;
/*     */     }
/*     */ 
/*     */     
/*     */     public Object[] readRow() {
/* 103 */       return this.row;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void close() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void reset() {}
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
/*     */   public void fire(Connection paramConnection, Object[] paramArrayOfObject1, Object[] paramArrayOfObject2) throws SQLException {
/* 144 */     fire(paramConnection, wrap(this.oldResultSet, this.oldSource, paramArrayOfObject1), wrap(this.newResultSet, this.newSource, paramArrayOfObject2));
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
/*     */   public abstract void fire(Connection paramConnection, ResultSet paramResultSet1, ResultSet paramResultSet2) throws SQLException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static SimpleResultSet wrap(SimpleResultSet paramSimpleResultSet, TriggerRowSource paramTriggerRowSource, Object[] paramArrayOfObject) throws SQLException {
/* 170 */     if (paramArrayOfObject == null) {
/* 171 */       return null;
/*     */     }
/* 173 */     paramTriggerRowSource.setRow(paramArrayOfObject);
/* 174 */     paramSimpleResultSet.next();
/* 175 */     return paramSimpleResultSet;
/*     */   }
/*     */   
/*     */   public void remove() throws SQLException {}
/*     */   
/*     */   public void close() throws SQLException {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\tools\TriggerAdapter.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */