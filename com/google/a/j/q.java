/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
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
/*     */ @a
/*     */ @c
/*     */ public final class q
/*     */   extends OutputStream
/*     */ {
/*     */   private final int fT;
/*     */   private final boolean ba;
/*     */   private final g b;
/*     */   private final File c;
/*     */   @com.google.b.a.a.a("this")
/*     */   private OutputStream out;
/*     */   @com.google.b.a.a.a("this")
/*     */   private a a;
/*     */   @com.google.b.a.a.a("this")
/*     */   private File file;
/*     */   
/*     */   private static class a
/*     */     extends ByteArrayOutputStream
/*     */   {
/*     */     private a() {}
/*     */     
/*     */     byte[] j() {
/*  71 */       return this.buf;
/*     */     }
/*     */     
/*     */     int getCount() {
/*  75 */       return this.count;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @d
/*     */   synchronized File getFile() {
/*  82 */     return this.file;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public q(int paramInt) {
/*  92 */     this(paramInt, false);
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
/*     */   public q(int paramInt, boolean paramBoolean) {
/* 104 */     this(paramInt, paramBoolean, null);
/*     */   }
/*     */ 
/*     */   
/*     */   private q(int paramInt, boolean paramBoolean, File paramFile) {
/* 109 */     this.fT = paramInt;
/* 110 */     this.ba = paramBoolean;
/* 111 */     this.c = paramFile;
/* 112 */     this.a = new a();
/* 113 */     this.out = this.a;
/*     */     
/* 115 */     if (paramBoolean) {
/* 116 */       this.b = new g(this)
/*     */         {
/*     */           public InputStream a() throws IOException
/*     */           {
/* 120 */             return q.a(this.a);
/*     */           }
/*     */ 
/*     */           
/*     */           protected void finalize() {
/*     */             try {
/* 126 */               this.a.reset();
/* 127 */             } catch (Throwable throwable) {
/* 128 */               throwable.printStackTrace(System.err);
/*     */             } 
/*     */           }
/*     */         };
/*     */     } else {
/* 133 */       this.b = new g(this)
/*     */         {
/*     */           public InputStream a() throws IOException
/*     */           {
/* 137 */             return q.a(this.a);
/*     */           }
/*     */         };
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public g b() {
/* 149 */     return this.b;
/*     */   }
/*     */   
/*     */   private synchronized InputStream c() throws IOException {
/* 153 */     if (this.file != null) {
/* 154 */       return new FileInputStream(this.file);
/*     */     }
/* 156 */     return new ByteArrayInputStream(this.a.j(), 0, this.a.getCount());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void reset() throws IOException {
/*     */     try {
/* 168 */       close();
/*     */     } finally {
/* 170 */       if (this.a == null) {
/* 171 */         this.a = new a();
/*     */       } else {
/* 173 */         this.a.reset();
/*     */       } 
/* 175 */       this.out = this.a;
/* 176 */       if (this.file != null) {
/* 177 */         File file = this.file;
/* 178 */         this.file = null;
/* 179 */         if (!file.delete()) {
/* 180 */           String str = String.valueOf(file); throw new IOException((new StringBuilder(18 + String.valueOf(str).length())).append("Could not delete: ").append(str).toString());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void write(int paramInt) throws IOException {
/* 188 */     update(1);
/* 189 */     this.out.write(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void write(byte[] paramArrayOfbyte) throws IOException {
/* 194 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 199 */     update(paramInt2);
/* 200 */     this.out.write(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void close() throws IOException {
/* 205 */     this.out.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public synchronized void flush() throws IOException {
/* 210 */     this.out.flush();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @com.google.b.a.a.a("this")
/*     */   private void update(int paramInt) throws IOException {
/* 219 */     if (this.file == null && this.a.getCount() + paramInt > this.fT) {
/* 220 */       File file = File.createTempFile("FileBackedOutputStream", null, this.c);
/* 221 */       if (this.ba)
/*     */       {
/*     */         
/* 224 */         file.deleteOnExit();
/*     */       }
/* 226 */       FileOutputStream fileOutputStream = new FileOutputStream(file);
/* 227 */       fileOutputStream.write(this.a.j(), 0, this.a.getCount());
/* 228 */       fileOutputStream.flush();
/*     */ 
/*     */       
/* 231 */       this.out = fileOutputStream;
/* 232 */       this.file = file;
/* 233 */       this.a = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\q.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */