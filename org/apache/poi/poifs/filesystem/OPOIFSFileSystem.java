/*     */ package org.apache.poi.poifs.filesystem;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*     */ import org.apache.poi.poifs.common.POIFSConstants;
/*     */ import org.apache.poi.poifs.dev.POIFSViewable;
/*     */ import org.apache.poi.poifs.property.DirectoryProperty;
/*     */ import org.apache.poi.poifs.property.Property;
/*     */ import org.apache.poi.poifs.property.PropertyTable;
/*     */ import org.apache.poi.poifs.storage.BATBlock;
/*     */ import org.apache.poi.poifs.storage.BlockAllocationTableReader;
/*     */ import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
/*     */ import org.apache.poi.poifs.storage.BlockList;
/*     */ import org.apache.poi.poifs.storage.BlockWritable;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ import org.apache.poi.poifs.storage.HeaderBlockWriter;
/*     */ import org.apache.poi.poifs.storage.RawDataBlockList;
/*     */ import org.apache.poi.poifs.storage.SmallBlockTableReader;
/*     */ import org.apache.poi.poifs.storage.SmallBlockTableWriter;
/*     */ import org.apache.poi.util.CloseIgnoringInputStream;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.LongField;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class OPOIFSFileSystem
/*     */   implements POIFSViewable
/*     */ {
/*  65 */   private static final POILogger _logger = POILogFactory.getLogger(OPOIFSFileSystem.class);
/*     */   
/*     */   private PropertyTable _property_table;
/*     */   private List<OPOIFSDocument> _documents;
/*     */   private DirectoryNode _root;
/*     */   
/*     */   public static InputStream createNonClosingInputStream(InputStream paramInputStream) {
/*  72 */     return (InputStream)new CloseIgnoringInputStream(paramInputStream);
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
/*  83 */   private POIFSBigBlockSize bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPOIFSFileSystem() {
/*  91 */     HeaderBlock headerBlock = new HeaderBlock(this.bigBlockSize);
/*  92 */     this._property_table = new PropertyTable(headerBlock);
/*  93 */     this._documents = new ArrayList<OPOIFSDocument>();
/*  94 */     this._root = null;
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
/*     */   public OPOIFSFileSystem(InputStream paramInputStream) throws IOException {
/* 129 */     this(); HeaderBlock headerBlock; RawDataBlockList rawDataBlockList;
/* 130 */     boolean bool = false;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 136 */       headerBlock = new HeaderBlock(paramInputStream);
/* 137 */       this.bigBlockSize = headerBlock.getBigBlockSize();
/*     */ 
/*     */       
/* 140 */       rawDataBlockList = new RawDataBlockList(paramInputStream, this.bigBlockSize);
/* 141 */       bool = true;
/*     */     } finally {
/* 143 */       closeInputStream(paramInputStream, bool);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 149 */     new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), (BlockList)rawDataBlockList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 157 */     PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
/*     */ 
/*     */ 
/*     */     
/* 161 */     processProperties(SmallBlockTableReader.getSmallDocumentBlocks(this.bigBlockSize, rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart()), (BlockList)rawDataBlockList, propertyTable.getRoot().getChildren(), null, headerBlock.getPropertyStart());
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
/* 173 */     getRoot().setStorageClsid(propertyTable.getRoot().getStorageClsid());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void closeInputStream(InputStream paramInputStream, boolean paramBoolean) {
/* 181 */     if (paramInputStream.markSupported() && !(paramInputStream instanceof java.io.ByteArrayInputStream)) {
/* 182 */       String str = "POIFS is closing the supplied input stream of type (" + paramInputStream.getClass().getName() + ") which supports mark/reset.  " + "This will be a problem for the caller if the stream will still be used.  " + "If that is the case the caller should wrap the input stream to avoid this close logic.  " + "This warning is only temporary and will not be present in future versions of POI.";
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 187 */       _logger.log(5, new Object[] { str });
/*     */     } 
/*     */     try {
/* 190 */       paramInputStream.close();
/* 191 */     } catch (IOException iOException) {
/* 192 */       if (paramBoolean) {
/* 193 */         throw new RuntimeException(iOException);
/*     */       }
/*     */ 
/*     */       
/* 197 */       _logger.log(7, new Object[] { "can't close input stream", iOException });
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
/*     */ 
/*     */   
/*     */   public static boolean hasPOIFSHeader(InputStream paramInputStream) throws IOException {
/* 212 */     byte[] arrayOfByte = IOUtils.peekFirst8Bytes(paramInputStream);
/* 213 */     return hasPOIFSHeader(arrayOfByte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean hasPOIFSHeader(byte[] paramArrayOfbyte) {
/* 220 */     LongField longField = new LongField(0, paramArrayOfbyte);
/*     */ 
/*     */     
/* 223 */     return (longField.get() == -2226271756974174256L);
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
/*     */   public DocumentEntry createDocument(InputStream paramInputStream, String paramString) throws IOException {
/* 242 */     return getRoot().createDocument(paramString, paramInputStream);
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
/*     */   public DocumentEntry createDocument(String paramString, int paramInt, POIFSWriterListener paramPOIFSWriterListener) throws IOException {
/* 262 */     return getRoot().createDocument(paramString, paramInt, paramPOIFSWriterListener);
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
/*     */   public DirectoryEntry createDirectory(String paramString) throws IOException {
/* 278 */     return getRoot().createDirectory(paramString);
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
/*     */   public void writeFilesystem(OutputStream paramOutputStream) throws IOException {
/* 295 */     this._property_table.preWrite();
/*     */ 
/*     */     
/* 298 */     SmallBlockTableWriter smallBlockTableWriter = new SmallBlockTableWriter(this.bigBlockSize, this._documents, this._property_table.getRoot());
/*     */ 
/*     */ 
/*     */     
/* 302 */     BlockAllocationTableWriter blockAllocationTableWriter = new BlockAllocationTableWriter(this.bigBlockSize);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 307 */     ArrayList<OPOIFSDocument> arrayList = new ArrayList();
/*     */     
/* 309 */     arrayList.addAll(this._documents);
/* 310 */     arrayList.add(this._property_table);
/* 311 */     arrayList.add(smallBlockTableWriter);
/* 312 */     arrayList.add(smallBlockTableWriter.getSBAT());
/*     */ 
/*     */ 
/*     */     
/* 316 */     Iterator<OPOIFSDocument> iterator = arrayList.iterator();
/*     */     
/* 318 */     while (iterator.hasNext()) {
/*     */       
/* 320 */       BATManaged bATManaged = iterator.next();
/* 321 */       int j = bATManaged.countBlocks();
/*     */       
/* 323 */       if (j != 0)
/*     */       {
/* 325 */         bATManaged.setStartBlock(blockAllocationTableWriter.allocateSpace(j));
/*     */       }
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
/* 338 */     int i = blockAllocationTableWriter.createBlocks();
/*     */ 
/*     */     
/* 341 */     HeaderBlockWriter headerBlockWriter = new HeaderBlockWriter(this.bigBlockSize);
/* 342 */     BATBlock[] arrayOfBATBlock = headerBlockWriter.setBATBlocks(blockAllocationTableWriter.countBlocks(), i);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 347 */     headerBlockWriter.setPropertyStart(this._property_table.getStartBlock());
/*     */ 
/*     */     
/* 350 */     headerBlockWriter.setSBATStart(smallBlockTableWriter.getSBAT().getStartBlock());
/*     */ 
/*     */     
/* 353 */     headerBlockWriter.setSBATBlockCount(smallBlockTableWriter.getSBATBlockCount());
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 360 */     ArrayList<HeaderBlockWriter> arrayList1 = new ArrayList();
/*     */     
/* 362 */     arrayList1.add(headerBlockWriter);
/* 363 */     arrayList1.addAll(this._documents);
/* 364 */     arrayList1.add(this._property_table);
/* 365 */     arrayList1.add(smallBlockTableWriter);
/* 366 */     arrayList1.add(smallBlockTableWriter.getSBAT());
/* 367 */     arrayList1.add(blockAllocationTableWriter);
/* 368 */     for (byte b = 0; b < arrayOfBATBlock.length; b++)
/*     */     {
/* 370 */       arrayList1.add(arrayOfBATBlock[b]);
/*     */     }
/*     */ 
/*     */     
/* 374 */     iterator = (Iterator)arrayList1.iterator();
/* 375 */     while (iterator.hasNext()) {
/*     */       
/* 377 */       BlockWritable blockWritable = iterator.next();
/*     */       
/* 379 */       blockWritable.writeBlocks(paramOutputStream);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 395 */     if (paramArrayOfString.length != 2) {
/*     */       
/* 397 */       System.err.println("two arguments required: input filename and output filename");
/*     */       
/* 399 */       System.exit(1);
/*     */     } 
/* 401 */     FileInputStream fileInputStream = new FileInputStream(paramArrayOfString[0]);
/* 402 */     FileOutputStream fileOutputStream = new FileOutputStream(paramArrayOfString[1]);
/*     */     
/* 404 */     (new OPOIFSFileSystem(fileInputStream)).writeFilesystem(fileOutputStream);
/* 405 */     fileInputStream.close();
/* 406 */     fileOutputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DirectoryNode getRoot() {
/* 417 */     if (this._root == null)
/*     */     {
/* 419 */       this._root = new DirectoryNode((DirectoryProperty)this._property_table.getRoot(), this, null);
/*     */     }
/* 421 */     return this._root;
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
/*     */   public DocumentInputStream createDocumentInputStream(String paramString) throws IOException {
/* 439 */     return getRoot().createDocumentInputStream(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addDocument(OPOIFSDocument paramOPOIFSDocument) {
/* 450 */     this._documents.add(paramOPOIFSDocument);
/* 451 */     this._property_table.addProperty((Property)paramOPOIFSDocument.getDocumentProperty());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void addDirectory(DirectoryProperty paramDirectoryProperty) {
/* 462 */     this._property_table.addProperty((Property)paramDirectoryProperty);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void remove(EntryNode paramEntryNode) {
/* 473 */     this._property_table.removeProperty(paramEntryNode.getProperty());
/* 474 */     if (paramEntryNode.isDocumentEntry())
/*     */     {
/* 476 */       this._documents.remove(((DocumentNode)paramEntryNode).getDocument());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processProperties(BlockList paramBlockList1, BlockList paramBlockList2, Iterator<Property> paramIterator, DirectoryNode paramDirectoryNode, int paramInt) throws IOException {
/* 487 */     while (paramIterator.hasNext()) {
/*     */       
/* 489 */       Property property = paramIterator.next();
/* 490 */       String str = property.getName();
/* 491 */       DirectoryNode directoryNode = (paramDirectoryNode == null) ? getRoot() : paramDirectoryNode;
/*     */ 
/*     */ 
/*     */       
/* 495 */       if (property.isDirectory()) {
/*     */         
/* 497 */         DirectoryNode directoryNode1 = (DirectoryNode)directoryNode.createDirectory(str);
/*     */ 
/*     */         
/* 500 */         directoryNode1.setStorageClsid(property.getStorageClsid());
/*     */         
/* 502 */         processProperties(paramBlockList1, paramBlockList2, ((DirectoryProperty)property).getChildren(), directoryNode1, paramInt);
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/* 509 */       int i = property.getStartBlock();
/* 510 */       int j = property.getSize();
/* 511 */       OPOIFSDocument oPOIFSDocument = null;
/*     */       
/* 513 */       if (property.shouldUseSmallBlocks()) {
/*     */         
/* 515 */         oPOIFSDocument = new OPOIFSDocument(str, paramBlockList1.fetchBlocks(i, paramInt), j);
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 522 */         oPOIFSDocument = new OPOIFSDocument(str, paramBlockList2.fetchBlocks(i, paramInt), j);
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 527 */       directoryNode.createDocument(oPOIFSDocument);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public Object[] getViewableArray() {
/* 543 */     if (preferArray())
/*     */     {
/* 545 */       return getRoot().getViewableArray();
/*     */     }
/* 547 */     return new Object[0];
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
/*     */   public Iterator<Object> getViewableIterator() {
/* 560 */     if (!preferArray())
/*     */     {
/* 562 */       return getRoot().getViewableIterator();
/*     */     }
/* 564 */     return Collections.<Object>emptyList().iterator();
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
/*     */   public boolean preferArray() {
/* 577 */     return getRoot().preferArray();
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
/*     */   public String getShortDescription() {
/* 589 */     return "POIFS FileSystem";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBigBlockSize() {
/* 596 */     return this.bigBlockSize.getBigBlockSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public POIFSBigBlockSize getBigBlockSizeDetails() {
/* 602 */     return this.bigBlockSize;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\OPOIFSFileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */