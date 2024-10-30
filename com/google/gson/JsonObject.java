/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.LinkedTreeMap;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class JsonObject
/*     */   extends JsonElement
/*     */ {
/*  33 */   private final LinkedTreeMap<String, JsonElement> members = new LinkedTreeMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonObject deepCopy() {
/*  42 */     JsonObject jsonObject = new JsonObject();
/*  43 */     for (Map.Entry entry : this.members.entrySet()) {
/*  44 */       jsonObject.add((String)entry.getKey(), ((JsonElement)entry.getValue()).deepCopy());
/*     */     }
/*  46 */     return jsonObject;
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
/*     */   public void add(String paramString, JsonElement paramJsonElement) {
/*  58 */     if (paramJsonElement == null) {
/*  59 */       paramJsonElement = JsonNull.INSTANCE;
/*     */     }
/*  61 */     this.members.put(paramString, paramJsonElement);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonElement remove(String paramString) {
/*  72 */     return (JsonElement)this.members.remove(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperty(String paramString1, String paramString2) {
/*  83 */     add(paramString1, createJsonElement(paramString2));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperty(String paramString, Number paramNumber) {
/*  94 */     add(paramString, createJsonElement(paramNumber));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperty(String paramString, Boolean paramBoolean) {
/* 105 */     add(paramString, createJsonElement(paramBoolean));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addProperty(String paramString, Character paramCharacter) {
/* 116 */     add(paramString, createJsonElement(paramCharacter));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private JsonElement createJsonElement(Object paramObject) {
/* 126 */     return (paramObject == null) ? JsonNull.INSTANCE : new JsonPrimitive(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<Map.Entry<String, JsonElement>> entrySet() {
/* 136 */     return this.members.entrySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<String> keySet() {
/* 146 */     return this.members.keySet();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/* 155 */     return this.members.size();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean has(String paramString) {
/* 165 */     return this.members.containsKey(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonElement get(String paramString) {
/* 175 */     return (JsonElement)this.members.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonPrimitive getAsJsonPrimitive(String paramString) {
/* 185 */     return (JsonPrimitive)this.members.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonArray getAsJsonArray(String paramString) {
/* 195 */     return (JsonArray)this.members.get(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonObject getAsJsonObject(String paramString) {
/* 205 */     return (JsonObject)this.members.get(paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 210 */     return (paramObject == this || (paramObject instanceof JsonObject && ((JsonObject)paramObject).members
/* 211 */       .equals(this.members)));
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 216 */     return this.members.hashCode();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\JsonObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */