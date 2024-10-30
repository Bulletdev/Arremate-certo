/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.values.XmlComplexContentImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlListImpl;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.LocalSimpleType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.UnionDocument;
/*     */ 
/*     */ 
/*     */ public class UnionDocumentImpl
/*     */   extends XmlComplexContentImpl
/*     */   implements UnionDocument
/*     */ {
/*     */   public UnionDocumentImpl(SchemaType paramSchemaType) {
/*  20 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  23 */   private static final b UNION$0 = new b("http://www.w3.org/2001/XMLSchema", "union");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnionDocument.Union getUnion() {
/*  32 */     synchronized (monitor()) {
/*     */       
/*  34 */       check_orphaned();
/*  35 */       UnionDocument.Union union = null;
/*  36 */       union = (UnionDocument.Union)get_store().find_element_user(UNION$0, 0);
/*  37 */       if (union == null)
/*     */       {
/*  39 */         return null;
/*     */       }
/*  41 */       return union;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnion(UnionDocument.Union paramUnion) {
/*  50 */     synchronized (monitor()) {
/*     */       
/*  52 */       check_orphaned();
/*  53 */       UnionDocument.Union union = null;
/*  54 */       union = (UnionDocument.Union)get_store().find_element_user(UNION$0, 0);
/*  55 */       if (union == null)
/*     */       {
/*  57 */         union = (UnionDocument.Union)get_store().add_element_user(UNION$0);
/*     */       }
/*  59 */       union.set((XmlObject)paramUnion);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public UnionDocument.Union addNewUnion() {
/*  68 */     synchronized (monitor()) {
/*     */       
/*  70 */       check_orphaned();
/*  71 */       UnionDocument.Union union = null;
/*  72 */       union = (UnionDocument.Union)get_store().add_element_user(UNION$0);
/*  73 */       return union;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class UnionImpl
/*     */     extends AnnotatedImpl
/*     */     implements UnionDocument.Union
/*     */   {
/*     */     public UnionImpl(SchemaType param1SchemaType) {
/*  86 */       super(param1SchemaType);
/*     */     }
/*     */     
/*  89 */     private static final b SIMPLETYPE$0 = new b("http://www.w3.org/2001/XMLSchema", "simpleType");
/*     */     
/*  91 */     private static final b MEMBERTYPES$2 = new b("", "memberTypes");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType[] getSimpleTypeArray() {
/* 100 */       synchronized (monitor()) {
/*     */         
/* 102 */         check_orphaned();
/* 103 */         ArrayList arrayList = new ArrayList();
/* 104 */         get_store().find_all_element_users(SIMPLETYPE$0, arrayList);
/* 105 */         LocalSimpleType[] arrayOfLocalSimpleType = new LocalSimpleType[arrayList.size()];
/* 106 */         arrayList.toArray((Object[])arrayOfLocalSimpleType);
/* 107 */         return arrayOfLocalSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType getSimpleTypeArray(int param1Int) {
/* 116 */       synchronized (monitor()) {
/*     */         
/* 118 */         check_orphaned();
/* 119 */         LocalSimpleType localSimpleType = null;
/* 120 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, param1Int);
/* 121 */         if (localSimpleType == null)
/*     */         {
/* 123 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 125 */         return localSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int sizeOfSimpleTypeArray() {
/* 134 */       synchronized (monitor()) {
/*     */         
/* 136 */         check_orphaned();
/* 137 */         return get_store().count_elements(SIMPLETYPE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSimpleTypeArray(LocalSimpleType[] param1ArrayOfLocalSimpleType) {
/* 146 */       synchronized (monitor()) {
/*     */         
/* 148 */         check_orphaned();
/* 149 */         arraySetterHelper((XmlObject[])param1ArrayOfLocalSimpleType, SIMPLETYPE$0);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setSimpleTypeArray(int param1Int, LocalSimpleType param1LocalSimpleType) {
/* 158 */       synchronized (monitor()) {
/*     */         
/* 160 */         check_orphaned();
/* 161 */         LocalSimpleType localSimpleType = null;
/* 162 */         localSimpleType = (LocalSimpleType)get_store().find_element_user(SIMPLETYPE$0, param1Int);
/* 163 */         if (localSimpleType == null)
/*     */         {
/* 165 */           throw new IndexOutOfBoundsException();
/*     */         }
/* 167 */         localSimpleType.set((XmlObject)param1LocalSimpleType);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType insertNewSimpleType(int param1Int) {
/* 176 */       synchronized (monitor()) {
/*     */         
/* 178 */         check_orphaned();
/* 179 */         LocalSimpleType localSimpleType = null;
/* 180 */         localSimpleType = (LocalSimpleType)get_store().insert_element_user(SIMPLETYPE$0, param1Int);
/* 181 */         return localSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public LocalSimpleType addNewSimpleType() {
/* 190 */       synchronized (monitor()) {
/*     */         
/* 192 */         check_orphaned();
/* 193 */         LocalSimpleType localSimpleType = null;
/* 194 */         localSimpleType = (LocalSimpleType)get_store().add_element_user(SIMPLETYPE$0);
/* 195 */         return localSimpleType;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void removeSimpleType(int param1Int) {
/* 204 */       synchronized (monitor()) {
/*     */         
/* 206 */         check_orphaned();
/* 207 */         get_store().remove_element(SIMPLETYPE$0, param1Int);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public List getMemberTypes() {
/* 216 */       synchronized (monitor()) {
/*     */         
/* 218 */         check_orphaned();
/* 219 */         SimpleValue simpleValue = null;
/* 220 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MEMBERTYPES$2);
/* 221 */         if (simpleValue == null)
/*     */         {
/* 223 */           return null;
/*     */         }
/* 225 */         return simpleValue.getListValue();
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public UnionDocument.Union.MemberTypes xgetMemberTypes() {
/* 234 */       synchronized (monitor()) {
/*     */         
/* 236 */         check_orphaned();
/* 237 */         UnionDocument.Union.MemberTypes memberTypes = null;
/* 238 */         memberTypes = (UnionDocument.Union.MemberTypes)get_store().find_attribute_user(MEMBERTYPES$2);
/* 239 */         return memberTypes;
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isSetMemberTypes() {
/* 248 */       synchronized (monitor()) {
/*     */         
/* 250 */         check_orphaned();
/* 251 */         return (get_store().find_attribute_user(MEMBERTYPES$2) != null);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setMemberTypes(List param1List) {
/* 260 */       synchronized (monitor()) {
/*     */         
/* 262 */         check_orphaned();
/* 263 */         SimpleValue simpleValue = null;
/* 264 */         simpleValue = (SimpleValue)get_store().find_attribute_user(MEMBERTYPES$2);
/* 265 */         if (simpleValue == null)
/*     */         {
/* 267 */           simpleValue = (SimpleValue)get_store().add_attribute_user(MEMBERTYPES$2);
/*     */         }
/* 269 */         simpleValue.setListValue(param1List);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void xsetMemberTypes(UnionDocument.Union.MemberTypes param1MemberTypes) {
/* 278 */       synchronized (monitor()) {
/*     */         
/* 280 */         check_orphaned();
/* 281 */         UnionDocument.Union.MemberTypes memberTypes = null;
/* 282 */         memberTypes = (UnionDocument.Union.MemberTypes)get_store().find_attribute_user(MEMBERTYPES$2);
/* 283 */         if (memberTypes == null)
/*     */         {
/* 285 */           memberTypes = (UnionDocument.Union.MemberTypes)get_store().add_attribute_user(MEMBERTYPES$2);
/*     */         }
/* 287 */         memberTypes.set((XmlObject)param1MemberTypes);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void unsetMemberTypes() {
/* 296 */       synchronized (monitor()) {
/*     */         
/* 298 */         check_orphaned();
/* 299 */         get_store().remove_attribute(MEMBERTYPES$2);
/*     */       } 
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public static class MemberTypesImpl
/*     */       extends XmlListImpl
/*     */       implements UnionDocument.Union.MemberTypes
/*     */     {
/*     */       public MemberTypesImpl(SchemaType param2SchemaType) {
/* 312 */         super(param2SchemaType, false);
/*     */       }
/*     */ 
/*     */       
/*     */       protected MemberTypesImpl(SchemaType param2SchemaType, boolean param2Boolean) {
/* 317 */         super(param2SchemaType, param2Boolean);
/*     */       }
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\UnionDocumentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */