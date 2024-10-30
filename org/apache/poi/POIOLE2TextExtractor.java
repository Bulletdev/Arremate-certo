/*     */ package org.apache.poi;
/*     */ 
/*     */ import org.apache.poi.hpsf.DocumentSummaryInformation;
/*     */ import org.apache.poi.hpsf.SummaryInformation;
/*     */ import org.apache.poi.hpsf.extractor.HPSFPropertiesExtractor;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class POIOLE2TextExtractor
/*     */   extends POITextExtractor
/*     */ {
/*     */   protected POIDocument document;
/*     */   
/*     */   public POIOLE2TextExtractor(POIDocument paramPOIDocument) {
/*  46 */     this.document = paramPOIDocument;
/*     */ 
/*     */ 
/*     */     
/*  50 */     setFilesystem(paramPOIDocument);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected POIOLE2TextExtractor(POIOLE2TextExtractor paramPOIOLE2TextExtractor) {
/*  61 */     this.document = paramPOIOLE2TextExtractor.document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DocumentSummaryInformation getDocSummaryInformation() {
/*  71 */     return this.document.getDocumentSummaryInformation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SummaryInformation getSummaryInformation() {
/*  80 */     return this.document.getSummaryInformation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POITextExtractor getMetadataTextExtractor() {
/*  91 */     return (POITextExtractor)new HPSFPropertiesExtractor(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DirectoryEntry getRoot() {
/* 101 */     return (DirectoryEntry)this.document.directory;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIOLE2TextExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */