/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.util.ZipSecureFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class POIXMLTextExtractor
/*     */   extends POITextExtractor
/*     */ {
/*     */   private final POIXMLDocument _document;
/*     */   
/*     */   public POIXMLTextExtractor(POIXMLDocument paramPOIXMLDocument) {
/*  38 */     this._document = paramPOIXMLDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.CoreProperties getCoreProperties() {
/*  47 */     return this._document.getProperties().getCoreProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.ExtendedProperties getExtendedProperties() {
/*  55 */     return this._document.getProperties().getExtendedProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLProperties.CustomProperties getCustomProperties() {
/*  63 */     return this._document.getProperties().getCustomProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final POIXMLDocument getDocument() {
/*  72 */     return this._document;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public OPCPackage getPackage() {
/*  81 */     return this._document.getPackage();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
/*  90 */     return new POIXMLPropertiesTextExtractor(this._document);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws IOException {
/*  96 */     if (this._document != null) {
/*     */       
/*  98 */       OPCPackage oPCPackage = this._document.getPackage();
/*  99 */       if (oPCPackage != null)
/*     */       {
/* 101 */         oPCPackage.revert();
/*     */       }
/*     */     } 
/* 104 */     super.close();
/*     */   }
/*     */   
/*     */   protected void checkMaxTextSize(StringBuffer paramStringBuffer, String paramString) {
/* 108 */     if (paramString == null) {
/*     */       return;
/*     */     }
/*     */     
/* 112 */     int i = paramStringBuffer.length() + paramString.length();
/* 113 */     if (i > ZipSecureFile.getMaxTextSize())
/* 114 */       throw new IllegalStateException("The text would exceed the max allowed overall size of extracted text. By default this is prevented as some documents may exhaust available memory and it may indicate that the file is used to inflate memory usage and thus could pose a security risk. You can adjust this limit via ZipSecureFile.setMaxTextSize() if you need to work with files which have a lot of text. Size: " + i + ", limit: MAX_TEXT_SIZE: " + ZipSecureFile.getMaxTextSize()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLTextExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */