/*    */ package com.google.gson.internal.bind;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.internal.;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonToken;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Array;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.ArrayList;
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
/*    */ public final class ArrayTypeAdapter<E>
/*    */   extends TypeAdapter<Object>
/*    */ {
/* 39 */   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
/*    */     {
/*    */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 42 */         Type type1 = param1TypeToken.getType();
/* 43 */         if (!(type1 instanceof java.lang.reflect.GenericArrayType) && (!(type1 instanceof Class) || !((Class)type1).isArray())) {
/* 44 */           return null;
/*    */         }
/*    */         
/* 47 */         Type type2 = .Gson.Types.getArrayComponentType(type1);
/* 48 */         TypeAdapter<?> typeAdapter = param1Gson.getAdapter(TypeToken.get(type2));
/* 49 */         return new ArrayTypeAdapter(param1Gson, typeAdapter, 
/* 50 */             .Gson.Types.getRawType(type2));
/*    */       }
/*    */     };
/*    */   
/*    */   private final Class<E> componentType;
/*    */   private final TypeAdapter<E> componentTypeAdapter;
/*    */   
/*    */   public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass) {
/* 58 */     this.componentTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(paramGson, paramTypeAdapter, paramClass);
/*    */     
/* 60 */     this.componentType = paramClass;
/*    */   }
/*    */   
/*    */   public Object read(JsonReader paramJsonReader) throws IOException {
/* 64 */     if (paramJsonReader.peek() == JsonToken.NULL) {
/* 65 */       paramJsonReader.nextNull();
/* 66 */       return null;
/*    */     } 
/*    */     
/* 69 */     ArrayList<Object> arrayList = new ArrayList();
/* 70 */     paramJsonReader.beginArray();
/* 71 */     while (paramJsonReader.hasNext()) {
/* 72 */       Object object1 = this.componentTypeAdapter.read(paramJsonReader);
/* 73 */       arrayList.add(object1);
/*    */     } 
/* 75 */     paramJsonReader.endArray();
/*    */     
/* 77 */     int i = arrayList.size();
/* 78 */     Object object = Array.newInstance(this.componentType, i);
/* 79 */     for (byte b = 0; b < i; b++) {
/* 80 */       Array.set(object, b, arrayList.get(b));
/*    */     }
/* 82 */     return object;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(JsonWriter paramJsonWriter, Object paramObject) throws IOException {
/* 87 */     if (paramObject == null) {
/* 88 */       paramJsonWriter.nullValue();
/*    */       
/*    */       return;
/*    */     } 
/* 92 */     paramJsonWriter.beginArray(); byte b; int i;
/* 93 */     for (b = 0, i = Array.getLength(paramObject); b < i; b++) {
/* 94 */       Object object = Array.get(paramObject, b);
/* 95 */       this.componentTypeAdapter.write(paramJsonWriter, object);
/*    */     } 
/* 97 */     paramJsonWriter.endArray();
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\ArrayTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */