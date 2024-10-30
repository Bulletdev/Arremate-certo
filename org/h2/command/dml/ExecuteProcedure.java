/*    */ package org.h2.command.dml;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.command.Prepared;
/*    */ import org.h2.engine.Procedure;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.Expression;
/*    */ import org.h2.expression.Parameter;
/*    */ import org.h2.result.ResultInterface;
/*    */ import org.h2.util.New;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ExecuteProcedure
/*    */   extends Prepared
/*    */ {
/* 24 */   private final ArrayList<Expression> expressions = New.arrayList();
/*    */   private Procedure procedure;
/*    */   
/*    */   public ExecuteProcedure(Session paramSession) {
/* 28 */     super(paramSession);
/*    */   }
/*    */   
/*    */   public void setProcedure(Procedure paramProcedure) {
/* 32 */     this.procedure = paramProcedure;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setExpression(int paramInt, Expression paramExpression) {
/* 42 */     this.expressions.add(paramInt, paramExpression);
/*    */   }
/*    */   
/*    */   private void setParameters() {
/* 46 */     Prepared prepared = this.procedure.getPrepared();
/* 47 */     ArrayList<Parameter> arrayList = prepared.getParameters();
/* 48 */     for (byte b = 0; arrayList != null && b < arrayList.size() && b < this.expressions.size(); 
/* 49 */       b++) {
/* 50 */       Expression expression = this.expressions.get(b);
/* 51 */       Parameter parameter = arrayList.get(b);
/* 52 */       parameter.setValue(expression.getValue(this.session));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isQuery() {
/* 58 */     Prepared prepared = this.procedure.getPrepared();
/* 59 */     return prepared.isQuery();
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 64 */     setParameters();
/* 65 */     Prepared prepared = this.procedure.getPrepared();
/* 66 */     return prepared.update();
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface query(int paramInt) {
/* 71 */     setParameters();
/* 72 */     Prepared prepared = this.procedure.getPrepared();
/* 73 */     return prepared.query(paramInt);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isTransactional() {
/* 78 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public ResultInterface queryMeta() {
/* 83 */     Prepared prepared = this.procedure.getPrepared();
/* 84 */     return prepared.queryMeta();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 89 */     return 59;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\dml\ExecuteProcedure.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */