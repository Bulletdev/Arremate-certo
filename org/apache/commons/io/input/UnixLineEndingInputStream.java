/*     */ package org.apache.commons.io.input;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UnixLineEndingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private boolean slashNSeen = false;
/*     */   private boolean slashRSeen = false;
/*     */   private boolean eofSeen = false;
/*     */   private final InputStream target;
/*     */   private final boolean ensureLineFeedAtEndOfFile;
/*     */   
/*     */   public UnixLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean) {
/*  47 */     this.target = paramInputStream;
/*  48 */     this.ensureLineFeedAtEndOfFile = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readWithUpdate() throws IOException {
/*  57 */     int i = this.target.read();
/*  58 */     this.eofSeen = (i == -1);
/*  59 */     if (this.eofSeen) {
/*  60 */       return i;
/*     */     }
/*  62 */     this.slashNSeen = (i == 10);
/*  63 */     this.slashRSeen = (i == 13);
/*  64 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  72 */     boolean bool = this.slashRSeen;
/*  73 */     if (this.eofSeen) {
/*  74 */       return eofGame(bool);
/*     */     }
/*  76 */     int i = readWithUpdate();
/*  77 */     if (this.eofSeen) {
/*  78 */       return eofGame(bool);
/*     */     }
/*  80 */     if (this.slashRSeen)
/*     */     {
/*  82 */       return 10;
/*     */     }
/*     */     
/*  85 */     if (bool && this.slashNSeen) {
/*  86 */       return read();
/*     */     }
/*     */     
/*  89 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int eofGame(boolean paramBoolean) {
/*  98 */     if (paramBoolean || !this.ensureLineFeedAtEndOfFile) {
/*  99 */       return -1;
/*     */     }
/* 101 */     if (!this.slashNSeen) {
/* 102 */       this.slashNSeen = true;
/* 103 */       return 10;
/*     */     } 
/* 105 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 114 */     super.close();
/* 115 */     this.target.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 123 */     throw new UnsupportedOperationException("Mark notsupported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\UnixLineEndingInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */