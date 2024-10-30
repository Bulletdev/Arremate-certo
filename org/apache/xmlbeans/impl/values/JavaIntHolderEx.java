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
/*     */ public abstract class JavaIntHolderEx
/*     */   extends JavaIntHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaIntHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
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
/*     */     int i;
/*     */     
/*  40 */     try { i = XsTypeConverter.lexInt(paramString); }
/*  41 */     catch (Exception exception) { throw new XmlValueOutOfRangeException(); }
/*     */     
/*  43 */     if (_validateOnSet()) {
/*     */       
/*  45 */       validateValue(i, this._schemaType, _voorVc);
/*  46 */       validateLexical(paramString, this._schemaType, _voorVc);
/*     */     } 
/*     */     
/*  49 */     super.set_int(i);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_int(int paramInt) {
/*  54 */     if (_validateOnSet()) {
/*  55 */       validateValue(paramInt, this._schemaType, _voorVc);
/*     */     }
/*  57 */     super.set_int(paramInt);
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
/*  69 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "int", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateValue(int paramInt, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  78 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(7);
/*  79 */     if (xmlAnySimpleType1 != null) {
/*     */       
/*  81 */       String str = Integer.toString(paramInt);
/*  82 */       int i = str.length();
/*  83 */       if (i > 0 && str.charAt(0) == '-')
/*  84 */         i--; 
/*  85 */       int j = getIntValue((XmlObject)xmlAnySimpleType1);
/*  86 */       if (i > j) {
/*     */         
/*  88 */         paramValidationContext.invalid("cvc-totalDigits-valid", new Object[] { new Integer(i), str, new Integer(getIntValue((XmlObject)xmlAnySimpleType1)), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(3);
/*  96 */     if (xmlAnySimpleType2 != null) {
/*     */       
/*  98 */       int i = getIntValue((XmlObject)xmlAnySimpleType2);
/*  99 */       if (paramInt <= i) {
/*     */         
/* 101 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "int", new Integer(paramInt), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(4);
/* 109 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 111 */       int i = getIntValue((XmlObject)xmlAnySimpleType3);
/* 112 */       if (paramInt < i) {
/*     */         
/* 114 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "int", new Integer(paramInt), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     XmlAnySimpleType xmlAnySimpleType4 = paramSchemaType.getFacet(5);
/* 122 */     if (xmlAnySimpleType4 != null) {
/*     */       
/* 124 */       int i = getIntValue((XmlObject)xmlAnySimpleType4);
/* 125 */       if (paramInt > i) {
/*     */         
/* 127 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "int", new Integer(paramInt), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     XmlAnySimpleType xmlAnySimpleType5 = paramSchemaType.getFacet(6);
/* 135 */     if (xmlAnySimpleType5 != null) {
/*     */       
/* 137 */       int i = getIntValue((XmlObject)xmlAnySimpleType5);
/* 138 */       if (paramInt >= i) {
/*     */         
/* 140 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "int", new Integer(paramInt), new Integer(i), QNameHelper.readable(paramSchemaType) });
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
/* 152 */         if (paramInt == getIntValue((XmlObject)arrayOfXmlAnySimpleType[b]))
/*     */           return; 
/*     */       } 
/* 155 */       paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "int", new Integer(paramInt), QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int getIntValue(XmlObject paramXmlObject) {
/* 161 */     SchemaType schemaType = paramXmlObject.schemaType();
/* 162 */     switch (schemaType.getDecimalSize()) {
/*     */       
/*     */       case 1000001:
/* 165 */         return ((XmlObjectBase)paramXmlObject).getBigDecimalValue().intValue();
/*     */       case 1000000:
/* 167 */         return ((XmlObjectBase)paramXmlObject).getBigIntegerValue().intValue();
/*     */       case 64:
/* 169 */         return (int)((XmlObjectBase)paramXmlObject).getLongValue();
/*     */     } 
/* 171 */     return ((XmlObjectBase)paramXmlObject).getIntValue();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 178 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 179 */     validateValue(getIntValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaIntHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */