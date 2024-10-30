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
/*     */ public abstract class JavaBase64HolderEx
/*     */   extends JavaBase64Holder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  29 */     return this._schemaType;
/*     */   }
/*     */   public JavaBase64HolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  32 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  36 */     return schemaType().getWhiteSpaceRule();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     byte[] arrayOfByte;
/*  43 */     if (_validateOnSet()) {
/*  44 */       arrayOfByte = validateLexical(paramString, schemaType(), _voorVc);
/*     */     } else {
/*  46 */       arrayOfByte = lex(paramString, _voorVc);
/*     */     } 
/*  48 */     if (arrayOfByte != null && _validateOnSet()) {
/*  49 */       validateValue(arrayOfByte, schemaType(), XmlObjectBase._voorVc);
/*     */     }
/*  51 */     super.set_ByteArray(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/*  57 */     if (_validateOnSet()) {
/*  58 */       validateValue(paramArrayOfbyte, schemaType(), _voorVc);
/*     */     }
/*  60 */     super.set_ByteArray(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(byte[] paramArrayOfbyte, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*  68 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(0)) != null) {
/*     */       int i;
/*  70 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) != paramArrayOfbyte.length)
/*     */       {
/*  72 */         paramValidationContext.invalid("cvc-length-valid.1.2", new Object[] { "base64Binary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  77 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(1)) != null) {
/*     */       int i;
/*  79 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) > paramArrayOfbyte.length)
/*     */       {
/*  81 */         paramValidationContext.invalid("cvc-minLength-valid.1.2", new Object[] { "base64Binary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  86 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(2)) != null) {
/*     */       int i;
/*  88 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) < paramArrayOfbyte.length)
/*     */       {
/*  90 */         paramValidationContext.invalid("cvc-maxLength-valid.1.2", new Object[] { "base64Binary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  95 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*     */     
/*  97 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       byte b;
/*  99 */       label37: for (b = 0; b < arrayOfXmlAnySimpleType.length; ) {
/*     */         
/* 101 */         byte[] arrayOfByte = ((XmlObjectBase)arrayOfXmlAnySimpleType[b]).byteArrayValue();
/*     */         
/* 103 */         if (arrayOfByte.length != paramArrayOfbyte.length) {
/*     */           b++; continue;
/*     */         } 
/* 106 */         for (byte b1 = 0; b1 < arrayOfByte.length; b1++) {
/* 107 */           if (arrayOfByte[b1] != paramArrayOfbyte[b1]) {
/*     */             continue label37;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 113 */       if (b >= arrayOfXmlAnySimpleType.length) {
/* 114 */         paramValidationContext.invalid("cvc-enumeration-valid.b", new Object[] { "base64Binary", QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 121 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 122 */     validateValue(byteArrayValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaBase64HolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */