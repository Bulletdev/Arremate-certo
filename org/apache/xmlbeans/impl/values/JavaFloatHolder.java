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
/*     */ public abstract class JavaFloatHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   private float _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  31 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_FLOAT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  39 */     return serialize(this._value);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String serialize(float paramFloat) {
/*  44 */     if (paramFloat == Float.POSITIVE_INFINITY)
/*  45 */       return "INF"; 
/*  46 */     if (paramFloat == Float.NEGATIVE_INFINITY)
/*  47 */       return "-INF"; 
/*  48 */     if (paramFloat == Float.NaN) {
/*  49 */       return "NaN";
/*     */     }
/*  51 */     return Float.toString(paramFloat);
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*  55 */     set_float(validateLexical(paramString, _voorVc));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float validateLexical(String paramString, ValidationContext paramValidationContext) {
/*     */     try {
/*  61 */       return XsTypeConverter.lexFloat(paramString);
/*     */     }
/*  63 */     catch (NumberFormatException numberFormatException) {
/*     */       
/*  65 */       paramValidationContext.invalid("float", new Object[] { paramString });
/*     */       
/*  67 */       return Float.NaN;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void set_nil() {
/*  72 */     this._value = 0.0F;
/*     */   }
/*     */   
/*  75 */   public BigDecimal getBigDecimalValue() { check_dated(); return new BigDecimal(this._value); }
/*  76 */   public double getDoubleValue() { check_dated(); return this._value; } public float getFloatValue() {
/*  77 */     check_dated(); return this._value;
/*     */   }
/*     */   
/*  80 */   protected void set_double(double paramDouble) { set_float((float)paramDouble); }
/*  81 */   protected void set_float(float paramFloat) { this._value = paramFloat; }
/*  82 */   protected void set_long(long paramLong) { set_float((float)paramLong); }
/*  83 */   protected void set_BigDecimal(BigDecimal paramBigDecimal) { set_float(paramBigDecimal.floatValue()); } protected void set_BigInteger(BigInteger paramBigInteger) {
/*  84 */     set_float(paramBigInteger.floatValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/*  89 */     return compare(this._value, ((XmlObjectBase)paramXmlObject).floatValue());
/*     */   }
/*     */ 
/*     */   
/*     */   static int compare(float paramFloat1, float paramFloat2) {
/*  94 */     if (paramFloat1 < paramFloat2) return -1; 
/*  95 */     if (paramFloat1 > paramFloat2) return 1;
/*     */     
/*  97 */     int i = Float.floatToIntBits(paramFloat1);
/*  98 */     int j = Float.floatToIntBits(paramFloat2);
/*     */     
/* 100 */     return (i == j) ? 0 : ((i < j) ? -1 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 105 */     return (compare(this._value, ((XmlObjectBase)paramXmlObject).floatValue()) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 110 */     return Float.floatToIntBits(this._value);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaFloatHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */