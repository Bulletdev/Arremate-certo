/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlPositiveInteger;
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
/*     */ public class JavaIntegerHolderEx
/*     */   extends JavaIntegerHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaIntegerHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  30 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaType schemaType() {
/*  36 */     return this._schemaType;
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*  40 */     BigInteger bigInteger = lex(paramString, _voorVc);
/*     */     
/*  42 */     if (_validateOnSet()) {
/*  43 */       validateValue(bigInteger, this._schemaType, _voorVc);
/*     */     }
/*  45 */     if (_validateOnSet()) {
/*  46 */       validateLexical(paramString, this._schemaType, _voorVc);
/*     */     }
/*  48 */     super.set_BigInteger(bigInteger);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_BigInteger(BigInteger paramBigInteger) {
/*  53 */     if (_validateOnSet()) {
/*  54 */       validateValue(paramBigInteger, this._schemaType, _voorVc);
/*     */     }
/*  56 */     super.set_BigInteger(paramBigInteger);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  61 */     JavaDecimalHolder.validateLexical(paramString, paramValidationContext);
/*  62 */     if (paramString.lastIndexOf('.') >= 0) {
/*  63 */       paramValidationContext.invalid("integer", new Object[] { paramString });
/*     */     }
/*     */ 
/*     */     
/*  67 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  69 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*  71 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "integer", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void validateValue(BigInteger paramBigInteger, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  80 */     XmlPositiveInteger xmlPositiveInteger = (XmlPositiveInteger)paramSchemaType.getFacet(7);
/*  81 */     if (xmlPositiveInteger != null) {
/*     */       
/*  83 */       String str = paramBigInteger.toString();
/*  84 */       int i = str.length();
/*  85 */       if (i > 0 && str.charAt(0) == '-')
/*  86 */         i--; 
/*  87 */       if (i > xmlPositiveInteger.getBigIntegerValue().intValue()) {
/*     */         
/*  89 */         paramValidationContext.invalid("cvc-totalDigits-valid", new Object[] { new Integer(i), str, new Integer(xmlPositiveInteger.getBigIntegerValue().intValue()), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/*  96 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(3);
/*  97 */     if (xmlAnySimpleType1 != null) {
/*     */       
/*  99 */       BigInteger bigInteger = getBigIntegerValue((XmlObject)xmlAnySimpleType1);
/* 100 */       if (paramBigInteger.compareTo(bigInteger) <= 0) {
/*     */         
/* 102 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "integer", paramBigInteger, bigInteger, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(4);
/* 110 */     if (xmlAnySimpleType2 != null) {
/*     */       
/* 112 */       BigInteger bigInteger = getBigIntegerValue((XmlObject)xmlAnySimpleType2);
/* 113 */       if (paramBigInteger.compareTo(bigInteger) < 0) {
/*     */         
/* 115 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "integer", paramBigInteger, bigInteger, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 122 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(5);
/* 123 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 125 */       BigInteger bigInteger = getBigIntegerValue((XmlObject)xmlAnySimpleType3);
/* 126 */       if (paramBigInteger.compareTo(bigInteger) > 0) {
/*     */         
/* 128 */         paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "integer", paramBigInteger, bigInteger, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 135 */     XmlAnySimpleType xmlAnySimpleType4 = paramSchemaType.getFacet(6);
/* 136 */     if (xmlAnySimpleType4 != null) {
/*     */       
/* 138 */       BigInteger bigInteger = getBigIntegerValue((XmlObject)xmlAnySimpleType4);
/* 139 */       if (paramBigInteger.compareTo(bigInteger) >= 0) {
/*     */         
/* 141 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "integer", paramBigInteger, bigInteger, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 148 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 149 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 151 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */         
/* 153 */         if (paramBigInteger.equals(getBigIntegerValue((XmlObject)arrayOfXmlAnySimpleType[b])))
/*     */           return; 
/*     */       } 
/* 156 */       paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "integer", paramBigInteger, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static BigInteger getBigIntegerValue(XmlObject paramXmlObject) {
/* 163 */     SchemaType schemaType = paramXmlObject.schemaType();
/* 164 */     switch (schemaType.getDecimalSize()) {
/*     */       
/*     */       case 1000001:
/* 167 */         return ((XmlObjectBase)paramXmlObject).bigDecimalValue().toBigInteger();
/*     */       case 1000000:
/* 169 */         return ((XmlObjectBase)paramXmlObject).bigIntegerValue();
/*     */     } 
/* 171 */     throw new IllegalStateException("Bad facet type for Big Int: " + schemaType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 177 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 178 */     validateValue(getBigIntegerValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaIntegerHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */