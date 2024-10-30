/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hpsf.wellknown.PropertyIDMap;
/*     */ import org.apache.poi.hpsf.wellknown.SectionIDMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DocumentSummaryInformation
/*     */   extends SpecialPropertySet
/*     */ {
/*     */   public static final String DEFAULT_STREAM_NAME = "\005DocumentSummaryInformation";
/*     */   
/*     */   public PropertyIDMap getPropertySetIDMap() {
/*  44 */     return PropertyIDMap.getDocumentSummaryInformationProperties();
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
/*     */   public DocumentSummaryInformation(PropertySet paramPropertySet) throws UnexpectedPropertySetTypeException {
/*  60 */     super(paramPropertySet);
/*  61 */     if (!isDocumentSummaryInformation()) {
/*  62 */       throw new UnexpectedPropertySetTypeException("Not a " + getClass().getName());
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
/*     */   public String getCategory() {
/*  74 */     return getPropertyStringValue(2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCategory(String paramString) {
/*  84 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/*  85 */     mutableSection.setProperty(2, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCategory() {
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
/*     */   
/*     */   public String getPresentationFormat() {
/* 107 */     return getPropertyStringValue(3);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPresentationFormat(String paramString) {
/* 117 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 118 */     mutableSection.setProperty(3, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removePresentationFormat() {
/* 126 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 127 */     mutableSection.removeProperty(3L);
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
/*     */   public int getByteCount() {
/* 140 */     return getPropertyIntValue(4);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByteCount(int paramInt) {
/* 150 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 151 */     mutableSection.setProperty(4, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeByteCount() {
/* 159 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 160 */     mutableSection.removeProperty(4L);
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
/*     */   public int getLineCount() {
/* 173 */     return getPropertyIntValue(5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLineCount(int paramInt) {
/* 183 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 184 */     mutableSection.setProperty(5, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLineCount() {
/* 192 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 193 */     mutableSection.removeProperty(5L);
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
/*     */   public int getParCount() {
/* 206 */     return getPropertyIntValue(6);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setParCount(int paramInt) {
/* 216 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 217 */     mutableSection.setProperty(6, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeParCount() {
/* 225 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 226 */     mutableSection.removeProperty(6L);
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
/*     */   public int getSlideCount() {
/* 239 */     return getPropertyIntValue(7);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSlideCount(int paramInt) {
/* 249 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 250 */     mutableSection.setProperty(7, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSlideCount() {
/* 258 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 259 */     mutableSection.removeProperty(7L);
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
/*     */   public int getNoteCount() {
/* 272 */     return getPropertyIntValue(8);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNoteCount(int paramInt) {
/* 282 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 283 */     mutableSection.setProperty(8, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeNoteCount() {
/* 291 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 292 */     mutableSection.removeProperty(8L);
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
/*     */   public int getHiddenCount() {
/* 306 */     return getPropertyIntValue(9);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHiddenCount(int paramInt) {
/* 316 */     MutableSection mutableSection = (MutableSection)getSections().get(0);
/* 317 */     mutableSection.setProperty(9, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHiddenCount() {
/* 325 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 326 */     mutableSection.removeProperty(9L);
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
/*     */   public int getMMClipCount() {
/* 340 */     return getPropertyIntValue(10);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMMClipCount(int paramInt) {
/* 350 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 351 */     mutableSection.setProperty(10, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeMMClipCount() {
/* 359 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 360 */     mutableSection.removeProperty(10L);
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
/*     */   public boolean getScale() {
/* 373 */     return getPropertyBooleanValue(11);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setScale(boolean paramBoolean) {
/* 383 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 384 */     mutableSection.setProperty(11, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeScale() {
/* 392 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 393 */     mutableSection.removeProperty(11L);
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
/*     */   public byte[] getHeadingPair() {
/* 407 */     notYetImplemented("Reading byte arrays ");
/* 408 */     return (byte[])getProperty(12);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeadingPair(byte[] paramArrayOfbyte) {
/* 418 */     notYetImplemented("Writing byte arrays ");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHeadingPair() {
/* 426 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 427 */     mutableSection.removeProperty(12L);
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
/*     */   public byte[] getDocparts() {
/* 441 */     notYetImplemented("Reading byte arrays");
/* 442 */     return (byte[])getProperty(13);
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
/*     */   public void setDocparts(byte[] paramArrayOfbyte) {
/* 454 */     notYetImplemented("Writing byte arrays");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeDocparts() {
/* 462 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 463 */     mutableSection.removeProperty(13L);
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
/*     */   public String getManager() {
/* 475 */     return getPropertyStringValue(14);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setManager(String paramString) {
/* 485 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 486 */     mutableSection.setProperty(14, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeManager() {
/* 494 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 495 */     mutableSection.removeProperty(14L);
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
/*     */   public String getCompany() {
/* 507 */     return getPropertyStringValue(15);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCompany(String paramString) {
/* 517 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 518 */     mutableSection.setProperty(15, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCompany() {
/* 526 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 527 */     mutableSection.removeProperty(15L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getLinksDirty() {
/* 538 */     return getPropertyBooleanValue(16);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLinksDirty(boolean paramBoolean) {
/* 548 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 549 */     mutableSection.setProperty(16, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLinksDirty() {
/* 557 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 558 */     mutableSection.removeProperty(16L);
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
/*     */   public int getCharCountWithSpaces() {
/* 571 */     return getPropertyIntValue(17);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharCountWithSpaces(int paramInt) {
/* 581 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 582 */     mutableSection.setProperty(17, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCharCountWithSpaces() {
/* 590 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 591 */     mutableSection.removeProperty(17L);
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
/*     */   public boolean getHyperlinksChanged() {
/* 604 */     return getPropertyBooleanValue(22);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHyperlinksChanged(boolean paramBoolean) {
/* 615 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 616 */     mutableSection.setProperty(22, paramBoolean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeHyperlinksChanged() {
/* 625 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 626 */     mutableSection.removeProperty(22L);
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
/*     */   public int getApplicationVersion() {
/* 640 */     return getPropertyIntValue(23);
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
/*     */   public void setApplicationVersion(int paramInt) {
/* 652 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 653 */     mutableSection.setProperty(23, paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeApplicationVersion() {
/* 661 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 662 */     mutableSection.removeProperty(23L);
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
/*     */   public byte[] getVBADigitalSignature() {
/* 674 */     Object object = getProperty(24);
/* 675 */     if (object != null && object instanceof byte[]) {
/* 676 */       return (byte[])object;
/*     */     }
/* 678 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setVBADigitalSignature(byte[] paramArrayOfbyte) {
/* 689 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 690 */     mutableSection.setProperty(24, paramArrayOfbyte);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeVBADigitalSignature() {
/* 698 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 699 */     mutableSection.removeProperty(24L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentType() {
/* 710 */     return getPropertyStringValue(26);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentType(String paramString) {
/* 720 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 721 */     mutableSection.setProperty(26, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeContentType() {
/* 729 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 730 */     mutableSection.removeProperty(26L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getContentStatus() {
/* 741 */     return getPropertyStringValue(27);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setContentStatus(String paramString) {
/* 751 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 752 */     mutableSection.setProperty(27, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeContentStatus() {
/* 760 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 761 */     mutableSection.removeProperty(27L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getLanguage() {
/* 772 */     return getPropertyStringValue(28);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLanguage(String paramString) {
/* 782 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 783 */     mutableSection.setProperty(28, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeLanguage() {
/* 791 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 792 */     mutableSection.removeProperty(28L);
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
/*     */   public String getDocumentVersion() {
/* 804 */     return getPropertyStringValue(29);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDocumentVersion(String paramString) {
/* 814 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 815 */     mutableSection.setProperty(29, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeDocumentVersion() {
/* 823 */     MutableSection mutableSection = (MutableSection)getFirstSection();
/* 824 */     mutableSection.removeProperty(29L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CustomProperties getCustomProperties() {
/* 835 */     CustomProperties customProperties = null;
/* 836 */     if (getSectionCount() >= 2) {
/*     */       
/* 838 */       customProperties = new CustomProperties();
/* 839 */       Section section = getSections().get(1);
/* 840 */       Map<Long, String> map = section.getDictionary();
/* 841 */       Property[] arrayOfProperty = section.getProperties();
/* 842 */       byte b1 = 0;
/* 843 */       for (byte b2 = 0; b2 < arrayOfProperty.length; b2++) {
/*     */         
/* 845 */         Property property = arrayOfProperty[b2];
/* 846 */         long l = property.getID();
/* 847 */         if (l != 0L && l != 1L) {
/*     */           
/* 849 */           b1++;
/* 850 */           CustomProperty customProperty = new CustomProperty(property, map.get(Long.valueOf(l)));
/*     */           
/* 852 */           customProperties.put(customProperty.getName(), customProperty);
/*     */         } 
/*     */       } 
/* 855 */       if (customProperties.size() != b1)
/* 856 */         customProperties.setPure(false); 
/*     */     } 
/* 858 */     return customProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCustomProperties(CustomProperties paramCustomProperties) {
/* 868 */     ensureSection2();
/* 869 */     MutableSection mutableSection = (MutableSection)getSections().get(1);
/* 870 */     Map<Long, String> map = paramCustomProperties.getDictionary();
/* 871 */     mutableSection.clear();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 876 */     int i = paramCustomProperties.getCodepage();
/* 877 */     if (i < 0)
/* 878 */       i = mutableSection.getCodepage(); 
/* 879 */     if (i < 0)
/* 880 */       i = 1200; 
/* 881 */     paramCustomProperties.setCodepage(i);
/* 882 */     mutableSection.setCodepage(i);
/* 883 */     mutableSection.setDictionary(map);
/* 884 */     for (Property property : paramCustomProperties.values())
/*     */     {
/*     */       
/* 887 */       mutableSection.setProperty(property);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void ensureSection2() {
/* 897 */     if (getSectionCount() < 2) {
/*     */       
/* 899 */       MutableSection mutableSection = new MutableSection();
/* 900 */       mutableSection.setFormatID(SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[1]);
/* 901 */       addSection(mutableSection);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeCustomProperties() {
/* 910 */     if (getSectionCount() >= 2) {
/* 911 */       getSections().remove(1);
/*     */     } else {
/* 913 */       throw new HPSFRuntimeException("Illegal internal format of Document SummaryInformation stream: second section is missing.");
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
/*     */   private void notYetImplemented(String paramString) {
/* 926 */     throw new UnsupportedOperationException(paramString + " is not yet implemented.");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\DocumentSummaryInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */