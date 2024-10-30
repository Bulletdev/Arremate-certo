/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Arrays;
/*     */ import java.util.Iterator;
/*     */ import java.util.Objects;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SequenceReader
/*     */   extends Reader
/*     */ {
/*     */   private Reader reader;
/*     */   private Iterator<? extends Reader> readers;
/*     */   
/*     */   public SequenceReader(Iterable<? extends Reader> paramIterable) {
/*  43 */     this.readers = ((Iterable<? extends Reader>)Objects.<Iterable<? extends Reader>>requireNonNull(paramIterable, "readers")).iterator();
/*  44 */     this.reader = nextReader();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SequenceReader(Reader... paramVarArgs) {
/*  53 */     this(Arrays.asList(paramVarArgs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  63 */     this.readers = null;
/*  64 */     this.reader = null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Reader nextReader() {
/*  73 */     return this.readers.hasNext() ? this.readers.next() : null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  83 */     int i = -1;
/*  84 */     while (this.reader != null) {
/*  85 */       i = this.reader.read();
/*  86 */       if (i == -1) {
/*  87 */         this.reader = nextReader();
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/*  92 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read(char[] paramArrayOfchar, int paramInt1, int paramInt2) throws IOException {
/* 102 */     Objects.requireNonNull(paramArrayOfchar, "cbuf");
/* 103 */     if (paramInt2 < 0 || paramInt1 < 0 || paramInt1 + paramInt2 > paramArrayOfchar.length) {
/* 104 */       throw new IndexOutOfBoundsException("Array Size=" + paramArrayOfchar.length + ", offset=" + paramInt1 + ", length=" + paramInt2);
/*     */     }
/* 106 */     int i = 0;
/* 107 */     while (this.reader != null) {
/* 108 */       int j = this.reader.read(paramArrayOfchar, paramInt1, paramInt2);
/* 109 */       if (j == -1) {
/* 110 */         this.reader = nextReader(); continue;
/*     */       } 
/* 112 */       i += j;
/* 113 */       paramInt1 += j;
/* 114 */       paramInt2 -= j;
/* 115 */       if (paramInt2 <= 0) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 120 */     if (i > 0) {
/* 121 */       return i;
/*     */     }
/* 123 */     return -1;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\SequenceReader.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */