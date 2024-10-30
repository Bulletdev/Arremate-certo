/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.internal.LinkedTreeMap;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ObjectTypeAdapter
/*     */   extends TypeAdapter<Object>
/*     */ {
/*  38 */   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
/*     */     {
/*     */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/*  41 */         if (param1TypeToken.getRawType() == Object.class) {
/*  42 */           return new ObjectTypeAdapter(param1Gson);
/*     */         }
/*  44 */         return null;
/*     */       }
/*     */     };
/*     */   
/*     */   private final Gson gson;
/*     */   
/*     */   ObjectTypeAdapter(Gson paramGson) {
/*  51 */     this.gson = paramGson;
/*     */   } public Object read(JsonReader paramJsonReader) throws IOException {
/*     */     ArrayList<Object> arrayList;
/*     */     LinkedTreeMap<String, Object> linkedTreeMap;
/*  55 */     JsonToken jsonToken = paramJsonReader.peek();
/*  56 */     switch (jsonToken) {
/*     */       case BEGIN_ARRAY:
/*  58 */         arrayList = new ArrayList();
/*  59 */         paramJsonReader.beginArray();
/*  60 */         while (paramJsonReader.hasNext()) {
/*  61 */           arrayList.add(read(paramJsonReader));
/*     */         }
/*  63 */         paramJsonReader.endArray();
/*  64 */         return arrayList;
/*     */       
/*     */       case BEGIN_OBJECT:
/*  67 */         linkedTreeMap = new LinkedTreeMap();
/*  68 */         paramJsonReader.beginObject();
/*  69 */         while (paramJsonReader.hasNext()) {
/*  70 */           linkedTreeMap.put(paramJsonReader.nextName(), read(paramJsonReader));
/*     */         }
/*  72 */         paramJsonReader.endObject();
/*  73 */         return linkedTreeMap;
/*     */       
/*     */       case STRING:
/*  76 */         return paramJsonReader.nextString();
/*     */       
/*     */       case NUMBER:
/*  79 */         return Double.valueOf(paramJsonReader.nextDouble());
/*     */       
/*     */       case BOOLEAN:
/*  82 */         return Boolean.valueOf(paramJsonReader.nextBoolean());
/*     */       
/*     */       case NULL:
/*  85 */         paramJsonReader.nextNull();
/*  86 */         return null;
/*     */     } 
/*     */     
/*  89 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(JsonWriter paramJsonWriter, Object paramObject) throws IOException {
/*  95 */     if (paramObject == null) {
/*  96 */       paramJsonWriter.nullValue();
/*     */       
/*     */       return;
/*     */     } 
/* 100 */     TypeAdapter typeAdapter = this.gson.getAdapter(paramObject.getClass());
/* 101 */     if (typeAdapter instanceof ObjectTypeAdapter) {
/* 102 */       paramJsonWriter.beginObject();
/* 103 */       paramJsonWriter.endObject();
/*     */       
/*     */       return;
/*     */     } 
/* 107 */     typeAdapter.write(paramJsonWriter, paramObject);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\ObjectTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */