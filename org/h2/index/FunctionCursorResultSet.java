/*    */ package org.h2.index;
/*    */ 
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.ResultSetMetaData;
/*    */ import java.sql.SQLException;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.SessionInterface;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.value.DataType;
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FunctionCursorResultSet
/*    */   implements Cursor
/*    */ {
/*    */   private final Session session;
/*    */   private final ResultSet result;
/*    */   private final ResultSetMetaData meta;
/*    */   private Value[] values;
/*    */   private Row row;
/*    */   
/*    */   FunctionCursorResultSet(Session paramSession, ResultSet paramResultSet) {
/* 30 */     this.session = paramSession;
/* 31 */     this.result = paramResultSet;
/*    */     try {
/* 33 */       this.meta = paramResultSet.getMetaData();
/* 34 */     } catch (SQLException sQLException) {
/* 35 */       throw DbException.convert(sQLException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 41 */     if (this.values == null) {
/* 42 */       return null;
/*    */     }
/* 44 */     if (this.row == null) {
/* 45 */       this.row = this.session.createRow(this.values, 1);
/*    */     }
/* 47 */     return this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 52 */     return (SearchRow)get();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 57 */     this.row = null;
/*    */     try {
/* 59 */       if (this.result != null && this.result.next()) {
/* 60 */         int i = this.meta.getColumnCount();
/* 61 */         this.values = new Value[i];
/* 62 */         for (byte b = 0; b < i; b++) {
/* 63 */           int j = DataType.getValueTypeFromResultSet(this.meta, b + 1);
/* 64 */           this.values[b] = DataType.readValue((SessionInterface)this.session, this.result, b + 1, j);
/*    */         } 
/*    */       } else {
/* 67 */         this.values = null;
/*    */       } 
/* 69 */     } catch (SQLException sQLException) {
/* 70 */       throw DbException.convert(sQLException);
/*    */     } 
/* 72 */     return (this.values != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 77 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\FunctionCursorResultSet.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */