/*     */ package org.apache.xmlbeans.impl.inst2xsd;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.Reader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.inst2xsd.util.TypeSystemHolder;
/*     */ import org.apache.xmlbeans.impl.tool.CommandLine;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Inst2Xsd
/*     */ {
/*     */   public static void main(String[] paramArrayOfString) {
/*  49 */     if (paramArrayOfString == null || paramArrayOfString.length == 0) {
/*     */       
/*  51 */       printHelp();
/*  52 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  56 */     HashSet hashSet1 = new HashSet();
/*  57 */     hashSet1.add("h");
/*  58 */     hashSet1.add("help");
/*  59 */     hashSet1.add("usage");
/*  60 */     hashSet1.add("license");
/*  61 */     hashSet1.add("version");
/*  62 */     hashSet1.add("verbose");
/*  63 */     hashSet1.add("validate");
/*     */     
/*  65 */     HashSet hashSet2 = new HashSet();
/*  66 */     hashSet2.add("design");
/*  67 */     hashSet2.add("simple-content-types");
/*  68 */     hashSet2.add("enumerations");
/*  69 */     hashSet2.add("outDir");
/*  70 */     hashSet2.add("outPrefix");
/*     */     
/*  72 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet1, hashSet2);
/*  73 */     Inst2XsdOptions inst2XsdOptions = new Inst2XsdOptions();
/*     */     
/*  75 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  77 */       CommandLine.printLicense();
/*  78 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  82 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  84 */       CommandLine.printVersion();
/*  85 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  89 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/*  91 */       printHelp();
/*  92 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  96 */     String[] arrayOfString = commandLine.getBadOpts();
/*  97 */     if (arrayOfString.length > 0) {
/*     */       
/*  99 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++)
/* 100 */         System.out.println("Unrecognized option: " + arrayOfString[b1]); 
/* 101 */       printHelp();
/* 102 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 106 */     String str1 = commandLine.getOpt("design");
/* 107 */     if (str1 != null)
/*     */     {
/*     */ 
/*     */       
/* 111 */       if (str1.equals("vb")) {
/*     */         
/* 113 */         inst2XsdOptions.setDesign(3);
/*     */       }
/* 115 */       else if (str1.equals("rd")) {
/*     */         
/* 117 */         inst2XsdOptions.setDesign(1);
/*     */       }
/* 119 */       else if (str1.equals("ss")) {
/*     */         
/* 121 */         inst2XsdOptions.setDesign(2);
/*     */       }
/*     */       else {
/*     */         
/* 125 */         printHelp();
/* 126 */         System.exit(0);
/*     */         return;
/*     */       } 
/*     */     }
/* 130 */     String str2 = commandLine.getOpt("simple-content-types");
/* 131 */     if (str2 != null)
/*     */     {
/*     */ 
/*     */       
/* 135 */       if (str2.equals("smart")) {
/*     */         
/* 137 */         inst2XsdOptions.setSimpleContentTypes(1);
/*     */       }
/* 139 */       else if (str2.equals("string")) {
/*     */         
/* 141 */         inst2XsdOptions.setSimpleContentTypes(2);
/*     */       }
/*     */       else {
/*     */         
/* 145 */         printHelp();
/* 146 */         System.exit(0);
/*     */         return;
/*     */       } 
/*     */     }
/* 150 */     String str3 = commandLine.getOpt("enumerations");
/* 151 */     if (str3 != null)
/*     */     {
/*     */ 
/*     */       
/* 155 */       if (str3.equals("never")) {
/*     */         
/* 157 */         inst2XsdOptions.setUseEnumerations(1);
/*     */       } else {
/*     */ 
/*     */         
/*     */         try {
/*     */           
/* 163 */           int i = Integer.parseInt(str3);
/* 164 */           inst2XsdOptions.setUseEnumerations(i);
/*     */         }
/* 166 */         catch (NumberFormatException numberFormatException) {
/*     */           
/* 168 */           printHelp();
/* 169 */           System.exit(0);
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }
/* 174 */     File file = new File((commandLine.getOpt("outDir") == null) ? "." : commandLine.getOpt("outDir"));
/*     */     
/* 176 */     String str4 = commandLine.getOpt("outPrefix");
/* 177 */     if (str4 == null) {
/* 178 */       str4 = "schema";
/*     */     }
/* 180 */     inst2XsdOptions.setVerbose((commandLine.getOpt("verbose") != null));
/* 181 */     boolean bool = (commandLine.getOpt("validate") != null) ? true : false;
/*     */     
/* 183 */     File[] arrayOfFile = commandLine.filesEndingWith(".xml");
/* 184 */     XmlObject[] arrayOfXmlObject = new XmlObject[arrayOfFile.length];
/*     */     
/* 186 */     if (arrayOfXmlObject.length == 0) {
/*     */       
/* 188 */       printHelp();
/* 189 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 193 */     byte b = 0;
/*     */     
/*     */     try {
/* 196 */       for (b = 0; b < arrayOfFile.length; b++)
/*     */       {
/* 198 */         arrayOfXmlObject[b] = XmlObject.Factory.parse(arrayOfFile[b]);
/*     */       }
/*     */     }
/* 201 */     catch (XmlException xmlException) {
/*     */       
/* 203 */       System.err.println("Invalid xml file: '" + arrayOfFile[b].getName() + "'. " + xmlException.getMessage());
/*     */       
/*     */       return;
/* 206 */     } catch (IOException iOException) {
/*     */       
/* 208 */       System.err.println("Could not read file: '" + arrayOfFile[b].getName() + "'. " + iOException.getMessage());
/*     */       
/*     */       return;
/*     */     } 
/* 212 */     SchemaDocument[] arrayOfSchemaDocument = inst2xsd(arrayOfXmlObject, inst2XsdOptions);
/*     */ 
/*     */     
/*     */     try {
/* 216 */       for (b = 0; b < arrayOfSchemaDocument.length; b++)
/*     */       {
/* 218 */         SchemaDocument schemaDocument = arrayOfSchemaDocument[b];
/*     */         
/* 220 */         if (inst2XsdOptions.isVerbose()) {
/* 221 */           System.out.println("----------------------\n\n" + schemaDocument);
/*     */         }
/* 223 */         schemaDocument.save(new File(file, str4 + b + ".xsd"), (new XmlOptions()).setSavePrettyPrint());
/*     */       }
/*     */     
/* 226 */     } catch (IOException iOException) {
/*     */       
/* 228 */       System.err.println("Could not write file: '" + file + File.pathSeparator + str4 + b + ".xsd" + "'. " + iOException.getMessage());
/*     */       
/*     */       return;
/*     */     } 
/* 232 */     if (bool)
/*     */     {
/* 234 */       validateInstances(arrayOfSchemaDocument, arrayOfXmlObject);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private static void printHelp() {
/* 240 */     System.out.println("Generates XMLSchema from instance xml documents.");
/* 241 */     System.out.println("Usage: inst2xsd [opts] [instance.xml]*");
/* 242 */     System.out.println("Options include:");
/* 243 */     System.out.println("    -design [rd|ss|vb] - XMLSchema design type");
/* 244 */     System.out.println("             rd  - Russian Doll Design - local elements and local types");
/* 245 */     System.out.println("             ss  - Salami Slice Design - global elements and local types");
/* 246 */     System.out.println("             vb  - Venetian Blind Design (default) - local elements and global complex types");
/* 247 */     System.out.println("    -simple-content-types [smart|string] - Simple content types detection (leaf text). Smart is the default");
/* 248 */     System.out.println("    -enumerations [never|NUMBER] - Use enumerations. Default value is 10.");
/* 249 */     System.out.println("    -outDir [dir] - Directory for output files. Default is '.'");
/* 250 */     System.out.println("    -outPrefix [file_name_prefix] - Prefix for output file names. Default is 'schema'");
/* 251 */     System.out.println("    -validate - Validates input instances agaist generated schemas.");
/* 252 */     System.out.println("    -verbose - print more informational messages");
/* 253 */     System.out.println("    -license - print license information");
/* 254 */     System.out.println("    -help - help imformation");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static SchemaDocument[] inst2xsd(Reader[] paramArrayOfReader, Inst2XsdOptions paramInst2XsdOptions) throws IOException, XmlException {
/* 264 */     XmlObject[] arrayOfXmlObject = new XmlObject[paramArrayOfReader.length];
/* 265 */     for (byte b = 0; b < paramArrayOfReader.length; b++)
/*     */     {
/* 267 */       arrayOfXmlObject[b] = XmlObject.Factory.parse(paramArrayOfReader[b]);
/*     */     }
/* 269 */     return inst2xsd(arrayOfXmlObject, paramInst2XsdOptions);
/*     */   }
/*     */   
/*     */   public static SchemaDocument[] inst2xsd(XmlObject[] paramArrayOfXmlObject, Inst2XsdOptions paramInst2XsdOptions) {
/*     */     RussianDollStrategy russianDollStrategy;
/* 274 */     if (paramInst2XsdOptions == null) {
/* 275 */       paramInst2XsdOptions = new Inst2XsdOptions();
/*     */     }
/*     */     
/* 278 */     TypeSystemHolder typeSystemHolder = new TypeSystemHolder();
/*     */ 
/*     */     
/* 281 */     switch (paramInst2XsdOptions.getDesign()) {
/*     */       
/*     */       case 1:
/* 284 */         russianDollStrategy = new RussianDollStrategy();
/*     */         break;
/*     */       
/*     */       case 2:
/* 288 */         russianDollStrategy = new SalamiSliceStrategy();
/*     */         break;
/*     */       
/*     */       case 3:
/* 292 */         russianDollStrategy = new VenetianBlindStrategy();
/*     */         break;
/*     */       
/*     */       default:
/* 296 */         throw new IllegalArgumentException("Unknown design.");
/*     */     } 
/*     */     
/* 299 */     russianDollStrategy.processDoc(paramArrayOfXmlObject, paramInst2XsdOptions, typeSystemHolder);
/*     */     
/* 301 */     if (paramInst2XsdOptions.isVerbose()) {
/* 302 */       System.out.println("typeSystemHolder.toString(): " + typeSystemHolder);
/*     */     }
/* 304 */     return typeSystemHolder.getSchemaDocuments();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static boolean validateInstances(SchemaDocument[] paramArrayOfSchemaDocument, XmlObject[] paramArrayOfXmlObject) {
/*     */     SchemaTypeLoader schemaTypeLoader;
/* 312 */     ArrayList arrayList = new ArrayList();
/* 313 */     XmlOptions xmlOptions = new XmlOptions();
/* 314 */     xmlOptions.setErrorListener(arrayList);
/*     */     
/*     */     try {
/* 317 */       schemaTypeLoader = XmlBeans.loadXsd((XmlObject[])paramArrayOfSchemaDocument, xmlOptions);
/*     */     }
/* 319 */     catch (Exception exception) {
/*     */       
/* 321 */       if (arrayList.isEmpty() || !(exception instanceof XmlException))
/*     */       {
/* 323 */         exception.printStackTrace(System.out);
/*     */       }
/* 325 */       System.out.println("\n-------------------\n\nInvalid schemas.");
/* 326 */       for (XmlError xmlError : arrayList)
/*     */       {
/*     */         
/* 329 */         System.out.println(xmlError.getLine() + ":" + xmlError.getColumn() + " " + xmlError.getMessage());
/*     */       }
/* 331 */       return false;
/*     */     } 
/*     */     
/* 334 */     System.out.println("\n-------------------");
/* 335 */     boolean bool = true;
/*     */     
/* 337 */     for (byte b = 0; b < paramArrayOfXmlObject.length; b++) {
/*     */       XmlObject xmlObject;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 343 */         xmlObject = schemaTypeLoader.parse(paramArrayOfXmlObject[b].newXMLStreamReader(), null, (new XmlOptions()).setLoadLineNumbers());
/*     */       }
/* 345 */       catch (XmlException xmlException) {
/*     */         
/* 347 */         System.out.println("Error:\n" + paramArrayOfXmlObject[b].documentProperties().getSourceName() + " not loadable: " + xmlException);
/* 348 */         xmlException.printStackTrace(System.out);
/* 349 */         bool = false;
/*     */       } 
/*     */ 
/*     */       
/* 353 */       ArrayList arrayList1 = new ArrayList();
/*     */       
/* 355 */       if (xmlObject.schemaType() == XmlObject.type) {
/*     */         
/* 357 */         System.out.println(paramArrayOfXmlObject[b].documentProperties().getSourceName() + " NOT valid.  ");
/* 358 */         System.out.println("  Document type not found.");
/* 359 */         bool = false;
/*     */       }
/* 361 */       else if (xmlObject.validate((new XmlOptions()).setErrorListener(arrayList1))) {
/* 362 */         System.out.println("Instance[" + b + "] valid - " + paramArrayOfXmlObject[b].documentProperties().getSourceName());
/*     */       } else {
/*     */         
/* 365 */         System.out.println("Instance[" + b + "] NOT valid - " + paramArrayOfXmlObject[b].documentProperties().getSourceName());
/* 366 */         for (XmlError xmlError : arrayList1)
/*     */         {
/*     */           
/* 369 */           System.out.println(xmlError.getLine() + ":" + xmlError.getColumn() + " " + xmlError.getMessage());
/*     */         }
/* 371 */         bool = false;
/*     */       } 
/*     */     } 
/*     */     
/* 375 */     return bool;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\inst2xsd\Inst2Xsd.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */