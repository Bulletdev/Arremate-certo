/*     */ package org.apache.xmlbeans.impl.inst2xsd;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlAnyURI;
/*     */ import org.apache.xmlbeans.XmlByte;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlDate;
/*     */ import org.apache.xmlbeans.XmlDateTime;
/*     */ import org.apache.xmlbeans.XmlDuration;
/*     */ import org.apache.xmlbeans.XmlFloat;
/*     */ import org.apache.xmlbeans.XmlInt;
/*     */ import org.apache.xmlbeans.XmlInteger;
/*     */ import org.apache.xmlbeans.XmlLong;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlQName;
/*     */ import org.apache.xmlbeans.XmlShort;
/*     */ import org.apache.xmlbeans.XmlString;
/*     */ import org.apache.xmlbeans.XmlTime;
/*     */ import org.apache.xmlbeans.impl.common.PrefixResolver;
/*     */ import org.apache.xmlbeans.impl.common.ValidationContext;
/*     */ import org.apache.xmlbeans.impl.common.XmlWhitespace;
/*     */ import org.apache.xmlbeans.impl.inst2xsd.util.Attribute;
/*     */ import org.apache.xmlbeans.impl.inst2xsd.util.Element;
/*     */ import org.apache.xmlbeans.impl.inst2xsd.util.Type;
/*     */ import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
/*     */ import org.apache.xmlbeans.impl.util.XsTypeConverter;
/*     */ import org.apache.xmlbeans.impl.values.XmlAnyUriImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlDateImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlDateTimeImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlDurationImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlQNameImpl;
/*     */ import org.apache.xmlbeans.impl.values.XmlTimeImpl;
/*     */ 
/*     */ public class RussianDollStrategy
/*     */   implements XsdGenStrategy {
/*     */   static final String _xsi = "http://www.w3.org/2001/XMLSchema-instance";
/*  40 */   static final b _xsiNil = new b("http://www.w3.org/2001/XMLSchema-instance", "nil", "xsi");
/*  41 */   static final b _xsiType = new b("http://www.w3.org/2001/XMLSchema-instance", "type", "xsi");
/*     */ 
/*     */   
/*     */   public void processDoc(XmlObject[] paramArrayOfXmlObject, Inst2XsdOptions paramInst2XsdOptions, TypeSystemHolder paramTypeSystemHolder) {
/*  45 */     for (byte b1 = 0; b1 < paramArrayOfXmlObject.length; b1++) {
/*     */       
/*  47 */       XmlObject xmlObject = paramArrayOfXmlObject[b1];
/*  48 */       XmlCursor xmlCursor = xmlObject.newCursor();
/*     */ 
/*     */       
/*  51 */       StringBuffer stringBuffer = new StringBuffer();
/*     */       
/*  53 */       while (!xmlCursor.isStart()) {
/*     */         
/*  55 */         xmlCursor.toNextToken();
/*  56 */         if (xmlCursor.isComment()) {
/*  57 */           stringBuffer.append(xmlCursor.getTextValue()); continue;
/*  58 */         }  if (xmlCursor.isEnddoc()) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/*  63 */       Element element = processElement(xmlCursor, stringBuffer.toString(), paramInst2XsdOptions, paramTypeSystemHolder);
/*  64 */       element.setGlobal(true);
/*     */       
/*  66 */       addGlobalElement(element, paramTypeSystemHolder, paramInst2XsdOptions);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected Element addGlobalElement(Element paramElement, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {
/*  72 */     assert paramElement.isGlobal();
/*  73 */     Element element = paramTypeSystemHolder.getGlobalElement(paramElement.getName());
/*     */     
/*  75 */     if (element == null) {
/*     */       
/*  77 */       paramTypeSystemHolder.addGlobalElement(paramElement);
/*  78 */       return paramElement;
/*     */     } 
/*     */ 
/*     */     
/*  82 */     combineTypes(element.getType(), paramElement.getType(), paramInst2XsdOptions);
/*  83 */     combineElementComments(element, paramElement);
/*  84 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Element processElement(XmlCursor paramXmlCursor, String paramString, Inst2XsdOptions paramInst2XsdOptions, TypeSystemHolder paramTypeSystemHolder) {
/*  91 */     assert paramXmlCursor.isStart();
/*  92 */     Element element = new Element();
/*  93 */     element.setName(paramXmlCursor.getName());
/*  94 */     element.setGlobal(false);
/*     */     
/*  96 */     Type type = Type.createUnnamedType(1);
/*  97 */     element.setType(type);
/*     */     
/*  99 */     StringBuffer stringBuffer1 = new StringBuffer();
/* 100 */     StringBuffer stringBuffer2 = new StringBuffer();
/* 101 */     ArrayList arrayList = new ArrayList();
/* 102 */     ArrayList arrayList1 = new ArrayList();
/*     */     
/*     */     while (true) {
/*     */       b b1;
/* 106 */       XmlCursor.TokenType tokenType = paramXmlCursor.toNextToken();
/* 107 */       switch (tokenType.intValue()) {
/*     */ 
/*     */ 
/*     */         
/*     */         case 6:
/* 112 */           b1 = paramXmlCursor.getName();
/* 113 */           if (!_xsiNil.getNamespaceURI().equals(b1.getNamespaceURI())) {
/* 114 */             arrayList1.add(processAttribute(paramXmlCursor, paramInst2XsdOptions, element.getName().getNamespaceURI(), paramTypeSystemHolder)); continue;
/* 115 */           }  if (_xsiNil.equals(b1)) {
/* 116 */             element.setNillable(true);
/*     */           }
/*     */           continue;
/*     */         
/*     */         case 3:
/* 121 */           arrayList.add(processElement(paramXmlCursor, stringBuffer2.toString(), paramInst2XsdOptions, paramTypeSystemHolder));
/* 122 */           stringBuffer2.delete(0, stringBuffer2.length());
/*     */           continue;
/*     */         
/*     */         case 5:
/* 126 */           stringBuffer1.append(paramXmlCursor.getChars());
/*     */           continue;
/*     */         
/*     */         case 8:
/* 130 */           stringBuffer2.append(paramXmlCursor.getTextValue());
/*     */           continue;
/*     */ 
/*     */         
/*     */         case 7:
/*     */           continue;
/*     */ 
/*     */         
/*     */         case 4:
/*     */           break;
/*     */ 
/*     */         
/*     */         case 9:
/*     */           continue;
/*     */ 
/*     */         
/*     */         case 2:
/*     */         case 0:
/*     */           break;
/*     */ 
/*     */         
/*     */         case 1:
/* 152 */           throw new IllegalStateException();
/*     */       } 
/*     */       
/* 155 */       throw new IllegalStateException("Unknown TokenType.");
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 160 */     String str1 = XmlWhitespace.collapse(stringBuffer1.toString(), 3);
/*     */     
/* 162 */     String str2 = (paramString == null) ? ((stringBuffer2.length() == 0) ? null : stringBuffer2.toString()) : ((stringBuffer2.length() == 0) ? paramString : stringBuffer2.insert(0, paramString).toString());
/*     */ 
/*     */     
/* 165 */     element.setComment(str2);
/*     */     
/* 167 */     if (arrayList.size() > 0) {
/*     */ 
/*     */       
/* 170 */       if (str1.length() > 0) {
/*     */         
/* 172 */         type.setContentType(4);
/*     */       }
/*     */       else {
/*     */         
/* 176 */         type.setContentType(3);
/*     */       } 
/* 178 */       processElementsInComplexType(type, arrayList, element.getName().getNamespaceURI(), paramTypeSystemHolder, paramInst2XsdOptions);
/* 179 */       processAttributesInComplexType(type, arrayList1);
/*     */     
/*     */     }
/*     */     else {
/*     */ 
/*     */       
/* 185 */       XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 186 */       xmlCursor.toParent();
/*     */       
/* 188 */       if (arrayList1.size() > 0) {
/*     */         
/* 190 */         type.setContentType(2);
/*     */         
/* 192 */         Type type1 = Type.createNamedType(processSimpleContentType(stringBuffer1.toString(), paramInst2XsdOptions, xmlCursor), 1);
/*     */         
/* 194 */         type.setExtensionType(type1);
/*     */         
/* 196 */         processAttributesInComplexType(type, arrayList1);
/*     */       }
/*     */       else {
/*     */         
/* 200 */         type.setContentType(1);
/* 201 */         type.setName(processSimpleContentType(stringBuffer1.toString(), paramInst2XsdOptions, xmlCursor));
/*     */ 
/*     */         
/* 204 */         String str = XmlString.type.getName().equals(type.getName()) ? stringBuffer1.toString() : str1;
/* 205 */         type.addEnumerationValue(str, xmlCursor);
/*     */       } 
/*     */       
/* 208 */       xmlCursor.dispose();
/*     */     } 
/*     */     
/* 211 */     checkIfReferenceToGlobalTypeIsNeeded(element, paramTypeSystemHolder, paramInst2XsdOptions);
/*     */     
/* 213 */     return element;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void processElementsInComplexType(Type paramType, List paramList, String paramString, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {
/* 219 */     HashMap hashMap = new HashMap();
/* 220 */     Element element = null;
/*     */     
/* 222 */     for (Element element1 : paramList) {
/*     */ 
/*     */ 
/*     */       
/* 226 */       if (element == null) {
/*     */         
/* 228 */         checkIfElementReferenceIsNeeded(element1, paramString, paramTypeSystemHolder, paramInst2XsdOptions);
/* 229 */         paramType.addElement(element1);
/* 230 */         hashMap.put(element1.getName(), element1);
/* 231 */         element = element1;
/*     */         
/*     */         continue;
/*     */       } 
/* 235 */       if (element.getName() == element1.getName()) {
/*     */         
/* 237 */         combineTypes(element.getType(), element1.getType(), paramInst2XsdOptions);
/* 238 */         combineElementComments(element, element1);
/*     */         
/* 240 */         element.setMinOccurs(0);
/* 241 */         element.setMaxOccurs(-1);
/*     */         
/*     */         continue;
/*     */       } 
/* 245 */       Element element2 = (Element)hashMap.get(element1.getName());
/* 246 */       if (element2 == null) {
/*     */         
/* 248 */         checkIfElementReferenceIsNeeded(element1, paramString, paramTypeSystemHolder, paramInst2XsdOptions);
/* 249 */         paramType.addElement(element1);
/* 250 */         hashMap.put(element1.getName(), element1);
/*     */       }
/*     */       else {
/*     */         
/* 254 */         combineTypes(element.getType(), element1.getType(), paramInst2XsdOptions);
/* 255 */         combineElementComments(element, element1);
/* 256 */         paramType.setTopParticleForComplexOrMixedContent(2);
/*     */       } 
/* 258 */       element = element1;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkIfElementReferenceIsNeeded(Element paramElement, String paramString, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {
/* 266 */     if (!paramElement.getName().getNamespaceURI().equals(paramString)) {
/*     */       
/* 268 */       Element element = new Element();
/* 269 */       element.setGlobal(true);
/* 270 */       element.setName(paramElement.getName());
/* 271 */       element.setType(paramElement.getType());
/*     */       
/* 273 */       if (paramElement.isNillable()) {
/*     */         
/* 275 */         element.setNillable(true);
/* 276 */         paramElement.setNillable(false);
/*     */       } 
/*     */       
/* 279 */       element = addGlobalElement(element, paramTypeSystemHolder, paramInst2XsdOptions);
/*     */       
/* 281 */       paramElement.setRef(element);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkIfReferenceToGlobalTypeIsNeeded(Element paramElement, TypeSystemHolder paramTypeSystemHolder, Inst2XsdOptions paramInst2XsdOptions) {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected void processAttributesInComplexType(Type paramType, List paramList) {
/* 293 */     assert paramType.isComplexType();
/* 294 */     for (Attribute attribute : paramList)
/*     */     {
/*     */       
/* 297 */       paramType.addAttribute(attribute);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected Attribute processAttribute(XmlCursor paramXmlCursor, Inst2XsdOptions paramInst2XsdOptions, String paramString, TypeSystemHolder paramTypeSystemHolder) {
/* 304 */     assert paramXmlCursor.isAttr() : "xc not on attribute";
/* 305 */     Attribute attribute = new Attribute();
/* 306 */     b b1 = paramXmlCursor.getName();
/*     */     
/* 308 */     attribute.setName(b1);
/*     */     
/* 310 */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/* 311 */     xmlCursor.toParent();
/*     */     
/* 313 */     Type type = Type.createNamedType(processSimpleContentType(paramXmlCursor.getTextValue(), paramInst2XsdOptions, xmlCursor), 1);
/*     */ 
/*     */     
/* 316 */     xmlCursor.dispose();
/*     */     
/* 318 */     attribute.setType(type);
/*     */     
/* 320 */     checkIfAttributeReferenceIsNeeded(attribute, paramString, paramTypeSystemHolder);
/*     */     
/* 322 */     return attribute;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void checkIfAttributeReferenceIsNeeded(Attribute paramAttribute, String paramString, TypeSystemHolder paramTypeSystemHolder) {
/* 327 */     if (!paramAttribute.getName().getNamespaceURI().equals("") && !paramAttribute.getName().getNamespaceURI().equals(paramString)) {
/*     */ 
/*     */ 
/*     */       
/* 331 */       Attribute attribute = new Attribute();
/* 332 */       attribute.setGlobal(true);
/* 333 */       attribute.setName(paramAttribute.getName());
/* 334 */       attribute.setType(paramAttribute.getType());
/*     */       
/* 336 */       paramTypeSystemHolder.addGlobalAttribute(attribute);
/*     */       
/* 338 */       paramAttribute.setRef(attribute);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected class SCTValidationContext
/*     */     implements ValidationContext
/*     */   {
/*     */     protected boolean valid = true;
/*     */     private final RussianDollStrategy this$0;
/*     */     
/*     */     public boolean isValid() {
/* 349 */       return this.valid;
/*     */     }
/*     */ 
/*     */     
/*     */     public void resetToValid() {
/* 354 */       this.valid = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void invalid(String param1String) {
/* 359 */       this.valid = false;
/*     */     }
/*     */ 
/*     */     
/*     */     public void invalid(String param1String, Object[] param1ArrayOfObject) {
/* 364 */       this.valid = false;
/*     */     }
/*     */   }
/*     */   
/* 368 */   private SCTValidationContext _validationContext = new SCTValidationContext();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static final boolean $assertionsDisabled;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected b processSimpleContentType(String paramString, Inst2XsdOptions paramInst2XsdOptions, final XmlCursor xc) {
/* 382 */     if (paramInst2XsdOptions.getSimpleContentTypes() == 2) {
/* 383 */       return XmlString.type.getName();
/*     */     }
/* 385 */     if (paramInst2XsdOptions.getSimpleContentTypes() != 1) {
/* 386 */       throw new IllegalArgumentException("Unknown value for Inst2XsdOptions.getSimpleContentTypes() :" + paramInst2XsdOptions.getSimpleContentTypes());
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 393 */       XsTypeConverter.lexByte(paramString);
/* 394 */       return XmlByte.type.getName();
/*     */     }
/* 396 */     catch (Exception exception) {
/*     */ 
/*     */       
/*     */       try {
/* 400 */         XsTypeConverter.lexShort(paramString);
/* 401 */         return XmlShort.type.getName();
/*     */       }
/* 403 */       catch (Exception exception1) {
/*     */ 
/*     */         
/*     */         try {
/* 407 */           XsTypeConverter.lexInt(paramString);
/* 408 */           return XmlInt.type.getName();
/*     */         }
/* 410 */         catch (Exception exception2) {
/*     */ 
/*     */           
/*     */           try {
/* 414 */             XsTypeConverter.lexLong(paramString);
/* 415 */             return XmlLong.type.getName();
/*     */           }
/* 417 */           catch (Exception exception3) {
/*     */ 
/*     */             
/*     */             try {
/* 421 */               XsTypeConverter.lexInteger(paramString);
/* 422 */               return XmlInteger.type.getName();
/*     */             }
/* 424 */             catch (Exception exception4) {
/*     */ 
/*     */               
/*     */               try {
/* 428 */                 XsTypeConverter.lexFloat(paramString);
/* 429 */                 return XmlFloat.type.getName();
/*     */               }
/* 431 */               catch (Exception exception5) {
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
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 448 */                 XmlDateImpl.validateLexical(paramString, XmlDate.type, this._validationContext);
/* 449 */                 if (this._validationContext.isValid())
/* 450 */                   return XmlDate.type.getName(); 
/* 451 */                 this._validationContext.resetToValid();
/*     */                 
/* 453 */                 XmlDateTimeImpl.validateLexical(paramString, XmlDateTime.type, this._validationContext);
/* 454 */                 if (this._validationContext.isValid())
/* 455 */                   return XmlDateTime.type.getName(); 
/* 456 */                 this._validationContext.resetToValid();
/*     */                 
/* 458 */                 XmlTimeImpl.validateLexical(paramString, XmlTime.type, this._validationContext);
/* 459 */                 if (this._validationContext.isValid())
/* 460 */                   return XmlTime.type.getName(); 
/* 461 */                 this._validationContext.resetToValid();
/*     */                 
/* 463 */                 XmlDurationImpl.validateLexical(paramString, XmlDuration.type, this._validationContext);
/* 464 */                 if (this._validationContext.isValid())
/* 465 */                   return XmlDuration.type.getName(); 
/* 466 */                 this._validationContext.resetToValid();
/*     */ 
/*     */                 
/* 469 */                 if (paramString.startsWith("http://") || paramString.startsWith("www.")) {
/*     */                   
/* 471 */                   XmlAnyUriImpl.validateLexical(paramString, this._validationContext);
/* 472 */                   if (this._validationContext.isValid())
/* 473 */                     return XmlAnyURI.type.getName(); 
/* 474 */                   this._validationContext.resetToValid();
/*     */                 } 
/*     */ 
/*     */                 
/* 478 */                 int i = paramString.indexOf(':');
/* 479 */                 if (i >= 0 && i == paramString.lastIndexOf(':') && i + 1 < paramString.length()) {
/*     */                   
/* 481 */                   PrefixResolver prefixResolver = new PrefixResolver() { private final XmlCursor val$xc; private final RussianDollStrategy this$0;
/*     */                       
/*     */                       public String getNamespaceForPrefix(String param1String) {
/* 484 */                         return xc.namespaceForPrefix(param1String);
/*     */                       } }
/*     */                     ;
/* 487 */                   b b1 = XmlQNameImpl.validateLexical(paramString, this._validationContext, prefixResolver);
/* 488 */                   if (this._validationContext.isValid())
/* 489 */                     return XmlQName.type.getName(); 
/* 490 */                   this._validationContext.resetToValid();
/*     */                 } 
/*     */ 
/*     */ 
/*     */                 
/* 495 */                 return XmlString.type.getName();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 501 */     }  } protected void combineTypes(Type paramType1, Type paramType2, Inst2XsdOptions paramInst2XsdOptions) { if (paramType1 == paramType2) {
/*     */       return;
/*     */     }
/* 504 */     if (paramType1.isGlobal() && paramType2.isGlobal() && paramType1.getName().equals(paramType2.getName())) {
/*     */       return;
/*     */     }
/*     */     
/* 508 */     if (paramType1.getContentType() == 1 && paramType2.getContentType() == 1) {
/*     */ 
/*     */       
/* 511 */       combineSimpleTypes(paramType1, paramType2, paramInst2XsdOptions);
/*     */       
/*     */       return;
/*     */     } 
/* 515 */     if ((paramType1.getContentType() == 1 || paramType1.getContentType() == 2) && (paramType2.getContentType() == 1 || paramType2.getContentType() == 2)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 521 */       b b1 = paramType1.isComplexType() ? paramType1.getExtensionType().getName() : paramType1.getName();
/* 522 */       b b2 = paramType2.isComplexType() ? paramType2.getExtensionType().getName() : paramType2.getName();
/*     */ 
/*     */       
/* 525 */       paramType1.setContentType(2);
/*     */       
/* 527 */       b b3 = combineToMoreGeneralSimpleType(b1, b2);
/* 528 */       if (paramType1.isComplexType()) {
/*     */         
/* 530 */         Type type = Type.createNamedType(b3, 1);
/* 531 */         paramType1.setExtensionType(type);
/*     */       } else {
/*     */         
/* 534 */         paramType1.setName(b3);
/*     */       } 
/* 536 */       combineAttributesOfTypes(paramType1, paramType2);
/*     */       
/*     */       return;
/*     */     } 
/* 540 */     if (paramType1.getContentType() == 3 && paramType2.getContentType() == 3) {
/*     */ 
/*     */       
/* 543 */       combineAttributesOfTypes(paramType1, paramType2);
/* 544 */       combineElementsOfTypes(paramType1, paramType2, false, paramInst2XsdOptions);
/*     */       
/*     */       return;
/*     */     } 
/* 548 */     if (paramType1.getContentType() == 1 || paramType1.getContentType() == 2 || paramType2.getContentType() == 1 || paramType2.getContentType() == 2) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 553 */       paramType1.setContentType(4);
/* 554 */       combineAttributesOfTypes(paramType1, paramType2);
/* 555 */       combineElementsOfTypes(paramType1, paramType2, true, paramInst2XsdOptions);
/*     */       
/*     */       return;
/*     */     } 
/* 559 */     if ((paramType1.getContentType() == 1 || paramType1.getContentType() == 2 || paramType1.getContentType() == 3 || paramType1.getContentType() == 4) && (paramType2.getContentType() == 1 || paramType2.getContentType() == 2 || paramType2.getContentType() == 3 || paramType2.getContentType() == 4)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 568 */       paramType1.setContentType(4);
/* 569 */       combineAttributesOfTypes(paramType1, paramType2);
/* 570 */       combineElementsOfTypes(paramType1, paramType2, false, paramInst2XsdOptions);
/*     */       
/*     */       return;
/*     */     } 
/* 574 */     throw new IllegalArgumentException("Unknown content type."); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void combineSimpleTypes(Type paramType1, Type paramType2, Inst2XsdOptions paramInst2XsdOptions) {
/* 580 */     assert paramType1.getContentType() == 1 && paramType2.getContentType() == 1 : "Invalid arguments";
/*     */ 
/*     */     
/* 583 */     paramType1.setName(combineToMoreGeneralSimpleType(paramType1.getName(), paramType2.getName()));
/*     */ 
/*     */     
/* 586 */     if (paramInst2XsdOptions.isUseEnumerations()) {
/*     */       
/* 588 */       paramType1.addAllEnumerationsFrom(paramType2);
/*     */       
/* 590 */       if (paramType1.getEnumerationValues().size() > paramInst2XsdOptions.getUseEnumerations())
/*     */       {
/* 592 */         paramType1.closeEnumeration();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected b combineToMoreGeneralSimpleType(b paramb1, b paramb2) {
/* 599 */     if (paramb1.equals(paramb2)) {
/* 600 */       return paramb1;
/*     */     }
/* 602 */     if (paramb2.equals(XmlShort.type.getName()) && paramb1.equals(XmlByte.type.getName()))
/* 603 */       return paramb2; 
/* 604 */     if (paramb1.equals(XmlShort.type.getName()) && paramb2.equals(XmlByte.type.getName())) {
/* 605 */       return paramb1;
/*     */     }
/* 607 */     if (paramb2.equals(XmlInt.type.getName()) && (paramb1.equals(XmlShort.type.getName()) || paramb1.equals(XmlByte.type.getName())))
/*     */     {
/* 609 */       return paramb2; } 
/* 610 */     if (paramb1.equals(XmlInt.type.getName()) && (paramb2.equals(XmlShort.type.getName()) || paramb2.equals(XmlByte.type.getName())))
/*     */     {
/* 612 */       return paramb1;
/*     */     }
/* 614 */     if (paramb2.equals(XmlLong.type.getName()) && (paramb1.equals(XmlInt.type.getName()) || paramb1.equals(XmlShort.type.getName()) || paramb1.equals(XmlByte.type.getName())))
/*     */     {
/* 616 */       return paramb2; } 
/* 617 */     if (paramb1.equals(XmlLong.type.getName()) && (paramb2.equals(XmlInt.type.getName()) || paramb2.equals(XmlShort.type.getName()) || paramb2.equals(XmlByte.type.getName())))
/*     */     {
/* 619 */       return paramb1;
/*     */     }
/* 621 */     if (paramb2.equals(XmlInteger.type.getName()) && (paramb1.equals(XmlLong.type.getName()) || paramb1.equals(XmlInt.type.getName()) || paramb1.equals(XmlShort.type.getName()) || paramb1.equals(XmlByte.type.getName())))
/*     */     {
/*     */       
/* 624 */       return paramb2; } 
/* 625 */     if (paramb1.equals(XmlInteger.type.getName()) && (paramb2.equals(XmlLong.type.getName()) || paramb2.equals(XmlInt.type.getName()) || paramb2.equals(XmlShort.type.getName()) || paramb2.equals(XmlByte.type.getName())))
/*     */     {
/*     */       
/* 628 */       return paramb1;
/*     */     }
/* 630 */     if (paramb2.equals(XmlFloat.type.getName()) && (paramb1.equals(XmlInteger.type.getName()) || paramb1.equals(XmlLong.type.getName()) || paramb1.equals(XmlInt.type.getName()) || paramb1.equals(XmlShort.type.getName()) || paramb1.equals(XmlByte.type.getName())))
/*     */     {
/*     */ 
/*     */       
/* 634 */       return paramb2; } 
/* 635 */     if (paramb1.equals(XmlFloat.type.getName()) && (paramb2.equals(XmlInteger.type.getName()) || paramb2.equals(XmlLong.type.getName()) || paramb2.equals(XmlInt.type.getName()) || paramb2.equals(XmlShort.type.getName()) || paramb2.equals(XmlByte.type.getName())))
/*     */     {
/*     */ 
/*     */       
/* 639 */       return paramb1;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 644 */     return XmlString.type.getName();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void combineAttributesOfTypes(Type paramType1, Type paramType2) {
/*     */     byte b1;
/* 651 */     for (b1 = 0; b1 < paramType2.getAttributes().size(); b1++) {
/*     */       
/* 653 */       Attribute attribute = paramType2.getAttributes().get(b1);
/* 654 */       byte b2 = 0; while (true) { if (b2 < paramType1.getAttributes().size()) {
/*     */           
/* 656 */           Attribute attribute1 = paramType1.getAttributes().get(b2);
/* 657 */           if (attribute1.getName().equals(attribute.getName())) {
/*     */             
/* 659 */             attribute1.getType().setName(combineToMoreGeneralSimpleType(attribute1.getType().getName(), attribute.getType().getName()));
/*     */             break;
/*     */           } 
/*     */           b2++;
/*     */           continue;
/*     */         } 
/* 665 */         paramType1.addAttribute(attribute);
/*     */         
/*     */         break; }
/*     */     
/*     */     } 
/* 670 */     for (b1 = 0; b1 < paramType1.getAttributes().size(); b1++) {
/*     */       
/* 672 */       Attribute attribute = paramType1.getAttributes().get(b1);
/* 673 */       for (byte b2 = 0; b2 < paramType2.getAttributes().size(); b2++) {
/*     */         
/* 675 */         Attribute attribute1 = paramType2.getAttributes().get(b2);
/* 676 */         if (attribute1.getName().equals(attribute.getName()));
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 682 */       attribute.setOptional(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void combineElementsOfTypes(Type paramType1, Type paramType2, boolean paramBoolean, Inst2XsdOptions paramInst2XsdOptions) {
/* 688 */     boolean bool = false;
/*     */     
/* 690 */     if (paramType1.getTopParticleForComplexOrMixedContent() != 1 || paramType2.getTopParticleForComplexOrMixedContent() != 1)
/*     */     {
/* 692 */       bool = true;
/*     */     }
/* 694 */     ArrayList arrayList = new ArrayList();
/*     */     
/* 696 */     int i = 0;
/* 697 */     int j = -1;
/* 698 */     int k = -1;
/*     */     
/*     */     int m;
/* 701 */     for (m = 0; !bool && m < paramType1.getElements().size(); m++) {
/*     */ 
/*     */       
/* 704 */       Element element = paramType1.getElements().get(m); int n;
/* 705 */       for (n = i; n < paramType2.getElements().size(); n++) {
/*     */         
/* 707 */         Element element1 = paramType2.getElements().get(n);
/* 708 */         if (element.getName().equals(element1.getName())) {
/*     */           
/* 710 */           j = n;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 716 */       if (j < i) {
/*     */         
/* 718 */         arrayList.add(element);
/* 719 */         element.setMinOccurs(0);
/*     */ 
/*     */       
/*     */       }
/*     */       else {
/*     */ 
/*     */         
/* 726 */         label77: for (n = i; n < j; n++) {
/*     */           
/* 728 */           Element element1 = paramType2.getElements().get(n);
/*     */           
/* 730 */           for (int i1 = m + 1; i1 < paramType1.getElements().size(); i1++) {
/*     */             
/* 732 */             Element element2 = paramType1.getElements().get(i1);
/* 733 */             if (element1.getName().equals(element2.getName())) {
/*     */               
/* 735 */               k = i1;
/*     */               
/*     */               break label77;
/*     */             } 
/*     */           } 
/*     */         } 
/* 741 */         if (k < m) {
/*     */ 
/*     */           
/* 744 */           for (n = i; n < j; n++) {
/*     */             
/* 746 */             Element element2 = paramType2.getElements().get(n);
/* 747 */             arrayList.add(element2);
/* 748 */             element2.setMinOccurs(0);
/*     */           } 
/*     */           
/* 751 */           arrayList.add(element);
/* 752 */           Element element1 = paramType2.getElements().get(j);
/*     */           
/* 754 */           if (element1.getMinOccurs() <= 0)
/* 755 */             element.setMinOccurs(0); 
/* 756 */           if (element1.getMaxOccurs() == -1) {
/* 757 */             element.setMaxOccurs(-1);
/*     */           }
/* 759 */           combineTypes(element.getType(), element1.getType(), paramInst2XsdOptions);
/* 760 */           combineElementComments(element, element1);
/*     */           
/* 762 */           i = j + 1;
/*     */         
/*     */         }
/*     */         else {
/*     */ 
/*     */           
/* 768 */           bool = true;
/*     */         } 
/*     */       } 
/*     */     } 
/* 772 */     for (m = i; m < paramType2.getElements().size(); m++) {
/*     */       
/* 774 */       Element element = paramType2.getElements().get(m);
/* 775 */       arrayList.add(element);
/* 776 */       element.setMinOccurs(0);
/*     */     } 
/*     */ 
/*     */     
/* 780 */     if (bool) {
/*     */       
/* 782 */       paramType1.setTopParticleForComplexOrMixedContent(2);
/*     */ 
/*     */       
/* 785 */       for (m = 0; m < paramType2.getElements().size(); m++) {
/*     */         
/* 787 */         Element element = paramType2.getElements().get(m);
/* 788 */         byte b1 = 0; while (true) { if (b1 < paramType1.getElements().size()) {
/*     */             
/* 790 */             Element element1 = paramType1.getElements().get(b1);
/* 791 */             element1.setMinOccurs(1);
/* 792 */             element1.setMaxOccurs(1);
/*     */             
/* 794 */             if (element1 == element) {
/*     */               break;
/*     */             }
/* 797 */             if (element1.getName().equals(element.getName())) {
/*     */               
/* 799 */               combineTypes(element1.getType(), element.getType(), paramInst2XsdOptions);
/* 800 */               combineElementComments(element1, element);
/*     */               
/*     */               break;
/*     */             } 
/*     */             b1++;
/*     */             continue;
/*     */           } 
/* 807 */           paramType1.addElement(element);
/* 808 */           element.setMinOccurs(1);
/* 809 */           element.setMaxOccurs(1);
/*     */           
/*     */           break; }
/*     */       
/*     */       } 
/*     */       return;
/*     */     } 
/* 816 */     paramType1.setElements(arrayList);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void combineElementComments(Element paramElement1, Element paramElement2) {
/* 823 */     if (paramElement2.getComment() != null && paramElement2.getComment().length() > 0)
/*     */     {
/* 825 */       if (paramElement1.getComment() == null) {
/* 826 */         paramElement1.setComment(paramElement2.getComment());
/*     */       } else {
/* 828 */         paramElement1.setComment(paramElement1.getComment() + paramElement2.getComment());
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xsd\RussianDollStrategy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */