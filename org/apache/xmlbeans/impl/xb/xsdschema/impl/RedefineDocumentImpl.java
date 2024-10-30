/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
/*     */ 
/*     */ public class RedefineDocumentImpl extends XmlComplexContentImpl implements RedefineDocument {
/*     */   public RedefineDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b REDEFINE$0 = new b("http://www.w3.org/2001/XMLSchema", "redefine");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RedefineDocument.Redefine getRedefine() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       RedefineDocument.Redefine redefine = null;
/*  36 */       redefine = (RedefineDocument.Redefine)get_store().find_element_user(REDEFINE$0, 0);
/*  37 */       if (redefine == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return redefine;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRedefine(RedefineDocument.Redefine paramRedefine) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       RedefineDocument.Redefine redefine = null;
/*  54 */       redefine = (RedefineDocument.Redefine)get_store().find_element_user(REDEFINE$0, 0);
/*  55 */       if (redefine == null)
/*     */       {
/*  57 */         redefine = (RedefineDocument.Redefine)get_store().add_element_user(REDEFINE$0);
/*     */       }
/*  59 */       redefine.set((XmlObject)paramRedefine);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public RedefineDocument.Redefine addNewRedefine() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       RedefineDocument.Redefine redefine = null;
/*  72 */       redefine = (RedefineDocument.Redefine)get_store().add_element_user(REDEFINE$0);
/*  73 */       return redefine;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class RedefineImpl
/*     */     extends OpenAttrsImpl
/*     */     implements RedefineDocument.Redefine
/*     */   {
/*     */     public RedefineImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b ANNOTATION$0 = new b("http://www.w3.org/2001/XMLSchema", "annotation");
/*     */     
/*  91 */     private static final b SIMPLETYPE$2 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*     */     
/*  93 */     private static final b COMPLEXTYPE$4 = new b("http://www.w3.org/2001/XMLSchema", "complexType");
/*     */     
/*  95 */     private static final b GROUP$6 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*     */     
/*  97 */     private static final b ATTRIBUTEGROUP$8 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*     */     
/*  99 */     private static final b SCHEMALOCATION$10 = new b("", "schemaLocation");
/*     */     
/* 101 */     private static final b ID$12 = new b("", "id");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDocument.Annotation[] getAnnotationArray() {
/* 110 */       synchronized (monitor()) {
/*     */         
/* 112 */         check_orphaned();
/* 113 */         ArrayList arrayList = new ArrayList();
/* 114 */         get_store().find_all_element_users(ANNOTATION$0, arrayList);
/* 115 */         AnnotationDocument.Annotation[] arrayOfAnnotation = new AnnotationDocument.Annotation[arrayList.size()];
/* 116 */         arrayList.toArray((Object[])arrayOfAnnotation);
/* 117 */         return arrayOfAnnotation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDocument.Annotation getAnnotationArray(int param1Int) {
/* 126 */       synchronized (monitor()) {
/*     */         
/* 128 */         check_orphaned();
/* 129 */         AnnotationDocument.Annotation annotation = null;
/* 130 */         annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, param1Int);
/* 131 */         if (annotation == null)
/*     */         {
/* 133 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 135 */         return annotation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfAnnotationArray() {
/* 144 */       synchronized (monitor()) {
/*     */         
/* 146 */         check_orphaned();
/* 147 */         return get_store().count_elements(ANNOTATION$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAnnotationArray(AnnotationDocument.Annotation[] param1ArrayOfAnnotation) {
/* 156 */       synchronized (monitor()) {
/*     */         
/* 158 */         check_orphaned();
/* 159 */         arraySetterHelper((XmlObject[])param1ArrayOfAnnotation, ANNOTATION$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAnnotationArray(int param1Int, AnnotationDocument.Annotation param1Annotation) {
/* 168 */       synchronized (monitor()) {
/*     */         
/* 170 */         check_orphaned();
/* 171 */         AnnotationDocument.Annotation annotation = null;
/* 172 */         annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, param1Int);
/* 173 */         if (annotation == null)
/*     */         {
/* 175 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 177 */         annotation.set((XmlObject)param1Annotation);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDocument.Annotation insertNewAnnotation(int param1Int) {
/* 186 */       synchronized (monitor()) {
/*     */         
/* 188 */         check_orphaned();
/* 189 */         AnnotationDocument.Annotation annotation = null;
/* 190 */         annotation = (AnnotationDocument.Annotation)get_store().insert_element_user(ANNOTATION$0, param1Int);
/* 191 */         return annotation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AnnotationDocument.Annotation addNewAnnotation() {
/* 200 */       synchronized (monitor()) {
/*     */         
/* 202 */         check_orphaned();
/* 203 */         AnnotationDocument.Annotation annotation = null;
/* 204 */         annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$0);
/* 205 */         return annotation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeAnnotation(int param1Int) {
/* 214 */       synchronized (monitor()) {
/*     */         
/* 216 */         check_orphaned();
/* 217 */         get_store().remove_element(ANNOTATION$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelSimpleType[] getSimpleTypeArray() {
/* 226 */       synchronized (monitor()) {
/*     */         
/* 228 */         check_orphaned();
/* 229 */         ArrayList arrayList = new ArrayList();
/* 230 */         get_store().find_all_element_users(SIMPLETYPE$2, arrayList);
/* 231 */         TopLevelSimpleType[] arrayOfTopLevelSimpleType = new TopLevelSimpleType[arrayList.size()];
/* 232 */         arrayList.toArray((Object[])arrayOfTopLevelSimpleType);
/* 233 */         return arrayOfTopLevelSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelSimpleType getSimpleTypeArray(int param1Int) {
/* 242 */       synchronized (monitor()) {
/*     */         
/* 244 */         check_orphaned();
/* 245 */         TopLevelSimpleType topLevelSimpleType = null;
/* 246 */         topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$2, param1Int);
/* 247 */         if (topLevelSimpleType == null)
/*     */         {
/* 249 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 251 */         return topLevelSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfSimpleTypeArray() {
/* 260 */       synchronized (monitor()) {
/*     */         
/* 262 */         check_orphaned();
/* 263 */         return get_store().count_elements(SIMPLETYPE$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSimpleTypeArray(TopLevelSimpleType[] param1ArrayOfTopLevelSimpleType) {
/* 272 */       synchronized (monitor()) {
/*     */         
/* 274 */         check_orphaned();
/* 275 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelSimpleType, SIMPLETYPE$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSimpleTypeArray(int param1Int, TopLevelSimpleType param1TopLevelSimpleType) {
/* 284 */       synchronized (monitor()) {
/*     */         
/* 286 */         check_orphaned();
/* 287 */         TopLevelSimpleType topLevelSimpleType = null;
/* 288 */         topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$2, param1Int);
/* 289 */         if (topLevelSimpleType == null)
/*     */         {
/* 291 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 293 */         topLevelSimpleType.set((XmlObject)param1TopLevelSimpleType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelSimpleType insertNewSimpleType(int param1Int) {
/* 302 */       synchronized (monitor()) {
/*     */         
/* 304 */         check_orphaned();
/* 305 */         TopLevelSimpleType topLevelSimpleType = null;
/* 306 */         topLevelSimpleType = (TopLevelSimpleType)get_store().insert_element_user(SIMPLETYPE$2, param1Int);
/* 307 */         return topLevelSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelSimpleType addNewSimpleType() {
/* 316 */       synchronized (monitor()) {
/*     */         
/* 318 */         check_orphaned();
/* 319 */         TopLevelSimpleType topLevelSimpleType = null;
/* 320 */         topLevelSimpleType = (TopLevelSimpleType)get_store().add_element_user(SIMPLETYPE$2);
/* 321 */         return topLevelSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeSimpleType(int param1Int) {
/* 330 */       synchronized (monitor()) {
/*     */         
/* 332 */         check_orphaned();
/* 333 */         get_store().remove_element(SIMPLETYPE$2, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelComplexType[] getComplexTypeArray() {
/* 342 */       synchronized (monitor()) {
/*     */         
/* 344 */         check_orphaned();
/* 345 */         ArrayList arrayList = new ArrayList();
/* 346 */         get_store().find_all_element_users(COMPLEXTYPE$4, arrayList);
/* 347 */         TopLevelComplexType[] arrayOfTopLevelComplexType = new TopLevelComplexType[arrayList.size()];
/* 348 */         arrayList.toArray((Object[])arrayOfTopLevelComplexType);
/* 349 */         return arrayOfTopLevelComplexType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelComplexType getComplexTypeArray(int param1Int) {
/* 358 */       synchronized (monitor()) {
/*     */         
/* 360 */         check_orphaned();
/* 361 */         TopLevelComplexType topLevelComplexType = null;
/* 362 */         topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$4, param1Int);
/* 363 */         if (topLevelComplexType == null)
/*     */         {
/* 365 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 367 */         return topLevelComplexType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfComplexTypeArray() {
/* 376 */       synchronized (monitor()) {
/*     */         
/* 378 */         check_orphaned();
/* 379 */         return get_store().count_elements(COMPLEXTYPE$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setComplexTypeArray(TopLevelComplexType[] param1ArrayOfTopLevelComplexType) {
/* 388 */       synchronized (monitor()) {
/*     */         
/* 390 */         check_orphaned();
/* 391 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelComplexType, COMPLEXTYPE$4);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setComplexTypeArray(int param1Int, TopLevelComplexType param1TopLevelComplexType) {
/* 400 */       synchronized (monitor()) {
/*     */         
/* 402 */         check_orphaned();
/* 403 */         TopLevelComplexType topLevelComplexType = null;
/* 404 */         topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$4, param1Int);
/* 405 */         if (topLevelComplexType == null)
/*     */         {
/* 407 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 409 */         topLevelComplexType.set((XmlObject)param1TopLevelComplexType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelComplexType insertNewComplexType(int param1Int) {
/* 418 */       synchronized (monitor()) {
/*     */         
/* 420 */         check_orphaned();
/* 421 */         TopLevelComplexType topLevelComplexType = null;
/* 422 */         topLevelComplexType = (TopLevelComplexType)get_store().insert_element_user(COMPLEXTYPE$4, param1Int);
/* 423 */         return topLevelComplexType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public TopLevelComplexType addNewComplexType() {
/* 432 */       synchronized (monitor()) {
/*     */         
/* 434 */         check_orphaned();
/* 435 */         TopLevelComplexType topLevelComplexType = null;
/* 436 */         topLevelComplexType = (TopLevelComplexType)get_store().add_element_user(COMPLEXTYPE$4);
/* 437 */         return topLevelComplexType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeComplexType(int param1Int) {
/* 446 */       synchronized (monitor()) {
/*     */         
/* 448 */         check_orphaned();
/* 449 */         get_store().remove_element(COMPLEXTYPE$4, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedGroup[] getGroupArray() {
/* 458 */       synchronized (monitor()) {
/*     */         
/* 460 */         check_orphaned();
/* 461 */         ArrayList arrayList = new ArrayList();
/* 462 */         get_store().find_all_element_users(GROUP$6, arrayList);
/* 463 */         NamedGroup[] arrayOfNamedGroup = new NamedGroup[arrayList.size()];
/* 464 */         arrayList.toArray((Object[])arrayOfNamedGroup);
/* 465 */         return arrayOfNamedGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedGroup getGroupArray(int param1Int) {
/* 474 */       synchronized (monitor()) {
/*     */         
/* 476 */         check_orphaned();
/* 477 */         NamedGroup namedGroup = null;
/* 478 */         namedGroup = (NamedGroup)get_store().find_element_user(GROUP$6, param1Int);
/* 479 */         if (namedGroup == null)
/*     */         {
/* 481 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 483 */         return namedGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfGroupArray() {
/* 492 */       synchronized (monitor()) {
/*     */         
/* 494 */         check_orphaned();
/* 495 */         return get_store().count_elements(GROUP$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setGroupArray(NamedGroup[] param1ArrayOfNamedGroup) {
/* 504 */       synchronized (monitor()) {
/*     */         
/* 506 */         check_orphaned();
/* 507 */         arraySetterHelper((XmlObject[])param1ArrayOfNamedGroup, GROUP$6);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setGroupArray(int param1Int, NamedGroup param1NamedGroup) {
/* 516 */       synchronized (monitor()) {
/*     */         
/* 518 */         check_orphaned();
/* 519 */         NamedGroup namedGroup = null;
/* 520 */         namedGroup = (NamedGroup)get_store().find_element_user(GROUP$6, param1Int);
/* 521 */         if (namedGroup == null)
/*     */         {
/* 523 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 525 */         namedGroup.set((XmlObject)param1NamedGroup);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedGroup insertNewGroup(int param1Int) {
/* 534 */       synchronized (monitor()) {
/*     */         
/* 536 */         check_orphaned();
/* 537 */         NamedGroup namedGroup = null;
/* 538 */         namedGroup = (NamedGroup)get_store().insert_element_user(GROUP$6, param1Int);
/* 539 */         return namedGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedGroup addNewGroup() {
/* 548 */       synchronized (monitor()) {
/*     */         
/* 550 */         check_orphaned();
/* 551 */         NamedGroup namedGroup = null;
/* 552 */         namedGroup = (NamedGroup)get_store().add_element_user(GROUP$6);
/* 553 */         return namedGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeGroup(int param1Int) {
/* 562 */       synchronized (monitor()) {
/*     */         
/* 564 */         check_orphaned();
/* 565 */         get_store().remove_element(GROUP$6, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedAttributeGroup[] getAttributeGroupArray() {
/* 574 */       synchronized (monitor()) {
/*     */         
/* 576 */         check_orphaned();
/* 577 */         ArrayList arrayList = new ArrayList();
/* 578 */         get_store().find_all_element_users(ATTRIBUTEGROUP$8, arrayList);
/* 579 */         NamedAttributeGroup[] arrayOfNamedAttributeGroup = new NamedAttributeGroup[arrayList.size()];
/* 580 */         arrayList.toArray((Object[])arrayOfNamedAttributeGroup);
/* 581 */         return arrayOfNamedAttributeGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedAttributeGroup getAttributeGroupArray(int param1Int) {
/* 590 */       synchronized (monitor()) {
/*     */         
/* 592 */         check_orphaned();
/* 593 */         NamedAttributeGroup namedAttributeGroup = null;
/* 594 */         namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$8, param1Int);
/* 595 */         if (namedAttributeGroup == null)
/*     */         {
/* 597 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 599 */         return namedAttributeGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfAttributeGroupArray() {
/* 608 */       synchronized (monitor()) {
/*     */         
/* 610 */         check_orphaned();
/* 611 */         return get_store().count_elements(ATTRIBUTEGROUP$8);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAttributeGroupArray(NamedAttributeGroup[] param1ArrayOfNamedAttributeGroup) {
/* 620 */       synchronized (monitor()) {
/*     */         
/* 622 */         check_orphaned();
/* 623 */         arraySetterHelper((XmlObject[])param1ArrayOfNamedAttributeGroup, ATTRIBUTEGROUP$8);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAttributeGroupArray(int param1Int, NamedAttributeGroup param1NamedAttributeGroup) {
/* 632 */       synchronized (monitor()) {
/*     */         
/* 634 */         check_orphaned();
/* 635 */         NamedAttributeGroup namedAttributeGroup = null;
/* 636 */         namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$8, param1Int);
/* 637 */         if (namedAttributeGroup == null)
/*     */         {
/* 639 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 641 */         namedAttributeGroup.set((XmlObject)param1NamedAttributeGroup);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedAttributeGroup insertNewAttributeGroup(int param1Int) {
/* 650 */       synchronized (monitor()) {
/*     */         
/* 652 */         check_orphaned();
/* 653 */         NamedAttributeGroup namedAttributeGroup = null;
/* 654 */         namedAttributeGroup = (NamedAttributeGroup)get_store().insert_element_user(ATTRIBUTEGROUP$8, param1Int);
/* 655 */         return namedAttributeGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public NamedAttributeGroup addNewAttributeGroup() {
/* 664 */       synchronized (monitor()) {
/*     */         
/* 666 */         check_orphaned();
/* 667 */         NamedAttributeGroup namedAttributeGroup = null;
/* 668 */         namedAttributeGroup = (NamedAttributeGroup)get_store().add_element_user(ATTRIBUTEGROUP$8);
/* 669 */         return namedAttributeGroup;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeAttributeGroup(int param1Int) {
/* 678 */       synchronized (monitor()) {
/*     */         
/* 680 */         check_orphaned();
/* 681 */         get_store().remove_element(ATTRIBUTEGROUP$8, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSchemaLocation() {
/* 690 */       synchronized (monitor()) {
/*     */         
/* 692 */         check_orphaned();
/* 693 */         SimpleValue simpleValue = null;
/* 694 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$10);
/* 695 */         if (simpleValue == null)
/*     */         {
/* 697 */           return null;
/*     */         }
/* 699 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSchemaLocation() {
/* 708 */       synchronized (monitor()) {
/*     */         
/* 710 */         check_orphaned();
/* 711 */         XmlAnyURI xmlAnyURI = null;
/* 712 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$10);
/* 713 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSchemaLocation(String param1String) {
/* 722 */       synchronized (monitor()) {
/*     */         
/* 724 */         check_orphaned();
/* 725 */         SimpleValue simpleValue = null;
/* 726 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$10);
/* 727 */         if (simpleValue == null)
/*     */         {
/* 729 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SCHEMALOCATION$10);
/*     */         }
/* 731 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSchemaLocation(XmlAnyURI param1XmlAnyURI) {
/* 740 */       synchronized (monitor()) {
/*     */         
/* 742 */         check_orphaned();
/* 743 */         XmlAnyURI xmlAnyURI = null;
/* 744 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$10);
/* 745 */         if (xmlAnyURI == null)
/*     */         {
/* 747 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SCHEMALOCATION$10);
/*     */         }
/* 749 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getId() {
/* 758 */       synchronized (monitor()) {
/*     */         
/* 760 */         check_orphaned();
/* 761 */         SimpleValue simpleValue = null;
/* 762 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$12);
/* 763 */         if (simpleValue == null)
/*     */         {
/* 765 */           return null;
/*     */         }
/* 767 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlID xgetId() {
/* 776 */       synchronized (monitor()) {
/*     */         
/* 778 */         check_orphaned();
/* 779 */         XmlID xmlID = null;
/* 780 */         xmlID = (XmlID)get_store().find_attribute_user(ID$12);
/* 781 */         return xmlID;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetId() {
/* 790 */       synchronized (monitor()) {
/*     */         
/* 792 */         check_orphaned();
/* 793 */         return (get_store().find_attribute_user(ID$12) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setId(String param1String) {
/* 802 */       synchronized (monitor()) {
/*     */         
/* 804 */         check_orphaned();
/* 805 */         SimpleValue simpleValue = null;
/* 806 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$12);
/* 807 */         if (simpleValue == null)
/*     */         {
/* 809 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ID$12);
/*     */         }
/* 811 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetId(XmlID param1XmlID) {
/* 820 */       synchronized (monitor()) {
/*     */         
/* 822 */         check_orphaned();
/* 823 */         XmlID xmlID = null;
/* 824 */         xmlID = (XmlID)get_store().find_attribute_user(ID$12);
/* 825 */         if (xmlID == null)
/*     */         {
/* 827 */           xmlID = (XmlID)get_store().add_attribute_user(ID$12);
/*     */         }
/* 829 */         xmlID.set((XmlObject)param1XmlID);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetId() {
/* 838 */       synchronized (monitor()) {
/*     */         
/* 840 */         check_orphaned();
/* 841 */         get_store().remove_attribute(ID$12);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\RedefineDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */