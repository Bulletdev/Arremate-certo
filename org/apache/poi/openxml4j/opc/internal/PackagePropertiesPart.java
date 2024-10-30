/*     */ package org.apache.poi.openxml4j.opc.internal;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Locale;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.openxml4j.opc.OPCPackage;
/*     */ import org.apache.poi.openxml4j.opc.PackagePart;
/*     */ import org.apache.poi.openxml4j.opc.PackagePartName;
/*     */ import org.apache.poi.openxml4j.opc.PackageProperties;
/*     */ import org.apache.poi.openxml4j.util.Nullable;
/*     */ import org.apache.poi.util.LocaleUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PackagePropertiesPart
/*     */   extends PackagePart
/*     */   implements PackageProperties
/*     */ {
/*     */   public static final String NAMESPACE_DC_URI = "http://purl.org/dc/elements/1.1/";
/*     */   public static final String NAMESPACE_CP_URI = "http://schemas.openxmlformats.org/package/2006/metadata/core-properties";
/*     */   public static final String NAMESPACE_DCTERMS_URI = "http://purl.org/dc/terms/";
/*     */   private static final String DEFAULT_DATEFORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";
/*  55 */   private static final String[] DATE_FORMATS = new String[] { "yyyy-MM-dd'T'HH:mm:ss'Z'", "yyyy-MM-dd'T'HH:mm:ss.SS'Z'" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  65 */   private final String[] TZ_DATE_FORMATS = new String[] { "yyyy-MM-dd'T'HH:mm:ssz", "yyyy-MM-dd'T'HH:mm:ss.Sz", "yyyy-MM-dd'T'HH:mm:ss.SSz", "yyyy-MM-dd'T'HH:mm:ss.SSSz" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  72 */   private final Pattern TIME_ZONE_PAT = Pattern.compile("([-+]\\d\\d):?(\\d\\d)");
/*     */   
/*     */   protected Nullable<String> category;
/*     */   
/*     */   protected Nullable<String> contentStatus;
/*     */   protected Nullable<String> contentType;
/*     */   protected Nullable<Date> created;
/*     */   protected Nullable<String> creator;
/*     */   protected Nullable<String> description;
/*     */   protected Nullable<String> identifier;
/*     */   protected Nullable<String> keywords;
/*     */   
/*     */   public PackagePropertiesPart(OPCPackage paramOPCPackage, PackagePartName paramPackagePartName) throws InvalidFormatException {
/*  85 */     super(paramOPCPackage, paramPackagePartName, "application/vnd.openxmlformats-package.core-properties+xml");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  96 */     this.category = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 104 */     this.contentStatus = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 114 */     this.contentType = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 119 */     this.created = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 124 */     this.creator = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 133 */     this.description = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 138 */     this.identifier = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 145 */     this.keywords = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 153 */     this.language = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 162 */     this.lastModifiedBy = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 167 */     this.lastPrinted = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 172 */     this.modified = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 180 */     this.revision = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 185 */     this.subject = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 190 */     this.title = new Nullable();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 195 */     this.version = new Nullable();
/*     */   }
/*     */ 
/*     */   
/*     */   protected Nullable<String> language;
/*     */   
/*     */   protected Nullable<String> lastModifiedBy;
/*     */   
/*     */   protected Nullable<Date> lastPrinted;
/*     */   protected Nullable<Date> modified;
/*     */   
/*     */   public Nullable<String> getCategoryProperty() {
/* 207 */     return this.category;
/*     */   }
/*     */   
/*     */   protected Nullable<String> revision;
/*     */   protected Nullable<String> subject;
/*     */   protected Nullable<String> title;
/*     */   protected Nullable<String> version;
/*     */   
/*     */   public Nullable<String> getContentStatusProperty() {
/* 216 */     return this.contentStatus;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getContentTypeProperty() {
/* 225 */     return this.contentType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<Date> getCreatedProperty() {
/* 234 */     return this.created;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCreatedPropertyString() {
/* 243 */     return getDateValue(this.created);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getCreatorProperty() {
/* 252 */     return this.creator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getDescriptionProperty() {
/* 261 */     return this.description;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getIdentifierProperty() {
/* 270 */     return this.identifier;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getKeywordsProperty() {
/* 279 */     return this.keywords;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getLanguageProperty() {
/* 288 */     return this.language;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getLastModifiedByProperty() {
/* 297 */     return this.lastModifiedBy;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<Date> getLastPrintedProperty() {
/* 306 */     return this.lastPrinted;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLastPrintedPropertyString() {
/* 315 */     return getDateValue(this.lastPrinted);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<Date> getModifiedProperty() {
/* 324 */     return this.modified;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getModifiedPropertyString() {
/* 333 */     if (this.modified.hasValue()) {
/* 334 */       return getDateValue(this.modified);
/*     */     }
/* 336 */     return getDateValue(new Nullable(new Date()));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getRevisionProperty() {
/* 345 */     return this.revision;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getSubjectProperty() {
/* 354 */     return this.subject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getTitleProperty() {
/* 363 */     return this.title;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Nullable<String> getVersionProperty() {
/* 372 */     return this.version;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategoryProperty(String paramString) {
/* 381 */     this.category = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentStatusProperty(String paramString) {
/* 390 */     this.contentStatus = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentTypeProperty(String paramString) {
/* 399 */     this.contentType = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatedProperty(String paramString) {
/*     */     try {
/* 409 */       this.created = setDateValue(paramString);
/* 410 */     } catch (InvalidFormatException invalidFormatException) {
/* 411 */       throw new IllegalArgumentException("Date for created could not be parsed: " + paramString, invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatedProperty(Nullable<Date> paramNullable) {
/* 421 */     if (paramNullable.hasValue()) {
/* 422 */       this.created = paramNullable;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCreatorProperty(String paramString) {
/* 431 */     this.creator = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDescriptionProperty(String paramString) {
/* 440 */     this.description = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIdentifierProperty(String paramString) {
/* 449 */     this.identifier = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setKeywordsProperty(String paramString) {
/* 458 */     this.keywords = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLanguageProperty(String paramString) {
/* 467 */     this.language = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastModifiedByProperty(String paramString) {
/* 476 */     this.lastModifiedBy = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastPrintedProperty(String paramString) {
/*     */     try {
/* 486 */       this.lastPrinted = setDateValue(paramString);
/* 487 */     } catch (InvalidFormatException invalidFormatException) {
/* 488 */       throw new IllegalArgumentException("lastPrinted  : " + invalidFormatException.getLocalizedMessage(), invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLastPrintedProperty(Nullable<Date> paramNullable) {
/* 499 */     if (paramNullable.hasValue()) {
/* 500 */       this.lastPrinted = paramNullable;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModifiedProperty(String paramString) {
/*     */     try {
/* 510 */       this.modified = setDateValue(paramString);
/* 511 */     } catch (InvalidFormatException invalidFormatException) {
/* 512 */       throw new IllegalArgumentException("modified  : " + invalidFormatException.getLocalizedMessage(), invalidFormatException);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setModifiedProperty(Nullable<Date> paramNullable) {
/* 523 */     if (paramNullable.hasValue()) {
/* 524 */       this.modified = paramNullable;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRevisionProperty(String paramString) {
/* 533 */     this.revision = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSubjectProperty(String paramString) {
/* 542 */     this.subject = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTitleProperty(String paramString) {
/* 551 */     this.title = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVersionProperty(String paramString) {
/* 560 */     this.version = setStringValue(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Nullable<String> setStringValue(String paramString) {
/* 567 */     if (paramString == null || paramString.equals("")) {
/* 568 */       return new Nullable();
/*     */     }
/* 570 */     return new Nullable(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Nullable<Date> setDateValue(String paramString) throws InvalidFormatException {
/* 580 */     if (paramString == null || paramString.equals("")) {
/* 581 */       return new Nullable();
/*     */     }
/*     */     
/* 584 */     Matcher matcher = this.TIME_ZONE_PAT.matcher(paramString);
/* 585 */     if (matcher.find()) {
/* 586 */       String str1 = paramString.substring(0, matcher.start()) + matcher.group(1) + matcher.group(2);
/*     */       
/* 588 */       for (String str2 : this.TZ_DATE_FORMATS) {
/* 589 */         SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str2, Locale.ROOT);
/* 590 */         simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
/* 591 */         Date date = simpleDateFormat.parse(str1, new ParsePosition(0));
/* 592 */         if (date != null) {
/* 593 */           return new Nullable(date);
/*     */         }
/*     */       } 
/*     */     } 
/* 597 */     String str = paramString.endsWith("Z") ? paramString : (paramString + "Z");
/* 598 */     for (String str1 : DATE_FORMATS) {
/* 599 */       SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str1, Locale.ROOT);
/* 600 */       simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
/* 601 */       Date date = simpleDateFormat.parse(str, new ParsePosition(0));
/* 602 */       if (date != null) {
/* 603 */         return new Nullable(date);
/*     */       }
/*     */     } 
/*     */     
/* 607 */     StringBuilder stringBuilder = new StringBuilder();
/* 608 */     byte b = 0;
/* 609 */     for (String str1 : this.TZ_DATE_FORMATS) {
/* 610 */       if (b++ > 0) {
/* 611 */         stringBuilder.append(", ");
/*     */       }
/* 613 */       stringBuilder.append(str1);
/*     */     } 
/* 615 */     for (String str1 : DATE_FORMATS) {
/* 616 */       stringBuilder.append(", ").append(str1);
/*     */     }
/* 618 */     throw new InvalidFormatException("Date " + paramString + " not well formatted, " + "expected format in: " + stringBuilder.toString());
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
/*     */   private String getDateValue(Nullable<Date> paramNullable) {
/* 631 */     if (paramNullable == null) {
/* 632 */       return "";
/*     */     }
/* 634 */     Date date = (Date)paramNullable.getValue();
/* 635 */     if (date == null) {
/* 636 */       return "";
/*     */     }
/*     */     
/* 639 */     SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ROOT);
/* 640 */     simpleDateFormat.setTimeZone(LocaleUtil.TIMEZONE_UTC);
/* 641 */     return simpleDateFormat.format(date);
/*     */   }
/*     */ 
/*     */   
/*     */   protected InputStream getInputStreamImpl() {
/* 646 */     throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
/*     */   }
/*     */ 
/*     */   
/*     */   protected OutputStream getOutputStreamImpl() {
/* 651 */     throw new InvalidOperationException("Can't use output stream to set properties !");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean save(OutputStream paramOutputStream) {
/* 657 */     throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean load(InputStream paramInputStream) {
/* 662 */     throw new InvalidOperationException("Operation not authorized. This part may only be manipulated using the getters and setters on PackagePropertiesPart");
/*     */   }
/*     */   
/*     */   public void close() {}
/*     */   
/*     */   public void flush() {}
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\internal\PackagePropertiesPart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */