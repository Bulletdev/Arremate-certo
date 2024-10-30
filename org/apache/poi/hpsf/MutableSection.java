/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.ByteArrayOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.OutputStream;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.ListIterator;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.util.CodePageUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MutableSection
/*     */   extends Section
/*     */ {
/*     */   private boolean dirty = true;
/*     */   private List<Property> preprops;
/*     */   private byte[] sectionBytes;
/*     */   
/*     */   public MutableSection() {
/*  75 */     this.dirty = true;
/*  76 */     this.formatID = null;
/*  77 */     this.offset = -1L;
/*  78 */     this.preprops = new LinkedList<Property>();
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
/*     */   public MutableSection(Section paramSection) {
/*  93 */     setFormatID(paramSection.getFormatID());
/*  94 */     Property[] arrayOfProperty = paramSection.getProperties();
/*  95 */     MutableProperty[] arrayOfMutableProperty = new MutableProperty[arrayOfProperty.length];
/*  96 */     for (byte b = 0; b < arrayOfProperty.length; b++)
/*  97 */       arrayOfMutableProperty[b] = new MutableProperty(arrayOfProperty[b]); 
/*  98 */     setProperties((Property[])arrayOfMutableProperty);
/*  99 */     setDictionary(paramSection.getDictionary());
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
/*     */   public void setFormatID(ClassID paramClassID) {
/* 114 */     this.formatID = paramClassID;
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
/*     */   public void setFormatID(byte[] paramArrayOfbyte) {
/* 130 */     ClassID classID = getFormatID();
/* 131 */     if (classID == null) {
/*     */       
/* 133 */       classID = new ClassID();
/* 134 */       setFormatID(classID);
/*     */     } 
/* 136 */     classID.setBytes(paramArrayOfbyte);
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
/*     */   public void setProperties(Property[] paramArrayOfProperty) {
/* 148 */     this.properties = paramArrayOfProperty;
/* 149 */     this.preprops = new LinkedList<Property>();
/* 150 */     for (byte b = 0; b < paramArrayOfProperty.length; b++)
/* 151 */       this.preprops.add(paramArrayOfProperty[b]); 
/* 152 */     this.dirty = true;
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
/*     */   public void setProperty(int paramInt, String paramString) {
/* 169 */     setProperty(paramInt, 31L, paramString);
/* 170 */     this.dirty = true;
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
/*     */   public void setProperty(int paramInt1, int paramInt2) {
/* 186 */     setProperty(paramInt1, 3L, Integer.valueOf(paramInt2));
/* 187 */     this.dirty = true;
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
/*     */   public void setProperty(int paramInt, long paramLong) {
/* 203 */     setProperty(paramInt, 20L, Long.valueOf(paramLong));
/* 204 */     this.dirty = true;
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
/*     */   public void setProperty(int paramInt, boolean paramBoolean) {
/* 220 */     setProperty(paramInt, 11L, Boolean.valueOf(paramBoolean));
/* 221 */     this.dirty = true;
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
/*     */   public void setProperty(int paramInt, long paramLong, Object paramObject) {
/* 244 */     MutableProperty mutableProperty = new MutableProperty();
/* 245 */     mutableProperty.setID(paramInt);
/* 246 */     mutableProperty.setType(paramLong);
/* 247 */     mutableProperty.setValue(paramObject);
/* 248 */     setProperty(mutableProperty);
/* 249 */     this.dirty = true;
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
/*     */   public void setProperty(Property paramProperty) {
/* 265 */     long l = paramProperty.getID();
/* 266 */     removeProperty(l);
/* 267 */     this.preprops.add(paramProperty);
/* 268 */     this.dirty = true;
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
/*     */   public void removeProperty(long paramLong) {
/* 280 */     for (Iterator<Property> iterator = this.preprops.iterator(); iterator.hasNext();) {
/* 281 */       if (((Property)iterator.next()).getID() == paramLong) {
/*     */         
/* 283 */         iterator.remove(); break;
/*     */       } 
/*     */     } 
/* 286 */     this.dirty = true;
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
/*     */   protected void setPropertyBooleanValue(int paramInt, boolean paramBoolean) {
/* 304 */     setProperty(paramInt, 11L, Boolean.valueOf(paramBoolean));
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
/*     */   public int getSize() {
/* 316 */     if (this.dirty) {
/*     */       
/*     */       try {
/*     */         
/* 320 */         this.size = calcSize();
/* 321 */         this.dirty = false;
/*     */       }
/* 323 */       catch (HPSFRuntimeException hPSFRuntimeException) {
/*     */         
/* 325 */         throw hPSFRuntimeException;
/*     */       }
/* 327 */       catch (Exception exception) {
/*     */         
/* 329 */         throw new HPSFRuntimeException(exception);
/*     */       } 
/*     */     }
/* 332 */     return this.size;
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
/*     */   private int calcSize() throws WritingNotSupportedException, IOException {
/* 348 */     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/* 349 */     write(byteArrayOutputStream);
/* 350 */     byteArrayOutputStream.close();
/*     */ 
/*     */     
/* 353 */     this.sectionBytes = Util.pad4(byteArrayOutputStream.toByteArray());
/* 354 */     return this.sectionBytes.length;
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
/*     */   public int write(OutputStream paramOutputStream) throws WritingNotSupportedException, IOException {
/* 379 */     if (!this.dirty && this.sectionBytes != null) {
/*     */       
/* 381 */       paramOutputStream.write(this.sectionBytes);
/* 382 */       return this.sectionBytes.length;
/*     */     } 
/*     */ 
/*     */     
/* 386 */     ByteArrayOutputStream byteArrayOutputStream1 = new ByteArrayOutputStream();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 392 */     ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
/*     */ 
/*     */ 
/*     */     
/* 396 */     int i = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     i += 8 + getPropertyCount() * 2 * 4;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 406 */     int j = -1;
/* 407 */     if (getProperty(0L) != null) {
/*     */       
/* 409 */       Object object = getProperty(1L);
/* 410 */       if (object != null) {
/*     */         
/* 412 */         if (!(object instanceof Integer)) {
/* 413 */           throw new IllegalPropertySetDataException("The codepage property (ID = 1) must be an Integer object.");
/*     */         
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 421 */         setProperty(1, 2L, Integer.valueOf(1200));
/*     */       } 
/* 423 */       j = getCodepage();
/*     */     } 
/*     */ 
/*     */     
/* 427 */     Collections.sort(this.preprops, new Comparator<Property>()
/*     */         {
/*     */           public int compare(Property param1Property1, Property param1Property2)
/*     */           {
/* 431 */             if (param1Property1.getID() < param1Property2.getID())
/* 432 */               return -1; 
/* 433 */             if (param1Property1.getID() == param1Property2.getID()) {
/* 434 */               return 0;
/*     */             }
/* 436 */             return 1;
/*     */           }
/*     */         });
/*     */ 
/*     */ 
/*     */     
/* 442 */     for (ListIterator<Property> listIterator = this.preprops.listIterator(); listIterator.hasNext(); ) {
/*     */       
/* 444 */       MutableProperty mutableProperty = (MutableProperty)listIterator.next();
/* 445 */       long l = mutableProperty.getID();
/*     */ 
/*     */       
/* 448 */       TypeWriter.writeUIntToStream(byteArrayOutputStream2, mutableProperty.getID());
/* 449 */       TypeWriter.writeUIntToStream(byteArrayOutputStream2, i);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 455 */       if (l != 0L) {
/*     */ 
/*     */         
/* 458 */         i += mutableProperty.write(byteArrayOutputStream1, getCodepage());
/*     */         continue;
/*     */       } 
/* 461 */       if (j == -1) {
/* 462 */         throw new IllegalPropertySetDataException("Codepage (property 1) is undefined.");
/*     */       }
/* 464 */       i += writeDictionary(byteArrayOutputStream1, this.dictionary, j);
/*     */     } 
/*     */ 
/*     */     
/* 468 */     byteArrayOutputStream1.close();
/* 469 */     byteArrayOutputStream2.close();
/*     */ 
/*     */     
/* 472 */     byte[] arrayOfByte1 = byteArrayOutputStream2.toByteArray();
/* 473 */     byte[] arrayOfByte2 = byteArrayOutputStream1.toByteArray();
/*     */ 
/*     */     
/* 476 */     TypeWriter.writeToStream(paramOutputStream, 8 + arrayOfByte1.length + arrayOfByte2.length);
/*     */ 
/*     */ 
/*     */     
/* 480 */     TypeWriter.writeToStream(paramOutputStream, getPropertyCount());
/*     */ 
/*     */     
/* 483 */     paramOutputStream.write(arrayOfByte1);
/*     */ 
/*     */     
/* 486 */     paramOutputStream.write(arrayOfByte2);
/*     */     
/* 488 */     return 8 + arrayOfByte1.length + arrayOfByte2.length;
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
/*     */   private static int writeDictionary(OutputStream paramOutputStream, Map<Long, String> paramMap, int paramInt) throws IOException {
/* 507 */     int i = TypeWriter.writeUIntToStream(paramOutputStream, paramMap.size());
/* 508 */     for (Map.Entry<Long, String> entry : paramMap.entrySet()) {
/* 509 */       Long long_ = (Long)entry.getKey();
/* 510 */       String str = (String)entry.getValue();
/*     */       
/* 512 */       if (paramInt == 1200) {
/*     */ 
/*     */         
/* 515 */         int j = str.length() + 1;
/* 516 */         if ((j & 0x1) == 1) {
/* 517 */           j++;
/*     */         }
/* 519 */         i += TypeWriter.writeUIntToStream(paramOutputStream, long_.longValue());
/* 520 */         i += TypeWriter.writeUIntToStream(paramOutputStream, j);
/* 521 */         byte[] arrayOfByte1 = CodePageUtil.getBytesInCodePage(str, paramInt);
/* 522 */         for (byte b1 = 2; b1 < arrayOfByte1.length; b1 += 2) {
/*     */           
/* 524 */           paramOutputStream.write(arrayOfByte1[b1 + 1]);
/* 525 */           paramOutputStream.write(arrayOfByte1[b1]);
/* 526 */           i += 2;
/*     */         } 
/* 528 */         j -= str.length();
/* 529 */         while (j > 0) {
/*     */           
/* 531 */           paramOutputStream.write(0);
/* 532 */           paramOutputStream.write(0);
/* 533 */           i += 2;
/* 534 */           j--;
/*     */         } 
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/* 541 */       i += TypeWriter.writeUIntToStream(paramOutputStream, long_.longValue());
/* 542 */       i += TypeWriter.writeUIntToStream(paramOutputStream, (str.length() + 1));
/* 543 */       byte[] arrayOfByte = CodePageUtil.getBytesInCodePage(str, paramInt);
/* 544 */       for (byte b = 0; b < arrayOfByte.length; b++) {
/*     */         
/* 546 */         paramOutputStream.write(arrayOfByte[b]);
/* 547 */         i++;
/*     */       } 
/* 549 */       paramOutputStream.write(0);
/* 550 */       i++;
/*     */     } 
/*     */     
/* 553 */     return i;
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
/*     */   public int getPropertyCount() {
/* 567 */     return this.preprops.size();
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
/*     */   public Property[] getProperties() {
/* 579 */     this.properties = this.preprops.<Property>toArray(new Property[0]);
/* 580 */     return this.properties;
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
/*     */   public Object getProperty(long paramLong) {
/* 595 */     getProperties();
/* 596 */     return super.getProperty(paramLong);
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
/*     */   public void setDictionary(Map<Long, String> paramMap) throws IllegalPropertySetDataException {
/* 620 */     if (paramMap != null) {
/*     */       
/* 622 */       this.dictionary = paramMap;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 627 */       setProperty(0, -1L, paramMap);
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 632 */       Integer integer = (Integer)getProperty(1L);
/*     */       
/* 634 */       if (integer == null) {
/* 635 */         setProperty(1, 2L, Integer.valueOf(1200));
/*     */       
/*     */       }
/*     */     }
/*     */     else {
/*     */       
/* 641 */       removeProperty(0L);
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
/*     */   public void setProperty(int paramInt, Object paramObject) {
/* 655 */     if (paramObject instanceof String) {
/* 656 */       setProperty(paramInt, (String)paramObject);
/* 657 */     } else if (paramObject instanceof Long) {
/* 658 */       setProperty(paramInt, ((Long)paramObject).longValue());
/* 659 */     } else if (paramObject instanceof Integer) {
/* 660 */       setProperty(paramInt, ((Integer)paramObject).intValue());
/* 661 */     } else if (paramObject instanceof Short) {
/* 662 */       setProperty(paramInt, ((Short)paramObject).intValue());
/* 663 */     } else if (paramObject instanceof Boolean) {
/* 664 */       setProperty(paramInt, ((Boolean)paramObject).booleanValue());
/* 665 */     } else if (paramObject instanceof java.util.Date) {
/* 666 */       setProperty(paramInt, 64L, paramObject);
/*     */     } else {
/* 668 */       throw new HPSFRuntimeException("HPSF does not support properties of type " + paramObject.getClass().getName() + ".");
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
/*     */   public void clear() {
/* 681 */     Property[] arrayOfProperty = getProperties();
/* 682 */     for (byte b = 0; b < arrayOfProperty.length; b++) {
/*     */       
/* 684 */       Property property = arrayOfProperty[b];
/* 685 */       removeProperty(property.getID());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCodepage(int paramInt) {
/* 696 */     setProperty(1, 2L, Integer.valueOf(paramInt));
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\MutableSection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */