/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlNCName;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NotationDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Public;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NotationDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements NotationDocument
/*     */ {
/*     */   public NotationDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b NOTATION$0 = new b("http://www.w3.org/2001/XMLSchema", "notation");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotationDocument.Notation getNotation() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       NotationDocument.Notation notation = null;
/*  36 */       notation = (NotationDocument.Notation)get_store().find_element_user(NOTATION$0, 0);
/*  37 */       if (notation == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return notation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNotation(NotationDocument.Notation paramNotation) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       NotationDocument.Notation notation = null;
/*  54 */       notation = (NotationDocument.Notation)get_store().find_element_user(NOTATION$0, 0);
/*  55 */       if (notation == null)
/*     */       {
/*  57 */         notation = (NotationDocument.Notation)get_store().add_element_user(NOTATION$0);
/*     */       }
/*  59 */       notation.set((XmlObject)paramNotation);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NotationDocument.Notation addNewNotation() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       NotationDocument.Notation notation = null;
/*  72 */       notation = (NotationDocument.Notation)get_store().add_element_user(NOTATION$0);
/*  73 */       return notation;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class NotationImpl
/*     */     extends AnnotatedImpl
/*     */     implements NotationDocument.Notation
/*     */   {
/*     */     public NotationImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b NAME$0 = new b("", "name");
/*     */     
/*  91 */     private static final b PUBLIC$2 = new b("", "public");
/*     */     
/*  93 */     private static final b SYSTEM$4 = new b("", "system");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 102 */       synchronized (monitor()) {
/*     */         
/* 104 */         check_orphaned();
/* 105 */         SimpleValue simpleValue = null;
/* 106 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/* 107 */         if (simpleValue == null)
/*     */         {
/* 109 */           return null;
/*     */         }
/* 111 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlNCName xgetName() {
/* 120 */       synchronized (monitor()) {
/*     */         
/* 122 */         check_orphaned();
/* 123 */         XmlNCName xmlNCName = null;
/* 124 */         xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$0);
/* 125 */         return xmlNCName;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setName(String param1String) {
/* 134 */       synchronized (monitor()) {
/*     */         
/* 136 */         check_orphaned();
/* 137 */         SimpleValue simpleValue = null;
/* 138 */         simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/* 139 */         if (simpleValue == null)
/*     */         {
/* 141 */           simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0);
/*     */         }
/* 143 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetName(XmlNCName param1XmlNCName) {
/* 152 */       synchronized (monitor()) {
/*     */         
/* 154 */         check_orphaned();
/* 155 */         XmlNCName xmlNCName = null;
/* 156 */         xmlNCName = (XmlNCName)get_store().find_attribute_user(NAME$0);
/* 157 */         if (xmlNCName == null)
/*     */         {
/* 159 */           xmlNCName = (XmlNCName)get_store().add_attribute_user(NAME$0);
/*     */         }
/* 161 */         xmlNCName.set((XmlObject)param1XmlNCName);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getPublic() {
/* 170 */       synchronized (monitor()) {
/*     */         
/* 172 */         check_orphaned();
/* 173 */         SimpleValue simpleValue = null;
/* 174 */         simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLIC$2);
/* 175 */         if (simpleValue == null)
/*     */         {
/* 177 */           return null;
/*     */         }
/* 179 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Public xgetPublic() {
/* 188 */       synchronized (monitor()) {
/*     */         
/* 190 */         check_orphaned();
/* 191 */         Public public_ = null;
/* 192 */         public_ = (Public)get_store().find_attribute_user(PUBLIC$2);
/* 193 */         return public_;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetPublic() {
/* 202 */       synchronized (monitor()) {
/*     */         
/* 204 */         check_orphaned();
/* 205 */         return (get_store().find_attribute_user(PUBLIC$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setPublic(String param1String) {
/* 214 */       synchronized (monitor()) {
/*     */         
/* 216 */         check_orphaned();
/* 217 */         SimpleValue simpleValue = null;
/* 218 */         simpleValue = (SimpleValue)get_store().find_attribute_user(PUBLIC$2);
/* 219 */         if (simpleValue == null)
/*     */         {
/* 221 */           simpleValue = (SimpleValue)get_store().add_attribute_user(PUBLIC$2);
/*     */         }
/* 223 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetPublic(Public param1Public) {
/* 232 */       synchronized (monitor()) {
/*     */         
/* 234 */         check_orphaned();
/* 235 */         Public public_ = null;
/* 236 */         public_ = (Public)get_store().find_attribute_user(PUBLIC$2);
/* 237 */         if (public_ == null)
/*     */         {
/* 239 */           public_ = (Public)get_store().add_attribute_user(PUBLIC$2);
/*     */         }
/* 241 */         public_.set((XmlObject)param1Public);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetPublic() {
/* 250 */       synchronized (monitor()) {
/*     */         
/* 252 */         check_orphaned();
/* 253 */         get_store().remove_attribute(PUBLIC$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getSystem() {
/* 262 */       synchronized (monitor()) {
/*     */         
/* 264 */         check_orphaned();
/* 265 */         SimpleValue simpleValue = null;
/* 266 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SYSTEM$4);
/* 267 */         if (simpleValue == null)
/*     */         {
/* 269 */           return null;
/*     */         }
/* 271 */         return simpleValue.getStringValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlAnyURI xgetSystem() {
/* 280 */       synchronized (monitor()) {
/*     */         
/* 282 */         check_orphaned();
/* 283 */         XmlAnyURI xmlAnyURI = null;
/* 284 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SYSTEM$4);
/* 285 */         return xmlAnyURI;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetSystem() {
/* 294 */       synchronized (monitor()) {
/*     */         
/* 296 */         check_orphaned();
/* 297 */         return (get_store().find_attribute_user(SYSTEM$4) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSystem(String param1String) {
/* 306 */       synchronized (monitor()) {
/*     */         
/* 308 */         check_orphaned();
/* 309 */         SimpleValue simpleValue = null;
/* 310 */         simpleValue = (SimpleValue)get_store().find_attribute_user(SYSTEM$4);
/* 311 */         if (simpleValue == null)
/*     */         {
/* 313 */           simpleValue = (SimpleValue)get_store().add_attribute_user(SYSTEM$4);
/*     */         }
/* 315 */         simpleValue.setStringValue(param1String);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetSystem(XmlAnyURI param1XmlAnyURI) {
/* 324 */       synchronized (monitor()) {
/*     */         
/* 326 */         check_orphaned();
/* 327 */         XmlAnyURI xmlAnyURI = null;
/* 328 */         xmlAnyURI = (XmlAnyURI)get_store().find_attribute_user(SYSTEM$4);
/* 329 */         if (xmlAnyURI == null)
/*     */         {
/* 331 */           xmlAnyURI = (XmlAnyURI)get_store().add_attribute_user(SYSTEM$4);
/*     */         }
/* 333 */         xmlAnyURI.set((XmlObject)param1XmlAnyURI);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetSystem() {
/* 342 */       synchronized (monitor()) {
/*     */         
/* 344 */         check_orphaned();
/* 345 */         get_store().remove_attribute(SYSTEM$4);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\NotationDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */