/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.lang.ref.SoftReference;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.IdentityHashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.ResourceLoader;
/*     */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*     */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*     */ import org.apache.xmlbeans.SchemaGlobalElement;
/*     */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*     */ import org.apache.xmlbeans.SchemaModelGroup;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.SystemCache;
/*     */ import org.apache.xmlbeans.impl.common.XBeanDebug;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaTypeLoaderImpl
/*     */   extends SchemaTypeLoaderBase
/*     */ {
/*     */   private ResourceLoader _resourceLoader;
/*     */   private ClassLoader _classLoader;
/*     */   private SchemaTypeLoader[] _searchPath;
/*     */   private Map _classpathTypeSystems;
/*     */   private Map _classLoaderTypeSystems;
/*     */   private Map _elementCache;
/*     */   private Map _attributeCache;
/*     */   private Map _modelGroupCache;
/*     */   private Map _attributeGroupCache;
/*     */   private Map _idConstraintCache;
/*     */   private Map _typeCache;
/*     */   private Map _documentCache;
/*     */   private Map _attributeTypeCache;
/*     */   private Map _classnameCache;
/*  60 */   public static String METADATA_PACKAGE_LOAD = SchemaTypeSystemImpl.METADATA_PACKAGE_GEN;
/*  61 */   private static final Object CACHED_NOT_FOUND = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SchemaTypeLoaderCache
/*     */     extends SystemCache
/*     */   {
/*  69 */     private ThreadLocal _cachedTypeSystems = new ThreadLocal() { protected Object initialValue() {
/*  70 */           return new ArrayList();
/*     */         } private final SchemaTypeLoaderImpl.SchemaTypeLoaderCache this$0; }
/*     */     ; static final boolean $assertionsDisabled;
/*     */     public SchemaTypeLoader getFromTypeLoaderCache(ClassLoader param1ClassLoader) {
/*  74 */       ArrayList arrayList = this._cachedTypeSystems.get();
/*     */       
/*  76 */       byte b = -1;
/*  77 */       SchemaTypeLoaderImpl schemaTypeLoaderImpl = null;
/*     */       byte b1;
/*  79 */       for (b1 = 0; b1 < arrayList.size(); b1++) {
/*     */         
/*  81 */         SchemaTypeLoaderImpl schemaTypeLoaderImpl1 = ((SoftReference)arrayList.get(b1)).get();
/*     */         
/*  83 */         if (schemaTypeLoaderImpl1 == null) {
/*     */           
/*  85 */           assert b1 > b;
/*  86 */           arrayList.remove(b1--);
/*     */         }
/*  88 */         else if (schemaTypeLoaderImpl1._classLoader == param1ClassLoader) {
/*     */           
/*  90 */           assert b == -1 && schemaTypeLoaderImpl == null;
/*     */           
/*  92 */           b = b1;
/*  93 */           schemaTypeLoaderImpl = schemaTypeLoaderImpl1;
/*     */ 
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 101 */       if (b > 0) {
/*     */         
/* 103 */         b1 = arrayList.get(0);
/* 104 */         arrayList.set(0, arrayList.get(b));
/* 105 */         arrayList.set(b, b1);
/*     */       } 
/*     */       
/* 108 */       return schemaTypeLoaderImpl;
/*     */     }
/*     */ 
/*     */     
/*     */     public void addToTypeLoaderCache(SchemaTypeLoader param1SchemaTypeLoader, ClassLoader param1ClassLoader) {
/* 113 */       assert param1SchemaTypeLoader instanceof SchemaTypeLoaderImpl && ((SchemaTypeLoaderImpl)param1SchemaTypeLoader)._classLoader == param1ClassLoader;
/*     */ 
/*     */       
/* 116 */       ArrayList arrayList = this._cachedTypeSystems.get();
/*     */       
/* 118 */       if (arrayList.size() > 0) {
/*     */         
/* 120 */         Object object = arrayList.get(0);
/* 121 */         arrayList.set(0, new SoftReference(param1SchemaTypeLoader));
/* 122 */         arrayList.add(object);
/*     */       } else {
/*     */         
/* 125 */         arrayList.add(new SoftReference(param1SchemaTypeLoader));
/*     */       } 
/*     */     }
/*     */     private SchemaTypeLoaderCache() {} }
/*     */   
/*     */   public static SchemaTypeLoaderImpl getContextTypeLoader() {
/* 131 */     ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
/* 132 */     SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl)SystemCache.get().getFromTypeLoaderCache(classLoader);
/*     */ 
/*     */     
/* 135 */     if (schemaTypeLoaderImpl == null) {
/*     */       
/* 137 */       schemaTypeLoaderImpl = new SchemaTypeLoaderImpl(new SchemaTypeLoader[] { (SchemaTypeLoader)BuiltinSchemaTypeSystem.get() }, null, classLoader);
/*     */ 
/*     */       
/* 140 */       SystemCache.get().addToTypeLoaderCache(schemaTypeLoaderImpl, classLoader);
/*     */     } 
/*     */     
/* 143 */     return schemaTypeLoaderImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   public static SchemaTypeLoader build(SchemaTypeLoader[] paramArrayOfSchemaTypeLoader, ResourceLoader paramResourceLoader, ClassLoader paramClassLoader) {
/* 148 */     if (paramArrayOfSchemaTypeLoader == null) {
/*     */       
/* 150 */       paramArrayOfSchemaTypeLoader = EMPTY_SCHEMATYPELOADER_ARRAY;
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 155 */       SubLoaderList subLoaderList = new SubLoaderList();
/* 156 */       for (byte b = 0; b < paramArrayOfSchemaTypeLoader.length; b++) {
/*     */         
/* 158 */         if (paramArrayOfSchemaTypeLoader[b] == null)
/* 159 */           throw new IllegalArgumentException("searchPath[" + b + "] is null"); 
/* 160 */         if (!(paramArrayOfSchemaTypeLoader[b] instanceof SchemaTypeLoaderImpl)) {
/* 161 */           subLoaderList.add(paramArrayOfSchemaTypeLoader[b]);
/*     */         } else {
/*     */           
/* 164 */           SchemaTypeLoaderImpl schemaTypeLoaderImpl = (SchemaTypeLoaderImpl)paramArrayOfSchemaTypeLoader[b];
/* 165 */           if (schemaTypeLoaderImpl._classLoader != null || schemaTypeLoaderImpl._resourceLoader != null)
/* 166 */           { subLoaderList.add(schemaTypeLoaderImpl); }
/* 167 */           else { for (byte b1 = 0; b1 < schemaTypeLoaderImpl._searchPath.length; b1++)
/* 168 */               subLoaderList.add(schemaTypeLoaderImpl._searchPath[b1]);  }
/*     */         
/*     */         } 
/* 171 */       }  paramArrayOfSchemaTypeLoader = subLoaderList.toArray();
/*     */     } 
/*     */     
/* 174 */     if (paramArrayOfSchemaTypeLoader.length == 1 && paramResourceLoader == null && paramClassLoader == null) {
/* 175 */       return paramArrayOfSchemaTypeLoader[0];
/*     */     }
/* 177 */     return new SchemaTypeLoaderImpl(paramArrayOfSchemaTypeLoader, paramResourceLoader, paramClassLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class SubLoaderList
/*     */   {
/* 185 */     private List theList = new ArrayList();
/* 186 */     private Map seen = new IdentityHashMap();
/*     */ 
/*     */     
/*     */     private boolean add(SchemaTypeLoader param1SchemaTypeLoader) {
/* 190 */       if (this.seen.containsKey(param1SchemaTypeLoader))
/* 191 */         return false; 
/* 192 */       this.theList.add(param1SchemaTypeLoader);
/* 193 */       this.seen.put(param1SchemaTypeLoader, null);
/* 194 */       return true;
/*     */     }
/*     */ 
/*     */     
/*     */     private SchemaTypeLoader[] toArray() {
/* 199 */       return (SchemaTypeLoader[])this.theList.toArray((Object[])SchemaTypeLoaderImpl.EMPTY_SCHEMATYPELOADER_ARRAY);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     private SubLoaderList() {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private SchemaTypeLoaderImpl(SchemaTypeLoader[] paramArrayOfSchemaTypeLoader, ResourceLoader paramResourceLoader, ClassLoader paramClassLoader) {
/* 219 */     if (paramArrayOfSchemaTypeLoader == null) {
/* 220 */       this._searchPath = EMPTY_SCHEMATYPELOADER_ARRAY;
/*     */     } else {
/* 222 */       this._searchPath = paramArrayOfSchemaTypeLoader;
/* 223 */     }  this._resourceLoader = paramResourceLoader;
/* 224 */     this._classLoader = paramClassLoader;
/*     */     
/* 226 */     initCaches();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final void initCaches() {
/* 234 */     this._classpathTypeSystems = Collections.synchronizedMap(new HashMap());
/* 235 */     this._classLoaderTypeSystems = Collections.synchronizedMap(new HashMap());
/* 236 */     this._elementCache = Collections.synchronizedMap(new HashMap());
/* 237 */     this._attributeCache = Collections.synchronizedMap(new HashMap());
/* 238 */     this._modelGroupCache = Collections.synchronizedMap(new HashMap());
/* 239 */     this._attributeGroupCache = Collections.synchronizedMap(new HashMap());
/* 240 */     this._idConstraintCache = Collections.synchronizedMap(new HashMap());
/* 241 */     this._typeCache = Collections.synchronizedMap(new HashMap());
/* 242 */     this._documentCache = Collections.synchronizedMap(new HashMap());
/* 243 */     this._attributeTypeCache = Collections.synchronizedMap(new HashMap());
/* 244 */     this._classnameCache = Collections.synchronizedMap(new HashMap());
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaTypeSystemImpl typeSystemForComponent(String paramString, b paramb) {
/* 249 */     String str1 = paramString + QNameHelper.hexsafedir(paramb) + ".xsb";
/* 250 */     String str2 = null;
/*     */     
/* 252 */     if (this._resourceLoader != null) {
/* 253 */       str2 = crackEntry(this._resourceLoader, str1);
/*     */     }
/* 255 */     if (this._classLoader != null) {
/* 256 */       str2 = crackEntry(this._classLoader, str1);
/*     */     }
/* 258 */     if (str2 != null) {
/* 259 */       return (SchemaTypeSystemImpl)typeSystemForName(str2);
/*     */     }
/* 261 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaTypeSystem typeSystemForName(String paramString) {
/* 266 */     if (this._resourceLoader != null) {
/*     */       
/* 268 */       SchemaTypeSystemImpl schemaTypeSystemImpl = getTypeSystemOnClasspath(paramString);
/* 269 */       if (schemaTypeSystemImpl != null) {
/* 270 */         return schemaTypeSystemImpl;
/*     */       }
/*     */     } 
/* 273 */     if (this._classLoader != null) {
/*     */       
/* 275 */       SchemaTypeSystemImpl schemaTypeSystemImpl = getTypeSystemOnClassloader(paramString);
/* 276 */       if (schemaTypeSystemImpl != null)
/* 277 */         return schemaTypeSystemImpl; 
/*     */     } 
/* 279 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaTypeSystemImpl typeSystemForClassname(String paramString1, String paramString2) {
/* 284 */     String str = paramString1 + paramString2.replace('.', '/') + ".xsb";
/*     */     
/* 286 */     if (this._resourceLoader != null) {
/*     */       
/* 288 */       String str1 = crackEntry(this._resourceLoader, str);
/* 289 */       if (str1 != null) {
/* 290 */         return getTypeSystemOnClasspath(str1);
/*     */       }
/*     */     } 
/* 293 */     if (this._classLoader != null) {
/*     */       
/* 295 */       String str1 = crackEntry(this._classLoader, str);
/* 296 */       if (str1 != null) {
/* 297 */         return getTypeSystemOnClassloader(str1);
/*     */       }
/*     */     } 
/* 300 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaTypeSystemImpl getTypeSystemOnClasspath(String paramString) {
/* 305 */     SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl)this._classpathTypeSystems.get(paramString);
/* 306 */     if (schemaTypeSystemImpl == null) {
/*     */       
/* 308 */       schemaTypeSystemImpl = new SchemaTypeSystemImpl(this._resourceLoader, paramString, this);
/* 309 */       this._classpathTypeSystems.put(paramString, schemaTypeSystemImpl);
/*     */     } 
/* 311 */     return schemaTypeSystemImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   SchemaTypeSystemImpl getTypeSystemOnClassloader(String paramString) {
/* 316 */     XBeanDebug.trace(1, "Finding type system " + paramString + " on classloader", 0);
/* 317 */     SchemaTypeSystemImpl schemaTypeSystemImpl = (SchemaTypeSystemImpl)this._classLoaderTypeSystems.get(paramString);
/* 318 */     if (schemaTypeSystemImpl == null) {
/*     */       
/* 320 */       XBeanDebug.trace(1, "Type system " + paramString + " not cached - consulting field", 0);
/* 321 */       schemaTypeSystemImpl = SchemaTypeSystemImpl.forName(paramString, this._classLoader);
/* 322 */       this._classLoaderTypeSystems.put(paramString, schemaTypeSystemImpl);
/*     */     } 
/* 324 */     return schemaTypeSystemImpl;
/*     */   }
/*     */ 
/*     */   
/*     */   static String crackEntry(ResourceLoader paramResourceLoader, String paramString) {
/* 329 */     InputStream inputStream = paramResourceLoader.getResourceAsStream(paramString);
/* 330 */     if (inputStream == null)
/* 331 */       return null; 
/* 332 */     return crackPointer(inputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   static String crackEntry(ClassLoader paramClassLoader, String paramString) {
/* 337 */     InputStream inputStream = paramClassLoader.getResourceAsStream(paramString);
/* 338 */     if (inputStream == null)
/* 339 */       return null; 
/* 340 */     return crackPointer(inputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   static String crackPointer(InputStream paramInputStream) {
/* 345 */     return SchemaTypeSystemImpl.crackPointer(paramInputStream);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isNamespaceDefined(String paramString) {
/* 350 */     for (byte b = 0; b < this._searchPath.length; b++) {
/* 351 */       if (this._searchPath[b].isNamespaceDefined(paramString))
/* 352 */         return true; 
/*     */     } 
/* 354 */     SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/namespace/", new b(paramString, "xmlns"));
/* 355 */     return (schemaTypeSystemImpl != null);
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
/*     */   public SchemaType.Ref findTypeRef(b paramb) {
/* 367 */     Object object = this._typeCache.get(paramb);
/* 368 */     if (object == CACHED_NOT_FOUND)
/* 369 */       return null; 
/* 370 */     SchemaType.Ref ref = (SchemaType.Ref)object;
/* 371 */     if (ref == null) {
/*     */       
/* 373 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 374 */         null == (ref = this._searchPath[b1].findTypeRef(paramb)); b1++);
/*     */       
/* 376 */       if (ref == null) {
/*     */         
/* 378 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/type/", paramb);
/* 379 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 381 */           ref = schemaTypeSystemImpl.findTypeRef(paramb);
/* 382 */           assert ref != null : "Type system registered type " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 385 */       this._typeCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 387 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType typeForClassname(String paramString) {
/* 392 */     paramString = paramString.replace('$', '.');
/*     */     
/* 394 */     Object object = this._classnameCache.get(paramString);
/* 395 */     if (object == CACHED_NOT_FOUND)
/* 396 */       return null; 
/* 397 */     SchemaType schemaType = (SchemaType)object;
/* 398 */     if (schemaType == null) {
/*     */       
/* 400 */       for (byte b = 0; b < this._searchPath.length && 
/* 401 */         null == (schemaType = this._searchPath[b].typeForClassname(paramString)); b++);
/*     */       
/* 403 */       if (schemaType == null) {
/*     */         
/* 405 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForClassname("schema" + METADATA_PACKAGE_LOAD + "/javaname/", paramString);
/* 406 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 408 */           schemaType = schemaTypeSystemImpl.typeForClassname(paramString);
/* 409 */           assert schemaType != null : "Type system registered type " + paramString + " but does not return it";
/*     */         } 
/*     */       } 
/* 412 */       this._classnameCache.put(paramString, (schemaType == null) ? CACHED_NOT_FOUND : schemaType);
/*     */     } 
/* 414 */     return schemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType.Ref findDocumentTypeRef(b paramb) {
/* 419 */     Object object = this._documentCache.get(paramb);
/* 420 */     if (object == CACHED_NOT_FOUND)
/* 421 */       return null; 
/* 422 */     SchemaType.Ref ref = (SchemaType.Ref)object;
/* 423 */     if (ref == null) {
/*     */       
/* 425 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 426 */         null == (ref = this._searchPath[b1].findDocumentTypeRef(paramb)); b1++);
/*     */       
/* 428 */       if (ref == null) {
/*     */         
/* 430 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/element/", paramb);
/* 431 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 433 */           ref = schemaTypeSystemImpl.findDocumentTypeRef(paramb);
/* 434 */           assert ref != null : "Type system registered element " + QNameHelper.pretty(paramb) + " but does not contain document type";
/*     */         } 
/*     */       } 
/* 437 */       this._documentCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 439 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType.Ref findAttributeTypeRef(b paramb) {
/* 444 */     Object object = this._attributeTypeCache.get(paramb);
/* 445 */     if (object == CACHED_NOT_FOUND)
/* 446 */       return null; 
/* 447 */     SchemaType.Ref ref = (SchemaType.Ref)object;
/* 448 */     if (ref == null) {
/*     */       
/* 450 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 451 */         null == (ref = this._searchPath[b1].findAttributeTypeRef(paramb)); b1++);
/*     */       
/* 453 */       if (ref == null) {
/*     */         
/* 455 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/attribute/", paramb);
/* 456 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 458 */           ref = schemaTypeSystemImpl.findAttributeTypeRef(paramb);
/* 459 */           assert ref != null : "Type system registered attribute " + QNameHelper.pretty(paramb) + " but does not contain attribute type";
/*     */         } 
/*     */       } 
/* 462 */       this._attributeTypeCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 464 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalElement.Ref findElementRef(b paramb) {
/* 469 */     Object object = this._elementCache.get(paramb);
/* 470 */     if (object == CACHED_NOT_FOUND)
/* 471 */       return null; 
/* 472 */     SchemaGlobalElement.Ref ref = (SchemaGlobalElement.Ref)object;
/* 473 */     if (ref == null) {
/*     */       
/* 475 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 476 */         null == (ref = this._searchPath[b1].findElementRef(paramb)); b1++);
/*     */       
/* 478 */       if (ref == null) {
/*     */         
/* 480 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/element/", paramb);
/* 481 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 483 */           ref = schemaTypeSystemImpl.findElementRef(paramb);
/* 484 */           assert ref != null : "Type system registered element " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 487 */       this._elementCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 489 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaGlobalAttribute.Ref findAttributeRef(b paramb) {
/* 494 */     Object object = this._attributeCache.get(paramb);
/* 495 */     if (object == CACHED_NOT_FOUND)
/* 496 */       return null; 
/* 497 */     SchemaGlobalAttribute.Ref ref = (SchemaGlobalAttribute.Ref)object;
/* 498 */     if (ref == null) {
/*     */       
/* 500 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 501 */         null == (ref = this._searchPath[b1].findAttributeRef(paramb)); b1++);
/*     */       
/* 503 */       if (ref == null) {
/*     */         
/* 505 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/attribute/", paramb);
/* 506 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 508 */           ref = schemaTypeSystemImpl.findAttributeRef(paramb);
/* 509 */           assert ref != null : "Type system registered attribute " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 512 */       this._attributeCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 514 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaModelGroup.Ref findModelGroupRef(b paramb) {
/* 519 */     Object object = this._modelGroupCache.get(paramb);
/* 520 */     if (object == CACHED_NOT_FOUND)
/* 521 */       return null; 
/* 522 */     SchemaModelGroup.Ref ref = (SchemaModelGroup.Ref)object;
/* 523 */     if (ref == null) {
/*     */       
/* 525 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 526 */         null == (ref = this._searchPath[b1].findModelGroupRef(paramb)); b1++);
/*     */       
/* 528 */       if (ref == null) {
/*     */         
/* 530 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/modelgroup/", paramb);
/* 531 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 533 */           ref = schemaTypeSystemImpl.findModelGroupRef(paramb);
/* 534 */           assert ref != null : "Type system registered model group " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 537 */       this._modelGroupCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 539 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaAttributeGroup.Ref findAttributeGroupRef(b paramb) {
/* 544 */     Object object = this._attributeGroupCache.get(paramb);
/* 545 */     if (object == CACHED_NOT_FOUND)
/* 546 */       return null; 
/* 547 */     SchemaAttributeGroup.Ref ref = (SchemaAttributeGroup.Ref)object;
/* 548 */     if (ref == null) {
/*     */       
/* 550 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 551 */         null == (ref = this._searchPath[b1].findAttributeGroupRef(paramb)); b1++);
/*     */       
/* 553 */       if (ref == null) {
/*     */         
/* 555 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/attributegroup/", paramb);
/* 556 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 558 */           ref = schemaTypeSystemImpl.findAttributeGroupRef(paramb);
/* 559 */           assert ref != null : "Type system registered attribute group " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 562 */       this._attributeGroupCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 564 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaIdentityConstraint.Ref findIdentityConstraintRef(b paramb) {
/* 569 */     Object object = this._idConstraintCache.get(paramb);
/* 570 */     if (object == CACHED_NOT_FOUND)
/* 571 */       return null; 
/* 572 */     SchemaIdentityConstraint.Ref ref = (SchemaIdentityConstraint.Ref)object;
/* 573 */     if (ref == null) {
/*     */       
/* 575 */       for (byte b1 = 0; b1 < this._searchPath.length && 
/* 576 */         null == (ref = this._searchPath[b1].findIdentityConstraintRef(paramb)); b1++);
/*     */       
/* 578 */       if (ref == null) {
/*     */         
/* 580 */         SchemaTypeSystemImpl schemaTypeSystemImpl = typeSystemForComponent("schema" + METADATA_PACKAGE_LOAD + "/identityconstraint/", paramb);
/* 581 */         if (schemaTypeSystemImpl != null) {
/*     */           
/* 583 */           ref = schemaTypeSystemImpl.findIdentityConstraintRef(paramb);
/* 584 */           assert ref != null : "Type system registered identity constraint " + QNameHelper.pretty(paramb) + " but does not return it";
/*     */         } 
/*     */       } 
/* 587 */       this._idConstraintCache.put(paramb, (ref == null) ? CACHED_NOT_FOUND : ref);
/*     */     } 
/* 589 */     return ref;
/*     */   }
/*     */ 
/*     */   
/*     */   public InputStream getSourceAsStream(String paramString) {
/* 594 */     InputStream inputStream = null;
/*     */     
/* 596 */     if (!paramString.startsWith("/")) {
/* 597 */       paramString = "/" + paramString;
/*     */     }
/* 599 */     if (this._resourceLoader != null) {
/* 600 */       inputStream = this._resourceLoader.getResourceAsStream("schema" + METADATA_PACKAGE_LOAD + "/src" + paramString);
/*     */     }
/* 602 */     if (inputStream == null && this._classLoader != null) {
/* 603 */       return this._classLoader.getResourceAsStream("schema" + METADATA_PACKAGE_LOAD + "/src" + paramString);
/*     */     }
/* 605 */     return inputStream;
/*     */   }
/*     */   
/* 608 */   private static final SchemaTypeLoader[] EMPTY_SCHEMATYPELOADER_ARRAY = new SchemaTypeLoader[0];
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   static {
/* 612 */     if (SystemCache.get() instanceof SystemCache)
/* 613 */       SystemCache.set(new SchemaTypeLoaderCache()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeLoaderImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */