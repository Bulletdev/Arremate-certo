/*    */ package org.apache.xmlbeans.impl.values;
/*    */ 
/*    */ import java.math.BigDecimal;
/*    */ import java.math.BigInteger;
/*    */ import org.apache.xmlbeans.SchemaType;
/*    */ import org.apache.xmlbeans.SimpleValue;
/*    */ import org.apache.xmlbeans.XmlObject;
/*    */ import org.apache.xmlbeans.impl.schema.BuiltinSchemaTypeSystem;
/*    */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
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
/*    */ public abstract class JavaLongHolder
/*    */   extends XmlObjectBase
/*    */ {
/*    */   private long _value;
/*    */   
/*    */   public SchemaType schemaType() {
/* 32 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_LONG;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/* 39 */     return Long.toString(this._value);
/*    */   } protected void set_text(String paramString) {
/*    */     
/* 42 */     try { set_long(XsTypeConverter.lexLong(paramString)); }
/* 43 */     catch (Exception exception) { throw new XmlValueOutOfRangeException("long", new Object[] { paramString }); }
/*    */   
/*    */   }
/*    */   protected void set_nil() {
/* 47 */     this._value = 0L;
/*    */   }
/*    */   
/*    */   public BigDecimal getBigDecimalValue() {
/* 51 */     check_dated(); return BigDecimal.valueOf(this._value);
/* 52 */   } public BigInteger getBigIntegerValue() { check_dated(); return BigInteger.valueOf(this._value); } public long getLongValue() {
/* 53 */     check_dated(); return this._value;
/*    */   }
/* 55 */   private static final BigInteger _max = BigInteger.valueOf(Long.MAX_VALUE);
/* 56 */   private static final BigInteger _min = BigInteger.valueOf(Long.MIN_VALUE);
/*    */   
/*    */   protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/* 59 */     set_BigInteger(paramBigDecimal.toBigInteger());
/*    */   }
/*    */   protected void set_BigInteger(BigInteger paramBigInteger) {
/* 62 */     if (paramBigInteger.compareTo(_max) > 0 || paramBigInteger.compareTo(_min) < 0)
/* 63 */       throw new XmlValueOutOfRangeException(); 
/* 64 */     this._value = paramBigInteger.longValue();
/*    */   } protected void set_long(long paramLong) {
/* 66 */     this._value = paramLong;
/*    */   }
/*    */ 
/*    */   
/*    */   protected int compare_to(XmlObject paramXmlObject) {
/* 71 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 64) {
/* 72 */       return -paramXmlObject.compareTo(this);
/*    */     }
/* 74 */     return (this._value == ((XmlObjectBase)paramXmlObject).longValue()) ? 0 : ((this._value < ((XmlObjectBase)paramXmlObject).longValue()) ? -1 : 1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 80 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 64) {
/* 81 */       return paramXmlObject.valueEquals(this);
/*    */     }
/* 83 */     return (this._value == ((XmlObjectBase)paramXmlObject).longValue());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   protected int value_hash_code() {
/* 92 */     return (int)((this._value >> 32L) * 19L + this._value);
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaLongHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */