/*     */ package org.apache.xmlbeans.impl.xsd2inst;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.tool.CommandLine;
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
/*     */ public class SchemaInstanceGenerator
/*     */ {
/*     */   public static class Xsd2InstOptions
/*     */   {
/*     */     private boolean _downloads = false;
/*     */     private boolean _nopvr = false;
/*     */     private boolean _noupa = false;
/*     */     
/*     */     public boolean isNetworkDownloads() {
/*  52 */       return this._downloads;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNetworkDownloads(boolean param1Boolean) {
/*  60 */       this._downloads = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNopvr() {
/*  69 */       return this._nopvr;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNopvr(boolean param1Boolean) {
/*  77 */       this._nopvr = param1Boolean;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean isNoupa() {
/*  86 */       return this._noupa;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void setNoupa(boolean param1Boolean) {
/*  94 */       this._noupa = param1Boolean;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void printUsage() {
/* 101 */     System.out.println("Generates a document based on the given Schema file");
/* 102 */     System.out.println("having the given element as root.");
/* 103 */     System.out.println("The tool makes reasonable attempts to create a valid document,");
/* 104 */     System.out.println("but this is not always possible since, for example, ");
/* 105 */     System.out.println("there are schemas for which no valid instance document ");
/* 106 */     System.out.println("can be produced.");
/* 107 */     System.out.println("Usage: xsd2inst [flags] schema.xsd -name element_name");
/* 108 */     System.out.println("Flags:");
/* 109 */     System.out.println("    -name    the name of the root element");
/* 110 */     System.out.println("    -dl      enable network downloads for imports and includes");
/* 111 */     System.out.println("    -nopvr   disable particle valid (restriction) rule");
/* 112 */     System.out.println("    -noupa   disable unique particle attribution rule");
/* 113 */     System.out.println("    -license prints license information");
/* 114 */     System.out.println("    -version prints version information");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/* 119 */     HashSet hashSet1 = new HashSet();
/* 120 */     HashSet hashSet2 = new HashSet();
/* 121 */     hashSet1.add("h");
/* 122 */     hashSet1.add("help");
/* 123 */     hashSet1.add("usage");
/* 124 */     hashSet1.add("license");
/* 125 */     hashSet1.add("version");
/* 126 */     hashSet1.add("dl");
/* 127 */     hashSet1.add("noupa");
/* 128 */     hashSet1.add("nopvr");
/* 129 */     hashSet1.add("partial");
/* 130 */     hashSet2.add("name");
/*     */     
/* 132 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet1, hashSet2);
/*     */     
/* 134 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/* 136 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/* 140 */     String[] arrayOfString = commandLine.getBadOpts();
/* 141 */     if (arrayOfString.length > 0) {
/*     */       
/* 143 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++)
/* 144 */         System.out.println("Unrecognized option: " + arrayOfString[b1]); 
/* 145 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/* 149 */     if (commandLine.getOpt("license") != null) {
/*     */       
/* 151 */       CommandLine.printLicense();
/* 152 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 156 */     if (commandLine.getOpt("version") != null) {
/*     */       
/* 158 */       CommandLine.printVersion();
/* 159 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 163 */     boolean bool1 = (commandLine.getOpt("dl") != null) ? true : false;
/* 164 */     boolean bool2 = (commandLine.getOpt("nopvr") != null) ? true : false;
/* 165 */     boolean bool3 = (commandLine.getOpt("noupa") != null) ? true : false;
/*     */     
/* 167 */     File[] arrayOfFile = commandLine.filesEndingWith(".xsd");
/* 168 */     String str1 = commandLine.getOpt("name");
/*     */     
/* 170 */     if (str1 == null) {
/*     */       
/* 172 */       System.out.println("Required option \"-name\" must be present");
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 177 */     ArrayList arrayList = new ArrayList();
/* 178 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/*     */ 
/*     */       
/*     */       try {
/* 182 */         arrayList.add(XmlObject.Factory.parse(arrayOfFile[b], (new XmlOptions()).setLoadLineNumbers().setLoadMessageDigest()));
/*     */       
/*     */       }
/* 185 */       catch (Exception exception) {
/*     */         
/* 187 */         System.err.println("Can not load schema file: " + arrayOfFile[b] + ": ");
/* 188 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     XmlObject[] arrayOfXmlObject = arrayList.<XmlObject>toArray(new XmlObject[arrayList.size()]);
/*     */     
/* 194 */     Xsd2InstOptions xsd2InstOptions = new Xsd2InstOptions();
/* 195 */     xsd2InstOptions.setNetworkDownloads(bool1);
/* 196 */     xsd2InstOptions.setNopvr(bool2);
/* 197 */     xsd2InstOptions.setNoupa(bool3);
/*     */     
/* 199 */     String str2 = xsd2inst(arrayOfXmlObject, str1, xsd2InstOptions);
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
/* 254 */     System.out.println(str2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String xsd2inst(String[] paramArrayOfString, String paramString, Xsd2InstOptions paramXsd2InstOptions) throws XmlException, IOException {
/* 263 */     Reader[] arrayOfReader = new Reader[paramArrayOfString.length];
/* 264 */     for (byte b = 0; b < paramArrayOfString.length; b++)
/*     */     {
/* 266 */       arrayOfReader[b] = new StringReader(paramArrayOfString[b]);
/*     */     }
/*     */     
/* 269 */     return xsd2inst(arrayOfReader, paramString, paramXsd2InstOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String xsd2inst(Reader[] paramArrayOfReader, String paramString, Xsd2InstOptions paramXsd2InstOptions) {
/* 278 */     ArrayList arrayList = new ArrayList();
/* 279 */     for (byte b = 0; b < paramArrayOfReader.length; b++) {
/*     */ 
/*     */       
/*     */       try {
/* 283 */         arrayList.add(XmlObject.Factory.parse(paramArrayOfReader[b], (new XmlOptions()).setLoadLineNumbers().setLoadMessageDigest()));
/*     */       
/*     */       }
/* 286 */       catch (Exception exception) {
/*     */         
/* 288 */         System.err.println("Can not load schema reader: " + b + "  " + paramArrayOfReader[b] + ": ");
/* 289 */         exception.printStackTrace();
/*     */       } 
/*     */     } 
/*     */     
/* 293 */     XmlObject[] arrayOfXmlObject = arrayList.<XmlObject>toArray(new XmlObject[arrayList.size()]);
/*     */     
/* 295 */     return xsd2inst(arrayOfXmlObject, paramString, paramXsd2InstOptions);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String xsd2inst(XmlObject[] paramArrayOfXmlObject, String paramString, Xsd2InstOptions paramXsd2InstOptions) {
/* 301 */     SchemaTypeSystem schemaTypeSystem = null;
/* 302 */     if (paramArrayOfXmlObject.length > 0) {
/*     */       
/* 304 */       ArrayList arrayList = new ArrayList();
/* 305 */       XmlOptions xmlOptions = new XmlOptions();
/* 306 */       if (paramXsd2InstOptions.isNetworkDownloads())
/* 307 */         xmlOptions.setCompileDownloadUrls(); 
/* 308 */       if (paramXsd2InstOptions.isNopvr())
/* 309 */         xmlOptions.setCompileNoPvrRule(); 
/* 310 */       if (paramXsd2InstOptions.isNoupa()) {
/* 311 */         xmlOptions.setCompileNoUpaRule();
/*     */       }
/*     */       
/*     */       try {
/* 315 */         schemaTypeSystem = XmlBeans.compileXsd(paramArrayOfXmlObject, (SchemaTypeLoader)XmlBeans.getBuiltinTypeSystem(), xmlOptions);
/*     */       }
/* 317 */       catch (Exception exception) {
/*     */         
/* 319 */         if (arrayList.isEmpty() || !(exception instanceof XmlException)) {
/* 320 */           exception.printStackTrace();
/*     */         }
/* 322 */         System.out.println("Schema compilation errors: ");
/* 323 */         for (Iterator iterator = arrayList.iterator(); iterator.hasNext();) {
/* 324 */           System.out.println(iterator.next());
/*     */         }
/*     */       } 
/*     */     } 
/* 328 */     if (schemaTypeSystem == null)
/*     */     {
/* 330 */       throw new RuntimeException("No Schemas to process.");
/*     */     }
/* 332 */     SchemaType[] arrayOfSchemaType = schemaTypeSystem.documentTypes();
/* 333 */     SchemaType schemaType = null;
/* 334 */     for (byte b = 0; b < arrayOfSchemaType.length; b++) {
/*     */       
/* 336 */       if (paramString.equals(arrayOfSchemaType[b].getDocumentElementName().dT())) {
/*     */         
/* 338 */         schemaType = arrayOfSchemaType[b];
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 343 */     if (schemaType == null)
/*     */     {
/* 345 */       throw new RuntimeException("Could not find a global element with name \"" + paramString + "\"");
/*     */     }
/*     */ 
/*     */     
/* 349 */     return SampleXmlUtil.createSampleForType(schemaType);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\xsd2inst\SchemaInstanceGenerator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */