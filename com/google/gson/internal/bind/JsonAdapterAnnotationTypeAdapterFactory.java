/*    */ package com.google.gson.internal.bind;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.JsonDeserializer;
/*    */ import com.google.gson.JsonSerializer;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.annotations.JsonAdapter;
/*    */ import com.google.gson.internal.ConstructorConstructor;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class JsonAdapterAnnotationTypeAdapterFactory
/*    */   implements TypeAdapterFactory
/*    */ {
/*    */   private final ConstructorConstructor constructorConstructor;
/*    */   
/*    */   public JsonAdapterAnnotationTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor) {
/* 38 */     this.constructorConstructor = paramConstructorConstructor;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
/* 44 */     Class clazz = paramTypeToken.getRawType();
/* 45 */     JsonAdapter jsonAdapter = (JsonAdapter)clazz.getAnnotation(JsonAdapter.class);
/* 46 */     if (jsonAdapter == null) {
/* 47 */       return null;
/*    */     }
/* 49 */     return (TypeAdapter)getTypeAdapter(this.constructorConstructor, paramGson, paramTypeToken, jsonAdapter);
/*    */   }
/*    */ 
/*    */   
/*    */   TypeAdapter<?> getTypeAdapter(ConstructorConstructor paramConstructorConstructor, Gson paramGson, TypeToken<?> paramTypeToken, JsonAdapter paramJsonAdapter) {
/*    */     TypeAdapter<?> typeAdapter;
/* 55 */     Object object = paramConstructorConstructor.get(TypeToken.get(paramJsonAdapter.value())).construct();
/*    */ 
/*    */     
/* 58 */     if (object instanceof TypeAdapter) {
/* 59 */       typeAdapter = (TypeAdapter)object;
/* 60 */     } else if (object instanceof TypeAdapterFactory) {
/* 61 */       typeAdapter = ((TypeAdapterFactory)object).create(paramGson, paramTypeToken);
/* 62 */     } else if (object instanceof JsonSerializer || object instanceof JsonDeserializer) {
/* 63 */       JsonSerializer<?> jsonSerializer = (object instanceof JsonSerializer) ? (JsonSerializer)object : null;
/*    */ 
/*    */       
/* 66 */       JsonDeserializer<?> jsonDeserializer = (object instanceof JsonDeserializer) ? (JsonDeserializer)object : null;
/*    */ 
/*    */       
/* 69 */       typeAdapter = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, paramGson, paramTypeToken, null);
/*    */     } else {
/* 71 */       throw new IllegalArgumentException("Invalid attempt to bind an instance of " + object
/* 72 */           .getClass().getName() + " as a @JsonAdapter for " + paramTypeToken.toString() + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
/*    */     } 
/*    */ 
/*    */ 
/*    */     
/* 77 */     if (typeAdapter != null && paramJsonAdapter.nullSafe()) {
/* 78 */       typeAdapter = typeAdapter.nullSafe();
/*    */     }
/*    */     
/* 81 */     return typeAdapter;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\JsonAdapterAnnotationTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */