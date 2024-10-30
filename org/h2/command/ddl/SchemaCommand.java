/*    */ package org.h2.command.ddl;
/*    */ 
/*    */ import org.h2.engine.Session;
/*    */ import org.h2.schema.Schema;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SchemaCommand
/*    */   extends DefineCommand
/*    */ {
/*    */   private final Schema schema;
/*    */   
/*    */   public SchemaCommand(Session paramSession, Schema paramSchema) {
/* 25 */     super(paramSession);
/* 26 */     this.schema = paramSchema;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected Schema getSchema() {
/* 35 */     return this.schema;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\command\ddl\SchemaCommand.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */