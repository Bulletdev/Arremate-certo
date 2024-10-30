/*     */ package org.apache.poi.poifs.eventfilesystem;
/*     */ 
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSDocument;
/*     */ import org.apache.poi.poifs.filesystem.POIFSDocumentPath;
/*     */ import org.apache.poi.poifs.property.DirectoryProperty;
/*     */ import org.apache.poi.poifs.property.Property;
/*     */ import org.apache.poi.poifs.property.PropertyTable;
/*     */ import org.apache.poi.poifs.storage.BlockAllocationTableReader;
/*     */ import org.apache.poi.poifs.storage.BlockList;
/*     */ import org.apache.poi.poifs.storage.HeaderBlock;
/*     */ import org.apache.poi.poifs.storage.RawDataBlockList;
/*     */ import org.apache.poi.poifs.storage.SmallBlockTableReader;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POIFSReader
/*     */ {
/*  60 */   private final POIFSReaderRegistry registry = new POIFSReaderRegistry();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean registryClosed = false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(InputStream paramInputStream) throws IOException {
/*  75 */     this.registryClosed = true;
/*     */ 
/*     */     
/*  78 */     HeaderBlock headerBlock = new HeaderBlock(paramInputStream);
/*     */ 
/*     */     
/*  81 */     RawDataBlockList rawDataBlockList = new RawDataBlockList(paramInputStream, headerBlock.getBigBlockSize());
/*     */ 
/*     */ 
/*     */     
/*  85 */     new BlockAllocationTableReader(headerBlock.getBigBlockSize(), headerBlock.getBATCount(), headerBlock.getBATArray(), headerBlock.getXBATCount(), headerBlock.getXBATIndex(), (BlockList)rawDataBlockList);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  93 */     PropertyTable propertyTable = new PropertyTable(headerBlock, rawDataBlockList);
/*     */ 
/*     */ 
/*     */     
/*  97 */     processProperties(SmallBlockTableReader.getSmallDocumentBlocks(headerBlock.getBigBlockSize(), rawDataBlockList, propertyTable.getRoot(), headerBlock.getSBATStart()), (BlockList)rawDataBlockList, propertyTable.getRoot().getChildren(), new POIFSDocumentPath());
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
/*     */   public void registerListener(POIFSReaderListener paramPOIFSReaderListener) {
/* 118 */     if (paramPOIFSReaderListener == null)
/*     */     {
/* 120 */       throw new NullPointerException();
/*     */     }
/* 122 */     if (this.registryClosed)
/*     */     {
/* 124 */       throw new IllegalStateException();
/*     */     }
/* 126 */     this.registry.registerListener(paramPOIFSReaderListener);
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
/*     */   public void registerListener(POIFSReaderListener paramPOIFSReaderListener, String paramString) {
/* 145 */     registerListener(paramPOIFSReaderListener, null, paramString);
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
/*     */   public void registerListener(POIFSReaderListener paramPOIFSReaderListener, POIFSDocumentPath paramPOIFSDocumentPath, String paramString) {
/* 167 */     if (paramPOIFSReaderListener == null || paramString == null || paramString.length() == 0)
/*     */     {
/* 169 */       throw new NullPointerException();
/*     */     }
/* 171 */     if (this.registryClosed)
/*     */     {
/* 173 */       throw new IllegalStateException();
/*     */     }
/* 175 */     this.registry.registerListener(paramPOIFSReaderListener, (paramPOIFSDocumentPath == null) ? new POIFSDocumentPath() : paramPOIFSDocumentPath, paramString);
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
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 191 */     if (paramArrayOfString.length == 0) {
/*     */       
/* 193 */       System.err.println("at least one argument required: input filename(s)");
/*     */       
/* 195 */       System.exit(1);
/*     */     } 
/*     */ 
/*     */     
/* 199 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/* 201 */       POIFSReader pOIFSReader = new POIFSReader();
/* 202 */       SampleListener sampleListener = new SampleListener();
/*     */       
/* 204 */       pOIFSReader.registerListener(sampleListener);
/* 205 */       System.out.println("reading " + paramArrayOfString[b]);
/* 206 */       FileInputStream fileInputStream = new FileInputStream(paramArrayOfString[b]);
/*     */       
/* 208 */       pOIFSReader.read(fileInputStream);
/* 209 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void processProperties(BlockList paramBlockList1, BlockList paramBlockList2, Iterator<Property> paramIterator, POIFSDocumentPath paramPOIFSDocumentPath) throws IOException {
/* 219 */     while (paramIterator.hasNext()) {
/*     */       
/* 221 */       Property property = paramIterator.next();
/* 222 */       String str = property.getName();
/*     */       
/* 224 */       if (property.isDirectory()) {
/*     */         
/* 226 */         POIFSDocumentPath pOIFSDocumentPath = new POIFSDocumentPath(paramPOIFSDocumentPath, new String[] { str });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 232 */         processProperties(paramBlockList1, paramBlockList2, ((DirectoryProperty)property).getChildren(), pOIFSDocumentPath);
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 238 */       int i = property.getStartBlock();
/* 239 */       Iterator<POIFSReaderListener> iterator = this.registry.getListeners(paramPOIFSDocumentPath, str);
/*     */       
/* 241 */       if (iterator.hasNext()) {
/*     */         
/* 243 */         int j = property.getSize();
/* 244 */         OPOIFSDocument oPOIFSDocument = null;
/*     */         
/* 246 */         if (property.shouldUseSmallBlocks()) {
/*     */           
/* 248 */           oPOIFSDocument = new OPOIFSDocument(str, paramBlockList1.fetchBlocks(i, -1), j);
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 254 */           oPOIFSDocument = new OPOIFSDocument(str, paramBlockList2.fetchBlocks(i, -1), j);
/*     */         } 
/*     */ 
/*     */         
/* 258 */         while (iterator.hasNext()) {
/*     */           
/* 260 */           POIFSReaderListener pOIFSReaderListener = iterator.next();
/*     */           
/* 262 */           pOIFSReaderListener.processPOIFSReaderEvent(new POIFSReaderEvent(new DocumentInputStream(oPOIFSDocument), paramPOIFSDocumentPath, str));
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 272 */       if (property.shouldUseSmallBlocks()) {
/*     */         
/* 274 */         paramBlockList1.fetchBlocks(i, -1);
/*     */         
/*     */         continue;
/*     */       } 
/* 278 */       paramBlockList2.fetchBlocks(i, -1);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SampleListener
/*     */     implements POIFSReaderListener
/*     */   {
/*     */     public void processPOIFSReaderEvent(POIFSReaderEvent param1POIFSReaderEvent) {
/* 306 */       DocumentInputStream documentInputStream = param1POIFSReaderEvent.getStream();
/* 307 */       POIFSDocumentPath pOIFSDocumentPath = param1POIFSReaderEvent.getPath();
/* 308 */       String str = param1POIFSReaderEvent.getName();
/*     */ 
/*     */       
/*     */       try {
/* 312 */         byte[] arrayOfByte = new byte[documentInputStream.available()];
/*     */         
/* 314 */         documentInputStream.read(arrayOfByte);
/* 315 */         int i = pOIFSDocumentPath.length();
/*     */         
/* 317 */         for (byte b = 0; b < i; b++)
/*     */         {
/* 319 */           System.out.print("/" + pOIFSDocumentPath.getComponent(b));
/*     */         }
/* 321 */         System.out.println("/" + str + ": " + arrayOfByte.length + " bytes read");
/*     */       
/*     */       }
/* 324 */       catch (IOException iOException) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\poifs\eventfilesystem\POIFSReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */