/*     */ package org.apache.xmlbeans.impl.xb.xsdschema.impl;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.All;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ExplicitGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.RealGroup;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class RealGroupImpl
/*     */   extends GroupImpl
/*     */   implements RealGroup
/*     */ {
/*     */   public RealGroupImpl(SchemaType paramSchemaType) {
/*  19 */     super(paramSchemaType);
/*     */   }
/*     */   
/*  22 */   private static final b ALL$0 = new b("http://www.w3.org/2001/XMLSchema", "all");
/*     */   
/*  24 */   private static final b CHOICE$2 = new b("http://www.w3.org/2001/XMLSchema", "choice");
/*     */   
/*  26 */   private static final b SEQUENCE$4 = new b("http://www.w3.org/2001/XMLSchema", "sequence");
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All[] getAllArray() {
/*  35 */     synchronized (monitor()) {
/*     */       
/*  37 */       check_orphaned();
/*  38 */       ArrayList arrayList = new ArrayList();
/*  39 */       get_store().find_all_element_users(ALL$0, arrayList);
/*  40 */       All[] arrayOfAll = new All[arrayList.size()];
/*  41 */       arrayList.toArray((Object[])arrayOfAll);
/*  42 */       return arrayOfAll;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All getAllArray(int paramInt) {
/*  51 */     synchronized (monitor()) {
/*     */       
/*  53 */       check_orphaned();
/*  54 */       All all = null;
/*  55 */       all = (All)get_store().find_element_user(ALL$0, paramInt);
/*  56 */       if (all == null)
/*     */       {
/*  58 */         throw new IndexOutOfBoundsException();
/*     */       }
/*  60 */       return all;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfAllArray() {
/*  69 */     synchronized (monitor()) {
/*     */       
/*  71 */       check_orphaned();
/*  72 */       return get_store().count_elements(ALL$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllArray(All[] paramArrayOfAll) {
/*  81 */     synchronized (monitor()) {
/*     */       
/*  83 */       check_orphaned();
/*  84 */       arraySetterHelper((XmlObject[])paramArrayOfAll, ALL$0);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAllArray(int paramInt, All paramAll) {
/*  93 */     synchronized (monitor()) {
/*     */       
/*  95 */       check_orphaned();
/*  96 */       All all = null;
/*  97 */       all = (All)get_store().find_element_user(ALL$0, paramInt);
/*  98 */       if (all == null)
/*     */       {
/* 100 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 102 */       all.set((XmlObject)paramAll);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All insertNewAll(int paramInt) {
/* 111 */     synchronized (monitor()) {
/*     */       
/* 113 */       check_orphaned();
/* 114 */       All all = null;
/* 115 */       all = (All)get_store().insert_element_user(ALL$0, paramInt);
/* 116 */       return all;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public All addNewAll() {
/* 125 */     synchronized (monitor()) {
/*     */       
/* 127 */       check_orphaned();
/* 128 */       All all = null;
/* 129 */       all = (All)get_store().add_element_user(ALL$0);
/* 130 */       return all;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeAll(int paramInt) {
/* 139 */     synchronized (monitor()) {
/*     */       
/* 141 */       check_orphaned();
/* 142 */       get_store().remove_element(ALL$0, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup[] getChoiceArray() {
/* 151 */     synchronized (monitor()) {
/*     */       
/* 153 */       check_orphaned();
/* 154 */       ArrayList arrayList = new ArrayList();
/* 155 */       get_store().find_all_element_users(CHOICE$2, arrayList);
/* 156 */       ExplicitGroup[] arrayOfExplicitGroup = new ExplicitGroup[arrayList.size()];
/* 157 */       arrayList.toArray((Object[])arrayOfExplicitGroup);
/* 158 */       return arrayOfExplicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup getChoiceArray(int paramInt) {
/* 167 */     synchronized (monitor()) {
/*     */       
/* 169 */       check_orphaned();
/* 170 */       ExplicitGroup explicitGroup = null;
/* 171 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$2, paramInt);
/* 172 */       if (explicitGroup == null)
/*     */       {
/* 174 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 176 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfChoiceArray() {
/* 185 */     synchronized (monitor()) {
/*     */       
/* 187 */       check_orphaned();
/* 188 */       return get_store().count_elements(CHOICE$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChoiceArray(ExplicitGroup[] paramArrayOfExplicitGroup) {
/* 197 */     synchronized (monitor()) {
/*     */       
/* 199 */       check_orphaned();
/* 200 */       arraySetterHelper((XmlObject[])paramArrayOfExplicitGroup, CHOICE$2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setChoiceArray(int paramInt, ExplicitGroup paramExplicitGroup) {
/* 209 */     synchronized (monitor()) {
/*     */       
/* 211 */       check_orphaned();
/* 212 */       ExplicitGroup explicitGroup = null;
/* 213 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(CHOICE$2, paramInt);
/* 214 */       if (explicitGroup == null)
/*     */       {
/* 216 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 218 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup insertNewChoice(int paramInt) {
/* 227 */     synchronized (monitor()) {
/*     */       
/* 229 */       check_orphaned();
/* 230 */       ExplicitGroup explicitGroup = null;
/* 231 */       explicitGroup = (ExplicitGroup)get_store().insert_element_user(CHOICE$2, paramInt);
/* 232 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup addNewChoice() {
/* 241 */     synchronized (monitor()) {
/*     */       
/* 243 */       check_orphaned();
/* 244 */       ExplicitGroup explicitGroup = null;
/* 245 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(CHOICE$2);
/* 246 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeChoice(int paramInt) {
/* 255 */     synchronized (monitor()) {
/*     */       
/* 257 */       check_orphaned();
/* 258 */       get_store().remove_element(CHOICE$2, paramInt);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup[] getSequenceArray() {
/* 267 */     synchronized (monitor()) {
/*     */       
/* 269 */       check_orphaned();
/* 270 */       ArrayList arrayList = new ArrayList();
/* 271 */       get_store().find_all_element_users(SEQUENCE$4, arrayList);
/* 272 */       ExplicitGroup[] arrayOfExplicitGroup = new ExplicitGroup[arrayList.size()];
/* 273 */       arrayList.toArray((Object[])arrayOfExplicitGroup);
/* 274 */       return arrayOfExplicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup getSequenceArray(int paramInt) {
/* 283 */     synchronized (monitor()) {
/*     */       
/* 285 */       check_orphaned();
/* 286 */       ExplicitGroup explicitGroup = null;
/* 287 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$4, paramInt);
/* 288 */       if (explicitGroup == null)
/*     */       {
/* 290 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 292 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int sizeOfSequenceArray() {
/* 301 */     synchronized (monitor()) {
/*     */       
/* 303 */       check_orphaned();
/* 304 */       return get_store().count_elements(SEQUENCE$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceArray(ExplicitGroup[] paramArrayOfExplicitGroup) {
/* 313 */     synchronized (monitor()) {
/*     */       
/* 315 */       check_orphaned();
/* 316 */       arraySetterHelper((XmlObject[])paramArrayOfExplicitGroup, SEQUENCE$4);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSequenceArray(int paramInt, ExplicitGroup paramExplicitGroup) {
/* 325 */     synchronized (monitor()) {
/*     */       
/* 327 */       check_orphaned();
/* 328 */       ExplicitGroup explicitGroup = null;
/* 329 */       explicitGroup = (ExplicitGroup)get_store().find_element_user(SEQUENCE$4, paramInt);
/* 330 */       if (explicitGroup == null)
/*     */       {
/* 332 */         throw new IndexOutOfBoundsException();
/*     */       }
/* 334 */       explicitGroup.set((XmlObject)paramExplicitGroup);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup insertNewSequence(int paramInt) {
/* 343 */     synchronized (monitor()) {
/*     */       
/* 345 */       check_orphaned();
/* 346 */       ExplicitGroup explicitGroup = null;
/* 347 */       explicitGroup = (ExplicitGroup)get_store().insert_element_user(SEQUENCE$4, paramInt);
/* 348 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ExplicitGroup addNewSequence() {
/* 357 */     synchronized (monitor()) {
/*     */       
/* 359 */       check_orphaned();
/* 360 */       ExplicitGroup explicitGroup = null;
/* 361 */       explicitGroup = (ExplicitGroup)get_store().add_element_user(SEQUENCE$4);
/* 362 */       return explicitGroup;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void removeSequence(int paramInt) {
/* 371 */     synchronized (monitor()) {
/*     */       
/* 373 */       check_orphaned();
/* 374 */       get_store().remove_element(SEQUENCE$4, paramInt);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xb\xsdschema\impl\RealGroupImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */