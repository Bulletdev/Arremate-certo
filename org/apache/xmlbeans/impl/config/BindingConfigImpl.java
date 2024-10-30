/*     */ package org.apache.xmlbeans.impl.config;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.BindingConfig;
/*     */ import org.apache.xmlbeans.InterfaceExtension;
/*     */ import org.apache.xmlbeans.PrePostExtension;
/*     */ import org.apache.xmlbeans.UserType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.jam.JamClassLoader;
/*     */ import org.apache.xmlbeans.impl.jam.JamService;
/*     */ import org.apache.xmlbeans.impl.jam.JamServiceFactory;
/*     */ import org.apache.xmlbeans.impl.jam.JamServiceParams;
/*     */ import org.apache.xmlbeans.impl.schema.StscState;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.ConfigDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Extensionconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Nsconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetenum;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BindingConfigImpl
/*     */   extends BindingConfig
/*     */ {
/*     */   private Map _packageMap;
/*     */   private Map _prefixMap;
/*     */   private Map _suffixMap;
/*     */   private Map _packageMapByUriPrefix;
/*     */   private Map _prefixMapByUriPrefix;
/*     */   private Map _suffixMapByUriPrefix;
/*     */   private Map _qnameTypeMap;
/*     */   private Map _qnameDocTypeMap;
/*     */   private Map _qnameElemMap;
/*     */   private Map _qnameAttMap;
/*     */   private List _interfaceExtensions;
/*     */   private List _prePostExtensions;
/*     */   private Map _userTypes;
/*     */   
/*     */   private BindingConfigImpl() {
/*  63 */     this._packageMap = Collections.EMPTY_MAP;
/*  64 */     this._prefixMap = Collections.EMPTY_MAP;
/*  65 */     this._suffixMap = Collections.EMPTY_MAP;
/*  66 */     this._packageMapByUriPrefix = Collections.EMPTY_MAP;
/*  67 */     this._prefixMapByUriPrefix = Collections.EMPTY_MAP;
/*  68 */     this._suffixMapByUriPrefix = Collections.EMPTY_MAP;
/*  69 */     this._qnameTypeMap = Collections.EMPTY_MAP;
/*  70 */     this._qnameDocTypeMap = Collections.EMPTY_MAP;
/*  71 */     this._qnameElemMap = Collections.EMPTY_MAP;
/*  72 */     this._qnameAttMap = Collections.EMPTY_MAP;
/*  73 */     this._interfaceExtensions = new ArrayList();
/*  74 */     this._prePostExtensions = new ArrayList();
/*  75 */     this._userTypes = Collections.EMPTY_MAP;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BindingConfig forConfigDocuments(ConfigDocument.Config[] paramArrayOfConfig, File[] paramArrayOfFile1, File[] paramArrayOfFile2) {
/*  80 */     return new BindingConfigImpl(paramArrayOfConfig, paramArrayOfFile1, paramArrayOfFile2);
/*     */   }
/*     */ 
/*     */   
/*     */   private BindingConfigImpl(ConfigDocument.Config[] paramArrayOfConfig, File[] paramArrayOfFile1, File[] paramArrayOfFile2) {
/*  85 */     this._packageMap = new LinkedHashMap();
/*  86 */     this._prefixMap = new LinkedHashMap();
/*  87 */     this._suffixMap = new LinkedHashMap();
/*  88 */     this._packageMapByUriPrefix = new LinkedHashMap();
/*  89 */     this._prefixMapByUriPrefix = new LinkedHashMap();
/*  90 */     this._suffixMapByUriPrefix = new LinkedHashMap();
/*  91 */     this._qnameTypeMap = new LinkedHashMap();
/*  92 */     this._qnameDocTypeMap = new LinkedHashMap();
/*  93 */     this._qnameElemMap = new LinkedHashMap();
/*  94 */     this._qnameAttMap = new LinkedHashMap();
/*  95 */     this._interfaceExtensions = new ArrayList();
/*  96 */     this._prePostExtensions = new ArrayList();
/*  97 */     this._userTypes = new LinkedHashMap();
/*     */     
/*  99 */     for (byte b = 0; b < paramArrayOfConfig.length; b++) {
/*     */       
/* 101 */       ConfigDocument.Config config = paramArrayOfConfig[b];
/* 102 */       Nsconfig[] arrayOfNsconfig = config.getNamespaceArray();
/* 103 */       for (byte b1 = 0; b1 < arrayOfNsconfig.length; b1++) {
/*     */         
/* 105 */         recordNamespaceSetting(arrayOfNsconfig[b1].getUri(), arrayOfNsconfig[b1].getPackage(), this._packageMap);
/* 106 */         recordNamespaceSetting(arrayOfNsconfig[b1].getUri(), arrayOfNsconfig[b1].getPrefix(), this._prefixMap);
/* 107 */         recordNamespaceSetting(arrayOfNsconfig[b1].getUri(), arrayOfNsconfig[b1].getSuffix(), this._suffixMap);
/* 108 */         recordNamespacePrefixSetting(arrayOfNsconfig[b1].getUriprefix(), arrayOfNsconfig[b1].getPackage(), this._packageMapByUriPrefix);
/* 109 */         recordNamespacePrefixSetting(arrayOfNsconfig[b1].getUriprefix(), arrayOfNsconfig[b1].getPrefix(), this._prefixMapByUriPrefix);
/* 110 */         recordNamespacePrefixSetting(arrayOfNsconfig[b1].getUriprefix(), arrayOfNsconfig[b1].getSuffix(), this._suffixMapByUriPrefix);
/*     */       } 
/*     */       
/* 113 */       Qnameconfig[] arrayOfQnameconfig = config.getQnameArray();
/* 114 */       for (byte b2 = 0; b2 < arrayOfQnameconfig.length; b2++) {
/*     */         
/* 116 */         List list = arrayOfQnameconfig[b2].xgetTarget().xgetListValue();
/* 117 */         b b5 = arrayOfQnameconfig[b2].getName();
/* 118 */         String str = arrayOfQnameconfig[b2].getJavaname();
/* 119 */         for (byte b6 = 0; b6 < list.size(); b6++) {
/*     */           
/* 121 */           Qnametargetenum qnametargetenum = list.get(b6);
/* 122 */           switch (qnametargetenum.enumValue().intValue()) {
/*     */             
/*     */             case 1:
/* 125 */               this._qnameTypeMap.put(b5, str);
/*     */               break;
/*     */             case 2:
/* 128 */               this._qnameDocTypeMap.put(b5, str);
/*     */               break;
/*     */             case 3:
/* 131 */               this._qnameElemMap.put(b5, str);
/*     */               break;
/*     */             case 4:
/* 134 */               this._qnameAttMap.put(b5, str);
/*     */               break;
/*     */           } 
/*     */         
/*     */         } 
/*     */       } 
/* 140 */       Extensionconfig[] arrayOfExtensionconfig = config.getExtensionArray();
/* 141 */       for (byte b3 = 0; b3 < arrayOfExtensionconfig.length; b3++)
/*     */       {
/* 143 */         recordExtensionSetting(paramArrayOfFile1, paramArrayOfFile2, arrayOfExtensionconfig[b3]);
/*     */       }
/*     */       
/* 146 */       Usertypeconfig[] arrayOfUsertypeconfig = config.getUsertypeArray();
/* 147 */       for (byte b4 = 0; b4 < arrayOfUsertypeconfig.length; b4++)
/*     */       {
/* 149 */         recordUserTypeSetting(paramArrayOfFile1, paramArrayOfFile2, arrayOfUsertypeconfig[b4]);
/*     */       }
/*     */     } 
/*     */     
/* 153 */     secondPhaseValidation();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void addInterfaceExtension(InterfaceExtensionImpl paramInterfaceExtensionImpl) {
/* 159 */     if (paramInterfaceExtensionImpl == null) {
/*     */       return;
/*     */     }
/* 162 */     this._interfaceExtensions.add(paramInterfaceExtensionImpl);
/*     */   }
/*     */ 
/*     */   
/*     */   void addPrePostExtension(PrePostExtensionImpl paramPrePostExtensionImpl) {
/* 167 */     if (paramPrePostExtensionImpl == null) {
/*     */       return;
/*     */     }
/* 170 */     this._prePostExtensions.add(paramPrePostExtensionImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void secondPhaseValidation() {
/* 176 */     HashMap hashMap = new HashMap();
/*     */     byte b;
/* 178 */     for (b = 0; b < this._interfaceExtensions.size(); b++) {
/*     */       
/* 180 */       InterfaceExtensionImpl interfaceExtensionImpl = this._interfaceExtensions.get(b);
/*     */       
/* 182 */       InterfaceExtensionImpl.MethodSignatureImpl[] arrayOfMethodSignatureImpl = (InterfaceExtensionImpl.MethodSignatureImpl[])interfaceExtensionImpl.getMethods();
/* 183 */       for (byte b1 = 0; b1 < arrayOfMethodSignatureImpl.length; b1++) {
/*     */         
/* 185 */         InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl = arrayOfMethodSignatureImpl[b1];
/*     */         
/* 187 */         if (hashMap.containsKey(arrayOfMethodSignatureImpl[b1])) {
/*     */ 
/*     */           
/* 190 */           InterfaceExtensionImpl.MethodSignatureImpl methodSignatureImpl1 = (InterfaceExtensionImpl.MethodSignatureImpl)hashMap.get(arrayOfMethodSignatureImpl[b1]);
/* 191 */           if (!methodSignatureImpl.getReturnType().equals(methodSignatureImpl1.getReturnType()))
/*     */           {
/* 193 */             error("Colliding methods '" + methodSignatureImpl.getSignature() + "' in interfaces " + methodSignatureImpl.getInterfaceName() + " and " + methodSignatureImpl1.getInterfaceName() + ".", null);
/*     */           }
/*     */ 
/*     */           
/*     */           return;
/*     */         } 
/*     */ 
/*     */         
/* 201 */         hashMap.put(arrayOfMethodSignatureImpl[b1], arrayOfMethodSignatureImpl[b1]);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 206 */     for (b = 0; b < this._prePostExtensions.size() - 1; b++) {
/*     */       
/* 208 */       PrePostExtensionImpl prePostExtensionImpl = this._prePostExtensions.get(b);
/* 209 */       for (byte b1 = 1; b1 < this._prePostExtensions.size(); b1++) {
/*     */         
/* 211 */         PrePostExtensionImpl prePostExtensionImpl1 = this._prePostExtensions.get(b1);
/* 212 */         if (prePostExtensionImpl.hasNameSetIntersection(prePostExtensionImpl1)) {
/* 213 */           error("The applicable domain for handler '" + prePostExtensionImpl.getHandlerNameForJavaSource() + "' intersects with the one for '" + prePostExtensionImpl1.getHandlerNameForJavaSource() + "'.", null);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void recordNamespaceSetting(Object paramObject, String paramString, Map paramMap) {
/* 221 */     if (paramString == null)
/*     */       return; 
/* 223 */     if (paramObject == null) {
/* 224 */       paramMap.put("", paramString);
/* 225 */     } else if (paramObject instanceof String && "##any".equals(paramObject)) {
/* 226 */       paramMap.put(paramObject, paramString);
/* 227 */     } else if (paramObject instanceof List) {
/*     */       
/* 229 */       for (String str : paramObject) {
/*     */ 
/*     */         
/* 232 */         if ("##local".equals(str))
/* 233 */           str = ""; 
/* 234 */         paramMap.put(str, paramString);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void recordNamespacePrefixSetting(List paramList, String paramString, Map paramMap) {
/* 241 */     if (paramString == null)
/*     */       return; 
/* 243 */     if (paramList == null)
/*     */       return; 
/* 245 */     for (Iterator iterator = paramList.iterator(); iterator.hasNext();)
/*     */     {
/* 247 */       paramMap.put(iterator.next(), paramString);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private void recordExtensionSetting(File[] paramArrayOfFile1, File[] paramArrayOfFile2, Extensionconfig paramExtensionconfig) {
/* 253 */     NameSet nameSet = null;
/* 254 */     Object object = paramExtensionconfig.getFor();
/*     */ 
/*     */     
/* 257 */     if (object instanceof String && "*".equals(object)) {
/* 258 */       nameSet = NameSet.EVERYTHING;
/* 259 */     } else if (object instanceof List) {
/*     */       
/* 261 */       NameSetBuilder nameSetBuilder = new NameSetBuilder();
/* 262 */       for (String str : object)
/*     */       {
/*     */         
/* 265 */         nameSetBuilder.add(str);
/*     */       }
/* 267 */       nameSet = nameSetBuilder.toNameSet();
/*     */     } 
/*     */     
/* 270 */     if (nameSet == null) {
/* 271 */       error("Invalid value of attribute 'for' : '" + object + "'.", (XmlObject)paramExtensionconfig);
/*     */     }
/* 273 */     Extensionconfig.Interface[] arrayOfInterface = paramExtensionconfig.getInterfaceArray();
/* 274 */     Extensionconfig.PrePostSet prePostSet = paramExtensionconfig.getPrePostSet();
/*     */     
/* 276 */     if (arrayOfInterface.length > 0 || prePostSet != null) {
/*     */       
/* 278 */       JamClassLoader jamClassLoader = getJamLoader(paramArrayOfFile1, paramArrayOfFile2);
/* 279 */       for (byte b = 0; b < arrayOfInterface.length; b++)
/*     */       {
/* 281 */         addInterfaceExtension(InterfaceExtensionImpl.newInstance(jamClassLoader, nameSet, arrayOfInterface[b]));
/*     */       }
/*     */       
/* 284 */       addPrePostExtension(PrePostExtensionImpl.newInstance(jamClassLoader, nameSet, prePostSet));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void recordUserTypeSetting(File[] paramArrayOfFile1, File[] paramArrayOfFile2, Usertypeconfig paramUsertypeconfig) {
/* 291 */     JamClassLoader jamClassLoader = getJamLoader(paramArrayOfFile1, paramArrayOfFile2);
/* 292 */     UserTypeImpl userTypeImpl = UserTypeImpl.newInstance(jamClassLoader, paramUsertypeconfig);
/* 293 */     this._userTypes.put(userTypeImpl.getName(), userTypeImpl);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private String lookup(Map paramMap1, Map paramMap2, String paramString) {
/* 299 */     if (paramString == null)
/* 300 */       paramString = ""; 
/* 301 */     String str = (String)paramMap1.get(paramString);
/* 302 */     if (str != null)
/* 303 */       return str; 
/* 304 */     if (paramMap2 != null) {
/*     */       
/* 306 */       str = lookupByUriPrefix(paramMap2, paramString);
/* 307 */       if (str != null) {
/* 308 */         return str;
/*     */       }
/*     */     } 
/* 311 */     return (String)paramMap1.get("##any");
/*     */   }
/*     */ 
/*     */   
/*     */   private String lookupByUriPrefix(Map paramMap, String paramString) {
/* 316 */     if (paramString == null)
/* 317 */       return null; 
/* 318 */     if (!paramMap.isEmpty()) {
/*     */       
/* 320 */       String str = null;
/* 321 */       Iterator iterator = paramMap.keySet().iterator();
/* 322 */       while (iterator.hasNext()) {
/*     */         
/* 324 */         String str1 = iterator.next();
/* 325 */         if (str != null && str1.length() < str.length())
/*     */           continue; 
/* 327 */         if (paramString.startsWith(str1)) {
/* 328 */           str = str1;
/*     */         }
/*     */       } 
/* 331 */       if (str != null)
/* 332 */         return (String)paramMap.get(str); 
/*     */     } 
/* 334 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static void warning(String paramString, XmlObject paramXmlObject) {
/* 340 */     StscState.get().error(paramString, 1, paramXmlObject);
/*     */   }
/*     */ 
/*     */   
/*     */   static void error(String paramString, XmlObject paramXmlObject) {
/* 345 */     StscState.get().error(paramString, 0, paramXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String lookupPackageForNamespace(String paramString) {
/* 352 */     return lookup(this._packageMap, this._packageMapByUriPrefix, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String lookupPrefixForNamespace(String paramString) {
/* 357 */     return lookup(this._prefixMap, this._prefixMapByUriPrefix, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String lookupSuffixForNamespace(String paramString) {
/* 362 */     return lookup(this._suffixMap, this._suffixMapByUriPrefix, paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String lookupJavanameForQName(b paramb) {
/* 368 */     String str = (String)this._qnameTypeMap.get(paramb);
/* 369 */     if (str != null)
/* 370 */       return str; 
/* 371 */     return (String)this._qnameDocTypeMap.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public String lookupJavanameForQName(b paramb, int paramInt) {
/* 376 */     switch (paramInt) {
/*     */       
/*     */       case 1:
/* 379 */         return (String)this._qnameTypeMap.get(paramb);
/*     */       case 2:
/* 381 */         return (String)this._qnameDocTypeMap.get(paramb);
/*     */       case 3:
/* 383 */         return (String)this._qnameElemMap.get(paramb);
/*     */       case 4:
/* 385 */         return (String)this._qnameAttMap.get(paramb);
/*     */     } 
/* 387 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public UserType lookupUserTypeForQName(b paramb) {
/* 392 */     if (paramb == null) {
/* 393 */       return null;
/*     */     }
/* 395 */     return (UserType)this._userTypes.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public InterfaceExtension[] getInterfaceExtensions() {
/* 400 */     return (InterfaceExtension[])this._interfaceExtensions.toArray((Object[])new InterfaceExtension[this._interfaceExtensions.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public InterfaceExtension[] getInterfaceExtensions(String paramString) {
/* 405 */     ArrayList arrayList = new ArrayList();
/* 406 */     for (byte b = 0; b < this._interfaceExtensions.size(); b++) {
/*     */       
/* 408 */       InterfaceExtensionImpl interfaceExtensionImpl = this._interfaceExtensions.get(b);
/* 409 */       if (interfaceExtensionImpl.contains(paramString)) {
/* 410 */         arrayList.add(interfaceExtensionImpl);
/*     */       }
/*     */     } 
/* 413 */     return arrayList.<InterfaceExtension>toArray(new InterfaceExtension[arrayList.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public PrePostExtension[] getPrePostExtensions() {
/* 418 */     return (PrePostExtension[])this._prePostExtensions.toArray((Object[])new PrePostExtension[this._prePostExtensions.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public PrePostExtension getPrePostExtension(String paramString) {
/* 423 */     for (byte b = 0; b < this._prePostExtensions.size(); b++) {
/*     */       
/* 425 */       PrePostExtensionImpl prePostExtensionImpl = this._prePostExtensions.get(b);
/* 426 */       if (prePostExtensionImpl.contains(paramString))
/* 427 */         return prePostExtensionImpl; 
/*     */     } 
/* 429 */     return null;
/*     */   }
/*     */   
/*     */   private JamClassLoader getJamLoader(File[] paramArrayOfFile1, File[] paramArrayOfFile2) {
/*     */     JamService jamService;
/* 434 */     JamServiceFactory jamServiceFactory = JamServiceFactory.getInstance();
/* 435 */     JamServiceParams jamServiceParams = jamServiceFactory.createServiceParams();
/* 436 */     jamServiceParams.set14WarningsEnabled(false);
/*     */     
/* 438 */     jamServiceParams.setShowWarnings(false);
/*     */ 
/*     */     
/* 441 */     if (paramArrayOfFile1 != null) {
/* 442 */       for (byte b = 0; b < paramArrayOfFile1.length; b++) {
/* 443 */         jamServiceParams.includeSourceFile(paramArrayOfFile1[b]);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/* 448 */     jamServiceParams.addClassLoader(getClass().getClassLoader());
/* 449 */     if (paramArrayOfFile2 != null) {
/* 450 */       for (byte b = 0; b < paramArrayOfFile2.length; b++) {
/* 451 */         jamServiceParams.addClasspath(paramArrayOfFile2[b]);
/*     */       }
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 457 */       jamService = jamServiceFactory.createService(jamServiceParams);
/*     */     }
/* 459 */     catch (IOException iOException) {
/*     */       
/* 461 */       error("Error when accessing .java files.", null);
/* 462 */       return null;
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
/*     */     
/* 478 */     return jamService.getClassLoader();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\config\BindingConfigImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */