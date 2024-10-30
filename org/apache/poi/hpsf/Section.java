/*     */ package org.apache.poi.hpsf;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.poi.hpsf.wellknown.SectionIDMap;
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
/*     */ public class Section
/*     */ {
/*     */   protected Map<Long, String> dictionary;
/*     */   protected ClassID formatID;
/*     */   protected long offset;
/*     */   protected int size;
/*     */   protected Property[] properties;
/*     */   private boolean wasNull;
/*     */   
/*     */   public ClassID getFormatID() {
/*  60 */     return this.formatID;
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
/*     */   public long getOffset() {
/*  78 */     return this.offset;
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
/*     */   public int getSize() {
/*  96 */     return this.size;
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
/*     */   public int getPropertyCount() {
/* 108 */     return this.properties.length;
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
/*     */   public Property[] getProperties() {
/* 126 */     return this.properties;
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
/*     */   protected Section() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Section(byte[] paramArrayOfbyte, int paramInt) throws UnsupportedEncodingException {
/* 153 */     int i = paramInt;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 158 */     this.formatID = new ClassID(paramArrayOfbyte, i);
/* 159 */     i += 16;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 165 */     this.offset = LittleEndian.getUInt(paramArrayOfbyte, i);
/* 166 */     i = (int)this.offset;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 171 */     this.size = (int)LittleEndian.getUInt(paramArrayOfbyte, i);
/* 172 */     i += 4;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 177 */     int j = (int)LittleEndian.getUInt(paramArrayOfbyte, i);
/* 178 */     i += 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 204 */     this.properties = new Property[j];
/*     */ 
/*     */     
/* 207 */     int k = i;
/* 208 */     ArrayList<PropertyListEntry> arrayList = new ArrayList(j);
/*     */     int m;
/* 210 */     for (m = 0; m < this.properties.length; m++) {
/*     */       
/* 212 */       PropertyListEntry propertyListEntry = new PropertyListEntry();
/*     */ 
/*     */       
/* 215 */       propertyListEntry.id = (int)LittleEndian.getUInt(paramArrayOfbyte, k);
/* 216 */       k += 4;
/*     */ 
/*     */       
/* 219 */       propertyListEntry.offset = (int)LittleEndian.getUInt(paramArrayOfbyte, k);
/* 220 */       k += 4;
/*     */ 
/*     */       
/* 223 */       arrayList.add(propertyListEntry);
/*     */     } 
/*     */ 
/*     */     
/* 227 */     Collections.sort(arrayList);
/*     */ 
/*     */     
/* 230 */     for (m = 0; m < j - 1; m++) {
/*     */       
/* 232 */       PropertyListEntry propertyListEntry1 = arrayList.get(m);
/* 233 */       PropertyListEntry propertyListEntry2 = arrayList.get(m + 1);
/* 234 */       propertyListEntry1.length = propertyListEntry2.offset - propertyListEntry1.offset;
/*     */     } 
/* 236 */     if (j > 0) {
/*     */       
/* 238 */       PropertyListEntry propertyListEntry = arrayList.get(j - 1);
/* 239 */       propertyListEntry.length = this.size - propertyListEntry.offset;
/*     */     } 
/*     */ 
/*     */     
/* 243 */     m = -1;
/* 244 */     Iterator<PropertyListEntry> iterator = arrayList.iterator();
/* 245 */     while (m == -1 && iterator.hasNext()) {
/*     */       
/* 247 */       PropertyListEntry propertyListEntry = iterator.next();
/*     */ 
/*     */       
/* 250 */       if (propertyListEntry.id == 1) {
/*     */ 
/*     */ 
/*     */         
/* 254 */         int n = (int)(this.offset + propertyListEntry.offset);
/* 255 */         long l = LittleEndian.getUInt(paramArrayOfbyte, n);
/* 256 */         n += 4;
/*     */         
/* 258 */         if (l != 2L) {
/* 259 */           throw new HPSFRuntimeException("Value type of property ID 1 is not VT_I2 but " + l + ".");
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 264 */         m = LittleEndian.getUShort(paramArrayOfbyte, n);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 270 */     byte b = 0;
/* 271 */     for (PropertyListEntry propertyListEntry : arrayList) {
/*     */ 
/*     */       
/* 274 */       Property property = new Property(propertyListEntry.id, paramArrayOfbyte, this.offset + propertyListEntry.offset, propertyListEntry.length, m);
/*     */ 
/*     */       
/* 277 */       if (property.getID() == 1L)
/* 278 */         property = new Property(property.getID(), property.getType(), Integer.valueOf(m)); 
/* 279 */       this.properties[b++] = property;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 285 */     this.dictionary = (Map<Long, String>)getProperty(0L);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class PropertyListEntry
/*     */     implements Comparable<PropertyListEntry>
/*     */   {
/*     */     int id;
/*     */ 
/*     */ 
/*     */     
/*     */     int offset;
/*     */ 
/*     */ 
/*     */     
/*     */     int length;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int compareTo(PropertyListEntry param1PropertyListEntry) {
/* 309 */       int i = param1PropertyListEntry.offset;
/* 310 */       if (this.offset < i)
/* 311 */         return -1; 
/* 312 */       if (this.offset == i) {
/* 313 */         return 0;
/*     */       }
/* 315 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 321 */       byte b = 31;
/* 322 */       int i = 1;
/* 323 */       i = 31 * i + this.id;
/* 324 */       i = 31 * i + this.length;
/* 325 */       i = 31 * i + this.offset;
/* 326 */       return i;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object param1Object) {
/* 332 */       if (this == param1Object) {
/* 333 */         return true;
/*     */       }
/* 335 */       if (param1Object == null) {
/* 336 */         return false;
/*     */       }
/* 338 */       if (getClass() != param1Object.getClass()) {
/* 339 */         return false;
/*     */       }
/* 341 */       PropertyListEntry propertyListEntry = (PropertyListEntry)param1Object;
/* 342 */       if (this.id != propertyListEntry.id) {
/* 343 */         return false;
/*     */       }
/* 345 */       if (this.length != propertyListEntry.length) {
/* 346 */         return false;
/*     */       }
/* 348 */       if (this.offset != propertyListEntry.offset) {
/* 349 */         return false;
/*     */       }
/* 351 */       return true;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 358 */       StringBuffer stringBuffer = new StringBuffer();
/* 359 */       stringBuffer.append(getClass().getName());
/* 360 */       stringBuffer.append("[id=");
/* 361 */       stringBuffer.append(this.id);
/* 362 */       stringBuffer.append(", offset=");
/* 363 */       stringBuffer.append(this.offset);
/* 364 */       stringBuffer.append(", length=");
/* 365 */       stringBuffer.append(this.length);
/* 366 */       stringBuffer.append(']');
/* 367 */       return stringBuffer.toString();
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
/*     */   public Object getProperty(long paramLong) {
/* 385 */     this.wasNull = false;
/* 386 */     for (byte b = 0; b < this.properties.length; b++) {
/* 387 */       if (paramLong == this.properties[b].getID())
/* 388 */         return this.properties[b].getValue(); 
/* 389 */     }  this.wasNull = true;
/* 390 */     return null;
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
/*     */   protected int getPropertyIntValue(long paramLong) {
/* 409 */     Object object = getProperty(paramLong);
/* 410 */     if (object == null)
/* 411 */       return 0; 
/* 412 */     if (!(object instanceof Long) && !(object instanceof Integer)) {
/* 413 */       throw new HPSFRuntimeException("This property is not an integer type, but " + object.getClass().getName() + ".");
/*     */     }
/*     */     
/* 416 */     Number number = (Number)object;
/* 417 */     return number.intValue();
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
/*     */   protected boolean getPropertyBooleanValue(int paramInt) {
/* 435 */     Boolean bool = (Boolean)getProperty(paramInt);
/* 436 */     if (bool == null) {
/* 437 */       return false;
/*     */     }
/* 439 */     return bool.booleanValue();
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
/*     */   public boolean wasNull() {
/* 467 */     return this.wasNull;
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
/*     */   public String getPIDString(long paramLong) {
/* 484 */     String str = null;
/* 485 */     if (this.dictionary != null) {
/* 486 */       str = this.dictionary.get(Long.valueOf(paramLong));
/*     */     }
/* 488 */     if (str == null) {
/* 489 */       str = SectionIDMap.getPIDString(getFormatID().getBytes(), paramLong);
/*     */     }
/* 491 */     return str;
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
/*     */   public boolean equals(Object paramObject) {
/* 522 */     if (paramObject == null || !(paramObject instanceof Section))
/* 523 */       return false; 
/* 524 */     Section section = (Section)paramObject;
/* 525 */     if (!section.getFormatID().equals(getFormatID())) {
/* 526 */       return false;
/*     */     }
/*     */ 
/*     */     
/* 530 */     Property[] arrayOfProperty1 = new Property[(getProperties()).length];
/* 531 */     Property[] arrayOfProperty2 = new Property[(section.getProperties()).length];
/* 532 */     System.arraycopy(getProperties(), 0, arrayOfProperty1, 0, arrayOfProperty1.length);
/* 533 */     System.arraycopy(section.getProperties(), 0, arrayOfProperty2, 0, arrayOfProperty2.length);
/*     */ 
/*     */ 
/*     */     
/* 537 */     Property property1 = null;
/* 538 */     Property property2 = null; byte b;
/* 539 */     for (b = 0; b < arrayOfProperty1.length; b++) {
/*     */       
/* 541 */       long l = arrayOfProperty1[b].getID();
/* 542 */       if (l == 0L) {
/*     */         
/* 544 */         property1 = arrayOfProperty1[b];
/* 545 */         arrayOfProperty1 = remove(arrayOfProperty1, b);
/* 546 */         b--;
/*     */       } 
/* 548 */       if (l == 1L) {
/*     */ 
/*     */         
/* 551 */         arrayOfProperty1 = remove(arrayOfProperty1, b);
/* 552 */         b--;
/*     */       } 
/*     */     } 
/* 555 */     for (b = 0; b < arrayOfProperty2.length; b++) {
/*     */       
/* 557 */       long l = arrayOfProperty2[b].getID();
/* 558 */       if (l == 0L) {
/*     */         
/* 560 */         property2 = arrayOfProperty2[b];
/* 561 */         arrayOfProperty2 = remove(arrayOfProperty2, b);
/* 562 */         b--;
/*     */       } 
/* 564 */       if (l == 1L) {
/*     */ 
/*     */         
/* 567 */         arrayOfProperty2 = remove(arrayOfProperty2, b);
/* 568 */         b--;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 574 */     if (arrayOfProperty1.length != arrayOfProperty2.length) {
/* 575 */       return false;
/*     */     }
/*     */     
/* 578 */     b = 1;
/* 579 */     if (property1 != null && property2 != null) {
/* 580 */       boolean bool = property1.getValue().equals(property2.getValue());
/* 581 */     } else if (property1 != null || property2 != null) {
/* 582 */       b = 0;
/* 583 */     }  if (b != 0) {
/* 584 */       return Util.equals((Object[])arrayOfProperty1, (Object[])arrayOfProperty2);
/*     */     }
/* 586 */     return false;
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
/*     */   private Property[] remove(Property[] paramArrayOfProperty, int paramInt) {
/* 601 */     Property[] arrayOfProperty = new Property[paramArrayOfProperty.length - 1];
/* 602 */     if (paramInt > 0)
/* 603 */       System.arraycopy(paramArrayOfProperty, 0, arrayOfProperty, 0, paramInt); 
/* 604 */     System.arraycopy(paramArrayOfProperty, paramInt + 1, arrayOfProperty, paramInt, arrayOfProperty.length - paramInt);
/* 605 */     return arrayOfProperty;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 615 */     long l = 0L;
/* 616 */     l += getFormatID().hashCode();
/* 617 */     Property[] arrayOfProperty = getProperties(); int i;
/* 618 */     for (i = 0; i < arrayOfProperty.length; i++)
/* 619 */       l += arrayOfProperty[i].hashCode(); 
/* 620 */     i = (int)(l & 0xFFFFFFFFL);
/* 621 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 631 */     StringBuffer stringBuffer = new StringBuffer();
/* 632 */     Property[] arrayOfProperty = getProperties();
/* 633 */     stringBuffer.append(getClass().getName());
/* 634 */     stringBuffer.append('[');
/* 635 */     stringBuffer.append("formatID: ");
/* 636 */     stringBuffer.append(getFormatID());
/* 637 */     stringBuffer.append(", offset: ");
/* 638 */     stringBuffer.append(getOffset());
/* 639 */     stringBuffer.append(", propertyCount: ");
/* 640 */     stringBuffer.append(getPropertyCount());
/* 641 */     stringBuffer.append(", size: ");
/* 642 */     stringBuffer.append(getSize());
/* 643 */     stringBuffer.append(", properties: [\n");
/* 644 */     for (byte b = 0; b < arrayOfProperty.length; b++) {
/*     */       
/* 646 */       stringBuffer.append(arrayOfProperty[b].toString());
/* 647 */       stringBuffer.append(",\n");
/*     */     } 
/* 649 */     stringBuffer.append(']');
/* 650 */     stringBuffer.append(']');
/* 651 */     return stringBuffer.toString();
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
/*     */   public Map<Long, String> getDictionary() {
/* 668 */     return this.dictionary;
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
/*     */   public int getCodepage() {
/* 680 */     Integer integer = (Integer)getProperty(1L);
/*     */     
/* 682 */     if (integer == null)
/* 683 */       return -1; 
/* 684 */     return integer.intValue();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\hpsf\Section.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */