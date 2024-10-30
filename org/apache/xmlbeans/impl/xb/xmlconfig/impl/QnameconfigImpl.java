/*     */ package org.apache.xmlbeans.impl.xb.xmlconfig.impl;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Qnameconfig;
/*     */ import org.apache.xmlbeans.impl.xb.xmlconfig.Qnametargetlist;
/*     */ 
/*     */ public class QnameconfigImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements Qnameconfig
/*     */ {
/*     */   public QnameconfigImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b NAME$0 = new b("", "name");
/*     */   
/*  24 */   private static final b JAVANAME$2 = new b("", "javaname");
/*     */   
/*  26 */   private static final b TARGET$4 = new b("", "target");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public b getName() {
/*  35 */     synchronized (monitor()) {
/*     */       
/*  37 */       check_orphaned();
/*  38 */       SimpleValue simpleValue = null;
/*  39 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/*  40 */       if (simpleValue == null)
/*     */       {
/*  42 */         return null;
/*     */       }
/*  44 */       return simpleValue.getQNameValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlQName xgetName() {
/*  53 */     synchronized (monitor()) {
/*     */       
/*  55 */       check_orphaned();
/*  56 */       XmlQName xmlQName = null;
/*  57 */       xmlQName = (XmlQName)get_store().find_attribute_user(NAME$0);
/*  58 */       return xmlQName;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetName() {
/*  67 */     synchronized (monitor()) {
/*     */       
/*  69 */       check_orphaned();
/*  70 */       return (get_store().find_attribute_user(NAME$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setName(b paramb) {
/*  79 */     synchronized (monitor()) {
/*     */       
/*  81 */       check_orphaned();
/*  82 */       SimpleValue simpleValue = null;
/*  83 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAME$0);
/*  84 */       if (simpleValue == null)
/*     */       {
/*  86 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAME$0);
/*     */       }
/*  88 */       simpleValue.setQNameValue(paramb);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetName(XmlQName paramXmlQName) {
/*  97 */     synchronized (monitor()) {
/*     */       
/*  99 */       check_orphaned();
/* 100 */       XmlQName xmlQName = null;
/* 101 */       xmlQName = (XmlQName)get_store().find_attribute_user(NAME$0);
/* 102 */       if (xmlQName == null)
/*     */       {
/* 104 */         xmlQName = (XmlQName)get_store().add_attribute_user(NAME$0);
/*     */       }
/* 106 */       xmlQName.set((XmlObject)paramXmlQName);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetName() {
/* 115 */     synchronized (monitor()) {
/*     */       
/* 117 */       check_orphaned();
/* 118 */       get_store().remove_attribute(NAME$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getJavaname() {
/* 127 */     synchronized (monitor()) {
/*     */       
/* 129 */       check_orphaned();
/* 130 */       SimpleValue simpleValue = null;
/* 131 */       simpleValue = (SimpleValue)get_store().find_attribute_user(JAVANAME$2);
/* 132 */       if (simpleValue == null)
/*     */       {
/* 134 */         return null;
/*     */       }
/* 136 */       return simpleValue.getStringValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlString xgetJavaname() {
/* 145 */     synchronized (monitor()) {
/*     */       
/* 147 */       check_orphaned();
/* 148 */       XmlString xmlString = null;
/* 149 */       xmlString = (XmlString)get_store().find_attribute_user(JAVANAME$2);
/* 150 */       return xmlString;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetJavaname() {
/* 159 */     synchronized (monitor()) {
/*     */       
/* 161 */       check_orphaned();
/* 162 */       return (get_store().find_attribute_user(JAVANAME$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setJavaname(String paramString) {
/* 171 */     synchronized (monitor()) {
/*     */       
/* 173 */       check_orphaned();
/* 174 */       SimpleValue simpleValue = null;
/* 175 */       simpleValue = (SimpleValue)get_store().find_attribute_user(JAVANAME$2);
/* 176 */       if (simpleValue == null)
/*     */       {
/* 178 */         simpleValue = (SimpleValue)get_store().add_attribute_user(JAVANAME$2);
/*     */       }
/* 180 */       simpleValue.setStringValue(paramString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetJavaname(XmlString paramXmlString) {
/* 189 */     synchronized (monitor()) {
/*     */       
/* 191 */       check_orphaned();
/* 192 */       XmlString xmlString = null;
/* 193 */       xmlString = (XmlString)get_store().find_attribute_user(JAVANAME$2);
/* 194 */       if (xmlString == null)
/*     */       {
/* 196 */         xmlString = (XmlString)get_store().add_attribute_user(JAVANAME$2);
/*     */       }
/* 198 */       xmlString.set((XmlObject)paramXmlString);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetJavaname() {
/* 207 */     synchronized (monitor()) {
/*     */       
/* 209 */       check_orphaned();
/* 210 */       get_store().remove_attribute(JAVANAME$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getTarget() {
/* 219 */     synchronized (monitor()) {
/*     */       
/* 221 */       check_orphaned();
/* 222 */       SimpleValue simpleValue = null;
/* 223 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$4);
/* 224 */       if (simpleValue == null)
/*     */       {
/* 226 */         simpleValue = (SimpleValue)get_default_attribute_value(TARGET$4);
/*     */       }
/* 228 */       if (simpleValue == null)
/*     */       {
/* 230 */         return null;
/*     */       }
/* 232 */       return simpleValue.getListValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Qnametargetlist xgetTarget() {
/* 241 */     synchronized (monitor()) {
/*     */       
/* 243 */       check_orphaned();
/* 244 */       Qnametargetlist qnametargetlist = null;
/* 245 */       qnametargetlist = (Qnametargetlist)get_store().find_attribute_user(TARGET$4);
/* 246 */       if (qnametargetlist == null)
/*     */       {
/* 248 */         qnametargetlist = (Qnametargetlist)get_default_attribute_value(TARGET$4);
/*     */       }
/* 250 */       return qnametargetlist;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetTarget() {
/* 259 */     synchronized (monitor()) {
/*     */       
/* 261 */       check_orphaned();
/* 262 */       return (get_store().find_attribute_user(TARGET$4) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTarget(List paramList) {
/* 271 */     synchronized (monitor()) {
/*     */       
/* 273 */       check_orphaned();
/* 274 */       SimpleValue simpleValue = null;
/* 275 */       simpleValue = (SimpleValue)get_store().find_attribute_user(TARGET$4);
/* 276 */       if (simpleValue == null)
/*     */       {
/* 278 */         simpleValue = (SimpleValue)get_store().add_attribute_user(TARGET$4);
/*     */       }
/* 280 */       simpleValue.setListValue(paramList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetTarget(Qnametargetlist paramQnametargetlist) {
/* 289 */     synchronized (monitor()) {
/*     */       
/* 291 */       check_orphaned();
/* 292 */       Qnametargetlist qnametargetlist = null;
/* 293 */       qnametargetlist = (Qnametargetlist)get_store().find_attribute_user(TARGET$4);
/* 294 */       if (qnametargetlist == null)
/*     */       {
/* 296 */         qnametargetlist = (Qnametargetlist)get_store().add_attribute_user(TARGET$4);
/*     */       }
/* 298 */       qnametargetlist.set((XmlObject)paramQnametargetlist);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetTarget() {
/* 307 */     synchronized (monitor()) {
/*     */       
/* 309 */       check_orphaned();
/* 310 */       get_store().remove_attribute(TARGET$4);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xmlconfig\impl\QnameconfigImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */