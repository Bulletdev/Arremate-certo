/*      */ package org.apache.xmlbeans.impl.xsd2inst;
/*      */ 
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import javax.xml.namespace.b;
/*      */ import org.apache.xmlbeans.GDate;
/*      */ import org.apache.xmlbeans.GDateBuilder;
/*      */ import org.apache.xmlbeans.GDateSpecification;
/*      */ import org.apache.xmlbeans.GDuration;
/*      */ import org.apache.xmlbeans.GDurationBuilder;
/*      */ import org.apache.xmlbeans.SchemaLocalElement;
/*      */ import org.apache.xmlbeans.SchemaParticle;
/*      */ import org.apache.xmlbeans.SchemaProperty;
/*      */ import org.apache.xmlbeans.SchemaType;
/*      */ import org.apache.xmlbeans.SimpleValue;
/*      */ import org.apache.xmlbeans.XmlAnySimpleType;
/*      */ import org.apache.xmlbeans.XmlCalendar;
/*      */ import org.apache.xmlbeans.XmlCursor;
/*      */ import org.apache.xmlbeans.XmlDate;
/*      */ import org.apache.xmlbeans.XmlDateTime;
/*      */ import org.apache.xmlbeans.XmlDecimal;
/*      */ import org.apache.xmlbeans.XmlDuration;
/*      */ import org.apache.xmlbeans.XmlGDay;
/*      */ import org.apache.xmlbeans.XmlGMonth;
/*      */ import org.apache.xmlbeans.XmlGMonthDay;
/*      */ import org.apache.xmlbeans.XmlGYear;
/*      */ import org.apache.xmlbeans.XmlGYearMonth;
/*      */ import org.apache.xmlbeans.XmlInteger;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.XmlTime;
/*      */ import org.apache.xmlbeans.impl.util.Base64;
/*      */ import org.apache.xmlbeans.impl.util.HexBin;
/*      */ import org.apache.xmlbeans.soap.SOAPArrayType;
/*      */ import org.apache.xmlbeans.soap.SchemaWSDLArrayType;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class SampleXmlUtil
/*      */ {
/*      */   private boolean _soapEnc;
/*      */   private static final int MAX_ELEMENTS = 1000;
/*      */   private int _nElements;
/*      */   Random _picker;
/*      */   
/*      */   private SampleXmlUtil(boolean paramBoolean) {
/*  100 */     this._picker = new Random(1L);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1188 */     this._typeStack = new ArrayList();
/*      */     this._soapEnc = paramBoolean;
/*      */   }
/*      */   
/*      */   public static String createSampleForType(SchemaType paramSchemaType) {
/*      */     XmlObject xmlObject = XmlObject.Factory.newInstance();
/*      */     XmlCursor xmlCursor = xmlObject.newCursor();
/*      */     xmlCursor.toNextToken();
/*      */     (new SampleXmlUtil(false)).createSampleForType(paramSchemaType, xmlCursor);
/*      */     XmlOptions xmlOptions = new XmlOptions();
/*      */     xmlOptions.put("SAVE_PRETTY_PRINT");
/*      */     xmlOptions.put("SAVE_PRETTY_PRINT_INDENT", 2);
/*      */     xmlOptions.put("SAVE_AGGRESSIVE_NAMESPACES");
/*      */     return xmlObject.xmlText(xmlOptions);
/*      */   }
/*      */   
/*      */   private void createSampleForType(SchemaType paramSchemaType, XmlCursor paramXmlCursor) {
/*      */     if (this._typeStack.contains(paramSchemaType))
/*      */       return; 
/*      */     this._typeStack.add(paramSchemaType);
/*      */     try {
/*      */       if (paramSchemaType.isSimpleType() || paramSchemaType.isURType()) {
/*      */         processSimpleType(paramSchemaType, paramXmlCursor);
/*      */         return;
/*      */       } 
/*      */       processAttributes(paramSchemaType, paramXmlCursor);
/*      */       switch (paramSchemaType.getContentType()) {
/*      */         case 2:
/*      */           processSimpleType(paramSchemaType, paramXmlCursor);
/*      */           break;
/*      */         case 4:
/*      */           paramXmlCursor.insertChars(pick(WORDS) + " ");
/*      */           if (paramSchemaType.getContentModel() != null)
/*      */             processParticle(paramSchemaType.getContentModel(), paramXmlCursor, true); 
/*      */           paramXmlCursor.insertChars(pick(WORDS));
/*      */           break;
/*      */         case 3:
/*      */           if (paramSchemaType.getContentModel() != null)
/*      */             processParticle(paramSchemaType.getContentModel(), paramXmlCursor, false); 
/*      */           break;
/*      */       } 
/*      */     } finally {
/*      */       this._typeStack.remove(this._typeStack.size() - 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processSimpleType(SchemaType paramSchemaType, XmlCursor paramXmlCursor) {
/*      */     String str = sampleDataForSimpleType(paramSchemaType);
/*      */     paramXmlCursor.insertChars(str);
/*      */   }
/*      */   
/*      */   private String sampleDataForSimpleType(SchemaType paramSchemaType) {
/*      */     String str;
/*      */     if (XmlObject.type.equals(paramSchemaType))
/*      */       return "anyType"; 
/*      */     if (XmlAnySimpleType.type.equals(paramSchemaType))
/*      */       return "anySimpleType"; 
/*      */     if (paramSchemaType.getSimpleVariety() == 3) {
/*      */       SchemaType schemaType = paramSchemaType.getListItemType();
/*      */       StringBuffer stringBuffer = new StringBuffer();
/*      */       int i = pickLength(paramSchemaType);
/*      */       if (i > 0)
/*      */         stringBuffer.append(sampleDataForSimpleType(schemaType)); 
/*      */       for (byte b1 = 1; b1 < i; b1++) {
/*      */         stringBuffer.append(' ');
/*      */         stringBuffer.append(sampleDataForSimpleType(schemaType));
/*      */       } 
/*      */       return stringBuffer.toString();
/*      */     } 
/*      */     if (paramSchemaType.getSimpleVariety() == 2) {
/*      */       SchemaType[] arrayOfSchemaType = paramSchemaType.getUnionConstituentTypes();
/*      */       if (arrayOfSchemaType.length == 0)
/*      */         return ""; 
/*      */       return sampleDataForSimpleType(arrayOfSchemaType[pick(arrayOfSchemaType.length)]);
/*      */     } 
/*      */     XmlAnySimpleType[] arrayOfXmlAnySimpleType = paramSchemaType.getEnumerationValues();
/*      */     if (arrayOfXmlAnySimpleType != null && arrayOfXmlAnySimpleType.length > 0)
/*      */       return arrayOfXmlAnySimpleType[pick(arrayOfXmlAnySimpleType.length)].getStringValue(); 
/*      */     switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*      */       default:
/*      */         return "";
/*      */       case 1:
/*      */       case 2:
/*      */         return "anything";
/*      */       case 3:
/*      */         return (pick(2) == 0) ? "true" : "false";
/*      */       case 4:
/*      */         str = null;
/*      */         try {
/*      */           str = new String(Base64.encode(formatToLength(pick(WORDS), paramSchemaType).getBytes("utf-8")));
/*      */         } catch (UnsupportedEncodingException unsupportedEncodingException) {}
/*      */         return str;
/*      */       case 5:
/*      */         return HexBin.encode(formatToLength(pick(WORDS), paramSchemaType));
/*      */       case 6:
/*      */         return formatToLength("http://www." + pick(DNS1) + "." + pick(DNS2) + "/" + pick(WORDS) + "/" + pick(WORDS), paramSchemaType);
/*      */       case 7:
/*      */         return formatToLength("qname", paramSchemaType);
/*      */       case 8:
/*      */         return formatToLength("notation", paramSchemaType);
/*      */       case 9:
/*      */         return "1.5E2";
/*      */       case 10:
/*      */         return "1.051732E7";
/*      */       case 11:
/*      */         switch (closestBuiltin(paramSchemaType).getBuiltinTypeCode()) {
/*      */           case 25:
/*      */             return formatDecimal("1", paramSchemaType);
/*      */           case 33:
/*      */             return formatDecimal("5", paramSchemaType);
/*      */           case 26:
/*      */             return formatDecimal("2", paramSchemaType);
/*      */           case 34:
/*      */             return formatDecimal("6", paramSchemaType);
/*      */           case 24:
/*      */             return formatDecimal("3", paramSchemaType);
/*      */           case 32:
/*      */             return formatDecimal("7", paramSchemaType);
/*      */           case 23:
/*      */             return formatDecimal("10", paramSchemaType);
/*      */           case 31:
/*      */             return formatDecimal("11", paramSchemaType);
/*      */           case 22:
/*      */             return formatDecimal("100", paramSchemaType);
/*      */           case 27:
/*      */             return formatDecimal("-200", paramSchemaType);
/*      */           case 28:
/*      */             return formatDecimal("-201", paramSchemaType);
/*      */           case 29:
/*      */             return formatDecimal("200", paramSchemaType);
/*      */           case 30:
/*      */             return formatDecimal("201", paramSchemaType);
/*      */         } 
/*      */         return formatDecimal("1000.00", paramSchemaType);
/*      */       case 12:
/*      */         switch (closestBuiltin(paramSchemaType).getBuiltinTypeCode()) {
/*      */           case 12:
/*      */           case 35:
/*      */             str = "string";
/*      */             return formatToLength(str, paramSchemaType);
/*      */           case 36:
/*      */             str = "token";
/*      */             return formatToLength(str, paramSchemaType);
/*      */         } 
/*      */         str = "string";
/*      */         return formatToLength(str, paramSchemaType);
/*      */       case 13:
/*      */         return formatDuration(paramSchemaType);
/*      */       case 14:
/*      */       case 15:
/*      */       case 16:
/*      */       case 17:
/*      */       case 18:
/*      */       case 19:
/*      */       case 20:
/*      */       case 21:
/*      */         break;
/*      */     } 
/*      */     return formatDate(paramSchemaType);
/*      */   }
/*      */   
/*      */   public static final String[] WORDS = new String[] { 
/*      */       "ipsa", "iovis", "rapidum", "iaculata", "e", "nubibus", "ignem", "disiecitque", "rates", "evertitque", 
/*      */       "aequora", "ventis", "illum", "exspirantem", "transfixo", "pectore", "flammas", "turbine", "corripuit", "scopuloque", 
/*      */       "infixit", "acuto", "ast", "ego", "quae", "divum", "incedo", "regina", "iovisque", "et", 
/*      */       "soror", "et", "coniunx", "una", "cum", "gente", "tot", "annos", "bella", "gero", 
/*      */       "et", "quisquam", "numen", "iunonis", "adorat", "praeterea", "aut", "supplex", "aris", "imponet", 
/*      */       "honorem", "talia", "flammato", "secum", "dea", "corde", "volutans", "nimborum", "in", "patriam", 
/*      */       "loca", "feta", "furentibus", "austris", "aeoliam", "venit", "hic", "vasto", "rex", "aeolus", 
/*      */       "antro", "luctantis", "ventos", "tempestatesque", "sonoras", "imperio", "premit", "ac", "vinclis", "et", 
/*      */       "carcere", "frenat", "illi", "indignantes", "magno", "cum", "murmure", "montis", "circum", "claustra", 
/*      */       "fremunt", "celsa", "sedet", "aeolus", "arce", "sceptra", "tenens", "mollitque", "animos", "et", 
/*      */       "temperat", "iras", "ni", "faciat", "maria", "ac", "terras", "caelumque", "profundum", "quippe", 
/*      */       "ferant", "rapidi", "secum", "verrantque", "per", "auras", "sed", "pater", "omnipotens", "speluncis", 
/*      */       "abdidit", "atris", "hoc", "metuens", "molemque", "et", "montis", "insuper", "altos", "imposuit", 
/*      */       "regemque", "dedit", "qui", "foedere", "certo", "et", "premere", "et", "laxas", "sciret", 
/*      */       "dare", "iussus", "habenas" };
/*      */   private static final String[] DNS1 = new String[] { "corp", "your", "my", "sample", "company", "test", "any" };
/*      */   private static final String[] DNS2 = new String[] { "com", "org", "com", "gov", "org", "com", "org", "com", "edu" };
/*      */   
/*      */   private int pick(int paramInt) {
/*      */     return this._picker.nextInt(paramInt);
/*      */   }
/*      */   
/*      */   private String pick(String[] paramArrayOfString) {
/*      */     return paramArrayOfString[pick(paramArrayOfString.length)];
/*      */   }
/*      */   
/*      */   private String pick(String[] paramArrayOfString, int paramInt) {
/*      */     if (paramInt <= 0)
/*      */       return ""; 
/*      */     int i = pick(paramArrayOfString.length);
/*      */     StringBuffer stringBuffer = new StringBuffer(paramArrayOfString[i]);
/*      */     while (paramInt-- > 0) {
/*      */       i++;
/*      */       if (i >= paramArrayOfString.length)
/*      */         i = 0; 
/*      */       stringBuffer.append(' ');
/*      */       stringBuffer.append(paramArrayOfString[i]);
/*      */     } 
/*      */     return stringBuffer.toString();
/*      */   }
/*      */   
/*      */   private String pickDigits(int paramInt) {
/*      */     StringBuffer stringBuffer = new StringBuffer();
/*      */     while (paramInt-- > 0)
/*      */       stringBuffer.append(Integer.toString(pick(10))); 
/*      */     return stringBuffer.toString();
/*      */   }
/*      */   
/*      */   private int pickLength(SchemaType paramSchemaType) {
/*      */     int i, j;
/*      */     XmlInteger xmlInteger1 = (XmlInteger)paramSchemaType.getFacet(0);
/*      */     if (xmlInteger1 != null)
/*      */       return xmlInteger1.getBigIntegerValue().intValue(); 
/*      */     XmlInteger xmlInteger2 = (XmlInteger)paramSchemaType.getFacet(1);
/*      */     XmlInteger xmlInteger3 = (XmlInteger)paramSchemaType.getFacet(2);
/*      */     if (xmlInteger2 == null) {
/*      */       i = 0;
/*      */     } else {
/*      */       i = xmlInteger2.getBigIntegerValue().intValue();
/*      */     } 
/*      */     if (xmlInteger3 == null) {
/*      */       j = Integer.MAX_VALUE;
/*      */     } else {
/*      */       j = xmlInteger3.getBigIntegerValue().intValue();
/*      */     } 
/*      */     if (i == 0 && j >= 1)
/*      */       i = 1; 
/*      */     if (j > i + 2)
/*      */       j = i + 2; 
/*      */     if (j < i)
/*      */       j = i; 
/*      */     return i + pick(j - i);
/*      */   }
/*      */   
/*      */   private String formatToLength(String paramString, SchemaType paramSchemaType) {
/*      */     String str = paramString;
/*      */     try {
/*      */       SimpleValue simpleValue1 = (SimpleValue)paramSchemaType.getFacet(0);
/*      */       if (simpleValue1 == null)
/*      */         simpleValue1 = (SimpleValue)paramSchemaType.getFacet(1); 
/*      */       if (simpleValue1 != null) {
/*      */         int i = simpleValue1.getIntValue();
/*      */         while (str.length() < i)
/*      */           str = str + str; 
/*      */       } 
/*      */       SimpleValue simpleValue2 = (SimpleValue)paramSchemaType.getFacet(0);
/*      */       if (simpleValue2 == null)
/*      */         simpleValue2 = (SimpleValue)paramSchemaType.getFacet(2); 
/*      */       if (simpleValue2 != null) {
/*      */         int i = simpleValue2.getIntValue();
/*      */         if (str.length() > i)
/*      */           str = str.substring(0, i); 
/*      */       } 
/*      */     } catch (Exception exception) {}
/*      */     return str;
/*      */   }
/*      */   
/*      */   private String formatDecimal(String paramString, SchemaType paramSchemaType) {
/*      */     BigDecimal bigDecimal4, bigDecimal1 = new BigDecimal(paramString);
/*      */     XmlDecimal xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(4);
/*      */     BigDecimal bigDecimal2 = (xmlDecimal != null) ? xmlDecimal.getBigDecimalValue() : null;
/*      */     xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(5);
/*      */     BigDecimal bigDecimal3 = (xmlDecimal != null) ? xmlDecimal.getBigDecimalValue() : null;
/*      */     boolean bool1 = true, bool2 = true;
/*      */     xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(3);
/*      */     if (xmlDecimal != null) {
/*      */       BigDecimal bigDecimal = xmlDecimal.getBigDecimalValue();
/*      */       if (bigDecimal2 == null || bigDecimal2.compareTo(bigDecimal) < 0) {
/*      */         bigDecimal2 = bigDecimal;
/*      */         bool1 = false;
/*      */       } 
/*      */     } 
/*      */     xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(6);
/*      */     if (xmlDecimal != null) {
/*      */       BigDecimal bigDecimal = xmlDecimal.getBigDecimalValue();
/*      */       if (bigDecimal3 == null || bigDecimal3.compareTo(bigDecimal) > 0) {
/*      */         bigDecimal3 = bigDecimal;
/*      */         bool2 = false;
/*      */       } 
/*      */     } 
/*      */     xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(7);
/*      */     int i = -1;
/*      */     if (xmlDecimal != null) {
/*      */       i = xmlDecimal.getBigDecimalValue().intValue();
/*      */       StringBuffer stringBuffer = new StringBuffer(i);
/*      */       for (byte b2 = 0; b2 < i; b2++)
/*      */         stringBuffer.append('9'); 
/*      */       BigDecimal bigDecimal = new BigDecimal(stringBuffer.toString());
/*      */       if (bigDecimal3 != null && bigDecimal3.compareTo(bigDecimal) > 0) {
/*      */         bigDecimal3 = bigDecimal;
/*      */         bool2 = true;
/*      */       } 
/*      */       bigDecimal = bigDecimal.negate();
/*      */       if (bigDecimal2 != null && bigDecimal2.compareTo(bigDecimal) < 0) {
/*      */         bigDecimal2 = bigDecimal;
/*      */         bool1 = true;
/*      */       } 
/*      */     } 
/*      */     boolean bool3 = (bigDecimal2 == null) ? true : bigDecimal1.compareTo(bigDecimal2);
/*      */     boolean bool4 = (bigDecimal3 == null) ? true : bigDecimal1.compareTo(bigDecimal3);
/*      */     boolean bool5 = (!bool3 || (!bool3 && bool1)) ? true : false;
/*      */     boolean bool6 = (!bool4 || (!bool4 && bool2)) ? true : false;
/*      */     xmlDecimal = (XmlDecimal)paramSchemaType.getFacet(8);
/*      */     int j = -1;
/*      */     if (xmlDecimal == null) {
/*      */       bigDecimal4 = new BigDecimal(1);
/*      */     } else {
/*      */       j = xmlDecimal.getBigDecimalValue().intValue();
/*      */       if (j > 0) {
/*      */         StringBuffer stringBuffer = new StringBuffer("0.");
/*      */         for (byte b2 = 1; b2 < j; b2++)
/*      */           stringBuffer.append('0'); 
/*      */         stringBuffer.append('1');
/*      */         bigDecimal4 = new BigDecimal(stringBuffer.toString());
/*      */       } else {
/*      */         bigDecimal4 = new BigDecimal(1.0D);
/*      */       } 
/*      */     } 
/*      */     if (!bool5 || !bool6)
/*      */       if (bool5 && !bool6) {
/*      */         if (bool2) {
/*      */           bigDecimal1 = bigDecimal3;
/*      */         } else {
/*      */           bigDecimal1 = bigDecimal3.subtract(bigDecimal4);
/*      */         } 
/*      */       } else if (!bool5 && bool6) {
/*      */         if (bool1) {
/*      */           bigDecimal1 = bigDecimal2;
/*      */         } else {
/*      */           bigDecimal1 = bigDecimal2.add(bigDecimal4);
/*      */         } 
/*      */       }  
/*      */     byte b1 = 0;
/*      */     BigDecimal bigDecimal5 = new BigDecimal(BigInteger.ONE);
/*      */     for (BigDecimal bigDecimal6 = bigDecimal1; bigDecimal6.abs().compareTo(bigDecimal5) >= 0; b1++)
/*      */       bigDecimal6 = bigDecimal6.movePointLeft(1); 
/*      */     if (j > 0) {
/*      */       if (i >= 0) {
/*      */         bigDecimal1 = bigDecimal1.setScale(Math.max(j, i - b1));
/*      */       } else {
/*      */         bigDecimal1 = bigDecimal1.setScale(j);
/*      */       } 
/*      */     } else if (j == 0) {
/*      */       bigDecimal1 = bigDecimal1.setScale(0);
/*      */     } 
/*      */     return bigDecimal1.toString();
/*      */   }
/*      */   
/*      */   private String formatDuration(SchemaType paramSchemaType) {
/*      */     XmlDuration xmlDuration = (XmlDuration)paramSchemaType.getFacet(4);
/*      */     GDuration gDuration1 = null;
/*      */     if (xmlDuration != null)
/*      */       gDuration1 = xmlDuration.getGDurationValue(); 
/*      */     xmlDuration = (XmlDuration)paramSchemaType.getFacet(5);
/*      */     GDuration gDuration2 = null;
/*      */     if (xmlDuration != null)
/*      */       gDuration2 = xmlDuration.getGDurationValue(); 
/*      */     xmlDuration = (XmlDuration)paramSchemaType.getFacet(3);
/*      */     GDuration gDuration3 = null;
/*      */     if (xmlDuration != null)
/*      */       gDuration3 = xmlDuration.getGDurationValue(); 
/*      */     xmlDuration = (XmlDuration)paramSchemaType.getFacet(6);
/*      */     GDuration gDuration4 = null;
/*      */     if (xmlDuration != null)
/*      */       gDuration4 = xmlDuration.getGDurationValue(); 
/*      */     GDurationBuilder gDurationBuilder = new GDurationBuilder();
/*      */     gDurationBuilder.setSecond(pick(800000));
/*      */     gDurationBuilder.setMonth(pick(20));
/*      */     if (gDuration1 != null) {
/*      */       if (gDurationBuilder.getYear() < gDuration1.getYear())
/*      */         gDurationBuilder.setYear(gDuration1.getYear()); 
/*      */       if (gDurationBuilder.getMonth() < gDuration1.getMonth())
/*      */         gDurationBuilder.setMonth(gDuration1.getMonth()); 
/*      */       if (gDurationBuilder.getDay() < gDuration1.getDay())
/*      */         gDurationBuilder.setDay(gDuration1.getDay()); 
/*      */       if (gDurationBuilder.getHour() < gDuration1.getHour())
/*      */         gDurationBuilder.setHour(gDuration1.getHour()); 
/*      */       if (gDurationBuilder.getMinute() < gDuration1.getMinute())
/*      */         gDurationBuilder.setMinute(gDuration1.getMinute()); 
/*      */       if (gDurationBuilder.getSecond() < gDuration1.getSecond())
/*      */         gDurationBuilder.setSecond(gDuration1.getSecond()); 
/*      */       if (gDurationBuilder.getFraction().compareTo(gDuration1.getFraction()) < 0)
/*      */         gDurationBuilder.setFraction(gDuration1.getFraction()); 
/*      */     } 
/*      */     if (gDuration2 != null) {
/*      */       if (gDurationBuilder.getYear() > gDuration2.getYear())
/*      */         gDurationBuilder.setYear(gDuration2.getYear()); 
/*      */       if (gDurationBuilder.getMonth() > gDuration2.getMonth())
/*      */         gDurationBuilder.setMonth(gDuration2.getMonth()); 
/*      */       if (gDurationBuilder.getDay() > gDuration2.getDay())
/*      */         gDurationBuilder.setDay(gDuration2.getDay()); 
/*      */       if (gDurationBuilder.getHour() > gDuration2.getHour())
/*      */         gDurationBuilder.setHour(gDuration2.getHour()); 
/*      */       if (gDurationBuilder.getMinute() > gDuration2.getMinute())
/*      */         gDurationBuilder.setMinute(gDuration2.getMinute()); 
/*      */       if (gDurationBuilder.getSecond() > gDuration2.getSecond())
/*      */         gDurationBuilder.setSecond(gDuration2.getSecond()); 
/*      */       if (gDurationBuilder.getFraction().compareTo(gDuration2.getFraction()) > 0)
/*      */         gDurationBuilder.setFraction(gDuration2.getFraction()); 
/*      */     } 
/*      */     if (gDuration3 != null) {
/*      */       if (gDurationBuilder.getYear() <= gDuration3.getYear())
/*      */         gDurationBuilder.setYear(gDuration3.getYear() + 1); 
/*      */       if (gDurationBuilder.getMonth() <= gDuration3.getMonth())
/*      */         gDurationBuilder.setMonth(gDuration3.getMonth() + 1); 
/*      */       if (gDurationBuilder.getDay() <= gDuration3.getDay())
/*      */         gDurationBuilder.setDay(gDuration3.getDay() + 1); 
/*      */       if (gDurationBuilder.getHour() <= gDuration3.getHour())
/*      */         gDurationBuilder.setHour(gDuration3.getHour() + 1); 
/*      */       if (gDurationBuilder.getMinute() <= gDuration3.getMinute())
/*      */         gDurationBuilder.setMinute(gDuration3.getMinute() + 1); 
/*      */       if (gDurationBuilder.getSecond() <= gDuration3.getSecond())
/*      */         gDurationBuilder.setSecond(gDuration3.getSecond() + 1); 
/*      */       if (gDurationBuilder.getFraction().compareTo(gDuration3.getFraction()) <= 0)
/*      */         gDurationBuilder.setFraction(gDuration3.getFraction().add(new BigDecimal(0.001D))); 
/*      */     } 
/*      */     if (gDuration4 != null) {
/*      */       if (gDurationBuilder.getYear() > gDuration4.getYear())
/*      */         gDurationBuilder.setYear(gDuration4.getYear()); 
/*      */       if (gDurationBuilder.getMonth() > gDuration4.getMonth())
/*      */         gDurationBuilder.setMonth(gDuration4.getMonth()); 
/*      */       if (gDurationBuilder.getDay() > gDuration4.getDay())
/*      */         gDurationBuilder.setDay(gDuration4.getDay()); 
/*      */       if (gDurationBuilder.getHour() > gDuration4.getHour())
/*      */         gDurationBuilder.setHour(gDuration4.getHour()); 
/*      */       if (gDurationBuilder.getMinute() > gDuration4.getMinute())
/*      */         gDurationBuilder.setMinute(gDuration4.getMinute()); 
/*      */       if (gDurationBuilder.getSecond() > gDuration4.getSecond())
/*      */         gDurationBuilder.setSecond(gDuration4.getSecond()); 
/*      */       if (gDurationBuilder.getFraction().compareTo(gDuration4.getFraction()) > 0)
/*      */         gDurationBuilder.setFraction(gDuration4.getFraction()); 
/*      */     } 
/*      */     gDurationBuilder.normalize();
/*      */     return gDurationBuilder.toString();
/*      */   }
/*      */   
/*      */   private String formatDate(SchemaType paramSchemaType) {
/*      */     XmlDateTime xmlDateTime;
/*      */     XmlTime xmlTime;
/*      */     XmlDate xmlDate;
/*      */     XmlGYearMonth xmlGYearMonth;
/*      */     XmlGYear xmlGYear;
/*      */     XmlGMonthDay xmlGMonthDay;
/*      */     XmlGDay xmlGDay;
/*      */     XmlGMonth xmlGMonth;
/*      */     GDateBuilder gDateBuilder = new GDateBuilder(new Date(1000L * pick(31536000) + (30L + pick(20)) * 365L * 24L * 60L * 60L * 1000L));
/*      */     GDate gDate1 = null, gDate2 = null;
/*      */     switch (paramSchemaType.getPrimitiveType().getBuiltinTypeCode()) {
/*      */       case 14:
/*      */         xmlDateTime = (XmlDateTime)paramSchemaType.getFacet(4);
/*      */         if (xmlDateTime != null)
/*      */           gDate1 = xmlDateTime.getGDateValue(); 
/*      */         xmlDateTime = (XmlDateTime)paramSchemaType.getFacet(3);
/*      */         if (xmlDateTime != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlDateTime.getGDateValue()) <= 0))
/*      */           gDate1 = xmlDateTime.getGDateValue(); 
/*      */         xmlDateTime = (XmlDateTime)paramSchemaType.getFacet(5);
/*      */         if (xmlDateTime != null)
/*      */           gDate2 = xmlDateTime.getGDateValue(); 
/*      */         xmlDateTime = (XmlDateTime)paramSchemaType.getFacet(6);
/*      */         if (xmlDateTime != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlDateTime.getGDateValue()) >= 0))
/*      */           gDate2 = xmlDateTime.getGDateValue(); 
/*      */         break;
/*      */       case 15:
/*      */         xmlTime = (XmlTime)paramSchemaType.getFacet(4);
/*      */         if (xmlTime != null)
/*      */           gDate1 = xmlTime.getGDateValue(); 
/*      */         xmlTime = (XmlTime)paramSchemaType.getFacet(3);
/*      */         if (xmlTime != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlTime.getGDateValue()) <= 0))
/*      */           gDate1 = xmlTime.getGDateValue(); 
/*      */         xmlTime = (XmlTime)paramSchemaType.getFacet(5);
/*      */         if (xmlTime != null)
/*      */           gDate2 = xmlTime.getGDateValue(); 
/*      */         xmlTime = (XmlTime)paramSchemaType.getFacet(6);
/*      */         if (xmlTime != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlTime.getGDateValue()) >= 0))
/*      */           gDate2 = xmlTime.getGDateValue(); 
/*      */         break;
/*      */       case 16:
/*      */         xmlDate = (XmlDate)paramSchemaType.getFacet(4);
/*      */         if (xmlDate != null)
/*      */           gDate1 = xmlDate.getGDateValue(); 
/*      */         xmlDate = (XmlDate)paramSchemaType.getFacet(3);
/*      */         if (xmlDate != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlDate.getGDateValue()) <= 0))
/*      */           gDate1 = xmlDate.getGDateValue(); 
/*      */         xmlDate = (XmlDate)paramSchemaType.getFacet(5);
/*      */         if (xmlDate != null)
/*      */           gDate2 = xmlDate.getGDateValue(); 
/*      */         xmlDate = (XmlDate)paramSchemaType.getFacet(6);
/*      */         if (xmlDate != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlDate.getGDateValue()) >= 0))
/*      */           gDate2 = xmlDate.getGDateValue(); 
/*      */         break;
/*      */       case 17:
/*      */         xmlGYearMonth = (XmlGYearMonth)paramSchemaType.getFacet(4);
/*      */         if (xmlGYearMonth != null)
/*      */           gDate1 = xmlGYearMonth.getGDateValue(); 
/*      */         xmlGYearMonth = (XmlGYearMonth)paramSchemaType.getFacet(3);
/*      */         if (xmlGYearMonth != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlGYearMonth.getGDateValue()) <= 0))
/*      */           gDate1 = xmlGYearMonth.getGDateValue(); 
/*      */         xmlGYearMonth = (XmlGYearMonth)paramSchemaType.getFacet(5);
/*      */         if (xmlGYearMonth != null)
/*      */           gDate2 = xmlGYearMonth.getGDateValue(); 
/*      */         xmlGYearMonth = (XmlGYearMonth)paramSchemaType.getFacet(6);
/*      */         if (xmlGYearMonth != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlGYearMonth.getGDateValue()) >= 0))
/*      */           gDate2 = xmlGYearMonth.getGDateValue(); 
/*      */         break;
/*      */       case 18:
/*      */         xmlGYear = (XmlGYear)paramSchemaType.getFacet(4);
/*      */         if (xmlGYear != null)
/*      */           gDate1 = xmlGYear.getGDateValue(); 
/*      */         xmlGYear = (XmlGYear)paramSchemaType.getFacet(3);
/*      */         if (xmlGYear != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlGYear.getGDateValue()) <= 0))
/*      */           gDate1 = xmlGYear.getGDateValue(); 
/*      */         xmlGYear = (XmlGYear)paramSchemaType.getFacet(5);
/*      */         if (xmlGYear != null)
/*      */           gDate2 = xmlGYear.getGDateValue(); 
/*      */         xmlGYear = (XmlGYear)paramSchemaType.getFacet(6);
/*      */         if (xmlGYear != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlGYear.getGDateValue()) >= 0))
/*      */           gDate2 = xmlGYear.getGDateValue(); 
/*      */         break;
/*      */       case 19:
/*      */         xmlGMonthDay = (XmlGMonthDay)paramSchemaType.getFacet(4);
/*      */         if (xmlGMonthDay != null)
/*      */           gDate1 = xmlGMonthDay.getGDateValue(); 
/*      */         xmlGMonthDay = (XmlGMonthDay)paramSchemaType.getFacet(3);
/*      */         if (xmlGMonthDay != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlGMonthDay.getGDateValue()) <= 0))
/*      */           gDate1 = xmlGMonthDay.getGDateValue(); 
/*      */         xmlGMonthDay = (XmlGMonthDay)paramSchemaType.getFacet(5);
/*      */         if (xmlGMonthDay != null)
/*      */           gDate2 = xmlGMonthDay.getGDateValue(); 
/*      */         xmlGMonthDay = (XmlGMonthDay)paramSchemaType.getFacet(6);
/*      */         if (xmlGMonthDay != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlGMonthDay.getGDateValue()) >= 0))
/*      */           gDate2 = xmlGMonthDay.getGDateValue(); 
/*      */         break;
/*      */       case 20:
/*      */         xmlGDay = (XmlGDay)paramSchemaType.getFacet(4);
/*      */         if (xmlGDay != null)
/*      */           gDate1 = xmlGDay.getGDateValue(); 
/*      */         xmlGDay = (XmlGDay)paramSchemaType.getFacet(3);
/*      */         if (xmlGDay != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlGDay.getGDateValue()) <= 0))
/*      */           gDate1 = xmlGDay.getGDateValue(); 
/*      */         xmlGDay = (XmlGDay)paramSchemaType.getFacet(5);
/*      */         if (xmlGDay != null)
/*      */           gDate2 = xmlGDay.getGDateValue(); 
/*      */         xmlGDay = (XmlGDay)paramSchemaType.getFacet(6);
/*      */         if (xmlGDay != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlGDay.getGDateValue()) >= 0))
/*      */           gDate2 = xmlGDay.getGDateValue(); 
/*      */         break;
/*      */       case 21:
/*      */         xmlGMonth = (XmlGMonth)paramSchemaType.getFacet(4);
/*      */         if (xmlGMonth != null)
/*      */           gDate1 = xmlGMonth.getGDateValue(); 
/*      */         xmlGMonth = (XmlGMonth)paramSchemaType.getFacet(3);
/*      */         if (xmlGMonth != null && (gDate1 == null || gDate1.compareToGDate((GDateSpecification)xmlGMonth.getGDateValue()) <= 0))
/*      */           gDate1 = xmlGMonth.getGDateValue(); 
/*      */         xmlGMonth = (XmlGMonth)paramSchemaType.getFacet(5);
/*      */         if (xmlGMonth != null)
/*      */           gDate2 = xmlGMonth.getGDateValue(); 
/*      */         xmlGMonth = (XmlGMonth)paramSchemaType.getFacet(6);
/*      */         if (xmlGMonth != null && (gDate2 == null || gDate2.compareToGDate((GDateSpecification)xmlGMonth.getGDateValue()) >= 0))
/*      */           gDate2 = xmlGMonth.getGDateValue(); 
/*      */         break;
/*      */     } 
/*      */     if (gDate1 != null && gDate2 == null) {
/*      */       if (gDate1.compareToGDate((GDateSpecification)gDateBuilder) >= 0) {
/*      */         XmlCalendar xmlCalendar = gDateBuilder.getCalendar();
/*      */         xmlCalendar.add(11, pick(8));
/*      */         gDateBuilder = new GDateBuilder((Calendar)xmlCalendar);
/*      */       } 
/*      */     } else if (gDate1 == null && gDate2 != null) {
/*      */       if (gDate2.compareToGDate((GDateSpecification)gDateBuilder) <= 0) {
/*      */         XmlCalendar xmlCalendar = gDateBuilder.getCalendar();
/*      */         xmlCalendar.add(11, 0 - pick(8));
/*      */         gDateBuilder = new GDateBuilder((Calendar)xmlCalendar);
/*      */       } 
/*      */     } else if (gDate1 != null && gDate2 != null) {
/*      */       if (gDate1.compareToGDate((GDateSpecification)gDateBuilder) >= 0 || gDate2.compareToGDate((GDateSpecification)gDateBuilder) <= 0) {
/*      */         XmlCalendar xmlCalendar1 = gDate1.getCalendar();
/*      */         XmlCalendar xmlCalendar2 = gDate2.getCalendar();
/*      */         xmlCalendar1.add(11, 1);
/*      */         if (xmlCalendar1.after(xmlCalendar2)) {
/*      */           xmlCalendar1.add(11, -1);
/*      */           xmlCalendar1.add(12, 1);
/*      */           if (xmlCalendar1.after(xmlCalendar2)) {
/*      */             xmlCalendar1.add(12, -1);
/*      */             xmlCalendar1.add(13, 1);
/*      */             if (xmlCalendar1.after(xmlCalendar2)) {
/*      */               xmlCalendar1.add(13, -1);
/*      */               xmlCalendar1.add(14, 1);
/*      */               if (xmlCalendar1.after(xmlCalendar2))
/*      */                 xmlCalendar1.add(14, -1); 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         gDateBuilder = new GDateBuilder((Calendar)xmlCalendar1);
/*      */       } 
/*      */     } 
/*      */     gDateBuilder.setBuiltinTypeCode(paramSchemaType.getPrimitiveType().getBuiltinTypeCode());
/*      */     if (pick(2) == 0)
/*      */       gDateBuilder.clearTimeZone(); 
/*      */     return gDateBuilder.toString();
/*      */   }
/*      */   
/*      */   private SchemaType closestBuiltin(SchemaType paramSchemaType) {
/*      */     while (!paramSchemaType.isBuiltinType())
/*      */       paramSchemaType = paramSchemaType.getBaseType(); 
/*      */     return paramSchemaType;
/*      */   }
/*      */   
/*      */   public static b crackQName(String paramString) {
/*      */     String str1, str2;
/*      */     int i = paramString.lastIndexOf(':');
/*      */     if (i >= 0) {
/*      */       str1 = paramString.substring(0, i);
/*      */       str2 = paramString.substring(i + 1);
/*      */     } else {
/*      */       str1 = "";
/*      */       str2 = paramString;
/*      */     } 
/*      */     return new b(str1, str2);
/*      */   }
/*      */   
/*      */   private void processParticle(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     int i = determineMinMaxForSample(paramSchemaParticle, paramXmlCursor);
/*      */     while (i-- > 0) {
/*      */       switch (paramSchemaParticle.getParticleType()) {
/*      */         case 4:
/*      */           processElement(paramSchemaParticle, paramXmlCursor, paramBoolean);
/*      */         case 3:
/*      */           processSequence(paramSchemaParticle, paramXmlCursor, paramBoolean);
/*      */         case 2:
/*      */           processChoice(paramSchemaParticle, paramXmlCursor, paramBoolean);
/*      */         case 1:
/*      */           processAll(paramSchemaParticle, paramXmlCursor, paramBoolean);
/*      */         case 5:
/*      */           processWildCard(paramSchemaParticle, paramXmlCursor, paramBoolean);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private int determineMinMaxForSample(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor) {
/*      */     int i = paramSchemaParticle.getIntMinOccurs();
/*      */     int j = paramSchemaParticle.getIntMaxOccurs();
/*      */     if (i == j)
/*      */       return i; 
/*      */     int k = i;
/*      */     if (k == 0 && this._nElements < 1000)
/*      */       k = 1; 
/*      */     if (paramSchemaParticle.getParticleType() != 4)
/*      */       return k; 
/*      */     if (paramSchemaParticle.getMaxOccurs() == null) {
/*      */       if (i == 0) {
/*      */         paramXmlCursor.insertComment("Zero or more repetitions:");
/*      */       } else {
/*      */         paramXmlCursor.insertComment(i + " or more repetitions:");
/*      */       } 
/*      */     } else if (paramSchemaParticle.getIntMaxOccurs() > 1) {
/*      */       paramXmlCursor.insertComment(i + " to " + String.valueOf(paramSchemaParticle.getMaxOccurs()) + " repetitions:");
/*      */     } else {
/*      */       paramXmlCursor.insertComment("Optional:");
/*      */     } 
/*      */     return k;
/*      */   }
/*      */   
/*      */   private String getItemNameOrType(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor) {
/*      */     String str = null;
/*      */     if (paramSchemaParticle.getParticleType() == 4) {
/*      */       str = "Element (" + paramSchemaParticle.getName().dT() + ")";
/*      */     } else {
/*      */       str = printParticleType(paramSchemaParticle.getParticleType());
/*      */     } 
/*      */     return str;
/*      */   }
/*      */   
/*      */   private void processElement(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     SchemaLocalElement schemaLocalElement = (SchemaLocalElement)paramSchemaParticle;
/*      */     if (this._soapEnc) {
/*      */       paramXmlCursor.insertElement(schemaLocalElement.getName().dT());
/*      */     } else {
/*      */       paramXmlCursor.insertElement(schemaLocalElement.getName().dT(), schemaLocalElement.getName().getNamespaceURI());
/*      */     } 
/*      */     this._nElements++;
/*      */     paramXmlCursor.toPrevToken();
/*      */     createSampleForType(schemaLocalElement.getType(), paramXmlCursor);
/*      */     paramXmlCursor.toNextToken();
/*      */   }
/*      */   
/*      */   private void moveToken(int paramInt, XmlCursor paramXmlCursor) {
/*      */     for (byte b1 = 0; b1 < Math.abs(paramInt); b1++) {
/*      */       if (paramInt < 0) {
/*      */         paramXmlCursor.toPrevToken();
/*      */       } else {
/*      */         paramXmlCursor.toNextToken();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private static final String formatQName(XmlCursor paramXmlCursor, b paramb) {
/*      */     String str2;
/*      */     XmlCursor xmlCursor = paramXmlCursor.newCursor();
/*      */     xmlCursor.toParent();
/*      */     String str1 = xmlCursor.prefixForNamespace(paramb.getNamespaceURI());
/*      */     xmlCursor.dispose();
/*      */     if (str1 == null || str1.length() == 0) {
/*      */       str2 = paramb.dT();
/*      */     } else {
/*      */       str2 = str1 + ":" + paramb.dT();
/*      */     } 
/*      */     return str2;
/*      */   }
/*      */   
/*      */   private static final b HREF = new b("href");
/*      */   private static final b ID = new b("id");
/*      */   private static final b XSI_TYPE = new b("http://www.w3.org/2001/XMLSchema-instance", "type");
/*      */   private static final b ENC_ARRAYTYPE = new b("http://schemas.xmlsoap.org/soap/encoding/", "arrayType");
/*      */   private static final b ENC_OFFSET = new b("http://schemas.xmlsoap.org/soap/encoding/", "offset");
/*      */   private static final Set SKIPPED_SOAP_ATTRS = new HashSet(Arrays.asList((Object[])new b[] { HREF, ID, ENC_OFFSET }));
/*      */   private ArrayList _typeStack;
/*      */   
/*      */   private void processAttributes(SchemaType paramSchemaType, XmlCursor paramXmlCursor) {
/*      */     if (this._soapEnc) {
/*      */       b b2 = paramSchemaType.getName();
/*      */       if (b2 != null)
/*      */         paramXmlCursor.insertAttributeWithValue(XSI_TYPE, formatQName(paramXmlCursor, b2)); 
/*      */     } 
/*      */     SchemaProperty[] arrayOfSchemaProperty = paramSchemaType.getAttributeProperties();
/*      */     for (byte b1 = 0; b1 < arrayOfSchemaProperty.length; b1++) {
/*      */       SchemaProperty schemaProperty = arrayOfSchemaProperty[b1];
/*      */       if (this._soapEnc) {
/*      */         if (SKIPPED_SOAP_ATTRS.contains(schemaProperty.getName()))
/*      */           continue; 
/*      */         if (ENC_ARRAYTYPE.equals(schemaProperty.getName())) {
/*      */           SOAPArrayType sOAPArrayType = ((SchemaWSDLArrayType)paramSchemaType.getAttributeModel().getAttribute(schemaProperty.getName())).getWSDLArrayType();
/*      */           if (sOAPArrayType != null)
/*      */             paramXmlCursor.insertAttributeWithValue(schemaProperty.getName(), formatQName(paramXmlCursor, sOAPArrayType.getQName()) + sOAPArrayType.soap11DimensionString()); 
/*      */           continue;
/*      */         } 
/*      */       } 
/*      */       String str = schemaProperty.getDefaultText();
/*      */       paramXmlCursor.insertAttributeWithValue(schemaProperty.getName(), (str == null) ? sampleDataForSimpleType(schemaProperty.getType()) : str);
/*      */       continue;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processSequence(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/*      */     for (byte b1 = 0; b1 < arrayOfSchemaParticle.length; b1++) {
/*      */       processParticle(arrayOfSchemaParticle[b1], paramXmlCursor, paramBoolean);
/*      */       if (paramBoolean && b1 < arrayOfSchemaParticle.length - 1)
/*      */         paramXmlCursor.insertChars(pick(WORDS)); 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processChoice(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/*      */     paramXmlCursor.insertComment("You have a CHOICE of the next " + String.valueOf(arrayOfSchemaParticle.length) + " items at this level");
/*      */     for (byte b1 = 0; b1 < arrayOfSchemaParticle.length; b1++)
/*      */       processParticle(arrayOfSchemaParticle[b1], paramXmlCursor, paramBoolean); 
/*      */   }
/*      */   
/*      */   private void processAll(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     SchemaParticle[] arrayOfSchemaParticle = paramSchemaParticle.getParticleChildren();
/*      */     for (byte b1 = 0; b1 < arrayOfSchemaParticle.length; b1++) {
/*      */       processParticle(arrayOfSchemaParticle[b1], paramXmlCursor, paramBoolean);
/*      */       if (paramBoolean && b1 < arrayOfSchemaParticle.length - 1)
/*      */         paramXmlCursor.insertChars(pick(WORDS)); 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void processWildCard(SchemaParticle paramSchemaParticle, XmlCursor paramXmlCursor, boolean paramBoolean) {
/*      */     paramXmlCursor.insertComment("You may enter ANY elements at this point");
/*      */     paramXmlCursor.insertElement("AnyElement");
/*      */   }
/*      */   
/*      */   private static b getClosestName(SchemaType paramSchemaType) {
/*      */     while (paramSchemaType.getName() == null)
/*      */       paramSchemaType = paramSchemaType.getBaseType(); 
/*      */     return paramSchemaType.getName();
/*      */   }
/*      */   
/*      */   private String printParticleType(int paramInt) {
/*      */     StringBuffer stringBuffer = new StringBuffer();
/*      */     stringBuffer.append("Schema Particle Type: ");
/*      */     switch (paramInt) {
/*      */       case 1:
/*      */         stringBuffer.append("ALL\n");
/*      */         return stringBuffer.toString();
/*      */       case 2:
/*      */         stringBuffer.append("CHOICE\n");
/*      */         return stringBuffer.toString();
/*      */       case 4:
/*      */         stringBuffer.append("ELEMENT\n");
/*      */         return stringBuffer.toString();
/*      */       case 3:
/*      */         stringBuffer.append("SEQUENCE\n");
/*      */         return stringBuffer.toString();
/*      */       case 5:
/*      */         stringBuffer.append("WILDCARD\n");
/*      */         return stringBuffer.toString();
/*      */     } 
/*      */     stringBuffer.append("Schema Particle Type Unknown");
/*      */     return stringBuffer.toString();
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xsd2inst\SampleXmlUtil.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */