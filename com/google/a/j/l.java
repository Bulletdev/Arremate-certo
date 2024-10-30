/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import java.io.EOFException;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.nio.CharBuffer;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @c
/*     */ public final class l
/*     */ {
/*     */   private static final int fS = 2048;
/*     */   
/*     */   static CharBuffer a() {
/*  55 */     return CharBuffer.allocate(2048);
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
/*     */   @com.google.b.a.a
/*     */   public static long a(Readable paramReadable, Appendable paramAppendable) throws IOException {
/*  73 */     if (paramReadable instanceof Reader) {
/*     */       
/*  75 */       if (paramAppendable instanceof StringBuilder) {
/*  76 */         return a((Reader)paramReadable, (StringBuilder)paramAppendable);
/*     */       }
/*  78 */       return a((Reader)paramReadable, a(paramAppendable));
/*     */     } 
/*     */     
/*  81 */     D.checkNotNull(paramReadable);
/*  82 */     D.checkNotNull(paramAppendable);
/*  83 */     long l1 = 0L;
/*  84 */     CharBuffer charBuffer = a();
/*  85 */     while (paramReadable.read(charBuffer) != -1) {
/*  86 */       v.b(charBuffer);
/*  87 */       paramAppendable.append(charBuffer);
/*  88 */       l1 += charBuffer.remaining();
/*  89 */       v.a(charBuffer);
/*     */     } 
/*  91 */     return l1;
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
/*     */   @com.google.b.a.a
/*     */   static long a(Reader paramReader, StringBuilder paramStringBuilder) throws IOException {
/* 115 */     D.checkNotNull(paramReader);
/* 116 */     D.checkNotNull(paramStringBuilder);
/* 117 */     char[] arrayOfChar = new char[2048];
/*     */     
/* 119 */     long l1 = 0L; int i;
/* 120 */     while ((i = paramReader.read(arrayOfChar)) != -1) {
/* 121 */       paramStringBuilder.append(arrayOfChar, 0, i);
/* 122 */       l1 += i;
/*     */     } 
/* 124 */     return l1;
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
/*     */   @com.google.b.a.a
/*     */   static long a(Reader paramReader, Writer paramWriter) throws IOException {
/* 143 */     D.checkNotNull(paramReader);
/* 144 */     D.checkNotNull(paramWriter);
/* 145 */     char[] arrayOfChar = new char[2048];
/*     */     
/* 147 */     long l1 = 0L; int i;
/* 148 */     while ((i = paramReader.read(arrayOfChar)) != -1) {
/* 149 */       paramWriter.write(arrayOfChar, 0, i);
/* 150 */       l1 += i;
/*     */     } 
/* 152 */     return l1;
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
/*     */   public static String a(Readable paramReadable) throws IOException {
/* 164 */     return a(paramReadable).toString();
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
/*     */   private static StringBuilder a(Readable paramReadable) throws IOException {
/* 176 */     StringBuilder stringBuilder = new StringBuilder();
/* 177 */     if (paramReadable instanceof Reader) {
/* 178 */       a((Reader)paramReadable, stringBuilder);
/*     */     } else {
/* 180 */       a(paramReadable, stringBuilder);
/*     */     } 
/* 182 */     return stringBuilder;
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
/*     */   @com.google.a.a.a
/*     */   public static List<String> a(Readable paramReadable) throws IOException {
/* 198 */     ArrayList<String> arrayList = new ArrayList();
/* 199 */     y y = new y(paramReadable);
/*     */     String str;
/* 201 */     while ((str = y.readLine()) != null) {
/* 202 */       arrayList.add(str);
/*     */     }
/* 204 */     return arrayList;
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
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static <T> T a(Readable paramReadable, x<T> paramx) throws IOException {
/* 219 */     D.checkNotNull(paramReadable);
/* 220 */     D.checkNotNull(paramx);
/*     */     
/* 222 */     y y = new y(paramReadable); String str; do {
/*     */     
/* 224 */     } while ((str = y.readLine()) != null && 
/* 225 */       paramx.t(str));
/*     */ 
/*     */ 
/*     */     
/* 229 */     return paramx.getResult();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   @com.google.b.a.a
/*     */   public static long b(Readable paramReadable) throws IOException {
/* 241 */     long l1 = 0L;
/*     */     
/* 243 */     CharBuffer charBuffer = a(); long l2;
/* 244 */     while ((l2 = paramReadable.read(charBuffer)) != -1L) {
/* 245 */       l1 += l2;
/* 246 */       v.a(charBuffer);
/*     */     } 
/* 248 */     return l1;
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
/*     */   @com.google.a.a.a
/*     */   public static void skipFully(Reader paramReader, long paramLong) throws IOException {
/* 262 */     D.checkNotNull(paramReader);
/* 263 */     while (paramLong > 0L) {
/* 264 */       long l1 = paramReader.skip(paramLong);
/* 265 */       if (l1 == 0L) {
/* 266 */         throw new EOFException();
/*     */       }
/* 268 */       paramLong -= l1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.a.a.a
/*     */   public static Writer c() {
/* 279 */     return a.a();
/*     */   }
/*     */   
/*     */   private static final class a
/*     */     extends Writer {
/* 284 */     private static final a a = new a();
/*     */ 
/*     */     
/*     */     public void write(int param1Int) {}
/*     */ 
/*     */     
/*     */     public void write(char[] param1ArrayOfchar) {
/* 291 */       D.checkNotNull(param1ArrayOfchar);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(char[] param1ArrayOfchar, int param1Int1, int param1Int2) {
/* 296 */       D.a(param1Int1, param1Int1 + param1Int2, param1ArrayOfchar.length);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(String param1String) {
/* 301 */       D.checkNotNull(param1String);
/*     */     }
/*     */ 
/*     */     
/*     */     public void write(String param1String, int param1Int1, int param1Int2) {
/* 306 */       D.a(param1Int1, param1Int1 + param1Int2, param1String.length());
/*     */     }
/*     */ 
/*     */     
/*     */     public Writer append(CharSequence param1CharSequence) {
/* 311 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Writer append(CharSequence param1CharSequence, int param1Int1, int param1Int2) {
/* 316 */       D.a(param1Int1, param1Int2, (param1CharSequence == null) ? "null".length() : param1CharSequence.length());
/* 317 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public Writer append(char param1Char) {
/* 322 */       return this;
/*     */     }
/*     */ 
/*     */     
/*     */     public void flush() {}
/*     */ 
/*     */     
/*     */     public void close() {}
/*     */ 
/*     */     
/*     */     public String toString() {
/* 333 */       return "CharStreams.nullWriter()";
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
/*     */   @com.google.a.a.a
/*     */   public static Writer a(Appendable paramAppendable) {
/* 347 */     if (paramAppendable instanceof Writer) {
/* 348 */       return (Writer)paramAppendable;
/*     */     }
/* 350 */     return new a(paramAppendable);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\l.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */