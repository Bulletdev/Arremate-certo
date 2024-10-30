/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
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
/*     */ public class InstanceValidator
/*     */ {
/*     */   public static void printUsage() {
/*  37 */     System.out.println("Validates the specified instance against the specified schema.");
/*  38 */     System.out.println("Contrast with the svalidate tool, which validates using a stream.");
/*  39 */     System.out.println("Usage: validate [-dl] [-nopvr] [-noupa] [-license] schema.xsd instance.xml");
/*  40 */     System.out.println("Options:");
/*  41 */     System.out.println("    -dl - permit network downloads for imports and includes (default is off)");
/*  42 */     System.out.println("    -noupa - do not enforce the unique particle attribution rule");
/*  43 */     System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
/*  44 */     System.out.println("    -strict - performs strict(er) validation");
/*  45 */     System.out.println("    -partial - allow partial schema type system");
/*  46 */     System.out.println("    -license - prints license information");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*  51 */     System.exit(extraMain(paramArrayOfString));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static int extraMain(String[] paramArrayOfString) {
/*     */     SchemaTypeSystem schemaTypeSystem;
/*     */     SchemaTypeLoader schemaTypeLoader1;
/*  61 */     HashSet hashSet = new HashSet();
/*  62 */     hashSet.add("h");
/*  63 */     hashSet.add("help");
/*  64 */     hashSet.add("usage");
/*  65 */     hashSet.add("license");
/*  66 */     hashSet.add("version");
/*  67 */     hashSet.add("dl");
/*  68 */     hashSet.add("noupa");
/*  69 */     hashSet.add("nopvr");
/*  70 */     hashSet.add("strict");
/*  71 */     hashSet.add("partial");
/*     */     
/*  73 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Collections.EMPTY_SET);
/*     */     
/*  75 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || paramArrayOfString.length < 1) {
/*     */       
/*  77 */       printUsage();
/*  78 */       return 0;
/*     */     } 
/*     */     
/*  81 */     String[] arrayOfString = commandLine.getBadOpts();
/*  82 */     if (arrayOfString.length > 0) {
/*     */       
/*  84 */       for (byte b = 0; b < arrayOfString.length; b++)
/*  85 */         System.out.println("Unrecognized option: " + arrayOfString[b]); 
/*  86 */       printUsage();
/*  87 */       return 0;
/*     */     } 
/*     */     
/*  90 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  92 */       CommandLine.printLicense();
/*  93 */       return 0;
/*     */     } 
/*     */     
/*  96 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  98 */       CommandLine.printVersion();
/*  99 */       return 0;
/*     */     } 
/*     */     
/* 102 */     if ((commandLine.args()).length == 0)
/*     */     {
/* 104 */       return 0;
/*     */     }
/*     */     
/* 107 */     boolean bool1 = (commandLine.getOpt("dl") != null) ? true : false;
/* 108 */     boolean bool2 = (commandLine.getOpt("nopvr") != null) ? true : false;
/* 109 */     boolean bool3 = (commandLine.getOpt("noupa") != null) ? true : false;
/* 110 */     boolean bool4 = (commandLine.getOpt("strict") != null) ? true : false;
/* 111 */     boolean bool5 = (commandLine.getOpt("partial") != null) ? true : false;
/*     */     
/* 113 */     File[] arrayOfFile1 = commandLine.filesEndingWith(".xsd");
/* 114 */     File[] arrayOfFile2 = commandLine.filesEndingWith(".xml");
/* 115 */     File[] arrayOfFile3 = commandLine.filesEndingWith(".jar");
/*     */     
/* 117 */     ArrayList arrayList = new ArrayList();
/*     */ 
/*     */     
/* 120 */     for (byte b1 = 0; b1 < arrayOfFile1.length; b1++) {
/*     */ 
/*     */       
/*     */       try {
/* 124 */         arrayList.add(XmlObject.Factory.parse(arrayOfFile1[b1], (new XmlOptions()).setLoadLineNumbers().setLoadMessageDigest()));
/*     */ 
/*     */       
/*     */       }
/* 128 */       catch (Exception exception) {
/*     */         
/* 130 */         System.err.println(arrayOfFile1[b1] + " not loadable: " + exception);
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     XmlObject[] arrayOfXmlObject = arrayList.<XmlObject>toArray(new XmlObject[0]);
/*     */     
/* 136 */     SchemaTypeLoader schemaTypeLoader2 = null;
/* 137 */     ArrayList arrayList1 = new ArrayList();
/* 138 */     XmlOptions xmlOptions = new XmlOptions();
/* 139 */     xmlOptions.setErrorListener(arrayList1);
/* 140 */     if (bool1)
/* 141 */       xmlOptions.setCompileDownloadUrls(); 
/* 142 */     if (bool2)
/* 143 */       xmlOptions.setCompileNoPvrRule(); 
/* 144 */     if (bool3)
/* 145 */       xmlOptions.setCompileNoUpaRule(); 
/* 146 */     if (bool5) {
/* 147 */       xmlOptions.put("COMPILE_PARTIAL_TYPESYSTEM");
/*     */     }
/* 149 */     if (arrayOfFile3 != null && arrayOfFile3.length > 0) {
/* 150 */       schemaTypeLoader2 = XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(arrayOfFile3));
/*     */     }
/* 152 */     byte b2 = 0;
/*     */ 
/*     */     
/*     */     try {
/* 156 */       if (arrayOfXmlObject != null && arrayOfXmlObject.length > 0) {
/* 157 */         schemaTypeSystem = XmlBeans.compileXsd(arrayOfXmlObject, schemaTypeLoader2, xmlOptions);
/*     */       }
/* 159 */     } catch (Exception exception) {
/*     */       
/* 161 */       if (arrayList1.isEmpty() || !(exception instanceof org.apache.xmlbeans.XmlException))
/*     */       {
/* 163 */         exception.printStackTrace(System.err);
/*     */       }
/* 165 */       System.out.println("Schema invalid:" + (bool5 ? " couldn't recover from errors" : ""));
/* 166 */       for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 167 */         System.out.println(iterator.next());
/*     */       }
/* 169 */       b2 = 10;
/* 170 */       return b2;
/*     */     } 
/*     */ 
/*     */     
/* 174 */     if (bool5 && !arrayList1.isEmpty()) {
/*     */       
/* 176 */       b2 = 11;
/* 177 */       System.out.println("Schema invalid: partial schema type system recovered");
/* 178 */       for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 179 */         System.out.println(iterator.next());
/*     */       }
/*     */     } 
/* 182 */     if (schemaTypeSystem == null) {
/* 183 */       schemaTypeLoader1 = XmlBeans.getContextTypeLoader();
/*     */     }
/* 185 */     for (byte b3 = 0; b3 < arrayOfFile2.length; b3++) {
/*     */       XmlObject xmlObject;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 191 */         xmlObject = schemaTypeLoader1.parse(arrayOfFile2[b3], null, (new XmlOptions()).setLoadLineNumbers("LOAD_LINE_NUMBERS_END_ELEMENT"));
/*     */       
/*     */       }
/* 194 */       catch (Exception exception) {
/*     */         
/* 196 */         System.err.println(arrayOfFile2[b3] + " not loadable: " + exception);
/* 197 */         exception.printStackTrace(System.err);
/*     */       } 
/*     */ 
/*     */       
/* 201 */       ArrayList arrayList2 = new ArrayList();
/*     */       
/* 203 */       if (xmlObject.schemaType() == XmlObject.type) {
/*     */         
/* 205 */         System.out.println(arrayOfFile2[b3] + " NOT valid.  ");
/* 206 */         System.out.println("  Document type not found.");
/*     */       }
/* 208 */       else if (xmlObject.validate(bool4 ? (new XmlOptions()).setErrorListener(arrayList2).setValidateStrict() : (new XmlOptions()).setErrorListener(arrayList2))) {
/*     */ 
/*     */         
/* 211 */         System.out.println(arrayOfFile2[b3] + " valid.");
/*     */       } else {
/*     */         
/* 214 */         b2 = 1;
/* 215 */         System.out.println(arrayOfFile2[b3] + " NOT valid.");
/* 216 */         for (Iterator iterator = arrayList2.iterator(); iterator.hasNext();)
/*     */         {
/* 218 */           System.out.println(iterator.next());
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 223 */     return b2;
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\InstanceValidator.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */