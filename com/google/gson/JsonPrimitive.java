/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.;
/*     */ import com.google.gson.internal.LazilyParsedNumber;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
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
/*     */ public final class JsonPrimitive
/*     */   extends JsonElement
/*     */ {
/*  35 */   private static final Class<?>[] PRIMITIVE_TYPES = new Class[] { int.class, long.class, short.class, float.class, double.class, byte.class, boolean.class, char.class, Integer.class, Long.class, Short.class, Float.class, Double.class, Byte.class, Boolean.class, Character.class };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Object value;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive(Boolean paramBoolean) {
/*  47 */     setValue(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive(Number paramNumber) {
/*  56 */     setValue(paramNumber);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive(String paramString) {
/*  65 */     setValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive(Character paramCharacter) {
/*  75 */     setValue(paramCharacter);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   JsonPrimitive(Object paramObject) {
/*  85 */     setValue(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive deepCopy() {
/*  94 */     return this;
/*     */   }
/*     */   
/*     */   void setValue(Object paramObject) {
/*  98 */     if (paramObject instanceof Character) {
/*     */ 
/*     */       
/* 101 */       char c = ((Character)paramObject).charValue();
/* 102 */       this.value = String.valueOf(c);
/*     */     } else {
/* 104 */       .Gson.Preconditions.checkArgument((paramObject instanceof Number || 
/* 105 */           isPrimitiveOrString(paramObject)));
/* 106 */       this.value = paramObject;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBoolean() {
/* 116 */     return this.value instanceof Boolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   Boolean getAsBooleanWrapper() {
/* 126 */     return (Boolean)this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAsBoolean() {
/* 136 */     if (isBoolean()) {
/* 137 */       return getAsBooleanWrapper().booleanValue();
/*     */     }
/*     */     
/* 140 */     return Boolean.parseBoolean(getAsString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isNumber() {
/* 150 */     return this.value instanceof Number;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getAsNumber() {
/* 161 */     return (this.value instanceof String) ? (Number)new LazilyParsedNumber((String)this.value) : (Number)this.value;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isString() {
/* 170 */     return this.value instanceof String;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getAsString() {
/* 180 */     if (isNumber())
/* 181 */       return getAsNumber().toString(); 
/* 182 */     if (isBoolean()) {
/* 183 */       return getAsBooleanWrapper().toString();
/*     */     }
/* 185 */     return (String)this.value;
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
/*     */   public double getAsDouble() {
/* 197 */     return isNumber() ? getAsNumber().doubleValue() : Double.parseDouble(getAsString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigDecimal getAsBigDecimal() {
/* 208 */     return (this.value instanceof BigDecimal) ? (BigDecimal)this.value : new BigDecimal(this.value.toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BigInteger getAsBigInteger() {
/* 219 */     return (this.value instanceof BigInteger) ? (BigInteger)this.value : new BigInteger(this.value
/* 220 */         .toString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getAsFloat() {
/* 231 */     return isNumber() ? getAsNumber().floatValue() : Float.parseFloat(getAsString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getAsLong() {
/* 242 */     return isNumber() ? getAsNumber().longValue() : Long.parseLong(getAsString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public short getAsShort() {
/* 253 */     return isNumber() ? getAsNumber().shortValue() : Short.parseShort(getAsString());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAsInt() {
/* 264 */     return isNumber() ? getAsNumber().intValue() : Integer.parseInt(getAsString());
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getAsByte() {
/* 269 */     return isNumber() ? getAsNumber().byteValue() : Byte.parseByte(getAsString());
/*     */   }
/*     */ 
/*     */   
/*     */   public char getAsCharacter() {
/* 274 */     return getAsString().charAt(0);
/*     */   }
/*     */   
/*     */   private static boolean isPrimitiveOrString(Object paramObject) {
/* 278 */     if (paramObject instanceof String) {
/* 279 */       return true;
/*     */     }
/*     */     
/* 282 */     Class<?> clazz = paramObject.getClass();
/* 283 */     for (Class<?> clazz1 : PRIMITIVE_TYPES) {
/* 284 */       if (clazz1.isAssignableFrom(clazz)) {
/* 285 */         return true;
/*     */       }
/*     */     } 
/* 288 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 293 */     if (this.value == null) {
/* 294 */       return 31;
/*     */     }
/*     */     
/* 297 */     if (isIntegral(this)) {
/* 298 */       long l = getAsNumber().longValue();
/* 299 */       return (int)(l ^ l >>> 32L);
/*     */     } 
/* 301 */     if (this.value instanceof Number) {
/* 302 */       long l = Double.doubleToLongBits(getAsNumber().doubleValue());
/* 303 */       return (int)(l ^ l >>> 32L);
/*     */     } 
/* 305 */     return this.value.hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 310 */     if (this == paramObject) {
/* 311 */       return true;
/*     */     }
/* 313 */     if (paramObject == null || getClass() != paramObject.getClass()) {
/* 314 */       return false;
/*     */     }
/* 316 */     JsonPrimitive jsonPrimitive = (JsonPrimitive)paramObject;
/* 317 */     if (this.value == null) {
/* 318 */       return (jsonPrimitive.value == null);
/*     */     }
/* 320 */     if (isIntegral(this) && isIntegral(jsonPrimitive)) {
/* 321 */       return (getAsNumber().longValue() == jsonPrimitive.getAsNumber().longValue());
/*     */     }
/* 323 */     if (this.value instanceof Number && jsonPrimitive.value instanceof Number) {
/* 324 */       double d1 = getAsNumber().doubleValue();
/*     */ 
/*     */       
/* 327 */       double d2 = jsonPrimitive.getAsNumber().doubleValue();
/* 328 */       return (d1 == d2 || (Double.isNaN(d1) && Double.isNaN(d2)));
/*     */     } 
/* 330 */     return this.value.equals(jsonPrimitive.value);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean isIntegral(JsonPrimitive paramJsonPrimitive) {
/* 338 */     if (paramJsonPrimitive.value instanceof Number) {
/* 339 */       Number number = (Number)paramJsonPrimitive.value;
/* 340 */       return (number instanceof BigInteger || number instanceof Long || number instanceof Integer || number instanceof Short || number instanceof Byte);
/*     */     } 
/*     */     
/* 343 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\JsonPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */