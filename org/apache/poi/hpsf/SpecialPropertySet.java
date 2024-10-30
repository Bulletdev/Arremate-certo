/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.OutputStream;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hpsf.wellknown.PropertyIDMap;
/*     */ import org.apache.poi.poifs.filesystem.DirectoryEntry;
/*     */ import org.apache.poi.util.LittleEndian;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SpecialPropertySet
/*     */   extends MutablePropertySet
/*     */ {
/*     */   private final MutablePropertySet delegate;
/*     */   
/*     */   public abstract PropertyIDMap getPropertySetIDMap();
/*     */   
/*     */   public SpecialPropertySet(PropertySet paramPropertySet) {
/*  81 */     this.delegate = new MutablePropertySet(paramPropertySet);
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
/*     */   public SpecialPropertySet(MutablePropertySet paramMutablePropertySet) {
/*  94 */     this.delegate = paramMutablePropertySet;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getByteOrder() {
/* 105 */     return this.delegate.getByteOrder();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFormat() {
/* 116 */     return this.delegate.getFormat();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOSVersion() {
/* 127 */     return this.delegate.getOSVersion();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ClassID getClassID() {
/* 138 */     return this.delegate.getClassID();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSectionCount() {
/* 149 */     return this.delegate.getSectionCount();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<Section> getSections() {
/* 160 */     return this.delegate.getSections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSummaryInformation() {
/* 171 */     return this.delegate.isSummaryInformation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDocumentSummaryInformation() {
/* 182 */     return this.delegate.isDocumentSummaryInformation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Section getFirstSection() {
/* 193 */     return this.delegate.getFirstSection();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void addSection(Section paramSection) {
/* 203 */     this.delegate.addSection(paramSection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearSections() {
/* 214 */     this.delegate.clearSections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByteOrder(int paramInt) {
/* 225 */     this.delegate.setByteOrder(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClassID(ClassID paramClassID) {
/* 236 */     this.delegate.setClassID(paramClassID);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFormat(int paramInt) {
/* 247 */     this.delegate.setFormat(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setOSVersion(int paramInt) {
/* 258 */     this.delegate.setOSVersion(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public InputStream toInputStream() throws IOException, WritingNotSupportedException {
/* 269 */     return this.delegate.toInputStream();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(DirectoryEntry paramDirectoryEntry, String paramString) throws WritingNotSupportedException, IOException {
/* 280 */     this.delegate.write(paramDirectoryEntry, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(OutputStream paramOutputStream) throws WritingNotSupportedException, IOException {
/* 289 */     this.delegate.write(paramOutputStream);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 298 */     return this.delegate.equals(paramObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Property[] getProperties() throws NoSingleSectionException {
/* 307 */     return this.delegate.getProperties();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object getProperty(int paramInt) throws NoSingleSectionException {
/* 316 */     return this.delegate.getProperty(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean getPropertyBooleanValue(int paramInt) throws NoSingleSectionException {
/* 327 */     return this.delegate.getPropertyBooleanValue(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getPropertyIntValue(int paramInt) throws NoSingleSectionException {
/* 338 */     return this.delegate.getPropertyIntValue(paramInt);
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
/*     */   protected String getPropertyStringValue(int paramInt) {
/* 352 */     Object object = getProperty(paramInt);
/* 353 */     return getPropertyStringValue(object);
/*     */   }
/*     */   
/*     */   protected static String getPropertyStringValue(Object paramObject) {
/* 357 */     if (paramObject == null) return null; 
/* 358 */     if (paramObject instanceof String) return (String)paramObject;
/*     */ 
/*     */     
/* 361 */     if (paramObject instanceof byte[]) {
/* 362 */       byte[] arrayOfByte = (byte[])paramObject;
/* 363 */       if (arrayOfByte.length == 0) {
/* 364 */         return "";
/*     */       }
/* 366 */       if (arrayOfByte.length == 1) {
/* 367 */         return Byte.toString(arrayOfByte[0]);
/*     */       }
/* 369 */       if (arrayOfByte.length == 2) {
/* 370 */         return Integer.toString(LittleEndian.getUShort(arrayOfByte));
/*     */       }
/* 372 */       if (arrayOfByte.length == 4) {
/* 373 */         return Long.toString(LittleEndian.getUInt(arrayOfByte));
/*     */       }
/*     */       
/* 376 */       return new String(arrayOfByte, Charset.forName("ASCII"));
/*     */     } 
/* 378 */     return paramObject.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 388 */     return this.delegate.hashCode();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 399 */     return this.delegate.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean wasNull() throws NoSingleSectionException {
/* 410 */     return this.delegate.wasNull();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\SpecialPropertySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */