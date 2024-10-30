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
/*     */ public class EditScript<T>
/*     */ {
/*  61 */   private final List<EditCommand<T>> commands = new ArrayList<>();
/*  62 */   private int lcsLength = 0;
/*  63 */   private int modifications = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(KeepCommand<T> paramKeepCommand) {
/*  72 */     this.commands.add(paramKeepCommand);
/*  73 */     this.lcsLength++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(InsertCommand<T> paramInsertCommand) {
/*  82 */     this.commands.add(paramInsertCommand);
/*  83 */     this.modifications++;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void append(DeleteCommand<T> paramDeleteCommand) {
/*  92 */     this.commands.add(paramDeleteCommand);
/*  93 */     this.modifications++;
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
/*     */   public void visit(CommandVisitor<T> paramCommandVisitor) {
/* 106 */     for (EditCommand<T> editCommand : this.commands) {
/* 107 */       editCommand.accept(paramCommandVisitor);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLCSLength() {
/* 119 */     return this.lcsLength;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getModifications() {
/* 130 */     return this.modifications;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\text\diff\EditScript.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */