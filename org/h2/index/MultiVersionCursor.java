/*     */ package org.h2.index;
/*     */ 
/*     */ import org.h2.engine.Session;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.message.DbException;
/*     */ import org.h2.result.Row;
/*     */ import org.h2.result.SearchRow;
/*     */ import org.h2.util.MathUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MultiVersionCursor
/*     */   implements Cursor
/*     */ {
/*     */   private final MultiVersionIndex index;
/*     */   private final Session session;
/*     */   private final Cursor baseCursor;
/*     */   private final Cursor deltaCursor;
/*     */   private final Object sync;
/*     */   private SearchRow baseRow;
/*     */   private Row deltaRow;
/*     */   private boolean onBase;
/*     */   private boolean end;
/*     */   private boolean needNewDelta;
/*     */   private boolean needNewBase;
/*     */   private boolean reverse;
/*     */   
/*     */   MultiVersionCursor(Session paramSession, MultiVersionIndex paramMultiVersionIndex, Cursor paramCursor1, Cursor paramCursor2, Object paramObject) {
/*  33 */     this.session = paramSession;
/*  34 */     this.index = paramMultiVersionIndex;
/*  35 */     this.baseCursor = paramCursor1;
/*  36 */     this.deltaCursor = paramCursor2;
/*  37 */     this.sync = paramObject;
/*  38 */     this.needNewDelta = true;
/*  39 */     this.needNewBase = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void loadCurrent() {
/*  46 */     synchronized (this.sync) {
/*  47 */       this.baseRow = this.baseCursor.getSearchRow();
/*  48 */       this.deltaRow = this.deltaCursor.get();
/*  49 */       this.needNewDelta = false;
/*  50 */       this.needNewBase = false;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void loadNext(boolean paramBoolean) {
/*  55 */     synchronized (this.sync) {
/*  56 */       if (paramBoolean) {
/*  57 */         if (step(this.baseCursor)) {
/*  58 */           this.baseRow = this.baseCursor.getSearchRow();
/*     */         } else {
/*  60 */           this.baseRow = null;
/*     */         }
/*     */       
/*  63 */       } else if (step(this.deltaCursor)) {
/*  64 */         this.deltaRow = this.deltaCursor.get();
/*     */       } else {
/*  66 */         this.deltaRow = null;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean step(Cursor paramCursor) {
/*  73 */     return this.reverse ? paramCursor.previous() : paramCursor.next();
/*     */   }
/*     */ 
/*     */   
/*     */   public Row get() {
/*  78 */     synchronized (this.sync) {
/*  79 */       if (this.end) {
/*  80 */         return null;
/*     */       }
/*  82 */       return this.onBase ? this.baseCursor.get() : this.deltaCursor.get();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public SearchRow getSearchRow() {
/*  88 */     synchronized (this.sync) {
/*  89 */       if (this.end) {
/*  90 */         return null;
/*     */       }
/*  92 */       return this.onBase ? this.baseCursor.getSearchRow() : this.deltaCursor.getSearchRow();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean next() {
/*  98 */     synchronized (this.sync) {
/*  99 */       int i; if (SysProperties.CHECK && this.end) {
/* 100 */         DbException.throwInternalError();
/*     */       }
/*     */       while (true) {
/* 103 */         if (this.needNewDelta) {
/* 104 */           loadNext(false);
/* 105 */           this.needNewDelta = false;
/*     */         } 
/* 107 */         if (this.needNewBase) {
/* 108 */           loadNext(true);
/* 109 */           this.needNewBase = false;
/*     */         } 
/* 111 */         if (this.deltaRow == null) {
/* 112 */           if (this.baseRow == null) {
/* 113 */             this.end = true;
/* 114 */             return false;
/*     */           } 
/* 116 */           this.onBase = true;
/* 117 */           this.needNewBase = true;
/* 118 */           return true;
/*     */         } 
/* 120 */         int j = this.deltaRow.getSessionId();
/* 121 */         boolean bool = (j == this.session.getId()) ? true : false;
/* 122 */         boolean bool1 = this.deltaRow.isDeleted();
/* 123 */         if (bool && bool1) {
/* 124 */           this.needNewDelta = true;
/*     */           continue;
/*     */         } 
/* 127 */         if (this.baseRow == null) {
/* 128 */           if (bool1) {
/* 129 */             if (bool) {
/* 130 */               this.end = true;
/* 131 */               return false;
/*     */             } 
/*     */             
/* 134 */             this.onBase = false;
/* 135 */             this.needNewDelta = true;
/* 136 */             return true;
/*     */           } 
/* 138 */           DbException.throwInternalError();
/*     */         } 
/* 140 */         i = this.index.compareRows((SearchRow)this.deltaRow, this.baseRow);
/* 141 */         if (i == 0) {
/*     */ 
/*     */           
/* 144 */           long l1 = this.deltaRow.getKey();
/* 145 */           long l2 = this.baseRow.getKey();
/* 146 */           i = MathUtils.compareLong(l1, l2);
/*     */         } 
/* 148 */         if (i == 0) {
/* 149 */           if (bool1) {
/* 150 */             if (bool) {
/* 151 */               DbException.throwInternalError();
/*     */             }
/*     */             break;
/*     */           } 
/* 155 */           if (bool) {
/* 156 */             this.onBase = false;
/* 157 */             this.needNewBase = true;
/* 158 */             this.needNewDelta = true;
/* 159 */             return true;
/*     */           } 
/*     */           
/* 162 */           this.needNewBase = true;
/* 163 */           this.needNewDelta = true; continue;
/*     */         } 
/*     */         break;
/*     */       } 
/* 167 */       if (i > 0) {
/* 168 */         this.onBase = true;
/* 169 */         this.needNewBase = true;
/* 170 */         return true;
/*     */       } 
/* 172 */       this.onBase = false;
/* 173 */       this.needNewDelta = true;
/* 174 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean previous() {
/* 181 */     this.reverse = true;
/*     */     try {
/* 183 */       return next();
/*     */     } finally {
/* 185 */       this.reverse = false;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\index\MultiVersionCursor.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */