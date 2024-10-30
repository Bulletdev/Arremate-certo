/*    */ package org.h2.schema;
/*    */ 
/*    */ import org.h2.engine.DbObjectBase;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class SchemaObjectBase
/*    */   extends DbObjectBase
/*    */   implements SchemaObject
/*    */ {
/*    */   private Schema schema;
/*    */   
/*    */   protected void initSchemaObjectBase(Schema paramSchema, int paramInt1, String paramString, int paramInt2) {
/* 28 */     initDbObjectBase(paramSchema.getDatabase(), paramInt1, paramString, paramInt2);
/* 29 */     this.schema = paramSchema;
/*    */   }
/*    */ 
/*    */   
/*    */   public Schema getSchema() {
/* 34 */     return this.schema;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSQL() {
/* 39 */     return this.schema.getSQL() + "." + super.getSQL();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isHidden() {
/* 44 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\schema\SchemaObjectBase.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */