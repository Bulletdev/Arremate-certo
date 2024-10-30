/*     */ package org.apache.xmlbeans.impl.values;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SimpleValue;
/*     */ import org.apache.xmlbeans.XmlAnySimpleType;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlSimpleList;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.common.XMLChar;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlListImpl
/*     */   extends XmlObjectBase
/*     */   implements XmlAnySimpleType
/*     */ {
/*     */   private SchemaType _schemaType;
/*     */   private XmlSimpleList _value;
/*     */   private XmlSimpleList _jvalue;
/*     */   
/*     */   public XmlListImpl(SchemaType paramSchemaType, boolean paramBoolean) {
/*  36 */     this._schemaType = paramSchemaType; initComplexType(paramBoolean, false);
/*     */   }
/*     */   public SchemaType schemaType() {
/*  39 */     return this._schemaType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String nullAsEmpty(String paramString) {
/*  52 */     if (paramString == null)
/*  53 */       return ""; 
/*  54 */     return paramString;
/*     */   }
/*     */ 
/*     */   
/*     */   private static String compute_list_text(List paramList) {
/*  59 */     if (paramList.size() == 0) {
/*  60 */       return "";
/*     */     }
/*  62 */     StringBuffer stringBuffer = new StringBuffer();
/*  63 */     stringBuffer.append(nullAsEmpty(((SimpleValue)paramList.get(0)).getStringValue()));
/*     */     
/*  65 */     for (byte b = 1; b < paramList.size(); b++) {
/*     */       
/*  67 */       stringBuffer.append(' ');
/*  68 */       stringBuffer.append(nullAsEmpty(((SimpleValue)paramList.get(b)).getStringValue()));
/*     */     } 
/*     */     
/*  71 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   protected String compute_text(NamespaceManager paramNamespaceManager) {
/*  76 */     return compute_list_text((List)this._value);
/*     */   }
/*     */   
/*     */   protected boolean is_defaultable_ws(String paramString) {
/*     */     try {
/*  81 */       XmlSimpleList xmlSimpleList = this._value;
/*  82 */       set_text(paramString);
/*     */ 
/*     */       
/*  85 */       this._value = xmlSimpleList;
/*     */       
/*  87 */       return false;
/*     */     }
/*  89 */     catch (XmlValueOutOfRangeException xmlValueOutOfRangeException) {
/*  90 */       return true;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void set_text(String paramString) {
/*  97 */     if (_validateOnSet() && !this._schemaType.matchPatternFacet(paramString)) {
/*  98 */       throw new XmlValueOutOfRangeException("cvc-datatype-valid.1.1", new Object[] { "list", paramString, QNameHelper.readable(this._schemaType) });
/*     */     }
/*     */     
/* 101 */     SchemaType schemaType = this._schemaType.getListItemType();
/*     */     
/* 103 */     XmlSimpleList xmlSimpleList = lex(paramString, schemaType, _voorVc, has_store() ? get_store() : null);
/*     */ 
/*     */     
/* 106 */     if (_validateOnSet()) {
/* 107 */       validateValue(xmlSimpleList, this._schemaType, _voorVc);
/*     */     }
/*     */     
/* 110 */     this._value = xmlSimpleList;
/* 111 */     this._jvalue = null;
/*     */   }
/*     */   
/* 114 */   private static final String[] EMPTY_STRINGARRAY = new String[0];
/*     */ 
/*     */   
/*     */   public static String[] split_list(String paramString) {
/* 118 */     if (paramString.length() == 0) {
/* 119 */       return EMPTY_STRINGARRAY;
/*     */     }
/* 121 */     ArrayList arrayList = new ArrayList();
/* 122 */     byte b1 = 0;
/* 123 */     byte b2 = 0;
/*     */     
/*     */     while (true) {
/* 126 */       if (b1 < paramString.length() && XMLChar.isSpace(paramString.charAt(b1))) {
/* 127 */         b1++; continue;
/* 128 */       }  if (b1 >= paramString.length())
/* 129 */         return (String[])arrayList.toArray((Object[])EMPTY_STRINGARRAY); 
/* 130 */       b2 = b1;
/* 131 */       while (b1 < paramString.length() && !XMLChar.isSpace(paramString.charAt(b1)))
/* 132 */         b1++; 
/* 133 */       arrayList.add(paramString.substring(b2, b1));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static XmlSimpleList lex(String paramString, SchemaType paramSchemaType, ValidationContext paramValidationContext, PrefixResolver paramPrefixResolver) {
/* 139 */     String[] arrayOfString = split_list(paramString);
/*     */     
/* 141 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = new XmlAnySimpleType[arrayOfString.length];
/* 142 */     boolean bool = false;
/* 143 */     if (paramPrefixResolver != null) {
/*     */       
/* 145 */       NamespaceContext.push(new NamespaceContext(paramPrefixResolver));
/* 146 */       bool = true;
/*     */     } 
/* 148 */     byte b = 0;
/*     */     
/*     */     try {
/* 151 */       for (b = 0; b < arrayOfString.length; b++) {
/*     */         
/*     */         try
/*     */         {
/* 155 */           arrayOfXmlAnySimpleType[b] = paramSchemaType.newValue(arrayOfString[b]);
/*     */         }
/* 157 */         catch (XmlValueOutOfRangeException xmlValueOutOfRangeException)
/*     */         {
/* 159 */           paramValidationContext.invalid("list", new Object[] { "item '" + arrayOfString[b] + "' is not a valid value of " + QNameHelper.readable(paramSchemaType) });
/*     */         }
/*     */       
/*     */       } 
/*     */     } finally {
/*     */       
/* 165 */       if (bool)
/* 166 */         NamespaceContext.pop(); 
/*     */     } 
/* 168 */     return new XmlSimpleList(Arrays.asList(arrayOfXmlAnySimpleType));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void set_nil() {
/* 173 */     this._value = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public List xgetListValue() {
/* 178 */     check_dated();
/* 179 */     return (List)this._value;
/*     */   }
/*     */ 
/*     */   
/*     */   public List getListValue() {
/* 184 */     check_dated();
/* 185 */     if (this._value == null)
/* 186 */       return null; 
/* 187 */     if (this._jvalue != null)
/* 188 */       return (List)this._jvalue; 
/* 189 */     ArrayList arrayList = new ArrayList();
/* 190 */     for (byte b = 0; b < this._value.size(); b++)
/* 191 */       arrayList.add(java_value((XmlObject)this._value.get(b))); 
/* 192 */     this._jvalue = new XmlSimpleList(arrayList);
/* 193 */     return (List)this._jvalue;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean permits_inner_space(XmlObject paramXmlObject) {
/* 198 */     switch (((SimpleValue)paramXmlObject).instanceType().getPrimitiveType().getBuiltinTypeCode()) {
/*     */       
/*     */       case 1:
/*     */       case 2:
/*     */       case 6:
/*     */       case 12:
/* 204 */         return true;
/*     */     } 
/* 206 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean contains_white_space(String paramString) {
/* 212 */     return (paramString.indexOf(' ') >= 0 || paramString.indexOf('\t') >= 0 || paramString.indexOf('\n') >= 0 || paramString.indexOf('\r') >= 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void set_list(List paramList) {
/*     */     XmlSimpleList xmlSimpleList;
/* 220 */     SchemaType schemaType = this._schemaType.getListItemType();
/*     */ 
/*     */     
/* 223 */     boolean bool = false;
/* 224 */     if (has_store()) {
/*     */       
/* 226 */       NamespaceContext.push(new NamespaceContext(get_store()));
/* 227 */       bool = true;
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 232 */       XmlAnySimpleType[] arrayOfXmlAnySimpleType = new XmlAnySimpleType[paramList.size()];
/* 233 */       for (byte b = 0; b < paramList.size(); b++) {
/*     */         
/* 235 */         Object object = paramList.get(b);
/* 236 */         if (object instanceof XmlObject && permits_inner_space((XmlObject)paramList.get(b))) {
/*     */           
/* 238 */           String str = paramList.get(b).toString();
/* 239 */           if (contains_white_space(str))
/* 240 */             throw new XmlValueOutOfRangeException(); 
/*     */         } 
/* 242 */         arrayOfXmlAnySimpleType[b] = schemaType.newValue(object);
/*     */       } 
/* 244 */       xmlSimpleList = new XmlSimpleList(Arrays.asList(arrayOfXmlAnySimpleType));
/*     */     }
/*     */     finally {
/*     */       
/* 248 */       if (bool) {
/* 249 */         NamespaceContext.pop();
/*     */       }
/*     */     } 
/* 252 */     if (_validateOnSet())
/*     */     {
/*     */       
/* 255 */       validateValue(xmlSimpleList, this._schemaType, _voorVc);
/*     */     }
/*     */     
/* 258 */     this._value = xmlSimpleList;
/* 259 */     this._jvalue = null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void validateValue(XmlSimpleList paramXmlSimpleList, SchemaType paramSchemaType, ValidationContext paramValidationContext) {
/* 264 */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/* 265 */     if (arrayOfXmlAnySimpleType != null) {
/*     */       
/* 267 */       byte b = 0; while (true) { if (b < arrayOfXmlAnySimpleType.length) {
/*     */           
/* 269 */           if (equal_xmlLists((List)paramXmlSimpleList, ((XmlObjectBase)arrayOfXmlAnySimpleType[b]).xlistValue()))
/*     */             break;  b++; continue;
/*     */         } 
/* 272 */         paramValidationContext.invalid("cvc-enumeration-valid", new Object[] { "list", paramXmlSimpleList, QNameHelper.readable(paramSchemaType) });
/*     */         
/*     */         break; }
/*     */     
/*     */     } 
/*     */     
/*     */     XmlAnySimpleType xmlAnySimpleType;
/* 279 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(0)) != null) {
/*     */       int i;
/* 281 */       if ((i = ((SimpleValue)xmlAnySimpleType).getIntValue()) != paramXmlSimpleList.size())
/*     */       {
/* 283 */         paramValidationContext.invalid("cvc-length-valid.2", new Object[] { paramXmlSimpleList, new Integer(paramXmlSimpleList.size()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 288 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(1)) != null) {
/*     */       int i;
/* 290 */       if ((i = ((SimpleValue)xmlAnySimpleType).getIntValue()) > paramXmlSimpleList.size())
/*     */       {
/* 292 */         paramValidationContext.invalid("cvc-minLength-valid.2", new Object[] { paramXmlSimpleList, new Integer(paramXmlSimpleList.size()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 297 */     if ((xmlAnySimpleType = paramSchemaType.getFacet(2)) != null) {
/*     */       int i;
/* 299 */       if ((i = ((SimpleValue)xmlAnySimpleType).getIntValue()) < paramXmlSimpleList.size())
/*     */       {
/* 301 */         paramValidationContext.invalid("cvc-maxLength-valid.2", new Object[] { paramXmlSimpleList, new Integer(paramXmlSimpleList.size()), new Integer(i), QNameHelper.readable(paramSchemaType) });
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean equal_to(XmlObject paramXmlObject) {
/* 312 */     return equal_xmlLists((List)this._value, ((XmlObjectBase)paramXmlObject).xlistValue());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean equal_xmlLists(List paramList1, List paramList2) {
/* 318 */     if (paramList1.size() != paramList2.size())
/* 319 */       return false; 
/* 320 */     for (byte b = 0; b < paramList1.size(); b++) {
/*     */       
/* 322 */       if (!paramList1.get(b).equals(paramList2.get(b)))
/* 323 */         return false; 
/*     */     } 
/* 325 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected int value_hash_code() {
/* 330 */     if (this._value == null) {
/* 331 */       return 0;
/*     */     }
/*     */     
/* 334 */     int i = this._value.size();
/* 335 */     int j = this._value.size() / 9;
/* 336 */     if (j < 1) {
/* 337 */       j = 1;
/*     */     }
/*     */     int k;
/* 340 */     for (k = 0; k < this._value.size(); k += j) {
/*     */       
/* 342 */       i *= 19;
/* 343 */       i += this._value.get(k).hashCode();
/*     */     } 
/*     */     
/* 346 */     if (k < this._value.size()) {
/*     */       
/* 348 */       i *= 19;
/* 349 */       i += this._value.get(k).hashCode();
/*     */     } 
/*     */     
/* 352 */     return i;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void validate_simpleval(String paramString, ValidationContext paramValidationContext) {
/* 357 */     validateValue((XmlSimpleList)xlistValue(), schemaType(), paramValidationContext);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\values\XmlListImpl.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */