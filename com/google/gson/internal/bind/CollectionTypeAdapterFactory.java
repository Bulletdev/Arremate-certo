/*    */ package com.google.gson.internal.bind;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.internal.;
/*    */ import com.google.gson.internal.ConstructorConstructor;
/*    */ import com.google.gson.internal.ObjectConstructor;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonToken;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.lang.reflect.Type;
/*    */ import java.util.Collection;
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
/*    */ public final class CollectionTypeAdapterFactory
/*    */   implements TypeAdapterFactory
/*    */ {
/*    */   private final ConstructorConstructor constructorConstructor;
/*    */   
/*    */   public CollectionTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor) {
/* 40 */     this.constructorConstructor = paramConstructorConstructor;
/*    */   }
/*    */ 
/*    */   
/*    */   public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
/* 45 */     Type type1 = paramTypeToken.getType();
/*    */     
/* 47 */     Class<?> clazz = paramTypeToken.getRawType();
/* 48 */     if (!Collection.class.isAssignableFrom(clazz)) {
/* 49 */       return null;
/*    */     }
/*    */     
/* 52 */     Type type2 = .Gson.Types.getCollectionElementType(type1, clazz);
/* 53 */     TypeAdapter<?> typeAdapter = paramGson.getAdapter(TypeToken.get(type2));
/* 54 */     ObjectConstructor<? extends Collection<?>> objectConstructor = this.constructorConstructor.get(paramTypeToken);
/*    */ 
/*    */     
/* 57 */     return new Adapter(paramGson, type2, typeAdapter, objectConstructor);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final class Adapter<E>
/*    */     extends TypeAdapter<Collection<E>>
/*    */   {
/*    */     private final TypeAdapter<E> elementTypeAdapter;
/*    */     private final ObjectConstructor<? extends Collection<E>> constructor;
/*    */     
/*    */     public Adapter(Gson param1Gson, Type param1Type, TypeAdapter<E> param1TypeAdapter, ObjectConstructor<? extends Collection<E>> param1ObjectConstructor) {
/* 68 */       this.elementTypeAdapter = new TypeAdapterRuntimeTypeWrapper<E>(param1Gson, param1TypeAdapter, param1Type);
/*    */       
/* 70 */       this.constructor = param1ObjectConstructor;
/*    */     }
/*    */     
/*    */     public Collection<E> read(JsonReader param1JsonReader) throws IOException {
/* 74 */       if (param1JsonReader.peek() == JsonToken.NULL) {
/* 75 */         param1JsonReader.nextNull();
/* 76 */         return null;
/*    */       } 
/*    */       
/* 79 */       Collection<Object> collection = (Collection)this.constructor.construct();
/* 80 */       param1JsonReader.beginArray();
/* 81 */       while (param1JsonReader.hasNext()) {
/* 82 */         Object object = this.elementTypeAdapter.read(param1JsonReader);
/* 83 */         collection.add(object);
/*    */       } 
/* 85 */       param1JsonReader.endArray();
/* 86 */       return (Collection)collection;
/*    */     }
/*    */     
/*    */     public void write(JsonWriter param1JsonWriter, Collection<E> param1Collection) throws IOException {
/*    */       // Byte code:
/*    */       //   0: aload_2
/*    */       //   1: ifnonnull -> 10
/*    */       //   4: aload_1
/*    */       //   5: invokevirtual nullValue : ()Lcom/google/gson/stream/JsonWriter;
/*    */       //   8: pop
/*    */       //   9: return
/*    */       //   10: aload_1
/*    */       //   11: invokevirtual beginArray : ()Lcom/google/gson/stream/JsonWriter;
/*    */       //   14: pop
/*    */       //   15: aload_2
/*    */       //   16: invokeinterface iterator : ()Ljava/util/Iterator;
/*    */       //   21: astore_3
/*    */       //   22: aload_3
/*    */       //   23: invokeinterface hasNext : ()Z
/*    */       //   28: ifeq -> 52
/*    */       //   31: aload_3
/*    */       //   32: invokeinterface next : ()Ljava/lang/Object;
/*    */       //   37: astore #4
/*    */       //   39: aload_0
/*    */       //   40: getfield elementTypeAdapter : Lcom/google/gson/TypeAdapter;
/*    */       //   43: aload_1
/*    */       //   44: aload #4
/*    */       //   46: invokevirtual write : (Lcom/google/gson/stream/JsonWriter;Ljava/lang/Object;)V
/*    */       //   49: goto -> 22
/*    */       //   52: aload_1
/*    */       //   53: invokevirtual endArray : ()Lcom/google/gson/stream/JsonWriter;
/*    */       //   56: pop
/*    */       //   57: return
/*    */       // Line number table:
/*    */       //   Java source line number -> byte code offset
/*    */       //   #90	-> 0
/*    */       //   #91	-> 4
/*    */       //   #92	-> 9
/*    */       //   #95	-> 10
/*    */       //   #96	-> 15
/*    */       //   #97	-> 39
/*    */       //   #98	-> 49
/*    */       //   #99	-> 52
/*    */       //   #100	-> 57
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\CollectionTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */