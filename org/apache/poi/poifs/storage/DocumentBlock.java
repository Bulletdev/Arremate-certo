/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Arrays;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.util.IOUtils;
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
/*     */ public final class DocumentBlock
/*     */   extends BigBlock
/*     */ {
/*     */   private static final byte _default_value = -1;
/*     */   private byte[] _data;
/*     */   private int _bytes_read;
/*     */   
/*     */   public DocumentBlock(RawDataBlock paramRawDataBlock) throws IOException {
/*  50 */     super((paramRawDataBlock.getBigBlockSize() == 512) ? POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS : POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  55 */     this._data = paramRawDataBlock.getData();
/*  56 */     this._bytes_read = this._data.length;
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
/*     */   public DocumentBlock(InputStream paramInputStream, POIFSBigBlockSize paramPOIFSBigBlockSize) throws IOException {
/*  70 */     this(paramPOIFSBigBlockSize);
/*  71 */     int i = IOUtils.readFully(paramInputStream, this._data);
/*     */     
/*  73 */     this._bytes_read = (i == -1) ? 0 : i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DocumentBlock(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  83 */     super(paramPOIFSBigBlockSize);
/*  84 */     this._data = new byte[paramPOIFSBigBlockSize.getBigBlockSize()];
/*  85 */     Arrays.fill(this._data, (byte)-1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int size() {
/*  96 */     return this._bytes_read;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean partiallyRead() {
/* 107 */     return (this._bytes_read != this.bigBlockSize.getBigBlockSize());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static byte getFillByte() {
/* 116 */     return -1;
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static DocumentBlock[] convert(POIFSBigBlockSize paramPOIFSBigBlockSize, byte[] paramArrayOfbyte, int paramInt) {
/* 134 */     DocumentBlock[] arrayOfDocumentBlock = new DocumentBlock[(paramInt + paramPOIFSBigBlockSize.getBigBlockSize() - 1) / paramPOIFSBigBlockSize.getBigBlockSize()];
/*     */     
/* 136 */     int i = 0;
/*     */     
/* 138 */     for (byte b = 0; b < arrayOfDocumentBlock.length; b++) {
/*     */       
/* 140 */       arrayOfDocumentBlock[b] = new DocumentBlock(paramPOIFSBigBlockSize);
/* 141 */       if (i < paramArrayOfbyte.length) {
/*     */         
/* 143 */         int j = Math.min(paramPOIFSBigBlockSize.getBigBlockSize(), paramArrayOfbyte.length - i);
/*     */ 
/*     */         
/* 146 */         System.arraycopy(paramArrayOfbyte, i, (arrayOfDocumentBlock[b])._data, 0, j);
/* 147 */         if (j != paramPOIFSBigBlockSize.getBigBlockSize())
/*     */         {
/* 149 */           Arrays.fill((arrayOfDocumentBlock[b])._data, j, paramPOIFSBigBlockSize.getBigBlockSize(), (byte)-1);
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 156 */         Arrays.fill((arrayOfDocumentBlock[b])._data, (byte)-1);
/*     */       } 
/* 158 */       i += paramPOIFSBigBlockSize.getBigBlockSize();
/*     */     } 
/* 160 */     return arrayOfDocumentBlock;
/*     */   }
/*     */   
/*     */   public static DataInputBlock getDataInputBlock(DocumentBlock[] paramArrayOfDocumentBlock, int paramInt) {
/* 164 */     if (paramArrayOfDocumentBlock == null || paramArrayOfDocumentBlock.length == 0) {
/* 165 */       return null;
/*     */     }
/*     */ 
/*     */     
/* 169 */     POIFSBigBlockSize pOIFSBigBlockSize = (paramArrayOfDocumentBlock[0]).bigBlockSize;
/* 170 */     short s = pOIFSBigBlockSize.getHeaderValue();
/* 171 */     int i = pOIFSBigBlockSize.getBigBlockSize();
/* 172 */     int j = i - 1;
/*     */ 
/*     */     
/* 175 */     int k = paramInt >> s;
/* 176 */     int m = paramInt & j;
/* 177 */     return new DataInputBlock((paramArrayOfDocumentBlock[k])._data, m);
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
/*     */ 
/*     */ 
/*     */   
/*     */   void writeData(OutputStream paramOutputStream) throws IOException {
/* 195 */     doWriteData(paramOutputStream, this._data);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\DocumentBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */