/*     */ package org.apache.poi.extractor;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import org.apache.poi.POIOLE2TextExtractor;
/*     */ import org.apache.poi.POITextExtractor;
/*     */ import org.apache.poi.POIXMLTextExtractor;
/*     */ import org.apache.poi.hsmf.MAPIMessage;
/*     */ import org.apache.poi.hsmf.datatypes.AttachmentChunks;
/*     */ import org.apache.poi.hsmf.extractor.OutlookTextExtactor;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
/*     */ import org.apache.poi.poifs.filesystem.Entry;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.NotOLE2FileException;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.util.NotImplemented;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ import org.apache.poi.xdgf.extractor.XDGFVisioExtractor;
/*     */ import org.apache.poi.xslf.extractor.XSLFPowerPointExtractor;
/*     */ import org.apache.poi.xslf.usermodel.XSLFRelation;
/*     */ import org.apache.poi.xslf.usermodel.XSLFSlideShow;
/*     */ import org.apache.poi.xssf.extractor.XSSFEventBasedExcelExtractor;
/*     */ import org.apache.poi.xssf.extractor.XSSFExcelExtractor;
/*     */ import org.apache.poi.xssf.usermodel.XSSFRelation;
/*     */ import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
/*     */ import org.apache.poi.xwpf.usermodel.XWPFRelation;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExtractorFactory
/*     */ {
/*  78 */   private static final POILogger logger = POILogFactory.getLogger(ExtractorFactory.class);
/*     */ 
/*     */   
/*     */   public static final String CORE_DOCUMENT_REL = "http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument";
/*     */ 
/*     */   
/*     */   protected static final String VISIO_DOCUMENT_REL = "http://schemas.microsoft.com/visio/2010/relationships/document";
/*     */   
/*     */   protected static final String STRICT_DOCUMENT_REL = "http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument";
/*     */ 
/*     */   
/*     */   public static boolean getThreadPrefersEventExtractors() {
/*  90 */     return OLE2ExtractorFactory.getThreadPrefersEventExtractors();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Boolean getAllThreadsPreferEventExtractors() {
/*  99 */     return OLE2ExtractorFactory.getAllThreadsPreferEventExtractors();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setThreadPrefersEventExtractors(boolean paramBoolean) {
/* 107 */     OLE2ExtractorFactory.setThreadPrefersEventExtractors(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setAllThreadsPreferEventExtractors(Boolean paramBoolean) {
/* 115 */     OLE2ExtractorFactory.setAllThreadsPreferEventExtractors(paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static boolean getPreferEventExtractor() {
/* 123 */     return OLE2ExtractorFactory.getPreferEventExtractor();
/*     */   }
/*     */   
/*     */   public static POITextExtractor createExtractor(File paramFile) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
/* 127 */     NPOIFSFileSystem nPOIFSFileSystem = null;
/*     */     try {
/* 129 */       nPOIFSFileSystem = new NPOIFSFileSystem(paramFile);
/* 130 */       POIOLE2TextExtractor pOIOLE2TextExtractor = createExtractor(nPOIFSFileSystem);
/* 131 */       pOIOLE2TextExtractor.setFilesystem((Closeable)nPOIFSFileSystem);
/* 132 */       return (POITextExtractor)pOIOLE2TextExtractor;
/*     */     }
/* 134 */     catch (OfficeXmlFileException officeXmlFileException) {
/*     */       
/* 136 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 137 */       return (POITextExtractor)createExtractor(OPCPackage.open(paramFile.toString(), PackageAccess.READ));
/*     */     }
/* 139 */     catch (NotOLE2FileException notOLE2FileException) {
/*     */       
/* 141 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 142 */       throw new IllegalArgumentException("Your File was neither an OLE2 file, nor an OOXML file");
/*     */     }
/* 144 */     catch (OpenXML4JException openXML4JException) {
/*     */       
/* 146 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 147 */       throw openXML4JException;
/*     */     }
/* 149 */     catch (XmlException xmlException) {
/*     */       
/* 151 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 152 */       throw xmlException;
/*     */     }
/* 154 */     catch (IOException iOException) {
/*     */       
/* 156 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 157 */       throw iOException;
/*     */     }
/* 159 */     catch (RuntimeException runtimeException) {
/*     */       
/* 161 */       IOUtils.closeQuietly((Closeable)nPOIFSFileSystem);
/* 162 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static POITextExtractor createExtractor(InputStream paramInputStream) throws IOException, InvalidFormatException, OpenXML4JException, XmlException {
/* 169 */     if (!paramInputStream.markSupported()) {
/* 170 */       paramInputStream = new PushbackInputStream(paramInputStream, 8);
/*     */     }
/*     */     
/* 173 */     if (NPOIFSFileSystem.hasPOIFSHeader(paramInputStream)) {
/* 174 */       return (POITextExtractor)createExtractor(new NPOIFSFileSystem(paramInputStream));
/*     */     }
/* 176 */     if (DocumentFactoryHelper.hasOOXMLHeader(paramInputStream)) {
/* 177 */       return (POITextExtractor)createExtractor(OPCPackage.open(paramInputStream));
/*     */     }
/* 179 */     throw new IllegalArgumentException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
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
/*     */   public static POIXMLTextExtractor createExtractor(OPCPackage paramOPCPackage) throws IOException, OpenXML4JException, XmlException {
/*     */     try {
/* 196 */       PackageRelationshipCollection packageRelationshipCollection = paramOPCPackage.getRelationshipsByType("http://schemas.openxmlformats.org/officeDocument/2006/relationships/officeDocument");
/*     */ 
/*     */       
/* 199 */       if (packageRelationshipCollection.size() == 0)
/*     */       {
/* 201 */         packageRelationshipCollection = paramOPCPackage.getRelationshipsByType("http://purl.oclc.org/ooxml/officeDocument/relationships/officeDocument");
/*     */       }
/* 203 */       if (packageRelationshipCollection.size() == 0) {
/*     */         
/* 205 */         packageRelationshipCollection = paramOPCPackage.getRelationshipsByType("http://schemas.microsoft.com/visio/2010/relationships/document");
/* 206 */         if (packageRelationshipCollection.size() == 1) {
/* 207 */           return (POIXMLTextExtractor)new XDGFVisioExtractor(paramOPCPackage);
/*     */         }
/*     */       } 
/*     */       
/* 211 */       if (packageRelationshipCollection.size() != 1) {
/* 212 */         throw new IllegalArgumentException("Invalid OOXML Package received - expected 1 core document, found " + packageRelationshipCollection.size());
/*     */       }
/*     */ 
/*     */       
/* 216 */       PackagePart packagePart = paramOPCPackage.getPart(packageRelationshipCollection.getRelationship(0));
/* 217 */       String str = packagePart.getContentType();
/*     */ 
/*     */       
/* 220 */       for (XSSFRelation xSSFRelation : XSSFExcelExtractor.SUPPORTED_TYPES) {
/* 221 */         if (xSSFRelation.getContentType().equals(str)) {
/* 222 */           if (getPreferEventExtractor()) {
/* 223 */             return (POIXMLTextExtractor)new XSSFEventBasedExcelExtractor(paramOPCPackage);
/*     */           }
/* 225 */           return (POIXMLTextExtractor)new XSSFExcelExtractor(paramOPCPackage);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 230 */       for (XWPFRelation xWPFRelation : XWPFWordExtractor.SUPPORTED_TYPES) {
/* 231 */         if (xWPFRelation.getContentType().equals(str)) {
/* 232 */           return (POIXMLTextExtractor)new XWPFWordExtractor(paramOPCPackage);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 237 */       for (XSLFRelation xSLFRelation : XSLFPowerPointExtractor.SUPPORTED_TYPES) {
/* 238 */         if (xSLFRelation.getContentType().equals(str)) {
/* 239 */           return (POIXMLTextExtractor)new XSLFPowerPointExtractor(paramOPCPackage);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 244 */       if (XSLFRelation.THEME_MANAGER.getContentType().equals(str)) {
/* 245 */         return (POIXMLTextExtractor)new XSLFPowerPointExtractor(new XSLFSlideShow(paramOPCPackage));
/*     */       }
/*     */       
/* 248 */       throw new IllegalArgumentException("No supported documents found in the OOXML package (found " + str + ")");
/*     */     }
/* 250 */     catch (IOException iOException) {
/*     */ 
/*     */       
/* 253 */       paramOPCPackage.revert();
/* 254 */       throw iOException;
/* 255 */     } catch (OpenXML4JException openXML4JException) {
/*     */ 
/*     */       
/* 258 */       paramOPCPackage.revert();
/* 259 */       throw openXML4JException;
/* 260 */     } catch (XmlException xmlException) {
/*     */ 
/*     */       
/* 263 */       paramOPCPackage.revert();
/* 264 */       throw xmlException;
/* 265 */     } catch (RuntimeException runtimeException) {
/*     */ 
/*     */       
/* 268 */       paramOPCPackage.revert();
/* 269 */       throw runtimeException;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static POIOLE2TextExtractor createExtractor(POIFSFileSystem paramPOIFSFileSystem) throws IOException, OpenXML4JException, XmlException {
/* 274 */     return OLE2ExtractorFactory.createExtractor(paramPOIFSFileSystem);
/*     */   }
/*     */   public static POIOLE2TextExtractor createExtractor(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException, OpenXML4JException, XmlException {
/* 277 */     return OLE2ExtractorFactory.createExtractor(paramNPOIFSFileSystem);
/*     */   }
/*     */   public static POIOLE2TextExtractor createExtractor(OPOIFSFileSystem paramOPOIFSFileSystem) throws IOException, OpenXML4JException, XmlException {
/* 280 */     return OLE2ExtractorFactory.createExtractor(paramOPOIFSFileSystem);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static POITextExtractor createExtractor(DirectoryNode paramDirectoryNode) throws IOException, OpenXML4JException, XmlException {
/* 286 */     for (String str : paramDirectoryNode.getEntryNames()) {
/* 287 */       if (str.equals("Package")) {
/* 288 */         OPCPackage oPCPackage = OPCPackage.open((InputStream)paramDirectoryNode.createDocumentInputStream("Package"));
/* 289 */         return (POITextExtractor)createExtractor(oPCPackage);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 294 */     return OLE2ExtractorFactory.createExtractor(paramDirectoryNode);
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
/*     */   public static POITextExtractor[] getEmbededDocsTextExtractors(POIOLE2TextExtractor paramPOIOLE2TextExtractor) throws IOException, OpenXML4JException, XmlException {
/* 306 */     ArrayList<Entry> arrayList = new ArrayList();
/*     */     
/* 308 */     ArrayList<ByteArrayInputStream> arrayList1 = new ArrayList();
/*     */ 
/*     */     
/* 311 */     DirectoryEntry directoryEntry = paramPOIOLE2TextExtractor.getRoot();
/* 312 */     if (directoryEntry == null) {
/* 313 */       throw new IllegalStateException("The extractor didn't know which POIFS it came from!");
/*     */     }
/*     */     
/* 316 */     if (paramPOIOLE2TextExtractor instanceof org.apache.poi.hssf.extractor.ExcelExtractor) {
/*     */       
/* 318 */       Iterator<Entry> iterator = directoryEntry.getEntries();
/* 319 */       while (iterator.hasNext()) {
/* 320 */         Entry entry = iterator.next();
/* 321 */         if (entry.getName().startsWith("MBD")) {
/* 322 */           arrayList.add(entry);
/*     */         }
/*     */       } 
/* 325 */     } else if (paramPOIOLE2TextExtractor instanceof org.apache.poi.hwpf.extractor.WordExtractor) {
/*     */       
/*     */       try {
/* 328 */         DirectoryEntry directoryEntry1 = (DirectoryEntry)directoryEntry.getEntry("ObjectPool");
/* 329 */         Iterator<Entry> iterator = directoryEntry1.getEntries();
/* 330 */         while (iterator.hasNext()) {
/* 331 */           Entry entry = iterator.next();
/* 332 */           if (entry.getName().startsWith("_")) {
/* 333 */             arrayList.add(entry);
/*     */           }
/*     */         } 
/* 336 */       } catch (FileNotFoundException fileNotFoundException) {
/* 337 */         logger.log(3, new Object[] { "Ignoring FileNotFoundException while extracting Word document", fileNotFoundException.getLocalizedMessage() });
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/* 343 */     else if (paramPOIOLE2TextExtractor instanceof OutlookTextExtactor) {
/*     */       
/* 345 */       MAPIMessage mAPIMessage = ((OutlookTextExtactor)paramPOIOLE2TextExtractor).getMAPIMessage();
/* 346 */       for (AttachmentChunks attachmentChunks : mAPIMessage.getAttachmentFiles()) {
/* 347 */         if (attachmentChunks.attachData != null) {
/* 348 */           byte[] arrayOfByte = attachmentChunks.attachData.getValue();
/* 349 */           arrayList1.add(new ByteArrayInputStream(arrayOfByte));
/* 350 */         } else if (attachmentChunks.attachmentDirectory != null) {
/* 351 */           arrayList.add(attachmentChunks.attachmentDirectory.getDirectory());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 357 */     if (arrayList.size() == 0 && arrayList1.size() == 0) {
/* 358 */       return new POITextExtractor[0];
/*     */     }
/*     */     
/* 361 */     ArrayList<POITextExtractor> arrayList2 = new ArrayList();
/* 362 */     for (Entry entry : arrayList) {
/* 363 */       arrayList2.add(createExtractor((DirectoryNode)entry));
/*     */     }
/* 365 */     for (InputStream inputStream : arrayList1) {
/*     */       try {
/* 367 */         arrayList2.add(createExtractor(inputStream));
/* 368 */       } catch (IllegalArgumentException illegalArgumentException) {
/*     */ 
/*     */         
/* 371 */         logger.log(3, new Object[] { "Format not supported yet", illegalArgumentException.getLocalizedMessage() });
/* 372 */       } catch (XmlException xmlException) {
/* 373 */         throw new IOException(xmlException.getMessage(), xmlException);
/* 374 */       } catch (OpenXML4JException openXML4JException) {
/* 375 */         throw new IOException(openXML4JException.getMessage(), openXML4JException);
/*     */       } 
/*     */     } 
/* 378 */     return arrayList2.<POITextExtractor>toArray(new POITextExtractor[arrayList2.size()]);
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
/*     */   @NotImplemented
/*     */   public static POITextExtractor[] getEmbededDocsTextExtractors(POIXMLTextExtractor paramPOIXMLTextExtractor) {
/* 391 */     throw new IllegalStateException("Not yet supported");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\extractor\ExtractorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */