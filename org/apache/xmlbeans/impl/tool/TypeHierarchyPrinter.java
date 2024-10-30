/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import org.apache.xmlbeans.SchemaType;
/*     */ import org.apache.xmlbeans.SchemaTypeLoader;
/*     */ import org.apache.xmlbeans.SchemaTypeSystem;
/*     */ import org.apache.xmlbeans.XmlBeans;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.common.QNameHelper;
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
/*     */ public class TypeHierarchyPrinter
/*     */ {
/*     */   public static void printUsage() {
/*  45 */     System.out.println("Prints the inheritance hierarchy of types defined in a schema.\n");
/*  46 */     System.out.println("Usage: xsdtree [-noanon] [-nopvr] [-noupa] [-partial] [-license] schemafile.xsd*");
/*  47 */     System.out.println("    -noanon - Don't include anonymous types in the tree.");
/*  48 */     System.out.println("    -noupa - do not enforce the unique particle attribution rule");
/*  49 */     System.out.println("    -nopvr - do not enforce the particle valid (restriction) rule");
/*  50 */     System.out.println("    -partial - Print only part of the hierarchy.");
/*  51 */     System.out.println("    -license - prints license information");
/*  52 */     System.out.println("    schemafile.xsd - File containing the schema for which to print a tree.");
/*  53 */     System.out.println();
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*     */     SchemaTypeSystem schemaTypeSystem;
/*  58 */     HashSet hashSet = new HashSet();
/*  59 */     hashSet.add("h");
/*  60 */     hashSet.add("help");
/*  61 */     hashSet.add("usage");
/*  62 */     hashSet.add("license");
/*  63 */     hashSet.add("version");
/*  64 */     hashSet.add("noanon");
/*  65 */     hashSet.add("noupr");
/*  66 */     hashSet.add("noupa");
/*  67 */     hashSet.add("partial");
/*     */     
/*  69 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Collections.EMPTY_SET);
/*  70 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/*  72 */       printUsage();
/*  73 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  77 */     String[] arrayOfString = commandLine.getBadOpts();
/*  78 */     if (arrayOfString.length > 0) {
/*     */       
/*  80 */       for (byte b = 0; b < arrayOfString.length; b++)
/*  81 */         System.out.println("Unrecognized option: " + arrayOfString[b]); 
/*  82 */       printUsage();
/*  83 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  87 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  89 */       CommandLine.printLicense();
/*  90 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  94 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  96 */       CommandLine.printVersion();
/*  97 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 101 */     if ((commandLine.args()).length == 0) {
/*     */       
/* 103 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/* 107 */     boolean bool1 = (commandLine.getOpt("noanon") != null) ? true : false;
/* 108 */     boolean bool2 = (commandLine.getOpt("nopvr") != null) ? true : false;
/* 109 */     boolean bool3 = (commandLine.getOpt("noupa") != null) ? true : false;
/* 110 */     boolean bool4 = (commandLine.getOpt("partial") != null) ? true : false;
/*     */     
/* 112 */     File[] arrayOfFile1 = commandLine.filesEndingWith(".xsd");
/* 113 */     File[] arrayOfFile2 = commandLine.filesEndingWith(".jar");
/*     */ 
/*     */     
/* 116 */     ArrayList arrayList = new ArrayList();
/* 117 */     for (byte b1 = 0; b1 < arrayOfFile1.length; b1++) {
/*     */ 
/*     */       
/*     */       try {
/* 121 */         arrayList.add(SchemaDocument.Factory.parse(arrayOfFile1[b1], (new XmlOptions()).setLoadLineNumbers()));
/*     */ 
/*     */       
/*     */       }
/* 125 */       catch (Exception exception) {
/*     */         
/* 127 */         System.err.println(arrayOfFile1[b1] + " not loadable: " + exception);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 132 */     XmlObject[] arrayOfXmlObject = arrayList.<XmlObject>toArray(new XmlObject[0]);
/*     */ 
/*     */     
/* 135 */     SchemaTypeLoader schemaTypeLoader = null;
/*     */     
/* 137 */     ArrayList arrayList1 = new ArrayList();
/* 138 */     XmlOptions xmlOptions = new XmlOptions();
/* 139 */     xmlOptions.setErrorListener(arrayList1);
/* 140 */     xmlOptions.setCompileDownloadUrls();
/* 141 */     if (bool2)
/* 142 */       xmlOptions.setCompileNoPvrRule(); 
/* 143 */     if (bool3)
/* 144 */       xmlOptions.setCompileNoUpaRule(); 
/* 145 */     if (bool4) {
/* 146 */       xmlOptions.put("COMPILE_PARTIAL_TYPESYSTEM");
/*     */     }
/* 148 */     if (arrayOfFile2 != null && arrayOfFile2.length > 0) {
/* 149 */       schemaTypeLoader = XmlBeans.typeLoaderForResource(XmlBeans.resourceLoaderForPath(arrayOfFile2));
/*     */     }
/*     */     
/*     */     try {
/* 153 */       schemaTypeSystem = XmlBeans.compileXsd(arrayOfXmlObject, schemaTypeLoader, xmlOptions);
/*     */     }
/* 155 */     catch (XmlException xmlException) {
/*     */       
/* 157 */       System.out.println("Schema invalid:" + (bool4 ? " couldn't recover from errors" : ""));
/* 158 */       if (arrayList1.isEmpty())
/* 159 */       { System.out.println(xmlException.getMessage()); }
/* 160 */       else { for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 161 */           System.out.println(iterator.next());
/*     */         } }
/*     */       
/*     */       return;
/*     */     } 
/* 166 */     if (bool4 && !arrayList1.isEmpty()) {
/*     */       
/* 168 */       System.out.println("Schema invalid: partial schema type system recovered");
/* 169 */       for (Iterator iterator = arrayList1.iterator(); iterator.hasNext();) {
/* 170 */         System.out.println(iterator.next());
/*     */       }
/*     */     } 
/*     */     
/* 174 */     HashMap hashMap1 = new HashMap();
/* 175 */     hashMap1.put("http://www.w3.org/XML/1998/namespace", "xml");
/* 176 */     hashMap1.put("http://www.w3.org/2001/XMLSchema", "xs");
/* 177 */     System.out.println("xmlns:xs=\"http://www.w3.org/2001/XMLSchema\"");
/*     */ 
/*     */     
/* 180 */     HashMap hashMap2 = new HashMap();
/*     */ 
/*     */     
/* 183 */     ArrayList arrayList2 = new ArrayList();
/* 184 */     arrayList2.addAll(Arrays.asList(schemaTypeSystem.documentTypes()));
/* 185 */     arrayList2.addAll(Arrays.asList(schemaTypeSystem.attributeTypes()));
/* 186 */     arrayList2.addAll(Arrays.asList(schemaTypeSystem.globalTypes()));
/*     */     
/* 188 */     for (byte b2 = 0; b2 < arrayList2.size(); b2++) {
/*     */       
/* 190 */       SchemaType schemaType = arrayList2.get(b2);
/*     */ 
/*     */       
/* 193 */       if (!bool1) {
/* 194 */         arrayList2.addAll(Arrays.asList(schemaType.getAnonymousTypes()));
/*     */       }
/*     */       
/* 197 */       if (!schemaType.isDocumentType() && !schemaType.isAttributeType() && schemaType != XmlObject.type) {
/*     */ 
/*     */ 
/*     */         
/* 201 */         noteNamespace(hashMap1, schemaType);
/*     */ 
/*     */         
/* 204 */         Collection collection = (Collection)hashMap2.get(schemaType.getBaseType());
/* 205 */         if (collection == null) {
/*     */           
/* 207 */           collection = new ArrayList();
/* 208 */           hashMap2.put(schemaType.getBaseType(), collection);
/*     */ 
/*     */           
/* 211 */           if (schemaType.getBaseType().isBuiltinType())
/* 212 */             arrayList2.add(schemaType.getBaseType()); 
/*     */         } 
/* 214 */         collection.add(schemaType);
/*     */       } 
/*     */     } 
/*     */     
/* 218 */     ArrayList arrayList3 = new ArrayList();
/* 219 */     arrayList3.add(XmlObject.type);
/* 220 */     StringBuffer stringBuffer = new StringBuffer();
/* 221 */     while (!arrayList3.isEmpty()) {
/*     */       
/* 223 */       SchemaType schemaType = arrayList3.remove(arrayList3.size() - 1);
/* 224 */       if (schemaType == null) {
/* 225 */         stringBuffer.setLength(Math.max(0, stringBuffer.length() - 2));
/*     */         continue;
/*     */       } 
/* 228 */       System.out.println(stringBuffer + "+-" + QNameHelper.readable(schemaType, hashMap1) + notes(schemaType));
/* 229 */       Collection collection = (Collection)hashMap2.get(schemaType);
/* 230 */       if (collection != null && collection.size() > 0) {
/*     */         
/* 232 */         stringBuffer.append((arrayList3.size() == 0 || arrayList3.get(arrayList3.size() - 1) == null) ? "  " : "| ");
/* 233 */         arrayList3.add(null);
/* 234 */         arrayList3.addAll(collection);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String notes(SchemaType paramSchemaType) {
/* 242 */     if (paramSchemaType.isBuiltinType()) {
/* 243 */       return " (builtin)";
/*     */     }
/* 245 */     if (paramSchemaType.isSimpleType()) {
/*     */       
/* 247 */       switch (paramSchemaType.getSimpleVariety()) {
/*     */         
/*     */         case 3:
/* 250 */           return " (list)";
/*     */         case 2:
/* 252 */           return " (union)";
/*     */       } 
/* 254 */       if (paramSchemaType.getEnumerationValues() != null)
/* 255 */         return " (enumeration)"; 
/* 256 */       return "";
/*     */     } 
/*     */ 
/*     */     
/* 260 */     switch (paramSchemaType.getContentType()) {
/*     */       
/*     */       case 4:
/* 263 */         return " (mixed)";
/*     */       case 2:
/* 265 */         return " (complex)";
/*     */     } 
/* 267 */     return "";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void noteNamespace(Map paramMap, SchemaType paramSchemaType) {
/* 273 */     String str1 = QNameHelper.namespace(paramSchemaType);
/* 274 */     if (str1.equals("") || paramMap.containsKey(str1)) {
/*     */       return;
/*     */     }
/* 277 */     String str2 = QNameHelper.suggestPrefix(str1);
/* 278 */     String str3 = str2;
/* 279 */     for (byte b = 0; paramMap.containsValue(str3); b++)
/*     */     {
/* 281 */       str3 = str2 + b;
/*     */     }
/*     */     
/* 284 */     paramMap.put(str1, str3);
/* 285 */     System.out.println("xmlns:" + str3 + "=\"" + str1 + "\"");
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\TypeHierarchyPrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */