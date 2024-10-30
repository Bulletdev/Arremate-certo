/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.poifs.property.DocumentProperty;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NDocumentInputStream
/*     */   extends DocumentInputStream
/*     */ {
/*     */   private int _current_offset;
/*     */   private int _current_block_count;
/*     */   private int _marked_offset;
/*     */   private int _marked_offset_count;
/*     */   private int _document_size;
/*     */   private boolean _closed;
/*     */   private NPOIFSDocument _document;
/*     */   private Iterator<ByteBuffer> _data;
/*     */   private ByteBuffer _buffer;
/*     */   
/*     */   public NDocumentInputStream(DocumentEntry paramDocumentEntry) throws IOException {
/*  63 */     if (!(paramDocumentEntry instanceof DocumentNode)) {
/*  64 */       throw new IOException("Cannot open internal document storage, " + paramDocumentEntry + " not a Document Node");
/*     */     }
/*  66 */     this._current_offset = 0;
/*  67 */     this._current_block_count = 0;
/*  68 */     this._marked_offset = 0;
/*  69 */     this._marked_offset_count = 0;
/*  70 */     this._document_size = paramDocumentEntry.getSize();
/*  71 */     this._closed = false;
/*     */     
/*  73 */     DocumentNode documentNode = (DocumentNode)paramDocumentEntry;
/*  74 */     DocumentProperty documentProperty = (DocumentProperty)documentNode.getProperty();
/*  75 */     this._document = new NPOIFSDocument(documentProperty, ((DirectoryNode)documentNode.getParent()).getNFileSystem());
/*     */ 
/*     */ 
/*     */     
/*  79 */     this._data = this._document.getBlockIterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NDocumentInputStream(NPOIFSDocument paramNPOIFSDocument) {
/*  88 */     this._current_offset = 0;
/*  89 */     this._current_block_count = 0;
/*  90 */     this._marked_offset = 0;
/*  91 */     this._marked_offset_count = 0;
/*  92 */     this._document_size = paramNPOIFSDocument.getSize();
/*  93 */     this._closed = false;
/*  94 */     this._document = paramNPOIFSDocument;
/*  95 */     this._data = this._document.getBlockIterator();
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/* 100 */     if (this._closed) {
/* 101 */       throw new IllegalStateException("cannot perform requested operation on a closed stream");
/*     */     }
/* 103 */     return this._document_size - this._current_offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/* 108 */     this._closed = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 113 */     this._marked_offset = this._current_offset;
/* 114 */     this._marked_offset_count = Math.max(0, this._current_block_count - 1);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 119 */     dieIfClosed();
/* 120 */     if (atEOD()) {
/* 121 */       return -1;
/*     */     }
/* 123 */     byte[] arrayOfByte = new byte[1];
/* 124 */     int i = read(arrayOfByte, 0, 1);
/* 125 */     if (i >= 0) {
/* 126 */       if (arrayOfByte[0] < 0) {
/* 127 */         return arrayOfByte[0] + 256;
/*     */       }
/* 129 */       return arrayOfByte[0];
/*     */     } 
/* 131 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 136 */     dieIfClosed();
/* 137 */     if (paramArrayOfbyte == null) {
/* 138 */       throw new IllegalArgumentException("buffer must not be null");
/*     */     }
/* 140 */     if (paramInt1 < 0 || paramInt2 < 0 || paramArrayOfbyte.length < paramInt1 + paramInt2) {
/* 141 */       throw new IndexOutOfBoundsException("can't read past buffer boundaries");
/*     */     }
/* 143 */     if (paramInt2 == 0) {
/* 144 */       return 0;
/*     */     }
/* 146 */     if (atEOD()) {
/* 147 */       return -1;
/*     */     }
/* 149 */     int i = Math.min(available(), paramInt2);
/* 150 */     readFully(paramArrayOfbyte, paramInt1, i);
/* 151 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 162 */     if (this._marked_offset == 0 && this._marked_offset_count == 0) {
/* 163 */       this._current_block_count = this._marked_offset_count;
/* 164 */       this._current_offset = this._marked_offset;
/* 165 */       this._data = this._document.getBlockIterator();
/* 166 */       this._buffer = null;
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 171 */     this._data = this._document.getBlockIterator();
/* 172 */     this._current_offset = 0; int i;
/* 173 */     for (i = 0; i < this._marked_offset_count; i++) {
/* 174 */       this._buffer = this._data.next();
/* 175 */       this._current_offset += this._buffer.remaining();
/*     */     } 
/*     */     
/* 178 */     this._current_block_count = this._marked_offset_count;
/*     */ 
/*     */     
/* 181 */     if (this._current_offset != this._marked_offset) {
/*     */       
/* 183 */       this._buffer = this._data.next();
/* 184 */       this._current_block_count++;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 189 */       i = this._marked_offset - this._current_offset;
/* 190 */       this._buffer.position(this._buffer.position() + i);
/*     */     } 
/*     */ 
/*     */     
/* 194 */     this._current_offset = this._marked_offset;
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 199 */     dieIfClosed();
/* 200 */     if (paramLong < 0L) {
/* 201 */       return 0L;
/*     */     }
/* 203 */     int i = this._current_offset + (int)paramLong;
/*     */     
/* 205 */     if (i < this._current_offset) {
/*     */       
/* 207 */       i = this._document_size;
/* 208 */     } else if (i > this._document_size) {
/* 209 */       i = this._document_size;
/*     */     } 
/*     */     
/* 212 */     long l = (i - this._current_offset);
/*     */ 
/*     */     
/* 215 */     byte[] arrayOfByte = new byte[(int)l];
/* 216 */     readFully(arrayOfByte);
/* 217 */     return l;
/*     */   }
/*     */   
/*     */   private void dieIfClosed() throws IOException {
/* 221 */     if (this._closed) {
/* 222 */       throw new IOException("cannot perform requested operation on a closed stream");
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean atEOD() {
/* 227 */     return (this._current_offset == this._document_size);
/*     */   }
/*     */   
/*     */   private void checkAvaliable(int paramInt) {
/* 231 */     if (this._closed) {
/* 232 */       throw new IllegalStateException("cannot perform requested operation on a closed stream");
/*     */     }
/* 234 */     if (paramInt > this._document_size - this._current_offset) {
/* 235 */       throw new RuntimeException("Buffer underrun - requested " + paramInt + " bytes but " + (this._document_size - this._current_offset) + " was available");
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 242 */     checkAvaliable(paramInt2);
/*     */     
/* 244 */     int i = 0;
/* 245 */     while (i < paramInt2) {
/* 246 */       if (this._buffer == null || this._buffer.remaining() == 0) {
/* 247 */         this._current_block_count++;
/* 248 */         this._buffer = this._data.next();
/*     */       } 
/*     */       
/* 251 */       int j = Math.min(paramInt2 - i, this._buffer.remaining());
/* 252 */       this._buffer.get(paramArrayOfbyte, paramInt1 + i, j);
/* 253 */       this._current_offset += j;
/* 254 */       i += j;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 260 */     return (byte)readUByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 265 */     return Double.longBitsToDouble(readLong());
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 270 */     checkAvaliable(8);
/* 271 */     byte[] arrayOfByte = new byte[8];
/* 272 */     readFully(arrayOfByte, 0, 8);
/* 273 */     return LittleEndian.getLong(arrayOfByte, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 278 */     checkAvaliable(2);
/* 279 */     byte[] arrayOfByte = new byte[2];
/* 280 */     readFully(arrayOfByte, 0, 2);
/* 281 */     return LittleEndian.getShort(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 286 */     checkAvaliable(4);
/* 287 */     byte[] arrayOfByte = new byte[4];
/* 288 */     readFully(arrayOfByte, 0, 4);
/* 289 */     return LittleEndian.getInt(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUShort() {
/* 294 */     checkAvaliable(2);
/* 295 */     byte[] arrayOfByte = new byte[2];
/* 296 */     readFully(arrayOfByte, 0, 2);
/* 297 */     return LittleEndian.getUShort(arrayOfByte);
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUByte() {
/* 302 */     checkAvaliable(1);
/* 303 */     byte[] arrayOfByte = new byte[1];
/* 304 */     readFully(arrayOfByte, 0, 1);
/* 305 */     if (arrayOfByte[0] >= 0)
/* 306 */       return arrayOfByte[0]; 
/* 307 */     return arrayOfByte[0] + 256;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NDocumentInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */