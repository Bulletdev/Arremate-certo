/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.BufferedInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.poifs.property.DocumentProperty;
/*     */ import org.apache.poi.util.HexDump;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NPOIFSDocument
/*     */   implements POIFSViewable
/*     */ {
/*     */   private DocumentProperty _property;
/*     */   private NPOIFSFileSystem _filesystem;
/*     */   private NPOIFSStream _stream;
/*     */   private int _block_size;
/*     */   
/*     */   public NPOIFSDocument(DocumentNode paramDocumentNode) throws IOException {
/*  50 */     this((DocumentProperty)paramDocumentNode.getProperty(), ((DirectoryNode)paramDocumentNode.getParent()).getNFileSystem());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NPOIFSDocument(DocumentProperty paramDocumentProperty, NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*  60 */     this._property = paramDocumentProperty;
/*  61 */     this._filesystem = paramNPOIFSFileSystem;
/*     */     
/*  63 */     if (paramDocumentProperty.getSize() < 4096) {
/*  64 */       this._stream = new NPOIFSStream(this._filesystem.getMiniStore(), paramDocumentProperty.getStartBlock());
/*  65 */       this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
/*     */     } else {
/*  67 */       this._stream = new NPOIFSStream(this._filesystem, paramDocumentProperty.getStartBlock());
/*  68 */       this._block_size = this._filesystem.getBlockStoreBlockSize();
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
/*     */   public NPOIFSDocument(String paramString, NPOIFSFileSystem paramNPOIFSFileSystem, InputStream paramInputStream) throws IOException {
/*  81 */     this._filesystem = paramNPOIFSFileSystem;
/*     */ 
/*     */     
/*  84 */     int i = store(paramInputStream);
/*     */ 
/*     */     
/*  87 */     this._property = new DocumentProperty(paramString, i);
/*  88 */     this._property.setStartBlock(this._stream.getStartBlock());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public NPOIFSDocument(String paramString, int paramInt, NPOIFSFileSystem paramNPOIFSFileSystem, POIFSWriterListener paramPOIFSWriterListener) throws IOException {
/*  94 */     this._filesystem = paramNPOIFSFileSystem;
/*     */     
/*  96 */     if (paramInt < 4096) {
/*  97 */       this._stream = new NPOIFSStream(paramNPOIFSFileSystem.getMiniStore());
/*  98 */       this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
/*     */     } else {
/* 100 */       this._stream = new NPOIFSStream(paramNPOIFSFileSystem);
/* 101 */       this._block_size = this._filesystem.getBlockStoreBlockSize();
/*     */     } 
/*     */     
/* 104 */     OutputStream outputStream = this._stream.getOutputStream();
/* 105 */     DocumentOutputStream documentOutputStream = new DocumentOutputStream(outputStream, paramInt);
/* 106 */     POIFSDocumentPath pOIFSDocumentPath = new POIFSDocumentPath(paramString.split("\\\\"));
/* 107 */     String str = pOIFSDocumentPath.getComponent(pOIFSDocumentPath.length() - 1);
/* 108 */     POIFSWriterEvent pOIFSWriterEvent = new POIFSWriterEvent(documentOutputStream, pOIFSDocumentPath, str, paramInt);
/* 109 */     paramPOIFSWriterListener.processPOIFSWriterEvent(pOIFSWriterEvent);
/* 110 */     outputStream.close();
/*     */ 
/*     */     
/* 113 */     this._property = new DocumentProperty(paramString, paramInt);
/* 114 */     this._property.setStartBlock(this._stream.getStartBlock());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int store(InputStream paramInputStream) throws IOException {
/* 121 */     char c = 'က';
/* 122 */     BufferedInputStream bufferedInputStream = new BufferedInputStream(paramInputStream, 4097);
/* 123 */     bufferedInputStream.mark(4096);
/*     */ 
/*     */     
/* 126 */     if (bufferedInputStream.skip(4096L) < 4096L) {
/* 127 */       this._stream = new NPOIFSStream(this._filesystem.getMiniStore());
/* 128 */       this._block_size = this._filesystem.getMiniStore().getBlockStoreBlockSize();
/*     */     } else {
/* 130 */       this._stream = new NPOIFSStream(this._filesystem);
/* 131 */       this._block_size = this._filesystem.getBlockStoreBlockSize();
/*     */     } 
/*     */ 
/*     */     
/* 135 */     bufferedInputStream.reset();
/*     */ 
/*     */     
/* 138 */     OutputStream outputStream = this._stream.getOutputStream();
/* 139 */     byte[] arrayOfByte = new byte[1024];
/* 140 */     int i = 0;
/*     */     int j;
/* 142 */     for (; (j = bufferedInputStream.read(arrayOfByte)) != -1; i += j) {
/* 143 */       outputStream.write(arrayOfByte, 0, j);
/*     */     }
/*     */ 
/*     */     
/* 147 */     j = i % this._block_size;
/* 148 */     if (j != 0 && j != this._block_size) {
/* 149 */       int k = this._block_size - j;
/* 150 */       byte[] arrayOfByte1 = new byte[k];
/* 151 */       Arrays.fill(arrayOfByte1, (byte)-1);
/* 152 */       outputStream.write(arrayOfByte1);
/*     */     } 
/*     */ 
/*     */     
/* 156 */     outputStream.close();
/* 157 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void free() throws IOException {
/* 164 */     this._stream.free();
/* 165 */     this._property.setStartBlock(-2);
/*     */   }
/*     */ 
/*     */   
/*     */   NPOIFSFileSystem getFileSystem() {
/* 170 */     return this._filesystem;
/*     */   }
/*     */   
/*     */   int getDocumentBlockSize() {
/* 174 */     return this._block_size;
/*     */   }
/*     */   
/*     */   Iterator<ByteBuffer> getBlockIterator() {
/* 178 */     if (getSize() > 0) {
/* 179 */       return this._stream.getBlockIterator();
/*     */     }
/* 181 */     List<?> list = Collections.emptyList();
/* 182 */     return (Iterator)list.iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 190 */     return this._property.getSize();
/*     */   }
/*     */   
/*     */   public void replaceContents(InputStream paramInputStream) throws IOException {
/* 194 */     free();
/* 195 */     int i = store(paramInputStream);
/* 196 */     this._property.setStartBlock(this._stream.getStartBlock());
/* 197 */     this._property.updateSize(i);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DocumentProperty getDocumentProperty() {
/* 204 */     return this._property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getViewableArray() {
/* 213 */     String str = "<NO DATA>";
/*     */     
/* 215 */     if (getSize() > 0) {
/*     */       
/* 217 */       byte[] arrayOfByte = new byte[getSize()];
/* 218 */       int i = 0;
/* 219 */       for (ByteBuffer byteBuffer : this._stream) {
/* 220 */         int j = Math.min(this._block_size, arrayOfByte.length - i);
/* 221 */         byteBuffer.get(arrayOfByte, i, j);
/* 222 */         i += j;
/*     */       } 
/*     */       
/* 225 */       str = HexDump.dump(arrayOfByte, 0L, 0);
/*     */     } 
/*     */     
/* 228 */     return (Object[])new String[] { str };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Object> getViewableIterator() {
/* 238 */     return Collections.<Object>emptyList().iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean preferArray() {
/* 249 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShortDescription() {
/* 259 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 261 */     stringBuffer.append("Document: \"").append(this._property.getName()).append("\"");
/* 262 */     stringBuffer.append(" size = ").append(getSize());
/* 263 */     return stringBuffer.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NPOIFSDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */