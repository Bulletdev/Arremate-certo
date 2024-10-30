/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonNull;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JsonTreeWriter
/*     */   extends JsonWriter
/*     */ {
/*  34 */   private static final Writer UNWRITABLE_WRITER = new Writer() {
/*     */       public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/*  36 */         throw new AssertionError();
/*     */       }
/*     */       public void flush() throws IOException {
/*  39 */         throw new AssertionError();
/*     */       }
/*     */       public void close() throws IOException {
/*  42 */         throw new AssertionError();
/*     */       }
/*     */     };
/*     */   
/*  46 */   private static final JsonPrimitive SENTINEL_CLOSED = new JsonPrimitive("closed");
/*     */ 
/*     */   
/*  49 */   private final List<JsonElement> stack = new ArrayList<JsonElement>();
/*     */ 
/*     */   
/*     */   private String pendingName;
/*     */ 
/*     */   
/*  55 */   private JsonElement product = (JsonElement)JsonNull.INSTANCE;
/*     */   
/*     */   public JsonTreeWriter() {
/*  58 */     super(UNWRITABLE_WRITER);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonElement get() {
/*  65 */     if (!this.stack.isEmpty()) {
/*  66 */       throw new IllegalStateException("Expected one JSON element but was " + this.stack);
/*     */     }
/*  68 */     return this.product;
/*     */   }
/*     */   
/*     */   private JsonElement peek() {
/*  72 */     return this.stack.get(this.stack.size() - 1);
/*     */   }
/*     */   
/*     */   private void put(JsonElement paramJsonElement) {
/*  76 */     if (this.pendingName != null) {
/*  77 */       if (!paramJsonElement.isJsonNull() || getSerializeNulls()) {
/*  78 */         JsonObject jsonObject = (JsonObject)peek();
/*  79 */         jsonObject.add(this.pendingName, paramJsonElement);
/*     */       } 
/*  81 */       this.pendingName = null;
/*  82 */     } else if (this.stack.isEmpty()) {
/*  83 */       this.product = paramJsonElement;
/*     */     } else {
/*  85 */       JsonElement jsonElement = peek();
/*  86 */       if (jsonElement instanceof JsonArray) {
/*  87 */         ((JsonArray)jsonElement).add(paramJsonElement);
/*     */       } else {
/*  89 */         throw new IllegalStateException();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public JsonWriter beginArray() throws IOException {
/*  95 */     JsonArray jsonArray = new JsonArray();
/*  96 */     put((JsonElement)jsonArray);
/*  97 */     this.stack.add(jsonArray);
/*  98 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter endArray() throws IOException {
/* 102 */     if (this.stack.isEmpty() || this.pendingName != null) {
/* 103 */       throw new IllegalStateException();
/*     */     }
/* 105 */     JsonElement jsonElement = peek();
/* 106 */     if (jsonElement instanceof JsonArray) {
/* 107 */       this.stack.remove(this.stack.size() - 1);
/* 108 */       return this;
/*     */     } 
/* 110 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   public JsonWriter beginObject() throws IOException {
/* 114 */     JsonObject jsonObject = new JsonObject();
/* 115 */     put((JsonElement)jsonObject);
/* 116 */     this.stack.add(jsonObject);
/* 117 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter endObject() throws IOException {
/* 121 */     if (this.stack.isEmpty() || this.pendingName != null) {
/* 122 */       throw new IllegalStateException();
/*     */     }
/* 124 */     JsonElement jsonElement = peek();
/* 125 */     if (jsonElement instanceof JsonObject) {
/* 126 */       this.stack.remove(this.stack.size() - 1);
/* 127 */       return this;
/*     */     } 
/* 129 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   public JsonWriter name(String paramString) throws IOException {
/* 133 */     if (this.stack.isEmpty() || this.pendingName != null) {
/* 134 */       throw new IllegalStateException();
/*     */     }
/* 136 */     JsonElement jsonElement = peek();
/* 137 */     if (jsonElement instanceof JsonObject) {
/* 138 */       this.pendingName = paramString;
/* 139 */       return this;
/*     */     } 
/* 141 */     throw new IllegalStateException();
/*     */   }
/*     */   
/*     */   public JsonWriter value(String paramString) throws IOException {
/* 145 */     if (paramString == null) {
/* 146 */       return nullValue();
/*     */     }
/* 148 */     put((JsonElement)new JsonPrimitive(paramString));
/* 149 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter nullValue() throws IOException {
/* 153 */     put((JsonElement)JsonNull.INSTANCE);
/* 154 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(boolean paramBoolean) throws IOException {
/* 158 */     put((JsonElement)new JsonPrimitive(Boolean.valueOf(paramBoolean)));
/* 159 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(Boolean paramBoolean) throws IOException {
/* 163 */     if (paramBoolean == null) {
/* 164 */       return nullValue();
/*     */     }
/* 166 */     put((JsonElement)new JsonPrimitive(paramBoolean));
/* 167 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(double paramDouble) throws IOException {
/* 171 */     if (!isLenient() && (Double.isNaN(paramDouble) || Double.isInfinite(paramDouble))) {
/* 172 */       throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramDouble);
/*     */     }
/* 174 */     put((JsonElement)new JsonPrimitive(Double.valueOf(paramDouble)));
/* 175 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(long paramLong) throws IOException {
/* 179 */     put((JsonElement)new JsonPrimitive(Long.valueOf(paramLong)));
/* 180 */     return this;
/*     */   }
/*     */   
/*     */   public JsonWriter value(Number paramNumber) throws IOException {
/* 184 */     if (paramNumber == null) {
/* 185 */       return nullValue();
/*     */     }
/*     */     
/* 188 */     if (!isLenient()) {
/* 189 */       double d = paramNumber.doubleValue();
/* 190 */       if (Double.isNaN(d) || Double.isInfinite(d)) {
/* 191 */         throw new IllegalArgumentException("JSON forbids NaN and infinities: " + paramNumber);
/*     */       }
/*     */     } 
/*     */     
/* 195 */     put((JsonElement)new JsonPrimitive(paramNumber));
/* 196 */     return this;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flush() throws IOException {}
/*     */   
/*     */   public void close() throws IOException {
/* 203 */     if (!this.stack.isEmpty()) {
/* 204 */       throw new IOException("Incomplete document");
/*     */     }
/* 206 */     this.stack.add(SENTINEL_CLOSED);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\JsonTreeWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */