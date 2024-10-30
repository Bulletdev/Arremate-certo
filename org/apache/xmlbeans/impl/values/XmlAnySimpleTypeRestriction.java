/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
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
/*    */ public class XmlAnySimpleTypeRestriction
/*    */   extends XmlAnySimpleTypeImpl
/*    */ {
/*    */   private SchemaType _schemaType;
/*    */   
/*    */   public XmlAnySimpleTypeRestriction(SchemaType paramSchemaType, boolean paramBoolean) {
/* 23 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public SchemaType schemaType() {
/* 28 */     return this._schemaType;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlAnySimpleTypeRestriction.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */