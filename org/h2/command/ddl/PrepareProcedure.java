/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import org.h2.command.Prepared;
/*    */ import org.h2.engine.Procedure;
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.expression.Parameter;
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
/*    */ public class PrepareProcedure
/*    */   extends DefineCommand
/*    */ {
/*    */   private String procedureName;
/*    */   private Prepared prepared;
/*    */   
/*    */   public PrepareProcedure(Session paramSession) {
/* 26 */     super(paramSession);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void checkParameters() {}
/*    */ 
/*    */ 
/*    */   
/*    */   public int update() {
/* 36 */     Procedure procedure = new Procedure(this.procedureName, this.prepared);
/* 37 */     this.prepared.setParameterList(this.parameters);
/* 38 */     this.prepared.setPrepareAlways(this.prepareAlways);
/* 39 */     this.prepared.prepare();
/* 40 */     this.session.addProcedure(procedure);
/* 41 */     return 0;
/*    */   }
/*    */   
/*    */   public void setProcedureName(String paramString) {
/* 45 */     this.procedureName = paramString;
/*    */   }
/*    */   
/*    */   public void setPrepared(Prepared paramPrepared) {
/* 49 */     this.prepared = paramPrepared;
/*    */   }
/*    */ 
/*    */   
/*    */   public ArrayList<Parameter> getParameters() {
/* 54 */     return New.arrayList();
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 59 */     return 51;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\PrepareProcedure.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */