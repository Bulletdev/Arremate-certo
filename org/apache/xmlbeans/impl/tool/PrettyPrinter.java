/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import org.apache.xmlbeans.XmlException;
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
/*     */ public class PrettyPrinter
/*     */ {
/*     */   private static final int DEFAULT_INDENT = 2;
/*     */   
/*     */   public static void printUsage() {
/*  35 */     System.out.println("Pretty prints XML files.");
/*  36 */     System.out.println("Usage: xpretty [switches] file.xml");
/*  37 */     System.out.println("Switches:");
/*  38 */     System.out.println("    -indent #   use the given indent");
/*  39 */     System.out.println("    -license prints license information");
/*     */   }
/*     */   
/*     */   public static void main(String[] paramArrayOfString) {
/*     */     int i;
/*  44 */     HashSet hashSet = new HashSet();
/*  45 */     hashSet.add("h");
/*  46 */     hashSet.add("help");
/*  47 */     hashSet.add("usage");
/*  48 */     hashSet.add("license");
/*  49 */     hashSet.add("version");
/*     */     
/*  51 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Collections.singleton("indent"));
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
/*  84 */     if ((commandLine.args()).length == 0) {
/*     */       
/*  86 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/*  90 */     String str = commandLine.getOpt("indent");
/*     */     
/*  92 */     if (str == null) {
/*  93 */       i = 2;
/*     */     } else {
/*  95 */       i = Integer.parseInt(str);
/*     */     } 
/*  97 */     File[] arrayOfFile = commandLine.getFiles();
/*     */     
/*  99 */     for (byte b = 0; b < arrayOfFile.length; b++) {
/*     */       XmlObject xmlObject;
/*     */ 
/*     */       
/*     */       try {
/* 104 */         xmlObject = XmlObject.Factory.parse(arrayOfFile[b], (new XmlOptions()).setLoadLineNumbers());
/*     */       }
/* 106 */       catch (Exception exception) {
/*     */         
/* 108 */         System.err.println(arrayOfFile[b] + " not loadable: " + exception.getMessage());
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 114 */         xmlObject.save(System.out, (new XmlOptions()).setSavePrettyPrint().setSavePrettyPrintIndent(i));
/*     */       }
/* 116 */       catch (IOException iOException) {
/*     */         
/* 118 */         System.err.println("Unable to pretty print " + arrayOfFile[b] + ": " + iOException.getMessage());
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static String indent(String paramString) throws IOException, XmlException {
/* 126 */     StringWriter stringWriter = new StringWriter();
/* 127 */     XmlObject xmlObject = XmlObject.Factory.parse(paramString, (new XmlOptions()).setLoadLineNumbers());
/* 128 */     xmlObject.save(stringWriter, (new XmlOptions()).setSavePrettyPrint().setSavePrettyPrintIndent(2));
/* 129 */     stringWriter.close();
/* 130 */     return stringWriter.getBuffer().toString();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\PrettyPrinter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */