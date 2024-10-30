/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import org.apache.poi.util.LittleEndianInput;
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
/*     */ public class DocumentInputStream
/*     */   extends InputStream
/*     */   implements LittleEndianInput
/*     */ {
/*     */   protected static final int EOF = -1;
/*     */   protected static final int SIZE_SHORT = 2;
/*     */   protected static final int SIZE_INT = 4;
/*     */   protected static final int SIZE_LONG = 8;
/*     */   private DocumentInputStream delegate;
/*     */   
/*     */   protected DocumentInputStream() {}
/*     */   
/*     */   public DocumentInputStream(DocumentEntry paramDocumentEntry) throws IOException {
/*  53 */     if (!(paramDocumentEntry instanceof DocumentNode)) {
/*  54 */       throw new IOException("Cannot open internal document storage");
/*     */     }
/*  56 */     DocumentNode documentNode = (DocumentNode)paramDocumentEntry;
/*  57 */     DirectoryNode directoryNode = (DirectoryNode)paramDocumentEntry.getParent();
/*     */     
/*  59 */     if (documentNode.getDocument() != null) {
/*  60 */       this.delegate = new ODocumentInputStream(paramDocumentEntry);
/*  61 */     } else if (directoryNode.getOFileSystem() != null) {
/*  62 */       this.delegate = new ODocumentInputStream(paramDocumentEntry);
/*  63 */     } else if (directoryNode.getNFileSystem() != null) {
/*  64 */       this.delegate = new NDocumentInputStream(paramDocumentEntry);
/*     */     } else {
/*  66 */       throw new IOException("No FileSystem bound on the parent, can't read contents");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentInputStream(OPOIFSDocument paramOPOIFSDocument) {
/*  76 */     this.delegate = new ODocumentInputStream(paramOPOIFSDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentInputStream(NPOIFSDocument paramNPOIFSDocument) {
/*  85 */     this.delegate = new NDocumentInputStream(paramNPOIFSDocument);
/*     */   }
/*     */ 
/*     */   
/*     */   public int available() {
/*  90 */     return this.delegate.available();
/*     */   }
/*     */ 
/*     */   
/*     */   public void close() {
/*  95 */     this.delegate.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public void mark(int paramInt) {
/* 100 */     this.delegate.mark(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean markSupported() {
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int read() throws IOException {
/* 115 */     return this.delegate.read();
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte) throws IOException {
/* 120 */     return read(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public int read(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/* 125 */     return this.delegate.read(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 135 */     this.delegate.reset();
/*     */   }
/*     */ 
/*     */   
/*     */   public long skip(long paramLong) throws IOException {
/* 140 */     return this.delegate.skip(paramLong);
/*     */   }
/*     */ 
/*     */   
/*     */   public byte readByte() {
/* 145 */     return this.delegate.readByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public double readDouble() {
/* 150 */     return this.delegate.readDouble();
/*     */   }
/*     */ 
/*     */   
/*     */   public short readShort() {
/* 155 */     return (short)readUShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte) {
/* 160 */     readFully(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void readFully(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 165 */     this.delegate.readFully(paramArrayOfbyte, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */   
/*     */   public long readLong() {
/* 170 */     return this.delegate.readLong();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readInt() {
/* 175 */     return this.delegate.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUShort() {
/* 180 */     return this.delegate.readUShort();
/*     */   }
/*     */ 
/*     */   
/*     */   public int readUByte() {
/* 185 */     return this.delegate.readUByte();
/*     */   }
/*     */   
/*     */   public long readUInt() {
/* 189 */     int i = readInt();
/* 190 */     return i & 0xFFFFFFFFL;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\DocumentInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */