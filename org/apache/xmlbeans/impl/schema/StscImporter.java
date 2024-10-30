/*      */ package org.apache.xmlbeans.impl.schema;
/*      */ 
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.ByteArrayOutputStream;
/*      */ import java.io.CharArrayReader;
/*      */ import java.io.CharArrayWriter;
/*      */ import java.io.File;
/*      */ import java.io.FileNotFoundException;
/*      */ import java.io.FileOutputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.io.OutputStreamWriter;
/*      */ import java.io.Reader;
/*      */ import java.net.MalformedURLException;
/*      */ import java.net.URI;
/*      */ import java.net.URISyntaxException;
/*      */ import java.net.URL;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.LinkedList;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.xmlbeans.SchemaTypeLoader;
/*      */ import org.apache.xmlbeans.XmlException;
/*      */ import org.apache.xmlbeans.XmlObject;
/*      */ import org.apache.xmlbeans.XmlOptions;
/*      */ import org.apache.xmlbeans.impl.common.IOUtil;
/*      */ import org.apache.xmlbeans.impl.common.XmlEncodingSniffer;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.RedefineDocument;
/*      */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*      */ import org.xml.sax.EntityResolver;
/*      */ import org.xml.sax.InputSource;
/*      */ import org.xml.sax.SAXException;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StscImporter
/*      */ {
/*      */   private static final String PROJECT_URL_PREFIX = "project://local";
/*      */   
/*      */   public static SchemaToProcess[] resolveImportsAndIncludes(SchemaDocument.Schema[] paramArrayOfSchema, boolean paramBoolean) {
/*   65 */     DownloadTable downloadTable = new DownloadTable(paramArrayOfSchema);
/*   66 */     return downloadTable.resolveImportsAndIncludes(paramBoolean);
/*      */   }
/*      */ 
/*      */   
/*      */   public static class SchemaToProcess
/*      */   {
/*      */     private SchemaDocument.Schema schema;
/*      */     private String chameleonNamespace;
/*      */     private List includes;
/*      */     private List redefines;
/*      */     private List redefineObjects;
/*      */     private Set indirectIncludes;
/*      */     private Set indirectIncludedBy;
/*      */     
/*      */     public SchemaToProcess(SchemaDocument.Schema param1Schema, String param1String) {
/*   81 */       this.schema = param1Schema;
/*   82 */       this.chameleonNamespace = param1String;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public SchemaDocument.Schema getSchema() {
/*   90 */       return this.schema;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getSourceName() {
/*   98 */       return this.schema.documentProperties().getSourceName();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getChameleonNamespace() {
/*  108 */       return this.chameleonNamespace;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public List getRedefines() {
/*  120 */       return this.redefines;
/*      */     }
/*      */ 
/*      */     
/*      */     public List getRedefineObjects() {
/*  125 */       return this.redefineObjects;
/*      */     }
/*      */ 
/*      */     
/*      */     private void addInclude(SchemaToProcess param1SchemaToProcess) {
/*  130 */       if (this.includes == null)
/*  131 */         this.includes = new ArrayList(); 
/*  132 */       this.includes.add(param1SchemaToProcess);
/*      */     }
/*      */ 
/*      */     
/*      */     private void addRedefine(SchemaToProcess param1SchemaToProcess, RedefineDocument.Redefine param1Redefine) {
/*  137 */       if (this.redefines == null || this.redefineObjects == null) {
/*      */         
/*  139 */         this.redefines = new ArrayList();
/*  140 */         this.redefineObjects = new ArrayList();
/*      */       } 
/*  142 */       this.redefines.add(param1SchemaToProcess);
/*  143 */       this.redefineObjects.add(param1Redefine);
/*      */     }
/*      */ 
/*      */     
/*      */     private void buildIndirectReferences() {
/*  148 */       if (this.includes != null) {
/*  149 */         for (byte b = 0; b < this.includes.size(); b++) {
/*      */           
/*  151 */           SchemaToProcess schemaToProcess = this.includes.get(b);
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  156 */           addIndirectIncludes(schemaToProcess);
/*      */         } 
/*      */       }
/*  159 */       if (this.redefines != null) {
/*  160 */         for (byte b = 0; b < this.redefines.size(); b++) {
/*      */           
/*  162 */           SchemaToProcess schemaToProcess = this.redefines.get(b);
/*  163 */           addIndirectIncludes(schemaToProcess);
/*      */         } 
/*      */       }
/*      */     }
/*      */     
/*      */     private void addIndirectIncludes(SchemaToProcess param1SchemaToProcess) {
/*  169 */       if (this.indirectIncludes == null)
/*  170 */         this.indirectIncludes = new HashSet(); 
/*  171 */       this.indirectIncludes.add(param1SchemaToProcess);
/*  172 */       if (param1SchemaToProcess.indirectIncludedBy == null)
/*  173 */         param1SchemaToProcess.indirectIncludedBy = new HashSet(); 
/*  174 */       param1SchemaToProcess.indirectIncludedBy.add(this);
/*  175 */       addIndirectIncludesHelper(this, param1SchemaToProcess);
/*  176 */       if (this.indirectIncludedBy != null) {
/*  177 */         for (SchemaToProcess schemaToProcess : this.indirectIncludedBy) {
/*      */ 
/*      */           
/*  180 */           schemaToProcess.indirectIncludes.add(param1SchemaToProcess);
/*  181 */           param1SchemaToProcess.indirectIncludedBy.add(schemaToProcess);
/*  182 */           addIndirectIncludesHelper(schemaToProcess, param1SchemaToProcess);
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*      */     private static void addIndirectIncludesHelper(SchemaToProcess param1SchemaToProcess1, SchemaToProcess param1SchemaToProcess2) {
/*  189 */       if (param1SchemaToProcess2.indirectIncludes != null) {
/*  190 */         for (SchemaToProcess schemaToProcess : param1SchemaToProcess2.indirectIncludes) {
/*      */ 
/*      */           
/*  193 */           param1SchemaToProcess1.indirectIncludes.add(schemaToProcess);
/*  194 */           schemaToProcess.indirectIncludedBy.add(param1SchemaToProcess1);
/*      */         } 
/*      */       }
/*      */     }
/*      */     
/*      */     public boolean indirectIncludes(SchemaToProcess param1SchemaToProcess) {
/*  200 */       return (this.indirectIncludes != null && this.indirectIncludes.contains(param1SchemaToProcess));
/*      */     }
/*      */ 
/*      */     
/*      */     public boolean equals(Object param1Object) {
/*  205 */       if (this == param1Object) return true; 
/*  206 */       if (!(param1Object instanceof SchemaToProcess)) return false;
/*      */       
/*  208 */       SchemaToProcess schemaToProcess = (SchemaToProcess)param1Object;
/*      */       
/*  210 */       if ((this.chameleonNamespace != null) ? !this.chameleonNamespace.equals(schemaToProcess.chameleonNamespace) : (schemaToProcess.chameleonNamespace != null)) return false; 
/*  211 */       if (this.schema != schemaToProcess.schema) return false;
/*      */       
/*  213 */       return true;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/*  219 */       int i = this.schema.hashCode();
/*  220 */       i = 29 * i + ((this.chameleonNamespace != null) ? this.chameleonNamespace.hashCode() : 0);
/*  221 */       return i;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String baseURLForDoc(XmlObject paramXmlObject) {
/*  229 */     String str = paramXmlObject.documentProperties().getSourceName();
/*      */     
/*  231 */     if (str == null) {
/*  232 */       return null;
/*      */     }
/*  234 */     if (str.startsWith("/")) {
/*  235 */       return "project://local" + str.replace('\\', '/');
/*      */     }
/*      */     
/*  238 */     int i = str.indexOf(':');
/*  239 */     if (i > 1 && str.substring(0, i).matches("^\\w+$")) {
/*  240 */       return str;
/*      */     }
/*  242 */     return "project://local/" + str.replace('\\', '/');
/*      */   }
/*      */ 
/*      */   
/*      */   private static URI parseURI(String paramString) {
/*  247 */     if (paramString == null) {
/*  248 */       return null;
/*      */     }
/*      */     
/*      */     try {
/*  252 */       return new URI(paramString);
/*      */     }
/*  254 */     catch (URISyntaxException uRISyntaxException) {
/*      */       
/*  256 */       return null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static URI resolve(URI paramURI, String paramString) throws URISyntaxException {
/*  264 */     URI uRI1 = new URI(paramString);
/*  265 */     URI uRI2 = paramURI.resolve(uRI1);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  272 */     if (uRI1.equals(uRI2) && !uRI1.isAbsolute() && (paramURI.getScheme().equals("jar") || paramURI.getScheme().equals("zip"))) {
/*      */       
/*  274 */       String str = paramURI.toString();
/*  275 */       int i = str.lastIndexOf('/');
/*  276 */       str = str.substring(0, i) + "/" + uRI1;
/*      */ 
/*      */ 
/*      */       
/*  280 */       int j = str.lastIndexOf("!/");
/*  281 */       if (j > 0) {
/*      */         
/*  283 */         int k = str.indexOf("/..", j);
/*  284 */         while (k > 0) {
/*      */           
/*  286 */           int m = str.lastIndexOf("/", k - 1);
/*  287 */           if (m >= j) {
/*      */             
/*  289 */             String str1 = str.substring(k + 3);
/*  290 */             str = str.substring(0, m).concat(str1);
/*      */           } 
/*  292 */           k = str.indexOf("/..", j);
/*      */         } 
/*      */       } 
/*  295 */       return URI.create(str);
/*      */     } 
/*      */ 
/*      */     
/*  299 */     if ("file".equals(uRI2.getScheme()) && !paramString.equals(uRI2))
/*      */     {
/*  301 */       if (paramURI.getPath().startsWith("//") && !uRI2.getPath().startsWith("//")) {
/*      */         
/*  303 */         String str = "///".concat(uRI2.getPath());
/*      */         
/*      */         try {
/*  306 */           uRI2 = new URI("file", null, str, uRI2.getQuery(), uRI2.getFragment());
/*      */         }
/*  308 */         catch (URISyntaxException uRISyntaxException) {}
/*      */       } 
/*      */     }
/*      */     
/*  312 */     return uRI2;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static class DownloadTable
/*      */   {
/*      */     private static class NsLocPair
/*      */     {
/*      */       private String namespaceURI;
/*      */ 
/*      */ 
/*      */       
/*      */       private String locationURL;
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public NsLocPair(String param2String1, String param2String2) {
/*  332 */         this.namespaceURI = param2String1;
/*  333 */         this.locationURL = param2String2;
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       public String getNamespaceURI() {
/*  341 */         return this.namespaceURI;
/*      */       }
/*      */ 
/*      */       
/*      */       public String getLocationURL() {
/*  346 */         return this.locationURL;
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(Object param2Object) {
/*  351 */         if (this == param2Object) return true; 
/*  352 */         if (!(param2Object instanceof NsLocPair)) return false;
/*      */         
/*  354 */         NsLocPair nsLocPair = (NsLocPair)param2Object;
/*      */         
/*  356 */         if ((this.locationURL != null) ? !this.locationURL.equals(nsLocPair.locationURL) : (nsLocPair.locationURL != null)) return false; 
/*  357 */         if ((this.namespaceURI != null) ? !this.namespaceURI.equals(nsLocPair.namespaceURI) : (nsLocPair.namespaceURI != null)) return false;
/*      */         
/*  359 */         return true;
/*      */       }
/*      */ 
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*  365 */         int i = (this.namespaceURI != null) ? this.namespaceURI.hashCode() : 0;
/*  366 */         i = 29 * i + ((this.locationURL != null) ? this.locationURL.hashCode() : 0);
/*  367 */         return i;
/*      */       }
/*      */     }
/*      */     
/*      */     private static class DigestKey
/*      */     {
/*      */       byte[] _digest;
/*      */       int _hashCode;
/*      */       
/*      */       DigestKey(byte[] param2ArrayOfbyte) {
/*  377 */         this._digest = param2ArrayOfbyte;
/*  378 */         for (byte b = 0; b < 4 && b < param2ArrayOfbyte.length; b++) {
/*      */           
/*  380 */           this._hashCode <<= 8;
/*  381 */           this._hashCode += param2ArrayOfbyte[b];
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*      */       public boolean equals(Object param2Object) {
/*  387 */         if (this == param2Object) return true; 
/*  388 */         if (!(param2Object instanceof DigestKey)) return false; 
/*  389 */         return Arrays.equals(this._digest, ((DigestKey)param2Object)._digest);
/*      */       }
/*      */ 
/*      */       
/*      */       public int hashCode() {
/*  394 */         return this._hashCode;
/*      */       }
/*      */     }
/*      */     
/*  398 */     private Map schemaByNsLocPair = new HashMap();
/*  399 */     private Map schemaByDigestKey = new HashMap();
/*  400 */     private LinkedList scanNeeded = new LinkedList();
/*  401 */     private Set emptyNamespaceSchemas = new HashSet();
/*  402 */     private Map scannedAlready = new HashMap();
/*  403 */     private Set failedDownloads = new HashSet();
/*      */ 
/*      */ 
/*      */     
/*      */     private SchemaDocument.Schema downloadSchema(XmlObject param1XmlObject, String param1String1, String param1String2) {
/*  408 */       if (param1String2 == null) {
/*  409 */         return null;
/*      */       }
/*  411 */       StscState stscState = StscState.get();
/*      */ 
/*      */       
/*  414 */       URI uRI = StscImporter.parseURI(StscImporter.baseURLForDoc(param1XmlObject));
/*  415 */       String str = null;
/*      */       
/*      */       try {
/*  418 */         str = (uRI == null) ? param1String2 : StscImporter.resolve(uRI, param1String2).toString();
/*      */       }
/*  420 */       catch (URISyntaxException uRISyntaxException) {
/*      */         
/*  422 */         stscState.error("Could not find resource - invalid location URL: " + uRISyntaxException.getMessage(), 56, param1XmlObject);
/*  423 */         return null;
/*      */       } 
/*      */ 
/*      */       
/*  427 */       if (stscState.isFileProcessed(str)) {
/*  428 */         return null;
/*      */       }
/*      */       
/*  431 */       if (str != null && param1String1 != null) {
/*      */         
/*  433 */         SchemaDocument.Schema schema = (SchemaDocument.Schema)this.schemaByNsLocPair.get(new NsLocPair(param1String1, str));
/*  434 */         if (schema != null) {
/*  435 */           return schema;
/*      */         }
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  447 */       if (param1String1 != null && !param1String1.equals("")) {
/*      */ 
/*      */         
/*  450 */         if (!stscState.shouldDownloadURI(str)) {
/*      */ 
/*      */ 
/*      */           
/*  454 */           SchemaDocument.Schema schema = (SchemaDocument.Schema)this.schemaByNsLocPair.get(new NsLocPair(param1String1, null));
/*  455 */           if (schema != null) {
/*  456 */             return schema;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  461 */         if (stscState.linkerDefinesNamespace(param1String1)) {
/*  462 */           return null;
/*      */         }
/*      */       } 
/*      */       
/*  466 */       if (str != null) {
/*      */         
/*  468 */         SchemaDocument.Schema schema = (SchemaDocument.Schema)this.schemaByNsLocPair.get(new NsLocPair(null, str));
/*  469 */         if (schema != null) {
/*  470 */           return schema;
/*      */         }
/*      */       } 
/*      */       
/*  474 */       if (str == null) {
/*      */         
/*  476 */         stscState.error("Could not find resource - no valid location URL.", 56, param1XmlObject);
/*  477 */         return null;
/*      */       } 
/*      */       
/*  480 */       if (previouslyFailedToDownload(str))
/*      */       {
/*      */         
/*  483 */         return null;
/*      */       }
/*      */       
/*  486 */       if (!stscState.shouldDownloadURI(str)) {
/*      */         
/*  488 */         stscState.error("Could not load resource \"" + str + "\" (network downloads disabled).", 56, param1XmlObject);
/*  489 */         addFailedDownload(str);
/*  490 */         return null;
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  496 */       try { XmlObject xmlObject = downloadDocument(stscState.getS4SLoader(), param1String1, str);
/*      */         
/*  498 */         SchemaDocument.Schema schema = findMatchByDigest(xmlObject);
/*  499 */         String str1 = stscState.relativize(str);
/*  500 */         if (schema != null)
/*      */         
/*      */         { 
/*  503 */           String str2 = stscState.relativize(schema.documentProperties().getSourceName());
/*  504 */           if (str2 != null) {
/*  505 */             stscState.info(str1 + " is the same as " + str2 + " (ignoring the duplicate file)");
/*      */           } else {
/*  507 */             stscState.info(str1 + " is the same as another schema");
/*      */           }
/*      */            }
/*      */         else
/*      */         
/*  512 */         { XmlOptions xmlOptions = new XmlOptions();
/*  513 */           xmlOptions.setErrorListener(stscState.getErrorListener());
/*  514 */           if (!(xmlObject instanceof SchemaDocument) || !xmlObject.validate(xmlOptions)) {
/*      */             
/*  516 */             stscState.error("Referenced document is not a valid schema", 56, param1XmlObject);
/*      */           }
/*      */           else {
/*      */             
/*  520 */             SchemaDocument schemaDocument = (SchemaDocument)xmlObject;
/*      */             
/*  522 */             schema = schemaDocument.getSchema();
/*  523 */             stscState.info("Loading referenced file " + str1);
/*      */             
/*  525 */             NsLocPair nsLocPair1 = new NsLocPair(emptyStringIfNull(schema.getTargetNamespace()), str);
/*  526 */             addSuccessfulDownload(nsLocPair1, schema);
/*  527 */             return schema;
/*      */           } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/*  543 */           addFailedDownload(str);
/*  544 */           return null; }  NsLocPair nsLocPair = new NsLocPair(emptyStringIfNull(schema.getTargetNamespace()), str); addSuccessfulDownload(nsLocPair, schema); return schema; } catch (MalformedURLException malformedURLException) { stscState.error("URL \"" + str + "\" is not well-formed", 56, param1XmlObject); } catch (IOException iOException) { stscState.error(iOException.toString(), 56, param1XmlObject); } catch (XmlException xmlException) { stscState.error("Problem parsing referenced XML resource - " + xmlException.getMessage(), 56, param1XmlObject); }  addFailedDownload(str); return null;
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     static XmlObject downloadDocument(SchemaTypeLoader param1SchemaTypeLoader, String param1String1, String param1String2) throws MalformedURLException, IOException, XmlException {
/*  550 */       StscState stscState = StscState.get();
/*      */       
/*  552 */       EntityResolver entityResolver = stscState.getEntityResolver();
/*  553 */       if (entityResolver != null) {
/*      */         
/*  555 */         InputSource inputSource = null;
/*      */         
/*      */         try {
/*  558 */           inputSource = entityResolver.resolveEntity(param1String1, param1String2);
/*      */         }
/*  560 */         catch (SAXException sAXException) {
/*      */           
/*  562 */           throw new XmlException(sAXException);
/*      */         } 
/*      */         
/*  565 */         if (inputSource != null) {
/*      */           
/*  567 */           stscState.addSourceUri(param1String2, null);
/*      */ 
/*      */           
/*  570 */           Reader reader = inputSource.getCharacterStream();
/*  571 */           if (reader != null) {
/*      */             
/*  573 */             reader = copySchemaSource(param1String2, reader, stscState);
/*  574 */             XmlOptions xmlOptions2 = new XmlOptions();
/*  575 */             xmlOptions2.setLoadLineNumbers();
/*  576 */             xmlOptions2.setDocumentSourceName(param1String2);
/*  577 */             return param1SchemaTypeLoader.parse(reader, null, xmlOptions2);
/*      */           } 
/*      */ 
/*      */           
/*  581 */           InputStream inputStream = inputSource.getByteStream();
/*  582 */           if (inputStream != null) {
/*      */             
/*  584 */             inputStream = copySchemaSource(param1String2, inputStream, stscState);
/*  585 */             String str1 = inputSource.getEncoding();
/*  586 */             XmlOptions xmlOptions2 = new XmlOptions();
/*  587 */             xmlOptions2.setLoadLineNumbers();
/*  588 */             xmlOptions2.setLoadMessageDigest();
/*  589 */             xmlOptions2.setDocumentSourceName(param1String2);
/*  590 */             if (str1 != null)
/*  591 */               xmlOptions2.setCharacterEncoding(str1); 
/*  592 */             return param1SchemaTypeLoader.parse(inputStream, null, xmlOptions2);
/*      */           } 
/*      */ 
/*      */           
/*  596 */           String str = inputSource.getSystemId();
/*  597 */           if (str == null) {
/*  598 */             throw new IOException("EntityResolver unable to resolve " + param1String2 + " (for namespace " + param1String1 + ")");
/*      */           }
/*  600 */           copySchemaSource(param1String2, stscState, false);
/*  601 */           XmlOptions xmlOptions1 = new XmlOptions();
/*  602 */           xmlOptions1.setLoadLineNumbers();
/*  603 */           xmlOptions1.setLoadMessageDigest();
/*  604 */           xmlOptions1.setDocumentSourceName(param1String2);
/*  605 */           URL uRL1 = new URL(str);
/*  606 */           return param1SchemaTypeLoader.parse(uRL1, null, xmlOptions1);
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/*  611 */       stscState.addSourceUri(param1String2, null);
/*  612 */       copySchemaSource(param1String2, stscState, false);
/*      */       
/*  614 */       XmlOptions xmlOptions = new XmlOptions();
/*  615 */       xmlOptions.setLoadLineNumbers();
/*  616 */       xmlOptions.setLoadMessageDigest();
/*  617 */       URL uRL = new URL(param1String2);
/*      */       
/*  619 */       return param1SchemaTypeLoader.parse(uRL, null, xmlOptions);
/*      */     }
/*      */ 
/*      */     
/*      */     private void addSuccessfulDownload(NsLocPair param1NsLocPair, SchemaDocument.Schema param1Schema) {
/*  624 */       byte[] arrayOfByte = param1Schema.documentProperties().getMessageDigest();
/*  625 */       if (arrayOfByte == null) {
/*      */         
/*  627 */         StscState.get().addSchemaDigest(null);
/*      */       }
/*      */       else {
/*      */         
/*  631 */         DigestKey digestKey = new DigestKey(arrayOfByte);
/*  632 */         if (!this.schemaByDigestKey.containsKey(digestKey)) {
/*      */           
/*  634 */           this.schemaByDigestKey.put(new DigestKey(arrayOfByte), param1Schema);
/*  635 */           StscState.get().addSchemaDigest(arrayOfByte);
/*      */         } 
/*      */       } 
/*      */       
/*  639 */       this.schemaByNsLocPair.put(param1NsLocPair, param1Schema);
/*  640 */       NsLocPair nsLocPair1 = new NsLocPair(param1NsLocPair.getNamespaceURI(), null);
/*  641 */       if (!this.schemaByNsLocPair.containsKey(nsLocPair1))
/*  642 */         this.schemaByNsLocPair.put(nsLocPair1, param1Schema); 
/*  643 */       NsLocPair nsLocPair2 = new NsLocPair(null, param1NsLocPair.getLocationURL());
/*  644 */       if (!this.schemaByNsLocPair.containsKey(nsLocPair2)) {
/*  645 */         this.schemaByNsLocPair.put(nsLocPair2, param1Schema);
/*      */       }
/*      */     }
/*      */     
/*      */     private SchemaDocument.Schema findMatchByDigest(XmlObject param1XmlObject) {
/*  650 */       byte[] arrayOfByte = param1XmlObject.documentProperties().getMessageDigest();
/*  651 */       if (arrayOfByte == null)
/*  652 */         return null; 
/*  653 */       return (SchemaDocument.Schema)this.schemaByDigestKey.get(new DigestKey(arrayOfByte));
/*      */     }
/*      */ 
/*      */     
/*      */     private void addFailedDownload(String param1String) {
/*  658 */       this.failedDownloads.add(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean previouslyFailedToDownload(String param1String) {
/*  663 */       return this.failedDownloads.contains(param1String);
/*      */     }
/*      */ 
/*      */     
/*      */     private static boolean nullableStringsMatch(String param1String1, String param1String2) {
/*  668 */       if (param1String1 == null && param1String2 == null)
/*  669 */         return true; 
/*  670 */       if (param1String1 == null || param1String2 == null)
/*  671 */         return false; 
/*  672 */       return param1String1.equals(param1String2);
/*      */     }
/*      */ 
/*      */     
/*      */     private static String emptyStringIfNull(String param1String) {
/*  677 */       if (param1String == null)
/*  678 */         return ""; 
/*  679 */       return param1String;
/*      */     }
/*      */ 
/*      */     
/*      */     private StscImporter.SchemaToProcess addScanNeeded(StscImporter.SchemaToProcess param1SchemaToProcess) {
/*  684 */       if (!this.scannedAlready.containsKey(param1SchemaToProcess)) {
/*      */         
/*  686 */         this.scannedAlready.put(param1SchemaToProcess, param1SchemaToProcess);
/*  687 */         this.scanNeeded.add(param1SchemaToProcess);
/*  688 */         return param1SchemaToProcess;
/*      */       } 
/*      */       
/*  691 */       return (StscImporter.SchemaToProcess)this.scannedAlready.get(param1SchemaToProcess);
/*      */     }
/*      */ 
/*      */     
/*      */     private void addEmptyNamespaceSchema(SchemaDocument.Schema param1Schema) {
/*  696 */       this.emptyNamespaceSchemas.add(param1Schema);
/*      */     }
/*      */ 
/*      */     
/*      */     private void usedEmptyNamespaceSchema(SchemaDocument.Schema param1Schema) {
/*  701 */       this.emptyNamespaceSchemas.remove(param1Schema);
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean fetchRemainingEmptyNamespaceSchemas() {
/*  706 */       if (this.emptyNamespaceSchemas.isEmpty()) {
/*  707 */         return false;
/*      */       }
/*  709 */       for (SchemaDocument.Schema schema : this.emptyNamespaceSchemas)
/*      */       {
/*      */         
/*  712 */         addScanNeeded(new StscImporter.SchemaToProcess(schema, null));
/*      */       }
/*      */       
/*  715 */       this.emptyNamespaceSchemas.clear();
/*  716 */       return true;
/*      */     }
/*      */ 
/*      */     
/*      */     private boolean hasNextToScan() {
/*  721 */       return !this.scanNeeded.isEmpty();
/*      */     }
/*      */ 
/*      */     
/*      */     private StscImporter.SchemaToProcess nextToScan() {
/*  726 */       return this.scanNeeded.removeFirst();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     public DownloadTable(SchemaDocument.Schema[] param1ArrayOfSchema) {
/*  732 */       for (byte b = 0; b < param1ArrayOfSchema.length; b++) {
/*      */         
/*  734 */         String str = param1ArrayOfSchema[b].getTargetNamespace();
/*  735 */         NsLocPair nsLocPair = new NsLocPair(str, StscImporter.baseURLForDoc((XmlObject)param1ArrayOfSchema[b]));
/*  736 */         addSuccessfulDownload(nsLocPair, param1ArrayOfSchema[b]);
/*  737 */         if (str != null) {
/*  738 */           addScanNeeded(new StscImporter.SchemaToProcess(param1ArrayOfSchema[b], null));
/*      */         } else {
/*  740 */           addEmptyNamespaceSchema(param1ArrayOfSchema[b]);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/*      */     public StscImporter.SchemaToProcess[] resolveImportsAndIncludes(boolean param1Boolean) {
/*  746 */       StscState stscState = StscState.get();
/*  747 */       ArrayList arrayList = new ArrayList();
/*  748 */       boolean bool = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       do {
/*  761 */         while (hasNextToScan()) {
/*      */           
/*  763 */           StscImporter.SchemaToProcess schemaToProcess = nextToScan();
/*  764 */           String str1 = schemaToProcess.getSourceName();
/*  765 */           stscState.addSourceUri(str1, null);
/*  766 */           arrayList.add(schemaToProcess);
/*  767 */           copySchemaSource(str1, stscState, param1Boolean);
/*      */ 
/*      */ 
/*      */           
/*  771 */           ImportDocument.Import[] arrayOfImport = schemaToProcess.getSchema().getImportArray();
/*  772 */           for (byte b1 = 0; b1 < arrayOfImport.length; b1++) {
/*      */             
/*  774 */             SchemaDocument.Schema schema = downloadSchema((XmlObject)arrayOfImport[b1], emptyStringIfNull(arrayOfImport[b1].getNamespace()), arrayOfImport[b1].getSchemaLocation());
/*      */ 
/*      */             
/*  777 */             if (schema != null)
/*      */             {
/*      */               
/*  780 */               if (!nullableStringsMatch(schema.getTargetNamespace(), arrayOfImport[b1].getNamespace())) {
/*      */                 
/*  782 */                 StscState.get().error("Imported schema has a target namespace \"" + schema.getTargetNamespace() + "\" that does not match the specified \"" + arrayOfImport[b1].getNamespace() + "\"", 4, (XmlObject)arrayOfImport[b1]);
/*      */               }
/*      */               else {
/*      */                 
/*  786 */                 addScanNeeded(new StscImporter.SchemaToProcess(schema, null));
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  793 */           IncludeDocument.Include[] arrayOfInclude = schemaToProcess.getSchema().getIncludeArray();
/*  794 */           String str2 = schemaToProcess.getChameleonNamespace();
/*  795 */           if (str2 == null)
/*  796 */             str2 = emptyStringIfNull(schemaToProcess.getSchema().getTargetNamespace()); 
/*      */           byte b2;
/*  798 */           for (b2 = 0; b2 < arrayOfInclude.length; b2++) {
/*      */             
/*  800 */             SchemaDocument.Schema schema = downloadSchema((XmlObject)arrayOfInclude[b2], null, arrayOfInclude[b2].getSchemaLocation());
/*      */             
/*  802 */             if (schema != null)
/*      */             {
/*      */               
/*  805 */               if (emptyStringIfNull(schema.getTargetNamespace()).equals(str2)) {
/*      */ 
/*      */                 
/*  808 */                 StscImporter.SchemaToProcess schemaToProcess1 = addScanNeeded(new StscImporter.SchemaToProcess(schema, null));
/*  809 */                 schemaToProcess.addInclude(schemaToProcess1);
/*      */               }
/*  811 */               else if (schema.getTargetNamespace() != null) {
/*      */ 
/*      */                 
/*  814 */                 StscState.get().error("Included schema has a target namespace \"" + schema.getTargetNamespace() + "\" that does not match the source namespace \"" + str2 + "\"", 4, (XmlObject)arrayOfInclude[b2]);
/*      */               
/*      */               }
/*      */               else {
/*      */                 
/*  819 */                 StscImporter.SchemaToProcess schemaToProcess1 = addScanNeeded(new StscImporter.SchemaToProcess(schema, str2));
/*  820 */                 schemaToProcess.addInclude(schemaToProcess1);
/*  821 */                 usedEmptyNamespaceSchema(schema);
/*      */               } 
/*      */             }
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/*  828 */           RedefineDocument.Redefine[] arrayOfRedefine = schemaToProcess.getSchema().getRedefineArray();
/*  829 */           str2 = schemaToProcess.getChameleonNamespace();
/*  830 */           if (str2 == null)
/*  831 */             str2 = emptyStringIfNull(schemaToProcess.getSchema().getTargetNamespace()); 
/*  832 */           for (b2 = 0; b2 < arrayOfRedefine.length; b2++) {
/*      */             
/*  834 */             SchemaDocument.Schema schema = downloadSchema((XmlObject)arrayOfRedefine[b2], null, arrayOfRedefine[b2].getSchemaLocation());
/*      */             
/*  836 */             if (schema != null)
/*      */             {
/*      */               
/*  839 */               if (emptyStringIfNull(schema.getTargetNamespace()).equals(str2))
/*      */               {
/*      */                 
/*  842 */                 StscImporter.SchemaToProcess schemaToProcess1 = addScanNeeded(new StscImporter.SchemaToProcess(schema, null));
/*  843 */                 schemaToProcess.addRedefine(schemaToProcess1, arrayOfRedefine[b2]);
/*  844 */                 bool = true;
/*      */               }
/*  846 */               else if (schema.getTargetNamespace() != null)
/*      */               {
/*      */                 
/*  849 */                 StscState.get().error("Redefined schema has a target namespace \"" + schema.getTargetNamespace() + "\" that does not match the source namespace \"" + str2 + "\"", 4, (XmlObject)arrayOfRedefine[b2]);
/*      */               
/*      */               }
/*      */               else
/*      */               {
/*  854 */                 StscImporter.SchemaToProcess schemaToProcess1 = addScanNeeded(new StscImporter.SchemaToProcess(schema, str2));
/*  855 */                 schemaToProcess.addRedefine(schemaToProcess1, arrayOfRedefine[b2]);
/*  856 */                 usedEmptyNamespaceSchema(schema);
/*  857 */                 bool = true;
/*      */               }
/*      */             
/*      */             }
/*      */           } 
/*      */         } 
/*  863 */       } while (fetchRemainingEmptyNamespaceSchemas());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  869 */       if (bool)
/*  870 */         for (byte b = 0; b < arrayList.size(); b++) {
/*      */           
/*  872 */           StscImporter.SchemaToProcess schemaToProcess = arrayList.get(b);
/*  873 */           schemaToProcess.buildIndirectReferences();
/*      */         }  
/*  875 */       return arrayList.<StscImporter.SchemaToProcess>toArray(new StscImporter.SchemaToProcess[arrayList.size()]);
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static Reader copySchemaSource(String param1String, Reader param1Reader, StscState param1StscState) {
/*  881 */       if (param1StscState.getSchemasDir() == null) {
/*  882 */         return param1Reader;
/*      */       }
/*  884 */       String str = param1StscState.sourceNameForUri(param1String);
/*  885 */       File file = new File(param1StscState.getSchemasDir(), str);
/*  886 */       if (file.exists()) {
/*  887 */         return param1Reader;
/*      */       }
/*      */       
/*      */       try {
/*  891 */         File file1 = new File(file.getParent());
/*  892 */         IOUtil.createDir(file1, null);
/*      */         
/*  894 */         CharArrayReader charArrayReader = copy(param1Reader);
/*  895 */         XmlEncodingSniffer xmlEncodingSniffer = new XmlEncodingSniffer(charArrayReader, null);
/*  896 */         OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), xmlEncodingSniffer.getXmlEncoding());
/*  897 */         IOUtil.copyCompletely(charArrayReader, outputStreamWriter);
/*      */         
/*  899 */         charArrayReader.reset();
/*  900 */         return charArrayReader;
/*      */       }
/*  902 */       catch (IOException iOException) {
/*      */         
/*  904 */         System.err.println("IO Error " + iOException);
/*  905 */         return param1Reader;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static InputStream copySchemaSource(String param1String, InputStream param1InputStream, StscState param1StscState) {
/*  912 */       if (param1StscState.getSchemasDir() == null) {
/*  913 */         return param1InputStream;
/*      */       }
/*  915 */       String str = param1StscState.sourceNameForUri(param1String);
/*  916 */       File file = new File(param1StscState.getSchemasDir(), str);
/*  917 */       if (file.exists()) {
/*  918 */         return param1InputStream;
/*      */       }
/*      */       
/*      */       try {
/*  922 */         File file1 = new File(file.getParent());
/*  923 */         IOUtil.createDir(file1, null);
/*      */         
/*  925 */         ByteArrayInputStream byteArrayInputStream = copy(param1InputStream);
/*      */         
/*  927 */         FileOutputStream fileOutputStream = new FileOutputStream(file);
/*  928 */         IOUtil.copyCompletely(byteArrayInputStream, fileOutputStream);
/*      */         
/*  930 */         byteArrayInputStream.reset();
/*  931 */         return byteArrayInputStream;
/*      */       }
/*  933 */       catch (IOException iOException) {
/*      */         
/*  935 */         System.err.println("IO Error " + iOException);
/*  936 */         return param1InputStream;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static void copySchemaSource(String param1String, StscState param1StscState, boolean param1Boolean) {
/*  943 */       if (param1StscState.getSchemasDir() != null) {
/*      */         
/*  945 */         String str = param1StscState.sourceNameForUri(param1String);
/*      */         
/*  947 */         File file = new File(param1StscState.getSchemasDir(), str);
/*  948 */         if (param1Boolean || !file.exists()) {
/*      */           
/*      */           try {
/*      */             
/*  952 */             File file1 = new File(file.getParent());
/*  953 */             IOUtil.createDir(file1, null);
/*      */             
/*  955 */             InputStream inputStream = null;
/*  956 */             URL uRL = new URL(param1String);
/*      */ 
/*      */             
/*      */             try {
/*  960 */               inputStream = uRL.openStream();
/*      */             }
/*  962 */             catch (FileNotFoundException fileNotFoundException) {
/*      */               
/*  964 */               if (param1Boolean && file.exists()) {
/*  965 */                 file.delete();
/*      */               } else {
/*  967 */                 throw fileNotFoundException;
/*      */               } 
/*  969 */             }  if (inputStream != null)
/*      */             {
/*  971 */               FileOutputStream fileOutputStream = new FileOutputStream(file);
/*  972 */               IOUtil.copyCompletely(inputStream, fileOutputStream);
/*      */             }
/*      */           
/*  975 */           } catch (IOException iOException) {
/*      */             
/*  977 */             System.err.println("IO Error " + iOException);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*      */     private static ByteArrayInputStream copy(InputStream param1InputStream) throws IOException {
/*  986 */       byte[] arrayOfByte = new byte[1024];
/*  987 */       ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
/*      */       
/*      */       int i;
/*  990 */       while ((i = param1InputStream.read(arrayOfByte, 0, 1024)) > 0) {
/*  991 */         byteArrayOutputStream.write(arrayOfByte, 0, i);
/*      */       }
/*  993 */       return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
/*      */     }
/*      */ 
/*      */     
/*      */     private static CharArrayReader copy(Reader param1Reader) throws IOException {
/*  998 */       char[] arrayOfChar = new char[1024];
/*  999 */       CharArrayWriter charArrayWriter = new CharArrayWriter();
/*      */       
/*      */       int i;
/* 1002 */       while ((i = param1Reader.read(arrayOfChar, 0, 1024)) > 0) {
/* 1003 */         charArrayWriter.write(arrayOfChar, 0, i);
/*      */       }
/* 1005 */       return new CharArrayReader(charArrayWriter.toCharArray());
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\schema\StscImporter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */