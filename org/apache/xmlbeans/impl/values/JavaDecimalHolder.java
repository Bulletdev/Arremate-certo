/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*     */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
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
/*     */ public class JavaDecimalHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   private BigDecimal _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  31 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_DECIMAL;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  38 */     return XsTypeConverter.printDecimal(this._value);
/*     */   }
/*     */   protected void set_text(String paramString) {
/*  41 */     if (_validateOnSet()) {
/*  42 */       validateLexical(paramString, _voorVc);
/*     */     }
/*     */     try {
/*  45 */       set_BigDecimal(new BigDecimal(paramString));
/*     */     }
/*  47 */     catch (NumberFormatException numberFormatException) {
/*     */       
/*  49 */       _voorVc.invalid("decimal", new Object[] { paramString });
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void set_nil() {
/*  54 */     this._value = null;
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
/*     */   public static void validateLexical(String paramString, ValidationContext paramValidationContext) {
/*  66 */     int i = paramString.length();
/*  67 */     byte b = 0;
/*     */     
/*  69 */     if (b < i) {
/*     */       
/*  71 */       char c = paramString.charAt(b);
/*     */       
/*  73 */       if (c == '+' || c == '-') {
/*  74 */         b++;
/*     */       }
/*     */     } 
/*  77 */     boolean bool1 = false;
/*  78 */     boolean bool2 = false;
/*     */     
/*  80 */     for (; b < i; b++) {
/*     */       
/*  82 */       char c = paramString.charAt(b);
/*     */       
/*  84 */       if (c == '.') {
/*     */         
/*  86 */         if (bool1) {
/*     */           
/*  88 */           paramValidationContext.invalid("decimal", new Object[] { "saw '.' more than once: " + paramString });
/*     */           
/*     */           return;
/*     */         } 
/*     */         
/*  93 */         bool1 = true;
/*     */       }
/*  95 */       else if (c >= '0' && c <= '9') {
/*     */         
/*  97 */         bool2 = true;
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 102 */         paramValidationContext.invalid("decimal", new Object[] { "unexpected char '" + c + "'" });
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     if (!bool2) {
/*     */       
/* 110 */       paramValidationContext.invalid("decimal", new Object[] { "expected at least one digit" });
/*     */       return;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public BigDecimal getBigDecimalValue() {
/* 117 */     check_dated(); return this._value;
/*     */   }
/*     */   protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/* 120 */     this._value = paramBigDecimal;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/* 125 */     return this._value.compareTo(((XmlObjectBase)paramXmlObject).bigDecimalValue());
/*     */   }
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 129 */     return (this._value.compareTo(((XmlObjectBase)paramXmlObject).bigDecimalValue()) == 0);
/*     */   }
/*     */   
/* 132 */   private static BigInteger _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
/* 133 */   private static BigInteger _minlong = BigInteger.valueOf(Long.MIN_VALUE);
/*     */ 
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */ 
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 141 */     if (this._value.scale() > 0)
/*     */     {
/* 143 */       if (this._value.setScale(0, 1).compareTo(this._value) != 0) {
/* 144 */         return decimalHashCode();
/*     */       }
/*     */     }
/* 147 */     BigInteger bigInteger = this._value.toBigInteger();
/*     */     
/* 149 */     if (bigInteger.compareTo(_maxlong) > 0 || bigInteger.compareTo(_minlong) < 0)
/*     */     {
/* 151 */       return bigInteger.hashCode();
/*     */     }
/* 153 */     long l = bigInteger.longValue();
/*     */     
/* 155 */     return (int)((l >> 32L) * 19L + l);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int decimalHashCode() {
/* 164 */     assert this._value.scale() > 0;
/*     */ 
/*     */     
/* 167 */     String str = this._value.toString();
/*     */     int i;
/* 169 */     for (i = str.length() - 1; i >= 0 && 
/* 170 */       str.charAt(i) == '0'; i--);
/*     */     
/* 172 */     assert str.indexOf('.') < i;
/*     */ 
/*     */     
/* 175 */     return str.substring(0, i + 1).hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaDecimalHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */