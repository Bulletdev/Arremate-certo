/*     */ package org.h2.schema;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Map;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ import org.h2.command.ddl.CreateTableData;
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.DbObjectBase;
/*     */ import org.h2.engine.DbSettings;
/*     */ import org.h2.engine.FunctionAlias;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.mvstore.db.MVTableEngine;
/*     */ import org.h2.table.RegularTable;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.table.TableLink;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Schema
/*     */   extends DbObjectBase
/*     */ {
/*     */   private User owner;
/*     */   private final boolean system;
/*     */   private final ConcurrentHashMap<String, Table> tablesAndViews;
/*     */   private final ConcurrentHashMap<String, Index> indexes;
/*     */   private final ConcurrentHashMap<String, Sequence> sequences;
/*     */   private final ConcurrentHashMap<String, TriggerObject> triggers;
/*     */   private final ConcurrentHashMap<String, Constraint> constraints;
/*     */   private final ConcurrentHashMap<String, Constant> constants;
/*     */   private final ConcurrentHashMap<String, FunctionAlias> functions;
/*  54 */   private final HashSet<String> temporaryUniqueNames = New.hashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Schema(Database paramDatabase, int paramInt, String paramString, User paramUser, boolean paramBoolean) {
/*  68 */     this.tablesAndViews = paramDatabase.newConcurrentStringMap();
/*  69 */     this.indexes = paramDatabase.newConcurrentStringMap();
/*  70 */     this.sequences = paramDatabase.newConcurrentStringMap();
/*  71 */     this.triggers = paramDatabase.newConcurrentStringMap();
/*  72 */     this.constraints = paramDatabase.newConcurrentStringMap();
/*  73 */     this.constants = paramDatabase.newConcurrentStringMap();
/*  74 */     this.functions = paramDatabase.newConcurrentStringMap();
/*  75 */     initDbObjectBase(paramDatabase, paramInt, paramString, 8);
/*  76 */     this.owner = paramUser;
/*  77 */     this.system = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean canDrop() {
/*  86 */     return !this.system;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQLForCopy(Table paramTable, String paramString) {
/*  91 */     throw DbException.throwInternalError();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDropSQL() {
/*  96 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getCreateSQL() {
/* 101 */     if (this.system) {
/* 102 */       return null;
/*     */     }
/* 104 */     return "CREATE SCHEMA IF NOT EXISTS " + getSQL() + " AUTHORIZATION " + this.owner.getSQL();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getType() {
/* 110 */     return 10;
/*     */   }
/*     */ 
/*     */   
/*     */   public void removeChildrenAndResources(Session paramSession) {
/* 115 */     while (this.triggers != null && this.triggers.size() > 0) {
/* 116 */       TriggerObject triggerObject = (TriggerObject)this.triggers.values().toArray()[0];
/* 117 */       this.database.removeSchemaObject(paramSession, triggerObject);
/*     */     } 
/* 119 */     while (this.constraints != null && this.constraints.size() > 0) {
/* 120 */       Constraint constraint = (Constraint)this.constraints.values().toArray()[0];
/* 121 */       this.database.removeSchemaObject(paramSession, (SchemaObject)constraint);
/*     */     } 
/*     */ 
/*     */     
/* 125 */     boolean bool = false;
/*     */     do {
/* 127 */       bool = false;
/* 128 */       if (this.tablesAndViews == null)
/*     */         continue; 
/* 130 */       for (Table table : New.arrayList(this.tablesAndViews.values()))
/*     */       {
/*     */         
/* 133 */         if (table.getName() != null) {
/* 134 */           if (this.database.getDependentTable((SchemaObject)table, table) == null) {
/* 135 */             this.database.removeSchemaObject(paramSession, (SchemaObject)table); continue;
/*     */           } 
/* 137 */           bool = true;
/*     */         }
/*     */       
/*     */       }
/*     */     
/* 142 */     } while (bool);
/* 143 */     while (this.indexes != null && this.indexes.size() > 0) {
/* 144 */       Index index = (Index)this.indexes.values().toArray()[0];
/* 145 */       this.database.removeSchemaObject(paramSession, (SchemaObject)index);
/*     */     } 
/* 147 */     while (this.sequences != null && this.sequences.size() > 0) {
/* 148 */       Sequence sequence = (Sequence)this.sequences.values().toArray()[0];
/* 149 */       this.database.removeSchemaObject(paramSession, sequence);
/*     */     } 
/* 151 */     while (this.constants != null && this.constants.size() > 0) {
/* 152 */       Constant constant = (Constant)this.constants.values().toArray()[0];
/* 153 */       this.database.removeSchemaObject(paramSession, constant);
/*     */     } 
/* 155 */     while (this.functions != null && this.functions.size() > 0) {
/* 156 */       FunctionAlias functionAlias = (FunctionAlias)this.functions.values().toArray()[0];
/* 157 */       this.database.removeSchemaObject(paramSession, (SchemaObject)functionAlias);
/*     */     } 
/* 159 */     this.database.removeMeta(paramSession, getId());
/* 160 */     this.owner = null;
/* 161 */     invalidate();
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
/*     */   public User getOwner() {
/* 175 */     return this.owner; } private Map<String, SchemaObject> getMap(int paramInt) { ConcurrentHashMap<String, Table> concurrentHashMap5;
/*     */     ConcurrentHashMap<String, Sequence> concurrentHashMap4;
/*     */     ConcurrentHashMap<String, Index> concurrentHashMap3;
/*     */     ConcurrentHashMap<String, TriggerObject> concurrentHashMap2;
/*     */     ConcurrentHashMap<String, Constraint> concurrentHashMap1;
/*     */     ConcurrentHashMap<String, Constant> concurrentHashMap;
/* 181 */     switch (paramInt) {
/*     */       case 0:
/* 183 */         return (Map)this.tablesAndViews;
/*     */       
/*     */       case 3:
/* 186 */         return (Map)this.sequences;
/*     */       
/*     */       case 1:
/* 189 */         return (Map)this.indexes;
/*     */       
/*     */       case 4:
/* 192 */         return (Map)this.triggers;
/*     */       
/*     */       case 5:
/* 195 */         return (Map)this.constraints;
/*     */       
/*     */       case 11:
/* 198 */         return (Map)this.constants;
/*     */       
/*     */       case 9:
/* 201 */         return (Map)this.functions;
/*     */     } 
/*     */     
/* 204 */     throw DbException.throwInternalError("type=" + paramInt); }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(SchemaObject paramSchemaObject) {
/* 217 */     if (SysProperties.CHECK && paramSchemaObject.getSchema() != this) {
/* 218 */       DbException.throwInternalError("wrong schema");
/*     */     }
/* 220 */     String str = paramSchemaObject.getName();
/* 221 */     Map<String, SchemaObject> map = getMap(paramSchemaObject.getType());
/* 222 */     if (SysProperties.CHECK && map.get(str) != null) {
/* 223 */       DbException.throwInternalError("object already exists: " + str);
/*     */     }
/* 225 */     map.put(str, paramSchemaObject);
/* 226 */     freeUniqueName(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rename(SchemaObject paramSchemaObject, String paramString) {
/* 236 */     int i = paramSchemaObject.getType();
/* 237 */     Map<String, SchemaObject> map = getMap(i);
/* 238 */     if (SysProperties.CHECK) {
/* 239 */       if (!map.containsKey(paramSchemaObject.getName())) {
/* 240 */         DbException.throwInternalError("not found: " + paramSchemaObject.getName());
/*     */       }
/* 242 */       if (paramSchemaObject.getName().equals(paramString) || map.containsKey(paramString)) {
/* 243 */         DbException.throwInternalError("object already exists: " + paramString);
/*     */       }
/*     */     } 
/* 246 */     paramSchemaObject.checkRename();
/* 247 */     map.remove(paramSchemaObject.getName());
/* 248 */     freeUniqueName(paramSchemaObject.getName());
/* 249 */     paramSchemaObject.rename(paramString);
/* 250 */     map.put(paramString, paramSchemaObject);
/* 251 */     freeUniqueName(paramString);
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
/*     */   public Table findTableOrView(Session paramSession, String paramString) {
/* 264 */     Table table = this.tablesAndViews.get(paramString);
/* 265 */     if (table == null && paramSession != null) {
/* 266 */       table = paramSession.findLocalTempTable(paramString);
/*     */     }
/* 268 */     return table;
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
/*     */   public Index findIndex(Session paramSession, String paramString) {
/* 280 */     Index index = this.indexes.get(paramString);
/* 281 */     if (index == null) {
/* 282 */       index = paramSession.findLocalTempTableIndex(paramString);
/*     */     }
/* 284 */     return index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TriggerObject findTrigger(String paramString) {
/* 295 */     return this.triggers.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sequence findSequence(String paramString) {
/* 306 */     return this.sequences.get(paramString);
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
/*     */   public Constraint findConstraint(Session paramSession, String paramString) {
/* 318 */     Constraint constraint = this.constraints.get(paramString);
/* 319 */     if (constraint == null) {
/* 320 */       constraint = paramSession.findLocalTempTableConstraint(paramString);
/*     */     }
/* 322 */     return constraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Constant findConstant(String paramString) {
/* 333 */     return this.constants.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public FunctionAlias findFunction(String paramString) {
/* 344 */     return this.functions.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void freeUniqueName(String paramString) {
/* 353 */     if (paramString != null) {
/* 354 */       synchronized (this.temporaryUniqueNames) {
/* 355 */         this.temporaryUniqueNames.remove(paramString);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private String getUniqueName(DbObject paramDbObject, Map<String, ? extends SchemaObject> paramMap, String paramString) {
/* 362 */     String str1 = Integer.toHexString(paramDbObject.getName().hashCode()).toUpperCase();
/* 363 */     String str2 = null;
/* 364 */     synchronized (this.temporaryUniqueNames) {
/* 365 */       byte b; int i; for (b = 1, i = str1.length(); b < i; b++) {
/* 366 */         str2 = paramString + str1.substring(0, b);
/* 367 */         if (!paramMap.containsKey(str2) && !this.temporaryUniqueNames.contains(str2)) {
/*     */           break;
/*     */         }
/* 370 */         str2 = null;
/*     */       } 
/* 372 */       if (str2 == null) {
/* 373 */         paramString = paramString + str1 + "_";
/* 374 */         for (b = 0;; b++) {
/* 375 */           str2 = paramString + b;
/* 376 */           if (!paramMap.containsKey(str2) && !this.temporaryUniqueNames.contains(str2)) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/* 381 */       this.temporaryUniqueNames.add(str2);
/*     */     } 
/* 383 */     return str2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUniqueConstraintName(Session paramSession, Table paramTable) {
/*     */     ConcurrentHashMap<String, Constraint> concurrentHashMap;
/* 395 */     if (paramTable.isTemporary() && !paramTable.isGlobalTemporary()) {
/* 396 */       HashMap hashMap = paramSession.getLocalTempTableConstraints();
/*     */     } else {
/* 398 */       concurrentHashMap = this.constraints;
/*     */     } 
/* 400 */     return getUniqueName((DbObject)paramTable, (Map)concurrentHashMap, "CONSTRAINT_");
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
/*     */   public String getUniqueIndexName(Session paramSession, Table paramTable, String paramString) {
/*     */     ConcurrentHashMap<String, Index> concurrentHashMap;
/* 413 */     if (paramTable.isTemporary() && !paramTable.isGlobalTemporary()) {
/* 414 */       HashMap hashMap = paramSession.getLocalTempTableIndexes();
/*     */     } else {
/* 416 */       concurrentHashMap = this.indexes;
/*     */     } 
/* 418 */     return getUniqueName((DbObject)paramTable, (Map)concurrentHashMap, paramString);
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
/*     */   public Table getTableOrView(Session paramSession, String paramString) {
/* 431 */     Table table = this.tablesAndViews.get(paramString);
/* 432 */     if (table == null) {
/* 433 */       if (paramSession != null) {
/* 434 */         table = paramSession.findLocalTempTable(paramString);
/*     */       }
/* 436 */       if (table == null) {
/* 437 */         throw DbException.get(42102, paramString);
/*     */       }
/*     */     } 
/* 440 */     return table;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Index getIndex(String paramString) {
/* 451 */     Index index = this.indexes.get(paramString);
/* 452 */     if (index == null) {
/* 453 */       throw DbException.get(42112, paramString);
/*     */     }
/* 455 */     return index;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Constraint getConstraint(String paramString) {
/* 466 */     Constraint constraint = this.constraints.get(paramString);
/* 467 */     if (constraint == null) {
/* 468 */       throw DbException.get(90057, paramString);
/*     */     }
/* 470 */     return constraint;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Constant getConstant(String paramString) {
/* 481 */     Constant constant = this.constants.get(paramString);
/* 482 */     if (constant == null) {
/* 483 */       throw DbException.get(90115, paramString);
/*     */     }
/* 485 */     return constant;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Sequence getSequence(String paramString) {
/* 496 */     Sequence sequence = this.sequences.get(paramString);
/* 497 */     if (sequence == null) {
/* 498 */       throw DbException.get(90036, paramString);
/*     */     }
/* 500 */     return sequence;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<SchemaObject> getAll() {
/* 509 */     ArrayList<SchemaObject> arrayList = New.arrayList();
/* 510 */     arrayList.addAll(getMap(0).values());
/* 511 */     arrayList.addAll(getMap(3).values());
/* 512 */     arrayList.addAll(getMap(1).values());
/* 513 */     arrayList.addAll(getMap(4).values());
/* 514 */     arrayList.addAll(getMap(5).values());
/* 515 */     arrayList.addAll(getMap(11).values());
/* 516 */     arrayList.addAll(getMap(9).values());
/* 517 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<SchemaObject> getAll(int paramInt) {
/* 527 */     Map<String, SchemaObject> map = getMap(paramInt);
/* 528 */     return New.arrayList(map.values());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArrayList<Table> getAllTablesAndViews() {
/* 537 */     synchronized (this.database) {
/* 538 */       return New.arrayList(this.tablesAndViews.values());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table getTableOrViewByName(String paramString) {
/* 549 */     synchronized (this.database) {
/* 550 */       return this.tablesAndViews.get(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void remove(SchemaObject paramSchemaObject) {
/* 560 */     String str = paramSchemaObject.getName();
/* 561 */     Map<String, SchemaObject> map = getMap(paramSchemaObject.getType());
/* 562 */     if (SysProperties.CHECK && !map.containsKey(str)) {
/* 563 */       DbException.throwInternalError("not found: " + str);
/*     */     }
/* 565 */     map.remove(str);
/* 566 */     freeUniqueName(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Table createTable(CreateTableData paramCreateTableData) {
/* 576 */     synchronized (this.database) {
/* 577 */       if (!paramCreateTableData.temporary || paramCreateTableData.globalTemporary) {
/* 578 */         this.database.lockMeta(paramCreateTableData.session);
/*     */       }
/* 580 */       paramCreateTableData.schema = this;
/* 581 */       if (paramCreateTableData.tableEngine == null) {
/* 582 */         DbSettings dbSettings = this.database.getSettings();
/* 583 */         if (dbSettings.defaultTableEngine != null) {
/* 584 */           paramCreateTableData.tableEngine = dbSettings.defaultTableEngine;
/* 585 */         } else if (dbSettings.mvStore) {
/* 586 */           paramCreateTableData.tableEngine = MVTableEngine.class.getName();
/*     */         } 
/*     */       } 
/* 589 */       if (paramCreateTableData.tableEngine != null) {
/* 590 */         return this.database.getTableEngine(paramCreateTableData.tableEngine).createTable(paramCreateTableData);
/*     */       }
/* 592 */       return (Table)new RegularTable(paramCreateTableData);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TableLink createTableLink(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, boolean paramBoolean1, boolean paramBoolean2) {
/* 614 */     synchronized (this.database) {
/* 615 */       return new TableLink(this, paramInt, paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramString7, paramBoolean1, paramBoolean2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\Schema.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */