/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlByte;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlNonNegativeInteger;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlPositiveInteger;
/*      */ import org.apache.xmlbeans.XmlQName;
/*      */ import org.apache.xmlbeans.XmlShort;
/*      */ import org.apache.xmlbeans.XmlUnsignedByte;
/*      */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*      */ import org.apache.xmlbeans.impl.regex.ParseException;
/*      */ import org.apache.xmlbeans.impl.regex.RegularExpression;
/*      */ import org.apache.xmlbeans.impl.values.XmlValueOutOfRangeException;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.Facet;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SimpleType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
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
/*      */ public class StscSimpleTypeResolver
/*      */ {
/*      */   public static void resolveSimpleType(SchemaTypeImpl paramSchemaTypeImpl) {
/*   60 */     SimpleType simpleType = (SimpleType)paramSchemaTypeImpl.getParseObject();
/*      */     
/*   62 */     assert paramSchemaTypeImpl.isSimpleType();
/*      */     
/*   64 */     SchemaDocument.Schema schema = StscComplexTypeResolver.getSchema((XmlObject)simpleType);
/*      */ 
/*      */     
/*   67 */     int i = (simpleType.isSetList() ? 1 : 0) + (simpleType.isSetUnion() ? 1 : 0) + (simpleType.isSetRestriction() ? 1 : 0);
/*      */ 
/*      */ 
/*      */     
/*   71 */     if (i > 1) {
/*      */       
/*   73 */       StscState.get().error("A simple type must define either a list, a union, or a restriction: more than one found.", 52, (XmlObject)simpleType);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*   79 */     else if (i < 1) {
/*      */       
/*   81 */       StscState.get().error("A simple type must define either a list, a union, or a restriction: none was found.", 52, (XmlObject)simpleType);
/*      */ 
/*      */ 
/*      */       
/*   85 */       resolveErrorSimpleType(paramSchemaTypeImpl);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*   90 */     boolean bool1 = false;
/*   91 */     boolean bool2 = false;
/*   92 */     boolean bool3 = false;
/*      */     
/*   94 */     Object object = null;
/*   95 */     if (simpleType.isSetFinal()) {
/*      */       
/*   97 */       object = simpleType.getFinal();
/*      */     
/*      */     }
/*  100 */     else if (schema != null && schema.isSetFinalDefault()) {
/*      */       
/*  102 */       object = schema.getFinalDefault();
/*      */     } 
/*      */     
/*  105 */     if (object != null)
/*      */     {
/*  107 */       if (object instanceof String) {
/*      */         
/*  109 */         if ("#all".equals(object))
/*      */         {
/*  111 */           bool1 = bool2 = bool3 = true;
/*      */         }
/*      */       }
/*  114 */       else if (object instanceof List) {
/*      */         
/*  116 */         List list = (List)object;
/*  117 */         if (list.contains("restriction")) {
/*  118 */           bool1 = true;
/*      */         }
/*  120 */         if (list.contains("list")) {
/*  121 */           bool2 = true;
/*      */         }
/*  123 */         if (list.contains("union")) {
/*  124 */           bool3 = true;
/*      */         }
/*      */       } 
/*      */     }
/*  128 */     paramSchemaTypeImpl.setSimpleFinal(bool1, bool2, bool3);
/*      */     
/*  130 */     ArrayList arrayList = new ArrayList();
/*      */     
/*  132 */     if (simpleType.getList() != null) {
/*  133 */       resolveListType(paramSchemaTypeImpl, simpleType.getList(), arrayList);
/*  134 */     } else if (simpleType.getUnion() != null) {
/*  135 */       resolveUnionType(paramSchemaTypeImpl, simpleType.getUnion(), arrayList);
/*  136 */     } else if (simpleType.getRestriction() != null) {
/*  137 */       resolveSimpleRestrictionType(paramSchemaTypeImpl, simpleType.getRestriction(), arrayList);
/*      */     } 
/*  139 */     paramSchemaTypeImpl.setAnonymousTypeRefs(makeRefArray(arrayList));
/*      */   }
/*      */ 
/*      */   
/*      */   private static SchemaType.Ref[] makeRefArray(Collection paramCollection) {
/*  144 */     SchemaType.Ref[] arrayOfRef = new SchemaType.Ref[paramCollection.size()];
/*  145 */     byte b = 0;
/*  146 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext(); b++)
/*  147 */       arrayOfRef[b] = ((SchemaType)iterator.next()).getRef(); 
/*  148 */     return arrayOfRef;
/*      */   }
/*      */ 
/*      */   
/*      */   static void resolveErrorSimpleType(SchemaTypeImpl paramSchemaTypeImpl) {
/*  153 */     paramSchemaTypeImpl.setSimpleTypeVariety(1);
/*  154 */     paramSchemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
/*  155 */     paramSchemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
/*  156 */     paramSchemaTypeImpl.setPrimitiveTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
/*      */   }
/*      */   static void resolveListType(SchemaTypeImpl paramSchemaTypeImpl, ListDocument.List paramList, List paramList1) {
/*      */     SchemaTypeImpl schemaTypeImpl;
/*      */     LocalSimpleType localSimpleType2;
/*  161 */     StscState stscState = StscState.get();
/*      */     
/*  163 */     paramSchemaTypeImpl.setSimpleTypeVariety(3);
/*  164 */     paramSchemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
/*  165 */     paramSchemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
/*  166 */     paramSchemaTypeImpl.setDerivationType(1);
/*      */     
/*  168 */     if (paramSchemaTypeImpl.isRedefinition())
/*      */     {
/*  170 */       stscState.error("src-redefine.5a", new Object[] { "list" }, (XmlObject)paramList);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  175 */     b b = paramList.getItemType();
/*  176 */     LocalSimpleType localSimpleType1 = paramList.getSimpleType();
/*      */     
/*  178 */     if (b != null && localSimpleType1 != null) {
/*      */       
/*  180 */       stscState.error("src-simple-type.3a", (Object[])null, (XmlObject)paramList);
/*      */       
/*  182 */       localSimpleType1 = null;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  188 */     if (b != null) {
/*      */       
/*  190 */       schemaTypeImpl = stscState.findGlobalType(b, paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl.getTargetNamespace());
/*  191 */       XmlQName xmlQName = paramList.xgetItemType();
/*  192 */       if (schemaTypeImpl == null)
/*      */       {
/*  194 */         stscState.notFoundError(b, 0, (XmlObject)paramList.xgetItemType(), true);
/*      */         
/*  196 */         schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */       }
/*      */     
/*  199 */     } else if (localSimpleType1 != null) {
/*      */       
/*  201 */       schemaTypeImpl = StscTranslator.translateAnonymousSimpleType((SimpleType)localSimpleType1, paramSchemaTypeImpl.getTargetNamespace(), (paramSchemaTypeImpl.getChameleonNamespace() != null), paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), paramList1, paramSchemaTypeImpl);
/*      */ 
/*      */       
/*  204 */       localSimpleType2 = localSimpleType1;
/*      */     }
/*      */     else {
/*      */       
/*  208 */       stscState.error("src-simple-type.3b", (Object[])null, (XmlObject)paramList);
/*      */       
/*  210 */       resolveErrorSimpleType(paramSchemaTypeImpl);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  215 */     if (schemaTypeImpl.finalList()) {
/*  216 */       stscState.error("st-props-correct.4.2.1", (Object[])null, (XmlObject)paramList);
/*      */     }
/*      */     
/*  219 */     StscResolver.resolveType(schemaTypeImpl);
/*      */     
/*  221 */     if (!schemaTypeImpl.isSimpleType()) {
/*      */       
/*  223 */       stscState.error("cos-st-restricts.2.1a", (Object[])null, (XmlObject)localSimpleType2);
/*      */       
/*  225 */       paramSchemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     } 
/*      */     
/*  228 */     switch (schemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 3:
/*  231 */         stscState.error("cos-st-restricts.2.1b", (Object[])null, (XmlObject)localSimpleType2);
/*      */         
/*  233 */         resolveErrorSimpleType(paramSchemaTypeImpl);
/*      */         return;
/*      */       case 2:
/*  236 */         if (schemaTypeImpl.isUnionOfLists()) {
/*      */           
/*  238 */           stscState.error("cos-st-restricts.2.1c", (Object[])null, (XmlObject)localSimpleType2);
/*  239 */           resolveErrorSimpleType(paramSchemaTypeImpl);
/*      */           return;
/*      */         } 
/*      */       
/*      */       case 1:
/*  244 */         paramSchemaTypeImpl.setListItemTypeRef(schemaTypeImpl.getRef());
/*      */         
/*  246 */         if (paramSchemaTypeImpl.getBuiltinTypeCode() == 8)
/*  247 */           stscState.recover("enumeration-required-notation", null, (XmlObject)localSimpleType2); 
/*      */         break;
/*      */       default:
/*      */         assert false;
/*  251 */         paramSchemaTypeImpl.setListItemTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
/*      */         break;
/*      */     } 
/*      */     
/*  255 */     paramSchemaTypeImpl.setBasicFacets(StscState.FACETS_LIST, StscState.FIXED_FACETS_LIST);
/*  256 */     paramSchemaTypeImpl.setWhiteSpaceRule(3);
/*      */ 
/*      */     
/*  259 */     resolveFundamentalFacets(paramSchemaTypeImpl);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static void resolveUnionType(SchemaTypeImpl paramSchemaTypeImpl, UnionDocument.Union paramUnion, List paramList) {
/*  267 */     paramSchemaTypeImpl.setSimpleTypeVariety(2);
/*  268 */     paramSchemaTypeImpl.setBaseTypeRef(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getRef());
/*  269 */     paramSchemaTypeImpl.setBaseDepth(BuiltinSchemaTypeSystem.ST_ANY_SIMPLE.getBaseDepth() + 1);
/*  270 */     paramSchemaTypeImpl.setDerivationType(1);
/*      */     
/*  272 */     StscState stscState = StscState.get();
/*      */     
/*  274 */     if (paramSchemaTypeImpl.isRedefinition())
/*      */     {
/*  276 */       stscState.error("src-redefine.5a", new Object[] { "union" }, (XmlObject)paramUnion);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  281 */     List list = paramUnion.getMemberTypes();
/*  282 */     LocalSimpleType[] arrayOfLocalSimpleType = paramUnion.getSimpleTypeArray();
/*      */     
/*  284 */     ArrayList arrayList = new ArrayList();
/*      */     
/*  286 */     if (arrayOfLocalSimpleType.length == 0 && (list == null || list.size() == 0))
/*      */     {
/*  288 */       stscState.error("src-union-memberTypes-or-simpleTypes", (Object[])null, (XmlObject)paramUnion);
/*      */     }
/*      */ 
/*      */     
/*  292 */     if (list != null)
/*      */     {
/*  294 */       for (b b : list) {
/*      */ 
/*      */         
/*  297 */         SchemaTypeImpl schemaTypeImpl = stscState.findGlobalType(b, paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl.getTargetNamespace());
/*  298 */         if (schemaTypeImpl == null) {
/*      */           
/*  300 */           stscState.notFoundError(b, 0, (XmlObject)paramUnion.xgetMemberTypes(), true); continue;
/*      */         } 
/*  302 */         arrayList.add(schemaTypeImpl);
/*      */       } 
/*      */     }
/*      */     
/*  306 */     for (byte b1 = 0; b1 < arrayOfLocalSimpleType.length; b1++) {
/*      */ 
/*      */       
/*  309 */       SchemaTypeImpl schemaTypeImpl = StscTranslator.translateAnonymousSimpleType((SimpleType)arrayOfLocalSimpleType[b1], paramSchemaTypeImpl.getTargetNamespace(), (paramSchemaTypeImpl.getChameleonNamespace() != null), paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), paramList, paramSchemaTypeImpl);
/*      */ 
/*      */       
/*  312 */       arrayList.add(schemaTypeImpl);
/*  313 */       schemaTypeImpl.setAnonymousUnionMemberOrdinal(b1 + 1);
/*      */     } 
/*      */ 
/*      */     
/*  317 */     for (Iterator iterator1 = arrayList.iterator(); iterator1.hasNext(); ) {
/*      */       
/*  319 */       SchemaTypeImpl schemaTypeImpl = iterator1.next();
/*  320 */       if (!StscResolver.resolveType(schemaTypeImpl)) {
/*      */         UnionDocument.Union.MemberTypes memberTypes;
/*      */         
/*  323 */         String str = "";
/*      */         
/*  325 */         if (schemaTypeImpl.getOuterType().equals(paramSchemaTypeImpl)) {
/*      */           
/*  327 */           XmlObject xmlObject = schemaTypeImpl.getParseObject();
/*      */         }
/*      */         else {
/*      */           
/*  331 */           str = QNameHelper.pretty(schemaTypeImpl.getName()) + " ";
/*  332 */           memberTypes = paramUnion.xgetMemberTypes();
/*      */         } 
/*      */         
/*  335 */         stscState.error("src-simple-type.4", new Object[] { str }, (XmlObject)memberTypes);
/*      */ 
/*      */         
/*  338 */         iterator1.remove();
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  344 */     boolean bool = false;
/*      */     
/*  346 */     for (Iterator iterator2 = arrayList.iterator(); iterator2.hasNext(); ) {
/*      */       
/*  348 */       SchemaTypeImpl schemaTypeImpl = iterator2.next();
/*      */       
/*  350 */       if (!schemaTypeImpl.isSimpleType()) {
/*      */         UnionDocument.Union.MemberTypes memberTypes;
/*      */         
/*  353 */         String str = "";
/*      */         
/*  355 */         if (schemaTypeImpl.getOuterType() != null && schemaTypeImpl.getOuterType().equals(paramSchemaTypeImpl)) {
/*      */           
/*  357 */           XmlObject xmlObject = schemaTypeImpl.getParseObject();
/*      */         }
/*      */         else {
/*      */           
/*  361 */           str = QNameHelper.pretty(schemaTypeImpl.getName()) + " ";
/*  362 */           memberTypes = paramUnion.xgetMemberTypes();
/*      */         } 
/*      */         
/*  365 */         stscState.error("cos-st-restricts.3.1", new Object[] { str }, (XmlObject)memberTypes);
/*      */ 
/*      */         
/*  368 */         iterator2.remove();
/*      */         
/*      */         continue;
/*      */       } 
/*  372 */       if (schemaTypeImpl.getSimpleVariety() == 3 || (schemaTypeImpl.getSimpleVariety() == 2 && schemaTypeImpl.isUnionOfLists()))
/*      */       {
/*  374 */         bool = true;
/*      */       }
/*      */     } 
/*      */     
/*  378 */     for (byte b2 = 0; b2 < arrayList.size(); b2++) {
/*      */       
/*  380 */       SchemaTypeImpl schemaTypeImpl = arrayList.get(b2);
/*  381 */       if (schemaTypeImpl.finalUnion()) {
/*  382 */         stscState.error("st-props-correct.4.2.2", (Object[])null, (XmlObject)paramUnion);
/*      */       }
/*      */     } 
/*  385 */     paramSchemaTypeImpl.setUnionOfLists(bool);
/*      */     
/*  387 */     paramSchemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(arrayList));
/*      */ 
/*      */     
/*  390 */     paramSchemaTypeImpl.setBasicFacets(StscState.FACETS_UNION, StscState.FIXED_FACETS_UNION);
/*      */ 
/*      */     
/*  393 */     resolveFundamentalFacets(paramSchemaTypeImpl);
/*      */   }
/*      */   
/*      */   static void resolveSimpleRestrictionType(SchemaTypeImpl paramSchemaTypeImpl, RestrictionDocument.Restriction paramRestriction, List paramList) {
/*      */     SchemaTypeImpl schemaTypeImpl;
/*  398 */     b b = paramRestriction.getBase();
/*  399 */     LocalSimpleType localSimpleType = paramRestriction.getSimpleType();
/*  400 */     StscState stscState = StscState.get();
/*      */     
/*  402 */     if (b != null && localSimpleType != null) {
/*      */       
/*  404 */       stscState.error("src-simple-type.2a", (Object[])null, (XmlObject)paramRestriction);
/*      */       
/*  406 */       localSimpleType = null;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  411 */     if (b != null) {
/*      */       
/*  413 */       if (paramSchemaTypeImpl.isRedefinition()) {
/*      */         
/*  415 */         schemaTypeImpl = stscState.findRedefinedGlobalType(paramRestriction.getBase(), paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl);
/*  416 */         if (schemaTypeImpl != null && !schemaTypeImpl.getName().equals(paramSchemaTypeImpl.getName()))
/*      */         {
/*  418 */           stscState.error("src-redefine.5b", new Object[] { "<simpleType>", QNameHelper.pretty(b), QNameHelper.pretty(paramSchemaTypeImpl.getName()) }, (XmlObject)paramRestriction);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*      */       else {
/*      */ 
/*      */         
/*  428 */         schemaTypeImpl = stscState.findGlobalType(b, paramSchemaTypeImpl.getChameleonNamespace(), paramSchemaTypeImpl.getTargetNamespace());
/*      */       } 
/*  430 */       if (schemaTypeImpl == null)
/*      */       {
/*  432 */         stscState.notFoundError(b, 0, (XmlObject)paramRestriction.xgetBase(), true);
/*      */         
/*  434 */         schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */       }
/*      */     
/*  437 */     } else if (localSimpleType != null) {
/*      */       
/*  439 */       if (paramSchemaTypeImpl.isRedefinition())
/*      */       {
/*  441 */         StscState.get().error("src-redefine.5a", new Object[] { "<simpleType>" }, (XmlObject)localSimpleType);
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*  446 */       schemaTypeImpl = StscTranslator.translateAnonymousSimpleType((SimpleType)localSimpleType, paramSchemaTypeImpl.getTargetNamespace(), (paramSchemaTypeImpl.getChameleonNamespace() != null), paramSchemaTypeImpl.getElemFormDefault(), paramSchemaTypeImpl.getAttFormDefault(), paramList, paramSchemaTypeImpl);
/*      */     
/*      */     }
/*      */     else {
/*      */ 
/*      */       
/*  452 */       stscState.error("src-simple-type.2b", (Object[])null, (XmlObject)paramRestriction);
/*      */       
/*  454 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     } 
/*      */ 
/*      */     
/*  458 */     if (!StscResolver.resolveType(schemaTypeImpl))
/*      */     {
/*      */       
/*  461 */       schemaTypeImpl = BuiltinSchemaTypeSystem.ST_ANY_SIMPLE;
/*      */     }
/*      */     
/*  464 */     if (schemaTypeImpl.finalRestriction()) {
/*  465 */       stscState.error("st-props-correct.3", (Object[])null, (XmlObject)paramRestriction);
/*      */     }
/*  467 */     paramSchemaTypeImpl.setBaseTypeRef(schemaTypeImpl.getRef());
/*  468 */     paramSchemaTypeImpl.setBaseDepth(schemaTypeImpl.getBaseDepth() + 1);
/*  469 */     paramSchemaTypeImpl.setDerivationType(1);
/*      */     
/*  471 */     if (!schemaTypeImpl.isSimpleType()) {
/*      */       
/*  473 */       stscState.error("cos-st-restricts.1.1", (Object[])null, (XmlObject)paramRestriction.xgetBase());
/*      */       
/*  475 */       resolveErrorSimpleType(paramSchemaTypeImpl);
/*      */       
/*      */       return;
/*      */     } 
/*  479 */     paramSchemaTypeImpl.setSimpleTypeVariety(schemaTypeImpl.getSimpleVariety());
/*      */ 
/*      */     
/*  482 */     switch (schemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 1:
/*  485 */         paramSchemaTypeImpl.setPrimitiveTypeRef(schemaTypeImpl.getPrimitiveType().getRef());
/*      */         break;
/*      */       case 2:
/*  488 */         paramSchemaTypeImpl.setUnionOfLists(schemaTypeImpl.isUnionOfLists());
/*  489 */         paramSchemaTypeImpl.setUnionMemberTypeRefs(makeRefArray(Arrays.asList(schemaTypeImpl.getUnionMemberTypes())));
/*      */         break;
/*      */       case 3:
/*  492 */         paramSchemaTypeImpl.setListItemTypeRef(schemaTypeImpl.getListItemType().getRef());
/*      */         break;
/*      */     } 
/*      */ 
/*      */     
/*  497 */     resolveFacets(paramSchemaTypeImpl, (XmlObject)paramRestriction, schemaTypeImpl);
/*      */ 
/*      */     
/*  500 */     resolveFundamentalFacets(paramSchemaTypeImpl);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static int translateWhitespaceCode(XmlAnySimpleType paramXmlAnySimpleType) {
/*  506 */     String str = paramXmlAnySimpleType.getStringValue();
/*      */     
/*  508 */     if (str.equals("collapse")) {
/*  509 */       return 3;
/*      */     }
/*  511 */     if (str.equals("preserve")) {
/*  512 */       return 1;
/*      */     }
/*  514 */     if (str.equals("replace")) {
/*  515 */       return 2;
/*      */     }
/*      */     
/*  518 */     StscState.get().error("Unrecognized whitespace value \"" + str + "\"", 20, (XmlObject)paramXmlAnySimpleType);
/*  519 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   static boolean isMultipleFacet(int paramInt) {
/*  524 */     return (paramInt == 11 || paramInt == 10);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static boolean facetAppliesToType(int paramInt, SchemaTypeImpl paramSchemaTypeImpl) {
/*  530 */     switch (paramSchemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 3:
/*  533 */         switch (paramInt) {
/*      */           
/*      */           case 0:
/*      */           case 1:
/*      */           case 2:
/*      */           case 9:
/*      */           case 10:
/*      */           case 11:
/*  541 */             return true;
/*      */         } 
/*  543 */         return false;
/*      */       
/*      */       case 2:
/*  546 */         switch (paramInt) {
/*      */           
/*      */           case 10:
/*      */           case 11:
/*  550 */             return true;
/*      */         } 
/*  552 */         return false;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  557 */     switch (paramSchemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
/*      */       
/*      */       case 2:
/*  560 */         return false;
/*      */       
/*      */       case 3:
/*  563 */         switch (paramInt) {
/*      */           
/*      */           case 9:
/*      */           case 10:
/*  567 */             return true;
/*      */         } 
/*  569 */         return false;
/*      */       
/*      */       case 9:
/*      */       case 10:
/*      */       case 13:
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/*  582 */         switch (paramInt) {
/*      */           
/*      */           case 3:
/*      */           case 4:
/*      */           case 5:
/*      */           case 6:
/*      */           case 9:
/*      */           case 10:
/*      */           case 11:
/*  591 */             return true;
/*      */         } 
/*  593 */         return false;
/*      */       
/*      */       case 11:
/*  596 */         switch (paramInt) {
/*      */           
/*      */           case 3:
/*      */           case 4:
/*      */           case 5:
/*      */           case 6:
/*      */           case 7:
/*      */           case 8:
/*      */           case 9:
/*      */           case 10:
/*      */           case 11:
/*  607 */             return true;
/*      */         } 
/*  609 */         return false;
/*      */       
/*      */       case 4:
/*      */       case 5:
/*      */       case 6:
/*      */       case 7:
/*      */       case 8:
/*      */       case 12:
/*  617 */         switch (paramInt) {
/*      */           
/*      */           case 0:
/*      */           case 1:
/*      */           case 2:
/*      */           case 9:
/*      */           case 10:
/*      */           case 11:
/*  625 */             return true;
/*      */         } 
/*  627 */         return false;
/*      */     } 
/*      */     
/*      */     assert false;
/*  631 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static int other_similar_limit(int paramInt) {
/*  637 */     switch (paramInt) {
/*      */       
/*      */       case 3:
/*  640 */         return 4;
/*      */       case 4:
/*  642 */         return 3;
/*      */       case 5:
/*  644 */         return 6;
/*      */       case 6:
/*  646 */         return 5;
/*      */     } 
/*      */     assert false;
/*  649 */     throw new IllegalStateException();
/*      */   }
/*      */ 
/*      */   
/*      */   static void resolveFacets(SchemaTypeImpl paramSchemaTypeImpl1, XmlObject paramXmlObject, SchemaTypeImpl paramSchemaTypeImpl2) {
/*      */     RegularExpression[] arrayOfRegularExpression;
/*  655 */     StscState stscState = StscState.get();
/*      */     
/*  657 */     boolean[] arrayOfBoolean1 = new boolean[12];
/*  658 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaTypeImpl2.getBasicFacets();
/*  659 */     boolean[] arrayOfBoolean2 = paramSchemaTypeImpl2.getFixedFacets();
/*  660 */     int i = 0;
/*  661 */     ArrayList arrayList = null;
/*  662 */     ArrayList arrayList1 = null;
/*      */     
/*  664 */     if (paramXmlObject != null) {
/*      */       
/*  666 */       XmlCursor xmlCursor = paramXmlObject.newCursor(); boolean bool;
/*  667 */       for (bool = xmlCursor.toFirstChild(); bool; bool = xmlCursor.toNextSibling()) {
/*      */         
/*  669 */         b b = xmlCursor.getName();
/*  670 */         String str = b.dT();
/*  671 */         int j = translateFacetCode(b);
/*  672 */         if (j != -1) {
/*      */ 
/*      */           
/*  675 */           Facet facet = (Facet)xmlCursor.getObject();
/*      */           
/*  677 */           if (!facetAppliesToType(j, paramSchemaTypeImpl2)) {
/*      */             
/*  679 */             stscState.error("cos-applicable-facets", new Object[] { str, QNameHelper.pretty(paramSchemaTypeImpl2.getName()) }, (XmlObject)facet);
/*      */           }
/*      */           else {
/*      */             
/*  683 */             if (paramSchemaTypeImpl2.getSimpleVariety() == 1 && paramSchemaTypeImpl2.getPrimitiveType().getBuiltinTypeCode() == 8 && (j == 0 || j == 1 || j == 2))
/*      */             {
/*      */ 
/*      */ 
/*      */               
/*  688 */               stscState.warning("notation-facets", new Object[] { str, QNameHelper.pretty(paramSchemaTypeImpl2.getName()) }, (XmlObject)facet);
/*      */             }
/*      */             
/*  691 */             if (arrayOfBoolean1[j] && !isMultipleFacet(j)) {
/*      */               
/*  693 */               stscState.error("src-single-facet-value", (Object[])null, (XmlObject)facet);
/*      */             } else {
/*      */               XmlNonNegativeInteger xmlNonNegativeInteger1, xmlNonNegativeInteger2; XmlPositiveInteger xmlPositiveInteger; XmlNonNegativeInteger xmlNonNegativeInteger3; boolean bool1, bool2; XmlAnySimpleType xmlAnySimpleType1, xmlAnySimpleType2; RegularExpression regularExpression;
/*  696 */               arrayOfBoolean1[j] = true;
/*      */               
/*  698 */               switch (j) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 case 0:
/*  707 */                   xmlNonNegativeInteger1 = StscTranslator.buildNnInteger(facet.getValue());
/*  708 */                   if (xmlNonNegativeInteger1 == null) {
/*      */                     
/*  710 */                     stscState.error("Must be a nonnegative integer", 20, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  713 */                   if (arrayOfBoolean2[j] && !arrayOfXmlAnySimpleType[j].valueEquals((XmlObject)xmlNonNegativeInteger1)) {
/*      */                     
/*  715 */                     stscState.error("facet-fixed", new Object[] { str }, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  718 */                   if (arrayOfXmlAnySimpleType[1] != null) {
/*      */ 
/*      */ 
/*      */                     
/*  722 */                     XmlAnySimpleType xmlAnySimpleType = paramSchemaTypeImpl2.getFacet(1);
/*  723 */                     if (xmlAnySimpleType == null || !xmlAnySimpleType.valueEquals((XmlObject)arrayOfXmlAnySimpleType[1]) || xmlAnySimpleType.compareValue((XmlObject)xmlNonNegativeInteger1) > 0) {
/*      */ 
/*      */ 
/*      */                       
/*  727 */                       stscState.error("length-minLength-maxLength", (Object[])null, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*      */                   } 
/*  731 */                   if (arrayOfXmlAnySimpleType[2] != null) {
/*      */ 
/*      */ 
/*      */                     
/*  735 */                     XmlAnySimpleType xmlAnySimpleType = paramSchemaTypeImpl2.getFacet(2);
/*  736 */                     if (xmlAnySimpleType == null || !xmlAnySimpleType.valueEquals((XmlObject)arrayOfXmlAnySimpleType[2]) || xmlAnySimpleType.compareValue((XmlObject)xmlNonNegativeInteger1) < 0) {
/*      */ 
/*      */ 
/*      */                       
/*  740 */                       stscState.error("length-minLength-maxLength", (Object[])null, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*      */                   } 
/*  744 */                   arrayOfXmlAnySimpleType[j] = (XmlAnySimpleType)xmlNonNegativeInteger1;
/*      */ 
/*      */                 
/*      */                 case 1:
/*      */                 case 2:
/*  749 */                   xmlNonNegativeInteger2 = StscTranslator.buildNnInteger(facet.getValue());
/*  750 */                   if (xmlNonNegativeInteger2 == null) {
/*      */                     
/*  752 */                     stscState.error("Must be a nonnegative integer", 20, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  755 */                   if (arrayOfBoolean2[j] && !arrayOfXmlAnySimpleType[j].valueEquals((XmlObject)xmlNonNegativeInteger2)) {
/*      */                     
/*  757 */                     stscState.error("facet-fixed", new Object[] { str }, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  760 */                   if (arrayOfXmlAnySimpleType[0] != null) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*  766 */                     XmlAnySimpleType xmlAnySimpleType = paramSchemaTypeImpl2.getFacet(j);
/*  767 */                     if (xmlAnySimpleType == null || !xmlAnySimpleType.valueEquals((XmlObject)xmlNonNegativeInteger2) || ((j == 1) ? (xmlAnySimpleType.compareTo(arrayOfXmlAnySimpleType[0]) <= 0) : (xmlAnySimpleType.compareTo(arrayOfXmlAnySimpleType[0]) >= 0))) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*  773 */                       stscState.error("length-minLength-maxLength", (Object[])null, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*      */                   } 
/*  777 */                   if (arrayOfXmlAnySimpleType[2] != null)
/*      */                   {
/*  779 */                     if (xmlNonNegativeInteger2.compareValue((XmlObject)arrayOfXmlAnySimpleType[2]) > 0) {
/*      */                       
/*  781 */                       stscState.error("maxLength-valid-restriction", (Object[])null, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*      */                   }
/*  785 */                   if (arrayOfXmlAnySimpleType[1] != null)
/*      */                   {
/*  787 */                     if (xmlNonNegativeInteger2.compareValue((XmlObject)arrayOfXmlAnySimpleType[1]) < 0) {
/*      */                       
/*  789 */                       stscState.error("minLength-valid-restriction", (Object[])null, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*      */                   }
/*  793 */                   arrayOfXmlAnySimpleType[j] = (XmlAnySimpleType)xmlNonNegativeInteger2;
/*      */ 
/*      */                 
/*      */                 case 7:
/*  797 */                   xmlPositiveInteger = StscTranslator.buildPosInteger(facet.getValue());
/*  798 */                   if (xmlPositiveInteger == null) {
/*      */                     
/*  800 */                     stscState.error("Must be a positive integer", 20, (XmlObject)facet);
/*      */                   } else {
/*      */                     
/*  803 */                     if (arrayOfBoolean2[j] && !arrayOfXmlAnySimpleType[j].valueEquals((XmlObject)xmlPositiveInteger)) {
/*      */                       
/*  805 */                       stscState.error("facet-fixed", new Object[] { str }, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*  808 */                     if (arrayOfXmlAnySimpleType[7] != null)
/*      */                     {
/*  810 */                       if (xmlPositiveInteger.compareValue((XmlObject)arrayOfXmlAnySimpleType[7]) > 0)
/*  811 */                         stscState.error("totalDigits-valid-restriction", (Object[])null, (XmlObject)facet); 
/*      */                     }
/*  813 */                     arrayOfXmlAnySimpleType[j] = (XmlAnySimpleType)xmlPositiveInteger;
/*      */                   } 
/*      */                 
/*      */                 case 8:
/*  817 */                   xmlNonNegativeInteger3 = StscTranslator.buildNnInteger(facet.getValue());
/*  818 */                   if (xmlNonNegativeInteger3 == null) {
/*      */                     
/*  820 */                     stscState.error("Must be a nonnegative integer", 20, (XmlObject)facet);
/*      */                   } else {
/*      */                     
/*  823 */                     if (arrayOfBoolean2[j] && !arrayOfXmlAnySimpleType[j].valueEquals((XmlObject)xmlNonNegativeInteger3)) {
/*      */                       
/*  825 */                       stscState.error("facet-fixed", new Object[] { str }, (XmlObject)facet);
/*      */                       break;
/*      */                     } 
/*  828 */                     if (arrayOfXmlAnySimpleType[8] != null)
/*      */                     {
/*  830 */                       if (xmlNonNegativeInteger3.compareValue((XmlObject)arrayOfXmlAnySimpleType[8]) > 0)
/*  831 */                         stscState.error("fractionDigits-valid-restriction", (Object[])null, (XmlObject)facet); 
/*      */                     }
/*  833 */                     if (arrayOfXmlAnySimpleType[7] != null)
/*      */                     {
/*  835 */                       if (xmlNonNegativeInteger3.compareValue((XmlObject)arrayOfXmlAnySimpleType[7]) > 0)
/*  836 */                         stscState.error("fractionDigits-totalDigits", (Object[])null, (XmlObject)facet); 
/*      */                     }
/*  838 */                     arrayOfXmlAnySimpleType[j] = (XmlAnySimpleType)xmlNonNegativeInteger3;
/*      */                   } 
/*      */ 
/*      */                 
/*      */                 case 3:
/*      */                 case 4:
/*      */                 case 5:
/*      */                 case 6:
/*  846 */                   if (arrayOfBoolean1[other_similar_limit(j)]) {
/*      */                     
/*  848 */                     stscState.error("Cannot define both inclusive and exclusive limit in the same restriciton", 19, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  851 */                   bool1 = (j == 3 || j == 4) ? true : false;
/*  852 */                   bool2 = (j == 3 || j == 6) ? true : false;
/*      */ 
/*      */ 
/*      */                   
/*      */                   try {
/*  857 */                     xmlAnySimpleType1 = paramSchemaTypeImpl2.newValue(facet.getValue(), true);
/*      */                   }
/*  859 */                   catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */ 
/*      */ 
/*      */                     
/*  863 */                     switch (j) {
/*      */                       
/*      */                       case 3:
/*  866 */                         stscState.error("minExclusive-valid-restriction", new Object[] { xmlValueOutOfRangeException.getMessage() }, (XmlObject)facet);
/*      */                         break;
/*      */                       
/*      */                       case 4:
/*  870 */                         stscState.error("minInclusive-valid-restriction", new Object[] { xmlValueOutOfRangeException.getMessage() }, (XmlObject)facet);
/*      */                         break;
/*      */                       
/*      */                       case 5:
/*  874 */                         stscState.error("maxInclusive-valid-restriction", new Object[] { xmlValueOutOfRangeException.getMessage() }, (XmlObject)facet);
/*      */                         break;
/*      */                       
/*      */                       case 6:
/*  878 */                         stscState.error("maxExclusive-valid-restriction", new Object[] { xmlValueOutOfRangeException.getMessage() }, (XmlObject)facet);
/*      */                         break;
/*      */                     } 
/*      */ 
/*      */ 
/*      */ 
/*      */                     
/*      */                     break;
/*      */                   } 
/*  887 */                   if (arrayOfBoolean2[j] && !arrayOfXmlAnySimpleType[j].valueEquals((XmlObject)xmlAnySimpleType1)) {
/*      */                     
/*  889 */                     stscState.error("facet-fixed", new Object[] { str }, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  892 */                   if (arrayOfXmlAnySimpleType[j] != null) {
/*      */                     
/*  894 */                     SchemaType schemaType = xmlAnySimpleType1.schemaType();
/*  895 */                     if (schemaType != null && !schemaType.isSimpleType() && schemaType.getContentType() == 2)
/*      */                     {
/*      */ 
/*      */ 
/*      */                       
/*  900 */                       xmlAnySimpleType1 = paramSchemaTypeImpl2.getContentBasedOnType().newValue(facet.getValue());
/*      */                     }
/*      */                     
/*  903 */                     int k = xmlAnySimpleType1.compareValue((XmlObject)arrayOfXmlAnySimpleType[j]);
/*  904 */                     if (k == 2 || k == (bool1 ? -1 : 1)) {
/*      */                       
/*  906 */                       stscState.error(bool1 ? (bool2 ? "Must be greater than or equal to previous minExclusive" : "Must be greater than or equal to previous minInclusive") : (bool2 ? "Must be less than or equal to previous maxExclusive" : "Must be less than or equal to previous maxInclusive"), 20, (XmlObject)facet);
/*      */ 
/*      */ 
/*      */ 
/*      */                       
/*      */                       break;
/*      */                     } 
/*      */                   } 
/*      */ 
/*      */ 
/*      */                   
/*  917 */                   arrayOfXmlAnySimpleType[j] = xmlAnySimpleType1;
/*  918 */                   arrayOfXmlAnySimpleType[other_similar_limit(j)] = null;
/*      */ 
/*      */                 
/*      */                 case 9:
/*  922 */                   i = translateWhitespaceCode(facet.getValue());
/*  923 */                   if (paramSchemaTypeImpl2.getWhiteSpaceRule() > i) {
/*      */                     
/*  925 */                     i = 0;
/*  926 */                     stscState.error("whiteSpace-valid-restriction", (Object[])null, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  929 */                   arrayOfXmlAnySimpleType[j] = StscState.build_wsstring(i).get();
/*      */ 
/*      */ 
/*      */ 
/*      */                 
/*      */                 case 11:
/*      */                   try {
/*  936 */                     xmlAnySimpleType2 = paramSchemaTypeImpl2.newValue(facet.getValue(), true);
/*      */ 
/*      */                   
/*      */                   }
/*  940 */                   catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*      */                     
/*  942 */                     stscState.error("enumeration-valid-restriction", new Object[] { facet.getValue().getStringValue(), xmlValueOutOfRangeException.getMessage() }, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  945 */                   if (arrayList == null)
/*  946 */                     arrayList = new ArrayList(); 
/*  947 */                   arrayList.add(xmlAnySimpleType2);
/*      */ 
/*      */                 
/*      */                 case 10:
/*      */                   try {
/*  952 */                     regularExpression = new RegularExpression(facet.getValue().getStringValue(), "X");
/*  953 */                   } catch (ParseException parseException) {
/*      */                     
/*  955 */                     stscState.error("pattern-regex", new Object[] { facet.getValue().getStringValue(), parseException.getMessage() }, (XmlObject)facet);
/*      */                     break;
/*      */                   } 
/*  958 */                   if (arrayList1 == null)
/*  959 */                     arrayList1 = new ArrayList(); 
/*  960 */                   arrayList1.add(regularExpression);
/*      */ 
/*      */                 
/*      */                 default:
/*  964 */                   if (facet.getFixed())
/*  965 */                     arrayOfBoolean2[j] = true;  break;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  971 */     }  paramSchemaTypeImpl1.setBasicFacets(makeValueRefArray(arrayOfXmlAnySimpleType), arrayOfBoolean2);
/*      */ 
/*      */     
/*  974 */     if (i == 0)
/*  975 */       i = paramSchemaTypeImpl2.getWhiteSpaceRule(); 
/*  976 */     paramSchemaTypeImpl1.setWhiteSpaceRule(i);
/*      */ 
/*      */     
/*  979 */     if (arrayList != null) {
/*      */       
/*  981 */       paramSchemaTypeImpl1.setEnumerationValues(makeValueRefArray(arrayList.<XmlAnySimpleType>toArray(new XmlAnySimpleType[arrayList.size()])));
/*      */ 
/*      */       
/*  984 */       SchemaType schemaType = paramSchemaTypeImpl1;
/*  985 */       if (paramSchemaTypeImpl1.isRedefinition()) {
/*  986 */         SchemaType schemaType1 = paramSchemaTypeImpl1.getBaseType().getBaseEnumType();
/*  987 */         if (schemaType1 == null || paramSchemaTypeImpl1.getBaseType() == schemaType1) {
/*  988 */           schemaType1 = paramSchemaTypeImpl1;
/*      */         }
/*      */       }
/*  991 */       else if (paramSchemaTypeImpl1.getBaseType().getBaseEnumType() != null) {
/*  992 */         schemaType = paramSchemaTypeImpl1.getBaseType().getBaseEnumType();
/*  993 */       }  paramSchemaTypeImpl1.setBaseEnumTypeRef(schemaType.getRef());
/*      */     }
/*      */     else {
/*      */       
/*  997 */       paramSchemaTypeImpl1.copyEnumerationValues(paramSchemaTypeImpl2);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1002 */     if (arrayList1 != null) {
/* 1003 */       arrayOfRegularExpression = arrayList1.<RegularExpression>toArray(EMPTY_REGEX_ARRAY);
/*      */     } else {
/* 1005 */       arrayOfRegularExpression = EMPTY_REGEX_ARRAY;
/* 1006 */     }  paramSchemaTypeImpl1.setPatternFacet((arrayOfRegularExpression.length > 0 || paramSchemaTypeImpl2.hasPatternFacet()));
/* 1007 */     paramSchemaTypeImpl1.setPatterns(arrayOfRegularExpression);
/*      */ 
/*      */ 
/*      */     
/* 1011 */     if (paramSchemaTypeImpl2.getBuiltinTypeCode() == 8 && 
/* 1012 */       paramSchemaTypeImpl1.getEnumerationValues() == null) {
/* 1013 */       stscState.recover("enumeration-required-notation", null, paramXmlObject);
/*      */     }
/*      */   }
/*      */   
/*      */   private static XmlValueRef[] makeValueRefArray(XmlAnySimpleType[] paramArrayOfXmlAnySimpleType) {
/* 1018 */     XmlValueRef[] arrayOfXmlValueRef = new XmlValueRef[paramArrayOfXmlAnySimpleType.length];
/* 1019 */     for (byte b = 0; b < arrayOfXmlValueRef.length; b++)
/* 1020 */       arrayOfXmlValueRef[b] = (paramArrayOfXmlAnySimpleType[b] == null) ? null : new XmlValueRef(paramArrayOfXmlAnySimpleType[b]); 
/* 1021 */     return arrayOfXmlValueRef;
/*      */   }
/*      */   
/* 1024 */   private static final RegularExpression[] EMPTY_REGEX_ARRAY = new RegularExpression[0];
/*      */ 
/*      */   
/*      */   private static boolean isDiscreteType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 1028 */     if (paramSchemaTypeImpl.getFacet(8) != null) {
/* 1029 */       return true;
/*      */     }
/* 1031 */     switch (paramSchemaTypeImpl.getPrimitiveType().getBuiltinTypeCode()) {
/*      */       
/*      */       case 3:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/* 1040 */         return true;
/*      */     } 
/* 1042 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static boolean isNumericPrimitive(SchemaType paramSchemaType) {
/* 1047 */     switch (paramSchemaType.getBuiltinTypeCode()) {
/*      */       
/*      */       case 9:
/*      */       case 10:
/*      */       case 11:
/* 1052 */         return true;
/*      */     } 
/* 1054 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int decimalSizeOfType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 1059 */     int i = mathematicalSizeOfType(paramSchemaTypeImpl);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1065 */     if (i == 8 && !XmlByte.type.isAssignableFrom(paramSchemaTypeImpl))
/* 1066 */       i = 16; 
/* 1067 */     if (i == 16 && !XmlShort.type.isAssignableFrom(paramSchemaTypeImpl) && !XmlUnsignedByte.type.isAssignableFrom(paramSchemaTypeImpl)) {
/* 1068 */       i = 32;
/*      */     }
/* 1070 */     return i;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int mathematicalSizeOfType(SchemaTypeImpl paramSchemaTypeImpl) {
/* 1075 */     if (paramSchemaTypeImpl.getPrimitiveType().getBuiltinTypeCode() != 11) {
/* 1076 */       return 0;
/*      */     }
/* 1078 */     if (paramSchemaTypeImpl.getFacet(8) == null || ((SimpleValue)paramSchemaTypeImpl.getFacet(8)).getBigIntegerValue().signum() != 0)
/*      */     {
/* 1080 */       return 1000001;
/*      */     }
/* 1082 */     BigInteger bigInteger1 = null;
/* 1083 */     BigInteger bigInteger2 = null;
/*      */     
/* 1085 */     if (paramSchemaTypeImpl.getFacet(3) != null)
/* 1086 */       bigInteger1 = ((SimpleValue)paramSchemaTypeImpl.getFacet(3)).getBigIntegerValue(); 
/* 1087 */     if (paramSchemaTypeImpl.getFacet(4) != null)
/* 1088 */       bigInteger1 = ((SimpleValue)paramSchemaTypeImpl.getFacet(4)).getBigIntegerValue(); 
/* 1089 */     if (paramSchemaTypeImpl.getFacet(5) != null)
/* 1090 */       bigInteger2 = ((SimpleValue)paramSchemaTypeImpl.getFacet(5)).getBigIntegerValue(); 
/* 1091 */     if (paramSchemaTypeImpl.getFacet(6) != null) {
/* 1092 */       bigInteger2 = ((SimpleValue)paramSchemaTypeImpl.getFacet(6)).getBigIntegerValue();
/*      */     }
/* 1094 */     if (paramSchemaTypeImpl.getFacet(7) != null) {
/*      */       
/* 1096 */       BigInteger bigInteger = null;
/*      */       
/*      */       try {
/* 1099 */         BigInteger bigInteger3 = ((SimpleValue)paramSchemaTypeImpl.getFacet(7)).getBigIntegerValue();
/*      */         
/* 1101 */         switch (bigInteger3.intValue()) { case 0:
/*      */           case 1:
/*      */           case 2:
/* 1104 */             bigInteger = BigInteger.valueOf(99L); break;
/*      */           case 3:
/*      */           case 4:
/* 1107 */             bigInteger = BigInteger.valueOf(9999L); break;
/*      */           case 5: case 6: case 7: case 8:
/*      */           case 9:
/* 1110 */             bigInteger = BigInteger.valueOf(999999999L); break;
/*      */           case 10: case 11: case 12: case 13: case 14: case 15: case 16:
/*      */           case 17:
/*      */           case 18:
/* 1114 */             bigInteger = BigInteger.valueOf(999999999999999999L);
/*      */             break; }
/*      */ 
/*      */       
/* 1118 */       } catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {}
/* 1119 */       if (bigInteger != null) {
/*      */         
/* 1121 */         bigInteger1 = (bigInteger1 == null) ? bigInteger.negate() : bigInteger1.max(bigInteger.negate());
/* 1122 */         bigInteger2 = (bigInteger2 == null) ? bigInteger : bigInteger2.min(bigInteger);
/*      */       } 
/*      */     } 
/*      */     
/* 1126 */     if (bigInteger1 != null && bigInteger2 != null) {
/*      */ 
/*      */       
/* 1129 */       if (bigInteger1.signum() < 0)
/* 1130 */         bigInteger1 = bigInteger1.negate().subtract(BigInteger.ONE); 
/* 1131 */       if (bigInteger2.signum() < 0) {
/* 1132 */         bigInteger2 = bigInteger2.negate().subtract(BigInteger.ONE);
/*      */       }
/* 1134 */       bigInteger2 = bigInteger2.max(bigInteger1);
/* 1135 */       if (bigInteger2.compareTo(BigInteger.valueOf(127L)) <= 0)
/* 1136 */         return 8; 
/* 1137 */       if (bigInteger2.compareTo(BigInteger.valueOf(32767L)) <= 0)
/* 1138 */         return 16; 
/* 1139 */       if (bigInteger2.compareTo(BigInteger.valueOf(2147483647L)) <= 0)
/* 1140 */         return 32; 
/* 1141 */       if (bigInteger2.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) <= 0) {
/* 1142 */         return 64;
/*      */       }
/*      */     } 
/* 1145 */     return 1000000; } static void resolveFundamentalFacets(SchemaTypeImpl paramSchemaTypeImpl) {
/*      */     SchemaTypeImpl schemaTypeImpl;
/*      */     SchemaType[] arrayOfSchemaType;
/*      */     boolean bool1;
/*      */     boolean bool2;
/*      */     boolean bool3;
/*      */     boolean bool4;
/*      */     byte b;
/* 1153 */     switch (paramSchemaTypeImpl.getSimpleVariety()) {
/*      */       
/*      */       case 1:
/* 1156 */         schemaTypeImpl = (SchemaTypeImpl)paramSchemaTypeImpl.getBaseType();
/* 1157 */         paramSchemaTypeImpl.setOrdered(schemaTypeImpl.ordered());
/* 1158 */         paramSchemaTypeImpl.setBounded(((paramSchemaTypeImpl.getFacet(3) != null || paramSchemaTypeImpl.getFacet(4) != null) && (paramSchemaTypeImpl.getFacet(5) != null || paramSchemaTypeImpl.getFacet(6) != null)));
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1163 */         paramSchemaTypeImpl.setFinite((schemaTypeImpl.isFinite() || (paramSchemaTypeImpl.isBounded() && isDiscreteType(paramSchemaTypeImpl))));
/*      */         
/* 1165 */         paramSchemaTypeImpl.setNumeric((schemaTypeImpl.isNumeric() || isNumericPrimitive(paramSchemaTypeImpl.getPrimitiveType())));
/*      */         
/* 1167 */         paramSchemaTypeImpl.setDecimalSize(decimalSizeOfType(paramSchemaTypeImpl));
/*      */         break;
/*      */       case 2:
/* 1170 */         arrayOfSchemaType = paramSchemaTypeImpl.getUnionMemberTypes();
/* 1171 */         bool1 = false;
/* 1172 */         bool2 = true;
/* 1173 */         bool3 = true;
/* 1174 */         bool4 = true;
/*      */         
/* 1176 */         for (b = 0; b < arrayOfSchemaType.length; b++) {
/*      */           
/* 1178 */           if (arrayOfSchemaType[b].ordered() != 0)
/* 1179 */             bool1 = true; 
/* 1180 */           if (!arrayOfSchemaType[b].isBounded())
/* 1181 */             bool2 = false; 
/* 1182 */           if (!arrayOfSchemaType[b].isFinite())
/* 1183 */             bool3 = false; 
/* 1184 */           if (!arrayOfSchemaType[b].isNumeric())
/* 1185 */             bool4 = false; 
/*      */         } 
/* 1187 */         paramSchemaTypeImpl.setOrdered(bool1);
/* 1188 */         paramSchemaTypeImpl.setBounded(bool2);
/* 1189 */         paramSchemaTypeImpl.setFinite(bool3);
/* 1190 */         paramSchemaTypeImpl.setNumeric(bool4);
/* 1191 */         paramSchemaTypeImpl.setDecimalSize(0);
/*      */         break;
/*      */       case 3:
/* 1194 */         paramSchemaTypeImpl.setOrdered(0);
/*      */         
/* 1196 */         paramSchemaTypeImpl.setBounded((paramSchemaTypeImpl.getFacet(0) != null || paramSchemaTypeImpl.getFacet(2) != null));
/*      */ 
/*      */         
/* 1199 */         paramSchemaTypeImpl.setFinite((paramSchemaTypeImpl.getListItemType().isFinite() && paramSchemaTypeImpl.isBounded()));
/* 1200 */         paramSchemaTypeImpl.setNumeric(false);
/* 1201 */         paramSchemaTypeImpl.setDecimalSize(0);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   private static class CodeForNameEntry { public b name;
/*      */     public int code;
/*      */     
/*      */     CodeForNameEntry(b param1b, int param1Int) {
/* 1209 */       this.name = param1b; this.code = param1Int;
/*      */     } }
/*      */ 
/*      */ 
/*      */   
/* 1214 */   private static CodeForNameEntry[] facetCodes = new CodeForNameEntry[] { new CodeForNameEntry(QNameHelper.forLNS("length", "http://www.w3.org/2001/XMLSchema"), 0), new CodeForNameEntry(QNameHelper.forLNS("minLength", "http://www.w3.org/2001/XMLSchema"), 1), new CodeForNameEntry(QNameHelper.forLNS("maxLength", "http://www.w3.org/2001/XMLSchema"), 2), new CodeForNameEntry(QNameHelper.forLNS("pattern", "http://www.w3.org/2001/XMLSchema"), 10), new CodeForNameEntry(QNameHelper.forLNS("enumeration", "http://www.w3.org/2001/XMLSchema"), 11), new CodeForNameEntry(QNameHelper.forLNS("whiteSpace", "http://www.w3.org/2001/XMLSchema"), 9), new CodeForNameEntry(QNameHelper.forLNS("maxInclusive", "http://www.w3.org/2001/XMLSchema"), 5), new CodeForNameEntry(QNameHelper.forLNS("maxExclusive", "http://www.w3.org/2001/XMLSchema"), 6), new CodeForNameEntry(QNameHelper.forLNS("minInclusive", "http://www.w3.org/2001/XMLSchema"), 4), new CodeForNameEntry(QNameHelper.forLNS("minExclusive", "http://www.w3.org/2001/XMLSchema"), 3), new CodeForNameEntry(QNameHelper.forLNS("totalDigits", "http://www.w3.org/2001/XMLSchema"), 7), new CodeForNameEntry(QNameHelper.forLNS("fractionDigits", "http://www.w3.org/2001/XMLSchema"), 8) };
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
/* 1230 */   private static final Map facetCodeMap = buildFacetCodeMap();
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   private static Map buildFacetCodeMap() {
/* 1234 */     HashMap hashMap = new HashMap();
/* 1235 */     for (byte b = 0; b < facetCodes.length; b++)
/* 1236 */       hashMap.put((facetCodes[b]).name, new Integer((facetCodes[b]).code)); 
/* 1237 */     return hashMap;
/*      */   }
/*      */ 
/*      */   
/*      */   private static int translateFacetCode(b paramb) {
/* 1242 */     Integer integer = (Integer)facetCodeMap.get(paramb);
/* 1243 */     if (integer == null)
/* 1244 */       return -1; 
/* 1245 */     return integer.intValue();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscSimpleTypeResolver.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */