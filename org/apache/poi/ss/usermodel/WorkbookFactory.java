/*     */ package org.apache.poi.ss.usermodel;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.PushbackInputStream;
/*     */ import org.apache.poi.EncryptedDocumentException;
/*     */ import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
/*     */ import org.apache.poi.hssf.usermodel.HSSFWorkbook;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackageAccess;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentFactoryHelper;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OfficeXmlFileException;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.util.IOUtils;
/*     */ import org.apache.poi.xssf.usermodel.XSSFWorkbook;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WorkbookFactory
/*     */ {
/*     */   public static Workbook create(POIFSFileSystem paramPOIFSFileSystem) throws IOException {
/*  49 */     return (Workbook)new HSSFWorkbook(paramPOIFSFileSystem);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Workbook create(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*     */     try {
/*  59 */       return create(paramNPOIFSFileSystem, (String)null);
/*  60 */     } catch (InvalidFormatException invalidFormatException) {
/*     */       
/*  62 */       throw new IOException(invalidFormatException);
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
/*     */   private static Workbook create(NPOIFSFileSystem paramNPOIFSFileSystem, String paramString) throws IOException, InvalidFormatException {
/*  79 */     DirectoryNode directoryNode = paramNPOIFSFileSystem.getRoot();
/*     */ 
/*     */     
/*  82 */     if (directoryNode.hasEntry("EncryptedPackage")) {
/*  83 */       InputStream inputStream = DocumentFactoryHelper.getDecryptedStream(paramNPOIFSFileSystem, paramString);
/*     */       
/*  85 */       OPCPackage oPCPackage = OPCPackage.open(inputStream);
/*  86 */       return create(oPCPackage);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  91 */     if (paramString != null) {
/*  92 */       Biff8EncryptionKey.setCurrentUserPassword(paramString);
/*     */     }
/*     */     try {
/*  95 */       return (Workbook)new HSSFWorkbook(directoryNode, true);
/*     */     } finally {
/*  97 */       Biff8EncryptionKey.setCurrentUserPassword(null);
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
/*     */   public static Workbook create(OPCPackage paramOPCPackage) throws IOException {
/* 114 */     return (Workbook)new XSSFWorkbook(paramOPCPackage);
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
/*     */   public static Workbook create(InputStream paramInputStream) throws IOException, InvalidFormatException, EncryptedDocumentException {
/* 140 */     return create(paramInputStream, (String)null);
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
/*     */   public static Workbook create(InputStream paramInputStream, String paramString) throws IOException, InvalidFormatException, EncryptedDocumentException {
/* 168 */     if (!paramInputStream.markSupported()) {
/* 169 */       paramInputStream = new PushbackInputStream(paramInputStream, 8);
/*     */     }
/*     */ 
/*     */     
/* 173 */     byte[] arrayOfByte = IOUtils.peekFirst8Bytes(paramInputStream);
/*     */ 
/*     */     
/* 176 */     if (NPOIFSFileSystem.hasPOIFSHeader(arrayOfByte)) {
/* 177 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(paramInputStream);
/* 178 */       return create(nPOIFSFileSystem, paramString);
/*     */     } 
/* 180 */     if (DocumentFactoryHelper.hasOOXMLHeader(paramInputStream)) {
/* 181 */       return (Workbook)new XSSFWorkbook(OPCPackage.open(paramInputStream));
/*     */     }
/* 183 */     throw new InvalidFormatException("Your InputStream was neither an OLE2 stream, nor an OOXML stream");
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
/*     */   public static Workbook create(File paramFile) throws IOException, InvalidFormatException, EncryptedDocumentException {
/* 201 */     return create(paramFile, (String)null);
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
/*     */   public static Workbook create(File paramFile, String paramString) throws IOException, InvalidFormatException, EncryptedDocumentException {
/* 222 */     return create(paramFile, paramString, false);
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
/*     */   public static Workbook create(File paramFile, String paramString, boolean paramBoolean) throws IOException, InvalidFormatException, EncryptedDocumentException {
/* 245 */     if (!paramFile.exists()) {
/* 246 */       throw new FileNotFoundException(paramFile.toString());
/*     */     }
/*     */     
/*     */     try {
/* 250 */       NPOIFSFileSystem nPOIFSFileSystem = new NPOIFSFileSystem(paramFile, paramBoolean);
/*     */       try {
/* 252 */         return create(nPOIFSFileSystem, paramString);
/* 253 */       } catch (RuntimeException runtimeException) {
/*     */         
/* 255 */         nPOIFSFileSystem.close();
/*     */         
/* 257 */         throw runtimeException;
/*     */       } 
/* 259 */     } catch (OfficeXmlFileException officeXmlFileException) {
/*     */       
/* 261 */       OPCPackage oPCPackage = OPCPackage.open(paramFile, paramBoolean ? PackageAccess.READ : PackageAccess.READ_WRITE);
/*     */       try {
/* 263 */         return (Workbook)new XSSFWorkbook(oPCPackage);
/* 264 */       } catch (IOException iOException) {
/*     */         
/* 266 */         oPCPackage.revert();
/*     */ 
/*     */ 
/*     */         
/* 270 */         throw iOException;
/* 271 */       } catch (RuntimeException runtimeException) {
/*     */         
/* 273 */         oPCPackage.revert();
/*     */ 
/*     */ 
/*     */         
/* 277 */         throw runtimeException;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\s\\usermodel\WorkbookFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */