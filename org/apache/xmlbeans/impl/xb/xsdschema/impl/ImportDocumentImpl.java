/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ImportDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements ImportDocument
/*     */ {
/*     */   public ImportDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b IMPORT$0 = new b("http://www.w3.org/2001/XMLSchema", "import");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImportDocument.Import getImport() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       ImportDocument.Import import_ = null;
/*  36 */       import_ = (ImportDocument.Import)get_store().find_element_user(IMPORT$0, 0);
/*  37 */       if (import_ == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return import_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setImport(ImportDocument.Import paramImport) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       ImportDocument.Import import_ = null;
/*  54 */       import_ = (ImportDocument.Import)get_store().find_element_user(IMPORT$0, 0);
/*  55 */       if (import_ == null)
/*     */       {
/*  57 */         import_ = (ImportDocument.Import)get_store().add_element_user(IMPORT$0);
/*     */       }
/*  59 */       import_.set((XmlObject)paramImport);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ImportDocument.Import addNewImport() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       ImportDocument.Import import_ = null;
/*  72 */       import_ = (ImportDocument.Import)get_store().add_element_user(IMPORT$0);
/*  73 */       return import_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ImportImpl
/*     */     extends AnnotatedImpl
/*     */     implements ImportDocument.Import
/*     */   {
/*     */     public ImportImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b NAMESPACE$0 = new b("", "namespace");
/*     */     
/*  91 */     private static final b SCHEMALOCATION$2 = new b("", "schemaLocation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getNamespace() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         SimpleValue simpleValue = null;
/* 104 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/* 105 */         if (simpleValue == null)
/*     */         {
/* 107 */           return null;
/*     */         }
/* 109 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetNamespace() {
/* 118 */       synchronized (monitor()) {
/*     */         
/* 120 */         check_orphaned();
/* 121 */         XmlAnyURI xmlAnyURI = null;
/* 122 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(NAMESPACE$0);
/* 123 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetNamespace() {
/* 132 */       synchronized (monitor()) {
/*     */         
/* 134 */         check_orphaned();
/* 135 */         return (get_store().find_attribute_user(NAMESPACE$0) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNamespace(String param1String) {
/* 144 */       synchronized (monitor()) {
/*     */         
/* 146 */         check_orphaned();
/* 147 */         SimpleValue simpleValue = null;
/* 148 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/* 149 */         if (simpleValue == null)
/*     */         {
/* 151 */           simpleValue = (SimpleValue)get_store().add_attribute_user(NAMESPACE$0);
/*     */         }
/* 153 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetNamespace(XmlAnyURI param1XmlAnyURI) {
/* 162 */       synchronized (monitor()) {
/*     */         
/* 164 */         check_orphaned();
/* 165 */         XmlAnyURI xmlAnyURI = null;
/* 166 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(NAMESPACE$0);
/* 167 */         if (xmlAnyURI == null)
/*     */         {
/* 169 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(NAMESPACE$0);
/*     */         }
/* 171 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetNamespace() {
/* 180 */       synchronized (monitor()) {
/*     */         
/* 182 */         check_orphaned();
/* 183 */         get_store().remove_attribute(NAMESPACE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSchemaLocation() {
/* 192 */       synchronized (monitor()) {
/*     */         
/* 194 */         check_orphaned();
/* 195 */         SimpleValue simpleValue = null;
/* 196 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$2);
/* 197 */         if (simpleValue == null)
/*     */         {
/* 199 */           return null;
/*     */         }
/* 201 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSchemaLocation() {
/* 210 */       synchronized (monitor()) {
/*     */         
/* 212 */         check_orphaned();
/* 213 */         XmlAnyURI xmlAnyURI = null;
/* 214 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$2);
/* 215 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetSchemaLocation() {
/* 224 */       synchronized (monitor()) {
/*     */         
/* 226 */         check_orphaned();
/* 227 */         return (get_store().find_attribute_user(SCHEMALOCATION$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSchemaLocation(String param1String) {
/* 236 */       synchronized (monitor()) {
/*     */         
/* 238 */         check_orphaned();
/* 239 */         SimpleValue simpleValue = null;
/* 240 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SCHEMALOCATION$2);
/* 241 */         if (simpleValue == null)
/*     */         {
/* 243 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SCHEMALOCATION$2);
/*     */         }
/* 245 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSchemaLocation(XmlAnyURI param1XmlAnyURI) {
/* 254 */       synchronized (monitor()) {
/*     */         
/* 256 */         check_orphaned();
/* 257 */         XmlAnyURI xmlAnyURI = null;
/* 258 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SCHEMALOCATION$2);
/* 259 */         if (xmlAnyURI == null)
/*     */         {
/* 261 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SCHEMALOCATION$2);
/*     */         }
/* 263 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetSchemaLocation() {
/* 272 */       synchronized (monitor()) {
/*     */         
/* 274 */         check_orphaned();
/* 275 */         get_store().remove_attribute(SCHEMALOCATION$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ImportDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */