/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.QNameSetSpecification;
/*      */ import org.apache.xmlbeans.SchemaAttributeModel;
/*      */ import org.apache.xmlbeans.SchemaGlobalElement;
/*      */ import org.apache.xmlbeans.SchemaIdentityConstraint;
/*      */ import org.apache.xmlbeans.SchemaLocalAttribute;
/*      */ import org.apache.xmlbeans.SchemaLocalElement;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlError;
/*      */ import org.apache.xmlbeans.XmlID;
/*      */ import org.apache.xmlbeans.XmlNOTATION;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.XmlString;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.common.XBeanDebug;
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
/*      */ public class StscChecker
/*      */ {
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   public static void checkAll() {
/*   52 */     StscState stscState = StscState.get();
/*      */     
/*   54 */     ArrayList arrayList = new ArrayList();
/*   55 */     arrayList.addAll(Arrays.asList(stscState.documentTypes()));
/*   56 */     arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
/*   57 */     arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
/*   58 */     arrayList.addAll(Arrays.asList(stscState.globalTypes()));
/*      */     
/*   60 */     for (byte b = 0; b < arrayList.size(); b++) {
/*      */       
/*   62 */       SchemaType schemaType = arrayList.get(b);
/*   63 */       if (!stscState.noPvr() && !schemaType.isDocumentType())
/*      */       {
/*      */         
/*   66 */         checkRestriction((SchemaTypeImpl)schemaType);
/*      */       }
/*   68 */       checkFields((SchemaTypeImpl)schemaType);
/*   69 */       arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
/*      */     } 
/*      */     
/*   72 */     checkSubstitutionGroups(stscState.globalElements());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void checkFields(SchemaTypeImpl paramSchemaTypeImpl) {
/*   82 */     if (paramSchemaTypeImpl.isSimpleType()) {
/*      */       return;
/*      */     }
/*   85 */     XmlObject xmlObject = paramSchemaTypeImpl.getParseObject();
/*      */     
/*   87 */     SchemaAttributeModel schemaAttributeModel = paramSchemaTypeImpl.getAttributeModel();
/*   88 */     if (schemaAttributeModel != null) {
/*      */       
/*   90 */       SchemaLocalAttribute[] arrayOfSchemaLocalAttribute = schemaAttributeModel.getAttributes();
/*   91 */       b b = null;
/*   92 */       for (byte b1 = 0; b1 < arrayOfSchemaLocalAttribute.length; b1++) {
/*      */         
/*   94 */         XmlObject xmlObject1 = ((SchemaLocalAttributeImpl)arrayOfSchemaLocalAttribute[b1])._parseObject;
/*   95 */         if (XmlID.type.isAssignableFrom(arrayOfSchemaLocalAttribute[b1].getType())) {
/*      */           
/*   97 */           if (b == null) {
/*      */             
/*   99 */             b = arrayOfSchemaLocalAttribute[b1].getName();
/*      */           }
/*      */           else {
/*      */             
/*  103 */             StscState.get().error("ag-props-correct.3", new Object[] { QNameHelper.pretty(b), arrayOfSchemaLocalAttribute[b1].getName() }, (xmlObject1 != null) ? xmlObject1 : xmlObject);
/*      */           } 
/*      */ 
/*      */           
/*  107 */           if (arrayOfSchemaLocalAttribute[b1].getDefaultText() != null)
/*      */           {
/*  109 */             StscState.get().error("a-props-correct.3", (Object[])null, (xmlObject1 != null) ? xmlObject1 : xmlObject);
/*      */           
/*      */           }
/*      */         }
/*  113 */         else if (XmlNOTATION.type.isAssignableFrom(arrayOfSchemaLocalAttribute[b1].getType())) {
/*      */           
/*  115 */           if (arrayOfSchemaLocalAttribute[b1].getType().getBuiltinTypeCode() == 8) {
/*      */             
/*  117 */             StscState.get().recover("enumeration-required-notation-attr", new Object[] { QNameHelper.pretty(arrayOfSchemaLocalAttribute[b1].getName()) }, (xmlObject1 != null) ? xmlObject1 : xmlObject);
/*      */           } else {
/*      */             boolean bool;
/*      */ 
/*      */ 
/*      */             
/*  123 */             if (arrayOfSchemaLocalAttribute[b1].getType().getSimpleVariety() == 2) {
/*      */               
/*  125 */               SchemaType[] arrayOfSchemaType = arrayOfSchemaLocalAttribute[b1].getType().getUnionConstituentTypes();
/*  126 */               for (byte b2 = 0; b2 < arrayOfSchemaType.length; b2++) {
/*  127 */                 if (arrayOfSchemaType[b2].getBuiltinTypeCode() == 8) {
/*  128 */                   StscState.get().recover("enumeration-required-notation-attr", new Object[] { QNameHelper.pretty(arrayOfSchemaLocalAttribute[b1].getName()) }, (xmlObject1 != null) ? xmlObject1 : xmlObject);
/*      */                 }
/*      */               } 
/*      */             } 
/*      */ 
/*      */             
/*  134 */             if (paramSchemaTypeImpl.isAttributeType()) {
/*  135 */               bool = (arrayOfSchemaLocalAttribute[b1].getName().getNamespaceURI().length() > 0) ? true : false;
/*      */             } else {
/*      */               
/*  138 */               SchemaType schemaType = paramSchemaTypeImpl;
/*  139 */               while (schemaType.getOuterType() != null)
/*  140 */                 schemaType = schemaType.getOuterType(); 
/*  141 */               if (schemaType.isDocumentType())
/*  142 */               { bool = (schemaType.getDocumentElementName().getNamespaceURI().length() > 0) ? true : false; }
/*  143 */               else { bool = (schemaType.getName().getNamespaceURI().length() > 0) ? true : false; }
/*      */             
/*  145 */             }  if (bool) {
/*  146 */               StscState.get().warning("notation-targetns-attr", new Object[] { QNameHelper.pretty(arrayOfSchemaLocalAttribute[b1].getName()) }, (xmlObject1 != null) ? xmlObject1 : xmlObject);
/*      */             }
/*      */           }
/*      */         
/*      */         }
/*      */         else {
/*      */           
/*  153 */           String str = arrayOfSchemaLocalAttribute[b1].getDefaultText();
/*  154 */           if (str != null) {
/*      */             
/*      */             try {
/*      */               
/*  158 */               XmlAnySimpleType xmlAnySimpleType = arrayOfSchemaLocalAttribute[b1].getDefaultValue();
/*  159 */               if (!xmlAnySimpleType.validate()) {
/*  160 */                 throw new Exception();
/*      */               }
/*  162 */               SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)paramSchemaTypeImpl.getAttributeProperty(arrayOfSchemaLocalAttribute[b1].getName());
/*  163 */               if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null)
/*      */               {
/*  165 */                 schemaPropertyImpl.setDefaultValue(new XmlValueRef(xmlAnySimpleType));
/*      */               }
/*      */             }
/*  168 */             catch (Exception exception) {
/*      */ 
/*      */               
/*  171 */               String str1 = arrayOfSchemaLocalAttribute[b1].isFixed() ? "fixed" : "default";
/*  172 */               XmlObject xmlObject2 = xmlObject;
/*  173 */               if (xmlObject1 != null) {
/*      */                 
/*  175 */                 xmlObject2 = xmlObject1.selectAttribute("", str1);
/*  176 */                 if (xmlObject2 == null) {
/*  177 */                   xmlObject2 = xmlObject1;
/*      */                 }
/*      */               } 
/*  180 */               StscState.get().error("a-props-correct.2", new Object[] { QNameHelper.pretty(arrayOfSchemaLocalAttribute[b1].getName()), str1, str, QNameHelper.pretty(arrayOfSchemaLocalAttribute[b1].getType().getName()) }, xmlObject2);
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  192 */     checkElementDefaults(paramSchemaTypeImpl.getContentModel(), xmlObject, paramSchemaTypeImpl);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void checkElementDefaults(SchemaParticle paramSchemaParticle, XmlObject paramXmlObject, SchemaType paramSchemaType) {
/*      */     SchemaParticle[] arrayOfSchemaParticle;
/*      */     byte b;
/*      */     String str1;
/*      */     String str2;
/*  205 */     if (paramSchemaParticle == null)
/*      */       return; 
/*  207 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       
/*      */       case 1:
/*      */       case 2:
/*      */       case 3:
/*  212 */         arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/*  213 */         for (b = 0; b < arrayOfSchemaParticle.length; b++)
/*      */         {
/*  215 */           checkElementDefaults(arrayOfSchemaParticle[b], paramXmlObject, paramSchemaType);
/*      */         }
/*      */         break;
/*      */       case 4:
/*  219 */         str1 = paramSchemaParticle.getDefaultText();
/*  220 */         if (str1 != null)
/*      */         {
/*  222 */           if (paramSchemaParticle.getType().isSimpleType() || paramSchemaParticle.getType().getContentType() == 2) {
/*      */             
/*      */             try
/*      */             {
/*  226 */               XmlAnySimpleType xmlAnySimpleType = paramSchemaParticle.getDefaultValue();
/*  227 */               XmlOptions xmlOptions = new XmlOptions();
/*  228 */               xmlOptions.put("VALIDATE_TEXT_ONLY");
/*  229 */               if (!xmlAnySimpleType.validate(xmlOptions)) {
/*  230 */                 throw new Exception();
/*      */               }
/*  232 */               SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)paramSchemaType.getElementProperty(paramSchemaParticle.getName());
/*  233 */               if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null)
/*      */               {
/*  235 */                 schemaPropertyImpl.setDefaultValue(new XmlValueRef(xmlAnySimpleType));
/*      */               }
/*      */             }
/*  238 */             catch (Exception exception)
/*      */             {
/*      */               
/*  241 */               String str = paramSchemaParticle.isFixed() ? "fixed" : "default";
/*  242 */               XmlObject xmlObject = paramXmlObject.selectAttribute("", str);
/*      */               
/*  244 */               StscState.get().error("e-props-correct.2", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()), str, str1, QNameHelper.pretty(paramSchemaParticle.getType().getName()) }, (xmlObject == null) ? paramXmlObject : xmlObject);
/*      */ 
/*      */             
/*      */             }
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  252 */           else if (paramSchemaParticle.getType().getContentType() == 4) {
/*      */             
/*  254 */             if (!paramSchemaParticle.getType().getContentModel().isSkippable())
/*      */             {
/*  256 */               String str = paramSchemaParticle.isFixed() ? "fixed" : "default";
/*  257 */               XmlObject xmlObject = paramXmlObject.selectAttribute("", str);
/*      */               
/*  259 */               StscState.get().error("cos-valid-default.2.2.2", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()), str, str1 }, (xmlObject == null) ? paramXmlObject : xmlObject);
/*      */ 
/*      */ 
/*      */             
/*      */             }
/*      */             else
/*      */             {
/*      */ 
/*      */ 
/*      */               
/*  269 */               SchemaPropertyImpl schemaPropertyImpl = (SchemaPropertyImpl)paramSchemaType.getElementProperty(paramSchemaParticle.getName());
/*  270 */               if (schemaPropertyImpl != null && schemaPropertyImpl.getDefaultText() != null)
/*      */               {
/*  272 */                 schemaPropertyImpl.setDefaultValue(new XmlValueRef(XmlString.type.newValue(str1)));
/*      */               }
/*      */             }
/*      */           
/*  276 */           } else if (paramSchemaParticle.getType().getContentType() == 3) {
/*      */             
/*  278 */             XmlObject xmlObject = paramXmlObject.selectAttribute("", "default");
/*  279 */             StscState.get().error("cos-valid-default.2.1", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()), str1, "element" }, (xmlObject == null) ? paramXmlObject : xmlObject);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*      */           }
/*  285 */           else if (paramSchemaParticle.getType().getContentType() == 1) {
/*      */             
/*  287 */             XmlObject xmlObject = paramXmlObject.selectAttribute("", "default");
/*  288 */             StscState.get().error("cos-valid-default.2.1", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()), str1, "empty" }, (xmlObject == null) ? paramXmlObject : xmlObject);
/*      */           } 
/*      */         }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  296 */         str2 = null;
/*  297 */         if (BuiltinSchemaTypeSystem.ST_ID.isAssignableFrom(paramSchemaParticle.getType())) {
/*  298 */           str2 = BuiltinSchemaTypeSystem.ST_ID.getName().dT();
/*  299 */         } else if (BuiltinSchemaTypeSystem.ST_IDREF.isAssignableFrom(paramSchemaParticle.getType())) {
/*  300 */           str2 = BuiltinSchemaTypeSystem.ST_IDREF.getName().dT();
/*  301 */         } else if (BuiltinSchemaTypeSystem.ST_IDREFS.isAssignableFrom(paramSchemaParticle.getType())) {
/*  302 */           str2 = BuiltinSchemaTypeSystem.ST_IDREFS.getName().dT();
/*  303 */         } else if (BuiltinSchemaTypeSystem.ST_ENTITY.isAssignableFrom(paramSchemaParticle.getType())) {
/*  304 */           str2 = BuiltinSchemaTypeSystem.ST_ENTITY.getName().dT();
/*  305 */         } else if (BuiltinSchemaTypeSystem.ST_ENTITIES.isAssignableFrom(paramSchemaParticle.getType())) {
/*  306 */           str2 = BuiltinSchemaTypeSystem.ST_ENTITIES.getName().dT();
/*  307 */         } else if (BuiltinSchemaTypeSystem.ST_NOTATION.isAssignableFrom(paramSchemaParticle.getType())) {
/*      */           boolean bool;
/*  309 */           if (paramSchemaParticle.getType().getBuiltinTypeCode() == 8) {
/*      */             
/*  311 */             StscState.get().recover("enumeration-required-notation-elem", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()) }, (((SchemaLocalElementImpl)paramSchemaParticle)._parseObject == null) ? paramXmlObject : ((SchemaLocalElementImpl)paramSchemaParticle)._parseObject.selectAttribute("", "type"));
/*      */ 
/*      */           
/*      */           }
/*      */           else {
/*      */ 
/*      */             
/*  318 */             if (paramSchemaParticle.getType().getSimpleVariety() == 2) {
/*      */               
/*  320 */               SchemaType[] arrayOfSchemaType = paramSchemaParticle.getType().getUnionConstituentTypes();
/*  321 */               for (byte b1 = 0; b1 < arrayOfSchemaType.length; b1++) {
/*  322 */                 if (arrayOfSchemaType[b1].getBuiltinTypeCode() == 8) {
/*  323 */                   StscState.get().recover("enumeration-required-notation-elem", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()) }, (((SchemaLocalElementImpl)paramSchemaParticle)._parseObject == null) ? paramXmlObject : ((SchemaLocalElementImpl)paramSchemaParticle)._parseObject.selectAttribute("", "type"));
/*      */                 }
/*      */               } 
/*      */             } 
/*      */             
/*  328 */             str2 = BuiltinSchemaTypeSystem.ST_NOTATION.getName().dT();
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  333 */           SchemaType schemaType = paramSchemaType;
/*  334 */           while (schemaType.getOuterType() != null)
/*  335 */             schemaType = schemaType.getOuterType(); 
/*  336 */           if (schemaType.isDocumentType()) {
/*  337 */             bool = (schemaType.getDocumentElementName().getNamespaceURI().length() > 0) ? true : false;
/*      */           } else {
/*  339 */             bool = (schemaType.getName().getNamespaceURI().length() > 0) ? true : false;
/*  340 */           }  if (bool) {
/*  341 */             StscState.get().warning("notation-targetns-elem", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()) }, (((SchemaLocalElementImpl)paramSchemaParticle)._parseObject == null) ? paramXmlObject : ((SchemaLocalElementImpl)paramSchemaParticle)._parseObject);
/*      */           }
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/*  347 */         if (str2 != null) {
/*  348 */           StscState.get().warning("id-idref-idrefs-entity-entities-notation", new Object[] { QNameHelper.pretty(paramSchemaParticle.getName()), str2 }, (((SchemaLocalElementImpl)paramSchemaParticle)._parseObject == null) ? paramXmlObject : ((SchemaLocalElementImpl)paramSchemaParticle)._parseObject.selectAttribute("", "type"));
/*      */         }
/*      */         break;
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
/*      */   public static boolean checkRestriction(SchemaTypeImpl paramSchemaTypeImpl) {
/*  367 */     if (paramSchemaTypeImpl.getDerivationType() == 1 && !paramSchemaTypeImpl.isSimpleType()) {
/*      */       SchemaType schemaType2; SchemaParticle schemaParticle1, schemaParticle2; ArrayList arrayList; boolean bool;
/*  369 */       StscState stscState = StscState.get();
/*      */ 
/*      */       
/*  372 */       XmlObject xmlObject = paramSchemaTypeImpl.getParseObject();
/*      */       
/*  374 */       SchemaType schemaType1 = paramSchemaTypeImpl.getBaseType();
/*  375 */       if (schemaType1.isSimpleType()) {
/*      */         
/*  377 */         stscState.error("src-ct.1", new Object[] { QNameHelper.pretty(schemaType1.getName()) }, xmlObject);
/*      */ 
/*      */         
/*  380 */         return false;
/*      */       } 
/*      */ 
/*      */       
/*  384 */       switch (paramSchemaTypeImpl.getContentType()) {
/*      */ 
/*      */         
/*      */         case 2:
/*  388 */           switch (schemaType1.getContentType()) {
/*      */ 
/*      */             
/*      */             case 2:
/*  392 */               schemaType2 = paramSchemaTypeImpl.getContentBasedOnType();
/*  393 */               if (schemaType2 != schemaType1) {
/*      */ 
/*      */ 
/*      */                 
/*  397 */                 SchemaType schemaType = schemaType1;
/*  398 */                 while (schemaType != null && !schemaType.isSimpleType())
/*  399 */                   schemaType = schemaType.getContentBasedOnType(); 
/*  400 */                 if (schemaType != null && !schemaType.isAssignableFrom(schemaType2)) {
/*      */                   
/*  402 */                   stscState.error("derivation-ok-restriction.5.2.2.1", (Object[])null, xmlObject);
/*      */                   
/*  404 */                   return false;
/*      */                 } 
/*      */               } 
/*      */               break;
/*      */ 
/*      */             
/*      */             case 4:
/*  411 */               if (schemaType1.getContentModel() != null && !schemaType1.getContentModel().isSkippable()) {
/*      */                 
/*  413 */                 stscState.error("derivation-ok-restriction.5.1.2", (Object[])null, xmlObject);
/*      */                 
/*  415 */                 return false;
/*      */               } 
/*      */               break;
/*      */           } 
/*      */           
/*  420 */           stscState.error("derivation-ok-restriction.5.1", (Object[])null, xmlObject);
/*      */           
/*  422 */           return false;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 1:
/*  428 */           switch (schemaType1.getContentType()) {
/*      */             case 1:
/*      */               break;
/*      */ 
/*      */ 
/*      */             
/*      */             case 3:
/*      */             case 4:
/*  436 */               if (schemaType1.getContentModel() != null && !schemaType1.getContentModel().isSkippable()) {
/*      */                 
/*  438 */                 stscState.error("derivation-ok-restriction.5.2.2", (Object[])null, xmlObject);
/*      */                 
/*  440 */                 return false;
/*      */               } 
/*      */               break;
/*      */           } 
/*  444 */           stscState.error("derivation-ok-restriction.5.2", (Object[])null, xmlObject);
/*      */           
/*  446 */           return false;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*      */         case 4:
/*  452 */           if (schemaType1.getContentType() != 4) {
/*      */             
/*  454 */             stscState.error("derivation-ok-restriction.5.3a", (Object[])null, xmlObject);
/*      */             
/*  456 */             return false;
/*      */           } 
/*      */ 
/*      */ 
/*      */         
/*      */         case 3:
/*  462 */           if (schemaType1.getContentType() == 1) {
/*      */             
/*  464 */             stscState.error("derivation-ok-restriction.5.3b", (Object[])null, xmlObject);
/*      */             
/*  466 */             return false;
/*      */           } 
/*  468 */           if (schemaType1.getContentType() == 2) {
/*      */             
/*  470 */             stscState.error("derivation-ok-restriction.5.3c", (Object[])null, xmlObject);
/*      */             
/*  472 */             return false;
/*      */           } 
/*      */ 
/*      */           
/*  476 */           schemaParticle1 = schemaType1.getContentModel();
/*  477 */           schemaParticle2 = paramSchemaTypeImpl.getContentModel();
/*      */           
/*  479 */           if (schemaParticle2 == null && paramSchemaTypeImpl.getDerivationType() == 1)
/*      */           {
/*      */ 
/*      */             
/*  483 */             return true;
/*      */           }
/*  485 */           if (schemaParticle1 == null || schemaParticle2 == null) {
/*      */             
/*  487 */             XBeanDebug.logStackTrace("Null models that weren't caught by EMPTY_CONTENT: " + schemaType1 + " (" + schemaParticle1 + "), " + paramSchemaTypeImpl + " (" + schemaParticle2 + ")");
/*  488 */             stscState.error("derivation-ok-restriction.5.3", (Object[])null, xmlObject);
/*  489 */             return false;
/*      */           } 
/*      */ 
/*      */           
/*  493 */           arrayList = new ArrayList();
/*  494 */           bool = isParticleValidRestriction(schemaParticle1, schemaParticle2, arrayList, xmlObject);
/*  495 */           if (!bool) {
/*      */ 
/*      */ 
/*      */ 
/*      */             
/*  500 */             if (arrayList.size() == 0) {
/*  501 */               stscState.error("derivation-ok-restriction.5.3", (Object[])null, xmlObject);
/*      */             } else {
/*  503 */               stscState.getErrorListener().add(arrayList.get(arrayList.size() - 1));
/*      */             } 
/*  505 */             return false;
/*      */           }  break;
/*      */       } 
/*      */     } 
/*  509 */     return true;
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
/*      */   public static boolean isParticleValidRestriction(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  523 */     boolean bool = false;
/*      */     
/*  525 */     if (paramSchemaParticle1.equals(paramSchemaParticle2))
/*  526 */     { bool = true; }
/*      */     
/*      */     else
/*      */     
/*  530 */     { switch (paramSchemaParticle1.getParticleType())
/*      */       { case 4:
/*  532 */           switch (paramSchemaParticle2.getParticleType())
/*      */           { case 4:
/*  534 */               bool = nameAndTypeOK((SchemaLocalElement)paramSchemaParticle1, (SchemaLocalElement)paramSchemaParticle2, paramCollection, paramXmlObject);
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
/*      */               
/*  636 */               return bool;case 1: case 2: case 3: case 5: paramCollection.add(XmlError.forObject("cos-particle-restrict.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject)); bool = false; return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Derived Type"); return bool;case 5: switch (paramSchemaParticle2.getParticleType()) { case 4: bool = nsCompat(paramSchemaParticle1, (SchemaLocalElement)paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 5: bool = nsSubset(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 1: bool = nsRecurseCheckCardinality(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 2: bool = nsRecurseCheckCardinality(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 3: bool = nsRecurseCheckCardinality(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Derived Type"); return bool;case 1: switch (paramSchemaParticle2.getParticleType()) { case 4: bool = recurseAsIfGroup(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 2: case 5: paramCollection.add(XmlError.forObject("cos-particle-restrict.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject)); bool = false; return bool;case 1: bool = recurse(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 3: bool = recurseUnordered(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Derived Type"); return bool;case 2: switch (paramSchemaParticle2.getParticleType()) { case 4: bool = recurseAsIfGroup(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 1: case 5: paramCollection.add(XmlError.forObject("cos-particle-restrict.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject)); bool = false; return bool;case 2: bool = recurseLax(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 3: bool = mapAndSum(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Derived Type"); return bool;case 3: switch (paramSchemaParticle2.getParticleType()) { case 4: bool = recurseAsIfGroup(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool;case 1: case 2: case 5: paramCollection.add(XmlError.forObject("cos-particle-restrict.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject)); bool = false; return bool;case 3: bool = recurse(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject); return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Derived Type"); return bool; }  assert false : XBeanDebug.logStackTrace("Unknown schema type for Base Type"); }  return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean mapAndSum(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  641 */     assert paramSchemaParticle1.getParticleType() == 2;
/*  642 */     assert paramSchemaParticle2.getParticleType() == 3;
/*  643 */     boolean bool = true;
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
/*  661 */     SchemaParticle[] arrayOfSchemaParticle1 = paramSchemaParticle2.getParticleChildren();
/*  662 */     SchemaParticle[] arrayOfSchemaParticle2 = paramSchemaParticle1.getParticleChildren();
/*  663 */     for (byte b = 0; b < arrayOfSchemaParticle1.length; b++) {
/*  664 */       SchemaParticle schemaParticle = arrayOfSchemaParticle1[b];
/*  665 */       boolean bool1 = false;
/*  666 */       for (byte b1 = 0; b1 < arrayOfSchemaParticle2.length; b1++) {
/*  667 */         SchemaParticle schemaParticle1 = arrayOfSchemaParticle2[b1];
/*      */         
/*  669 */         if (isParticleValidRestriction(schemaParticle1, schemaParticle, paramCollection, paramXmlObject)) {
/*      */           
/*  671 */           bool1 = true;
/*      */           break;
/*      */         } 
/*      */       } 
/*  675 */       if (!bool1) {
/*  676 */         bool = false;
/*  677 */         paramCollection.add(XmlError.forObject("rcase-MapAndSum.1", new Object[] { printParticle(schemaParticle) }, paramXmlObject));
/*      */ 
/*      */ 
/*      */         
/*  681 */         return false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  687 */     BigInteger bigInteger1 = paramSchemaParticle2.getMinOccurs().multiply(BigInteger.valueOf((paramSchemaParticle2.getParticleChildren()).length));
/*  688 */     BigInteger bigInteger2 = null;
/*  689 */     BigInteger bigInteger3 = null;
/*  690 */     if (paramSchemaParticle2.getMaxOccurs() == bigInteger3) {
/*  691 */       bigInteger2 = null;
/*      */     } else {
/*  693 */       bigInteger2 = paramSchemaParticle2.getMaxOccurs().multiply(BigInteger.valueOf((paramSchemaParticle2.getParticleChildren()).length));
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
/*  704 */     if (bigInteger1.compareTo(paramSchemaParticle1.getMinOccurs()) < 0) {
/*  705 */       bool = false;
/*  706 */       paramCollection.add(XmlError.forObject("rcase-MapAndSum.2a", new Object[] { bigInteger1.toString(), paramSchemaParticle1.getMinOccurs().toString() }, paramXmlObject));
/*      */     
/*      */     }
/*  709 */     else if (paramSchemaParticle1.getMaxOccurs() != bigInteger3 && (bigInteger2 == bigInteger3 || bigInteger2.compareTo(paramSchemaParticle1.getMaxOccurs()) > 0)) {
/*  710 */       bool = false;
/*  711 */       paramCollection.add(XmlError.forObject("rcase-MapAndSum.2b", new Object[] { (bigInteger2 == bigInteger3) ? "unbounded" : bigInteger2.toString(), paramSchemaParticle1.getMaxOccurs().toString() }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  716 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean recurseAsIfGroup(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  724 */     assert (paramSchemaParticle1.getParticleType() == 2 && paramSchemaParticle2.getParticleType() == 4) || (paramSchemaParticle1.getParticleType() == 3 && paramSchemaParticle2.getParticleType() == 4);
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
/*  738 */     SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
/*  739 */     schemaParticleImpl.setParticleType(paramSchemaParticle1.getParticleType());
/*  740 */     schemaParticleImpl.setMinOccurs(BigInteger.ONE);
/*  741 */     schemaParticleImpl.setMaxOccurs(BigInteger.ONE);
/*  742 */     schemaParticleImpl.setParticleChildren(new SchemaParticle[] { paramSchemaParticle2 });
/*      */ 
/*      */     
/*  745 */     return isParticleValidRestriction(paramSchemaParticle1, schemaParticleImpl, paramCollection, paramXmlObject);
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean recurseLax(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  750 */     assert paramSchemaParticle1.getParticleType() == 2 && paramSchemaParticle2.getParticleType() == 2;
/*  751 */     boolean bool = true;
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
/*  767 */     if (!occurrenceRangeOK(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject)) {
/*  768 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  773 */     SchemaParticle[] arrayOfSchemaParticle1 = paramSchemaParticle2.getParticleChildren();
/*  774 */     SchemaParticle[] arrayOfSchemaParticle2 = paramSchemaParticle1.getParticleChildren();
/*  775 */     byte b1 = 0, b2 = 0;
/*  776 */     while (b1 < arrayOfSchemaParticle1.length && b2 < arrayOfSchemaParticle2.length) {
/*  777 */       SchemaParticle schemaParticle1 = arrayOfSchemaParticle1[b1];
/*  778 */       SchemaParticle schemaParticle2 = arrayOfSchemaParticle2[b2];
/*      */       
/*  780 */       if (isParticleValidRestriction(schemaParticle2, schemaParticle1, paramCollection, paramXmlObject)) {
/*      */         
/*  782 */         b1++;
/*  783 */         b2++;
/*      */         
/*      */         continue;
/*      */       } 
/*  787 */       b2++;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  794 */     if (b1 < arrayOfSchemaParticle1.length) {
/*  795 */       bool = false;
/*      */ 
/*      */       
/*  798 */       paramCollection.add(XmlError.forObject("rcase-RecurseLax.2", new Object[] { printParticles(arrayOfSchemaParticle2, b1) }paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  804 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean recurseUnordered(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  809 */     assert paramSchemaParticle1.getParticleType() == 1 && paramSchemaParticle2.getParticleType() == 3;
/*  810 */     boolean bool = true;
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
/*  828 */     if (!occurrenceRangeOK(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject)) {
/*  829 */       return false;
/*      */     }
/*      */ 
/*      */     
/*  833 */     SchemaParticle[] arrayOfSchemaParticle1 = paramSchemaParticle1.getParticleChildren();
/*  834 */     HashMap hashMap = new HashMap(10);
/*  835 */     Object object = new Object();
/*      */     
/*  837 */     for (byte b1 = 0; b1 < arrayOfSchemaParticle1.length; b1++) {
/*  838 */       hashMap.put(arrayOfSchemaParticle1[b1].getName(), arrayOfSchemaParticle1[b1]);
/*      */     }
/*      */     
/*  841 */     SchemaParticle[] arrayOfSchemaParticle2 = paramSchemaParticle2.getParticleChildren();
/*  842 */     for (byte b2 = 0; b2 < arrayOfSchemaParticle2.length; b2++) {
/*  843 */       Object object1 = hashMap.get(arrayOfSchemaParticle2[b2].getName());
/*  844 */       if (object1 == null) {
/*  845 */         bool = false;
/*  846 */         paramCollection.add(XmlError.forObject("rcase-RecurseUnordered.2", new Object[] { printParticle(arrayOfSchemaParticle2[b2]) }, paramXmlObject));
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/*  851 */       if (object1 == object) {
/*      */         
/*  853 */         bool = false;
/*  854 */         paramCollection.add(XmlError.forObject("rcase-RecurseUnordered.2.1", new Object[] { printParticle(arrayOfSchemaParticle2[b2]) }, paramXmlObject));
/*      */         
/*      */         break;
/*      */       } 
/*  858 */       SchemaParticle schemaParticle = (SchemaParticle)object1;
/*  859 */       if (arrayOfSchemaParticle2[b2].getMaxOccurs() == null || arrayOfSchemaParticle2[b2].getMaxOccurs().compareTo(BigInteger.ONE) > 0) {
/*      */ 
/*      */         
/*  862 */         bool = false;
/*  863 */         paramCollection.add(XmlError.forObject("rcase-RecurseUnordered.2.2a", new Object[] { printParticle(arrayOfSchemaParticle2[b2]), printMaxOccurs(arrayOfSchemaParticle2[b2].getMinOccurs()) }, paramXmlObject));
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/*  868 */       if (!isParticleValidRestriction(schemaParticle, arrayOfSchemaParticle2[b2], paramCollection, paramXmlObject)) {
/*      */ 
/*      */         
/*  871 */         bool = false;
/*      */         
/*      */         break;
/*      */       } 
/*  875 */       hashMap.put(arrayOfSchemaParticle2[b2].getName(), object);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  881 */     if (bool) {
/*      */       
/*  883 */       Set set = hashMap.keySet();
/*  884 */       for (b b : set) {
/*      */         
/*  886 */         if (hashMap.get(b) != object && !((SchemaParticle)hashMap.get(b)).isSkippable()) {
/*      */           
/*  888 */           bool = false;
/*  889 */           paramCollection.add(XmlError.forObject("rcase-RecurseUnordered.2.3", new Object[] { printParticle((SchemaParticle)hashMap.get(b)) }, paramXmlObject));
/*      */         } 
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  896 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean recurse(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  901 */     boolean bool = true;
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
/*  920 */     if (!occurrenceRangeOK(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject))
/*      */     {
/*  922 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  930 */     SchemaParticle[] arrayOfSchemaParticle1 = paramSchemaParticle2.getParticleChildren();
/*  931 */     SchemaParticle[] arrayOfSchemaParticle2 = paramSchemaParticle1.getParticleChildren();
/*  932 */     byte b1 = 0, b2 = 0;
/*  933 */     while (b1 < arrayOfSchemaParticle1.length && b2 < arrayOfSchemaParticle2.length) {
/*  934 */       SchemaParticle schemaParticle1 = arrayOfSchemaParticle1[b1];
/*  935 */       SchemaParticle schemaParticle2 = arrayOfSchemaParticle2[b2];
/*      */       
/*  937 */       if (isParticleValidRestriction(schemaParticle2, schemaParticle1, paramCollection, paramXmlObject)) {
/*      */         
/*  939 */         b1++;
/*  940 */         b2++;
/*      */         
/*      */         continue;
/*      */       } 
/*  944 */       if (schemaParticle2.isSkippable()) {
/*      */         
/*  946 */         b2++;
/*      */         continue;
/*      */       } 
/*  949 */       bool = false;
/*  950 */       paramCollection.add(XmlError.forObject("rcase-Recurse.2.1", new Object[] { printParticle(schemaParticle1), printParticle(paramSchemaParticle2), printParticle(schemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject));
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
/*  962 */     if (b1 < arrayOfSchemaParticle1.length) {
/*  963 */       bool = false;
/*  964 */       paramCollection.add(XmlError.forObject("rcase-Recurse.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1), printParticles(arrayOfSchemaParticle1, b1) }paramXmlObject));
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  970 */     else if (b2 < arrayOfSchemaParticle2.length) {
/*  971 */       ArrayList arrayList = new ArrayList(arrayOfSchemaParticle2.length);
/*  972 */       for (byte b = b2; b < arrayOfSchemaParticle2.length; b++) {
/*  973 */         if (!arrayOfSchemaParticle2[b].isSkippable()) {
/*  974 */           arrayList.add(arrayOfSchemaParticle2[b]);
/*      */         }
/*      */       } 
/*  977 */       if (arrayList.size() > 0) {
/*      */         
/*  979 */         bool = false;
/*  980 */         paramCollection.add(XmlError.forObject("rcase-Recurse.2.2", new Object[] { printParticle(paramSchemaParticle1), printParticle(paramSchemaParticle2), printParticles(arrayList) }, paramXmlObject));
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  986 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean nsRecurseCheckCardinality(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/*  994 */     assert paramSchemaParticle1.getParticleType() == 5;
/*  995 */     assert paramSchemaParticle2.getParticleType() == 1 || paramSchemaParticle2.getParticleType() == 2 || paramSchemaParticle2.getParticleType() == 3;
/*      */ 
/*      */     
/*  998 */     boolean bool = true;
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
/* 1009 */     SchemaParticleImpl schemaParticleImpl = new SchemaParticleImpl();
/* 1010 */     schemaParticleImpl.setParticleType(paramSchemaParticle1.getParticleType());
/* 1011 */     schemaParticleImpl.setWildcardProcess(paramSchemaParticle1.getWildcardProcess());
/* 1012 */     schemaParticleImpl.setWildcardSet(paramSchemaParticle1.getWildcardSet());
/* 1013 */     schemaParticleImpl.setMinOccurs(BigInteger.ZERO);
/* 1014 */     schemaParticleImpl.setMaxOccurs(null);
/* 1015 */     schemaParticleImpl.setTransitionRules(paramSchemaParticle1.getWildcardSet(), true);
/* 1016 */     schemaParticleImpl.setTransitionNotes(paramSchemaParticle1.getWildcardSet(), true);
/*      */     
/* 1018 */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle2.getParticleChildren();
/* 1019 */     for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 1020 */       SchemaParticle schemaParticle = arrayOfSchemaParticle[b];
/* 1021 */       switch (schemaParticle.getParticleType()) {
/*      */         
/*      */         case 4:
/* 1024 */           bool = nsCompat(schemaParticleImpl, (SchemaLocalElement)schemaParticle, paramCollection, paramXmlObject);
/*      */           break;
/*      */         
/*      */         case 5:
/* 1028 */           bool = nsSubset(schemaParticleImpl, schemaParticle, paramCollection, paramXmlObject);
/*      */           break;
/*      */         
/*      */         case 1:
/*      */         case 2:
/*      */         case 3:
/* 1034 */           bool = nsRecurseCheckCardinality(schemaParticleImpl, schemaParticle, paramCollection, paramXmlObject);
/*      */           break;
/*      */       } 
/*      */       
/* 1038 */       if (!bool) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1047 */     if (bool) {
/* 1048 */       bool = checkGroupOccurrenceOK(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject);
/*      */     }
/*      */     
/* 1051 */     return bool;
/*      */   }
/*      */   
/*      */   private static boolean checkGroupOccurrenceOK(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1055 */     boolean bool = true;
/* 1056 */     BigInteger bigInteger1 = BigInteger.ZERO;
/* 1057 */     BigInteger bigInteger2 = BigInteger.ZERO;
/* 1058 */     switch (paramSchemaParticle2.getParticleType()) {
/*      */       case 1:
/*      */       case 3:
/* 1061 */         bigInteger1 = getEffectiveMinRangeAllSeq(paramSchemaParticle2);
/* 1062 */         bigInteger2 = getEffectiveMaxRangeAllSeq(paramSchemaParticle2);
/*      */         break;
/*      */       case 2:
/* 1065 */         bigInteger1 = getEffectiveMinRangeChoice(paramSchemaParticle2);
/* 1066 */         bigInteger2 = getEffectiveMaxRangeChoice(paramSchemaParticle2);
/*      */         break;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1072 */     if (bigInteger1.compareTo(paramSchemaParticle1.getMinOccurs()) < 0) {
/* 1073 */       bool = false;
/* 1074 */       paramCollection.add(XmlError.forObject("range-ok.1", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1082 */     BigInteger bigInteger3 = null;
/* 1083 */     if (paramSchemaParticle1.getMaxOccurs() != bigInteger3) {
/* 1084 */       if (bigInteger2 == bigInteger3) {
/* 1085 */         bool = false;
/* 1086 */         paramCollection.add(XmlError.forObject("range-ok.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject));
/*      */ 
/*      */       
/*      */       }
/* 1090 */       else if (bigInteger2.compareTo(paramSchemaParticle1.getMaxOccurs()) > 0) {
/* 1091 */         bool = false;
/* 1092 */         paramCollection.add(XmlError.forObject("range-ok.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject));
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1098 */     return bool;
/*      */   }
/*      */   
/*      */   private static BigInteger getEffectiveMaxRangeChoice(SchemaParticle paramSchemaParticle) {
/* 1102 */     BigInteger bigInteger1 = BigInteger.ZERO;
/* 1103 */     BigInteger bigInteger2 = null;
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
/* 1118 */     boolean bool = false;
/* 1119 */     BigInteger bigInteger3 = BigInteger.ZERO;
/* 1120 */     BigInteger bigInteger4 = BigInteger.ZERO;
/* 1121 */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1122 */     for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 1123 */       SchemaParticle schemaParticle = arrayOfSchemaParticle[b];
/* 1124 */       switch (schemaParticle.getParticleType()) {
/*      */         
/*      */         case 4:
/*      */         case 5:
/* 1128 */           if (schemaParticle.getMaxOccurs() == bigInteger2) {
/* 1129 */             bigInteger1 = bigInteger2; break;
/*      */           } 
/* 1131 */           if (schemaParticle.getIntMaxOccurs() > 0) {
/*      */             
/* 1133 */             bool = true;
/* 1134 */             if (schemaParticle.getMaxOccurs().compareTo(bigInteger3) > 0) {
/* 1135 */               bigInteger3 = schemaParticle.getMaxOccurs();
/*      */             }
/*      */           } 
/*      */           break;
/*      */         
/*      */         case 1:
/*      */         case 3:
/* 1142 */           bigInteger1 = getEffectiveMaxRangeAllSeq(schemaParticle);
/* 1143 */           if (bigInteger1 != bigInteger2)
/*      */           {
/* 1145 */             if (bigInteger1.compareTo(bigInteger4) > 0) {
/* 1146 */               bigInteger4 = bigInteger1;
/*      */             }
/*      */           }
/*      */           break;
/*      */         case 2:
/* 1151 */           bigInteger1 = getEffectiveMaxRangeChoice(schemaParticle);
/* 1152 */           if (bigInteger1 != bigInteger2)
/*      */           {
/* 1154 */             if (bigInteger1.compareTo(bigInteger4) > 0) {
/* 1155 */               bigInteger4 = bigInteger1;
/*      */             }
/*      */           }
/*      */           break;
/*      */       } 
/*      */       
/* 1161 */       if (bigInteger1 == bigInteger2) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1169 */     if (bigInteger1 != bigInteger2)
/*      */     {
/* 1171 */       if (bool && paramSchemaParticle.getMaxOccurs() == bigInteger2) {
/* 1172 */         bigInteger1 = bigInteger2;
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1177 */         bigInteger1 = paramSchemaParticle.getMaxOccurs().multiply(bigInteger3.add(bigInteger4));
/*      */       } 
/*      */     }
/*      */     
/* 1181 */     return bigInteger1;
/*      */   }
/*      */   
/*      */   private static BigInteger getEffectiveMaxRangeAllSeq(SchemaParticle paramSchemaParticle) {
/* 1185 */     BigInteger bigInteger1 = BigInteger.ZERO;
/* 1186 */     BigInteger bigInteger2 = null;
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
/* 1198 */     boolean bool = false;
/* 1199 */     BigInteger bigInteger3 = BigInteger.ZERO;
/* 1200 */     BigInteger bigInteger4 = BigInteger.ZERO;
/* 1201 */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1202 */     for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 1203 */       SchemaParticle schemaParticle = arrayOfSchemaParticle[b];
/* 1204 */       switch (schemaParticle.getParticleType()) {
/*      */         
/*      */         case 4:
/*      */         case 5:
/* 1208 */           if (schemaParticle.getMaxOccurs() == bigInteger2) {
/* 1209 */             bigInteger1 = bigInteger2; break;
/*      */           } 
/* 1211 */           if (schemaParticle.getIntMaxOccurs() > 0) {
/*      */             
/* 1213 */             bool = true;
/* 1214 */             bigInteger3 = bigInteger3.add(schemaParticle.getMaxOccurs());
/*      */           } 
/*      */           break;
/*      */         
/*      */         case 1:
/*      */         case 3:
/* 1220 */           bigInteger1 = getEffectiveMaxRangeAllSeq(schemaParticle);
/* 1221 */           if (bigInteger1 != bigInteger2)
/*      */           {
/* 1223 */             if (bigInteger1.compareTo(bigInteger4) > 0) {
/* 1224 */               bigInteger4 = bigInteger1;
/*      */             }
/*      */           }
/*      */           break;
/*      */         case 2:
/* 1229 */           bigInteger1 = getEffectiveMaxRangeChoice(schemaParticle);
/* 1230 */           if (bigInteger1 != bigInteger2)
/*      */           {
/* 1232 */             if (bigInteger1.compareTo(bigInteger4) > 0) {
/* 1233 */               bigInteger4 = bigInteger1;
/*      */             }
/*      */           }
/*      */           break;
/*      */       } 
/*      */       
/* 1239 */       if (bigInteger1 == bigInteger2) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1247 */     if (bigInteger1 != bigInteger2)
/*      */     {
/* 1249 */       if (bool && paramSchemaParticle.getMaxOccurs() == bigInteger2) {
/* 1250 */         bigInteger1 = bigInteger2;
/*      */       
/*      */       }
/*      */       else {
/*      */         
/* 1255 */         bigInteger1 = paramSchemaParticle.getMaxOccurs().multiply(bigInteger3.add(bigInteger4));
/*      */       } 
/*      */     }
/*      */     
/* 1259 */     return bigInteger1;
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
/*      */   private static BigInteger getEffectiveMinRangeChoice(SchemaParticle paramSchemaParticle) {
/* 1272 */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1273 */     if (arrayOfSchemaParticle.length == 0)
/* 1274 */       return BigInteger.ZERO; 
/* 1275 */     BigInteger bigInteger = null;
/*      */ 
/*      */     
/* 1278 */     for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 1279 */       BigInteger bigInteger1, bigInteger2; SchemaParticle schemaParticle = arrayOfSchemaParticle[b];
/* 1280 */       switch (schemaParticle.getParticleType()) {
/*      */         case 4:
/*      */         case 5:
/* 1283 */           if (bigInteger == null || bigInteger.compareTo(schemaParticle.getMinOccurs()) > 0) {
/* 1284 */             bigInteger = schemaParticle.getMinOccurs();
/*      */           }
/*      */           break;
/*      */         case 1:
/*      */         case 3:
/* 1289 */           bigInteger1 = getEffectiveMinRangeAllSeq(schemaParticle);
/* 1290 */           if (bigInteger == null || bigInteger.compareTo(bigInteger1) > 0) {
/* 1291 */             bigInteger = bigInteger1;
/*      */           }
/*      */           break;
/*      */         case 2:
/* 1295 */           bigInteger2 = getEffectiveMinRangeChoice(schemaParticle);
/* 1296 */           if (bigInteger == null || bigInteger.compareTo(bigInteger2) > 0) {
/* 1297 */             bigInteger = bigInteger2;
/*      */           }
/*      */           break;
/*      */       } 
/*      */     } 
/* 1302 */     if (bigInteger == null) {
/* 1303 */       bigInteger = BigInteger.ZERO;
/*      */     }
/*      */     
/* 1306 */     bigInteger = paramSchemaParticle.getMinOccurs().multiply(bigInteger);
/* 1307 */     return bigInteger;
/*      */   }
/*      */   
/*      */   private static BigInteger getEffectiveMinRangeAllSeq(SchemaParticle paramSchemaParticle) {
/* 1311 */     BigInteger bigInteger1 = BigInteger.ZERO;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1321 */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/* 1322 */     BigInteger bigInteger2 = BigInteger.ZERO;
/* 1323 */     for (byte b = 0; b < arrayOfSchemaParticle.length; b++) {
/* 1324 */       SchemaParticle schemaParticle = arrayOfSchemaParticle[b];
/* 1325 */       switch (schemaParticle.getParticleType()) {
/*      */         case 4:
/*      */         case 5:
/* 1328 */           bigInteger2 = bigInteger2.add(schemaParticle.getMinOccurs());
/*      */           break;
/*      */         case 1:
/*      */         case 3:
/* 1332 */           bigInteger2 = bigInteger2.add(getEffectiveMinRangeAllSeq(schemaParticle));
/*      */           break;
/*      */         case 2:
/* 1335 */           bigInteger2 = bigInteger2.add(getEffectiveMinRangeChoice(schemaParticle));
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1340 */     bigInteger1 = paramSchemaParticle.getMinOccurs().multiply(bigInteger2);
/*      */     
/* 1342 */     return bigInteger1;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean nsSubset(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1347 */     assert paramSchemaParticle1.getParticleType() == 5;
/* 1348 */     assert paramSchemaParticle2.getParticleType() == 5;
/* 1349 */     boolean bool = false;
/*      */ 
/*      */     
/* 1352 */     if (occurrenceRangeOK(paramSchemaParticle1, paramSchemaParticle2, paramCollection, paramXmlObject)) {
/*      */ 
/*      */       
/* 1355 */       if (paramSchemaParticle1.getWildcardSet().inverse().isDisjoint((QNameSetSpecification)paramSchemaParticle2.getWildcardSet())) {
/* 1356 */         bool = true;
/*      */       } else {
/* 1358 */         bool = false;
/* 1359 */         paramCollection.add(XmlError.forObject("rcase-NSSubset.2", new Object[] { printParticle(paramSchemaParticle2), printParticle(paramSchemaParticle1) }, paramXmlObject));
/*      */       } 
/*      */     } else {
/*      */       
/* 1363 */       bool = false;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1369 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean nsCompat(SchemaParticle paramSchemaParticle, SchemaLocalElement paramSchemaLocalElement, Collection paramCollection, XmlObject paramXmlObject) {
/* 1374 */     assert paramSchemaParticle.getParticleType() == 5;
/* 1375 */     boolean bool = false;
/*      */ 
/*      */ 
/*      */     
/* 1379 */     if (paramSchemaParticle.getWildcardSet().contains(paramSchemaLocalElement.getName())) {
/*      */       
/* 1381 */       if (occurrenceRangeOK(paramSchemaParticle, (SchemaParticle)paramSchemaLocalElement, paramCollection, paramXmlObject)) {
/* 1382 */         bool = true;
/*      */       
/*      */       }
/*      */     }
/*      */     else {
/*      */       
/* 1388 */       bool = false;
/* 1389 */       paramCollection.add(XmlError.forObject("rcase-NSCompat.1", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement), printParticle(paramSchemaParticle) }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1395 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean nameAndTypeOK(SchemaLocalElement paramSchemaLocalElement1, SchemaLocalElement paramSchemaLocalElement2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1403 */     if (!((SchemaParticle)paramSchemaLocalElement1).canStartWithElement(paramSchemaLocalElement2.getName())) {
/* 1404 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.1", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */       
/* 1406 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1410 */     if (!paramSchemaLocalElement1.isNillable() && paramSchemaLocalElement2.isNillable()) {
/* 1411 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.2", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */       
/* 1413 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1417 */     if (!occurrenceRangeOK((SchemaParticle)paramSchemaLocalElement1, (SchemaParticle)paramSchemaLocalElement2, paramCollection, paramXmlObject))
/*      */     {
/* 1419 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1424 */     if (!checkFixed(paramSchemaLocalElement1, paramSchemaLocalElement2, paramCollection, paramXmlObject))
/*      */     {
/*      */       
/* 1427 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1431 */     if (!checkIdentityConstraints(paramSchemaLocalElement1, paramSchemaLocalElement2, paramCollection, paramXmlObject))
/*      */     {
/*      */       
/* 1434 */       return false;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1439 */     if (!typeDerivationOK(paramSchemaLocalElement1.getType(), paramSchemaLocalElement2.getType(), paramCollection, paramXmlObject))
/*      */     {
/*      */       
/* 1442 */       return false;
/*      */     }
/*      */ 
/*      */     
/* 1446 */     if (!blockSetOK(paramSchemaLocalElement1, paramSchemaLocalElement2, paramCollection, paramXmlObject))
/*      */     {
/*      */       
/* 1449 */       return false;
/*      */     }
/*      */     
/* 1452 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean blockSetOK(SchemaLocalElement paramSchemaLocalElement1, SchemaLocalElement paramSchemaLocalElement2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1457 */     if (paramSchemaLocalElement1.blockRestriction() && !paramSchemaLocalElement2.blockRestriction()) {
/*      */       
/* 1459 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), "restriction", printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */ 
/*      */       
/* 1462 */       return false;
/*      */     } 
/* 1464 */     if (paramSchemaLocalElement1.blockExtension() && !paramSchemaLocalElement2.blockExtension()) {
/*      */       
/* 1466 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), "extension", printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */ 
/*      */       
/* 1469 */       return false;
/*      */     } 
/* 1471 */     if (paramSchemaLocalElement1.blockSubstitution() && !paramSchemaLocalElement2.blockSubstitution()) {
/*      */       
/* 1473 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.6", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), "substitution", printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */ 
/*      */       
/* 1476 */       return false;
/*      */     } 
/* 1478 */     return true;
/*      */   }
/*      */   
/*      */   private static boolean typeDerivationOK(SchemaType paramSchemaType1, SchemaType paramSchemaType2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1482 */     boolean bool = false;
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
/* 1493 */     if (paramSchemaType1.isAssignableFrom(paramSchemaType2)) {
/*      */ 
/*      */       
/* 1496 */       bool = checkAllDerivationsForRestriction(paramSchemaType1, paramSchemaType2, paramCollection, paramXmlObject);
/*      */     } else {
/*      */       
/* 1499 */       bool = false;
/* 1500 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.7a", new Object[] { printType(paramSchemaType2), printType(paramSchemaType1) }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */     
/* 1504 */     return bool;
/*      */   }
/*      */   
/*      */   private static boolean checkAllDerivationsForRestriction(SchemaType paramSchemaType1, SchemaType paramSchemaType2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1508 */     boolean bool = true;
/* 1509 */     SchemaType schemaType = paramSchemaType2;
/*      */ 
/*      */     
/* 1512 */     HashSet hashSet = null;
/* 1513 */     if (paramSchemaType1.getSimpleVariety() == 2) {
/* 1514 */       hashSet = new HashSet(Arrays.asList((Object[])paramSchemaType1.getUnionConstituentTypes()));
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 1519 */     while (!paramSchemaType1.equals(schemaType) && hashSet != null && !hashSet.contains(schemaType)) {
/* 1520 */       if (schemaType.getDerivationType() == 1) {
/* 1521 */         schemaType = schemaType.getBaseType(); continue;
/*      */       } 
/* 1523 */       bool = false;
/* 1524 */       paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.7b", new Object[] { printType(paramSchemaType2), printType(paramSchemaType1), printType(schemaType) }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1529 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean checkIdentityConstraints(SchemaLocalElement paramSchemaLocalElement1, SchemaLocalElement paramSchemaLocalElement2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1534 */     boolean bool = true;
/*      */     
/* 1536 */     SchemaIdentityConstraint[] arrayOfSchemaIdentityConstraint1 = paramSchemaLocalElement1.getIdentityConstraints();
/* 1537 */     SchemaIdentityConstraint[] arrayOfSchemaIdentityConstraint2 = paramSchemaLocalElement2.getIdentityConstraints();
/*      */     
/* 1539 */     for (byte b = 0; b < arrayOfSchemaIdentityConstraint2.length; b++) {
/* 1540 */       SchemaIdentityConstraint schemaIdentityConstraint = arrayOfSchemaIdentityConstraint2[b];
/* 1541 */       if (checkForIdentityConstraintExistence(arrayOfSchemaIdentityConstraint1, schemaIdentityConstraint)) {
/* 1542 */         bool = false;
/* 1543 */         paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.5", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), printParticle((SchemaParticle)paramSchemaLocalElement1) }, paramXmlObject));
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/* 1549 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean checkForIdentityConstraintExistence(SchemaIdentityConstraint[] paramArrayOfSchemaIdentityConstraint, SchemaIdentityConstraint paramSchemaIdentityConstraint) {
/* 1554 */     boolean bool = false;
/* 1555 */     for (byte b = 0; b < paramArrayOfSchemaIdentityConstraint.length; b++) {
/* 1556 */       SchemaIdentityConstraint schemaIdentityConstraint = paramArrayOfSchemaIdentityConstraint[b];
/* 1557 */       if (schemaIdentityConstraint.getName().equals(paramSchemaIdentityConstraint.getName())) {
/* 1558 */         bool = true;
/*      */         break;
/*      */       } 
/*      */     } 
/* 1562 */     return bool;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean checkFixed(SchemaLocalElement paramSchemaLocalElement1, SchemaLocalElement paramSchemaLocalElement2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1569 */     boolean bool = false;
/* 1570 */     if (paramSchemaLocalElement1.isFixed()) {
/* 1571 */       if (paramSchemaLocalElement1.getDefaultText().equals(paramSchemaLocalElement2.getDefaultText())) {
/*      */         
/* 1573 */         bool = true;
/*      */       } else {
/*      */         
/* 1576 */         paramCollection.add(XmlError.forObject("rcase-NameAndTypeOK.4", new Object[] { printParticle((SchemaParticle)paramSchemaLocalElement2), paramSchemaLocalElement2.getDefaultText(), printParticle((SchemaParticle)paramSchemaLocalElement1), paramSchemaLocalElement1.getDefaultText() }, paramXmlObject));
/*      */ 
/*      */ 
/*      */         
/* 1580 */         bool = false;
/*      */       } 
/*      */     } else {
/*      */       
/* 1584 */       bool = true;
/*      */     } 
/* 1586 */     return bool;
/*      */   }
/*      */   
/*      */   private static boolean occurrenceRangeOK(SchemaParticle paramSchemaParticle1, SchemaParticle paramSchemaParticle2, Collection paramCollection, XmlObject paramXmlObject) {
/* 1590 */     boolean bool = false;
/*      */ 
/*      */     
/* 1593 */     if (paramSchemaParticle2.getMinOccurs().compareTo(paramSchemaParticle1.getMinOccurs()) >= 0) {
/*      */ 
/*      */       
/* 1596 */       if (paramSchemaParticle1.getMaxOccurs() == null) {
/* 1597 */         bool = true;
/*      */       
/*      */       }
/* 1600 */       else if (paramSchemaParticle2.getMaxOccurs() != null && paramSchemaParticle1.getMaxOccurs() != null && paramSchemaParticle2.getMaxOccurs().compareTo(paramSchemaParticle1.getMaxOccurs()) <= 0) {
/*      */         
/* 1602 */         bool = true;
/*      */       } else {
/* 1604 */         bool = false;
/* 1605 */         paramCollection.add(XmlError.forObject("range-ok.2", new Object[] { printParticle(paramSchemaParticle2), printMaxOccurs(paramSchemaParticle2.getMaxOccurs()), printParticle(paramSchemaParticle1), printMaxOccurs(paramSchemaParticle1.getMaxOccurs()) }, paramXmlObject));
/*      */       
/*      */       }
/*      */     
/*      */     }
/*      */     else {
/*      */       
/* 1612 */       bool = false;
/* 1613 */       paramCollection.add(XmlError.forObject("range-ok.1", new Object[] { printParticle(paramSchemaParticle2), paramSchemaParticle2.getMinOccurs().toString(), printParticle(paramSchemaParticle1), paramSchemaParticle1.getMinOccurs().toString() }, paramXmlObject));
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1618 */     return bool;
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printParticles(List paramList) {
/* 1623 */     return printParticles((SchemaParticle[])paramList.toArray((Object[])new SchemaParticle[paramList.size()]));
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printParticles(SchemaParticle[] paramArrayOfSchemaParticle) {
/* 1628 */     return printParticles(paramArrayOfSchemaParticle, 0, paramArrayOfSchemaParticle.length);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printParticles(SchemaParticle[] paramArrayOfSchemaParticle, int paramInt) {
/* 1633 */     return printParticles(paramArrayOfSchemaParticle, paramInt, paramArrayOfSchemaParticle.length);
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printParticles(SchemaParticle[] paramArrayOfSchemaParticle, int paramInt1, int paramInt2) {
/* 1638 */     StringBuffer stringBuffer = new StringBuffer(paramArrayOfSchemaParticle.length * 30);
/* 1639 */     for (int i = paramInt1; i < paramInt2; ) {
/*      */       
/* 1641 */       stringBuffer.append(printParticle(paramArrayOfSchemaParticle[i]));
/* 1642 */       if (++i != paramInt2)
/* 1643 */         stringBuffer.append(", "); 
/*      */     } 
/* 1645 */     return stringBuffer.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printParticle(SchemaParticle paramSchemaParticle) {
/* 1650 */     switch (paramSchemaParticle.getParticleType()) {
/*      */       case 1:
/* 1652 */         return "<all>";
/*      */       case 2:
/* 1654 */         return "<choice>";
/*      */       case 4:
/* 1656 */         return "<element name=\"" + QNameHelper.pretty(paramSchemaParticle.getName()) + "\">";
/*      */       case 3:
/* 1658 */         return "<sequence>";
/*      */       case 5:
/* 1660 */         return "<any>";
/*      */     } 
/* 1662 */     return "??";
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static String printMaxOccurs(BigInteger paramBigInteger) {
/* 1668 */     if (paramBigInteger == null)
/* 1669 */       return "unbounded"; 
/* 1670 */     return paramBigInteger.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static String printType(SchemaType paramSchemaType) {
/* 1675 */     if (paramSchemaType.getName() != null)
/* 1676 */       return QNameHelper.pretty(paramSchemaType.getName()); 
/* 1677 */     return paramSchemaType.toString();
/*      */   }
/*      */ 
/*      */   
/*      */   private static void checkSubstitutionGroups(SchemaGlobalElement[] paramArrayOfSchemaGlobalElement) {
/* 1682 */     StscState stscState = StscState.get();
/*      */     
/* 1684 */     for (byte b = 0; b < paramArrayOfSchemaGlobalElement.length; b++) {
/*      */       
/* 1686 */       SchemaGlobalElement schemaGlobalElement1 = paramArrayOfSchemaGlobalElement[b];
/* 1687 */       SchemaGlobalElement schemaGlobalElement2 = schemaGlobalElement1.substitutionGroup();
/*      */       
/* 1689 */       if (schemaGlobalElement2 != null) {
/*      */         
/* 1691 */         SchemaType schemaType1 = schemaGlobalElement2.getType();
/* 1692 */         SchemaType schemaType2 = schemaGlobalElement1.getType();
/* 1693 */         XmlObject xmlObject = ((SchemaGlobalElementImpl)schemaGlobalElement1)._parseObject;
/*      */         
/* 1695 */         if (!schemaType1.isAssignableFrom(schemaType2)) {
/*      */           
/* 1697 */           stscState.error("e-props-correct.4", new Object[] { QNameHelper.pretty(schemaGlobalElement1.getName()), QNameHelper.pretty(schemaGlobalElement2.getName()) }, xmlObject);
/*      */ 
/*      */ 
/*      */         
/*      */         }
/* 1702 */         else if (schemaGlobalElement2.finalExtension() && schemaGlobalElement2.finalRestriction()) {
/*      */           
/* 1704 */           stscState.error("e-props-correct.4a", new Object[] { QNameHelper.pretty(schemaGlobalElement1.getName()), QNameHelper.pretty(schemaGlobalElement2.getName()), "#all" }, xmlObject);
/*      */ 
/*      */ 
/*      */         
/*      */         }
/* 1709 */         else if (!schemaType1.equals(schemaType2)) {
/*      */           
/* 1711 */           if (schemaGlobalElement2.finalExtension() && schemaType2.getDerivationType() == 2) {
/*      */ 
/*      */             
/* 1714 */             stscState.error("e-props-correct.4a", new Object[] { QNameHelper.pretty(schemaGlobalElement1.getName()), QNameHelper.pretty(schemaGlobalElement2.getName()), "extension" }, xmlObject);
/*      */ 
/*      */ 
/*      */           
/*      */           }
/* 1719 */           else if (schemaGlobalElement2.finalRestriction() && schemaType2.getDerivationType() == 1) {
/*      */ 
/*      */             
/* 1722 */             stscState.error("e-props-correct.4a", new Object[] { QNameHelper.pretty(schemaGlobalElement1.getName()), QNameHelper.pretty(schemaGlobalElement2.getName()), "restriction" }, xmlObject);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscChecker.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */