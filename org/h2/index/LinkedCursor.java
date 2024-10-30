/*    */ package org.h2.index;
/*    */ 
/*    */ import java.sql.PreparedStatement;
/*    */ import java.sql.ResultSet;
/*    */ import java.sql.SQLException;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.engine.SessionInterface;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ import org.h2.table.Column;
/*    */ import org.h2.table.TableLink;
/*    */ import org.h2.value.DataType;
/*    */ import org.h2.value.Value;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LinkedCursor
/*    */   implements Cursor
/*    */ {
/*    */   private final TableLink tableLink;
/*    */   private final PreparedStatement prep;
/*    */   private final String sql;
/*    */   private final Session session;
/*    */   private final ResultSet rs;
/*    */   private Row current;
/*    */   
/*    */   LinkedCursor(TableLink paramTableLink, ResultSet paramResultSet, Session paramSession, String paramString, PreparedStatement paramPreparedStatement) {
/* 35 */     this.session = paramSession;
/* 36 */     this.tableLink = paramTableLink;
/* 37 */     this.rs = paramResultSet;
/* 38 */     this.sql = paramString;
/* 39 */     this.prep = paramPreparedStatement;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 44 */     return this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 49 */     return (SearchRow)this.current;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/*    */     try {
/* 55 */       boolean bool = this.rs.next();
/* 56 */       if (!bool) {
/* 57 */         this.rs.close();
/* 58 */         this.tableLink.reusePreparedStatement(this.prep, this.sql);
/* 59 */         this.current = null;
/* 60 */         return false;
/*    */       } 
/* 62 */     } catch (SQLException sQLException) {
/* 63 */       throw DbException.convert(sQLException);
/*    */     } 
/* 65 */     this.current = this.tableLink.getTemplateRow();
/* 66 */     for (byte b = 0; b < this.current.getColumnCount(); b++) {
/* 67 */       Column column = this.tableLink.getColumn(b);
/* 68 */       Value value = DataType.readValue((SessionInterface)this.session, this.rs, b + 1, column.getType());
/* 69 */       this.current.setValue(b, value);
/*    */     } 
/* 71 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 76 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\LinkedCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */