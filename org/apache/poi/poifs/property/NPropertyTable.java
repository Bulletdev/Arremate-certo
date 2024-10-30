/*     */ package org.apache.poi.poifs.property;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.filesystem.BlockStore;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSStream;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NPropertyTable
/*     */   extends PropertyTableBase
/*     */ {
/*  41 */   private static final POILogger _logger = POILogFactory.getLogger(NPropertyTable.class);
/*     */   
/*     */   private POIFSBigBlockSize _bigBigBlockSize;
/*     */ 
/*     */   
/*     */   public NPropertyTable(HeaderBlock paramHeaderBlock) {
/*  47 */     super(paramHeaderBlock);
/*  48 */     this._bigBigBlockSize = paramHeaderBlock.getBigBlockSize();
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
/*     */   public NPropertyTable(HeaderBlock paramHeaderBlock, NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*  66 */     super(paramHeaderBlock, buildProperties((new NPOIFSStream((BlockStore)paramNPOIFSFileSystem, paramHeaderBlock.getPropertyStart())).iterator(), paramHeaderBlock.getBigBlockSize()));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  73 */     this._bigBigBlockSize = paramHeaderBlock.getBigBlockSize();
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
/*     */   private static List<Property> buildProperties(Iterator<ByteBuffer> paramIterator, POIFSBigBlockSize paramPOIFSBigBlockSize) throws IOException {
/*  85 */     ArrayList<Property> arrayList = new ArrayList();
/*  86 */     while (paramIterator.hasNext()) {
/*  87 */       byte[] arrayOfByte; ByteBuffer byteBuffer = paramIterator.next();
/*     */ 
/*     */ 
/*     */       
/*  91 */       if (byteBuffer.hasArray() && byteBuffer.arrayOffset() == 0 && (byteBuffer.array()).length == paramPOIFSBigBlockSize.getBigBlockSize()) {
/*     */         
/*  93 */         arrayOfByte = byteBuffer.array();
/*     */       } else {
/*  95 */         arrayOfByte = new byte[paramPOIFSBigBlockSize.getBigBlockSize()];
/*     */         
/*  97 */         int i = arrayOfByte.length;
/*  98 */         if (byteBuffer.remaining() < paramPOIFSBigBlockSize.getBigBlockSize()) {
/*     */ 
/*     */ 
/*     */           
/* 102 */           _logger.log(5, new Object[] { "Short Property Block, ", Integer.valueOf(byteBuffer.remaining()), " bytes instead of the expected " + paramPOIFSBigBlockSize.getBigBlockSize() });
/*     */           
/* 104 */           i = byteBuffer.remaining();
/*     */         } 
/*     */         
/* 107 */         byteBuffer.get(arrayOfByte, 0, i);
/*     */       } 
/*     */       
/* 110 */       PropertyFactory.convertToProperties(arrayOfByte, arrayList);
/*     */     } 
/* 112 */     return arrayList;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int countBlocks() {
/* 122 */     long l = (this._properties.size() * 128);
/* 123 */     int i = this._bigBigBlockSize.getBigBlockSize();
/* 124 */     int j = (int)(l / i);
/* 125 */     if (l % i != 0L) {
/* 126 */       j++;
/*     */     }
/* 128 */     return j;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void preWrite() {
/* 135 */     ArrayList<Property> arrayList = new ArrayList();
/*     */     
/* 137 */     byte b = 0;
/* 138 */     for (Property property : this._properties) {
/*     */       
/* 140 */       if (property == null)
/* 141 */         continue;  property.setIndex(b++);
/* 142 */       arrayList.add(property);
/*     */     } 
/*     */ 
/*     */     
/* 146 */     for (Property property : arrayList) property.preWrite();
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(NPOIFSStream paramNPOIFSStream) throws IOException {
/* 153 */     OutputStream outputStream = paramNPOIFSStream.getOutputStream();
/* 154 */     for (Property property : this._properties) {
/* 155 */       if (property != null) {
/* 156 */         property.writeData(outputStream);
/*     */       }
/*     */     } 
/* 159 */     outputStream.close();
/*     */ 
/*     */     
/* 162 */     if (getStartBlock() != paramNPOIFSStream.getStartBlock())
/* 163 */       setStartBlock(paramNPOIFSStream.getStartBlock()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\property\NPropertyTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */