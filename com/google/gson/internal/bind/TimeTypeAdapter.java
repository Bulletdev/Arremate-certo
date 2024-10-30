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
/*    */ import java.sql.Time;
/*    */ import java.text.DateFormat;
/*    */ import java.text.ParseException;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
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
/*    */ public final class TimeTypeAdapter
/*    */   extends TypeAdapter<Time>
/*    */ {
/* 41 */   public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory()
/*    */     {
/*    */       public <T> TypeAdapter<T> create(Gson param1Gson, TypeToken<T> param1TypeToken) {
/* 44 */         return (param1TypeToken.getRawType() == Time.class) ? new TimeTypeAdapter() : null;
/*    */       }
/*    */     };
/*    */   
/* 48 */   private final DateFormat format = new SimpleDateFormat("hh:mm:ss a");
/*    */   
/*    */   public synchronized Time read(JsonReader paramJsonReader) throws IOException {
/* 51 */     if (paramJsonReader.peek() == JsonToken.NULL) {
/* 52 */       paramJsonReader.nextNull();
/* 53 */       return null;
/*    */     } 
/*    */     try {
/* 56 */       Date date = this.format.parse(paramJsonReader.nextString());
/* 57 */       return new Time(date.getTime());
/* 58 */     } catch (ParseException parseException) {
/* 59 */       throw new JsonSyntaxException(parseException);
/*    */     } 
/*    */   }
/*    */   
/*    */   public synchronized void write(JsonWriter paramJsonWriter, Time paramTime) throws IOException {
/* 64 */     paramJsonWriter.value((paramTime == null) ? null : this.format.format(paramTime));
/*    */   }
/*    */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\gson\internal\bind\TimeTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */