/*     */ package org.h2.engine;
/*     */ 
/*     */ import java.sql.SQLException;
/*     */ import org.h2.api.DatabaseEventListener;
/*     */ import org.h2.command.Prepared;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueInt;
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
/*     */ public class MetaRecord
/*     */   implements Comparable<MetaRecord>
/*     */ {
/*     */   private final int id;
/*     */   private final int objectType;
/*     */   private final String sql;
/*     */   
/*     */   public MetaRecord(SearchRow paramSearchRow) {
/*  28 */     this.id = paramSearchRow.getValue(0).getInt();
/*  29 */     this.objectType = paramSearchRow.getValue(2).getInt();
/*  30 */     this.sql = paramSearchRow.getValue(3).getString();
/*     */   }
/*     */   
/*     */   MetaRecord(DbObject paramDbObject) {
/*  34 */     this.id = paramDbObject.getId();
/*  35 */     this.objectType = paramDbObject.getType();
/*  36 */     this.sql = paramDbObject.getCreateSQL();
/*     */   }
/*     */   
/*     */   void setRecord(SearchRow paramSearchRow) {
/*  40 */     paramSearchRow.setValue(0, (Value)ValueInt.get(this.id));
/*  41 */     paramSearchRow.setValue(1, (Value)ValueInt.get(0));
/*  42 */     paramSearchRow.setValue(2, (Value)ValueInt.get(this.objectType));
/*  43 */     paramSearchRow.setValue(3, ValueString.get(this.sql));
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
/*     */   void execute(Database paramDatabase, Session paramSession, DatabaseEventListener paramDatabaseEventListener) {
/*     */     try {
/*  56 */       Prepared prepared = paramSession.prepare(this.sql);
/*  57 */       prepared.setObjectId(this.id);
/*  58 */       prepared.update();
/*  59 */     } catch (DbException dbException) {
/*  60 */       dbException = dbException.addSQL(this.sql);
/*  61 */       SQLException sQLException = dbException.getSQLException();
/*  62 */       paramDatabase.getTrace(2).error(sQLException, this.sql);
/*  63 */       if (paramDatabaseEventListener != null) {
/*  64 */         paramDatabaseEventListener.exceptionThrown(sQLException, this.sql);
/*     */       } else {
/*     */         
/*  67 */         throw dbException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public int getId() {
/*  73 */     return this.id;
/*     */   }
/*     */   
/*     */   public int getObjectType() {
/*  77 */     return this.objectType;
/*     */   }
/*     */   
/*     */   public String getSQL() {
/*  81 */     return this.sql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int compareTo(MetaRecord paramMetaRecord) {
/*  92 */     int i = getCreateOrder();
/*  93 */     int j = paramMetaRecord.getCreateOrder();
/*  94 */     if (i != j) {
/*  95 */       return i - j;
/*     */     }
/*  97 */     return getId() - paramMetaRecord.getId();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int getCreateOrder() {
/* 107 */     switch (this.objectType) {
/*     */       case 6:
/* 109 */         return 0;
/*     */       case 2:
/* 111 */         return 1;
/*     */       case 10:
/* 113 */         return 2;
/*     */       case 9:
/* 115 */         return 3;
/*     */       case 12:
/* 117 */         return 4;
/*     */       case 3:
/* 119 */         return 5;
/*     */       case 11:
/* 121 */         return 6;
/*     */       case 0:
/* 123 */         return 7;
/*     */       case 1:
/* 125 */         return 8;
/*     */       case 5:
/* 127 */         return 9;
/*     */       case 4:
/* 129 */         return 10;
/*     */       case 7:
/* 131 */         return 11;
/*     */       case 8:
/* 133 */         return 12;
/*     */       case 14:
/* 135 */         return 13;
/*     */       case 13:
/* 137 */         return 14;
/*     */     } 
/* 139 */     throw DbException.throwInternalError("type=" + this.objectType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 145 */     return "MetaRecord [id=" + this.id + ", objectType=" + this.objectType + ", sql=" + this.sql + "]";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\engine\MetaRecord.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */