/*     */ package org.apache.xmlbeans;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.Serializable;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.text.MessageFormat;
/*     */ import java.util.MissingResourceException;
/*     */ import java.util.PropertyResourceBundle;
/*     */ import java.util.ResourceBundle;
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
/*     */ public class XmlError
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 1L;
/*  43 */   private static final ResourceBundle _bundle = PropertyResourceBundle.getBundle("org.apache.xmlbeans.message");
/*     */   
/*     */   private String _message;
/*     */   private String _code;
/*     */   private String _source;
/*  48 */   private int _severity = 0;
/*  49 */   private int _line = -1;
/*  50 */   private int _column = -1;
/*  51 */   private int _offset = -1;
/*     */   
/*     */   private transient XmlCursor _cursor;
/*     */   
/*     */   public static final int SEVERITY_ERROR = 0;
/*     */   
/*     */   public static final int SEVERITY_WARNING = 1;
/*     */   public static final int SEVERITY_INFO = 2;
/*     */   
/*     */   public XmlError(XmlError paramXmlError) {
/*  61 */     this._message = paramXmlError.getMessage();
/*  62 */     this._code = paramXmlError.getErrorCode();
/*  63 */     this._severity = paramXmlError.getSeverity();
/*  64 */     this._source = paramXmlError.getSourceName();
/*  65 */     this._line = paramXmlError.getLine();
/*  66 */     this._column = paramXmlError.getColumn();
/*  67 */     this._offset = paramXmlError.getOffset();
/*  68 */     this._cursor = paramXmlError.getCursorLocation();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private XmlError(String paramString1, String paramString2, int paramInt1, String paramString3, int paramInt2, int paramInt3, int paramInt4, XmlCursor paramXmlCursor) {
/*  78 */     this._message = paramString1;
/*  79 */     this._code = paramString2;
/*  80 */     this._severity = paramInt1;
/*  81 */     this._source = paramString3;
/*  82 */     this._line = paramInt2;
/*  83 */     this._column = paramInt3;
/*  84 */     this._offset = paramInt4;
/*  85 */     this._cursor = paramXmlCursor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private XmlError(String paramString1, Object[] paramArrayOfObject, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, XmlCursor paramXmlCursor) {
/*  91 */     this(formattedMessage(paramString1, paramArrayOfObject), paramString1, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XmlError(String paramString1, String paramString2, int paramInt, XmlCursor paramXmlCursor) {
/* 100 */     String str = null;
/* 101 */     int i = -1;
/* 102 */     int j = -1;
/* 103 */     int k = -1;
/*     */     
/* 105 */     if (paramXmlCursor != null) {
/*     */ 
/*     */       
/* 108 */       str = paramXmlCursor.documentProperties().getSourceName();
/*     */       
/* 110 */       XmlCursor xmlCursor = paramXmlCursor.newCursor();
/*     */       
/* 112 */       XmlLineNumber xmlLineNumber = (XmlLineNumber)xmlCursor.getBookmark(XmlLineNumber.class);
/*     */ 
/*     */       
/* 115 */       if (xmlLineNumber == null) {
/* 116 */         xmlLineNumber = (XmlLineNumber)xmlCursor.toPrevBookmark(XmlLineNumber.class);
/*     */       }
/* 118 */       if (xmlLineNumber != null) {
/*     */         
/* 120 */         i = xmlLineNumber.getLine();
/* 121 */         j = xmlLineNumber.getColumn();
/* 122 */         k = xmlLineNumber.getOffset();
/*     */       } 
/*     */       
/* 125 */       xmlCursor.dispose();
/*     */     } 
/*     */     
/* 128 */     this._message = paramString1;
/* 129 */     this._code = paramString2;
/* 130 */     this._severity = paramInt;
/* 131 */     this._source = str;
/* 132 */     this._line = i;
/* 133 */     this._column = j;
/* 134 */     this._offset = k;
/* 135 */     this._cursor = paramXmlCursor;
/*     */   }
/*     */ 
/*     */   
/*     */   protected XmlError(String paramString, Object[] paramArrayOfObject, int paramInt, XmlCursor paramXmlCursor) {
/* 140 */     this(formattedMessage(paramString, paramArrayOfObject), paramString, paramInt, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected XmlError(String paramString1, String paramString2, int paramInt, Location paramLocation) {
/* 149 */     String str = null;
/* 150 */     int i = -1;
/* 151 */     int j = -1;
/*     */     
/* 153 */     if (paramLocation != null) {
/*     */       
/* 155 */       i = paramLocation.getLineNumber();
/* 156 */       j = paramLocation.getColumnNumber();
/* 157 */       str = paramLocation.getPublicId();
/* 158 */       if (str == null) {
/* 159 */         str = paramLocation.getSystemId();
/*     */       }
/*     */     } 
/* 162 */     this._message = paramString1;
/* 163 */     this._code = paramString2;
/* 164 */     this._severity = paramInt;
/* 165 */     this._source = str;
/* 166 */     this._line = i;
/* 167 */     this._column = j;
/*     */   }
/*     */ 
/*     */   
/*     */   protected XmlError(String paramString, Object[] paramArrayOfObject, int paramInt, Location paramLocation) {
/* 172 */     this(formattedMessage(paramString, paramArrayOfObject), paramString, paramInt, paramLocation);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forMessage(String paramString) {
/* 181 */     return forMessage(paramString, 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forMessage(String paramString, int paramInt) {
/* 191 */     return forSource(paramString, paramInt, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forMessage(String paramString, Object[] paramArrayOfObject) {
/* 201 */     return forSource(paramString, paramArrayOfObject, 0, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forMessage(String paramString, Object[] paramArrayOfObject, int paramInt) {
/* 212 */     return forSource(paramString, paramArrayOfObject, paramInt, null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forSource(String paramString1, String paramString2) {
/* 222 */     return forLocation(paramString1, 0, paramString2, -1, -1, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forSource(String paramString1, int paramInt, String paramString2) {
/* 233 */     return forLocation(paramString1, paramInt, paramString2, -1, -1, -1);
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
/*     */   public static XmlError forSource(String paramString1, Object[] paramArrayOfObject, int paramInt, String paramString2) {
/* 245 */     return forLocation(paramString1, paramArrayOfObject, paramInt, paramString2, -1, -1, -1);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forLocation(String paramString1, String paramString2, Location paramLocation) {
/* 256 */     return new XmlError(paramString1, (String)null, 0, paramString2, paramLocation.getLineNumber(), paramLocation.getColumnNumber(), -1, null);
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
/*     */   
/*     */   public static XmlError forLocation(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3) {
/* 270 */     return new XmlError(paramString1, (String)null, 0, paramString2, paramInt1, paramInt2, paramInt3, null);
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
/*     */ 
/*     */   
/*     */   public static XmlError forLocation(String paramString1, Object[] paramArrayOfObject, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4) {
/* 285 */     return new XmlError(paramString1, paramArrayOfObject, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, null);
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
/*     */   
/*     */   public static XmlError forLocation(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4) {
/* 299 */     return new XmlError(paramString1, (String)null, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, null);
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
/*     */ 
/*     */   
/*     */   public static XmlError forLocationAndCursor(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3, int paramInt4, XmlCursor paramXmlCursor) {
/* 314 */     return new XmlError(paramString1, (String)null, paramInt1, paramString2, paramInt2, paramInt3, paramInt4, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forObject(String paramString, XmlObject paramXmlObject) {
/* 324 */     return forObject(paramString, 0, paramXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forObject(String paramString, Object[] paramArrayOfObject, XmlObject paramXmlObject) {
/* 335 */     return forObject(paramString, paramArrayOfObject, 0, paramXmlObject);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forObject(String paramString, int paramInt, XmlObject paramXmlObject) {
/* 346 */     if (paramXmlObject == null) {
/* 347 */       return forMessage(paramString, paramInt);
/*     */     }
/* 349 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 350 */     return forCursor(paramString, paramInt, xmlCursor);
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
/*     */   public static XmlError forObject(String paramString, Object[] paramArrayOfObject, int paramInt, XmlObject paramXmlObject) {
/* 363 */     if (paramXmlObject == null) {
/* 364 */       return forMessage(paramString, paramArrayOfObject, paramInt);
/*     */     }
/* 366 */     XmlCursor xmlCursor = paramXmlObject.newCursor();
/* 367 */     return forCursor(paramString, paramArrayOfObject, paramInt, xmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forCursor(String paramString, XmlCursor paramXmlCursor) {
/* 378 */     return forCursor(paramString, 0, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forCursor(String paramString, Object[] paramArrayOfObject, XmlCursor paramXmlCursor) {
/* 389 */     return forCursor(paramString, paramArrayOfObject, 0, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static XmlError forCursor(String paramString, int paramInt, XmlCursor paramXmlCursor) {
/* 400 */     return new XmlError(paramString, (String)null, paramInt, paramXmlCursor);
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
/*     */   public static XmlError forCursor(String paramString, Object[] paramArrayOfObject, int paramInt, XmlCursor paramXmlCursor) {
/* 412 */     return new XmlError(paramString, paramArrayOfObject, paramInt, paramXmlCursor);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected static String formattedFileName(String paramString, URI paramURI) {
/* 420 */     if (paramString == null) {
/* 421 */       return null;
/*     */     }
/* 423 */     URI uRI = null;
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 428 */       uRI = new URI(paramString);
/*     */ 
/*     */       
/* 431 */       if (!uRI.isAbsolute()) {
/* 432 */         uRI = null;
/*     */       }
/* 434 */     } catch (URISyntaxException uRISyntaxException) {
/*     */       
/* 436 */       uRI = null;
/*     */     } 
/*     */ 
/*     */     
/* 440 */     if (uRI == null) {
/* 441 */       uRI = (new File(paramString)).toURI();
/*     */     }
/* 443 */     if (paramURI != null) {
/* 444 */       uRI = paramURI.relativize(uRI);
/*     */     }
/*     */     
/* 447 */     if (uRI.isAbsolute() ? (uRI.getScheme().compareToIgnoreCase("file") == 0) : (paramURI != null && paramURI.isAbsolute() && paramURI.getScheme().compareToIgnoreCase("file") == 0)) {
/*     */       
/*     */       try {
/*     */ 
/*     */         
/* 452 */         return (new File(uRI)).toString();
/*     */       }
/* 454 */       catch (Exception exception) {}
/*     */     }
/*     */     
/* 457 */     return uRI.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String formattedMessage(String paramString, Object[] paramArrayOfObject) {
/*     */     String str;
/* 465 */     if (paramString == null) {
/* 466 */       return null;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 472 */       str = MessageFormat.format(_bundle.getString(paramString), paramArrayOfObject);
/*     */     }
/* 474 */     catch (MissingResourceException missingResourceException) {
/*     */       
/* 476 */       return MessageFormat.format(_bundle.getString("message.missing.resource"), new Object[] { missingResourceException.getMessage() });
/*     */     
/*     */     }
/* 479 */     catch (IllegalArgumentException illegalArgumentException) {
/*     */       
/* 481 */       return MessageFormat.format(_bundle.getString("message.pattern.invalid"), new Object[] { illegalArgumentException.getMessage() });
/*     */     } 
/*     */ 
/*     */     
/* 485 */     return str;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSeverity() {
/* 504 */     return this._severity;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getMessage() {
/* 509 */     return this._message;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getErrorCode() {
/* 514 */     return this._code;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getSourceName() {
/* 519 */     return this._source;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLine() {
/* 524 */     return this._line;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getColumn() {
/* 529 */     return this._column;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getOffset() {
/* 534 */     return this._offset;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getLocation(Object paramObject) {
/* 542 */     if (paramObject == XmlCursor.class)
/* 543 */       return this._cursor; 
/* 544 */     if (paramObject == XmlObject.class && this._cursor != null)
/* 545 */       return this._cursor.getObject(); 
/* 546 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlCursor getCursorLocation() {
/* 555 */     return (XmlCursor)getLocation(XmlCursor.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public XmlObject getObjectLocation() {
/* 564 */     return (XmlObject)getLocation(XmlObject.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 573 */     return toString(null);
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
/*     */   
/*     */   public String toString(URI paramURI) {
/* 587 */     StringBuffer stringBuffer = new StringBuffer();
/*     */     
/* 589 */     String str1 = formattedFileName(getSourceName(), paramURI);
/*     */     
/* 591 */     if (str1 != null) {
/*     */       
/* 593 */       stringBuffer.append(str1);
/* 594 */       int i = getLine();
/* 595 */       if (i < 0) {
/* 596 */         i = 0;
/*     */       }
/* 598 */       stringBuffer.append(':');
/* 599 */       stringBuffer.append(i);
/* 600 */       stringBuffer.append(':');
/* 601 */       if (getColumn() > 0) {
/*     */         
/* 603 */         stringBuffer.append(getColumn());
/* 604 */         stringBuffer.append(':');
/*     */       } 
/* 606 */       stringBuffer.append(" ");
/*     */     } 
/*     */     
/* 609 */     switch (getSeverity()) {
/*     */       case 0:
/* 611 */         stringBuffer.append("error: "); break;
/* 612 */       case 1: stringBuffer.append("warning: ");
/*     */         break;
/*     */     } 
/*     */     
/* 616 */     if (getErrorCode() != null)
/*     */     {
/* 618 */       stringBuffer.append(getErrorCode()).append(": ");
/*     */     }
/*     */     
/* 621 */     String str2 = getMessage();
/*     */     
/* 623 */     stringBuffer.append((str2 == null) ? "<Unspecified message>" : str2);
/*     */     
/* 625 */     return stringBuffer.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String severityAsString(int paramInt) {
/* 630 */     switch (paramInt) {
/*     */       case 0:
/* 632 */         return "error";
/*     */       case 1:
/* 634 */         return "warning";
/*     */       case 2:
/* 636 */         return "info";
/*     */     } 
/* 638 */     throw new IllegalArgumentException("unknown severity");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\XmlError.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */