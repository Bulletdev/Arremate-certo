/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*    */ import org.apache.xmlbeans.impl.common.ValidationContext;
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
/*    */ public abstract class JavaBooleanHolderEx
/*    */   extends JavaBooleanHolder
/*    */ {
/*    */   private SchemaType _schemaType;
/*    */   
/*    */   public SchemaType schemaType() {
/* 30 */     return this._schemaType;
/*    */   }
/*    */   
/*    */   public static boolean validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 34 */     boolean bool = JavaBooleanHolder.validateLexical(paramString, paramValidationContext);
/* 35 */     validatePattern(paramString, paramSchemaType, paramValidationContext);
/* 36 */     return bool;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static void validatePattern(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 42 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/* 43 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "boolean", paramString, QNameHelper.readable(paramSchemaType) });
/*    */     }
/*    */   }
/*    */   
/*    */   public JavaBooleanHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/* 48 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*    */   }
/*    */   
/*    */   protected void set_text(String paramString) {
/* 52 */     if (_validateOnSet())
/* 53 */       validatePattern(paramString, this._schemaType, _voorVc); 
/* 54 */     super.set_text(paramString);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 59 */     validateLexical(paramString, schemaType(), paramValidationContext);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaBooleanHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */