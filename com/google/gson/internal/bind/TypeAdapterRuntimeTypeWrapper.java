/*    */ package com.google.gson.internal.bind;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Type;
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
/*    */ final class TypeAdapterRuntimeTypeWrapper<T>
/*    */   extends TypeAdapter<T>
/*    */ {
/*    */   private final Gson context;
/*    */   private final TypeAdapter<T> delegate;
/*    */   private final Type type;
/*    */   
/*    */   TypeAdapterRuntimeTypeWrapper(Gson paramGson, TypeAdapter<T> paramTypeAdapter, Type paramType) {
/* 34 */     this.context = paramGson;
/* 35 */     this.delegate = paramTypeAdapter;
/* 36 */     this.type = paramType;
/*    */   }
/*    */ 
/*    */   
/*    */   public T read(JsonReader paramJsonReader) throws IOException {
/* 41 */     return (T)this.delegate.read(paramJsonReader);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void write(JsonWriter paramJsonWriter, T paramT) throws IOException {
/* 53 */     TypeAdapter<T> typeAdapter = this.delegate;
/* 54 */     Type type = getRuntimeTypeIfMoreSpecific(this.type, paramT);
/* 55 */     if (type != this.type) {
/* 56 */       TypeAdapter<T> typeAdapter1 = this.context.getAdapter(TypeToken.get(type));
/* 57 */       if (!(typeAdapter1 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
/*    */         
/* 59 */         typeAdapter = typeAdapter1;
/* 60 */       } else if (!(this.delegate instanceof ReflectiveTypeAdapterFactory.Adapter)) {
/*    */ 
/*    */         
/* 63 */         typeAdapter = this.delegate;
/*    */       } else {
/*    */         
/* 66 */         typeAdapter = typeAdapter1;
/*    */       } 
/*    */     } 
/* 69 */     typeAdapter.write(paramJsonWriter, paramT);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private Type getRuntimeTypeIfMoreSpecific(Type<?> paramType, Object paramObject) {
/* 76 */     if (paramObject != null && (paramType == Object.class || paramType instanceof java.lang.reflect.TypeVariable || paramType instanceof Class))
/*    */     {
/* 78 */       paramType = paramObject.getClass();
/*    */     }
/* 80 */     return paramType;
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\TypeAdapterRuntimeTypeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */