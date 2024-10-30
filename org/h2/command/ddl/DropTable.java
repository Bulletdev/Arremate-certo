/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableView;
/*     */ import org.h2.util.StatementBuilder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DropTable
/*     */   extends SchemaCommand
/*     */ {
/*     */   private boolean ifExists;
/*     */   private String tableName;
/*     */   private Table table;
/*     */   private DropTable next;
/*     */   private int dropAction;
/*     */   
/*     */   public DropTable(Session paramSession, Schema paramSchema) {
/*  35 */     super(paramSession, paramSchema);
/*  36 */     this.dropAction = (paramSession.getDatabase().getSettings()).dropRestrict ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addNextDropTable(DropTable paramDropTable) {
/*  47 */     if (this.next == null) {
/*  48 */       this.next = paramDropTable;
/*     */     } else {
/*  50 */       this.next.addNextDropTable(paramDropTable);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setIfExists(boolean paramBoolean) {
/*  55 */     this.ifExists = paramBoolean;
/*  56 */     if (this.next != null) {
/*  57 */       this.next.setIfExists(paramBoolean);
/*     */     }
/*     */   }
/*     */   
/*     */   public void setTableName(String paramString) {
/*  62 */     this.tableName = paramString;
/*     */   }
/*     */   
/*     */   private void prepareDrop() {
/*  66 */     this.table = getSchema().findTableOrView(this.session, this.tableName);
/*  67 */     if (this.table == null) {
/*  68 */       if (!this.ifExists) {
/*  69 */         throw DbException.get(42102, this.tableName);
/*     */       }
/*     */     } else {
/*  72 */       this.session.getUser().checkRight(this.table, 15);
/*  73 */       if (!this.table.canDrop()) {
/*  74 */         throw DbException.get(90118, this.tableName);
/*     */       }
/*  76 */       if (this.dropAction == 0) {
/*  77 */         ArrayList arrayList = this.table.getViews();
/*  78 */         if (arrayList != null && arrayList.size() > 0) {
/*  79 */           StatementBuilder statementBuilder = new StatementBuilder();
/*  80 */           for (TableView tableView : arrayList) {
/*  81 */             statementBuilder.appendExceptFirst(", ");
/*  82 */             statementBuilder.append(tableView.getName());
/*     */           } 
/*  84 */           throw DbException.get(90107, new String[] { this.tableName, statementBuilder.toString() });
/*     */         } 
/*     */       } 
/*  87 */       this.table.lock(this.session, true, true);
/*     */     } 
/*  89 */     if (this.next != null) {
/*  90 */       this.next.prepareDrop();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void executeDrop() {
/*  97 */     this.table = getSchema().findTableOrView(this.session, this.tableName);
/*     */     
/*  99 */     if (this.table != null) {
/* 100 */       this.table.setModified();
/* 101 */       Database database = this.session.getDatabase();
/* 102 */       database.lockMeta(this.session);
/* 103 */       database.removeSchemaObject(this.session, (SchemaObject)this.table);
/*     */     } 
/* 105 */     if (this.next != null) {
/* 106 */       this.next.executeDrop();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/* 112 */     this.session.commit(true);
/* 113 */     prepareDrop();
/* 114 */     executeDrop();
/* 115 */     return 0;
/*     */   }
/*     */   
/*     */   public void setDropAction(int paramInt) {
/* 119 */     this.dropAction = paramInt;
/* 120 */     if (this.next != null) {
/* 121 */       this.next.setDropAction(paramInt);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 127 */     return 44;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropTable.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */