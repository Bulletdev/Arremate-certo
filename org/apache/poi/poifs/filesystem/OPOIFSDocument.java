/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.poifs.property.DocumentProperty;
/*     */ import org.apache.poi.poifs.property.Property;
/*     */ import org.apache.poi.poifs.storage.BlockWritable;
/*     */ import org.apache.poi.poifs.storage.DataInputBlock;
/*     */ import org.apache.poi.poifs.storage.DocumentBlock;
/*     */ import org.apache.poi.poifs.storage.ListManagedBlock;
/*     */ import org.apache.poi.poifs.storage.RawDataBlock;
/*     */ import org.apache.poi.poifs.storage.SmallDocumentBlock;
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
/*     */ public final class OPOIFSDocument
/*     */   implements POIFSViewable, BATManaged, BlockWritable
/*     */ {
/*  47 */   private static final DocumentBlock[] EMPTY_BIG_BLOCK_ARRAY = new DocumentBlock[0];
/*  48 */   private static final SmallDocumentBlock[] EMPTY_SMALL_BLOCK_ARRAY = new SmallDocumentBlock[0];
/*     */ 
/*     */   
/*     */   private DocumentProperty _property;
/*     */ 
/*     */   
/*     */   private int _size;
/*     */ 
/*     */   
/*     */   private final POIFSBigBlockSize _bigBigBlockSize;
/*     */ 
/*     */   
/*     */   private SmallBlockStore _small_store;
/*     */   
/*     */   private BigBlockStore _big_store;
/*     */ 
/*     */   
/*     */   public OPOIFSDocument(String paramString, RawDataBlock[] paramArrayOfRawDataBlock, int paramInt) throws IOException {
/*  66 */     this._size = paramInt;
/*  67 */     if (paramArrayOfRawDataBlock.length == 0) {
/*  68 */       this._bigBigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
/*     */     } else {
/*  70 */       this._bigBigBlockSize = (paramArrayOfRawDataBlock[0].getBigBlockSize() == 512) ? POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS : POIFSConstants.LARGER_BIG_BLOCK_SIZE_DETAILS;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  76 */     this._big_store = new BigBlockStore(this._bigBigBlockSize, convertRawBlocksToBigBlocks((ListManagedBlock[])paramArrayOfRawDataBlock));
/*  77 */     this._property = new DocumentProperty(paramString, this._size);
/*  78 */     this._small_store = new SmallBlockStore(this._bigBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
/*  79 */     this._property.setDocument(this);
/*     */   }
/*     */ 
/*     */   
/*     */   private static DocumentBlock[] convertRawBlocksToBigBlocks(ListManagedBlock[] paramArrayOfListManagedBlock) throws IOException {
/*  84 */     DocumentBlock[] arrayOfDocumentBlock = new DocumentBlock[paramArrayOfListManagedBlock.length];
/*  85 */     for (byte b = 0; b < arrayOfDocumentBlock.length; b++) {
/*  86 */       arrayOfDocumentBlock[b] = new DocumentBlock((RawDataBlock)paramArrayOfListManagedBlock[b]);
/*     */     }
/*  88 */     return arrayOfDocumentBlock;
/*     */   }
/*     */   private static SmallDocumentBlock[] convertRawBlocksToSmallBlocks(ListManagedBlock[] paramArrayOfListManagedBlock) {
/*  91 */     if (paramArrayOfListManagedBlock instanceof SmallDocumentBlock[]) {
/*  92 */       return (SmallDocumentBlock[])paramArrayOfListManagedBlock;
/*     */     }
/*  94 */     SmallDocumentBlock[] arrayOfSmallDocumentBlock = new SmallDocumentBlock[paramArrayOfListManagedBlock.length];
/*  95 */     System.arraycopy(paramArrayOfListManagedBlock, 0, arrayOfSmallDocumentBlock, 0, paramArrayOfListManagedBlock.length);
/*  96 */     return arrayOfSmallDocumentBlock;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSDocument(String paramString, SmallDocumentBlock[] paramArrayOfSmallDocumentBlock, int paramInt) {
/* 107 */     this._size = paramInt;
/*     */     
/* 109 */     if (paramArrayOfSmallDocumentBlock.length == 0) {
/* 110 */       this._bigBigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
/*     */     } else {
/* 112 */       this._bigBigBlockSize = paramArrayOfSmallDocumentBlock[0].getBigBlockSize();
/*     */     } 
/*     */     
/* 115 */     this._big_store = new BigBlockStore(this._bigBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
/* 116 */     this._property = new DocumentProperty(paramString, this._size);
/* 117 */     this._small_store = new SmallBlockStore(this._bigBigBlockSize, paramArrayOfSmallDocumentBlock);
/* 118 */     this._property.setDocument(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSDocument(String paramString, POIFSBigBlockSize paramPOIFSBigBlockSize, ListManagedBlock[] paramArrayOfListManagedBlock, int paramInt) throws IOException {
/* 129 */     this._size = paramInt;
/* 130 */     this._bigBigBlockSize = paramPOIFSBigBlockSize;
/* 131 */     this._property = new DocumentProperty(paramString, this._size);
/* 132 */     this._property.setDocument(this);
/* 133 */     if (Property.isSmall(this._size)) {
/* 134 */       this._big_store = new BigBlockStore(paramPOIFSBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
/* 135 */       this._small_store = new SmallBlockStore(paramPOIFSBigBlockSize, convertRawBlocksToSmallBlocks(paramArrayOfListManagedBlock));
/*     */     } else {
/* 137 */       this._big_store = new BigBlockStore(paramPOIFSBigBlockSize, convertRawBlocksToBigBlocks(paramArrayOfListManagedBlock));
/* 138 */       this._small_store = new SmallBlockStore(paramPOIFSBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
/*     */     } 
/*     */   }
/*     */   public OPOIFSDocument(String paramString, ListManagedBlock[] paramArrayOfListManagedBlock, int paramInt) throws IOException {
/* 142 */     this(paramString, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, paramArrayOfListManagedBlock, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSDocument(String paramString, POIFSBigBlockSize paramPOIFSBigBlockSize, InputStream paramInputStream) throws IOException {
/*     */     DocumentBlock documentBlock;
/* 152 */     ArrayList<DocumentBlock> arrayList = new ArrayList();
/*     */     
/* 154 */     this._size = 0;
/* 155 */     this._bigBigBlockSize = paramPOIFSBigBlockSize;
/*     */     do {
/* 157 */       documentBlock = new DocumentBlock(paramInputStream, paramPOIFSBigBlockSize);
/* 158 */       int i = documentBlock.size();
/*     */       
/* 160 */       if (i <= 0)
/* 161 */         continue;  arrayList.add(documentBlock);
/* 162 */       this._size += i;
/*     */     }
/* 164 */     while (!documentBlock.partiallyRead());
/*     */ 
/*     */ 
/*     */     
/* 168 */     DocumentBlock[] arrayOfDocumentBlock = arrayList.<DocumentBlock>toArray(new DocumentBlock[arrayList.size()]);
/*     */     
/* 170 */     this._big_store = new BigBlockStore(paramPOIFSBigBlockSize, arrayOfDocumentBlock);
/* 171 */     this._property = new DocumentProperty(paramString, this._size);
/* 172 */     this._property.setDocument(this);
/* 173 */     if (this._property.shouldUseSmallBlocks()) {
/* 174 */       this._small_store = new SmallBlockStore(paramPOIFSBigBlockSize, SmallDocumentBlock.convert(paramPOIFSBigBlockSize, (BlockWritable[])arrayOfDocumentBlock, this._size));
/* 175 */       this._big_store = new BigBlockStore(paramPOIFSBigBlockSize, new DocumentBlock[0]);
/*     */     } else {
/* 177 */       this._small_store = new SmallBlockStore(paramPOIFSBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
/*     */     } 
/*     */   }
/*     */   public OPOIFSDocument(String paramString, InputStream paramInputStream) throws IOException {
/* 181 */     this(paramString, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, paramInputStream);
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
/*     */   public OPOIFSDocument(String paramString, int paramInt, POIFSBigBlockSize paramPOIFSBigBlockSize, POIFSDocumentPath paramPOIFSDocumentPath, POIFSWriterListener paramPOIFSWriterListener) {
/* 193 */     this._size = paramInt;
/* 194 */     this._bigBigBlockSize = paramPOIFSBigBlockSize;
/* 195 */     this._property = new DocumentProperty(paramString, this._size);
/* 196 */     this._property.setDocument(this);
/* 197 */     if (this._property.shouldUseSmallBlocks()) {
/* 198 */       this._small_store = new SmallBlockStore(this._bigBigBlockSize, paramPOIFSDocumentPath, paramString, paramInt, paramPOIFSWriterListener);
/* 199 */       this._big_store = new BigBlockStore(this._bigBigBlockSize, EMPTY_BIG_BLOCK_ARRAY);
/*     */     } else {
/* 201 */       this._small_store = new SmallBlockStore(this._bigBigBlockSize, EMPTY_SMALL_BLOCK_ARRAY);
/* 202 */       this._big_store = new BigBlockStore(this._bigBigBlockSize, paramPOIFSDocumentPath, paramString, paramInt, paramPOIFSWriterListener);
/*     */     } 
/*     */   }
/*     */   public OPOIFSDocument(String paramString, int paramInt, POIFSDocumentPath paramPOIFSDocumentPath, POIFSWriterListener paramPOIFSWriterListener) {
/* 206 */     this(paramString, paramInt, POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS, paramPOIFSDocumentPath, paramPOIFSWriterListener);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SmallDocumentBlock[] getSmallBlocks() {
/* 213 */     return this._small_store.getBlocks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSize() {
/* 220 */     return this._size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void read(byte[] paramArrayOfbyte, int paramInt) {
/* 231 */     int i = paramArrayOfbyte.length;
/*     */     
/* 233 */     DataInputBlock dataInputBlock = getDataInputBlock(paramInt);
/*     */     
/* 235 */     int j = dataInputBlock.available();
/* 236 */     if (j > i) {
/* 237 */       dataInputBlock.readFully(paramArrayOfbyte, 0, i);
/*     */       
/*     */       return;
/*     */     } 
/* 241 */     int k = i;
/* 242 */     int m = 0;
/* 243 */     int n = paramInt;
/* 244 */     while (k > 0) {
/* 245 */       int i1; boolean bool = (k >= j) ? true : false;
/*     */       
/* 247 */       if (bool) {
/* 248 */         i1 = j;
/*     */       } else {
/* 250 */         i1 = k;
/*     */       } 
/* 252 */       dataInputBlock.readFully(paramArrayOfbyte, m, i1);
/* 253 */       k -= i1;
/* 254 */       m += i1;
/* 255 */       n += i1;
/* 256 */       if (bool) {
/* 257 */         if (n == this._size) {
/* 258 */           if (k > 0) {
/* 259 */             throw new IllegalStateException("reached end of document stream unexpectedly");
/*     */           }
/* 261 */           dataInputBlock = null;
/*     */           break;
/*     */         } 
/* 264 */         dataInputBlock = getDataInputBlock(n);
/* 265 */         j = dataInputBlock.available();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DataInputBlock getDataInputBlock(int paramInt) {
/* 274 */     if (paramInt >= this._size) {
/* 275 */       if (paramInt > this._size) {
/* 276 */         throw new RuntimeException("Request for Offset " + paramInt + " doc size is " + this._size);
/*     */       }
/* 278 */       return null;
/*     */     } 
/* 280 */     if (this._property.shouldUseSmallBlocks()) {
/* 281 */       return SmallDocumentBlock.getDataInputBlock(this._small_store.getBlocks(), paramInt);
/*     */     }
/* 283 */     return DocumentBlock.getDataInputBlock(this._big_store.getBlocks(), paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   DocumentProperty getDocumentProperty() {
/* 291 */     return this._property;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void writeBlocks(OutputStream paramOutputStream) throws IOException {
/* 302 */     this._big_store.writeBlocks(paramOutputStream);
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
/*     */   public int countBlocks() {
/* 314 */     return this._big_store.countBlocks();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStartBlock(int paramInt) {
/* 323 */     this._property.setStartBlock(paramInt);
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
/*     */   public Object[] getViewableArray() {
/* 335 */     String str = "<NO DATA>";
/*     */     try {
/*     */       SmallDocumentBlock[] arrayOfSmallDocumentBlock;
/* 338 */       DocumentBlock[] arrayOfDocumentBlock = null;
/*     */       
/* 340 */       if (this._big_store.isValid()) {
/* 341 */         arrayOfDocumentBlock = this._big_store.getBlocks();
/* 342 */       } else if (this._small_store.isValid()) {
/* 343 */         arrayOfSmallDocumentBlock = this._small_store.getBlocks();
/*     */       } 
/* 345 */       if (arrayOfSmallDocumentBlock != null) {
/* 346 */         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 347 */         for (SmallDocumentBlock smallDocumentBlock : arrayOfSmallDocumentBlock) {
/* 348 */           smallDocumentBlock.writeBlocks(byteArrayOutputStream);
/*     */         }
/* 350 */         int i = Math.min(byteArrayOutputStream.size(), this._property.getSize());
/* 351 */         str = HexDump.dump(byteArrayOutputStream.toByteArray(), 0L, 0, i);
/*     */       } 
/* 353 */     } catch (IOException iOException) {
/* 354 */       str = iOException.getMessage();
/*     */     } 
/* 356 */     return (Object[])new String[] { str };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Iterator<Object> getViewableIterator() {
/* 366 */     return Collections.<Object>emptyList().iterator();
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
/* 377 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getShortDescription() {
/* 387 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 389 */     stringBuffer.append("Document: \"").append(this._property.getName()).append("\"");
/* 390 */     stringBuffer.append(" size = ").append(getSize());
/* 391 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class SmallBlockStore
/*     */   {
/*     */     private SmallDocumentBlock[] _smallBlocks;
/*     */     
/*     */     private final POIFSDocumentPath _path;
/*     */     
/*     */     private final String _name;
/*     */     
/*     */     private final int _size;
/*     */     
/*     */     private final POIFSWriterListener _writer;
/*     */     private final POIFSBigBlockSize _bigBlockSize;
/*     */     
/*     */     SmallBlockStore(POIFSBigBlockSize param1POIFSBigBlockSize, SmallDocumentBlock[] param1ArrayOfSmallDocumentBlock) {
/* 409 */       this._bigBlockSize = param1POIFSBigBlockSize;
/* 410 */       this._smallBlocks = (SmallDocumentBlock[])param1ArrayOfSmallDocumentBlock.clone();
/* 411 */       this._path = null;
/* 412 */       this._name = null;
/* 413 */       this._size = -1;
/* 414 */       this._writer = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SmallBlockStore(POIFSBigBlockSize param1POIFSBigBlockSize, POIFSDocumentPath param1POIFSDocumentPath, String param1String, int param1Int, POIFSWriterListener param1POIFSWriterListener) {
/* 427 */       this._bigBlockSize = param1POIFSBigBlockSize;
/* 428 */       this._smallBlocks = new SmallDocumentBlock[0];
/* 429 */       this._path = param1POIFSDocumentPath;
/* 430 */       this._name = param1String;
/* 431 */       this._size = param1Int;
/* 432 */       this._writer = param1POIFSWriterListener;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isValid() {
/* 439 */       return (this._smallBlocks.length > 0 || this._writer != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     SmallDocumentBlock[] getBlocks() {
/* 446 */       if (isValid() && this._writer != null) {
/* 447 */         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._size);
/* 448 */         DocumentOutputStream documentOutputStream = new DocumentOutputStream(byteArrayOutputStream, this._size);
/*     */         
/* 450 */         this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, this._path, this._name, this._size));
/* 451 */         this._smallBlocks = SmallDocumentBlock.convert(this._bigBlockSize, byteArrayOutputStream.toByteArray(), this._size);
/*     */       } 
/* 453 */       return this._smallBlocks;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static final class BigBlockStore
/*     */   {
/*     */     private DocumentBlock[] bigBlocks;
/*     */     
/*     */     private final POIFSDocumentPath _path;
/*     */     
/*     */     private final String _name;
/*     */     
/*     */     private final int _size;
/*     */     private final POIFSWriterListener _writer;
/*     */     private final POIFSBigBlockSize _bigBlockSize;
/*     */     
/*     */     BigBlockStore(POIFSBigBlockSize param1POIFSBigBlockSize, DocumentBlock[] param1ArrayOfDocumentBlock) {
/* 471 */       this._bigBlockSize = param1POIFSBigBlockSize;
/* 472 */       this.bigBlocks = (DocumentBlock[])param1ArrayOfDocumentBlock.clone();
/* 473 */       this._path = null;
/* 474 */       this._name = null;
/* 475 */       this._size = -1;
/* 476 */       this._writer = null;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     BigBlockStore(POIFSBigBlockSize param1POIFSBigBlockSize, POIFSDocumentPath param1POIFSDocumentPath, String param1String, int param1Int, POIFSWriterListener param1POIFSWriterListener) {
/* 489 */       this._bigBlockSize = param1POIFSBigBlockSize;
/* 490 */       this.bigBlocks = new DocumentBlock[0];
/* 491 */       this._path = param1POIFSDocumentPath;
/* 492 */       this._name = param1String;
/* 493 */       this._size = param1Int;
/* 494 */       this._writer = param1POIFSWriterListener;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     boolean isValid() {
/* 501 */       return (this.bigBlocks.length > 0 || this._writer != null);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DocumentBlock[] getBlocks() {
/* 508 */       if (isValid() && this._writer != null) {
/* 509 */         ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(this._size);
/* 510 */         DocumentOutputStream documentOutputStream = new DocumentOutputStream(byteArrayOutputStream, this._size);
/*     */         
/* 512 */         this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, this._path, this._name, this._size));
/* 513 */         this.bigBlocks = DocumentBlock.convert(this._bigBlockSize, byteArrayOutputStream.toByteArray(), this._size);
/*     */       } 
/* 515 */       return this.bigBlocks;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void writeBlocks(OutputStream param1OutputStream) throws IOException {
/* 524 */       if (isValid()) {
/* 525 */         if (this._writer != null) {
/* 526 */           DocumentOutputStream documentOutputStream = new DocumentOutputStream(param1OutputStream, this._size);
/*     */           
/* 528 */           this._writer.processPOIFSWriterEvent(new POIFSWriterEvent(documentOutputStream, this._path, this._name, this._size));
/* 529 */           documentOutputStream.writeFiller(countBlocks() * this._bigBlockSize.getBigBlockSize(), DocumentBlock.getFillByte());
/*     */         } else {
/*     */           
/* 532 */           for (byte b = 0; b < this.bigBlocks.length; b++) {
/* 533 */             this.bigBlocks[b].writeBlocks(param1OutputStream);
/*     */           }
/*     */         } 
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int countBlocks() {
/* 544 */       if (isValid()) {
/* 545 */         if (this._writer == null) {
/* 546 */           return this.bigBlocks.length;
/*     */         }
/* 548 */         return (this._size + this._bigBlockSize.getBigBlockSize() - 1) / this._bigBlockSize.getBigBlockSize();
/*     */       } 
/*     */       
/* 551 */       return 0;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\OPOIFSDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */