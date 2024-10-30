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
/*     */ public abstract class JavaFloatHolderEx
/*     */   extends JavaFloatHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaFloatHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  29 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   
/*     */   protected void set_float(float paramFloat) {
/*  38 */     if (_validateOnSet())
/*  39 */       validateValue(paramFloat, this._schemaType, _voorVc); 
/*  40 */     super.set_float(paramFloat);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  45 */     float f = JavaFloatHolder.validateLexical(paramString, paramValidationContext);
/*     */     
/*  47 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/*  48 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "float", paramString, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/*  51 */     return f;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(float paramFloat, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*  59 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(3)) != null) {
/*     */       float f;
/*  61 */       if (compare(paramFloat, f = ((XmlObjectBase)xmlAnySimpleType).floatValue()) <= 0)
/*     */       {
/*  63 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "float", new Float(paramFloat), new Float(f), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  68 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(4)) != null) {
/*     */       float f;
/*  70 */       if (compare(paramFloat, f = ((XmlObjectBase)xmlAnySimpleType).floatValue()) < 0)
/*     */       {
/*  72 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "float", new Float(paramFloat), new Float(f), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  77 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(5)) != null) {
/*     */       float f;
/*  79 */       if (compare(paramFloat, f = ((XmlObjectBase)xmlAnySimpleType).floatValue()) > 0)
/*     */       {
/*  81 */         paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "float", new Float(paramFloat), new Float(f), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  86 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(6)) != null) {
/*     */       float f;
/*  88 */       if (compare(paramFloat, f = ((XmlObjectBase)xmlAnySimpleType).floatValue()) >= 0)
/*     */       {
/*  90 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "float", new Float(paramFloat), new Float(f), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  95 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*  96 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/*  98 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*  99 */         if (compare(paramFloat, ((XmlObjectBase)arrayOfXmlAnySimpleType[b]).floatValue()) == 0)
/*     */           return; 
/* 101 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "float", new Float(paramFloat), QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 108 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 109 */     validateValue(floatValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaFloatHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */