/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Usertypeconfig;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class UsertypeconfigImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements Usertypeconfig
/*     */ {
/*     */   public UsertypeconfigImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b STATICHANDLER$0 = new b("http://xml.apache.org/xmlbeans/2004/02/xbean/config", "staticHandler");
/*     */   
/*  24 */   private static final b NAME$2 = new b("", "name");
/*     */   
/*  26 */   private static final b JAVANAME$4 = new b("", "javaname");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getStaticHandler() {
/*  35 */     synchronized (monitor()) {
/*     */       
/*  37 */       check_orphaned();
/*  38 */       SimpleValue simpleValue = null;
/*  39 */       simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/*  40 */       if (simpleValue == null)
/*     */       {
/*  42 */         return null;
/*     */       }
/*  44 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetStaticHandler() {
/*  53 */     synchronized (monitor()) {
/*     */       
/*  55 */       check_orphaned();
/*  56 */       XmlString xmlString = null;
/*  57 */       xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/*  58 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setStaticHandler(String paramString) {
/*  67 */     synchronized (monitor()) {
/*     */       
/*  69 */       check_orphaned();
/*  70 */       SimpleValue simpleValue = null;
/*  71 */       simpleValue = (SimpleValue)get_store().find_element_user(STATICHANDLER$0, 0);
/*  72 */       if (simpleValue == null)
/*     */       {
/*  74 */         simpleValue = (SimpleValue)get_store().add_element_user(STATICHANDLER$0);
/*     */       }
/*  76 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetStaticHandler(XmlString paramXmlString) {
/*  85 */     synchronized (monitor()) {
/*     */       
/*  87 */       check_orphaned();
/*  88 */       XmlString xmlString = null;
/*  89 */       xmlString = (XmlString)get_store().find_element_user(STATICHANDLER$0, 0);
/*  90 */       if (xmlString == null)
/*     */       {
/*  92 */         xmlString = (XmlString)get_store().add_element_user(STATICHANDLER$0);
/*     */       }
/*  94 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getName() {
/* 103 */     synchronized (monitor()) {
/*     */       
/* 105 */       check_orphaned();
/* 106 */       SimpleValue simpleValue = null;
/* 107 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 108 */       if (simpleValue == null)
/*     */       {
/* 110 */         return null;
/*     */       }
/* 112 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetName() {
/* 121 */     synchronized (monitor()) {
/*     */       
/* 123 */       check_orphaned();
/* 124 */       XmlQName xmlQName = null;
/* 125 */       xmlQName = (XmlQName)get_store().find_attribute_user(NAME$2);
/* 126 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/* 135 */     synchronized (monitor()) {
/*     */       
/* 137 */       check_orphaned();
/* 138 */       return (get_store().find_attribute_user(NAME$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(b paramb) {
/* 147 */     synchronized (monitor()) {
/*     */       
/* 149 */       check_orphaned();
/* 150 */       SimpleValue simpleValue = null;
/* 151 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$2);
/* 152 */       if (simpleValue == null)
/*     */       {
/* 154 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$2);
/*     */       }
/* 156 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlQName paramXmlQName) {
/* 165 */     synchronized (monitor()) {
/*     */       
/* 167 */       check_orphaned();
/* 168 */       XmlQName xmlQName = null;
/* 169 */       xmlQName = (XmlQName)get_store().find_attribute_user(NAME$2);
/* 170 */       if (xmlQName == null)
/*     */       {
/* 172 */         xmlQName = (XmlQName)get_store().add_attribute_user(NAME$2);
/*     */       }
/* 174 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 183 */     synchronized (monitor()) {
/*     */       
/* 185 */       check_orphaned();
/* 186 */       get_store().remove_attribute(NAME$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getJavaname() {
/* 195 */     synchronized (monitor()) {
/*     */       
/* 197 */       check_orphaned();
/* 198 */       SimpleValue simpleValue = null;
/* 199 */       simpleValue = (SimpleValue)get_store().find_attribute_user(JAVANAME$4);
/* 200 */       if (simpleValue == null)
/*     */       {
/* 202 */         return null;
/*     */       }
/* 204 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetJavaname() {
/* 213 */     synchronized (monitor()) {
/*     */       
/* 215 */       check_orphaned();
/* 216 */       XmlString xmlString = null;
/* 217 */       xmlString = (XmlString)get_store().find_attribute_user(JAVANAME$4);
/* 218 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetJavaname() {
/* 227 */     synchronized (monitor()) {
/*     */       
/* 229 */       check_orphaned();
/* 230 */       return (get_store().find_attribute_user(JAVANAME$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJavaname(String paramString) {
/* 239 */     synchronized (monitor()) {
/*     */       
/* 241 */       check_orphaned();
/* 242 */       SimpleValue simpleValue = null;
/* 243 */       simpleValue = (SimpleValue)get_store().find_attribute_user(JAVANAME$4);
/* 244 */       if (simpleValue == null)
/*     */       {
/* 246 */         simpleValue = (SimpleValue)get_store().add_attribute_user(JAVANAME$4);
/*     */       }
/* 248 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetJavaname(XmlString paramXmlString) {
/* 257 */     synchronized (monitor()) {
/*     */       
/* 259 */       check_orphaned();
/* 260 */       XmlString xmlString = null;
/* 261 */       xmlString = (XmlString)get_store().find_attribute_user(JAVANAME$4);
/* 262 */       if (xmlString == null)
/*     */       {
/* 264 */         xmlString = (XmlString)get_store().add_attribute_user(JAVANAME$4);
/*     */       }
/* 266 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetJavaname() {
/* 275 */     synchronized (monitor()) {
/*     */       
/* 277 */       check_orphaned();
/* 278 */       get_store().remove_attribute(JAVANAME$4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\UsertypeconfigImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */