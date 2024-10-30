/*    */ package com.google.gson.internal.bind;
/*    */ 
/*    */ import com.google.gson.Gson;
/*    */ import com.google.gson.JsonSyntaxException;
/*    */ import com.google.gson.TypeAdapter;
/*    */ import com.google.gson.TypeAdapterFactory;
/*    */ import com.google.gson.reflect.TypeToken;
/*    */ import com.google.gson.stream.JsonReader;
/*    */ import com.google.gson.stream.JsonToken;
/*    */ import com.google.gson.stream.JsonWriter;
/*    */ import java.io.IOException;
/*    */ import java.sql.Date;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
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
/*    */ public final class SqlDateTypeAdapter
/*    */   extends TypeAdapter<Date>
/*    */ {
/* 39 */   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
/*    */     {
/*    */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 42 */         return (param1TypeToken.getRawType() == Date.class) ? new SqlDateTypeAdapter() : null;
/*    */       }
/*    */     };
/*    */ 
/*    */   
/* 47 */   private final DateFormat format = new SimpleDateFormat("MMM d, yyyy");
/*    */ 
/*    */   
/*    */   public synchronized Date read(JsonReader paramJsonReader) throws IOException {
/* 51 */     if (paramJsonReader.peek() == JsonToken.NULL) {
/* 52 */       paramJsonReader.nextNull();
/* 53 */       return null;
/*    */     } 
/*    */     try {
/* 56 */       long l = this.format.parse(paramJsonReader.nextString()).getTime();
/* 57 */       return new Date(l);
/* 58 */     } catch (ParseException parseException) {
/* 59 */       throw new JsonSyntaxException(parseException);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public synchronized void write(JsonWriter paramJsonWriter, Date paramDate) throws IOException {
/* 65 */     paramJsonWriter.value((paramDate == null) ? null : this.format.format(paramDate));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\SqlDateTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */