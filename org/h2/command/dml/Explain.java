/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.util.Map;
/*     */ import java.util.TreeMap;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.mvstore.db.MVTableEngine;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.store.PageStore;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Explain
/*     */   extends Prepared
/*     */ {
/*     */   private Prepared command;
/*     */   private LocalResult result;
/*     */   private boolean executeCommand;
/*     */   
/*     */   public Explain(Session paramSession) {
/*  36 */     super(paramSession);
/*     */   }
/*     */   
/*     */   public void setCommand(Prepared paramPrepared) {
/*  40 */     this.command = paramPrepared;
/*     */   }
/*     */   
/*     */   public Prepared getCommand() {
/*  44 */     return this.command;
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepare() {
/*  49 */     this.command.prepare();
/*     */   }
/*     */   
/*     */   public void setExecuteCommand(boolean paramBoolean) {
/*  53 */     this.executeCommand = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/*  58 */     return query(-1);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface query(int paramInt) {
/*  63 */     Column column = new Column("PLAN", 13);
/*  64 */     Database database = this.session.getDatabase();
/*  65 */     ExpressionColumn expressionColumn = new ExpressionColumn(database, column);
/*  66 */     Expression[] arrayOfExpression = { (Expression)expressionColumn };
/*  67 */     this.result = new LocalResult(this.session, arrayOfExpression, 1);
/*  68 */     if (paramInt >= 0) {
/*     */       String str;
/*  70 */       if (this.executeCommand) {
/*  71 */         PageStore pageStore = null;
/*  72 */         MVTableEngine.Store store = null;
/*  73 */         if (database.isPersistent()) {
/*  74 */           pageStore = database.getPageStore();
/*  75 */           if (pageStore != null) {
/*  76 */             pageStore.statisticsStart();
/*     */           }
/*  78 */           store = database.getMvStore();
/*  79 */           if (store != null) {
/*  80 */             store.statisticsStart();
/*     */           }
/*     */         } 
/*  83 */         if (this.command.isQuery()) {
/*  84 */           this.command.query(paramInt);
/*     */         } else {
/*  86 */           this.command.update();
/*     */         } 
/*  88 */         str = this.command.getPlanSQL();
/*  89 */         Map<?, ?> map = null;
/*  90 */         if (pageStore != null) {
/*  91 */           map = pageStore.statisticsEnd();
/*  92 */         } else if (store != null) {
/*  93 */           map = store.statisticsEnd();
/*     */         } 
/*  95 */         if (map != null) {
/*  96 */           int i = 0;
/*  97 */           for (Map.Entry entry : map.entrySet()) {
/*  98 */             i += ((Integer)entry.getValue()).intValue();
/*     */           }
/* 100 */           if (i > 0) {
/* 101 */             map = new TreeMap<>(map);
/* 102 */             StringBuilder stringBuilder = new StringBuilder();
/* 103 */             if (map.size() > 1) {
/* 104 */               stringBuilder.append("total: ").append(i).append('\n');
/*     */             }
/* 106 */             for (Map.Entry<?, ?> entry : map.entrySet()) {
/* 107 */               int j = ((Integer)entry.getValue()).intValue();
/* 108 */               int k = (int)(100L * j / i);
/* 109 */               stringBuilder.append((String)entry.getKey()).append(": ").append(j);
/* 110 */               if (map.size() > 1) {
/* 111 */                 stringBuilder.append(" (").append(k).append("%)");
/*     */               }
/* 113 */               stringBuilder.append('\n');
/*     */             } 
/* 115 */             str = str + "\n/*\n" + stringBuilder.toString() + "*/";
/*     */           } 
/*     */         } 
/*     */       } else {
/* 119 */         str = this.command.getPlanSQL();
/*     */       } 
/* 121 */       add(str);
/*     */     } 
/* 123 */     this.result.done();
/* 124 */     return (ResultInterface)this.result;
/*     */   }
/*     */   
/*     */   private void add(String paramString) {
/* 128 */     Value[] arrayOfValue = { ValueString.get(paramString) };
/* 129 */     this.result.addRow(arrayOfValue);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/* 134 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/* 139 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 144 */     return this.command.isReadOnly();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 149 */     return 60;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\Explain.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */