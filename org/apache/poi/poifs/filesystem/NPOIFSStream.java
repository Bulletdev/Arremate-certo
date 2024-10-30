/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Iterator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NPOIFSStream
/*     */   implements Iterable<ByteBuffer>
/*     */ {
/*     */   private BlockStore blockStore;
/*     */   private int startBlock;
/*     */   private OutputStream outStream;
/*     */   
/*     */   public NPOIFSStream(BlockStore paramBlockStore, int paramInt) {
/*  59 */     this.blockStore = paramBlockStore;
/*  60 */     this.startBlock = paramInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NPOIFSStream(BlockStore paramBlockStore) {
/*  68 */     this.blockStore = paramBlockStore;
/*  69 */     this.startBlock = -2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getStartBlock() {
/*  78 */     return this.startBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<ByteBuffer> iterator() {
/*  86 */     return getBlockIterator();
/*     */   }
/*     */   
/*     */   public Iterator<ByteBuffer> getBlockIterator() {
/*  90 */     if (this.startBlock == -2) {
/*  91 */       throw new IllegalStateException("Can't read from a new stream before it has been written to");
/*     */     }
/*     */ 
/*     */     
/*  95 */     return new StreamBlockByteBufferIterator(this.startBlock);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void updateContents(byte[] paramArrayOfbyte) throws IOException {
/* 105 */     OutputStream outputStream = getOutputStream();
/* 106 */     outputStream.write(paramArrayOfbyte);
/* 107 */     outputStream.close();
/*     */   }
/*     */   
/*     */   public OutputStream getOutputStream() throws IOException {
/* 111 */     if (this.outStream == null) {
/* 112 */       this.outStream = new StreamBlockByteBuffer();
/*     */     }
/* 114 */     return this.outStream;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void free() throws IOException {
/* 125 */     BlockStore.ChainLoopDetector chainLoopDetector = this.blockStore.getChainLoopDetector();
/* 126 */     free(chainLoopDetector);
/*     */   }
/*     */   private void free(BlockStore.ChainLoopDetector paramChainLoopDetector) {
/* 129 */     int i = this.startBlock;
/* 130 */     while (i != -2) {
/* 131 */       int j = i;
/* 132 */       paramChainLoopDetector.claim(j);
/* 133 */       i = this.blockStore.getNextBlock(j);
/* 134 */       this.blockStore.setNextBlock(j, -1);
/*     */     } 
/* 136 */     this.startBlock = -2;
/*     */   }
/*     */ 
/*     */   
/*     */   protected class StreamBlockByteBufferIterator
/*     */     implements Iterator<ByteBuffer>
/*     */   {
/*     */     private BlockStore.ChainLoopDetector loopDetector;
/*     */     private int nextBlock;
/*     */     
/*     */     protected StreamBlockByteBufferIterator(int param1Int) {
/* 147 */       this.nextBlock = param1Int;
/*     */       try {
/* 149 */         this.loopDetector = NPOIFSStream.this.blockStore.getChainLoopDetector();
/* 150 */       } catch (IOException iOException) {
/* 151 */         throw new RuntimeException(iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public boolean hasNext() {
/* 156 */       if (this.nextBlock == -2) {
/* 157 */         return false;
/*     */       }
/* 159 */       return true;
/*     */     }
/*     */     
/*     */     public ByteBuffer next() {
/* 163 */       if (this.nextBlock == -2) {
/* 164 */         throw new IndexOutOfBoundsException("Can't read past the end of the stream");
/*     */       }
/*     */       
/*     */       try {
/* 168 */         this.loopDetector.claim(this.nextBlock);
/* 169 */         ByteBuffer byteBuffer = NPOIFSStream.this.blockStore.getBlockAt(this.nextBlock);
/* 170 */         this.nextBlock = NPOIFSStream.this.blockStore.getNextBlock(this.nextBlock);
/* 171 */         return byteBuffer;
/* 172 */       } catch (IOException iOException) {
/* 173 */         throw new RuntimeException(iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     public void remove() {
/* 178 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   protected class StreamBlockByteBuffer extends OutputStream {
/* 183 */     byte[] oneByte = new byte[1];
/*     */     
/*     */     ByteBuffer buffer;
/*     */     BlockStore.ChainLoopDetector loopDetector;
/*     */     int prevBlock;
/*     */     int nextBlock;
/*     */     
/*     */     protected StreamBlockByteBuffer() throws IOException {
/* 191 */       this.loopDetector = NPOIFSStream.this.blockStore.getChainLoopDetector();
/* 192 */       this.prevBlock = -2;
/* 193 */       this.nextBlock = NPOIFSStream.this.startBlock;
/*     */     }
/*     */     
/*     */     protected void createBlockIfNeeded() throws IOException {
/* 197 */       if (this.buffer != null && this.buffer.hasRemaining())
/*     */         return; 
/* 199 */       int i = this.nextBlock;
/*     */ 
/*     */ 
/*     */       
/* 203 */       if (i == -2) {
/* 204 */         i = NPOIFSStream.this.blockStore.getFreeBlock();
/* 205 */         this.loopDetector.claim(i);
/*     */ 
/*     */         
/* 208 */         this.nextBlock = -2;
/*     */ 
/*     */         
/* 211 */         if (this.prevBlock != -2) {
/* 212 */           NPOIFSStream.this.blockStore.setNextBlock(this.prevBlock, i);
/*     */         }
/* 214 */         NPOIFSStream.this.blockStore.setNextBlock(i, -2);
/*     */ 
/*     */ 
/*     */         
/* 218 */         if (NPOIFSStream.this.startBlock == -2) {
/* 219 */           NPOIFSStream.this.startBlock = i;
/*     */         }
/*     */       } else {
/* 222 */         this.loopDetector.claim(i);
/* 223 */         this.nextBlock = NPOIFSStream.this.blockStore.getNextBlock(i);
/*     */       } 
/*     */       
/* 226 */       this.buffer = NPOIFSStream.this.blockStore.createBlockIfNeeded(i);
/*     */ 
/*     */       
/* 229 */       this.prevBlock = i;
/*     */     }
/*     */     
/*     */     public void write(int param1Int) throws IOException {
/* 233 */       this.oneByte[0] = (byte)(param1Int & 0xFF);
/* 234 */       write(this.oneByte);
/*     */     }
/*     */     
/*     */     public void write(byte[] param1ArrayOfbyte, int param1Int1, int param1Int2) throws IOException {
/* 238 */       if (param1Int1 < 0 || param1Int1 > param1ArrayOfbyte.length || param1Int2 < 0 || param1Int1 + param1Int2 > param1ArrayOfbyte.length || param1Int1 + param1Int2 < 0)
/*     */       {
/* 240 */         throw new IndexOutOfBoundsException(); } 
/* 241 */       if (param1Int2 == 0) {
/*     */         return;
/*     */       }
/*     */       
/*     */       do {
/* 246 */         createBlockIfNeeded();
/* 247 */         int i = Math.min(this.buffer.remaining(), param1Int2);
/* 248 */         this.buffer.put(param1ArrayOfbyte, param1Int1, i);
/* 249 */         param1Int1 += i;
/* 250 */         param1Int2 -= i;
/* 251 */       } while (param1Int2 > 0);
/*     */     }
/*     */ 
/*     */     
/*     */     public void close() throws IOException {
/* 256 */       NPOIFSStream nPOIFSStream = new NPOIFSStream(NPOIFSStream.this.blockStore, this.nextBlock);
/* 257 */       nPOIFSStream.free(this.loopDetector);
/*     */ 
/*     */       
/* 260 */       if (this.prevBlock != -2)
/* 261 */         NPOIFSStream.this.blockStore.setNextBlock(this.prevBlock, -2); 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NPOIFSStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */