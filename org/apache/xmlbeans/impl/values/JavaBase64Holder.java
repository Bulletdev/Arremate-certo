/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.Arrays;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlBase64Binary;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*     */ import org.apache.xmlbeans.impl.util.Base64;
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
/*     */ public abstract class JavaBase64Holder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   protected byte[] _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  36 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_BASE_64_BINARY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  45 */     return new String(Base64.encode(this._value));
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*  49 */     this._hashcached = false;
/*  50 */     if (_validateOnSet()) {
/*  51 */       this._value = validateLexical(paramString, schemaType(), _voorVc);
/*     */     } else {
/*  53 */       this._value = lex(paramString, _voorVc);
/*     */     } 
/*     */   }
/*     */   protected void set_nil() {
/*  57 */     this._hashcached = false;
/*  58 */     this._value = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] lex(String paramString, ValidationContext paramValidationContext) {
/*  63 */     byte[] arrayOfByte1 = null;
/*     */     
/*     */     try {
/*  66 */       arrayOfByte1 = paramString.getBytes("UTF-8");
/*     */     }
/*  68 */     catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*     */ 
/*     */ 
/*     */     
/*  72 */     byte[] arrayOfByte2 = Base64.decode(arrayOfByte1);
/*     */     
/*  74 */     if (arrayOfByte2 == null)
/*     */     {
/*     */       
/*  77 */       paramValidationContext.invalid("base64Binary", new Object[] { "not encoded properly" });
/*     */     }
/*     */     
/*  80 */     return arrayOfByte2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  85 */     byte[] arrayOfByte = lex(paramString, paramValidationContext);
/*  86 */     if (arrayOfByte == null) return null;
/*     */     
/*  88 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/*     */       
/*  90 */       paramValidationContext.invalid("cvc-datatype-valid.1.1b", new Object[] { "base 64", QNameHelper.readable(paramSchemaType) });
/*     */       
/*  92 */       return null;
/*     */     } 
/*     */     
/*  95 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArrayValue() {
/* 100 */     check_dated();
/* 101 */     if (this._value == null) {
/* 102 */       return null;
/*     */     }
/* 104 */     byte[] arrayOfByte = new byte[this._value.length];
/* 105 */     System.arraycopy(this._value, 0, arrayOfByte, 0, this._value.length);
/* 106 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/* 112 */     this._hashcached = false;
/* 113 */     this._value = new byte[paramArrayOfbyte.length];
/* 114 */     System.arraycopy(paramArrayOfbyte, 0, this._value, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 120 */     byte[] arrayOfByte = ((XmlBase64Binary)paramXmlObject).getByteArrayValue();
/* 121 */     return Arrays.equals(this._value, arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean _hashcached = false;
/* 126 */   protected int hashcode = 0;
/*     */   
/*     */   protected static MessageDigest md5;
/*     */   
/*     */   static {
/*     */     try {
/* 132 */       md5 = MessageDigest.getInstance("MD5");
/*     */     }
/* 134 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */       
/* 136 */       throw new IllegalStateException("Cannot find MD5 hash Algorithm");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 142 */     if (this._hashcached) {
/* 143 */       return this.hashcode;
/*     */     }
/* 145 */     this._hashcached = true;
/*     */     
/* 147 */     if (this._value == null) {
/* 148 */       return this.hashcode = 0;
/*     */     }
/* 150 */     byte[] arrayOfByte = md5.digest(this._value);
/* 151 */     return this.hashcode = arrayOfByte[0] << 24 + arrayOfByte[1] << 16 + arrayOfByte[2] << 8 + arrayOfByte[3];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaBase64Holder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */