/*      */ package com.google.gson;
/*      */ 
/*      */ import com.google.gson.internal.ConstructorConstructor;
/*      */ import com.google.gson.internal.Excluder;
/*      */ import com.google.gson.internal.Primitives;
/*      */ import com.google.gson.internal.Streams;
/*      */ import com.google.gson.internal.bind.ArrayTypeAdapter;
/*      */ import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
/*      */ import com.google.gson.internal.bind.DateTypeAdapter;
/*      */ import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
/*      */ import com.google.gson.internal.bind.JsonTreeReader;
/*      */ import com.google.gson.internal.bind.JsonTreeWriter;
/*      */ import com.google.gson.internal.bind.MapTypeAdapterFactory;
/*      */ import com.google.gson.internal.bind.ObjectTypeAdapter;
/*      */ import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
/*      */ import com.google.gson.internal.bind.SqlDateTypeAdapter;
/*      */ import com.google.gson.internal.bind.TimeTypeAdapter;
/*      */ import com.google.gson.internal.bind.TypeAdapters;
/*      */ import com.google.gson.reflect.TypeToken;
/*      */ import com.google.gson.stream.JsonReader;
/*      */ import com.google.gson.stream.JsonToken;
/*      */ import com.google.gson.stream.JsonWriter;
/*      */ import com.google.gson.stream.MalformedJsonException;
/*      */ import java.io.EOFException;
/*      */ import java.io.IOException;
/*      */ import java.io.Reader;
/*      */ import java.io.StringReader;
/*      */ import java.io.StringWriter;
/*      */ import java.io.Writer;
/*      */ import java.lang.reflect.Type;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.concurrent.ConcurrentHashMap;
/*      */ import java.util.concurrent.atomic.AtomicLong;
/*      */ import java.util.concurrent.atomic.AtomicLongArray;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public final class Gson
/*      */ {
/*      */   static final boolean DEFAULT_JSON_NON_EXECUTABLE = false;
/*      */   static final boolean DEFAULT_LENIENT = false;
/*      */   static final boolean DEFAULT_PRETTY_PRINT = false;
/*      */   static final boolean DEFAULT_ESCAPE_HTML = true;
/*      */   static final boolean DEFAULT_SERIALIZE_NULLS = false;
/*      */   static final boolean DEFAULT_COMPLEX_MAP_KEYS = false;
/*      */   static final boolean DEFAULT_SPECIALIZE_FLOAT_VALUES = false;
/*  114 */   private static final TypeToken<?> NULL_KEY_SURROGATE = TypeToken.get(Object.class);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String JSON_NON_EXECUTABLE_PREFIX = ")]}'\n";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  124 */   private final ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>> calls = new ThreadLocal<Map<TypeToken<?>, FutureTypeAdapter<?>>>();
/*      */ 
/*      */   
/*  127 */   private final Map<TypeToken<?>, TypeAdapter<?>> typeTokenCache = new ConcurrentHashMap<TypeToken<?>, TypeAdapter<?>>();
/*      */ 
/*      */   
/*      */   private final ConstructorConstructor constructorConstructor;
/*      */ 
/*      */   
/*      */   private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
/*      */ 
/*      */   
/*      */   final List<TypeAdapterFactory> factories;
/*      */ 
/*      */   
/*      */   final Excluder excluder;
/*      */ 
/*      */   
/*      */   final FieldNamingStrategy fieldNamingStrategy;
/*      */ 
/*      */   
/*      */   final Map<Type, InstanceCreator<?>> instanceCreators;
/*      */ 
/*      */   
/*      */   final boolean serializeNulls;
/*      */ 
/*      */   
/*      */   final boolean complexMapKeySerialization;
/*      */ 
/*      */   
/*      */   final boolean generateNonExecutableJson;
/*      */ 
/*      */   
/*      */   final boolean htmlSafe;
/*      */ 
/*      */   
/*      */   final boolean prettyPrinting;
/*      */ 
/*      */   
/*      */   final boolean lenient;
/*      */ 
/*      */   
/*      */   final boolean serializeSpecialFloatingPointValues;
/*      */ 
/*      */   
/*      */   final String datePattern;
/*      */ 
/*      */   
/*      */   final int dateStyle;
/*      */ 
/*      */   
/*      */   final int timeStyle;
/*      */ 
/*      */   
/*      */   final LongSerializationPolicy longSerializationPolicy;
/*      */   
/*      */   final List<TypeAdapterFactory> builderFactories;
/*      */   
/*      */   final List<TypeAdapterFactory> builderHierarchyFactories;
/*      */ 
/*      */   
/*      */   public Gson() {
/*  186 */     this(Excluder.DEFAULT, FieldNamingPolicy.IDENTITY, 
/*  187 */         Collections.emptyMap(), false, false, false, true, false, false, false, LongSerializationPolicy.DEFAULT, null, 2, 2, 
/*      */ 
/*      */ 
/*      */         
/*  191 */         Collections.emptyList(), Collections.emptyList(), 
/*  192 */         Collections.emptyList());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   Gson(Excluder paramExcluder, FieldNamingStrategy paramFieldNamingStrategy, Map<Type, InstanceCreator<?>> paramMap, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7, LongSerializationPolicy paramLongSerializationPolicy, String paramString, int paramInt1, int paramInt2, List<TypeAdapterFactory> paramList1, List<TypeAdapterFactory> paramList2, List<TypeAdapterFactory> paramList3) {
/*  203 */     this.excluder = paramExcluder;
/*  204 */     this.fieldNamingStrategy = paramFieldNamingStrategy;
/*  205 */     this.instanceCreators = paramMap;
/*  206 */     this.constructorConstructor = new ConstructorConstructor(paramMap);
/*  207 */     this.serializeNulls = paramBoolean1;
/*  208 */     this.complexMapKeySerialization = paramBoolean2;
/*  209 */     this.generateNonExecutableJson = paramBoolean3;
/*  210 */     this.htmlSafe = paramBoolean4;
/*  211 */     this.prettyPrinting = paramBoolean5;
/*  212 */     this.lenient = paramBoolean6;
/*  213 */     this.serializeSpecialFloatingPointValues = paramBoolean7;
/*  214 */     this.longSerializationPolicy = paramLongSerializationPolicy;
/*  215 */     this.datePattern = paramString;
/*  216 */     this.dateStyle = paramInt1;
/*  217 */     this.timeStyle = paramInt2;
/*  218 */     this.builderFactories = paramList1;
/*  219 */     this.builderHierarchyFactories = paramList2;
/*      */     
/*  221 */     ArrayList<TypeAdapterFactory> arrayList = new ArrayList();
/*      */ 
/*      */     
/*  224 */     arrayList.add(TypeAdapters.JSON_ELEMENT_FACTORY);
/*  225 */     arrayList.add(ObjectTypeAdapter.FACTORY);
/*      */ 
/*      */     
/*  228 */     arrayList.add(paramExcluder);
/*      */ 
/*      */     
/*  231 */     arrayList.addAll(paramList3);
/*      */ 
/*      */     
/*  234 */     arrayList.add(TypeAdapters.STRING_FACTORY);
/*  235 */     arrayList.add(TypeAdapters.INTEGER_FACTORY);
/*  236 */     arrayList.add(TypeAdapters.BOOLEAN_FACTORY);
/*  237 */     arrayList.add(TypeAdapters.BYTE_FACTORY);
/*  238 */     arrayList.add(TypeAdapters.SHORT_FACTORY);
/*  239 */     TypeAdapter<Number> typeAdapter = longAdapter(paramLongSerializationPolicy);
/*  240 */     arrayList.add(TypeAdapters.newFactory(long.class, Long.class, typeAdapter));
/*  241 */     arrayList.add(TypeAdapters.newFactory(double.class, Double.class, 
/*  242 */           doubleAdapter(paramBoolean7)));
/*  243 */     arrayList.add(TypeAdapters.newFactory(float.class, Float.class, 
/*  244 */           floatAdapter(paramBoolean7)));
/*  245 */     arrayList.add(TypeAdapters.NUMBER_FACTORY);
/*  246 */     arrayList.add(TypeAdapters.ATOMIC_INTEGER_FACTORY);
/*  247 */     arrayList.add(TypeAdapters.ATOMIC_BOOLEAN_FACTORY);
/*  248 */     arrayList.add(TypeAdapters.newFactory(AtomicLong.class, atomicLongAdapter(typeAdapter)));
/*  249 */     arrayList.add(TypeAdapters.newFactory(AtomicLongArray.class, atomicLongArrayAdapter(typeAdapter)));
/*  250 */     arrayList.add(TypeAdapters.ATOMIC_INTEGER_ARRAY_FACTORY);
/*  251 */     arrayList.add(TypeAdapters.CHARACTER_FACTORY);
/*  252 */     arrayList.add(TypeAdapters.STRING_BUILDER_FACTORY);
/*  253 */     arrayList.add(TypeAdapters.STRING_BUFFER_FACTORY);
/*  254 */     arrayList.add(TypeAdapters.newFactory(BigDecimal.class, TypeAdapters.BIG_DECIMAL));
/*  255 */     arrayList.add(TypeAdapters.newFactory(BigInteger.class, TypeAdapters.BIG_INTEGER));
/*  256 */     arrayList.add(TypeAdapters.URL_FACTORY);
/*  257 */     arrayList.add(TypeAdapters.URI_FACTORY);
/*  258 */     arrayList.add(TypeAdapters.UUID_FACTORY);
/*  259 */     arrayList.add(TypeAdapters.CURRENCY_FACTORY);
/*  260 */     arrayList.add(TypeAdapters.LOCALE_FACTORY);
/*  261 */     arrayList.add(TypeAdapters.INET_ADDRESS_FACTORY);
/*  262 */     arrayList.add(TypeAdapters.BIT_SET_FACTORY);
/*  263 */     arrayList.add(DateTypeAdapter.FACTORY);
/*  264 */     arrayList.add(TypeAdapters.CALENDAR_FACTORY);
/*  265 */     arrayList.add(TimeTypeAdapter.FACTORY);
/*  266 */     arrayList.add(SqlDateTypeAdapter.FACTORY);
/*  267 */     arrayList.add(TypeAdapters.TIMESTAMP_FACTORY);
/*  268 */     arrayList.add(ArrayTypeAdapter.FACTORY);
/*  269 */     arrayList.add(TypeAdapters.CLASS_FACTORY);
/*      */ 
/*      */     
/*  272 */     arrayList.add(new CollectionTypeAdapterFactory(this.constructorConstructor));
/*  273 */     arrayList.add(new MapTypeAdapterFactory(this.constructorConstructor, paramBoolean2));
/*  274 */     this.jsonAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(this.constructorConstructor);
/*  275 */     arrayList.add(this.jsonAdapterFactory);
/*  276 */     arrayList.add(TypeAdapters.ENUM_FACTORY);
/*  277 */     arrayList.add(new ReflectiveTypeAdapterFactory(this.constructorConstructor, paramFieldNamingStrategy, paramExcluder, this.jsonAdapterFactory));
/*      */ 
/*      */     
/*  280 */     this.factories = Collections.unmodifiableList(arrayList);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public GsonBuilder newBuilder() {
/*  290 */     return new GsonBuilder(this);
/*      */   }
/*      */   
/*      */   public Excluder excluder() {
/*  294 */     return this.excluder;
/*      */   }
/*      */   
/*      */   public FieldNamingStrategy fieldNamingStrategy() {
/*  298 */     return this.fieldNamingStrategy;
/*      */   }
/*      */   
/*      */   public boolean serializeNulls() {
/*  302 */     return this.serializeNulls;
/*      */   }
/*      */   
/*      */   public boolean htmlSafe() {
/*  306 */     return this.htmlSafe;
/*      */   }
/*      */   
/*      */   private TypeAdapter<Number> doubleAdapter(boolean paramBoolean) {
/*  310 */     if (paramBoolean) {
/*  311 */       return TypeAdapters.DOUBLE;
/*      */     }
/*  313 */     return new TypeAdapter<Number>() {
/*      */         public Double read(JsonReader param1JsonReader) throws IOException {
/*  315 */           if (param1JsonReader.peek() == JsonToken.NULL) {
/*  316 */             param1JsonReader.nextNull();
/*  317 */             return null;
/*      */           } 
/*  319 */           return Double.valueOf(param1JsonReader.nextDouble());
/*      */         }
/*      */         public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/*  322 */           if (param1Number == null) {
/*  323 */             param1JsonWriter.nullValue();
/*      */             return;
/*      */           } 
/*  326 */           double d = param1Number.doubleValue();
/*  327 */           Gson.checkValidFloatingPoint(d);
/*  328 */           param1JsonWriter.value(param1Number);
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   private TypeAdapter<Number> floatAdapter(boolean paramBoolean) {
/*  334 */     if (paramBoolean) {
/*  335 */       return TypeAdapters.FLOAT;
/*      */     }
/*  337 */     return new TypeAdapter<Number>() {
/*      */         public Float read(JsonReader param1JsonReader) throws IOException {
/*  339 */           if (param1JsonReader.peek() == JsonToken.NULL) {
/*  340 */             param1JsonReader.nextNull();
/*  341 */             return null;
/*      */           } 
/*  343 */           return Float.valueOf((float)param1JsonReader.nextDouble());
/*      */         }
/*      */         public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/*  346 */           if (param1Number == null) {
/*  347 */             param1JsonWriter.nullValue();
/*      */             return;
/*      */           } 
/*  350 */           float f = param1Number.floatValue();
/*  351 */           Gson.checkValidFloatingPoint(f);
/*  352 */           param1JsonWriter.value(param1Number);
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   static void checkValidFloatingPoint(double paramDouble) {
/*  358 */     if (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble)) {
/*  359 */       throw new IllegalArgumentException(paramDouble + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static TypeAdapter<Number> longAdapter(LongSerializationPolicy paramLongSerializationPolicy) {
/*  366 */     if (paramLongSerializationPolicy == LongSerializationPolicy.DEFAULT) {
/*  367 */       return TypeAdapters.LONG;
/*      */     }
/*  369 */     return new TypeAdapter<Number>() {
/*      */         public Number read(JsonReader param1JsonReader) throws IOException {
/*  371 */           if (param1JsonReader.peek() == JsonToken.NULL) {
/*  372 */             param1JsonReader.nextNull();
/*  373 */             return null;
/*      */           } 
/*  375 */           return Long.valueOf(param1JsonReader.nextLong());
/*      */         }
/*      */         public void write(JsonWriter param1JsonWriter, Number param1Number) throws IOException {
/*  378 */           if (param1Number == null) {
/*  379 */             param1JsonWriter.nullValue();
/*      */             return;
/*      */           } 
/*  382 */           param1JsonWriter.value(param1Number.toString());
/*      */         }
/*      */       };
/*      */   }
/*      */   
/*      */   private static TypeAdapter<AtomicLong> atomicLongAdapter(final TypeAdapter<Number> longAdapter) {
/*  388 */     return (new TypeAdapter<AtomicLong>() {
/*      */         public void write(JsonWriter param1JsonWriter, AtomicLong param1AtomicLong) throws IOException {
/*  390 */           longAdapter.write(param1JsonWriter, Long.valueOf(param1AtomicLong.get()));
/*      */         }
/*      */         public AtomicLong read(JsonReader param1JsonReader) throws IOException {
/*  393 */           Number number = longAdapter.read(param1JsonReader);
/*  394 */           return new AtomicLong(number.longValue());
/*      */         }
/*  396 */       }).nullSafe();
/*      */   }
/*      */   
/*      */   private static TypeAdapter<AtomicLongArray> atomicLongArrayAdapter(final TypeAdapter<Number> longAdapter) {
/*  400 */     return (new TypeAdapter<AtomicLongArray>() {
/*      */         public void write(JsonWriter param1JsonWriter, AtomicLongArray param1AtomicLongArray) throws IOException {
/*  402 */           param1JsonWriter.beginArray(); byte b; int i;
/*  403 */           for (b = 0, i = param1AtomicLongArray.length(); b < i; b++) {
/*  404 */             longAdapter.write(param1JsonWriter, Long.valueOf(param1AtomicLongArray.get(b)));
/*      */           }
/*  406 */           param1JsonWriter.endArray();
/*      */         }
/*      */         public AtomicLongArray read(JsonReader param1JsonReader) throws IOException {
/*  409 */           ArrayList<Long> arrayList = new ArrayList();
/*  410 */           param1JsonReader.beginArray();
/*  411 */           while (param1JsonReader.hasNext()) {
/*  412 */             long l = ((Number)longAdapter.read(param1JsonReader)).longValue();
/*  413 */             arrayList.add(Long.valueOf(l));
/*      */           } 
/*  415 */           param1JsonReader.endArray();
/*  416 */           int i = arrayList.size();
/*  417 */           AtomicLongArray atomicLongArray = new AtomicLongArray(i);
/*  418 */           for (byte b = 0; b < i; b++) {
/*  419 */             atomicLongArray.set(b, ((Long)arrayList.get(b)).longValue());
/*      */           }
/*  421 */           return atomicLongArray;
/*      */         }
/*  423 */       }).nullSafe();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> TypeAdapter<T> getAdapter(TypeToken<T> paramTypeToken) {
/*  434 */     TypeAdapter<T> typeAdapter = (TypeAdapter)this.typeTokenCache.get((paramTypeToken == null) ? NULL_KEY_SURROGATE : paramTypeToken);
/*  435 */     if (typeAdapter != null) {
/*  436 */       return typeAdapter;
/*      */     }
/*      */     
/*  439 */     Map<Object, Object> map = (Map)this.calls.get();
/*  440 */     boolean bool = false;
/*  441 */     if (map == null) {
/*  442 */       map = new HashMap<Object, Object>();
/*  443 */       this.calls.set(map);
/*  444 */       bool = true;
/*      */     } 
/*      */ 
/*      */     
/*  448 */     FutureTypeAdapter<T> futureTypeAdapter = (FutureTypeAdapter)map.get(paramTypeToken);
/*  449 */     if (futureTypeAdapter != null) {
/*  450 */       return futureTypeAdapter;
/*      */     }
/*      */     
/*      */     try {
/*  454 */       FutureTypeAdapter<T> futureTypeAdapter1 = new FutureTypeAdapter();
/*  455 */       map.put(paramTypeToken, futureTypeAdapter1);
/*      */       
/*  457 */       for (TypeAdapterFactory typeAdapterFactory : this.factories) {
/*  458 */         TypeAdapter<T> typeAdapter1 = typeAdapterFactory.create(this, paramTypeToken);
/*  459 */         if (typeAdapter1 != null) {
/*  460 */           futureTypeAdapter1.setDelegate(typeAdapter1);
/*  461 */           this.typeTokenCache.put(paramTypeToken, typeAdapter1);
/*  462 */           return typeAdapter1;
/*      */         } 
/*      */       } 
/*  465 */       throw new IllegalArgumentException("GSON (2.8.5) cannot handle " + paramTypeToken);
/*      */     } finally {
/*  467 */       map.remove(paramTypeToken);
/*      */       
/*  469 */       if (bool) {
/*  470 */         this.calls.remove();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> TypeAdapter<T> getDelegateAdapter(TypeAdapterFactory paramTypeAdapterFactory, TypeToken<T> paramTypeToken) {
/*      */     JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory;
/*  528 */     if (!this.factories.contains(paramTypeAdapterFactory)) {
/*  529 */       jsonAdapterAnnotationTypeAdapterFactory = this.jsonAdapterFactory;
/*      */     }
/*      */     
/*  532 */     boolean bool = false;
/*  533 */     for (TypeAdapterFactory typeAdapterFactory : this.factories) {
/*  534 */       if (!bool) {
/*  535 */         if (typeAdapterFactory == jsonAdapterAnnotationTypeAdapterFactory) {
/*  536 */           bool = true;
/*      */         }
/*      */         
/*      */         continue;
/*      */       } 
/*  541 */       TypeAdapter<T> typeAdapter = typeAdapterFactory.create(this, paramTypeToken);
/*  542 */       if (typeAdapter != null) {
/*  543 */         return typeAdapter;
/*      */       }
/*      */     } 
/*  546 */     throw new IllegalArgumentException("GSON cannot serialize " + paramTypeToken);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> TypeAdapter<T> getAdapter(Class<T> paramClass) {
/*  556 */     return getAdapter(TypeToken.get(paramClass));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonElement toJsonTree(Object paramObject) {
/*  573 */     if (paramObject == null) {
/*  574 */       return JsonNull.INSTANCE;
/*      */     }
/*  576 */     return toJsonTree(paramObject, paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonElement toJsonTree(Object paramObject, Type paramType) {
/*  596 */     JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
/*  597 */     toJson(paramObject, paramType, (JsonWriter)jsonTreeWriter);
/*  598 */     return jsonTreeWriter.get();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toJson(Object paramObject) {
/*  615 */     if (paramObject == null) {
/*  616 */       return toJson(JsonNull.INSTANCE);
/*      */     }
/*  618 */     return toJson(paramObject, paramObject.getClass());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toJson(Object paramObject, Type paramType) {
/*  637 */     StringWriter stringWriter = new StringWriter();
/*  638 */     toJson(paramObject, paramType, stringWriter);
/*  639 */     return stringWriter.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(Object paramObject, Appendable paramAppendable) throws JsonIOException {
/*  657 */     if (paramObject != null) {
/*  658 */       toJson(paramObject, paramObject.getClass(), paramAppendable);
/*      */     } else {
/*  660 */       toJson(JsonNull.INSTANCE, paramAppendable);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(Object paramObject, Type paramType, Appendable paramAppendable) throws JsonIOException {
/*      */     try {
/*  682 */       JsonWriter jsonWriter = newJsonWriter(Streams.writerForAppendable(paramAppendable));
/*  683 */       toJson(paramObject, paramType, jsonWriter);
/*  684 */     } catch (IOException iOException) {
/*  685 */       throw new JsonIOException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(Object paramObject, Type paramType, JsonWriter paramJsonWriter) throws JsonIOException {
/*  696 */     TypeAdapter<?> typeAdapter = getAdapter(TypeToken.get(paramType));
/*  697 */     boolean bool1 = paramJsonWriter.isLenient();
/*  698 */     paramJsonWriter.setLenient(true);
/*  699 */     boolean bool2 = paramJsonWriter.isHtmlSafe();
/*  700 */     paramJsonWriter.setHtmlSafe(this.htmlSafe);
/*  701 */     boolean bool3 = paramJsonWriter.getSerializeNulls();
/*  702 */     paramJsonWriter.setSerializeNulls(this.serializeNulls);
/*      */     try {
/*  704 */       typeAdapter.write(paramJsonWriter, paramObject);
/*  705 */     } catch (IOException iOException) {
/*  706 */       throw new JsonIOException(iOException);
/*  707 */     } catch (AssertionError assertionError) {
/*  708 */       throw new AssertionError("AssertionError (GSON 2.8.5): " + assertionError.getMessage(), assertionError);
/*      */     } finally {
/*  710 */       paramJsonWriter.setLenient(bool1);
/*  711 */       paramJsonWriter.setHtmlSafe(bool2);
/*  712 */       paramJsonWriter.setSerializeNulls(bool3);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toJson(JsonElement paramJsonElement) {
/*  724 */     StringWriter stringWriter = new StringWriter();
/*  725 */     toJson(paramJsonElement, stringWriter);
/*  726 */     return stringWriter.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(JsonElement paramJsonElement, Appendable paramAppendable) throws JsonIOException {
/*      */     try {
/*  739 */       JsonWriter jsonWriter = newJsonWriter(Streams.writerForAppendable(paramAppendable));
/*  740 */       toJson(paramJsonElement, jsonWriter);
/*  741 */     } catch (IOException iOException) {
/*  742 */       throw new JsonIOException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonWriter newJsonWriter(Writer paramWriter) throws IOException {
/*  750 */     if (this.generateNonExecutableJson) {
/*  751 */       paramWriter.write(")]}'\n");
/*      */     }
/*  753 */     JsonWriter jsonWriter = new JsonWriter(paramWriter);
/*  754 */     if (this.prettyPrinting) {
/*  755 */       jsonWriter.setIndent("  ");
/*      */     }
/*  757 */     jsonWriter.setSerializeNulls(this.serializeNulls);
/*  758 */     return jsonWriter;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public JsonReader newJsonReader(Reader paramReader) {
/*  765 */     JsonReader jsonReader = new JsonReader(paramReader);
/*  766 */     jsonReader.setLenient(this.lenient);
/*  767 */     return jsonReader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void toJson(JsonElement paramJsonElement, JsonWriter paramJsonWriter) throws JsonIOException {
/*  775 */     boolean bool1 = paramJsonWriter.isLenient();
/*  776 */     paramJsonWriter.setLenient(true);
/*  777 */     boolean bool2 = paramJsonWriter.isHtmlSafe();
/*  778 */     paramJsonWriter.setHtmlSafe(this.htmlSafe);
/*  779 */     boolean bool3 = paramJsonWriter.getSerializeNulls();
/*  780 */     paramJsonWriter.setSerializeNulls(this.serializeNulls);
/*      */     try {
/*  782 */       Streams.write(paramJsonElement, paramJsonWriter);
/*  783 */     } catch (IOException iOException) {
/*  784 */       throw new JsonIOException(iOException);
/*  785 */     } catch (AssertionError assertionError) {
/*  786 */       throw new AssertionError("AssertionError (GSON 2.8.5): " + assertionError.getMessage(), assertionError);
/*      */     } finally {
/*  788 */       paramJsonWriter.setLenient(bool1);
/*  789 */       paramJsonWriter.setHtmlSafe(bool2);
/*  790 */       paramJsonWriter.setSerializeNulls(bool3);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(String paramString, Class<T> paramClass) throws JsonSyntaxException {
/*  813 */     Object object = fromJson(paramString, paramClass);
/*  814 */     return Primitives.wrap(paramClass).cast(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(String paramString, Type paramType) throws JsonSyntaxException {
/*  837 */     if (paramString == null) {
/*  838 */       return null;
/*      */     }
/*  840 */     StringReader stringReader = new StringReader(paramString);
/*  841 */     return (T)fromJson(stringReader, paramType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(Reader paramReader, Class<T> paramClass) throws JsonSyntaxException, JsonIOException {
/*  864 */     JsonReader jsonReader = newJsonReader(paramReader);
/*  865 */     Object object = fromJson(jsonReader, paramClass);
/*  866 */     assertFullConsumption(object, jsonReader);
/*  867 */     return Primitives.wrap(paramClass).cast(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(Reader paramReader, Type paramType) throws JsonIOException, JsonSyntaxException {
/*  891 */     JsonReader jsonReader = newJsonReader(paramReader);
/*  892 */     T t = (T)fromJson(jsonReader, paramType);
/*  893 */     assertFullConsumption(t, jsonReader);
/*  894 */     return t;
/*      */   }
/*      */   
/*      */   private static void assertFullConsumption(Object paramObject, JsonReader paramJsonReader) {
/*      */     try {
/*  899 */       if (paramObject != null && paramJsonReader.peek() != JsonToken.END_DOCUMENT) {
/*  900 */         throw new JsonIOException("JSON document was not fully consumed.");
/*      */       }
/*  902 */     } catch (MalformedJsonException malformedJsonException) {
/*  903 */       throw new JsonSyntaxException(malformedJsonException);
/*  904 */     } catch (IOException iOException) {
/*  905 */       throw new JsonIOException(iOException);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(JsonReader paramJsonReader, Type paramType) throws JsonIOException, JsonSyntaxException {
/*  919 */     boolean bool = true;
/*  920 */     boolean bool1 = paramJsonReader.isLenient();
/*  921 */     paramJsonReader.setLenient(true);
/*      */     try {
/*  923 */       paramJsonReader.peek();
/*  924 */       bool = false;
/*  925 */       TypeToken<?> typeToken = TypeToken.get(paramType);
/*  926 */       TypeAdapter<?> typeAdapter = getAdapter(typeToken);
/*  927 */       Object object = typeAdapter.read(paramJsonReader);
/*  928 */       return (T)object;
/*  929 */     } catch (EOFException eOFException) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  934 */       if (bool) {
/*  935 */         return null;
/*      */       }
/*  937 */       throw new JsonSyntaxException(eOFException);
/*  938 */     } catch (IllegalStateException illegalStateException) {
/*  939 */       throw new JsonSyntaxException(illegalStateException);
/*  940 */     } catch (IOException iOException) {
/*      */       
/*  942 */       throw new JsonSyntaxException(iOException);
/*  943 */     } catch (AssertionError assertionError) {
/*  944 */       throw new AssertionError("AssertionError (GSON 2.8.5): " + assertionError.getMessage(), assertionError);
/*      */     } finally {
/*  946 */       paramJsonReader.setLenient(bool1);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(JsonElement paramJsonElement, Class<T> paramClass) throws JsonSyntaxException {
/*  967 */     Object object = fromJson(paramJsonElement, paramClass);
/*  968 */     return Primitives.wrap(paramClass).cast(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public <T> T fromJson(JsonElement paramJsonElement, Type paramType) throws JsonSyntaxException {
/*  991 */     if (paramJsonElement == null) {
/*  992 */       return null;
/*      */     }
/*  994 */     return fromJson((JsonReader)new JsonTreeReader(paramJsonElement), paramType);
/*      */   }
/*      */   
/*      */   static class FutureTypeAdapter<T> extends TypeAdapter<T> {
/*      */     private TypeAdapter<T> delegate;
/*      */     
/*      */     public void setDelegate(TypeAdapter<T> param1TypeAdapter) {
/* 1001 */       if (this.delegate != null) {
/* 1002 */         throw new AssertionError();
/*      */       }
/* 1004 */       this.delegate = param1TypeAdapter;
/*      */     }
/*      */     
/*      */     public T read(JsonReader param1JsonReader) throws IOException {
/* 1008 */       if (this.delegate == null) {
/* 1009 */         throw new IllegalStateException();
/*      */       }
/* 1011 */       return this.delegate.read(param1JsonReader);
/*      */     }
/*      */     
/*      */     public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
/* 1015 */       if (this.delegate == null) {
/* 1016 */         throw new IllegalStateException();
/*      */       }
/* 1018 */       this.delegate.write(param1JsonWriter, param1T);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1024 */     return "{serializeNulls:" + this.serializeNulls + 
/* 1025 */       ",factories:" + 
/* 1026 */       this.factories + ",instanceCreators:" + 
/* 1027 */       this.constructorConstructor + "}";
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\Gson.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */