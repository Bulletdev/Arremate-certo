/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class IncludeDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements IncludeDocument
/*     */ {
/*     */   public IncludeDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b INCLUDE$0 = new b("http://www.w3.org/2001/XMLSchema", "include");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IncludeDocument.Include getInclude() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       IncludeDocument.Include include = null;
/*  36 */       include = (IncludeDocument.Include)get_store().find_element_user(INCLUDE$0, 0);
/*  37 */       if (include == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return include;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInclude(IncludeDocument.Include paramInclude) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       IncludeDocument.Include include = null;
/*  54 */       include = (IncludeDocument.Include)get_store().find_element_user(INCLUDE$0, 0);
/*  55 */       if (include == null)
/*     */       {
/*  57 */         include = (IncludeDocument.Include)get_store().add_element_user(INCLUDE$0);
/*     */       }
/*  59 */       include.set((XmlObject)paramInclude);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IncludeDocument.Include addNewInclude() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       IncludeDocument.Include include = null;
/*  72 */       include = (IncludeDocument.Include)get_store().add_element_user(INCLUDE$0);
/*  73 */       return include;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class IncludeImpl
/*     */     extends AnnotatedImpl
/*     */     implements IncludeDocument.Include
/*     */   {
/*     */     public IncludeImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b SCHEMALOCATION$0 = new b("", "schemaLocation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSchemaLocation() {
/*  98 */       synchronized (monitor()) {
/*     */         
/* 100 */         check_orphaned();
/* 101 */         SimpleValue simpleValue = null;
/* 102 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$0);
/* 103 */         if (simpleValue == null)
/*     */         {
/* 105 */           return null;
/*     */         }
/* 107 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSchemaLocation() {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         XmlAnyURI xmlAnyURI = null;
/* 120 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$0);
/* 121 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSchemaLocation(String param1String) {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         SimpleValue simpleValue = null;
/* 134 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$0);
/* 135 */         if (simpleValue == null)
/*     */         {
/* 137 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SCHEMALOCATION$0);
/*     */         }
/* 139 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSchemaLocation(XmlAnyURI param1XmlAnyURI) {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         XmlAnyURI xmlAnyURI = null;
/* 152 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$0);
/* 153 */         if (xmlAnyURI == null)
/*     */         {
/* 155 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SCHEMALOCATION$0);
/*     */         }
/* 157 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\IncludeDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */