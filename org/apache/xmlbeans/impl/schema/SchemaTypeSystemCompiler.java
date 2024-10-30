/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Writer;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import org.apache.xmlbeans.BindingConfig;
/*     */ import org.apache.xmlbeans.Filer;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.XmlErrorWatcher;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SchemaTypeSystemCompiler
/*     */ {
/*     */   public static class Parameters
/*     */   {
/*     */     private SchemaTypeSystem existingSystem;
/*     */     private String name;
/*     */     private SchemaDocument.Schema[] schemas;
/*     */     private BindingConfig config;
/*     */     private SchemaTypeLoader linkTo;
/*     */     private XmlOptions options;
/*     */     private Collection errorListener;
/*     */     private boolean javaize;
/*     */     private URI baseURI;
/*     */     private Map sourcesToCopyMap;
/*     */     private File schemasDir;
/*     */     
/*     */     public SchemaTypeSystem getExistingTypeSystem() {
/*  66 */       return this.existingSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setExistingTypeSystem(SchemaTypeSystem param1SchemaTypeSystem) {
/*  71 */       this.existingSystem = param1SchemaTypeSystem;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getName() {
/*  76 */       return this.name;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setName(String param1String) {
/*  81 */       this.name = param1String;
/*     */     }
/*     */ 
/*     */     
/*     */     public SchemaDocument.Schema[] getSchemas() {
/*  86 */       return this.schemas;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSchemas(SchemaDocument.Schema[] param1ArrayOfSchema) {
/*  91 */       this.schemas = param1ArrayOfSchema;
/*     */     }
/*     */ 
/*     */     
/*     */     public BindingConfig getConfig() {
/*  96 */       return this.config;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setConfig(BindingConfig param1BindingConfig) {
/* 101 */       this.config = param1BindingConfig;
/*     */     }
/*     */ 
/*     */     
/*     */     public SchemaTypeLoader getLinkTo() {
/* 106 */       return this.linkTo;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setLinkTo(SchemaTypeLoader param1SchemaTypeLoader) {
/* 111 */       this.linkTo = param1SchemaTypeLoader;
/*     */     }
/*     */ 
/*     */     
/*     */     public XmlOptions getOptions() {
/* 116 */       return this.options;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setOptions(XmlOptions param1XmlOptions) {
/* 121 */       this.options = param1XmlOptions;
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection getErrorListener() {
/* 126 */       return this.errorListener;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setErrorListener(Collection param1Collection) {
/* 131 */       this.errorListener = param1Collection;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isJavaize() {
/* 136 */       return this.javaize;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setJavaize(boolean param1Boolean) {
/* 141 */       this.javaize = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public URI getBaseURI() {
/* 146 */       return this.baseURI;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setBaseURI(URI param1URI) {
/* 151 */       this.baseURI = param1URI;
/*     */     }
/*     */ 
/*     */     
/*     */     public Map getSourcesToCopyMap() {
/* 156 */       return this.sourcesToCopyMap;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSourcesToCopyMap(Map param1Map) {
/* 161 */       this.sourcesToCopyMap = param1Map;
/*     */     }
/*     */ 
/*     */     
/*     */     public File getSchemasDir() {
/* 166 */       return this.schemasDir;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSchemasDir(File param1File) {
/* 171 */       this.schemasDir = param1File;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaTypeSystem compile(Parameters paramParameters) {
/* 181 */     return compileImpl(paramParameters.getExistingTypeSystem(), paramParameters.getName(), paramParameters.getSchemas(), paramParameters.getConfig(), paramParameters.getLinkTo(), paramParameters.getOptions(), paramParameters.getErrorListener(), paramParameters.isJavaize(), paramParameters.getBaseURI(), paramParameters.getSourcesToCopyMap(), paramParameters.getSchemasDir());
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
/*     */   public static SchemaTypeSystemImpl compile(String paramString, SchemaTypeSystem paramSchemaTypeSystem, XmlObject[] paramArrayOfXmlObject, BindingConfig paramBindingConfig, SchemaTypeLoader paramSchemaTypeLoader, Filer paramFiler, XmlOptions paramXmlOptions) throws XmlException {
/* 199 */     paramXmlOptions = XmlOptions.maskNull(paramXmlOptions);
/* 200 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 202 */     if (paramArrayOfXmlObject != null)
/*     */     {
/* 204 */       for (byte b = 0; b < paramArrayOfXmlObject.length; b++) {
/*     */         
/* 206 */         if (paramArrayOfXmlObject[b] instanceof SchemaDocument.Schema) {
/* 207 */           arrayList.add(paramArrayOfXmlObject[b]);
/* 208 */         } else if (paramArrayOfXmlObject[b] instanceof SchemaDocument && ((SchemaDocument)paramArrayOfXmlObject[b]).getSchema() != null) {
/* 209 */           arrayList.add(((SchemaDocument)paramArrayOfXmlObject[b]).getSchema());
/*     */         } else {
/* 211 */           throw new XmlException("Thread " + Thread.currentThread().getName() + ": The " + b + "th supplied input is not a schema document: its type is " + paramArrayOfXmlObject[b].schemaType());
/*     */         } 
/*     */       } 
/*     */     }
/* 215 */     Collection collection = (Collection)paramXmlOptions.get("ERROR_LISTENER");
/* 216 */     XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(collection);
/*     */     
/* 218 */     SchemaTypeSystemImpl schemaTypeSystemImpl = compileImpl(paramSchemaTypeSystem, paramString, arrayList.<SchemaDocument.Schema>toArray(new SchemaDocument.Schema[arrayList.size()]), paramBindingConfig, paramSchemaTypeLoader, paramXmlOptions, (Collection)xmlErrorWatcher, (paramFiler != null), (URI)paramXmlOptions.get("BASE_URI"), null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 224 */     if (xmlErrorWatcher.hasError() && schemaTypeSystemImpl == null)
/*     */     {
/* 226 */       throw new XmlException(xmlErrorWatcher.firstError());
/*     */     }
/*     */     
/* 229 */     if (schemaTypeSystemImpl != null && !schemaTypeSystemImpl.isIncomplete() && paramFiler != null) {
/*     */       
/* 231 */       schemaTypeSystemImpl.save(paramFiler);
/* 232 */       generateTypes(schemaTypeSystemImpl, paramFiler, paramXmlOptions);
/*     */     } 
/*     */     
/* 235 */     return schemaTypeSystemImpl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static SchemaTypeSystemImpl compileImpl(SchemaTypeSystem paramSchemaTypeSystem, String paramString, SchemaDocument.Schema[] paramArrayOfSchema, BindingConfig paramBindingConfig, SchemaTypeLoader paramSchemaTypeLoader, XmlOptions paramXmlOptions, Collection paramCollection, boolean paramBoolean, URI paramURI, Map paramMap, File paramFile) {
/* 246 */     if (paramSchemaTypeLoader == null) {
/* 247 */       throw new IllegalArgumentException("Must supply linkTo");
/*     */     }
/* 249 */     XmlErrorWatcher xmlErrorWatcher = new XmlErrorWatcher(paramCollection);
/* 250 */     boolean bool1 = (paramSchemaTypeSystem != null) ? true : false;
/*     */ 
/*     */     
/* 253 */     StscState stscState = StscState.start();
/* 254 */     boolean bool2 = (paramXmlOptions == null || !paramXmlOptions.hasOption("COMPILE_NO_VALIDATION")) ? true : false;
/*     */     
/*     */     try {
/* 257 */       stscState.setErrorListener((Collection)xmlErrorWatcher);
/* 258 */       stscState.setBindingConfig(paramBindingConfig);
/* 259 */       stscState.setOptions(paramXmlOptions);
/* 260 */       stscState.setGivenTypeSystemName(paramString);
/* 261 */       stscState.setSchemasDir(paramFile);
/* 262 */       if (paramURI != null) {
/* 263 */         stscState.setBaseUri(paramURI);
/*     */       }
/*     */       
/* 266 */       paramSchemaTypeLoader = SchemaTypeLoaderImpl.build(new SchemaTypeLoader[] { (SchemaTypeLoader)BuiltinSchemaTypeSystem.get(), paramSchemaTypeLoader }, null, null);
/* 267 */       stscState.setImportingTypeLoader(paramSchemaTypeLoader);
/*     */       
/* 269 */       ArrayList arrayList = new ArrayList(paramArrayOfSchema.length);
/*     */ 
/*     */       
/* 272 */       if (bool2) {
/*     */         
/* 274 */         XmlOptions xmlOptions = (new XmlOptions()).setErrorListener((Collection)xmlErrorWatcher);
/* 275 */         if (paramXmlOptions.hasOption("VALIDATE_TREAT_LAX_AS_SKIP"))
/* 276 */           xmlOptions.setValidateTreatLaxAsSkip(); 
/* 277 */         for (byte b = 0; b < paramArrayOfSchema.length; b++) {
/*     */           
/* 279 */           if (paramArrayOfSchema[b].validate(xmlOptions)) {
/* 280 */             arrayList.add(paramArrayOfSchema[b]);
/*     */           }
/*     */         } 
/*     */       } else {
/*     */         
/* 285 */         arrayList.addAll(Arrays.asList(paramArrayOfSchema));
/*     */       } 
/*     */       
/* 288 */       SchemaDocument.Schema[] arrayOfSchema = arrayList.<SchemaDocument.Schema>toArray(new SchemaDocument.Schema[arrayList.size()]);
/*     */       
/* 290 */       if (bool1) {
/*     */         
/* 292 */         HashSet hashSet = new HashSet();
/* 293 */         arrayOfSchema = getSchemasToRecompile((SchemaTypeSystemImpl)paramSchemaTypeSystem, arrayOfSchema, hashSet);
/* 294 */         stscState.initFromTypeSystem((SchemaTypeSystemImpl)paramSchemaTypeSystem, hashSet);
/*     */       }
/*     */       else {
/*     */         
/* 298 */         stscState.setDependencies(new SchemaDependencies());
/*     */       } 
/*     */ 
/*     */       
/* 302 */       StscImporter.SchemaToProcess[] arrayOfSchemaToProcess = StscImporter.resolveImportsAndIncludes(arrayOfSchema, bool1);
/*     */ 
/*     */       
/* 305 */       StscTranslator.addAllDefinitions(arrayOfSchemaToProcess);
/*     */ 
/*     */       
/* 308 */       StscResolver.resolveAll();
/*     */ 
/*     */       
/* 311 */       StscChecker.checkAll();
/*     */ 
/*     */       
/* 314 */       StscJavaizer.javaizeAllTypes(paramBoolean);
/*     */ 
/*     */       
/* 317 */       StscState.get().sts().loadFromStscState(stscState);
/*     */ 
/*     */       
/* 320 */       if (paramMap != null) {
/* 321 */         paramMap.putAll(stscState.sourceCopyMap());
/*     */       }
/* 323 */       if (xmlErrorWatcher.hasError())
/*     */       {
/*     */         
/* 326 */         if (stscState.allowPartial() && stscState.getRecovered() == xmlErrorWatcher.size()) {
/*     */ 
/*     */           
/* 329 */           StscState.get().sts().setIncomplete(true);
/*     */         
/*     */         }
/*     */         else {
/*     */           
/* 334 */           return null;
/*     */         } 
/*     */       }
/*     */       
/* 338 */       if (paramSchemaTypeSystem != null) {
/* 339 */         ((SchemaTypeSystemImpl)paramSchemaTypeSystem).setIncomplete(true);
/*     */       }
/* 341 */       return StscState.get().sts();
/*     */     }
/*     */     finally {
/*     */       
/* 345 */       StscState.end();
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
/*     */   private static SchemaDocument.Schema[] getSchemasToRecompile(SchemaTypeSystemImpl paramSchemaTypeSystemImpl, SchemaDocument.Schema[] paramArrayOfSchema, Set paramSet) {
/* 358 */     HashSet hashSet = new HashSet();
/* 359 */     HashMap hashMap = new HashMap();
/* 360 */     ArrayList arrayList = new ArrayList();
/* 361 */     for (byte b1 = 0; b1 < paramArrayOfSchema.length; b1++) {
/*     */       
/* 363 */       String str = paramArrayOfSchema[b1].documentProperties().getSourceName();
/* 364 */       if (str == null) {
/* 365 */         throw new IllegalArgumentException("One of the Schema files passed in doesn't have the source set, which prevents it to be incrementally compiled");
/*     */       }
/*     */       
/* 368 */       hashSet.add(str);
/* 369 */       hashMap.put(str, paramArrayOfSchema[b1]);
/* 370 */       arrayList.add(paramArrayOfSchema[b1]);
/*     */     } 
/* 372 */     SchemaDependencies schemaDependencies = paramSchemaTypeSystemImpl.getDependencies();
/* 373 */     List list = schemaDependencies.getNamespacesTouched(hashSet);
/* 374 */     paramSet.addAll(schemaDependencies.computeTransitiveClosure(list));
/* 375 */     List list1 = schemaDependencies.getFilesTouched(paramSet);
/* 376 */     StscState.get().setDependencies(new SchemaDependencies(schemaDependencies, paramSet));
/* 377 */     for (byte b2 = 0; b2 < list1.size(); b2++) {
/*     */       
/* 379 */       String str = list1.get(b2);
/* 380 */       SchemaDocument.Schema schema = (SchemaDocument.Schema)hashMap.get(str);
/* 381 */       if (schema == null) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 386 */           XmlObject xmlObject = StscImporter.DownloadTable.downloadDocument(StscState.get().getS4SLoader(), null, str);
/*     */           
/* 388 */           XmlOptions xmlOptions = new XmlOptions();
/* 389 */           xmlOptions.setErrorListener(StscState.get().getErrorListener());
/* 390 */           if (!(xmlObject instanceof SchemaDocument) || !xmlObject.validate(xmlOptions)) {
/*     */             
/* 392 */             StscState.get().error("Referenced document is not a valid schema, URL = " + str, 56, (XmlObject)null);
/*     */           }
/*     */           else {
/*     */             
/* 396 */             SchemaDocument schemaDocument = (SchemaDocument)xmlObject;
/*     */             
/* 398 */             arrayList.add(schemaDocument.getSchema());
/*     */           } 
/* 400 */         } catch (MalformedURLException malformedURLException) {
/*     */           
/* 402 */           StscState.get().error("exception.loading.url", new Object[] { "MalformedURLException", str, malformedURLException.getMessage() }, (XmlObject)null);
/*     */         
/*     */         }
/* 405 */         catch (IOException iOException) {
/*     */           
/* 407 */           StscState.get().error("exception.loading.url", new Object[] { "IOException", str, iOException.getMessage() }, (XmlObject)null);
/*     */         
/*     */         }
/* 410 */         catch (XmlException xmlException) {
/*     */           
/* 412 */           StscState.get().error("exception.loading.url", new Object[] { "XmlException", str, xmlException.getMessage() }, (XmlObject)null);
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/* 417 */     return arrayList.<SchemaDocument.Schema>toArray(new SchemaDocument.Schema[arrayList.size()]);
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
/*     */   public static boolean generateTypes(SchemaTypeSystem paramSchemaTypeSystem, Filer paramFiler, XmlOptions paramXmlOptions) {
/* 434 */     if (paramSchemaTypeSystem instanceof SchemaTypeSystemImpl && ((SchemaTypeSystemImpl)paramSchemaTypeSystem).isIncomplete()) {
/* 435 */       return false;
/*     */     }
/* 437 */     boolean bool = true;
/*     */     
/* 439 */     ArrayList arrayList = new ArrayList();
/* 440 */     arrayList.addAll(Arrays.asList(paramSchemaTypeSystem.globalTypes()));
/* 441 */     arrayList.addAll(Arrays.asList(paramSchemaTypeSystem.documentTypes()));
/* 442 */     arrayList.addAll(Arrays.asList(paramSchemaTypeSystem.attributeTypes()));
/*     */     
/* 444 */     for (SchemaType schemaType : arrayList) {
/*     */ 
/*     */       
/* 447 */       if (schemaType.isBuiltinType())
/*     */         continue; 
/* 449 */       if (schemaType.getFullJavaName() == null) {
/*     */         continue;
/*     */       }
/* 452 */       String str = schemaType.getFullJavaName();
/*     */       
/* 454 */       Writer writer = null;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 459 */         writer = paramFiler.createSourceFile(str);
/* 460 */         SchemaTypeCodePrinter.printType(writer, schemaType, paramXmlOptions);
/*     */       }
/* 462 */       catch (IOException iOException) {
/*     */         
/* 464 */         System.err.println("IO Error " + iOException);
/* 465 */         bool = false;
/*     */       } finally {
/*     */         
/* 468 */         try { if (writer != null) writer.close();  } catch (IOException iOException) {}
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 474 */         str = schemaType.getFullJavaImplName();
/* 475 */         writer = paramFiler.createSourceFile(str);
/*     */         
/* 477 */         SchemaTypeCodePrinter.printTypeImpl(writer, schemaType, paramXmlOptions);
/*     */       }
/* 479 */       catch (IOException iOException) {
/*     */         
/* 481 */         System.err.println("IO Error " + iOException);
/* 482 */         bool = false;
/*     */       } finally {
/*     */         
/* 485 */         try { if (writer != null) writer.close();  } catch (IOException iOException) {}
/*     */       } 
/*     */     } 
/*     */     
/* 489 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\SchemaTypeSystemCompiler.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */