/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.math.BigDecimal;
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
/*     */ 
/*     */ public abstract class JavaDecimalHolderEx
/*     */   extends JavaDecimalHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  32 */     return this._schemaType;
/*     */   }
/*     */   public JavaDecimalHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  35 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*  39 */     if (_validateOnSet()) {
/*  40 */       validateLexical(paramString, this._schemaType, _voorVc);
/*     */     }
/*  42 */     BigDecimal bigDecimal = null;
/*     */     try {
/*  44 */       bigDecimal = new BigDecimal(paramString);
/*     */     }
/*  46 */     catch (NumberFormatException numberFormatException) {
/*     */       
/*  48 */       _voorVc.invalid("decimal", new Object[] { paramString });
/*     */     } 
/*     */     
/*  51 */     if (_validateOnSet()) {
/*  52 */       validateValue(bigDecimal, this._schemaType, _voorVc);
/*     */     }
/*  54 */     super.set_BigDecimal(bigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/*  59 */     if (_validateOnSet())
/*  60 */       validateValue(paramBigDecimal, this._schemaType, _voorVc); 
/*  61 */     super.set_BigDecimal(paramBigDecimal);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  66 */     JavaDecimalHolder.validateLexical(paramString, paramValidationContext);
/*     */ 
/*     */     
/*  69 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  71 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*     */         
/*  74 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "decimal", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(BigDecimal paramBigDecimal, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  87 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(8);
/*  88 */     if (xmlAnySimpleType1 != null) {
/*     */       
/*  90 */       int i = ((XmlObjectBase)xmlAnySimpleType1).getBigIntegerValue().intValue();
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/*  95 */         paramBigDecimal.setScale(i);
/*     */       }
/*  97 */       catch (ArithmeticException arithmeticException) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 102 */         paramValidationContext.invalid("cvc-fractionDigits-valid", new Object[] { new Integer(paramBigDecimal.scale()), paramBigDecimal.toString(), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(7);
/* 110 */     if (xmlAnySimpleType2 != null) {
/*     */       
/* 112 */       String str = paramBigDecimal.unscaledValue().toString();
/* 113 */       int i = ((XmlObjectBase)xmlAnySimpleType2).getBigIntegerValue().intValue();
/* 114 */       int j = str.length();
/* 115 */       int k = j;
/* 116 */       if (j > 0) {
/*     */ 
/*     */         
/* 119 */         if (str.charAt(0) == '-')
/*     */         {
/* 121 */           k--;
/*     */         }
/*     */ 
/*     */         
/* 125 */         byte b = 0;
/* 126 */         int m = paramBigDecimal.scale();
/* 127 */         int n = j - 1;
/* 128 */         for (; str.charAt(n) == '0' && n > 0 && b < m; 
/* 129 */           n--)
/*     */         {
/* 131 */           b++;
/*     */         }
/*     */         
/* 134 */         k -= b;
/*     */       } 
/*     */       
/* 137 */       if (k > i) {
/*     */         
/* 139 */         paramValidationContext.invalid("cvc-totalDigits-valid", new Object[] { new Integer(k), paramBigDecimal.toString(), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 146 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(3);
/* 147 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 149 */       BigDecimal bigDecimal = ((XmlObjectBase)xmlAnySimpleType3).getBigDecimalValue();
/* 150 */       if (paramBigDecimal.compareTo(bigDecimal) <= 0) {
/*     */         
/* 152 */         paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "decimal", paramBigDecimal, bigDecimal, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     XmlAnySimpleType xmlAnySimpleType4 = paramSchemaType.getFacet(4);
/* 160 */     if (xmlAnySimpleType4 != null) {
/*     */       
/* 162 */       BigDecimal bigDecimal = ((XmlObjectBase)xmlAnySimpleType4).getBigDecimalValue();
/* 163 */       if (paramBigDecimal.compareTo(bigDecimal) < 0) {
/*     */         
/* 165 */         paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "decimal", paramBigDecimal, bigDecimal, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 172 */     XmlAnySimpleType xmlAnySimpleType5 = paramSchemaType.getFacet(5);
/* 173 */     if (xmlAnySimpleType5 != null) {
/*     */       
/* 175 */       BigDecimal bigDecimal = ((XmlObjectBase)xmlAnySimpleType5).getBigDecimalValue();
/* 176 */       if (paramBigDecimal.compareTo(bigDecimal) > 0) {
/*     */         
/* 178 */         paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "decimal", paramBigDecimal, bigDecimal, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 185 */     XmlAnySimpleType xmlAnySimpleType6 = paramSchemaType.getFacet(6);
/* 186 */     if (xmlAnySimpleType6 != null) {
/*     */       
/* 188 */       BigDecimal bigDecimal = ((XmlObjectBase)xmlAnySimpleType6).getBigDecimalValue();
/* 189 */       if (paramBigDecimal.compareTo(bigDecimal) >= 0) {
/*     */         
/* 191 */         paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "decimal", paramBigDecimal, bigDecimal, QNameHelper.readable(paramSchemaType) });
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 198 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 199 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 201 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/* 202 */         if (paramBigDecimal.equals(((XmlObjectBase)arrayOfXmlAnySimpleType[b]).getBigDecimalValue()))
/*     */           return; 
/* 204 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "decimal", paramBigDecimal, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 211 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 212 */     validateValue(getBigDecimalValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaDecimalHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */