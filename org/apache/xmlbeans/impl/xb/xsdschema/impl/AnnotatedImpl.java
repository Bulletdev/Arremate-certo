/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlID;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Annotated;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.AnnotationDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class AnnotatedImpl
/*     */   extends OpenAttrsImpl
/*     */   implements Annotated
/*     */ {
/*     */   public AnnotatedImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b ANNOTATION$0 = new b("http://www.w3.org/2001/XMLSchema", "annotation");
/*     */   
/*  24 */   private static final b ID$2 = new b("", "id");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationDocument.Annotation getAnnotation() {
/*  33 */     synchronized (monitor()) {
/*     */       
/*  35 */       check_orphaned();
/*  36 */       AnnotationDocument.Annotation annotation = null;
/*  37 */       annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, 0);
/*  38 */       if (annotation == null)
/*     */       {
/*  40 */         return null;
/*     */       }
/*  42 */       return annotation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetAnnotation() {
/*  51 */     synchronized (monitor()) {
/*     */       
/*  53 */       check_orphaned();
/*  54 */       return (get_store().count_elements(ANNOTATION$0) != 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAnnotation(AnnotationDocument.Annotation paramAnnotation) {
/*  63 */     synchronized (monitor()) {
/*     */       
/*  65 */       check_orphaned();
/*  66 */       AnnotationDocument.Annotation annotation = null;
/*  67 */       annotation = (AnnotationDocument.Annotation)get_store().find_element_user(ANNOTATION$0, 0);
/*  68 */       if (annotation == null)
/*     */       {
/*  70 */         annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$0);
/*     */       }
/*  72 */       annotation.set((XmlObject)paramAnnotation);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AnnotationDocument.Annotation addNewAnnotation() {
/*  81 */     synchronized (monitor()) {
/*     */       
/*  83 */       check_orphaned();
/*  84 */       AnnotationDocument.Annotation annotation = null;
/*  85 */       annotation = (AnnotationDocument.Annotation)get_store().add_element_user(ANNOTATION$0);
/*  86 */       return annotation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetAnnotation() {
/*  95 */     synchronized (monitor()) {
/*     */       
/*  97 */       check_orphaned();
/*  98 */       get_store().remove_element(ANNOTATION$0, 0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 107 */     synchronized (monitor()) {
/*     */       
/* 109 */       check_orphaned();
/* 110 */       SimpleValue simpleValue = null;
/* 111 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
/* 112 */       if (simpleValue == null)
/*     */       {
/* 114 */         return null;
/*     */       }
/* 116 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlID xgetId() {
/* 125 */     synchronized (monitor()) {
/*     */       
/* 127 */       check_orphaned();
/* 128 */       XmlID xmlID = null;
/* 129 */       xmlID = (XmlID)get_store().find_attribute_user(ID$2);
/* 130 */       return xmlID;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetId() {
/* 139 */     synchronized (monitor()) {
/*     */       
/* 141 */       check_orphaned();
/* 142 */       return (get_store().find_attribute_user(ID$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setId(String paramString) {
/* 151 */     synchronized (monitor()) {
/*     */       
/* 153 */       check_orphaned();
/* 154 */       SimpleValue simpleValue = null;
/* 155 */       simpleValue = (SimpleValue)get_store().find_attribute_user(ID$2);
/* 156 */       if (simpleValue == null)
/*     */       {
/* 158 */         simpleValue = (SimpleValue)get_store().add_attribute_user(ID$2);
/*     */       }
/* 160 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetId(XmlID paramXmlID) {
/* 169 */     synchronized (monitor()) {
/*     */       
/* 171 */       check_orphaned();
/* 172 */       XmlID xmlID = null;
/* 173 */       xmlID = (XmlID)get_store().find_attribute_user(ID$2);
/* 174 */       if (xmlID == null)
/*     */       {
/* 176 */         xmlID = (XmlID)get_store().add_attribute_user(ID$2);
/*     */       }
/* 178 */       xmlID.set((XmlObject)paramXmlID);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetId() {
/* 187 */     synchronized (monitor()) {
/*     */       
/* 189 */       check_orphaned();
/* 190 */       get_store().remove_attribute(ID$2);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\AnnotatedImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */