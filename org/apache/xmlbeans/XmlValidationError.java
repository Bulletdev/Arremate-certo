/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.util.List;
/*     */ import javax.xml.namespace.b;
/*     */ import javax.xml.stream.Location;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class XmlValidationError
/*     */   extends XmlError
/*     */ {
/*     */   public static final int INCORRECT_ELEMENT = 1;
/*     */   public static final int ELEMENT_NOT_ALLOWED = 2;
/*     */   public static final int ELEMENT_TYPE_INVALID = 3;
/*     */   public static final int NIL_ELEMENT = 4;
/*     */   public static final int INCORRECT_ATTRIBUTE = 1000;
/*     */   public static final int ATTRIBUTE_TYPE_INVALID = 1001;
/*     */   public static final int LIST_INVALID = 2000;
/*     */   public static final int UNION_INVALID = 3000;
/*     */   public static final int UNDEFINED = 10000;
/*     */   private b _fieldQName;
/*     */   private b _offendingQName;
/*     */   private SchemaType _expectedSchemaType;
/*     */   private List _expectedQNames;
/*     */   private int _errorType;
/*     */   private SchemaType _badSchemaType;
/*     */   
/*     */   private XmlValidationError(String paramString, int paramInt1, XmlCursor paramXmlCursor, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 144 */     super(paramString, (String)null, paramInt1, paramXmlCursor);
/*     */     
/* 146 */     setFieldQName(paramb1);
/* 147 */     setOffendingQName(paramb2);
/* 148 */     setExpectedSchemaType(paramSchemaType1);
/* 149 */     setExpectedQNames(paramList);
/* 150 */     setErrorType(paramInt2);
/* 151 */     setBadSchemaType(paramSchemaType2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XmlValidationError(String paramString, Object[] paramArrayOfObject, int paramInt1, XmlCursor paramXmlCursor, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 162 */     super(paramString, paramArrayOfObject, paramInt1, paramXmlCursor);
/*     */     
/* 164 */     setFieldQName(paramb1);
/* 165 */     setOffendingQName(paramb2);
/* 166 */     setExpectedSchemaType(paramSchemaType1);
/* 167 */     setExpectedQNames(paramList);
/* 168 */     setErrorType(paramInt2);
/* 169 */     setBadSchemaType(paramSchemaType2);
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
/*     */   private XmlValidationError(String paramString, int paramInt1, Location paramLocation, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 181 */     super(paramString, (String)null, paramInt1, paramLocation);
/*     */     
/* 183 */     setFieldQName(paramb1);
/* 184 */     setOffendingQName(paramb2);
/* 185 */     setExpectedSchemaType(paramSchemaType1);
/* 186 */     setExpectedQNames(paramList);
/* 187 */     setErrorType(paramInt2);
/* 188 */     setBadSchemaType(paramSchemaType2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XmlValidationError(String paramString, Object[] paramArrayOfObject, int paramInt1, Location paramLocation, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 199 */     super(paramString, paramArrayOfObject, paramInt1, paramLocation);
/*     */     
/* 201 */     setFieldQName(paramb1);
/* 202 */     setOffendingQName(paramb2);
/* 203 */     setExpectedSchemaType(paramSchemaType1);
/* 204 */     setExpectedQNames(paramList);
/* 205 */     setErrorType(paramInt2);
/* 206 */     setBadSchemaType(paramSchemaType2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlValidationError forCursorWithDetails(String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt1, XmlCursor paramXmlCursor, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 213 */     if (paramString2 == null) {
/* 214 */       return new XmlValidationError(paramString1, paramInt1, paramXmlCursor, paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*     */     }
/*     */     
/* 217 */     return new XmlValidationError(paramString2, paramArrayOfObject, paramInt1, paramXmlCursor, paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlValidationError forLocationWithDetails(String paramString1, String paramString2, Object[] paramArrayOfObject, int paramInt1, Location paramLocation, b paramb1, b paramb2, SchemaType paramSchemaType1, List paramList, int paramInt2, SchemaType paramSchemaType2) {
/* 225 */     if (paramString2 == null) {
/* 226 */       return new XmlValidationError(paramString1, paramInt1, paramLocation, paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*     */     }
/*     */     
/* 229 */     return new XmlValidationError(paramString2, paramArrayOfObject, paramInt1, paramLocation, paramb1, paramb2, paramSchemaType1, paramList, paramInt2, paramSchemaType2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 235 */     if (this._fieldQName != null) {
/*     */       
/* 237 */       String str = super.getMessage();
/* 238 */       StringBuffer stringBuffer = new StringBuffer(str.length() + 100);
/*     */       
/* 240 */       stringBuffer.append(str);
/*     */       
/* 242 */       stringBuffer.append(" in element ");
/* 243 */       stringBuffer.append(this._fieldQName.dT());
/* 244 */       if (this._fieldQName.getNamespaceURI() != null && this._fieldQName.getNamespaceURI().length() != 0) {
/* 245 */         stringBuffer.append('@').append(this._fieldQName.getNamespaceURI());
/*     */       }
/* 247 */       return stringBuffer.toString();
/*     */     } 
/*     */     
/* 250 */     return super.getMessage();
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType getBadSchemaType() {
/* 255 */     return this._badSchemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setBadSchemaType(SchemaType paramSchemaType) {
/* 260 */     this._badSchemaType = paramSchemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getErrorType() {
/* 265 */     return this._errorType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setErrorType(int paramInt) {
/* 270 */     this._errorType = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public List getExpectedQNames() {
/* 275 */     return this._expectedQNames;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExpectedQNames(List paramList) {
/* 280 */     this._expectedQNames = paramList;
/*     */   }
/*     */ 
/*     */   
/*     */   public b getFieldQName() {
/* 285 */     return this._fieldQName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setFieldQName(b paramb) {
/* 290 */     this._fieldQName = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public b getOffendingQName() {
/* 295 */     return this._offendingQName;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setOffendingQName(b paramb) {
/* 300 */     this._offendingQName = paramb;
/*     */   }
/*     */ 
/*     */   
/*     */   public SchemaType getExpectedSchemaType() {
/* 305 */     return this._expectedSchemaType;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExpectedSchemaType(SchemaType paramSchemaType) {
/* 310 */     this._expectedSchemaType = paramSchemaType;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlValidationError.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */