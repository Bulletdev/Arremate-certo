/*     */ package org.h2.index;
/*     */ 
/*     */ import java.util.Iterator;
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ class PageDataCursor
/*     */   implements Cursor
/*     */ {
/*     */   private PageDataLeaf current;
/*     */   private int idx;
/*     */   private final long maxKey;
/*     */   private Row row;
/*     */   private final boolean multiVersion;
/*     */   private final Session session;
/*     */   private Iterator<Row> delta;
/*     */   
/*     */   PageDataCursor(Session paramSession, PageDataLeaf paramPageDataLeaf, int paramInt, long paramLong, boolean paramBoolean) {
/*  29 */     this.current = paramPageDataLeaf;
/*  30 */     this.idx = paramInt;
/*  31 */     this.maxKey = paramLong;
/*  32 */     this.multiVersion = paramBoolean;
/*  33 */     this.session = paramSession;
/*  34 */     if (paramBoolean) {
/*  35 */       this.delta = paramPageDataLeaf.index.getDelta();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Row get() {
/*  41 */     return this.row;
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchRow getSearchRow() {
/*  46 */     return (SearchRow)get();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/*  51 */     if (!this.multiVersion) {
/*  52 */       nextRow();
/*  53 */       return checkMax();
/*     */     } 
/*     */     label19: while (true) {
/*  56 */       while (this.delta != null) {
/*  57 */         if (!this.delta.hasNext()) {
/*  58 */           this.delta = null;
/*  59 */           this.row = null;
/*     */           continue;
/*     */         } 
/*  62 */         this.row = this.delta.next();
/*  63 */         if (!this.row.isDeleted() || this.row.getSessionId() == this.session.getId())
/*     */           continue; 
/*     */         break label19;
/*     */       } 
/*  67 */       nextRow();
/*  68 */       if (this.row != null && this.row.getSessionId() != 0 && this.row.getSessionId() != this.session.getId()) {
/*     */         continue;
/*     */       }
/*     */       
/*     */       break;
/*     */     } 
/*     */     
/*  75 */     return checkMax();
/*     */   }
/*     */   
/*     */   private boolean checkMax() {
/*  79 */     if (this.row != null) {
/*  80 */       if (this.maxKey != Long.MAX_VALUE) {
/*  81 */         long l = this.current.index.getKey((SearchRow)this.row, Long.MAX_VALUE, Long.MAX_VALUE);
/*  82 */         if (l > this.maxKey) {
/*  83 */           this.row = null;
/*  84 */           return false;
/*     */         } 
/*     */       } 
/*  87 */       return true;
/*     */     } 
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   private void nextRow() {
/*  93 */     if (this.idx >= this.current.getEntryCount()) {
/*  94 */       this.current = this.current.getNextPage();
/*  95 */       this.idx = 0;
/*  96 */       if (this.current == null) {
/*  97 */         this.row = null;
/*     */         return;
/*     */       } 
/*     */     } 
/* 101 */     this.row = this.current.getRowAt(this.idx);
/* 102 */     this.idx++;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean previous() {
/* 107 */     throw DbException.throwInternalError();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\PageDataCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */