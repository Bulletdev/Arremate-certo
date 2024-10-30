/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.util.Arrays;
/*     */ import java.util.HashSet;
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
/*     */ public class RunXQuery
/*     */ {
/*     */   public static void printUsage() {
/*  26 */     System.out.println("Run an XQuery against an XML instance");
/*  27 */     System.out.println("Usage:");
/*  28 */     System.out.println("xquery [-verbose] [-pretty] [-q <query> | -qf query.xq] [file.xml]*");
/*  29 */     System.out.println(" -q <query> to specify a query on the command-line");
/*  30 */     System.out.println(" -qf <query> to specify a file containing a query");
/*  31 */     System.out.println(" -pretty pretty-prints the results");
/*  32 */     System.out.println(" -license prints license information");
/*  33 */     System.out.println(" the query is run on each XML file specified");
/*  34 */     System.out.println("");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  39 */     HashSet hashSet = new HashSet();
/*  40 */     hashSet.add("h");
/*  41 */     hashSet.add("help");
/*  42 */     hashSet.add("usage");
/*  43 */     hashSet.add("license");
/*  44 */     hashSet.add("version");
/*  45 */     hashSet.add("verbose");
/*  46 */     hashSet.add("pretty");
/*     */     
/*  48 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Arrays.asList(new String[] { "q", "qf" }));
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  53 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/*  55 */       printUsage();
/*  56 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  60 */     String[] arrayOfString = commandLine.getBadOpts();
/*  61 */     if (arrayOfString.length > 0) {
/*     */       
/*  63 */       for (byte b1 = 0; b1 < arrayOfString.length; b1++)
/*  64 */         System.out.println("Unrecognized option: " + arrayOfString[b1]); 
/*  65 */       printUsage();
/*  66 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  70 */     if (commandLine.getOpt("license") != null) {
/*     */       
/*  72 */       CommandLine.printLicense();
/*  73 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  77 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  79 */       CommandLine.printVersion();
/*  80 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  84 */     paramArrayOfString = commandLine.args();
/*     */     
/*  86 */     if (paramArrayOfString.length == 0) {
/*     */       
/*  88 */       printUsage();
/*  89 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  93 */     boolean bool1 = (commandLine.getOpt("verbose") != null) ? true : false;
/*  94 */     boolean bool2 = (commandLine.getOpt("pretty") != null) ? true : false;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 100 */     String str1 = commandLine.getOpt("q");
/* 101 */     String str2 = commandLine.getOpt("qf");
/*     */     
/* 103 */     if (str1 == null && str2 == null) {
/*     */       
/* 105 */       System.err.println("No query specified");
/* 106 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/* 110 */     if (str1 != null && str2 != null) {
/*     */       
/* 112 */       System.err.println("Specify -qf or -q, not both.");
/* 113 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/*     */     try {
/* 119 */       if (str2 != null)
/*     */       {
/* 121 */         File file = new File(str2);
/* 122 */         FileInputStream fileInputStream = new FileInputStream(file);
/* 123 */         InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/*     */         
/* 125 */         StringBuffer stringBuffer = new StringBuffer();
/*     */ 
/*     */         
/*     */         while (true) {
/* 129 */           int i = inputStreamReader.read();
/*     */           
/* 131 */           if (i < 0) {
/*     */             break;
/*     */           }
/* 134 */           stringBuffer.append((char)i);
/*     */         } 
/*     */         
/* 137 */         inputStreamReader.close();
/* 138 */         fileInputStream.close();
/*     */         
/* 140 */         str1 = stringBuffer.toString();
/*     */       }
/*     */     
/* 143 */     } catch (Throwable throwable) {
/*     */       
/* 145 */       System.err.println("Cannot read query file: " + throwable.getMessage());
/* 146 */       System.exit(1);
/*     */       
/*     */       return;
/*     */     } 
/* 150 */     if (bool1) {
/*     */       
/* 152 */       System.out.println("Compile Query:");
/* 153 */       System.out.println(str1);
/* 154 */       System.out.println();
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 159 */       str1 = XmlBeans.compileQuery(str1);
/*     */     }
/* 161 */     catch (Exception exception) {
/*     */       
/* 163 */       System.err.println("Error compiling query: " + exception.getMessage());
/* 164 */       System.exit(1);
/*     */ 
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */ 
/*     */     
/* 172 */     File[] arrayOfFile = commandLine.getFiles();
/*     */     
/* 174 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/*     */       XmlObject xmlObject;
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 180 */         if (bool1) {
/*     */           
/* 182 */           FileInputStream fileInputStream = new FileInputStream(arrayOfFile[b]);
/*     */ 
/*     */           
/*     */           while (true) {
/* 186 */             int i = fileInputStream.read();
/*     */             
/* 188 */             if (i < 0) {
/*     */               break;
/*     */             }
/* 191 */             System.out.write(i);
/*     */           } 
/*     */           
/* 194 */           fileInputStream.close();
/*     */           
/* 196 */           System.out.println();
/*     */         } 
/*     */         
/* 199 */         xmlObject = XmlObject.Factory.parse(arrayOfFile[b]);
/*     */       }
/* 201 */       catch (Throwable throwable) {
/*     */         
/* 203 */         System.err.println("Error parsing instance: " + throwable.getMessage());
/* 204 */         System.exit(1);
/*     */         
/*     */         return;
/*     */       } 
/* 208 */       if (bool1) {
/*     */         
/* 210 */         System.out.println("Executing Query...");
/* 211 */         System.err.println();
/*     */       } 
/*     */       
/* 214 */       XmlObject[] arrayOfXmlObject = null;
/*     */ 
/*     */       
/*     */       try {
/* 218 */         arrayOfXmlObject = xmlObject.execQuery(str1);
/*     */       }
/* 220 */       catch (Throwable throwable) {
/*     */         
/* 222 */         System.err.println("Error executing query: " + throwable.getMessage());
/* 223 */         System.exit(1);
/*     */         
/*     */         return;
/*     */       } 
/* 227 */       if (bool1)
/*     */       {
/* 229 */         System.out.println("Query Result:");
/*     */       }
/*     */       
/* 232 */       XmlOptions xmlOptions = new XmlOptions();
/* 233 */       xmlOptions.setSaveOuter();
/* 234 */       if (bool2) {
/* 235 */         xmlOptions.setSavePrettyPrint();
/*     */       }
/* 237 */       for (byte b1 = 0; b1 < arrayOfXmlObject.length; b1++) {
/*     */         
/* 239 */         arrayOfXmlObject[b1].save(System.out, xmlOptions);
/* 240 */         System.out.println();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\RunXQuery.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */