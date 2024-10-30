/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.FieldNamingStrategy;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import com.google.gson.TypeAdapter;
/*     */ import com.google.gson.TypeAdapterFactory;
/*     */ import com.google.gson.annotations.JsonAdapter;
/*     */ import com.google.gson.annotations.SerializedName;
/*     */ import com.google.gson.internal.;
/*     */ import com.google.gson.internal.ConstructorConstructor;
/*     */ import com.google.gson.internal.Excluder;
/*     */ import com.google.gson.internal.ObjectConstructor;
/*     */ import com.google.gson.internal.Primitives;
/*     */ import com.google.gson.internal.reflect.ReflectionAccessor;
/*     */ import com.google.gson.reflect.TypeToken;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Type;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
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
/*     */ public final class ReflectiveTypeAdapterFactory
/*     */   implements TypeAdapterFactory
/*     */ {
/*     */   private final ConstructorConstructor constructorConstructor;
/*     */   private final FieldNamingStrategy fieldNamingPolicy;
/*     */   private final Excluder excluder;
/*     */   private final JsonAdapterAnnotationTypeAdapterFactory jsonAdapterFactory;
/*  53 */   private final ReflectionAccessor accessor = ReflectionAccessor.getInstance();
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectiveTypeAdapterFactory(ConstructorConstructor paramConstructorConstructor, FieldNamingStrategy paramFieldNamingStrategy, Excluder paramExcluder, JsonAdapterAnnotationTypeAdapterFactory paramJsonAdapterAnnotationTypeAdapterFactory) {
/*  58 */     this.constructorConstructor = paramConstructorConstructor;
/*  59 */     this.fieldNamingPolicy = paramFieldNamingStrategy;
/*  60 */     this.excluder = paramExcluder;
/*  61 */     this.jsonAdapterFactory = paramJsonAdapterAnnotationTypeAdapterFactory;
/*     */   }
/*     */   
/*     */   public boolean excludeField(Field paramField, boolean paramBoolean) {
/*  65 */     return excludeField(paramField, paramBoolean, this.excluder);
/*     */   }
/*     */   
/*     */   static boolean excludeField(Field paramField, boolean paramBoolean, Excluder paramExcluder) {
/*  69 */     return (!paramExcluder.excludeClass(paramField.getType(), paramBoolean) && !paramExcluder.excludeField(paramField, paramBoolean));
/*     */   }
/*     */ 
/*     */   
/*     */   private List<String> getFieldNames(Field paramField) {
/*  74 */     SerializedName serializedName = paramField.<SerializedName>getAnnotation(SerializedName.class);
/*  75 */     if (serializedName == null) {
/*  76 */       String str1 = this.fieldNamingPolicy.translateName(paramField);
/*  77 */       return Collections.singletonList(str1);
/*     */     } 
/*     */     
/*  80 */     String str = serializedName.value();
/*  81 */     String[] arrayOfString = serializedName.alternate();
/*  82 */     if (arrayOfString.length == 0) {
/*  83 */       return Collections.singletonList(str);
/*     */     }
/*     */     
/*  86 */     ArrayList<String> arrayList = new ArrayList(arrayOfString.length + 1);
/*  87 */     arrayList.add(str);
/*  88 */     for (String str1 : arrayOfString) {
/*  89 */       arrayList.add(str1);
/*     */     }
/*  91 */     return arrayList;
/*     */   }
/*     */   
/*     */   public <T> TypeAdapter<T> create(Gson paramGson, TypeToken<T> paramTypeToken) {
/*  95 */     Class<?> clazz = paramTypeToken.getRawType();
/*     */     
/*  97 */     if (!Object.class.isAssignableFrom(clazz)) {
/*  98 */       return null;
/*     */     }
/*     */     
/* 101 */     ObjectConstructor<T> objectConstructor = this.constructorConstructor.get(paramTypeToken);
/* 102 */     return new Adapter<T>(objectConstructor, getBoundFields(paramGson, paramTypeToken, clazz));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private BoundField createBoundField(final Gson context, final Field field, String paramString, final TypeToken<?> fieldType, boolean paramBoolean1, boolean paramBoolean2) {
/* 108 */     final boolean isPrimitive = Primitives.isPrimitive(fieldType.getRawType());
/*     */     
/* 110 */     JsonAdapter jsonAdapter = field.<JsonAdapter>getAnnotation(JsonAdapter.class);
/* 111 */     TypeAdapter<?> typeAdapter1 = null;
/* 112 */     if (jsonAdapter != null) {
/* 113 */       typeAdapter1 = this.jsonAdapterFactory.getTypeAdapter(this.constructorConstructor, context, fieldType, jsonAdapter);
/*     */     }
/*     */     
/* 116 */     final boolean jsonAdapterPresent = (typeAdapter1 != null) ? true : false;
/* 117 */     if (typeAdapter1 == null) typeAdapter1 = context.getAdapter(fieldType);
/*     */     
/* 119 */     final TypeAdapter<?> typeAdapter = typeAdapter1;
/* 120 */     return new BoundField(paramString, paramBoolean1, paramBoolean2)
/*     */       {
/*     */         void write(JsonWriter param1JsonWriter, Object param1Object) throws IOException, IllegalAccessException
/*     */         {
/* 124 */           Object object = field.get(param1Object);
/*     */           
/* 126 */           TypeAdapter typeAdapter = jsonAdapterPresent ? typeAdapter : new TypeAdapterRuntimeTypeWrapper(context, typeAdapter, fieldType.getType());
/* 127 */           typeAdapter.write(param1JsonWriter, object);
/*     */         }
/*     */         
/*     */         void read(JsonReader param1JsonReader, Object param1Object) throws IOException, IllegalAccessException {
/* 131 */           Object object = typeAdapter.read(param1JsonReader);
/* 132 */           if (object != null || !isPrimitive)
/* 133 */             field.set(param1Object, object); 
/*     */         }
/*     */         
/*     */         public boolean writeField(Object param1Object) throws IOException, IllegalAccessException {
/* 137 */           if (!this.serialized) return false; 
/* 138 */           Object object = field.get(param1Object);
/* 139 */           return (object != param1Object);
/*     */         }
/*     */       };
/*     */   }
/*     */   
/*     */   private Map<String, BoundField> getBoundFields(Gson paramGson, TypeToken<?> paramTypeToken, Class<?> paramClass) {
/* 145 */     LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<Object, Object>();
/* 146 */     if (paramClass.isInterface()) {
/* 147 */       return (Map)linkedHashMap;
/*     */     }
/*     */     
/* 150 */     Type type = paramTypeToken.getType();
/* 151 */     while (paramClass != Object.class) {
/* 152 */       Field[] arrayOfField = paramClass.getDeclaredFields();
/* 153 */       for (Field field : arrayOfField) {
/* 154 */         boolean bool1 = excludeField(field, true);
/* 155 */         boolean bool2 = excludeField(field, false);
/* 156 */         if (bool1 || bool2) {
/*     */ 
/*     */           
/* 159 */           this.accessor.makeAccessible(field);
/* 160 */           Type type1 = .Gson.Types.resolve(paramTypeToken.getType(), paramClass, field.getGenericType());
/* 161 */           List<String> list = getFieldNames(field);
/* 162 */           BoundField boundField = null; byte b; int i;
/* 163 */           for (b = 0, i = list.size(); b < i; b++) {
/* 164 */             String str = list.get(b);
/* 165 */             if (b != 0) bool1 = false; 
/* 166 */             BoundField boundField1 = createBoundField(paramGson, field, str, 
/* 167 */                 TypeToken.get(type1), bool1, bool2);
/* 168 */             BoundField boundField2 = (BoundField)linkedHashMap.put(str, boundField1);
/* 169 */             if (boundField == null) boundField = boundField2; 
/*     */           } 
/* 171 */           if (boundField != null) {
/* 172 */             throw new IllegalArgumentException(type + " declares multiple JSON fields named " + boundField.name);
/*     */           }
/*     */         } 
/*     */       } 
/* 176 */       paramTypeToken = TypeToken.get(.Gson.Types.resolve(paramTypeToken.getType(), paramClass, paramClass.getGenericSuperclass()));
/* 177 */       paramClass = paramTypeToken.getRawType();
/*     */     } 
/* 179 */     return (Map)linkedHashMap;
/*     */   }
/*     */   
/*     */   static abstract class BoundField {
/*     */     final String name;
/*     */     final boolean serialized;
/*     */     final boolean deserialized;
/*     */     
/*     */     protected BoundField(String param1String, boolean param1Boolean1, boolean param1Boolean2) {
/* 188 */       this.name = param1String;
/* 189 */       this.serialized = param1Boolean1;
/* 190 */       this.deserialized = param1Boolean2;
/*     */     }
/*     */     
/*     */     abstract boolean writeField(Object param1Object) throws IOException, IllegalAccessException;
/*     */     
/*     */     abstract void write(JsonWriter param1JsonWriter, Object param1Object) throws IOException, IllegalAccessException;
/*     */     
/*     */     abstract void read(JsonReader param1JsonReader, Object param1Object) throws IOException, IllegalAccessException; }
/*     */   
/*     */   public static final class Adapter<T> extends TypeAdapter<T> { private final ObjectConstructor<T> constructor;
/*     */     
/*     */     Adapter(ObjectConstructor<T> param1ObjectConstructor, Map<String, ReflectiveTypeAdapterFactory.BoundField> param1Map) {
/* 202 */       this.constructor = param1ObjectConstructor;
/* 203 */       this.boundFields = param1Map;
/*     */     }
/*     */     private final Map<String, ReflectiveTypeAdapterFactory.BoundField> boundFields;
/*     */     public T read(JsonReader param1JsonReader) throws IOException {
/* 207 */       if (param1JsonReader.peek() == JsonToken.NULL) {
/* 208 */         param1JsonReader.nextNull();
/* 209 */         return null;
/*     */       } 
/*     */       
/* 212 */       Object object = this.constructor.construct();
/*     */       
/*     */       try {
/* 215 */         param1JsonReader.beginObject();
/* 216 */         while (param1JsonReader.hasNext()) {
/* 217 */           String str = param1JsonReader.nextName();
/* 218 */           ReflectiveTypeAdapterFactory.BoundField boundField = this.boundFields.get(str);
/* 219 */           if (boundField == null || !boundField.deserialized) {
/* 220 */             param1JsonReader.skipValue(); continue;
/*     */           } 
/* 222 */           boundField.read(param1JsonReader, object);
/*     */         }
/*     */       
/* 225 */       } catch (IllegalStateException illegalStateException) {
/* 226 */         throw new JsonSyntaxException(illegalStateException);
/* 227 */       } catch (IllegalAccessException illegalAccessException) {
/* 228 */         throw new AssertionError(illegalAccessException);
/*     */       } 
/* 230 */       param1JsonReader.endObject();
/* 231 */       return (T)object;
/*     */     }
/*     */     
/*     */     public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
/* 235 */       if (param1T == null) {
/* 236 */         param1JsonWriter.nullValue();
/*     */         
/*     */         return;
/*     */       } 
/* 240 */       param1JsonWriter.beginObject();
/*     */       try {
/* 242 */         for (ReflectiveTypeAdapterFactory.BoundField boundField : this.boundFields.values()) {
/* 243 */           if (boundField.writeField(param1T)) {
/* 244 */             param1JsonWriter.name(boundField.name);
/* 245 */             boundField.write(param1JsonWriter, param1T);
/*     */           } 
/*     */         } 
/* 248 */       } catch (IllegalAccessException illegalAccessException) {
/* 249 */         throw new AssertionError(illegalAccessException);
/*     */       } 
/* 251 */       param1JsonWriter.endObject();
/*     */     } }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\ReflectiveTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */