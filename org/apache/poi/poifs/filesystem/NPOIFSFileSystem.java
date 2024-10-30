/*      */ package org.apache.poi.poifs.filesystem;
/*      */ 
/*      */ import java.io.Closeable;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStream;
/*      */ import java.io.PushbackInputStream;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.nio.channels.Channels;
/*      */ import java.nio.channels.FileChannel;
/*      */ import java.nio.channels.ReadableByteChannel;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import org.apache.poi.EmptyFileException;
/*      */ import org.apache.poi.poifs.common.POIFSBigBlockSize;
/*      */ import org.apache.poi.poifs.common.POIFSConstants;
/*      */ import org.apache.poi.poifs.dev.POIFSViewable;
/*      */ import org.apache.poi.poifs.nio.ByteArrayBackedDataSource;
/*      */ import org.apache.poi.poifs.nio.DataSource;
/*      */ import org.apache.poi.poifs.nio.FileBackedDataSource;
/*      */ import org.apache.poi.poifs.property.DirectoryProperty;
/*      */ import org.apache.poi.poifs.property.DocumentProperty;
/*      */ import org.apache.poi.poifs.property.NPropertyTable;
/*      */ import org.apache.poi.poifs.property.Property;
/*      */ import org.apache.poi.poifs.storage.BATBlock;
/*      */ import org.apache.poi.poifs.storage.BlockAllocationTableReader;
/*      */ import org.apache.poi.poifs.storage.BlockAllocationTableWriter;
/*      */ import org.apache.poi.poifs.storage.HeaderBlock;
/*      */ import org.apache.poi.poifs.storage.HeaderBlockWriter;
/*      */ import org.apache.poi.util.CloseIgnoringInputStream;
/*      */ import org.apache.poi.util.IOUtils;
/*      */ import org.apache.poi.util.Internal;
/*      */ import org.apache.poi.util.LongField;
/*      */ import org.apache.poi.util.POILogFactory;
/*      */ import org.apache.poi.util.POILogger;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NPOIFSFileSystem
/*      */   extends BlockStore
/*      */   implements Closeable, POIFSViewable
/*      */ {
/*   72 */   private static final POILogger LOG = POILogFactory.getLogger(NPOIFSFileSystem.class);
/*      */   private NPOIFSMiniStore _mini_store;
/*      */   private NPropertyTable _property_table;
/*      */   private List<BATBlock> _xbat_blocks;
/*      */   
/*      */   public static InputStream createNonClosingInputStream(InputStream paramInputStream) {
/*   78 */     return (InputStream)new CloseIgnoringInputStream(paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private List<BATBlock> _bat_blocks;
/*      */ 
/*      */   
/*      */   private HeaderBlock _header;
/*      */ 
/*      */   
/*      */   private DirectoryNode _root;
/*      */ 
/*      */   
/*      */   private DataSource _data;
/*      */   
/*   94 */   private POIFSBigBlockSize bigBlockSize = POIFSConstants.SMALLER_BIG_BLOCK_SIZE_DETAILS;
/*      */ 
/*      */ 
/*      */   
/*      */   private NPOIFSFileSystem(boolean paramBoolean) {
/*   99 */     this._header = new HeaderBlock(this.bigBlockSize);
/*  100 */     this._property_table = new NPropertyTable(this._header);
/*  101 */     this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), new ArrayList<BATBlock>(), this._header);
/*  102 */     this._xbat_blocks = new ArrayList<BATBlock>();
/*  103 */     this._bat_blocks = new ArrayList<BATBlock>();
/*  104 */     this._root = null;
/*      */     
/*  106 */     if (paramBoolean)
/*      */     {
/*      */       
/*  109 */       this._data = (DataSource)new ByteArrayBackedDataSource(new byte[this.bigBlockSize.getBigBlockSize() * 3]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem() {
/*  118 */     this(true);
/*      */ 
/*      */ 
/*      */     
/*  122 */     this._header.setBATCount(1);
/*  123 */     this._header.setBATArray(new int[] { 1 });
/*  124 */     BATBlock bATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, false);
/*  125 */     bATBlock.setOurBlockIndex(1);
/*  126 */     this._bat_blocks.add(bATBlock);
/*      */     
/*  128 */     setNextBlock(0, -2);
/*  129 */     setNextBlock(1, -3);
/*      */     
/*  131 */     this._property_table.setStartBlock(0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem(File paramFile) throws IOException {
/*  149 */     this(paramFile, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem(File paramFile, boolean paramBoolean) throws IOException {
/*  168 */     this(null, paramFile, paramBoolean, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem(FileChannel paramFileChannel) throws IOException {
/*  187 */     this(paramFileChannel, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem(FileChannel paramFileChannel, boolean paramBoolean) throws IOException {
/*  206 */     this(paramFileChannel, null, paramBoolean, false);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private NPOIFSFileSystem(FileChannel paramFileChannel, File paramFile, boolean paramBoolean1, boolean paramBoolean2) throws IOException {
/*  212 */     this(false);
/*      */ 
/*      */     
/*      */     try {
/*  216 */       if (paramFile != null) {
/*  217 */         if (paramFile.length() == 0L) {
/*  218 */           throw new EmptyFileException();
/*      */         }
/*  220 */         FileBackedDataSource fileBackedDataSource = new FileBackedDataSource(paramFile, paramBoolean1);
/*  221 */         paramFileChannel = fileBackedDataSource.getChannel();
/*  222 */         this._data = (DataSource)fileBackedDataSource;
/*      */       } else {
/*  224 */         this._data = (DataSource)new FileBackedDataSource(paramFileChannel, paramBoolean1);
/*      */       } 
/*      */ 
/*      */       
/*  228 */       ByteBuffer byteBuffer = ByteBuffer.allocate(512);
/*  229 */       IOUtils.readFully(paramFileChannel, byteBuffer);
/*      */ 
/*      */       
/*  232 */       this._header = new HeaderBlock(byteBuffer);
/*      */ 
/*      */       
/*  235 */       readCoreContents();
/*  236 */     } catch (IOException iOException) {
/*      */ 
/*      */       
/*  239 */       if (paramBoolean2 && paramFileChannel != null) {
/*  240 */         paramFileChannel.close();
/*  241 */         paramFileChannel = null;
/*      */       } 
/*  243 */       throw iOException;
/*  244 */     } catch (RuntimeException runtimeException) {
/*      */ 
/*      */ 
/*      */       
/*  248 */       if (paramBoolean2 && paramFileChannel != null) {
/*  249 */         paramFileChannel.close();
/*  250 */         paramFileChannel = null;
/*      */       } 
/*  252 */       throw runtimeException;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSFileSystem(InputStream paramInputStream) throws IOException {
/*  288 */     this(false);
/*      */     
/*  290 */     ReadableByteChannel readableByteChannel = null;
/*  291 */     boolean bool = false;
/*      */ 
/*      */     
/*      */     try {
/*  295 */       readableByteChannel = Channels.newChannel(paramInputStream);
/*      */ 
/*      */       
/*  298 */       ByteBuffer byteBuffer1 = ByteBuffer.allocate(512);
/*  299 */       IOUtils.readFully(readableByteChannel, byteBuffer1);
/*      */ 
/*      */       
/*  302 */       this._header = new HeaderBlock(byteBuffer1);
/*      */ 
/*      */       
/*  305 */       BlockAllocationTableReader.sanityCheckBlockCount(this._header.getBATCount());
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  310 */       long l = BATBlock.calculateMaximumSize(this._header);
/*  311 */       if (l > 2147483647L) {
/*  312 */         throw new IllegalArgumentException("Unable read a >2gb file via an InputStream");
/*      */       }
/*  314 */       ByteBuffer byteBuffer2 = ByteBuffer.allocate((int)l);
/*      */ 
/*      */       
/*  317 */       byteBuffer1.position(0);
/*  318 */       byteBuffer2.put(byteBuffer1);
/*  319 */       byteBuffer2.position(byteBuffer1.capacity());
/*      */ 
/*      */       
/*  322 */       IOUtils.readFully(readableByteChannel, byteBuffer2);
/*  323 */       bool = true;
/*      */ 
/*      */       
/*  326 */       this._data = (DataSource)new ByteArrayBackedDataSource(byteBuffer2.array(), byteBuffer2.position());
/*      */     } finally {
/*      */       
/*  329 */       if (readableByteChannel != null)
/*  330 */         readableByteChannel.close(); 
/*  331 */       closeInputStream(paramInputStream, bool);
/*      */     } 
/*      */ 
/*      */     
/*  335 */     readCoreContents();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void closeInputStream(InputStream paramInputStream, boolean paramBoolean) {
/*      */     try {
/*  343 */       paramInputStream.close();
/*  344 */     } catch (IOException iOException) {
/*  345 */       if (paramBoolean) {
/*  346 */         throw new RuntimeException(iOException);
/*      */       }
/*      */ 
/*      */       
/*  350 */       LOG.log(7, new Object[] { "can't close input stream", iOException });
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean hasPOIFSHeader(InputStream paramInputStream) throws IOException {
/*  369 */     paramInputStream.mark(8);
/*      */     
/*  371 */     byte[] arrayOfByte = new byte[8];
/*  372 */     int i = IOUtils.readFully(paramInputStream, arrayOfByte);
/*  373 */     LongField longField = new LongField(0, arrayOfByte);
/*      */ 
/*      */     
/*  376 */     if (paramInputStream instanceof PushbackInputStream) {
/*  377 */       PushbackInputStream pushbackInputStream = (PushbackInputStream)paramInputStream;
/*  378 */       pushbackInputStream.unread(arrayOfByte, 0, i);
/*      */     } else {
/*  380 */       paramInputStream.reset();
/*      */     } 
/*      */ 
/*      */     
/*  384 */     return (longField.get() == -2226271756974174256L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean hasPOIFSHeader(byte[] paramArrayOfbyte) {
/*  392 */     LongField longField = new LongField(0, paramArrayOfbyte);
/*  393 */     return (longField.get() == -2226271756974174256L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readCoreContents() throws IOException {
/*  403 */     this.bigBlockSize = this._header.getBigBlockSize();
/*      */ 
/*      */ 
/*      */     
/*  407 */     BlockStore.ChainLoopDetector chainLoopDetector = getChainLoopDetector();
/*      */ 
/*      */     
/*  410 */     for (int k : this._header.getBATArray()) {
/*  411 */       readBAT(k, chainLoopDetector);
/*      */     }
/*      */ 
/*      */     
/*  415 */     int i = this._header.getBATCount() - (this._header.getBATArray()).length;
/*      */ 
/*      */ 
/*      */     
/*  419 */     int j = this._header.getXBATIndex();
/*  420 */     for (byte b1 = 0; b1 < this._header.getXBATCount(); b1++) {
/*  421 */       chainLoopDetector.claim(j);
/*  422 */       ByteBuffer byteBuffer = getBlockAt(j);
/*  423 */       BATBlock bATBlock = BATBlock.createBATBlock(this.bigBlockSize, byteBuffer);
/*  424 */       bATBlock.setOurBlockIndex(j);
/*  425 */       j = bATBlock.getValueAt(this.bigBlockSize.getXBATEntriesPerBlock());
/*  426 */       this._xbat_blocks.add(bATBlock);
/*      */ 
/*      */       
/*  429 */       int k = Math.min(i, this.bigBlockSize.getXBATEntriesPerBlock());
/*  430 */       for (byte b = 0; b < k; b++) {
/*  431 */         int m = bATBlock.getValueAt(b);
/*  432 */         if (m == -1 || m == -2)
/*  433 */           break;  readBAT(m, chainLoopDetector);
/*      */       } 
/*  435 */       i -= k;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  440 */     this._property_table = new NPropertyTable(this._header, this);
/*      */ 
/*      */ 
/*      */     
/*  444 */     ArrayList<BATBlock> arrayList = new ArrayList();
/*  445 */     this._mini_store = new NPOIFSMiniStore(this, this._property_table.getRoot(), arrayList, this._header);
/*  446 */     j = this._header.getSBATStart();
/*  447 */     for (byte b2 = 0; b2 < this._header.getSBATCount() && j != -2; b2++) {
/*  448 */       chainLoopDetector.claim(j);
/*  449 */       ByteBuffer byteBuffer = getBlockAt(j);
/*  450 */       BATBlock bATBlock = BATBlock.createBATBlock(this.bigBlockSize, byteBuffer);
/*  451 */       bATBlock.setOurBlockIndex(j);
/*  452 */       arrayList.add(bATBlock);
/*  453 */       j = getNextBlock(j);
/*      */     } 
/*      */   }
/*      */   private void readBAT(int paramInt, BlockStore.ChainLoopDetector paramChainLoopDetector) throws IOException {
/*  457 */     paramChainLoopDetector.claim(paramInt);
/*  458 */     ByteBuffer byteBuffer = getBlockAt(paramInt);
/*  459 */     BATBlock bATBlock = BATBlock.createBATBlock(this.bigBlockSize, byteBuffer);
/*  460 */     bATBlock.setOurBlockIndex(paramInt);
/*  461 */     this._bat_blocks.add(bATBlock);
/*      */   }
/*      */   
/*      */   private BATBlock createBAT(int paramInt, boolean paramBoolean) throws IOException {
/*  465 */     BATBlock bATBlock = BATBlock.createEmptyBATBlock(this.bigBlockSize, !paramBoolean);
/*  466 */     bATBlock.setOurBlockIndex(paramInt);
/*      */     
/*  468 */     ByteBuffer byteBuffer = ByteBuffer.allocate(this.bigBlockSize.getBigBlockSize());
/*  469 */     int i = (1 + paramInt) * this.bigBlockSize.getBigBlockSize();
/*  470 */     this._data.write(byteBuffer, i);
/*      */     
/*  472 */     return bATBlock;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ByteBuffer getBlockAt(int paramInt) throws IOException {
/*  481 */     long l1 = (paramInt + 1);
/*  482 */     long l2 = l1 * this.bigBlockSize.getBigBlockSize();
/*      */     try {
/*  484 */       return this._data.read(this.bigBlockSize.getBigBlockSize(), l2);
/*  485 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException1) {
/*  486 */       IndexOutOfBoundsException indexOutOfBoundsException2 = new IndexOutOfBoundsException("Block " + paramInt + " not found");
/*  487 */       indexOutOfBoundsException2.initCause(indexOutOfBoundsException1);
/*  488 */       throw indexOutOfBoundsException2;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected ByteBuffer createBlockIfNeeded(int paramInt) throws IOException {
/*      */     try {
/*  499 */       return getBlockAt(paramInt);
/*  500 */     } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
/*      */       
/*  502 */       long l = ((paramInt + 1) * this.bigBlockSize.getBigBlockSize());
/*      */       
/*  504 */       ByteBuffer byteBuffer = ByteBuffer.allocate(getBigBlockSize());
/*  505 */       this._data.write(byteBuffer, l);
/*      */       
/*  507 */       return getBlockAt(paramInt);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected BATBlock.BATBlockAndIndex getBATBlockAndIndex(int paramInt) {
/*  517 */     return BATBlock.getBATBlockAndIndex(paramInt, this._header, this._bat_blocks);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getNextBlock(int paramInt) {
/*  527 */     BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(paramInt);
/*  528 */     return bATBlockAndIndex.getBlock().getValueAt(bATBlockAndIndex.getIndex());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setNextBlock(int paramInt1, int paramInt2) {
/*  536 */     BATBlock.BATBlockAndIndex bATBlockAndIndex = getBATBlockAndIndex(paramInt1);
/*  537 */     bATBlockAndIndex.getBlock().setValueAt(bATBlockAndIndex.getIndex(), paramInt2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected int getFreeBlock() throws IOException {
/*  549 */     int i = this.bigBlockSize.getBATEntriesPerBlock();
/*      */ 
/*      */     
/*  552 */     int j = 0;
/*  553 */     for (BATBlock bATBlock1 : this._bat_blocks) {
/*  554 */       if (bATBlock1.hasFreeSectors())
/*      */       {
/*  556 */         for (byte b = 0; b < i; b++) {
/*  557 */           int k = bATBlock1.getValueAt(b);
/*  558 */           if (k == -1)
/*      */           {
/*  560 */             return j + b;
/*      */           }
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  566 */       j += i;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  571 */     BATBlock bATBlock = createBAT(j, true);
/*  572 */     bATBlock.setValueAt(0, -3);
/*  573 */     this._bat_blocks.add(bATBlock);
/*      */ 
/*      */     
/*  576 */     if (this._header.getBATCount() >= 109) {
/*      */       
/*  578 */       BATBlock bATBlock1 = null;
/*  579 */       for (BATBlock bATBlock2 : this._xbat_blocks) {
/*  580 */         if (bATBlock2.hasFreeSectors()) {
/*  581 */           bATBlock1 = bATBlock2;
/*      */           break;
/*      */         } 
/*      */       } 
/*  585 */       if (bATBlock1 == null) {
/*      */         
/*  587 */         bATBlock1 = createBAT(j + 1, false);
/*      */         
/*  589 */         bATBlock1.setValueAt(0, j);
/*      */         
/*  591 */         bATBlock.setValueAt(1, -4);
/*      */ 
/*      */         
/*  594 */         j++;
/*      */ 
/*      */         
/*  597 */         if (this._xbat_blocks.size() == 0) {
/*  598 */           this._header.setXBATStart(j);
/*      */         } else {
/*  600 */           ((BATBlock)this._xbat_blocks.get(this._xbat_blocks.size() - 1)).setValueAt(this.bigBlockSize.getXBATEntriesPerBlock(), j);
/*      */         } 
/*      */ 
/*      */         
/*  604 */         this._xbat_blocks.add(bATBlock1);
/*  605 */         this._header.setXBATCount(this._xbat_blocks.size());
/*      */       } else {
/*      */         
/*  608 */         for (byte b = 0; b < this.bigBlockSize.getXBATEntriesPerBlock(); b++) {
/*  609 */           if (bATBlock1.getValueAt(b) == -1) {
/*  610 */             bATBlock1.setValueAt(b, j);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } else {
/*  617 */       int[] arrayOfInt = new int[this._header.getBATCount() + 1];
/*  618 */       System.arraycopy(this._header.getBATArray(), 0, arrayOfInt, 0, arrayOfInt.length - 1);
/*  619 */       arrayOfInt[arrayOfInt.length - 1] = j;
/*  620 */       this._header.setBATArray(arrayOfInt);
/*      */     } 
/*  622 */     this._header.setBATCount(this._bat_blocks.size());
/*      */ 
/*      */     
/*  625 */     return j + 1;
/*      */   }
/*      */   
/*      */   protected long size() throws IOException {
/*  629 */     return this._data.size();
/*      */   }
/*      */ 
/*      */   
/*      */   protected BlockStore.ChainLoopDetector getChainLoopDetector() throws IOException {
/*  634 */     return new BlockStore.ChainLoopDetector(this, this._data.size());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   NPropertyTable _get_property_table() {
/*  642 */     return this._property_table;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public NPOIFSMiniStore getMiniStore() {
/*  650 */     return this._mini_store;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addDocument(NPOIFSDocument paramNPOIFSDocument) {
/*  660 */     this._property_table.addProperty((Property)paramNPOIFSDocument.getDocumentProperty());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addDirectory(DirectoryProperty paramDirectoryProperty) {
/*  670 */     this._property_table.addProperty((Property)paramDirectoryProperty);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentEntry createDocument(InputStream paramInputStream, String paramString) throws IOException {
/*  689 */     return getRoot().createDocument(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentEntry createDocument(String paramString, int paramInt, POIFSWriterListener paramPOIFSWriterListener) throws IOException {
/*  709 */     return getRoot().createDocument(paramString, paramInt, paramPOIFSWriterListener);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DirectoryEntry createDirectory(String paramString) throws IOException {
/*  725 */     return getRoot().createDirectory(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentEntry createOrUpdateDocument(InputStream paramInputStream, String paramString) throws IOException {
/*  745 */     return getRoot().createOrUpdateDocument(paramString, paramInputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isInPlaceWriteable() {
/*  755 */     if (this._data instanceof FileBackedDataSource && (
/*  756 */       (FileBackedDataSource)this._data).isWriteable()) {
/*  757 */       return true;
/*      */     }
/*      */     
/*  760 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeFilesystem() throws IOException {
/*  772 */     if (this._data instanceof FileBackedDataSource) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  780 */       if (!((FileBackedDataSource)this._data).isWriteable()) {
/*  781 */         throw new IllegalArgumentException("POIFS opened in read only mode, so writeFilesystem() may not be called. Open the FileSystem in read-write mode first");
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  786 */       syncWithDataSource();
/*      */       return;
/*      */     } 
/*      */     throw new IllegalArgumentException("POIFS opened from an inputstream, so writeFilesystem() may not be called. Use writeFilesystem(OutputStream) instead");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void writeFilesystem(OutputStream paramOutputStream) throws IOException {
/*  802 */     syncWithDataSource();
/*      */ 
/*      */     
/*  805 */     this._data.copyTo(paramOutputStream);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void syncWithDataSource() throws IOException {
/*  815 */     this._mini_store.syncWithDataSource();
/*      */ 
/*      */     
/*  818 */     NPOIFSStream nPOIFSStream = new NPOIFSStream(this, this._header.getPropertyStart());
/*  819 */     this._property_table.preWrite();
/*  820 */     this._property_table.write(nPOIFSStream);
/*      */ 
/*      */ 
/*      */     
/*  824 */     HeaderBlockWriter headerBlockWriter = new HeaderBlockWriter(this._header);
/*  825 */     headerBlockWriter.writeBlock(getBlockAt(-1));
/*      */ 
/*      */     
/*  828 */     for (BATBlock bATBlock : this._bat_blocks) {
/*  829 */       ByteBuffer byteBuffer = getBlockAt(bATBlock.getOurBlockIndex());
/*  830 */       BlockAllocationTableWriter.writeBlock(bATBlock, byteBuffer);
/*      */     } 
/*      */     
/*  833 */     for (BATBlock bATBlock : this._xbat_blocks) {
/*  834 */       ByteBuffer byteBuffer = getBlockAt(bATBlock.getOurBlockIndex());
/*  835 */       BlockAllocationTableWriter.writeBlock(bATBlock, byteBuffer);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void close() throws IOException {
/*  845 */     this._data.close();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void main(String[] paramArrayOfString) throws IOException {
/*  860 */     if (paramArrayOfString.length != 2) {
/*      */       
/*  862 */       System.err.println("two arguments required: input filename and output filename");
/*      */       
/*  864 */       System.exit(1);
/*      */     } 
/*  866 */     FileInputStream fileInputStream = new FileInputStream(paramArrayOfString[0]);
/*      */     try {
/*  868 */       FileOutputStream fileOutputStream = new FileOutputStream(paramArrayOfString[1]);
/*      */       try {
/*  870 */         NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(fileInputStream);
/*      */         try {
/*  872 */           nPOIFSFileSystem.writeFilesystem(fileOutputStream);
/*      */         } finally {
/*  874 */           nPOIFSFileSystem.close();
/*      */         } 
/*      */       } finally {
/*  877 */         fileOutputStream.close();
/*      */       } 
/*      */     } finally {
/*  880 */       fileInputStream.close();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DirectoryNode getRoot() {
/*  891 */     if (this._root == null) {
/*  892 */       this._root = new DirectoryNode((DirectoryProperty)this._property_table.getRoot(), this, null);
/*      */     }
/*  894 */     return this._root;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public DocumentInputStream createDocumentInputStream(String paramString) throws IOException {
/*  912 */     return getRoot().createDocumentInputStream(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void remove(EntryNode paramEntryNode) throws IOException {
/*  923 */     if (paramEntryNode instanceof DocumentEntry) {
/*  924 */       NPOIFSDocument nPOIFSDocument = new NPOIFSDocument((DocumentProperty)paramEntryNode.getProperty(), this);
/*  925 */       nPOIFSDocument.free();
/*      */     } 
/*      */ 
/*      */     
/*  929 */     this._property_table.removeProperty(paramEntryNode.getProperty());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object[] getViewableArray() {
/*  943 */     if (preferArray())
/*      */     {
/*  945 */       return getRoot().getViewableArray();
/*      */     }
/*  947 */     return new Object[0];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Iterator<Object> getViewableIterator() {
/*  960 */     if (!preferArray())
/*      */     {
/*  962 */       return getRoot().getViewableIterator();
/*      */     }
/*  964 */     return Collections.<Object>emptyList().iterator();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean preferArray() {
/*  977 */     return getRoot().preferArray();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getShortDescription() {
/*  989 */     return "POIFS FileSystem";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBigBlockSize() {
/*  998 */     return this.bigBlockSize.getBigBlockSize();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public POIFSBigBlockSize getBigBlockSizeDetails() {
/* 1005 */     return this.bigBlockSize;
/*      */   }
/*      */ 
/*      */   
/*      */   protected int getBlockStoreBlockSize() {
/* 1010 */     return getBigBlockSize();
/*      */   }
/*      */   
/*      */   @Internal
/*      */   public NPropertyTable getPropertyTable() {
/* 1015 */     return this._property_table;
/*      */   }
/*      */   
/*      */   @Internal
/*      */   public HeaderBlock getHeaderBlock() {
/* 1020 */     return this._header;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\filesystem\NPOIFSFileSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */