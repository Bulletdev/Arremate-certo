/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.ByteArrayInputStream;
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.Closeable;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hpsf.DocumentSummaryInformation;
/*     */ import org.apache.poi.hpsf.MutablePropertySet;
/*     */ import org.apache.poi.hpsf.PropertySet;
/*     */ import org.apache.poi.hpsf.PropertySetFactory;
/*     */ import org.apache.poi.hpsf.SummaryInformation;
/*     */ import org.apache.poi.hpsf.WritingNotSupportedException;
/*     */ import org.apache.poi.poifs.crypt.EncryptionInfo;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryNode;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.OPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ import org.apache.poi.util.Internal;
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
/*     */ public abstract class POIDocument
/*     */   implements Closeable
/*     */ {
/*     */   private SummaryInformation sInf;
/*     */   private DocumentSummaryInformation dsInf;
/*     */   protected DirectoryNode directory;
/*  58 */   private static final POILogger logger = POILogFactory.getLogger(POIDocument.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean initialized = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected POIDocument(DirectoryNode paramDirectoryNode) {
/*  69 */     this.directory = paramDirectoryNode;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected POIDocument(OPOIFSFileSystem paramOPOIFSFileSystem) {
/*  78 */     this(paramOPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected POIDocument(NPOIFSFileSystem paramNPOIFSFileSystem) {
/*  86 */     this(paramNPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected POIDocument(POIFSFileSystem paramPOIFSFileSystem) {
/*  94 */     this(paramPOIFSFileSystem.getRoot());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentSummaryInformation getDocumentSummaryInformation() {
/* 104 */     if (!this.initialized) readProperties(); 
/* 105 */     return this.dsInf;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SummaryInformation getSummaryInformation() {
/* 115 */     if (!this.initialized) readProperties(); 
/* 116 */     return this.sInf;
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
/*     */   public void createInformationProperties() {
/* 129 */     if (!this.initialized) readProperties(); 
/* 130 */     if (this.sInf == null) {
/* 131 */       this.sInf = PropertySetFactory.newSummaryInformation();
/*     */     }
/* 133 */     if (this.dsInf == null) {
/* 134 */       this.dsInf = PropertySetFactory.newDocumentSummaryInformation();
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
/*     */   protected void readProperties() {
/* 148 */     PropertySet propertySet = getPropertySet("\005DocumentSummaryInformation");
/* 149 */     if (propertySet instanceof DocumentSummaryInformation) {
/* 150 */       this.dsInf = (DocumentSummaryInformation)propertySet;
/* 151 */     } else if (propertySet != null) {
/* 152 */       logger.log(5, new Object[] { "DocumentSummaryInformation property set came back with wrong class - ", propertySet.getClass() });
/*     */     } else {
/* 154 */       logger.log(5, new Object[] { "DocumentSummaryInformation property set came back as null" });
/*     */     } 
/*     */ 
/*     */     
/* 158 */     propertySet = getPropertySet("\005SummaryInformation");
/* 159 */     if (propertySet instanceof SummaryInformation) {
/* 160 */       this.sInf = (SummaryInformation)propertySet;
/* 161 */     } else if (propertySet != null) {
/* 162 */       logger.log(5, new Object[] { "SummaryInformation property set came back with wrong class - ", propertySet.getClass() });
/*     */     } else {
/* 164 */       logger.log(5, new Object[] { "SummaryInformation property set came back as null" });
/*     */     } 
/*     */ 
/*     */     
/* 168 */     this.initialized = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected PropertySet getPropertySet(String paramString) {
/* 179 */     return getPropertySet(paramString, null);
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
/*     */   protected PropertySet getPropertySet(String paramString, EncryptionInfo paramEncryptionInfo) {
/* 191 */     DirectoryNode directoryNode = this.directory;
/*     */     
/* 193 */     NPOIFSFileSystem nPOIFSFileSystem = null;
/* 194 */     String str = "getting";
/*     */     try {
/* 196 */       if (paramEncryptionInfo != null) {
/* 197 */         str = "getting encrypted";
/* 198 */         InputStream inputStream = paramEncryptionInfo.getDecryptor().getDataStream(this.directory);
/*     */         try {
/* 200 */           nPOIFSFileSystem = new NPOIFSFileSystem(inputStream);
/* 201 */           directoryNode = nPOIFSFileSystem.getRoot();
/*     */         } finally {
/* 203 */           inputStream.close();
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 208 */       if (directoryNode == null || !directoryNode.hasEntry(paramString)) {
/* 209 */         return null;
/*     */       }
/*     */ 
/*     */       
/* 213 */       str = "getting";
/* 214 */       DocumentInputStream documentInputStream = directoryNode.createDocumentInputStream(directoryNode.getEntry(paramString));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 222 */     catch (Exception exception) {
/* 223 */       logger.log(5, new Object[] { "Error " + str + " property set with name " + paramString, exception });
/* 224 */       return null;
/*     */     } finally {
/* 226 */       if (nPOIFSFileSystem != null) {
/*     */         try {
/* 228 */           nPOIFSFileSystem.close();
/* 229 */         } catch (IOException iOException) {
/* 230 */           logger.log(5, new Object[] { "Error closing encrypted property poifs", iOException });
/*     */         } 
/*     */       }
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
/*     */   protected void writeProperties() throws IOException {
/* 244 */     validateInPlaceWritePossible();
/* 245 */     writeProperties(this.directory.getFileSystem(), null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeProperties(NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/* 256 */     writeProperties(paramNPOIFSFileSystem, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void writeProperties(NPOIFSFileSystem paramNPOIFSFileSystem, List<String> paramList) throws IOException {
/* 267 */     SummaryInformation summaryInformation = getSummaryInformation();
/* 268 */     if (summaryInformation != null) {
/* 269 */       writePropertySet("\005SummaryInformation", (PropertySet)summaryInformation, paramNPOIFSFileSystem);
/* 270 */       if (paramList != null) {
/* 271 */         paramList.add("\005SummaryInformation");
/*     */       }
/*     */     } 
/* 274 */     DocumentSummaryInformation documentSummaryInformation = getDocumentSummaryInformation();
/* 275 */     if (documentSummaryInformation != null) {
/* 276 */       writePropertySet("\005DocumentSummaryInformation", (PropertySet)documentSummaryInformation, paramNPOIFSFileSystem);
/* 277 */       if (paramList != null) {
/* 278 */         paramList.add("\005DocumentSummaryInformation");
/*     */       }
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
/*     */   protected void writePropertySet(String paramString, PropertySet paramPropertySet, NPOIFSFileSystem paramNPOIFSFileSystem) throws IOException {
/*     */     try {
/* 294 */       MutablePropertySet mutablePropertySet = new MutablePropertySet(paramPropertySet);
/* 295 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*     */       
/* 297 */       mutablePropertySet.write(byteArrayOutputStream);
/* 298 */       byte[] arrayOfByte = byteArrayOutputStream.toByteArray();
/* 299 */       ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(arrayOfByte);
/*     */ 
/*     */       
/* 302 */       paramNPOIFSFileSystem.createOrUpdateDocument(byteArrayInputStream, paramString);
/*     */       
/* 304 */       logger.log(3, new Object[] { "Wrote property set " + paramString + " of size " + arrayOfByte.length });
/* 305 */     } catch (WritingNotSupportedException writingNotSupportedException) {
/* 306 */       logger.log(7, new Object[] { "Couldn't write property set with name " + paramString + " as not supported by HPSF yet" });
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
/*     */   protected void validateInPlaceWritePossible() throws IllegalStateException {
/* 318 */     if (this.directory == null) {
/* 319 */       throw new IllegalStateException("Newly created Document, cannot save in-place");
/*     */     }
/* 321 */     if (this.directory.getParent() != null) {
/* 322 */       throw new IllegalStateException("This is not the root Document, cannot save embedded resource in-place");
/*     */     }
/* 324 */     if (this.directory.getFileSystem() == null || !this.directory.getFileSystem().isInPlaceWriteable())
/*     */     {
/* 326 */       throw new IllegalStateException("Opened read-only or via an InputStream, a Writeable File is required");
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
/*     */   public abstract void write() throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void write(File paramFile) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void write(OutputStream paramOutputStream) throws IOException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/* 388 */     if (this.directory != null && 
/* 389 */       this.directory.getNFileSystem() != null) {
/* 390 */       this.directory.getNFileSystem().close();
/* 391 */       this.directory = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Internal
/*     */   public DirectoryNode getDirectory() {
/* 398 */     return this.directory;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIDocument.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */