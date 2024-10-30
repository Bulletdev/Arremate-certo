/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.QNameSetBuilder;
/*      */ import org.apache.xmlbeans.QNameSetSpecification;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*      */ import org.apache.xmlbeans.SchemaLocalElement;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AllNNI;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AnyDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroupRef;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexContentDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexRestrictionType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ExtensionType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Group;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleRestrictionType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*      */ 
/*      */ public class StscComplexTypeResolver {
/*      */   private static final int MODEL_GROUP_CODE = 100;
/*      */   
/*      */   public static Group getContentModel(ComplexType paramComplexType) {
/*   47 */     if (paramComplexType.getAll() != null) {
/*   48 */       return (Group)paramComplexType.getAll();
/*      */     }
/*   50 */     if (paramComplexType.getSequence() != null) {
/*   51 */       return (Group)paramComplexType.getSequence();
/*      */     }
/*   53 */     if (paramComplexType.getChoice() != null) {
/*   54 */       return (Group)paramComplexType.getChoice();
/*      */     }
/*   56 */     if (paramComplexType.getGroup() != null) {
/*   57 */       return (Group)paramComplexType.getGroup();
/*      */     }
/*   59 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static Group getContentModel(ComplexRestrictionType paramComplexRestrictionType) {
/*   64 */     if (paramComplexRestrictionType.getAll() != null) {
/*   65 */       return (Group)paramComplexRestrictionType.getAll();
/*      */     }
/*   67 */     if (paramComplexRestrictionType.getSequence() != null) {
/*   68 */       return (Group)paramComplexRestrictionType.getSequence();
/*      */     }
/*   70 */     if (paramComplexRestrictionType.getChoice() != null) {
/*   71 */       return (Group)paramComplexRestrictionType.getChoice();
/*      */     }
/*   73 */     if (paramComplexRestrictionType.getGroup() != null) {
/*   74 */       return (Group)paramComplexRestrictionType.getGroup();
/*      */     }
/*   76 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Group getContentModel(ExtensionType paramExtensionType) {
/*   82 */     if (paramExtensionType.getAll() != null) {
/*   83 */       return (Group)paramExtensionType.getAll();
/*      */     }
/*   85 */     if (paramExtensionType.getSequence() != null) {
/*   86 */       return (Group)paramExtensionType.getSequence();
/*      */     }
/*   88 */     if (paramExtensionType.getChoice() != null) {
/*   89 */       return (Group)paramExtensionType.getChoice();
/*      */     }
/*   91 */     if (paramExtensionType.getGroup() != null) {
/*   92 */       return (Group)paramExtensionType.getGroup();
/*      */     }
/*   94 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaDocument.Schema getSchema(XmlObject paramXmlObject) {
/*  100 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/*      */ 
/*      */     
/*      */     try {
/*  104 */       while (xmlCursor.toParent()) {
/*      */         
/*  106 */         paramXmlObject = xmlCursor.getObject();
/*      */         
/*  108 */         if (paramXmlObject.schemaType().equals(SchemaDocument.Schema.type)) {
/*  109 */           return (SchemaDocument.Schema)paramXmlObject;
/*      */         }
/*      */       } 
/*      */     } finally {
/*      */       
/*  114 */       xmlCursor.dispose();
/*      */     } 
/*      */     
/*  117 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void resolveComplexType(SchemaTypeImpl paramSchemaTypeImpl) {
/*  122 */     ComplexType complexType = (ComplexType)paramSchemaTypeImpl.getParseObject();
/*  123 */     StscState stscState = StscState.get();
/*  124 */     SchemaDocument.Schema schema = getSchema((XmlObject)complexType);
/*      */ 
/*      */     
/*  127 */     boolean bool1 = complexType.isSetAbstract() ? complexType.getAbstract() : false;
/*  128 */     boolean bool2 = false;
/*  129 */     boolean bool3 = false;
/*  130 */     boolean bool4 = false;
/*  131 */     boolean bool5 = false;
/*      */     
/*  133 */     Object object1 = null;
/*  134 */     if (complexType.isSetFinal()) {
/*      */       
/*  136 */       object1 = complexType.getFinal();
/*      */     
/*      */     }
/*  139 */     else if (schema != null && schema.isSetFinalDefault()) {
/*      */       
/*  141 */       object1 = schema.getFinalDefault();
/*      */     } 
/*      */     
/*  144 */     if (object1 != null)
/*      */     {
/*  146 */       if (object1 instanceof String && object1.equals("#all")) {
/*      */ 
/*      */         
/*  149 */         bool2 = bool3 = bool4 = bool5 = true;
/*      */       }
/*  151 */       else if (object1 instanceof List) {
/*      */         
/*  153 */         if (((List)object1).contains("extension")) {
/*  154 */           bool2 = true;
/*      */         }
/*  156 */         if (((List)object1).contains("restriction")) {
/*  157 */           bool3 = true;
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  170 */     paramSchemaTypeImpl.setAbstractFinal(bool1, bool2, bool3, bool4, bool5);
/*      */ 
/*      */     
/*  173 */     boolean bool6 = false;
/*  174 */     boolean bool7 = false;
/*  175 */     Object object2 = null;
/*      */     
/*  177 */     if (complexType.isSetBlock()) {
/*  178 */       object2 = complexType.getBlock();
/*  179 */     } else if (schema != null && schema.isSetBlockDefault()) {
/*  180 */       object2 = schema.getBlockDefault();
/*      */     } 
/*  182 */     if (object2 != null)
/*      */     {
/*  184 */       if (object2 instanceof String && object2.equals("#all")) {
/*      */ 
/*      */         
/*  187 */         bool6 = bool7 = true;
/*      */       }
/*  189 */       else if (object2 instanceof List) {
/*      */         
/*  191 */         if (((List)object2).contains("extension"))
/*  192 */           bool6 = true; 
/*  193 */         if (((List)object2).contains("restriction")) {
/*  194 */           bool7 = true;
/*      */         }
/*      */       } 
/*      */     }
/*  198 */     paramSchemaTypeImpl.setBlock(bool6, bool7);
/*      */ 
/*      */     
/*  201 */     ComplexContentDocument.ComplexContent complexContent = complexType.getComplexContent();
/*  202 */     SimpleContentDocument.SimpleContent simpleContent = complexType.getSimpleContent();
/*  203 */     Group group = getContentModel(complexType);
/*  204 */     int i = ((complexContent != null) ? 1 : 0) + ((simpleContent != null) ? 1 : 0) + ((group != null) ? 1 : 0);
/*      */ 
/*      */ 
/*      */     
/*  208 */     if (i > 1) {
/*      */ 
/*      */       
/*  211 */       stscState.error("A complex type must define either a content model, or a simpleContent or complexContent derivation: more than one found.", 26, (XmlObject)complexType);
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  216 */       group = null;
/*  217 */       if (complexContent != null && simpleContent != null) {
/*  218 */         simpleContent = null;
/*      */       }
/*      */     } 
/*  221 */     if (complexContent != null) {
/*      */ 
/*      */       
/*  224 */       if (complexContent.getExtension() != null && complexContent.getRestriction() != null) {
/*  225 */         stscState.error("Restriction conflicts with extension", 26, (XmlObject)complexContent.getRestriction());
/*      */       }
/*      */ 
/*      */       
/*  229 */       boolean bool = complexContent.isSetMixed() ? complexContent.getMixed() : complexType.getMixed();
/*      */       
/*  231 */       if (complexContent.getExtension() != null) {
/*  232 */         resolveCcExtension(paramSchemaTypeImpl, complexContent.getExtension(), bool);
/*  233 */       } else if (complexContent.getRestriction() != null) {
/*  234 */         resolveCcRestriction(paramSchemaTypeImpl, complexContent.getRestriction(), bool);
/*      */       }
/*      */       else {
/*      */         
/*  238 */         stscState.error("Missing restriction or extension", 27, (XmlObject)complexContent);
/*  239 */         resolveErrorType(paramSchemaTypeImpl);
/*      */       } 
/*      */       return;
/*      */     } 
/*  243 */     if (simpleContent != null) {
/*      */ 
/*      */       
/*  246 */       if (simpleContent.getExtension() != null && simpleContent.getRestriction() != null) {
/*  247 */         stscState.error("Restriction conflicts with extension", 26, (XmlObject)simpleContent.getRestriction());
/*      */       }
/*  249 */       if (simpleContent.getExtension() != null) {
/*  250 */         resolveScExtension(paramSchemaTypeImpl, simpleContent.getExtension());
/*  251 */       } else if (simpleContent.getRestriction() != null) {
/*  252 */         resolveScRestriction(paramSchemaTypeImpl, simpleContent.getRestriction());
/*      */       }
/*      */       else {
/*      */         
/*  256 */         stscState.error("Missing restriction or extension", 27, (XmlObject)simpleContent);
/*  257 */         resolveErrorType(paramSchemaTypeImpl);
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/*  262 */     resolveBasicComplexType(paramSchemaTypeImpl);
/*      */   }
/*      */ 
/*      */   
/*      */   static void resolveErrorType(SchemaTypeImpl paramSchemaTypeImpl) {
/*  267 */     throw new RuntimeException("This type of error recovery not yet implemented.");
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaType.Ref[] makeRefArray(Collection paramCollection) {
/*  272 */     SchemaType.Ref[] arrayOfRef = new SchemaType.Ref[paramCollection.size()];
/*  273 */     byte b = 0;
/*  274 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext(); b++)
/*  275 */       arrayOfRef[b] = ((SchemaType)iterator.next()).getRef(); 
/*  276 */     return arrayOfRef;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void resolveBasicComplexType(SchemaTypeImpl paramSchemaTypeImpl) {
/*  282 */     ArrayList arrayList = new ArrayList();
/*  283 */     ComplexType complexType = (ComplexType)paramSchemaTypeImpl.getParseObject();
/*  284 */     String str = paramSchemaTypeImpl.getTargetNamespace();
/*  285 */     boolean bool1 = (paramSchemaTypeImpl.getChameleonNamespace() != null) ? true : false;
/*  286 */     Group group = getContentModel(complexType);
/*      */     
/*  288 */     if (paramSchemaTypeImpl.isRedefinition())
/*      */     {
/*  290 */       StscState.get().error("src-redefine.5a", new Object[] { "<complexType>" }, (XmlObject)complexType);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  295 */     int i = translateParticleCode(group);
/*      */ 
/*      */     
/*  298 */     LinkedHashMap linkedHashMap = new LinkedHashMap();
/*      */ 
/*      */     
/*  301 */     SchemaParticle schemaParticle = translateContentModel(paramSchemaTypeImpl, (XmlObject)group, str, bool1, paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), i, arrayList, linkedHashMap, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  307 */     boolean bool2 = (schemaParticle != null && schemaParticle.getParticleType() == 1) ? true : false;
/*      */ 
/*      */     
/*  310 */     SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/*  311 */     translateAttributeModel((XmlObject)complexType, str, bool1, paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl, null, schemaAttributeModelImpl, null, true, null);
/*      */ 
/*      */ 
/*      */     
/*  315 */     WildcardResult wildcardResult1 = summarizeEltWildcards(schemaParticle);
/*  316 */     WildcardResult wildcardResult2 = summarizeAttrWildcards(schemaAttributeModelImpl);
/*      */ 
/*      */     
/*  319 */     if (schemaParticle != null) {
/*      */       
/*  321 */       buildStateMachine(schemaParticle);
/*  322 */       if (!StscState.get().noUpa() && !((SchemaParticleImpl)schemaParticle).isDeterministic()) {
/*  323 */         StscState.get().error("cos-nonambig", (Object[])null, (XmlObject)group);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  328 */     Map map1 = buildContentPropertyModelByQName(schemaParticle, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  331 */     Map map2 = buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  334 */     boolean bool3 = complexType.getMixed() ? true : ((schemaParticle == null) ? true : true);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  342 */     paramSchemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
/*  343 */     paramSchemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getBaseDepth() + 1);
/*  344 */     paramSchemaTypeImpl.setDerivationType(2);
/*  345 */     paramSchemaTypeImpl.setComplexTypeVariety(bool3);
/*  346 */     paramSchemaTypeImpl.setContentModel(schemaParticle, schemaAttributeModelImpl, map1, map2, bool2);
/*  347 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*  348 */     paramSchemaTypeImpl.setWildcardSummary(wildcardResult1.typedWildcards, wildcardResult1.hasWildcards, wildcardResult2.typedWildcards, wildcardResult2.hasWildcards);
/*      */   }
/*      */   static void resolveCcRestriction(SchemaTypeImpl paramSchemaTypeImpl, ComplexRestrictionType paramComplexRestrictionType, boolean paramBoolean) {
/*      */     SchemaTypeImpl schemaTypeImpl;
/*      */     SchemaAttributeModelImpl schemaAttributeModelImpl;
/*  353 */     StscState stscState = StscState.get();
/*  354 */     String str = paramSchemaTypeImpl.getTargetNamespace();
/*  355 */     boolean bool1 = (paramSchemaTypeImpl.getChameleonNamespace() != null) ? true : false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  361 */     if (paramComplexRestrictionType.getBase() == null) {
/*      */ 
/*      */       
/*  364 */       stscState.error("A complexContent must define a base type", 28, (XmlObject)paramComplexRestrictionType);
/*  365 */       schemaTypeImpl = null;
/*      */     }
/*      */     else {
/*      */       
/*  369 */       if (paramSchemaTypeImpl.isRedefinition()) {
/*      */         
/*  371 */         schemaTypeImpl = stscState.findRedefinedGlobalType(paramComplexRestrictionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl);
/*  372 */         if (schemaTypeImpl != null && !schemaTypeImpl.getName().equals(paramSchemaTypeImpl.getName()))
/*      */         {
/*  374 */           stscState.error("src-redefine.5b", new Object[] { "<complexType>", QNameHelper.pretty(schemaTypeImpl.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramComplexRestrictionType);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  384 */         schemaTypeImpl = stscState.findGlobalType(paramComplexRestrictionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), str);
/*      */       } 
/*      */       
/*  387 */       if (schemaTypeImpl == null) {
/*  388 */         stscState.notFoundError(paramComplexRestrictionType.getBase(), 0, (XmlObject)paramComplexRestrictionType.xgetBase(), true);
/*      */       }
/*      */     } 
/*  391 */     if (schemaTypeImpl == null) {
/*  392 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
/*      */     }
/*  394 */     if (schemaTypeImpl != null && schemaTypeImpl.finalRestriction())
/*      */     {
/*  396 */       stscState.error("derivation-ok-restriction.1", new Object[] { QNameHelper.pretty(schemaTypeImpl.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramComplexRestrictionType.xgetBase());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  403 */     if (schemaTypeImpl != null)
/*      */     {
/*  405 */       if (!StscResolver.resolveType(schemaTypeImpl)) {
/*  406 */         schemaTypeImpl = null;
/*      */       }
/*      */     }
/*  409 */     ArrayList arrayList = new ArrayList();
/*  410 */     Group group = getContentModel(paramComplexRestrictionType);
/*      */ 
/*      */     
/*  413 */     int i = translateParticleCode(group);
/*      */ 
/*      */     
/*  416 */     LinkedHashMap linkedHashMap = new LinkedHashMap();
/*      */ 
/*      */     
/*  419 */     SchemaParticle schemaParticle = translateContentModel(paramSchemaTypeImpl, (XmlObject)group, str, bool1, paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), i, arrayList, linkedHashMap, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  425 */     boolean bool2 = (schemaParticle != null && schemaParticle.getParticleType() == 1) ? true : false;
/*      */ 
/*      */ 
/*      */     
/*  429 */     if (schemaTypeImpl == null) {
/*  430 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/*      */     } else {
/*  432 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl.getAttributeModel());
/*  433 */     }  translateAttributeModel((XmlObject)paramComplexRestrictionType, str, bool1, paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl, false, null);
/*      */ 
/*      */ 
/*      */     
/*  437 */     WildcardResult wildcardResult1 = summarizeEltWildcards(schemaParticle);
/*  438 */     WildcardResult wildcardResult2 = summarizeAttrWildcards(schemaAttributeModelImpl);
/*      */ 
/*      */     
/*  441 */     if (schemaParticle != null) {
/*      */       
/*  443 */       buildStateMachine(schemaParticle);
/*  444 */       if (!StscState.get().noUpa() && !((SchemaParticleImpl)schemaParticle).isDeterministic()) {
/*  445 */         StscState.get().error("cos-nonambig", (Object[])null, (XmlObject)group);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  450 */     Map map1 = buildContentPropertyModelByQName(schemaParticle, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  453 */     Map map2 = buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*      */ 
/*      */ 
/*      */     
/*  457 */     boolean bool3 = paramBoolean ? true : ((schemaParticle == null) ? true : true);
/*      */ 
/*      */ 
/*      */     
/*  461 */     paramSchemaTypeImpl.setBaseTypeRef(schemaTypeImpl.getRef());
/*  462 */     paramSchemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
/*  463 */     paramSchemaTypeImpl.setDerivationType(1);
/*  464 */     paramSchemaTypeImpl.setComplexTypeVariety(bool3);
/*  465 */     paramSchemaTypeImpl.setContentModel(schemaParticle, schemaAttributeModelImpl, map1, map2, bool2);
/*  466 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*  467 */     paramSchemaTypeImpl.setWildcardSummary(wildcardResult1.typedWildcards, wildcardResult1.hasWildcards, wildcardResult2.typedWildcards, wildcardResult2.hasWildcards);
/*      */   }
/*      */ 
/*      */   
/*      */   static Map extractElementModel(SchemaType paramSchemaType) {
/*  472 */     HashMap hashMap = new HashMap();
/*  473 */     if (paramSchemaType != null) {
/*      */       
/*  475 */       SchemaProperty[] arrayOfSchemaProperty = paramSchemaType.getProperties();
/*  476 */       for (byte b = 0; b < arrayOfSchemaProperty.length; b++) {
/*      */         
/*  478 */         if (!arrayOfSchemaProperty[b].isAttribute())
/*      */         {
/*  480 */           hashMap.put(arrayOfSchemaProperty[b].getName(), arrayOfSchemaProperty[b].getType());
/*      */         }
/*      */       } 
/*      */     } 
/*  484 */     return hashMap;
/*      */   }
/*      */   static void resolveCcExtension(SchemaTypeImpl paramSchemaTypeImpl, ExtensionType paramExtensionType, boolean paramBoolean) {
/*      */     SchemaType schemaType;
/*      */     SchemaAttributeModelImpl schemaAttributeModelImpl;
/*      */     boolean bool3;
/*  490 */     StscState stscState = StscState.get();
/*  491 */     String str = paramSchemaTypeImpl.getTargetNamespace();
/*  492 */     boolean bool1 = (paramSchemaTypeImpl.getChameleonNamespace() != null) ? true : false;
/*      */     
/*  494 */     if (paramExtensionType.getBase() == null) {
/*      */ 
/*      */       
/*  497 */       stscState.error("A complexContent must define a base type", 28, (XmlObject)paramExtensionType);
/*  498 */       schemaType = null;
/*      */     }
/*      */     else {
/*      */       
/*  502 */       if (paramSchemaTypeImpl.isRedefinition()) {
/*      */         
/*  504 */         schemaType = stscState.findRedefinedGlobalType(paramExtensionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl);
/*  505 */         if (schemaType != null && !schemaType.getName().equals(paramSchemaTypeImpl.getName()))
/*      */         {
/*  507 */           stscState.error("src-redefine.5b", new Object[] { "<complexType>", QNameHelper.pretty(schemaType.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramExtensionType);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  517 */         schemaType = stscState.findGlobalType(paramExtensionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), str);
/*      */       } 
/*  519 */       if (schemaType == null) {
/*  520 */         stscState.notFoundError(paramExtensionType.getBase(), 0, (XmlObject)paramExtensionType.xgetBase(), true);
/*      */       }
/*      */     } 
/*      */     
/*  524 */     if (schemaType != null)
/*      */     {
/*  526 */       if (!StscResolver.resolveType((SchemaTypeImpl)schemaType)) {
/*  527 */         schemaType = null;
/*      */       }
/*      */     }
/*  530 */     if (schemaType != null && schemaType.isSimpleType()) {
/*      */       
/*  532 */       stscState.recover("src-ct.1", new Object[] { QNameHelper.pretty(schemaType.getName()) }, (XmlObject)paramExtensionType.xgetBase());
/*      */ 
/*      */       
/*  535 */       schemaType = null;
/*      */     } 
/*      */     
/*  538 */     if (schemaType != null && schemaType.finalExtension())
/*      */     {
/*  540 */       stscState.error("cos-ct-extends.1.1", new Object[] { QNameHelper.pretty(schemaType.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramExtensionType.xgetBase());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  547 */     SchemaParticle schemaParticle1 = (schemaType == null) ? null : schemaType.getContentModel();
/*      */ 
/*      */     
/*  550 */     ArrayList arrayList = new ArrayList();
/*  551 */     Map map1 = extractElementModel(schemaType);
/*  552 */     Group group = getContentModel(paramExtensionType);
/*      */     
/*  554 */     if (schemaType != null && schemaType.getContentType() == 2)
/*      */     {
/*  556 */       if (group != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  561 */         stscState.recover("cos-ct-extends.1.4.1", new Object[] { QNameHelper.pretty(schemaType.getName()) }, (XmlObject)paramExtensionType.xgetBase());
/*      */ 
/*      */         
/*  564 */         schemaType = null;
/*      */       
/*      */       }
/*      */       else {
/*      */         
/*  569 */         resolveScExtensionPart2(paramSchemaTypeImpl, schemaType, paramExtensionType, str, bool1);
/*      */         
/*      */         return;
/*      */       } 
/*      */     }
/*  574 */     SchemaParticle schemaParticle2 = translateContentModel(paramSchemaTypeImpl, (XmlObject)group, str, bool1, paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), translateParticleCode(group), arrayList, map1, false, null);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  580 */     if (schemaParticle2 == null && !paramBoolean) {
/*  581 */       paramBoolean = (schemaType != null && schemaType.getContentType() == 4);
/*      */     }
/*      */     
/*  584 */     if (schemaType != null && schemaType.getContentType() != 1 && ((schemaType.getContentType() == 4)) != paramBoolean)
/*      */     {
/*      */       
/*  587 */       stscState.error("cos-ct-extends.1.4.2.2", (Object[])null, (XmlObject)paramExtensionType.xgetBase());
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  592 */     if (schemaType != null && schemaType.hasAllContent() && schemaParticle2 != null) {
/*      */ 
/*      */       
/*  595 */       stscState.error("Cannot extend a type with 'all' content model", 42, (XmlObject)paramExtensionType.xgetBase());
/*  596 */       schemaParticle2 = null;
/*      */     } 
/*      */ 
/*      */     
/*  600 */     SchemaParticle schemaParticle3 = extendContentModel(schemaParticle1, schemaParticle2, (XmlObject)paramExtensionType);
/*      */ 
/*      */     
/*  603 */     boolean bool2 = (schemaParticle3 != null && schemaParticle3.getParticleType() == 1) ? true : false;
/*      */ 
/*      */ 
/*      */     
/*  607 */     if (schemaType == null) {
/*  608 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/*      */     } else {
/*  610 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaType.getAttributeModel());
/*  611 */     }  translateAttributeModel((XmlObject)paramExtensionType, str, bool1, paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl, null, schemaAttributeModelImpl, schemaType, true, null);
/*      */ 
/*      */ 
/*      */     
/*  615 */     WildcardResult wildcardResult1 = summarizeEltWildcards(schemaParticle3);
/*  616 */     WildcardResult wildcardResult2 = summarizeAttrWildcards(schemaAttributeModelImpl);
/*      */ 
/*      */     
/*  619 */     if (schemaParticle3 != null) {
/*      */       
/*  621 */       buildStateMachine(schemaParticle3);
/*  622 */       if (!StscState.get().noUpa() && !((SchemaParticleImpl)schemaParticle3).isDeterministic()) {
/*  623 */         StscState.get().error("cos-nonambig", (Object[])null, (XmlObject)group);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  628 */     Map map2 = buildContentPropertyModelByQName(schemaParticle3, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  631 */     Map map3 = buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*      */ 
/*      */ 
/*      */     
/*  635 */     if (schemaParticle3 == null && schemaType != null && schemaType.getContentType() == 2) {
/*      */ 
/*      */       
/*  638 */       bool3 = true;
/*  639 */       paramSchemaTypeImpl.setContentBasedOnTypeRef(schemaType.getContentBasedOnType().getRef());
/*      */     } else {
/*      */       
/*  642 */       bool3 = paramBoolean ? true : ((schemaParticle3 == null) ? true : true);
/*      */     } 
/*      */ 
/*      */     
/*  646 */     if (schemaType == null)
/*  647 */       schemaType = XmlObject.type; 
/*  648 */     paramSchemaTypeImpl.setBaseTypeRef(schemaType.getRef());
/*  649 */     paramSchemaTypeImpl.setBaseDepth(((SchemaTypeImpl)schemaType).getBaseDepth() + 1);
/*  650 */     paramSchemaTypeImpl.setDerivationType(2);
/*  651 */     paramSchemaTypeImpl.setComplexTypeVariety(bool3);
/*  652 */     paramSchemaTypeImpl.setContentModel(schemaParticle3, schemaAttributeModelImpl, map2, map3, bool2);
/*  653 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*  654 */     paramSchemaTypeImpl.setWildcardSummary(wildcardResult1.typedWildcards, wildcardResult1.hasWildcards, wildcardResult2.typedWildcards, wildcardResult2.hasWildcards);
/*      */   }
/*      */   
/*      */   static void resolveScRestriction(SchemaTypeImpl paramSchemaTypeImpl, SimpleRestrictionType paramSimpleRestrictionType) {
/*      */     SchemaTypeImpl schemaTypeImpl1;
/*      */     SchemaAttributeModelImpl schemaAttributeModelImpl;
/*  660 */     SchemaTypeImpl schemaTypeImpl2 = null;
/*  661 */     StscState stscState = StscState.get();
/*  662 */     String str = paramSchemaTypeImpl.getTargetNamespace();
/*  663 */     boolean bool = (paramSchemaTypeImpl.getChameleonNamespace() != null) ? true : false;
/*  664 */     ArrayList arrayList = new ArrayList();
/*  665 */     if (paramSimpleRestrictionType.getSimpleType() != null) {
/*      */       
/*  667 */       LocalSimpleType localSimpleType = paramSimpleRestrictionType.getSimpleType();
/*  668 */       SchemaTypeImpl schemaTypeImpl = StscTranslator.translateAnonymousSimpleType((SimpleType)localSimpleType, str, bool, paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl);
/*      */ 
/*      */ 
/*      */       
/*  672 */       schemaTypeImpl2 = schemaTypeImpl;
/*      */     } 
/*  674 */     if (paramSimpleRestrictionType.getBase() == null) {
/*      */       
/*  676 */       stscState.error("A simpleContent restriction must define a base type", 28, (XmlObject)paramSimpleRestrictionType);
/*      */       
/*  678 */       schemaTypeImpl1 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*      */     else {
/*      */       
/*  682 */       if (paramSchemaTypeImpl.isRedefinition()) {
/*      */         
/*  684 */         schemaTypeImpl1 = stscState.findRedefinedGlobalType(paramSimpleRestrictionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl);
/*  685 */         if (schemaTypeImpl1 != null && !schemaTypeImpl1.getName().equals(paramSchemaTypeImpl.getName()))
/*      */         {
/*  687 */           stscState.error("src-redefine.5b", new Object[] { "<simpleType>", QNameHelper.pretty(schemaTypeImpl1.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramSimpleRestrictionType);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  697 */         schemaTypeImpl1 = stscState.findGlobalType(paramSimpleRestrictionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), str);
/*      */       } 
/*  699 */       if (schemaTypeImpl1 == null) {
/*      */         
/*  701 */         stscState.notFoundError(paramSimpleRestrictionType.getBase(), 0, (XmlObject)paramSimpleRestrictionType.xgetBase(), true);
/*      */         
/*  703 */         schemaTypeImpl1 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  708 */     StscResolver.resolveType(schemaTypeImpl1);
/*  709 */     if (schemaTypeImpl2 != null) {
/*  710 */       StscResolver.resolveType(schemaTypeImpl2);
/*      */     } else {
/*  712 */       schemaTypeImpl2 = schemaTypeImpl1;
/*      */     } 
/*  714 */     if (schemaTypeImpl1.isSimpleType()) {
/*      */ 
/*      */       
/*  717 */       stscState.recover("ct-props-correct.2", new Object[] { QNameHelper.pretty(schemaTypeImpl1.getName()) }, (XmlObject)paramSimpleRestrictionType);
/*      */ 
/*      */ 
/*      */       
/*  721 */       schemaTypeImpl1 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*  723 */     else if (schemaTypeImpl1.getContentType() != 2 && schemaTypeImpl2 == null) {
/*      */ 
/*      */ 
/*      */       
/*  727 */       schemaTypeImpl1 = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     } 
/*      */     
/*  730 */     if (schemaTypeImpl1 != null && schemaTypeImpl1.finalRestriction())
/*      */     {
/*  732 */       stscState.error("derivation-ok-restriction.1", new Object[] { QNameHelper.pretty(schemaTypeImpl1.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramSimpleRestrictionType.xgetBase());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  740 */     if (schemaTypeImpl1 == null) {
/*  741 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/*      */     } else {
/*  743 */       schemaAttributeModelImpl = new SchemaAttributeModelImpl(schemaTypeImpl1.getAttributeModel());
/*  744 */     }  translateAttributeModel((XmlObject)paramSimpleRestrictionType, str, bool, paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl, null, schemaAttributeModelImpl, schemaTypeImpl1, false, null);
/*      */ 
/*      */ 
/*      */     
/*  748 */     WildcardResult wildcardResult = summarizeAttrWildcards(schemaAttributeModelImpl);
/*      */ 
/*      */     
/*  751 */     Map map = buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  754 */     paramSchemaTypeImpl.setBaseTypeRef(schemaTypeImpl1.getRef());
/*  755 */     paramSchemaTypeImpl.setBaseDepth(schemaTypeImpl1.getBaseDepth() + 1);
/*  756 */     paramSchemaTypeImpl.setContentBasedOnTypeRef(schemaTypeImpl2.getRef());
/*  757 */     paramSchemaTypeImpl.setDerivationType(1);
/*  758 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*  759 */     paramSchemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResult.typedWildcards, wildcardResult.hasWildcards);
/*  760 */     paramSchemaTypeImpl.setComplexTypeVariety(2);
/*  761 */     paramSchemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, map, false);
/*  762 */     paramSchemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl2.getSimpleVariety());
/*  763 */     paramSchemaTypeImpl.setPrimitiveTypeRef((schemaTypeImpl2.getPrimitiveType() == null) ? null : schemaTypeImpl2.getPrimitiveType().getRef());
/*  764 */     switch (paramSchemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 3:
/*  767 */         paramSchemaTypeImpl.setListItemTypeRef(schemaTypeImpl2.getListItemType().getRef());
/*      */         break;
/*      */       
/*      */       case 2:
/*  771 */         paramSchemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl2.getUnionMemberTypes())));
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  776 */     StscSimpleTypeResolver.resolveFacets(paramSchemaTypeImpl, (XmlObject)paramSimpleRestrictionType, schemaTypeImpl2);
/*      */ 
/*      */     
/*  779 */     StscSimpleTypeResolver.resolveFundamentalFacets(paramSchemaTypeImpl);
/*      */   }
/*      */ 
/*      */   
/*      */   static void resolveScExtension(SchemaTypeImpl paramSchemaTypeImpl, SimpleExtensionType paramSimpleExtensionType) {
/*      */     SchemaTypeImpl schemaTypeImpl;
/*  785 */     StscState stscState = StscState.get();
/*  786 */     String str = paramSchemaTypeImpl.getTargetNamespace();
/*  787 */     boolean bool = (paramSchemaTypeImpl.getChameleonNamespace() != null) ? true : false;
/*  788 */     if (paramSimpleExtensionType.getBase() == null) {
/*      */       
/*  790 */       stscState.error("A simpleContent extension must define a base type", 28, (XmlObject)paramSimpleExtensionType);
/*      */       
/*  792 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*      */     else {
/*      */       
/*  796 */       if (paramSchemaTypeImpl.isRedefinition()) {
/*      */         
/*  798 */         schemaTypeImpl = stscState.findRedefinedGlobalType(paramSimpleExtensionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl);
/*  799 */         if (schemaTypeImpl != null && !schemaTypeImpl.getName().equals(paramSchemaTypeImpl.getName()))
/*      */         {
/*  801 */           stscState.error("src-redefine.5b", new Object[] { "<simpleType>", QNameHelper.pretty(schemaTypeImpl.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramSimpleExtensionType);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  811 */         schemaTypeImpl = stscState.findGlobalType(paramSimpleExtensionType.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), str);
/*      */       } 
/*  813 */       if (schemaTypeImpl == null) {
/*      */         
/*  815 */         stscState.notFoundError(paramSimpleExtensionType.getBase(), 0, (XmlObject)paramSimpleExtensionType.xgetBase(), true);
/*      */         
/*  817 */         schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  822 */     StscResolver.resolveType(schemaTypeImpl);
/*      */     
/*  824 */     if (!schemaTypeImpl.isSimpleType() && schemaTypeImpl.getContentType() != 2) {
/*      */ 
/*      */       
/*  827 */       stscState.error("src-ct.2", new Object[] { QNameHelper.pretty(schemaTypeImpl.getName()) }, (XmlObject)paramSimpleExtensionType);
/*      */ 
/*      */ 
/*      */       
/*  831 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     } 
/*      */     
/*  834 */     if (schemaTypeImpl != null && schemaTypeImpl.finalExtension())
/*      */     {
/*  836 */       stscState.error("cos-ct-extends.1.1", new Object[] { QNameHelper.pretty(schemaTypeImpl.getName()), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramSimpleExtensionType.xgetBase());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  842 */     resolveScExtensionPart2(paramSchemaTypeImpl, schemaTypeImpl, (ExtensionType)paramSimpleExtensionType, str, bool);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void resolveScExtensionPart2(SchemaTypeImpl paramSchemaTypeImpl, SchemaType paramSchemaType, ExtensionType paramExtensionType, String paramString, boolean paramBoolean) {
/*  849 */     ArrayList arrayList = new ArrayList();
/*      */     
/*  851 */     SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl(paramSchemaType.getAttributeModel());
/*  852 */     translateAttributeModel((XmlObject)paramExtensionType, paramString, paramBoolean, paramSchemaTypeImpl.getAttFormDefault(), arrayList, paramSchemaTypeImpl, null, schemaAttributeModelImpl, paramSchemaType, true, null);
/*      */ 
/*      */     
/*  855 */     WildcardResult wildcardResult = summarizeAttrWildcards(schemaAttributeModelImpl);
/*      */ 
/*      */     
/*  858 */     Map map = buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*      */ 
/*      */     
/*  861 */     paramSchemaTypeImpl.setBaseTypeRef(paramSchemaType.getRef());
/*  862 */     paramSchemaTypeImpl.setBaseDepth(((SchemaTypeImpl)paramSchemaType).getBaseDepth() + 1);
/*  863 */     paramSchemaTypeImpl.setContentBasedOnTypeRef(paramSchemaType.getRef());
/*  864 */     paramSchemaTypeImpl.setDerivationType(2);
/*  865 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*  866 */     paramSchemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, wildcardResult.typedWildcards, wildcardResult.hasWildcards);
/*  867 */     paramSchemaTypeImpl.setComplexTypeVariety(2);
/*  868 */     paramSchemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, null, map, false);
/*  869 */     paramSchemaTypeImpl.setSimpleTypeVariety(paramSchemaType.getSimpleVariety());
/*  870 */     paramSchemaTypeImpl.setPrimitiveTypeRef((paramSchemaType.getPrimitiveType() == null) ? null : paramSchemaType.getPrimitiveType().getRef());
/*  871 */     switch (paramSchemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 3:
/*  874 */         paramSchemaTypeImpl.setListItemTypeRef(paramSchemaType.getListItemType().getRef());
/*      */         break;
/*      */       
/*      */       case 2:
/*  878 */         paramSchemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(paramSchemaType.getUnionMemberTypes())));
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  883 */     StscSimpleTypeResolver.resolveFacets(paramSchemaTypeImpl, null, (SchemaTypeImpl)paramSchemaType);
/*      */ 
/*      */     
/*  886 */     StscSimpleTypeResolver.resolveFundamentalFacets(paramSchemaTypeImpl);
/*      */   }
/*      */   
/*      */   static class WildcardResult { QNameSet typedWildcards;
/*      */     boolean hasWildcards;
/*      */     
/*      */     WildcardResult(QNameSet param1QNameSet, boolean param1Boolean) {
/*  893 */       this.typedWildcards = param1QNameSet;
/*  894 */       this.hasWildcards = param1Boolean;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static WildcardResult summarizeAttrWildcards(SchemaAttributeModel paramSchemaAttributeModel) {
/*  902 */     if (paramSchemaAttributeModel.getWildcardProcess() == 0)
/*  903 */       return new WildcardResult(QNameSet.EMPTY, false); 
/*  904 */     if (paramSchemaAttributeModel.getWildcardProcess() == 3)
/*  905 */       return new WildcardResult(QNameSet.EMPTY, true); 
/*  906 */     return new WildcardResult(paramSchemaAttributeModel.getWildcardSet(), true);
/*      */   } static WildcardResult summarizeEltWildcards(SchemaParticle paramSchemaParticle) {
/*      */     QNameSetBuilder qNameSetBuilder;
/*      */     boolean bool;
/*      */     byte b;
/*  911 */     if (paramSchemaParticle == null)
/*      */     {
/*  913 */       return new WildcardResult(QNameSet.EMPTY, false);
/*      */     }
/*      */     
/*  916 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*  921 */         qNameSetBuilder = new QNameSetBuilder();
/*  922 */         bool = false;
/*  923 */         for (b = 0; b < paramSchemaParticle.countOfParticleChild(); b++) {
/*      */           
/*  925 */           WildcardResult wildcardResult = summarizeEltWildcards(paramSchemaParticle.getParticleChild(b));
/*  926 */           qNameSetBuilder.addAll((QNameSetSpecification)wildcardResult.typedWildcards);
/*  927 */           bool |= wildcardResult.hasWildcards;
/*      */         } 
/*  929 */         return new WildcardResult(qNameSetBuilder.toQNameSet(), bool);
/*      */       case 5:
/*  931 */         return new WildcardResult((paramSchemaParticle.getWildcardProcess() == 3) ? QNameSet.EMPTY : paramSchemaParticle.getWildcardSet(), true);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  937 */     return new WildcardResult(QNameSet.EMPTY, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void translateAttributeModel(XmlObject paramXmlObject, String paramString1, boolean paramBoolean1, String paramString2, List paramList, SchemaType paramSchemaType1, Set paramSet, SchemaAttributeModelImpl paramSchemaAttributeModelImpl, SchemaType paramSchemaType2, boolean paramBoolean2, SchemaAttributeGroupImpl paramSchemaAttributeGroupImpl) {
/*  948 */     StscState stscState = StscState.get();
/*  949 */     if (paramSet == null)
/*  950 */       paramSet = new HashSet(); 
/*  951 */     boolean bool1 = false;
/*  952 */     boolean bool2 = false;
/*  953 */     SchemaAttributeModel schemaAttributeModel = null;
/*  954 */     if (paramSchemaType2 != null) {
/*  955 */       schemaAttributeModel = paramSchemaType2.getAttributeModel();
/*      */     }
/*  957 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/*      */     boolean bool;
/*  959 */     for (bool = xmlCursor.toFirstChild(); bool; bool = xmlCursor.toNextSibling()) {
/*      */       Attribute attribute; Wildcard wildcard; AttributeGroupRef attributeGroupRef; SchemaLocalAttributeImpl schemaLocalAttributeImpl; NamespaceList namespaceList; b b; String str1; SchemaAttributeGroupImpl schemaAttributeGroupImpl1; QNameSet qNameSet; String str2; int i; SchemaAttributeGroupImpl schemaAttributeGroupImpl2;
/*  961 */       switch (translateAttributeCode(xmlCursor.getName())) {
/*      */ 
/*      */         
/*      */         case 100:
/*  965 */           attribute = (Attribute)xmlCursor.getObject();
/*      */           
/*  967 */           schemaLocalAttributeImpl = StscTranslator.translateAttribute(attribute, paramString1, paramString2, paramBoolean1, paramList, paramSchemaType1, schemaAttributeModel, true);
/*  968 */           if (schemaLocalAttributeImpl == null) {
/*      */             break;
/*      */           }
/*  971 */           if (paramSet.contains(schemaLocalAttributeImpl.getName())) {
/*      */             
/*  973 */             stscState.error("ct-props-correct.4", new Object[] { QNameHelper.pretty(schemaLocalAttributeImpl.getName()), QNameHelper.pretty(paramSchemaType1.getName()) }, (XmlObject)attribute.xgetName());
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */           
/*  979 */           paramSet.add(schemaLocalAttributeImpl.getName());
/*      */           
/*  981 */           if (schemaAttributeModel != null) {
/*      */             
/*  983 */             SchemaLocalAttribute schemaLocalAttribute = schemaAttributeModel.getAttribute(schemaLocalAttributeImpl.getName());
/*  984 */             if (schemaLocalAttribute == null) {
/*      */               
/*  986 */               if (!paramBoolean2)
/*      */               {
/*  988 */                 if (!schemaAttributeModel.getWildcardSet().contains(schemaLocalAttributeImpl.getName())) {
/*  989 */                   stscState.error("derivation-ok-restriction.2.2", new Object[] { QNameHelper.pretty(schemaLocalAttributeImpl.getName()), QNameHelper.pretty(paramSchemaType1.getName()) }, (XmlObject)attribute);
/*      */                 
/*      */                 }
/*      */               
/*      */               }
/*      */             }
/*  995 */             else if (paramBoolean2) {
/*      */ 
/*      */               
/*  998 */               if (schemaLocalAttributeImpl.getUse() == 1) {
/*  999 */                 stscState.error("An extension cannot prohibit an attribute from the base type; use restriction instead.", 37, (XmlObject)attribute.xgetUse());
/*      */               
/*      */               }
/*      */             }
/* 1003 */             else if (schemaLocalAttributeImpl.getUse() != 3) {
/*      */               
/* 1005 */               if (schemaLocalAttribute.getUse() == 3) {
/* 1006 */                 stscState.error("derivation-ok-restriction.2.1.1", new Object[] { QNameHelper.pretty(schemaLocalAttributeImpl.getName()), QNameHelper.pretty(paramSchemaType1.getName()) }, (XmlObject)attribute);
/*      */               }
/*      */               
/* 1009 */               if (schemaLocalAttributeImpl.getUse() == 1) {
/* 1010 */                 paramSchemaAttributeModelImpl.removeProhibitedAttribute(schemaLocalAttributeImpl.getName());
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1016 */           if (schemaLocalAttributeImpl.getUse() != 1) {
/*      */             
/* 1018 */             paramSchemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*      */           else {
/*      */ 
/*      */ 
/*      */             
/* 1027 */             SchemaType schemaType = schemaLocalAttributeImpl.getType();
/* 1028 */             if (paramList != null && paramList.contains(schemaType))
/*      */             {
/* 1030 */               paramList.remove(schemaType);
/*      */             }
/*      */           } 
/*      */           
/* 1034 */           if (schemaLocalAttributeImpl.getDefaultText() != null && !schemaLocalAttributeImpl.isFixed())
/*      */           {
/* 1036 */             if (schemaLocalAttributeImpl.getUse() != 2) {
/* 1037 */               stscState.error("src-attribute.2", new Object[] { QNameHelper.pretty(schemaLocalAttributeImpl.getName()) }, (XmlObject)attribute);
/*      */             }
/*      */           }
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 102:
/* 1046 */           wildcard = (Wildcard)xmlCursor.getObject();
/* 1047 */           if (bool1) {
/*      */ 
/*      */             
/* 1050 */             stscState.error("Only one attribute wildcard allowed", 38, (XmlObject)wildcard);
/*      */             break;
/*      */           } 
/* 1053 */           bool1 = true;
/* 1054 */           namespaceList = wildcard.xgetNamespace();
/*      */           
/* 1056 */           if (namespaceList == null) {
/* 1057 */             str1 = "##any";
/*      */           } else {
/* 1059 */             str1 = namespaceList.getStringValue();
/* 1060 */           }  qNameSet = QNameSet.forWildcardNamespaceString(str1, paramString1);
/*      */           
/* 1062 */           if (schemaAttributeModel != null && !paramBoolean2) {
/*      */             
/* 1064 */             if (schemaAttributeModel.getWildcardSet() == null) {
/*      */               
/* 1066 */               stscState.error("derivation-ok-restriction.4.1", (Object[])null, (XmlObject)wildcard);
/*      */               break;
/*      */             } 
/* 1069 */             if (!schemaAttributeModel.getWildcardSet().containsAll((QNameSetSpecification)qNameSet)) {
/*      */               
/* 1071 */               stscState.error("derivation-ok-restriction.4.2", new Object[] { str1 }, (XmlObject)wildcard);
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */           
/* 1077 */           i = translateWildcardProcess(wildcard.xgetProcessContents());
/* 1078 */           if (paramSchemaAttributeModelImpl.getWildcardProcess() == 0) {
/*      */             
/* 1080 */             paramSchemaAttributeModelImpl.setWildcardSet(qNameSet);
/* 1081 */             paramSchemaAttributeModelImpl.setWildcardProcess(i);
/*      */             
/*      */             break;
/*      */           } 
/* 1085 */           if (paramBoolean2) {
/*      */             
/* 1087 */             paramSchemaAttributeModelImpl.setWildcardSet(qNameSet.union((QNameSetSpecification)paramSchemaAttributeModelImpl.getWildcardSet()));
/* 1088 */             paramSchemaAttributeModelImpl.setWildcardProcess(i);
/*      */             
/*      */             break;
/*      */           } 
/* 1092 */           paramSchemaAttributeModelImpl.setWildcardSet(qNameSet.intersect((QNameSetSpecification)paramSchemaAttributeModelImpl.getWildcardSet()));
/*      */           break;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 101:
/* 1100 */           attributeGroupRef = (AttributeGroupRef)xmlCursor.getObject();
/* 1101 */           b = attributeGroupRef.getRef();
/* 1102 */           if (b == null) {
/*      */ 
/*      */             
/* 1105 */             stscState.error("Attribute group reference must have a ref attribute", 39, (XmlObject)attributeGroupRef);
/*      */             
/*      */             break;
/*      */           } 
/* 1109 */           if (paramSchemaAttributeGroupImpl != null) {
/*      */             
/* 1111 */             schemaAttributeGroupImpl1 = stscState.findRedefinedAttributeGroup(b, paramBoolean1 ? paramString1 : null, paramSchemaAttributeGroupImpl);
/* 1112 */             if (schemaAttributeGroupImpl1 != null && paramSchemaAttributeGroupImpl.getName().equals(schemaAttributeGroupImpl1.getName()))
/*      */             {
/*      */               
/* 1115 */               if (bool2) {
/* 1116 */                 stscState.error("src-redefine.7.1", new Object[] { QNameHelper.pretty(paramSchemaAttributeGroupImpl.getName()) }, (XmlObject)attributeGroupRef);
/*      */               }
/* 1118 */               bool2 = true;
/*      */             }
/*      */           
/*      */           } else {
/*      */             
/* 1123 */             schemaAttributeGroupImpl1 = stscState.findAttributeGroup(b, paramBoolean1 ? paramString1 : null, paramString1);
/*      */           } 
/* 1125 */           if (schemaAttributeGroupImpl1 == null) {
/*      */             
/* 1127 */             stscState.notFoundError(b, 4, (XmlObject)attributeGroupRef.xgetRef(), true);
/*      */             break;
/*      */           } 
/* 1130 */           if (stscState.isProcessing(schemaAttributeGroupImpl1)) {
/*      */             
/* 1132 */             stscState.error("src-attribute_group.3", new Object[] { QNameHelper.pretty(schemaAttributeGroupImpl1.getName()) }, schemaAttributeGroupImpl1.getParseObject());
/*      */             
/*      */             break;
/*      */           } 
/* 1136 */           str2 = paramString1;
/* 1137 */           if (schemaAttributeGroupImpl1.getTargetNamespace() != null) {
/*      */             
/* 1139 */             str2 = schemaAttributeGroupImpl1.getTargetNamespace();
/* 1140 */             paramBoolean1 = (schemaAttributeGroupImpl1.getChameleonNamespace() != null);
/*      */           } 
/*      */           
/* 1143 */           stscState.startProcessing(schemaAttributeGroupImpl1);
/* 1144 */           schemaAttributeGroupImpl2 = null;
/* 1145 */           if (schemaAttributeGroupImpl1.isRedefinition())
/* 1146 */             schemaAttributeGroupImpl2 = schemaAttributeGroupImpl1; 
/* 1147 */           translateAttributeModel(schemaAttributeGroupImpl1.getParseObject(), str2, paramBoolean1, schemaAttributeGroupImpl1.getFormDefault(), paramList, paramSchemaType1, paramSet, paramSchemaAttributeModelImpl, paramSchemaType2, paramBoolean2, schemaAttributeGroupImpl2);
/*      */ 
/*      */ 
/*      */           
/* 1151 */           stscState.finishProcessing(schemaAttributeGroupImpl1);
/*      */           break;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     } 
/* 1162 */     if (!paramBoolean2 && !bool1) {
/*      */       
/* 1164 */       paramSchemaAttributeModelImpl.setWildcardSet(null);
/* 1165 */       paramSchemaAttributeModelImpl.setWildcardProcess(0);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaParticle extendContentModel(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, XmlObject paramXmlObject) {
/* 1174 */     if (paramSchemaParticle2 == null) {
/* 1175 */       return paramSchemaParticle1;
/*      */     }
/*      */     
/* 1178 */     if (paramSchemaParticle1 == null) {
/* 1179 */       return paramSchemaParticle2;
/*      */     }
/*      */     
/* 1182 */     SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
/* 1183 */     schemaParticleImpl.setParticleType(3);
/*      */     
/* 1185 */     ArrayList arrayList = new ArrayList();
/* 1186 */     addMinusPointlessParticles(arrayList, paramSchemaParticle1, 3);
/* 1187 */     addMinusPointlessParticles(arrayList, paramSchemaParticle2, 3);
/* 1188 */     schemaParticleImpl.setMinOccurs(BigInteger.ONE);
/* 1189 */     schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
/* 1190 */     schemaParticleImpl.setParticleChildren((SchemaParticle[])arrayList.toArray((Object[])new SchemaParticle[arrayList.size()]));
/*      */ 
/*      */     
/* 1193 */     return filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, paramXmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   static BigInteger extractMinOccurs(XmlNonNegativeInteger paramXmlNonNegativeInteger) {
/* 1198 */     if (paramXmlNonNegativeInteger == null)
/* 1199 */       return BigInteger.ONE; 
/* 1200 */     BigInteger bigInteger = paramXmlNonNegativeInteger.getBigIntegerValue();
/* 1201 */     if (bigInteger == null)
/* 1202 */       return BigInteger.ONE; 
/* 1203 */     return bigInteger;
/*      */   }
/*      */ 
/*      */   
/*      */   static BigInteger extractMaxOccurs(AllNNI paramAllNNI) {
/* 1208 */     if (paramAllNNI == null) {
/* 1209 */       return BigInteger.ONE;
/*      */     }
/* 1211 */     if (paramAllNNI.instanceType().getPrimitiveType().getBuiltinTypeCode() == 11) {
/* 1212 */       return ((XmlInteger)paramAllNNI).getBigIntegerValue();
/*      */     }
/* 1214 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static class RedefinitionForGroup
/*      */   {
/*      */     private SchemaModelGroupImpl group;
/*      */     private boolean seenRedefinition = false;
/*      */     
/*      */     public RedefinitionForGroup(SchemaModelGroupImpl param1SchemaModelGroupImpl) {
/* 1224 */       this.group = param1SchemaModelGroupImpl;
/*      */     }
/*      */ 
/*      */     
/*      */     public SchemaModelGroupImpl getGroup() {
/* 1229 */       return this.group;
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean isSeenRedefinition() {
/* 1234 */       return this.seenRedefinition;
/*      */     }
/*      */ 
/*      */     
/*      */     public void setSeenRedefinition(boolean param1Boolean) {
/* 1239 */       this.seenRedefinition = param1Boolean;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaParticle translateContentModel(SchemaType paramSchemaType, XmlObject paramXmlObject, String paramString1, boolean paramBoolean1, String paramString2, String paramString3, int paramInt, List paramList, Map paramMap, boolean paramBoolean2, RedefinitionForGroup paramRedefinitionForGroup) {
/*      */     Group group;
/*      */     BigInteger bigInteger1, bigInteger2;
/*      */     SchemaParticleImpl schemaParticleImpl;
/* 1250 */     if (paramXmlObject == null || paramInt == 0) {
/* 1251 */       return null;
/*      */     }
/* 1253 */     StscState stscState = StscState.get();
/*      */ 
/*      */ 
/*      */     
/* 1257 */     assert paramInt != 0;
/*      */     
/* 1259 */     boolean bool = false;
/*      */ 
/*      */     
/* 1262 */     SchemaModelGroupImpl schemaModelGroupImpl = null;
/*      */ 
/*      */ 
/*      */     
/* 1266 */     if (paramInt == 4) {
/*      */       
/* 1268 */       if (!paramBoolean2) {
/* 1269 */         stscState.error("Must be a sequence, choice or all here", 32, paramXmlObject);
/*      */       }
/*      */ 
/*      */       
/* 1273 */       LocalElement localElement = (LocalElement)paramXmlObject;
/* 1274 */       schemaParticleImpl = StscTranslator.translateElement((Element)localElement, paramString1, paramBoolean1, paramString2, paramString3, paramList, paramSchemaType);
/*      */       
/* 1276 */       if (schemaParticleImpl == null)
/* 1277 */         return null; 
/* 1278 */       bigInteger1 = extractMinOccurs(localElement.xgetMinOccurs());
/* 1279 */       bigInteger2 = extractMaxOccurs(localElement.xgetMaxOccurs());
/*      */       
/* 1281 */       SchemaType schemaType = (SchemaType)paramMap.get(schemaParticleImpl.getName());
/* 1282 */       if (schemaType == null)
/*      */       {
/* 1284 */         paramMap.put(schemaParticleImpl.getName(), schemaParticleImpl.getType());
/*      */       }
/* 1286 */       else if (!schemaParticleImpl.getType().equals(schemaType))
/*      */       {
/* 1288 */         stscState.error("cos-element-consistent", new Object[] { QNameHelper.pretty(schemaParticleImpl.getName()) }, paramXmlObject);
/* 1289 */         return null;
/*      */       }
/*      */     
/* 1292 */     } else if (paramInt == 5) {
/*      */       QNameSet qNameSet;
/* 1294 */       if (!paramBoolean2)
/* 1295 */         stscState.error("Must be a sequence, choice or all here", 32, paramXmlObject); 
/* 1296 */       AnyDocument.Any any = (AnyDocument.Any)paramXmlObject;
/* 1297 */       schemaParticleImpl = new SchemaParticleImpl();
/* 1298 */       schemaParticleImpl.setParticleType(5);
/*      */       
/* 1300 */       NamespaceList namespaceList = any.xgetNamespace();
/* 1301 */       if (namespaceList == null) {
/* 1302 */         qNameSet = QNameSet.ALL;
/*      */       } else {
/* 1304 */         qNameSet = QNameSet.forWildcardNamespaceString(namespaceList.getStringValue(), paramString1);
/* 1305 */       }  schemaParticleImpl.setWildcardSet(qNameSet);
/* 1306 */       schemaParticleImpl.setWildcardProcess(translateWildcardProcess(any.xgetProcessContents()));
/* 1307 */       bigInteger1 = extractMinOccurs(any.xgetMinOccurs());
/* 1308 */       bigInteger2 = extractMaxOccurs(any.xgetMaxOccurs());
/*      */     }
/*      */     else {
/*      */       
/* 1312 */       Group group1 = (Group)paramXmlObject;
/* 1313 */       schemaParticleImpl = new SchemaParticleImpl();
/*      */ 
/*      */       
/* 1316 */       bigInteger1 = extractMinOccurs(group1.xgetMinOccurs());
/* 1317 */       bigInteger2 = extractMaxOccurs(group1.xgetMaxOccurs());
/*      */       
/* 1319 */       if (paramInt == 100) {
/*      */         
/* 1321 */         b b = group1.getRef();
/* 1322 */         if (b == null) {
/*      */ 
/*      */           
/* 1325 */           stscState.error("Group reference must have a ref attribute", 33, paramXmlObject);
/* 1326 */           return null;
/*      */         } 
/*      */         
/* 1329 */         if (paramRedefinitionForGroup != null) {
/*      */           
/* 1331 */           schemaModelGroupImpl = stscState.findRedefinedModelGroup(b, paramBoolean1 ? paramString1 : null, paramRedefinitionForGroup.getGroup());
/* 1332 */           if (schemaModelGroupImpl != null && schemaModelGroupImpl.getName().equals(paramRedefinitionForGroup.getGroup().getName()))
/*      */           {
/* 1334 */             if (paramRedefinitionForGroup.isSeenRedefinition()) {
/* 1335 */               stscState.error("src-redefine.6.1.1", new Object[] { QNameHelper.pretty(schemaModelGroupImpl.getName()) }, paramXmlObject);
/*      */             }
/* 1337 */             if (!BigInteger.ONE.equals(bigInteger2) || !BigInteger.ONE.equals(bigInteger1)) {
/* 1338 */               stscState.error("src-redefine.6.1.2", new Object[] { QNameHelper.pretty(schemaModelGroupImpl.getName()) }, paramXmlObject);
/*      */             }
/* 1340 */             paramRedefinitionForGroup.setSeenRedefinition(true);
/*      */           }
/*      */         
/*      */         } else {
/*      */           
/* 1345 */           schemaModelGroupImpl = stscState.findModelGroup(b, paramBoolean1 ? paramString1 : null, paramString1);
/*      */         } 
/* 1347 */         if (schemaModelGroupImpl == null) {
/*      */           
/* 1349 */           stscState.notFoundError(b, 6, (XmlObject)((Group)paramXmlObject).xgetRef(), true);
/* 1350 */           return null;
/*      */         } 
/* 1352 */         if (stscState.isProcessing(schemaModelGroupImpl)) {
/*      */           
/* 1354 */           stscState.error("mg-props-correct.2", new Object[] { QNameHelper.pretty(schemaModelGroupImpl.getName()) }, schemaModelGroupImpl.getParseObject());
/*      */           
/* 1356 */           return null;
/*      */         } 
/*      */ 
/*      */         
/* 1360 */         XmlCursor xmlCursor = schemaModelGroupImpl.getParseObject().newCursor(); boolean bool1;
/* 1361 */         for (bool1 = xmlCursor.toFirstChild(); bool1; bool1 = xmlCursor.toNextSibling()) {
/*      */           
/* 1363 */           paramInt = translateParticleCode(xmlCursor.getName());
/* 1364 */           if (paramInt != 0) {
/*      */             
/* 1366 */             group = group1 = (Group)xmlCursor.getObject();
/*      */             break;
/*      */           } 
/*      */         } 
/* 1370 */         if (paramInt == 0) {
/*      */ 
/*      */           
/* 1373 */           stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImpl.getName()) + " is empty", 32, schemaModelGroupImpl.getParseObject());
/* 1374 */           return null;
/*      */         } 
/* 1376 */         if (paramInt != 1 && paramInt != 3 && paramInt != 2)
/*      */         {
/*      */           
/* 1379 */           stscState.error("Model group " + QNameHelper.pretty(schemaModelGroupImpl.getName()) + " is not a sequence, all, or choice", 32, schemaModelGroupImpl.getParseObject());
/*      */         }
/*      */         
/* 1382 */         String str = schemaModelGroupImpl.getTargetNamespace();
/* 1383 */         if (str != null)
/* 1384 */           paramString1 = str; 
/* 1385 */         paramString2 = schemaModelGroupImpl.getElemFormDefault();
/* 1386 */         paramString3 = schemaModelGroupImpl.getAttFormDefault();
/* 1387 */         paramBoolean1 = (schemaModelGroupImpl.getChameleonNamespace() != null);
/*      */       } 
/*      */       
/* 1390 */       switch (paramInt) {
/*      */         
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/* 1395 */           schemaParticleImpl.setParticleType(paramInt);
/* 1396 */           bool = true;
/*      */           break;
/*      */         
/*      */         default:
/*      */           assert false;
/* 1401 */           throw new IllegalStateException();
/*      */       } 
/*      */     
/*      */     } 
/* 1405 */     if (bigInteger2 != null && bigInteger1.compareTo(bigInteger2) > 0) {
/*      */       
/* 1407 */       stscState.error("p-props-correct.2.1", (Object[])null, (XmlObject)group);
/* 1408 */       bigInteger2 = bigInteger1;
/*      */     } 
/*      */     
/* 1411 */     if (bigInteger2 != null && bigInteger2.compareTo(BigInteger.ONE) < 0) {
/*      */       
/* 1413 */       stscState.warning("p-props-correct.2.2", (Object[])null, (XmlObject)group);
/*      */ 
/*      */       
/* 1416 */       paramList.remove(schemaParticleImpl.getType());
/* 1417 */       return null;
/*      */     } 
/*      */     
/* 1420 */     schemaParticleImpl.setMinOccurs(bigInteger1);
/* 1421 */     schemaParticleImpl.setMaxOccurs(bigInteger2);
/*      */     
/* 1423 */     if (schemaModelGroupImpl != null) {
/*      */       
/* 1425 */       stscState.startProcessing(schemaModelGroupImpl);
/* 1426 */       paramRedefinitionForGroup = null;
/* 1427 */       if (schemaModelGroupImpl.isRedefinition()) {
/* 1428 */         paramRedefinitionForGroup = new RedefinitionForGroup(schemaModelGroupImpl);
/*      */       }
/*      */     } 
/* 1431 */     if (bool) {
/*      */       
/* 1433 */       XmlCursor xmlCursor = group.newCursor();
/* 1434 */       ArrayList arrayList = new ArrayList(); boolean bool1;
/* 1435 */       for (bool1 = xmlCursor.toFirstChild(); bool1; bool1 = xmlCursor.toNextSibling()) {
/*      */         
/* 1437 */         int i = translateParticleCode(xmlCursor.getName());
/* 1438 */         if (i != 0)
/*      */         {
/* 1440 */           addMinusPointlessParticles(arrayList, translateContentModel(paramSchemaType, xmlCursor.getObject(), paramString1, paramBoolean1, paramString2, paramString3, i, paramList, paramMap, true, paramRedefinitionForGroup), schemaParticleImpl.getParticleType());
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1447 */       schemaParticleImpl.setParticleChildren((SchemaParticle[])arrayList.toArray((Object[])new SchemaParticle[arrayList.size()]));
/*      */       
/* 1449 */       xmlCursor.dispose();
/*      */     } 
/*      */ 
/*      */     
/* 1453 */     SchemaParticle schemaParticle = filterPointlessParticlesAndVerifyAllParticles(schemaParticleImpl, (XmlObject)group);
/*      */     
/* 1455 */     if (schemaModelGroupImpl != null)
/*      */     {
/* 1457 */       stscState.finishProcessing(schemaModelGroupImpl);
/*      */     }
/*      */     
/* 1460 */     return schemaParticle;
/*      */   }
/*      */ 
/*      */   
/*      */   static int translateWildcardProcess(Wildcard.ProcessContents paramProcessContents) {
/* 1465 */     if (paramProcessContents == null) {
/* 1466 */       return 1;
/*      */     }
/* 1468 */     String str = paramProcessContents.getStringValue();
/*      */     
/* 1470 */     if ("lax".equals(str)) {
/* 1471 */       return 2;
/*      */     }
/* 1473 */     if ("skip".equals(str)) {
/* 1474 */       return 3;
/*      */     }
/* 1476 */     return 1;
/*      */   }
/*      */ 
/*      */   
/*      */   static SchemaParticle filterPointlessParticlesAndVerifyAllParticles(SchemaParticle paramSchemaParticle, XmlObject paramXmlObject) {
/* 1481 */     if (paramSchemaParticle.getMaxOccurs() != null && paramSchemaParticle.getMaxOccurs().signum() == 0) {
/* 1482 */       return null;
/*      */     }
/* 1484 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 1:
/*      */       case 3:
/* 1488 */         if ((paramSchemaParticle.getParticleChildren()).length == 0)
/* 1489 */           return null; 
/* 1490 */         if (paramSchemaParticle.isSingleton() && paramSchemaParticle.countOfParticleChild() == 1) {
/* 1491 */           return paramSchemaParticle.getParticleChild(0);
/*      */         }
/*      */         break;
/*      */       case 2:
/* 1495 */         if ((paramSchemaParticle.getParticleChildren()).length == 0 && paramSchemaParticle.getMinOccurs().compareTo(BigInteger.ZERO) == 0)
/*      */         {
/* 1497 */           return null; } 
/* 1498 */         if (paramSchemaParticle.isSingleton() && paramSchemaParticle.countOfParticleChild() == 1) {
/* 1499 */           return paramSchemaParticle.getParticleChild(0);
/*      */         }
/*      */         break;
/*      */       case 4:
/*      */       case 5:
/* 1504 */         return paramSchemaParticle;
/*      */       
/*      */       default:
/*      */         assert false;
/* 1508 */         throw new IllegalStateException();
/*      */     } 
/*      */     
/* 1511 */     boolean bool = (paramSchemaParticle.getParticleType() == 1) ? true : false;
/*      */     
/* 1513 */     if (bool)
/*      */     {
/*      */       
/* 1516 */       if (paramSchemaParticle.getMaxOccurs() == null || paramSchemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)
/*      */       {
/*      */ 
/*      */         
/* 1520 */         StscState.get().error("cos-all-limited.1.2a", (Object[])null, paramXmlObject);
/*      */       }
/*      */     }
/*      */     
/* 1524 */     for (byte b = 0; b < paramSchemaParticle.countOfParticleChild(); b++) {
/*      */       
/* 1526 */       SchemaParticle schemaParticle = paramSchemaParticle.getParticleChild(b);
/* 1527 */       if (schemaParticle.getParticleType() == 1) {
/*      */ 
/*      */ 
/*      */         
/* 1531 */         StscState.get().error("cos-all-limited.1.2b", (Object[])null, paramXmlObject);
/*      */       }
/* 1533 */       else if (bool && (schemaParticle.getParticleType() != 4 || schemaParticle.getMaxOccurs() == null || schemaParticle.getMaxOccurs().compareTo(BigInteger.ONE) > 0)) {
/*      */ 
/*      */ 
/*      */         
/* 1537 */         StscState.get().error("cos-all-limited.2", (Object[])null, paramXmlObject);
/*      */       } 
/*      */     } 
/*      */     
/* 1541 */     return paramSchemaParticle;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void addMinusPointlessParticles(List paramList, SchemaParticle paramSchemaParticle, int paramInt) {
/* 1547 */     if (paramSchemaParticle == null) {
/*      */       return;
/*      */     }
/* 1550 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 3:
/* 1553 */         if (paramInt == 3 && paramSchemaParticle.isSingleton()) {
/*      */ 
/*      */           
/* 1556 */           paramList.addAll(Arrays.asList(paramSchemaParticle.getParticleChildren()));
/*      */           return;
/*      */         } 
/*      */         break;
/*      */       
/*      */       case 2:
/* 1562 */         if (paramInt == 2 && paramSchemaParticle.isSingleton()) {
/*      */ 
/*      */           
/* 1565 */           paramList.addAll(Arrays.asList(paramSchemaParticle.getParticleChildren()));
/*      */           return;
/*      */         } 
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1573 */     paramList.add(paramSchemaParticle);
/*      */   }
/*      */ 
/*      */   
/*      */   static Map buildAttributePropertyModelByQName(SchemaAttributeModel paramSchemaAttributeModel, SchemaType paramSchemaType) {
/* 1578 */     LinkedHashMap linkedHashMap = new LinkedHashMap();
/* 1579 */     SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = paramSchemaAttributeModel.getAttributes();
/*      */     
/* 1581 */     for (byte b = 0; b < arrayOfSchemaLocalAttribute.length; b++) {
/* 1582 */       linkedHashMap.put(arrayOfSchemaLocalAttribute[b].getName(), buildUseProperty((SchemaField)arrayOfSchemaLocalAttribute[b], paramSchemaType));
/*      */     }
/* 1584 */     return linkedHashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   static Map buildContentPropertyModelByQName(SchemaParticle paramSchemaParticle, SchemaType paramSchemaType) {
/* 1589 */     if (paramSchemaParticle == null) {
/* 1590 */       return Collections.EMPTY_MAP;
/*      */     }
/* 1592 */     boolean bool = false;
/* 1593 */     Map map = null;
/*      */     
/* 1595 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 1:
/*      */       case 3:
/* 1599 */         bool = true;
/*      */         break;
/*      */       case 2:
/* 1602 */         bool = false;
/*      */         break;
/*      */       case 4:
/* 1605 */         map = buildElementPropertyModel((SchemaLocalElement)paramSchemaParticle, paramSchemaType);
/*      */         break;
/*      */       case 5:
/* 1608 */         map = Collections.EMPTY_MAP;
/*      */         break;
/*      */       default:
/*      */         assert false;
/* 1612 */         throw new IllegalStateException();
/*      */     } 
/*      */     
/* 1615 */     if (map == null) {
/*      */ 
/*      */       
/* 1618 */       map = new LinkedHashMap();
/* 1619 */       SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/*      */       
/* 1621 */       for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/*      */ 
/*      */         
/* 1624 */         Map map1 = buildContentPropertyModelByQName(arrayOfSchemaParticle[b], paramSchemaType);
/*      */         
/* 1626 */         for (SchemaProperty schemaProperty : map1.values()) {
/*      */ 
/*      */           
/* 1629 */           SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)map.get(schemaProperty.getName());
/* 1630 */           if (schemaPropertyImpl == null) {
/*      */             
/* 1632 */             if (!bool)
/* 1633 */               ((SchemaPropertyImpl)schemaProperty).setMinOccurs(BigInteger.ZERO); 
/* 1634 */             map.put(schemaProperty.getName(), schemaProperty);
/*      */             
/*      */             continue;
/*      */           } 
/* 1638 */           assert schemaPropertyImpl.getType().equals(schemaProperty.getType());
/*      */           
/* 1640 */           mergeProperties(schemaPropertyImpl, schemaProperty, bool);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1645 */       BigInteger bigInteger1 = paramSchemaParticle.getMinOccurs();
/* 1646 */       BigInteger bigInteger2 = paramSchemaParticle.getMaxOccurs();
/*      */       
/* 1648 */       for (SchemaProperty schemaProperty : map.values()) {
/*      */ 
/*      */         
/* 1651 */         BigInteger bigInteger3 = schemaProperty.getMinOccurs();
/* 1652 */         BigInteger bigInteger4 = schemaProperty.getMaxOccurs();
/*      */         
/* 1654 */         bigInteger3 = bigInteger3.multiply(bigInteger1);
/* 1655 */         if (bigInteger2 != null && bigInteger2.equals(BigInteger.ZERO)) {
/* 1656 */           bigInteger4 = BigInteger.ZERO;
/* 1657 */         } else if (bigInteger4 != null && !bigInteger4.equals(BigInteger.ZERO)) {
/* 1658 */           bigInteger4 = (bigInteger2 == null) ? null : bigInteger4.multiply(bigInteger2);
/*      */         } 
/* 1660 */         ((SchemaPropertyImpl)schemaProperty).setMinOccurs(bigInteger3);
/* 1661 */         ((SchemaPropertyImpl)schemaProperty).setMaxOccurs(bigInteger4);
/*      */       } 
/*      */     } 
/*      */     
/* 1665 */     return map;
/*      */   }
/*      */ 
/*      */   
/*      */   static Map buildElementPropertyModel(SchemaLocalElement paramSchemaLocalElement, SchemaType paramSchemaType) {
/* 1670 */     HashMap hashMap = new HashMap(1);
/*      */     
/* 1672 */     SchemaProperty schemaProperty = buildUseProperty((SchemaField)paramSchemaLocalElement, paramSchemaType);
/* 1673 */     hashMap.put(schemaProperty.getName(), schemaProperty);
/* 1674 */     return hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   static SchemaProperty buildUseProperty(SchemaField paramSchemaField, SchemaType paramSchemaType) {
/* 1679 */     SchemaPropertyImpl schemaPropertyImpl = new SchemaPropertyImpl();
/* 1680 */     schemaPropertyImpl.setName(paramSchemaField.getName());
/* 1681 */     schemaPropertyImpl.setContainerTypeRef(paramSchemaType.getRef());
/* 1682 */     schemaPropertyImpl.setTypeRef(paramSchemaField.getType().getRef());
/* 1683 */     schemaPropertyImpl.setAttribute(paramSchemaField.isAttribute());
/* 1684 */     schemaPropertyImpl.setDefault(paramSchemaField.isDefault() ? 2 : 0);
/* 1685 */     schemaPropertyImpl.setFixed(paramSchemaField.isFixed() ? 2 : 0);
/* 1686 */     schemaPropertyImpl.setNillable(paramSchemaField.isNillable() ? 2 : 0);
/* 1687 */     schemaPropertyImpl.setDefaultText(paramSchemaField.getDefaultText());
/* 1688 */     schemaPropertyImpl.setMinOccurs(paramSchemaField.getMinOccurs());
/* 1689 */     schemaPropertyImpl.setMaxOccurs(paramSchemaField.getMaxOccurs());
/*      */     
/* 1691 */     if (paramSchemaField instanceof SchemaLocalElementImpl) {
/*      */       
/* 1693 */       SchemaLocalElementImpl schemaLocalElementImpl = (SchemaLocalElementImpl)paramSchemaField;
/* 1694 */       schemaPropertyImpl.setAcceptedNames(schemaLocalElementImpl.acceptedStartNames());
/*      */     } 
/*      */     
/* 1697 */     return schemaPropertyImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void mergeProperties(SchemaPropertyImpl paramSchemaPropertyImpl, SchemaProperty paramSchemaProperty, boolean paramBoolean) {
/* 1703 */     BigInteger bigInteger1 = paramSchemaPropertyImpl.getMinOccurs();
/* 1704 */     BigInteger bigInteger2 = paramSchemaPropertyImpl.getMaxOccurs();
/* 1705 */     if (paramBoolean) {
/*      */       
/* 1707 */       bigInteger1 = bigInteger1.add(paramSchemaProperty.getMinOccurs());
/* 1708 */       if (bigInteger2 != null) {
/* 1709 */         bigInteger2 = (paramSchemaProperty.getMaxOccurs() == null) ? null : bigInteger2.add(paramSchemaProperty.getMaxOccurs());
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1714 */       bigInteger1 = bigInteger1.min(paramSchemaProperty.getMinOccurs());
/* 1715 */       if (bigInteger2 != null) {
/* 1716 */         bigInteger2 = (paramSchemaProperty.getMaxOccurs() == null) ? null : bigInteger2.max(paramSchemaProperty.getMaxOccurs());
/*      */       }
/*      */     } 
/* 1719 */     paramSchemaPropertyImpl.setMinOccurs(bigInteger1);
/* 1720 */     paramSchemaPropertyImpl.setMaxOccurs(bigInteger2);
/*      */ 
/*      */     
/* 1723 */     if (paramSchemaProperty.hasNillable() != paramSchemaPropertyImpl.hasNillable())
/* 1724 */       paramSchemaPropertyImpl.setNillable(1); 
/* 1725 */     if (paramSchemaProperty.hasDefault() != paramSchemaPropertyImpl.hasDefault())
/* 1726 */       paramSchemaPropertyImpl.setDefault(1); 
/* 1727 */     if (paramSchemaProperty.hasFixed() != paramSchemaPropertyImpl.hasFixed()) {
/* 1728 */       paramSchemaPropertyImpl.setFixed(1);
/*      */     }
/*      */     
/* 1731 */     if (paramSchemaPropertyImpl.getDefaultText() != null)
/*      */     {
/* 1733 */       if (paramSchemaProperty.getDefaultText() == null || !paramSchemaPropertyImpl.getDefaultText().equals(paramSchemaProperty.getDefaultText()))
/*      */       {
/* 1735 */         paramSchemaPropertyImpl.setDefaultText(null);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   static SchemaParticle[] ensureStateMachine(SchemaParticle[] paramArrayOfSchemaParticle) {
/* 1741 */     for (byte b = 0; b < paramArrayOfSchemaParticle.length; b++)
/*      */     {
/* 1743 */       buildStateMachine(paramArrayOfSchemaParticle[b]);
/*      */     }
/* 1745 */     return paramArrayOfSchemaParticle;
/*      */   }
/*      */   
/*      */   static void buildStateMachine(SchemaParticle paramSchemaParticle) {
/*      */     byte b;
/* 1750 */     if (paramSchemaParticle == null) {
/*      */       return;
/*      */     }
/* 1753 */     SchemaParticleImpl schemaParticleImpl = (SchemaParticleImpl)paramSchemaParticle;
/* 1754 */     if (schemaParticleImpl.hasTransitionNotes()) {
/*      */       return;
/*      */     }
/* 1757 */     QNameSetBuilder qNameSetBuilder1 = new QNameSetBuilder();
/* 1758 */     QNameSetBuilder qNameSetBuilder2 = new QNameSetBuilder();
/* 1759 */     boolean bool = true;
/* 1760 */     SchemaParticle[] arrayOfSchemaParticle = null;
/* 1761 */     boolean bool1 = (schemaParticleImpl.getMinOccurs().signum() == 0) ? true : false;
/*      */     
/* 1763 */     switch (schemaParticleImpl.getParticleType()) {
/*      */ 
/*      */       
/*      */       case 4:
/* 1767 */         if (schemaParticleImpl.hasTransitionRules()) {
/* 1768 */           qNameSetBuilder1.addAll((QNameSetSpecification)schemaParticleImpl.acceptedStartNames()); break;
/*      */         } 
/* 1770 */         qNameSetBuilder1.add(schemaParticleImpl.getName());
/*      */         break;
/*      */ 
/*      */ 
/*      */       
/*      */       case 5:
/* 1776 */         qNameSetBuilder1.addAll((QNameSetSpecification)schemaParticleImpl.getWildcardSet());
/*      */         break;
/*      */       
/*      */       case 3:
/* 1780 */         arrayOfSchemaParticle = ensureStateMachine(schemaParticleImpl.getParticleChildren());
/*      */ 
/*      */         
/* 1783 */         bool1 = true;
/* 1784 */         for (b = 0; bool1 && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1786 */           if (!arrayOfSchemaParticle[b].isSkippable()) {
/* 1787 */             bool1 = false;
/*      */           }
/*      */         } 
/*      */         
/* 1791 */         for (b = 0; bool && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1793 */           if (!((SchemaParticleImpl)arrayOfSchemaParticle[b]).isDeterministic()) {
/* 1794 */             bool = false;
/*      */           }
/*      */         } 
/*      */         
/* 1798 */         for (b = 1; b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1800 */           qNameSetBuilder2.addAll((QNameSetSpecification)((SchemaParticleImpl)arrayOfSchemaParticle[b - 1]).getExcludeNextSet());
/* 1801 */           if (bool && !qNameSetBuilder2.isDisjoint((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames()))
/* 1802 */             bool = false; 
/* 1803 */           if (arrayOfSchemaParticle[b].isSkippable()) {
/* 1804 */             qNameSetBuilder2.addAll((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames());
/*      */           } else {
/* 1806 */             qNameSetBuilder2.clear();
/*      */           } 
/*      */         } 
/*      */         
/* 1810 */         for (b = 0; b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1812 */           qNameSetBuilder1.addAll((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames());
/* 1813 */           if (!arrayOfSchemaParticle[b].isSkippable()) {
/*      */             break;
/*      */           }
/*      */         } 
/*      */         break;
/*      */       case 2:
/* 1819 */         arrayOfSchemaParticle = ensureStateMachine(schemaParticleImpl.getParticleChildren());
/*      */ 
/*      */         
/* 1822 */         bool1 = false;
/* 1823 */         for (b = 0; !bool1 && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1825 */           if (arrayOfSchemaParticle[b].isSkippable()) {
/* 1826 */             bool1 = true;
/*      */           }
/*      */         } 
/*      */         
/* 1830 */         for (b = 0; bool && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1832 */           if (!((SchemaParticleImpl)arrayOfSchemaParticle[b]).isDeterministic()) {
/* 1833 */             bool = false;
/*      */           }
/*      */         } 
/*      */         
/* 1837 */         for (b = 0; b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1839 */           if (bool && !qNameSetBuilder1.isDisjoint((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames()))
/* 1840 */             bool = false; 
/* 1841 */           qNameSetBuilder1.addAll((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames());
/* 1842 */           qNameSetBuilder2.addAll((QNameSetSpecification)((SchemaParticleImpl)arrayOfSchemaParticle[b]).getExcludeNextSet());
/*      */         } 
/*      */         break;
/*      */ 
/*      */       
/*      */       case 1:
/* 1848 */         arrayOfSchemaParticle = ensureStateMachine(schemaParticleImpl.getParticleChildren());
/*      */ 
/*      */         
/* 1851 */         bool1 = true;
/* 1852 */         for (b = 0; !bool1 && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1854 */           if (!arrayOfSchemaParticle[b].isSkippable()) {
/* 1855 */             bool1 = false;
/*      */           }
/*      */         } 
/*      */         
/* 1859 */         for (b = 0; bool && b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1861 */           if (!((SchemaParticleImpl)arrayOfSchemaParticle[b]).isDeterministic()) {
/* 1862 */             bool = false;
/*      */           }
/*      */         } 
/*      */         
/* 1866 */         for (b = 0; b < arrayOfSchemaParticle.length; b++) {
/*      */           
/* 1868 */           if (bool && !qNameSetBuilder1.isDisjoint((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames()))
/* 1869 */             bool = false; 
/* 1870 */           qNameSetBuilder1.addAll((QNameSetSpecification)arrayOfSchemaParticle[b].acceptedStartNames());
/* 1871 */           qNameSetBuilder2.addAll((QNameSetSpecification)((SchemaParticleImpl)arrayOfSchemaParticle[b]).getExcludeNextSet());
/*      */         } 
/* 1873 */         if (bool1) {
/* 1874 */           qNameSetBuilder2.addAll((QNameSetSpecification)qNameSetBuilder1);
/*      */         }
/*      */         break;
/*      */       
/*      */       default:
/* 1879 */         throw new IllegalStateException("Unrecognized schema particle");
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1884 */     BigInteger bigInteger1 = schemaParticleImpl.getMinOccurs();
/* 1885 */     BigInteger bigInteger2 = schemaParticleImpl.getMaxOccurs();
/* 1886 */     boolean bool2 = (bigInteger2 == null || bigInteger2.compareTo(BigInteger.ONE) > 0) ? true : false;
/* 1887 */     boolean bool3 = (bigInteger2 == null || bigInteger1.compareTo(bigInteger2) < 0) ? true : false;
/*      */     
/* 1889 */     if (bool2 && bool && !qNameSetBuilder2.isDisjoint((QNameSetSpecification)qNameSetBuilder1)) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/* 1894 */       QNameSet qNameSet = qNameSetBuilder2.intersect((QNameSetSpecification)qNameSetBuilder1);
/*      */ 
/*      */       
/* 1897 */       HashMap hashMap1 = new HashMap();
/* 1898 */       particlesMatchingStart(schemaParticleImpl, (QNameSetSpecification)qNameSet, hashMap1, new QNameSetBuilder());
/*      */ 
/*      */       
/* 1901 */       HashMap hashMap2 = new HashMap();
/* 1902 */       particlesMatchingAfter(schemaParticleImpl, (QNameSetSpecification)qNameSet, hashMap2, new QNameSetBuilder(), true);
/*      */ 
/*      */ 
/*      */       
/* 1906 */       bool = afterMapSubsumedByStartMap(hashMap1, hashMap2);
/*      */     } 
/*      */     
/* 1909 */     if (bool3) {
/* 1910 */       qNameSetBuilder2.addAll((QNameSetSpecification)qNameSetBuilder1);
/*      */     }
/* 1912 */     bool1 = (bool1 || bigInteger1.signum() == 0) ? true : false;
/*      */     
/* 1914 */     schemaParticleImpl.setTransitionRules(qNameSetBuilder1.toQNameSet(), bool1);
/* 1915 */     schemaParticleImpl.setTransitionNotes(qNameSetBuilder2.toQNameSet(), bool);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean afterMapSubsumedByStartMap(Map paramMap1, Map paramMap2) {
/* 1920 */     if (paramMap2.size() > paramMap1.size()) {
/* 1921 */       return false;
/*      */     }
/* 1923 */     if (paramMap2.isEmpty()) {
/* 1924 */       return true;
/*      */     }
/* 1926 */     for (SchemaParticle schemaParticle : paramMap1.keySet()) {
/*      */ 
/*      */       
/* 1929 */       if (schemaParticle.getParticleType() == 5)
/*      */       {
/* 1931 */         if (paramMap2.containsKey(schemaParticle)) {
/*      */           
/* 1933 */           QNameSet qNameSet1 = (QNameSet)paramMap1.get(schemaParticle);
/* 1934 */           QNameSet qNameSet2 = (QNameSet)paramMap2.get(schemaParticle);
/* 1935 */           if (!qNameSet1.containsAll((QNameSetSpecification)qNameSet2))
/* 1936 */             return false; 
/*      */         } 
/*      */       }
/* 1939 */       paramMap2.remove(schemaParticle);
/* 1940 */       if (paramMap2.isEmpty())
/* 1941 */         return true; 
/*      */     } 
/* 1943 */     return paramMap2.isEmpty(); } private static void particlesMatchingStart(SchemaParticle paramSchemaParticle, QNameSetSpecification paramQNameSetSpecification, Map paramMap, QNameSetBuilder paramQNameSetBuilder) { SchemaParticle[] arrayOfSchemaParticle;
/*      */     byte b1;
/*      */     QNameSetBuilder qNameSetBuilder1;
/*      */     QNameSetBuilder qNameSetBuilder2;
/*      */     byte b2;
/* 1948 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 4:
/* 1951 */         if (!paramQNameSetSpecification.contains(paramSchemaParticle.getName()))
/*      */           return; 
/* 1953 */         paramMap.put(paramSchemaParticle, null);
/* 1954 */         paramQNameSetBuilder.add(paramSchemaParticle.getName());
/*      */         return;
/*      */       
/*      */       case 5:
/* 1958 */         if (paramQNameSetSpecification.isDisjoint((QNameSetSpecification)paramSchemaParticle.getWildcardSet()))
/*      */           return; 
/* 1960 */         paramMap.put(paramSchemaParticle, paramSchemaParticle.getWildcardSet().intersect(paramQNameSetSpecification));
/* 1961 */         paramQNameSetBuilder.addAll((QNameSetSpecification)paramSchemaParticle.getWildcardSet());
/*      */         return;
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/* 1967 */         arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1968 */         for (b1 = 0; b1 < arrayOfSchemaParticle.length; b1++) {
/* 1969 */           particlesMatchingStart(arrayOfSchemaParticle[b1], paramQNameSetSpecification, paramMap, paramQNameSetBuilder);
/*      */         }
/*      */         return;
/*      */ 
/*      */       
/*      */       case 3:
/* 1975 */         arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1976 */         if (arrayOfSchemaParticle.length == 0)
/*      */           return; 
/* 1978 */         if (!arrayOfSchemaParticle[0].isSkippable()) {
/*      */           
/* 1980 */           particlesMatchingStart(arrayOfSchemaParticle[0], paramQNameSetSpecification, paramMap, paramQNameSetBuilder);
/*      */           return;
/*      */         } 
/* 1983 */         qNameSetBuilder1 = new QNameSetBuilder(paramQNameSetSpecification);
/* 1984 */         qNameSetBuilder2 = new QNameSetBuilder();
/* 1985 */         for (b2 = 0; b2 < arrayOfSchemaParticle.length; b2++) {
/*      */           
/* 1987 */           particlesMatchingStart(arrayOfSchemaParticle[b2], (QNameSetSpecification)qNameSetBuilder1, paramMap, qNameSetBuilder2);
/* 1988 */           paramQNameSetBuilder.addAll((QNameSetSpecification)qNameSetBuilder2);
/* 1989 */           if (!arrayOfSchemaParticle[b2].isSkippable())
/*      */             return; 
/* 1991 */           qNameSetBuilder1.removeAll((QNameSetSpecification)qNameSetBuilder2);
/* 1992 */           if (qNameSetBuilder1.isEmpty())
/*      */             return; 
/* 1994 */           qNameSetBuilder2.clear();
/*      */         } 
/*      */         return;
/*      */     }  } private static void particlesMatchingAfter(SchemaParticle paramSchemaParticle, QNameSetSpecification paramQNameSetSpecification, Map paramMap, QNameSetBuilder paramQNameSetBuilder, boolean paramBoolean) {
/*      */     SchemaParticle[] arrayOfSchemaParticle;
/*      */     byte b;
/*      */     QNameSetBuilder qNameSetBuilder1;
/*      */     QNameSetBuilder qNameSetBuilder2;
/*      */     int i;
/* 2003 */     switch (paramSchemaParticle.getParticleType()) {
/*      */ 
/*      */       
/*      */       case 1:
/*      */       case 2:
/* 2008 */         arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 2009 */         for (b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 2010 */           particlesMatchingAfter(arrayOfSchemaParticle[b], paramQNameSetSpecification, paramMap, paramQNameSetBuilder, false);
/*      */         }
/*      */         break;
/*      */ 
/*      */       
/*      */       case 3:
/* 2016 */         arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 2017 */         if (arrayOfSchemaParticle.length == 0)
/*      */           break; 
/* 2019 */         if (!arrayOfSchemaParticle[arrayOfSchemaParticle.length - 1].isSkippable()) {
/*      */           
/* 2021 */           particlesMatchingAfter(arrayOfSchemaParticle[0], paramQNameSetSpecification, paramMap, paramQNameSetBuilder, false);
/*      */           break;
/*      */         } 
/* 2024 */         qNameSetBuilder1 = new QNameSetBuilder(paramQNameSetSpecification);
/* 2025 */         qNameSetBuilder2 = new QNameSetBuilder();
/* 2026 */         for (i = arrayOfSchemaParticle.length - 1; i >= 0; i--) {
/*      */           
/* 2028 */           particlesMatchingAfter(arrayOfSchemaParticle[i], (QNameSetSpecification)qNameSetBuilder1, paramMap, qNameSetBuilder2, false);
/* 2029 */           paramQNameSetBuilder.addAll((QNameSetSpecification)qNameSetBuilder2);
/* 2030 */           if (!arrayOfSchemaParticle[i].isSkippable())
/*      */             break; 
/* 2032 */           qNameSetBuilder1.removeAll((QNameSetSpecification)qNameSetBuilder2);
/* 2033 */           if (qNameSetBuilder1.isEmpty())
/*      */             break; 
/* 2035 */           qNameSetBuilder2.clear();
/*      */         } 
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/* 2041 */     if (!paramBoolean) {
/*      */       
/* 2043 */       BigInteger bigInteger1 = paramSchemaParticle.getMinOccurs();
/* 2044 */       BigInteger bigInteger2 = paramSchemaParticle.getMaxOccurs();
/* 2045 */       boolean bool = (bigInteger2 == null || bigInteger1.compareTo(bigInteger2) < 0) ? true : false;
/* 2046 */       if (bool)
/*      */       {
/* 2048 */         particlesMatchingStart(paramSchemaParticle, paramQNameSetSpecification, paramMap, paramQNameSetBuilder); } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static class CodeForNameEntry { public b name;
/*      */     public int code;
/*      */     
/*      */     CodeForNameEntry(b param1b, int param1Int) {
/* 2056 */       this.name = param1b; this.code = param1Int;
/*      */     } }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2063 */   private static CodeForNameEntry[] particleCodes = new CodeForNameEntry[] { new CodeForNameEntry(QNameHelper.forLNS("all", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("sequence", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("choice", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("element", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("any", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("group", "http://www.w3.org/2001/XMLSchema"), 100) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2073 */   private static Map particleCodeMap = buildParticleCodeMap(); private static final int ATTRIBUTE_CODE = 100; private static final int ATTRIBUTE_GROUP_CODE = 101;
/*      */   private static final int ANY_ATTRIBUTE_CODE = 102;
/*      */   
/*      */   private static Map buildParticleCodeMap() {
/* 2077 */     HashMap hashMap = new HashMap();
/* 2078 */     for (byte b = 0; b < particleCodes.length; b++)
/* 2079 */       hashMap.put((particleCodes[b]).name, new Integer((particleCodes[b]).code)); 
/* 2080 */     return hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int translateParticleCode(Group paramGroup) {
/* 2085 */     if (paramGroup == null)
/* 2086 */       return 0; 
/* 2087 */     return translateParticleCode(paramGroup.newCursor().getName());
/*      */   }
/*      */ 
/*      */   
/*      */   private static int translateParticleCode(b paramb) {
/* 2092 */     Integer integer = (Integer)particleCodeMap.get(paramb);
/* 2093 */     if (integer == null)
/* 2094 */       return 0; 
/* 2095 */     return integer.intValue();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2102 */   private static CodeForNameEntry[] attributeCodes = new CodeForNameEntry[] { new CodeForNameEntry(QNameHelper.forLNS("attribute", "http://www.w3.org/2001/XMLSchema"), 100), new CodeForNameEntry(QNameHelper.forLNS("attributeGroup", "http://www.w3.org/2001/XMLSchema"), 101), new CodeForNameEntry(QNameHelper.forLNS("anyAttribute", "http://www.w3.org/2001/XMLSchema"), 102) };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/* 2109 */   private static Map attributeCodeMap = buildAttributeCodeMap();
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private static Map buildAttributeCodeMap() {
/* 2113 */     HashMap hashMap = new HashMap();
/* 2114 */     for (byte b = 0; b < attributeCodes.length; b++)
/* 2115 */       hashMap.put((attributeCodes[b]).name, new Integer((attributeCodes[b]).code)); 
/* 2116 */     return hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   static int translateAttributeCode(b paramb) {
/* 2121 */     Integer integer = (Integer)attributeCodeMap.get(paramb);
/* 2122 */     if (integer == null)
/* 2123 */       return 0; 
/* 2124 */     return integer.intValue();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscComplexTypeResolver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */