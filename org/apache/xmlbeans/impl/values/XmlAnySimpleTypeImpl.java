/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlAnySimpleType;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class XmlAnySimpleTypeImpl
/*    */   extends XmlObjectBase
/*    */   implements XmlAnySimpleType
/*    */ {
/*    */   private SchemaType _schemaType;
/*    */   String _textvalue;
/*    */   
/*    */   public XmlAnySimpleTypeImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/* 40 */     this._textvalue = ""; this._schemaType = paramSchemaType; initComplexType(paramBoolean, false); } public XmlAnySimpleTypeImpl() { this._textvalue = "";
/*    */     this._schemaType = (SchemaType)BuiltinSchemaTypeSystem.ST_ANY_SIMPLE; } public SchemaType schemaType() {
/*    */     return this._schemaType;
/*    */   } protected int get_wscanon_rule() {
/* 44 */     return 1;
/*    */   }
/*    */ 
/*    */   
/*    */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/* 49 */     return this._textvalue;
/*    */   }
/*    */   protected void set_text(String paramString) {
/* 52 */     this._textvalue = paramString;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void set_nil() {
/* 57 */     this._textvalue = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 65 */     return this._textvalue.equals(((XmlAnySimpleType)paramXmlObject).getStringValue());
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 71 */     return (this._textvalue == null) ? 0 : this._textvalue.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlAnySimpleTypeImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */