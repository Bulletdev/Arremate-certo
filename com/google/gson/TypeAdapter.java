/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.bind.JsonTreeReader;
/*     */ import com.google.gson.internal.bind.JsonTreeWriter;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class TypeAdapter<T>
/*     */ {
/*     */   public abstract void write(JsonWriter paramJsonWriter, T paramT) throws IOException;
/*     */   
/*     */   public final void toJson(Writer paramWriter, T paramT) throws IOException {
/* 141 */     JsonWriter jsonWriter = new JsonWriter(paramWriter);
/* 142 */     write(jsonWriter, paramT);
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
/*     */   public final TypeAdapter<T> nullSafe() {
/* 186 */     return new TypeAdapter<T>() {
/*     */         public void write(JsonWriter param1JsonWriter, T param1T) throws IOException {
/* 188 */           if (param1T == null) {
/* 189 */             param1JsonWriter.nullValue();
/*     */           } else {
/* 191 */             TypeAdapter.this.write(param1JsonWriter, param1T);
/*     */           } 
/*     */         }
/*     */         public T read(JsonReader param1JsonReader) throws IOException {
/* 195 */           if (param1JsonReader.peek() == JsonToken.NULL) {
/* 196 */             param1JsonReader.nextNull();
/* 197 */             return null;
/*     */           } 
/* 199 */           return TypeAdapter.this.read(param1JsonReader);
/*     */         }
/*     */       };
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
/*     */   public final String toJson(T paramT) {
/* 215 */     StringWriter stringWriter = new StringWriter();
/*     */     try {
/* 217 */       toJson(stringWriter, paramT);
/* 218 */     } catch (IOException iOException) {
/* 219 */       throw new AssertionError(iOException);
/*     */     } 
/* 221 */     return stringWriter.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final JsonElement toJsonTree(T paramT) {
/*     */     try {
/* 233 */       JsonTreeWriter jsonTreeWriter = new JsonTreeWriter();
/* 234 */       write((JsonWriter)jsonTreeWriter, paramT);
/* 235 */       return jsonTreeWriter.get();
/* 236 */     } catch (IOException iOException) {
/* 237 */       throw new JsonIOException(iOException);
/*     */     } 
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
/*     */   public abstract T read(JsonReader paramJsonReader) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T fromJson(Reader paramReader) throws IOException {
/* 259 */     JsonReader jsonReader = new JsonReader(paramReader);
/* 260 */     return read(jsonReader);
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
/*     */   public final T fromJson(String paramString) throws IOException {
/* 273 */     return fromJson(new StringReader(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final T fromJsonTree(JsonElement paramJsonElement) {
/*     */     try {
/* 284 */       JsonTreeReader jsonTreeReader = new JsonTreeReader(paramJsonElement);
/* 285 */       return read((JsonReader)jsonTreeReader);
/* 286 */     } catch (IOException iOException) {
/* 287 */       throw new JsonIOException(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\TypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */