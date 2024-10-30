/*     */ package org.passay;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.CharBuffer;
/*     */ import java.security.SecureRandom;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Random;
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
/*     */ public class y
/*     */ {
/*     */   private final Random random;
/*     */   
/*     */   public y() {
/*  27 */     this(new SecureRandom());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public y(Random paramRandom) {
/*  38 */     this.random = paramRandom;
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
/*     */   public String a(int paramInt, g... paramVarArgs) {
/*  52 */     return a(paramInt, Arrays.asList(paramVarArgs));
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
/*     */   public String a(int paramInt, List<g> paramList) {
/*  67 */     if (paramInt <= 0) {
/*  68 */       throw new IllegalArgumentException("length must be greater than 0");
/*     */     }
/*     */     
/*  71 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  73 */     CharBuffer charBuffer = CharBuffer.allocate(paramInt);
/*  74 */     if (paramList != null) {
/*  75 */       for (g g : paramList) {
/*  76 */         a(g.ff(), g.ca(), charBuffer);
/*  77 */         stringBuilder.append(g.ff());
/*     */       } 
/*     */     }
/*  80 */     a(stringBuilder, paramInt - charBuffer.position(), charBuffer);
/*  81 */     charBuffer.flip();
/*  82 */     a(charBuffer);
/*  83 */     return charBuffer.toString();
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
/*     */   protected void a(CharSequence paramCharSequence, int paramInt, Appendable paramAppendable) {
/*  96 */     for (byte b = 0; b < paramInt; b++) {
/*     */       try {
/*  98 */         paramAppendable.append(paramCharSequence.charAt(this.random.nextInt(paramCharSequence.length())));
/*  99 */       } catch (IOException iOException) {
/* 100 */         throw new RuntimeException("Error appending characters.", iOException);
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
/*     */   protected void a(CharBuffer paramCharBuffer) {
/* 115 */     for (int i = paramCharBuffer.position(); i < paramCharBuffer.limit(); i++) {
/* 116 */       int j = this.random.nextInt(paramCharBuffer.length());
/* 117 */       char c = paramCharBuffer.get(j);
/* 118 */       paramCharBuffer.put(j, paramCharBuffer.get(i));
/* 119 */       paramCharBuffer.put(i, c);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\passay\y.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */