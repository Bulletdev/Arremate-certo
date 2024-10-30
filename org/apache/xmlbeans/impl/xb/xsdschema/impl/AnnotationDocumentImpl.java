/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AppinfoDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.DocumentationDocument;
/*     */ 
/*     */ 
/*     */ public class AnnotationDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements AnnotationDocument
/*     */ {
/*     */   public AnnotationDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b ANNOTATION$0 = new b("http://www.w3.org/2001/XMLSchema", "annotation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationDocument.Annotation getAnnotation() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       AnnotationDocument.Annotation annotation = null;
/*  36 */       annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, 0);
/*  37 */       if (annotation == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return annotation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnnotation(AnnotationDocument.Annotation paramAnnotation) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       AnnotationDocument.Annotation annotation = null;
/*  54 */       annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, 0);
/*  55 */       if (annotation == null)
/*     */       {
/*  57 */         annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$0);
/*     */       }
/*  59 */       annotation.set((XmlObject)paramAnnotation);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationDocument.Annotation addNewAnnotation() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       AnnotationDocument.Annotation annotation = null;
/*  72 */       annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$0);
/*  73 */       return annotation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class AnnotationImpl
/*     */     extends OpenAttrsImpl
/*     */     implements AnnotationDocument.Annotation
/*     */   {
/*     */     public AnnotationImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b APPINFO$0 = new b("http://www.w3.org/2001/XMLSchema", "appinfo");
/*     */     
/*  91 */     private static final b DOCUMENTATION$2 = new b("http://www.w3.org/2001/XMLSchema", "documentation");
/*     */     
/*  93 */     private static final b ID$4 = new b("", "id");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AppinfoDocument.Appinfo[] getAppinfoArray() {
/* 102 */       synchronized (monitor()) {
/*     */         
/* 104 */         check_orphaned();
/* 105 */         ArrayList arrayList = new ArrayList();
/* 106 */         get_store().find_all_element_users(APPINFO$0, arrayList);
/* 107 */         AppinfoDocument.Appinfo[] arrayOfAppinfo = new AppinfoDocument.Appinfo[arrayList.size()];
/* 108 */         arrayList.toArray((Object[])arrayOfAppinfo);
/* 109 */         return arrayOfAppinfo;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AppinfoDocument.Appinfo getAppinfoArray(int param1Int) {
/* 118 */       synchronized (monitor()) {
/*     */         
/* 120 */         check_orphaned();
/* 121 */         AppinfoDocument.Appinfo appinfo = null;
/* 122 */         appinfo = (AppinfoDocument.Appinfo)get_store().find_element_user(APPINFO$0, param1Int);
/* 123 */         if (appinfo == null)
/*     */         {
/* 125 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 127 */         return appinfo;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfAppinfoArray() {
/* 136 */       synchronized (monitor()) {
/*     */         
/* 138 */         check_orphaned();
/* 139 */         return get_store().count_elements(APPINFO$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAppinfoArray(AppinfoDocument.Appinfo[] param1ArrayOfAppinfo) {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         arraySetterHelper((XmlObject[])param1ArrayOfAppinfo, APPINFO$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setAppinfoArray(int param1Int, AppinfoDocument.Appinfo param1Appinfo) {
/* 160 */       synchronized (monitor()) {
/*     */         
/* 162 */         check_orphaned();
/* 163 */         AppinfoDocument.Appinfo appinfo = null;
/* 164 */         appinfo = (AppinfoDocument.Appinfo)get_store().find_element_user(APPINFO$0, param1Int);
/* 165 */         if (appinfo == null)
/*     */         {
/* 167 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 169 */         appinfo.set((XmlObject)param1Appinfo);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AppinfoDocument.Appinfo insertNewAppinfo(int param1Int) {
/* 178 */       synchronized (monitor()) {
/*     */         
/* 180 */         check_orphaned();
/* 181 */         AppinfoDocument.Appinfo appinfo = null;
/* 182 */         appinfo = (AppinfoDocument.Appinfo)get_store().insert_element_user(APPINFO$0, param1Int);
/* 183 */         return appinfo;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public AppinfoDocument.Appinfo addNewAppinfo() {
/* 192 */       synchronized (monitor()) {
/*     */         
/* 194 */         check_orphaned();
/* 195 */         AppinfoDocument.Appinfo appinfo = null;
/* 196 */         appinfo = (AppinfoDocument.Appinfo)get_store().add_element_user(APPINFO$0);
/* 197 */         return appinfo;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeAppinfo(int param1Int) {
/* 206 */       synchronized (monitor()) {
/*     */         
/* 208 */         check_orphaned();
/* 209 */         get_store().remove_element(APPINFO$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DocumentationDocument.Documentation[] getDocumentationArray() {
/* 218 */       synchronized (monitor()) {
/*     */         
/* 220 */         check_orphaned();
/* 221 */         ArrayList arrayList = new ArrayList();
/* 222 */         get_store().find_all_element_users(DOCUMENTATION$2, arrayList);
/* 223 */         DocumentationDocument.Documentation[] arrayOfDocumentation = new DocumentationDocument.Documentation[arrayList.size()];
/* 224 */         arrayList.toArray((Object[])arrayOfDocumentation);
/* 225 */         return arrayOfDocumentation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DocumentationDocument.Documentation getDocumentationArray(int param1Int) {
/* 234 */       synchronized (monitor()) {
/*     */         
/* 236 */         check_orphaned();
/* 237 */         DocumentationDocument.Documentation documentation = null;
/* 238 */         documentation = (DocumentationDocument.Documentation)get_store().find_element_user(DOCUMENTATION$2, param1Int);
/* 239 */         if (documentation == null)
/*     */         {
/* 241 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 243 */         return documentation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfDocumentationArray() {
/* 252 */       synchronized (monitor()) {
/*     */         
/* 254 */         check_orphaned();
/* 255 */         return get_store().count_elements(DOCUMENTATION$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setDocumentationArray(DocumentationDocument.Documentation[] param1ArrayOfDocumentation) {
/* 264 */       synchronized (monitor()) {
/*     */         
/* 266 */         check_orphaned();
/* 267 */         arraySetterHelper((XmlObject[])param1ArrayOfDocumentation, DOCUMENTATION$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setDocumentationArray(int param1Int, DocumentationDocument.Documentation param1Documentation) {
/* 276 */       synchronized (monitor()) {
/*     */         
/* 278 */         check_orphaned();
/* 279 */         DocumentationDocument.Documentation documentation = null;
/* 280 */         documentation = (DocumentationDocument.Documentation)get_store().find_element_user(DOCUMENTATION$2, param1Int);
/* 281 */         if (documentation == null)
/*     */         {
/* 283 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 285 */         documentation.set((XmlObject)param1Documentation);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DocumentationDocument.Documentation insertNewDocumentation(int param1Int) {
/* 294 */       synchronized (monitor()) {
/*     */         
/* 296 */         check_orphaned();
/* 297 */         DocumentationDocument.Documentation documentation = null;
/* 298 */         documentation = (DocumentationDocument.Documentation)get_store().insert_element_user(DOCUMENTATION$2, param1Int);
/* 299 */         return documentation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public DocumentationDocument.Documentation addNewDocumentation() {
/* 308 */       synchronized (monitor()) {
/*     */         
/* 310 */         check_orphaned();
/* 311 */         DocumentationDocument.Documentation documentation = null;
/* 312 */         documentation = (DocumentationDocument.Documentation)get_store().add_element_user(DOCUMENTATION$2);
/* 313 */         return documentation;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeDocumentation(int param1Int) {
/* 322 */       synchronized (monitor()) {
/*     */         
/* 324 */         check_orphaned();
/* 325 */         get_store().remove_element(DOCUMENTATION$2, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getId() {
/* 334 */       synchronized (monitor()) {
/*     */         
/* 336 */         check_orphaned();
/* 337 */         SimpleValue simpleValue = null;
/* 338 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
/* 339 */         if (simpleValue == null)
/*     */         {
/* 341 */           return null;
/*     */         }
/* 343 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlID xgetId() {
/* 352 */       synchronized (monitor()) {
/*     */         
/* 354 */         check_orphaned();
/* 355 */         XmlID xmlID = null;
/* 356 */         xmlID = (XmlID)get_store().find_attribute_user(ID$4);
/* 357 */         return xmlID;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetId() {
/* 366 */       synchronized (monitor()) {
/*     */         
/* 368 */         check_orphaned();
/* 369 */         return (get_store().find_attribute_user(ID$4) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setId(String param1String) {
/* 378 */       synchronized (monitor()) {
/*     */         
/* 380 */         check_orphaned();
/* 381 */         SimpleValue simpleValue = null;
/* 382 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ID$4);
/* 383 */         if (simpleValue == null)
/*     */         {
/* 385 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ID$4);
/*     */         }
/* 387 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetId(XmlID param1XmlID) {
/* 396 */       synchronized (monitor()) {
/*     */         
/* 398 */         check_orphaned();
/* 399 */         XmlID xmlID = null;
/* 400 */         xmlID = (XmlID)get_store().find_attribute_user(ID$4);
/* 401 */         if (xmlID == null)
/*     */         {
/* 403 */           xmlID = (XmlID)get_store().add_attribute_user(ID$4);
/*     */         }
/* 405 */         xmlID.set((XmlObject)param1XmlID);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetId() {
/* 414 */       synchronized (monitor()) {
/*     */         
/* 416 */         check_orphaned();
/* 417 */         get_store().remove_attribute(ID$4);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AnnotationDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */