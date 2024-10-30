/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
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
/*     */ public class JavaUriHolderEx
/*     */   extends JavaUriHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  30 */     return this._schemaType;
/*     */   }
/*     */   public JavaUriHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
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
/*     */       
/*  44 */       if (!check(paramString, this._schemaType)) {
/*  45 */         throw new XmlValueOutOfRangeException();
/*     */       }
/*  47 */       if (!this._schemaType.matchPatternFacet(paramString)) {
/*  48 */         throw new XmlValueOutOfRangeException();
/*     */       }
/*     */     } 
/*  51 */     super.set_text(paramString);
/*     */   }
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
/*     */   public static void validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  65 */     XmlAnyUriImpl.validateLexical(paramString, paramValidationContext);
/*     */     
/*  67 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*     */     
/*  69 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       byte b;
/*     */ 
/*     */       
/*  73 */       for (b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */         
/*  75 */         String str = ((SimpleValue)arrayOfXmlAnySimpleType[b]).getStringValue();
/*     */         
/*  77 */         if (str.equals(paramString)) {
/*     */           break;
/*     */         }
/*     */       } 
/*  81 */       if (b >= arrayOfXmlAnySimpleType.length) {
/*  82 */         paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "anyURI", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  87 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  89 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*     */         
/*  92 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "anyURI", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */     
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*     */     
/*     */     int i;
/*     */     
/* 100 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(0)) != null && (
/* 101 */       i = ((SimpleValue)xmlAnySimpleType).getBigIntegerValue().intValue()) != paramString.length()) {
/* 102 */       paramValidationContext.invalid("cvc-length-valid.1.1", new Object[] { "anyURI", paramString, new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 105 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(1)) != null && (
/* 106 */       i = ((SimpleValue)xmlAnySimpleType).getBigIntegerValue().intValue()) > paramString.length()) {
/* 107 */       paramValidationContext.invalid("cvc-minLength-valid.1.1", new Object[] { "anyURI", paramString, new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 110 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(2)) != null && (
/* 111 */       i = ((SimpleValue)xmlAnySimpleType).getBigIntegerValue().intValue()) < paramString.length()) {
/* 112 */       paramValidationContext.invalid("cvc-maxLength-valid.1.1", new Object[] { "anyURI", paramString, new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean check(String paramString, SchemaType paramSchemaType) {
/* 118 */     int i = (paramString == null) ? 0 : paramString.length();
/*     */     
/* 120 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(0);
/* 121 */     if (xmlAnySimpleType1 != null) {
/*     */       
/* 123 */       int j = ((SimpleValue)xmlAnySimpleType1).getBigIntegerValue().intValue();
/* 124 */       if (i == j) {
/* 125 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 129 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(1);
/* 130 */     if (xmlAnySimpleType2 != null) {
/*     */       
/* 132 */       int j = ((SimpleValue)xmlAnySimpleType2).getBigIntegerValue().intValue();
/* 133 */       if (i < j) {
/* 134 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 138 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(2);
/* 139 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 141 */       int j = ((SimpleValue)xmlAnySimpleType3).getBigIntegerValue().intValue();
/* 142 */       if (i > j) {
/* 143 */         return false;
/*     */       }
/*     */     } 
/* 146 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 151 */     validateLexical(stringValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaUriHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */