/*     */ package org.apache.xmlbeans.impl.inst2xsd.util;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.Collection;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ComplexType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Element;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalComplexType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalElement;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NoFixedFacet;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleContentDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleExtensionType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class TypeSystemHolder
/*     */ {
/*  41 */   Map _globalElements = new LinkedHashMap();
/*  42 */   Map _globalAttributes = new LinkedHashMap();
/*  43 */   Map _globalTypes = new LinkedHashMap();
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public void addGlobalElement(Element paramElement) {
/*  48 */     assert paramElement.isGlobal() && !paramElement.isRef();
/*  49 */     this._globalElements.put(paramElement.getName(), paramElement);
/*     */   }
/*     */ 
/*     */   
/*     */   public Element getGlobalElement(b paramb) {
/*  54 */     return (Element)this._globalElements.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public Element[] getGlobalElements() {
/*  59 */     Collection collection = this._globalElements.values();
/*  60 */     return (Element[])collection.toArray((Object[])new Element[collection.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addGlobalAttribute(Attribute paramAttribute) {
/*  65 */     assert paramAttribute.isGlobal() && !paramAttribute.isRef();
/*  66 */     this._globalAttributes.put(paramAttribute.getName(), paramAttribute);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute getGlobalAttribute(b paramb) {
/*  71 */     return (Attribute)this._globalAttributes.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public Attribute[] getGlobalAttributes() {
/*  76 */     Collection collection = this._globalAttributes.values();
/*  77 */     return (Attribute[])collection.toArray((Object[])new Attribute[collection.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addGlobalType(Type paramType) {
/*  82 */     assert paramType.isGlobal() && paramType.getName() != null : "type must be a global type before being added.";
/*  83 */     this._globalTypes.put(paramType.getName(), paramType);
/*     */   }
/*     */ 
/*     */   
/*     */   public Type getGlobalType(b paramb) {
/*  88 */     return (Type)this._globalTypes.get(paramb);
/*     */   }
/*     */ 
/*     */   
/*     */   public Type[] getGlobalTypes() {
/*  93 */     Collection collection = this._globalTypes.values();
/*  94 */     return (Type[])collection.toArray((Object[])new Type[collection.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SchemaDocument[] getSchemaDocuments() {
/* 100 */     LinkedHashMap linkedHashMap = new LinkedHashMap();
/*     */     
/* 102 */     for (b b : this._globalElements.keySet()) {
/*     */ 
/*     */       
/* 105 */       String str = b.getNamespaceURI();
/* 106 */       SchemaDocument schemaDocument = getSchemaDocumentForTNS(linkedHashMap, str);
/*     */       
/* 108 */       fillUpGlobalElement((Element)this._globalElements.get(b), schemaDocument, str);
/*     */     } 
/*     */     
/* 111 */     for (b b : this._globalAttributes.keySet()) {
/*     */ 
/*     */       
/* 114 */       String str = b.getNamespaceURI();
/* 115 */       SchemaDocument schemaDocument = getSchemaDocumentForTNS(linkedHashMap, str);
/*     */       
/* 117 */       fillUpGlobalAttribute((Attribute)this._globalAttributes.get(b), schemaDocument, str);
/*     */     } 
/*     */     
/* 120 */     for (b b : this._globalTypes.keySet()) {
/*     */ 
/*     */       
/* 123 */       String str = b.getNamespaceURI();
/* 124 */       SchemaDocument schemaDocument = getSchemaDocumentForTNS(linkedHashMap, str);
/*     */       
/* 126 */       fillUpGlobalType((Type)this._globalTypes.get(b), schemaDocument, str);
/*     */     } 
/*     */     
/* 129 */     Collection collection = linkedHashMap.values();
/* 130 */     return (SchemaDocument[])collection.toArray((Object[])new SchemaDocument[collection.size()]);
/*     */   }
/*     */ 
/*     */   
/*     */   private static SchemaDocument getSchemaDocumentForTNS(Map paramMap, String paramString) {
/* 135 */     SchemaDocument schemaDocument = (SchemaDocument)paramMap.get(paramString);
/* 136 */     if (schemaDocument == null) {
/*     */       
/* 138 */       schemaDocument = SchemaDocument.Factory.newInstance();
/* 139 */       paramMap.put(paramString, schemaDocument);
/*     */     } 
/* 141 */     return schemaDocument;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static SchemaDocument.Schema getTopLevelSchemaElement(SchemaDocument paramSchemaDocument, String paramString) {
/* 147 */     SchemaDocument.Schema schema = paramSchemaDocument.getSchema();
/* 148 */     if (schema == null) {
/*     */       
/* 150 */       schema = paramSchemaDocument.addNewSchema();
/* 151 */       schema.setAttributeFormDefault(FormChoice.Enum.forString("unqualified"));
/* 152 */       schema.setElementFormDefault(FormChoice.Enum.forString("qualified"));
/* 153 */       if (!paramString.equals(""))
/* 154 */         schema.setTargetNamespace(paramString); 
/*     */     } 
/* 156 */     return schema;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillUpGlobalElement(Element paramElement, SchemaDocument paramSchemaDocument, String paramString) {
/* 162 */     assert paramString.equals(paramElement.getName().getNamespaceURI());
/*     */     
/* 164 */     SchemaDocument.Schema schema = getTopLevelSchemaElement(paramSchemaDocument, paramString);
/*     */     
/* 166 */     TopLevelElement topLevelElement = schema.addNewElement();
/* 167 */     topLevelElement.setName(paramElement.getName().dT());
/*     */     
/* 169 */     if (paramElement.isNillable()) {
/* 170 */       topLevelElement.setNillable(paramElement.isNillable());
/*     */     }
/* 172 */     fillUpElementDocumentation((Element)topLevelElement, paramElement.getComment());
/*     */     
/* 174 */     Type type = paramElement.getType();
/* 175 */     fillUpTypeOnElement(type, (Element)topLevelElement, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fillUpLocalElement(Element paramElement, LocalElement paramLocalElement, String paramString) {
/* 180 */     fillUpElementDocumentation((Element)paramLocalElement, paramElement.getComment());
/* 181 */     if (!paramElement.isRef()) {
/*     */       
/* 183 */       assert paramElement.getName().getNamespaceURI().equals(paramString) || paramElement.getName().getNamespaceURI().length() == 0;
/*     */       
/* 185 */       fillUpTypeOnElement(paramElement.getType(), (Element)paramLocalElement, paramString);
/* 186 */       paramLocalElement.setName(paramElement.getName().dT());
/*     */     }
/*     */     else {
/*     */       
/* 190 */       paramLocalElement.setRef(paramElement.getName());
/* 191 */       assert !paramElement.isNillable();
/*     */     } 
/*     */     
/* 194 */     if (paramElement.getMaxOccurs() == -1)
/*     */     {
/* 196 */       paramLocalElement.setMaxOccurs("unbounded");
/*     */     }
/* 198 */     if (paramElement.getMinOccurs() != 1)
/*     */     {
/* 200 */       paramLocalElement.setMinOccurs(new BigInteger("" + paramElement.getMinOccurs()));
/*     */     }
/*     */     
/* 203 */     if (paramElement.isNillable()) {
/* 204 */       paramLocalElement.setNillable(paramElement.isNillable());
/*     */     }
/*     */   }
/*     */   
/*     */   private void fillUpTypeOnElement(Type paramType, Element paramElement, String paramString) {
/* 209 */     if (paramType.isGlobal()) {
/*     */       
/* 211 */       assert paramType.getName() != null : "Global type must have a name.";
/* 212 */       paramElement.setType(paramType.getName());
/*     */     }
/* 214 */     else if (paramType.getContentType() == 1) {
/*     */       
/* 216 */       if (paramType.isEnumeration()) {
/* 217 */         fillUpEnumeration(paramType, paramElement);
/*     */       } else {
/* 219 */         paramElement.setType(paramType.getName());
/*     */       } 
/*     */     } else {
/*     */       
/* 223 */       LocalComplexType localComplexType = paramElement.addNewComplexType();
/* 224 */       fillUpContentForComplexType(paramType, (ComplexType)localComplexType, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void fillUpEnumeration(Type paramType, Element paramElement) {
/* 230 */     assert paramType.isEnumeration() && !paramType.isComplexType() : "Enumerations must be on simple types only.";
/* 231 */     RestrictionDocument.Restriction restriction = paramElement.addNewSimpleType().addNewRestriction();
/* 232 */     restriction.setBase(paramType.getName());
/* 233 */     if (paramType.isQNameEnumeration()) {
/*     */       
/* 235 */       for (byte b = 0; b < paramType.getEnumerationQNames().size(); b++)
/*     */       {
/* 237 */         b b1 = paramType.getEnumerationQNames().get(b);
/* 238 */         XmlQName xmlQName = XmlQName.Factory.newValue(b1);
/*     */         
/* 240 */         NoFixedFacet noFixedFacet = restriction.addNewEnumeration();
/* 241 */         XmlCursor xmlCursor = noFixedFacet.newCursor();
/*     */         
/* 243 */         String str = xmlCursor.prefixForNamespace(b1.getNamespaceURI());
/* 244 */         xmlCursor.dispose();
/*     */         
/* 246 */         noFixedFacet.setValue((XmlAnySimpleType)XmlQName.Factory.newValue(new b(b1.getNamespaceURI(), b1.dT(), str)));
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 252 */       for (byte b = 0; b < paramType.getEnumerationValues().size(); b++) {
/*     */         
/* 254 */         String str = paramType.getEnumerationValues().get(b);
/* 255 */         restriction.addNewEnumeration().setValue((XmlAnySimpleType)XmlString.Factory.newValue(str));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillUpAttributesInComplexTypesSimpleContent(Type paramType, SimpleExtensionType paramSimpleExtensionType, String paramString) {
/* 263 */     for (byte b = 0; b < paramType.getAttributes().size(); b++) {
/*     */       
/* 265 */       Attribute attribute = paramType.getAttributes().get(b);
/* 266 */       Attribute attribute1 = paramSimpleExtensionType.addNewAttribute();
/* 267 */       fillUpLocalAttribute(attribute, attribute1, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillUpAttributesInComplexTypesComplexContent(Type paramType, ComplexType paramComplexType, String paramString) {
/* 274 */     for (byte b = 0; b < paramType.getAttributes().size(); b++) {
/*     */       
/* 276 */       Attribute attribute = paramType.getAttributes().get(b);
/* 277 */       Attribute attribute1 = paramComplexType.addNewAttribute();
/* 278 */       fillUpLocalAttribute(attribute, attribute1, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void fillUpLocalAttribute(Attribute paramAttribute, Attribute paramAttribute1, String paramString) {
/* 284 */     if (paramAttribute.isRef()) {
/*     */       
/* 286 */       paramAttribute1.setRef(paramAttribute.getRef().getName());
/*     */     }
/*     */     else {
/*     */       
/* 290 */       assert paramAttribute.getName().getNamespaceURI() == paramString || paramAttribute.getName().getNamespaceURI().equals("");
/* 291 */       paramAttribute1.setType(paramAttribute.getType().getName());
/* 292 */       paramAttribute1.setName(paramAttribute.getName().dT());
/* 293 */       if (paramAttribute.isOptional()) {
/* 294 */         paramAttribute1.setUse(Attribute.Use.OPTIONAL);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void fillUpContentForComplexType(Type paramType, ComplexType paramComplexType, String paramString) {
/* 300 */     if (paramType.getContentType() == 2) {
/*     */       
/* 302 */       SimpleContentDocument.SimpleContent simpleContent = paramComplexType.addNewSimpleContent();
/*     */       
/* 304 */       assert paramType.getExtensionType() != null && paramType.getExtensionType().getName() != null : "Extension type must exist and be named for a COMPLEX_TYPE_SIMPLE_CONTENT";
/*     */       
/* 306 */       SimpleExtensionType simpleExtensionType = simpleContent.addNewExtension();
/* 307 */       simpleExtensionType.setBase(paramType.getExtensionType().getName());
/*     */       
/* 309 */       fillUpAttributesInComplexTypesSimpleContent(paramType, simpleExtensionType, paramString);
/*     */     } else {
/*     */       ExplicitGroup explicitGroup;
/*     */       
/* 313 */       if (paramType.getContentType() == 4)
/*     */       {
/* 315 */         paramComplexType.setMixed(true);
/*     */       }
/*     */ 
/*     */       
/* 319 */       if (paramType.getContentType() == 5) {
/* 320 */         explicitGroup = null;
/* 321 */       } else if (paramType.getTopParticleForComplexOrMixedContent() == 1) {
/*     */         
/* 323 */         explicitGroup = paramComplexType.addNewSequence();
/*     */       }
/* 325 */       else if (paramType.getTopParticleForComplexOrMixedContent() == 2) {
/*     */         
/* 327 */         explicitGroup = paramComplexType.addNewChoice();
/* 328 */         explicitGroup.setMaxOccurs("unbounded");
/* 329 */         explicitGroup.setMinOccurs(new BigInteger("0"));
/*     */       } else {
/* 331 */         throw new IllegalStateException("Unknown particle type in complex and mixed content");
/*     */       } 
/* 333 */       for (byte b = 0; b < paramType.getElements().size(); b++) {
/*     */         
/* 335 */         Element element = paramType.getElements().get(b);
/* 336 */         assert !element.isGlobal();
/* 337 */         LocalElement localElement = explicitGroup.addNewElement();
/* 338 */         fillUpLocalElement(element, localElement, paramString);
/*     */       } 
/*     */       
/* 341 */       fillUpAttributesInComplexTypesComplexContent(paramType, paramComplexType, paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillUpGlobalAttribute(Attribute paramAttribute, SchemaDocument paramSchemaDocument, String paramString) {
/* 348 */     assert paramString.equals(paramAttribute.getName().getNamespaceURI());
/* 349 */     SchemaDocument.Schema schema = getTopLevelSchemaElement(paramSchemaDocument, paramString);
/*     */     
/* 351 */     TopLevelAttribute topLevelAttribute = schema.addNewAttribute();
/* 352 */     topLevelAttribute.setName(paramAttribute.getName().dT());
/*     */     
/* 354 */     Type type = paramAttribute.getType();
/*     */     
/* 356 */     if (type.getContentType() == 1) {
/*     */       
/* 358 */       topLevelAttribute.setType(type.getName());
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 363 */       throw new IllegalStateException();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void fillUpElementDocumentation(Element paramElement, String paramString) {
/* 369 */     if (paramString != null && paramString.length() > 0) {
/*     */       
/* 371 */       DocumentationDocument.Documentation documentation = paramElement.addNewAnnotation().addNewDocumentation();
/* 372 */       documentation.set((XmlObject)XmlString.Factory.newValue(paramString));
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void fillUpGlobalType(Type paramType, SchemaDocument paramSchemaDocument, String paramString) {
/* 379 */     assert paramString.equals(paramType.getName().getNamespaceURI());
/* 380 */     SchemaDocument.Schema schema = getTopLevelSchemaElement(paramSchemaDocument, paramString);
/*     */     
/* 382 */     TopLevelComplexType topLevelComplexType = schema.addNewComplexType();
/* 383 */     topLevelComplexType.setName(paramType.getName().dT());
/*     */     
/* 385 */     fillUpContentForComplexType(paramType, (ComplexType)topLevelComplexType, paramString);
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 390 */     return "TypeSystemHolder{\n\n_globalElements=" + this._globalElements + "\n\n_globalAttributes=" + this._globalAttributes + "\n\n_globalTypes=" + this._globalTypes + "\n}";
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xs\\util\TypeSystemHolder.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */