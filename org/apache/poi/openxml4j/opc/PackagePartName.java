/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Locale;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.OpenXML4JRuntimeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PackagePartName
/*     */   implements Comparable<PackagePartName>
/*     */ {
/*     */   private URI partNameURI;
/*  49 */   private static String[] RFC3986_PCHAR_SUB_DELIMS = new String[] { "!", "$", "&", "'", "(", ")", "*", "+", ",", ";", "=" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private static String[] RFC3986_PCHAR_UNRESERVED_SUP = new String[] { "-", ".", "_", "~" };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private static String[] RFC3986_PCHAR_AUTHORIZED_SUP = new String[] { ":", "@" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isRelationship;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   PackagePartName(URI paramURI, boolean paramBoolean) throws InvalidFormatException {
/*  84 */     if (paramBoolean) {
/*  85 */       throwExceptionIfInvalidPartUri(paramURI);
/*     */     }
/*  87 */     else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(paramURI)) {
/*  88 */       throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
/*     */     } 
/*     */ 
/*     */     
/*  92 */     this.partNameURI = paramURI;
/*  93 */     this.isRelationship = isRelationshipPartURI(this.partNameURI);
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
/*     */   PackagePartName(String paramString, boolean paramBoolean) throws InvalidFormatException {
/*     */     URI uRI;
/*     */     try {
/* 114 */       uRI = new URI(paramString);
/* 115 */     } catch (URISyntaxException uRISyntaxException) {
/* 116 */       throw new IllegalArgumentException("partName argmument is not a valid OPC part name !");
/*     */     } 
/*     */ 
/*     */     
/* 120 */     if (paramBoolean) {
/* 121 */       throwExceptionIfInvalidPartUri(uRI);
/*     */     }
/* 123 */     else if (!PackagingURIHelper.PACKAGE_ROOT_URI.equals(uRI)) {
/* 124 */       throw new OpenXML4JRuntimeException("OCP conformance must be check for ALL part name except special cases : ['/']");
/*     */     } 
/*     */ 
/*     */     
/* 128 */     this.partNameURI = uRI;
/* 129 */     this.isRelationship = isRelationshipPartURI(this.partNameURI);
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
/*     */   private boolean isRelationshipPartURI(URI paramURI) {
/* 141 */     if (paramURI == null) {
/* 142 */       throw new IllegalArgumentException("partUri");
/*     */     }
/* 144 */     return paramURI.getPath().matches("^.*/" + PackagingURIHelper.RELATIONSHIP_PART_SEGMENT_NAME + "/.*\\" + PackagingURIHelper.RELATIONSHIP_PART_EXTENSION_NAME + "$");
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
/*     */   public boolean isRelationshipPartURI() {
/* 157 */     return this.isRelationship;
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
/*     */   private static void throwExceptionIfInvalidPartUri(URI paramURI) throws InvalidFormatException {
/* 171 */     if (paramURI == null) {
/* 172 */       throw new IllegalArgumentException("partUri");
/*     */     }
/* 174 */     throwExceptionIfEmptyURI(paramURI);
/*     */ 
/*     */     
/* 177 */     throwExceptionIfAbsoluteUri(paramURI);
/*     */ 
/*     */     
/* 180 */     throwExceptionIfPartNameNotStartsWithForwardSlashChar(paramURI);
/*     */ 
/*     */     
/* 183 */     throwExceptionIfPartNameEndsWithForwardSlashChar(paramURI);
/*     */ 
/*     */ 
/*     */     
/* 187 */     throwExceptionIfPartNameHaveInvalidSegments(paramURI);
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
/*     */   private static void throwExceptionIfEmptyURI(URI paramURI) throws InvalidFormatException {
/* 200 */     if (paramURI == null) {
/* 201 */       throw new IllegalArgumentException("partURI");
/*     */     }
/* 203 */     String str = paramURI.getPath();
/* 204 */     if (str.length() == 0 || (str.length() == 1 && str.charAt(0) == PackagingURIHelper.FORWARD_SLASH_CHAR))
/*     */     {
/* 206 */       throw new InvalidFormatException("A part name shall not be empty [M1.1]: " + paramURI.getPath());
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void throwExceptionIfPartNameHaveInvalidSegments(URI paramURI) throws InvalidFormatException {
/* 238 */     if (paramURI == null) {
/* 239 */       throw new IllegalArgumentException("partUri");
/*     */     }
/*     */ 
/*     */     
/* 243 */     String[] arrayOfString = paramURI.toASCIIString().split("/");
/* 244 */     if (arrayOfString.length <= 1 || !arrayOfString[0].equals("")) {
/* 245 */       throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + paramURI.getPath());
/*     */     }
/*     */ 
/*     */     
/* 249 */     for (byte b = 1; b < arrayOfString.length; b++) {
/* 250 */       String str = arrayOfString[b];
/* 251 */       if (str == null || "".equals(str)) {
/* 252 */         throw new InvalidFormatException("A part name shall not have empty segments [M1.3]: " + paramURI.getPath());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 257 */       if (str.endsWith(".")) {
/* 258 */         throw new InvalidFormatException("A segment shall not end with a dot ('.') character [M1.9]: " + paramURI.getPath());
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 263 */       if ("".equals(str.replaceAll("\\\\.", "")))
/*     */       {
/*     */         
/* 266 */         throw new InvalidFormatException("A segment shall include at least one non-dot character. [M1.10]: " + paramURI.getPath());
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 272 */       checkPCharCompliance(str);
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
/*     */   private static void checkPCharCompliance(String paramString) throws InvalidFormatException {
/* 292 */     int i = paramString.length();
/* 293 */     for (byte b = 0; b < i; b++) {
/* 294 */       char c = paramString.charAt(b);
/* 295 */       boolean bool = true;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 300 */       if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
/*     */         
/* 302 */         bool = false;
/*     */       } else {
/*     */         byte b1;
/* 305 */         for (b1 = 0; b1 < RFC3986_PCHAR_UNRESERVED_SUP.length; b1++) {
/* 306 */           if (c == RFC3986_PCHAR_UNRESERVED_SUP[b1].charAt(0)) {
/* 307 */             bool = false;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */         
/* 313 */         b1 = 0;
/* 314 */         for (; bool && b1 < RFC3986_PCHAR_AUTHORIZED_SUP.length; b1++) {
/* 315 */           if (c == RFC3986_PCHAR_AUTHORIZED_SUP[b1].charAt(0)) {
/* 316 */             bool = false;
/*     */           }
/*     */         } 
/*     */ 
/*     */         
/* 321 */         b1 = 0;
/* 322 */         for (; bool && b1 < RFC3986_PCHAR_SUB_DELIMS.length; b1++) {
/* 323 */           if (c == RFC3986_PCHAR_SUB_DELIMS[b1].charAt(0)) {
/* 324 */             bool = false;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 329 */       if (bool && c == '%') {
/*     */ 
/*     */         
/* 332 */         if (i - b < 2) {
/* 333 */           throw new InvalidFormatException("The segment " + paramString + " contain invalid encoded character !");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 339 */         bool = false;
/*     */ 
/*     */         
/* 342 */         char c1 = (char)Integer.parseInt(paramString.substring(b + 1, b + 3), 16);
/*     */         
/* 344 */         b += 2;
/*     */ 
/*     */         
/* 347 */         if (c1 == '/' || c1 == '\\') {
/* 348 */           throw new InvalidFormatException("A segment shall not contain percent-encoded forward slash ('/'), or backward slash ('') characters. [M1.7]");
/*     */         }
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 354 */         if ((c1 >= 'A' && c1 <= 'Z') || (c1 >= 'a' && c1 <= 'z') || (c1 >= '0' && c1 <= '9'))
/*     */         {
/*     */           
/* 357 */           bool = true;
/*     */         }
/*     */         
/* 360 */         byte b1 = 0;
/* 361 */         for (; !bool && b1 < RFC3986_PCHAR_UNRESERVED_SUP.length; b1++) {
/* 362 */           if (c == RFC3986_PCHAR_UNRESERVED_SUP[b1].charAt(0)) {
/* 363 */             bool = true;
/*     */             break;
/*     */           } 
/*     */         } 
/* 367 */         if (bool) {
/* 368 */           throw new InvalidFormatException("A segment shall not contain percent-encoded unreserved characters. [M1.8]");
/*     */         }
/*     */       } 
/*     */       
/* 372 */       if (bool) {
/* 373 */         throw new InvalidFormatException("A segment shall not hold any characters other than pchar characters. [M1.6]");
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
/*     */   private static void throwExceptionIfPartNameNotStartsWithForwardSlashChar(URI paramURI) throws InvalidFormatException {
/* 390 */     String str = paramURI.getPath();
/* 391 */     if (str.length() > 0 && str.charAt(0) != PackagingURIHelper.FORWARD_SLASH_CHAR)
/*     */     {
/* 393 */       throw new InvalidFormatException("A part name shall start with a forward slash ('/') character [M1.4]: " + paramURI.getPath());
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
/*     */   private static void throwExceptionIfPartNameEndsWithForwardSlashChar(URI paramURI) throws InvalidFormatException {
/* 410 */     String str = paramURI.getPath();
/* 411 */     if (str.length() > 0 && str.charAt(str.length() - 1) == PackagingURIHelper.FORWARD_SLASH_CHAR)
/*     */     {
/* 413 */       throw new InvalidFormatException("A part name shall not have a forward slash as the last character [M1.5]: " + paramURI.getPath());
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
/*     */   private static void throwExceptionIfAbsoluteUri(URI paramURI) throws InvalidFormatException {
/* 428 */     if (paramURI.isAbsolute()) {
/* 429 */       throw new InvalidFormatException("Absolute URI forbidden: " + paramURI);
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
/*     */   public int compareTo(PackagePartName paramPackagePartName) {
/* 445 */     return compare(this, paramPackagePartName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getExtension() {
/* 456 */     String str = this.partNameURI.getPath();
/* 457 */     if (str.length() > 0) {
/* 458 */       int i = str.lastIndexOf(".");
/* 459 */       if (i > -1)
/* 460 */         return str.substring(i + 1); 
/*     */     } 
/* 462 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 471 */     return this.partNameURI.toASCIIString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object paramObject) {
/* 482 */     if (paramObject instanceof PackagePartName)
/*     */     {
/* 484 */       return this.partNameURI.toASCIIString().toLowerCase(Locale.ROOT).equals(((PackagePartName)paramObject).partNameURI.toASCIIString().toLowerCase(Locale.ROOT));
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 489 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 495 */     return this.partNameURI.toASCIIString().toLowerCase(Locale.ROOT).hashCode();
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 500 */     return getName();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public URI getURI() {
/* 511 */     return this.partNameURI;
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
/*     */   public static int compare(PackagePartName paramPackagePartName1, PackagePartName paramPackagePartName2) {
/* 535 */     if (paramPackagePartName1 == null)
/*     */     {
/*     */       
/* 538 */       return (paramPackagePartName2 == null) ? 0 : -1;
/*     */     }
/* 540 */     if (paramPackagePartName2 == null)
/*     */     {
/*     */       
/* 543 */       return 1;
/*     */     }
/*     */     
/* 546 */     return compare(paramPackagePartName1.getURI().toASCIIString().toLowerCase(Locale.ROOT), paramPackagePartName2.getURI().toASCIIString().toLowerCase(Locale.ROOT));
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
/*     */   public static int compare(String paramString1, String paramString2) {
/* 565 */     if (paramString1 == null)
/*     */     {
/*     */       
/* 568 */       return (paramString2 == null) ? 0 : -1;
/*     */     }
/* 570 */     if (paramString2 == null)
/*     */     {
/*     */       
/* 573 */       return 1;
/*     */     }
/*     */     
/* 576 */     int i = paramString1.length();
/* 577 */     int j = paramString2.length();
/* 578 */     for (byte b1 = 0, b2 = 0; b1 < i && b2 < j; ) {
/*     */       
/* 580 */       char c1 = paramString1.charAt(b1++);
/* 581 */       char c2 = paramString2.charAt(b2++);
/*     */       
/* 583 */       if (Character.isDigit(c1) && Character.isDigit(c2)) {
/*     */         
/* 585 */         int k = b1 - 1;
/* 586 */         while (b1 < i && Character.isDigit(paramString1.charAt(b1)))
/*     */         {
/* 588 */           b1++;
/*     */         }
/*     */         
/* 591 */         int m = b2 - 1;
/* 592 */         while (b2 < j && Character.isDigit(paramString2.charAt(b2)))
/*     */         {
/* 594 */           b2++;
/*     */         }
/*     */ 
/*     */         
/* 598 */         int n = (new BigInteger(paramString1.substring(k, b1))).compareTo(new BigInteger(paramString2.substring(m, b2)));
/*     */ 
/*     */ 
/*     */         
/* 602 */         if (n != 0) return n;  continue;
/*     */       } 
/* 604 */       if (c1 != c2)
/*     */       {
/* 606 */         return c1 - c2;
/*     */       }
/*     */     } 
/*     */     
/* 610 */     return i - j;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackagePartName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */