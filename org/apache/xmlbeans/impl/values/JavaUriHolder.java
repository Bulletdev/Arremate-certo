/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlAnyURI;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.common.ValidationContext;
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
/*    */ public abstract class JavaUriHolder
/*    */   extends XmlObjectBase
/*    */ {
/*    */   private String _value;
/*    */   
/*    */   public SchemaType schemaType() {
/* 31 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_ANY_URI;
/*    */   }
/*    */   
/*    */   public String compute_text(NamespaceManager paramNamespaceManager) {
/* 35 */     return (this._value == null) ? "" : this._value;
/*    */   }
/*    */   protected void set_text(String paramString) {
/* 38 */     if (_validateOnSet())
/* 39 */       validateLexical(paramString, _voorVc); 
/* 40 */     this._value = paramString;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void validateLexical(String paramString, ValidationContext paramValidationContext) {
/* 47 */     if (paramString.startsWith("##"))
/* 48 */       paramValidationContext.invalid("anyURI", new Object[] { paramString }); 
/*    */   }
/*    */   
/*    */   protected void set_nil() {
/* 52 */     this._value = null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 59 */     return this._value.equals(((XmlAnyURI)paramXmlObject).getStringValue());
/*    */   }
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 64 */     return this._value.hashCode();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaUriHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */