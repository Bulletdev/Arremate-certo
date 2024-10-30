/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.QNameSetBuilder;
/*      */ import org.apache.xmlbeans.QNameSetSpecification;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaBookmark;
/*      */ import org.apache.xmlbeans.SchemaField;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlPositiveInteger;
/*      */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.XMLChar;
/*      */ import org.apache.xmlbeans.impl.common.XPath;
/*      */ import org.apache.xmlbeans.impl.regex.RegularExpression;
/*      */ import org.apache.xmlbeans.impl.values.NamespaceContext;
/*      */ import org.apache.xmlbeans.impl.values.XmlNonNegativeIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlPositiveIntegerImpl;
/*      */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AttributeGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Element;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Keybase;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
/*      */ import org.apache.xmlbeans.soap.SOAPArrayType;
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
/*      */ public class StscTranslator
/*      */ {
/*   74 */   private static final b WSDL_ARRAYTYPE_NAME = QNameHelper.forLNS("arrayType", "http://schemas.xmlsoap.org/wsdl/");
/*      */ 
/*      */   
/*      */   private static final String FORM_QUALIFIED = "qualified";
/*      */ 
/*      */   
/*      */   public static void addAllDefinitions(StscImporter.SchemaToProcess[] paramArrayOfSchemaToProcess) {
/*   81 */     ArrayList arrayList = new ArrayList();
/*   82 */     for (byte b1 = 0; b1 < paramArrayOfSchemaToProcess.length; b1++) {
/*      */       
/*   84 */       List list = paramArrayOfSchemaToProcess[b1].getRedefines();
/*   85 */       if (list != null) {
/*      */         
/*   87 */         List list1 = paramArrayOfSchemaToProcess[b1].getRedefineObjects();
/*   88 */         Iterator iterator = list.iterator();
/*   89 */         Iterator iterator1 = list1.iterator();
/*   90 */         while (iterator.hasNext()) {
/*      */ 
/*      */           
/*   93 */           assert iterator1.hasNext() : "The array of redefines and redefine objects have to have the same length";
/*   94 */           arrayList.add(new RedefinitionHolder(iterator.next(), iterator1.next()));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  100 */     RedefinitionMaster redefinitionMaster = new RedefinitionMaster(arrayList.<RedefinitionHolder>toArray(new RedefinitionHolder[arrayList.size()]));
/*      */ 
/*      */     
/*  103 */     StscState stscState = StscState.get(); byte b2;
/*  104 */     for (b2 = 0; b2 < paramArrayOfSchemaToProcess.length; b2++) {
/*      */       
/*  106 */       SchemaDocument.Schema schema = paramArrayOfSchemaToProcess[b2].getSchema();
/*  107 */       String str1 = paramArrayOfSchemaToProcess[b2].getChameleonNamespace();
/*      */ 
/*      */ 
/*      */       
/*  111 */       if (schema.sizeOfNotationArray() > 0)
/*      */       {
/*  113 */         stscState.warning("Schema <notation> is not yet supported for this release.", 51, (XmlObject)schema.getNotationArray(0));
/*      */       }
/*      */ 
/*      */       
/*  117 */       String str2 = schema.getTargetNamespace();
/*  118 */       boolean bool = false;
/*  119 */       if (str1 != null && str2 == null) {
/*      */         
/*  121 */         str2 = str1;
/*  122 */         bool = true;
/*      */       } 
/*  124 */       if (str2 == null) {
/*  125 */         str2 = "";
/*      */       }
/*      */       
/*  128 */       if (str2.length() > 0 || !isEmptySchema(schema)) {
/*      */         
/*  130 */         stscState.registerContribution(str2, schema.documentProperties().getSourceName());
/*  131 */         stscState.addNewContainer(str2);
/*      */       } 
/*      */ 
/*      */       
/*  135 */       ArrayList arrayList1 = new ArrayList();
/*  136 */       TopLevelComplexType[] arrayOfTopLevelComplexType = schema.getComplexTypeArray();
/*  137 */       for (byte b3 = 0; b3 < arrayOfTopLevelComplexType.length; b3++) {
/*      */         
/*  139 */         TopLevelComplexType topLevelComplexType = arrayOfTopLevelComplexType[b3];
/*      */ 
/*      */ 
/*      */         
/*  143 */         RedefinitionHolder[] arrayOfRedefinitionHolder = redefinitionMaster.getComplexTypeRedefinitions(topLevelComplexType.getName(), paramArrayOfSchemaToProcess[b2]);
/*      */         
/*  145 */         for (byte b10 = 0; b10 < arrayOfRedefinitionHolder.length; b10++) {
/*      */ 
/*      */ 
/*      */           
/*  149 */           if (arrayOfRedefinitionHolder[b10] != null) {
/*      */             
/*  151 */             TopLevelComplexType topLevelComplexType1 = arrayOfRedefinitionHolder[b10].redefineComplexType(topLevelComplexType.getName());
/*  152 */             assert topLevelComplexType1 != null;
/*  153 */             arrayList1.add(topLevelComplexType);
/*  154 */             topLevelComplexType = topLevelComplexType1;
/*      */           } 
/*      */         } 
/*      */         
/*  158 */         SchemaTypeImpl schemaTypeImpl = translateGlobalComplexType(topLevelComplexType, str2, bool, (arrayList1.size() > 0));
/*  159 */         stscState.addGlobalType(schemaTypeImpl, null);
/*      */ 
/*      */ 
/*      */         
/*  163 */         for (int i = arrayList1.size() - 1; i >= 0; i--) {
/*      */           
/*  165 */           TopLevelComplexType topLevelComplexType1 = arrayList1.remove(i);
/*  166 */           SchemaTypeImpl schemaTypeImpl1 = translateGlobalComplexType(topLevelComplexType1, str2, bool, (i > 0));
/*  167 */           stscState.addGlobalType(schemaTypeImpl1, schemaTypeImpl);
/*  168 */           schemaTypeImpl = schemaTypeImpl1;
/*      */         } 
/*      */       } 
/*      */       
/*  172 */       TopLevelSimpleType[] arrayOfTopLevelSimpleType = schema.getSimpleTypeArray();
/*  173 */       for (byte b4 = 0; b4 < arrayOfTopLevelSimpleType.length; b4++) {
/*      */         
/*  175 */         TopLevelSimpleType topLevelSimpleType = arrayOfTopLevelSimpleType[b4];
/*      */         
/*  177 */         RedefinitionHolder[] arrayOfRedefinitionHolder = redefinitionMaster.getSimpleTypeRedefinitions(topLevelSimpleType.getName(), paramArrayOfSchemaToProcess[b2]);
/*      */         
/*  179 */         for (byte b10 = 0; b10 < arrayOfRedefinitionHolder.length; b10++) {
/*      */ 
/*      */ 
/*      */           
/*  183 */           if (arrayOfRedefinitionHolder[b10] != null) {
/*      */             
/*  185 */             TopLevelSimpleType topLevelSimpleType1 = arrayOfRedefinitionHolder[b10].redefineSimpleType(topLevelSimpleType.getName());
/*  186 */             assert topLevelSimpleType1 != null;
/*  187 */             arrayList1.add(topLevelSimpleType);
/*  188 */             topLevelSimpleType = topLevelSimpleType1;
/*      */           } 
/*      */         } 
/*      */         
/*  192 */         SchemaTypeImpl schemaTypeImpl = translateGlobalSimpleType(topLevelSimpleType, str2, bool, (arrayList1.size() > 0));
/*  193 */         stscState.addGlobalType(schemaTypeImpl, null);
/*      */         
/*  195 */         for (int i = arrayList1.size() - 1; i >= 0; i--) {
/*      */           
/*  197 */           TopLevelSimpleType topLevelSimpleType1 = (TopLevelSimpleType)arrayList1.remove(i);
/*  198 */           SchemaTypeImpl schemaTypeImpl1 = translateGlobalSimpleType(topLevelSimpleType1, str2, bool, (i > 0));
/*  199 */           stscState.addGlobalType(schemaTypeImpl1, schemaTypeImpl);
/*  200 */           schemaTypeImpl = schemaTypeImpl1;
/*      */         } 
/*      */       } 
/*      */       
/*  204 */       TopLevelElement[] arrayOfTopLevelElement = schema.getElementArray();
/*  205 */       for (byte b5 = 0; b5 < arrayOfTopLevelElement.length; b5++) {
/*      */         
/*  207 */         TopLevelElement topLevelElement = arrayOfTopLevelElement[b5];
/*  208 */         stscState.addDocumentType(translateDocumentType(topLevelElement, str2, bool), QNameHelper.forLNS(topLevelElement.getName(), str2));
/*      */       } 
/*      */       
/*  211 */       TopLevelAttribute[] arrayOfTopLevelAttribute = schema.getAttributeArray();
/*  212 */       for (byte b6 = 0; b6 < arrayOfTopLevelAttribute.length; b6++) {
/*      */         
/*  214 */         TopLevelAttribute topLevelAttribute = arrayOfTopLevelAttribute[b6];
/*  215 */         stscState.addAttributeType(translateAttributeType(topLevelAttribute, str2, bool), QNameHelper.forLNS(topLevelAttribute.getName(), str2));
/*      */       } 
/*      */       
/*  218 */       NamedGroup[] arrayOfNamedGroup = schema.getGroupArray();
/*  219 */       for (byte b7 = 0; b7 < arrayOfNamedGroup.length; b7++) {
/*      */         
/*  221 */         NamedGroup namedGroup = arrayOfNamedGroup[b7];
/*      */         
/*  223 */         RedefinitionHolder[] arrayOfRedefinitionHolder = redefinitionMaster.getModelGroupRedefinitions(namedGroup.getName(), paramArrayOfSchemaToProcess[b2]);
/*      */         
/*  225 */         for (byte b10 = 0; b10 < arrayOfRedefinitionHolder.length; b10++) {
/*      */ 
/*      */ 
/*      */           
/*  229 */           if (arrayOfRedefinitionHolder[b10] != null) {
/*      */             
/*  231 */             NamedGroup namedGroup1 = arrayOfRedefinitionHolder[b10].redefineModelGroup(namedGroup.getName());
/*  232 */             assert namedGroup1 != null;
/*  233 */             arrayList1.add(namedGroup);
/*  234 */             namedGroup = namedGroup1;
/*      */           } 
/*      */         } 
/*      */         
/*  238 */         SchemaModelGroupImpl schemaModelGroupImpl = translateModelGroup(namedGroup, str2, bool, (arrayList1.size() > 0));
/*  239 */         stscState.addModelGroup(schemaModelGroupImpl, null);
/*      */         
/*  241 */         for (int i = arrayList1.size() - 1; i >= 0; i--) {
/*      */           
/*  243 */           NamedGroup namedGroup1 = (NamedGroup)arrayList1.remove(i);
/*  244 */           SchemaModelGroupImpl schemaModelGroupImpl1 = translateModelGroup(namedGroup1, str2, bool, (i > 0));
/*  245 */           stscState.addModelGroup(schemaModelGroupImpl1, schemaModelGroupImpl);
/*  246 */           schemaModelGroupImpl = schemaModelGroupImpl1;
/*      */         } 
/*      */       } 
/*      */       
/*  250 */       NamedAttributeGroup[] arrayOfNamedAttributeGroup = schema.getAttributeGroupArray();
/*  251 */       for (byte b8 = 0; b8 < arrayOfNamedAttributeGroup.length; b8++) {
/*      */         
/*  253 */         NamedAttributeGroup namedAttributeGroup = arrayOfNamedAttributeGroup[b8];
/*      */         
/*  255 */         RedefinitionHolder[] arrayOfRedefinitionHolder = redefinitionMaster.getAttributeGroupRedefinitions(namedAttributeGroup.getName(), paramArrayOfSchemaToProcess[b2]);
/*      */         
/*  257 */         for (byte b10 = 0; b10 < arrayOfRedefinitionHolder.length; b10++) {
/*      */ 
/*      */ 
/*      */           
/*  261 */           if (arrayOfRedefinitionHolder[b10] != null) {
/*      */             
/*  263 */             NamedAttributeGroup namedAttributeGroup1 = arrayOfRedefinitionHolder[b10].redefineAttributeGroup(namedAttributeGroup.getName());
/*  264 */             assert namedAttributeGroup1 != null;
/*  265 */             arrayList1.add(namedAttributeGroup);
/*  266 */             namedAttributeGroup = namedAttributeGroup1;
/*      */           } 
/*      */         } 
/*      */         
/*  270 */         SchemaAttributeGroupImpl schemaAttributeGroupImpl = translateAttributeGroup((AttributeGroup)namedAttributeGroup, str2, bool, (arrayList1.size() > 0));
/*  271 */         stscState.addAttributeGroup(schemaAttributeGroupImpl, null);
/*      */         
/*  273 */         for (int i = arrayList1.size() - 1; i >= 0; i--) {
/*      */           
/*  275 */           NamedAttributeGroup namedAttributeGroup1 = (NamedAttributeGroup)arrayList1.remove(i);
/*  276 */           SchemaAttributeGroupImpl schemaAttributeGroupImpl1 = translateAttributeGroup((AttributeGroup)namedAttributeGroup1, str2, bool, (i > 0));
/*  277 */           stscState.addAttributeGroup(schemaAttributeGroupImpl1, schemaAttributeGroupImpl);
/*  278 */           schemaAttributeGroupImpl = schemaAttributeGroupImpl1;
/*      */         } 
/*      */       } 
/*      */       
/*  282 */       AnnotationDocument.Annotation[] arrayOfAnnotation = schema.getAnnotationArray();
/*  283 */       for (byte b9 = 0; b9 < arrayOfAnnotation.length; b9++) {
/*  284 */         stscState.addAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(str2), (XmlObject)schema, arrayOfAnnotation[b9]), str2);
/*      */       }
/*      */     } 
/*  287 */     for (b2 = 0; b2 < arrayList.size(); b2++) {
/*  288 */       ((RedefinitionHolder)arrayList.get(b2)).complainAboutMissingDefinitions();
/*      */     }
/*      */   }
/*      */   
/*      */   private static class RedefinitionHolder
/*      */   {
/*  294 */     private Map stRedefinitions = Collections.EMPTY_MAP;
/*  295 */     private Map ctRedefinitions = Collections.EMPTY_MAP;
/*  296 */     private Map agRedefinitions = Collections.EMPTY_MAP;
/*  297 */     private Map mgRedefinitions = Collections.EMPTY_MAP;
/*  298 */     private String schemaLocation = "";
/*      */     
/*      */     private StscImporter.SchemaToProcess schemaRedefined;
/*      */ 
/*      */     
/*      */     RedefinitionHolder(StscImporter.SchemaToProcess param1SchemaToProcess, RedefineDocument.Redefine param1Redefine) {
/*  304 */       this.schemaRedefined = param1SchemaToProcess;
/*  305 */       if (param1Redefine != null) {
/*      */         
/*  307 */         StscState stscState = StscState.get();
/*      */         
/*  309 */         this.stRedefinitions = new HashMap();
/*  310 */         this.ctRedefinitions = new HashMap();
/*  311 */         this.agRedefinitions = new HashMap();
/*  312 */         this.mgRedefinitions = new HashMap();
/*  313 */         if (param1Redefine.getSchemaLocation() != null) {
/*  314 */           this.schemaLocation = param1Redefine.getSchemaLocation();
/*      */         }
/*  316 */         TopLevelComplexType[] arrayOfTopLevelComplexType = param1Redefine.getComplexTypeArray();
/*  317 */         for (byte b1 = 0; b1 < arrayOfTopLevelComplexType.length; b1++) {
/*      */           
/*  319 */           if (arrayOfTopLevelComplexType[b1].getName() != null)
/*      */           {
/*      */             
/*  322 */             if (this.ctRedefinitions.containsKey(arrayOfTopLevelComplexType[b1].getName())) {
/*  323 */               stscState.error("Duplicate type redefinition: " + arrayOfTopLevelComplexType[b1].getName(), 49, (XmlObject)null);
/*      */             } else {
/*  325 */               this.ctRedefinitions.put(arrayOfTopLevelComplexType[b1].getName(), arrayOfTopLevelComplexType[b1]);
/*      */             } 
/*      */           }
/*      */         } 
/*  329 */         TopLevelSimpleType[] arrayOfTopLevelSimpleType = param1Redefine.getSimpleTypeArray();
/*  330 */         for (byte b2 = 0; b2 < arrayOfTopLevelSimpleType.length; b2++) {
/*      */           
/*  332 */           if (arrayOfTopLevelSimpleType[b2].getName() != null)
/*      */           {
/*  334 */             if (this.stRedefinitions.containsKey(arrayOfTopLevelSimpleType[b2].getName())) {
/*  335 */               stscState.error("Duplicate type redefinition: " + arrayOfTopLevelSimpleType[b2].getName(), 49, (XmlObject)null);
/*      */             } else {
/*  337 */               this.stRedefinitions.put(arrayOfTopLevelSimpleType[b2].getName(), arrayOfTopLevelSimpleType[b2]);
/*      */             } 
/*      */           }
/*      */         } 
/*  341 */         NamedGroup[] arrayOfNamedGroup = param1Redefine.getGroupArray();
/*  342 */         for (byte b3 = 0; b3 < arrayOfNamedGroup.length; b3++) {
/*      */           
/*  344 */           if (arrayOfNamedGroup[b3].getName() != null)
/*      */           {
/*  346 */             if (this.mgRedefinitions.containsKey(arrayOfNamedGroup[b3].getName())) {
/*  347 */               stscState.error("Duplicate type redefinition: " + arrayOfNamedGroup[b3].getName(), 49, (XmlObject)null);
/*      */             } else {
/*  349 */               this.mgRedefinitions.put(arrayOfNamedGroup[b3].getName(), arrayOfNamedGroup[b3]);
/*      */             } 
/*      */           }
/*      */         } 
/*  353 */         NamedAttributeGroup[] arrayOfNamedAttributeGroup = param1Redefine.getAttributeGroupArray();
/*  354 */         for (byte b4 = 0; b4 < arrayOfNamedAttributeGroup.length; b4++) {
/*      */           
/*  356 */           if (arrayOfNamedAttributeGroup[b4].getName() != null)
/*      */           {
/*  358 */             if (this.agRedefinitions.containsKey(arrayOfNamedAttributeGroup[b4].getName())) {
/*  359 */               stscState.error("Duplicate type redefinition: " + arrayOfNamedAttributeGroup[b4].getName(), 49, (XmlObject)null);
/*      */             } else {
/*  361 */               this.agRedefinitions.put(arrayOfNamedAttributeGroup[b4].getName(), arrayOfNamedAttributeGroup[b4]);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     public TopLevelSimpleType redefineSimpleType(String param1String) {
/*  369 */       if (param1String == null || !this.stRedefinitions.containsKey(param1String))
/*  370 */         return null; 
/*  371 */       return (TopLevelSimpleType)this.stRedefinitions.remove(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public TopLevelComplexType redefineComplexType(String param1String) {
/*  376 */       if (param1String == null || !this.ctRedefinitions.containsKey(param1String))
/*  377 */         return null; 
/*  378 */       return (TopLevelComplexType)this.ctRedefinitions.remove(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public NamedGroup redefineModelGroup(String param1String) {
/*  383 */       if (param1String == null || !this.mgRedefinitions.containsKey(param1String))
/*  384 */         return null; 
/*  385 */       return (NamedGroup)this.mgRedefinitions.remove(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public NamedAttributeGroup redefineAttributeGroup(String param1String) {
/*  390 */       if (param1String == null || !this.agRedefinitions.containsKey(param1String))
/*  391 */         return null; 
/*  392 */       return (NamedAttributeGroup)this.agRedefinitions.remove(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     public void complainAboutMissingDefinitions() {
/*  397 */       if (this.stRedefinitions.isEmpty() && this.ctRedefinitions.isEmpty() && this.agRedefinitions.isEmpty() && this.mgRedefinitions.isEmpty()) {
/*      */         return;
/*      */       }
/*      */       
/*  401 */       StscState stscState = StscState.get();
/*      */       
/*  403 */       for (String str : this.stRedefinitions.keySet())
/*      */       {
/*      */         
/*  406 */         stscState.error("Redefined simple type " + str + " not found in " + this.schemaLocation, 60, (XmlObject)this.stRedefinitions.get(str));
/*      */       }
/*      */       
/*  409 */       for (String str : this.ctRedefinitions.keySet())
/*      */       {
/*      */         
/*  412 */         stscState.error("Redefined complex type " + str + " not found in " + this.schemaLocation, 60, (XmlObject)this.ctRedefinitions.get(str));
/*      */       }
/*      */       
/*  415 */       for (String str : this.agRedefinitions.keySet())
/*      */       {
/*      */         
/*  418 */         stscState.error("Redefined attribute group " + str + " not found in " + this.schemaLocation, 60, (XmlObject)this.agRedefinitions.get(str));
/*      */       }
/*      */       
/*  421 */       for (String str : this.mgRedefinitions.keySet())
/*      */       {
/*      */         
/*  424 */         stscState.error("Redefined model group " + str + " not found in " + this.schemaLocation, 60, (XmlObject)this.mgRedefinitions.get(str));
/*      */       }
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
/*      */   private static class RedefinitionMaster
/*      */   {
/*  441 */     private Map stRedefinitions = Collections.EMPTY_MAP;
/*  442 */     private Map ctRedefinitions = Collections.EMPTY_MAP;
/*  443 */     private Map agRedefinitions = Collections.EMPTY_MAP;
/*  444 */     private Map mgRedefinitions = Collections.EMPTY_MAP;
/*  445 */     private static final StscTranslator.RedefinitionHolder[] EMPTY_REDEFINTION_HOLDER_ARRAY = new StscTranslator.RedefinitionHolder[0];
/*      */     private static final short SIMPLE_TYPE = 1;
/*      */     private static final short COMPLEX_TYPE = 2;
/*      */     
/*      */     RedefinitionMaster(StscTranslator.RedefinitionHolder[] param1ArrayOfRedefinitionHolder) {
/*  450 */       if (param1ArrayOfRedefinitionHolder.length > 0) {
/*      */         
/*  452 */         this.stRedefinitions = new HashMap();
/*  453 */         this.ctRedefinitions = new HashMap();
/*  454 */         this.agRedefinitions = new HashMap();
/*  455 */         this.mgRedefinitions = new HashMap();
/*      */         
/*  457 */         for (byte b = 0; b < param1ArrayOfRedefinitionHolder.length; b++) {
/*      */           
/*  459 */           StscTranslator.RedefinitionHolder redefinitionHolder = param1ArrayOfRedefinitionHolder[b];
/*  460 */           for (Object object : redefinitionHolder.stRedefinitions.keySet()) {
/*      */ 
/*      */             
/*  463 */             List list = (List)this.stRedefinitions.get(object);
/*  464 */             if (list == null) {
/*      */               
/*  466 */               list = new ArrayList();
/*  467 */               this.stRedefinitions.put(object, list);
/*      */             } 
/*  469 */             list.add(param1ArrayOfRedefinitionHolder[b]);
/*      */           } 
/*  471 */           for (Object object : redefinitionHolder.ctRedefinitions.keySet()) {
/*      */ 
/*      */             
/*  474 */             List list = (List)this.ctRedefinitions.get(object);
/*  475 */             if (list == null) {
/*      */               
/*  477 */               list = new ArrayList();
/*  478 */               this.ctRedefinitions.put(object, list);
/*      */             } 
/*  480 */             list.add(param1ArrayOfRedefinitionHolder[b]);
/*      */           } 
/*  482 */           for (Object object : redefinitionHolder.agRedefinitions.keySet()) {
/*      */ 
/*      */             
/*  485 */             List list = (List)this.agRedefinitions.get(object);
/*  486 */             if (list == null) {
/*      */               
/*  488 */               list = new ArrayList();
/*  489 */               this.agRedefinitions.put(object, list);
/*      */             } 
/*  491 */             list.add(param1ArrayOfRedefinitionHolder[b]);
/*      */           } 
/*  493 */           for (Object object : redefinitionHolder.mgRedefinitions.keySet()) {
/*      */ 
/*      */             
/*  496 */             List list = (List)this.mgRedefinitions.get(object);
/*  497 */             if (list == null) {
/*      */               
/*  499 */               list = new ArrayList();
/*  500 */               this.mgRedefinitions.put(object, list);
/*      */             } 
/*  502 */             list.add(param1ArrayOfRedefinitionHolder[b]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     private static final short MODEL_GROUP = 3; private static final short ATTRIBUTE_GROUP = 4;
/*      */     static final boolean $assertionsDisabled;
/*      */     
/*      */     StscTranslator.RedefinitionHolder[] getSimpleTypeRedefinitions(String param1String, StscImporter.SchemaToProcess param1SchemaToProcess) {
/*  511 */       List list = (List)this.stRedefinitions.get(param1String);
/*  512 */       if (list == null)
/*  513 */         return EMPTY_REDEFINTION_HOLDER_ARRAY; 
/*  514 */       return doTopologicalSort(list, param1SchemaToProcess, param1String, (short)1);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     StscTranslator.RedefinitionHolder[] getComplexTypeRedefinitions(String param1String, StscImporter.SchemaToProcess param1SchemaToProcess) {
/*  520 */       List list = (List)this.ctRedefinitions.get(param1String);
/*  521 */       if (list == null)
/*  522 */         return EMPTY_REDEFINTION_HOLDER_ARRAY; 
/*  523 */       return doTopologicalSort(list, param1SchemaToProcess, param1String, (short)2);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     StscTranslator.RedefinitionHolder[] getAttributeGroupRedefinitions(String param1String, StscImporter.SchemaToProcess param1SchemaToProcess) {
/*  529 */       List list = (List)this.agRedefinitions.get(param1String);
/*  530 */       if (list == null)
/*  531 */         return EMPTY_REDEFINTION_HOLDER_ARRAY; 
/*  532 */       return doTopologicalSort(list, param1SchemaToProcess, param1String, (short)4);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     StscTranslator.RedefinitionHolder[] getModelGroupRedefinitions(String param1String, StscImporter.SchemaToProcess param1SchemaToProcess) {
/*  538 */       List list = (List)this.mgRedefinitions.get(param1String);
/*  539 */       if (list == null)
/*  540 */         return EMPTY_REDEFINTION_HOLDER_ARRAY; 
/*  541 */       return doTopologicalSort(list, param1SchemaToProcess, param1String, (short)3);
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
/*      */     
/*      */     private StscTranslator.RedefinitionHolder[] doTopologicalSort(List param1List, StscImporter.SchemaToProcess param1SchemaToProcess, String param1String, short param1Short) {
/*  554 */       StscTranslator.RedefinitionHolder[] arrayOfRedefinitionHolder1 = new StscTranslator.RedefinitionHolder[param1List.size()];
/*  555 */       byte b1 = 0;
/*  556 */       for (byte b2 = 0; b2 < param1List.size(); b2++) {
/*      */         
/*  558 */         StscTranslator.RedefinitionHolder redefinitionHolder = param1List.get(b2);
/*  559 */         if (redefinitionHolder.schemaRedefined == param1SchemaToProcess || redefinitionHolder.schemaRedefined.indirectIncludes(param1SchemaToProcess))
/*      */         {
/*  561 */           arrayOfRedefinitionHolder1[b1++] = redefinitionHolder;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/*  567 */       StscTranslator.RedefinitionHolder[] arrayOfRedefinitionHolder2 = new StscTranslator.RedefinitionHolder[b1];
/*  568 */       int[] arrayOfInt = new int[b1];
/*      */       byte b3;
/*  570 */       for (b3 = 0; b3 < b1 - 1; b3++) {
/*      */         
/*  572 */         StscTranslator.RedefinitionHolder redefinitionHolder = arrayOfRedefinitionHolder1[b3];
/*  573 */         for (int i = b3 + 1; i < b1; i++) {
/*      */           
/*  575 */           if (redefinitionHolder.schemaRedefined.indirectIncludes((arrayOfRedefinitionHolder1[i]).schemaRedefined))
/*  576 */             arrayOfInt[b3] = arrayOfInt[b3] + 1; 
/*  577 */           if ((arrayOfRedefinitionHolder1[i]).schemaRedefined.indirectIncludes(redefinitionHolder.schemaRedefined)) {
/*  578 */             arrayOfInt[i] = arrayOfInt[i] + 1;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  583 */       b3 = 0;
/*  584 */       boolean bool = false;
/*  585 */       while (b3 < b1) {
/*      */         
/*  587 */         int i = -1; int j;
/*  588 */         for (j = 0; j < arrayOfInt.length; j++) {
/*  589 */           if (arrayOfInt[j] == 0)
/*      */           {
/*  591 */             if (i < 0)
/*  592 */               i = j;  } 
/*      */         } 
/*  594 */         if (i < 0) {
/*      */ 
/*      */           
/*  597 */           if (!bool) {
/*      */             
/*  599 */             StringBuffer stringBuffer = new StringBuffer();
/*  600 */             XmlObject xmlObject = null;
/*  601 */             for (byte b5 = 0; b5 < b1; b5++) {
/*  602 */               if (arrayOfRedefinitionHolder1[b5] != null) {
/*      */                 
/*  604 */                 stringBuffer.append((arrayOfRedefinitionHolder1[b5]).schemaLocation).append(',').append(' ');
/*      */                 
/*  606 */                 if (xmlObject == null)
/*  607 */                   xmlObject = locationFromRedefinitionAndCode(arrayOfRedefinitionHolder1[b5], param1String, param1Short); 
/*      */               } 
/*      */             } 
/*  610 */             StscState.get().error("Detected circular redefinition of " + componentNameFromCode(param1Short) + " \"" + param1String + "\"; Files involved: " + stringBuffer.toString(), 60, xmlObject);
/*      */ 
/*      */ 
/*      */             
/*  614 */             bool = true;
/*      */           } 
/*  616 */           j = b1;
/*  617 */           for (byte b = 0; b < b1; b++) {
/*  618 */             if (arrayOfInt[b] > 0 && arrayOfInt[b] < j) {
/*      */               
/*  620 */               j = arrayOfInt[b];
/*  621 */               i = b;
/*      */             } 
/*  623 */           }  arrayOfInt[i] = arrayOfInt[i] - 1;
/*      */           
/*      */           continue;
/*      */         } 
/*  627 */         assert arrayOfRedefinitionHolder1[i] != null;
/*  628 */         arrayOfRedefinitionHolder2[b3++] = arrayOfRedefinitionHolder1[i];
/*  629 */         for (j = 0; j < b1; j++) {
/*  630 */           if (arrayOfRedefinitionHolder1[j] != null && (arrayOfRedefinitionHolder1[j]).schemaRedefined.indirectIncludes((arrayOfRedefinitionHolder1[i]).schemaRedefined))
/*      */           {
/*      */ 
/*      */             
/*  634 */             arrayOfInt[j] = arrayOfInt[j] - 1; } 
/*  635 */         }  arrayOfRedefinitionHolder1[i] = null;
/*  636 */         arrayOfInt[i] = arrayOfInt[i] - 1;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  643 */       for (byte b4 = 1; b4 < b1; b4++) {
/*      */         int i;
/*      */ 
/*      */ 
/*      */         
/*  648 */         for (i = b4 - 1; i >= 0 && 
/*  649 */           arrayOfRedefinitionHolder2[i] == null; i--);
/*      */ 
/*      */         
/*  652 */         if (!(arrayOfRedefinitionHolder2[b4]).schemaRedefined.indirectIncludes((arrayOfRedefinitionHolder2[i]).schemaRedefined)) {
/*      */ 
/*      */           
/*  655 */           StscState.get().error("Detected multiple redefinitions of " + componentNameFromCode(param1Short) + " \"" + param1String + "\"; Files involved: " + (arrayOfRedefinitionHolder2[i]).schemaRedefined.getSourceName() + ", " + (arrayOfRedefinitionHolder2[b4]).schemaRedefined.getSourceName(), 49, locationFromRedefinitionAndCode(arrayOfRedefinitionHolder2[b4], param1String, param1Short));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  663 */           switch (param1Short) {
/*      */             
/*      */             case 1:
/*  666 */               arrayOfRedefinitionHolder2[b4].redefineSimpleType(param1String); break;
/*      */             case 2:
/*  668 */               arrayOfRedefinitionHolder2[b4].redefineComplexType(param1String); break;
/*      */             case 4:
/*  670 */               arrayOfRedefinitionHolder2[b4].redefineAttributeGroup(param1String); break;
/*      */             case 3:
/*  672 */               arrayOfRedefinitionHolder2[b4].redefineModelGroup(param1String); break;
/*      */           } 
/*  674 */           arrayOfRedefinitionHolder2[b4] = null;
/*      */         } 
/*      */       } 
/*      */       
/*  678 */       return arrayOfRedefinitionHolder2;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private String componentNameFromCode(short param1Short) {
/*  684 */       switch (param1Short)
/*      */       { case 1:
/*  686 */           str = "simple type";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  692 */           return str;case 2: str = "complex type"; return str;case 3: str = "model group"; return str;case 4: str = "attribute group"; return str; }  String str = ""; return str;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private XmlObject locationFromRedefinitionAndCode(StscTranslator.RedefinitionHolder param1RedefinitionHolder, String param1String, short param1Short) {
/*  699 */       switch (param1Short)
/*      */       
/*      */       { case 1:
/*  702 */           xmlObject = (XmlObject)param1RedefinitionHolder.stRedefinitions.get(param1String);
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
/*  716 */           return xmlObject;case 2: xmlObject = (XmlObject)param1RedefinitionHolder.ctRedefinitions.get(param1String); return xmlObject;case 3: xmlObject = (XmlObject)param1RedefinitionHolder.mgRedefinitions.get(param1String); return xmlObject;case 4: xmlObject = (XmlObject)param1RedefinitionHolder.agRedefinitions.get(param1String); return xmlObject; }  XmlObject xmlObject = null; return xmlObject;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static String findFilename(XmlObject paramXmlObject) {
/*  722 */     return StscState.get().sourceNameForUri(paramXmlObject.documentProperties().getSourceName());
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaTypeImpl translateDocumentType(TopLevelElement paramTopLevelElement, String paramString, boolean paramBoolean) {
/*  727 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(paramString));
/*      */     
/*  729 */     schemaTypeImpl.setDocumentType(true);
/*  730 */     schemaTypeImpl.setParseContext((XmlObject)paramTopLevelElement, paramString, paramBoolean, null, null, false);
/*  731 */     schemaTypeImpl.setFilename(findFilename((XmlObject)paramTopLevelElement));
/*      */     
/*  733 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaTypeImpl translateAttributeType(TopLevelAttribute paramTopLevelAttribute, String paramString, boolean paramBoolean) {
/*  738 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(StscState.get().getContainer(paramString));
/*      */     
/*  740 */     schemaTypeImpl.setAttributeType(true);
/*  741 */     schemaTypeImpl.setParseContext((XmlObject)paramTopLevelAttribute, paramString, paramBoolean, null, null, false);
/*  742 */     schemaTypeImpl.setFilename(findFilename((XmlObject)paramTopLevelAttribute));
/*      */     
/*  744 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaTypeImpl translateGlobalComplexType(TopLevelComplexType paramTopLevelComplexType, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  749 */     StscState stscState = StscState.get();
/*      */     
/*  751 */     String str = paramTopLevelComplexType.getName();
/*  752 */     if (str == null) {
/*      */       
/*  754 */       stscState.error("missing-name", new Object[] { "global type" }, (XmlObject)paramTopLevelComplexType);
/*      */       
/*  756 */       return null;
/*      */     } 
/*  758 */     if (!XMLChar.isValidNCName(str))
/*      */     {
/*  760 */       stscState.error("invalid-value", new Object[] { str, "name" }, (XmlObject)paramTopLevelComplexType.xgetName());
/*      */     }
/*      */ 
/*      */     
/*  764 */     b b1 = QNameHelper.forLNS(str, paramString);
/*      */     
/*  766 */     if (isReservedTypeName(b1)) {
/*      */       
/*  768 */       stscState.warning("reserved-type-name", new Object[] { QNameHelper.pretty(b1) }, (XmlObject)paramTopLevelComplexType);
/*  769 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  773 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(paramString));
/*  774 */     schemaTypeImpl.setParseContext((XmlObject)paramTopLevelComplexType, paramString, paramBoolean1, null, null, paramBoolean2);
/*  775 */     schemaTypeImpl.setFilename(findFilename((XmlObject)paramTopLevelComplexType));
/*  776 */     schemaTypeImpl.setName(QNameHelper.forLNS(str, paramString));
/*  777 */     schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString), (Annotated)paramTopLevelComplexType));
/*  778 */     schemaTypeImpl.setUserData(getUserData((XmlObject)paramTopLevelComplexType));
/*  779 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaTypeImpl translateGlobalSimpleType(TopLevelSimpleType paramTopLevelSimpleType, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/*  784 */     StscState stscState = StscState.get();
/*      */     
/*  786 */     String str = paramTopLevelSimpleType.getName();
/*  787 */     if (str == null) {
/*      */       
/*  789 */       stscState.error("missing-name", new Object[] { "global type" }, (XmlObject)paramTopLevelSimpleType);
/*      */       
/*  791 */       return null;
/*      */     } 
/*  793 */     if (!XMLChar.isValidNCName(str))
/*      */     {
/*  795 */       stscState.error("invalid-value", new Object[] { str, "name" }, (XmlObject)paramTopLevelSimpleType.xgetName());
/*      */     }
/*      */ 
/*      */     
/*  799 */     b b1 = QNameHelper.forLNS(str, paramString);
/*      */     
/*  801 */     if (isReservedTypeName(b1)) {
/*      */       
/*  803 */       stscState.warning("reserved-type-name", new Object[] { QNameHelper.pretty(b1) }, (XmlObject)paramTopLevelSimpleType);
/*  804 */       return null;
/*      */     } 
/*      */ 
/*      */     
/*  808 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(paramString));
/*  809 */     schemaTypeImpl.setSimpleType(true);
/*  810 */     schemaTypeImpl.setParseContext((XmlObject)paramTopLevelSimpleType, paramString, paramBoolean1, null, null, paramBoolean2);
/*  811 */     schemaTypeImpl.setFilename(findFilename((XmlObject)paramTopLevelSimpleType));
/*  812 */     schemaTypeImpl.setName(b1);
/*  813 */     schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString), (Annotated)paramTopLevelSimpleType));
/*  814 */     schemaTypeImpl.setUserData(getUserData((XmlObject)paramTopLevelSimpleType));
/*  815 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaTypeImpl translateAnonymousSimpleType(SimpleType paramSimpleType, String paramString1, boolean paramBoolean, String paramString2, String paramString3, List paramList, SchemaType paramSchemaType) {
/*  822 */     StscState stscState = StscState.get();
/*  823 */     SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(paramString1));
/*  824 */     schemaTypeImpl.setSimpleType(true);
/*  825 */     schemaTypeImpl.setParseContext((XmlObject)paramSimpleType, paramString1, paramBoolean, paramString2, paramString3, false);
/*      */     
/*  827 */     schemaTypeImpl.setOuterSchemaTypeRef(paramSchemaType.getRef());
/*  828 */     schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString1), (Annotated)paramSimpleType));
/*  829 */     schemaTypeImpl.setUserData(getUserData((XmlObject)paramSimpleType));
/*  830 */     paramList.add(schemaTypeImpl);
/*  831 */     return schemaTypeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   static FormChoice findElementFormDefault(XmlObject paramXmlObject) {
/*  836 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/*  837 */     while (xmlCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
/*  838 */       if (!xmlCursor.toParent())
/*  839 */         return null; 
/*  840 */     }  return ((SchemaDocument.Schema)xmlCursor.getObject()).xgetElementFormDefault();
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean uriMatch(String paramString1, String paramString2) {
/*  845 */     if (paramString1 == null)
/*  846 */       return (paramString2 == null || paramString2.equals("")); 
/*  847 */     if (paramString2 == null)
/*  848 */       return paramString1.equals(""); 
/*  849 */     return paramString1.equals(paramString2);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void copyGlobalElementToLocalElement(SchemaGlobalElement paramSchemaGlobalElement, SchemaLocalElementImpl paramSchemaLocalElementImpl) {
/*  855 */     paramSchemaLocalElementImpl.setNameAndTypeRef(paramSchemaGlobalElement.getName(), paramSchemaGlobalElement.getType().getRef());
/*  856 */     paramSchemaLocalElementImpl.setNillable(paramSchemaGlobalElement.isNillable());
/*  857 */     paramSchemaLocalElementImpl.setDefault(paramSchemaGlobalElement.getDefaultText(), paramSchemaGlobalElement.isFixed(), ((SchemaGlobalElementImpl)paramSchemaGlobalElement).getParseObject());
/*  858 */     paramSchemaLocalElementImpl.setIdentityConstraints(((SchemaLocalElementImpl)paramSchemaGlobalElement).getIdentityConstraintRefs());
/*  859 */     paramSchemaLocalElementImpl.setBlock(paramSchemaGlobalElement.blockExtension(), paramSchemaGlobalElement.blockRestriction(), paramSchemaGlobalElement.blockSubstitution());
/*  860 */     paramSchemaLocalElementImpl.setAbstract(paramSchemaGlobalElement.isAbstract());
/*  861 */     paramSchemaLocalElementImpl.setTransitionRules(((SchemaParticle)paramSchemaGlobalElement).acceptedStartNames(), ((SchemaParticle)paramSchemaGlobalElement).isSkippable());
/*      */     
/*  863 */     paramSchemaLocalElementImpl.setAnnotation(paramSchemaGlobalElement.getAnnotation());
/*      */   }
/*      */ 
/*      */   
/*      */   public static void copyGlobalAttributeToLocalAttribute(SchemaGlobalAttributeImpl paramSchemaGlobalAttributeImpl, SchemaLocalAttributeImpl paramSchemaLocalAttributeImpl) {
/*  868 */     paramSchemaLocalAttributeImpl.init(paramSchemaGlobalAttributeImpl.getName(), paramSchemaGlobalAttributeImpl.getTypeRef(), paramSchemaGlobalAttributeImpl.getUse(), paramSchemaGlobalAttributeImpl.getDefaultText(), paramSchemaGlobalAttributeImpl.getParseObject(), paramSchemaGlobalAttributeImpl._defaultValue, paramSchemaGlobalAttributeImpl.isFixed(), paramSchemaGlobalAttributeImpl.getWSDLArrayType(), paramSchemaGlobalAttributeImpl.getAnnotation(), null);
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
/*      */   public static SchemaLocalElementImpl translateElement(Element paramElement, String paramString1, boolean paramBoolean, String paramString2, String paramString3, List paramList, SchemaType paramSchemaType) {
/*      */     b b2;
/*      */     SchemaLocalElementImpl schemaLocalElementImpl;
/*      */     LocalSimpleType localSimpleType;
/*  887 */     StscState stscState = StscState.get();
/*      */     
/*  889 */     SchemaTypeImpl schemaTypeImpl = null;
/*      */ 
/*      */     
/*  892 */     if (paramElement.isSetSubstitutionGroup()) {
/*      */       
/*  894 */       schemaTypeImpl = stscState.findDocumentType(paramElement.getSubstitutionGroup(), ((SchemaTypeImpl)paramSchemaType).getChameleonNamespace(), paramString1);
/*      */ 
/*      */       
/*  897 */       if (schemaTypeImpl != null) {
/*  898 */         StscResolver.resolveType(schemaTypeImpl);
/*      */       }
/*      */     } 
/*  901 */     String str1 = paramElement.getName();
/*  902 */     b b1 = paramElement.getRef();
/*      */ 
/*      */     
/*  905 */     if (b1 != null && str1 != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  910 */       stscState.error("src-element.2.1a", new Object[] { str1 }, (XmlObject)paramElement.xgetRef());
/*      */       
/*  912 */       str1 = null;
/*      */     } 
/*  914 */     if (b1 == null && str1 == null) {
/*      */       
/*  916 */       stscState.error("src-element.2.1b", (Object[])null, (XmlObject)paramElement);
/*      */       
/*  918 */       return null;
/*      */     } 
/*  920 */     if (str1 != null && !XMLChar.isValidNCName(str1))
/*      */     {
/*  922 */       stscState.error("invalid-value", new Object[] { str1, "name" }, (XmlObject)paramElement.xgetName());
/*      */     }
/*      */ 
/*      */     
/*  926 */     if (b1 != null) {
/*      */       
/*  928 */       if (paramElement.getType() != null)
/*      */       {
/*  930 */         stscState.error("src-element.2.2", new Object[] { "type" }, (XmlObject)paramElement.xgetType());
/*      */       }
/*      */ 
/*      */       
/*  934 */       if (paramElement.getSimpleType() != null)
/*      */       {
/*  936 */         stscState.error("src-element.2.2", new Object[] { "<simpleType>" }, (XmlObject)paramElement.getSimpleType());
/*      */       }
/*      */ 
/*      */       
/*  940 */       if (paramElement.getComplexType() != null)
/*      */       {
/*  942 */         stscState.error("src-element.2.2", new Object[] { "<complexType>" }, (XmlObject)paramElement.getComplexType());
/*      */       }
/*      */ 
/*      */       
/*  946 */       if (paramElement.getForm() != null)
/*      */       {
/*  948 */         stscState.error("src-element.2.2", new Object[] { "form" }, (XmlObject)paramElement.xgetForm());
/*      */       }
/*      */ 
/*      */       
/*  952 */       if (paramElement.sizeOfKeyArray() > 0)
/*      */       {
/*  954 */         stscState.warning("src-element.2.2", new Object[] { "<key>" }, (XmlObject)paramElement);
/*      */       }
/*      */ 
/*      */       
/*  958 */       if (paramElement.sizeOfKeyrefArray() > 0)
/*      */       {
/*  960 */         stscState.warning("src-element.2.2", new Object[] { "<keyref>" }, (XmlObject)paramElement);
/*      */       }
/*      */ 
/*      */       
/*  964 */       if (paramElement.sizeOfUniqueArray() > 0)
/*      */       {
/*  966 */         stscState.warning("src-element.2.2", new Object[] { "<unique>" }, (XmlObject)paramElement);
/*      */       }
/*      */ 
/*      */       
/*  970 */       if (paramElement.isSetDefault())
/*      */       {
/*  972 */         stscState.warning("src-element.2.2", new Object[] { "default" }, (XmlObject)paramElement.xgetDefault());
/*      */       }
/*      */ 
/*      */       
/*  976 */       if (paramElement.isSetFixed())
/*      */       {
/*  978 */         stscState.warning("src-element.2.2", new Object[] { "fixed" }, (XmlObject)paramElement.xgetFixed());
/*      */       }
/*      */ 
/*      */       
/*  982 */       if (paramElement.isSetBlock())
/*      */       {
/*  984 */         stscState.warning("src-element.2.2", new Object[] { "block" }, (XmlObject)paramElement.xgetBlock());
/*      */       }
/*      */ 
/*      */       
/*  988 */       if (paramElement.isSetNillable())
/*      */       {
/*  990 */         stscState.warning("src-element.2.2", new Object[] { "nillable" }, (XmlObject)paramElement.xgetNillable());
/*      */       }
/*      */ 
/*      */       
/*  994 */       assert paramElement instanceof org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
/*  995 */       SchemaGlobalElementImpl schemaGlobalElementImpl = stscState.findGlobalElement(b1, paramBoolean ? paramString1 : null, paramString1);
/*  996 */       if (schemaGlobalElementImpl == null) {
/*      */         
/*  998 */         stscState.notFoundError(b1, 1, (XmlObject)paramElement.xgetRef(), true);
/*      */         
/* 1000 */         return null;
/*      */       } 
/* 1002 */       schemaLocalElementImpl = new SchemaLocalElementImpl();
/* 1003 */       schemaLocalElementImpl.setParticleType(4);
/* 1004 */       schemaLocalElementImpl.setUserData(getUserData((XmlObject)paramElement));
/* 1005 */       copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl);
/* 1006 */       return schemaLocalElementImpl;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1011 */     SchemaType schemaType = null;
/*      */     
/* 1013 */     if (paramElement instanceof org.apache.xmlbeans.impl.xb.xsdschema.LocalElement) {
/*      */       
/* 1015 */       schemaLocalElementImpl = new SchemaLocalElementImpl();
/* 1016 */       boolean bool6 = false;
/* 1017 */       FormChoice formChoice = paramElement.xgetForm();
/* 1018 */       if (formChoice != null) {
/* 1019 */         bool6 = formChoice.getStringValue().equals("qualified");
/* 1020 */       } else if (paramString2 != null) {
/* 1021 */         bool6 = paramString2.equals("qualified");
/*      */       } else {
/*      */         
/* 1024 */         formChoice = findElementFormDefault((XmlObject)paramElement);
/* 1025 */         bool6 = (formChoice != null && formChoice.getStringValue().equals("qualified"));
/*      */       } 
/*      */       
/* 1028 */       b2 = bool6 ? QNameHelper.forLNS(str1, paramString1) : QNameHelper.forLN(str1);
/*      */     }
/*      */     else {
/*      */       
/* 1032 */       SchemaGlobalElementImpl schemaGlobalElementImpl = new SchemaGlobalElementImpl(stscState.getContainer(paramString1));
/* 1033 */       schemaLocalElementImpl = schemaGlobalElementImpl;
/*      */ 
/*      */       
/* 1036 */       if (schemaTypeImpl != null) {
/*      */         
/* 1038 */         SchemaGlobalElementImpl schemaGlobalElementImpl1 = stscState.findGlobalElement(paramElement.getSubstitutionGroup(), paramBoolean ? paramString1 : null, paramString1);
/* 1039 */         if (schemaGlobalElementImpl1 != null) {
/* 1040 */           schemaGlobalElementImpl.setSubstitutionGroup(schemaGlobalElementImpl1.getRef());
/*      */         }
/*      */       } 
/*      */       
/* 1044 */       b2 = QNameHelper.forLNS(str1, paramString1);
/* 1045 */       SchemaTypeImpl schemaTypeImpl1 = (SchemaTypeImpl)paramSchemaType;
/*      */       
/* 1047 */       b[] arrayOfB = schemaTypeImpl1.getSubstitutionGroupMembers();
/* 1048 */       QNameSetBuilder qNameSetBuilder = new QNameSetBuilder();
/* 1049 */       qNameSetBuilder.add(b2);
/*      */       byte b7;
/* 1051 */       for (b7 = 0; b7 < arrayOfB.length; b7++) {
/*      */         
/* 1053 */         schemaGlobalElementImpl.addSubstitutionGroupMember(arrayOfB[b7]);
/* 1054 */         qNameSetBuilder.add(arrayOfB[b7]);
/*      */       } 
/*      */       
/* 1057 */       schemaLocalElementImpl.setTransitionRules(QNameSet.forSpecification((QNameSetSpecification)qNameSetBuilder), false);
/* 1058 */       schemaLocalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
/*      */       
/* 1060 */       b7 = 0;
/* 1061 */       boolean bool6 = false;
/* 1062 */       Object object1 = paramElement.getFinal();
/* 1063 */       if (object1 != null)
/*      */       {
/* 1065 */         if (object1 instanceof String && object1.equals("#all")) {
/*      */ 
/*      */           
/* 1068 */           b7 = bool6 = true;
/*      */         }
/* 1070 */         else if (object1 instanceof List) {
/*      */           
/* 1072 */           if (((List)object1).contains("extension"))
/* 1073 */             b7 = 1; 
/* 1074 */           if (((List)object1).contains("restriction")) {
/* 1075 */             bool6 = true;
/*      */           }
/*      */         } 
/*      */       }
/* 1079 */       schemaGlobalElementImpl.setFinal(b7, bool6);
/* 1080 */       schemaGlobalElementImpl.setAbstract(paramElement.getAbstract());
/* 1081 */       schemaGlobalElementImpl.setFilename(findFilename((XmlObject)paramElement));
/* 1082 */       schemaGlobalElementImpl.setParseContext((XmlObject)paramElement, paramString1, paramBoolean);
/*      */     } 
/*      */     
/* 1085 */     SchemaAnnotationImpl schemaAnnotationImpl = SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString1), (Annotated)paramElement);
/* 1086 */     schemaLocalElementImpl.setAnnotation(schemaAnnotationImpl);
/* 1087 */     schemaLocalElementImpl.setUserData(getUserData((XmlObject)paramElement));
/* 1088 */     if (paramElement.getType() != null) {
/*      */       
/* 1090 */       schemaType = stscState.findGlobalType(paramElement.getType(), paramBoolean ? paramString1 : null, paramString1);
/* 1091 */       if (schemaType == null) {
/* 1092 */         stscState.notFoundError(paramElement.getType(), 0, (XmlObject)paramElement.xgetType(), true);
/*      */       }
/*      */     } 
/* 1095 */     boolean bool1 = false;
/* 1096 */     LocalComplexType localComplexType = paramElement.getComplexType();
/* 1097 */     if (localComplexType == null) {
/*      */       
/* 1099 */       localSimpleType = paramElement.getSimpleType();
/* 1100 */       bool1 = true;
/*      */     } 
/*      */     
/* 1103 */     if (schemaType != null && localSimpleType != null) {
/*      */       
/* 1105 */       stscState.error("src-element.3", (Object[])null, (XmlObject)localSimpleType);
/* 1106 */       localSimpleType = null;
/*      */     } 
/*      */     
/* 1109 */     if (localSimpleType != null) {
/*      */       
/* 1111 */       Object[] arrayOfObject = stscState.getCurrentProcessing();
/* 1112 */       b[] arrayOfB = new b[arrayOfObject.length];
/* 1113 */       for (byte b7 = 0; b7 < arrayOfB.length; b7++) {
/* 1114 */         if (arrayOfObject[b7] instanceof SchemaModelGroupImpl)
/* 1115 */           arrayOfB[b7] = ((SchemaModelGroupImpl)arrayOfObject[b7]).getName(); 
/* 1116 */       }  SchemaType schemaType1 = checkRecursiveGroupReference(arrayOfB, b2, (SchemaTypeImpl)paramSchemaType);
/* 1117 */       if (schemaType1 != null) {
/* 1118 */         SchemaType schemaType2 = schemaType1;
/*      */       } else {
/*      */         
/* 1121 */         SchemaTypeImpl schemaTypeImpl1 = new SchemaTypeImpl(stscState.getContainer(paramString1));
/* 1122 */         schemaType = schemaTypeImpl1;
/* 1123 */         schemaTypeImpl1.setContainerField((SchemaField)schemaLocalElementImpl);
/* 1124 */         schemaTypeImpl1.setOuterSchemaTypeRef((paramSchemaType == null) ? null : paramSchemaType.getRef());
/* 1125 */         schemaTypeImpl1.setGroupReferenceContext(arrayOfB);
/*      */         
/* 1127 */         paramList.add((SchemaTypeImpl)schemaType);
/* 1128 */         schemaTypeImpl1.setSimpleType(bool1);
/* 1129 */         schemaTypeImpl1.setParseContext((XmlObject)localSimpleType, paramString1, paramBoolean, paramString2, paramString3, false);
/*      */         
/* 1131 */         schemaTypeImpl1.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString1), (Annotated)localSimpleType));
/* 1132 */         schemaTypeImpl1.setUserData(getUserData((XmlObject)localSimpleType));
/*      */       } 
/*      */     } 
/*      */     
/* 1136 */     if (schemaType == null)
/*      */     {
/*      */       
/* 1139 */       if (schemaTypeImpl != null) {
/*      */         
/* 1141 */         SchemaGlobalElementImpl schemaGlobalElementImpl = stscState.findGlobalElement(paramElement.getSubstitutionGroup(), paramBoolean ? paramString1 : null, paramString1);
/*      */ 
/*      */ 
/*      */         
/* 1145 */         if (schemaGlobalElementImpl != null) {
/* 1146 */           schemaType = schemaGlobalElementImpl.getType();
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1153 */     if (schemaType == null) {
/* 1154 */       schemaType = BuiltinSchemaTypeSystem.ST_ANY_TYPE;
/*      */     }
/* 1156 */     SOAPArrayType sOAPArrayType = null;
/* 1157 */     XmlCursor xmlCursor = paramElement.newCursor();
/* 1158 */     String str2 = xmlCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
/* 1159 */     xmlCursor.dispose();
/* 1160 */     if (str2 != null) {
/*      */       
/*      */       try {
/*      */         
/* 1164 */         sOAPArrayType = new SOAPArrayType(str2, (PrefixResolver)new NamespaceContext((XmlObject)paramElement));
/*      */       }
/* 1166 */       catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */         
/* 1168 */         stscState.error("soaparray", new Object[] { str2 }, (XmlObject)paramElement);
/*      */       } 
/*      */     }
/* 1171 */     schemaLocalElementImpl.setWsdlArrayType(sOAPArrayType);
/*      */     
/* 1173 */     boolean bool = paramElement.isSetFixed();
/* 1174 */     if (paramElement.isSetDefault() && bool) {
/*      */       
/* 1176 */       stscState.error("src-element.1", (Object[])null, (XmlObject)paramElement.xgetFixed());
/*      */       
/* 1178 */       bool = false;
/*      */     } 
/* 1180 */     schemaLocalElementImpl.setParticleType(4);
/* 1181 */     schemaLocalElementImpl.setNameAndTypeRef(b2, schemaType.getRef());
/* 1182 */     schemaLocalElementImpl.setNillable(paramElement.getNillable());
/* 1183 */     schemaLocalElementImpl.setDefault(bool ? paramElement.getFixed() : paramElement.getDefault(), bool, (XmlObject)paramElement);
/*      */     
/* 1185 */     Object object = paramElement.getBlock();
/* 1186 */     boolean bool2 = false;
/* 1187 */     boolean bool3 = false;
/* 1188 */     boolean bool4 = false;
/*      */     
/* 1190 */     if (object != null)
/*      */     {
/* 1192 */       if (object instanceof String && object.equals("#all")) {
/*      */ 
/*      */         
/* 1195 */         bool2 = bool3 = bool4 = true;
/*      */       }
/* 1197 */       else if (object instanceof List) {
/*      */         
/* 1199 */         if (((List)object).contains("extension"))
/* 1200 */           bool2 = true; 
/* 1201 */         if (((List)object).contains("restriction"))
/* 1202 */           bool3 = true; 
/* 1203 */         if (((List)object).contains("substitution")) {
/* 1204 */           bool4 = true;
/*      */         }
/*      */       } 
/*      */     }
/* 1208 */     schemaLocalElementImpl.setBlock(bool2, bool3, bool4);
/*      */     
/* 1210 */     boolean bool5 = false;
/*      */ 
/*      */ 
/*      */     
/* 1214 */     int i = paramElement.sizeOfKeyArray() + paramElement.sizeOfKeyrefArray() + paramElement.sizeOfUniqueArray();
/* 1215 */     SchemaIdentityConstraintImpl[] arrayOfSchemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl[i];
/* 1216 */     byte b3 = 0;
/*      */ 
/*      */     
/* 1219 */     Keybase[] arrayOfKeybase1 = paramElement.getKeyArray();
/* 1220 */     for (byte b4 = 0; b4 < arrayOfKeybase1.length; b4++, b3++) {
/* 1221 */       arrayOfSchemaIdentityConstraintImpl[b3] = translateIdentityConstraint(arrayOfKeybase1[b4], paramString1, paramBoolean);
/* 1222 */       if (arrayOfSchemaIdentityConstraintImpl[b3] != null) {
/* 1223 */         arrayOfSchemaIdentityConstraintImpl[b3].setConstraintCategory(1);
/*      */       } else {
/* 1225 */         bool5 = true;
/*      */       } 
/*      */     } 
/*      */     
/* 1229 */     Keybase[] arrayOfKeybase2 = paramElement.getUniqueArray();
/* 1230 */     for (byte b5 = 0; b5 < arrayOfKeybase2.length; b5++, b3++) {
/* 1231 */       arrayOfSchemaIdentityConstraintImpl[b3] = translateIdentityConstraint(arrayOfKeybase2[b5], paramString1, paramBoolean);
/* 1232 */       if (arrayOfSchemaIdentityConstraintImpl[b3] != null) {
/* 1233 */         arrayOfSchemaIdentityConstraintImpl[b3].setConstraintCategory(3);
/*      */       } else {
/* 1235 */         bool5 = true;
/*      */       } 
/*      */     } 
/*      */     
/* 1239 */     KeyrefDocument.Keyref[] arrayOfKeyref = paramElement.getKeyrefArray();
/* 1240 */     for (byte b6 = 0; b6 < arrayOfKeyref.length; b6++, b3++) {
/* 1241 */       arrayOfSchemaIdentityConstraintImpl[b3] = translateIdentityConstraint((Keybase)arrayOfKeyref[b6], paramString1, paramBoolean);
/* 1242 */       if (arrayOfSchemaIdentityConstraintImpl[b3] != null) {
/* 1243 */         arrayOfSchemaIdentityConstraintImpl[b3].setConstraintCategory(2);
/*      */       } else {
/* 1245 */         bool5 = true;
/*      */       } 
/*      */     } 
/* 1248 */     if (!bool5) {
/*      */       
/* 1250 */       SchemaIdentityConstraint.Ref[] arrayOfRef = new SchemaIdentityConstraint.Ref[i];
/* 1251 */       for (byte b7 = 0; b7 < arrayOfRef.length; b7++) {
/* 1252 */         arrayOfRef[b7] = arrayOfSchemaIdentityConstraintImpl[b7].getRef();
/*      */       }
/* 1254 */       schemaLocalElementImpl.setIdentityConstraints(arrayOfRef);
/*      */     } 
/*      */     
/* 1257 */     return schemaLocalElementImpl;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static SchemaType checkRecursiveGroupReference(b[] paramArrayOfb, b paramb, SchemaTypeImpl paramSchemaTypeImpl) {
/* 1285 */     if (paramArrayOfb.length < 1)
/* 1286 */       return null; 
/* 1287 */     SchemaTypeImpl schemaTypeImpl = paramSchemaTypeImpl;
/*      */     
/* 1289 */     while (schemaTypeImpl != null) {
/*      */       
/* 1291 */       if (schemaTypeImpl.getName() != null || schemaTypeImpl.isDocumentType())
/* 1292 */         return null; 
/* 1293 */       if (paramb.equals(schemaTypeImpl.getContainerField().getName())) {
/*      */         
/* 1295 */         b[] arrayOfB = schemaTypeImpl.getGroupReferenceContext();
/* 1296 */         if (arrayOfB != null && arrayOfB.length == paramArrayOfb.length) {
/*      */ 
/*      */           
/* 1299 */           boolean bool = true;
/* 1300 */           for (byte b1 = 0; b1 < paramArrayOfb.length; b1++) {
/* 1301 */             if ((paramArrayOfb[b1] != null || arrayOfB[b1] != null) && (paramArrayOfb[b1] == null || !paramArrayOfb[b1].equals(arrayOfB[b1]))) {
/*      */ 
/*      */               
/* 1304 */               bool = false; break;
/*      */             } 
/*      */           } 
/* 1307 */           if (bool)
/* 1308 */             return schemaTypeImpl; 
/*      */         } 
/*      */       } 
/* 1311 */       schemaTypeImpl = (SchemaTypeImpl)schemaTypeImpl.getOuterType();
/*      */     } 
/* 1313 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String removeWhitespace(String paramString) {
/* 1318 */     StringBuffer stringBuffer = new StringBuffer();
/* 1319 */     for (byte b1 = 0; b1 < paramString.length(); b1++) {
/*      */       
/* 1321 */       char c = paramString.charAt(b1);
/* 1322 */       if (!XMLChar.isSpace(c))
/*      */       {
/* 1324 */         stringBuffer.append(c); } 
/*      */     } 
/* 1326 */     return stringBuffer.toString();
/*      */   }
/*      */   
/* 1329 */   public static final RegularExpression XPATH_REGEXP = new RegularExpression("(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*))))(\\|(\\.//)?((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)/)*((((child::)?((\\i\\c*:)?(\\i\\c*|\\*)))|\\.)|((attribute::|@)((\\i\\c*:)?(\\i\\c*|\\*)))))*", "X");
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private static boolean checkXPathSyntax(String paramString) {
/* 1333 */     if (paramString == null) {
/* 1334 */       return false;
/*      */     }
/*      */     
/* 1337 */     paramString = removeWhitespace(paramString);
/*      */ 
/*      */     
/* 1340 */     synchronized (XPATH_REGEXP) {
/*      */       
/* 1342 */       return XPATH_REGEXP.matches(paramString);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static SchemaIdentityConstraintImpl translateIdentityConstraint(Keybase paramKeybase, String paramString, boolean paramBoolean) {
/* 1349 */     StscState stscState = StscState.get();
/*      */ 
/*      */     
/* 1352 */     String str = (paramKeybase.getSelector() == null) ? null : paramKeybase.getSelector().getXpath();
/* 1353 */     if (!checkXPathSyntax(str)) {
/*      */       
/* 1355 */       stscState.error("c-selector-xpath", new Object[] { str }, (XmlObject)paramKeybase.getSelector().xgetXpath());
/* 1356 */       return null;
/*      */     } 
/*      */     
/* 1359 */     FieldDocument.Field[] arrayOfField = paramKeybase.getFieldArray();
/* 1360 */     for (byte b1 = 0; b1 < arrayOfField.length; b1++) {
/*      */       
/* 1362 */       if (!checkXPathSyntax(arrayOfField[b1].getXpath())) {
/*      */         
/* 1364 */         stscState.error("c-fields-xpaths", new Object[] { arrayOfField[b1].getXpath() }, (XmlObject)arrayOfField[b1].xgetXpath());
/* 1365 */         return null;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1370 */     SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = new SchemaIdentityConstraintImpl(stscState.getContainer(paramString));
/* 1371 */     schemaIdentityConstraintImpl.setName(QNameHelper.forLNS(paramKeybase.getName(), paramString));
/* 1372 */     schemaIdentityConstraintImpl.setSelector(paramKeybase.getSelector().getXpath());
/* 1373 */     schemaIdentityConstraintImpl.setParseContext((XmlObject)paramKeybase, paramString, paramBoolean);
/* 1374 */     SchemaAnnotationImpl schemaAnnotationImpl = SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString), (Annotated)paramKeybase);
/* 1375 */     schemaIdentityConstraintImpl.setAnnotation(schemaAnnotationImpl);
/* 1376 */     schemaIdentityConstraintImpl.setUserData(getUserData((XmlObject)paramKeybase));
/*      */ 
/*      */     
/* 1379 */     XmlCursor xmlCursor = paramKeybase.newCursor();
/* 1380 */     HashMap hashMap = new HashMap();
/*      */     
/* 1382 */     xmlCursor.getAllNamespaces(hashMap);
/* 1383 */     hashMap.remove("");
/* 1384 */     schemaIdentityConstraintImpl.setNSMap(hashMap);
/* 1385 */     xmlCursor.dispose();
/*      */     
/* 1387 */     String[] arrayOfString = new String[arrayOfField.length];
/* 1388 */     for (byte b2 = 0; b2 < arrayOfString.length; b2++)
/* 1389 */       arrayOfString[b2] = arrayOfField[b2].getXpath(); 
/* 1390 */     schemaIdentityConstraintImpl.setFields(arrayOfString);
/*      */     
/*      */     try {
/* 1393 */       schemaIdentityConstraintImpl.buildPaths();
/*      */     }
/* 1395 */     catch (org.apache.xmlbeans.impl.common.XPath.XPathCompileException xPathCompileException) {
/* 1396 */       stscState.error("invalid-xpath", new Object[] { xPathCompileException.getMessage() }, (XmlObject)paramKeybase);
/* 1397 */       return null;
/*      */     } 
/*      */     
/* 1400 */     stscState.addIdConstraint(schemaIdentityConstraintImpl);
/* 1401 */     schemaIdentityConstraintImpl.setFilename(findFilename((XmlObject)paramKeybase));
/*      */     
/* 1403 */     return stscState.findIdConstraint(schemaIdentityConstraintImpl.getName(), paramString, null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static SchemaModelGroupImpl translateModelGroup(NamedGroup paramNamedGroup, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 1409 */     String str = paramNamedGroup.getName();
/* 1410 */     if (str == null) {
/*      */       
/* 1412 */       StscState.get().error("missing-name", new Object[] { "model group" }, (XmlObject)paramNamedGroup);
/* 1413 */       return null;
/*      */     } 
/* 1415 */     SchemaContainer schemaContainer = StscState.get().getContainer(paramString);
/* 1416 */     SchemaModelGroupImpl schemaModelGroupImpl = new SchemaModelGroupImpl(schemaContainer);
/* 1417 */     SchemaAnnotationImpl schemaAnnotationImpl = SchemaAnnotationImpl.getAnnotation(schemaContainer, (Annotated)paramNamedGroup);
/* 1418 */     FormChoice formChoice1 = findElementFormDefault((XmlObject)paramNamedGroup);
/* 1419 */     FormChoice formChoice2 = findAttributeFormDefault((XmlObject)paramNamedGroup);
/* 1420 */     schemaModelGroupImpl.init(QNameHelper.forLNS(str, paramString), paramString, paramBoolean1, (formChoice1 == null) ? null : formChoice1.getStringValue(), (formChoice2 == null) ? null : formChoice2.getStringValue(), paramBoolean2, (XmlObject)paramNamedGroup, schemaAnnotationImpl, getUserData((XmlObject)paramNamedGroup));
/*      */ 
/*      */ 
/*      */     
/* 1424 */     schemaModelGroupImpl.setFilename(findFilename((XmlObject)paramNamedGroup));
/* 1425 */     return schemaModelGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   public static SchemaAttributeGroupImpl translateAttributeGroup(AttributeGroup paramAttributeGroup, String paramString, boolean paramBoolean1, boolean paramBoolean2) {
/* 1430 */     String str = paramAttributeGroup.getName();
/* 1431 */     if (str == null) {
/*      */       
/* 1433 */       StscState.get().error("missing-name", new Object[] { "attribute group" }, (XmlObject)paramAttributeGroup);
/* 1434 */       return null;
/*      */     } 
/* 1436 */     SchemaContainer schemaContainer = StscState.get().getContainer(paramString);
/* 1437 */     SchemaAttributeGroupImpl schemaAttributeGroupImpl = new SchemaAttributeGroupImpl(schemaContainer);
/* 1438 */     SchemaAnnotationImpl schemaAnnotationImpl = SchemaAnnotationImpl.getAnnotation(schemaContainer, (Annotated)paramAttributeGroup);
/* 1439 */     FormChoice formChoice = findAttributeFormDefault((XmlObject)paramAttributeGroup);
/* 1440 */     schemaAttributeGroupImpl.init(QNameHelper.forLNS(str, paramString), paramString, paramBoolean1, (formChoice == null) ? null : formChoice.getStringValue(), paramBoolean2, (XmlObject)paramAttributeGroup, schemaAnnotationImpl, getUserData((XmlObject)paramAttributeGroup));
/*      */ 
/*      */     
/* 1443 */     schemaAttributeGroupImpl.setFilename(findFilename((XmlObject)paramAttributeGroup));
/* 1444 */     return schemaAttributeGroupImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   static FormChoice findAttributeFormDefault(XmlObject paramXmlObject) {
/* 1449 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 1450 */     while (xmlCursor.getObject().schemaType() != SchemaDocument.Schema.type) {
/* 1451 */       if (!xmlCursor.toParent())
/* 1452 */         return null; 
/* 1453 */     }  return ((SchemaDocument.Schema)xmlCursor.getObject()).xgetAttributeFormDefault();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static SchemaLocalAttributeImpl translateAttribute(Attribute paramAttribute, String paramString1, String paramString2, boolean paramBoolean1, List paramList, SchemaType paramSchemaType, SchemaAttributeModel paramSchemaAttributeModel, boolean paramBoolean2) {
/*      */     b b2;
/*      */     SchemaLocalAttributeImpl schemaLocalAttributeImpl;
/* 1461 */     StscState stscState = StscState.get();
/*      */     
/* 1463 */     String str1 = paramAttribute.getName();
/* 1464 */     b b1 = paramAttribute.getRef();
/*      */     
/* 1466 */     if (b1 != null && str1 != null) {
/*      */       
/* 1468 */       if (str1.equals(b1.dT()) && uriMatch(paramString1, b1.getNamespaceURI())) {
/* 1469 */         stscState.warning("src-attribute.3.1a", new Object[] { str1 }, (XmlObject)paramAttribute.xgetRef());
/*      */       } else {
/* 1471 */         stscState.error("src-attribute.3.1a", new Object[] { str1 }, (XmlObject)paramAttribute.xgetRef());
/*      */       } 
/* 1473 */       str1 = null;
/*      */     } 
/* 1475 */     if (b1 == null && str1 == null) {
/*      */       
/* 1477 */       stscState.error("src-attribute.3.1b", (Object[])null, (XmlObject)paramAttribute);
/*      */       
/* 1479 */       return null;
/*      */     } 
/* 1481 */     if (str1 != null && !XMLChar.isValidNCName(str1))
/*      */     {
/* 1483 */       stscState.error("invalid-value", new Object[] { str1, "name" }, (XmlObject)paramAttribute.xgetName());
/*      */     }
/*      */ 
/*      */     
/* 1487 */     boolean bool = false;
/* 1488 */     String str2 = null;
/* 1489 */     String str3 = null;
/*      */ 
/*      */     
/* 1492 */     SchemaType schemaType = null;
/* 1493 */     int i = 2;
/*      */     
/* 1495 */     if (paramBoolean2) {
/* 1496 */       schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/*      */     } else {
/*      */       
/* 1499 */       schemaLocalAttributeImpl = new SchemaGlobalAttributeImpl(StscState.get().getContainer(paramString1));
/* 1500 */       schemaLocalAttributeImpl.setParseContext((XmlObject)paramAttribute, paramString1, paramBoolean1);
/*      */     } 
/*      */     
/* 1503 */     if (b1 != null) {
/*      */       
/* 1505 */       if (paramAttribute.getType() != null)
/*      */       {
/* 1507 */         stscState.error("src-attribute.3.2", new Object[] { "type" }, (XmlObject)paramAttribute.xgetType());
/*      */       }
/*      */ 
/*      */       
/* 1511 */       if (paramAttribute.getSimpleType() != null)
/*      */       {
/* 1513 */         stscState.error("src-attribute.3.2", new Object[] { "<simpleType>" }, (XmlObject)paramAttribute.getSimpleType());
/*      */       }
/*      */ 
/*      */       
/* 1517 */       if (paramAttribute.getForm() != null)
/*      */       {
/* 1519 */         stscState.error("src-attribute.3.2", new Object[] { "form" }, (XmlObject)paramAttribute.xgetForm());
/*      */       }
/*      */ 
/*      */       
/* 1523 */       SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = stscState.findGlobalAttribute(b1, paramBoolean1 ? paramString1 : null, paramString1);
/* 1524 */       if (schemaGlobalAttributeImpl == null) {
/*      */         
/* 1526 */         stscState.notFoundError(b1, 3, (XmlObject)paramAttribute.xgetRef(), true);
/*      */         
/* 1528 */         return null;
/*      */       } 
/*      */       
/* 1531 */       b2 = b1;
/* 1532 */       i = schemaGlobalAttributeImpl.getUse();
/* 1533 */       schemaType = schemaGlobalAttributeImpl.getType();
/* 1534 */       str2 = schemaGlobalAttributeImpl.getDefaultText();
/* 1535 */       if (str2 != null) {
/*      */         
/* 1537 */         bool = schemaGlobalAttributeImpl.isFixed();
/* 1538 */         if (bool) {
/* 1539 */           str3 = str2;
/*      */         }
/*      */       } 
/*      */     } else {
/*      */       
/* 1544 */       if (paramBoolean2) {
/*      */         
/* 1546 */         boolean bool1 = false;
/* 1547 */         FormChoice formChoice = paramAttribute.xgetForm();
/* 1548 */         if (formChoice != null) {
/* 1549 */           bool1 = formChoice.getStringValue().equals("qualified");
/* 1550 */         } else if (paramString2 != null) {
/* 1551 */           bool1 = paramString2.equals("qualified");
/*      */         } else {
/*      */           
/* 1554 */           formChoice = findAttributeFormDefault((XmlObject)paramAttribute);
/* 1555 */           bool1 = (formChoice != null && formChoice.getStringValue().equals("qualified"));
/*      */         } 
/*      */         
/* 1558 */         b2 = bool1 ? QNameHelper.forLNS(str1, paramString1) : QNameHelper.forLN(str1);
/*      */       }
/*      */       else {
/*      */         
/* 1562 */         b2 = QNameHelper.forLNS(str1, paramString1);
/*      */       } 
/*      */       
/* 1565 */       if (paramAttribute.getType() != null) {
/*      */         
/* 1567 */         schemaType = stscState.findGlobalType(paramAttribute.getType(), paramBoolean1 ? paramString1 : null, paramString1);
/* 1568 */         if (schemaType == null) {
/* 1569 */           stscState.notFoundError(paramAttribute.getType(), 0, (XmlObject)paramAttribute.xgetType(), true);
/*      */         }
/*      */       } 
/* 1572 */       if (b2.getNamespaceURI().equals("http://www.w3.org/2001/XMLSchema-instance"))
/*      */       {
/* 1574 */         stscState.error("no-xsi", new Object[] { "http://www.w3.org/2001/XMLSchema-instance" }, (XmlObject)paramAttribute.xgetName());
/*      */       }
/*      */       
/* 1577 */       if (b2.getNamespaceURI().length() == 0 && b2.dT().equals("xmlns"))
/*      */       {
/* 1579 */         stscState.error("no-xmlns", (Object[])null, (XmlObject)paramAttribute.xgetName());
/*      */       }
/*      */       
/* 1582 */       LocalSimpleType localSimpleType = paramAttribute.getSimpleType();
/*      */       
/* 1584 */       if (schemaType != null && localSimpleType != null) {
/*      */         
/* 1586 */         stscState.error("src-attribute.4", (Object[])null, (XmlObject)localSimpleType);
/* 1587 */         localSimpleType = null;
/*      */       } 
/*      */       
/* 1590 */       if (localSimpleType != null) {
/*      */         
/* 1592 */         SchemaTypeImpl schemaTypeImpl = new SchemaTypeImpl(stscState.getContainer(paramString1));
/* 1593 */         schemaType = schemaTypeImpl;
/* 1594 */         schemaTypeImpl.setContainerField((SchemaField)schemaLocalAttributeImpl);
/* 1595 */         schemaTypeImpl.setOuterSchemaTypeRef((paramSchemaType == null) ? null : paramSchemaType.getRef());
/*      */         
/* 1597 */         paramList.add(schemaType);
/* 1598 */         schemaTypeImpl.setSimpleType(true);
/* 1599 */         schemaTypeImpl.setParseContext((XmlObject)localSimpleType, paramString1, paramBoolean1, null, null, false);
/* 1600 */         schemaTypeImpl.setAnnotation(SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString1), (Annotated)localSimpleType));
/* 1601 */         schemaTypeImpl.setUserData(getUserData((XmlObject)localSimpleType));
/*      */       } 
/*      */       
/* 1604 */       if (schemaType == null && paramSchemaAttributeModel != null && paramSchemaAttributeModel.getAttribute(b2) != null) {
/* 1605 */         schemaType = paramSchemaAttributeModel.getAttribute(b2).getType();
/*      */       }
/*      */     } 
/* 1608 */     if (schemaType == null) {
/* 1609 */       schemaType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/* 1611 */     if (!schemaType.isSimpleType()) {
/*      */ 
/*      */       
/* 1614 */       stscState.error("Attributes must have a simple type (not complex).", 46, (XmlObject)paramAttribute);
/*      */       
/* 1616 */       schemaType = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     } 
/*      */     
/* 1619 */     if (paramAttribute.isSetUse()) {
/*      */       
/* 1621 */       i = translateUseCode(paramAttribute.xgetUse());
/*      */ 
/*      */       
/* 1624 */       if (i != 2 && !bool) {
/* 1625 */         str2 = null;
/*      */       }
/*      */     } 
/* 1628 */     if (paramAttribute.isSetDefault() || paramAttribute.isSetFixed()) {
/*      */       
/* 1630 */       if (bool && !paramAttribute.isSetFixed()) {
/* 1631 */         stscState.error("A use of a fixed attribute definition must also be fixed", 9, (XmlObject)paramAttribute.xgetFixed());
/*      */       }
/* 1633 */       bool = paramAttribute.isSetFixed();
/*      */       
/* 1635 */       if (paramAttribute.isSetDefault() && bool) {
/*      */         
/* 1637 */         stscState.error("src-attribute.1", (Object[])null, (XmlObject)paramAttribute.xgetFixed());
/*      */         
/* 1639 */         bool = false;
/*      */       } 
/* 1641 */       str2 = bool ? paramAttribute.getFixed() : paramAttribute.getDefault();
/*      */ 
/*      */       
/* 1644 */       if (str3 != null && !str3.equals(str2)) {
/*      */         
/* 1646 */         stscState.error("au-value_constraint", (Object[])null, (XmlObject)paramAttribute.xgetFixed());
/*      */         
/* 1648 */         str2 = str3;
/*      */       } 
/*      */     } 
/*      */     
/* 1652 */     if (!paramBoolean2)
/*      */     {
/* 1654 */       ((SchemaGlobalAttributeImpl)schemaLocalAttributeImpl).setFilename(findFilename((XmlObject)paramAttribute));
/*      */     }
/*      */     
/* 1657 */     SOAPArrayType sOAPArrayType = null;
/* 1658 */     XmlCursor xmlCursor = paramAttribute.newCursor();
/* 1659 */     String str4 = xmlCursor.getAttributeText(WSDL_ARRAYTYPE_NAME);
/* 1660 */     xmlCursor.dispose();
/* 1661 */     if (str4 != null) {
/*      */       
/*      */       try {
/*      */         
/* 1665 */         sOAPArrayType = new SOAPArrayType(str4, (PrefixResolver)new NamespaceContext((XmlObject)paramAttribute));
/*      */       }
/* 1667 */       catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */         
/* 1669 */         stscState.error("soaparray", new Object[] { str4 }, (XmlObject)paramAttribute);
/*      */       } 
/*      */     }
/*      */     
/* 1673 */     SchemaAnnotationImpl schemaAnnotationImpl = SchemaAnnotationImpl.getAnnotation(stscState.getContainer(paramString1), (Annotated)paramAttribute);
/* 1674 */     schemaLocalAttributeImpl.init(b2, schemaType.getRef(), i, str2, (XmlObject)paramAttribute, null, bool, sOAPArrayType, schemaAnnotationImpl, getUserData((XmlObject)paramAttribute));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1681 */     return schemaLocalAttributeImpl;
/*      */   }
/*      */ 
/*      */   
/*      */   static int translateUseCode(Attribute.Use paramUse) {
/* 1686 */     if (paramUse == null) {
/* 1687 */       return 2;
/*      */     }
/* 1689 */     String str = paramUse.getStringValue();
/* 1690 */     if (str.equals("optional"))
/* 1691 */       return 2; 
/* 1692 */     if (str.equals("required"))
/* 1693 */       return 3; 
/* 1694 */     if (str.equals("prohibited"))
/* 1695 */       return 1; 
/* 1696 */     return 2;
/*      */   }
/*      */   
/*      */   static BigInteger buildBigInt(XmlAnySimpleType paramXmlAnySimpleType) {
/*      */     BigInteger bigInteger;
/* 1701 */     if (paramXmlAnySimpleType == null)
/* 1702 */       return null; 
/* 1703 */     String str = paramXmlAnySimpleType.getStringValue();
/*      */ 
/*      */     
/*      */     try {
/* 1707 */       bigInteger = new BigInteger(str);
/*      */     }
/* 1709 */     catch (NumberFormatException numberFormatException) {
/*      */       
/* 1711 */       StscState.get().error("invalid-value-detail", new Object[] { str, "nonNegativeInteger", numberFormatException.getMessage() }, (XmlObject)paramXmlAnySimpleType);
/* 1712 */       return null;
/*      */     } 
/*      */     
/* 1715 */     if (bigInteger.signum() < 0) {
/*      */       
/* 1717 */       StscState.get().error("invalid-value", new Object[] { str, "nonNegativeInteger" }, (XmlObject)paramXmlAnySimpleType);
/* 1718 */       return null;
/*      */     } 
/*      */     
/* 1721 */     return bigInteger;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static XmlNonNegativeInteger buildNnInteger(XmlAnySimpleType paramXmlAnySimpleType) {
/* 1727 */     BigInteger bigInteger = buildBigInt(paramXmlAnySimpleType);
/*      */     
/*      */     try {
/* 1730 */       XmlNonNegativeIntegerImpl xmlNonNegativeIntegerImpl = new XmlNonNegativeIntegerImpl();
/* 1731 */       xmlNonNegativeIntegerImpl.set(bigInteger);
/* 1732 */       xmlNonNegativeIntegerImpl.setImmutable();
/* 1733 */       return (XmlNonNegativeInteger)xmlNonNegativeIntegerImpl;
/*      */     }
/* 1735 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/* 1737 */       StscState.get().error("Internal error processing number", 21, (XmlObject)paramXmlAnySimpleType);
/* 1738 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   static XmlPositiveInteger buildPosInteger(XmlAnySimpleType paramXmlAnySimpleType) {
/* 1744 */     BigInteger bigInteger = buildBigInt(paramXmlAnySimpleType);
/*      */     
/*      */     try {
/* 1747 */       XmlPositiveIntegerImpl xmlPositiveIntegerImpl = new XmlPositiveIntegerImpl();
/* 1748 */       xmlPositiveIntegerImpl.set(bigInteger);
/* 1749 */       xmlPositiveIntegerImpl.setImmutable();
/* 1750 */       return (XmlPositiveInteger)xmlPositiveIntegerImpl;
/*      */     }
/* 1752 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */       
/* 1754 */       StscState.get().error("Internal error processing number", 21, (XmlObject)paramXmlAnySimpleType);
/* 1755 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static Object getUserData(XmlObject paramXmlObject) {
/* 1762 */     XmlCursor.XmlBookmark xmlBookmark = paramXmlObject.newCursor().getBookmark(SchemaBookmark.class);
/* 1763 */     if (xmlBookmark != null && xmlBookmark instanceof SchemaBookmark) {
/* 1764 */       return ((SchemaBookmark)xmlBookmark).getValue();
/*      */     }
/* 1766 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isEmptySchema(SchemaDocument.Schema paramSchema) {
/* 1771 */     XmlCursor xmlCursor = paramSchema.newCursor();
/* 1772 */     boolean bool = !xmlCursor.toFirstChild() ? true : false;
/* 1773 */     xmlCursor.dispose();
/* 1774 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isReservedTypeName(b paramb) {
/* 1779 */     return (BuiltinSchemaTypeSystem.get().findType(paramb) != null);
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscTranslator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */