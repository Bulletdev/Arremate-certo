/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
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
/*     */ 
/*     */ public abstract class JavaIntHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   private int _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  32 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_INT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String compute_text(NamespaceManager paramNamespaceManager) {
/*  39 */     return Long.toString(this._value);
/*     */   } protected void set_text(String paramString) {
/*     */     
/*  42 */     try { set_int(XsTypeConverter.lexInt(paramString)); }
/*  43 */     catch (Exception exception) { throw new XmlValueOutOfRangeException("int", new Object[] { paramString }); }
/*     */   
/*     */   }
/*     */   protected void set_nil() {
/*  47 */     this._value = 0;
/*     */   }
/*     */   
/*  50 */   public BigDecimal getBigDecimalValue() { check_dated(); return new BigDecimal(this._value); }
/*  51 */   public BigInteger getBigIntegerValue() { check_dated(); return BigInteger.valueOf(this._value); }
/*  52 */   public long getLongValue() { check_dated(); return this._value; } public int getIntValue() {
/*  53 */     check_dated(); return this._value;
/*     */   }
/*  55 */   static final BigInteger _max = BigInteger.valueOf(2147483647L);
/*  56 */   static final BigInteger _min = BigInteger.valueOf(-2147483648L);
/*     */   
/*     */   protected void set_BigDecimal(BigDecimal paramBigDecimal) {
/*  59 */     set_BigInteger(paramBigDecimal.toBigInteger());
/*     */   }
/*     */   protected void set_BigInteger(BigInteger paramBigInteger) {
/*  62 */     if (paramBigInteger.compareTo(_max) > 0 || paramBigInteger.compareTo(_min) < 0)
/*  63 */       throw new XmlValueOutOfRangeException(); 
/*  64 */     set_int(paramBigInteger.intValue());
/*     */   }
/*     */   
/*     */   protected void set_long(long paramLong) {
/*  68 */     if (paramLong > 2147483647L || paramLong < -2147483648L)
/*  69 */       throw new XmlValueOutOfRangeException(); 
/*  70 */     set_int((int)paramLong);
/*     */   }
/*     */   
/*     */   protected void set_int(int paramInt) {
/*  74 */     this._value = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/*  80 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 32) {
/*  81 */       return -paramXmlObject.compareTo(this);
/*     */     }
/*  83 */     return (this._value == ((XmlObjectBase)paramXmlObject).intValue()) ? 0 : ((this._value < ((XmlObjectBase)paramXmlObject).intValue()) ? -1 : 1);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/*  89 */     if (((SimpleValue)paramXmlObject).instanceType().getDecimalSize() > 32) {
/*  90 */       return paramXmlObject.valueEquals(this);
/*     */     }
/*  92 */     return (this._value == ((XmlObjectBase)paramXmlObject).intValue());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 101 */     return this._value;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaIntHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */