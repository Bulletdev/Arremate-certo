/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.net.URI;
/*     */ import java.net.URISyntaxException;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashMap;
/*     */ import java.util.HashSet;
/*     */ import java.util.Set;
/*     */ import javax.xml.namespace.b;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.FormChoice;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.IncludeDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedAttributeGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.NamedGroup;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.SchemaDocument;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelAttribute;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelComplexType;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelElement;
/*     */ import org.apache.xmlbeans.impl.xb.xsdschema.TopLevelSimpleType;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FactorImports
/*     */ {
/*     */   public static void printUsage() {
/*  54 */     System.out.println("Refactors a directory of XSD files to remove name conflicts.");
/*  55 */     System.out.println("Usage: sfactor [-import common.xsd] [-out outputdir] inputdir");
/*  56 */     System.out.println("    -import common.xsd - The XSD file to contain redundant ");
/*  57 */     System.out.println("                         definitions for importing.");
/*  58 */     System.out.println("    -out outputdir - The directory into which to place XSD ");
/*  59 */     System.out.println("                     files resulting from refactoring, ");
/*  60 */     System.out.println("                     plus a commonly imported common.xsd.");
/*  61 */     System.out.println("    inputdir - The directory containing the XSD files with");
/*  62 */     System.out.println("               redundant definitions.");
/*  63 */     System.out.println("    -license - Print license information.");
/*  64 */     System.out.println();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  70 */     HashSet hashSet = new HashSet();
/*  71 */     hashSet.add("h");
/*  72 */     hashSet.add("help");
/*  73 */     hashSet.add("usage");
/*  74 */     hashSet.add("license");
/*  75 */     hashSet.add("version");
/*     */     
/*  77 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Arrays.asList(new String[] { "import", "out" }));
/*  78 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null || paramArrayOfString.length < 1) {
/*     */       
/*  80 */       printUsage();
/*  81 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  85 */     String[] arrayOfString = commandLine.getBadOpts();
/*  86 */     if (arrayOfString.length > 0) {
/*     */       
/*  88 */       for (byte b = 0; b < arrayOfString.length; b++)
/*  89 */         System.out.println("Unrecognized option: " + arrayOfString[b]); 
/*  90 */       printUsage();
/*  91 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  95 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  97 */       CommandLine.printLicense();
/*  98 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 102 */     if (commandLine.getOpt("version") != null) {
/*     */       
/* 104 */       CommandLine.printVersion();
/* 105 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 109 */     paramArrayOfString = commandLine.args();
/* 110 */     if (paramArrayOfString.length != 1) {
/*     */       
/* 112 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 116 */     String str1 = commandLine.getOpt("import");
/* 117 */     if (str1 == null) {
/* 118 */       str1 = "common.xsd";
/*     */     }
/* 120 */     String str2 = commandLine.getOpt("out");
/* 121 */     if (str2 == null) {
/*     */       
/* 123 */       System.out.println("Using output directory 'out'");
/* 124 */       str2 = "out";
/*     */     } 
/* 126 */     File file1 = new File(str2);
/* 127 */     File file2 = new File(paramArrayOfString[0]);
/*     */ 
/*     */     
/* 130 */     File[] arrayOfFile = commandLine.getFiles();
/* 131 */     HashMap hashMap1 = new HashMap();
/* 132 */     HashSet hashSet1 = new HashSet();
/* 133 */     HashSet hashSet2 = new HashSet();
/* 134 */     HashSet hashSet3 = new HashSet();
/* 135 */     HashSet hashSet4 = new HashSet();
/* 136 */     HashSet hashSet5 = new HashSet();
/*     */     
/* 138 */     HashSet hashSet6 = new HashSet();
/* 139 */     HashSet hashSet7 = new HashSet();
/* 140 */     HashSet hashSet8 = new HashSet();
/* 141 */     HashSet hashSet9 = new HashSet();
/* 142 */     HashSet hashSet10 = new HashSet();
/* 143 */     HashSet hashSet11 = new HashSet();
/*     */     
/* 145 */     for (byte b1 = 0; b1 < arrayOfFile.length; b1++) {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 150 */         SchemaDocument schemaDocument = SchemaDocument.Factory.parse(arrayOfFile[b1]);
/* 151 */         hashMap1.put(schemaDocument, arrayOfFile[b1]);
/*     */ 
/*     */         
/* 154 */         if (schemaDocument.getSchema().sizeOfImportArray() > 0 || schemaDocument.getSchema().sizeOfIncludeArray() > 0) {
/* 155 */           System.out.println("warning: " + arrayOfFile[b1] + " contains imports or includes that are being ignored.");
/*     */         }
/*     */         
/* 158 */         String str = schemaDocument.getSchema().getTargetNamespace();
/* 159 */         if (str == null) {
/* 160 */           str = "";
/*     */         }
/* 162 */         TopLevelComplexType[] arrayOfTopLevelComplexType = schemaDocument.getSchema().getComplexTypeArray();
/* 163 */         for (byte b3 = 0; b3 < arrayOfTopLevelComplexType.length; b3++) {
/* 164 */           noteName(arrayOfTopLevelComplexType[b3].getName(), str, hashSet3, hashSet8, hashSet11);
/*     */         }
/* 166 */         TopLevelSimpleType[] arrayOfTopLevelSimpleType = schemaDocument.getSchema().getSimpleTypeArray();
/* 167 */         for (byte b4 = 0; b4 < arrayOfTopLevelSimpleType.length; b4++) {
/* 168 */           noteName(arrayOfTopLevelSimpleType[b4].getName(), str, hashSet3, hashSet8, hashSet11);
/*     */         }
/* 170 */         TopLevelElement[] arrayOfTopLevelElement = schemaDocument.getSchema().getElementArray();
/* 171 */         for (byte b5 = 0; b5 < arrayOfTopLevelElement.length; b5++) {
/* 172 */           noteName(arrayOfTopLevelElement[b5].getName(), str, hashSet1, hashSet6, hashSet11);
/*     */         }
/* 174 */         TopLevelAttribute[] arrayOfTopLevelAttribute = schemaDocument.getSchema().getAttributeArray();
/* 175 */         for (byte b6 = 0; b6 < arrayOfTopLevelAttribute.length; b6++) {
/* 176 */           noteName(arrayOfTopLevelAttribute[b6].getName(), str, hashSet2, hashSet7, hashSet11);
/*     */         }
/* 178 */         NamedGroup[] arrayOfNamedGroup = schemaDocument.getSchema().getGroupArray();
/* 179 */         for (byte b7 = 0; b7 < arrayOfNamedGroup.length; b7++) {
/* 180 */           noteName(arrayOfNamedGroup[b7].getName(), str, hashSet4, hashSet9, hashSet11);
/*     */         }
/* 182 */         NamedAttributeGroup[] arrayOfNamedAttributeGroup = schemaDocument.getSchema().getAttributeGroupArray();
/* 183 */         for (byte b8 = 0; b8 < arrayOfNamedAttributeGroup.length; b8++) {
/* 184 */           noteName(arrayOfNamedAttributeGroup[b8].getName(), str, hashSet5, hashSet10, hashSet11);
/*     */         }
/*     */       }
/* 187 */       catch (XmlException xmlException) {
/*     */         
/* 189 */         System.out.println("warning: " + arrayOfFile[b1] + " is not a schema file - " + xmlException.getError().toString());
/*     */       }
/* 191 */       catch (IOException iOException) {
/*     */         
/* 193 */         System.err.println("Unable to load " + arrayOfFile[b1] + " - " + iOException.getMessage());
/* 194 */         System.exit(1);
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 199 */     if (hashMap1.size() == 0) {
/*     */       
/* 201 */       System.out.println("No schema files found.");
/* 202 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 206 */     if (hashSet8.size() + hashSet6.size() + hashSet7.size() + hashSet9.size() + hashSet10.size() == 0) {
/*     */ 
/*     */       
/* 209 */       System.out.println("No duplicate names found.");
/* 210 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 215 */     HashMap hashMap2 = new HashMap();
/* 216 */     HashMap hashMap3 = new HashMap();
/* 217 */     byte b2 = (hashSet11.size() == 1) ? 0 : 1;
/* 218 */     for (String str : hashSet11) {
/*     */ 
/*     */       
/* 221 */       SchemaDocument schemaDocument = SchemaDocument.Factory.parse("<xs:schema xmlns:xs='http://www.w3.org/2001/XMLSchema'/>");
/*     */ 
/*     */       
/* 224 */       if (str.length() > 0)
/* 225 */         schemaDocument.getSchema().setTargetNamespace(str); 
/* 226 */       schemaDocument.getSchema().setElementFormDefault(FormChoice.QUALIFIED);
/* 227 */       hashMap2.put(str, schemaDocument);
/* 228 */       hashMap3.put(schemaDocument, commonFileFor(str1, str, b2++, file1));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 234 */     for (SchemaDocument schemaDocument1 : hashMap1.keySet()) {
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 239 */       String str = schemaDocument1.getSchema().getTargetNamespace();
/* 240 */       if (str == null) {
/* 241 */         str = "";
/*     */       }
/* 243 */       SchemaDocument schemaDocument2 = (SchemaDocument)hashMap2.get(str);
/*     */       
/* 245 */       boolean bool = false;
/*     */       
/* 247 */       TopLevelComplexType[] arrayOfTopLevelComplexType = schemaDocument1.getSchema().getComplexTypeArray();
/* 248 */       for (int i = arrayOfTopLevelComplexType.length - 1; i >= 0; i--) {
/*     */         
/* 250 */         if (isDuplicate(arrayOfTopLevelComplexType[i].getName(), str, hashSet8)) {
/*     */           
/* 252 */           if (isFirstDuplicate(arrayOfTopLevelComplexType[i].getName(), str, hashSet3, hashSet8))
/* 253 */             schemaDocument2.getSchema().addNewComplexType().set((XmlObject)arrayOfTopLevelComplexType[i]); 
/* 254 */           bool = true;
/* 255 */           schemaDocument1.getSchema().removeComplexType(i);
/*     */         } 
/*     */       } 
/* 258 */       TopLevelSimpleType[] arrayOfTopLevelSimpleType = schemaDocument1.getSchema().getSimpleTypeArray();
/* 259 */       for (byte b3 = 0; b3 < arrayOfTopLevelSimpleType.length; b3++) {
/*     */         
/* 261 */         if (isDuplicate(arrayOfTopLevelSimpleType[b3].getName(), str, hashSet8)) {
/*     */           
/* 263 */           if (isFirstDuplicate(arrayOfTopLevelSimpleType[b3].getName(), str, hashSet3, hashSet8))
/* 264 */             schemaDocument2.getSchema().addNewSimpleType().set((XmlObject)arrayOfTopLevelSimpleType[b3]); 
/* 265 */           bool = true;
/* 266 */           schemaDocument1.getSchema().removeSimpleType(b3);
/*     */         } 
/*     */       } 
/* 269 */       TopLevelElement[] arrayOfTopLevelElement = schemaDocument1.getSchema().getElementArray();
/* 270 */       for (byte b4 = 0; b4 < arrayOfTopLevelElement.length; b4++) {
/*     */         
/* 272 */         if (isDuplicate(arrayOfTopLevelElement[b4].getName(), str, hashSet6)) {
/*     */           
/* 274 */           if (isFirstDuplicate(arrayOfTopLevelElement[b4].getName(), str, hashSet1, hashSet6))
/* 275 */             schemaDocument2.getSchema().addNewElement().set((XmlObject)arrayOfTopLevelElement[b4]); 
/* 276 */           bool = true;
/* 277 */           schemaDocument1.getSchema().removeElement(b4);
/*     */         } 
/*     */       } 
/* 280 */       TopLevelAttribute[] arrayOfTopLevelAttribute = schemaDocument1.getSchema().getAttributeArray();
/* 281 */       for (byte b5 = 0; b5 < arrayOfTopLevelAttribute.length; b5++) {
/*     */         
/* 283 */         if (isDuplicate(arrayOfTopLevelAttribute[b5].getName(), str, hashSet7)) {
/*     */           
/* 285 */           if (isFirstDuplicate(arrayOfTopLevelAttribute[b5].getName(), str, hashSet2, hashSet7))
/* 286 */             schemaDocument2.getSchema().addNewElement().set((XmlObject)arrayOfTopLevelAttribute[b5]); 
/* 287 */           bool = true;
/* 288 */           schemaDocument1.getSchema().removeElement(b5);
/*     */         } 
/*     */       } 
/* 291 */       NamedGroup[] arrayOfNamedGroup = schemaDocument1.getSchema().getGroupArray();
/* 292 */       for (byte b6 = 0; b6 < arrayOfNamedGroup.length; b6++) {
/*     */         
/* 294 */         if (isDuplicate(arrayOfNamedGroup[b6].getName(), str, hashSet9)) {
/*     */           
/* 296 */           if (isFirstDuplicate(arrayOfNamedGroup[b6].getName(), str, hashSet4, hashSet9))
/* 297 */             schemaDocument2.getSchema().addNewElement().set((XmlObject)arrayOfNamedGroup[b6]); 
/* 298 */           bool = true;
/* 299 */           schemaDocument1.getSchema().removeElement(b6);
/*     */         } 
/*     */       } 
/* 302 */       NamedAttributeGroup[] arrayOfNamedAttributeGroup = schemaDocument1.getSchema().getAttributeGroupArray();
/* 303 */       for (byte b7 = 0; b7 < arrayOfNamedAttributeGroup.length; b7++) {
/*     */         
/* 305 */         if (isDuplicate(arrayOfNamedAttributeGroup[b7].getName(), str, hashSet10)) {
/*     */           
/* 307 */           if (isFirstDuplicate(arrayOfNamedAttributeGroup[b7].getName(), str, hashSet5, hashSet10))
/* 308 */             schemaDocument2.getSchema().addNewElement().set((XmlObject)arrayOfNamedAttributeGroup[b7]); 
/* 309 */           bool = true;
/* 310 */           schemaDocument1.getSchema().removeElement(b7);
/*     */         } 
/*     */       } 
/* 313 */       if (bool) {
/*     */         
/* 315 */         IncludeDocument.Include include = schemaDocument1.getSchema().addNewInclude();
/* 316 */         File file3 = (File)hashMap1.get(schemaDocument1);
/* 317 */         File file4 = outputFileFor(file3, file2, file1);
/* 318 */         File file5 = (File)hashMap3.get(schemaDocument2);
/* 319 */         if (str != null) {
/* 320 */           include.setSchemaLocation(relativeURIFor(file4, file5));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 325 */     if (!file1.isDirectory() && !file1.mkdirs()) {
/*     */       
/* 327 */       System.err.println("Unable to makedir " + file1);
/* 328 */       System.exit(1);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 333 */     for (SchemaDocument schemaDocument : hashMap1.keySet()) {
/*     */ 
/*     */       
/* 336 */       File file3 = (File)hashMap1.get(schemaDocument);
/* 337 */       File file4 = outputFileFor(file3, file2, file1);
/* 338 */       if (file4 == null) {
/* 339 */         System.out.println("Cannot copy " + file3); continue;
/*     */       } 
/* 341 */       schemaDocument.save(file4, (new XmlOptions()).setSavePrettyPrint().setSaveAggresiveNamespaces());
/*     */     } 
/*     */     
/* 344 */     for (SchemaDocument schemaDocument : hashMap3.keySet()) {
/*     */ 
/*     */       
/* 347 */       File file = (File)hashMap3.get(schemaDocument);
/* 348 */       schemaDocument.save(file, (new XmlOptions()).setSavePrettyPrint().setSaveAggresiveNamespaces());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static File outputFileFor(File paramFile1, File paramFile2, File paramFile3) {
/* 355 */     URI uRI1 = paramFile2.getAbsoluteFile().toURI();
/* 356 */     URI uRI2 = paramFile1.getAbsoluteFile().toURI();
/* 357 */     URI uRI3 = uRI1.relativize(uRI2);
/* 358 */     if (uRI3.isAbsolute()) {
/*     */       
/* 360 */       System.out.println("Cannot relativize " + paramFile1);
/* 361 */       return null;
/*     */     } 
/*     */     
/* 364 */     URI uRI4 = paramFile3.toURI();
/* 365 */     URI uRI5 = CodeGenUtil.resolve(uRI4, uRI3);
/* 366 */     return new File(uRI5);
/*     */   }
/*     */ 
/*     */   
/*     */   private static URI commonAncestor(URI paramURI1, URI paramURI2) {
/* 371 */     String str1 = paramURI1.toString();
/* 372 */     String str2 = paramURI2.toString();
/* 373 */     int i = str1.length();
/* 374 */     if (str2.length() < i)
/* 375 */       i = str2.length(); 
/*     */     int j;
/* 377 */     for (j = 0; j < i; j++) {
/*     */       
/* 379 */       if (str1.charAt(j) != str2.charAt(j))
/*     */         break; 
/*     */     } 
/* 382 */     j--;
/* 383 */     if (j >= 0)
/* 384 */       j = str1.lastIndexOf('/', j); 
/* 385 */     if (j < 0) {
/* 386 */       return null;
/*     */     }
/*     */     try {
/* 389 */       return new URI(str1.substring(0, j));
/*     */     }
/* 391 */     catch (URISyntaxException uRISyntaxException) {
/*     */       
/* 393 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static String relativeURIFor(File paramFile1, File paramFile2) {
/* 400 */     URI uRI1 = paramFile1.getAbsoluteFile().toURI();
/* 401 */     URI uRI2 = paramFile2.getAbsoluteFile().toURI();
/*     */     
/* 403 */     URI uRI3 = commonAncestor(uRI1, uRI2);
/* 404 */     if (uRI3 == null) {
/* 405 */       return uRI2.toString();
/*     */     }
/* 407 */     URI uRI4 = uRI3.relativize(uRI1);
/* 408 */     URI uRI5 = uRI3.relativize(uRI2);
/* 409 */     if (uRI4.isAbsolute() || uRI5.isAbsolute())
/* 410 */       return uRI2.toString(); 
/* 411 */     String str1 = "";
/* 412 */     String str2 = uRI4.toString();
/* 413 */     for (int i = 0; i < str2.length(); ) {
/*     */       
/* 415 */       i = str2.indexOf('/', i);
/* 416 */       if (i < 0)
/*     */         break; 
/* 418 */       str1 = str1 + "../";
/* 419 */       i++;
/*     */     } 
/* 421 */     return str1 + uRI5.toString();
/*     */   }
/*     */ 
/*     */   
/*     */   private static File commonFileFor(String paramString1, String paramString2, int paramInt, File paramFile) {
/* 426 */     String str = paramString1;
/* 427 */     if (paramInt > 0) {
/*     */       
/* 429 */       int i = paramString1.lastIndexOf('.');
/* 430 */       if (i < 0)
/* 431 */         i = paramString1.length(); 
/* 432 */       str = paramString1.substring(0, i) + paramInt + paramString1.substring(i);
/*     */     } 
/* 434 */     return new File(paramFile, str);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void noteName(String paramString1, String paramString2, Set paramSet1, Set paramSet2, Set paramSet3) {
/* 440 */     if (paramString1 == null)
/*     */       return; 
/* 442 */     b b = new b(paramString2, paramString1);
/* 443 */     if (paramSet1.contains(b)) {
/*     */       
/* 445 */       paramSet2.add(b);
/* 446 */       paramSet3.add(paramString2);
/*     */     } else {
/*     */       
/* 449 */       paramSet1.add(b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isFirstDuplicate(String paramString1, String paramString2, Set paramSet1, Set paramSet2) {
/* 455 */     if (paramString1 == null)
/* 456 */       return false; 
/* 457 */     b b = new b(paramString2, paramString1);
/* 458 */     if (paramSet2.contains(b) && paramSet1.contains(b)) {
/*     */       
/* 460 */       paramSet1.remove(b);
/* 461 */       return true;
/*     */     } 
/* 463 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean isDuplicate(String paramString1, String paramString2, Set paramSet) {
/* 468 */     if (paramString1 == null)
/* 469 */       return false; 
/* 470 */     b b = new b(paramString2, paramString1);
/* 471 */     return paramSet.contains(b);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\FactorImports.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */