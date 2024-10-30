/*     */ package org.apache.poi.poifs.crypt;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.FilterOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.security.GeneralSecurityException;
/*     */ import javax.crypto.Cipher;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentOutputStream;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterEvent;
/*     */ import org.apache.poi.poifs.filesystem.POIFSWriterListener;
/*     */ import org.apache.poi.util.Internal;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.util.TempFile;
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
/*     */ @Internal
/*     */ public abstract class ChunkedCipherOutputStream
/*     */   extends FilterOutputStream
/*     */ {
/*  44 */   private static final POILogger logger = POILogFactory.getLogger(ChunkedCipherOutputStream.class);
/*     */   
/*     */   protected final int chunkSize;
/*     */   
/*     */   protected final int chunkMask;
/*     */   
/*     */   protected final int chunkBits;
/*     */   private final byte[] _chunk;
/*     */   private final File fileOut;
/*     */   private final DirectoryNode dir;
/*  54 */   private long _pos = 0L;
/*     */   private Cipher _cipher;
/*     */   
/*     */   public ChunkedCipherOutputStream(DirectoryNode paramDirectoryNode, int paramInt) throws IOException, GeneralSecurityException {
/*  58 */     super(null);
/*  59 */     this.chunkSize = paramInt;
/*  60 */     this.chunkMask = paramInt - 1;
/*  61 */     this.chunkBits = Integer.bitCount(this.chunkMask);
/*  62 */     this._chunk = new byte[paramInt];
/*     */     
/*  64 */     this.fileOut = TempFile.createTempFile("encrypted_package", "crypt");
/*  65 */     this.fileOut.deleteOnExit();
/*  66 */     this.out = new FileOutputStream(this.fileOut);
/*  67 */     this.dir = paramDirectoryNode;
/*  68 */     this._cipher = initCipherForBlock(null, 0, false);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(int paramInt) throws IOException {
/*  83 */     write(new byte[] { (byte)paramInt });
/*     */   }
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte) throws IOException {
/*  87 */     write(paramArrayOfbyte, 0, paramArrayOfbyte.length);
/*     */   }
/*     */ 
/*     */   
/*     */   public void write(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws IOException {
/*  92 */     if (paramInt2 == 0)
/*     */       return; 
/*  94 */     if (paramInt2 < 0 || paramArrayOfbyte.length < paramInt1 + paramInt2) {
/*  95 */       throw new IOException("not enough bytes in your input buffer");
/*     */     }
/*     */     
/*  98 */     while (paramInt2 > 0) {
/*  99 */       int i = (int)(this._pos & this.chunkMask);
/* 100 */       int j = Math.min(this.chunkSize - i, paramInt2);
/* 101 */       System.arraycopy(paramArrayOfbyte, paramInt1, this._chunk, i, j);
/* 102 */       this._pos += j;
/* 103 */       paramInt1 += j;
/* 104 */       paramInt2 -= j;
/* 105 */       if ((this._pos & this.chunkMask) == 0L)
/*     */         try {
/* 107 */           writeChunk();
/* 108 */         } catch (GeneralSecurityException generalSecurityException) {
/* 109 */           throw new IOException(generalSecurityException);
/*     */         }  
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void writeChunk() throws IOException, GeneralSecurityException {
/*     */     boolean bool;
/* 116 */     int i = (int)(this._pos & this.chunkMask);
/*     */ 
/*     */     
/* 119 */     int j = (int)(this._pos >> this.chunkBits);
/*     */     
/* 121 */     if (i == 0) {
/* 122 */       j--;
/* 123 */       i = this.chunkSize;
/* 124 */       bool = false;
/*     */     } else {
/*     */       
/* 127 */       bool = true;
/*     */     } 
/*     */     
/* 130 */     this._cipher = initCipherForBlock(this._cipher, j, bool);
/*     */     
/* 132 */     int k = this._cipher.doFinal(this._chunk, 0, i, this._chunk);
/* 133 */     this.out.write(this._chunk, 0, k);
/*     */   } protected abstract Cipher initCipherForBlock(Cipher paramCipher, int paramInt, boolean paramBoolean) throws GeneralSecurityException;
/*     */   protected abstract void calculateChecksum(File paramFile, int paramInt) throws GeneralSecurityException, IOException;
/*     */   public void close() throws IOException {
/*     */     try {
/* 138 */       writeChunk();
/*     */       
/* 140 */       super.close();
/*     */       
/* 142 */       int i = (int)(this.fileOut.length() + 8L);
/* 143 */       calculateChecksum(this.fileOut, (int)this._pos);
/* 144 */       this.dir.createDocument("EncryptedPackage", i, new EncryptedPackageWriter());
/* 145 */       createEncryptionInfoEntry(this.dir, this.fileOut);
/* 146 */     } catch (GeneralSecurityException generalSecurityException) {
/* 147 */       throw new IOException(generalSecurityException);
/*     */     } 
/*     */   }
/*     */   protected abstract void createEncryptionInfoEntry(DirectoryNode paramDirectoryNode, File paramFile) throws IOException, GeneralSecurityException;
/*     */   
/*     */   private class EncryptedPackageWriter implements POIFSWriterListener { public void processPOIFSWriterEvent(POIFSWriterEvent param1POIFSWriterEvent) {
/*     */       try {
/* 154 */         DocumentOutputStream documentOutputStream = param1POIFSWriterEvent.getStream();
/* 155 */         byte[] arrayOfByte = new byte[ChunkedCipherOutputStream.this.chunkSize];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 161 */         LittleEndian.putLong(arrayOfByte, 0, ChunkedCipherOutputStream.this._pos);
/* 162 */         documentOutputStream.write(arrayOfByte, 0, 8);
/*     */         
/* 164 */         FileInputStream fileInputStream = new FileInputStream(ChunkedCipherOutputStream.this.fileOut);
/*     */         int i;
/* 166 */         while ((i = fileInputStream.read(arrayOfByte)) != -1) {
/* 167 */           documentOutputStream.write(arrayOfByte, 0, i);
/*     */         }
/* 169 */         fileInputStream.close();
/*     */         
/* 171 */         documentOutputStream.close();
/*     */         
/* 173 */         if (!ChunkedCipherOutputStream.this.fileOut.delete()) {
/* 174 */           ChunkedCipherOutputStream.logger.log(7, new Object[] { "Can't delete temporary encryption file: " + ChunkedCipherOutputStream.access$200(this.this$0) });
/*     */         }
/* 176 */       } catch (IOException iOException) {
/* 177 */         throw new EncryptedDocumentException(iOException);
/*     */       } 
/*     */     }
/*     */     
/*     */     private EncryptedPackageWriter() {} }
/*     */ 
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\crypt\ChunkedCipherOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */