/*    */ package com.google.gson;
/*    */ 
/*    */ import com.google.gson.internal.Streams;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonToken;
/*    */ import com.google.gson.stream.MalformedJsonException;
/*    */ import java.io.IOException;
/*    */ import java.io.Reader;
/*    */ import java.io.StringReader;
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
/*    */ public final class JsonParser
/*    */ {
/*    */   public JsonElement parse(String paramString) throws JsonSyntaxException {
/* 45 */     return parse(new StringReader(paramString));
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
/*    */   public JsonElement parse(Reader paramReader) throws JsonIOException, JsonSyntaxException {
/*    */     try {
/* 58 */       JsonReader jsonReader = new JsonReader(paramReader);
/* 59 */       JsonElement jsonElement = parse(jsonReader);
/* 60 */       if (!jsonElement.isJsonNull() && jsonReader.peek() != JsonToken.END_DOCUMENT) {
/* 61 */         throw new JsonSyntaxException("Did not consume the entire document.");
/*    */       }
/* 63 */       return jsonElement;
/* 64 */     } catch (MalformedJsonException malformedJsonException) {
/* 65 */       throw new JsonSyntaxException(malformedJsonException);
/* 66 */     } catch (IOException iOException) {
/* 67 */       throw new JsonIOException(iOException);
/* 68 */     } catch (NumberFormatException numberFormatException) {
/* 69 */       throw new JsonSyntaxException(numberFormatException);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public JsonElement parse(JsonReader paramJsonReader) throws JsonIOException, JsonSyntaxException {
/* 81 */     boolean bool = paramJsonReader.isLenient();
/* 82 */     paramJsonReader.setLenient(true);
/*    */     try {
/* 84 */       return Streams.parse(paramJsonReader);
/* 85 */     } catch (StackOverflowError stackOverflowError) {
/* 86 */       throw new JsonParseException("Failed parsing JSON source: " + paramJsonReader + " to Json", stackOverflowError);
/* 87 */     } catch (OutOfMemoryError outOfMemoryError) {
/* 88 */       throw new JsonParseException("Failed parsing JSON source: " + paramJsonReader + " to Json", outOfMemoryError);
/*    */     } finally {
/* 90 */       paramJsonReader.setLenient(bool);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\JsonParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */