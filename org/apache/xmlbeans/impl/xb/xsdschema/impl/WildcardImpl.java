/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.JavaStringEnumerationHolderEx;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NamespaceList;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class WildcardImpl
/*     */   extends AnnotatedImpl
/*     */   implements Wildcard
/*     */ {
/*     */   public WildcardImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b NAMESPACE$0 = new b("", "namespace");
/*     */   
/*  24 */   private static final b PROCESSCONTENTS$2 = new b("", "processContents");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getNamespace() {
/*  33 */     synchronized (monitor()) {
/*     */       
/*  35 */       check_orphaned();
/*  36 */       SimpleValue simpleValue = null;
/*  37 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/*  38 */       if (simpleValue == null)
/*     */       {
/*  40 */         simpleValue = (SimpleValue)get_default_attribute_value(NAMESPACE$0);
/*     */       }
/*  42 */       if (simpleValue == null)
/*     */       {
/*  44 */         return null;
/*     */       }
/*  46 */       return simpleValue.getObjectValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NamespaceList xgetNamespace() {
/*  55 */     synchronized (monitor()) {
/*     */       
/*  57 */       check_orphaned();
/*  58 */       NamespaceList namespaceList = null;
/*  59 */       namespaceList = (NamespaceList)get_store().find_attribute_user(NAMESPACE$0);
/*  60 */       if (namespaceList == null)
/*     */       {
/*  62 */         namespaceList = (NamespaceList)get_default_attribute_value(NAMESPACE$0);
/*     */       }
/*  64 */       return namespaceList;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetNamespace() {
/*  73 */     synchronized (monitor()) {
/*     */       
/*  75 */       check_orphaned();
/*  76 */       return (get_store().find_attribute_user(NAMESPACE$0) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNamespace(Object paramObject) {
/*  85 */     synchronized (monitor()) {
/*     */       
/*  87 */       check_orphaned();
/*  88 */       SimpleValue simpleValue = null;
/*  89 */       simpleValue = (SimpleValue)get_store().find_attribute_user(NAMESPACE$0);
/*  90 */       if (simpleValue == null)
/*     */       {
/*  92 */         simpleValue = (SimpleValue)get_store().add_attribute_user(NAMESPACE$0);
/*     */       }
/*  94 */       simpleValue.setObjectValue(paramObject);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetNamespace(NamespaceList paramNamespaceList) {
/* 103 */     synchronized (monitor()) {
/*     */       
/* 105 */       check_orphaned();
/* 106 */       NamespaceList namespaceList = null;
/* 107 */       namespaceList = (NamespaceList)get_store().find_attribute_user(NAMESPACE$0);
/* 108 */       if (namespaceList == null)
/*     */       {
/* 110 */         namespaceList = (NamespaceList)get_store().add_attribute_user(NAMESPACE$0);
/*     */       }
/* 112 */       namespaceList.set((XmlObject)paramNamespaceList);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetNamespace() {
/* 121 */     synchronized (monitor()) {
/*     */       
/* 123 */       check_orphaned();
/* 124 */       get_store().remove_attribute(NAMESPACE$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard.ProcessContents.Enum getProcessContents() {
/* 133 */     synchronized (monitor()) {
/*     */       
/* 135 */       check_orphaned();
/* 136 */       SimpleValue simpleValue = null;
/* 137 */       simpleValue = (SimpleValue)get_store().find_attribute_user(PROCESSCONTENTS$2);
/* 138 */       if (simpleValue == null)
/*     */       {
/* 140 */         simpleValue = (SimpleValue)get_default_attribute_value(PROCESSCONTENTS$2);
/*     */       }
/* 142 */       if (simpleValue == null)
/*     */       {
/* 144 */         return null;
/*     */       }
/* 146 */       return (Wildcard.ProcessContents.Enum)simpleValue.getEnumValue();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Wildcard.ProcessContents xgetProcessContents() {
/* 155 */     synchronized (monitor()) {
/*     */       
/* 157 */       check_orphaned();
/* 158 */       Wildcard.ProcessContents processContents = null;
/* 159 */       processContents = (Wildcard.ProcessContents)get_store().find_attribute_user(PROCESSCONTENTS$2);
/* 160 */       if (processContents == null)
/*     */       {
/* 162 */         processContents = (Wildcard.ProcessContents)get_default_attribute_value(PROCESSCONTENTS$2);
/*     */       }
/* 164 */       return processContents;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isSetProcessContents() {
/* 173 */     synchronized (monitor()) {
/*     */       
/* 175 */       check_orphaned();
/* 176 */       return (get_store().find_attribute_user(PROCESSCONTENTS$2) != null);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setProcessContents(Wildcard.ProcessContents.Enum paramEnum) {
/* 185 */     synchronized (monitor()) {
/*     */       
/* 187 */       check_orphaned();
/* 188 */       SimpleValue simpleValue = null;
/* 189 */       simpleValue = (SimpleValue)get_store().find_attribute_user(PROCESSCONTENTS$2);
/* 190 */       if (simpleValue == null)
/*     */       {
/* 192 */         simpleValue = (SimpleValue)get_store().add_attribute_user(PROCESSCONTENTS$2);
/*     */       }
/* 194 */       simpleValue.setEnumValue((StringEnumAbstractBase)paramEnum);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void xsetProcessContents(Wildcard.ProcessContents paramProcessContents) {
/* 203 */     synchronized (monitor()) {
/*     */       
/* 205 */       check_orphaned();
/* 206 */       Wildcard.ProcessContents processContents = null;
/* 207 */       processContents = (Wildcard.ProcessContents)get_store().find_attribute_user(PROCESSCONTENTS$2);
/* 208 */       if (processContents == null)
/*     */       {
/* 210 */         processContents = (Wildcard.ProcessContents)get_store().add_attribute_user(PROCESSCONTENTS$2);
/*     */       }
/* 212 */       processContents.set((XmlObject)paramProcessContents);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsetProcessContents() {
/* 221 */     synchronized (monitor()) {
/*     */       
/* 223 */       check_orphaned();
/* 224 */       get_store().remove_attribute(PROCESSCONTENTS$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ProcessContentsImpl
/*     */     extends JavaStringEnumerationHolderEx
/*     */     implements Wildcard.ProcessContents
/*     */   {
/*     */     public ProcessContentsImpl(SchemaType param1SchemaType) {
/* 237 */       super(param1SchemaType, false);
/*     */     }
/*     */ 
/*     */     
/*     */     protected ProcessContentsImpl(SchemaType param1SchemaType, boolean param1Boolean) {
/* 242 */       super(param1SchemaType, param1Boolean);
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\WildcardImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */