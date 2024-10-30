/*     */ package org.h2.result;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.h2.value.Transfer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ResultColumn
/*     */ {
/*     */   final String alias;
/*     */   final String schemaName;
/*     */   final String tableName;
/*     */   final String columnName;
/*     */   final int columnType;
/*     */   final long precision;
/*     */   final int scale;
/*     */   final int displaySize;
/*     */   final boolean autoIncrement;
/*     */   final int nullable;
/*     */   
/*     */   ResultColumn(Transfer paramTransfer) throws IOException {
/*  73 */     this.alias = paramTransfer.readString();
/*  74 */     this.schemaName = paramTransfer.readString();
/*  75 */     this.tableName = paramTransfer.readString();
/*  76 */     this.columnName = paramTransfer.readString();
/*  77 */     this.columnType = paramTransfer.readInt();
/*  78 */     this.precision = paramTransfer.readLong();
/*  79 */     this.scale = paramTransfer.readInt();
/*  80 */     this.displaySize = paramTransfer.readInt();
/*  81 */     this.autoIncrement = paramTransfer.readBoolean();
/*  82 */     this.nullable = paramTransfer.readInt();
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
/*     */   public static void writeColumn(Transfer paramTransfer, ResultInterface paramResultInterface, int paramInt) throws IOException {
/*  94 */     paramTransfer.writeString(paramResultInterface.getAlias(paramInt));
/*  95 */     paramTransfer.writeString(paramResultInterface.getSchemaName(paramInt));
/*  96 */     paramTransfer.writeString(paramResultInterface.getTableName(paramInt));
/*  97 */     paramTransfer.writeString(paramResultInterface.getColumnName(paramInt));
/*  98 */     paramTransfer.writeInt(paramResultInterface.getColumnType(paramInt));
/*  99 */     paramTransfer.writeLong(paramResultInterface.getColumnPrecision(paramInt));
/* 100 */     paramTransfer.writeInt(paramResultInterface.getColumnScale(paramInt));
/* 101 */     paramTransfer.writeInt(paramResultInterface.getDisplaySize(paramInt));
/* 102 */     paramTransfer.writeBoolean(paramResultInterface.isAutoIncrement(paramInt));
/* 103 */     paramTransfer.writeInt(paramResultInterface.getNullable(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\result\ResultColumn.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */