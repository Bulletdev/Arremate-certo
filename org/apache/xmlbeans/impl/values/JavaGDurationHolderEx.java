/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import org.apache.xmlbeans.GDuration;
/*     */ import org.apache.xmlbeans.GDurationSpecification;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
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
/*     */ public abstract class JavaGDurationHolderEx
/*     */   extends XmlObjectBase
/*     */ {
/*     */   GDuration _value;
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public JavaGDurationHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  29 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     GDuration gDuration;
/*  39 */     if (_validateOnSet()) {
/*  40 */       gDuration = validateLexical(paramString, this._schemaType, _voorVc);
/*     */     } else {
/*  42 */       gDuration = lex(paramString, _voorVc);
/*     */     } 
/*  44 */     if (_validateOnSet() && gDuration != null) {
/*  45 */       validateValue((GDurationSpecification)gDuration, this._schemaType, _voorVc);
/*     */     }
/*  47 */     this._value = gDuration;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_GDuration(GDurationSpecification paramGDurationSpecification) {
/*  52 */     if (_validateOnSet()) {
/*  53 */       validateValue(paramGDurationSpecification, this._schemaType, _voorVc);
/*     */     }
/*  55 */     if (paramGDurationSpecification.isImmutable() && paramGDurationSpecification instanceof GDuration) {
/*  56 */       this._value = (GDuration)paramGDurationSpecification;
/*     */     } else {
/*  58 */       this._value = new GDuration(paramGDurationSpecification);
/*     */     } 
/*     */   }
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  62 */     return (this._value == null) ? "" : this._value.toString();
/*     */   }
/*     */   
/*     */   protected void set_nil() {
/*  66 */     this._value = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public GDuration getGDurationValue() {
/*  71 */     check_dated();
/*     */     
/*  73 */     return (this._value == null) ? null : this._value;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GDuration lex(String paramString, ValidationContext paramValidationContext) {
/*  78 */     GDuration gDuration = null;
/*     */ 
/*     */     
/*     */     try {
/*  82 */       gDuration = new GDuration(paramString);
/*     */     }
/*  84 */     catch (Exception exception) {
/*     */       
/*  86 */       paramValidationContext.invalid("duration", new Object[] { paramString });
/*     */     } 
/*     */     
/*  89 */     return gDuration;
/*     */   }
/*     */ 
/*     */   
/*     */   public static GDuration validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  94 */     GDuration gDuration = lex(paramString, paramValidationContext);
/*     */     
/*  96 */     if (gDuration != null && paramSchemaType.hasPatternFacet() && 
/*  97 */       !paramSchemaType.matchPatternFacet(paramString)) {
/*  98 */       paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "duration", paramString, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 101 */     return gDuration;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(GDurationSpecification paramGDurationSpecification, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*     */     GDuration gDuration;
/* 109 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(3)) != null && 
/* 110 */       paramGDurationSpecification.compareToGDuration((GDurationSpecification)(gDuration = ((XmlObjectBase)xmlAnySimpleType).gDurationValue())) <= 0) {
/* 111 */       paramValidationContext.invalid("cvc-minExclusive-valid", new Object[] { "duration", paramGDurationSpecification, gDuration, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 114 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(4)) != null && 
/* 115 */       paramGDurationSpecification.compareToGDuration((GDurationSpecification)(gDuration = ((XmlObjectBase)xmlAnySimpleType).gDurationValue())) < 0) {
/* 116 */       paramValidationContext.invalid("cvc-minInclusive-valid", new Object[] { "duration", paramGDurationSpecification, gDuration, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 119 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(6)) != null && 
/* 120 */       paramGDurationSpecification.compareToGDuration((GDurationSpecification)(gDuration = ((XmlObjectBase)xmlAnySimpleType).gDurationValue())) >= 0) {
/* 121 */       paramValidationContext.invalid("cvc-maxExclusive-valid", new Object[] { "duration", paramGDurationSpecification, gDuration, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 124 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(5)) != null && 
/* 125 */       paramGDurationSpecification.compareToGDuration((GDurationSpecification)(gDuration = ((XmlObjectBase)xmlAnySimpleType).gDurationValue())) > 0) {
/* 126 */       paramValidationContext.invalid("cvc-maxInclusive-valid", new Object[] { "duration", paramGDurationSpecification, gDuration, QNameHelper.readable(paramSchemaType) });
/*     */     }
/*     */     
/* 129 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 130 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 132 */       for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/* 133 */         if (paramGDurationSpecification.compareToGDuration((GDurationSpecification)((XmlObjectBase)arrayOfXmlAnySimpleType[b]).gDurationValue()) == 0)
/*     */           return; 
/* 135 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "duration", paramGDurationSpecification, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/* 142 */     return this._value.compareToGDuration((GDurationSpecification)((XmlObjectBase)paramXmlObject).gDurationValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 147 */     return this._value.equals(((XmlObjectBase)paramXmlObject).gDurationValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 152 */     return this._value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 157 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 158 */     validateValue((GDurationSpecification)gDurationValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaGDurationHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */