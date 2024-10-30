/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonDeserializationContext;
/*     */ import com.google.gson.JsonDeserializer;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonParseException;
/*     */ import com.google.gson.JsonSerializationContext;
/*     */ import com.google.gson.JsonSerializer;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.internal.;
/*     */ import com.google.gson.internal.Streams;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class TreeTypeAdapter<T>
/*     */   extends TypeAdapter<T>
/*     */ {
/*     */   private final JsonSerializer<T> serializer;
/*     */   private final JsonDeserializer<T> deserializer;
/*     */   final Gson gson;
/*     */   private final TypeToken<T> typeToken;
/*     */   private final TypeAdapterFactory skipPast;
/*  47 */   private final GsonContextImpl context = new GsonContextImpl();
/*     */ 
/*     */   
/*     */   private TypeAdapter<T> delegate;
/*     */ 
/*     */   
/*     */   public TreeTypeAdapter(JsonSerializer<T> paramJsonSerializer, JsonDeserializer<T> paramJsonDeserializer, Gson paramGson, TypeToken<T> paramTypeToken, TypeAdapterFactory paramTypeAdapterFactory) {
/*  54 */     this.serializer = paramJsonSerializer;
/*  55 */     this.deserializer = paramJsonDeserializer;
/*  56 */     this.gson = paramGson;
/*  57 */     this.typeToken = paramTypeToken;
/*  58 */     this.skipPast = paramTypeAdapterFactory;
/*     */   }
/*     */   
/*     */   public T read(JsonReader paramJsonReader) throws IOException {
/*  62 */     if (this.deserializer == null) {
/*  63 */       return (T)delegate().read(paramJsonReader);
/*     */     }
/*  65 */     JsonElement jsonElement = Streams.parse(paramJsonReader);
/*  66 */     if (jsonElement.isJsonNull()) {
/*  67 */       return null;
/*     */     }
/*  69 */     return (T)this.deserializer.deserialize(jsonElement, this.typeToken.getType(), this.context);
/*     */   }
/*     */   
/*     */   public void write(JsonWriter paramJsonWriter, T paramT) throws IOException {
/*  73 */     if (this.serializer == null) {
/*  74 */       delegate().write(paramJsonWriter, paramT);
/*     */       return;
/*     */     } 
/*  77 */     if (paramT == null) {
/*  78 */       paramJsonWriter.nullValue();
/*     */       return;
/*     */     } 
/*  81 */     JsonElement jsonElement = this.serializer.serialize(paramT, this.typeToken.getType(), this.context);
/*  82 */     Streams.write(jsonElement, paramJsonWriter);
/*     */   }
/*     */   
/*     */   private TypeAdapter<T> delegate() {
/*  86 */     TypeAdapter<T> typeAdapter = this.delegate;
/*  87 */     return (typeAdapter != null) ? typeAdapter : (this
/*     */       
/*  89 */       .delegate = this.gson.getDelegateAdapter(this.skipPast, this.typeToken));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeAdapterFactory newFactory(TypeToken<?> paramTypeToken, Object paramObject) {
/*  96 */     return new SingleTypeFactory(paramObject, paramTypeToken, false, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken<?> paramTypeToken, Object paramObject) {
/* 106 */     boolean bool = (paramTypeToken.getType() == paramTypeToken.getRawType()) ? true : false;
/* 107 */     return new SingleTypeFactory(paramObject, paramTypeToken, bool, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static TypeAdapterFactory newTypeHierarchyFactory(Class<?> paramClass, Object paramObject) {
/* 116 */     return new SingleTypeFactory(paramObject, null, false, paramClass);
/*     */   }
/*     */   
/*     */   private static final class SingleTypeFactory
/*     */     implements TypeAdapterFactory {
/*     */     private final TypeToken<?> exactType;
/*     */     private final boolean matchRawType;
/*     */     private final Class<?> hierarchyType;
/*     */     private final JsonSerializer<?> serializer;
/*     */     private final JsonDeserializer<?> deserializer;
/*     */     
/*     */     SingleTypeFactory(Object param1Object, TypeToken<?> param1TypeToken, boolean param1Boolean, Class<?> param1Class) {
/* 128 */       this.serializer = (param1Object instanceof JsonSerializer) ? (JsonSerializer)param1Object : null;
/*     */ 
/*     */       
/* 131 */       this.deserializer = (param1Object instanceof JsonDeserializer) ? (JsonDeserializer)param1Object : null;
/*     */ 
/*     */       
/* 134 */       .Gson.Preconditions.checkArgument((this.serializer != null || this.deserializer != null));
/* 135 */       this.exactType = param1TypeToken;
/* 136 */       this.matchRawType = param1Boolean;
/* 137 */       this.hierarchyType = param1Class;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 145 */       boolean bool = (this.exactType != null) ? ((this.exactType.equals(param1TypeToken) || (this.matchRawType && this.exactType.getType() == param1TypeToken.getRawType())) ? true : false) : this.hierarchyType.isAssignableFrom(param1TypeToken.getRawType());
/* 146 */       return bool ? new TreeTypeAdapter<T>((JsonSerializer)this.serializer, (JsonDeserializer)this.deserializer, param1Gson, param1TypeToken, this) : null;
/*     */     }
/*     */   }
/*     */   
/*     */   private final class GsonContextImpl
/*     */     implements JsonDeserializationContext, JsonSerializationContext {
/*     */     private GsonContextImpl() {}
/*     */     
/*     */     public JsonElement serialize(Object param1Object) {
/* 155 */       return TreeTypeAdapter.this.gson.toJsonTree(param1Object);
/*     */     }
/*     */     public JsonElement serialize(Object param1Object, Type param1Type) {
/* 158 */       return TreeTypeAdapter.this.gson.toJsonTree(param1Object, param1Type);
/*     */     }
/*     */     
/*     */     public <R> R deserialize(JsonElement param1JsonElement, Type param1Type) throws JsonParseException {
/* 162 */       return (R)TreeTypeAdapter.this.gson.fromJson(param1JsonElement, param1Type);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\TreeTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */