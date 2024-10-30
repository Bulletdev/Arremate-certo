/*     */ package org.apache.commons.collections4.sequence;
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
/*     */ public class ReplacementsFinder<T>
/*     */   implements CommandVisitor<T>
/*     */ {
/*     */   private final List<T> pendingInsertions;
/*     */   private final List<T> pendingDeletions;
/*     */   private int skipped;
/*     */   private final ReplacementsHandler<T> handler;
/*     */   
/*     */   public ReplacementsFinder(ReplacementsHandler<T> paramReplacementsHandler) {
/*  66 */     this.pendingInsertions = new ArrayList<T>();
/*  67 */     this.pendingDeletions = new ArrayList<T>();
/*  68 */     this.skipped = 0;
/*  69 */     this.handler = paramReplacementsHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitInsertCommand(T paramT) {
/*  78 */     this.pendingInsertions.add(paramT);
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
/*     */   public void visitKeepCommand(T paramT) {
/*  90 */     if (this.pendingDeletions.isEmpty() && this.pendingInsertions.isEmpty()) {
/*  91 */       this.skipped++;
/*     */     } else {
/*  93 */       this.handler.handleReplacement(this.skipped, this.pendingDeletions, this.pendingInsertions);
/*  94 */       this.pendingDeletions.clear();
/*  95 */       this.pendingInsertions.clear();
/*  96 */       this.skipped = 1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void visitDeleteCommand(T paramT) {
/* 106 */     this.pendingDeletions.add(paramT);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\collections4\sequence\ReplacementsFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */