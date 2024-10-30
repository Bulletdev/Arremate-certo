/*     */ package com.google.gson.internal;
/*     */ 
/*     */ import com.google.gson.JsonElement;
/*     */ import com.google.gson.JsonIOException;
/*     */ import com.google.gson.JsonNull;
/*     */ import com.google.gson.JsonParseException;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import com.google.gson.internal.bind.TypeAdapters;
/*     */ import com.google.gson.stream.JsonReader;
/*     */ import com.google.gson.stream.JsonWriter;
/*     */ import com.google.gson.stream.MalformedJsonException;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
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
/*     */ public final class Streams
/*     */ {
/*     */   private Streams() {
/*  37 */     throw new UnsupportedOperationException();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static JsonElement parse(JsonReader paramJsonReader) throws JsonParseException {
/*  44 */     boolean bool = true;
/*     */     try {
/*  46 */       paramJsonReader.peek();
/*  47 */       bool = false;
/*  48 */       return (JsonElement)TypeAdapters.JSON_ELEMENT.read(paramJsonReader);
/*  49 */     } catch (EOFException eOFException) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  54 */       if (bool) {
/*  55 */         return (JsonElement)JsonNull.INSTANCE;
/*     */       }
/*     */       
/*  58 */       throw new JsonSyntaxException(eOFException);
/*  59 */     } catch (MalformedJsonException malformedJsonException) {
/*  60 */       throw new JsonSyntaxException(malformedJsonException);
/*  61 */     } catch (IOException iOException) {
/*  62 */       throw new JsonIOException(iOException);
/*  63 */     } catch (NumberFormatException numberFormatException) {
/*  64 */       throw new JsonSyntaxException(numberFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void write(JsonElement paramJsonElement, JsonWriter paramJsonWriter) throws IOException {
/*  72 */     TypeAdapters.JSON_ELEMENT.write(paramJsonWriter, paramJsonElement);
/*     */   }
/*     */   
/*     */   public static Writer writerForAppendable(Appendable paramAppendable) {
/*  76 */     return (paramAppendable instanceof Writer) ? (Writer)paramAppendable : new AppendableWriter(paramAppendable);
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class AppendableWriter
/*     */     extends Writer
/*     */   {
/*     */     private final Appendable appendable;
/*     */     
/*  85 */     private final CurrentWrite currentWrite = new CurrentWrite();
/*     */     
/*     */     AppendableWriter(Appendable param1Appendable) {
/*  88 */       this.appendable = param1Appendable;
/*     */     }
/*     */     
/*     */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) throws IOException {
/*  92 */       this.currentWrite.chars = param1ArrayOfchar;
/*  93 */       this.appendable.append(this.currentWrite, param1Int1, param1Int1 + param1Int2);
/*     */     }
/*     */     
/*     */     public void write(int param1Int) throws IOException {
/*  97 */       this.appendable.append((char)param1Int);
/*     */     }
/*     */     
/*     */     public void flush() {}
/*     */     
/*     */     public void close() {}
/*     */     
/*     */     static class CurrentWrite
/*     */       implements CharSequence {
/*     */       char[] chars;
/*     */       
/*     */       public int length() {
/* 109 */         return this.chars.length;
/*     */       }
/*     */       public char charAt(int param2Int) {
/* 112 */         return this.chars[param2Int];
/*     */       }
/*     */       public CharSequence subSequence(int param2Int1, int param2Int2) {
/* 115 */         return new String(this.chars, param2Int1, param2Int2 - param2Int1);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\Streams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */