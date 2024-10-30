/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.util.Date;
/*     */ import org.apache.poi.hpsf.wellknown.PropertyIDMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SummaryInformation
/*     */   extends SpecialPropertySet
/*     */ {
/*     */   public static final String DEFAULT_STREAM_NAME = "\005SummaryInformation";
/*     */   
/*     */   public PropertyIDMap getPropertySetIDMap() {
/*  39 */     return PropertyIDMap.getSummaryInformationProperties();
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
/*     */   public SummaryInformation(PropertySet paramPropertySet) throws UnexpectedPropertySetTypeException {
/*  55 */     super(paramPropertySet);
/*  56 */     if (!isSummaryInformation()) {
/*  57 */       throw new UnexpectedPropertySetTypeException("Not a " + getClass().getName());
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
/*     */   public String getTitle() {
/*  70 */     return getPropertyStringValue(2);
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
/*     */   public void setTitle(String paramString) {
/*  82 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/*  83 */     mutableSection.setProperty(2, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTitle() {
/*  93 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/*  94 */     mutableSection.removeProperty(2L);
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
/*     */   public String getSubject() {
/* 106 */     return getPropertyStringValue(3);
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
/*     */   public void setSubject(String paramString) {
/* 118 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 119 */     mutableSection.setProperty(3, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSubject() {
/* 129 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 130 */     mutableSection.removeProperty(3L);
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
/*     */   public String getAuthor() {
/* 142 */     return getPropertyStringValue(4);
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
/*     */   public void setAuthor(String paramString) {
/* 154 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 155 */     mutableSection.setProperty(4, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAuthor() {
/* 165 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 166 */     mutableSection.removeProperty(4L);
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
/*     */   public String getKeywords() {
/* 178 */     return getPropertyStringValue(5);
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
/*     */   public void setKeywords(String paramString) {
/* 190 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 191 */     mutableSection.setProperty(5, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeKeywords() {
/* 201 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 202 */     mutableSection.removeProperty(5L);
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
/*     */   public String getComments() {
/* 214 */     return getPropertyStringValue(6);
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
/*     */   public void setComments(String paramString) {
/* 226 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 227 */     mutableSection.setProperty(6, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeComments() {
/* 237 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 238 */     mutableSection.removeProperty(6L);
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
/*     */   public String getTemplate() {
/* 250 */     return getPropertyStringValue(7);
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
/*     */   public void setTemplate(String paramString) {
/* 262 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 263 */     mutableSection.setProperty(7, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeTemplate() {
/* 273 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 274 */     mutableSection.removeProperty(7L);
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
/*     */   public String getLastAuthor() {
/* 286 */     return getPropertyStringValue(8);
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
/*     */   public void setLastAuthor(String paramString) {
/* 298 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 299 */     mutableSection.setProperty(8, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLastAuthor() {
/* 309 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 310 */     mutableSection.removeProperty(8L);
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
/*     */   public String getRevNumber() {
/* 322 */     return getPropertyStringValue(9);
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
/*     */   public void setRevNumber(String paramString) {
/* 334 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 335 */     mutableSection.setProperty(9, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeRevNumber() {
/* 345 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 346 */     mutableSection.removeProperty(9L);
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
/*     */   public long getEditTime() {
/* 360 */     Date date = (Date)getProperty(10);
/* 361 */     if (date == null) {
/* 362 */       return 0L;
/*     */     }
/* 364 */     return Util.dateToFileTime(date);
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
/*     */   public void setEditTime(long paramLong) {
/* 376 */     Date date = Util.filetimeToDate(paramLong);
/* 377 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 378 */     mutableSection.setProperty(10, 64L, date);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeEditTime() {
/* 388 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 389 */     mutableSection.removeProperty(10L);
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
/*     */   public Date getLastPrinted() {
/* 401 */     return (Date)getProperty(11);
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
/*     */   public void setLastPrinted(Date paramDate) {
/* 413 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 414 */     mutableSection.setProperty(11, 64L, paramDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLastPrinted() {
/* 425 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 426 */     mutableSection.removeProperty(11L);
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
/*     */   public Date getCreateDateTime() {
/* 438 */     return (Date)getProperty(12);
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
/*     */   public void setCreateDateTime(Date paramDate) {
/* 450 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 451 */     mutableSection.setProperty(12, 64L, paramDate);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCreateDateTime() {
/* 462 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 463 */     mutableSection.removeProperty(12L);
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
/*     */   public Date getLastSaveDateTime() {
/* 475 */     return (Date)getProperty(13);
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
/*     */   public void setLastSaveDateTime(Date paramDate) {
/* 487 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 488 */     mutableSection.setProperty(13, 64L, paramDate);
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
/*     */   public void removeLastSaveDateTime() {
/* 500 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 501 */     mutableSection.removeProperty(13L);
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
/*     */   public int getPageCount() {
/* 515 */     return getPropertyIntValue(14);
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
/*     */   public void setPageCount(int paramInt) {
/* 527 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 528 */     mutableSection.setProperty(14, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removePageCount() {
/* 538 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 539 */     mutableSection.removeProperty(14L);
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
/*     */   public int getWordCount() {
/* 552 */     return getPropertyIntValue(15);
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
/*     */   public void setWordCount(int paramInt) {
/* 564 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 565 */     mutableSection.setProperty(15, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeWordCount() {
/* 575 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 576 */     mutableSection.removeProperty(15L);
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
/*     */   public int getCharCount() {
/* 589 */     return getPropertyIntValue(16);
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
/*     */   public void setCharCount(int paramInt) {
/* 601 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 602 */     mutableSection.setProperty(16, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCharCount() {
/* 612 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 613 */     mutableSection.removeProperty(16L);
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
/*     */   public byte[] getThumbnail() {
/* 631 */     return (byte[])getProperty(17);
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
/*     */   public Thumbnail getThumbnailThumbnail() {
/* 643 */     byte[] arrayOfByte = getThumbnail();
/* 644 */     if (arrayOfByte == null) return null; 
/* 645 */     return new Thumbnail(arrayOfByte);
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
/*     */   public void setThumbnail(byte[] paramArrayOfbyte) {
/* 657 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 658 */     mutableSection.setProperty(17, 30L, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeThumbnail() {
/* 669 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 670 */     mutableSection.removeProperty(17L);
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
/*     */   public String getApplicationName() {
/* 682 */     return getPropertyStringValue(18);
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
/*     */   public void setApplicationName(String paramString) {
/* 694 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 695 */     mutableSection.setProperty(18, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeApplicationName() {
/* 705 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 706 */     mutableSection.removeProperty(18L);
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
/*     */   
/*     */   public int getSecurity() {
/* 735 */     return getPropertyIntValue(19);
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
/*     */   public void setSecurity(int paramInt) {
/* 747 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 748 */     mutableSection.setProperty(19, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSecurity() {
/* 758 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 759 */     mutableSection.removeProperty(19L);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\SummaryInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */