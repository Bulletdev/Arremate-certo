/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.poifs.storage.DataInputBlock;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class ODocumentInputStream
/*     */   extends DocumentInputStream
/*     */ {
/*     */   private int _current_offset;
/*     */   private int _marked_offset;
/*     */   private int _document_size;
/*     */   private boolean _closed;
/*     */   private OPOIFSDocument _document;
/*     */   private DataInputBlock _currentBlock;
/*     */   
/*     */   public ODocumentInputStream(DocumentEntry paramDocumentEntry) throws IOException {
/*  56 */     if (!(paramDocumentEntry instanceof DocumentNode)) {
/*  57 */       throw new IOException("Cannot open internal document storage");
/*     */     }
/*  59 */     DocumentNode documentNode = (DocumentNode)paramDocumentEntry;
/*  60 */     if (documentNode.getDocument() == null) {
/*  61 */       throw new IOException("Cannot open internal document storage");
/*     */     }
/*     */     
/*  64 */     this._current_offset = 0;
/*  65 */     this._marked_offset = 0;
/*  66 */     this._document_size = paramDocumentEntry.getSize();
/*  67 */     this._closed = false;
/*  68 */     this._document = documentNode.getDocument();
/*  69 */     this._currentBlock = getDataInputBlock(0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ODocumentInputStream(OPOIFSDocument paramOPOIFSDocument) {
/*  78 */     this._current_offset = 0;
/*  79 */     this._marked_offset = 0;
/*  80 */     this._document_size = paramOPOIFSDocument.getSize();
/*  81 */     this._closed = false;
/*  82 */     this._document = paramOPOIFSDocument;
/*  83 */     this._currentBlock = getDataInputBlock(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/*  88 */     if (this._closed) {
/*  89 */       throw new IllegalStateException("cannot perform requested operation on a closed stream");
/*     */     }
/*  91 */     return this._document_size - this._current_offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*  96 */     this._closed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 101 */     this._marked_offset = this._current_offset;
/*     */   }
/*     */   
/*     */   private DataInputBlock getDataInputBlock(int paramInt) {
/* 105 */     return this._document.getDataInputBlock(paramInt);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 110 */     dieIfClosed();
/* 111 */     if (atEOD()) {
/* 112 */       return -1;
/*     */     }
/* 114 */     int i = this._currentBlock.readUByte();
/* 115 */     this._current_offset++;
/* 116 */     if (this._currentBlock.available() < 1) {
/* 117 */       this._currentBlock = getDataInputBlock(this._current_offset);
/*     */     }
/* 119 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 124 */     dieIfClosed();
/* 125 */     if (paramArrayOfbyte == null) {
/* 126 */       throw new IllegalArgumentException("buffer must not be null");
/*     */     }
/* 128 */     if (paramInt1 < 0 || paramInt2 < 0 || paramArrayOfbyte.length < paramInt1 + paramInt2) {
/* 129 */       throw new IndexOutOfBoundsException("can't read past buffer boundaries");
/*     */     }
/* 131 */     if (paramInt2 == 0) {
/* 132 */       return 0;
/*     */     }
/* 134 */     if (atEOD()) {
/* 135 */       return -1;
/*     */     }
/* 137 */     int i = Math.min(available(), paramInt2);
/* 138 */     readFully(paramArrayOfbyte, paramInt1, i);
/* 139 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 149 */     this._current_offset = this._marked_offset;
/* 150 */     this._currentBlock = getDataInputBlock(this._current_offset);
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 155 */     dieIfClosed();
/* 156 */     if (paramLong < 0L) {
/* 157 */       return 0L;
/*     */     }
/* 159 */     int i = this._current_offset + (int)paramLong;
/*     */     
/* 161 */     if (i < this._current_offset) {
/*     */ 
/*     */       
/* 164 */       i = this._document_size;
/* 165 */     } else if (i > this._document_size) {
/* 166 */       i = this._document_size;
/*     */     } 
/* 168 */     long l = (i - this._current_offset);
/*     */     
/* 170 */     this._current_offset = i;
/* 171 */     this._currentBlock = getDataInputBlock(this._current_offset);
/* 172 */     return l;
/*     */   }
/*     */   
/*     */   private void dieIfClosed() throws IOException {
/* 176 */     if (this._closed) {
/* 177 */       throw new IOException("cannot perform requested operation on a closed stream");
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean atEOD() {
/* 182 */     return (this._current_offset == this._document_size);
/*     */   }
/*     */   
/*     */   private void checkAvaliable(int paramInt) {
/* 186 */     if (this._closed) {
/* 187 */       throw new IllegalStateException("cannot perform requested operation on a closed stream");
/*     */     }
/* 189 */     if (paramInt > this._document_size - this._current_offset) {
/* 190 */       throw new RuntimeException("Buffer underrun - requested " + paramInt + " bytes but " + (this._document_size - this._current_offset) + " was available");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 197 */     return (byte)readUByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 202 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 207 */     return (short)readUShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 212 */     checkAvaliable(paramInt2);
/* 213 */     int i = this._currentBlock.available();
/* 214 */     if (i > paramInt2) {
/* 215 */       this._currentBlock.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/* 216 */       this._current_offset += paramInt2;
/*     */       
/*     */       return;
/*     */     } 
/* 220 */     int j = paramInt2;
/* 221 */     int k = paramInt1;
/* 222 */     while (j > 0) {
/* 223 */       int m; boolean bool = (j >= i) ? true : false;
/*     */       
/* 225 */       if (bool) {
/* 226 */         m = i;
/*     */       } else {
/* 228 */         m = j;
/*     */       } 
/* 230 */       this._currentBlock.readFully(paramArrayOfbyte, k, m);
/* 231 */       j -= m;
/* 232 */       k += m;
/* 233 */       this._current_offset += m;
/* 234 */       if (bool) {
/* 235 */         if (this._current_offset == this._document_size) {
/* 236 */           if (j > 0) {
/* 237 */             throw new IllegalStateException("reached end of document stream unexpectedly");
/*     */           }
/*     */           
/* 240 */           this._currentBlock = null;
/*     */           break;
/*     */         } 
/* 243 */         this._currentBlock = getDataInputBlock(this._current_offset);
/* 244 */         i = this._currentBlock.available();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public long readLong() {
/*     */     long l;
/* 251 */     checkAvaliable(8);
/* 252 */     int i = this._currentBlock.available();
/*     */     
/* 254 */     if (i > 8) {
/* 255 */       l = this._currentBlock.readLongLE();
/*     */     } else {
/* 257 */       DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + i);
/* 258 */       if (i == 8) {
/* 259 */         l = this._currentBlock.readLongLE();
/*     */       } else {
/* 261 */         l = dataInputBlock.readLongLE(this._currentBlock, i);
/*     */       } 
/* 263 */       this._currentBlock = dataInputBlock;
/*     */     } 
/* 265 */     this._current_offset += 8;
/* 266 */     return l;
/*     */   }
/*     */   
/*     */   public int readInt() {
/*     */     int j;
/* 271 */     checkAvaliable(4);
/* 272 */     int i = this._currentBlock.available();
/*     */     
/* 274 */     if (i > 4) {
/* 275 */       j = this._currentBlock.readIntLE();
/*     */     } else {
/* 277 */       DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + i);
/* 278 */       if (i == 4) {
/* 279 */         j = this._currentBlock.readIntLE();
/*     */       } else {
/* 281 */         j = dataInputBlock.readIntLE(this._currentBlock, i);
/*     */       } 
/* 283 */       this._currentBlock = dataInputBlock;
/*     */     } 
/* 285 */     this._current_offset += 4;
/* 286 */     return j;
/*     */   }
/*     */   
/*     */   public int readUShort() {
/*     */     int j;
/* 291 */     checkAvaliable(2);
/* 292 */     int i = this._currentBlock.available();
/*     */     
/* 294 */     if (i > 2) {
/* 295 */       j = this._currentBlock.readUShortLE();
/*     */     } else {
/* 297 */       DataInputBlock dataInputBlock = getDataInputBlock(this._current_offset + i);
/* 298 */       if (i == 2) {
/* 299 */         j = this._currentBlock.readUShortLE();
/*     */       } else {
/* 301 */         j = dataInputBlock.readUShortLE(this._currentBlock);
/*     */       } 
/* 303 */       this._currentBlock = dataInputBlock;
/*     */     } 
/* 305 */     this._current_offset += 2;
/* 306 */     return j;
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUByte() {
/* 311 */     checkAvaliable(1);
/* 312 */     int i = this._currentBlock.readUByte();
/* 313 */     this._current_offset++;
/* 314 */     if (this._currentBlock.available() < 1) {
/* 315 */       this._currentBlock = getDataInputBlock(this._current_offset);
/*     */     }
/* 317 */     return i;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\ODocumentInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */