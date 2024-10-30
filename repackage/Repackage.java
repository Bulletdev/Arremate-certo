/*     */ package repackage;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStream;
/*     */ import java.io.InputStreamReader;
/*     */ import java.io.OutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.io.Reader;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ 
/*     */ public class Repackage {
/*     */   private File g;
/*     */   private File h;
/*     */   private List bb;
/*     */   private List bc;
/*     */   
/*     */   public static void main(String[] paramArrayOfString) throws Exception {
/*  26 */     (new Repackage(paramArrayOfString)).iO();
/*     */   }
/*     */   private Pattern H; private a _repackager; private Map aD; private List bd; private int jo;
/*     */   
/*     */   private Repackage(String[] paramArrayOfString) {
/*  31 */     String str1 = null;
/*  32 */     String str2 = null;
/*  33 */     String str3 = null;
/*  34 */     boolean bool = false;
/*     */     
/*  36 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/*     */       
/*  38 */       if (paramArrayOfString[b].equals("-repackage") && b + 1 < paramArrayOfString.length) {
/*  39 */         str3 = paramArrayOfString[++b];
/*  40 */       } else if (paramArrayOfString[b].equals("-f") && b + 1 < paramArrayOfString.length) {
/*  41 */         str1 = paramArrayOfString[++b];
/*  42 */       } else if (paramArrayOfString[b].equals("-t") && b + 1 < paramArrayOfString.length) {
/*  43 */         str2 = paramArrayOfString[++b];
/*     */       } else {
/*  45 */         bool = true;
/*     */       } 
/*     */     } 
/*  48 */     if (!bool && str3 != null) if ((((str1 == null) ? 1 : 0) ^ ((str2 == null) ? 1 : 0)) == 0) {
/*     */ 
/*     */         
/*  51 */         this._repackager = new a(str3);
/*     */         
/*  53 */         if (str1 == null || str2 == null) {
/*     */           return;
/*     */         }
/*  56 */         this.g = new File(str1);
/*  57 */         this.h = new File(str2);
/*     */         return;
/*     */       }  
/*     */     throw new RuntimeException("Usage: repackage -repackage [spec] [ -f [sourcedir] -t [targetdir] ]");
/*     */   }
/*     */   public void iO() throws Exception {
/*  63 */     if (this.g == null || this.h == null) {
/*     */       
/*  65 */       System.out.println(this._repackager.a(a(System.in)).toString());
/*     */       
/*     */       return;
/*     */     } 
/*  69 */     this.bb = this._repackager.bG();
/*  70 */     this.bc = this._repackager.bH();
/*     */     
/*  72 */     this.H = Pattern.compile("^\\s*package\\s+((?:\\w|\\.)*)\\s*;", 8);
/*     */ 
/*     */     
/*  75 */     this.bd = new ArrayList();
/*  76 */     this.aD = new HashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     this.h.mkdirs();
/*     */     
/*  83 */     ArrayList arrayList = new ArrayList();
/*     */     
/*  85 */     a(arrayList, this.g);
/*     */     
/*  87 */     System.out.println("Repackaging " + arrayList.size() + " files ...");
/*     */     
/*  89 */     int i = this.g.getCanonicalPath().length();
/*     */     
/*  91 */     for (byte b = 0; b < arrayList.size(); b++) {
/*     */       
/*  93 */       File file = arrayList.get(b);
/*     */       
/*  95 */       String str = file.getCanonicalPath().substring(i + 1);
/*     */       
/*  97 */       bR(str);
/*     */     } 
/*     */     
/* 100 */     iP();
/*     */     
/* 102 */     if (this.jo > 0) {
/* 103 */       System.out.println("Skipped " + this.jo + " unmodified files.");
/*     */     }
/*     */   }
/*     */   
/*     */   private boolean ah(String paramString) {
/* 108 */     File file1 = new File(this.g, paramString);
/* 109 */     File file2 = new File(this.h, paramString);
/* 110 */     return (file1.lastModified() < file2.lastModified());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bR(String paramString) throws IOException {
/* 116 */     if (paramString.endsWith(".java")) {
/* 117 */       bU(paramString);
/* 118 */     } else if (paramString.endsWith(".xsdconfig") || paramString.endsWith(".xml") || paramString.endsWith(".g")) {
/*     */ 
/*     */       
/* 121 */       bT(paramString);
/* 122 */     } else if (paramString.startsWith("bin" + File.separatorChar)) {
/* 123 */       bT(paramString);
/*     */     } else {
/* 125 */       bS(paramString);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void bS(String paramString) {
/* 130 */     this.bd.add(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void iP() throws IOException {
/* 136 */     for (String str1 : this.bd) {
/*     */ 
/*     */       
/* 139 */       String str2 = str1;
/*     */       
/* 141 */       String str3 = a.bt(str1);
/* 142 */       String str4 = (String)this.aD.get(str3);
/*     */       
/* 144 */       if (str4 != null) {
/* 145 */         str2 = (new File(str4, (new File(str1)).getName())).toString();
/*     */       }
/* 147 */       if (str1.endsWith(".html")) {
/* 148 */         p(str1, str2); continue;
/*     */       } 
/* 150 */       q(str1, str2);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bT(String paramString) throws IOException {
/* 157 */     File file1 = new File(this.g, paramString);
/* 158 */     File file2 = new File(this.h, paramString);
/*     */     
/* 160 */     if (file1.lastModified() < file2.lastModified()) {
/* 161 */       this.jo++;
/*     */     } else {
/* 163 */       a(file2, this._repackager.a(a(file1)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void p(String paramString1, String paramString2) throws IOException {
/* 169 */     File file1 = new File(this.g, paramString1);
/* 170 */     File file2 = new File(this.h, paramString2);
/*     */     
/* 172 */     if (file1.lastModified() < file2.lastModified()) {
/* 173 */       this.jo++;
/*     */     } else {
/* 175 */       a(file2, this._repackager.a(a(file1)));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void q(String paramString1, String paramString2) throws IOException {
/* 181 */     File file1 = new File(this.g, paramString1);
/* 182 */     File file2 = new File(this.h, paramString2);
/*     */     
/* 184 */     if (file1.lastModified() < file2.lastModified()) {
/* 185 */       this.jo++;
/*     */     } else {
/* 187 */       copyFile(file1, file2);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void bU(String paramString) throws IOException {
/* 193 */     File file1 = new File(this.g, paramString);
/* 194 */     StringBuffer stringBuffer = a(file1);
/*     */     
/* 196 */     Matcher matcher = this.H.matcher(stringBuffer);
/*     */     
/* 198 */     if (matcher.find()) {
/*     */       boolean bool;
/* 200 */       String str1 = matcher.group(1);
/* 201 */       int i = matcher.start(1);
/* 202 */       int j = matcher.end(1);
/*     */       
/* 204 */       if (matcher.find()) {
/* 205 */         throw new RuntimeException("Two package specifications found: " + paramString);
/*     */       }
/* 207 */       ArrayList arrayList = a.a(paramString, File.separatorChar);
/* 208 */       String str2 = a.bt(paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       do {
/* 215 */         bool = false;
/*     */         
/* 217 */         for (byte b1 = 1; b1 < arrayList.size(); b1++) {
/*     */           
/* 219 */           String str3 = arrayList.get(b1 - 1);
/* 220 */           String str4 = arrayList.get(b1);
/*     */           
/* 222 */           if (str3.indexOf(':') < str4.indexOf(':'))
/*     */           {
/* 224 */             arrayList.set(b1 - 1, str4);
/* 225 */             arrayList.set(b1, str3);
/*     */             
/* 227 */             bool = true;
/*     */           }
/*     */         
/*     */         } 
/* 231 */       } while (bool);
/*     */ 
/*     */ 
/*     */       
/* 235 */       ArrayList arrayList1 = a.a(str1, '.');
/*     */       
/* 237 */       int k = arrayList.size() - 2;
/*     */       
/* 239 */       if (k < 0 || arrayList.size() - 1 < arrayList1.size()) {
/* 240 */         throw new RuntimeException("Package spec differs from file path: " + paramString);
/*     */       }
/* 242 */       for (int m = arrayList1.size() - 1; m >= 0; m--) {
/*     */         
/* 244 */         if (!arrayList1.get(m).equals(arrayList.get(k)))
/* 245 */           throw new RuntimeException("Package spec differs from file path: " + paramString); 
/* 246 */         k--;
/*     */       } 
/*     */       
/* 249 */       List list = null;
/* 250 */       List list1 = null;
/*     */       
/*     */       byte b;
/* 253 */       label77: for (b = 0; b < this.bb.size(); b++) {
/*     */         
/* 255 */         List list2 = this.bb.get(b);
/*     */         
/* 257 */         if (list2.size() <= arrayList1.size()) {
/*     */           
/* 259 */           for (byte b1 = 0; b1 < list2.size(); b1++) {
/* 260 */             if (!list2.get(b1).equals(arrayList1.get(b1)))
/*     */               continue label77; 
/*     */           } 
/* 263 */           list1 = list2;
/* 264 */           list = this.bc.get(b);
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/*     */       
/* 270 */       if (list != null) {
/*     */         
/* 272 */         String str3 = "";
/* 273 */         String str4 = "";
/*     */         int n;
/* 275 */         for (n = 0; n < list.size(); n++) {
/*     */           
/* 277 */           if (n > 0) {
/*     */             
/* 279 */             str3 = str3 + ".";
/* 280 */             str4 = str4 + File.separatorChar;
/*     */           } 
/*     */           
/* 283 */           str3 = str3 + list.get(n);
/* 284 */           str4 = str4 + list.get(n);
/*     */         } 
/*     */         
/* 287 */         for (n = arrayList.size() - arrayList1.size() - 2; n >= 0; n--) {
/* 288 */           str4 = (String)arrayList.get(n) + File.separatorChar + str4;
/*     */         }
/* 290 */         for (n = list1.size(); n < arrayList1.size(); n++) {
/*     */           
/* 292 */           str4 = str4 + File.separatorChar + (String)arrayList1.get(n);
/* 293 */           str3 = str3 + '.' + (String)arrayList1.get(n);
/*     */         } 
/*     */         
/* 296 */         str4 = str4 + File.separatorChar + (String)arrayList.get(arrayList.size() - 1);
/*     */         
/* 298 */         stringBuffer.replace(i, j, str3);
/*     */         
/* 300 */         paramString = str4;
/* 301 */         String str5 = a.bt(paramString);
/*     */         
/* 303 */         if (!str2.equals(str5))
/*     */         {
/* 305 */           this.aD.put(str2, str5);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 310 */     File file2 = new File(this.h, paramString);
/*     */     
/* 312 */     if (file1.lastModified() < file2.lastModified()) {
/*     */       
/* 314 */       this.jo++;
/*     */       
/*     */       return;
/*     */     } 
/* 318 */     a(new File(this.h, paramString), this._repackager.a(stringBuffer));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void a(File paramFile, StringBuffer paramStringBuffer) throws IOException {
/* 324 */     paramFile.getParentFile().mkdirs();
/*     */     
/* 326 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile);
/* 327 */     OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
/* 328 */     StringReader stringReader = new StringReader(paramStringBuffer.toString());
/*     */     
/* 330 */     a(stringReader, outputStreamWriter);
/*     */     
/* 332 */     stringReader.close();
/* 333 */     outputStreamWriter.close();
/* 334 */     fileOutputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   StringBuffer a(File paramFile) throws IOException {
/* 340 */     FileInputStream fileInputStream = new FileInputStream(paramFile);
/* 341 */     InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
/* 342 */     StringWriter stringWriter = new StringWriter();
/*     */     
/* 344 */     a(inputStreamReader, stringWriter);
/*     */     
/* 346 */     stringWriter.close();
/* 347 */     inputStreamReader.close();
/* 348 */     fileInputStream.close();
/*     */     
/* 350 */     return stringWriter.getBuffer();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   StringBuffer a(InputStream paramInputStream) throws IOException {
/* 356 */     InputStreamReader inputStreamReader = new InputStreamReader(paramInputStream);
/* 357 */     StringWriter stringWriter = new StringWriter();
/*     */     
/* 359 */     a(inputStreamReader, stringWriter);
/*     */     
/* 361 */     stringWriter.close();
/* 362 */     inputStreamReader.close();
/*     */     
/* 364 */     return stringWriter.getBuffer();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copyFile(File paramFile1, File paramFile2) throws IOException {
/* 369 */     paramFile2.getParentFile().mkdirs();
/*     */     
/* 371 */     FileInputStream fileInputStream = new FileInputStream(paramFile1);
/* 372 */     FileOutputStream fileOutputStream = new FileOutputStream(paramFile2);
/*     */     
/* 374 */     copy(fileInputStream, fileOutputStream);
/*     */     
/* 376 */     fileOutputStream.close();
/* 377 */     fileInputStream.close();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void copy(InputStream paramInputStream, OutputStream paramOutputStream) throws IOException {
/* 382 */     byte[] arrayOfByte = new byte[16384];
/*     */ 
/*     */     
/*     */     while (true) {
/* 386 */       int i = paramInputStream.read(arrayOfByte, 0, arrayOfByte.length);
/*     */       
/* 388 */       if (i < 0) {
/*     */         break;
/*     */       }
/* 391 */       paramOutputStream.write(arrayOfByte, 0, i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void a(Reader paramReader, Writer paramWriter) throws IOException {
/* 397 */     char[] arrayOfChar = new char[16384];
/*     */ 
/*     */     
/*     */     while (true) {
/* 401 */       int i = paramReader.read(arrayOfChar, 0, arrayOfChar.length);
/*     */       
/* 403 */       if (i < 0) {
/*     */         break;
/*     */       }
/* 406 */       paramWriter.write(arrayOfChar, 0, i);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(ArrayList paramArrayList, File paramFile) throws IOException {
/* 412 */     if (!paramFile.isDirectory()) {
/*     */       
/* 414 */       paramArrayList.add(paramFile);
/*     */ 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 420 */     if (paramFile.getName().equals("build")) {
/*     */       return;
/*     */     }
/*     */     
/* 424 */     if (paramFile.getName().equals("CVS")) {
/*     */       return;
/*     */     }
/* 427 */     String[] arrayOfString = paramFile.list();
/*     */     
/* 429 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 430 */       a(paramArrayList, new File(paramFile, arrayOfString[b]));
/*     */     }
/*     */   }
/*     */   
/*     */   public void d(File paramFile) throws IOException {
/* 435 */     if (!paramFile.exists()) {
/*     */       return;
/*     */     }
/* 438 */     if (paramFile.isDirectory()) {
/*     */       
/* 440 */       String[] arrayOfString = paramFile.list();
/*     */       
/* 442 */       for (byte b = 0; b < arrayOfString.length; b++) {
/* 443 */         d(new File(paramFile, arrayOfString[b]));
/*     */       }
/*     */     } 
/* 446 */     paramFile.delete();
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\repackage\Repackage.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       1.1.3
 */