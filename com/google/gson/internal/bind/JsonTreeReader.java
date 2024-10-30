/*     */ package com.google.gson.internal.bind;
/*     */ 
/*     */ import com.google.gson.JsonArray;
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonObject;
/*     */ import com.google.gson.JsonPrimitive;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Iterator;
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
/*     */ public final class JsonTreeReader
/*     */   extends JsonReader
/*     */ {
/*  38 */   private static final Reader UNREADABLE_READER = new Reader() {
/*     */       public int read(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/*  40 */         throw new AssertionError();
/*     */       }
/*     */       public void close() throws IOException {
/*  43 */         throw new AssertionError();
/*     */       }
/*     */     };
/*  46 */   private static final Object SENTINEL_CLOSED = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  51 */   private Object[] stack = new Object[32];
/*  52 */   private int stackSize = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  62 */   private String[] pathNames = new String[32];
/*  63 */   private int[] pathIndices = new int[32];
/*     */   
/*     */   public JsonTreeReader(JsonElement paramJsonElement) {
/*  66 */     super(UNREADABLE_READER);
/*  67 */     push(paramJsonElement);
/*     */   }
/*     */   
/*     */   public void beginArray() throws IOException {
/*  71 */     expect(JsonToken.BEGIN_ARRAY);
/*  72 */     JsonArray jsonArray = (JsonArray)peekStack();
/*  73 */     push(jsonArray.iterator());
/*  74 */     this.pathIndices[this.stackSize - 1] = 0;
/*     */   }
/*     */   
/*     */   public void endArray() throws IOException {
/*  78 */     expect(JsonToken.END_ARRAY);
/*  79 */     popStack();
/*  80 */     popStack();
/*  81 */     if (this.stackSize > 0) {
/*  82 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public void beginObject() throws IOException {
/*  87 */     expect(JsonToken.BEGIN_OBJECT);
/*  88 */     JsonObject jsonObject = (JsonObject)peekStack();
/*  89 */     push(jsonObject.entrySet().iterator());
/*     */   }
/*     */   
/*     */   public void endObject() throws IOException {
/*  93 */     expect(JsonToken.END_OBJECT);
/*  94 */     popStack();
/*  95 */     popStack();
/*  96 */     if (this.stackSize > 0) {
/*  97 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean hasNext() throws IOException {
/* 102 */     JsonToken jsonToken = peek();
/* 103 */     return (jsonToken != JsonToken.END_OBJECT && jsonToken != JsonToken.END_ARRAY);
/*     */   }
/*     */   
/*     */   public JsonToken peek() throws IOException {
/* 107 */     if (this.stackSize == 0) {
/* 108 */       return JsonToken.END_DOCUMENT;
/*     */     }
/*     */     
/* 111 */     Object object = peekStack();
/* 112 */     if (object instanceof Iterator) {
/* 113 */       boolean bool = this.stack[this.stackSize - 2] instanceof JsonObject;
/* 114 */       Iterator iterator = (Iterator)object;
/* 115 */       if (iterator.hasNext()) {
/* 116 */         if (bool) {
/* 117 */           return JsonToken.NAME;
/*     */         }
/* 119 */         push(iterator.next());
/* 120 */         return peek();
/*     */       } 
/*     */       
/* 123 */       return bool ? JsonToken.END_OBJECT : JsonToken.END_ARRAY;
/*     */     } 
/* 125 */     if (object instanceof JsonObject)
/* 126 */       return JsonToken.BEGIN_OBJECT; 
/* 127 */     if (object instanceof JsonArray)
/* 128 */       return JsonToken.BEGIN_ARRAY; 
/* 129 */     if (object instanceof JsonPrimitive) {
/* 130 */       JsonPrimitive jsonPrimitive = (JsonPrimitive)object;
/* 131 */       if (jsonPrimitive.isString())
/* 132 */         return JsonToken.STRING; 
/* 133 */       if (jsonPrimitive.isBoolean())
/* 134 */         return JsonToken.BOOLEAN; 
/* 135 */       if (jsonPrimitive.isNumber()) {
/* 136 */         return JsonToken.NUMBER;
/*     */       }
/* 138 */       throw new AssertionError();
/*     */     } 
/* 140 */     if (object instanceof com.google.gson.JsonNull)
/* 141 */       return JsonToken.NULL; 
/* 142 */     if (object == SENTINEL_CLOSED) {
/* 143 */       throw new IllegalStateException("JsonReader is closed");
/*     */     }
/* 145 */     throw new AssertionError();
/*     */   }
/*     */ 
/*     */   
/*     */   private Object peekStack() {
/* 150 */     return this.stack[this.stackSize - 1];
/*     */   }
/*     */   
/*     */   private Object popStack() {
/* 154 */     Object object = this.stack[--this.stackSize];
/* 155 */     this.stack[this.stackSize] = null;
/* 156 */     return object;
/*     */   }
/*     */   
/*     */   private void expect(JsonToken paramJsonToken) throws IOException {
/* 160 */     if (peek() != paramJsonToken) {
/* 161 */       throw new IllegalStateException("Expected " + paramJsonToken + " but was " + 
/* 162 */           peek() + locationString());
/*     */     }
/*     */   }
/*     */   
/*     */   public String nextName() throws IOException {
/* 167 */     expect(JsonToken.NAME);
/* 168 */     Iterator<Map.Entry> iterator = (Iterator)peekStack();
/* 169 */     Map.Entry entry = iterator.next();
/* 170 */     String str = (String)entry.getKey();
/* 171 */     this.pathNames[this.stackSize - 1] = str;
/* 172 */     push(entry.getValue());
/* 173 */     return str;
/*     */   }
/*     */   
/*     */   public String nextString() throws IOException {
/* 177 */     JsonToken jsonToken = peek();
/* 178 */     if (jsonToken != JsonToken.STRING && jsonToken != JsonToken.NUMBER) {
/* 179 */       throw new IllegalStateException("Expected " + JsonToken.STRING + " but was " + jsonToken + 
/* 180 */           locationString());
/*     */     }
/* 182 */     String str = ((JsonPrimitive)popStack()).getAsString();
/* 183 */     if (this.stackSize > 0) {
/* 184 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/* 186 */     return str;
/*     */   }
/*     */   
/*     */   public boolean nextBoolean() throws IOException {
/* 190 */     expect(JsonToken.BOOLEAN);
/* 191 */     boolean bool = ((JsonPrimitive)popStack()).getAsBoolean();
/* 192 */     if (this.stackSize > 0) {
/* 193 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/* 195 */     return bool;
/*     */   }
/*     */   
/*     */   public void nextNull() throws IOException {
/* 199 */     expect(JsonToken.NULL);
/* 200 */     popStack();
/* 201 */     if (this.stackSize > 0) {
/* 202 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public double nextDouble() throws IOException {
/* 207 */     JsonToken jsonToken = peek();
/* 208 */     if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
/* 209 */       throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonToken + 
/* 210 */           locationString());
/*     */     }
/* 212 */     double d = ((JsonPrimitive)peekStack()).getAsDouble();
/* 213 */     if (!isLenient() && (Double.isNaN(d) || Double.isInfinite(d))) {
/* 214 */       throw new NumberFormatException("JSON forbids NaN and infinities: " + d);
/*     */     }
/* 216 */     popStack();
/* 217 */     if (this.stackSize > 0) {
/* 218 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/* 220 */     return d;
/*     */   }
/*     */   
/*     */   public long nextLong() throws IOException {
/* 224 */     JsonToken jsonToken = peek();
/* 225 */     if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
/* 226 */       throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonToken + 
/* 227 */           locationString());
/*     */     }
/* 229 */     long l = ((JsonPrimitive)peekStack()).getAsLong();
/* 230 */     popStack();
/* 231 */     if (this.stackSize > 0) {
/* 232 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/* 234 */     return l;
/*     */   }
/*     */   
/*     */   public int nextInt() throws IOException {
/* 238 */     JsonToken jsonToken = peek();
/* 239 */     if (jsonToken != JsonToken.NUMBER && jsonToken != JsonToken.STRING) {
/* 240 */       throw new IllegalStateException("Expected " + JsonToken.NUMBER + " but was " + jsonToken + 
/* 241 */           locationString());
/*     */     }
/* 243 */     int i = ((JsonPrimitive)peekStack()).getAsInt();
/* 244 */     popStack();
/* 245 */     if (this.stackSize > 0) {
/* 246 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/* 248 */     return i;
/*     */   }
/*     */   
/*     */   public void close() throws IOException {
/* 252 */     this.stack = new Object[] { SENTINEL_CLOSED };
/* 253 */     this.stackSize = 1;
/*     */   }
/*     */   
/*     */   public void skipValue() throws IOException {
/* 257 */     if (peek() == JsonToken.NAME) {
/* 258 */       nextName();
/* 259 */       this.pathNames[this.stackSize - 2] = "null";
/*     */     } else {
/* 261 */       popStack();
/* 262 */       if (this.stackSize > 0) {
/* 263 */         this.pathNames[this.stackSize - 1] = "null";
/*     */       }
/*     */     } 
/* 266 */     if (this.stackSize > 0) {
/* 267 */       this.pathIndices[this.stackSize - 1] = this.pathIndices[this.stackSize - 1] + 1;
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString() {
/* 272 */     return getClass().getSimpleName();
/*     */   }
/*     */   
/*     */   public void promoteNameToValue() throws IOException {
/* 276 */     expect(JsonToken.NAME);
/* 277 */     Iterator<Map.Entry> iterator = (Iterator)peekStack();
/* 278 */     Map.Entry entry = iterator.next();
/* 279 */     push(entry.getValue());
/* 280 */     push(new JsonPrimitive((String)entry.getKey()));
/*     */   }
/*     */   
/*     */   private void push(Object paramObject) {
/* 284 */     if (this.stackSize == this.stack.length) {
/* 285 */       Object[] arrayOfObject = new Object[this.stackSize * 2];
/* 286 */       int[] arrayOfInt = new int[this.stackSize * 2];
/* 287 */       String[] arrayOfString = new String[this.stackSize * 2];
/* 288 */       System.arraycopy(this.stack, 0, arrayOfObject, 0, this.stackSize);
/* 289 */       System.arraycopy(this.pathIndices, 0, arrayOfInt, 0, this.stackSize);
/* 290 */       System.arraycopy(this.pathNames, 0, arrayOfString, 0, this.stackSize);
/* 291 */       this.stack = arrayOfObject;
/* 292 */       this.pathIndices = arrayOfInt;
/* 293 */       this.pathNames = arrayOfString;
/*     */     } 
/* 295 */     this.stack[this.stackSize++] = paramObject;
/*     */   }
/*     */   
/*     */   public String getPath() {
/* 299 */     StringBuilder stringBuilder = (new StringBuilder()).append('$');
/* 300 */     for (byte b = 0; b < this.stackSize; b++) {
/* 301 */       if (this.stack[b] instanceof JsonArray) {
/* 302 */         if (this.stack[++b] instanceof Iterator) {
/* 303 */           stringBuilder.append('[').append(this.pathIndices[b]).append(']');
/*     */         }
/* 305 */       } else if (this.stack[b] instanceof JsonObject && 
/* 306 */         this.stack[++b] instanceof Iterator) {
/* 307 */         stringBuilder.append('.');
/* 308 */         if (this.pathNames[b] != null) {
/* 309 */           stringBuilder.append(this.pathNames[b]);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     return stringBuilder.toString();
/*     */   }
/*     */   
/*     */   private String locationString() {
/* 318 */     return " at path " + getPath();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\JsonTreeReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */