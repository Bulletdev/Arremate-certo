/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import org.apache.poi.poifs.property.DocumentProperty;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NDocumentOutputStream
/*     */   extends OutputStream
/*     */ {
/*     */   private int _document_size;
/*     */   private boolean _closed;
/*     */   private NPOIFSDocument _document;
/*     */   private DocumentProperty _property;
/*  45 */   private ByteArrayOutputStream _buffer = new ByteArrayOutputStream(4096);
/*     */ 
/*     */ 
/*     */   
/*     */   private NPOIFSStream _stream;
/*     */ 
/*     */ 
/*     */   
/*     */   private OutputStream _stream_output;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NDocumentOutputStream(DocumentEntry paramDocumentEntry) throws IOException {
/*  59 */     if (!(paramDocumentEntry instanceof DocumentNode)) {
/*  60 */       throw new IOException("Cannot open internal document storage, " + paramDocumentEntry + " not a Document Node");
/*     */     }
/*  62 */     this._document_size = 0;
/*  63 */     this._closed = false;
/*     */     
/*  65 */     this._property = (DocumentProperty)((DocumentNode)paramDocumentEntry).getProperty();
/*     */     
/*  67 */     this._document = new NPOIFSDocument((DocumentNode)paramDocumentEntry);
/*  68 */     this._document.free();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NDocumentOutputStream(DirectoryEntry paramDirectoryEntry, String paramString) throws IOException {
/*  78 */     if (!(paramDirectoryEntry instanceof DirectoryNode)) {
/*  79 */       throw new IOException("Cannot open internal directory storage, " + paramDirectoryEntry + " not a Directory Node");
/*     */     }
/*  81 */     this._document_size = 0;
/*  82 */     this._closed = false;
/*     */ 
/*     */     
/*  85 */     DocumentEntry documentEntry = paramDirectoryEntry.createDocument(paramString, new ByteArrayInputStream(new byte[0]));
/*  86 */     this._property = (DocumentProperty)((DocumentNode)documentEntry).getProperty();
/*  87 */     this._document = new NPOIFSDocument((DocumentNode)documentEntry);
/*     */   }
/*     */   
/*     */   private void dieIfClosed() throws IOException {
/*  91 */     if (this._closed) {
/*  92 */       throw new IOException("cannot perform requested operation on a closed stream");
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void checkBufferSize() throws IOException {
/*  98 */     if (this._buffer.size() > 4096) {
/*     */       
/* 100 */       byte[] arrayOfByte = this._buffer.toByteArray();
/* 101 */       this._buffer = null;
/* 102 */       write(arrayOfByte, 0, arrayOfByte.length);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/* 109 */     dieIfClosed();
/*     */     
/* 111 */     if (this._buffer != null) {
/* 112 */       this._buffer.write(paramInt);
/* 113 */       checkBufferSize();
/*     */     } else {
/* 115 */       write(new byte[] { (byte)paramInt });
/*     */     } 
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/* 120 */     dieIfClosed();
/*     */     
/* 122 */     if (this._buffer != null) {
/* 123 */       this._buffer.write(paramArrayOfbyte);
/* 124 */       checkBufferSize();
/*     */     } else {
/* 126 */       write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 131 */     dieIfClosed();
/*     */     
/* 133 */     if (this._buffer != null) {
/* 134 */       this._buffer.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 135 */       checkBufferSize();
/*     */     } else {
/* 137 */       if (this._stream == null) {
/* 138 */         this._stream = new NPOIFSStream(this._document.getFileSystem());
/* 139 */         this._stream_output = this._stream.getOutputStream();
/*     */       } 
/* 141 */       this._stream_output.write(paramArrayOfbyte, paramInt1, paramInt2);
/* 142 */       this._document_size += paramInt2;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 148 */     if (this._buffer != null) {
/*     */       
/* 150 */       this._document.replaceContents(new ByteArrayInputStream(this._buffer.toByteArray()));
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 155 */       this._stream_output.close();
/* 156 */       this._property.updateSize(this._document_size);
/* 157 */       this._property.setStartBlock(this._stream.getStartBlock());
/*     */     } 
/*     */ 
/*     */     
/* 161 */     this._closed = true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NDocumentOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */