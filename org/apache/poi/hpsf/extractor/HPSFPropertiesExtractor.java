/*     */ package org.apache.poi.hpsf.extractor;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import org.apache.poi.POIDocument;
/*     */ import org.apache.poi.POIOLE2TextExtractor;
/*     */ import org.apache.poi.POITextExtractor;
/*     */ import org.apache.poi.hpsf.CustomProperties;
/*     */ import org.apache.poi.hpsf.DocumentSummaryInformation;
/*     */ import org.apache.poi.hpsf.HPSFPropertiesOnlyDocument;
/*     */ import org.apache.poi.hpsf.Property;
/*     */ import org.apache.poi.hpsf.SpecialPropertySet;
/*     */ import org.apache.poi.hpsf.SummaryInformation;
/*     */ import org.apache.poi.hpsf.wellknown.PropertyIDMap;
/*     */ import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
/*     */ import org.apache.poi.poifs.filesystem.POIFSFileSystem;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HPSFPropertiesExtractor
/*     */   extends POIOLE2TextExtractor
/*     */ {
/*     */   public HPSFPropertiesExtractor(POIOLE2TextExtractor paramPOIOLE2TextExtractor) {
/*  43 */     super(paramPOIOLE2TextExtractor);
/*     */   }
/*     */   public HPSFPropertiesExtractor(POIDocument paramPOIDocument) {
/*  46 */     super(paramPOIDocument);
/*     */   }
/*     */   public HPSFPropertiesExtractor(POIFSFileSystem paramPOIFSFileSystem) {
/*  49 */     super((POIDocument)new HPSFPropertiesOnlyDocument(paramPOIFSFileSystem));
/*     */   }
/*     */   public HPSFPropertiesExtractor(NPOIFSFileSystem paramNPOIFSFileSystem) {
/*  52 */     super((POIDocument)new HPSFPropertiesOnlyDocument(paramNPOIFSFileSystem));
/*     */   }
/*     */   
/*     */   public String getDocumentSummaryInformationText() {
/*  56 */     if (this.document == null) {
/*  57 */       return "";
/*     */     }
/*     */     
/*  60 */     DocumentSummaryInformation documentSummaryInformation = this.document.getDocumentSummaryInformation();
/*  61 */     StringBuilder stringBuilder = new StringBuilder();
/*     */ 
/*     */     
/*  64 */     stringBuilder.append(getPropertiesText((SpecialPropertySet)documentSummaryInformation));
/*     */ 
/*     */     
/*  67 */     CustomProperties customProperties = (documentSummaryInformation == null) ? null : documentSummaryInformation.getCustomProperties();
/*  68 */     if (customProperties != null) {
/*  69 */       for (String str1 : customProperties.nameSet()) {
/*  70 */         String str2 = HelperPropertySet.getPropertyValueText(customProperties.get(str1));
/*  71 */         stringBuilder.append(str1).append(" = ").append(str2).append("\n");
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*  76 */     return stringBuilder.toString();
/*     */   }
/*     */   public String getSummaryInformationText() {
/*  79 */     if (this.document == null) {
/*  80 */       return "";
/*     */     }
/*     */     
/*  83 */     SummaryInformation summaryInformation = this.document.getSummaryInformation();
/*     */ 
/*     */     
/*  86 */     return getPropertiesText((SpecialPropertySet)summaryInformation);
/*     */   }
/*     */   
/*     */   private static String getPropertiesText(SpecialPropertySet paramSpecialPropertySet) {
/*  90 */     if (paramSpecialPropertySet == null)
/*     */     {
/*  92 */       return "";
/*     */     }
/*     */     
/*  95 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/*  97 */     PropertyIDMap propertyIDMap = paramSpecialPropertySet.getPropertySetIDMap();
/*  98 */     Property[] arrayOfProperty = paramSpecialPropertySet.getProperties();
/*  99 */     for (Property property : arrayOfProperty) {
/* 100 */       String str1 = Long.toString(property.getID());
/* 101 */       Object object = propertyIDMap.get(property.getID());
/* 102 */       if (object != null) {
/* 103 */         str1 = object.toString();
/*     */       }
/*     */       
/* 106 */       String str2 = HelperPropertySet.getPropertyValueText(property.getValue());
/* 107 */       stringBuilder.append(str1).append(" = ").append(str2).append("\n");
/*     */     } 
/*     */     
/* 110 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getText() {
/* 118 */     return getSummaryInformationText() + getDocumentSummaryInformationText();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POITextExtractor getMetadataTextExtractor() {
/* 125 */     throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
/*     */   }
/*     */   
/*     */   private static abstract class HelperPropertySet extends SpecialPropertySet {
/*     */     public HelperPropertySet() {
/* 130 */       super(null);
/*     */     }
/*     */     public static String getPropertyValueText(Object param1Object) {
/* 133 */       if (param1Object == null) {
/* 134 */         return "(not set)";
/*     */       }
/* 136 */       return SpecialPropertySet.getPropertyStringValue(param1Object);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 142 */     return super.equals(paramObject);
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 147 */     return super.hashCode();
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/* 151 */     for (String str : paramArrayOfString)
/* 152 */       HPSFPropertiesExtractor hPSFPropertiesExtractor = new HPSFPropertiesExtractor(new NPOIFSFileSystem(new File(str))); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\extractor\HPSFPropertiesExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */