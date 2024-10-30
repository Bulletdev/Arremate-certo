/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import org.apache.poi.hpsf.wellknown.SectionIDMap;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentEntry;
/*     */ import org.apache.poi.poifs.filesystem.DocumentInputStream;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PropertySetFactory
/*     */ {
/*     */   public static PropertySet create(DirectoryEntry paramDirectoryEntry, String paramString) throws FileNotFoundException, NoPropertySetStreamException, IOException, UnsupportedEncodingException {
/*  58 */     DocumentInputStream documentInputStream = null;
/*     */     try {
/*  60 */       DocumentEntry documentEntry = (DocumentEntry)paramDirectoryEntry.getEntry(paramString);
/*  61 */       documentInputStream = new DocumentInputStream(documentEntry);
/*     */     
/*     */     }
/*     */     finally {
/*     */       
/*  66 */       if (documentInputStream != null) documentInputStream.close();
/*     */     
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
/*     */   public static PropertySet create(InputStream paramInputStream) throws NoPropertySetStreamException, MarkUnsupportedException, UnsupportedEncodingException, IOException {
/*  92 */     PropertySet propertySet = new PropertySet(paramInputStream);
/*     */     
/*     */     try {
/*  95 */       if (propertySet.isSummaryInformation())
/*  96 */         return new SummaryInformation(propertySet); 
/*  97 */       if (propertySet.isDocumentSummaryInformation()) {
/*  98 */         return new DocumentSummaryInformation(propertySet);
/*     */       }
/* 100 */       return propertySet;
/*     */     }
/* 102 */     catch (UnexpectedPropertySetTypeException unexpectedPropertySetTypeException) {
/*     */ 
/*     */ 
/*     */       
/* 106 */       throw new IllegalStateException(unexpectedPropertySetTypeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SummaryInformation newSummaryInformation() {
/* 117 */     MutablePropertySet mutablePropertySet = new MutablePropertySet();
/* 118 */     MutableSection mutableSection = (MutableSection)mutablePropertySet.getFirstSection();
/* 119 */     mutableSection.setFormatID(SectionIDMap.SUMMARY_INFORMATION_ID);
/*     */     
/*     */     try {
/* 122 */       return new SummaryInformation(mutablePropertySet);
/*     */     }
/* 124 */     catch (UnexpectedPropertySetTypeException unexpectedPropertySetTypeException) {
/*     */ 
/*     */       
/* 127 */       throw new HPSFRuntimeException(unexpectedPropertySetTypeException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static DocumentSummaryInformation newDocumentSummaryInformation() {
/* 138 */     MutablePropertySet mutablePropertySet = new MutablePropertySet();
/* 139 */     MutableSection mutableSection = (MutableSection)mutablePropertySet.getFirstSection();
/* 140 */     mutableSection.setFormatID(SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[0]);
/*     */     
/*     */     try {
/* 143 */       return new DocumentSummaryInformation(mutablePropertySet);
/*     */     }
/* 145 */     catch (UnexpectedPropertySetTypeException unexpectedPropertySetTypeException) {
/*     */ 
/*     */       
/* 148 */       throw new HPSFRuntimeException(unexpectedPropertySetTypeException);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\PropertySetFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */