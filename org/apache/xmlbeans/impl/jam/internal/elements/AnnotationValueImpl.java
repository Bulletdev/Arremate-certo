/*     */ package org.apache.xmlbeans.impl.jam.internal.elements;
/*     */ 
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotation;
/*     */ import org.apache.xmlbeans.impl.jam.JAnnotationValue;
/*     */ import org.apache.xmlbeans.impl.jam.JClass;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.JClassRef;
/*     */ import org.apache.xmlbeans.impl.jam.internal.classrefs.QualifiedJClassRef;
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
/*     */ public class AnnotationValueImpl
/*     */   implements JAnnotationValue
/*     */ {
/*  34 */   private Object mValue = null;
/*  35 */   private JClassRef mType = null;
/*     */ 
/*     */   
/*     */   private String mName;
/*     */ 
/*     */   
/*     */   private ElementContext mContext;
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationValueImpl(ElementContext paramElementContext, String paramString, Object paramObject, JClass paramJClass) {
/*  46 */     if (paramElementContext == null) throw new IllegalArgumentException("null ctx"); 
/*  47 */     if (paramString == null) throw new IllegalArgumentException("null name"); 
/*  48 */     if (paramObject == null) throw new IllegalArgumentException("null value"); 
/*  49 */     if (paramJClass == null) throw new IllegalArgumentException("null type"); 
/*  50 */     if (paramObject.getClass().isArray()) {
/*  51 */       this.mValue = ensureArrayWrapped(paramObject);
/*     */     } else {
/*  53 */       this.mValue = paramObject;
/*     */     } 
/*  55 */     this.mContext = paramElementContext;
/*  56 */     this.mName = paramString;
/*  57 */     this.mType = QualifiedJClassRef.create(paramJClass);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDefaultValueUsed() {
/*  64 */     throw new IllegalStateException("NYI");
/*     */   }
/*     */   
/*     */   public String getName() {
/*  68 */     return this.mName;
/*     */   } public JClass getType() {
/*  70 */     return this.mType.getRefClass();
/*     */   }
/*     */   
/*     */   public JAnnotation asAnnotation() {
/*  74 */     if (this.mValue instanceof JAnnotation) {
/*  75 */       return (JAnnotation)this.mValue;
/*     */     }
/*  77 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public JClass asClass() {
/*  82 */     if (this.mValue instanceof JClass) {
/*  83 */       return (JClass)this.mValue;
/*     */     }
/*  85 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String asString() {
/*  90 */     if (this.mValue == null) return null; 
/*  91 */     return this.mValue.toString();
/*     */   }
/*     */   
/*     */   public int asInt() throws NumberFormatException {
/*  95 */     if (this.mValue == null) return 0; 
/*  96 */     if (this.mValue instanceof Number) return ((Number)this.mValue).intValue(); 
/*     */     try {
/*  98 */       return Integer.parseInt(this.mValue.toString().trim());
/*  99 */     } catch (NumberFormatException numberFormatException) {
/* 100 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean asBoolean() throws IllegalArgumentException {
/* 105 */     if (this.mValue == null) return false; 
/* 106 */     return Boolean.valueOf(this.mValue.toString().trim()).booleanValue();
/*     */   }
/*     */   
/*     */   public long asLong() throws NumberFormatException {
/* 110 */     if (this.mValue == null) return 0L; 
/* 111 */     if (this.mValue instanceof Number) return ((Number)this.mValue).longValue(); 
/*     */     try {
/* 113 */       return Long.parseLong(this.mValue.toString().trim());
/* 114 */     } catch (NumberFormatException numberFormatException) {
/* 115 */       return 0L;
/*     */     } 
/*     */   }
/*     */   
/*     */   public short asShort() throws NumberFormatException {
/* 120 */     if (this.mValue == null) return 0; 
/* 121 */     if (this.mValue instanceof Number) return ((Number)this.mValue).shortValue(); 
/*     */     try {
/* 123 */       return Short.parseShort(this.mValue.toString().trim());
/* 124 */     } catch (NumberFormatException numberFormatException) {
/* 125 */       return 0;
/*     */     } 
/*     */   }
/*     */   
/*     */   public double asDouble() throws NumberFormatException {
/* 130 */     if (this.mValue == null) return 0.0D; 
/* 131 */     if (this.mValue instanceof Number) return ((Number)this.mValue).doubleValue(); 
/*     */     try {
/* 133 */       return Double.parseDouble(this.mValue.toString().trim());
/* 134 */     } catch (NumberFormatException numberFormatException) {
/* 135 */       return 0.0D;
/*     */     } 
/*     */   }
/*     */   
/*     */   public float asFloat() throws NumberFormatException {
/* 140 */     if (this.mValue == null) return 0.0F; 
/* 141 */     if (this.mValue instanceof Number) return ((Number)this.mValue).floatValue(); 
/*     */     try {
/* 143 */       return Float.parseFloat(this.mValue.toString().trim());
/* 144 */     } catch (NumberFormatException numberFormatException) {
/* 145 */       return 0.0F;
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte asByte() throws NumberFormatException {
/* 150 */     if (this.mValue == null) return 0; 
/* 151 */     if (this.mValue instanceof Number) return ((Number)this.mValue).byteValue(); 
/*     */     try {
/* 153 */       return Byte.parseByte(this.mValue.toString().trim());
/* 154 */     } catch (NumberFormatException numberFormatException) {
/* 155 */       return 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public char asChar() throws IllegalArgumentException {
/* 161 */     if (this.mValue == null) return Character.MIN_VALUE; 
/* 162 */     if (this.mValue instanceof Character) return ((Character)this.mValue).charValue(); 
/* 163 */     this.mValue = this.mValue.toString();
/* 164 */     return (((String)this.mValue).length() == 0) ? Character.MIN_VALUE : ((String)this.mValue).charAt(0);
/*     */   }
/*     */   
/*     */   public JClass[] asClassArray() {
/* 168 */     if (this.mValue instanceof JClass[]) {
/* 169 */       return (JClass[])this.mValue;
/*     */     }
/* 171 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public JAnnotation[] asAnnotationArray() {
/* 176 */     if (this.mValue instanceof JAnnotation[]) {
/* 177 */       return (JAnnotation[])this.mValue;
/*     */     }
/* 179 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public String[] asStringArray() {
/* 184 */     if (!this.mValue.getClass().isArray()) return null; 
/* 185 */     String[] arrayOfString = new String[((Object[])this.mValue).length];
/* 186 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 187 */       if (((Object[])this.mValue)[b] == null) {
/* 188 */         this.mContext.getLogger().error("Null annotation value array element on " + getName());
/*     */         
/* 190 */         arrayOfString[b] = "";
/*     */       } else {
/* 192 */         arrayOfString[b] = ((Object[])this.mValue)[b].toString();
/*     */       } 
/*     */     } 
/* 195 */     return arrayOfString;
/*     */   }
/*     */   
/*     */   public int[] asIntArray() throws NumberFormatException {
/* 199 */     if (!this.mValue.getClass().isArray()) return null; 
/* 200 */     int[] arrayOfInt = new int[((Object[])this.mValue).length];
/* 201 */     for (byte b = 0; b < arrayOfInt.length; b++) {
/* 202 */       if (((Object[])this.mValue)[b] == null) {
/* 203 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 205 */         arrayOfInt[b] = 0;
/*     */       } else {
/* 207 */         arrayOfInt[b] = Integer.parseInt(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 210 */     return arrayOfInt;
/*     */   }
/*     */   
/*     */   public boolean[] asBooleanArray() throws IllegalArgumentException {
/* 214 */     if (!this.mValue.getClass().isArray()) return null; 
/* 215 */     boolean[] arrayOfBoolean = new boolean[((Object[])this.mValue).length];
/* 216 */     for (byte b = 0; b < arrayOfBoolean.length; b++) {
/* 217 */       if (((Object[])this.mValue)[b] == null) {
/* 218 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 220 */         arrayOfBoolean[b] = false;
/*     */       } else {
/* 222 */         arrayOfBoolean[b] = Boolean.valueOf(((Object[])this.mValue)[b].toString()).booleanValue();
/*     */       } 
/*     */     } 
/* 225 */     return arrayOfBoolean;
/*     */   }
/*     */   
/*     */   public short[] asShortArray() throws NumberFormatException {
/* 229 */     if (!this.mValue.getClass().isArray()) return null; 
/* 230 */     short[] arrayOfShort = new short[((Object[])this.mValue).length];
/* 231 */     for (byte b = 0; b < arrayOfShort.length; b++) {
/* 232 */       if (((Object[])this.mValue)[b] == null) {
/* 233 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 235 */         arrayOfShort[b] = 0;
/*     */       } else {
/* 237 */         arrayOfShort[b] = Short.parseShort(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 240 */     return arrayOfShort;
/*     */   }
/*     */   
/*     */   public long[] asLongArray() throws NumberFormatException {
/* 244 */     if (!this.mValue.getClass().isArray()) return null; 
/* 245 */     long[] arrayOfLong = new long[((Object[])this.mValue).length];
/* 246 */     for (byte b = 0; b < arrayOfLong.length; b++) {
/* 247 */       if (((Object[])this.mValue)[b] == null) {
/* 248 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 250 */         arrayOfLong[b] = 0L;
/*     */       } else {
/* 252 */         arrayOfLong[b] = Long.parseLong(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 255 */     return arrayOfLong;
/*     */   }
/*     */   
/*     */   public double[] asDoubleArray() throws NumberFormatException {
/* 259 */     if (!this.mValue.getClass().isArray()) return null; 
/* 260 */     double[] arrayOfDouble = new double[((Object[])this.mValue).length];
/* 261 */     for (byte b = 0; b < arrayOfDouble.length; b++) {
/* 262 */       if (((Object[])this.mValue)[b] == null) {
/* 263 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 265 */         arrayOfDouble[b] = 0.0D;
/*     */       } else {
/* 267 */         arrayOfDouble[b] = Double.parseDouble(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 270 */     return arrayOfDouble;
/*     */   }
/*     */   
/*     */   public float[] asFloatArray() throws NumberFormatException {
/* 274 */     if (!this.mValue.getClass().isArray()) return null; 
/* 275 */     float[] arrayOfFloat = new float[((Object[])this.mValue).length];
/* 276 */     for (byte b = 0; b < arrayOfFloat.length; b++) {
/* 277 */       if (((Object[])this.mValue)[b] == null) {
/* 278 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 280 */         arrayOfFloat[b] = 0.0F;
/*     */       } else {
/* 282 */         arrayOfFloat[b] = Float.parseFloat(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 285 */     return arrayOfFloat;
/*     */   }
/*     */   
/*     */   public byte[] asByteArray() throws NumberFormatException {
/* 289 */     if (!this.mValue.getClass().isArray()) return null; 
/* 290 */     byte[] arrayOfByte = new byte[((Object[])this.mValue).length];
/* 291 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 292 */       if (((Object[])this.mValue)[b] == null) {
/* 293 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 295 */         arrayOfByte[b] = 0;
/*     */       } else {
/* 297 */         arrayOfByte[b] = Byte.parseByte(((Object[])this.mValue)[b].toString());
/*     */       } 
/*     */     } 
/* 300 */     return arrayOfByte;
/*     */   }
/*     */   
/*     */   public char[] asCharArray() throws IllegalArgumentException {
/* 304 */     if (!this.mValue.getClass().isArray()) return null; 
/* 305 */     char[] arrayOfChar = new char[((Object[])this.mValue).length];
/* 306 */     for (byte b = 0; b < arrayOfChar.length; b++) {
/* 307 */       if (((Object[])this.mValue)[b] == null) {
/* 308 */         this.mContext.getLogger().error("Null annotation value array element " + b + " on " + getName());
/*     */         
/* 310 */         arrayOfChar[b] = Character.MIN_VALUE;
/*     */       } else {
/*     */         
/* 313 */         arrayOfChar[b] = ((Object[])this.mValue)[b].toString().charAt(0);
/*     */       } 
/*     */     } 
/* 316 */     return arrayOfChar;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Object[] ensureArrayWrapped(Object paramObject) {
/* 324 */     if (paramObject instanceof Object[]) return (Object[])paramObject; 
/* 325 */     if (paramObject instanceof int[]) {
/* 326 */       int i = ((int[])paramObject).length;
/* 327 */       Integer[] arrayOfInteger = new Integer[i];
/* 328 */       for (byte b = 0; b < i; ) { arrayOfInteger[b] = new Integer(((int[])paramObject)[b]); b++; }
/* 329 */        return (Object[])arrayOfInteger;
/* 330 */     }  if (paramObject instanceof boolean[]) {
/* 331 */       int i = ((boolean[])paramObject).length;
/* 332 */       Boolean[] arrayOfBoolean = new Boolean[i];
/* 333 */       for (byte b = 0; b < i; ) { arrayOfBoolean[b] = Boolean.valueOf(((boolean[])paramObject)[b]); b++; }
/* 334 */        return (Object[])arrayOfBoolean;
/* 335 */     }  if (paramObject instanceof byte[]) {
/* 336 */       int i = ((byte[])paramObject).length;
/* 337 */       Byte[] arrayOfByte = new Byte[i];
/* 338 */       for (byte b = 0; b < i; ) { arrayOfByte[b] = new Byte(((byte[])paramObject)[b]); b++; }
/* 339 */        return (Object[])arrayOfByte;
/* 340 */     }  if (paramObject instanceof char[]) {
/* 341 */       int i = ((char[])paramObject).length;
/* 342 */       Character[] arrayOfCharacter = new Character[i];
/* 343 */       for (byte b = 0; b < i; ) { arrayOfCharacter[b] = new Character(((char[])paramObject)[b]); b++; }
/* 344 */        return (Object[])arrayOfCharacter;
/* 345 */     }  if (paramObject instanceof float[]) {
/* 346 */       int i = ((float[])paramObject).length;
/* 347 */       Float[] arrayOfFloat = new Float[i];
/* 348 */       for (byte b = 0; b < i; ) { arrayOfFloat[b] = new Float(((float[])paramObject)[b]); b++; }
/* 349 */        return (Object[])arrayOfFloat;
/* 350 */     }  if (paramObject instanceof double[]) {
/* 351 */       int i = ((double[])paramObject).length;
/* 352 */       Double[] arrayOfDouble = new Double[i];
/* 353 */       for (byte b = 0; b < i; ) { arrayOfDouble[b] = new Double(((double[])paramObject)[b]); b++; }
/* 354 */        return (Object[])arrayOfDouble;
/* 355 */     }  if (paramObject instanceof long[]) {
/* 356 */       int i = ((long[])paramObject).length;
/* 357 */       Long[] arrayOfLong = new Long[i];
/* 358 */       for (byte b = 0; b < i; ) { arrayOfLong[b] = new Long(((long[])paramObject)[b]); b++; }
/* 359 */        return (Object[])arrayOfLong;
/* 360 */     }  if (paramObject instanceof short[]) {
/* 361 */       int i = ((short[])paramObject).length;
/* 362 */       Short[] arrayOfShort = new Short[i];
/* 363 */       for (byte b = 0; b < i; ) { arrayOfShort[b] = new Short(((short[])paramObject)[b]); b++; }
/* 364 */        return (Object[])arrayOfShort;
/*     */     } 
/* 366 */     throw new IllegalStateException("Unknown array type " + paramObject.getClass());
/*     */   }
/*     */   
/*     */   public Object getValue() {
/* 370 */     return this.mValue;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\jam\internal\elements\AnnotationValueImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */