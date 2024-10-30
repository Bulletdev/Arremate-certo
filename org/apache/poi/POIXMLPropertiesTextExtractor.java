/*     */ package org.apache.poi;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.text.DateFormat;
/*     */ import java.text.DateFormatSymbols;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.openxml4j.opc.internal.PackagePropertiesPart;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperties;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.customProperties.CTProperty;
/*     */ import org.openxmlformats.schemas.officeDocument.x2006.extendedProperties.CTProperties;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class POIXMLPropertiesTextExtractor
/*     */   extends POIXMLTextExtractor
/*     */ {
/*     */   private final DateFormat dateFormat;
/*     */   
/*     */   public POIXMLPropertiesTextExtractor(POIXMLDocument paramPOIXMLDocument) {
/*  46 */     super(paramPOIXMLDocument);
/*  47 */     DateFormatSymbols dateFormatSymbols = DateFormatSymbols.getInstance(Locale.ROOT);
/*  48 */     this.dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", dateFormatSymbols);
/*  49 */     this.dateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public POIXMLPropertiesTextExtractor(POIXMLTextExtractor paramPOIXMLTextExtractor) {
/*  60 */     this(paramPOIXMLTextExtractor.getDocument());
/*     */   }
/*     */   
/*     */   private void appendIfPresent(StringBuffer paramStringBuffer, String paramString, boolean paramBoolean) {
/*  64 */     appendIfPresent(paramStringBuffer, paramString, Boolean.toString(paramBoolean));
/*     */   }
/*     */   private void appendIfPresent(StringBuffer paramStringBuffer, String paramString, int paramInt) {
/*  67 */     appendIfPresent(paramStringBuffer, paramString, Integer.toString(paramInt));
/*     */   }
/*     */   private void appendIfPresent(StringBuffer paramStringBuffer, String paramString, Date paramDate) {
/*  70 */     if (paramDate == null)
/*  71 */       return;  appendIfPresent(paramStringBuffer, paramString, this.dateFormat.format(paramDate));
/*     */   }
/*     */   private void appendIfPresent(StringBuffer paramStringBuffer, String paramString1, String paramString2) {
/*  74 */     if (paramString2 == null)
/*  75 */       return;  paramStringBuffer.append(paramString1);
/*  76 */     paramStringBuffer.append(" = ");
/*  77 */     paramStringBuffer.append(paramString2);
/*  78 */     paramStringBuffer.append("\n");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCorePropertiesText() {
/*  88 */     POIXMLDocument pOIXMLDocument = getDocument();
/*  89 */     if (pOIXMLDocument == null) {
/*  90 */       return "";
/*     */     }
/*     */     
/*  93 */     StringBuffer stringBuffer = new StringBuffer();
/*  94 */     PackagePropertiesPart packagePropertiesPart = pOIXMLDocument.getProperties().getCoreProperties().getUnderlyingProperties();
/*     */ 
/*     */     
/*  97 */     appendIfPresent(stringBuffer, "Category", (String)packagePropertiesPart.getCategoryProperty().getValue());
/*  98 */     appendIfPresent(stringBuffer, "Category", (String)packagePropertiesPart.getCategoryProperty().getValue());
/*  99 */     appendIfPresent(stringBuffer, "ContentStatus", (String)packagePropertiesPart.getContentStatusProperty().getValue());
/* 100 */     appendIfPresent(stringBuffer, "ContentType", (String)packagePropertiesPart.getContentTypeProperty().getValue());
/* 101 */     appendIfPresent(stringBuffer, "Created", (Date)packagePropertiesPart.getCreatedProperty().getValue());
/* 102 */     appendIfPresent(stringBuffer, "CreatedString", packagePropertiesPart.getCreatedPropertyString());
/* 103 */     appendIfPresent(stringBuffer, "Creator", (String)packagePropertiesPart.getCreatorProperty().getValue());
/* 104 */     appendIfPresent(stringBuffer, "Description", (String)packagePropertiesPart.getDescriptionProperty().getValue());
/* 105 */     appendIfPresent(stringBuffer, "Identifier", (String)packagePropertiesPart.getIdentifierProperty().getValue());
/* 106 */     appendIfPresent(stringBuffer, "Keywords", (String)packagePropertiesPart.getKeywordsProperty().getValue());
/* 107 */     appendIfPresent(stringBuffer, "Language", (String)packagePropertiesPart.getLanguageProperty().getValue());
/* 108 */     appendIfPresent(stringBuffer, "LastModifiedBy", (String)packagePropertiesPart.getLastModifiedByProperty().getValue());
/* 109 */     appendIfPresent(stringBuffer, "LastPrinted", (Date)packagePropertiesPart.getLastPrintedProperty().getValue());
/* 110 */     appendIfPresent(stringBuffer, "LastPrintedString", packagePropertiesPart.getLastPrintedPropertyString());
/* 111 */     appendIfPresent(stringBuffer, "Modified", (Date)packagePropertiesPart.getModifiedProperty().getValue());
/* 112 */     appendIfPresent(stringBuffer, "ModifiedString", packagePropertiesPart.getModifiedPropertyString());
/* 113 */     appendIfPresent(stringBuffer, "Revision", (String)packagePropertiesPart.getRevisionProperty().getValue());
/* 114 */     appendIfPresent(stringBuffer, "Subject", (String)packagePropertiesPart.getSubjectProperty().getValue());
/* 115 */     appendIfPresent(stringBuffer, "Title", (String)packagePropertiesPart.getTitleProperty().getValue());
/* 116 */     appendIfPresent(stringBuffer, "Version", (String)packagePropertiesPart.getVersionProperty().getValue());
/*     */     
/* 118 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExtendedPropertiesText() {
/* 127 */     POIXMLDocument pOIXMLDocument = getDocument();
/* 128 */     if (pOIXMLDocument == null) {
/* 129 */       return "";
/*     */     }
/*     */     
/* 132 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 134 */     CTProperties cTProperties = pOIXMLDocument.getProperties().getExtendedProperties().getUnderlyingProperties();
/*     */     
/* 136 */     appendIfPresent(stringBuffer, "Application", cTProperties.getApplication());
/* 137 */     appendIfPresent(stringBuffer, "AppVersion", cTProperties.getAppVersion());
/* 138 */     appendIfPresent(stringBuffer, "Characters", cTProperties.getCharacters());
/* 139 */     appendIfPresent(stringBuffer, "CharactersWithSpaces", cTProperties.getCharactersWithSpaces());
/* 140 */     appendIfPresent(stringBuffer, "Company", cTProperties.getCompany());
/* 141 */     appendIfPresent(stringBuffer, "HyperlinkBase", cTProperties.getHyperlinkBase());
/* 142 */     appendIfPresent(stringBuffer, "HyperlinksChanged", cTProperties.getHyperlinksChanged());
/* 143 */     appendIfPresent(stringBuffer, "Lines", cTProperties.getLines());
/* 144 */     appendIfPresent(stringBuffer, "LinksUpToDate", cTProperties.getLinksUpToDate());
/* 145 */     appendIfPresent(stringBuffer, "Manager", cTProperties.getManager());
/* 146 */     appendIfPresent(stringBuffer, "Pages", cTProperties.getPages());
/* 147 */     appendIfPresent(stringBuffer, "Paragraphs", cTProperties.getParagraphs());
/* 148 */     appendIfPresent(stringBuffer, "PresentationFormat", cTProperties.getPresentationFormat());
/* 149 */     appendIfPresent(stringBuffer, "Template", cTProperties.getTemplate());
/* 150 */     appendIfPresent(stringBuffer, "TotalTime", cTProperties.getTotalTime());
/*     */     
/* 152 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCustomPropertiesText() {
/* 161 */     POIXMLDocument pOIXMLDocument = getDocument();
/* 162 */     if (pOIXMLDocument == null) {
/* 163 */       return "";
/*     */     }
/*     */     
/* 166 */     StringBuilder stringBuilder = new StringBuilder();
/*     */     
/* 168 */     CTProperties cTProperties = pOIXMLDocument.getProperties().getCustomProperties().getUnderlyingProperties();
/*     */     
/* 170 */     for (CTProperty cTProperty : cTProperties.getPropertyArray()) {
/* 171 */       String str = "(not implemented!)";
/*     */       
/* 173 */       if (cTProperty.isSetLpwstr()) {
/* 174 */         str = cTProperty.getLpwstr();
/*     */       }
/* 176 */       else if (cTProperty.isSetLpstr()) {
/* 177 */         str = cTProperty.getLpstr();
/*     */       }
/* 179 */       else if (cTProperty.isSetDate()) {
/* 180 */         str = cTProperty.getDate().toString();
/*     */       }
/* 182 */       else if (cTProperty.isSetFiletime()) {
/* 183 */         str = cTProperty.getFiletime().toString();
/*     */       }
/* 185 */       else if (cTProperty.isSetBool()) {
/* 186 */         str = Boolean.toString(cTProperty.getBool());
/*     */ 
/*     */       
/*     */       }
/* 190 */       else if (cTProperty.isSetI1()) {
/* 191 */         str = Integer.toString(cTProperty.getI1());
/*     */       }
/* 193 */       else if (cTProperty.isSetI2()) {
/* 194 */         str = Integer.toString(cTProperty.getI2());
/*     */       }
/* 196 */       else if (cTProperty.isSetI4()) {
/* 197 */         str = Integer.toString(cTProperty.getI4());
/*     */       }
/* 199 */       else if (cTProperty.isSetI8()) {
/* 200 */         str = Long.toString(cTProperty.getI8());
/*     */       }
/* 202 */       else if (cTProperty.isSetInt()) {
/* 203 */         str = Integer.toString(cTProperty.getInt());
/*     */ 
/*     */       
/*     */       }
/* 207 */       else if (cTProperty.isSetUi1()) {
/* 208 */         str = Integer.toString(cTProperty.getUi1());
/*     */       }
/* 210 */       else if (cTProperty.isSetUi2()) {
/* 211 */         str = Integer.toString(cTProperty.getUi2());
/*     */       }
/* 213 */       else if (cTProperty.isSetUi4()) {
/* 214 */         str = Long.toString(cTProperty.getUi4());
/*     */       }
/* 216 */       else if (cTProperty.isSetUi8()) {
/* 217 */         str = cTProperty.getUi8().toString();
/*     */       }
/* 219 */       else if (cTProperty.isSetUint()) {
/* 220 */         str = Long.toString(cTProperty.getUint());
/*     */ 
/*     */       
/*     */       }
/* 224 */       else if (cTProperty.isSetR4()) {
/* 225 */         str = Float.toString(cTProperty.getR4());
/*     */       }
/* 227 */       else if (cTProperty.isSetR8()) {
/* 228 */         str = Double.toString(cTProperty.getR8());
/*     */       }
/* 230 */       else if (cTProperty.isSetDecimal()) {
/* 231 */         BigDecimal bigDecimal = cTProperty.getDecimal();
/* 232 */         if (bigDecimal == null) {
/* 233 */           str = null;
/*     */         } else {
/* 235 */           str = bigDecimal.toPlainString();
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 257 */       stringBuilder.append(cTProperty.getName()).append(" = ").append(str).append("\n");
/*     */     } 
/*     */     
/* 260 */     return stringBuilder.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public String getText() {
/*     */     try {
/* 266 */       return getCorePropertiesText() + getExtendedPropertiesText() + getCustomPropertiesText();
/*     */ 
/*     */     
/*     */     }
/* 270 */     catch (Exception exception) {
/* 271 */       throw new RuntimeException(exception);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public POIXMLPropertiesTextExtractor getMetadataTextExtractor() {
/* 277 */     throw new IllegalStateException("You already have the Metadata Text Extractor, not recursing!");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\POIXMLPropertiesTextExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */