/*      */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*      */ import java.util.ArrayList;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
/*      */ 
/*      */ public class SchemaDocumentImpl extends XmlComplexContentImpl implements SchemaDocument {
/*      */   public SchemaDocumentImpl(SchemaType paramSchemaType) {
/*   20 */     super(paramSchemaType);
/*      */   }
/*      */   
/*   23 */   private static final b SCHEMA$0 = new b("http://www.w3.org/2001/XMLSchema", "schema");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaDocument.Schema getSchema() {
/*   32 */     synchronized (monitor()) {
/*      */       
/*   34 */       check_orphaned();
/*   35 */       SchemaDocument.Schema schema = null;
/*   36 */       schema = (SchemaDocument.Schema)get_store().find_element_user(SCHEMA$0, 0);
/*   37 */       if (schema == null)
/*      */       {
/*   39 */         return null;
/*      */       }
/*   41 */       return schema;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setSchema(SchemaDocument.Schema paramSchema) {
/*   50 */     synchronized (monitor()) {
/*      */       
/*   52 */       check_orphaned();
/*   53 */       SchemaDocument.Schema schema = null;
/*   54 */       schema = (SchemaDocument.Schema)get_store().find_element_user(SCHEMA$0, 0);
/*   55 */       if (schema == null)
/*      */       {
/*   57 */         schema = (SchemaDocument.Schema)get_store().add_element_user(SCHEMA$0);
/*      */       }
/*   59 */       schema.set((XmlObject)paramSchema);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public SchemaDocument.Schema addNewSchema() {
/*   68 */     synchronized (monitor()) {
/*      */       
/*   70 */       check_orphaned();
/*   71 */       SchemaDocument.Schema schema = null;
/*   72 */       schema = (SchemaDocument.Schema)get_store().add_element_user(SCHEMA$0);
/*   73 */       return schema;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class SchemaImpl
/*      */     extends OpenAttrsImpl
/*      */     implements SchemaDocument.Schema
/*      */   {
/*      */     public SchemaImpl(SchemaType param1SchemaType) {
/*   86 */       super(param1SchemaType);
/*      */     }
/*      */     
/*   89 */     private static final b INCLUDE$0 = new b("http://www.w3.org/2001/XMLSchema", "include");
/*      */     
/*   91 */     private static final b IMPORT$2 = new b("http://www.w3.org/2001/XMLSchema", "import");
/*      */     
/*   93 */     private static final b REDEFINE$4 = new b("http://www.w3.org/2001/XMLSchema", "redefine");
/*      */     
/*   95 */     private static final b ANNOTATION$6 = new b("http://www.w3.org/2001/XMLSchema", "annotation");
/*      */     
/*   97 */     private static final b SIMPLETYPE$8 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*      */     
/*   99 */     private static final b COMPLEXTYPE$10 = new b("http://www.w3.org/2001/XMLSchema", "complexType");
/*      */     
/*  101 */     private static final b GROUP$12 = new b("http://www.w3.org/2001/XMLSchema", "group");
/*      */     
/*  103 */     private static final b ATTRIBUTEGROUP$14 = new b("http://www.w3.org/2001/XMLSchema", "attributeGroup");
/*      */     
/*  105 */     private static final b ELEMENT$16 = new b("http://www.w3.org/2001/XMLSchema", "element");
/*      */     
/*  107 */     private static final b ATTRIBUTE$18 = new b("http://www.w3.org/2001/XMLSchema", "attribute");
/*      */     
/*  109 */     private static final b NOTATION$20 = new b("http://www.w3.org/2001/XMLSchema", "notation");
/*      */     
/*  111 */     private static final b TARGETNAMESPACE$22 = new b("", "targetNamespace");
/*      */     
/*  113 */     private static final b VERSION$24 = new b("", "version");
/*      */     
/*  115 */     private static final b FINALDEFAULT$26 = new b("", "finalDefault");
/*      */     
/*  117 */     private static final b BLOCKDEFAULT$28 = new b("", "blockDefault");
/*      */     
/*  119 */     private static final b ATTRIBUTEFORMDEFAULT$30 = new b("", "attributeFormDefault");
/*      */     
/*  121 */     private static final b ELEMENTFORMDEFAULT$32 = new b("", "elementFormDefault");
/*      */     
/*  123 */     private static final b ID$34 = new b("", "id");
/*      */     
/*  125 */     private static final b LANG$36 = new b("http://www.w3.org/XML/1998/namespace", "lang");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IncludeDocument.Include[] getIncludeArray() {
/*  134 */       synchronized (monitor()) {
/*      */         
/*  136 */         check_orphaned();
/*  137 */         ArrayList arrayList = new ArrayList();
/*  138 */         get_store().find_all_element_users(INCLUDE$0, arrayList);
/*  139 */         IncludeDocument.Include[] arrayOfInclude = new IncludeDocument.Include[arrayList.size()];
/*  140 */         arrayList.toArray((Object[])arrayOfInclude);
/*  141 */         return arrayOfInclude;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IncludeDocument.Include getIncludeArray(int param1Int) {
/*  150 */       synchronized (monitor()) {
/*      */         
/*  152 */         check_orphaned();
/*  153 */         IncludeDocument.Include include = null;
/*  154 */         include = (IncludeDocument.Include)get_store().find_element_user(INCLUDE$0, param1Int);
/*  155 */         if (include == null)
/*      */         {
/*  157 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  159 */         return include;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfIncludeArray() {
/*  168 */       synchronized (monitor()) {
/*      */         
/*  170 */         check_orphaned();
/*  171 */         return get_store().count_elements(INCLUDE$0);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setIncludeArray(IncludeDocument.Include[] param1ArrayOfInclude) {
/*  180 */       synchronized (monitor()) {
/*      */         
/*  182 */         check_orphaned();
/*  183 */         arraySetterHelper((XmlObject[])param1ArrayOfInclude, INCLUDE$0);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setIncludeArray(int param1Int, IncludeDocument.Include param1Include) {
/*  192 */       synchronized (monitor()) {
/*      */         
/*  194 */         check_orphaned();
/*  195 */         IncludeDocument.Include include = null;
/*  196 */         include = (IncludeDocument.Include)get_store().find_element_user(INCLUDE$0, param1Int);
/*  197 */         if (include == null)
/*      */         {
/*  199 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  201 */         include.set((XmlObject)param1Include);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IncludeDocument.Include insertNewInclude(int param1Int) {
/*  210 */       synchronized (monitor()) {
/*      */         
/*  212 */         check_orphaned();
/*  213 */         IncludeDocument.Include include = null;
/*  214 */         include = (IncludeDocument.Include)get_store().insert_element_user(INCLUDE$0, param1Int);
/*  215 */         return include;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public IncludeDocument.Include addNewInclude() {
/*  224 */       synchronized (monitor()) {
/*      */         
/*  226 */         check_orphaned();
/*  227 */         IncludeDocument.Include include = null;
/*  228 */         include = (IncludeDocument.Include)get_store().add_element_user(INCLUDE$0);
/*  229 */         return include;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeInclude(int param1Int) {
/*  238 */       synchronized (monitor()) {
/*      */         
/*  240 */         check_orphaned();
/*  241 */         get_store().remove_element(INCLUDE$0, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImportDocument.Import[] getImportArray() {
/*  250 */       synchronized (monitor()) {
/*      */         
/*  252 */         check_orphaned();
/*  253 */         ArrayList arrayList = new ArrayList();
/*  254 */         get_store().find_all_element_users(IMPORT$2, arrayList);
/*  255 */         ImportDocument.Import[] arrayOfImport = new ImportDocument.Import[arrayList.size()];
/*  256 */         arrayList.toArray((Object[])arrayOfImport);
/*  257 */         return arrayOfImport;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImportDocument.Import getImportArray(int param1Int) {
/*  266 */       synchronized (monitor()) {
/*      */         
/*  268 */         check_orphaned();
/*  269 */         ImportDocument.Import import_ = null;
/*  270 */         import_ = (ImportDocument.Import)get_store().find_element_user(IMPORT$2, param1Int);
/*  271 */         if (import_ == null)
/*      */         {
/*  273 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  275 */         return import_;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfImportArray() {
/*  284 */       synchronized (monitor()) {
/*      */         
/*  286 */         check_orphaned();
/*  287 */         return get_store().count_elements(IMPORT$2);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setImportArray(ImportDocument.Import[] param1ArrayOfImport) {
/*  296 */       synchronized (monitor()) {
/*      */         
/*  298 */         check_orphaned();
/*  299 */         arraySetterHelper((XmlObject[])param1ArrayOfImport, IMPORT$2);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setImportArray(int param1Int, ImportDocument.Import param1Import) {
/*  308 */       synchronized (monitor()) {
/*      */         
/*  310 */         check_orphaned();
/*  311 */         ImportDocument.Import import_ = null;
/*  312 */         import_ = (ImportDocument.Import)get_store().find_element_user(IMPORT$2, param1Int);
/*  313 */         if (import_ == null)
/*      */         {
/*  315 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  317 */         import_.set((XmlObject)param1Import);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImportDocument.Import insertNewImport(int param1Int) {
/*  326 */       synchronized (monitor()) {
/*      */         
/*  328 */         check_orphaned();
/*  329 */         ImportDocument.Import import_ = null;
/*  330 */         import_ = (ImportDocument.Import)get_store().insert_element_user(IMPORT$2, param1Int);
/*  331 */         return import_;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImportDocument.Import addNewImport() {
/*  340 */       synchronized (monitor()) {
/*      */         
/*  342 */         check_orphaned();
/*  343 */         ImportDocument.Import import_ = null;
/*  344 */         import_ = (ImportDocument.Import)get_store().add_element_user(IMPORT$2);
/*  345 */         return import_;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeImport(int param1Int) {
/*  354 */       synchronized (monitor()) {
/*      */         
/*  356 */         check_orphaned();
/*  357 */         get_store().remove_element(IMPORT$2, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RedefineDocument.Redefine[] getRedefineArray() {
/*  366 */       synchronized (monitor()) {
/*      */         
/*  368 */         check_orphaned();
/*  369 */         ArrayList arrayList = new ArrayList();
/*  370 */         get_store().find_all_element_users(REDEFINE$4, arrayList);
/*  371 */         RedefineDocument.Redefine[] arrayOfRedefine = new RedefineDocument.Redefine[arrayList.size()];
/*  372 */         arrayList.toArray((Object[])arrayOfRedefine);
/*  373 */         return arrayOfRedefine;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RedefineDocument.Redefine getRedefineArray(int param1Int) {
/*  382 */       synchronized (monitor()) {
/*      */         
/*  384 */         check_orphaned();
/*  385 */         RedefineDocument.Redefine redefine = null;
/*  386 */         redefine = (RedefineDocument.Redefine)get_store().find_element_user(REDEFINE$4, param1Int);
/*  387 */         if (redefine == null)
/*      */         {
/*  389 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  391 */         return redefine;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfRedefineArray() {
/*  400 */       synchronized (monitor()) {
/*      */         
/*  402 */         check_orphaned();
/*  403 */         return get_store().count_elements(REDEFINE$4);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setRedefineArray(RedefineDocument.Redefine[] param1ArrayOfRedefine) {
/*  412 */       synchronized (monitor()) {
/*      */         
/*  414 */         check_orphaned();
/*  415 */         arraySetterHelper((XmlObject[])param1ArrayOfRedefine, REDEFINE$4);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setRedefineArray(int param1Int, RedefineDocument.Redefine param1Redefine) {
/*  424 */       synchronized (monitor()) {
/*      */         
/*  426 */         check_orphaned();
/*  427 */         RedefineDocument.Redefine redefine = null;
/*  428 */         redefine = (RedefineDocument.Redefine)get_store().find_element_user(REDEFINE$4, param1Int);
/*  429 */         if (redefine == null)
/*      */         {
/*  431 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  433 */         redefine.set((XmlObject)param1Redefine);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RedefineDocument.Redefine insertNewRedefine(int param1Int) {
/*  442 */       synchronized (monitor()) {
/*      */         
/*  444 */         check_orphaned();
/*  445 */         RedefineDocument.Redefine redefine = null;
/*  446 */         redefine = (RedefineDocument.Redefine)get_store().insert_element_user(REDEFINE$4, param1Int);
/*  447 */         return redefine;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public RedefineDocument.Redefine addNewRedefine() {
/*  456 */       synchronized (monitor()) {
/*      */         
/*  458 */         check_orphaned();
/*  459 */         RedefineDocument.Redefine redefine = null;
/*  460 */         redefine = (RedefineDocument.Redefine)get_store().add_element_user(REDEFINE$4);
/*  461 */         return redefine;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeRedefine(int param1Int) {
/*  470 */       synchronized (monitor()) {
/*      */         
/*  472 */         check_orphaned();
/*  473 */         get_store().remove_element(REDEFINE$4, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDocument.Annotation[] getAnnotationArray() {
/*  482 */       synchronized (monitor()) {
/*      */         
/*  484 */         check_orphaned();
/*  485 */         ArrayList arrayList = new ArrayList();
/*  486 */         get_store().find_all_element_users(ANNOTATION$6, arrayList);
/*  487 */         AnnotationDocument.Annotation[] arrayOfAnnotation = new AnnotationDocument.Annotation[arrayList.size()];
/*  488 */         arrayList.toArray((Object[])arrayOfAnnotation);
/*  489 */         return arrayOfAnnotation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDocument.Annotation getAnnotationArray(int param1Int) {
/*  498 */       synchronized (monitor()) {
/*      */         
/*  500 */         check_orphaned();
/*  501 */         AnnotationDocument.Annotation annotation = null;
/*  502 */         annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$6, param1Int);
/*  503 */         if (annotation == null)
/*      */         {
/*  505 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  507 */         return annotation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfAnnotationArray() {
/*  516 */       synchronized (monitor()) {
/*      */         
/*  518 */         check_orphaned();
/*  519 */         return get_store().count_elements(ANNOTATION$6);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAnnotationArray(AnnotationDocument.Annotation[] param1ArrayOfAnnotation) {
/*  528 */       synchronized (monitor()) {
/*      */         
/*  530 */         check_orphaned();
/*  531 */         arraySetterHelper((XmlObject[])param1ArrayOfAnnotation, ANNOTATION$6);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAnnotationArray(int param1Int, AnnotationDocument.Annotation param1Annotation) {
/*  540 */       synchronized (monitor()) {
/*      */         
/*  542 */         check_orphaned();
/*  543 */         AnnotationDocument.Annotation annotation = null;
/*  544 */         annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$6, param1Int);
/*  545 */         if (annotation == null)
/*      */         {
/*  547 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  549 */         annotation.set((XmlObject)param1Annotation);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDocument.Annotation insertNewAnnotation(int param1Int) {
/*  558 */       synchronized (monitor()) {
/*      */         
/*  560 */         check_orphaned();
/*  561 */         AnnotationDocument.Annotation annotation = null;
/*  562 */         annotation = (AnnotationDocument.Annotation)get_store().insert_element_user(ANNOTATION$6, param1Int);
/*  563 */         return annotation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public AnnotationDocument.Annotation addNewAnnotation() {
/*  572 */       synchronized (monitor()) {
/*      */         
/*  574 */         check_orphaned();
/*  575 */         AnnotationDocument.Annotation annotation = null;
/*  576 */         annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$6);
/*  577 */         return annotation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeAnnotation(int param1Int) {
/*  586 */       synchronized (monitor()) {
/*      */         
/*  588 */         check_orphaned();
/*  589 */         get_store().remove_element(ANNOTATION$6, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelSimpleType[] getSimpleTypeArray() {
/*  598 */       synchronized (monitor()) {
/*      */         
/*  600 */         check_orphaned();
/*  601 */         ArrayList arrayList = new ArrayList();
/*  602 */         get_store().find_all_element_users(SIMPLETYPE$8, arrayList);
/*  603 */         TopLevelSimpleType[] arrayOfTopLevelSimpleType = new TopLevelSimpleType[arrayList.size()];
/*  604 */         arrayList.toArray((Object[])arrayOfTopLevelSimpleType);
/*  605 */         return arrayOfTopLevelSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelSimpleType getSimpleTypeArray(int param1Int) {
/*  614 */       synchronized (monitor()) {
/*      */         
/*  616 */         check_orphaned();
/*  617 */         TopLevelSimpleType topLevelSimpleType = null;
/*  618 */         topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$8, param1Int);
/*  619 */         if (topLevelSimpleType == null)
/*      */         {
/*  621 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  623 */         return topLevelSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfSimpleTypeArray() {
/*  632 */       synchronized (monitor()) {
/*      */         
/*  634 */         check_orphaned();
/*  635 */         return get_store().count_elements(SIMPLETYPE$8);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setSimpleTypeArray(TopLevelSimpleType[] param1ArrayOfTopLevelSimpleType) {
/*  644 */       synchronized (monitor()) {
/*      */         
/*  646 */         check_orphaned();
/*  647 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelSimpleType, SIMPLETYPE$8);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setSimpleTypeArray(int param1Int, TopLevelSimpleType param1TopLevelSimpleType) {
/*  656 */       synchronized (monitor()) {
/*      */         
/*  658 */         check_orphaned();
/*  659 */         TopLevelSimpleType topLevelSimpleType = null;
/*  660 */         topLevelSimpleType = (TopLevelSimpleType)get_store().find_element_user(SIMPLETYPE$8, param1Int);
/*  661 */         if (topLevelSimpleType == null)
/*      */         {
/*  663 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  665 */         topLevelSimpleType.set((XmlObject)param1TopLevelSimpleType);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelSimpleType insertNewSimpleType(int param1Int) {
/*  674 */       synchronized (monitor()) {
/*      */         
/*  676 */         check_orphaned();
/*  677 */         TopLevelSimpleType topLevelSimpleType = null;
/*  678 */         topLevelSimpleType = (TopLevelSimpleType)get_store().insert_element_user(SIMPLETYPE$8, param1Int);
/*  679 */         return topLevelSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelSimpleType addNewSimpleType() {
/*  688 */       synchronized (monitor()) {
/*      */         
/*  690 */         check_orphaned();
/*  691 */         TopLevelSimpleType topLevelSimpleType = null;
/*  692 */         topLevelSimpleType = (TopLevelSimpleType)get_store().add_element_user(SIMPLETYPE$8);
/*  693 */         return topLevelSimpleType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeSimpleType(int param1Int) {
/*  702 */       synchronized (monitor()) {
/*      */         
/*  704 */         check_orphaned();
/*  705 */         get_store().remove_element(SIMPLETYPE$8, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelComplexType[] getComplexTypeArray() {
/*  714 */       synchronized (monitor()) {
/*      */         
/*  716 */         check_orphaned();
/*  717 */         ArrayList arrayList = new ArrayList();
/*  718 */         get_store().find_all_element_users(COMPLEXTYPE$10, arrayList);
/*  719 */         TopLevelComplexType[] arrayOfTopLevelComplexType = new TopLevelComplexType[arrayList.size()];
/*  720 */         arrayList.toArray((Object[])arrayOfTopLevelComplexType);
/*  721 */         return arrayOfTopLevelComplexType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelComplexType getComplexTypeArray(int param1Int) {
/*  730 */       synchronized (monitor()) {
/*      */         
/*  732 */         check_orphaned();
/*  733 */         TopLevelComplexType topLevelComplexType = null;
/*  734 */         topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$10, param1Int);
/*  735 */         if (topLevelComplexType == null)
/*      */         {
/*  737 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  739 */         return topLevelComplexType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfComplexTypeArray() {
/*  748 */       synchronized (monitor()) {
/*      */         
/*  750 */         check_orphaned();
/*  751 */         return get_store().count_elements(COMPLEXTYPE$10);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setComplexTypeArray(TopLevelComplexType[] param1ArrayOfTopLevelComplexType) {
/*  760 */       synchronized (monitor()) {
/*      */         
/*  762 */         check_orphaned();
/*  763 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelComplexType, COMPLEXTYPE$10);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setComplexTypeArray(int param1Int, TopLevelComplexType param1TopLevelComplexType) {
/*  772 */       synchronized (monitor()) {
/*      */         
/*  774 */         check_orphaned();
/*  775 */         TopLevelComplexType topLevelComplexType = null;
/*  776 */         topLevelComplexType = (TopLevelComplexType)get_store().find_element_user(COMPLEXTYPE$10, param1Int);
/*  777 */         if (topLevelComplexType == null)
/*      */         {
/*  779 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  781 */         topLevelComplexType.set((XmlObject)param1TopLevelComplexType);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelComplexType insertNewComplexType(int param1Int) {
/*  790 */       synchronized (monitor()) {
/*      */         
/*  792 */         check_orphaned();
/*  793 */         TopLevelComplexType topLevelComplexType = null;
/*  794 */         topLevelComplexType = (TopLevelComplexType)get_store().insert_element_user(COMPLEXTYPE$10, param1Int);
/*  795 */         return topLevelComplexType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelComplexType addNewComplexType() {
/*  804 */       synchronized (monitor()) {
/*      */         
/*  806 */         check_orphaned();
/*  807 */         TopLevelComplexType topLevelComplexType = null;
/*  808 */         topLevelComplexType = (TopLevelComplexType)get_store().add_element_user(COMPLEXTYPE$10);
/*  809 */         return topLevelComplexType;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeComplexType(int param1Int) {
/*  818 */       synchronized (monitor()) {
/*      */         
/*  820 */         check_orphaned();
/*  821 */         get_store().remove_element(COMPLEXTYPE$10, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedGroup[] getGroupArray() {
/*  830 */       synchronized (monitor()) {
/*      */         
/*  832 */         check_orphaned();
/*  833 */         ArrayList arrayList = new ArrayList();
/*  834 */         get_store().find_all_element_users(GROUP$12, arrayList);
/*  835 */         NamedGroup[] arrayOfNamedGroup = new NamedGroup[arrayList.size()];
/*  836 */         arrayList.toArray((Object[])arrayOfNamedGroup);
/*  837 */         return arrayOfNamedGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedGroup getGroupArray(int param1Int) {
/*  846 */       synchronized (monitor()) {
/*      */         
/*  848 */         check_orphaned();
/*  849 */         NamedGroup namedGroup = null;
/*  850 */         namedGroup = (NamedGroup)get_store().find_element_user(GROUP$12, param1Int);
/*  851 */         if (namedGroup == null)
/*      */         {
/*  853 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  855 */         return namedGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfGroupArray() {
/*  864 */       synchronized (monitor()) {
/*      */         
/*  866 */         check_orphaned();
/*  867 */         return get_store().count_elements(GROUP$12);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setGroupArray(NamedGroup[] param1ArrayOfNamedGroup) {
/*  876 */       synchronized (monitor()) {
/*      */         
/*  878 */         check_orphaned();
/*  879 */         arraySetterHelper((XmlObject[])param1ArrayOfNamedGroup, GROUP$12);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setGroupArray(int param1Int, NamedGroup param1NamedGroup) {
/*  888 */       synchronized (monitor()) {
/*      */         
/*  890 */         check_orphaned();
/*  891 */         NamedGroup namedGroup = null;
/*  892 */         namedGroup = (NamedGroup)get_store().find_element_user(GROUP$12, param1Int);
/*  893 */         if (namedGroup == null)
/*      */         {
/*  895 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  897 */         namedGroup.set((XmlObject)param1NamedGroup);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedGroup insertNewGroup(int param1Int) {
/*  906 */       synchronized (monitor()) {
/*      */         
/*  908 */         check_orphaned();
/*  909 */         NamedGroup namedGroup = null;
/*  910 */         namedGroup = (NamedGroup)get_store().insert_element_user(GROUP$12, param1Int);
/*  911 */         return namedGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedGroup addNewGroup() {
/*  920 */       synchronized (monitor()) {
/*      */         
/*  922 */         check_orphaned();
/*  923 */         NamedGroup namedGroup = null;
/*  924 */         namedGroup = (NamedGroup)get_store().add_element_user(GROUP$12);
/*  925 */         return namedGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeGroup(int param1Int) {
/*  934 */       synchronized (monitor()) {
/*      */         
/*  936 */         check_orphaned();
/*  937 */         get_store().remove_element(GROUP$12, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedAttributeGroup[] getAttributeGroupArray() {
/*  946 */       synchronized (monitor()) {
/*      */         
/*  948 */         check_orphaned();
/*  949 */         ArrayList arrayList = new ArrayList();
/*  950 */         get_store().find_all_element_users(ATTRIBUTEGROUP$14, arrayList);
/*  951 */         NamedAttributeGroup[] arrayOfNamedAttributeGroup = new NamedAttributeGroup[arrayList.size()];
/*  952 */         arrayList.toArray((Object[])arrayOfNamedAttributeGroup);
/*  953 */         return arrayOfNamedAttributeGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedAttributeGroup getAttributeGroupArray(int param1Int) {
/*  962 */       synchronized (monitor()) {
/*      */         
/*  964 */         check_orphaned();
/*  965 */         NamedAttributeGroup namedAttributeGroup = null;
/*  966 */         namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$14, param1Int);
/*  967 */         if (namedAttributeGroup == null)
/*      */         {
/*  969 */           throw new IndexOutOfBoundsException();
/*      */         }
/*  971 */         return namedAttributeGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfAttributeGroupArray() {
/*  980 */       synchronized (monitor()) {
/*      */         
/*  982 */         check_orphaned();
/*  983 */         return get_store().count_elements(ATTRIBUTEGROUP$14);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAttributeGroupArray(NamedAttributeGroup[] param1ArrayOfNamedAttributeGroup) {
/*  992 */       synchronized (monitor()) {
/*      */         
/*  994 */         check_orphaned();
/*  995 */         arraySetterHelper((XmlObject[])param1ArrayOfNamedAttributeGroup, ATTRIBUTEGROUP$14);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAttributeGroupArray(int param1Int, NamedAttributeGroup param1NamedAttributeGroup) {
/* 1004 */       synchronized (monitor()) {
/*      */         
/* 1006 */         check_orphaned();
/* 1007 */         NamedAttributeGroup namedAttributeGroup = null;
/* 1008 */         namedAttributeGroup = (NamedAttributeGroup)get_store().find_element_user(ATTRIBUTEGROUP$14, param1Int);
/* 1009 */         if (namedAttributeGroup == null)
/*      */         {
/* 1011 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1013 */         namedAttributeGroup.set((XmlObject)param1NamedAttributeGroup);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedAttributeGroup insertNewAttributeGroup(int param1Int) {
/* 1022 */       synchronized (monitor()) {
/*      */         
/* 1024 */         check_orphaned();
/* 1025 */         NamedAttributeGroup namedAttributeGroup = null;
/* 1026 */         namedAttributeGroup = (NamedAttributeGroup)get_store().insert_element_user(ATTRIBUTEGROUP$14, param1Int);
/* 1027 */         return namedAttributeGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NamedAttributeGroup addNewAttributeGroup() {
/* 1036 */       synchronized (monitor()) {
/*      */         
/* 1038 */         check_orphaned();
/* 1039 */         NamedAttributeGroup namedAttributeGroup = null;
/* 1040 */         namedAttributeGroup = (NamedAttributeGroup)get_store().add_element_user(ATTRIBUTEGROUP$14);
/* 1041 */         return namedAttributeGroup;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeAttributeGroup(int param1Int) {
/* 1050 */       synchronized (monitor()) {
/*      */         
/* 1052 */         check_orphaned();
/* 1053 */         get_store().remove_element(ATTRIBUTEGROUP$14, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelElement[] getElementArray() {
/* 1062 */       synchronized (monitor()) {
/*      */         
/* 1064 */         check_orphaned();
/* 1065 */         ArrayList arrayList = new ArrayList();
/* 1066 */         get_store().find_all_element_users(ELEMENT$16, arrayList);
/* 1067 */         TopLevelElement[] arrayOfTopLevelElement = new TopLevelElement[arrayList.size()];
/* 1068 */         arrayList.toArray((Object[])arrayOfTopLevelElement);
/* 1069 */         return arrayOfTopLevelElement;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelElement getElementArray(int param1Int) {
/* 1078 */       synchronized (monitor()) {
/*      */         
/* 1080 */         check_orphaned();
/* 1081 */         TopLevelElement topLevelElement = null;
/* 1082 */         topLevelElement = (TopLevelElement)get_store().find_element_user(ELEMENT$16, param1Int);
/* 1083 */         if (topLevelElement == null)
/*      */         {
/* 1085 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1087 */         return topLevelElement;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfElementArray() {
/* 1096 */       synchronized (monitor()) {
/*      */         
/* 1098 */         check_orphaned();
/* 1099 */         return get_store().count_elements(ELEMENT$16);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setElementArray(TopLevelElement[] param1ArrayOfTopLevelElement) {
/* 1108 */       synchronized (monitor()) {
/*      */         
/* 1110 */         check_orphaned();
/* 1111 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelElement, ELEMENT$16);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setElementArray(int param1Int, TopLevelElement param1TopLevelElement) {
/* 1120 */       synchronized (monitor()) {
/*      */         
/* 1122 */         check_orphaned();
/* 1123 */         TopLevelElement topLevelElement = null;
/* 1124 */         topLevelElement = (TopLevelElement)get_store().find_element_user(ELEMENT$16, param1Int);
/* 1125 */         if (topLevelElement == null)
/*      */         {
/* 1127 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1129 */         topLevelElement.set((XmlObject)param1TopLevelElement);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelElement insertNewElement(int param1Int) {
/* 1138 */       synchronized (monitor()) {
/*      */         
/* 1140 */         check_orphaned();
/* 1141 */         TopLevelElement topLevelElement = null;
/* 1142 */         topLevelElement = (TopLevelElement)get_store().insert_element_user(ELEMENT$16, param1Int);
/* 1143 */         return topLevelElement;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelElement addNewElement() {
/* 1152 */       synchronized (monitor()) {
/*      */         
/* 1154 */         check_orphaned();
/* 1155 */         TopLevelElement topLevelElement = null;
/* 1156 */         topLevelElement = (TopLevelElement)get_store().add_element_user(ELEMENT$16);
/* 1157 */         return topLevelElement;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeElement(int param1Int) {
/* 1166 */       synchronized (monitor()) {
/*      */         
/* 1168 */         check_orphaned();
/* 1169 */         get_store().remove_element(ELEMENT$16, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelAttribute[] getAttributeArray() {
/* 1178 */       synchronized (monitor()) {
/*      */         
/* 1180 */         check_orphaned();
/* 1181 */         ArrayList arrayList = new ArrayList();
/* 1182 */         get_store().find_all_element_users(ATTRIBUTE$18, arrayList);
/* 1183 */         TopLevelAttribute[] arrayOfTopLevelAttribute = new TopLevelAttribute[arrayList.size()];
/* 1184 */         arrayList.toArray((Object[])arrayOfTopLevelAttribute);
/* 1185 */         return arrayOfTopLevelAttribute;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelAttribute getAttributeArray(int param1Int) {
/* 1194 */       synchronized (monitor()) {
/*      */         
/* 1196 */         check_orphaned();
/* 1197 */         TopLevelAttribute topLevelAttribute = null;
/* 1198 */         topLevelAttribute = (TopLevelAttribute)get_store().find_element_user(ATTRIBUTE$18, param1Int);
/* 1199 */         if (topLevelAttribute == null)
/*      */         {
/* 1201 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1203 */         return topLevelAttribute;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfAttributeArray() {
/* 1212 */       synchronized (monitor()) {
/*      */         
/* 1214 */         check_orphaned();
/* 1215 */         return get_store().count_elements(ATTRIBUTE$18);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAttributeArray(TopLevelAttribute[] param1ArrayOfTopLevelAttribute) {
/* 1224 */       synchronized (monitor()) {
/*      */         
/* 1226 */         check_orphaned();
/* 1227 */         arraySetterHelper((XmlObject[])param1ArrayOfTopLevelAttribute, ATTRIBUTE$18);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAttributeArray(int param1Int, TopLevelAttribute param1TopLevelAttribute) {
/* 1236 */       synchronized (monitor()) {
/*      */         
/* 1238 */         check_orphaned();
/* 1239 */         TopLevelAttribute topLevelAttribute = null;
/* 1240 */         topLevelAttribute = (TopLevelAttribute)get_store().find_element_user(ATTRIBUTE$18, param1Int);
/* 1241 */         if (topLevelAttribute == null)
/*      */         {
/* 1243 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1245 */         topLevelAttribute.set((XmlObject)param1TopLevelAttribute);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelAttribute insertNewAttribute(int param1Int) {
/* 1254 */       synchronized (monitor()) {
/*      */         
/* 1256 */         check_orphaned();
/* 1257 */         TopLevelAttribute topLevelAttribute = null;
/* 1258 */         topLevelAttribute = (TopLevelAttribute)get_store().insert_element_user(ATTRIBUTE$18, param1Int);
/* 1259 */         return topLevelAttribute;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public TopLevelAttribute addNewAttribute() {
/* 1268 */       synchronized (monitor()) {
/*      */         
/* 1270 */         check_orphaned();
/* 1271 */         TopLevelAttribute topLevelAttribute = null;
/* 1272 */         topLevelAttribute = (TopLevelAttribute)get_store().add_element_user(ATTRIBUTE$18);
/* 1273 */         return topLevelAttribute;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeAttribute(int param1Int) {
/* 1282 */       synchronized (monitor()) {
/*      */         
/* 1284 */         check_orphaned();
/* 1285 */         get_store().remove_element(ATTRIBUTE$18, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NotationDocument.Notation[] getNotationArray() {
/* 1294 */       synchronized (monitor()) {
/*      */         
/* 1296 */         check_orphaned();
/* 1297 */         ArrayList arrayList = new ArrayList();
/* 1298 */         get_store().find_all_element_users(NOTATION$20, arrayList);
/* 1299 */         NotationDocument.Notation[] arrayOfNotation = new NotationDocument.Notation[arrayList.size()];
/* 1300 */         arrayList.toArray((Object[])arrayOfNotation);
/* 1301 */         return arrayOfNotation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NotationDocument.Notation getNotationArray(int param1Int) {
/* 1310 */       synchronized (monitor()) {
/*      */         
/* 1312 */         check_orphaned();
/* 1313 */         NotationDocument.Notation notation = null;
/* 1314 */         notation = (NotationDocument.Notation)get_store().find_element_user(NOTATION$20, param1Int);
/* 1315 */         if (notation == null)
/*      */         {
/* 1317 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1319 */         return notation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int sizeOfNotationArray() {
/* 1328 */       synchronized (monitor()) {
/*      */         
/* 1330 */         check_orphaned();
/* 1331 */         return get_store().count_elements(NOTATION$20);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setNotationArray(NotationDocument.Notation[] param1ArrayOfNotation) {
/* 1340 */       synchronized (monitor()) {
/*      */         
/* 1342 */         check_orphaned();
/* 1343 */         arraySetterHelper((XmlObject[])param1ArrayOfNotation, NOTATION$20);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setNotationArray(int param1Int, NotationDocument.Notation param1Notation) {
/* 1352 */       synchronized (monitor()) {
/*      */         
/* 1354 */         check_orphaned();
/* 1355 */         NotationDocument.Notation notation = null;
/* 1356 */         notation = (NotationDocument.Notation)get_store().find_element_user(NOTATION$20, param1Int);
/* 1357 */         if (notation == null)
/*      */         {
/* 1359 */           throw new IndexOutOfBoundsException();
/*      */         }
/* 1361 */         notation.set((XmlObject)param1Notation);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NotationDocument.Notation insertNewNotation(int param1Int) {
/* 1370 */       synchronized (monitor()) {
/*      */         
/* 1372 */         check_orphaned();
/* 1373 */         NotationDocument.Notation notation = null;
/* 1374 */         notation = (NotationDocument.Notation)get_store().insert_element_user(NOTATION$20, param1Int);
/* 1375 */         return notation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public NotationDocument.Notation addNewNotation() {
/* 1384 */       synchronized (monitor()) {
/*      */         
/* 1386 */         check_orphaned();
/* 1387 */         NotationDocument.Notation notation = null;
/* 1388 */         notation = (NotationDocument.Notation)get_store().add_element_user(NOTATION$20);
/* 1389 */         return notation;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void removeNotation(int param1Int) {
/* 1398 */       synchronized (monitor()) {
/*      */         
/* 1400 */         check_orphaned();
/* 1401 */         get_store().remove_element(NOTATION$20, param1Int);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getTargetNamespace() {
/* 1410 */       synchronized (monitor()) {
/*      */         
/* 1412 */         check_orphaned();
/* 1413 */         SimpleValue simpleValue = null;
/* 1414 */         simpleValue = (SimpleValue)get_store().find_attribute_user(TARGETNAMESPACE$22);
/* 1415 */         if (simpleValue == null)
/*      */         {
/* 1417 */           return null;
/*      */         }
/* 1419 */         return simpleValue.getStringValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlAnyURI xgetTargetNamespace() {
/* 1428 */       synchronized (monitor()) {
/*      */         
/* 1430 */         check_orphaned();
/* 1431 */         XmlAnyURI xmlAnyURI = null;
/* 1432 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGETNAMESPACE$22);
/* 1433 */         return xmlAnyURI;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetTargetNamespace() {
/* 1442 */       synchronized (monitor()) {
/*      */         
/* 1444 */         check_orphaned();
/* 1445 */         return (get_store().find_attribute_user(TARGETNAMESPACE$22) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setTargetNamespace(String param1String) {
/* 1454 */       synchronized (monitor()) {
/*      */         
/* 1456 */         check_orphaned();
/* 1457 */         SimpleValue simpleValue = null;
/* 1458 */         simpleValue = (SimpleValue)get_store().find_attribute_user(TARGETNAMESPACE$22);
/* 1459 */         if (simpleValue == null)
/*      */         {
/* 1461 */           simpleValue = (SimpleValue)get_store().add_attribute_user(TARGETNAMESPACE$22);
/*      */         }
/* 1463 */         simpleValue.setStringValue(param1String);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetTargetNamespace(XmlAnyURI param1XmlAnyURI) {
/* 1472 */       synchronized (monitor()) {
/*      */         
/* 1474 */         check_orphaned();
/* 1475 */         XmlAnyURI xmlAnyURI = null;
/* 1476 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(TARGETNAMESPACE$22);
/* 1477 */         if (xmlAnyURI == null)
/*      */         {
/* 1479 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(TARGETNAMESPACE$22);
/*      */         }
/* 1481 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetTargetNamespace() {
/* 1490 */       synchronized (monitor()) {
/*      */         
/* 1492 */         check_orphaned();
/* 1493 */         get_store().remove_attribute(TARGETNAMESPACE$22);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getVersion() {
/* 1502 */       synchronized (monitor()) {
/*      */         
/* 1504 */         check_orphaned();
/* 1505 */         SimpleValue simpleValue = null;
/* 1506 */         simpleValue = (SimpleValue)get_store().find_attribute_user(VERSION$24);
/* 1507 */         if (simpleValue == null)
/*      */         {
/* 1509 */           return null;
/*      */         }
/* 1511 */         return simpleValue.getStringValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlToken xgetVersion() {
/* 1520 */       synchronized (monitor()) {
/*      */         
/* 1522 */         check_orphaned();
/* 1523 */         XmlToken xmlToken = null;
/* 1524 */         xmlToken = (XmlToken)get_store().find_attribute_user(VERSION$24);
/* 1525 */         return xmlToken;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetVersion() {
/* 1534 */       synchronized (monitor()) {
/*      */         
/* 1536 */         check_orphaned();
/* 1537 */         return (get_store().find_attribute_user(VERSION$24) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setVersion(String param1String) {
/* 1546 */       synchronized (monitor()) {
/*      */         
/* 1548 */         check_orphaned();
/* 1549 */         SimpleValue simpleValue = null;
/* 1550 */         simpleValue = (SimpleValue)get_store().find_attribute_user(VERSION$24);
/* 1551 */         if (simpleValue == null)
/*      */         {
/* 1553 */           simpleValue = (SimpleValue)get_store().add_attribute_user(VERSION$24);
/*      */         }
/* 1555 */         simpleValue.setStringValue(param1String);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetVersion(XmlToken param1XmlToken) {
/* 1564 */       synchronized (monitor()) {
/*      */         
/* 1566 */         check_orphaned();
/* 1567 */         XmlToken xmlToken = null;
/* 1568 */         xmlToken = (XmlToken)get_store().find_attribute_user(VERSION$24);
/* 1569 */         if (xmlToken == null)
/*      */         {
/* 1571 */           xmlToken = (XmlToken)get_store().add_attribute_user(VERSION$24);
/*      */         }
/* 1573 */         xmlToken.set((XmlObject)param1XmlToken);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetVersion() {
/* 1582 */       synchronized (monitor()) {
/*      */         
/* 1584 */         check_orphaned();
/* 1585 */         get_store().remove_attribute(VERSION$24);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getFinalDefault() {
/* 1594 */       synchronized (monitor()) {
/*      */         
/* 1596 */         check_orphaned();
/* 1597 */         SimpleValue simpleValue = null;
/* 1598 */         simpleValue = (SimpleValue)get_store().find_attribute_user(FINALDEFAULT$26);
/* 1599 */         if (simpleValue == null)
/*      */         {
/* 1601 */           simpleValue = (SimpleValue)get_default_attribute_value(FINALDEFAULT$26);
/*      */         }
/* 1603 */         if (simpleValue == null)
/*      */         {
/* 1605 */           return null;
/*      */         }
/* 1607 */         return simpleValue.getObjectValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FullDerivationSet xgetFinalDefault() {
/* 1616 */       synchronized (monitor()) {
/*      */         
/* 1618 */         check_orphaned();
/* 1619 */         FullDerivationSet fullDerivationSet = null;
/* 1620 */         fullDerivationSet = (FullDerivationSet)get_store().find_attribute_user(FINALDEFAULT$26);
/* 1621 */         if (fullDerivationSet == null)
/*      */         {
/* 1623 */           fullDerivationSet = (FullDerivationSet)get_default_attribute_value(FINALDEFAULT$26);
/*      */         }
/* 1625 */         return fullDerivationSet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetFinalDefault() {
/* 1634 */       synchronized (monitor()) {
/*      */         
/* 1636 */         check_orphaned();
/* 1637 */         return (get_store().find_attribute_user(FINALDEFAULT$26) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setFinalDefault(Object param1Object) {
/* 1646 */       synchronized (monitor()) {
/*      */         
/* 1648 */         check_orphaned();
/* 1649 */         SimpleValue simpleValue = null;
/* 1650 */         simpleValue = (SimpleValue)get_store().find_attribute_user(FINALDEFAULT$26);
/* 1651 */         if (simpleValue == null)
/*      */         {
/* 1653 */           simpleValue = (SimpleValue)get_store().add_attribute_user(FINALDEFAULT$26);
/*      */         }
/* 1655 */         simpleValue.setObjectValue(param1Object);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetFinalDefault(FullDerivationSet param1FullDerivationSet) {
/* 1664 */       synchronized (monitor()) {
/*      */         
/* 1666 */         check_orphaned();
/* 1667 */         FullDerivationSet fullDerivationSet = null;
/* 1668 */         fullDerivationSet = (FullDerivationSet)get_store().find_attribute_user(FINALDEFAULT$26);
/* 1669 */         if (fullDerivationSet == null)
/*      */         {
/* 1671 */           fullDerivationSet = (FullDerivationSet)get_store().add_attribute_user(FINALDEFAULT$26);
/*      */         }
/* 1673 */         fullDerivationSet.set((XmlObject)param1FullDerivationSet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetFinalDefault() {
/* 1682 */       synchronized (monitor()) {
/*      */         
/* 1684 */         check_orphaned();
/* 1685 */         get_store().remove_attribute(FINALDEFAULT$26);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Object getBlockDefault() {
/* 1694 */       synchronized (monitor()) {
/*      */         
/* 1696 */         check_orphaned();
/* 1697 */         SimpleValue simpleValue = null;
/* 1698 */         simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCKDEFAULT$28);
/* 1699 */         if (simpleValue == null)
/*      */         {
/* 1701 */           simpleValue = (SimpleValue)get_default_attribute_value(BLOCKDEFAULT$28);
/*      */         }
/* 1703 */         if (simpleValue == null)
/*      */         {
/* 1705 */           return null;
/*      */         }
/* 1707 */         return simpleValue.getObjectValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public BlockSet xgetBlockDefault() {
/* 1716 */       synchronized (monitor()) {
/*      */         
/* 1718 */         check_orphaned();
/* 1719 */         BlockSet blockSet = null;
/* 1720 */         blockSet = (BlockSet)get_store().find_attribute_user(BLOCKDEFAULT$28);
/* 1721 */         if (blockSet == null)
/*      */         {
/* 1723 */           blockSet = (BlockSet)get_default_attribute_value(BLOCKDEFAULT$28);
/*      */         }
/* 1725 */         return blockSet;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetBlockDefault() {
/* 1734 */       synchronized (monitor()) {
/*      */         
/* 1736 */         check_orphaned();
/* 1737 */         return (get_store().find_attribute_user(BLOCKDEFAULT$28) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setBlockDefault(Object param1Object) {
/* 1746 */       synchronized (monitor()) {
/*      */         
/* 1748 */         check_orphaned();
/* 1749 */         SimpleValue simpleValue = null;
/* 1750 */         simpleValue = (SimpleValue)get_store().find_attribute_user(BLOCKDEFAULT$28);
/* 1751 */         if (simpleValue == null)
/*      */         {
/* 1753 */           simpleValue = (SimpleValue)get_store().add_attribute_user(BLOCKDEFAULT$28);
/*      */         }
/* 1755 */         simpleValue.setObjectValue(param1Object);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetBlockDefault(BlockSet param1BlockSet) {
/* 1764 */       synchronized (monitor()) {
/*      */         
/* 1766 */         check_orphaned();
/* 1767 */         BlockSet blockSet = null;
/* 1768 */         blockSet = (BlockSet)get_store().find_attribute_user(BLOCKDEFAULT$28);
/* 1769 */         if (blockSet == null)
/*      */         {
/* 1771 */           blockSet = (BlockSet)get_store().add_attribute_user(BLOCKDEFAULT$28);
/*      */         }
/* 1773 */         blockSet.set((XmlObject)param1BlockSet);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetBlockDefault() {
/* 1782 */       synchronized (monitor()) {
/*      */         
/* 1784 */         check_orphaned();
/* 1785 */         get_store().remove_attribute(BLOCKDEFAULT$28);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FormChoice.Enum getAttributeFormDefault() {
/* 1794 */       synchronized (monitor()) {
/*      */         
/* 1796 */         check_orphaned();
/* 1797 */         SimpleValue simpleValue = null;
/* 1798 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/* 1799 */         if (simpleValue == null)
/*      */         {
/* 1801 */           simpleValue = (SimpleValue)get_default_attribute_value(ATTRIBUTEFORMDEFAULT$30);
/*      */         }
/* 1803 */         if (simpleValue == null)
/*      */         {
/* 1805 */           return null;
/*      */         }
/* 1807 */         return (FormChoice.Enum)simpleValue.getEnumValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FormChoice xgetAttributeFormDefault() {
/* 1816 */       synchronized (monitor()) {
/*      */         
/* 1818 */         check_orphaned();
/* 1819 */         FormChoice formChoice = null;
/* 1820 */         formChoice = (FormChoice)get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/* 1821 */         if (formChoice == null)
/*      */         {
/* 1823 */           formChoice = (FormChoice)get_default_attribute_value(ATTRIBUTEFORMDEFAULT$30);
/*      */         }
/* 1825 */         return formChoice;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetAttributeFormDefault() {
/* 1834 */       synchronized (monitor()) {
/*      */         
/* 1836 */         check_orphaned();
/* 1837 */         return (get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setAttributeFormDefault(FormChoice.Enum param1Enum) {
/* 1846 */       synchronized (monitor()) {
/*      */         
/* 1848 */         check_orphaned();
/* 1849 */         SimpleValue simpleValue = null;
/* 1850 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/* 1851 */         if (simpleValue == null)
/*      */         {
/* 1853 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/*      */         }
/* 1855 */         simpleValue.setEnumValue((StringEnumAbstractBase)param1Enum);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetAttributeFormDefault(FormChoice param1FormChoice) {
/* 1864 */       synchronized (monitor()) {
/*      */         
/* 1866 */         check_orphaned();
/* 1867 */         FormChoice formChoice = null;
/* 1868 */         formChoice = (FormChoice)get_store().find_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/* 1869 */         if (formChoice == null)
/*      */         {
/* 1871 */           formChoice = (FormChoice)get_store().add_attribute_user(ATTRIBUTEFORMDEFAULT$30);
/*      */         }
/* 1873 */         formChoice.set((XmlObject)param1FormChoice);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetAttributeFormDefault() {
/* 1882 */       synchronized (monitor()) {
/*      */         
/* 1884 */         check_orphaned();
/* 1885 */         get_store().remove_attribute(ATTRIBUTEFORMDEFAULT$30);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FormChoice.Enum getElementFormDefault() {
/* 1894 */       synchronized (monitor()) {
/*      */         
/* 1896 */         check_orphaned();
/* 1897 */         SimpleValue simpleValue = null;
/* 1898 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ELEMENTFORMDEFAULT$32);
/* 1899 */         if (simpleValue == null)
/*      */         {
/* 1901 */           simpleValue = (SimpleValue)get_default_attribute_value(ELEMENTFORMDEFAULT$32);
/*      */         }
/* 1903 */         if (simpleValue == null)
/*      */         {
/* 1905 */           return null;
/*      */         }
/* 1907 */         return (FormChoice.Enum)simpleValue.getEnumValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public FormChoice xgetElementFormDefault() {
/* 1916 */       synchronized (monitor()) {
/*      */         
/* 1918 */         check_orphaned();
/* 1919 */         FormChoice formChoice = null;
/* 1920 */         formChoice = (FormChoice)get_store().find_attribute_user(ELEMENTFORMDEFAULT$32);
/* 1921 */         if (formChoice == null)
/*      */         {
/* 1923 */           formChoice = (FormChoice)get_default_attribute_value(ELEMENTFORMDEFAULT$32);
/*      */         }
/* 1925 */         return formChoice;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetElementFormDefault() {
/* 1934 */       synchronized (monitor()) {
/*      */         
/* 1936 */         check_orphaned();
/* 1937 */         return (get_store().find_attribute_user(ELEMENTFORMDEFAULT$32) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setElementFormDefault(FormChoice.Enum param1Enum) {
/* 1946 */       synchronized (monitor()) {
/*      */         
/* 1948 */         check_orphaned();
/* 1949 */         SimpleValue simpleValue = null;
/* 1950 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ELEMENTFORMDEFAULT$32);
/* 1951 */         if (simpleValue == null)
/*      */         {
/* 1953 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ELEMENTFORMDEFAULT$32);
/*      */         }
/* 1955 */         simpleValue.setEnumValue((StringEnumAbstractBase)param1Enum);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetElementFormDefault(FormChoice param1FormChoice) {
/* 1964 */       synchronized (monitor()) {
/*      */         
/* 1966 */         check_orphaned();
/* 1967 */         FormChoice formChoice = null;
/* 1968 */         formChoice = (FormChoice)get_store().find_attribute_user(ELEMENTFORMDEFAULT$32);
/* 1969 */         if (formChoice == null)
/*      */         {
/* 1971 */           formChoice = (FormChoice)get_store().add_attribute_user(ELEMENTFORMDEFAULT$32);
/*      */         }
/* 1973 */         formChoice.set((XmlObject)param1FormChoice);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetElementFormDefault() {
/* 1982 */       synchronized (monitor()) {
/*      */         
/* 1984 */         check_orphaned();
/* 1985 */         get_store().remove_attribute(ELEMENTFORMDEFAULT$32);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getId() {
/* 1994 */       synchronized (monitor()) {
/*      */         
/* 1996 */         check_orphaned();
/* 1997 */         SimpleValue simpleValue = null;
/* 1998 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$34);
/* 1999 */         if (simpleValue == null)
/*      */         {
/* 2001 */           return null;
/*      */         }
/* 2003 */         return simpleValue.getStringValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlID xgetId() {
/* 2012 */       synchronized (monitor()) {
/*      */         
/* 2014 */         check_orphaned();
/* 2015 */         XmlID xmlID = null;
/* 2016 */         xmlID = (XmlID)get_store().find_attribute_user(ID$34);
/* 2017 */         return xmlID;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetId() {
/* 2026 */       synchronized (monitor()) {
/*      */         
/* 2028 */         check_orphaned();
/* 2029 */         return (get_store().find_attribute_user(ID$34) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setId(String param1String) {
/* 2038 */       synchronized (monitor()) {
/*      */         
/* 2040 */         check_orphaned();
/* 2041 */         SimpleValue simpleValue = null;
/* 2042 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$34);
/* 2043 */         if (simpleValue == null)
/*      */         {
/* 2045 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ID$34);
/*      */         }
/* 2047 */         simpleValue.setStringValue(param1String);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetId(XmlID param1XmlID) {
/* 2056 */       synchronized (monitor()) {
/*      */         
/* 2058 */         check_orphaned();
/* 2059 */         XmlID xmlID = null;
/* 2060 */         xmlID = (XmlID)get_store().find_attribute_user(ID$34);
/* 2061 */         if (xmlID == null)
/*      */         {
/* 2063 */           xmlID = (XmlID)get_store().add_attribute_user(ID$34);
/*      */         }
/* 2065 */         xmlID.set((XmlObject)param1XmlID);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetId() {
/* 2074 */       synchronized (monitor()) {
/*      */         
/* 2076 */         check_orphaned();
/* 2077 */         get_store().remove_attribute(ID$34);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getLang() {
/* 2086 */       synchronized (monitor()) {
/*      */         
/* 2088 */         check_orphaned();
/* 2089 */         SimpleValue simpleValue = null;
/* 2090 */         simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$36);
/* 2091 */         if (simpleValue == null)
/*      */         {
/* 2093 */           return null;
/*      */         }
/* 2095 */         return simpleValue.getStringValue();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public XmlLanguage xgetLang() {
/* 2104 */       synchronized (monitor()) {
/*      */         
/* 2106 */         check_orphaned();
/* 2107 */         XmlLanguage xmlLanguage = null;
/* 2108 */         xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$36);
/* 2109 */         return xmlLanguage;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isSetLang() {
/* 2118 */       synchronized (monitor()) {
/*      */         
/* 2120 */         check_orphaned();
/* 2121 */         return (get_store().find_attribute_user(LANG$36) != null);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setLang(String param1String) {
/* 2130 */       synchronized (monitor()) {
/*      */         
/* 2132 */         check_orphaned();
/* 2133 */         SimpleValue simpleValue = null;
/* 2134 */         simpleValue = (SimpleValue)get_store().find_attribute_user(LANG$36);
/* 2135 */         if (simpleValue == null)
/*      */         {
/* 2137 */           simpleValue = (SimpleValue)get_store().add_attribute_user(LANG$36);
/*      */         }
/* 2139 */         simpleValue.setStringValue(param1String);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void xsetLang(XmlLanguage param1XmlLanguage) {
/* 2148 */       synchronized (monitor()) {
/*      */         
/* 2150 */         check_orphaned();
/* 2151 */         XmlLanguage xmlLanguage = null;
/* 2152 */         xmlLanguage = (XmlLanguage)get_store().find_attribute_user(LANG$36);
/* 2153 */         if (xmlLanguage == null)
/*      */         {
/* 2155 */           xmlLanguage = (XmlLanguage)get_store().add_attribute_user(LANG$36);
/*      */         }
/* 2157 */         xmlLanguage.set((XmlObject)param1XmlLanguage);
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void unsetLang() {
/* 2166 */       synchronized (monitor()) {
/*      */         
/* 2168 */         check_orphaned();
/* 2169 */         get_store().remove_attribute(LANG$36);
/*      */       } 
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\SchemaDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */