/*     */ package org.apache.poi.poifs.storage;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
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
/*     */ public class HeaderBlockWriter
/*     */   implements BlockWritable, HeaderBlockConstants
/*     */ {
/*     */   private final HeaderBlock _header_block;
/*     */   
/*     */   public HeaderBlockWriter(POIFSBigBlockSize paramPOIFSBigBlockSize) {
/*  44 */     this._header_block = new HeaderBlock(paramPOIFSBigBlockSize);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HeaderBlockWriter(HeaderBlock paramHeaderBlock) {
/*  53 */     this._header_block = paramHeaderBlock;
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
/*     */   public BATBlock[] setBATBlocks(int paramInt1, int paramInt2) {
/*     */     BATBlock[] arrayOfBATBlock;
/*  72 */     POIFSBigBlockSize pOIFSBigBlockSize = this._header_block.getBigBlockSize();
/*     */     
/*  74 */     this._header_block.setBATCount(paramInt1);
/*     */ 
/*     */     
/*  77 */     int i = Math.min(paramInt1, 109);
/*  78 */     int[] arrayOfInt = new int[i]; int j;
/*  79 */     for (j = 0; j < i; j++) {
/*  80 */       arrayOfInt[j] = paramInt2 + j;
/*     */     }
/*  82 */     this._header_block.setBATArray(arrayOfInt);
/*     */ 
/*     */     
/*  85 */     if (paramInt1 > 109) {
/*     */       
/*  87 */       j = paramInt1 - 109;
/*  88 */       int[] arrayOfInt1 = new int[j];
/*     */       
/*  90 */       for (byte b = 0; b < j; b++)
/*     */       {
/*  92 */         arrayOfInt1[b] = paramInt2 + b + 109;
/*     */       }
/*     */       
/*  95 */       arrayOfBATBlock = BATBlock.createXBATBlocks(pOIFSBigBlockSize, arrayOfInt1, paramInt2 + paramInt1);
/*     */       
/*  97 */       this._header_block.setXBATStart(paramInt2 + paramInt1);
/*     */     }
/*     */     else {
/*     */       
/* 101 */       arrayOfBATBlock = BATBlock.createXBATBlocks(pOIFSBigBlockSize, new int[0], 0);
/* 102 */       this._header_block.setXBATStart(-2);
/*     */     } 
/* 104 */     this._header_block.setXBATCount(arrayOfBATBlock.length);
/* 105 */     return arrayOfBATBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPropertyStart(int paramInt) {
/* 116 */     this._header_block.setPropertyStart(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSBATStart(int paramInt) {
/* 127 */     this._header_block.setSBATStart(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSBATBlockCount(int paramInt) {
/* 137 */     this._header_block.setSBATBlockCount(paramInt);
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
/*     */   static int calculateXBATStorageRequirements(POIFSBigBlockSize paramPOIFSBigBlockSize, int paramInt) {
/* 151 */     return (paramInt > 109) ? BATBlock.calculateXBATStorageRequirements(paramPOIFSBigBlockSize, paramInt - 109) : 0;
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
/*     */ 
/*     */   
/*     */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 171 */     this._header_block.writeData(paramOutputStream);
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
/*     */   public void writeBlock(ByteBuffer paramByteBuffer) throws IOException {
/* 185 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._header_block.getBigBlockSize().getBigBlockSize());
/*     */ 
/*     */     
/* 188 */     this._header_block.writeData(byteArrayOutputStream);
/*     */     
/* 190 */     paramByteBuffer.put(byteArrayOutputStream.toByteArray());
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\storage\HeaderBlockWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */