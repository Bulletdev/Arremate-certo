/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.internal.;
/*     */ import com.google.gson.internal.ConstructorConstructor;
/*     */ import com.google.gson.internal.JsonReaderInternalAccess;
/*     */ import com.google.gson.internal.ObjectConstructor;
/*     */ import com.google.gson.internal.Streams;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class MapTypeAdapterFactory
/*     */   implements TypeAdapterFactory
/*     */ {
/*     */   private final ConstructorConstructor constructorConstructor;
/*     */   final boolean complexMapKeySerialization;
/*     */   
/*     */   public MapTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, boolean paramBoolean) {
/* 111 */     this.constructorConstructor = paramConstructorConstructor;
/* 112 */     this.complexMapKeySerialization = paramBoolean;
/*     */   }
/*     */   
/*     */   public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
/* 116 */     Type type = paramTypeToken.getType();
/*     */     
/* 118 */     Class<?> clazz = paramTypeToken.getRawType();
/* 119 */     if (!Map.class.isAssignableFrom(clazz)) {
/* 120 */       return null;
/*     */     }
/*     */     
/* 123 */     Class clazz1 = .Gson.Types.getRawType(type);
/* 124 */     Type[] arrayOfType = .Gson.Types.getMapKeyAndValueTypes(type, clazz1);
/* 125 */     TypeAdapter<?> typeAdapter1 = getKeyAdapter(paramGson, arrayOfType[0]);
/* 126 */     TypeAdapter<?> typeAdapter2 = paramGson.getAdapter(TypeToken.get(arrayOfType[1]));
/* 127 */     ObjectConstructor<? extends Map<?, ?>> objectConstructor = this.constructorConstructor.get(paramTypeToken);
/*     */ 
/*     */ 
/*     */     
/* 131 */     return (TypeAdapter)new Adapter<Object, Object>(paramGson, arrayOfType[0], typeAdapter1, arrayOfType[1], typeAdapter2, objectConstructor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private TypeAdapter<?> getKeyAdapter(Gson paramGson, Type paramType) {
/* 140 */     return (paramType == boolean.class || paramType == Boolean.class) ? TypeAdapters.BOOLEAN_AS_STRING : paramGson
/*     */       
/* 142 */       .getAdapter(TypeToken.get(paramType));
/*     */   }
/*     */   
/*     */   private final class Adapter<K, V>
/*     */     extends TypeAdapter<Map<K, V>>
/*     */   {
/*     */     private final TypeAdapter<K> keyTypeAdapter;
/*     */     private final TypeAdapter<V> valueTypeAdapter;
/*     */     private final ObjectConstructor<? extends Map<K, V>> constructor;
/*     */     
/*     */     public Adapter(Gson param1Gson, Type param1Type1, TypeAdapter<K> param1TypeAdapter, Type param1Type2, TypeAdapter<V> param1TypeAdapter1, ObjectConstructor<? extends Map<K, V>> param1ObjectConstructor) {
/* 153 */       this.keyTypeAdapter = new TypeAdapterRuntimeTypeWrapper<K>(param1Gson, param1TypeAdapter, param1Type1);
/*     */       
/* 155 */       this.valueTypeAdapter = new TypeAdapterRuntimeTypeWrapper<V>(param1Gson, param1TypeAdapter1, param1Type2);
/*     */       
/* 157 */       this.constructor = param1ObjectConstructor;
/*     */     }
/*     */     
/*     */     public Map<K, V> read(JsonReader param1JsonReader) throws IOException {
/* 161 */       JsonToken jsonToken = param1JsonReader.peek();
/* 162 */       if (jsonToken == JsonToken.NULL) {
/* 163 */         param1JsonReader.nextNull();
/* 164 */         return null;
/*     */       } 
/*     */       
/* 167 */       Map<Object, Object> map = (Map)this.constructor.construct();
/*     */       
/* 169 */       if (jsonToken == JsonToken.BEGIN_ARRAY) {
/* 170 */         param1JsonReader.beginArray();
/* 171 */         while (param1JsonReader.hasNext()) {
/* 172 */           param1JsonReader.beginArray();
/* 173 */           Object object1 = this.keyTypeAdapter.read(param1JsonReader);
/* 174 */           Object object2 = this.valueTypeAdapter.read(param1JsonReader);
/* 175 */           Object object = map.put(object1, object2);
/* 176 */           if (object != null) {
/* 177 */             throw new JsonSyntaxException("duplicate key: " + object1);
/*     */           }
/* 179 */           param1JsonReader.endArray();
/*     */         } 
/* 181 */         param1JsonReader.endArray();
/*     */       } else {
/* 183 */         param1JsonReader.beginObject();
/* 184 */         while (param1JsonReader.hasNext()) {
/* 185 */           JsonReaderInternalAccess.INSTANCE.promoteNameToValue(param1JsonReader);
/* 186 */           Object object1 = this.keyTypeAdapter.read(param1JsonReader);
/* 187 */           Object object2 = this.valueTypeAdapter.read(param1JsonReader);
/* 188 */           Object object = map.put(object1, object2);
/* 189 */           if (object != null) {
/* 190 */             throw new JsonSyntaxException("duplicate key: " + object1);
/*     */           }
/*     */         } 
/* 193 */         param1JsonReader.endObject();
/*     */       } 
/* 195 */       return (Map)map;
/*     */     }
/*     */     
/*     */     public void write(JsonWriter param1JsonWriter, Map<K, V> param1Map) throws IOException {
/* 199 */       if (param1Map == null) {
/* 200 */         param1JsonWriter.nullValue();
/*     */         
/*     */         return;
/*     */       } 
/* 204 */       if (!MapTypeAdapterFactory.this.complexMapKeySerialization) {
/* 205 */         param1JsonWriter.beginObject();
/* 206 */         for (Map.Entry<K, V> entry : param1Map.entrySet()) {
/* 207 */           param1JsonWriter.name(String.valueOf(entry.getKey()));
/* 208 */           this.valueTypeAdapter.write(param1JsonWriter, entry.getValue());
/*     */         } 
/* 210 */         param1JsonWriter.endObject();
/*     */         
/*     */         return;
/*     */       } 
/* 214 */       int i = 0;
/* 215 */       ArrayList<JsonElement> arrayList = new ArrayList(param1Map.size());
/*     */       
/* 217 */       ArrayList arrayList1 = new ArrayList(param1Map.size());
/* 218 */       for (Map.Entry<K, V> entry : param1Map.entrySet()) {
/* 219 */         JsonElement jsonElement = this.keyTypeAdapter.toJsonTree(entry.getKey());
/* 220 */         arrayList.add(jsonElement);
/* 221 */         arrayList1.add(entry.getValue());
/* 222 */         i |= (jsonElement.isJsonArray() || jsonElement.isJsonObject()) ? 1 : 0;
/*     */       } 
/*     */       
/* 225 */       if (i != 0) {
/* 226 */         param1JsonWriter.beginArray(); byte b; int j;
/* 227 */         for (b = 0, j = arrayList.size(); b < j; b++) {
/* 228 */           param1JsonWriter.beginArray();
/* 229 */           Streams.write(arrayList.get(b), param1JsonWriter);
/* 230 */           this.valueTypeAdapter.write(param1JsonWriter, arrayList1.get(b));
/* 231 */           param1JsonWriter.endArray();
/*     */         } 
/* 233 */         param1JsonWriter.endArray();
/*     */       } else {
/* 235 */         param1JsonWriter.beginObject(); byte b; int j;
/* 236 */         for (b = 0, j = arrayList.size(); b < j; b++) {
/* 237 */           JsonElement jsonElement = arrayList.get(b);
/* 238 */           param1JsonWriter.name(keyToString(jsonElement));
/* 239 */           this.valueTypeAdapter.write(param1JsonWriter, arrayList1.get(b));
/*     */         } 
/* 241 */         param1JsonWriter.endObject();
/*     */       } 
/*     */     }
/*     */     
/*     */     private String keyToString(JsonElement param1JsonElement) {
/* 246 */       if (param1JsonElement.isJsonPrimitive()) {
/* 247 */         JsonPrimitive jsonPrimitive = param1JsonElement.getAsJsonPrimitive();
/* 248 */         if (jsonPrimitive.isNumber())
/* 249 */           return String.valueOf(jsonPrimitive.getAsNumber()); 
/* 250 */         if (jsonPrimitive.isBoolean())
/* 251 */           return Boolean.toString(jsonPrimitive.getAsBoolean()); 
/* 252 */         if (jsonPrimitive.isString()) {
/* 253 */           return jsonPrimitive.getAsString();
/*     */         }
/* 255 */         throw new AssertionError();
/*     */       } 
/* 257 */       if (param1JsonElement.isJsonNull()) {
/* 258 */         return "null";
/*     */       }
/* 260 */       throw new AssertionError();
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\MapTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */