/*      */ package org.apache.xmlbeans.impl.values;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.List;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.GDate;
/*      */ import org.apache.xmlbeans.GDateSpecification;
/*      */ import org.apache.xmlbeans.GDuration;
/*      */ import org.apache.xmlbeans.GDurationSpecification;
/*      */ import org.apache.xmlbeans.QNameSet;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.StringEnumAbstractBase;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeImpl;
/*      */ import org.apache.xmlbeans.impl.schema.SchemaTypeVisitorImpl;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class XmlComplexContentImpl
/*      */   extends XmlObjectBase
/*      */ {
/*      */   private SchemaTypeImpl _schemaType;
/*      */   static final boolean $assertionsDisabled;
/*      */   
/*      */   public XmlComplexContentImpl(SchemaType paramSchemaType) {
/*   35 */     this._schemaType = (SchemaTypeImpl)paramSchemaType;
/*   36 */     initComplexType(true, true);
/*      */   }
/*      */   
/*      */   public SchemaType schemaType() {
/*   40 */     return (SchemaType)this._schemaType;
/*      */   }
/*      */ 
/*      */   
/*      */   public String compute_text(NamespaceManager paramNamespaceManager) {
/*   45 */     return null;
/*      */   }
/*      */   
/*      */   protected final void set_String(String paramString) {
/*   49 */     assert this._schemaType.getContentType() != 2;
/*      */     
/*   51 */     if (this._schemaType.getContentType() != 4 && !this._schemaType.isNoType())
/*      */     {
/*      */       
/*   54 */       throw new IllegalArgumentException("Type does not allow for textual content: " + this._schemaType);
/*      */     }
/*      */ 
/*      */     
/*   58 */     super.set_String(paramString);
/*      */   }
/*      */ 
/*      */   
/*      */   public void set_text(String paramString) {
/*   63 */     assert this._schemaType.getContentType() == 4 || this._schemaType.isNoType();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void update_from_complex_content() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void set_nil() {}
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equal_to(XmlObject paramXmlObject) {
/*   79 */     if (!this._schemaType.equals(paramXmlObject.schemaType())) {
/*   80 */       return false;
/*      */     }
/*      */     
/*   83 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected int value_hash_code() {
/*   89 */     throw new IllegalStateException("Complex types cannot be used as hash keys");
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TypeStoreVisitor new_visitor() {
/*   95 */     return (TypeStoreVisitor)new SchemaTypeVisitorImpl(this._schemaType.getContentModel());
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean is_child_element_order_sensitive() {
/*  101 */     return schemaType().isOrderSensitive();
/*      */   }
/*      */ 
/*      */   
/*      */   public int get_elementflags(b paramb) {
/*  106 */     SchemaProperty schemaProperty = schemaType().getElementProperty(paramb);
/*  107 */     if (schemaProperty == null)
/*  108 */       return 0; 
/*  109 */     if (schemaProperty.hasDefault() == 1 || schemaProperty.hasFixed() == 1 || schemaProperty.hasNillable() == 1)
/*      */     {
/*      */       
/*  112 */       return -1; } 
/*  113 */     return ((schemaProperty.hasDefault() == 0) ? 0 : 2) | ((schemaProperty.hasFixed() == 0) ? 0 : 4) | ((schemaProperty.hasNillable() == 0) ? 0 : 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String get_default_attribute_text(b paramb) {
/*  122 */     return super.get_default_attribute_text(paramb);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String get_default_element_text(b paramb) {
/*  128 */     SchemaProperty schemaProperty = schemaType().getElementProperty(paramb);
/*  129 */     if (schemaProperty == null)
/*  130 */       return ""; 
/*  131 */     return schemaProperty.getDefaultText();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void unionArraySetterHelper(Object[] paramArrayOfObject, b paramb) {
/*  142 */     byte b1 = (paramArrayOfObject == null) ? 0 : paramArrayOfObject.length;
/*      */     
/*  144 */     TypeStore typeStore = get_store();
/*      */     
/*  146 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  148 */     for (; i > b1; i--) {
/*  149 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  151 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  155 */       if (b2 >= i) {
/*  156 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  158 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  160 */       ((XmlObjectBase)typeStoreUser).objectSet(paramArrayOfObject[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected SimpleValue[] arraySetterHelper(int paramInt, b paramb) {
/*  166 */     SimpleValue[] arrayOfSimpleValue = new SimpleValue[paramInt];
/*      */     
/*  168 */     TypeStore typeStore = get_store();
/*      */     
/*  170 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  172 */     for (; i > paramInt; i--) {
/*  173 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  175 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  179 */       if (b1 >= i) {
/*  180 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  182 */         typeStoreUser = typeStore.find_element_user(paramb, b1);
/*      */       } 
/*  184 */       arrayOfSimpleValue[b1] = (SimpleValue)typeStoreUser;
/*      */     } 
/*      */     
/*  187 */     return arrayOfSimpleValue;
/*      */   }
/*      */ 
/*      */   
/*      */   protected SimpleValue[] arraySetterHelper(int paramInt, b paramb, QNameSet paramQNameSet) {
/*  192 */     SimpleValue[] arrayOfSimpleValue = new SimpleValue[paramInt];
/*      */     
/*  194 */     TypeStore typeStore = get_store();
/*      */     
/*  196 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  198 */     for (; i > paramInt; i--) {
/*  199 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  201 */     for (byte b1 = 0; b1 < paramInt; b1++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  205 */       if (b1 >= i) {
/*  206 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  208 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b1);
/*      */       } 
/*  210 */       arrayOfSimpleValue[b1] = (SimpleValue)typeStoreUser;
/*      */     } 
/*      */     
/*  213 */     return arrayOfSimpleValue;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(boolean[] paramArrayOfboolean, b paramb) {
/*  218 */     byte b1 = (paramArrayOfboolean == null) ? 0 : paramArrayOfboolean.length;
/*      */     
/*  220 */     TypeStore typeStore = get_store();
/*      */     
/*  222 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  224 */     for (; i > b1; i--) {
/*  225 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  227 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  231 */       if (b2 >= i) {
/*  232 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  234 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  236 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfboolean[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(float[] paramArrayOffloat, b paramb) {
/*  242 */     byte b1 = (paramArrayOffloat == null) ? 0 : paramArrayOffloat.length;
/*      */     
/*  244 */     TypeStore typeStore = get_store();
/*      */     
/*  246 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  248 */     for (; i > b1; i--) {
/*  249 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  251 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  255 */       if (b2 >= i) {
/*  256 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  258 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  260 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOffloat[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(double[] paramArrayOfdouble, b paramb) {
/*  266 */     byte b1 = (paramArrayOfdouble == null) ? 0 : paramArrayOfdouble.length;
/*      */     
/*  268 */     TypeStore typeStore = get_store();
/*      */     
/*  270 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  272 */     for (; i > b1; i--) {
/*  273 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  275 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  279 */       if (b2 >= i) {
/*  280 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  282 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  284 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfdouble[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(byte[] paramArrayOfbyte, b paramb) {
/*  290 */     byte b1 = (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length;
/*      */     
/*  292 */     TypeStore typeStore = get_store();
/*      */     
/*  294 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  296 */     for (; i > b1; i--) {
/*  297 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  299 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  303 */       if (b2 >= i) {
/*  304 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  306 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  308 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfbyte[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(short[] paramArrayOfshort, b paramb) {
/*  314 */     byte b1 = (paramArrayOfshort == null) ? 0 : paramArrayOfshort.length;
/*      */     
/*  316 */     TypeStore typeStore = get_store();
/*      */     
/*  318 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  320 */     for (; i > b1; i--) {
/*  321 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  323 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  327 */       if (b2 >= i) {
/*  328 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  330 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  332 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfshort[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(int[] paramArrayOfint, b paramb) {
/*  338 */     byte b1 = (paramArrayOfint == null) ? 0 : paramArrayOfint.length;
/*      */     
/*  340 */     TypeStore typeStore = get_store();
/*      */     
/*  342 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  344 */     for (; i > b1; i--) {
/*  345 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  347 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  351 */       if (b2 >= i) {
/*  352 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  354 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  356 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfint[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(long[] paramArrayOflong, b paramb) {
/*  362 */     byte b1 = (paramArrayOflong == null) ? 0 : paramArrayOflong.length;
/*      */     
/*  364 */     TypeStore typeStore = get_store();
/*      */     
/*  366 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  368 */     for (; i > b1; i--) {
/*  369 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  371 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  375 */       if (b2 >= i) {
/*  376 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  378 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  380 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOflong[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(BigDecimal[] paramArrayOfBigDecimal, b paramb) {
/*  386 */     byte b1 = (paramArrayOfBigDecimal == null) ? 0 : paramArrayOfBigDecimal.length;
/*      */     
/*  388 */     TypeStore typeStore = get_store();
/*      */     
/*  390 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  392 */     for (; i > b1; i--) {
/*  393 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  395 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  399 */       if (b2 >= i) {
/*  400 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  402 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  404 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfBigDecimal[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(BigInteger[] paramArrayOfBigInteger, b paramb) {
/*  410 */     byte b1 = (paramArrayOfBigInteger == null) ? 0 : paramArrayOfBigInteger.length;
/*      */     
/*  412 */     TypeStore typeStore = get_store();
/*      */     
/*  414 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  416 */     for (; i > b1; i--) {
/*  417 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  419 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  423 */       if (b2 >= i) {
/*  424 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  426 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  428 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfBigInteger[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(String[] paramArrayOfString, b paramb) {
/*  434 */     byte b1 = (paramArrayOfString == null) ? 0 : paramArrayOfString.length;
/*      */     
/*  436 */     TypeStore typeStore = get_store();
/*      */     
/*  438 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  440 */     for (; i > b1; i--) {
/*  441 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  443 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  447 */       if (b2 >= i) {
/*  448 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  450 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  452 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfString[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(byte[][] paramArrayOfbyte, b paramb) {
/*  458 */     byte b1 = (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length;
/*      */     
/*  460 */     TypeStore typeStore = get_store();
/*      */     
/*  462 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  464 */     for (; i > b1; i--) {
/*  465 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  467 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  471 */       if (b2 >= i) {
/*  472 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  474 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  476 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfbyte[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(GDate[] paramArrayOfGDate, b paramb) {
/*  482 */     byte b1 = (paramArrayOfGDate == null) ? 0 : paramArrayOfGDate.length;
/*      */     
/*  484 */     TypeStore typeStore = get_store();
/*      */     
/*  486 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  488 */     for (; i > b1; i--) {
/*  489 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  491 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  495 */       if (b2 >= i) {
/*  496 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  498 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  500 */       ((XmlObjectBase)typeStoreUser).set((GDateSpecification)paramArrayOfGDate[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(GDuration[] paramArrayOfGDuration, b paramb) {
/*  506 */     byte b1 = (paramArrayOfGDuration == null) ? 0 : paramArrayOfGDuration.length;
/*      */     
/*  508 */     TypeStore typeStore = get_store();
/*      */     
/*  510 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  512 */     for (; i > b1; i--) {
/*  513 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  515 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  519 */       if (b2 >= i) {
/*  520 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  522 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  524 */       ((XmlObjectBase)typeStoreUser).set((GDurationSpecification)paramArrayOfGDuration[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(Calendar[] paramArrayOfCalendar, b paramb) {
/*  530 */     byte b1 = (paramArrayOfCalendar == null) ? 0 : paramArrayOfCalendar.length;
/*      */     
/*  532 */     TypeStore typeStore = get_store();
/*      */     
/*  534 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  536 */     for (; i > b1; i--) {
/*  537 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  539 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  543 */       if (b2 >= i) {
/*  544 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  546 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  548 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfCalendar[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(Date[] paramArrayOfDate, b paramb) {
/*  554 */     byte b1 = (paramArrayOfDate == null) ? 0 : paramArrayOfDate.length;
/*      */     
/*  556 */     TypeStore typeStore = get_store();
/*      */     
/*  558 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  560 */     for (; i > b1; i--) {
/*  561 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  563 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  567 */       if (b2 >= i) {
/*  568 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  570 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  572 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfDate[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(b[] paramArrayOfb, b paramb) {
/*  578 */     byte b1 = (paramArrayOfb == null) ? 0 : paramArrayOfb.length;
/*      */     
/*  580 */     TypeStore typeStore = get_store();
/*      */     
/*  582 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  584 */     for (; i > b1; i--) {
/*  585 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  587 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  591 */       if (b2 >= i) {
/*  592 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  594 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  596 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfb[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(StringEnumAbstractBase[] paramArrayOfStringEnumAbstractBase, b paramb) {
/*  602 */     byte b1 = (paramArrayOfStringEnumAbstractBase == null) ? 0 : paramArrayOfStringEnumAbstractBase.length;
/*      */     
/*  604 */     TypeStore typeStore = get_store();
/*      */     
/*  606 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  608 */     for (; i > b1; i--) {
/*  609 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  611 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  615 */       if (b2 >= i) {
/*  616 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  618 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  620 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfStringEnumAbstractBase[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(List[] paramArrayOfList, b paramb) {
/*  626 */     byte b1 = (paramArrayOfList == null) ? 0 : paramArrayOfList.length;
/*      */     
/*  628 */     TypeStore typeStore = get_store();
/*      */     
/*  630 */     int i = typeStore.count_elements(paramb);
/*      */     
/*  632 */     for (; i > b1; i--) {
/*  633 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*  635 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  639 */       if (b2 >= i) {
/*  640 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  642 */         typeStoreUser = typeStore.find_element_user(paramb, b2);
/*      */       } 
/*  644 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfList[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void unionArraySetterHelper(Object[] paramArrayOfObject, b paramb, QNameSet paramQNameSet) {
/*  650 */     byte b1 = (paramArrayOfObject == null) ? 0 : paramArrayOfObject.length;
/*      */     
/*  652 */     TypeStore typeStore = get_store();
/*      */     
/*  654 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  656 */     for (; i > b1; i--) {
/*  657 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  659 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  663 */       if (b2 >= i) {
/*  664 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  666 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  668 */       ((XmlObjectBase)typeStoreUser).objectSet(paramArrayOfObject[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(boolean[] paramArrayOfboolean, b paramb, QNameSet paramQNameSet) {
/*  674 */     byte b1 = (paramArrayOfboolean == null) ? 0 : paramArrayOfboolean.length;
/*      */     
/*  676 */     TypeStore typeStore = get_store();
/*      */     
/*  678 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  680 */     for (; i > b1; i--) {
/*  681 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  683 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  687 */       if (b2 >= i) {
/*  688 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  690 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  692 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfboolean[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(float[] paramArrayOffloat, b paramb, QNameSet paramQNameSet) {
/*  698 */     byte b1 = (paramArrayOffloat == null) ? 0 : paramArrayOffloat.length;
/*      */     
/*  700 */     TypeStore typeStore = get_store();
/*      */     
/*  702 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  704 */     for (; i > b1; i--) {
/*  705 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  707 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  711 */       if (b2 >= i) {
/*  712 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  714 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  716 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOffloat[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(double[] paramArrayOfdouble, b paramb, QNameSet paramQNameSet) {
/*  722 */     byte b1 = (paramArrayOfdouble == null) ? 0 : paramArrayOfdouble.length;
/*      */     
/*  724 */     TypeStore typeStore = get_store();
/*      */     
/*  726 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  728 */     for (; i > b1; i--) {
/*  729 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  731 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  735 */       if (b2 >= i) {
/*  736 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  738 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  740 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfdouble[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(byte[] paramArrayOfbyte, b paramb, QNameSet paramQNameSet) {
/*  746 */     byte b1 = (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length;
/*      */     
/*  748 */     TypeStore typeStore = get_store();
/*      */     
/*  750 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  752 */     for (; i > b1; i--) {
/*  753 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  755 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  759 */       if (b2 >= i) {
/*  760 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  762 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  764 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfbyte[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(short[] paramArrayOfshort, b paramb, QNameSet paramQNameSet) {
/*  770 */     byte b1 = (paramArrayOfshort == null) ? 0 : paramArrayOfshort.length;
/*      */     
/*  772 */     TypeStore typeStore = get_store();
/*      */     
/*  774 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  776 */     for (; i > b1; i--) {
/*  777 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  779 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  783 */       if (b2 >= i) {
/*  784 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  786 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  788 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfshort[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(int[] paramArrayOfint, b paramb, QNameSet paramQNameSet) {
/*  794 */     byte b1 = (paramArrayOfint == null) ? 0 : paramArrayOfint.length;
/*      */     
/*  796 */     TypeStore typeStore = get_store();
/*      */     
/*  798 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  800 */     for (; i > b1; i--) {
/*  801 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  803 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  807 */       if (b2 >= i) {
/*  808 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  810 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  812 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfint[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(long[] paramArrayOflong, b paramb, QNameSet paramQNameSet) {
/*  818 */     byte b1 = (paramArrayOflong == null) ? 0 : paramArrayOflong.length;
/*      */     
/*  820 */     TypeStore typeStore = get_store();
/*      */     
/*  822 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  824 */     for (; i > b1; i--) {
/*  825 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  827 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  831 */       if (b2 >= i) {
/*  832 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  834 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  836 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOflong[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(BigDecimal[] paramArrayOfBigDecimal, b paramb, QNameSet paramQNameSet) {
/*  842 */     byte b1 = (paramArrayOfBigDecimal == null) ? 0 : paramArrayOfBigDecimal.length;
/*      */     
/*  844 */     TypeStore typeStore = get_store();
/*      */     
/*  846 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  848 */     for (; i > b1; i--) {
/*  849 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  851 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  855 */       if (b2 >= i) {
/*  856 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  858 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  860 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfBigDecimal[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(BigInteger[] paramArrayOfBigInteger, b paramb, QNameSet paramQNameSet) {
/*  866 */     byte b1 = (paramArrayOfBigInteger == null) ? 0 : paramArrayOfBigInteger.length;
/*      */     
/*  868 */     TypeStore typeStore = get_store();
/*      */     
/*  870 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  872 */     for (; i > b1; i--) {
/*  873 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  875 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  879 */       if (b2 >= i) {
/*  880 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  882 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  884 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfBigInteger[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(String[] paramArrayOfString, b paramb, QNameSet paramQNameSet) {
/*  890 */     byte b1 = (paramArrayOfString == null) ? 0 : paramArrayOfString.length;
/*      */     
/*  892 */     TypeStore typeStore = get_store();
/*      */     
/*  894 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  896 */     for (; i > b1; i--) {
/*  897 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  899 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  903 */       if (b2 >= i) {
/*  904 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  906 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  908 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfString[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(byte[][] paramArrayOfbyte, b paramb, QNameSet paramQNameSet) {
/*  914 */     byte b1 = (paramArrayOfbyte == null) ? 0 : paramArrayOfbyte.length;
/*      */     
/*  916 */     TypeStore typeStore = get_store();
/*      */     
/*  918 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  920 */     for (; i > b1; i--) {
/*  921 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  923 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  927 */       if (b2 >= i) {
/*  928 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  930 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  932 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfbyte[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(GDate[] paramArrayOfGDate, b paramb, QNameSet paramQNameSet) {
/*  938 */     byte b1 = (paramArrayOfGDate == null) ? 0 : paramArrayOfGDate.length;
/*      */     
/*  940 */     TypeStore typeStore = get_store();
/*      */     
/*  942 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  944 */     for (; i > b1; i--) {
/*  945 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  947 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  951 */       if (b2 >= i) {
/*  952 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  954 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  956 */       ((XmlObjectBase)typeStoreUser).set((GDateSpecification)paramArrayOfGDate[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(GDuration[] paramArrayOfGDuration, b paramb, QNameSet paramQNameSet) {
/*  962 */     byte b1 = (paramArrayOfGDuration == null) ? 0 : paramArrayOfGDuration.length;
/*      */     
/*  964 */     TypeStore typeStore = get_store();
/*      */     
/*  966 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  968 */     for (; i > b1; i--) {
/*  969 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  971 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  975 */       if (b2 >= i) {
/*  976 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/*  978 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/*  980 */       ((XmlObjectBase)typeStoreUser).set((GDurationSpecification)paramArrayOfGDuration[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(Calendar[] paramArrayOfCalendar, b paramb, QNameSet paramQNameSet) {
/*  986 */     byte b1 = (paramArrayOfCalendar == null) ? 0 : paramArrayOfCalendar.length;
/*      */     
/*  988 */     TypeStore typeStore = get_store();
/*      */     
/*  990 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/*  992 */     for (; i > b1; i--) {
/*  993 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*  995 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/*  999 */       if (b2 >= i) {
/* 1000 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1002 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/* 1004 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfCalendar[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(Date[] paramArrayOfDate, b paramb, QNameSet paramQNameSet) {
/* 1010 */     byte b1 = (paramArrayOfDate == null) ? 0 : paramArrayOfDate.length;
/*      */     
/* 1012 */     TypeStore typeStore = get_store();
/*      */     
/* 1014 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/* 1016 */     for (; i > b1; i--) {
/* 1017 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/* 1019 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1023 */       if (b2 >= i) {
/* 1024 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1026 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/* 1028 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfDate[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(b[] paramArrayOfb, b paramb, QNameSet paramQNameSet) {
/* 1034 */     byte b1 = (paramArrayOfb == null) ? 0 : paramArrayOfb.length;
/*      */     
/* 1036 */     TypeStore typeStore = get_store();
/*      */     
/* 1038 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/* 1040 */     for (; i > b1; i--) {
/* 1041 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/* 1043 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1047 */       if (b2 >= i) {
/* 1048 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1050 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/* 1052 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfb[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(StringEnumAbstractBase[] paramArrayOfStringEnumAbstractBase, b paramb, QNameSet paramQNameSet) {
/* 1058 */     byte b1 = (paramArrayOfStringEnumAbstractBase == null) ? 0 : paramArrayOfStringEnumAbstractBase.length;
/*      */     
/* 1060 */     TypeStore typeStore = get_store();
/*      */     
/* 1062 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/* 1064 */     for (; i > b1; i--) {
/* 1065 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/* 1067 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1071 */       if (b2 >= i) {
/* 1072 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1074 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/* 1076 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfStringEnumAbstractBase[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(List[] paramArrayOfList, b paramb, QNameSet paramQNameSet) {
/* 1082 */     byte b1 = (paramArrayOfList == null) ? 0 : paramArrayOfList.length;
/*      */     
/* 1084 */     TypeStore typeStore = get_store();
/*      */     
/* 1086 */     int i = typeStore.count_elements(paramQNameSet);
/*      */     
/* 1088 */     for (; i > b1; i--) {
/* 1089 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/* 1091 */     for (byte b2 = 0; b2 < b1; b2++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1095 */       if (b2 >= i) {
/* 1096 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1098 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b2);
/*      */       } 
/* 1100 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfList[b2]);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(XmlObject[] paramArrayOfXmlObject, b paramb) {
/* 1106 */     TypeStore typeStore = get_store();
/*      */     
/* 1108 */     if (paramArrayOfXmlObject == null || paramArrayOfXmlObject.length == 0) {
/*      */       
/* 1110 */       int j = typeStore.count_elements(paramb);
/* 1111 */       for (; j > 0; j--) {
/* 1112 */         typeStore.remove_element(paramb, 0);
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1118 */     int i = typeStore.count_elements(paramb);
/* 1119 */     byte b2 = 0, b3 = 0; byte b1;
/* 1120 */     for (b1 = 0; b1 < paramArrayOfXmlObject.length; b1++) {
/*      */       
/* 1122 */       if (!paramArrayOfXmlObject[b1].isImmutable()) {
/*      */         
/* 1124 */         XmlCursor xmlCursor = paramArrayOfXmlObject[b1].newCursor();
/* 1125 */         if (xmlCursor.toParent() && xmlCursor.getObject() == this) {
/*      */           
/* 1127 */           xmlCursor.dispose();
/*      */           break;
/*      */         } 
/* 1130 */         xmlCursor.dispose();
/*      */       } 
/* 1132 */     }  if (b1 < paramArrayOfXmlObject.length) {
/*      */       
/* 1134 */       TypeStoreUser typeStoreUser = typeStore.find_element_user(paramb, 0);
/* 1135 */       if (typeStoreUser == paramArrayOfXmlObject[b1]) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1143 */         byte b6 = 0;
/* 1144 */         for (b6 = 0; b6 < b1; b6++) {
/*      */           
/* 1146 */           TypeStoreUser typeStoreUser1 = typeStore.insert_element_user(paramb, b6);
/* 1147 */           ((XmlObjectBase)typeStoreUser1).set(paramArrayOfXmlObject[b6]);
/*      */         } 
/* 1149 */         b1++; b6++; for (; b1 < paramArrayOfXmlObject.length; b1++, b6++) {
/*      */           
/* 1151 */           XmlCursor xmlCursor = paramArrayOfXmlObject[b1].isImmutable() ? null : paramArrayOfXmlObject[b1].newCursor();
/* 1152 */           if (xmlCursor != null && xmlCursor.toParent() && xmlCursor.getObject() == this) {
/*      */             
/* 1154 */             xmlCursor.dispose();
/* 1155 */             typeStoreUser = typeStore.find_element_user(paramb, b6);
/* 1156 */             if (typeStoreUser == paramArrayOfXmlObject[b1]) {
/*      */               continue;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */ 
/*      */           
/* 1166 */           xmlCursor.dispose();
/*      */           
/* 1168 */           TypeStoreUser typeStoreUser1 = typeStore.insert_element_user(paramb, b6);
/* 1169 */           ((XmlObjectBase)typeStoreUser1).set(paramArrayOfXmlObject[b1]);
/*      */           continue;
/*      */         } 
/* 1172 */         b3 = b6;
/* 1173 */         b2 = b1;
/* 1174 */         i = typeStore.count_elements(paramb);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     byte b4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1190 */     for (b4 = b1; b4 < paramArrayOfXmlObject.length; b4++) {
/*      */       
/* 1192 */       TypeStoreUser typeStoreUser = typeStore.add_element_user(paramb);
/* 1193 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfXmlObject[b4]);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1199 */     b4 = b1;
/* 1200 */     for (; i > b4 - b2 + b3; i--) {
/* 1201 */       typeStore.remove_element(paramb, i - 1);
/*      */     }
/*      */     byte b5;
/* 1204 */     for (b1 = b2, b5 = b3; b1 < b4; b1++, b5++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1208 */       if (b5 >= i) {
/* 1209 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1211 */         typeStoreUser = typeStore.find_element_user(paramb, b5);
/*      */       } 
/* 1213 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfXmlObject[b1]);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void arraySetterHelper(XmlObject[] paramArrayOfXmlObject, b paramb, QNameSet paramQNameSet) {
/* 1224 */     TypeStore typeStore = get_store();
/*      */     
/* 1226 */     if (paramArrayOfXmlObject == null || paramArrayOfXmlObject.length == 0) {
/*      */       
/* 1228 */       int j = typeStore.count_elements(paramQNameSet);
/* 1229 */       for (; j > 0; j--) {
/* 1230 */         typeStore.remove_element(paramQNameSet, 0);
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/* 1236 */     int i = typeStore.count_elements(paramQNameSet);
/* 1237 */     byte b2 = 0, b3 = 0; byte b1;
/* 1238 */     for (b1 = 0; b1 < paramArrayOfXmlObject.length; b1++) {
/*      */       
/* 1240 */       if (!paramArrayOfXmlObject[b1].isImmutable()) {
/*      */         
/* 1242 */         XmlCursor xmlCursor = paramArrayOfXmlObject[b1].newCursor();
/* 1243 */         if (xmlCursor.toParent() && xmlCursor.getObject() == this) {
/*      */           
/* 1245 */           xmlCursor.dispose();
/*      */           break;
/*      */         } 
/* 1248 */         xmlCursor.dispose();
/*      */       } 
/* 1250 */     }  if (b1 < paramArrayOfXmlObject.length) {
/*      */       
/* 1252 */       TypeStoreUser typeStoreUser = typeStore.find_element_user(paramQNameSet, 0);
/* 1253 */       if (typeStoreUser == paramArrayOfXmlObject[b1]) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/* 1261 */         byte b6 = 0;
/* 1262 */         for (b6 = 0; b6 < b1; b6++) {
/*      */           
/* 1264 */           TypeStoreUser typeStoreUser1 = typeStore.insert_element_user(paramQNameSet, paramb, b6);
/* 1265 */           ((XmlObjectBase)typeStoreUser1).set(paramArrayOfXmlObject[b6]);
/*      */         } 
/* 1267 */         b1++; b6++; for (; b1 < paramArrayOfXmlObject.length; b1++, b6++) {
/*      */           
/* 1269 */           XmlCursor xmlCursor = paramArrayOfXmlObject[b1].isImmutable() ? null : paramArrayOfXmlObject[b1].newCursor();
/* 1270 */           if (xmlCursor != null && xmlCursor.toParent() && xmlCursor.getObject() == this) {
/*      */             
/* 1272 */             xmlCursor.dispose();
/* 1273 */             typeStoreUser = typeStore.find_element_user(paramQNameSet, b6);
/* 1274 */             if (typeStoreUser == paramArrayOfXmlObject[b1]) {
/*      */               continue;
/*      */             }
/*      */ 
/*      */ 
/*      */             
/*      */             break;
/*      */           } 
/*      */ 
/*      */           
/* 1284 */           xmlCursor.dispose();
/*      */           
/* 1286 */           TypeStoreUser typeStoreUser1 = typeStore.insert_element_user(paramQNameSet, paramb, b6);
/* 1287 */           ((XmlObjectBase)typeStoreUser1).set(paramArrayOfXmlObject[b1]);
/*      */           continue;
/*      */         } 
/* 1290 */         b3 = b6;
/* 1291 */         b2 = b1;
/* 1292 */         i = typeStore.count_elements(paramb);
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     byte b4;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1308 */     for (b4 = b1; b4 < paramArrayOfXmlObject.length; b4++) {
/*      */       
/* 1310 */       TypeStoreUser typeStoreUser = typeStore.add_element_user(paramb);
/* 1311 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfXmlObject[b4]);
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1317 */     b4 = b1;
/* 1318 */     for (; i > b4 - b2 + b3; i--) {
/* 1319 */       typeStore.remove_element(paramQNameSet, i - 1);
/*      */     }
/*      */     byte b5;
/* 1322 */     for (b1 = b2, b5 = b3; b1 < b4; b1++, b5++) {
/*      */       TypeStoreUser typeStoreUser;
/*      */ 
/*      */       
/* 1326 */       if (b5 >= i) {
/* 1327 */         typeStoreUser = typeStore.add_element_user(paramb);
/*      */       } else {
/* 1329 */         typeStoreUser = typeStore.find_element_user(paramQNameSet, b5);
/*      */       } 
/* 1331 */       ((XmlObjectBase)typeStoreUser).set(paramArrayOfXmlObject[b1]);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlComplexContentImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */