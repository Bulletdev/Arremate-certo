/*     */ package org.apache.xmlbeans.soap;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*     */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class SOAPArrayType
/*     */ {
/*     */   private b _type;
/*     */   private int[] _ranks;
/*     */   private int[] _dimensions;
/*     */   
/*     */   public boolean isSameRankAs(SOAPArrayType paramSOAPArrayType) {
/*  47 */     if (this._ranks.length != paramSOAPArrayType._ranks.length)
/*  48 */       return false; 
/*  49 */     for (byte b1 = 0; b1 < this._ranks.length; b1++) {
/*     */       
/*  51 */       if (this._ranks[b1] != paramSOAPArrayType._ranks[b1])
/*  52 */         return false; 
/*     */     } 
/*  54 */     if (this._dimensions.length != paramSOAPArrayType._dimensions.length)
/*  55 */       return false; 
/*  56 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int[] parseSoap11Index(String paramString) {
/*  66 */     paramString = XmlWhitespace.collapse(paramString, 3);
/*  67 */     if (!paramString.startsWith("[") || !paramString.endsWith("]"))
/*  68 */       throw new IllegalArgumentException("Misformed SOAP 1.1 index: must be contained in braces []"); 
/*  69 */     return internalParseCommaIntString(paramString.substring(1, paramString.length() - 1));
/*     */   }
/*     */ 
/*     */   
/*     */   private static int[] internalParseCommaIntString(String paramString) {
/*  74 */     ArrayList arrayList = new ArrayList();
/*  75 */     int i = 0;
/*     */     
/*     */     while (true) {
/*  78 */       int j = paramString.indexOf(',', i);
/*  79 */       if (j < 0) {
/*     */         
/*  81 */         arrayList.add(paramString.substring(i));
/*     */         break;
/*     */       } 
/*  84 */       arrayList.add(paramString.substring(i, j));
/*  85 */       i = j + 1;
/*     */     } 
/*     */     
/*  88 */     int[] arrayOfInt = new int[arrayList.size()];
/*  89 */     i = 0;
/*  90 */     for (Iterator iterator = arrayList.iterator(); iterator.hasNext(); i++) {
/*     */       
/*  92 */       String str = XmlWhitespace.collapse(iterator.next(), 3);
/*  93 */       if (str.equals("*") || str.equals("")) {
/*     */         
/*  95 */         arrayOfInt[i] = -1;
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/* 101 */           arrayOfInt[i] = Integer.parseInt(str);
/*     */         }
/* 103 */         catch (Exception exception) {
/*     */           
/* 105 */           throw new XmlValueOutOfRangeException("Malformed integer in SOAP array index");
/*     */         } 
/*     */       } 
/*     */     } 
/* 109 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SOAPArrayType(String paramString, PrefixResolver paramPrefixResolver) {
/* 120 */     int i = paramString.indexOf('[');
/* 121 */     if (i < 0) {
/* 122 */       throw new XmlValueOutOfRangeException();
/*     */     }
/*     */     
/* 125 */     String str1 = XmlWhitespace.collapse(paramString.substring(0, i), 3);
/* 126 */     int j = str1.indexOf(':');
/* 127 */     String str2 = "";
/* 128 */     if (j >= 0) {
/* 129 */       str2 = str1.substring(0, j);
/*     */     }
/* 131 */     String str3 = paramPrefixResolver.getNamespaceForPrefix(str2);
/* 132 */     if (str3 == null) {
/* 133 */       throw new XmlValueOutOfRangeException();
/*     */     }
/* 135 */     this._type = QNameHelper.forLNS(str1.substring(j + 1), str3);
/*     */     
/* 137 */     initDimensions(paramString, i);
/*     */   }
/*     */   
/* 140 */   private static int[] EMPTY_INT_ARRAY = new int[0];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SOAPArrayType(b paramb, String paramString) {
/* 151 */     int i = paramString.indexOf('[');
/* 152 */     if (i < 0) {
/*     */       
/* 154 */       this._type = paramb;
/* 155 */       this._ranks = EMPTY_INT_ARRAY;
/* 156 */       paramString = XmlWhitespace.collapse(paramString, 3);
/* 157 */       String[] arrayOfString = paramString.split(" ");
/* 158 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/*     */         
/* 160 */         String str = arrayOfString[b1];
/* 161 */         if (str.equals("*")) {
/*     */           
/* 163 */           this._dimensions[b1] = -1;
/*     */         } else {
/*     */           
/*     */           try
/*     */           {
/*     */ 
/*     */             
/* 170 */             this._dimensions[b1] = Integer.parseInt(arrayOfString[b1]);
/*     */           }
/* 172 */           catch (Exception exception)
/*     */           {
/* 174 */             throw new XmlValueOutOfRangeException();
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/*     */     } else {
/*     */       
/* 181 */       this._type = paramb;
/* 182 */       initDimensions(paramString, i);
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
/*     */   public SOAPArrayType(SOAPArrayType paramSOAPArrayType, int[] paramArrayOfint) {
/* 197 */     this._type = paramSOAPArrayType._type;
/*     */     
/* 199 */     this._ranks = new int[paramSOAPArrayType._ranks.length + 1];
/* 200 */     System.arraycopy(paramSOAPArrayType._ranks, 0, this._ranks, 0, paramSOAPArrayType._ranks.length);
/* 201 */     this._ranks[this._ranks.length - 1] = paramSOAPArrayType._dimensions.length;
/*     */     
/* 203 */     this._dimensions = new int[paramArrayOfint.length];
/* 204 */     System.arraycopy(paramArrayOfint, 0, this._dimensions, 0, paramArrayOfint.length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void initDimensions(String paramString, int paramInt) {
/* 212 */     ArrayList arrayList = new ArrayList();
/* 213 */     int i = -1; int j;
/* 214 */     for (j = paramInt; j >= 0; ) {
/*     */       
/* 216 */       i = paramString.indexOf(']', j);
/* 217 */       if (i < 0)
/* 218 */         throw new XmlValueOutOfRangeException(); 
/* 219 */       arrayList.add(paramString.substring(j + 1, i));
/* 220 */       j = paramString.indexOf('[', i);
/*     */     } 
/*     */     
/* 223 */     String str = paramString.substring(i + 1);
/* 224 */     if (!XmlWhitespace.isAllSpace(str)) {
/* 225 */       throw new XmlValueOutOfRangeException();
/*     */     }
/*     */     
/* 228 */     this._ranks = new int[arrayList.size() - 1];
/* 229 */     for (byte b1 = 0; b1 < this._ranks.length; b1++) {
/*     */       
/* 231 */       String str1 = arrayList.get(b1);
/* 232 */       byte b2 = 0;
/* 233 */       for (byte b3 = 0; b3 < str1.length(); b3++) {
/*     */         
/* 235 */         char c = str1.charAt(b3);
/* 236 */         if (c == ',') {
/* 237 */           b2++;
/* 238 */         } else if (!XmlWhitespace.isSpace(c)) {
/* 239 */           throw new XmlValueOutOfRangeException();
/*     */         } 
/* 241 */       }  this._ranks[b1] = b2 + 1;
/*     */     } 
/*     */ 
/*     */     
/* 245 */     this._dimensions = internalParseCommaIntString(arrayList.get(arrayList.size() - 1));
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
/*     */   public b getQName() {
/* 261 */     return this._type;
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
/*     */   public int[] getRanks() {
/* 273 */     int[] arrayOfInt = new int[this._ranks.length];
/* 274 */     System.arraycopy(this._ranks, 0, arrayOfInt, 0, arrayOfInt.length);
/* 275 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] getDimensions() {
/* 283 */     int[] arrayOfInt = new int[this._dimensions.length];
/* 284 */     System.arraycopy(this._dimensions, 0, arrayOfInt, 0, arrayOfInt.length);
/* 285 */     return arrayOfInt;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean containsNestedArrays() {
/* 294 */     return (this._ranks.length > 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String soap11DimensionString() {
/* 302 */     return soap11DimensionString(this._dimensions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String soap11DimensionString(int[] paramArrayOfint) {
/* 312 */     StringBuffer stringBuffer = new StringBuffer(); byte b1;
/* 313 */     for (b1 = 0; b1 < this._ranks.length; b1++) {
/*     */       
/* 315 */       stringBuffer.append('[');
/* 316 */       for (byte b2 = 1; b2 < this._ranks[b1]; b2++)
/* 317 */         stringBuffer.append(','); 
/* 318 */       stringBuffer.append(']');
/*     */     } 
/*     */     
/* 321 */     stringBuffer.append('[');
/* 322 */     for (b1 = 0; b1 < paramArrayOfint.length; b1++) {
/*     */       
/* 324 */       if (b1 > 0)
/* 325 */         stringBuffer.append(','); 
/* 326 */       if (paramArrayOfint[b1] >= 0)
/* 327 */         stringBuffer.append(paramArrayOfint[b1]); 
/*     */     } 
/* 329 */     stringBuffer.append(']');
/* 330 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SOAPArrayType() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SOAPArrayType newSoap12Array(b paramb, String paramString) {
/* 347 */     int[] arrayOfInt1 = EMPTY_INT_ARRAY;
/* 348 */     paramString = XmlWhitespace.collapse(paramString, 3);
/* 349 */     String[] arrayOfString = paramString.split(" ");
/* 350 */     int[] arrayOfInt2 = new int[arrayOfString.length];
/* 351 */     for (byte b1 = 0; b1 < arrayOfString.length; b1++) {
/*     */       
/* 353 */       String str = arrayOfString[b1];
/* 354 */       if (b1 == 0 && str.equals("*")) {
/*     */         
/* 356 */         arrayOfInt2[b1] = -1;
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 363 */           arrayOfInt2[b1] = Integer.parseInt(arrayOfString[b1]);
/*     */         }
/* 365 */         catch (Exception exception) {
/*     */           
/* 367 */           throw new XmlValueOutOfRangeException();
/*     */         } 
/*     */       } 
/*     */     } 
/* 371 */     SOAPArrayType sOAPArrayType = new SOAPArrayType();
/* 372 */     sOAPArrayType._ranks = arrayOfInt1;
/* 373 */     sOAPArrayType._type = paramb;
/* 374 */     sOAPArrayType._dimensions = arrayOfInt2;
/* 375 */     return sOAPArrayType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String soap12DimensionString(int[] paramArrayOfint) {
/* 386 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 388 */     for (byte b1 = 0; b1 < paramArrayOfint.length; b1++) {
/*     */       
/* 390 */       if (b1 > 0)
/* 391 */         stringBuffer.append(' '); 
/* 392 */       if (paramArrayOfint[b1] >= 0)
/* 393 */         stringBuffer.append(paramArrayOfint[b1]); 
/*     */     } 
/* 395 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SOAPArrayType nestedArrayType() {
/* 404 */     if (!containsNestedArrays()) {
/* 405 */       throw new IllegalStateException();
/*     */     }
/* 407 */     SOAPArrayType sOAPArrayType = new SOAPArrayType();
/*     */     
/* 409 */     sOAPArrayType._type = this._type;
/*     */     
/* 411 */     sOAPArrayType._ranks = new int[this._ranks.length - 1];
/* 412 */     System.arraycopy(this._ranks, 0, sOAPArrayType._ranks, 0, sOAPArrayType._ranks.length);
/*     */     
/* 414 */     sOAPArrayType._dimensions = new int[this._ranks[this._ranks.length - 1]];
/* 415 */     for (byte b1 = 0; b1 < sOAPArrayType._dimensions.length; b1++) {
/* 416 */       sOAPArrayType._dimensions[b1] = -1;
/*     */     }
/*     */ 
/*     */     
/* 420 */     return sOAPArrayType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 425 */     return this._type.hashCode() + this._dimensions.length + this._ranks.length + ((this._dimensions.length == 0) ? 0 : this._dimensions[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 430 */     if (paramObject == this) {
/* 431 */       return true;
/*     */     }
/* 433 */     if (!paramObject.getClass().equals(getClass())) {
/* 434 */       return false;
/*     */     }
/* 436 */     SOAPArrayType sOAPArrayType = (SOAPArrayType)paramObject;
/*     */     
/* 438 */     if (!this._type.equals(sOAPArrayType._type)) {
/* 439 */       return false;
/*     */     }
/* 441 */     if (this._ranks.length != sOAPArrayType._ranks.length) {
/* 442 */       return false;
/*     */     }
/* 444 */     if (this._dimensions.length != sOAPArrayType._dimensions.length)
/* 445 */       return false; 
/*     */     byte b1;
/* 447 */     for (b1 = 0; b1 < this._ranks.length; b1++) {
/* 448 */       if (this._ranks[b1] != sOAPArrayType._ranks[b1])
/* 449 */         return false; 
/*     */     } 
/* 451 */     for (b1 = 0; b1 < this._dimensions.length; b1++) {
/* 452 */       if (this._dimensions[b1] != sOAPArrayType._dimensions[b1])
/* 453 */         return false; 
/*     */     } 
/* 455 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\soap\SOAPArrayType.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */