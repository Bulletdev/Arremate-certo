/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.XmlBoolean;
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
/*    */ public abstract class JavaBooleanHolder
/*    */   extends XmlObjectBase
/*    */ {
/*    */   private boolean _value;
/*    */   
/*    */   public SchemaType schemaType() {
/* 28 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_BOOLEAN;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/* 35 */     return this._value ? "true" : "false";
/*    */   }
/*    */   protected void set_text(String paramString) {
/* 38 */     this._value = validateLexical(paramString, _voorVc);
/*    */   }
/*    */   
/*    */   public static boolean validateLexical(String paramString, ValidationContext paramValidationContext) {
/* 42 */     if (paramString.equals("true") || paramString.equals("1")) {
/* 43 */       return true;
/*    */     }
/* 45 */     if (paramString.equals("false") || paramString.equals("0")) {
/* 46 */       return false;
/*    */     }
/* 48 */     paramValidationContext.invalid("boolean", new Object[] { paramString });
/*    */     
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   protected void set_nil() {
/* 54 */     this._value = false;
/*    */   }
/*    */   public boolean getBooleanValue() {
/* 57 */     check_dated(); return this._value;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void set_boolean(boolean paramBoolean) {
/* 62 */     this._value = paramBoolean;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int compare_to(XmlObject paramXmlObject) {
/* 69 */     return (this._value == ((XmlBoolean)paramXmlObject).getBooleanValue()) ? 0 : 2;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 74 */     return (this._value == ((XmlBoolean)paramXmlObject).getBooleanValue());
/*    */   }
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 79 */     return this._value ? 957379554 : 676335975;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaBooleanHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */