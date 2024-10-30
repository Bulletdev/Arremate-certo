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
/*     */ public abstract class JavaDoubleHolder
/*     */   extends XmlObjectBase
/*     */ {
/*     */   double _value;
/*     */   
/*     */   public SchemaType schemaType() {
/*  31 */     return (SchemaType)BuiltinSchemaTypeSystem.ST_DOUBLE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  38 */     return serialize(this._value);
/*     */   }
/*     */   
/*     */   public static String serialize(double paramDouble) {
/*  42 */     if (paramDouble == Double.POSITIVE_INFINITY)
/*  43 */       return "INF"; 
/*  44 */     if (paramDouble == Double.NEGATIVE_INFINITY)
/*  45 */       return "-INF"; 
/*  46 */     if (paramDouble == Double.NaN) {
/*  47 */       return "NaN";
/*     */     }
/*  49 */     return Double.toString(paramDouble);
/*     */   }
/*     */   
/*     */   protected void set_text(String paramString) {
/*  53 */     set_double(validateLexical(paramString, _voorVc));
/*     */   }
/*     */ 
/*     */   
/*     */   public static double validateLexical(String paramString, ValidationContext paramValidationContext) {
/*     */     try {
/*  59 */       return XsTypeConverter.lexDouble(paramString);
/*     */     }
/*  61 */     catch (NumberFormatException numberFormatException) {
/*     */       
/*  63 */       paramValidationContext.invalid("double", new Object[] { paramString });
/*     */       
/*  65 */       return Double.NaN;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void set_nil() {
/*  70 */     this._value = 0.0D;
/*     */   }
/*     */   
/*     */   public BigDecimal getBigDecimalValue() {
/*  74 */     check_dated(); return new BigDecimal(this._value);
/*  75 */   } public double getDoubleValue() { check_dated(); return this._value; } public float getFloatValue() {
/*  76 */     check_dated(); return (float)this._value;
/*     */   }
/*     */   
/*  79 */   protected void set_double(double paramDouble) { this._value = paramDouble; }
/*  80 */   protected void set_float(float paramFloat) { set_double(paramFloat); }
/*  81 */   protected void set_long(long paramLong) { set_double(paramLong); }
/*  82 */   protected void set_BigDecimal(BigDecimal paramBigDecimal) { set_double(paramBigDecimal.doubleValue()); } protected void set_BigInteger(BigInteger paramBigInteger) {
/*  83 */     set_double(paramBigInteger.doubleValue());
/*     */   }
/*     */ 
/*     */   
/*     */   protected int compare_to(XmlObject paramXmlObject) {
/*  88 */     return compare(this._value, ((XmlObjectBase)paramXmlObject).doubleValue());
/*     */   }
/*     */   
/*     */   static int compare(double paramDouble1, double paramDouble2) {
/*  92 */     if (paramDouble1 < paramDouble2) return -1; 
/*  93 */     if (paramDouble1 > paramDouble2) return 1;
/*     */     
/*  95 */     long l1 = Double.doubleToLongBits(paramDouble1);
/*  96 */     long l2 = Double.doubleToLongBits(paramDouble2);
/*     */     
/*  98 */     return (l1 == l2) ? 0 : ((l1 < l2) ? -1 : 1);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 103 */     return (compare(this._value, ((XmlObjectBase)paramXmlObject).doubleValue()) == 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 108 */     long l = Double.doubleToLongBits(this._value);
/* 109 */     return (int)((l >> 32L) * 19L + l);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\JavaDoubleHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */