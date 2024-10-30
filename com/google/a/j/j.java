/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.b.D;
/*     */ import com.google.b.a.a;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.util.Iterator;
/*     */ import java.util.stream.Stream;
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
/*     */ public abstract class j
/*     */ {
/*     */   public abstract Writer a() throws IOException;
/*     */   
/*     */   public Writer b() throws IOException {
/*  81 */     Writer writer = a();
/*  82 */     return (writer instanceof BufferedWriter) ? 
/*  83 */       writer : 
/*  84 */       new BufferedWriter(writer);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(CharSequence paramCharSequence) throws IOException {
/*  93 */     D.checkNotNull(paramCharSequence);
/*     */     
/*  95 */     n n = n.a();
/*     */     try {
/*  97 */       Writer writer = n.<Writer>a(a());
/*  98 */       writer.append(paramCharSequence);
/*  99 */       writer.flush();
/* 100 */     } catch (Throwable throwable) {
/* 101 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 103 */       n.close();
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
/*     */   public void e(Iterable<? extends CharSequence> paramIterable) throws IOException {
/* 115 */     a(paramIterable, System.getProperty("line.separator"));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(Iterable<? extends CharSequence> paramIterable, String paramString) throws IOException {
/* 126 */     a(paramIterable.iterator(), paramString);
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
/*     */   @a
/*     */   public void a(Stream<? extends CharSequence> paramStream) throws IOException {
/* 139 */     a(paramStream, System.getProperty("line.separator"));
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
/*     */   @a
/*     */   public void a(Stream<? extends CharSequence> paramStream, String paramString) throws IOException {
/* 152 */     a(paramStream.iterator(), paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   private void a(Iterator<? extends CharSequence> paramIterator, String paramString) throws IOException {
/* 157 */     D.checkNotNull(paramString);
/*     */     
/* 159 */     Writer writer = b(); try {
/* 160 */       while (paramIterator.hasNext()) {
/* 161 */         writer.append(paramIterator.next()).append(paramString);
/*     */       }
/* 163 */       if (writer != null) writer.close(); 
/*     */     } catch (Throwable throwable) {
/*     */       if (writer != null)
/*     */         try {
/*     */           writer.close();
/*     */         } catch (Throwable throwable1) {
/*     */           throwable.addSuppressed(throwable1);
/*     */         }  
/*     */       throw throwable;
/*     */     } 
/*     */   }
/*     */   @a
/*     */   public long a(Readable paramReadable) throws IOException {
/* 176 */     D.checkNotNull(paramReadable);
/*     */     
/* 178 */     n n = n.a();
/*     */     try {
/* 180 */       Writer writer = n.<Writer>a(a());
/* 181 */       long l = l.a(paramReadable, writer);
/* 182 */       writer.flush();
/* 183 */       return l;
/* 184 */     } catch (Throwable throwable) {
/* 185 */       throw n.rethrow(throwable);
/*     */     } finally {
/* 187 */       n.close();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\j.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */