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
/*     */ 
/*     */ 
/*     */ public abstract class JavaHexBinaryHolderEx
/*     */   extends JavaHexBinaryHolder
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   
/*     */   public SchemaType schemaType() {
/*  31 */     return this._schemaType;
/*     */   }
/*     */   public JavaHexBinaryHolderEx(SchemaType paramSchemaType, boolean paramBoolean) {
/*  34 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   
/*     */   protected int get_wscanon_rule() {
/*  38 */     return schemaType().getWhiteSpaceRule();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*     */     byte[] arrayOfByte;
/*  45 */     if (_validateOnSet()) {
/*  46 */       arrayOfByte = validateLexical(paramString, schemaType(), _voorVc);
/*     */     } else {
/*  48 */       arrayOfByte = lex(paramString, _voorVc);
/*     */     } 
/*  50 */     if (_validateOnSet() && arrayOfByte != null) {
/*  51 */       validateValue(arrayOfByte, schemaType(), XmlObjectBase._voorVc);
/*     */     }
/*  53 */     super.set_ByteArray(arrayOfByte);
/*     */     
/*  55 */     this._value = arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/*  61 */     if (_validateOnSet()) {
/*  62 */       validateValue(paramArrayOfbyte, schemaType(), _voorVc);
/*     */     }
/*  64 */     super.set_ByteArray(paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void validateValue(byte[] paramArrayOfbyte, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*     */     XmlAnySimpleType xmlAnySimpleType;
/*  72 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(0)) != null) {
/*     */       int i;
/*  74 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) != paramArrayOfbyte.length)
/*     */       {
/*  76 */         paramValidationContext.invalid("cvc-length-valid.1.2", new Object[] { "hexBinary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  81 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(1)) != null) {
/*     */       int i;
/*  83 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) > paramArrayOfbyte.length)
/*     */       {
/*  85 */         paramValidationContext.invalid("cvc-minLength-valid.1.2", new Object[] { "hexBinary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  90 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(2)) != null) {
/*     */       int i;
/*  92 */       if ((i = ((XmlObjectBase)xmlAnySimpleType).bigIntegerValue().intValue()) < paramArrayOfbyte.length)
/*     */       {
/*  94 */         paramValidationContext.invalid("cvc-maxLength-valid.1.2", new Object[] { "hexBinary", new Integer(paramArrayOfbyte.length), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  99 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*     */     
/* 101 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       byte b;
/* 103 */       label37: for (b = 0; b < arrayOfXmlAnySimpleType.length; ) {
/*     */         
/* 105 */         byte[] arrayOfByte = ((XmlObjectBase)arrayOfXmlAnySimpleType[b]).byteArrayValue();
/*     */         
/* 107 */         if (arrayOfByte.length != paramArrayOfbyte.length) {
/*     */           b++; continue;
/*     */         } 
/* 110 */         for (byte b1 = 0; b1 < arrayOfByte.length; b1++) {
/* 111 */           if (arrayOfByte[b1] != paramArrayOfbyte[b1]) {
/*     */             continue label37;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 117 */       if (b >= arrayOfXmlAnySimpleType.length) {
/* 118 */         paramValidationContext.invalid("cvc-enumeration-valid.b", new Object[] { "hexBinary", QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 125 */     validateLexical(paramString, schemaType(), paramValidationContext);
/* 126 */     validateValue(byteArrayValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaHexBinaryHolderEx.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */