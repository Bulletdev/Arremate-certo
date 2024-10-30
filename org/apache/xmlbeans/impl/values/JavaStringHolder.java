/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlObject;
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
/*    */ public class JavaStringHolder
/*    */   extends XmlObjectBase
/*    */ {
/*    */   private String _value;
/*    */   
/*    */   public SchemaType schemaType() {
/* 28 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_STRING;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int get_wscanon_rule() {
/* 33 */     return 1;
/*    */   }
/*    */   
/* 36 */   public String compute_text(NamespaceManager paramNamespaceManager) { return this._value; }
/* 37 */   protected void set_text(String paramString) { this._value = paramString; } protected void set_nil() {
/* 38 */     this._value = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 45 */     return this._value.equals(((XmlObjectBase)paramXmlObject).stringValue());
/*    */   }
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 50 */     return this._value.hashCode();
/*    */   }
/*    */   
/*    */   protected boolean is_defaultable_ws(String paramString) {
/* 54 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaStringHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */