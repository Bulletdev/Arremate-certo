/*     */ package org.apache.commons.net.io;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
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
/*     */ public final class DotTerminatedMessageReader
/*     */   extends BufferedReader
/*     */ {
/*     */   private static final char LF = '\n';
/*     */   private static final char CR = '\r';
/*     */   private static final int DOT = 46;
/*     */   private boolean atBeginning;
/*     */   private boolean eof;
/*     */   private boolean seenCR;
/*     */   
/*     */   public DotTerminatedMessageReader(Reader paramReader) {
/*  56 */     super(paramReader);
/*     */     
/*  58 */     this.atBeginning = true;
/*  59 */     this.eof = false;
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
/*     */   public int read() throws IOException {
/*  76 */     synchronized (this.lock) {
/*  77 */       if (this.eof) {
/*  78 */         return -1;
/*     */       }
/*  80 */       int i = super.read();
/*  81 */       if (i == -1) {
/*  82 */         this.eof = true;
/*  83 */         return -1;
/*     */       } 
/*  85 */       if (this.atBeginning) {
/*  86 */         this.atBeginning = false;
/*  87 */         if (i == 46) {
/*  88 */           mark(2);
/*  89 */           i = super.read();
/*  90 */           if (i == -1) {
/*     */             
/*  92 */             this.eof = true;
/*  93 */             return 46;
/*     */           } 
/*  95 */           if (i == 46)
/*     */           {
/*  97 */             return i;
/*     */           }
/*  99 */           if (i == 13) {
/* 100 */             i = super.read();
/* 101 */             if (i == -1) {
/*     */               
/* 103 */               reset();
/* 104 */               return 46;
/*     */             } 
/* 106 */             if (i == 10) {
/* 107 */               this.atBeginning = true;
/* 108 */               this.eof = true;
/*     */               
/* 110 */               return -1;
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 115 */           reset();
/* 116 */           return 46;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 121 */       if (this.seenCR) {
/* 122 */         this.seenCR = false;
/* 123 */         if (i == 10) {
/* 124 */           this.atBeginning = true;
/*     */         }
/*     */       } 
/* 127 */       if (i == 13) {
/* 128 */         this.seenCR = true;
/*     */       }
/* 130 */       return i;
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
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/* 148 */     return read(paramArrayOfchar, 0, paramArrayOfchar.length);
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 168 */     if (paramInt2 < 1)
/*     */     {
/* 170 */       return 0;
/*     */     }
/*     */     
/* 173 */     synchronized (this.lock) {
/*     */       int i;
/* 175 */       if ((i = read()) == -1)
/*     */       {
/* 177 */         return -1;
/*     */       }
/*     */       
/* 180 */       int j = paramInt1;
/*     */ 
/*     */       
/*     */       do {
/* 184 */         paramArrayOfchar[paramInt1++] = (char)i;
/*     */       }
/* 186 */       while (--paramInt2 > 0 && (i = read()) != -1);
/*     */       
/* 188 */       return paramInt1 - j;
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
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 209 */     synchronized (this.lock) {
/*     */       
/* 211 */       if (!this.eof)
/*     */       {
/* 213 */         while (read() != -1);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 218 */       this.eof = true;
/* 219 */       this.atBeginning = false;
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
/*     */   public String readLine() throws IOException {
/* 231 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 233 */     synchronized (this.lock) {
/* 234 */       int i; while ((i = read()) != -1) {
/*     */         
/* 236 */         if (i == 10 && this.atBeginning) {
/* 237 */           return stringBuilder.substring(0, stringBuilder.length() - 1);
/*     */         }
/* 239 */         stringBuilder.append((char)i);
/*     */       } 
/*     */     } 
/* 242 */     String str = stringBuilder.toString();
/* 243 */     if (str.isEmpty()) {
/* 244 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 248 */     return str;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\net\io\DotTerminatedMessageReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */