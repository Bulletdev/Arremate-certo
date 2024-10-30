/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.StringEnumAbstractBase;
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
/*    */ public abstract class JavaStringEnumerationHolderEx
/*    */   extends JavaStringHolderEx
/*    */ {
/*    */   private StringEnumAbstractBase _val;
/*    */   
/*    */   public JavaStringEnumerationHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/* 29 */     super(paramSchemaType, paramBoolean);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected void set_text(String paramString) {
/* 37 */     StringEnumAbstractBase stringEnumAbstractBase = schemaType().enumForString(paramString);
/* 38 */     if (stringEnumAbstractBase == null) {
/* 39 */       throw new XmlValueOutOfRangeException("cvc-enumeration-valid", new Object[] { "string", paramString, QNameHelper.readable(schemaType()) });
/*    */     }
/*    */     
/* 42 */     super.set_text(paramString);
/* 43 */     this._val = stringEnumAbstractBase;
/*    */   }
/*    */ 
/*    */   
/*    */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 48 */     JavaStringHolderEx.validateLexical(paramString, paramSchemaType, paramValidationContext);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void set_nil() {
/* 53 */     this._val = null;
/* 54 */     super.set_nil();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public StringEnumAbstractBase getEnumValue() {
/* 60 */     check_dated();
/* 61 */     return this._val;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void set_enum(StringEnumAbstractBase paramStringEnumAbstractBase) {
/* 66 */     Class clazz = schemaType().getEnumJavaClass();
/* 67 */     if (clazz != null && !paramStringEnumAbstractBase.getClass().equals(clazz)) {
/* 68 */       throw new XmlValueOutOfRangeException();
/*    */     }
/* 70 */     super.set_text(paramStringEnumAbstractBase.toString());
/* 71 */     this._val = paramStringEnumAbstractBase;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaStringEnumerationHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */