/*     */ package com.google.gson;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JsonArray
/*     */   extends JsonElement
/*     */   implements Iterable<JsonElement>
/*     */ {
/*     */   private final List<JsonElement> elements;
/*     */   
/*     */   public JsonArray() {
/*  40 */     this.elements = new ArrayList<JsonElement>();
/*     */   }
/*     */   
/*     */   public JsonArray(int paramInt) {
/*  44 */     this.elements = new ArrayList<JsonElement>(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonArray deepCopy() {
/*  53 */     if (!this.elements.isEmpty()) {
/*  54 */       JsonArray jsonArray = new JsonArray(this.elements.size());
/*  55 */       for (JsonElement jsonElement : this.elements) {
/*  56 */         jsonArray.add(jsonElement.deepCopy());
/*     */       }
/*  58 */       return jsonArray;
/*     */     } 
/*  60 */     return new JsonArray();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Boolean paramBoolean) {
/*  69 */     this.elements.add((paramBoolean == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Character paramCharacter) {
/*  78 */     this.elements.add((paramCharacter == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramCharacter));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(Number paramNumber) {
/*  87 */     this.elements.add((paramNumber == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramNumber));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(String paramString) {
/*  96 */     this.elements.add((paramString == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void add(JsonElement paramJsonElement) {
/* 105 */     if (paramJsonElement == null) {
/* 106 */       paramJsonElement = JsonNull.INSTANCE;
/*     */     }
/* 108 */     this.elements.add(paramJsonElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addAll(JsonArray paramJsonArray) {
/* 117 */     this.elements.addAll(paramJsonArray.elements);
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
/*     */   public JsonElement set(int paramInt, JsonElement paramJsonElement) {
/* 129 */     return this.elements.set(paramInt, paramJsonElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean remove(JsonElement paramJsonElement) {
/* 140 */     return this.elements.remove(paramJsonElement);
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
/*     */   public JsonElement remove(int paramInt) {
/* 153 */     return this.elements.remove(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean contains(JsonElement paramJsonElement) {
/* 163 */     return this.elements.contains(paramJsonElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 172 */     return this.elements.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<JsonElement> iterator() {
/* 182 */     return this.elements.iterator();
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
/*     */   public JsonElement get(int paramInt) {
/* 194 */     return this.elements.get(paramInt);
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
/*     */   public Number getAsNumber() {
/* 207 */     if (this.elements.size() == 1) {
/* 208 */       return ((JsonElement)this.elements.get(0)).getAsNumber();
/*     */     }
/* 210 */     throw new IllegalStateException();
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
/*     */   public String getAsString() {
/* 223 */     if (this.elements.size() == 1) {
/* 224 */       return ((JsonElement)this.elements.get(0)).getAsString();
/*     */     }
/* 226 */     throw new IllegalStateException();
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
/*     */   public double getAsDouble() {
/* 239 */     if (this.elements.size() == 1) {
/* 240 */       return ((JsonElement)this.elements.get(0)).getAsDouble();
/*     */     }
/* 242 */     throw new IllegalStateException();
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
/*     */   public BigDecimal getAsBigDecimal() {
/* 256 */     if (this.elements.size() == 1) {
/* 257 */       return ((JsonElement)this.elements.get(0)).getAsBigDecimal();
/*     */     }
/* 259 */     throw new IllegalStateException();
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
/*     */   public BigInteger getAsBigInteger() {
/* 273 */     if (this.elements.size() == 1) {
/* 274 */       return ((JsonElement)this.elements.get(0)).getAsBigInteger();
/*     */     }
/* 276 */     throw new IllegalStateException();
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
/*     */   public float getAsFloat() {
/* 289 */     if (this.elements.size() == 1) {
/* 290 */       return ((JsonElement)this.elements.get(0)).getAsFloat();
/*     */     }
/* 292 */     throw new IllegalStateException();
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
/*     */   public long getAsLong() {
/* 305 */     if (this.elements.size() == 1) {
/* 306 */       return ((JsonElement)this.elements.get(0)).getAsLong();
/*     */     }
/* 308 */     throw new IllegalStateException();
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
/*     */   public int getAsInt() {
/* 321 */     if (this.elements.size() == 1) {
/* 322 */       return ((JsonElement)this.elements.get(0)).getAsInt();
/*     */     }
/* 324 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public byte getAsByte() {
/* 329 */     if (this.elements.size() == 1) {
/* 330 */       return ((JsonElement)this.elements.get(0)).getAsByte();
/*     */     }
/* 332 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public char getAsCharacter() {
/* 337 */     if (this.elements.size() == 1) {
/* 338 */       return ((JsonElement)this.elements.get(0)).getAsCharacter();
/*     */     }
/* 340 */     throw new IllegalStateException();
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
/*     */   public short getAsShort() {
/* 353 */     if (this.elements.size() == 1) {
/* 354 */       return ((JsonElement)this.elements.get(0)).getAsShort();
/*     */     }
/* 356 */     throw new IllegalStateException();
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
/*     */   public boolean getAsBoolean() {
/* 369 */     if (this.elements.size() == 1) {
/* 370 */       return ((JsonElement)this.elements.get(0)).getAsBoolean();
/*     */     }
/* 372 */     throw new IllegalStateException();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 377 */     return (paramObject == this || (paramObject instanceof JsonArray && ((JsonArray)paramObject).elements.equals(this.elements)));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 382 */     return this.elements.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\JsonArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */