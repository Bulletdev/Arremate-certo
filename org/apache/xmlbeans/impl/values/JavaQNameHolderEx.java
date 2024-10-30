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
/*     */ public abstract class JavaQNameHolderEx
/*     */   extends JavaQNameHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  34 */     return this._schemaType;
/*     */   }
/*     */   public JavaQNameHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  37 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  41 */     return schemaType().getWhiteSpaceRule();
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     b b;
/*  46 */     PrefixResolver prefixResolver = NamespaceContext.getCurrent();
/*     */     
/*  48 */     if (prefixResolver == null && has_store()) {
/*  49 */       prefixResolver = get_store();
/*     */     }
/*     */     
/*  52 */     if (_validateOnSet()) {
/*     */       
/*  54 */       b = validateLexical(paramString, this._schemaType, _voorVc, prefixResolver);
/*  55 */       if (b != null) {
/*  56 */         validateValue(b, this._schemaType, _voorVc);
/*     */       }
/*     */     } else {
/*  59 */       b = JavaQNameHolder.validateLexical(paramString, _voorVc, prefixResolver);
/*     */     } 
/*  61 */     super.set_QName(b);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_QName(b paramb) {
/*  66 */     if (_validateOnSet())
/*  67 */       validateValue(paramb, this._schemaType, _voorVc); 
/*  68 */     super.set_QName(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_xmlanysimple(XmlAnySimpleType paramXmlAnySimpleType) {
/*     */     b b;
/*  74 */     if (_validateOnSet()) {
/*     */       
/*  76 */       b = validateLexical(paramXmlAnySimpleType.getStringValue(), this._schemaType, _voorVc, NamespaceContext.getCurrent());
/*     */       
/*  78 */       if (b != null) {
/*  79 */         validateValue(b, this._schemaType, _voorVc);
/*     */       }
/*     */     } else {
/*  82 */       b = JavaQNameHolder.validateLexical(paramXmlAnySimpleType.getStringValue(), _voorVc, NamespaceContext.getCurrent());
/*     */     } 
/*  84 */     super.set_QName(b);
/*     */   }
/*     */ 
/*     */   
/*     */   public static b validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext, PrefixResolver paramPrefixResolver) {
/*  89 */     b b = JavaQNameHolder.validateLexical(paramString, paramValidationContext, paramPrefixResolver);
/*     */ 
/*     */     
/*  92 */     if (paramSchemaType.hasPatternFacet())
/*     */     {
/*  94 */       if (!paramSchemaType.matchPatternFacet(paramString))
/*     */       {
/*     */         
/*  97 */         paramValidationContext.invalid("cvc-datatype-valid.1.1", new Object[] { "QName", paramString, QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     }
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
/*     */ 
/*     */ 
/*     */     
/* 122 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateValue(b paramb, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 127 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 128 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 130 */       for (byte b1 = 0; b1 < arrayOfXmlAnySimpleType.length; b1++) {
/* 131 */         if (paramb.equals(((XmlObjectBase)arrayOfXmlAnySimpleType[b1]).getQNameValue()))
/*     */           return; 
/* 133 */       }  paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "QName", paramb, QNameHelper.readable(paramSchemaType) });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 140 */     validateValue(getQNameValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaQNameHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */