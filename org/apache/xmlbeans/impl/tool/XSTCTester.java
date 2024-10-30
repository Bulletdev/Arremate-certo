/*     */ package org.apache.xmlbeans.impl.tool;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.Date;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.regex.Pattern;
/*     */ import org.apache.xmlbeans.SystemProperties;
/*     */ import org.apache.xmlbeans.XmlCalendar;
/*     */ import org.apache.xmlbeans.XmlError;
/*     */ import org.apache.xmlbeans.XmlException;
/*     */ import org.apache.xmlbeans.XmlObject;
/*     */ import org.apache.xmlbeans.XmlOptions;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.FileDesc;
/*     */ import org.apache.xmlbeans.impl.xb.ltgfmt.TestsDocument;
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
/*     */ public class XSTCTester
/*     */ {
/*     */   public static void printUsage() {
/*  44 */     System.out.println("Usage: xstc [-showpass] [-errcode] foo_LTGfmt.xml ...");
/*     */   }
/*     */ 
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws IOException {
/*  49 */     HashSet hashSet = new HashSet();
/*  50 */     hashSet.add("h");
/*  51 */     hashSet.add("help");
/*  52 */     hashSet.add("usage");
/*  53 */     hashSet.add("version");
/*  54 */     hashSet.add("showpass");
/*  55 */     hashSet.add("errcode");
/*     */     
/*  57 */     long l1 = System.currentTimeMillis();
/*     */     
/*  59 */     CommandLine commandLine = new CommandLine(paramArrayOfString, hashSet, Collections.EMPTY_SET);
/*  60 */     if (commandLine.getOpt("h") != null || commandLine.getOpt("help") != null || commandLine.getOpt("usage") != null) {
/*     */       
/*  62 */       printUsage();
/*  63 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  67 */     if (commandLine.getOpt("version") != null) {
/*     */       
/*  69 */       CommandLine.printVersion();
/*  70 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  74 */     String[] arrayOfString = commandLine.getBadOpts();
/*  75 */     if (arrayOfString.length > 0) {
/*     */       
/*  77 */       for (byte b = 0; b < arrayOfString.length; b++)
/*  78 */         System.out.println("Unrecognized option: " + arrayOfString[b]); 
/*  79 */       printUsage();
/*  80 */       System.exit(0);
/*     */       
/*     */       return;
/*     */     } 
/*  84 */     if ((commandLine.args()).length == 0) {
/*  85 */       printUsage();
/*     */       
/*     */       return;
/*     */     } 
/*  89 */     boolean bool1 = (commandLine.getOpt("showpass") != null) ? true : false;
/*  90 */     boolean bool2 = (commandLine.getOpt("errcode") != null) ? true : false;
/*     */     
/*  92 */     File[] arrayOfFile = commandLine.getFiles();
/*  93 */     ArrayList arrayList = new ArrayList();
/*  94 */     XMLBeanXSTCHarness xMLBeanXSTCHarness = new XMLBeanXSTCHarness();
/*     */     
/*  96 */     for (byte b1 = 0; b1 < arrayOfFile.length; b1++) {
/*     */       
/*  98 */       if (arrayOfFile[b1].getName().indexOf("LTG") >= 0) {
/*  99 */         arrayList.add(arrayOfFile[b1]);
/*     */       }
/*     */     } 
/* 102 */     File file = new File("out.html");
/* 103 */     PrintWriter printWriter = new PrintWriter(new FileWriter(file));
/* 104 */     printWriter.println("<html>");
/* 105 */     printWriter.println("<style>td {border-bottom: 1px solid black} xmp {white-space: normal; word-wrap: break-word; word-break: break-all} </style>");
/* 106 */     printWriter.println("<body>");
/*     */     
/* 108 */     printWriter.println("<script language='JavaScript' type='text/javascript'>");
/* 109 */     printWriter.println("var w;");
/* 110 */     printWriter.println("function openWindow(schema, instance) {");
/* 111 */     printWriter.println("  if (w == null) {");
/* 112 */     printWriter.println("    w = window.open('about:blank', 'xstc');");
/* 113 */     printWriter.println("  }");
/* 114 */     printWriter.println("  if (w.closed) {");
/* 115 */     printWriter.println("    w = window.open('about:blank', 'xstc');");
/* 116 */     printWriter.println("  }");
/* 117 */     printWriter.println("  w.document.open();");
/* 118 */     printWriter.println("  w.document.write(\"<frameset rows=*,*><frame src='\" + schema + \"'><frame src='\" + instance + \"'></frameset>\");");
/* 119 */     printWriter.println("  w.document.close();");
/* 120 */     printWriter.println("  w.focus();");
/* 121 */     printWriter.println("}");
/* 122 */     printWriter.println("</script>");
/*     */     
/* 124 */     printWriter.println("<h1>XML Schema Test Collection Results</h1>");
/* 125 */     printWriter.println("<p>Run on " + new XmlCalendar(new Date()) + "</p>");
/* 126 */     printWriter.println("<p>Values in schema or instance valid columns are results from compiling or validating respectively.");
/* 127 */     printWriter.println("Red or orange background mean the test failed.</p>");
/* 128 */     printWriter.println("<table style='border: 1px solid black' cellpadding=0 cellspacing=0>");
/* 129 */     printWriter.println("<tr><td witdh=10%>id</td><td width=70%>Description</td><td width=10%>sch v</td><td width=10%>ins v</td></tr>");
/* 130 */     byte b2 = 0;
/* 131 */     byte b3 = 0;
/* 132 */     for (File file1 : arrayList) {
/*     */ 
/*     */       
/* 135 */       System.out.println("Processing test cases in " + file1);
/* 136 */       ArrayList arrayList1 = new ArrayList();
/* 137 */       TestCase[] arrayOfTestCase = parseLTGFile(file1, arrayList1);
/* 138 */       ArrayList arrayList2 = new ArrayList();
/* 139 */       if (arrayOfTestCase != null) for (byte b = 0; b < arrayOfTestCase.length; b++) {
/*     */           
/* 141 */           TestCaseResult testCaseResult = new TestCaseResult();
/* 142 */           testCaseResult.testCase = arrayOfTestCase[b];
/* 143 */           xMLBeanXSTCHarness.runTestCase(testCaseResult);
/* 144 */           b3++;
/* 145 */           if (!testCaseResult.succeeded(bool2)) {
/* 146 */             b2++;
/* 147 */           } else if (!bool1) {
/*     */             continue;
/* 149 */           }  arrayList2.add(testCaseResult); continue;
/*     */         }  
/* 151 */       printWriter.println("<tr><td colspan=4 bgcolor=skyblue>" + file1 + "</td></tr>");
/* 152 */       if (!arrayList1.isEmpty()) {
/*     */         
/* 154 */         printWriter.println("<tr><td>Errors within the LTG file:");
/* 155 */         printWriter.println("<xmp>");
/* 156 */         for (Iterator iterator1 = arrayList1.iterator(); iterator1.hasNext();)
/* 157 */           printWriter.println(iterator1.next()); 
/* 158 */         printWriter.println("</xmp>");
/* 159 */         printWriter.println("</td></tr>");
/*     */ 
/*     */       
/*     */       }
/* 163 */       else if (arrayList2.size() == 0) {
/* 164 */         printWriter.println("<tr><td colspan=4 bgcolor=green>Nothing to report</td></tr>");
/*     */       } 
/* 166 */       if (arrayList2 == null)
/*     */         continue; 
/* 168 */       for (Iterator iterator = arrayList2.iterator(); iterator.hasNext();)
/*     */       {
/* 170 */         summarizeResultAsHTMLTableRows(iterator.next(), printWriter, bool2);
/*     */       }
/*     */     } 
/* 173 */     printWriter.println("<tr><td colspan=4>Summary: " + b2 + " failures out of " + b3 + " cases run.</td></tr>");
/* 174 */     printWriter.println("</table>");
/* 175 */     printWriter.close();
/*     */     
/* 177 */     long l2 = System.currentTimeMillis();
/* 178 */     System.out.println("Time run tests: " + ((l2 - l1) / 1000.0D) + " seconds");
/*     */ 
/*     */     
/* 181 */     System.out.println("Results output to " + file);
/* 182 */     if (SystemProperties.getProperty("os.name").toLowerCase().indexOf("windows") >= 0) {
/* 183 */       Runtime.getRuntime().exec("cmd /c start iexplore \"" + file.getAbsolutePath() + "\"");
/*     */     } else {
/* 185 */       Runtime.getRuntime().exec("mozilla file://" + file.getAbsolutePath());
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class TestCase
/*     */   {
/*     */     private File ltgFile;
/*     */     private String id;
/*     */     private String origin;
/*     */     private String description;
/*     */     private File schemaFile;
/*     */     private File instanceFile;
/*     */     private File resourceFile;
/*     */     private boolean svExpected;
/*     */     private boolean ivExpected;
/*     */     private boolean rvExpected;
/*     */     private String errorCode;
/*     */     
/*     */     public File getLtgFile() {
/* 204 */       return this.ltgFile;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getId() {
/* 209 */       return this.id;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getOrigin() {
/* 214 */       return this.origin;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getDescription() {
/* 219 */       return this.description;
/*     */     }
/*     */ 
/*     */     
/*     */     public File getSchemaFile() {
/* 224 */       return this.schemaFile;
/*     */     }
/*     */ 
/*     */     
/*     */     public File getInstanceFile() {
/* 229 */       return this.instanceFile;
/*     */     }
/*     */ 
/*     */     
/*     */     public File getResourceFile() {
/* 234 */       return this.resourceFile;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSvExpected() {
/* 239 */       return this.svExpected;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isIvExpected() {
/* 244 */       return this.ivExpected;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isRvExpected() {
/* 249 */       return this.rvExpected;
/*     */     }
/*     */ 
/*     */     
/*     */     public String getErrorCode() {
/* 254 */       return this.errorCode;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static class TestCaseResult
/*     */   {
/*     */     private XSTCTester.TestCase testCase;
/*     */     private boolean svActual;
/* 263 */     private Collection svMessages = new ArrayList();
/*     */     private boolean ivActual;
/* 265 */     private Collection ivMessages = new ArrayList();
/*     */     
/*     */     private boolean crash;
/*     */     
/*     */     public XSTCTester.TestCase getTestCase() {
/* 270 */       return this.testCase;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isSvActual() {
/* 275 */       return this.svActual;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setSvActual(boolean param1Boolean) {
/* 280 */       this.svActual = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isIvActual() {
/* 285 */       return this.ivActual;
/*     */     }
/*     */ 
/*     */     
/*     */     public void setIvActual(boolean param1Boolean) {
/* 290 */       this.ivActual = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection getSvMessages() {
/* 295 */       return Collections.unmodifiableCollection(this.svMessages);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addSvMessages(Collection param1Collection) {
/* 300 */       this.svMessages.addAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public Collection getIvMessages() {
/* 305 */       return Collections.unmodifiableCollection(this.ivMessages);
/*     */     }
/*     */ 
/*     */     
/*     */     public void addIvMessages(Collection param1Collection) {
/* 310 */       this.ivMessages.addAll(param1Collection);
/*     */     }
/*     */ 
/*     */     
/*     */     public void setCrash(boolean param1Boolean) {
/* 315 */       this.crash = param1Boolean;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean isCrash() {
/* 320 */       return this.crash;
/*     */     }
/*     */ 
/*     */     
/*     */     public boolean succeeded(boolean param1Boolean) {
/* 325 */       int i = (!this.crash && isIvActual() == this.testCase.isIvExpected() && isSvActual() == this.testCase.isSvExpected()) ? 1 : 0;
/*     */ 
/*     */       
/* 328 */       if (param1Boolean && this.testCase.getErrorCode() != null)
/* 329 */         i &= (XSTCTester.errorReported(this.testCase.getErrorCode(), this.svMessages) || XSTCTester.errorReported(this.testCase.getErrorCode(), this.ivMessages)) ? 1 : 0; 
/* 330 */       return i;
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
/*     */   public static String makeHTMLLink(File paramFile, boolean paramBoolean) {
/* 342 */     if (paramFile == null)
/* 343 */       return "&nbsp;"; 
/* 344 */     URI uRI = paramFile.getAbsoluteFile().toURI();
/* 345 */     return "<a href=\"" + uRI + "\" target=_blank>" + Boolean.toString(paramBoolean) + "</a>";
/*     */   }
/*     */   
/* 348 */   private static final Pattern leadingSpace = Pattern.compile("^\\s+", 8);
/*     */ 
/*     */   
/*     */   public static String makeHTMLDescription(TestCase paramTestCase) {
/* 352 */     StringBuffer stringBuffer = new StringBuffer();
/* 353 */     stringBuffer.append("<a class=noline href='javascript:openWindow(\"");
/* 354 */     if (paramTestCase.getSchemaFile() == null) {
/* 355 */       stringBuffer.append("about:No schema");
/*     */     } else {
/* 357 */       stringBuffer.append(paramTestCase.getSchemaFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/*     */     } 
/* 359 */     stringBuffer.append("\", \"");
/* 360 */     if (paramTestCase.getInstanceFile() == null) {
/* 361 */       stringBuffer.append("about:No instance");
/*     */     } else {
/* 363 */       stringBuffer.append(paramTestCase.getInstanceFile().getAbsolutePath().replaceAll("\\\\", "\\\\\\\\"));
/* 364 */     }  stringBuffer.append("\")'><xmp>");
/* 365 */     stringBuffer.append(leadingSpace.matcher(paramTestCase.getDescription()).replaceAll(""));
/* 366 */     stringBuffer.append("</xmp></a>");
/* 367 */     return stringBuffer.toString();
/*     */   }
/*     */   
/*     */   public static void summarizeResultAsHTMLTableRows(TestCaseResult paramTestCaseResult, PrintWriter paramPrintWriter, boolean paramBoolean) {
/*     */     String str;
/* 372 */     TestCase testCase = paramTestCaseResult.getTestCase();
/*     */     
/* 374 */     boolean bool1 = (paramBoolean && testCase.getErrorCode() != null) ? true : false;
/* 375 */     boolean bool2 = (!paramTestCaseResult.getIvMessages().isEmpty() || !paramTestCaseResult.getSvMessages().isEmpty()) ? true : false;
/*     */     
/* 377 */     boolean bool3 = (testCase.getSchemaFile() == null || testCase.isSvExpected() == paramTestCaseResult.isSvActual()) ? true : false;
/* 378 */     boolean bool4 = (testCase.getInstanceFile() == null || testCase.isIvExpected() == paramTestCaseResult.isIvActual()) ? true : false;
/* 379 */     boolean bool5 = true;
/* 380 */     if (bool1) {
/* 381 */       bool5 = (errorReported(testCase.getErrorCode(), paramTestCaseResult.svMessages) || errorReported(testCase.getErrorCode(), paramTestCaseResult.ivMessages)) ? true : false;
/*     */     }
/* 383 */     paramPrintWriter.println(paramTestCaseResult.isCrash() ? "<tr bgcolor=black color=white>" : "<tr>");
/* 384 */     int i = 1 + (bool1 ? 1 : 0) + (bool2 ? 1 : 0);
/* 385 */     paramPrintWriter.println("<td rowspan=" + i + " valign=top>" + testCase.getId() + "</td>");
/* 386 */     paramPrintWriter.println("<td valign=top>" + makeHTMLDescription(testCase) + "</td>");
/*     */     
/* 388 */     if (testCase.getResourceFile() == null) {
/* 389 */       str = makeHTMLLink(testCase.getSchemaFile(), paramTestCaseResult.isSvActual());
/*     */     } else {
/* 391 */       str = makeHTMLLink(testCase.getSchemaFile(), paramTestCaseResult.isSvActual()) + "<br>" + makeHTMLLink(testCase.getResourceFile(), paramTestCaseResult.isSvActual());
/*     */     } 
/* 393 */     paramPrintWriter.println((bool3 ? "<td valign=top>" : (paramTestCaseResult.isSvActual() ? "<td bgcolor=orange valign=top>" : "<td bgcolor=red valign=top>")) + str + "</td>");
/* 394 */     paramPrintWriter.println((bool4 ? "<td valign=top>" : (paramTestCaseResult.isIvActual() ? "<td bgcolor=orange valign=top>" : "<td bgcolor=red valign=top>")) + makeHTMLLink(testCase.getInstanceFile(), paramTestCaseResult.isIvActual()) + "</td>");
/* 395 */     paramPrintWriter.println("</tr>");
/* 396 */     if (bool1) {
/*     */       
/* 398 */       paramPrintWriter.println("<tr>");
/* 399 */       paramPrintWriter.println((bool5 ? "<td colspan=4 valid=top>" : "<td colspan=4 bgcolor=orange valign=top>") + "expected error: " + testCase.getErrorCode() + "</td>");
/* 400 */       paramPrintWriter.println("</tr>");
/*     */     } 
/* 402 */     if (bool2) {
/*     */       
/* 404 */       if (!paramTestCaseResult.succeeded(paramBoolean)) {
/* 405 */         paramPrintWriter.println("<tr><td colspan=4 bgcolor=yellow><xmp>");
/*     */       } else {
/* 407 */         paramPrintWriter.println("<tr><td colspan=4><xmp>");
/* 408 */       }  Iterator iterator; for (iterator = paramTestCaseResult.getSvMessages().iterator(); iterator.hasNext();)
/* 409 */         paramPrintWriter.println(iterator.next()); 
/* 410 */       for (iterator = paramTestCaseResult.getIvMessages().iterator(); iterator.hasNext();)
/* 411 */         paramPrintWriter.println(iterator.next()); 
/* 412 */       paramPrintWriter.println("</xmp></tr></td>");
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static TestCase[] parseLTGFile(File paramFile, Collection paramCollection) {
/* 418 */     ArrayList arrayList = new ArrayList();
/*     */     
/*     */     try {
/* 421 */       XmlOptions xmlOptions = new XmlOptions();
/* 422 */       xmlOptions.setLoadSubstituteNamespaces(Collections.singletonMap("", "http://www.bea.com/2003/05/xmlbean/ltgfmt"));
/* 423 */       xmlOptions.setErrorListener(arrayList);
/* 424 */       xmlOptions.setLoadLineNumbers();
/* 425 */       TestsDocument testsDocument = TestsDocument.Factory.parse(paramFile, xmlOptions);
/* 426 */       if (!testsDocument.validate(xmlOptions)) {
/* 427 */         throw new Exception("Document " + paramFile + " not valid.");
/*     */       }
/* 429 */       org.apache.xmlbeans.impl.xb.ltgfmt.TestCase[] arrayOfTestCase = testsDocument.getTests().getTestArray();
/*     */       
/* 431 */       ArrayList arrayList1 = new ArrayList();
/* 432 */       for (byte b = 0; b < arrayOfTestCase.length; b++) {
/*     */         
/* 434 */         TestCase testCase = new TestCase();
/* 435 */         testCase.ltgFile = paramFile;
/* 436 */         testCase.id = arrayOfTestCase[b].getId();
/* 437 */         testCase.origin = arrayOfTestCase[b].getOrigin();
/* 438 */         testCase.description = arrayOfTestCase[b].getDescription();
/* 439 */         FileDesc[] arrayOfFileDesc = arrayOfTestCase[b].getFiles().getFileArray();
/* 440 */         arrayOfTestCase[b].getOrigin();
/* 441 */         for (byte b1 = 0; b1 < arrayOfFileDesc.length; b1++) {
/*     */           
/* 443 */           String str1 = arrayOfFileDesc[b1].getFolder();
/* 444 */           String str2 = arrayOfFileDesc[b1].getFileName();
/* 445 */           File file = new File(paramFile.getParentFile(), str1 + "/" + str2);
/* 446 */           if (!file.exists() || !file.isFile() || !file.canRead()) {
/*     */             
/* 448 */             paramCollection.add(XmlError.forObject("Can't read file " + file, (XmlObject)arrayOfFileDesc[b1]).toString());
/*     */           }
/*     */           else {
/*     */             
/* 452 */             switch (arrayOfFileDesc[b1].getRole().intValue()) {
/*     */               
/*     */               case 2:
/* 455 */                 if (testCase.instanceFile != null)
/* 456 */                   paramCollection.add(XmlError.forObject("More than one instance file speicifed - ignoring all but last", (XmlObject)arrayOfFileDesc[b1]).toString()); 
/* 457 */                 testCase.instanceFile = file;
/* 458 */                 testCase.ivExpected = arrayOfFileDesc[b1].getValidity();
/*     */                 break;
/*     */               
/*     */               case 1:
/* 462 */                 if (testCase.schemaFile != null)
/* 463 */                   paramCollection.add(XmlError.forObject("More than one schema file speicifed - ignoring all but last", (XmlObject)arrayOfFileDesc[b1]).toString()); 
/* 464 */                 testCase.schemaFile = file;
/* 465 */                 testCase.svExpected = arrayOfFileDesc[b1].getValidity();
/*     */                 break;
/*     */               
/*     */               case 3:
/* 469 */                 if (testCase.resourceFile != null)
/* 470 */                   paramCollection.add(XmlError.forObject("More than one resource file speicifed - ignoring all but last", (XmlObject)arrayOfFileDesc[b1]).toString()); 
/* 471 */                 testCase.resourceFile = file;
/* 472 */                 testCase.rvExpected = arrayOfFileDesc[b1].getValidity();
/*     */                 break;
/*     */               
/*     */               default:
/* 476 */                 throw new XmlException(XmlError.forObject("Unexpected file role", arrayOfFileDesc[b1]));
/*     */             } 
/*     */             
/* 479 */             if (arrayOfFileDesc[b1].getCode() != null)
/* 480 */               testCase.errorCode = arrayOfFileDesc[b1].getCode().getID(); 
/*     */           } 
/* 482 */         }  arrayList1.add(testCase);
/*     */       } 
/* 484 */       return arrayList1.<TestCase>toArray(new TestCase[arrayList1.size()]);
/*     */     }
/* 486 */     catch (Exception exception) {
/*     */       
/* 488 */       if (arrayList.isEmpty())
/* 489 */       { paramCollection.add(exception.getMessage()); }
/* 490 */       else { for (Iterator iterator = arrayList.iterator(); iterator.hasNext();)
/* 491 */           paramCollection.add(iterator.next().toString());  }
/* 492 */        return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean errorReported(String paramString, Collection paramCollection) {
/* 498 */     if (paramString == null || paramCollection == null || paramCollection.size() == 0) {
/* 499 */       return false;
/*     */     }
/* 501 */     for (Iterator iterator = paramCollection.iterator(); iterator.hasNext();) {
/*     */       
/* 503 */       if (paramString.equals(((XmlError)iterator.next()).getErrorCode())) {
/* 504 */         return true;
/*     */       }
/*     */     } 
/* 507 */     return false;
/*     */   }
/*     */   
/*     */   public static interface Harness {
/*     */     void runTestCase(XSTCTester.TestCaseResult param1TestCaseResult);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\org\apache\xmlbeans\impl\tool\XSTCTester.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */