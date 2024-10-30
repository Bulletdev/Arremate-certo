/*     */ package org.apache.xmlbeans.impl.piccolo.xml;
/*     */ 
/*     */ import org.xml.sax.AttributeList;
/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class AttributesHolder
/*     */   implements AttributeList, Attributes
/*     */ {
/*     */   protected int length;
/*     */   protected String[] data;
/*     */   
/*     */   public void addAndCheckAttribute(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) throws SAXException {
/*  46 */     for (byte b = 0; b < this.length; b++) {
/*  47 */       if (this.data[b * 5 + 2] == paramString3)
/*  48 */         throw new FatalParsingException("duplicate attribute '" + paramString3 + "'"); 
/*     */     } 
/*  50 */     addAttribute(paramString1, paramString2, paramString3, paramString4, paramString5);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AttributesHolder() {
/*  60 */     this.length = 0;
/*  61 */     this.data = null;
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
/*     */   public AttributesHolder(Attributes paramAttributes) {
/*  73 */     setAttributes(paramAttributes);
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
/*     */   public int getLength() {
/*  86 */     return this.length;
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
/*     */   public String getURI(int paramInt) {
/*  98 */     if (paramInt >= 0 && paramInt < this.length) {
/*  99 */       return this.data[paramInt * 5];
/*     */     }
/*     */     
/* 102 */     return null;
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
/*     */   public String getLocalName(int paramInt) {
/* 115 */     if (paramInt >= 0 && paramInt < this.length) {
/* 116 */       return this.data[paramInt * 5 + 1];
/*     */     }
/*     */     
/* 119 */     return null;
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
/*     */   public String getName(int paramInt) {
/* 131 */     return getQName(paramInt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getQName(int paramInt) {
/* 142 */     if (paramInt >= 0 && paramInt < this.length) {
/* 143 */       return this.data[paramInt * 5 + 2];
/*     */     }
/*     */     
/* 146 */     return null;
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
/*     */   public String getType(int paramInt) {
/* 159 */     if (paramInt >= 0 && paramInt < this.length) {
/* 160 */       return this.data[paramInt * 5 + 3];
/*     */     }
/*     */     
/* 163 */     return null;
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
/*     */   public String getValue(int paramInt) {
/* 175 */     if (paramInt >= 0 && paramInt < this.length) {
/* 176 */       return this.data[paramInt * 5 + 4];
/*     */     }
/*     */     
/* 179 */     return null;
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
/*     */   public int getIndex(String paramString1, String paramString2) {
/* 197 */     int i = this.length * 5;
/* 198 */     for (byte b = 0; b < i; b += 5) {
/* 199 */       if (this.data[b].equals(paramString1) && this.data[b + 1].equals(paramString2)) {
/* 200 */         return b / 5;
/*     */       }
/*     */     } 
/* 203 */     return -1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIndex(String paramString) {
/* 214 */     int i = this.length * 5;
/* 215 */     for (byte b = 0; b < i; b += 5) {
/* 216 */       if (this.data[b + 2].equals(paramString)) {
/* 217 */         return b / 5;
/*     */       }
/*     */     } 
/* 220 */     return -1;
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
/*     */   public String getType(String paramString1, String paramString2) {
/* 234 */     int i = this.length * 5;
/* 235 */     for (byte b = 0; b < i; b += 5) {
/* 236 */       if (this.data[b].equals(paramString1) && this.data[b + 1].equals(paramString2)) {
/* 237 */         return this.data[b + 3];
/*     */       }
/*     */     } 
/* 240 */     return null;
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
/*     */   public String getType(String paramString) {
/* 252 */     int i = this.length * 5;
/* 253 */     for (byte b = 0; b < i; b += 5) {
/* 254 */       if (this.data[b + 2].equals(paramString)) {
/* 255 */         return this.data[b + 3];
/*     */       }
/*     */     } 
/* 258 */     return null;
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
/*     */   public String getValue(String paramString1, String paramString2) {
/* 272 */     int i = this.length * 5;
/* 273 */     for (byte b = 0; b < i; b += 5) {
/* 274 */       if (this.data[b].equals(paramString1) && this.data[b + 1].equals(paramString2)) {
/* 275 */         return this.data[b + 4];
/*     */       }
/*     */     } 
/* 278 */     return null;
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
/*     */   public String getValue(String paramString) {
/* 290 */     int i = this.length * 5;
/* 291 */     for (byte b = 0; b < i; b += 5) {
/* 292 */       if (this.data[b + 2].equals(paramString)) {
/* 293 */         return this.data[b + 4];
/*     */       }
/*     */     } 
/* 296 */     return null;
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
/*     */   public void clear() {
/* 310 */     this.length = 0;
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
/*     */   public void setAttributes(Attributes paramAttributes) {
/* 322 */     clear();
/* 323 */     this.length = paramAttributes.getLength();
/* 324 */     if (this.length > 0) {
/* 325 */       this.data = new String[this.length * 5];
/* 326 */       for (byte b = 0; b < this.length; b++) {
/* 327 */         this.data[b * 5] = paramAttributes.getURI(b);
/* 328 */         this.data[b * 5 + 1] = paramAttributes.getLocalName(b);
/* 329 */         this.data[b * 5 + 2] = paramAttributes.getQName(b);
/* 330 */         this.data[b * 5 + 3] = paramAttributes.getType(b);
/* 331 */         this.data[b * 5 + 4] = paramAttributes.getValue(b);
/*     */       } 
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
/*     */   public void addAttribute(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
/* 355 */     ensureCapacity(this.length + 1);
/* 356 */     this.data[this.length * 5] = paramString1;
/* 357 */     this.data[this.length * 5 + 1] = paramString2;
/* 358 */     this.data[this.length * 5 + 2] = paramString3;
/* 359 */     this.data[this.length * 5 + 3] = paramString4;
/* 360 */     this.data[this.length * 5 + 4] = paramString5;
/* 361 */     this.length++;
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
/*     */   public void setAttribute(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5) {
/* 387 */     if (paramInt >= 0 && paramInt < this.length) {
/* 388 */       this.data[paramInt * 5] = paramString1;
/* 389 */       this.data[paramInt * 5 + 1] = paramString2;
/* 390 */       this.data[paramInt * 5 + 2] = paramString3;
/* 391 */       this.data[paramInt * 5 + 3] = paramString4;
/* 392 */       this.data[paramInt * 5 + 4] = paramString5;
/*     */     } else {
/*     */       
/* 395 */       badIndex(paramInt);
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
/*     */   public void removeAttribute(int paramInt) {
/* 408 */     if (paramInt >= 0 && paramInt < this.length) {
/* 409 */       this.data[paramInt * 5] = null;
/* 410 */       this.data[paramInt * 5 + 1] = null;
/* 411 */       this.data[paramInt * 5 + 2] = null;
/* 412 */       this.data[paramInt * 5 + 3] = null;
/* 413 */       this.data[paramInt * 5 + 4] = null;
/* 414 */       if (paramInt < this.length - 1) {
/* 415 */         System.arraycopy(this.data, (paramInt + 1) * 5, this.data, paramInt * 5, (this.length - paramInt - 1) * 5);
/*     */       }
/*     */       
/* 418 */       this.length--;
/*     */     } else {
/*     */       
/* 421 */       badIndex(paramInt);
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
/*     */   public void setURI(int paramInt, String paramString) {
/* 436 */     if (paramInt >= 0 && paramInt < this.length) {
/* 437 */       this.data[paramInt * 5] = paramString;
/*     */     } else {
/*     */       
/* 440 */       badIndex(paramInt);
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
/*     */   public void setLocalName(int paramInt, String paramString) {
/* 455 */     if (paramInt >= 0 && paramInt < this.length) {
/* 456 */       this.data[paramInt * 5 + 1] = paramString;
/*     */     } else {
/*     */       
/* 459 */       badIndex(paramInt);
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
/*     */   public void setQName(int paramInt, String paramString) {
/* 474 */     if (paramInt >= 0 && paramInt < this.length) {
/* 475 */       this.data[paramInt * 5 + 2] = paramString;
/*     */     } else {
/*     */       
/* 478 */       badIndex(paramInt);
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
/*     */   public void setType(int paramInt, String paramString) {
/* 492 */     if (paramInt >= 0 && paramInt < this.length) {
/* 493 */       this.data[paramInt * 5 + 3] = paramString;
/*     */     } else {
/*     */       
/* 496 */       badIndex(paramInt);
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
/*     */   public void setValue(int paramInt, String paramString) {
/* 510 */     if (paramInt >= 0 && paramInt < this.length) {
/* 511 */       this.data[paramInt * 5 + 4] = paramString;
/*     */     } else {
/*     */       
/* 514 */       badIndex(paramInt);
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
/*     */   private void ensureCapacity(int paramInt) {
/*     */     int i;
/* 528 */     if (paramInt <= 0) {
/*     */       return;
/*     */     }
/*     */     
/* 532 */     if (this.data == null || this.data.length == 0) {
/* 533 */       i = 25;
/*     */     } else {
/* 535 */       if (this.data.length >= paramInt * 5) {
/*     */         return;
/*     */       }
/*     */       
/* 539 */       i = this.data.length;
/*     */     } 
/* 541 */     while (i < paramInt * 5) {
/* 542 */       i *= 2;
/*     */     }
/* 544 */     String[] arrayOfString = new String[i];
/* 545 */     if (this.length > 0) {
/* 546 */       System.arraycopy(this.data, 0, arrayOfString, 0, this.length * 5);
/*     */     }
/* 548 */     this.data = arrayOfString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void badIndex(int paramInt) throws ArrayIndexOutOfBoundsException {
/* 558 */     String str = "Attempt to modify attribute at illegal index: " + paramInt;
/* 559 */     throw new ArrayIndexOutOfBoundsException(str);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\piccolo\xml\AttributesHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */