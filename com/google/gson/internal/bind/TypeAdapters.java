/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonIOException;
/*     */ import com.google.gson.JsonNull;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import com.google.gson.internal.LazilyParsedNumber;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.net.InetAddress;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.BitSet;
/*     */ import java.util.Calendar;
/*     */ import java.util.Currency;
/*     */ import java.util.Date;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.HashMap;
/*     */ import java.util.Locale;
/*     */ import java.util.Map;
/*     */ import java.util.StringTokenizer;
/*     */ import java.util.UUID;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import java.util.concurrent.atomic.AtomicInteger;
/*     */ import java.util.concurrent.atomic.AtomicIntegerArray;
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
/*     */ public final class TypeAdapters
/*     */ {
/*     */   private TypeAdapters() {
/*  65 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */   
/*  69 */   public static final TypeAdapter<Class> CLASS = (new TypeAdapter<Class>()
/*     */     {
/*     */       public void write(JsonWriter param1JsonWriter, Class param1Class) throws IOException {
/*  72 */         throw new UnsupportedOperationException("Attempted to serialize java.lang.Class: " + param1Class
/*  73 */             .getName() + ". Forgot to register a type adapter?");
/*     */       }
/*     */       
/*     */       public Class read(JsonReader param1JsonReader) throws IOException {
/*  77 */         throw new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
/*     */       }
/*  80 */     }).nullSafe();
/*     */   
/*  82 */   public static final TypeAdapterFactory CLASS_FACTORY = newFactory(Class.class, CLASS);
/*     */   
/*  84 */   public static final TypeAdapter<BitSet> BIT_SET = (new TypeAdapter<BitSet>() {
/*     */       public BitSet read(JsonReader param1JsonReader) throws IOException {
/*  86 */         BitSet bitSet = new BitSet();
/*  87 */         param1JsonReader.beginArray();
/*  88 */         byte b = 0;
/*  89 */         JsonToken jsonToken = param1JsonReader.peek();
/*  90 */         while (jsonToken != JsonToken.END_ARRAY) {
/*     */           boolean bool; String str;
/*  92 */           switch (jsonToken) {
/*     */             case NUMBER:
/*  94 */               bool = (param1JsonReader.nextInt() != 0);
/*     */               break;
/*     */             case BOOLEAN:
/*  97 */               bool = param1JsonReader.nextBoolean();
/*     */               break;
/*     */             case STRING:
/* 100 */               str = param1JsonReader.nextString();
/*     */               try {
/* 102 */                 bool = (Integer.parseInt(str) != 0);
/* 103 */               } catch (NumberFormatException numberFormatException) {
/* 104 */                 throw new JsonSyntaxException("Error: Expecting: bitset number value (1, 0), Found: " + str);
/*     */               } 
/*     */               break;
/*     */             
/*     */             default:
/* 109 */               throw new JsonSyntaxException("Invalid bitset value type: " + jsonToken);
/*     */           } 
/* 111 */           if (bool) {
/* 112 */             bitSet.set(b);
/*     */           }
/* 114 */           b++;
/* 115 */           jsonToken = param1JsonReader.peek();
/*     */         } 
/* 117 */         param1JsonReader.endArray();
/* 118 */         return bitSet;
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, BitSet param1BitSet) throws IOException {
/* 122 */         param1JsonWriter.beginArray(); byte b; int i;
/* 123 */         for (b = 0, i = param1BitSet.length(); b < i; b++) {
/* 124 */           boolean bool = param1BitSet.get(b) ? true : false;
/* 125 */           param1JsonWriter.value(bool);
/*     */         } 
/* 127 */         param1JsonWriter.endArray();
/*     */       }
/* 129 */     }).nullSafe();
/*     */   
/* 131 */   public static final TypeAdapterFactory BIT_SET_FACTORY = newFactory(BitSet.class, BIT_SET);
/*     */   
/* 133 */   public static final TypeAdapter<Boolean> BOOLEAN = new TypeAdapter<Boolean>()
/*     */     {
/*     */       public Boolean read(JsonReader param1JsonReader) throws IOException {
/* 136 */         JsonToken jsonToken = param1JsonReader.peek();
/* 137 */         if (jsonToken == JsonToken.NULL) {
/* 138 */           param1JsonReader.nextNull();
/* 139 */           return null;
/* 140 */         }  if (jsonToken == JsonToken.STRING)
/*     */         {
/* 142 */           return Boolean.valueOf(Boolean.parseBoolean(param1JsonReader.nextString()));
/*     */         }
/* 144 */         return Boolean.valueOf(param1JsonReader.nextBoolean());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Boolean param1Boolean) throws IOException {
/* 148 */         param1JsonWriter.value(param1Boolean);
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 156 */   public static final TypeAdapter<Boolean> BOOLEAN_AS_STRING = new TypeAdapter<Boolean>() {
/*     */       public Boolean read(JsonReader param1JsonReader) throws IOException {
/* 158 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 159 */           param1JsonReader.nextNull();
/* 160 */           return null;
/*     */         } 
/* 162 */         return Boolean.valueOf(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Boolean param1Boolean) throws IOException {
/* 166 */         param1JsonWriter.value((param1Boolean == null) ? "null" : param1Boolean.toString());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 171 */   public static final TypeAdapterFactory BOOLEAN_FACTORY = newFactory(boolean.class, (Class)Boolean.class, (TypeAdapter)BOOLEAN);
/*     */   
/* 173 */   public static final TypeAdapter<Number> BYTE = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 176 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 177 */           param1JsonReader.nextNull();
/* 178 */           return null;
/*     */         } 
/*     */         try {
/* 181 */           int i = param1JsonReader.nextInt();
/* 182 */           return Byte.valueOf((byte)i);
/* 183 */         } catch (NumberFormatException numberFormatException) {
/* 184 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 189 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 194 */   public static final TypeAdapterFactory BYTE_FACTORY = newFactory(byte.class, (Class)Byte.class, (TypeAdapter)BYTE);
/*     */   
/* 196 */   public static final TypeAdapter<Number> SHORT = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 199 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 200 */           param1JsonReader.nextNull();
/* 201 */           return null;
/*     */         } 
/*     */         try {
/* 204 */           return Short.valueOf((short)param1JsonReader.nextInt());
/* 205 */         } catch (NumberFormatException numberFormatException) {
/* 206 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 211 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 216 */   public static final TypeAdapterFactory SHORT_FACTORY = newFactory(short.class, (Class)Short.class, (TypeAdapter)SHORT);
/*     */   
/* 218 */   public static final TypeAdapter<Number> INTEGER = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 221 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 222 */           param1JsonReader.nextNull();
/* 223 */           return null;
/*     */         } 
/*     */         try {
/* 226 */           return Integer.valueOf(param1JsonReader.nextInt());
/* 227 */         } catch (NumberFormatException numberFormatException) {
/* 228 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 233 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */   
/* 237 */   public static final TypeAdapterFactory INTEGER_FACTORY = newFactory(int.class, (Class)Integer.class, (TypeAdapter)INTEGER);
/*     */   
/* 239 */   public static final TypeAdapter<AtomicInteger> ATOMIC_INTEGER = (new TypeAdapter<AtomicInteger>() {
/*     */       public AtomicInteger read(JsonReader param1JsonReader) throws IOException {
/*     */         try {
/* 242 */           return new AtomicInteger(param1JsonReader.nextInt());
/* 243 */         } catch (NumberFormatException numberFormatException) {
/* 244 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       public void write(JsonWriter param1JsonWriter, AtomicInteger param1AtomicInteger) throws IOException {
/* 248 */         param1JsonWriter.value(param1AtomicInteger.get());
/*     */       }
/* 250 */     }).nullSafe();
/*     */   
/* 252 */   public static final TypeAdapterFactory ATOMIC_INTEGER_FACTORY = newFactory(AtomicInteger.class, ATOMIC_INTEGER);
/*     */   
/* 254 */   public static final TypeAdapter<AtomicBoolean> ATOMIC_BOOLEAN = (new TypeAdapter<AtomicBoolean>() {
/*     */       public AtomicBoolean read(JsonReader param1JsonReader) throws IOException {
/* 256 */         return new AtomicBoolean(param1JsonReader.nextBoolean());
/*     */       }
/*     */       public void write(JsonWriter param1JsonWriter, AtomicBoolean param1AtomicBoolean) throws IOException {
/* 259 */         param1JsonWriter.value(param1AtomicBoolean.get());
/*     */       }
/* 261 */     }).nullSafe();
/*     */   
/* 263 */   public static final TypeAdapterFactory ATOMIC_BOOLEAN_FACTORY = newFactory(AtomicBoolean.class, ATOMIC_BOOLEAN);
/*     */   
/* 265 */   public static final TypeAdapter<AtomicIntegerArray> ATOMIC_INTEGER_ARRAY = (new TypeAdapter<AtomicIntegerArray>() {
/*     */       public AtomicIntegerArray read(JsonReader param1JsonReader) throws IOException {
/* 267 */         ArrayList<Integer> arrayList = new ArrayList();
/* 268 */         param1JsonReader.beginArray();
/* 269 */         while (param1JsonReader.hasNext()) {
/*     */           try {
/* 271 */             int j = param1JsonReader.nextInt();
/* 272 */             arrayList.add(Integer.valueOf(j));
/* 273 */           } catch (NumberFormatException numberFormatException) {
/* 274 */             throw new JsonSyntaxException(numberFormatException);
/*     */           } 
/*     */         } 
/* 277 */         param1JsonReader.endArray();
/* 278 */         int i = arrayList.size();
/* 279 */         AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(i);
/* 280 */         for (byte b = 0; b < i; b++) {
/* 281 */           atomicIntegerArray.set(b, ((Integer)arrayList.get(b)).intValue());
/*     */         }
/* 283 */         return atomicIntegerArray;
/*     */       }
/*     */       public void write(JsonWriter param1JsonWriter, AtomicIntegerArray param1AtomicIntegerArray) throws IOException {
/* 286 */         param1JsonWriter.beginArray(); byte b; int i;
/* 287 */         for (b = 0, i = param1AtomicIntegerArray.length(); b < i; b++) {
/* 288 */           param1JsonWriter.value(param1AtomicIntegerArray.get(b));
/*     */         }
/* 290 */         param1JsonWriter.endArray();
/*     */       }
/* 292 */     }).nullSafe();
/*     */   
/* 294 */   public static final TypeAdapterFactory ATOMIC_INTEGER_ARRAY_FACTORY = newFactory(AtomicIntegerArray.class, ATOMIC_INTEGER_ARRAY);
/*     */   
/* 296 */   public static final TypeAdapter<Number> LONG = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 299 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 300 */           param1JsonReader.nextNull();
/* 301 */           return null;
/*     */         } 
/*     */         try {
/* 304 */           return Long.valueOf(param1JsonReader.nextLong());
/* 305 */         } catch (NumberFormatException numberFormatException) {
/* 306 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 311 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */   
/* 315 */   public static final TypeAdapter<Number> FLOAT = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 318 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 319 */           param1JsonReader.nextNull();
/* 320 */           return null;
/*     */         } 
/* 322 */         return Float.valueOf((float)param1JsonReader.nextDouble());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 326 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */   
/* 330 */   public static final TypeAdapter<Number> DOUBLE = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 333 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 334 */           param1JsonReader.nextNull();
/* 335 */           return null;
/*     */         } 
/* 337 */         return Double.valueOf(param1JsonReader.nextDouble());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 341 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */   
/* 345 */   public static final TypeAdapter<Number> NUMBER = new TypeAdapter<Number>()
/*     */     {
/*     */       public Number read(JsonReader param1JsonReader) throws IOException {
/* 348 */         JsonToken jsonToken = param1JsonReader.peek();
/* 349 */         switch (jsonToken) {
/*     */           case NULL:
/* 351 */             param1JsonReader.nextNull();
/* 352 */             return null;
/*     */           case NUMBER:
/*     */           case STRING:
/* 355 */             return (Number)new LazilyParsedNumber(param1JsonReader.nextString());
/*     */         } 
/* 357 */         throw new JsonSyntaxException("Expecting number, got: " + jsonToken);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/* 362 */         param1JsonWriter.value(param1Number);
/*     */       }
/*     */     };
/*     */   
/* 366 */   public static final TypeAdapterFactory NUMBER_FACTORY = newFactory(Number.class, NUMBER);
/*     */   
/* 368 */   public static final TypeAdapter<Character> CHARACTER = new TypeAdapter<Character>()
/*     */     {
/*     */       public Character read(JsonReader param1JsonReader) throws IOException {
/* 371 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 372 */           param1JsonReader.nextNull();
/* 373 */           return null;
/*     */         } 
/* 375 */         String str = param1JsonReader.nextString();
/* 376 */         if (str.length() != 1) {
/* 377 */           throw new JsonSyntaxException("Expecting character, got: " + str);
/*     */         }
/* 379 */         return Character.valueOf(str.charAt(0));
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Character param1Character) throws IOException {
/* 383 */         param1JsonWriter.value((param1Character == null) ? null : String.valueOf(param1Character));
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 388 */   public static final TypeAdapterFactory CHARACTER_FACTORY = newFactory(char.class, (Class)Character.class, (TypeAdapter)CHARACTER);
/*     */   
/* 390 */   public static final TypeAdapter<String> STRING = new TypeAdapter<String>()
/*     */     {
/*     */       public String read(JsonReader param1JsonReader) throws IOException {
/* 393 */         JsonToken jsonToken = param1JsonReader.peek();
/* 394 */         if (jsonToken == JsonToken.NULL) {
/* 395 */           param1JsonReader.nextNull();
/* 396 */           return null;
/*     */         } 
/*     */         
/* 399 */         if (jsonToken == JsonToken.BOOLEAN) {
/* 400 */           return Boolean.toString(param1JsonReader.nextBoolean());
/*     */         }
/* 402 */         return param1JsonReader.nextString();
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, String param1String) throws IOException {
/* 406 */         param1JsonWriter.value(param1String);
/*     */       }
/*     */     };
/*     */   
/* 410 */   public static final TypeAdapter<BigDecimal> BIG_DECIMAL = new TypeAdapter<BigDecimal>() {
/*     */       public BigDecimal read(JsonReader param1JsonReader) throws IOException {
/* 412 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 413 */           param1JsonReader.nextNull();
/* 414 */           return null;
/*     */         } 
/*     */         try {
/* 417 */           return new BigDecimal(param1JsonReader.nextString());
/* 418 */         } catch (NumberFormatException numberFormatException) {
/* 419 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, BigDecimal param1BigDecimal) throws IOException {
/* 424 */         param1JsonWriter.value(param1BigDecimal);
/*     */       }
/*     */     };
/*     */   
/* 428 */   public static final TypeAdapter<BigInteger> BIG_INTEGER = new TypeAdapter<BigInteger>() {
/*     */       public BigInteger read(JsonReader param1JsonReader) throws IOException {
/* 430 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 431 */           param1JsonReader.nextNull();
/* 432 */           return null;
/*     */         } 
/*     */         try {
/* 435 */           return new BigInteger(param1JsonReader.nextString());
/* 436 */         } catch (NumberFormatException numberFormatException) {
/* 437 */           throw new JsonSyntaxException(numberFormatException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, BigInteger param1BigInteger) throws IOException {
/* 442 */         param1JsonWriter.value(param1BigInteger);
/*     */       }
/*     */     };
/*     */   
/* 446 */   public static final TypeAdapterFactory STRING_FACTORY = newFactory(String.class, STRING);
/*     */   
/* 448 */   public static final TypeAdapter<StringBuilder> STRING_BUILDER = new TypeAdapter<StringBuilder>()
/*     */     {
/*     */       public StringBuilder read(JsonReader param1JsonReader) throws IOException {
/* 451 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 452 */           param1JsonReader.nextNull();
/* 453 */           return null;
/*     */         } 
/* 455 */         return new StringBuilder(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, StringBuilder param1StringBuilder) throws IOException {
/* 459 */         param1JsonWriter.value((param1StringBuilder == null) ? null : param1StringBuilder.toString());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 464 */   public static final TypeAdapterFactory STRING_BUILDER_FACTORY = newFactory(StringBuilder.class, STRING_BUILDER);
/*     */   
/* 466 */   public static final TypeAdapter<StringBuffer> STRING_BUFFER = new TypeAdapter<StringBuffer>()
/*     */     {
/*     */       public StringBuffer read(JsonReader param1JsonReader) throws IOException {
/* 469 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 470 */           param1JsonReader.nextNull();
/* 471 */           return null;
/*     */         } 
/* 473 */         return new StringBuffer(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, StringBuffer param1StringBuffer) throws IOException {
/* 477 */         param1JsonWriter.value((param1StringBuffer == null) ? null : param1StringBuffer.toString());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 482 */   public static final TypeAdapterFactory STRING_BUFFER_FACTORY = newFactory(StringBuffer.class, STRING_BUFFER);
/*     */   
/* 484 */   public static final TypeAdapter<URL> URL = new TypeAdapter<URL>()
/*     */     {
/*     */       public URL read(JsonReader param1JsonReader) throws IOException {
/* 487 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 488 */           param1JsonReader.nextNull();
/* 489 */           return null;
/*     */         } 
/* 491 */         String str = param1JsonReader.nextString();
/* 492 */         return "null".equals(str) ? null : new URL(str);
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, URL param1URL) throws IOException {
/* 496 */         param1JsonWriter.value((param1URL == null) ? null : param1URL.toExternalForm());
/*     */       }
/*     */     };
/*     */   
/* 500 */   public static final TypeAdapterFactory URL_FACTORY = newFactory(URL.class, URL);
/*     */   
/* 502 */   public static final TypeAdapter<URI> URI = new TypeAdapter<URI>()
/*     */     {
/*     */       public URI read(JsonReader param1JsonReader) throws IOException {
/* 505 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 506 */           param1JsonReader.nextNull();
/* 507 */           return null;
/*     */         } 
/*     */         try {
/* 510 */           String str = param1JsonReader.nextString();
/* 511 */           return "null".equals(str) ? null : new URI(str);
/* 512 */         } catch (URISyntaxException uRISyntaxException) {
/* 513 */           throw new JsonIOException(uRISyntaxException);
/*     */         } 
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, URI param1URI) throws IOException {
/* 518 */         param1JsonWriter.value((param1URI == null) ? null : param1URI.toASCIIString());
/*     */       }
/*     */     };
/*     */   
/* 522 */   public static final TypeAdapterFactory URI_FACTORY = newFactory(URI.class, URI);
/*     */   
/* 524 */   public static final TypeAdapter<InetAddress> INET_ADDRESS = new TypeAdapter<InetAddress>()
/*     */     {
/*     */       public InetAddress read(JsonReader param1JsonReader) throws IOException {
/* 527 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 528 */           param1JsonReader.nextNull();
/* 529 */           return null;
/*     */         } 
/*     */         
/* 532 */         return InetAddress.getByName(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, InetAddress param1InetAddress) throws IOException {
/* 536 */         param1JsonWriter.value((param1InetAddress == null) ? null : param1InetAddress.getHostAddress());
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 541 */   public static final TypeAdapterFactory INET_ADDRESS_FACTORY = newTypeHierarchyFactory(InetAddress.class, INET_ADDRESS);
/*     */   
/* 543 */   public static final TypeAdapter<UUID> UUID = new TypeAdapter<UUID>()
/*     */     {
/*     */       public UUID read(JsonReader param1JsonReader) throws IOException {
/* 546 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 547 */           param1JsonReader.nextNull();
/* 548 */           return null;
/*     */         } 
/* 550 */         return UUID.fromString(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, UUID param1UUID) throws IOException {
/* 554 */         param1JsonWriter.value((param1UUID == null) ? null : param1UUID.toString());
/*     */       }
/*     */     };
/*     */   
/* 558 */   public static final TypeAdapterFactory UUID_FACTORY = newFactory(UUID.class, UUID);
/*     */   
/* 560 */   public static final TypeAdapter<Currency> CURRENCY = (new TypeAdapter<Currency>()
/*     */     {
/*     */       public Currency read(JsonReader param1JsonReader) throws IOException {
/* 563 */         return Currency.getInstance(param1JsonReader.nextString());
/*     */       }
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Currency param1Currency) throws IOException {
/* 567 */         param1JsonWriter.value(param1Currency.getCurrencyCode());
/*     */       }
/* 569 */     }).nullSafe();
/* 570 */   public static final TypeAdapterFactory CURRENCY_FACTORY = newFactory(Currency.class, CURRENCY);
/*     */   
/* 572 */   public static final TypeAdapterFactory TIMESTAMP_FACTORY = new TypeAdapterFactory()
/*     */     {
/*     */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 575 */         if (param1TypeToken.getRawType() != Timestamp.class) {
/* 576 */           return null;
/*     */         }
/*     */         
/* 579 */         final TypeAdapter dateTypeAdapter = param1Gson.getAdapter(Date.class);
/* 580 */         return (TypeAdapter)new TypeAdapter<Timestamp>() {
/*     */             public Timestamp read(JsonReader param2JsonReader) throws IOException {
/* 582 */               Date date = (Date)dateTypeAdapter.read(param2JsonReader);
/* 583 */               return (date != null) ? new Timestamp(date.getTime()) : null;
/*     */             }
/*     */             
/*     */             public void write(JsonWriter param2JsonWriter, Timestamp param2Timestamp) throws IOException {
/* 587 */               dateTypeAdapter.write(param2JsonWriter, param2Timestamp);
/*     */             }
/*     */           };
/*     */       }
/*     */     };
/*     */   
/* 593 */   public static final TypeAdapter<Calendar> CALENDAR = new TypeAdapter<Calendar>()
/*     */     {
/*     */       private static final String YEAR = "year";
/*     */       private static final String MONTH = "month";
/*     */       private static final String DAY_OF_MONTH = "dayOfMonth";
/*     */       private static final String HOUR_OF_DAY = "hourOfDay";
/*     */       private static final String MINUTE = "minute";
/*     */       private static final String SECOND = "second";
/*     */       
/*     */       public Calendar read(JsonReader param1JsonReader) throws IOException {
/* 603 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 604 */           param1JsonReader.nextNull();
/* 605 */           return null;
/*     */         } 
/* 607 */         param1JsonReader.beginObject();
/* 608 */         int i = 0;
/* 609 */         int j = 0;
/* 610 */         int k = 0;
/* 611 */         int m = 0;
/* 612 */         int n = 0;
/* 613 */         int i1 = 0;
/* 614 */         while (param1JsonReader.peek() != JsonToken.END_OBJECT) {
/* 615 */           String str = param1JsonReader.nextName();
/* 616 */           int i2 = param1JsonReader.nextInt();
/* 617 */           if ("year".equals(str)) {
/* 618 */             i = i2; continue;
/* 619 */           }  if ("month".equals(str)) {
/* 620 */             j = i2; continue;
/* 621 */           }  if ("dayOfMonth".equals(str)) {
/* 622 */             k = i2; continue;
/* 623 */           }  if ("hourOfDay".equals(str)) {
/* 624 */             m = i2; continue;
/* 625 */           }  if ("minute".equals(str)) {
/* 626 */             n = i2; continue;
/* 627 */           }  if ("second".equals(str)) {
/* 628 */             i1 = i2;
/*     */           }
/*     */         } 
/* 631 */         param1JsonReader.endObject();
/* 632 */         return new GregorianCalendar(i, j, k, m, n, i1);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Calendar param1Calendar) throws IOException {
/* 637 */         if (param1Calendar == null) {
/* 638 */           param1JsonWriter.nullValue();
/*     */           return;
/*     */         } 
/* 641 */         param1JsonWriter.beginObject();
/* 642 */         param1JsonWriter.name("year");
/* 643 */         param1JsonWriter.value(param1Calendar.get(1));
/* 644 */         param1JsonWriter.name("month");
/* 645 */         param1JsonWriter.value(param1Calendar.get(2));
/* 646 */         param1JsonWriter.name("dayOfMonth");
/* 647 */         param1JsonWriter.value(param1Calendar.get(5));
/* 648 */         param1JsonWriter.name("hourOfDay");
/* 649 */         param1JsonWriter.value(param1Calendar.get(11));
/* 650 */         param1JsonWriter.name("minute");
/* 651 */         param1JsonWriter.value(param1Calendar.get(12));
/* 652 */         param1JsonWriter.name("second");
/* 653 */         param1JsonWriter.value(param1Calendar.get(13));
/* 654 */         param1JsonWriter.endObject();
/*     */       }
/*     */     };
/*     */ 
/*     */   
/* 659 */   public static final TypeAdapterFactory CALENDAR_FACTORY = newFactoryForMultipleTypes(Calendar.class, (Class)GregorianCalendar.class, CALENDAR);
/*     */   
/* 661 */   public static final TypeAdapter<Locale> LOCALE = new TypeAdapter<Locale>()
/*     */     {
/*     */       public Locale read(JsonReader param1JsonReader) throws IOException {
/* 664 */         if (param1JsonReader.peek() == JsonToken.NULL) {
/* 665 */           param1JsonReader.nextNull();
/* 666 */           return null;
/*     */         } 
/* 668 */         String str1 = param1JsonReader.nextString();
/* 669 */         StringTokenizer stringTokenizer = new StringTokenizer(str1, "_");
/* 670 */         String str2 = null;
/* 671 */         String str3 = null;
/* 672 */         String str4 = null;
/* 673 */         if (stringTokenizer.hasMoreElements()) {
/* 674 */           str2 = stringTokenizer.nextToken();
/*     */         }
/* 676 */         if (stringTokenizer.hasMoreElements()) {
/* 677 */           str3 = stringTokenizer.nextToken();
/*     */         }
/* 679 */         if (stringTokenizer.hasMoreElements()) {
/* 680 */           str4 = stringTokenizer.nextToken();
/*     */         }
/* 682 */         if (str3 == null && str4 == null)
/* 683 */           return new Locale(str2); 
/* 684 */         if (str4 == null) {
/* 685 */           return new Locale(str2, str3);
/*     */         }
/* 687 */         return new Locale(str2, str3, str4);
/*     */       }
/*     */ 
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, Locale param1Locale) throws IOException {
/* 692 */         param1JsonWriter.value((param1Locale == null) ? null : param1Locale.toString());
/*     */       }
/*     */     };
/*     */   
/* 696 */   public static final TypeAdapterFactory LOCALE_FACTORY = newFactory(Locale.class, LOCALE);
/*     */   
/* 698 */   public static final TypeAdapter<JsonElement> JSON_ELEMENT = new TypeAdapter<JsonElement>() { public JsonElement read(JsonReader param1JsonReader) throws IOException { String str; JsonArray jsonArray;
/*     */         JsonObject jsonObject;
/* 700 */         switch (param1JsonReader.peek()) {
/*     */           case STRING:
/* 702 */             return (JsonElement)new JsonPrimitive(param1JsonReader.nextString());
/*     */           case NUMBER:
/* 704 */             str = param1JsonReader.nextString();
/* 705 */             return (JsonElement)new JsonPrimitive((Number)new LazilyParsedNumber(str));
/*     */           case BOOLEAN:
/* 707 */             return (JsonElement)new JsonPrimitive(Boolean.valueOf(param1JsonReader.nextBoolean()));
/*     */           case NULL:
/* 709 */             param1JsonReader.nextNull();
/* 710 */             return (JsonElement)JsonNull.INSTANCE;
/*     */           case BEGIN_ARRAY:
/* 712 */             jsonArray = new JsonArray();
/* 713 */             param1JsonReader.beginArray();
/* 714 */             while (param1JsonReader.hasNext()) {
/* 715 */               jsonArray.add(read(param1JsonReader));
/*     */             }
/* 717 */             param1JsonReader.endArray();
/* 718 */             return (JsonElement)jsonArray;
/*     */           case BEGIN_OBJECT:
/* 720 */             jsonObject = new JsonObject();
/* 721 */             param1JsonReader.beginObject();
/* 722 */             while (param1JsonReader.hasNext()) {
/* 723 */               jsonObject.add(param1JsonReader.nextName(), read(param1JsonReader));
/*     */             }
/* 725 */             param1JsonReader.endObject();
/* 726 */             return (JsonElement)jsonObject;
/*     */         } 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 732 */         throw new IllegalArgumentException(); }
/*     */ 
/*     */ 
/*     */       
/*     */       public void write(JsonWriter param1JsonWriter, JsonElement param1JsonElement) throws IOException {
/* 737 */         if (param1JsonElement == null || param1JsonElement.isJsonNull()) {
/* 738 */           param1JsonWriter.nullValue();
/* 739 */         } else if (param1JsonElement.isJsonPrimitive()) {
/* 740 */           JsonPrimitive jsonPrimitive = param1JsonElement.getAsJsonPrimitive();
/* 741 */           if (jsonPrimitive.isNumber()) {
/* 742 */             param1JsonWriter.value(jsonPrimitive.getAsNumber());
/* 743 */           } else if (jsonPrimitive.isBoolean()) {
/* 744 */             param1JsonWriter.value(jsonPrimitive.getAsBoolean());
/*     */           } else {
/* 746 */             param1JsonWriter.value(jsonPrimitive.getAsString());
/*     */           }
/*     */         
/* 749 */         } else if (param1JsonElement.isJsonArray()) {
/* 750 */           param1JsonWriter.beginArray();
/* 751 */           for (JsonElement jsonElement : param1JsonElement.getAsJsonArray()) {
/* 752 */             write(param1JsonWriter, jsonElement);
/*     */           }
/* 754 */           param1JsonWriter.endArray();
/*     */         }
/* 756 */         else if (param1JsonElement.isJsonObject()) {
/* 757 */           param1JsonWriter.beginObject();
/* 758 */           for (Map.Entry entry : param1JsonElement.getAsJsonObject().entrySet()) {
/* 759 */             param1JsonWriter.name((String)entry.getKey());
/* 760 */             write(param1JsonWriter, (JsonElement)entry.getValue());
/*     */           } 
/* 762 */           param1JsonWriter.endObject();
/*     */         } else {
/*     */           
/* 765 */           throw new IllegalArgumentException("Couldn't write " + param1JsonElement.getClass());
/*     */         } 
/*     */       } }
/*     */   ;
/*     */ 
/*     */   
/* 771 */   public static final TypeAdapterFactory JSON_ELEMENT_FACTORY = newTypeHierarchyFactory(JsonElement.class, JSON_ELEMENT);
/*     */   
/*     */   private static final class EnumTypeAdapter<T extends Enum<T>> extends TypeAdapter<T> {
/* 774 */     private final Map<String, T> nameToConstant = new HashMap<String, T>();
/* 775 */     private final Map<T, String> constantToName = new HashMap<T, String>();
/*     */     
/*     */     public EnumTypeAdapter(Class<T> param1Class) {
/*     */       try {
/* 779 */         for (Enum enum_ : (Enum[])param1Class.getEnumConstants()) {
/* 780 */           String str = enum_.name();
/* 781 */           SerializedName serializedName = param1Class.getField(str).<SerializedName>getAnnotation(SerializedName.class);
/* 782 */           if (serializedName != null) {
/* 783 */             str = serializedName.value();
/* 784 */             for (String str1 : serializedName.alternate()) {
/* 785 */               this.nameToConstant.put(str1, (T)enum_);
/*     */             }
/*     */           } 
/* 788 */           this.nameToConstant.put(str, (T)enum_);
/* 789 */           this.constantToName.put((T)enum_, str);
/*     */         } 
/* 791 */       } catch (NoSuchFieldException noSuchFieldException) {
/* 792 */         throw new AssertionError(noSuchFieldException);
/*     */       } 
/*     */     }
/*     */     public T read(JsonReader param1JsonReader) throws IOException {
/* 796 */       if (param1JsonReader.peek() == JsonToken.NULL) {
/* 797 */         param1JsonReader.nextNull();
/* 798 */         return null;
/*     */       } 
/* 800 */       return this.nameToConstant.get(param1JsonReader.nextString());
/*     */     }
/*     */     
/*     */     public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
/* 804 */       param1JsonWriter.value((param1T == null) ? null : this.constantToName.get(param1T));
/*     */     }
/*     */   }
/*     */   
/* 808 */   public static final TypeAdapterFactory ENUM_FACTORY = new TypeAdapterFactory()
/*     */     {
/*     */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 811 */         Class<?> clazz = param1TypeToken.getRawType();
/* 812 */         if (!Enum.class.isAssignableFrom(clazz) || clazz == Enum.class) {
/* 813 */           return null;
/*     */         }
/* 815 */         if (!clazz.isEnum()) {
/* 816 */           clazz = clazz.getSuperclass();
/*     */         }
/* 818 */         return new TypeAdapters.EnumTypeAdapter(clazz);
/*     */       }
/*     */     };
/*     */ 
/*     */   
/*     */   public static <TT> TypeAdapterFactory newFactory(final TypeToken<TT> type, final TypeAdapter<TT> typeAdapter) {
/* 824 */     return new TypeAdapterFactory()
/*     */       {
/*     */         public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 827 */           return param1TypeToken.equals(type) ? typeAdapter : null;
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static <TT> TypeAdapterFactory newFactory(final Class<TT> type, final TypeAdapter<TT> typeAdapter) {
/* 834 */     return new TypeAdapterFactory()
/*     */       {
/*     */         public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 837 */           return (param1TypeToken.getRawType() == type) ? typeAdapter : null;
/*     */         }
/*     */         public String toString() {
/* 840 */           return "Factory[type=" + type.getName() + ",adapter=" + typeAdapter + "]";
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static <TT> TypeAdapterFactory newFactory(final Class<TT> unboxed, final Class<TT> boxed, final TypeAdapter<? super TT> typeAdapter) {
/* 847 */     return new TypeAdapterFactory()
/*     */       {
/*     */         public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 850 */           Class clazz = param1TypeToken.getRawType();
/* 851 */           return (clazz == unboxed || clazz == boxed) ? typeAdapter : null;
/*     */         }
/*     */         public String toString() {
/* 854 */           return "Factory[type=" + boxed.getName() + "+" + unboxed
/* 855 */             .getName() + ",adapter=" + typeAdapter + "]";
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */   
/*     */   public static <TT> TypeAdapterFactory newFactoryForMultipleTypes(final Class<TT> base, final Class<? extends TT> sub, final TypeAdapter<? super TT> typeAdapter) {
/* 862 */     return new TypeAdapterFactory()
/*     */       {
/*     */         public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 865 */           Class clazz = param1TypeToken.getRawType();
/* 866 */           return (clazz == base || clazz == sub) ? typeAdapter : null;
/*     */         }
/*     */         public String toString() {
/* 869 */           return "Factory[type=" + base.getName() + "+" + sub
/* 870 */             .getName() + ",adapter=" + typeAdapter + "]";
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static <T1> TypeAdapterFactory newTypeHierarchyFactory(final Class<T1> clazz, final TypeAdapter<T1> typeAdapter) {
/* 881 */     return new TypeAdapterFactory()
/*     */       {
/*     */         public <T2> TypeAdapter<T2> create(Gson param1Gson, TypeToken<T2> param1TypeToken) {
/* 884 */           final Class<?> requestedType = param1TypeToken.getRawType();
/* 885 */           if (!clazz.isAssignableFrom(clazz)) {
/* 886 */             return null;
/*     */           }
/* 888 */           return new TypeAdapter<T1>() {
/*     */               public void write(JsonWriter param2JsonWriter, T1 param2T1) throws IOException {
/* 890 */                 typeAdapter.write(param2JsonWriter, param2T1);
/*     */               }
/*     */               
/*     */               public T1 read(JsonReader param2JsonReader) throws IOException {
/* 894 */                 Object object = typeAdapter.read(param2JsonReader);
/* 895 */                 if (object != null && !requestedType.isInstance(object)) {
/* 896 */                   throw new JsonSyntaxException("Expected a " + requestedType.getName() + " but was " + object
/* 897 */                       .getClass().getName());
/*     */                 }
/* 899 */                 return (T1)object;
/*     */               }
/*     */             };
/*     */         }
/*     */         public String toString() {
/* 904 */           return "Factory[typeHierarchy=" + clazz.getName() + ",adapter=" + typeAdapter + "]";
/*     */         }
/*     */       };
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\TypeAdapters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */