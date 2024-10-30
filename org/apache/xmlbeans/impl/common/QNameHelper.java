/*     */ package org.apache.xmlbeans.impl.common;
/*     */ 
/*     */ import java.io.UnsupportedEncodingException;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaField;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.xml.stream.XMLName;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class QNameHelper
/*     */ {
/*  33 */   private static final Map WELL_KNOWN_PREFIXES = buildWKP();
/*     */ 
/*     */   
/*     */   public static XMLName getXMLName(b paramb) {
/*  37 */     if (paramb == null) {
/*  38 */       return null;
/*     */     }
/*  40 */     return XMLNameHelper.forLNS(paramb.dT(), paramb.getNamespaceURI());
/*     */   }
/*     */ 
/*     */   
/*     */   public static b forLNS(String paramString1, String paramString2) {
/*  45 */     if (paramString2 == null)
/*  46 */       paramString2 = ""; 
/*  47 */     return new b(paramString2, paramString1);
/*     */   }
/*     */ 
/*     */   
/*     */   public static b forLN(String paramString) {
/*  52 */     return new b("", paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public static b forPretty(String paramString, int paramInt) {
/*  57 */     int i = paramString.indexOf('@', paramInt);
/*  58 */     if (i < 0)
/*  59 */       return new b("", paramString.substring(paramInt)); 
/*  60 */     return new b(paramString.substring(i + 1), paramString.substring(paramInt, i));
/*     */   }
/*     */ 
/*     */   
/*     */   public static String pretty(b paramb) {
/*  65 */     if (paramb == null) {
/*  66 */       return "null";
/*     */     }
/*  68 */     if (paramb.getNamespaceURI() == null || paramb.getNamespaceURI().length() == 0) {
/*  69 */       return paramb.dT();
/*     */     }
/*  71 */     return paramb.dT() + "@" + paramb.getNamespaceURI();
/*     */   }
/*     */   
/*  74 */   private static final char[] hexdigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' }; public static final int MAX_NAME_LENGTH = 64;
/*     */   public static final String URI_SHA1_PREFIX = "URI_SHA_1_";
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static boolean isSafe(int paramInt) {
/*  79 */     if (paramInt >= 97 && paramInt <= 122)
/*  80 */       return true; 
/*  81 */     if (paramInt >= 65 && paramInt <= 90)
/*  82 */       return true; 
/*  83 */     if (paramInt >= 48 && paramInt <= 57)
/*  84 */       return true; 
/*  85 */     return false;
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
/*     */   public static String hexsafe(String paramString) {
/* 111 */     StringBuffer stringBuffer = new StringBuffer();
/* 112 */     for (byte b = 0; b < paramString.length(); b++) {
/*     */       
/* 114 */       char c = paramString.charAt(b);
/* 115 */       if (isSafe(c)) {
/*     */         
/* 117 */         stringBuffer.append(c);
/*     */       }
/*     */       else {
/*     */         
/* 121 */         byte[] arrayOfByte = null;
/*     */         
/*     */         try {
/* 124 */           arrayOfByte = paramString.substring(b, b + 1).getBytes("UTF-8");
/* 125 */           for (byte b1 = 0; b1 < arrayOfByte.length; b1++)
/*     */           {
/* 127 */             stringBuffer.append('_');
/* 128 */             stringBuffer.append(hexdigits[arrayOfByte[b1] >> 4 & 0xF]);
/* 129 */             stringBuffer.append(hexdigits[arrayOfByte[b1] & 0xF]);
/*     */           }
/*     */         
/* 132 */         } catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */ 
/*     */           
/* 135 */           stringBuffer.append("_BAD_UTF8_CHAR");
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 141 */     if (stringBuffer.length() <= 64) {
/* 142 */       return stringBuffer.toString();
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 147 */       MessageDigest messageDigest = MessageDigest.getInstance("SHA");
/* 148 */       byte[] arrayOfByte1 = null;
/*     */       
/*     */       try {
/* 151 */         arrayOfByte1 = paramString.getBytes("UTF-8");
/*     */       }
/* 153 */       catch (UnsupportedEncodingException unsupportedEncodingException) {
/*     */ 
/*     */         
/* 156 */         arrayOfByte1 = new byte[0];
/*     */       } 
/* 158 */       byte[] arrayOfByte2 = messageDigest.digest(arrayOfByte1);
/* 159 */       assert arrayOfByte2.length == 20;
/* 160 */       stringBuffer = new StringBuffer("URI_SHA_1_");
/* 161 */       for (byte b1 = 0; b1 < arrayOfByte2.length; b1++) {
/*     */         
/* 163 */         stringBuffer.append(hexdigits[arrayOfByte2[b1] >> 4 & 0xF]);
/* 164 */         stringBuffer.append(hexdigits[arrayOfByte2[b1] & 0xF]);
/*     */       } 
/* 166 */       return stringBuffer.toString();
/*     */     }
/* 168 */     catch (NoSuchAlgorithmException noSuchAlgorithmException) {
/*     */       
/* 170 */       throw new IllegalStateException("Using in a JDK without an SHA implementation");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String hexsafedir(b paramb) {
/* 176 */     if (paramb.getNamespaceURI() == null || paramb.getNamespaceURI().length() == 0)
/* 177 */       return "_nons/" + hexsafe(paramb.dT()); 
/* 178 */     return hexsafe(paramb.getNamespaceURI()) + "/" + hexsafe(paramb.dT());
/*     */   }
/*     */ 
/*     */   
/*     */   private static Map buildWKP() {
/* 183 */     HashMap hashMap = new HashMap();
/* 184 */     hashMap.put("http://www.w3.org/XML/1998/namespace", "xml");
/* 185 */     hashMap.put("http://www.w3.org/2001/XMLSchema", "xs");
/* 186 */     hashMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
/* 187 */     hashMap.put("http://schemas.xmlsoap.org/wsdl/", "wsdl");
/* 188 */     hashMap.put("http://schemas.xmlsoap.org/soap/encoding/", "soapenc");
/* 189 */     hashMap.put("http://schemas.xmlsoap.org/soap/envelope/", "soapenv");
/* 190 */     return Collections.unmodifiableMap(hashMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String readable(SchemaType paramSchemaType) {
/* 195 */     return readable(paramSchemaType, WELL_KNOWN_PREFIXES);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String readable(SchemaType paramSchemaType, Map paramMap) {
/* 200 */     if (paramSchemaType.getName() != null)
/*     */     {
/* 202 */       return readable(paramSchemaType.getName(), paramMap);
/*     */     }
/*     */     
/* 205 */     if (paramSchemaType.isAttributeType())
/*     */     {
/* 207 */       return "attribute type " + readable(paramSchemaType.getAttributeTypeAttributeName(), paramMap);
/*     */     }
/*     */     
/* 210 */     if (paramSchemaType.isDocumentType())
/*     */     {
/* 212 */       return "document type " + readable(paramSchemaType.getDocumentElementName(), paramMap);
/*     */     }
/*     */     
/* 215 */     if (paramSchemaType.isNoType() || paramSchemaType.getOuterType() == null)
/*     */     {
/* 217 */       return "invalid type";
/*     */     }
/*     */     
/* 220 */     SchemaType schemaType = paramSchemaType.getOuterType();
/* 221 */     SchemaField schemaField = paramSchemaType.getContainerField();
/*     */     
/* 223 */     if (schemaType.isAttributeType())
/*     */     {
/* 225 */       return "type of attribute " + readable(schemaField.getName(), paramMap);
/*     */     }
/* 227 */     if (schemaType.isDocumentType())
/*     */     {
/* 229 */       return "type of element " + readable(schemaField.getName(), paramMap);
/*     */     }
/*     */     
/* 232 */     if (schemaField != null) {
/*     */       
/* 234 */       if (schemaField.isAttribute())
/*     */       {
/* 236 */         return "type of " + schemaField.getName().dT() + " attribute in " + readable(schemaType, paramMap);
/*     */       }
/*     */ 
/*     */       
/* 240 */       return "type of " + schemaField.getName().dT() + " element in " + readable(schemaType, paramMap);
/*     */     } 
/*     */ 
/*     */     
/* 244 */     if (schemaType.getBaseType() == paramSchemaType)
/* 245 */       return "base type of " + readable(schemaType, paramMap); 
/* 246 */     if (schemaType.getSimpleVariety() == 3)
/* 247 */       return "item type of " + readable(schemaType, paramMap); 
/* 248 */     if (schemaType.getSimpleVariety() == 2) {
/* 249 */       return "member type " + paramSchemaType.getAnonymousUnionMemberOrdinal() + " of " + readable(schemaType, paramMap);
/*     */     }
/* 251 */     return "inner type in " + readable(schemaType, paramMap);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String readable(b paramb) {
/* 256 */     return readable(paramb, WELL_KNOWN_PREFIXES);
/*     */   }
/*     */ 
/*     */   
/*     */   public static String readable(b paramb, Map paramMap) {
/* 261 */     if (paramb.getNamespaceURI().length() == 0)
/* 262 */       return paramb.dT(); 
/* 263 */     String str = (String)paramMap.get(paramb.getNamespaceURI());
/* 264 */     if (str != null)
/* 265 */       return str + ":" + paramb.dT(); 
/* 266 */     return paramb.dT() + " in namespace " + paramb.getNamespaceURI();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String suggestPrefix(String paramString) {
/* 271 */     String str = (String)WELL_KNOWN_PREFIXES.get(paramString);
/* 272 */     if (str != null) {
/* 273 */       return str;
/*     */     }
/* 275 */     int i = paramString.length();
/* 276 */     int j = paramString.lastIndexOf('/');
/* 277 */     if (j > 0 && j == paramString.length() - 1) {
/*     */       
/* 279 */       i = j;
/* 280 */       j = paramString.lastIndexOf('/', j - 1);
/*     */     } 
/*     */     
/* 283 */     j++;
/*     */     
/* 285 */     if (paramString.startsWith("www.", j))
/*     */     {
/* 287 */       j += 4;
/*     */     }
/*     */     
/* 290 */     while (j < i) {
/*     */       
/* 292 */       if (XMLChar.isNCNameStart(paramString.charAt(j)))
/*     */         break; 
/* 294 */       j++;
/*     */     } 
/*     */     
/* 297 */     for (int k = j + 1; k < i; k++) {
/*     */       
/* 299 */       if (!XMLChar.isNCName(paramString.charAt(k)) || !Character.isLetterOrDigit(paramString.charAt(k))) {
/*     */         
/* 301 */         i = k;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/*     */     
/* 307 */     if (paramString.length() >= j + 3 && startsWithXml(paramString, j)) {
/*     */       
/* 309 */       if (paramString.length() >= j + 4)
/* 310 */         return "x" + Character.toLowerCase(paramString.charAt(j + 3)); 
/* 311 */       return "ns";
/*     */     } 
/*     */     
/* 314 */     if (i - j > 4)
/*     */     {
/* 316 */       if (isVowel(paramString.charAt(j + 2)) && !isVowel(paramString.charAt(j + 3))) {
/* 317 */         i = j + 4;
/*     */       } else {
/* 319 */         i = j + 3;
/*     */       } 
/*     */     }
/* 322 */     if (i - j == 0) {
/* 323 */       return "ns";
/*     */     }
/* 325 */     return paramString.substring(j, i).toLowerCase();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean startsWithXml(String paramString, int paramInt) {
/* 330 */     if (paramString.length() < paramInt + 3) {
/* 331 */       return false;
/*     */     }
/* 333 */     if (paramString.charAt(paramInt) != 'X' && paramString.charAt(paramInt) != 'x')
/* 334 */       return false; 
/* 335 */     if (paramString.charAt(paramInt + 1) != 'M' && paramString.charAt(paramInt + 1) != 'm')
/* 336 */       return false; 
/* 337 */     if (paramString.charAt(paramInt + 2) != 'L' && paramString.charAt(paramInt + 2) != 'l') {
/* 338 */       return false;
/*     */     }
/* 340 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isVowel(char paramChar) {
/* 345 */     switch (paramChar) {
/*     */       
/*     */       case 'A':
/*     */       case 'E':
/*     */       case 'I':
/*     */       case 'O':
/*     */       case 'U':
/*     */       case 'a':
/*     */       case 'e':
/*     */       case 'i':
/*     */       case 'o':
/*     */       case 'u':
/* 357 */         return true;
/*     */     } 
/* 359 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String namespace(SchemaType paramSchemaType) {
/* 365 */     while (paramSchemaType != null) {
/*     */       
/* 367 */       if (paramSchemaType.getName() != null)
/* 368 */         return paramSchemaType.getName().getNamespaceURI(); 
/* 369 */       if (paramSchemaType.getContainerField() != null && paramSchemaType.getContainerField().getName().getNamespaceURI().length() > 0)
/* 370 */         return paramSchemaType.getContainerField().getName().getNamespaceURI(); 
/* 371 */       paramSchemaType = paramSchemaType.getOuterType();
/*     */     } 
/* 373 */     return "";
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
/*     */   public static String getLocalPart(String paramString) {
/* 386 */     int i = paramString.indexOf(':');
/*     */     
/* 388 */     return (i < 0) ? paramString : paramString.substring(i + 1);
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
/*     */   public static String getPrefixPart(String paramString) {
/* 401 */     int i = paramString.indexOf(':');
/*     */     
/* 403 */     return (i >= 0) ? paramString.substring(0, i) : "";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\common\QNameHelper.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */