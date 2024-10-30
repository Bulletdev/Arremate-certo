/*     */ package org.h2.command;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import org.h2.command.dml.Explain;
/*     */ import org.h2.command.dml.Query;
/*     */ import org.h2.expression.Parameter;
/*     */ import org.h2.expression.ParameterInterface;
/*     */ import org.h2.result.ResultInterface;
/*     */ import org.h2.value.Value;
/*     */ import org.h2.value.ValueNull;
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
/*     */ public class CommandContainer
/*     */   extends Command
/*     */ {
/*     */   private Prepared prepared;
/*     */   private boolean readOnlyKnown;
/*     */   private boolean readOnly;
/*     */   
/*     */   CommandContainer(Parser paramParser, String paramString, Prepared paramPrepared) {
/*  29 */     super(paramParser, paramString);
/*  30 */     paramPrepared.setCommand(this);
/*  31 */     this.prepared = paramPrepared;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArrayList<? extends ParameterInterface> getParameters() {
/*  36 */     return (ArrayList)this.prepared.getParameters();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isTransactional() {
/*  41 */     return this.prepared.isTransactional();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isQuery() {
/*  46 */     return this.prepared.isQuery();
/*     */   }
/*     */ 
/*     */   
/*     */   public void prepareJoinBatch() {
/*  51 */     if (this.session.isJoinBatchEnabled()) {
/*  52 */       prepareJoinBatch(this.prepared);
/*     */     }
/*     */   }
/*     */   
/*     */   private static void prepareJoinBatch(Prepared paramPrepared) {
/*  57 */     if (paramPrepared.isQuery()) {
/*  58 */       if (paramPrepared.getType() == 66) {
/*  59 */         ((Query)paramPrepared).prepareJoinBatch();
/*  60 */       } else if (paramPrepared.getType() == 60) {
/*  61 */         prepareJoinBatch(((Explain)paramPrepared).getCommand());
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   private void recompileIfRequired() {
/*  67 */     if (this.prepared.needRecompile()) {
/*     */       
/*  69 */       this.prepared.setModificationMetaId(0L);
/*  70 */       String str = this.prepared.getSQL();
/*  71 */       ArrayList<Parameter> arrayList1 = this.prepared.getParameters();
/*  72 */       Parser parser = new Parser(this.session);
/*  73 */       this.prepared = parser.parse(str);
/*  74 */       long l = this.prepared.getModificationMetaId();
/*  75 */       this.prepared.setModificationMetaId(0L);
/*  76 */       ArrayList<Parameter> arrayList2 = this.prepared.getParameters(); byte b; int i;
/*  77 */       for (b = 0, i = arrayList2.size(); b < i; b++) {
/*  78 */         Parameter parameter = arrayList1.get(b);
/*  79 */         if (parameter.isValueSet()) {
/*  80 */           Value value = parameter.getValue(this.session);
/*  81 */           Parameter parameter1 = arrayList2.get(b);
/*  82 */           parameter1.setValue(value);
/*     */         } 
/*     */       } 
/*  85 */       this.prepared.prepare();
/*  86 */       this.prepared.setModificationMetaId(l);
/*  87 */       prepareJoinBatch();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int update() {
/*  93 */     recompileIfRequired();
/*  94 */     setProgress(5);
/*  95 */     start();
/*  96 */     this.session.setLastScopeIdentity((Value)ValueNull.INSTANCE);
/*  97 */     this.prepared.checkParameters();
/*  98 */     int i = this.prepared.update();
/*  99 */     this.prepared.trace(this.startTimeNanos, i);
/* 100 */     setProgress(6);
/* 101 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface query(int paramInt) {
/* 106 */     recompileIfRequired();
/* 107 */     setProgress(5);
/* 108 */     start();
/* 109 */     this.prepared.checkParameters();
/* 110 */     ResultInterface resultInterface = this.prepared.query(paramInt);
/* 111 */     this.prepared.trace(this.startTimeNanos, resultInterface.getRowCount());
/* 112 */     setProgress(6);
/* 113 */     return resultInterface;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() {
/* 118 */     if (!this.readOnlyKnown) {
/* 119 */       this.readOnly = this.prepared.isReadOnly();
/* 120 */       this.readOnlyKnown = true;
/*     */     } 
/* 122 */     return this.readOnly;
/*     */   }
/*     */ 
/*     */   
/*     */   public ResultInterface queryMeta() {
/* 127 */     return this.prepared.queryMeta();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCacheable() {
/* 132 */     return this.prepared.isCacheable();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCommandType() {
/* 137 */     return this.prepared.getType();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\CommandContainer.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */