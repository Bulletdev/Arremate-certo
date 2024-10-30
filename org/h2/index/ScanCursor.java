/*    */ package org.h2.index;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.message.DbException;
/*    */ import org.h2.result.Row;
/*    */ import org.h2.result.SearchRow;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ScanCursor
/*    */   implements Cursor
/*    */ {
/*    */   private final ScanIndex scan;
/*    */   private Row row;
/*    */   private final Session session;
/*    */   private final boolean multiVersion;
/*    */   private Iterator<Row> delta;
/*    */   
/*    */   ScanCursor(Session paramSession, ScanIndex paramScanIndex, boolean paramBoolean) {
/* 25 */     this.session = paramSession;
/* 26 */     this.scan = paramScanIndex;
/* 27 */     this.multiVersion = paramBoolean;
/* 28 */     if (paramBoolean) {
/* 29 */       this.delta = paramScanIndex.getDelta();
/*    */     }
/* 31 */     this.row = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public Row get() {
/* 36 */     return this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public SearchRow getSearchRow() {
/* 41 */     return (SearchRow)this.row;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean next() {
/* 46 */     if (this.multiVersion) {
/*    */       label26: while (true) {
/* 48 */         while (this.delta != null) {
/* 49 */           if (!this.delta.hasNext()) {
/* 50 */             this.delta = null;
/* 51 */             this.row = null;
/*    */             continue;
/*    */           } 
/* 54 */           this.row = this.delta.next();
/* 55 */           if (!this.row.isDeleted() || this.row.getSessionId() == this.session.getId())
/*    */             continue; 
/*    */           break label26;
/*    */         } 
/* 59 */         this.row = this.scan.getNextRow(this.row);
/* 60 */         if (this.row != null && this.row.getSessionId() != 0 && this.row.getSessionId() != this.session.getId()) {
/*    */           continue;
/*    */         }
/*    */         
/*    */         break;
/*    */       } 
/*    */       
/* 67 */       return (this.row != null);
/*    */     } 
/* 69 */     this.row = this.scan.getNextRow(this.row);
/* 70 */     return (this.row != null);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean previous() {
/* 75 */     throw DbException.throwInternalError();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\ScanCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */