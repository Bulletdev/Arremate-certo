/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.HttpURLConnection;
/*     */ import java.net.URL;
/*     */ import java.net.URLConnection;
/*     */ import java.security.DigestInputStream;
/*     */ import java.security.MessageDigest;
/*     */ import java.security.NoSuchAlgorithmException;
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.XMLStreamReader;
/*     */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*     */ import org.apache.xmlbeans.SchemaField;
/*     */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*     */ import org.apache.xmlbeans.SchemaGlobalElement;
/*     */ import org.apache.xmlbeans.SchemaModelGroup;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlFactoryHook;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.XmlSaxHandler;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.store.Locale;
/*     */ import org.apache.xmlbeans.impl.validator.ValidatingXMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLInputStream;
/*     */ import org.apache.xmlbeans.xml.stream.XMLStreamException;
/*     */ import org.w3c.dom.DOMImplementation;
/*     */ import org.w3c.dom.Node;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class SchemaTypeLoaderBase
/*     */   implements SchemaTypeLoader
/*     */ {
/*  64 */   private static final String USER_AGENT = "XMLBeans/" + XmlBeans.getVersion() + " (" + XmlBeans.getTitle() + ")";
/*     */   
/*  66 */   private static final Method _pathCompiler = getMethod("org.apache.xmlbeans.impl.store.Path", "compilePath", new Class[] { String.class, XmlOptions.class });
/*  67 */   private static final Method _queryCompiler = getMethod("org.apache.xmlbeans.impl.store.Query", "compileQuery", new Class[] { String.class, XmlOptions.class });
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   private static Method getMethod(String paramString1, String paramString2, Class[] paramArrayOfClass) {
/*     */     try {
/*  73 */       return Class.forName(paramString1).getDeclaredMethod(paramString2, paramArrayOfClass);
/*     */ 
/*     */     
/*     */     }
/*  77 */     catch (Exception exception) {
/*     */       
/*  79 */       throw new IllegalStateException("Cannot find " + paramString1 + "." + paramString2 + ".  verify that xmlstore " + "(from xbean.jar) is on classpath");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Object invokeMethod(Method paramMethod, Object[] paramArrayOfObject) {
/*     */     try {
/*  90 */       return paramMethod.invoke(paramMethod, paramArrayOfObject);
/*     */     }
/*  92 */     catch (InvocationTargetException invocationTargetException) {
/*     */       
/*  94 */       Throwable throwable = invocationTargetException.getCause();
/*  95 */       IllegalStateException illegalStateException = new IllegalStateException(throwable.getMessage());
/*  96 */       illegalStateException.initCause(throwable);
/*  97 */       throw illegalStateException;
/*     */     }
/*  99 */     catch (Exception exception) {
/*     */       
/* 101 */       IllegalStateException illegalStateException = new IllegalStateException(exception.getMessage());
/* 102 */       illegalStateException.initCause(exception);
/* 103 */       throw illegalStateException;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static String doCompilePath(String paramString, XmlOptions paramXmlOptions) {
/* 109 */     return (String)invokeMethod(_pathCompiler, new Object[] { paramString, paramXmlOptions });
/*     */   }
/*     */ 
/*     */   
/*     */   private static String doCompileQuery(String paramString, XmlOptions paramXmlOptions) {
/* 114 */     return (String)invokeMethod(_queryCompiler, new Object[] { paramString, paramXmlOptions });
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findType(b paramb) {
/* 119 */     SchemaType.Ref ref = findTypeRef(paramb);
/* 120 */     if (ref == null)
/* 121 */       return null; 
/* 122 */     SchemaType schemaType = ref.get();
/* 123 */     assert schemaType != null;
/* 124 */     return schemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findDocumentType(b paramb) {
/* 129 */     SchemaType.Ref ref = findDocumentTypeRef(paramb);
/* 130 */     if (ref == null)
/* 131 */       return null; 
/* 132 */     SchemaType schemaType = ref.get();
/* 133 */     assert schemaType != null;
/* 134 */     return schemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType findAttributeType(b paramb) {
/* 139 */     SchemaType.Ref ref = findAttributeTypeRef(paramb);
/* 140 */     if (ref == null)
/* 141 */       return null; 
/* 142 */     SchemaType schemaType = ref.get();
/* 143 */     assert schemaType != null;
/* 144 */     return schemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaModelGroup findModelGroup(b paramb) {
/* 149 */     SchemaModelGroup.Ref ref = findModelGroupRef(paramb);
/* 150 */     if (ref == null)
/* 151 */       return null; 
/* 152 */     SchemaModelGroup schemaModelGroup = ref.get();
/* 153 */     assert schemaModelGroup != null;
/* 154 */     return schemaModelGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeGroup findAttributeGroup(b paramb) {
/* 159 */     SchemaAttributeGroup.Ref ref = findAttributeGroupRef(paramb);
/* 160 */     if (ref == null)
/* 161 */       return null; 
/* 162 */     SchemaAttributeGroup schemaAttributeGroup = ref.get();
/* 163 */     assert schemaAttributeGroup != null;
/* 164 */     return schemaAttributeGroup;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement findElement(b paramb) {
/* 169 */     SchemaGlobalElement.Ref ref = findElementRef(paramb);
/* 170 */     if (ref == null)
/* 171 */       return null; 
/* 172 */     SchemaGlobalElement schemaGlobalElement = ref.get();
/* 173 */     assert schemaGlobalElement != null;
/* 174 */     return schemaGlobalElement;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalAttribute findAttribute(b paramb) {
/* 179 */     SchemaGlobalAttribute.Ref ref = findAttributeRef(paramb);
/* 180 */     if (ref == null)
/* 181 */       return null; 
/* 182 */     SchemaGlobalAttribute schemaGlobalAttribute = ref.get();
/* 183 */     assert schemaGlobalAttribute != null;
/* 184 */     return schemaGlobalAttribute;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlObject newInstance(SchemaType paramSchemaType, XmlOptions paramXmlOptions) {
/* 193 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 195 */     if (xmlFactoryHook != null) {
/* 196 */       return xmlFactoryHook.newInstance(this, paramSchemaType, paramXmlOptions);
/*     */     }
/* 198 */     return Locale.newInstance(this, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(String paramString, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/* 203 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 205 */     if (xmlFactoryHook != null) {
/* 206 */       return xmlFactoryHook.parse(this, paramString, paramSchemaType, paramXmlOptions);
/*     */     }
/* 208 */     return Locale.parseToXmlObject(this, paramString, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlObject parse(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException {
/* 216 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 218 */     if (xmlFactoryHook != null) {
/* 219 */       return xmlFactoryHook.parse(this, paramXMLInputStream, paramSchemaType, paramXmlOptions);
/*     */     }
/* 221 */     return Locale.parseToXmlObject(this, paramXMLInputStream, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(XMLStreamReader paramXMLStreamReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/* 226 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 228 */     if (xmlFactoryHook != null) {
/* 229 */       return xmlFactoryHook.parse(this, paramXMLStreamReader, paramSchemaType, paramXmlOptions);
/*     */     }
/* 231 */     return Locale.parseToXmlObject(this, paramXMLStreamReader, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(File paramFile, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/* 236 */     if (paramXmlOptions == null) {
/*     */       
/* 238 */       paramXmlOptions = new XmlOptions();
/* 239 */       paramXmlOptions.put("DOCUMENT_SOURCE_NAME", paramFile.toURI().normalize().toString());
/*     */     
/*     */     }
/* 242 */     else if (!paramXmlOptions.hasOption("DOCUMENT_SOURCE_NAME")) {
/*     */       
/* 244 */       paramXmlOptions = new XmlOptions(paramXmlOptions);
/* 245 */       paramXmlOptions.put("DOCUMENT_SOURCE_NAME", paramFile.toURI().normalize().toString());
/*     */     } 
/*     */     
/* 248 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/*     */ 
/*     */     
/*     */     try {
/* 252 */       return parse(fileInputStream, paramSchemaType, paramXmlOptions);
/*     */     }
/*     */     finally {
/*     */       
/* 256 */       fileInputStream.close();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(URL paramURL, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/* 262 */     if (paramXmlOptions == null) {
/*     */       
/* 264 */       paramXmlOptions = new XmlOptions();
/* 265 */       paramXmlOptions.put("DOCUMENT_SOURCE_NAME", paramURL.toString());
/*     */     
/*     */     }
/* 268 */     else if (!paramXmlOptions.hasOption("DOCUMENT_SOURCE_NAME")) {
/*     */       
/* 270 */       paramXmlOptions = new XmlOptions(paramXmlOptions);
/* 271 */       paramXmlOptions.put("DOCUMENT_SOURCE_NAME", paramURL.toString());
/*     */     } 
/*     */     
/* 274 */     URLConnection uRLConnection = null;
/* 275 */     InputStream inputStream = null;
/*     */ 
/*     */     
/*     */     try {
/* 279 */       boolean bool = false;
/* 280 */       byte b = 0;
/*     */       
/*     */       do {
/* 283 */         uRLConnection = paramURL.openConnection();
/* 284 */         uRLConnection.addRequestProperty("User-Agent", USER_AGENT);
/* 285 */         uRLConnection.addRequestProperty("Accept", "application/xml, text/xml, */*");
/* 286 */         if (!(uRLConnection instanceof HttpURLConnection))
/*     */           continue; 
/* 288 */         HttpURLConnection httpURLConnection = (HttpURLConnection)uRLConnection;
/* 289 */         int i = httpURLConnection.getResponseCode();
/* 290 */         bool = (i == 301 || i == 302) ? true : false;
/* 291 */         if (bool && b > 5) {
/* 292 */           bool = false;
/*     */         }
/* 294 */         if (!bool)
/*     */           continue; 
/* 296 */         String str = httpURLConnection.getHeaderField("Location");
/* 297 */         if (str == null) {
/* 298 */           bool = false;
/*     */         } else {
/*     */           
/* 301 */           paramURL = new URL(str);
/* 302 */           b++;
/*     */         }
/*     */       
/*     */       }
/* 306 */       while (bool);
/*     */       
/* 308 */       inputStream = uRLConnection.getInputStream();
/* 309 */       return parse(inputStream, paramSchemaType, paramXmlOptions);
/*     */     }
/*     */     finally {
/*     */       
/* 313 */       if (inputStream != null) {
/* 314 */         inputStream.close();
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public XmlObject parse(InputStream paramInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/* 320 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 322 */     DigestInputStream digestInputStream = null;
/*     */ 
/*     */     
/* 325 */     if (paramXmlOptions != null && paramXmlOptions.hasOption("LOAD_MESSAGE_DIGEST")) {
/*     */       MessageDigest messageDigest;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 331 */         messageDigest = MessageDigest.getInstance("SHA");
/*     */       }
/* 333 */       catch (NoSuchAlgorithmException noSuchAlgorithmException) {}
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 338 */       digestInputStream = new DigestInputStream(paramInputStream, messageDigest);
/* 339 */       paramInputStream = digestInputStream;
/*     */     } 
/*     */     
/* 342 */     if (xmlFactoryHook != null) {
/* 343 */       return xmlFactoryHook.parse(this, paramInputStream, paramSchemaType, paramXmlOptions);
/*     */     }
/* 345 */     XmlObject xmlObject = Locale.parseToXmlObject(this, paramInputStream, paramSchemaType, paramXmlOptions);
/*     */     
/* 347 */     if (digestInputStream != null) {
/* 348 */       xmlObject.documentProperties().setMessageDigest(digestInputStream.getMessageDigest().digest());
/*     */     }
/* 350 */     return xmlObject;
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(Reader paramReader, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, IOException {
/* 355 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 357 */     if (xmlFactoryHook != null) {
/* 358 */       return xmlFactoryHook.parse(this, paramReader, paramSchemaType, paramXmlOptions);
/*     */     }
/* 360 */     return Locale.parseToXmlObject(this, paramReader, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlObject parse(Node paramNode, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException {
/* 365 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 367 */     if (xmlFactoryHook != null) {
/* 368 */       return xmlFactoryHook.parse(this, paramNode, paramSchemaType, paramXmlOptions);
/*     */     }
/* 370 */     return Locale.parseToXmlObject(this, paramNode, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public XmlSaxHandler newXmlSaxHandler(SchemaType paramSchemaType, XmlOptions paramXmlOptions) {
/* 375 */     XmlFactoryHook xmlFactoryHook = XmlFactoryHook.ThreadContext.getHook();
/*     */     
/* 377 */     if (xmlFactoryHook != null) {
/* 378 */       return xmlFactoryHook.newXmlSaxHandler(this, paramSchemaType, paramXmlOptions);
/*     */     }
/* 380 */     return Locale.newSaxHandler(this, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public DOMImplementation newDomImplementation(XmlOptions paramXmlOptions) {
/* 385 */     return Locale.newDomImplementation(this, paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XMLInputStream newValidatingXMLInputStream(XMLInputStream paramXMLInputStream, SchemaType paramSchemaType, XmlOptions paramXmlOptions) throws XmlException, XMLStreamException {
/* 393 */     return (XMLInputStream)new ValidatingXMLInputStream(paramXMLInputStream, this, paramSchemaType, paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String compilePath(String paramString) {
/* 402 */     return compilePath(paramString, (XmlOptions)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String compilePath(String paramString, XmlOptions paramXmlOptions) {
/* 407 */     return doCompilePath(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */   
/*     */   public String compileQuery(String paramString) {
/* 412 */     return compileQuery(paramString, (XmlOptions)null);
/*     */   }
/*     */ 
/*     */   
/*     */   public String compileQuery(String paramString, XmlOptions paramXmlOptions) {
/* 417 */     return doCompileQuery(paramString, paramXmlOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaType typeForSignature(String paramString) {
/*     */     String str;
/* 427 */     int i = paramString.indexOf('@');
/*     */ 
/*     */     
/* 430 */     if (i < 0) {
/*     */       
/* 432 */       str = "";
/* 433 */       i = paramString.length();
/*     */     }
/*     */     else {
/*     */       
/* 437 */       str = paramString.substring(i + 1);
/*     */     } 
/*     */     
/* 440 */     ArrayList arrayList = new ArrayList();
/*     */     int j;
/* 442 */     for (j = 0; j < i; ) {
/*     */       
/* 444 */       int m = paramString.indexOf(':', j);
/* 445 */       int n = paramString.indexOf('|', j);
/* 446 */       int i1 = (m < 0) ? n : ((n < 0) ? m : ((m < n) ? m : n));
/* 447 */       if (i1 < 0 || i1 > i)
/* 448 */         i1 = i; 
/* 449 */       String str1 = paramString.substring(j, i1);
/* 450 */       arrayList.add(str1);
/* 451 */       j = i1 + 1;
/*     */     } 
/*     */     
/* 454 */     SchemaType schemaType = null;
/*     */     
/* 456 */     for (int k = arrayList.size() - 1; k >= 0; k--) {
/*     */       SchemaGlobalElement schemaGlobalElement; SchemaGlobalAttribute schemaGlobalAttribute; SchemaType[] arrayOfSchemaType1; int m; SchemaType[] arrayOfSchemaType2;
/* 458 */       String str1 = arrayList.get(k);
/* 459 */       if (str1.length() < 1)
/* 460 */         throw new IllegalArgumentException(); 
/* 461 */       boolean bool = (str1.length() >= 2 && str1.charAt(1) == '=') ? true : true;
/* 462 */       switch (str1.charAt(0)) {
/*     */         
/*     */         case 'T':
/* 465 */           if (schemaType != null)
/* 466 */             throw new IllegalArgumentException(); 
/* 467 */           schemaType = findType(QNameHelper.forLNS(str1.substring(bool), str));
/* 468 */           if (schemaType == null) {
/* 469 */             return null;
/*     */           }
/*     */           break;
/*     */         case 'D':
/* 473 */           if (schemaType != null)
/* 474 */             throw new IllegalArgumentException(); 
/* 475 */           schemaType = findDocumentType(QNameHelper.forLNS(str1.substring(bool), str));
/* 476 */           if (schemaType == null) {
/* 477 */             return null;
/*     */           }
/*     */           break;
/*     */         case 'C':
/*     */         case 'R':
/* 482 */           if (schemaType != null)
/* 483 */             throw new IllegalArgumentException(); 
/* 484 */           schemaType = findAttributeType(QNameHelper.forLNS(str1.substring(bool), str));
/* 485 */           if (schemaType == null) {
/* 486 */             return null;
/*     */           }
/*     */           break;
/*     */         case 'E':
/*     */         case 'U':
/* 491 */           if (schemaType != null) {
/*     */             
/* 493 */             if (schemaType.getContentType() < 3)
/* 494 */               return null; 
/* 495 */             SchemaType[] arrayOfSchemaType = schemaType.getAnonymousTypes();
/* 496 */             String str2 = str1.substring(bool);
/* 497 */             byte b = 0; while (true) { if (b < arrayOfSchemaType.length) {
/*     */                 
/* 499 */                 SchemaField schemaField = arrayOfSchemaType[b].getContainerField();
/* 500 */                 if (schemaField != null && !schemaField.isAttribute() && schemaField.getName().dT().equals(str2)) {
/*     */                   
/* 502 */                   schemaType = arrayOfSchemaType[b]; break;
/*     */                 }  b++;
/*     */                 continue;
/*     */               } 
/* 506 */               return null; }
/*     */             
/*     */             break;
/*     */           } 
/* 510 */           schemaGlobalElement = findElement(QNameHelper.forLNS(str1.substring(bool), str));
/* 511 */           if (schemaGlobalElement == null)
/* 512 */             return null; 
/* 513 */           schemaType = schemaGlobalElement.getType();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'A':
/*     */         case 'Q':
/* 519 */           if (schemaType != null) {
/*     */             
/* 521 */             if (schemaType.isSimpleType())
/* 522 */               return null; 
/* 523 */             SchemaType[] arrayOfSchemaType = schemaType.getAnonymousTypes();
/* 524 */             String str2 = str1.substring(bool);
/* 525 */             byte b = 0; while (true) { if (b < arrayOfSchemaType.length) {
/*     */                 
/* 527 */                 SchemaField schemaField = arrayOfSchemaType[b].getContainerField();
/* 528 */                 if (schemaField != null && schemaField.isAttribute() && schemaField.getName().dT().equals(str2)) {
/*     */                   
/* 530 */                   schemaType = arrayOfSchemaType[b]; break;
/*     */                 }  b++;
/*     */                 continue;
/*     */               } 
/* 534 */               return null; }
/*     */             
/*     */             break;
/*     */           } 
/* 538 */           schemaGlobalAttribute = findAttribute(QNameHelper.forLNS(str1.substring(bool), str));
/* 539 */           if (schemaGlobalAttribute == null)
/* 540 */             return null; 
/* 541 */           schemaType = schemaGlobalAttribute.getType();
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'B':
/* 546 */           if (schemaType == null)
/*     */           {
/* 548 */             throw new IllegalArgumentException();
/*     */           }
/*     */ 
/*     */           
/* 552 */           if (schemaType.getSimpleVariety() != 1)
/* 553 */             return null; 
/* 554 */           arrayOfSchemaType1 = schemaType.getAnonymousTypes();
/* 555 */           if (arrayOfSchemaType1.length != 1)
/* 556 */             return null; 
/* 557 */           schemaType = arrayOfSchemaType1[0];
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'I':
/* 562 */           if (schemaType == null)
/*     */           {
/* 564 */             throw new IllegalArgumentException();
/*     */           }
/*     */ 
/*     */           
/* 568 */           if (schemaType.getSimpleVariety() != 3)
/* 569 */             return null; 
/* 570 */           arrayOfSchemaType1 = schemaType.getAnonymousTypes();
/* 571 */           if (arrayOfSchemaType1.length != 1)
/* 572 */             return null; 
/* 573 */           schemaType = arrayOfSchemaType1[0];
/*     */           break;
/*     */ 
/*     */         
/*     */         case 'M':
/* 578 */           if (schemaType == null)
/*     */           {
/* 580 */             throw new IllegalArgumentException();
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */           
/*     */           try {
/* 587 */             m = Integer.parseInt(str1.substring(bool));
/*     */           }
/* 589 */           catch (Exception exception) {
/*     */             
/* 591 */             throw new IllegalArgumentException();
/*     */           } 
/*     */           
/* 594 */           if (schemaType.getSimpleVariety() != 2)
/* 595 */             return null; 
/* 596 */           arrayOfSchemaType2 = schemaType.getAnonymousTypes();
/* 597 */           if (arrayOfSchemaType2.length <= m)
/* 598 */             return null; 
/* 599 */           schemaType = arrayOfSchemaType2[m];
/*     */           break;
/*     */ 
/*     */         
/*     */         default:
/* 604 */           throw new IllegalArgumentException();
/*     */       } 
/*     */     } 
/* 607 */     return schemaType;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeLoaderBase.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */