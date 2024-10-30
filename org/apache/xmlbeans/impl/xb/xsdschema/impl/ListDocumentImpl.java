/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ListDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements ListDocument
/*     */ {
/*     */   public ListDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b LIST$0 = new b("http://www.w3.org/2001/XMLSchema", "list");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListDocument.List getList() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       ListDocument.List list = null;
/*  36 */       list = (ListDocument.List)get_store().find_element_user(LIST$0, 0);
/*  37 */       if (list == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return list;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setList(ListDocument.List paramList) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       ListDocument.List list = null;
/*  54 */       list = (ListDocument.List)get_store().find_element_user(LIST$0, 0);
/*  55 */       if (list == null)
/*     */       {
/*  57 */         list = (ListDocument.List)get_store().add_element_user(LIST$0);
/*     */       }
/*  59 */       list.set((XmlObject)paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ListDocument.List addNewList() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       ListDocument.List list = null;
/*  72 */       list = (ListDocument.List)get_store().add_element_user(LIST$0);
/*  73 */       return list;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ListImpl
/*     */     extends AnnotatedImpl
/*     */     implements ListDocument.List
/*     */   {
/*     */     public ListImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*     */     
/*  91 */     private static final b ITEMTYPE$2 = new b("", "itemType");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType getSimpleType() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         LocalSimpleType localSimpleType = null;
/* 104 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/* 105 */         if (localSimpleType == null)
/*     */         {
/* 107 */           return null;
/*     */         }
/* 109 */         return localSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetSimpleType() {
/* 118 */       synchronized (monitor()) {
/*     */         
/* 120 */         check_orphaned();
/* 121 */         return (get_store().count_elements(SIMPLETYPE$0) != 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSimpleType(LocalSimpleType param1LocalSimpleType) {
/* 130 */       synchronized (monitor()) {
/*     */         
/* 132 */         check_orphaned();
/* 133 */         LocalSimpleType localSimpleType = null;
/* 134 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, 0);
/* 135 */         if (localSimpleType == null)
/*     */         {
/* 137 */           localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/*     */         }
/* 139 */         localSimpleType.set((XmlObject)param1LocalSimpleType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType addNewSimpleType() {
/* 148 */       synchronized (monitor()) {
/*     */         
/* 150 */         check_orphaned();
/* 151 */         LocalSimpleType localSimpleType = null;
/* 152 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/* 153 */         return localSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetSimpleType() {
/* 162 */       synchronized (monitor()) {
/*     */         
/* 164 */         check_orphaned();
/* 165 */         get_store().remove_element(SIMPLETYPE$0, 0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public b getItemType() {
/* 174 */       synchronized (monitor()) {
/*     */         
/* 176 */         check_orphaned();
/* 177 */         SimpleValue simpleValue = null;
/* 178 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMTYPE$2);
/* 179 */         if (simpleValue == null)
/*     */         {
/* 181 */           return null;
/*     */         }
/* 183 */         return simpleValue.getQNameValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public XmlQName xgetItemType() {
/* 192 */       synchronized (monitor()) {
/*     */         
/* 194 */         check_orphaned();
/* 195 */         XmlQName xmlQName = null;
/* 196 */         xmlQName = (XmlQName)get_store().find_attribute_user(ITEMTYPE$2);
/* 197 */         return xmlQName;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetItemType() {
/* 206 */       synchronized (monitor()) {
/*     */         
/* 208 */         check_orphaned();
/* 209 */         return (get_store().find_attribute_user(ITEMTYPE$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setItemType(b param1b) {
/* 218 */       synchronized (monitor()) {
/*     */         
/* 220 */         check_orphaned();
/* 221 */         SimpleValue simpleValue = null;
/* 222 */         simpleValue = (SimpleValue)get_store().find_attribute_user(ITEMTYPE$2);
/* 223 */         if (simpleValue == null)
/*     */         {
/* 225 */           simpleValue = (SimpleValue)get_store().add_attribute_user(ITEMTYPE$2);
/*     */         }
/* 227 */         simpleValue.setQNameValue(param1b);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetItemType(XmlQName param1XmlQName) {
/* 236 */       synchronized (monitor()) {
/*     */         
/* 238 */         check_orphaned();
/* 239 */         XmlQName xmlQName = null;
/* 240 */         xmlQName = (XmlQName)get_store().find_attribute_user(ITEMTYPE$2);
/* 241 */         if (xmlQName == null)
/*     */         {
/* 243 */           xmlQName = (XmlQName)get_store().add_attribute_user(ITEMTYPE$2);
/*     */         }
/* 245 */         xmlQName.set((XmlObject)param1XmlQName);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetItemType() {
/* 254 */       synchronized (monitor()) {
/*     */         
/* 256 */         check_orphaned();
/* 257 */         get_store().remove_attribute(ITEMTYPE$2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\ListDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */