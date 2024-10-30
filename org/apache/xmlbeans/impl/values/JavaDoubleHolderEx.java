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
/*     */ public abstract class JavaDoubleHolderEx
/*     */   extends JavaDoubleHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaDoubleHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  29 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   
/*     */   protected void set_double(double paramDouble) {
/*  38 */     if (_validateOnSet())
/*  39 */       validateValue(paramDouble, this._schemaType, _voorVc); 
/*  40 */     super.set_double(paramDouble);
/*     */   }
/*     */ 
/*     */   
/*     */   public static double validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  45 */     double d = JavaDoubleHolder.validateLexical(paramString, paramValidationContext);
/*     */     
/*  47 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/*  48 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "double", paramString, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/*  51 */     return d;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(double paramDouble, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*  59 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(3)) != null) {
/*     */       double d;
/*  61 */       if (compare(paramDouble, d = ((XmlObjectBase)xmlAnySimpleType).doubleValue()) <= 0)
/*     */       {
/*  63 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "double", new Double(paramDouble), new Double(d), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  68 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(4)) != null) {
/*     */       double d;
/*  70 */       if (compare(paramDouble, d = ((XmlObjectBase)xmlAnySimpleType).doubleValue()) < 0)
/*     */       {
/*  72 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "double", new Double(paramDouble), new Double(d), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  77 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(5)) != null) {
/*     */       double d;
/*  79 */       if (compare(paramDouble, d = ((XmlObjectBase)xmlAnySimpleType).doubleValue()) > 0)
/*     */       {
/*  81 */         paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "double", new Double(paramDouble), new Double(d), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  86 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(6)) != null) {
/*     */       double d;
/*  88 */       if (compare(paramDouble, d = ((XmlObjectBase)xmlAnySimpleType).doubleValue()) >= 0)
/*     */       {
/*  90 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "double", new Double(paramDouble), new Double(d), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  95 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*  96 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/*  98 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*  99 */         if (compare(paramDouble, ((XmlObjectBase)arrayOfXmlAnySimpleType[b]).doubleValue()) == 0)
/*     */           return; 
/* 101 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "double", new Double(paramDouble), QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 108 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 109 */     validateValue(doubleValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaDoubleHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */