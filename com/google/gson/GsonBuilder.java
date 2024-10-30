/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.;
/*     */ import com.google.gson.internal.Excluder;
/*     */ import com.google.gson.internal.bind.TreeTypeAdapter;
/*     */ import com.google.gson.internal.bind.TypeAdapters;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import java.lang.reflect.Type;
/*     */ import java.sql.Date;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class GsonBuilder
/*     */ {
/*  79 */   private Excluder excluder = Excluder.DEFAULT;
/*  80 */   private LongSerializationPolicy longSerializationPolicy = LongSerializationPolicy.DEFAULT;
/*  81 */   private FieldNamingStrategy fieldNamingPolicy = FieldNamingPolicy.IDENTITY;
/*  82 */   private final Map<Type, InstanceCreator<?>> instanceCreators = new HashMap<Type, InstanceCreator<?>>();
/*     */   
/*  84 */   private final List<TypeAdapterFactory> factories = new ArrayList<TypeAdapterFactory>();
/*     */   
/*  86 */   private final List<TypeAdapterFactory> hierarchyFactories = new ArrayList<TypeAdapterFactory>();
/*     */   private boolean serializeNulls = false;
/*     */   private String datePattern;
/*  89 */   private int dateStyle = 2;
/*  90 */   private int timeStyle = 2;
/*     */ 
/*     */   
/*     */   private boolean complexMapKeySerialization = false;
/*     */ 
/*     */   
/*     */   private boolean serializeSpecialFloatingPointValues = false;
/*     */ 
/*     */   
/*     */   private boolean escapeHtmlChars = true;
/*     */ 
/*     */   
/*     */   private boolean prettyPrinting = false;
/*     */ 
/*     */   
/*     */   private boolean generateNonExecutableJson = false;
/*     */   
/*     */   private boolean lenient = false;
/*     */ 
/*     */   
/*     */   public GsonBuilder() {}
/*     */ 
/*     */   
/*     */   GsonBuilder(Gson paramGson) {
/* 114 */     this.excluder = paramGson.excluder;
/* 115 */     this.fieldNamingPolicy = paramGson.fieldNamingStrategy;
/* 116 */     this.instanceCreators.putAll(paramGson.instanceCreators);
/* 117 */     this.serializeNulls = paramGson.serializeNulls;
/* 118 */     this.complexMapKeySerialization = paramGson.complexMapKeySerialization;
/* 119 */     this.generateNonExecutableJson = paramGson.generateNonExecutableJson;
/* 120 */     this.escapeHtmlChars = paramGson.htmlSafe;
/* 121 */     this.prettyPrinting = paramGson.prettyPrinting;
/* 122 */     this.lenient = paramGson.lenient;
/* 123 */     this.serializeSpecialFloatingPointValues = paramGson.serializeSpecialFloatingPointValues;
/* 124 */     this.longSerializationPolicy = paramGson.longSerializationPolicy;
/* 125 */     this.datePattern = paramGson.datePattern;
/* 126 */     this.dateStyle = paramGson.dateStyle;
/* 127 */     this.timeStyle = paramGson.timeStyle;
/* 128 */     this.factories.addAll(paramGson.builderFactories);
/* 129 */     this.hierarchyFactories.addAll(paramGson.builderHierarchyFactories);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder setVersion(double paramDouble) {
/* 140 */     this.excluder = this.excluder.withVersion(paramDouble);
/* 141 */     return this;
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
/*     */   public GsonBuilder excludeFieldsWithModifiers(int... paramVarArgs) {
/* 156 */     this.excluder = this.excluder.withModifiers(paramVarArgs);
/* 157 */     return this;
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
/*     */   public GsonBuilder generateNonExecutableJson() {
/* 170 */     this.generateNonExecutableJson = true;
/* 171 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder excludeFieldsWithoutExposeAnnotation() {
/* 181 */     this.excluder = this.excluder.excludeFieldsWithoutExposeAnnotation();
/* 182 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder serializeNulls() {
/* 193 */     this.serializeNulls = true;
/* 194 */     return this;
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
/*     */   public GsonBuilder enableComplexMapKeySerialization() {
/* 274 */     this.complexMapKeySerialization = true;
/* 275 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder disableInnerClassSerialization() {
/* 285 */     this.excluder = this.excluder.disableInnerClassSerialization();
/* 286 */     return this;
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
/*     */   public GsonBuilder setLongSerializationPolicy(LongSerializationPolicy paramLongSerializationPolicy) {
/* 298 */     this.longSerializationPolicy = paramLongSerializationPolicy;
/* 299 */     return this;
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
/*     */   public GsonBuilder setFieldNamingPolicy(FieldNamingPolicy paramFieldNamingPolicy) {
/* 311 */     this.fieldNamingPolicy = paramFieldNamingPolicy;
/* 312 */     return this;
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
/*     */   public GsonBuilder setFieldNamingStrategy(FieldNamingStrategy paramFieldNamingStrategy) {
/* 324 */     this.fieldNamingPolicy = paramFieldNamingStrategy;
/* 325 */     return this;
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
/*     */   public GsonBuilder setExclusionStrategies(ExclusionStrategy... paramVarArgs) {
/* 339 */     for (ExclusionStrategy exclusionStrategy : paramVarArgs) {
/* 340 */       this.excluder = this.excluder.withExclusionStrategy(exclusionStrategy, true, true);
/*     */     }
/* 342 */     return this;
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
/*     */   public GsonBuilder addSerializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy) {
/* 358 */     this.excluder = this.excluder.withExclusionStrategy(paramExclusionStrategy, true, false);
/* 359 */     return this;
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
/*     */   public GsonBuilder addDeserializationExclusionStrategy(ExclusionStrategy paramExclusionStrategy) {
/* 375 */     this.excluder = this.excluder.withExclusionStrategy(paramExclusionStrategy, false, true);
/* 376 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder setPrettyPrinting() {
/* 386 */     this.prettyPrinting = true;
/* 387 */     return this;
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
/*     */   public GsonBuilder setLenient() {
/* 399 */     this.lenient = true;
/* 400 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public GsonBuilder disableHtmlEscaping() {
/* 411 */     this.escapeHtmlChars = false;
/* 412 */     return this;
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
/*     */   public GsonBuilder setDateFormat(String paramString) {
/* 433 */     this.datePattern = paramString;
/* 434 */     return this;
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
/*     */   public GsonBuilder setDateFormat(int paramInt) {
/* 452 */     this.dateStyle = paramInt;
/* 453 */     this.datePattern = null;
/* 454 */     return this;
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
/*     */   public GsonBuilder setDateFormat(int paramInt1, int paramInt2) {
/* 473 */     this.dateStyle = paramInt1;
/* 474 */     this.timeStyle = paramInt2;
/* 475 */     this.datePattern = null;
/* 476 */     return this;
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
/*     */   public GsonBuilder registerTypeAdapter(Type paramType, Object paramObject) {
/* 497 */     .Gson.Preconditions.checkArgument((paramObject instanceof JsonSerializer || paramObject instanceof JsonDeserializer || paramObject instanceof InstanceCreator || paramObject instanceof TypeAdapter));
/*     */ 
/*     */ 
/*     */     
/* 501 */     if (paramObject instanceof InstanceCreator) {
/* 502 */       this.instanceCreators.put(paramType, (InstanceCreator)paramObject);
/*     */     }
/* 504 */     if (paramObject instanceof JsonSerializer || paramObject instanceof JsonDeserializer) {
/* 505 */       TypeToken typeToken = TypeToken.get(paramType);
/* 506 */       this.factories.add(TreeTypeAdapter.newFactoryWithMatchRawType(typeToken, paramObject));
/*     */     } 
/* 508 */     if (paramObject instanceof TypeAdapter) {
/* 509 */       this.factories.add(TypeAdapters.newFactory(TypeToken.get(paramType), (TypeAdapter)paramObject));
/*     */     }
/* 511 */     return this;
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
/*     */   public GsonBuilder registerTypeAdapterFactory(TypeAdapterFactory paramTypeAdapterFactory) {
/* 523 */     this.factories.add(paramTypeAdapterFactory);
/* 524 */     return this;
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
/*     */   public GsonBuilder registerTypeHierarchyAdapter(Class<?> paramClass, Object paramObject) {
/* 543 */     .Gson.Preconditions.checkArgument((paramObject instanceof JsonSerializer || paramObject instanceof JsonDeserializer || paramObject instanceof TypeAdapter));
/*     */ 
/*     */     
/* 546 */     if (paramObject instanceof JsonDeserializer || paramObject instanceof JsonSerializer) {
/* 547 */       this.hierarchyFactories.add(TreeTypeAdapter.newTypeHierarchyFactory(paramClass, paramObject));
/*     */     }
/* 549 */     if (paramObject instanceof TypeAdapter) {
/* 550 */       this.factories.add(TypeAdapters.newTypeHierarchyFactory(paramClass, (TypeAdapter)paramObject));
/*     */     }
/* 552 */     return this;
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
/*     */   public GsonBuilder serializeSpecialFloatingPointValues() {
/* 576 */     this.serializeSpecialFloatingPointValues = true;
/* 577 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Gson create() {
/* 587 */     ArrayList<TypeAdapterFactory> arrayList1 = new ArrayList(this.factories.size() + this.hierarchyFactories.size() + 3);
/* 588 */     arrayList1.addAll(this.factories);
/* 589 */     Collections.reverse(arrayList1);
/*     */     
/* 591 */     ArrayList<TypeAdapterFactory> arrayList2 = new ArrayList<TypeAdapterFactory>(this.hierarchyFactories);
/* 592 */     Collections.reverse(arrayList2);
/* 593 */     arrayList1.addAll(arrayList2);
/*     */     
/* 595 */     addTypeAdaptersForDate(this.datePattern, this.dateStyle, this.timeStyle, arrayList1);
/*     */     
/* 597 */     return new Gson(this.excluder, this.fieldNamingPolicy, this.instanceCreators, this.serializeNulls, this.complexMapKeySerialization, this.generateNonExecutableJson, this.escapeHtmlChars, this.prettyPrinting, this.lenient, this.serializeSpecialFloatingPointValues, this.longSerializationPolicy, this.datePattern, this.dateStyle, this.timeStyle, this.factories, this.hierarchyFactories, arrayList1);
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
/*     */   private void addTypeAdaptersForDate(String paramString, int paramInt1, int paramInt2, List<TypeAdapterFactory> paramList) {
/*     */     DefaultDateTypeAdapter defaultDateTypeAdapter1, defaultDateTypeAdapter2, defaultDateTypeAdapter3;
/* 611 */     if (paramString != null && !"".equals(paramString.trim())) {
/* 612 */       defaultDateTypeAdapter1 = new DefaultDateTypeAdapter(Date.class, paramString);
/* 613 */       defaultDateTypeAdapter2 = new DefaultDateTypeAdapter((Class)Timestamp.class, paramString);
/* 614 */       defaultDateTypeAdapter3 = new DefaultDateTypeAdapter((Class)Date.class, paramString);
/* 615 */     } else if (paramInt1 != 2 && paramInt2 != 2) {
/* 616 */       defaultDateTypeAdapter1 = new DefaultDateTypeAdapter(Date.class, paramInt1, paramInt2);
/* 617 */       defaultDateTypeAdapter2 = new DefaultDateTypeAdapter((Class)Timestamp.class, paramInt1, paramInt2);
/* 618 */       defaultDateTypeAdapter3 = new DefaultDateTypeAdapter((Class)Date.class, paramInt1, paramInt2);
/*     */     } else {
/*     */       return;
/*     */     } 
/*     */     
/* 623 */     paramList.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter1));
/* 624 */     paramList.add(TypeAdapters.newFactory(Timestamp.class, defaultDateTypeAdapter2));
/* 625 */     paramList.add(TypeAdapters.newFactory(Date.class, defaultDateTypeAdapter3));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\GsonBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */