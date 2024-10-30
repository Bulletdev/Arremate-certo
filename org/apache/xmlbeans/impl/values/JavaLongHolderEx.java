/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
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
/*     */ public abstract class JavaLongHolderEx
/*     */   extends JavaLongHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaLongHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  28 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     long l;
/*     */     
/*  40 */     try { l = XsTypeConverter.lexLong(paramString); }
/*  41 */     catch (Exception exception) { throw new XmlValueOutOfRangeException(); }
/*     */     
/*  43 */     if (_validateOnSet()) {
/*     */       
/*  45 */       validateValue(l, this._schemaType, _voorVc);
/*  46 */       validateLexical(paramString, this._schemaType, _voorVc);
/*     */     } 
/*     */     
/*  49 */     super.set_long(l);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_long(long paramLong) {
/*  54 */     if (_validateOnSet()) {
/*  55 */       validateValue(paramLong, this._schemaType, _voorVc);
/*     */     }
/*  57 */     super.set_long(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  62 */     JavaDecimalHolder.validateLexical(paramString, paramValidationContext);
/*     */ 
/*     */     
/*  65 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  67 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*  69 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "long", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateValue(long paramLong, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  78 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(7);
/*  79 */     if (xmlAnySimpleType1 != null) {
/*     */       
/*  81 */       long l = getLongValue((XmlObject)xmlAnySimpleType1);
/*  82 */       String str = Long.toString(paramLong);
/*  83 */       int i = str.length();
/*  84 */       if (i > 0 && str.charAt(0) == '-')
/*  85 */         i--; 
/*  86 */       if (i > l) {
/*     */         
/*  88 */         paramValidationContext.invalid("cvc-totalDigits-valid", new Object[] { new Integer(i), str, new Long(l), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(3);
/*  96 */     if (xmlAnySimpleType2 != null) {
/*     */       
/*  98 */       long l = getLongValue((XmlObject)xmlAnySimpleType2);
/*  99 */       if (paramLong <= l) {
/*     */         
/* 101 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "long", new Long(paramLong), new Long(l), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(4);
/* 109 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 111 */       long l = getLongValue((XmlObject)xmlAnySimpleType3);
/* 112 */       if (paramLong < l) {
/*     */         
/* 114 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "long", new Long(paramLong), new Long(l), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     XmlAnySimpleType xmlAnySimpleType4 = paramSchemaType.getFacet(5);
/* 122 */     if (xmlAnySimpleType4 != null) {
/*     */       
/* 124 */       long l = getLongValue((XmlObject)xmlAnySimpleType4);
/* 125 */       if (paramLong > l) {
/*     */         
/* 127 */         paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "long", new Long(paramLong), new Long(l), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     XmlAnySimpleType xmlAnySimpleType5 = paramSchemaType.getFacet(6);
/* 135 */     if (xmlAnySimpleType5 != null) {
/*     */       
/* 137 */       long l = getLongValue((XmlObject)xmlAnySimpleType5);
/* 138 */       if (paramLong >= l) {
/*     */         
/* 140 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "long", new Long(paramLong), new Long(l), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 148 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 150 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */         
/* 152 */         if (paramLong == getLongValue((XmlObject)arrayOfXmlAnySimpleType[b]))
/*     */           return; 
/*     */       } 
/* 155 */       paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "long", new Long(paramLong), QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static long getLongValue(XmlObject paramXmlObject) {
/* 161 */     SchemaType schemaType = paramXmlObject.schemaType();
/* 162 */     switch (schemaType.getDecimalSize()) {
/*     */       
/*     */       case 1000001:
/* 165 */         return ((XmlObjectBase)paramXmlObject).getBigDecimalValue().longValue();
/*     */       case 1000000:
/* 167 */         return ((XmlObjectBase)paramXmlObject).getBigIntegerValue().longValue();
/*     */       case 64:
/* 169 */         return ((XmlObjectBase)paramXmlObject).getLongValue();
/*     */     } 
/* 171 */     throw new IllegalStateException("Bad facet type: " + schemaType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 178 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 179 */     validateValue(getLongValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaLongHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */