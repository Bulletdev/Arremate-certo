/*     */ package org.h2.command.ddl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Role;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
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
/*     */ public class DropDatabase
/*     */   extends DefineCommand
/*     */ {
/*     */   private boolean dropAllObjects;
/*     */   private boolean deleteFiles;
/*     */   
/*     */   public DropDatabase(Session paramSession) {
/*  30 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  35 */     if (this.dropAllObjects) {
/*  36 */       dropAllObjects();
/*     */     }
/*  38 */     if (this.deleteFiles) {
/*  39 */       this.session.getDatabase().setDeleteFilesOnDisconnect(true);
/*     */     }
/*  41 */     return 0;
/*     */   }
/*     */   private void dropAllObjects() {
/*     */     boolean bool;
/*  45 */     this.session.getUser().checkAdmin();
/*  46 */     this.session.commit(true);
/*  47 */     Database database = this.session.getDatabase();
/*  48 */     database.lockMeta(this.session);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     do {
/*  54 */       ArrayList arrayList = database.getAllTablesAndViews(false);
/*  55 */       ArrayList<Table> arrayList3 = New.arrayList();
/*  56 */       for (Table table : arrayList) {
/*  57 */         if (table.getName() != null && "VIEW".equals(table.getTableType()))
/*     */         {
/*  59 */           arrayList3.add(table);
/*     */         }
/*     */       } 
/*  62 */       for (Table table : arrayList) {
/*  63 */         if (table.getName() != null && "TABLE LINK".equals(table.getTableType()))
/*     */         {
/*  65 */           arrayList3.add(table);
/*     */         }
/*     */       } 
/*  68 */       for (Table table : arrayList) {
/*  69 */         if (table.getName() != null && "TABLE".equals(table.getTableType()) && !table.isHidden())
/*     */         {
/*     */           
/*  72 */           arrayList3.add(table);
/*     */         }
/*     */       } 
/*  75 */       for (Table table : arrayList) {
/*  76 */         if (table.getName() != null && "EXTERNAL".equals(table.getTableType()) && !table.isHidden())
/*     */         {
/*     */           
/*  79 */           arrayList3.add(table);
/*     */         }
/*     */       } 
/*  82 */       bool = false;
/*  83 */       for (Table table : arrayList3) {
/*  84 */         if (table.getName() == null)
/*     */           continue; 
/*  86 */         if (database.getDependentTable((SchemaObject)table, table) == null) {
/*  87 */           database.removeSchemaObject(this.session, (SchemaObject)table); continue;
/*     */         } 
/*  89 */         bool = true;
/*     */       }
/*     */     
/*  92 */     } while (bool);
/*     */ 
/*     */     
/*  95 */     for (Schema schema : database.getAllSchemas()) {
/*  96 */       if (schema.canDrop()) {
/*  97 */         database.removeDatabaseObject(this.session, (DbObject)schema);
/*     */       }
/*     */     } 
/* 100 */     this.session.findLocalTempTable(null);
/* 101 */     ArrayList arrayList1 = New.arrayList();
/* 102 */     arrayList1.addAll(database.getAllSchemaObjects(3));
/*     */ 
/*     */     
/* 105 */     arrayList1.addAll(database.getAllSchemaObjects(5));
/* 106 */     arrayList1.addAll(database.getAllSchemaObjects(4));
/* 107 */     arrayList1.addAll(database.getAllSchemaObjects(11));
/* 108 */     arrayList1.addAll(database.getAllSchemaObjects(9));
/* 109 */     for (SchemaObject schemaObject : arrayList1) {
/* 110 */       if (schemaObject.isHidden()) {
/*     */         continue;
/*     */       }
/* 113 */       database.removeSchemaObject(this.session, schemaObject);
/*     */     } 
/* 115 */     for (User user : database.getAllUsers()) {
/* 116 */       if (user != this.session.getUser()) {
/* 117 */         database.removeDatabaseObject(this.session, (DbObject)user);
/*     */       }
/*     */     } 
/* 120 */     for (Role role : database.getAllRoles()) {
/* 121 */       String str = role.getCreateSQL();
/*     */       
/* 123 */       if (str != null) {
/* 124 */         database.removeDatabaseObject(this.session, (DbObject)role);
/*     */       }
/*     */     } 
/* 127 */     ArrayList arrayList2 = New.arrayList();
/* 128 */     arrayList2.addAll(database.getAllRights());
/* 129 */     arrayList2.addAll(database.getAllAggregates());
/* 130 */     arrayList2.addAll(database.getAllUserDataTypes());
/* 131 */     for (DbObject dbObject : arrayList2) {
/* 132 */       String str = dbObject.getCreateSQL();
/*     */       
/* 134 */       if (str != null) {
/* 135 */         database.removeDatabaseObject(this.session, dbObject);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setDropAllObjects(boolean paramBoolean) {
/* 141 */     this.dropAllObjects = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setDeleteFiles(boolean paramBoolean) {
/* 145 */     this.deleteFiles = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 150 */     return 38;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DropDatabase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */