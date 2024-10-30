/*     */ package com.google.gson;
/*     */ 
/*     */ import com.google.gson.internal.Streams;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonToken;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
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
/*     */ public final class JsonStreamParser
/*     */   implements Iterator<JsonElement>
/*     */ {
/*     */   private final JsonReader parser;
/*     */   private final Object lock;
/*     */   
/*     */   public JsonStreamParser(String paramString) {
/*  61 */     this(new StringReader(paramString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonStreamParser(Reader paramReader) {
/*  69 */     this.parser = new JsonReader(paramReader);
/*  70 */     this.parser.setLenient(true);
/*  71 */     this.lock = new Object();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public JsonElement next() throws JsonParseException {
/*  82 */     if (!hasNext()) {
/*  83 */       throw new NoSuchElementException();
/*     */     }
/*     */     
/*     */     try {
/*  87 */       return Streams.parse(this.parser);
/*  88 */     } catch (StackOverflowError stackOverflowError) {
/*  89 */       throw new JsonParseException("Failed parsing JSON source to Json", stackOverflowError);
/*  90 */     } catch (OutOfMemoryError outOfMemoryError) {
/*  91 */       throw new JsonParseException("Failed parsing JSON source to Json", outOfMemoryError);
/*  92 */     } catch (JsonParseException jsonParseException) {
/*  93 */       throw (jsonParseException.getCause() instanceof java.io.EOFException) ? new NoSuchElementException() : jsonParseException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean hasNext() {
/* 103 */     synchronized (this.lock) {
/*     */       
/* 105 */       return (this.parser.peek() != JsonToken.END_DOCUMENT);
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
/*     */ 
/*     */   
/*     */   public void remove() {
/* 120 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\JsonStreamParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */