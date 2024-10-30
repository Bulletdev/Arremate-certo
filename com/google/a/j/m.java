/*     */ package com.google.a.j;
/*     */ 
/*     */ import com.google.a.a.a;
/*     */ import com.google.a.a.c;
/*     */ import com.google.a.a.d;
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
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
/*     */ public final class m
/*     */ {
/*     */   @d
/*  37 */   static final Logger logger = Logger.getLogger(m.class.getName());
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
/*     */   public static void a(Closeable paramCloseable, boolean paramBoolean) throws IOException {
/*  74 */     if (paramCloseable == null) {
/*     */       return;
/*     */     }
/*     */     try {
/*  78 */       paramCloseable.close();
/*  79 */     } catch (IOException iOException) {
/*  80 */       if (paramBoolean) {
/*  81 */         logger.log(Level.WARNING, "IOException thrown while closing Closeable.", iOException);
/*     */       } else {
/*  83 */         throw iOException;
/*     */       } 
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
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeQuietly(InputStream paramInputStream) {
/*     */     try {
/* 104 */       a(paramInputStream, true);
/* 105 */     } catch (IOException iOException) {
/* 106 */       throw new AssertionError(iOException);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void closeQuietly(Reader paramReader) {
/*     */     try {
/* 125 */       a(paramReader, true);
/* 126 */     } catch (IOException iOException) {
/* 127 */       throw new AssertionError(iOException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\com\google\a\j\m.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */