/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.Writer;
/*     */ import java.nio.CharBuffer;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TeeReader
/*     */   extends ProxyReader
/*     */ {
/*     */   private final Writer branch;
/*     */   private final boolean closeBranch;
/*     */   
/*     */   public TeeReader(Reader paramReader, Writer paramWriter) {
/*  57 */     this(paramReader, paramWriter, false);
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
/*     */   public TeeReader(Reader paramReader, Writer paramWriter, boolean paramBoolean) {
/*  70 */     super(paramReader);
/*  71 */     this.branch = paramWriter;
/*  72 */     this.closeBranch = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*     */     try {
/*  84 */       super.close();
/*     */     } finally {
/*  86 */       if (this.closeBranch) {
/*  87 */         this.branch.close();
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
/*     */   public int read() throws IOException {
/* 100 */     int i = super.read();
/* 101 */     if (i != -1) {
/* 102 */       this.branch.write(i);
/*     */     }
/* 104 */     return i;
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
/*     */   public int read(char[] paramArrayOfchar) throws IOException {
/* 116 */     int i = super.read(paramArrayOfchar);
/* 117 */     if (i != -1) {
/* 118 */       this.branch.write(paramArrayOfchar, 0, i);
/*     */     }
/* 120 */     return i;
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
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 134 */     int i = super.read(paramArrayOfchar, paramInt1, paramInt2);
/* 135 */     if (i != -1) {
/* 136 */       this.branch.write(paramArrayOfchar, paramInt1, i);
/*     */     }
/* 138 */     return i;
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
/*     */   public int read(CharBuffer paramCharBuffer) throws IOException {
/* 150 */     int i = paramCharBuffer.position();
/* 151 */     int j = super.read(paramCharBuffer);
/* 152 */     if (j != -1) {
/*     */ 
/*     */       
/* 155 */       int k = paramCharBuffer.position();
/* 156 */       int m = paramCharBuffer.limit();
/*     */       try {
/* 158 */         paramCharBuffer.position(i).limit(k);
/* 159 */         this.branch.append(paramCharBuffer);
/*     */       } finally {
/*     */         
/* 162 */         paramCharBuffer.position(k).limit(m);
/*     */       } 
/*     */     } 
/* 165 */     return j;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\TeeReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */