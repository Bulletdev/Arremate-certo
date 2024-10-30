/*     */ package org.apache.commons.text.diff;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
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
/*     */ public class ReplacementsFinder<T>
/*     */   implements CommandVisitor<T>
/*     */ {
/*     */   private final List<T> pendingInsertions;
/*     */   private final List<T> pendingDeletions;
/*     */   private int skipped;
/*     */   private final ReplacementsHandler<T> handler;
/*     */   
/*     */   public ReplacementsFinder(ReplacementsHandler<T> paramReplacementsHandler) {
/*  79 */     this.pendingInsertions = new ArrayList<>();
/*  80 */     this.pendingDeletions = new ArrayList<>();
/*  81 */     this.skipped = 0;
/*  82 */     this.handler = paramReplacementsHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitInsertCommand(T paramT) {
/*  92 */     this.pendingInsertions.add(paramT);
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
/*     */   public void visitKeepCommand(T paramT) {
/* 106 */     if (this.pendingDeletions.isEmpty() && this.pendingInsertions.isEmpty()) {
/* 107 */       this.skipped++;
/*     */     } else {
/* 109 */       this.handler.handleReplacement(this.skipped, this.pendingDeletions, this.pendingInsertions);
/* 110 */       this.pendingDeletions.clear();
/* 111 */       this.pendingInsertions.clear();
/* 112 */       this.skipped = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitDeleteCommand(T paramT) {
/* 123 */     this.pendingDeletions.add(paramT);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\ReplacementsFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */