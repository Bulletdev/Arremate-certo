/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class JavaStringHolderEx
/*     */   extends JavaStringHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  30 */     return this._schemaType;
/*     */   }
/*     */   public JavaStringHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  33 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  37 */     return schemaType().getWhiteSpaceRule();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*  42 */     if (_validateOnSet()) {
/*  43 */       validateLexical(paramString, this._schemaType, _voorVc);
/*     */     }
/*  45 */     super.set_text(paramString);
/*     */   }
/*     */   
/*     */   protected boolean is_defaultable_ws(String paramString) {
/*     */     try {
/*  50 */       validateLexical(paramString, this._schemaType, _voorVc);
/*  51 */       return false;
/*     */     }
/*  53 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*  54 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  61 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/*     */       
/*  63 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "string", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*  68 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(0);
/*  69 */     if (xmlAnySimpleType1 != null) {
/*     */       
/*  71 */       int i = ((XmlObjectBase)xmlAnySimpleType1).bigIntegerValue().intValue();
/*  72 */       if (paramString.length() != i) {
/*     */         
/*  74 */         paramValidationContext.invalid("cvc-length-valid.1.1", new Object[] { "string", new Integer(paramString.length()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  81 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(1);
/*  82 */     if (xmlAnySimpleType2 != null) {
/*     */       
/*  84 */       int i = ((XmlObjectBase)xmlAnySimpleType2).bigIntegerValue().intValue();
/*  85 */       if (paramString.length() < i) {
/*     */         
/*  87 */         paramValidationContext.invalid("cvc-minLength-valid.1.1", new Object[] { "string", new Integer(paramString.length()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(2);
/*  95 */     if (xmlAnySimpleType3 != null) {
/*     */       
/*  97 */       int i = ((XmlObjectBase)xmlAnySimpleType3).bigIntegerValue().intValue();
/*  98 */       if (paramString.length() > i) {
/*     */         
/* 100 */         paramValidationContext.invalid("cvc-maxLength-valid.1.1", new Object[] { "string", new Integer(paramString.length()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 111 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 112 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 114 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */         
/* 116 */         if (paramString.equals(arrayOfXmlAnySimpleType[b].getStringValue()))
/*     */           return; 
/*     */       } 
/* 119 */       paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "string", paramString, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 126 */     validateLexical(stringValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaStringHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */