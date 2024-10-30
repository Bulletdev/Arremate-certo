/*     */ package org.apache.poi.openxml4j.opc;
/*     */ 
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.nio.ByteBuffer;
/*     */ import java.nio.charset.Charset;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
/*     */ import org.apache.poi.openxml4j.exceptions.InvalidOperationException;
/*     */ import org.apache.poi.util.POILogFactory;
/*     */ import org.apache.poi.util.POILogger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class PackagingURIHelper
/*     */ {
/*  38 */   private static final POILogger _logger = POILogFactory.getLogger(PackagingURIHelper.class);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static URI packageRootUri;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String RELATIONSHIP_PART_EXTENSION_NAME;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PACKAGE_PROPERTIES_SEGMENT_NAME;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String PACKAGE_CORE_PROPERTIES_NAME;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char FORWARD_SLASH_CHAR;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final String FORWARD_SLASH_STRING;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final URI PACKAGE_RELATIONSHIPS_ROOT_URI;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final PackagePartName PACKAGE_RELATIONSHIPS_ROOT_PART_NAME;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final URI CORE_PROPERTIES_URI;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final PackagePartName CORE_PROPERTIES_PART_NAME;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final URI PACKAGE_ROOT_URI;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final PackagePartName PACKAGE_ROOT_PART_NAME;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Pattern missingAuthPattern;
/*     */ 
/*     */ 
/*     */   
/*     */   private static final char[] hexDigits;
/*     */ 
/*     */ 
/*     */   
/* 107 */   public static final String RELATIONSHIP_PART_SEGMENT_NAME = "_rels"; static {
/* 108 */     RELATIONSHIP_PART_EXTENSION_NAME = ".rels";
/* 109 */     FORWARD_SLASH_CHAR = '/';
/* 110 */     FORWARD_SLASH_STRING = "/";
/* 111 */     PACKAGE_PROPERTIES_SEGMENT_NAME = "docProps";
/* 112 */     PACKAGE_CORE_PROPERTIES_NAME = "core.xml";
/*     */ 
/*     */     
/* 115 */     URI uRI1 = null;
/* 116 */     URI uRI2 = null;
/* 117 */     URI uRI3 = null;
/*     */     try {
/* 119 */       uRI1 = new URI("/");
/* 120 */       uRI2 = new URI(FORWARD_SLASH_CHAR + RELATIONSHIP_PART_SEGMENT_NAME + FORWARD_SLASH_CHAR + RELATIONSHIP_PART_EXTENSION_NAME);
/*     */ 
/*     */       
/* 123 */       packageRootUri = new URI("/");
/* 124 */       uRI3 = new URI(FORWARD_SLASH_CHAR + PACKAGE_PROPERTIES_SEGMENT_NAME + FORWARD_SLASH_CHAR + PACKAGE_CORE_PROPERTIES_NAME);
/*     */     
/*     */     }
/* 127 */     catch (URISyntaxException uRISyntaxException) {}
/*     */ 
/*     */     
/* 130 */     PACKAGE_ROOT_URI = uRI1;
/* 131 */     PACKAGE_RELATIONSHIPS_ROOT_URI = uRI2;
/* 132 */     CORE_PROPERTIES_URI = uRI3;
/*     */ 
/*     */     
/* 135 */     PackagePartName packagePartName1 = null;
/* 136 */     PackagePartName packagePartName2 = null;
/* 137 */     PackagePartName packagePartName3 = null;
/*     */     try {
/* 139 */       packagePartName2 = createPartName(PACKAGE_RELATIONSHIPS_ROOT_URI);
/* 140 */       packagePartName3 = createPartName(CORE_PROPERTIES_URI);
/* 141 */       packagePartName1 = new PackagePartName(PACKAGE_ROOT_URI, false);
/*     */     }
/* 143 */     catch (InvalidFormatException invalidFormatException) {}
/*     */ 
/*     */     
/* 146 */     PACKAGE_RELATIONSHIPS_ROOT_PART_NAME = packagePartName2;
/* 147 */     CORE_PROPERTIES_PART_NAME = packagePartName3;
/* 148 */     PACKAGE_ROOT_PART_NAME = packagePartName1;
/*     */ 
/*     */     
/* 151 */     missingAuthPattern = Pattern.compile("\\w+://");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 767 */     hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/*     */   }
/*     */   public static URI getPackageRootUri() {
/*     */     return packageRootUri;
/*     */   }
/*     */   private static boolean isUnsafe(int paramInt) {
/* 773 */     return (paramInt > 128 || Character.isWhitespace(paramInt));
/*     */   }
/*     */   
/*     */   public static boolean isRelationshipPartURI(URI paramURI) {
/*     */     if (paramURI == null)
/*     */       throw new IllegalArgumentException("partUri"); 
/*     */     return paramURI.getPath().matches(".*" + RELATIONSHIP_PART_SEGMENT_NAME + ".*" + RELATIONSHIP_PART_EXTENSION_NAME + "$");
/*     */   }
/*     */   
/*     */   public static String getFilename(URI paramURI) {
/*     */     if (paramURI != null) {
/*     */       String str = paramURI.getPath();
/*     */       int i = str.length();
/*     */       int j = i;
/*     */       while (--j >= 0) {
/*     */         char c = str.charAt(j);
/*     */         if (c == FORWARD_SLASH_CHAR)
/*     */           return str.substring(j + 1, i); 
/*     */       } 
/*     */     } 
/*     */     return "";
/*     */   }
/*     */   
/*     */   public static String getFilenameWithoutExtension(URI paramURI) {
/*     */     String str = getFilename(paramURI);
/*     */     int i = str.lastIndexOf(".");
/*     */     if (i == -1)
/*     */       return str; 
/*     */     return str.substring(0, i);
/*     */   }
/*     */   
/*     */   public static URI getPath(URI paramURI) {
/*     */     if (paramURI != null) {
/*     */       String str = paramURI.getPath();
/*     */       int i = str.length();
/*     */       int j = i;
/*     */       while (--j >= 0) {
/*     */         char c = str.charAt(j);
/*     */         if (c == FORWARD_SLASH_CHAR)
/*     */           try {
/*     */             return new URI(str.substring(0, j));
/*     */           } catch (URISyntaxException uRISyntaxException) {
/*     */             return null;
/*     */           }  
/*     */       } 
/*     */     } 
/*     */     return null;
/*     */   }
/*     */   
/*     */   public static URI combine(URI paramURI1, URI paramURI2) {
/*     */     URI uRI = null;
/*     */     try {
/*     */       uRI = new URI(combine(paramURI1.getPath(), paramURI2.getPath()));
/*     */     } catch (URISyntaxException uRISyntaxException) {
/*     */       throw new IllegalArgumentException("Prefix and suffix can't be combine !");
/*     */     } 
/*     */     return uRI;
/*     */   }
/*     */   
/*     */   public static String combine(String paramString1, String paramString2) {
/*     */     if (!paramString1.endsWith("" + FORWARD_SLASH_CHAR) && !paramString2.startsWith("" + FORWARD_SLASH_CHAR))
/*     */       return paramString1 + FORWARD_SLASH_CHAR + paramString2; 
/*     */     if ((!paramString1.endsWith("" + FORWARD_SLASH_CHAR) && paramString2.startsWith("" + FORWARD_SLASH_CHAR)) || (paramString1.endsWith("" + FORWARD_SLASH_CHAR) && !paramString2.startsWith("" + FORWARD_SLASH_CHAR)))
/*     */       return paramString1 + paramString2; 
/*     */     return "";
/*     */   }
/*     */   
/*     */   public static URI relativizeURI(URI paramURI1, URI paramURI2, boolean paramBoolean) {
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     String[] arrayOfString1 = paramURI1.getPath().split("/", -1);
/*     */     String[] arrayOfString2 = paramURI2.getPath().split("/", -1);
/*     */     if (arrayOfString1.length == 0)
/*     */       throw new IllegalArgumentException("Can't relativize an empty source URI !"); 
/*     */     if (arrayOfString2.length == 0)
/*     */       throw new IllegalArgumentException("Can't relativize an empty target URI !"); 
/*     */     if (paramURI1.toString().equals("/")) {
/*     */       String str1 = paramURI2.getPath();
/*     */       if (paramBoolean && str1.length() > 0 && str1.charAt(0) == '/')
/*     */         try {
/*     */           paramURI2 = new URI(str1.substring(1));
/*     */         } catch (Exception exception) {
/*     */           _logger.log(5, new Object[] { exception });
/*     */           return null;
/*     */         }  
/*     */       return paramURI2;
/*     */     } 
/*     */     byte b1 = 0;
/*     */     byte b2;
/*     */     for (b2 = 0; b2 < arrayOfString1.length && b2 < arrayOfString2.length && arrayOfString1[b2].equals(arrayOfString2[b2]); b2++)
/*     */       b1++; 
/*     */     if ((b1 == 0 || b1 == 1) && arrayOfString1[0].equals("") && arrayOfString2[0].equals("")) {
/*     */       for (b2 = 0; b2 < arrayOfString1.length - 2; b2++)
/*     */         stringBuilder.append("../"); 
/*     */       for (b2 = 0; b2 < arrayOfString2.length; b2++) {
/*     */         if (!arrayOfString2[b2].equals("")) {
/*     */           stringBuilder.append(arrayOfString2[b2]);
/*     */           if (b2 != arrayOfString2.length - 1)
/*     */             stringBuilder.append("/"); 
/*     */         } 
/*     */       } 
/*     */       try {
/*     */         return new URI(stringBuilder.toString());
/*     */       } catch (Exception exception) {
/*     */         _logger.log(5, new Object[] { exception });
/*     */         return null;
/*     */       } 
/*     */     } 
/*     */     if (b1 == arrayOfString1.length && b1 == arrayOfString2.length) {
/*     */       if (paramURI1.equals(paramURI2)) {
/*     */         stringBuilder.append(arrayOfString1[arrayOfString1.length - 1]);
/*     */       } else {
/*     */         stringBuilder.append("");
/*     */       } 
/*     */     } else {
/*     */       if (b1 == 1) {
/*     */         stringBuilder.append("/");
/*     */       } else {
/*     */         for (b2 = b1; b2 < arrayOfString1.length - 1; b2++)
/*     */           stringBuilder.append("../"); 
/*     */       } 
/*     */       for (b2 = b1; b2 < arrayOfString2.length; b2++) {
/*     */         if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) != '/')
/*     */           stringBuilder.append("/"); 
/*     */         stringBuilder.append(arrayOfString2[b2]);
/*     */       } 
/*     */     } 
/*     */     String str = paramURI2.getRawFragment();
/*     */     if (str != null)
/*     */       stringBuilder.append("#").append(str); 
/*     */     try {
/*     */       return new URI(stringBuilder.toString());
/*     */     } catch (Exception exception) {
/*     */       _logger.log(5, new Object[] { exception });
/*     */       return null;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static URI relativizeURI(URI paramURI1, URI paramURI2) {
/*     */     return relativizeURI(paramURI1, paramURI2, false);
/*     */   }
/*     */   
/*     */   public static URI resolvePartUri(URI paramURI1, URI paramURI2) {
/*     */     if (paramURI1 == null || paramURI1.isAbsolute())
/*     */       throw new IllegalArgumentException("sourcePartUri invalid - " + paramURI1); 
/*     */     if (paramURI2 == null || paramURI2.isAbsolute())
/*     */       throw new IllegalArgumentException("targetUri invalid - " + paramURI2); 
/*     */     return paramURI1.resolve(paramURI2);
/*     */   }
/*     */   
/*     */   public static URI getURIFromPath(String paramString) {
/*     */     URI uRI;
/*     */     try {
/*     */       uRI = toURI(paramString);
/*     */     } catch (URISyntaxException uRISyntaxException) {
/*     */       throw new IllegalArgumentException("path");
/*     */     } 
/*     */     return uRI;
/*     */   }
/*     */   
/*     */   public static URI getSourcePartUriFromRelationshipPartUri(URI paramURI) {
/*     */     if (paramURI == null)
/*     */       throw new IllegalArgumentException("Must not be null"); 
/*     */     if (!isRelationshipPartURI(paramURI))
/*     */       throw new IllegalArgumentException("Must be a relationship part"); 
/*     */     if (paramURI.compareTo(PACKAGE_RELATIONSHIPS_ROOT_URI) == 0)
/*     */       return PACKAGE_ROOT_URI; 
/*     */     String str1 = paramURI.getPath();
/*     */     String str2 = getFilenameWithoutExtension(paramURI);
/*     */     str1 = str1.substring(0, str1.length() - str2.length() - RELATIONSHIP_PART_EXTENSION_NAME.length());
/*     */     str1 = str1.substring(0, str1.length() - RELATIONSHIP_PART_SEGMENT_NAME.length() - 1);
/*     */     str1 = combine(str1, str2);
/*     */     return getURIFromPath(str1);
/*     */   }
/*     */   
/*     */   public static PackagePartName createPartName(URI paramURI) throws InvalidFormatException {
/*     */     if (paramURI == null)
/*     */       throw new IllegalArgumentException("partName"); 
/*     */     return new PackagePartName(paramURI, true);
/*     */   }
/*     */   
/*     */   public static PackagePartName createPartName(String paramString) throws InvalidFormatException {
/*     */     URI uRI;
/*     */     try {
/*     */       uRI = toURI(paramString);
/*     */     } catch (URISyntaxException uRISyntaxException) {
/*     */       throw new InvalidFormatException(uRISyntaxException.getMessage());
/*     */     } 
/*     */     return createPartName(uRI);
/*     */   }
/*     */   
/*     */   public static PackagePartName createPartName(String paramString, PackagePart paramPackagePart) throws InvalidFormatException {
/*     */     URI uRI;
/*     */     try {
/*     */       uRI = resolvePartUri(paramPackagePart.getPartName().getURI(), new URI(paramString));
/*     */     } catch (URISyntaxException uRISyntaxException) {
/*     */       throw new InvalidFormatException(uRISyntaxException.getMessage());
/*     */     } 
/*     */     return createPartName(uRI);
/*     */   }
/*     */   
/*     */   public static PackagePartName createPartName(URI paramURI, PackagePart paramPackagePart) throws InvalidFormatException {
/*     */     URI uRI = resolvePartUri(paramPackagePart.getPartName().getURI(), paramURI);
/*     */     return createPartName(uRI);
/*     */   }
/*     */   
/*     */   public static boolean isValidPartName(URI paramURI) {
/*     */     if (paramURI == null)
/*     */       throw new IllegalArgumentException("partUri"); 
/*     */     try {
/*     */       createPartName(paramURI);
/*     */       return true;
/*     */     } catch (Exception exception) {
/*     */       return false;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static String decodeURI(URI paramURI) {
/*     */     StringBuffer stringBuffer = new StringBuffer();
/*     */     String str = paramURI.toASCIIString();
/*     */     int i = str.length();
/*     */     for (byte b = 0; b < i; b++) {
/*     */       char c = str.charAt(b);
/*     */       if (c == '%') {
/*     */         if (i - b < 2)
/*     */           throw new IllegalArgumentException("The uri " + str + " contain invalid encoded character !"); 
/*     */         char c1 = (char)Integer.parseInt(str.substring(b + 1, b + 3), 16);
/*     */         stringBuffer.append(c1);
/*     */         b += 2;
/*     */       } else {
/*     */         stringBuffer.append(c);
/*     */       } 
/*     */     } 
/*     */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static PackagePartName getRelationshipPartName(PackagePartName paramPackagePartName) {
/*     */     PackagePartName packagePartName;
/*     */     if (paramPackagePartName == null)
/*     */       throw new IllegalArgumentException("partName"); 
/*     */     if (PACKAGE_ROOT_URI.getPath().equals(paramPackagePartName.getURI().getPath()))
/*     */       return PACKAGE_RELATIONSHIPS_ROOT_PART_NAME; 
/*     */     if (paramPackagePartName.isRelationshipPartURI())
/*     */       throw new InvalidOperationException("Can't be a relationship part"); 
/*     */     String str1 = paramPackagePartName.getURI().getPath();
/*     */     String str2 = getFilename(paramPackagePartName.getURI());
/*     */     str1 = str1.substring(0, str1.length() - str2.length());
/*     */     str1 = combine(str1, RELATIONSHIP_PART_SEGMENT_NAME);
/*     */     str1 = combine(str1, str2);
/*     */     str1 = str1 + RELATIONSHIP_PART_EXTENSION_NAME;
/*     */     try {
/*     */       packagePartName = createPartName(str1);
/*     */     } catch (InvalidFormatException invalidFormatException) {
/*     */       return null;
/*     */     } 
/*     */     return packagePartName;
/*     */   }
/*     */   
/*     */   public static URI toURI(String paramString) throws URISyntaxException {
/*     */     if (paramString.indexOf("\\") != -1)
/*     */       paramString = paramString.replace('\\', '/'); 
/*     */     int i = paramString.indexOf('#');
/*     */     if (i != -1) {
/*     */       String str1 = paramString.substring(0, i);
/*     */       String str2 = paramString.substring(i + 1);
/*     */       paramString = str1 + "#" + encode(str2);
/*     */     } 
/*     */     if (paramString.length() > 0) {
/*     */       StringBuilder stringBuilder = new StringBuilder();
/*     */       int j = paramString.length() - 1;
/*     */       while (j >= 0) {
/*     */         char c = paramString.charAt(j);
/*     */         if (Character.isWhitespace(c) || c == ' ') {
/*     */           stringBuilder.append(c);
/*     */           j--;
/*     */         } 
/*     */       } 
/*     */       if (stringBuilder.length() > 0)
/*     */         paramString = paramString.substring(0, j + 1) + encode(stringBuilder.reverse().toString()); 
/*     */     } 
/*     */     if (missingAuthPattern.matcher(paramString).matches())
/*     */       paramString = paramString + "/"; 
/*     */     return new URI(paramString);
/*     */   }
/*     */   
/*     */   public static String encode(String paramString) {
/*     */     int i = paramString.length();
/*     */     if (i == 0)
/*     */       return paramString; 
/*     */     ByteBuffer byteBuffer = ByteBuffer.wrap(paramString.getBytes(Charset.forName("UTF-8")));
/*     */     StringBuilder stringBuilder = new StringBuilder();
/*     */     while (byteBuffer.hasRemaining()) {
/*     */       int j = byteBuffer.get() & 0xFF;
/*     */       if (isUnsafe(j)) {
/*     */         stringBuilder.append('%');
/*     */         stringBuilder.append(hexDigits[j >> 4 & 0xF]);
/*     */         stringBuilder.append(hexDigits[j >> 0 & 0xF]);
/*     */         continue;
/*     */       } 
/*     */       stringBuilder.append((char)j);
/*     */     } 
/*     */     return stringBuilder.toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\poi\openxml4j\opc\PackagingURIHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */