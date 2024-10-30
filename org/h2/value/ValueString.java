/*     */ package org.h2.value;
/*     */ 
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import org.h2.engine.SysProperties;
/*     */ import org.h2.util.MathUtils;
/*     */ import org.h2.util.StringUtils;
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
/*     */ public class ValueString
/*     */   extends Value
/*     */ {
/*  21 */   private static final ValueString EMPTY = new ValueString("");
/*     */ 
/*     */   
/*     */   protected final String value;
/*     */ 
/*     */ 
/*     */   
/*     */   protected ValueString(String paramString) {
/*  29 */     this.value = paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSQL() {
/*  34 */     return StringUtils.quoteStringSQL(this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/*  39 */     return (paramObject instanceof ValueString && this.value.equals(((ValueString)paramObject).value));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int compareSecure(Value paramValue, CompareMode paramCompareMode) {
/*  46 */     ValueString valueString = (ValueString)paramValue;
/*  47 */     return paramCompareMode.compareString(this.value, valueString.value, false);
/*     */   }
/*     */ 
/*     */   
/*     */   public String getString() {
/*  52 */     return this.value;
/*     */   }
/*     */ 
/*     */   
/*     */   public long getPrecision() {
/*  57 */     return this.value.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public Object getObject() {
/*  62 */     return this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void set(PreparedStatement paramPreparedStatement, int paramInt) throws SQLException {
/*  68 */     paramPreparedStatement.setString(paramInt, this.value);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getDisplaySize() {
/*  73 */     return this.value.length();
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMemory() {
/*  78 */     return this.value.length() * 2 + 48;
/*     */   }
/*     */ 
/*     */   
/*     */   public Value convertPrecision(long paramLong, boolean paramBoolean) {
/*  83 */     if (paramLong == 0L || this.value.length() <= paramLong) {
/*  84 */       return this;
/*     */     }
/*  86 */     int i = MathUtils.convertLongToInt(paramLong);
/*  87 */     return getNew(this.value.substring(0, i));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/*  94 */     return this.value.hashCode();
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
/*     */   public int getType() {
/* 124 */     return 13;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Value get(String paramString) {
/* 134 */     return get(paramString, false);
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
/*     */   public static Value get(String paramString, boolean paramBoolean) {
/* 146 */     if (paramString.isEmpty()) {
/* 147 */       return paramBoolean ? ValueNull.INSTANCE : EMPTY;
/*     */     }
/* 149 */     ValueString valueString = new ValueString(StringUtils.cache(paramString));
/* 150 */     if (paramString.length() > SysProperties.OBJECT_CACHE_MAX_PER_ELEMENT_SIZE) {
/* 151 */       return valueString;
/*     */     }
/* 153 */     return Value.cache(valueString);
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
/*     */   
/*     */   protected Value getNew(String paramString) {
/* 166 */     return get(paramString);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h2\value\ValueString.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */