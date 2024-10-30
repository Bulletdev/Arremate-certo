/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.BigInteger;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.SimpleValue;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*    */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class JavaIntegerHolder
/*    */   extends XmlObjectBase
/*    */ {
/*    */   private BigInteger _value;
/*    */   
/*    */   public SchemaType schemaType() {
/* 32 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_INTEGER;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/* 39 */     return this._value.toString();
/*    */   }
/*    */   protected void set_text(String paramString) {
/* 42 */     set_BigInteger(lex(paramString, _voorVc));
/*    */   }
/*    */   
/*    */   public static BigInteger lex(String paramString, ValidationContext paramValidationContext) {
/* 46 */     if (paramString.length() > 0 && paramString.charAt(0) == '+')
/* 47 */       paramString = paramString.substring(1); 
/*    */     
/* 49 */     try { return new BigInteger(paramString); }
/* 50 */     catch (Exception exception) { paramValidationContext.invalid("integer", new Object[] { paramString }); return null; }
/*    */   
/*    */   }
/*    */   protected void set_nil() {
/* 54 */     this._value = null;
/*    */   }
/*    */   
/* 57 */   public BigDecimal getBigDecimalValue() { check_dated(); return (this._value == null) ? null : new BigDecimal(this._value); } public BigInteger getBigIntegerValue() {
/* 58 */     check_dated(); return this._value;
/*    */   }
/*    */   
/* 61 */   protected void set_BigDecimal(BigDecimal paramBigDecimal) { this._value = paramBigDecimal.toBigInteger(); } protected void set_BigInteger(BigInteger paramBigInteger) {
/* 62 */     this._value = paramBigInteger;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int compare_to(XmlObject paramXmlObject) {
/* 67 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 1000000) {
/* 68 */       return -paramXmlObject.compareTo(this);
/*    */     }
/* 70 */     return this._value.compareTo(((XmlObjectBase)paramXmlObject).bigIntegerValue());
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 75 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 1000000) {
/* 76 */       return paramXmlObject.valueEquals(this);
/*    */     }
/* 78 */     return this._value.equals(((XmlObjectBase)paramXmlObject).bigIntegerValue());
/*    */   }
/*    */   
/* 81 */   private static BigInteger _maxlong = BigInteger.valueOf(Long.MAX_VALUE);
/* 82 */   private static BigInteger _minlong = BigInteger.valueOf(Long.MIN_VALUE);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 90 */     if (this._value.compareTo(_maxlong) > 0 || this._value.compareTo(_minlong) < 0)
/*    */     {
/* 92 */       return this._value.hashCode();
/*    */     }
/* 94 */     long l = this._value.longValue();
/*    */     
/* 96 */     return (int)((l >> 32L) * 19L + l);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaIntegerHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */