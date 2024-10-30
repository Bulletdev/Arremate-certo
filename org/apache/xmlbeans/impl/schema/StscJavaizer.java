/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.BindingConfig;
/*     */ import org.apache.xmlbeans.InterfaceExtension;
/*     */ import org.apache.xmlbeans.PrePostExtension;
/*     */ import org.apache.xmlbeans.SchemaField;
/*     */ import org.apache.xmlbeans.SchemaProperty;
/*     */ import org.apache.xmlbeans.SchemaStringEnumEntry;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.UserType;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.common.NameUtil;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StscJavaizer
/*     */ {
/*     */   private static final int MAX_ENUM_COUNT = 3668;
/*     */   
/*     */   public static void javaizeAllTypes(boolean paramBoolean) {
/*  54 */     StscState stscState = StscState.get();
/*     */     
/*  56 */     ArrayList arrayList = new ArrayList();
/*  57 */     arrayList.addAll(Arrays.asList(stscState.documentTypes()));
/*  58 */     arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
/*  59 */     arrayList.addAll(Arrays.asList(stscState.globalTypes()));
/*     */ 
/*     */     
/*  62 */     if (paramBoolean) {
/*  63 */       assignGlobalJavaNames(arrayList);
/*     */     }
/*     */     
/*  66 */     for (byte b = 0; b < arrayList.size(); b++) {
/*     */       
/*  68 */       SchemaType schemaType = arrayList.get(b);
/*  69 */       if (paramBoolean) {
/*     */         
/*  71 */         javaizeType((SchemaTypeImpl)schemaType);
/*  72 */         String str = schemaType.getFullJavaName();
/*  73 */         if (str != null) {
/*  74 */           stscState.addClassname(str.replace('$', '.'), schemaType);
/*     */         }
/*     */       } else {
/*  77 */         skipJavaizingType((SchemaTypeImpl)schemaType);
/*  78 */       }  arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  83 */       addAnonymousTypesFromRedefinition(schemaType, arrayList);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void assignGlobalJavaNames(Collection paramCollection) {
/*  89 */     HashSet hashSet = new HashSet();
/*  90 */     StscState stscState = StscState.get();
/*     */     
/*  92 */     for (SchemaTypeImpl schemaTypeImpl : paramCollection) {
/*     */ 
/*     */       
/*  95 */       b b = findTopName(schemaTypeImpl);
/*  96 */       String str = stscState.getJavaname(b, schemaTypeImpl.isDocumentType() ? 2 : 1);
/*     */       
/*  98 */       if (schemaTypeImpl.isUnjavaized()) {
/*     */         
/* 100 */         schemaTypeImpl.setFullJavaName(pickFullJavaClassName(hashSet, findTopName(schemaTypeImpl), str, schemaTypeImpl.isDocumentType(), schemaTypeImpl.isAttributeType()));
/* 101 */         schemaTypeImpl.setFullJavaImplName(pickFullJavaImplName(hashSet, schemaTypeImpl.getFullJavaName()));
/*     */         
/* 103 */         setUserTypes(schemaTypeImpl, stscState);
/*     */         
/* 105 */         setExtensions(schemaTypeImpl, stscState);
/*     */       } 
/*     */     } 
/*     */     
/* 109 */     verifyInterfaceNameCollisions(hashSet, stscState);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void verifyInterfaceNameCollisions(Set paramSet, StscState paramStscState) {
/* 114 */     BindingConfig bindingConfig = paramStscState.getBindingConfig();
/* 115 */     if (bindingConfig == null) {
/*     */       return;
/*     */     }
/* 118 */     InterfaceExtension[] arrayOfInterfaceExtension = bindingConfig.getInterfaceExtensions();
/* 119 */     for (byte b1 = 0; b1 < arrayOfInterfaceExtension.length; b1++) {
/*     */       
/* 121 */       if (paramSet.contains(arrayOfInterfaceExtension[b1].getInterface().toLowerCase())) {
/* 122 */         paramStscState.error("InterfaceExtension interface '" + arrayOfInterfaceExtension[b1].getInterface() + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject)null);
/*     */       }
/* 124 */       String str = arrayOfInterfaceExtension[b1].getStaticHandler();
/* 125 */       if (str != null && paramSet.contains(str.toLowerCase())) {
/* 126 */         paramStscState.error("InterfaceExtension handler class '" + str + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject)null);
/*     */       }
/*     */     } 
/* 129 */     PrePostExtension[] arrayOfPrePostExtension = bindingConfig.getPrePostExtensions();
/* 130 */     for (byte b2 = 0; b2 < arrayOfPrePostExtension.length; b2++) {
/*     */       
/* 132 */       String str = arrayOfPrePostExtension[b2].getStaticHandler();
/* 133 */       if (str != null && paramSet.contains(str.toLowerCase())) {
/* 134 */         paramStscState.error("PrePostExtension handler class '" + str + "' creates a name collision with one of the generated interfaces or classes.", 0, (XmlObject)null);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private static void setUserTypes(SchemaTypeImpl paramSchemaTypeImpl, StscState paramStscState) {
/* 140 */     BindingConfig bindingConfig = paramStscState.getBindingConfig();
/*     */     
/* 142 */     if (bindingConfig != null) {
/*     */       
/* 144 */       UserType userType = bindingConfig.lookupUserTypeForQName(paramSchemaTypeImpl.getName());
/* 145 */       if (userType != null) {
/*     */         
/* 147 */         paramSchemaTypeImpl.setUserTypeName(userType.getJavaName());
/* 148 */         paramSchemaTypeImpl.setUserTypeHandlerName(userType.getStaticHandler());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void setExtensions(SchemaTypeImpl paramSchemaTypeImpl, StscState paramStscState) {
/* 155 */     String str = paramSchemaTypeImpl.getFullJavaName();
/* 156 */     BindingConfig bindingConfig = paramStscState.getBindingConfig();
/*     */     
/* 158 */     if (str != null && bindingConfig != null) {
/*     */       
/* 160 */       paramSchemaTypeImpl.setInterfaceExtensions(bindingConfig.getInterfaceExtensions(str));
/* 161 */       paramSchemaTypeImpl.setPrePostExtension(bindingConfig.getPrePostExtension(str));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isStringType(SchemaType paramSchemaType) {
/* 167 */     if (paramSchemaType == null || paramSchemaType.getSimpleVariety() != 1)
/* 168 */       return false; 
/* 169 */     return (paramSchemaType.getPrimitiveType().getBuiltinTypeCode() == 12);
/*     */   }
/*     */ 
/*     */   
/*     */   static String pickConstantName(Set paramSet, String paramString) {
/* 174 */     String str1 = NameUtil.upperCaseUnderbar(paramString);
/*     */     
/* 176 */     if (str1.length() == 0)
/*     */     {
/* 178 */       str1 = "X";
/*     */     }
/*     */     
/* 181 */     if (str1.startsWith("INT_"))
/*     */     {
/* 183 */       str1 = "X_" + str1;
/*     */     }
/*     */ 
/*     */     
/* 187 */     byte b = 1; String str2;
/* 188 */     for (str2 = str1; paramSet.contains(str2); ) {
/*     */       
/* 190 */       b++;
/* 191 */       str2 = str1 + "_" + b;
/*     */     } 
/*     */     
/* 194 */     paramSet.add(str2);
/*     */     
/* 196 */     return str2;
/*     */   }
/*     */ 
/*     */   
/*     */   static void skipJavaizingType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 201 */     if (paramSchemaTypeImpl.isJavaized()) {
/*     */       return;
/*     */     }
/* 204 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)paramSchemaTypeImpl.getBaseType();
/* 205 */     if (schemaTypeImpl != null) {
/* 206 */       skipJavaizingType(schemaTypeImpl);
/*     */     }
/* 208 */     paramSchemaTypeImpl.startJavaizing();
/* 209 */     secondPassProcessType(paramSchemaTypeImpl);
/* 210 */     paramSchemaTypeImpl.finishJavaizing();
/*     */   }
/*     */ 
/*     */   
/*     */   static void secondPassProcessType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 215 */     if (isStringType(paramSchemaTypeImpl)) {
/*     */       
/* 217 */       XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaTypeImpl.getEnumerationValues();
/*     */ 
/*     */ 
/*     */       
/* 221 */       if (arrayOfXmlAnySimpleType != null)
/*     */       {
/*     */         
/* 224 */         if (arrayOfXmlAnySimpleType.length > 3668) {
/*     */           
/* 226 */           StscState.get().warning("SchemaType Enumeration found with too many enumeration values to create a Java enumeration. The base SchemaType \"" + paramSchemaTypeImpl.getBaseEnumType() + "\" will be used instead", 1, (XmlObject)null);
/*     */ 
/*     */ 
/*     */           
/* 230 */           paramSchemaTypeImpl = (SchemaTypeImpl)paramSchemaTypeImpl.getBaseEnumType();
/*     */         }
/*     */         else {
/*     */           
/* 234 */           SchemaStringEnumEntry[] arrayOfSchemaStringEnumEntry = new SchemaStringEnumEntry[arrayOfXmlAnySimpleType.length];
/* 235 */           SchemaType schemaType = paramSchemaTypeImpl.getBaseEnumType();
/* 236 */           if (schemaType == paramSchemaTypeImpl) {
/*     */             
/* 238 */             HashSet hashSet = new HashSet();
/* 239 */             for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++)
/*     */             {
/* 241 */               String str = arrayOfXmlAnySimpleType[b].getStringValue();
/*     */               
/* 243 */               arrayOfSchemaStringEnumEntry[b] = new SchemaStringEnumEntryImpl(str, b + 1, pickConstantName(hashSet, str));
/*     */             }
/*     */           
/*     */           } else {
/*     */             
/* 248 */             for (byte b = 0; b < arrayOfXmlAnySimpleType.length; b++) {
/*     */               
/* 250 */               String str = arrayOfXmlAnySimpleType[b].getStringValue();
/* 251 */               arrayOfSchemaStringEnumEntry[b] = schemaType.enumEntryForString(str);
/*     */             } 
/*     */           } 
/* 254 */           paramSchemaTypeImpl.setStringEnumEntries(arrayOfSchemaStringEnumEntry);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void javaizeType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 262 */     if (paramSchemaTypeImpl.isJavaized()) {
/*     */       return;
/*     */     }
/* 265 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)paramSchemaTypeImpl.getBaseType();
/* 266 */     if (schemaTypeImpl != null)
/* 267 */       javaizeType(schemaTypeImpl); 
/* 268 */     if (paramSchemaTypeImpl.getContentBasedOnType() != null && paramSchemaTypeImpl.getContentBasedOnType() != schemaTypeImpl) {
/* 269 */       javaizeType((SchemaTypeImpl)paramSchemaTypeImpl.getContentBasedOnType());
/*     */     }
/* 271 */     paramSchemaTypeImpl.startJavaizing();
/*     */     
/* 273 */     paramSchemaTypeImpl.setCompiled(true);
/*     */     
/* 275 */     secondPassProcessType(paramSchemaTypeImpl);
/*     */     
/* 277 */     if (!paramSchemaTypeImpl.isSimpleType()) {
/*     */       
/* 279 */       SchemaProperty[] arrayOfSchemaProperty1 = paramSchemaTypeImpl.getElementProperties();
/* 280 */       SchemaProperty[] arrayOfSchemaProperty2 = paramSchemaTypeImpl.getAttributeProperties();
/*     */ 
/*     */       
/* 283 */       HashSet hashSet = new HashSet();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 288 */       SchemaProperty[] arrayOfSchemaProperty3 = schemaTypeImpl.getProperties(); byte b;
/* 289 */       for (b = 0; b < arrayOfSchemaProperty3.length; b++) {
/*     */         
/* 291 */         String str = arrayOfSchemaProperty3[b].getJavaPropertyName();
/* 292 */         assert !hashSet.contains(str);
/* 293 */         hashSet.add(str);
/*     */       } 
/*     */ 
/*     */       
/* 297 */       avoidExtensionMethods(hashSet, paramSchemaTypeImpl);
/*     */ 
/*     */       
/* 300 */       for (b = 1;; b = 0) {
/*     */         
/* 302 */         if (arrayOfSchemaProperty1.length > 0) {
/* 303 */           assignJavaPropertyNames(hashSet, arrayOfSchemaProperty1, schemaTypeImpl, b);
/*     */         }
/* 305 */         assignJavaPropertyNames(hashSet, arrayOfSchemaProperty2, schemaTypeImpl, b);
/*     */         
/* 307 */         if (b == 0) {
/*     */           break;
/*     */         }
/*     */       } 
/* 311 */       SchemaProperty[] arrayOfSchemaProperty4 = paramSchemaTypeImpl.getProperties();
/*     */ 
/*     */       
/* 314 */       boolean bool = isPropertyModelOrderInsensitive(arrayOfSchemaProperty4);
/*     */ 
/*     */ 
/*     */       
/* 318 */       assignJavaTypeCodes(arrayOfSchemaProperty4);
/*     */       
/* 320 */       paramSchemaTypeImpl.setOrderSensitive(!bool);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 325 */     if (paramSchemaTypeImpl.getFullJavaName() != null || paramSchemaTypeImpl.getOuterType() != null) {
/* 326 */       assignJavaAnonymousTypeNames(paramSchemaTypeImpl);
/*     */     }
/* 328 */     paramSchemaTypeImpl.finishJavaizing();
/*     */   }
/*     */   
/* 331 */   private static final String[] PREFIXES = new String[] { "get", "xget", "isNil", "isSet", "sizeOf", "set", "xset", "addNew", "setNil", "unset", "insert", "add", "insertNew", "addNew", "remove" };
/*     */ 
/*     */ 
/*     */   
/*     */   private static void avoidExtensionMethods(Set paramSet, SchemaTypeImpl paramSchemaTypeImpl) {
/* 336 */     InterfaceExtension[] arrayOfInterfaceExtension = paramSchemaTypeImpl.getInterfaceExtensions();
/* 337 */     if (arrayOfInterfaceExtension != null) for (byte b = 0; b < arrayOfInterfaceExtension.length; b++) {
/*     */         
/* 339 */         InterfaceExtension interfaceExtension = arrayOfInterfaceExtension[b];
/* 340 */         InterfaceExtension.MethodSignature[] arrayOfMethodSignature = interfaceExtension.getMethods();
/* 341 */         for (byte b1 = 0; b1 < arrayOfMethodSignature.length; b1++) {
/*     */           
/* 343 */           String str = arrayOfMethodSignature[b1].getName();
/* 344 */           for (byte b2 = 0; b2 < PREFIXES.length; b2++) {
/*     */             
/* 346 */             String str1 = PREFIXES[b2];
/* 347 */             if (str.startsWith(str1)) {
/* 348 */               paramSet.add(str.substring(str1.length()));
/*     */             }
/*     */           } 
/*     */         } 
/*     */       }  
/*     */   }
/*     */   
/*     */   static void assignJavaAnonymousTypeNames(SchemaTypeImpl paramSchemaTypeImpl) {
/* 356 */     HashSet hashSet = new HashSet();
/* 357 */     SchemaType[] arrayOfSchemaType = paramSchemaTypeImpl.getAnonymousTypes();
/* 358 */     StscState stscState = StscState.get();
/*     */     
/* 360 */     int i = arrayOfSchemaType.length;
/* 361 */     if (paramSchemaTypeImpl.isRedefinition()) {
/*     */ 
/*     */ 
/*     */       
/* 365 */       ArrayList arrayList = new ArrayList();
/* 366 */       addAnonymousTypesFromRedefinition(paramSchemaTypeImpl, arrayList);
/* 367 */       if (arrayList.size() > 0) {
/*     */         
/* 369 */         SchemaType[] arrayOfSchemaType1 = new SchemaType[i + arrayList.size()];
/* 370 */         arrayList.toArray((Object[])arrayOfSchemaType1);
/* 371 */         System.arraycopy(arrayOfSchemaType, 0, arrayOfSchemaType1, arrayList.size(), i);
/* 372 */         arrayOfSchemaType = arrayOfSchemaType1;
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 380 */     SchemaTypeImpl schemaTypeImpl = paramSchemaTypeImpl;
/* 381 */     for (; schemaTypeImpl != null; 
/* 382 */       schemaType = schemaTypeImpl.getOuterType()) {
/*     */       SchemaType schemaType;
/* 384 */       hashSet.add(schemaTypeImpl.getShortJavaName());
/*     */     } 
/*     */     
/* 387 */     schemaTypeImpl = paramSchemaTypeImpl;
/* 388 */     for (; schemaTypeImpl != null; 
/* 389 */       schemaType = schemaTypeImpl.getOuterType()) {
/*     */       SchemaType schemaType;
/* 391 */       hashSet.add(schemaTypeImpl.getShortJavaImplName());
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 397 */     hashSet.add(getOutermostPackage(paramSchemaTypeImpl.getFullJavaName()));
/*     */ 
/*     */     
/* 400 */     for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*     */       
/* 402 */       SchemaTypeImpl schemaTypeImpl1 = (SchemaTypeImpl)arrayOfSchemaType[b];
/* 403 */       if (schemaTypeImpl1 != null)
/*     */       {
/* 405 */         if (!schemaTypeImpl1.isSkippedAnonymousType()) {
/*     */           
/* 407 */           String str1 = null;
/* 408 */           String str2 = null;
/*     */           
/* 410 */           SchemaField schemaField = schemaTypeImpl1.getContainerField();
/* 411 */           if (schemaField != null) {
/*     */             
/* 413 */             b b1 = schemaTypeImpl1.getContainerField().getName();
/* 414 */             str1 = b1.dT();
/* 415 */             str2 = stscState.getJavaname(schemaTypeImpl1.getContainerField().getName(), 1);
/*     */           
/*     */           }
/*     */           else {
/*     */             
/* 420 */             switch (schemaTypeImpl1.getOuterType().getSimpleVariety()) {
/*     */               
/*     */               case 2:
/* 423 */                 str2 = "Member"; break;
/*     */               case 3:
/* 425 */                 str2 = "Item";
/*     */                 break;
/*     */               default:
/* 428 */                 assert false : "Weird type " + schemaTypeImpl1.toString();
/* 429 */                 str2 = "Base";
/*     */                 break;
/*     */             } 
/*     */           } 
/* 433 */           if (b < i) {
/*     */             
/* 435 */             schemaTypeImpl1.setShortJavaName(pickInnerJavaClassName(hashSet, str1, str2));
/*     */             
/* 437 */             schemaTypeImpl1.setShortJavaImplName(pickInnerJavaImplName(hashSet, str1, (str2 == null) ? null : (str2 + "Impl")));
/*     */ 
/*     */           
/*     */           }
/*     */           else {
/*     */ 
/*     */             
/* 444 */             schemaTypeImpl1.setFullJavaName(paramSchemaTypeImpl.getFullJavaName() + "$" + pickInnerJavaClassName(hashSet, str1, str2));
/*     */             
/* 446 */             schemaTypeImpl1.setFullJavaImplName(paramSchemaTypeImpl.getFullJavaImplName() + "$" + pickInnerJavaImplName(hashSet, str1, (str2 == null) ? null : (str2 + "Impl")));
/*     */           } 
/*     */ 
/*     */ 
/*     */           
/* 451 */           setExtensions(schemaTypeImpl1, stscState);
/*     */         }  } 
/*     */     } 
/*     */   }
/*     */   
/*     */   static void assignJavaPropertyNames(Set paramSet, SchemaProperty[] paramArrayOfSchemaProperty, SchemaType paramSchemaType, boolean paramBoolean) {
/* 457 */     StscState stscState = StscState.get();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 466 */     for (byte b = 0; b < paramArrayOfSchemaProperty.length; b++) {
/*     */       
/* 468 */       SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)paramArrayOfSchemaProperty[b];
/*     */       
/* 470 */       SchemaProperty schemaProperty = schemaPropertyImpl.isAttribute() ? paramSchemaType.getAttributeProperty(schemaPropertyImpl.getName()) : paramSchemaType.getElementProperty(schemaPropertyImpl.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 475 */       if (((schemaProperty != null)) == paramBoolean) {
/*     */         String str;
/*     */         
/* 478 */         b b1 = schemaPropertyImpl.getName();
/*     */ 
/*     */ 
/*     */         
/* 482 */         if (schemaProperty == null) {
/* 483 */           str = pickJavaPropertyName(paramSet, b1.dT(), stscState.getJavaname(b1, schemaPropertyImpl.isAttribute() ? 4 : 3));
/*     */         }
/*     */         else {
/*     */           
/* 487 */           str = schemaProperty.getJavaPropertyName();
/*     */         } 
/* 489 */         schemaPropertyImpl.setJavaPropertyName(str);
/*     */         
/* 491 */         boolean bool1 = (schemaPropertyImpl.getMaxOccurs() == null || schemaPropertyImpl.getMaxOccurs().compareTo(BigInteger.ONE) > 0) ? true : false;
/*     */         
/* 493 */         boolean bool2 = (!bool1 && schemaPropertyImpl.getMaxOccurs().signum() > 0) ? true : false;
/* 494 */         boolean bool3 = (bool2 && schemaPropertyImpl.getMinOccurs().signum() == 0) ? true : false;
/* 495 */         SchemaType schemaType = schemaPropertyImpl.getType();
/*     */         
/* 497 */         if (schemaProperty != null) {
/*     */           
/* 499 */           if (schemaProperty.extendsJavaArray()) {
/*     */             
/* 501 */             bool2 = false;
/* 502 */             bool3 = false;
/* 503 */             bool1 = true;
/*     */           } 
/* 505 */           if (schemaProperty.extendsJavaSingleton())
/*     */           {
/* 507 */             bool2 = true;
/*     */           }
/* 509 */           if (schemaProperty.extendsJavaOption())
/*     */           {
/* 511 */             bool3 = true;
/*     */           }
/* 513 */           schemaType = schemaProperty.javaBasedOnType();
/*     */         } 
/*     */         
/* 516 */         schemaPropertyImpl.setExtendsJava(schemaType.getRef(), bool2, bool3, bool1);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static void assignJavaTypeCodes(SchemaProperty[] paramArrayOfSchemaProperty) {
/* 523 */     for (byte b = 0; b < paramArrayOfSchemaProperty.length; b++) {
/*     */       
/* 525 */       SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)paramArrayOfSchemaProperty[b];
/* 526 */       SchemaType schemaType = schemaPropertyImpl.javaBasedOnType();
/* 527 */       schemaPropertyImpl.setJavaTypeCode(javaTypeCodeForType(schemaType));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   static int javaTypeCodeInCommon(SchemaType[] paramArrayOfSchemaType) {
/* 533 */     if (paramArrayOfSchemaType == null || paramArrayOfSchemaType.length == 0) {
/* 534 */       return 0;
/*     */     }
/* 536 */     int i = javaTypeCodeForType(paramArrayOfSchemaType[0]);
/* 537 */     if (i == 19)
/* 538 */       return i; 
/* 539 */     for (byte b = 1; b < paramArrayOfSchemaType.length; b++) {
/*     */ 
/*     */       
/* 542 */       if (i != javaTypeCodeForType(paramArrayOfSchemaType[b]))
/* 543 */         return 19; 
/*     */     } 
/* 545 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   static int javaTypeCodeForType(SchemaType paramSchemaType) {
/* 550 */     if (!paramSchemaType.isSimpleType()) {
/* 551 */       return 0;
/*     */     }
/* 553 */     if (((SchemaTypeImpl)paramSchemaType).getUserTypeHandlerName() != null) {
/* 554 */       return 20;
/*     */     }
/* 556 */     if (paramSchemaType.getSimpleVariety() == 2) {
/*     */ 
/*     */       
/* 559 */       SchemaType schemaType = paramSchemaType.getUnionCommonBaseType();
/* 560 */       if (schemaType != null && !schemaType.isURType()) {
/* 561 */         paramSchemaType = schemaType;
/*     */       } else {
/* 563 */         return javaTypeCodeInCommon(paramSchemaType.getUnionConstituentTypes());
/*     */       } 
/*     */     } 
/* 566 */     if (paramSchemaType.getSimpleVariety() == 3) {
/* 567 */       return 16;
/*     */     }
/* 569 */     if (paramSchemaType.isURType()) {
/* 570 */       return 0;
/*     */     }
/* 572 */     switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*     */ 
/*     */       
/*     */       case 2:
/* 576 */         return 10;
/*     */       
/*     */       case 3:
/* 579 */         return 1;
/*     */       
/*     */       case 4:
/* 582 */         return 11;
/*     */       
/*     */       case 5:
/* 585 */         return 11;
/*     */       
/*     */       case 6:
/* 588 */         return 10;
/*     */       
/*     */       case 7:
/* 591 */         return 15;
/*     */       
/*     */       case 8:
/* 594 */         return 0;
/*     */       
/*     */       case 9:
/* 597 */         return 2;
/*     */       
/*     */       case 10:
/* 600 */         return 3;
/*     */       
/*     */       case 11:
/* 603 */         switch (paramSchemaType.getDecimalSize()) {
/*     */           
/*     */           case 8:
/* 606 */             return 4;
/*     */           case 16:
/* 608 */             return 5;
/*     */           case 32:
/* 610 */             return 6;
/*     */           case 64:
/* 612 */             return 7;
/*     */           case 1000000:
/* 614 */             return 9;
/*     */         } 
/*     */         
/* 617 */         return 8;
/*     */ 
/*     */       
/*     */       case 12:
/* 621 */         if (isStringType(paramSchemaType.getBaseEnumType())) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 628 */           if (paramSchemaType.getEnumerationValues() != null && (paramSchemaType.getEnumerationValues()).length > 3668)
/*     */           {
/*     */             
/* 631 */             return 10;
/*     */           }
/*     */ 
/*     */           
/* 635 */           return 18;
/*     */         } 
/*     */         
/* 638 */         return 10;
/*     */       
/*     */       case 13:
/* 641 */         return 13;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       case 14:
/*     */       case 15:
/*     */       case 16:
/*     */       case 17:
/*     */       case 18:
/*     */       case 19:
/*     */       case 20:
/*     */       case 21:
/* 654 */         return 17;
/*     */     } 
/*     */     
/* 657 */     assert false : "unrecognized code " + paramSchemaType.getPrimitiveType().getBuiltinTypeCode();
/* 658 */     throw new IllegalStateException("unrecognized code " + paramSchemaType.getPrimitiveType().getBuiltinTypeCode() + " of " + paramSchemaType.getPrimitiveType().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static boolean isPropertyModelOrderInsensitive(SchemaProperty[] paramArrayOfSchemaProperty) {
/* 664 */     for (byte b = 0; b < paramArrayOfSchemaProperty.length; b++) {
/*     */       
/* 666 */       SchemaProperty schemaProperty = paramArrayOfSchemaProperty[b];
/* 667 */       if (schemaProperty.hasNillable() == 1)
/* 668 */         return false; 
/* 669 */       if (schemaProperty.hasDefault() == 1)
/* 670 */         return false; 
/* 671 */       if (schemaProperty.hasFixed() == 1)
/* 672 */         return false; 
/* 673 */       if (schemaProperty.hasDefault() != 0 && schemaProperty.getDefaultText() == null)
/*     */       {
/* 675 */         return false; } 
/*     */     } 
/* 677 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean protectReservedGlobalClassNames(String paramString) {
/* 682 */     int i = paramString.lastIndexOf('.');
/* 683 */     String str = paramString.substring(i + 1);
/* 684 */     if (str.endsWith("Document") && !str.equals("Document"))
/* 685 */       return true; 
/* 686 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static boolean protectReservedInnerClassNames(String paramString) {
/* 691 */     return (paramString.equals("Enum") || paramString.equals("Factory"));
/*     */   }
/*     */   
/* 694 */   static String[] PROTECTED_PROPERTIES = new String[] { "StringValue", "BooleanValue", "ByteValue", "ShortValue", "IntValue", "LongValue", "BigIntegerValue", "BigDecimalValue", "FloatValue", "DoubleValue", "ByteArrayValue", "EnumValue", "CalendarValue", "DateValue", "GDateValue", "GDurationValue", "QNameValue", "ListValue", "ObjectValue", "Class" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 716 */   static Set PROTECTED_PROPERTIES_SET = new HashSet(Arrays.asList((Object[])PROTECTED_PROPERTIES));
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   static boolean protectReservedPropertyNames(String paramString) {
/* 720 */     return (PROTECTED_PROPERTIES_SET.contains(paramString) || (paramString.endsWith("Array") && !paramString.equals("Array")));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String pickFullJavaClassName(Set paramSet, b paramb, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*     */     String str1;
/*     */     boolean bool;
/*     */     String str3;
/* 729 */     if (paramString != null && paramString.indexOf('.') >= 0) {
/*     */ 
/*     */       
/* 732 */       str1 = paramString;
/* 733 */       bool = protectReservedGlobalClassNames(str1);
/*     */     }
/*     */     else {
/*     */       
/* 737 */       StscState stscState = StscState.get();
/* 738 */       String str4 = paramb.getNamespaceURI();
/*     */       
/* 740 */       str1 = NameUtil.getClassNameFromQName(paramb);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 746 */       str3 = stscState.getPackageOverride(str4);
/*     */       
/* 748 */       if (str3 != null)
/*     */       {
/*     */ 
/*     */         
/* 752 */         str1 = str3 + "." + str1.substring(str1.lastIndexOf('.') + 1);
/*     */       }
/*     */ 
/*     */       
/* 756 */       String str5 = stscState.getJavaPrefix(str4);
/* 757 */       if (str5 != null) {
/* 758 */         str1 = str1.substring(0, str1.lastIndexOf('.') + 1) + str5 + str1.substring(str1.lastIndexOf('.') + 1);
/*     */       }
/*     */       
/* 761 */       if (paramString != null)
/*     */       {
/* 763 */         str1 = str1.substring(0, str1.lastIndexOf('.') + 1) + paramString;
/*     */       }
/*     */       
/* 766 */       bool = protectReservedGlobalClassNames(str1);
/* 767 */       if (paramString == null) {
/*     */ 
/*     */         
/* 770 */         if (paramBoolean1) {
/* 771 */           str1 = str1 + "Document";
/* 772 */         } else if (paramBoolean2) {
/* 773 */           str1 = str1 + "Attribute";
/*     */         } 
/*     */         
/* 776 */         String str = stscState.getJavaSuffix(str4);
/* 777 */         if (str != null) {
/* 778 */           str1 = str1 + str;
/*     */         }
/*     */       } 
/*     */     } 
/* 782 */     String str2 = getOutermostPackage(str1);
/*     */     
/* 784 */     byte b1 = 1;
/*     */     
/* 786 */     if (bool) {
/* 787 */       str3 = str1 + b1;
/*     */     } else {
/* 789 */       str3 = str1;
/* 790 */     }  while (paramSet.contains(str3.toLowerCase()) || str3.equals(str2)) {
/*     */       
/* 792 */       b1++;
/* 793 */       str3 = str1 + b1;
/*     */     } 
/*     */     
/* 796 */     paramSet.add(str3.toLowerCase());
/*     */     
/* 798 */     return str3;
/*     */   }
/*     */ 
/*     */   
/*     */   static String getOutermostPackage(String paramString) {
/* 803 */     if (paramString == null) {
/* 804 */       return "";
/*     */     }
/*     */     
/* 807 */     int i = paramString.indexOf('.');
/* 808 */     if (i < 0) {
/* 809 */       return "";
/*     */     }
/*     */     
/* 812 */     return paramString.substring(0, i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static String pickFullJavaImplName(Set paramSet, String paramString) {
/* 818 */     String str1 = paramString;
/* 819 */     String str2 = null;
/* 820 */     int i = paramString.lastIndexOf('.');
/* 821 */     if (i >= 0) {
/*     */       
/* 823 */       str1 = paramString.substring(i + 1);
/* 824 */       str2 = paramString.substring(0, i);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 829 */     String str3 = str2 + ".impl." + str1 + "Impl";
/*     */     
/* 831 */     i = 1;
/* 832 */     String str4 = str3;
/* 833 */     while (paramSet.contains(str4.toLowerCase())) {
/*     */       
/* 835 */       i++;
/* 836 */       str4 = str3 + i;
/*     */     } 
/*     */     
/* 839 */     paramSet.add(str4.toLowerCase());
/*     */     
/* 841 */     return str4;
/*     */   }
/*     */   
/*     */   static String pickJavaPropertyName(Set paramSet, String paramString1, String paramString2) {
/*     */     String str;
/* 846 */     if (paramString2 == null)
/* 847 */       paramString2 = NameUtil.upperCamelCase(paramString1); 
/* 848 */     boolean bool = protectReservedPropertyNames(paramString2);
/*     */     
/* 850 */     byte b = 1;
/* 851 */     if (bool) {
/* 852 */       str = paramString2 + b;
/*     */     } else {
/* 854 */       str = paramString2;
/* 855 */     }  while (paramSet.contains(str)) {
/*     */       
/* 857 */       b++;
/* 858 */       str = paramString2 + b;
/*     */     } 
/*     */     
/* 861 */     paramSet.add(str);
/*     */     
/* 863 */     return str;
/*     */   }
/*     */   
/*     */   static String pickInnerJavaClassName(Set paramSet, String paramString1, String paramString2) {
/*     */     String str;
/* 868 */     if (paramString2 == null)
/* 869 */       paramString2 = NameUtil.upperCamelCase(paramString1); 
/* 870 */     boolean bool = protectReservedInnerClassNames(paramString2);
/*     */     
/* 872 */     byte b = 1;
/* 873 */     if (bool) {
/* 874 */       str = paramString2 + b;
/*     */     } else {
/* 876 */       str = paramString2;
/* 877 */     }  while (paramSet.contains(str)) {
/*     */       
/* 879 */       b++;
/* 880 */       str = paramString2 + b;
/*     */     } 
/*     */     
/* 883 */     paramSet.add(str);
/*     */     
/* 885 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   static String pickInnerJavaImplName(Set paramSet, String paramString1, String paramString2) {
/* 890 */     if (paramString2 == null)
/* 891 */       paramString2 = NameUtil.upperCamelCase(paramString1) + "Impl"; 
/* 892 */     String str = paramString2;
/* 893 */     byte b = 1;
/* 894 */     while (paramSet.contains(str)) {
/*     */       
/* 896 */       b++;
/* 897 */       str = paramString2 + b;
/*     */     } 
/*     */     
/* 900 */     paramSet.add(str);
/*     */     
/* 902 */     return str;
/*     */   }
/*     */ 
/*     */   
/*     */   static b findTopName(SchemaType paramSchemaType) {
/* 907 */     if (paramSchemaType.getName() != null) {
/* 908 */       return paramSchemaType.getName();
/*     */     }
/* 910 */     if (paramSchemaType.isDocumentType()) {
/*     */ 
/*     */       
/* 913 */       if (paramSchemaType.getContentModel() == null || paramSchemaType.getContentModel().getParticleType() != 4)
/* 914 */         throw new IllegalStateException(); 
/* 915 */       return paramSchemaType.getDocumentElementName();
/*     */     } 
/*     */     
/* 918 */     if (paramSchemaType.isAttributeType()) {
/*     */       
/* 920 */       if (paramSchemaType.getAttributeModel() == null || (paramSchemaType.getAttributeModel().getAttributes()).length != 1)
/* 921 */         throw new IllegalStateException(); 
/* 922 */       return paramSchemaType.getAttributeTypeAttributeName();
/*     */     } 
/*     */     
/* 925 */     SchemaField schemaField = paramSchemaType.getContainerField();
/* 926 */     assert schemaField != null;
/* 927 */     assert paramSchemaType.getOuterType() == null;
/* 928 */     return schemaField.getName();
/*     */   }
/*     */ 
/*     */   
/*     */   static void addAnonymousTypesFromRedefinition(SchemaType paramSchemaType, List paramList) {
/* 933 */     while (((SchemaTypeImpl)paramSchemaType).isRedefinition() && (paramSchemaType.getDerivationType() == 2 || paramSchemaType.isSimpleType())) {
/*     */ 
/*     */ 
/*     */       
/* 937 */       paramSchemaType = paramSchemaType.getBaseType();
/* 938 */       SchemaType[] arrayOfSchemaType = paramSchemaType.getAnonymousTypes();
/* 939 */       if (arrayOfSchemaType.length > 0)
/* 940 */         paramList.addAll(Arrays.asList(arrayOfSchemaType)); 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscJavaizer.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */