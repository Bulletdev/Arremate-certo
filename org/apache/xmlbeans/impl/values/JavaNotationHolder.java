/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
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
/*    */ public abstract class JavaNotationHolder
/*    */   extends XmlQNameImpl
/*    */ {
/*    */   public SchemaType schemaType() {
/* 25 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_NOTATION;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaNotationHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */