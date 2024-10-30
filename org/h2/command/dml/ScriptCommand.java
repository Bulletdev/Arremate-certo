/*     */ package org.h2.command.dml;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.nio.charset.Charset;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Set;
/*     */ import org.h2.api.JavaObjectSerializer;
/*     */ import org.h2.command.Parser;
/*     */ import org.h2.constraint.Constraint;
/*     */ import org.h2.engine.Comment;
/*     */ import org.h2.engine.Constants;
/*     */ import org.h2.engine.Database;
/*     */ import org.h2.engine.DbObject;
/*     */ import org.h2.engine.Right;
/*     */ import org.h2.engine.Role;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.Setting;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.engine.User;
/*     */ import org.h2.engine.UserAggregate;
/*     */ import org.h2.engine.UserDataType;
/*     */ import org.h2.expression.Expression;
/*     */ import org.h2.expression.ExpressionColumn;
/*     */ import org.h2.index.Cursor;
/*     */ import org.h2.index.Index;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.LocalResult;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.schema.Constant;
/*     */ import org.h2.schema.Schema;
/*     */ import org.h2.schema.SchemaObject;
/*     */ import org.h2.schema.Sequence;
/*     */ import org.h2.schema.TriggerObject;
/*     */ import org.h2.store.FileStore;
/*     */ import org.h2.store.LobStorageBackend;
/*     */ import org.h2.table.Column;
/*     */ import org.h2.table.PlanItem;
/*     */ import org.h2.table.Table;
/*     */ import org.h2.util.IOUtils;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.SmallLRUCache;
/*     */ import org.h2.util.StatementBuilder;
/*     */ import org.h2.util.StringUtils;
/*     */ import org.h2.util.TempFileDeleter;
/*     */ import org.h2.util.Utils;
/*     */ import org.h2.value.CompareMode;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueString;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScriptCommand
/*     */   extends ScriptBase
/*     */ {
/*  69 */   private Charset charset = Constants.UTF8;
/*     */   
/*     */   private Set<String> schemaNames;
/*     */   
/*     */   private Collection<Table> tables;
/*     */   
/*     */   private boolean passwords;
/*     */   
/*     */   private boolean data;
/*     */   private boolean settings;
/*     */   private boolean drop;
/*     */   private boolean simple;
/*     */   private LocalResult result;
/*     */   private String lineSeparatorString;
/*     */   private byte[] lineSeparator;
/*     */   private byte[] buffer;
/*     */   private boolean tempLobTableCreated;
/*     */   private int nextLobId;
/*  87 */   private int lobBlockSize = 4096;
/*     */   
/*     */   public ScriptCommand(Session paramSession) {
/*  90 */     super(paramSession);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/*  95 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchemaNames(Set<String> paramSet) {
/* 101 */     this.schemaNames = paramSet;
/*     */   }
/*     */   
/*     */   public void setTables(Collection<Table> paramCollection) {
/* 105 */     this.tables = paramCollection;
/*     */   }
/*     */   
/*     */   public void setData(boolean paramBoolean) {
/* 109 */     this.data = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setPasswords(boolean paramBoolean) {
/* 113 */     this.passwords = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setSettings(boolean paramBoolean) {
/* 117 */     this.settings = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setLobBlockSize(long paramLong) {
/* 121 */     this.lobBlockSize = MathUtils.convertLongToInt(paramLong);
/*     */   }
/*     */   
/*     */   public void setDrop(boolean paramBoolean) {
/* 125 */     this.drop = paramBoolean;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 130 */     LocalResult localResult = createResult();
/* 131 */     localResult.done();
/* 132 */     return (ResultInterface)localResult;
/*     */   }
/*     */   
/*     */   private LocalResult createResult() {
/* 136 */     Expression[] arrayOfExpression = { (Expression)new ExpressionColumn(this.session.getDatabase(), new Column("SCRIPT", 13)) };
/*     */     
/* 138 */     return new LocalResult(this.session, arrayOfExpression, 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface query(int paramInt) {
/* 143 */     this.session.getUser().checkAdmin();
/* 144 */     reset();
/* 145 */     Database database = this.session.getDatabase();
/* 146 */     if (this.schemaNames != null) {
/* 147 */       for (String str : this.schemaNames) {
/* 148 */         Schema schema = database.findSchema(str);
/* 149 */         if (schema == null) {
/* 150 */           throw DbException.get(90079, str);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*     */     try {
/* 156 */       this.result = createResult();
/* 157 */       deleteStore();
/* 158 */       openOutput();
/* 159 */       if (this.out != null) {
/* 160 */         this.buffer = new byte[4096];
/*     */       }
/* 162 */       if (this.settings) {
/* 163 */         for (Setting setting : database.getAllSettings()) {
/* 164 */           if (setting.getName().equals(SetTypes.getTypeName(34))) {
/*     */             continue;
/*     */           }
/*     */ 
/*     */ 
/*     */           
/* 170 */           add(setting.getCreateSQL(), false);
/*     */         } 
/*     */       }
/* 173 */       if (this.out != null) {
/* 174 */         add("", true);
/*     */       }
/* 176 */       for (User user : database.getAllUsers()) {
/* 177 */         add(user.getCreateSQL(this.passwords), false);
/*     */       }
/* 179 */       for (Role role : database.getAllRoles()) {
/* 180 */         add(role.getCreateSQL(true), false);
/*     */       }
/* 182 */       for (Schema schema : database.getAllSchemas()) {
/* 183 */         if (excludeSchema(schema)) {
/*     */           continue;
/*     */         }
/* 186 */         add(schema.getCreateSQL(), false);
/*     */       } 
/* 188 */       for (UserDataType userDataType : database.getAllUserDataTypes()) {
/* 189 */         if (this.drop) {
/* 190 */           add(userDataType.getDropSQL(), false);
/*     */         }
/* 192 */         add(userDataType.getCreateSQL(), false);
/*     */       } 
/* 194 */       for (SchemaObject schemaObject : database.getAllSchemaObjects(11)) {
/*     */         
/* 196 */         if (excludeSchema(schemaObject.getSchema())) {
/*     */           continue;
/*     */         }
/* 199 */         Constant constant = (Constant)schemaObject;
/* 200 */         add(constant.getCreateSQL(), false);
/*     */       } 
/*     */       
/* 203 */       ArrayList<?> arrayList1 = database.getAllTablesAndViews(false);
/*     */ 
/*     */       
/* 206 */       Collections.sort(arrayList1, new Comparator<Table>()
/*     */           {
/*     */             public int compare(Table param1Table1, Table param1Table2) {
/* 209 */               return param1Table1.getId() - param1Table2.getId();
/*     */             }
/*     */           });
/*     */ 
/*     */       
/* 214 */       for (Table table : arrayList1) {
/* 215 */         if (excludeSchema(table.getSchema())) {
/*     */           continue;
/*     */         }
/* 218 */         if (excludeTable(table)) {
/*     */           continue;
/*     */         }
/* 221 */         if (table.isHidden()) {
/*     */           continue;
/*     */         }
/* 224 */         table.lock(this.session, false, false);
/* 225 */         String str = table.getCreateSQL();
/* 226 */         if (str == null) {
/*     */           continue;
/*     */         }
/*     */         
/* 230 */         if (this.drop) {
/* 231 */           add(table.getDropSQL(), false);
/*     */         }
/*     */       } 
/* 234 */       for (SchemaObject schemaObject : database.getAllSchemaObjects(9)) {
/*     */         
/* 236 */         if (excludeSchema(schemaObject.getSchema())) {
/*     */           continue;
/*     */         }
/* 239 */         if (this.drop) {
/* 240 */           add(schemaObject.getDropSQL(), false);
/*     */         }
/* 242 */         add(schemaObject.getCreateSQL(), false);
/*     */       } 
/* 244 */       for (UserAggregate userAggregate : database.getAllAggregates()) {
/* 245 */         if (this.drop) {
/* 246 */           add(userAggregate.getDropSQL(), false);
/*     */         }
/* 248 */         add(userAggregate.getCreateSQL(), false);
/*     */       } 
/* 250 */       for (SchemaObject schemaObject : database.getAllSchemaObjects(3)) {
/*     */         
/* 252 */         if (excludeSchema(schemaObject.getSchema())) {
/*     */           continue;
/*     */         }
/* 255 */         Sequence sequence = (Sequence)schemaObject;
/* 256 */         if (this.drop) {
/* 257 */           add(sequence.getDropSQL(), false);
/*     */         }
/* 259 */         add(sequence.getCreateSQL(), false);
/*     */       } 
/*     */ 
/*     */       
/* 263 */       int i = 0;
/* 264 */       for (Table table : arrayList1) {
/* 265 */         if (excludeSchema(table.getSchema())) {
/*     */           continue;
/*     */         }
/* 268 */         if (excludeTable(table)) {
/*     */           continue;
/*     */         }
/* 271 */         if (table.isHidden()) {
/*     */           continue;
/*     */         }
/* 274 */         table.lock(this.session, false, false);
/* 275 */         String str1 = table.getCreateSQL();
/* 276 */         if (str1 == null) {
/*     */           continue;
/*     */         }
/*     */         
/* 280 */         String str2 = table.getTableType();
/* 281 */         add(str1, false);
/* 282 */         ArrayList arrayList = table.getConstraints();
/* 283 */         if (arrayList != null) {
/* 284 */           for (Constraint constraint : arrayList) {
/* 285 */             if ("PRIMARY KEY".equals(constraint.getConstraintType()))
/*     */             {
/* 287 */               add(constraint.getCreateSQLWithoutIndexes(), false);
/*     */             }
/*     */           } 
/*     */         }
/* 291 */         if ("TABLE".equals(str2)) {
/* 292 */           if (table.canGetRowCount()) {
/* 293 */             String str = "-- " + table.getRowCountApproximation() + " +/- SELECT COUNT(*) FROM " + table.getSQL();
/*     */ 
/*     */             
/* 296 */             add(str, false);
/*     */           } 
/* 298 */           if (this.data) {
/* 299 */             i = generateInsertValues(i, table);
/*     */           }
/*     */         } 
/* 302 */         ArrayList<Index> arrayList3 = table.getIndexes();
/* 303 */         for (byte b = 0; arrayList3 != null && b < arrayList3.size(); b++) {
/* 304 */           Index index = arrayList3.get(b);
/* 305 */           if (!index.getIndexType().getBelongsToConstraint()) {
/* 306 */             add(index.getCreateSQL(), false);
/*     */           }
/*     */         } 
/*     */       } 
/* 310 */       if (this.tempLobTableCreated) {
/* 311 */         add("DROP TABLE IF EXISTS SYSTEM_LOB_STREAM", true);
/* 312 */         add("CALL SYSTEM_COMBINE_BLOB(-1)", true);
/* 313 */         add("DROP ALIAS IF EXISTS SYSTEM_COMBINE_CLOB", true);
/* 314 */         add("DROP ALIAS IF EXISTS SYSTEM_COMBINE_BLOB", true);
/* 315 */         this.tempLobTableCreated = false;
/*     */       } 
/*     */       
/* 318 */       ArrayList<?> arrayList2 = database.getAllSchemaObjects(5);
/*     */       
/* 320 */       Collections.sort(arrayList2, new Comparator<SchemaObject>()
/*     */           {
/*     */             public int compare(SchemaObject param1SchemaObject1, SchemaObject param1SchemaObject2) {
/* 323 */               return ((Constraint)param1SchemaObject1).compareTo((Constraint)param1SchemaObject2);
/*     */             }
/*     */           });
/* 326 */       for (SchemaObject schemaObject : arrayList2) {
/* 327 */         if (excludeSchema(schemaObject.getSchema())) {
/*     */           continue;
/*     */         }
/* 330 */         Constraint constraint = (Constraint)schemaObject;
/* 331 */         if (excludeTable(constraint.getTable())) {
/*     */           continue;
/*     */         }
/* 334 */         if (constraint.getTable().isHidden()) {
/*     */           continue;
/*     */         }
/* 337 */         if (!"PRIMARY KEY".equals(constraint.getConstraintType())) {
/* 338 */           add(constraint.getCreateSQLWithoutIndexes(), false);
/*     */         }
/*     */       } 
/*     */       
/* 342 */       for (SchemaObject schemaObject : database.getAllSchemaObjects(4)) {
/* 343 */         if (excludeSchema(schemaObject.getSchema())) {
/*     */           continue;
/*     */         }
/* 346 */         TriggerObject triggerObject = (TriggerObject)schemaObject;
/* 347 */         if (excludeTable(triggerObject.getTable())) {
/*     */           continue;
/*     */         }
/* 350 */         add(triggerObject.getCreateSQL(), false);
/*     */       } 
/*     */       
/* 353 */       for (Right right : database.getAllRights()) {
/* 354 */         DbObject dbObject = right.getGrantedObject();
/* 355 */         if (dbObject != null) {
/* 356 */           if (dbObject instanceof Schema) {
/* 357 */             if (excludeSchema((Schema)dbObject)) {
/*     */               continue;
/*     */             }
/* 360 */           } else if (dbObject instanceof Table) {
/* 361 */             Table table = (Table)dbObject;
/* 362 */             if (excludeSchema(table.getSchema())) {
/*     */               continue;
/*     */             }
/* 365 */             if (excludeTable(table)) {
/*     */               continue;
/*     */             }
/*     */           } 
/*     */         }
/* 370 */         add(right.getCreateSQL(), false);
/*     */       } 
/*     */       
/* 373 */       for (Comment comment : database.getAllComments()) {
/* 374 */         add(comment.getCreateSQL(), false);
/*     */       }
/* 376 */       if (this.out != null) {
/* 377 */         this.out.close();
/*     */       }
/* 379 */     } catch (IOException iOException) {
/* 380 */       throw DbException.convertIOException(iOException, getFileName());
/*     */     } finally {
/* 382 */       closeIO();
/*     */     } 
/* 384 */     this.result.done();
/* 385 */     LocalResult localResult = this.result;
/* 386 */     reset();
/* 387 */     return (ResultInterface)localResult;
/*     */   }
/*     */   
/*     */   private int generateInsertValues(int paramInt, Table paramTable) throws IOException {
/* 391 */     PlanItem planItem = paramTable.getBestPlanItem(this.session, null, null, -1, null, null);
/* 392 */     Index index = planItem.getIndex();
/* 393 */     Cursor cursor = index.find(this.session, null, null);
/* 394 */     Column[] arrayOfColumn = paramTable.getColumns();
/* 395 */     StatementBuilder statementBuilder = new StatementBuilder("INSERT INTO ");
/* 396 */     statementBuilder.append(paramTable.getSQL()).append('(');
/* 397 */     for (Column column : arrayOfColumn) {
/* 398 */       statementBuilder.appendExceptFirst(", ");
/* 399 */       statementBuilder.append(Parser.quoteIdentifier(column.getName()));
/*     */     } 
/* 401 */     statementBuilder.append(") VALUES");
/* 402 */     if (!this.simple) {
/* 403 */       statementBuilder.append('\n');
/*     */     }
/* 405 */     statementBuilder.append('(');
/* 406 */     String str = statementBuilder.toString();
/* 407 */     statementBuilder = null;
/* 408 */     while (cursor.next()) {
/* 409 */       Row row = cursor.get();
/* 410 */       if (statementBuilder == null) {
/* 411 */         statementBuilder = new StatementBuilder(str);
/*     */       } else {
/* 413 */         statementBuilder.append(",\n(");
/*     */       } 
/* 415 */       for (byte b = 0; b < row.getColumnCount(); b++) {
/* 416 */         if (b > 0) {
/* 417 */           statementBuilder.append(", ");
/*     */         }
/* 419 */         Value value = row.getValue(b);
/* 420 */         if (value.getPrecision() > this.lobBlockSize) {
/*     */           
/* 422 */           if (value.getType() == 16) {
/* 423 */             int i = writeLobStream(value);
/* 424 */             statementBuilder.append("SYSTEM_COMBINE_CLOB(" + i + ")");
/* 425 */           } else if (value.getType() == 15) {
/* 426 */             int i = writeLobStream(value);
/* 427 */             statementBuilder.append("SYSTEM_COMBINE_BLOB(" + i + ")");
/*     */           } else {
/* 429 */             statementBuilder.append(value.getSQL());
/*     */           } 
/*     */         } else {
/* 432 */           statementBuilder.append(value.getSQL());
/*     */         } 
/*     */       } 
/* 435 */       statementBuilder.append(')');
/* 436 */       paramInt++;
/* 437 */       if ((paramInt & 0x7F) == 0) {
/* 438 */         checkCanceled();
/*     */       }
/* 440 */       if (this.simple || statementBuilder.length() > 4096) {
/* 441 */         add(statementBuilder.toString(), true);
/* 442 */         statementBuilder = null;
/*     */       } 
/*     */     } 
/* 445 */     if (statementBuilder != null) {
/* 446 */       add(statementBuilder.toString(), true);
/*     */     }
/* 448 */     return paramInt;
/*     */   } private int writeLobStream(Value paramValue) throws IOException {
/*     */     byte[] arrayOfByte;
/*     */     char[] arrayOfChar;
/* 452 */     if (!this.tempLobTableCreated) {
/* 453 */       add("CREATE TABLE IF NOT EXISTS SYSTEM_LOB_STREAM(ID INT NOT NULL, PART INT NOT NULL, CDATA VARCHAR, BDATA BINARY)", true);
/*     */ 
/*     */ 
/*     */       
/* 457 */       add("CREATE PRIMARY KEY SYSTEM_LOB_STREAM_PRIMARY_KEY ON SYSTEM_LOB_STREAM(ID, PART)", true);
/*     */       
/* 459 */       add("CREATE ALIAS IF NOT EXISTS SYSTEM_COMBINE_CLOB FOR \"" + getClass().getName() + ".combineClob\"", true);
/*     */       
/* 461 */       add("CREATE ALIAS IF NOT EXISTS SYSTEM_COMBINE_BLOB FOR \"" + getClass().getName() + ".combineBlob\"", true);
/*     */       
/* 463 */       this.tempLobTableCreated = true;
/*     */     } 
/* 465 */     int i = this.nextLobId++;
/* 466 */     switch (paramValue.getType())
/*     */     { case 15:
/* 468 */         arrayOfByte = new byte[this.lobBlockSize];
/* 469 */         try (InputStream null = paramValue.getInputStream()) {
/* 470 */           for (byte b = 0;; b++) {
/* 471 */             StringBuilder stringBuilder = new StringBuilder(this.lobBlockSize * 2);
/* 472 */             stringBuilder.append("INSERT INTO SYSTEM_LOB_STREAM VALUES(" + i + ", " + b + ", NULL, '");
/*     */             
/* 474 */             int j = IOUtils.readFully(inputStream, arrayOfByte, this.lobBlockSize);
/* 475 */             if (j <= 0) {
/*     */               break;
/*     */             }
/* 478 */             stringBuilder.append(StringUtils.convertBytesToHex(arrayOfByte, j)).append("')");
/* 479 */             String str = stringBuilder.toString();
/* 480 */             add(str, true);
/*     */           } 
/*     */         } 
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
/* 507 */         return i;case 16: arrayOfChar = new char[this.lobBlockSize]; try (Reader null = paramValue.getReader()) { for (byte b = 0;; b++) { StringBuilder stringBuilder = new StringBuilder(this.lobBlockSize * 2); stringBuilder.append("INSERT INTO SYSTEM_LOB_STREAM VALUES(" + i + ", " + b + ", "); int j = IOUtils.readFully(reader, arrayOfChar, this.lobBlockSize); if (j == 0) break;  stringBuilder.append(StringUtils.quoteStringSQL(new String(arrayOfChar, 0, j))).append(", NULL)"); String str = stringBuilder.toString(); add(str, true); }  }  return i; }  DbException.throwInternalError("type:" + paramValue.getType()); return i;
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
/*     */   public static InputStream combineBlob(Connection paramConnection, int paramInt) throws SQLException {
/* 521 */     if (paramInt < 0) {
/* 522 */       return null;
/*     */     }
/* 524 */     final ResultSet rs = getLobStream(paramConnection, "BDATA", paramInt);
/* 525 */     return new InputStream() {
/*     */         private InputStream current;
/*     */         private boolean closed;
/*     */         
/*     */         public int read() throws IOException {
/*     */           try {
/*     */             while (true)
/* 532 */             { if (this.current == null) {
/* 533 */                 if (this.closed) {
/* 534 */                   return -1;
/*     */                 }
/* 536 */                 if (!rs.next()) {
/* 537 */                   close();
/* 538 */                   return -1;
/*     */                 } 
/* 540 */                 this.current = rs.getBinaryStream(1);
/* 541 */                 this.current = new BufferedInputStream(this.current);
/*     */               } 
/* 543 */               int i = this.current.read();
/* 544 */               if (i >= 0) {
/* 545 */                 return i;
/*     */               }
/* 547 */               this.current = null; } 
/* 548 */           } catch (SQLException sQLException) {
/* 549 */             throw DbException.convertToIOException(sQLException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void close() throws IOException {
/* 555 */           if (this.closed) {
/*     */             return;
/*     */           }
/* 558 */           this.closed = true;
/*     */           try {
/* 560 */             rs.close();
/* 561 */           } catch (SQLException sQLException) {
/* 562 */             throw DbException.convertToIOException(sQLException);
/*     */           } 
/*     */         }
/*     */       };
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
/*     */   public static Reader combineClob(Connection paramConnection, int paramInt) throws SQLException {
/* 577 */     if (paramInt < 0) {
/* 578 */       return null;
/*     */     }
/* 580 */     final ResultSet rs = getLobStream(paramConnection, "CDATA", paramInt);
/* 581 */     return new Reader() {
/*     */         private Reader current;
/*     */         private boolean closed;
/*     */         
/*     */         public int read() throws IOException {
/*     */           try {
/*     */             while (true)
/* 588 */             { if (this.current == null) {
/* 589 */                 if (this.closed) {
/* 590 */                   return -1;
/*     */                 }
/* 592 */                 if (!rs.next()) {
/* 593 */                   close();
/* 594 */                   return -1;
/*     */                 } 
/* 596 */                 this.current = rs.getCharacterStream(1);
/* 597 */                 this.current = new BufferedReader(this.current);
/*     */               } 
/* 599 */               int i = this.current.read();
/* 600 */               if (i >= 0) {
/* 601 */                 return i;
/*     */               }
/* 603 */               this.current = null; } 
/* 604 */           } catch (SQLException sQLException) {
/* 605 */             throw DbException.convertToIOException(sQLException);
/*     */           } 
/*     */         }
/*     */ 
/*     */         
/*     */         public void close() throws IOException {
/* 611 */           if (this.closed) {
/*     */             return;
/*     */           }
/* 614 */           this.closed = true;
/*     */           try {
/* 616 */             rs.close();
/* 617 */           } catch (SQLException sQLException) {
/* 618 */             throw DbException.convertToIOException(sQLException);
/*     */           } 
/*     */         }
/*     */         
/*     */         public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/* 623 */           if (param1Int2 == 0) {
/* 624 */             return 0;
/*     */           }
/* 626 */           int i = read();
/* 627 */           if (i == -1) {
/* 628 */             return -1;
/*     */           }
/* 630 */           param1ArrayOfchar[param1Int1] = (char)i;
/* 631 */           byte b = 1;
/* 632 */           for (; b < param1Int2; b++) {
/* 633 */             i = read();
/* 634 */             if (i == -1) {
/*     */               break;
/*     */             }
/* 637 */             param1ArrayOfchar[param1Int1 + b] = (char)i;
/*     */           } 
/* 639 */           return b;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   private static ResultSet getLobStream(Connection paramConnection, String paramString, int paramInt) throws SQLException {
/* 646 */     PreparedStatement preparedStatement = paramConnection.prepareStatement("SELECT " + paramString + " FROM SYSTEM_LOB_STREAM WHERE ID=? ORDER BY PART");
/*     */     
/* 648 */     preparedStatement.setInt(1, paramInt);
/* 649 */     return preparedStatement.executeQuery();
/*     */   }
/*     */   
/*     */   private void reset() {
/* 653 */     this.result = null;
/* 654 */     this.buffer = null;
/* 655 */     this.lineSeparatorString = SysProperties.LINE_SEPARATOR;
/* 656 */     this.lineSeparator = this.lineSeparatorString.getBytes(this.charset);
/*     */   }
/*     */   
/*     */   private boolean excludeSchema(Schema paramSchema) {
/* 660 */     if (this.schemaNames != null && !this.schemaNames.contains(paramSchema.getName())) {
/* 661 */       return true;
/*     */     }
/* 663 */     if (this.tables != null) {
/*     */       
/* 665 */       for (Table table : paramSchema.getAllTablesAndViews()) {
/* 666 */         if (this.tables.contains(table)) {
/* 667 */           return false;
/*     */         }
/*     */       } 
/* 670 */       return true;
/*     */     } 
/* 672 */     return false;
/*     */   }
/*     */   
/*     */   private boolean excludeTable(Table paramTable) {
/* 676 */     return (this.tables != null && !this.tables.contains(paramTable));
/*     */   }
/*     */   
/*     */   private void add(String paramString, boolean paramBoolean) throws IOException {
/* 680 */     if (paramString == null) {
/*     */       return;
/*     */     }
/* 683 */     if (this.lineSeparator.length > 1 || this.lineSeparator[0] != 10) {
/* 684 */       paramString = StringUtils.replaceAll(paramString, "\n", this.lineSeparatorString);
/*     */     }
/* 686 */     paramString = paramString + ";";
/* 687 */     if (this.out != null) {
/* 688 */       byte[] arrayOfByte = paramString.getBytes(this.charset);
/* 689 */       int i = MathUtils.roundUpInt(arrayOfByte.length + this.lineSeparator.length, 16);
/*     */       
/* 691 */       this.buffer = Utils.copy(arrayOfByte, this.buffer);
/*     */       
/* 693 */       if (i > this.buffer.length) {
/* 694 */         this.buffer = new byte[i];
/*     */       }
/* 696 */       System.arraycopy(arrayOfByte, 0, this.buffer, 0, arrayOfByte.length); int j;
/* 697 */       for (j = arrayOfByte.length; j < i - this.lineSeparator.length; j++)
/* 698 */         this.buffer[j] = 32; 
/*     */       int k;
/* 700 */       for (j = 0, k = i - this.lineSeparator.length; k < i; k++, j++) {
/* 701 */         this.buffer[k] = this.lineSeparator[j];
/*     */       }
/* 703 */       this.out.write(this.buffer, 0, i);
/* 704 */       if (!paramBoolean) {
/* 705 */         Value[] arrayOfValue = { ValueString.get(paramString) };
/* 706 */         this.result.addRow(arrayOfValue);
/*     */       } 
/*     */     } else {
/* 709 */       Value[] arrayOfValue = { ValueString.get(paramString) };
/* 710 */       this.result.addRow(arrayOfValue);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setSimple(boolean paramBoolean) {
/* 715 */     this.simple = paramBoolean;
/*     */   }
/*     */   
/*     */   public void setCharset(Charset paramCharset) {
/* 719 */     this.charset = paramCharset;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getType() {
/* 724 */     return 65;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\ScriptCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */