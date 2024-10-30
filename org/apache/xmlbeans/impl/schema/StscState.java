/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.io.File;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.BindingConfig;
/*      */ import org.apache.xmlbeans.SchemaAttributeGroup;
/*      */ import org.apache.xmlbeans.SchemaComponent;
/*      */ import org.apache.xmlbeans.SchemaGlobalAttribute;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*      */ import org.apache.xmlbeans.SchemaModelGroup;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.SystemProperties;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlBeans;
/*      */ import org.apache.xmlbeans.XmlError;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.ResolverUtil;
/*      */ import org.apache.xmlbeans.impl.util.HexBin;
/*      */ import org.apache.xmlbeans.impl.values.XmlStringImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.xml.sax.EntityResolver;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StscState
/*      */ {
/*      */   private String _givenStsName;
/*      */   private Collection _errorListener;
/*      */   private SchemaTypeSystemImpl _target;
/*      */   private BindingConfig _config;
/*      */   private Map _compatMap;
/*      */   private boolean _doingDownloads;
/*   63 */   private byte[] _digest = null;
/*      */   
/*      */   private boolean _noDigest = false;
/*      */   
/*      */   private boolean _allowPartial = false;
/*   68 */   private int _recoveredErrors = 0;
/*      */   
/*      */   private SchemaTypeLoader _importingLoader;
/*      */   
/*   72 */   private Map _containers = new LinkedHashMap();
/*      */   
/*      */   private SchemaDependencies _dependencies;
/*   75 */   private Map _redefinedGlobalTypes = new LinkedHashMap();
/*   76 */   private Map _redefinedModelGroups = new LinkedHashMap();
/*   77 */   private Map _redefinedAttributeGroups = new LinkedHashMap();
/*      */   
/*   79 */   private Map _globalTypes = new LinkedHashMap();
/*   80 */   private Map _globalElements = new LinkedHashMap();
/*   81 */   private Map _globalAttributes = new LinkedHashMap();
/*   82 */   private Map _modelGroups = new LinkedHashMap();
/*   83 */   private Map _attributeGroups = new LinkedHashMap();
/*   84 */   private Map _documentTypes = new LinkedHashMap();
/*   85 */   private Map _attributeTypes = new LinkedHashMap();
/*   86 */   private Map _typesByClassname = new LinkedHashMap();
/*   87 */   private Map _misspelledNames = new HashMap();
/*   88 */   private Set _processingGroups = new LinkedHashSet();
/*   89 */   private Map _idConstraints = new LinkedHashMap();
/*   90 */   private Set _namespaces = new HashSet();
/*   91 */   private List _annotations = new ArrayList();
/*      */   private boolean _noUpa;
/*      */   private boolean _noPvr;
/*      */   private boolean _noAnn;
/*      */   private boolean _mdefAll;
/*   96 */   private Set _mdefNamespaces = buildDefaultMdefNamespaces();
/*      */   
/*      */   private EntityResolver _entityResolver;
/*      */   
/*      */   private File _schemasDir;
/*      */   
/*      */   private static Set buildDefaultMdefNamespaces() {
/*  103 */     return new HashSet(Arrays.asList((Object[])new String[] { "http://www.openuri.org/2002/04/soap/conversation/" }));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  113 */   public static final Object CHAMELEON_INCLUDE_URI = new Object();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void initFromTypeSystem(SchemaTypeSystemImpl paramSchemaTypeSystemImpl, Set paramSet) {
/*  129 */     SchemaContainer[] arrayOfSchemaContainer = paramSchemaTypeSystemImpl.containers();
/*  130 */     for (byte b = 0; b < arrayOfSchemaContainer.length; b++) {
/*      */       
/*  132 */       if (!paramSet.contains(arrayOfSchemaContainer[b].getNamespace()))
/*      */       {
/*      */         
/*  135 */         addContainer(arrayOfSchemaContainer[b]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addNewContainer(String paramString) {
/*  145 */     if (this._containers.containsKey(paramString)) {
/*      */       return;
/*      */     }
/*  148 */     SchemaContainer schemaContainer = new SchemaContainer(paramString);
/*  149 */     schemaContainer.setTypeSystem(sts());
/*  150 */     addNamespace(paramString);
/*  151 */     this._containers.put(paramString, schemaContainer);
/*      */   }
/*      */ 
/*      */   
/*      */   private void addContainer(SchemaContainer paramSchemaContainer) {
/*  156 */     this._containers.put(paramSchemaContainer.getNamespace(), paramSchemaContainer);
/*  157 */     List list1 = paramSchemaContainer.redefinedModelGroups();
/*  158 */     for (byte b1 = 0; b1 < list1.size(); b1++) {
/*      */       
/*  160 */       b b = ((SchemaModelGroup)list1.get(b1)).getName();
/*  161 */       this._redefinedModelGroups.put(b, list1.get(b1));
/*      */     } 
/*      */     
/*  164 */     List list2 = paramSchemaContainer.redefinedAttributeGroups();
/*  165 */     for (byte b2 = 0; b2 < list2.size(); b2++) {
/*      */       
/*  167 */       b b = ((SchemaAttributeGroup)list2.get(b2)).getName();
/*  168 */       this._redefinedAttributeGroups.put(b, list2.get(b2));
/*      */     } 
/*      */     
/*  171 */     List list3 = paramSchemaContainer.redefinedGlobalTypes();
/*  172 */     for (byte b3 = 0; b3 < list3.size(); b3++) {
/*      */       
/*  174 */       b b = ((SchemaType)list3.get(b3)).getName();
/*  175 */       this._redefinedGlobalTypes.put(b, list3.get(b3));
/*      */     } 
/*      */     
/*  178 */     List list = paramSchemaContainer.globalElements();
/*  179 */     for (byte b4 = 0; b4 < list.size(); b4++) {
/*      */       
/*  181 */       b b = ((SchemaGlobalElement)list.get(b4)).getName();
/*  182 */       this._globalElements.put(b, list.get(b4));
/*      */     } 
/*      */     
/*  185 */     List list4 = paramSchemaContainer.globalAttributes();
/*  186 */     for (byte b5 = 0; b5 < list4.size(); b5++) {
/*      */       
/*  188 */       b b = ((SchemaGlobalAttribute)list4.get(b5)).getName();
/*  189 */       this._globalAttributes.put(b, list4.get(b5));
/*      */     } 
/*      */     
/*  192 */     List list5 = paramSchemaContainer.modelGroups();
/*  193 */     for (byte b6 = 0; b6 < list5.size(); b6++) {
/*      */       
/*  195 */       b b = ((SchemaModelGroup)list5.get(b6)).getName();
/*  196 */       this._modelGroups.put(b, list5.get(b6));
/*      */     } 
/*      */     
/*  199 */     List list6 = paramSchemaContainer.attributeGroups();
/*  200 */     for (byte b7 = 0; b7 < list6.size(); b7++) {
/*      */       
/*  202 */       b b = ((SchemaAttributeGroup)list6.get(b7)).getName();
/*  203 */       this._attributeGroups.put(b, list6.get(b7));
/*      */     } 
/*      */     
/*  206 */     List list7 = paramSchemaContainer.globalTypes();
/*  207 */     for (byte b8 = 0; b8 < list7.size(); b8++) {
/*      */       
/*  209 */       SchemaType schemaType = list7.get(b8);
/*  210 */       b b = schemaType.getName();
/*  211 */       this._globalTypes.put(b, schemaType);
/*  212 */       if (schemaType.getFullJavaName() != null) {
/*  213 */         addClassname(schemaType.getFullJavaName(), schemaType);
/*      */       }
/*      */     } 
/*  216 */     List list8 = paramSchemaContainer.documentTypes();
/*  217 */     for (byte b9 = 0; b9 < list8.size(); b9++) {
/*      */       
/*  219 */       SchemaType schemaType = list8.get(b9);
/*  220 */       b b = schemaType.getProperties()[0].getName();
/*  221 */       this._documentTypes.put(b, schemaType);
/*  222 */       if (schemaType.getFullJavaName() != null) {
/*  223 */         addClassname(schemaType.getFullJavaName(), schemaType);
/*      */       }
/*      */     } 
/*  226 */     List list9 = paramSchemaContainer.attributeTypes();
/*  227 */     for (byte b10 = 0; b10 < list9.size(); b10++) {
/*      */       
/*  229 */       SchemaType schemaType = list9.get(b10);
/*  230 */       b b = schemaType.getProperties()[0].getName();
/*  231 */       this._attributeTypes.put(b, schemaType);
/*  232 */       if (schemaType.getFullJavaName() != null) {
/*  233 */         addClassname(schemaType.getFullJavaName(), schemaType);
/*      */       }
/*      */     } 
/*  236 */     List list10 = paramSchemaContainer.identityConstraints();
/*  237 */     for (byte b11 = 0; b11 < list10.size(); b11++) {
/*      */       
/*  239 */       b b = ((SchemaIdentityConstraint)list10.get(b11)).getName();
/*  240 */       this._idConstraints.put(b, list10.get(b11));
/*      */     } 
/*      */     
/*  243 */     this._annotations.addAll(paramSchemaContainer.annotations());
/*  244 */     this._namespaces.add(paramSchemaContainer.getNamespace());
/*  245 */     paramSchemaContainer.unsetImmutable();
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaContainer getContainer(String paramString) {
/*  250 */     return (SchemaContainer)this._containers.get(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   Map getContainerMap() {
/*  255 */     return Collections.unmodifiableMap(this._containers);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void registerDependency(String paramString1, String paramString2) {
/*  262 */     this._dependencies.registerDependency(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   void registerContribution(String paramString1, String paramString2) {
/*  267 */     this._dependencies.registerContribution(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaDependencies getDependencies() {
/*  272 */     return this._dependencies;
/*      */   }
/*      */ 
/*      */   
/*      */   void setDependencies(SchemaDependencies paramSchemaDependencies) {
/*  277 */     this._dependencies = paramSchemaDependencies;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isFileProcessed(String paramString) {
/*  282 */     return this._dependencies.isFileRepresented(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setImportingTypeLoader(SchemaTypeLoader paramSchemaTypeLoader) {
/*  291 */     this._importingLoader = paramSchemaTypeLoader;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setErrorListener(Collection paramCollection) {
/*  298 */     this._errorListener = paramCollection;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void error(String paramString, int paramInt, XmlObject paramXmlObject) {
/*  305 */     addError(this._errorListener, paramString, paramInt, paramXmlObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void error(String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/*  311 */     addError(this._errorListener, paramString, paramArrayOfObject, paramXmlObject);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void recover(String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/*  317 */     addError(this._errorListener, paramString, paramArrayOfObject, paramXmlObject); this._recoveredErrors++;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void warning(String paramString, int paramInt, XmlObject paramXmlObject) {
/*  324 */     addWarning(this._errorListener, paramString, paramInt, paramXmlObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void warning(String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/*  333 */     if (paramString == "reserved-type-name" && paramXmlObject.documentProperties().getSourceName() != null && paramXmlObject.documentProperties().getSourceName().indexOf("XMLSchema.xsd") > 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  338 */     addWarning(this._errorListener, paramString, paramArrayOfObject, paramXmlObject);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void info(String paramString) {
/*  345 */     addInfo(this._errorListener, paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void info(String paramString, Object[] paramArrayOfObject) {
/*  351 */     addInfo(this._errorListener, paramString, paramArrayOfObject);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addError(Collection paramCollection, String paramString, int paramInt, XmlObject paramXmlObject) {
/*  356 */     XmlError xmlError = XmlError.forObject(paramString, 0, paramXmlObject);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  361 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addError(Collection paramCollection, String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/*  366 */     XmlError xmlError = XmlError.forObject(paramString, paramArrayOfObject, 0, paramXmlObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  372 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addError(Collection paramCollection, String paramString, Object[] paramArrayOfObject, File paramFile) {
/*  377 */     XmlError xmlError = XmlError.forLocation(paramString, paramArrayOfObject, 0, paramFile.toURI().toString(), 0, 0, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  383 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addError(Collection paramCollection, String paramString, Object[] paramArrayOfObject, URL paramURL) {
/*  388 */     XmlError xmlError = XmlError.forLocation(paramString, paramArrayOfObject, 0, paramURL.toString(), 0, 0, 0);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  394 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void addWarning(Collection paramCollection, String paramString, int paramInt, XmlObject paramXmlObject) {
/*  400 */     XmlError xmlError = XmlError.forObject(paramString, 1, paramXmlObject);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  405 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addWarning(Collection paramCollection, String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/*  410 */     XmlError xmlError = XmlError.forObject(paramString, paramArrayOfObject, 1, paramXmlObject);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  416 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addInfo(Collection paramCollection, String paramString) {
/*  421 */     XmlError xmlError = XmlError.forMessage(paramString, 2);
/*  422 */     paramCollection.add(xmlError);
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addInfo(Collection paramCollection, String paramString, Object[] paramArrayOfObject) {
/*  427 */     XmlError xmlError = XmlError.forMessage(paramString, paramArrayOfObject, 2);
/*  428 */     paramCollection.add(xmlError);
/*      */   }
/*      */   
/*      */   public void setGivenTypeSystemName(String paramString) {
/*  432 */     this._givenStsName = paramString;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setTargetSchemaTypeSystem(SchemaTypeSystemImpl paramSchemaTypeSystemImpl) {
/*  438 */     this._target = paramSchemaTypeSystemImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSchemaDigest(byte[] paramArrayOfbyte) {
/*  445 */     if (this._noDigest) {
/*      */       return;
/*      */     }
/*  448 */     if (paramArrayOfbyte == null) {
/*      */       
/*  450 */       this._noDigest = true;
/*  451 */       this._digest = null;
/*      */       
/*      */       return;
/*      */     } 
/*  455 */     if (this._digest == null)
/*  456 */       this._digest = new byte[16]; 
/*  457 */     int i = this._digest.length;
/*  458 */     if (paramArrayOfbyte.length < i)
/*  459 */       i = paramArrayOfbyte.length; 
/*  460 */     for (byte b = 0; b < i; b++) {
/*  461 */       this._digest[b] = (byte)(this._digest[b] ^ paramArrayOfbyte[b]);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaTypeSystemImpl sts() {
/*  469 */     if (this._target != null) {
/*  470 */       return this._target;
/*      */     }
/*  472 */     String str = this._givenStsName;
/*  473 */     if (str == null && this._digest != null) {
/*  474 */       str = "s" + new String(HexBin.encode(this._digest));
/*      */     }
/*  476 */     this._target = new SchemaTypeSystemImpl(str);
/*  477 */     return this._target;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldDownloadURI(String paramString) {
/*  485 */     if (this._doingDownloads) {
/*  486 */       return true;
/*      */     }
/*  488 */     if (paramString == null) {
/*  489 */       return false;
/*      */     }
/*      */     
/*      */     try {
/*  493 */       URI uRI = new URI(paramString);
/*  494 */       if (uRI.getScheme().equalsIgnoreCase("jar") || uRI.getScheme().equalsIgnoreCase("zip")) {
/*      */ 
/*      */ 
/*      */         
/*  498 */         String str = uRI.getSchemeSpecificPart();
/*  499 */         int i = str.lastIndexOf('!');
/*  500 */         return shouldDownloadURI((i > 0) ? str.substring(0, i) : str);
/*      */       } 
/*  502 */       return uRI.getScheme().equalsIgnoreCase("file");
/*      */     }
/*  504 */     catch (Exception exception) {
/*      */       
/*  506 */       return false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setOptions(XmlOptions paramXmlOptions) {
/*  515 */     if (paramXmlOptions == null) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  520 */     this._allowPartial = paramXmlOptions.hasOption("COMPILE_PARTIAL_TYPESYSTEM");
/*      */     
/*  522 */     this._compatMap = (Map)paramXmlOptions.get("COMPILE_SUBSTITUTE_NAMES");
/*  523 */     this._noUpa = paramXmlOptions.hasOption("COMPILE_NO_UPA_RULE") ? true : (!"true".equals(SystemProperties.getProperty("xmlbean.uniqueparticleattribution", "true")));
/*      */     
/*  525 */     this._noPvr = paramXmlOptions.hasOption("COMPILE_NO_PVR_RULE") ? true : (!"true".equals(SystemProperties.getProperty("xmlbean.particlerestriction", "true")));
/*      */     
/*  527 */     this._noAnn = paramXmlOptions.hasOption("COMPILE_NO_ANNOTATIONS") ? true : (!"true".equals(SystemProperties.getProperty("xmlbean.schemaannotations", "true")));
/*      */     
/*  529 */     this._doingDownloads = paramXmlOptions.hasOption("COMPILE_DOWNLOAD_URLS") ? true : "true".equals(SystemProperties.getProperty("xmlbean.downloadurls", "false"));
/*      */     
/*  531 */     this._entityResolver = (EntityResolver)paramXmlOptions.get("ENTITY_RESOLVER");
/*      */     
/*  533 */     if (this._entityResolver == null) {
/*  534 */       this._entityResolver = ResolverUtil.getGlobalEntityResolver();
/*      */     }
/*  536 */     if (this._entityResolver != null) {
/*  537 */       this._doingDownloads = true;
/*      */     }
/*  539 */     if (paramXmlOptions.hasOption("COMPILE_MDEF_NAMESPACES")) {
/*      */       
/*  541 */       this._mdefNamespaces.addAll((Collection)paramXmlOptions.get("COMPILE_MDEF_NAMESPACES"));
/*      */       
/*  543 */       String str1 = "##local";
/*  544 */       String str2 = "##any";
/*      */       
/*  546 */       if (this._mdefNamespaces.contains(str1)) {
/*      */         
/*  548 */         this._mdefNamespaces.remove(str1);
/*  549 */         this._mdefNamespaces.add("");
/*      */       } 
/*  551 */       if (this._mdefNamespaces.contains(str2)) {
/*      */         
/*  553 */         this._mdefNamespaces.remove(str2);
/*  554 */         this._mdefAll = true;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityResolver getEntityResolver() {
/*  564 */     return this._entityResolver;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean noUpa() {
/*  572 */     return this._noUpa;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean noPvr() {
/*  580 */     return this._noPvr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean noAnn() {
/*  588 */     return this._noAnn;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean allowPartial() {
/*  597 */     return this._allowPartial;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getRecovered() {
/*  606 */     return this._recoveredErrors;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private b compatName(b paramb, String paramString) {
/*  618 */     if (paramb.getNamespaceURI().length() == 0 && paramString != null && paramString.length() > 0) {
/*  619 */       paramb = new b(paramString, paramb.dT());
/*      */     }
/*  621 */     if (this._compatMap == null) {
/*  622 */       return paramb;
/*      */     }
/*  624 */     b b1 = (b)this._compatMap.get(paramb);
/*  625 */     if (b1 == null)
/*  626 */       return paramb; 
/*  627 */     return b1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBindingConfig(BindingConfig paramBindingConfig) throws IllegalArgumentException {
/*  636 */     this._config = paramBindingConfig;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public BindingConfig getBindingConfig() throws IllegalArgumentException {
/*  642 */     return this._config;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPackageOverride(String paramString) {
/*  650 */     if (this._config == null)
/*  651 */       return null; 
/*  652 */     return this._config.lookupPackageForNamespace(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getJavaPrefix(String paramString) {
/*  660 */     if (this._config == null)
/*  661 */       return null; 
/*  662 */     return this._config.lookupPrefixForNamespace(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getJavaSuffix(String paramString) {
/*  670 */     if (this._config == null)
/*  671 */       return null; 
/*  672 */     return this._config.lookupSuffixForNamespace(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getJavaname(b paramb, int paramInt) {
/*  680 */     if (this._config == null)
/*  681 */       return null; 
/*  682 */     return this._config.lookupJavanameForQName(paramb, paramInt);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String crunchName(b paramb) {
/*  690 */     return paramb.dT().toLowerCase();
/*      */   }
/*      */ 
/*      */   
/*      */   void addSpelling(b paramb, SchemaComponent paramSchemaComponent) {
/*  695 */     this._misspelledNames.put(crunchName(paramb), paramSchemaComponent);
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaComponent findSpelling(b paramb) {
/*  700 */     return (SchemaComponent)this._misspelledNames.get(crunchName(paramb));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   void addNamespace(String paramString) {
/*  707 */     this._namespaces.add(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   String[] getNamespaces() {
/*  712 */     return (String[])this._namespaces.toArray((Object[])new String[this._namespaces.size()]);
/*      */   }
/*      */ 
/*      */   
/*      */   boolean linkerDefinesNamespace(String paramString) {
/*  717 */     return this._importingLoader.isNamespaceDefined(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaTypeImpl findGlobalType(b paramb, String paramString1, String paramString2) {
/*  724 */     paramb = compatName(paramb, paramString1);
/*  725 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)this._globalTypes.get(paramb);
/*  726 */     boolean bool = false;
/*  727 */     if (schemaTypeImpl == null) {
/*      */       
/*  729 */       schemaTypeImpl = (SchemaTypeImpl)this._importingLoader.findType(paramb);
/*  730 */       bool = (schemaTypeImpl != null) ? true : false;
/*      */     } 
/*  732 */     if (!bool && paramString2 != null)
/*  733 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  734 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaTypeImpl findRedefinedGlobalType(b paramb, String paramString, SchemaTypeImpl paramSchemaTypeImpl) {
/*  739 */     b b1 = paramSchemaTypeImpl.getName();
/*  740 */     paramb = compatName(paramb, paramString);
/*  741 */     if (paramb.equals(b1))
/*      */     {
/*  743 */       return (SchemaTypeImpl)this._redefinedGlobalTypes.get(paramSchemaTypeImpl);
/*      */     }
/*      */     
/*  746 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)this._globalTypes.get(paramb);
/*  747 */     if (schemaTypeImpl == null) {
/*  748 */       schemaTypeImpl = (SchemaTypeImpl)this._importingLoader.findType(paramb);
/*      */     }
/*  750 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addGlobalType(SchemaTypeImpl paramSchemaTypeImpl1, SchemaTypeImpl paramSchemaTypeImpl2) {
/*  755 */     if (paramSchemaTypeImpl1 != null) {
/*      */       
/*  757 */       b b = paramSchemaTypeImpl1.getName();
/*  758 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/*  759 */       assert schemaContainer != null && schemaContainer == paramSchemaTypeImpl1.getContainer();
/*      */       
/*  761 */       if (paramSchemaTypeImpl2 != null) {
/*      */         
/*  763 */         if (this._redefinedGlobalTypes.containsKey(paramSchemaTypeImpl2))
/*      */         {
/*  765 */           if (!ignoreMdef(b)) {
/*  766 */             if (this._mdefAll) {
/*  767 */               warning("sch-props-correct.2", new Object[] { "global type", QNameHelper.pretty(b), ((SchemaType)this._redefinedGlobalTypes.get(paramSchemaTypeImpl2)).getSourceName() }, paramSchemaTypeImpl1.getParseObject());
/*      */             }
/*      */             else {
/*      */               
/*  771 */               error("sch-props-correct.2", new Object[] { "global type", QNameHelper.pretty(b), ((SchemaType)this._redefinedGlobalTypes.get(paramSchemaTypeImpl2)).getSourceName() }, paramSchemaTypeImpl1.getParseObject());
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/*  779 */           this._redefinedGlobalTypes.put(paramSchemaTypeImpl2, paramSchemaTypeImpl1);
/*  780 */           schemaContainer.addRedefinedType(paramSchemaTypeImpl1.getRef());
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  785 */       else if (this._globalTypes.containsKey(b)) {
/*      */         
/*  787 */         if (!ignoreMdef(b)) {
/*  788 */           if (this._mdefAll) {
/*  789 */             warning("sch-props-correct.2", new Object[] { "global type", QNameHelper.pretty(b), ((SchemaType)this._globalTypes.get(b)).getSourceName() }, paramSchemaTypeImpl1.getParseObject());
/*      */           }
/*      */           else {
/*      */             
/*  793 */             error("sch-props-correct.2", new Object[] { "global type", QNameHelper.pretty(b), ((SchemaType)this._globalTypes.get(b)).getSourceName() }, paramSchemaTypeImpl1.getParseObject());
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/*  801 */         this._globalTypes.put(b, paramSchemaTypeImpl1);
/*  802 */         schemaContainer.addGlobalType(paramSchemaTypeImpl1.getRef());
/*  803 */         addSpelling(b, (SchemaComponent)paramSchemaTypeImpl1);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean ignoreMdef(b paramb) {
/*  811 */     return this._mdefNamespaces.contains(paramb.getNamespaceURI());
/*      */   }
/*      */   
/*      */   SchemaType[] globalTypes() {
/*  815 */     return (SchemaType[])this._globalTypes.values().toArray((Object[])new SchemaType[this._globalTypes.size()]);
/*      */   }
/*      */   SchemaType[] redefinedGlobalTypes() {
/*  818 */     return (SchemaType[])this._redefinedGlobalTypes.values().toArray((Object[])new SchemaType[this._redefinedGlobalTypes.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaTypeImpl findDocumentType(b paramb, String paramString1, String paramString2) {
/*  824 */     paramb = compatName(paramb, paramString1);
/*  825 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)this._documentTypes.get(paramb);
/*  826 */     boolean bool = false;
/*  827 */     if (schemaTypeImpl == null) {
/*      */       
/*  829 */       schemaTypeImpl = (SchemaTypeImpl)this._importingLoader.findDocumentType(paramb);
/*  830 */       bool = (schemaTypeImpl != null) ? true : false;
/*      */     } 
/*  832 */     if (!bool && paramString2 != null)
/*  833 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  834 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addDocumentType(SchemaTypeImpl paramSchemaTypeImpl, b paramb) {
/*  839 */     if (this._documentTypes.containsKey(paramb)) {
/*      */       
/*  841 */       if (!ignoreMdef(paramb)) {
/*  842 */         if (this._mdefAll) {
/*  843 */           warning("sch-props-correct.2", new Object[] { "global element", QNameHelper.pretty(paramb), ((SchemaComponent)this._documentTypes.get(paramb)).getSourceName() }, paramSchemaTypeImpl.getParseObject());
/*      */         }
/*      */         else {
/*      */           
/*  847 */           error("sch-props-correct.2", new Object[] { "global element", QNameHelper.pretty(paramb), ((SchemaComponent)this._documentTypes.get(paramb)).getSourceName() }, paramSchemaTypeImpl.getParseObject());
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/*  855 */       this._documentTypes.put(paramb, paramSchemaTypeImpl);
/*  856 */       SchemaContainer schemaContainer = getContainer(paramb.getNamespaceURI());
/*  857 */       assert schemaContainer != null && schemaContainer == paramSchemaTypeImpl.getContainer();
/*  858 */       schemaContainer.addDocumentType(paramSchemaTypeImpl.getRef());
/*      */     } 
/*      */   }
/*      */   
/*      */   SchemaType[] documentTypes() {
/*  863 */     return (SchemaType[])this._documentTypes.values().toArray((Object[])new SchemaType[this._documentTypes.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaTypeImpl findAttributeType(b paramb, String paramString1, String paramString2) {
/*  869 */     paramb = compatName(paramb, paramString1);
/*  870 */     SchemaTypeImpl schemaTypeImpl = (SchemaTypeImpl)this._attributeTypes.get(paramb);
/*  871 */     boolean bool = false;
/*  872 */     if (schemaTypeImpl == null) {
/*      */       
/*  874 */       schemaTypeImpl = (SchemaTypeImpl)this._importingLoader.findAttributeType(paramb);
/*  875 */       bool = (schemaTypeImpl != null) ? true : false;
/*      */     } 
/*  877 */     if (!bool && paramString2 != null)
/*  878 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  879 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addAttributeType(SchemaTypeImpl paramSchemaTypeImpl, b paramb) {
/*  884 */     if (this._attributeTypes.containsKey(paramb)) {
/*      */       
/*  886 */       if (!ignoreMdef(paramb)) {
/*  887 */         if (this._mdefAll) {
/*  888 */           warning("sch-props-correct.2", new Object[] { "global attribute", QNameHelper.pretty(paramb), ((SchemaComponent)this._attributeTypes.get(paramb)).getSourceName() }, paramSchemaTypeImpl.getParseObject());
/*      */         }
/*      */         else {
/*      */           
/*  892 */           error("sch-props-correct.2", new Object[] { "global attribute", QNameHelper.pretty(paramb), ((SchemaComponent)this._attributeTypes.get(paramb)).getSourceName() }, paramSchemaTypeImpl.getParseObject());
/*      */         
/*      */         }
/*      */       
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/*  900 */       this._attributeTypes.put(paramb, paramSchemaTypeImpl);
/*  901 */       SchemaContainer schemaContainer = getContainer(paramb.getNamespaceURI());
/*  902 */       assert schemaContainer != null && schemaContainer == paramSchemaTypeImpl.getContainer();
/*  903 */       schemaContainer.addAttributeType(paramSchemaTypeImpl.getRef());
/*      */     } 
/*      */   }
/*      */   
/*      */   SchemaType[] attributeTypes() {
/*  908 */     return (SchemaType[])this._attributeTypes.values().toArray((Object[])new SchemaType[this._attributeTypes.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaGlobalAttributeImpl findGlobalAttribute(b paramb, String paramString1, String paramString2) {
/*  914 */     paramb = compatName(paramb, paramString1);
/*  915 */     SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl)this._globalAttributes.get(paramb);
/*  916 */     boolean bool = false;
/*  917 */     if (schemaGlobalAttributeImpl == null) {
/*      */       
/*  919 */       schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl)this._importingLoader.findAttribute(paramb);
/*  920 */       bool = (schemaGlobalAttributeImpl != null) ? true : false;
/*      */     } 
/*  922 */     if (!bool && paramString2 != null)
/*  923 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  924 */     return schemaGlobalAttributeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addGlobalAttribute(SchemaGlobalAttributeImpl paramSchemaGlobalAttributeImpl) {
/*  929 */     if (paramSchemaGlobalAttributeImpl != null) {
/*      */       
/*  931 */       b b = paramSchemaGlobalAttributeImpl.getName();
/*  932 */       this._globalAttributes.put(b, paramSchemaGlobalAttributeImpl);
/*  933 */       addSpelling(b, (SchemaComponent)paramSchemaGlobalAttributeImpl);
/*  934 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/*  935 */       assert schemaContainer != null && schemaContainer == paramSchemaGlobalAttributeImpl.getContainer();
/*  936 */       schemaContainer.addGlobalAttribute(paramSchemaGlobalAttributeImpl.getRef());
/*      */     } 
/*      */   }
/*      */   
/*      */   SchemaGlobalAttribute[] globalAttributes() {
/*  941 */     return (SchemaGlobalAttribute[])this._globalAttributes.values().toArray((Object[])new SchemaGlobalAttribute[this._globalAttributes.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaGlobalElementImpl findGlobalElement(b paramb, String paramString1, String paramString2) {
/*  947 */     paramb = compatName(paramb, paramString1);
/*  948 */     SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl)this._globalElements.get(paramb);
/*  949 */     boolean bool = false;
/*  950 */     if (schemaGlobalElementImpl == null) {
/*      */       
/*  952 */       schemaGlobalElementImpl = (SchemaGlobalElementImpl)this._importingLoader.findElement(paramb);
/*  953 */       bool = (schemaGlobalElementImpl != null) ? true : false;
/*      */     } 
/*  955 */     if (!bool && paramString2 != null)
/*  956 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  957 */     return schemaGlobalElementImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addGlobalElement(SchemaGlobalElementImpl paramSchemaGlobalElementImpl) {
/*  962 */     if (paramSchemaGlobalElementImpl != null) {
/*      */       
/*  964 */       b b = paramSchemaGlobalElementImpl.getName();
/*  965 */       this._globalElements.put(b, paramSchemaGlobalElementImpl);
/*  966 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/*  967 */       assert schemaContainer != null && schemaContainer == paramSchemaGlobalElementImpl.getContainer();
/*  968 */       schemaContainer.addGlobalElement(paramSchemaGlobalElementImpl.getRef());
/*  969 */       addSpelling(b, (SchemaComponent)paramSchemaGlobalElementImpl);
/*      */     } 
/*      */   }
/*      */   
/*      */   SchemaGlobalElement[] globalElements() {
/*  974 */     return (SchemaGlobalElement[])this._globalElements.values().toArray((Object[])new SchemaGlobalElement[this._globalElements.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaAttributeGroupImpl findAttributeGroup(b paramb, String paramString1, String paramString2) {
/*  980 */     paramb = compatName(paramb, paramString1);
/*  981 */     SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl)this._attributeGroups.get(paramb);
/*  982 */     boolean bool = false;
/*  983 */     if (schemaAttributeGroupImpl == null) {
/*      */       
/*  985 */       schemaAttributeGroupImpl = (SchemaAttributeGroupImpl)this._importingLoader.findAttributeGroup(paramb);
/*  986 */       bool = (schemaAttributeGroupImpl != null) ? true : false;
/*      */     } 
/*  988 */     if (!bool && paramString2 != null)
/*  989 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/*  990 */     return schemaAttributeGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaAttributeGroupImpl findRedefinedAttributeGroup(b paramb, String paramString, SchemaAttributeGroupImpl paramSchemaAttributeGroupImpl) {
/*  995 */     b b1 = paramSchemaAttributeGroupImpl.getName();
/*  996 */     paramb = compatName(paramb, paramString);
/*  997 */     if (paramb.equals(b1))
/*      */     {
/*  999 */       return (SchemaAttributeGroupImpl)this._redefinedAttributeGroups.get(paramSchemaAttributeGroupImpl);
/*      */     }
/*      */     
/* 1002 */     SchemaAttributeGroupImpl schemaAttributeGroupImpl = (SchemaAttributeGroupImpl)this._attributeGroups.get(paramb);
/* 1003 */     if (schemaAttributeGroupImpl == null)
/* 1004 */       schemaAttributeGroupImpl = (SchemaAttributeGroupImpl)this._importingLoader.findAttributeGroup(paramb); 
/* 1005 */     return schemaAttributeGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addAttributeGroup(SchemaAttributeGroupImpl paramSchemaAttributeGroupImpl1, SchemaAttributeGroupImpl paramSchemaAttributeGroupImpl2) {
/* 1010 */     if (paramSchemaAttributeGroupImpl1 != null) {
/*      */       
/* 1012 */       b b = paramSchemaAttributeGroupImpl1.getName();
/* 1013 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/* 1014 */       assert schemaContainer != null && schemaContainer == paramSchemaAttributeGroupImpl1.getContainer();
/* 1015 */       if (paramSchemaAttributeGroupImpl2 != null) {
/*      */         
/* 1017 */         if (this._redefinedAttributeGroups.containsKey(paramSchemaAttributeGroupImpl2))
/*      */         {
/* 1019 */           if (!ignoreMdef(b)) {
/* 1020 */             if (this._mdefAll) {
/* 1021 */               warning("sch-props-correct.2", new Object[] { "attribute group", QNameHelper.pretty(b), ((SchemaComponent)this._redefinedAttributeGroups.get(paramSchemaAttributeGroupImpl2)).getSourceName() }, paramSchemaAttributeGroupImpl1.getParseObject());
/*      */             }
/*      */             else {
/*      */               
/* 1025 */               error("sch-props-correct.2", new Object[] { "attribute group", QNameHelper.pretty(b), ((SchemaComponent)this._redefinedAttributeGroups.get(paramSchemaAttributeGroupImpl2)).getSourceName() }, paramSchemaAttributeGroupImpl1.getParseObject());
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1033 */           this._redefinedAttributeGroups.put(paramSchemaAttributeGroupImpl2, paramSchemaAttributeGroupImpl1);
/* 1034 */           schemaContainer.addRedefinedAttributeGroup(paramSchemaAttributeGroupImpl1.getRef());
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1039 */       else if (this._attributeGroups.containsKey(b)) {
/*      */         
/* 1041 */         if (!ignoreMdef(b)) {
/* 1042 */           if (this._mdefAll) {
/* 1043 */             warning("sch-props-correct.2", new Object[] { "attribute group", QNameHelper.pretty(b), ((SchemaComponent)this._attributeGroups.get(b)).getSourceName() }, paramSchemaAttributeGroupImpl1.getParseObject());
/*      */           }
/*      */           else {
/*      */             
/* 1047 */             error("sch-props-correct.2", new Object[] { "attribute group", QNameHelper.pretty(b), ((SchemaComponent)this._attributeGroups.get(b)).getSourceName() }, paramSchemaAttributeGroupImpl1.getParseObject());
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/* 1055 */         this._attributeGroups.put(paramSchemaAttributeGroupImpl1.getName(), paramSchemaAttributeGroupImpl1);
/* 1056 */         addSpelling(paramSchemaAttributeGroupImpl1.getName(), (SchemaComponent)paramSchemaAttributeGroupImpl1);
/* 1057 */         schemaContainer.addAttributeGroup(paramSchemaAttributeGroupImpl1.getRef());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaAttributeGroup[] attributeGroups() {
/* 1064 */     return (SchemaAttributeGroup[])this._attributeGroups.values().toArray((Object[])new SchemaAttributeGroup[this._attributeGroups.size()]);
/*      */   }
/*      */   SchemaAttributeGroup[] redefinedAttributeGroups() {
/* 1067 */     return (SchemaAttributeGroup[])this._redefinedAttributeGroups.values().toArray((Object[])new SchemaAttributeGroup[this._redefinedAttributeGroups.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaModelGroupImpl findModelGroup(b paramb, String paramString1, String paramString2) {
/* 1073 */     paramb = compatName(paramb, paramString1);
/* 1074 */     SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl)this._modelGroups.get(paramb);
/* 1075 */     boolean bool = false;
/* 1076 */     if (schemaModelGroupImpl == null) {
/*      */       
/* 1078 */       schemaModelGroupImpl = (SchemaModelGroupImpl)this._importingLoader.findModelGroup(paramb);
/* 1079 */       bool = (schemaModelGroupImpl != null) ? true : false;
/*      */     } 
/* 1081 */     if (!bool && paramString2 != null)
/* 1082 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/* 1083 */     return schemaModelGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaModelGroupImpl findRedefinedModelGroup(b paramb, String paramString, SchemaModelGroupImpl paramSchemaModelGroupImpl) {
/* 1088 */     b b1 = paramSchemaModelGroupImpl.getName();
/* 1089 */     paramb = compatName(paramb, paramString);
/* 1090 */     if (paramb.equals(b1))
/*      */     {
/* 1092 */       return (SchemaModelGroupImpl)this._redefinedModelGroups.get(paramSchemaModelGroupImpl);
/*      */     }
/*      */     
/* 1095 */     SchemaModelGroupImpl schemaModelGroupImpl = (SchemaModelGroupImpl)this._modelGroups.get(paramb);
/* 1096 */     if (schemaModelGroupImpl == null)
/* 1097 */       schemaModelGroupImpl = (SchemaModelGroupImpl)this._importingLoader.findModelGroup(paramb); 
/* 1098 */     return schemaModelGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   void addModelGroup(SchemaModelGroupImpl paramSchemaModelGroupImpl1, SchemaModelGroupImpl paramSchemaModelGroupImpl2) {
/* 1103 */     if (paramSchemaModelGroupImpl1 != null) {
/*      */       
/* 1105 */       b b = paramSchemaModelGroupImpl1.getName();
/* 1106 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/* 1107 */       assert schemaContainer != null && schemaContainer == paramSchemaModelGroupImpl1.getContainer();
/* 1108 */       if (paramSchemaModelGroupImpl2 != null) {
/*      */         
/* 1110 */         if (this._redefinedModelGroups.containsKey(paramSchemaModelGroupImpl2))
/*      */         {
/* 1112 */           if (!ignoreMdef(b)) {
/* 1113 */             if (this._mdefAll) {
/* 1114 */               warning("sch-props-correct.2", new Object[] { "model group", QNameHelper.pretty(b), ((SchemaComponent)this._redefinedModelGroups.get(paramSchemaModelGroupImpl2)).getSourceName() }, paramSchemaModelGroupImpl1.getParseObject());
/*      */             }
/*      */             else {
/*      */               
/* 1118 */               error("sch-props-correct.2", new Object[] { "model group", QNameHelper.pretty(b), ((SchemaComponent)this._redefinedModelGroups.get(paramSchemaModelGroupImpl2)).getSourceName() }, paramSchemaModelGroupImpl1.getParseObject());
/*      */             
/*      */             }
/*      */           
/*      */           }
/*      */         }
/*      */         else
/*      */         {
/* 1126 */           this._redefinedModelGroups.put(paramSchemaModelGroupImpl2, paramSchemaModelGroupImpl1);
/* 1127 */           schemaContainer.addRedefinedModelGroup(paramSchemaModelGroupImpl1.getRef());
/*      */         
/*      */         }
/*      */       
/*      */       }
/* 1132 */       else if (this._modelGroups.containsKey(b)) {
/*      */         
/* 1134 */         if (!ignoreMdef(b)) {
/* 1135 */           if (this._mdefAll) {
/* 1136 */             warning("sch-props-correct.2", new Object[] { "model group", QNameHelper.pretty(b), ((SchemaComponent)this._modelGroups.get(b)).getSourceName() }, paramSchemaModelGroupImpl1.getParseObject());
/*      */           }
/*      */           else {
/*      */             
/* 1140 */             error("sch-props-correct.2", new Object[] { "model group", QNameHelper.pretty(b), ((SchemaComponent)this._modelGroups.get(b)).getSourceName() }, paramSchemaModelGroupImpl1.getParseObject());
/*      */           
/*      */           }
/*      */         
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/* 1148 */         this._modelGroups.put(paramSchemaModelGroupImpl1.getName(), paramSchemaModelGroupImpl1);
/* 1149 */         addSpelling(paramSchemaModelGroupImpl1.getName(), (SchemaComponent)paramSchemaModelGroupImpl1);
/* 1150 */         schemaContainer.addModelGroup(paramSchemaModelGroupImpl1.getRef());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   SchemaModelGroup[] modelGroups() {
/* 1157 */     return (SchemaModelGroup[])this._modelGroups.values().toArray((Object[])new SchemaModelGroup[this._modelGroups.size()]);
/*      */   }
/*      */   SchemaModelGroup[] redefinedModelGroups() {
/* 1160 */     return (SchemaModelGroup[])this._redefinedModelGroups.values().toArray((Object[])new SchemaModelGroup[this._redefinedModelGroups.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   SchemaIdentityConstraintImpl findIdConstraint(b paramb, String paramString1, String paramString2) {
/* 1166 */     paramb = compatName(paramb, paramString1);
/* 1167 */     if (paramString2 != null)
/* 1168 */       registerDependency(paramString2, paramb.getNamespaceURI()); 
/* 1169 */     return (SchemaIdentityConstraintImpl)this._idConstraints.get(paramb);
/*      */   }
/*      */ 
/*      */   
/*      */   void addIdConstraint(SchemaIdentityConstraintImpl paramSchemaIdentityConstraintImpl) {
/* 1174 */     if (paramSchemaIdentityConstraintImpl != null) {
/*      */       
/* 1176 */       b b = paramSchemaIdentityConstraintImpl.getName();
/* 1177 */       SchemaContainer schemaContainer = getContainer(b.getNamespaceURI());
/* 1178 */       assert schemaContainer != null && schemaContainer == paramSchemaIdentityConstraintImpl.getContainer();
/* 1179 */       if (this._idConstraints.containsKey(b)) {
/*      */         
/* 1181 */         if (!ignoreMdef(b)) {
/* 1182 */           warning("sch-props-correct.2", new Object[] { "identity constraint", QNameHelper.pretty(b), ((SchemaComponent)this._idConstraints.get(b)).getSourceName() }, paramSchemaIdentityConstraintImpl.getParseObject());
/*      */         
/*      */         }
/*      */       }
/*      */       else {
/*      */         
/* 1188 */         this._idConstraints.put(b, paramSchemaIdentityConstraintImpl);
/* 1189 */         addSpelling(paramSchemaIdentityConstraintImpl.getName(), (SchemaComponent)paramSchemaIdentityConstraintImpl);
/* 1190 */         schemaContainer.addIdentityConstraint(paramSchemaIdentityConstraintImpl.getRef());
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   SchemaIdentityConstraintImpl[] idConstraints() {
/* 1196 */     return (SchemaIdentityConstraintImpl[])this._idConstraints.values().toArray((Object[])new SchemaIdentityConstraintImpl[this._idConstraints.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   void addAnnotation(SchemaAnnotationImpl paramSchemaAnnotationImpl, String paramString) {
/* 1202 */     if (paramSchemaAnnotationImpl != null) {
/*      */       
/* 1204 */       SchemaContainer schemaContainer = getContainer(paramString);
/* 1205 */       assert schemaContainer != null && schemaContainer == paramSchemaAnnotationImpl.getContainer();
/* 1206 */       this._annotations.add(paramSchemaAnnotationImpl);
/* 1207 */       schemaContainer.addAnnotation(paramSchemaAnnotationImpl);
/*      */     } 
/*      */   }
/*      */   
/*      */   List annotations() {
/* 1212 */     return this._annotations;
/*      */   }
/*      */ 
/*      */   
/*      */   boolean isProcessing(Object paramObject) {
/* 1217 */     return this._processingGroups.contains(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   void startProcessing(Object paramObject) {
/* 1222 */     assert !this._processingGroups.contains(paramObject);
/* 1223 */     this._processingGroups.add(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   void finishProcessing(Object paramObject) {
/* 1228 */     assert this._processingGroups.contains(paramObject);
/* 1229 */     this._processingGroups.remove(paramObject);
/*      */   }
/*      */ 
/*      */   
/*      */   Object[] getCurrentProcessing() {
/* 1234 */     return this._processingGroups.toArray();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   Map typesByClassname() {
/* 1240 */     return Collections.unmodifiableMap(this._typesByClassname);
/*      */   }
/*      */   void addClassname(String paramString, SchemaType paramSchemaType) {
/* 1243 */     this._typesByClassname.put(paramString, paramSchemaType);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class StscStack
/*      */   {
/*      */     StscState current;
/*      */ 
/*      */     
/* 1254 */     ArrayList stack = new ArrayList();
/*      */     
/*      */     final StscState push() {
/* 1257 */       this.stack.add(this.current);
/* 1258 */       this.current = new StscState();
/* 1259 */       return this.current;
/*      */     }
/*      */     
/*      */     final void pop() {
/* 1263 */       this.current = this.stack.get(this.stack.size() - 1);
/* 1264 */       this.stack.remove(this.stack.size() - 1);
/*      */     }
/*      */     
/*      */     private StscStack() {} }
/* 1268 */   private static ThreadLocal tl_stscStack = new ThreadLocal();
/*      */ 
/*      */   
/*      */   public static StscState start() {
/* 1272 */     StscStack stscStack = tl_stscStack.get();
/*      */     
/* 1274 */     if (stscStack == null) {
/*      */       
/* 1276 */       stscStack = new StscStack();
/* 1277 */       tl_stscStack.set(stscStack);
/*      */     } 
/* 1279 */     return stscStack.push();
/*      */   }
/*      */ 
/*      */   
/*      */   public static StscState get() {
/* 1284 */     return ((StscStack)tl_stscStack.get()).current;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void end() {
/* 1289 */     StscStack stscStack = tl_stscStack.get();
/* 1290 */     stscStack.pop();
/* 1291 */     if (stscStack.stack.size() == 0) {
/* 1292 */       tl_stscStack.set(null);
/*      */     }
/*      */   }
/*      */   
/* 1296 */   private static final XmlValueRef XMLSTR_PRESERVE = buildString("preserve");
/* 1297 */   private static final XmlValueRef XMLSTR_REPLACE = buildString("preserve");
/* 1298 */   private static final XmlValueRef XMLSTR_COLLAPSE = buildString("preserve");
/*      */   
/* 1300 */   static final SchemaType[] EMPTY_ST_ARRAY = new SchemaType[0];
/* 1301 */   static final SchemaType.Ref[] EMPTY_STREF_ARRAY = new SchemaType.Ref[0];
/*      */   
/* 1303 */   private static final XmlValueRef[] FACETS_NONE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, null, null, null };
/*      */ 
/*      */ 
/*      */   
/* 1307 */   private static final boolean[] FIXED_FACETS_NONE = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, false, 
/*      */       false, false };
/*      */   
/* 1311 */   private static final XmlValueRef[] FACETS_WS_COLLAPSE = new XmlValueRef[] { null, null, null, null, null, null, null, null, null, build_wsstring(3), null, null };
/*      */ 
/*      */ 
/*      */   
/* 1315 */   private static final boolean[] FIXED_FACETS_WS = new boolean[] { 
/*      */       false, false, false, false, false, false, false, false, false, true, 
/*      */       false, false };
/*      */   
/* 1319 */   static final XmlValueRef[] FACETS_UNION = FACETS_NONE;
/* 1320 */   static final boolean[] FIXED_FACETS_UNION = FIXED_FACETS_NONE;
/* 1321 */   static final XmlValueRef[] FACETS_LIST = FACETS_WS_COLLAPSE;
/* 1322 */   static final boolean[] FIXED_FACETS_LIST = FIXED_FACETS_WS; private static final String PROJECT_URL_PREFIX = "project://local";
/*      */   Map _sourceForUri;
/*      */   
/*      */   static XmlValueRef build_wsstring(int paramInt) {
/* 1326 */     switch (paramInt) {
/*      */       
/*      */       case 1:
/* 1329 */         return XMLSTR_PRESERVE;
/*      */       case 2:
/* 1331 */         return XMLSTR_REPLACE;
/*      */       case 3:
/* 1333 */         return XMLSTR_COLLAPSE;
/*      */     } 
/* 1335 */     return null;
/*      */   }
/*      */   URI _baseURI; SchemaTypeLoader _s4sloader; static final boolean $assertionsDisabled;
/*      */   
/*      */   static XmlValueRef buildString(String paramString) {
/* 1340 */     if (paramString == null) {
/* 1341 */       return null;
/*      */     }
/*      */     
/*      */     try {
/* 1345 */       XmlStringImpl xmlStringImpl = new XmlStringImpl();
/* 1346 */       xmlStringImpl.set(paramString);
/* 1347 */       xmlStringImpl.setImmutable();
/* 1348 */       return new XmlValueRef((XmlAnySimpleType)xmlStringImpl);
/*      */     }
/* 1350 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/* 1352 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void notFoundError(b paramb, int paramInt, XmlObject paramXmlObject, boolean paramBoolean) {
/* 1359 */     String str1, str2 = QNameHelper.pretty(paramb);
/* 1360 */     String str3 = null;
/* 1361 */     String str4 = null;
/* 1362 */     String str5 = null;
/*      */     
/* 1364 */     if (paramBoolean) {
/* 1365 */       this._recoveredErrors++;
/*      */     }
/* 1367 */     switch (paramInt) {
/*      */       
/*      */       case 0:
/* 1370 */         str1 = "type";
/*      */         break;
/*      */       case 1:
/* 1373 */         str1 = "element";
/*      */         break;
/*      */       case 3:
/* 1376 */         str1 = "attribute";
/*      */         break;
/*      */       case 6:
/* 1379 */         str1 = "model group";
/*      */         break;
/*      */       case 4:
/* 1382 */         str1 = "attribute group";
/*      */         break;
/*      */       case 5:
/* 1385 */         str1 = "identity constraint";
/*      */         break;
/*      */       default:
/*      */         assert false;
/* 1389 */         str1 = "definition";
/*      */         break;
/*      */     } 
/*      */     
/* 1393 */     SchemaComponent schemaComponent = findSpelling(paramb);
/*      */     
/* 1395 */     if (schemaComponent != null) {
/*      */       
/* 1397 */       b b1 = schemaComponent.getName();
/* 1398 */       if (b1 != null) {
/*      */         
/* 1400 */         switch (schemaComponent.getComponentType()) {
/*      */           
/*      */           case 0:
/* 1403 */             str3 = "type";
/* 1404 */             str5 = ((SchemaType)schemaComponent).getSourceName();
/*      */             break;
/*      */           case 1:
/* 1407 */             str3 = "element";
/* 1408 */             str5 = ((SchemaGlobalElement)schemaComponent).getSourceName();
/*      */             break;
/*      */           case 3:
/* 1411 */             str3 = "attribute";
/* 1412 */             str5 = ((SchemaGlobalAttribute)schemaComponent).getSourceName();
/*      */             break;
/*      */           case 4:
/* 1415 */             str3 = "attribute group";
/*      */             break;
/*      */           case 6:
/* 1418 */             str3 = "model group";
/*      */             break;
/*      */         } 
/*      */         
/* 1422 */         if (str5 != null)
/*      */         {
/* 1424 */           str5 = str5.substring(str5.lastIndexOf('/') + 1);
/*      */         }
/*      */         
/* 1427 */         if (!b1.equals(paramb))
/*      */         {
/* 1429 */           str4 = QNameHelper.pretty(b1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1434 */     if (str3 == null) {
/*      */ 
/*      */       
/* 1437 */       error("src-resolve", new Object[] { str1, str2 }, paramXmlObject);
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1442 */       error("src-resolve.a", new Object[] { str1, str2, str3, (str4 == null) ? new Integer(0) : new Integer(1), str4, (str5 == null) ? new Integer(0) : new Integer(1), str5 }, paramXmlObject);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String sourceNameForUri(String paramString) {
/* 1465 */     return (String)this._sourceForUri.get(paramString);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Map sourceCopyMap() {
/* 1475 */     return Collections.unmodifiableMap(this._sourceForUri);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setBaseUri(URI paramURI) {
/* 1483 */     this._baseURI = paramURI;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String relativize(String paramString) {
/* 1490 */     return relativize(paramString, false);
/*      */   }
/*      */ 
/*      */   
/*      */   public String computeSavedFilename(String paramString) {
/* 1495 */     return relativize(paramString, true);
/*      */   }
/*      */ 
/*      */   
/*      */   private String relativize(String paramString, boolean paramBoolean) {
/* 1500 */     if (paramString == null) {
/* 1501 */       return null;
/*      */     }
/*      */     
/* 1504 */     if (paramString.startsWith("/")) {
/*      */       
/* 1506 */       paramString = "project://local" + paramString.replace('\\', '/');
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1511 */       int k = paramString.indexOf(':');
/* 1512 */       if (k <= 1 || !paramString.substring(0, k).matches("^\\w+$")) {
/* 1513 */         paramString = "project://local/" + paramString.replace('\\', '/');
/*      */       }
/*      */     } 
/*      */     
/* 1517 */     if (this._baseURI != null) {
/*      */       
/*      */       try {
/*      */         
/* 1521 */         URI uRI = this._baseURI.relativize(new URI(paramString));
/* 1522 */         if (!uRI.isAbsolute()) {
/* 1523 */           return uRI.toString();
/*      */         }
/* 1525 */         paramString = uRI.toString();
/*      */       }
/* 1527 */       catch (URISyntaxException uRISyntaxException) {}
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1532 */     if (!paramBoolean) {
/* 1533 */       return paramString;
/*      */     }
/* 1535 */     int i = paramString.lastIndexOf('/');
/* 1536 */     String str1 = QNameHelper.hexsafe((i == -1) ? "" : paramString.substring(0, i));
/*      */     
/* 1538 */     int j = paramString.indexOf('?', i + 1);
/* 1539 */     if (j == -1) {
/* 1540 */       return str1 + "/" + paramString.substring(i + 1);
/*      */     }
/* 1542 */     String str2 = QNameHelper.hexsafe((j == -1) ? "" : paramString.substring(j));
/*      */ 
/*      */     
/* 1545 */     if (str2.startsWith("URI_SHA_1_")) {
/* 1546 */       return str1 + "/" + paramString.substring(i + 1, j);
/*      */     }
/* 1548 */     return str1 + "/" + paramString.substring(i + 1, j) + str2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSourceUri(String paramString1, String paramString2) {
/* 1557 */     if (paramString1 == null) {
/*      */       return;
/*      */     }
/* 1560 */     if (paramString2 == null) {
/* 1561 */       paramString2 = computeSavedFilename(paramString1);
/*      */     }
/* 1563 */     this._sourceForUri.put(paramString1, paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Collection getErrorListener() {
/* 1571 */     return this._errorListener;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaTypeLoader getS4SLoader() {
/* 1579 */     return this._s4sloader;
/*      */   }
/*      */   private StscState() {
/* 1582 */     this._sourceForUri = new HashMap();
/* 1583 */     this._baseURI = URI.create("project://local/");
/* 1584 */     this._s4sloader = XmlBeans.typeLoaderForClassLoader(SchemaDocument.class.getClassLoader());
/*      */   }
/*      */   
/*      */   public File getSchemasDir() {
/* 1588 */     return this._schemasDir;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setSchemasDir(File paramFile) {
/* 1593 */     this._schemasDir = paramFile;
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscState.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */