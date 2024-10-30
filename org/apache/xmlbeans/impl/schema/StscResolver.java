/*     */ package org.apache.xmlbeans.impl.schema;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.QNameSet;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Element;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.KeyrefDocument;
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
/*     */ public class StscResolver
/*     */ {
/*     */   static final boolean $assertionsDisabled;
/*     */   
/*     */   public static void resolveAll() {
/*  44 */     StscState stscState = StscState.get();
/*     */     
/*  46 */     SchemaType[] arrayOfSchemaType = stscState.documentTypes();
/*  47 */     for (byte b1 = 0; b1 < arrayOfSchemaType.length; b1++) {
/*  48 */       resolveSubstitutionGroup((SchemaTypeImpl)arrayOfSchemaType[b1]);
/*     */     }
/*  50 */     ArrayList arrayList = new ArrayList();
/*  51 */     arrayList.addAll(Arrays.asList(stscState.documentTypes()));
/*  52 */     arrayList.addAll(Arrays.asList(stscState.attributeTypes()));
/*  53 */     arrayList.addAll(Arrays.asList(stscState.redefinedGlobalTypes()));
/*  54 */     arrayList.addAll(Arrays.asList(stscState.globalTypes()));
/*     */     
/*  56 */     for (byte b2 = 0; b2 < arrayList.size(); b2++) {
/*     */       
/*  58 */       SchemaType schemaType = arrayList.get(b2);
/*  59 */       resolveType((SchemaTypeImpl)schemaType);
/*  60 */       arrayList.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
/*     */     } 
/*     */ 
/*     */     
/*  64 */     resolveIdentityConstraints();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean resolveType(SchemaTypeImpl paramSchemaTypeImpl) {
/*  69 */     if (paramSchemaTypeImpl.isResolved())
/*  70 */       return true; 
/*  71 */     if (paramSchemaTypeImpl.isResolving()) {
/*     */       
/*  73 */       StscState.get().error("Cyclic dependency error", 13, paramSchemaTypeImpl.getParseObject());
/*  74 */       return false;
/*     */     } 
/*     */ 
/*     */     
/*  78 */     paramSchemaTypeImpl.startResolving();
/*     */     
/*  80 */     if (paramSchemaTypeImpl.isDocumentType()) {
/*  81 */       resolveDocumentType(paramSchemaTypeImpl);
/*  82 */     } else if (paramSchemaTypeImpl.isAttributeType()) {
/*  83 */       resolveAttributeType(paramSchemaTypeImpl);
/*  84 */     } else if (paramSchemaTypeImpl.isSimpleType()) {
/*  85 */       StscSimpleTypeResolver.resolveSimpleType(paramSchemaTypeImpl);
/*     */     } else {
/*  87 */       StscComplexTypeResolver.resolveComplexType(paramSchemaTypeImpl);
/*     */     } 
/*  89 */     paramSchemaTypeImpl.finishResolving();
/*     */     
/*  91 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean resolveSubstitutionGroup(SchemaTypeImpl paramSchemaTypeImpl) {
/*  96 */     assert paramSchemaTypeImpl.isDocumentType();
/*     */     
/*  98 */     if (paramSchemaTypeImpl.isSGResolved())
/*  99 */       return true; 
/* 100 */     if (paramSchemaTypeImpl.isSGResolving()) {
/*     */       
/* 102 */       StscState.get().error("Cyclic dependency error", 13, paramSchemaTypeImpl.getParseObject());
/* 103 */       return false;
/*     */     } 
/*     */     
/* 106 */     paramSchemaTypeImpl.startResolvingSGs();
/*     */ 
/*     */ 
/*     */     
/* 110 */     TopLevelElement topLevelElement = (TopLevelElement)paramSchemaTypeImpl.getParseObject();
/* 111 */     SchemaTypeImpl schemaTypeImpl = null;
/* 112 */     b b = new b(paramSchemaTypeImpl.getTargetNamespace(), topLevelElement.getName());
/*     */ 
/*     */     
/* 115 */     if (topLevelElement.isSetSubstitutionGroup()) {
/*     */       
/* 117 */       schemaTypeImpl = StscState.get().findDocumentType(topLevelElement.getSubstitutionGroup(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl.getTargetNamespace());
/*     */ 
/*     */       
/* 120 */       if (schemaTypeImpl == null) {
/* 121 */         StscState.get().notFoundError(topLevelElement.getSubstitutionGroup(), 1, (XmlObject)topLevelElement.xgetSubstitutionGroup(), true);
/*     */       }
/* 123 */       else if (!resolveSubstitutionGroup(schemaTypeImpl)) {
/* 124 */         schemaTypeImpl = null;
/*     */       } else {
/* 126 */         paramSchemaTypeImpl.setSubstitutionGroup(topLevelElement.getSubstitutionGroup());
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 131 */     while (schemaTypeImpl != null) {
/*     */ 
/*     */       
/* 134 */       schemaTypeImpl.addSubstitutionGroupMember(b);
/*     */       
/* 136 */       if (schemaTypeImpl.getSubstitutionGroup() == null) {
/*     */         break;
/*     */       }
/* 139 */       schemaTypeImpl = StscState.get().findDocumentType(schemaTypeImpl.getSubstitutionGroup(), schemaTypeImpl.getChameleonNamespace(), null);
/*     */ 
/*     */       
/* 142 */       assert schemaTypeImpl != null : "Could not find document type for: " + schemaTypeImpl.getSubstitutionGroup();
/*     */       
/* 144 */       if (!resolveSubstitutionGroup(schemaTypeImpl)) {
/* 145 */         schemaTypeImpl = null;
/*     */       }
/*     */     } 
/*     */     
/* 149 */     paramSchemaTypeImpl.finishResolvingSGs();
/* 150 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resolveDocumentType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 156 */     assert paramSchemaTypeImpl.isResolving();
/*     */     
/* 158 */     assert paramSchemaTypeImpl.isDocumentType();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 164 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 166 */     SchemaGlobalElementImpl schemaGlobalElementImpl = (SchemaGlobalElementImpl)StscTranslator.translateElement((Element)paramSchemaTypeImpl.getParseObject(), paramSchemaTypeImpl.getTargetNamespace(), paramSchemaTypeImpl.isChameleon(), null, null, arrayList, paramSchemaTypeImpl);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 173 */     SchemaLocalElementImpl schemaLocalElementImpl = null;
/*     */     
/* 175 */     if (schemaGlobalElementImpl != null) {
/*     */       
/* 177 */       StscState.get().addGlobalElement(schemaGlobalElementImpl);
/*     */       
/* 179 */       schemaLocalElementImpl = new SchemaLocalElementImpl();
/*     */       
/* 181 */       schemaLocalElementImpl.setParticleType(4);
/* 182 */       StscTranslator.copyGlobalElementToLocalElement(schemaGlobalElementImpl, schemaLocalElementImpl);
/* 183 */       schemaLocalElementImpl.setMinOccurs(BigInteger.ONE);
/* 184 */       schemaLocalElementImpl.setMaxOccurs(BigInteger.ONE);
/*     */       
/* 186 */       schemaLocalElementImpl.setTransitionNotes(QNameSet.EMPTY, true);
/*     */     } 
/*     */     
/* 189 */     Map map = StscComplexTypeResolver.buildContentPropertyModelByQName(schemaLocalElementImpl, paramSchemaTypeImpl);
/*     */ 
/*     */ 
/*     */     
/* 193 */     SchemaTypeImpl schemaTypeImpl = (paramSchemaTypeImpl.getSubstitutionGroup() == null) ? BuiltinSchemaTypeSystem.ST_ANY_TYPE : StscState.get().findDocumentType(paramSchemaTypeImpl.getSubstitutionGroup(), paramSchemaTypeImpl.isChameleon() ? paramSchemaTypeImpl.getTargetNamespace() : null, null);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 199 */     paramSchemaTypeImpl.setBaseTypeRef(schemaTypeImpl.getRef());
/* 200 */     paramSchemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
/* 201 */     paramSchemaTypeImpl.setDerivationType(1);
/* 202 */     paramSchemaTypeImpl.setComplexTypeVariety(3);
/*     */     
/* 204 */     paramSchemaTypeImpl.setContentModel(schemaLocalElementImpl, new SchemaAttributeModelImpl(), map, Collections.EMPTY_MAP, false);
/*     */ 
/*     */ 
/*     */     
/* 208 */     paramSchemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
/*     */ 
/*     */     
/* 211 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resolveAttributeType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 219 */     assert paramSchemaTypeImpl.isResolving();
/*     */     
/* 221 */     assert paramSchemaTypeImpl.isAttributeType();
/*     */     
/* 223 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 225 */     SchemaGlobalAttributeImpl schemaGlobalAttributeImpl = (SchemaGlobalAttributeImpl)StscTranslator.translateAttribute((Attribute)paramSchemaTypeImpl.getParseObject(), paramSchemaTypeImpl.getTargetNamespace(), null, paramSchemaTypeImpl.isChameleon(), arrayList, paramSchemaTypeImpl, null, false);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 230 */     SchemaAttributeModelImpl schemaAttributeModelImpl = new SchemaAttributeModelImpl();
/*     */     
/* 232 */     if (schemaGlobalAttributeImpl != null) {
/*     */       
/* 234 */       StscState.get().addGlobalAttribute(schemaGlobalAttributeImpl);
/*     */       
/* 236 */       SchemaLocalAttributeImpl schemaLocalAttributeImpl = new SchemaLocalAttributeImpl();
/* 237 */       StscTranslator.copyGlobalAttributeToLocalAttribute(schemaGlobalAttributeImpl, schemaLocalAttributeImpl);
/* 238 */       schemaAttributeModelImpl.addAttribute(schemaLocalAttributeImpl);
/*     */     } 
/*     */     
/* 241 */     paramSchemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_TYPE.getRef());
/* 242 */     paramSchemaTypeImpl.setBaseDepth(paramSchemaTypeImpl.getBaseDepth() + 1);
/* 243 */     paramSchemaTypeImpl.setDerivationType(1);
/* 244 */     paramSchemaTypeImpl.setComplexTypeVariety(1);
/*     */     
/* 246 */     Map map = StscComplexTypeResolver.buildAttributePropertyModelByQName(schemaAttributeModelImpl, paramSchemaTypeImpl);
/*     */ 
/*     */ 
/*     */     
/* 250 */     paramSchemaTypeImpl.setContentModel(null, schemaAttributeModelImpl, Collections.EMPTY_MAP, map, false);
/*     */ 
/*     */     
/* 253 */     paramSchemaTypeImpl.setWildcardSummary(QNameSet.EMPTY, false, QNameSet.EMPTY, false);
/*     */ 
/*     */     
/* 256 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*     */   }
/*     */ 
/*     */   
/*     */   private static SchemaType.Ref[] makeRefArray(Collection paramCollection) {
/* 261 */     SchemaType.Ref[] arrayOfRef = new SchemaType.Ref[paramCollection.size()];
/* 262 */     byte b = 0;
/* 263 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext(); b++)
/* 264 */       arrayOfRef[b] = ((SchemaType)iterator.next()).getRef(); 
/* 265 */     return arrayOfRef;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void resolveIdentityConstraints() {
/* 271 */     StscState stscState = StscState.get();
/* 272 */     SchemaIdentityConstraintImpl[] arrayOfSchemaIdentityConstraintImpl = stscState.idConstraints();
/*     */     
/* 274 */     for (byte b = 0; b < arrayOfSchemaIdentityConstraintImpl.length; b++) {
/*     */       
/* 276 */       if (!arrayOfSchemaIdentityConstraintImpl[b].isResolved()) {
/*     */         
/* 278 */         KeyrefDocument.Keyref keyref = (KeyrefDocument.Keyref)arrayOfSchemaIdentityConstraintImpl[b].getParseObject();
/* 279 */         b b1 = keyref.getRefer();
/* 280 */         SchemaIdentityConstraintImpl schemaIdentityConstraintImpl = null;
/*     */         
/* 282 */         schemaIdentityConstraintImpl = stscState.findIdConstraint(b1, arrayOfSchemaIdentityConstraintImpl[b].getChameleonNamespace(), arrayOfSchemaIdentityConstraintImpl[b].getTargetNamespace());
/* 283 */         if (schemaIdentityConstraintImpl == null) {
/*     */           
/* 285 */           stscState.notFoundError(b1, 5, (XmlObject)keyref, true);
/*     */         }
/*     */         else {
/*     */           
/* 289 */           if (schemaIdentityConstraintImpl.getConstraintCategory() == 2) {
/* 290 */             stscState.error("c-props-correct.1", (Object[])null, arrayOfSchemaIdentityConstraintImpl[b].getParseObject());
/*     */           }
/*     */           
/* 293 */           if ((schemaIdentityConstraintImpl.getFields()).length != (arrayOfSchemaIdentityConstraintImpl[b].getFields()).length) {
/* 294 */             stscState.error("c-props-correct.2", (Object[])null, arrayOfSchemaIdentityConstraintImpl[b].getParseObject());
/*     */           }
/*     */           
/* 297 */           arrayOfSchemaIdentityConstraintImpl[b].setReferencedKey(schemaIdentityConstraintImpl.getRef());
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscResolver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */