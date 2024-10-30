/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
/*     */ import org.h2.value.ValueNull;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Analyze
/*     */   extends DefineCommand
/*     */ {
/*     */   private int sampleRows;
/*     */   
/*     */   public Analyze(Session paramSession) {
/*  35 */     super(paramSession);
/*  36 */     this.sampleRows = (paramSession.getDatabase().getSettings()).analyzeSample;
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  41 */     this.session.commit(true);
/*  42 */     this.session.getUser().checkAdmin();
/*  43 */     Database database = this.session.getDatabase();
/*  44 */     for (Table table : database.getAllTablesAndViews(false)) {
/*  45 */       analyzeTable(this.session, table, this.sampleRows, true);
/*     */     }
/*  47 */     return 0;
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
/*     */   public static void analyzeTable(Session paramSession, Table paramTable, int paramInt, boolean paramBoolean) {
/*  60 */     if (!paramTable.getTableType().equals("TABLE") || paramTable.isHidden() || paramSession == null) {
/*     */       return;
/*     */     }
/*     */     
/*  64 */     if (!paramBoolean) {
/*  65 */       if (paramSession.getDatabase().isSysTableLocked()) {
/*     */         return;
/*     */       }
/*  68 */       if (paramTable.hasSelectTrigger()) {
/*     */         return;
/*     */       }
/*     */     } 
/*  72 */     if (paramTable.isTemporary() && !paramTable.isGlobalTemporary() && paramSession.findLocalTempTable(paramTable.getName()) == null) {
/*     */       return;
/*     */     }
/*     */     
/*  76 */     if (paramTable.isLockedExclusively() && !paramTable.isLockedExclusivelyBy(paramSession)) {
/*     */       return;
/*     */     }
/*  79 */     if (!paramSession.getUser().hasRight(paramTable, 1)) {
/*     */       return;
/*     */     }
/*  82 */     if (paramSession.getCancel() != 0L) {
/*     */       return;
/*     */     }
/*     */     
/*  86 */     Column[] arrayOfColumn = paramTable.getColumns();
/*  87 */     if (arrayOfColumn.length == 0) {
/*     */       return;
/*     */     }
/*  90 */     Database database = paramSession.getDatabase();
/*  91 */     StatementBuilder statementBuilder = new StatementBuilder("SELECT ");
/*  92 */     for (Column column : arrayOfColumn) {
/*  93 */       statementBuilder.appendExceptFirst(", ");
/*  94 */       int i = column.getType();
/*  95 */       if (i == 15 || i == 16) {
/*     */ 
/*     */         
/*  98 */         statementBuilder.append("MAX(NULL)");
/*     */       } else {
/* 100 */         statementBuilder.append("SELECTIVITY(").append(column.getSQL()).append(')');
/*     */       } 
/*     */     } 
/* 103 */     statementBuilder.append(" FROM ").append(paramTable.getSQL());
/* 104 */     if (paramInt > 0) {
/* 105 */       statementBuilder.append(" LIMIT ? SAMPLE_SIZE ? ");
/*     */     }
/* 107 */     String str = statementBuilder.toString();
/* 108 */     Prepared prepared = paramSession.prepare(str);
/* 109 */     if (paramInt > 0) {
/* 110 */       ArrayList<Parameter> arrayList = prepared.getParameters();
/* 111 */       ((Parameter)arrayList.get(0)).setValue((Value)ValueInt.get(1));
/* 112 */       ((Parameter)arrayList.get(1)).setValue((Value)ValueInt.get(paramInt));
/*     */     } 
/* 114 */     ResultInterface resultInterface = prepared.query(0);
/* 115 */     resultInterface.next();
/* 116 */     for (byte b = 0; b < arrayOfColumn.length; b++) {
/* 117 */       Value value = resultInterface.currentRow()[b];
/* 118 */       if (value != ValueNull.INSTANCE) {
/* 119 */         int i = value.getInt();
/* 120 */         arrayOfColumn[b].setSelectivity(i);
/*     */       } 
/*     */     } 
/* 123 */     if (paramBoolean) {
/* 124 */       database.updateMeta(paramSession, (DbObject)paramTable);
/*     */     } else {
/* 126 */       Session session = database.getSystemSession();
/* 127 */       if (session != paramSession)
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 132 */         synchronized (session) {
/* 133 */           synchronized (database) {
/* 134 */             database.updateMeta(session, (DbObject)paramTable);
/* 135 */             session.commit(true);
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setTop(int paramInt) {
/* 143 */     this.sampleRows = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 148 */     return 21;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\Analyze.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */