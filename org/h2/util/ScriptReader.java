/*     */ package org.h2.util;
/*     */ 
/*     */ import java.io.Closeable;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.Arrays;
/*     */ import org.h2.message.DbException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ScriptReader
/*     */   implements Closeable
/*     */ {
/*     */   private final Reader reader;
/*     */   private char[] buffer;
/*     */   private int bufferPos;
/*  33 */   private int bufferStart = -1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int bufferEnd;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean endOfFile;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean insideRemark;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean blockRemark;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean skipRemarks;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int remarkStart;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ScriptReader(Reader paramReader) {
/*  72 */     this.reader = paramReader;
/*  73 */     this.buffer = new char[8192];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() {
/*     */     try {
/*  82 */       this.reader.close();
/*  83 */     } catch (IOException iOException) {
/*  84 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String readStatement() {
/*  95 */     if (this.endOfFile) {
/*  96 */       return null;
/*     */     }
/*     */     try {
/*  99 */       return readStatementLoop();
/* 100 */     } catch (IOException iOException) {
/* 101 */       throw DbException.convertIOException(iOException, null);
/*     */     } 
/*     */   }
/*     */   
/*     */   private String readStatementLoop() throws IOException {
/* 106 */     this.bufferStart = this.bufferPos;
/* 107 */     int i = read();
/*     */     while (true) {
/* 109 */       if (i < 0) {
/* 110 */         this.endOfFile = true;
/* 111 */         if (this.bufferPos - 1 == this.bufferStart)
/* 112 */           return null; 
/*     */         break;
/*     */       } 
/* 115 */       if (i == 59) {
/*     */         break;
/*     */       }
/* 118 */       switch (i) {
/*     */         case 36:
/* 120 */           i = read();
/* 121 */           if (i == 36 && (this.bufferPos - this.bufferStart < 3 || this.buffer[this.bufferPos - 3] <= ' ')) {
/*     */             
/*     */             while (true) {
/* 124 */               i = read();
/* 125 */               if (i < 0) {
/*     */                 break;
/*     */               }
/* 128 */               if (i == 36) {
/* 129 */                 i = read();
/* 130 */                 if (i < 0) {
/*     */                   break;
/*     */                 }
/* 133 */                 if (i == 36) {
/*     */                   break;
/*     */                 }
/*     */               } 
/*     */             } 
/* 138 */             i = read();
/*     */           } 
/*     */           continue;
/*     */         
/*     */         case 39:
/*     */           do {
/* 144 */             i = read();
/* 145 */             if (i < 0) {
/*     */               break;
/*     */             }
/* 148 */           } while (i != 39);
/*     */ 
/*     */ 
/*     */           
/* 152 */           i = read();
/*     */           continue;
/*     */         case 34:
/*     */           do {
/* 156 */             i = read();
/* 157 */             if (i < 0) {
/*     */               break;
/*     */             }
/* 160 */           } while (i != 34);
/*     */ 
/*     */ 
/*     */           
/* 164 */           i = read();
/*     */           continue;
/*     */         case 47:
/* 167 */           i = read();
/* 168 */           if (i == 42) {
/*     */             
/* 170 */             startRemark(true);
/*     */             while (true) {
/* 172 */               i = read();
/* 173 */               if (i < 0) {
/*     */                 break;
/*     */               }
/* 176 */               if (i == 42) {
/* 177 */                 i = read();
/* 178 */                 if (i < 0) {
/* 179 */                   clearRemark();
/*     */                   break;
/*     */                 } 
/* 182 */                 if (i == 47) {
/* 183 */                   endRemark();
/*     */                   break;
/*     */                 } 
/*     */               } 
/*     */             } 
/* 188 */             i = read(); continue;
/* 189 */           }  if (i == 47) {
/*     */             
/* 191 */             startRemark(false);
/*     */             while (true) {
/* 193 */               i = read();
/* 194 */               if (i < 0) {
/* 195 */                 clearRemark();
/*     */                 break;
/*     */               } 
/* 198 */               if (i == 13 || i == 10) {
/* 199 */                 endRemark();
/*     */                 break;
/*     */               } 
/*     */             } 
/* 203 */             i = read();
/*     */           } 
/*     */           continue;
/*     */         
/*     */         case 45:
/* 208 */           i = read();
/* 209 */           if (i == 45) {
/*     */             
/* 211 */             startRemark(false);
/*     */             while (true) {
/* 213 */               i = read();
/* 214 */               if (i < 0) {
/* 215 */                 clearRemark();
/*     */                 break;
/*     */               } 
/* 218 */               if (i == 13 || i == 10) {
/* 219 */                 endRemark();
/*     */                 break;
/*     */               } 
/*     */             } 
/* 223 */             i = read();
/*     */           } 
/*     */           continue;
/*     */       } 
/*     */       
/* 228 */       i = read();
/*     */     } 
/*     */ 
/*     */     
/* 232 */     return new String(this.buffer, this.bufferStart, this.bufferPos - 1 - this.bufferStart);
/*     */   }
/*     */   
/*     */   private void startRemark(boolean paramBoolean) {
/* 236 */     this.blockRemark = paramBoolean;
/* 237 */     this.remarkStart = this.bufferPos - 2;
/* 238 */     this.insideRemark = true;
/*     */   }
/*     */   
/*     */   private void endRemark() {
/* 242 */     clearRemark();
/* 243 */     this.insideRemark = false;
/*     */   }
/*     */   
/*     */   private void clearRemark() {
/* 247 */     if (this.skipRemarks) {
/* 248 */       Arrays.fill(this.buffer, this.remarkStart, this.bufferPos, ' ');
/*     */     }
/*     */   }
/*     */   
/*     */   private int read() throws IOException {
/* 253 */     if (this.bufferPos >= this.bufferEnd) {
/* 254 */       return readBuffer();
/*     */     }
/* 256 */     return this.buffer[this.bufferPos++];
/*     */   }
/*     */   
/*     */   private int readBuffer() throws IOException {
/* 260 */     if (this.endOfFile) {
/* 261 */       return -1;
/*     */     }
/* 263 */     int i = this.bufferPos - this.bufferStart;
/* 264 */     if (i > 0) {
/* 265 */       char[] arrayOfChar = this.buffer;
/* 266 */       if (i + 4096 > arrayOfChar.length) {
/*     */         
/* 268 */         if (arrayOfChar.length >= 1073741823) {
/* 269 */           throw new IOException("Error in parsing script, statement size exceeds 1G, first 80 characters of statement looks like: " + new String(this.buffer, this.bufferStart, 80));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 274 */         this.buffer = new char[arrayOfChar.length * 2];
/*     */       } 
/* 276 */       System.arraycopy(arrayOfChar, this.bufferStart, this.buffer, 0, i);
/*     */     } 
/* 278 */     this.remarkStart -= this.bufferStart;
/* 279 */     this.bufferStart = 0;
/* 280 */     this.bufferPos = i;
/* 281 */     int j = this.reader.read(this.buffer, i, 4096);
/* 282 */     if (j == -1) {
/*     */       
/* 284 */       this.bufferEnd = -1024;
/* 285 */       this.endOfFile = true;
/*     */ 
/*     */       
/* 288 */       this.bufferPos++;
/* 289 */       return -1;
/*     */     } 
/* 291 */     this.bufferEnd = i + j;
/* 292 */     return this.buffer[this.bufferPos++];
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isInsideRemark() {
/* 302 */     return this.insideRemark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBlockRemark() {
/* 312 */     return this.blockRemark;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSkipRemarks(boolean paramBoolean) {
/* 321 */     this.skipRemarks = paramBoolean;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\h\\util\ScriptReader.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       1.1.3
 */