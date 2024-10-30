/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Session;
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
/*    */ public class DeallocateProcedure
/*    */   extends DefineCommand
/*    */ {
/*    */   private String procedureName;
/*    */   
/*    */   public DeallocateProcedure(Session paramSession) {
/* 20 */     super(paramSession);
/*    */   }
/*    */ 
/*    */   
/*    */   public int update() {
/* 25 */     this.session.removeProcedure(this.procedureName);
/* 26 */     return 0;
/*    */   }
/*    */   
/*    */   public void setProcedureName(String paramString) {
/* 30 */     this.procedureName = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getType() {
/* 35 */     return 35;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\DeallocateProcedure.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */