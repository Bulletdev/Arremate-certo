/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.Arrays;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlHexBinary;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*     */ import org.apache.xmlbeans.impl.util.HexBin;
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
/*     */ public abstract class JavaHexBinaryHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   protected byte[] _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  36 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_HEX_BINARY;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  45 */     return new String(HexBin.encode(this._value));
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
/*  72 */     byte[] arrayOfByte2 = HexBin.decode(arrayOfByte1);
/*     */     
/*  74 */     if (arrayOfByte2 == null)
/*     */     {
/*     */       
/*  77 */       paramValidationContext.invalid("hexBinary", new Object[] { "not encoded properly" });
/*     */     }
/*     */     
/*  80 */     return arrayOfByte2;
/*     */   }
/*     */ 
/*     */   
/*     */   public static byte[] validateLexical(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/*  85 */     byte[] arrayOfByte = lex(paramString, paramValidationContext);
/*     */     
/*  87 */     if (arrayOfByte == null) {
/*  88 */       return null;
/*     */     }
/*  90 */     if (!paramSchemaType.matchPatternFacet(paramString)) {
/*     */       
/*  92 */       paramValidationContext.invalid("Hex encoded data does not match pattern for " + QNameHelper.readable(paramSchemaType));
/*  93 */       return null;
/*     */     } 
/*     */     
/*  96 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */   
/*     */   public byte[] getByteArrayValue() {
/* 101 */     check_dated();
/* 102 */     if (this._value == null) {
/* 103 */       return null;
/*     */     }
/* 105 */     byte[] arrayOfByte = new byte[this._value.length];
/* 106 */     System.arraycopy(this._value, 0, arrayOfByte, 0, this._value.length);
/* 107 */     return arrayOfByte;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_ByteArray(byte[] paramArrayOfbyte) {
/* 113 */     this._hashcached = false;
/* 114 */     this._value = new byte[paramArrayOfbyte.length];
/* 115 */     System.arraycopy(paramArrayOfbyte, 0, this._value, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 121 */     byte[] arrayOfByte = ((XmlHexBinary)paramXmlObject).getByteArrayValue();
/* 122 */     return Arrays.equals(this._value, arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean _hashcached = false;
/* 127 */   protected int hashcode = 0;
/*     */   
/*     */   protected static MessageDigest md5;
/*     */   
/*     */   static {
/*     */     try {
/* 133 */       md5 = MessageDigest.getInstance("MD5");
/*     */     }
/* 135 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */       
/* 137 */       throw new IllegalStateException("Cannot find MD5 hash Algorithm");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 143 */     if (this._hashcached) {
/* 144 */       return this.hashcode;
/*     */     }
/* 146 */     this._hashcached = true;
/*     */     
/* 148 */     if (this._value == null) {
/* 149 */       return this.hashcode = 0;
/*     */     }
/* 151 */     byte[] arrayOfByte = md5.digest(this._value);
/* 152 */     return this.hashcode = arrayOfByte[0] << 24 + arrayOfByte[1] << 16 + arrayOfByte[2] << 8 + arrayOfByte[3];
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaHexBinaryHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */