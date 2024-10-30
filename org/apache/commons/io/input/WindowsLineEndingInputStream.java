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
/*     */ public class WindowsLineEndingInputStream
/*     */   extends InputStream
/*     */ {
/*     */   private boolean slashRSeen = false;
/*     */   private boolean slashNSeen = false;
/*     */   private boolean injectSlashN = false;
/*     */   private boolean eofSeen = false;
/*     */   private final InputStream target;
/*     */   private final boolean ensureLineFeedAtEndOfFile;
/*     */   
/*     */   public WindowsLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean) {
/*  48 */     this.target = paramInputStream;
/*  49 */     this.ensureLineFeedAtEndOfFile = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int readWithUpdate() throws IOException {
/*  58 */     int i = this.target.read();
/*  59 */     this.eofSeen = (i == -1);
/*  60 */     if (this.eofSeen) {
/*  61 */       return i;
/*     */     }
/*  63 */     this.slashRSeen = (i == 13);
/*  64 */     this.slashNSeen = (i == 10);
/*  65 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/*  73 */     if (this.eofSeen)
/*  74 */       return eofGame(); 
/*  75 */     if (this.injectSlashN) {
/*  76 */       this.injectSlashN = false;
/*  77 */       return 10;
/*     */     } 
/*  79 */     boolean bool = this.slashRSeen;
/*  80 */     int i = readWithUpdate();
/*  81 */     if (this.eofSeen) {
/*  82 */       return eofGame();
/*     */     }
/*  84 */     if (i == 10 && 
/*  85 */       !bool) {
/*     */       
/*  87 */       this.injectSlashN = true;
/*  88 */       return 13;
/*     */     } 
/*     */     
/*  91 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int eofGame() {
/* 101 */     if (!this.ensureLineFeedAtEndOfFile) {
/* 102 */       return -1;
/*     */     }
/* 104 */     if (!this.slashNSeen && !this.slashRSeen) {
/* 105 */       this.slashRSeen = true;
/* 106 */       return 13;
/*     */     } 
/* 108 */     if (!this.slashNSeen) {
/* 109 */       this.slashRSeen = false;
/* 110 */       this.slashNSeen = true;
/* 111 */       return 10;
/*     */     } 
/* 113 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 122 */     super.close();
/* 123 */     this.target.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public synchronized void mark(int paramInt) {
/* 131 */     throw new UnsupportedOperationException("Mark not supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\commons\io\input\WindowsLineEndingInputStream.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */