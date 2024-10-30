/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.net.URL;
/*     */ import java.util.Collections;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.LinkedList;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.XmlCursor;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.IOUtil;
/*     */ import org.apache.xmlbeans.impl.xb.substwsdl.DefinitionsDocument;
/*     */ import org.apache.xmlbeans.impl.xb.substwsdl.TImport;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.ImportDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
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
/*     */ public class SchemaCopy
/*     */ {
/*     */   public static void printUsage() {
/*  43 */     System.out.println("Copies the XML schema at the specified URL to the specified file.");
/*  44 */     System.out.println("Usage: scopy sourceurl [targetfile]");
/*  45 */     System.out.println("    sourceurl - The URL at which the schema is located.");
/*  46 */     System.out.println("    targetfile - The file to which the schema should be copied.");
/*  47 */     System.out.println();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  53 */     if (paramArrayOfString.length < 1 || paramArrayOfString.length > 2) {
/*     */       
/*  55 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/*  59 */     URI uRI1 = null;
/*  60 */     URI uRI2 = null;
/*     */ 
/*     */     
/*     */     try {
/*  64 */       if (paramArrayOfString[0].compareToIgnoreCase("-usage") == 0) {
/*  65 */         printUsage();
/*     */         
/*     */         return;
/*     */       } 
/*  69 */       uRI1 = new URI(paramArrayOfString[0]);
/*  70 */       uRI1.toURL();
/*     */     }
/*  72 */     catch (Exception exception) {
/*     */       
/*  74 */       System.err.println("Badly formed URL " + uRI1);
/*     */       
/*     */       return;
/*     */     } 
/*  78 */     if (paramArrayOfString.length < 2) {
/*     */ 
/*     */       
/*     */       try {
/*  82 */         URI uRI = (new File(".")).getCanonicalFile().toURI();
/*  83 */         String str = uRI1.getPath();
/*  84 */         str = str.substring(str.lastIndexOf('/') + 1);
/*  85 */         uRI2 = CodeGenUtil.resolve(uRI, URI.create(str));
/*     */       }
/*  87 */       catch (Exception exception) {
/*     */         
/*  89 */         System.err.println("Cannot canonicalize current directory");
/*     */ 
/*     */ 
/*     */         
/*     */         return;
/*     */       } 
/*     */     } else {
/*     */       try {
/*  97 */         uRI2 = new URI(paramArrayOfString[1]);
/*  98 */         if (!uRI2.isAbsolute()) {
/*  99 */           uRI2 = null;
/* 100 */         } else if (!uRI2.getScheme().equals("file")) {
/* 101 */           uRI2 = null;
/*     */         } 
/* 103 */       } catch (Exception exception) {
/*     */         
/* 105 */         uRI2 = null;
/*     */       } 
/*     */       
/* 108 */       if (uRI2 == null) {
/*     */         
/*     */         try {
/*     */           
/* 112 */           uRI2 = (new File(uRI2)).getCanonicalFile().toURI();
/*     */         }
/* 114 */         catch (Exception exception) {
/*     */           
/* 116 */           System.err.println("Cannot canonicalize current directory");
/*     */           
/*     */           return;
/*     */         } 
/*     */       }
/*     */     } 
/* 122 */     Map map = findAllRelative(uRI1, uRI2);
/* 123 */     copyAll(map, true);
/*     */   }
/*     */ 
/*     */   
/*     */   private static void copyAll(Map paramMap, boolean paramBoolean) {
/* 128 */     for (URI uRI1 : paramMap.keySet()) {
/*     */ 
/*     */       
/* 131 */       URI uRI2 = (URI)paramMap.get(uRI1);
/*     */       
/*     */       try {
/* 134 */         IOUtil.copyCompletely(uRI1, uRI2);
/*     */       }
/* 136 */       catch (Exception exception) {
/*     */         
/* 138 */         if (paramBoolean)
/* 139 */           System.out.println("Could not copy " + uRI1 + " -> " + uRI2); 
/*     */         continue;
/*     */       } 
/* 142 */       if (paramBoolean) {
/* 143 */         System.out.println("Copied " + uRI1 + " -> " + uRI2);
/*     */       }
/*     */     } 
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
/*     */   public static Map findAllRelative(URI paramURI1, URI paramURI2) {
/* 161 */     LinkedHashMap linkedHashMap = new LinkedHashMap();
/* 162 */     linkedHashMap.put(paramURI1, paramURI2);
/*     */     
/* 164 */     LinkedList linkedList = new LinkedList();
/* 165 */     linkedList.add(paramURI1);
/*     */     
/* 167 */     while (!linkedList.isEmpty()) {
/*     */       
/* 169 */       URI uRI1 = linkedList.removeFirst();
/* 170 */       URI uRI2 = (URI)linkedHashMap.get(uRI1);
/* 171 */       Map map = findRelativeInOne(uRI1, uRI2);
/* 172 */       for (URI uRI : map.keySet()) {
/*     */ 
/*     */         
/* 175 */         if (linkedHashMap.containsKey(uRI))
/*     */           continue; 
/* 177 */         linkedHashMap.put(uRI, map.get(uRI));
/* 178 */         linkedList.add(uRI);
/*     */       } 
/*     */     } 
/*     */     
/* 182 */     return linkedHashMap;
/*     */   }
/*     */   
/* 185 */   private static final XmlOptions loadOptions = (new XmlOptions()).setLoadSubstituteNamespaces(Collections.singletonMap("http://schemas.xmlsoap.org/wsdl/", "http://www.apache.org/internal/xmlbeans/wsdlsubst"));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Map findRelativeInOne(URI paramURI1, URI paramURI2) {
/*     */     try {
/* 194 */       URL uRL = paramURI1.toURL();
/* 195 */       XmlObject xmlObject = XmlObject.Factory.parse(uRL, loadOptions);
/* 196 */       XmlCursor xmlCursor = xmlObject.newCursor();
/* 197 */       xmlCursor.toFirstChild();
/*     */       
/* 199 */       LinkedHashMap linkedHashMap = new LinkedHashMap();
/*     */       
/* 201 */       if (xmlObject instanceof SchemaDocument) {
/* 202 */         putMappingsFromSchema(linkedHashMap, paramURI1, paramURI2, ((SchemaDocument)xmlObject).getSchema());
/* 203 */       } else if (xmlObject instanceof DefinitionsDocument) {
/* 204 */         putMappingsFromWsdl(linkedHashMap, paramURI1, paramURI2, ((DefinitionsDocument)xmlObject).getDefinitions());
/* 205 */       }  return linkedHashMap;
/*     */     }
/* 207 */     catch (Exception exception) {
/*     */ 
/*     */ 
/*     */       
/* 211 */       return Collections.EMPTY_MAP;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void putNewMapping(Map paramMap, URI paramURI1, URI paramURI2, String paramString) {
/*     */     try {
/* 218 */       if (paramString == null)
/*     */         return; 
/* 220 */       URI uRI1 = new URI(paramString);
/* 221 */       if (uRI1.isAbsolute())
/*     */         return; 
/* 223 */       URI uRI2 = CodeGenUtil.resolve(paramURI1, uRI1);
/* 224 */       URI uRI3 = CodeGenUtil.resolve(paramURI2, uRI1);
/* 225 */       paramMap.put(uRI2, uRI3);
/*     */     }
/* 227 */     catch (URISyntaxException uRISyntaxException) {}
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void putMappingsFromSchema(Map paramMap, URI paramURI1, URI paramURI2, SchemaDocument.Schema paramSchema) {
/* 235 */     ImportDocument.Import[] arrayOfImport = paramSchema.getImportArray();
/* 236 */     for (byte b1 = 0; b1 < arrayOfImport.length; b1++) {
/* 237 */       putNewMapping(paramMap, paramURI1, paramURI2, arrayOfImport[b1].getSchemaLocation());
/*     */     }
/* 239 */     IncludeDocument.Include[] arrayOfInclude = paramSchema.getIncludeArray();
/* 240 */     for (byte b2 = 0; b2 < arrayOfInclude.length; b2++) {
/* 241 */       putNewMapping(paramMap, paramURI1, paramURI2, arrayOfInclude[b2].getSchemaLocation());
/*     */     }
/*     */   }
/*     */   
/*     */   private static void putMappingsFromWsdl(Map paramMap, URI paramURI1, URI paramURI2, DefinitionsDocument.Definitions paramDefinitions) {
/* 246 */     XmlObject[] arrayOfXmlObject = paramDefinitions.getTypesArray();
/* 247 */     for (byte b1 = 0; b1 < arrayOfXmlObject.length; b1++) {
/*     */       
/* 249 */       SchemaDocument.Schema[] arrayOfSchema = (SchemaDocument.Schema[])arrayOfXmlObject[b1].selectPath("declare namespace xs='http://www.w3.org/2001/XMLSchema' xs:schema");
/* 250 */       for (byte b = 0; b < arrayOfSchema.length; b++) {
/* 251 */         putMappingsFromSchema(paramMap, paramURI1, paramURI2, arrayOfSchema[b]);
/*     */       }
/*     */     } 
/* 254 */     TImport[] arrayOfTImport = paramDefinitions.getImportArray();
/* 255 */     for (byte b2 = 0; b2 < arrayOfTImport.length; b2++)
/* 256 */       putNewMapping(paramMap, paramURI1, paramURI2, arrayOfTImport[b2].getLocation()); 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\SchemaCopy.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */