/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import org.apache.poi.hpsf.wellknown.SectionIDMap;
/*     */ import org.apache.poi.util.IOUtils;
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
/*     */ public class PropertySet
/*     */ {
/*  64 */   static final byte[] BYTE_ORDER_ASSERTION = new byte[] { -2, -1 };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int byteOrder;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getByteOrder() {
/*  81 */     return this.byteOrder;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  89 */   static final byte[] FORMAT_ASSERTION = new byte[] { 0, 0 };
/*     */   
/*     */   protected int format;
/*     */   
/*     */   protected int osVersion;
/*     */   
/*     */   public static final int OS_WIN16 = 0;
/*     */   
/*     */   public static final int OS_MACINTOSH = 1;
/*     */   
/*     */   public static final int OS_WIN32 = 2;
/*     */   
/*     */   protected ClassID classID;
/*     */   
/*     */   protected List<Section> sections;
/*     */   
/*     */   public int getFormat() {
/* 106 */     return this.format;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOSVersion() {
/* 145 */     return this.osVersion;
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
/*     */   public ClassID getClassID() {
/* 164 */     return this.classID;
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
/*     */   public int getSectionCount() {
/* 177 */     return this.sections.size();
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
/*     */   public List<Section> getSections() {
/* 194 */     return this.sections;
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
/*     */   protected PropertySet() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PropertySet(InputStream paramInputStream) throws NoPropertySetStreamException, MarkUnsupportedException, IOException, UnsupportedEncodingException {
/* 238 */     if (isPropertySetStream(paramInputStream)) {
/*     */       
/* 240 */       int i = paramInputStream.available();
/* 241 */       byte[] arrayOfByte = new byte[i];
/* 242 */       IOUtils.readFully(paramInputStream, arrayOfByte);
/* 243 */       init(arrayOfByte, 0, arrayOfByte.length);
/*     */     } else {
/*     */       
/* 246 */       throw new NoPropertySetStreamException();
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
/*     */   public PropertySet(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws NoPropertySetStreamException, UnsupportedEncodingException {
/* 269 */     if (isPropertySetStream(paramArrayOfbyte, paramInt1, paramInt2)) {
/* 270 */       init(paramArrayOfbyte, paramInt1, paramInt2);
/*     */     } else {
/* 272 */       throw new NoPropertySetStreamException();
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
/*     */   public PropertySet(byte[] paramArrayOfbyte) throws NoPropertySetStreamException, UnsupportedEncodingException {
/* 292 */     this(paramArrayOfbyte, 0, paramArrayOfbyte.length);
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
/*     */   public static boolean isPropertySetStream(InputStream paramInputStream) throws MarkUnsupportedException, IOException {
/* 318 */     byte b = 50;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 325 */     if (!paramInputStream.markSupported())
/* 326 */       throw new MarkUnsupportedException(paramInputStream.getClass().getName()); 
/* 327 */     paramInputStream.mark(50);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 332 */     byte[] arrayOfByte = new byte[50];
/* 333 */     int i = paramInputStream.read(arrayOfByte, 0, Math.min(arrayOfByte.length, paramInputStream.available()));
/*     */ 
/*     */     
/* 336 */     boolean bool = isPropertySetStream(arrayOfByte, 0, i);
/*     */     
/* 338 */     paramInputStream.reset();
/* 339 */     return bool;
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
/*     */   public static boolean isPropertySetStream(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) {
/* 365 */     int i = paramInt1;
/* 366 */     int j = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 367 */     i += 2;
/* 368 */     byte[] arrayOfByte = new byte[2];
/* 369 */     LittleEndian.putShort(arrayOfByte, 0, (short)j);
/* 370 */     if (!Util.equal(arrayOfByte, BYTE_ORDER_ASSERTION))
/* 371 */       return false; 
/* 372 */     int k = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 373 */     i += 2;
/* 374 */     arrayOfByte = new byte[2];
/* 375 */     LittleEndian.putShort(arrayOfByte, 0, (short)k);
/* 376 */     if (!Util.equal(arrayOfByte, FORMAT_ASSERTION)) {
/* 377 */       return false;
/*     */     }
/* 379 */     i += 4;
/*     */     
/* 381 */     i += 16;
/* 382 */     long l = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 383 */     i += 4;
/* 384 */     if (l < 0L)
/* 385 */       return false; 
/* 386 */     return true;
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
/*     */   private void init(byte[] paramArrayOfbyte, int paramInt1, int paramInt2) throws UnsupportedEncodingException {
/* 412 */     int i = paramInt1;
/* 413 */     this.byteOrder = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 414 */     i += 2;
/* 415 */     this.format = LittleEndian.getUShort(paramArrayOfbyte, i);
/* 416 */     i += 2;
/* 417 */     this.osVersion = (int)LittleEndian.getUInt(paramArrayOfbyte, i);
/* 418 */     i += 4;
/* 419 */     this.classID = new ClassID(paramArrayOfbyte, i);
/* 420 */     i += 16;
/* 421 */     int j = LittleEndian.getInt(paramArrayOfbyte, i);
/* 422 */     i += 4;
/* 423 */     if (j < 0) {
/* 424 */       throw new HPSFRuntimeException("Section count " + j + " is negative.");
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 439 */     this.sections = new ArrayList<Section>(j);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 446 */     for (byte b = 0; b < j; b++) {
/*     */       
/* 448 */       Section section = new Section(paramArrayOfbyte, i);
/* 449 */       i += 20;
/* 450 */       this.sections.add(section);
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
/*     */   public boolean isSummaryInformation() {
/* 465 */     if (this.sections.size() <= 0)
/* 466 */       return false; 
/* 467 */     return Util.equal(((Section)this.sections.get(0)).getFormatID().getBytes(), SectionIDMap.SUMMARY_INFORMATION_ID);
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
/*     */   public boolean isDocumentSummaryInformation() {
/* 482 */     if (this.sections.size() <= 0)
/* 483 */       return false; 
/* 484 */     return Util.equal(((Section)this.sections.get(0)).getFormatID().getBytes(), SectionIDMap.DOCUMENT_SUMMARY_INFORMATION_ID[0]);
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
/*     */   public Property[] getProperties() throws NoSingleSectionException {
/* 505 */     return getFirstSection().getProperties();
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
/*     */   protected Object getProperty(int paramInt) throws NoSingleSectionException {
/* 523 */     return getFirstSection().getProperty(paramInt);
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
/*     */   protected boolean getPropertyBooleanValue(int paramInt) throws NoSingleSectionException {
/* 544 */     return getFirstSection().getPropertyBooleanValue(paramInt);
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
/*     */   protected int getPropertyIntValue(int paramInt) throws NoSingleSectionException {
/* 564 */     return getFirstSection().getPropertyIntValue(paramInt);
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
/*     */   public boolean wasNull() throws NoSingleSectionException {
/* 586 */     return getFirstSection().wasNull();
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
/*     */   public Section getFirstSection() {
/* 598 */     if (getSectionCount() < 1)
/* 599 */       throw new MissingSectionException("Property set does not contain any sections."); 
/* 600 */     return this.sections.get(0);
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
/*     */   public Section getSingleSection() {
/* 613 */     int i = getSectionCount();
/* 614 */     if (i != 1) {
/* 615 */       throw new NoSingleSectionException("Property set contains " + i + " sections.");
/*     */     }
/* 617 */     return this.sections.get(0);
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
/*     */   public boolean equals(Object paramObject) {
/* 634 */     if (paramObject == null || !(paramObject instanceof PropertySet))
/* 635 */       return false; 
/* 636 */     PropertySet propertySet = (PropertySet)paramObject;
/* 637 */     int i = propertySet.getByteOrder();
/* 638 */     int j = getByteOrder();
/* 639 */     ClassID classID1 = propertySet.getClassID();
/* 640 */     ClassID classID2 = getClassID();
/* 641 */     int k = propertySet.getFormat();
/* 642 */     int m = getFormat();
/* 643 */     int n = propertySet.getOSVersion();
/* 644 */     int i1 = getOSVersion();
/* 645 */     int i2 = propertySet.getSectionCount();
/* 646 */     int i3 = getSectionCount();
/* 647 */     if (i != j || !classID1.equals(classID2) || k != m || n != i1 || i2 != i3)
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 652 */       return false;
/*     */     }
/*     */     
/* 655 */     return Util.equals(getSections(), propertySet.getSections());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 665 */     throw new UnsupportedOperationException("FIXME: Not yet implemented.");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 675 */     StringBuilder stringBuilder = new StringBuilder();
/* 676 */     int i = getSectionCount();
/* 677 */     stringBuilder.append(getClass().getName());
/* 678 */     stringBuilder.append('[');
/* 679 */     stringBuilder.append("byteOrder: ");
/* 680 */     stringBuilder.append(getByteOrder());
/* 681 */     stringBuilder.append(", classID: ");
/* 682 */     stringBuilder.append(getClassID());
/* 683 */     stringBuilder.append(", format: ");
/* 684 */     stringBuilder.append(getFormat());
/* 685 */     stringBuilder.append(", OSVersion: ");
/* 686 */     stringBuilder.append(getOSVersion());
/* 687 */     stringBuilder.append(", sectionCount: ");
/* 688 */     stringBuilder.append(i);
/* 689 */     stringBuilder.append(", sections: [\n");
/* 690 */     for (Section section : getSections())
/* 691 */       stringBuilder.append(section); 
/* 692 */     stringBuilder.append(']');
/* 693 */     stringBuilder.append(']');
/* 694 */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\PropertySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */