/*     */ package junit.runner;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.IOException;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringReader;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.Properties;
/*     */ import junit.b.b;
/*     */ import junit.b.i;
/*     */ import junit.b.l;
/*     */ import junit.b.n;
/*     */ import org.junit.c.l;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class a
/*     */   implements l
/*     */ {
/*     */   public static final String jH = "suite";
/*     */   private static Properties a;
/*  33 */   static int hT = 500;
/*     */   
/*     */   static boolean cb = true;
/*     */   
/*     */   boolean cc = true;
/*     */ 
/*     */   
/*     */   public synchronized void b(i parami) {
/*  41 */     be(parami.toString());
/*     */   }
/*     */   
/*     */   protected static void a(Properties paramProperties) {
/*  45 */     a = paramProperties;
/*     */   }
/*     */   
/*     */   protected static Properties a() {
/*  49 */     if (a == null) {
/*  50 */       a = new Properties();
/*  51 */       a.put("loading", "true");
/*  52 */       a.put("filterstack", "true");
/*  53 */       hj();
/*     */     } 
/*  55 */     return a;
/*     */   }
/*     */   
/*     */   public static void hh() throws IOException {
/*  59 */     FileOutputStream fileOutputStream = new FileOutputStream(a());
/*     */     try {
/*  61 */       a().store(fileOutputStream, "");
/*     */     } finally {
/*  63 */       fileOutputStream.close();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void k(String paramString1, String paramString2) {
/*  68 */     a().put(paramString1, paramString2);
/*     */   }
/*     */   
/*     */   public synchronized void a(i parami) {
/*  72 */     bf(parami.toString());
/*     */   }
/*     */   
/*     */   public synchronized void a(i parami, Throwable paramThrowable) {
/*  76 */     a(1, parami, paramThrowable);
/*     */   }
/*     */   
/*     */   public synchronized void a(i parami, b paramb) {
/*  80 */     a(2, parami, (Throwable)paramb);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void be(String paramString);
/*     */ 
/*     */ 
/*     */   
/*     */   public abstract void bf(String paramString);
/*     */ 
/*     */   
/*     */   public abstract void a(int paramInt, i parami, Throwable paramThrowable);
/*     */ 
/*     */   
/*     */   public i b(String paramString) {
/*  96 */     if (paramString.length() <= 0) {
/*  97 */       hi();
/*  98 */       return null;
/*     */     } 
/* 100 */     Class<?> clazz = null;
/*     */     try {
/* 102 */       clazz = a(paramString);
/* 103 */     } catch (ClassNotFoundException classNotFoundException) {
/* 104 */       String str = classNotFoundException.getMessage();
/* 105 */       if (str == null) {
/* 106 */         str = paramString;
/*     */       }
/* 108 */       bg("Class not found \"" + str + "\"");
/* 109 */       return null;
/* 110 */     } catch (Exception exception) {
/* 111 */       bg("Error: " + exception.toString());
/* 112 */       return null;
/*     */     } 
/* 114 */     Method method = null;
/*     */     try {
/* 116 */       method = clazz.getMethod("suite", new Class[0]);
/* 117 */     } catch (Exception exception) {
/*     */       
/* 119 */       hi();
/* 120 */       return (i)new n(clazz);
/*     */     } 
/* 122 */     if (!Modifier.isStatic(method.getModifiers())) {
/* 123 */       bg("Suite() method must be static");
/* 124 */       return null;
/*     */     } 
/* 126 */     i i = null;
/*     */     try {
/* 128 */       i = (i)method.invoke(null, new Object[0]);
/* 129 */       if (i == null) {
/* 130 */         return i;
/*     */       }
/* 132 */     } catch (InvocationTargetException invocationTargetException) {
/* 133 */       bg("Failed to invoke suite():" + invocationTargetException.getTargetException().toString());
/* 134 */       return null;
/* 135 */     } catch (IllegalAccessException illegalAccessException) {
/* 136 */       bg("Failed to invoke suite():" + illegalAccessException.toString());
/* 137 */       return null;
/*     */     } 
/*     */     
/* 140 */     hi();
/* 141 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String b(long paramLong) {
/* 148 */     return NumberFormat.getInstance().format(paramLong / 1000.0D);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected String c(String[] paramArrayOfString) {
/* 156 */     String str = null;
/* 157 */     for (byte b = 0; b < paramArrayOfString.length; b++) {
/* 158 */       if (paramArrayOfString[b].equals("-noloading")) {
/* 159 */         as(false);
/* 160 */       } else if (paramArrayOfString[b].equals("-nofilterstack")) {
/* 161 */         cb = false;
/* 162 */       } else if (paramArrayOfString[b].equals("-c")) {
/* 163 */         if (paramArrayOfString.length > b + 1) {
/* 164 */           str = aF(paramArrayOfString[b + 1]);
/*     */         } else {
/* 166 */           System.out.println("Missing Test class name");
/*     */         } 
/* 168 */         b++;
/*     */       } else {
/* 170 */         str = paramArrayOfString[b];
/*     */       } 
/*     */     } 
/* 173 */     return str;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void as(boolean paramBoolean) {
/* 180 */     this.cc = paramBoolean;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String aF(String paramString) {
/* 187 */     if (paramString.startsWith("Default package for")) {
/* 188 */       return paramString.substring(paramString.lastIndexOf(".") + 1);
/*     */     }
/* 190 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String aG(String paramString) {
/* 197 */     if (hT != -1 && paramString.length() > hT) {
/* 198 */       paramString = paramString.substring(0, hT) + "...";
/*     */     }
/* 200 */     return paramString;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected abstract void bg(String paramString);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Class<?> a(String paramString) throws ClassNotFoundException {
/* 213 */     return Class.forName(paramString);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void hi() {}
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean es() {
/* 223 */     return (aH("loading").equals("true") && this.cc);
/*     */   }
/*     */   
/*     */   private static File a() {
/* 227 */     String str = System.getProperty("user.home");
/* 228 */     return new File(str, "junit.properties");
/*     */   }
/*     */   
/*     */   private static void hj() {
/* 232 */     FileInputStream fileInputStream = null;
/*     */     
/* 234 */     try { fileInputStream = new FileInputStream(a());
/* 235 */       a(new Properties(a()));
/* 236 */       a().load(fileInputStream); }
/* 237 */     catch (IOException iOException)
/*     */     
/*     */     { 
/*     */       try {
/* 241 */         if (fileInputStream != null) {
/* 242 */           fileInputStream.close();
/*     */         }
/* 244 */       } catch (IOException iOException1) {} } catch (SecurityException securityException) { try { if (fileInputStream != null) fileInputStream.close();  } catch (IOException iOException) {} } finally { try { if (fileInputStream != null) fileInputStream.close();  } catch (IOException iOException) {} }
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public static String aH(String paramString) {
/* 250 */     return a().getProperty(paramString);
/*     */   }
/*     */   
/*     */   public static int d(String paramString, int paramInt) {
/* 254 */     String str = aH(paramString);
/* 255 */     int i = paramInt;
/* 256 */     if (str == null) {
/* 257 */       return i;
/*     */     }
/*     */     try {
/* 260 */       i = Integer.parseInt(str);
/* 261 */     } catch (NumberFormatException numberFormatException) {}
/*     */     
/* 263 */     return i;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String b(Throwable paramThrowable) {
/* 270 */     return aI(l.c(paramThrowable));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String aI(String paramString) {
/* 277 */     if (et()) {
/* 278 */       return paramString;
/*     */     }
/*     */     
/* 281 */     StringWriter stringWriter = new StringWriter();
/* 282 */     PrintWriter printWriter = new PrintWriter(stringWriter);
/* 283 */     StringReader stringReader = new StringReader(paramString);
/* 284 */     BufferedReader bufferedReader = new BufferedReader(stringReader);
/*     */     
/*     */     try {
/*     */       String str;
/* 288 */       while ((str = bufferedReader.readLine()) != null) {
/* 289 */         if (!E(str)) {
/* 290 */           printWriter.println(str);
/*     */         }
/*     */       } 
/* 293 */     } catch (Exception exception) {
/* 294 */       return paramString;
/*     */     } 
/* 296 */     return stringWriter.toString();
/*     */   }
/*     */   
/*     */   protected static boolean et() {
/* 300 */     return (!aH("filterstack").equals("true") || !cb);
/*     */   }
/*     */   
/*     */   static boolean E(String paramString) {
/* 304 */     String[] arrayOfString = { "junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke(" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 314 */     for (byte b = 0; b < arrayOfString.length; b++) {
/* 315 */       if (paramString.indexOf(arrayOfString[b]) > 0) {
/* 316 */         return true;
/*     */       }
/*     */     } 
/* 319 */     return false;
/*     */   }
/*     */   
/*     */   static {
/* 323 */     hT = d("maxmessage", hT);
/*     */   }
/*     */ }


/* Location:              C:\Arremate\Arremate.jar!\junit\runner\a.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */