/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
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
/*     */ 
/*     */ public abstract class JavaNotationHolderEx
/*     */   extends JavaNotationHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   public JavaNotationHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  37 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  41 */     return schemaType().getWhiteSpaceRule();
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*  46 */     if (_validateOnSet()) {
/*     */       
/*  48 */       if (!check(paramString, this._schemaType)) {
/*  49 */         throw new XmlValueOutOfRangeException();
/*     */       }
/*  51 */       if (!this._schemaType.matchPatternFacet(paramString)) {
/*  52 */         throw new XmlValueOutOfRangeException();
/*     */       }
/*     */     } 
/*  55 */     super.set_text(paramString);
/*     */   }
/*     */   
/*     */   protected void set_notation(String paramString) {
/*  59 */     set_text(paramString);
/*     */   }
/*     */   
/*     */   protected void set_xmlanysimple(XmlAnySimpleType paramXmlAnySimpleType) {
/*     */     b b;
/*  64 */     if (_validateOnSet()) {
/*     */       
/*  66 */       b = validateLexical(paramXmlAnySimpleType.getStringValue(), this._schemaType, _voorVc, NamespaceContext.getCurrent());
/*     */       
/*  68 */       if (b != null) {
/*  69 */         validateValue(b, this._schemaType, _voorVc);
/*     */       }
/*     */     } else {
/*  72 */       b = JavaNotationHolder.validateLexical(paramXmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
/*     */     } 
/*  74 */     set_QName(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public static b validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext, PrefixResolver paramPrefixResolver) {
/*  79 */     b b = JavaQNameHolder.validateLexical(paramString, paramValidationContext, paramPrefixResolver);
/*     */ 
/*     */     
/*  82 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  84 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*     */         
/*  87 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "NOTATION", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*  92 */     check(paramString, paramSchemaType);
/*     */     
/*  94 */     return b;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean check(String paramString, SchemaType paramSchemaType) {
/* 100 */     XmlAnySimpleType xmlAnySimpleType1 = paramSchemaType.getFacet(0);
/* 101 */     if (xmlAnySimpleType1 != null) {
/*     */       
/* 103 */       int i = ((XmlObjectBase)xmlAnySimpleType1).getBigIntegerValue().intValue();
/* 104 */       if (paramString.length() == i) {
/* 105 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 109 */     XmlAnySimpleType xmlAnySimpleType2 = paramSchemaType.getFacet(1);
/* 110 */     if (xmlAnySimpleType2 != null) {
/*     */       
/* 112 */       int i = ((XmlObjectBase)xmlAnySimpleType2).getBigIntegerValue().intValue();
/* 113 */       if (paramString.length() < i) {
/* 114 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 118 */     XmlAnySimpleType xmlAnySimpleType3 = paramSchemaType.getFacet(2);
/* 119 */     if (xmlAnySimpleType3 != null) {
/*     */       
/* 121 */       int i = ((XmlObjectBase)xmlAnySimpleType3).getBigIntegerValue().intValue();
/* 122 */       if (paramString.length() > i) {
/* 123 */         return false;
/*     */       }
/*     */     } 
/* 126 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateValue(b paramb, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 131 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 132 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 134 */       for (byte b1 = 0; b1 < arrayOfXmlAnySimpleType.length; b1++) {
/* 135 */         if (paramb.equals(((XmlObjectBase)arrayOfXmlAnySimpleType[b1]).getQNameValue()))
/*     */           return; 
/* 137 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "NOTATION", paramb, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaNotationHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */